
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.OtMasChargeDetails"%>
<%@page import="java.util.Iterator"%>



<%
Map<String,Object> map = new HashMap<String,Object>();

if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
List<OtMasChargeDetails> chargeList = new ArrayList<OtMasChargeDetails>();
if(map.get("chargeList") != null){
	chargeList = (List<OtMasChargeDetails>)map.get("chargeList");
}
%>



<ul>
	<%	if(chargeList.size() !=0){

		for (Iterator iterator = chargeList.iterator(); iterator.hasNext();) {

			//Object[] pair = (Object[]) iterator.next();
			OtMasChargeDetails masChargeCode=(OtMasChargeDetails)iterator.next();

		    String chargeCodeName=masChargeCode.getChargeCode().getChargeCodeName();
		    String chargeCode=masChargeCode.getChargeCode().getChargeCodeCode();
		    int chargeId=masChargeCode.getChargeCode().getId();


%>
	<li style="width: auto;"><%=chargeCodeName%>[<%=chargeId%>][<%=chargeCode%>]</li>
<input type="hidden" name="chargeName1" id="chargeId" value="<%=chargeCodeName%>[<%=chargeId%>]" />


	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>



