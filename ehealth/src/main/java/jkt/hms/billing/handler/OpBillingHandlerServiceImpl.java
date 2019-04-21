package jkt.hms.billing.handler;

import java.math.BigDecimal;
import java.util.Map;

import jkt.hms.billing.dataservice.OpBillingDataService;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;

public class OpBillingHandlerServiceImpl implements OpBillingHandlerService {

	OpBillingDataService opBillingDataService = null;
	Map<String, Object> showBillServicingJsp;
	
/*	public Map<String, Object> showBillServicingJsp(
			Map<String, Object>map) {
		return opBillingDataService.showBillServicingJsp(map);
	}*/
	
/*	public Map<String, Object> showOPBillServecing(
			Map<String, Object>map) {
		return opBillingDataService.showBillServicingJsp(map);
	}*/
	@Override
	public Map<String, Object> getReferedPatient(Box box) {
		return opBillingDataService.getReferedPatient(box);
	}

	public Map<String, Object> searchOPBillServicing(Box box) {
		return opBillingDataService.searchOPBillServicing(box);
	}
	public OpBillingDataService getOpBillingDataService() {
		return opBillingDataService;
	}
	
	public void setOpBillingDataService(
			OpBillingDataService opBillingDataService) {
		this.opBillingDataService = opBillingDataService;
	}

	public Map<String, Object> getPatientDetailsForOpBilling(Map<String, Object> parameterMap) {
		return opBillingDataService.getPatientDetailsForOpBilling(parameterMap);
	}

	public Map<String, Object> getChargeCodeForAutoComplete(
			Map<String, Object> parameterMap) {
		return opBillingDataService.getChargeCodeForAutoComplete(parameterMap);
	}

	public Map<String, Object> getChargeCodeDetails(String chargeCode, int hinId,int schemeId,int hospitalId) {
		return opBillingDataService.getChargeCodeDetails(chargeCode, hinId,schemeId,hospitalId);
	}

	public Map<String, Object> submitBillServicingDetails(
			Map<String, Object> dataMap) {
		return opBillingDataService.submitBillServicingDetails(dataMap);
	}

	public Map<String, Object> getOrderNoTempBillNoForBilling(String hin) {
		return opBillingDataService.getOrderNoTempBillNoForBilling(hin);
	}

	public String generateReceiptNo(String flag,int hospitalId) {
		return opBillingDataService.generateReceiptNo(flag,hospitalId);
	}

	public Map<String, Object> getPrescriptionAndTempBillNo(String hin) {
		return opBillingDataService.getPrescriptionAndTempBillNo(hin);
	}

	public Map<String, Object> getPatientDetailsForBillDispensing(Box box) {
		return opBillingDataService.getPatientDetailsForBillDispensing(box);
	}

	public String generateBillNo(String billType, String flag,int hospitalId) {
		return opBillingDataService.generateBillNo(billType, flag, hospitalId);
	}

	public Map<String, Object> getChargeAmountAfterDiscount(Map<String, Object> map) {
		return opBillingDataService.getChargeAmountAfterDiscount(map);
	}

	public Map<String, Object> getItemCodeForAutoComplete(Box box) {
		return opBillingDataService.getItemCodeForAutoComplete(box);
	}

	public Map<String, Object> getItemBatchNo(Box box) {
		return opBillingDataService.getItemBatchNo(box);
	}

	public Map<String, Object> getDetailsForBillDispensing() {
		return opBillingDataService.getDetailsForBillDispensing();
	}

	public Map<String, Object> submitBillDispensingDetails(Box box,
			Map<String, Object> detailsMap) {
		return opBillingDataService
				.submitBillDispensingDetails(box, detailsMap);
	}

	public Map<String, Object> getBillNoForPaymentAdvice(Box box) {
		return opBillingDataService.getBillNoForPaymentAdvice(box);
	}

	public Map<String, Object> getPatientDetailsForPaymentAdviceServicing(
			Box box) {
		return opBillingDataService
				.getPatientDetailsForPaymentAdviceServicing(box);
	}

	public Map<String, Object> submitPaymentAdviceServicingDetails(
			Map<String, Object> dataMap) {
		return opBillingDataService
				.submitPaymentAdviceServicingDetails(dataMap);
	}

	public String generatePaymentAdviceNo(String flag,int hospitalId) {
		return opBillingDataService.generatePaymentAdviceNo(flag,hospitalId);
	}

	public Map<String, Object> getPatientDetailsForPaymentAdviceDispensing(
			Box box) {
		return opBillingDataService
				.getPatientDetailsForPaymentAdviceDispensing(box);
	}

	public Map<String, Object> submitPaymentAdviceDispensingDetails(
			Map<String, Object> dataMap) {
		return opBillingDataService
				.submitPaymentAdviceDispensingDetails(dataMap);
	}

	public Map<String, Object> getPaymentAdviceNoForCashRefund(
			Map<String, Object> parameterMap) {
		return opBillingDataService
				.getPaymentAdviceNoForCashRefund(parameterMap);
	}

	public Map<String, Object> getConnectionForReport() {
		return opBillingDataService.getConnectionForReport();
	}

	public Map<String, Object> getDetailsForCashRefund(Box box) {
		return opBillingDataService.getDetailsForCashRefund(box);
	}

	public boolean submitCashRefundDetails(Box box) {
		return opBillingDataService.submitCashRefundDetails(box);
	}

	public Map<String, Object> getBillNoForRefund(Box box) {
		return opBillingDataService.getBillNoForRefund(box);
	}

	public Map<String, Object> getVisitNo(Box box) {
		return opBillingDataService.getVisitNo(box);
	}

	public Map<String, Object> getDetailsForCashStatisticsReport() {
		return opBillingDataService.getDetailsForCashStatisticsReport();
	}

	public Map<String, Object> checkBatchNoForIssue(Box box) {
		return opBillingDataService.checkBatchNoForIssue(box);
	}

	public Map<String, Object> issueItemBatchFromPharmacy(Box box) {
		return opBillingDataService.issueItemBatchFromPharmacy(box);
	}

	public Map<String, Object> submitTemporaryBillServicingDetails(Box box) {
		return opBillingDataService.submitTemporaryBillServicingDetails(box);
	}

	public Map<String, Object> submitTemporaryBillDispensingDetails(Box box) {
		return opBillingDataService.submitTemporaryBillDispensingDetails(box);
	}

	public Map<String, Object> getItemDiscount(Box box) {
		return opBillingDataService.getItemDiscount(box);
	}

	public Map<String, Object> getCompanyPatientListForSettlement(Box box) {
		return opBillingDataService.getCompanyPatientListForSettlement(box);
	}

	public Map<String, Object> submitCompanySettlementDetails(Box box) {
		return opBillingDataService.submitCompanySettlementDetails(box);
	}

	public Map<String, Object> getPaymentAdviceNoForAdviceRep(
			Map<String, Object> parameterMap) {

		return opBillingDataService.getPaymentAdviceNoForAdviceRep(parameterMap);
	}

	public Map<String, Object> getTemplateDetailsForBilling(Box box) {
		return opBillingDataService.getTemplateDetailsForBilling(box);
	}

	public Map<String, Object> scheduledDailyChargeEntry(Map<String, Object> dataMap) {
		return opBillingDataService.scheduledDailyChargeEntry(dataMap);
	}

	public Map<String, Object> showDailyChargeProcessJsp() {
		return opBillingDataService.showDailyChargeProcessJsp();
	}
	
	public Map<String, Object> searchPatientForBillDispensing(Box box) {
		return opBillingDataService.searchPatientForBillDispensing(box);
	}
	
	@Override
	public Map<String, Object> getHospitalParameterForDispensing() 
	{
		return opBillingDataService.getHospitalParameterForDispensing();
	}

	@Override
	public Map<String, Object> scheduledBillDetail() {
		return opBillingDataService.scheduledBillDetail();
	}
	
	public Map<String, Object> getChargeCodeDetailsForOTPostAnethisia(String chargeCode, int hinId)
	{
		return opBillingDataService.getChargeCodeDetailsForOTPostAnethisia(chargeCode,hinId);
	}

	@Override
	public int getTokenNoForDepartment(int departmentId) {
		return opBillingDataService.getTokenNoForDepartment(departmentId);
	}

	@Override
	public int getVisitNo(String hinNo) {
		return opBillingDataService.getVisitNo(hinNo);
	}

	@Override
	public String getage(String hinNo) {
		return opBillingDataService.getage(hinNo);
	}

	@Override
	public Map<String, Object> submitvisit(Visit v) {
		return opBillingDataService.submitvisit(v);
	}

	@Override
	public Map<String, Object> getBillNosByUhid(Box box) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> searchAdviceSerciving(Box box) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> searchAdviceDispensing(Box box) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Map<String, Object> showBillDispensingJsp(Box box) {
		return opBillingDataService.showBillDispensingJsp(box);
	}
	
	@Override
	public Map<String, Object> getInpatientBilDispensingDetail(Box box) {
		return opBillingDataService.getInpatientBilDispensingDetail(box);
	}
	@Override
	public Map<String, Object> searchPatientForAdvanceTransfer(Box box) { 
		 return opBillingDataService.searchPatientForAdvanceTransfer(box);
	}

	@Override
	public Map<String, Object> searchPatientForAdvance(Box box) {
		
		return opBillingDataService.searchPatientForAdvance(box);
	}

	@Override
	public Map<String, Object> getPatientDetailsForPatientAdvance(Box box) {
	
		return opBillingDataService.getPatientDetailsForPatientAdvance(box);
	}

	@Override
	public Map<String, Object> getMemberDetailsForPatientAdvance(Box box) {
	
		return opBillingDataService.getMemberDetailsForPatientAdvance(box);
	}
	public boolean submitPatientAdvanceFamilyNCahrity(Box box) {
		
		return opBillingDataService.submitPatientAdvanceFamilyNCahrity(box);
	}

	@Override
	public Map<String, Object> getSchemeWiseStatisticsJsp() {
		return opBillingDataService.getSchemeWiseStatisticsJsp();
	}

	@Override
	public int gewtHinId(String hinNo) {
		return opBillingDataService.gewtHinId(hinNo);
	}

	@Override
	public String generateReceiptNo(String flag) {
		return opBillingDataService.generateReceiptNo(flag);
	}

	@Override
	public Map<String, Object> displayOrderNoWithOutResultEntry(Box box) {
		
		return opBillingDataService.displayOrderNoWithOutResultEntry(box);
	}
	
	@Override
	public Map<String, Object> getPatientName(Box box) {
		
		return opBillingDataService.getPatientName(box);
	}
	
}
