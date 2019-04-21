<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasLoan"%>
<%@page import="jkt.hrms.masters.business.HrLoanHeader"%>
<%@page import="jkt.hrms.masters.business.HrLoanDetail"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasGrade"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<script type="text/javascript" language="javascript"
	src="../jsp/js/proto.js"></script>
<%
			Map map = new HashMap();
			if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			}
			Map<String,Object> utilMap = new HashMap<String,Object>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			List<HrMasLoan> loanList = new ArrayList<HrMasLoan>();
			List<HrLoanHeader> loanHeaderList = new ArrayList<HrLoanHeader>();
			List<HrLoanDetail> loanDetailList = new ArrayList<HrLoanDetail>();
			List<HrLoanDetail> maxLoanDetailList = new ArrayList<HrLoanDetail>();
			List<MasGrade> gradeList = new ArrayList<MasGrade>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			if(map.get("employeeList")!= null){
				employeeList = (List)map.get("employeeList");
			}
			if(map.get("loanList")!= null){
				loanList = (List)map.get("loanList");
			}
			if(map.get("gradeList")!= null){
				gradeList = (List)map.get("gradeList");
			}
			if(map.get("departmentList")!= null){
				departmentList = (List)map.get("departmentList");
			}
			if(map.get("loanHeaderList")!= null){
				loanHeaderList = (List)map.get("loanHeaderList");
			}
			if(map.get("loanDetailList")!= null){
				loanDetailList = (List)map.get("loanDetailList");
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
			if(map.get("message") != null){
			String message = (String)map.get("message");
			%>
			<h4><span><%=message %></span></h4>
			<%} %>
<script type="text/javascript">	
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}			
	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'	
	function checkInstallmentAmt(){
	  var installAmt = document.loanDetail.<%= INSTALLMENT_AMOUNT%>.value;
	  var balanceLoan = document.loanDetail.<%= BALANCE_LOAN%>.value;
	  
	  if(parseFloat(installAmt) >parseFloat(balanceLoan)){
	  alert("Balance Loan is greater than equal to installment Amount")
	  
	   return false;
	 }else if(parseFloat(installAmt) == parseFloat(balanceLoan)){
	
		 return true;
	 
	 }
	   return true;
	 
	}
	function checkBalanceLoan(){
	  var installAmt = document.loanDetail.<%= INSTALLMENT_AMOUNT%>.value;
	  var balanceLoan = document.loanDetail.<%= BALANCE_LOAN%>.value;
	  var compAmount = document.loanDetail.<%= COMPOUND_AMOUNT%>.value;
	  var totalBalanceLoan = parseFloat(installAmt)+ parseFloat(balanceLoan);
	  if(parseFloat(totalBalanceLoan) >parseFloat(compAmount)){
	   alert(" Loan Compound amount is greater than equal to Balance Loan plus Installment Amount")
	   document.loanDetail.<%= INSTALLMENT_AMOUNT%>.value = "";
	   return false;
	 }else if(parseFloat(totalBalanceLoan) == parseFloat(compAmount)){
	
		 return true;
	 
	 }else{
	   return true;
	   }
	 
	}
   
   function resetUpdatedValue(){
  			document.getElementById('empId').disabled = false;
 		}
   
</script>

<div class="titleBg">
<h2>Loan Details</h2>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


<script type="text/javascript">

formFields = [
[0, "<%= COMMON_ID%>", "id"], [1,"<%=LOAN_HEADER_ID%>"], [2,"<%= INSTALLMENT_DATE %>"],[3,"<%=INSTALLMENT_AMOUNT%>"],[4,"<%= INTEREST_PAID%>"],[5,"<%= PRINCIPAL_PAID%>"],[6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=STATUS%>"],
[10,"<%=BALANCE_LOAN%>"],[11,"<%=EMPLOYEE_CODE%>"],[12,"<%=REMARK%>"],[13,"<%=GRADE_NAME%>"],[14,"<%=SEQUENCE_ID%>"],
[15,"<%=DEPARTMENT_NAME%>"],[16,"<%=JOIN_DATE%>"],[17,"<%=LOAN_CODE%>"],[18,"<%=LOAN_DESC%>"],[19,"<%=LOAN_P_AMOUNT%>"],[20,"<%=COMPOUND_AMOUNT%>"],[21,"hiddenEmp"]];
statusTd = 9;
</script></div>
<div class="clear"></div>
<div class="division"></div>

<form name="loanDetail" method="post" action="">
<h4>Employee Details</h4>
<div class="clear"></div>
<div class="Block">
<input type="hidden" name="hiddenEmp" id=hiddenEmp " value="" /> 
<label><span>*</span> Employee</label> 
<select id="empId" name="<%=LOAN_HEADER_ID %>" validate="Employee,string,yes" onchange="submitProtoAjax('loanDetail','loan?method=getLoanDetailFromAjax');">
<option value="0">Select</option>
<%
for(HrLoanHeader hrLoanHeader :loanHeaderList){
%>
<option value="<%=hrLoanHeader.getId() %>"><%=hrLoanHeader.getEmployee().getFirstName().trim()+" "+hrLoanHeader.getEmployee().getLastName().trim()+"-"+hrLoanHeader.getEmployee().getEmployeeCode().trim()%></option>
<%}%>
</select>
<div id="testDiv">

<input type="hidden" id="loanPeriodId"	name="<%=LOAN_PERIOD%>" value="" /> 
<label id=biglabel>Emp.Code</label>
<input type="text" name="<%= EMPLOYEE_CODE %>" class="readOnly"	readonly="readonly" value="" validate="Employee Code,string,yes" MAXLENGTH="45" tabindex=1 /> 
<label>Grade</label> 
<input type="text" name="<%=GRADE_NAME%>" class="readOnly" readonly="readonly" value="" validate="Grade,string,no" MAXLENGTH="40" tabindex=1 />
<div class="clear"></div>
<label>Seq.Id</label> 
<input type="text" name="<%= SEQUENCE_ID%>"	value="" class="readOnly" readonly="readonly" validate="SeqId,int,yes"	MAXLENGTH="40" tabindex=1 /> <label>Department</label> <input	type="text" name="<%= DEPARTMENT_NAME%>" value="" class="readOnly"
	readonly="readonly" validate="Deaprtment Name,string,yes"
	MAXLENGTH="40" tabindex=1 /> <label>Join Date</label> <input
	type="text" id="joinDateId" name="<%=JOIN_DATE %>" value=""
	class="date" class="readOnly" readonly="readonly"
	validate="Join date ,date,yes" MAXLENGTH="30" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<label id=biglabel><span>*</span> Loan Code</label> 
<input type="text" id="loanCodeId" class="readOnly"	readonly="readonly" name="<%= LOAN_CODE%>" value=""	validate="Loan Desc.,string,yes" MAXLENGTH="40" tabindex=1 /> 
<label><span>*</span> Loan Desc.</label> 
<input type="text" id="loanDescId" class="readOnly" readonly="readonly" name="<%= LOAN_DESC%>" value="" validate="Loan Desc.,string,yes" MAXLENGTH="40" tabindex=1 /> 
<label><span>*</span> Loan Amount</label> 
<input type="text" name="<%= LOAN_P_AMOUNT%>" class="readOnly" readonly="readonly" id="loanPAmountId" value="" validate="Loan Amount,float,yes" MAXLENGTH="7" tabindex=1 />
<div class="clear"></div>
<label><span>*</span> Comp.Amount</label> 
<input type="text"	name="<%= COMPOUND_AMOUNT%>" class="readOnly" readonly="readonly"	id="loanCAmountId" value="" validate="Loan Comp Amount,float,yes"	MAXLENGTH="16" tabindex=1 /> 
<label><span>*</span> Install.Date</label>
<input type="text" name="<%=INSTALLMENT_DATE %>" value="<%=date%> "	class="date" readonly="readonly" validate="Installment date ,date,yes"	MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.loanDetail.<%=INSTALLMENT_DATE%>,event)" />
<label><span>*</span> Install.Amount</label> 
<input type="text"	name="<%= INSTALLMENT_AMOUNT%>" id="installmentId" value=""	validate="Installment Amount,Float,yes" MAXLENGTH="13" tabindex=1 />
<div class="clear"></div>
<label><span>*</span> Interest Paid</label> 
<input type="text"	name="<%= INTEREST_PAID%>" class="readOnly" readonly="readonly"	value="" validate="Interest Paid,string,yes" MAXLENGTH="13" tabindex=1 />
<label><span>*</span> Prin.Paid</label> 
<input type="text"	name="<%=PRINCIPAL_PAID%>" class="readOnly" readonly="readonly"	value="" validate="Prin.Paid,Float,yes" MAXLENGTH="13" tabindex=1 /> <label><span>*</span> Balance Loan</label> 
<input type="text" name="<%= BALANCE_LOAN%>" class="readOnly" readonly="readonly" id="balanceLoanId" value="" validate="Balance Loan,Float,yes" MAXLENGTH="15" tabindex=1 />
<div class="clear"></div>
<label><span>*</span> Remarks</label> 
<input type="text"	name="<%= REMARK%>" value="" validate="Remark,string,yes"	MAXLENGTH="40" tabindex=1 />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button"	onClick="submitForm('loanDetail','loan?method=saveLoanDetail','checkInstallmentAmt');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit"	id="editbutton" value="Update" class="button" style="display: none;"	onClick="submitForm('loanDetail','loan?method=editLoanDetail','checkInstallmentAmt');"	accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button"	style="display: none;"	onClick="submitForm('payroll','payrollMasters?method=deletePayroll&flag='+this.value)" accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();resetUpdatedValue();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label> 
<label class="value"><%=userName%></label>
<label>Changed Date</label> 
<label class="value"><%=date%></label> 
<label>Changed Time</label> 
<label class="value"><%=time%></label> <input type="hidden"	name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
<input type="hidden" name="<%=STATUS %>" value="" /> 
<input	type="hidden" name="<%= COMMON_ID%>" value="" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Employee"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= LOAN_HEADER_ID%>"

data_header[1] = new Array;
data_header[1][0] = "Install.Date"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= INSTALLMENT_DATE %>";

data_header[2] = new Array;
data_header[2][0] = "Install.Amount"
data_header[2][1] = "data";
data_header[2][2] = "10%"
data_header[2][3] = "<%= INSTALLMENT_AMOUNT %>"

data_header[3] = new Array;
data_header[3][0] = "Interest Paid"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%= INTEREST_PAID %>"

data_header[4] = new Array;
data_header[4][0] = "Prin.Paid"
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= PRINCIPAL_PAID %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_BY %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%= CHANGED_DATE %>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%= CHANGED_TIME %>";

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = "15%";
data_header[8][3] = "<%=STATUS %>";

data_header[9] = new Array;
data_header[9][0] = "Balance Loan"
data_header[9][1] = "data";
data_header[9][2] = "15%";
data_header[9][3] = "<%=BALANCE_LOAN %>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = "15%";
data_header[10][3] = "<%=EMPLOYEE_CODE %>";

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = "15%";
data_header[11][3] = "<%=REMARK %>";

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = "15%";
data_header[12][3] = "<%=GRADE_NAME %>";

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = "15%";
data_header[13][3] = "<%=SEQUENCE_ID %>";

data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = "15%";
data_header[14][3] = "<%=DEPARTMENT_NAME %>";

data_header[15] = new Array;
data_header[15][0] = ""
data_header[15][1] = "hide";
data_header[15][2] = "15%";
data_header[15][3] = "<%=JOIN_DATE %>";

data_header[16] = new Array;
data_header[16][0] = ""
data_header[16][1] = "hide";
data_header[16][2] = "15%";
data_header[16][3] = "<%=LOAN_CODE %>";

data_header[17] = new Array;
data_header[17][0] = ""
data_header[17][1] = "hide";
data_header[17][2] = "15%";
data_header[17][3] = "<%=LOAN_DESC %>";

data_header[18] = new Array;
data_header[18][0] = ""
data_header[18][1] = "hide";
data_header[18][2] = "15%";
data_header[18][3] = "<%=LOAN_P_AMOUNT %>";

data_header[19] = new Array;
data_header[19][0] = ""
data_header[19][1] = "hide";
data_header[19][2] = "15%";
data_header[19][3] = "<%=COMPOUND_AMOUNT %>";

data_header[20] = new Array;
data_header[20][0] = ""
data_header[20][1] = "hide";
data_header[20][2] = "15%";
data_header[20][3] = "hiddenEmp";


data_arr = new Array();

<%

Iterator itr=loanDetailList.iterator();
int  counter=0;
while(itr.hasNext())
{


HrLoanDetail hrLoanDetail= (HrLoanDetail)itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrLoanDetail.getId()%>
<%
	for(HrLoanHeader hrLoanHeader : loanHeaderList){
		if(hrLoanHeader.getId().equals(hrLoanDetail.getLoanHeader().getId())){
			for(MasEmployee masEmployee : employeeList){
				if(hrLoanHeader.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][1] = "<%=masEmployee.getFirstName()+" "+masEmployee.getLastName()+"-"+masEmployee.getEmployeeCode()%>"

<%
				}
			}
	}
 }
%>

data_arr[<%= counter%>][2] = "<%= HMSUtil.convertDateToStringWithoutTime(hrLoanDetail.getInstallDate())%>"
data_arr[<%= counter%>][3] = "<%= hrLoanDetail.getInstallAmount()%>"
data_arr[<%= counter%>][4] = "<%= hrLoanDetail.getInterestPaid()%>"
data_arr[<%= counter%>][5] = "<%= hrLoanDetail.getPPaid()%>"
data_arr[<%= counter%>][6] = "<%= hrLoanDetail.getLastChgBy() %>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(hrLoanDetail.getLastChgDate()) %>"
data_arr[<%= counter%>][8] = "<%= hrLoanDetail.getLastChgTime() %>"



<% 

if(hrLoanDetail.getStatus().equals("y")){ %>
data_arr[<%= counter%>][9] = "Active"
<%}else{%>
data_arr[<%= counter%>][9] = "InActive"
<%}%>

data_arr[<%= counter%>][10] = "<%= hrLoanDetail.getBalanceLoan() %>"
<%
	for(HrLoanHeader hrLoanHeader:loanHeaderList){
		if(hrLoanHeader.getId()==hrLoanDetail.getLoanHeader().getId() ){
		for(MasEmployee masEmployee : employeeList){
			if(hrLoanHeader.getEmployee().getId() == masEmployee.getId()){
%>
data_arr[<%= counter%>][11] = "<%= masEmployee.getEmployeeCode()%>"

<%}
			}
 }
	}
%>
data_arr[<%= counter%>][12] = "<%= hrLoanDetail.getRemark() %>"

<%
	for(HrLoanHeader hrLoanHeader:loanHeaderList){
		if(hrLoanHeader.getId().equals(hrLoanDetail.getLoanHeader().getId()) ){
		for(MasEmployee masEmployee : employeeList){
			if(hrLoanHeader.getEmployee().getId().equals(masEmployee.getId())){
				for(MasGrade masGrade :gradeList){
					if(masEmployee.getGrade() != null){
						if(masEmployee.getGrade().getId().equals(masGrade.getId())){
				
%>
data_arr[<%= counter%>][13] = "<%= masGrade.getGradeName().trim() %>"
<%}
					}
}
 }
	}
		}
	}
%>

<%
	for(HrLoanHeader hrLoanHeader:loanHeaderList){
		if(hrLoanHeader.getId().equals(hrLoanDetail.getLoanHeader().getId()) ){
		for(MasEmployee masEmployee : employeeList){
			if(hrLoanHeader.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][14] = "<%= masEmployee.getId()%>"
<%}
}
 }
	}
%>
<%
	for(HrLoanHeader hrLoanHeader:loanHeaderList){
		if(hrLoanHeader.getId().equals(hrLoanDetail.getLoanHeader().getId()) ){
		for(MasEmployee masEmployee : employeeList){
			if(hrLoanHeader.getEmployee().getId().equals(masEmployee.getId())){
				for(MasDepartment masDepartment :departmentList){
					if(masEmployee.getDepartment().getId().equals(masDepartment.getId())){
				
%>
data_arr[<%= counter%>][15] = "<%= masDepartment.getDepartmentName().trim() %>"
<%}
}
 }
	}
		}
	}
%>

<%
	for(HrLoanHeader hrLoanHeader:loanHeaderList){
		if(hrLoanHeader.getId().equals(hrLoanDetail.getLoanHeader().getId()) ){
		for(MasEmployee masEmployee : employeeList){
			if(hrLoanHeader.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][16] = "<%=HMSUtil.convertDateToStringWithoutTime(masEmployee.getJoinDate())%>"
<%}
}
 }
	}
%>
<%
	for(HrLoanHeader hrLoanHeader:loanHeaderList){
		if(hrLoanHeader.getId().equals(hrLoanDetail.getLoanHeader().getId()) ){
		for(HrMasLoan hrMasLoan :loanList){
			if(hrLoanHeader.getLoan().getId().equals(hrMasLoan.getId())){
%>
data_arr[<%= counter%>][17] = "<%= hrMasLoan.getLoanCode()%>"
<%}
}
 }
	}
%>
<%
	for(HrLoanHeader hrLoanHeader:loanHeaderList){
		if(hrLoanHeader.getId().equals(hrLoanDetail.getLoanHeader().getId()) ){
		for(HrMasLoan hrMasLoan :loanList){
			if(hrLoanHeader.getLoan().getId().equals(hrMasLoan.getId())){
%>
data_arr[<%= counter%>][18] = "<%= hrMasLoan.getLoanDescription()%>"
<%}
}
 }
	}
%>
<%
	for(HrLoanHeader hrLoanHeader:loanHeaderList){
		if(hrLoanHeader.getId().equals(hrLoanDetail.getLoanHeader().getId()) ){
		
%>
data_arr[<%= counter%>][19] = "<%= hrLoanHeader.getLoanPAmount()%>"
<%}
}
 
%>

<%
	for(HrLoanHeader hrLoanHeader:loanHeaderList){
		if(hrLoanHeader.getId().equals(hrLoanDetail.getLoanHeader().getId()) ){
		
%>
data_arr[<%= counter%>][20] = "<%= hrLoanHeader.getLoanCAmount()%>"
<%}
}
 
%>
<%
	for(HrLoanHeader hrLoanHeader : loanHeaderList){
		if(hrLoanHeader.getId().equals(hrLoanDetail.getLoanHeader().getId())){
			//for(MasEmployee masEmployee : employeeList){
				//if(hrLoanHeader.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][21] = "<%=hrLoanHeader.getId()%>"

<%
				//}
			//}
	}
 }
%>

<%
counter++;
}
%>


formName = "loanDetail"


start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	
	

</script>
