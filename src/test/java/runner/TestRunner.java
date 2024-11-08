package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// Cucumber testlerinin çalıştırılması için gerekli olan @RunWith ve @CucumberOptions ayarları yapılır.
@RunWith(Cucumber.class)
@CucumberOptions(
        // Çalıştırma raporları ve çıktı formatları için eklentiler
        plugin = {
                "pretty", // Konsolda daha okunabilir bir çıktı sağlar
                "json:target/cucumber.json", // JSON formatında rapor oluşturur, otomasyon sonuçlarını analiz etmek için kullanılabilir
                "utils.formatter.PrettyReports" // Özel olarak oluşturulmuş PrettyReports sınıfını eklenti olarak kullanır
        },
        features = "src/test/resources/features", // Feature dosyalarının yolu belirtilir
        glue = "stepDefinitions", // Step definition dosyalarının yolu belirtilir
        tags = "@AssignmentForm", // Belirli bir senaryo veya senaryo grubunu çalıştırmak için etiket eklenir
        dryRun = false // Kodların senaryolarla uyumunu kontrol etmek için, 'false' olarak ayarlandığında testleri çalıştırır
)
public class TestRunner {
        // Boş bırakılmıştır çünkü tüm ayarlamalar Cucumber tarafından yapılmaktadır
}
