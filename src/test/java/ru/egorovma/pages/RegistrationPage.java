package ru.egorovma.pages;

import com.codeborne.selenide.SelenideElement;
import ru.egorovma.pages.components.CalendarComponent;
import ru.egorovma.pages.components.TableResultFormComponent;

import java.util.List;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    TableResultFormComponent tableResultFormComponent = new TableResultFormComponent();
    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            mobileNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitInput = $("#submit");

    public RegistrationPage openPage(String url) {
        open(url);
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public RegistrationPage setGender(String genterWrapper) {
        genderInput.$(byText(genterWrapper)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String userNumber) {
        mobileNumberInput.setValue(userNumber);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String hobbies) {
        hobbiesInput.$(byText(hobbies)).click();
        return this;
    }

    public RegistrationPage setHobbies(List<String> hobbies) {
        for (String hobby : hobbies) {
            hobbiesInput.$(byText(hobby)).click();
        }
        return this;
    }

    public RegistrationPage setPicture(String picture) {
        uploadPictureInput.uploadFromClasspath(picture);
        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public RegistrationPage setState(String state) {
        stateInput.setValue(state).pressEnter();
        return this;
    }

    public RegistrationPage setCity(String city) {
        cityInput.setValue(city).pressEnter();
        return this;
    }

    public void submit() {
        submitInput.click();
    }

    public RegistrationPage checkResult(String key, String value) {
        tableResultFormComponent.checkResult(key, value);
        return this;
    }

    public void checkResult(String key, List<String> value) {
        String formattedValue = value.toString().replaceAll("[\\[\\]]", "");
        tableResultFormComponent.checkResult(key, formattedValue);
    }

    public void checkRequiredFields(String propertyName, String expectedValue) {
        firstNameInput.shouldHave(cssValue(propertyName, expectedValue));
        lastNameInput.shouldHave(cssValue(propertyName, expectedValue));
    }

    public void checkRequiredUserNumber(String propertyName, String expectedValue) {
        mobileNumberInput.shouldHave(cssValue(propertyName, expectedValue));
    }
}