package Api;

import Api.dto.Counts;
import Api.dto.Project;
import org.testng.annotations.Test;

public class ProjectApiTest extends BaseApiTest{
    @Test
    public void createProject() {
        Project project = Project.
                builder().
                title("NewProject").
                code("NP2").
                description("new").
//                 counts(new Counts(5)).
                        build();

        projectApi.createProject(project);
    }
 }

