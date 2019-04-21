package jkt.hrms.util;

import java.util.Comparator;

import jkt.hrms.recruitment.masters.business.HrRequisitionHistory;

public class RequisitionHistoryComparator implements Comparator {

	public int compare(Object obj1, Object obj2) {

		// parameter are of type Object, so we have to downcast it to
		// RequisitionHistory objects

		Integer id1 = ((HrRequisitionHistory) obj1).getId();

		Integer id2 = ((HrRequisitionHistory) obj2).getId();

		if (id1 > id2) {
			return 1;
		} else if (id1 < id2) {
			return -1;
		} else {
			return 0;
		}

	}

}
