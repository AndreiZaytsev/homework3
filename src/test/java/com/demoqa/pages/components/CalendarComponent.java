package com.demoqa.pages.components;

import com.demoqa.pages.RegistrationFormPage;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public CalendarComponent setDate(String year, String month, String day) {
        $(".react-datepicker__year-select").selectOptionContainingText(year);
        $(".react-datepicker__month-select").selectOptionContainingText(month);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month").click();

        return this;
    }

}
