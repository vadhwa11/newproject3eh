<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript">
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
	</script>
<%
	Map<String, Object> utilMap = new HashMap<String, Object>();	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate"); 
	
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
	map = (Map<String,Object>) request.getAttribute("map");
	}
	List<MasStoreGroup> categoryList = new ArrayList<MasStoreGroup>();
	if(map.get("categoryList")!=null){
	categoryList = (List<MasStoreGroup>)map.get("categoryList");
	}
	
%>
<form name="drugForm" method="post" action="">
<div class="titleBg">
<h2>FSN Analysis Report</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label>Item Group</label>
 <select name="itemCat"  >
 <option value="0">Select</option>
 <%for(MasStoreGroup itemCat : categoryList){ %>
 <option value="<%=itemCat.getId()%>"><%=itemCat.getGroupName() %></option>
 <% }%>
  </select>
 <div class="clear"></div>
<label><span>*</span> From Date</label> 
<input style="width: 100px;" type="text"	name="<%=FROM_DATE%>" value="<%=currentDate%>" class="textbox_date"	MAXLENGTH="30" validate="fromDate,date,yes" readonly="readonly" /> 
<a href="javascript:setdate('<%=currentDate%>',document.drugForm.<%=FROM_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" />
 </a>

<label><span>*</span> To Date</label> 
<input style="width: 100px;" type="text"	name="<%=TO_DATE%>" value="<%=currentDate%>" class="textbox_date"	MAXLENGTH="30" validate="toDate,date,yes" readonly="readonly" /> 
<a href="javascript:setdate('<%=currentDate%>',document.drugForm.<%=TO_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" />
 </a>  
 </div>
 <div class="clear"></div>
 <div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Generate Report"	class="buttonBig"	onClick="submitForm('drugForm','purchaseOrder?method=generateFSNAnalysisReport');"	accesskey="a" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>