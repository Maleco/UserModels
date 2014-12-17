package org.dariochat.app;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;


public class Images
{
	static String imageNames[] = {"figure", "reply", "forward", "mail", "compose", "responded", "forwarded", "back", "home"};
	static int numImages = imageNames.length;

	static Image images[] = null;
	static Image screenshots[] = null;

	static void initialize ()
	{
		images = new Image[imageNames.length];
		screenshots = new Image[10];
		for (int i=0 ; i<imageNames.length ; i++)
		{
			String name = imageNames[i];
			images[i] = getImageFromFile (name+".jpg");
		}		
		
		// Load the Intro screenshots
		for (int i=1; i<=5; ++i)
					screenshots[i-1] =  getImageFromFile("ScreenshotsIntro/Intro-vraag"+i+".png;");
	}

	static Image getImage (int i)
	{
		return images[i];
	}
	
	static Image getIntroImage (int i)
	{
		return screenshots[i];
	}

	public static Image getImageFromFile (final String name)
	{
		Image image = null;
		URL url = DarioAppMain.class.getResource ("/resources/images/" + name);
		image = Toolkit.getDefaultToolkit().getImage (url);
		return image;
	}
}
