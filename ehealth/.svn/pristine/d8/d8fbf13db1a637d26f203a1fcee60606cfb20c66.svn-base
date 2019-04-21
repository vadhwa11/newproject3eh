<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.BloodStockDetail"%>


<form name="discardEntry" method="post" action=""><script>
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
</script> <%

	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date=(String)utilMap.get("currentDate");
	String time=(String)utilMap.get("currentTime");
	
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<BloodStockDetail> stockList = new ArrayList<BloodStockDetail>();
	
	String userName="";
	int deptId = 0;
	int hospitalId = 0;
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	if (session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute("deptId");
	}
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	if (session.getAttribute("userName") != null) {
		  userName = (String) session.getAttribute("userName");
	}
	if(map.get("employeeList") != null){
		employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	if(map.get("stockList") != null){
		stockList=(List)map.get("stockList");
	}
%>
<div class="clear"></div>
<div class="titleBg">
<h2>Blood Discard Entry</h2>
</div>
<div class="clear"></div>
<%
		String discardSeqNo="";
		if(map.get("discardSeqNo") != null){
			discardSeqNo = (String)map.get("discardSeqNo");
		}
%>

<div class="Block"><input id="currentDateId" type=hidden
	name="<%=CURRENT_DATE %>" value="<%=date %>" title="Current date" /> <label>Discard
No.</label> <input id="discardNoId" type=hidden name="<%=DISCARD_NO %>"
	value="<%=discardSeqNo %>" title="Discard Number" /> <label
	class="value"> <%=discardSeqNo %> </label> <label>Discard Date</label>
<input type="text" class="date" id="date1" name="<%=DISCARD_DATE %>"
	value="<%=date %>" validate="Date,date,yes" MAXLENGTH="10" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" onchange="validateDate();"
	onClick="setdate('<%=date %>',document.discardEntry.<%=DISCARD_DATE%>,event)" />


<label>Approved By</label> <select id="employeeId"
	name=<%=APPROVED_BY %> validate="Approved By,string,no">
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

<label>Remarks</label> <input type="text" name="<%= REMARKS%>" value=""
	validate="Remarks,string,no" class="large" MAXLENGTH="50" tabindex=1 />
<input type="hidden" id="hospitalId" name="<%= HOSPITAL_ID%>" value=""
	tabindex=1 readonly="readonly" /> <input type="hidden" name="deptId"
	id="deptId" value="<%=deptId %>" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<h4>Blood Details</h4>
<div class="clear"></div>
<div class="Block">
<%for(BloodStockDetail bldStockDetail:stockList){ %> <label><span>*</span>Blood
Bag No.</label> <input type="text" id="bloodBagNo" name="<%= BLOOD_BAG_NO%>"
	value="<%=bldStockDetail.getBloodBagNo() %>"
	validate="Blood Bag No.,String,yes" tabindex=1 disabled="disabled" /> <input
	type="hidden" id="stockDetailId" name="<%=STOCK_DETAIL_ID%>"
	value="<%=bldStockDetail.getId()%>" /> <label><span>*</span>
Date of Collection</label> <input type="text" id="collDate"
	name="<%= COLLECTION_DATE%>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(bldStockDetail.getStockMain().getCollectionDate()) %>"
	tabindex=1 disabled="disabled" />

<div class="clear"></div>

<label class="auto"><span>*</span> Blood Component Name</label> <input
	type="text" id="componentName" name="<%=BLOOD_COMPONENT_NAME%>"
	value="<%=bldStockDetail.getComponent().getComponentName() %>"
	disabled="disabled" /> <label>Quantity</label> <input type="text"
	id="quantity" name="<%= QUANTITY%>"
	value="<%=bldStockDetail.getQty() %>" class="small" disabled="disabled" />
<labelclass="small">ml</label>

<div class="clear"></div>

<label>Name</label> <%if(bldStockDetail.getStockMain().getHin()!= null){ %>
<input type="text" id="name" name="<%= NAME%>"
	value="<%=bldStockDetail.getStockMain().getHin().getPFirstName() %>"
	disabled="disabled" /> <%}else if(bldStockDetail.getStockMain().getName()!=null){ %>
<input type="text" id="name" name="<%= NAME%>"
	value="<%= bldStockDetail.getStockMain().getName()%>"
	disabled="disabled" /> <%} else{%> <input type="text" id="name"
	name="<%= NAME%>" value="-" disabled="disabled" /> <%} %> <label><span>*</span>
Date of Expiry</label> <%if(bldStockDetail.getStockMain().getExpiryDate()!= null){ %>
<input type="text" id="expiryDate" name="<%= EXPIRY_DATE%>"
	value="<%= HMSUtil.convertDateToStringWithoutTime(bldStockDetail.getStockMain().getExpiryDate())%>"
	disabled="disabled" /> <%} %> <label>Blood Group</label> <%if(bldStockDetail.getStockMain().getHin() != null && bldStockDetail.getStockMain().getHin().getBloodGroup() != null){ %>
<input type="text" id="bloodGroupId" name="<%= BLOOD_GROUP_ID%>"
	value="<%=bldStockDetail.getStockMain().getHin().getBloodGroup().getBloodGroupName() %>"
	disabled="disabled" /> <%} else if(bldStockDetail.getStockMain().getBloodGroup() != null){%>
<input type="text" id="bloodGroupId" name="<%= BLOOD_GROUP_ID%>"
	value="<%=bldStockDetail.getStockMain().getBloodGroup().getBloodGroupName() %>"
	disabled="disabled" /> <%}else{ %> <input type="text" id="bloodGroupId"
	name="<%= BLOOD_GROUP_ID%>" value="" disabled="disabled" /> <%} %> <%} %>
<div class="clear"></div></div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" value="Submit"
	onclick="submitForm('discardEntry','bloodBank?method=submitBloodDiscard');"
	align="right" /> <input type="reset" class="button" name="Reset"
	id="reset" value="Reset" onclick="resetClicked('discardEntry');"
	accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
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
			function fillBloodBagDetail(obj){	
		<%		
		if(stockList != null && stockList.size() > 0){
				for (BloodStockDetail bloodStockDetail : stockList) {%>
								var invObj =<%= bloodStockDetail.getBloodBagNo()%>
								if(invObj == obj){
								
 								document.getElementById('stockDetailId').value="<%=bloodStockDetail.getId()%>"
	 							document.getElementById('collDate').value="<%=HMSUtil.convertDateToStringWithoutTime(bloodStockDetail.getStockMain().getCollectionDate())%>"
	 							document.getElementById('componentName').value="<%=bloodStockDetail.getComponent().getComponentName()%>"
	 							document.getElementById('quantity').value="<%=bloodStockDetail.getQty()%>"
	 							<% if(bloodStockDetail.getStockMain().getHin() != null){%>
	 							document.getElementById('hinNo').value="<%=bloodStockDetail.getStockMain().getHin().getHinNo()%>"
	 							document.getElementById('name').value="<%=bloodStockDetail.getStockMain().getHin().getPFirstName()%>"

								<%}else{%>
		 						document.getElementById('name').value="<%=bloodStockDetail.getStockMain().getName()%>"
								<%}%>	
								document.getElementById('expiryDate').value="<%=HMSUtil.convertDateToStringWithoutTime(bloodStockDetail.getStockMain().getExpiryDate())%>"
								<%if(bloodStockDetail.getStockMain().getBloodGroup() !=null){%>
	 							document.getElementById('bloodGroup').value="<%=bloodStockDetail.getStockMain().getBloodGroup().getBloodGroupName()%>"
	 							<%}else{%>
	 							document.getElementById('bloodGroup').value=""
	 							<%}%>
 							}else{
 								alert("Blood Bag No. is not available");
 								document.getElementById('bloodBagNo').value=""
 							}
 							<%}}%>
 							}
 			</script>