<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.HesEquipmentMaster"%>
<%@page import="jkt.hms.masters.business.HesMaintenanceJobMaster"%>
<%@page import="jkt.hms.util.Box"%>

<%@page import="jkt.hms.masters.business.HesEquipmentMaintenance"%><script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/acnik.js"></script>
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
Box box = HMSUtil.getBox(request);
	String entryNo = "";
	String userName = "";

	if(request.getAttribute("map") != null)
	{
		map = (Map<String ,Object>) request.getAttribute("map");
	}
	
	if (map.get("num")!=null)
		entryNo = (String)map.get("num").toString();

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");

	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<HesEquipmentMaintenance> equipmentList = new ArrayList<HesEquipmentMaintenance>();
	List<HesMaintenanceJobMaster> jobMaintenanceList = new ArrayList<HesMaintenanceJobMaster>();
	List<HesEquipmentMaintenance> entryNoList = new ArrayList<HesEquipmentMaintenance>();
	List<HesEquipmentMaster> hesEqpuipmentMaster = new ArrayList<HesEquipmentMaster>();
	if(map.get("hesEqpuipmentMaster")!=null){
		hesEqpuipmentMaster=(List<HesEquipmentMaster>)map.get("hesEqpuipmentMaster");
	}
	if(map.get("entryNoList")!=null){
		entryNoList=(List<HesEquipmentMaintenance>)map.get("entryNoList");
	}
	List<Object> maintenanceList = new ArrayList<Object>();
	String url = "";

	if (map.get("departmentList")!= null){
		departmentList = (List<MasDepartment>)map.get("departmentList");
	}

	if (map.get("equipmentNameList")!= null){
		equipmentList = (List<HesEquipmentMaintenance>)map.get("equipmentNameList");
	}

	if (map.get("employeeList")!= null){
		employeeList = (List<MasEmployee>)map.get("employeeList");
	}

	if (map.get("jobMaintenanceList")!= null){
		jobMaintenanceList = (List<HesMaintenanceJobMaster>)map.get("jobMaintenanceList");
	}
	
	if(session.getAttribute("userName") != null)
	{
		userName = (String)session.getAttribute("userName");
	}

	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
%>
<!---------------------------------Code for search------------------------->
<form name="hesMaintenanceEntrySearchForm" method="post"">
<div class="clear"></div>
<div class="search" id="threadsearch"><a href=""></a> <script
	type="text/javascript"> vbmenu_register("threadsearch"); </script></div>
<div class="clear"></div>
<!-- thread search menu -->
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<form action="" method="post">
<input type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" />
<input type="hidden" name="do" value="process" /> <input type="hidden"
	name="searchthread" value="1" /> <input type="hidden" name="showposts"
	value="1" /> <input type="hidden" name="searchthreadid" value="85875" />
<div class="paddingTop15"></div>
<div class="clear"></div>

  <label>Date </label> <input type="text" name="<%=ON_DATE%>"
	value="<%=currentDate %>" class="date" maxlength="30" tabindex=1 /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.hesMaintenanceEntrySearchForm.<%= ON_DATE%>,event);" />
	
<label>Equipment Name :</label>
<select name="searchEquipment">
	<option value="0" >-Select Equipment Name-</option>
<%
		for (HesEquipmentMaintenance hesEquipmentMaintenance : entryNoList  )
		{
%>
			<option value=<%=hesEquipmentMaintenance.getEquipment().getId()%>><%=hesEquipmentMaintenance.getEquipment().getEquipmentName()%></option>
<%
		}
%>
</select>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>


<label>Entry No :</label> <select name="searchEntryNo">
	<option value="0" >-Select Entry No-</option>
<%
		for (HesEquipmentMaintenance hesEquipmentMaintenance : entryNoList )
		{
%>
			<option value=<%=hesEquipmentMaintenance.getEntryNo()%>><%=hesEquipmentMaintenance.getEntryNo()%></option>
<%
		}
%>
</select> 
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<input type="image" src="/hms/jsp/images/go.gif" class="button"
	onClick="submitForm('hesMaintenanceEntrySearchForm','hes?method=searchEquipmentMaintenanceForm');" />
	
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</div>
<div class="clear"></div>

<!--main content placeholder starts here-->
<h2>Preventive Maintenance Entry</h2>
</div>
<div class="clear"></div>
<!--Block One Starts-->
<form name="equipmentPreventMaintenanceEntryForm" method="post">
<div class="Block">
<label><span>*</span>Entry No.</label>
<input type="text" id="entryNo" name="entryNo" value="<%=entryNo%>" tabindex=1 readonly="readonly" />

<label>Date</label>
<input type="text" name="<%=FROM_DATE%>"
	value="<%=currentDate %>" class="date" maxlength="30" tabindex=1 /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.equipmentPreventMaintenanceEntryForm.<%= FROM_DATE%>,event);" />
<label><span>*</span>Department Name</label>
<select name="deptId" id="deptId" validate="Department Name,String,yes" tabindex=1 onchange="populateDepartment(this.value,'equipmentPreventMaintenanceEntryForm');">
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
<label><span>*</span>Assigned To </label>
<select name="empId" id="empId" validate="Employee Name,String,yes">
<option value="0">Select</option>
<%
			for(MasEmployee masEmployee : employeeList){
			%>
	      <option value="<%=masEmployee.getId() %>"
		<%=HMSUtil.isSelected(masEmployee.getId(),Integer.valueOf(box.getInt("empId")))%>><%=masEmployee.getFirstName()+""+masEmployee.getLastName()%></option>
	<%}
%>
	</select>
	


<label><span>*</span>Equipment Name</label>
<select name="equipmentId" id="equipmentId" validate="Equipment Name,String,yes" tabindex=1>
	<option value="0">-Select Equipment Name-</option>
<%
		for (HesEquipmentMaster hesEquipmentMaster : hesEqpuipmentMaster )
		{
%>		
			<option value="<%=hesEquipmentMaster.getId() %>"
		<%=HMSUtil.isSelected(hesEquipmentMaster.getId(),Integer.valueOf(box.getInt("equipmentId")))%>><%=hesEquipmentMaster.getEquipmentName()%></option>
<%
		}
%>
</select>

<script type="text/javascript">

<%
    int counter = 0;
	for (MasDepartment masDepartment : departmentList){
	for (HesEquipmentMaster equipmentMaintenance : hesEqpuipmentMaster) {
		
	if(equipmentMaintenance.getDepartment() != null){
	if(masDepartment.getId().equals(equipmentMaintenance.getDepartment().getId() )){
			%>
			departmentArray[<%=counter%>] = new Array();
			departmentArray[<%=counter%>][0]=<%=masDepartment.getId()%>;
			departmentArray[<%=counter%>][1] = <%=equipmentMaintenance.getId()%>;
			departmentArray[<%=counter%>][2] = "<%=equipmentMaintenance.getEquipmentName()%>";
				<%
	counter++;
	} } } }
%>
</script>
<label><span>*</span>Maintenance Job Name</label>
<select name="maintenanceId" id="maintenanceId" validate="Maintenance Job Name,String,yes" tabindex=1>
	<option value="0">-Select Maintenance Job Name-</option>
<%
		for (HesMaintenanceJobMaster hesMaintenanceJobMaster : jobMaintenanceList )
		{
%>
			<option value=<%=hesMaintenanceJobMaster.getId()%>><%=hesMaintenanceJobMaster.getMaintenanceName()%></option>
<%
		}
%>
</select>

<label>Schedule Date</label>

<input type="text"
	name="<%=TO_DATE%>" value="<%=currentDate %>" class="date"
	readonly="readonly" validate="Pick a date"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onclick="javascript:setdate('<%=currentDate%>',document.equipmentPreventMaintenanceEntryForm.<%=TO_DATE%>,event)" />

<label>Schedule Time</label>
<input type="text" name="<%=DELIVERY_TIME%>" value="<%=currentTime %>"  validate="Schedule Time,deliveryTime,yes"
	MAXLENGTH="30" /> 
	
	
	
<div class="clear"></div>

</div>
<!--Block one Ends-->


<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>


<input type="button" name="sss" align="right" class="button" value="Submit"
 onclick="submitForm('equipmentPreventMaintenanceEntryForm','hes?method=submitEquipmentMaintenanceEntryJsp');" />

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
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<!--Bottom labels ends--> <!--main content placeholder ends here--></form>
<div class="clear"></div>
<div class="paddingTop40"></div>
