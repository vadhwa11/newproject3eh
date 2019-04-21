package jkt.hms.billing.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.billing.dataservice.BillingDataService;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasScheme;
import jkt.hms.masters.business.PrinterCofiguration;
import jkt.hms.util.Box;

public class BillingHandlerServiceImpl implements BillingHandlerService {

	BillingDataService billingDataService = null;

	/**
	 * Getter And Setter of BillingDataService
	 */
	public BillingDataService getBillingDataService() {
		return billingDataService;
	}

	public void setBillingDataService(BillingDataService billingDataService) {
		this.billingDataService = billingDataService;
	}

	// -----------------------------------------------------------------------

	public Map<String, Object> getPatientDetails(Box box) {
		return billingDataService.getPatientDetails(box);
	}

	public Map<String, Object> getChargeCode(Map<String, Object> parameterMap) {
		return billingDataService.getChargeCode(parameterMap);
	}

	public Map<String, Object> getMainAndSubCharge() {
		return billingDataService.getMainAndSubCharge();
	}

	public Map<String, Object> fillItemsForChargeCode(
			Map<String, Object> dataMap) {
		return billingDataService.fillItemsForChargeCode(dataMap);
	}

	public boolean submitChargeSlipDetails(Box box) {
		return billingDataService.submitChargeSlipDetails(box);
	}

	public Map<String, Object> getPatientDetailsForAdvance(
			Map<String, Object> mapForDs) {
		return billingDataService.getPatientDetailsForAdvance(mapForDs);
	}

	public int getChargeSlipNo(String flag,int hospitalId) {
		return billingDataService.getChargeSlipNo(flag,hospitalId);
	}

	public Map<String, Object> submitDepositDetails(
			Map<String, Object> parameterMap) {
		return billingDataService.submitDepositDetails(parameterMap);
	}

	public Map<String, Object> submitBillingFinalSettlementDetails(Box box) {
		return billingDataService.submitBillingFinalSettlementDetails(box);
	}

	public Map<String, Object> getConnectionForReport() {
		return billingDataService.getConnectionForReport();
	}

	public List<Inpatient> getAdNo(String hin, int hospitalId) {
		return billingDataService.getAdNo(hin,hospitalId);
	}

	@Override
	public Map<String, Object> getPatientDetailsForFinalBill(String adNo,String hin, Integer hin_id, Integer hospitalId) {
		return billingDataService.getPatientDetailsForFinalBill(adNo,hin,hin_id,hospitalId);
	}

	public Map<String, Object> getChargeCodeForMainCharge(int mainChargeId,
			int inpatientId) {
		return billingDataService.getChargeCodeForMainCharge(mainChargeId,
				inpatientId);
	}

	public Map<String, Object> submitFinalBillDetails(Box box) {
		return billingDataService.submitFinalBillDetails(box);
	}

	public Map<String, Object> getFinalBillNo(String adNo) {
		return billingDataService.getFinalBillNo(adNo);
	}

	public Map<String, Object> getBillingDetailsForSettlement(
			String finalBillno, String adNo) {
		return billingDataService.getBillingDetailsForSettlement(finalBillno,
				adNo);
	}

	public String generateRefundNo(String string,int hospitalId) {
		return billingDataService.generateRefundNo(string,hospitalId);
	}

	public Map<String, Object> getReceiptDetailsForPatient(int inpatientId) {
		return billingDataService.getReceiptDetailsForPatient(inpatientId);
	}

	public Map<String, Object> getPatientDetailsForBillDispensing(Box box) {
		return billingDataService.getPatientDetailsForBillDispensing(box);
	}

	public Map<String, Object> getDetailsForBillDispensing() {
		return billingDataService.getDetailsForBillDispensing();
	}

	public Map<String, Object> getOrderNoForChargeSlip(Box box) {
		return billingDataService.getOrderNoForChargeSlip(box);
	}

	public Map<String, Object> searchChargeSlipForCancellation(Box box) {
		return billingDataService.searchChargeSlipForCancellation(box);
	}

	public boolean cancelChargeSlip(Box box) {
		return billingDataService.cancelChargeSlip(box);
	}

	public Map<String, Object> searchChargeSlipNoForPymntAdv(Box box) {
		return billingDataService.searchChargeSlipNoForPymntAdv(box);
	}

	public Map<String, Object> getPatientDetailsForPaymentAdviceChargeSlip(
			Box box) {
		return billingDataService
				.getPatientDetailsForPaymentAdviceChargeSlip(box);
	}

	public Map<String, Object> searchBillForCancellation(Box box) {
		return billingDataService.searchBillForCancellation(box);
	}

	public boolean cancelBillDispensing(Box box) {
		return billingDataService.cancelBillDispensing(box);
	}

	public Map<String, Object> getPharmacySalesDetails(Box box) {
		return billingDataService.getPharmacySalesDetails(box);
	}

	public Map<String, Object> getItemWiseDetails(Box box) {
		return billingDataService.getItemWiseDetails(box);
	}

	public Map<String, Object> getItemBatchDetails(int itemId, int inpatientId) {
		return billingDataService.getItemBatchDetails(itemId, inpatientId);
	}

	public Map<String, Object> getEmployeeList() {
		return billingDataService.getEmployeeList();
	}

	public String getHospitalName(int hospitalId) {
		return billingDataService.getHospitalName(hospitalId);
	}

	public Map<String, Object> showAccountRegister() {
		return billingDataService.showAccountRegister();
	}

	public Map<String, Object> showDepartmentWiseCash() {
		return billingDataService.showDepartmentWiseCash();
	}

	public int getInpatientId(String adNo) {
		return billingDataService.getInpatientId(adNo);
	}

	public Map<String, Object> getCompanyList() {
		return billingDataService.getCompanyList();
	}

	public Map<String, Object> getAuthorizrList() {
		return billingDataService.getAuthorizrList();
	}

	public Map<String, Object> submitOrderBookingDetails(Box box) {
		return billingDataService.submitOrderBookingDetails(box);
	}

	public Map<String, Object> getPatientDetailsForOrderBooking(Box box) {
		return billingDataService.getPatientDetailsForOrderBooking(box);
	}

	public Map<String, Object> viewPrescriptionForOrderBooking(Box box) {
		return billingDataService.viewPrescriptionForOrderBooking(box);
	}

	public Map<String, Object> getPatientListForDrugIssue(Box box) {
		return billingDataService.getPatientListForDrugIssue(box);
	}

	public Map<String, Object> getPatientDrugIssueDetails(Box box) {
		return billingDataService.getPatientDrugIssueDetails(box);
	}

	public Map<String, Object> submitPatientDrugIssueAndBillingDetails(Box box) {
		return billingDataService.submitPatientDrugIssueAndBillingDetails(box);
	}

	public List<MasDepartment> getDepartmentDetails(int deptId) {
		return billingDataService.getDepartmentDetails(deptId);
	}

	public void executeProcedureForReport(Map<String, Object> parameters) {
		billingDataService.executeProcedureForReport(parameters);
	}

	public Map<String, Object> getSystemParamDetails() {
		return billingDataService.getSystemParamDetails();
	}

	public Map<String, Object> getOpBillNo(String HinNo) {
		return billingDataService.getOpBillNo(HinNo);
	}
	public Map<String, Object> getReceiptNo(String HinNo,String billType) {
		return billingDataService.getReceiptNo(HinNo,billType);
	}
	public Map<String, Object> getDisBillNo(String HinNo,String tablename,String type,String dateField) {
		return billingDataService.getDisBillNo(HinNo,tablename,type,dateField);
	}

	public Map<String, Object> showUserList() {
			return billingDataService.showUserList();
	}

	public List<Inpatient> getAdNoForReport(String hin) {
					 return billingDataService.getAdNoForReport(hin);
	}

	public List<PrinterCofiguration> getPrinterConfigurationList(Map<String, Object> generalmap) {
			return billingDataService.getPrinterConfigurationList(generalmap);
	}

	public void executeProcedureForDailyCashReport(Map<String, Object> parameters) {
			billingDataService.executeProcedureForDailyCashReport(parameters);
	}

	public void executeProcedureForRetrivePastDue(Map<String, Object> parameters) {
		billingDataService.executeProcedureForRetrivePastDue(parameters);
	}

	public Map<String, Object> getChargeSlipDetails(Box box) {
			return billingDataService.getChargeSlipDetails(box);
	}

	@Override
	public boolean updateFinalBill(Box box) {
		return billingDataService.updateFinalBill(box);
	}

	@Override
	public boolean updateBills(int inpatientId) {
		return billingDataService.updateBills(inpatientId);
	}

	@Override
	public boolean updateBillsForMLC(int inpatientId) {
		return billingDataService.updateBillsForMLC(inpatientId);
	}

	@Override
	public int getGenderId(Integer hinId) {
		return billingDataService.getGenderId(hinId);
	}

	@Override
	public int getPatientTypeId(Integer hinId) {
		return billingDataService.getPatientTypeId(hinId);
	}

	@Override
	public Date getAdmDate(int inpatientId) {
		return billingDataService.getAdmDate(inpatientId);
	}

	@Override
	public Map<String, Object> updateDates(int inpatientId,String nextToAdmDate) {
		return billingDataService.updateDates(inpatientId,nextToAdmDate);
	}

	@Override
	public boolean printCashCollectionReport(Map<String, Object> parameters) {
		return billingDataService.printCashCollectionReport(parameters);
	}

	@Override
	public Map<String, Object> getSubChargeCode(Box box) {
		return billingDataService.getSubChargeCode(box);
	}
	
	@Override
	public Map<String, Object> showDetailPendingDispensing(Map<String, Object> mapForDs) {
		return billingDataService.showDetailPendingDispensing(mapForDs);
	}
	
	@Override
	public Map<String, Object> showIPBillingSearchJsp(Box box) {
		return billingDataService.showIPBillingSearchJsp(box);
	}
	
	public Map<String, Object> showIPBillDispensingJsp(Box box) {
		return billingDataService.showIPBillDispensingJsp(box);
	}
	
	public Map<String, Object> waitingListBookingPaward(Box box) {
		return billingDataService.waitingListBookingPaward(box);
	}
	
	public Map<String, Object> bookingPayward(Box box) {
		return billingDataService.bookingPayward(box);
	}
	public Map<String, Object> waitingListAllotmentPayward(Box box) {
		return billingDataService.waitingListAllotmentPayward(box);
	}
	
	public Map<String, Object> allotmentPayward(Box box) {
		return billingDataService.allotmentPayward(box);
	}
	public Map<String, Object> billWaitingListRenewalSearch(Box box) {
		return billingDataService.billWaitingListRenewalSearch(box);
	}
	public Map<String, Object> renewalPayward(Box box) {
		return billingDataService.renewalPayward(box);
	}
	public Map<String, Object> submitPaywardDetails(
			Map<String, Object> parameterMap) {
		return billingDataService.submitPaywardDetails(parameterMap);
	}
	public Map<String, Object> submitAllotmentDetails(
			Map<String, Object> parameterMap) {
		return billingDataService.submitAllotmentDetails(parameterMap);
	}
	
	public Map<String, Object> submitRenewaltDetails(
			Map<String, Object> parameterMap) {
		return billingDataService.submitRenewaltDetails(parameterMap);
	}

	@Override
	public Map<String, Object> showPostPaidStatus(Box box,
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return billingDataService.showPostPaidStatus(box,dataMap);
	}
	
	public Map<String, Object> getFinalBillDetails(Map<String, Object> parameters){
		
		return billingDataService.getFinalBillDetails(parameters);
	}

	@Override
	public Map<String, Object> showConsolidateReportForWaiveOffPayLaterJsp(
			int hospitalId) {
		return billingDataService.showConsolidateReportForWaiveOffPayLaterJsp(hospitalId);
	}

	@Override
	public Map<String, Object> getItemBatchDetailsFinal(Map<String, Object> mapForDs, Box box) {
		return billingDataService.getItemBatchDetailsFinal(mapForDs,box);
	}

	@Override
	public String generateRefundNo(String string) {
		return billingDataService.generateRefundNo(string);
	}

	@Override
	public Map<String, Object> populateExpiryDateByBatchNo(
			Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		return billingDataService.populateExpiryDateByBatchNo(mapForDs);
	}

	@Override
	public List<MasScheme> getAllSchemeList() {
		// TODO Auto-generated method stub
		return billingDataService.getAllSchemeList();
	}

	@Override
	public Map<String, Object> getKmsclIntegrationXMLData(
			Map<String, Object> mapForDS) {
		return billingDataService.getKmsclIntegrationXMLData(mapForDS);
	}

	@Override
	public Map<String, Object> getHighLevelDrugsForIPBilling(Box box) {
		return billingDataService.getHighLevelDrugsForIPBilling(box);
	}
	
	@Override
	public Map<String, Object> getKmsclAddedXMLData(Map<String, Object> mapForDS) {
		return billingDataService.getKmsclAddedXMLData(mapForDS);
	}
}
