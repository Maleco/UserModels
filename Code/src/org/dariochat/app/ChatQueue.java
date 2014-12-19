package org.dariochat.app;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ChatQueue
{
	//final int size = movies.length;
	final int size = 16;
	int count;
	boolean askFollowUp;
	int tagIndex, movieIndex, top3Index;
	JFrame frame = null;
	boolean chatDiff;
	int condition; //houd bij welke conditie je doet
	
	String tags[] = {
			// events after which user needs to maintain problem state
			"browser focus", "browser link1", "browser link2", "compose type", // "mail reply" "browser home", ambiguous
			// events after which user does not need to maintain problem state
			"mail select", "compose send", "browser link3", "mail move"
	};

	static String movies[] =
	{
		"Slumdog Millionaire", "The Curious Case of Benjamin Button", "Frost/Nixon", "Milk", "The Reader",
		"No Country For Old Men", "Atonement", "Juno", "Michael Clayton", "There Will Be Blood" ,
		"The Departed", "Babel","Letters From Iwo Jima", "Little Miss Sunshine", "The Queen",
		"Crash", "Brokeback Mountain", "Capote", "Good Night, and Good Luck", "Munich",
		"Million Dollar Baby", "The Aviator", "Finding Neverland", "Ray", "Sideways",
		"The Lord Of The Rings: The Return Of The King", "Lost In Translation", "Master and Commander: The Far Side of the World", "Mystic River", "Seabiscuit",
		"Chicago", "Gangs of New York", "The Hours", "The Lord of the Rings: The Two Towers", "The Pianist",
		"A Beautiful Mind", "Gosford Park", "In the Bedroom", "The Lord of the Rings: The Fellowship of the Ring", "Moulin Rouge" ,
		"Gladiator", "Chocolat", "Crouching Tiger, Hidden Dragon", "Erin Brockovich", "Traffic" ,
		"American Beauty", "The Cider House Rules", "The Green Mile", "The Insider", "The Sixth Sense"
	};
	
	static String top3[] =
	{
		  "radio broadcasting", "CD", "song", "female artist", "male artist", 
		  "band", "music style", "actor", "actress", "movie",
		  "tv show/program", "TV station", "Dutch celebrity", "book", "country",
		  "Dutch city", "foreign city", "shop", "brand of clothing", "electronic brand",
		  "animal", "pet", "car", "sport", "school subject",
		  "teacher", "sports team", "company/organization", "website", "board game",
		  "game", "dessert", "candy", "meal", "drink",
		  "activity", "quote", "cartoon", "breakfast", "comic"
		
	};
	
	void setChatDiff(boolean newDiff){
		chatDiff = newDiff;
	}
	
	static Boolean followup[];

	ChatQueue ()
	{
		count = 0;
		askFollowUp = false;
		tagIndex = 0;
		movieIndex = 0;
		top3Index = 0;
		chatDiff = false;
		condition = 0;
		
		followup = new Boolean[size];
		for (int i=0 ; i<size/2 ; i++)
		{
			followup[i] = new Boolean (true);
			followup[i+size/2] = new Boolean (false);
		}
		
		Utilities.shuffle (tags);
		Utilities.shuffle (movies);
		Utilities.shuffle (top3);
		Utilities.shuffle (followup);
	}

	boolean isNext (String window, String event)
	{
		//if (count >= size && !askFollowUp) DarioAppMain.exit();
		
		if (count >= size && !askFollowUp) {
			//DarioAppMain.chat.dispose();
			//DarioAppMain.mail.dispose();
			//DarioAppMain.browser.dispose();
			count = 0;
			if(condition == 3){
				JOptionPane.showMessageDialog(frame, "This is the end of the experiment. You may call your experimenter.");
				DarioAppMain.exit();
			}else{
				JOptionPane.showMessageDialog(frame, "Take a short break and move on when you are ready");
			condition++;
			}
		}
		
		
		String tag = window + " " + event;
		return tag.startsWith (tags[tagIndex]);
	}

	String getMessage ()
	{
		//if (count >= size && !askFollowUp) DarioAppMain.exit();
		
		if (count >= size && !askFollowUp) {
			//DarioAppMain.chat.dispose();
			//DarioAppMain.mail.dispose();
			//DarioAppMain.browser.dispose();
			count = 0;
			if(condition == 3){
				JOptionPane.showMessageDialog(frame, "This is the end of the experiment. You may call your experimenter.");
				DarioAppMain.exit();
			}else{
				JOptionPane.showMessageDialog(frame, "Take a short break and move on when you are ready");
			condition++;
			}
			
		}
		
		
		String message;
		if (askFollowUp)
		{
			if(!chatDiff){
				String last = DarioAppMain.chat.lastMessage().toLowerCase();
				if (last.startsWith("y") || last.contains("yes"))
					message = "Did you like it?";
				else
					message = "Do you want to see it?";
				askFollowUp = false;
			}else{
				message = "What is your least favorite?";
				askFollowUp = false;
			}
		}
		else
		{
			if(!chatDiff){
				message = "Have you seen the movie <i>" + movies[movieIndex] + "</i> ?";
				movieIndex++;
				if (movieIndex >= movies.length) { movieIndex=0 ; Utilities.shuffle (movies); }
				askFollowUp = followup[count];
				count++;
			}else{
				message = "What is your favorite <i>" + top3[top3Index] + "</i>?";
				top3Index++;
				if (top3Index >= top3.length) { top3Index=0 ; Utilities.shuffle (top3); }
				askFollowUp = followup[count];
				count++;
			}
		}
		
		tagIndex ++;
		if (tagIndex >= tags.length) { tagIndex=0 ; Utilities.shuffle (tags); }
		
		return message;
	}
}
