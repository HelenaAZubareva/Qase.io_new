package Api;

import Api.Steps.SuiteSteps;
import Api.dto.Cases.ErrorResult;
import Api.dto.Suites.Suite;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.apache.hc.core5.http.HttpStatus.SC_OK;

public class SuiteApiTest extends BaseApiTest {

    SuiteSteps suiteSteps = new SuiteSteps();

    @Test
    public void CreateTestSuiteScenario() {
        String projectCode = "DEMO";
        String title = faker.name().fullName() + faker.name().title();
        Suite testSuite = Suite.builder().title(title).build();
        Suite testSuiteWithDescription = Suite.builder().title(title).description(projectCode).build();

        Suite createdTestSuite = suiteSteps.createTestSuite(projectCode, testSuite);
        int testSuiteId = createdTestSuite.getId();

        suiteSteps.updateTestSuite(testSuiteWithDescription, projectCode, testSuiteId);

        Suite updatedTestSuite = suiteSteps.getTestSuite(projectCode, testSuiteId);
        Assert.assertEquals(createdTestSuite.getTitle(), updatedTestSuite.getTitle());
        Assert.assertEquals(testSuiteWithDescription.getDescription(), updatedTestSuite.getDescription());

        suiteApi.deleteTestSuite(projectCode, testSuiteId, SC_OK);
    }

}
