package com.selenium.basics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TcsAptitude {
	public static void main(String args[]) throws Exception{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.tcsion.com/?login=true&ref=https://www.tcsion.com/iDH/India/Dashboard/course_detail/7061005/1");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"divLogin\"]/div/div/div[1]/button/span")).click();
     	driver.findElement(By.xpath("//*[@id=\"cookieModal_CM\"]/div/div[1]/div[3]/button[2]")).click();
    	driver.findElement(By.xpath("//*[@id=\"tcsHeader\"]/div[1]/div/div[3]/div/button[2]")).click();
    	Thread.sleep(10000);
	    driver.findElement(By.xpath("//*[@id=\"userid_temp\"]")).sendKeys("Voorandurusujanvenkat@gmail.com");
	    Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"confData\"]")).sendKeys("Password here");
        Thread.sleep(10000);
	    driver.findElement(By.xpath("//*[@id=\"loginExistingUser\"]")).click();
        Thread.sleep(10000);
     	driver.findElement(By.xpath("//*[@id=\"showDashboardHeader\"]/a")).click();
     	Thread.sleep(10000);
	driver.findElement(By.xpath("//*[@id=\"Left_2\"]/a")).click();
	Thread.sleep(10000);
	driver.findElement(By.xpath("//*[@id=\"otherProduct\"]/div[1]/div[3]/a")).click();
	Thread.sleep(10000);
	driver.findElement(By.xpath("//*[@id=\"continueBtn\"]")).click();
	}}