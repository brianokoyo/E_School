package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.DataBaseTransactions;
import controller.E_School;

public class GradeMarks extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int rows = 1;
	int cols = 1;
	JButton jbaddrow, jbsave;
	Vector<JPanel> jp = new Vector<JPanel>();
	JComboBox jcbpaper;
	E_School e_School;

	public JPanel jpanelFactory() {
		JPanel panelfac = new JPanel();
		String[] marks = new String[100];
		for (int i = 0; i < marks.length; i++) {
			marks[i] = i + "";
		}
		panelfac.add(new JLabel("Min Mark"));
		panelfac.add(new JComboBox(marks));
		panelfac.add(new JLabel("Max Mark"));
		panelfac.add(new JComboBox(marks));
		panelfac.add(new JLabel("Grade"));
		panelfac.add(new JComboBox(DataBaseTransactions.get_grade()));
		return panelfac;
	}

	public GradeMarks() {
		jcbpaper = new JComboBox(E_School.get_paper_type());
		jbaddrow = new JButton("Add Grade");
		jbsave = new JButton("Save");

		jbaddrow.addActionListener(this);
		jbsave.addActionListener(this);

		jp.add(new JPanel());
		jp.add(new JPanel());
		jp.add(new JPanel());
		jp.add(new JPanel());

		jp.elementAt(0).add(jcbpaper);

		jp.elementAt(1).setLayout(new GridLayout(rows, cols));
		jp.elementAt(1).add(jpanelFactory());

		jp.elementAt(2).add(jbaddrow);
		jp.elementAt(2).add(jbsave);

		setLayout(new BorderLayout());
		add(jp.elementAt(0), BorderLayout.NORTH);
		add(jp.elementAt(1), BorderLayout.CENTER);
		add(jp.elementAt(2), BorderLayout.SOUTH);
		setBorder(BorderFactory.createRaisedBevelBorder());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		if (source == jbaddrow) {
			rows++;
			jp.elementAt(1).setLayout(new GridLayout(rows, cols));
			jp.elementAt(1).add(jpanelFactory());
			jp.elementAt(1).repaint();
			jp.elementAt(1).validate();
		} else if (source == jbsave) {
			get_grade();
		}
	}

	public void get_grade() {
		String paper_type = jcbpaper.getSelectedItem() + "";
		String min_mark = ((JComboBox) jpanelFactory().getComponent(1)).getSelectedItem()+ "";
		String max_mark = ((JComboBox) jpanelFactory().getComponent(3)).getSelectedItem()+ "";
		String grade = ((JComboBox) jpanelFactory().getComponent(5)).getSelectedItem()+ "";
		e_School=new E_School();
		e_School.register_subject_grading(paper_type, min_mark, max_mark, grade);
		System.out.println(paper_type);
		System.out.println(min_mark);
		System.out.println(max_mark);
		System.out.println(grade);
	}
}
