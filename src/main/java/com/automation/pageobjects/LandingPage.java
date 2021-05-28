package com.automation.pageobjects;

import com.automation.components.LoginFormComponent;
import com.automation.components.RegisterFormComponent;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LandingPage extends AbstractPage {
    private LoginFormComponent loginFormComponent;
    private RegisterFormComponent registerFormComponent;

    @FindBy(className = "login-btn")
    private WebElement landingPageLoginBtn;

    @FindBy(className = "register-btn")
    private WebElement registerButton;

    @FindBy(tagName = "header")
    private WebElement header;

    @FindBy(className = "footer")
    private WebElement footer;

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public void userLogin(String email, String password) {
        loginFormComponent.getEmailField().sendKeys(email);
        loginFormComponent.getPasswordField().sendKeys(password);
    }

    public boolean headerDisplayed() {
        return header.isDisplayed();
    }

    public boolean footerDisplayed() {
        return footer.isDisplayed();
    }

    public boolean loginButtonDisplayed() {
        return landingPageLoginBtn.isDisplayed();
    }

    public boolean registerButtonDisplayed() {
        return registerButton.isDisplayed();
    }

    public void clickRegister() {
        registerButton.click();
    }

    public boolean isRegisterFormDisplayed() {
        return registerFormComponent.isDisplayed();
    }

    public void clickLogin() {
        landingPageLoginBtn.click();
    }

    public String loginGetText() {
        return landingPageLoginBtn.getText();
    }
}
