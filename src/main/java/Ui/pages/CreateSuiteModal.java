package Ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import Ui.wrappers.InputCreateSuite;

import static com.codeborne.selenide.Selenide.$;

public class CreateSuiteModal {
    public SelenideElement createButton = $("#save-suite-button");
    @Step("Creating suite")
    public CreateSuiteModal createSuite(String suiteName, String description, String preconditions) {
        new InputCreateSuite("Suite name").writeSuite(suiteName);
        new InputCreateSuite("Description").writeSuite(description);
        new InputCreateSuite("Preconditions").writeSuite(preconditions);
        return this;
    }
}
