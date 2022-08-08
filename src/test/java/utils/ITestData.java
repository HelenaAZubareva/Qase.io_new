package utils;

import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;

import static utils.PropertyReader.getEmail;
import static utils.PropertyReader.getPassword;

public interface ITestData {
    @DataProvider(name = "Failed login data")
    static Object[][] inputForUpdateAddress() {

        return new Object[][]{
                {"",""},
                {"  ", "  "},
                {getEmail(), ""},
                {getEmail(), "123"},
                {getEmail(), "  "},
                {"", getPassword()},
                {"  ", getPassword()},
                {"qwer", getPassword()},
                {"qwer", "123"},
        };
    }
}
