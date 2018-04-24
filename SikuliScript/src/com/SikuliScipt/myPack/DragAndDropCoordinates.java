package com.SikuliScipt.myPack;

import java.awt.Point;

import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.crestech.opkey.plugin.KeywordLibrary;
import com.crestech.opkey.plugin.communication.contracts.functionresult.FunctionResult;
import com.crestech.opkey.plugin.communication.contracts.functionresult.Result;
import com.crestech.opkey.plugin.sikuliplugin.SikuliObject;
import com.crestech.opkey.plugin.webdriver.Finder;
import com.crestech.opkey.plugin.webdriver.exceptionhandlers.ObjectNotFoundException;
import com.crestech.opkey.plugin.webdriver.exceptionhandlers.ToolNotSetException;
import com.crestech.opkey.plugin.webdriver.object.WebDriverObject;

public class DragAndDropCoordinates implements KeywordLibrary {

	public FunctionResult Method_DragDropCoordinate(SikuliObject ImageToDrag, WebDriverObject object, int x, int y) throws FindFailed, InterruptedException, ToolNotSetException, ObjectNotFoundException {
		String imgToDrag = ImageToDrag.getImagePath();
		System.out.println("image to be dragged..." + imgToDrag);
		Screen s = new Screen();
		/*Match imageLoc = s.find(imgToDrag);
		 s.dragDrop(imageLoc,imageLoc.offset(new Location(imageLoc.getX()+x,imageLoc.getY()+y)));
		 */
		
		WebElement element = Finder.findWebElement(object);
			
		Pattern ptrn = new Pattern(imgToDrag);

		s.dragDrop(ptrn.similar(ImageToDrag.getMatchPercentage()),
				new Location(ptrn.getTargetOffset().x + x, ptrn.getTargetOffset().y + y));
		System.out.println("dragged and dropped successfullyy");
		return Result.PASS().setOutput(true).make();
	}

}
