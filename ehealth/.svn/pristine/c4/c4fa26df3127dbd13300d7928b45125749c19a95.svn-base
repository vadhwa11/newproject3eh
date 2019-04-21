<%--
	 * Copyright 2010 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : dietIndoorPatientJsp.jsp
	 * Tables Used         :
	 * Description         :
	 * @author  Create Date: 28.10.2010    Name: Ramdular
	 * Revision Date:      Revision By:
	 * @version 1.0
--%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.*"%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script src="/hms/jsp/js/calendar.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>


<script type="text/javascript" language="javascript">
	<%
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		String time=String.valueOf(calendar.getTime());
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}%>
		 serverdate = '<%=date+"/"+month+"/"+year%>'
		 
		function checkStartDate(){
		var toDate = document.patientEnquirySearch1.<%= TO_DATE %>.value;
		var cDate = new Date();
		var month = cDate.getMonth() + 1
		var day = cDate.getDate()
		var year = cDate.getFullYear()
		var seperator = "/"
		var currentDate  = new Date(month + seperator + day + seperator + year);
		var endDate =new Date(toDate.substring(6),(toDate.substring(3,5) - 1) ,toDate.substring(0,2))
		if(toDate=="")
		{
		 alert("Date should not be blank.");
		 return false;
		}
		return true;
	}
</script>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		String message="";
		Box box=HMSUtil.getBox(request);
		List<MasDiet> masDietList = new ArrayList<MasDiet>();
		List<MasMenuType> masMenuTypeList = new ArrayList<MasMenuType>();
		List<IpdDietRequisitionHeader> dietRequisitionHeaders = new ArrayList<IpdDietRequisitionHeader>();
		
		
		/* List indoorPatientDietList = new ArrayList();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		List<MasDiet> masDietList = new ArrayList<MasDiet>();
		List<PatientDietIndoorDetail> dietIndoorDetailList = new ArrayList<PatientDietIndoorDetail>(); */
		Map<String, Object> utilMap = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currenDate = (String) utilMap.get("currentDate");
	 	String currentTime = (String) utilMap.get("currentTime");
	 	/* String userName=null;
	  	if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		} */
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		/* if(map.get("indoorPatientDietList") != null){
			indoorPatientDietList= (List)map.get("indoorPatientDietList");
		}
		if(map.get("masEmployeeList") != null){
			masEmployeeList= (List<MasEmployee>)map.get("masEmployeeList");
		}
		if(map.get("masDietList") != null){
			masDietList= (List<MasDiet>)map.get("masDietList");
		} */
		
		if(map.get("masDietList") != null){
			masDietList= (List<MasDiet>)map.get("masDietList");
		}
		if(map.get("masMenuTypeList") != null){
			masMenuTypeList= (List<MasMenuType>)map.get("masMenuTypeList");
		}
		
		if(map.get("dietRequisitionHeaders") != null){
			dietRequisitionHeaders= (List<IpdDietRequisitionHeader>)map.get("dietRequisitionHeaders");
		}
		
		if(map.get("box")!=null)
		{
			box=(Box)map.get("box");
		}

		int cnt=1;
	%>
<%--
<div class="titleBg">
<h2>Chart of diet for Indoor Patient</h2>
</div>
<div class="search" id="threadsearch"><a href=""></a> <script
	type="text/javascript"> vbmenu_register("threadsearch"); </script></div>
<div class="clear"></div>
<!-- thread search menu -->
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<form name="search" action="" method="post"><label><%=prop.getProperty("com.jkt.hms.registration_no") :</label>
<input type="text" name="<%=HIN_NO %>" id="hinNo" MAXLENGTH="30"
	tabindex=1 />
<div class="clear"></div>
<label>Patient First Name : </label> <input type="text"
	name="<%=P_FIRST_NAME %>" id="patientFName" MAXLENGTH="30" tabindex=1 />
<label>Patient Middle Name : </label> <input type="text"
	name="<%=P_MIDDLE_NAME %>" id="patientMName" MAXLENGTH="30" tabindex=1 />
<div class="clear"></div>
<label>Patient Last Name : </label> <input type="text"
	name="<%=P_LAST_NAME %>" id="pateintLName" MAXLENGTH="30" tabindex=1 />
<input type="button"
	onClick="submitForm('search','/hms/hms/diet?method=searchIndoorPatientDietList');"
	class="button" /></form>
</div>


<div class="clear"></div>
<form name="dietIndoorPatientList" method="post" action="">

<div class="Block"><label>Date:</label> <%
String toDate=null;
if(request.getParameter("toDate")!=null)
{
	toDate = (String)request.getParameter("toDate");

}else if(toDate==null)
{
	toDate = currenDate;
}
%> <input type="text" id="toDateId" name="<%=TO_DATE%>"
	value="<%=toDate%>" class="date" readonly="readonly" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="javascript:setdate('<%=currenDate %>',document.dietIndoorPatientList.<%=TO_DATE%>,event)"></img>
<label>Time:</label> <select
	name="time" id="time" onchange="selectLunchAndDinner()">
	<option value="M">Morning</option>
	<option value="E">Evening</option>
</select>
<input type="button" name="SearchList" onclick="searchLunchAndDinner()" value="Go" class="button" accesskey="a" />
<div class="clear"></div>
<label><span>*</span>Prepared By:</label> <select name="employeeId"
	id="employeeId">
	<option value="0">Select</option>
	<%
 for(MasEmployee employee : masEmployeeList)
 {
	 String employeeName ="";
  if(employee.getFirstName()!=null)
  {
	  employeeName = employee.getFirstName();
  }
  if(employee.getMiddleName()!=null)
  {
	  employeeName = employeeName+" "+employee.getMiddleName();
  }
  if(employee.getLastName()!=null)
  {
	  employeeName = employeeName+" "+employee.getLastName();
  }
 %>
	<option value="<%=employee.getId()%>"><%=employeeName%></option>
	<%}%>
</select></div>

<div class="clear"></div>
<div class="clear"></div>
<div id="searchresults" tabindex=2></div>
<div id="searchtable" tabindex=2></div>

<div id="testDivItem">
<%
    int  counter=0;
	if (indoorPatientDietList != null && indoorPatientDietList.size() > 0) {

%>

<table>
	<tr>
		<th></th>
		<th>Sl. No.</th>
		<th>Name of Patient</th>
		<th><%=prop.getProperty("com.jkt.hms.registration_no")%></th>
		<th>Bed No.</th>
		<th>Type of Food</th>
		<th>Morning Tea Bread</th>
		<th>Eggs</th>
		<th>Lunch</th>
		<th>Evening Tea</th>
		<th>Banana</th>
		<th>Dinner</th>
		<th>Remark</th>
	</tr>
<%
for(int i=0;i<indoorPatientDietList.size(); i++){
	Inpatient patient = (Inpatient)indoorPatientDietList.get(i);
%>
	<tr>
		<td><input type="checkbox" class="radiogrid" name="parent<%=cnt%>"
			id="parent<%=cnt%>" value="<%=patient.getId()%>" checked="checked"/></td>
		<td><%=cnt%></td>
		<%
	  	 String parient_Name ="";
		  if(patient.getHin().getPFirstName()!=null)
		  {
			  parient_Name = patient.getHin().getPFirstName();
		  }
		  if(patient.getHin().getPMiddleName()!=null)
		  {
			  parient_Name = parient_Name+" "+patient.getHin().getPMiddleName();
		  }
		  if(patient.getHin().getPLastName()!=null)
		  {
			  parient_Name = parient_Name+" "+patient.getHin().getPLastName();
		  }
	%>
		<td><%=parient_Name%></td>
		<td><%=patient.getHin().getHinNo()%><input type="hidden" name="<%=HIN_NO%><%=cnt%>" id="<%=HIN_NO%><%=cnt%>" value="<%=patient.getHin().getId()%>" /></td>
		<td><%=patient.getBed().getBedNo()%><input type="hidden" name="<%=BED_NO%><%=cnt%>" id="<%=BED_NO%><%=cnt%>" value="<%=patient.getBed().getId()%>" /></td>
		<td><select name="dietType<%=cnt%>" id="dietType<%=cnt%>"
			style="width: 60px; overflow: auto;">
			<%for(MasDiet masDiet : masDietList){
				if(patient.getDiet()==null){%>
					<option value="<%=masDiet.getId()%>"><%=masDiet.getDietName()%></option>
				<%}else{
					if(patient.getDiet().getId().equals(masDiet.getId())){%>
			<option	value="<%=patient.getDiet().getId()%>" selected="selected"><%=masDiet.getDietName()%></option>
			<%}else{%><option value="<%=masDiet.getId()%>"><%=masDiet.getDietName()%></option>

			<%}}}%>

		</select></td>
		<td><select name="morningTea<%=cnt%>" id="morningTea<%=cnt%>"
			style="width: 60px; overflow: auto;">
			<option value="Y">Yes</option>
			<option value="N">No</option>
		</select></td>
		<%
				String doctName ="";
				if(patient.getDoctor() != null){
					doctName =patient.getDoctor().getFirstName();
					if(patient.getDoctor().getMiddleName()!=null)
					{
					 doctName = doctName +" "+patient.getDoctor().getMiddleName();
					}
					if(patient.getDoctor().getLastName()!=null)
					{
					 doctName = doctName +" "+patient.getDoctor().getLastName();
					}
				}
			%>

		<td><select name="eggs<%=cnt%>" id="eggs<%=cnt%>"
			style="width: 60px; overflow: auto;">
			<option value="Y">Yes</option>
			<option value="N">No</option>
		</select></td>
		<td><select name="lunch<%=cnt%>" id="lunch<%=cnt%>"
			style="width: 60px; overflow: auto;">
			<option value="Y">Yes</option>
			<option value="N">No</option>
		</select></td>
		<td><select name="eveningTea<%=cnt%>" id="eveningTea<%=cnt%>"
			style="width: 60px; overflow: auto;">
			<option value="N">No</option>
			<option value="Y">Yes</option>
		</select></td>
		<td><select name="banana<%=cnt%>" id="banana<%=cnt%>"
			style="width: 60px; overflow: auto;">
			<option value="N">No</option>
			<option value="Y">Yes</option>
		</select></td>
		<td><select name="dinner<%=cnt%>" id="dinner<%=cnt%>"
			style="width: 60px; overflow: auto;">
			<option value="N">No</option>
			<option value="Y">Yes</option>
		</select></td>
		<td><input type="text" name="remarks<%=cnt%>" id="remarks<%=cnt%>" value="" maxlength="95" /></td>
	</tr>
<%
	cnt++;
	counter++;
	}
%>
</table>

</div>

<div id="testDiv"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<center><input name="Submit"
	type="button" align="right" tabindex="5" class="button" value="Submit"
	onclick="if(validateField()){submitForm('dietIndoorPatientList','/hms/hms/diet?method=updateIndoorPatientDiet');}" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</center>
<%}else{%>
<font face="arial" size="4" color="red">No Records Found !</font>
<%} %>
<input type="hidden" name="counter" id="counter" value="<%=counter%>"></input>
<div class="clear"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=currenDate%></label>
<label>Changed Time</label> <label class="value"><%=currentTime%></label>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currenDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" /></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">
	<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
	//-->
</script>

<script type="text/javascript">
function selectLunchAndDinner()
{

	var time = document.getElementById("time").value
	var toDate = document.getElementById("toDateId").value;

	var counter =  document.getElementById("counter").value
	for(i =1;i<=counter;i++)
	{
		if(time=='E')
		{
			document.getElementById("morningTea"+i).value='N'
			document.getElementById("eggs"+i).value='N'
			document.getElementById("lunch"+i).value='N'
			document.getElementById("eveningTea"+i).value='Y'
			document.getElementById("banana"+i).value='Y'
			document.getElementById("dinner"+i).value='Y'
		}
		if(time=='M')
		{
		    document.getElementById("morningTea"+i).value='Y'
			document.getElementById("eggs"+i).value='Y'
			document.getElementById("lunch"+i).value='Y'
			document.getElementById("eveningTea"+i).value='N'
			document.getElementById("banana"+i).value='N'
			document.getElementById("dinner"+i).value='N'
		}
	}
}
function searchLunchAndDinner()
{
		var time = document.getElementById("time").value
		var toDate = document.getElementById("toDateId").value;
		submitProtoAjaxForLionClass('dietIndoorPatientList','/hms/hms/diet?method=showDietForIndoorPatientListNest&time='+time+'&toDate='+toDate);
}

function submitProtoAjaxForLionClass(formName,action){
	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 var url=action+"&"+getNameAndData(formName)

        	new Ajax.Updater('testDivItem',url,
			   {asynchronous:true, evalScripts:true });
			return true;
    	}

function validateField()
{
if(document.getElementById('employeeId').value=='0')
{
	alert('Please Select the Prepared Name !!!');
	document.getElementById('employeeId').focus();
	return false;
}
else
{
 return true;
}
}

</script>
</form> --%>







<div class="Block" >
 <div class="titleBg">
<h2>issue Diet To Patient</h2>
</div> 
<div class="clear"></div>
<form name="serachDietPatient" method="post" action="">
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>


<label>Requisition for Date</label>
<%if(!box.getString("dietForDate").equals("")) {%>
<script type="text/javascript">
var requisitiondate='<%=box.getString("dietForDate")%>';
</script>
<input type="text"  class="date"validate="Requisition for Date,date,yes" name="dietForDate" id="dietForDate" readonly="readonly" value="<%=box.getString("dietForDate")%>"  />
<img width="16" height="16" border="0" onclick="javascript:setdate('<%=date+"/"+month+"/"+year%>',document.serachDietPatient.dietForDate,event);" validate="Pick a date" src="/hms/jsp/images/cal.gif">
 
<%}else{ %>
<script type="text/javascript">
var requisitiondate='<%=date+"/"+month+"/"+year%>';
</script>
<input type="text"  class="date" name="dietForDate" validate="Requisition for Date,date,yes" id="dietForDate" readonly="readonly" value="<%=date+"/"+month+"/"+year%>"    />
<img width="16" height="16" border="0" onclick="javascript:setdate('<%=date+"/"+month+"/"+year%>',document.serachDietPatient.dietForDate,event);" validate="Pick a date" src="/hms/jsp/images/cal.gif">
 
<%} %>
 
 <label>Diet Time</label>
<select name="<%=DIET_MENU_ITEM_ID %>" id="<%=DIET_MENU_ITEM_ID %>"  validate="Diet Time,int,yes">
<option value="">select</option>
<%
for(MasMenuType menuType : masMenuTypeList)
{
%>
<%if(box.getInt(DIET_MENU_ITEM_ID)==menuType.getId()) {%>
<option value="<%=	menuType.getId()%>" selected="selected"><%=menuType.getMenuName()%></option>

<% }else{%>

<option value="<%=	menuType.getId()%>"><%=menuType.getMenuName()%></option>

<% }%>

<%} %>
</select> 


<label>Diet Type</label>

<select name="<%=DIET_TYPE_ID %>" id="<%=DIET_TYPE_ID %>" validate="Diet Type,int,no">
<option value="">select</option>
<%
for(MasDiet diet : masDietList)
{
%>

<%if(box.getInt(DIET_MENU_ITEM_ID)==diet.getId()) {%>
<option value="<%=	diet.getId()%>" selected="selected"><%=diet.getDietName()%></option>

<% }else{%>

<option value="<%=	diet.getId()%>"><%=diet.getDietName()%></option>

<% }%>

<%} %>
</select> 


<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<input type="button" value="Search" class="button" onclick="submitForm('serachDietPatient','/hms/hms/ipd?method=showDietForIndoorPatientList');" />


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>

<%if(dietRequisitionHeaders.size()>0)
	{%>
<form name="isuueDietToPatient" method="post" action="">

<label>Date</label>

<%if(!box.getString(REQUEST_DATE).equals("")){ %>

<input type="text"  class="date" name="<%=REQUEST_DATE%>" id="<%=REQUEST_DATE%>" validate="Request Date,date,no" readonly="readonly"  value="<%=box.getString(REQUEST_DATE)%>"/>
<img width="16" height="16" border="0" onclick="javascript:setdate('<%=date+"/"+month+"/"+year%>',document.isuueDietToPatient.<%=REQUEST_DATE%>,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
 
<%}else{ %>
<input type="text"  class="date" name="<%=REQUEST_DATE%>" id="<%=REQUEST_DATE%>" validate="Request Date,date,no" readonly="readonly" value="<%=date+"/"+month+"/"+year%>"/>
<img width="16" height="16" border="0" onclick="javascript:setdate('<%=date+"/"+month+"/"+year%>',document.isuueDietToPatient.<%=REQUEST_DATE%>,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
 
<%} %>


	<div class="clear"></div>
<div class="paddingTop25"></div>
	<div class="clear"></div>

<table width="100%" colspan="7" id="componentDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<!-- <th width="3%">&nbsp;</th> -->
			<th>IP No.</th>
			<th>Patient Name</th>
			<th>Age</th>
			<th>Gender</th>
			 <th>Category</th>
			  <th>Bed No.</th>
			<th>Diagnosis</th>
			<th>Adm Date</th>
			<th>Doctor Name</th>
			<!-- <th>Diet Time</th>
			<th>Remarks</th>  -->
			 <th>Issue</th>
		</tr>
	</thead>
	<tbody>
	<%
	int patientCount=0;
	for(IpdDietRequisitionHeader dietRequisitionHeader:dietRequisitionHeaders) {
		patientCount++;
		Inpatient inpatient=dietRequisitionHeader.getInpatient();
		String patientName = "-";
		try
		{
			patientName=inpatient.getHin().getPFirstName();
			if(inpatient.getHin().getPMiddleName()!=null){
				patientName += " "+inpatient.getHin().getPMiddleName();
			}
			if(inpatient.getHin().getPLastName()!=null){
				patientName += " "+inpatient.getHin().getPLastName();
		}
		}
		catch (Exception e)
		{
		patientName = "-";
		}
		
		String gender="-";
		try
		{
			gender = inpatient.getHin().getSex().getAdministrativeSexName();
		}
		catch(Exception exception)
		{
			gender="-";
		}
		
		String currentAge = "-";
		try
		{
					String age = inpatient.getHin().getAge();
				try{
					if(!age.equals(""))
					currentAge = HMSUtil.calculateAgeForADT(age,inpatient.getHin().getRegDate());
				}catch(Exception ex){
					ex.printStackTrace();
				}
		}
		catch(Exception exception)
		{
			currentAge="-";
		}
		
		String consultingDoctor="-";
		try
		{
			consultingDoctor=inpatient.getDoctor().getFirstName();
			if(inpatient.getDoctor().getMiddleName()!=null)
			{
				consultingDoctor +=" "+inpatient.getDoctor().getMiddleName();
			}
			
			if(inpatient.getDoctor().getLastName()!=null)
			{
				consultingDoctor+=" "+inpatient.getDoctor().getLastName();
			}
		}
		catch(Exception exception)
		{
			consultingDoctor="-";
		}
	%>
		<tr>
<!-- <td><input type="checkbox" /> </td> -->
			<td><%=inpatient.getAdNo() %></td>
	<td><%=patientName %></td>
		<td><%=currentAge %></td>
	<td><%=gender %></td>
	<td>&nbsp;</td>
		<td><%=inpatient.getBed().getBedNo() %></td>
		<td>&nbsp;</td>
		<td><%=HMSUtil.convertDateToStringWithoutTime(inpatient.getDateOfAddmission()) %></td>
	<td><%=consultingDoctor%></td>
			 <td><input type="checkbox" name="dietRequisitionId<%=patientCount %>" id="dietRequisitionId<%=patientCount %>" onchange="updateItemrequiredForDietCombination('<%=inpatient.getId()%>','<%=patientCount %>')" value="<%=dietRequisitionHeader.getId() %>" />
			 <div id="extradiet<%=inpatient.getId()%>">
			 <%
			 Set<IpdDietRequisitionDetails> dietRequisitionDetails=new HashSet<IpdDietRequisitionDetails>();
			 dietRequisitionDetails=dietRequisitionHeader.getIpdDietRequisitionDetails();
			 int dietCount=0;
			 for(IpdDietRequisitionDetails details:dietRequisitionDetails)
			 { 
			 if(details.getDietItems()!=null)
			 {
				 dietCount++;
			
			 %>
			 <input type="hidden" name="extraDietId<%=inpatient.getId()%><%=dietCount %>" id="extraDietId<%=inpatient.getId()%><%=dietCount %>" value="<%=details.getDietItems().getId()%>" validate="Id,int,no">
			 <input type="hidden" name="extraDietName<%=inpatient.getId()%><%=dietCount %>" id="extraDietName<%=inpatient.getId()%><%=dietCount %>" value="<%=details.getDietItems().getDietItemsName()%>" validate="Name,metachar,no">
			 <input type="hidden" name="extraDietquantity<%=inpatient.getId()%><%=dietCount %>" id="extraDietquantity<%=inpatient.getId()%><%=dietCount %>" value="<%=details.getQuantity()%>" validate="quantity,metachar,no">
			  <input type="hidden" name="extraDietunit<%=inpatient.getId()%><%=dietCount %>" id="extraDietunit<%=inpatient.getId()%><%=dietCount %>" value="<%=details.getDietItems().getAccountingUnit()!=null?details.getDietItems().getAccountingUnit().getUnitName():""%>" validate="UnitName,metachar,no">
			 <input type="hidden" name="extraDietRemarks<%=inpatient.getId()%><%=dietCount %>" id="extraDietRemarks<%=inpatient.getId()%><%=dietCount %>" value="<%=details.getRemarks()%>" validate="remarks,metachar,no">
			 <%} 
			 }
			 %>
			 <input type="hidden" name="extracount<%=inpatient.getId()%>" id="extracount<%=inpatient.getId()%>" value="<%=dietCount%>">
			 
			 </div>
			 
			 <div id="selectedDiet<%=inpatient.getId()%>">
			 <%
			  dietCount=0;
			 for(IpdDietRequisitionDetails details:dietRequisitionDetails)
			 { 
			 if(details.getDietCombination()!=null)
			 {
				 dietCount++;
			
			 %>
			 <input type="hidden" name="dietcombinationDietId<%=inpatient.getId()%><%=dietCount %>" id="dietcombinationDietId<%=inpatient.getId()%><%=dietCount %>" value="<%=details.getDietCombination().getDietItems().getId()%>" validate="Id,int,no">
			 <input type="hidden" name="dietcombinationId<%=inpatient.getId()%><%=dietCount %>" id="dietcombinationId<%=inpatient.getId()%><%=dietCount %>" value="<%=details.getDietCombination().getId()%>" validate="Id,int,no">
			 <input type="hidden" name="dietcombinationName<%=inpatient.getId()%><%=dietCount %>" id="dietcombinationName<%=inpatient.getId()%><%=dietCount %>" value="<%=details.getDietCombination().getDietItems().getDietItemsName()%>" validate="Name,metachar,no">
			 <input type="hidden" name="dietcombinationquantity<%=inpatient.getId()%><%=dietCount %>" id="dietcombinationquantity<%=inpatient.getId()%><%=dietCount %>" value="<%=details.getDietCombination().getDietQuantity()%>" validate="quantity,metachar,no">
			 <input type="hidden" name="dietcombinationunit<%=inpatient.getId()%><%=dietCount %>" id="dietcombinationunit<%=inpatient.getId()%><%=dietCount %>" value="<%=details.getDietCombination().getDietItems().getAccountingUnit()!=null?details.getDietCombination().getDietItems().getAccountingUnit().getUnitName():""%>" validate="ÜnitName,metachar,no">
			 
			 <%} 
			 }
			 %>
			 <input type="hidden" name="dietCount<%=inpatient.getId()%>" id="dietCount<%=inpatient.getId()%>" value="<%=dietCount%>">
			 </div>
			 
			  </td> 
		</tr>
		
		<%} %>
		
	</tbody>
</table>
<input type="hidden" name="patientCount" id="patientCount" value="<%=patientCount%>" />

<!-- <div style="float: right;">
<label>Page</label>
<select class="small" name="templateId" id="templateId" onchange="showHideDrugTemplateCombo(this.value);" tabindex="1">
<option value="0">Select</option>
</select>
</div> -->

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<label>Remarks</label><textarea name="<%=REMARKS%>" id="<%=REMARKS%>" rows="5" cols="20" class="large" maxlength="200"  onkeyup="return checkLength(this)" validate="remarks,metachar,no"></textarea>
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<h4>Total Diet Required</h4>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<%
int itemrequired=0;
%>
<table  id="itemrequiredTable" >
	<thead>
		<tr>
			<th>Item</th>
			<th>Qty</th>
			<!-- <th>Remarks</th> -->
		</tr>
	</thead>
	<tbody>
	
	</tbody>
</table>

<input type="hidden" name="itemRequired" id="itemRequired" value="<%=itemrequired%>" />

 <div class="clear"></div>
<div class="paddingTop25"></div>
<div class="paddingTop15"></div>

<div class="clear"></div>
<input type="button" class="button" value="Submit"  align="right" tabindex=1 onclick="submitDietIssue();" />
	<input type="button" class="button" value="Reset" 	align="right" tabindex=1 onclick="submitFormForButton('isuueDietToPatient','/hms/hms/ipd?method=showDietForIndoorPatientList');" />
	
	<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<%} else{%>
<h4>No Record Found.</h4>
<%} %>

<div class="clear"></div>

</div>

<script type="text/javascript">
function updateItemrequiredForDietCombination(inpatientId,index)
{
	if(document.getElementById("dietRequisitionId"+index).checked)
		{
	if(document.getElementById('itemRequired').value>0)
	{
			for(var k=1;k<=document.getElementById("dietCount"+inpatientId).value;k++)
				{
		var itemmatched=false; 
		for(var j=1;j<=document.getElementById('itemRequired').value;j++)
			{
			if(document.getElementById('dietId'+j)!=null && document.getElementById('dietcombinationDietId'+inpatientId+k).value==document.getElementById('dietId'+j).value)
			{
				var quantity=parseFloat(document.getElementById('dietItemCount'+j).value)+parseFloat(document.getElementById('dietcombinationquantity'+inpatientId+k).value);
				 document.getElementById('dietItemCountView'+j).innerHTML='';
				var e3 = document.createElement('input');
				  e3.type = 'hidden';
				  e3.name='dietItemCount'+j;
				  e3.id='dietItemCount'+j
				  e3.value=quantity ;
				  document.getElementById('dietItemCountView'+j).appendChild(e3);	
				var e3 = document.createElement('label');
				  e3.innerHTML =parseFloat(document.getElementById('dietItemCount'+j).value) + document.getElementById('dietcombinationunit'+inpatientId+k).value;
				  document.getElementById('dietItemCountView'+j).appendChild(e3);	
				itemmatched=true;
				break;
			}
			}
		if(!itemmatched)
			{
			var tbl = document.getElementById('itemrequiredTable');
			  var lastRow = tbl.rows.length;
			  var hdb = document.getElementById('itemRequired');
			  var iteration = parseInt(hdb.value);
		  	 var row = tbl.insertRow(lastRow);
			  var iteration = parseInt(hdb.value)+1;
			  hdb.value = iteration;
		   
		   	  var cellRight1 = row.insertCell(0);
			  var e3 = document.createElement('input');
			  e3.type = 'hidden';
			  e3.name='dietId'+iteration;
			  e3.id='dietId'+iteration
			  e3.value=document.getElementById('dietcombinationDietId'+inpatientId+k).value;
			  cellRight1.appendChild(e3);
			  var e3 = document.createElement('label');
			  e3.innerHTML =document.getElementById('dietcombinationName'+inpatientId+k).value;
			  cellRight1.appendChild(e3);
			  
			  var cellRight1 = row.insertCell(1);
			  cellRight1.id="dietItemCountView"+iteration;
			  
			  var e3 = document.createElement('input');
			  e3.type = 'hidden';
			  e3.name='dietItemCount'+iteration;
			  e3.id='dietItemCount'+iteration
			  e3.value=document.getElementById('dietcombinationquantity'+inpatientId+k).value;
			  cellRight1.appendChild(e3);
			  var e3 = document.createElement('label');
			  e3.innerHTML =document.getElementById('dietcombinationquantity'+inpatientId+k).value+document.getElementById('dietcombinationunit'+inpatientId+k).value;
			  cellRight1.appendChild(e3);
			}
			}
	}
	else
		{
				var count=document.getElementById("dietCount"+inpatientId).value
				for(var i=1;i<=count;i++)
				{
				  /*  if(document.getElementById("checkbox"+i)!=null && document.getElementById("checkbox"+i).checked && document.getElementById('nomenclature'+i)!=null && document.getElementById('nomenclature'+i).value!='')
					   { */
					   var tbl = document.getElementById('itemrequiredTable');
						  var lastRow = tbl.rows.length;
						  var hdb = document.getElementById('itemRequired');
						  var iteration = parseInt(hdb.value);
					  	 var row = tbl.insertRow(lastRow);
						  var iteration = parseInt(hdb.value)+1;
						  hdb.value = iteration;
					   
					   	  var cellRight1 = row.insertCell(0);
						  var e3 = document.createElement('input');
						  e3.type = 'hidden';
						  e3.name='dietId'+iteration;
						  e3.id='dietId'+iteration
						  e3.value=document.getElementById('dietcombinationDietId'+inpatientId+i).value;
						  cellRight1.appendChild(e3);
						  var e3 = document.createElement('label');
						  e3.innerHTML =document.getElementById('dietcombinationName'+inpatientId+i).value;
						  cellRight1.appendChild(e3);
						  
						  var cellRight1 = row.insertCell(1);
						  cellRight1.id="dietItemCountView"+iteration;
						  
						  var e3 = document.createElement('input');
						  e3.type = 'hidden';
						  e3.name='dietItemCount'+iteration;
						  e3.id='dietItemCount'+iteration
						  e3.value=document.getElementById('dietcombinationquantity'+inpatientId+i).value;
						  cellRight1.appendChild(e3);
						  var e3 = document.createElement('label');
						  e3.innerHTML =document.getElementById('dietcombinationquantity'+inpatientId+i).value+document.getElementById('dietcombinationunit'+inpatientId+i).value;
						  cellRight1.appendChild(e3);
					  /*  } */
				}
		}
	
	if(document.getElementById('itemRequired').value>0)
	{
			for(var k=1;k<=document.getElementById("extracount"+inpatientId).value;k++)
				{
		var itemmatched=false; 
		for(var j=1;j<=document.getElementById('itemRequired').value;j++)
			{
			if(document.getElementById('dietId'+j)!=null && document.getElementById('extraDietId'+inpatientId+k).value==document.getElementById('dietId'+j).value)
			{
				var quantity=parseFloat(document.getElementById('dietItemCount'+j).value)+parseFloat(document.getElementById('extraDietquantity'+inpatientId+k).value);
				 document.getElementById('dietItemCountView'+j).innerHTML='';
				var e3 = document.createElement('input');
				  e3.type = 'hidden';
				  e3.name='dietItemCount'+j;
				  e3.id='dietItemCount'+j
				  e3.value=quantity ;
				  document.getElementById('dietItemCountView'+j).appendChild(e3);	
				var e3 = document.createElement('label');
				  e3.innerHTML =parseFloat(document.getElementById('dietItemCount'+j).value) + document.getElementById('extraDietunit'+inpatientId+k).value;
				  document.getElementById('dietItemCountView'+j).appendChild(e3);	
				itemmatched=true;
				break;
			}
			}
		if(!itemmatched)
			{
			var tbl = document.getElementById('itemrequiredTable');
			  var lastRow = tbl.rows.length;
			  var hdb = document.getElementById('itemRequired');
			  var iteration = parseInt(hdb.value);
		  	 var row = tbl.insertRow(lastRow);
			  var iteration = parseInt(hdb.value)+1;
			  hdb.value = iteration;
		   
		   	  var cellRight1 = row.insertCell(0);
			  var e3 = document.createElement('input');
			  e3.type = 'hidden';
			  e3.name='dietId'+iteration;
			  e3.id='dietId'+iteration
			  e3.value=document.getElementById('extraDietId'+inpatientId+k).value;
			  cellRight1.appendChild(e3);
			  var e3 = document.createElement('label');
			  e3.innerHTML =document.getElementById('extraDietName'+inpatientId+k).value;
			  cellRight1.appendChild(e3);
			  
			  var cellRight1 = row.insertCell(1);
			  cellRight1.id="dietItemCountView"+iteration;
			  
			  var e3 = document.createElement('input');
			  e3.type = 'hidden';
			  e3.name='dietItemCount'+iteration;
			  e3.id='dietItemCount'+iteration
			  e3.value=document.getElementById('extraDietquantity'+inpatientId+k).value;
			  cellRight1.appendChild(e3);
			  var e3 = document.createElement('label');
			  e3.innerHTML =document.getElementById('extraDietquantity'+inpatientId+k).value+document.getElementById('extraDietunit'+inpatientId+k).value;
			  cellRight1.appendChild(e3);
			}
			}
	}
	else
		{
				var count=document.getElementById("extracount"+inpatientId).value
				for(var i=1;i<=count;i++)
				{
					  
			var tbl = document.getElementById('itemrequiredTable');
			  var lastRow = tbl.rows.length;
			  var hdb = document.getElementById('itemRequired');
			  var iteration = parseInt(hdb.value);
		  	 var row = tbl.insertRow(lastRow);
			  var iteration = parseInt(hdb.value)+1;
			  hdb.value = iteration;
		   
		   	  var cellRight1 = row.insertCell(0);
			  var e3 = document.createElement('input');
			  e3.type = 'hidden';
			  e3.name='dietId'+iteration;
			  e3.id='dietId'+iteration
			  e3.value=document.getElementById('extraDietId'+inpatientId+i).value;
			  cellRight1.appendChild(e3);
			  var e3 = document.createElement('label');
			  e3.innerHTML =document.getElementById('extraDietName'+inpatientId+i).value;
			  cellRight1.appendChild(e3);
			  
			  var cellRight1 = row.insertCell(1);
			  cellRight1.id="dietItemCountView"+iteration;
			  
			  var e3 = document.createElement('input');
			  e3.type = 'hidden';
			  e3.name='dietItemCount'+iteration;
			  e3.id='dietItemCount'+iteration
			  e3.value=document.getElementById('extraDietquantity'+inpatientId+i).value;
			  cellRight1.appendChild(e3);
			  var e3 = document.createElement('label');
			  e3.innerHTML =document.getElementById('extraDietquantity'+inpatientId+i).value+document.getElementById('extraDietunit'+inpatientId+i).value;
			  cellRight1.appendChild(e3);
				}
		}
	
		}
	else
		{
		
		if(document.getElementById('dietCount'+inpatientId).value>0)
		{
		var tbl = document.getElementById('itemrequiredTable');
		var itemRequiredCount=document.getElementById('itemRequired').value;
		var patientDietCount=document.getElementById('dietCount'+inpatientId).value;
		for(var i=1;i<=patientDietCount;i++)
			{
			var deleteRow=0;
			for(var j=1;j<=itemRequiredCount;j++)
				{
				if(document.getElementById('dietId'+j)!=null)
					{
					deleteRow=deleteRow+1;
					}
				if(document.getElementById('dietId'+j)!=null && document.getElementById('dietcombinationDietId'+inpatientId+''+i).value==document.getElementById('dietId'+j).value)
				{
					
					var quantity=parseInt(document.getElementById('dietItemCount'+j).value)-parseInt(document.getElementById('dietcombinationquantity'+inpatientId+''+i).value);
					document.getElementById('dietItemCountView'+j).innerHTML='';
					var e3 = document.createElement('input');
					  e3.type = 'hidden';
					  e3.name='dietItemCount'+j;
					  e3.id='dietItemCount'+j
					  e3.value=quantity;
					  document.getElementById('dietItemCountView'+j).appendChild(e3);	
					var e3 = document.createElement('label');
					  e3.innerHTML =document.getElementById('dietItemCount'+j).value;
					  document.getElementById('dietItemCountView'+j).appendChild(e3);
					if(document.getElementById('dietItemCount'+j).value<=0)
						{
						tbl.deleteRow(deleteRow);
						}
					break;
				}
				}
			}
		}
		
		
		 if(document.getElementById('extracount'+inpatientId).value>0)
		{
		var tbl = document.getElementById('itemrequiredTable');
		var itemRequiredCount=document.getElementById('itemRequired').value;
		var patientDietCount=document.getElementById('extracount'+inpatientId).value;
		for(var i=1;i<=patientDietCount;i++)
			{
			var deleteRow=0;
			for(var j=1;j<=itemRequiredCount;j++)
				{
				if(document.getElementById('dietId'+j)!=null)
					{
					deleteRow=deleteRow+1;
					}
				if(document.getElementById('dietId'+j)!=null && document.getElementById('extraDietId'+inpatientId+''+i).value==document.getElementById('dietId'+j).value)
				{				
					var quantity=parseInt(document.getElementById('dietItemCount'+j).value)-parseInt(document.getElementById('extraDietquantity'+inpatientId+''+i).value);
					 document.getElementById('dietItemCountView'+j).innerHTML='';
					var e3 = document.createElement('input');
					  e3.type = 'hidden';
					  e3.name='dietItemCount'+j;
					  e3.id='dietItemCount'+j
					  e3.value=quantity;
					  document.getElementById('dietItemCountView'+j).appendChild(e3);	
					var e3 = document.createElement('label');
					  e3.innerHTML =document.getElementById('dietItemCount'+j).value;
					 document.getElementById('dietItemCountView'+j).appendChild(e3);	
					if(document.getElementById('dietItemCount'+j).value<=0)
						{
						tbl.deleteRow(deleteRow);
						}
					break;
				}
				}
			}
		} 
		}
	}
	
	function submitDietIssue()
	{
		var patientCount=document.getElementById('patientCount').value;
		var selectedCount=0;
		for(var i=1;i<=patientCount;i++)
			{
			if(document.getElementById('dietRequisitionId'+i).checked)
				{
				selectedCount=selectedCount+1;
				}
			}
		if(selectedCount==0)
			{
			alert('Please select atleast one patient before submitting.');
			return;
			}
		
		submitForm('isuueDietToPatient',"/hms/hms/ipd?method=submitDietForIndoorPatientList");
		
	}
</script>