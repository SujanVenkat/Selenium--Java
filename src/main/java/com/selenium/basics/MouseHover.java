package com.selenium.basics;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class MouseHover {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.orangehrm.com/en/");
		Actions actions=new Actions(driver);//now for performing mouse actions we send driver in Actions class
		actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a"))).perform();//pass the target element to click 
		Thread.sleep(3000);
		actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/div/div/div/div/ul/li[1]"))).perform();//pass the target element to click
		actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/div/div/div/div/ul/li[1]/div/div/h6[2]/a"))).click().perform();
		Thread.sleep(3000);
		actions.doubleClick(driver.findElement(By.xpath("/html/body/div/div/div[1]"))).perform();//it will highlight the specified element like (double click)
		Thread.sleep(3000);
		actions.contextClick(driver.findElement(By.xpath("/html/body/div/div/div[1]"))).perform();//context click mean it will do right click on that element
		Thread.sleep(40000);
		driver.findElement(By.xpath("")).click();
		Thread.sleep(3000);
	    driver.quit();
	}
}