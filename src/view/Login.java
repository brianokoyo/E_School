package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.E_School;

public class Login extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	E_School e_School;
	Vector<JLabel> jl = new Vector<JLabel>();
	Vector<JButton> jb = new Vector<JButton>();
	JPasswordField jpf = new JPasswordField();
	JTextField jtf_username = new JTextField(10);
	public static JPanel jpcenter = new JPanel(new GridLayout(2, 2));
	public static JPanel jpsouth = new JPanel(new GridLayout(1, 2));
	public static JPanel jplogin = new JPanel();
	String[] jlnames = { "UserNames", "Password" };
	String[] jbnames = { "Login", "Cancel" };

	public Login() {
		for (int i = 0; i < 2; i++) {
			jl.add(new JLabel(jlnames[i]));
		}
		for (int i = 0; i < 2; i++) {
			jb.add(new JButton(jbnames[i]));
			jb.get(i).addActionListener(this);
			jpsouth.add(jb.get(i));
		}
		jtf_username.setText("root");
		jpf.setText("root");
		jpcenter.add(jl.get(0));
		jpcenter.add(jtf_username);
		jpcenter.add(jl.get(1));
		jpcenter.add(jpf);
		jplogin.setLayout(new BorderLayout());
		setLayout(new BorderLayout());
		jplogin.add(jpcenter, BorderLayout.CENTER);
		jplogin.add(jpsouth, BorderLayout.SOUTH);
		add(jplogin);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		if (source == jb.get(0)) {
			String user = jtf_username.getText();
			String password = String.valueOf(jpf.getPassword());

			e_School = new E_School();
			try {
				e_School.validateUser(user, password);
				e_School.open_eschool();
			} catch (SQLException sql) {
				JOptionPane.showMessageDialog(null,
						"Access Denied,Please Try Again");
			} catch (ClassNotFoundException cnf) {
				// TODO: handle exception
			}

		} else {
			System.exit(0);
		}
	}

}
