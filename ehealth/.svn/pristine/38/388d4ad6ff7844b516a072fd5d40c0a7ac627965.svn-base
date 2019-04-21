<%@page import="jkt.hms.masters.business.SurveyDetailMails"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.PhMasParliyamentAssembly"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
int couHouse =0;
if(map.get("countHouse") !=null){
	couHouse=(Integer)map.get("countHouse");
}
int memCount =0;
if(map.get("memberCount") !=null){
	memCount=(Integer)map.get("memberCount");
}
int phcCount = 0;
if(map.get("phcCount") !=null){
	phcCount=(Integer)map.get("phcCount");
}
int userType =0;
if(map.get("userType") !=null){
	userType=(Integer)map.get("userType");
}



%>
 <div id="testdiv">
<div class="clear"></div>
<%-- <input type="hidden" name="districtIdss" id="districtIdss" value="10"/>
<div class="clear"></div>
<% if(userType <= 2) { %>
	<label>Number of PHCs</label> <input type="text" value="<%= phcCount%>" readonly="readonly" name="pSurvey" >
<% } %> --%>
<label>House Survey</label> <input id ="houseSurveyId" type="text" value="<%= couHouse%>"  readonly="readonly" name="hSurvey" > <%-- value="<%= couHouse%>" --%>
<label>Member Survey</label> <input id ="memberSurveyId" type="text" value="<%= memCount%>" readonly="readonly" name="mSurvey">
<label>Remarks</label> <input type="text" value=""  name="remarks"> 
<div class="clear"></div>

</div>
