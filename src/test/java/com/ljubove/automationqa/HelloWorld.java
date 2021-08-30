package com.ljubove.automationqa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorld {
    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://otus.ru");
        Assert.assertEquals(driver.getTitle(),"Otus - онлайн образование");
    }
}
