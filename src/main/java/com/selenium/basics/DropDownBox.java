package com.selenium.basics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
public class DropDownBox {
	public static void main(String args[]) throws Exception{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		driver.manage().window().maximize();
		WebElement singleselectdropdown=driver.findElement(By.xpath("//*[@id=\"course\"]"));
		Select selectionelement=new Select(singleselectdropdown);
		selectionelement.selectByIndex(2);
		Thread.sleep(10000);
		selectionelement.selectByValue("python");
		selectionelement.selectByVisibleText("Javascript");
		///same for multiple select dropdown boxes it will select multiple  unlike single select dropdown boxes
		//we can deselect in multipledropdownboxes
		
	}
	

}
