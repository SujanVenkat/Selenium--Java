package com.selenium.basics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {
	public static void main(String args[]) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://vtop.vitap.ac.in/vtop/login");
		//driver.manage().window().maximize();
		File sourcefile=driver.getScreenshotAs(OutputType.FILE);//here it will take screenshot and store as file in sourcefile variable
		File destinationfile=new File("C:\\Users\\sujan\\OneDrive\\Documents\\basics\\basics\\Photos\\img2.png");//here it will create new file in specified path and mention file name with what should be saved
		try {
			FileUtils.copyFile(sourcefile,destinationfile);//it copies that file into path mentioned above
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("screenshot saved successfully");
		driver.quit();
	}

}
