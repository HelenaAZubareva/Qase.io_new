package Api.tests;

import Api.base.BaseApiTest;
import Api.dto.defect.Defect;
import Api.dto.defect.UpdateDefect;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestConstants;


public class DefectApiTest extends BaseApiTest implements TestConstants {

    /**
     * Checking the creating of a defect in selected project
     */
    @Test(priority = 1)
    @TmsLink("ADP-2")
    public void createDefectTest() {
        Defect defect = Defect.
                builder().
                title(DEFECT_TITLE).
                actualResult(DEFECT_ACTUAL_RESULT).
                severity(DEFECT_SEVERITY).
                build();

        defectApi.createDefect(defect, ACTUAL_CODE);
        Assert.assertEquals(defect.getTitle(), DEFECT_TITLE);
    }

    /**
     * Checking the retrieve of all defects by  code
     */
    @Test(priority = 2)
    @TmsLink("ADP-3")
    public void getAllDefectTest() {
        defectApi.getAllDefectTest(ACTUAL_CODE);
    }

    /**
     * Checking the retrieve of a specific defect by code and ID
     */
    @Test(priority = 2)
    @TmsLink("ADP-4")
    public void getSpecificDefectTest() {
        var result= defectApi.getSpecificDefect(ACTUAL_CODE, DEFECT_ID);
        Assert.assertEquals(result.getResult().getId(),DEFECT_ID);
    }

    /**
     * Checking the updating of a defect in selected project
     */
    @Test(priority = 3)
    @TmsLink("ADP-5")
    public void updateDefectTest() {
        UpdateDefect updateDefect = UpdateDefect.
                builder().
                actualResult("2").
                build();

        defectApi.updateDefect(updateDefect, ACTUAL_CODE, DEFECT_ID);
    }
}







