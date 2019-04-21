package jkt.hrms.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import jkt.hrms.recruitment.masters.business.Resumeremarks;

public class RecruitmentUtil {
	public static void sortById(List requestListForSorting) {
		class MyComparator implements Comparator {
			public int compare(Object object1, Object object2) {
				Resumeremarks resumeRemarks1 = (Resumeremarks) object1;
				int requestId1 = resumeRemarks1.getId();
				Resumeremarks resumeRemarks2 = (Resumeremarks) object2;
				int requestId2 = resumeRemarks2.getId();
				int cc = ((Integer) requestId1).compareTo(requestId2);
				return (cc < 0 ? 1 : cc > 0 ? -1 : 0);
			}
		}
		;
		Collections.sort(requestListForSorting, new MyComparator());
	}

}
