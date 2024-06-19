package com.selenium.basics;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Maximize {
	public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();//while opening itself you need in full screen you can use this and add argument and pass it in chrome opening constructor
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);//passing here
        driver.get("https://www.tcsion.com/?login=true&ref=https://www.tcsion.com/iDH/India/Dashboard/course_detail/7061005/1");
        driver.quit();

}
	
}
