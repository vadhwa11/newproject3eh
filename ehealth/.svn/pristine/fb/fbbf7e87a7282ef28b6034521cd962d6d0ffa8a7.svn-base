package jkt.hms.util;

import java.util.Comparator;

import jkt.hms.masters.business.Visit;

public class QueueManagComparator implements Comparator<Visit>{

	@Override
	public int compare(Visit v1, Visit v2) {
		if (v1.getPriorityNumber() <v2.getPriorityNumber())
        {
            return -1;
        }
        if (v1.getPriorityNumber() > v2.getPriorityNumber())
        {
            return 1;
        }
        return 0;
	}

	 /*PriorityQueue<Patient> patientQueue = new PriorityQueue<Patient>(10, new Comparator<Patient>() {
	        public int compare(Patient patient1, Patient patient2) {
	            return (patient1.isEmergencyCase() == patient2.isEmergencyCase()) ? (Integer.valueOf(patient1.getId()).compareTo(patient2.getId()))
	                                                                              : (patient1.isEmergencyCase() ? -1 : 1);
	        }
	    });*/
}
