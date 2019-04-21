<%@page import="jkt.hms.masters.business.BloodStockDetail"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.OpdTemplateTreatment"%>


<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<form name="popGenExam" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<OpdTemplateTreatment> templateGeneTreatmentList = new ArrayList<OpdTemplateTreatment>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("templateGeneTreatmentList") != null){
		templateGeneTreatmentList=(List<OpdTemplateTreatment>)map.get("templateGeneTreatmentList");
	}
	
	boolean preAnesthesia=false;
	if(map.get("preAneshesiaDoctorNotesFlag")!=null && map.get("preAneshesiaDoctorNotesFlag").equals("preAneshesiaDoctorNotes")){
		preAnesthesia=true;
	}
%> 
<h2>General Examination Templates</h2>

<% if(templateGeneTreatmentList.size() == 0){
	%>
<h4><span>No Record Found</span></h4>
<% 							}else{%>
<div class="smallWithHeight">
<table colspan="7" id="componentDetails" cellpadding="0"
	cellspacing="0">

	<thead>
		<tr>
			<th scope="col"><input type="checkbox" name="checkall"
			class="radioCheck" value="Collected All" id="addbutton"
			onclick="CheckAll(this);" align="right" /></th>
			<th scope="col">Template Name</th>
		</tr>
	</thead>
	<tbody>
		<%
		int i=0;
	for(OpdTemplateTreatment treaTemplateTreatment :templateGeneTreatmentList){
 %>
		<%
		String genExamTemp="";
		String generalExamination="";
		String templateName="";
		if(treaTemplateTreatment.getTemplate() !=null ){
		 	 if(treaTemplateTreatment.getGeneralExamination() !=null && !treaTemplateTreatment.getGeneralExamination().equals("") && treaTemplateTreatment.getGeneralExamination().length()>0){
		 			 templateName=treaTemplateTreatment.getGeneralExamination();
	 				
 %>
		<tr>
			<td><input id="checkId<%=i %>" name="checkedTemp" type="checkbox"  class="radioCheck" value="n"/>
			<input type="hidden" name="rowLength" id="rowLength" value="<%=templateGeneTreatmentList.size()%>"/></td>
			
			<td>
				<input type="text" value="<%= templateName%>" name="generalExamination" id="generalExamination<%=i %>" size="40"/>
							</td>
		</tr>
		<%i++;
}    %>
		<%} 
}
		%>

	</tbody>
</table></div>
				<input type="hidden" value="<%=i %>" name="rowVal" id="rowVal"/>			
	
	
	<%if(preAnesthesia){ %>
	<input name="" type="button" class="button" value="OK" onclick="setGeneralExamTempalteToPreAnesthesia();window.close();"" />
	<%}else{ %>
	<input name="" type="button" class="button" value="OK" onclick="setGeneralExamTempalte();window.close();"" />
	<%}} %>
	 
	<input name="" type="button" class="button"	value="Close" onclick="cancelForm();" />  	
</form>
<script>
 function cancelForm(){
   	   window.close();
  }
   
 
  	
   function setGeneralExamTempalte(){
		  
	   var generalExam = "";
	   var  checkId;
	   var rowVal= document.getElementById('rowVal').value;
	   for(i=0;i<rowVal;i++){
		 checkId = document.getElementById('checkId'+i);
	     if(checkId.checked == true){
		   generalExam += document.getElementById('generalExamination'+i).value+"\n";
		}
		
	 }
	 window.opener.document.getElementById('generalExaminationOPC').value=generalExam;
	 window.opener.document.getElementById('generalExaminationEXM').value=generalExam;
	 window.opener.document.getElementById('generalExaminationOPC').focus();
		 window.close();
  	}
   
   function setGeneralExamTempalteToPreAnesthesia(){
	   var generalExam = "";
	   var  checkId;
	   var rowVal= document.getElementById('rowVal').value;
	   for(i=0;i<rowVal;i++){
		 checkId = document.getElementById('checkId'+i);
	     if(checkId.checked == true){
		   generalExam += document.getElementById('generalExamination'+i).value+"\n";
		}
		
	 }
	 window.opener.document.getElementById('referralNote').value=generalExam;
	 window.opener.document.getElementById('referralNote').focus();
		 window.close();
   }
  	
   function CheckAll(chk){
	   var rowLength=document.getElementById('rowLength').value;
	   for (var i=0;i <document.popGenExam.elements.length;i++)
	   	{
	   		var e = document.popGenExam.elements[i];

	   		if (e.type == "checkbox")
	   		{
	   			e.checked = chk.checked;
	   			for(var j=0;j<rowLength;j++)
	   			{
	   				e.value="y";
	   			}
	   		}
	   	}
	   }
	</script>