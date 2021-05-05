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

    @FindBy(className = "primary-btn")
    private WebElement addButton;

    @FindBy(css = ".grey-btn")
    private WebElement editButton;

    @FindBy(css = ".card-delete-btn")
    private WebElement deleteButton;


}