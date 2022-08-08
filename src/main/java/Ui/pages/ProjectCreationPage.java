package Ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import utils.AllureUtils;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
@Log4j2
public class ProjectCreationPage {
    Faker faker = new Faker(new Locale("en-US"));
    public SelenideElement nameProjectInput = $("#inputTitle");
    public SelenideElement codeProjectInput = $("#inputCode");
    public SelenideElement createProjectButton = $(".btn.btn-primary");
    public ElementsCollection listOfProjectNames = $$(".defect-title");

    public SelenideElement errorMessage = $(".form-control-feedback");

    public String nameProject = faker.name().title();

    @Step("Creating a new project with correct data")
    public void createNewProjectWithCorrectData() {
        log.info("Set '{}' like project name", nameProject);
        nameProjectInput.sendKeys(nameProject);
        codeProjectInput.clear();
        log.info("Set code");
        codeProjectInput.sendKeys(faker.code().asin());
        log.info("Navigate to created repository page");
        createProjectButton.click();
        AllureUtils.screenshot();
    }

    @Step("Creating a new project with project name '{nameProject}' and code '{code}'")
    public void createNewProject(String nameProject, String code) {
        log.info("Set '{}' like project name", nameProject);
        nameProjectInput.sendKeys(nameProject);
        codeProjectInput.clear();
        log.info("Set '{}' like code", code);
        codeProjectInput.sendKeys(code);
        log.info("Navigate to created repository page");
        createProjectButton.click();
        AllureUtils.screenshot();
    }
}

