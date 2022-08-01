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

        $("#firstName").setValue("Andrey");
        $("#lastName").setValue("Zaytsev");
        $("#userEmail").setValue("test@example.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("9100000000");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionContainingText("2000");
        $(".react-datepicker__month-select").selectOptionContainingText("Oct");
        $(".react-datepicker__day--001").click();
        SelenideElement subjectsInput = $("[id=subjectsInput]");
        subjectsInput.click();
        subjectsInput.setValue("English").pressEnter();
        subjectsInput.setValue("Computer Science").pressEnter();
        subjectsInput.setValue("Math").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-2']").click();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/test_file.png"));
        $("[id=currentAddress").setValue("Kaluga");
        $(byText("Select State")).click();
        $(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Noida")).click();
        $(byText("Submit")).click();

        SelenideElement modalBody = $(".modal-body");
        modalBody.shouldHave(text("Andrey Zaytsev"), text("test@example.com"), text("Male"), text("9100000000"),
                text("01 October,2000"), text("English, Computer Science, Maths"), text("Sports, Reading, Music"),
                text("test_file.png"), text("Kaluga"), text("NCR Noida"));

    }
}
