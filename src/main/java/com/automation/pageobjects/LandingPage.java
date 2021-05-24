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
public class LandingPage extends HtmlElement {
    private WebDriver driver;
    private List<LoginFormComponent> loginFormComponents;

    @FindBy(css = ".login-btn")
    private WebElement landingPageLoginBtn;

    public LoginFormComponent getLoginFormItems() {
        return loginFormComponents.stream()
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("No such element found"));
    }

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }
}
