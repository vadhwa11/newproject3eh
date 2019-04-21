<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * majorHead.jsp
 * Purpose of the JSP -  This is for Budget Major Head.
 * @author  Ujjwal
 * Create Date: 31st Jan,2011
 * Revision Date:
 * Revision By:
 * @version 1.15
--%>
<%@page  import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@page  import="static jkt.hms.util.RequestConstants.*"%>
<%@page  import="java.util.*"%>
<%@page  import="jkt.hms.util.HMSUtil"%>
<%@page  import="jkt.hms.masters.business.BudMinorSubHead"%>
<%@page  import="jkt.hms.masters.business.BudSubMajorHead"%>
<%@page import="jkt.hms.masters.business.BudMinorHead"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<BudMinorSubHead> searchMinorSubHeadList = new ArrayList<BudMinorSubHead>();
	List<BudSubMajorHead> submajorHeadList = new ArrayList<BudSubMajorHead>();
	List<BudSubMajorHead> gridsubMajorHeadList = new ArrayList<BudSubMajorHead>();
	List<BudMinorHead> searchMinorHeadList = new ArrayList<BudMinorHead>();
	
	
	searchMinorSubHeadList = (List<BudMinorSubHead>)map.get("searchMinorSubHeadList");
	gridsubMajorHeadList= (List<BudSubMajorHead>)map.get("gridsubMajorHeadList");
	submajorHeadList = (List<BudSubMajorHead>)map.get("submajorHeadList");
	searchMinorHeadList=(List<BudMinorHead>)map.get("searchMinorHeadList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>


<h4><span><%=message %></span></h4>
<%} %>
<div class="clear" ></div>
<div class="titleBg">
<h2>Budget Minor Sub Head Master </h2>
</div>
<div class="clear"></div>
<div class="Block">
<div class="searcharea">
<div class="searchar">
<form name="search" method="post" action="" >
<label>Minor Sub Head Code</label>
<input type="radio"	name="<%=SELECTED_RADIO%>" value="1" checked="checked" class="radioCheck" tabindex=1 />
<label>Minor Sub Head Name</label>
<input	type="radio" name="<%=SELECTED_RADIO %>" value="2" checked="checked" class="radioCheck" />
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Sub-Major Head Code,string,no" MAXLENGTH="30" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=searchCountry')" />
<div class="clear"></div>
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','budget?method=searchMinorSubHead','checkSearch')" tabindex=1 />
<%--- Report Button   --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="bud_minor_sub_head">
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
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<%
		if(searchMinorSubHeadList != null)
		{
			if(searchMinorSubHeadList.size()>0)
		 	{
				String strForCode = (String)map.get("MinorSubHeadCode");
				String strForCodeDescription = (String)map.get("MinorSubHeadName");

				if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
				{
%>
				 	<a href="account?method=showMinorSubHead">Show All Records</a> <%
				}
		 	}

	 		if(searchMinorSubHeadList.size()==0 && map.get("SEARCH_NAME") != null)
	  		{
%>
			 	<a href="account?method=showMinorSubHead">Show All Records</a>
<%
     		}
		}
%>


<script type="text/javascript">
formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%=SEARCH_NAME%>"], [3,"<%=MINOR_HEAD_ID%>"],[4,"<%=SEQUENCE_NO%>"], [5,"<%=STATUS%>"] ];
	 statusTd = 5;
	</script></div>
<form name="cylindertypeMaster" method="post" action="">

<input type="hidden" name="<%= POJO_NAME %>" value="BudSubMajorHead">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="SubMajorHeadName">
<input	type="hidden" name="title" value="Country">
<input type="hidden" name="pojoPropertyCode" value="SubMajorHeadCode">
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Minor Sub Head Code</label>
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Minor Sub Head Code,string,yes" class="textbox_size20" MAXLENGTH="8" / tabindex=1>
<label><span>*</span> Minor Sub Head  Name</label>
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Minor Sub HeadName,string,yes" class="textbox_size20"	MAXLENGTH="50" / tabindex=1>
<div class="clear"></div>
<label><span>*</span> Minor Head Name</label>
<select	name="<%= MINOR_HEAD_ID %>" validate="MinorHead,string,yes" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=addCountry')">
<option value="0">Select</option>
<%
for (BudMinorHead submajorHead: searchMinorHeadList){
%>
<option value="<%=submajorHead.getId() %>">
<%=submajorHead.getMinorHeadName()%></option>
<%}%>
</select>

<!--<label>Sequence No</label>
<input type="text" id="fname11"  name="<%= SEQUENCE_NO %>" value=""  class="textbox_size20" onblur="getSequenceNo(this.value);"  MAXLENGTH="8" onblur="getSequenceNo(this.value);"  tabindex=1>
<div class="clear"></div>-->
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('cylindertypeMaster','budget?method=addMinorSubHead');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('cylindertypeMaster','budget?method=editMinorSubHead')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none" onClick="submitForm('cylindertypeMaster','budget?method=deleteMinorSubHead&flag='+this.value)" accesskey="d" tabindex=1 />
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
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
 
</form>
<div class="clear">
</div>
<div class="paddingTop40">
</div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Minor Sub Head Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Minor Sub Head Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%=SEARCH_NAME%>";

data_header[2] = new Array;
data_header[2][0] = "Sub Major Head Name"
data_header[2][1] = "hide";
data_header[2][2] = "40%";
data_header[2][3] = "<%=MINOR_HEAD_ID%>";

data_header[3] = new Array;
data_header[3][0] = "Sub Major Head Name"
data_header[3][1] = "hide";
data_header[3][2] = "40%";
data_header[3][3] = "<%=SEQUENCE_NO%>";

data_header[4] = new Array;
data_header[4][0] = "Status"
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "<%=STATUS %>";

data_arr = new Array();
<%

Iterator itr=searchMinorSubHeadList.iterator();
int  counter=0;
while(itr.hasNext())
{
	BudMinorSubHead subminorHead = (BudMinorSubHead)itr.next();
	
%>
		data_arr[<%= counter%>] = new Array();
		data_arr[<%= counter%>][0] = <%= subminorHead.getId()%>
		data_arr[<%= counter%>][1] = "<%= subminorHead.getMinorSubHeadCode()%>"
		data_arr[<%= counter%>][2] = "<%= subminorHead.getMinorSubHeadName()%>"
			<%
			Iterator itrGridMajorHeadList=searchMinorHeadList.iterator();
 			while(itrGridMajorHeadList.hasNext())
    		{
 				try
 				{
 					BudMinorHead  submajorheadGrid = (BudMinorHead)itrGridMajorHeadList.next();
 					
 					if(subminorHead.getMinorHeadId().getId().equals(submajorheadGrid.getId()) && submajorheadGrid.getStatus().equals("y"))
	 				{
%>
					data_arr[<%= counter%>][3] = "<%=submajorheadGrid.getMinorHeadName().trim()%>"
<%
					}
	 				else if(subminorHead.getId().equals(submajorheadGrid.getId()) && submajorheadGrid.getStatus().equals("n"))
	 				{
%>
						data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=submajorheadGrid.getMinorHeadName().trim()%>"

<%
					}
    			}
 				catch(Exception e)
 				{
 					e.printStackTrace();
 				}
 			}
%>
data_arr[<%= counter%>][4] = "<%= subminorHead.getSequenceNo()%>"

<%
		if(subminorHead.getStatus().equals("y"))
		{
%>
			data_arr[<%= counter%>][5] = "Active"
<%				}
		else
		{
%>
			data_arr[<%= counter%>][5] = "InActive"
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
<script language="javascript">
function getSequenceNo(val)
{
	<%for(BudMinorSubHead budget:searchMinorSubHeadList){%>

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
<script language="javascript">
function getSequenceNo(val)
{
	<%for(BudMinorSubHead budget:searchMinorSubHeadList){%>

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
