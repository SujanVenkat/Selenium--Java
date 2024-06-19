package com.selenium.basics;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;

public class ExplicitWait {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));//it will wait till 30 seconds till if not found throws exception
        driver.get("https://www.tcsion.com/?login=true&ref=https://www.tcsion.com/iDH/India/Dashboard/course_detail/7061005/1");
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"divLogin\"]/div/div/div[1]/button/span")));//it will not execute the next steps till it find specified element >it waits
        driver.findElement(By.xpath("//*[@id=\"divLogin\"]/div/div/div[1]/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"cookieModal_CM\"]/div/div[1]/div[3]/button[2]/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"tcsHeader\"]/div[1]/div/div[3]/div/button[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"userid_temp\"]")).sendKeys("voorandurusujanvenkat@gmail.com");
        Thread.sleep(3000);
        driver.quit();
    }
}
