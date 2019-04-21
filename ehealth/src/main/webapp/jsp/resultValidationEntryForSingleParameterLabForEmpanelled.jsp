<%@page import="jkt.hms.masters.business.MasEmpaneled"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%>
<%@page import="java.text.DecimalFormat"%>

<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="java.io.InputStream"%>


<script src="/hms/jsp/js/proto.js"
	type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>
<script type="text/javascript">
 function chkLength(field,maxLimit)
{
	if(field.value.length > maxLimit)
	{
	 alert('you crossed the maximum limit of '+maxLimit+' characters');
	 var val=field.value.substring(0,maxLimit);
	 field.value=val;
	}
}
 
 
 function CheckAll(checkall)
	{
		var c = document.getElementById('counter').value; 
		if(checkall.checked ){
			for (var i=0;i < c;i++) {
				var obj=document.getElementById('checkIdSingleValue'+i);
				var objForMultiple=document.getElementById('checkId'+i);
	  			if(obj !=null && obj.disabled== false){
	  				document.getElementById('checkIdSingleValue'+i).checked =true;
	  				document.getElementById('checkIdSingleValueRetest'+i).checked=false;  
	 				document.getElementById("retestAllButton").checked=false;
	 				document.getElementById("recollectAllButton").checked=false;
	 				document.getElementById('checkIdSingleValueRecollect'+i).checked=false; 
	  			} 
	  			else if(objForMultiple !=null && objForMultiple.disabled== false){
	  				document.getElementById('checkId'+i).checked =true;  
	  				document.getElementById('checkIdRetest'+i).checked=false; 
	  				document.getElementById('checkIdRecollect'+i).checked=false;
	  				document.getElementById("retestAllButton").checked=false;
	  				document.getElementById("recollectAllButton").checked=false;
	  			}
	 			 
	 		}
		}else{
			checkall.checked == false ; 
		 	for (var i=0;i< c;i++) {
		 		var obj=document.getElementById('checkIdSingleValue'+i);
				var objForMultiple=document.getElementById('checkId'+i);
		 		if(obj !=null){
		 			document.getElementById("checkIdSingleValue"+i).checked =false;
		 		}else if(objForMultiple !=null){
		 			document.getElementById("checkId"+i).checked =false;
		 		}
	  			
	 	 	}
	 	}
	}
 
 function checkAllRetested(checkAllRetest){
	 var c = document.getElementById('counter').value;
		if(checkAllRetest.checked ){
			for (var i=0;i< c;i++) {
				var obj=document.getElementById('checkIdSingleValueRetest'+i);
				var objForMultiple=document.getElementById('checkIdRetest'+i);
	  			if(obj !=null && obj.disabled== false){
	  				document.getElementById('checkIdSingleValueRetest'+i).checked=true;
	  				document.getElementById('checkIdSingleValue'+i).checked =false; 
	  				document.getElementById("addbutton").checked=false;  
	  				document.getElementById("recollectAllButton").checked=false;
	  				document.getElementById('checkIdSingleValueRecollect'+i).checked=false; 
	  			}else if(objForMultiple !=null && objForMultiple.disabled== false){  
	  				document.getElementById('checkIdRetest'+i).checked=true;
	  				document.getElementById("addbutton").checked=false;
	  				document.getElementById("recollectAllButton").checked=false; 
	  				document.getElementById('checkId'+i).checked=false; 
	  				document.getElementById('checkIdRecollect'+i).checked=false; 
	  				  
	  			} 
	 		}
		}else{
			checkAllRetest.checked == false ; 
		 	for (var i=0;i < c;i++) {
		 		var obj=document.getElementById('checkIdSingleValueRetest'+i);
				var objForMultiple=document.getElementById('checkIdRetest'+i);
				if(obj !=null){
		 			document.getElementById("checkIdSingleValueRetest"+i).checked =false; 
		 		}else if(objForMultiple !=null){
		 			document.getElementById("checkIdRetest"+i).checked =false;
		 		} 
	 	 	}
	 	}
 } 
  function checkAllRecollected(checkAllRecollect)
	{ 
		var c = document.getElementById('counter').value;
		if(checkAllRecollect.checked ){
			for (var i=0;i < c;i++) {
				var obj=document.getElementById('checkIdSingleValueRecollect'+i);
				var objForMultiple=document.getElementById('checkIdRecollect'+i);
	  			if(obj !=null && obj.disabled== false){
	  				document.getElementById('checkIdSingleValueRecollect'+i).checked=true;
	  				document.getElementById('checkIdSingleValue'+i).checked =false; 
	  				document.getElementById("addbutton").checked=false; 
	  				document.getElementById('checkIdSingleValueRetest'+i).checked=false;  
	 				document.getElementById("retestAllButton").checked=false;
	  			}else if(objForMultiple !=null && objForMultiple.disabled== false){ 
	  				document.getElementById('checkIdRecollect'+i).checked=true; 
	  				document.getElementById("addbutton").checked=false;
	  				document.getElementById("retestAllButton").checked=false; 
	  				document.getElementById('checkId'+i).checked=false; 
	  				document.getElementById('checkIdRetest'+i).checked=false;
	  				
	  			}
	 			 
	 		}
		}else{
			checkAllRecollect.checked == false ; 
		 	for (var i=0;i < c;i++) {
		 		var obj=document.getElementById('checkIdSingleValueReject'+i);
				var objForMultiple=document.getElementById('checkIdReject'+i);
				if(obj !=null){
		 			document.getElementById("checkIdSingleValueReject"+i).checked =false;
		 			$("retestTh").hide();
	  				$("recollectTh").hide();
	  				$("retestTd"+i).hide();
	  				$("recollectTd"+i).hide();
		 		}else if(objForMultiple !=null){
		 			document.getElementById("checkIdReject"+i).checked =false;
		 		} 
	 	 	}
	 	}
	}
  function  accepted(chkObj, inc)
 {
 	 if(chkObj.checked){
 	 if(chkObj.id == "checkIdSingleValue"+inc){ 
 	 	document.getElementById('checkIdSingleValueRetest'+inc).checked=false; 
 	 	document.getElementById('checkIdSingleValueRecollect'+inc).checked=false;
 	 }else if(chkObj.id == "checkId"+inc){
 		document.getElementById('checkIdRetest'+inc).checked=false; 
 	 	document.getElementById('checkIdRecollect'+inc).checked=false;
 	 }
 	 }
 }

  function  retest(chkObj, inc)
 	{
 		 if(chkObj.checked){
 		  if(chkObj.id == "checkIdSingleValueRetest"+inc){ 
 		    document.getElementById('checkIdSingleValue'+inc).checked=false; 
 		   document.getElementById('checkIdSingleValueRecollect'+inc).checked=false;
 	  }else if(chkObj.id == "checkIdRetest"+inc){
 		 document.getElementById('checkId'+inc).checked=false; 
		   document.getElementById('checkIdRecollect'+inc).checked=false;
 	  }
 	 } 
  }  
  function  recollect(chkObj, inc)
	{
		 if(chkObj.checked){
		  if(chkObj.id == "checkIdSingleValueRecollect"+inc){ 
		    document.getElementById('checkIdSingleValue'+inc).checked=false; 
		    document.getElementById('checkIdSingleValueRetest'+inc).checked=false;
	  }else if(chkObj.id == "checkIdRecollect"+inc){
		  document.getElementById('checkId'+inc).checked=false; 
		  document.getElementById('checkIdRetest'+inc).checked=false;
	  }
	 }   
}
 
 /* function CheckAll(chk)
{
for (var i=0;i < document.sampleCollection.elements.length;i++)
	{
		var e = document.sampleCollection.elements[i];

		if (e.type == "checkbox")
		{
			e.checked = chk.checked;
		}
	}
}  */
 function goBack(){
 	window.location.href='/hms/hms/investigation?method=searchPatientForResultValidationLab';
 }

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

	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);

    int pageNo=1;
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
	List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	String resultId = "";
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("pageNo") != null)
	{
		pageNo=(Integer)map.get("pageNo");
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
	if(map.get("employeeList") != null){
	    employeeList = (List<MasEmployee>)map.get("employeeList");
	}

	String deptType="";
	if(session.getAttribute("deptType") != null){
		deptType = (String)session.getAttribute("deptType");
	}
	String deptName ="";
	if(session.getAttribute("deptName") != null){
		deptName = (String)session.getAttribute("deptName");
	}
	if(map.get("investigationList") != null){
		investigationList = (ArrayList)map.get("investigationList");
	}
	Map<String,Object> detailsMap = new HashMap<String,Object>();
	if(map.get("detailsMap") !=null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}
	if(map.get("resultId") !=null){
		resultId = (String)map.get("resultId");
	}

	try{
		if(map.get("resultList") != null){
			resultList=(List)map.get("resultList");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	Set<DgResultEntryDetail> dgResultDtSet = new HashSet<DgResultEntryDetail>();
	for(DgResultEntryHeader dgResultHeader : resultList){
		dgResultDtSet = dgResultHeader.getDgResultEntryDetails();
	}
	DgResultEntryHeader dgResultEntryHeader= new DgResultEntryHeader();
	if(resultList != null && resultList.size() >0) {
		dgResultEntryHeader = (DgResultEntryHeader) resultList.get(0);
	}

	DgResultEntryHeader dgresultHeader=new DgResultEntryHeader();
	if(resultList != null && resultList.size() >0){
		dgresultHeader = (DgResultEntryHeader) resultList.get(0);
	}

	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
	 	e.printStackTrace();
	}
	 String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
%>

<!--main content placeholder starts here-->
<form name="sampleCollection" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<div class="titleBg">
		<h2>Result Validation</h2>
	</div>
	<%
String subDept = "";

int SubChargeId=0;
int mainChargeId=0;
		for(DgResultEntryDetail dgDetail :dgResultDtSet){
			if(dgDetail.getInvestigation() != null){
			subDept = dgDetail.getInvestigation().getSubChargecode().getSubChargecodeName();
			SubChargeId=dgDetail.getInvestigation().getSubChargecode().getId();
			mainChargeId=dgDetail.getInvestigation().getMainChargecode().getId();
%>
	<%
 			}
 		}%>
	<!--Block Two Starts-->
	<div class="clear"></div>
	<h4>Patient Details</h4>
	<div class="Block">
		<div class="clear"></div>
		<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
		<%
String patientName = "";
String age  = "";
String sex = "";
if(dgResultEntryHeader.getHin() == null){
	Set<DgOrderdt> set = new HashSet<DgOrderdt>();
	
	if(dgresultHeader.getSampleCollectionHeader()!=null){
		set = dgresultHeader.getSampleCollectionHeader().getOrder().getDgOrderdts();
	}
	BlOpBillHeader  billHeader = new BlOpBillHeader();
	for(DgOrderdt orderDt : set){
		if(orderDt.getBill() != null){
		  billHeader = orderDt.getBill();
		  	patientName=billHeader.getPatientName();
			age=billHeader.getAge();
			sex=billHeader.getSex().getAdministrativeSexName();
		}
	}
}

%>
		<%if(dgResultEntryHeader.getHin()!= null){ %>
		<label class="value"><%=dgResultEntryHeader.getHin().getHinNo() %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<%
	if(dgResultEntryHeader.getHin()!= null){

			String middleName = "";
					String lastName = "";
					if(dgResultEntryHeader.getHin().getPMiddleName() != null){
						middleName = dgResultEntryHeader.getHin().getPMiddleName();
					}
					if(dgResultEntryHeader.getHin().getPLastName() != null){
						lastName = dgResultEntryHeader.getHin().getPLastName();
					}

					%>
		<label>Patient Name</label> <label class="value"><%=dgResultEntryHeader.getHin().getPFirstName()+" "+middleName+" "+lastName%></label>
		<%}else{ %>
		<label>Patient Name</label> <label class="value"><%=patientName%></label>

		<%} %>
		<%if(dgResultEntryHeader.getHin()!= null){ %>
		<label>Gender</label> <label class="value"><%= dgResultEntryHeader.getHin().getSex().getAdministrativeSexName()%></label>
		<%}else{ %>
		<label>Gender</label> <label class="value"><%=sex%></label>
		<%} %>
		<div class="clear"></div>
		<label>Unit</label> <label class="value">-</label>
		<%
		String bloodGroup="-";
		if(dgResultEntryHeader.getHin().getBloodGroup()!=null && dgResultEntryHeader.getHin().getBloodGroup().getBloodGroupCode()!=null){
			bloodGroup=dgResultEntryHeader.getHin().getBloodGroup().getBloodGroupCode();
		}
		%>
		<label>Blood Group</label> <label class="value"><%=bloodGroup%></label>
		<label>Mobile No</label>
		<%String mobileNumber="-"; 
			if(dgResultEntryHeader.getHin().getMobileNumber()!=null && !"".equalsIgnoreCase(dgResultEntryHeader.getHin().getMobileNumber().trim())){
				mobileNumber=dgResultEntryHeader.getHin().getMobileNumber();
			}
			String fName="";
			String lName="";
			String mName="";
			if(dgResultEntryHeader.getSampleCollectionHeader().getOrder().getPrescribedBy()!=null){
				fName=dgResultEntryHeader.getSampleCollectionHeader().getOrder().getPrescribedBy().getFirstName();
			}if(dgResultEntryHeader.getSampleCollectionHeader().getOrder().getPrescribedBy()!=null && dgResultEntryHeader.getSampleCollectionHeader().getOrder().getPrescribedBy().getLastName()!=null){
				lName=dgResultEntryHeader.getSampleCollectionHeader().getOrder().getPrescribedBy().getLastName();
			}
			if(dgResultEntryHeader.getSampleCollectionHeader().getOrder().getPrescribedBy()!=null && dgResultEntryHeader.getSampleCollectionHeader().getOrder().getPrescribedBy().getMiddleName()!=null){
				mName=dgResultEntryHeader.getSampleCollectionHeader().getOrder().getPrescribedBy().getMiddleName();
			}%>
		<label class="value"><%=mobileNumber%></label>
		<div class="clear"></div>
		<%  
			String ipNo="-";
			String ward="-";
			String bedNo="-";
			if(dgResultEntryHeader.getSampleCollectionHeader().getOrder().getInpatient()!=null){
				ipNo=dgResultEntryHeader.getSampleCollectionHeader().getOrder().getInpatient().getAdNo();
				ward=dgResultEntryHeader.getSampleCollectionHeader().getOrder().getInpatient().getDepartment().getDepartmentName();
				bedNo=dgResultEntryHeader.getSampleCollectionHeader().getOrder().getInpatient().getBed().getBedNo();
			%>
		<label>IP No</label> <label class="value"><%=ipNo%></label> <label>Ward</label>
		<label class="value"><%=ward%></label> <label>Bed No</label> <label
			class="value"><%=bedNo%></label>
		<div class="clear"></div>
		<%}%>
		<label>Doctor Name</label> <label class="value"><%=fName+" "+mName+" "+lName %></label>
		<div>
			<%
if(dgResultEntryHeader.getInpatient() != null){
%>
			<input type="hidden" name="<%=INPATIENT_ID %>"
				value="<%=dgResultEntryHeader.getInpatient().getId()%>" />
			<%} else{%>
			<input type="hidden" name="<%=INPATIENT_ID %>" value="" />
			<%} %>
			<input type="hidden" name="<%=DEPARTMENT_ID %>"
				value="<%=dgResultEntryHeader.getDepartment().getId()%>" />
			<%
		if(dgResultEntryHeader.getHin() !=null){
	%>
			<input type="hidden" name="<%=HIN_ID %>"
				value="<%=dgResultEntryHeader.getHin().getId() %>" /> <input
				type="hidden" name="<%=HIN_NO %>"
				value="<%=dgResultEntryHeader.getHin().getHinNo() %>" />
			<%} %>
		</div>




		<div class="clear"></div>
	</div>
	<!--Block Two Ends-->
	<script>

function inputValidate(){

	var validatedCheckBoxCountSingle = document.getElementById('validatedCheckBoxCountSingle').value;
	var validatedCheckBoxCountMultiple = document.getElementById('validatedCheckBoxCountMultiple').value;
	if(validatedCheckBoxCountSingle > 0 || validatedCheckBoxCountMultiple > 0){
		for(var i = 0 ;i< validatedCheckBoxCountSingle ;i++){
			if(document.getElementById('checkIdSingleValue'+i).checked == true){
				return true;
			}
			else if(document.getElementById('checkIdSingleValueRetest'+i).checked == true){
				return true;
			}else if(document.getElementById('checkIdSingleValueRecollect'+i).checked == true){
				return true;
			}
		}

		for(var j = 0 ;j< validatedCheckBoxCountMultiple ;j++){
			if(document.getElementById('checkId'+j).checked == true){
				return true;
			}
			else if(document.getElementById('checkIdRetest'+j).checked == true){
				return true;
			}
			else if(document.getElementById('checkIdRecollect'+j).checked == true){
				return true;
			}
		}
		alert("Please select atleast one result.")
		return false;
	}else{
		return true;
	}
}

//function inputValidate(){
//	validatedSingleValue  = document.getElementsByName('validatedSingleValue');
//	if(validatedSingleValue != null || validatedSingleValue != undefined){
//		for(var i = 0; i < document.getElementsByName('validatedSingleValue').length; i++){
//			if(document.getElementsByName('validatedSingleValue')[i].checked == true)
 //             {
//				return true;
//			  }
 // 		}
//	}
//	validated  = document.getElementsByName('validated');
//	if(validated != null || validated != undefined){
//		for(var i = 0; i < document.getElementsByName('validated').length; i++){
//			if(document.getElementsByName('validated')[i].checked == true)
 //             {
//				return true;
//			  }
 // 		}
//	}
 // 		alert("Please Validate The Result.")
//		return false;
//}

function inputValue(){
		for(var i = 0; i < document.getElementsByName('validated').length; i++){
			if(document.getElementsByName('validated')[i].checked == true)
              {
				return true;
			  }
  		}
  		alert("Please Validate The Result.")
		return false;
	}
function openTemplateScreen(index){
	//var resultEnteredBy = document.getElementById('<%=RESULT_VALIDATED_BY %>').value;
	//if(resultEnteredBy != ''){
		var resultId = document.getElementById('resultIdTemplate'+index).value;
		var resultIdStringForTemplate = document.getElementById('resultIdStringForTemplate').value;
		var resultEnteredByForTemplate = document.getElementById('<%=RESULT_VALIDATED_BY %>').value;
		submitForm('sampleCollection','investigation?method=searchPatientForResultValidation&resultId='+resultId+'&flagForLab=fromLab&resultIdStringForTemplate='+resultIdStringForTemplate+'&resultEnteredByForTemplate='+resultEnteredByForTemplate+'');
	//}else{
	//	alert('Result Entered By can not be blank.');
	//	return false;
	//}

}
function openSensitiveScreen(index){
		var resultId = document.getElementById('resultIdSensitive'+index).value;
		var resultIdStringForTemplate = document.getElementById('resultIdStringForTemplate').value;
		var resultEnteredByForTemplate = document.getElementById('<%=RESULT_VALIDATED_BY %>').value;
		submitForm('sampleCollection','investigation?method=searchPatientForResultValidation&resultId='+resultId+'&flagForLab=fromLab&resultIdStringForTemplate='+resultIdStringForTemplate+'&resultEnteredByForTemplate='+resultEnteredByForTemplate+'');
}

</script>
	<script>

function resetResult(){
	  document.getElementById('result').value="";
	   document.getElementById('additionalRemarks').value="";

   }
</script>
	<!-- Block Three Starts -->
	<h4>Sample Details</h4>
	<div class="clear"></div>
	<div class="Block">
		<div class="clear"></div>
		<label>Date</label>
		<%if(dgresultHeader.getResultDate() != null){ %>
		<label class="value"><%=HMSUtil.changeDateToddMMyyyy(dgresultHeader.getResultDate()) %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<label>Validated By:</label>
		<%if(dgresultHeader.getEmployee() != null) {%>
		<input type="hidden" id="<%=RESULT_ENTERED_BY %>"
			name="<%=RESULT_ENTERED_BY %>"
			value="<%=dgresultHeader.getEmployee().getFirstName() %>" />
		<%
			String VFName="";
			String VMName="";
			String VLName="";
			if(dgresultHeader.getEmployee().getFirstName()!=null){
				VFName=dgresultHeader.getEmployee().getFirstName();
			}if(dgResultEntryHeader.getEmployee().getMiddleName()!=null){
				VMName=dgResultEntryHeader.getEmployee().getMiddleName();
			}if( dgresultHeader.getEmployee().getLastName() !=null){
				 VLName=dgresultHeader.getEmployee().getLastName() ;
			}
			%>
		<label class="value"> <%=VFName+" "+ VMName+" "+ VLName %></label>
		<%}else { %>
		<input type="hidden" id="<%=RESULT_ENTERED_BY %>"
			name="<%=RESULT_ENTERED_BY %>" value="" /> <label class="value">
			-</label>
		<%} %>
		<div class="clear"></div>
	</div>
	<h4>Result Details</h4>
	<div class="clear"></div>
	<div class="Block">
		<div class="clear"></div>
		<label>Date</label>
		<%if(dgresultHeader.getResultDate() != null){ %>
		<label class="value"><%=HMSUtil.changeDateToddMMyyyy(dgresultHeader.getResultDate()) %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<label>Entered By:</label>
		<%if(dgresultHeader.getEmployee() != null) {%>
		<input type="hidden" id="<%=RESULT_ENTERED_BY %>"
			name="<%=RESULT_ENTERED_BY %>"
			value="<%=dgresultHeader.getEmployee().getFirstName() %>" />
		<%
			String EFName="";
			String EMName="";
			String ELName="";
			if(dgresultHeader.getEmployee().getFirstName()!=null){
				EFName=dgresultHeader.getEmployee().getFirstName();
			}if(dgResultEntryHeader.getEmployee().getMiddleName()!=null){
				EMName=dgResultEntryHeader.getEmployee().getMiddleName();
			}if( dgresultHeader.getEmployee().getLastName() !=null){
				ELName=dgresultHeader.getEmployee().getLastName() ;
			}
			%>

		<label class="value"> <%=EFName+" "+EMName+" "+ELName%></label>
		<%}else { %>
		<input type="hidden" id="<%=RESULT_ENTERED_BY %>"
			name="<%=RESULT_ENTERED_BY %>" value="" /> <label class="value">
			-</label>
		<%} %>

		<div class="clear"></div>
	</div>
	<h4>Result Validation Details</h4>
	<div class="clear"></div>
	<div class="Block">
		<div class="clear"></div>
		<input type="hidden" name="<%=RESULT_NO %>"
			value="<%=dgResultEntryHeader.getResultNo() %>" />
			
			 <label>Date</label>
		<label class="value"><%=date%></label>
		
		 <label>Time</label>
		<label class="value"><%=time%></label>
		<%-- <label>Result
			Validated Time</label> <label class="value"><%=time%> --%>
		</label> <label><span>*</span>Result Validated By</label>
		
		
		<%MasEmpaneled masEmpaneled = (MasEmpaneled)session.getAttribute("users");
		//Integer empId =masEmpaneled.getEmployee().getId();
		String empFName="";
		String empMName="";
		String empLName=""; 
		if(masEmpaneled.getEmpaneledName()!=null){
			empFName=masEmpaneled.getEmpaneledName();
		}  %>
		<label class="valueAuto"><%=empFName%></label>
		<%-- <input type="hidden" name="<%=RESULT_VALIDATED_BY %>"
			value="<%=empId%>" /> --%>



		<%-- <select
			id="<%=RESULT_VALIDATED_BY %>" name="<%= RESULT_VALIDATED_BY %>"
			validate="Result Validated By,string,yes" tabindex=1>
			<option value="">Select</option>
			<%for(MasEmployee masEmployee : employeeList){%>
			<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
			<%	} %>
		</select> --%>
		<div class="clear"></div>
		<label>Clinical Notes</label>
		<%if(dgresultHeader.getSampleCollectionHeader().getOrder().getClinicalNote() != null){ %>
		<label class="valueAuto"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getClinicalNote() %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<input type=hidden value=0 name=pagecounter2 /> <input type="hidden"
			name="pageNo" id="pageNo" value="<%=pageNo%>" />
		<div class="clear"></div>
	</div>
	<!-- Block Three Ends -->
	<div class="clear"></div>
	<!-- Table Starts -->
	<label
		style="width: auto; padding-left: 10px; padding-top: 0px; color: red;">
		(In Result Column: Special Characters like (,-,@ etc) are not allowed
		only numeric value can be entered.) </label>
	<div class="clear"></div>
	<div class="cmntable">
		<table id="chargeDetails" width="100%" cellpadding="0" cellspacing="0"
			style="height: auto;">

			<tr>
				<th width="7%">S.No.</th>
				<%-- <%if(deptType.equalsIgnoreCase("DIAG")){ %>
				<th width="4%">Reprocess<input type="checkbox" name="checkall1"
					value="Validate All" id="addbutton" onclick="CheckAll();"
					class="radioCheck" /></th>
				<%} %> --%>
				<th width="7%">Test Name</th>
				<%-- <%if(deptType.equalsIgnoreCase("DIAG")){ %> --%>
				<th width="7%">Sample</th>
				<%-- 	<%} %> --%>
				<th width="10%">Result</th>
				<%if(RequestConstants.UHID_FOR_QUALITY_TESTING.equalsIgnoreCase(dgResultEntryHeader.getHin().getHinNo())){%>
				<th width="10%">QC Result</th>
				<%} %>
				<%if(deptType.equalsIgnoreCase("DIAG")){ %>
				<th width="10%">UOM</th>
				<%} %>
				<%if(deptType.equalsIgnoreCase("DIAG")){ %>
				<th width="10%">Normal Range</th>
				<%} %>
				<%if(deptType.equalsIgnoreCase("DIAG")){ %>
				<th scope="col">Accepted <input type="checkbox" name="checkall"
					class="radioCheck" value="Collected All" id="addbutton"
					onclick="CheckAll(this);" align="right" /></th>
				<%} %>
				<%if(deptType.equalsIgnoreCase("RADIO")){ %>
				<th width="10%">Remark</th>
				<%} %>
				<th scope="col">Retest <input type="checkbox"
					name="checkAllRetest" class="radioCheck" value="Retest All"
					id="retestAllButton" onclick="checkAllRetested(this);"
					align="right" />
				</th>
				<th scope="col">Recollect<input type="checkbox"
					name="checkAllRecollect" class="radioCheck" value="Recollect All"
					id="recollectAllButton" onclick="checkAllRecollected(this);"
					align="right" />
				</th>
				<%if(deptType.equalsIgnoreCase("DIAG")){ %>
				<th width="4%">Reason</th> 
				<%} %> 
				<th width="4%">SMS Abnormal Result</th>
				<%
    int index = 0;
    int indexForSingle = 0;
    int indexForMultiple = 0;

    for(DgResultEntryHeader dgResultEntryHeader2 : resultList){
 		if(dgResultEntryHeader2.getResultType() != null
				&& dgResultEntryHeader2.getResultType().equalsIgnoreCase("v") && dgResultEntryHeader2.getDgResultEntryDetailSens().iterator().hasNext()){

 			DgResultEntryDetailSen dgDetail = dgResultEntryHeader2.getDgResultEntryDetailSens().iterator().next();
 			%>

				<tr><%=dgDetail.getInvestigation().getInvestigationName() %></tr>

				<tr>
					<td><%=index+1 %></td>
					<td>
						<%if(dgDetail.getInvestigation() !=null){

			              %> <label name="<%=INVESTIGATION_NAME %>"
						style="font-weight: bold;"><%=dgDetail.getInvestigation().getInvestigationName() %>
					</label> <%}else { %> <label style="font-weight: bold;">-</label> <%} %>
					</td>
					<td></td>
					<td><input name="resultIdSensitive"
						id="resultIdSensitive<%=index%>" type="hidden"
						value="<%=dgDetail.getResultEntry().getId()%>"> </input> <input
						type="button" class="buttonBig2" value="Click Here To Fill Result"
						onclick="openSensitiveScreen('<%=index%>');" align="right" /></td>
					<td></td>

				</tr>

				<%	}else{
			if(dgResultEntryHeader2.getDgResultEntryDetails().iterator().hasNext()){
		 	DgResultEntryDetail dgDetail = dgResultEntryHeader2.getDgResultEntryDetails().iterator().next();
		//	for(DgResultEntryDetail dgDetail : dgDtSet){
	    	if(dgDetail.getInvestigation().getInvestigationType().equals("s")){
					System.out.println("**************** line number for 759 for single parameter");
			    %>
				<tr>
					<td><%=index+1 %></td>
					<%-- <td>
						<% if(dgDetail.getValidated() != null) {%> <input
						id="checkIdSingleValue<%=indexForSingle%>"
						name="checkIdSingleValue<%=indexForSingle%>" type="checkbox"
						class="radioCheck" /> <%}else{ %> <input
						id="checkIdSingleValue<%=indexForSingle%>"
						name="checkIdSingleValue<%=indexForSingle%>" type="checkbox"
						class="radioCheck" /> <%} %>
					</td> --%>
					<td width="7%">
						<%if(dgDetail.getInvestigation() !=null){

			              %> <input type="hidden"
						name="<%=RESULT_ID_SINGLE_VALUE %>"
						id="<%= RESULT_ID_SINGLE_VALUE%>"
						value="<%=dgResultEntryHeader2.getId() %>" /> <input
						name="<%=RESULT_TYPE_SINGLE_VALUE %>" type="hidden" size="10"
						value="<%=dgDetail.getResultType() %>" readonly /> <input
						name="<%=INVESTIGATION_ID_SINGLE_VALUE %>" type="hidden" size="5"
						value="<%=dgDetail.getInvestigation().getId() %>" readonly /> <label
						style="font-weight: bold;"><%=dgDetail.getInvestigation().getInvestigationName()%></label>

						<%}else { %> <label style="font-weight: bold;">-</label> <%} %>
					</td>
					<%if(deptType.equalsIgnoreCase("DIAG")){ %>
					<td width="7%">
						<%if(dgDetail.getSample() !=null){ %><label><%=dgDetail.getSample().getSampleDescription() %></label>
						<input name="<%=SAMPLE_ID_SINGLE_VALUE %>"
						id=<%=SAMPLE_ID_SINGLE_VALUE %> type="hidden" size="5"
						value="<%=dgDetail.getSample().getId() %>" readonly type="hidden" />
						<input name="sample2"
						value="<%=dgDetail.getSample().getSampleDescription() %>"
						readonly="readonly" type="hidden" /> <%}else { %> <input
						name="sample" readonly="readonly" type="hidden"></input><label>-</label>
						<%} %>
					</td>
					<%} %>
					<td>
						<%
				    try{
				    	if(dgDetail.getInvestigation().getMinNormalValue() != null
				    		&& dgDetail.getInvestigation().getMaxNormalValue() != null
				    		&& !dgDetail.getInvestigation().getMinNormalValue().equals("")
				    		&& !dgDetail.getInvestigation().getMaxNormalValue().equals("")){

				    		Float minValue = Float.parseFloat(dgDetail.getInvestigation().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getInvestigation().getMaxNormalValue());
				    		if(dgDetail.getResult() != null
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <input
						name="<%=RESULT_SINGLE_VALUE %>" tabindex="1"
						onkeyup="submitAllExceptEnter(this,event,'','<%=index+1 %>');"
						id="<%=RESULT_SINGLE_VALUE %><%=index+1 %>" value="<%=result %>" />
						<% }else{ %> <input name="<%=RESULT_SINGLE_VALUE %>" tabindex="1"
						onkeyup="submitAllExceptEnter(this,event,'','<%=index+1 %>');"
						id="<%=RESULT_SINGLE_VALUE %><%=index+1 %>" class="highlight"
						value="<%=result %>" /> <% }
					    	}else{%> <input name="<%=RESULT_SINGLE_VALUE %>" tabindex="1"
						onkeyup="submitAllExceptEnter(this,event,'','<%=index+1 %>');"
						id="<%=RESULT_SINGLE_VALUE %><%=index+1 %>"
						value="<%=dgDetail.getResult()%>" /> <%}
					       }else{ %> <input name="<%=RESULT_SINGLE_VALUE %>"
						tabindex="1"
						onkeyup="submitAllExceptEnter(this,event,'','<%=index+1 %>');"
						id="<%=RESULT_SINGLE_VALUE %><%=index+1 %>"
						value="<%=dgDetail.getResult()%>" /> <% }
				    }catch(Exception exception){ %> <input
						name="<%=RESULT_SINGLE_VALUE %>" tabindex="1"
						onkeyup="submitAllExceptEnter(this,event,'','<%=index+1 %>');"
						id="<%=RESULT_SINGLE_VALUE %><%=index+1 %>"
						value="<%=dgDetail.getResult()%>" /> <% } %>
					</td>
					<%if(RequestConstants.UHID_FOR_QUALITY_TESTING.equalsIgnoreCase(dgResultEntryHeader.getHin().getHinNo())){%>
					<td><input type="hidden" name="<%=QC_RESULT_SINGLE_VALUE %>"
						tabindex="1" id="<%=QC_RESULT_SINGLE_VALUE %><%=index+1 %>"
						value="<%=dgDetail.getQcResult() %>" /><label><%=dgDetail.getQcResult() %></label></td>
					<%} %>
					<%if(deptType.equalsIgnoreCase("DIAG")){ %>
					<td width="10%">
						<%if(dgDetail.getUom() !=null){ %> <input
						name="<%=UNIT_OF_MEASUREMENT_ID_SINGLE_VALUE %>"
						id="<%=UNIT_OF_MEASUREMENT_ID_SINGLE_VALUE %>" type="hidden"
						size="5" value="<%=dgDetail.getUom().getId()%>" readonly /> <input
						name="uom" value="<%=dgDetail.getUom().getUomName() %>"
						readonly="readonly" /> <%}else { %> <input name="uom" value="-"
						readonly="readonly" /> <%} %>
					</td>
					<%} %>



					<%if(deptType.equalsIgnoreCase("DIAG")){ %>
					<td width="10%">
						<%if(dgDetail.getInvestigation().getNormalValue() != null || dgDetail.getInvestigation().getMinNormalValue() != null || dgDetail.getInvestigation().getMaxNormalValue() != null){ %>
						<%if(dgDetail.getInvestigation().getNormalValue() != null ){
							if(!dgDetail.getInvestigation().getNormalValue().equals("")){
						%> <input name="normalValue" type="text" size="8"
						value="<%=dgDetail.getInvestigation().getNormalValue()%>" readonly />
						<%}else if (dgDetail.getInvestigation().getMinNormalValue()!= null && dgDetail.getInvestigation().getMaxNormalValue() != null){ %>
						<input name="normalValue" type="text" style="" size="10"
						value="<%=dgDetail.getInvestigation().getMinNormalValue()+" - "+dgDetail.getInvestigation().getMaxNormalValue()%>"
						readonly /> <%}
							}
						else if(dgDetail.getInvestigation().getMinNormalValue()!= null && dgDetail.getInvestigation().getMaxNormalValue() != null){ %>
						<input name="normalValue" type="text" size="8"
						value="<%=dgDetail.getInvestigation().getMinNormalValue()+" - "+dgDetail.getInvestigation().getMaxNormalValue()%>"
						readonly /> <%}}else{ %> <input name="normalValue" type="text"
						size="8" value="" readonly /> <%} %>
					</td>
					<%} %>
					<td width="4%"><input
						id="checkIdSingleValue<%=indexForSingle%>"
						name="checkIdSingleValue<%=indexForSingle%>" type="checkbox"
						class="radioCheck" onclick="accepted(this,<%=indexForSingle%>);" /></td>
					<td width="4%"><input
						id="checkIdSingleValueRetest<%=indexForSingle%>"
						name="checkIdSingleValueRetest<%=indexForSingle%>" type="checkbox"
						class="radioCheck" onclick="retest(this,<%=indexForSingle%>);" /></td>
					<td width="4%"><input
						id="checkIdSingleValueRecollect<%=indexForSingle%>"
						name="checkIdSingleValueRecollect<%=indexForSingle%>"
						type="checkbox" class="radioCheck"
						onclick="recollect(this,<%=indexForSingle%>);" /></td>
					<td>
						<%if(dgDetail.getRemarks() != null){ %> <input
						value="<%=dgDetail.getRemarks() %>" onkeyup="chkLength(this,100);"
						id="<%=ADDITIONAL_REMARKS_SINGLE_VALUE %>"
						name="<%=ADDITIONAL_REMARKS_SINGLE_VALUE %>"></input> <%}else{ %> <input
						value="" onkeyup="chkLength(this,100);"
						id="<%=ADDITIONAL_REMARKS_SINGLE_VALUE %>"
						name="<%=ADDITIONAL_REMARKS_SINGLE_VALUE %>"></input> <%} %>
					</td>
					<td><input type="checkbox" name="sms<%=indexForSingle%>"
					class="radioCheck" value="yes" id="smsButton" 
					align="right" /></td>

				</tr>

				<%
		 indexForSingle++;
		}else if(dgDetail.getInvestigation().getInvestigationType().equals("t")){ 
		%>
				<tr>

					<td><%=index+1 %></td>
					<td>
						<%if(dgDetail.getInvestigation() !=null){
			              %> <label name="<%=INVESTIGATION_NAME %>"
						style="font-weight: bold;"><%=dgDetail.getInvestigation().getInvestigationName() %>
					</label> <%}else { %> <label style="font-weight: bold;">-</label> <%} %>
					</td>
					<td></td>
					<td><input name="resultIdTemplate"
						id="resultIdTemplate<%=index%>" type="hidden"
						value="<%=dgDetail.getResultEntry().getId()%>"> </input> <input
						type="button" class="buttonBig2"
						value="Click Here To Validate Result"
						onclick="openTemplateScreen('<%=index%>');" align="right" /></td>
					<td></td>
					<td><input id="" name="" type="checkbox" class="radioCheck" /></td>

				</tr>
				<%

		}else if(dgDetail.getInvestigation().getInvestigationType().equals("m")){ 	
		System.out.println("*************** line number for 928 for multiple test"+index);
		%>
				
				<jsp:include page="resultValidationTableForMultipleTestType.jsp"
					flush="true">
					<jsp:param name="resultEntryIndex" value="<%=index%>" />
					<jsp:param name="resultEntryIndexForMultiple"
						value="<%=indexForMultiple%>" />
				</jsp:include>
				<%  
			indexForMultiple = indexForMultiple + dgResultEntryHeader2.getDgResultEntryDetails().size()+1;
			//index=indexForMultiple-1;
		}
		}
 		index++;
			}
    	} %>
				<input type="hidden" name="counter" id="counter" value="<%=index+indexForMultiple%>" />
		</table>
	</div>

	<div class="clear"></div>
	<input type="hidden" name="validatedCheckBoxCountSingle"
		id="validatedCheckBoxCountSingle" value="<%=indexForSingle%>" /> <input
		type="hidden" name="validatedCheckBoxCountMultiple"
		id="validatedCheckBoxCountMultiple" value="<%=indexForMultiple%>" />
	<input type="hidden" name="resultIdStringForTemplate"
		id="resultIdStringForTemplate" value="<%=resultId%>" />
	<!-- Table Ends -->
	<div class="paddingTop15"></div>

	<!--Bottom labels starts-->
	<div class="clear"></div>
	<div class="division"></div>

	<input type="button" class="button" value="Submit"
		onclick="if(inputValidate()){submitForm('sampleCollection','investigation?method=submitResultValidationForAllInvestigationTypeLabForEmpanelled')};"
		align="right" /> <input name="Button" type="button"
		class="buttonHighlight" value="Reset" onclick="resetResult();" /> <input
		name="Button" type="button" class="button" value="Back"
		onclick="history.back();" />
	<div class="clear"></div>
	<div class="division"></div>
	<div class="bottom">
		<div class="clear"></div>
		<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
			Date</label> <label class="value"><%=date%></label> <label>Changed
			Time</label> <label class="value"><%=time%></label>
	</div>
	<!--Bottom labels ends-->
	<div class="clear"></div>
	<div class="division"></div>
	<div class="paddingTop40"></div>
</form>
<!--main content placeholder ends here-->

<script type="text/javascript">
function checkForNumericResult(obj,inc)
{
	if(obj.value != ''){
		var flag = validateNumeric(obj.value);
		if(flag == false){
			alert('\''+obj.value + '\' is not Accepted in Result Column at row ' + inc + '.\nOnly numeric value is allowed in Result.');
			return false;
		}
	}
	return true;
}
function submitAllExceptEnter(myfield,e,url,inc)
{
	var keycode;
	if (window.event)
		 keycode = window.event.keyCode;
	else if (e)
		keycode = e.which;
	else
		return true;
	//if (keycode != 13) {
	//	if(checkForNumericResult(myfield,inc)){
	//		return true;
		//}else{
			document.getElementById('<%=RESULT_SINGLE_VALUE %>'+inc).value = '';
			return false;
		//}
	//}
}
function checkForNumericResultMultiple(obj,inc,mainCount,subCount)
{
	if(obj.value != ''){
		var flag = validateNumeric(obj.value);
		if(flag == false){
			alert('\''+obj.value + '\' is not Accepted in Result Column at row ' + mainCount + '.' + subCount+ '.\nOnly numeric value is allowed in Result.');
			return false;
		}
	}
	return true;
}

function submitAllExceptEnterForMultiple(myfield,e,url,inc,mainCount,subCount)
{
	var keycode;
	if (window.event)
		 keycode = window.event.keyCode;
	else if (e)
		keycode = e.which;
	else
		return true;
	if (keycode != 13) {
		var chargeCodeCode = document.getElementById('chargeCodeCodeForPerticularTestForMultiple'+inc).value;
		//if(chargeCodeCode != 'HA25'){
		//	if(checkForNumericResultMultiple(myfield,inc,mainCount,subCount)){
		//		return true;
		//	}else{
				<%-- document.getElementById('<%=RESULT%>'+inc).value = ''; --%>
			return false;
			//}
		}
	}
</script>
