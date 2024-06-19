package com.selenium.basics;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BasicsApplication {
	public static void main(String[] args) throws Exception {
	    //System.setProperty("webdriver.chrome.driver", "C:\\Users\\sujan\\Downloads\\basics\\basics\\src\\main\\resources\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://github.com/login");
	Thread.sleep(3000);
	highlight(driver,driver.findElement(By.id("login_field")));
	Thread.sleep(3000);
	highlight(driver,driver.findElement(By.className("header-logo")));
	Thread.sleep(3000);
	highlight(driver,driver.findElement(By.name("password")));
	Thread.sleep(3000);
	highlight(driver,driver.findElement(By.linkText("Forgot password?")));
	Thread.sleep(3000);
	highlight(driver,driver.findElement(By.partialLinkText("Create an")));
	Thread.sleep(3000);
	highlight(driver,driver.findElement(By.tagName("h1")));
	Thread.sleep(3000);
	highlight(driver,driver.findElement(By.xpath("//*[@id=\"login\"]/div[5]")));
	Thread.sleep(3000);
	highlight(driver,driver.findElement(By.cssSelector("#login > div.auth-form-body.mt-3")));
	}
public static void highlight(WebDriver driver, WebElement element) {
	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
	

	WebElement email=driver.findElement(By.xpath("//*[@id=\"login_field\"]"));
	if(email.isDisplayed()) {
		if(email.isEnabled()) {
			email.sendKeys("voorandurusujanvenkat@gmail.com");
		}
		System.err.println("email textbox is not enabled");
	}
	System.err.println("email text box is not displayed");
	}
}

