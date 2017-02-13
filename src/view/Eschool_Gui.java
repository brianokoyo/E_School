/**
 * 
 */
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
import javax.swing.JTabbedPane;

/**
 * @author chebet
 * 
 */
public class Eschool_Gui extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Vector<JTabbedPane> jtp = new Vector<JTabbedPane>();
	JLabel jlwelcome;
	public static JLabel jlusername = new JLabel();
	RegisterSchoolAndClasses registerSchoolAndClasses;
	RegisterInstructors registerInstructors;
	RegisterStudents registerStudents;
	RegisterPaperAndExamType registerPaperAndExamType;
	Accounts accounts;
	GradeMarks gradeMarks;
	EnterMarks enterMarks;
	View_marks view_marks;

	JPanel jpmenu;
	JButton jblogout;

	/**
	 * 
	 */
	public Eschool_Gui() {
		setLayout(new BorderLayout());
		registerSchoolAndClasses = new RegisterSchoolAndClasses();
		registerInstructors = new RegisterInstructors();
		registerStudents = new RegisterStudents();
		registerPaperAndExamType = new RegisterPaperAndExamType();
		gradeMarks = new GradeMarks();
		enterMarks = new EnterMarks();
		view_marks = new View_marks();
		accounts = new Accounts();

		jpmenu = new JPanel(new GridLayout(1, 3));

		jblogout = new JButton("Logout");
		jblogout.addActionListener(this);

		jlwelcome = new JLabel("Welcome");

		jtp.add(new JTabbedPane());

		jpmenu.add(jlwelcome);
		jpmenu.add(jlusername);
		jpmenu.add(jblogout);

		jtp.elementAt(0).add("Register School", registerSchoolAndClasses);
		jtp.elementAt(0).add("Register instructors", registerInstructors);
		jtp.elementAt(0).add("Register Students", registerStudents);
		jtp.elementAt(0)
				.add("Register Paper & Exams", registerPaperAndExamType);
		jtp.elementAt(0).add("Grade Marks", gradeMarks);
		jtp.elementAt(0).add("Enter Marks", enterMarks);
		jtp.elementAt(0).add("View_marks",view_marks);
		//jtp.elementAt(0).add("Accounts", accounts);

		setLayout(new BorderLayout());
		add(jtp.elementAt(0), BorderLayout.CENTER);
		add(jpmenu, BorderLayout.NORTH);
		setBorder(BorderFactory.createRaisedBevelBorder());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		if (source == jblogout) {
			System.exit(0);
		}
	}

}
