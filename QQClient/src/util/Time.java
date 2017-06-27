package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	public String getFullTime(){
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(now);
	}
	
	public String getHMS(){
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		return df.format(now);
	}
	
	public static void main(String args[]){
		Time time = new Time();
		System.out.println(time.getHMS());
	}
}
