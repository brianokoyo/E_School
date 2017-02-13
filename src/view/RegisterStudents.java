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

public class RegisterStudents extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Vector<JLabel> jl = new Vector<JLabel>();
	Vector<JTextField> jtf = new Vector<JTextField>();
	Vector<JPasswordField> jpf = new Vector<JPasswordField>();
	Vector<JButton> jb = new Vector<JButton>();
	Vector<JPanel> jp = new Vector<JPanel>();
	E_School e_School;

	public RegisterStudents() {
		jp.add(new JPanel(new GridLayout(4, 1)));
		jp.add(new JPanel(new GridLayout(1, 2)));

		jb.add(new JButton("Save"));
		jb.add(new JButton("Cancel"));

		jb.elementAt(0).addActionListener(this);
		jb.elementAt(1).addActionListener(this);

		jl.add(new JLabel("Adm No"));
		jl.add(new JLabel("First Name"));
		jl.add(new JLabel("Sur Name"));
		jl.add(new JLabel("Last Name"));

		jtf.add(new JTextField(20));
		jtf.add(new JTextField(20));
		jtf.add(new JTextField(20));
		jtf.add(new JTextField(20));

		jp.elementAt(1).add(jb.elementAt(0));
		jp.elementAt(1).add(jb.elementAt(1));

		jp.elementAt(0).add(jl.elementAt(0));
		jp.elementAt(0).add(jtf.elementAt(0));
		jp.elementAt(0).add(jl.elementAt(1));
		jp.elementAt(0).add(jtf.elementAt(1));
		jp.elementAt(0).add(jl.elementAt(2));
		jp.elementAt(0).add(jtf.elementAt(2));
		jp.elementAt(0).add(jl.elementAt(3));
		jp.elementAt(0).add(jtf.elementAt(3));

		setLayout(new BorderLayout());
		add(jp.elementAt(0), BorderLayout.CENTER);
		add(jp.elementAt(1), BorderLayout.SOUTH);
		setBorder(BorderFactory.createRaisedBevelBorder());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		if (source == jb.elementAt(0)) {
			getStudent();
			System.out.println("saving");
		} else if (source == jb.elementAt(1)) {
			System.out.println("cancelling");
			int size = jtf.size();
			for (int i = 0; i < size; i++) {
				jtf.elementAt(i).setText("");
			}
		}
	}

	public void getStudent() {
		String adm_no = jtf.elementAt(0).getText();
		String first_name = jtf.elementAt(1).getText();
		String sur_name = jtf.elementAt(2).getText();
		String last_name = jtf.elementAt(3).getText();

		e_School = new E_School();
		e_School.register_student(adm_no, first_name, sur_name, last_name);
	}
}
