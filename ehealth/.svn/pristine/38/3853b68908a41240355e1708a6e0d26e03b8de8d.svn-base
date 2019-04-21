<%
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<Object[]> emergencyIndentList = new ArrayList<Object[]>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	if(map.get("emergencyIndentList")!=null){
		emergencyIndentList = (List<Object[]>) map.get("emergencyIndentList");
	}
%>



<%@page import="java.util.*"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<div id="grnDiv">
<div class="Block">
<label><span>*</span>Indent No</label>
<select name="indentId" id="indentCombo" onchange="submitProtoAjaxforIndent('createGrn','/hms/hms/stores?method=responseForIndentGrid');" validate="Indent No,String,yes" tabindex=1>
<option value="">Select</option>
<%
if(emergencyIndentList.size()>0){
	for(Object[] obj :emergencyIndentList){

%>
<option value="<%=obj[1] %>"><%=obj[0] %></option>
<%}} %>
</select>
<div id="indentDiv">
<label><span>*</span> Indent Date</label>
<input type="text" name="indentDate" value="" class="date" readonly="readonly" validate="Indent Date,date,yes"	MAXLENGTH="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.createGrn.indentDate,event)" />

<label><span>*</span> Date Received</label>
<input type="text" name="dateReceived"	value="" class="date" readonly="readonly" validate="Date Received,date,yes"	MAXLENGTH="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.createGrn.dateReceived,event)" />
<div class="clear"></div>
<label><span>*</span> Invoice No</label>
<input name="invoiceNo" id="indentCombo" value="" validate="Invoice No,string,yes" tabindex=1 />

<label><span>*</span> Invoice Date</label>
<input type="text" name="invoiceDate"	value="" class="date" readonly="readonly" validate="Invoice Date,date,yes"	MAXLENGTH="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.createGrn.invoiceDate,event)" />

<label>Delivery Challan No</label>
<input type="text" name="challanNo" id="challanNo" value="" validate="Challan No,string,no" />
<div class="clear"></div>
<%-- <label>PO Date</label>
<input type="text" name="poDate" value="" class="date" readonly="readonly" validate="PO Date,date,no"	MAXLENGTH="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.createGrn.poDate,event)" /> --%>
<div class="clear"></div>

</div>
</div>
</div>

