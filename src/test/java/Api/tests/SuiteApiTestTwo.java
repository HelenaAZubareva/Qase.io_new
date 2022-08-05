package Api.tests;

import Api.base.BaseApiTest;
import Api.dto.Suites.Suite;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.apache.hc.core5.http.HttpStatus.SC_OK;
import static utils.TestConstants.ACTUAL_CODE;

public class SuiteApiTestTwo extends BaseApiTest {
    int suiteId;
    String title;
    Suite testSuite;

    @BeforeMethod
    public void before() {
        title = faker.name().fullName() + faker.name().title();
        testSuite = Suite.builder().title(title).build();
        suiteId = suiteApi.createTestSuite(ACTUAL_CODE, testSuite);
    }

    /**
     * Scenario two for creating, updating and deleting of a specific suite for a specific project
     */
    @Test
    public void CreateTestSuiteScenarioTwo() {

        //update
        Suite testSuiteWithDescription = Suite.builder().title(title).description(ACTUAL_CODE).build();
        suiteApi.updateTestsuite(testSuiteWithDescription, ACTUAL_CODE, suiteId, SC_OK);

        //assert
        Suite updatedTestSuite = suiteApi.getTestSuiteById(ACTUAL_CODE, suiteId).getResult();
        Assert.assertEquals(testSuite.getTitle(), updatedTestSuite.getTitle());
        Assert.assertEquals(testSuiteWithDescription.getDescription(), updatedTestSuite.getDescription());
    }

    @AfterTest
    public void after() {
        suiteApi.deleteTestSuite(ACTUAL_CODE, suiteId, SC_OK);
    }
}
