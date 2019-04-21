<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.PhStudentRegistration"%>
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
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css"/>
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
animatedcollapse.addDiv('title9', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title10', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title11', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title12', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title13', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title14', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title15', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title16', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.init()
function changeClass(title,t)
{
animatedcollapse.toggle(title,t);
}
</script>
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
<script language="Javascript">
function allergyClick()
{

		var allergy = document.student.allergy.value;
		if(allergy == "Yes"){
			document.getElementById('allergyYesDiv').style.display = "inline";
			document.getElementById('allergyNoDiv').style.display = "none";
			
		}
		else
		{
			document.getElementById('allergyNoDiv').style.display = "inline";
			document.getElementById('allergyYesDiv').style.display = "none";
		}
		
}

</script>
<%
Map<String,Object> map = new HashMap<String,Object>();
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");  
String time = (String)utilMap.get("currentTime");

if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasDistrict> districtList = new ArrayList<MasDistrict>();
districtList = (ArrayList)map.get("districtList");

List<MasHospitalType> masHospitalTypeList = new ArrayList<MasHospitalType>();
masHospitalTypeList = (ArrayList)map.get("masHospitalTypeList");

List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
masHospitalList = (ArrayList)map.get("masHospitalList");

List<MasActionTaken> masActionTakenList = new ArrayList<MasActionTaken>();
masActionTakenList = (ArrayList)map.get("masActionTakenList");

List<PhStudentRegistration> phStudentRegistrationList= new ArrayList<PhStudentRegistration>();
if(map.get("phStudentRegistrationList") != null){
	phStudentRegistrationList =  (List<PhStudentRegistration>)map.get("phStudentRegistrationList");
	
}

List<MasSpecialityDeptGroup> masForGorupParameter=new ArrayList<MasSpecialityDeptGroup>();
	List<MasSpecialtyGroupParameter> groupParameterList=new ArrayList<MasSpecialtyGroupParameter>();
	List<MasSpecialityDeptGroupValue> masValue=new ArrayList<MasSpecialityDeptGroupValue>();
		
	
	String userName = "";
	String  departName= "";
	String checkBox="";
    String valueName="";	
    
	  if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	        }
	 if(map.get("masForGorupParameter") != null){
		 masForGorupParameter = (List<MasSpecialityDeptGroup>)map.get("masForGorupParameter");
		      } 
     if(map.get("masValue") != null){
        masValue = (List<MasSpecialityDeptGroupValue>)map.get("masValue");
	 }
         if(map.get("groupParameterList") != null){
        groupParameterList = (List<MasSpecialtyGroupParameter>)map.get("groupParameterList");

		} 
         if(map.get("valueName") != null){
        	 valueName = (String)map.get("valueName");
 	
 			} 
         
         if(map.get("checkBox") != null){
        	 checkBox = (String)map.get("checkBox");
 	
 			} 
     

if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}
String message="";
if(map.get("message") != null){
	  message = (String)map.get("message");
}



			if (phStudentRegistrationList.size() > 0) {
				for (PhStudentRegistration pst : phStudentRegistrationList) {
		%>

<form name="student" method="post" action="">
<h2>Preliminary Medical Screening</h2>

<div class="detailsDiv">
<div class="detailsDivLeft"><h4>Student  Details</h4></div>
<div class="detailsDivRight"><h4><a href="#" onclick="getStudentAllDetails();">View Previous Health Records</a></h4></div>
<div class="clear"></div>
</div>

<div class="Block">
 <input type="hidden" value="<%=pst.getId()%>" name ="studentId" id="studentId"></input>
<label>UHID No. </label> 
<%if(pst.getMembersurvey().getAadhaarNo() !=null){ %>
<input type="text" value="<%=pst.getMembersurvey().getAadhaarNo()%>" readonly="readonly"></input>
<%}else{ %>
<input type="text" value="-"  readonly="readonly"></input>
<%} %>

<label>Gender </label>
<input  type="text" name="gender" readonly="readonly" value="<%=pst.getMembersurvey().getGender().getAdministrativeSexName()%>" validate="Gender,string,yes" maxlength="49" tabindex=1 	onkeyup="validateStudent(this.value);" id="studentName"/>

<label>Guardian Name </label>
<%if(pst.getGuardianName()!=null && !pst.getGuardianName().equals("")){ %>
<input  type="text" name="gender" readonly="readonly" value="<%=pst.getGuardianName()%>" validate="Guardian Name,string,no" maxlength="49" tabindex=1 	onkeyup="validateStudent(this.value);" id="studentName"/>
<%}else{ %>
<input  type="text" name="gender" readonly="readonly" value="-" validate="Guardian Name,string,no" maxlength="49" tabindex=1 	 id="studentName"/>
<%} %>
 
 <div class="clear"></div>
<label>Student Name </label>
<input  type="text" name="studentName" readonly="readonly" value="<%=pst.getMembersurvey().getName()%>" validate="Student Name,string,yes" maxlength="49" tabindex=1 	onkeyup="validateStudent(this.value);" id="studentName"/>
<label>DOB</label>
<%if(pst.getMembersurvey().getDateOfBirth()!=null){ %>
<input type="text" id="dobId" name="dob"	readonly="readonly" value="<%=HMSUtil.convertDateToStringWithoutTime(pst.getMembersurvey().getDateOfBirth()) %>" class="date" onkeyup="
        var v = this.value;
        if (v.match(/^\d{2}$/) !== null) {
            this.value = v + '/';
        } else if (v.match(/^\d{2}\/\d{2}$/) !== null) {
            this.value = v + '/';
        }"/>
	<%}else{ %>
	<input type="text" id="dobId" name="dob"	value="" class="date" onkeyup="
        var v = this.value;
        if (v.match(/^\d{2}$/) !== null) {
            this.value = v + '/';
        } else if (v.match(/^\d{2}\/\d{2}$/) !== null) {
            this.value = v + '/';
        }"
	 MAXLENGTH="30" />
	<%} %>
<div id="dobcalId">
<img id="" src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0"	onclick="setdate('<%=date %>',document.student.dob,event)"	validate="Pick a date"  tabindex="14" />
</div>


<label>Contact No.</label>
<input  type="text" readonly="readonly" value="<%=pst.getMembersurvey().getContactNo()%>"/>

   <div class="clear"></div>
   <label>Class</label>
<input  type="text" readonly="readonly" value="<%=pst.getClassdetails() != null ? pst.getClassdetails().getSchoolClass() : ""%>"/>
   

</div>
   <div class="clear"></div>
<h4>General Measurements</h4>
   <table border="0" align="center" cellpadding="0" cellspacing="0" id="grid"  class="sortable">  
  <tr><th>Pulse Rate</th>
  <td><input  tabindex="11" name="pulse" type="text" id="pulse"	validate="pulse,num,no" maxlength="3" value="" /></td>
  <th>Blood Pressure SBP</th>
  <td><input  tabindex="11" name="sbp" type="text" id="sbp"	validate="SBP,num,no" maxlength="3" value="" validate="SBP,int,no"/></td>
  <th>Weight</th>
  <td><input type="text"  id="weight" maxlength="3" class="allownumericwithoutdecimal"  value="" name="weight" validate="Weight,int,no"  /><span>Kg.</span></td>
  </tr>

  <tr><th>DBP</th>
  <td><input  tabindex="11" name="dbp" type="text" id="dbp"	validate="DBP,num,no" maxlength="3" value="" validate="DBP,int,no"/>  </td>
  <th>BMI</th>
  <td><input type="text" maxlength="3" class="allownumericwithoutdecimal" value="" name="bmi" id="bmi" validate="BMI,int,no" /></td>
  <th>Height</th>
  <td>  <input type="text" maxlength="3" class="allownumericwithoutdecimal" value="" id="height" validate="Height,int,no" name="height"/><span>Cms.</span>
  </td>
  </tr>
<tr>
<th>Age at Puberly</th>
  <td><input type="text" maxlength="3" name="age" class="allownumericwithoutdecimal" value="" id="age" validate="Age at Puberly,int,no" /><span>years</span>
  </td>
  </tr>
  
</table>

    <div class="clear"></div>
    
    
<h4>Immunization Details</h4>
  	 
  <table border="0" align="center" cellpadding="0" cellspacing="0" id="grid"  class="sortable">  
  <tr><th>Immunization</th>
  <th>Due Date</th>
  <th>Immunization Date</th>
  </tr>
  <tr>
  <th>BCG </th>
  <td> <input	type="text" id="bcgDueDate" name="bcgDueDate" value=""		class="date" readonly="readonly" validate="Joining Date,date,no"	MAXLENGTH="30" />
  <img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="BCG Due Date,date,no"	onclick="javascript:setdate('student',document.student.bcgDueDate,event)" />
  </td>
  <td> <input	type="text" id="bcgImmDate" name="bcgImmDate" value=""		class="date" readonly="readonly" validate="Joining Date,date,no"	MAXLENGTH="30" />
  <img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="BCG Immunization date,date,no"	onclick="javascript:setdate('student',document.student.bcgImmDate,event)" />
  </td>
  
   </tr>
  
  <tr><th>OPV-O</th>  
  <td> <input	type="text" id="opvODueDate" name="opvODueDate" value=""		class="date" readonly="readonly" validate="Joining Date,date,no"	MAXLENGTH="30" />
  <img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="OPV-O Due date,date,no"	onclick="javascript:setdate('student',document.student.opvODueDate,event)" />
  </td>
  <td> <input	type="text" id="opvOImmDate" name="opvOImmDate" value=""		class="date" readonly="readonly" validate="Joining Date,date,no"	MAXLENGTH="30" />
  <img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="OPV-O Immunization date,date,no"	onclick="javascript:setdate('student',document.student.opvOImmDate,event)" />
  </td></tr>
  
  <tr><th>Hepatities - BO</th>
  <td> <input	type="text" id="hepatitiesBoDueDate" name="hepatitiesBoDueDate" value=""		class="date" readonly="readonly" validate="Joining Date,date,no"	MAXLENGTH="30" />
  <img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Hepatities - BO Due date,date,no"	onclick="javascript:setdate('student',document.student.hepatitiesBoDueDate,event)" />
  </td>
  <td> <input	type="text" id="hepatitiesBoImmDate" name="hepatitiesBoImmDate" value=""		class="date" readonly="readonly" validate="Joining Date,date,no"	MAXLENGTH="30" />
  <img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Hepatities - BO Immunization date,date,no"	onclick="javascript:setdate('student',document.student.hepatitiesBoImmDate,event)" />
  </td>
  </tr>
    
  </table>

  
  
    <div class="clear"></div>
<div id="divName">
   <table border="0" align="center" cellpadding="0" cellspacing="0" id="grid"  class="sortable">
   <tr>  
		<%
					int count=1;
		   Set<Integer> set=new HashSet<Integer>();
			int i=1;
				if(masForGorupParameter.size()>0)
				{
						%>
					
					<%
					for(MasSpecialityDeptGroup deptGroup: masForGorupParameter)
						{ 
						%>
				
						
								
    
										<% if(set.add(deptGroup.getSpGroup().getSpGroup().getId())){%>
    
     <th><%=deptGroup.getSpGroup().getSpGroup().getSpGroupName()%></th>

             							
             							<%  if(!deptGroup.getValueType().equalsIgnoreCase("Check Box") && !deptGroup.getValueType().equalsIgnoreCase("Radio Button")){%>
             							  <th>DETAILS REMARKS</th>
											  <th>ACTION TAKEN</th>
										 <%} else						 	
             						if(deptGroup.getValueType().equalsIgnoreCase("Check Box")){%>
             							  <th>Select</th>
										  
											  
										 <%} %>

									
										
										<%} %>
										
  </tr>
						
							
					          <tr>
					            		<% if(deptGroup.getSpGroup().getSpParameter().getStatus().equalsIgnoreCase("Y")) { %>
										  	 <td>	<%=deptGroup.getSpGroup().getSpParameter().getSpParameterName()%>
								       		<input type="hidden" value="<%= deptGroup.getSpGroup().getSpGroup().getId()%>:<%=deptGroup.getSpGroup().getSpParameter().getId()%>" name="parameterId<%=i%>"/>
						 			 </td>
						 			 
						 				<%}%>  	
						 			 
										<%if(deptGroup.getTextField()!=null){%>
											<%if(deptGroup.getTextField().equalsIgnoreCase("t")  )
										    {%>
										 
										     <td><input type="text" name="textValue<%=i%>" maxlength="90"/></td>
										  
										    <% }%>
										<%}%>
										
										
										
										 <td>	
             							
             							<%  if(!deptGroup.getValueType().equalsIgnoreCase("Check Box") && !deptGroup.getValueType().equalsIgnoreCase("Radio Button")){ %>
										  	 
					 	 <select name="actionTakenId<%=count %>" id="actionTakenId<%=count %>"  validate="Action Taken,metachar,no" tabindex=1  tabindex=1 ">
<%	if(masActionTakenList.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = masActionTakenList.iterator(); iterator.hasNext();) {
					 MasActionTaken a = (MasActionTaken) iterator.next();
					 if(a.getActionTakenName()!=null){
				  %>
				  <option value="<%=a.getId ()%>"><%=a.getActionTakenName().trim()%></option>
				  <%
				  	 	}
				 }
				   %>
			
			
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>
		
										 <% count++;} %>
										 <%  if(deptGroup.getValueType().equalsIgnoreCase("Check Box") || deptGroup.getValueType().equalsIgnoreCase("Radio Button")){%>
										  	<%if(deptGroup.getValueType().equalsIgnoreCase("Radio Button")){ %>
    	              						<input type="radio" name="textValue<%=i%>" value="radio" />
	              						 <%}else if(deptGroup.getValueType().equalsIgnoreCase("Check Box")){ %>
        	       						   <input type="checkbox" name="textValue<%=i%>" value="checkbox"/>
             							<%} %>
             							
		
										 <%} %>
						 			 </td>
										</tr>
							
								
						
						<%i++;}%>
										
		<%} %>
		
	</table>	
								
								
								
								</div>
   <input type="hidden" name="actionTakenCounter" value="<%=count%>">
   <input type="hidden" name="parameterCounter" value="<%=i%>">
    <div class="clear"></div>
      <table border="0" align="center" cellpadding="0" cellspacing="0" id="grid"  class="sortable">
    <tr>
    <th>Does the child have any known allergy ?</th>
    <td> <label>No</label>
    <input type="radio"	id="allergy"  name="allergy" value="No" class="radioCheckCol1" onclick="allergyClick();" />
    </td>
    <td>
    <label>Yes</label>
    <input type="radio"	id="allergy"  name="allergy" value="Yes" class="radioCheckCol1" onclick="allergyClick();" />
    </td>
     
     <td>
   <div id="allergyYesDiv" style="display: none;">
    <input name="allergyYesText" id="allergyYesText" type="text" maxlength="100">
        </div>
        <div id="allergyNoDiv" style="display: none;">
   
        </div>  
    </td>

    </tr>
  	</table>
    <div class="clear"></div>
     <h4>Referral</h4>
 <table border="0" align="center" cellpadding="0" cellspacing="0" id="grid"  class="sortable">
   <tr>
    
    <th>District</th>
    <th>Hospital Type</th>
    <th>Hospital</th>
    </tr>
    <tr>
    <td style="height:30px !important;">
  
  <select name="districtId" id="districtId"  validate="District,string,yes" tabindex=1  tabindex=1 onblur="valueDistrictHospitalType();">
<%	if(districtList.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = districtList.iterator(); iterator.hasNext();) {
					 MasDistrict ds = (MasDistrict) iterator.next();
					 if(ds.getDistrictName()!=null){
				  %>
				  <option value="<%=ds.getId ()%>"><%=ds.getDistrictName().trim()%></option>
				  <%
				  	 	}
				 }
				   %>
			
			
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>
	
</td>
  
  <td>
  
<select name="hospitalTypeId" id="hospitalTypeId"  validate="Hospital Type,string,yes" tabindex=1  tabindex=1 onblur="valueDistrictHospitalType();">
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = masHospitalTypeList.iterator(); iterator.hasNext();) {
					 MasHospitalType dh = (MasHospitalType) iterator.next();
					 if(dh.getHospitalTypeName()!=null){
				  %>
				  <option value="<%=dh.getId ()%>"><%=dh.getHospitalTypeName().trim()%></option>
				  <%
				  	 	}
				 
				   %>
			
			
	
		
	<%} %>
	</select>
  

</td>
<td>
    
<select name="hospitalId" id="hospitalId"  validate="Hospital,string,yes" tabindex=1  tabindex=1>
<%	if(masHospitalList.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = masHospitalList.iterator(); iterator.hasNext();) {
					 MasHospital d = (MasHospital) iterator.next();
					 if(d.getHospitalName()!=null){
				  %>
				  <option value="<%=d.getId ()%>"><%=d.getHospitalName().trim()%></option>
				  <%
				  	 	}
				 }
				   %>

	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>
	</td>
	</tr>
	</table>
	
<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
      <div class="clear"></div>
 <input type="button" class="button" value="Save" onclick="submitForm('student','/hms/hms/pubHealth?method=saveStudentHealthReg&skip=1');"  />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
	  
<%}} %>


<script language="Javascript">
function otherFamilyHistory()
{

		var obj = document.student.other.checked;
		if(obj ==true){
		
			document.getElementById('otherDiv').style.display = "inline";
			
		}
		else
		{
			document.getElementById('otherDiv').style.display = "none";
		}
		
}


function alleryYes()
{
	
		var a = document.student.allery.value;
		if(a =="y"){
		
			document.getElementById('yesDiv').style.display = "inline";
			
		}
		if(a =="n")
		{
			document.getElementById('yesDiv').style.display = "none";
		}
		
}


function valueDistrictHospitalType()
{
		var districtId =document.getElementById('districtId').value; 
		var hospitalTypeId=document.getElementById('hospitalTypeId').value; 
  	
  		if(districtId!=0 && hospitalTypeId!=0){
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

		      	obj = document.getElementById('hospitalId');
		    	obj.length = 1;
				

		       	for (loop = 0; loop < items.childNodes.length; loop++) {
		       		
		 	   	    var item = items.childNodes[loop];
		 	   	    var hospitalId  = item.getElementsByTagName("hospitalId")[0];
		 	   	    var hospitalName = item.getElementsByTagName("hospitalName")[0];
		
		 	   	obj.length++;
				obj.options[obj.length-1].value=hospitalId.childNodes[0].nodeValue;
				obj.options[obj.length-1].text=hospitalName.childNodes[0].nodeValue;

				
		 	       
		       	}
		     
		      }
		    }
		    var url='/hms/hms/pubHealth?method=fillDataForDistrictHospitalType&districtId='+districtId+'&hospitalTypeId=' + hospitalTypeId;
    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

		    xmlHttp.open("GET",url,true);
		    xmlHttp.setRequestHeader("Content-Type", "text/xml");
		    xmlHttp.send(null);

  		}
		
} 
</script>
<script language="javascript">

function getStudentAllDetails()
{
	if(document.getElementById('studentId').value!=null){
	var studentId=document.getElementById('studentId').value;
	window.location = "/hms/hms/pubHealth?method=getStudentAllDetailsById&studentId="+studentId;
    }
		}
</script>	
	
