<%@page import="jkt.hms.masters.business.MasDiscount"%>
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is for Response of discount details for update.
 * @author  Ritu
 * Create Date: 30th Jun,2009 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hrms.masters.business.HrMasEmployeeEducation"%>
<%@page import="jkt.hrms.masters.business.HrEmployeeExperience"%>
<%@page import="jkt.hrms.masters.business.HrMasQualification"%>
<%@page import="jkt.hrms.masters.business.HrMasCourse"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>

<!-- <script type="text/javascript">
animatedcollapse.addDiv('title1', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title2', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('title3', 'fade=0,speed=400,group=pets,hide=1,persist=0,hide=0')
animatedcollapse.addDiv('title4', 'fade=0,speed=400,group=pets,hide=0')
animatedcollapse.addDiv('title5', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title6', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title7', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title8', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.init()
function changeClass(title,t)
{
animatedcollapse.toggle(title,t);
}
</script> -->

<script>
<%Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>

<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<HrMasEmployeeEducation>  educationList = new ArrayList<HrMasEmployeeEducation>();
	List<HrEmployeeExperience>  expList = new ArrayList<HrEmployeeExperience>();
	List<HrMasQualification> qualificationList = new ArrayList<HrMasQualification>();
	List<HrMasCourse> coursesList = new ArrayList<HrMasCourse>();
	if (map.get("educationList") != null) {
		educationList = (List<HrMasEmployeeEducation> ) map.get("educationList");
	}
	if (map.get("expList") != null) {
		expList = (List<HrEmployeeExperience> ) map.get("expList");
	}
	if (map.get("qualificationList") != null) {
		qualificationList = (List<HrMasQualification> ) map.get("qualificationList");
	}
	if (map.get("coursesList") != null) {
		coursesList = (List<HrMasCourse> ) map.get("coursesList");
	}
System.out.println(educationList.size()+"employee"+qualificationList.size());

%>

<div id="testDiv">

<a href="javascript:changeClass('title6','t6')"><h5 id='t6'>Employee Education Details</h5></a>
			<div class="clear"></div>	
			<div class="Block" id="title6"> 
		
			<div class="clear"></div>	
			<input type="button"	class="button" value="Add Row" onclick="addRow();" align="right" /> 
			<input	type="button" class="button" value="Delete Row" onclick="removeRow('grid')"	align="right" />
			<div class="clear"></div>


 <table width="100%" border="0" cellspacing="0" id="grid" cellpadding="0">
			<tr>
		<th scope="col">Sr. No.</th>
		<th scope="col">Qualification</th>		
		<th scope="col">Course Name</th>		
		<th scope="col">Year of Passing</th>
		<th scope="col">Course Duration</th>
		<th scope="col">Qualified Date</th>
		<th scope="col">Skills</th>
		<th scope="col">Awards</th>
						

	</tr>
	<%
	  String klass = "even";
	  int  counter1=0;
				String id1 = "";
	 		id1 = "id" + counter1;
	 		counter1++;

	 		if(counter1%2==0){
	 			klass = "even";
	 		}
	 		else
	 		{
	 			klass= "odd";
	 		}

String url="";
  %>

<%int i1=0; 
if(educationList.size()>0){
for(HrMasEmployeeEducation hmee : educationList){
	i1++;
%>

		<tr>
		<td>
			<input type="text" id="srno" name="srno" value="<%=i1 %>" tabindex="1" size="2"/>
			<input type="hidden" id="id" name="id<%=i1 %>" value="<%=hmee.getId() %>" />
		</td>
		<td><select id="qualification" name="<%=QUALIFICATION%><%=i1%>"	 validate="Qualification,string,no" tabindex=1>
			<%
			int count=0;
			for (HrMasQualification qualification : qualificationList) {
				
				if(hmee.getQualification() != null){
				if(hmee.getQualification().getId() == qualification.getId() ){
			count++;
			%>
			<option value="<%=qualification.getId ()%>"><%=qualification.getQualificationName()%></option>
			<%}}}if(count==0){%>
			<option value="0">Select</option>
			<%for (HrMasQualification qualification : qualificationList) {%>
			<option value="<%=qualification.getId ()%>"><%=qualification.getQualificationName()%></option>
			
			<%} }%>
			</select> </td>
		<td>
			<select id="coursesName" name="<%=COURSES_NAME%><%=i1%>"	validate="Courses Name,string,no" tabindex="1">
			<%
			int count1=0;
				for (HrMasCourse course : coursesList) {
				if(hmee.getCourse() != null ){
				if(hmee.getCourse().getId() == course.getId() ){count1++;
			%>
			<option value="<%=course.getId ()%>"><%=course.getCourseName()%></option>
			<%}}}if(count1==0){%>
			<option value="0">Select</option>
			<%for (HrMasCourse course : coursesList) {%>
			<option value="<%=course.getId ()%>"><%=course.getCourseName()%></option>
			<%}}%>
			</select> 
		</td>
			
			<td>
				<input type="text" id="yearPassing<%=i1%>" name="yearPassing<%=i1%>" value="<%=hmee.getPassingYear() != null ? hmee.getPassingYear():"" %>" size="6" MAXLENGTH="5" class="medium3" validate="Year of Passing,String,no" />
			</td>
			
			<td>
				<input type="text" id="courseDuration" name="courseDuration<%=i1%>" value="<%=hmee.getCourseDuration() != null ? hmee.getCourseDuration():"" %>" size="5" class="medium3" onClick="unCheck(this)"  />
				<select id="courseDurationnew" name="courseDurationnew<%=i1%>" class="medium3"	 validate="Qualification,string,no" tabindex=1>
			
			
			<option value="<%=hmee.getCourseDurationUnit() != null ? hmee.getCourseDurationUnit() :"0"%>"><%=(hmee.getCourseDurationUnit() != null && !hmee.getCourseDurationUnit().equals("0")  )? hmee.getCourseDurationUnit() :"select"%></option>
			<option value="Year"><%="Year"%></option>
			<option value="Month"><%="Month"%></option>
			<option value="Days"><%="Days"%></option>
			
			</select>
			</td>
			
			<td>
				
			<input type="text"  id="qualified_date"  name="<%=QUALIFIED_DATE%><%=i1%>" validate="Qualified Date,date,no"  value="<%=hmee.getQualifiedDate() != null ? HMSUtil.getDateFormat(hmee.getQualifiedDate(),"dd/MM/yyyy"):"" %>" class="date" MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'td');" tabindex=1 onkeypress="return submitenter(this,event,'personnel?method=addEmployeeDependent')" /> 
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%= QUALIFIED_DATE%><%=i1%>',document.employee.<%=QUALIFIED_DATE%><%=i1%>,true);" />
			</td>
			
			
			<td>
				<input type="text" name="<%=EDUCATION_SKILLS%><%=i1%>" value="<%=hmee.getSkillDetails() %>" size="12" validate=" Skills,string,no" />
			</td>
			<td>
				<input type="text"  name="<%=AWARDS%><%=i1%>" size="14" value="<%=hmee.getAwards() %>" validate="Awards,string,no" />
			</td>
		

	</tr>
	
<%}}else{
%>

<tr>
		<td>
			<input type="text" id="srno" name="srno" value="<%=i1 %>" tabindex="1" size="2"/>
			<input type="hidden" id="id" name="id<%=i1 %>" value="22" />
		</td>
		<td><select id="qualification" name="<%=QUALIFICATION%><%=i1%>"	 validate="Qualification,string,no" tabindex=1>
			<option value="0">Select</option>
			<%for (HrMasQualification qualification : qualificationList) {%>
			<option value="<%=qualification.getId ()%>"><%=qualification.getQualificationName()%></option>
			<%}%>
			</select> </td>
		<td>
			<select id="coursesName" name="<%=COURSES_NAME%><%=i1%>"	validate="Courses Name,string,no" tabindex="1">
			<option value="0">Select</option>
			<%for (HrMasCourse course : coursesList) {%>
			<option value="<%=course.getId ()%>"><%=course.getCourseName()%></option>
			<%}%>
			</select> 
		</td>
			
			<td>
				<input type="text" id="yearPassing<%=i1%>" name="yearPassing<%=i1%>" value="" size="6" MAXLENGTH="5" class="medium3" validate="Year of Passing,String,no" />
			</td>
			
			<td>
				<input type="text" id="courseDuration" name="courseDuration<%=i1%>" size="5" class="medium3" onClick="unCheck(this)"  />
				<select id="courseDurationnew" name="<%="courseDurationnew"%><%=i1%>" class="medium3"	 validate="Qualification,string,no" tabindex=1>
			<option value="0">Select</option>
			
			<option value="year"><%="Year"%></option>
			<option value="month"><%="Month"%></option>
			<option value="days"><%="Days"%></option>
			
			</select>
			</td>
			
			<td>
				
			<input type="text"  id="qualified_date"  name="<%=QUALIFIED_DATE%><%=i1%>" validate="Qualified Date,date,no"   class="date" MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'td');" tabindex=1 onkeypress="return submitenter(this,event,'personnel?method=addEmployeeDependent')" /> 
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%= QUALIFIED_DATE%><%=i1%>',document.employee.<%= QUALIFIED_DATE+"1" %>,true);" />
			</td>
			
			
			<td>
				<input type="text" name="<%=EDUCATION_SKILLS%><%=i1%>" size="12" validate=" Skills,string,no" />
			</td>
			<td>
				<input type="text"  name="<%=AWARDS%><%=i1%>" size="14" validate="Awards,string,no" />
			</td>
		

	</tr>

<%} %>
</table>
		
<input type="hidden" id="hdbedu" value="<%=educationList.size() %>" name="hdbedu" /> </div>




<div class="clear"></div>
			<div class="division"></div>
			<a href="javascript:changeClass('title7','t7')"><h5 id='t7'>Employee Experience</h5></a>
			<div class="clear"></div>
			<div class="Block" id="title7"> 		
			<div class="clear"></div>
			
			<div class="clear"></div>	
			<input type="button"	class="button" value="Add Row" onclick="addRow1();" align="right" /> 
			<input	type="button" class="button" value="Delete Row" onclick="removeRow('grid1')"	align="right" />
			<div class="clear"></div>
		
			
			<table width="100%" border="0" cellspacing="0" id="grid1" cellpadding="0">
					<tr>
		<th scope="col">Sr. No.</th>
		<th scope="col">Previous Employer</th>		
		<th scope="col">Service Start Date</th>		
		<th scope="col">Service End Date</th>
		<th scope="col">Experience</th>
		<th scope="col">Designation</th>
		<th scope="col">Awards</th>
			<th scope="col">Reseon For Job Change</th>
	</tr>
	
	<%
	  String klass1 = "even";
	  int  counter2=0;
				String id2 = "";
	 		id2 = "id" + counter2;
	 		counter1++;

	 		if(counter2%2==0){
	 			klass1 = "even";
	 		}
	 		else
	 		{
	 			klass1= "odd";
	 		}


  %>

<%int j1=0; 
if(expList.size()>0){
for(HrEmployeeExperience hee : expList){
	
j1++;
%>
			<tr>
		<td>
			<input type="text" id="srno" name="srno" value="<%=j1 %>" tabindex="1" size="2"/>
			<input type="hidden" id="id" name="id<%=j1 %>" value="22" />
		</td>
		<td><input type="text" name="<%=PREVIOUS_EMPLOYER%><%=j1 %>" value="<%=hee.getPreviousEmployer() != null ? hee.getPreviousEmployer() :""%>"  size="16" validate="Previous Employer 1,String,no"  MAXLENGTH="30" /> </td>
		<td>
			<input type="text" id="expserviceStartDate2"  name="<%=SERVICE_START_DATE%><%=j1 %>"  value="<%=hee.getServiceStartDate() != null ? HMSUtil.getDateFormat(hee.getServiceStartDate(),"dd/MM/yyyy"):"" %>" class="date" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Service Start Date,date,no"  size="10" />
			 <img src="/hms/jsp/images/cal.gif" width="16" onclick="javascript:setdate('',document.employee.<%=SERVICE_START_DATE%><%=j1 %>,event)" height="16" border="0" validate="Pick a date"  class="calender"/>
		</td>
			
			<td>
				<input type="text" id="SERVICE_END_DATE<%=j1 %>"  name="<%=SERVICE_END_DATE%><%=j1 %>" value="<%=hee.getServiceEndDate() != null ? HMSUtil.getDateFormat(hee.getServiceEndDate(),"dd/MM/yyyy"):"" %>"  class="date"  onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Service End Date ,date,no"   size="10" />
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onClick="javascript:setdate('',document.employee.<%=SERVICE_END_DATE%><%=j1 %>,event)" validate="Pick a date" class="calender" /> 
			</td>
			
			<td>
				<input type="text" id="<%=YEARS%><%=j1 %>" name="<%=YEARS%><%=j1 %>"  value="<%=hee.getExpYrs() != null ? hee.getExpYrs() :""%>" size="10"  class="medium3" onClick="unCheck(this)"  />
				
			</td>
			
			<td>
				
			<input type="text" id="designation" name="<%=DESIGNATION%><%=j1%>" value="<%=hee.getDesignation() != null ?hee.getDesignation() :"" %>" size="14" validate="Designation 1,String,no"  MAXLENGTH="30" />	
			</td>
			
			
			<td>
				<input type="text" name="<%=EX_AWARDS%><%=j1%>"   value="<%=hee.getAwards() != null ? hee.getAwards() :""%>" validate="Awards 1,String,no"  size="14" MAXLENGTH="200" />
			</td>
			<td>
				<input type="text" id="previousEmployer" name="<%=PREVIOUS_SERVICE_END_REASON%><%=j1 %>"   value="<%=hee.getPreviousServiceEndReason() != null ? hee.getPreviousServiceEndReason() :""%>" size="14" validate="Previous Service End Reason1 ,String,no"  MAXLENGTH="30" />
			</td>

	</tr>
	
<%}}else{
%>

<tr>
		<td>
			<input type="text" id="srno" name="srno" value="<%=j1 %>" tabindex="1" size="2"/>
			<input type="hidden" id="id" name="id<%=j1 %>" value="22" />
		</td>
		<td><input type="text" name="<%=PREVIOUS_EMPLOYER%><%=j1 %>" value=""  size="16" validate="Previous Employer 1,String,no"  MAXLENGTH="30" /> </td>
		<td>
			<input type="text" id="expserviceStartDate2"  name="<%=SERVICE_START_DATE%><%=j1 %>"   class="date" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Service Start Date,date,no"  size="10" />
			 <img src="/hms/jsp/images/cal.gif" width="16" onclick="javascript:setdate('',document.employee.<%=SERVICE_START_DATE%><%=j1 %>,event)" height="16" border="0" validate="Pick a date"  class="calender"/>
		</td>
			
			<td>
				<input type="text" id="SERVICE_END_DATE<%=j1 %>"  name="<%=SERVICE_END_DATE%><%=j1 %>" class="date"  onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Service End Date ,date,no"   size="10" />
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onClick="javascript:setdate('',document.employee.<%=SERVICE_END_DATE%><%=j1 %>,event)" validate="Pick a date" class="calender" /> 
			</td>
			
			<td>
				<input type="text" id="<%=YEARS%><%=j1 %>" name="<%=YEARS%><%=j1 %>" size="8" class="medium3" onClick="unCheck(this)"  />
				
			</td>
			
			<td>
				
			<input type="text" id="designation" name="<%=DESIGNATION%><%=j1%>" value="" size="14" validate="Designation 1,String,no"  MAXLENGTH="30" />	
			</td>
			
			
			<td>
				<input type="text" name="<%=EX_AWARDS%><%=j1%>" value=""  validate="Awards 1,String,no"  size="14" MAXLENGTH="200" />
			</td>
			<td>
				<input type="text" id="previousEmployer" name="<%=PREVIOUS_SERVICE_END_REASON%><%=j1 %>" value=""  size="14" validate="Previous Service End Reason1 ,String,no"  MAXLENGTH="30" />
			</td>

	</tr>

<%} %>
</table> 
		
<input type="hidden" id="hdbexp" value="<%=j1 %>" name="hdbexp" /></div>


	</div>
	</div>
	
	