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
public class EditFormComponent extends HtmlElement {

    private WebDriver driver;
    @FindBy(css = ".grey-btn")
    private WebElement editButton;

    @FindBy(id = "wishlist-form-title-label")
    private  WebElement titleLabel;

    @FindBy(id = "wishlist-form-type-label")
    private  WebElement typeLabel;

    @FindBy(className = "wishlist-form")
    private  WebElement descriptionLabel;

    @FindBy(id = "wishlist-form-date-label")
    private  WebElement dateLabel;

    @FindBy(id = "wishlist-form-privacy-label")
    private  WebElement privacyLabel;

    @FindBy(id = "wishlist-form-title-label")
    private  WebElement titleField;

    @FindBy(css = ".MuiSelect-selectMenu")
    private  WebElement typeField;

    @FindBy(xpath = "//li[normalize-space()='Birthday']")
    private  WebElement selectBirthDay;

    @FindBy(xpath = "//li[normalize-space()='Wedding']")
    private  WebElement selectWedding;

    @FindBy(xpath = "//li[normalize-space()='Other']")
    private  WebElement selectOther;

    @FindBy(xpath = "//li[normalize-space()='None']")
    private  WebElement selectNone;

    @FindBy(id = "wishlist-form-description")
    private  WebElement textField;

    @FindBy(id = "wishlist-form-date")
    private  WebElement dateButton;

    @FindBy(id = "wishlist-form-privacy")
    private  WebElement privacySelectButton;

    @FindBy(css = ".MuiListItem-button:hover ")
    private  WebElement selectPrivat;

    @FindBy(css = ".MuiListItem-button:hover")
    private  WebElement selectPublic;

    @FindBy(css = ".form-btn ")
    private  WebElement saveChangesButton;

    @FindBy(css = ".form-title")
    private  WebElement wishlistHeaderTitle;


    public EditFormComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    public void waitEditFormElement(){
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}