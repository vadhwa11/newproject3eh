<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>	
<%@page import="java.util.*"%>
<%@page import="jkt.hrms.masters.business.PrjSiteResMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>	

	<%
			Map<String, Object> map = new HashMap<String, Object>();
	  	List<MstrProject> projectList = new ArrayList<MstrProject>();
			if(request.getAttribute("map") != null){
				map = (Map) request.getAttribute("map");
			}
			if(map.get("projectList")!= null){
				projectList = (List)map.get("projectList");
			}
			
	
	%>





<%@page import="jkt.hrms.masters.business.MstrProject"%>
<label >Project</label>  
            <select name="<%=PROJECT_ID %>" id="projNameId" validate="Project,int,no"  tabindex=1>
			  <option value="0">Select</option>
			  <% 
				for ( MstrProject mstrProject : projectList){
				%>
		    
			  <option value="<%=mstrProject.getId ()%>"><%=mstrProject.getPrjName()%></option>
			  		  
			  <%}%>
              </select>		
              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
