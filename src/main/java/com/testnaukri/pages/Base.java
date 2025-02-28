package com.testnaukri.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Base(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver,this);
    }

    public void clickElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void enterText(WebElement element,String text){
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public String getText(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

}
