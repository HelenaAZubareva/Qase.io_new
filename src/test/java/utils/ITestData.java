package utils;

import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;

import static utils.PropertyReader.getEmail;
import static utils.PropertyReader.getPassword;

public interface ITestData {
    @DataProvider(name = "Failed login data")
    static Object[][] inputForUpdateAddress() throws FileNotFoundException {

        return new Object[][]{
                {"",""},
                {"  ", "  "},
                {getEmail(), ""},
                {getEmail(), "123"},
                {getEmail(), "qwer"},
                {getEmail(), "!@#$"},
                {getEmail(), "ййцук"},
                {getEmail(), "sql"},
                {getEmail(), "css"},
                {"simson@gmail.com", "qwer"},
                {"simson@gmail.com", getPassword()},
                {"", getPassword()},
                {"qwer", getPassword()},
                {"qw er", getPassword()},
                {" qwer", getPassword()},
                {"qwer ", getPassword()},
                {" qwer ", getPassword()},
                {"   ", getPassword()},
        };
    }
}
