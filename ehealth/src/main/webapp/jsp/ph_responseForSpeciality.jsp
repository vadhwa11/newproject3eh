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
<div class="clear"></div>
<div id="divName">
		<%
		   Set<Integer> set=new HashSet<Integer>();
			int i=0;
				if(masForGorupParameter.size()>0)
				{
					int count=0;
						%>
					
					<%
					for(MasSpecialityDeptGroup deptGroup: masForGorupParameter)
						{ count++;
						%>
						<div>
								<div>
										<% if(set.add(deptGroup.getSpGroup().getSpGroup().getId())){%>
										<label><%=deptGroup.getSpGroup().getSpGroup().getSpGroupName()%></label>
										<div class="clear"></div>
										<%} %>
								</div> 
								<div>
					            	 <label>
					            		<% if(deptGroup.getSpGroup().getSpParameter().getStatus().equalsIgnoreCase("Y")) {%>
											<%=deptGroup.getSpGroup().getSpParameter().getSpParameterName()%>
								       		<input type="hidden" value="<%= deptGroup.getSpGroup().getSpGroup().getId()%>:<%=deptGroup.getSpGroup().getSpParameter().getId()%>" name="parameterId"/>
						 				<%}%>
						 			 </label>
										<%if(deptGroup.getTextField()!=null){%>
											<%if(deptGroup.getTextField().equalsIgnoreCase("t")  )
										    {%><input type="text" name="textValue"/> <% }%>
										<%}%>
										
										 <%if(deptGroup.getTextField()!=null){%>
											<%if(deptGroup.getTextField().equalsIgnoreCase("n")  && deptGroup.getValueType().equalsIgnoreCase("text area"))
										    {%><textarea style="width: 179px; height: 38px;" rows="" cols=""  name="textValue"></textarea> <% }%>
										 <%}%> 
										 
										 <%if(deptGroup.getTextField()!=null){%>
											   <%if(deptGroup.getTextField().equalsIgnoreCase("n")  && deptGroup.getValueType().equalsIgnoreCase("lov"))
										       {%>
										    	<select name="textValue">
										    	<option>Select</option>
										    	<%for(MasSpecialityDeptGroupValue msdValue:masValue){ %>
										    		<%if(deptGroup.getId()==msdValue.getDeptGroup().getId()){ %>
										    			<option value="<%=msdValue.getValue()%>"><%=msdValue.getValue() %></option>
										    		<%} %>
										    	<%}%>
										    	</select>
										      <%}%>
										 <%}%> 
										 
										<%if(deptGroup.getValueType().equalsIgnoreCase("Radio Button")){ %>
    	              						<label><input type="radio" name="textValue" value="radio" /></label>
	              						 <%}else if(deptGroup.getValueType().equalsIgnoreCase("Check Box")){ %>
        	       						    <label><input type="checkbox" name="textValue" value="checkbox"/></label>
             							<%} %>
										 
										 
										 
										 <%if(count%2==0){ %>
											<div class="clear"></div>
										<%} %>
								</div>
								
						</div>
						<%}%>
		<%}else{ %>
		<h4>No Record Found</h4>
		<% } %>
</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
