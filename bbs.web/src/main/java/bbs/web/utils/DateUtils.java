package bbs.web.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateUtils {

	public String getShortTime(Date pubTime) {
		Date now = new Date();
		long nowMs = now.getTime();
		long pubMs = pubTime.getTime();
		
		long delTime = (nowMs - pubMs)/1000;
		
		String shortTime = null;
		
		if (delTime > 365 * 24 * 60 * 60) {
			shortTime = (delTime / (365 * 24 * 60 * 60)) + "年前";
		}
		else if (delTime > 24 * 60 * 60) {
			shortTime = (delTime/(24 * 60 * 60)) + "天前";
		}
		else if (delTime > 60 * 60) {
			shortTime = (delTime/(60 * 60)) + "小时前";
		}
		else if (delTime > 60) {
			shortTime = (delTime/60) + "分钟前";
		}
		else {
			shortTime = "1秒前";
		}
		
		return shortTime;
	}
	
	public String getShortTime(String pubTimeString) throws ParseException {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		
		Date pubTime = format.parse(pubTimeString);
		return this.getShortTime(pubTime);
	}
}
