<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">

	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String getDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(getDate.length()<2){
			getDate="0"+getDate;
		}

	%>
	serverdate = '<%=getDate+"/"+month+"/"+year%>'
</script>
<%

	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	}
	List<MasAdministrativeSex> genderList = new ArrayList<MasAdministrativeSex>();
	List<MasBloodGroup> bloodGrpList=new ArrayList<MasBloodGroup>();
	List<PhVillageSurvey> schoolList=new ArrayList<PhVillageSurvey>();
	
	if(map.get("schoolList")!=null){
		schoolList=(List<PhVillageSurvey>)map.get("schoolList");
	}
	
	if(map.get("genderList") != null){
		genderList = (List<MasAdministrativeSex>)map.get("genderList");
	}
	
	if(map.get("bloodGrpList") != null){
		bloodGrpList = (List<MasBloodGroup>)map.get("bloodGrpList");
	}
	
if(map.get("message") != null){
		 String  message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		 <%} %> 
<form name="student" method="post" action="">
<div class="titleBg">
<h2>Search Member</h2>
</div>
<div class="Block">
<label>School Name</label>
<select  name="villageSurveyId" validate="School Name,string,no" tabindex="1" onclick="submitProtoAjaxWithDivNameToShowStatus('student','/hms/hms/pubHealth?method=getClassList','testClass');">
<option value="0">Select</option>
	<%for(PhVillageSurvey phVillageSurvey:schoolList){ %>
	<option value="<%=phVillageSurvey.getId() %>"><%=phVillageSurvey.getPlaceName().trim() %></option>
	<%} %>
</select>

 <div id="testClass">

<label>Class</label> 
<select  name="classId" validate="Class,string,no" tabindex="1" >
<option value="0">Select</option>
	</select>
	
	
<label>Section</label> 
<select  name="section" validate="Section,string,no" tabindex="1" >
<option value="0">Select</option>
	
</select>
</div>


<div class="clear"></div>

<label>Student Name</label>
<input type="text"  name="studentName" value=""/>

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>	
<input type="button" name="Submit" onclick="submitProtoAjaxWithDivNameToShowStatus('student','/hms/hms/pubHealth?method=getPhStudentRegistrationOpdMainList','studentRegistration');" accesskey="r"  tabindex=1  value="Search" class="buttonBig" />
	
<div class="clear"></div>	
 <div id="studentRegistration">
 <div class="clear"></div>
 <div class="clear"></div>
 <div class="clear"></div>
 <div class="clear"></div> 
<h4>List of Member</h4>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
	
<table  width="100%" border="0" id="accId" cellspacing="0" cellpadding="0" class="sortable">
	<thead>
		<tr>
			<th>UHID</th>
			<th>Student Name</th>
			<th>Gender</th>
			<th>Class</th>
			
		</tr>
	</thead>
	<tbody id="tableData">
	<tr>
	<td colspan="4"><h6> Select Any One </h6></td>
	</tr>
	
	</tbody>
	</table>

	
<div class="clear"></div>


	 </div>
<div class="clear"></div>


	
	</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
	
		<script type="text/javascript">
		
		function validateStudent(val) {
			if(!validateFullName(trimAll(document.getElementById('studentName').value))){
				alert("Student Name is not valid.");
				document.getElementById('studentName').value = "";
				return false;
			}
			
		}
		
		function validateMother(val) {
			if(!validateFullName(trimAll(document.getElementById('motherName').value))){
				alert("Mother Name is not valid.");
				document.getElementById('motherName').value = "";
				return false;
			}
		}
		function validateFather(val) {
			if(!validateFullName(trimAll(document.getElementById('fatherName').value))){
				alert("Father Name is not valid.");
				document.getElementById('fatherName').value = "";
				return false;
			}
		}
		function isAgeInteger(s)
		{
		      var i;
			s = s.toString();
			
		      for (i = 0; i < s.length; i++)
		      {
		         var c = s.charAt(i);
		         if (isNaN(c)) 
			   {
				alert("Given Age is not a number");
				document.getElementById('age').value ="";
				document.getElementById('age').focus;
				return false;
			   }
		      }
		      return true;
		}
		function checkForDOB()
		{

			if(document.getElementById("age").value!="" && document.getElementById("age").value>0)
			{
				var ageAtRegTime=document.getElementById("age").value;
				if(ageAtRegTime.indexOf(".")==1)
				{
					currentAge=ageAtRegTime.substring(0,ageAtRegTime.indexOf("."))+" "+document.getElementById("ageUnitId").value;
				}
				else if(ageAtRegTime.indexOf(".")==-1)
				{
					currentAge=document.getElementById("age").value+" "+document.getElementById("ageUnitId").value;
				}
				document.getElementById('idForAge').value=currentAge;
				var apoxAge=calculateApproxDobFromAge();
				document.getElementById("dobId").value="";
				document.getElementById("dobId").value=apoxAge;
			}

			return true;
		}
		function calculateApproxDobFromAge(){
		var age =  document.getElementById('idForAge').value;
	
			var obj = age.split(" ");
			currentDateJ = new Date();

			unit=obj[1];
			year = 0; month = 0; day = 0;
			if(unit == 'Years'){
				year = currentDateJ.getFullYear()- obj[0];
			}
			else if(unit == 'Months'){
				month=(currentDateJ.getMonth()+1)-obj[0]
				if(month<=0){
					month = month+12
					year--;
				}
				if(month != 0)
					month = (month<10)? "0"+month : month


			}
			else if(unit == 'Days'){
				day = (currentDateJ.getDate()-obj[0])
				if(day<0){
					day = day+30
					month--;
				}
				day = (day<10)? "0"+day : day

			}

			if(year <= 0)
				year = currentDateJ.getFullYear()+year;
			if(month <= 0)
				month = (((currentDateJ.getMonth()+1)+month)<10)? "0"+((currentDateJ.getMonth()+1)+month) : ((currentDateJ.getMonth()+1)+month);
			if(day == 0)
				day = (currentDateJ.getDate()<10)? "0"+currentDateJ.getDate() : currentDateJ.getDate();

			approxDob =day + "/" + month + "/" + year;
			
			return approxDob;

		}
				
		
		function chkLength(field,maxLimit)
		{
		if(field.value.length > maxLimit)
		{
		 alert('Maximum Limit is '+maxLimit+' characters.');
		 var val=field.value.substring(0,maxLimit);
		 field.value=val;
		}
		}
		
	
	
		

	
		</script><script type="text/javascript">
							

		 function calculateAgeInAjax(formName) {
			  //alert("formName======>>"+formName);
		 dob=document.getElementById('dobId').value;
		 //alert("dob======>>"+dob);
			if(dob != ""){
				if(checkDob()){
					//alert("in check()dob======>>"+dob);
				action="/hms/hms/registration?method=calculateAgeInAjax&dateOfBirth="+dob;
				obj = eval('document.'+formName)
				       obj.action = action;
			    	   	 var url=action
			 }
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
		   xmlHttp.onreadystatechange=function()
		   {
		     if(xmlHttp.readyState==4){
		     	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
		     	for (loop = 0; loop < items.childNodes.length; loop++) {
			   	    var item = items.childNodes[loop];
			        var age  = item.getElementsByTagName("age")[0];
			        var period  = item.getElementsByTagName("period")[0];
			       obj=eval(document.getElementById('ageId'))
			       if(age.childNodes[0].nodeValue == "0"){
			      document.getElementById("age").value=age.childNodes[0].nodeValue;
			       }else{

				   document.getElementById("age").value=age.childNodes[0].nodeValue
				   document.getElementById("age").value=age.childNodes[0].nodeValue
				   		  }
				   	document.getElementById('ageUnitId').style.display = 'inline';
				    temp = eval("document."+formName+".ageUnit");
				   temp.value=period.childNodes[0].nodeValue
				   document.getElementById('religionId').focus();
		     	}
		     }
		   }
		   var url=action;
   	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

		   xmlHttp.open("GET",url,true);
		   xmlHttp.setRequestHeader("Content-Type", "text/xml");
		   xmlHttp.send(null);

		   }
		 }
		function fillStudent()
		{
			submitProtoAjaxForOpdMainTemplate('student','/hms/hms/schoolHealthMaster?method=showStudent','divTemplet');
			
		}
		
		
		</script>
		
		<script type="text/javascript">
		
		function schoolTypeList()
		{

				var schoolType = document.student.<%=SCHOOL_TYPE%>.value;
				if(schoolType == "Anganwadi"){
					document.getElementById('anganwadiDiv').style.display = "inline";
					document.getElementById('schoolDiv').style.display = "none";
					document.getElementById('classIdSection').value=0;
					document.getElementById('joiningDateIds').value="";
					document.getElementById('joiningDateIdjs').value="";
					document.getElementById('admissionNoSection').value="";
					//submitProtoAjaxWithDivName('student','/hms/hms/schoolHealthMaster?method=getSchoolListStudent&xschoolType=Anganwadi','divSchoolType');
				}
				else if(schoolType == "School"){
					document.getElementById('schoolDiv').style.display = "inline";
					document.getElementById('anganwadiDiv').style.display = "none";
					document.getElementById('classIdDivison').value=0;
					document.getElementById('joiningDateIdd').value="";
					document.getElementById('joiningDateIdss').value="";
					document.getElementById('admissionNoDivision').value="";
					
					
					  //submitProtoAjaxWithDivName('student','/hms/hms/schoolHealthMaster?method=getSchoolListStudent&schoolType=School','divSchoolType');
							}
				else
				{
					document.getElementById('schoolDiv').style.display = "none";
					document.getElementById('anganwadiDiv').style.display = "none";
				}
				
		}
		
	
		
		
		</script>
		
<script language="javascript">

function updateStudent(){
	if(document.getElementById('schId').value!=null){
	var schId=document.getElementById('schId').value;
	//alert("schId-------->"+schId)
	submitForm('student','student?method=updateStudentReg&schId='+schId);
	}else{
			

	}
		
}
</script>
<script language="javascript">

function validatePhStHel(cstId,stId,classD,schoolClass)
{
       if (cstId==stId && classD==schoolClass) 
	   {
		alert("Health record already entered for this Student.");
		return false;
	   }
      return true;
}

</script>
 <script>
 function generateExcel()
	 {
var schoolNameId=document.getElementById('schoolNameId').value;
alert("in method"+schoolNameId);
if(schoolNameId==""){
alert("Please select School");
return false;
	 }else{
submitForm('student','pubHealth?method=generateStudentExcel&schoolNameId='+schoolNameId);
	 }
}
		 function updateExcel(){
			 //var url="/hms/hms/schoolHealthMaster?method=displayStudentPhoto&studentId="+studentId+"&grNo="+grNo;
				var url="/hms/hms/pubHealth?method=uploadExcel";
					//alert(url);
			 	newwindow=window.open(url,'name',"left=100,top=100,height=400,width=350,status=1,scrollbars=1,resizable=0");
			 }
		
		 

		 </script>
		 
	<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
	  </script>