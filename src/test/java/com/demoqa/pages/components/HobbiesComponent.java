package com.demoqa.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HobbiesComponent {

    public HobbiesComponent setHobbies(String value1, String value2) {
        $("#hobbiesWrapper").$(byText(value1)).click();
        $("#hobbiesWrapper").$(byText(value2)).click();

        return this;
    }
}
