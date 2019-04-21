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
<form name="popFamHistory" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<OpdTemplateTreatment> templateFamilyList = new ArrayList<OpdTemplateTreatment>();
	List<String> historyEnteredValuesList  = new ArrayList<String>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("templateFamilyList") != null){
		templateFamilyList=(List<OpdTemplateTreatment>)map.get("templateFamilyList");
	}
	
	if(map.get("historyEnteredValues") != null){
		String historyEnteredValues			=	(String)map.get("historyEnteredValues");
		String[] historyEnteredValuesArray 	=	historyEnteredValues.split(",");
		historyEnteredValuesList = 	Arrays.asList(historyEnteredValuesArray);
	}
%> 
<h2>Family History Templates</h2>

<% if(templateFamilyList.size() == 0){ %>
<h4><span>No Record Found</span></h4>

<%}else{%>

<div class="smallWithHeight">
<table colspan="7" id="componentDetails" cellpadding="0" cellspacing="0">

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
	for(OpdTemplateTreatment treaTemplateTreatment :templateFamilyList){

		String familyTemp="";
		String familyHistory="";
		if(treaTemplateTreatment.getFamilyHistory() !=null){
			if(treaTemplateTreatment.getTemplate() !=null &&  treaTemplateTreatment.getFamilyHistory() !=null && !treaTemplateTreatment.getFamilyHistory().equals("") && treaTemplateTreatment.getFamilyHistory().length()>0){
		 		familyHistory=treaTemplateTreatment.getFamilyHistory();
 %>
		<tr>
			<td>
				<% if(historyEnteredValuesList.contains(familyHistory)) {%>
			<input id="checkId<%=i %>" name="checkedTemp" type="checkbox" checked="checked"  class="radioCheck" value="n"/>
			<% }else {%>
			<input id="checkId<%=i %>" name="checkedTemp" type="checkbox"  class="radioCheck" value="n"/>
			<% } %>
			<input type="hidden" name="rowLength" id="rowLength" value="<%=templateFamilyList.size()%>"/></td>
			<td><input type="text" value="<%= familyHistory%>" name="familyHistory" id="familyHistory<%=i %>" size="40"/>
							</td>
		</tr>
		<%i++;
    }
 } %>
<%	} %>
	</tbody>
</table></div>
	<input type="hidden" value="<%=i %>" name="rowVal" id="rowVal"/>			
	<%} %>
	
	<input name="" type="button" class="button" value="OK" onclick="setFamilyHistoryTempalte();window.close();"/> 
	<input name="" type="button" class="button"	value="Close" onclick="cancelForm();" /> 	
</form>
<script>
 function cancelForm(){
   	   window.close();
  }
   
   function setFamilyHistoryTempalte(){
	  
	   var generalExam = "";
	   var  checkId;
	   var rowVal= document.getElementById('rowVal').value;
	   for(i=0;i<rowVal;i++){
		 checkId = document.getElementById('checkId'+i);
	     if(checkId.checked == true){
		   generalExam += document.getElementById('familyHistory'+i).value+"\n"
		}
		
	 }
	 window.opener.document.getElementById('familyHistory').value=generalExam;
	 window.opener.document.getElementById('familyHistory').focus();
		 window.close();
  	}
   function CheckAll(chk){
	   var rowLength=document.getElementById('rowLength').value;
	   for (var i=0;i <document.popFamHistory.elements.length;i++)
	   	{
	   		var e = document.popFamHistory.elements[i];

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