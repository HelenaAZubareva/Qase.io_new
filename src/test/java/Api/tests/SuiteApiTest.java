package Api.tests;

import Api.Steps.SuiteSteps;
import Api.base.BaseApiTest;
import Api.dto.Suites.Suite;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.apache.hc.core5.http.HttpStatus.SC_OK;
import static utils.TestConstants.ACTUAL_CODE;

public class SuiteApiTest extends BaseApiTest {

    SuiteSteps suiteSteps = new SuiteSteps();

    /**
     * Scenario for creating, updating and deleting of a specific suite for a specific project
     */
    @Test
    public void CreateTestSuiteScenario() {
        //variables
        String title = faker.name().fullName() + faker.name().title();
        Suite testSuite = Suite.builder().title(title).build();

        //create
        Suite testSuiteWithDescription = Suite.builder().title(title).description(ACTUAL_CODE).build();

        Suite createdTestSuite = suiteSteps.createTestSuite(ACTUAL_CODE, testSuite);
        int testSuiteId = createdTestSuite.getId();

        //update
        suiteSteps.updateTestSuite(testSuiteWithDescription, ACTUAL_CODE, testSuiteId);

        //assert
        Suite updatedTestSuite = suiteSteps.getTestSuite(ACTUAL_CODE, testSuiteId);
        Assert.assertEquals(createdTestSuite.getTitle(), updatedTestSuite.getTitle());
        Assert.assertEquals(testSuiteWithDescription.getDescription(), updatedTestSuite.getDescription());

        //delete
        suiteApi.deleteTestSuite(ACTUAL_CODE, testSuiteId, SC_OK);
    }
}
