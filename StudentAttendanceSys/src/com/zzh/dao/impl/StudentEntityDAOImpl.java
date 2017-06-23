package com.zzh.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.zzh.bean.ClassEntity;
import com.zzh.bean.StudentEntity;
import com.zzh.bean.TeacherEntity;
import com.zzh.dao.StudentEntityDAO;
import com.zzh.util.DBConnection;

public class StudentEntityDAOImpl implements StudentEntityDAO {

	public String login(int id, String pwd) {
		Connection conn = null;
		Statement sta = null;
		String stuName = "";
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "select * from stuInfo where student_id=" + id + " and student_login_pwd='" + pwd + "'; ";
			System.out.println(sql);
			ResultSet rs = sta.executeQuery(sql);
			if (rs.next()) {
				stuName = rs.getString("student_name");
				return stuName;
			} else {
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				sta.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public StudentEntity fndStuById(int id) {
		Connection conn = null;
		Statement sta = null;
		StudentEntity student = null;

		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			// select * from stuInfo where student_id=?;
			String sql = "select * from stuInfo where student_id=" + id + ";";
			ResultSet rs = sta.executeQuery(sql);
			if (rs.next()) {
				student = new StudentEntity();
				student.setStudent_id(id);
				student.setStudent_name(rs.getString("student_name"));
				student.setStudent_college(rs.getString("student_college"));
				student.setStudent_major(rs.getString("student_major"));
				student.setStudent_email(rs.getString("student_email"));
			}
			return student;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				sta.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public StudentEntity[] fndStuByClass(int classId) {
		Connection conn = null;
		Statement sta = null;
		StudentEntity student[] = null;
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			// select * from StuAttend.stuInfo where student_id=any(select
			// student_id from classStudentInfo where class_id=?);
			String sql = "select * from stuInfo where student_id="
					+ "any(select student_id from classStudentInfo where class_id=" + classId + ");";
			System.out.println(sql);
			ResultSet rs = sta.executeQuery(sql);
			int i = 0;
			student = new StudentEntity[rs.getRow()];
			while (rs.next()) {
				student[i] = new StudentEntity();
				student[i].setStudent_id(rs.getInt("student_id"));
				student[i].setStudent_name(rs.getString("student_name"));
				student[i].setStudent_college(rs.getString("student_college"));
				student[i].setStudent_major(rs.getString("student_major"));
				student[i].setStudent_email(rs.getString("student_email"));
				i++;
			}
			return student;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				sta.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public int updateStuEmail(int id, String newEmail) {
		Connection conn = null;
		Statement sta = null;
		int rtnVal = -1;

		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "update stuInfo set student_email='" + newEmail + "' where student_id=" + id + ";";
			rtnVal = sta.executeUpdate(sql);
			return rtnVal;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally {
			try {
				sta.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public int updateStuPwd(int id, String oldPwd, String newPwd) {
		Connection conn = null;
		Statement sta = null;
		int rtnVal = -1;

		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "select * from stuInfo where student_id=" + id + ";";
			ResultSet rs = sta.executeQuery(sql);
			String oldPwdRt = "";
			if (rs.next()) {
				oldPwdRt = rs.getString("student_login_pwd");
			}
			if (oldPwdRt.equals(oldPwd)) {
				String sql1 = "update stuInfo set student_login_pwd='" + newPwd + "' where student_id=" + id + ";";
				rtnVal = sta.executeUpdate(sql1);
			}
			return rtnVal;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally {
			try {
				sta.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ArrayList<TeacherEntity> fndTeaByStuId(int id) {
		Connection conn = null;
		Statement sta = null;
		ArrayList<TeacherEntity> teacher = new ArrayList<TeacherEntity>();

		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			// select * from teacherInfo where teacher_id=any(select teacher_id
			// from classInfo where class_id=any(select class_id from
			// classStudentInfo where student_id=any(select student_id from
			// stuInfo where student_id=?)));
			String sql = "select* from teacherInfo where teacher_id=any(select teacher_id from classInfo where class_id=any(select class_id from classStudentInfo where student_id=any(select student_id from stuInfo where student_id="
					+ id + ")));";
			System.out.println(sql);
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				TeacherEntity teacherL = new TeacherEntity();
				teacherL.setTeacher_id(rs.getInt("teacher_id"));
				teacherL.setTeacher_name(rs.getString("teacher_name"));
				teacherL.setCollege_name(rs.getString("college_name"));
				teacherL.setFaculty_name(rs.getString("faculty_name"));
				teacherL.setTeacher_email(rs.getString("teacher_email"));
				teacher.add(teacherL);
			}
			return teacher;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				sta.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public ArrayList<String[]> fndClsByStuId(int id) {
		Connection conn = null;
		Statement sta = null;
		ArrayList<String[]> class_ = new ArrayList<String[]>();

		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			// select classInfo.class_id, classInfo.course_name,
			// teacherInfo.teacher_name from classInfo left join teacherInfo on
			// classInfo.teacher_id = teacherInfo.teacher_id where
			// class_id=any(select class_id from classStudentInfo where
			// student_id=1);
			String sql = "select classInfo.class_id, classInfo.course_name, teacherInfo.teacher_name from classInfo left join teacherInfo on classInfo.teacher_id = teacherInfo.teacher_id where class_id=any(select class_id from classStudentInfo where student_id="
					+ id + ");";
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				String class_id = String.valueOf(rs.getInt("class_id"));
				String course_name = rs.getString("course_name");
				String teacher_name = rs.getString("teacher_name");
				String c[] = { class_id, course_name, teacher_name };
				class_.add(c);
			}
			return class_;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				sta.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ArrayList<String[]> fndAttByStuId(int id, int cid) {
		Connection conn = null;
		Statement sta = null;
		ArrayList<String[]> att = new ArrayList<String[]>();

		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "select attendanceInfo.record_time, classInfo.course_name, attendance_record.attendance_status from (((attendanceInfo inner join classInfo on attendanceInfo.class_id=classInfo.class_id ) inner join attendance_record on attendanceInfo.attendance_id=attendance_record.attendance_id) inner join stuInfo on stuInfo.student_id=attendance_record.student_id) where stuInfo.student_id="
					+ id + " and classInfo.class_id=" + cid + ";";
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				String rt = rs.getString("record_time");
				String course_name = rs.getString("course_name");
				String as = rs.getString("attendance_status");
				String c[] = { rt, course_name, as };
				att.add(c);
			}
			return att;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				sta.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
