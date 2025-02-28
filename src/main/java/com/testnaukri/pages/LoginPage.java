package com.testnaukri.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Base{

    @FindBy(xpath = "//a[text()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='form-row'][1]/input")
    private WebElement userNameField;

    @FindBy(xpath = "//div[@class='form-row'][2]/input")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void login(String username,String password){
        clickElement(loginButton);
        enterText(userNameField,username);
        enterText(passwordField,password);
        clickElement(submit);
    }


}
