package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DataBaseTransactions {
	Connection conn = null;
	static Statement stmt = null;
	static ResultSet rst = null;

	public DataBaseTransactions(String user, String password)
			throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/E_school";
		conn = DriverManager.getConnection(url, user, password);
		stmt = conn.createStatement();
		get_all_student_marks();
	}

	public void create_user(String user, String password) {
		String create_user = "CREATE USER '" + user + "'@'%' IDENTIFIED BY '"
				+ password + "'";
		String grant_user_pribiledges = " GRANT SELECT,UPDATE,INSERT ON E_school.* TO '"
				+ user + "'";
		String flush_privileges = "FLUSH PRIVILEGES";

		try {
			stmt.executeUpdate(create_user);
			stmt.executeUpdate(grant_user_pribiledges);
			stmt.executeQuery(flush_privileges);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void insert_block(String block_name) {
		System.out.println(block_name);

		String register_school = "INSERT INTO block VALUES ('" + block_name
				+ "')";
		try {
			stmt.executeUpdate(register_school);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insert_block_level(String block_level_name) {
		String register_block = "INSERT INTO block_level VALUES ('"
				+ block_level_name + "')";
		try {
			stmt.executeUpdate(register_block);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insert_block_sublevel(String block_sub_level) {
		String register_sublevel = "INSERT INTO block_sub_level VALUES ('"
				+ block_sub_level + "')";
		try {
			stmt.executeUpdate(register_sublevel);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insert_instructor_details(String user_name,
			String first_name, String sur_name, String last_name) {
		String register_instructor = "INSERT INTO instructor_details VALUES ('"
				+ user_name + "','" + first_name + "','" + sur_name + "','"
				+ last_name + "')";
		try {
			stmt.executeUpdate(register_instructor);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insert_exam_type(String exam_type, String exam_time) {
		String register_exam_type = "INSERT INTO exam_type VALUES ('"
				+ exam_type + "','" + exam_time + "')";
		try {
			stmt.executeUpdate(register_exam_type);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insert_paper_type(String paper_type) {
		String register_paper_type = "INSERT INTO paper_type VALUES ('"
				+ paper_type + "')";
		try {
			stmt.executeUpdate(register_paper_type);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insert_student_details(String adm_no, String first_name,
			String sur_name, String last_name) {
		String register_student = "INSERT INTO student_details VALUES ('"
				+ adm_no + "','" + first_name + "','" + sur_name + "','"
				+ last_name + "')";
		try {
			stmt.executeUpdate(register_student);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insert_student_score(String adm_no, String exam_type,
			String paper_type, String mark) {
		String grade = "SET @grade = (SELECT grade FROM mark_grade WHERE min_mark<'"
				+ mark
				+ "' AND max_mark >'"
				+ mark
				+ "' AND paper_type = 'Mathematics')";
		String user_name = "SET @username =(SELECT SUBSTRING_INDEX(USER(),'@',1))";
		String register_student_score = "INSERT INTO student_score VALUES ('"
				+ adm_no + "','" + exam_type + "','" + paper_type + "','"
				+ mark + "',@grade,UNIX_TIMESTAMP(DATE(NOW())),@username)";
		try {
			stmt.executeUpdate(grade);
			stmt.executeUpdate(user_name);
			stmt.executeUpdate(register_student_score);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insert_subject_grading(String paper_type,
			String min_mark, String max_mark, String grade) {
		String register_student_score = "INSERT INTO mark_grade VALUES('"
				+ paper_type + "','" + min_mark + "','" + max_mark + "','"
				+ grade + "',UNIX_TIMESTAMP(DATE(NOW())))";
		try {
			stmt.executeUpdate(register_student_score);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Vector<String> get_students_adm_no() {
		Vector<String> adm_no = new Vector<String>();

		String admn_no = "SELECT adm_no FROM student_details";
		try {
			rst = stmt.executeQuery(admn_no);
			while (rst.next()) {
				adm_no.add(rst.getString("adm_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adm_no;
	}

	public static Vector<String> get_paper_type() {
		Vector<String> subject = new Vector<String>();

		String admn_no = "SELECT paper_type FROM paper_type";
		try {
			rst = stmt.executeQuery(admn_no);
			while (rst.next()) {
				subject.add(rst.getString("paper_type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return subject;
	}

	public static Vector<String> get_marks() {
		Vector<String> marks = new Vector<String>();

		String mark = "SELECT marks FROM marks";
		try {
			rst = stmt.executeQuery(mark);
			while (rst.next()) {
				marks.add(rst.getString("marks"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return marks;
	}

	public static Vector<String> get_grade() {
		Vector<String> grades = new Vector<String>();

		String admn_no = "SELECT grade FROM grades";
		try {
			rst = stmt.executeQuery(admn_no);
			while (rst.next()) {
				grades.add(rst.getString("grade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return grades;
	}

	public static Vector<String> get_exam_type() {
		Vector<String> exam_type = new Vector<String>();

		String admn_no = "SELECT exam_type FROM exam_type";
		try {
			rst = stmt.executeQuery(admn_no);
			while (rst.next()) {
				exam_type.add(rst.getString("exam_type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exam_type;
	}

	public static Vector<String> get_username() {
		Vector<String> user_name = new Vector<String>();

		String user_names = "SELECT user_name FROM instructor_details";
		try {
			rst = stmt.executeQuery(user_names);
			while (rst.next()) {
				user_name.add(rst.getString("user_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user_name;
	}

	public static Vector<String> get_level_name() {
		Vector<String> level_name = new Vector<String>();

		String level_names = "SELECT level_name FROM block_level";
		try {
			rst = stmt.executeQuery(level_names);
			while (rst.next()) {
				level_name.add(rst.getString("level_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return level_name;
	}

	public static Vector<String> get_sub_level_name() {
		Vector<String> sub_level_name = new Vector<String>();

		String sub_level_names = "SELECT sub_level_name FROM block_sub_level";
		try {
			rst = stmt.executeQuery(sub_level_names);
			while (rst.next()) {
				sub_level_name.add(rst.getString("sub_level_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sub_level_name;
	}

	public static Vector<Vector<String>> get_all_student_marks() {
		Vector<Vector<String>> students_perfomance = new Vector<Vector<String>>();

		String select_all_students = "SELECT adm_no,exam_type,paper_type,mark,grade,user_name,class,stream FROM student_score";
		try {

			rst = stmt.executeQuery(select_all_students);
			ResultSetMetaData md = rst.getMetaData();
			int columns = md.getColumnCount();

			while (rst.next()) {
				Vector<String> all_students = new Vector<String>(columns);

				for (int i = 1; i <= columns; i++) {
					String persons_data = rst.getString(i);
					all_students.addElement(persons_data);
				}
				students_perfomance.add(all_students);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students_perfomance;
	}

	public static Vector<Vector<String>> get_adm_no_marks(String adm_no) {
		Vector<Vector<String>> students_perfomance = new Vector<Vector<String>>();

		String select_student_performance = "SELECT adm_no,exam_type,paper_type,mark,grade,user_name,class,stream FROM student_score WHERE adm_no='"
				+ adm_no + "'";

		try {

			rst = stmt.executeQuery(select_student_performance);
			ResultSetMetaData md = rst.getMetaData();
			int columns = md.getColumnCount();

			while (rst.next()) {
				Vector<String> students_in_admno = new Vector<String>(columns);
				for (int i = 1; i <= columns; i++) {
					String persons_data = rst.getString(i);
					students_in_admno.addElement(persons_data);
				}
				students_perfomance.add(students_in_admno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students_perfomance;
	}

	public static Vector<Vector<String>> get_exam_type_marks(String exam_type) {
		Vector<Vector<String>> students_perfomance = new Vector<Vector<String>>();

		String select_exam_performance = "SELECT adm_no,exam_type,paper_type,mark,grade,user_name,class,stream FROM student_score WHERE exam_type='"
				+ exam_type + "'";
		try {
			rst = stmt.executeQuery(select_exam_performance);
			ResultSetMetaData md = rst.getMetaData();
			int columns = md.getColumnCount();

			while (rst.next()) {
				Vector<String> students_in_exam = new Vector<String>(columns);
				for (int i = 1; i <= columns; i++) {
					String persons_data = rst.getString(i);
					students_in_exam.addElement(persons_data);
				}
				students_perfomance.add(students_in_exam);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students_perfomance;
	}

	public static Vector<Vector<String>> get_paper_type_marks(String paper_type) {
		Vector<Vector<String>> students_perfomance = new Vector<Vector<String>>();

		String select_paper_type_performance = "SELECT adm_no,exam_type,paper_type,mark,grade,user_name,class,stream FROM student_score WHERE paper_type='"
				+ paper_type + "'";
		try {
			rst = stmt.executeQuery(select_paper_type_performance);
			ResultSetMetaData md = rst.getMetaData();
			int columns = md.getColumnCount();

			while (rst.next()) {
				Vector<String> students_in_paper_type = new Vector<String>(
						columns);
				for (int i = 1; i <= columns; i++) {
					String persons_data = rst.getString(i);
					students_in_paper_type.addElement(persons_data);
				}
				students_perfomance.add(students_in_paper_type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students_perfomance;
	}

	public static Vector<Vector<String>> get_mark_marks(String marks) {
		Vector<Vector<String>> students_perfomance = new Vector<Vector<String>>();

		String select_marks_students = "SELECT adm_no,exam_type,paper_type,mark,grade,user_name,class,stream FROM student_score WHERE marks='"
				+ marks + "'";
		try {

			rst = stmt.executeQuery(select_marks_students);
			ResultSetMetaData md = rst.getMetaData();
			int columns = md.getColumnCount();

			while (rst.next()) {
				Vector<String> marks_students = new Vector<String>(columns);

				for (int i = 1; i <= columns; i++) {
					String persons_data = rst.getString(i);
					marks_students.addElement(persons_data);
				}
				students_perfomance.add(marks_students);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students_perfomance;
	}

	public static Vector<Vector<String>> get_grade_marks(String grade) {
		Vector<Vector<String>> students_perfomance = new Vector<Vector<String>>();

		String select_grade_performance = "SELECT adm_no,exam_type,paper_type,mark,grade,user_name,class,stream FROM student_score WHERE grade='"
				+ grade + "'";
		try {

			rst = stmt.executeQuery(select_grade_performance);
			ResultSetMetaData md = rst.getMetaData();
			int columns = md.getColumnCount();

			while (rst.next()) {
				Vector<String> students_in_grade = new Vector<String>(columns);
				for (int i = 1; i <= columns; i++) {
					String persons_data = rst.getString(i);
					students_in_grade.addElement(persons_data);
				}
				students_perfomance.add(students_in_grade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students_perfomance;
	}

	public static Vector<Vector<String>> get_user_name_marks(String user_name) {
		Vector<Vector<String>> students_perfomance = new Vector<Vector<String>>();

		String select_grade_performance = "SELECT adm_no,exam_type,paper_type,mark,grade,user_name,class,stream FROM student_score WHERE user_name='"
				+ user_name + "'";
		try {
			rst = stmt.executeQuery(select_grade_performance);
			ResultSetMetaData md = rst.getMetaData();
			int columns = md.getColumnCount();

			while (rst.next()) {
				Vector<String> students_in_user_name = new Vector<String>(
						columns);
				for (int i = 1; i <= columns; i++) {
					String persons_data = rst.getString(i);
					students_in_user_name.addElement(persons_data);
				}
				students_perfomance.add(students_in_user_name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students_perfomance;
	}

	public static Vector<Vector<String>> get_class_marks(String class_name) {
		Vector<Vector<String>> students_perfomance = new Vector<Vector<String>>();

		String select_class_performance = "SELECT adm_no,exam_type,paper_type,mark,grade,user_name,class,stream FROM student_score WHERE class='"
				+ class_name + "'";

		try {

			rst = stmt.executeQuery(select_class_performance);
			ResultSetMetaData md = rst.getMetaData();
			int columns = md.getColumnCount();

			while (rst.next()) {
				Vector<String> students_in_class = new Vector<String>(columns);
				for (int i = 1; i <= columns; i++) {
					String persons_data = rst.getString(i);
					students_in_class.addElement(persons_data);
				}
				students_perfomance.add(students_in_class);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students_perfomance;
	}

	public static Vector<Vector<String>> get_stream_marks(String stream_name) {
		Vector<Vector<String>> students_perfomance = new Vector<Vector<String>>();

		String select_stream_performance = "SELECT adm_no,exam_type,paper_type,mark,grade,user_name,class,stream FROM student_score WHERE stream='"
				+ stream_name + "'";

		try {

			rst = stmt.executeQuery(select_stream_performance);
			ResultSetMetaData md = rst.getMetaData();
			int columns = md.getColumnCount();

			while (rst.next()) {
				Vector<String> students_in_stream = new Vector<String>(columns);
				for (int i = 1; i <= columns; i++) {
					String persons_data = rst.getString(i);
					students_in_stream.addElement(persons_data);
				}
				students_perfomance.add(students_in_stream);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students_perfomance;
	}

	public static Vector<Vector<String>> get_subjects_marks(String subjects_name) {
		Vector<Vector<String>> subjects_perfomance = new Vector<Vector<String>>();

		String select_subjects_performance = "SELECT adm_no,exam_type,paper_type mark,grade,user_name,class,stream FROM student_score WHERE subjects='"
				+ subjects_name + "'";

		try {

			rst = stmt.executeQuery(select_subjects_performance);
			ResultSetMetaData md = rst.getMetaData();
			int columns = md.getColumnCount();

			while (rst.next()) {
				Vector<String> students_in_stream = new Vector<String>(columns);
				for (int i = 1; i <= columns; i++) {
					String persons_data = rst.getString(i);
					students_in_stream.addElement(persons_data);
				}
				subjects_perfomance.add(students_in_stream);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return subjects_perfomance;
	}

	public static String get_admno_sum(String admno) {
		String setsum = "SET @sum = (SELECT SUM(mark) FROM student_score WHERE adm_no = '"
				+ admno + "')";
		String getsum = "SELECT @sum";
		String sum = "";
		try {
			stmt.executeUpdate(setsum);
			rst = stmt.executeQuery(getsum);
			while (rst.next()) {
				sum = rst.getString("@sum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}

	public static String get_admno_avg(String admno) {
		String setavg = "SET @avg = (SELECT AVG(mark) FROM student_score  WHERE adm_no = '"
				+ admno + "')";
		String truncate_avg = "SET @truncated_avg = (SELECT TRUNCATE(@avg,1))";
		String gettruncate_avg = "SELECT @truncated_avg";
		String avg = "";
		try {
			stmt.executeUpdate(setavg);
			stmt.executeUpdate(truncate_avg);
			rst = stmt.executeQuery(gettruncate_avg);
			while (rst.next()) {
				avg = rst.getString("@truncated_avg");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return avg;
	}

	public static String get_exam_sum(String exam) {
		String setsum = "SET @sum = (SELECT SUM(mark) FROM student_score  WHERE exam_type = '"
				+ exam + "')";
		String getsum = "SELECT @sum";
		String sums = "";
		try {
			stmt.executeUpdate(setsum);
			rst = stmt.executeQuery(getsum);
			while (rst.next()) {
				sums = rst.getString("@sum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sums;
	}

	public static String get_exam_avg(String exam) {
		String setavg = "SET @avg = (SELECT AVG(mark) FROM student_score  WHERE exam_type = '"
				+ exam + "')";
		String truncate_avg = "SET @truncated_avg = (SELECT TRUNCATE(@avg,1))";
		String gettruncate_avg = "SELECT @truncated_avg";
		String avg = "";
		try {
			stmt.executeUpdate(setavg);
			stmt.executeUpdate(truncate_avg);
			rst = stmt.executeQuery(gettruncate_avg);
			while (rst.next()) {
				avg = rst.getString("@truncated_avg");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return avg;
	}

	public static String get_paper_sum(String paper) {
		String setsum = "SET @sum = (SELECT SUM(mark) FROM student_score  WHERE paper_type = '"
				+ paper + "')";
		String getsum = "SELECT @sum";
		String sums = "";
		try {
			stmt.executeUpdate(setsum);
			rst = stmt.executeQuery(getsum);
			while (rst.next()) {
				sums = rst.getString("@sum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sums;
	}

	public static String get_paper_avg(String paper) {
		String setavg = "SET @avg = (SELECT AVG(mark) FROM student_score  WHERE paper_type = '"
				+ paper + "')";
		String truncate_avg = "SET @truncated_avg = (SELECT TRUNCATE(@avg,1))";
		String gettruncate_avg = "SELECT @truncated_avg";
		String avg = "";
		try {
			stmt.executeUpdate(setavg);
			stmt.executeUpdate(truncate_avg);
			rst = stmt.executeQuery(gettruncate_avg);
			while (rst.next()) {
				avg = rst.getString("@truncated_avg");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return avg;
	}

	public static String get_grade_sum(String grade) {
		String setsum = "SET @sum = (SELECT SUM(mark) FROM student_score  WHERE grade = '"
				+ grade + "')";
		String getsum = "SELECT @sum";
		String sums = "";
		try {
			stmt.executeUpdate(setsum);
			rst = stmt.executeQuery(getsum);
			while (rst.next()) {
				sums = rst.getString("@sum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sums;
	}

	public static String get_grade_avg(String grade) {
		String setavg = "SET @avg = (SELECT AVG(mark) FROM student_score  WHERE grade = '"
				+ grade + "')";
		String truncate_avg = "SET @truncated_avg = (SELECT TRUNCATE(@avg,1))";
		String gettruncate_avg = "SELECT @truncated_avg";
		String avg = "";
		try {
			stmt.executeUpdate(setavg);
			stmt.executeUpdate(truncate_avg);
			rst = stmt.executeQuery(gettruncate_avg);
			while (rst.next()) {
				avg = rst.getString("@truncated_avg");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return avg;
	}

	public static String get_username_sum(String user_name) {
		String setsum = "SET @sum = (SELECT SUM(mark) FROM student_score  WHERE user_name = '"
				+ user_name + "')";
		String getsum = "SELECT @sum";
		String sums = "";
		try {
			stmt.executeUpdate(setsum);
			rst = stmt.executeQuery(getsum);
			while (rst.next()) {
				sums = rst.getString("@sum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sums;
	}

	public static String get_username_avg(String user_name) {
		String setavg = "SET @avg = (SELECT AVG(mark) FROM student_score  WHERE user_name = '"
				+ user_name + "')";
		String truncate_avg = "SET @truncated_avg = (SELECT TRUNCATE(@avg,1))";
		String gettruncate_avg = "SELECT @truncated_avg";
		String avg = "";
		try {
			stmt.executeUpdate(setavg);
			stmt.executeUpdate(truncate_avg);
			rst = stmt.executeQuery(gettruncate_avg);
			while (rst.next()) {
				avg = rst.getString("@truncated_avg");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return avg;
	}

	public static String get_class_sum(String classes) {
		String setsum = "SET @sum = (SELECT SUM(mark) FROM student_score  WHERE class = '"
				+ classes + "')";
		String getsum = "SELECT @sum";
		String sums = "";
		try {
			stmt.executeUpdate(setsum);
			rst = stmt.executeQuery(getsum);
			while (rst.next()) {
				sums = rst.getString("@sum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sums;
	}

	public static String get_class_avg(String classes) {
		String setavg = "SET @avg = (SELECT AVG(mark) FROM student_score  WHERE class = '"
				+ classes + "')";
		String truncate_avg = "SET @truncated_avg = (SELECT TRUNCATE(@avg,1))";
		String gettruncate_avg = "SELECT @truncated_avg";
		String avg = "";
		try {
			stmt.executeUpdate(setavg);
			stmt.executeUpdate(truncate_avg);
			rst = stmt.executeQuery(gettruncate_avg);
			while (rst.next()) {
				avg = rst.getString("@truncated_avg");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return avg;
	}

	public static String get_sublevel_sum(String sublevel) {
		String setsum = "SET @sum = (SELECT SUM(mark) FROM student_score  WHERE stream = '"
				+ sublevel + "')";
		String getsum = "SELECT @sum";
		String sums = "";
		try {
			stmt.executeUpdate(setsum);
			rst = stmt.executeQuery(getsum);
			while (rst.next()) {
				sums = rst.getString("@sum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sums;
	}

	public static String get_sublevel_avg(String sublevel) {
		String setavg = "SET @avg = (SELECT AVG(mark) FROM student_score  WHERE stream = '"
				+ sublevel + "')";
		String truncate_avg = "SET @truncated_avg = (SELECT TRUNCATE(@avg,1))";
		String gettruncate_avg = "SELECT @truncated_avg";
		String avg = "";
		try {
			stmt.executeUpdate(setavg);
			stmt.executeUpdate(truncate_avg);
			rst = stmt.executeQuery(gettruncate_avg);
			while (rst.next()) {
				avg = rst.getString("@truncated_avg");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return avg;
	}

}
