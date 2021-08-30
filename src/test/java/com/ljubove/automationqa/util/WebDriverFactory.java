package com.ljubove.automationqa.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriverFactory {

    public static WebDriver getDriver(String webDriver) {
        switch (webDriver) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "opera":
                WebDriverManager.operadriver().setup();
                return new OperaDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            default:
                throw new RuntimeException("Unsupported browser");
        }
    }
}
