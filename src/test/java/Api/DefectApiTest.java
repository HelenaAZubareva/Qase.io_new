package Api;

import Api.dto.defect.Defect;
import Api.dto.defect.UpdateDefect;
import Ui.base.BaseTest;
import org.testng.annotations.Test;
import utils.TestConstants;


public class DefectApiTest extends BaseApiTest implements TestConstants {

    @Test(priority = 1)
    public void createDefectTest() {
        Defect defect = Defect.
                builder().
                title(DEFECT_TITLE).
                actualResult(DEFECT_ACTUAL_RESULT).
                severity(DEFECT_SEVERITY).
                build();

        defectApi.createDefect(defect, DEFECT_CODE);


    }
    @Test(priority = 2)
    public void getAllDefectTest() {
        defectApi.getAllDefectTest(DEFECT_CODE);
    }

    @Test(priority = 2)
    public void getSpecificDefectTest() {

        defectApi.getSpecificDefect(DEFECT_CODE, DEFECT_ID);
    }


@Test (priority = 3)
    public void updateDefectTest() {
        UpdateDefect updateDefect = UpdateDefect.
                builder().
                actualResult("2").
                build();

        defectApi.updateDefect(updateDefect, DEFECT_CODE, DEFECT_ID);
    }
}







