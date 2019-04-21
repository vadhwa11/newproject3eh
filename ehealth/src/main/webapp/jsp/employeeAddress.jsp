<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * employee.jsp  
 * Purpose of the JSP -  This is for Employee Information.
 * @author  Rajat  
 * Create Date: 12th Jan,2009
 * Revision Date:      
 * Revision By: 
 * @version 1.10
--%>

<%@page import="jkt.hms.masters.business.MasReligion"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasTitle"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasCostCenter"%>
<%@page import="jkt.hms.masters.business.MasEmpStatus"%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>
<%@page import="jkt.hms.masters.business.MasGrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasRank"%> 
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.TransactionSequence"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasEmployeeCaste"%>
<%@page import="jkt.hms.masters.business.MasEmployeeSubCaste"%>
<%@page import="jkt.hms.masters.business.MasCategory"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasPostCode"%>
<%@page import="jkt.hms.masters.business.MasVillage"%>
<%@page import="jkt.hms.masters.business.MasLsg"%>
<%@page import="jkt.hms.hrms.masters.business.*" %>
<%@page import="jkt.hms.hrms.recruitment.masters.business.*"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasLsgType"%>
<%@page import="jkt.hms.masters.business.MasTaluk"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.PhMasLocalityType"%>
<%@page import="jkt.hms.masters.business.MasVisaType"%>
<%@page import="jkt.hrms.masters.business.HrMasQualification"%>
<%@page import="jkt.hrms.masters.business.HrMasCourse"%>
<%@page import="jkt.hrms.masters.business.HrMasSpecialQualification"%>
<%@page import="jkt.hrms.masters.business.HrMasInstitute"%>
<%@page import="jkt.hrms.masters.business.HrEmployeeExperience"%>
<%@page import="jkt.hrms.masters.business.UserManager"%>
<%@page import="jkt.hrms.recruitment.masters.business.Resumepersonaldetails" %>
<%@page import="jkt.hrms.recruitment.masters.business.Resumeskillmaster" %>
<%@page import="jkt.hrms.masters.business.MasEmployeeType"%>
<%@page import="jkt.hrms.masters.business.MasLocation"%>
<%@page import="jkt.hms.util.EmployeeEducationComparator"%>
<%@page import="jkt.hrms.masters.business.HrMasEmployeeEducation"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" src="/hms/jsp/js/tabcontent.js">
/***********************************************
* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/
</script>
<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/animatedcollapse.js">
/***********************************************
 * 
* Animated Collapsible DIV v2.0- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for this script and 100s more
***********************************************/
</script>

<script type="text/javascript">

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

</script>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script language="javascript">
var $j = jQuery.noConflict();
</script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<script>
<%
	//System.gc();
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
String empcode = "";
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
		Map<String,Object> mapEmployee = new HashMap<String,Object>();
		if(request.getAttribute("map") != null){
			mapEmployee = (Map<String,Object>) request.getAttribute("map");
		}
		int hospId = 0;
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmpStatus> empStatusList = new ArrayList<MasEmpStatus>();
		List<MasEmpCategory> empCategoryList = new ArrayList<MasEmpCategory>();
	
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		List<MasRank> rankList = new ArrayList<MasRank>();
	
		List<TransactionSequence> seqList = new ArrayList<TransactionSequence>();
		List<Resumepersonaldetails> joinedCandidates = new ArrayList<Resumepersonaldetails>();
		List<HrMasQualification> qualificationList = new ArrayList<HrMasQualification>();
		List<HrMasCourse> coursesList = new ArrayList<HrMasCourse>();
		List<HrMasSpecialQualification> splQualificationList = new ArrayList<HrMasSpecialQualification>();
		List<HrMasInstitute> institutesList = new ArrayList<HrMasInstitute>();
		List<Resumeskillmaster> skillMasterList = new ArrayList<Resumeskillmaster>();
	
		List<MasEmployeeType> employeeTypeList = new ArrayList<MasEmployeeType>();
		List<MasMaritalStatus> maritalStatusList = new ArrayList<MasMaritalStatus>(); 
		List<MasAdministrativeSex> masAdministrativeSexList = new ArrayList<MasAdministrativeSex>();
		List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
		
		
		
		 List<MasDistrict> districtList = new ArrayList<MasDistrict>();
	      
	       List<MasPostCode> postCodeList = new ArrayList<MasPostCode>();
			List<MasVillage> villageList = new ArrayList<MasVillage>();
			
			List<MasLsg> lsgNameList=new ArrayList<MasLsg>();
			List<MasLsgType> lsgTypeList=new ArrayList<MasLsgType>();
			List<MasTaluk> talukList=new ArrayList<MasTaluk>();
			
			List<MasState> stateList = new ArrayList<MasState>();
			List<MasCountry> countryList = new ArrayList<MasCountry>();
			List<MasVisaType> visaTypeList=new ArrayList<MasVisaType>();
			List<PhMasLocalityType> localityList=new ArrayList<PhMasLocalityType>();
			
		if(mapEmployee.get("titleList") != null){
			titleList = (List<MasTitle>)mapEmployee.get("titleList");
			session.setAttribute("titleList", titleList);
		}else if(session.getAttribute("titleList") != null){
			titleList = (List<MasTitle>)session.getAttribute("titleList");
		}
		
		if(mapEmployee.get("departmentList") != null){
			departmentList = (List<MasDepartment>)mapEmployee.get("departmentList");
			session.setAttribute("departmentList", departmentList);
		}else if(session.getAttribute("departmentList") != null){
			departmentList = (List<MasDepartment>)session.getAttribute("departmentList");
		}
		
		if(mapEmployee.get("empStatusList") != null){
			empStatusList = (List<MasEmpStatus>)mapEmployee.get("empStatusList");
			session.setAttribute("empStatusList", empStatusList);
		}else if(session.getAttribute("empStatusList") != null){
			empStatusList = (List<MasEmpStatus>)session.getAttribute("empStatusList");
		}
		
	
		
		if(mapEmployee.get("empCategoryList") != null){
			empCategoryList = (List<MasEmpCategory>)mapEmployee.get("empCategoryList");
			session.setAttribute("empCategoryList", empCategoryList);
		}else if(session.getAttribute("empCategoryList") != null){
			empCategoryList = (List<MasEmpCategory>)session.getAttribute("empCategoryList");
		}
		
		if(mapEmployee.get("gradeList") != null){
			//gradeList = (List<Object[]>)mapEmployee.get("gradeList");
			gradeList = (List<MasGrade>)mapEmployee.get("gradeList");
			session.setAttribute("gradeList", gradeList);
		}else if(session.getAttribute("gradeList") != null){
			//gradeList = (List<Object[]>)session.getAttribute("gradeList");
			gradeList = (List<MasGrade>)mapEmployee.get("gradeList");
		}
		
	
		if(mapEmployee.get("rankList") != null){
			//rankList = (List<Object[]>)mapEmployee.get("rankList");
			rankList = (List<MasRank>)mapEmployee.get("rankList");
			session.setAttribute("rankList", rankList);
		}else if(session.getAttribute("rankList") != null){
			//rankList = (List<Object[]>)session.getAttribute("rankList");
			rankList = (List<MasRank>)mapEmployee.get("rankList");
		}
	
		
		if(mapEmployee.get("seqList") != null){
			seqList = (List<TransactionSequence>)mapEmployee.get("seqList");
			session.setAttribute("seqList", seqList);
		}else if(session.getAttribute("seqList") != null){
			seqList = (List<TransactionSequence>)session.getAttribute("seqList");
		}
		
		if(mapEmployee.get("joinedCandidates") != null){
			joinedCandidates = (List<Resumepersonaldetails>)mapEmployee.get("joinedCandidates");
			//System.out.println(joinedCandidates.size());
			session.setAttribute("joinedCandidates", joinedCandidates);
		}else if(session.getAttribute("joinedCandidates") != null){
			joinedCandidates = (List<Resumepersonaldetails>)session.getAttribute("joinedCandidates");
		}
		
		if(mapEmployee.get("qualificationList") != null){
			qualificationList = (List<HrMasQualification>)mapEmployee.get("qualificationList");
			session.setAttribute("qualificationList", qualificationList);
		}else if(session.getAttribute("qualificationList") != null){
			qualificationList = (List<HrMasQualification>)session.getAttribute("qualificationList");
		}
		//System.out.println("list size---"+qualificationList.size());
		if(mapEmployee.get("coursesList") != null){
			coursesList = (List<HrMasCourse>)mapEmployee.get("coursesList");
			session.setAttribute("coursesList", coursesList);
		}else if(session.getAttribute("coursesList") != null){
			coursesList = (List<HrMasCourse>)session.getAttribute("coursesList");
		}
		
		if(mapEmployee.get("splQualificationList") != null){
			splQualificationList = (List<HrMasSpecialQualification>)mapEmployee.get("splQualificationList");
			session.setAttribute("splQualificationList", splQualificationList);
		}else if(session.getAttribute("splQualificationList") != null){
			splQualificationList = (List<HrMasSpecialQualification>)session.getAttribute("splQualificationList");
		}
		
		if(mapEmployee.get("institutesList") != null){
			institutesList = (List<HrMasInstitute>)mapEmployee.get("institutesList");
			//System.out.println(joinedCandidates.size());
			session.setAttribute("institutesList", institutesList);
		}else if(session.getAttribute("institutesList") != null){
			institutesList = (List<HrMasInstitute>)session.getAttribute("institutesList");
		}
		
		if(mapEmployee.get("skillMasterList") != null){
			skillMasterList = (List<Resumeskillmaster>)mapEmployee.get("skillMasterList");
			session.setAttribute("skillMasterList", skillMasterList);
		}else if(session.getAttribute("skillMasterList") != null){
			skillMasterList = (List<Resumeskillmaster>)session.getAttribute("skillMasterList");
		}
		if(mapEmployee.get("countryList") != null){
			countryList = (List<MasCountry>)mapEmployee.get("countryList");
			session.setAttribute("countryList", countryList);
		}else if(session.getAttribute("countryList") != null){
			countryList = (List<MasCountry>)session.getAttribute("countryList");
		}
		if(mapEmployee.get("employeeTypeList") != null){
			employeeTypeList = (List<MasEmployeeType>)mapEmployee.get("employeeTypeList");
			session.setAttribute("employeeTypeList", employeeTypeList);
		}else if(session.getAttribute("employeeTypeList") != null){
			employeeTypeList = (List<MasEmployeeType>)session.getAttribute("employeeTypeList");
		}
		if(mapEmployee.get("maritalStatusList") != null){
			maritalStatusList = (List<MasMaritalStatus>)mapEmployee.get("maritalStatusList");
			session.setAttribute("maritalStatusList", maritalStatusList);
		}else if(session.getAttribute("maritalStatusList") != null){
			maritalStatusList = (List<MasMaritalStatus>)session.getAttribute("maritalStatusList");
		}
		
		if(mapEmployee.get("masAdministrativeSexList") != null){
			masAdministrativeSexList = (List<MasAdministrativeSex>)mapEmployee.get("masAdministrativeSexList");
			session.setAttribute("masAdministrativeSexList", masAdministrativeSexList);
		}else if(session.getAttribute("masAdministrativeSexList") != null){
			masAdministrativeSexList = (List<MasAdministrativeSex>)session.getAttribute("masAdministrativeSexList");
		}
		if(mapEmployee.get("masHospitalList") != null){
			masHospitalList = (List<MasHospital>)mapEmployee.get("masHospitalList");
			//session.setAttribute("masHospitalList", masHospitalList);
		}
		List<MasEmployee> employeeCodeList = new ArrayList<MasEmployee>();
		employeeCodeList = (ArrayList) map.get("employeeCodeList");
		List<MasRelation> relationCodeList = new ArrayList<MasRelation>();
		relationCodeList = (ArrayList) map.get("relationCodeList");
		
		if(seqList.size() > 0){
		TransactionSequence	tran = (TransactionSequence)seqList.get(0);
		 empcode ="E"+(String.valueOf(""+tran.getTransactionSequenceNumber()));
		 //System.out.println("empcode:::::::"+empcode);
		}		
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
		
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");
		
		List<MasEmployee> searchEmployeeList = new ArrayList<MasEmployee>(); 
		if(mapEmployee.get("searchEmployeeList") != null){
			searchEmployeeList = (List)mapEmployee.get("searchEmployeeList");
			session.setAttribute("mapEmployee",mapEmployee);
	
		}
		
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		String message = "";
		if(mapEmployee.get("message") != null){
			    message = (String)mapEmployee.get("message");
			 
			   
			  }
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		if(mapEmployee.get("employeeList") != null){
			employeeList = (List)mapEmployee.get("employeeList");
		   
		  }
		List<MasLocation> locationList = new ArrayList<MasLocation>();
		if(mapEmployee.get("locationList") != null){
			locationList = (List)mapEmployee.get("locationList");
		   
		  }
		
		List<MasReligion> masReligion = new ArrayList<MasReligion>();
		if(mapEmployee.get("masReligion") != null){
			masReligion = (List)mapEmployee.get("masReligion");
		   
		  }
		
		List<MasEmployeeCaste > masEmployeeCaste = new ArrayList<MasEmployeeCaste>();
		List<MasEmployeeSubCaste > masEmployeeSubCaste = new ArrayList<MasEmployeeSubCaste>();
		List<MasCategory > masCategory = new ArrayList<MasCategory>();
		if(mapEmployee.get("masEmployeeCaste") != null){
			masEmployeeCaste = (List)mapEmployee.get("masEmployeeCaste");
		   
		  }
		if(mapEmployee.get("masEmployeeSubCaste") != null){
			masEmployeeSubCaste = (List)mapEmployee.get("masEmployeeSubCaste");
		   
		  }
		if(mapEmployee.get("masCategory") != null){
			masCategory = (List)mapEmployee.get("masCategory"); 
		  }				
		
		
%>

<h2>Employee Information</h2>
			
<script type="text/javascript">
var icdArray=new Array();
var icdArray1=new Array();
var icdArray2=new Array();
var icdArray3=new Array();
var lineManagerArr = new Array();
</script>

<% if(!message.equals("")){ %>
<h4><%=message %></h4>
<%} %>

<div class="clear"></div>
<div class="Block">

	  <div id="searcharea">
	  
		  <div id="searchbar">
		  
			  <form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			    		      <label class="medium">PEN</label>     
			    	<input type="radio" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" class="radioAuto" tabindex=1 />
			    	
			    	<label class="medium">Emp Name</label>
					<input type="radio" name="<%=SELECTED_RADIO %>" value="2"  class="radioAuto"  tabindex=1 MAXLENGTH="128" />
			    	
					<%-- <label class="medium">First Name</label>
					<input type="radio" name="<%=SELECTED_RADIO %>" value="2"  class="radioAuto"  tabindex=1 MAXLENGTH="32" /> --%>
					
					<%-- <label class="medium">Last Name</label>
					<input type="radio" name="<%=SELECTED_RADIO %>" value="3"  class="radioAuto" tabindex=1 MAXLENGTH="32"  />		 --%>								
						
					<input type="text"  id="searchField" class="medium3"  name="<%= SEARCH_FIELD%>" value=""  validate="Employee Code,string,no" MAXLENGTH="32" onkeypress="return submitenter(this,event,'personnel?method=searchEmployee')" tabindex=1/>
                 <input type="button" name="search" value="Search" class="buttonBig" onclick="submitForm('search','personnel?method=searchEmployee','checkSearch')" tabindex=1  />
                                   
		            
		            <input type="button" name="Report" value="Generate Report" class="buttonBig2" onClick="submitForm('search','personnel?method=generateReportForEmployeeInformation');" accesskey="g" tabindex=1/>
		           <!--  <input type="button" name="Report" value="Generate Report Excel" class="buttonBig2" onClick="submitForm('search','personnel?method=generateReportForEmployeeInformationExcel');" accesskey="e" tabindex=2/> -->		          
                     
                    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_employee">

		     </form>
		 </div>
 </div>
<div class="clear"></div>
 </div>

	<jsp:include page="searchResultBlock.jsp" />
	<div class="clear"></div>
 <div id="searchresults" >
	<div id="searchtable" ></div>
	<div class="division"></div>
	<% try{
		if(searchEmployeeList.size()>0 )
		 {
			String strForCode = (String)mapEmployee.get("employeeCode");
			String strForCodeFirstDescriptions = (String)mapEmployee.get("firstName");
			String strForCodeLastDescriptions = (String)mapEmployee.get("lastName");
			if(strForCode!= null && strForCode!= "" || strForCodeFirstDescriptions!= null && strForCodeFirstDescriptions!= "" || strForCodeLastDescriptions!=null && strForCodeLastDescriptions!="")
			{
	%> 
  <br/>
    <a href="personnel?method=showEmployeeJsp">Show All Records</a>
	<%
			}
		 }else{%> 
			 <a href="personnel?method=showEmployeeJsp">Show All Records</a>
			<% }
		}
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	 %>
	<script type="text/javascript">
		
	formFields = [
	[0, "<%= COMMON_ID%>", "id"], [1,"<%= EMPLOYEE_CODE%>"],  [2,"<%= APPOINTMENT_DATE %>"],[3,"<%=JOIN_DATE%>"],[4,"<%= EMPLOYEE_TYPE %>"],[5,"<%= EMPLOYEE_CARD_NO%>"],[6,"<%= FIRST_NAME%>"],[7,"empName"],[8,"<%= LAST_NAME%>"],[9,"<%= TITLE_ID %>"],[10,"<%=RANK_ID%>"],[11,"<%=EMP_STATUS_ID%>"],[12,"<%= DEPARTMENT_ID %>"],[13,"<%= GENDER%>"],[14,"<%= DATE_OF_BIRTH %>"],[15,"<%= PASSPORTNUMBER%>"],[16,"<%=PASSPORTISSUEDATE %>"],[17,"<%= PASSPORTEXPIRYDATE %>"],[18,"<%= VISADETAILS%>"],[19,"<%= PANNO%>"],[20,"<%= DRIVING%>"],[21,"<%= MARITAL_STATUS_ID%>"],[22,"<%= MARRIAGE_DATE%>"],[23,"<%= BANK_CODE%>"],[24,"<%= BANK_ACCOUNT_CODE%>"],[25,"<%=BANK_ACCOUNT_NUMBER%>"], [26,"<%=ACCOUNT_HEAD %>"],[27,"<%=STATUS %>"],[28,"<%=EMPLOYEE_PERMANENT_ADDRESS%>"],[29,"<%=EMPLOYEE_RESIDENTIAL_ADDRESS%>"],[30,"<%=EMERGENCY_MOBILE%>"],[31,"<%=TELL_NO_OFFICE%>"],[32,"<%=TELL_NO_RESIDENCE%>"],[33,"<%=EMAIL%>"],[34,"<%=URL%>"],[35,"<%=SERVICE_START_DATE+"1"%>"],[36,"<%=SERVICE_END_DATE+ "1"%>"],[37,"<%=YEARS+ "1"%>"],[38,"<%=MONTHS+ "1"%>"],[39,"<%=PREVIOUS_EMPLOYER+ "1"%>"],[40,"<%=DESIGNATION+ "1"%>"],[41,"<%=EX_AWARDS+ "1"%>"],[42,"<%=PREVIOUS_SERVICE_END_REASON+ "1"%>"],[43,"<%=EMPLOYER_PHONE_NO+ "1"%>"],[44,"<%=EMPLOYER_ADDRESS+ "1"%>"],[45,"<%=EXPERIENCE_SKILLS+"1"%>"],[46,"<%=MANAGER_ID%>"],[47,"<%=LOCATION%>"],[48,"<%=PROBATION_PERIOD%>"],[49,"<%=CONFIRMATION_DUE_DATE%>"],[50,"<%=LAST_WORKING_DAY%>"],[51,"<%=DATE_OF_RESIGNATION%>"]
	,[52,"<%=EQUIVALENT_DESIGNATION%>"],[53,"<%=EMPLOYEE_GRADE_ID%>"],[54,"<%=PFNO%>"],[55,"<%=PAY_MODE%>"],[56,"joinOrganisation"],[57,"hospitalIdEmp"],[58,"managerId"],[59,"<%=PASSPORTISSUEPLACE%>"]
	,[60,"<%=QUALIFICATION + "1"%>"],[61,"<%=QUALIFICATION + "2"%>"],[62,"<%=QUALIFICATION + "3"%>"],[63,"<%=COURSES_NAME + "1"%>"],
	[64,"<%=COURSES_NAME + "2"%>"],[65,"<%=COURSES_NAME+ "3"%>"],[66,"<%=SPL_QUALIFICATION + "1"%>"],[67,"<%=SPL_QUALIFICATION+ "2"%>"],[68,"<%=SPL_QUALIFICATION + "3"%>"]
	,[69,"<%=INSTITUTION + "1"%>"],[70,"<%=INSTITUTION+ "2"%>"],[71,"<%=INSTITUTION+ "3"%>"],[72,"<%=START_DATE + "1"%>"],[73,"<%=START_DATE + "2"%>"],
	[74,"<%=START_DATE+ "3"%>"],[75,"<%=END_DATE + "1"%>"],[76,"<%=END_DATE + "2"%>"],[77,"<%=END_DATE + "3"%>"],[78,"<%=COURSES_DURATION + "1"%>"],
	[79,"<%=COURSES_DURATION+ "2"%>"],[80,"<%=COURSES_DURATION+ "3"%>"],[81,"<%=QUALIFIED_DATE + "1"%>"],[82,"<%=QUALIFIED_DATE+ "2"%>"],[83,"<%=QUALIFIED_DATE+ "3"%>"]
	,[84,"<%=AWARDS+ "1"%>"],[85,"<%=AWARDS + "2"%>"],[86,"<%=AWARDS + "3"%>"],[87,"<%=EDUCATION_SKILLS+ "1"%>"],[88,"<%=EDUCATION_SKILLS+ "2"%>"],[89,"<%=EDUCATION_SKILLS+ "3"%>"]
	
	,[90,"<%=HANDICAP_STATUS%>"],[91,"<%=INSURANCE_TYPE%>"],[92,"<%=INSURANCE_COMPANY%>"]
	,[93,"<%=INSURANCE_START_DATE%>"],[94,"<%=INSURANCE_END_DATE%>"],[95,"<%=MEDICAL_REMARKS%>"]		
	,[96,"<%=EXPERIENCE_SKILLS%>"],[97,"fatherOrHusbandName"],[98,"employee_Code"],[99,"sbuId"]
	,[100,"<%=QUALIFICATION + "4"%>"],[101,"<%=QUALIFICATION + "5"%>"],[102,"<%=COURSES_NAME + "4"%>"]
	,[103,"<%=COURSES_NAME + "5"%>"],[104,"<%=SPL_QUALIFICATION + "4"%>"],[105,"<%=SPL_QUALIFICATION + "5"%>"]
	,[106,"<%=INSTITUTION + "4"%>"],[107,"<%=INSTITUTION + "5"%>"],[108,"<%=START_DATE + "4"%>"]
	,[109,"<%=START_DATE + "5"%>"],[110,"<%=END_DATE + "4"%>"],[111,"<%=END_DATE + "5"%>"]
	,[112,"<%=COURSES_DURATION + "4"%>"],[113,"<%=COURSES_DURATION+ "5"%>"],[114,"<%=QUALIFIED_DATE + "4"%>"],
	[115,"<%=QUALIFIED_DATE+ "5"%>"],[116,"<%=AWARDS+ "4"%>"],[117,"<%=AWARDS + "5"%>"],
	[118,"<%=EDUCATION_SKILLS+ "4"%>"],[119,"<%=EDUCATION_SKILLS+ "5"%>"],[120,"religion"],[121,"premium"]
	,[122,"<%=SERVICE_START_DATE+"2"%>"],[123,"<%=SERVICE_END_DATE+"2"%>"],[124,"<%=YEARS+ "2"%>"],[125,"<%=MONTHS+ "2"%>"],[126,"<%=PREVIOUS_EMPLOYER+ "2"%>"]
	,[127,"<%=DESIGNATION+ "2"%>"],[128,"<%=EX_AWARDS+ "2"%>"],[129,"<%=PREVIOUS_SERVICE_END_REASON+ "2"%>"],[130,"<%=EMPLOYER_PHONE_NO+ "2"%>"]
	,[131,"<%=EMPLOYER_ADDRESS+ "2"%>"],[132,"<%=EXPERIENCE_SKILLS+"2"%>"],[133,"<%=SERVICE_START_DATE+"3"%>"],
	[134,"<%=SERVICE_END_DATE+"3"%>"],[135,"<%=YEARS+ "3"%>"],[136,"<%=MONTHS+ "3"%>"],[137,"<%=PREVIOUS_EMPLOYER+ "3"%>"],[138,"<%=DESIGNATION+ "3"%>"],[139,"<%=EX_AWARDS+ "3"%>"]
	,[140,"<%=PREVIOUS_SERVICE_END_REASON+ "3"%>"],[141,"<%=EMPLOYER_PHONE_NO+ "3"%>"],[142,"<%=EMPLOYER_ADDRESS+ "3"%>"],[143,"<%=EXPERIENCE_SKILLS+"3"%>"]
	,[144,"<%=SERVICE_START_DATE+"4"%>"],[145,"<%=SERVICE_END_DATE+"4"%>"],[146,"<%=YEARS+ "4"%>"],[147,"<%=MONTHS+ "4"%>"],[148,"<%=PREVIOUS_EMPLOYER+ "4"%>"]
	,[149,"<%=DESIGNATION+ "4"%>"],[150,"<%=EX_AWARDS+ "4"%>"],[151,"<%=PREVIOUS_SERVICE_END_REASON+ "4"%>"],[152,"<%=EMPLOYER_PHONE_NO+ "4"%>"]
	,[153,"<%=EMPLOYER_ADDRESS+ "4"%>"],[154,"<%=EXPERIENCE_SKILLS+"4"%>"],
	[155,"<%=SERVICE_START_DATE+"5"%>"],[156,"<%=SERVICE_END_DATE+"5"%>"],[157,"<%=YEARS+ "5"%>"],[158,"<%=MONTHS+ "5"%>"],[159,"<%=PREVIOUS_EMPLOYER+ "5"%>"]
	,[160,"<%=DESIGNATION+ "5"%>"],[161,"<%=EX_AWARDS+ "5"%>"],[162,"<%=PREVIOUS_SERVICE_END_REASON+ "5"%>"],[163,"<%=EMPLOYER_PHONE_NO+ "5"%>"]
	,[164,"<%=EMPLOYER_ADDRESS+ "5"%>"],[165,"<%=EXPERIENCE_SKILLS+"5"%>"],[166,"<%=MIDDLE_NAME%>"],[167,"PEN"],[168,"ifscCode"],[169,"bankBranch"]
	]; 
	
                                                          	
	 statusTd = 27;
	</script>
	</div>
  
  <div class="clear"></div>
  
  <form name="employee" method="post" action="" >
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
  
  <input type="hidden" name="<%= POJO_NAME %>" value = "MasEmployee" />
  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="FirstName" />
  <input type="hidden" name="title" value = "Employee" />
  <input type="hidden" name="<%=JSP_NAME %>" value = "employee" />
  <input type="hidden" name="pojoPropertyCode" value = "EmployeeCode" />
  <input type="hidden" id="dclick" value = "yes" />
  <input type="hidden" id="rowid" value = "2" />  
	  	
	  	
		<a href="javascript:changeClass('title1','t1')"> <h5 id='t1' class="minus"></h5> </a>
 <!-- <a href="javascript:changeClass('title1','t1')"> <h5 id='t1' class="minus">Employee Joining Details</h5> </a>   -->
	<div class="clear"></div>
	  	 
	  	<%--  <div class="Block" id="title1">
	
			<label>Applicant</label>
			<select name="<%= APPLICANT_ID%>" onchange="populateField(this.value)">
				<option value="">
					Select
				</option>
				<%for(Resumepersonaldetails joinedCandidate : joinedCandidates){%>
				<option value="<%= joinedCandidate.getId() %>" >
				<%=joinedCandidate.getFirstName() + " " + joinedCandidate.getLastName()  %>	
				</option>
				<%} %>
			</select>
			
			<label>Expected Joining Date</label>
			<input type="text" id="appointmentId" name="<%=APPOINTMENT_DATE%>" value="" class="calDate" readonly="readonly" validate="Appointment Date,date,no"  MAXLENGTH="30" /> --%>
			<%-- <img src="/erp/jsp/images/cal.gif" onClick="javascript:setdate('',document.employee.<%=APPOINTMENT_DATE%>,event)" width="16" height="16" border="0" validate="Pick a date" class="calender" /> --%> 
			
  	  	   	<%-- <label>Actual Joining Date</label>
		    <input type="text" id="joinId" name="<%=JOIN_DATE%>" value="<%=dateCal+"/"+month+"/"+year%>" class="calDate" readonly="readonly" validate="Date Of Joining,date,no"  MAXLENGTH="30" /> --%>
			<%-- <img src="/erp/jsp/images/cal.gif" width="16" height="16" border="0" onClick="javascript:setdate('',document.employee.<%=JOIN_DATE%>,event)" validate="Pick a date" class="calender" /> --%> 
			  	 <%--
			
			<label>Probation Period</label>
			<select class="small" id="<%=PROBATION_PERIOD %>" name="<%=PROBATION_PERIOD %>" validate="Probation Period,string,no" onchange="populateConfirmationDueDate(this)"> 
			   <option value="">Select</option>
			   <option value="6">6</option>
			   <option value="12">12</option>
			</select>
			<label class="smallAuto">Months</label>
			<label class="smallAuto">&nbsp;&nbsp;&nbsp; </label>
			
			
			<label>Confirmation due date</label>
			<input type="text" id="<%=CONFIRMATION_DUE_DATE%>" name="<%=CONFIRMATION_DUE_DATE%>" value="" class="date" readonly="readonly" validate="Confirmation Due Date,date,no"  MAXLENGTH="30" />
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onClick="javascript:setdate('',document.employee.<%=CONFIRMATION_DUE_DATE%>,event)" validate="Pick a date" class="calender" />
			<div class="clear"></div>
			 	<div class="clear"></div>
			<label> Centre <span>*</span></label>
		 	<select name="joinOrganisation" id = "joinOrganisation" validate="Centre,string,yes">
		 	<option value="">Select </option>
		 	<% for(MasHospital comp : masHospitalList ){ %>
		 		<option value="<%=comp.getId() %>"><%=comp.getHospitalName()%></option>
		 	<%} %>
		 	</select>--%>
	   <!-- </div> -->	
	   
	  
	   <div class="clear"></div>
	  <!--  <div class="division"></div> -->
  		<a href="javascript:changeClass('title2','t2')"><h5 id='t2' class="minus">Employee Details</h5></a>
		<div class="clear"></div>
	  		<div class="Block" id="title2">
	  		<label > PEN  </label>
	  		<input type="text" id="PEN" name="PEN" value="" MAXLENGTH="12" class="medium3" validate="PEN,String,no" onblur="duplicateCodeNo(this.value)"/>
	  		
	  		<label > UHID  </label>
	  		<input type="text" id="UHID" name="UHID" value="" MAXLENGTH="12" class="medium3" validate="UHID,String,no" />
			
	  		<label > Service Type <span>*</span></label>
			<select id="employeeType" name=<%=EMPLOYEE_TYPE%> validate="Employee Type,string,yes" class="mediumm">
				<option value="">Select</option>
				<%for(MasEmployeeType employeeType : employeeTypeList){%>
				<option value="<%= employeeType.getId() %>" >
				<%= employeeType.getEmpType()%>	
				</option>
				<%} %>         
			</select>
			
			 <!-- <label>Employee Code <span>* </span></label> -->
			<input type="hidden" id="employee_Code" name="employee_Code" value="" MAXLENGTH="6" class="medium3" validate="Employee Code,String,no"  
			onblur="duplicateCodeNo(this.value)" />
			<%--
  	  	  	<label>Card No.</label>
			<input type="text" name="<%= EMPLOYEE_CARD_NO%>" id="employeeCardNo"  value="" validate="Card No.,string,no"      onblur="duplicateCardNo(this.value)" />
			     	<div class="clear"></div>
			   --%>
			   
			    <div class="clear"></div>
			    
			    <label>Designation <span>* </span></label>
				<select id="rankId" name=<%=RANK_ID %> validate="Designation,string,yes" class="mediumm">
				<option value="0">Select</option>
				            
				        <%
				         		if(rankList != null){ 	
				         			//for (Object[] masRank :rankList) {
				         				for (MasRank masRank :rankList) {
				         				
				         %>
						<%--  <option value="<%=(Integer)masRank[0]%>"><%=(String)masRank[1] %></option>     --%>  
						 <option value="<%=masRank.getId()%>"><%=masRank.getRankName() %></option> 
				        <%		
				        			}
				        		 } 
				        %>
			      </select>
			      
			
			      
			<label>Title <span>* </span> </label>
				<select id="titleId" name=<%=TITLE_ID %> validate="Title,int,yes" class="mediumm">
				<option value="0">Select</option>
				            
				        <%
				         		if(titleList != null){ 	
				         			for (Iterator iter = titleList.iterator(); iter.hasNext();) {
				         				MasTitle masTitle = (MasTitle) iter.next();
				         %>
						<option value="<%=masTitle.getId() %>"><%=masTitle.getTitleName() %></option>           
				        <%		
				        			}
				        		 } 
				        %>
			      </select>
	           
	         
           <%--  <label>First Name <span>* </span></label>
			<input type="text" id="firstName" name="<%=FIRST_NAME %>" value="" class="medium3" validate="First Name,name,yes"  MAXLENGTH="32"/>			
			
			<div class="clear"></div>
			
			<label>Middle Name</label>
			<input type="text" name="<%=MIDDLE_NAME%>" value="" class="medium3"  validate="Middle Name,name,no" MAXLENGTH="32" />
			
			
			 
			<label>Last Name <span>* </span></label>
			<input type="text" id="lastName" name="<%=LAST_NAME %>" value="" class="medium3"  validate="Last Name,name,yes" MAXLENGTH="32" /> --%>
			
			<label>Employee Name <span>* </span></label>
			<input type="text" id="empName" name="empName" value="" class="medium3" validate="Employee Name,string,yes"  MAXLENGTH="128"/>		
			
			<label>Religion</label>
			
			<select name="religion"   id="religion"  validate="Religion,int,no" class="mediumm">
			<option value="0">Select</option>
			<%for(MasReligion mr : masReligion) {%>
			<option value="<%=mr.getId() %>"><%=mr.getReligionName()%></option>
			<%} %>
			</select>

			<label>Caste</label>
			
			<select name="caste"   id="caste"  validate="caste,int,no" class="mediumm">
			<option value="0">Select</option>
			<%for(MasEmployeeCaste mec : masEmployeeCaste) {%>
			<option value="<%=mec.getId() %>"><%=mec.getCasteName() %></option>
			<%} %>
			</select>
			
			<label>Sub Caste</label>
			
			<select name="subCaste"   id="subCaste"  validate="subCaste,int,no" class="mediumm">
			<option value="0">Select</option>
			<%for(MasEmployeeSubCaste mesc : masEmployeeSubCaste) {%>
			<option value="<%=mesc.getId() %>"><%=mesc.getSubCasteName() %></option>
			<%} %>
			</select>
			
<div class="clear"></div>
			          
		  <label>Category</label>
		 <select name="category"   id="category"  validate="Category,int,no" class="mediumm">
			<option value="0">Select</option>
			<%-- <%for(MasCategory mc : masCategory) {%>
			<option value="<%=mc.getId() %>"><%=mc.getCategoryName() %></option>
			<%} %> --%>
			
			<%for (MasEmpCategory empCategory : empCategoryList) {%>
						 		<option value="<%=empCategory.getId() %>"><%=empCategory.getEmpCategoryName()%></option>
						<%} %>
			</select>
	
			  <div id="test">		 
            <label>Department <span>* </span> </label>
				  <select id="departmentId" name=<%=DEPARTMENT_ID %> validate="Department,string,yes" class="mediumm">
					 <option value="0">Select</option>
			              
			          <%
			           		if(departmentList != null){ 	
			           			for (Iterator iter = departmentList.iterator(); iter.hasNext();) {
			           				MasDepartment masDepartment = (MasDepartment) iter.next();
			           %>
							<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>           
			          <%		
			          			}
			          		 } 
			          %>
	            </select>
	            </div>
	           	
		 
		 	<%-- <label>Location <span>* </span></label>
		 	<select name="<%=LOCATION%>" id="<%=LOCATION%>"  validate="Location,int,yes">
		 	<option value="0">
		 	Select
		 	</option>
		 	
		 	<% for(MasLocation location : locationList){ %>
		 	<option value="<%=location.getId() %>"><%=location.getLocationName()%> </option>
		 	<%}%>
		 	</select> --%>
		 	
		 		<%--   <div class="clear"></div>
		 		<label><span>* </span>Holiday as Per</label>
		 	<select name="holidayAsPer" id="holidayAsPer"  validate="holidayAsPer,int,yes">
		 	<option value="0">
		 	Select
		 	</option>
		 	
		 	<% for(MasLocation location : locationList){ %>
		 	<option value="<%=location.getId() %>"><%=location.getLocationName()%> </option>
		 	<%}%>
		 	</select>
		 	 --%>
		 
		 <!--  <div class="clear"></div>
		 	<label class="value">Set Line Manager</label>
		 	<input type="radio" id="setManager" name="setManager" value="m"  
			onclick="showHideLineManager(this)"  class="radioCheck" />  -->	
			
			
			<!--  <div id="divSetManager" style="display: none;">-->
			
			
			<label>District <span>* </span></label>
		 	<!--  <select name="hospitalIdEmp" id = "hospitalIdEmp" validate="Manager Organisation,int,yes" onchange="populateLineManager(this.value,'employee')" class="mediumm">-->
		 	<select name="joinOrganisation" id = "joinOrganisation" validate="Manager Organisation,int,yes" onchange="populateLineManager(this.value,'employee')" class="mediumm">
		 	<option value="0">Select</option>
		 	<% for(MasHospital masHospital : masHospitalList ){ %>
		 		<option value="<%=masHospital.getId() %>"><%=masHospital.getHospitalName()%></option>
		 	<%} %>
			</select>
			
			<div class="clear"></div>
			
			<label>Institute Type <span>* </span></label>
		 	<!--  <select name="hospitalIdEmp" id = "hospitalIdEmp" validate="Manager Organisation,int,yes" onchange="populateLineManager(this.value,'employee')" class="mediumm">-->
		 	<select name="joinOrganisation" id = "joinOrganisation" validate="Manager Organisation,int,yes" onchange="populateLineManager(this.value,'employee')" class="mediumm">
		 	<option value="0">Select</option>
		 	<% for(MasHospital masHospital : masHospitalList ){ %>
		 		<option value="<%=masHospital.getId() %>"><%=masHospital.getHospitalName()%></option>
		 	<%} %>
			</select>
			
			
			
		 	<label>Institute Name <span>* </span></label>
		 	<!--  <select name="hospitalIdEmp" id = "hospitalIdEmp" validate="Manager Organisation,int,yes" onchange="populateLineManager(this.value,'employee')" class="mediumm">-->
		 	<select name="joinOrganisation" id = "joinOrganisation" validate="Manager Organisation,int,yes" onchange="populateLineManager(this.value,'employee')" class="mediumm">
		 	<option value="0">Select</option>
		 	<% for(MasHospital masHospital : masHospitalList ){ %>
		 		<option value="<%=masHospital.getId() %>"><%=masHospital.getHospitalName()%></option>
		 	<%} %>
			</select>
							
			 <%-- 	<label>Controlling Manager</label>
			 	<select name="managerId" id="managerId" validate="Controlling Manager,int,no" class="mediumm">
				 	<option value="0">Select</option>
						<%for (MasEmployee emp : employeeList) {
						String Full_name=emp.getFirstName();
						if(emp.getLastName()!= null && !emp.getLastName().equals("") ){
							Full_name=Full_name+" "+emp.getLastName();
						}						
						
						%>
						 		<option value="<%=emp.getId() %>"><%=Full_name%></option>
						<%} %>
				</select> --%>
			<!--  </div>-->
			
			<script type="text/javascript">
		<%
		int count=0;
		for (MasHospital masHospital :masHospitalList) 
		{
		for (MasEmployee masEmployee :employeeList) 
		{
			if(masEmployee.getHospital() != null){
				if(masHospital.getId().equals(masEmployee.getHospital().getId())){
					String Full_name=masEmployee.getFirstName();
					if(masEmployee.getLastName()!= null && !masEmployee.getLastName().equals("") ){
						Full_name=Full_name+" "+masEmployee.getLastName();
					}
		%>
		lineManagerArr[<%=count%>] = new Array();
		lineManagerArr[<%=count%>][0] = <%=masHospital.getId()%>;
		lineManagerArr[<%=count%>][1] = <%=masEmployee.getId()%>;	
		<%-- 							
		lineManagerArr[<%=count%>][2] = "<%=masEmployee.getFirstName() +" "+masEmployee.getLastName()%>";
		--%>	
		lineManagerArr[<%=count%>][2] = "<%=Full_name%>";
		<%
		count++;
		}
		}
		}
		}
		%>
		
</script> 

<%--
			<label>Equivalent Designation</label>
			<input type="text" name="<%=EQUIVALENT_DESIGNATION %>" validate="Equivalent Designation,string,no"/>
			<div class="clear"></div>
			 --%>
			 		
			 		
			 		<label>Joining Date</label>
		    <input type="text" id="joinId" name="<%=JOIN_DATE%>" value="<%=dateCal+"/"+month+"/"+year%>" class="calDate" readonly="readonly" validate="Date Of Joining,date,no"  MAXLENGTH="30" /> 
			<%-- <img src="/erp/jsp/images/cal.gif" width="16" height="16" border="0" onClick="javascript:setdate('',document.employee.<%=JOIN_DATE%>,event)" validate="Pick a date" class="calender" /> --%> 
			<label>Emp Status  </label>
				 <select id="empStatusId" name=<%=EMP_STATUS_ID %> onchange="showFields(this)" class="mediumm">
						  	<option value="0">Select</option>
			              
			          <%
			           		if(empStatusList != null){ 	
			           			for (Iterator iter = empStatusList.iterator(); iter.hasNext();) {
			           				MasEmpStatus masEmpStatus = (MasEmpStatus) iter.next();
			           %>
							<option value="<%=masEmpStatus.getId() %>"><%=masEmpStatus.getEmpStatusName() %></option>           
			          <%		
			          			}
			          		 } 
			          %>
			      </select>
			      <div id="responseList">
					</div>
					
					<div class="clear"></div>
					
	           
			<div id="dateOfResig" style="display:none;">
			<label>Date of Resignation</label>
			<input type="text" id="<%=DATE_OF_RESIGNATION%>" name="<%=DATE_OF_RESIGNATION%>" value="" class="calDate" readonly="readonly" validate="Date Of Resignation,date,no"  MAXLENGTH="30" />
			<%-- <img src="/erp/jsp/images/cal.gif" width="16" height="16" border="0" onClick="javascript:setdate('',document.employee.<%=DATE_OF_RESIGNATION%>,event)" validate="Pick a date" class="calender" /> --%>
			
			<div class="clear"></div>
			</div>
			
			<div id="lwp" style="display:none;">
			<label>From Date</label>
			<input type="text" id="<%=DATE_OF_RESIGNATION%>" name="<%=DATE_OF_RESIGNATION%>" value="" class="calDate" readonly="readonly" validate="Date Of Resignation,date,no"  MAXLENGTH="30" />
			<%-- <img src="/erp/jsp/images/cal.gif" width="16" height="16" border="0" onClick="javascript:setdate('',document.employee.<%=DATE_OF_RESIGNATION%>,event)" validate="Pick a date" class="calender" /> --%>
			
			<div class="clear"></div>
			</div>
			
			<div id="lastWorkDay" style="display:none;">
			<!-- <label>Last Working Day</label>   -->
			<label>Relieving Date</label>
			<input type="text" id="<%=LAST_WORKING_DAY%>" name="<%=LAST_WORKING_DAY%>" value="" class="calDate" readonly="readonly" validate="Last Working Day,date,no"  MAXLENGTH="30" />
			<%-- <img src="/erp/jsp/images/cal.gif" width="16" height="16" border="0" onClick="javascript:setdate('',document.employee.<%=LAST_WORKING_DAY%>,event)" validate="Pick a date" class="calender" /> --%>
			<div class="clear"></div>
			</div>
			
		
		</div> <!-- div title1 ends -->
		
		<div class="clear"></div>
		<div class="division"></div>
		<a href="javascript:changeClass('title3','t3')"><h5 id='t3'>Employee Personal Details</h5></a>	
		<div class="clear"></div>
	  	 <div class="Block" id="title3"> 
    	  	
    	  	
			<label>Gender <span>* </span></label>
			<select name="<%=GENDER %>" validate="Gender,int,yes" class="mediumm">
			<option value="0">Select</option>
			<%for(MasAdministrativeSex gender : masAdministrativeSexList) {%>
			<option value="<%=gender.getId() %>"><%=gender.getAdministrativeSexName() %></option>
			<%} %>
			</select>
					
    	  	<label>Date Of Birth <span>* </span></label>
<%-- 			<input type="text" id="dateOfBirth" name="<%=DATE_OF_BIRTH%>" value=""  class="calDate"   onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');"/> --%>
			 
			<input type="text" id="dateOfBirth" name="<%=DATE_OF_BIRTH%>" validate="Date of birth,dobHRMS,yes" class="date" MAXLENGTH="30" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'td');"/> 
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%=DATE_OF_BIRTH%>',document.employee.<%=DATE_OF_BIRTH%>,true);" /> 
	
	
	
			
			<label>Passport Number</label>
			<input type="text" id="passportNumber" name="<%= PASSPORTNUMBER%>" value="" validate="Passport Number,string,no"  MAXLENGTH="8"/>
   	  	 	
   	  	 	<div class="clear"></div>
   	  	 	<!-- <label>Passport Issue Date</label> -->
			
			<input type="hidden" name="<%= PASSPORTISSUEDATE%>" id="passportIssueDate"  validate="Passport Issue Date,date,no" class="date" MAXLENGTH="30" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'td');"/> 
			<%-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%=PASSPORTISSUEDATE%>',document.employee.<%=PASSPORTISSUEDATE%>,true);" /> --%> 
			
		
			<!-- <label>Passport Expiry Date</label> -->
			
			<input type="hidden" name="<%= PASSPORTEXPIRYDATE%>" id="passportExpiryDate"  validate="Passport Expiry Date,date,no" class="date" MAXLENGTH="30" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'td');"/> 
			<%-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%=PASSPORTEXPIRYDATE%>',document.employee.<%=PASSPORTEXPIRYDATE%>,true);" /> --%> 
			
			
	<!-- 		<label>Passport Issue Place</label> -->
			<input type="hidden" name="<%= PASSPORTISSUEPLACE%>" value="" validate="Passport Issue Place,string,no"  MAXLENGTH="20"/>
			
			<div class="clear"></div>
			
			<%-- <label>Visa Details</label>
			<input type="text" name="<%= VISADETAILS%>" value="" validate="Visa Details,string,no"  MAXLENGTH="20"/> --%>
   	  	 
   	  	 	
			
			<%-- <label>Driving Licence No.</label>
			<input type="text" name="<%= DRIVING%>" value="" validate="Driving Licence,string,no"  MAXLENGTH="20"/> --%>
   	  	 	
   	  	 	<div class="clear"></div>
   	  	 	
   	  	 	
   	  	 	<label>Marital Status <span>* </span></label>
			<select name="<%=MARITAL_STATUS_ID %>" id="MARITAL_STATUS_ID"  validate="Marital Status,int,yes" onchange="disableMariageDate()" class="mediumm">
			<option value="">Select</option>
			
			<%for(MasMaritalStatus maritalStatus : maritalStatusList){ %>
			<option value="<%=maritalStatus.getId() %>"><%=maritalStatus.getMaritalStatusName() %></option>
			<%} %>
			
			</select>
   	  	 	
   	  	 	<div id="mrg" style="Display:block">
   	  	 	
   	  	 	<label>Marriage Date</label>
			<%-- <input type="text" id="<%=MARRIAGE_DATE %>"  onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" name="<%= MARRIAGE_DATE%>" value="" validate="Marriage Date,date,no"  class="calDate" /> --%>
			<input type="text" name="<%= MARRIAGE_DATE%>" id="<%=MARRIAGE_DATE %>"  validate="Marriage Date,date,no" class="date" MAXLENGTH="30" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'td');"/> 
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%=MARRIAGE_DATE%>',document.employee.<%=MARRIAGE_DATE%>,true);" /> 
			
			
			</div>
			
			<label>Father/Husband <span>* </span></label>
			<input type="text" name="fatherOrHusbandName" value="" validate="Father's/Husband's Name,string,yes"  MAXLENGTH="190"/>
			
   	  	 	<div class="clear"></div>
   	  	 	<label>PF No</label>
			<input type="text" name="<%= PFNO%>" value="" validate="PF No,string,no"  MAXLENGTH="25"/>
		
			
			
			<label>PAN No <span>* </span></label>
			<input type="text" name="<%= PANNO%>" id="panNO" value="" validate="PAN No,string,yes"  MAXLENGTH="10" onblur="chkPan(this.value);"/>
   			<div class="clear"></div>
		</div> 	 
   	  
  		
  		<div class="clear"></div>
		<div class="division"></div>
		<a href="javascript:changeClass('title4','t4')"><h5 id='t4'>Employee Bank Details</h5></a>	
		<div class="clear"></div>
	  	 <div class="Block" id="title4"> 
    	  	<label>Bank Name</label>
			<input type="text" name="<%= BANK_CODE%>" value="Axis Bank" validate="Bank Code,string,no" maxlength="25"/>

			<!-- <label>Bank A/C Code</label> -->
			<input type="hidden" name="<%= BANK_ACCOUNT_CODE%>" value="" validate="Bank Account Code,string,no" class="medium3" MAXLENGTH="10"/>
			
			<label>A/C Number</label>
			<input type="text" name="<%= BANK_ACCOUNT_NUMBER%>" value="" validate="Bank Account Number,string,no" class="medium3" MAXLENGTH="20"/>
   	  	 	
   	  	 	
   	  	 	
			<!-- <label>A/C Head</label> -->
			<input type="hidden" name="<%= ACCOUNT_HEAD%>" value="" validate="Account Head,name,no" class="medium3" MAXLENGTH="10"/>
			
			<label>IFSC Code</label>
			<input type="text" name="ifscCode" value="" validate="IFSC Code,string,no" class="medium3" MAXLENGTH="10"/>
			<div class="clear"></div>
			<label>Bank Branch</label>
			<input type="text" name="bankBranch" value="" validate="Bank Branch,string,no" class="medium3" MAXLENGTH="10"/>
			
			
   	  	 	 <%--
   	  	 	<label>Payment Mode</label>
			<input type="text" name="<%= PAY_MODE%>" value="" validate="Payment Mode No,string,no"  MAXLENGTH="45"/>
			 --%>
   	  	 	<div class="clear"></div>
   	  	 	
   	  	 	
   	  	 	
   	  	 	<div class="clear"></div>
				
				<input type="button" class="buttonNew"  value="Permanent" onclick="showAddressDivs('permanentAddDiv', 'temporaryAddDiv', 'aadharrAddDiv', this,'permanent')"/>
				<input type="button" class="buttonNew" value="Temporary" onclick="showAddressDivs('temporaryAddDiv', 'aadharrAddDiv', 'permanentAddDiv', this,'temporary')"/>
	<div class="clear"></div>		
		
	<div class="Block">
	<div class="clear"></div>	
		

		<div  id="permanentAddDiv" class="" style="display: none;">
		<input type="hidden" name="permAddr" value="" id="permAddr"/>
			<label>District</label><select name="P_DISTRICT" id="cityId"
				tabindex="22"
				onChange="if(fillNokAddr()){populateBlock(this.value,'registration')}">
			<option value="0">Select</option>	
				<%
		
		
		for(MasDistrict masDistrict : districtList)
		{
			%>
		
				<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
<%
		}
%>
			</select> <label>Taluk</label><select name="P_TALUK" id="talukId"
				tabindex="22" onChange="">
				<option value="0">Select</option>
				<% 	for(MasTaluk masTaluk:talukList){ %>
			
				<option value="<%=masTaluk.getId()%>"><%=masTaluk.getTalukName() %></option>
			<%}
				%>
			</select> <label>LSG Name</label><select name="P_LSG_NAME" id="lsgNameId"
				tabindex="">
				<option value="0">Select</option>
				<% for(MasLsg masLsg:lsgNameList){ %>
				<option value="<%=masLsg.getId()%>"><%=masLsg.getLsgTypeName() %></option>
					
			<%	}
			
				%>
				
			</select>
			<div class="clear"></div>
			<label>Ward</label><input type="text" name="P_WARD" value=""
				validate="" maxlength="8" tabindex="" id="wardId"
				onblur="" /> <label>Locality</label><select name="P_LOCALITY"
				id="locality" tabindex="">
				<option value="0">Select</option>
				<% for(PhMasLocalityType locality:localityList ){ %>
				<option value="<%=locality.getId()%>"><%=locality.getLocalityDescription() %></option>
					
				<%}
		
				%>
			</select> <label>LSG House No.</label><input type="text"
				name="P_LSG_HOUSE_NO" value="" validate=""
				maxlength="8" />
			<div class="clear"></div>
			<label>Colony House No.</label><input type="text"
				name="P_HOUSE_NO" value="" validate=""
				maxlength="8" tabindex="" id="houseId" onblur="" />
			 <label>Post Office</label>
			 <select name="P_POST_OFFICE" id="postOff"
				onchange="populateVillage(this.value);"
				validate="" tabindex="">
				<option value="0">Select</option>
			
				<% for (MasPostCode masPostOff:postCodeList ){ %>
					<option value="<%=masPostOff.getId()%>"><%=masPostOff.getPostCodeName() %></option>
				<% 
				}
			%>
				
			</select>
			 <label>Pin Code</label><input type="text" id="pincode"
				name="P_PINCODE" value="" tabindex=""
				validate="" MAXLENGTH="15" />
			<div class="clear"></div>
			<label>Health House Id</label><input type="text" id="healthHouseId"
				name="P_HEALTH_HOUSE_ID" value="" tabindex=""
				validate="" MAXLENGTH="15" />
		</div>
		<div id="temporaryAddDiv" class="" style="display: none;">
		<input type="hidden" name="pTempAddr" value="" id="pTempAddr"/>
			<label>District</label><select name="T_DISTRICT" id="cityId"
				tabindex="22"
				onChange="if(fillNokAddr()){populateBlock(this.value,'registration')}">
			<option value="0">Select</option>	
				<%
		
		for(MasDistrict masDistrict : districtList)
		{
			%>
		
				<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
<%
		}
%>
			</select> <label>Taluk</label><select name="T_TALUK" id="talukId"
				tabindex="22" onChange="">
				<option value="0">Select</option>
				<% 	for(MasTaluk masTaluk:talukList){ %>
			
				<option value="<%=masTaluk.getId()%>"><%=masTaluk.getTalukName() %></option>
			<%}
				%>
			</select> <label>LSG Name</label><select name="T_LSG_NAME" id="lsgNameId"
				tabindex="">
				<option value="0">Select</option>
				<% for(MasLsg masLsg:lsgNameList){ %>
				<option value="<%=masLsg.getId()%>"><%=masLsg.getLsgTypeName() %></option>
					
			<%	}
			
				%>
			</select>
			<div class="clear"></div>
			<label>Ward</label><input type="text" name="T_WARD" value=""
				validate="" maxlength="8" tabindex="" id="wardId"
				onblur="" /> <label>Locality</label><select name="T_LOCALITY"
				id="locality" tabindex="">
				<option value="0">Select</option>
				<% for(PhMasLocalityType locality:localityList ){ %>
				<option value="<%=locality.getId()%>"><%=locality.getLocalityDescription() %></option>
					
				<%}
		
				%>
			</select> <label>LSG House No.</label><input type="text"
				name="T_LSG_HOUSE_NO" value="" validate=""
				maxlength="8" />
			<div class="clear"></div>
			<label>Colony House No.</label><input type="text"
				name="T_HOUSE_NO" value="" validate=""
				maxlength="8" tabindex="" id="houseId" onblur="" /> 
				<label>Post	Office</label>
				<select name="P_POST_OFFICE" id="postOff"
				onchange="populateVillage(this.value);"
				validate="" tabindex="">
				<option value="0">Select</option>
			
				<% for (MasPostCode masPostOff:postCodeList ){ %>
					<option value="<%=masPostOff.getId()%>"><%=masPostOff.getPostCodeName() %></option>
				<% 
				}
			%>
				
			</select>
			<label>Pin Code</label><input type="text" id="pincode"
				name="T_PINCODE" value="" tabindex=""
				validate="" MAXLENGTH="15" />
			<div class="clear"></div>
			
		</div>
	</div>
	<div class="clear"></div>
	<div class="division"></div>
   	  	 	
   	  	 	
   	  	 	
   	 	</div> 	 
		<div class="clear"></div>
		<div class="division"></div>
		<a href="javascript:changeClass('title5','t5')"><h5 id='t5'>Employee Contact Details</h5></a>	
		<div class="clear"></div>
			<div class="clear"></div>
	  	 <div class="Block" id="title5"> 
	    	<label>Permanent Address</label>
	    	<textarea id="<%=EMPLOYEE_PERMANENT_ADDRESS %>" name="<%=EMPLOYEE_PERMANENT_ADDRESS%>" validate="Permanent Address,'',no" id="permanentAddress" onkeydown="refreshLength1(this.id,250)" onkeyup="refreshLength(this.id,250)" onblur="removeNewLine(this)" maxlength="200"></textarea>
	    	
	    	<label>Residential Address</label>
	    	<textarea id="<%=EMPLOYEE_RESIDENTIAL_ADDRESS%>" name="<%=EMPLOYEE_RESIDENTIAL_ADDRESS%>" validate="Residential Address,'',no" id="residentialAddress" onkeydown="refreshLength1(this.id,250)" onkeyup="refreshLength(this.id,250)"  onblur="removeNewLine(this)" maxlength="200"></textarea>
	    	
	    	<label>Mobile</label>
			<input type="text" id='mobile' name="<%= EMERGENCY_MOBILE%>" value="" validate="Mobile,alphanumeric,no" class="medium3" MAXLENGTH="12" />
			
			<div class="clear"></div>
			
			<label>Office Phone</label>
			<input type="text" id='officePhone' name="<%= TELL_NO_OFFICE%>" value="" validate="Office Phone,alphanumeric,no"  MAXLENGTH=12 />
			
			<label>Resi. Phone</label>
			<input type="text" name="<%= TELL_NO_RESIDENCE %>" value="" validate="Residence Phone,alphanumeric,no" class="medium3" MAXLENGTH="12" />
			
			<label>Email Id</label>
			<input type="text" id="emailId" name="<%= EMAIL %>"  validate="email Id,email,no"  value="" class="medium3" MAXLENGTH="30" />			
		    
			<div class="clear"></div>
			
		<%-- 	<label>Emp Url</label>
			<input type="text" name="<%= URL%>" value="" validate="Employee Url,string,no" class="medium3" MAXLENGTH="30" onkeypress="return submitenter(this,event,'personnel?method=addEmployee')" />
			 --%>
		</div>		 
			
			<div class="clear"></div>
			<div class="division"></div>
			<a href="javascript:changeClass('title6','t6')"><h5 id='t6'>Employee Education Details</h5></a>
			<div class="clear"></div>	
			<div class="Block" id="title6"> 
		
			<div class="clear"></div>
		
			<ul id="countrytabs" class="shadetabs">
			<li><a href="#" rel="country1" class="selected">Education1</a></li>
			<li><a href="#" rel="country2">Education2</a></li>
			<li><a href="#" rel="country3">Education3</a></li>
			<li><a href="#" rel="country4">Education4</a></li>
			<li><a href="#" rel="country5">Education5</a></li>
			</ul>
			
			<div class="tabcontainer">
			
			<!-- Education 1 starts  -->
			<div id="country1" class="tabcontent">
			
			<label>Highest Qualification</label> 
			<select id="qualification" name="<%= QUALIFICATION+"1" %>"	 validate="Education1:Qualification,string,no" tabindex=1 class="mediumm">
			<option value="0">Select</option>
			<%
			for (HrMasQualification qualification : qualificationList) {
			%>

			<option value="<%=qualification.getId ()%>"><%=qualification.getQualificationName()%></option>

			<%
			}
			%>
			</select> 
	 
	 		<label>Courses Name</label>
			<select class="mediumm" id="coursesName" name="<%= COURSES_NAME+"1" %>"	validate="Education1:Courses Name,string,no" tabindex=1>
			<option value="0">Select</option>
			<%
			for (HrMasCourse course : coursesList) {
			%>

			<option value="<%=course.getId ()%>"><%=course.getCourseName()%></option>

			<%
			}
			%>
			</select> 
			
			<%--
			// ye coomnet tha pehle se hi
			<label>Spl Qualification</label>
			<select id="splQualification" name="<%= SPL_QUALIFICATION+"1"%>"	validate="Education1:Spl Qualification,string,no" tabindex=1>
			<option value="0">Select</option>
			<%
			for (HrMasSpecialQualification splQualifictaion : splQualificationList) {
			%>

			<option value="<%=splQualifictaion.getId ()%>"><%=splQualifictaion.getSpecialQualificationName()%></option>

			<%
			}
			%>
			</select>  --%> 
			<label>Any Certification</label>
			<input type="text"  id="splQualification" name="<%= SPL_QUALIFICATION+"1"%>"	validate="Education1:Spl Qualification,string,no" tabindex=1 />
			
  	  	   	<div class="clear"></div>
			<label>Institute</label>
			<select class="mediumm" name="<%= INSTITUTION+"1"%>" validate="Education1:Institute,string,no" tabindex=1>
			<option value="0">Select</option>
			<%for (HrMasInstitute institute : institutesList) {%>
				<option value="<%=institute.getId ()%>"><%=institute.getInstituteName()%></option>
			<%}%>
			</select> 
 			<label>Start Date</label>
			<%-- <input type="text"	name="<%=START_DATE+"1"%>" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');"  value=""	validate="Education1:Start Date,string,no" class="calDate" > --%> 
			
            <input type="text"  name="<%=START_DATE+"1"%>" validate="Education1:Start Date,string,no"  class="date" MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'td');"/> 
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%=START_DATE+"1"%>',document.employee.<%=START_DATE+"1"%>,true);" />
			
			<label>End Date</label>
			<%-- <input type="text"	name="<%= END_DATE+"1"%>" value="" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" 	validate="Education1:End Date,string,no"  class="calDate"> --%>
			<input type="text"  name="<%= END_DATE+"1"%>" validate="Education1:End Date,string,no"  class="date" MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'td');"/> 
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%= END_DATE+"1"%>',document.employee.<%= END_DATE+"1"%>,true);" />
			
			
			<div class="clear"></div>
			
			<label>Course Duration   (in months)</label>
			<input type="text"	id="duration" name="<%= COURSES_DURATION+"1" %>" value=""	validate="Education1:Course Duration,int,no" class="medium3" MAXLENGTH="30" tabindex=1 onkeypress="return submitenter(this,event,'personnel?method=addEmployeeDependent')">
			
			<label>Qualified Date</label>
			<%-- <input type="text" id="qualified_date" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" 	class="calDate" name="<%= QUALIFIED_DATE+"1" %>" value=""	validate="Education1:Qualified Date,date,no" class="medium3" MAXLENGTH="30" tabindex=1 onkeypress="return submitenter(this,event,'personnel?method=addEmployeeDependent')"> --%>
			<input type="text"  id="qualified_date"  name="<%= QUALIFIED_DATE+"1" %>" validate="Education1:Qualified Date,date,no"  class="date" MAXLENGTH="10" onkeypress="return submitenter(this,event,'personnel?method=addEmployeeDependent')" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'td');" tabindex=1 /> 
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%= QUALIFIED_DATE+"1" %>',document.employee.<%= QUALIFIED_DATE+"1" %>,true);" />
			
			
			<label>Awards</label>
			<input type="text" class="medium3" name="<%=AWARDS+"1"%>" validate="Education1:Awards,'string',no" maxlength="45" />
			
			<div class="clear"></div>
			
			<label>Skills</label>
			<input type="text" name="<%=EDUCATION_SKILLS+"1"%>" size="6" validate="Education1:Skills,string,no" class="large">
			<div class="clear"></div>
		
			</div>
			<!-- Education 2 -->
			<div id="country2" class="tabcontent">
			
			<label>Highest Qualification</label> 
			<select class="mediumm" id="qualification" name="<%= QUALIFICATION+"2" %>"	 validate="Education2:Qualification,string,no" tabindex=1>
			<option value="0">Select</option>
			<%for (HrMasQualification qualification : qualificationList) {%>
				<option value="<%=qualification.getId ()%>"><%=qualification.getQualificationName()%></option>
			<%}%>
			</select> 
	 		<label>Courses Name</label>
			<select id="coursesName" name="<%= COURSES_NAME+"2" %>"	validate="Education2:Courses Name,string,no" tabindex=1 class="mediumm">
			<option value="0">Select</option>
			<%for (HrMasCourse course : coursesList) {%>
				<option value="<%=course.getId ()%>"><%=course.getCourseName()%></option>
			<%}%>
			</select> 
			<%--  // ye coomnet tha pehle se hi
			<label>Spl Qualification</label>
			<select id="splQualification" name="<%= SPL_QUALIFICATION+"2"%>"	validate="Education2:Spl Qualification,string,no" tabindex=1>
			<option value="0">Select</option>
			<%for (HrMasSpecialQualification splQualifictaion : splQualificationList) {%>
				<option value="<%=splQualifictaion.getId ()%>"><%=splQualifictaion.getSpecialQualificationName()%></option>
			<%}%>
			</select>  --%>
			
			<label>Any Certification</label>
			<input type="text"  id="splQualification" name="<%= SPL_QUALIFICATION+"2"%>"	validate="Education2:Spl Qualification,string,no" tabindex=1 />
			
  	  	   	<div class="clear"></div>
			<label>Institute</label>
			<select name="<%= INSTITUTION+"2"%>"	validate="Education2:Institute,string,no" tabindex=1 class="mediumm">
			<option value="0">Select</option>
			<%for (HrMasInstitute institute : institutesList) {%>
				<option value="<%=institute.getId ()%>"><%=institute.getInstituteName()%></option>
			<%}%>
			</select> 
 			<label>Start Date</label>
			<%-- <input type="text"	name="<%=START_DATE+"2"%>" value=""	onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Education2:Start Date,string,no" class="calDate" > --%> 
			<input type="text"  name="<%=START_DATE+"2"%>" validate="Education2:Start Date,string,no"  class="date" MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'td');"/> 
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%=START_DATE+"2"%>',document.employee.<%=START_DATE+"2"%>,true);" />
			
			<label>End Date</label>
			<%-- <input type="text"	name="<%= END_DATE+"2"%>" value="" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Education2:End Date,string,no"  class="calDate"> --%>
			<input type="text"  name="<%= END_DATE+"2"%>" validate="Education2:End Date,string,no"  class="date" MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'td');"/> 
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%= END_DATE+"2"%>',document.employee.<%= END_DATE+"2"%>,true);" />
			<div class="clear"></div>
			<label>Course Duration   (in months)</label>
			<input type="text"	id="duration" name="<%= COURSES_DURATION+"2" %>" value=""	validate="Education2:Course Duration,int,no"  MAXLENGTH="30" tabindex=1 onkeypress="return submitenter(this,event,'personnel?method=addEmployeeDependent')">
			<label>Qualified Date</label>
			<%-- <input type="text" id="qualified_date" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" class="calDate" name="<%= QUALIFIED_DATE+"2" %>" value=""	validate="Education2:Qualified Date,date,no" class="medium3" MAXLENGTH="30" tabindex=1 onkeypress="return submitenter(this,event,'personnel?method=addEmployeeDependent')"> --%>
			<input type="text"  id="qualified_date"  name="<%= QUALIFIED_DATE+"2" %>" validate="Education2:Qualified Date,date,no"   class="date" MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'td');" tabindex=1 onkeypress="return submitenter(this,event,'personnel?method=addEmployeeDependent')" /> 
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%= QUALIFIED_DATE+"2" %>',document.employee.<%= QUALIFIED_DATE+"2" %>,true);" />
			
			<label>Awards</label>
			<input type="text" class="medium3" name="<%=AWARDS+"2"%>" validate="Education2:Awards,'string',no" />
			<div class="clear"></div>
			<label>Skills</label>
			<input type="text" name="<%=EDUCATION_SKILLS+"2"%>" size="6" validate="Education2:Skills,string,no" class="large">
			<div class="clear"></div>
			</div><!-- education2 ends -->
			
			<div id="country3" class="tabcontent">
			<label>Highest Qualification</label> 
			<select class="mediumm" id="qualification" name="<%= QUALIFICATION+"3" %>"	 validate="Education3:Qualification,string,no" tabindex=1>
			<option value="0">Select</option>
			<%for (HrMasQualification qualification : qualificationList) {%>
			<option value="<%=qualification.getId ()%>"><%=qualification.getQualificationName()%></option>
			<%}%>
			</select> 
	 		<label>Courses Name</label>
			<select class="mediumm" id="coursesName" name="<%= COURSES_NAME+"3" %>"	validate="Education3:Courses Name,string,no" tabindex=1>
			<option value="0">Select</option>
			<%for (HrMasCourse course : coursesList) {%>
			<option value="<%=course.getId ()%>"><%=course.getCourseName()%></option>
			<%}%>
			</select> 
			<%-- // ye coomnet tha pehle se hi
			<label>Spl Qualification</label>
			<select id="splQualification" name="<%= SPL_QUALIFICATION+"3"%>"	validate="Education3:Spl Qualification,string,no" tabindex=1>
			<option value="0">Select</option>
			<%for (HrMasSpecialQualification splQualifictaion : splQualificationList) {%>
			<option value="<%=splQualifictaion.getId ()%>"><%=splQualifictaion.getSpecialQualificationName()%></option>
			<%}%>
			</select> --%>			
			
			<label>Any Certification</label>
			<input type="text"  id="splQualification" name="<%= SPL_QUALIFICATION+"3"%>"	validate="Education3:Spl Qualification,string,no" tabindex=1 />
			
  	  	   	<div class="clear"></div>
			<label>Institute</label>
			<select class="mediumm" name="<%= INSTITUTION+"3" %>"	validate="Education3:Institute,string,no" tabindex=1>
			<option value="0">Select</option>
			<%for (HrMasInstitute institute : institutesList) {%>
			<option value="<%=institute.getId ()%>"><%=institute.getInstituteName()%></option>
			<%}%>
			</select> 
 			<label>Start Date</label>
			<%-- <input type="text"	name="<%=START_DATE+"3"%>" value=""	onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Education3:Start Date,string,no" class="calDate" /> --%> 
			<input type="text"  name="<%=START_DATE+"3"%>" validate="Education3:Start Date,string,no"  class="date" MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'td');"/> 
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%=START_DATE+"3"%>',document.employee.<%=START_DATE+"3"%>,true);" />
			<label>End Date</label>
			<%-- <input type="text"	name="<%= END_DATE+"3"%>" value="" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="End Date,string,no"  class="calDate" /> --%>
			<input type="text"  name="<%= END_DATE+"3"%>" validate="Education3:End Date,string,no"  class="date" MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'td');"/> 
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%= END_DATE+"3"%>',document.employee.<%= END_DATE+"3"%>,true);" />
			<div class="clear"></div>
			<label>Course Duration   (in months)</label>
			<input type="text"	id="duration" name="<%= COURSES_DURATION+"3" %>" value="" validate="Education3:Course Duration,int,no" class="medium3" MAXLENGTH="30" tabindex=1 onkeypress="return submitenter(this,event,'personnel?method=addEmployeeDependent')">
			<label>Qualified Date</label>
			<%-- <input type="text" id="qualified_date"	class="calDate"  name="<%= QUALIFIED_DATE+"3" %>" value=""	validate="Education3:Qualified Date,date,no"  onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" tabindex=1 onkeypress="return submitenter(this,event,'personnel?method=addEmployeeDependent')"> --%>
			<input type="text"  id="qualified_date"  name="<%= QUALIFIED_DATE+"3" %>" validate="Education3:Qualified Date,date,no"   class="date" MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'td');" tabindex=1 onkeypress="return submitenter(this,event,'personnel?method=addEmployeeDependent')" /> 
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%= QUALIFIED_DATE+"3" %>',document.employee.<%= QUALIFIED_DATE+"3" %>,true);" />
			
			<label>Awards</label>
			<input type="text" class="medium3" name="<%=AWARDS+"3"%>" validate="Education3:Awards,string,no" />
			<div class="clear"></div>
			<label>Skills</label>
			<input type="text" name="<%=EDUCATION_SKILLS+"3"%>" size="6" validate="Primary Skills,string,no" class="large">
			<div class="clear"></div>
			</div><!-- education3 ends -->
			
			<div id="country4" class="tabcontent">
			<label>Highest Qualification</label> 
			<select id="qualification" name="<%= QUALIFICATION+"4" %>"	 validate="Education4:Qualification,string,no" tabindex=1 class="mediumm">
			<option value="0">Select</option>
			<%for (HrMasQualification qualification : qualificationList) {%>
			<option value="<%=qualification.getId ()%>"><%=qualification.getQualificationName()%></option>
			<%}%>
			</select> 
	 		<label>Courses Name</label>
			<select class="mediumm" id="coursesName" name="<%= COURSES_NAME+"4" %>"	validate="Education4:Courses Name,string,no" tabindex=1>
			<option value="0">Select</option>
			<%for (HrMasCourse course : coursesList) {%>
			<option value="<%=course.getId ()%>"><%=course.getCourseName()%></option>
			<%}%>
			</select> 
			<%-- // ye coomnet tha pehle se hi
			<label>Spl Qualification</label>
			<select id="splQualification" name="<%= SPL_QUALIFICATION+"3"%>"	validate="Education3:Spl Qualification,string,no" tabindex=1>
			<option value="0">Select</option>
			<%for (HrMasSpecialQualification splQualifictaion : splQualificationList) {%>
			<option value="<%=splQualifictaion.getId ()%>"><%=splQualifictaion.getSpecialQualificationName()%></option>
			<%}%>
			</select> --%>			
			
			<label>Any Certification</label>
			<input type="text"  id="splQualification" name="<%= SPL_QUALIFICATION+"4"%>"	validate="Education4:Spl Qualification,string,no" tabindex=1 />
			
  	  	   	<div class="clear"></div>
			<label>Institute</label>
			<select name="<%= INSTITUTION+"4" %>"	class="mediumm" validate="Education4:Institute,string,no" tabindex=1>
			<option value="0">Select</option>
			<%for (HrMasInstitute institute : institutesList) {%>
			<option value="<%=institute.getId ()%>"><%=institute.getInstituteName()%></option>
			<%}%>
			</select> 
 			<label>Start Date</label>
			<%-- <input type="text"	name="<%=START_DATE+"4"%>" value=""	onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Education4:Start Date,string,no" class="calDate" > --%> 
			<input type="text"  name="<%=START_DATE+"4"%>" validate="Education4:Start Date,string,no"  class="date" MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'td');"/> 
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%=START_DATE+"4"%>',document.employee.<%=START_DATE+"4"%>,true);" />
			<label>End Date</label>
			<%-- <input type="text"	name="<%= END_DATE+"4"%>" value="" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="End Date,string,no"  class="calDate"> --%>
			<input type="text"  name="<%= END_DATE+"4"%>" validate="Education4:End Date,string,no"  class="date" MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'td');"/> 
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%= END_DATE+"4"%>',document.employee.<%= END_DATE+"4"%>,true);" />
			<div class="clear"></div>
			<label>Course Duration   (in months)</label>
			<input type="text"	id="duration" name="<%= COURSES_DURATION+"4" %>" value="" validate="Education4:Course Duration,int,no" class="medium3" MAXLENGTH="30" tabindex=1 onkeypress="return submitenter(this,event,'personnel?method=addEmployeeDependent')">
			<label>Qualified Date</label>
			<%-- <input type="text" id="qualified_date"	class="calDate"  name="<%= QUALIFIED_DATE+"4" %>" value=""	validate="Education4:Qualified Date,date,no"  onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" tabindex=1 onkeypress="return submitenter(this,event,'personnel?method=addEmployeeDependent')"> --%>
			<input type="text"  id="qualified_date"  name="<%= QUALIFIED_DATE+"4" %>" validate="Education4:Qualified Date,date,no"   class="date" MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'td');" tabindex=1 onkeypress="return submitenter(this,event,'personnel?method=addEmployeeDependent')" /> 
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%= QUALIFIED_DATE+"4"%>',document.employee.<%= QUALIFIED_DATE+"4" %>,true);" />
			
			<label>Awards</label>
			<input type="text" class="medium3" name="<%=AWARDS+"4"%>" validate="Education4:Awards,string,no" />
			<div class="clear"></div>
			<label>Skills</label>
			<input type="text" name="<%=EDUCATION_SKILLS+"4"%>" size="6" validate="Primary Skills,string,no" class="large">
			<div class="clear"></div>
			</div><!-- education4 ends -->
			
			
			<div id="country5" class="tabcontent">
			<label>Highest Qualification</label> 
			<select id="qualification" name="<%= QUALIFICATION+"5" %>" class="mediumm"	 validate="Education5:Qualification,string,no" tabindex=1>
			<option value="0">Select</option>
			<%for (HrMasQualification qualification : qualificationList) {%>
			<option value="<%=qualification.getId ()%>"><%=qualification.getQualificationName()%></option>
			<%}%>
			</select> 
	 		<label>Courses Name</label>
			<select id="coursesName" name="<%= COURSES_NAME+"5" %>"	validate="Education5:Courses Name,string,no" tabindex=1 class="mediumm">
			<option value="0">Select</option>
			<%for (HrMasCourse course : coursesList) {%>
			<option value="<%=course.getId ()%>"><%=course.getCourseName()%></option>
			<%}%>
			</select> 
			<%-- // ye coomnet tha pehle se hi
			<label>Spl Qualification</label>
			<select id="splQualification" name="<%= SPL_QUALIFICATION+"3"%>"	validate="Education3:Spl Qualification,string,no" tabindex=1>
			<option value="0">Select</option>
			<%for (HrMasSpecialQualification splQualifictaion : splQualificationList) {%>
			<option value="<%=splQualifictaion.getId ()%>"><%=splQualifictaion.getSpecialQualificationName()%></option>
			<%}%>
			</select> --%>			
			
			<label>Any Certification</label>
			<input type="text"  id="splQualification" name="<%= SPL_QUALIFICATION+"5"%>"	validate="Education5:Spl Qualification,string,no" tabindex=1 />
			
  	  	   	<div class="clear"></div>
			<label>Institute</label>
			<select name="<%= INSTITUTION+"5" %>" class="mediumm" validate="Education5:Institute,string,no" tabindex=1>
			<option value="0">Select</option>
			<%for (HrMasInstitute institute : institutesList) {%>
			<option value="<%=institute.getId ()%>"><%=institute.getInstituteName()%></option>
			<%}%>
			</select> 
 			<label>Start Date</label>
			<%-- <input type="text"	name="<%=START_DATE+"5"%>" value=""	onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Education5:Start Date,string,no" class="calDate" > --%> 
			<input type="text"  name="<%=START_DATE+"5"%>" validate="Education5:Start Date,string,no"  class="date" MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'td');"/> 
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%=START_DATE+"5"%>',document.employee.<%=START_DATE+"5"%>,true);" />
			<label>End Date</label>
			<%-- <input type="text"	name="<%= END_DATE+"5"%>" value="" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="End Date,string,no"  class="calDate"> --%>			
			<input type="text"  name="<%= END_DATE+"5"%>" validate="Education5:End Date,string,no"  class="date" MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'td');"/> 
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%= END_DATE+"5"%>',document.employee.<%= END_DATE+"5"%>,true);" />
			<div class="clear"></div>
			<label>Course Duration   (in months)</label>
			<input type="text"	id="duration" name="<%= COURSES_DURATION+"5" %>" value="" validate="Education5:Course Duration,int,no" class="medium3" MAXLENGTH="30" tabindex=1 onkeypress="return submitenter(this,event,'personnel?method=addEmployeeDependent')">
			<label>Qualified Date</label>
			<%-- <input type="text" id="qualified_date"	class="calDate" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" name="<%= QUALIFIED_DATE+"5" %>" value=""	validate="Education5:Qualified Date,date,no" class="medium3" tabindex=1 onkeypress="return submitenter(this,event,'personnel?method=addEmployeeDependent')"> --%>
			<input type="text"  id="qualified_date"  name="<%= QUALIFIED_DATE+"5" %>" validate="Education5:Qualified Date,date,no"   class="date" MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'td');" tabindex=1 onkeypress="return submitenter(this,event,'personnel?method=addEmployeeDependent')" /> 
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%= QUALIFIED_DATE+"5"%>',document.employee.<%= QUALIFIED_DATE+"5" %>,true);" />
			
			<label>Awards</label>
			<input type="text" class="medium3" name="<%=AWARDS+"5"%>" validate="Education5:Awards,string,no" />
			<div class="clear"></div>
			<label>Skills</label>
			<input type="text" name="<%=EDUCATION_SKILLS+"5"%>" size="6" validate="Primary Skills,string,no" class="large">
			<div class="clear"></div>
			</div><!-- education5 ends -->
			
			</div><!-- tabcontainr ends -->

		</div>
		
<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script> 
		<div class="clear"></div>
			<div class="division"></div>
			<a href="javascript:changeClass('title7','t7')"><h5 id='t7'>Employee Experience</h5></a>
			<div class="clear"></div>
			<div class="Block" id="title7"> 
			
			<div class="clear"></div>
			<ul id="countrytabs1" class="shadetabs">
			<li><a href="#" rel="country6" class="selected">Experience1</a></li>
			<li><a href="#" rel="country7">Experience2</a></li>
			<li><a href="#" rel="country8">Experience3</a></li>
			<li><a href="#" rel="country9">Experience4</a></li>
			<li><a href="#" rel="country10">Experience5</a></li>
					
			</ul>
			<div class="clear"></div>
			<div class="tabcontainer">
			<div id="country6" class="tabcontent">
		 
			<label>Service Start date</label>
			
			<input type="text" id="expserviceStartDate1"  name="<%=SERVICE_START_DATE+"1"%>"   class="date" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Service Start Date 1 ,date,no"   MAXLENGTH="30" />
			 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onClick="javascript:setdate('',document.employee.<%=SERVICE_START_DATE+"1"%>,event)" validate="Pick a date" class="calender" /> 
	 		
	 		<label>Service End Date</label>
			
			 <input type="text" id="SERVICE_END_DATE1"  name="<%=SERVICE_END_DATE+"1"%>" class="date" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Service End Date,date,no"   MAXLENGTH="30" />
			 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onClick="javascript:setdate('',document.employee.<%=SERVICE_END_DATE+"1"%>,event)" validate="Pick a date" class="calender" />
									
			<label>Experience</label>
			<select name="<%=YEARS+"1"%>" validate="Experience in Years 1,string,no"  class="smallest">
				<option value="">--</option>
			<%	for(int i=0;i<=30;i++){%>
				<option value="<%=i%>"><%=i%></option>
			<%}%>
			<option value="31">+30</option>
			</select>
			<label class="smallAuto">Yrs</label>

			<select name="<%=MONTHS+"1"%>" validate="Experience in Months 1 ,string,no" class="smallest" >
			<option value="">--</option>
			<option value="0">--</option>
			<%for(int i=1;i<=11;i++){%>
			<option value="<%=i%>"><%=i%></option>
			<%}%>
			</select>
			<label class="smallAuto">Months</label>
			<div class="clear"></div>
			
			<label>Previous Employer</label>
			<input type="text" name="<%=PREVIOUS_EMPLOYER+"1"%>" value=""  validate="Previous Employer 1,String,no"  MAXLENGTH="30" />
			
			<label>Designation</label>
			<input type="text" id="designation" name="<%=DESIGNATION+"1"%>" value=""  validate="Designation 1,String,no"  MAXLENGTH="30" />			
			
			<label>Awards</label>
			<input type="text" name="<%=EX_AWARDS+"1"%>" value=""  validate="Awards 1,String,no"  MAXLENGTH="200" />	 
			
  	  	   	<div class="clear"></div>
  	  	   	
			<label>Previous Service End Reason</label>
			<input type="text" id="previousEmployer" name="<%=PREVIOUS_SERVICE_END_REASON+"1"%>" value=""  validate="Previous Service End Reason1 ,String,no"  MAXLENGTH="30" />
			
			<label>Phone No.</label>
			<input type="text" name="<%=EMPLOYER_PHONE_NO+"1"%>" value=""  validate="Employer phone no. 1 ,String,no"  MAXLENGTH="30" />
			
			<label>Address</label>
			<textarea name="<%= EMPLOYER_ADDRESS+"1"%>" validate="Address 1 , string,no" id="employerAddress" onkeydown="refreshLengthWithoutMeter1(this.id,250)" onkeyup="refreshLengthWithoutMeter(this.id,250)"></textarea> 
			<div class="clear"></div>
			
			<div class="clear"></div>
 			<label>Skills</label>
 			<input type="hidden" name="<%=EXPERIENCE_SKILLS%>" size="6" validate="Primary Skills,string,no" class="large" maxlength="200">
			<input type="text" name="<%=EXPERIENCE_SKILLS+"1"%>" size="6" validate="Primary Skills1,string,no" class="large" maxlength="200">
			<div class="clear"></div>
		</div> <!-- end experi6 div -->
		
		
		<div id="country7" class="tabcontent">
		 
			<label>Service Start date</label> 
			<input type="text" id="expserviceStartDate2"  name="<%=SERVICE_START_DATE+"2"%>"   class="date" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Service Start Date,date,no"  />
			 <img src="/hms/jsp/images/cal.gif" width="16" onclick="javascript:setdate('',document.employee.<%=SERVICE_START_DATE+"2"%>,event)" height="16" border="0" validate="Pick a date"  class="calender"/> 
	 		
	 		<label>Service End Date</label>
		
			
			 <input type="text" id="SERVICE_END_DATE2"  name="<%=SERVICE_END_DATE+"2"%>" class="date"  onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Service End Date 2,date,no"   MAXLENGTH="30" />
			< <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onClick="javascript:setdate('',document.employee.<%=SERVICE_END_DATE+"2"%>,event)" validate="Pick a date" class="calender" /> 
									
			<label>Experience</label>
			<select name="<%=YEARS+"2"%>" validate="Experience in Years,string,no"  class="smallest">
				<option value="">--</option>calDate
			<%	for(int i=0;i<=30;i++){%>
				<option value="<%=i%>"><%=i%></option>
			<%}%>
			<option value="31">+30</option>
			</select>
			<%--<label class="smallAuto">Yrs</label>--%>

			<select name="<%=MONTHS+"2"%>" validate="Experience in Months,string,no" class="smallest" >
			<option value="">--</option>
			<option value="0">--</option>
			<%for(int i=1;i<=11;i++){%>
			<option value="<%=i%>"><%=i%></option>
			<%}%>
			</select>
			<!-- <label class="smallAuto">Months</label> -->
			<div class="clear"></div>
			
			<label>Previous Employer</label>
			<input type="text" name="<%=PREVIOUS_EMPLOYER+"2"%>" value=""  validate="Previous Employer,String,no"  MAXLENGTH="30" />
			
			<label>Designation</label>
			<input type="text" id="designation" name="<%=DESIGNATION+"2"%>" value=""  validate="Designation,String,no"  MAXLENGTH="30" />			
			
			<label>Awards</label>
			<input type="text" name="<%=EX_AWARDS+"2"%>" value=""  validate="Awards,String,no"  MAXLENGTH="200" />	 
			
  	  	   	<div class="clear"></div>
  	  	   	
			<label>Previous Service End Reason</label>
			<input type="text" id="previousEmployer" name="<%=PREVIOUS_SERVICE_END_REASON+"2"%>" value=""  validate="Previous Service End Reason,String,no"  MAXLENGTH="30" />
			
			<label>Phone No.</label>
			<input type="text" name="<%=EMPLOYER_PHONE_NO+"2"%>" value=""  validate="Employer phone no.,String,no"  MAXLENGTH="30" />
			
			<label>Address</label>
			<textarea name="<%= EMPLOYER_ADDRESS+"2"%>" validate="Address,string,no" id="employerAddress" onkeydown="refreshLengthWithoutMeter1(this.id,250)" onkeyup="refreshLengthWithoutMeter(this.id,250)"></textarea> 
			<div class="clear"></div>
			
			<div class="clear"></div>
 			<label>Skills</label>
			<input type="text" name="<%=EXPERIENCE_SKILLS+"2"%>" size="6" validate="Primary Skills,string,no" class="large" maxlength="200">
			<div class="clear"></div>
		</div> <!-- end exper7 div -->
		
		<div id="country8" class="tabcontent">
		 
			<label>Service Start date</label> 
			<input type="text" name="<%=SERVICE_START_DATE+"3"%>"  onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" value="" validate="Service Start Date,date,no" class="calDate" />
			<%-- <img src="/erp/jsp/images/cal.gif" width="16" onclick="javascript:setdate('',document.employee.<%=SERVICE_START_DATE+"3"%>,event)" height="16" border="0" validate="Pick a date"  /> --%>
	 		
	 		<label>Service End Date</label>
			<input type="text" name="<%=SERVICE_END_DATE+"3"%>" value=""  onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Service End Date,date,no" class="calDate" />
			<%-- <img src="/erp/jsp/images/cal.gif" width="16" onclick="javascript:setdate('',document.employee.<%=SERVICE_END_DATE+"3"%>,event)" height="16" border="0" validate="Pick a date"  /> --%>
									
			<label>Experience</label>
			<select name="<%=YEARS+"3"%>" validate="Experience in Years,string,no"  class="smallest">
				<option value="">--</option>
			<%	for(int i=0;i<=30;i++){%>
				<option value="<%=i%>"><%=i%></option>
			<%}%>
			<option value="31">+30</option>
			</select>
			<%--<label class="smallAuto">Yrs</label>--%>

			<select name="<%=MONTHS+"3"%>" validate="Experience in Months,string,no" class="smallest" >
			<option value="">--</option>
			<option value="0">--</option>
			<%for(int i=1;i<=11;i++){%>
			<option value="<%=i%>"><%=i%></option>
			<%}%>
			</select>
		<%--	<label class="smallAuto">Months</label> --%>
			<div class="clear"></div>
			
			<label>Previous Employer</label>
			<input type="text" name="<%=PREVIOUS_EMPLOYER+"3"%>" value=""  validate="Previous Employer,String,no"  MAXLENGTH="30" />
			
			<label>Designation</label>
			<input type="text" id="designation" name="<%=DESIGNATION+"3"%>" value=""  validate="Designation,String,no"  MAXLENGTH="30" />			
			
			<label>Awards</label>
			<input type="text" name="<%=EX_AWARDS+"3"%>" value=""  validate="Awards,String,no"  MAXLENGTH="200" />	 
			
  	  	   	<div class="clear"></div>
  	  	   	
			<label>Previous Service End Reason</label>
			<input type="text" id="previousEmployer" name="<%=PREVIOUS_SERVICE_END_REASON+"3"%>" value=""  validate="Previous Service End Reason,String,no"  MAXLENGTH="30" />
			
			<label>Phone No.</label>
			<input type="text" name="<%=EMPLOYER_PHONE_NO+"3"%>" value=""  validate="Employer phone no.,String,no"  MAXLENGTH="30" />
			
			<label>Address</label>
			<textarea name="<%= EMPLOYER_ADDRESS+"3"%>" validate="Address,string,no" id="employerAddress" onkeydown="refreshLengthWithoutMeter1(this.id,250)" onkeyup="refreshLengthWithoutMeter(this.id,250)"></textarea> 
			<div class="clear"></div>
			
			<div class="clear"></div>
 			<label>Skills</label>
			<input type="text" name="<%=EXPERIENCE_SKILLS+"3"%>" size="6" validate="Primary Skills,string,no" class="large" maxlength="200">
			<div class="clear"></div>
		</div> <!-- end exper8 div -->
		
		<div id="country9" class="tabcontent">
		 
			<label>Service Start date</label> 
			<input type="text" name="<%=SERVICE_START_DATE+"4"%>"  onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" value="" validate="Service Start Date,date,no" class="calDate" />
			<%-- <img src="/erp/jsp/images/cal.gif" width="16" onclick="javascript:setdate('',document.employee.<%=SERVICE_START_DATE+"4"%>,event)" height="16" border="0" validate="Pick a date"  /> --%>
	 		
	 		<label>Service End Date</label>
			<input type="text" name="<%=SERVICE_END_DATE+"4"%>" value=""  onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Service End Date,date,no" class="calDate" />
			<%-- <img src="/erp/jsp/images/cal.gif" width="16" onclick="javascript:setdate('',document.employee.<%=SERVICE_END_DATE+"4"%>,event)" height="16" border="0" validate="Pick a date"  /> --%>
									
			<label>Experience</label>
			<select name="<%=YEARS+"4"%>" validate="Experience in Years,string,no"  class="smallest">
				<option value="">--</option>
			<%	for(int i=0;i<=30;i++){%>
				<option value="<%=i%>"><%=i%></option>
			<%}%>
			<option value="31">+30</option>
			</select>
		<%--	<label class="smallAuto">Yrs</label> --%>

			<select name="<%=MONTHS+"4"%>" validate="Experience in Months,string,no" class="smallest" >
			<option value="">--</option>
			<option value="0">--</option>
			<%for(int i=1;i<=11;i++){%>
			<option value="<%=i%>"><%=i%></option>
			<%}%>
			</select>
		<%--	<label class="smallAuto">Months</label> --%>
			<div class="clear"></div>
			
			<label>Previous Employer</label>
			<input type="text" name="<%=PREVIOUS_EMPLOYER+"4"%>" value=""  validate="Previous Employer,String,no"  MAXLENGTH="30" />
			
			<label>Designation</label>
			<input type="text" id="designation" name="<%=DESIGNATION+"4"%>" value=""  validate="Designation,String,no"  MAXLENGTH="30" />			
			
			<label>Awards</label>
			<input type="text" name="<%=EX_AWARDS+"4"%>" value=""  validate="Awards,String,no"  MAXLENGTH="200" />	 
			
  	  	   	<div class="clear"></div>
  	  	   	
			<label>Previous Service End Reason</label>
			<input type="text" id="previousEmployer" name="<%=PREVIOUS_SERVICE_END_REASON+"4"%>" value=""  validate="Previous Service End Reason,String,no"  MAXLENGTH="30" />
			
			<label>Phone No.</label>
			<input type="text" name="<%=EMPLOYER_PHONE_NO+"4"%>" value=""  validate="Employer phone no.,String,no"  MAXLENGTH="30" />
			
			<label>Address</label>
			<textarea name="<%= EMPLOYER_ADDRESS+"4"%>" validate="Address,string,no" id="employerAddress" onkeydown="refreshLengthWithoutMeter1(this.id,250)" onkeyup="refreshLengthWithoutMeter(this.id,250)"></textarea> 
			<div class="clear"></div>
			
			<div class="clear"></div>
 			<label>Skills</label>
			<input type="text" name="<%=EXPERIENCE_SKILLS+"4"%>" size="6" validate="Primary Skills,string,no" class="large" maxlength="200">
			<div class="clear"></div>
		</div> <!-- end exper9 div -->
		
		<div id="country10" class="tabcontent">
		 
			<label>Service Start date</label> 
			<input type="text" name="<%=SERVICE_START_DATE+"5"%>"  onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" value="" validate="Service Start Date,date,no" class="calDate" />
			<%-- <img src="/erp/jsp/images/cal.gif" width="16" onclick="javascript:setdate('',document.employee.<%=SERVICE_START_DATE+"5"%>,event)" height="16" border="0" validate="Pick a date"  /> --%>
	 		
	 		<label>Service End Date</label>
			<input type="text" name="<%=SERVICE_END_DATE+"5"%>" value=""  onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Service End Date,date,no" class="calDate" />
			<%-- <img src="/erp/jsp/images/cal.gif" width="16" onclick="javascript:setdate('',document.employee.<%=SERVICE_END_DATE+"5"%>,event)" height="16" border="0" validate="Pick a date"  /> --%>
									
			<label>Experience</label>
			<select name="<%=YEARS+"5"%>" validate="Experience in Years,string,no"  class="smallest">
				<option value="">--</option>
			<%	for(int i=0;i<=30;i++){%>
				<option value="<%=i%>"><%=i%></option>
			<%}%>
			<option value="31">+30</option>
			</select>
			<%-- <label class="smallAuto">Yrs</label> --%>

			<select name="<%=MONTHS+"5"%>" validate="Experience in Months,string,no" class="smallest" >
			<option value="">--</option>
			<option value="0">--</option>
			<%for(int i=1;i<=11;i++){%>
			<option value="<%=i%>"><%=i%></option>
			<%}%>
			</select>
			<%-- <label class="smallAuto">Months</label>--%>
			<div class="clear"></div>
			
			<label>Previous Employer</label>
			<input type="text" name="<%=PREVIOUS_EMPLOYER+"5"%>" value=""  validate="Previous Employer,String,no"  MAXLENGTH="30" />
			
			<label>Designation</label>
			<input type="text" id="designation" name="<%=DESIGNATION+"5"%>" value=""  validate="Designation,String,no"  MAXLENGTH="30" />			
			
			<label>Awards</label>
			<input type="text" name="<%=EX_AWARDS+"5"%>" value=""  validate="Awards,String,no"  MAXLENGTH="200" />	 
			
  	  	   	<div class="clear"></div>
  	  	   	
			<label>Previous Service End Reason</label>
			<input type="text" id="previousEmployer" name="<%=PREVIOUS_SERVICE_END_REASON+"5"%>" value=""  validate="Previous Service End Reason,String,no"  MAXLENGTH="30" />
			
			<label>Phone No.</label>
			<input type="text" name="<%=EMPLOYER_PHONE_NO+"5"%>" value=""  validate="Employer phone no.,String,no"  MAXLENGTH="30" />
			
			<label>Address</label>
			<textarea name="<%= EMPLOYER_ADDRESS+"5"%>" validate="Address,string,no" id="employerAddress" onkeydown="refreshLengthWithoutMeter1(this.id,250)" onkeyup="refreshLengthWithoutMeter(this.id,250)"></textarea> 
			<div class="clear"></div>
			
 			<label>Skills</label>
			<input type="text" name="<%=EXPERIENCE_SKILLS+"5"%>" size="6" validate="Primary Skills,string,no" class="large" maxlength="200">
			<div class="clear"></div>
		</div> <!-- end exper10 div -->
		<div class="clear"></div>
		
		</div><!-- end tabcontainer div -->
		
		
		</div> <!-- end Block div -->
		
<script type="text/javascript">

var countries1=new ddtabcontent("countrytabs1")
countries1.setpersist(true)
countries1.setselectedClassTarget("link") //"link" or "linkparent"
countries1.init()

</script>
		
		<div class="division"></div>
		<div class="clear"></div>
			
			<a href="javascript:changeClass('title8','t8')"><h5 id='t8'>Employee Health</h5></a>
			<div class="clear"></div>
			<div class="Block" id="title8"> 
		 
			<label>Handicap Status</label> 
			<select name="<%=HANDICAP_STATUS%>" validate="Handicap Status,string,no" >
				<option value="">
					Select
				</option>
				<option value="Not Handicapped">
					Not Handicapped
				</option>
				<option value="Physically Handicapped">
					Physically Handicapped
				</option>
			</select>
	 		
	 		<label>Insurance Type</label>
			<select name="<%=INSURANCE_TYPE%>" validate="Insurance Type,string,no" >
				<option value="">
					Select
				</option>
				<option value="Life Insurance">
					Life Insurance
				</option>
				<option value="Medical Insurance">
					Medical Insurance
				</option>
			</select>									
			
			<label>Insurance Company</label>
			<input type="text" name="<%=INSURANCE_COMPANY%>" value=""  validate="Insurance Company,String,no"  class="medium3" MAXLENGTH="30" />
			
			<div class="clear"></div>
						
			<label>Insurance Start date</label>
			<input type="text" name="<%=INSURANCE_START_DATE%>" value=""  onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Insurance Start Date,string,no" class="date">
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%=INSURANCE_START_DATE%>',document.employee.<%=INSURANCE_START_DATE%>,true);" />
	 		<%-- <img src="/erp/jsp/images/cal.gif" width="16" onClick="javascript:setdate('',document.employee.<%=INSURANCE_START_DATE%>,event)" height="16" border="0" validate="Pick a date" class="calender" /> --%>
			
			<label>Insurance End Date</label>
			<input type="text" name="<%=INSURANCE_END_DATE%>" value=""  onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Insurance Start Date,string,no" class="date">
	 		 <img src="/hms/jsp/images/cal.gif" width="16" onClick="javascript:setdate('',document.employee.<%=INSURANCE_END_DATE%>,event)" height="16" border="0" validate="Pick a date" class="calender" /> 		
			
			
			<label>Premium</label>			
			<select name="premium" id="premium" >
				<option value="">Select</option>
				<option value="Yearly">Yearly</option>
				<option value="Monthly">Monthly</option>
				</select>
					<div class="clear"></div>
				<label>Medical Remarks</label>
			<textarea name="<%=MEDICAL_REMARKS%>" validate="Medical Remarks,string,no" id="medicalRemarks" onkeydown="refreshLengthWithoutMeter1(this.id,250)" onkeyup="refreshLengthWithoutMeter(this.id,250)"></textarea>
				<div class="clear"></div>
  	  	   	</div>
  	  	
			<div class="clear"></div>
						
			<div id="edited"></div>
			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('employee','personnel?method=addEmployeeCliniRx');" accesskey="a" />
			<!-- <input type="button" name="edit" id="editbutton" value="Update"  style="display:none;" class="button" onClick="submitForm('employee','personnel?method=addEmployeeCliniRx')" accesskey="u"  /> -->
	<input type="button" name="edit" id="editbutton" value="Update"
		style="display: none;" class="button"
		onClick="submitForm('employee','personnel?method=editEmployeeTemp')"
		accesskey="u" /> <input type="button" name="Delete" id="deletebutton" value="Activate"  class="button" onClick="submitForm('employee','personnel?method=deleteEmployee&flag='+this.value)" accesskey="d" />		
			<input type="reset"  name ="Reset" id="reset" value ="Reset" class="button" onclick="location.reload();" accesskey="r" />
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
			<input type="hidden" name="<%= HOSPITAL_ID%>" value="" />
			
		  <div class="clear"></div>
		<div class="paddingTop15"></div>
			 <div class="bottom">
			
			<label >Changed By</label>   
			<label class="value" ><%=userName%></label>
			        
			<label>Changed Date</label>   
			<label class="value"><%=date%></label>
			 
			<label >Changed Time</label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
			
		 </div> 
		<div class="clear"></div>
   		
</form>

<script type="text/javascript">

data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Employee Code"
data_header[0][1] = "hide";
data_header[0][2] = 0;
data_header[0][3] = "<%=EMPLOYEE_CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Appointment Date"
data_header[1][1] = "hide";
data_header[1][2] = 0;
data_header[1][3] = "<%= APPOINTMENT_DATE %>";

data_header[2] = new Array;
data_header[2][0] = "Join Date"
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= JOIN_DATE%>"

data_header[3] = new Array;
data_header[3][0] = "Employee Type"
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=EMPLOYEE_TYPE%>"

data_header[4] = new Array;
data_header[4][0] = "Employee Card No"
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= EMPLOYEE_CARD_NO%>"

data_header[5] = new Array;
data_header[5][0] = "First Name"
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=FIRST_NAME %>"

data_header[6] = new Array;
data_header[6][0] = "Employee Name"
data_header[6][1] = "data";
data_header[6][2] = 0;
data_header[6][3] = "empName"

data_header[7] = new Array;
data_header[7][0] = "Last Name"
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%= LAST_NAME %>"

data_header[8] = new Array;
data_header[8][0] = "Title"
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%= TITLE_ID %>"

data_header[9] = new Array;
data_header[9][0] = "Designation"
data_header[9][1] = "data";
data_header[9][2] = 0;
data_header[9][3] = "<%= RANK_ID %>"

data_header[10] = new Array;
data_header[10][0] = "Employee Status"
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "<%= EMP_STATUS_ID %>"

data_header[11] = new Array;
data_header[11][0] = "Department"
data_header[11][1]="data";
data_header[11][2] = 0;
data_header[11][3] = "<%= DEPARTMENT_ID %>"


data_header[12] = new Array;
data_header[12][0] = "Gender"
data_header[12][1] = "hide";
data_header[12][2] = 0;
data_header[12][3] = "<%= GENDER%>"

data_header[13] = new Array;
data_header[13][0] = "Date of Birth"
data_header[13][1] = "hide";
data_header[13][2] = 0;
data_header[13][3] = "<%= DATE_OF_BIRTH%>"

data_header[14] = new Array;
data_header[14][0] = "Passport Number"
data_header[14][1] = "hide";
data_header[14][2] = 0;
data_header[14][3] = "<%= PASSPORTNUMBER%>"

data_header[15] = new Array;
data_header[15][0] = "Passport Issue Date"
data_header[15][1] = "hide";
data_header[15][2] = 0;
data_header[15][3] = "<%= PASSPORTISSUEDATE%>"

data_header[16] = new Array;
data_header[16][0] = "Passport Expiry Date"
data_header[16][1] = "hide";
data_header[16][2] = 0;
data_header[16][3] = "<%= PASSPORTEXPIRYDATE%>"

data_header[17] = new Array;
data_header[17][0] = "Visa Details"
data_header[17][1] = "hide";
data_header[17][2] = 0;
data_header[17][3] = "<%= VISADETAILS%>"

data_header[18] = new Array;
data_header[18][0] = "PAN No."
data_header[18][1] = "hide";
data_header[18][2] = 0;
data_header[18][3] = "<%= PANNO%>"

data_header[19] = new Array;
data_header[19][0] = "Driving Licence"
data_header[19][1] = "hide";
data_header[19][2] = 0;
data_header[19][3] = "<%= DRIVING%>"

data_header[20] = new Array;
data_header[20][0] = "Marital Status"
data_header[20][1] = "hide";
data_header[20][2] = 0;
data_header[20][3] = "<%= MARITAL_STATUS_ID%>"

data_header[21] = new Array;
data_header[21][0] = "Marriage Date"
data_header[21][1] = "hide";
data_header[21][2] = 0;
data_header[21][3] = "<%= MARRIAGE_DATE%>"

data_header[22] = new Array;
data_header[22][0] = "Bank Code"
data_header[22][1] = "hide";
data_header[22][2] = 0;
data_header[22][3] = "<%= BANK_CODE%>"

data_header[23] = new Array;
data_header[23][0] = "Bank Account Code"
data_header[23][1] = "hide";
data_header[23][2] = 0;
data_header[23][3] = "<%= BANK_ACCOUNT_CODE%>"

data_header[24] = new Array;
data_header[24][0] = "Bank Account Number"
data_header[24][1] = "hide";
data_header[24][2] = 0;
data_header[24][3] = "<%=BANK_ACCOUNT_NUMBER%>"

data_header[25] = new Array;
data_header[25][0] = "Account Head"
data_header[25][1] = "hide";
data_header[25][2] = 0;
data_header[25][3] = "<%= ACCOUNT_HEAD%>"


data_header[26] = new Array;
data_header[26][0] = "Status"
data_header[26][1] = "data";
data_header[26][2] = 0;
data_header[26][3] = "<%=STATUS %>"

data_header[27] = new Array;
data_header[27][0] = "Permanent Address "
data_header[27][1] = "hide";
data_header[27][2] = 0;
data_header[27][3] = "<%=EMPLOYEE_PERMANENT_ADDRESS %>"

data_header[28] = new Array;
data_header[28][0] = "Residential Address"
data_header[28][1] = "hide";
data_header[28][2] = 0;
data_header[28][3] = "<%=EMPLOYEE_RESIDENTIAL_ADDRESS%>"


data_header[29] = new Array;
data_header[29][0] = "Mobile No."
data_header[29][1] = "hide";
data_header[29][2] = 0;
data_header[29][3] = "<%=EMERGENCY_MOBILE%>"

data_header[30] = new Array;
data_header[30][0] = "Office Phone"
data_header[30][1] = "hide";
data_header[30][2] = 0;
data_header[30][3] = "<%=TELL_NO_OFFICE%>"

data_header[31] = new Array;
data_header[31][0] = "Resi. Phone"
data_header[31][1] = "hide";
data_header[31][2] = 0;
data_header[31][3] = "<%=TELL_NO_RESIDENCE%>"

data_header[32] = new Array;
data_header[32][0] = "Email Id"
data_header[32][1] = "hide";
data_header[32][2] = 0;
data_header[32][3] = "<%=EMAIL%>"

data_header[33] = new Array;
data_header[33][0] = "Emp Url"
data_header[33][1] = "hide";
data_header[33][2] = 0;
data_header[33][3] = "<%=URL%>"

data_header[34] = new Array;
data_header[34][0] = ""
data_header[34][1] = "hide";
data_header[34][2] = 0;
data_header[34][3] = "<%=SERVICE_START_DATE+"1"%>"

data_header[35] = new Array;
data_header[35][0] = "Service End Date"
data_header[35][1] = "hide";
data_header[35][2] = 0;
data_header[35][3] = "<%=SERVICE_END_DATE+"1"%>"

data_header[36] = new Array;
data_header[36][0] = "Experience Years"
data_header[36][1] = "hide";
data_header[36][2] = 0;
data_header[36][3] = "<%=YEAR+"1"%>"

data_header[37] = new Array;
data_header[37][0] = "Experience Months"
data_header[37][1] = "hide";
data_header[37][2] = 0;
data_header[37][3] = "<%=MONTHS+"1"%>"

data_header[38] = new Array;
data_header[38][0] = "Previous Employer"
data_header[38][1] = "hide";
data_header[38][2] = 0;
data_header[38][3] = "<%=PREVIOUS_EMPLOYER+"1"%>"

data_header[39] = new Array;
data_header[39][0] = "Designation"
data_header[39][1] = "hide";
data_header[39][2] = 0;
data_header[39][3] = "<%=DESIGNATION+"1"%>"

data_header[40] = new Array;
data_header[40][0] = "Awards"
data_header[40][1] = "hide";
data_header[40][2] = 0;
data_header[40][3] = "<%=EX_AWARDS+"1"%>"

data_header[41] = new Array;
data_header[41][0] = "Previous Service End Reason"
data_header[41][1] = "hide";
data_header[41][2] = 0;
data_header[41][3] = "<%=PREVIOUS_SERVICE_END_REASON+"1"%>"

data_header[42] = new Array;
data_header[42][0] = "Phone No."
data_header[42][1] = "hide";
data_header[42][2] = 0;
data_header[42][3] = "<%=EMPLOYER_PHONE_NO+"1"%>"

data_header[43] = new Array;
data_header[43][0] = "Address"
data_header[43][1] = "hide";
data_header[43][2] = 0;
data_header[43][3] = "<%=EMPLOYER_ADDRESS+"1"%>"

data_header[44] = new Array;
data_header[44][0] = "Skills"
data_header[44][1] = "hide";
data_header[44][2] = 0;
data_header[44][3] = "<%=EXPERIENCE_SKILLS+"1"%>"

data_header[45] = new Array;
data_header[45][0] = "line Manager"
data_header[45][1] = "hide";
data_header[45][2] = 0;
data_header[45][3] = "<%=MANAGER_ID%>"

data_header[46] = new Array;
data_header[46][0] = "Location"
data_header[46][1] = "hide";
data_header[46][2] = 0;
data_header[46][3] = "<%=LOCATION%>"

data_header[47] = new Array;
data_header[47][0] = "Probation Period"
data_header[47][1] = "hide";
data_header[47][2] = 0;
data_header[47][3] = "<%=PROBATION_PERIOD%>"

data_header[48] = new Array;
data_header[48][0] = "Confirmation Due Date"
data_header[48][1] = "hide";
data_header[48][2] = 0;
data_header[48][3] = "<%=CONFIRMATION_DUE_DATE%>"

data_header[49] = new Array;
data_header[49][0] = "Last Working Day"
data_header[49][1] = "hide";
data_header[49][2] = 0;
data_header[49][3] = "<%=LAST_WORKING_DAY%>"

data_header[50] = new Array;
data_header[50][0] = "Date of Resignation"
data_header[50][1] = "hide";
data_header[50][2] = 0;
data_header[50][3] = "<%=DATE_OF_RESIGNATION%>"

data_header[51] = new Array;
data_header[51][0] = "Equivalent Designation"
data_header[51][1] = "hide";
data_header[51][2] = 0;
data_header[51][3] = "<%=EQUIVALENT_DESIGNATION%>"

data_header[52] = new Array;
data_header[52][0] = "Work Level"
data_header[52][1] = "hide";
data_header[52][2] = 0;
data_header[52][3] = "<%=EMPLOYEE_GRADE_ID%>"

data_header[53] = new Array;
data_header[53][0] = "Pf"
data_header[53][1] = "hide";
data_header[53][2] = 0;
data_header[53][3] = "<%=PFNO%>"


data_header[54] = new Array;
data_header[54][0] = "paymode"
data_header[54][1] = "hide";
data_header[54][2] = 0;
data_header[54][3] = "<%=PAY_MODE%>"

data_header[55] = new Array;
data_header[55][0] = "Institute"
data_header[55][1] = "data";
data_header[55][2] = 0;
data_header[55][3] = "joinOrganisation"

data_header[56] = new Array;
data_header[56][0] = ""
data_header[56][1] = "hide";
data_header[56][2] = 0;
data_header[56][3] = "hospitalIdEmp"

data_header[57] = new Array;
data_header[57][0] = "manager"
data_header[57][1] = "hide";
data_header[57][2] = 0;
data_header[57][3] = "managerId"

data_header[58] = new Array;
data_header[58][0] = ""
data_header[58][1] = "hide";
data_header[58][2] = 0;
data_header[58][3] = "<%=PASSPORTISSUEPLACE%>"

data_header[59] = new Array;
data_header[59][0] = ""
data_header[59][1] = "hide";
data_header[59][2] = 0;
data_header[59][3] = "<%=QUALIFICATION+"1"%>"

data_header[60] = new Array;
data_header[60][0] = ""
data_header[60][1] = "hide";
data_header[60][2] = 0;
data_header[60][3] = "<%=QUALIFICATION+"2"%>"

data_header[61] = new Array;
data_header[61][0] = ""
data_header[61][1] = "hide";
data_header[61][2] = 0;
data_header[61][3] = "<%=QUALIFICATION+"3"%>"

data_header[62] = new Array;
data_header[62][0] = ""
data_header[62][1] = "hide";
data_header[62][2] = 0;
data_header[62][3] = "<%=COURSES_NAME+"1"%>"

data_header[63] = new Array;
data_header[63][0] = ""
data_header[63][1] = "hide";
data_header[63][2] = 0;
data_header[63][3] = "<%=COURSES_NAME+"2"%>"

data_header[64] = new Array;
data_header[64][0] = ""
data_header[64][1] = "hide";
data_header[64][2] = 0;
data_header[64][3] = "<%=COURSES_NAME+"3"%>"

data_header[65] = new Array;
data_header[65][0] = ""
data_header[65][1] = "hide";
data_header[65][2] = 0;
data_header[65][3] = "<%=SPL_QUALIFICATION+"1"%>"

data_header[66] = new Array;
data_header[66][0] = ""
data_header[66][1] = "hide";
data_header[66][2] = 0;
data_header[66][3] = "<%=SPL_QUALIFICATION+"2"%>"

data_header[67] = new Array;
data_header[67][0] = ""
data_header[67][1] = "hide";
data_header[67][2] = 0;
data_header[67][3] = "<%=SPL_QUALIFICATION+"3"%>"


data_header[68] = new Array;
data_header[68][0] = ""
data_header[68][1] = "hide";
data_header[68][2] = 0;
data_header[68][3] = "<%=INSTITUTION+"1"%>"

data_header[69] = new Array;
data_header[69][0] = ""
data_header[69][1] = "hide";
data_header[69][2] = 0;
data_header[69][3] = "<%=INSTITUTION+"2"%>"

data_header[70] = new Array;
data_header[70][0] = ""
data_header[70][1] = "hide";
data_header[70][2] = 0;
data_header[70][3] = "<%=INSTITUTION+"3"%>"

data_header[71] = new Array;
data_header[71][0] = ""
data_header[71][1] = "hide";
data_header[71][2] = 0;
data_header[71][3] = "<%=START_DATE+"1"%>"

data_header[72] = new Array;
data_header[72][0] = ""
data_header[72][1] = "hide";
data_header[72][2] = 0;
data_header[72][3] = "<%=START_DATE+"2"%>"

data_header[73] = new Array;
data_header[73][0] = ""
data_header[73][1] = "hide";
data_header[73][2] = 0;
data_header[73][3] = "<%=START_DATE+"3"%>"

data_header[74] = new Array;
data_header[74][0] = ""
data_header[74][1] = "hide";
data_header[74][2] = 0;
data_header[74][3] = "<%=END_DATE+"1"%>"

data_header[75] = new Array;
data_header[75][0] = ""
data_header[75][1] = "hide";
data_header[75][2] = 0;
data_header[75][3] = "<%=END_DATE+"2"%>"

data_header[76] = new Array;
data_header[76][0] = ""
data_header[76][1] = "hide";
data_header[76][2] = 0;
data_header[76][3] = "<%=END_DATE+"3"%>"

data_header[77] = new Array;
data_header[77][0] = ""
data_header[77][1] = "hide";
data_header[77][2] = 0;
data_header[77][3] = "<%=COURSES_DURATION+"1"%>"

data_header[78] = new Array;
data_header[78][0] = ""
data_header[78][1] = "hide";
data_header[78][2] = 0;
data_header[78][3] = "<%=COURSES_DURATION+"2"%>"

data_header[79] = new Array;
data_header[79][0] = ""
data_header[79][1] = "hide";
data_header[79][2] = 0;
data_header[79][3] = "<%=COURSES_DURATION+"3"%>"

data_header[80] = new Array;
data_header[80][0] = ""
data_header[80][1] = "hide";
data_header[80][2] = 0;
data_header[80][3] = "<%=QUALIFIED_DATE+"1"%>"

data_header[81] = new Array;
data_header[81][0] = ""
data_header[81][1] = "hide";
data_header[81][2] = 0;
data_header[81][3] = "<%=QUALIFIED_DATE+"2"%>"

data_header[82] = new Array;
data_header[82][0] = ""
data_header[82][1] = "hide";
data_header[82][2] = 0;
data_header[82][3] = "<%=QUALIFIED_DATE+"3"%>"

data_header[83] = new Array;
data_header[83][0] = ""
data_header[83][1] = "hide";
data_header[83][2] = 0;
data_header[83][3] = "<%=AWARDS+"1"%>"

data_header[84] = new Array;
data_header[84][0] = ""
data_header[84][1] = "hide";
data_header[84][2] = 0;
data_header[84][3] = "<%=AWARDS+"2"%>"

data_header[85] = new Array;
data_header[85][0] = ""
data_header[85][1] = "hide";
data_header[85][2] = 0;
data_header[85][3] = "<%=AWARDS+"3"%>"

data_header[86] = new Array;
data_header[86][0] = ""
data_header[86][1] = "hide";
data_header[86][2] = 0;
data_header[86][3] = "<%=EDUCATION_SKILLS+"1"%>"

data_header[87] = new Array;
data_header[87][0] = ""
data_header[87][1] = "hide";
data_header[87][2] = 0;
data_header[87][3] = "<%=EDUCATION_SKILLS+"2"%>"

data_header[88] = new Array;
data_header[88][0] = ""
data_header[88][1] = "hide";
data_header[88][2] = 0;
data_header[88][3] = "<%=EDUCATION_SKILLS+"3"%>"

data_header[89] = new Array;
data_header[89][0] = ""
data_header[89][1] = "hide";
data_header[89][2] = 0;
data_header[89][3] = "<%=HANDICAP_STATUS%>"

data_header[90] = new Array;
data_header[90][0] = ""
data_header[90][1] = "hide";
data_header[90][2] = 0;
data_header[90][3] = "<%=INSURANCE_TYPE%>"

data_header[91] = new Array;
data_header[91][0] = ""
data_header[91][1] = "hide";
data_header[91][2] = 0;
data_header[91][3] = "<%=INSURANCE_COMPANY%>"

data_header[92] = new Array;
data_header[92][0] = ""
data_header[92][1] = "hide";
data_header[92][2] = 0;
data_header[92][3] = "<%=INSURANCE_START_DATE%>"

data_header[93] = new Array;
data_header[93][0] = ""
data_header[93][1] = "hide";
data_header[93][2] = 0;
data_header[93][3] = "<%=INSURANCE_END_DATE%>"

data_header[94] = new Array;
data_header[94][0] = ""
data_header[94][1] = "hide";
data_header[94][2] = 0;
data_header[94][3] = "<%=MEDICAL_REMARKS%>"

data_header[95] = new Array;
data_header[95][0] = ""
data_header[95][1] = "hide";
data_header[95][2] = 0;
data_header[95][3] = "<%=EXPERIENCE_SKILLS%>"

data_header[96] = new Array;
data_header[96][0] = ""
data_header[96][1] = "hide";
data_header[96][2] = 0;
data_header[96][3] = "fatherOrHusbandName"

data_header[97] = new Array;
data_header[97][0] = "employee_Code"
data_header[97][1] = "hide";
data_header[97][2] = 0;
data_header[97][3] = "employee_Code"

data_header[98] = new Array;
data_header[98][0] = "Sbu"
data_header[98][1] = "hide";
data_header[98][2] = 0;
data_header[98][3] = "sbuId"


data_header[99] = new Array;
data_header[99][0] = ""
data_header[99][1] = "hide";
data_header[99][2] = 0;
data_header[99][3] = "<%=QUALIFICATION+"4"%>"

data_header[100] = new Array;
data_header[100][0] = ""
data_header[100][1] = "hide";
data_header[100][2] = 0;
data_header[100][3] = "<%=QUALIFICATION+"5"%>"


data_header[101] = new Array;
data_header[101][0] = ""
data_header[101][1] = "hide";
data_header[101][2] = 0;
data_header[101][3] = "<%=COURSES_NAME+"4"%>"

data_header[102] = new Array;
data_header[102][0] = ""
data_header[102][1] = "hide";
data_header[102][2] = 0;
data_header[102][3] = "<%=COURSES_NAME+"5"%>"

data_header[103] = new Array;
data_header[103][0] = ""
data_header[103][1] = "hide";
data_header[103][2] = 0;
data_header[103][3] = "<%=SPL_QUALIFICATION+"4"%>"

data_header[104] = new Array;
data_header[104][0] = ""
data_header[104][1] = "hide";
data_header[104][2] = 0;
data_header[104][3] = "<%=SPL_QUALIFICATION+"5"%>"


data_header[105] = new Array;
data_header[105][0] = ""
data_header[105][1] = "hide";
data_header[105][2] = 0;
data_header[105][3] = "<%=INSTITUTION+"4"%>"

data_header[106] = new Array;
data_header[106][0] = ""
data_header[106][1] = "hide";
data_header[106][2] = 0;
data_header[106][3] = "<%=INSTITUTION+"5"%>"

data_header[107] = new Array;
data_header[107][0] = ""
data_header[107][1] = "hide";
data_header[107][2] = 0;
data_header[107][3] = "<%=START_DATE+"4"%>"

data_header[108] = new Array;
data_header[108][0] = ""
data_header[108][1] = "hide";
data_header[108][2] = 0;
data_header[108][3] = "<%=START_DATE+"5"%>"


data_header[109] = new Array;
data_header[109][0] = ""
data_header[109][1] = "hide";
data_header[109][2] = 0;
data_header[109][3] = "<%=END_DATE+"4"%>"

data_header[110] = new Array;
data_header[110][0] = ""
data_header[110][1] = "hide";
data_header[110][2] = 0;
data_header[110][3] = "<%=END_DATE+"5"%>"



data_header[111] = new Array;
data_header[111][0] = ""
data_header[111][1] = "hide";
data_header[111][2] = 0;
data_header[111][3] = "<%=COURSES_DURATION+"4"%>"

data_header[112] = new Array;
data_header[112][0] = ""
data_header[112][1] = "hide";
data_header[112][2] = 0;
data_header[112][3] = "<%=COURSES_DURATION+"5"%>"

data_header[113] = new Array;
data_header[113][0] = ""
data_header[113][1] = "hide";
data_header[113][2] = 0;
data_header[113][3] = "<%=QUALIFIED_DATE+"4"%>"


data_header[114] = new Array;
data_header[114][0] = ""
data_header[114][1] = "hide";
data_header[114][2] = 0;
data_header[114][3] = "<%=QUALIFIED_DATE+"5"%>"


data_header[115] = new Array;
data_header[115][0] = ""
data_header[115][1] = "hide";
data_header[115][2] = 0;
data_header[115][3] = "<%=AWARDS+"4"%>"

data_header[116] = new Array;
data_header[116][0] = ""
data_header[116][1] = "hide";
data_header[116][2] = 0;
data_header[116][3] = "<%=AWARDS+"5"%>"

data_header[117] = new Array;
data_header[117][0] = ""
data_header[117][1] = "hide";
data_header[117][2] = 0;
data_header[117][3] = "<%=EDUCATION_SKILLS+"4"%>"

data_header[118] = new Array;
data_header[118][0] = ""
data_header[118][1] = "hide";
data_header[118][2] = 0;
data_header[118][3] = "<%=EDUCATION_SKILLS+"5"%>"

data_header[119] = new Array;
data_header[119][0] = ""
data_header[119][1] = "hide";
data_header[119][2] = 0;
data_header[119][3] = "religion"

data_header[120] = new Array;
data_header[120][0] = ""
data_header[120][1] = "hide";
data_header[120][2] = 0;
data_header[120][3] = "premium"

data_header[121] = new Array;
data_header[121][0] = ""
data_header[121][1] = "hide";
data_header[121][2] = 0;
data_header[121][3] = "<%=SERVICE_START_DATE+"2"%>" 

data_header[122] = new Array;
data_header[122][0] = ""
data_header[122][1] = "hide";
data_header[122][2] = 0;
data_header[122][3] = "<%=SERVICE_END_DATE+"2"%>" 

data_header[123] = new Array;
data_header[123][0] = "Experience Years 2"
data_header[123][1] = "hide";
data_header[123][2] = 0;
data_header[123][3] = "<%=YEARS+ "2"%>" 

data_header[124] = new Array;
data_header[124][0] = "Experience Months 2"
data_header[124][1] = "hide";
data_header[124][2] = 0;
data_header[124][3] = "<%=MONTHS+"2"%>"

data_header[125] = new Array;
data_header[125][0] = "Previous Employer 2"
data_header[125][1] = "hide";
data_header[125][2] = 0;
data_header[125][3] = "<%=PREVIOUS_EMPLOYER+"2"%>"

data_header[126] = new Array;
data_header[126][0] = "Designation 2"
data_header[126][1] = "hide";
data_header[126][2] = 0;
data_header[126][3] = "<%=DESIGNATION+"2"%>"

data_header[127] = new Array;
data_header[127][0] = "Awards 2"
data_header[127][1] = "hide";
data_header[127][2] = 0;
data_header[127][3] = "<%=EX_AWARDS+"2"%>"

data_header[128] = new Array;
data_header[128][0] = "Previous Service End Reason"
data_header[128][1] = "hide";
data_header[128][2] = 0;
data_header[128][3] = "<%=PREVIOUS_SERVICE_END_REASON+"2"%>"

data_header[129] = new Array;
data_header[129][0] = "Phone No."
data_header[129][1] = "hide";
data_header[129][2] = 0;
data_header[129][3] = "<%=EMPLOYER_PHONE_NO+"2"%>"

data_header[130] = new Array;
data_header[130][0] = "Address"
data_header[130][1] = "hide";
data_header[130][2] = 0;
data_header[130][3] = "<%=EMPLOYER_ADDRESS+"2"%>"

data_header[131] = new Array;
data_header[131][0] = "Skills"
data_header[131][1] = "hide";
data_header[131][2] = 0;
data_header[131][3] = "<%=EXPERIENCE_SKILLS+"2"%>"

data_header[132] = new Array;
data_header[132][0] = ""
data_header[132][1] = "hide";
data_header[132][2] = 0;
data_header[132][3] = "<%=SERVICE_START_DATE+"3"%>" 

data_header[133] = new Array;
data_header[133][0] = ""
data_header[133][1] = "hide";
data_header[133][2] = 0;
data_header[133][3] = "<%=SERVICE_END_DATE+"3"%>" 

data_header[134] = new Array;
data_header[134][0] = "Experience Years 3"
data_header[134][1] = "hide";
data_header[134][2] = 0;
data_header[134][3] = "<%=YEARS+ "3"%>" 

data_header[135] = new Array;
data_header[135][0] = "Experience Months 3"
data_header[135][1] = "hide";
data_header[135][2] = 0;
data_header[135][3] = "<%=MONTHS+"3"%>"

data_header[136] = new Array;
data_header[136][0] = "Previous Employer 3"
data_header[136][1] = "hide";
data_header[136][2] = 0;
data_header[136][3] = "<%=PREVIOUS_EMPLOYER+"3"%>"

data_header[137] = new Array;
data_header[137][0] = "Designation 3"
data_header[137][1] = "hide";
data_header[137][2] = 0;
data_header[137][3] = "<%=DESIGNATION+"3"%>"

data_header[138] = new Array;
data_header[138][0] = "Awards 2"
data_header[138][1] = "hide";
data_header[138][2] = 0;
data_header[138][3] = "<%=EX_AWARDS+"3"%>"

data_header[139] = new Array;
data_header[139][0] = "Previous Service End Reason 3"
data_header[139][1] = "hide";
data_header[139][2] = 0;
data_header[139][3] = "<%=PREVIOUS_SERVICE_END_REASON+"3"%>"

data_header[140] = new Array;
data_header[140][0] = "Phone No."
data_header[140][1] = "hide";
data_header[140][2] = 0;
data_header[140][3] = "<%=EMPLOYER_PHONE_NO+"3"%>"

data_header[141] = new Array;
data_header[141][0] = "Address"
data_header[141][1] = "hide";
data_header[141][2] = 0;
data_header[141][3] = "<%=EMPLOYER_ADDRESS+"3"%>"

data_header[142] = new Array;
data_header[142][0] = "Skills 3"
data_header[142][1] = "hide";
data_header[142][2] = 0;
data_header[142][3] = "<%=EXPERIENCE_SKILLS+"3"%>"

data_header[143] = new Array;
data_header[143][0] = ""
data_header[143][1] = "hide";
data_header[143][2] = 0;
data_header[143][3] = "<%=SERVICE_START_DATE+"4"%>" 

data_header[144] = new Array;
data_header[144][0] = ""
data_header[144][1] = "hide";
data_header[144][2] = 0;
data_header[144][3] = "<%=SERVICE_END_DATE+"4"%>" 

data_header[145] = new Array;
data_header[145][0] = "Experience Years 4"
data_header[145][1] = "hide";
data_header[145][2] = 0;
data_header[145][3] = "<%=YEARS+ "4"%>" 

data_header[146] = new Array;
data_header[146][0] = "Experience Months 4"
data_header[146][1] = "hide";
data_header[146][2] = 0;
data_header[146][3] = "<%=MONTHS+"4"%>"

data_header[147] = new Array;
data_header[147][0] = "Previous Employer 4"
data_header[147][1] = "hide";
data_header[147][2] = 0;
data_header[147][3] = "<%=PREVIOUS_EMPLOYER+"4"%>"

data_header[148] = new Array;
data_header[148][0] = "Designation 4"
data_header[148][1] = "hide";
data_header[148][2] = 0;
data_header[148][3] = "<%=DESIGNATION+"4"%>"

data_header[149] = new Array;
data_header[149][0] = "Awards 2"
data_header[149][1] = "hide";
data_header[149][2] = 0;
data_header[149][3] = "<%=EX_AWARDS+"4"%>"

data_header[150] = new Array;
data_header[150][0] = "Previous Service End Reason 4"
data_header[150][1] = "hide";
data_header[150][2] = 0;
data_header[150][3] = "<%=PREVIOUS_SERVICE_END_REASON+"4"%>"

data_header[151] = new Array;
data_header[151][0] = "Phone No."
data_header[151][1] = "hide";
data_header[151][2] = 0;
data_header[151][3] = "<%=EMPLOYER_PHONE_NO+"4"%>"

data_header[152] = new Array;
data_header[152][0] = "Address"
data_header[152][1] = "hide";
data_header[152][2] = 0;
data_header[152][3] = "<%=EMPLOYER_ADDRESS+"4"%>"

data_header[153] = new Array;
data_header[153][0] = "Skills 4"
data_header[153][1] = "hide";
data_header[153][2] = 0;
data_header[153][3] = "<%=EXPERIENCE_SKILLS+"4"%>"

data_header[154] = new Array;
data_header[154][0] = ""
data_header[154][1] = "hide";
data_header[154][2] = 0;
data_header[154][3] = "<%=SERVICE_START_DATE+"5"%>" 

data_header[155] = new Array;
data_header[155][0] = ""
data_header[155][1] = "hide";
data_header[155][2] = 0;
data_header[155][3] = "<%=SERVICE_END_DATE+"5"%>" 

data_header[156] = new Array;
data_header[156][0] = "Experience Years 5"
data_header[156][1] = "hide";
data_header[156][2] = 0;
data_header[156][3] = "<%=YEARS+ "5"%>" 

data_header[157] = new Array;
data_header[157][0] = "Experience Months 5"
data_header[157][1] = "hide";
data_header[157][2] = 0;
data_header[157][3] = "<%=MONTHS+"5"%>"

data_header[158] = new Array;
data_header[158][0] = "Previous Employer 5"
data_header[158][1] = "hide";
data_header[158][2] = 0;
data_header[158][3] = "<%=PREVIOUS_EMPLOYER+"5"%>"

data_header[159] = new Array;
data_header[159][0] = "Designation 5"
data_header[159][1] = "hide";
data_header[159][2] = 0;
data_header[159][3] = "<%=DESIGNATION+"5"%>"

data_header[160] = new Array;
data_header[160][0] = "Awards 5"
data_header[160][1] = "hide";
data_header[160][2] = 0;
data_header[160][3] = "<%=EX_AWARDS+"5"%>"

data_header[161] = new Array;
data_header[161][0] = "Previous Service End Reason 5"
data_header[161][1] = "hide";
data_header[161][2] = 0;
data_header[161][3] = "<%=PREVIOUS_SERVICE_END_REASON+"5"%>"

data_header[162] = new Array;
data_header[162][0] = "Phone No. 5"
data_header[162][1] = "hide";
data_header[162][2] = 0;
data_header[162][3] = "<%=EMPLOYER_PHONE_NO+"5"%>"

data_header[163] = new Array;
data_header[163][0] = "Address 5"
data_header[163][1] = "hide";
data_header[163][2] = 0;
data_header[163][3] = "<%=EMPLOYER_ADDRESS+"5"%>"

data_header[164] = new Array;
data_header[164][0] = "Skills 5"
data_header[164][1] = "hide";
data_header[164][2] = 0;
data_header[164][3] = "<%=EXPERIENCE_SKILLS+"5"%>"

data_header[165] = new Array;
data_header[165][0] = "Middle Name"
data_header[165][1] = "hide";
data_header[165][2] = 0;
data_header[165][3] = "<%=MIDDLE_NAME %>"

data_header[166] = new Array;
data_header[166][0] = "PEN"
data_header[166][1] = "data";
data_header[166][2] = 0;
data_header[166][3] = "PEN"

data_header[167] = new Array;
data_header[167][0] = "Bank Branch"
data_header[167][1] = "hide";
data_header[167][2] = 0;
data_header[167][3] = "bankBranch"

data_header[168] = new Array;
data_header[168][0] = "IFSC Code"
data_header[168][1] = "hide";
data_header[168][2] = 0;
data_header[168][3] = "ifscCode"


data_arr = new Array();
<%	
	int  counter=0;

	for (MasEmployee masEmp : searchEmployeeList) {
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%=masEmp.getId()%>


<%if(masEmp.getEmployeeCode()!= null){%>
data_arr[<%= counter%>][1] = "<%=masEmp.getEmployeeCode()%>"
<%}else {%>
data_arr[<%= counter%>][1] = ""
<%} 
if(masEmp.getAppointmentDate() != null){%>
data_arr[<%= counter%>][2] = "<%= HMSUtil.getDateFormat(masEmp.getAppointmentDate(),"dd/MM/yyyy") %>"
<%}else {%>
data_arr[<%= counter%>][2] = ""
<%} if(masEmp.getJoinDate() != null){%>
data_arr[<%= counter%>][3] = "<%=HMSUtil.getDateFormat(masEmp.getJoinDate(),"dd/MM/yyyy")%>"
<%}else{%>
data_arr[<%= counter%>][3] = ""
<%}%>

<%if(masEmp.getEmployeeType() != null){
	Iterator itrTitleList= employeeTypeList.iterator();
	 while(itrTitleList.hasNext())
       {
        MasEmployeeType  masEmployeeType = (MasEmployeeType)itrTitleList.next(); 
		 if(masEmp.getEmployeeType().getId().equals(masEmployeeType.getId()) && masEmployeeType.getStatus().equalsIgnoreCase("y")){%>
			data_arr[<%= counter%>][4] = "<%=masEmployeeType.getEmpType()%>"
		<%}else if(masEmp.getTitle().getId().equals(masEmployeeType.getId()) && masEmployeeType.getStatus().equals("n")){%>
			data_arr[<%= counter%>][4] = "<span>*</span>Parent InActivated--<%=masEmployeeType.getEmpType()%>";
			
		<%}
       }
} else {%>
data_arr[<%= counter%>][4] = ""
<%} if(masEmp.getCardNo()!= null){%>
data_arr[<%= counter%>][5] = "<%= masEmp.getCardNo()%>"
<%}else{%>
data_arr[<%= counter%>][5] = ""
<%}%>
<% if(masEmp.getFirstName() != null){%>
data_arr[<%= counter%>][6] = "<%=masEmp.getFirstName()%>"
<%}else{%>
data_arr[<%= counter%>][6] = ""
<%}%>

<%if(masEmp.getEmployeeName() != null ){%>
data_arr[<%= counter%>][7] = "<%=masEmp.getEmployeeName()%>";
<%}else{%>
data_arr[<%= counter%>][7] = "";
<%}%>

<% if(masEmp.getLastName() != null){%>
data_arr[<%= counter%>][8] = "<%=masEmp.getLastName()%>"
<%}else{%>
data_arr[<%= counter%>][8] = ""
<%}%>
<% if(masEmp.getTitle() != null){
		Iterator itrTitleList=titleList.iterator();
		 while(itrTitleList.hasNext())
            {
             MasTitle  masTitleGrid = (MasTitle)itrTitleList.next(); 
			 if(masEmp.getTitle().getId().equals(masTitleGrid.getId()) && masTitleGrid.getStatus().equalsIgnoreCase("y")){%>
				data_arr[<%= counter%>][9] = "<%=masTitleGrid.getTitleName()%>"
			<%}else if(masEmp.getTitle().getId().equals(masTitleGrid.getId()) && masTitleGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][9] = "<font id='error'>*</font>Parent InActivated--<%=masTitleGrid.getTitleName()%>";
				
			<%}
			}
}else{%>
data_arr[<%= counter%>][9] = ""
<%}%>
<% if(masEmp.getRank()!= null){

		//for(Object[] masRankGrid :rankList){
			for(MasRank masRankGrid :rankList){
			 //if(masEmp.getRank().getId().equals(masRankGrid[0]) && masRankGrid[2].equals("y")){
			 if(masEmp.getRank().getId().equals(masRankGrid.getId()) && masRankGrid.getStatus().equalsIgnoreCase("y")){%>
				data_arr[<%= counter%>][10] = "<%=masRankGrid.getRankName()%>"
				<%-- data_arr[<%= counter%>][10] = "<%=masRankGrid[1]%>" --%>
			<%}//else if(masEmp.getRank().getId().equals(masRankGrid[0]) && masRankGrid[2].equals("n")){
			else if(masEmp.getRank().getId().equals(masRankGrid.getId()) && masRankGrid.getStatus().equals("n")){
			%>
				<%-- data_arr[<%= counter%>][10] = "<font id='error'>*</font>Parent InActivated--<%=masRankGrid[1]%>"; --%>
				data_arr[<%= counter%>][10] = "<font id='error'>*</font>Parent InActivated--<%=masRankGrid.getRankName()%>";
				
			<%}
            }
}else{%>
  data_arr[<%= counter%>][10]=""
<%}
if(masEmp.getEmployeeStatus() != null){

		Iterator itrEmpStatusList=empStatusList.iterator();
		 while(itrEmpStatusList.hasNext())
            {
             MasEmpStatus  masEmpStatusGrid = (MasEmpStatus)itrEmpStatusList.next(); 
             if(masEmp.getEmployeeStatus().getId().equals(masEmpStatusGrid.getId()) && masEmpStatusGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][11] = "<%=masEmpStatusGrid.getEmpStatusName()%>"
			<%}else if(masEmp.getEmployeeStatus().getId().equals(masEmpStatusGrid.getId()) && masEmpStatusGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][11] = "<font id='error'>*</font>Parent InActivated--<%=masEmpStatusGrid.getEmpStatusName()%>";
				
			<%}
             
            }
} else {%>
  data_arr[<%= counter%>][11] = ""
<%} 
if(masEmp.getDepartment() != null){%>
<%
		for(MasDepartment masDepartment : departmentList){
            if(masEmp.getDepartment() != null){
			if(masEmp.getDepartment().getId().equals(masDepartment.getId()) && masDepartment.getStatus().equalsIgnoreCase("y")){
			 %>
				data_arr[<%= counter%>][12] = "<%=masDepartment.getDepartmentName()%>"
			<%}else if(masEmp.getDepartment().getId().equals(masDepartment.getId()) && masDepartment.getStatus().equals("n")){%>
				data_arr[<%= counter%>][12] = "<font id='error'>*</font>Parent InActivated--<%=masDepartment.getDepartmentName()%>";
				
			<%}
            }}
}else {%>
data_arr[<%= counter%>][12] = ""
<%}
if(masEmp.getPersonalDetails()!=null && masEmp.getPersonalDetails().getGender() != null){

		for(MasAdministrativeSex masAdministrativeSex : masAdministrativeSexList){
            if(masEmp.getPersonalDetails().getGender() != null){
			if(masEmp.getPersonalDetails().getGender().getId().equals(masAdministrativeSex.getId()) && masAdministrativeSex.getStatus().equalsIgnoreCase("y")){
			 %>
				data_arr[<%= counter%>][13] = "<%=masAdministrativeSex.getAdministrativeSexName()%>"
			<%}else if(masEmp.getPersonalDetails().getGender().getId().equals(masAdministrativeSex.getId()) && masAdministrativeSex.getStatus().equals("n")){%>
				data_arr[<%= counter%>][13] = "<font id='error'>*</font>Parent InActivated--<%=masAdministrativeSex.getAdministrativeSexName()%>";
				
			<%}
            }}
}else{%>
data_arr[<%= counter%>][13] = ""
<%}
if(masEmp.getPersonalDetails()!=null && masEmp.getPersonalDetails().getDateOfBirth() != null){%>
data_arr[<%= counter%>][14] = "<%= HMSUtil.getDateFormat(masEmp.getPersonalDetails().getDateOfBirth(),"dd/MM/yyyy")  %>"
<%}else {%>
data_arr[<%= counter%>][14] = ""
<%} 
 if(masEmp.getPersonalDetails()!=null && masEmp.getPersonalDetails().getPassportNo() != null){%>
data_arr[<%= counter%>][15] = "<%= masEmp.getPersonalDetails().getPassportNo() %>"
<%}else {%>
data_arr[<%= counter%>][15] = ""
<%} if(masEmp.getPersonalDetails()!=null && masEmp.getPersonalDetails().getPassportIssueDate() != null){%>
data_arr[<%= counter%>][16] = "<%=HMSUtil.getDateFormat(masEmp.getPersonalDetails().getPassportIssueDate(),"dd/MM/yyyy")%>"
<%}else {%>
data_arr[<%= counter%>][16] = ""
<%}
if(masEmp.getPersonalDetails()!=null && masEmp.getPersonalDetails().getPassportExpiryDate() != null){%>
data_arr[<%= counter%>][17] = "<%=HMSUtil.getDateFormat(masEmp.getPersonalDetails().getPassportExpiryDate(),"dd/MM/yyyy")%>"
<%} else {%>
data_arr[<%= counter%>][17] = ""
<%}
if(masEmp.getPersonalDetails()!=null && masEmp.getPersonalDetails().getVisaDetails() != null){%>
data_arr[<%= counter%>][18] = "<%= masEmp.getPersonalDetails().getVisaDetails()%>"
<%}else{%>
data_arr[<%= counter%>][18] = ""
<%}
 if(masEmp.getPersonalDetails()!=null && masEmp.getPersonalDetails().getPanNo() != null){%>
data_arr[<%= counter%>][19] = "<%= masEmp.getPersonalDetails().getPanNo()%>"
<%} else {%>
data_arr[<%= counter%>][19] = ""
<%} if(masEmp.getPersonalDetails()!=null && masEmp.getPersonalDetails().getDrivingLicence() != null){%>
data_arr[<%= counter%>][20] = "<%= masEmp.getPersonalDetails().getDrivingLicence()  %>"
<%}else {%>
data_arr[<%= counter%>][20] = ""
<%}
 if(masEmp.getPersonalDetails()!=null && masEmp.getPersonalDetails().getMaritalStatus() != null){

		for(MasMaritalStatus masMaritalStatus : maritalStatusList){
            if(masEmp.getPersonalDetails().getMaritalStatus() != null){
			if(masEmp.getPersonalDetails().getMaritalStatus().getId().equals(masMaritalStatus.getId()) && masMaritalStatus.getStatus().equalsIgnoreCase("y")){
			 %>
				data_arr[<%= counter%>][21] = "<%=masMaritalStatus.getMaritalStatusName() %>"
			<%}else if(masEmp.getPersonalDetails().getMaritalStatus().getId().equals(masMaritalStatus.getId()) && masMaritalStatus.getStatus().equals("n")){%>
				data_arr[<%= counter%>][21] = "<font id='error'>*</font>Parent InActivated--<%=masMaritalStatus%>";
				
			<%}
            }
		}
}else {%>
data_arr[<%= counter%>][21] = ""
<%} if(masEmp.getPersonalDetails()!=null && masEmp.getPersonalDetails().getMarriageDate() != null){%>
data_arr[<%= counter%>][22] = "<%=HMSUtil.getDateFormat(masEmp.getPersonalDetails().getMarriageDate(),"dd/MM/yyyy")%>"
<%} else {%>
data_arr[<%= counter%>][22] = ""
<%}
  if(masEmp.getBankCode() != null){%>
data_arr[<%= counter%>][23] = "<%=masEmp.getBankCode()%>"
<%}else {%>
data_arr[<%= counter%>][23] = ""
<%}
  if(masEmp.getBankAccountCode()!= null){%>
data_arr[<%= counter%>][24] = "<%=masEmp.getBankAccountCode()%>"
<%}else {%>
data_arr[<%= counter%>][24] = ""
<%}
  if(masEmp.getBankAccountNumber() != null){%>
data_arr[<%= counter%>][25] = "<%=masEmp.getBankAccountNumber()%>";
<%}else {%>
data_arr[<%= counter%>][25] = ""
<%}
  if(masEmp.getAccountHead() != null){%>
data_arr[<%= counter%>][26] = "<%=masEmp.getAccountHead()%>";
<%}else {%>
data_arr[<%= counter%>][26] = ""
<%}if(masEmp.getStatus() != null){
	String status = ""; 
	if(masEmp.getStatus().equalsIgnoreCase("y"))
		status= "Active";
	else if( masEmp.getStatus().equalsIgnoreCase("e"))
		status= "Edit";
	else
		status= "Inactive";
%>
data_arr[<%= counter%>][27] = "<%=status%>";
<%} else {%>
data_arr[<%= counter%>][27] = ""
<%}if(masEmp.getPermanentAddress() != null){%>
data_arr[<%= counter%>][28] = "<%=masEmp.getPermanentAddress()%>";
<%}else {%>
data_arr[<%= counter%>][28] = ""
<%}if(masEmp.getResidentialAddress() != null){%>
data_arr[<%= counter%>][29] = "<%=masEmp.getResidentialAddress()%>";
<%}else {%>
data_arr[<%= counter%>][29] = ""
<%}if(masEmp.getCellNoEmergency() != null){%>
data_arr[<%= counter%>][30] = "<%=masEmp.getCellNoEmergency()%>";
<%}else {%>
data_arr[<%= counter%>][30] = ""
<%}if(masEmp.getTelNoOffice() != null){%>
data_arr[<%= counter%>][31] = "<%=masEmp.getTelNoOffice()%>";
<%}else {%>
data_arr[<%= counter%>][31] = ""
<%}if(masEmp.getTelNoResidence() != null){%>
data_arr[<%= counter%>][32] = "<%=masEmp.getTelNoResidence()%>";
<%}else {%>
data_arr[<%= counter%>][32] = ""
<%}if(masEmp.getEmail() != null){%>
data_arr[<%= counter%>][33] = "<%=masEmp.getEmail()%>";
<%}else {%>
data_arr[<%= counter%>][33] = ""
<%}if(masEmp.getUrl() != null){%>
data_arr[<%= counter%>][34] = "";
<%}else {%>
data_arr[<%= counter%>][34] = "";
<%}%>

<% //System.out.println("masEmp.getEmployeeExperience()>>"+masEmp.getEmployeeExperience());

Set<HrEmployeeExperience> empExp = masEmp.getEmployeeExperience();

boolean A1 = false;
boolean A2 = false;
boolean A3 = false;
boolean A4 = false;
boolean A5 = false;
boolean A6 = false;
boolean A7 = false;
boolean A8 = false;
boolean A9 = false;
boolean A10 = false;
boolean A11 = false;

boolean b1 = false;
boolean b2 = false;
boolean b3 = false;
boolean b4 = false;
boolean b5 = false;
boolean b6 = false;
boolean b7 = false;
boolean b8 = false;
boolean b9 = false;
boolean b10 = false;
boolean b11 = false;

boolean c1 = false;
boolean c2 = false;
boolean c3 = false;
boolean c4 = false;
boolean c5 = false;
boolean c6 = false;
boolean c7 = false;
boolean c8 = false;
boolean c9 = false;
boolean c10 = false;
boolean c11 = false;

boolean d1 = false;
boolean d2 = false;
boolean d3 = false;
boolean d4 = false;
boolean d5 = false;
boolean d6 = false;
boolean d7 = false;
boolean d8 = false;
boolean d9 = false;
boolean d10 = false;
boolean d11 = false;

boolean e1 = false;
boolean e2 = false;
boolean e3 = false;
boolean e4 = false;
boolean e5 = false;
boolean e6 = false;
boolean e7 = false;
boolean e8 = false;
boolean e9 = false;
boolean e10 = false;
boolean e11 = false;
//System.out.println("empExp>>"+empExp.size());
	
if(empExp.size()>0){
for(HrEmployeeExperience exp : empExp){

if(exp.getServiceStartDate() != null  && exp.getExperienceTypeCode().equals(1)){
	%>

	data_arr[<%= counter%>][35] = "<%=HMSUtil.getDateFormat(exp.getServiceStartDate(),"dd/MM/yyyy")%>";
	
	<% A1= true;}%>
<%
	if(exp.getServiceEndDate() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(1)){		
		%>
	data_arr[<%= counter%>][36] = "<%=HMSUtil.getDateFormat(exp.getServiceEndDate(),"dd/MM/yyyy")%>";
	<%A2= true;}%>
		
		<%if(exp.getExpYrs() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(1)){
			%>
		
		data_arr[<%= counter%>][37] = "<%=exp.getExpYrs()%>";
		<%A3=true;}%>
			
		<%if(exp.getExpMonths() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(1)){
		%>
				
		data_arr[<%= counter%>][38] = "<%=exp.getExpMonths()%>";
		<%A4=true;}%>
		
		<%if(exp.getPreviousEmployer() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(1)){
			%>					
			data_arr[<%= counter%>][39] = "<%=exp.getPreviousEmployer()%>";
			<%A5=true;}%>
					
			<%if(exp.getDesignation() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(1)){
			%>					
			data_arr[<%= counter%>][40] = "<%=exp.getDesignation()%>";
			<%A6=true;}%>
						
						
			<%if(exp.getAwards() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(1)){
			%>					
			data_arr[<%= counter%>][41] = "<%=exp.getAwards()%>";
			<%A7=true;}%>
					
					
						
			<%if(exp.getPreviousServiceEndReason() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(1)){
			%>					
			data_arr[<%= counter%>][42] = "<%=exp.getPreviousServiceEndReason()%>";
			<%A8=true;}%>
			
			<%if(exp.getPhoneNo() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(1)){
									//System.out.println("---getPhoneNo---"+exp.getPhoneNo());
			%>					
			data_arr[<%= counter%>][43] = "<%=exp.getPhoneNo()%>";
			<%A9=true;}%>
									
			<%if(exp.getAddress() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(1)){
			%>					
			data_arr[<%= counter%>][44] = "<%=exp.getAddress()%>";
			<%A10=true;}%>
			
			<%//System.out.println("skil>ppppppp>");
			//System.out.println("skil>>"+exp.getSkills());
			if(exp.getSkills() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(1)){
			%>					
			data_arr[<%= counter%>][45] = "<%=exp.getSkills()%>";
			<%A11=true;}%>
										
			<%if(exp.getServiceStartDate() != null && exp.getExperienceTypeCode() != null  && exp.getExperienceTypeCode().equals(2)){
				%>							
				data_arr[<%= counter%>][122] = "<%=HMSUtil.getDateFormat(exp.getServiceStartDate(),"dd/MM/yyyy")%>";
				<%b1 = true;} %>
			
			
		<%	if(exp.getServiceEndDate() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(2)){
			%>
			data_arr[<%= counter%>][123] = "<%=HMSUtil.getDateFormat(exp.getServiceEndDate(),"dd/MM/yyyy")%>";
			<%b2=true;}%>
			
			<%if(exp.getExpYrs() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(2)){
			%>

			data_arr[<%= counter%>][124] = "<%=exp.getExpYrs()%>";
			<%b3=true;}%>
			
			<%if(exp.getExpMonths() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(2)){
			%>
			data_arr[<%= counter%>][125] = "<%=exp.getExpMonths()%>";
			<%b4=true;}%>

			<%if(exp.getPreviousEmployer() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(2)){
				%>					
				data_arr[<%= counter%>][126] = "<%=exp.getPreviousEmployer()%>";
				<%b5=true;}%>
			
			<% if(exp.getDesignation() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(2)){
				%>					
				data_arr[<%= counter%>][127] = "<%=exp.getDesignation()%>";
				<%b6=true;}%>
				
				<% if(exp.getAwards() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(2)){
					%>					
				data_arr[<%= counter%>][128] = "<%=exp.getAwards()%>";
				<%b7=true;}%>
					
				<%if(exp.getPreviousServiceEndReason() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(2)){
				%>	
				data_arr[<%= counter%>][129] = "<%=exp.getPreviousServiceEndReason()%>";
				<%b8=true;}%>
					
					<%if(exp.getPhoneNo() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(2)){
					%>					
					data_arr[<%= counter%>][130] = "<%=exp.getPhoneNo()%>";
					<%b9=true;}%>
												
					<%if(exp.getAddress() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(2)){
					%>					
					data_arr[<%= counter%>][131] = "<%=exp.getAddress()%>";
					<%b10=true;}%>
						
					<%if(exp.getSkills() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(2)){
					%>					
					data_arr[<%= counter%>][132] = "<%=exp.getSkills()%>";
					<%b11=true;}%>
					
					<%if(exp.getServiceStartDate() != null && exp.getExperienceTypeCode() != null  && exp.getExperienceTypeCode().equals(3)){
					%>							
					data_arr[<%= counter%>][133] = "<%=HMSUtil.getDateFormat(exp.getServiceStartDate(),"dd/MM/yyyy")%>";
					<%c1 = true;} %>
					
					
					<%if(exp.getServiceEndDate() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(3)){
					%>
					data_arr[<%= counter%>][134] = "<%=HMSUtil.getDateFormat(exp.getServiceEndDate(),"dd/MM/yyyy")%>";
					<%c2=true;}%>
					
					<%if(exp.getExpYrs() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(3)){
					%>
					data_arr[<%= counter%>][135] = "<%=exp.getExpYrs()%>";
					<%c3=true;}%>
						
					<%if(exp.getExpMonths() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(3)){
						%>
					data_arr[<%= counter%>][136] = "<%=exp.getExpMonths()%>";
					<%c4=true;}%>
					
					<%if(exp.getPreviousEmployer() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(3)){
						%>					
					data_arr[<%= counter%>][137] = "<%=exp.getPreviousEmployer()%>";
					<%c5=true;}%>
								
					<%if(exp.getDesignation() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(3)){
					%>					
					data_arr[<%= counter%>][138] = "<%=exp.getDesignation()%>";
					<%c6=true;}%>
					
					<% if(exp.getAwards() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(3)){
						%>					
					data_arr[<%= counter%>][139] = "<%=exp.getAwards()%>";
					<%c7=true;}%>
						
					<%if(exp.getPreviousServiceEndReason() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(3)){
					%>	
					data_arr[<%= counter%>][140] = "<%=exp.getPreviousServiceEndReason()%>";
					<%c8=true;}%>
					<%if(exp.getPhoneNo() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(3)){
						%>					
					data_arr[<%= counter%>][141] = "<%=exp.getPhoneNo()%>";
					<%c9=true;}%>
													
					<%if(exp.getAddress() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(3)){
					%>					
					data_arr[<%= counter%>][142] = "<%=exp.getAddress()%>";
					<%c10=true;}%>
					
					<%if(exp.getSkills() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(3)){
						%>					
					data_arr[<%= counter%>][143] = "<%=exp.getSkills()%>";
					<%c11=true;}%>	
					
					<%if(exp.getServiceStartDate() != null && exp.getExperienceTypeCode() != null  && exp.getExperienceTypeCode().equals(4)){
						%>							
					data_arr[<%= counter%>][144] = "<%=HMSUtil.getDateFormat(exp.getServiceStartDate(),"dd/MM/yyyy")%>";
					<%d1 = true;} %>
						
						
					<%if(exp.getServiceEndDate() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(4)){
					%>
					data_arr[<%= counter%>][145] = "<%=HMSUtil.getDateFormat(exp.getServiceEndDate(),"dd/MM/yyyy")%>";
					<%d2=true;}%>
						
						<%if(exp.getExpYrs() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(4)){
						%>
						data_arr[<%= counter%>][146] = "<%=exp.getExpYrs()%>";
						<%d3=true;}%>
							
						<%if(exp.getExpMonths() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(4)){
							%>
						data_arr[<%= counter%>][147] = "<%=exp.getExpMonths()%>";
						<%d4=true;}%>
						
						<%if(exp.getPreviousEmployer() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(4)){
							%>					
						data_arr[<%= counter%>][148] = "<%=exp.getPreviousEmployer()%>";
						<%d5=true;}%>
									
						<%if(exp.getDesignation() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(4)){
						%>					
						data_arr[<%= counter%>][149] = "<%=exp.getDesignation()%>";
						<%d6=true;}%>
						
						<% if(exp.getAwards() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(4)){
							%>					
						data_arr[<%= counter%>][150] = "<%=exp.getAwards()%>";
						<%d7=true;}%>
							
						<%if(exp.getPreviousServiceEndReason() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(4)){
						%>	
						data_arr[<%= counter%>][151] = "<%=exp.getPreviousServiceEndReason()%>";
						<%d8=true;}%>
						<%if(exp.getPhoneNo() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(4)){
							%>					
						data_arr[<%= counter%>][152] = "<%=exp.getPhoneNo()%>";
						<%d9=true;}%>
														
						<%if(exp.getAddress() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(4)){
						%>					
						data_arr[<%= counter%>][153] = "<%=exp.getAddress()%>";
						<%d10=true;}%>
						
						<%if(exp.getSkills() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(4)){
							%>					
						data_arr[<%= counter%>][154] = "<%=exp.getSkills()%>";
						<%d11=true;}%>	
						
						<%if(exp.getServiceStartDate() != null && exp.getExperienceTypeCode() != null  && exp.getExperienceTypeCode().equals(5)){
							%>							
						data_arr[<%= counter%>][155] = "<%=HMSUtil.getDateFormat(exp.getServiceStartDate(),"dd/MM/yyyy")%>";
						<%e1 = true;} %>
							
							
						<%if(exp.getServiceEndDate() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(5)){
							%>
						data_arr[<%= counter%>][156] = "<%=HMSUtil.getDateFormat(exp.getServiceEndDate(),"dd/MM/yyyy")%>";
						<%e2=true;}%>
							
						<%if(exp.getExpYrs() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(5)){
								%>
						data_arr[<%= counter%>][157] = "<%=exp.getExpYrs()%>";
							<%e3=true;}%>
									
						<%if(exp.getExpMonths() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(5)){
									%>
						data_arr[<%= counter%>][158] = "<%=exp.getExpMonths()%>";
							<%e4=true;}%>
							
							<%if(exp.getPreviousEmployer() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(5)){
								%>					
							data_arr[<%= counter%>][159] = "<%=exp.getPreviousEmployer()%>";
							<%e5=true;}%>
										
							<%if(exp.getDesignation() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(5)){
							%>					
							data_arr[<%= counter%>][160] = "<%=exp.getDesignation()%>";
							<%e6=true;}%>
							
							<% if(exp.getAwards() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(5)){
								%>					
							data_arr[<%= counter%>][161] = "<%=exp.getAwards()%>";
							<%e7=true;}%>

							<%if(exp.getPreviousServiceEndReason() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(5)){
								%>	
							data_arr[<%= counter%>][162] = "<%=exp.getPreviousServiceEndReason()%>";
							<%e8=true;}%>
							<%if(exp.getPhoneNo() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(5)){
								%>					
							data_arr[<%= counter%>][163] = "<%=exp.getPhoneNo()%>";
							<%e9=true;}%>
															
							<%if(exp.getAddress() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(5)){
							%>					
							data_arr[<%= counter%>][164] = "<%=exp.getAddress()%>";
							<%e10=true;}%>
							
							<%if(exp.getSkills() != null && exp.getExperienceTypeCode() != null && exp.getExperienceTypeCode().equals(5)){
								%>					
							data_arr[<%= counter%>][165] = "<%=exp.getSkills()%>";
							<%e11=true;}%>			
				<%}
}%>

<%if(!A1){%>
data_arr[<%= counter%>][35] = "";
<%}%>
<%if(!A2){%>
data_arr[<%= counter%>][36] = "";
<%}%>
<%if(!A3){%>
data_arr[<%= counter%>][37] = "";
<%}%>
<%if(!A4){%>
data_arr[<%= counter%>][38] = "";
<%}%>
<%if(!A5){%>
data_arr[<%= counter%>][39] = "";
<%}%>
<%if(!A6){%>
data_arr[<%= counter%>][40] = "";
<%}%>
<%if(!A7){%>
data_arr[<%= counter%>][41] = "";
<%}%>
<%if(!A8){%>
data_arr[<%= counter%>][42] = "";
<%}%>
<%if(!A9){%>
data_arr[<%= counter%>][43] = "";
<%}%>
<%if(!A10){%>
data_arr[<%= counter%>][44] = "";
<%}%>
<%if(!A11){%>
data_arr[<%= counter%>][45] = "";
<%}%>


<% if(!b1){%>
data_arr[<%= counter%>][122] = "";
<%}%>
<% if(!b2){%>
data_arr[<%= counter%>][123] = "";
<%}%>
<% if(!b3){%>
data_arr[<%= counter%>][124] = "";
<%}%>
<% if(!b4){%>
data_arr[<%= counter%>][125] = "";
<%}%>
<% if(!b5){%>
data_arr[<%= counter%>][126] = "";
<%}%>
<%if(!b6){%>
data_arr[<%= counter%>][127] = "";
<%}%>
<%if(!b7){%>
data_arr[<%= counter%>][128] = "";
<%}%>
<%if(!b8){%>
data_arr[<%= counter%>][129] = "";
<%}%>
<%if(!b9){%>
data_arr[<%= counter%>][130] = "";
<%}%>
<%if(!b10){%>
data_arr[<%= counter%>][131] = "";
<%}%>
<%if(!b11){%>
data_arr[<%= counter%>][132] = "";
<%}%>

<% if(!c1){%>
data_arr[<%= counter%>][133] = "";
<%}%>
<% if(!c2){%>
data_arr[<%= counter%>][134] = "";
<%}%>
<% if(!c3){%>
data_arr[<%= counter%>][135] = "";
<%}%>
<% if(!c4){%>
data_arr[<%= counter%>][136] = "";
<%}%>
<% if(!c5){%>
data_arr[<%= counter%>][137] = "";
<%}%>
<% if(!c6){%>
data_arr[<%= counter%>][138] = "";
<%}%>
<% if(!c7){%>
data_arr[<%= counter%>][139] = "";
<%}%>
<% if(!c8){%>
data_arr[<%= counter%>][140] = "";
<%}%>
<% if(!c9){%>
data_arr[<%= counter%>][141] = "";
<%}%>
<% if(!c10){%>
data_arr[<%= counter%>][142] = "";
<%}%>
<% if(!c11){%>
data_arr[<%= counter%>][143] = "";
<%}%>

<% if(!d1){%>
data_arr[<%= counter%>][144] = "";
<%}%>
<% if(!d2){%>
data_arr[<%= counter%>][145] = "";
<%}%>
<% if(!d3){%>
data_arr[<%= counter%>][146] = "";
<%}%>
<% if(!d4){%>
data_arr[<%= counter%>][147] = "";
<%}%>
<% if(!d5){%>
data_arr[<%= counter%>][148] = "";
<%}%>
<% if(!d6){%>
data_arr[<%= counter%>][149] = "";
<%}%>
<% if(!d7){%>
data_arr[<%= counter%>][150] = "";
<%}%>
<% if(!d8){%>
data_arr[<%= counter%>][151] = "";
<%}%>
<% if(!d9){%>
data_arr[<%= counter%>][152] = "";
<%}%>
<% if(!d10){%>
data_arr[<%= counter%>][153] = "";
<%}%>
<% if(!d11){%>
data_arr[<%= counter%>][154] = "";
<%}%>

<% if(!e1){%>
data_arr[<%= counter%>][155] = "";
<%}%>
<% if(!e2){%>
data_arr[<%= counter%>][156] = "";
<%}%>

<% if(!e3){%>
data_arr[<%= counter%>][157] = "";
<%}%>
<% if(!e4){%>
data_arr[<%= counter%>][158] = "";
<%}%>
<% if(!e5){%>
data_arr[<%= counter%>][159] = "";
<%}%>
<%if(!e6){%>
data_arr[<%= counter%>][160] = "";
<%}%>
<%if(!e7){%>
data_arr[<%= counter%>][161] = "";
<%}%>
<% if(!e8){%>
data_arr[<%= counter%>][162] = "";
<%}%>
<% if(!e9){%>
data_arr[<%= counter%>][163] = "";
<%}%>
<% if(!e10){%>
data_arr[<%= counter%>][164] = "";
<%}%>
<% if(!e11){%>
data_arr[<%= counter%>][165] = "";
<%}%>


<% 
if(masEmp.getUserManager()!=null && masEmp.getUserManager().size()!=0){

	Set userManSet = masEmp.getUserManager();
	
	List userManList = null;
	MasEmployee manager = null;
	if(userManSet!=null)
	{
		userManList = new ArrayList(userManSet);
		UserManager userManager = (UserManager)userManList.get(0);
		 manager = userManager.getManagers();
	
		 
	}
	
	for(MasEmployee emp : employeeList){
		//System.out.println(emp.getId()+" 6A "+manager);
		if(manager!=null && manager.getId() != null) {
			//System.out.println(emp.getId()+" 6Az "+manager.getId());
		
		if( manager.getId()!=null && (manager.getId().equals(emp.getId()) && emp.getStatus().equalsIgnoreCase("y"))){
			
		
		 %>
			data_arr[<%= counter%>][46] = "<%=emp.getFirstName()+" " +emp.getLastName() + " - "+ emp.getEmployeeCode()%>"
		<%}else if(manager!=null && manager.getId().equals(masEmp.getId()) && masEmp.getStatus().equals("n")){%>
			data_arr[<%= counter%>][46] = "<font id='error'>*</font>Parent InActivated--<%=emp.getFirstName()+" " +emp.getLastName() + " - "+ emp.getEmployeeCode()%>";
			
		<%}}else{%>
		data_arr[<%= counter%>][46] = "";
	<%}}
	
}else {%>
	data_arr[<%= counter%>][46] = ""
<%}%>

data_arr[<%= counter%>][47] = ""

<%if(masEmp.getProbationPeriod() !=null){%>
data_arr[<%= counter%>][48] = "<%=masEmp.getProbationPeriod()%>";
<%}else {%>
data_arr[<%= counter%>][48] = "";
<%}if(masEmp.getConfirmationDueDate() !=null){%>
data_arr[<%= counter%>][49] = "<%=HMSUtil.getDateFormat(masEmp.getConfirmationDueDate(),"dd/MM/yyyy")%>";
<%}else {%>
data_arr[<%= counter%>][49] = "";
<%}if(masEmp.getLastWorkingDay() !=null){%>
data_arr[<%= counter%>][50] = "<%=HMSUtil.getDateFormat(masEmp.getLastWorkingDay(),"dd/MM/yyyy")%>";
<%}else {%>
data_arr[<%= counter%>][50] = "";
<%}if(masEmp.getDateOfResignation() !=null){%>
data_arr[<%= counter%>][51] = "<%=HMSUtil.getDateFormat(masEmp.getDateOfResignation(),"dd/MM/yyyy")%>";
<%}else {%>
data_arr[<%= counter%>][51] = "";
<%}if(masEmp.getEquivalentDesignation() !=null){%>
data_arr[<%= counter%>][52] = "<%=masEmp.getEquivalentDesignation()%>";
<%}else {%>
data_arr[<%= counter%>][52] = "";
<%}if(masEmp.getGrade() !=null){

	//for(Object[] grade : gradeList){
		for(MasGrade grade : gradeList){
		//if(grade[0].equals(masEmp.getGrade().getId()) && grade[2].equals("y")){
			if(grade.getId().equals(masEmp.getGrade().getId()) && grade.getStatus().equalsIgnoreCase("y")){
		%>
			
			data_arr[<%= counter%>][53] = "<%=masEmp.getGrade().getGradeName()%>";
		
	<% }
		//else if(grade[0].equals(masEmp.getGrade().getId()) && grade[2].equals("n")){
			else if(grade.getId().equals(masEmp.getGrade().getId()) && grade.getStatus().equalsIgnoreCase("n")){
		%>
			data_arr[<%= counter%>][53] = "";
	<%}
}
}else {%>
data_arr[<%= counter%>][53] = "";
<%}if(masEmp.getPfNo() !=null){%>
data_arr[<%= counter%>][54] = "<%=masEmp.getPfNo()%>";
<%}else {%>
data_arr[<%= counter%>][54] = "";
<%}if(masEmp.getPaymentMode() !=null){%>
data_arr[<%= counter%>][55] = "<%=masEmp.getPaymentMode()%>";
<%}else {%>
data_arr[<%= counter%>][55] = "";
<%}%>
<%if(masEmp.getHospital() !=null){%>
data_arr[<%= counter%>][56] = "<%=masEmp.getHospital().getHospitalName()%>";
<%}else {%>
data_arr[<%= counter%>][56] = "";
<%}%>
<%if(masEmp.getHospital() !=null){%>
data_arr[<%= counter%>][57] = "<%=masEmp.getHospital().getHospitalName()%>";
<%}else {%>
data_arr[<%= counter%>][57] = "";
<%}%>

<%if(masEmp.getLineManager()!=null){%>
data_arr[<%= counter%>][58] = "<%=masEmp.getLineManager().getFirstName()+" "+masEmp.getLineManager().getLastName()%>";
<%}else {%>
data_arr[<%= counter%>][58] = "";
<%}%>

<%if(masEmp.getPersonalDetails()!=null && masEmp.getPersonalDetails().getPassportIssuePlace() != null){%>
data_arr[<%= counter%>][59] = "<%=masEmp.getPersonalDetails().getPassportIssuePlace()%>";
<%}else {%>
data_arr[<%= counter%>][59] = "";
<%}%>

  <% ///System.out.println("empEduca"+masEmp.getEmployeeEducation());
 // System.out.println("empEducation33333333333333333"+masEmp.getEmployeeEducation());
 
  Set<HrMasEmployeeEducation> empEducation = masEmp.getEmployeeEducation();
	//System.out.println("empEducation222222222222222222222>>"+empEducation);
    //Set<HrMasEmployeeEducation> sortedSet =  EmployeeEducationComparator.getEmployeeEducationTreeSet();
    //sortedSet.addAll(empEducation);
    boolean firstQualificationFound = false;
    boolean secondQualificationFound = false;
    boolean thirdQualificationFound = false;
    boolean fourQualificationFound = false;
    boolean fiveQualificationFound = false;

    boolean firstCourseFound = false;
    boolean secondCourseFound = false;
    boolean thirdCourseFound = false;
    boolean fourCourseFound = false;
    boolean fiveCourseFound = false;

    boolean firstSplQualificationFound = false;
    boolean secondSplQualificationFound = false;
    boolean thirdSplQualificationFound = false;
    boolean fourSplQualificationFound = false;
    boolean fiveSplQualificationFound = false;

    boolean firstIntituteFound = false;
    boolean secondIntituteFound = false;
    boolean thirdIntituteFound = false;
    boolean fourIntituteFound = false;
    boolean fiveIntituteFound = false;

    boolean firstStartDateFound = false;
    boolean secondStartDateFound = false;
    boolean thirdStartDateFound = false;
    boolean fourStartDateFound = false;
    boolean fiveStartDateFound = false;

    boolean firstEndDateFound = false;
    boolean secondEndDateFound = false;
    boolean thirdEndDateFound = false;
    boolean fourEndDateFound = false;
    boolean fiveEndDateFound = false;

    boolean firstCourseDurationFound = false;
    boolean secondCourseDurationFound = false;
    boolean thirdCourseDurationFound = false;
    boolean fourCourseDurationFound = false;
    boolean fiveCourseDurationFound = false;

    boolean firstQualifiedDateFound = false;
    boolean secondQualifiedDateFound = false;
    boolean thirdQualifiedDateFound = false;
    boolean fourQualifiedDateFound = false;
    boolean fiveQualifiedDateFound = false;

    boolean firstAwardsFound = false;
    boolean secondAwardsFound = false;
    boolean thirdAwardsFound = false;
    boolean fourAwardsFound = false;
    boolean fiveAwardsFound = false;

    boolean firstSkillDetailsFound = false;
    boolean secondSkillDetailsFound = false;
    boolean thirdSkillDetailsFound = false;
    boolean fourSkillDetailsFound= false;
    boolean fiveSkillDetailsFound = false;
	//System.out.println("empEducation>>"+empEducation);
	
	if(empEducation.size()>0){
	for(HrMasEmployeeEducation education : empEducation){
		for(HrMasQualification qualification : qualificationList){
			
			
			if(education.getQualification() != null && qualification.getId().equals(education.getQualification().getId()) 
					&& education.getEducationTypeCode().equals(1) ){ %>
				data_arr[<%= counter%>][60] = "<%=qualification.getQualificationName()%>";
			<%	firstQualificationFound = true;
			}if(education.getQualification() != null && qualification.getId().equals(education.getQualification().getId())
				&& education.getEducationTypeCode().equals(2)){%>
				data_arr[<%= counter%>][61] = "<%=qualification.getQualificationName()%>";
			<%	secondQualificationFound = true;
			} 
			//System.out.println(education.getQualification()+"   "+qualification.getId()+" "+education.getQualification().getId()+" "+education.getEducationTypeCode());
			if(education.getQualification() != null && qualification.getId().equals(education.getQualification().getId()) 
				&& education.getEducationTypeCode().equals(3)){ %>
				data_arr[<%= counter%>][62] = "<%=qualification.getQualificationName()%>";
			<%	thirdQualificationFound = true;
			} 
			
			if(education.getQualification() != null && qualification.getId().equals(education.getQualification().getId()) 
					&& education.getEducationTypeCode().equals(4)){ %>
					data_arr[<%= counter%>][100] = "<%=qualification.getQualificationName()%>";
				<%	fourQualificationFound = true;
				} 
			if(education.getQualification() != null && qualification.getId().equals(education.getQualification().getId()) 
					&& education.getEducationTypeCode().equals(5)){ %>
					data_arr[<%= counter%>][101] = "<%=qualification.getQualificationName()%>";
				<%	fiveQualificationFound = true;
				} 
	}
	for(HrMasCourse course : coursesList){//put null codition first of all
			if(education.getCourse() != null && course.getId().equals(education.getCourse().getId()) 
					&& education.getEducationTypeCode().equals(1)){ %>
				data_arr[<%= counter%>][63] = "<%=course.getCourseName()%>";
			<%	firstCourseFound = true;
			} 
			if(education.getCourse() != null && course.getId().equals(education.getCourse().getId()) 
				&& education.getEducationTypeCode().equals(2)){%>
				data_arr[<%= counter%>][64] = "<%=course.getCourseName()%>";
			<%	secondCourseFound = true;
			} 
			
			if(education.getCourse() != null && course.getId().equals(education.getCourse().getId()) 
				&& education.getEducationTypeCode().equals(3)){ %>
				data_arr[<%= counter%>][65] = "<%=course.getCourseName()%>";
			<%	thirdCourseFound = true;
			} 
			
			if(education.getCourse() != null && course.getId().equals(education.getCourse().getId()) 
					&& education.getEducationTypeCode().equals(4)){ %>
					data_arr[<%= counter%>][102] = "<%=course.getCourseName()%>";
				<%	fourCourseFound = true;
				}
			
			if(education.getCourse() != null && course.getId().equals(education.getCourse().getId()) 
					&& education.getEducationTypeCode().equals(5)){ %>
					data_arr[<%= counter%>][103] = "<%=course.getCourseName()%>";
				<%	fiveCourseFound = true;
				}
	}
	
	

	if(education.getSplQualification() != null && education.getEducationTypeCode() != null && education.getEducationTypeCode().equals(1)){ %>
	data_arr[<%= counter%>][66] = "<%=education.getSplQualification()%>";
<%	firstSplQualificationFound = true;
}
if(education.getSplQualification() != null && education.getEducationTypeCode() != null && education.getEducationTypeCode().equals(2)){%>
	data_arr[<%= counter%>][67] = "<%=education.getSplQualification()%>";
<%	secondSplQualificationFound = true;
}
if(education.getSplQualification() != null && education.getEducationTypeCode() != null && education.getEducationTypeCode().equals(3)){ %>
	data_arr[<%= counter%>][68] = "<%=education.getSplQualification()%>";
<%	thirdSplQualificationFound = true;
}

if(education.getSplQualification() != null && education.getEducationTypeCode() != null && education.getEducationTypeCode().equals(4)){ %>
data_arr[<%= counter%>][104] = "<%=education.getSplQualification()%>";
<%	fourSplQualificationFound = true;
}

if(education.getSplQualification() != null && education.getEducationTypeCode() != null && education.getEducationTypeCode().equals(5)){ %>
data_arr[<%= counter%>][105] = "<%=education.getSplQualification()%>";
<%	fiveSplQualificationFound = true;
}



	
	for(HrMasInstitute institute : institutesList){
			if(education.getInstitute() != null && institute.getId().equals(education.getInstitute().getId()) 
					&& education.getEducationTypeCode().equals(1)){ %>
				data_arr[<%= counter%>][69] = "<%=institute.getInstituteName()%>";
			<%	firstIntituteFound = true;
			} 
			if(education.getInstitute() != null && institute.getId().equals(education.getInstitute().getId()) 
				&& education.getEducationTypeCode().equals(2)){%>
				data_arr[<%= counter%>][70] = "<%=institute.getInstituteName()%>";
			<%	secondIntituteFound = true;
			} 
			if(education.getInstitute() != null && institute.getId().equals(education.getInstitute().getId()) 
				&& education.getEducationTypeCode().equals(3)){ %>
				data_arr[<%= counter%>][71] = "<%=institute.getInstituteName()%>";
			<%	thirdIntituteFound = true;
			} 
			
			if(education.getInstitute() != null && institute.getId().equals(education.getInstitute().getId()) 
					&& education.getEducationTypeCode().equals(4)){ %>
					data_arr[<%= counter%>][106] = "<%=institute.getInstituteName()%>";
				<%	fourIntituteFound = true;
				} 
			
			if(education.getInstitute() != null && institute.getId().equals(education.getInstitute().getId()) 
					&& education.getEducationTypeCode().equals(5)){ %>
					data_arr[<%= counter%>][107] = "<%=institute.getInstituteName()%>";
				<%	fourIntituteFound = true;
				}
	}
	
	
	if(education.getStartDate() != null && education.getEducationTypeCode().equals(1)){ %>
		data_arr[<%= counter%>][72] = "<%=HMSUtil.getDateFormat(education.getStartDate(),"dd/MM/yyyy")%>";
	<%	firstStartDateFound = true;
	}
	if(education.getStartDate() != null && education.getEducationTypeCode().equals(2)){%>
		data_arr[<%= counter%>][73] = "<%=HMSUtil.getDateFormat(education.getStartDate(),"dd/MM/yyyy")%>";
	<%	secondStartDateFound = true;
	}
	if(education.getStartDate() != null && education.getEducationTypeCode().equals(3)){ %>
		data_arr[<%= counter%>][74] = "<%=HMSUtil.getDateFormat(education.getStartDate(),"dd/MM/yyyy")%>";
	<%	thirdStartDateFound = true;
	}
	
	if(education.getStartDate() != null && education.getEducationTypeCode().equals(4)){ %>
	data_arr[<%= counter%>][108] = "<%=HMSUtil.getDateFormat(education.getStartDate(),"dd/MM/yyyy")%>";
	<%	fourStartDateFound = true;
	}
	
	if(education.getStartDate() != null && education.getEducationTypeCode().equals(5)){ %>
	data_arr[<%= counter%>][109] = "<%=HMSUtil.getDateFormat(education.getStartDate(),"dd/MM/yyyy")%>";
	<%	fiveStartDateFound = true;
	}
	

	if(education.getEndDate() != null && education.getEducationTypeCode().equals(1)){ %>
		data_arr[<%= counter%>][75] = "<%=HMSUtil.getDateFormat(education.getEndDate(),"dd/MM/yyyy")%>";
	<%	firstEndDateFound = true;
	}
	if(education.getEndDate() != null && education.getEducationTypeCode().equals(2)){%>
		data_arr[<%= counter%>][76] = "<%=HMSUtil.getDateFormat(education.getEndDate(),"dd/MM/yyyy")%>";
	<%	secondEndDateFound = true;
	}
	if(education.getEndDate() != null && education.getEducationTypeCode().equals(3)){ %>
		data_arr[<%= counter%>][77] = "<%=HMSUtil.getDateFormat(education.getEndDate(),"dd/MM/yyyy")%>";
	<%	thirdEndDateFound = true;
	}
	
	if(education.getEndDate() != null && education.getEducationTypeCode().equals(4)){ %>
	data_arr[<%= counter%>][110] = "<%=HMSUtil.getDateFormat(education.getEndDate(),"dd/MM/yyyy")%>";
	<%	fourEndDateFound = true;
	}
	
	if(education.getEndDate() != null && education.getEducationTypeCode().equals(5)){ %>
	data_arr[<%= counter%>][111] = "<%=HMSUtil.getDateFormat(education.getEndDate(),"dd/MM/yyyy")%>";
	<%	fiveEndDateFound = true;
	}
	

	if(education.getCourseDuration() != null && education.getEducationTypeCode().equals(1)){ %>
		data_arr[<%= counter%>][78] = "<%=education.getCourseDuration()%>";
	<%	firstCourseDurationFound = true;
	}
	if(education.getCourseDuration() != null && education.getEducationTypeCode().equals(2)){%>
		data_arr[<%= counter%>][79] = "<%=education.getCourseDuration()%>";
	<%	secondCourseDurationFound = true;
	}
	if(education.getCourseDuration() != null && education.getEducationTypeCode().equals(3)){ %>
		data_arr[<%= counter%>][80] = "<%=education.getCourseDuration()%>";
	<%	thirdCourseDurationFound = true;
	}
	
	if(education.getCourseDuration() != null && education.getEducationTypeCode().equals(4)){ %>
	data_arr[<%= counter%>][112] = "<%=education.getCourseDuration()%>";
	<%	fourCourseDurationFound = true;
	}
	
	if(education.getCourseDuration() != null && education.getEducationTypeCode().equals(5)){ %>
	data_arr[<%= counter%>][113] = "<%=education.getCourseDuration()%>";
	<%	fiveCourseDurationFound = true;
	}
	


	if(education.getQualifiedDate() != null && education.getEducationTypeCode().equals(1)){ %>
		data_arr[<%= counter%>][81] = "<%=HMSUtil.getDateFormat(education.getQualifiedDate(),"dd/MM/yyyy")%>";
	<%	firstQualifiedDateFound = true;
	}
	if(education.getQualifiedDate() != null && education.getEducationTypeCode().equals(2)){%>
		data_arr[<%= counter%>][82] = "<%=HMSUtil.getDateFormat(education.getQualifiedDate(),"dd/MM/yyyy")%>";
	<%	secondQualifiedDateFound = true;
	}
	if(education.getQualifiedDate() != null && education.getEducationTypeCode().equals(3)){ %>
		data_arr[<%= counter%>][83] = "<%=HMSUtil.getDateFormat(education.getQualifiedDate(),"dd/MM/yyyy")%>";
	<%	thirdQualifiedDateFound = true;
	}
	
	if(education.getQualifiedDate() != null && education.getEducationTypeCode().equals(4)){ %>
	data_arr[<%= counter%>][114] = "<%=HMSUtil.getDateFormat(education.getQualifiedDate(),"dd/MM/yyyy")%>";
	<%	fourQualifiedDateFound = true;
	}
	
	if(education.getQualifiedDate() != null && education.getEducationTypeCode().equals(5)){ %>
	data_arr[<%= counter%>][115] = "<%=HMSUtil.getDateFormat(education.getQualifiedDate(),"dd/MM/yyyy")%>";
	<%	fiveQualifiedDateFound = true;
	}


	if(education.getAwards() != null && education.getEducationTypeCode() != null && education.getEducationTypeCode().equals(1)){ %>
		data_arr[<%= counter%>][84] = "<%=education.getAwards()%>";
	<%	firstAwardsFound = true;
	}
	if(education.getAwards() != null && education.getEducationTypeCode() != null && education.getEducationTypeCode().equals(2)){%>
		data_arr[<%= counter%>][85] = "<%=education.getAwards()%>";
	<%	secondAwardsFound = true;
	}
	if(education.getAwards() != null && education.getEducationTypeCode() != null && education.getEducationTypeCode().equals(3)){ %>
		data_arr[<%= counter%>][86] = "<%=education.getAwards()%>";
	<%	thirdAwardsFound = true;
	}
	
	if(education.getAwards() != null && education.getEducationTypeCode() != null && education.getEducationTypeCode().equals(4)){ %>
	data_arr[<%= counter%>][116] = "<%=education.getAwards()%>";
	<%	fourAwardsFound = true;
	}
	if(education.getAwards() != null && education.getEducationTypeCode() != null && education.getEducationTypeCode().equals(5)){ %>
	data_arr[<%= counter%>][117] = "<%=education.getAwards()%>";
	<%	fiveAwardsFound = true;
	}
	
	
	//System.out.println("education.getSkillDetails()>>>>>>>>"+education.getSkillDetails());
	if(education.getSkillDetails() != null && education.getEducationTypeCode() != null && education.getEducationTypeCode().equals(1)){ %>
		data_arr[<%= counter%>][87] = "<%=education.getSkillDetails()%>";
	<%	firstSkillDetailsFound = true;
	}
	if(education.getSkillDetails() != null && education.getEducationTypeCode() != null && education.getEducationTypeCode().equals(2)){%>
		data_arr[<%= counter%>][88] = "<%=education.getSkillDetails()%>";
	<%	secondSkillDetailsFound = true;
	}
	if(education.getSkillDetails() != null && education.getEducationTypeCode() != null && education.getEducationTypeCode().equals(3)){ %>
		data_arr[<%= counter%>][89] = "<%=education.getSkillDetails()%>";
	<%	thirdSkillDetailsFound = true;
	}
	
	if(education.getSkillDetails() != null && education.getEducationTypeCode() != null && education.getEducationTypeCode().equals(4)){ %>
	data_arr[<%= counter%>][118] = "<%=education.getSkillDetails()%>";
	<%	fourSkillDetailsFound = true;
	}
	
	if(education.getSkillDetails() != null && education.getEducationTypeCode() != null && education.getEducationTypeCode().equals(5)){ %>
	data_arr[<%= counter%>][119] = "<%=education.getSkillDetails()%>";
	<%	fiveSkillDetailsFound = true;
	}

	
	
	
	} }
	if(!firstQualificationFound){ %>
		data_arr[<%= counter%>][60] = "";
	<%}if(!secondQualificationFound){ %>
		data_arr[<%= counter%>][61] = "";
	<%}if(!thirdQualificationFound){ %>
		data_arr[<%= counter%>][62] = "";
		<%}if(!fourQualificationFound){ %>
		data_arr[<%= counter%>][100] = "";
	<%}if(!fiveQualificationFound){ %>
		data_arr[<%= counter%>][101] = "";

		

	<%}if(!firstCourseFound){ %>
		data_arr[<%= counter%>][63] = "";
	<%}if(!secondCourseFound){ %>
		data_arr[<%= counter%>][64] = "";
	<%}if(!thirdCourseFound){ %>
		data_arr[<%= counter%>][65] = "";
		<%}if(!fourCourseFound){ %>
		data_arr[<%= counter%>][102] = "";
	<%}if(!fiveCourseFound){ %>
		data_arr[<%= counter%>][103] = "";
		

	<%}if(!firstSplQualificationFound){ %>
		data_arr[<%= counter%>][66] = "";
	<%}if(!secondSplQualificationFound){ %>
		data_arr[<%= counter%>][67] = "";
	<%}if(!thirdSplQualificationFound){ %>
		data_arr[<%= counter%>][68] = "";
		<%}if(!fourSplQualificationFound){ %>
		data_arr[<%= counter%>][104] = "";
	<%}if(!fiveSplQualificationFound){ %>
		data_arr[<%= counter%>][105] = "";

		

	<%}if(!firstIntituteFound){ %>
		data_arr[<%= counter%>][69] = "";
	<%}if(!secondIntituteFound){ %>
		data_arr[<%= counter%>][70] = "";
	<%}if(!thirdIntituteFound){ %>
		data_arr[<%= counter%>][71] = "";
		<%}if(!fourIntituteFound){ %>
		data_arr[<%= counter%>][106] = "";
	<%}if(!fiveIntituteFound){ %>
		data_arr[<%= counter%>][107] = "";

		

	<%}if(!firstStartDateFound){ %>
		data_arr[<%= counter%>][72] = "";
	<%}if(!secondStartDateFound){ %>
		data_arr[<%= counter%>][73] = "";
	<%}if(!thirdStartDateFound){ %>
		data_arr[<%= counter%>][74] = "";
	<%}if(!fourStartDateFound){ %>
		data_arr[<%= counter%>][108] = "";
	<%}if(!fiveStartDateFound){ %>
		data_arr[<%= counter%>][109] = "";

		

	<%}if(!firstEndDateFound){ %>
		data_arr[<%= counter%>][75] = "";
	<%}if(!secondEndDateFound){ %>
		data_arr[<%= counter%>][76] = "";
	<%}if(!thirdEndDateFound){ %>
		data_arr[<%= counter%>][77] = "";
	<%}if(!fourEndDateFound){ %>
		data_arr[<%= counter%>][110] = "";
	<%}if(!fiveEndDateFound){ %>
		data_arr[<%= counter%>][111] = "";

		

	<%}if(!firstCourseDurationFound){ %>
		data_arr[<%= counter%>][78] = "";
	<%}if(!secondCourseDurationFound){ %>
		data_arr[<%= counter%>][79] = "";
	<%}if(!thirdCourseDurationFound){ %>
		data_arr[<%= counter%>][80] = "";
	<%}if(!fourCourseDurationFound){ %>
		data_arr[<%= counter%>][112] = "";
	<%}if(!fiveCourseDurationFound){ %>
		data_arr[<%= counter%>][113] = "";

	<%}if(!firstQualifiedDateFound){ %>
		data_arr[<%= counter%>][81] = "";
	<%}if(!secondQualifiedDateFound){ %>
		data_arr[<%= counter%>][82] = "";
	<%}if(!thirdQualifiedDateFound){ %>
		data_arr[<%= counter%>][83] = "";
	<%}
	if(!fourQualifiedDateFound){ %>
	data_arr[<%= counter%>][114] = "";
	<%}
	if(!fiveQualifiedDateFound){ %>
	data_arr[<%= counter%>][115] = "";
<%}

	if(!firstAwardsFound){ %>
		data_arr[<%= counter%>][84] = "";
	<%}if(!secondAwardsFound){ %>
		data_arr[<%= counter%>][85] = "";
	<%}if(!thirdAwardsFound){ %>
		data_arr[<%= counter%>][86] = "";
	<%}if(!fourAwardsFound){ %>
		data_arr[<%= counter%>][116] = "";
	<%}if(!fiveAwardsFound){ %>
		data_arr[<%= counter%>][117] = "";
	<%}

	if(!firstSkillDetailsFound){ %>
		data_arr[<%= counter%>][87] = "";
	<%}if(!secondSkillDetailsFound){ %>
		data_arr[<%= counter%>][88] = "";
	<%}if(!thirdSkillDetailsFound){ %>
		data_arr[<%= counter%>][89] = "";
	<%}if(!fourSkillDetailsFound){ %>
		data_arr[<%= counter%>][118] = "";
	<%}if(!fiveSkillDetailsFound){ %>
		data_arr[<%= counter%>][119] = "";
	<%}

if(masEmp.getHandicapStatus()!=null){%>
	data_arr[<%= counter%>][90] = "<%=masEmp.getHandicapStatus()%>";
<%}else {%>
	data_arr[<%= counter%>][90] = "";
<%}%>

<%if(masEmp.getInsuranceType()!=null){%>
	data_arr[<%= counter%>][91] = "<%=masEmp.getInsuranceType()%>";
<%}else {%>
	data_arr[<%= counter%>][91] = "";
<%}%>

<%if(masEmp.getInsuranceCompany()!=null){%>
	data_arr[<%= counter%>][92] = "<%=masEmp.getInsuranceCompany()%>";
<%}else {%>
	data_arr[<%= counter%>][92] = "";
<%}%>

<%if(masEmp.getInsuranceStartDate()!=null){%>
	data_arr[<%= counter%>][93] = "<%=HMSUtil.getDateFormat(masEmp.getInsuranceStartDate(),"dd/MM/yyyy")%>";
<%}else {%>
	data_arr[<%= counter%>][93] = "";
<%}%>

<%if(masEmp.getInsuranceEndDate()!=null){%>
	data_arr[<%= counter%>][94] = "<%=HMSUtil.getDateFormat(masEmp.getInsuranceEndDate(),"dd/MM/yyyy")%>";
<%}else {%>
	data_arr[<%= counter%>][94] = "";
<%}%>

<%if(masEmp.getMedicalRemarks()!=null){%>
	data_arr[<%= counter%>][95] = "<%=masEmp.getMedicalRemarks()%>";
<%}else {%>
	data_arr[<%= counter%>][95] = "";
<%}%>
<%--
<%if(masEmp.getEmployeeExperience() != null 
		&& masEmp.getEmployeeExperience().getSkills()!=null){%>
	data_arr[<%= counter%>][96] = "<%=masEmp.getEmployeeExperience().getSkills()%>";
<%}else {%>
	data_arr[<%= counter%>][96] = "";
<%}%>
--%>
data_arr[<%= counter%>][96] = "";
<%if(masEmp.getFatherHusbandName()!= null){%>
data_arr[<%= counter%>][97] = "<%=masEmp.getFatherHusbandName()%>";
<%}else{%>
data_arr[<%= counter%>][97] = "";
<%}%>

<%if(masEmp.getEmployeeCode()!= null){%>
data_arr[<%= counter%>][98] = "<%=masEmp.getEmployeeCode()%>";
<%}else{%>
data_arr[<%= counter%>][98] = "";
<%}%>


							
<%if(masEmp.getEmpReligion()!= null){%>
data_arr[<%= counter%>][120] = "<%=masEmp.getEmpReligion().getReligionName()%>";
<%}else{%>
data_arr[<%= counter%>][120] = "";
<%}%>

<%if(masEmp.getPremium()!= null){%>
data_arr[<%= counter%>][121] = "<%=masEmp.getPremium()%>";
<%}else{%>
data_arr[<%= counter%>][121] = "";
<%}%>



							
<% if(masEmp.getMiddleName() != null){%>
data_arr[<%= counter%>][166] ="<%=masEmp.getMiddleName()%>"
<%}else{%>
data_arr[<%= counter%>][166] =""
<%}%>

<%if(masEmp.getPEN() != null){%>
data_arr[<%= counter%>][167] ="<%=masEmp.getPEN()%>"
<%}else{%>
data_arr[<%= counter%>][167] =""
<%}%>

<%if(masEmp.getBankBranch() != null){%>
data_arr[<%= counter%>][168] ="<%=masEmp.getBankBranch()%>"
<%}else{%>
data_arr[<%= counter%>][168] =""
<%}%>

<%if(masEmp.getIfscCode() != null){%>
data_arr[<%= counter%>][169] ="<%=masEmp.getIfscCode()%>"
<%}else{%>
data_arr[<%= counter%>][169] =""
<%}%>
	
<%counter++;
}
%>
formName = "employee"

nonEditable = ['<%= EMPLOYEE_CODE%>']
 
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
	
	
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');
</script>	

<script>
function generateReport()
{
parent.location='hospital?method=generateReportForHospitalRelatedMasters';
} 

function changeClass(title,t)
{
animatedcollapse.toggle(title,t);
}

function changePrimary()
{
	var primary = document.getElementById('primarySkills');
	var secondary = document.getElementById('secondarySkills');
	var j=0;
	for(var i=secondary.options.length-1;i>=0;i--)
	{
	secondary.remove(i);
	}
	for(var i=0;i<primary.options.length;i++)
	{
	if(primary.options[i].selected)
	{
	<%for(Resumeskillmaster skillmaster: skillMasterList)
	{%>
	if(primary.options[i].value==<%=skillmaster.getSkillParent()%>)
	{
	secondary.options[j]=new Option(' <%=skillmaster.getSkillDesc()%>','<%=skillmaster.getId()%>', false, false);
	j=j+1;
	}
	<%}%>
	}
	}
	}

function disableTextFields(rbId)
{
	
	if(document.getElementById(rbId).checked == 'true')
	{
		
		if(document.getElementById(rbId).value=='1')
		{
			document.getElementById('coursesName').setAttribute(disabled , 'false');
			document.getElementById('qualification').setAttribute(disabled , 'false');
			document.getElementById('splQualification').setAttribute(disabled , 'false');
		}
		if(document.getElementById(rbId) =='2')
		{
			document.getElementById('coursesName').setAttribute(disabled , 'disabled');
			document.getElementById('qualification').setAttribute(disabled , 'false');
			document.getElementById('splQualification').setAttribute(disabled , 'disabled');
			
		}
		if(document.getElementById(rbId).value=='3')
		{
			document.getElementById('coursesName').setAttribute(disabled , 'disabled');
			document.getElementById('qualification').setAttribute(disabled , 'disabled');
			document.getElementById('splQualification').setAttribute(disabled , 'false');
		}
	}
}


function populateField(idvalue)
{ 
	//document.employee.reset();

	<%
	for(Resumepersonaldetails joinedCandidate  : joinedCandidates){
		int id = joinedCandidate.getId();
		//int balance = (Integer.parseInt(hrEmployeeBalance.getEarned()));
		//int balanceId = hrEmployeeBalance.getId();
	%>
	
		if(idvalue == <%=id%> ){
			
			document.getElementById('firstName').value = '<%= joinedCandidate.getFirstName()%>';
	    	document.getElementById('lastName').value = '<%= joinedCandidate.getLastName() != null ? joinedCandidate.getLastName() :""%>';
	    	document.getElementById('emailId').value = '<%= joinedCandidate.getEmailId() != null ? joinedCandidate.getEmailId() :""%>';
	    	document.getElementById('mobile').value = '<%=joinedCandidate.getMobile() != null ? joinedCandidate.getMobile() :""%>';
	    	document.getElementById('officePhone').value = '<%=joinedCandidate.getOtherPhone() != null ? joinedCandidate.getOtherPhone() :""%>';
	    	document.getElementById('previousEmployer').value = '<%= joinedCandidate.getPreviousEmployer() != null ? joinedCandidate.getPreviousEmployer() : "" %>';	    	
	    	document.getElementById('joinId').value =serverdate;
	    	document.getElementById('appointmentId').value = '<%= joinedCandidate.getResumeStatus().getDateOfJoin()  != null ? joinedCandidate.getResumeStatus().getDateOfJoin() : ""  %>';
	    	<%-- document.getElementById('<%=PROBATION_PERIOD%>').value = '<%= joinedCandidate.getResumeStatus().getProbationPeriod() != null ? joinedCandidate.getResumeStatus().getProbationPeriod() : "" %>'; --%>
	    	document.getElementById('empStatusId').value ='1';
	    
	   		<%-- document.getElementById('employeeType').value = '<%=joinedCandidate.getResourceRequisition().getEmployeeType().getId()%>'; --%>
	    	document.getElementById('departmentId').value = '<%=joinedCandidate.getResourceRequisition().getDepartment().getId()%>';
	   		document.getElementById('dateOfBirth').value = '<%=joinedCandidate.getDateOfBirth() != null ? joinedCandidate.getDateOfBirth() : ""%>';
	    	document.getElementById('passportNumber').value = '<%=joinedCandidate.getPassportNo() != null ? joinedCandidate.getPassportNo() : ""%>';
	    	document.getElementById('passportExpiryDate').value = '<%=joinedCandidate.getPassportExpiryDate() != null ? joinedCandidate.getPassportExpiryDate() : ""%>';	
	  		document.getElementById('rankId').value = '<%=joinedCandidate.getResumeStatus().getDesignation().getId()%>'
	  		
	  	
	    }
		if(idvalue == "" ){
			
	    	document.getElementById('firstName').value = '';
	    	document.getElementById('lastName').value = '';
	    	document.getElementById('emailId').value = '';
	    	document.getElementById('mobile').value = '';
	    	document.getElementById('officePhone').value = '';
	    	document.getElementById('previousEmployer').value = '';
	    	document.getElementById('joinId').value=serverdate;
	    	document.getElementById('appointmentId').value = '';
	    	document.getElementById('<%=PROBATION_PERIOD%>').value = '';
	    	document.getElementById('empStatusId').value ='0';
	    	document.getElementById('employeeType').value = '0';
	    	document.getElementById('designation').value = '';
	    	document.getElementById('departmentId').value = '0';
	    	document.getElementById('dateOfBirth').value = '';
	    	document.getElementById('passportNumber').value = '';
	    	document.getElementById('passportExpiryDate').value = '';
	    	document.getElementById('rankId').value = '0'
		}
		
	<%
	}
	%>
}

function removeNewLine(obj){
/***** Firefox only needs this line *****/

document.getElementById(obj.id).value = document.getElementById(obj.id).value.replace(/\n/g,' ');

/***** IE and Opera need this line also *****/
                     
document.getElementById(obj.id).value=document.getElementById(obj.id).value.replace(/\s/g,' ').replace(/  ,/g,' ');  
}

function removeLine()
{
removeNewLine(document.getElementById("<%=EMPLOYEE_PERMANENT_ADDRESS%>"));
removeNewLine(document.getElementById("<%=EMPLOYEE_RESIDENTIAL_ADDRESS%>"));
}
document.employee.onsubmit = removeLine();
</script>
<script>


function disableMariageDate(){
	var mrg = document.getElementById('MARITAL_STATUS_ID').value;
	var mrg1 = document.employee.maritalStatusId.options[mrg].text
	if(mrg1 =="Single"){
		document.getElementById('mrg').style.display = "none";
	}else{
		document.getElementById('mrg').style.display = "block";
	}
	
}


function showFields(obj){
	
	//subordinateList('employee');
	
	document.getElementById('lastWorkDay').style.display = "none";
	document.getElementById('dateOfResig').style.display = "none";
	
	if(obj.value!="0" && obj.value == 3)
	{
	document.getElementById('lastWorkDay').style.display = "block";
	document.getElementById('dateOfResig').style.display = "block";
	document.getElementById('lwp').style.display = "none";
	}
	else if(obj.value!="0" && obj.value != 1)
	{
	document.getElementById('lastWorkDay').style.display = "block";
	document.getElementById('<%=DATE_OF_RESIGNATION%>').value = "";
	document.getElementById('lwp').style.display = "none";
	}
	else if(obj.value!="0" || obj.value == 1)
	{
	document.getElementById('<%=LAST_WORKING_DAY%>').value = "";
	document.getElementById('<%=DATE_OF_RESIGNATION%>').value = "";
	document.getElementById('lwp').style.display = "none";
	}
	 if(obj.value == 7)
	{
	document.getElementById('lwp').style.display = "block";
	
	}
	
}

function subordinateList(formName){
		
		obj1 = eval('document.'+formName+'.<%=COMMON_ID%>');
		
		empId = obj1.value;
		url="/erp/erp/personnel?method=getsubordinateList&empId="+empId;
		retrieveUrl1(url);	
 }
   
var request = false;
function retrieveUrl1(url){
   try {
     request = new XMLHttpRequest();
   } catch (trymicrosoft) {
     try {
       request = new ActiveXObject("Msxml2.XMLHTTP");
     } catch (othermicrosoft) {
       try {
         request = new ActiveXObject("Microsoft.XMLHTTP");
       } catch (failed) {
         request = false;
       }  
     }
   }
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	 request.open("GET", url, true);
     request.onreadystatechange = updatePage1;
     request.send(null);
     
   if (!request)
     alert("Error initializing XMLHttpRequest!");

}

function updatePage1() {
    if ((request.readyState == 4) && (request.status == 200)) { 
				
		    		document.getElementById('responseList').innerHTML = request.responseText;
		    		document.getElementById('responseList').style.display = 'block';
		   }
}
   

function refreshPage()
{
document.location.href = 'personnel?method=showEmployeeJsp';
}

function populateConfirmationDueDate(obj)
{
	probationPeriod = obj.value;
	probationPeriod = ((probationPeriod == 12)?365 : 183);
	actualJoiningDate = document.getElementById('joinId').value ; 
	
	var myDate = new Date();
	myDate.setFullYear(actualJoiningDate.substring(6,10),actualJoiningDate.substring(3,5),actualJoiningDate.substring(0,2));
	myDate.setDate(myDate.getDate()+probationPeriod);
	
	
	dd=((myDate.getDate().toString()).length==1)? '0'+myDate.getDate().toString() :myDate.getDate()
	mm =((myDate.getMonth().toString()).length==1)? '0'+myDate.getMonth().toString() :myDate.getMonth()
	myDate = dd + '/' + mm + '/' + (1900+parseInt(myDate.getYear()));
	document.getElementById('<%=CONFIRMATION_DUE_DATE%>').value = myDate;
	
}

function showHideLineManager(obj){
   
    	var checkedLinemanager = obj.value;
    	if(checkedLinemanager == 'm'){
    		document.getElementById('divSetManager').style.display='block';
    		
    	}else{
    		document.getElementById('divSetManager').style.display='none';
    		
    	}
    }

function duplicateCodeNo(val)
{
	if(val.length==6){
		ajaxDuplicateCodeNo('employee','personnel?method=getEmployeeCode&empCode=' +  val );
	}/* else{
		alert("Employee code should be of 6 digits.")
		document.getElementById('employee_Code').value='';
	
	} */
}

function duplicateCardNo(val)
{
		ajaxDuplicateCardNo('employee','personnel?method=getEmployeeCard&empCard=' +  val );
}

function ajaxDuplicateCardNo(formName,action)
{
  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
    	alert(e)
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }
    var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];

      	for (loop = 0; loop < items.childNodes.length; loop++)
      	{
	   	    var item = items.childNodes[loop];
	        var status  = item.getElementsByTagName("status")[0];
	       // alert("---status>>>"+status.childNodes[0].nodeValue)
	        if(status.childNodes[0].nodeValue == "yes"){
	        	alert("Employee card no allready Exist.");
	        	 document.getElementById('employeeCardNo').value="";
		        
		        return false;
	        }
	        
      }
    }
  }
}

function ajaxDuplicateCodeNo(formName,action)
{
  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
    	alert(e)
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }
    var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];

      	for (loop = 0; loop < items.childNodes.length; loop++)
      	{
	   	    var item = items.childNodes[loop];
	        var status  = item.getElementsByTagName("status")[0];
	       // alert("---status>>>"+status.childNodes[0].nodeValue)
	        if(status.childNodes[0].nodeValue == "yes"){
	        	alert("PEN allready Exist.");
	        	 document.getElementById('PEN').value="";
		        
		        return false;
	        }
	        
      }
    }
  }
}


function chkPan(val)
{
	if(val.length<10){
		alert("PAN No should be of 10 digits.")
		document.getElementById('panNO').value="";
	}
}


function addRow(){

	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  hdb.value=iteration


	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('Select');
	 // e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	 
	  e0.name = 'qualification1' + iteration;
	  e0.id = 'qualification1' + iteration;
	  e0.classname='smalllabel';
	  //e0.size = '20';
	  e0.setAttribute('tabindex','1');

	  e0.setAttribute('tabindex','1');
	  e0.options[0] = new Option('Select', '0');
	

	   for(var i = 0;i<icdArray.length;i++ ){
	      e0.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	      }
	  
	  
	  cellRight0.appendChild(e0);

	  
	  var cellRight3 = row.insertCell(1);
	  var e3= document.createElement('Select');
	 // e3.type = 'text';
	  e3.name='coursesName'+iteration;
	  e3.id='coursesName'+iteration
	  e3.classname='smalllabel';
	  e3.setAttribute('tabindex','1');
	  e3.options[0] = new Option('Select', '0');

	   for(var i = 0;i<icdArray1.length;i++ ){
	      e3.options[i+1] = new Option(icdArray1[i][1],icdArray1[i][0]);
	      }
	  cellRight3.appendChild(e3);


	  var cellRight4 = row.insertCell(2);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='splQualification'+iteration;
	  e4.id='splQualification'+iteration
	  e4.size='10';
	  e4.setAttribute('tabindex','1');
	  cellRight4.appendChild(e4);

	  var cellRight5 = row.insertCell(3);
	  var e5 = document.createElement('Select');
	  e5.name='institution'+iteration;
	  e5.id='institution'+iteration;
	  e5.classname='smalllabel';
	  e5.setAttribute('tabindex','1');
	  e5.options[0] = new Option('Select', '0');

	   for(var i = 0;i<icdArray2.length;i++ ){
	      e5.options[i+1] = new Option(icdArray2[i][1],icdArray2[i][0]);
	      }
	  cellRight5.appendChild(e5);

	 

	/*  var e5 = document.createElement('input');
	  e5.type = 'hidden';
	  e5.name='total'+iteration;
	  e5.id='total'+iteration;
	  e5.size='5';
	  e5.setAttribute('tabindex','1');
	  cellRight4.appendChild(e5);


	  // ****************** comment by javed

	  var cellRight6 = row.insertCell(6);
	  var e6 = document.createElement('Select');

	  e6.name='instructionACPC'+iteration;
	  e6.id='instructionACPC'+iteration;
	  e6.classname='smalllabel';
	  e6.setAttribute('tabindex','1');
	   e6.options[0] = new Option('Select', '');
	   e6.options[1] = new Option('AC', 'AC');
	   e6.options[2] = new Option('PC', 'PC');
	   cellRight6.appendChild(e6);


	  var cellRight7 = row.insertCell(7);
	   var e7 = document.createElement('Select');

	  e7.name='typeLeftRight'+iteration;
	  e7.id='typeLeftRight'+iteration;
	  e7.classname='smalllabel';
	  e7.setAttribute('tabindex','1');
	   e7.options[0] = new Option('Select', '');
	   e7.options[1] = new Option('Left', 'left');
	   e7.options[2] = new Option('Right', 'right');
	   cellRight7.appendChild(e7);*/

	  var cellRight6 = row.insertCell(4);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.name='duration'+iteration;
	  e6.id='coursesDuration'+iteration
	  e6.size='10';
	  e6.setAttribute('tabindex','1');
	  cellRight6.appendChild(e6);

	  var cellRight7 = row.insertCell(5);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name='awards'+iteration;
	  e7.id='awards'+iteration
	  e7.size='10';
	  e7.setAttribute('tabindex','1');
	  cellRight7.appendChild(e7);

	  var cellRight8 = row.insertCell(6);
	  var e8 = document.createElement('input');
	  e8.type = 'text';
	  e8.name='educationSkills'+iteration;
	  e8.id='educationSkills'+iteration
	  e8.size='10';
	  e8.setAttribute('tabindex','1');
	  cellRight8.appendChild(e8);
	}

	function removeRow()
	{
	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
	  	tbl.deleteRow(lastRow - 1);
	  	var tbl = document.getElementById('grid');
	  	var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
	 	var iteration = lastRow - 1;
	  	var hdb = document.getElementById('hdb');
	  	hdb.value=iteration
	}
	}
	
	function chkPassportDate(expiry_date){
		var issue_date= document.getElementById('passportIssueDate').value;
		if(expiry_date <=issue_date  ){
			alert("Passport Expiry date should not less than or equal to Passport Issue date.")
			document.getElementById('passportExpiryDate').value='';
			
		}
		
	}
	

	function populateLineManager(val,formName){
		obj = eval('document.'+formName+'.managerId');
		obj.length = 1;
		
		for(i=0;i<lineManagerArr.length;i++){
			if(lineManagerArr[i][0]==val){
				obj.length++;
				obj.options[obj.length-1].value=lineManagerArr[i][1];
				obj.options[obj.length-1].text=lineManagerArr[i][2];			
			}
		}
	}

	var dtCh= "/";
	var minYear=1900;
	var maxYear=2100;
	function isDate(dtStr,fieldId){
		
		var daysInMonth = DaysArray(12)
		var pos1=dtStr.indexOf(dtCh)
		var pos2=dtStr.indexOf(dtCh,pos1+1)
		//var strMonth=dtStr.substring(0,pos1)
		//var strDay=dtStr.substring(pos1+1,pos2)
		var strDay=dtStr.substring(0,pos1)
		var strMonth=dtStr.substring(pos1+1,pos2)
		//alert("strMonth--"+strMonth);
		//alert("strDay--"+strDay);
		var strYear=dtStr.substring(pos2+1)
		strYr=strYear
		if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1)
		if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1)
		for (var i = 1; i <= 3; i++) {
		if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1)
		}
		month=parseInt(strMonth)
		day=parseInt(strDay)
		year=parseInt(strYr)
		if (pos1==-1 || pos2==-1){
		alert("The date format should be : DD/MM/YYYY" );
		document.getElementById(fieldId).value="";
		document.getElementById(fieldId).focus();
		return false
		}
		if (strMonth.length<1 || month<1 || month>12){
		alert("Please enter a valid month");
		document.getElementById(fieldId).value="";
		document.getElementById(fieldId).focus();
		return false
		}
		if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
		alert("Please enter a valid day");
		document.getElementById(fieldId).value="";
		document.getElementById(fieldId).focus();
		return false
		}
		if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
		alert("Please enter a valid 4 digit year between "+minYear+" and "+maxYear+"");
		document.getElementById(fieldId).value="";
		document.getElementById(fieldId).focus();
		return false
		}
		if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
		alert("Please enter a valid date ");
		document.getElementById(fieldId).value="";
		document.getElementById(fieldId).focus();
		return false
		}
		return true
		}
	function validateExpDate(dt,fieldId){
		
		if(dt.value!=""){
		if (isDate(dt.value,fieldId)==false){
		return false
		}
		}
		return true
		}

</script>