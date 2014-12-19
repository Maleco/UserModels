package org.dariochat.app;

import java.text.*;
import java.util.*;

import javax.swing.ImageIcon;

// Create a *random* email for the task
public class Email
{
	String from, subject, date, shortDate;
	String body;
	int status;
	int productIndex;

	static String firstNames[] = {"Henk", "Ingrid", "Piet", "Klaas", "Jan", "Roderick"};
	static String lastNames[] = {"Jansen", "de Vries", "Smilda", "InsertStandaardNaam"};
	static String subjects[] = {"question", "request", "information"};
	
	Email (int i)
	{
		Random r = new Random();

		String firstName = firstNames[r.nextInt(firstNames.length)];
		from = firstName + " " + lastNames[r.nextInt(lastNames.length)];
		
		subject = "Vraag " + (i+1);
		
		Date currentDate = new Date();
		SimpleDateFormat df = new SimpleDateFormat ("M/dd/yy h:mm aaa"); //("EEE MMM d yyyy h:mm aaa");1
		date = df.format (currentDate);
		
		df = new SimpleDateFormat ("h:mm aaa");
		shortDate = "Today " + df.format (currentDate);

		productIndex = i;
		
		body = 
				"Goedemiddag, <br><br>" + Products.getAmount(i) + "<br><br>" + 
				"Mijn wensen zijn:<br>- " + Products.getDemand1(i) + "<br>- " + Products.getDemand2(i) + "<br><br>" +
				"Zou je mij de volgende prijzen kunnen toesturen van de beste optie:" + "<br>" + 
				"- De reissom<br>- De prijs van de skipas ter plaatse<br>- De verplichte bijkomende kosten" + "<br><br>" +
				"Alvast bedankt";		
							
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
