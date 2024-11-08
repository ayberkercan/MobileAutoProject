package utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReusableMethods {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;

    public ReusableMethods() {
        this.driver = Driver.getAppiumDriver();
        this.wait = new WebDriverWait(driver, 15); // 15 saniyelik bekleme süresi
    }

    // Belirli bir elemente tıklamak için reusable method
    public void clickElement(By by) {
        try {
            MobileElement element = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(by));
            element.click();
        } catch (NoSuchElementException e) {
            System.out.println("Element bulunamadı: " + by);
        }
    }

    // Sayfa kaydırma ve görünür hale getirme yöntemi
    public void scrollAndClick(String visibleText) {
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".scrollIntoView(new UiSelector().textContains(\"" + visibleText + "\").instance(0))"
        ).click();
    }

    // Bir elementin görünür olup olmadığını kontrol etme
    public boolean isElementVisible(By by) {
        try {
            return ((MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by))).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Bir elementin metnini almak için reusable method
    public String getText(By by) {
        try {
            MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return element.getText();
        } catch (NoSuchElementException e) {
            System.out.println("Element bulunamadı: " + by);
            return null;
        }
    }

    // Ekrana belirli bir süre dokunma (long press) yöntemi
    public void longPressElement(By by, int durationInSeconds) {
        MobileElement element = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(by));
        new TouchAction<>(driver)
                .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element))
                        .withDuration(Duration.ofSeconds(durationInSeconds)))
                .release()
                .perform();
    }
}
