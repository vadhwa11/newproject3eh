<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.RequestConstants"%>

<%@page import="jkt.hms.masters.business.HesEquipmentBreakdownEntry"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.HesEquipmentMaster"%><script type="text/javascript" src="/hms/jsp/js/acnik.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>

<script type="text/javascript" language="javascript">
<%
Calendar calendar = Calendar.getInstance();
String month = String.valueOf((calendar.get(Calendar.MONTH))+1);
String date = String.valueOf(calendar.get(Calendar.DATE));
int year = calendar.get(calendar.YEAR);

	if(month.length() < 2)
	{
		month = "0" + month;
	}
	if(date.length() < 2)
	{
		date = "0" + date;
	}
%>
serverdate = '<%=date+"/"+month+"/"+year%>'
</script>


<%
	Map<String ,Object> map = new HashMap<String ,Object>();
	String entryNo = "";
	String euipmentName="";
	String natureOfBreakdown="";
	String dateOfBreakdown="";
	String timeOfBreakdown="";
	String userName = "";
	int empIdTo=0;
	int empIdFrom=0;
	String ramarks="";
	
	
	if(request.getAttribute("map")!=null)
	{
		map = (Map<String ,Object>) request.getAttribute("map");
	}
	
	
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	//List<Object> assessoryList = new ArrayList<Object>();
	List<HesEquipmentBreakdownEntry> equipmentBreakdownList = new ArrayList<HesEquipmentBreakdownEntry>();		
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasEmployee> employeeListTo = new ArrayList<MasEmployee>();
	List<MasEmployee> employeeListFrom = new ArrayList<MasEmployee>();
	List<HesEquipmentMaster> equipmentList = new ArrayList<HesEquipmentMaster>();
	
	if (map.get("num")!=null)
		entryNo = (String)map.get("num").toString();
	   
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	
	if (map.get("departmentList")!= null){
		departmentList = (List<MasDepartment>)map.get("departmentList");
	}

	if (map.get("equipmentNameList")!= null){
		equipmentList = (List<HesEquipmentMaster>)map.get("equipmentNameList");
	}
	if (map.get("employeeListTo")!= null){
		employeeListTo = (List<MasEmployee>)map.get("employeeListTo");
	}	
	if (map.get("employeeListFrom")!= null){
		employeeListFrom = (List<MasEmployee>)map.get("employeeListFrom");
	}
	
	if (map.get("searchEquipmentBreakdownList")!= null){
		equipmentBreakdownList = (List<HesEquipmentBreakdownEntry>)map.get("searchEquipmentBreakdownList");
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
%>



<!--main content placeholder starts here-->

<div class="titleBg">
<h2>Emergency Call Entry For Equipment Breakdown</h2>
</div>




<div class="clear"></div>
<!--Block One Starts-->
<form name="equipmentEmergencyBreakdownEntryForm" method="post">
<div class="Block">
<label><span>*</span>Entry No.</label>
<input type="text" id="entryNo" name="entryNo" value="<%=entryNo%>" tabindex=1 readonly="readonly" />

<label>Date</label>
<input type="text" name="<%=RequestConstants.FROM_DATE%>"
	value="<%=currentDate %>" class="date" maxlength="30" tabindex=1 /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.equipmentEmergencyBreakdownEntryForm.<%=RequestConstants.FROM_DATE%>,event);" />


<label><span>*</span>Department Name</label>
<!-- <select name="deptId" id="deptId" validate="Department Name,String,yes" tabindex=1 onchange="populateDepartment(this.value,'equipmentBreakdownEntryForm');"> -->
<select name="deptId" id="deptId" validate="Department Name,String,yes" tabindex=1> 
	<option value="0">-Select Department-</option>
<%
		for (MasDepartment mastDepartment : departmentList )
		{
%>
			<option value=<%=mastDepartment.getId()%>><%=mastDepartment.getDepartmentName()%></option>
<%
		}
%>
</select>
<div class="clear"></div>
<label><span>*</span>Equipment Name</label>
<select name="equipmentId" id="equipmentId" validate="Equipment Name,String,yes" tabindex=1>
	<option value="0">-Select Equipment Name-</option>
<%
		for (HesEquipmentMaster hesEquipmentMaster : equipmentList )
		{
%>		
  			<option value=<%=hesEquipmentMaster.getId()%>><%=hesEquipmentMaster.getEquipmentName()%></option>	
			<%-- <option value="<%=hesEquipmentMaster.getId() %>"
		    <%=HMSUtil.isSelected(hesEquipmentMaster.getId(),Integer.valueOf(box.getInt("equipmentId")))%>><%=hesEquipmentMaster.getEquipmentName()%></option> --%>
<%
		}
%>
</select>

<%--  <script type="text/javascript">

<%
    int counter = 0;
	for (MasDepartment masDepartment : departmentList){
	for (HesEquipmentMaster equipmentMaintenance : equipmentList) {
		
	if(equipmentMaintenance.getDepartment() != null){
	if(masDepartment.getId().equals(equipmentMaintenance.getDepartment().getId() )){
departmentArray[<%=counter%>] = new Array();
departmentArray[<%=counter%>][0]=<%=masDepartment.getId()%>;
departmentArray[<%=counter%>][1] = <%=equipmentMaintenance.getId()%>;
departmentArray[<%=counter%>][2] = "<%=equipmentMaintenance.getEquipmentName()%>";
	<%
	counter++;
	} } } }
%>
</script> --%>


<label>Nature Of Breakdown</label>
<input type="text" id="breakId" rows="8" name="breakId" value=""  > </input>

<label>Date Of Breakdown</label>
<input type="text"
	name="<%=RequestConstants.TO_DATE%>" value="<%=currentDate %>" class="date"
	readonly="readonly" validate="Pick a date"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onclick="javascript:setdate('<%=currentDate%>',document.equipmentEmergencyBreakdownEntryForm.<%=RequestConstants.TO_DATE%>,event)" />
<div class="clear"></div>

<label>Time Of Breakdown</label>
<input type="text" name="<%=RequestConstants.DELIVERY_TIME%>" value="<%=currentTime %>"  validate="Call Time,deliveryTime,yes"
	MAXLENGTH="15" /> 
	

<label><span>*</span>Call Submitted To</label>
<select name="employeeIdTo" id="employeeIdTo" validate="Employee Name,String,yes">
<option value="0">Select</option>
<%
			for(MasEmployee masEmployeeTo : employeeListTo){
			%>
	           <option value=<%=masEmployeeTo.getId()%>><%=masEmployeeTo.getFirstName()+""+masEmployeeTo.getLastName()%></option>
	<%}%>
	</select>

<label><span>*</span>Call Submitted By</label>
<select name="employeeIdFrom" id="employeeIdFrom" validate="Employee Name,String,yes">
<option value="0">Select</option>
<%
			for(MasEmployee masEmployeeFrom : employeeListFrom){
			%>
				<option value=<%=masEmployeeFrom.getId()%>><%=masEmployeeFrom.getFirstName()+""+masEmployeeFrom.getLastName()%></option>
	<%}%>
	</select>

<div class="clear"></div>
<label>Remarks</label>
<textarea id="remarksId" rows="8" name="remarks" value=""  > </textarea>

<label>Action Taken:</label>
<input type="text" id="actionId" rows="8" name="actionId" value=""  > </input>

<label>Nature of Repairs Carried Out:</label>
<input type="text" id="repairId" rows="8" name="repairId" value=""  > </input>
	
<div class="clear"></div>

<label>Time of Complete Breakdown:</label>
<input type="text" id="completeTimeId" rows="8" name="completeTimeId" value=""  > </input>

<label>Serviced By:</label>
<select name="serviceById" id="serviceById" validate="Employee Name,String,yes">
<option value="0">--Select Serviced By--</option>
<option value="1">Company Service Engineer</option>
<option value="2">Biomedical Engineer</option>
<option value="3">Vbch</option>

</select>
<!-- <input type="text" id="serviceById" rows="8" name="serviceById" value=""  > </input> -->

</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<!--Block one Ends-->


<%--------------- Start of Search Panel using text box equipment no master ---------------------------%>

<form name="searchEquipBreakdown" method="post">
<div>

<label><span>*</span> Please Enter Equipment Breakdown Entry No</label>
	<td><input id="entryIdBreakdown" type="text" tabindex="1" size="45" value="" name="entryIdBreakdown" );"/>
			<div id="ac2update" class="autocomplete" style="display: none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
				new Ajax.Autocompleter('entryIdBreakdown','ac2update','/hms/hms/hes?method=getEquipmentBreakdown',{parameters: 'requiredField=entryIdBreakdown&searchEntryNo=<%=entryNo%>'});
			</script>
				</td>
<input type="image" name="button" class="button" value="Search"	onClick="submitForm('searchEquipBreakdown','/hms/hms/hes?method=searchEquipmentBreakdownEntry');" />
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<%-------------------- End of Search Panel ---------------------------%>
<div class="titleBg">
<h4><font color="red"></>Details of Equipment Breakdown for searched Entry No.</font></h4>
</div>

<div class="clear"></div>	
     <div class="Block">
     <!-- <label> Entry No: </label>  -->
     <%
     if(equipmentBreakdownList.size()>0){
    	 
    // HesEquipmentMaster hesEquipmentMaster=new HesEquipmentMaster();
    // for (Iterator iterator = assessoryList.iterator(); iterator.hasNext();) {
			//Object[] object = (Object[]) iterator.next();
			//hesEquipmentMaster=(HesEquipmentMaster)object[1];
     //}
     for (HesEquipmentBreakdownEntry hesEquipmentBreakdown: equipmentBreakdownList){ %>

     <%-- <input type="text"
	name="<%=entryNo %>"
	value="<%=hesEquipmentBreakdown.getEntryNo()%>" id="entryNo" readonly="readonly" class="textbox_size20"
	MAXLENGTH="10"/  > --%>
	
	<label> Date: </label> <input type="text"
	name="<%=RequestConstants.FROM_DATE %>"
	value="<%=hesEquipmentBreakdown.getDate()%>" id="date" readonly="readonly" class="textbox_size20"
	MAXLENGTH="10"/  >
	
	<label> Equipment Name: </label> 
	<input type="text"
	name="<%=euipmentName %>"
	value="<%=hesEquipmentBreakdown.getEquipmentMaster().getEquipmentName() %>" id=EquipmentName readonly="readonly" class="textbox_size20"
	MAXLENGTH="10"/  >
	
	
	
	<label> Nature Of Breakdown: </label> <input type="text"
	name="<%=natureOfBreakdown %>"
	value="<%=hesEquipmentBreakdown.getNatureOfBreakdown()%>" id="natureOfBreakdown" readonly="readonly" class="textbox_size20"
	MAXLENGTH="10"/ >
	<div class="clear"></div>
	
	<label> Date Of Breakdown: </label> <input type="text"
	name="<%=dateOfBreakdown %>"
	value="<%=hesEquipmentBreakdown.getDateOfBreakdown()%>" id="dateOfBreakdown" readonly="readonly" class="textbox_size20"
	MAXLENGTH="10"/  >
	
	<label> Time Of Breakdown: </label> <input type="text"
	name="<%=timeOfBreakdown %>"
	value="<%=hesEquipmentBreakdown.getTimeOfBreakdown()%>" id="timeOfBreakdown" readonly="readonly" class="textbox_size20"
	MAXLENGTH="10"/  >
	
		<label>Call Submitted To: </label> <input type="text"
	name="<%=empIdTo %>" value=" <%=hesEquipmentBreakdown.getEmployeeTo().getFirstName()+" "+hesEquipmentBreakdown.getEmployeeTo().getLastName()%>"
	id="empIdTo" readonly="readonly" class="textbox_size20"
	MAXLENGTH="10" />
	<div class="clear"></div>
	
    <label>Call Submitted By: </label> <input type="text"  id="empIdFrom" 
	name="<%=empIdFrom %>" value="<%=hesEquipmentBreakdown.getEmployeeFrom().getFirstName()+" "+hesEquipmentBreakdown.getEmployeeFrom().getLastName() %>"
     readonly="readonly" class="textbox_size20"
	MAXLENGTH="10" />

	
	<label>Remarks</label>
    <td><textarea
	name="cremarks"
	id="cremarks" readonly="readonly" 
	MAXLENGTH="10" ><%=hesEquipmentBreakdown.getRemarks()%></textarea></td>
	
	
	
	<%}
     }
     %>


	</div>
	
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


<!--Block one Ends-->

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>


<input type="button" name="sss" align="right" class="button" value="Submit"
 onclick="submitForm('equipmentEmergencyBreakdownEntryForm','hes?method=submitEmergencyEquipmentBreakdownEntryJsp');" />

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<!--Bottom labels starts-->

<div class="bottom"><input type="hidden" name="lastChgBy" value="<%=userName%>" /> 
<input type="hidden" name="lastChgDate" value="<%=currentDate%>" /> 
<input type="hidden" name="lastChgTime" value="<%=currentTime%>" /> 
<label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=currentDate%></label> 
<label>Changed Time</label> <label class="value"><%=currentTime%></label>
</div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>




<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script><input type="hidden" name="rows" id="rr" value="1" />
<!--Bottom labels ends--> <!--main content placeholder ends here--></form>
<div class="clear"></div>
<div class="paddingTop40"></div>
	