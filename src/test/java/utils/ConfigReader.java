package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        String path = "configuration.properties";
        try {
            // configuration.properties dosyasını dosya giriş akışı ile açıyoruz
            FileInputStream fileInputStream = new FileInputStream(path);
            // Properties nesnesini oluşturup yükleme yapıyoruz
            properties = new Properties();
            properties.load(fileInputStream);
            // Dosya giriş akışını kapatıyoruz
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            // Dosya bulunamazsa hata ayıklama çıktısını verir
            e.printStackTrace();
        } catch (IOException e) {
            // Giriş/Çıkış hatası durumunda hata ayıklama çıktısını verir
            e.printStackTrace();
        }
    }

    /**
     * Verilen anahtar (key) ile properties dosyasındaki değeri döndürür.
     * @param key istenen property anahtarı
     * @return property değeri
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
