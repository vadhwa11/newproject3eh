<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgCollectionCenter"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

<%@page import="java.net.URL"%>
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
		serverdate = '<%=date+"/"+month+"/"+year%>';
</script>

<%
	 	Box box = HMSUtil.getBox(request);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	List<DgCollectionCenter> collectionCenterList = new ArrayList<DgCollectionCenter>();
		
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Date toDate  = new Date();
		Date fromDate = new Date();
		int deptId= 0;
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if (map.get("fromDate") != null) {
	 		fromDate = (Date) map.get("fromDate");
	 		session.setAttribute("fromDate", fromDate);
	 	}
		if (map.get("toDate") != null) {
	 		toDate = (Date) map.get("toDate");
	 		session.setAttribute("toDate", toDate);
	 	}
		if(map.get("collectionCenterList") != null){
			collectionCenterList = (List<DgCollectionCenter>)map.get("collectionCenterList");
		}
	
	%>

<div class="titleBg">
<h2>Daily Blood collection centre wise report</h2>
</div>
<form name="dailyBloodCollection" target="_blank" action="" method="post">
<div class="Block"><label><span>*</span>From Date</label> <input
	type="text" class="date" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.dailyBloodCollection.<%=FROM_DATE%>,event)" />

<label><span>*</span>To Date</label> <input type="text" class="date"
	id="fromDateId" name="<%=TO_DATE %>" value="<%=currentDate %>"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.dailyBloodCollection.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<label><span>*</span>Collection centre:</label> <select name="<%= SUB_CHARGECODE_ID %>" tabindex=1 validate="Collection centre,string,yes">
	<option value="0">Select</option>
	<% 
				for (DgCollectionCenter  dgCollectionCenter : collectionCenterList){
					%>
	<option value="<%=dgCollectionCenter.getId ()%>"><%=dgCollectionCenter.getCollectionCenterName()%></option>
	<%}%>
</select> 


</script>
<div class="clear"></div>

</div>

<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('dailyBloodCollection','lab?method=printDailyBloodCollectionCenterWise','validateFromToDate');" />
<input type="reset" name="Reset" id="reset" value="Reset"
	class="buttonHighlight" onclick="resetCheck();" accesskey="r" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>


<script type="text/javascript" language="javascript">
	
	function validateFromToDate(){
		
		var nowDate=new Date();
		
		obj1 = eval(document.dailyBloodCollection.fromDate)
		obj2 = eval(document.dailyBloodCollection.toDate)
			
		if(obj1.value != "" && obj2.value != ""){
		
		 validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
		 validToDate=new Date(obj2.value.substring(6),(obj2.value.substring(3,5) - 1) ,obj2.value.substring(0,2));
				
			if(validFromDate<=nowDate){
					if(validFromDate > validToDate){
							alert("From Date should be smaller than To Date\n");
							return false;
					}
				}else{
				alert("From Date should not be greater than Current date\n");
				return false;
				}
		}
		return true;
	}
</script>