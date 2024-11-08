package stepDefinitions;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Driver;

public class Hooks {

    private AppiumDriverLocalService appiumServer;

    @Before
    public void setUp() {
        // Appium server'ı başlatır
        appiumServer = AppiumDriverLocalService.buildDefaultService();
        appiumServer.start();
    }

    @After
    public void tearDown(Scenario scenario) {
        // Test başarısız olursa ekran görüntüsü alır ve senaryoya ekler
        if (scenario.isFailed()) {
            if (Driver.getAppiumDriver() != null) {
                final byte[] screenshot = ((TakesScreenshot) Driver.getAppiumDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot");
            }
        }

        // Appium server'ı durdurur
        if (appiumServer != null && appiumServer.isRunning()) {
            appiumServer.stop();
        }
    }
}
