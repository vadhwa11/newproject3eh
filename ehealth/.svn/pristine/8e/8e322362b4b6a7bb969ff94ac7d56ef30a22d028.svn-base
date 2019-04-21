<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * unit.jsp  
 * Purpose of the JSP -  This is for Grade.
 * @author  Mansi
 * Create Date: 17th April,2015
 * Revision Date:      
 * Revision By:  
 * @version 1.9;
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasGrade"%>

<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>

<%
Map map = new HashMap();
if(request.getAttribute("map") != null)
{
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");

ArrayList searchGradeList = (ArrayList)map.get("searchGradeList");

String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}
if(map.get("message") != null){
	   String message = (String)map.get("message");
	   out.println(message);
	  }

%>
<script type="text/javascript">
function check(){
var SDate = document.grade.<%= START_DATE%>.value;
var EDate = document.grade.<%= END_DATE %>.value;

if (SDate == '' || EDate == '') {
alert("Plesae enter both....");
return false;
}
var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))
if(startDate > endDate)
{
alert("Please ensure that the End Date is greater than or equal to the Start Date.");
document.calldate.next_day.focus();
return false;
}
}
</script>
<div class="titleBg">
<h2>Grade Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action="">

<label>Grade Code</label>

<input type="text" id="searchField" name="searchField"	value="" validate="Grade Code,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'personnel?method=searchUnit')" />

<input type="hidden" name="colCode" value="grade_code">
<input type="hidden" name="<%=SELECTED_RADIO%>"  id="radio1"  value="1"  checked="checked" />
<div class="clear"></div>			
<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','generalMaster?method=searchGrade','checkSearch')"	tabindex=1 />

 <%--- Report Button   --%>
<input type="button"	name="Report" value="Generate Report" class="buttonBig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 

<input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_Grade">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>


</div>
</div>

<div class="clear"></div>
<div class="clear"></div>
</div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>

<% 
		if(searchGradeList.size()>0)
		 {
			String strForAddressDescription = (String)map.get("gradeCode");
			if(strForAddressDescription!= null && strForAddressDescription!= "")
			{
	%>
	<a href="generalMaster?method=showGradeJsp">Show All Records</a> 
	<%
			}
		 }
	 if(searchGradeList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="generalMaster?method=showGradeJsp">Show All Records</a> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"payScaleCode"], [3,"<%=SEARCH_NAME%>"],  [4,"<%=START_DATE%>"],  [5,"<%=END_DATE%>"],  [6,"remarks"], [7,"<%= CHANGED_BY%>"], [8,"<%= CHANGED_DATE %>"],[9,"<%= CHANGED_TIME %>"],[10,"<%=STATUS%>"] ];
	 statusTd = 10;
	</script></div>

<form name="grade" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input	type="hidden" name="<%= POJO_NAME %>" value="MasGrade">
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="GradeLevel">
<input	type="hidden" name="title" value="Grade">
<input	type="hidden" name="<%=JSP_NAME %>" value="grade">
<input	type="hidden" name="pojoPropertyCode" value="GradeCode">


<div class="paddingTop15"></div>
<div class="clear"></div>

<div class="Block">

<label><span>*</span>Grade Code</label>

<input	type="text" name="<%= CODE %>" value=""	validate="Grade Code,string,yes" class="textbox_size20" MAXLENGTH="30"	 tabindex=1> 
<script>
		document.grade.<%=CODE%>.focus();
</script>

<label><span>*</span>Pay Scale Code </label> 
<input type="text"	name="payScaleCode" value="" validate="Pay Scale Code,string,yes"	class="textbox_size20" MAXLENGTH="50"  tabindex=1> 

<label><span>*</span>Grade Level</label> 
<input type="text"	name="<%=SEARCH_NAME %>" value="" validate="Grade Level,string,yes"	class="textbox_size20" MAXLENGTH="50"  tabindex=1> 

<div class="clear"></div>
<label><span>*</span> Start Date</label> 
<input	type="text" id="startDateId" name="<%=START_DATE%>" value=""	class="date" readonly="readonly" validate="Start Date,date,yes"	MAXLENGTH="30"  />
<img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date"	onclick="javascript:setdate('',document.grade.<%=START_DATE%>,event)" />

<label><span>*</span> End Date</label>
<input type="text" id="endDateId"	name="<%=END_DATE%>" value=""   class="date" readonly="readonly"	validate="End Date,date,yes" MAXLENGTH="30"	 />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="javascript:setdate('',document.grade.<%=END_DATE%>,event)" />
<label>Remarks </label> 
<!-- <input type="textarea"	name="remarks" value="" 	class="textbox_size20" MAXLENGTH="50"  tabindex=1>  -->
 <textarea name="remarks" validate="Remarks,string,no" MAXLENGTH="100"  cols="10" rows="10" class="textareaMediua"></textarea>

<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button" onClick="submitForm('grade','generalMaster?method=addGrade','check();');"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit"	id="editbutton" value="Update" class="button" style="display: none;"	onClick="submitForm('grade','generalMaster?method=editGrade','check();')" accesskey="u"	tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" style="display: none;"	class="button"	onClick="submitForm('grade','generalMaster?method=deleteGrade&flag='+this.value)"	accesskey="d" tabindex=1 />
<input type="reset" name="Reset"	id="reset" value="Reset" class="buttonHighlight"	onClick="submitFormForButton('grade','generalMaster?method=showGradeJsp')" accesskey="r" /> 
<input type="hidden"	name="<%=STATUS %>" value="" /> <input type="hidden"	name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>
<div class="division"></div>
<div class="clear"></div>

<div class="bottom">
<label>Changed By</label> 
<label	class="value"><%=userName%></label>
 
<label>Changed Date</label> 
<label	class="value"><%=date%></label> 

<label>Changed Time</label> 
<label	class="value"><%=time%></label> 
<input type="hidden"	name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Grade Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Pay Scale Code"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "payScaleCode";

data_header[2] = new Array;
data_header[2][0] = "Grade Level"
data_header[2][1] = "data";
data_header[2][2] = 0;
data_header[2][3] = "<%=SEARCH_NAME%>"


	data_header[3] = new Array;
	data_header[3][0] = "Start Date"
	data_header[3][1] = "hide";
	data_header[3][2] = 0;
	data_header[3][3] = "<%= START_DATE %>"
	

		data_header[4] = new Array;
		data_header[4][0] = "End Date"
		data_header[4][1] = "hide";
		data_header[4][2] = 0;
		data_header[4][3] = "<%= END_DATE %>"
		
		

			data_header[5] = new Array;
			data_header[5][0] = "Remarks"
			data_header[5][1] = "hide";
			data_header[5][2] = 0;
			data_header[5][3] = "remarks"
data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%= CHANGED_BY %>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "0";
data_header[7][3] = "<%= CHANGED_DATE %>";

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%=CHANGED_TIME %>";

data_header[9] = new Array;
data_header[9][0] = "Status"
data_header[9][1] = "data";
data_header[9][2] = "15%";
data_header[9][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchGradeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasGrade  masGrade = (MasGrade)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masGrade.getId()%>
data_arr[<%= counter%>][1] = "<%=masGrade.getGradeCode()!=null?masGrade.getGradeCode():" "%>"
data_arr[<%= counter%>][2] = "<%=masGrade.getPayScaleCode()!=null?masGrade.getPayScaleCode():" " %>"
data_arr[<%= counter%>][3] = "<%=masGrade.getGradeLevel()!=null?masGrade.getGradeLevel():" "%>"
	data_arr[<%= counter%>][4] = "<%= masGrade.getStartDate()!=null? HMSUtil.convertDateToStringWithoutTime(masGrade.getStartDate()) :" "%>"
		data_arr[<%= counter%>][5] = "<%= masGrade.getEndDate()!=null? HMSUtil.convertDateToStringWithoutTime(masGrade.getEndDate()) :" "%>"
			data_arr[<%= counter%>][6] = "<%=masGrade.getRemarks()!=null?masGrade.getRemarks():" "%>"
data_arr[<%= counter%>][7] = "<%= masGrade.getLastChgBy()!=null?(masGrade.getLastChgBy().getId()!=null?masGrade.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][8] = "<%= HMSUtil.convertDateToStringWithoutTime(masGrade.getLastChgDate()) %>"
data_arr[<%= counter%>][9] = "<%= masGrade.getLastChgTime() %>"
<% if(masGrade.getStatus().equalsIgnoreCase("Y")){ %>
data_arr[<%= counter%>][10] = "Active"
<%}else{%>
data_arr[<%= counter%>][10] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "grade"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
