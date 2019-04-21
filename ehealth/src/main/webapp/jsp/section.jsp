<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * section.jsp  
 * Purpose of the JSP -  This is for Section.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 13th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasStoreSection"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<MasStoreGroup> itemGroupList = new ArrayList<MasStoreGroup>();
	List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchStoreSectionList = (ArrayList)map.get("searchStoreSectionList");
	System.out.println("searchStoreSectionList=="+searchStoreSectionList.size());
	if(map.get("itemGroupList") != null){
		itemGroupList = (List)map.get("itemGroupList");
	}
	if(map.get("itemTypeList") != null){
		itemTypeList = (List)map.get("itemTypeList");
	}
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	String uniqueCode="SEC/"+searchStoreSectionList.size();
	if(map.get("message") != null){
		 String  message = (String)map.get("message");
		 
		   %>
		   
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.MasItemType"%><h4><span><%=message %></span></h4>
		 <%} %>
<div class="titleBg">
<h2>Item Section Master</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label class="auto">Item Section Code</label> 
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" /> 
<label class="auto"> Item Section Name </label> 
<input	type="radio" name="<%=SELECTED_RADIO %>" value="2" maxlength="2" class="radiobutMargin" /> 
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Section Code,alphanumeric,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'pharmacy?method=searchStoreSection')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','pharmacy?method=searchStoreSection','checkSearch')" tabindex=1 />
<%--- Report Button   
<input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/> --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_pvms_niv_section">
 

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
		if(searchStoreSectionList.size()>0)
		 {
			String strForCode = (String)map.get("sectionCode");
			String strForCodeDescription = (String)map.get("sectionName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h4><a href="pharmacy?method=showStoreSectionJsp">Show All Records</a></h4> <%
			}
		 }
	if(searchStoreSectionList.size()==0 && map.get("search") != null)
	  {
	 %><h4> <a href="pharmacy?method=showStoreSectionJsp">Show All Records</a></h4>
<%
}
	%> <script type="text/javascript">
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"itemTypeId"],[7,"itemGroupId"],[8,"<%=STATUS%>"] ];
	 statusTd = 8;
	</script></div>
<div class="clear"></div>
<form name="section" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> 
<input type="hidden" name="<%= POJO_NAME %>" value="MasStoreSection" /> 
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="SectionName" />
<input type="hidden" name="title" value="Section" /> 
<input type="hidden" name="<%=JSP_NAME %>" value="section" /> 
<input type="hidden" name="pojoPropertyCode" value="SectionCode" />
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Item Group </label>
<select name="itemGroupId" id="itemGroupId"	validate="Item Group,string,yes" onchange="populateItemType(this.value,'section');" tabindex=1>
	<option value="0">Select</option>
	<% 					
				for (MasStoreGroup  masStoreGroup : itemGroupList){
				%>
	<option value="<%=masStoreGroup.getId ()%>"><%=masStoreGroup.getGroupName().trim()%></option>
	<%}%>
</select>
<label><span>*</span> Item Type </label>
<select name="itemTypeId" id="itemTypeId"	validate="Item  Type,string,yes" tabindex=1>
	<option value="0">Select</option>
	<% 					
				for (MasItemType  masItemType : itemTypeList){
				%>
	<option value="<%=masItemType.getId()%>"><%=masItemType.getItemTypeName().trim()%></option>
	<%}%>
</select>
<label><span>*</span> Item Section Code</label>

<input id="codeId" type="text" name="<%= CODE%>" value="<%=uniqueCode %>" validate="Section Code,string,yes" MAXLENGTH="2" tabindex=1 readonly="readonly"/> 
<label><span>*</span> Item Section Name</label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Section Code,string,yes" MAXLENGTH="200" tabindex=1	onkeypress="return submitenter(this,event,'pharmacy?method=addStoreSection')" />
<script>
				document.section.<%=CODE%>.focus();
			</script>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('section','pharmacy?method=addStoreSection');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" style="display: none;" class="button"
	onClick="submitForm('section','pharmacy?method=editStoreSection')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" style="display: none;"
	class="button"
	onClick="submitForm('section','pharmacy?method=deleteStoreSection&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" /> <input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>

<div class="bottom">
<label>Changed By:</label> 
<label class="value"><%=userName%></label>
<label>Changed Date:</label> 
<label class="value"><%=date%></label> 
<label>Changed Time</label> 
<label class="value"><%=time%></label> 
<input type="hidden"	name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="paddingTop40"></div>
</div>
</form>
<div class="clear"></div>
<script type="text/javascript">
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Item Section Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Item Section Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_DATE %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%= CHANGED_TIME %>";


data_header[5] = new Array;
data_header[5][0] = "Item Type"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "itemTypeId";



data_header[6] = new Array;
data_header[6][0] = "Item Group"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "itemGroupId";

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchStoreSectionList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             MasStoreSection  masStoreSection = (MasStoreSection)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masStoreSection.getId()%>
data_arr[<%= counter%>][1] = "<%=masStoreSection.getSectionCode()%>"
data_arr[<%= counter%>][2] = "<%= masStoreSection.getSectionName()%>"
<%if(masStoreSection.getLastChgBy() != null){%>
data_arr[<%= counter%>][3] = "<%= masStoreSection.getLastChgBy().getId() %>"
<%}else{%>
data_arr[<%= counter%>][3] = "-"
<%}%>
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masStoreSection.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masStoreSection.getLastChgTime() %>"



	<%
	if(masStoreSection.getItemType()!= null){
	%>

	<%
	for(MasItemType masItemType :itemTypeList){
	     
		 if(masStoreSection.getItemType().getId().equals(masItemType.getId()) && masItemType.getStatus().equalsIgnoreCase("y")){%>
			data_arr[<%= counter%>][6] = "<%=masItemType.getItemTypeName().trim()%>"
		<%}else if(masStoreSection.getItemType().getId().equals(masItemType.getId()) && masItemType.getStatus().equalsIgnoreCase("n")){%>
			data_arr[<%= counter%>][6] = "<font id='error'>*</font>Parent InActivated--<%=masItemType.getItemTypeName().trim()%>";
		<%}
	}%>
	<%}else{
	%>
	data_arr[<%= counter%>][6] = "-"
	<%}%>

	

	<%
	if(masStoreSection.getItemType()!=null && masStoreSection.getItemType().getGroup()!= null){
	%>

	<%
	for(MasStoreGroup m :itemGroupList){
	     
		 if(masStoreSection.getItemType().getGroup().getId().equals(m.getId()) && m.getStatus().equalsIgnoreCase("y")){%>
			data_arr[<%= counter%>][7] = "<%=m.getGroupName().trim()%>"
		<%}else if(masStoreSection.getItemType().getGroup().getId().equals(m.getId()) && m.getStatus().equalsIgnoreCase("n")){%>
			data_arr[<%= counter%>][7] = "<font id='error'>*</font>Parent InActivated--<%=m.getGroupName().trim()%>";
		<%}
	}%>
	<%}else{
	%>
		data_arr[<%= counter%>][7] = "-"
	<%}%>

<% if(masStoreSection.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "section"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>

<script type="text/javascript">
var itemTypeArray = new Array();
<%
	int cnt = 0;
for (MasStoreGroup masStoreGroup:itemGroupList)
	{
		for (MasItemType masItemType:itemTypeList)
		{
			if(masItemType.getGroup()!= null){
			if( masStoreGroup.getId().equals(masItemType.getGroup().getId())){
						%>
						itemTypeArray[<%=cnt%>] = new Array();
						itemTypeArray[<%=cnt%>][0] = <%=masStoreGroup.getId()%>;
						itemTypeArray[<%=cnt%>][1] = <%=masItemType.getId()%>;
						itemTypeArray[<%=cnt%>][2] = "<%=masItemType.getItemTypeName()%>";

						<%
						cnt++;
			}}	} } %>
</script>