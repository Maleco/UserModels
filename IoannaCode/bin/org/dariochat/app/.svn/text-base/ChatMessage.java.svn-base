package org.dariochat.app;

import java.awt.*;
import javax.swing.*;


public class ChatMessage extends JPanel
{
	String text;
	boolean me;
	JButton balloon;
	JLabel icon;

	String convertHTML (String text)
	{
		String text2 = "<html><font size=2pt>&nbsp;</font><br>";
		int count=0;
		for (int i=0 ; i<text.length() ; i++)
		{
			count++;
			char c = text.charAt(i);
			if (count >= 40 && Character.isWhitespace(c))
			{
				text2 += "<br>";
				count = 0;
			}
			else text2 += c;
		}
		text2 += "<br><font size=2pt>&nbsp;</font></html>";
		return text2;
	}

	ChatMessage (boolean me, String text)
	{
		this.text = text;
		this.me = me;
		
		balloon = new JButton (convertHTML (text));
		balloon.setAlignmentX (JButton.LEFT_ALIGNMENT);
		balloon.setBackground (Color.white);

		icon = new JLabel (new ImageIcon (Images.getImage (0)));

		Component flexSpace = Box.createHorizontalGlue();
		Component rigidSpace = Box.createRigidArea (new Dimension (100, 10));

		JPanel center = new JPanel();
		center.setLayout (new BoxLayout (center, BoxLayout.X_AXIS));
		center.setBackground (Color.white);

		setLayout (new BorderLayout(6,6));
		if (me)
		{
			center.add (balloon);
			center.add (flexSpace);
			add (center, BorderLayout.CENTER);
			add (icon, BorderLayout.WEST);
			add (rigidSpace, BorderLayout.EAST);
		}
		else
		{
			center.add (flexSpace);
			center.add (balloon);
			add (center, BorderLayout.CENTER);
			add (icon, BorderLayout.EAST);
			add (rigidSpace, BorderLayout.WEST);
		}

		setBackground (Color.white);
		setBorder (BorderFactory.createEmptyBorder(3,6,3,6));
	}
	
	void setText (String text)
	{
		this.text = text;
		balloon.setText (convertHTML (text));
	}
}
