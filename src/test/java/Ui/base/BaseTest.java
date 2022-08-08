package Ui.base;

import Ui.browser.SelenideConfiguration;

import Ui.pages.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import Ui.steps.ProjectCreationPageSteps;
import utils.PropertyReader;

import java.util.Locale;
import java.util.Optional;

import static com.codeborne.selenide.Selenide.closeWebDriver;
@Listeners(TestListener.class)
public class BaseTest {

    protected LoginPage loginPage;
    protected PropertyReader reader;
    protected ProjectsPage projectsPage;
    protected ProjectCreationPage projectCreationPage;
    protected CreatedRepositoryPage createdRepositoryPage;
    protected ProjectCreationPageSteps projectCreationPageSteps;
    protected CreateSuiteModal createSuiteModal;
    protected CreateCasePage createCasePage;
    protected Faker faker;



    @BeforeMethod (alwaysRun = true, description = "Opening Browser")
    public void setUp() {
        String browser = Optional.ofNullable(System.getProperty("browser")).orElse("chrome");
        SelenideConfiguration.configureBrowser(browser);

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
                .includeSelenideSteps(true));

        loginPage = new LoginPage();
        reader = new PropertyReader();
        projectsPage = new ProjectsPage();
        projectCreationPage = new ProjectCreationPage();
        createdRepositoryPage = new CreatedRepositoryPage();
        projectCreationPageSteps = new ProjectCreationPageSteps();
        createSuiteModal = new CreateSuiteModal();
        createCasePage = new CreateCasePage();
        faker = new Faker(new Locale("en-US"));
    }

    @AfterMethod (alwaysRun=true, description = "Closing Browser")
    public void closeBrowser(){
        closeWebDriver();
    }


}
