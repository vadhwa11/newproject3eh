package jkt.hrms.masters.handler;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasEmployee;
import jkt.hrms.masters.business.HrEmployeeOtherEarning;
import jkt.hrms.masters.business.HrEmployeePayElements;
import jkt.hrms.masters.business.HrEmployeePayStructure;
import jkt.hrms.masters.business.HrItaxHeader;
import jkt.hrms.masters.business.HrMasFinancialYear;
import jkt.hrms.masters.business.HrMasItaxExemption;
import jkt.hrms.masters.business.HrMasItaxIncomeCode;
import jkt.hrms.masters.business.HrMasItaxSecInvestment;
import jkt.hrms.masters.business.HrMasItaxSlab;
import jkt.hrms.masters.business.HrMasItaxSurcharge;
import jkt.hrms.masters.business.HrMasSurcharge;

public interface IncomeTaxMasHandlerService {

	public Map showIncomeTaxSlabJsp();

	public Map searchItaxSlabMaster(Float taxRate, String financialYear);

	public boolean addIncomeTaxSlabMaster(HrMasItaxSlab hrMasItaxSlab);

	public boolean editIncomeTaxSlabMaster(Map generalMap);

	public boolean deleteIncomeTaxSlabMaster(int slabid, Map generalMap);

	public Map showFinancialJsp();

	// Start Added by Ramdular
	// +++++++++++++++++++++++++++++++++++++++++++++++2011/04/14

	public Map showIncomeTaxExemptJsp();

	public Map searchIncomeTaxExemptMaster(String financialYear);

	public boolean addIncomeTaxExemptMaster(
			HrMasItaxExemption hrMasItaxExemption);

	public boolean editIncomeTaxExemptMaster(Map generalMap);

	public boolean deleteIncomeTaxExemptMaster(int slabid, Map generalMap);

	public Map copyIncomeTaxExemptMaster(int copyFromYear, int copyToYear);

	public Map searchFinancialYearMaster(String year, String financialYear);

	public boolean addFinancialYearMaster(HrMasFinancialYear hrMasFinancialYear);

	public boolean editFinancialYearMaster(Map generalMap);

	public Map showSectionInvestmentJsp();

	public Map copySectionInvestmentJsp(int copyFromYear, int copyToYear);

	public Map searchSectionInvestmentJsp(String financialYear);

	public boolean addISectionInvestmentJsp(
			HrMasItaxSecInvestment hrMasItaxSecInvestment);

	public boolean editISectionInvestmentJsp(Map generalMap);

	public boolean deleteISectionInvestmentJsp(int id, Map generalMap);

	public Map showIncomeTaxSurchargeJsp();

	public Map copyIncomeTaxSurchargeJsp(int copyFromYear, int copyToYear);

	public Map searchIncomeTaxSurchargeJsp(String financialYear);

	public boolean addIncomeTaxSurchargeJsp(
			HrMasItaxSurcharge hrMasItaxSurcharge);

	public boolean editIncomeTaxSurchargeJsp(Map generalMap);

	public boolean deleteIncomeTaxSurchargeJsp(int id, Map generalMap);

	public Map showSurchargeJsp();

	public Map searchSurcharge(String code, String name);

	public boolean addSurcharge(HrMasSurcharge hrMasSurcharge);

	public boolean editSurcharge(Map generalMap);

	public boolean deleteSurcharge(int surchargeId, Map generalMap);

	public Map showOtherIncomeCodeJsp();

	public Map searchOtherIncomeCode(String code, String name);

	public boolean addOtherIncomeCode(HrMasItaxIncomeCode hrMasItaxIncomeCode);

	public boolean editOtherIncomeCode(Map generalMap);

	public boolean deleteOtherIncomeCode(int otehrIncomeCodeId, Map generalMap);

	public Map showEmployeeOtherEarningJsp();

	public boolean addEmployeeOtherEarning(
			HrEmployeeOtherEarning hrEmployeeOtherEarning);

	public boolean editEmployeeOtherEarning(Map generalMap);

	public boolean deleteEmployeeOtherEarning(int id, Map generalMap);

	public Map showITComputationJsp();

	public List getITaxHeaderList(Map parameterMap);

	public Object loadObject(Class klass, Integer id);

	public List getPayElementsAmountSumList(List listHeader);

	public HrEmployeePayStructure getEmployeePayStructure(Integer empId);

	public List<HrEmployeePayElements> getEmployeePayElements(Integer empId);

	public List<HrMasFinancialYear> getFinancialYearList();

	public void saveObject(Object object);

	public Boolean checkDuplicateITaxHeader(HrItaxHeader itaxHeader);

	public void removeItaxDetails(Map parameterMap);

	public List<HrMasItaxSlab> getSlabList(Map map);

	public List<HrMasItaxSurcharge> getSurcharge(HrMasFinancialYear finYear);

	public Map showEmployeeInvestmentJsp();

	public Connection getDBConnection();

	public Map saveEmployeeInvestment(Map generalMap);

	public Map checkEmployeeInvestment(Map generalMap);

	public Map<String, Object> getConnectionForReport();

	public boolean deleteFinancialYearMaster(int financialYrId, Map generalMap);

	public List getEmployeeListForITcomp();

	Map computeIncomeTax(Map parameterMap);

	public Map computeIncomeTax(MasEmployee employee, Map parameterMap);

	public Map checkForExistingIncomeTaxExempt(Map generalMap);

	// End by Ramdular -----------------------------------------------2011/04/16
}
