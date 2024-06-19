package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Instagram {
	public static void main(String args[]) throws Exception{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.instagram.com/");
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[1]/div/label/input")).sendKeys("sujan_pro_max");
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/div/label/input")).sendKeys("lsdlkjflkds");
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//*[@id=\"loginForm\"]/span/div")).getText());
		
		
	}

}
