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

public class PrettyReports implements EventListener {
    private final File outputDir;
    private final File jsonFile;
    private final EventListener delegateJsonEventListener;

    public PrettyReports() throws Exception {
        this(Paths.get("target", "cucumber").toFile());
    }

    public PrettyReports(final File outputDir) throws Exception {
        this(outputDir, createTempFileDeletedOnExit());
    }

    protected PrettyReports(final File outputDir, final File jsonFile) throws Exception {
        this(outputDir, jsonFile, createJsonEventListener(jsonFile));
    }

    protected PrettyReports(final File outputDir, final File jsonFile, final EventListener delegateJsonEventListener) {
        this.outputDir = outputDir;
        this.jsonFile = jsonFile;
        this.delegateJsonEventListener = delegateJsonEventListener;
    }

    protected static File createTempFileDeletedOnExit() throws IOException {
        Path tempFile = Files.createTempFile("cucumber", ".json");
        tempFile.toFile().deleteOnExit();
        return tempFile.toFile();
    }

    protected static EventListener createJsonEventListener(final File jsonFile) {
        try {
            final OutputStream outputStream = new FileOutputStream(jsonFile);
            return new io.cucumber.core.plugin.JsonFormatter(outputStream);
        } catch (final FileNotFoundException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public void setEventPublisher(final EventPublisher publisher) {
        this.delegateJsonEventListener.setEventPublisher(publisher);
        publisher.registerHandlerFor(TestRunFinished.class, generatePrettyReport(this.jsonFile));
    }

    protected EventHandler<TestRunFinished> generatePrettyReport(final File jsonFile) {
        return event -> generatePrettyReport(jsonFile, this.outputDir);
    }

    protected static void generatePrettyReport(final File jsonFile, final File outputDir) {
        final Configuration configuration = new Configuration(outputDir, "MobilTurkuvazcaAppAuto Tests");
        new ReportBuilder(Collections.singletonList(jsonFile.getAbsolutePath()), configuration).generateReports();
    }
}
