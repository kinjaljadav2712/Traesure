package Assignment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationTestCases {
	WebDriver driver;

	@BeforeClass
	public void setup()
	{


		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();



		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);

		driver.get("https://app.tcloud.dev.anqlave.io/auth/signin"); //Url

	}
	@Test
	public void SigninTest1() throws InterruptedException{

		driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("kinjaljadav271287@gmail.com");
		driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("Jainam121110");
		driver.findElement(By.id("signin-button")).click();

		Thread.sleep(2000);


	}
	@Test
	public void Upload() throws InterruptedException, AWTException {

		driver.findElement(By.xpath("//button[@aria-label='Add files or folders']")).click();



		driver.findElement(By.xpath("//div[contains(text(),'Upload files')]")).click();
		Thread.sleep(3000);

		Robot robot = new Robot();

		StringSelection filepath = new StringSelection("C:\\Users\\Wilton\\Desktop\\Treasure - Treas.png\\");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(2000);

		robot.keyRelease(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		System.out.println("File uploaded successfully");

		Thread.sleep(2000);



		driver.findElement(By.xpath("//*[@id=\"cdk-drop-list-0\"]/tr[1]/td[3]/mat-icon[1]")).click();
		driver.findElement(By.xpath("/html/body/app-root/div/app-browser-layout/div/mat-sidenav-container/mat-sidenav-content/app-drive/app-file-browser/div[2]/mat-toolbar/mat-toolbar-row/div[2]/button[3]/span[1]/mat-icon")).click();



		driver.findElement(By.xpath("//div[@class='ng-star-inserted']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[normalize-space()='Logout']")).click();


	}

}