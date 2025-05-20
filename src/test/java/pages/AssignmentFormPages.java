package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utils.Driver;

import java.time.Duration;

public class AssignmentFormPages {

    private AndroidDriver<MobileElement> driver;
    private Wait<AndroidDriver<MobileElement>> wait;

    public AssignmentFormPages() {
        this.driver = (AndroidDriver<MobileElement>) Driver.getAppiumDriver();
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);

        // ✅ Hata düzeltilmiş: 5000 -> Duration.ofMillis(5000)
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofMillis(5000)), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Talepler']")
    public WebElement clickRequestsForAssignment;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Yeni Talep Oluştur']")
    public WebElement createNewRequest;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Görevlendirme Talep Formu']")
    public WebElement requestForTaskForm;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Görev Ekle']")
    public WebElement addTaskButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Seçiniz']")
    public WebElement clickTaskType;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Canlı Yayın']/android.view.ViewGroup/android.view.ViewGroup")
    public WebElement selectTheTaskType;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Yazınız']")
    public WebElement subjectTask;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='20 Mayıs 2025'])[1]")
    public WebElement clickOnTheStartDate;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='21 Mayıs 2025']")
    public WebElement enterStartTime;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    public WebElement okButton1;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='SS:dd'])[1]")
    public WebElement clickOnTheStartClock;

    @AndroidFindBy(xpath = "//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='17']")
    public WebElement chooseOclock;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    public WebElement okButton2;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Gün/Ay/Yıl']")
    public WebElement clickOnTheEndDate;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='22 Mayıs 2025']")
    public WebElement chooseEndDate;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    public WebElement okButton3;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='SS:dd']")
    public WebElement clickEndOclock;

    @AndroidFindBy(xpath = "//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='9']")
    public WebElement chooseEndOclock;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    public WebElement okButton4;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Yazınız']")
    public WebElement reasonforworkinghours;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Kaydet']")
    public WebElement saveButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Ek Onaycı Seçiniz\"]")
    public WebElement octConfirmator;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"ABDULHALİK ÇİMEN, GENEL MÜDÜR\"]/android.view.ViewGroup/android.view.ViewGroup")
    public WebElement chooseOctConfirmator;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Kaydet\"]")
    public WebElement submitButton;
   @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"Gönder\"]")
   public WebElement sendButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Kapat']")
    public WebElement closeInfoButton;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Görevlendirme Formu'])[1]")
    public WebElement ongoingAssignmentRequest;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Anasayfa']")
    public WebElement goToTheHomePageAssignmentRequest;

    // ✅ Sayfayı kaydırarak 'saveButton' elementine ulaşma ve tıklama işlemi
    public void scrollAndClickSaveButton() {
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Kaydet\"))"
        ));
        saveButton.click();
    }
}
