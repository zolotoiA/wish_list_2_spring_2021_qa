package com.automation.pageobjects;

import lombok.Getter;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.List;

@Getter
public class MainDashboardPage extends HtmlElement {
    private WebDriver driver;
    private List<CardComponent> listOfCardItems;

    @FindBy(className = "primary-btn ")
    private WebElement newWishlistButton;

    @FindBy(className = "navbar-logout-btn")
    private WebElement logoutButton;

    public MainDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    public CardComponent getCardByTitle(String card) {
        return listOfCardItems.stream()
                .filter(e -> e.getItemCardTitle().getText().equals(card))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No such card found"));
    }

    public int cardsQuantity() {
        int i = 0;
        for (CardComponent card : listOfCardItems) {
            i++;
        }
        return i;
    }
}
