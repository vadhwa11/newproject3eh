<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>


<%@ page import="static jkt.hms.util.RequestConstants.*" %>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<Object> medicoLegalDetailsNoList = new ArrayList<Object>();
if(map.get("medicoLegalDetailsNoList") != null){
	medicoLegalDetailsNoList = (List<Object>)map.get("medicoLegalDetailsNoList");
}


String uhin="";
if(map.get("uhin") != null){
	uhin = (String)map.get("uhin");
}

String mlcType="";
if(map.get("mlcType") != null){
	mlcType = (String)map.get("mlcType");
}

%>
<div id="divTest">
<label><span>*</span> PM No.</label>
<select name="medicoLegalDetailsId" id="medicoLegalDetailsId" validate="PM No.,string,yes">
	<%	if(medicoLegalDetailsNoList.size()>0 ){
		for (Iterator i = medicoLegalDetailsNoList.iterator(); i.hasNext();) {
			
			Object[] b = (Object[]) i.next();

         	int mlcId  = (Integer)b[3];
		    String mlcNo  = (String)b[2];
		    if(mlcNo!=null){
%>
	<option value="<%=mlcId%>"><%=mlcNo%></option>
	<%}}}else{%>
	<option value="">No Items found</option>
	<%} %>
	

</select>


<div class="clear"></div>
<input type="hidden" name="<%=HIN_NO%>" value="<%=uhin%>" />
<input name="mlcType" id="mlcType" value="<%=mlcType %>" type="hidden"/>



<input type="button" name="add" id="addbutton" value="Print" 	class="button"	onClick="submitForm('mlcSearch','mlc?method=generateReportForMLC');"	accesskey="a" tabindex=1 />

</div>
