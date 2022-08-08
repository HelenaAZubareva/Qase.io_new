package Ui.pages;

import Ui.pages.ProjectCreationPage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import utils.AllureUtils;
import utils.PropertyReader;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;

@Log4j2
public class ProjectsPage {
    public SelenideElement createProjectButton = $("#createButton");
    public SelenideElement searchField = $(".form-control.search-input");
    public SelenideElement message = $(".no-project.mt-4");

    @Step("Clicking  creating project button")
    public ProjectCreationPage clickCreateProjectButton() {
        log.info("Navigate to new project page");
        createProjectButton.shouldBe(visible).click();
        AllureUtils.screenshot();
        return new ProjectCreationPage();
    }
}


