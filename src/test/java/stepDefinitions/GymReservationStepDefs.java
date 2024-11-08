package stepDefinitions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.GymReservationPages;
import utils.Driver;

public class GymReservationStepDefs {

    GymReservationPages gymReservationPages = new GymReservationPages();

    @Given("click on the phone number field")
    public void clickOnThePhoneNumberField() {
        // Telefon numarası alanına tıklama
        gymReservationPages.clickPhoneTextBox.click();
    }

    @When("please enter the phone number {string}")
    public void pleaseEnterThePhoneNumber(String phoneNumber) {
        // Telefon numarasını girme
        gymReservationPages.phoneTextboxEdit.sendKeys(phoneNumber);
    }

    @When("click on the next button")
    public void clickOnTheNextButton() {
        // İleri butonuna tıklama
        gymReservationPages.forwardButton.click();
    }

    @When("click on the password field")
    public void clickOnThePasswordField() {
        // Şifre alanına tıklama
        gymReservationPages.passwordButton.click();
    }

    @When("enter the password {string}")
    public void enterThePassword(String password) {
        // Şifreyi girme
        gymReservationPages.passwordButonSend.sendKeys(password);
    }

    @Then("click on the login button")
    public void clickOnTheLoginButton() throws InterruptedException {
        // Giriş butonuna tıklama
        gymReservationPages.loginButton.click();
        Thread.sleep(1000);
    }

    @Given("click on the requests")
    public void clickOnTheRequests() throws InterruptedException {
        // Talepler sekmesine tıklama
        gymReservationPages.clickOnRequests.click();
    }

    @When("click to create a new request")
    public void clickToCreateANewRequest() {
        // Yeni talep oluştur butonuna tıklama
        gymReservationPages.createNewRequest.click();
    }

    @When("click here to book a gym")
    public void clickHereToBookAGym() {
        // Spor salonu rezervasyonu için tıklama
        gymReservationPages.gymReservation.click();
    }

    @When("select a date")
    public void selectADate() {
        // Tarih seçme
        gymReservationPages.chooseDate.click();
    }

    @When("select the booking time")
    public void selectTheBookingTime() {
        // Rezervasyon zamanını seçme
        gymReservationPages.selectReservationTime.click();
    }

    @When("click on the create reservation button")
    public void clickOnTheCreateReservationButton() {
        // Rezervasyon oluştur butonuna tıklama
        gymReservationPages.createReservationButton.click();
    }

    @When("booking confirmation click")
    public void bookingConfirmationClick() {
        // Rezervasyon onayı için tıklama
        gymReservationPages.bookingConfirmation.click();
    }

    @When("close the confirmation button")
    public void closeTheConfirmationButton() throws InterruptedException {
        // Onay kapatma butonuna tıklama
        gymReservationPages.confirmCloseButton.click();
        Thread.sleep(3000);
    }

    @Then("go back to the homepage")
    public void goBackToTheHomepage() {
        // Ana sayfaya geri dönme
        gymReservationPages.returnToTheHomePage.click();
    }
}
