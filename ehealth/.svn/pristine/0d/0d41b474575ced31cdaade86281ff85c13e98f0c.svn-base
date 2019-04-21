
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreWorkOrderT"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/neStores?method=showWorkRegisterReportJsp";
  obj.submit();
  }
</script> <script type="text/javascript" language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script> <%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	
	

	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<StoreWorkOrderT> searchMasStoreItemList = new ArrayList<StoreWorkOrderT>();
	if(map.get("searchMasStoreItemList")!=null)
		searchMasStoreItemList = (List) map.get("searchMasStoreItemList");


%>
<div id="contentspace">
<form name="workRegister" method="post" action=""><br />
<br />
<div class="panelbar">
<div class="paneltext"">Work Order Register Report</div>
</div>
<br />

<label class="bodytextB1"><font id="error">*</font>From Date :</label> <input
	type="text" name="<%=FROM_DATE%>" value="" class="textbox_date"
	MAXLENGTH="30" validate="Pick a from date,date,yes" readonly="readonly" />
<a
	href="javascript:setdate('<%=currentDate%>',document.workRegister.<%=FROM_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> <label class="bodytextB1"><font
	id="error">*</font>To Date :</label> <input type="text" name="<%=TO_DATE%>"
	value="" class="textbox_date" MAXLENGTH="30"
	validate="Pick a to date,date,yes" readonly="readonly" /> <a
	href="javascript:setdate('<%=currentDate%>',document.workRegister.<%=TO_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> <label class="bodytextB1"><font
	id="error">*</font>PVMS/NIV No:</label> <select name="<%=PVMS_NO%>"
	validate="PVMS/NIV No,String,yes">
	<option value=0>Select</option>
	<%
				for (StoreWorkOrderT masWorkOrder :searchMasStoreItemList ) {
				
				%>
	<option value=<%=masWorkOrder.getItem().getPvmsNo()%>><%=masWorkOrder.getItem().getPvmsNo()%>
	</option>
	<%	
					}
				
					
				%>
</select> <br>
<center><input type="button" name="add" id="addbutton"
	value="Ok" class="button"
	onClick="submitForm('workRegister','neStores?method=generateWorkRegisterReport');"
	accesskey="a" tabindex=1 /> <input type="button" name="clear"
	id="clearbutton" value="Clear" class="button"
	onClick="clearButton('workRegister');" accesskey="a" tabindex=1 /></center>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</div>