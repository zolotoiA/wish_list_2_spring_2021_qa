package com.automation.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class DependenciesSetup {

    @Getter
    private String a = "privet";

    @Test
    public void check1() {
        assertThat(getA(), is("privet"));
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://github.com/bonigarcia/webdrivermanager");
        String url = driver.getCurrentUrl();
        assertEquals(url, driver.getCurrentUrl());

    }
}