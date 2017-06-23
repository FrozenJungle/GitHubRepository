package com.zzh.bean;

public class TeacherEntity {
	int teacher_id;
	String teacher_name;
	String teacher_login_pwd;
	String college_name;
	String faculty_name;
	String teacher_email;

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getTeacher_login_pwd() {
		return teacher_login_pwd;
	}

	public void setTeacher_login_pwd(String teacher_login_pwd) {
		this.teacher_login_pwd = teacher_login_pwd;
	}

	public String getCollege_name() {
		return college_name;
	}

	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}

	public String getFaculty_name() {
		return faculty_name;
	}

	public void setFaculty_name(String faculty_name) {
		this.faculty_name = faculty_name;
	}

	public String getTeacher_email() {
		return teacher_email;
	}

	public void setTeacher_email(String teacher_email) {
		this.teacher_email = teacher_email;
	}
}
