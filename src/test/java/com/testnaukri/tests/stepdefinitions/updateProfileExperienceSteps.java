package com.testnaukri.tests.stepdefinitions;

import com.testnaukri.pages.HomePage;
import com.testnaukri.pages.LoginPage;
import com.testnaukri.pages.ProfilePage;
import com.testnaukri.base.AutomationBase;
import com.testnaukri.utils.ConfigReader;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class updateProfileExperienceSteps extends AutomationBase {

    private LoginPage loginPage;
    private HomePage homePage;
    private ProfilePage profilePage;
    private WebDriver driver;

    private String username;
    private String password;

    public updateProfileExperienceSteps() {
        setUp();
        this.driver = getDriver();
        if (this.driver == null) {
            throw new RuntimeException("WebDriver instance is null! Check if it is initialized correctly.");
        }
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        profilePage = new ProfilePage(driver);

        username = ConfigReader.getProperty("username");
        password = ConfigReader.getProperty("password");
    }

    @Given("User is on login page")
    public void userIsOnLoginPage() {
        System.out.println("Starting setup");
        System.out.println("Done setup");
    }

    @When("User enters valid username and password")
    public void userEntersValidUsernameAndPassword() {
        loginPage.login(username, password);
    }


    @Then("User should be navigated to home page")
    public void userShouldBeNavigatedToHomePage() {
        homePage.verifyHomePage();
    }

    @When("User clicks on profile")
    public void userClicksOnProfile() {
        homePage.goToProfile();
    }

    @Then("User should be navigated to profile page")
    public void userShouldBeNavigatedToProfilePage() {
        profilePage.verifyProfilePage();
    }

    @When("User updates experience details")
    public void userUpdatesExperienceDetails() {
        profilePage.clickEdit();
        profilePage.updateExperience();
    }


    @Then("Experience should be updated successfully")
    public void experienceShouldBeUpdatedSuccessfully() {
        System.out.println("Experience updated successfully: " + profilePage.getExperienceDetails());
        tearDown();
    }
}
