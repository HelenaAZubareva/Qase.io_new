package Api;

import Api.dto.Cases.ErrorResult;
import Api.dto.Cases.Result;
import Api.dto.Suites.Suite;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.apache.hc.core5.http.HttpStatus.SC_OK;

public class SuiteTestClass extends BaseApiTest{

    int suiteId;

    String projectCode = "DEMO";

    @BeforeMethod
    public void before(){

        String title = faker.name().fullName() + faker.name().title();
        Suite testSuite = Suite.builder().title(title).build();
        suiteId = suiteApi.createTestSuite(projectCode, testSuite);
    }


    @Test
    public void CreateTestSuiteScenario1() {


      //update test suite
      //assert


    }

    @Test
    public void CreateTestSuiteScenario() {


        //todo

    }

    @AfterTest
    public void after(){
      suiteApi.deleteTestSuite(projectCode, suiteId, SC_OK);

    }
}
