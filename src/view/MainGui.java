package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainGui() {
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		/*
		 * if (getComponent(0).getName().equals("login")) { setBounds(200, 200,
		 * 250, 250); } else { setBounds(200, 200, 1200, 500); }
		 */
		setBounds(200, 200, 1200, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
