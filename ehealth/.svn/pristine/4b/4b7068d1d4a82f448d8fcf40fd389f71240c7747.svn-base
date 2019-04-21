package jkt.hms.enquiry.dataservice;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientAddress;
import jkt.hms.masters.business.PatientEpisode;
import jkt.hms.util.Box;

public interface EnquiryDataService {

	List<MasDepartment> getWardList();

	Map<String, Object> getDoctorList(Map<String, Object> enquiryMap);

	Map<String, Object> getDetailsForEnquiry();

	Map<String, Object> getPatientDetailsForEnquiry(Map<String, Object> enquiryMap);

	Map<String, Object> getInPatientDetailsForEnquiry(Map<String, Object> enquiryMap);

	Map<String, Object> getDetailsForSearch();

	Map<String, Object> getInPatientDetailsForEnquiry2(Map<String, Object> mapForDs);

	Map<String, Object> showPatientDetails(Map<String, Object> dataMap);

	Map<String, Object> getAdVisitDetails(Map<String, Object> dataMap);

	Map<String, Object> getAllEnquiry(Map<String, Object> dataMap);

	Map<String, Object> getItemsForPrescription(Box box);

	Map<String, Object> getPatientDetailsForFinalBill(int patientHinId,String patientIpd);

	Map<String, Object> showPatientEpfJsp();

	Map<String, Object> getConnectionForReport();
	
	Map<String, Object> showWardWiseDetails(Map<String, Object> detailMap);
	
	Map<String, Object> investigationResult(Box box);
	
	Map<String, Object> showPaitentDetail(Box box);

	Map<String, Object> saveClinicalObservation(Box box);

	List<Patient> getPatientList(String hinNo);
	
}
