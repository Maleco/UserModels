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
	static Random rand = new Random();
	static long startTime = 0;
	static double lastTime = 0;
	
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

		// The minimize action
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
		}
	}

	public static void main (String args[])
	{
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
				sum += sampleDil;
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
		int mailDelay = 2000;
		int noisePercentage = 25;	// percentage of noise on delay (so amount of noise depends on size of delay)
		boolean testMode = true;	// if testMode is true, application will exit when clicking the red exit button on the browser (!) window
		DarioAppMain(browserDelay, mailDelay, noisePercentage, testMode);
	}
}
