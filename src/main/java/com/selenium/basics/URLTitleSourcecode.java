package com.selenium.basics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class URLTitleSourcecode {
	public static void main(String args[]) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://vtop.vitap.ac.in/vtop/login");
		driver.manage().window().maximize();
		String url=driver.getCurrentUrl();//returns what url it accessed
		String titleofpage=driver.getTitle();//gives title of that page
		String sourcecode=driver.getPageSource();//gives source code of that page
		System.out.println(url);
		System.out.println(titleofpage);
		System.out.println(sourcecode);
		driver.quit();
	}
}
