@GymReservation
Feature: Login Page Test Scenario - Common step

  Scenario: Login Test Case
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

  Scenario: Gym Reservation
    # Talepler kısmına tıklanır
    Given click on the requests
    # Yeni talep oluşturulmak için butona tıklanır
    When click to create a new request
    # Spor salonu rezervasyonu yapmak için tıklanır
    When click here to book a gym
    # Rezervasyon tarihi seçilir
    When select a date
    # Rezervasyon saati seçilir
    When select the booking time
    # Rezervasyonu oluştur butonuna tıklanır
    When click on the create reservation button
    # Rezervasyon onayı penceresine tıklanır
    When booking confirmation click
    # Onay penceresini kapatmak için tıklanır
    When close the confirmation button
    # Anasayfaya geri dönülür
    Then go back to the homepage
