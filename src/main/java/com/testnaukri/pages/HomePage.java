package com.testnaukri.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


}
