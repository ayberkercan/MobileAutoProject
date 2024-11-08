package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AssignmentFormPages;

// AssignmentFormStepDefs sınıfı, ilgili senaryolarda kullanılacak adımları tanımlar
public class AssignmentFormStepDefs {
    AssignmentFormPages assignmentFormPages = new AssignmentFormPages();

    @When("click on the requests for assignment")
    public void clickOnTheRequestsForAssignment() {
        // Görev taleplerine tıklama
        assignmentFormPages.clickRequestsForAssignment.click();
    }

    @When("click on the create new request button")
    public void clickOnTheCreateNewRequestButton() {
        // Yeni talep oluştur butonuna tıklama
        assignmentFormPages.createNewRequest.click();
    }

    @When("click on the request for the assignment form")
    public void clickOnTheRequestForTheAssignmentForm() {
        // Görev formu talebine tıklama
        assignmentFormPages.requestForTaskForm.click();
    }

    @When("click on the add task button Oct.")
    public void clickOnTheAddTaskButtonOct() {
        // Ekim ayı için görev ekle butonuna tıklama
        assignmentFormPages.addTaskButton.click();
    }

    @When("click on the assignment type field")
    public void clickOnTheAssignmentTypeField() {
        // Görev türü alanına tıklama
        assignmentFormPages.clickTaskType.click();
    }

    @When("select the type of assignment")
    public void selectTheTypeOfAssignment() {
        // Görev türünü seçme
        assignmentFormPages.selectTheTaskType.click();
    }

    @When("write about the assignment topic {string}")
    public void writeAboutTheAssignmentTopic(String subjectOfTheTask) {
        // Görev konusu hakkında bilgi yazma
        assignmentFormPages.subjectTask.sendKeys(subjectOfTheTask);
    }

    @When("click on the start date")
    public void clickOnTheStartDate() {
        // Başlangıç tarihine tıklama
        assignmentFormPages.clickOnTheStartDate.click();
    }

    @When("enter the start time")
    public void enterTheStartTime() {
        // Başlangıç zamanını girme
        assignmentFormPages.enterStartTime.click();
    }

    @When("click on the calendarOkButtonOne")
    public void clickOnTheCalendarOkButtonOne() {
        // Takvimdeki ilk onay butonuna tıklama
        assignmentFormPages.okButton1.click();
    }

    @When("click on the start time")
    public void clickOnTheStartTime() {
        // Başlangıç saatine tıklama
        assignmentFormPages.clickOnTheStartClock.click();
    }

    @When("select the start time")
    public void selectTheStartTime() {
        // Başlangıç saatini seçme
        assignmentFormPages.chooseOclock.click();
    }

    @When("click on the calendarOkButtonTwo")
    public void clickOnTheCalendarOkButtonTwo() {
        // Takvimdeki ikinci onay butonuna tıklama
        assignmentFormPages.okButton2.click();
    }

    @When("click on the end date")
    public void clickOnTheEndDate() {
        // Bitiş tarihine tıklama
        assignmentFormPages.clickOnTheEndDate.click();
    }

    @When("select the end date")
    public void selectTheEndDate() {
        // Bitiş tarihini seçme
        assignmentFormPages.chooseEndDate.click();
    }

    @When("click on the calendarOkButtonThree")
    public void clickOnTheCalendarOkButtonThree() {
        // Takvimdeki üçüncü onay butonuna tıklama
        assignmentFormPages.okButton3.click();
    }

    @When("click on the end time")
    public void clickOnTheEndTime() {
        // Bitiş saatine tıklama
        assignmentFormPages.clickEndOclock.click();
    }

    @When("select the end time")
    public void selectTheEndTime() {
        // Bitiş saatini seçme
        assignmentFormPages.chooseEndOclock.click();
    }

    @When("click on the calendarOkButtonFour")
    public void clickOnTheCalendarOkButtonFour() {
        // Takvimdeki dördüncü onay butonuna tıklama
        assignmentFormPages.okButton4.click();
    }

    @When("Scroll down to the elementSaveButton")
    public void scrollDownToTheElementSaveButton() {
        // Kaydet butonuna ulaşmak için sayfayı kaydırma
        assignmentFormPages.scrollAndClickSaveButton();
    }

    @When("click on the additional October")
    public void clickOnTheAdditionalOctober() {
        // Ekim ayı için ek onay alanına tıklama
        assignmentFormPages.octConfirmator.click();
    }

    @When("select an additional approver from the list Oct.")
    public void selectAnAdditionalApproverFromTheListOct() {
        // Ekim ayı için onaylayıcı seçme
        assignmentFormPages.chooseOctConfirmator.click();
    }

    @When("click on the send button")
    public void clickOnTheSendButton() {
        // Gönder butonuna tıklama
        assignmentFormPages.submitButton.click();
    }

    @When("click on the close confirmation button")
    public void clickOnTheCloseConfirmationButton() {
        // Kapat onay butonuna tıklama
        assignmentFormPages.closeInfoButton.click();
    }

    @When("click on the assignment form for ongoing requests")
    public void clickOnTheAssignmentFormForOngoingRequests() {
        // Devam eden görevler formuna tıklama
        assignmentFormPages.ongoingAssignmentRequest.click();
    }

    @Then("you have sent the assignment to the administrator go back to the homepage")
    public void youHaveSentTheAssignmentToTheAdministratorGoBackToTheHomepage() {
        // Görev yöneticisine gönderildiğinde ana sayfaya dönme
        assignmentFormPages.goToTheHomePageAssignmentRequest.click();
    }
}
