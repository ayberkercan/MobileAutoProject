package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.time.Duration;

public class GymReservationPages {

    // Constructor: GymReservationPages sınıfının elementlerini başlatır ve sürücüyü ayarlar
    public GymReservationPages() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver(), Duration.ofSeconds(25)), this);
    }

    // Telefon Numarası metin kutusuna tıklama
    @AndroidFindBy(xpath="//android.widget.TextView[@text=\"Telefon Numarası\"]")
    public WebElement clickPhoneTextBox;

    // Telefon numarasını girmek için düzenleme kutusu
    @AndroidFindBy(xpath="//android.widget.EditText[@text=\"(5xx) xxx xx xx\"]")
    public WebElement phoneTextboxEdit;

    // İleri butonuna tıklama
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"İleri\"]")
    public WebElement forwardButton;

    // Şifre metin kutusuna tıklama
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Şifre\"]")
    public WebElement passwordButton;

    // Şifre girişi için düzenleme kutusu
    @AndroidFindBy(xpath = "//android.widget.EditText")
    public WebElement passwordButonSend;

    // Giriş butonuna tıklama
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Giriş\"]")
    public WebElement loginButton;

    // Talepler menüsüne tıklama
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Talepler\"]")
    public WebElement clickOnRequests;

    // Yeni Talep Oluştur seçeneğine tıklama
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Yeni Talep Oluştur\"]")
    public WebElement createNewRequest;

    // Spor Salonu Rezervasyonu seçeneğine tıklama
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Spor Salonu Rezervasyonu\"]")
    public WebElement gymReservation;

    // Rezervasyon tarihi seçimi (örneğin, 15'i seçme)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"15\"]")
    public WebElement chooseDate;

    // Rezervasyon saati seçimi (17:30-19:00 aralığı)
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"17:30-19:00,  20 \"]/android.view.ViewGroup[1]/android.view.ViewGroup")
    public WebElement selectReservationTime;

    // Rezervasyonu Oluştur butonuna tıklama
    @AndroidFindBy(xpath ="//android.widget.TextView[@text=\"Rezervasyonu Oluştur\"]")
    public WebElement createReservationButton;

    // Rezervasyon onayı için Evet butonuna tıklama
    @AndroidFindBy(xpath ="//android.widget.TextView[@text=\"Evet\"]")
    public WebElement bookingConfirmation;

    // Rezervasyon onayı sonrasında Kapat butonuna tıklama
    @AndroidFindBy(xpath ="//android.widget.TextView[@text=\"Kapat\"]")
    public WebElement confirmCloseButton;

    // Anasayfaya dönmek için butona tıklama
    @AndroidFindBy(xpath ="//android.view.View[@content-desc=\"Anasayfa\"]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView[3]")
    public WebElement returnToTheHomePage;

}
