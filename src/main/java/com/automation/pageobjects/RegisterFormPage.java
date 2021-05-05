package com.automation.pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter
public class RegisterFormPage {

    @FindBy(css = ".MuiFormControl-root.MuiTextField-root > div.MuiInput-root.MuiInputBase-root > input[maxlength=\"50\"]")
    private WebElement fullName;

    @FindBy(css = ".MuiFormControl-root.MuiTextField-root > div.MuiInput-root.MuiInputBase-root > input[maxlength=\"40\"]")
    private WebElement emailAddress;

    @FindBy(id = "fullNameID")
    private WebElement fullNameId;

    @FindBy(id = "standard-adornment-password")
    private WebElement password;

    @FindBy(id = "standard-adornment-confirmationPassword")
    private WebElement confirmPassword;

    @FindBy(xpath = "//*[@class='primary-btn nav-btn register-btn']")
    private WebElement registerButtonFromHeader;

    @FindBy(xpath = "//*[@class='primary-btn form-btn']")
    private WebElement registerButton;

    @FindBy(xpath = "//p[normalize-space()='Please enter a full name']")
    private WebElement fullNameError;

    @FindBy(xpath = "//p[normalize-space()='Please enter a valid email address']")
    private WebElement emailError;

    @FindBy(xpath = "//p[normalize-space()='There is an existing account with this email']")
    private WebElement emailExistingError;

    @FindBy(xpath = "//p[normalize-space()='Please enter a password']")
    private WebElement passwordEmptyError;

    @FindBy(xpath = "//p[normalize-space()='The password contains white spaces']")
    private WebElement passwordWithSpaceError;

    @FindBy(xpath = "//p[normalize-space()='The password is too short']")
    private WebElement passwordToShortError;

    @FindBy(xpath = "//p[normalize-space()='Passwords do not match']")
    private WebElement confirmPasswordError;

    @FindBy(css = ".wishlist-form")
    private WebElement registerUserPopUp;

    @FindBy(xpath = "//*[contains(text(),'Full Name')]")
    private WebElement fullNameLbl;

    @FindBy(xpath = "//*[contains(text(),'Email')]")
    private WebElement emailLbl;

    @FindBy(xpath = "//*[contains(text(),'Password')]")
    private WebElement passwordLbl;

    @FindBy(xpath = "//*[contains(text(),'Confirm Password')]")
    private WebElement confirmPasswordLbl;

    @FindBy(css = ".login-btn")
    private WebElement loginButton;


    public RegisterFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterFullName(String username) {
        fullName.clear();
        fullName.sendKeys(username);
    }

    public void enterEmailAddress(String email) {
        emailAddress.clear();
        emailAddress.sendKeys(email);
    }

    public void enterPassword(String pass) {
        password.clear();
        password.sendKeys(pass);
    }

    public void enterConfirmPassword(String confirmPass) {
        confirmPassword.clear();
        confirmPassword.sendKeys(confirmPass);
    }

    public void checkLoggedIn(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".nav-greeting")));
    }

    public void checkRegisterFormDisplaying(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".form-title")));
    }
}