<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<html lang="hi" >
<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientVisitSearch.jsp
	 * Tables Used         :
	 * Description         :
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By:
	 * @version 1.0
--%>

<%@page import="java.io.InputStream" %>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="java.text.SimpleDateFormat"%>
<link href="/hms/jsp/css/css/jquery-ui.css" rel="stylesheet" />
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/jquery-ui.js"></script>
<script>jQuery.noConflict();</script>

<%-- <%@ taglib uri="http://www.owasp.org/index.php/Category:OWASP_CSRFGuard_Project/Owasp.CsrfGuard.tld" prefix="csrf" %>
<script type="text/javascript" language="javascript" src="/hms/JavaScriptServlet">
</script> --%>
<script type="text/javascript">
/* var csrfTokenName='<csrf:tokenname />';
var csrfTokenValue='<csrf:tokenvalue />'; */
 var csrfTokenName='${_csrf.parameterName}';
 var csrfTokenValue='${_csrf.token}';
</script>
<script type="text/javascript" src="/hms/jsp/js/csrfToken.js"></script>



<!-- <title>EHA Hospital Management System</title> -->


<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js?n=1"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js?n=1"></script>

	
	
	<script type="text/javascript" language="javascript"  src="/hms/jsp/js/proto.js"></script>


<link href="/hms/jsp/css/jquery.multiselect.css" rel="stylesheet" type="text/css">
<style>
body { font-family:'Open Sans' Arial, Helvetica, sans-serif}
ul,li { margin:0; padding:0; list-style:block;}
.label { color:#000; font-size:16px;}

</style>
<!-- <script type="text/javascript">
window.onblur=function(){self.close();};
</script> -->
<%

		Map<String, Object> map = new HashMap<String, Object>();
List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		int mainChargeCodeId=0;
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(request.getAttribute("mainChargeCodeId") != null){
			mainChargeCodeId = (Integer)request.getAttribute("mainChargeCodeId");
		}
		
		if(map.get("chargeCodeList") != null){
			chargeCodeList =(List<MasChargeCode>)map.get("chargeCodeList");
		}
		List<MasSubChargecode> subchargeCodeList = new ArrayList<MasSubChargecode>();
		if(map.get("subchargeCodeList") != null){
			subchargeCodeList =(List<MasSubChargecode>)map.get("subchargeCodeList");
		}
		
	%>
<div class="Block">

<form name="patientAndAdDetailsdd" action="" method="post" >
<input type="button" name="b" value="ADD" class="button" onClick="addInvestigation();" />
<input type="button" name="b" value="Go Back" class="button"	onClick="window.close();" />
    <%-- <label>Sub Group</label> <select id="subChargeCodeId"
		name="subChargeCode_id" onchange="showPatientHistory(this.value)">
		<option value="0">Select</option>
		<%
			for(MasSubChargecode subChargecode : subchargeCodeList){
			%>
		<option value="<%=subChargecode.getId() %>"><%=subChargecode.getSubChargecodeName().toUpperCase() %></option>
		<%}%>
	</select>  --%>
<div class="titleBg">
<h2>Investigation List</h2>
</div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
if(null !=chargeCodeList && chargeCodeList.size()>0){%>

<select id="langOpt2" name="langOpt2[]" multiple >

	<%for (Iterator iterator = chargeCodeList.iterator(); iterator.hasNext();) {
		DgMasInvestigation dgMasInvestigation = (DgMasInvestigation)iterator.next();%>
		<option value="<%=dgMasInvestigation.getInvestigationName()%>[<%=dgMasInvestigation.getId()%>](<%=dgMasInvestigation.getMainChargecode().getId()%>)"><%=dgMasInvestigation.getInvestigationName()%>[<%=dgMasInvestigation.getId()%>](<%=dgMasInvestigation.getMainChargecode().getId()%>)</option>
	<%}%>
	</select>
<% }
%>

<div class="clear"></div>

</form>
	
</div>

<div class="paddingTop15"></div>




<div class="division"></div>
<div class="clear"></div>
<div class="paddingTop40"></div>


<script src="/hms/jsp/js/jquery.mind.js"></script>
<script src="/hms/jsp/js/jquery.multiselect.js"></script>
<script>

$('#langOpt2').multiselect({
	
    columns:1,
    placeholder: 'Select Investigation',
    search: true
    
});



</script>
<script type="text/javascript">
function showPatientHistory(subChargeId){
   // var mainChargeCodeId = document.getElementById("mainChargeCodeId").value;
   // alert(mainChargeCodeId);
    //var hin=document.getElementById('hinIdd').value;
	 //alert(hin);
	//var hiddenValueCharge=document.getElementById('hiddenValueCharge').value;
	 
	 // alert(hiddenValueCharge);
    var url='/hms/hms/lab?method=showInvestigationBySubChargeId&subChargeId='+subChargeId+'&mainChargeCodeId='+<%=mainChargeCodeId%>;
    newwindow=window.open(url,'patientAndAdDetailsdd',"left=100,top=10,height=630,width=1024,status=1,scrollbars=yes,resizable=0");
}
<%-- function getTableValue(){
	oList=patientAndAdDetailsdd.elements["langOpt2"];
	 var hin=window.opener.document.getElementById('hinIdd').value;
	 //alert(hin);
	 
	var hiddenValueCharge=window.opener.document.getElementById('hiddenValueCharge').value;
	//oList=document.getElementById('langOpt2');
	var sdValues = [];
	   for(var i = 1; i < oList.options.length; i++)
	   {
	      if(oList.options[i].selected == true)
	      {
	      sdValues.push(oList.options[i].value);
	    //  alert(sdValues);
	     
	      }
	   }
	   alert(window.opener.document.getElementById("investigationOrderBooking").value)
	   dsubmitProtoAjaxWithDivName(window.opener.document.getElementById("investigationOrderBooking"),'/hms/hms/lab?method=fillChargeCoded&rowVal=hiddenValueCharge&hin='+hin+'&sdValues='+sdValues+'&mainCharge='+<%=mainChargeCodeId%>+'','rateVall')
window.close();
	  // return sdValues;
	
}
 --%>
 function addInvestigation(){
	var hinId= window.opener.document.getElementById('hinIdd').value;
	var selectPrevInvestigation= window.opener.document.getElementById('selectPrevInvestigation').value;
	 oList=patientAndAdDetailsdd.elements["langOpt2"];
	var invesValue="";
	 var sdValues = [];
	   for(var i = 0; i < oList.options.length; i++)
	   {
	      if(oList.options[i].selected == true)
	      {
	      sdValues.push(oList.options[i].value);
	     
	      
	      }
	   }
	   invesValue=sdValues;
	  // alert(sdValues);
	   var res = selectPrevInvestigation.split(",");
	  // alert(res.length-1);
	   for(var i = 0; i < res.length; i++)
	   {
	      sdValues.push(res[i]);
	      
	   }
	   
	   
	   window.opener.document.getElementById('selectPrevInvestigation').value=invesValue;
	   window.opener.document.getElementById('hiddenValueCharge').value=sdValues.length;
	   jQuery(function ($) { 
			new Ajax.Request('lab?method=fillChargeCoded&sdValues='+sdValues+'&hinId='+hinId+'&'+csrfTokenName+'='+csrfTokenValue, {
		    	  onSuccess: function(response) {
		    		  window.opener.document.getElementById('chargeDetails').innerHTML=response.responseText.trim() ;//$('#chargeDetails tbody').append(response);
		    		  var totalAmount=0.0;
		    		   var finaltotalAmount=0.0;
		    		   for(var i = 1; i < sdValues.length; i++)
		    		   {
		    			 
		    			  
		    			  totalAmount= window.opener.document.getElementById('amount'+i).value;
		    			  finaltotalAmount = parseFloat(finaltotalAmount) + parseFloat(totalAmount);
		    		      
		    		   }
		    		  // alert(finaltotalAmount)
		    		   window.opener.document.getElementById('totalCostId').value =finaltotalAmount;
		    		   window.close();
			    }
		  	  });   
		 });
	  
	// window.opener.document.getElementById('selectedInvestigationId').value= sdValues;
	 //window.opener.getTableValue();
 }
</script>
