package Api.apiclients;

import Api.base.BaseApi;
import Api.dto.project.Project;

import static org.apache.hc.core5.http.HttpStatus.SC_OK;
import static utils.PropertyReader.getProjectApiUri;

public class ProjectApi extends BaseApi {
    public void createProject(Project project) {
        post(gson.toJson(project), getProjectApiUri(), SC_OK);
    }

    public Project getProjectByCode(String code) {

        return gson.fromJson(get(getProjectApiUri() + code, SC_OK).
                path("result").toString(), Project.class);
    }

    public void deleteProject(String code) {
        delete(getProjectApiUri() + code, SC_OK);
    }
}
