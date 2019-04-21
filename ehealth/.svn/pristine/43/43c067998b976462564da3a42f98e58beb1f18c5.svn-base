<%@page import="jkt.hms.masters.business.MasHospital"%>
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
List<MasHospital>basicSectionList = new ArrayList<MasHospital>();
if(map.get("basicSectionList") !=null){
	basicSectionList=(List<MasHospital>)map.get("basicSectionList");
}
%>

<div id="subCenterDiv">
<label> Basic Section</label> 
<select id="basicSectionId"	name="basicSectionId" class="large" validate="BasicSection,string,no" 	tabindex=1>
<%	if(basicSectionList.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (MasHospital basicSection : basicSectionList) {
					
				  %>
				  <option value="<%=basicSection.getId ()%>"><%=basicSection.getHospitalName()%></option>
				  <%
				  	 	}
				   %>
			
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>
<div class="clear"></div>
<label>Mapping Parameters </label>
    <select name="parametersId" id="parametersId" class="large" onchange="getParameters(this.value)" validate="Parameters,string,yes">
             	<option value="0">Select</option>
             	<option value="sc">Sub Center</option>
             	<option value="loc">Locality</option>
             	<option value="par">Parliament</option>
             	<option value="ass">Assembly</option>
             	<option value="lsgi">LSGI</option>
             	<option value="post">Post Office with Pin Code</option>
              <option value="esec">Electrical Section</option>
                
                
	</select>
</div>



