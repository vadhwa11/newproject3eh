package jkt.hms.budget.dataservice;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.BudEstimateEntry;
import jkt.hms.masters.business.BudEstimateEntry;
import jkt.hms.masters.business.BudMajorHead;
import jkt.hms.masters.business.BudMinorHead;
import jkt.hms.masters.business.BudMinorSubHead;
import jkt.hms.masters.business.BudObjectHead;
import jkt.hms.masters.business.BudReAppropEntry;
import jkt.hms.masters.business.BudSubMajorHead;
import jkt.hms.masters.business.BudVoucherHeader;
import jkt.hms.masters.business.BudVoucherReceiptEntry;
import jkt.hms.masters.business.FaMasAccount;
//import jkt.hms.masters.business.FaMasNarration;
import jkt.hms.masters.business.FaMasSubLed;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.util.Box;
import jkt.hrms.masters.business.HrMasFinancialYear;


@SuppressWarnings("unused")
public interface BudgetDataService {

	Map<String, Object> showFinancialyearMaster();

	boolean addfinancialyear(HrMasFinancialYear masFinancialYear);

	boolean editfinancialyear(Map<String, Object> generalMap);

	Map<String, Object> searchfinancialyear(String financialCode,String financialName);

	Map<String, Object> showBudgetMajorHead();

	boolean deletefinancialyear(int financilId, Map<String, Object> generalMap);

	boolean deleteMajorHead(int majorheadId, Map<String, Object> generalMap);

	boolean addMajorHead(BudMajorHead majorHead);

	boolean editmajorhead(Map<String, Object> generalMap);

	Map<String, Object> searchmajorhead(String MajorHeadCode,String majorHeadName);

	Map<String, Object> checkForExistingMasters(Map<String, Object> generalMap);

	Map<String, Object> showSubMajorHead();

	boolean addSubMajorHead(BudSubMajorHead subMajorHead);

	boolean editSubMajorHead(Map<String, Object> generalMap);

	boolean deleteSubMajorHead(int submajorheadId, Map<String, Object> generalMap);

	Map<String, Object> showMinorSubHead();

	boolean addMinorSubHead(BudMinorSubHead minorSubHead);

	boolean deleteMinorSubHead(int minorsubheadId,Map<String, Object> generalMap);

	boolean editMinorSubHead(Map<String, Object> generalMap);

	Map<String, Object> searchMinorSubHead(String minorSubHeadCode,String minorSubHeadName);

	Map<String, Object> showObjectHead();

	boolean addObjectHead(BudObjectHead objecthead);

	boolean editObjectHead(Map<String, Object> generalMap);

	boolean deleteObjectHead(int objectheadId, Map<String, Object> generalMap);

	Map<String, Object> searchsubmajorHead(String submajorheadCode,	String submajorheadName);

	Map<String, Object> searchObjectHead(String objectheadCode,String objectheadName);

	Map<String, Object> showBudgetEstimateEntry();

	boolean submitBudget(BudEstimateEntry estimateentry);

	boolean addBudget(BudEstimateEntry estimate,Date encashDate,int objectheadId,String sectorType);

	Map<String, Object> showVoucherContingentBill();

/*	boolean addVoucher(BudVoucherHeader voucherHeader);*/

	Map<String, Object> showsearchBudgetEstimateEntry(String code);

	String generateBilltNo(String string);

	String generateOrderNumber();

	boolean submitVoucher(Box box);

	boolean addVoucher(Box box);

	Map<String, Object> getConnectionForReport();

	Map<String, Object> searchEstimation(int demandNo);

	Map<String, Object> showBudgetReappropEntry(int financialId);

	boolean addBudgetreapprop(BudReAppropEntry estimate,int budgetId);

	Map<String, Object> getNameTitle(String demandNo);

	boolean updateEstimateEntry(Map<String, Object> generalMap);

	Map<String, Object> searchBudgetEstimateEntry(int code1);

	Map<String, Object> showResponse(int objectheadId,int financialId,String sectorType);

	boolean addVoucher(BudVoucherHeader voucherHeader);

	Map<String, Object> searchBudgetReAppropEntry(int code1);

	Map<String, Object> getMaxEquipmentDate(int financialId);

	Map<String, Object> showVoucherReceiptEntry();

	//Map<String, Object> showReceipt(int financialId,String sectorType,int objectheadId);


	boolean addReceiptVoucher(BudVoucherReceiptEntry estimate,String receiptDate);

	Map<String, Object> searchReceiptNo(int code1);

	Map<String, Object> showMinorHead();

	boolean addMinorHead(BudMinorHead minorHead);

	boolean editMinorHead(Map<String, Object> generalMap);

	boolean deleteMinorHead(int minorsubheadId, Map<String, Object> generalMap);

	Map<String, Object> getHospitalName(Map<String, Object> mapForDs);

	Map<String, Object> showObj(String sectorType);

	boolean editBudget(Map<String, Object> generalMap);

	Map<String, Object> showReceipt(int objectheadId,String sectorType, int financialId);

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

	Map<String, Object> printVoucherReceipt(Map<String, Object> requestParameters);

	List<BudVoucherReceiptEntry> getReceiptNumberList();

	Map<String, Object> showPrintVoucherReport();

	
}
