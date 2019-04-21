

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
	</script>

<%
		String userName = "";
		String date ="";
		String time = "";
		String reply = "";
		Boolean hinNoFound = null;
		Map map = new HashMap();

		Map<String,Object> utilMap = new HashMap<String,Object>();
		Inpatient inpatient = new Inpatient();

		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		date = (String)utilMap.get("currentDate");
		time = (String)utilMap.get("currentTime");
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
  	
		if(map.get("inpatientList") != null){
		inpatientList = (List<Inpatient>)map.get("inpatientList");
		}
		if (map.get("hinNoFound") != null)
		{
			hinNoFound = (Boolean)map.get("hinNoFound");
		}


  	    if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
%>
<div id="testDiv">
<label><span>*</span>IP No. </label> 
<select	name="<%=ADMISSION_NUMBER%>" validate="admissionNumber,string,no">
<option value="0">Select</option>
	<% if (inpatientList!=null && inpatientList.size() > 0 )
	     	{
				Iterator itr = inpatientList.iterator();
				while (itr.hasNext())
				{
					inpatient = (Inpatient)itr.next();
					{
					%>
	<option value="<%=inpatient.getId()%>"><%=inpatient.getAdNo()%>
	</option>
	<% 
					}
				} %>
	<script>
			 	document.getElementById('errorMsg').innerHTML='';
			 </script>
	<% }
	     	 else if (hinNoFound)
	     	 {
			 %>
	<script>
			 	document.getElementById('errorMsg').innerHTML='<div class="errormsg" style="width: 850px;">* No Admitted Patients!... Pl. Check Your UHID No.</div>';
			 </script>
	<%
			  }
	     	 else
		      {
				 %>
	<script>
				 	document.getElementById('errorMsg').innerHTML='<div class="errormsg" style="width: 850px;">* Wrong Reg No.!... Pl. Check Your UHID No.</div>';
				 </script>
	<%
				  }
	     	 %>
</select>




</div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

