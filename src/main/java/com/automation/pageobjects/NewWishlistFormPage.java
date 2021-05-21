package com.automation.pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import static com.automation.utils.ChooseOfWebDriver.getDriver;

@Getter
public class NewWishlistFormPage {
    WebDriver driver;

    @FindBy(className = "wishlist-form-title")
    private WebElement title;

    @FindBy(className = "wishlist-form-type")
    private WebElement type;

    @FindBy(className = "wishlist-form-btn")
    private WebElement saveButton;

    public NewWishlistFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public void inputTitle(String s) {
        getTitle().sendKeys(s);
    }

    public void inputType(String s) {
        getType().click();
        getDriver().findElement(By.xpath("//div//ul//li[contains(text(),'" + s + "')]")).click();
    }
}
