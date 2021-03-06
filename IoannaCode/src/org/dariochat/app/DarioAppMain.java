package org.dariochat.app;

import java.awt.event.*;
import java.util.Calendar;
import javax.swing.*;

public class DarioAppMain
{
	static Mail mail;
	static Chat chat;
	static Browser browser;
	static Composer composer;
	static ChatQueue chatQueue = new ChatQueue ();
	static Data data = new Data ();
	static long startTime = 0;
	static double lastTime = 0;
	static boolean newTrial = true;
	static boolean chatdiff = false;
	static boolean[][] volgordes = new boolean[][] {
			{false,false,true,false,false,true,true,true},
			{false,true,true,true,false,false,true,false},
			{false,false,false,true,true,false,true,true},
			{true,false,true,true,false,false,false,true},
			{false,false,true,true,false,true,true,false},
			{false,true,true,false,false,false,true,true},
			
			{true,false,false,false,true,true,false,true},
			{true,true,false,true,true,false,false,false},
			{false,true,false,false,true,true,true,false},
			{true,true,true,false,false,true,false,false},
			{true,true,false,false,true,false,false,true},
			{true,false,false,true,true,true,false,false},
			
			{false,false,true,false,true,true,false,true},
			{false,true,true,true,true,false,false,false},
			{false,false,false,true,true,true,true,false},
			{true,false,true,true,false,true,false,false},
			{false,false,true,true,true,false,false,true},
			{false,true,true,false,true,true,false,false},
			
			{true,false,false,false,false,true,true,true},
			{true,true,false,true,false,false,true,false},
			{false,true,false,false,true,false,true,true},
			{true,true,true,false,false,false,false,true},
			{true,true,false,false,false,true,true,false},
			{true,false,false,true,false,false,true,true},
		};
	static boolean[] dezevolgorde = new boolean[8];
	

	static void startEvent (int delay, boolean periodic, ActionListener al)
	{
		javax.swing.Timer timer = new javax.swing.Timer (delay, al);
		timer.setRepeats (periodic);
		timer.start();
	}

	static void recordEvent (String window, String event)
	{ 
		recordEvent (window, event, "");
	}

	public static void setNewCondition(boolean newBrowserDelay, boolean newChatSet){
		browser.setDelay(newBrowserDelay);
		chatQueue.setChatDiff(newChatSet);
	}


	
	static void recordEvent (String window, String event, String extra)
	{
		long ms = Calendar.getInstance().getTimeInMillis() - startTime;
		Sample s = new Sample (.001*ms, window, event, extra);
		data.add (s);
		

			if (newTrial && chat!=null && chat.isLastFromUser() && chatQueue.isNext (window, event))
			{
				final String text = chatQueue.getMessage();
				int delay = 50 + Utilities.random.nextInt(150);
				//int delay = 5;
				startEvent (delay, false, new ActionListener() {
					public void actionPerformed (ActionEvent e) {
						chat.addMessage (false, text);
						recordEvent ("chat", "prompt", text);
					}
				});
				newTrial = false;
			}
			
		if (window.equals("mail") && event.equals("select"))
			newTrial = true;
	}

	public static void exit ()
	{
		System.exit (0);
	}
	
	
	public static void StartDarioAppMain(int browserDelay, int noisePercentage, boolean testMode){
		startTime = Calendar.getInstance().getTimeInMillis();

		Images.initialize();

		browser = new Browser (browserDelay, noisePercentage, testMode);
		browser.setVisible (true);

		chat = new Chat ();
		chat.setVisible (true);

		mail = new Mail ();
		mail.setVisible (true);

		composer = new Composer ();
		composer.setVisible (false);
		
		// should also disable CMD-` in Preferences so people don't switch windows using keystrokes!
		
		startEvent (100, true, new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				mail.setSize (700, 700);
				mail.setLocation (0, 0);
				mail.setExtendedState (JFrame.NORMAL);
				browser.setSize (700, 350); // (700,456);
				browser.setLocation (50, 100);
				browser.setExtendedState (JFrame.NORMAL);
				chat.setSize (700,220); // (700,590);
				chat.setLocation (100,240); // (100,132);
				chat.setExtendedState (JFrame.NORMAL);
				composer.setSize (650, 500);
				composer.setLocation (70, 50);
				composer.setExtendedState (JFrame.NORMAL);
			}
		});
	}
	
	public DarioAppMain(){
		int noisePercentage = 35;	// percentage of noise on delay (so amount of noise depends on size of delay)
		boolean testMode = false;	// if testMode is true, application will exit when clicking the red exit button on the browser (!) window
	
				StartDarioAppMain(3000, noisePercentage, testMode);
				setNewCondition(dezevolgorde[0], dezevolgorde[1]);
				recordEvent ("start conditie", dezevolgorde[0] + "_" +dezevolgorde[1]);
		
	}
	
	public static void main (String args[])
	{
		JFrame frame = null;
		JOptionPane.showMessageDialog(frame, "This is the start of the experiment.\n\n When you're ready, you may press 'ok' to start.");
		String participantNumber = (String)JOptionPane.showInputDialog(frame, "Your participant number:\n", "Participant number", JOptionPane.QUESTION_MESSAGE);
		String participantGender = (String)JOptionPane.showInputDialog(frame, "Your gender: (m/f):\n", "Your gender", JOptionPane.QUESTION_MESSAGE);
		String participantAge = (String)JOptionPane.showInputDialog(frame, "Your age:\n", "Your age", JOptionPane.QUESTION_MESSAGE);
		recordEvent ("participantNumber", participantNumber,"");
		recordEvent ("participantGender", participantGender,"");
		recordEvent ("participantAge", participantAge,"");
		
		int partnr = Integer.parseInt(participantNumber.trim());

		for(int i=0; i<8; i++){
			dezevolgorde[i] = volgordes[partnr][i];
		}
		new DarioAppMain();
		
	}
	

	
	
	
}
