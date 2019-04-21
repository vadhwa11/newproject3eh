<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script language=javascript src="/hms/jsp/js/proto.js" type=text/javascript></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>
<script language="javascript">
var $j = jQuery.noConflict();
</script>


<form name="faBankReconciliation" method="post" action="">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
	if(map.get("accountList") != null){
		accountList = (List<FaMasAccount>)map.get("accountList");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");
		%>
<h4><span><%=message %></span></h4>
	<%}
%>

<div class="titleBg">
<h2>Bank Reconciliation</h2>
</div>
<div class="Block">
<div class="paddingTop5"></div>
<label>As On Date</label>
<input type="text" name="<%=AS_ON_DATE%>" value="<%= date %>" validate="From Date,string,yes" class="calDate" MAXLENGTH="30" readonly="readonly" />
<label>Bank A/c</label>
<select name="<%=BANK_ACCOUNT  %>" onchange="submitProtoAjax('faBankReconciliation','/hms/hms/account?method=getBankAccountDetailsForReconciliation');" >
<option value="">Select</option>
<%
	for(FaMasAccount masAccount : accountList){
%>
<option value="<%=masAccount.getId() %>"><%=masAccount.getAccDesc() %></option>

<%}
%>
</select>
<div class="clear"></div>
<h4>Balance Details</h4>
<div class="clear"></div>
<div id="testDiv">

<label class="auto" style="padding:0px 12px 0px 5px;">Balance As Per Company Book</label>
<input type="text" id="compBlnc" name="" value=""/>

<label class="value"></label>
<label class="auto">Balance As Per Bank Book</label>
<input type="text" name="" value=""/>
<select name="drCr" class="midium">
<option value="">Select</option>
<option value="dr">Dr</option>
<option value="cr">Cr</option>
</select>
<div class="clear"></div>
<label>Difference</label>
<input type="text" name="difference" id="difference" value=""/>

<div class="clear"></div>
</div>

<input id="addbutton" class="button" type="button" tabindex="1" accesskey="a" onclick="" value="Submit" name="add">
<input id="reset" class="button" type="reset" accesskey="r" onclick="resetCheck();" value="Reset" name="Reset">

</div>
<div class="clear"></div>

<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName%></label>
<label>Changed Date</label>
 <label class="value"><%=date%></label>
  <label>Changed Time</label>
  <label class="value"><%=time%></label>
  <input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
   <input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
   <input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
   </div>
<div class="clear"></div>

<script type="text/javascript">
function calculateDiffrence(){
	var bankBlanc = document.getElementById('bankBlnc').value;
	var companyBalance = document.getElementById('compBlncHidden').value;
	var compBlncType = document.getElementById('blncType').value;
	var bankBlncType = document.getElementById('bankBlncType').value;
	if(bankBlncType != "" && bankBlanc != ""){
		if(compBlncType != bankBlncType){
			document.getElementById('difference').value = parseFloat(companyBalance)-parseFloat(bankBlanc);
		}else{
			document.getElementById('difference').value = parseFloat(companyBalance)+parseFloat(bankBlanc);
		}
	}
}

function calculateBalanceAmt(){
	var diff = document.getElementById('difference').value;
	var count = document.getElementById('counter').value;
	var totalcompBlnc = 0;
	var totalcompBlnc = document.getElementById('compBlnc').value
	for(var i=1;i<count;i++){
		var amt =  document.getElementById('amt'+i).value;
		var val = document.getElementById('chqStatus'+i).value;
		if(val != ""){
			if(val == "notYetCleared"){
				totalcompBlnc = parseFloat(totalcompBlnc) - parseFloat(amt);
				//document.getElementById('compBlnc').value = parseFloat(document.getElementById('compBlncHidden').value)-parseFloat(amt);
			}else if(val == "notYetPresent"){
				totalcompBlnc = parseFloat(totalcompBlnc) + parseFloat(amt);
				//document.getElementById('compBlnc').value = parseFloat(document.getElementById('compBlncHidden').value)+parseFloat(amt);
			}
		}
	}
	if(totalcompBlnc != "")
		document.getElementById('compBlncHidden').value = parseFloat(totalcompBlnc);
	calculateDiffrence();
		<%-- if(voucherType == 'RV'){
			document.getElementById('difference').value = parseFloat(diff)+parseFloat(amt);
		}else if(voucherType == 'PV'){
			document.getElementById('difference').value = parseFloat(diff)-parseFloat(amt);
		}
	}else{
		if(voucherType == 'RV'){
			document.getElementById('difference').value = parseFloat(diff)-parseFloat(amt);
		}else if(voucherType == 'PV'){
			document.getElementById('difference').value = parseFloat(diff)-parseFloat(amt);
		}
	}--%>

}

</script><script>
function popoupforTransaction(rowNum){
	var url="/hms/hms/account?method=showDataForTrnsaction&rowNum="+rowNum;
    popwindowForDelete(url);
 }
function popwindowForDelete(url)
{
	// newwindow=window.open(url,'name',"height=500,width=700,status=1, scrollbars=yes ");
	 newwindow=window.open(url,'name','status=yes,resizable,scrollbars=1,height=400,width=1000,');
}
function setvalueToParent(rowNum){
	//alert("in method");
	window.opener.document.getElementById('transactionDateId'+rowNum).value=window.opener.document.getElementById('transactionDateId'+rowNum).value;
	window.opener.document.getElementById('transactionAmountId'+rowNum).value=window.opener.document.getElementById('transactionAmountId'+rowNum).value;
	window.opener.document.getElementById('narrationId'+rowNum).value=window.opener.document.getElementById('narrationId'+rowNum).value;

	window.opener.document.getElementById('transactionType'+rowNum).value=window.opener.document.getElementById('transactionType'+rowNum).value;

}

</script>
<script>
function calculateBalanceAmt2(row)
{
	//alert(row);
	//alert(document.getElementById('chqStatus'+row).value);
	if(document.getElementById('chqStatus'+row).value=='1' || document.getElementById('chqStatus'+row).value=='3'){
		//alert("in if");
		document.getElementById('chequeNoId'+row).disabled=false;
		document.getElementById('amt'+row).disabled=false;
		document.getElementById('amt'+row).readonly=true;
		document.getElementById('amt'+row).value=document.getElementById('amtId2'+row).value;
//		amtId2
		}else if(document.getElementById('chqStatus'+row).value=='2' || document.getElementById('chqStatus'+row).value=='4'){
		//alert("in if");
		document.getElementById('chequeNoId'+row).disabled=true;
		document.getElementById('chequeNoId'+row).disabled=true;
		document.getElementById('amt'+row).disabled=false;//="inline";
		document.getElementById('amt'+row).value="";
		document.getElementById('chequeDate'+row).value="";
		document.getElementById('vType'+row).value="";
		document.getElementById('vType'+row).value="";
		document.getElementById('chequeNoId'+row).value="0";
		
	}
}
</script>
<script>
function getDetailsForCheckNo(val,row){
	//alert(val+"<=====>"+i);
	//submitProtoAjax('faBankReconciliation','account?method=getValueForchequeNo&chequeNo='+val);
	ajaxFunctionForAutoAA('faBankReconciliation','account?method=getValueForchequeNo&chequeNo='+val , row);
	
	}
function ajaxFunctionForAutoAA(formName,action,rowVal) {
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
	   //   	var brandId="brandId"+rowVal;
		//	obj =document.getElementById(brandId); 
		//	obj.length = 1;
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		        var id  = item.getElementsByTagName("id")[0];
		        var amount  = item.getElementsByTagName("amount")[0];
		        var voucherType=item.getElementsByTagName("voucherType")[0];
		        var checkDate=item.getElementsByTagName("checkDate")[0];
//		        var au  = item.getElementsByTagName("au")[0];
	//	        var name  = item.getElementsByTagName("name")[0];
		        //var manufacturerName=item.getElementsByTagName("manufacturerName")[0];
		       // var manufacturerId=item.getElementsByTagName("manufacturerId")[0];
		//       var costPrice=item.getElementsByTagName("costPrice")[0];
		      
		  //     var expiry=item.getElementsByTagName("expiry")[0];
		       // var brandLength  = item.getElementsByTagName("brands")[0];
		      // var obj= document.getElementById('manuId'+rowVal);
		      // obj.length=1;
		      // obj.options[ obj.length-1].value = manufacturerId.childNodes[0].nodeValue;
		       // obj.options[ obj.length-1].text = manufacturerName.childNodes[0].nodeValue;
	        	document.getElementById('amt'+rowVal).value = amount.childNodes[0].nodeValue
	        	document.getElementById('chequeDate'+rowVal).value = checkDate.childNodes[0].nodeValue
	        	document.getElementById('vType'+rowVal).value = voucherType.childNodes[0].nodeValue
	        	document.getElementById('vhId'+rowVal).value = id.childNodes[0].nodeValue
	        	//document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
	        	//document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue
	        	//document.getElementById('unitRateVarTemp'+rowVal).value = costPrice.childNodes[0].nodeValue
	        	 
	        
	        	/*for(innerLoop = 0;innerLoop < brandLength.childNodes.length;innerLoop++){
	        	//	var brand = brandLength.childNodes[innerLoop];
		        	var brandId  = brand.getElementsByTagName("brandId")[0];
		        	var brandName  = brand.getElementsByTagName("brandName")[0];
		        	obj.length++;
					obj.options[obj.length-1].value=brandId.childNodes[0].nodeValue;
					obj.options[obj.length-1].text=brandName.childNodes[0].nodeValue;
		        	
	        	}*/
	      	} 
	      }
	    }
	   // var url=action+"&"+getNameAndData(formName)
	    var url=action;
		url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	     
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
	    
	  }
</script>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>