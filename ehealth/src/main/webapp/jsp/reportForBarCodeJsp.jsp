<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
Map<String,Object>map=new HashMap<String,Object>();

if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
}
%>


<script lang="javascript" src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<form name="reportForBarCode" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Bar Code Print</h2> </div>
<div class="clear"></div>
<div class="Block">
<label>UHID</label>
<input type="text" name="uhId" id="uhId" value="" onblur="submitProtoAjaxWithDivName('reportForBarCode','/hms/hms/investigation?method=getVisitDetails','visitId');" />
<div id="visitId"></div>


</div>

</form>
	<script>
function generatePrin(a,b){
	//alert("a------>>"+a);
	//alert("b------>>"+b);
	//alert("e------>>"+e);
	
	submitForm('reportForBarCode','lab?method=generateReportForLabMachineBarcode&&orderId='+a+'&dgSampleDetailId='+b);	
	
}

//added by amit das on 30-06-2016
function generatePrint(orderId,dgSampleDetailId){
	var action = "lab?method=generateReportForLabMachineBarcode&orderId="+orderId+"&dgSampleDetailId="+dgSampleDetailId;
	window.open(action,'name',"left=100,top=100,height=300,width=580,status=1,scrollbars=1,resizable=1");
	
}
</script>
