package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Accounts extends JPanel implements ActionListener, ItemListener {
	
	private static final long serialVersionUID = 2827743943220676254L;
	JPanel panelNorth, panelSouth, panelLoad, panelView, panelInput;
	JRadioButton jrbview, jrbinput;
	ButtonGroup bg;
	JButton butsave, butcancel, butdisplay;
	JLabel labelregistration, labelpayment, labelamount, labelserial,
			labelwelcome;
	JTextField fieldregistration, fieldamount, fieldserial;
	JComboBox pay;
	String[] arraypay = { "CASH", "CHEQUE", "BANKERS_CHEQUE", "MONEY_ORDER" };

	public Accounts() {
		panelNorth = new JPanel();
		panelSouth = new JPanel();
		panelLoad = new JPanel();
		panelView = new JPanel();
		panelInput = new JPanel();

		jrbview = new JRadioButton("VIEW");
		jrbinput = new JRadioButton("INPUT");

		bg = new ButtonGroup();
		panelLoad.setLayout(new BorderLayout());
		panelLoad.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		labelwelcome = new JLabel("WELCOME TO ACCOUNTING SYSTEM");
		labelwelcome.setFont(new Font("Lucida_Hans", Font.BOLD, 40));
		labelwelcome.setBorder(BorderFactory.createRaisedBevelBorder());
		labelwelcome.setToolTipText("Click On Input Or View");
		panelLoad.add(labelwelcome);

		labelregistration = new JLabel("STUDENT_REG._NO");
		labelpayment = new JLabel("MODE_OF_PAYMENT");
		labelamount = new JLabel("AMOUNT");
		labelserial = new JLabel("SERIAL_N0");
		fieldregistration = new JTextField(15);
		fieldamount = new JTextField(15);
		fieldserial = new JTextField(15);
		pay = new JComboBox(arraypay);
		pay.addItemListener(this);
		labelserial.setEnabled(false);
		fieldserial.setEnabled(false);
		fieldserial.setText("DEACTIVATED");
		panelInput.setLayout(new GridLayout(4, 2, 10, 10));
		panelInput.setBorder(BorderFactory.createLoweredBevelBorder());

		panelInput.add(labelregistration);
		panelInput.add(fieldregistration);
		panelInput.add(labelpayment);
		panelInput.add(pay);
		panelInput.add(labelserial);
		panelInput.add(fieldserial);
		panelInput.add(labelamount);
		panelInput.add(fieldamount);

		butcancel = new JButton("CANCEL");
		butsave = new JButton("SAVE");
		butdisplay = new JButton("DISPLAY");
		jrbview = new JRadioButton("VIEW");
		jrbview.addActionListener(this);
		butcancel.addActionListener(this);
		butsave.addActionListener(this);
		jrbinput.addActionListener(this);
		panelSouth.setLayout(new GridLayout(1, 3));

		panelNorth.setLayout(new GridLayout(1, 2));
		panelNorth.setBorder(BorderFactory.createLoweredBevelBorder());
		panelNorth.add(jrbinput);
		panelNorth.add(jrbview);
		panelSouth.add(butsave);
		panelSouth.add(butcancel);
		panelSouth.add(butdisplay);

		bg.add(jrbview);
		bg.add(jrbinput);

		setLayout(new BorderLayout());
		add(panelNorth, BorderLayout.NORTH);
		add(panelLoad, BorderLayout.CENTER);
		add(panelSouth, BorderLayout.SOUTH);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (source == jrbinput) {
			panelLoad.remove(labelwelcome);
			panelLoad.add(panelInput);
			butdisplay.setEnabled(false);
			repaint();
			validate();
		} else if (source == jrbview) {
			butsave.setEnabled(false);
			butcancel.setEnabled(false);
			butdisplay.setEnabled(true);
		}

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		if (pay.getSelectedItem().equals("CASH")) {
			labelserial.setEnabled(false);
			fieldserial.setEnabled(false);
			fieldserial.setText("DEACTIVATED");
		} else {
			labelserial.setEnabled(true);
			fieldserial.setEnabled(true);
			fieldserial.setText("");
			repaint();
			validate();
		}
	}
}
