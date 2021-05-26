package com.automation.components;

import com.automation.pageobjects.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
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

    @FindBy(className = "grey-btn")
    private WebElement editButton;

    @FindBy(className = "card-delete-btn")
    private WebElement deleteButton;

    public String getItemCardTitle(){
        return itemCardTitle.getText();
    }
}