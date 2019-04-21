<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hrms.masters.business.HrAdvance"%>
<%@page import="jkt.hrms.masters.business.HrAdvanceDetail"%>

<%
			Map map = new HashMap();
			if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			}
			Map<String,Object> utilMap = new HashMap<String,Object>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			List<HrAdvance> advanceList = new ArrayList<HrAdvance>();
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			List<HrAdvanceDetail> advanceDetailList = new ArrayList<HrAdvanceDetail>();
			if(map.get("hospitalList")!= null){
				hospitalList = (List)map.get("hospitalList");
			}
			if(map.get("employeeList")!= null){
				employeeList = (List)map.get("employeeList");
			}
			if(map.get("advanceList")!= null){
				advanceList = (List)map.get("advanceList");
			}
			if(map.get("advanceDetailList")!= null){
				advanceDetailList = (List)map.get("advanceDetailList");
			}
			
			int hospitalId = 0;
			if(hospitalList.size()>0){
				MasHospital masHospital = hospitalList.get(0);
				hospitalId = masHospital.getId();
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
			out.println(message);
			}
%>







<script type="text/javascript">
	function checkRecoveredAmount(){
	  var recDetailAmt = document.advanceDetail.<%= RECOVERED_AMOUNT_DETAIL%>.value;
	  var advanceAmt;
	  var recHeaderAmt;
	  var remainRecAmount;
	  if(recHeaderAmt != "0"){
	  <%
	  		for(HrAdvance hrAdvance : advanceList){
	  %>
	   advanceAmt = '<%=hrAdvance.getAdvanceAmount()%>'
	  	recHeaderAmt = '<%=hrAdvance.getRecoveredAmount()%>'
	  	remainRecAmount = advanceAmt - recHeaderAmt;
	  	if(parseFloat(recDetailAmt) > advanceAmt ){
		  alert("Recovered Amount should not be greater than Advance amount")
		  document.advanceDetail.<%= RECOVERED_AMOUNT_DETAIL%>.value = "";
	   		return false;
	 }else if(parseFloat(recDetailAmt) > remainRecAmount){
		 alert("Recovered Amount should not be greater than Remaining Advance Amount")
		  document.advanceDetail.<%= RECOVERED_AMOUNT_DETAIL%>.value = "";
	   		return false;
	 
	 }else if(remainRecAmount == recDetailAmt){
		 return true;
	 }
	   return true;
	   <%
	  		}
	  	%>
	  }
	 
	}


function displayValues(idvalue) {
	<%
	for(HrAdvance hrAdvance :advanceList){
		int id = hrAdvance.getId();

	%>
	if(idvalue == <%=id%> ){
    document.getElementById('empCodeId').value = '<%= hrAdvance.getEmployee().getEmployeeCode()%>'
	document.getElementById('advanceDateId').value = '<%=HMSUtil.convertDateToStringWithoutTime(hrAdvance.getAdvanceDate())%>'
	
	}
<%
	}
	
%>	

}
	function checkRecoveredDate(){
		var aDate = document.advanceDetail.<%= ADVANCE_DATE%>.value;
		var rDate = document.advanceDetail.<%= RECOVERY_DATE %>.value;
	
		var	advanceDate =new Date(aDate.substring(6),(aDate.substring(3,5) - 1) ,aDate.substring(0,2))
		var recoveryDate =new Date(rDate.substring(6),(rDate.substring(3,5) - 1) ,rDate.substring(0,2))
		if(recoveryDate < advanceDate)
		{
			alert("Recovery Date should not be less than Advance Date.");
			document.advanceDetail.<%= RECOVERY_DATE %>.value = "";
			return false;
		}
		return true;
	}

	
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
</script>
<div class="titleBg">
<h2>Advance Detail</h2>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<script type="text/javascript">

formFields = [
[0, "<%= COMMON_ID%>", "id"], [1,"<%=ADVANCE_ID%>"], [2,"<%= EMPLOYEE_CODE %>"],[3,"<%=ADVANCE_DATE%>"],[4,"<%= RECOVERED_AMOUNT_DETAIL%>"],[5,"<%= RECOVERY_DATE%>"],[6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=REMARK%>"],[10,"<%=STATUS%>"]];
statusTd = 10;
</script></div>
<div class="clear"></div>
<div class="division"></div>
<form name="advanceDetail" method="post" action="">
<div class="Block">
<input type="hidden" id="advanceAmountId"	name="<%=ADVANCE_AMOUNT%>" value="" /> 
<input type="hidden"	id="recHeaderAmountId" name="<%=RECOVERED_AMOUNT_HEADER%>" value="" />
<label><span>*</span> Employee Name</label> <select
	name="<%=ADVANCE_ID %>" validate="Employee,string,yes"
	onchange="displayValues(this.value);">
	<option value="0">Select</option>
	<%
	for(HrAdvance hrAdvance : advanceList){
%>
	<option value="<%=hrAdvance.getId() %>"><%=hrAdvance.getEmployee().getFirstName().trim()+" "+hrAdvance.getEmployee().getLastName().trim()+"-"+hrAdvance.getEmployee().getEmployeeCode().trim()%></option>
	<%
	}
%>
</select> <label id=biglabel><span>*</span> Employee Code</label> <input
	name="<%=EMPLOYEE_CODE%>" id="empCodeId" class="readOnly"
	readonly="readonly" type="text" /> <label><span>*</span>Advance
Date</label> <input type="text" id="advanceDateId" name="<%=ADVANCE_DATE %>"
	value="" class="readOnly" readonly="readonly"
	validate="Advance date ,date,yes" MAXLENGTH="30" />


<div class="clear"></div>
<label><span>*</span> Recovered Amount</label> 
<input type="text"	name="<%= RECOVERED_AMOUNT_DETAIL%>" value="" validate="Recovered Amount,Float,yes" MAXLENGTH="9" tabindex=1 /> 
<label><span>*</span> Recovery Date</label>
	<input type="text"  name="<%=RECOVERY_DATE %>" value="" class="date" readonly="readonly" validate="Recovery date ,date,yes"  MAXLENGTH="30" />
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.advanceDetail.<%=RECOVERY_DATE%>,event)"/>
	<label><span>*</span> Remarks</label>
	<input  type="text" name="<%= REMARK%>" value="" validate="Remark,string,yes" MAXLENGTH="40" tabindex=1 />
	<div class="clear"></div></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button"	onClick="submitForm('advanceDetail','loan?method=saveAdvanceDetail','checkRecoveredAmount','checkRecoveredDate');"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('advanceDetail','loan?method=updateAdvanceDetail','checkFromDate','checkPaidDate','checkRecoveredDate','checkRecoveredAmount')" accesskey="u" tabindex=1 /> 
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('reimbDetail','payrollMasters?method=deletePayroll&flag='+this.value)" accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" /> 
<input type="hidden" name="<%=STATUS %>" value="" /> 
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

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
data_header[0][3] = "<%= ADVANCE_ID %>";

data_header[1] = new Array;
data_header[1][0] = "Emp.Code"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= EMPLOYEE_CODE %>";

data_header[2] = new Array;
data_header[2][0] = "Advance Date"
data_header[2][1] = "data";
data_header[2][2] = "10%"
data_header[2][3] = "<%=ADVANCE_DATE%>";

data_header[3] = new Array;
data_header[3][0] = "Recovered Amount"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%= RECOVERED_AMOUNT_DETAIL %>";

data_header[4] = new Array;
data_header[4][0] = "Recovery date"
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= RECOVERY_DATE %>";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_BY %>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%= CHANGED_DATE %>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%= CHANGED_TIME %>";

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = "15%";
data_header[8][3] = "<%=REMARK %>";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = "15%";
data_header[9][3] = "<%=STATUS%>";

data_arr = new Array();

<%


Iterator itr=advanceDetailList.iterator();
int  counter=0;
while(itr.hasNext())
{


	HrAdvanceDetail  hrAdvanceDetail= (HrAdvanceDetail)itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrAdvanceDetail.getId()%>
<%
		for(HrAdvance hrAdvance :advanceList){
		if(hrAdvance.getId().equals(hrAdvanceDetail.getAdvance().getId())){			
			for(MasEmployee masEmployee : employeeList){
				if(hrAdvance.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][1] = "<%=masEmployee.getFirstName().trim()+" "+masEmployee.getLastName().trim()+"-"+masEmployee.getEmployeeCode().trim()%>";
<%
			}
		}
	}
 }
		
%>
<%
			for(HrAdvance hrAdvance :advanceList){
			if(hrAdvance.getId().equals(hrAdvanceDetail.getAdvance().getId())){				
			for(MasEmployee masEmployee : employeeList){
				if(hrAdvance.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][2] = "<%=masEmployee.getEmployeeCode()%>";
<%
		}
	  }
	}
  }
		
%>
<%
		for(HrAdvance hrAdvance :advanceList){
			if(hrAdvance.getId().equals(hrAdvanceDetail.getAdvance().getId())){
		
%>

data_arr[<%= counter%>][3] = "<%=HMSUtil.convertDateToStringWithoutTime(hrAdvance.getAdvanceDate())%>";
<%
		}
	}
%>
data_arr[<%= counter%>][4] = "<%=hrAdvanceDetail.getRecoveredAmount()%>";
data_arr[<%= counter%>][5] = "<%=HMSUtil.convertDateToStringWithoutTime(hrAdvanceDetail.getRecoveryDate())%>"
data_arr[<%= counter%>][6] = "<%= hrAdvanceDetail.getLastChgBy() %>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(hrAdvanceDetail.getLastChgDate()) %>"
data_arr[<%= counter%>][8] = "<%= hrAdvanceDetail.getLastChgTime() %>"
data_arr[<%= counter%>][9] = "<%=hrAdvanceDetail.getRemark() %>"
<% 

if(hrAdvanceDetail.getStatus().equals("y")){ %>
data_arr[<%= counter%>][10] = "Active"
<%}else{%>
data_arr[<%= counter%>][10] = "InActive"
<%}%>
<%

counter++;
}
%>


formName = "advanceDetail"

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	
	

</script>
