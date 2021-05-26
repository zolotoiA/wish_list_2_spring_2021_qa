package com.automation.components;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.concurrent.TimeUnit;

import static com.automation.utils.ChooseOfWebDriver.getDriver;

@Getter
@FindBy(className = "form-container")
public class EditFormComponent extends HtmlElement {
    @FindBy(className = "grey-btn")
    private WebElement editButton;

    @FindBy(id = "wishlist-form-title-label")
    private WebElement titleLabel;

    @FindBy(id = "wishlist-form-type-label")
    private WebElement typeLabel;

    @FindBy(className = "wishlist-form")
    private WebElement descriptionLabel;

    @FindBy(id = "wishlist-form-date-label")
    private WebElement dateLabel;

    @FindBy(id = "wishlist-form-privacy-label")
    private WebElement privacyLabel;

    @FindBy(id = "wishlist-form-title-label")
    private WebElement titleField;

    @FindBy(className = "MuiSelect-selectMenu")
    private WebElement typeField;

    @FindBy(xpath = "//li[normalize-space()='Birthday']")
    private WebElement selectBirthDay;

    @FindBy(xpath = "//li[normalize-space()='Wedding']")
    private WebElement selectWedding;

    @FindBy(xpath = "//li[normalize-space()='Other']")
    private WebElement selectOther;

    @FindBy(xpath = "//li[normalize-space()='None']")
    private WebElement selectNone;

    @FindBy(id = "wishlist-form-description")
    private WebElement textField;

    @FindBy(id = "wishlist-form-date")
    private WebElement dateButton;

    @FindBy(id = "wishlist-form-privacy")
    private WebElement privacySelectButton;

    @FindBy(className = "MuiListItem-button:hover ")
    private WebElement selectPrivat;

    @FindBy(className = "MuiListItem-button:hover")
    private WebElement selectPublic;

    @FindBy(className = "form-btn")
    private WebElement saveChangesButton;

    @FindBy(className = "form-title")
    private WebElement wishlistHeaderTitle;

    public void waitEditFormElement() {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}