package Ui.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Ui.base.BaseTest;
import utils.ITestData;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static utils.PropertyReader.*;

public class LoginTest extends BaseTest {
    /**
     * Checking the possibility of successive login
     */
    @Test(description = "Success login")
    @TmsLink("ADP-17")
    public void testSuccessLogin() {
        loginPage.loginWithCorrectUser();
        webdriver().shouldHave(url(getProjectsPageUrl()));
    }

    /**
     * Checking the possibility of failing login with data
     */
    @Test(description = "Failed login", dataProvider = "Failed login data", dataProviderClass = ITestData.class)
    @TmsLink("ADP-18")
    public void testFailedLogin(String email, String password) {
        loginPage.login(email, password);
        webdriver().shouldHave(url(getLoginPageUrl()));

    }

    /**
     * Checking the possibility of failing login with credentials do not match records
     */

    @Test(description = "Failed login with credentials do not match records")
    @TmsLink("ADP-19")
    @Parameters({"email", "password"})
    public void testIncorrectLogin(@Optional("Smith@gmail.com") String email,
                                   @Optional("123qwe!?") String password) {
        loginPage.login(email, password);
        loginPage.errorMessage.shouldHave(Condition.exactText("These credentials do not match our records."));
    }
}
