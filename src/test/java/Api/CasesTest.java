package Api;

import Api.dto.Cases.Case;
import Api.dto.Cases.ErrorResult;
import Api.dto.Cases.GetTestCaseResponse;
import Api.dto.Cases.Result;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CasesTest extends BaseApiTest {

    @Test
    public void CreateTestCase(){
        String projectCode = "DEMO";
        String title = faker.name().fullName() + faker.book().title();
        Case testCase = Case.builder().title(title).build();

        int testCaseId = casesApi.createTestCase(projectCode, testCase);
        Result createdTestCase = casesApi.getTestCaseById(projectCode,testCaseId).getResult();
        Assert.assertEquals(createdTestCase.getTitle(),testCase.getTitle());

        ErrorResult result =  casesApi.deleteTestCase(projectCode,987, 404);

    }
}
