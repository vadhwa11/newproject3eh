<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasLoan"%>
<%@page import="jkt.hrms.masters.business.HrLoanHeader"%>
<%@page import="jkt.hrms.masters.business.HrLoanDetail"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasGrade"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%
			Map map = new HashMap();
			if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			}
			Map<String,Object> utilMap = new HashMap<String,Object>();
			List<HrLoanHeader> loanHeaderList = new ArrayList<HrLoanHeader>();
			List<HrLoanDetail> loanDetailList = new ArrayList<HrLoanDetail>();
			List<HrLoanDetail> maxLoanDetailList = new ArrayList<HrLoanDetail>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			List<MasGrade> gradeList = new ArrayList<MasGrade>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			if(map.get("loanHeaderList")!= null){
				loanHeaderList = (List)map.get("loanHeaderList");
			}
			
			if(map.get("loanDetailList")!= null){
				loanDetailList = (List)map.get("loanDetailList");
			}
			if(map.get("employeeList")!= null){
				employeeList = (List)map.get("employeeList");
			}
			if(map.get("gradeList")!= null){
				gradeList = (List)map.get("gradeList");
			}
			if(map.get("departmentList")!= null){
				departmentList = (List)map.get("departmentList");
			}
			if(map.get("maxLoanDetailList")!= null){
				maxLoanDetailList = (List)map.get("maxLoanDetailList");
			}
			BigDecimal balanaceLoan1 = null;
			String refNo = "";
			if(maxLoanDetailList.size()>0){
				HrLoanDetail hrLoanDetail = (HrLoanDetail)maxLoanDetailList.get(0);
				balanaceLoan1 = hrLoanDetail.getBalanceLoan();
				//refNo = hrLoanDetail.getLoanHeader().getReferenceNo();
				
			}
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date = (String)utilMap.get("currentDate");	 
			String time = (String)utilMap.get("currentTime");
			
			String userName = "";
			if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
			}
			int loanPeriod = 0;
			BigDecimal loanCAmount = null;
			BigDecimal loanPAmount = null;
			BigDecimal installAmount  = null;
			BigDecimal monthInstall  = null;
			BigDecimal balanceLoan1  = null;
			BigDecimal balanceDetail = null;
			int principalPaid = 0;
			BigDecimal prinpaid = null;
			int interestPaid = 0;
			BigDecimal intPaid = null; 
			
			if(maxLoanDetailList.size()>0){
				for(HrLoanDetail hrLoanDetail :maxLoanDetailList){
					loanPeriod = hrLoanDetail.getLoanHeader().getLoanPeriod();
					loanCAmount = hrLoanDetail.getLoanHeader().getLoanCAmount();
					loanPAmount = hrLoanDetail.getLoanHeader().getLoanPAmount();
					installAmount = hrLoanDetail.getInstallAmount();
					balanaceLoan1 = hrLoanDetail.getBalanceLoan();
					  if(balanaceLoan1 != null){
						  balanceDetail = balanaceLoan1;
					  }else{
						  balanceDetail = loanCAmount;
					  }
				}
				
			}else{
				  balanceDetail = loanHeaderList.get(0).getLoanCAmount();
			  }
%>
<%
	for(HrLoanHeader hrLoanHeader :loanHeaderList){
		
		principalPaid = (hrLoanHeader.getLoanPAmount().intValue()/hrLoanHeader.getLoanPeriod());
		prinpaid = new BigDecimal(principalPaid);
		
		interestPaid = ((hrLoanHeader.getLoanCAmount().intValue()/hrLoanHeader.getLoanPeriod())-prinpaid.intValue());
		intPaid = new BigDecimal(interestPaid);
%>

<script type="text/javascript">
	function checkInstallmentAmt(){
		  var installAmt = document.loanDetail.<%= INSTALLMENT_AMOUNT%>.value;
		  var balanceLoan = document.loanDetail.<%= BALANCE_LOAN%>.value;
		  
		  if(balanceLoan < installAmt){
		  alert("Balance Loan is greater than equal to installment Amount")
		  
		   return false;
		 }else if(installAmt = balanceLoan){
		
			 return true;
		 
		 }
		   return true;
		 
		}
</script>
<div class="Block"><input type="hidden" id="loanPeriodId"
	name="<%=LOAN_PERIOD%>" value="<%=hrLoanHeader.getLoanPeriod()%>" /> <label
	id=biglabel> Emp.Code</label> <input type="text"
	name="<%= EMPLOYEE_CODE %>" class="readOnly" readonly="readonly"
	id="empCodeId"
	value="<%=hrLoanHeader.getEmployee().getEmployeeCode() %>"
	validate="Employee Code,string,yes" MAXLENGTH="45" tabindex=1 /> <label>Grade</label>
<%

		
		
		for(MasEmployee masEmployee : employeeList){
			if(hrLoanHeader.getEmployee().getId().equals(masEmployee.getId())){
				for(MasGrade masGrade :gradeList){
					if(masEmployee.getGrade() != null){
						if(masEmployee.getGrade().getId().equals(masGrade.getId())){
			
%> <input type="text" name="<%=GRADE_NAME%>" id="gradeId"
	class="readOnly" readonly="readonly"
	value="<%=masGrade.getGradeName().trim() %>" validate="Grade,string,no"
	MAXLENGTH="40" tabindex=1 /> <%}
					}
}
 }
	}
		
	
%>
<div class="clear"></div>
<label>Seq.Id</label> <input type="text" name="<%= SEQUENCE_ID%>"
	id="seqId" value="<%=hrLoanHeader.getEmployee().getId() %>"
	class="readOnly" readonly="readonly" validate="SeqId,int,yes"
	MAXLENGTH="40" tabindex=1 /> <label>Department</label> <input
	type="text" name="<%= DEPARTMENT_NAME%>" id="departmentId"
	value="<%=hrLoanHeader.getEmployee().getDepartment().getDepartmentName().trim() %>"
	class="readOnly" readonly="readonly"
	validate="Deaprtment Name,string,yes" MAXLENGTH="40" tabindex=1 /> <label>Join
Date</label> <input type="text" id="joinDateId" name="<%=JOIN_DATE %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(hrLoanHeader.getEmployee().getJoinDate()) %>"
	class="readOnly" readonly="readonly" validate="To date ,date,yes"
	MAXLENGTH="30" />
<div class="clear"></div>
</div>
<h4>Loan Details</h4>
<div class="clear"></div>
<div class="Block"><label id=biglabel><span>*</span> Loan
Code</label> <input type="text" id="loanCodeId" class="readOnly"
	readonly="readonly" name="<%= LOAN_CODE%>"
	value="<%=hrLoanHeader.getLoan().getLoanCode()%>"
	validate="Loan Desc.,string,yes" MAXLENGTH="40" tabindex=1 /> <label><span>*</span>
Loan Desc.</label> <input type="text" id="loanDescId" class="readOnly"
	readonly="readonly" name="<%= LOAN_DESC%>"
	value="<%=hrLoanHeader.getLoan().getLoanDescription()%>"
	validate="Loan Desc.,string,yes" MAXLENGTH="40" tabindex=1 /> <label><span>*</span>
Loan Amount</label> <input type="text" name="<%= LOAN_P_AMOUNT%>"
	class="readOnly" readonly="readonly" id="loanPAmountId"
	value="<%=hrLoanHeader.getLoanPAmount()%>"
	validate="Loan Amount,float,yes" MAXLENGTH="7" tabindex=1 />

<div class="clear"></div>
<label><span>*</span> Comp.Amount</label> <input type="text"
	name="<%= COMPOUND_AMOUNT%>" class="readOnly" readonly="readonly"
	id="loanCAmountId" value="<%=hrLoanHeader.getLoanCAmount()%>"
	validate="Loan Comp Amount,float,yes" MAXLENGTH="16" tabindex=1 /> <label><span>*</span>Install.Date</label>
<input type="text" name="<%=INSTALLMENT_DATE %>" value="<%=date%> "
	class="date" readonly="readonly" validate="Installment date ,date,yes"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date" class="calender"
	onclick="setdate('',document.loanDetail.<%=INSTALLMENT_DATE%>,event)" />
<label><span>*</span>Install.Amount</label> <input type="text"
	name="<%= INSTALLMENT_AMOUNT%>" id="installmentId"
	value="<%=hrLoanHeader.getMonthlyInstall()%>"
	validate="Installment Amount,Float,no" MAXLENGTH="13" tabindex=1 />
<div class="clear"></div>
<label><span>*</span>Interest Paid</label> <input type="text"
	name="<%= INTEREST_PAID%>" class="readOnly" readonly="readonly"
	value="<%=intPaid %>" validate="Interest Paid,string,no" MAXLENGTH="13"
	tabindex=1 /> <label><span>*</span>Prin.Paid</label> <input
	type="text" name="<%=PRINCIPAL_PAID%>" class="readOnly"
	readonly="readonly" value="<%=prinpaid %>"
	validate="Prin.Paid,Float,no" MAXLENGTH="13" tabindex=1 /> <label><span>*</span>Balance
Loan</label> <input type="text" name="<%= BALANCE_LOAN%>" class="readOnly"
	readonly="readonly" id="balanceLoanId" value="<%=balanceDetail %>"
	validate="Balance Loan,string,yes" MAXLENGTH="16" tabindex=1 />
<div class="clear"></div>
<label><span>*</span>Remarks</label> <input type="text"
	name="<%= REMARK%>" value="" validate="Remark,string,yes"
	MAXLENGTH="40" tabindex=1 />
<div class="clear"></div>
<%
	}
%>