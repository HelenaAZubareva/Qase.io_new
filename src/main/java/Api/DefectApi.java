package Api;

import Api.dto.defect.Defect;
import Api.dto.defect.UpdateDefect;
import utils.DataConstants;

import static utils.PropertyReader.getDefectApiUri;

public class DefectApi extends BaseApi implements DataConstants {
    public void createDefect(Defect defect, String code) {
        post(gson.toJson(defect), getDefectApiUri() + code, CODE_OK);
    }
    public Defect getSpecificDefect(String code, String id) {
        return gson.fromJson(get(getDefectApiUri() + code + id, CODE_OK).
                asString(), Defect.class);



    }
    public Defect getAllDefectTest(String code) {
        return gson.fromJson(get(getDefectApiUri() + code, CODE_OK).
                asString(), Defect.class);
    }



    public void updateDefect(UpdateDefect updateDefect, String code, String id) {
        patch(gson.toJson(updateDefect), getDefectApiUri() + code + id, CODE_OK);
    }


}