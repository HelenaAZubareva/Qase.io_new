package Api;

import Api.dto.project.Project;
import org.testng.annotations.Test;
import utils.TestConstants;

public class ProjectApiTest extends BaseApiTest implements TestConstants{
    @Test (priority = 1)
    public void createProject() {
        Project project = Project.
                builder().
                title(PROJECT_TITLE).
                code(PROJECT_CODE).
                description(PROJECT_DESCRIPTION).
                        build();

        projectApi.createProject(project);
    }
    @Test (priority = 2)
    public void getAllProject() {
        projectApi.getAllProject();
    }

    @Test (priority = 2)
    public void getProjectByCode() {
        projectApi.getProjectByCode(PROJECT_CODE);
    }


    @Test (priority = 3)
    public void deleteProjectByCodeTest() {
        projectApi.deleteProject(PROJECT_CODE);
    }


 }

