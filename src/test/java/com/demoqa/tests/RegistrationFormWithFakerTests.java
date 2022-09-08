package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestData.generateRandomMonth;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;


public class RegistrationFormWithFakerTests extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    Faker faker = new Faker();

    static String firstName,
            lastName,
            expectedFullName = format("%s %s", firstName, lastName),
            day,
            month,
            year,
            expectedDateOfBirth = format("%s %s,%s", day, month, year),
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
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        expectedFullName = format("%s %s", firstName, lastName);
        day = faker.number().numberBetween(1, 28) + "";
        month = generateRandomMonth();
        year = faker.number().numberBetween(1950, 2010) + "";
        expectedDateOfBirth = format("%s %s,%s", day, month, year);
        email = faker.internet().emailAddress();
        gender = "Male";
        number = faker.phoneNumber().subscriberNumber(10);
        userSubject1 = "Maths";
        userSubject2 = "English";
        userSubject3 = "Computer Science";
        expectedSubjects = format("%s, %s, %s", userSubject1, userSubject2, userSubject3);
        hobbies1 = "Sports";
        hobbies2 = "Reading";
        uploadFile = "Picture test_file.png";
        currentAddress = faker.address().fullAddress();
        state = "NCR";
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
