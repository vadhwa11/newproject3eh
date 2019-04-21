package jkt.hms.billing.handler;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BlankRemover {

	/*public static void main(String arg[])
	{
	dateDifference();
	}

	public static void dateDifference()
	{
	Date currentdate = new Date();
	Calendar calUpdated = Calendar.getInstance();
	calUpdated.set(2010, 06, 07);
	long currentDateMilliSec = currentdate.getTime();
	long updateDateMilliSec = calUpdated.getTimeInMillis();
	long diffDays = (currentDateMilliSec - updateDateMilliSec) / (24 * 60 * 60 * 1000);
	String currentDate="";
	for(int i=1; i<=diffDays+1; i++){

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(calUpdated.getTime());
		int dateValue = calendar.get(Calendar.DATE);

		calendar.set(Calendar.DATE, dateValue + i);

		Date date = calendar.getTime();
		String finalIssuePeriod="";
		int x=1;
		//finalIssuePeriod=getIssuePeriod(convertDateToStringWithoutTime(date),x,"Weekly");
		x++;


		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(date);
		int dateValue1 = calendar1.get(Calendar.DATE);

		calendar1.set(Calendar.DATE, dateValue1 - 7);
		Date date1 = calendar1.getTime();
	}


	}*/
	public static void main(String arg[])
	{
	//dateDifference();
	//compaireDate();
	Date date=new Date(2010,3,10);
	dateFormatterDDMMYYYY(date);
	}
	public static void dateFormatterDDMMYYYY(Date date1)
	{
	try{
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
	String datetime = dateFormat.format(date);
	Date date2 = new Date();
	SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
	String datetime2 = dateFormat1.format(date1);
	date2=dateFormat1.parse(datetime2);
	if(date1.compareTo(date2)>0){
	}else{
	}

	}catch (Exception e) {
	// TODO: handle exception
	}

	}

}
