package jkt.hms.util;

import java.util.Comparator;

import jkt.hms.masters.business.CommonLabTestReport;

public class ComparatorForLabTestDate implements Comparator<CommonLabTestReport>{

	@Override
	public int compare(CommonLabTestReport o1, CommonLabTestReport o2) {
		
		String s1 = o1.getResultDate();
		String s2 = o2.getResultDate();

		return s1.compareTo(s2);
		
	}

}
