package org.dariochat.app;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

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
	
	static void recordEvent (String window, String event, String extra)
	{
		long ms = Calendar.getInstance().getTimeInMillis() - startTime;
		Sample s = new Sample (.001*ms, window, event, extra);
		data.add (s);
		
			System.out.println(ms);
			/// Implement our model here
			if (newTrial & ms > 10000)
			{
				/// The following lines of code minimize the windows of the mailtask, so the chatclient is focused.
				mail.setExtendedState(Frame.ICONIFIED);
				mail.setVisible (false);
				browser.setExtendedState(Frame.ICONIFIED);
				browser.setVisible (false);
				if(composer.isVisible()){
					composer.setExtendedState(Frame.ICONIFIED);
					composer.setVisible(false);
					minimized = true;
				}
				
				/// Simple testcase, I let the thread sleep for 5 seconds, after which the panels become visible again. The user still has to minimize the chatclient.
				try {
				    Thread.sleep(5000);                
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
				mail.setExtendedState(Frame.NORMAL);
				mail.setVisible (true);
				browser.setExtendedState(Frame.NORMAL);
				browser.setVisible (true);
				if(minimized){
					composer.setExtendedState(Frame.NORMAL);
					composer.setVisible(true);
				}
				
				newTrial = false;
			}
			
		if (window.equals("mail") && event.equals("select"))
			newTrial = true;
	}

	public static void exit ()
	{
		System.exit (0);
	}
	
	
	public static void DarioAppMainn(int browserDelay, int mailDelay, int noisePercentage, boolean testMode){
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
				
				composer.setSize (1000, 1000);
				composer.setLocation (70, 50);
				composer.setExtendedState (JFrame.NORMAL);
			}
		});
	}

	public static void main (String args[]) throws AWTException
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
		int browserDelay = 3000;
		int mailDelay = 2000;
		int noisePercentage = 35;	// percentage of noise on delay (so amount of noise depends on size of delay)
		boolean testMode = true;	// if testMode is true, application will exit when clicking the red exit button on the browser (!) window
		DarioAppMainn(browserDelay, mailDelay, noisePercentage, testMode);
	}
	

	
	
	
}
