<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * country.jsp
 * Purpose of the JSP -  This is for Financial Year Details.
 * @author  Ujjwal
 * Create Date: 01st Feb,2011
 * Revision Date:
 * Revision By:
 * @version 1.15
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@ page import="jkt.hms.masters.business.BudObjectHead" %>
<%@ page import="jkt.hrms.*"%>
<%@ page import="jkt.hms.masters.business.BudMinorSubHead" %>
<%@ page import="jkt.hms.masters.business.BudSubMajorHead" %>
<%@ page import="jkt.hms.masters.business.BudMajorHead" %>
<%@ page import="jkt.hms.masters.business.BudMinorHead" %>
<%@page import="jkt.hms.util.Box"%>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%@page import="java.net.URL"%>
<%
Map map =new HashMap();
if(request.getAttribute("map")!=null){
	map = (Map) request.getAttribute("map");
}
Box box = HMSUtil.getBox(request);
Map<String, Object> utilmap = new HashMap<String, Object>();
utilmap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilmap.get("currentDate");
String time = (String)utilmap.get("currentTime");
List <BudObjectHead> searchObjectHeadList = new ArrayList<BudObjectHead>();
List <BudMajorHead> serchMajorHeadList = new ArrayList<BudMajorHead>();
List <BudSubMajorHead> searchsubmajorheadList = new ArrayList<BudSubMajorHead>();
List <BudMinorSubHead> searchminorsubheadList = new ArrayList<BudMinorSubHead>();
List <BudMajorHead> gridmajorheadList = new ArrayList<BudMajorHead>();
List <BudSubMajorHead> gridsubmajorheadList = new ArrayList<BudSubMajorHead>();
List <BudMinorSubHead> gridminorsubheadList = new ArrayList<BudMinorSubHead>();
List <BudMinorHead> searchminorheadList = new ArrayList<BudMinorHead>();

searchObjectHeadList  = (List <BudObjectHead>) map.get("searchobjectheadList");
serchMajorHeadList = (List <BudMajorHead>) map.get("searchmajorheadList");
searchsubmajorheadList = (List <BudSubMajorHead>) map.get("searchsubmajorheadList");
searchminorsubheadList = (List <BudMinorSubHead>) map.get("searchminorsubheadList");
searchminorheadList=(List <BudMinorHead>) map.get("searchminorheadList");
String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}
if(map.get("message") != null){
	   String message = (String)map.get("message");
	   %>
<h4><span><%=message %></span></h4>
<%} %>
<div class="clear"></div>
<div class="titleBg">
<h2>Object Head Master</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div class="searcharea">
<div class="searchbar">
<form name="search" method="post" action="" >
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label>Object Head Code</label>
<input type="radio"	name="<%=SELECTED_RADIO%>" value="1" checked="checked" class="radioCheck" tabindex=1 />
<label>Object Head Name</label>
<input	type="radio" name="<%=SELECTED_RADIO %>" value="2" checked="checked" class="radioCheck" />
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Sub-Major Head Code,string,no" MAXLENGTH="30" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=searchCountry')" />
<div class="clear"></div>
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','budget?method=searchObjectHead','checkSearch')" tabindex=1 />
<%--- Report Button   --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="bud_object_head">
</form>
</div>
</div>
<div class="clear"></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>
<%
if(searchObjectHeadList!=null){
		if(searchObjectHeadList.size()>0 )
		 {
			String strForCode = (String)map.get("objectHeadCode");
			String strForCodeDescription = (String)map.get("objectHeadName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
%><h4> <a href="budget?method=showObjectHead">Show All Records</a></h4> <%
			}
		 }
	 if(searchObjectHeadList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="budget?method=showObjectHead">Show All Records</a></h4>

<%
     }}
	%>


<script type="text/javascript">
formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%=SEARCH_NAME%>"], [3,"<%=MAJOR_HEAD_ID%>"],[4,"<%=MAJOR_SUB_HEAD_ID%>"],[5,"minorHeadId1"],[6,"<%=MINOR_SUB_HEAD_ID%>"],[7,"<%=SEQUENCE_NO%>"], [8,"<%=STATUS%>"],[9,"<%=FUND_ALLOCATED%>"] ];
	 statusTd = 9;
	</script></div>

<div class="clear"></div>

<form name="financialyear" method="post" action="">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="<%= POJO_NAME %>" value="BudObjectHead" />
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="ObjectHeadName"/>
<input	type="hidden" name="title" value="Country">
<input type="hidden" name="pojoPropertyCode" value="ObjectHeadCode">
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class=Block>
<label><span>*</span>Major Head Name</label>
<select	name="<%= MAJOR_HEAD_ID %>" class="Large" validate="MajorHead,string,yes" tabindex=1 onchange="populatemajorHead(this.value,'financialyear');">
<option value="0">Select</option>
<%
for (BudMajorHead majorHead: serchMajorHeadList){
%>
<option value="<%=majorHead.getId()%>">
<%=majorHead.getMajorHeadName()%></option>
<%}%>
</select>
<label><span>*</span>Major Sub Head Name</label>
<select	name="<%=MAJOR_SUB_HEAD_ID %>" id="subMajorHeadId" class="Large" tabindex=1  onchange="populatesubmajorHead(this.value,'financialyear');">
<option value="0">Select</option>
<%
			for(BudSubMajorHead subMajorHead : searchsubmajorheadList){
			%>
	<option value="<%=subMajorHead.getId() %>"
		<%=HMSUtil.isSelected(subMajorHead.getId(),Integer.valueOf(box.getInt(SUB_MAJOR_HEAD_ID)))%>><%=subMajorHead.getSubMajorHeadName() %></option>
	<%}%>
	</select>
<script type="text/javascript">

<%

	int counter = 0;

	for (BudMajorHead majorhead : serchMajorHeadList){
	for (BudSubMajorHead subMajorHead : searchsubmajorheadList) {
	if(subMajorHead.getMajorHeadId() != null){
	if(majorhead.getId().equals(subMajorHead.getMajorHeadId().getId() )){
		
%>
majorHeadCodeArray1[<%=counter%>] = new Array();
majorHeadCodeArray1[<%=counter%>][0]=<%=majorhead.getId()%>;
majorHeadCodeArray1[<%=counter%>][1] = <%=subMajorHead.getId()%>;
majorHeadCodeArray1[<%=counter%>][2] = "<%=subMajorHead.getSubMajorHeadName()%>";
	<%
	counter++;
	} } } }

%>
</script> 
<label><span>*</span>Minor Head Name</label>
<select	name="minorHeadId1" id="minorHead1" validate="SubMajorHead,string,yes" tabindex=1 class="Large" onchange="populateminorHead(this.value,'financialyear');"  >
<option value="0">Select</option>
<%
			for(BudMinorHead minorHead : searchminorheadList){
			%>
	<option value="<%=minorHead.getId() %>">
	<%=HMSUtil.isSelected(minorHead.getId(),Integer.valueOf(box.getInt("minorHead1")))%><%=minorHead.getMinorHeadName() %></option>
	<%}%>
	
	</select>
<script type="text/javascript">

<%

	int counter2 = 0;

	for (BudSubMajorHead submajorhead : searchsubmajorheadList){
	for (BudMinorHead minorHead : searchminorheadList) {
		if(minorHead.getSubMajorHeadId() != null){
	if(submajorhead.getId().equals(minorHead.getSubMajorHeadId().getId() )){
		
%>
majorHeadCodeArray2[<%=counter2%>] = new Array();
majorHeadCodeArray2[<%=counter2%>][0]=<%=submajorhead.getId()%>;
majorHeadCodeArray2[<%=counter2%>][1] = <%=minorHead.getId()%>;

majorHeadCodeArray2[<%=counter2%>][2] = "<%=minorHead.getMinorHeadName().trim()%>";
	<%
	counter2++;
	} } } }

%>
</script> 
<div class="clear"></div>
<label><span>*</span>Minor Sub Head</label>
<select	name="<%= MINOR_SUB_HEAD_ID %>" id="minorHeadId" validate="SubMajorHead,string,yes" tabindex=1 class="Large" >
<option value="0">Select</option>
<%
for (BudMinorSubHead majorHead: searchminorsubheadList){
%>
<option value="<%=majorHead.getId()%>">

<%=HMSUtil.isSelected(majorHead.getId(),Integer.valueOf(box.getInt(MINOR_SUB_HEAD_ID)))%><%=majorHead.getMinorSubHeadName() %></option>
<%}%>
	</select>
	<script type="text/javascript">

<%

	int count = 0;

	for (BudMinorHead minorHead : searchminorheadList){
	for (BudMinorSubHead majorHead: searchminorsubheadList) {
		if(majorHead.getMinorHeadId() != null){
	if(minorHead.getId().equals(majorHead.getMinorHeadId().getId() )){
		
%>
codeArray[<%=count%>] = new Array();
codeArray[<%=count%>][0]=<%=minorHead.getId()%>;
codeArray[<%=count%>][1] = <%=majorHead.getId()%>;

codeArray[<%=count%>][2] = "<%=majorHead.getMinorSubHeadName().trim()%>";
	<%
	count++;
	} } } }

%>
</script>
<label><span>*</span>Object Head Code</label>
<input type="text" id="ohId" name="<%= CODE%>" value="" validate="Object Head  Code,string,yes" class="Large" MAXLENGTH="8"  tabindex=1/>
<label><span>*</span>	Object Head Name</label>
<input type="text" id="ohname"  name="<%= SEARCH_NAME %>" value="" validate="Object Head  Name,string,yes" class="Large" MAXLENGTH="50" / tabindex=1>
<div class="clear"></div>
<!--<label >Sequence No</label>
<input type="text" id="ohname"  name="<%= SEQUENCE_NO %>" onblur="getSequenceNo(this.value);" value="" class="Large" MAXLENGTH="8" / tabindex=1>
--><label class="auto" style="padding:0px 12px 0px 5px;"><span>*</span>Designation of Officer to Whom Fund stand Allocated</label>
<input type="text" id="ohname"  name="<%= FUND_ALLOCATED %>" value="" validate="Designation,string,yes" class="Large" MAXLENGTH="20" / tabindex=1>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('financialyear','budget?method=addObjectHead');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('financialyear','budget?method=editObjectHead')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none" onClick="submitForm('financialyear','budget?method=deleteObjectHead&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName%></label>
<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label> <label class="value"><%=time%></label>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
</form>
<div class="clear">
</div>
<div class="paddingTop40">
</div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Object Head Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Object Head Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%=SEARCH_NAME%>";

data_header[2] = new Array;
data_header[2][0] = " Major Head Name"
data_header[2][1] = "hide";
data_header[2][2] = "40%";
data_header[2][3] = "<%=MAJOR_HEAD_ID%>";

data_header[3] = new Array;
data_header[3][0] = "Major sub Head Name"
data_header[3][1] = "hide";
data_header[3][2] = "15%";
data_header[3][3] = "<%=MAJOR_SUB_HEAD_ID %>";

data_header[4] = new Array;
data_header[4][0] = "Minor sub Head Name"
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "minorHeadId1";

data_header[5] = new Array;
data_header[5][0] = "Minor sub Head Name"
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%=MINOR_SUB_HEAD_ID %>";

data_header[6] = new Array;
data_header[6][0] = "Sequwncw No"
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=SEQUENCE_NO %>";

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";

data_header[8] = new Array;
data_header[8][0] = "Officer"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=FUND_ALLOCATED %>";

data_arr = new Array();
<%
Iterator itr=searchObjectHeadList.iterator();
          int  counter1=0;
          while(itr.hasNext())
           {            
             BudObjectHead  objecthead = (BudObjectHead)itr.next();       

%>

data_arr[<%= counter1%>] = new Array();
data_arr[<%= counter1%>][0] = <%= objecthead.getId()%>
data_arr[<%= counter1%>][1] = "<%=objecthead.getObjectHeadCode()%>"
data_arr[<%= counter1%>][2] = "<%=objecthead.getObjectHeadName()%>"
	<% if(objecthead.getMajorHeadId() != null){%>
	<%
			for(BudMajorHead majorhead : serchMajorHeadList)
			{
	            if(objecthead.getMajorHeadId() != null){
				if(objecthead.getMajorHeadId().getId().equals(majorhead.getId()) && majorhead.getStatus().equals("y")){
				 %>
					data_arr[<%= counter1%>][3] = "<%=majorhead.getMajorHeadName()%>"
				<%}else if(objecthead.getMajorHeadId().equals(majorhead.getId()) && majorhead.getStatus().equals("n")){%>
					data_arr[<%= counter1%>][3] = "<font id='error'>*</font>Parent InActivated--<%=majorhead.getMajorHeadName()%>";
					
				<%}
	            }
			}
	}%>
	<% if(objecthead.getMajorSubHeadId() != null){%>
	<%
			for(BudSubMajorHead subMajorHead : searchsubmajorheadList)
			{
	            if(objecthead.getMajorSubHeadId() != null){
				if(objecthead.getMajorSubHeadId().getId().equals(subMajorHead.getId()) && subMajorHead.getStatus().equals("y")){
				 %>
					data_arr[<%= counter1%>][4] = "<%=subMajorHead.getSubMajorHeadName()%>"
				<%}else if(objecthead.getMajorSubHeadId().getId().equals(subMajorHead.getId()) && subMajorHead.getStatus().equals("n")){%>
					data_arr[<%= counter1%>][4] = "<font id='error'>*</font>Parent InActivated--<%=subMajorHead.getSubMajorHeadName()%>";
					
				<%}
	            }
			}
	}%>

	<% if(objecthead.getMinorHeadId().getId() != null){%>
	<%
	
			for(BudMinorHead minorHead : searchminorheadList)
			{
	       //     if(objecthead.getMinorHeadId().getId() != null){
	            	
				if(objecthead.getMinorHeadId().getId().equals(minorHead.getId()) && minorHead.getStatus().equals("y")){
				 %>
					data_arr[<%= counter1%>][5] = "<%=minorHead.getMinorHeadName().trim()%>"
				<%}else if(objecthead.getMajorSubHeadId().getId().equals(minorHead.getId()) && minorHead.getStatus().equals("n")){%>
					data_arr[<%= counter1%>][5] = "<font id='error'>*</font>Parent InActivated--<%=minorHead.getMinorHeadName().trim()%>";
					
				<%}
	    //        }
			}
	}%>
	<% if(objecthead.getMinorSubHeadId().getId() != null){%>
	<%
			for(BudMinorSubHead minorSubHead : searchminorsubheadList)
			{
	         // if(objecthead.getMinorSubHeadId() != null){
				if(objecthead.getMinorSubHeadId().getId().equals(minorSubHead.getId()) && minorSubHead.getStatus().equals("y")){
				 %>
					data_arr[<%= counter1%>][6] = "<%=minorSubHead.getMinorSubHeadName()%>"
				<%}else if(objecthead.getMajorSubHeadId().getId().equals(minorSubHead.getId()) && minorSubHead.getStatus().equals("n")){%>
					data_arr[<%= counter1%>][6] = "<font id='error'>*</font>Parent InActivated--<%=minorSubHead.getMinorSubHeadName()%>";
					
				<%}
	       //  }
			}
	}%>	
data_arr[<%= counter1%>][7] = "<%= objecthead.getSequenceNo() %>"
<% if(objecthead.getStatus().equals("y")){ %>
data_arr[<%= counter1%>][8] = "Active"
<%}else{%>
data_arr[<%= counter1%>][8] = "InActive"
<%}%>
data_arr[<%= counter1%>][9] = "<%= objecthead.getFundAllocatedOfficer() %>"
<%
       counter1++;
}
%>
formName = "financialyear"
nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');

</script>
<script language="javascript">
function getSequenceNo(val)
{
	<%for(BudObjectHead budget:searchObjectHeadList){%>

if(<%=budget.getSequenceNo()%>==val)
{
	alert("Sequence No. already Exist.....");
	document.getElementById('fname11').value="";
	document.getElementById("fname11").focus();
return false;

}

<%}%>
}

</script>
