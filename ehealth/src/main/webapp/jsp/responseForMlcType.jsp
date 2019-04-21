<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>



<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
String uhin="";
if(map.get("uhin") != null){
	uhin = (String)map.get("uhin");
}

List<Object> medicoLegalDetailsList = new ArrayList<Object>();
if(map.get("medicoLegalDetailsList") != null){
	medicoLegalDetailsList = (List<Object>)map.get("medicoLegalDetailsList");
}

%>
<div id="divTest">
<label><span>*</span> MLC Type</label>
<!--  <select name="mlcType" id="mlcType" validate="MLC Type,string,yes"   onclick="submitProtoAjaxWithDivName('mlcSearch','/hms/hms/mlc?method=getMlcTypeReport','divMlc');">-->
<select name="mlcType" id="mlcType" validate="MLC Type,string,yes" >

	<%	if(medicoLegalDetailsList.size() !=0){
		for (Iterator iterator = medicoLegalDetailsList.iterator(); iterator.hasNext();) {
			Object[] object = (Object[]) iterator.next();

		    
		    String mlcType  = (String)object[1];
%>
	<option value="<%=mlcType%>"><%=mlcType%></option>
	<%}}else{%>
	<option value="">No Items found</option>
	<%} %>
	</select>
<!-- 	<div id="divMlc">
	
<label><span>*</span> MLC No.</label>
<select name="medicoLegalDetailsId" id="medicoLegalDetailsId" validate="MLC No,string,yes">
<option value=""></option>
</select>

	
	</div>
	 -->

<input type="button" name="add" id="addbutton" value="Print" 	class="button"	onClick="submitForm('mlcSearch','mlc?method=generateReportForMLC');"	accesskey="a" tabindex=1 />

	 
</div>



