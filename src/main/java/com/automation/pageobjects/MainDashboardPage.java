package com.automation.pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.List;

public class MainDashboardPage extends HtmlElement {
    private WebDriver driver;
    private List<CardComponent> listOfCardItems;

    public MainDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    public CardComponent getCardByTitle(String card) {
        return listOfCardItems.stream()
                .filter(e -> e.getItemCardTitle().equals(card))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No such card found"));
    }
}
