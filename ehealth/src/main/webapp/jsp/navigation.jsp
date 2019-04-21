<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * navigation.jsp  
 * Purpose of the JSP -  This is for navigation.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 12th Nov,2007 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.masters.business.MasApplication"%>
<%@ page import=" static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@ page import="jkt.hms.masters.business.Users"%>


<%@page import="jkt.hms.util.HMSUtil"%>

<form name="navigation" method="post" >

<div id="menu">
<script type="text/javascript">
			var menu = new Array();
  
  
<% 

        //			code for jsp
                Map map = null;
                int counter = 0;
        	    //Set<MasApplication> applicationSet = null;
        	    Set<MasApplication> applicationSet = null;
           	//	List<Object> applicationSet = new ArrayList<Object>();    
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
               
                  /*   
                Integer userId = null;
                if(session.getAttribute("userId4DotNet") != null){
                	userId = (Integer)session.getAttribute("userId4DotNet");
                } */
                String appId = "";
                if(session.getAttribute("appId")!= null){
                	appId = (String)session.getAttribute("appId");
                }
	if(applicationSet != null)
           	for(MasApplication appMaster : applicationSet){
            	out.println("menu["+ counter + "] = new Array();");
       			out.println("menu["+ counter + "][0] ='" + appMaster.getId()+"'");
       			out.println("menu["+ counter + "][1] ='" + appMaster.getParentId()+"'");
       			out.println("menu["+ counter + "][2] ='" + appMaster.getName()+"'");
       		/* 	out.println("menu["+ counter + "][3] ='" + appMaster.getUrl()+"&appId="+appMaster.getId()+"'");
       		 */
       			out.println("menu["+ counter + "][3] ='" + appMaster.getUrl()+"'");
        		out.println("menu["+ counter + "][4] ='" + appId+"'");
        		
       			counter++;
               }

 %>              
           	makeMainMenu();
           	
  </script>
  </div>
 
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

</div>
</div>

<!-- Header Closed -->
<div class="clear"></div>
<div id="mainIn">
<!-- 
<script>
document.addEventListener("contextmenu", function(e){
    e.preventDefault();
}, false);
</script> 
 -->