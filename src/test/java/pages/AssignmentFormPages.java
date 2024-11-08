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
import java.lang.Thread;

import java.time.Duration;

public class AssignmentFormPages {

    private AndroidDriver<MobileElement> driver;  // Android sürücüsünü tanımlıyoruz.
    private Wait<AndroidDriver<MobileElement>> wait;  // Bekleme işlemi için FluentWait nesnesi oluşturuyoruz.

    // Constructor: Android sürücüsünü ve bekleme ayarlarını başlatıyoruz.
    public AssignmentFormPages() {
        this.driver = (AndroidDriver<MobileElement>) Driver.getAppiumDriver();
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))  // Maksimum 30 saniye bekle
                .pollingEvery(Duration.ofMillis(500))  // Her 500 milisaniyede bir kontrol et
                .ignoring(Exception.class);  // Herhangi bir exception durumunda devam et
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(25)), this);  // Sayfa elementlerini başlat
    }

    // Element tanımları (Her bir element, Android'in XPath ile tanımlanmış bir bileşeni ifade eder)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Talepler']")
    public WebElement clickRequestsForAssignment;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Yeni Talep Oluştur']")
    public WebElement createNewRequest;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Görevlendirme Formu']")
    public WebElement requestForTaskForm;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Görev Ekle']")
    public WebElement addTaskButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Seçiniz']")
    public WebElement clickTaskType;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Canlı Yayın']/android.view.ViewGroup/android.view.ViewGroup")
    public WebElement selectTheTaskType;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Yazınız']")
    public WebElement subjectTask;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"Gün/Ay/Yıl\"])[1]")
    public WebElement clickOnTheStartDate;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"24 Eylül 2024\"]")
    public WebElement enterStartTime;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
    public WebElement okButton1;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='SS:dd'])[1]")
    public WebElement clickOnTheStartClock;

    @AndroidFindBy(xpath = "//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='9']")
    public WebElement chooseOclock;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    public WebElement okButton2;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Gün/Ay/Yıl']")
    public WebElement clickOnTheEndDate;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"25 Eylül 2024\"]")
    public WebElement chooseEndDate;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
    public WebElement okButton3;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SS:dd']")
    public WebElement clickEndOclock;

    @AndroidFindBy(xpath = "//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='9']")
    public WebElement chooseEndOclock;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    public WebElement okButton4;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Kaydet']")
    public WebElement saveButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Seçiniz']")
    public WebElement octConfirmator;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ABDULHALİK ÇİMEN']/android.view.ViewGroup/android.view.ViewGroup")
    public WebElement chooseOctConfirmator;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Gönder']")
    public WebElement submitButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Kapat']")
    public WebElement closeInfoButton;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Görevlendirme Formu\"])[1]")
    public WebElement ongoingAssignmentRequest;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Anasayfa']")
    public WebElement goToTheHomePageAssignmentRequest;

    // Sayfayı kaydırarak 'saveButton' elementine ulaşma ve tıklama işlemi
    public void scrollAndClickSaveButton() {
        // Elementi bulana kadar sayfayı kaydırıyoruz
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(jf\"Kaydet\"));"
        ));

        // Elemente ulaştıktan sonra tıklama işlemi
        saveButton.click();
    }
}
