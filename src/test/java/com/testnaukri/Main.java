package com.testnaukri;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Main {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.naukri.com/");

        driver.manage().window().maximize();

        System.out.println("page title "+driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        WebElement popUp = driver.findElement(By.xpath("//div[@class='acceptance-btn']"));
        popUp.click();
        WebElement Login = driver.findElement(By.xpath("//a[text()='Login']"));
        Login.click();

        WebElement userName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='form-row'][1]/input")));
        userName.click();
        userName.sendKeys("**************");

        WebElement password = driver.findElement(By.xpath("//div[@class='form-row'][2]/input"));
        password.sendKeys("********");

        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();

        WebElement viewProfile = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[contains(@alt,'profile')]")));
        viewProfile.click();

        WebElement updateProfile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='View & Update Profile']")));
        updateProfile.click();

        WebElement fullName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='fullname']")));
        String fullNameText = fullName.getText();
        System.out.println("Full Name: "+fullNameText);

        WebElement edit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//em[text()='editOneTheme']")));
        edit.click();

        js.executeScript("window.scrollBy(0,160)");

        WebElement expDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='exp-years-droopeFor']")));
        expDropdown.click();
        WebElement exp3Years = driver.findElement((By.xpath("//a[@data-id='exp-years-droope_3']")));
        exp3Years.click();
        expDropdown.click();
        WebElement exp2Years = driver.findElement((By.xpath("//a[@data-id='exp-years-droope_2']")));
        exp2Years.click();



        js.executeScript("window.scrollBy(0,500)");
        WebElement save = driver.findElement((By.xpath("//button[@id='saveBasicDetailsBtn']")));
        save.click();
        WebElement expDetails = driver.findElement(By.xpath("//span[@name='Experience']"));
        String expDetailsText = expDetails.getText();
        System.out.println("Experience Details: "+expDetailsText);


        driver.quit();
    }
}
