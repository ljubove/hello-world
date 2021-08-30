package com.ljubove.automationqa.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class MarkBeforeClickListener extends AbstractWebDriverEventListener {

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'",
                element);
        // Пауза, что бы мы успели рассмотреть
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px solid red'",
                element);
    }
}
