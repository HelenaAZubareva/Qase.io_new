package Ui.tests;

import org.testng.annotations.Test;
import Ui.base.BaseTest;

public class CreateNewProjectTest  extends BaseTest {

    /**
     * Checking the possibility of creating a new project
     */
    @Test (description = "Creating new project test")
    public void createNewProjectTest() {
        loginPage.loginWithCorrectUser();
        projectCreationPageSteps.createNewProject();
        projectCreationPageSteps.checkCreatedProject();
    }

    /**
     * Checking the possibility of deleting the created project
     */
    @Test (description = "Deleting new project test")
    public void deleteNewProjectTest() {
        loginPage.loginWithCorrectUser();
        projectCreationPageSteps.createNewProject();
        projectCreationPageSteps.checkProjectDeletion();
    }
}
