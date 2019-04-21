<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>

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
	List<StorePoHeader> poNumberList = new ArrayList<StorePoHeader>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(map.get("poNumberList")!=null){
		poNumberList =(List<StorePoHeader>) map.get("poNumberList");
	}
%>
<script type="text/javascript" language="javascript">
 function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/purchaseOrder?method=printLocalPoFormatJsp";
  obj.submit();
}
 function showReportWithStock(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/purchaseOrder?method=printLocalPoFormatJsp&withStock=true";
  obj.submit();
}
function crvValidationcheck(flag){

var grnNo = document.getElementById('GRNNO').value;
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
<form name="grnReport" id=grnReport method="post" action=""	target="_blank">
<div class="titleBg">
<h2>PURCHASE ORDER REPORT</h2>
</div>
<div class="clear"></div>
<label>Select PO No</label>
<%
String poNo="";
if(poNumberList.get(0)!=null){
	poNo=poNumberList.get(0).getPoNumber();
}
%>
<input type="text" name="<%=PO_NO%>" value="<%=poNo%>"	tabindex=1 MAXLENGTH="50" id="<%=PO_NO%>" />
<div id="ac2update" class="autocomplete" style="display: none;"></div>
<div id="ac2update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=PO_NO%>','ac2update','purchaseOrder?method=getPoListForPurchaseOrder',{parameters:'requiredField=<%=PO_NO%>'});
		</script>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="print" type="submit" class="button"	value="Print" onClick="showReport('grnReport');">
<input	type="button" name="print" type="submit" class="buttonBig2"	value="Print With Stock Details" onClick="showReportWithStock('grnReport');"> </input>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>