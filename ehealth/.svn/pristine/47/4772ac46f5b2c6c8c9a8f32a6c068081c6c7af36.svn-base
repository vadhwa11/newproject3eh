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
List<MasHospital>subcenterList = new ArrayList<MasHospital>();
if(map.get("subcenterList") !=null){
	subcenterList=(List<MasHospital>)map.get("subcenterList");
}
%>

<div id="subCenterDiv">
<label> Sub Center</label> 
<select id="subcenterId"	name="subcenterId" class="large" validate="Sub Center,string,no" 	tabindex=1>
<%	if(subcenterList.size() >0){ %>
			
				<option value="0">Select</option>
	
				 <%
				 for (MasHospital subCenter : subcenterList) {
					
				  %>
				  <option value="<%=subCenter.getId ()%>"><%=subCenter.getHospitalName()%></option>
				  <%
				  	 	}
				   %>
			
		
	<%}else{ %>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>
<div class="clear"></div>
<label>Mapping Parameters </label>
    <select name="parametersId" id="parametersId" class="large" onchange="getParameters(this.value)"  validate="Parameters,string,yes">
             	<option value="0">Select</option>
             	<option value="bs">Basic Sections</option>
             	<option value="loc">Locality</option>
             	<option value="par">Parliament</option>
             	<option value="ass">Assembly</option>
             	<option value="lsgi">LSGI</option>
             	<option value="post">Post Office with Pin Code</option>
              <option value="esec">Electrical Section</option>
	</select>

	

</div>
