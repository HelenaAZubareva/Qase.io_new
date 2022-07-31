package Api;

import Api.dto.project.Project;

import static org.apache.hc.core5.http.HttpStatus.SC_OK;
import static utils.PropertyReader.getAllProjectApiUri;
import static utils.PropertyReader.getProjectApiUri;
import utils.DataConstants;

public class ProjectApi extends BaseApi implements DataConstants{
    public void createProject(Project project) {
      post(gson.toJson(project), getProjectApiUri(), SC_OK);
    }

  public Project getProjectByCode(String code) {

      return gson.fromJson(get(getProjectApiUri() + code, SC_OK).
              path("result").toString(), Project.class);
   }
    public Project getAllProject()  {

        return gson.fromJson(get(getAllProjectApiUri(), SC_OK).
                path("result").toString(), Project.class);
    }
    public void deleteProject(String code) {
        delete(  getProjectApiUri() + code, SC_OK);
    }
}
