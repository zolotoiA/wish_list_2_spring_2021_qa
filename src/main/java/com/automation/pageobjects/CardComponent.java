package com.automation.pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Getter
@FindBy(className = "card")
public class CardComponent extends HtmlElement {

    @FindBy(css = ".card h1")
    private WebElement itemCardTitle;

    @FindBy(css = ".primary-btn")
    private WebElement addButton;

    @FindBy(css = ".grey-btn")
    private WebElement editButton;

    @FindBy(css = ".card-delete-btn")
    private WebElement deleteButton;

    public String getItemCardTitle() {
        return itemCardTitle.getText();
    }

    public WebElement getAddButton() {
        return addButton;
    }

    public WebElement getEditButton() {
        return editButton;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

}
