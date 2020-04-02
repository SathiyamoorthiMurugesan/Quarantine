package selenium;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertScreentshot {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.home") + "\\eclipse-workspace\\quarentine\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.toolsqa.com/handling-alerts-using-selenium-webdriver/");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
//		https://www.techlistic.com/2016/06/top-6-demo-websites-for-practice.html
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("here"))));
		NormalScreenshot(driver);
		driver.findElement(By.id("cookie_action_close_header")).click();
		NormalScreenshot(driver);

		driver.findElement(By.xpath("//button[contains(text(),'Simple Alert')]")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		//To take screen shot of the alert using selenium getScreenshotAs method, but we will get unhandle alert exception.
		NormalScreenshot(driver);
		Thread.sleep(3000);
		alert.accept();
	}

	public static void NormalScreenshot(WebDriver driver) throws IOException {
			
		 Date date = new Date(); SimpleDateFormat dateformat = new
		 SimpleDateFormat("yyyy-MM-dd HH-mm-ss"); 
		 TakesScreenshot tss =  (TakesScreenshot) driver; File file = tss.getScreenshotAs(OutputType.FILE);
		 //In order to use the FileUtils, we need to import common.io jar
		 FileUtils.copyFile(file, new File("C:\\Users\\ELCOT\\eclipse-workspace\\quarentine\\screenshots\\" 
		 + dateformat.format(date) + ".png"));
			 
	}

}
