package Ui.tests;

import org.testng.annotations.Test;
import Ui.base.BaseTest;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.open;

public class CreateNewProjectNegativeTest extends BaseTest {

    /**
     * Checking the possibility of creating a new project with filling in the "Project Code" field with invalid data
     */

    @Test (description = "Creating new project with incorrect code", groups = "Negative")
    public void createNewProjectWithIncorrectCode() {
        loginPage.loginWithCorrectUser();
        projectCreationPageSteps.createNewProjectWithData(faker.name().title(), faker.code().isbnRegistrant());

        projectCreationPage.errorMessage.shouldHave(exactText("The code format is invalid."));
    }

    /**
     * Checking the possibility of creating a new project with filling in the "Project Code" field with data
     * containing less than two characters
     */
    @Test (description = "Creating new project with one character code")
    public void createNewProjectWithOneCharacterCode() {
        loginPage.loginWithCorrectUser();
        projectCreationPageSteps.createNewProjectWithData(faker.name().title(), faker.code().isbnGroup());

        projectCreationPage.errorMessage.shouldHave(exactText("The code must be at least 2 characters."));
    }

    /**
     * Checking the possibility of creating a new project by filling in the "Project Code" field with an existing code
     */
    @Test (description = "Creating new project with same code", groups = "Negative")
    public void createNewProjectWithSameCode() {
        String code = faker.code().imei();

        loginPage.loginWithCorrectUser();
        projectCreationPageSteps.createNewProjectWithData(faker.name().title(), code);

        open(reader.getProjectsPageUrl());
        projectCreationPageSteps.createNewProjectWithData(faker.name().title(), code);

        projectCreationPage.errorMessage.shouldHave(exactText("The selected project code is already in use."));
    }
}
