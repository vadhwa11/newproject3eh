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
import jkt.hrms.masters.dataservice.IncomeTaxMasDataService;

public class IncomeTaxMasHandlerServiceImpl implements
		IncomeTaxMasHandlerService {

	private IncomeTaxMasDataService incomeTaxMasDataService = null;

	public IncomeTaxMasDataService getIncomeTaxMasDataService() {
		return incomeTaxMasDataService;
	}

	public void setIncomeTaxMasDataService(
			IncomeTaxMasDataService incomeTaxMasDataService) {
		this.incomeTaxMasDataService = incomeTaxMasDataService;
	}

	public Map showIncomeTaxSlabJsp() {

		return incomeTaxMasDataService.showIncomeTaxSlabJsp();
	}

	public Map searchItaxSlabMaster(Float taxRate, String financialYear) {

		return incomeTaxMasDataService.searchItaxSlabMaster(taxRate,
				financialYear);

	}

	public boolean addIncomeTaxSlabMaster(HrMasItaxSlab hrMasItaxSlab) {
		return incomeTaxMasDataService.addIncomeTaxSlabMaster(hrMasItaxSlab);
	}

	public boolean editIncomeTaxSlabMaster(Map generalMap) {
		return incomeTaxMasDataService.editIncomeTaxSlabMaster(generalMap);
	}

	public boolean deleteIncomeTaxSlabMaster(int slabid, Map generalMap) {
		return incomeTaxMasDataService.deleteIncomeTaxSlabMaster(slabid,
				generalMap);
	}

	public Map showFinancialJsp() {
		return incomeTaxMasDataService.showFinancialJsp();
	}

	// Start Added by Ramdular
	// +++++++++++++++++++++++++++++++++++++++++++++++2011/04/14

	public Map showIncomeTaxExemptJsp() {
		return incomeTaxMasDataService.showIncomeTaxExemptJsp();
	}

	public Map copyIncomeTaxExemptMaster(int copyFromYear, int copyToYear) {
		return incomeTaxMasDataService.copyIncomeTaxExemptMaster(copyFromYear,
				copyToYear);
	}

	public Map searchIncomeTaxExemptMaster(String financialYear) {
		return incomeTaxMasDataService
				.searchIncomeTaxExemptMaster(financialYear);
	}

	public boolean addIncomeTaxExemptMaster(
			HrMasItaxExemption hrMasItaxExemption) {
		return incomeTaxMasDataService
				.addIncomeTaxExemptMaster(hrMasItaxExemption);
	}

	public boolean editIncomeTaxExemptMaster(Map generalMap) {
		return incomeTaxMasDataService.editIncomeTaxExemptMaster(generalMap);
	}

	public boolean deleteIncomeTaxExemptMaster(int slabid, Map generalMap) {
		return incomeTaxMasDataService.deleteIncomeTaxExemptMaster(slabid,
				generalMap);
	}

	public Map searchFinancialYearMaster(String year, String financialYear) {
		return incomeTaxMasDataService.searchFinancialYearMaster(year,
				financialYear);
	}

	public boolean addFinancialYearMaster(HrMasFinancialYear hrMasFinancialYear) {
		return incomeTaxMasDataService
				.addFinancialYearMaster(hrMasFinancialYear);
	}

	public boolean editFinancialYearMaster(Map generalMap) {
		return incomeTaxMasDataService.editFinancialYearMaster(generalMap);
	}

	public Map showSectionInvestmentJsp() {
		return incomeTaxMasDataService.showSectionInvestmentJsp();
	}

	public Map copySectionInvestmentJsp(int copyFromYear, int copyToYear) {
		return incomeTaxMasDataService.copySectionInvestmentJsp(copyFromYear,
				copyToYear);
	}

	public Map searchSectionInvestmentJsp(String financialYear) {
		return incomeTaxMasDataService
				.searchSectionInvestmentJsp(financialYear);
	}

	public boolean addISectionInvestmentJsp(
			HrMasItaxSecInvestment hrMasItaxSecInvestment) {
		return incomeTaxMasDataService
				.addISectionInvestmentJsp(hrMasItaxSecInvestment);
	}

	public boolean editISectionInvestmentJsp(Map generalMap) {
		return incomeTaxMasDataService.editISectionInvestmentJsp(generalMap);
	}

	public boolean deleteISectionInvestmentJsp(int id, Map generalMap) {
		return incomeTaxMasDataService.deleteISectionInvestmentJsp(id,
				generalMap);
	}

	public Map showIncomeTaxSurchargeJsp() {
		return incomeTaxMasDataService.showIncomeTaxSurchargeJsp();
	}

	public Map copyIncomeTaxSurchargeJsp(int copyFromYear, int copyToYear) {
		return incomeTaxMasDataService.copyIncomeTaxSurchargeJsp(copyFromYear,
				copyToYear);
	}

	public Map searchIncomeTaxSurchargeJsp(String financialYear) {
		return incomeTaxMasDataService
				.searchIncomeTaxSurchargeJsp(financialYear);
	}

	public boolean addIncomeTaxSurchargeJsp(
			HrMasItaxSurcharge hrMasItaxSurcharge) {
		return incomeTaxMasDataService
				.addIncomeTaxSurchargeJsp(hrMasItaxSurcharge);
	}

	public boolean editIncomeTaxSurchargeJsp(Map generalMap) {
		return incomeTaxMasDataService.editIncomeTaxSurchargeJsp(generalMap);
	}

	public boolean deleteIncomeTaxSurchargeJsp(int id, Map generalMap) {
		return incomeTaxMasDataService.deleteIncomeTaxSurchargeJsp(id,
				generalMap);
	}

	public Map showSurchargeJsp() {
		return incomeTaxMasDataService.showSurchargeJsp();
	}

	public Map searchSurcharge(String code, String name) {
		return incomeTaxMasDataService.searchSurcharge(code, name);
	}

	public boolean addSurcharge(HrMasSurcharge hrMasSurcharge) {
		return incomeTaxMasDataService.addSurcharge(hrMasSurcharge);
	}

	public boolean editSurcharge(Map generalMap) {
		return incomeTaxMasDataService.editSurcharge(generalMap);
	}

	public boolean deleteSurcharge(int surchargeId, Map generalMap) {
		return incomeTaxMasDataService.deleteSurcharge(surchargeId, generalMap);
	}

	public Map showOtherIncomeCodeJsp() {
		return incomeTaxMasDataService.showOtherIncomeCodeJsp();
	}

	public Map searchOtherIncomeCode(String code, String name) {
		return incomeTaxMasDataService.searchOtherIncomeCode(code, name);
	}

	public boolean addOtherIncomeCode(HrMasItaxIncomeCode hrMasItaxIncomeCode) {
		return incomeTaxMasDataService.addOtherIncomeCode(hrMasItaxIncomeCode);
	}

	public boolean editOtherIncomeCode(Map generalMap) {
		return incomeTaxMasDataService.editOtherIncomeCode(generalMap);
	}

	public boolean deleteOtherIncomeCode(int otehrIncomeCodeId, Map generalMap) {
		return incomeTaxMasDataService.deleteOtherIncomeCode(otehrIncomeCodeId,
				generalMap);
	}

	public Map showEmployeeOtherEarningJsp() {
		return incomeTaxMasDataService.showEmployeeOtherEarningJsp();
	}

	public boolean addEmployeeOtherEarning(
			HrEmployeeOtherEarning hrEmployeeOtherEarning) {
		return incomeTaxMasDataService
				.addEmployeeOtherEarning(hrEmployeeOtherEarning);
	}

	public boolean editEmployeeOtherEarning(Map generalMap) {
		return incomeTaxMasDataService.editEmployeeOtherEarning(generalMap);
	}

	public boolean deleteEmployeeOtherEarning(int id, Map generalMap) {
		return incomeTaxMasDataService.deleteEmployeeOtherEarning(id,
				generalMap);
	}

	public Map showEmployeeInvestmentJsp() {
		return incomeTaxMasDataService.showEmployeeInvestmentJsp();
	}

	public Map showITComputationJsp() {
		return incomeTaxMasDataService.showITComputationJsp();
	}

	public List getITaxHeaderList(Map parameterMap) {
		return incomeTaxMasDataService.getITaxHeaderList(parameterMap);
	}

	public Object loadObject(Class klass, Integer id) {
		return incomeTaxMasDataService.loadObject(klass, id);
	}

	public List getPayElementsAmountSumList(List listHeader) {
		return incomeTaxMasDataService.getPayElementsAmountSumList(listHeader);
	}

	public HrEmployeePayStructure getEmployeePayStructure(Integer empId) {
		return incomeTaxMasDataService.getEmployeePayStructure(empId);
	}

	public List<HrEmployeePayElements> getEmployeePayElements(Integer empId) {
		return incomeTaxMasDataService.getEmployeePayElements(empId);
	}

	public List<HrMasFinancialYear> getFinancialYearList() {
		return incomeTaxMasDataService.getFinancialYearList();

	}

	public void saveObject(Object object) {
		incomeTaxMasDataService.saveObject(object);
	}

	public Boolean checkDuplicateITaxHeader(HrItaxHeader itaxHeader) {
		return incomeTaxMasDataService.checkDuplicateITaxHeader(itaxHeader);
	}

	public void removeItaxDetails(Map parameterMap) {
		incomeTaxMasDataService.removeItaxDetails(parameterMap);
	}

	public List<HrMasItaxSlab> getSlabList(Map map) {
		return incomeTaxMasDataService.getSlabList(map);
	}

	public List<HrMasItaxSurcharge> getSurcharge(HrMasFinancialYear finYear) {
		return incomeTaxMasDataService.getSurcharge(finYear);
	}

	public Connection getDBConnection() {
		return incomeTaxMasDataService.getDBConnection();
	}

	public Map saveEmployeeInvestment(Map generalMap) {
		return incomeTaxMasDataService.saveEmployeeInvestment(generalMap);
	}

	public Map checkEmployeeInvestment(Map generalMap) {
		return incomeTaxMasDataService.checkEmployeeInvestment(generalMap);
	}

	public Map<String, Object> getConnectionForReport() {
		return incomeTaxMasDataService.getConnectionForReport();
	}

	public boolean deleteFinancialYearMaster(int financialYrId, Map generalMap) {
		return incomeTaxMasDataService.deleteFinancialYearMaster(financialYrId,
				generalMap);
	}
	public List  getEmployeeListForITcomp()
	{
		return incomeTaxMasDataService.getEmployeeListForITcomp();
	}
	public Map computeIncomeTax(Map parameterMap)
	{
		return incomeTaxMasDataService.computeIncomeTax(parameterMap);
	}
	public Map computeIncomeTax(MasEmployee employee,Map parameterMap)
	{
		return incomeTaxMasDataService.computeIncomeTax(employee, parameterMap);
	}
	public Map checkForExistingIncomeTaxExempt(Map generalMap)
	{
		return incomeTaxMasDataService.checkForExistingIncomeTaxExempt(generalMap);
	}

	// End by Ramdular -----------------------------------------------2011/04/16
}
