package jkt.hms.adt.dataservice;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.SilDilStatus;

public interface CommandentDataService {

	/**
	 * ---------------------------------- Today Admission and SIL/DIL
	 * ------------------------------------- made by Mansi Gagrani
	 * 
	 * @param generalMap
	 * @return
	 */
	List<Inpatient> showTodayAdmission(Map<String, Object> map);

	List<SilDilStatus> showTodaySILDILJsp(Map<String, Object> map);

	/**
	 * ---------------------------------- ADT BED STATUS
	 * ------------------------------------- made by Priyanka Garg
	 * 
	 * @param generalMap
	 * @return
	 */
	Map<String, Object> showBedStateJsp(Map<String, Object> generalMap);
}
