package jkt.hms.enquiry.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.enquiry.dataservice.EnquiryDataService;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientAddress;
import jkt.hms.masters.business.PatientEpisode;
import jkt.hms.util.Box;

public class EnquiryHandlerServiceImpl implements EnquiryHandlerService {

	EnquiryDataService enquiryDataService = null;

	public EnquiryDataService getEnquiryDataService() {
		return enquiryDataService;
	}

	public void setEnquiryDataService(EnquiryDataService enquiryDataService) {
		this.enquiryDataService = enquiryDataService;
	}

	// -----------------------------------------------------------------------------------------------
	public List<MasDepartment> getWardList() {
		return enquiryDataService.getWardList();
	}

	public Map<String, Object> getDoctorList(Map<String, Object> enquiryMap) {
		return enquiryDataService.getDoctorList(enquiryMap);
	}

	public Map<String, Object> getDetailsForEnquiry() {
		return enquiryDataService.getDetailsForEnquiry();
	}

	public Map<String, Object> getPatientDetailsForEnquiry(
			Map<String, Object> enquiryMap) {
		return enquiryDataService.getPatientDetailsForEnquiry(enquiryMap);
	}

	public Map<String, Object> getInPatientDetailsForEnquiry(
			Map<String, Object> enquiryMap) {
		return enquiryDataService.getInPatientDetailsForEnquiry(enquiryMap);
	}

	public Map<String, Object> getDetailsForSearch() {
		return enquiryDataService.getDetailsForSearch();
	}

	public Map<String, Object> getInPatientDetailsForEnquiry2(
			Map<String, Object> mapForDs) {
		return enquiryDataService.getInPatientDetailsForEnquiry2(mapForDs);
	}

	public Map<String, Object> showPatientDetails(Map<String, Object> dataMap) {
		return enquiryDataService.showPatientDetails(dataMap);
	}

	public Map<String, Object> getAdVisitDetails(Map<String, Object> dataMap) {
		return enquiryDataService.getAdVisitDetails(dataMap);
	}

	public Map<String, Object> getAllEnquiry(Map<String, Object> dataMap) {
		return enquiryDataService.getAllEnquiry(dataMap);
	}

	public Map<String, Object> getItemsForPrescription(Box box) {
		return enquiryDataService.getItemsForPrescription(box);
	}

	@Override
	public Map<String, Object> getPatientDetailsForFinalBill(int patientHinId,String patientIpd) {
		return enquiryDataService.getPatientDetailsForFinalBill(patientHinId,patientIpd);
	}
	public Map<String, Object> showPatientEpfJsp() {
		return enquiryDataService.showPatientEpfJsp();
	}

	@Override
	public Map<String, Object> getConnectionForReport() {
		return enquiryDataService.getConnectionForReport();
	}
	public Map<String, Object> showWardWiseDetails(Map<String, Object> detailMap) {
		return enquiryDataService.showWardWiseDetails(detailMap);
	}
	
	@Override
	public Map<String, Object> investigationResult(Box box) {
		return enquiryDataService.investigationResult(box);
	}

	@Override
	public Map<String, Object> showPaitentDetail(Box box) {
		// TODO Auto-generated method stub
		return enquiryDataService.showPaitentDetail(box);
	}

	@Override
	public Map<String, Object> saveClinicalObservation(Box box) {
		
		return enquiryDataService.saveClinicalObservation(box);
	}

	@Override
	public List<Patient> getPatientList(String hinNo) {
		return enquiryDataService.getPatientList(hinNo);
	}

	
}
