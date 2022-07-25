package Api;

import org.testng.annotations.BeforeMethod;

public class BaseApiTest {
    public ProjectApi projectApi;

    @BeforeMethod
    public void setup() {
        projectApi = new ProjectApi();
    }
}
