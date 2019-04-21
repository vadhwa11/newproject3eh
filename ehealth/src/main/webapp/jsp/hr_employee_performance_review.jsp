<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * employeeDependent.jsp  
 * Purpose of the JSP -  This is for Dependent Employee.
 * @author  Rajat
 * Create Date: 6th Mar,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.1
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>

<%@page import="jkt.hms.masters.business.HrEmployeePerformanceReview"%>
<%@page import="jkt.hms.masters.business.HrPerformanceReviewRatings"%>

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
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");	

	Map<String,Object> map = null;
	if(request.getAttribute("map")!=null)
	{
		map = (Map)request.getAttribute("map");
	}
	
	
	List<MasEmployee> employeeList =  new ArrayList<MasEmployee>();
	if(map!=null && map.get("employeeList")!=null)
	{
		employeeList = (List)map.get("employeeList");
	}
	
	List<MasEmployee> employeeListForSearch =  new ArrayList<MasEmployee>();
	if(map!=null && map.get("employeeListForSearch")!=null)
	{
		employeeListForSearch = (List)map.get("employeeListForSearch");
	}
	List<HrEmployeePerformanceReview> searchEmpPerformanceReviewList = new ArrayList<HrEmployeePerformanceReview>(); 
	if(map.get("searchEmpPerformanceReviewList") != null){
		searchEmpPerformanceReviewList = (List)map.get("searchEmpPerformanceReviewList");
		session.setAttribute("mapEmpPerformnceReview",map);
	}
	
	List<HrPerformanceReviewRatings> performanceReviewRatingsList = new ArrayList<HrPerformanceReviewRatings>(); 
	if(map.get("performanceReviewRatingsList") != null){
		performanceReviewRatingsList = (List)map.get("performanceReviewRatingsList");
		session.setAttribute("mapEmpPerformnceReview",map);
	}
	String message = ""; 
	if(map.get("message")!=null)
	{
		message = (String)map.get("message");
	}
	
	%>
<h4><span><%=message %></span></h4>
<div class="titleBg">
<h2>Employee Performance Review</h2>
</div>
<div class="clear"></div>
<div class="Block">

<div id="searcharea">

<div id="searchbar">

<form name="search" method="post" action=""><label>Employee
Code</label> <select name="<%=EMPLOYEE_CODE %>" id='searchField'>
	<option value="">Select</option>
	<% for(MasEmployee employee: employeeListForSearch){%>

	<option value="<%=employee.getId() %>"><%=employee.getFirstName()+" " +employee.getLastName()+" - " +employee.getEmployeeCode()%>
	</option>
	<%} %>
</select> <input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','/hms/hms/personnel?method=searchEmployeePerformanceReview')"
	tabindex=1 /> <%--- Report Button   
		             <input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig2" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/>
                    --%> <input type="hidden"
	name="<%=JASPER_FILE_NAME%>" value="Mas_employee"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</div>
<div class="clear"></div>
</div>

<!-- Pasted -->

<div class="clear"></div>
<!-- end of div Block -->

<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


<% 
	if(searchEmpPerformanceReviewList.size()==0 && map.get("search") != null)
	{
	%> <h4><a href="personnel?method=showEmployeePerformanceReviewJsp">Show All Records</a></h4> <%
	}
	%> <script type="text/javascript">
		
		formFields = [
				[0, "<%= COMMON_ID%>", "id"], [1,"<%= EMPLOYEE_ID%>"], [2,"<%=ASSESSMENT_PERFORMANCE_GOALS%>"], [3,"<%=ASSESSMENT_BEHAVIOUR%>"],[4,"<%= OVERALL_ASSESSMENT %>"],[5,"<%= YEAR %>"],[6,"<%= INCREMENT_PERCENTAGE%>"],[7,"<%= INCREMENT_AMOUNT%>"],[8,"<%= PROMOTION%>"], [9,"<%=COMMENTS%>"],[10,"<%=STATUS%>"] ];
	 statusTd = 10;
		</script></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="Block">
<form name="employeePerformanceReview" method="post" action="">
<input	type="hidden" name="title" value="Employee Performance Review" />
<label><span>*</span> Employee Name</label> 
<select name="<%= EMPLOYEE_ID %>" id="<%=EMPLOYEE_ID %>" validate="Employee Name,string,yes" tabindex=1>
<option value="">Select</option>
<%
for (MasEmployee masEmployeecode : employeeList) {
%>
<option value="<%=masEmployeecode.getId ()%>"><%=masEmployeecode.getFirstName() + " " + masEmployeecode.getLastName()+" - "+masEmployeecode.getEmployeeCode()%></option>
<%}%>
</select> 
<label>Assessment on performance goals</label> 
<select	name="<%=ASSESSMENT_PERFORMANCE_GOALS %>" validate="Assessment on performance goals ,string,no" tabindex=1> 
<option value="">Select</option>
<%
for (HrPerformanceReviewRatings rating: performanceReviewRatingsList) {
%>
<option value="<%=rating.getId ()%>"><%=rating.getRatingDesc()%></option>
<%}%>
</select> 
<label>Assessment on behaviour/ development goals</label> 
<select	name="<%=ASSESSMENT_BEHAVIOUR %>" validate="Assessment on behaviour ,string,no" tabindex=1>
<option value="">Select</option>
<%
for (HrPerformanceReviewRatings rating: performanceReviewRatingsList) {
%>
<option value="<%=rating.getId ()%>"><%=rating.getRatingDesc()%></option>
<%}%>
</select>
<div class="clear"></div>
<label><span>*</span> Overall Assessment</label> 
<select	name="<%=OVERALL_ASSESSMENT %>"	validate="Overall Assessment,string,yes" tabindex=1> 
<option value="">Select</option>
<%
for (HrPerformanceReviewRatings rating: performanceReviewRatingsList) {
%>
<option value="<%=rating.getId ()%>"><%=rating.getRatingDesc()%></option>
<%}%>
</select> 
<label>Year</label> 
<select name="<%=YEAR%>" validate="Experience in Years,string,no">
<option value="--">--</option>
<%	for(int i=2005;i<=2050;i++){%>
<option value="<%=i%>"><%=i%></option>
<%}%>
</select> 
<label>Increment Percentage</label> <input type="text"	name=<%=INCREMENT_PERCENTAGE%> validate="Increment Percentage,float,no"	maxlength="6" />
<div class="clear"></div>
<label>Increment Amount</label> 
<input type="text"	name="<%=INCREMENT_AMOUNT %>" validate="Increment Amount,string,no" />
<label>Promotion (if any)</label> 
<input type="text" name="<%=PROMOTION%>" validate="Promotion,string,no" /> 
<label>Comments </label> 
<textarea name="<%=COMMENTS%>" validate="Comments,string,no" onkeyup="refreshLength1(this.id,250)" onkeydown="refreshLength2(this.id,250)"></textarea>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button"	onClick="submitForm('employeePerformanceReview','personnel?method=addOrUpdateEmployeePerformaceReview');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('employeePerformanceReview','personnel?method=addOrUpdateEmployeePerformaceReview');" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="InActivate"	style="display: none;" class="button" onClick="submitForm('employeePerformanceReview','personnel?method=deleteEmployeePerformanceReview','removeMandatory')" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS%>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%="admin"%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%="admin"%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "Employee Code"
	data_header[0][1] = "data";
	data_header[0][2] = "10%";
	data_header[0][3] = "<%= CODE%>"
	
	data_header[1] = new Array;
	data_header[1][0] = "Assessment On Performance Goals"
	data_header[1][1] = "hide";
	data_header[1][2] = "25%";
	data_header[1][3] = "<%= ASSESSMENT_PERFORMANCE_GOALS %>";
	
	data_header[2] = new Array;
	data_header[2][0] = "Assessment Behaviour"
	data_header[2][1] = "hide";
	data_header[2][2] = "15%";
	data_header[2][3] = "<%= ASSESSMENT_BEHAVIOUR %>";
	
	data_header[3] = new Array;
	data_header[3][0] = "Overall Assessment"
	data_header[3][1] = "data";
	data_header[3][2] = "20%";
	data_header[3][3] = "<%= OVERALL_ASSESSMENT %>";
	
	data_header[4] = new Array;
	data_header[4][0] = "Year"
	data_header[4][1] = "data";
	data_header[4][2] = "20%";
	data_header[4][3] = "<%=YEAR%>";
	
	data_header[5] = new Array;
	data_header[5][0] = "Increment Percentage"
	data_header[5][1] = "data";
	data_header[5][2] = "30%";
	data_header[5][3] = "<%= INCREMENT_PERCENTAGE%>";
	
	data_header[6] = new Array;
	data_header[6][0] = "Increment Amount"
	data_header[6][1] = "data";
	data_header[6][2] = "40%";
	data_header[6][3] = "<%=INCREMENT_AMOUNT%>";
	
	data_header[7] = new Array;
	data_header[7][0] = "Promotion"
	data_header[7][1] = "hide";
	data_header[7][2] = "40%";
	data_header[7][3] = "<%=PROMOTION%>";
	
	data_header[8] = new Array;
	data_header[8][0] = "Comments"
	data_header[8][1] = "hide";
	data_header[8][2] = "40%";
	data_header[8][3] = "<%=COMMENTS%>";
	
	data_header[9] = new Array;
	data_header[9][0] = "Status"
	data_header[9][1] = "data";
	data_header[9][2] = "15%";
	data_header[9][3] = "<%=STATUS %>";
	
	data_arr = new Array();
	
	
	
	<%
		Iterator itr=searchEmpPerformanceReviewList.iterator();
	    int  counter=0;
	    while(itr.hasNext())
	    {																																																											
	        HrEmployeePerformanceReview  performanceReview = (HrEmployeePerformanceReview)itr.next(); 
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= performanceReview.getId()%>
			
		   <%if(performanceReview.getEmployee()!=null){
			
			Iterator itrGridEmployeeList= employeeListForSearch.iterator();
			while(itrGridEmployeeList.hasNext())
   				{	
				MasEmployee  employeeGrid = (MasEmployee)itrGridEmployeeList.next(); 
				if(performanceReview.getEmployee().getId().equals(employeeGrid.getId()) && employeeGrid.getStatus().equals("y")){%>
					data_arr[<%= counter%>][1] = "<%=employeeGrid.getFirstName() + " "  +employeeGrid.getLastName() + " - " +employeeGrid.getEmployeeCode()%>";
				<%}else if(performanceReview.getId().equals(employeeGrid.getId()) && employeeGrid.getStatus().equals("n")){%>
					data_arr[<%= counter%>][1] = "<span>* </span>Parent InActivated--<%=employeeGrid.getFirstName()+" "+employeeGrid.getLastName()+" - "+employeeGrid.getEmployeeCode()%>";
			
				<%}
				}
			}else{
			%>
			data_arr[<%= counter%>][1] = "0"
			<%}if(performanceReview.getAssesmentPerformanceGoals()!=null){
			
			 
			Iterator itrGridRatingList= performanceReviewRatingsList.iterator();
			while(itrGridRatingList.hasNext())
   				{	
				HrPerformanceReviewRatings  rating = (HrPerformanceReviewRatings)itrGridRatingList.next(); 
				if(performanceReview.getAssesmentPerformanceGoals().getId().equals(rating.getId()) && rating.getStatus().equals("y")){%>
					data_arr[<%= counter%>][2] = "<%=rating.getRatingDesc()%>";
				<%}else if(performanceReview.getId().equals(rating.getId()) && rating.getStatus().equals("n")){%>
					data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=rating.getRatingDesc()%>";
			
				<%}
				}
			}
			else{%>
				data_arr[<%= counter%>][2] = "";
			<%}if(performanceReview.getAssesmentBehaviour()!=null){
			
			 
			Iterator itrGridRatingList= performanceReviewRatingsList.iterator();
			while(itrGridRatingList.hasNext())
   				{	
				HrPerformanceReviewRatings  rating = (HrPerformanceReviewRatings)itrGridRatingList.next(); 
				if(performanceReview.getAssesmentBehaviour().getId().equals(rating.getId()) && rating.getStatus().equals("y")){%>
					data_arr[<%= counter%>][3] = "<%=rating.getRatingDesc()%>";
				<%}else if(performanceReview.getId().equals(rating.getId()) && rating.getStatus().equals("n")){%>
					data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=rating.getRatingDesc()%>";
			
				<%}
				}
			}
			else{%>
				data_arr[<%= counter%>][3] = "";
			<%}if(performanceReview.getOverallAssesment()!=null){
			
			 
			Iterator itrGridRatingList= performanceReviewRatingsList.iterator();
			while(itrGridRatingList.hasNext())
   				{	
				HrPerformanceReviewRatings  rating = (HrPerformanceReviewRatings)itrGridRatingList.next(); 
				if(performanceReview.getOverallAssesment().getId().equals(rating.getId()) && rating.getStatus().equals("y")){%>
					data_arr[<%= counter%>][4] = "<%=rating.getRatingDesc()%>";
				<%}else if(performanceReview.getId().equals(rating.getId()) && rating.getStatus().equals("n")){%>
					data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=rating.getRatingDesc()%>";
			
				<%}
				}
			}
			else{%>
				data_arr[<%= counter%>][4] = "";
			<%}if(performanceReview.getYear()!=null){%>
				data_arr[<%= counter%>][5] = "<%=performanceReview.getYear().toString()%>";
				<%}else{%>
				data_arr[<%= counter%>][5] = "";
				<%}if(performanceReview.getIncrementPercentage()!=null){%>
				data_arr[<%= counter%>][6] = "<%=performanceReview.getIncrementPercentage()%>";
				<%}else{%>
				data_arr[<%= counter%>][6] = "";
				<%}if(performanceReview.getIncrementAmount()!=null){%>
				data_arr[<%= counter%>][7] = "<%=performanceReview.getIncrementAmount()%>";
				<%}else{%>
				data_arr[<%= counter%>][7] = "";
				<%}if(performanceReview.getPromotion()!=null){%>
				data_arr[<%= counter%>][8] = "<%=performanceReview.getPromotion()%>";
				<%}else{%>
				data_arr[<%= counter%>][8] = "";
				<%}if(performanceReview.getComments()!=null){%>
				data_arr[<%= counter%>][9] = "<%=performanceReview.getComments()%>";
				<%}else{%>
				data_arr[<%= counter%>][9] = "";
				<%}if(performanceReview.getStatus()!=null){
				String status = "InActive";
				if(performanceReview.getStatus().equals("y"))
						{
							status = "Active";
						}
				%>
				data_arr[<%= counter%>][10] = "<%=status%>";
				<%}else{%>
				data_arr[<%= counter%>][10] = "";
				<%}%>
			
			<%
			     counter++;
		}
	%>
	
	
	
	
    formName = "employeePerformanceReview"
	nonEditable = ['<%=EMPLOYEE_ID%>'];
	
	
	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	makeTable(start,end);
	
	intializeHover('searchresulttable', 'TR', ' tableover');	
	
	function removeMandatory()
	{
	document.getElementById('<%=EMPLOYEE_ID%>').setAttribute('validate','Employee Name,string,no');
	return true;
	}	
	</script>
