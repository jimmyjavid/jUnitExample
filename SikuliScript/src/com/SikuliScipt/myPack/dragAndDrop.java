package com.SikuliScipt.myPack;

import java.awt.Image;
import java.lang.reflect.GenericArrayType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class dragAndDrop {
	public static void main(String[] args) throws FindFailed, InterruptedException {
		Settings.OcrTextSearch = true;
		Settings.OcrTextRead = true;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ahmed.javed\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://dsportal.fsidev.co.uk/sathish/WebApp/Index/#");
		// driver.manage().window().maximize();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("Sakshi");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("XgK8xu");
		driver.findElement(By.xpath("//body/div/div[2]/div/section/form/div[3]/div/input[3]")).click();
		Thread.sleep(10000);

		driver.findElement(
				By.xpath("//ul[@id='menu']/li/a/i[@class='menu-icon icon-webapplicationmenugroup icon-white']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//ul[@id='menu']/li/ul/li/a/i[@class='menu-icon icon-webapp-index icon-black']"))
				.click();
		Thread.sleep(20000);
		driver.findElement(By
				.xpath("(//section//div[@class='app-tree jstree jstree-0 jstree-focused jstree-apple']/ul/li)[16]/ins"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By
				.xpath("//section//div[@class='app-tree jstree jstree-0 jstree-focused jstree-apple']/ul/li[16]/ul/li/ins"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By
				.xpath("//section//div[@class='app-tree jstree jstree-0 jstree-focused jstree-apple']/ul/li[16]/ul/li/ul/li/a"))
				.click();

		Thread.sleep(60000);
		Screen s = new Screen();
		String imgToDrag = "D:\\Workspace1\\SikuliScript\\button.png";
		System.out.println("image to be dragged..." + imgToDrag);
		// Pattern ptnImgToDrag = new Pattern(imgToDrag);
		
		Match imageLoc = s.find("imgToDrag");
		s.dragDrop(imageLoc, imageLoc.offset(new Location(imageLoc.getX() + 500, imageLoc.getY() + 700)));

		// s.dragDrop(imageLoc,imageLoc.offset(new
		// Location(imageLoc.getX()+500,imageLoc.getY()+500)));

		System.out.println("dragged and dropped successfullyy");

	}
}
