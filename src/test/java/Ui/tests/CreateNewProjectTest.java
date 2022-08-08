package Ui.tests;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import Ui.base.BaseTest;

public class CreateNewProjectTest  extends BaseTest {

    /**
     * Checking the possibility of creating a new project
     */
    @Test (description = "Creating new project test")
    @TmsLink("ADP-14")
    public void createNewProjectTest() {
        loginPage.loginWithCorrectUser();
        projectCreationPageSteps.createNewProject();
        projectCreationPageSteps.checkCreatedProject();
    }

    /**
     * Checking the possibility of deleting the created project
     */
    @Test (description = "Deleting new project test")
    @TmsLink("ADP-15")
    public void deleteNewProjectTest() {
        loginPage.loginWithCorrectUser();
        projectCreationPageSteps.createNewProject();
        projectCreationPageSteps.checkProjectDeletion();
    }
}
