package com.zzh.model;

public class Attendance {
	String time;
	String course;
	String result;

	public Attendance(String time, String course, String result) {
		this.time = time;
		this.course = course;
		this.result = result;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
