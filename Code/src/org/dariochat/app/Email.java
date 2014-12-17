package org.dariochat.app;

import java.text.*;
import java.util.*;

import javax.swing.ImageIcon;

// Create a *random* email for the task
public class Email
{
	String from, subject, date, shortDate;
	int productIndex;
	String body;
	int status;

	static String firstNames[] = {"John"};
	static String lastNames[] = {"Doe"};
	static String subjects[] = {"question", "request", "information"};
	
	Email ()
	{
		Random r = new Random();

		String firstName = firstNames[r.nextInt(firstNames.length)];
		from = firstName + " " + lastNames[r.nextInt(lastNames.length)];
		
		subject = subjects[r.nextInt(subjects.length)];
		
		Date currentDate = new Date();
		SimpleDateFormat df = new SimpleDateFormat ("M/dd/yy h:mm aaa"); //("EEE MMM d yyyy h:mm aaa");
		date = df.format (currentDate);
		
		df = new SimpleDateFormat ("h:mm aaa");
		shortDate = "Today " + df.format (currentDate);

		productIndex = Utilities.random.nextInt(99);
		
		String product = Products.getBrandModel (productIndex);
		ImageIcon screenshot = new ImageIcon("/resources/images/ScreenshotsIntro/Intro-vraag1.png");
		body = "What is the price of " + product + "?<br><br>Tnx,<br>" + firstName;
		
		
		
		status = 0;
	}
	
	String bodyHTML ()
	{
		return "<html>" +
		"<table cellspacing=0 cellpadding=1><tr><td align=right>From:&nbsp;</td><td>" + from + "</td></tr>" +
		"<tr><td align=right>Subject:&nbsp;</td><td>" + subject + "</td></tr>" +
		"<tr><td align=right>Date:&nbsp;</td><td>" + date + "</td></tr>" +
		"</table><hr><br>" +
		body + "</html>";
	}
}
