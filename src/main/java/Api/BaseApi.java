package Api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import static org.hamcrest.core.IsEqual.equalTo;
import static utils.PropertyReader.getBaseUrlApi;


import static io.restassured.RestAssured.given;
import static utils.PropertyReader.getToken;


public class BaseApi {

    Gson gson = new GsonBuilder().
            excludeFieldsWithoutExposeAnnotation().
            create();


    RequestSpecification requestSpecification;

    public BaseApi() {
        requestSpecification =
                given().
                        header("Token", getToken()).
                        header("Content-Type", "application/json").
                        log().all();
    }

    protected Response get(String uri, int statusCode) {
        return requestSpecification.
                when().
                get(getBaseUrlApi() + uri).
                then().
                log().all().
                statusCode(statusCode).
                extract().response();
    }

    protected Response post(String body, String uri, int statusCode) {
        return requestSpecification.
                body(body).
                when().
                log().all().
                post(getBaseUrlApi() + uri).
                then().
                statusCode(statusCode).
                log().all().
                extract().response();
    }

    protected Response put(String body, String uri) {
        return requestSpecification.
                body(body).
                when().
                log().all().
                put(getBaseUrlApi() + uri).
                then().
                statusCode(200).
                log().all().
                extract().response();
    }

    protected Response patch(String body, String uri, int statusCode) {
        return requestSpecification.
                body(body).
                when().
                patch(getBaseUrlApi() + uri).
                then().
                log().all().
                statusCode(statusCode).
                extract().response();
    }

    protected Response delete(String uri, int statusCode) {
        return requestSpecification.
                when().
                delete(getBaseUrlApi() + uri).
                then().
                log().all().
                statusCode(statusCode).
                extract().response();
    }
}
