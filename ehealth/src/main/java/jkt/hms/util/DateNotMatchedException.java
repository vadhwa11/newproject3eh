package jkt.hms.util;

public class DateNotMatchedException extends Exception {

	public String getMessage() {
		return "File can't be uploaded.Date of upload doesn't match date of attendance.";
	}

}
