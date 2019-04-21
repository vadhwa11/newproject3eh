package jkt.hms.billing.dataservice;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasScheme;
import jkt.hms.masters.business.PrinterCofiguration;
import jkt.hms.util.Box;

public interface BillingDataService {

	Map<String, Object> getPatientDetails(Box box);

	Map<String, Object> getChargeCode(Map<String, Object> parameterMap);

	Map<String, Object> getMainAndSubCharge();

	Map<String, Object> fillItemsForChargeCode(Map<String, Object> dataMap);

	boolean submitChargeSlipDetails(Box box);

	Map<String, Object> getPatientDetailsForAdvance(Map<String, Object> mapForDs);

	int getChargeSlipNo(String flag,int hospitalId);

	Map<String, Object> submitDepositDetails(Map<String, Object> parameterMap);

	Map<String, Object> submitBillingFinalSettlementDetails(Box box);

	Map<String, Object> getConnectionForReport();

	List<Inpatient> getAdNo(String hin, int hospitalId);

	List<Inpatient> getAdNoForReport(String hin);

	Map<String, Object> getPatientDetailsForFinalBill(String adNo, String hin, Integer hin_id, Integer hospitalId);

	Map<String, Object> getChargeCodeForMainCharge(int mainChargeId,int inpatientId);

	Map<String, Object> submitFinalBillDetails(Box box);

	Map<String, Object> getFinalBillNo(String adNo);

	Map<String, Object> getOpBillNo(String HinNo);

	Map<String, Object> getReceiptNo(String HinNo,String billType);

	Map<String, Object> getDisBillNo(String HinNo,String tablename,String type, String dateField);

	Map<String, Object> getBillingDetailsForSettlement(String finalBillno,
			String adNo);

	String generateRefundNo(String string,int hospitalId);

	Map<String, Object> getReceiptDetailsForPatient(int inpatientId);

	Map<String, Object> getPatientDetailsForBillDispensing(Box box);

	Map<String, Object> getDetailsForBillDispensing();

	Map<String, Object> getOrderNoForChargeSlip(Box box);

	Map<String, Object> searchChargeSlipForCancellation(Box box);

	boolean cancelChargeSlip(Box box);

	Map<String, Object> searchChargeSlipNoForPymntAdv(Box box);

	Map<String, Object> getPatientDetailsForPaymentAdviceChargeSlip(Box box);

	Map<String, Object> searchBillForCancellation(Box box);

	boolean cancelBillDispensing(Box box);

	Map<String, Object> getPharmacySalesDetails(Box box);

	Map<String, Object> getItemWiseDetails(Box box);

	Map<String, Object> getItemBatchDetails(int itemId, int inpatientId);

	Map<String, Object> getEmployeeList();

	Map<String, Object> showUserList();

	String getHospitalName(int hospitalId);

	Map<String, Object> showAccountRegister();

	Map<String, Object> showDepartmentWiseCash();


	int getInpatientId(String adNo);

	Map<String, Object> getCompanyList();

	Map<String, Object> getAuthorizrList();

	Map<String, Object> submitOrderBookingDetails(Box box);

	Map<String, Object> getPatientDetailsForOrderBooking(Box box);

	Map<String, Object> viewPrescriptionForOrderBooking(Box box);

	Map<String, Object> getPatientListForDrugIssue(Box box);

	Map<String, Object> getPatientDrugIssueDetails(Box box);

	Map<String, Object> submitPatientDrugIssueAndBillingDetails(Box box);

	List<MasDepartment> getDepartmentDetails(int deptId);

	void executeProcedureForReport(Map<String, Object> parameters);

	void executeProcedureForDailyCashReport(Map<String, Object> parameters);

	void executeProcedureForRetrivePastDue(Map<String, Object> parameters);

	Map<String, Object> getSystemParamDetails();

	List<PrinterCofiguration> getPrinterConfigurationList(Map<String, Object> generalmap);

	Map<String, Object> getChargeSlipDetails(Box box);
	
	public Map<String, Object> singlePateintRoomRentCalculate(Map<String, Object> dataMap,Integer patientHinId);

	boolean updateFinalBill(Box box);

	boolean updateBills(int inpatientId);

	boolean updateBillsForMLC(int inpatientId);

	int getGenderId(Integer hinId);

	int getPatientTypeId(Integer hinId);

	Date getAdmDate(int inpatientId);

	Map<String, Object> updateDates(int inpatientId,String nextToAdmDate);

	boolean printCashCollectionReport(Map<String, Object> parameters);

	Map<String, Object> getSubChargeCode(Box box);
	
	Map<String, Object> showDetailPendingDispensing(Map<String, Object> mapForDs);

	Map<String, Object> showPaymentAdviceDispensingJsp(Box box);

	Map<String, Object> getBillNosByUhid(Box box);

	Map<String, Object> showIPBillingWaitingList(Box box);
	
	Map<String, Object> showIPBillingSearchJsp(Box box);

	Map<String, Object> showIPBillDispensingJsp(Box box);

	Map<String, Object> waitingListBookingPaward(Box box);

	Map<String, Object> bookingPayward(Box box);

	Map<String, Object> waitingListAllotmentPayward(Box box);

	Map<String, Object> allotmentPayward(Box box);

	Map<String, Object> billWaitingListRenewalSearch(Box box);

	Map<String, Object> renewalPayward(Box box);

/*	Map<String, Object> submitPaywardDetails(Box box);*/

	Map<String, Object> submitPaywardDetails(Map<String, Object> parameterMap);

	Map<String, Object> submitAllotmentDetails(Map<String, Object> parameterMap);

	Map<String, Object> submitRenewaltDetails(Map<String, Object> parameterMap);

	Map<String, Object> showPostPaidStatus(Box box, Map<String, Object> dataMap);
	
	Map<String, Object> getFinalBillDetails(Map<String, Object> parameters);

	Map<String, Object> showConsolidateReportForWaiveOffPayLaterJsp(
			int hospitalId);

	Map<String, Object> getItemBatchDetailsFinal(Map<String, Object> mapForDs,Box box);

	String generateRefundNo(String string);
	
	Map<String, Object> populateExpiryDateByBatchNo(Map<String, Object> mapForDs);
	
	/*Added By Srikanth*/
	List<MasScheme> getAllSchemeList();

	Map<String, Object> getKmsclIntegrationXMLData(Map<String, Object> mapForDS);

	Map<String, Object> addKmsclData(Map<String, Object> kmsclMap);

	Map<String, Object> getHighLevelDrugsForIPBilling(Box box);
	
	Map<String, Object> getKmsclAddedXMLData(Map<String, Object> mapForDS);
	
}
