package com.selenium.basics;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoadTime {
	public static void main(String args[]) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);//here we set as 5 seconds if page doesnot even for 5 sec then it throw exception
		Instant starttime=Instant.now();//current time before start
		System.out.println(starttime);
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
		Instant endtime=Instant.now();//end time after opening web page
		System.out.println(endtime);
		Duration duration=Duration.between(starttime, endtime);//it shows difference in time in seconds
		System.out.println(duration);
		driver.quit();
	}

}
