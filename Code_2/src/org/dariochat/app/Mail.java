package org.dariochat.app;

import java.awt.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.html.*;
import javax.swing.tree.*;

public class Mail extends JFrame
{
	MyTableModel tableModel;
	JTable table;
	DefaultTreeModel treeModel;
	JTree tree;
	JEditorPane message;
	ImageIcon respondedIcon, forwardedIcon;
	int delaymail;


	ActionListener taskPerformersempty = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {			
		}
	};
	Timer test2 = new Timer(0, taskPerformersempty);

	DefaultMutableTreeNode mailbox (String name)
	{
		DefaultMutableTreeNode node = new DefaultMutableTreeNode (name);
		node.add (new DefaultMutableTreeNode ("Messages"));
		return node;
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

	Mail (final int delay)
	{
		super ("Mail");
		delaymail = delay;

		JPanel main = new JPanel (new BorderLayout ());

		DefaultMutableTreeNode root = new DefaultMutableTreeNode ("MAILBOXES");
		root.add (mailbox ("Inbox"));

		treeModel = new DefaultTreeModel (root);

		tree = new JTree (treeModel);
		tree.setRootVisible (false);
		tree.setShowsRootHandles (false);
		tree.setSelectionRow (0);
		tree.setBorder (BorderFactory.createEmptyBorder (6,12,6,12));
		tree.setBackground (Utilities.mailBlue);

		DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer() {
			public Color getBackground() { return null; }
			public Color getBackgroundNonSelectionColor() { return null; }
		};
		tree.setCellRenderer(renderer);

		DropTargetListener dtl = new DropTargetListener () {

			public void dragEnter (DropTargetDragEvent dtde) {}
			public void dragExit (DropTargetEvent dtde) {}
			public void dropActionChanged(DropTargetDragEvent dtde) {}

			public void dragOver (DropTargetDragEvent dtde)
			{
				Point pt = dtde.getLocation();
				TreePath path = tree.getPathForLocation (pt.x, pt.y);
				if ((path != null) && (path.getPathCount() > 1))
				{
					tree.setSelectionPath (path);
					dtde.acceptDrag (DnDConstants.ACTION_MOVE);
					//DarioAppMain.recordEvent ("mail", "drag");
				}
				else
				{
					tree.clearSelection();
					dtde.rejectDrag();
					//DarioAppMain.recordEvent ("mail", "rejectdrag");
				}
			}

			public void drop (DropTargetDropEvent dtde)
			{
				Point pt = dtde.getLocation();
				TreePath path = tree.getPathForLocation (pt.x, pt.y);
				if ((path != null) && (path.getPathCount() > 1))
				{
					dtde.acceptDrop (DnDConstants.ACTION_MOVE);
					int i = table.getSelectedRow();
					if (i >= 0)
					{
						removeEmail (i);
						tableModel.emails.add(new Email(i));
						table.clearSelection();
						table.repaint();
						tree.clearSelection();
					}
					DarioAppMain.recordEvent ("mail", "move", path.getLastPathComponent().toString());
				}
				else
				{
					dtde.rejectDrop();
					//DarioAppMain.recordEvent ("mail", "rejectdrop");
				}
			}
		};
		new DropTarget (tree, dtl);

		main.add (tree, BorderLayout.WEST);

		tableModel = new MyTableModel ();
		table = new JTable (tableModel);
		table.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
		table.setDragEnabled (true);
		table.setRowSelectionAllowed (true);
		table.setColumnSelectionAllowed (false);
		setTableColumnWidth (0, 20);
		setTableColumnWidth (3, 130);

		respondedIcon = new ImageIcon (Images.getImage (5));
		forwardedIcon = new ImageIcon (Images.getImage (6));

		table.getColumnModel().getColumn(0).setCellRenderer (new DefaultTableCellRenderer() {
			public Component getTableCellRendererComponent(JTable table, Object value,
					boolean isSelected, boolean hasFocus, 
					int row, int column) {
				setIcon ((ImageIcon) value);
				return this;
			}
		});

		// Add all the mails to the Email window
		for (int i=0; i < Products.getSize(); i++) tableModel.emails.add(new Email(i));

		JScrollPane tableScroll = new JScrollPane (table);
		tableScroll.setVerticalScrollBarPolicy (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		message = new JEditorPane ();
		message.setEditable (false);
		message.setContentType ("text/html");
		message.setBorder (BorderFactory.createEmptyBorder (6,12,6,12));

		Font font = UIManager.getFont("Label.font");
		String bodyRule = "body {font-family: " + font.getFamily() + "; " + "font-size: " + font.getSize() + "pt;}";
		((HTMLDocument) (message.getDocument())).getStyleSheet().addRule(bodyRule);

		JScrollPane editorScroll = new JScrollPane (message);
		editorScroll.setVerticalScrollBarPolicy (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		ListSelectionModel selmod = table.getSelectionModel();
		selmod.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged (ListSelectionEvent e) {

				if (!e.getValueIsAdjusting())
				{
					int i = table.getSelectedRow();
					Email email = tableModel.emails.elementAt(i);

					message.setText ("loading..");

					ActionListener taskPerformers = new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							int i = table.getSelectedRow();
							if (i>=0 && i<tableModel.emails.size())
							{
								Email email = tableModel.emails.elementAt(i);
								String product = Products.getID (email.productIndex);
								message.setText (email.bodyHTML());
								DarioAppMain.recordEvent ("mail", "loaded", product);
							}				
						}
					};

					double rnd = Math.random()*2-1;
					double noise = (delaymail/100*35)*rnd;						
					Timer test2 = new Timer(delaymail+(int)noise, taskPerformers);
					test2.setRepeats(false);
					test2.start();		

					String product = Products.getID (email.productIndex);
					DarioAppMain.recordEvent ("mail", "select", product);
				}
			}
		});

		JSplitPane msgPane = new JSplitPane (JSplitPane.VERTICAL_SPLIT, tableScroll, editorScroll);
		msgPane.setBorder (null); 

		// makes divider in mail window unable to be resized
		msgPane.setEnabled(false);

		main.add (msgPane, BorderLayout.CENTER);

		JButton getmail = controlButton ("Received", 3);		
		JButton compose = controlButton ("New message", 4);		
		JButton reply = controlButton ("Reply", 1);		
		JButton forward = controlButton ("Forward", 2);
		
		getmail.setMaximumSize(new Dimension 	(200,50));
		getmail.setPreferredSize(new Dimension 	(200,50));
		compose.setMaximumSize(new Dimension 	(200,50));
		compose.setPreferredSize(new Dimension 	(200,50));
		reply.setMaximumSize(new Dimension 		(200,50));
		reply.setPreferredSize(new Dimension 	(200,50));
		forward.setMaximumSize(new Dimension 	(200,50));
		forward.setPreferredSize(new Dimension 	(200,50));
		
		
		JPanel buttons = new JPanel();
		buttons.setLayout (new BoxLayout (buttons, BoxLayout.X_AXIS));
		
		buttons.setBorder (BorderFactory.createEmptyBorder (3,15,3,15));
		buttons.add (getmail);
		buttons.add (compose);
		buttons.add (reply);
		buttons.add (forward);
		buttons.setBackground (Utilities.myDarkGray);
		buttons.setBorder (BorderFactory.createEmptyBorder (3,15,3,15));

		reply.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i>=0 && i<tableModel.emails.size())
				{
					Email email = tableModel.emails.elementAt(i);
					DarioAppMain.composer.appear (email, true);
					email.status = 1;
					table.repaint();
					String product = Products.getID (email.productIndex);
					DarioAppMain.recordEvent ("mail", "reply", product);
				}
				else
				{
					DarioAppMain.recordEvent ("mail", e.getActionCommand());										
				}
			}
		});

		main.add (buttons, BorderLayout.NORTH);

		setDefaultCloseOperation (JFrame.DO_NOTHING_ON_CLOSE);
		setContentPane (main);
		pack ();

		//setSize (700, 700);
		msgPane.setDividerLocation (.999);

		//added a recordEvent to record the focus on the main mail window
		addWindowFocusListener (new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				DarioAppMain.recordEvent ("mail", "focus");

				message.setText ("loading...");

				ActionListener taskPerformers = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						int i = table.getSelectedRow();
						if (i>=0 && i<tableModel.emails.size())
						{
							Email email = tableModel.emails.elementAt(i);
							String product = Products.getID (email.productIndex);
							message.setText (email.bodyHTML());
							DarioAppMain.recordEvent ("mail", "loaded", product);
						}				
					}
				};
				double rnd = Math.random()*2-1;

				double noise = (delaymail/100*35)*rnd;
				Timer test2 = new Timer(delaymail+(int)noise, taskPerformers);
				test2.setRepeats(false);
				test2.start();
	}
			public void windowLostFocus(WindowEvent e) {
				message.setText ("");
				//if the window is not focused, we don't want them to cheat by dragging the focused window an look at the model. 
				//So if th mail window is not focused, the message is blank 

			}
		});
	}

	void removeEmail (int i) { tableModel.emails.removeElementAt (i); }

	void setTableColumnWidth (int i, int w)
	{
		TableColumn col = table.getColumnModel().getColumn(i);
		col.setMinWidth (w);
		col.setMaxWidth (w);
		col.setPreferredWidth (w);
	}

	class MyTableModel extends AbstractTableModel
	{
		String[] columns = {"�", "From:", "Subject:", "Date:"};
		Vector<Email> emails = new Vector<Email> ();

		public int getColumnCount() { return columns.length; }
		public int getRowCount() { return emails.size(); }
		public String getColumnName (int j) { return columns[j]; }
		public boolean isCellEditable (int i, int j) { return false; }

		public Object getValueAt (int i, int j)
		{
			Email e = emails.elementAt (i);
			Object o = null;
			switch (j)
			{
			case 0: if (e.status == 1) return respondedIcon;
			else if (e.status == 2) return forwardedIcon;
			break;
			case 1: o = e.from; break;
			case 2: o = e.subject; break;
			case 3: o = e.shortDate; break;
			}
			return o;
		}
	}
}

