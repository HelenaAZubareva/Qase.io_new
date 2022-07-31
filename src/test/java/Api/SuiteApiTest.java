package Api;

import Api.dto.Cases.ErrorResult;
import Api.dto.Cases.Result;
import Api.dto.Suites.Suite;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.apache.hc.core5.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.hc.core5.http.HttpStatus.SC_OK;

public class SuiteApiTest extends BaseApiTest {
    @Test
    public void CreateTestSuiteScenario() {
        String projectCode = "DEMO";
        String title = faker.name().fullName() + faker.name().title();
        Suite testSuite = Suite.builder().title(title).build();
        int testSuiteId = suiteApi.createTestSuite(projectCode, testSuite);

        Result createdTestSuite = suiteApi.getTestSuiteById(projectCode, testSuiteId).getResult();
        Assert.assertEquals(createdTestSuite.getTitle(), testSuite.getTitle());

        ErrorResult result = suiteApi.deleteTestSuite(projectCode, 7, SC_OK);
    }
}
