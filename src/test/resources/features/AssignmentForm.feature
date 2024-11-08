@AssignmentForm
Feature: AssignmentForm

  # Ortak adım
  Background: Common step login
    # Telefon numarası alanına tıklanır
    Given click on the phone number field
    # Telefon numarası girilir
    When please enter the phone number "5399393358"
    # Sonraki butonuna tıklanır
    When click on the next button
    # Şifre alanına tıklanır
    When click on the password field
    # Şifre girilir
    When enter the password "000000"
    # Giriş yapılır
    Then click on the login button

  Scenario: AssignmentForm Scenario
    # Görev talepleri bölümüne tıklanır
    When click on the requests for assignment
    # Yeni görev talebi oluşturma butonuna tıklanır
    When click on the create new request button
    # Görev formu talebine tıklanır
    When click on the request for the assignment form
    # Ekim ayındaki görev ekle butonuna tıklanır
    When click on the add task button Oct.
    # Görev türü alanına tıklanır
    When click on the assignment type field
    # Görev türü seçilir
    When select the type of assignment
    # Görev konusu yazılır
    When write about the assignment topic "Ankara'ya canlı yayına gidebilmek için görevlendirme istiyorum."
    # Başlangıç tarihi alanına tıklanır
    When click on the start date
    # Başlangıç saati girilir
    When enter the start time
    # Takvim onay butonuna tıklanır
    When click on the calendarOkButtonOne
    # Başlangıç saati seçilir
    When click on the start time
    # Başlangıç saati onaylanır
    When select the start time
    # Takvim onay butonuna tıklanır
    When click on the calendarOkButtonTwo
    # Bitiş tarihi alanına tıklanır
    When click on the end date
    # Bitiş tarihi seçilir
    When select the end date
    # Takvim onay butonuna tıklanır
    When click on the calendarOkButtonThree
    # Bitiş saati alanına tıklanır
    When click on the end time
    # Bitiş saati seçilir
    When select the end time
    # Takvim onay butonuna tıklanır
    When click on the calendarOkButtonFour
    # Save butonuna kaydırılır ve tıklanır
    When Scroll down to the elementSaveButton
    # Save butonuna tıklanır (yorum satırına alınmış)
    # When click on the save button
    # Ekim ayındaki ek bir onaylı kişiye tıklanır
    When click on the additional October
    # Ekstra onaylayan kişi seçilir
    When select an additional approver from the list Oct.
    # Gönder butonuna tıklanır
    When click on the send button
    # Onay mesajını kapatma butonuna tıklanır
    When click on the close confirmation button
    # Devam eden talepler için görev formuna tıklanır
    When click on the assignment form for ongoing requests
    # Görev başarıyla gönderildiği için anasayfaya geri dönülür
    Then you have sent the assignment to the administrator go back to the homepage
