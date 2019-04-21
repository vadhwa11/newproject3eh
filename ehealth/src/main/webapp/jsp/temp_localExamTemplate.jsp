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
<form name="popSysExam" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<OpdTemplateTreatment> templateSysTreatmentList = new ArrayList<OpdTemplateTreatment>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("templateSysTreatmentList") != null){
		templateSysTreatmentList=(List<OpdTemplateTreatment>)map.get("templateSysTreatmentList");
	}
%> 
<h2>Local Examination Templates</h2>

<% if(templateSysTreatmentList.size() == 0){
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
	for(OpdTemplateTreatment treaTemplateTreatment :templateSysTreatmentList){
 %>
		<%
		String sysExamTemp="";
		String systemicExamination="";
		if(treaTemplateTreatment.getLocalExamination() !=null){
			if(treaTemplateTreatment.getTemplate() !=null &&  treaTemplateTreatment.getLocalExamination() !=null && !treaTemplateTreatment.getLocalExamination().equals("") && treaTemplateTreatment.getLocalExamination().length()>0){
		 		systemicExamination=treaTemplateTreatment.getLocalExamination();
 %>
		<tr>
			<td><input id="checkId<%=i %>" name="checkedTemp" type="checkbox"  class="radioCheck" value="n"/>
			<input type="hidden" name="rowLength" id="rowLength" value="<%=templateSysTreatmentList.size()%>"/></td>
			
			<td>
				<input type="text" value="<%= systemicExamination%>" name="systemicExamination" id="systemicExamination<%=i %>" size="40"/>
							</td>
		</tr>
		<%i++;
    } %>
		<%} 
}
		%>

	</tbody>
</table></div>
				<input type="hidden" value="<%=i %>" name="rowVal" id="rowVal"/>			
	
	
	<input name="" type="button" class="button" value="OK" onclick="setSystemicExamTempalte();window.close();" /> <%} %>
	<input name="" type="button" class="button"	value="Close" onclick="cancelForm();" /> 	
</form>
<script>
function cancelForm(){
  	   window.close();
 }
  
function setSystemicExamTempalte(){
	   var generalExam = "";
	   var  checkId;
	   var rowVal= document.getElementById('rowVal').value;
	 for(i=0;i<rowVal;i++){
		checkId = document.getElementById('checkId'+i);
	   if(checkId.checked == true){
		   generalExam += document.getElementById('systemicExamination'+i).value+"\n"
		}
	 }
	 window.opener.document.getElementById('localExamination').value=generalExam;
	 window.opener.document.getElementById('localExamination').focus();
		 window.close();
	}
function CheckAll(chk){
	   var rowLength=document.getElementById('rowLength').value;
	   for (var i=0;i <document.popSysExam.elements.length;i++)
	   	{
	   		var e = document.popSysExam.elements[i];

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
