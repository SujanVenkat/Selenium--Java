package com.selenium.basics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
class Click{
	public static void main(String args[]) throws Exception {
	WebDriver driver1=new ChromeDriver();
	driver1.get("https://www.hyrtutorials.com/p/basic-controls.html");
	driver1.manage().window().maximize();
	driver1.findElement(By.xpath("//*[@id=\"femalerb\"]")).click();
	driver1.findElement(By.xpath("//*[@id=\"englishchbx\"]")).click();
	driver1.findElement(By.xpath("//*[@id=\"hindichbx\"]")).click();
	WebElement chinesebox=driver1.findElement(By.xpath("//*[@id=\"chinesechbx\"]"));
	chinesebox.click();//here it will tick it 
	Thread.sleep(3000);
	if(chinesebox.isSelected()) {
		chinesebox.click();
	}
	driver1.findElement(By.xpath("//*[@id=\"registerbtn\"]")).click();
	System.out.println(driver1.findElement(By.xpath("//*[@id=\"msg\"]")).getText());
	driver1.findElement(By.xpath("//*[@id=\"navigateHome\"]")).click();
	
	
	}
	
}


