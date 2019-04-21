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

<%@page import="jkt.hms.masters.business.MasSpecialityHeading"%>
<%@page import="jkt.hms.masters.business.MasSpecialityGroup"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasSpecialityGroup"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		
		List<MasSpecialityGroup> masGroupList = new ArrayList<MasSpecialityGroup>();
		List<MasSpecialityHeading>headingList = new ArrayList<MasSpecialityHeading>();
		
		List<MasSpecialityGroup> gridGroupList = new ArrayList<MasSpecialityGroup>();
		String userName = "";
		
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if(map.get("masGroupList") != null){
			masGroupList = (ArrayList)map.get("masGroupList");
		}
			
	    if(map.get("gridGroupList") != null){
	    	gridGroupList = (ArrayList)map.get("gridGroupList");
	           }
	    if(map.get("headingList") != null){
	    	headingList = (ArrayList)map.get("headingList");
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
	String sGroupCode = "";
	if(map.get("sGroupCode") != null){
		sGroupCode = (String)map.get("sGroupCode");
           }
	
	if(map.get("message") != null){
		  String message = (String)map.get("message");
		   %>
		
<h4>
	<span><%=message %></span>
</h4>
<%}
	int pageNo = 0;
	if(map.get("pageNo") != null){
		pageNo = (Integer)map.get("pageNo");
	}
%>

<div class="titleBg">
	<h2>Speciality Group Master</h2>
</div>
<div class="Block">
	<div id="searcharea">
		<div id="searchbar">
			<form name="search" method="post" action="">
			
					 <label>Group Code </label>
<input type="radio"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" />
<label>Group Name </label>
<input type="radio"	name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" /> 
				<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Group Code,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'generalMaster?method=searchGroup')" />
					
				<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','generalMaster?method=searchGroup','checkSearch')"		tabindex=1 />
				<%--- Report Button   --%>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>			
		</div>
	</div>
	<div class="clear"></div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
	<div id="searchtable" tabindex=2></div>
	<% 
		if(masGroupList.size()>0 || masGroupList.size() > 0)
		 {
			String strForCode = (String)map.get("groupCode");
			String strForCodeDescription = (String)map.get("groupName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%><h4>
		<a href="generalMaster?method=showGroupJsp">Show All Records </a>
	</h4>
	<%
			}
		 }
	 if(masGroupList.size()==0 && map.get("search") != null)
	  {
	 %>
	<h4>
		<a href="generalMaster?method=showGroupJsp">Show All Records</a>
	</h4>
	<%
     }
	%>
	<script type="text/javascript">

	formFields = [
	 			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= STATUS%>"],  [4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"display"],[8,"heading"] ];
	 statusTd = 3;

	</script>
</div>

<form name="state" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<input type="hidden" name="<%= POJO_NAME %>" value="MasSpecialityGroup">
		<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="SpGroupName">
			<input type="hidden" name="<%=POJO_PROPERTY_CODE %>"
			value="SpGroupCode"> <input type="hidden" name="title"
				value="Group"> <input type="hidden" name="<%=JSP_NAME %>"
					value="group"> <input type="hidden" name="pojoPropertyCode"
						value="SpGroupCode">

							<div class="paddingTop5"></div>
							<div class="clear"></div>
							<div class="Block">
								<label><span>*</span> Group Code</label> 
								<%-- <%if(gridGroupList.size() ==0){ %>
								<input type="text" name="<%= CODE%>" value="G1" validate="Group Code,alphanumeric,yes" class="textbox_size20" MAXLENGTH="8" tabindex=1 />
									<%}else{ %> --%>
								<input type="text" name="<%= CODE%>" value="<%=sGroupCode %>" validate="Group Code,alphanumeric,yes" class="textbox_size20" MAXLENGTH="8" tabindex=1 />
									
									<%//} %>
									 <label><span>*</span>Group Name </label> 
									<%--  <%if(gridGroupList.size() ==0){ %>
									<input type="text" name="<%= SEARCH_NAME %>" value="Group1" validate="Group Name,alphanumeric,yes" class="textbox_size20" MAXLENGTH="50" tabindex=1 />
									<%}else{ %> --%>
									<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Group Name,string,yes" class="textbox_size20" MAXLENGTH="100" tabindex=1 />
									<%//} %>
								<script>
			document.state.<%=CODE%>.focus();
			</script>
			
			<label>Heading</label> 
								<select id="heading"	name="heading" validate="Department,string,no" tabindex=1>
									<option value="0">Select</option>
									<% 
				             for ( MasSpecialityHeading heading: headingList){
				            %>
									<option value="<%=heading.getId ()%>"><%=heading.getSpHeadingOne()%></option>
									<%}%>

								</select> 

<div class="clear"></div>
					<label>Display</label>
                            <input type="checkbox" value="y" name="display" checked="checked"  class="checkbox" />
								<div class="clear"></div>							
							<div id="edited"></div>
							
							 <input type="button" name="add"
							id="addbutton" value="Add" class="button"
							onClick="submitForm('state','generalMaster?method=addGroup');"accesskey="a" tabindex=1 />
							
							 <input type="button" name="edit" id="editbutton" value="Update" style="display: none;"
							class="button"	onClick="submitForm('state','generalMaster?method=editGroupToDatabase')"
							accesskey="u" tabindex=1 /> 
							
							
							<input type="button" name="Delete"id="deletebutton" value="Activate" class="button"
							style="display: none;" onClick="submitForm('state','generalMaster?method=deleteGroup&flag='+this.value)"
							accesskey="d" tabindex=1 />
							
							 <input type="reset" name="Reset"id="reset" value="Reset" class="buttonHighlight"
							onclick="resetCheck();" accesskey="r" />
							
							 <input type="hidden"name="<%=STATUS %>" value="" /> <input type="hidden"
							name="<%= COMMON_ID%>" value="" /> 
							
						
							
							<input type="hidden" id="pageNoEdit" name="pageNoEdit"
							value="<%=pageNo%>" /> <!--  -->
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
data_header[0][0] = "Group Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Group Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Status"
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "<%=STATUS %>";


data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_BY %>"

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


data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "display"

	data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "display"



data_arr = new Array();


<%
Iterator itr=masGroupList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             MasSpecialityGroup  masSpGroup = (MasSpecialityGroup)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masSpGroup.getId()%>
data_arr[<%= counter%>][1] = "<%=masSpGroup.getSpGroupCode()%>"
data_arr[<%= counter%>][2] = "<%= masSpGroup.getSpGroupName()%>"
	<% if(masSpGroup.getStatus().equalsIgnoreCase("y")){ %>
	data_arr[<%= counter%>][3] = "Active"
	<%}else{%>
	data_arr[<%= counter%>][3] = "InActive"
	<%}%>
data_arr[<%= counter%>][4] = "<%= masSpGroup.getLastChgBy()%>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masSpGroup.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masSpGroup.getLastChgTime() %>"

	<% if(masSpGroup.getDisplay() != null){ %>
	data_arr[<%= counter%>][7] = "<%=masSpGroup.getDisplay()%>"
	<%}else{%>
	data_arr[<%= counter%>][7] = "n"
	<%}%>
	
	<%if(masSpGroup!=null && masSpGroup.getSpHeading()!=null){%>
   	data_arr[<%= counter%>][8] = "<%= masSpGroup.getSpHeading().getSpHeadingOne()%>"
   	<%}else{%>
   	data_arr[<%= counter%>][8] = ""
   	<%}%>

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
formName = "state"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
	makeTable(start,end);
	
//pgNo = '<%=pageNo%>';
//totalPages = Math.ceil(data_arr.length/rowsPerPage);
//goToPage(pgNo);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
