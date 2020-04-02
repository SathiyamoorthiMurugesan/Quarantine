package selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandling {

	public static void main(String[] args) {
		
		  System.setProperty("webdriver.chrome.driver",System.getProperty("user.home")+"\\eclipse-workspace\\quarentine\\drivers\\chromedriver.exe") ;
		  WebDriver driver = new ChromeDriver();
		  driver.get("https://www.toolsqa.com/handling-alerts-using-selenium-webdriver/");
		  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
//		  https://www.techlistic.com/2016/06/top-6-demo-websites-for-practice.html
		  driver.manage().window().maximize();
		  WebDriverWait wait = new WebDriverWait(driver, 5);
		  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("here"))));
		  driver.findElement(By.id("cookie_action_close_header")).click();
		  
		  driver.findElement(By.xpath("//button[contains(text(),'Simple Alert')]")).click();
		  wait.until(ExpectedConditions.alertIsPresent());
		  Alert alert = driver.switchTo().alert();
		  System.out.println(alert.getText());
		  alert.accept();
		  
		  driver.findElement(By.xpath("//button[contains(text(),'Confirm Pop up')]")).click();
		  System.out.println(alert.getText());
		  alert.dismiss();
		  
		  driver.findElement(By.xpath("//button[text()='Prompt Pop up']")).click();
		  System.out.println(alert.getText());
		  alert.sendKeys("Yes");
		  alert.accept();
		  
	}
}
