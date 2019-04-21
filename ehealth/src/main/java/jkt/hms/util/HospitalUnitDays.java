package jkt.hms.util;

public enum HospitalUnitDays {
MONDAY("Monday","monday"),
TUESDAY("Tuesday","tuesday"),
WEDNESDAY("Wednesday","wednesday"),
THURSDAY("Thursday","thursday"),
FRIDAY("Friday","friday"),
SATURDAY("Saturday","saturday"),
SUNDAY("Sunday","sunday");

//tuesday,wednesday,thursday,friday,saturday,sunday

private String labelName;
private String labelValue;
public String getLabelName() {
	return labelName;
}
public String getLabelValue() {
	return labelValue;
}

HospitalUnitDays(String labelName,String labelValue){
	this.labelName=labelName;
	this.labelValue=labelValue;
}

}
