package utils.formatter;

import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventHandler;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunFinished;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

/**
 * PrettyReports sınıfı, Cucumber test raporlarını güzel bir biçimde oluşturmak için kullanılan bir event listener sınıfıdır.
 * JSON formatında oluşturulan test raporunu alır ve MasterThought tarafından desteklenen HTML raporlarına dönüştürür.
 */
public class PrettyReports implements EventListener {
    private final File outputDir; // Raporun kaydedileceği dizin
    private final File jsonFile; // JSON formatında test raporunu tutacak dosya
    private final EventListener delegateJsonEventListener; // JSON event listener'ı

    /**
     * Default constructor. Varsayılan olarak "target/cucumber" dizini kullanılır.
     */
    public PrettyReports() throws Exception {
        this(Paths.get("target", "cucumber").toFile());
    }

    /**
     * Belirtilen output dizini ile PrettyReports nesnesi oluşturur.
     *
     * @param outputDir Raporun kaydedileceği dizin
     */
    public PrettyReports(final File outputDir) throws Exception {
        this(outputDir, createTempFileDeletedOnExit());
    }

    /**
     * PrettyReports nesnesi oluşturur. JSON rapor dosyasını geçici olarak oluşturur.
     *
     * @param outputDir Raporun kaydedileceği dizin
     * @param jsonFile JSON formatında test raporunu tutacak dosya
     */
    protected PrettyReports(final File outputDir, final File jsonFile) throws Exception {
        this(outputDir, jsonFile, createJsonEventListener(jsonFile));
    }

    /**
     * PrettyReports nesnesi oluşturur ve belirtilen delegate JSON event listener'ı kullanır.
     *
     * @param outputDir Raporun kaydedileceği dizin
     * @param jsonFile JSON formatında test raporunu tutacak dosya
     * @param delegateJsonEventListener JSON event listener'ı
     */
    protected PrettyReports(final File outputDir, final File jsonFile, final EventListener delegateJsonEventListener) {
        this.outputDir = outputDir;
        this.jsonFile = jsonFile;
        this.delegateJsonEventListener = delegateJsonEventListener;
    }

    /**
     * Geçici bir dosya oluşturur ve bu dosyayı program sonlandırıldığında silinecek şekilde ayarlar.
     *
     * @return Geçici dosya
     * @throws IOException Dosya oluşturulurken oluşabilecek hata
     */
    protected static File createTempFileDeletedOnExit() throws IOException {
        Path tempFile = Files.createTempFile("cucumber", ".json"); // Geçici JSON dosyası oluşturuluyor
        tempFile.toFile().deleteOnExit(); // Dosya sonlandırıldığında silinecek şekilde ayarlanıyor
        return tempFile.toFile();
    }

    /**
     * JSON event listener'ı oluşturur ve belirtilen dosyaya yazmak için ayarlar.
     *
     * @param jsonFile JSON verisinin kaydedileceği dosya
     * @return JSON event listener'ı
     * @throws UncheckedIOException Dosya bulunamadığında oluşabilecek hata
     */
    protected static EventListener createJsonEventListener(final File jsonFile) {
        try {
            final OutputStream outputStream = new FileOutputStream(jsonFile); // JSON verisini yazmak için output stream oluşturuluyor
            return new io.cucumber.core.plugin.JsonFormatter(outputStream); // JSON formatında event listener oluşturuluyor
        } catch (final FileNotFoundException e) {
            throw new UncheckedIOException(e); // Dosya bulunamadığında hata fırlatılır
        }
    }

    /**
     * EventPublisher nesnesine event handler'ları ekler.
     * JSON event listener'ını ve rapor oluşturma işlemini ayarlar.
     *
     * @param publisher EventPublisher nesnesi
     */
    @Override
    public void setEventPublisher(final EventPublisher publisher) {
        this.delegateJsonEventListener.setEventPublisher(publisher); // JSON event listener'ını publisher'a bağlar
        publisher.registerHandlerFor(TestRunFinished.class, generatePrettyReport(this.jsonFile)); // Test tamamlandığında raporu oluşturur
    }

    /**
     * Test tamamlandığında Pretty raporunu oluşturacak event handler'ı döndürür.
     *
     * @param jsonFile JSON dosyasını kullanarak rapor oluşturulacak dosya
     * @return Event handler
     */
    protected EventHandler<TestRunFinished> generatePrettyReport(final File jsonFile) {
        return event -> generatePrettyReport(jsonFile, this.outputDir); // Test tamamlandığında rapor oluşturuluyor
    }

    /**
     * JSON dosyasını kullanarak HTML raporunu oluşturur.
     *
     * @param jsonFile JSON rapor dosyası
     * @param outputDir Raporun kaydedileceği dizin
     */
    protected static void generatePrettyReport(final File jsonFile, final File outputDir) {
        final Configuration configuration = new Configuration(outputDir, "MobilTurkuvazcaAppAuto Tests"); // Raporun başlığı
        new ReportBuilder(Collections.singletonList(jsonFile.getAbsolutePath()), configuration).generateReports(); // HTML raporu oluşturur
    }
}
