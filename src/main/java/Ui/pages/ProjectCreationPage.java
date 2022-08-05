package Ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectCreationPage {
    Faker faker = new Faker(new Locale("en-US"));

    public SelenideElement nameProjectInput = $("#inputTitle");
    public SelenideElement codeProjectInput = $("#inputCode");
    public SelenideElement createProjectButton = $(".btn.btn-primary");
    public ElementsCollection listOfProjectNames = $$(".defect-title");

    public SelenideElement errorMessage = $(".form-control-feedback");

    public String nameProject = faker.name().title();

    public void createNewProjectWithCorrectData() {
        nameProjectInput.sendKeys(nameProject);
        codeProjectInput.sendKeys(faker.code().asin());
        createProjectButton.click();
    }

    public void createNewProject(String nameProject, String code) {
        nameProjectInput.sendKeys(nameProject);
        codeProjectInput.clear();
        codeProjectInput.sendKeys(code);
        createProjectButton.click();
    }
}

