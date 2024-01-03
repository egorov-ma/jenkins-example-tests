package ru.egorovma.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private final SelenideElement chooseYear = $(".react-datepicker__year-select"),
            chooseMonth = $(".react-datepicker__month-select");

    public void setDate(String day, String month, String year) {
        chooseYear.selectOption(year);
        chooseMonth.selectOption(month);
        $(".react-datepicker__month").$$(".react-datepicker__day:not(.react-datepicker__day--outside-month)")
                .findBy(text(day)).click();
    }
}