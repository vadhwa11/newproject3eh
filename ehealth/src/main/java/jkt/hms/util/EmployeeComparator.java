package jkt.hms.util;

import java.io.Serializable;
import java.util.Comparator;
import java.util.TreeSet;

import jkt.hms.masters.business.MasEmployee;

public class EmployeeComparator implements Serializable,
		Comparator<MasEmployee> {

	public int compare(MasEmployee m1, MasEmployee m2) {
		String int1 = m1.getFirstName();
		String int2 = m2.getFirstName();
		return int1.compareTo(int2);
	}

	public static TreeSet<MasEmployee> getEmployeeTreeSet() {
		return new TreeSet<MasEmployee>(new EmployeeComparator());
	}
}