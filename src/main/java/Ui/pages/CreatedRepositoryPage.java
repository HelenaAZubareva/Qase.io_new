package Ui.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreatedRepositoryPage {
    public SelenideElement settingsLink =  $x("//a[@title='Settings']");

    public SelenideElement deleteProjectButton = $(".btn.btn-cancel");
    public SelenideElement suiteButton = $("#create-suite-button");
    public SelenideElement caseButton = $("#create-case-button");
    public SelenideElement suiteName = $(".DvbSwG");
    public SelenideElement caseTitle = $(".jp0OXJ.nzJYNg");


    public void deleteCreatedProject() {
        settingsLink.click();
        deleteProjectButton.click();
        deleteProjectButton.click();
    }
}
