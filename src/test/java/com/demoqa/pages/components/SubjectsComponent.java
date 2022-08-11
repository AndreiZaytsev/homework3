package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class SubjectsComponent {

    public SubjectsComponent setSubjects(String value1, String value2, String value3) {
        $("#subjectsInput").setValue(value1).pressEnter();
        $("#subjectsInput").setValue(value2).pressEnter();
        $("#subjectsInput").setValue(value3).pressEnter();


        return this;
    }
}
