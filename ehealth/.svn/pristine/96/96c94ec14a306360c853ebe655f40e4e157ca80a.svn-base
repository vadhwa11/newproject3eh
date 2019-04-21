package jkt.hms.billing.handler;

import java.math.BigDecimal;
import java.util.Map;

import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;

public interface OpBillingHandlerService {

	Map<String, Object> getPatientDetailsForOpBilling(Map<String, Object> parameterMap);

	Map<String, Object> getChargeCodeForAutoComplete(
			Map<String, Object> parameterMap);

	Map<String, Object> getChargeCodeDetails(String chargeCode, int hinId,int schemeId,int hospitalId);

	Map<String, Object> submitBillServicingDetails(Map<String, Object> dataMap);
	
/*	Map<String, Object> showBillServicingJsp(Map<String, Object> map);*/
	
	Map<String, Object> searchOPBillServicing(Box box);
	
/*	Map<String, Object> showOPBillServecing(Map<String, Object> map);*/
	
	Map<String, Object> getOrderNoTempBillNoForBilling(String hin);

	String generateReceiptNo(String flag,int hospitalId);

	String generateBillNo(String billType, String flag,int hospitalId);

	Map<String, Object> getPrescriptionAndTempBillNo(String hin);

	Map<String, Object> getPatientDetailsForBillDispensing(Box box);

	Map<String, Object> getChargeAmountAfterDiscount(Map<String, Object> map);

	Map<String, Object> getItemCodeForAutoComplete(Box box);

	Map<String, Object> getItemBatchNo(Box box);

	Map<String, Object> submitBillDispensingDetails(Box box,
			Map<String, Object> detailsMap);

	Map<String, Object> getBillNoForPaymentAdvice(Box box);

	Map<String, Object> getPatientDetailsForPaymentAdviceServicing(Box box);

	Map<String, Object> submitPaymentAdviceServicingDetails(
			Map<String, Object> dataMap);

	String generatePaymentAdviceNo(String string,int hospitalId);

	Map<String, Object> getPatientDetailsForPaymentAdviceDispensing(Box box);

	Map<String, Object> submitPaymentAdviceDispensingDetails(
			Map<String, Object> dataMap);

	Map<String, Object> getPaymentAdviceNoForCashRefund(
			Map<String, Object> parameterMap);

	Map<String, Object> getPaymentAdviceNoForAdviceRep(
			Map<String, Object> parameterMap);

	Map<String, Object> getConnectionForReport();

	Map<String, Object> getDetailsForCashRefund(Box box);

	boolean submitCashRefundDetails(Box box);

	Map<String, Object> getBillNoForRefund(Box box);

	Map<String, Object> getVisitNo(Box box);

	Map<String, Object> getDetailsForCashStatisticsReport();

	Map<String, Object> checkBatchNoForIssue(Box box);

	Map<String, Object> issueItemBatchFromPharmacy(Box box);

	Map<String, Object> submitTemporaryBillServicingDetails(Box box);

	Map<String, Object> submitTemporaryBillDispensingDetails(Box box);

	Map<String, Object> getItemDiscount(Box box);

	Map<String, Object> getCompanyPatientListForSettlement(Box box);

	Map<String, Object> submitCompanySettlementDetails(Box box);

	Map<String, Object> getTemplateDetailsForBilling(Box box);

	Map<String, Object> scheduledDailyChargeEntry(Map<String, Object> dataMap);

	Map<String, Object> showDailyChargeProcessJsp();

	Map<String, Object> getHospitalParameterForDispensing();

	Map<String, Object> scheduledBillDetail();
	Map<String, Object> getChargeCodeDetailsForOTPostAnethisia(String chargeCode, int hinId);

	int getTokenNoForDepartment(int departmentId);

	int getVisitNo(String hinNo);

	String getage(String hinNo);

	Map<String, Object> submitvisit(Visit v);
	
	Map<String, Object> getDetailsForBillDispensing();
	
	Map<String, Object> searchPatientForBillDispensing(Box box);

	Map<String, Object> getBillNosByUhid(Box box);

	Map<String, Object> searchAdviceSerciving(Box box);

	Map<String, Object> searchAdviceDispensing(Box box);
	
	Map<String, Object> searchPatientForAdvanceTransfer(Box box); 
	
	boolean submitPatientAdvanceFamilyNCahrity(Box box); 
	
	Map<String, Object> showBillDispensingJsp(Box box);

	Map<String, Object> getReferedPatient(Box box);

	public Map<String, Object> getInpatientBilDispensingDetail(Box box) ;

	Map<String, Object> searchPatientForAdvance(Box box);

	Map<String, Object> getPatientDetailsForPatientAdvance(Box box);

	Map<String, Object> getMemberDetailsForPatientAdvance(Box box);

	Map<String, Object> getSchemeWiseStatisticsJsp();

	int gewtHinId(String hinNo);

	String generateReceiptNo(String flag);

	Map<String, Object> displayOrderNoWithOutResultEntry(Box box);
	
	Map<String, Object> getPatientName(Box box);

}
