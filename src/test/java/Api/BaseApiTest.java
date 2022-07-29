package Api;

import org.testng.annotations.BeforeMethod;

public class BaseApiTest {
    public ProjectApi projectApi;

    public DefectApi defectApi;


    @BeforeMethod
    public void setup() {
        projectApi = new ProjectApi();

        defectApi = new DefectApi();

    }
}
