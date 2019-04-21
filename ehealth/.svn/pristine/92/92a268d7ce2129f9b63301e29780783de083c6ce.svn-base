package jkt.hms.budget.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.regexp.internal.recompile;

import jkt.hms.budget.dataservice.BudgetDataService;
import jkt.hms.masters.business.BudEstimateEntry;
import jkt.hms.masters.business.BudMajorHead;
import jkt.hms.masters.business.BudMinorHead;
import jkt.hms.masters.business.BudMinorSubHead;
import jkt.hms.masters.business.BudObjectHead;
import jkt.hms.masters.business.BudReAppropEntry;
import jkt.hms.masters.business.BudSubMajorHead;
import jkt.hms.masters.business.BudVoucherHeader;
import jkt.hms.masters.business.BudVoucherReceiptEntry;
import jkt.hms.util.Box;
import jkt.hrms.masters.business.HrMasFinancialYear;

public class BudgetHandlerServiceImpl implements BudgetHandlerService {

	BudgetDataService budgetDataService = null;

	public BudgetDataService getBudgetDataService() {
		return budgetDataService;
	}

	public void setBudgetDataService(BudgetDataService budgetDataService) {
		this.budgetDataService = budgetDataService;
	}




	public Map<String, Object> showFinancialyearMaster()
	{
	return budgetDataService.showFinancialyearMaster();
	}

	@Override
	public boolean addfinancialyear(HrMasFinancialYear masFinancialYear) {
		return budgetDataService.addfinancialyear(masFinancialYear);
	}

	@Override
	public boolean editfinancialyear(Map<String, Object> generalMap) {
		return budgetDataService.editfinancialyear(generalMap);
	}

	@Override
	public Map<String, Object> searchfinancialyear(String financialCode,
			String financialName) {
		return budgetDataService.searchfinancialyear(financialCode , financialName);
	}

	@Override
	public Map<String, Object> showBudgetMajorHead() {
		return budgetDataService.showBudgetMajorHead();
	}

	@Override
	public boolean deletefinancialyear(int financilId,
			Map<String, Object> generalMap) {
		return budgetDataService.deletefinancialyear(financilId,generalMap);
	}

	@Override
	public boolean deleteMajorHead(int majorheadId,
			Map<String, Object> generalMap) {
		return budgetDataService.deleteMajorHead(majorheadId,generalMap);	}

	@Override
	public boolean addMajorHead(BudMajorHead majorHead) {
		return budgetDataService.addMajorHead(majorHead);	}

		@Override
		public boolean editmajorhead(Map<String, Object> generalMap) {
			return budgetDataService.editmajorhead(generalMap);
		}

		@Override
		public Map<String, Object> searchmajorhead(String majorHeadCode,
				String majorHeadName) {

			return budgetDataService.searchmajorhead(majorHeadCode , majorHeadName);
		}
		public Map<String, Object> checkForExistingMasters(Map<String, Object> generalMap) {
			return budgetDataService.checkForExistingMasters(generalMap);
		}

		public Map<String, Object> showSubMajorHead() {
			return budgetDataService.showSubMajorHead();	}

		@Override
		public boolean addSubMajorHead(BudSubMajorHead subMajorHead) {
			return budgetDataService.addSubMajorHead(subMajorHead);
		}
		public boolean editSubMajorHead(Map<String, Object> generalMap) {

			return budgetDataService.editSubMajorHead(generalMap);
		}
		public boolean deleteSubMajorHead(int submajorheadId,
				Map<String, Object> generalMap) {

			return budgetDataService.deleteSubMajorHead(submajorheadId,generalMap);
		}
		public Map<String, Object> showMinorSubHead() {

			return budgetDataService.showMinorSubHead();
		}
		public boolean addMinorSubHead(BudMinorSubHead minorSubHead) {

			return budgetDataService.addMinorSubHead(minorSubHead);
		}

		public boolean deleteMinorSubHead(int minorsubheadId,Map<String, Object> generalMap) {

			return budgetDataService.deleteMinorSubHead(minorsubheadId,generalMap);
		}
		public boolean editMinorSubHead(Map<String, Object> generalMap) {
			return budgetDataService.editMinorSubHead(generalMap);
		}
		public Map<String, Object> searchMinorSubHead(String minorSubHeadCode,String minorSubHeadName) {
			return budgetDataService.searchMinorSubHead(minorSubHeadCode, minorSubHeadName);
		}

		public Map<String, Object> showObjectHead() {
			return budgetDataService.showObjectHead();
		}
		public boolean addObjectHead(BudObjectHead objecthead) {
			return budgetDataService.addObjectHead(objecthead);
		}
		public boolean editObjectHead(Map<String, Object> generalMap) {
			return budgetDataService.editObjectHead(generalMap);
		}
		public boolean deleteObjectHead(int objectheadId,
				Map<String, Object> generalMap) {
			return budgetDataService.deleteObjectHead(objectheadId, generalMap);
		}

		@Override
		public Map<String, Object> searchsubmajorHead(String submajorheadCode,
				String submajorheadName) {

			return budgetDataService.searchsubmajorHead(submajorheadCode, submajorheadName);
		}

		@Override
		public Map<String, Object> searchObjectHead(String objectheadCode,
				String objectheadName) {

			return budgetDataService.searchObjectHead(objectheadCode, objectheadName);

		}

		@Override
		public Map<String, Object> showBudgetEstimateEntry() {
			return budgetDataService.showBudgetEstimateEntry();
		}



		@Override
		public boolean submitBudget(BudEstimateEntry estimateentry) {
			return budgetDataService.submitBudget(estimateentry);
		}

		@Override
		public boolean addBudget(BudEstimateEntry estimate,Date encashDate,int objectheadId,String sectorType) 
		{
			return budgetDataService.addBudget(estimate,encashDate, objectheadId, sectorType);
		}

		@Override
		public Map<String, Object> showsearchBudgetEstimateEntry(String code) {
			return budgetDataService.showsearchBudgetEstimateEntry(code);
		}

		@Override
		public Map<String, Object> showVoucherContingentBill() {
			return budgetDataService.showVoucherContingentBill();
		}

		@Override
		public boolean addVoucher(BudVoucherHeader voucherHeader) {
			return budgetDataService.addVoucher(voucherHeader);
		}

		@Override
		public String generateBilltNo(String string) {
			return budgetDataService.generateBilltNo(string);
		}

		@Override
		public String generateOrderNumber() {
			return budgetDataService.generateOrderNumber();
		}

		@Override
		public boolean submitVoucher(Box box) {
			return budgetDataService.submitVoucher(box) ;
		}

		@Override
		public boolean addVoucher(Box box) {

		return budgetDataService.addVoucher(box); 
		}

		@Override
		public Map<String, Object> getConnectionForReport() {
			
			return budgetDataService.getConnectionForReport();
		}

		@Override
		public Map<String, Object> searchEstimation(int demandNo) {
				return budgetDataService.searchEstimation(demandNo);
		}

		@Override
		public Map<String, Object> showBudgetReappropEntry(int financialId) {
			return budgetDataService.showBudgetReappropEntry(financialId);
		}

		@Override
		public boolean addBudgetreapprop(BudReAppropEntry estimate,int budgetId) {
			return budgetDataService.addBudgetreapprop(estimate, budgetId);
		}

		@Override
		public Map<String, Object> getNameTitle(String demandNo) {
			return budgetDataService.getNameTitle(demandNo);
		}

		@Override
		public boolean updateEstimateEntry(Map<String, Object> generalMap) {
			return budgetDataService.updateEstimateEntry(generalMap);
		}

		@Override
		public Map<String, Object> searchBudgetEstimateEntry(int code1) {
			
			return budgetDataService.searchBudgetEstimateEntry(code1);
		}

		@Override
		public Map<String, Object> showResponse(int objectheadId,int financialId,String sectorType) {
			return budgetDataService.showResponse(objectheadId,financialId,sectorType);
			}

		@Override
		public Map<String, Object> searchBudgetReAppropEntry(int code1) {
			return budgetDataService.searchBudgetReAppropEntry(code1);
		}

		@Override
		public Map<String, Object> getMaxEquipmentDate(int financialId) {
			return budgetDataService.getMaxEquipmentDate(financialId);
		}

		@Override
		public Map<String, Object> showVoucherReceiptEntry() {
			return budgetDataService.showVoucherReceiptEntry();
		}

		/*@Override
		public Map<String, Object> showReceipt(int financialId,String sectorType,int objectheadId){
			return budgetDataService.showReceipt(financialId,sectorType,objectheadId);
		}*/

		@Override
		public boolean addReceiptVoucher(BudVoucherReceiptEntry estimate,String receiptDate) {
			return budgetDataService.addReceiptVoucher(estimate,receiptDate);
		}

		@Override
		public Map<String, Object> searchReceiptNo(int code1) {
			return budgetDataService.searchReceiptNo(code1);
		}

		@Override
		public boolean addMinorHead(BudMinorHead minorHead) {
			return budgetDataService.addMinorHead(minorHead);
		}

		@Override
		public Map<String, Object> showMinorHead() {
				return budgetDataService.showMinorHead();
		}

		@Override
		public boolean editMinorHead(Map<String, Object> generalMap) {
			return budgetDataService.editMinorHead(generalMap);
		}

		@Override
		public boolean deleteMinorHead(int minorsubheadId,
				Map<String, Object> generalMap) {
			return budgetDataService.deleteMinorHead(minorsubheadId,generalMap);
		}

		@Override
		public Map<String, Object> getHospitalName(Map<String, Object> mapForDs) {
			return budgetDataService.getHospitalName(mapForDs);
		}

		@Override
		public Map<String, Object> showObj(String sectorType) {
			return budgetDataService.showObj(sectorType);
		}

		@Override
		public boolean editBudget(Map<String, Object> generalMap) {
			return budgetDataService.editBudget(generalMap);
		}

		@Override
		public Map<String, Object> showReceipt(int objectheadId,String sectorType, int financialId) {
			return budgetDataService.showReceipt(objectheadId,sectorType,financialId);
		}

		@Override
		public Map<String, Object> showReceipts(String sectorType) {
			return budgetDataService.showReceipts(sectorType);
		}

		@Override
		public boolean editReceipt(Map<String, Object> generalMap) {
			return budgetDataService.editReceipt(generalMap);
		}

		@Override
		public boolean editReApprop(Map<String, Object> generalMap) {
			return budgetDataService.editReApprop(generalMap);
		}

		@Override
		public Map<String, Object> searchBillNo(int code1) {
			return budgetDataService.searchBillNo(code1);
		}

		@Override
		public Map<String, Object> showVoucherReportJsp() {
			return budgetDataService.showVoucherReportJsp();
		}
		public Map<String, Object> showAdviceJsp() {
			return budgetDataService.showAdviceJsp();
		}

		public Map<String, Object> showDetailMonthlyExpenditure() {
			return budgetDataService.showDetailMonthlyExpenditure();
		}
		
		public Map<String, Object> showApproprationRegister() {
			return budgetDataService.showApproprationRegister();
		}
		public Map<String, Object> showoMnthlyObjectWiseExpenditure() {
			return budgetDataService.showoMnthlyObjectWiseExpenditure();
		}
		public Map<String, Object> showoMnthlyMinorWiseExpenditure() {
			return budgetDataService.showoMnthlyMinorWiseExpenditure();
		}

		@Override
		public Map<String, Object> showoReceiptVoucher() {
			return budgetDataService.showoReceiptVoucher();
		}

		public Map<String, Object> printVoucherReceipt(	Map<String, Object> requestParameters) {
			return budgetDataService.printVoucherReceipt(requestParameters);
		}

		@Override
		public List<BudVoucherReceiptEntry> getReceiptNumberList() {
			return budgetDataService.getReceiptNumberList();
		}

		@Override
		public Map<String, Object> showPrintVoucherReport() {
			return budgetDataService.showPrintVoucherReport();
		}

}
