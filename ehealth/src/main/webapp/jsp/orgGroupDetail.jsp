<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * department.jsp  
 * Purpose of the JSP -  This is for Department details 
 * @author  Dipali
 * @author  Vishal
 * Create Date: 10th April,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgMasOrganism"%>
<%@page import="jkt.hms.masters.business.DgMasOrganismGroup"%>
<%@page import="jkt.hms.masters.business.DgOrgGrpDtl"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<DgMasOrganismGroup> organismGroupList = new ArrayList<DgMasOrganismGroup>();
	List<DgMasOrganism> organismList = new ArrayList<DgMasOrganism>();
	organismList = (ArrayList)map.get("organismList");
	organismGroupList = (ArrayList)map.get("organismGroupList");
	ArrayList searchOrganismGroupDetailList = (ArrayList)map.get("searchOrganismGroupDetailList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		 String  message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		 <%} %> 
<div class="titleBg">
<h2>Organism Group Detail</h2>
</div>
<div class="Block">
<div class="clear"></div>
<div class="paddingTop5"></div>

<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label>Organism Group </label> 
<input type="text" id="searchField" name="<%=SEARCH_NAME%>" value="" validate="Organism Group,string,no" MAXLENGTH="8" onkeypress="return submitenter(this,event,'laboratory?method=searchOrganismGroupDetail)" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','laboratory?method=searchOrganismGroupDetail','checkSearch')" tabindex=1 /> 
<%--- Report Button  --%> 
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_org_grp_details">
</form>
</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>
<% 
  if(searchOrganismGroupDetailList.size()>0)
   {
   String strForCode = (String)map.get("organismGroupName");
   if(strForCode!= null && strForCode!= "" )
   {
 %> <h4><a href="laboratory?method=showOrganismGroupDetailJsp">Show All Records</a></h4> <%
		
		  }
	   }
	 if(searchOrganismGroupDetailList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="laboratory?method=showOrganismGroupDetailJsp">Show All
Records</a></h4> <%
    }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= ORGANISM_GROUP_ID%>"], [2,"<%= ORGANISM_ID %>"], [3,"<%= CHANGED_BY %>"], [4,"<%= CHANGED_DATE%>"], [5,"<%= CHANGED_TIME %>"],[6,"<%= STATUS %>"]];
	 statusTd = 6;
</script></div>
<form name="orgGroupDetail" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="<%= POJO_NAME %>" value="DgOrgGrpDtl">
<input type="hidden" name="title" value="orgGroupDetail">
<input type="hidden" name="<%=JSP_NAME %>" value="orgGroupDetail">
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Organism Group </label> 
<select name="<%= ORGANISM_GROUP_ID %>" validate="Organism Group,string,yes" tabindex=1>
<option value="">Select</option>
<% 
for (DgMasOrganismGroup  organismGroup : organismGroupList){
				if(organismGroup.getStatus().equals("y")){
		 %>
	<option value="<%=organismGroup.getId ()%>"><%=organismGroup.getOrganismGroupName()%></option>
	<%}
        }%>
</select> 
<label><span>*</span> Organism </label>
<select	name="<%= ORGANISM_ID %>" validate="Organism,string,yes" tabindex=1>
<option value="">Select</option>
	<% 
			for (DgMasOrganism  dgMasOrganism : organismList){
		 %>
	<option value="<%=dgMasOrganism.getId ()%>"><%=dgMasOrganism.getOrganismName()%></option>
	<%}%>
</select>

<div class="clear"></div>
<div id="edited"></div>

<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('orgGroupDetail','laboratory?method=addOrganismGroupDetail');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" style="display: none;" class="button"
	onClick="submitForm('orgGroupDetail','laboratory?method=editOrganismGroupDetail')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" style="display: none;"
	class="button"
	onClick="submitForm('orgGroupDetail','laboratory?method=deleteOrganismGroupDetail&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" /> <input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" />


<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div></form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Oragnism Group "
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= ORGANISM_GROUP_ID%>"

data_header[1] = new Array;
data_header[1][0] = "Oragnism"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= ORGANISM_ID %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%=CHANGED_BY %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_DATE %>";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CHANGED_TIME %>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>"

data_arr = new Array();

<%
Iterator itr=searchOrganismGroupDetailList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             DgOrgGrpDtl  dgOrgGrpDtl = (DgOrgGrpDtl)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= dgOrgGrpDtl.getId()%>


            
            <%
		Iterator itrOrganismGroupList=organismGroupList.iterator();
		 while(itrOrganismGroupList.hasNext())
            {try{
             DgMasOrganismGroup  organismGroup = (DgMasOrganismGroup)itrOrganismGroupList.next(); 
			 if(dgOrgGrpDtl.getOrganismGroup().getId().equals(organismGroup.getId()) && organismGroup.getStatus().equals("y")){
			 
			 %>
				data_arr[<%= counter%>][1] = "<%=organismGroup.getOrganismGroupName()%>";
			<%}else if(dgOrgGrpDtl.getOrganismGroup().getId().equals(organismGroup.getId()) && organismGroup.getStatus().equals("n")){
			
			%>
				data_arr[<%= counter%>][1] = "<span>*</span>Parent InActivated--<%=organismGroup.getOrganismGroupName()%>";
				
			<%}
            }catch(Exception e){e.printStackTrace();}}%>
            
            <%
		Iterator itrOrganismDetailList=organismList.iterator();
		 while(itrOrganismDetailList.hasNext())
		 {try{
             DgMasOrganism  dgMasOrganism = (DgMasOrganism)itrOrganismDetailList.next(); 
			 if(dgOrgGrpDtl.getOrganism().getId().equals(dgMasOrganism.getId()) && dgMasOrganism.getStatus().equals("y")){%>
				data_arr[<%= counter%>][2] = "<%=dgMasOrganism.getOrganismName()%>"
			<%}else if(dgOrgGrpDtl.getOrganism().getId().equals(dgMasOrganism.getId()) && dgMasOrganism.getStatus().equals("n")){%>
				data_arr[<%= counter%>][2] = "<span>*</span>Parent InActivated--<%=dgMasOrganism.getOrganismName()%>";
				
			<%}
            }catch(Exception e){e.printStackTrace();}}%>
data_arr[<%= counter%>][3] = "<%= dgOrgGrpDtl.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(dgOrgGrpDtl.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= dgOrgGrpDtl.getLastChgTime() %>"
<% if(dgOrgGrpDtl.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "orgGroupDetail"

start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
