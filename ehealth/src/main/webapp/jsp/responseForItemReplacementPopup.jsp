<!-- -Patient Drug issue By Dipali 18/nov/2010-->

<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="java.util.*"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<!-- Added by Kaushal Mishra -->
<%-- <%@ taglib uri="http://www.owasp.org/index.php/Category:OWASP_CSRFGuard_Project/Owasp.CsrfGuard.tld" prefix="csrf" %> --%>
<script type="text/javascript" language="javascript" src="/hms/JavaScriptServlet"></script>
<script type="text/javascript" src="/hms/jsp/js/csrfToken.js"></script>
<script type="text/javascript">
var csrfTokenName='<csrf:tokenname />';
var csrfTokenValue='<csrf:tokenvalue />';
</script>
<!-- Ended -->
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<link rel="stylesheet" href="/hms/jsp/css/style.css" type="text/css" />
<%
	Map map = new HashMap();
	int itemId=0;
	String qtyRequested="";
	int qtyPending=0;
	int rowVal=0;
	int nextRowVal=0; 
	int issuedItemId=0;
	int issueId=0;
	int detailId=0;
	int visit=0;
	String issueNo ="";
	int totalRow=0;
	BigDecimal rol=new BigDecimal(0);
	BigDecimal clos=new BigDecimal(0); 
	int qtyIssued=0;
	int qtyReturned=0; // added by amit das on 09-06-2016
	List<MasStoreBrand> masStoreBrandList= new ArrayList<MasStoreBrand>();
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	if(map.get("masStoreBrandList")!=null){
		masStoreBrandList = (List) map.get("masStoreBrandList");
	}
	if(map.get("rol")!=null){
		rol=(BigDecimal)map.get("rol");
	}
	if(map.get("clos")!=null){
		clos=(BigDecimal)map.get("clos");
	}
	if(map.get("qtyIssued")!=null){
		qtyIssued=(Integer)map.get("qtyIssued");
	}
	// added by amit das on 09-06-2016
	if(map.get("qtyReturned")!=null){
		qtyReturned=(Integer)map.get("qtyReturned");
	}
	

	int a=0;
	a=clos.compareTo(rol);

	if(map.get("visitId")!=null){
		visit = Integer.parseInt(""+map.get("visitId"));
	}
	if(map.get("itemId")!=null){
		itemId = Integer.parseInt(""+map.get("itemId"));
	}

	if(map.get("rowVal")!=null){
		rowVal = Integer.parseInt(""+map.get("rowVal"));
		nextRowVal=rowVal+1; 
	}
	

	if(map.get("issueNo")!=null){
		issueNo = (String)map.get("issueNo");
	}
	if(map.get("issueId")!=null){
		issueId = (Integer)map.get("issueId");

	}
	if(map.get("issuedItemId")!=null){
		issuedItemId = Integer.parseInt(""+map.get("issuedItemId"));

	}
	Date issueDate=new Date();
	if(map.get("issueDate")!=null){
		issueDate = (Date)map.get("issueDate");
	}
	if(map.get("detailId")!=null){
		detailId = Integer.parseInt(""+map.get("detailId"));

	}
	String flag = "";
	if(map.get("flag") != null){
		flag = (String)map.get("flag") ;
	}
	if(map.get("qtyRequested")!=null){
		qtyRequested = (""+map.get("qtyRequested"));
	}
	if(map.get("qtyPending")!=null){
		qtyPending =Integer.parseInt(map.get("qtyPending").toString());
	}
	String itemName ="";
	if(map.get("itemName")!=null){
		itemName = (String)map.get("itemName");
	}
	if(map.get("totalRow")!=null){
		totalRow = (Integer)map.get("totalRow");
	}
	int issueTId=0;
	if(map.get("issueTId")!=null){
		issueTId=(Integer)map.get("issueTId");
	}
	String date="";
	String userName = "";
	String time= "";
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	date = (String)utilMap.get("currentDate");
	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
 	int inc=1;
 	String messageForRol="Closing Stock is less than ROL!!";
 	if(a==-1){
	%>
<h4><%=messageForRol %></h4>
<%} %>
<script type="text/javascript">

	function cancelForm(){
		
	
		
  	 close();
   	}
</script>
<div class="titleBg">
	<h2>Item Details</h2>
</div>
<%if(masStoreBrandList.size()!=0){%>

<form name="itemIssuePopUp" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<div class="clear"></div>
	<input type="hidden" name="<%=RequestConstants.QTY_IN_REQUEST %>"
		id="reqQty" value="<%=qtyRequested %>" />
		<input type="hidden" name="pendingQty"
		id="pendingQty" value="<%=qtyPending %>" />
		 <input type="hidden"
		name="<%=RequestConstants.ISSUE_NO %>" id="issueNo" value="" /> <input
		type="hidden" name="<%=ISSUE_DATE %>"
		value="<%=HMSUtil.convertDateToStringTypeDate(issueDate)%>"
		id="issueDate" /> <input type="hidden"
		name="<%=RequestConstants.DEPARTMENT_ID %>" value="" /> <input
		type="hidden" name="<%=RequestConstants.DEPARTMENT_ID_TEMP %>"
		id="departmentIdTemp" value="" />
		<div class="clear"></div>
		<label>Qty Issued</label>
		<label class="value"><%=qtyIssued %><input type="hidden" name ="qtyIssue" id = "qtyIssue" value ="<%=qtyIssued %>" ></label>
		<label>Qty Returned</label>
		<label class="value"><%=qtyReturned != 0?qtyReturned:"" %><input type="hidden" name ="qtyReturn" id = "qtyReturn" value ="<%=qtyReturned != 0?qtyReturned:0 %>" ></label>
	<table id="indentDetails" class="grid_header" border="1">
		<thead>
			<tr>
				<th>Batch No</th>
				<th>Unit</th>
				<th>Unit Rate</th>
				<th>Exp Date</th>
				<th>Stock Available</th>
				<th>Qty Replace</th>
				<th>Note</th>
			</tr>
		</thead>
		<tbody>
			<input type="hidden" name="<%=RequestConstants.DETAIL_ID %>"
				value="<%=detailId%>" />
			<input type="hidden" name="<%=RequestConstants.ITEM_ID %>"
				value="<%=itemId%>" />
			<input type="hidden" name="<%=RequestConstants.ISSUED_ITEM %>"
				value="<%=issuedItemId%>" />
			<input type="hidden" name="<%=RequestConstants.ISSUE_ID %>"
				value="<%=issueId%>" />

			<%
  String issuedQty="issuedQty";
  String issuedQty2="issuedQty";
  String issuedQtyTemp="issuedQtyTemp";
  String issuedQtyTemp2="issuedQtyTemp";
  String remarks="remarks";
  String remarks2="remarks";
  String remarksTemp="remarksTemp";
  String remarksTemp2="remarksTemp";
  String stockIn="stockIn";
  String stockIn2="stockIn";

  String costPrice="costPrice";
  String costPrice2="costPrice";
  try{
	  for (Iterator iterator = masStoreBrandList.iterator(); iterator.hasNext();) {
		  issuedQty=issuedQty2+(""+inc);
	 		 issuedQtyTemp=issuedQtyTemp2+(""+inc);
		 	 remarks=remarks2+(""+inc);
			 remarksTemp=remarksTemp2+(""+inc);
			  stockIn=stockIn2+(""+inc);
		  costPrice=costPrice2+(""+inc);
	  StoreItemBatchStock storeItem = (StoreItemBatchStock) iterator.next();

  %>
			<tr><input type="hidden" name="issueTId" id="issueTId" value="<%=issueTId%>"/>
				<td width="10%"><input type="hidden"
					value="<%=storeItem.getId()%>" name="storeItemId<%=inc%>" /> <input
					type="text" readonly="readonly"
					value="<%=storeItem.getBatchNo() %>" /> <input type="hidden"
					name="<%=RequestConstants.BATCH_NO %>"
					value="<%=storeItem.getBatchNo() %>" /> <input type="hidden"
					name="visitId" id="visitId" value="<%=visit %>" /></td>
				<td width="13%"><input type="text"
					name="<%=RequestConstants.AU %>" size="5" readonly="readonly"
					value="<%=storeItem.getItem().getItemConversion().getPurchaseUnit().getUnitName()%>" />
				</td>
				<td width="13%">
				<%BigDecimal mrp=new BigDecimal(1);
				if(storeItem.getMrp()!=null){
					mrp=storeItem.getMrp();
				}%>
				<input type="text"
					name="unitRate<%=inc%>" size="5" readonly="readonly"
					value="<%=mrp%>" />
				</td>
				<%
  	 	SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
	 	SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
	 	String date4MySQL="";
	 	
	 	if(storeItem.getExpiryDate()!=null){
	 		date4MySQL=formatterOut.format(formatterIn.parse(""+storeItem.getExpiryDate()));
	 	}
	 	%>
				<td width="13%"><input type="text" readonly="readonly"
					name="<%=RequestConstants.EXPIRY_DATE %>" value="<%=date4MySQL %>" />
				</td>
				<td width="13%"><input
					value="<%=""+storeItem.getClosingStock().intValue()%>" id="<%=stockIn%>"
					readonly="readonly" /> <input type="hidden"
					value="<%=""+storeItem.getCostPrice()%>" name="costPrice"
					id="costPrice" /></td>

				<td width="13%"><input type="text" tabindex="1"
					name="<%=RequestConstants.QTY_ISSUED_TEMP%>"
					validate='Issued Quantity,float,no' class="medcaption"
					id="<%=issuedQtyTemp %>"
					onblur="validateQty(<%=inc%>);fillQtyIssuedForIssueCiv('<%=inc %>')" /> <input
					type="hidden" name="<%=RequestConstants.QTY_ISSUED%>" value="0"
					id="<%=issuedQty %>" /></td>

				<td width="13%"><input type="text"
					name="<%=RequestConstants.REMARKS_TEMP%>" id="<%=remarksTemp %>"
					validate='Remarks,String,no'
					onchange="fillRemarksForIssueCiv('<%=inc %>')" /> <input
					type="hidden" name="<%=RequestConstants.REMARKS%>" value=""
					id="<%=remarks %>" /></td>
			</tr>
			<% inc++;}
  	 }catch(Exception w){w.printStackTrace();}%>

		</tbody>
	</table>
<input type="hidden" name="totalRowCount" value="<%=inc%>"></input>
	</div>
	<div id="testDiv"></div>
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div> 
	<input type="hidden" id="issueId"></input> 
	<div id="dataForNextPrescription">
	<input type="hidden" id="itemId<%=nextRowVal%>"></input> 
	<input type="hidden" id="qtyIssued<%=nextRowVal%>"></input>
	<input type="hidden" id="presId<%=nextRowVal%>"></input>
	<input type="hidden" id="qtyPending<%=nextRowVal%>"></input>
	<input type="hidden" id="itemName<%=nextRowVal%>"></input>
	<input type="hidden" id="qtyRequest<%=nextRowVal%>"></input>
	<input type="hidden" id="next<%=nextRowVal%>" value="<%=nextRowVal%>"></input> 
	<input type="hidden" id="hiddenValueCharge" value="<%=totalRow%>"></input> 
	<input type="hidden" id="visitId<%=nextRowVal%>"></input>
	</div>   
	<%if(!(nextRowVal>=totalRow)){%> 
	<input type="button" value="Next"
			class="button" onClick="nextWithSave();"/>  
	<%}else{%>
	<div id="saveId" style="display: inline;">
		<input id="save" property="save" type="button" name="Submit13"
			value="Replace" class="button"
			onclick="submitForm('itemIssuePopUp','/hms/hms/stores?method=addPatientDrugIssueReplace');" />
	</div>
	<%}%>
	
	<div id="afterSave" style="display: none;">
		<input id="save" type="button" name="Submit13" value="Save"
			class="button" />
	</div>
	<input type="button" name="cancel" id="addbutton" value="Close"
		class="button" onClick="cancelForm();" accesskey="a" tabindex=1 /> <input
		type="hidden" id="totalQty" />
	<%}else{ %>
	<h4>Records not Found</h4>
	<div class="clear"></div>
	<%} %>


	<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
		type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
		type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<script type="text/javascript"> 
	document.getElementById('issueNo').value = window.opener.document.getElementById('issueNo').value;
	document.getElementById('issueDate').value = window.opener.document.getElementById('issueDate').value;  
	
	document.getElementById('itemId<%=nextRowVal%>').value=window.opener.document.getElementById('itemId<%=nextRowVal%>').value; 
	document.getElementById('qtyIssued<%=nextRowVal%>').value=window.opener.document.getElementById('qtyIssued<%=nextRowVal%>').value;
	document.getElementById('presId<%=nextRowVal%>').value=window.opener.document.getElementById('presId<%=nextRowVal%>').value;
	document.getElementById('qtyPending<%=nextRowVal%>').value=window.opener.document.getElementById('qtyPending<%=nextRowVal%>').value;
	document.getElementById('itemName<%=nextRowVal%>').value=window.opener.document.getElementById('itemName<%=nextRowVal%>').value;
	
	document.getElementById('qtyRequest<%=nextRowVal%>').value=window.opener.document.getElementById('qtyRequest<%=nextRowVal%>').value; 
	document.getElementById('visitId<%=nextRowVal%>').value=window.opener.document.getElementById('visitId<%=nextRowVal%>').value; 
	//document.getElementById('departmentIdTemp').value = window.opener.document.getElementById('departmentIdTemp').value;
	//document.getElementById('requestBy').value = window.opener.document.getElementById('requestBy').value;
	//document.getElementById('requestDate').value = window.opener.document.getElementById('requestDate').value;
	//document.getElementById('approvedBy').value = window.opener.document.getElementById('approvedBy').value;
	//document.getElementById('issuedBy').value = window.opener.document.getElementById('issuedBy').value;
	//document.getElementById('requestNo').value = window.opener.document.getElementById('requestNo').value;


function submitProtoAjaxForIssueBatchToDept(formName,action,issueObj){
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
    var issueId = 0;
  //		var issueObj = window.opener.document.getElementById('issueId');
      if(xmlHttp.readyState==4){

      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	if(items.childNodes.length!=0){

      	for (loop = 0; loop < items.childNodes.length; loop++) {

	   	 var item = items.childNodes[loop];

	   	 var issueId = item.getElementsByTagName("issueId")[0];
	   	 issueObj.value = issueId.childNodes[0].nodeValue;
	   	  }
	   	  }

      }
    }
    var url=action+"&"+getNameAndData('strs_Item_Issu_Drug');
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  }


function disableSaveButton(){
	ob1 = true;
	if(document.getElementById('save')){
		document.getElementById('saveId').style.display = 'none';
		document.getElementById('afterSave').style.display = 'inline';
		window.close();
	}

}

function validateQty(id)
{
		
var issuedQty = document.getElementById('qtyIssue').value;
var pastReturnedQty = document.getElementById('qtyReturn').value; // added by amit das on 09-06-2016

var intvalue = Math.round(issuedQty);
var intvalueForPastReturnedQty = Math.round(pastReturnedQty);

var returnedQty =document.getElementById('issuedQtyTemp'+id).value;
//alert("issuedQty "+issuedQty+" returnedQty "+returnedQty+" (returnedQty<=issuedQty) "+(intvalue >= returnedQty));
//if(returnedQty>(intvalue-intvalueForPastReturnedQty))//changed by govind 5-10-2016
if(intvalue >= returnedQty)
	{
	//alert("Replaced Drug can not be Greater than Remaining Issued Quantity.");//changed by govind 5-10-2016
	return true; 
}
else
{
alert("Replaced Drug can not be Greater than Issued Quantity.");
document.getElementById('issuedQtyTemp'+id).value = "";
 return false;
}
}

function nextWithSave(){ 
	 if(setTotalQty(<%=inc%>,<%=rowVal%>)){
		 new Ajax.Request('/hms/hms/stores?method=addPatientDrugIssue'+'&'+csrfTokenName+'='+csrfTokenValue+'&'+getNameAndData('itemIssuePopUp'), {
	    	  onSuccess: function(response) { 
	    	      if(response.responseText.trim()!='')
	    	    	  {    
	    	    	  openPopupForItemIssueForPatientNext('itemIssuePopUp',document.getElementById('qtyRequest<%=nextRowVal%>').value,<%=nextRowVal%>,'','');
	    	    	  }
	    	  }
	    	}); 
		} 
}
	</script>
</form>