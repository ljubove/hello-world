package com.ljubove.automationqa;

import com.ljubove.automationqa.filters.CourseFilter;
import com.ljubove.automationqa.util.MarkBeforeClickListener;
import com.ljubove.automationqa.util.WebDriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class AutomationQaApplicationTests {

	@Value("${webdriver}")
	String webDriver;

	@Autowired
	private CourseFilter filter;

	@Test
	void contextLoads() {
	}

	@Test
	public void test(){
		//WebDriver driver = WebDriverFactory.getDriver("chrome");
		//WebDriver driver = WebDriverFactory.getDriver("firefox");
		WebDriver webdriver = WebDriverFactory.getDriver("opera");
		EventFiringWebDriver driver = new EventFiringWebDriver(webdriver);
		driver.register(new MarkBeforeClickListener());
		driver.manage().window().maximize();
		driver.get("https://otus.ru");

		WebElement test = driver.findElement(By.className("header2-menu__item-text"));
				test.click();
		log.info("Start");
		WebElement test1 = driver.findElement(By.xpath(".//*[text()='\n                            Программирование\n                            \n                                ']/.."));
		test1.click();
		log.info("clicked");
		driver.get("https://otus.ru");
		Assert.assertEquals("Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям", driver.getTitle());

	}

}
