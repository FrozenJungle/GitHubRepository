package com.zzh.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.zzh.bean.StudentEntity;
import com.zzh.bean.TeacherEntity;
import com.zzh.dao.TeacherEntityDAO;
import com.zzh.util.DBConnection;

public class TeacherEntityDAOImpl implements TeacherEntityDAO {
	public String login(int id, String pwd) {
		Connection conn = null;
		Statement sta = null;
		String teaName = "";
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "select * from teacherInfo where teacher_id=" + id + " and teacher_login_pwd='" + pwd + "'; ";
			System.out.println(sql);
			ResultSet rs = sta.executeQuery(sql);
			if (rs.next()) {
				teaName = rs.getString("teacher_name");
				return teaName;
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

	public TeacherEntity fndTeaById(int id) {
		Connection conn = null;
		Statement sta = null;
		TeacherEntity teacher = null;

		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			// select * from stuInfo where teacher_id=?;
			String sql = "select * from teacherInfo where teacher_id=" + id + ";";
			ResultSet rs = sta.executeQuery(sql);
			if (rs.next()) {
				teacher = new TeacherEntity();
				teacher.setTeacher_id(id);
				teacher.setTeacher_name(rs.getString("teacher_name"));
				teacher.setCollege_name(rs.getString("college_name"));
				teacher.setFaculty_name(rs.getString("faculty_name"));
				teacher.setTeacher_email(rs.getString("teacher_email"));
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

	public int altTeaInfo(int id, String[] s) {
		Connection conn = null;
		Statement sta = null;
		int rtnVal = -1;

		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "update teacherInfo set teacher_name='" + s[0] + "',teacher_id=" + s[1] + ",college_name='"
					+ s[2] + "',faculty_name='" + s[3] + "',teacher_email='" + s[4] + "' where teacher_id=" + id + ";";
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

	public int updateTeaPwd(int id, String oldPwd, String newPwd) {
		Connection conn = null;
		Statement sta = null;
		int rtnVal = -1;

		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "select * from teacherInfo where teacher_id=" + id + ";";
			ResultSet rs = sta.executeQuery(sql);
			String oldPwdRt = "";
			if (rs.next()) {
				oldPwdRt = rs.getString("teacher_login_pwd");
			}
			if (oldPwdRt.equals(oldPwd)) {
				String sql1 = "update teacherInfo set teacher_login_pwd='" + newPwd + "' where teacher_id=" + id + ";";
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

	public ArrayList<StudentEntity> fndStuById(int id) {
		Connection conn = null;
		Statement sta = null;
		ArrayList<StudentEntity> student = new ArrayList<StudentEntity>();

		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();

			String sql = "select* from stuInfo where student_id="+id+";";
			System.out.println(sql);
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				StudentEntity s = new StudentEntity();
				s.setStudent_id(rs.getInt("student_id"));
				s.setStudent_name(rs.getString("student_name"));
				s.setStudent_college(rs.getString("student_college"));
				s.setStudent_major(rs.getString("student_major"));
				student.add(s);
			}
			return student;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				sta.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<StudentEntity> fndStuByName(String stuName) {
		Connection conn = null;
		Statement sta = null;
		ArrayList<StudentEntity> student = new ArrayList<StudentEntity>();

		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();

			String sql = "select* from stuInfo where student_name='"+stuName+"';";
			System.out.println(sql);
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				StudentEntity s = new StudentEntity();
				s.setStudent_id(rs.getInt("student_id"));
				s.setStudent_name(rs.getString("student_name"));
				s.setStudent_college(rs.getString("student_college"));
				s.setStudent_major(rs.getString("student_major"));
				student.add(s);
			}
			return student;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				sta.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<StudentEntity> fndStuByClassId(int classId) {
		Connection conn = null;
		Statement sta = null;
		ArrayList<StudentEntity> student = new ArrayList<StudentEntity>();

		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();

			String sql = "select * from stuInfo join classStudentInfo on stuInfo.student_id=classStudentInfo.student_id where class_id="+classId+";";
			System.out.println(sql);
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				StudentEntity s = new StudentEntity();
				s.setStudent_id(rs.getInt("student_id"));
				s.setStudent_name(rs.getString("student_name"));
				s.setStudent_college(rs.getString("student_college"));
				s.setStudent_major(rs.getString("student_major"));
				student.add(s);
			}
			return student;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				sta.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<StudentEntity> fndStuByMajor(String major) {
		Connection conn = null;
		Statement sta = null;
		ArrayList<StudentEntity> student = new ArrayList<StudentEntity>();

		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();

			String sql = "select * from stuInfo where student_major='"+major+"';";
			System.out.println(sql);
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				StudentEntity s = new StudentEntity();
				s.setStudent_id(rs.getInt("student_id"));
				s.setStudent_name(rs.getString("student_name"));
				s.setStudent_college(rs.getString("student_college"));
				s.setStudent_major(rs.getString("student_major"));
				student.add(s);
			}
			return student;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				sta.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<String> fndAllFac() {
		Connection conn = null;
		Statement sta = null;
		ArrayList<String> rtn = new ArrayList<String>();

		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "select distinct faculty_name from teacherInfo;";
			ResultSet rs = sta.executeQuery(sql);

			while (rs.next()) {
				rtn.add(rs.getString("faculty_name"));
			}
			return rtn;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				sta.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public ArrayList<String> fndAllClg() {
		Connection conn = null;
		Statement sta = null;
		ArrayList<String> rtn = new ArrayList<String>();

		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "select distinct college_name from collegeInfo;";
			ResultSet rs = sta.executeQuery(sql);

			while (rs.next()) {
				rtn.add(rs.getString("college_name"));
			}
			return rtn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				sta.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public ArrayList<String[]> fndAllAtt(int id){
		Connection conn = null;
		Statement sta = null;
		ArrayList<String[]> rtn = new ArrayList<String[]>();

		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();

			String sql = "select attendanceInfo.class_id,classInfo.course_name,stuInfo.student_id,stuInfo.student_name,attendanceInfo.record_time,attendance_record.attendance_status from((( attendance_record join stuInfo on attendance_record.student_id=stuInfo.student_Id ) join attendanceInfo on attendance_record.attendance_id=attendanceInfo.attendance_id)join classInfo on attendanceInfo.class_id=classInfo.class_id) where classInfo.teacher_id="+id+";";
			System.out.println(sql);
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				String[] a = new String[6];
				a[0]=String.valueOf(rs.getInt(1));
				a[1]=rs.getString(2);
				a[2]=String.valueOf(rs.getInt(3));
				a[3]=rs.getString(4);
				a[4]=rs.getString(5);
				a[5]=rs.getString(6);
				rtn.add(a);
			}
			return rtn;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				sta.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
