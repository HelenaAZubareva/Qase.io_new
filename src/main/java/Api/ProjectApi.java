package Api;

import Api.dto.Project;

public class ProjectApi extends BaseApi{
    public void createProject(Project project) {
      post(gson.toJson(project), "project");
    }

  public Project getProjectByCode(String code) {
   return gson.fromJson(get("project/" + code).
              path("result").toString(), Project.class);
   }
}
