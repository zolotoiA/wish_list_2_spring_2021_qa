package com.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {

    private WebDriver driver;
    @FindBy(css = ".nav-greeting")
    static WebElement welcomeText;
    @FindBy(css = ".nav-title")
    private WebElement welcomeTitle;
    @FindBy(css = ".primary-btn ")
    private WebElement newWishlistButton;
    @FindBy(xpath = "//div[@class='nav-quick-access']//*[local-name()='svg']")
    private WebElement settingsButton;
    @FindBy(xpath = "//div[@class='nav-quick-access']//*[local-name()='svg']")
    private WebElement notificationButton;
    @FindBy(xpath = "//div[@class='MuiAvatar-root MuiAvatar-circle nav-avatar MuiAvatar-colorDefault']//*[local-name()='svg']")
    private WebElement avatarIcon;
    @FindBy(xpath = "button=log out")
    private WebElement logOutButton;


    public HeaderPage (WebDriver driver) {
        this. driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getNewWishlistButton() {
        return newWishlistButton;
    }

    public WebElement getSettingsButton() {
        return settingsButton;
    }

    public WebElement getNotificationButton() {
        return notificationButton;
    }

    public WebElement getAvatarIcon() {
        return avatarIcon;
    }

    public  String getWelcomeText() {
       return welcomeText.getText();
    }

    public  String getWelcomeTitle() {
        return welcomeTitle.getText();
    }
}