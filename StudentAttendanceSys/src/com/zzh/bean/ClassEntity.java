package com.zzh.bean;

public class ClassEntity {
	int class_id;
	int course_id;
	String course_name;
	int class_start_week;
	int class_end_week;
	String class_time;
	int teacher_id;

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public int getClass_start_week() {
		return class_start_week;
	}

	public void setClass_start_week(int class_start_week) {
		this.class_start_week = class_start_week;
	}

	public int getClass_end_week() {
		return class_end_week;
	}

	public void setClass_end_week(int class_end_week) {
		this.class_end_week = class_end_week;
	}

	public String getClass_time() {
		return class_time;
	}

	public void setClass_time(String class_time) {
		this.class_time = class_time;
	}

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
}
