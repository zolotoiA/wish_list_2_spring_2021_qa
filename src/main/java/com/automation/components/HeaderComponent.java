package com.automation.components;

import com.automation.pageobjects.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.concurrent.TimeUnit;

@Getter
@FindBy(tagName = "header")
public class HeaderComponent extends HtmlElement {

    @FindBy(css = ".nav-greeting")
    private WebElement welcomeText;

    @FindBy(css = ".nav-title")
    private WebElement welcomeTitle;

    @FindBy(css = ".primary-btn ")
    private WebElement newWishlistButton;

    @FindBy(className = "MuiSvgIcon-root nav-icons")
    private WebElement settingsButton;

    @FindBy(xpath = "//div[@class='nav-quick-access']//*[local-name()='svg']")
    private WebElement notificationButton;

    @FindBy(css = ".MuiAvatar-fallback]")
    private WebElement avatarIcon;

    @FindBy(css = ".login-btn")
    private WebElement loginButton;

    @FindBy(className = "navbar-logout-btn")
    private WebElement logoutButton;
}