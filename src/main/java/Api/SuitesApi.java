package Api;

import Api.dto.Cases.ErrorResult;
import Api.dto.Suites.GetTestSuiteResponse;
import Api.dto.Suites.ResultSuiteApi;
import Api.dto.Suites.Suite;
import io.restassured.response.Response;
import utils.DataConstants;

import static org.apache.hc.core5.http.HttpStatus.SC_OK;
import static utils.PropertyReader.getSuitesApiUri;

public class SuitesApi extends BaseApi implements DataConstants {
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
}
