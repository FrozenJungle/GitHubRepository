/**
 * 
 */
package com.zzh.dao;

import java.util.ArrayList;

import com.zzh.bean.ClassEntity;
import com.zzh.bean.StudentEntity;
import com.zzh.bean.TeacherEntity;

/**
 * @author zzhsmac
 *
 */
public interface StudentEntityDAO {
	public String login(int id, String pwd);

	public StudentEntity fndStuById(int id);

	public StudentEntity[] fndStuByClass(int classId);

	public int updateStuEmail(int id, String newEmail);

	public int updateStuPwd(int id, String oldPwd, String newPwd);

	public ArrayList<TeacherEntity> fndTeaByStuId(int id);

	public ArrayList<String[]> fndClsByStuId(int id);
	
	public ArrayList<String[]> fndAttByStuId(int id,int cid);
}
