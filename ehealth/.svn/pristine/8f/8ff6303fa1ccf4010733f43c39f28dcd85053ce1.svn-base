<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * country.jsp
 * Purpose of the JSP -  This is for Country Details.
 * @author  Ujjwal
 * Create Date: 28th Jan,2011
 * Revision Date:
 * Revision By:
 * @version 1.15
--%>
<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.BudSubMajorHead"%>
<%@page import="jkt.hms.masters.business.BudMajorHead"%>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<BudSubMajorHead> searchSubMajorHeadList = new ArrayList<BudSubMajorHead>();
	List<BudMajorHead> majorHeadList = new ArrayList<BudMajorHead>();
	List<BudMajorHead> gridMajorHeadList = new ArrayList<BudMajorHead>();
	searchSubMajorHeadList = (List<BudSubMajorHead>)map.get("searchSubMajorHeadList");
	gridMajorHeadList = (List<BudMajorHead>)map.get("gridMajorHeadList");
	majorHeadList = (List<BudMajorHead>)map.get("majorHeadList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>

<h4><span><%=message %></span></h4>
<%} %>
<div class="titleBg">
<h2>Budget Sub-Major Head Master</h2>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<div class="searcharea">
<div class="searchar">
<form name="search" method="post" action="" >
<label>Sub-Major Head Code</label>
<input type="radio"	name="<%=SELECTED_RADIO%>" value="1" checked="checked" class="radioCheck" tabindex=1 />
<label>Sub-Major Head Name</label>
<input	type="radio" name="<%=SELECTED_RADIO %>" value="2" checked="checked" class="radioCheck" />
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Sub-Major Head Code,string,no" MAXLENGTH="30" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=searchCountry')" />
<div class="clear"></div>
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','budget?method=searchsubmajorHead','checkSearch')" tabindex=1 />
<%--- Report Button   --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="bud_sub_major_head">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
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
if(searchSubMajorHeadList!=null){

		if(searchSubMajorHeadList.size()>0 )
		 {
			String strForCode = (String)map.get("submajorheadCode");
			String strForCodeDescription = (String)map.get("submajorheadName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
%><h4> <a href="budget?method=showSubMajorHead">Show All Records</a></h4> <%
			}
		 }
	 if(searchSubMajorHeadList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="budget?method=showSubMajorHead">Show All Records</a></h4>

<%
     }}
	%>



<script type="text/javascript">
formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%=SEARCH_NAME%>"], [3,"<%=MAJOR_HEAD_ID%>"], [4,"<%=STATUS%>"] ];
	 statusTd = 4;
	</script>
</div>
<form name="cylindertypeMaster" method="post" action="">
<input type="hidden" name="<%= POJO_NAME %>" value="BudSubMajorHead">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="SubMajorHeadName">
<input	type="hidden" name="title" value="Country">
<input type="hidden" name="pojoPropertyCode" value="SubMajorHeadCode">
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Sub-Major Code</label>
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Sub MAjor Head Code,string,yes" class="textbox_size20" MAXLENGTH="8" / tabindex=1>
<label><span>*</span> Sub-Major Name</label>
<input type="text" name="<%=SEARCH_NAME%>" value="" validate="Sub MAjor Head Name,string,yes" class="Large"	MAXLENGTH="50" / tabindex=1>
<div class="clear"></div>
<label><span>*</span> Major Head Name</label>
<select	name="<%= MAJOR_HEAD_ID %>"  validate="MajorHead,string,yes" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=addCountry')">
<option value="0">Select</option>
<%
for (BudMajorHead majorHead: majorHeadList){
%>
<option value="<%=majorHead.getId()%>"><%=majorHead.getMajorHeadName().trim()%></option>

<%}%>
</select>

<!--<label> Sequence No</label>
<input type="text" id="fname11"  name="<%= SEQUENCE_NO %>" value=""  class="Large" MAXLENGTH="8" onblur="getSequenceNo(this.value);"  tabindex=1>
<div class="clear"></div>-->

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('cylindertypeMaster','budget?method=addSubMajorHead');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('cylindertypeMaster','budget?method=editSubMajorHead')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none" onClick="submitForm('cylindertypeMaster','budget?method=deleteSubMajorHead&flag='+this.value)" accesskey="d" tabindex=1 />
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
data_header[0][0] = "Sub Major Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Sub Major Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%=SEARCH_NAME%>";

data_header[2] = new Array;
data_header[2][0] = " Major Head Name"
data_header[2][1] = "hide";
data_header[2][2] = "40%";
data_header[2][3] = "<%=MAJOR_HEAD_ID%>";

data_header[3] = new Array;
data_header[3][0] = "Status"
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%=STATUS %>";



data_arr = new Array();
<%

Iterator itr=searchSubMajorHeadList.iterator();
int  counter=0;
while(itr.hasNext())
{
	BudSubMajorHead subMajorHead = (BudSubMajorHead)itr.next();
	

%>
		data_arr[<%= counter%>] = new Array();
		data_arr[<%= counter%>][0] = <%= subMajorHead.getId()%>
		data_arr[<%= counter%>][1] = "<%= subMajorHead.getSubMajorHeadCode()%>"
		data_arr[<%= counter%>][2] = "<%= subMajorHead.getSubMajorHeadName().trim()%>"
<%
				Iterator itrGridMajorHeadList=majorHeadList.iterator();
	 			while(itrGridMajorHeadList.hasNext())
        		{
	 				try
	 				{
	 					BudMajorHead  submajorheadGrid = (BudMajorHead)itrGridMajorHeadList.next();
	 					
	 					if(subMajorHead.getMajorHeadId().getId().equals(submajorheadGrid.getId()) && submajorheadGrid.getStatus().equals("y"))
		 				{
%>
							data_arr[<%= counter%>][3] = "<%=submajorheadGrid.getMajorHeadName().trim()%>"
<%
						}
		 				else if(subMajorHead.getId().equals(submajorheadGrid.getId()) && submajorheadGrid.getStatus().equals("n"))
		 				{
%>
							data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=submajorheadGrid.getMajorHeadName().trim()%>"

<%
						}
        			}
	 				catch(Exception e)
	 				{
	 					e.printStackTrace();
	 				}
	 			}
%>


<%
		if(subMajorHead.getStatus().equals("y"))
		{
%>
			data_arr[<%= counter%>][4] = "Active"
<%				}
		else
		{
%>
			data_arr[<%= counter%>][4] = "InActive"
<%				}
     	counter++;
}
%>
formName = "cylindertypeMaster"
	nonEditable = ['<%= CODE%>'];
	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	makeTable(start,end);

	intializeHover('searchresulttable', 'TR', ' tableover');
</script>
