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
<form name="popPresentComp" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<OpdTemplateTreatment> templatePresentComplaintList = new ArrayList<OpdTemplateTreatment>();
	List<String> historyEnteredValuesList  = new ArrayList<String>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("templatePresentComplaintList") != null){
		templatePresentComplaintList=(List<OpdTemplateTreatment>)map.get("templatePresentComplaintList");
	}
	
	if(map.get("historyEnteredValues") != null){
		String historyEnteredValues			=	(String)map.get("historyEnteredValues");
		String[] historyEnteredValuesArray 	=	historyEnteredValues.split(",");
		historyEnteredValuesList = 	Arrays.asList(historyEnteredValuesArray);
	}
	
%> 
<h2>Present Complaint & History Templates</h2>

<% if(templatePresentComplaintList.size() == 0){
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
			<th scope="col">Template Values</th>
		</tr>
	</thead>
	<tbody>
		<%
		int i=0;
	for(OpdTemplateTreatment treaTemplateTreatment :templatePresentComplaintList){
 %>
		<%
		String templateName="";
		if(treaTemplateTreatment.getTemplate() !=null ){
			if(treaTemplateTreatment.getPresentComplaintHistory() !=null && !treaTemplateTreatment.getPresentComplaintHistory().equals("") && treaTemplateTreatment.getPresentComplaintHistory().length()>0){
		 			 templateName=treaTemplateTreatment.getPresentComplaintHistory();
	 				
 %>
		<tr>
			<td>    
					<% if(historyEnteredValuesList.contains(templateName)) {%>
						<input id="checkId<%=i %>" name="checkedTemp" type="checkbox" checked="checked" class="radioCheck" value="n"/>
					<% }else {%>
						<input id="checkId<%=i %>" name="checkedTemp" type="checkbox"  class="radioCheck" value="n"/>
					<% } %>
					<input type="hidden" name="rowLength" id="rowLength" value="<%=templatePresentComplaintList.size()%>" readonly="readonly"/>
			</td>
			<td><input type="text" value="<%= templateName%>" name="presentComplain" id="presentComplain<%=i %>" readonly="readonly" size="40"/></td>
		</tr>
		<%i++;
}    %>
		<%
		}
}
		%>

	</tbody>
</table></div>
				<input type="hidden" value="<%=i %>" name="rowVal" id="rowVal"/>			

	
	<input name="" type="button" class="button" value="OK" onclick="setPresentComplaintTempalte();window.close();"" /> 
	<input name="" type="button" class="button"	value="Close" onclick="cancelForm();" />
		<%} %> 	
</form>
<script>
 function cancelForm(){
   	   window.close();
  }
   
   function setPresentComplaintTempalte(){
	   var preComp = "";
	   var  checkId;
	   var rowVal= document.getElementById('rowVal').value;
	 for(i=0;i<rowVal;i++){
		checkId = document.getElementById('checkId'+i);
	   if(checkId.checked == true){
		   preComp += document.getElementById('presentComplain'+i).value+"\n"
		}
		
	 }
	 window.opener.document.getElementById('presentComplain').value=preComp;
	 window.opener.document.getElementById('presentComplain').focus();
	 if(window.opener.document.getElementById('presentComplainTemp')!=null)
		 window.opener.document.getElementById('presentComplainTemp').value=preComp;
	 
		 window.close();
  	}
   function CheckAll(chk){
	   var rowLength=document.getElementById('rowLength').value;
	   for (var i=0;i <document.popPresentComp.elements.length;i++)
	   	{
	   		var e = document.popPresentComp.elements[i];

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