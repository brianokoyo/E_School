package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.E_School;

public class RegisterPaperAndExamType extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Vector<JPanel> jp = new Vector<JPanel>();
	Vector<JTextField> jtfexam = new Vector<JTextField>();
	Vector<JTextField> jtfexam_time = new Vector<JTextField>();
	Vector<JTextField> jtfpaper = new Vector<JTextField>();

	Vector<JLabel> jl = new Vector<JLabel>();
	Vector<JButton> jb = new Vector<JButton>();
	int rows1 = 2;
	int rows2 = 5;
	int cols = 2;
	E_School e_School;

	public RegisterPaperAndExamType() {
		jp.add(new JPanel());
		jp.add(new JPanel(new GridLayout(rows1, cols)));
		jp.add(new JPanel(new GridLayout(rows2, cols)));
		jp.add(new JPanel(new GridLayout(1, 3)));
		jp.add(new JPanel());

		jl.add(new JLabel("Exam Type"));
		jl.add(new JLabel());
		jl.add(new JLabel("Paper Type"));

		jtfexam.add(new JTextField(20));
		jtfexam_time.add(new JTextField(20));
		jtfpaper.add(new JTextField(20));

		jb.add(new JButton("Add Exam"));
		jb.add(new JButton("Add Paper"));
		jb.add(new JButton("Save"));
		jb.add(new JButton("Cancel"));

		jb.elementAt(0).addActionListener(this);
		jb.elementAt(1).addActionListener(this);
		jb.elementAt(2).addActionListener(this);
		jb.elementAt(3).addActionListener(this);

		jp.elementAt(1).add(jl.elementAt(0));
		jp.elementAt(1).add(jl.elementAt(1));
		jp.elementAt(2).add(jl.elementAt(2));

		jp.elementAt(3).add(jb.elementAt(0));
		jp.elementAt(3).add(jb.elementAt(1));
		jp.elementAt(3).add(jb.elementAt(2));
		jp.elementAt(3).add(jb.elementAt(3));

		jp.elementAt(4).setLayout(new GridLayout(1, 2));
		jp.elementAt(4).add(jp.elementAt(1));
		jp.elementAt(4).add(jp.elementAt(2));
		setLayout(new BorderLayout());

		add(jp.elementAt(4), BorderLayout.CENTER);
		add(jp.elementAt(3), BorderLayout.SOUTH);
		setBorder(BorderFactory.createRaisedBevelBorder());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		if (source == jb.elementAt(0)) {
			System.out.println("add Class");
			jtfexam.add(new JTextField());
			jtfexam_time.add(new JTextField());

			jp.elementAt(1).add(jtfexam.elementAt(jtfexam.size() - 1));
			jp.elementAt(1)
					.add(jtfexam_time.elementAt(jtfexam_time.size() - 1));

			jp.elementAt(1).setLayout(new GridLayout(rows1, cols, 20, 0));
			rows1++;
			repaint();
			validate();
		} else if (source == jb.elementAt(1)) {
			System.out.println("Add Stream");
			jtfpaper.add(new JTextField(20));
			jp.elementAt(2).add(jtfpaper.elementAt(jtfpaper.size() - 1));
			jp.elementAt(2).setLayout(new GridLayout(rows2, cols));
			rows2++;
			repaint();
			validate();
		} else if (source == jb.elementAt(2)) {
			System.out.println("saving");
			getStreams();
			getClasses();
		} else if (source == jb.elementAt(3)) {
			System.out.println("cancelling");
			jp.elementAt(1).removeAll();
			jp.elementAt(2).removeAll();
			jp.elementAt(1).add(jl.elementAt(0));
			jp.elementAt(2).add(jl.elementAt(1));
			repaint();
			validate();
		} else {

		}
	}

	public void getClasses() {
		Iterator<JTextField> jtfclassIterator = jtfexam.iterator();
		Iterator<JTextField> jtf_examtype = jtfexam_time.iterator();

		while (jtfclassIterator.hasNext()) {
			e_School = new E_School();
			e_School.register_exam_type(jtfclassIterator.next().getText(),
					jtf_examtype.next().getText());
		}
	}

	public void getStreams() {
		Iterator<JTextField> jtfpapers = jtfpaper.iterator();
		while (jtfpapers.hasNext()) {
			e_School = new E_School();
			e_School.register_paper_type(jtfpapers.next().getText());
		}
	}

}
