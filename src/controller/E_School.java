/**
 * 
 */
package controller;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.Vector;

import model.DataBaseTransactions;
import view.Eschool_Gui;
import view.Login;
import view.MainGui;

public class E_School {
	DataBaseTransactions dataBaseTransactions;
	static MainGui mainGui;
	Eschool_Gui eschool_Gui;
	public static Login login;

	public void validateUser(String user, String password) throws SQLException,
			ClassNotFoundException {
		dataBaseTransactions = new DataBaseTransactions(user, password);
	}

	public void register_school(String block_name) {
		DataBaseTransactions.insert_block(block_name);
	}

	public void register_level(String block_level_name) {
		DataBaseTransactions.insert_block_level(block_level_name);
	}

	public void register_block_sublevel(String block_sub_level) {
		DataBaseTransactions.insert_block_sublevel(block_sub_level);
	}

	public void register_student(String adm_no, String first_name,
			String sur_name, String last_name) {
		DataBaseTransactions.insert_student_details(adm_no, first_name,
				sur_name, last_name);
	}

	public void register_instructor(String user_name, String first_name,
			String sur_name, String last_name) {
		DataBaseTransactions.insert_instructor_details(user_name, first_name,
				sur_name, last_name);
	}

	public void register_exam_type(String exam_type, String exam_time) {
		DataBaseTransactions.insert_exam_type(exam_type, exam_time);
	}

	public void register_paper_type(String paper_type) {
		DataBaseTransactions.insert_paper_type(paper_type);
	}

	public void insert_student_score(String adm_no, String exam_type,
			String paper_type, String mark) {
		DataBaseTransactions.insert_student_score(adm_no, exam_type,
				paper_type, mark);
	}

	public void register_subject_grading(String paper_type, String min_mark,
			String max_mark, String grade) {
		DataBaseTransactions.insert_subject_grading(paper_type, min_mark,
				max_mark, grade);
	}

	public static Vector<String> get_stud_adm_no() {
		return DataBaseTransactions.get_students_adm_no();
	}

	public static Vector<String> get_paper_type() {
		return DataBaseTransactions.get_paper_type();
	}

	public static Vector<String> get_grade() {
		return DataBaseTransactions.get_grade();
	}

	public static Vector<String> get_marks() {
		return DataBaseTransactions.get_marks();
	}

	public static Vector<String> get_exam_type() {
		return DataBaseTransactions.get_exam_type();
	}

	public static Vector<String> get_username() {
		return DataBaseTransactions.get_username();
	}

	public static Vector<String> get_level_name() {
		return DataBaseTransactions.get_level_name();
	}

	public static Vector<String> get_sub_level_name() {
		return DataBaseTransactions.get_sub_level_name();
	}

	public static Vector<Vector<String>> get_all_student_marks() {
		return DataBaseTransactions.get_all_student_marks();
	}

	public static Vector<Vector<String>> get_adm_no_marks(String adm_no) {
		return DataBaseTransactions.get_adm_no_marks(adm_no);
	}

	public static Vector<Vector<String>> get_subjects_marks(String subjects) {
		return DataBaseTransactions.get_subjects_marks(subjects);
	}

	public static Vector<Vector<String>> get_exam_type_marks(String exam_type) {
		return DataBaseTransactions.get_exam_type_marks(exam_type);
	}

	public static Vector<Vector<String>> get_paper_type_marks(String paper_type) {
		return DataBaseTransactions.get_paper_type_marks(paper_type);
	}

	public static Vector<Vector<String>> get_grade_marks(String grade) {
		return DataBaseTransactions.get_grade_marks(grade);
	}

	public static Vector<Vector<String>> get_user_name_marks(String user_name) {
		return DataBaseTransactions.get_user_name_marks(user_name);
	}

	public static Vector<Vector<String>> get_class_marks(String class_name) {
		return DataBaseTransactions.get_class_marks(class_name);
	}

	public static Vector<Vector<String>> get_stream_marks(String stream_name) {
		return DataBaseTransactions.get_stream_marks(stream_name);
	}

	public static String get_admno_sum(String admno) {
		return DataBaseTransactions.get_admno_sum(admno);
	}

	public static String get_admno_avg(String admno) {
		return DataBaseTransactions.get_admno_avg(admno);
	}

	public static String get_exam_sum(String exam) {
		return DataBaseTransactions.get_exam_sum(exam);
	}

	public static String get_exam_avg(String exam) {
		return DataBaseTransactions.get_exam_avg(exam);
	}

	public static String get_paper_sum(String paper) {
		return DataBaseTransactions.get_paper_sum(paper);
	}

	public static String get_paper_avg(String paper) {
		return DataBaseTransactions.get_paper_avg(paper);
	}

	public static String get_grade_sum(String grade) {
		return DataBaseTransactions.get_grade_sum(grade);
	}

	public static String get_grade_avg(String grade) {
		return DataBaseTransactions.get_grade_avg(grade);
	}

	public static String get_username_sum(String user_name) {
		return DataBaseTransactions.get_username_sum(user_name);
	}

	public static String get_username_avg(String user_name) {
		return DataBaseTransactions.get_username_avg(user_name);
	}

	public static String get_class_sum(String classes) {
		return DataBaseTransactions.get_class_sum(classes);
	}

	public static String get_class_avg(String classes) {
		return DataBaseTransactions.get_class_avg(classes);
	}

	public static String get_sublevel_sum(String sublevel) {
		return DataBaseTransactions.get_sublevel_sum(sublevel);
	}

	public static String get_sublevel_avg(String sublevel) {
		return DataBaseTransactions.get_sublevel_avg(sublevel);
	}

	public void open_eschool() {
		eschool_Gui = new Eschool_Gui();
		mainGui.remove(login);
		mainGui.add(eschool_Gui, BorderLayout.CENTER);
		mainGui.repaint();
		mainGui.validate();
	}

	public static void main(String[] args) {
		login = new Login();
		mainGui = new MainGui();
		mainGui.add(login);
	}

}
