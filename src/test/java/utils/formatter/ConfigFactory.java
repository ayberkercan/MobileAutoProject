package utils.formatter;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.reducers.ReducingMethod;
import net.masterthought.cucumber.sorting.SortingMethod;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Map.Entry;
import java.util.Properties;

import static java.lang.Boolean.parseBoolean;
import static java.util.Optional.ofNullable;

public class ConfigFactory {

    // Varsayılan dosya adı
    private static final String DEFAULT_FILENAME = "cucumber-reporting.properties";

    // Grafiklerden hariç tutulacak etiketler için desen
    private static final String TAGS_TO_EXCLUDE_FROM_CHART_PATTERN = "^tagsToExcludeFromChart\\.\\d+$";

    // Sunum modu ile ilgili anahtar
    private static final String PRESENTATION_MODE_PREFIX = "presentationMode.";

    // Azaltma yöntemi ile ilgili anahtar
    private static final String REDUCING_METHOD_PREFIX = "reducingMethod.";

    // Sınıflandırmalar ile ilgili anahtar
    private static final String CLASSIFICATIONS_PREFIX = "classifications.";

    // Yapılandırma dosyasının adı
    public static final String CONFIG_FILE_PROPERTY = "cucumber.reporting.config.file";

    /**
     * Yapılandırma nesnesi döndürür.
     *
     * @param outputDir Çıktı dizini
     * @return Yapılandırma nesnesi
     */
    public static Configuration getConfiguration(final File outputDir) {
        // Özellik dosyasını yükle
        final Properties properties = loadProperties();

        // Proje adı
        final String projectName = properties.getProperty("projectName", "AtouMod BDD Automations Tests Report");

        // Yapılandırmayı oluştur
        final Configuration configuration = new Configuration(outputDir, projectName);

        // Yapılandırmayı özelleştir
        configureBuildNumber(configuration, properties);
        configureSortingMethod(configuration, properties);
        configureTagsToExcludeFromChart(configuration, properties);
        configureTrendsStatsFile(configuration, properties);
        configureRepeatableConfigurationKeys(configuration, properties);

        return configuration;
    }

    /**
     * Yapı numarasını yapılandırmaya ekler.
     *
     * @param configuration Yapılandırma nesnesi
     * @param properties Özellikler
     */
    protected static void configureBuildNumber(final Configuration configuration, final Properties properties) {
        configuration.setBuildNumber(properties.getProperty("buildNumber"));
    }

    /**
     * Sıralama yöntemini yapılandırmaya ekler.
     *
     * @param configuration Yapılandırma nesnesi
     * @param properties Özellikler
     */
    protected static void configureSortingMethod(final Configuration configuration, final Properties properties) {
        final String sortingMethod = properties.getProperty("sortingMethod");
        if (StringUtils.isNotEmpty(sortingMethod)) {
            configuration.setSortingMethod(Enum.valueOf(SortingMethod.class, sortingMethod));
        }
    }

    /**
     * Grafikten hariç tutulacak etiketleri yapılandırmaya ekler.
     *
     * @param configuration Yapılandırma nesnesi
     * @param properties Özellikler
     */
    protected static void configureTagsToExcludeFromChart(final Configuration configuration, final Properties properties) {
        final String[] tagsToExclude = getTagsToExcludeFromChart(properties);
        configuration.setTagsToExcludeFromChart(tagsToExclude);
    }

    /**
     * Grafikten hariç tutulacak etiketleri özelliğiyle yükler.
     *
     * @param properties Özellikler
     * @return Hariç tutulacak etiketler
     */
    protected static String[] getTagsToExcludeFromChart(final Properties properties) {
        return properties.entrySet().stream()
                .filter(entry -> ((String)entry.getKey()).matches(TAGS_TO_EXCLUDE_FROM_CHART_PATTERN))
                .map(Entry::getValue)
                .toArray(String[]::new);
    }

    /**
     * Trend istatistik dosyasını yapılandırmaya ekler.
     *
     * @param configuration Yapılandırma nesnesi
     * @param properties Özellikler
     */
    protected static void configureTrendsStatsFile(final Configuration configuration, final Properties properties) {
        String trendsStatsFile = properties.getProperty("trendsStatsFile");
        if (StringUtils.isNotEmpty(trendsStatsFile)) {
            configuration.setTrendsStatsFile(new File(trendsStatsFile));
        }
    }

    /**
     * Tekrarlanabilir yapılandırma anahtarlarını özelliğe göre ayarlar.
     *
     * @param configuration Yapılandırma nesnesi
     * @param properties Özellikler
     */
    protected static void configureRepeatableConfigurationKeys(final Configuration configuration, final Properties properties) {
        final Enumeration<Object> keys = properties.keys();
        while (keys.hasMoreElements()) {
            final String qualifiedKey = (String)keys.nextElement();
            if (qualifiedKey.startsWith(PRESENTATION_MODE_PREFIX)) {
                configurePresentationMode(qualifiedKey, configuration, properties);
            } else if (qualifiedKey.startsWith(REDUCING_METHOD_PREFIX)) {
                configureReducingMethod(qualifiedKey, configuration, properties);
            } else if (qualifiedKey.startsWith(CLASSIFICATIONS_PREFIX)) {
                configureClassifications(qualifiedKey, configuration, properties);
            }
        }
    }

    /**
     * Sunum modunu yapılandırmaya ekler.
     *
     * @param qualifiedKey Anahtar
     * @param configuration Yapılandırma nesnesi
     * @param properties Özellikler
     */
    protected static void configurePresentationMode(final String qualifiedKey, final Configuration configuration, final Properties properties) {
        if (parseBoolean(properties.getProperty(qualifiedKey))) {
            final String presentationModeName = qualifiedKey.substring(PRESENTATION_MODE_PREFIX.length());
            final PresentationMode presentationMode = Enum.valueOf(PresentationMode.class, presentationModeName);
            configuration.addPresentationModes(presentationMode);
        }
    }

    /**
     * Azaltma yöntemini yapılandırmaya ekler.
     *
     * @param qualifiedKey Anahtar
     * @param configuration Yapılandırma nesnesi
     * @param properties Özellikler
     */
    protected static void configureReducingMethod(final String qualifiedKey, final Configuration configuration, final Properties properties) {
        if (parseBoolean(properties.getProperty(qualifiedKey))) {
            final String reducingMethodName = qualifiedKey.substring(REDUCING_METHOD_PREFIX.length());
            final ReducingMethod reducingMethod = Enum.valueOf(ReducingMethod.class, reducingMethodName);
            configuration.addReducingMethod(reducingMethod);
        }
    }

    /**
     * Sınıflandırmaları yapılandırmaya ekler.
     *
     * @param qualifiedKey Anahtar
     * @param configuration Yapılandırma nesnesi
     * @param properties Özellikler
     */
    protected static void configureClassifications(final String qualifiedKey, final Configuration configuration, final Properties properties) {
        final String key = qualifiedKey.substring(CLASSIFICATIONS_PREFIX.length());
        configuration.addClassifications(key, properties.getProperty(qualifiedKey));
    }

    /**
     * Özellik dosyasını yükler.
     *
     * @return Yüklenmiş özellikler
     */
    protected static Properties loadProperties() {
        final Properties properties = new Properties();
        final InputStream stream = getPropertiesStream();
        if (stream != null) {
            try {
                properties.load(new InputStreamReader(stream, "UTF-8"));
            } catch (final IOException e) {
                throw new UncheckedIOException(e);
            }
        }
        return properties;
    }

    /**
     * Özellik dosyasını almak için input stream döndürür.
     *
     * @return Input stream
     */
    protected static InputStream getPropertiesStream() {
        final String filename = getPropertiesFilename();
        final File propertiesFile = ofNullable(Paths.get(filename).toFile())
                .filter(File::exists)
                .filter(File::isFile)
                .filter(File::canRead)
                .orElse(null);
        if (propertiesFile == null && !filename.equals(DEFAULT_FILENAME)) {
            throw new UncheckedIOException(
                    new FileNotFoundException("Cucumber reporting properties file " + filename + " was not found"));
        } else if (propertiesFile != null) {
            try {
                return new FileInputStream(propertiesFile);
            } catch (final FileNotFoundException e) {
                throw new UncheckedIOException(e);
            }
        }
        return null;
    }

    /**
     * Özellik dosyasının adını döndürür.
     *
     * @return Özellik dosyasının adı
     */
    protected static String getPropertiesFilename() {
        return System.getProperty(CONFIG_FILE_PROPERTY, DEFAULT_FILENAME);
    }

}
