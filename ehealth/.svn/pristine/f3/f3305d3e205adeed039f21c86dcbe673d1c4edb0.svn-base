<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hr_exitInterview.jsp  
 * Purpose of the JSP -  This is for  Employee Exit Interview.
 * @author  Rajat
 * Create Date: 1st April,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.1
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@page import="jkt.hms.masters.business.Users"%>
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
	Users user = null; 
	if(map.get("user")!=null)
	{
		user = (Users)map.get("user");
	}
	%>
<h4><span><%=message %></span></h4>
<div class="titleBg">
<h2>Exit Interview</h2>
</div>
<div class="clear"></div>
<!-- Pasted -->
<script type="text/javascript">
		formFields = [
		      			[0, "<%= COMMON_ID%>", "id"], [1,"<%= EMPLOYEE_ID%>"], [2,"<%=ASSESSMENT_PERFORMANCE_GOALS%>"], [3,"<%=ASSESSMENT_BEHAVIOUR%>"],[4,"<%= OVERALL_ASSESSMENT %>"],[5,"<%= YEAR %>"],[6,"<%= INCREMENT_PERCENTAGE%>"],[7,"<%= INCREMENT_AMOUNT%>"],[8,"<%= PROMOTION%>"], [9,"<%=COMMENTS%>"],[10,"<%=STATUS%>"] ];
	 statusTd = 10;
		</script>
<form name="employeeExitInterview" method="post" action="">
<div class="clear"></div>
<div class="Block">
<input type="hidden" name="title" value="Employee Performance Review"></input>
<label>Employee Name</label> 
<label class="value"><%=user.getEmployee().getFirstName()+" "+user.getEmployee().getLastName() %></label>
<label>Department</label> 
<label class="value"><%=user.getEmployee().getDepartment().getDepartmentName() %></label>
<!--<label>Designation</label>
<label class="value"></label> 
	-->
<div class="clear"></div>
<label>Date of Joining</label> 
<label class="value"><%=HMSUtil.getDateFormat(user.getEmployee().getJoinDate(),"dd/MM/yyyy") %></label>
<label>Date of Relieving</label> 
<input name="<%=DATE_OF_RELIEVING%>" type="text" class="date" readonly /> 
<img src="/hms/jsp/images/cal.gif" class="calendar" validate="Pick a date" onClick="setdate('',document.employeeExitInterview.<%=DATE_OF_RELIEVING%>,event)" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<label class="auto">
1. What are your reason(s) for leaving <%=employeeList.get(0).getHospital().getHospitalName() %>
</label>
<div class="clear"></div>
<select class="list" multiple name="<%=QUEST1 %>">
<option value="Better Prospects">Better Prospects</option>
<option value="Financial">Financial</option>
<option value="Career">Career</option>
<option value="Domestic/ Family Problems">Domestic/ Family Problems</option>
<option value="Further Studies">Further Studies</option>
<option value="Health">Health</option>
<option value="Immigration">Immigration</option>
<option value="Marriage">Marriage</option>
<option value="Self employment">Self employment</option>
<option value="Work Load/ Working Hours">Work Load/ Working Hours</option>
<option value="Working Conditions">Working Conditions</option>
<option value="Relationship with supervisor">Relationship with supervisor</option>
<option value="Lack of Career Opportunities">Lack of Career  Opportunities</option>
<option value="Type of work/ responsibilities">Type of work/responsibilities</option>
</select>
<div class="clear"></div>
<div class="paddingTop15"></div>
<label class="auto">2. What circumstances would have prevented your departure?</label>
<div class="clear"></div>
<textarea name="<%=QUEST2 %> class="large" > </textarea>
<div class="clear"></div>
<div class="paddingTop15"></div>
<label class="auto">3. What did you like most about your job?</label>
<div class="clear"></div>
<textarea name="<%=QUEST3%>"></textarea>
<div class="clear"></div>
<div class="paddingTop15"></div>
<label class="auto">4. What did you like least about your job?</label>
<div class="clear"></div>
<textarea name="<%=QUEST4%>"></textarea>
<div class="clear"></div>
<div class="paddingTop15"></div>
<label class="auto">5. How would you rate the following?</label>
<table cellpadding="0" cellspacing="0">
	<tr>
		<td><label class="auto">a) Cooperation within your
		department </label></td>
		<td><select name="<%=QUEST5a%>">
			<option value="Excellent">Excellent</option>
			<option value="Good">Good</option>
			<option value="Fair">Fair</option>
			<option value="Poor">Poor</option>
		</select></td>

		<td><label class="large">b) Cooperation with other
		divisions </label></td>
		<td><select name="<%=QUEST5b%>">
			<option value="Excellent">Excellent</option>
			<option value="Good">Good</option>
			<option value="Fair">Fair</option>
			<option value="Poor">Poor</option>
		</select></td>
	</tr>

	<tr>
		<td><label class="auto">c) Communication within
		organisation </label></td>
		<td><select name="<%=QUEST5c%>">
			<option value="Excellent">Excellent</option>
			<option value="Good">Good</option>
			<option value="Fair">Fair</option>
			<option value="Poor">Poor</option>
		</select></td>
		<td><label class="auto">d) CliniRx new employee
		orientation program </label></td>
		<td><select name="<%=QUEST5d%>">
			<option value="Excellent">Excellent</option>
			<option value="Good">Good</option>
			<option value="Fair">Fair</option>
			<option value="Poor">Poor</option>
		</select></td>
	</tr>

	<tr>
		<td><label class="auto">e) Rate of pay for your job </label></td>
		<td><select name="<%=QUEST5e%>">
			<option value="Excellent">Excellent</option>
			<option value="Good">Good</option>
			<option value="Fair">Fair</option>
			<option value="Poor">Poor</option>
		</select></td>
		<td><label class="auto">f) Career development
		/Advancement </label></td>
		<td><select name="<%=QUEST5f%>">
			<option value="Excellent">Excellent</option>
			<option value="Good">Good</option>
			<option value="Fair">Fair</option>
			<option value="Poor">Poor</option>
		</select></td>
	</tr>

	<tr>
		<td><label class="auto">g) Physical working conditions </label></td>
		<td><select name="<%=QUEST5g%>">
			<option value="Excellent">Excellent</option>
			<option value="Good">Good</option>
			<option value="Fair">Fair</option>
			<option value="Poor">Poor</option>
		</select></td>
		<td><label class="auto">h) Opportunities </label></td>
		<td><select name="<%=QUEST5h%>">
			<option value="Excellent">Excellent</option>
			<option value="Good">Good</option>
			<option value="Fair">Fair</option>
			<option value="Poor">Poor</option>
		</select></td>
	</tr>
</table>
<div class="clear"></div>
<div class="paddingTop15"></div>
<label class="auto">6.Could your qualifications and skills have been used to better advantage ?</label> 
<label class="smallAuto">Yes</label> 
<input	type="radio" name="<%=QUEST6%>" class="radioCheck" /> 
<label class="smallAuto">No</label> 
<input type="radio" name="<%=QUEST6%>" class="radioCheck" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<label class="auto">7.Were you encouraged to find new and better ways of doing things?</label> 
<label class="smallAuto">Yes</label> 
<input	type="radio" name="<%=QUEST7%>" class="radioCheck" /> 
<label class="smallAuto">No</label> 
<input type="radio" name="<%=QUEST7%>" class="radioCheck" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<label class="auto">8.What suggestions do you have to make this organization a better place to work ?</label> 
<label class="smallAuto">Yes</label>
<input type="radio" name="<%=QUEST8%>" class="radioCheck" /> 
<label	class="smallAuto">No</label> 
<input type="radio" name="<%=QUEST8%>"	class="radioCheck" />
<div class="clear"></div>
</div>
<div id="edited"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Submit"class="button"	onClick="submitForm('employeeExitInterview','personnel?method=addOrUpdateexitInterview');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update"	style="display: none;" class="button"	onClick="submitForm('employeePerformanceReview','personnel?method=addOrUpdateEmployeePerformaceReview');"	accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="InActivate"	style="display: none;" class="button" onClick="submitForm('employeePerformanceReview','personnel?method=deleteEmployeePerformanceReview')" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS%>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By</label> 
<label class="value"><%="admin"%></label>
<label>Changed Date</label> 
<label class="value"><%=date%></label> 
<label>Changed Time</label> 
<label class="value"><%=time%></label> 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%="admin"%>" /> 
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
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
			
			Iterator itrGridEmployeeList= employeeList.iterator();
			while(itrGridEmployeeList.hasNext())
   				{	
				MasEmployee  employeeGrid = (MasEmployee)itrGridEmployeeList.next(); 
				if(performanceReview.getEmployee().getId().equals(employeeGrid.getId()) && employeeGrid.getStatus().equals("y")){%>
					data_arr[<%= counter%>][1] = "<%=employeeGrid.getEmployeeCode()+" - " + employeeGrid.getFirstName() + " "  +employeeGrid.getLastName()%>";
				<%}else if(performanceReview.getId().equals(employeeGrid.getId()) && employeeGrid.getStatus().equals("n")){%>
					data_arr[<%= counter%>][1] = "<font id='error'>*</font>Parent InActivated--<%=employeeGrid.getEmployeeCode()%> - <%=employeeGrid.getFirstName()%>";
			
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
				data_arr[<%= counter%>][5] = "<%=performanceReview.getYear()%>";
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
	</script>
