package com.selenium.basics;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class WindowHandle {
	public static void main(String args[]) throws Exception{
        WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		String parentwindowhandle=driver.getWindowHandle();//storing parent window in variable parentwindowhandle
		System.out.println("parent window handle  "+parentwindowhandle+driver.getTitle());//it gives page title
		driver.findElement(By.xpath("//*[@id=\"newWindowBtn\"]")).click();
		Set<String> windowhandles=driver.getWindowHandles();//storing all windows in integer set
		for(String windowhandle :windowhandles) {
			if(!windowhandle.equals(parentwindowhandle)) {//ignoring parent window and sending child window
				driver.switchTo().window(windowhandle);//switching here 
				driver.manage().window().maximize();
				driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("sujan");
				Thread.sleep(3000);
				driver.close();
				Thread.sleep(3000);
			}
		}
			driver.switchTo().window(parentwindowhandle);
			driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("sujan");
			Thread.sleep(3000);
			driver.quit();	
		}
}
