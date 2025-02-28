package com.testnaukri.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends Base{

    @FindBy(xpath = "//span[@class='fullname']")
    private WebElement fullName;

    @FindBy(xpath = "//span[@name='Experience']")
    private WebElement experience;

    @FindBy(xpath = "//em[text()='editOneTheme']")
    private WebElement edit;

    @FindBy(xpath = "//div[contains(@class,'crossIcon')]")
    private WebElement chatbotClose;

    @FindBy(xpath = "//input[@id='exp-years-droopeFor']")
    private WebElement expDropdown;

    @FindBy(xpath = "//a[@data-id='exp-years-droope_3']")
    private WebElement exp3Years;

    @FindBy(xpath = "//a[@data-id='exp-years-droope_2']")
    private WebElement exp2Years;

    @FindBy(xpath = "//button[@id='saveBasicDetailsBtn']")
    private WebElement saveButton;


    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getFullName(){
        return getText(fullName);
    }

    public void clickEdit(){
        clickElement(edit);
    }

    private void closeChatbotIfPresent() {
        try {
            if (chatbotClose.isDisplayed()) {
                chatbotClose.click();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Chatbot popup not found, continuing...");
        }
    }

    public void updateExperience() {
        closeChatbotIfPresent();

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,160)");

        clickElement(expDropdown);
        clickElement(exp3Years);
        clickElement(expDropdown);
        clickElement(exp2Years);

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        clickElement(saveButton);
    }

    public String getExperienceDetails(){
        return getText(experience);
    }
}
