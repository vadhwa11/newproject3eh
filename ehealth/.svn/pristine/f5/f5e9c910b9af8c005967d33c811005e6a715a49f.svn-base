
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="jkt.hrms.masters.business.*"%>
<%@ page import="jkt.hms.masters.business.*"%>
<%@ page import="jkt.hms.util.*"%>

<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
	
	
</script>
<%	
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
	}

	Map<String,Object> mapEmployee = new HashMap<String,Object>();
	
	if(request.getAttribute("map") != null){
	mapEmployee = (Map<String,Object>) request.getAttribute("map");
	}
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>(); 
	if(mapEmployee.get("employeeList") != null){
		employeeList = (List)mapEmployee.get("employeeList");
	}
	
	List<HrMasPayElement> payElementsList = new ArrayList<HrMasPayElement>();
	if(mapEmployee.get("payElementsList") != null){
		payElementsList = (List)mapEmployee.get("payElementsList");
	}
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	String message="";
	if(mapEmployee.get("message") != null){
		message = (String)mapEmployee.get("message");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
%>
<h4><span><%=message%></span></h4>
<div class="titleBg">
<h2>Employee Pay Elements</h2>
</div>


<div class="clear"></div>

<form name="addEmployeePayElements" method="post" action="">

<div class="clear"></div>
<div class="Block" id="title1">
<label><span>* </span>Employee Code</label> 
<select name="<%=EMPLOYEE_ID %>" id="<%=EMPLOYEE_ID %>" validate="Employee Code,string,yes" >
	<option value="">Select</option>
	<% for(MasEmployee employee : employeeList){%>

	<option value="<%=employee.getId() %>"><%=employee.getFirstName()+" "+employee.getLastName()+ " - "+ employee.getEmployeeCode()%>
	</option>
	<%} %>
	
</select> 

<div class="clear"></div>
<table class="small">
<tr>
<th>Select</th>
<th>PayElement</th>
<th>Amount</th>
<th>PayElement Type</th>
<th>Status Date</th>


</tr>
<%
int i = 0;
if(payElementsList.size()>0){ 
	for(HrMasPayElement payElement :payElementsList){



%>
	
<tr>

<td><input type="checkbox" name="payElementId<%=i%>" value="<%= payElement.getId()%>"></td>
<td><%=payElement.getPayElementDesc() %></td>
<td><input type="text" name="payElementAmount<%=i%>" value=""></td>
<td><input type="text" name="payElementType<%=i%>" value="<%=payElement.getPayElementType() %>"></td>
<td> <input type="text" name="<%=PAY_ELEMENT_START_DATE %><%=i%>" class="date" validate="Start Date,date,no" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onClick="javascript:setdate('',document.addEmployeePayElements.<%=PAY_ELEMENT_START_DATE%><%=i%>,'event')" validate="Pick a date" class="calender" /></td>
</tr>

<%
i++;
	}} %>

</table>

<input type="hidden" id="countId" name="counter" value="<%=i%>">

<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label> 
<label class="value"><%=userName%></label>

<label>Changed Date</label>
 <label class="value"><%=date%></label> 
 <label>Changed Time</label> 
 <label class="value"><%=time%></label>
  
 <input type="hidden"  name="<%=CHANGED_BY%>"  value="<%=userName%>" />
  <input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
  <input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> 

  <div class="clear"></div>
  </div>
  <input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
 <input type="hidden" name="<%= HOSPITAL_ID%>" value="" />
    <div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('addEmployeePayElements','personnel?method=addMultipleEmployeePayElement');" accesskey="a" /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="location.reload();" accesskey="r" />
    <div class="clear"></div>
<div class="paddingTop40"></div>
    <div class="clear"></div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


<script type="text/javascript">


function populateEmployeeBasicPay(obj)
{
		selectedEmployeeId = obj.value;
	
	<%MasEmployee selectedEmployee = null;
	  for(MasEmployee employee :employeeList){%>
		if(<%=employee.getId()%> == selectedEmployeeId)
		{
		<%
	    Set payStructureSet = null;
		if(employee!=null){
		 payStructureSet = employee.getPayStructure();
		}
		List payStructureList =null;
		HrEmployeePayStructure employeePayStructure = null;
		Float basicPay = 0.0f;
		if(payStructureSet!=null)
		{
			payStructureList = new ArrayList(payStructureSet);
		}
		if(payStructureList!=null && !payStructureList.isEmpty())
		{
		 employeePayStructure =(HrEmployeePayStructure) payStructureList.get(0);
		 
		 if(employeePayStructure !=null)
		 	basicPay = employeePayStructure.getBasicPay().floatValue();
		}%>		
		basicPayValue = '<%=basicPay%>';
		
		}	
	<%}%>
	
	document.employeePayElements.<%=PAY_ELEMENT_CODE%>.value = '';
	document.employeePayElements.<%=PAY_ELEMENT_TYPE%>.value= '';
	document.employeePayElements.<%=PAY_AMOUNT%>.value = '';
	//document.employeePayElements.<%=PAY_AMOUNT%>.setAttribute("class","");
	//document.employeePayElements.<%=PAY_AMOUNT%>.setAttribute("readonly","");
	//document.getElementById('basicDependantDiv').innerHTML = '';
	//document.getElementById('basicDependantDiv').style.display  = 'none';
}


function populateElementType(obj)
{
		payElementId = obj.value;
		<%for(HrMasPayElement payElement : payElementsList){ %>
		
		if(<%=payElement.getId()%> == payElementId){
		document.employeePayElements.<%=PAY_ELEMENT_TYPE%>.value = '<%=payElement.getPayElementType()%>';
		
		if("<%=payElement.getBasicDependent()%>" == "y")
		{
		
		document.employeePayElements.<%=PAY_AMOUNT%>.value = (parseFloat('<%=payElement.getBasicMultiplier()%>')* basicPayValue)/100;
		document.employeePayElements.<%=PAY_AMOUNT%>.value = formatNumber(document.employeePayElements.<%=PAY_AMOUNT%>.value ,0);
		//document.employeePayElements.<%=PAY_AMOUNT%>.setAttribute("class","readOnly");
		//document.employeePayElements.<%=PAY_AMOUNT%>.setAttribute("readonly","readonly");
		//document.getElementById('basicDependantDiv').innerHTML = 'Basic Dependant ('+<%=payElement.getBasicMultiplier()%> +'% of Basic)';
		//document.getElementById('basicDependantDiv').style.display = 'block';
		}
		else
		{
		document.employeePayElements.<%=PAY_AMOUNT%>.value = '';
		//document.employeePayElements.<%=PAY_AMOUNT%>.setAttribute("class","");
		//document.employeePayElements.<%=PAY_AMOUNT%>.setAttribute("readonly","");
		document.getElementById('basicDependantDiv').innerHTML = '';
		document.getElementById('basicDependantDiv').style.display  = 'none';
		}
		
		}
		<%}%>
		
}
function removeMandatory()
	{
	document.getElementById('<%=EMPLOYEE_ID%>').setAttribute('validate','Employee Name,string,no');
	return true;
	}

</script>

<script language="javascript">

function formatNumber(myNum, numOfDec)
{
var decimal = 1
for(i=1; i<=numOfDec;i++)
decimal = decimal *10

var myFormattedNum = (Math.round(myNum * decimal)/decimal).toFixed(numOfDec)
return(myFormattedNum)
}
</script>