<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.BloodMasComponent"%>
<%@page import="jkt.hms.masters.business.BloodOpeningStockMain"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<link href="css/hms_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
	animatedcollapse.addDiv('slide1', 'fade=0,speed=400,group=pets')
	animatedcollapse.addDiv('slide2', 'fade=0,speed=400,group=pets,persist=1,hide=1')	
	animatedcollapse.init()
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

	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date=(String)utilMap.get("currentDate");
	String time=(String)utilMap.get("currentTime");
	
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<BloodMasComponent> componentList = new ArrayList<BloodMasComponent>();
	List<BloodOpeningStockMain> openingStockList = new ArrayList<BloodOpeningStockMain>();
	List<Patient> patientList = new ArrayList<Patient>();
	List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
	
	String userName="";
	
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	if (session.getAttribute("userName") != null) {
		  userName = (String) session.getAttribute("userName");
	}
	if(map.get("employeeList") != null){
		employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	if(map.get("componentList") != null){
		componentList = (List<BloodMasComponent>)map.get("componentList");
	}
	if(map.get("openingStockList") != null){
		openingStockList = (List<BloodOpeningStockMain>)map.get("openingStockList");
	}
	BloodOpeningStockMain bloodOpeningStockMain = new BloodOpeningStockMain();
	if(openingStockList.size() > 0){
		bloodOpeningStockMain=(BloodOpeningStockMain) openingStockList.get(0);
	}
	
	if(map.get("bloodGroupList") != null){
		bloodGroupList = (List<MasBloodGroup>)map.get("bloodGroupList");
	}
	
	if(map.get("patientList") != null){
		patientList = (List<Patient>)map.get("patientList");
	}
	String message ="";

	if (map.get("message") != null) {
             message = (String) map.get("message");
      }
	if(!message.equalsIgnoreCase("")){
	%>
<h4><span><%=message %></span></h4>

<%} %>
<form name="openingBalance" method="post" action="">
<div class="titleBg">
<h2>Blood Stock Opening Balance Entry</h2>
</div>
<%
		String stockSeqNo="";
		if(map.get("stockSeqNo") != null){
			stockSeqNo = (String)map.get("stockSeqNo");
		}
		
%>
<div class="Block">
<input id="currentDateId" type=hidden
	name="<%=CURRENT_DATE %>" value="<%=date %>" title="Current date" /> <label>Opening
No.</label> <label class="value"><%=1 %></label> <input id="openingId"
	type=hidden name="<%=STOCK_NO %>" value="<%=1%>" title="Opening No" />
<label>Date</label> <input type="text" class="date" id="dateId"
	name="<%=DATE %>" value="<%=date %>" validate="Date,date,yes"
	MAXLENGTH="10" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=date %>',document.openingBalance.<%=DATE%>,event)" />


<label> <span>*</span> Approved By </label> <select id="employeeId"
	name=<%=EMPLOYEE_ID %> validate="Approved By,string,yes">
	<option value="0">Select</option>

	<%
				         		if(employeeList != null){ 	
				         			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
				         				MasEmployee masEmployee = (MasEmployee) iter.next();
				         %>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+ " "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()%></option>
	<%		} } %>
</select>
<div class="clear"></div>
<label>Remarks</label>
<textarea class="comorBiditylarge" maxlength="1024" rows="0" cols="0" name="<%= REMARKS%>" value="" validate="Remarks,string,no" tabindex=1 style="width: 332px;"></textarea>

<div class="clear"></div>
<h4>Blood Donor Details</h4>

<label>Blood Bag No. <span>*</span></label> 
<input	type="text" id="bloodBagNo" name="<%= BLOOD_BAG_NO%>" value=""	validate="Blood Bag No.,int,yes" class="textbox_size20" maxlength="15" tabindex=1 /> 
<label>Date of Collection <span>*</span></label> 
<input	type="text" class="date" id="collDateId" name="<%=COLLECTION_DATE %>"	value="" validate="Date Of Collection,string,yes" readonly="readonly"	MAXLENGTH="30" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"	onClick="setdate('<%=date%>',document.getElementById('collDateId'),event)" />

<label>Blood Component Name <span>*</span></label> 
<select	id="bloodComponentId" name=<%=BLOOD_COMPONENT_ID %>validate="Blood Component Name,string,yes" onblur="fillComponentDetail(this.value);">
<option value="0">Select</option>
	<%
        		if(componentList != null){ 	
       			for (Iterator iter = componentList.iterator(); iter.hasNext();) {
   				BloodMasComponent masComponent = (BloodMasComponent) iter.next();
				         %>
	<option value="<%=masComponent.getId() %>"><%=masComponent.getComponentName()%></option>
	<%} } %>
</select> 
<script type="text/javascript">
			function fillComponentDetail(obj){	
		<%		
		if(componentList != null && componentList.size() > 0){
				for (BloodMasComponent component : componentList) {%>
								var invObj =<%=component.getId()%>
								if(invObj == obj){
	 							document.getElementById('qty').value="<%=component.getQtyUnit()%>"
 							}
 							
 					<%} } %>
 					}
 			</script>
 <div class="clear"></div>			
 <label>Quantity</label> <input type="text" id="qty" name="<%= QUANTITY%>" value="" validate="Qty,int,yes"
 maxlength="3" readonly="readonly" tabindex=1 class="date" style="width:152px;" />
<label class="auto">ml</label>

<label>HIN</label> <input type="text" id="hinNo" name="<%= HIN_NO%>"
	value="" validate="HIN,string,no" tabindex=1 maxlength="20"
	onblur="ajaxFunctionForPatient(openingBalance);" /> <input
	type="hidden" id="hinId" name="<%= HIN_ID%>" value="" /> 
<label>Name <span>*</span></label>
<input type="text" align="right" name="<%=DONER_NAME%>" id="donerName"	value="" maxlength="30" />
<div class="clear"></div>

<label>Date of Expiry <span>*</span></label> 
<input type="text"	class="date" id="expiryDateId" name="<%=EXPIRY_DATE %>" value=""	readonly="readonly" MAXLENGTH="30" validate="Date of Expiry,date,yes" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" onchange="validateExpiryDate();"	onClick="setdate('<%=date %>',document.openingBalance.<%=EXPIRY_DATE%>,event)" />
<label>Blood Group <span>*</span></label>
<select id="bloodGroupId"	name=<%=BLOOD_GROUP_ID %> validate="Blood Group,string,yes">
	<option value="0">Select</option>
	<%
				         		if(bloodGroupList != null){ 	
				         			for (Iterator iter = bloodGroupList.iterator(); iter.hasNext();) {
				         				MasBloodGroup bloodGroup = (MasBloodGroup) iter.next();
				         %>
	<option value="<%=bloodGroup.getId() %>"><%=bloodGroup.getBloodGroupName()%></option>
	<%		} } %>
</select>
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" class="button" value="Submit"	onclick="submitForm('openingBalance','bloodBank?method=submitStockOpeningBalance');"	align="right" /> 
<input type="reset" class="button" name="Reset"	id="reset" value="Reset" onclick="resetClicked('openingBalance');"	accesskey="r" />
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>
<div class="clear"></div>

</div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript" language="javascript">				
				
	function validateExpiryDate(){
	expiryDate = new Date(expiryDateId.substring(6),(expiryDateId.substring(3,5) - 1) ,expiryDateId.substring(0,2));
			 	currentDate = new Date();
				var month = currentDate.getMonth() + 1
				var day = currentDate.getDate()
				var year = currentDate.getFullYear()
				var seperator = "/"
				currentDate = new Date(month + seperator + day + seperator + year);
				if(expiryDate < currentDate)
				{	
					alert("Expiry Date should be greater than Today's date!!");
					document.getElementById('expiryDateId').value="";
					return false;
				}
				else
				{
					return true;
				}
		}
		
	function validateCollectionDate(){
			collDate = new Date(collectionDate.substring(6),(collectionDate.substring(3,5) - 1) ,collectionDate.substring(0,2));
			 	currentDate = new Date();
				var month = currentDate.getMonth() + 1
				var day = currentDate.getDate()
				var year = currentDate.getFullYear()
				var seperator = "/"
				currentDate = new Date(month + seperator + day + seperator + year);
				if(collDate >currentDate)
				{	
					alert("Date Of Collection should be smaller than Today's date!!");
					document.getElementById('collectionDate').value="";
					return false;
				}
				else
				{
					return true;
				}
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
	</script>