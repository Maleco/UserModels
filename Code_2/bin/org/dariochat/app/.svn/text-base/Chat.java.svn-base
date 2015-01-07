package org.dariochat.app;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;


public class Chat extends JFrame
{
	DefaultListModel listModel;
	JList list;
	JTextField input;
	boolean blockScrollEvents = true;

	Chat ()
	{
		super ("Chat");
		//setBackground (Color.white);

		listModel = new DefaultListModel ();
		list = new JList (listModel);

		list.setCellRenderer (new ListCellRenderer() {
			public Component getListCellRendererComponent (JList list, Object value,
					int index, boolean isSelected, boolean cellHasFocus)
			{	
				return (ChatMessage) value;
			}
		});

		JScrollPane listScroll = new JScrollPane (list);
		listScroll.setVerticalScrollBarPolicy (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		JScrollBar scrollbar = listScroll.getVerticalScrollBar();
		scrollbar.addAdjustmentListener (new AdjustmentListener() {
			public void adjustmentValueChanged (AdjustmentEvent e) {
				if (!blockScrollEvents && !e.getValueIsAdjusting())
					DarioAppMain.recordEvent ("chat", "scroll", Integer.toString(e.getAdjustmentType()));
			}
		});

		input = new JTextField();
		input.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMessage (true, input.getText());
				DarioAppMain.recordEvent ("chat", "msg", input.getText());
				input.setText("");
			}
		});

		input.getDocument().addDocumentListener (new DocumentListener() {
			public void insertUpdate (DocumentEvent e) {
				setBackground (Color.white);
				DarioAppMain.recordEvent ("chat", "type", input.getText());
			}
			public void changedUpdate (DocumentEvent e) { }
			public void removeUpdate (DocumentEvent e) {
				setBackground (Color.white);
				if (input.getText().length() > 0)
					DarioAppMain.recordEvent ("chat", "type", input.getText());
			}
		});

		JPanel main = new JPanel ();
		main.setLayout (new BorderLayout (12,12));
		main.add (listScroll, BorderLayout.CENTER);
		main.add (input, BorderLayout.SOUTH);
		main.setBorder (BorderFactory.createEmptyBorder(12,12,12,12));

		addWindowFocusListener (new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				setBackground (Color.white);
				DarioAppMain.recordEvent ("chat", "focus");
			}
			public void windowLostFocus(WindowEvent e) { }
		});

		setDefaultCloseOperation (JFrame.DO_NOTHING_ON_CLOSE);
		setContentPane (main);

		pack ();
		
		blockScrollEvents = false;
		
		//setSize (600,240);
		//setLocation (702,482);
	}

	void addMessage (boolean me, String text)
	{
		blockScrollEvents = true;
		listModel.addElement (new ChatMessage (me, text));
		list.ensureIndexIsVisible (listModel.size()-1);
		list.repaint();
		blockScrollEvents = false;

		Toolkit.getDefaultToolkit().beep();
		if (me || isFocused()) setBackground (Color.white);
		else setBackground (Color.yellow);
	}

	String lastMessage ()
	{
		ChatMessage cm = (ChatMessage) listModel.lastElement();
		if (cm == null) return "";
		else return cm.text;
	}

	boolean isLastFromUser ()
	{
		if (listModel==null || listModel.size()==0) return true;
		ChatMessage cm = (ChatMessage) listModel.lastElement();
		if (cm == null) return true;
		return cm.me;
	}
}
