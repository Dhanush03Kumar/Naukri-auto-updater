package com.testnaukri.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class HomePage extends Base{

    @FindBy(xpath = "//img[contains(@alt,'profile')]")
    private WebElement viewProfile;

    @FindBy(xpath = "//a[text()='View & Update Profile']")
    private WebElement updateProfile;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToProfile(){
        clickElement(viewProfile);
        clickElement(updateProfile);
    }


    public void verifyHomePage() {
        String expectedTitle="Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com";
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Home page title does not match!");
    }
}
