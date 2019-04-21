<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import = "static jkt.hrms.util.HrmsRequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasGrade"%>


<%@page import="jkt.hrms.masters.business.MstrTherapeutic"%>
<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="org.apache.tools.ant.Project"%>
<%@page import="jkt.hrms.masters.business.MstrSponsor"%>



<form name="sponsorWiseProject" method="post" action="">

<%
			Map<String,Object> map =new HashMap<String,Object>();
			List<MstrSponsor> sponsorList = new ArrayList<MstrSponsor>();
			
			if(request.getAttribute("map")!=null){
				map=(Map) request.getAttribute("map");
			}
			if(map.get("sponsorList")!=null){
				sponsorList=(List<MstrSponsor>)map.get("sponsorList");
			}
			
%>

<div class="titleBg">
<h2>Sponsor Wise Project</h2></div>

    <div class="clear"></div>
    
    	<label><span>*</span> Sponsor</label>
     	<select name="<%=SPONSOR_ID%>" id="<%=SPONSOR_ID%>" validate="Sponsor,string,yes">
    	<option value="">Select</option>
    	<%
			for(MstrSponsor mstrSponsor : sponsorList)
			{				
		%>
			<option value="<%= mstrSponsor.getId()%>"><%=mstrSponsor.getSponsorName()%></option>
		<%} %>
		
         </select>

    	 	<div class="clear"></div>
    	 
    	<div class="clear"></div>
    	<input type="button" class="button" value="print" name="print" onclick="submitForm('sponsorWiseProject','/hms/hrms/report?method=printSponsorWiseProject');"/>
    	 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 </form>
    	
