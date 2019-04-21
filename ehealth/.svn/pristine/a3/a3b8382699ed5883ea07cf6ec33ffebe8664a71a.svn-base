package jkt.hrms.util;

import static jkt.hrms.util.HrmsRequestConstants.EMPLOYEE_ID;


import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletOutputStream;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.web.servlet.ModelAndView;

import jkt.hms.masters.business.MasEmployee;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.hrms.itax.pojo.ItaxDetailsYearly;
import jkt.hrms.itax.pojo.ItaxPayElementsPojo;
import jkt.hrms.masters.business.HrArrear;
import jkt.hrms.masters.business.HrBonusDetail;
import jkt.hrms.masters.business.HrEmployeeInvestment;
import jkt.hrms.masters.business.HrEmployeeOtherEarning;
import jkt.hrms.masters.business.HrEmployeePayElements;
import jkt.hrms.masters.business.HrEmployeePayStructure;
import jkt.hrms.masters.business.HrItaxCalculate;
import jkt.hrms.masters.business.HrItaxDetails;
import jkt.hrms.masters.business.HrItaxHeader;
import jkt.hrms.masters.business.HrLoanHeader;
import jkt.hrms.masters.business.HrMasFinancialYear;
import jkt.hrms.masters.business.HrMasItaxSlab;
import jkt.hrms.masters.business.HrMasItaxSurcharge;
import jkt.hrms.masters.business.HrPayrollProcessDetail;
import jkt.hrms.masters.business.HrPayrollProcessHeader;
import jkt.hrms.masters.handler.IncomeTaxMasHandlerService;
import jkt.hrms.masters.handler.IncomeTaxMasHandlerServiceImpl;

public class IncomeTaxUtil {
	public static String[] months = {"Jan","Feb","Mar","April","May","Jun","July","August","Sept","Oct","Nov","Dec"};
	
	
	private static MasEmployee employee = null;
	private static HrPayrollProcessHeader employeePayrollProcessHeader = null;
	private static List<HrBonusDetail> bonusDetailsList = null;
	private static List<HrArrear> listArrear = null;
	private static HrLoanHeader employeeLoanHeader = null;
	private static BigDecimal arrearBasic = new BigDecimal(0.0);
	private static BigDecimal  bonusAmount = new BigDecimal(0.0);
	private static List<HrEmployeeOtherEarning> employeeOtherEarningsList = null;
	private static BigDecimal  employeeOtherEarningsAmount = new BigDecimal(0.0);
	
	private static BigDecimal taxablePayElemntsAmount = new BigDecimal(0.0);
	private static List<HrPayrollProcessDetail> emptaxablePayElemntsList = new ArrayList<HrPayrollProcessDetail>();
	private static List<HrEmployeeInvestment> employeeInvestmentList = new ArrayList<HrEmployeeInvestment>();
	private static List<HrArrear> employeeTaxableArrear = new ArrayList<HrArrear>();
	private static IncomeTaxMasHandlerService incomeTaxMasHandlerService ;
	private static HrItaxHeader iTaxHeader = new HrItaxHeader(); 
	private static HrMasFinancialYear financialYr = null;
	public static void initialize(Map returnMap)
	{
		 incomeTaxMasHandlerService = (IncomeTaxMasHandlerService)returnMap.get("incomeTaxMasHandlerService"); 
		 if(returnMap.get("employeePayrollProcessHeader")!=null)
		 employeePayrollProcessHeader = (HrPayrollProcessHeader)returnMap.get("employeePayrollProcessHeader"); 
		 int employeeId  = (Integer)returnMap.get("empId");
		 employee = (MasEmployee)incomeTaxMasHandlerService.loadObject(MasEmployee.class, employeeId);
		 bonusDetailsList = (List)returnMap.get("bonusDetailsList");//from db
		 listArrear = (List)returnMap.get("listArrear");//from db
		 //employeeLoanHeader = (HrLoanHeader)returnMap.get("employeeLoanHeader");//from db
		 taxablePayElemntsAmount = new BigDecimal(0.0);
		 emptaxablePayElemntsList = new ArrayList<HrPayrollProcessDetail>();
		 employeeInvestmentList =(List)returnMap.get("employeeInvestmentList");//from db
		 if(employeePayrollProcessHeader!=null){
		 arrearBasic = employeePayrollProcessHeader.getArrearSalaryAmt();//(BigDecimal)returnMap.get("arrearBasic");
		 }
		 bonusAmount = new BigDecimal(0.0);
		 employeeOtherEarningsList = (List)returnMap.get("employeeOtherEarningsList");//from db
		 employeeOtherEarningsAmount = new BigDecimal(0.0);
		 
		 if(employeePayrollProcessHeader!=null)
		 financialYr = IncomeTaxUtil.getCurrentFinancialYear(employeePayrollProcessHeader.getYear(),employeePayrollProcessHeader.getMonth(),25);
		 Map parameterMap = new HashMap();
		 parameterMap.put("empId", employee.getId());
		 parameterMap.put("finYrId",financialYr.getId() );
		 List<HrItaxHeader> itaxHeaderList = incomeTaxMasHandlerService.getITaxHeaderList(parameterMap);
		 List<HrItaxHeader> tempItaxHeaderList = new ArrayList<HrItaxHeader>();
		 for(HrItaxHeader itaxHeader:itaxHeaderList)
		 {
			 if(itaxHeader.getFMonth().equals(employeePayrollProcessHeader.getMonth()-1))
			 {
				 tempItaxHeaderList.add(itaxHeader);
			 }
		 }
		 if(tempItaxHeaderList.size()==0){
			 iTaxHeader = new HrItaxHeader();
		 }
		 else if(tempItaxHeaderList.size()==1)
		 {
			 iTaxHeader = tempItaxHeaderList.get(0);
		 }
			 
	}
	
	public static BigDecimal computeEarnings()
	{
		BigDecimal totalTaxableEarnings = new BigDecimal(0.0);
		BigDecimal basic = new BigDecimal(0.0);
		BigDecimal arrearSalary = new BigDecimal(0.0);
		
		
		BigDecimal arrearElementsAmount = new BigDecimal(0.0);
		
		//BigDecimal loanAmount = new BigDecimal(0.0);
		
		if(employeePayrollProcessHeader!=null)
		{
			basic = employeePayrollProcessHeader.getBasic();
			arrearSalary = arrearBasic;
			Set employeePayRollProcessDetailsSet = employeePayrollProcessHeader.getHrPayrollProcessDetails();
			List<HrPayrollProcessDetail> employeePayRollProcessDetailsList = new ArrayList();
			if(employeePayRollProcessDetailsSet!=null)
			{
				employeePayRollProcessDetailsList = new ArrayList<HrPayrollProcessDetail>(employeePayRollProcessDetailsSet);
				computeTotalTaxablePayElementAmount(employeePayRollProcessDetailsList);
			}
			
		}//end of outer most If
		
		
		//calculating arrear elements amount
		if(listArrear !=null && listArrear.size()!=0)
		{
			
			for(HrArrear employeeArrear : listArrear)
			{
				if(employeeArrear.getPayElement().getTaxableElement().equals("y") && employeeArrear.getArrearStatus().equals("unpaid"))
				{
				  arrearElementsAmount = arrearElementsAmount.add(employeeArrear.getArrearAmount());
				  employeeTaxableArrear.add(employeeArrear);
				}
			}
		}
		
		//calculating bonus
		if(bonusDetailsList!=null && bonusDetailsList.size()!=0)
		{
			for(HrBonusDetail bonusDetail : bonusDetailsList)
			{
				if(bonusDetail.getBonus().getTaxable().equals("y"))
				{
					bonusAmount = bonusAmount.add(bonusDetail.getBonusAmount());
				}
			}
		}
		
		if(employeeOtherEarningsList!=null && employeeOtherEarningsList.size()>0)
		{
			for(HrEmployeeOtherEarning employeeOtherEarning : employeeOtherEarningsList)
			{
				employeeOtherEarningsAmount = employeeOtherEarningsAmount.add(employeeOtherEarning.getIncomeAmount());
			}
		}
		//calculating loan
		/*if(employeeLoanHeader!=null)
		{
			
			loanAmount =  employeeLoanHeader.getLoanPAmount();
		}*/
		
		totalTaxableEarnings = basic.add(taxablePayElemntsAmount)
									.add(arrearElementsAmount)
									.add(arrearSalary)
									.add(bonusAmount)
									.add(employeeOtherEarningsAmount);
		
		
		return totalTaxableEarnings;	
	}

	public static BigDecimal computeDeductions()
	{
		//BigDecimal advanceInstallments = new BigDecimal(0.0);
		//BigDecimal loanInstallments = new BigDecimal(0.0);
		BigDecimal totalDeductions = new BigDecimal(0.0);
		BigDecimal payelementsDedc = new BigDecimal(0.0);
		if(employeePayrollProcessHeader!=null )
		{
			/*if(employeePayrollProcessHeader.getAdvanceInstallment()!=null)
			advanceInstallments = employeePayrollProcessHeader.getAdvanceInstallment();
			
			if(employeePayrollProcessHeader.getLoanInstallment()!=null)
			loanInstallments = employeePayrollProcessHeader.getLoanInstallment();
			*/
		}
		
		if(employeePayrollProcessHeader!=null)
		{
		Set employeePayRollProcessDetailsSet = employeePayrollProcessHeader.getHrPayrollProcessDetails();
		List<HrPayrollProcessDetail> employeePayRollProcessDetailsList = new ArrayList();
		if(employeePayRollProcessDetailsSet!=null)
		{
			employeePayRollProcessDetailsList = new ArrayList<HrPayrollProcessDetail>(employeePayRollProcessDetailsSet);
			for(HrPayrollProcessDetail payrollProcessDetail: employeePayRollProcessDetailsList)
			{
				if(payrollProcessDetail!=null)
				{
					HrEmployeePayElements employeePayElement =  payrollProcessDetail.getEmpPayElement();
					if(employeePayElement.getPayElement().getPayElementType().equals("Deduction"))
					{
						
						if(payrollProcessDetail.getPayelementAmount()!=null)
							{
							payelementsDedc = payelementsDedc.add(payrollProcessDetail.getPayelementAmount());
							emptaxablePayElemntsList.add(payrollProcessDetail);
							}
					}
					
				}
			}//end of for loop
		}
		
	}//end of outer most If
		totalDeductions = payelementsDedc ;//.add(advanceInstallments).add(loanInstallments);

		return totalDeductions;
	}
	
	public static void computeTotalTaxablePayElementAmount(List<HrPayrollProcessDetail> employeePayRollProcessDetailsList)
	{
		
		for(HrPayrollProcessDetail payrollProcessDetail: employeePayRollProcessDetailsList)
		{
			if(payrollProcessDetail!=null)
			{
				HrEmployeePayElements employeePayElement =  payrollProcessDetail.getEmpPayElement();
				if(employeePayElement!=null && employeePayElement.getPayElement().getPayElementType().equals("Addition") && employeePayElement.getPayElement().getTaxableElement().equals("y"))
				{
					
					if(payrollProcessDetail.getPayelementAmount()!=null)
					{
						taxablePayElemntsAmount = taxablePayElemntsAmount.add(payrollProcessDetail.getPayelementAmount());
						emptaxablePayElemntsList.add(payrollProcessDetail);
					}
				}
				
				if(employeePayElement.getPayElement().getPayElementType().equals("Reimb") && employeePayElement.getPayElement().getTaxableElement().equals("y"))
				{
					BigDecimal taxableReimAmount = new BigDecimal(0.0);
					if(payrollProcessDetail.getPayelementAmount()!=null)
					{
						taxableReimAmount = payrollProcessDetail.getPayelementAmount();
						emptaxablePayElemntsList.add(payrollProcessDetail);
					}
					taxablePayElemntsAmount = taxablePayElemntsAmount.add(taxableReimAmount);
				}
				
			}
			
			
		}
	}
	
	
	public static BigDecimal computeInvestments()
	{
		BigDecimal investment = new BigDecimal(0.0); 
		BigDecimal totalInvestments = new BigDecimal(0.0);
		for(HrEmployeeInvestment employeeInvestment:employeeInvestmentList)
		{
			if(employeeInvestment.getInvAmount()!=null)
			{
				
				investment = employeeInvestment.getInvAmount();
				if(investment.compareTo(employeeInvestment.getSecInvest().getHrMasItaxExemption().getMaximumAmt()) == 1){
					if(investment.compareTo(employeeInvestment.getSecInvest().getMaxAmount()) == 1)
					investment = employeeInvestment.getSecInvest().getMaxAmount();
				}
				else 
				{
					if(investment.compareTo(employeeInvestment.getSecInvest().getMaxAmount()) == 1)
					investment = employeeInvestment.getSecInvest().getMaxAmount();
				}
				totalInvestments = totalInvestments.add(investment);	
			}
			
		}
		
		return totalInvestments;
	}
	
	/*public static Map getIncomeTaxReturnMap()
	{
		computeEarnings();
		computeDeductions();
		computeInvestments();
		return null;
	}*/
	
	public static void populateItaxDetails(MasEmployee employee)
	{
	Map<String, Object> map =new HashMap<String, Object>();
	Integer empId = 0;
	String employeeIdstring = "";
	
	
	Integer year = employeePayrollProcessHeader.getYear();
	Integer month = employeePayrollProcessHeader.getMonth()-1;
	Calendar c = Calendar.getInstance();
	c.set(year, month, 1);
	Date payRollDate = c.getTime();
	HrMasFinancialYear payRollFinancialYear = null;
	//get Current Financial Year 
	List<HrMasFinancialYear> listFinList = incomeTaxMasHandlerService.getFinancialYearList();
	
	for(HrMasFinancialYear finYr : listFinList)
	{
	 if(payRollDate.after(finYr.getYearFromDate()) && payRollDate.before(finYr.getYearToDate()))
		{
		 payRollFinancialYear = finYr;
		}
	}
		BigDecimal taxableEarningsAmount =  IncomeTaxUtil.computeEarnings();
		BigDecimal deductionsforTaxCalc = IncomeTaxUtil.computeDeductions();
		List<HrPayrollProcessDetail> empTaxablePayElementsList = IncomeTaxUtil.getEmptaxablePayElemntsList();
		BigDecimal totalInvestments =  IncomeTaxUtil.computeInvestments();
		List<HrEmployeeInvestment> employeeInvestmentsList = IncomeTaxUtil.getEmployeeInvestmentList();
		BigDecimal totalDeductions = deductionsforTaxCalc; 
		BigDecimal netIncome = taxableEarningsAmount.subtract(totalDeductions);
		
		
		
		iTaxHeader.setDeduction(totalDeductions);
		iTaxHeader.setEarning(taxableEarningsAmount);
		iTaxHeader.setEmployee(employee);
		iTaxHeader.setNetIncome(netIncome);
		iTaxHeader.setFMonth(month);
		iTaxHeader.setItax(new BigDecimal(0.0));
		
		
		iTaxHeader.setFYear(payRollFinancialYear);
		Boolean duplicateExists = incomeTaxMasHandlerService.checkDuplicateITaxHeader(iTaxHeader);
		
		if(true){
		try{
			incomeTaxMasHandlerService.saveObject(iTaxHeader);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//removing previously entered itax details for same month in case of update
		Map parameterMap = new HashMap();
		parameterMap.put("iTaxHeaderId", iTaxHeader.getId());
		//parameterMap.put("finYr", financialYr);
		//parameterMap.put("month",month);
		incomeTaxMasHandlerService.removeItaxDetails(parameterMap);
		
		//saving employee basic
		HrItaxDetails itaxDetails1 = new HrItaxDetails();
		itaxDetails1.setAmount(employeePayrollProcessHeader.getBasic());
		itaxDetails1.setItaxHeader(iTaxHeader);
		itaxDetails1.setPayElement("Basic");
		itaxDetails1.setElementType("A");
		incomeTaxMasHandlerService.saveObject(itaxDetails1);
		
		
		//saving taxable pay elements
		for(HrPayrollProcessDetail payproDet : empTaxablePayElementsList)
		{
			HrItaxDetails iTaxDetails = new HrItaxDetails();
			iTaxDetails.setAmount(payproDet.getPayelementAmount());
			
			if(payproDet.getEmpPayElement().getPayElement().getPayElementType().equals("Addition"))
			iTaxDetails.setElementType("A");
			else if(payproDet.getEmpPayElement().getPayElement().getPayElementType().equals("Deduction"))
			{
			
		     iTaxDetails.setElementType("D");
			 
		   //hard coding section in case pay elemnt is PF(Id=8)
		     if(payproDet.getEmpPayElement().getPayElement().getId().equals(8))
		     iTaxDetails.setSection("SEC80(C)");
			
			}
			else
			iTaxDetails.setElementType("R");	
			
			iTaxDetails.setItaxHeader(iTaxHeader);
			iTaxDetails.setPayElement(payproDet.getEmpPayElement().getPayElement().getPayElementDesc());
			
			incomeTaxMasHandlerService.saveObject(iTaxDetails);
		}
		//saving emp investments
		for(HrEmployeeInvestment empInv : employeeInvestmentsList)
		{
			HrItaxDetails itaxDetails = new HrItaxDetails();
			itaxDetails.setAmount(empInv.getInvAmount());
			itaxDetails.setItaxHeader(iTaxHeader);
			itaxDetails.setPayElement(empInv.getSecInvest().getInvestmentType().getInvestmentDescription());
			itaxDetails.setSection(empInv.getSecInvest().getHrMasItaxExemption().getSectionCode());
			itaxDetails.setElementType("I");
			incomeTaxMasHandlerService.saveObject(itaxDetails);
		}
		
		//saving taxable arrear pay elements
		for(HrArrear emplArrear : employeeTaxableArrear)
		{
			HrItaxDetails itaxDetails = new HrItaxDetails();
			itaxDetails.setAmount(emplArrear.getArrearAmount());
			itaxDetails.setItaxHeader(iTaxHeader);
			itaxDetails.setPayElement("Arrear "+ emplArrear.getPayElement().getPayElementDesc());
			itaxDetails.setElementType("A");
			incomeTaxMasHandlerService.saveObject(itaxDetails);
		}
		//saving taxable arrear basic
		if(employeePayrollProcessHeader.getArrearSalaryAmt().compareTo(new BigDecimal(0.0)) != 0)
			{
				HrItaxDetails itaxDetails = new HrItaxDetails();
				itaxDetails.setAmount(arrearBasic);
				itaxDetails.setItaxHeader(iTaxHeader);
				itaxDetails.setPayElement("Arrear Basic");
				itaxDetails.setElementType("A");
				incomeTaxMasHandlerService.saveObject(itaxDetails);
			}
		
		//saving bonus
		HrItaxDetails itaxDetails = new HrItaxDetails();
		itaxDetails.setAmount(bonusAmount);
		itaxDetails.setItaxHeader(iTaxHeader);
		itaxDetails.setPayElement("Bonus");
		itaxDetails.setElementType("A");
		incomeTaxMasHandlerService.saveObject(itaxDetails);
		
		//saving other earnings
		for(HrEmployeeOtherEarning employeeOtherEarning : employeeOtherEarningsList)
		{
			HrItaxDetails itaxDetails2 = new HrItaxDetails();
			itaxDetails2.setAmount(employeeOtherEarningsAmount);
			itaxDetails2.setItaxHeader(iTaxHeader);
			itaxDetails2.setPayElement(employeeOtherEarning.getIncomeCode().getIncomeDesc());
			itaxDetails2.setElementType("O");
			incomeTaxMasHandlerService.saveObject(itaxDetails2);
		}
		
		}
		else
		{
			
		}
	
	}
	
	public static Map calculateIncomeTax(Map<String,Object> incometaxMap)
	 {
		BigDecimal  totalYearEarings = (BigDecimal)incometaxMap.get("totalYearEarings");
		BigDecimal  totalYearDed = (BigDecimal)incometaxMap.get("totalYearDed");
		BigDecimal  processedTotalInvestments = (BigDecimal)incometaxMap.get("processedTotalInvestments");
		BigDecimal  processedTotalOtherEarnings = (BigDecimal)incometaxMap.get("processedTotalOtherEarnings");
		HrMasFinancialYear finYear = (HrMasFinancialYear)incometaxMap.get("financialYear");
		MasEmployee employee = (MasEmployee)incometaxMap.get("employee");
		IncomeTaxMasHandlerService incomeTaxMasHandlerService = (IncomeTaxMasHandlerService)incometaxMap.get("incomeTaxMasHandlerService");
		if(incomeTaxMasHandlerService==null)
		{
			incomeTaxMasHandlerService = IncomeTaxUtil.incomeTaxMasHandlerService;
		}
		BigDecimal taxableSalary = totalYearEarings.add(processedTotalOtherEarnings).subtract(totalYearDed).subtract(processedTotalInvestments);
		BigDecimal taxableSalary1 = taxableSalary; 
		String citizen = "";
		
		//commented for maven
		/*if(employee.getEmployeePersonalDetails().getGender().getId().equals(3))
		{
			citizen = "m";
		}
		else if(employee.getEmployeePersonalDetails().getGender().getId().equals(2))
		{
			citizen = "f";
		}
		*/
		Date currDate = new Date();
		
		//commented for maven
		/*if(employee.getEmployeePersonalDetails().getDateOfBirth()!=null){
			Integer age = currDate.getYear() - employee.getEmployeePersonalDetails().getDateOfBirth().getYear();
			if(age>=60)
			{
				citizen = "s";
			}
		}*/
		Map parameterMap = new HashMap();
		parameterMap.put("citizen", citizen);
		parameterMap.put("finyear", finYear);
		List<HrMasItaxSlab> slabList = incomeTaxMasHandlerService.getSlabList(parameterMap);
		BigDecimal incomeTax = new BigDecimal(0.0);
		/*for(HrMasItaxSlab slab : slabList)
		{
			if((taxableSalary.compareTo(new BigDecimal(0))!=0 )&& (taxableSalary.compareTo(slab.getLowerLimit())==1 || taxableSalary.compareTo(slab.getLowerLimit())==0))
			{	BigDecimal slabAmountTaxable = new BigDecimal(0.0);
				if(taxableSalary.compareTo(slab.getUpperLimit())==-1 || taxableSalary.compareTo(slab.getUpperLimit())==0) // lies between range
				{
					 slabAmountTaxable = taxableSalary.subtract(new BigDecimal(1));
					 taxableSalary = new BigDecimal(0);
				}
				else // lies beyond upper limit
				{
					 slabAmountTaxable = slab.getUpperLimit().subtract(slab.getLowerLimit()).add(new BigDecimal(1));
					 taxableSalary = taxableSalary.subtract(slab.getUpperLimit().subtract(slab.getLowerLimit()));
				}
				BigDecimal slabTax = slabAmountTaxable.multiply(slab.getTaxRate());
				slabTax = slabTax.divide(new BigDecimal(100));
				incomeTax = incomeTax.add(slabTax);
			}
			else
			{
				
				
			}*/
		HrMasItaxSlab enclosingSlabtaxableSlab = null;
		BigDecimal remainingTaxableSalary = taxableSalary; 
		BigDecimal slabTax = new BigDecimal(0.0);
		for(HrMasItaxSlab slab : slabList)
		{
			if((taxableSalary.compareTo(new BigDecimal(0))!=0 )&& (taxableSalary.compareTo(slab.getLowerLimit())==1 || taxableSalary.compareTo(slab.getLowerLimit())==0))
			{	BigDecimal slabAmount = slab.getUpperLimit().subtract(slab.getLowerLimit()).add(new BigDecimal(1));
				if(taxableSalary.compareTo(slab.getLowerLimit())==1 && taxableSalary.compareTo(slab.getUpperLimit())==-1)
				{
					enclosingSlabtaxableSlab = slab;
					taxableSalary = taxableSalary.subtract(slab.getLowerLimit());
					break;
				}
				else
				{
					remainingTaxableSalary = remainingTaxableSalary.subtract(slabAmount);
					slabTax = slabTax.add((slabAmount.multiply(slab.getTaxRate())).divide(new BigDecimal(100)));
				}
			}
			else
			{
				
				
			}
		}
		if(slabList!=null && enclosingSlabtaxableSlab!=null && slabList.size()>0){
		incomeTax = slabTax.add((taxableSalary.multiply(enclosingSlabtaxableSlab.getTaxRate())).divide(new BigDecimal(100)));
		}
		List<HrMasItaxSurcharge> itaxSurchargeList = incomeTaxMasHandlerService.getSurcharge(finYear); 
		BigDecimal surcharge = new BigDecimal(0.0);
		BigDecimal eduCess = new BigDecimal(0.0);
		for(HrMasItaxSurcharge itaxSurcharge:itaxSurchargeList){
		if(itaxSurcharge.getSurchargeBase().equals("t"))
		{
			surcharge = incomeTax.multiply(itaxSurcharge.getPercentOne());
			surcharge = surcharge.divide(new BigDecimal(100));
			if(surcharge.compareTo(itaxSurcharge.getLowerLimit())==-1 )
			{
				surcharge = itaxSurcharge.getLowerLimit();
			}
			
			if(surcharge.compareTo(itaxSurcharge.getUpperLimit())== 1 )
			{
				surcharge = itaxSurcharge.getUpperLimit();
			}
		}	
		else if(itaxSurcharge.getSurchargeBase().equals("s"))
		{
			//eduCess = taxableSalary1.multiply(itaxSurcharge.getPercentOne());
			if(taxableSalary1.compareTo(itaxSurcharge.getMinTaxSal())==1){
			eduCess = incomeTax.add(surcharge);
			eduCess = eduCess.multiply(itaxSurcharge.getPercentOne());
			eduCess = eduCess.divide(new BigDecimal(100));
			
			if(eduCess.compareTo(itaxSurcharge.getLowerLimit())==-1 )
			{
				eduCess = itaxSurcharge.getLowerLimit();
			}
			
			if(eduCess.compareTo(itaxSurcharge.getUpperLimit())== 1 )
			{
				eduCess = itaxSurcharge.getUpperLimit();
			}
			}
		}
		
		
		}
		Map returnMap = new HashMap();
		returnMap.put("taxableSalary", taxableSalary1);
		returnMap.put("taxOnTotalIncome", incomeTax);
		returnMap.put("surcharge", surcharge);
		returnMap.put("eduCess", eduCess);
		return returnMap;
	 }

	
	public static BigDecimal computeIncomeTax() throws Exception
	{

		HrMasFinancialYear finYr = null;
		finYr = IncomeTaxUtil.getCurrentFinancialYear(employeePayrollProcessHeader.getYear(),employeePayrollProcessHeader.getMonth(),25);
		Map parameterMap = new HashMap();
		parameterMap.put("empId", employee.getId());
		parameterMap.put("finYrId", finYr.getId());
		List<HrItaxHeader> iTaxHeaderList = incomeTaxMasHandlerService.getITaxHeaderList(parameterMap);
		List<Integer> processedMonths = new ArrayList<Integer>();
		List<Integer> unProcessedMonths = new ArrayList<Integer>();
		
		for(int i=0;i<12;i++)
		{
			unProcessedMonths.add(i);
		}
		Integer lastMonthProcessed = 0;
		HrItaxHeader lastprocessedItaxHeader = null;
		
		//List<HrItaxHeader> itaxHeaderListProcessed = new ArrayList<HrItaxHeader>();
		for(HrItaxHeader itaxHeader:iTaxHeaderList)
		{
			unProcessedMonths.remove(itaxHeader.getFMonth());
			processedMonths.add(itaxHeader.getFMonth());
		}
		if(processedMonths.size()!=0)
		{
		lastMonthProcessed = Collections.max(processedMonths);
		}
		else
		{
			
			return null;
		}
		for(HrItaxHeader itaxHeader:iTaxHeaderList)
		{
			if(itaxHeader.getFMonth().equals(lastMonthProcessed))
			{
				lastprocessedItaxHeader = itaxHeader;
			}
		}
		
		//HrMasFinancialYear finYr = (HrMasFinancialYear)incomeTaxMasHandlerService.loadObject(HrMasFinancialYear.class, finYrId);
		HrEmployeePayStructure payStructure = null;
		if(incomeTaxMasHandlerService.getEmployeePayStructure(employee.getId()) != null){
		payStructure = incomeTaxMasHandlerService.getEmployeePayStructure(employee.getId());
		}
		List<HrEmployeePayElements> employeePayElements = incomeTaxMasHandlerService.getEmployeePayElements(employee.getId());
		List payElementsAmountSum = incomeTaxMasHandlerService.getPayElementsAmountSumList(iTaxHeaderList);
		BigDecimal processedEarnings = new BigDecimal(0.0);
		BigDecimal processeddeductions = new BigDecimal(0.0);
		BigDecimal processedTotalInvestments = new BigDecimal(0.0);
		BigDecimal processedTotalOtherEarnings = new BigDecimal(0.0);
		
		List<ItaxPayElementsPojo> deductionsList = new ArrayList<ItaxPayElementsPojo>();
		List<ItaxPayElementsPojo> earningsList = new ArrayList<ItaxPayElementsPojo>();
		
		for(int i=0;i<payElementsAmountSum.size();i++)
		{
			Object[] ar =(Object[]) payElementsAmountSum.get(i);
			
			    BigDecimal totalPayelementAmountForYear = new BigDecimal(0.0);
				BigDecimal monthlyPayelemntAmount = new BigDecimal(0.0);
			    BigDecimal payelemetSum = (BigDecimal)ar[0];
				String payElement = (String)ar[1];
				String elementtype = (String)ar[2];
				String section = (String)ar[3];
				
				
				
				for(HrEmployeePayElements payElements:employeePayElements)
				{
					if(payElements.getPayAmount()!=null && payElements.getStatus().equals("y") && payElements.getPayElement().getTaxableElement().equals("y"))
					{
					if(payElements.getPayElement().getPayElementType().equals("Addition") || payElements.getPayElement().getPayElementType().equals("Reimb"))
					{
					   if(payElements.getPayElement().getPayElementDesc().equals(payElement))
					   {
						   monthlyPayelemntAmount = monthlyPayelemntAmount.add(payElements.getPayAmount());
							 
					   }
					   
					   /*else if(payElement.equals("Basic"))
						 {
						   monthlyPayelemntAmount = monthlyPayelemntAmount.add(payStructure.getBasicPay().multiply(new BigDecimal(unProcessedMonths.size())));
						 }*/
					}
					if(payElements.getPayElement().getPayElementType().equals("Deduction"))
					{
						 if(payElements.getPayElement().getPayElementDesc().equals(payElement))
						   {
							 monthlyPayelemntAmount = monthlyPayelemntAmount.add(payElements.getPayAmount());

							  
						   }
					}
					}
					
				}
				BigDecimal monthlyBasic = new BigDecimal(0);
				if(payStructure!=null){
					monthlyBasic= payStructure.getBasicPay();
				}
				
				if(payElement.equals("Basic"))
				{
					totalPayelementAmountForYear = payelemetSum.add(monthlyBasic.multiply(new BigDecimal(unProcessedMonths.size())));
				}
				else
				{
					totalPayelementAmountForYear = payelemetSum.add(monthlyPayelemntAmount.multiply(new BigDecimal(unProcessedMonths.size())));
				}
				ItaxPayElementsPojo  itaxPayElementsPojo = new ItaxPayElementsPojo();
				itaxPayElementsPojo.setPayElement(payElement);
				
				itaxPayElementsPojo.setAmount(totalPayelementAmountForYear);
				if(elementtype.equals("A") || elementtype.equals("R") || elementtype.equals("O"))
				{
					 processedEarnings = processedEarnings.add(payelemetSum);
					 earningsList.add(itaxPayElementsPojo);
	 
				}
				else if(elementtype.equals("D") || elementtype.equals("I") )
				{
					processeddeductions = processeddeductions.add(payelemetSum);
					itaxPayElementsPojo.setSection(section);
					deductionsList.add(itaxPayElementsPojo);
				}
				
				
		}
		
		
		
		
		/*ItaxPayElementsPojo otherearnings = new ItaxPayElementsPojo();
		otherearnings.setAmount(processedTotalOtherEarnings);
		otherearnings.setPayElement("Other Earnings");
		earningsList.add(otherearnings);*/
		
		
		
		
		for(HrItaxDetails itaxDetails : lastprocessedItaxHeader.getITaxDetailsSet())
		{
			if(itaxDetails.getElementType().equals("I"))
			{
				processedTotalInvestments = processedTotalInvestments.add(itaxDetails.getAmount());
				
			}
			else if(itaxDetails.getElementType().equals("O"))
			{
				processedTotalOtherEarnings = processedTotalOtherEarnings.add(itaxDetails.getAmount());
			}
		}
//		
		BigDecimal earningsForRemMonths = new BigDecimal(0.0);
		BigDecimal dedForRemmonths = new BigDecimal(0.0);
		
		
		
		BigDecimal monthlyTotalEarning = new BigDecimal(0.0);
		BigDecimal monthlyTotalDed = new BigDecimal(0.0);
		for(HrEmployeePayElements payElements:employeePayElements)
		{
			if(payElements.getPayAmount()!=null && payElements.getStatus().equals("y") && payElements.getPayElement().getTaxableElement().equals("y"))
			{
			if(payElements.getPayElement().getPayElementType().equals("Addition") || payElements.getPayElement().getPayElementType().equals("Reimb"))
			{
				monthlyTotalEarning = monthlyTotalEarning.add(payElements.getPayAmount());
			}
			if(payElements.getPayElement().getPayElementType().equals("Deduction"))
			{
				monthlyTotalDed = monthlyTotalDed.add(payElements.getPayAmount()); 
			}
			}
			
		}
		if(payStructure!=null)
		monthlyTotalEarning = monthlyTotalEarning.add(payStructure.getBasicPay());
		
		
		earningsForRemMonths = monthlyTotalEarning.multiply(new BigDecimal(unProcessedMonths.size()));
		dedForRemmonths = monthlyTotalDed.multiply(new BigDecimal(unProcessedMonths.size()));
		
		BigDecimal totalYearEarings = processedEarnings.add(earningsForRemMonths);
		BigDecimal totalYearDed     = processeddeductions.add(dedForRemmonths); 
		
		Map<String,Object> incometaxMap = new HashMap();
		incometaxMap.put("totalYearEarings", totalYearEarings);
		incometaxMap.put("totalYearDed", totalYearDed);
		incometaxMap.put("processedTotalInvestments", processedTotalInvestments);
		incometaxMap.put("processedTotalOtherEarnings", processedTotalOtherEarnings);
		incometaxMap.put("financialYear", finYr);
		incometaxMap.put("employee",employee);
		
		Map returnMap = IncomeTaxUtil.calculateIncomeTax(incometaxMap);
		
		BigDecimal taxableSalary = (BigDecimal)returnMap.get("taxableSalary");
		BigDecimal incomeTaxTotal = (BigDecimal)returnMap.get("taxOnTotalIncome");
		BigDecimal surcharge = (BigDecimal)returnMap.get("surcharge");
		BigDecimal eduCess   = (BigDecimal)returnMap.get("eduCess");
		
		//saving calculated incometax  
		HrItaxCalculate itaxCalculate = null;
		
 
		// if(employee.getItaxCalculate().size()==1)
		// {
		//		List<HrItaxCalculate> list  = new ArrayList<HrItaxCalculate>(employee.getItaxCalculate());
		//		itaxCalculate = list.get(0);
		// }
		// else
		// {
			 	itaxCalculate = new HrItaxCalculate();
		// }	
		
		itaxCalculate.setEmployee(employee);
		itaxCalculate.setFinYear(finYr);
		itaxCalculate.setTotalTax((incomeTaxTotal.add(surcharge).add(eduCess)).divide(new BigDecimal(1.00)));
		itaxCalculate.setMonthlyItax(new BigDecimal(incomeTaxTotal.intValue()/12));
		itaxCalculate.setTotalDeduction(totalYearDed.add(processedTotalInvestments));
		itaxCalculate.setTotalEarning(totalYearEarings.add(processedTotalOtherEarnings));
		incomeTaxMasHandlerService.saveObject(itaxCalculate);
		
		ItaxDetailsYearly itaxDetailsYearly = new ItaxDetailsYearly();
		JRBeanCollectionDataSource deductionsDataSource = new JRBeanCollectionDataSource(deductionsList);
		JRBeanCollectionDataSource earningdataSource = new JRBeanCollectionDataSource(earningsList);
		itaxDetailsYearly.setDeductionsDataSource(deductionsDataSource);
		itaxDetailsYearly.setEarningsDataSource(earningdataSource);
		itaxDetailsYearly.setEmployee(employee);
		itaxDetailsYearly.setFinancialYear(finYr);
		itaxDetailsYearly.setTaxableSalary(taxableSalary);
		itaxDetailsYearly.setTotalTax(incomeTaxTotal);
		itaxDetailsYearly.setSurcharge(surcharge);
		itaxDetailsYearly.setEduCess(eduCess);
		
		List<ItaxDetailsYearly> listForReport = new ArrayList<ItaxDetailsYearly>();
		listForReport.add(itaxDetailsYearly);
		
		BigDecimal alreadyPaidIT = new BigDecimal(0.0);
		for(HrItaxHeader itaxHeader : iTaxHeaderList)
		{
			if(itaxHeader.getItax()!=null)
			alreadyPaidIT = alreadyPaidIT.add(itaxHeader.getItax());
		}
		BigDecimal remainingTax = itaxCalculate.getTotalTax().subtract(alreadyPaidIT);
		BigDecimal monthlyIT = new BigDecimal(remainingTax.intValue()/unProcessedMonths.size());
		iTaxHeader.setItax(monthlyIT);
		incomeTaxMasHandlerService.saveObject(iTaxHeader);
		return monthlyIT;

	}
	
	/**
	 * @return the emptaxablePayElemntsList
	 */
	public static List<HrPayrollProcessDetail> getEmptaxablePayElemntsList() {
		return emptaxablePayElemntsList;
	}
	
	
	/**
	 * @return the employeeInvestmentList
	 */
	public static List<HrEmployeeInvestment> getEmployeeInvestmentList() {
		return employeeInvestmentList;
	}
	
	public static HrMasFinancialYear getCurrentFinancialYear(Integer year,Integer month,Integer date1)
	{
		Calendar c = Calendar.getInstance();
		c.set(year, month, date1);
		Date date = c.getTime();
		HrMasFinancialYear finYr = null;
		List<HrMasFinancialYear> finYrList = incomeTaxMasHandlerService.getFinancialYearList();
		for(HrMasFinancialYear fyr : finYrList)
		{
			if(date.after(fyr.getYearFromDate()) && date.before(fyr.getYearToDate()))
			{
				finYr = fyr;
			}
		}
		
		return finYr;
	}
}
