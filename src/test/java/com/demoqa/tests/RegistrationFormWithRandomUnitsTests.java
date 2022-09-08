package com.demoqa.tests;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static com.demoqa.tests.TestData.*;
import static com.demoqa.utils.RandomUtils.*;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;


public class RegistrationFormWithRandomUnitsTests extends TestBase{
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    static String firstName,
            lastName,
            expectedFullName =  format("%s %s", firstName, lastName),
            day,
            month,
            year,
            expectedDateOfBirth =  format("%s %s,%s", day, month, year),
            email,
            gender,
            number,
            userSubject1,
            userSubject2,
            userSubject3,
            expectedSubjects = format("%s, %s, %s", userSubject1, userSubject2, userSubject3),
            hobbies1,
            hobbies2,
            uploadFile,
            currentAddress,
            state,
            city;

    @BeforeEach
    void prepareTestData() {
        firstName = getRandomString(10);
        lastName = getRandomString(10);
        expectedFullName =  format("%s %s", firstName, lastName);
        day = "01";
        month = "October";
        year = "2000";
        expectedDateOfBirth =  format("%s %s,%s", day, month, year);
        email = getRandomEmail();
        gender = "Male";
        number = getRandomPhone();
        userSubject1 = "Maths";
        userSubject2 = "English";
        userSubject3 = "Computer Science";
        expectedSubjects =  format("%s, %s, %s", userSubject1, userSubject2, userSubject3);
        hobbies1 = "Sports";
        hobbies2 = "Reading";
        uploadFile = "Picture test_file.png";
        currentAddress = "Kaluga";
        state  = "NCR";
        city = "Noida";
    }


    @Test
    void fillFormTest() {
        step("Open registration form ", () -> {
        registrationFormPage.openPage();
        });
        step("Fill form", () -> {
        registrationFormPage.setFirstName(firstName)
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
        });
        step("Check form results", () -> {
         registrationFormPage.checkResultsTableVisible()
                 .checkResult("Student Name", expectedFullName)
                 .checkResult("Student Email", email)
                 .checkResult("Gender", gender)
                 .checkResult("Mobile", number)
                 .checkResult("Date of Birth", expectedDateOfBirth)
                 .checkResult("Subjects", expectedSubjects)
                 .checkResult("Hobbies", "Sports, Reading")
                 .checkResult("Picture", uploadFile)
                 .checkResult("Address", currentAddress)
                 .checkResult("State and City", state + " " + city);
        });

    }

    @Test
    void fillFormWithMinimumDataTest() {
        step("Open registration form ", () -> {
        registrationFormPage.openPage();
        });
        step("Fill form", () -> {
        registrationFormPage.setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setNumber(number)
                .pressSubmit();
        });
        step("Check form results", () -> {
        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", expectedFullName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", number);
        });
    }
}
