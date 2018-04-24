package com.SikuliScipt.myPack;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class notepad {

	public static void main(String []ar) throws FindFailed, InterruptedException
	{
		Screen s = new Screen();
		try {
			s.find("Snap 2017-07-29 at 13.41.30.png");
			System.out.println("image found...");
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			System.out.println("Image not find..");
			e.printStackTrace();
		}
		s.click("Snap 2017-07-29 at 13.41.30.png");
		Thread.sleep(5000);
		s.click("Snap 2017-07-29 at 13.41.30.png");
		Thread.sleep(5000);
		System.out.println("notepad writing");
		s.find("Notepad.png");
		
		s.type("Notepad.png","Sikuli image recognition...");
		System.out.println("recognition complete//.....");
	}
	
}
