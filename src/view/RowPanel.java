package view;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RowPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Vector<JTextField> jtf = new Vector<JTextField>();
	JCheckBox jcb = new JCheckBox();;

	JTextField jtfFactory(String text) {
		JTextField template = new JTextField(text);
		template.setBorder(BorderFactory.createLoweredBevelBorder());
		template.setEditable(false);
		return template;
	}

	// adm_no,exam_type,paper_type,mark,grade,time,user_name,class,stream
	public RowPanel(String adm_no, String exam_type, String paper_type,
			String mark, String grade, String user_name,
			String class_name, String stream) {
		add(jtfFactory(adm_no));
		add(jtfFactory(exam_type));
		add(jtfFactory(paper_type));
		add(jtfFactory(mark));
		add(jtfFactory(grade));
		add(jtfFactory(user_name));
		add(jtfFactory(class_name));
		add(jtfFactory(stream));

		setLayout(new GridLayout(1, 9));
	}
	
}
