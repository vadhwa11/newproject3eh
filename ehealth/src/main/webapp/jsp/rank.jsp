<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * rank.jsp  
 * Purpose of the JSP -  This is for Rank.
 * @author  Dipali
 * @author  Vishal
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.8
--%>

<%@page import="jkt.hms.masters.business.MasStream"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasServiceStatus"%>
<%@page import="jkt.hms.masters.business.MasWing"%>
<%@page import="jkt.hms.masters.business.MasGrade"%>
<%@page import="jkt.hms.masters.business.MasCadre"%>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<MasStream> masStreamList = new ArrayList<MasStream>();
	List<MasWing> masWingList = new ArrayList<MasWing>();
	List<MasGrade> masGradeList = new ArrayList<MasGrade>();
	List<MasCadre> masCadreList = new ArrayList<MasCadre>();
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
	serviceTypeList = (ArrayList)map.get("serviceTypeList");
	
	List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
	rankCategoryList = (ArrayList)map.get("rankCategoryList");
	
	List<MasServiceStatus> serviceStatusList = new ArrayList<MasServiceStatus>();
	serviceStatusList = (ArrayList)map.get("serviceStatusList");
	
	ArrayList searchRankList = (ArrayList)map.get("searchRankList");
	ArrayList gridServiceTypeList = (ArrayList)map.get("gridServiceTypeList");
	if(map.get("masWingList") != null){
		masWingList=(List<MasWing> ) map.get("masWingList");
		
	}
	
	if(map.get("masGradeList") != null){
		masGradeList=(List<MasGrade>) map.get("masGradeList");
		
	}
	
	if(map.get("masStreamList") != null){
		masStreamList=(List<MasStream>) map.get("masStreamList");
		
	}
	
	if(map.get("masCadreList") != null){
		masCadreList=(List<MasCadre>) map.get("masCadreList");
		
	}
	
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
<h2>Designation Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label>Designation Code </label>
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin"/> 
<label>Designation Name </label> 
<input	type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" />
<input type="text" id="searchField"	name="<%= SEARCH_FIELD%>" value=""	validate="Designation Code,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'personnel?method=searchRank')" />

<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','personnel?method=searchRank','checkSearch')"	tabindex=1 /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<%--- Report Button   --%> 

<input type="button" name="Report" value="Report" class="buttonBig" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMastersforrank');" accesskey="g" tabindex=1 /> 
<input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_rank">
</form>
</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>
<% 
  if(searchRankList.size()>0)
   {
   String strForCode = (String)map.get("rankCode");
   String strForCodeDescription = (String)map.get("rankName");
   if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
   {
 %><h4> <a href="personnel?method=showRankJsp">Show All Records</a></h4> <%
			}
		 }
	 if(searchRankList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="personnel?method=showRankJsp">Show All Records</a></h4> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= RANK_CATEGORY_ID %>"], [4,"<%= SERVICE_STATUS_ID %>"], [5,"<%= SERVICE_TYPE_ID %>"], [6,"<%=CHANGED_BY%>"], [7,"<%=CHANGED_DATE%>"],[8,"<%=CHANGED_TIME%>"] 
				,  [9,"wing"], [10,"grade"],[11,"stream"],[12,"cadre"],[13,"<%=STATUS%>"],[14,"description"],[15,"designationOrder"]];
	 statusTd = 13;
	</script></div>

<form name="rank" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input type="hidden"
	name="<%= POJO_NAME %>" value="MasRank"> <input type="hidden"
	name="<%=POJO_PROPERTY_NAME %>" value="RankName"> <input
	type="hidden" name="title" value="Rank"> <input type="hidden"
	name="<%=JSP_NAME %>" value="rank"> <input type="hidden"
	name="pojoPropertyCode" value="RankCode">
<div class="paddingTop5"></div>
<div class="clear"></div>	
<div class="Block">
<label><span>*</span> Designation Code</label>
<input id="codeId" type="text" name="<%= CODE%>" value=""
	validate="Designation Code,string,yes" class="textbox_size20"
	MAXLENGTH="8" / tabindex=1> 
	<label><span>*</span> Designation Name</label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Designation Name,string,yes" class="textbox_size20"	MAXLENGTH="99"  tabindex=1> 
<script>
			document.rank.<%=CODE%>.focus();
		</script> 
		<%--	<label><span>*</span> Designation Category</label>
		<select name="<%= RANK_CATEGORY_ID %>" validate="Designation Category,string,yes" tabindex=1>
			<option value="">Select</option>
				  <% 
						for (MasRankCategory  masRankCategory : rankCategoryList){
				  %>
		    <option value="<%=masRankCategory.getId ()%>"><%=masRankCategory.getRankCategoryName()%></option>
			  		  
			    <%}%>
		</select> --%>

<%--  	<label><span>*</span>Service Status</label>
		<select name="<%= SERVICE_STATUS_ID %>" validate="Service Status,string,yes" tabindex=1>
			<option value="">Select</option>
			<% 
				for (MasServiceStatus  masServiceStatus : serviceStatusList){
			%>
		    
			<option value="<%=masServiceStatus.getId ()%>"><%=masServiceStatus.getServiceStatusName()%></option>
          	  <%}%>
	 	</select>
		<label><span>*</span> Service Type:</label>
		<select name="<%= SERVICE_TYPE_ID %>" validate="Service Type,string,yes" tabindex=1 onkeypress="return submitenter(this,event,'personnel?method=addRank')">
			<option value="">Select</option>
		    <% 
		 		for (MasServiceType  masServiceType : serviceTypeList){
			%>
		    <option value="<%=masServiceType.getId ()%>"><%=masServiceType.getServiceTypeName()%></option>
            <%}%>
		</select> --%>
		<label><span>*</span> Wing </label> 
<select name="wing" validate="Wing ,string,yes" tabindex=1>
			<option value="">Select</option>
			 <% 
				for (MasWing  mw : masWingList){
			%>
		    
			<option value="<%=mw.getId ()%>"><%=mw.getWingName()%></option>
          	  <%}%>
	 	</select> 
	 	<div class="clear"></div>
	 			<label><span>*</span> Grade Level</label> 
<select name="grade" validate="Grade Name,string,yes" tabindex=1>
			<option value="">Select</option>
			 <% 
				for (MasGrade  mg : masGradeList){
			%>		    
			<option value="<%=mg.getId ()%>"><%=mg.getGradeLevel()%></option>
          	  <%}%> 
	 	</select> 
	 			<label><span>*</span> Stream </label> 
<select name="stream" validate="Stream ,string,yes" tabindex=1>
			<option value="">Select</option>
		 <% 
				for (MasStream  ms : masStreamList){
			%>
		    
			<option value="<%=ms.getId ()%>"><%=ms.getStreamName()%></option>
          	  <%}%>
	 	</select> 
	 	
	 	<label><span>*</span> Cadre</label> 
<select name="cadre" validate="Cadre,string,yes" tabindex=1>
			<option value="">Select</option>
		 <% 
				for (MasCadre  mc : masCadreList){
			%>
		    
			<option value="<%=mc.getId ()%>"><%=mc.getCadreName()%></option>
          	  <%}%>
	 	</select> 
	 	
	 	<div class="clear"></div>
	 	
 <label > Designation Order  </label>
		<input  type="text" name="designationOrder" value=""  validate="Designation Order,int,no"  tabindex=1 maxlength="2" />
	 	
	 	<label> Description</label> 
<input type="text" name="description" value="" validate="Description,string,no" class="textbox_size20"	MAXLENGTH="100"  tabindex=1> 
<div class="clear"></div>

<div id="edited"></div>

<input type="button" name="add" id="addbutton" value="Add"
	class="button" onClick="submitForm('rank','personnel?method=addRank');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" style="display: none;" class="button"
	onClick="submitForm('rank','personnel?method=editRank')" accesskey="u"
	tabindex=1 /> <input type="button" name="Delete" id="deletebutton"
	value="Activate" class="button" style="display: none;"
	onClick="submitForm('rank','personnel?method=deleteRank&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" /> <input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" />

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By:</label> 
<label	class="value"><%=userName%></label> 
<label>Changed Date:</label>
 <label	class="value"><%=date%></label> 
 <label>Changed Time:</label> 
 <label	class="value"><%=time%></label> 
 <input type="hidden"	name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
 <input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
 <input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="clear"></div>
</div>
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Designation Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Designation Name"
data_header[1][1] = "data";
data_header[1][2] = "30%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Designation Category"
data_header[2][1] = "hide";
data_header[2][2] = "30%";
data_header[2][3] = "<%= RANK_CATEGORY_ID %>";

data_header[3] = new Array;
data_header[3][0] = "Service Status"
data_header[3][1] = "hide";
data_header[3][2] = "20%";
data_header[3][3] = "<%= SERVICE_STATUS_ID %>";

data_header[4] = new Array;
data_header[4][0] = "Service Type"
data_header[4][1] = "hide";
data_header[4][2] = "35%";
data_header[4][3] = "<%=SERVICE_TYPE_ID %>";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] =  "<%=CHANGED_BY %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] ="<%=CHANGED_DATE %>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] =  "<%=CHANGED_TIME %>"

data_header[8] = new Array;
data_header[8][0] = "Wing"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "wing";


data_header[9] = new Array;
data_header[9][0] = "Grade Level"
data_header[9][1] = "data";
data_header[9][2] = "15%";
data_header[9][3] = "grade";


data_header[10] = new Array;
data_header[10][0] = "Stream"
data_header[10][1] = "data";
data_header[10][2] = "15%";
data_header[10][3] = "stream";

data_header[11] = new Array;
data_header[11][0] = "Cadre"
data_header[11][1] = "hide";
data_header[11][2] = "15%";
data_header[11][3] = "cadre";

data_header[12] = new Array;
data_header[12][0] = "Status"
data_header[12][1] = "data";
data_header[12][2] = "15%";
data_header[12][3] = "<%=STATUS %>";

data_header[13] = new Array;
data_header[13][0] = "Description"
data_header[13][1] = "hide";
data_header[13][2] = "15%";
data_header[13][3] = "description";

data_header[14] = new Array;
data_header[14][0] = "Designation Order"
data_header[14][1] = "hide";
data_header[14][2] = "15%";
data_header[14][3] = "designationOrder";

data_arr = new Array();

<%

Iterator itr=searchRankList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasRank  masRank = (MasRank)itr.next(); 
  %>            

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%=masRank.getId()%>"
data_arr[<%= counter%>][1] = "<%=masRank.getRankCode()%>"
data_arr[<%= counter%>][2] = "<%= masRank.getRankName()%>"
<%
	Iterator itrRankCategoryList=rankCategoryList.iterator();
	 while(itrRankCategoryList.hasNext())
           {
            MasRankCategory  masRankCategoryGrid = (MasRankCategory)itrRankCategoryList.next(); 
		 if(masRank.getRankCategory()!=null && masRank.getRankCategory().getId().equals(masRankCategoryGrid.getId()) && masRankCategoryGrid.getStatus().equals("y")){%>
			data_arr[<%= counter%>][3] = "<%=masRankCategoryGrid.getRankCategoryName()%>"
		<%}else if(masRank.getRankCategory()!=null && masRank.getRankCategory().getId().equals(masRankCategoryGrid.getId()) && masRankCategoryGrid.getStatus().equals("n")){%>
			data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masRankCategoryGrid.getRankCategoryName()%>";
			
		<%}
}%>
<%
	Iterator itrServiceStatusList=serviceStatusList.iterator();
	 while(itrServiceStatusList.hasNext())
           {
            MasServiceStatus  masServiceStatusGrid = (MasServiceStatus)itrServiceStatusList.next(); 
		 if(masRank.getServiceStatus()!=null && masRank.getServiceStatus().getId().equals(masServiceStatusGrid.getId()) && masServiceStatusGrid.getStatus().equals("y")){%>
			data_arr[<%= counter%>][4] = "<%=masServiceStatusGrid.getServiceStatusName()%>"
		<%}else if(masRank.getServiceStatus()!=null && masRank.getServiceStatus().getId().equals(masServiceStatusGrid.getId()) && masServiceStatusGrid.getStatus().equals("n")){%>
			data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=masServiceStatusGrid.getServiceStatusName()%>";
			
		<%}
}%>

<%
		Iterator itrGridServiceTypeList=gridServiceTypeList.iterator();
		 while(itrGridServiceTypeList.hasNext())
            {try{
             MasServiceType  serviceTypeGrid = (MasServiceType)itrGridServiceTypeList.next(); 
			 if(masRank.getServiceType()!=null && masRank.getServiceType().getId().equals(serviceTypeGrid.getId()) && serviceTypeGrid.getStatus().equalsIgnoreCase("y")){%>
				data_arr[<%= counter%>][5] = "<%=serviceTypeGrid.getServiceTypeName()%>"
			<%}else if(masRank.getServiceType()!=null && masRank.getServiceType().getId().equals(serviceTypeGrid.getId()) && serviceTypeGrid.getStatus().equalsIgnoreCase("n")){%>
				data_arr[<%= counter%>][5] = "<font id='error'>*</font>Parent InActivated--<%=serviceTypeGrid.getServiceTypeName()%>";
				
			<%}
            }catch(Exception e){e.printStackTrace();}}%>
data_arr[<%= counter%>][6] = "<%= masRank.getLastChgBy() %>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(masRank.getLastChgDate()) %>"
data_arr[<%= counter%>][8] = "<%= masRank.getLastChgTime() %>"

<% if(masRank.getWing() != null){ %>
data_arr[<%= counter%>][9] = "<%=masRank.getWing().getWingName()%>"
<%}else{%>
data_arr[<%= counter%>][9] = ""
<%}%>

<% if(masRank.getGrade() != null){ %>
data_arr[<%= counter%>][10] = "<%=masRank.getGrade().getGradeLevel()%>"
<%}else{%>
data_arr[<%= counter%>][10] = ""
<%}%>

<% if(masRank.getStream() != null){ %>
data_arr[<%= counter%>][11] = "<%=masRank.getStream().getStreamName()%>"
<%}else{%>
data_arr[<%= counter%>][11] = ""
<%}%>

<% if(masRank.getCadre() != null){ %>
data_arr[<%= counter%>][12] = "<%=masRank.getCadre().getCadreName()%>"
<%}else{%>
data_arr[<%= counter%>][12] = ""
<%}%>

<% if(masRank.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][13] = "Active"
<%}else{%>
data_arr[<%= counter%>][13] = "InActive"
<%}%>
<% if(masRank.getDescription() != null ){ %>
data_arr[<%= counter%>][14] = "<%=masRank.getDescription() %>"
<%}else{%>
data_arr[<%= counter%>][14] = ""
<%}%>

<% if(masRank.getDesignationOrder() != null ){ %>
data_arr[<%= counter%>][15] = "<%=masRank.getDesignationOrder() %>"
<%}else{%>
data_arr[<%= counter%>][15] = ""
<%}%>

<%
		     counter++;
}
%>
 
formName = "rank"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
