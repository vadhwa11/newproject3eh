<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.BloodStockDetail"%>
<%@page import="jkt.hms.masters.business.BloodReactionEntry"%>
<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/animatedcollapse.js"></script>
<script type="text/javascript" src="/hms/jsp/js/tabcontent.js">
	/***********************************************
	* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
	* This notice MUST stay intact for legal use
	* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
	***********************************************/
	</script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">

animatedcollapse.addDiv('title1', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('title2', 'fade=0,speed=400,group=pets,persist=1,hide=1')

animatedcollapse.init()

</script>
<script>
	function changeClass(title,t)
	{
	animatedcollapse.toggle(title,t);
	}
	</script>
	
	<script language="javascript">
		function addRow(tableID) {
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;
			var row = table.insertRow(rowCount);
			var colCount = table.rows[0].cells.length;
			
			for (var i = 0; i < colCount; i++) {
				var newcell = row.insertCell(i);
				newcell.innerHTML = table.rows[0].cells[i].innerHTML;
				switch (newcell.childNodes[0].type) {
				case "text":
					newcell.childNodes[0].value = "";
					break;
				case "checkbox":
					newcell.childNodes[0].checked = false;
					break;
				case "select-one":
					newcell.childNodes[0].selectedIndex = 0;
					break;
				}
			}
		}
		function deleteRow(tableID) {
			try {
				
				var table = document.getElementById(tableID);
				var rowCount = table.rows.length;
				
				for (var i = 0; i < rowCount; i++) {
					var row = table.rows[i];
					
					var chkbox = row.cells[0].childNodes[0];
					alert(chkbox);
					if (null != chkbox && true == chkbox.checked) {
						
						if (rowCount <= 1) {
							
							alert("Cannot delete all the rows.");
							break;
						}
						
						table.deleteRow(i);
						rowCount--;
						i--;
					}
				}
			} catch (e) {
				alert(e);
			}
		}
	</script>
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
	int pageNo=1;
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Set<Inpatient> inpatientSet = new HashSet<Inpatient>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	StringTokenizer st = new StringTokenizer(time);
	String currentTime[] =time.split(":");
	String time1 =currentTime[0]+":"+currentTime[1];
	String userName="";
	int hospitalId=0;
	int BloodhdId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
		}
		if(map.get("detailsMap") != null){
		detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		if (session.getAttribute("userName") != null) {
			  userName = (String) session.getAttribute("userName");
		}
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<BloodStockDetail> stockList = new ArrayList<BloodStockDetail>();
		BloodReactionEntry bloodReactionEntry = new BloodReactionEntry();
		List<BloodReactionEntry> reactionList = new ArrayList<BloodReactionEntry>();
		if(map.get("reactionList") != null){
			reactionList =(List)map.get("reactionList");
		}
		if(reactionList != null && reactionList.size()>0){
			bloodReactionEntry = reactionList.get(0);	
		}
		int hinId=0;
		if(bloodReactionEntry.getHin()!=null){
			hinId = bloodReactionEntry.getHin().getId();			
		}
		int reactionId=0;
		if(map.get("reactionId") != null){
			reactionId =(Integer)map.get("reactionId");
		}
		if(map.get("inpatientList") != null){
			inpatientList= (List<Inpatient>)map.get("inpatientList");
		}
		if(map.get("bloodGroupList") != null){
			bloodGroupList= (List<MasBloodGroup>)map.get("bloodGroupList");
		}
		if(map.get("employeeList") != null){
			employeeList= (List<MasEmployee>)map.get("employeeList");
		}
		if(map.get("stockList") != null){
			stockList= (List<BloodStockDetail>)map.get("stockList");
		}
%>
<!--main content placeholder starts here-->
<form name="bloodReaction" method="post" action="">
<div class="titleBg">
<h2>Blood Reaction Form Details</h2>
</div>
<div class="clear"></div>

<div class="clear"></div>

<div class="clear"></div>

<div class="Block">
<div class="clear"></div>
<h4>Patient Details</h4>
<label>UID</label>
 <input id="bloodBagNo"
	name="<%=BLOOD_BAG_NO %>" type="text" value=""
	onblur="ajaxFunctionForBagNoReaction(bloodReaction);" />
	
	<label>Patient Name</label>
 <input id="bloodBagNo"
	name="<%=BLOOD_BAG_NO %>" type="text" value=""
	onblur="ajaxFunctionForBagNoReaction(bloodReaction);" />
	
	<label>Gender</label>
 <input id="bloodBagNo"
	name="<%=BLOOD_BAG_NO %>" type="text" value=""
	onblur="ajaxFunctionForBagNoReaction(bloodReaction);" />
	<div class="clear"></div>
	
	 
	 <label>IP Number</label>
 <input id="bloodBagNo"
	name="<%=BLOOD_BAG_NO %>" type="text" value=""
	onblur="ajaxFunctionForBagNoReaction(bloodReaction);" />
	
	 <label>Blood Group</label>
 <input id="bloodBagNo"
	name="<%=BLOOD_BAG_NO %>" type="text" value=""
	onblur="ajaxFunctionForBagNoReaction(bloodReaction);" />
	
	<label>Mobile Number</label>
 <input id="bloodBagNo"
	name="<%=BLOOD_BAG_NO %>" type="text" value=""
	onblur="ajaxFunctionForBagNoReaction(bloodReaction);" />
	
	<div class="clear"></div>
	
	<label>Unit</label>
 <input id="bloodBagNo"
	name="<%=BLOOD_BAG_NO %>" type="text" value=""
	onblur="ajaxFunctionForBagNoReaction(bloodReaction);" />
	
	<label>Ward</label>
 <input id="bloodBagNo"
	name="<%=BLOOD_BAG_NO %>" type="text" value=""
	onblur="ajaxFunctionForBagNoReaction(bloodReaction);" />
	<label>Bed Number </label>
 <input id="bloodBagNo"
	name="<%=BLOOD_BAG_NO %>" type="text" value=""
	onblur="ajaxFunctionForBagNoReaction(bloodReaction);" />
	<div class="clear"></div>

<label>Doctor Name</label> 
<input id="issueTime"
	name="<%=ISSUED_TIME %>" type="text" value=""
	onKeyUp="mask(this.value,this,'2',':');" validate="Issue Time,time,yes"
	maxlength="5" onBlur="IsValidTime(this.value,this.id);" />

<div class="clear"></div>
<h4> Details</h4>
<div class="clear"></div>

<label> Blood Bag Number</label> 

<select id="matchedId"
	name=<%=CROSS_MATCHED_BY %> validate="Cross Matched By,string,no">
	<option value="0">Select</option>
</select>

<label><span>*</span> Issue Date</label> 
	<input type="text" class="date"
	id="fromDateId" name="<%=ISSUED_DATE %>" value="" readonly="readonly"
	MAXLENGTH="30" validate="Issue Date,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.bloodReaction.<%=ISSUED_DATE%>,event)" />

<label>Issued By</label> 

<select id="matchedId"
	name=<%=CROSS_MATCHED_BY %> validate="Cross Matched By,string,no">
	<option value="0">Select</option>
</select>

<div class="clear"></div>
<label>Cross Match By</label> 

<select id="matchedId"
	name=<%=CROSS_MATCHED_BY %> validate="Cross Matched By,string,no">
	<option value="0">Select</option>
</select>

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>


<label class="auto">Temperature of patient Before Transfusion</label>
 <input id="tempTransfussion" name="<%=TEMP_TRANSFUSSION %>"
	value="" type="text" maxlength="25"
	validate="Temperature of patient Before Transfusion,string,yes" /> 
	
<label>Date of Transfusion</label> <input type="text" class="date" id="fromDateId"
	name="<%=TRANSFUSSION_DATE %>" value="" readonly="readonly"
	MAXLENGTH="30" vvalidate="Date of Transfusion,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.bloodReaction.<%=TRANSFUSSION_DATE%>,event)" />
<div class="clear"></div>

<label>  Time Started</label> 
<input class="small"
	id="startedTime" name="<%=STARTED_TIME %>" type="text" value=""
	onKeyUp="mask(this.value,this,'2',':');"
	validate=" Time Started,time,no" maxlength="5"
	onBlur="IsValidTime(this.value,this.id);" /> <label class="small">hrs</label>

<label>Time Completed</label> <input class="small" id="completedTime"
	name="<%=COMPLETED_TIME %>" type="text" value=""
	onKeyUp="mask(this.value,this,'2',':');"
	validate="Time Completed,time,no" maxlength="5"
	onBlur="IsValidTime(this.value,this.id);" /> <label class="small">hrs</label>
<div class="clear"></div>

<h4>Reactions</h4>

<div class="clear"></div>
<div class="clear"></div>

	
	
	<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" value="Add"
	onclick="addRow('dataTable')"
	align="right" /> 
	
	<input type="button" class="buttonHighlight"
	name="Reset" id="reset" value="Delete"
	onclick="deleteRow('dataTable')" accesskey="r" />
	
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>	
	
<table id="" width="100%" border="0" cellspacing="0" cellpadding="0">
 <thead>
		<tr>
			<th>Serial Number</th>
			<th>Reaction</th>
			<th> </th>
		</tr>
	</thead>
	</table>

<table id="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">

	<tbody>
		<%-- <%

	int inc=0;
	for(inc=1;inc<=4;inc++){
 %>
 --%>
		<tr>
			<%-- <td width="5%"><input type="text" size="2" value="<%=inc%>"
				name="<%=SR_NO%>" readonly="readonly" /> <input type="hidden"
				align="right" name="smainId" id="stockMainId1<%=inc%>" value="" /></td>
 --%>
 		
 			<td>
 			<%-- <input type="text" size="40" id="componentName<%=inc%>"
				name="bloodComponentName" onblur="if(fillSrNo('<%=inc %>')){checkForComponentCode(this.value, '<%=inc %>');}" /> --%>
 			<input id="" type="text"
				name="<%=BLOOD_BAG_NO%>" value="1" size="35" MAXLENGTH="45"
				tabindex=1 readonly="readonly" />
 			
 			</td>
			<td><input id="" type="text"
				name="<%=BLOOD_BAG_NO%>" value="" size="20" MAXLENGTH="45"
				tabindex=1 readonly="readonly" /></td>
				
			<%-- <td><input type="hidden" value="" name="<%=BLOOD_COMPONENT_ID%>"
				id="" /> <input type="text" align="right"
				name="componentCode" id="componentCode" value=""
				readonly="readonly" /></td> --%>

			
<!-- 
			<div id="ac2update" style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
	  new Ajax.Autocompleter(document.getElementById('componentName'),'ac2update','bloodBank?method=getComponentNameSeparationForAutoComplete',{parameters:'requiredField=bloodComponentName'});
			</script></td> -->
			<%-- <td><input type="text" id=""
				name="<%=QUANTITY %>" value="" validate="Qty,int,no" MAXLENGTH="3" />
			</td> --%>
			<td><input name="chk" type="checkbox" size="5" id="chk"></td>
			
		</tr>
		<%-- <%} %> --%>
		<%-- <input type="hidden" name="counter" id="counter" value="<%=inc %>" /> --%>
	</tbody>
</table>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>

<h4>Vitals</h4>

<div class="clear"></div>
<div class="clear"></div>

 <label class="medium">Temperature</label> <input
	type="text" class="small" name="" value=""
	validate="Temp,float,no" maxlength="5" tabindex="1" /> 
	<label class="small">°F</label> 
	
<label >Pulse</label> <input
	type="text" class="small" name="" value=""
	validate="Pulse,flat,no" maxlength="6" tabindex="1" /> 
	
	<label class="small">Per Minute</label>
	
	<label class="medium">BP</label> 
	<input type="text" class="small" name="" value="" validate="BP,string,no" maxlength="3"
	tabindex="1" /> 
	<input type="text" class="small" name="" value="/" validate="BP,string,no" maxlength="3"
	tabindex="1" /> 
	<input type="text" class="small" name="" value="" validate="BP,string,no" maxlength="3"
	tabindex="1" /> 
	<label class="small">mm Hg</label>
	<div class="clear"></div>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
	Systolic
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;
	Diatolic
	
	<label class="medium">Remarks</label>
	 <textarea rows="4" cols="50">
 
</textarea> 
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>

<input type="button" class="button" value="Submit"
	onclick="submitForm('bloodReaction','bloodBank?method=submitBloodReactionEntry');"
	align="right" /> <input type="reset" class="buttonHighlight"
	name="Reset" id="reset" value="Reset"
	onclick="resetClicked('bloodReaction',);" accesskey="r" />
	
</div>

<div class="clear"></div>
<div class="clear"></div>

<div class="paddLeft25">


<div class="clear"></div>

<div class="paddLeft25">


<div class="clear"></div>


<div class="clear"></div>


<div class="clear"></div>
</div>
</div>
<!--Bottom labels starts-->
<div class="clear"></div>
<div class="division"></div>

<div class="clear"></div>


<div class="division"></div>
<div class="bottom">

<label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=currentDate%></label>

<label>Changed Time</label> <label class="value"><%=time%></label>
<div class="clear"></div>
</div>
<!--Bottom labels ends-->
<div class="clear"></div>
<div class="clear"></div>
<div class="paddingTop40"></div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<!--Bottom labels starts-->
<!--main content placeholder ends here-->


<script type="text/javascript">
			function checkBloodBag(obj){	
		<%		
		if(stockList != null && stockList.size() > 0){
				for (BloodStockDetail bloodStockDetail : stockList) {%>
								var invObj =<%= bloodStockDetail.getBloodBagNo()%>
								
								if(invObj != obj){
								alert("Blood Bag No. is not available");
 								document.getElementById('bloodBagNo').value=""
 							}
 		<%} } %>
 		}
 </script>