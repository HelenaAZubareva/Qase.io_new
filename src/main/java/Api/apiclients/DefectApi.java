package Api.apiclients;

import Api.base.BaseApi;
import Api.dto.defect.Defect;
import Api.dto.defect.Status;
import Api.dto.defect.UpdateDefect;

import static org.apache.hc.core5.http.HttpStatus.SC_OK;
import static utils.PropertyReader.getDefectApiUri;

public class DefectApi extends BaseApi {
    public void createDefect(Defect defect, String code) {
        post(gson.toJson(defect), getDefectApiUri() + code, SC_OK);
    }

    public Status getSpecificDefect(String code, int id) {
        return gson.fromJson(get(getDefectApiUri() + code +"/"+ id, SC_OK).body().
                asString(), Status.class);
    }

    public Defect getAllDefectTest(String code) {
        return gson.fromJson(get(getDefectApiUri() + code, SC_OK).
                asString(), Defect.class);
    }

    public void updateDefect(UpdateDefect updateDefect, String code, int id) {
        patch(gson.toJson(updateDefect), getDefectApiUri() + code +"/"+ id, SC_OK);
    }
}
