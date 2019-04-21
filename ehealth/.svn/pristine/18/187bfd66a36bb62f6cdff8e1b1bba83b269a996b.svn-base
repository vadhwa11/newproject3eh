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
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasCadre"%>
<%@page import="jkt.hms.masters.business.HrInstitutionalSanctionedPost"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasSpecialOfficial"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>
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
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
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
List<MasCadre> cadreList = new ArrayList<MasCadre>();
List<MasRank> designationList = new ArrayList<MasRank>();
List<HrInstitutionalSanctionedPost> institutionalSanctionedPostList = new ArrayList<HrInstitutionalSanctionedPost>();
List<MasHospital> insList = new ArrayList<MasHospital>();
List<MasEmployeeDepartment> deptList = new ArrayList<MasEmployeeDepartment>();
List<MasSpecialOfficial> masSpecialOfficialList = new ArrayList<MasSpecialOfficial>();
List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
List<MasDistrict> masdistrictList = new ArrayList<MasDistrict>();

if(map.get("insList") != null){
	insList=(List<MasHospital> ) map.get("insList");	
}
if(map.get("deptList") != null){
	deptList=(List<MasEmployeeDepartment> ) map.get("deptList");	
}
if(map.get("CadreList") != null){
	cadreList=(List<MasCadre>) map.get("CadreList");	
}
if(map.get("designationList") != null){
	designationList=(List<MasRank>) map.get("designationList");	
}
if(map.get("institutionalSanctionedPostList") != null){
	institutionalSanctionedPostList=(List<HrInstitutionalSanctionedPost> ) map.get("institutionalSanctionedPostList");
}
if(map.get("masSpecialOfficialList") != null){
	masSpecialOfficialList=(List<MasSpecialOfficial> ) map.get("masSpecialOfficialList");	
}
if(map.get("mhospitalTypetList") != null){
	mhospitalTypetList=(List<MasHospitalType> ) map.get("mhospitalTypetList");
}
if(map.get("masdistrictList") != null){
	masdistrictList=(List<MasDistrict> ) map.get("masdistrictList");
}
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

/* if (SDate == '' || EDate == '') {
alert("Plesae enter both Date....");
return false;
} */
var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))
if(startDate > endDate)
{
alert("Please ensure that the To Date is greater than or equal to the From Date.");
document.calldate.next_day.focus();
return false;
}
}
</script>
<div class="titleBg">
<h2>Sanction Post Institute Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action="">
<label>Reference Order </label>
<input type="text" id="searchField" name="<%= CODE%>"	value="" validate="Reference Order,string,no" MAXLENGTH="12" tabindex=1	onkeypress="return submitenter(this,event,'personnel?method=searchUnit')" />

<div class="clear"></div>
<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','generalMaster?method=searchSanctionInstitutePost','checkSearch')"	tabindex=1 />
 <%--- Report Button   --%>
<!-- <input type="button"	name="Report" value="Generate Report Based on Search" class="button"	onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');"	accesskey="g" tabindex=1 />  -->
 <input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_Grade">  
 

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
		if(institutionalSanctionedPostList.size()>0)
		 {
			String strForAddressDescription = (String)map.get("gradeCode");
			if(strForAddressDescription!= null && strForAddressDescription!= "")
			{
	%>
	<a href="generalMaster?method=showSanctionPostInstituteJsp">Show All Records</a> 
	<%
			}
		 }
	 if(institutionalSanctionedPostList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="generalMaster?method=showSanctionPostInstituteJsp">Show All Records</a> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"cadre"], [3,"sploffName"], [4,"institute"],[5,"dept"],  [6,"<%=START_DATE%>"],  [7,"<%=END_DATE%>"], [8,"<%= CHANGED_BY%>"],[9,"<%= CHANGED_DATE %>"],[10,"<%= CHANGED_TIME %>"],[11,"<%="sanctionPostNo"%>"] ,[12,"<%=STATUS%>"],[13,"designation"],[14,"district"],[15,"instituteType"],[16,"permaPost"],[17,"tempPost"],[18,"supernumPost"]];
	 statusTd = 12;
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
<label><span>*</span>Reference Order</label>
<input	type="text" name="<%= CODE %>" value=""	validate="Reference Order,string,yes" class="textbox_size20" MAXLENGTH="30"	 tabindex=1> 
<script>
		document.grade.<%=CODE%>.focus();
</script>
<label><span>*</span>Cadre </label> 
<select id="cadre"	name="cadre" validate="Cadre ,string,yes" tabindex=1 onChange="populateDesignation(this.value,'designation')">
	<option value="">Select</option>
	 <% 
		for (MasCadre  mcl : cadreList)
		{
	%>
	<option value="<%=mcl.getId()%>"><%=mcl.getCadreName()%></option>
	<%
		}
	%> 
	</select>
	 
	<label><span>*</span>Designation </label> 
<select id="designation"	name="designation" validate="Designation ,string,yes" tabindex=1>
	<option value="">Select</option>
	 <% 
		for (MasRank  mr : designationList)
		{
	%>
	<option value="<%=mr.getId()%>"><%=mr.getRankName()%></option>
	<%
		}
	%> 
	</select>
	<div class="clear"></div>
	<label>Special Official Name </label> 
<select id="sploffName"	name="sploffName" validate="Special Official Name  ,string,no" tabindex=1>
	<option value="">Select</option>
	 <% 
		for (MasSpecialOfficial  mso : masSpecialOfficialList)
		{
	%>
	<option value="<%=mso.getId()%>"><%=mso.getSpecialOfficialName()%></option>
	<%
		}
	%> 
</select> 
 
<label><span>*</span>District  </label> 
<select id="district"	name="district" validate="District ,string,yes" tabindex=1 onChange="populateInst('temp')" >
	<option value="0">Select</option>
	 <% 
		for (MasDistrict  md : masdistrictList){%>
		<%if(md.getDistrictName()!=null){ %>
		 
	<option value="<%=md.getId()%>"><%=md.getDistrictName()%></option>
	<%} %> 
	<%} %>
	</select>
	
	<label><span>*</span>Institute Type </label> 
<select id="instituteType"	name="instituteType" validate="Institute type ,string,yes" tabindex=1 onChange="populateInst('temp')" >
	<option value="0">Select</option>
	 <% 
		for (MasHospitalType  mht : mhospitalTypetList)
		{
	%>
	<option value="<%=mht.getId()%>"><%=mht.getHospitalTypeName()%></option>
	<%
		}
	%> 
	</select>
	<div class="clear"></div>
	
<label><span>*</span>Institute  </label> 
<select id="institute"	name="institute" validate="Institute ,string,yes" tabindex=1>
	<option value="">Select</option>
	 <% 
		for (MasHospital  mh : insList)
		{
	%>
	<option value="<%=mh.getId()%>"><%=mh.getHospitalName()%></option>
	<%
		}
	%>  
	</select>
<label><span>*</span>Department </label> 
<select id="dept"	name="dept" validate="Department,string,yes" tabindex=1>
	<option value="">Select</option>
	 <% 
		for (MasEmployeeDepartment  md : deptList)
		{
	%>
	<option value="<%=md.getId()%>"><%=md.getEmpDeptName()%></option>
	<%
		}
	%> 
</select>
 
<label><span>*</span> From Date</label> 
<input	type="text" id="startDateId" name="<%=START_DATE%>" value=""	class="date" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="From Date,date,yes"  />
<img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date"	onclick="javascript:setdate('',document.grade.<%=START_DATE%>,event)" />
<div class="clear"></div>
<label><span>*</span> To Date</label>
<input type="text" id="endDateId"	name="<%=END_DATE%>" value=""   class="date" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');"	validate="To Date,date,yes" 	 />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="javascript:setdate('',document.grade.<%=END_DATE%>,event)" />
 
<label><span>*</span>Sanction Post No </label> 
<input type="text" name="sanctionPostNo" id="sanctionPostNo" validate="Sanction Post No,string,yes" tabindex=1  onKeyPress="return isNumber(event)" MAXLENGTH="3" />
<!--  -->

<label> <span>*</span>Permanent Post </label> 
<input type="text"	name="permaPost" id="permaPost" value="0 " validate="Permanent Post,int,yes"	class="textbox_size20" MAXLENGTH="4"  tabindex=1>  
<div class="clear"></div>
<label><span>*</span>Temporary Post </label> 
<input type="text"	name="tempPost" id="tempPost" value=" 0" validate="Temporary Post,int,yes"	class="textbox_size20" MAXLENGTH="4"  tabindex=1>  

<label><span>*</span>Supernumerary Post </label> 
<input type="text"	name="supernumPost"	id="supernumPost" value=" 0" validate="Supernumerary Post,int,yes"	class="textbox_size20" MAXLENGTH="4"  tabindex=1> 
 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button" onClick="if(totalPost()){submitForm('grade','generalMaster?method=addSanctionInstitutePost','check();');}"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit"	id="editbutton" value="Update" class="button" style="display: none;"	onClick="submitForm('grade','generalMaster?method=editSanctionInstitutePost','check();')" accesskey="u"	tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" style="display: none;"	class="button"	onClick="submitForm('grade','generalMaster?method=deleteSanctionInstitutePost&flag='+this.value)"	accesskey="d" tabindex=1 />
<input type="reset" name="Reset"	id="reset" value="Reset" class="buttonHighlight"	 accesskey="r" /> 
<input type="hidden"	name="<%=STATUS %>" value=" y" /> <input type="hidden"	name="<%= COMMON_ID%>" value="" />
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
data_header[0][0] = "Reference Order"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Cadre"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "cadre";

data_header[2] = new Array;
data_header[2][0] = "Special official Name"
data_header[2][1] = "data";
data_header[2][2] = 0;
data_header[2][3] = "sploffName"

	data_header[3] = new Array;
data_header[3][0] = "Institute"
data_header[3][1] = "data";
data_header[3][2] = 0;
data_header[3][3] = "insititue"

	data_header[4] = new Array;
data_header[4][0] = "Department"
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "dept"


	data_header[5] = new Array;
	data_header[5][0] = "From Date"
	data_header[5][1] = "hide";
	data_header[5][2] = 0;
	data_header[5][3] = "<%= START_DATE %>"
	

		data_header[6] = new Array;
		data_header[6][0] = "To Date"
		data_header[6][1] = "hide";
		data_header[6][2] = 0;
		data_header[6][3] = "<%= END_DATE %>"
		
	
data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%= CHANGED_BY %>"

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = "0";
data_header[8][3] = "<%= CHANGED_DATE %>";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%=CHANGED_TIME %>";

data_header[10] = new Array;
data_header[10][0] = "Sanction Post"
data_header[10][1] = "data";
data_header[10][2] = "15%";
data_header[10][3] = "sanctionPostNo";

data_header[11] = new Array;
data_header[11][0] = "Status"
data_header[11][1] = "hide";
data_header[11][2] = "15%";
data_header[11][3] = "<%=STATUS%>";

data_header[12]=new Array;
data_header[12][0]="Designation";
data_header[12][1]="hide";
data_header[12][2]="15%";
data_header[12][3]="designation";

data_header[13]=new Array;
data_header[13][0]="District";
data_header[13][1]="hide";
data_header[13][2]="15%";
data_header[13][3]="district";

data_header[14]=new Array;
data_header[14][0]="Institute Type";
data_header[14][1]="hide";
data_header[14][2]="15%";
data_header[14][3]="instituteType";

data_header[15]=new Array;
data_header[15][0]="Permanent Post";
data_header[15][1]="hide";
data_header[15][2]="15%";
data_header[15][3]="permaPost";

data_header[16]=new Array;
data_header[16][0]="Temporary Post";
data_header[16][1]="hide";
data_header[16][2]="15%";
data_header[16][3]="tempPost";

data_header[17]=new Array;
data_header[17][0]="Supernumerary Post ";
data_header[17][1]="hide";
data_header[17][2]="15%";
data_header[17][3]="supernumPost";

data_arr = new Array();

<%
Iterator itr=institutionalSanctionedPostList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  HrInstitutionalSanctionedPost  hisp = (HrInstitutionalSanctionedPost)itr.next(); 
%>
data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hisp.getId()%>
data_arr[<%= counter%>][1] = "<%=hisp.getRefOrderId()!= null ? hisp.getRefOrderId():" "%>";
data_arr[<%= counter%>][2] = "<%=hisp.getCadre()!= null ? hisp.getCadre().getCadreName():" "%>";
data_arr[<%= counter%>][13] = "<%=hisp.getRank()!= null ? hisp.getRank().getRankName():" "%>";
data_arr[<%= counter%>][14] = "<%=hisp.getInstitution().getDistrict()!= null ? hisp.getInstitution().getDistrict().getDistrictName():" "%>";
data_arr[<%= counter%>][15] = "<%=hisp.getInstitution().getHospitalType()!= null ? hisp.getInstitution().getHospitalType().getHospitalTypeName() :" "%>";
data_arr[<%= counter%>][16] = "<%=hisp.getPermanentPost()!= null ? hisp.getPermanentPost():" "%>";
data_arr[<%= counter%>][17] = "<%=hisp.getTemporaryPost()!= null ? hisp.getTemporaryPost():" "%>";
data_arr[<%= counter%>][18] = "<%=hisp.getSupernumeraryPost()!= null ? hisp.getSupernumeraryPost():" "%>";

data_arr[<%= counter%>][3] = "<%=hisp.getSpecialOfficial()!= null ? hisp.getSpecialOfficial().getSpecialOfficialName():" "%>";
data_arr[<%= counter%>][4] = "<%=hisp.getInstitution()!= null ? hisp.getInstitution().getHospitalName():" "%>";
data_arr[<%= counter%>][5] =  "<%=hisp.getDepartment()!= null ? hisp.getDepartment().getEmpDeptName():" "%>";

data_arr[<%= counter%>][6] = "<%= hisp.getFromDate()!=null? HMSUtil.convertDateToStringWithoutTime(hisp.getFromDate()) :" "%>";
data_arr[<%= counter%>][7] = "<%= hisp.getToDate()!=null? HMSUtil.convertDateToStringWithoutTime(hisp.getToDate()) :" "%>";
 data_arr[<%= counter%>][8] = "<%= hisp.getLastChgBy()!=null?(hisp.getLastChgBy().getId()!=null?hisp.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][9] = "<%= HMSUtil.convertDateToStringWithoutTime(hisp.getLastChgDate()) %>"
data_arr[<%= counter%>][10] = "<%= hisp.getLastChgTime() %>"  

<% if(hisp.getPostNo()!= null){ %>
data_arr[<%= counter%>][11] = "<%= hisp.getPostNo()%>"  
<%}else{%>
data_arr[<%= counter%>][11] = ""
<%}%>
<%if(hisp.getStatus()!=null){%>
<% if(hisp.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][12] = "Active"
<%}
}else{%>
data_arr[<%= counter%>][12] = "InActive"
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
<script type="text/javascript">

function removeAllOptions(selectbox)
{
	var i;
	for(i=selectbox.options.length-1;i>=0;i--)
	{
		selectbox.remove(i);
	}
}

  function populateInst(id)
  {
	var hosType=document.getElementById("instituteType").value; 
	var dist=document.getElementById("district").value;
	//alert(hosType+" -- "+dist)
	var sel = document.getElementById("institute");
	removeAllOptions(sel);
	if(hosType!="0" && dist==0){
		//alert(hosType+" hosType not zero dist- "+dist)
	var size = <%=insList.size()%>
	optionRepMan = new Option("Select" , "0","true");
	sel.options.add(optionRepMan);
		 	<%
			for(MasHospital mid:insList){%>
				if(<%=mid.getHospitalType().getId()%> == hosType){<%
				if(mid.getStatus().equalsIgnoreCase("y")){
			%>
				optionRepMan = new Option("<%=mid.getHospitalName()%>" , "<%=mid.getId()%>","true");				
				sel.options.add(optionRepMan);
			<%}
			%>
				}
				<%}%>
		}
	
	if(dist!="0" && hosType =="0"){
		//alert(hosType+" not zero dist- "+dist)
		var size = <%=insList.size()%>
		optionRepMan = new Option("Select" , "0","true");
		sel.options.add(optionRepMan);

		<%
				for(MasHospital mid:insList){%>
				<%if(mid.getDistrict()!=null){%>
					if(<%=mid.getDistrict().getId()%> == dist){<%
					if(mid.getStatus().equalsIgnoreCase("y")){
				%>
					optionRepMan = new Option("<%=mid.getHospitalName()%>" , "<%=mid.getId()%>","true");				
					sel.options.add(optionRepMan);
						
				<%}
				%>
					}
					<%}%>
					<%}%>
				
			}
	
	if(dist!="0" && hosType !="0"){
		var size = <%=insList.size()%>
		optionRepMan = new Option("Select" , "0","true");
		sel.options.add(optionRepMan);
				<%
				for(MasHospital mid:insList){%>
				<%if(mid.getDistrict()!=null){%>
					if(<%=mid.getDistrict().getId()%> == dist && <%=mid.getHospitalType().getId()%> == hosType){<%
					if(mid.getStatus().equalsIgnoreCase("y")){
				%>
					optionRepMan = new Option("<%=mid.getHospitalName()%>" , "<%=mid.getId()%>","true");				
					sel.options.add(optionRepMan);
						
				<%}
				%>
					}
					<%}%>
					<%}%>
			}
}

function isNumber(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode != 46 && charCode > 31
     && (charCode < 48 || charCode > 57))
      return false;
   return true;
}
//
function populateDesignation(cadre,id){	
		var sel = document.getElementById(id);
		removeAllOptions(sel);
		if(cadre !="0"){
				<% 
				for(MasRank mr:designationList){%>
				<%if(mr.getCadre()!=null){%>
				 if(<%=mr.getCadre().getId() %> == cadre){ <% 
							if(mr.getStatus().equalsIgnoreCase("y")){
						%>
					optionRepMan = new Option("<%=mr.getRankName()%>" , "<%=mr.getId()%>","true");				
					sel.options.add(optionRepMan);
					<%}%>
					}
				 <%}%>
					<%}%>
					optionRepMan = new Option("<%="Select"%>" , "0","true");				
					sel.options.add(optionRepMan);
			}
	} 
</script>
