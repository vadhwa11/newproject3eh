package jkt.hms.budget.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

public interface BudgetHandlerService {

	Map<String, Object> showFinancialyearMaster();

	Map<String, Object> checkForExistingMasters(Map<String, Object> generalMap);

	boolean addfinancialyear(HrMasFinancialYear masFinancialYear);

	boolean editfinancialyear(Map<String, Object> generalMap);

	Map<String, Object> searchfinancialyear(String financialCode,String financialName);

	boolean deletefinancialyear(int financilId, Map<String, Object> generalMap);

	Map<String, Object> showBudgetMajorHead();

	boolean deleteMajorHead(int majorheadId, Map<String, Object> generalMap);

	boolean editmajorhead(Map<String, Object> generalMap);

	Map<String, Object> searchmajorhead(String majorHeadCode,String majorHeadName);

	Map<String, Object> showSubMajorHead();

	Map<String, Object> showBudgetEstimateEntry();

	Map<String, Object> searchObjectHead(String objectheadCode,String objectheadName);

	Map<String, Object> searchsubmajorHead(String submajorheadCode,String submajorheadName);

	//Map<String, Object> showObjectHead();

	boolean deleteObjectHead(int objectheadId, Map<String, Object> generalMap);

	Map<String, Object> showMinorSubHead();

	boolean editMinorSubHead(Map<String, Object> generalMap);

	boolean deleteMinorSubHead(int minorsubheadId,Map<String, Object> generalMap);

	boolean deleteSubMajorHead(int submajorheadId,Map<String, Object> generalMap);

	boolean editSubMajorHead(Map<String, Object> generalMap);

	Map<String, Object> searchMinorSubHead(String minorSubHeadCode,String minorSubHeadName);

	Map<String, Object> showObjectHead();

	boolean addMajorHead(BudMajorHead majorHead);

	boolean addSubMajorHead(BudSubMajorHead subMajorHead);

	boolean addMinorSubHead(BudMinorSubHead minorSubHead);

	boolean addObjectHead(BudObjectHead objecthead);

	boolean addBudget(BudEstimateEntry estimate,Date encashDate,int objectheadId,String sectorType);

	boolean submitBudget(BudEstimateEntry estimateentry);

	Map<String, Object> showVoucherContingentBill();

	boolean addVoucher(BudVoucherHeader voucherHeader);

	Map<String, Object> showsearchBudgetEstimateEntry(String code);

	String generateBilltNo(String string);

	String generateOrderNumber();

	boolean submitVoucher(Box box);

	boolean addVoucher(Box box);

	Map<String, Object> getConnectionForReport();

	boolean editObjectHead(Map<String, Object> generalMap);

	Map<String, Object> searchEstimation(int demandNo);

	

	boolean addBudgetreapprop(BudReAppropEntry estimate,int budgetId);

	Map<String, Object> getNameTitle(String demandNo);

	boolean updateEstimateEntry(Map<String, Object> generalMap);

	Map<String, Object> searchBudgetEstimateEntry(int code1);

	Map<String, Object> showResponse(int objectheadId,int financialId,String sectorType);

	Map<String, Object> searchBudgetReAppropEntry(int code1);

	Map<String, Object> getMaxEquipmentDate(int financialId);

	Map<String, Object> showVoucherReceiptEntry();

//	Map<String, Object> showReceipt(int financialId,String sectorType,int objectheadId);


	boolean addReceiptVoucher(BudVoucherReceiptEntry estimate,String receiptDate);

	Map<String, Object> searchReceiptNo(int code1);

	Map<String, Object> showBudgetReappropEntry(int financialId);

	Map<String, Object> showMinorHead();

	boolean addMinorHead(BudMinorHead minorHead);

	boolean editMinorHead(Map<String, Object> generalMap);

	boolean deleteMinorHead(int minorsubheadId, Map<String, Object> generalMap);

	Map<String, Object> getHospitalName(Map<String, Object> mapForDs);

	Map<String, Object> showObj(String sectorType);

	boolean editBudget(Map<String, Object> generalMap);

	Map<String, Object> showReceipt(int objectheadId,String sectorType, int financialId	);

	Map<String, Object> showReceipts(String sectorType);

	boolean editReceipt(Map<String, Object> generalMap);

	boolean editReApprop(Map<String, Object> generalMap);

	Map<String, Object> searchBillNo(int code1);

	Map<String, Object> showVoucherReportJsp();

	Map<String, Object> showAdviceJsp();

	Map<String, Object> showDetailMonthlyExpenditure();

	Map<String, Object> showApproprationRegister();

	Map<String, Object> showoMnthlyObjectWiseExpenditure();

	Map<String, Object> showoMnthlyMinorWiseExpenditure();

	Map<String, Object> showoReceiptVoucher();

	Object printVoucherReceipt(Map<String, Object> requestParameters);

	List<BudVoucherReceiptEntry> getReceiptNumberList();

	//List<BudVoucherReceiptEntry> getBillNumberList();

	Map<String, Object> showPrintVoucherReport();

	
}
