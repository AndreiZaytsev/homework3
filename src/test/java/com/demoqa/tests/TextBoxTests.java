package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase {

    @BeforeAll
    static void configure() {
//        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.timeout = 10000; // 10 seconds
//        Configuration.browser = "opera";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue("Andrey");
        $("#lastName").setValue("Zaytsev");
        $("#userEmail").setValue("test@example.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9100000000");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionContainingText("2000");
        $(".react-datepicker__month-select").selectOptionContainingText("Oct");
        $(".react-datepicker__day--001:not(.react-datepicker__day--outside-month").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/test_file.png"));
        $("#currentAddress").setValue("Kaluga");
        $(byText("Select State")).click();
        $(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Noida")).click();
        $(byText("Submit")).click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        SelenideElement modalBody = $(".modal-body");
        modalBody.shouldHave(text("Andrey Zaytsev"), text("test@example.com"), text("Male"), text("9100000000"),
                text("01 October,2000"), text("Maths, English, Computer Science"), text("Sports, Reading"),
                text("test_file.png"), text("Kaluga"), text("NCR Noida"));

    }
}
