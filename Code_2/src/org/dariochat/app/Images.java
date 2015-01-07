package org.dariochat.app;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;


public class Images
{
	static String imageNames[] = {"figure", "reply", "forward", "mail", "compose", "responded", "forwarded", "back", "home"};
	static int numImages = imageNames.length;
	static Image images[];

	static void initialize ()
	{
		images = new Image[imageNames.length];
		for (int i=0 ; i<imageNames.length ; i++)
		{
			images[i] = getImageFromFile (imageNames[i]+".jpg");
		}
	}

	static Image getImage (int i) { return images[i]; }

	public static Image getImageFromFile (final String name)
	{
		Image image = null;
		URL url = DarioAppMain.class.getResource ("/resources/images/" + name);
		image = Toolkit.getDefaultToolkit().getImage (url);
		return image;
	}
}
