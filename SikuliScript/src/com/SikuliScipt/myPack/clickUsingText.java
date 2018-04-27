package com.SikuliScipt.myPack;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crestech.opkey.plugin.KeywordLibrary;
import com.crestech.opkey.plugin.ResultCodes;
import com.crestech.opkey.plugin.communication.contracts.functionresult.FunctionResult;
import com.crestech.opkey.plugin.communication.contracts.functionresult.Result;
import com.crestech.opkey.plugin.contexts.Context;
import com.crestech.opkey.plugin.webdriver.Finder;
import com.crestech.opkey.plugin.webdriver.exceptionhandlers.ArgumentDataMissingException;
import com.crestech.opkey.plugin.webdriver.exceptionhandlers.ObjectNotFoundException;
import com.crestech.opkey.plugin.webdriver.exceptionhandlers.ToolNotSetException;
import com.crestech.opkey.plugin.webdriver.keywords.Utils;

public class clickUsingText implements KeywordLibrary{
	public static boolean findInWholeHtml = false;
	public static void main(String[] args) throws InterruptedException, ToolNotSetException, ObjectNotFoundException, ArgumentDataMissingException
	{ System.setProperty("webdriver.gecko.driver", "C:\\Users\\ahmed.javed\\Downloads\\geckodriver-v0.18.0-win32\\geckodriver_32.exe");
		WebDriver driver = new FirefoxDriver();
		Context.session().setTool(driver);
		driver.get("http://cresconnect.crestechglobal.com/");
		Thread.sleep(20000);
		clickUsingText obj = new clickUsingText();
		obj.Custom_clickTextUsingText("Password", 0, false, "input", false, 1);
	}

	public FunctionResult Custom_clickTextUsingText(String textSearch, int index, boolean isContains, String TagName, boolean before, int tagIndex)
			throws InterruptedException, ToolNotSetException, ObjectNotFoundException, ArgumentDataMissingException {
		new Utils().someChecksBeforeTextKeywords();
		System.out.println("Inside Method_clickTextUsingText");
		Boolean foundByPlaceholder = false;
		// System.out.println("xyZ");
		findInWholeHtml = false;
		textSearch = textSearch.trim();
		TagName = TagName.trim();

		if (textSearch.trim().length() == 0) {
			return Result.FAIL(ResultCodes.ERROR_ARGUMENT_DATA_MISSING).setMessage("Text is not provided").setOutput(false).make();
		}
		List<WebElement> eles = new ArrayList<>();
		try {
			eles = Finder.findElementByText(textSearch, isContains, index);

		} catch (Exception e) {
			// e.printStackTrace();
			return Result.FAIL(ResultCodes.ERROR_OBJECT_NOT_FOUND).setOutput(false)
					.setMessage("No Object Found With Text <" + Context.current().getFunctionCall().getDataArguments().getDataArgument().get(0).getValue() + ">").make();
		}
		// System.out.println("ELEMENT SIZE" + eles.size());
		// Finder.printList(eles);
		if (eles.size() == 0) {
			return Result.FAIL(ResultCodes.ERROR_OBJECT_NOT_FOUND).setOutput(false)
					.setMessage("No Object Found With Text <" + Context.current().getFunctionCall().getDataArguments().getDataArgument().get(0).getValue() + ">").make();
		}
		String xpath;
		WebElement ele = eles.get(index);
		/*
		 * System.out.println("ELE = " + ele); if (findInWholeHtml) { ele =
		 * eles.get(eles.size() - 1); } else { for (int p = index; p <
		 * eles.size(); p++) { try { eles.get(p).getText(); ele = eles.get(p);
		 * break; } catch (Exception ex) { } } } String forAttr =
		 * ele.getAttribute("for"); System.out.println("ELE1 = " + ele);
		 * System.out.println(forAttr != null && !forAttr.isEmpty()); if
		 * (forAttr != null && !forAttr.isEmpty()) { WebElement editBox =
		 * Finder.findWebDriver().findElement(By.id(forAttr)); if (editBox !=
		 * null) { ele.click(); editBox.clear(); //editBox.sendKeys(textValue);
		 * String tagName = editBox.getTagName();
		 * if(tagName.equalsIgnoreCase(TagName)){ editBox.click(); } return
		 * Result.PASS().setOutput(true).make(); } }
		 */

		// System.out.println(ele.getAttribute("outerHTML"));
		// System.out.println("@@@@@@@@@@@@@@@@@@@@@" +
		// ele.getAttribute("type"));
		List<WebElement> list = new ArrayList<WebElement>();

		if (before) {
			System.out.println("before");
			xpath = "./preceding::" + TagName + "]";
			System.out.println("xpath obtained is****:--"+xpath);
			list = ele.findElements(By.xpath(xpath));
			// System.out.println("Size: " + list.size() + " Xpath: " +
			// xpath);
		} else {
			// for placeholder
			System.out.println("After");
			String xpathForPlaceholder = "./following::" + TagName + "";
			System.out.println("xpath obtained is****:--"+xpathForPlaceholder);
			// WebElement eleForPlaceholder = null;
			try {
				list = ele.findElements(By.xpath(xpathForPlaceholder));
				System.out.println("size of list is:$$###"+list.size());
			} catch (Exception e) {
				e.printStackTrace();
			}
			/*
			 * if (eleForPlaceholder != null) { System.out.println("eph : " +
			 * eleForPlaceholder); foundByPlaceholder = true; } else {
			 * System.out.println("eph else : "); xpath =
			 * ".//input | ./textarea | ./input[@type='text' or @type='email' or @type='password' or not(@type) or @type='number' or @type='search' or @type='tel' or @type='url' or @type='date' or @type='datelocal' or @type='datetime-local' or @type='month' or @type='time' or @type='week'] | ./following::textarea | ./following::input[@type='text' or @type='email' or @type='password' or not(@type) or @type='number' or @type='search' or @type='tel' or @type='url' or @type='date' or @type='datelocal' or @type='datetime-local' or @type='month' or @type='time' or @type='week']"
			 * ; list = ele.findElements(By.xpath(xpath)); }
			 */
			// System.out.println("Size: " + list.size() + " Xpath: " +
			// xpath);
		}

		/*
		 * if (!foundByPlaceholder) { System.out.println("!foundByPlaceholder");
		 * if (list.size() > 0) { if (before) { ele = list.get(list.size() - 1);
		 * 
		 * } else { ele = list.get(0);
		 * System.out.println(ele.getAttribute("outerHTML")); } } }
		 */
		// for (WebElement webElement : list) {
		// System.out.println("webElement" +
		// webElement.getAttribute("outerHTML"));
		// break;
		// }

		
		//Currently in branch of Branch....
		
		if (ele != null) {
			System.out.println("LAst Ele : " + ele.getAttribute("outerHTML"));
			list.get(tagIndex).click();
			return Result.PASS().setOutput(true).make();
		}

		return Result.FAIL(ResultCodes.ERROR_OBJECT_NOT_FOUND)
				.setMessage("No Object Found With Text <" + Context.current().getFunctionCall().getDataArguments().getDataArgument().get(0).getValue() + ">").setOutput(false).make();
	}

}
