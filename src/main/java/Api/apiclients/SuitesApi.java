package Api.apiclients;

import Api.base.BaseApi;
import Api.dto.Cases.ErrorResult;
import Api.dto.Suites.GetTestSuiteResponse;
import Api.dto.Suites.ResultSuiteApi;
import Api.dto.Suites.Suite;
import io.restassured.response.Response;

import static org.apache.hc.core5.http.HttpStatus.SC_OK;
import static utils.PropertyReader.getSuitesApiUri;

public class SuitesApi extends BaseApi {
    public int createTestSuite(String projectCode, Suite testSuite) {

        String body = gson.toJson(testSuite);
        Response response = post(body, getSuitesApiUri() + projectCode, SC_OK);
        return gson.fromJson(response.body().path("result").toString(), ResultSuiteApi.class).getId();
    }

    public GetTestSuiteResponse getTestSuiteById(String projectCode, int testSuiteId) {

        Response response = get(getSuitesApiUri() + projectCode + "/" + testSuiteId, SC_OK);
        return gson.fromJson(response.body().asString(), GetTestSuiteResponse.class);
    }

    public ErrorResult deleteTestSuite(String projectCode, int testSuiteId, int statusCode) {
        return gson.fromJson(delete(getSuitesApiUri() + projectCode + "/" + testSuiteId,
                statusCode).body().asString(), ErrorResult.class);
    }

    public int updateTestsuite(Suite testSuite, String projectCode, int testSuiteId, int statusCode) {

        String body = gson.toJson(testSuite);
        Response response = patch(body, getSuitesApiUri() + projectCode + "/" + testSuiteId, statusCode);
        return gson.fromJson(response.body().asString(), ResultSuiteApi.class).getId();
    }

}
