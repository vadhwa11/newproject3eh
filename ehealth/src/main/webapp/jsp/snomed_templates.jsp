<%@page import="jkt.hms.masters.business.OpdTemplateTreatment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="java.util.*"%>


<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<OpdTemplateTreatment>opdTemplates=new ArrayList<OpdTemplateTreatment>();
	if(map.get("templates")!=null){
		opdTemplates=(List<OpdTemplateTreatment>)map.get("templates");
	}
	String msg="";
	Boolean flag=false;
	if(map.get("msg")!=null){
		msg=(String)map.get("msg");
		flag=(Boolean)map.get("flag");
	}
%>

<%
if(flag!=null && flag){
	if(msg!=null && !msg.equals("")) {%>
	<label class="autoSize"><span><%=msg %></span></label>
	<%}
}else{ %>
	<label>Snomed Templates</label>
<%} %>
<div class="paddingTop25"></div>
<div class="clear"></div>
<div class="Block">
<form name="snomedTemplates" id="snomedTemplates" action="" method="post">

<label>Present Complaint / History</label>
<select name="presentComplain"  id="presentComplain"  multiple="4" size="5"  class="listSnomed">
<%for(OpdTemplateTreatment opdTemp:opdTemplates){
	if(opdTemp.getPresentComplaintHistory()!=null){
%>
	<option value="<%=opdTemp.getId()%>-0"><%=opdTemp.getPresentComplaintHistory()%></option>
<%}}%>
</select>
<div style="width:38px; height:62px; float:left;">
<input type="button" class="buttonAuto-buttn" id="presentComplainAdd" name="presentComplainAdd" value="+"  onClick="javascript:openPopupWindowSnomedCT(1);"  />
<input type="button" class="buttonCross" id="presentComplainRmv" name="presentComplainRmv" value="x"  />
</div>
  
<label>History of Past Illness</label>
<select name="pastIllness" id="pastIllness"   multiple="4" size="5"  class="listSnomed">
<%for(OpdTemplateTreatment opdTemp:opdTemplates){
	if(opdTemp.getPastIllnessHistory()!=null){
%>
	<option value="<%=opdTemp.getId()%>-0"><%=opdTemp.getPastIllnessHistory()%></option>
<%}}%>
</select>
<div style="width:38px; height:62px; float:left;">
<input type="button" class="buttonAuto-buttn" id="pastIllnessAdd" name="pastIllnessAdd" value="+"  onClick="javascript:openPopupWindowSnomedCT(2);"  />
<input type="button" class="buttonCross" id="pastIllnessRmv" name="pastIllnessRmv" value="x"  />
</div>



<div class="clear"></div>
<label>Personal History</label>
<select name="personalHistory" id="personalHistory"  multiple="4" size="5"  class="listSnomed">
<%for(OpdTemplateTreatment opdTemp:opdTemplates){
	if(opdTemp.getPersonalHistory()!=null){
%>
	<option value="<%=opdTemp.getId()%>-0"><%=opdTemp.getPersonalHistory()%></option>
<%}}%>
</select>
<div style="width:38px; height:62px; float:left;">
<input type="button" class="buttonAuto-buttn" id="personalHistoryAdd" name="personalHistoryAdd" value="+"  onClick="javascript:openPopupWindowSnomedCT(3);"    />
<input type="button" class="buttonCross" id="personalHistoryRmv" name="personalHistoryRmv" value="x"  />
</div>

<label>Family History</label>
<select name="familyHistory"  id="familyHistory"  multiple="4" size="5"  class="listSnomed">
<%for(OpdTemplateTreatment opdTemp:opdTemplates){
	if(opdTemp.getFamilyHistory()!=null){
%>
	<option value="<%=opdTemp.getId()%>-0"><%=opdTemp.getFamilyHistory()%></option>
<%}}%>
</select>
<div style="width:38px; height:62px; float:left;">
<input type="button" class="buttonAuto-buttn" id="familyHistoryAdd" name="familyHistoryAdd" value="+"  onClick="javascript:openPopupWindowSnomedCT(4);"  />
<input type="button" class="buttonCross" id="familyHistoryRmv" name="familyHistoryRmv" value="x"  />
</div>

<div class="clear"></div>

<label>Medication History</label>
<select name="medicationhistory" id="medicationhistory"  multiple="4" size="5"  class="listSnomed">
<%for(OpdTemplateTreatment opdTemp:opdTemplates){
	if(opdTemp.getMedicationHistory()!=null){
%>
	<option value="<%=opdTemp.getId()%>-0"><%=opdTemp.getMedicationHistory()%></option>
<%}}%>
</select>
<div style="width:38px; height:62px; float:left;">
<input type="button" class="buttonAuto-buttn" id="medicationhistoryAdd" name="medicationhistoryAdd" value="+"  onClick="javascript:openPopupWindowSnomedCT(5);" />
<input type="button" class="buttonCross" id="medicationhistoryRmv" name="medicationhistoryRmv" value="x"  />
</div>

<label>Systemic Examination</label>
<select name="systemic" id="systemic"  multiple="4" size="5"  class="listSnomed">
<%for(OpdTemplateTreatment opdTemp:opdTemplates){
	if(opdTemp.getSystemicExamination()!=null){
%>
	<option value="<%=opdTemp.getId()%>-0"><%=opdTemp.getSystemicExamination()%></option>
<%}}%>
</select>
<div style="width:38px; height:62px; float:left;">
<input type="button" class="buttonAuto-buttn" id="systemicAdd" name="systemicAdd" value="+" onClick="javascript:openPopupWindowSnomedCT(6);" />
<input type="button" class="buttonCross" id="systemicRmv" name="systemicRmv" value="x"  />
</div>


<div class="clear"></div>
<label>General Examination</label>
<select name="general" id="general"  multiple="4" size="5"  class="listSnomed">
<%for(OpdTemplateTreatment opdTemp:opdTemplates){
	if(opdTemp.getGeneralExamination()!=null){
%>
	<option value="<%=opdTemp.getId()%>-0"><%=opdTemp.getGeneralExamination()%></option>
<%}}%>
</select>
<div style="width:38px; height:62px; float:left;">
<input type="button" class="buttonAuto-buttn" id="generalAdd" name="generalAdd" value="+"  onClick="javascript:openPopupWindowSnomedCT(7);" />
<input type="button" class="buttonCross" id="generalRmv" name="generalRmv" value="x"  />
</div>

<div class="clear"></div>
<input type="button" class="buttonAuto-buttn"  value="submit" onclick="submitSnomedTemplate()" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>
</div>

<link href="/hms/jsp/css/jquery-ui.css" rel="stylesheet" />	
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/jquery-ui.js"></script>
<script src="/hms/jsp/js/jquery.min.js"></script>
<link rel="stylesheet" href="/hms/jsp/css/jquery-ui.css">
<script>jQuery.noConflict();</script>
<div id="dialog-confirm"></div>
<script type="text/javascript">
jQuery(function ($) {
	$("#presentComplainRmv").click(function(){
		if(confirm("Do you want to delete !")){
			$('#presentComplain').find('option:selected').remove().end();	
		}
	});
	
	$("#pastIllnessRmv").click(function(){
		$('#pastIllness').find('option:selected').remove().end();
	}); 
	
	$("#personalHistoryRmv").click(function(){
		$('#personalHistory').find('option:selected').remove().end();
	}); 
	
	$("#familyHistoryRmv").click(function(){
		$('#familyHistory').find('option:selected').remove().end();
	}); 
	
	$("#medicationhistoryRmv").click(function(){
		$('#medicationhistory').find('option:selected').remove().end();
	}); 
	
	$("#systemicRmv").click(function(){
		$('#systemic').find('option:selected').remove().end();
	}); 
	
	$("#generalRmv").click(function(){
		$('#general').find('option:selected').remove().end();
	}); 
}); 
function submitSnomedTemplate(){
	if(confirm("Do you want to submit !")){
		submitForm('snomedTemplates','opd?method=snomedTemplatesJsp');
	}
}
function jsSetSnomedFindingData(findingCode)
{
document.getElementById("finding").value=findingCode;
document.getElementById("finding").focus();
}

function openPopupWindowSnomedCT(code)
{
 var url="/hms/hms/opd?method=showSnomedCTSearchJsp&code="+code+"&"+csrfTokenName+"="+csrfTokenValue;
 newwindow=window.open(url,'opd_window',"left=100,top=100,height=640,width=850,status=1,scrollbars=yes,resizable=0");
}
function addTermInSelect(termId,term,action,code){
	/* Delete duplicate entry options*/
	var desSelect=null;
	switch(code){
	case '1':desSelect=document.getElementById("presentComplain");break;
	case '2':desSelect=document.getElementById("pastIllness");break;
	case '3':desSelect=document.getElementById("personalHistory");break;
	case '4':desSelect=document.getElementById("familyHistory");break;
	case '5':desSelect=document.getElementById("medicationhistory");break;
	case '6':desSelect=document.getElementById("systemic");break;
	case '7':desSelect=document.getElementById("general");break;
	}
	
	if(desSelect.length>0){
		for(var x=0;x<desSelect.length;x++){
			if(desSelect[x].id==termId){
				desSelect.remove(x);
			}
		}
	}
	
	/* Add new options */
	var select = null;
	var newOption = document.createElement("option");
	newOption.text =term;
	newOption.value ="0-"+termId+":"+term;
	newOption.setAttribute("selected", "selected");
	switch(code){
		case '1':select=document.getElementById("presentComplain");break;
		case '2':select=document.getElementById("pastIllness");break;
		case '3':select=document.getElementById("personalHistory");break;
		case '4':select=document.getElementById("familyHistory");break;
		case '5':select=document.getElementById("medicationhistory");break;
		case '6':select=document.getElementById("systemic");break;
		case '7':select=document.getElementById("general");break;
	}
	
		if(action==1){
			select.appendChild(newOption);	
		}else if(action==2){
			  for (var i=0; i<select.length; i++){
			  if (select.options[i].id == termId )
				  select.remove(i);
			  }
		}
		
}	
</script>
 
