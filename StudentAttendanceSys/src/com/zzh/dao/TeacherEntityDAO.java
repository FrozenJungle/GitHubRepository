package com.zzh.dao;

import java.util.ArrayList;

import com.zzh.bean.StudentEntity;
import com.zzh.bean.TeacherEntity;

public interface TeacherEntityDAO {
	public String login(int id, String pwd);
	public TeacherEntity fndTeaById(int id);
	public int altTeaInfo(int id,String[] s);
	public int updateTeaPwd(int id,String oldPwd,String newPwd);
	public ArrayList<StudentEntity> fndStuById(int id);
	public ArrayList<StudentEntity> fndStuByName(String stuName);
	public ArrayList<StudentEntity> fndStuByClassId(int classId);
	public ArrayList<StudentEntity> fndStuByMajor(String major);
	public ArrayList<String> fndAllFac();
	public ArrayList<String> fndAllClg();
	public ArrayList<String[]> fndAllAtt(int id);
}
