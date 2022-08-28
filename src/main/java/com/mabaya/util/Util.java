package com.mabaya.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public static String dateToString(LocalDateTime date) {
		return date.format(formatter);
	}
	
	public static LocalDateTime stringToDate(String dtStr) {
		return LocalDateTime.parse(dtStr,formatter);
	}

}

