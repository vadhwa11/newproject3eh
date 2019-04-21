package jkt.hms.util;


import java.io.Serializable;
import java.util.Comparator;
import java.util.TreeSet;

import jkt.hms.masters.business.MasApplication;
import jkt.hms.masters.business.MasEmployee;
import jkt.hrms.masters.business.MstrDeptTaskMap;
import jkt.hrms.masters.business.MstrTask;
import jkt.hrms.masters.business.MstrRoleTaskMap;



public class TaskComparator implements Serializable , Comparator<MstrDeptTaskMap>{

	public int compare(MstrDeptTaskMap m1, MstrDeptTaskMap m2) {
		String int1 = m1.getTask().getTaskName();
		String int2 = m2.getTask().getTaskName();
		return int1.compareTo(int2);
	}
	
	public static TreeSet<MasEmployee> getEmployeeTreeSet(){
		return new TreeSet<MasEmployee> (new EmployeeComparator());
	}
}