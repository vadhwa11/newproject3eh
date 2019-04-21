<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import = "static jkt.hrms.util.HrmsRequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hrms.masters.business.MstrProject"%>


<form name="projectVendorWise" method="post" action="">

<%
			Map<String,Object> map =new HashMap<String,Object>();
			List<MstrProject> projectList = new ArrayList<MstrProject>();
			
			if(request.getAttribute("map")!=null){
				map=(Map) request.getAttribute("map");
			}
			if(map.get("projectList")!=null){
				projectList=(List<MstrProject>)map.get("projectList");
			}
			
%>

<div class="titleBg">
<h2>Project Wise Vendor</h2></div>

    <div class="clear"></div>
    
    	<label><span>*</span> Project</label>
     	<select name="<%=PROJECT_ID%>" id="<%=PROJECT_ID%>" validate="Project,string,yes">
    	<option value="">Select</option>
    	<%
			for(MstrProject mstrProject : projectList)
			{				
		%>
			<option value="<%= mstrProject.getId()%>"><%=mstrProject.getPrjName()%></option>
		<%} %>
		
         </select>

    	 	<div class="clear"></div>
    	 
    	<div class="clear"></div>
    	<input type="button" class="button" value="print" name="print" onclick="submitForm('projectVendorWise','/hms/hrms/report?method=printProjectVendorWise');"/>
    		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
    	
