package jkt.hms.util;

import java.io.Serializable;
import java.util.Comparator;
import java.util.TreeSet;

import jkt.hrms.masters.business.HrMasEmployeeEducation;

public class EmployeeEducationComparator implements Serializable , Comparator<HrMasEmployeeEducation>{
	public int compare(HrMasEmployeeEducation e1, HrMasEmployeeEducation e2) {
		Integer int1 = Integer.valueOf(e1.getEducationTypeCode());
		Integer int2 = Integer.valueOf(e2.getEducationTypeCode());
		return int1.compareTo(int2);
	}
	public static TreeSet<HrMasEmployeeEducation> getEmployeeEducationTreeSet(){
		return new TreeSet<HrMasEmployeeEducation> (new EmployeeEducationComparator());
	}
	
}