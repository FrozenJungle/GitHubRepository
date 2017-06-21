/**
 * 
 */
package com.zzh.dao;

import com.zzh.bean.StudentEntity;

/**
 * @author zzhsmac
 *
 */
public interface StudentEntityDAO {
	public String login(int id,String pwd);
	public StudentEntity fndStuById(int id);
	public StudentEntity[] fndStuByClass(int classId);
	public int updateStuEmail(int id,String newEmail);
	public int updateStuPwd(int id,String oldPwd,String newPwd);
}
