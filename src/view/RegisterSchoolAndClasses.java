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

public class RegisterSchoolAndClasses extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Vector<JPanel> jp = new Vector<JPanel>();
	Vector<JTextField> jtfsch = new Vector<JTextField>();
	Vector<JTextField> jtfcls = new Vector<JTextField>();
	Vector<JTextField> jtfstrm = new Vector<JTextField>();

	Vector<JLabel> jl = new Vector<JLabel>();
	Vector<JButton> jb = new Vector<JButton>();
	int rows1 = 5;
	int rows2 = 5;
	int cols = 1;
	E_School e_School;

	public RegisterSchoolAndClasses() {
		jp.add(new JPanel());
		jp.add(new JPanel(new GridLayout(rows1, cols)));
		jp.add(new JPanel(new GridLayout(rows2, cols)));
		jp.add(new JPanel(new GridLayout(1, 3)));
		jp.add(new JPanel());

		jl.add(new JLabel("School Name"));
		jl.add(new JLabel("Class Name"));
		jl.add(new JLabel("Stream Name"));

		jtfsch.add(new JTextField(20));
		jtfsch.add(new JTextField(20));
		jtfsch.add(new JTextField(20));

		jb.add(new JButton("Add Class"));
		jb.add(new JButton("Add Stream"));
		jb.add(new JButton("Save"));
		jb.add(new JButton("Cancel"));

		jb.elementAt(0).addActionListener(this);
		jb.elementAt(1).addActionListener(this);
		jb.elementAt(2).addActionListener(this);
		jb.elementAt(3).addActionListener(this);

		jp.elementAt(0).add(jl.elementAt(0));
		jp.elementAt(0).add(jtfsch.elementAt(0));

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

		add(jp.elementAt(0), BorderLayout.NORTH);
		add(jp.elementAt(4), BorderLayout.CENTER);
		add(jp.elementAt(3), BorderLayout.SOUTH);
		setBorder(BorderFactory.createRaisedBevelBorder());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		if (source == jb.elementAt(0)) {
			System.out.println("add Class");
			jtfcls.add(generateTextFields("class", 20));
			jp.elementAt(1).add(jtfcls.elementAt(jtfcls.size() - 1));
			jp.elementAt(1).setLayout(new GridLayout(rows1, cols));
			rows1++;
			repaint();
			validate();
		} else if (source == jb.elementAt(1)) {
			System.out.println("Add Stream");
			jtfstrm.add(generateTextFields("steam", 20));
			jp.elementAt(2).add(jtfstrm.elementAt(jtfstrm.size() - 1));
			jp.elementAt(2).setLayout(new GridLayout(rows2, cols));
			rows2++;
			repaint();
			validate();
		} else if (source == jb.elementAt(2)) {
			registerSchool();
			getClasses();
			getStreams();
			System.out.println("saving");
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

	private JTextField generateTextFields(String name, int size) {
		JTextField field = new JTextField(size);
		field.setName(name);
		return field;

	}

	public void registerSchool() {
		String school = jtfsch.elementAt(0).getText();
		e_School = new E_School();
		e_School.register_school(school);
	}

	public void getClasses() {
		Iterator<JTextField> jtfclassIterator = jtfcls.iterator();
		while (jtfclassIterator.hasNext()) {
			e_School = new E_School();
			e_School.register_level(jtfclassIterator.next().getText());
		}
	}

	public void getStreams() {
		Iterator<JTextField> jtfclassIterator = jtfstrm.iterator();
		while (jtfclassIterator.hasNext()) {
			e_School = new E_School();
			e_School.register_block_sublevel(jtfclassIterator.next().getText());
		}
	}
}
