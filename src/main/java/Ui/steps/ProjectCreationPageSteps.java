package Ui.steps;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import Ui.pages.CreatedRepositoryPage;
import Ui.pages.ProjectCreationPage;
import Ui.pages.ProjectsPage;
import utils.PropertyReader;

import static com.codeborne.selenide.CollectionCondition.containExactTextsCaseSensitive;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.open;
import static utils.PropertyReader.getProjectsPageUrl;

@Log4j2
public class ProjectCreationPageSteps {
    private ProjectsPage projectsPage = new ProjectsPage();
    private ProjectCreationPage projectCreationPage = new ProjectCreationPage();
    private CreatedRepositoryPage createdRepositoryPage = new CreatedRepositoryPage();


    public int initialListSize;


    @Step("Creating new project")
    public void createNewProject() {
        initialListSize = projectCreationPage.listOfProjectNames.size();

        projectsPage.clickCreateProjectButton();
        projectCreationPage.createNewProjectWithCorrectData();
    }

    @Step("Creating new project  with data")
    public void createNewProjectWithData(String nameProject, String code) {
        projectsPage.clickCreateProjectButton();
        log.info("Creating new project with name {nameProject} and  code {code}");
        projectCreationPage.createNewProject(nameProject, code);
    }

    @Step("Checking created project")
    public void checkCreatedProject() {
        Selenide.open(getProjectsPageUrl());
        log.info("Navigating to  {}",getProjectsPageUrl());
        projectCreationPage.listOfProjectNames
                .shouldHave(containExactTextsCaseSensitive(projectCreationPage.nameProject));
    }

    @Step("Check project deletion")
    public void checkProjectDeletion() {
        createdRepositoryPage.deleteCreatedProject();
        projectCreationPage.listOfProjectNames.shouldHave(size(initialListSize));
    }
}
