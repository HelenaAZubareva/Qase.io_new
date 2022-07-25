package Ui.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.*;
import static utils.PropertyReader.*;

@Log4j2
public class LoginPage {
    public SelenideElement emailInput = $("#inputEmail");
    public SelenideElement passwordInput = $x("//input[@type='password']");
    public SelenideElement loginButton = $(By.id("btnLogin"));
    public SelenideElement errorMessage = $x("//div[@class='form-control-feedback']");



    @Step("Opening login.salesforce.com")
    public void openPage() {
        log.info("Navigate to {}", getLoginUrl());
        Selenide.open(getLoginUrl());
    }

    @Step("Logging with correct User")
    public ProjectsPage loginWithCorrectUser() {
        log.info("Navigating to  {}", getLoginUrl());
        Selenide.open(getLoginUrl());
        log.info("Logging with email {}", getEmail());
        emailInput.sendKeys(getEmail());
        log.info("Logging with password {}", getPassword());
        passwordInput.sendKeys(getPassword());
        loginButton.click();
        return new ProjectsPage();
    }

    @Step("Logging with email '{email}' and password '{password}'")
    public ProjectsPage login(String email, String password) {
        log.info("Navigating to  {}", getLoginUrl());
        Selenide.open(getLoginUrl());
        log.info("Logging with email {email}");
        emailInput.sendKeys(email);
        log.info("Logging with password {password}");
        passwordInput.sendKeys(password);
        loginButton.click();
        log.info("Clicking login button");
        return new ProjectsPage();
    }
}
