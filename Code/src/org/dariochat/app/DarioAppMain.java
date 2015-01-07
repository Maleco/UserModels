package org.dariochat.app;
import com.srresearch.eyelink.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Random;
<<<<<<< HEAD
import java.util.Vector;
=======
>>>>>>> 027143746968b5e728222819c1cf0243397c81ee

import javax.swing.*;

public class DarioAppMain
{
	static Mail mail;
	static Browser browser;
	static Composer composer;
	static Data data = new Data ();
	static Random rand = new Random();
	static long startTime = 0;
	static double lastTime = 0;
<<<<<<< HEAD
=======
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
	
>>>>>>> 027143746968b5e728222819c1cf0243397c81ee
	
	static boolean minimized;
	static int nrIntro = 4;
	static int nrNormal = 8;
	static int randSecond = 0;
	static int thresholdIOP = 10;
	static int readSize = 125;

	// Eyetracker variables
	static int qFinished = 0;
	static String currentWindow;
	static Sample s;
	static Tracker t;
	static double dilMax = 0;
	static double dilBase = 0;

	static double currentEmail;
	static boolean currentEmailInterrupted = false;

	//	static
	//	{
	//		System.loadLibrary("eljava");
	//	}

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
<<<<<<< HEAD

	static void minimize () {
		// The minimize action
=======
	
	static void minimize () {
>>>>>>> 027143746968b5e728222819c1cf0243397c81ee
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
<<<<<<< HEAD

		// Set the variables
		currentEmailInterrupted = true;
		thresholdIOP += 2;

		// Print the minimize action
		String window = "chat"; String event = "focus"; String extra="interruption";
		long ms = Calendar.getInstance().getTimeInMillis() - startTime;
		Sampledario s = new Sampledario (.001*ms, window, event, extra);
		data.add (s);
	}

	static void recordEvent (String window, String event, String extra)
	{
		int curEmail =Integer.parseInt(extra);
		// New email = new trial
		if (window == "mail" && event == "select" && curEmail != currentEmail)
		{
			currentEmail = curEmail;			
			currentEmailInterrupted = false;
		}

		// Keep track of focused window
		if (event == "focus") currentWindow = window;

		// Composer send -> Email completed
		if (window == "compose" && event == "send")	{
			qFinished++;
			if (!currentEmailInterrupted) thresholdIOP -= 2;
		}

		// Random interrupt (20% chance)
		if (currentEmail >= nrIntro  		  + nrNormal*randSecond && 
			currentEmail < (nrIntro+nrNormal) + nrNormal*randSecond && 
			!currentEmailInterrupted  && rand.nextInt(10) <= 1 && event != "type" )
			minimize();	// Interrupt

=======
	}
	
	static void recordEvent (String window, String event, String extra)
	{
		if(event == "focus")
		{
			currentWindow = window;
		}
>>>>>>> 027143746968b5e728222819c1cf0243397c81ee
		long ms = Calendar.getInstance().getTimeInMillis() - startTime;
		Sampledario s = new Sampledario (.001*ms, window, event, extra);
		data.add (s);
	}

	public static void exit ()
	{
		System.exit (0);
	}

	public static double getIOP(double dilSample)
	{
		double PCPSdilSample = (dilSample-dilBase)	/dilBase;
		double PCPSdilMax 	 = (dilMax-dilBase)		/dilBase;
		return 1+(19*(1-(PCPSdilSample/PCPSdilMax)));
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

		startEvent (100, true, new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				mail.setSize (500, 1080);
				mail.setLocation (0, 0);
				mail.setExtendedState (JFrame.NORMAL);

				browser.setSize (1100, 1080); // (700,456);
				browser.setLocation (500, 0);
				browser.setExtendedState (JFrame.NORMAL);

				composer.setSize (820, 1080);
				composer.setLocation (0, 0);
				composer.setExtendedState (JFrame.NORMAL);
			}
		});
<<<<<<< HEAD
		 
		//Continuous loop for the Eyetracker-data
		while(true){
			if (currentEmail >= nrIntro  		  - nrNormal*(randSecond-1) && 
				currentEmail < (nrIntro+nrNormal) - nrNormal*(randSecond-1) && 
				!currentEmailInterrupted ) 
			{				
				
				double avgDil = 0.00;
				
				//Read #readSize values with an pauze of 4ms (so 500ms total)
				for (int counter = 0; counter < readSize; counter++)
				{
					double sampleDil = t.getNewestSample().pa(EL_EYE.EL_LEFT) ;
					// Update max value 
					if (sampleDil > dilMax) dilMax = sampleDil;
					avgDil += sampleDil / readSize;

					try {
						Thread.sleep(4);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}

				// Interrupt if possible
				if (getIOP(avgDil) < thresholdIOP) minimize();
			}
=======
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		System.out.println(qFinished);
		System.out.println(currentWindow);
		//s = t.getNewestSample();
>>>>>>> 027143746968b5e728222819c1cf0243397c81ee
		}
	}

	public static void main (String args[])
	{
<<<<<<< HEAD
		JFrame frame = new JFrame();
		// Show instructions
		JOptionPane.showMessageDialog(
				frame, 
				"Welkom, bedankt voor je deelname. Dit experiment zal ± 15 minuten duren. \n" +
						"Tijdens het experiment zal je een aantal e-mails moeten beantwoorden. \n" +
						"De vragen in deze e-mails zijn aan de klantenservice van een touroperator voor wintersportvakanties gesteld. \n" +
						"Daarbij moet je gebruik maken van de reeds geopende browser, waarin alle benodigde informatie staat weergegeven. \n" +
						"Daarnaast moet je ook een aantal persoonlijke vragen die via de chat gesteld worden beantwoorden. \n" +
						"Deze chat verschijnt automatisch op het scherm. Pas als alle vragen in de chat beantwoord zijn, mag je verder gaan met de e-mail taak. \n" +
						"Teruggaan naar de mail taak doe je door zelf op de e-mail en de browser in de taakbalk te klikken.  \n" +
						"\n" +
						"Enkele restricties:\n" +
						"\n" +
						"- Gebruik geen alt-tab. \n" +
						"- Chat niet minimaliseren.\n" +
						"- E-mails op volgorde beantwoorden, beginnen bij nummer 1.\n" +
						"\n" +
						"\n" +
						"De eerste vier e-mails zijn ter introductie, daarna begint het daadwerkelijke experiment.\n" +
						"Je start eerst met een wit scherm, we willen je vragen om in alle rust naar dit scherm te kijken. Na 15 seconden zal het daadwerkelijke experiment starten. \n" +
						"\n" +
						"Succes!\n" 
				);

		// Empty screen

		frame.setSize(1600,1200);
		frame.setVisible(true);

		//5 seconds to calm
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		t = new Tracker();
		t.open();          // open connection to the tracker
		t.startRecording(true,true,true,true); // start recording.

		// Determine baseline (10s)
		long time= System.currentTimeMillis();
		long end = time+10000;

		int i = 0;
		double sum = 0;
		while(System.currentTimeMillis() < end) {
			// Read the Eyetracker value				
			double sampleDil = t.getNewestSample().pa(EL_EYE.EL_LEFT);
			// Update max value 
			if (sampleDil > dilMax) dilMax = sampleDil; 

			// Add to measurement
			if (sampleDil != 0)
			{
				sum += s.pa(EL_EYE.EL_LEFT);
				i++;
			}
		}
		frame.setVisible(false);
		dilBase = sum/i; 
		System.out.println(dilBase);
		System.out.println(dilMax);

		// Set experiment variables
		randSecond = rand.nextInt(2);
		int browserDelay = 2000;
=======
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
>>>>>>> 027143746968b5e728222819c1cf0243397c81ee
		int mailDelay = 2000;
		int noisePercentage = 25;	// percentage of noise on delay (so amount of noise depends on size of delay)
		boolean testMode = true;	// if testMode is true, application will exit when clicking the red exit button on the browser (!) window
		DarioAppMain(browserDelay, mailDelay, noisePercentage, testMode);
	}
}
