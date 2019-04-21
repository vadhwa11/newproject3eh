<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * currency.jsp  
 * Purpose of the JSP -  This is for Currency Details.
 * @author  Shailesh
 * Create Date: 14th nov,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.8  
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.HmsNoticeBoard"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchNoticeList = (ArrayList)map.get("searchNoticeList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	String message="";
	if(map.get("message") != null){
		    message = (String)map.get("message");
		   
		  }
%>
<h4><span><%=message %></span></h4>
<div class="titleBg">
<h2>Notice Master</h2>
</div>

<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="clear"></div>
<label>Notice Code</label> <input type="radio"
	name="<%=SELECTED_RADIO  %>" value="1" checked="checked"
	class="radiobutMargin" /> <label>Notice Description</label> <input
	type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" />
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""
	validate="Notice Code,string,no" MAXLENGTH="20" tabindex=1
	onkeypress="return submitenter(this,event,'hospital?method=searchNotice')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','hospital?method=searchNotice','checkSearch')"
	tabindex=1 /> <input type="hidden"
	name="<%=JASPER_FILE_NAME%>" value="Mas_notice"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
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
		if(searchNoticeList.size()>0)
		 {
			String strForCode = (String)map.get("noticeCode");
			String strForCodeDescription = (String)map.get("noticeName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h4><a href="hospital?method=showNoticeJsp">Show All Records</a></h4> <%
			}
		 }
	 if(searchNoticeList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="generalMaster?method=showNoticeJsp">Show All Records</a></h4> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
</script></div>


<form name="notice" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden"
	name="<%= POJO_NAME %>" value="HmsNoticeBoard"><input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="Desc"><input
	type="hidden" name="title" value="Notice"><input type="hidden"
	name="<%=JSP_NAME %>" value="notice"><input type="hidden"
	name="pojoPropertyCode" value="NoticeCode">
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block"><label><span>*</span> Notice Code</label> <input
	id="codeId" type="text" name="<%= CODE%>" value=""
	validate="Notice Code,string,yes" MAXLENGTH="30"  tabindex=1 />
	<label><span>*</span> Notice
Name</label> <input type="text" name="<%= SEARCH_NAME %>" value=""
	validate="Notice Name,string,yes" MAXLENGTH="199" tabindex=1 onkeypress="return submitenter(this,event,'hospital?method=addNotice')">
	<script>document.notice.<%=CODE%>.focus();</script>
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('notice','hospital?method=addNotice');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" style="display: none;" class="button"
	onClick="submitForm('notice','hospital?method=editNotice')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" style="display: none;"
	class="button"
	onClick="submitForm('notice','hospital?method=deleteNotice&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" /> <input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>

<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

<div class="clear"></div>
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Notice Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Notice Description"
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
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();

<%


Iterator itr=searchNoticeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  HmsNoticeBoard hmsNoticeBoard = (HmsNoticeBoard)itr.next(); 
             
			

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hmsNoticeBoard.getId()%>
data_arr[<%= counter%>][1] = "<%=hmsNoticeBoard.getNoticeCode()%>"
data_arr[<%= counter%>][2] = "<%= hmsNoticeBoard.getDesc()%>"
<%if(hmsNoticeBoard.getLastChangedBy()!=null){%>
data_arr[<%= counter%>][3] = "<%= hmsNoticeBoard.getLastChangedBy() %>"
<%}else{%>
data_arr[<%= counter%>][3]="";
<%}%>
<%if(hmsNoticeBoard.getLastChangedDate()!=null){%>
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(hmsNoticeBoard.getLastChangedDate()) %>"
<%}else{%>
data_arr[<%= counter%>][4]="";
<%}%>
<%if(hmsNoticeBoard.getLastChangedTime()!=null){%>
data_arr[<%= counter%>][5] = "<%= hmsNoticeBoard.getLastChangedTime() %>"
<%}else{%>
data_arr[<%= counter%>][5]="";
<%}%>
<% if(hmsNoticeBoard.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "notice"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
