
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.PatientMainLabInfo"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>

<%
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}

List<PatientMainLabInfo> samplelist = new ArrayList<PatientMainLabInfo>();
if(map.get("sampleList") != null)
{
	samplelist = (List<PatientMainLabInfo>)map.get("sampleList");

}

%>
<div id="sampleNoDiv">

     <select  id="SampleNo" name="SampleNo"   tabindex=1 >

           <% if(samplelist.size()==0)
        	   {%>
        	   <option value="">No Sample No Found</option>
        	   <% }else{%>
                 <option value="">Select</option>
                 <% }%>

		 	<%

			for (PatientMainLabInfo slist : samplelist)
			{
				if(slist.getSampleNo() != null)
				{

    %>
			<option value="<%=slist.getSampleNo()%>" ><%=slist.getSampleNo()%></option>
			<%
				}

			}
		%>
		</select>
</div> 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 