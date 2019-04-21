<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * gruPara.jsp  
 * Purpose of the JSP -  This is showing State.
 * @author  Dipali
 * @author  Vishal
 * Create Date: 07th April,2009
 * Revision Date:      
 * Revision By:  
 * @version 1.14
--%>

<%@page import="jkt.hms.masters.business.MasSpecialtyGroupParameter"%>
<%@page import="jkt.hms.masters.business.SpGroupParameter"%>
<%@page import="jkt.hms.masters.business.MasSpecialityParameter"%>
<%@page import="jkt.hms.masters.business.MasSpecialityGroup"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasSpecialityGroup"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		
		List<MasSpecialtyGroupParameter> masParameter = new ArrayList<MasSpecialtyGroupParameter>();
		
		List<MasSpecialityParameter> masSpParaList = new ArrayList<MasSpecialityParameter>();
		
		List<MasSpecialityGroup> masSpGrpList = new ArrayList<MasSpecialityGroup>();
		
		String userName = "";
		
		map.put("masSpParaList", masSpParaList);
		map.put("masSpGrpList", masSpGrpList);
		map.put("masParameter", masParameter);
		
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if(map.get("masSpGrpList") != null){
			masSpGrpList = (ArrayList)map.get("masSpGrpList");
		}
			
	    if(map.get("masSpParaList") != null){
	    	masSpParaList = (ArrayList)map.get("masSpParaList");
	           }
	    
	    if(map.get("masParameter") != null){
	    	masParameter = (ArrayList)map.get("masParameter");
	           }
	    
	    
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
	
	if(map.get("message") != null){
		  String message = (String)map.get("message");
		   %>
		 
<h4>
	<span><%=message %></span>
</h4>
<%}
	
%>

<div class="titleBg">
	<h2>Group Parameter Master</h2>
</div>
<div class="Block">
	<div id="searcharea">
		<div id="searchbar">
			<form name="search" method="post" action="">
			
					
         <label>Group</label>
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Group Code,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'generalMaster?method=showGroupParaMasterJSP')" />
					
<input type="button" name="search" value="Search" class="button" id="searchField"	onclick="submitForm('search','generalMaster?method=showGroupParaMasterJSP','checkSearch')"		tabindex=1 />
				<%--- Report Button   --%>
							
				
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

			
			
		</div>
	</div>
	<div class="clear"></div>
</div>
<%-- <table>
	<tr><th>Group Name</th><th>Parameter Name</th><th>Status</th></tr>
	<%
		for(SpGroupParameterT   spGroupParameterTs:spGroupParameterT){
%>
<tr><td><input type="text" value="<%= spGroupParameterTs.getGroupParameterM().getSpGroup().getSpGroupName()%>"</td>
<td><%=spGroupParameterTs.getSpParameter().getSpParameterName()%></td>
<td></td>
	<%} %>
</table>
 --%>

<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
	<div id="searchtable" tabindex=2></div>
	<% 
		if(masParameter.size()>0 || masParameter.size() > 0)
		 {
			String strForCode = (String)map.get("groupCode");
			String strForCodeDescription = (String)map.get("groupName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%><h4>
		<a href="generalMaster?method=showGroupParaMasterJSP">Show All Records </a>
	</h4>
	<%
			}
		 }
	 if(masParameter.size()==0 && map.get("search") != null)
	  {
	 %>
	<h4>
		<a href="generalMaster?method=showGroupParaMasterJSP">Show All Records</a>
	</h4>
	<%
     }
	%>
	<script type="text/javascript">

	formFields = [
	 			[0, "<%= COMMON_ID%>", "id"], [1,"grpMaster"], [2,"paraMastr"], [3,"<%= STATUS%>"] ];
	 statusTd = 3;

	</script>
</div>

<form name="gruPara" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<input type="hidden" name="<%= POJO_NAME %>" value="MasSpecialityDeptGroup">
		<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="SpGroup">
			<input type="hidden" name="<%=POJO_PROPERTY_CODE %>"
			value="SpGroup"> <input type="hidden" name="title"
				value="DepartmentGroup"> <input type="hidden" name="<%=JSP_NAME %>"
					value="grop_parameter_master"> <input type="hidden" name="pojoPropertyCode"
						value="Department">

							<div class="paddingTop5"></div>
							<div class="clear"></div>
							<div class="Block">
							
	<label><span>*</span> Group </label> <select name="grpMaster" validate="Group,string,yes" tabindex=1>
			<option value="">Select</option>
            <% 
				for ( MasSpecialityGroup masGruplist : masSpGrpList){
				%>
	        <option value="<%=masGruplist.getId ()%>"><%=masGruplist.getSpGroupName()%></option>
	<%}%>
            
		</select>    
		
		
	 <label><span>*</span>Parameter </label> <select name="paraMastr"  validate="Parameter,string,yes" tabindex=1 >
	   <option value="">Select</option>
            <% 
				for ( MasSpecialityParameter paraaraList : masSpParaList){
				%>
       	<option value="<%=paraaraList.getId()%>"><%=paraaraList.getSpParameterName()%></option>
	<%}%>
            
		</select>    
		<script>
								
			<%-- document.gruPara.<%=CODE%>.focus(); --%>
			</script>


								<div class="clear"></div>
							
							<div id="edited"></div>
							
							 <input type="button" name="add"
							id="addbutton" value="Add" class="button"
							onClick="submitForm('gruPara','generalMaster?method=addGroupParaMaster');"accesskey="a" tabindex=1 />
							
							 <input type="button" name="edit" id="editbutton" value="Update" style="display: none;"
							class="button"	onClick="submitForm('gruPara','generalMaster?method=editGroupParaMaster')"
							accesskey="u" tabindex=1 /> 
							
							
							<input type="button" name="Delete"id="deletebutton" value="Activate" class="button"
							style="display: none;" onClick="submitForm('gruPara','generalMaster?method=deleteGroupParaMaster&flag='+this.value)"
							accesskey="d" tabindex=1 />
							
							 <input type="reset" name="Reset"id="reset" value="Reset" class="buttonHighlight"
							onclick="resetCheck();" accesskey="r" />
							
							 <input type="hidden"name="<%=STATUS %>" value="" /> <input type="hidden"
							name="<%= COMMON_ID%>" value="" /> 
							
							<div class="clear"></div>
							</div>
							<div class="bottom">
								<label> Changed By: </label> <label class="value"><%=userName%></label>
								<label> Changed Date: </label> <label class="value"><%=date%></label>
								<label> Changed Time: </label> <label class="value"><%=time%></label>
								<input type="hidden" name="<%=CHANGED_BY%>"
									value="<%=userName%>" /> <input type="hidden"
									name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
									type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
							</div>
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Group"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "grpMaster"

data_header[1] = new Array;
data_header[1][0] = "Parameter"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "paraMastr"

data_header[2] = new Array;
data_header[2][0] = "Status"
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "<%=STATUS %>";


 data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "paraMastr"
<%--
data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[3][3] = "<%=CHANGED_DATE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=CHANGED_TIME %>"
 --%>


data_arr = new Array();


<%


Iterator itr=masParameter.iterator();
        int  counter=0;
        while(itr.hasNext())
         {
        	MasSpecialtyGroupParameter  masParameter1 = (MasSpecialtyGroupParameter)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masParameter1.getId()%>


<%
Iterator itrGridDepartmentTypeList=masSpGrpList.iterator();
while(itrGridDepartmentTypeList.hasNext())
   {
	 
	 try{
		 MasSpecialityGroup  masGroup = (MasSpecialityGroup)itrGridDepartmentTypeList.next(); 
		 
	 if(masParameter1.getSpGroup().getId().equals(masGroup.getId()) && masGroup.getStatus().equalsIgnoreCase("y")){%>
	 
	 data_arr[<%= counter%>][1] = "<%=masGroup.getSpGroupName().trim()%>"
	 
	<%}else if(masParameter1.getSpGroup().getId().equals(masGroup.getId()) && masGroup.getStatus().equalsIgnoreCase("n")){%>
	
	 data_arr[<%= counter%>][1] = "<%=masGroup.getSpGroupName().trim()%>"
		
	<%}
   }catch(Exception e){e.printStackTrace();}}

   
   %>
   <%
   Iterator itrGridPArameterList=masSpParaList.iterator();
   while(itrGridPArameterList.hasNext())
      {
   	 
   	 try{
   		 MasSpecialityParameter  masParameter11 = (MasSpecialityParameter)itrGridPArameterList.next(); 
   	 if(masParameter1.getSpParameter().getId().equals(masParameter11.getId()) && masParameter11.getStatus().equalsIgnoreCase("y")){%>
   	data_arr[<%= counter%>][2] = "<%=masParameter11.getSpParameterName().trim()%>"
   	<%}else if(masParameter1.getSpParameter().getId().equals(masParameter11.getId()) && masParameter11.getStatus().equalsIgnoreCase("n")){%>
   	data_arr[<%= counter%>][2] = "<%= masParameter11.getSpParameterName().trim()%>"
   		
   	<%}
      }catch(Exception e){e.printStackTrace();}}

      
      %>


	<% if(masParameter1.getStatus().equalsIgnoreCase("y")){ %>
	data_arr[<%= counter%>][3] = "Active"
	<%}else{%>
	data_arr[<%= counter%>][3] = "InActive"
	<%}%>
data_arr[<%= counter%>][4] = "<%= masParameter1.getSpParameter().getId()%>"
data_arr[<%= counter%>][5] = "<%= masParameter1.getLastChgBy()%>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(masParameter1.getLastChgDate()) %>"
data_arr[<%= counter%>][7] = "<%= masParameter1.getLastChgTime() %>"

<%
     counter++;
}
%>
<%-- 
<%
Iterator itr=masGroupList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             MasSpecialityGroup  masGroup = (MasSpecialityGroup)itr.next(); 
%>


data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masGroup .getId()%>
data_arr[<%= counter%>][1] = "<%=masGroup .getSpGroupCode()%>"
data_arr[<%= counter%>][2] = "<%= masGroup .getSpGroupName()%>"
<%
		Iterator itrGridGroupList=gridGroupList.iterator();
		 while(itrGridGroupList.hasNext())
            {
			 MasSpecialityGroup  masGroupItr = (MasSpecialityGroup)itrGridGroupList.next(); 
            
			 if(masGroupItr.getSpGroupName().getId().equals(masGroupItr.getId()) && masGroupItr.getStatus().equalsIgnoreCase("y")){
			
			 %>
				data_arr[<%= counter%>][3] = "<%=masGroupItr.getSpGroupName()%>"
			<%}else if(masGroupItr.getSpGroupName().getId().equals(masGroupList.getId()) && masGroupList.getStatus().equalsIgnoreCase("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masGroupList.getSpGroupName()%>";
				
			<%}
}%>

data_arr[<%= counter%>][4] = "<%= masGroupList.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masGroupList.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masGroupList.getLastChgTime() %>
	"
<% if(masGroupList.getStatus().equalsIgnoreCase("y")){ %>
	data_arr[
<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 --%>
formName = "gruPara"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
	makeTable(start,end);
	
totalPages = Math.ceil(data_arr.length/rowsPerPage);
goToPage(pgNo);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
