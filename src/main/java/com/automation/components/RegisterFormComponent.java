package com.automation.components;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Getter
@FindBy(css = ".form-container.register-form")
public class RegisterFormComponent extends HtmlElement {

    @FindBy(className = "register-form")
    private WebElement regFormTitle;

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

    @FindBy(css = ".form-title")
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
}