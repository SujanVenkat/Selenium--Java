package com.selenium.basics;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
public class VtopAP{
	public static void main(String args[]) throws IOException, InterruptedException, TesseractException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions selectoption=new ChromeOptions();
		selectoption.addArguments("start-maximized");
		WebDriver driver=new ChromeDriver(selectoption);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(120));
		driver.get("https://vtop.vitap.ac.in/vtop/open/page");
		driver.findElement(By.xpath("//*[@id=\"stdForm\"]/a/div/div[2]/button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"captchaStr\"]")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]")));
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("21BCE7813");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("password");
		WebElement imgelement=driver.findElement(By.xpath("//*[@id=\"captchaBlock\"]/img"));
		File imgfile=imgelement.getScreenshotAs(OutputType.FILE);
		File saving=new File("C:\\Users\\sujan\\OneDrive\\Documents\\basics\\basics\\Photos\\img3.png");
		FileUtils.copyFile(imgfile, saving);
		Thread.sleep(2000);
		ITesseract image=new Tesseract();
		String finaltext=image.doOCR(saving);
		System.out.println(finaltext);
		driver.findElement(By.xpath("//*[@id=\"captchaStr\"]")).sendKeys(finaltext);
				}
}