package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.E_School;

public class RegisterInstructors extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Vector<JLabel> jl = new Vector<JLabel>();
	Vector<JTextField> jtfinstructors = new Vector<JTextField>();
	Vector<JPasswordField> jpf = new Vector<JPasswordField>();
	Vector<JButton> jb = new Vector<JButton>();
	Vector<JPanel> jp = new Vector<JPanel>();
	E_School e_School;

	public RegisterInstructors() {

		jp.add(new JPanel(new GridLayout(6, 1)));
		jp.add(new JPanel(new GridLayout(1, 2)));

		jb.add(new JButton("Save"));
		jb.add(new JButton("Cancel"));

		jl.add(new JLabel("First Name"));
		jl.add(new JLabel("Sur Name"));
		jl.add(new JLabel("Last Name"));
		jl.add(new JLabel("Username"));
		jl.add(new JLabel("Password"));
		jl.add(new JLabel("Password Confirmation"));

		jb.elementAt(0).addActionListener(this);
		jb.elementAt(1).addActionListener(this);

		jtfinstructors.add(new JTextField(20));
		jtfinstructors.add(new JTextField(20));
		jtfinstructors.add(new JTextField(20));
		jtfinstructors.add(new JTextField(20));
		jpf.add(new JPasswordField(20));
		jpf.add(new JPasswordField(20));

		jp.elementAt(0).add(jl.elementAt(0));
		jp.elementAt(0).add(jtfinstructors.elementAt(0));
		jp.elementAt(0).add(jl.elementAt(1));
		jp.elementAt(0).add(jtfinstructors.elementAt(1));
		jp.elementAt(0).add(jl.elementAt(2));
		jp.elementAt(0).add(jtfinstructors.elementAt(2));
		jp.elementAt(0).add(jl.elementAt(3));
		jp.elementAt(0).add(jtfinstructors.elementAt(3));
		jp.elementAt(0).add(jl.elementAt(4));
		jp.elementAt(0).add(jpf.elementAt(0));
		jp.elementAt(0).add(jl.elementAt(5));
		jp.elementAt(0).add(jpf.elementAt(1));

		jp.elementAt(1).add(jb.elementAt(0));
		jp.elementAt(1).add(jb.elementAt(1));

		setLayout(new BorderLayout());
		add(jp.elementAt(0), BorderLayout.CENTER);
		add(jp.elementAt(1), BorderLayout.SOUTH);

		setBorder(BorderFactory.createRaisedBevelBorder());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		if (source == jb.elementAt(0)) {
			System.out.println("saving");
			getInstructor();
		} else if (source == jb.elementAt(1)) {
			System.out.println("cancelling");
			int size = jtfinstructors.size();
			for (int i = 0; i < size; i++) {
				jtfinstructors.elementAt(i).setText("");
			}
		}
	}

	public void getInstructor() {

		e_School = new E_School();
		String user_name = jtfinstructors.elementAt(0).getText();
		String first_name = jtfinstructors.elementAt(1).getText();
		String sur_name = jtfinstructors.elementAt(2).getText();
		String last_name = jtfinstructors.elementAt(3).getText();

		e_School.register_instructor(user_name, first_name, sur_name, last_name);

	}
}
