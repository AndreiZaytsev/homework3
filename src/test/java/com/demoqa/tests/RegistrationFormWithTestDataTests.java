package com.demoqa.tests;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestData.*;



public class RegistrationFormWithTestDataTests extends TestBase{
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();



    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
        .setFirstName(firstName)
        .setLastName(lastName)
        .setEmail(email)
        .setGender(gender)
        .setNumber(number)
        .setBirthDate(year, month, day)
        .setUserSubjects(userSubject1, userSubject2, userSubject3)
        .setHobbies(hobbies1, hobbies2)
        .setUploadFile(uploadFile)
        .setCurrentAddress(currentAddress)
        .setStateAndCity(state, city)
        .pressSubmit();

         registrationFormPage.checkResultsTableVisible()
            .checkResult("Student Name", expectedFullName)
            .checkResult("Student Email", email)
            .checkResult("Gender", gender)
            .checkResult("Mobile", number)
            .checkResult("Date of Birth", expectedDateOfBirth)
            .checkResult("Subjects", userSubject1 + ", " + userSubject2 + ", " + userSubject3)
            .checkResult("Hobbies", "Sports, Reading")
            .checkResult("Picture", uploadFile)
            .checkResult("Address", currentAddress)
            .checkResult("State and City", state + " " + city);

    }    @Test
    void fillFormWithMinimumDataTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setNumber(number)
                .pressSubmit();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", expectedFullName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", number);

    }
}
