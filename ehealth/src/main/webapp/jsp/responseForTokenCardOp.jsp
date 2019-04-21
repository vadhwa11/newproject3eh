<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.PatientEpisode"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}
	Boolean flag = false;
	if (map.get("flag") != null) {
		flag =(Boolean) map.get("flag");
	}
%>
<%if(flag == true){%>
<div class="clear"></div>
<input type="button" name="Print Token" value="Print Token" class="buttonBig" onClick="submitFormForDirectPrint('printToken','registration?method=printTokenCardOp');" />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<%}else{%>
<h4>No Data Found</h4>
<div class="clear"></div>
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<%}%>