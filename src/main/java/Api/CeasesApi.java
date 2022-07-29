package Api;

import Api.dto.Cases.Case;
import Api.dto.Cases.ErrorResult;
import Api.dto.Cases.GetTestCaseResponse;
import Api.dto.Cases.ResultApi;
import io.restassured.response.Response;

import static utils.PropertyReader.getCasesApiUri;

public class CeasesApi extends BaseApi {

    public int createTestCase(String projectCode, Case testCase) {

        String body = gson.toJson(testCase);
        Response response = post(body, getCasesApiUri() + projectCode, 200);
        return gson.fromJson(response.body().path("result").toString(), ResultApi.class).getId();
    }

    public GetTestCaseResponse getTestCaseById(String projectCode, int testCaseId) {

        Response response = get(getCasesApiUri() + projectCode + "/" + testCaseId, 200);
        return gson.fromJson(response.body().asString(), GetTestCaseResponse.class);
    }

    public ErrorResult deleteTestCase(String projectCode, int testCaseId, int statusCode){
        return gson.fromJson(delete(getCasesApiUri() + projectCode + "/" + testCaseId, statusCode).body().asString(), ErrorResult.class);
    }
}
