<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
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
		Map map = new HashMap();
	 	if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
 			Map<String, Object> utilMap = new HashMap<String, Object>();

			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		 	String currenDate = (String) utilMap.get("currentDate");
		 	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		if(map.get("employeeList")!=null)
		{
			employeeList = (List<MasEmployee>)map.get("employeeList");
		}
%>
<div id="docDiv">
<label>Doctor Name</label>
<select name="docName" id="doctorId" >
<option value="">Select</option>
<%for(MasEmployee emp:employeeList){ %>
<option value="<%=emp.getId() %>"><%=emp.getFirstName().concat(" ").concat(emp.getLastName()) %></option>
<%} %>
</select>
</div>

