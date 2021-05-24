package com.automation.pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Getter
@FindBy(css = ".login-form")
public class LoginFormComponent extends HtmlElement {

    @FindBy(css = ".form-title")
    private WebElement loginFormTitle;

    @FindBy(css = "#login-email-input")
    private WebElement emailField;

    @FindBy(css = "#login-password-input")
    private WebElement passwordField;

    @FindBy(css = "#login-btn")
    private WebElement loginFormButton;
}
