package utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    // AndroidDriver nesnesini saklamak için
    private static AndroidDriver<MobileElement> appiumDriver;

    /**
     * AppiumDriver'ı başlatır ve döndürür. Eğer zaten başlatılmışsa, mevcut driver'ı döndürür.
     * @return AndroidDriver<MobileElement>
     */
    public static AndroidDriver<MobileElement> getAppiumDriver() {

        URL appiumServerURL = null;

        try {
            // Appium server URL'si başlatılıyor
            appiumServerURL = new URL("http://0.0.0.0:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // appiumDriver nesnesi yoksa yeni bir AndroidDriver başlat
        if (appiumDriver == null) {
            // DesiredCapabilities ile gerekli özellikler tanımlanıyor
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigReader.getProperty("automationName"));
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.getProperty("platformName"));
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigReader.getProperty("platformVersion"));
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigReader.getProperty("deviceName"));
            caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, ConfigReader.getProperty("appPackage"));
            caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ConfigReader.getProperty("appActivity"));

            // Yalnızca Android için driver başlatılıyor
            if (ConfigReader.getProperty("platformName").equals("Android")) {
                appiumDriver = new AndroidDriver<>(appiumServerURL, caps);
                appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else {
                throw new UnsupportedOperationException("Invalid Platform Name " + ConfigReader.getProperty("platformName"));
            }
        }

        return appiumDriver;
    }

    /**
     * AppiumDriver'ı kapatır ve null olarak ayarlar.
     */
    public static void quitAppiumDriver() {
        if (appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        }
    }
}
