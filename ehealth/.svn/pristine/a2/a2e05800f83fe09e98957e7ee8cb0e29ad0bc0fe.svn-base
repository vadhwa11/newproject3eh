<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hr_dcf_entry.jsp  
 * Purpose of the JSP -  This is for DCF Entry
 * @author  Vishal
 * Create Date: 13th July,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.1
--%>

<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>

<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="jkt.hrms.masters.business.PrjSiteResMap"%>


<%@page import="jkt.hrms.masters.business.MstrSiteHeader"%>
<%@page import="jkt.hrms.masters.business.PrjAddPtHeader"%>
<%@page import="jkt.hrms.masters.business.PrjPatvisitsch"%>
<%@page import="jkt.hrms.masters.business.MstrPtvisit"%>

<script type="text/javascript" language="javascript" src="../jsp/js/proto.js"></script>
<%
			
				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject>projectList = new ArrayList<MstrProject>();
				List<MstrSiteHeader> siteHeaderList = new ArrayList<MstrSiteHeader>();
				
				
				int projectId = 0;
				int siteId = 0;
				String projectName = "";
				String projectCode = "";
				String sponsorName  = "";
				String trialPhase = "";
				String protocolNo = "";
				String projectType = "";
				String projectStatus = "";
				String siteCode    ="";
				String siteName 	 = "";
				String fileName="";
				
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
				}
				if(map.get("siteHeaderList")!= null){
					siteHeaderList = (List)map.get("siteHeaderList");
				}
								
				if(map.get("projectId")!= null){
					projectId = (Integer)map.get("projectId");
				}
				if(map.get("siteId")!= null){
					siteId = (Integer)map.get("siteId");
				}
				if(map.get("fileName")!=null){
					fileName=(String)map.get("fileName");
				}
				if(projectList.size()>0){
					for (MstrProject mstrProject :projectList){
						projectId     =	mstrProject.getId();				
						projectName   = mstrProject.getPrjName();
						projectCode   = mstrProject.getPrjCode();
						sponsorName   = mstrProject.getSponsor().getSponsorName();
						trialPhase    = mstrProject.getTrialPhase().getTrialPhaseName();
						protocolNo    = mstrProject.getPrjProtocalno();
						projectType   = mstrProject.getProjectType().getProjectName();
						projectStatus = mstrProject.getProjectStatus().getPrjsName();
						
					}
				}
				
				if(siteHeaderList.size()>0){
					for (MstrSiteHeader mstrSiteHeader :siteHeaderList){
						siteId     =	mstrSiteHeader.getId();				
						siteName   =    mstrSiteHeader.getSiteName();
						siteCode  =     mstrSiteHeader.getSiteCode();
					}
				}
				
				String message = "";
				if(map.get("message")!= null){
					message = (String)map.get("message");
					 out.println(message);
				}
				Map<String,Object> utilMap = new HashMap<String,Object>();
			
									
	%>
	




<div class="titleBg"> 
<h2>DCF Tracker</h2></div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="dcfEntry" method="post" enctype="multipart/form-data" action="">

<div class="clear"></div>
<div class="Block">

<label>Project Name</label>
<label ><%=projectName %></label>
<label>Project Code</label>
<label><%=projectCode %></label>
<label>Project Status </label>
<label><%=projectStatus %></label>
<div class="clear"></div>
<label>Trial Phase </label>
<label><%=trialPhase %></label>
<label>Protocol No </label>
<label><%=protocolNo %></label>
<label>Project Type</label>
<label><%=projectType %></label>
<label>Site Name</label>
<label> <%=siteName %></label>
<div class="clear"></div>
<div class="clear"></div>

</div>
<div class="clear"></div>
	<input type="file" class="browse" id = "uploadFile" name="upload"/>
<div class="clear"></div>
			
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="validateFile();" accesskey="a" tabindex=1/>
<input type="hidden" name="projectId" value="<%=projectId %>" />
<input type="hidden" name="siteId" value="<%=siteId %>" />
<input type="hidden" name="siteCode" value="<%=siteCode %>" />
<input type="hidden" name="protocolNo" value="<%=protocolNo %>" />

<script type="text/javascript">	
	formName = "dcfEntry";	
</script>


<script type="text/javascript">

function validateFile(){
    var file = document.getElementById('uploadFile').value;
    alert("file");
    if (file == ""){
 	  alert("Upload File should not be blank");
 	  return false;
 	}
 	else{
 		 obj = eval('document.'+formName)
 		 obj.action = 'projectTracking?method=uploadDCF&'+csrfTokenName+'='+csrfTokenValue;
  		 obj.submit();
  		 return true;
 	}
 	
}


</script>

			
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

