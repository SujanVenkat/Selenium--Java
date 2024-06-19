package com.selenium.basics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Frames {
	public static void main(String args[]) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.switchTo().frame("frm3");//without using switching to that particular frame the driver cant find that frame inside at driver variable will have the instances of main web page only .if you have different frames in a single webpage then switch to frame by iframe id
		Thread.sleep(3000);
	   driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("sujan");
	   Thread.sleep(3000);
		driver.switchTo().defaultContent();//again switch to main content
		driver.quit();
	}
}
