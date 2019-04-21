<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasChargeCode> masChargecodeList= new ArrayList<MasChargeCode>();
if(map.get("masChargecodeList") != null){
	masChargecodeList = (List<MasChargeCode>)map.get("masChargecodeList");
	
}
%>

<div id="chargeDiv"><label>Charge</label> <select name="charge"
	id="charge">
	<option value="0">Select</option>
	<% 
	     	if (masChargecodeList!=null && masChargecodeList.size() > 0 ) 
	     	{ 
	     		for (MasChargeCode masChargeCode:masChargecodeList) {
	    			
					
			%>
	<option value="<%=masChargeCode.getId()%>"><%=masChargeCode.getChargeCodeName()%>
	</option>


	<%}} %>


</select></div>



