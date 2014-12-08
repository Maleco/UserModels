package org.dariochat.app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.html.*;


public class Composer extends JFrame
{
	JEditorPane header, editor;

	JButton controlButton (String label, int imageIndex)
	{
		JButton b = new JButton (label, new ImageIcon (Images.getImage (imageIndex)));
		b.setVerticalTextPosition (SwingConstants.BOTTOM);
		b.setHorizontalTextPosition (SwingConstants.CENTER);
		b.setBackground (Color.lightGray);
		b.setPreferredSize (new Dimension (70, 60));
		return b;
	}

	String extractTyping ()
	{
		String text = editor.getText();
		int i1 = text.indexOf ("<body>");
		int i2 = text.indexOf ("<br>");
		if (i1>0 && i2>0 && i1<i2 && i2<text.length())
		{
			text = text.substring (i1+6, i2).trim();
			text = text.replace ('\n', '/');
		}
		return text;
	}

	Composer ()
	{
		super ("Message");

		JPanel main = new JPanel (new BorderLayout ());

		header = new JEditorPane ();
		header.setEditable (false);
		header.setContentType ("text/html");
		header.setBorder (BorderFactory.createEmptyBorder (6,12,6,12));
		Font font = UIManager.getFont("Label.font");
		String bodyRule = "body {font-family: " + font.getFamily() + "; " + "font-size: " + font.getSize() + "pt;}";
		((HTMLDocument) (header.getDocument())).getStyleSheet().addRule(bodyRule);
		header.setBackground (Utilities.myLightGray);

		header.setText ("<table><tr><td align=right>To:</td><td>" + "Person" + "</td></tr>" +
				"<tr><td align=right>Subject:</td><td>Re: " + "Subject" + "</td></tr>" +
				"</table></html>");

		editor = new JEditorPane ();
		editor.setEditable (true);
		editor.setContentType ("text/html");
		editor.setBorder (BorderFactory.createEmptyBorder (6,12,6,12));
		font = UIManager.getFont("Label.font");
		bodyRule = "body {font-family: " + font.getFamily() + "; " + "font-size: " + font.getSize() + "pt;}";
		((HTMLDocument) (editor.getDocument())).getStyleSheet().addRule(bodyRule);

		editor.setText ("<html><br><br>" + "Body" + "</html>");

		editor.getDocument().addDocumentListener (new DocumentListener() {
			public void insertUpdate (DocumentEvent e) {
				if (isVisible())
					DarioAppMain.recordEvent ("compose", "type", extractTyping());
			}
			public void changedUpdate (DocumentEvent e) { }
			public void removeUpdate (DocumentEvent e) {
				if (isVisible() && (editor.getText().length() > 0))
					DarioAppMain.recordEvent ("compose", "type", extractTyping());
			}
		});

		JScrollPane editorScroll = new JScrollPane (editor);
		editorScroll.setVerticalScrollBarPolicy (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		JButton send = controlButton ("Send", 3);
		JPanel buttons = new JPanel();
		buttons.setLayout (new BoxLayout (buttons, BoxLayout.X_AXIS));
		buttons.add (send);
		buttons.add (Box.createHorizontalGlue());
		buttons.setBackground (Utilities.myDarkGray);
		buttons.setBorder (BorderFactory.createEmptyBorder(6,12,6,6));

		send.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible (false);
				DarioAppMain.recordEvent ("compose", "send", extractTyping());
			}
		});

		JPanel center = new JPanel();
		center.setLayout (new BorderLayout());
		center.add (header, BorderLayout.NORTH);
		center.add (editor, BorderLayout.CENTER);

		main.add (buttons, BorderLayout.NORTH);
		main.add (center, BorderLayout.CENTER);

		addWindowFocusListener (new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				DarioAppMain.recordEvent ("compose", "focus");
			}
			public void windowLostFocus(WindowEvent e) { }
		});

		setDefaultCloseOperation (JFrame.DO_NOTHING_ON_CLOSE);
		setContentPane (main);
		pack ();

		editor.requestFocusInWindow ();
		editor.setCaretPosition (1); // not 0 because of <html> tag!

		//setSize (500, 500);
		//setLocation (400, 100);
	}

	String indentBody (String body)
	{
		return "> " + body.replaceAll ("<br>", "<br>> ");
	}

	void appear (Email include, boolean reply)
	{
		setVisible (false);

		String to = (reply ? include.from : "Administrator");
		header.setText ("<table><tr><td align=right>To:</td><td>" + to + "</td></tr>" +
				"<tr><td align=right>Subject:</td><td>Re: " + include.subject + "</td></tr>" +
				"</table></html>");

		editor.setText ("<html><br><br>" + /*indentBody(include.body) + */"</html>");

		editor.requestFocusInWindow ();
		editor.setCaretPosition (1); // no 0 because of <html> tag!

		setVisible (true);
	}
}
