package com.demoqa.tests;
import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class RegistrationFormTests extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
        .setFirstName("Andrey")
        .setLastName("Zaytsev")
        .setEmail("test@example.com")
        .setGender("Male")
        .setNumber("9100000000")
        .setBirthDate("2000", "Oct", "01")
        .setUserSubjects("Math", "English", "Computer Science")
        .setHobbies("Sports", "Reading")
        .setUploadFile("src/test/resources/test_file.png")
        .setCurrentAddress("Kaluga")
        .setStateAndCity("NCR", "Noida")
        .pressSubmit();

         registrationFormPage.checkResultsTableVisible()
            .checkResult("Student Name", "Andrey Zaytsev")
            .checkResult("Student Email", "test@example.com")
            .checkResult("Gender", "Male")
            .checkResult("Mobile", "9100000000")
            .checkResult("Date of Birth", "01 October,2000")
            .checkResult("Subjects", "Maths, English, Computer Science")
            .checkResult("Hobbies", "Sports, Reading")
            .checkResult("Picture", "test_file.png")
            .checkResult("Address", "Kaluga")
            .checkResult("State and City", "NCR Noida");

    }    @Test
    void fillFormWithMinimumDataTest() {
        registrationFormPage.openPage()
                .setFirstName("Andrey")
                .setLastName("Zaytsev")
                .setGender("Male")
                .setNumber("9100000000")
                .pressSubmit();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Andrey Zaytsev")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9100000000");

    }
}
