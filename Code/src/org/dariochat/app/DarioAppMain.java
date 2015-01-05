package org.dariochat.app;
import com.srresearch.eyelink.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Random;

import javax.swing.*;

public class DarioAppMain
{
	static Mail mail;
	static Browser browser;
	static Composer composer;
	static Data data = new Data ();
	static long startTime = 0;
	static double lastTime = 0;
	static boolean newTrial = true;
	static boolean minimized;
	static int expStruct;
	static Random rand = new Random();
	static int qFinished = 0;
	static String currentWindow;
	static Sample s;
	//static Tracker t = new Tracker();
	static double max = 0;
	
	static void incrementFinish ()
	{
		qFinished++;
	}
	
	
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
	
	static void minimize () {
		mail.setExtendedState(Frame.ICONIFIED);
		mail.setVisible (false);
		browser.setExtendedState(Frame.ICONIFIED);
		browser.setVisible (false);
		if(composer.isVisible()){
			composer.setExtendedState(Frame.ICONIFIED);
			composer.setVisible(false);
			minimized = true;
		}
		mail.setExtendedState(Frame.NORMAL);
		mail.setVisible (true);
		browser.setExtendedState(Frame.NORMAL);
		browser.setVisible (true);
		if(minimized){
			composer.setExtendedState(Frame.NORMAL);
			composer.setVisible(true);
		}
	}
	
	static void recordEvent (String window, String event, String extra)
	{
		if(event == "focus")
		{
			currentWindow = window;
		}
		long ms = Calendar.getInstance().getTimeInMillis() - startTime;
		Sampledario s = new Sampledario (.001*ms, window, event, extra);
		data.add (s);
		

			/// Implement our model here
			if (newTrial)
			{
				int delay = 50 + Utilities.random.nextInt(150);
				startEvent (delay, false, new ActionListener() {
					public void actionPerformed (ActionEvent e) {
						///recordEvent ("chat", "prompt", text);
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
	
	
	public static void DarioAppMain(int browserDelay, int mailDelay, int noisePercentage, boolean testMode){
		startTime = Calendar.getInstance().getTimeInMillis();

		Images.initialize();

		browser = new Browser (browserDelay, noisePercentage, testMode);
		browser.setVisible (true);
		mail = new Mail (mailDelay);
		mail.setVisible (true);

		composer = new Composer ();
		composer.setVisible (false);
		
		// should also disable CMD-` in Preferences so people don't switch windows using keystrokes!
		
		startEvent (100, true, new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				mail.setSize (820, 1080);
				mail.setLocation (0, 0);
				mail.setExtendedState (JFrame.NORMAL);
	
				browser.setSize (1100, 1080); // (700,456);
				browser.setLocation (820, 0);
				browser.setExtendedState (JFrame.NORMAL);
				
				composer.setSize (820, 1080);
				composer.setLocation (0, 0);
				composer.setExtendedState (JFrame.NORMAL);
			}
		});
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		System.out.println(qFinished);
		System.out.println(currentWindow);
		//s = t.getNewestSample();
		}
	}

	public static void main (String args[])
	{
		/* Commented out to speed up dev-time
		JFrame frame = null;
		JOptionPane.showMessageDialog(frame, "This is the start of the experiment.\n\n When you're ready, you may press 'ok' to start.");
		String participantNumber = (String)JOptionPane.showInputDialog(frame, "Your participant number:\n", "Participant number", JOptionPane.QUESTION_MESSAGE);
		Object[] possibilities = {"Male", "Female"};
		String participantGender = (String)JOptionPane.showInputDialog(frame, "Your gender: ", "Your gender", JOptionPane.PLAIN_MESSAGE,null,possibilities, "Male");
		String participantAge = (String)JOptionPane.showInputDialog(frame, "Your age:\n", "Your age", JOptionPane.QUESTION_MESSAGE);
		recordEvent ("participantNumber", participantNumber,"");
		recordEvent ("participantGender", participantGender,"");
		recordEvent ("participantAge", participantAge,"");
		*/		
		expStruct = rand.nextInt(2);
		int browserDelay = 3000;
		int mailDelay = 2000;
		int noisePercentage = 35;	// percentage of noise on delay (so amount of noise depends on size of delay)
		boolean testMode = true;	// if testMode is true, application will exit when clicking the red exit button on the browser (!) window
		DarioAppMain(browserDelay, mailDelay, noisePercentage, testMode);
	}
	

	
	
	
}
