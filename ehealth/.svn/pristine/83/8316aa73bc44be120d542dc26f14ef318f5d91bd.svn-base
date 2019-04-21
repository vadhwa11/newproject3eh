<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StoreStockTakingM"%>



<script>
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
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Box box = HMSUtil.getBox(request);

	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	if (request.getAttribute("map") != null)
	{
		map = (Map)request.getAttribute("map");
	}
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");

	String userName = "";
	int deptId=0;
	int hospitalId=0;

	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	if(session.getAttribute("hospitalId") != null){
		hospitalId = (Integer)session.getAttribute("hospitalId");
	}
	if(map.get("departmentList")!=null)
	{
		departmentList = (List)map.get("departmentList");
	}
	%>
	<form name="adjustmentSearch" method="post">
	<div class="clear"></div>
	<div class="titleBg">
<h2>Adjustment</h2>
</div>
<div class="clear"></div>
<div class="Block"><label>Store/Dept. </label> <select
	name="<%= DEPARTMENT_ID%>">
	<option value="0">Select</option>
	<%
						for (MasDepartment masDepartment :departmentList )
						{
							if(masDepartment.getId() == deptId){
					%>
	<option value=<%=masDepartment.getId()%>
		<%=HMSUtil.isSelected(masDepartment.getId().toString(),box.getString(DEPARTMENT_ID)) %>
		selected><%=masDepartment.getDepartmentName()%></option>
	<%
							}else{
					%>
	<option value=<%=masDepartment.getId()%>
		<%=HMSUtil.isSelected(masDepartment.getId().toString(),box.getString(DEPARTMENT_ID)) %>><%=masDepartment.getDepartmentName()%></option>
	<%
							}
						}
					%>
</select>


	<label class="auto">Physical Stock as on Date</label>

	<input type="text" class="date" id="fromDateId"	name="<%=PHYSICAL_STOCK_DATE %>" value="<%=currentDate %>" readonly="readonly"
	MAXLENGTH="30" validate="Physical Stock as on Date,date,yes" />
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.adjustmentSearch.<%=PHYSICAL_STOCK_DATE%>,event)" />

	<input	type="button" name="search" value="Search" class="button"	onclick="submitForm('adjustmentSearch','/hms/hms/stores?method=showAdjustmentJsp');" tabindex=1 />
	<div class="clear"></div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>