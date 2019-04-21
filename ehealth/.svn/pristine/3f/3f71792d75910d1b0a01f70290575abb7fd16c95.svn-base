<%@page import="jkt.hms.masters.business.EmpScMapping"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.*" %>


<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%
	Map map=new HashMap();
	/* List<MasEmployee>doctorList=new ArrayList<MasEmployee>(); */
	List<MasEmployee> masEmployeeList=new ArrayList<MasEmployee>();
	if(request.getAttribute("map")!=null){
		map=(Map)request.getAttribute("map");
	}
	if(map.get("masEmployeeList")!=null){
		masEmployeeList=(List<MasEmployee>)map.get("masEmployeeList");
	}
	int visitId=0;
	int hinId=0;
	String uhidNo="";
	
	if(map.get("visitId") !=null ){
		visitId=(Integer)map.get("visitId");
	}
	if(map.get("hinId") !=null ){
		hinId=(Integer)map.get("hinId");
	}
	if(map.get("uhidNo") !=null ){
		uhidNo=(String)map.get("uhidNo");
	}
	boolean status=false;
	
	if(map.get("status") !=null ){
		status=(Boolean)map.get("status");
	}
%>

<title>Second Opinion</title>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<%if(status){%>
	<font size="4" weight="bold" color="green">Save SuccessFully !  </font>
<%}%>
<script type="text/javascript">
	function submitSecondOpinion(){
		var comments=document.getElementById('comments').value;
		var patientDetailsStatus=document.getElementById('patientDetailsStatus').value;
		var secondOpinionDoc=document.getElementById('secondOpinionDoc').value;
		var ehr=document.getElementById('ehr').value;
		var Investigation=document.getElementById('Investigation').value;
		var prescription=document.getElementById('prescription').value;
		var casesheet=document.getElementById('caseSheet').value;
		var hinId=document.getElementById('hinId').value;
		var uhidNo=document.getElementById('uhidNo').value;
		var visitId=document.getElementById('visitId').value;
		/* if(comments !=""){
		submitForm('secondopinion','/hms/hms/opd?method=submitSecondOpinion');
		opener.fnSubmitPatient('secondop');
		//window.close();
		}
		else{
			alert("Comments can not blanck ")
		} */
		
		if (confirm("Do you want patient send to Second Opinion !")) {
		if(comments!=""){
			var xmlHttp=null;
			  try {
			    // Firefox, Opera 8.0+, Safari
			    xmlHttp=new XMLHttpRequest();
			  }catch (e){
			    // Internet Explorer
			    try{
			      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
			    }catch (e){
			    	alert(e);
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
			    	  var data=this.responseText;
				    	alert(data);
				    	opener.fnSubmitPatient('secondop');
				    	window.close();
			      }
			    };

			       var url="/hms/hms/opd?method=submitSecondOpinion&comments="+comments+"&patientDetailsStatus="+patientDetailsStatus+"&secondOpinionDoc="+secondOpinionDoc+"&ehr="+ehr+"&Investigation="+Investigation+"&prescription="+prescription+"&casesheet="+casesheet+"&hinId="+hinId+"&uhidNo="+uhidNo+"&visitId="+visitId;
		   	 	   url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
			    xmlHttp.open("POST",url,false);
			    xmlHttp.setRequestHeader("Content-Type", "text/xml");
			    xmlHttp.send(null);
		}else{
			alert("Comments can not blanck ");
		}
		}
	}
	
</script>

<form id="secondopinion" name="secondopinion" method="post" action="">

<input type="hidden" name="uhidNo" id="uhidNo" value="<%=uhidNo %>"/>
<input type="hidden" name="hinId" id="hinId" value="<%=hinId %>"/>
<input type="hidden" name="visitId" id="visitId" value="<%=visitId %>"/>

<h4>Second Opinion</h4>
<div class="Block" style="width:840px">
<label>Doctor<span>*</span></label>
<select id="secondOpinionDoc" name="secondOpinionDoc" id="secondOpinionDoc" validate="Doctor,string,yes">
	<option value="">Select</option>
	<%if(null !=masEmployeeList && masEmployeeList.size()>0){
	for(MasEmployee doctor:masEmployeeList)
		{
		String docName=doctor.getEmployeeName();
	%>
	<option value="<%=doctor.getId()%>"><%=docName%></option>
	<%} }%>
</select>
<label>EHR</label>
<input type="checkbox" name="ehr" id="ehr" value="y">
<div class="clear"></div>
<label>Investigation</label>
<input type="checkbox" name="Investigation" id="Investigation" value="y">
<label>Prescription</label>
<input type="checkbox" name="prescription" id="prescription" value="y">
<div class="clear"></div>
<label>CaseSheet</label>
<input type="checkbox" name="caseSheet" id="caseSheet" value="y">
<label>Patient Details</label>
<input type="checkbox" name="patientDetailsStatus" id="patientDetailsStatus" value="y" checked="checked">


<div class="clear"></div>
<label>Comments<span>*</span></label>
<textarea class="large" name="comments" id="comments"  validate="comments,string,yes"  cols="0"	rows="10" maxlength="200" tabindex="5" ></textarea>
<div class="clear"></div>
<div class="paddLeft55">
<input type="button" class="button" name="prev" value="save" onClick="submitSecondOpinion();"  />
<input type="button" class="button" name="next" value="Reset" onclick="setFocus();" /></div>
</div>
 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<script type="text/javascript">
	var csrfTokenName='${_csrf.parameterName}';
	var csrfTokenValue='${_csrf.token}';
	
	 function setFocus()
     {
  	     document.getElementById("secondopinion").reset();
          
     }
	
</script>

 </form>

