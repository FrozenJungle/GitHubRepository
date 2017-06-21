package com.zzh.control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.zzh.model.Attendance;
import com.zzh.util.DBConnection;

public class Operator {
	
	
	


//	
//	public ArrayList<Attendance> fndAttendance(int studentId,int classId){
//		Connection conn = null;
//		Statement sta = null;
//		try {
//			conn = DBConnection.getConnection();
//			sta = conn.createStatement();
//			String sql = "select * from attendance_record where 'student_id'="+studentId+";";
//			ResultSet rs = sta.executeQuery(sql);
//			ArrayList<Attendance> attlist = new ArrayList<Attendance>();
//			while (rs.next()) {
//				
//			}
//			return booklist;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		} finally {
//			try {
//				sta.close();
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
}
