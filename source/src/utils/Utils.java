package utils;

import java.time.LocalTime;
import java.util.logging.Logger;

public class Utils {
	public static Logger getLogger(String className) {
		return Logger.getLogger(className);
	}
	public static LocalTime plusTime(LocalTime time1,LocalTime time2) {
		int hours=(time1.getHour()+time2.getHour())>=60?(time1.getHour()+time2.getHour()-60):(time1.getHour()+time2.getHour());
		int minutes=(time1.getMinute()+time2.getMinute())>=60?(time1.getMinute()+time2.getMinute()-60):(time1.getMinute()+time2.getMinute());
		int seconds=(time1.getSecond()+time2.getSecond())>=60?(time1.getSecond()+time2.getSecond()-60):(time1.getSecond()+time2.getSecond());
		return LocalTime.of(hours, minutes,seconds);
    }
}
