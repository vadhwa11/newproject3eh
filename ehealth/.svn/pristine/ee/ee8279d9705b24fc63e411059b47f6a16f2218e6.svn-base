<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.OtMasChargeDetails"%>
<%@page import="java.util.Iterator"%>
 <%

Map<String,Object> map = new HashMap<String,Object>();

if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
List<OtMasChargeDetails> chargeList = new ArrayList<OtMasChargeDetails>();
if(map.get("chargeList1") != null){
	chargeList = (List<OtMasChargeDetails>)map.get("chargeList1");
}
 %>
<div id="rateVal">
<ul>
	<%
	String time="";;
	if(chargeList.size() !=0){

		for(OtMasChargeDetails otMasChargeDetails:chargeList)
		{
			 time=otMasChargeDetails.getApproxDuration();
		}
%>
<input type="hidden" name="hidden" id="hidden" value="<%=time %>"/>
  	<%}else{%>
 	<%} %>
</ul>
</div>


