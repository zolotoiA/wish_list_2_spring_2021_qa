package com.automation.components;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;


@Getter
@FindBy(css = ".login-form")
public class LoginFormComponent extends HtmlElement {

    @FindBy(className = "form-title")
    private WebElement loginFormTitle;

    @FindBy(css = "#login-email-input")
    private WebElement emailField;

    @FindBy(css = "#login-password-input")
    private WebElement passwordField;

    @FindBy(css = "#login-btn")
    private WebElement loginFormButton;

    @FindBy(css = "#login-email-input-helper-text")
    private WebElement loginFieldErrorMsg;

    @FindBy(css = "div[class='MuiFormControl-root jss107'] p[class='MuiFormHelperText-root Mui-error Mui-required']")
    private WebElement passwordFieldErrorMsg;

    @FindBy(xpath = "//p[normalize-space()='Wrong email or password']")
    private WebElement emailOrPasswordErrMsg;

    @FindBy(xpath = "//p[normalize-space()='The password contains white spaces']")
    private WebElement passwordWhiteSpaceError;
}
