package com.selenium.basics;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TicketBooking{
	public static void main(String args[]) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("start-maximized");
		WebDriver driver=new ChromeDriver(options);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(120));
		driver.get("https://karnatakatemplesaccommodation.com/e/temples/karnataka-pravasi-saudha-tirumala");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbar\"]/ul/li[9]/a")));
		driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[9]/a")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"frm-login\"]/div[1]/div[2]/input")));
		driver.findElement(By.xpath("//*[@id=\"frm-login\"]/div[1]/div[2]/input")).sendKeys("sujantestingsite@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"frm-login\"]/div[1]/div[3]/input")).sendKeys("sujankali");
		driver.findElement(By.xpath("//*[@id=\"frm-login\"]/div[2]/button[1]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"room_type\"]")));
		WebElement dropdownhandle=driver.findElement(By.xpath("//*[@id=\"room_type\"]"));
		dropdownhandle.click();
		Select singleoption=new Select(dropdownhandle);
		singleoption.selectByIndex(1);  //1-non ac} 2-non ac corner }3-ac type 1 }4-ac type 2 }5-ac type 3
		String targetDate="10/sep/2024";
		Calendar calendar = Calendar.getInstance();
		try {
			SimpleDateFormat targetDateFormat = new SimpleDateFormat("dd/MMM/yyyy");
			targetDateFormat.setLenient(false);
			Date formattedTargetDate = targetDateFormat.parse(targetDate);
			calendar.setTime(formattedTargetDate);
		} catch (Exception e) {
			throw new Exception("Invalid date is provided, please check the input date!!");
		}
		int targetMonth = calendar.get(Calendar.MONTH);
		int targetYear = calendar.get(Calendar.YEAR);
		int targetDay = calendar.get(Calendar.DAY_OF_MONTH);
		driver.findElement(By.xpath("//*[@id=\"check_in_date\"]")).click();
        //june 2024 
		String currentDate = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div")).getText();
		System.out.println(currentDate);
		calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(currentDate));
		int currentMonth = calendar.get(Calendar.MONTH);
		int currentYear = calendar.get(Calendar.YEAR);
		while(currentMonth < targetMonth || currentYear < targetYear) {
			//Thread.sleep(3000);
			driver.findElement(By.className("ui-datepicker-next")).click();
			currentDate = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div")).getText();
			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(currentDate));
			currentMonth = calendar.get(Calendar.MONTH);
			currentYear = calendar.get(Calendar.YEAR);
		}
		if(currentMonth == targetMonth && currentYear == targetYear)
			driver.findElement(By.xpath("//a[text()="+targetDay+"]")).click();
		else
			throw new Exception("unable to select the date because of current and target dates mismatch");
		//------------------------------------------
		String checkoutdate="11/sep/2024";
		Calendar calendar1 = Calendar.getInstance();
		try {
			SimpleDateFormat Format = new SimpleDateFormat("dd/MMM/yyyy");
			Format.setLenient(false);
			Date formattedcheckoutDate = Format.parse(checkoutdate);
			calendar1.setTime(formattedcheckoutDate);
		} catch (Exception e) {
			throw new Exception("Invalid date is provided, please check the input date!!");
		}
		int Month = calendar1.get(Calendar.MONTH);
		int Year = calendar1.get(Calendar.YEAR);
		int Day = calendar1.get(Calendar.DAY_OF_MONTH);
		driver.findElement(By.xpath("//*[@id=\"check_out_date\"]")).click();
        //june 2024 
		String presentDate = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div")).getText();
		System.out.println(presentDate);
		calendar1.setTime(new SimpleDateFormat("MMM yyyy").parse(presentDate));
		int presentMonth = calendar1.get(Calendar.MONTH);
		int presentYear = calendar1.get(Calendar.YEAR);
		while(presentMonth < Month || presentYear < Year) {
			//Thread.sleep(3000);
			driver.findElement(By.className("ui-datepicker-next")).click();
			presentDate = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div")).getText();
			calendar1.setTime(new SimpleDateFormat("MMM yyyy").parse(presentDate));
			presentMonth = calendar1.get(Calendar.MONTH);
			presentYear = calendar1.get(Calendar.YEAR);
		}
		if(presentMonth == Month && presentYear == Year)
			driver.findElement(By.xpath("//a[text()="+Day+"]")).click();
		else
			throw new Exception("unable to select the date because of current and target dates mismatch"); 
		driver.findElement(By.xpath("//*[@id=\"no_of_guests\"]")).sendKeys("2");
		driver.findElement(By.xpath("//*[@id=\"no_of_child\"]")).sendKeys("0");
		driver.findElement(By.xpath("/html/body/section/div[3]/div[1]/div[1]/div/div/div[1]/div[2]/form/div[1]/div[7]/div/input[1]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"person_name_1\"]"))).sendKeys("sujan");
		driver.findElement(By.xpath("//*[@id=\"person_email_1\"]")).sendKeys("sujantestingsite@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"person_mobile_1\"]")).sendKeys("7842271175");
		driver.findElement(By.xpath("//*[@id=\"person_age_1\"]")).sendKeys("21");
		WebElement gender1=driver.findElement(By.xpath("//*[@id=\"person_gender_1\"]"));
		Select genderselect=new Select(gender1);
		genderselect.selectByIndex(1);
		driver.findElement(By.xpath("//*[@id=\"person_name_2\"]")).sendKeys("venkat");
		driver.findElement(By.xpath("//*[@id=\"person_email_2\"]")).sendKeys("sujantestingsite@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"person_mobile_2\"]")).sendKeys("7842271175");
		driver.findElement(By.xpath("//*[@id=\"person_age_2\"]")).sendKeys("21");
		WebElement gender2=driver.findElement(By.xpath("//*[@id=\"person_gender_2\"]"));
	    Select selecting1=new Select(gender2);
		selecting1.selectByIndex(1);// 0>male 1>female
		driver.findElement(By.xpath("//*[@id=\"otp\"]")).sendKeys("1234");
		driver.findElement(By.xpath("//*[@id=\"terms_and_conditions\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"id_proof_1\"]")).sendKeys("C:\\Users\\sujan\\Downloads\\uploadfile.png");
		driver.findElement(By.xpath("//*[@id=\"id_proof_2\"]")).sendKeys("C:\\Users\\sujan\\Downloads\\uploadfile.png");
		driver.findElement(By.xpath("//*[@id=\"add-guests-detail\"]/div[4]/div[2]/input[8]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/section/div/div[2]/div[2]/table/tbody/tr[4]/td[1]/form/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"orderBillName\"]")).sendKeys("Venkat");
		driver.findElement(By.xpath("//*[@id=\"orderBillAddress\"]")).sendKeys("korlagunta tirupathi");
		driver.findElement(By.xpath("//*[@id=\"orderBillZip\"]")).sendKeys("517501");
		driver.findElement(By.xpath("//*[@id=\"orderBillTel\"]")).sendKeys("7842271175");
		driver.findElement(By.xpath("//*[@id=\"orderBillEmail\"]")).sendKeys("sujantestingsite@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"OPTUPI\"]/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"pay-by-qrcode\"]/div[2]/span[1]/a/div[2]")).click();
		Thread.sleep(5000);
		driver.quit();
     	}
}

