package com.demoqa.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class Button {

    private final String name;
    private final SelenideElement selector;

    public Button(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }

    //  @Step("Нажать кнопку {this.name}")
    public void click() {
        System.out.println("Нажать кнопку " + name);
        selector.click();
    }
}
