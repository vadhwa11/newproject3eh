<!DOCTYPE html>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasApplication"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>


<!-- commented by amit das on 16-08-2016 -->
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> --%>


<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/jquery.min.js"></script>

<script type="text/javascript">
$.noConflict();

$(document).ready(function(){
  $('#menu li a').click(function(){
	  
    $('li a').removeClass("active");
    $(this).addClass("active");
});
});

$(document).ready(function(){
  $('#menu li ul li a').click(function(){
    $('li a').removeClass("active");
    $(this).parent().parent().parent().children().get(0).setAttribute("class", "active");
});
});
</script>

<div class="clear"></div>
<form name="navigation" method="post" >
<script type="text/javascript">
			var menu = new Array();
  
			  </script>
<% 

                Map map = null;
                int counter = 0;
        	    Set<MasApplication> applicationSet = null;
                if(request.getAttribute("map") != null)
                {
					map = (Map)request.getAttribute("map"); 
				}
		        
                if(map.get("applicationSet")!=null)
                {
                	applicationSet = (Set<MasApplication>)map.get("applicationSet");
                	session.setAttribute("applicationSet",applicationSet);
                }
                else if(session.getAttribute("applicationSet") != null){
                	applicationSet = (Set<MasApplication>)session.getAttribute("applicationSet");
                }
            	String screenPath = "";
            	String parentName = "";
            	String appName = "";
           
                 String parentId = "";
                 //added by ritu on 24-08-2017
                 int userType = 0; /* user type 4 for general user */
             	if(session.getAttribute("users") != null){
             		 Users user = (Users)session.getAttribute("users");
             		 userType = user.getUserType()!=null?user.getUserType():4;
             	}//added by ritu on 24-08-2017 end
                 
                 %>
                 <div class="main_menu">
                  <ul id="menu_new">
                 <%
                 String appId= "";
                 if(session.getAttribute("appId")!= null){
                 	appId = (String)session.getAttribute("appId");
                 } 
                 String selectedAppId = "";
                 if(request.getParameter("selectedAppId")!=null){
                	 selectedAppId = request.getParameter("selectedAppId");
                	 session.setAttribute("selectedAppId", selectedAppId);
                	 session.removeAttribute("childAppId");
                 }else if(session.getAttribute("selectedAppId")!=null){
                	 selectedAppId = (String)session.getAttribute("selectedAppId");
                	
                 }
                 String childAppId = "";
                 if(request.getParameter("childAppId")!=null){
                	 childAppId = request.getParameter("childAppId");
                	 session.setAttribute("childAppId", childAppId);
                 }else if(session.getAttribute("childAppId")!=null){
                	 childAppId = (String)session.getAttribute("childAppId");
                 }
                 
         		if(applicationSet != null){
         			
         			if(((String)session.getAttribute("loginName")).equalsIgnoreCase("jktuser") || userType <=1){//changed by ritu on 24-08-2017
               		for(MasApplication appMaster : applicationSet){
               			if(!appMaster.getParentId().equals("0") && appMaster.getParentId().equals(appId)){
               				String menuurl  = appMaster.getUrl().substring(0,1);
               				if(!menuurl.equals("#")){
    	         %>
    	     	
    	     	<!-- Added JSTL for XSS by Amit Das on 18-02-2016 -->
    			<%-- <li><a href="#" id="<%=appMaster.getId() %>" onclick="submitForm('navigation','<%=appMaster.getUrl()+"&selectedAppId="+appMaster.getId()%>');"><%=appMaster.getName() %></a></li> --%>
    			
    			<!-- commented by amit das on 16-08-2016 -->
    			<%-- <c:set var="url1"><%=appMaster.getUrl()%></c:set>
    			<c:set var="id1"><%=appMaster.getId()%></c:set> --%>
    			
    			
    			<%-- <li><a href="#" id="<%=appMaster.getId() %>" onclick="submitForm('navigation','${fn:escapeXml(url1)}&selectedAppId=${fn:escapeXml(id1)}&'+csrfTokenName+'='+csrfTokenValue);"><%=appMaster.getName() %></a></li> --%>
    			
    			<%-- <li><a href="#" id="<%=appMaster.getId() %>" onclick="submitForm('navigation','${fn:escapeXml(url1)}&selectedAppId=${fn:escapeXml(id1)}');"><%=appMaster.getName() %></a></li> --%>
    				<li><a href="#" id="<%=appMaster.getId() %>" onclick="submitForm('navigation','<%=appMaster.getUrl()%>&selectedAppId=<%=appMaster.getId()%>');"><%=appMaster.getName() %></a></li>
				<!-- End JSTL for XSS by Amit Das on 18-02-2016 -->
				
    			<%}else{ %>
    				<li><a href="#" id="<%=appMaster.getId() %>" ><%=appMaster.getName() %></a>
    				<ul>
    				<%
    				int cnt =1;
    				for(MasApplication app : applicationSet){
    					%>
    				<%
    					if(app.getParentId().equals(appMaster.getId())){
    					
    				%>
    					<!-- Added JSTL for XSS by Amit Das on 18-02-2016 -->
    					<%-- <li><a href="#" id="<%=appMaster.getId() %>"  onclick="submitForm('navigation','<%=app.getUrl()+"&selectedAppId="+appMaster.getId()%>');"><%=app.getName() %></a></li> --%>
    					
    					<!-- commented by amit das on 16-08-2016 -->
    					<%-- <c:set var="url2"><%=app.getUrl()%></c:set>
    					<c:set var="id2"><%=appMaster.getId()%></c:set>
    					<c:set var="childAppId2"><%=app.getId()%></c:set>
    			 		--%>
    			
    					<%-- <li><a href="#" id="<%=appMaster.getId() %>"  onclick="submitForm('navigation','${fn:escapeXml(url2)}&selectedAppId=${fn:escapeXml(id2)}&childAppId=${fn:escapeXml(childAppId2)}&'+csrfTokenName+'='+csrfTokenValue);"><%=app.getName() %></a></li> --%>
    					
    					<%-- <li><a href="#" id="<%=appMaster.getId() %>"  onclick="submitForm('navigation','${fn:escapeXml(url2)}&selectedAppId=${fn:escapeXml(id2)}&childAppId=${fn:escapeXml(childAppId2)}');"><%=app.getName() %></a></li> --%>
    					<li><a href="#" id="<%=appMaster.getId() %>"  onclick="submitForm('navigation','<%=app.getUrl()%>&selectedAppId=<%=appMaster.getId()%>&childAppId=<%=app.getId()%>');"><%=app.getName() %></a></li>
    					<!-- Added JSTL for XSS by Amit Das on 18-02-2016 -->
    				
    				<%cnt++;} %>
    			<%	}%>
    				</ul>
    				</li>
    			

    <%}} %>

           			<%
           			counter++;
                   }
         			}else{  
                   		for(MasApplication appMaster : applicationSet){

if(!appMaster.getName().equalsIgnoreCase("Module Management") && !appMaster.getName().equalsIgnoreCase("User Application")){
                   			if(!appMaster.getParentId().equals("0") && appMaster.getParentId().equals(appId)){
                   				String menuurl  = appMaster.getUrl().substring(0,1);
                   				if(!menuurl.equals("#")){
        	         %>
        	     	
        	     	<!-- Added JSTL for XSS by Amit Das on 18-02-2016 -->
        			<%-- <li><a href="#" id="<%=appMaster.getId() %>" onclick="submitForm('navigation','<%=appMaster.getUrl()+"&selectedAppId="+appMaster.getId()%>');"><%=appMaster.getName() %></a></li> --%>
        			
        			<!-- commmented by amit das on 16-08-2016 -->
        			<%-- <c:set var="url1"><%=appMaster.getUrl()%></c:set>
        			<c:set var="id1"><%=appMaster.getId()%></c:set> --%>
        			
        			<%-- <li><a href="#" id="<%=appMaster.getId() %>" onclick="submitForm('navigation','${fn:escapeXml(url1)}&selectedAppId=${fn:escapeXml(id1)}&'+csrfTokenName+'='+csrfTokenValue);"><%=appMaster.getName() %></a></li> --%>
        			<%-- <li><a href="#" id="<%=appMaster.getId() %>" onclick="submitForm('navigation','${fn:escapeXml(url1)}&selectedAppId=${fn:escapeXml(id1)}');"><%=appMaster.getName() %></a></li> --%>
        			
        			<li><a href="#" id="<%=appMaster.getId() %>" onclick="submitForm('navigation','<%=appMaster.getUrl()%>&selectedAppId=<%=appMaster.getId()%>');"><%=appMaster.getName() %></a></li>
        			
    				<!-- End JSTL for XSS by Amit Das on 18-02-2016 -->
    				
        			<%}else{ %>
        				<li><a href="#" id="<%=appMaster.getId() %>" ><%=appMaster.getName() %></a>
        				<ul>
        				<%
        				int cnt =1;
        				for(MasApplication app : applicationSet){
        					%>
        				<%
        				if(!app.getName().equalsIgnoreCase("Module Management") || !app.getName().equalsIgnoreCase("User Application")){
        					if(app.getParentId().equals(appMaster.getId())){
        					
        				%>
        					<!-- Added JSTL for XSS by Amit Das on 18-02-2016 -->
        					<%-- <li><a href="#" id="<%=appMaster.getId() %>"  onclick="submitForm('navigation','<%=app.getUrl()+"&selectedAppId="+appMaster.getId()%>');"><%=app.getName() %></a></li> --%>
        					
        					<!-- commmented by amit das on 16-08-2016 -->
        					<%-- <c:set var="url2"><%=app.getUrl()%></c:set>
        					<c:set var="id2"><%=appMaster.getId()%></c:set>
        					<c:set var="childAppId2"><%=app.getId()%></c:set> --%>
        			
        			
        			
        					<%-- <li><a href="#" id="<%=appMaster.getId() %>"  onclick="submitForm('navigation','${fn:escapeXml(url2)}&selectedAppId=${fn:escapeXml(id2)}&childAppId=${fn:escapeXml(childAppId2)}&'+csrfTokenName+'='+csrfTokenValue);"><%=app.getName() %></a></li> --%>
        					<%-- <li><a href="#" id="<%=appMaster.getId() %>"  onclick="submitForm('navigation','${fn:escapeXml(url2)}&selectedAppId=${fn:escapeXml(id2)}&childAppId=${fn:escapeXml(childAppId2)}');"><%=app.getName() %></a></li> --%>
        					<li><a href="#" id="<%=appMaster.getId() %>"  onclick="submitForm('navigation','<%=app.getUrl()%>&selectedAppId=<%=appMaster.getId()%>&childAppId=<%=app.getId()%>');"><%=app.getName() %></a></li>
        					<!-- Added JSTL for XSS by Amit Das on 18-02-2016 -->
        				
        				<%cnt++;}} %>
        			<%	}%>
        				</ul>
        				</li>
        			

        <%}} %>

               			<%
               			counter++;
                       }
                   		}
             			}
         		}
     %>
</ul>
<div class="clear"></div>
<%
String selAppId = "";
	if(!childAppId.equals("")){
		selAppId = childAppId;
	}else{
		selAppId =  selectedAppId;
	}

	if(!selAppId.equals("")){
		for(MasApplication app : applicationSet){
		if(selAppId.equals(app.getId())){
			appName = app.getName();
			if(!app.getParentId().equals("0")){
				if(!app.getApplication().getParentId().equals("0")){
					
					parentName = app.getApplication().getApplication().getName()+" >";
				}
					parentName = parentName+" "+app.getApplication().getName();
			}
				
			
		}
		
		}		
	}
		
%>
<script type="text/javascript">
if(document.getElementById('<%=selectedAppId%>'))
document.getElementById('<%=selectedAppId%>').className='active';
</script>
</div>           
  <!-- 	makeMainMenu(); -->
           	

<%--  <input type="hidden" name="selectedAppId" id="selectedAppId" value="<%=reqappId%>"/>
       <input type="hidden" name="parentId" id="parentId" value="<%=parentId%>"/> --%>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

<div class="clear"></div>
<div class="indicationMainDiv">
<%
	if(!appName.equals("")){
		screenPath = parentName+" > "+appName;
%>
<div class="indication-nav"><%=screenPath %></div>
<%} %>
</div>
<div class="clear"></div>
<!-- mainIn div start hera and end in footer jsp -->
<div id="mainIn">


