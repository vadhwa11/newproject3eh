<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * state.jsp  
 * Purpose of the JSP -  This is showing State.
 * @author  Dipali
 * @author  Vishal
 * Create Date: 07th April,2009
 * Revision Date:      
 * Revision By:  
 * @version 1.14
--%>

<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.MasSpecialtyTemplate"%>
<%@page import="jkt.hms.masters.business.MasSpecialityDeptGroup"%>
<%@page import="jkt.hms.masters.business.MasSpecialityDeptGroupValue"%>
<%@page import="jkt.hms.masters.business.SpDeptGroupT"%>
<%@page import="jkt.hms.masters.business.SpDeptGroupM"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<%@page import="jkt.hms.masters.business.MasSpecialtyGroupParameter"%>
<%@page import="jkt.hms.masters.business.MasSpecialityParameter"%>
<%@page import="jkt.hms.masters.business.MasSpecialityGroup"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasSpecialityGroup"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>
<script language="javascript" type="text/javascript"
	src="/hms/jsp/js/ajax.js"></script>




<%
	    Map map=new HashMap();	
          Map<String,Object> utilMap = new HashMap<String,Object>();
        List<MasSpecialityDeptGroup> masForGorupParameter=new ArrayList<MasSpecialityDeptGroup>();
		List<MasSpecialtyGroupParameter> groupParameterList=new ArrayList<MasSpecialtyGroupParameter>();
		List<MasSpecialityDeptGroupValue> masValue=new ArrayList<MasSpecialityDeptGroupValue>();
			
		
		String userName = "";
		String  departName= "";
		String checkBox="";
	    String valueName="";	
	    
		  if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		        }
		 if(map.get("masForGorupParameter") != null){
			 masForGorupParameter = (List<MasSpecialityDeptGroup>)map.get("masForGorupParameter");
			      } 
         if(map.get("masValue") != null){
            masValue = (List<MasSpecialityDeptGroupValue>)map.get("masValue");
			}
             if(map.get("groupParameterList") != null){
	        groupParameterList = (List<MasSpecialtyGroupParameter>)map.get("groupParameterList");
	
			} 
             if(map.get("valueName") != null){
            	 valueName = (String)map.get("valueName");
     	
     			} 
             
             if(map.get("checkBox") != null){
            	 checkBox = (String)map.get("checkBox");
     	
     			} 
         
             
	 System.out.println("size========="+masForGorupParameter.size());
	    
	    
	String date ="";
	String time ="";
	try{
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	}catch(Exception ex){
		ex.printStackTrace();
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	String message="";
	if(map.get("message") != null){
		  message = (String)map.get("message");
	}
		   %>

<h4>
	<span><%=message %></span>
</h4>
<%
	int pageNo = 0;
	if(map.get("pageNo") != null){
		pageNo = (Integer)map.get("pageNo");
	}
%>

<div class="titleBg"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
	<div id="searcharea">

	</div>
	<div class="clear"></div>
</div>


<div class="clear"></div>
<%-- <jsp:include page="searchResultBlock.jsp" /> --%>
<div class="clear"></div>


<form name="speciality" method="post" action="" enctype="">

	<div id="divName">
        
		<%
		   Set<Integer> set=new HashSet<Integer>();
		
		int i=0;
								if(masForGorupParameter.size()>0)
								{
								%>
		<table>
		<tbody>
			<tr>
			<th>Group</th>
			<th>Parameter</th>
			<th></th>
			<th>Values</th>
			<th></th>
			</tr>  
			<%
			
			
			for(MasSpecialityDeptGroup deptGroup: masForGorupParameter)
									{
				i++;
									%>
				<tr> 	
		<td>	<% if(set.add(deptGroup.getSpGroup().getSpGroup().getId())){%>
				<%=deptGroup.getSpGroup().getSpGroup().getSpGroupName()%>
				<input type="hidden" value="<%= deptGroup.getId()%>" name="groupId<%=i %>"/>
				<%} %>
				
				</td>
		
			
            <td><% if(deptGroup.getSpGroup().getSpParameter().getStatus().equalsIgnoreCase("Y")) {%>
					<%=deptGroup.getSpGroup().getSpParameter().getSpParameterName()%>
			       <input type="hidden" value="<%= deptGroup.getId()%>" name="parameterId<%=i %>"/>
			 <% }%></td>
			 
		
				<td>
				<%if(deptGroup.getTextField()!=null){%>
				<%if(deptGroup.getTextField().equalsIgnoreCase("t"))
			    {%> <input type="text" name="textValue<%=i %>"/> <% }else{ %> 
			    <p>--<p>
			    <%} %>
			    <%} %>
			    </td>
  				<td>
  				            	
             <%if(deptGroup.getValueType().equalsIgnoreCase("LOV")){ %>
             <textarea name="presentComplain<%=i %>" id="presentComplain<%=deptGroup.getId()%>"
						validate="presentComplain,string,no" cols="0" tabindex="4" rows="0"
						maxlength="500"><%= valueName%></textarea>
						<input type="hidden" name="presentComplainId<%=i%>" id="presentComplainId<%=deptGroup.getId()%>"/>
						
						 <input type="button"
					class="buttonAuto" id="button4" name="button4" value="----"
					onclick="getFamilyHistoryTemplate('<%=deptGroup.getId()%>');" /> 
             
                <%}else if(deptGroup.getValueType().equalsIgnoreCase("Radio Button")){ %>
                  <input type="radio" name="checkbox<%=i %>" value=""/>
                  
                  <%}else if(deptGroup.getValueType().equalsIgnoreCase("Check Box")){ %>
                  <input type="checkbox" name="checkbox<%=i %>""value=""/>
             
               <%}else if(deptGroup.getValueType().equalsIgnoreCase("Text Area")){ %>
                 <textarea rows="4" cols="20" name="texarea<%=i %>"></textarea>
             
                 <%}   
             
               
               else{ %>
                 
                 <%} %>
             
               </td>
             
		
		<% }%>	
		
		</tr> </tbody></table>
		
		<input type="hidden" name="increment" value=""><%	} else{ %>
		<h4>No Record Found</h4>
		<% } %>

		
		
			<input type="hidden" name="totalrecord" value="<%=i %>" />
			
				<% if(masForGorupParameter.size()>0) {%>
	 <input type="submit" name="add" id="addbutton" value="Save" class="button"
		 onClick="submitForm('speciality','generalMaster?method=saveSpeciality');" accesskey="a" tabindex=1 />
	
	<%} %>
		
		
	</div>
<div class="clear"></div>
  
	</div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>


<script type="text/javascript" language="utf8">
	function getPresentTemplate() {
		var url = '/hms/hms/generalMaster?method=showPopUpForValues';
		popwindow(url);
	}
	var newwindow;
	function popwindow(url) {
		newwindow = window.open(url, 'name', 'height=500,width=800,status=1');
		if (window.focus) {
			newwindow.focus()
		}
		newwindow.createPopup();
	}
	function fnReset() {
		if (confirm('Are you sure want to reset screen ?')) {
			document.getElementById("").value = "";

		}
	}
</script>


