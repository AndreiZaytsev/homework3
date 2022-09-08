package com.demoqa.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateAndCityComponent {

    public StateAndCityComponent setStateAndCity(String State, String City) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(State)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(City)).click();

        return this;
    }
}
