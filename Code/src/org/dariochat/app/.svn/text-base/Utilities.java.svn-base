package org.dariochat.app;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.Random;


public class Utilities
{
	static Color myLightGray = new Color (236,236,236);
	static Color myDarkGray = new Color (175,175,175);
	static Color mailBlue = new Color (222,228,234);

	static DecimalFormat df1 = new DecimalFormat ("#.0");
	static DecimalFormat df2 = new DecimalFormat ("#.00");
	static DecimalFormat df3 = new DecimalFormat ("#.000");
	static DecimalFormat df4 = new DecimalFormat ("#.0000");
	static DecimalFormat df5 = new DecimalFormat ("#.0000");

	static Random random = new Random (System.currentTimeMillis());

	static int sign (double x) { return (x >= 0) ? 1 : -1; }
	static double sqr (double x) { return (x*x); }

	static int sec2ms (double x) { return (int) (Math.round(x*1000)); }

	static void shuffle (Object a[])
	{
		for (int i=0 ; i<a.length-1 ; i++)
		{
			int ri = i + 1 + random.nextInt (a.length - i - 1);
			Object tmp = a[i];
			a[i] = a[ri];
			a[ri] = tmp;
		}
	}
	
	static PrintStream uniqueOutputFile (String name) 
	{
		int num = 1;
		File file;
		String filename;
		do  {
			filename = name + num + ".txt";
			file = new File (filename);
			num++;
		} while (file.exists());
		PrintStream stream = null;
		try {
			stream = new PrintStream (new FileOutputStream (file));
		}
		catch (FileNotFoundException e) { e.printStackTrace(); }
		return stream;
	}
}
