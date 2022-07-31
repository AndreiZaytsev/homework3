package com.demoqa;

import com.codeborne.selenide.Configuration;
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
        $("[id=firstName]").setValue("Andrey");
        $("[id=lastName]").setValue("Zaytsev");
        $("[id=userEmail]").setValue("test@example.com");
        $("[for='gender-radio-1']").click();
        $("[id=userNumber]").setValue("9100000000");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__year-select").selectOptionContainingText("2000");
        $(".react-datepicker__month-select").selectOptionContainingText("Oct");
        $(".react-datepicker__day--001").click();
        $("[id=subjectsInput]").click();
        $("[id=subjectsInput]").setValue("English").pressEnter();
        $("[id=subjectsInput]").setValue("Computer Science").pressEnter();
        $("[id=subjectsInput]").setValue("Math").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-2']").click();
        $("[for='hobbies-checkbox-3']").click();
        $("[id=uploadPicture]").uploadFile(new File("src/test/resources/test_file.png"));
        $("[id=currentAddress").setValue("Kaluga");
        $(byText("Select State")).click();
        $(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Noida")).click();
        $(byText("Submit")).click();

        $(".modal-body").shouldHave(text("Andrey Zaytsev"));
        $(".modal-body").shouldHave(text("test@example.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("9100000000"));
        $(".modal-body").shouldHave(text("01 October,2000"));
        $(".modal-body").shouldHave(text("English, Computer Science, Maths"));
        $(".modal-body").shouldHave(text("Sports, Reading, Music"));
        $(".modal-body").shouldHave(text("test_file.png"));
        $(".modal-body").shouldHave(text("Kaluga"));
        $(".modal-body").shouldHave(text("NCR Noida"));

    }

}
