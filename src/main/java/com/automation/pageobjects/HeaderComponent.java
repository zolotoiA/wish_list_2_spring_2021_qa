package com.automation.pageobjects;

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
public class HeaderComponent extends HtmlElement {

    private WebDriver driver;
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


    public HeaderComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    public void waitHeaderComponent(){
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}