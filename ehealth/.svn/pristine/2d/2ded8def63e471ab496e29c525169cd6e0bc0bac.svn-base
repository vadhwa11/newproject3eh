
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>




<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />
<div id="contentspace"><script type="text/javascript"
	language="javascript">
	<%
	Map map = new HashMap();
	String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	String serviceNo="";
	if (map.get("serviceNo") != null) {
		serviceNo = (String) map.get("serviceNo");
	}
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
	</script> <script type="text/javascript" language="javascript">
	function checkForServiceNo(serviceNo){
	
	if(serviceNo==""){
		return true
	}else{
	getHinNo('search','adt?method=getAdmissionNoList&flag=hin')
	
	}
	}
	</script> <br />
<h2 align="left" class="style1">SIL/DIL Form</h2>
<br />


<form name="search" method="post" action="">
<body onLoad="checkForServiceNo(<%=serviceNo%>);">
<label class="bodytextB">Service No.:</label>
<input type="text" id="serviceNo." name="<%=SERVICE_NO%>"
	value="<%=serviceNo%>" class="textbox_date" MAXLENGTH="20"
	onblur="getHinNo('search','adt?method=getAdmissionNoList&flag=hin&&silDil=silDil')" />
<div id="hinDiv"><label class="bodytextB"> HIN:</label> <input
	type="text" name="<%=HIN_NO%>" value="" class="textbox_date"
	MAXLENGTH="50"
	onchange="submitProtoAjax('search','adt?method=getAdmissionNoList&flag=admission')" />
</div>
<div id="testDiv"><label class="bodytextB"> IP No.:</label> <input
	type="text" id="frwSlno" name="<%=AD_NO%>" value=""
	class="textbox_date" MAXLENGTH="30" validate="IP No.,string,yes" /></div>
<br />
<br />


</body>
<input type="submit" name="OK" value="OK" class="button"
	onClick="submitForm('search','/hms/hms/ipd?method=showSilDilJspInAdt&adt=yes');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>


</div>