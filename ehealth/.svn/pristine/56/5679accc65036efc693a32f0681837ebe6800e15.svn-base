<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * questions.jsp  
 * Purpose of the JSP -  This is showing Questions.
 * @author  Dipali
 * @author  Vishal
 * Create Date: 07th April,2009
 * Revision Date:      
 * Revision By:  
 * @version 1.14
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasQuestions"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		
		List<MasQuestions> searchQuestionsList = new ArrayList<MasQuestions>();
		List<MasQuestions> gridQuestionsList = new ArrayList<MasQuestions>();
		String userName = "";
		
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if(map.get("searchQuestionsList") != null){
			searchQuestionsList = (ArrayList)map.get("searchQuestionsList");
		}
	
	if(map.get("gridQuestionsList") != null){
	gridQuestionsList = (ArrayList)map.get("gridQuestionsList");
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
		   <h4><span><%=message %></span></h4>
		 <%}
	int pageNo = 0;
	if(map.get("pageNo") != null){
		pageNo = (Integer)map.get("pageNo");
	}
%>

<div class="titleBg">
<h2>Questions Master</h2>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Question No </label>
<input type="radio"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radioCheckCol1" />
<label>Question </label>
<input type="radio"	name="<%=SELECTED_RADIO %>" value="2" class="radioCheckCol1" /> 

<input type="hidden" name="colCode" value="questionno">
<input type="hidden" name="colName" value="question">
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Questions Code,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'generalMaster?method=searchQuestions')" />
<input type="button" name="search" value="Search" class="button"onclick="submitForm('search','generalMaster?method=searchQuestions','checkSearch')" tabindex=1 /> 
<%--- Report Button   --%> 
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_questions">
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
		if(searchQuestionsList.size() > 0)
		 {
			String strForCode = (String)map.get("questionno");
			String strForCodeDescription = (String)map.get("question");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%><h4> <a href="generalMaster?method=showQuestionsJsp">Show All Records </a></h4> <%
			}
		 }
	 if(searchQuestionsList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="generalMaster?method=showQuestionsJsp">Show All Records</a></h4> <%
     }
	%> <script type="text/javascript">

	formFields = [
	 			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;

	</script></div>

<form name="questions" method="post" action="">
<input type="hidden"	name="<%= POJO_NAME %>" value="MasQuestions"> 
<input type="hidden"	name="<%=POJO_PROPERTY_NAME %>" value="Question"> 
<input	type="hidden" name="<%=POJO_PROPERTY_CODE %>" value="Questionno">
<input type="hidden" name="title" value="Questions"> 
<input	type="hidden" name="<%=JSP_NAME %>" value="questions"> 
<input	type="hidden" name="pojoPropertyCode" value="Questionno">

<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Question No</label> 
<input type="text" name="<%= CODE%>" value="" validate="Questions Code,string,yes" class="textbox_size20" MAXLENGTH="8" tabindex=1 />
<label><span>*</span> Question </label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Questions Name,string,yes" class="textbox_size20" MAXLENGTH="100" tabindex=1 />
<script>
			document.questions.<%=CODE%>.focus();
			</script>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>

<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('questions','generalMaster?method=addQuestions');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('questions','generalMaster?method=editQuestions')" accesskey="u" tabindex=1 /> 

<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('questions','generalMaster?method=deleteQuestions&flag='+this.value)" accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" /> 
<input type="hidden"	name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<!-- Added By Ritu for edit page-->
<input type="hidden" id="pageNoEdit" name="pageNoEdit" value="<%=pageNo%>"/>  
<!--  -->
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label> Changed By: </label> 
<label class="value"><%=userName%></label> 
<label> Changed Date: </label> 
<label class="value"><%=date%></label> 
<label> Changed Time: </label> 
<label class="value"><%=time%></label> 
<input type="hidden"	name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Questions Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Questions Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";



data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%=CHANGED_BY %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_DATE %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CHANGED_TIME %>"

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchQuestionsList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             MasQuestions  masQuestions = (MasQuestions)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masQuestions.getId()%>
data_arr[<%= counter%>][1] = "<%=masQuestions.getQuestionno()%>"
data_arr[<%= counter%>][2] = "<%= masQuestions.getQuestion()%>"


	 data_arr[<%= counter%>][3] = "<%= masQuestions.getLastChgBy()!=null?(masQuestions.getLastChgBy().getId()!=null?masQuestions.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masQuestions.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masQuestions.getLastChgTime() %>"

<% if(masQuestions.getStatus().equalsIgnoreCase("Y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "questions"

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
