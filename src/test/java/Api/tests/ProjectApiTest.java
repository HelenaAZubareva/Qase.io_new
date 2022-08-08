package Api.tests;

import Api.base.BaseApiTest;
import Api.dto.project.Project;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import utils.TestConstants;

public class ProjectApiTest extends BaseApiTest implements TestConstants {
    /**
     * Checking the creating of a new project through API
     */
    @Test(priority = 1)
    @TmsLink("ADP-6")
    public void createProject() {
        Project project = Project.
                builder().
                title(PROJECT_TITLE).
                code(PROJECT_CODE).
                description(PROJECT_DESCRIPTION).
                build();

        projectApi.createProject(project);
    }

    /**
     * Checking the retrieve of a specific project by code
     */
    @Test(priority = 2)
    @TmsLink("ADP-7")
    public void getProjectByCode() {
        projectApi.getProjectByCode(PROJECT_CODE);
    }

    /**
     * Checking the deleting of a specific project by code
     */
    @Test(priority = 3)
    @TmsLink("ADP-8")
    public void deleteProjectByCodeTest() {
        projectApi.deleteProject(PROJECT_CODE);
    }
}

