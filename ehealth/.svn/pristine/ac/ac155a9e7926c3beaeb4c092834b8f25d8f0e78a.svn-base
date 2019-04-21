<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.BudVoucherReceiptEntry"%>


<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/calender.js" type="text/javascript"></script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<BudVoucherReceiptEntry> budVoucherReceiptEntryList = new ArrayList<BudVoucherReceiptEntry>();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(map.get("budVoucherReceiptEntryList")!=null){
		budVoucherReceiptEntryList =(List) map.get("budVoucherReceiptEntryList");
	}
%>
<script type="text/javascript" language="javascript">
function crvValidationcheck(flag){

var grnNo = document.getElementById('grnNo').value;
 if(grnNo != ""){
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
	   
	  	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	   	   var sli  = item.getElementsByTagName("SLIStatus")[0];
	       if(sli.childNodes[0].nodeValue == 'YES'){
	      
	       if(flag == "GRN Report"){
	       submitForm('grnReport','stores?method=generateCrvReport&flag=crv');
	       }
	        if(flag == "Contingent Bill"){
	        submitForm('grnReport','stores?method=generateCrvReport&flag=contingentBill');
	       }
	        if(flag == "Proforma B"){
	        submitForm('grnReport','stores?method=generateCrvReport&flag=proformaB');
	       }
	        if(flag == "Barcode"){
	        submitForm('grnReport','stores?method=generateCrvReport&flag=barcode');
	       }
	         if(flag == "LPO"){
	         submitForm('grnReport','stores?method=generateCrvReport&flag=LPO');
	       }
	       
	        }else if(sli.childNodes[0].nodeValue == 'NO'){
	        alert("Ledger action is pending for this GRN !!!"); 
	        return false;
	       }
	   } 
      }
    }
   
   var url="/hms/hms/stores?method=findGrnLedgeraction&grnNo="+grnNo;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
     
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
   }
  
  }
  </script>
<form name="grnReport" id=grnReport method="post" action=""
	target="_blank">

<div class="titleBg">
<h2>Voucher Receipt REPORT</h2>
</div>

<div class="clear"></div>
<label>Receipt No.</label> 
<input type="text" name="<%=RECEIPT_NO%>"	value="<%=budVoucherReceiptEntryList.get(budVoucherReceiptEntryList.size()-1).getReceiptNo()%>"	tabindex=1 MAXLENGTH="50" id="<%=GRN_NO%>" />
<div id="ac2update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
new Ajax.Autocompleter('<%=RECEIPT_NO%>','ac2update','stores?method=getGrnNoListForAutoComplete',{parameters:'requiredField=<%=GRN_NO%>'});
		</script> 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="GRN Report" class="button" onClick="crvValidationcheck(this.value);" accesskey="g" tabindex=1 /> 
<%--<input type="button" name="add" id="addbutton" value="Contingent Bill" class="button" onClick="submitForm('grnReport','stores?method=generateCrvReport&flag=contingentBill');" accesskey="c" tabindex=1/>
<input type="button" name="add" id="addbutton" value="Proforma B" class="button" onClick="submitForm('grnReport','stores?method=generateCrvReport&flag=proformaB');" accesskey="p" tabindex=1/>
<input type="button" name="add" id="addbutton" value="LPO" class="button" onClick="submitForm('grnReport','stores?method=generateCrvReport&flag=LPO');" accesskey="b" tabindex=1/> --%>
<input type="button" name="add" id="addbutton" value="Barcode"	class="button"	onClick="submitForm('grnReport','stores?method=generateCrvReport&flag=barcode');"	accesskey="b" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>







