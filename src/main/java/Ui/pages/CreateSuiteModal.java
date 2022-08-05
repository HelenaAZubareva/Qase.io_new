package Ui.pages;
import Ui.wrappers.InputCreateCase;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class CreateSuiteModal {
    public SelenideElement createButton = $("#save-suite-button");
    @Step("Creating suite")
    public CreateSuiteModal createSuite(String suiteName, String description, String preconditions) {
        new InputCreateCase("Suite name").writeCase(suiteName);
        new InputCreateCase("Description").writeCase(description);
        new InputCreateCase("Preconditions").writeCase(preconditions);
        return this;
    }
}
