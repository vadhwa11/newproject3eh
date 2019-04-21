package jkt.hms.util;

import java.io.Serializable;
import java.util.Comparator;
import java.util.TreeSet;

import jkt.hms.masters.business.DgResultEntryDetail;

public class DgResultEntryComparatorByOrderNo implements Serializable,
		Comparator<DgResultEntryDetail> {

	public int compare(DgResultEntryDetail m1, DgResultEntryDetail m2) {
		
		Integer int1 = m1.getSubInvestigation().getOrderNo();
		Integer int2 = m2.getSubInvestigation().getOrderNo();
		 if(int1==int2)
		       return 0;
		   else if(int1>int2)
		       return 1;
		   else
		       return -1;
	}

	public static TreeSet<DgResultEntryDetail> getApplicationTreeSet() {
		return new TreeSet<DgResultEntryDetail>(
				new DgResultEntryComparatorByOrderNo());
	}
}