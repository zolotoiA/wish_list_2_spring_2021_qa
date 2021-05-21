package com.automation.utils;

import com.automation.propertyreader.PropertiesFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Objects;

@Log4j2
public class ChooseOfWebDriver {

    private static WebDriver driver;
    private static String driverType;


    public static WebDriver initiateInstance() {
        if (Objects.isNull(driverType)) {
            driverType = PropertiesFileReader.getProperty("browser").toUpperCase();
        }
        switch (WebDriverEnum.valueOf(driverType)) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case IE:
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new RuntimeException(driverType + " driver file was not found");
        }
        log.info("WebDriver is initialized");
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver() {
        return driver == null ? initiateInstance() : driver;
    }

    public static void quitDriver() {
        driver.close();
        driver.quit();
        driver = null;
        log.info("Quit WebDriver");
    }

}
