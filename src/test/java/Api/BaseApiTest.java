package Api;

import com.github.javafaker.Faker;
import org.testng.annotations.BeforeMethod;

public class BaseApiTest {
    public ProjectApi projectApi;

    public DefectApi defectApi;

    public Faker faker = new Faker();

    CeasesApi casesApi = new CeasesApi();


    @BeforeMethod
    public void setup() {
        projectApi = new ProjectApi();

        defectApi = new DefectApi();

    }
}
