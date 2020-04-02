package selenium;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertRobotScreenshot {

	public static void main(String[] args) throws AWTException, IOException, InterruptedException{
		 System.setProperty("webdriver.chrome.driver",System.getProperty("user.home")+ "\\eclipse-workspace\\quarentine\\drivers\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://www.toolsqa.com/handling-alerts-using-selenium-webdriver/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		 driver.findElement(By.id("cookie_action_close_header")).click();
		 driver.findElement(By.xpath("//button[contains(text(),'Simple Alert')]")).click();
		 Alert alert = driver.switchTo().alert();
		 System.out.println(alert.getText());
		 RobotScreenshot();
//		 Here we need to hold the program else our next line will execute and 
//		 Robot class will take screen shot of whatever screen will comes after execution
		 Thread.sleep(3000);
		 alert.accept();
	}
	
	public static void RobotScreenshot() throws AWTException, IOException {
		Date date = new Date(); 
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"); 
		Robot robot = new Robot();
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage fullscreenshot = robot.createScreenCapture(screenRect);
		ImageIO.write(fullscreenshot, "png", new File("C:\\Users\\ELCOT\\eclipse-workspace\\quarentine\\screenshots\\" 
				 + dateformat.format(date) + ".png"));
	}

}
