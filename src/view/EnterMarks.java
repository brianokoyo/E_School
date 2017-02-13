package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.E_School;

public class EnterMarks extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	Vector<JComboBox> jcb = new Vector<JComboBox>();
	Vector<JButton> jb = new Vector<JButton>();
	Vector<JTextField> jtf = new Vector<JTextField>();
	Vector<JPanel> jp = new Vector<JPanel>();
	Vector<String> admissionNo = new Vector<String>();
	E_School e_School;

	public EnterMarks() {
		jcb.add(new JComboBox(E_School.get_stud_adm_no()));
		jcb.add(new JComboBox(E_School.get_paper_type()));
		jcb.add(new JComboBox(E_School.get_exam_type()));

		jb.add(new JButton("Save"));
		jb.add(new JButton("Cancel"));
		
		jb.elementAt(0).addActionListener(this);
		jb.elementAt(1).addActionListener(this);

		jtf.add(new JTextField(20));

		jp.add(new JPanel(new GridLayout(1, 3)));
		jp.add(new JPanel(new GridLayout(1, 2)));

		jp.elementAt(0).add(jcb.elementAt(0));
		jp.elementAt(0).add(jcb.elementAt(1));
		jp.elementAt(0).add(jcb.elementAt(2));
		jp.elementAt(0).add(jtf.elementAt(0));

		jp.elementAt(1).add(jb.elementAt(0));
		jp.elementAt(1).add(jb.elementAt(1));

		setLayout(new BorderLayout());
		add(jp.elementAt(0), BorderLayout.NORTH);
		add(jp.elementAt(1), BorderLayout.SOUTH);
		setBorder(BorderFactory.createRaisedBevelBorder());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		if (source == jb.elementAt(0)) {
			System.out.println("saving");
			String adm_no = (String) jcb.elementAt(0).getSelectedItem();
			String paper_type = (String) jcb.elementAt(1).getSelectedItem();
			String exam_type = (String) jcb.elementAt(2).getSelectedItem();
			String mark = jtf.elementAt(0).getText();
			e_School=new E_School();
			e_School.insert_student_score(adm_no, exam_type, paper_type, mark);
		} else if (source == jb.elementAt(1)) {
			System.out.println("canceling");
			int size = jtf.size();
			for (int i = 0; i < size; i++) {
				jtf.elementAt(i).setText("");
			}
		}
	}
}
