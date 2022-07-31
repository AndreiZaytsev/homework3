package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void configure() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.timeout = 10000; // 10 seconds
//        Configuration.browser = "opera";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        SelenideElement firstName = $("[id=firstName]");
        firstName.setValue("Andrey");

        SelenideElement lastName = $("[id=lastName]");
        lastName.setValue("Zaytsev");

        SelenideElement userEmail = $("[id=userEmail]");
        userEmail.setValue("test@example.com");

        SelenideElement genderRadio = $("[for='gender-radio-1']");
        genderRadio.click();

        SelenideElement userNumber = $("[id=userNumber]");
        userNumber.setValue("9100000000");

        SelenideElement dateOfBirthInput =  $("[id=dateOfBirthInput]");
        dateOfBirthInput.click();

        SelenideElement yearSelect = $(".react-datepicker__year-select");
        yearSelect.selectOptionContainingText("2000");

        SelenideElement monthSelect = $(".react-datepicker__month-select");
        monthSelect.selectOptionContainingText("Oct");


        SelenideElement daySelect =  $(".react-datepicker__day--001");
        daySelect.click();

        SelenideElement subjectsInput = $("[id=subjectsInput]");
        subjectsInput.click();
        subjectsInput.setValue("English").pressEnter();
        subjectsInput.setValue("Computer Science").pressEnter();
        subjectsInput.setValue("Math").pressEnter();

        SelenideElement hobbiesCheckbox1 = $("[for='hobbies-checkbox-1']");
        hobbiesCheckbox1.click();

        SelenideElement hobbiesCheckbox2 = $("[for='hobbies-checkbox-2']");
        hobbiesCheckbox2.click();

        SelenideElement hobbiesCheckbox3 = $("[for='hobbies-checkbox-3']");
        hobbiesCheckbox3.click();

        SelenideElement uploadPicture = $("[id=uploadPicture]");
        uploadPicture.uploadFile(new File("src/test/resources/test_file.png"));

        SelenideElement currentAddress = $("[id=currentAddress");
        currentAddress.setValue("Kaluga");


        $(byText("Select State")).click();
        $(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Noida")).click();

        SelenideElement submit = $(byText("Submit"));
        submit.click();



        SelenideElement modalBody = $(".modal-body");
        modalBody.shouldHave(text("Andrey Zaytsev"));
        modalBody.shouldHave(text("test@example.com"));
        modalBody.shouldHave(text("Male"));
        modalBody.shouldHave(text("9100000000"));
        modalBody.shouldHave(text("01 October,2000"));
        modalBody.shouldHave(text("English, Computer Science, Maths"));
        modalBody.shouldHave(text("Sports, Reading, Music"));
        modalBody.shouldHave(text("test_file.png"));
        modalBody.shouldHave(text("Kaluga"));
        modalBody.shouldHave(text("NCR Noida"));


    }

}
