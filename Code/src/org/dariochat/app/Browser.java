package org.dariochat.app;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.io.File;
import java.net.URL;

public class Browser extends JFrame
{
	JEditorPane browser;
	URL homepage;
	URL load;
	URL tempURL;
	URL temp2URL; //Ioanna
	URL empty;
	URL searching;
	int level = 0;
	int delay = 0;
	//int delay = 2000;			// delay in the browser in ms
	//int noisePercentage = 35;	// percentage of noise on delay (so amount of noise depends on size of delay)
	//boolean testMode = true;	// if testMode is true, application will exit when 
								// clicking the red exit button on the browser (!) window

	void setDelay(boolean newDelay){
		if(newDelay){
			delay = 3000;
		}
		else{
			delay = 0;
		}
	}
	
	JButton controlButton (String label, int imageIndex)
	{
		JButton b = new JButton (label, new ImageIcon (Images.getImage (imageIndex)));
		b.setVerticalTextPosition (SwingConstants.BOTTOM);
		b.setHorizontalTextPosition (SwingConstants.CENTER);
		b.setBackground (Color.lightGray);
		b.setPreferredSize (new Dimension (70, 60));
		return b;
	}

	Browser (final int newDelay, final int noisePercentage, boolean testMode)
	{
		super ("Browser");
		delay = newDelay;
		JPanel main = new JPanel (new BorderLayout ());

		try {
			File f = new File(".");
			homepage = new URL ("file:///" +  f.getCanonicalPath() + "/src/resources/web/Questions.html");
			load = new URL ("file:///" +  f.getCanonicalPath() + "/src/resources/web/load.html");
			empty = new URL ("file:///" +  f.getCanonicalPath() + "/src/resources/web/empty.html");
			searching = new URL ("file:///" +  f.getCanonicalPath() + "/src/resources/web/searching.html");
			tempURL = homepage;
			browser = new JEditorPane (homepage);
		} catch (IOException e) { e.printStackTrace(); }

		browser.setEditable (false);
		//browser.setContentType ("text/html");
		browser.setBorder (BorderFactory.createEmptyBorder (6,12,6,12));
		//Font font = UIManager.getFont("Label.font");
		//String bodyRule = "body {font-family: " + font.getFamily() + "; " + "font-size: " + font.getSize() + "pt;}";
		//((HTMLDocument) (browser.getDocument())).getStyleSheet().addRule(bodyRule);
		
		
		browser.addHyperlinkListener (new HyperlinkListener() {
			public void hyperlinkUpdate (final HyperlinkEvent event) {
				if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
					
					//added a recordEvent to record the specific time at which a link is requested
					File file = new File(event.getURL().getFile());
					temp2URL = event.getURL();//[Ioanna] storing the link he wants to go to
					DarioAppMain.recordEvent ("browser", "linkRequest"+(level+1), file.getName());
					
					try {
						browser.setPage(load);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					//try {	
					//Added a delay in the browser
					//if (browser.getPage() != homepage) {
					
					ActionListener taskPerformer = new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							try {
								browser.setPage(event.getURL());
								level ++;
								File file = new File(event.getURL().getFile());
								DarioAppMain.recordEvent ("browser", "link"+level, file.getName());
							} catch (IOException e) {
								e.printStackTrace();
							}
							
						}
					};
						// create noise for the delay
						double rnd = Math.random()*2-1;
						double noise = (delay/100*noisePercentage)*rnd;
						Timer test = new Timer(0, taskPerformer);
						if(level == 2){//[Ioanna] Adding a delay in the last level, so that it can be considered a low-workload point
							try {
								browser.setPage(searching);
								test = new Timer(2000+(int)noise, taskPerformer);
								
								} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}}//[Ioanna]

						//test = new Timer(delay+(int)noise, taskPerformer);
						
						// no delay/loader at lowest level
						if(level != 2){
							test = new Timer(delay+(int)noise, taskPerformer);
						}
						
						test.setRepeats(false);
						test.start();
				}
			}
		});

		JScrollPane browserScroll = new JScrollPane (browser);
		browserScroll.setVerticalScrollBarPolicy (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		//JButton backButton = controlButton ("Back", 7);

		JButton homeButton = controlButton ("Home", 8);
		homeButton.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent ae) {
				try {
					browser.setPage(homepage);
					level = 0;
					DarioAppMain.recordEvent ("browser", "home");
				} catch (IOException e) { e.printStackTrace(); }
			}
		});

		JPanel buttons = new JPanel();
		buttons.setLayout (new BoxLayout (buttons, BoxLayout.X_AXIS));
		//buttons.add (backButton);
		//buttons.add (Box.createRigidArea (new Dimension (3,3)));
		buttons.add (homeButton);
		buttons.add (Box.createHorizontalGlue());
		buttons.setBackground (Utilities.myDarkGray);
		buttons.setBorder (BorderFactory.createEmptyBorder (3,12,3,12));

		main.add (buttons, BorderLayout.NORTH);
		main.add (browserScroll, BorderLayout.CENTER);

		/*
		 * Record when the browser is focused on
		 */
		addWindowFocusListener (new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				DarioAppMain.recordEvent ("browser", "focus");
				try {
					browser.setPage(tempURL);
					} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
			}
			public void windowLostFocus (WindowEvent e) {
				try {

					tempURL = browser.getPage(); //[Ioanna] when change back from chat, they find the link they were previous 
					if (tempURL.equals(load)) {//[Ioanna] If it is "loading" it will get stuck there. We have to change the URL to the link requested, the one they want to go to.
						try{//[Ioanna] if we don't put delay, they will change to chat and then back again to avoid loading
							Thread.sleep(2000);//[Ioanna] I can't find out how much time it is loading before they swich, so I suppose they have already spent min 1000 changing windows, so we wait 2000 more.
							// That is only in case they swich back to the browser before the "loading" is over.
						}catch (InterruptedException e1)
						{
							tempURL = temp2URL;}
						tempURL = temp2URL;//[Ioanna] go to the link that was requested
					}
					if (tempURL.equals(searching)) {//[Ioanna] If it is "loading" it will get stuck there. We have to change the URL to the link requested, the one they want to go to.
						try{//[Ioanna] if we don't put delay, they will change to chat and then back again to avoid loading
							Thread.sleep(2000);//[Ioanna] I can't find out how much time it is loading before they swich, so I suppose they have already spent min 1000 changing windows, so we wait 2000 more.
							// That is only in case they swich back to the browser before the "loading" is over.
						}catch (InterruptedException e1)
						{
							tempURL = temp2URL;}
						tempURL = temp2URL;//[Ioanna] go to the link that was requested
					}
					browser.setPage(empty);//[Ioanna] that's what they see in the browser when they try to cheat by dragging the focused window
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}

			}
		}); 
		
		if (testMode){
			setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		} else {
			setDefaultCloseOperation (JFrame.DO_NOTHING_ON_CLOSE);
		}
		setContentPane (main);
		pack ();

		//setSize (700, 456);
		//setLocation (702, 0);
	}
}
