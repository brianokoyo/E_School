package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.E_School;

public class View_marks extends JPanel implements ActionListener {
	/**
	 * adm_no,exam_type,paper_type,mark,grade,time,user_name,class,stream
	 */
	private static final long serialVersionUID = 1L;
	JComboBox adm_no, exam_type, paper_type, mark, grade, time, user_name,
			class_names, stream;
	JPanel jpnorth, jpcenter, jpsouth;
	JLabel jltotal, jlavg;
	JTextField jtftotal, jtfavg;
	JButton jbview_reportform;
	int rows = 1;
	int cols = 1;
	Report_Form report_Form;

	public View_marks() {
		adm_no = new JComboBox(E_School.get_stud_adm_no());
		exam_type = new JComboBox(E_School.get_exam_type());
		paper_type = new JComboBox(E_School.get_paper_type());
		mark = new JComboBox(E_School.get_marks());
		grade = new JComboBox(E_School.get_grade());
		user_name = new JComboBox(E_School.get_username());
		class_names = new JComboBox(E_School.get_level_name());
		stream = new JComboBox(E_School.get_sub_level_name());

		adm_no.addActionListener(this);
		exam_type.addActionListener(this);
		paper_type.addActionListener(this);
		mark.addActionListener(this);
		grade.addActionListener(this);
		user_name.addActionListener(this);
		class_names.addActionListener(this);
		stream.addActionListener(this);

		jpcenter = new JPanel();
		jpnorth = new JPanel();
		jpsouth = new JPanel();

		jltotal = new JLabel("Total");
		jlavg = new JLabel("Average");

		jtftotal = new JTextField(10);
		jtfavg = new JTextField(10);

		jbview_reportform = new JButton("View Report_Form");
		jbview_reportform.addActionListener(this);

		jpsouth.add(jltotal);
		jpsouth.add(jtftotal);
		jpsouth.add(jlavg);
		jpsouth.add(jtfavg);
		jpsouth.add(jbview_reportform);

		jpnorth.add(adm_no);
		jpnorth.add(exam_type);
		jpnorth.add(paper_type);
		jpnorth.add(grade);
		jpnorth.add(user_name);
		jpnorth.add(class_names);
		jpnorth.add(stream);
		Vector<Vector<String>> get_all_student_marks = E_School
				.get_all_student_marks();
		Iterator<Vector<String>> get_all_student_marks_iterator = get_all_student_marks
				.iterator();
		while (get_all_student_marks_iterator.hasNext()) {
			Vector<String> stud_performance = get_all_student_marks_iterator
					.next();
			Iterator<String> stud_perfomance_iterator = stud_performance
					.iterator();

			jpcenter.add(new RowPanel(stud_perfomance_iterator.next(),
					stud_perfomance_iterator.next(), stud_perfomance_iterator
							.next(), stud_perfomance_iterator.next(),
					stud_perfomance_iterator.next(), stud_perfomance_iterator
							.next(), stud_perfomance_iterator.next(),
					stud_perfomance_iterator.next()));

			jpcenter.setLayout(new GridLayout(rows, cols));
			repaint();
			validate();
			rows++;
		}
		
		jtftotal.setText(E_School.get_admno_sum(adm_no.getSelectedItem()
				.toString()));
		jtfavg.setText(E_School.get_admno_avg(adm_no.getSelectedItem()
				.toString()));
		
		setLayout(new BorderLayout());

		add(jpnorth, BorderLayout.NORTH);
		add(new JScrollPane(jpcenter));
		add(jpsouth, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();
		if (source == adm_no) {
			get_admno(adm_no.getSelectedItem().toString());
			jtftotal.setText(E_School.get_admno_sum(adm_no.getSelectedItem()
					.toString()));
			jtfavg.setText(E_School.get_admno_avg(adm_no.getSelectedItem()
					.toString()));
		} else if (source == exam_type) {
			jtftotal.setText(E_School.get_exam_sum(exam_type.getSelectedItem()
					.toString()));
			jtfavg.setText(E_School.get_exam_avg(exam_type.getSelectedItem()
					.toString()));
			get_exam(exam_type.getSelectedItem().toString());
		} else if (source == paper_type) {
			jtftotal.setText(E_School.get_paper_sum(paper_type
					.getSelectedItem().toString()));
			jtfavg.setText(E_School.get_paper_avg(paper_type.getSelectedItem()
					.toString()));
			get_paper(paper_type.getSelectedItem().toString());
		} else if (source == grade) {
			jtftotal.setText(E_School.get_grade_sum(grade.getSelectedItem()
					.toString()));
			jtfavg.setText(E_School.get_grade_avg(grade.getSelectedItem()
					.toString()));
			get_grades(grade.getSelectedItem().toString());
		} else if (source == user_name) {
			jtftotal.setText(E_School.get_username_sum(user_name
					.getSelectedItem().toString()));
			jtfavg.setText(E_School.get_username_avg(user_name
					.getSelectedItem().toString()));
			get_username(user_name.getSelectedItem().toString());
		} else if (source == class_names) {
			jtftotal.setText(E_School.get_class_sum(class_names
					.getSelectedItem().toString()));
			jtfavg.setText(E_School.get_class_avg(class_names.getSelectedItem()
					.toString()));
			get_class(class_names.getSelectedItem().toString());
		} else if (source == stream) {
			jtftotal.setText(E_School.get_sublevel_sum(stream.getSelectedItem()
					.toString()));
			jtfavg.setText(E_School.get_sublevel_avg(stream.getSelectedItem()
					.toString()));
			get_stream(stream.getSelectedItem().toString());
		} else if (source == jbview_reportform) {
			report_Form = new Report_Form();
			
		}
	}

	public void get_admno(String adm_no) {
		rows = 0;
		jpcenter.removeAll();
		Vector<Vector<String>> get_all_student_marks = E_School
				.get_adm_no_marks(adm_no);
		if (get_all_student_marks.size()>1) {
			Iterator<Vector<String>> get_all_student_marks_iterator = get_all_student_marks
					.iterator();
			while (get_all_student_marks_iterator.hasNext()) {
				Vector<String> stud_performance = get_all_student_marks_iterator
						.next();
				Iterator<String> stud_perfomance_iterator = stud_performance
						.iterator();

				jpcenter.add(new RowPanel(stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next()));
				rows++;
				jpcenter.setLayout(new GridLayout(rows, cols));
				repaint();
				validate();
			}
		}else {
			JOptionPane.showMessageDialog(null, "Selection Empty");
			repaint();
			revalidate();
		}
	}

	public void get_exam(String exam) {
		rows = 0;
		jpcenter.removeAll();
		Vector<Vector<String>> get_all_student_marks = E_School
				.get_exam_type_marks(exam);
		if (get_all_student_marks.size() > 1) {
			Iterator<Vector<String>> get_all_student_marks_iterator = get_all_student_marks
					.iterator();
			while (get_all_student_marks_iterator.hasNext()) {
				Vector<String> stud_performance = get_all_student_marks_iterator
						.next();
				Iterator<String> stud_perfomance_iterator = stud_performance
						.iterator();

				jpcenter.add(new RowPanel(stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next()));
				rows++;
				jpcenter.setLayout(new GridLayout(rows, cols));
				repaint();
				validate();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Selection Empty");
			repaint();
			revalidate();
		}
	}

	public void get_paper(String paper) {
		rows = 0;
		jpcenter.removeAll();
		Vector<Vector<String>> get_all_student_marks = E_School
				.get_paper_type_marks(paper);
		if (get_all_student_marks.size() > 1) {
			Iterator<Vector<String>> get_all_student_marks_iterator = get_all_student_marks
					.iterator();
			while (get_all_student_marks_iterator.hasNext()) {
				Vector<String> stud_performance = get_all_student_marks_iterator
						.next();
				Iterator<String> stud_perfomance_iterator = stud_performance
						.iterator();

				jpcenter.add(new RowPanel(stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next()));
				rows++;
				jpcenter.setLayout(new GridLayout(rows, cols));
				repaint();
				validate();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Selection Empty");
			repaint();
			revalidate();
		}
	}

	public void get_grades(String grade) {
		rows = 0;
		jpcenter.removeAll();
		Vector<Vector<String>> get_all_student_marks = E_School
				.get_grade_marks(grade);
		if (get_all_student_marks.size() > 1) {
			Iterator<Vector<String>> get_all_student_marks_iterator = get_all_student_marks
					.iterator();
			while (get_all_student_marks_iterator.hasNext()) {
				Vector<String> stud_performance = get_all_student_marks_iterator
						.next();
				Iterator<String> stud_perfomance_iterator = stud_performance
						.iterator();

				jpcenter.add(new RowPanel(stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next()));
				rows++;
				jpcenter.setLayout(new GridLayout(rows, cols));
				repaint();
				validate();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Selection Empty");
			repaint();
			revalidate();
		}
	}

	public void get_username(String user_name) {
		rows = 0;
		jpcenter.removeAll();
		Vector<Vector<String>> get_all_student_marks = E_School
				.get_user_name_marks(user_name);
		if (get_all_student_marks.size() > 1) {
			Iterator<Vector<String>> get_all_student_marks_iterator = get_all_student_marks
					.iterator();
			while (get_all_student_marks_iterator.hasNext()) {
				Vector<String> stud_performance = get_all_student_marks_iterator
						.next();
				Iterator<String> stud_perfomance_iterator = stud_performance
						.iterator();

				jpcenter.add(new RowPanel(stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next()));
				rows++;
				jpcenter.setLayout(new GridLayout(rows, cols));
				repaint();
				validate();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Selection Empty");
			repaint();
			revalidate();
		}
	}

	public void get_class(String class_name) {
		rows = 0;
		jpcenter.removeAll();
		Vector<Vector<String>> get_all_student_marks = E_School
				.get_class_marks(class_name);
		if (get_all_student_marks.size() > 1) {
			Iterator<Vector<String>> get_all_student_marks_iterator = get_all_student_marks
					.iterator();
			while (get_all_student_marks_iterator.hasNext()) {
				Vector<String> stud_performance = get_all_student_marks_iterator
						.next();
				Iterator<String> stud_perfomance_iterator = stud_performance
						.iterator();

				jpcenter.add(new RowPanel(stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next()));
				rows++;
				jpcenter.setLayout(new GridLayout(rows, cols));
				repaint();
				validate();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Selection Empty");
			repaint();
			revalidate();
		}
	}

	public void get_stream(String stream) {
		rows = 0;
		jpcenter.removeAll();
		Vector<Vector<String>> get_all_student_marks = E_School
				.get_stream_marks(stream);
		if (get_all_student_marks.size() > 1) {
			Iterator<Vector<String>> get_all_student_marks_iterator = get_all_student_marks
					.iterator();
			while (get_all_student_marks_iterator.hasNext()) {
				Vector<String> stud_performance = get_all_student_marks_iterator
						.next();
				Iterator<String> stud_perfomance_iterator = stud_performance
						.iterator();

				jpcenter.add(new RowPanel(stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next(),
						stud_perfomance_iterator.next()));
				rows++;
				jpcenter.setLayout(new GridLayout(rows, cols));
				repaint();
				validate();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Selection Empty");
			repaint();
			revalidate();
		}
	}
}
