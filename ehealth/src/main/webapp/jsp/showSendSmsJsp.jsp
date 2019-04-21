<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasDepartmentType"%>
<%@page import="jkt.hms.masters.business.MasCostCenter"%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

 <script	type="text/javascript" language="javascript">
<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date_to=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date_to.length()<2){
			date_to="0"+date_to;
		}
	%>
		serverdate = '<%=date_to+"/"+month+"/"+year%>'
</script>
<script>function changeList(){
	 //alert("in function");
	// alert(document.messageCommunicationForm.selectedChrage);
			  if(document.sendSms.selectedChrage.checked)				 
				   {
				 //  alert("true");
			  		document.sendSms.<%=EMPLOYEE_ID%>.disabled = true;
			  }
			  else{
			   		document.sendSms.<%=EMPLOYEE_ID%>.disabled = false;
			  }
 }
</script>
<%

	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasEmpCategory> empCategoryList = new ArrayList<MasEmpCategory>();
	if(map.get("employeeList")!=null){
		employeeList= (ArrayList)map.get("employeeList");
	}
	if(map.get("empCategoryList")!=null){
		empCategoryList= (ArrayList)map.get("empCategoryList");
	}
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	String deptName = "";
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	if(map.get("message") != null){
		 String  message = (String)map.get("message");
%>
		   <h4><span><%=message %></span></h4>
		 <%} %>
<div class="titleBg">
<h2>Send SMS</h2>
<input type="hidden" name="deptName" id="deptName"	value="<%=deptName %>" />
<div class="clear"></div>
</div>
<form name="sendSms" method="post" action="">
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">

<label>Current Date</label>
<label class="value"><%=currentDate%></label>
<input type="hidden" value=<%=currentDate%> name="<%=ENTRY_DATE %>" id="entryDate"/>
<div class="clear"></div>
<div class="clear"></div>
<label><span>*</span>Employee Category</label>
<select	id="employeeId" name=<%=EMPLOYEE_CATEGORY_ID%> 
 tabindex="1" tabindex="1" 
onchange="submitProtoAjaxWithDivName('sendSms','ipd?method=showEmployee','birthDiv');" 
onblur="submitProtoAjaxWithDivName('sendSms','ipd?method=showEmployee','birthDiv');"
onkeyup="submitProtoAjaxWithDivName('sendSms','ipd?method=showEmployee','birthDiv');" >
		<option value="0">Select</option>

	<%
				         		if(empCategoryList != null){
				         			for (Iterator iter = empCategoryList.iterator(); iter.hasNext();) {
				         				MasEmpCategory masEmpCategory = (MasEmpCategory) iter.next();
				         %>
	<option value="<%=masEmpCategory.getId() %>"><%=masEmpCategory.getEmpCategoryName()%></option>
	<%
				        			}
				        		 }
				        %>
</select>

<div id="birthDiv">
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>

<label>Send All</label>
<input type="checkbox" name="selectedChrage" id="selectedChrage" value="y" onClick="changeList();"/> 
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
<label><span>*</span> SMS To</label>
<select	id="employeeId" name=<%=EMPLOYEE_ID%> multiple="multiple" size="16" class="list"   tabindex="1" tabindex="1" onchange="chkMobileNo(this.value)">
		<option value="0">Select</option>

	<%
				         		if(employeeList != null){
				         			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
				         				MasEmployee masEmployee = (MasEmployee) iter.next();
				         %>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName() +" "+masEmployee.getLastName()%></option>
	<%
				        			}
				        		 }
				        %>
</select>
</div>
<div class="clear"></div>
<label><span>*</span>Mobile No</label>
<input type="text" value="" name="<%=MOBILE_NO%>" id="mobilNo" />
<div class="clear"></div>
<label><span>*</span> Message</label>
<textarea name="<%=MESSAGE_FOR_WARD_JSP %>" value="" id="messageForWard" onkeyup="chkLength(this,699);"
	validate="message,string,yes" tabindex="1"></textarea>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" value="Submit"	onclick="submitForm('sendSms','ipd?method=submitSendSms');" />
<!-- 
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<input type="button" class="button" value="View" onclick="submitProtoAjaxForHandTakeOver('sendSms','ipd?method=viewHandTakeOver');" />
<input type="button" class="buttonBig" value="Generate Report" onclick="submitDetails()"/>
 -->
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>
<div class="clear"></div>
<div class="division"></div>
<div id="testDiv">
</div>
<script type="text/javascript">

function chkMobileNo(val)
{
//	`("--- val --- "+val);
	<%
		if(employeeList != null){%>
			//Salert("--- val --- "+val);<%
			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
				MasEmployee masEmployee = (MasEmployee) iter.next();
%>
	if(val==<%=masEmployee.getId()%>){
	//	alert("--- val --- "+val);
		document.getElementById("mobilNo").value="<%=masEmployee.getTelNoOffice()%>";
	}
<%
		}
	 }else{
%>
document.getElementById("mobilNo").value="";
<%
	 }
%>
}
function chkLength(field,maxLimit)
	{
	if(field.value.length > maxLimit)
	{
	 alert('Maximum Limit is '+maxLimit+' characters.');
	 var val=field.value.substring(0,maxLimit);
	 field.value=val;
	}
}
function submitProtoAjaxForHandTakeOver(formName,action){
	var toDate = document.getElementById("ToDateId").value;
  	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 var url=action+"&toDate="+toDate;
     	       	new Ajax.Updater('testDiv',url,
			   {asynchronous:true, evalScripts:true });
			return true;
 }
function submitDetails(){

	    document.sendSms.action="ipd?method=reportHandTakeOver";
        document.sendSms.submit();
}
</script>