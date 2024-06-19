package com.selenium.basics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class AlertHandling {
	public static void main(String args[]) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		driver.manage().window().maximize();
//for alert box
		System.out.println(driver.findElement(By.xpath("//*[@id=\"post-body-2252040019981508971\"]/div/div[4]")).getText());
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"alertBox\"]")).click();
		Thread.sleep(3000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.xpath("//*[@id=\"post-body-2252040019981508971\"]/div/div[4]")).getText());
		driver.navigate().refresh();
//for confrim box		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"post-body-2252040019981508971\"]/div/div[4]")).getText());
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"confirmBox\"]")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.xpath("//*[@id=\"post-body-2252040019981508971\"]/div/div[4]")).getText());
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@id=\"confirmBox\"]")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		System.out.println(driver.findElement(By.xpath("//*[@id=\"post-body-2252040019981508971\"]/div/div[4]")).getText());
//prompt box
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@id=\"promptBox\"]")).click();
		driver.switchTo().alert().sendKeys("sujan");
		driver.switchTo().alert().accept();
		
		
	}

}
