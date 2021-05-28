package com.automation.pageobjects;

import com.automation.components.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.concurrent.TimeUnit;

import static com.automation.utils.ChooseOfWebDriver.getDriver;

public abstract class AbstractPage extends HtmlElement {
    public HeaderComponent headerItems = new HeaderComponent();

    public void waitPageOrElement() {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    public AbstractPage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }
}
