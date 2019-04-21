
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.HesEquipmentMaster"%>
<%@page import="jkt.hms.util.Box"%>


<%@page import="jkt.hms.masters.business.MasStoreSupplierGroup"%>
<%@page import="jkt.hms.masters.business.HesEquipmentAmcDetailsEntry"%>
<%@page import="jkt.hms.util.RequestConstants"%><script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
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
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<HesEquipmentMaster> equipmentMasList = new ArrayList<HesEquipmentMaster>();
	List<MasStoreSupplierGroup> supplierGroupList = new ArrayList<MasStoreSupplierGroup>();
	List<HesEquipmentAmcDetailsEntry> amcDetailsList = new ArrayList<HesEquipmentAmcDetailsEntry>();
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
    String url = "";
    Box box = HMSUtil.getBox(request);
	String entryNo = "";
	String userName = "";
	int departmentId = 0 ;

	if(request.getAttribute("map") != null)
	{
		map = (Map<String ,Object>) request.getAttribute("map");
	}
	   
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	
	if (map.get("departmentList")!= null){
		departmentList = (List<MasDepartment>)map.get("departmentList");
	}
	
	if (map.get("equipmentMasList")!= null){
		equipmentMasList = (List<HesEquipmentMaster>)map.get("equipmentMasList");
	 }
	
	if(map.get("supplierGroupList")!=null){
		supplierGroupList=(List<MasStoreSupplierGroup>)map.get("supplierGroupList");	
	}

	if(map.get("amcDetailsList")!=null){
		amcDetailsList=(List<HesEquipmentAmcDetailsEntry>)map.get("amcDetailsList");
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
      
<form name="equipmentAmcSearchForm" method="post"">

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

  <label>Date </label> <input type="text" name="<%=RequestConstants.FROM_DATE%>"
	value="<%=currentDate %>" class="date" maxlength="30" tabindex=1 /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.equipmentAmcSearchForm.<%= RequestConstants.FROM_DATE%>,event);" />
	
<label>Equipment Name :</label>
<select name="searchEquipment">
	<option value="0" >-Select Equipment Name-</option>
<%
		for (HesEquipmentAmcDetailsEntry hesEquipmentAmcMaster : amcDetailsList )
		{
%>
			<option value=<%=hesEquipmentAmcMaster.getEpuipment().getId()%>><%=hesEquipmentAmcMaster.getEpuipment().getEquipmentName()%></option>
<%
		}
%>
</select>          
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<input type="image" src="/hms/jsp/images/go.gif" class="button"
	onClick="submitForm('equipmentAmcSearchForm','hes?method=searchEquipmentBreakdownForm');" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</div>
<div class="clear"></div>

<!--main content placeholder starts here-->
<div class="titleBg">
<h2>Equipment AMC Details Entry</h2>
</div>
<div class="clear"></div>
<!--Block One Starts-->
<form name="equipmentAmcDetailsSubmitForm" method="post">
<div class="Block">
<!-- Commented by amit when department is not required from front end -->
<label><span>*</span>Department Name</label>
<select name="deptId" id="deptId" validate="Department Name,String,yes" tabindex=1 >
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

<label><span>*</span>Equipment Name</label>
<select name="equipmentId" id="equipmentId" validate="Equipment Name,String,yes" tabindex=1 onchange="submitProtoAjaxWithDivName('equipmentAmcDetailsSubmitForm','hes?method=getEquipmentAMCDetails','masEquipmentAMC')">
	<option value="0">-Select Equipment Name-</option>
<%
		for (HesEquipmentMaster hesEquipmentMaster : equipmentMasList )
		{
%>		
  			<option value=<%=hesEquipmentMaster.getId()%>><%=hesEquipmentMaster.getEquipmentName()%></option>
			<%-- <option value="<%=hesEquipmentMaster.getId() %>"
		    <%=HMSUtil.isSelected(hesEquipmentMaster.getId(),Integer.valueOf(box.getInt("equipmentId")))%>><%=hesEquipmentMaster.getEquipmentName()%></option>--%>
<%
		}
%>
</select>


<%-- <script type="text/javascript">

<%
    int counter = 0;
	for (MasDepartment masDepartment : departmentList){
	for (HesEquipmentMaster equipmentMaintenance : equipmentList) {
		
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
</script> --%>

<div id="masEquipmentAMC">
<label>Serial No</label>

<select name="serialNo" id="serialNo" validate="Serial No,String,yes" tabindex=1>
	<option value=" ">-Select Serial No-</option>

</select>

<div class="clear"></div>

<label>Date Of Installation</label>
<input type="text" name="<%=RequestConstants.TO_DATE %>" value="" id="dateOfInstallation"  
	MAXLENGTH="15"  readonly="readonly"/>

<%-- <input type="text"
	name="<%=RequestConstants.TO_DATE%>" value="<%=currentDate %>" class="date"
	readonly="readonly" validate="Pick a date"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onclick="javascript:setdate('<%=currentDate%>',document.equipmentAmcDetailsSubmitForm.<%=RequestConstants.TO_DATE%>,event)" />  --%>

<label>Warranty Start Date</label> 
<input type="text" name="warentySdate" value="" id="warentySdate"  
	MAXLENGTH="15"  readonly="readonly" />

<label>Warranty End Date</label>
<input type="text" name="warentyEdate" value="" id="warentyEdate"  
	MAXLENGTH="15"  readonly="readonly" onchange="setAndReset(this);"/>
 
<div class="clear"></div>
<!-- <label>Remarks</label>	
<textarea name="remarks" id="remarks" size="25" readonly="readonly" value=""> </textarea> -->
</div>
<div class="clear"></div>

<!-- <label>Warrenty/Amc Type</label>
<select name="AmcWarenty" id="AmcWarenty" validate="Amc Warrenty Type,String,yes" tabindex=1>
	<option value="0">-Select Warrenty/Amc Type-</option>
	<option value="1">Amc Type</option>
	<option value="2">Warrency Type </option>
</select>  -->

<!-- Code start for AMC HEADER -->
<div class="division"></div>
 <div class="titleBg">
<h2>Insert details for Equipment AMC</h2>
</div>
<div class="tableHolderAuto">
<div class="cmntable">
<table  border="0" cellspacing="0" cellpadding="0" id="amcMasterId">
	<tr>
		<th scope="col">AMC Company</th>
		<th scope="col">AMC Date From</th>
		<th scope="col">AMC Date To</th>
		<th scope="col">Cost of AMC</th>
		<th scope="col">Adv.Bill No.</th>
		<th scope="col">Adv.Bill Date</th>
		<th scope="col">Adv. Bill Amount</th>
		<th scope="col">Balance Bill No.</th>
		<th scope="col">Balance Bill Date</th>
		<th scope="col">Balance Bill Amount</th>
		<th scope="col">Remarks</th>
	</tr>
	    <td width="5%">
	    	<select name="companyId" id="companyId" validate="AMC Company Name,String,yes">
				<option value="0">Select AMC Company</option>
		<%
			for(MasStoreSupplierGroup masSupGroup : supplierGroupList){
			%>
	            <option value=<%=masSupGroup.getId()%>><%=masSupGroup.getSupplier().getSupplierName() %></option>
	   <%}%>
	    </td> 
	    <td width="25%">
	    <input type="text"
			name="<%=RequestConstants.ON_DATE%>" value="<%=currentDate %>" size="10" class="date"
			readonly="readonly" validate="Pick a date"
			 /> <img src="/hms/jsp/images/cal.gif" width="25"
			height="16" border="0" validate="Pick a date"
			onclick="javascript:setdate('<%=currentDate%>',document.equipmentAmcDetailsSubmitForm.<%=RequestConstants.ON_DATE%>,event)" />
	    </td>
	    <td width="15%">
	    	<input type="text"
			name="<%=RequestConstants.AMC_END_DATE%>" value="<%=currentDate %>" class="date"
			readonly="readonly" validate="Pick a date"
			MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
			height="16" border="0" validate="Pick a date"
			onclick="javascript:setdate('<%=currentDate%>',document.equipmentAmcDetailsSubmitForm.<%=RequestConstants.AMC_END_DATE%>,event)" />
	    </td>
	    
	    <td width="10%"><input type="text" name="costOfAmc" id="costOfAmc" size="15"/></td>
	    
	    <td width="10%"><input type="text" name="advBillNo" id="advBillNo" size="15"/></td>
	    
	    	 <td width="15%">
	    	<input type="text"
			name="<%=RequestConstants.ADVANCE_BILL_DATE%>" value="<%=currentDate %>" class="date"
			 validate="Pick a date"
			MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
			height="16" border="0" validate="Pick a date"
			onclick="javascript:setdate('<%=currentDate%>',document.equipmentAmcDetailsSubmitForm.<%=RequestConstants.ADVANCE_BILL_DATE%>,event)" />
	    </td>
	    
	    <td width="10%"><input type="text" name="advBillAmt" id="advBillAmt" size="10"/></td>
	    <td width="10%"><input type="text" name="balBillNo" id="balBillNo" size="15"/></td>
	    
	    	 <td width="15%">
	    	<input type="text"
			name="<%=RequestConstants.BAL_BILL_DATE%>" value="<%=currentDate %>" class="date"
			 validate="Pick a date"
			MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
			height="16" border="0" validate="Pick a date"
			onclick="javascript:setdate('<%=currentDate%>',document.equipmentAmcDetailsSubmitForm.<%=RequestConstants.BAL_BILL_DATE%>,event)" />
	    </td>
	    
	    <td width="10%"><input type="text" name="balBillAmt" id="balBillAmt" size="15"/></td>
	    <td width="10%"><textarea name="remarks" id="remarks" size="15"> </textarea></td>
	
</table>	
</div>

<%--<select name="companyId" id="companyId" validate="AMC Company Name,String,yes">
<option value="0">Select</option>
<%
			for(MasStoreSupplierGroup masSupGroup : supplierGroupList){
			%>
	            <option value=<%=masSupGroup.getId()%>><%=masSupGroup.getGroup().getGroupName() %></option>
	           
	           
	<%}%>
	
</select>

<input type="text"
	name="<%=RequestConstants.ON_DATE%>" value="<%=currentDate %>" class="date"
	validate="Pick a date"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onclick="javascript:setdate('<%=currentDate%>',document.equipmentAmcDetailsSubmitForm.<%=RequestConstants.ON_DATE%>,event)" />

<input type="text"
	name="<%=RequestConstants.AMC_TO_DATE%>" value="<%=currentDate %>" class="date"
	validate="Pick a date"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onclick="javascript:setdate('<%=currentDate%>',document.equipmentAmcDetailsSubmitForm.<%=RequestConstants.AMC_TO_DATE%>,event)" />

<input type="text" id="amcCost" rows="8" name="amcCost" value=""  > </input>

<input type="text" id="adBillNo" rows="8" name="adBillNo" value=""  > </input>


<input type="text"
	name="<%=RequestConstants.ADDVANCE_BILL_DATE%>" value="<%=currentDate %>" class="date"
	validate="Pick a date"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onclick="javascript:setdate('<%=currentDate%>',document.equipmentAmcDetailsSubmitForm.<%=RequestConstants.ADVANCE_BILL_DATE%>,event)" />

<input type="text" id="adBillAmt" rows="8" name="adBillAmt" value=""  > </input>

<input type="text" id="balBillNo" rows="8" name="balBillNo" value=""  > </input>

<input type="text"
	name="<%=RequestConstants.BAL_BILL_DATE%>" value="<%=currentDate %>" class="date"
	validate="Pick a date"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onclick="javascript:setdate('<%=currentDate%>',document.equipmentAmcDetailsSubmitForm.<%=RequestConstants.BAL_BILL_DATE%>,event)" />

<input type="text" id="adBillAmt" rows="8" name="adBillAmt" value=""  > </input>

<% 
for(HesEquipmentAmcDetailsEntry amcObj2 : amcDetailsList){%>
<textarea id="remarks" rows="8" name="remarks" > <%=amcObj2.getRemarks()%> </textarea>
<%}
%>
  --%>

	
<div class="clear"></div>

</div>
<!--Block one Ends-->


<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>


<input type="button" name="sss" align="right" class="button" value="Submit" onclick="submitForm('equipmentAmcDetailsSubmitForm','hes?method=submitEquipmentAMCDetalis');" />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />

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
<!--Bottom labels ends--> <!--main content placeholder ends here-->
<div class="clear"></div>
<div class="paddingTop40"></div>
