package Api.Steps;

import Api.apiclients.SuitesApi;
import Api.dto.Cases.ErrorResult;
import Api.dto.Suites.Suite;
import org.testng.Assert;

import static org.apache.hc.core5.http.HttpStatus.SC_OK;

public class SuiteSteps {
    public SuitesApi suiteApi = new SuitesApi();

    public Suite createTestSuite(String projectCode, Suite testSuite) {

        int testSuiteId = suiteApi.createTestSuite(projectCode, testSuite);
        Suite createdTestSuite = suiteApi.getTestSuiteById(projectCode, testSuiteId).getResult();
        Assert.assertEquals(createdTestSuite.getTitle(), testSuite.getTitle());

        return createdTestSuite;
    }

    public int updateTestSuite(Suite testSuite, String projectCode, int testSuiteId) {
        return suiteApi.updateTestsuite(testSuite, projectCode, testSuiteId, SC_OK);
    }

    public Suite getTestSuite(String projectCode, int testSuiteId) {
        return suiteApi.getTestSuiteById(projectCode, testSuiteId).getResult();
    }

    public ErrorResult deleteTestSuite(String projectCode, int testSuiteId) {
        return suiteApi.deleteTestSuite(projectCode, testSuiteId, SC_OK);
    }
}


