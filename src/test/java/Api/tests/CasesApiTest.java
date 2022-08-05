package Api.tests;

import Api.base.BaseApiTest;
import Api.dto.Cases.Case;
import Api.dto.Cases.ErrorResult;
import Api.dto.Cases.Result;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.apache.hc.core5.http.HttpStatus.SC_NOT_FOUND;
import static utils.TestConstants.ACTUAL_CODE;

public class CasesApiTest extends BaseApiTest {

    /**
     * Scenario for creating, retrieving and deleting of a specific case for a specific project
     */
    @Test
    public void CreateTestCaseScenario() {
        String title = faker.name().fullName() + faker.book().title();
        Case testCase = Case.builder().title(title).build();
        int testCaseId = casesApi.createTestCase(ACTUAL_CODE, testCase);

        Result createdTestCase = casesApi.getTestCaseById(ACTUAL_CODE, testCaseId).getResult();
        Assert.assertEquals(createdTestCase.getTitle(), testCase.getTitle());

        ErrorResult result = casesApi.deleteTestCase(ACTUAL_CODE, 987, SC_NOT_FOUND);
    }
}
