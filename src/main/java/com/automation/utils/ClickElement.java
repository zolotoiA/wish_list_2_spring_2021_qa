package com.automation.utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ClickElement {
    public static void clickElement(String pageName, String elementName, WebDriver driver) {
        WebElement webElement;
//        Class clazz = null;
//        try {
//            clazz = Class.forName("com.automation.components."+pageName);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        Field[] fields = clazz.getDeclaredFields();
//        for (Field field : fields)
//            if (field.getType() == WebElement.class) {
//                field.setAccessible(true);
//                if (field.getName().equals(elementName))
//                    try {
//                        webElement = (WebElement) field.get(clazz.getConstructor(WebDriver.class).newInstance(driver));
//                        webElement.click();
//                    } catch (IllegalAccessException | NoSuchMethodException | InstantiationException |
//                            InvocationTargetException e) {
//                        e.printStackTrace();
//                    }
            }
        private static List<Class<?>> getAllClassesFrom (String...pageName)) {
            return new Reflections(pageName, new SubTypesScanner(false))
                    .getAllTypes()
                    .stream()
                    .map(name -> {
                        try {
                            return Class.forName(name);
                        } catch (ClassNotFoundException e) {
                            return null;
                        }
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }
    }

