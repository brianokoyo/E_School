package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Report_Form extends JFrame implements ActionListener, ItemListener {

	private static final long serialVersionUID = -3845068120194225687L;

	JLabel labelregistration, labelname, labelexam, labelposition, labelclass,
			labeloutof, labelteachcomment, labelteachsignature,
			labelheadcomment, labelheadsignature, labeltotal, labelsubject,
			labelteacher, labelsignature, labelmarks, labelmarksoutof,
			labelgrade, labelcomments, labeldate, labelopening;

	JTextField fieldregistration, fieldname, fieldposition, fieldclassoutof,
			fieldclass, fieldteachcomment, fieldteachsignature,
			fieldheadcomment, fieldheadsignature, fieldtotal, fieldsubject,
			fieldteacher, fieldmarks, fieldsignature, fieldtotaloutof,
			fieldtotalgrade, fieldcomments, fieldmarksoutof, fieldgrade,
			fielddate, fieldopening;

	JPanel paneldetails, panelmarks, panelrows, panelscore, panelclass,
			panelcomments, panelreportform, panelbuttons, paneldate,
			paneltotalcomments, panelall;

	JComboBox exam_type;
	String[] exam = { "Post_Term_One", "Mid_Term_One", "End_Of_Term_One",
			"Post_Term_Two", "Mid_Term_Two", "End_Of_Term_Two",
			"Post_Term_Three", "Mid_Term_Three", "End_Of_Term_Three" };

	JButton butprint, butback;

	public Report_Form() {
		panelall = new JPanel();
		paneldetails = new JPanel();
		panelmarks = new JPanel();
		panelscore = new JPanel();
		panelclass = new JPanel();
		panelcomments = new JPanel();
		panelreportform = new JPanel();
		panelbuttons = new JPanel();
		panelrows = new JPanel();
		paneldate = new JPanel();
		paneltotalcomments = new JPanel();

		paneldetails.setLayout(new GridLayout(3, 4, 10, 10));
		paneldetails
				.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		labelregistration = new JLabel("STUDENT_REG.NO :");
		labelname = new JLabel("STUDENT_NAME :");
		labelclass = new JLabel("CLASS :");
		labelexam = new JLabel("EXAM_TYPE :");
		labelposition = new JLabel("POSITION :");
		labeloutof = new JLabel("OUT_OF :");

		fieldregistration = new JTextField(15);
		fieldname = new JTextField(15);
		fieldclass = new JTextField(15);
		fieldclassoutof = new JTextField(15);
		fieldposition = new JTextField(15);

		exam_type = new JComboBox(exam);
		exam_type.addItemListener(this);

		paneldetails.add(labelregistration);
		paneldetails.add(fieldregistration);
		paneldetails.add(labelexam);
		paneldetails.add(exam_type);
		paneldetails.add(labelname);
		paneldetails.add(fieldname);
		paneldetails.add(labelposition);
		paneldetails.add(fieldposition);
		paneldetails.add(labelclass);
		paneldetails.add(fieldclass);
		paneldetails.add(labeloutof);
		paneldetails.add(fieldclassoutof);

		panelmarks.setLayout(new GridLayout(1, 7));
		panelmarks.setBorder(BorderFactory.createLoweredBevelBorder());
		labelsubject = new JLabel("SUBJECT");
		labelsubject.setBorder(BorderFactory.createRaisedBevelBorder());
		labelteacher = new JLabel("TEACHER");
		labelteacher.setBorder(BorderFactory.createRaisedBevelBorder());
		labelsignature = new JLabel("SIGNATURE");
		labelsignature.setBorder(BorderFactory.createRaisedBevelBorder());
		labelmarks = new JLabel("MARKS");
		labelmarks.setBorder(BorderFactory.createRaisedBevelBorder());
		labelmarksoutof = new JLabel("OUT_OF");
		labelmarksoutof.setBorder(BorderFactory.createRaisedBevelBorder());
		labelgrade = new JLabel("GRADE");
		labelgrade.setBorder(BorderFactory.createRaisedBevelBorder());
		labelcomments = new JLabel("COMMENT");
		labelcomments.setBorder(BorderFactory.createRaisedBevelBorder());

		panelmarks.add(labelsubject);
		panelmarks.add(labelteacher);
		panelmarks.add(labelsignature);
		panelmarks.add(labelmarks);
		panelmarks.add(labelmarksoutof);
		panelmarks.add(labelgrade);
		panelmarks.add(labelcomments);

		panelrows.setLayout(new GridLayout(1, 7));
		fieldsubject = new JTextField(15);
		fieldteacher = new JTextField(15);
		fieldsignature = new JTextField(15);
		fieldmarks = new JTextField(15);
		fieldmarksoutof = new JTextField(15);
		fieldgrade = new JTextField(15);
		fieldcomments = new JTextField(15);

		panelrows.add(fieldsubject);
		panelrows.add(fieldteacher);
		panelrows.add(fieldsignature);
		panelrows.add(fieldmarks);
		panelrows.add(fieldmarksoutof);
		panelrows.add(fieldgrade);
		panelrows.add(fieldcomments);

		panelscore.setLayout(new GridLayout(1, 5));
		labeltotal = new JLabel("TOTAL");
		fieldtotal = new JTextField(45);
		fieldmarksoutof = new JTextField(15);
		fieldtotaloutof = new JTextField(15);
		fieldtotalgrade = new JTextField(15);

		panelscore.add(labeltotal);
		panelscore.add(fieldtotal);
		panelscore.add(fieldtotaloutof);
		panelscore.add(fieldtotalgrade);

		panelclass.setLayout(new GridLayout(4, 1, 10, 10));
		panelclass.add(panelmarks);
		panelclass.add(panelrows);
		panelclass.add(panelscore);

		panelcomments.setLayout(new GridLayout(4, 2, 10, 5));
		labelteachcomment = new JLabel("TEACHER'S_COMMENTS :");
		labelheadcomment = new JLabel("HEAD_TEACHER'S_COMMENTS :");
		labelteachsignature = new JLabel("SIGNATURE :");
		labelheadsignature = new JLabel("SIGNATURE :");
		fieldteachcomment = new JTextField(60);
		fieldteachsignature = new JTextField(45);
		fieldheadcomment = new JTextField(60);
		fieldheadsignature = new JTextField(45);

		panelcomments.add(labelteachcomment);
		panelcomments.add(fieldteachcomment);
		panelcomments.add(labelteachsignature);
		panelcomments.add(fieldteachsignature);
		panelcomments.add(labelheadcomment);
		panelcomments.add(fieldheadcomment);
		panelcomments.add(labelheadsignature);
		panelcomments.add(fieldheadsignature);

		paneldate.setLayout(new GridLayout(1, 4));
		labeldate = new JLabel("DATE :");
		labelopening = new JLabel("OPENING_DATE :");
		fielddate = new JTextField(15);
		fieldopening = new JTextField(15);
		paneldate.add(labeldate);
		paneldate.add(fielddate);
		paneldate.add(labelopening);
		paneldate.add(fieldopening);

		paneltotalcomments.setLayout(new BorderLayout());
		paneltotalcomments.add(panelcomments, BorderLayout.NORTH);
		paneltotalcomments.add(paneldate, BorderLayout.SOUTH);

		panelreportform.setLayout(new GridLayout(4, 1, 15, 15));
		panelreportform.add(paneldetails);
		panelreportform.add(panelclass);
		panelreportform.add(paneltotalcomments);
		panelreportform.setBorder(BorderFactory.createLoweredBevelBorder());

		butprint = new JButton("PRINT");
		butprint.setMnemonic(KeyEvent.VK_P);
		butprint.addActionListener(this);
		butback = new JButton("BACK");
		butback.setMnemonic(KeyEvent.VK_C);
		butback.addActionListener(this);

		panelbuttons.setLayout(new GridLayout(1, 2, 15, 0));
		panelbuttons.setBorder(BorderFactory.createRaisedBevelBorder());
		panelbuttons.add(butback);
		panelbuttons.add(butprint);

		panelall.setLayout(new BorderLayout());
		panelall.add(panelreportform, BorderLayout.CENTER);
		panelall.add(panelbuttons, BorderLayout.SOUTH);

		add(panelall);
		setVisible(true);
		setTitle("REPORT_FORM");
		setLocationRelativeTo(null);

		pack();
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		if (!exam_type.getSelectedItem().equals("End_Of_Term_One")
				|| !(exam_type.getSelectedItem().equals("End_Of_Term_Two"))
				|| !(exam_type.getSelectedItem().equals("End_Of_Term_Three"))) {
			labeldate.setEnabled(true);
			labelopening.setEnabled(true);
			fielddate.setEnabled(true);
			fieldopening.setEnabled(true);

			repaint();
			validate();
		} else {
			labeldate.setEnabled(false);
			labelopening.setEnabled(false);
			fielddate.setEnabled(false);
			fieldopening.setEnabled(false);
			repaint();
			validate();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		if (source == butprint) {

		} else if (source == butback) {
			dispose();
		} else {

		}
	}

}
