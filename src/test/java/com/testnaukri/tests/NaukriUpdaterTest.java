package com.testnaukri.tests;

import com.testnaukri.base.AutomationBase;
import com.testnaukri.pages.HomePage;
import com.testnaukri.pages.LoginPage;
import com.testnaukri.pages.ProfilePage;
import com.testnaukri.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NaukriUpdaterTest extends AutomationBase {

    private LoginPage loginPage;
    private HomePage homePage;
    private ProfilePage profilePage;

    private String username;
    private String password;

    @BeforeMethod
    public void setUpTest(){
        setUp();
        loginPage=new LoginPage(getDriver());
        homePage=new HomePage(getDriver());
        profilePage=new ProfilePage(getDriver());

        username = ConfigReader.getProperty("username");
        password = ConfigReader.getProperty("password");
    }

    @Test
    public void updateProfileTest(){
        loginPage.login(username,password);
        homePage.goToProfile();
        System.out.println("Full name before update: "+profilePage.getFullName());
        profilePage.clickEdit();
        profilePage.updateExperience();
        System.out.println("Experience updated successfully : "+profilePage.getExperienceDetails());
    }

    @AfterMethod
    public void tearDownTest(){
        tearDown();
    }
}
