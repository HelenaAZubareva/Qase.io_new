package Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.PropertyReader;

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

    protected Response get(String uri) {
        return requestSpecification.
                when().
                get(getBaseUrlApi() + uri).
                then().
                log().all().
                statusCode(200).
                extract().response();
    }

    protected Response post(String body, String uri) {
        return requestSpecification.
                body(body).
                when().
                log().all().
                post( getBaseUrlApi() + uri).
                then().
                statusCode(200).
                log().all().
                extract().response();
    }

    protected Response put(String body, String uri) {
        return requestSpecification.
                body(body).
                when().
                log().all().
                put( getBaseUrlApi()+ uri).
                then().
                statusCode(200).
                log().all().
                extract().response();
    }

    protected Response patch(String body, String uri) {
        return requestSpecification.
                body(body).
                when().
                log().all().
                patch(getBaseUrlApi() + uri).
                then().
                statusCode(200).
                log().all().
                extract().response();
    }

    protected void delete(String uri) {
        requestSpecification.
                when().
                delete(getBaseUrlApi() + uri).
                then().
                log().all().
                statusCode(200);
    }
}
