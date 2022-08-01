package Api;

import com.github.javafaker.Faker;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseApiTest {
    public SuitesApi suiteApi;
    public ProjectApi projectApi;
    public DefectApi defectApi;
    public CeasesApi casesApi;
    public Faker faker;

    @BeforeClass
    public void setup() {

        suiteApi = new SuitesApi();
        projectApi = new ProjectApi();
        defectApi = new DefectApi();
        casesApi = new CeasesApi();
        faker = new Faker();

    }
}
