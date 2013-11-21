package TP2;

import java.util.Date;

public class TimerUtils {
	
	public static Date getCurrentTime(){
		return new Date();
	}
	
	public static double calculateTimeInSeconds(Date before) {
		Date after = new Date();
		double time = after.getTime() - before.getTime();
		return time / 1000;		
	}
	
}
