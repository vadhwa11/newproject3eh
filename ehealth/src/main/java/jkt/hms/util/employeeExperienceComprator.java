package jkt.hms.util;
	import java.io.Serializable;
	import java.util.Comparator;
	import java.util.TreeSet;

	import jkt.hrms.masters.business.HrEmployeeExperience;

	public class employeeExperienceComprator implements Serializable , Comparator<HrEmployeeExperience>{
		public int compare(HrEmployeeExperience e1, HrEmployeeExperience e2) {
			Integer int1 = Integer.valueOf(e1.getExperienceTypeCode());
			Integer int2 = Integer.valueOf(e2.getExperienceTypeCode());
			return int1.compareTo(int2);
			
		}
		public static TreeSet<HrEmployeeExperience> getEmployeeExperienceTreeSet(){
			return new TreeSet<HrEmployeeExperience> (new employeeExperienceComprator());
		}
	}
	

