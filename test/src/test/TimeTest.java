package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest {

	public static void main(String[] args) { 
//		TimeTest xx = new TimeTest();
//        long now = System.currentTimeMillis();
////		System.out.println("today: "+ xx.getBaseDate(now));
////		System.out.println("yesterday: "+ xx.getBaseDate(now-xx.ONE_DAY_MS));
//        now = 177705825l;
//        SimpleDateFormat form = new SimpleDateFormat("yyyy MM dd HH:mm");
//        Date d = new Date(now);
//        System.out.print(form.format(d));
		System.out.println(-4%5);
		System.out.println(3%5);
		
		
	}
	
	final long ONE_DAY_MS = 24*60*60*1000;
    final SimpleDateFormat timeFormat = new SimpleDateFormat("yyyyMMdd");
	private int getBaseTime(int hour24) {
		if(hour24%3==2) return hour24;
		else if (hour24<2) return 23;
		else return hour24 - hour24%3 -1;
	}
	private String getBaseDate(long timeMs) {
		Date date = new Date(timeMs);
		return timeFormat.format(date);
		
	}
    private String getTime1() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat timeFormat = new SimpleDateFormat("HHmm");
        String getTime1 = timeFormat.format(date);

        long getTime2 = Long.parseLong(getTime1);

        if ((getTime2 <= 210) || (getTime2 >= 2311)) {
            return "2300";
        } else if (getTime2 <= 510) {
            return "0200";
        } else if (getTime2 <= 810) {
            return "0500";
        } else if (getTime2 <= 1110) {
            return "0800";
        } else if (getTime2 <= 1410) {
            return "1100";
        } else if (getTime2 <= 1710) {
            return "1400";
        } else if (getTime2 <= 2010) {
            return "1700";
        } else {
            return "2000";
        }
    }
}
