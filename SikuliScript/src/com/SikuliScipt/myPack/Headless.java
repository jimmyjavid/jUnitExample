package com.SikuliScipt.myPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Headless {

	public static void main(String[] args) throws InterruptedException
	{ long initialtime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
	
	 System.out.println("initial time "+initialtime*1000);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed.javed\\Music\\chromedriver.exe");

		  ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("disable-extensions");
		options.addArguments("test-type", "allow-no-sandbox-job", "no-sandbox");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		capabilities.setCapability("unexpectedAlertBehaviour", "ignore");
		capabilities.setCapability("handlesAlerts", false);
		
		WebDriver driver = new ChromeDriver(capabilities);
		
 
		driver.get("http://www.avonromance.com");
		System.out.println("title"+driver.getTitle());
		long endtime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
		int timedifference = (int) ((endtime - initialtime)/1000);
		System.out.println("end time;;"+endtime);
		System.out.println();
		System.out.println("Total time difference = "+timedifference);
		driver.manage().window().maximize();
		System.out.println("Headless execution starts here....");
		driver.findElement(By.xpath("(//a[@href='Company.html'])[1]")).click();
		System.out.println("firsr click done..");
		//Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@href='News.html'])[1]")).click();
		System.out.println("second click done..");
		//Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@href='Contact.php'])[1]")).click();
		System.out.println("Third click done..");
		//Thread.sleep(3000);
		
		
		
		System.out.println("end time;;"+(System.currentTimeMillis()/1000)%60);
		System.out.println();
		System.out.println("Total time difference = "+timedifference);
	}
}
