<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreDefectiveDrugM"%>
<%@page import="jkt.hms.masters.business.StoreCopyAddressList"%>
<%@page import="jkt.hms.masters.business.StoreGrnT"%>

<%@page import="jkt.hms.masters.business.StoreInternalReturnT"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>
<% 
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	int entryId=0;	
	if(map.get("entryId")!=null){
		entryId=Integer.parseInt(""+map.get("entryId"));
	}	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	

	List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
			if(map.get("itemList") != null){
				itemList = (ArrayList) map.get("itemList");
				session.setAttribute("itemList",itemList);
			}else if(session.getAttribute("itemList") != null){
				itemList = (ArrayList)session.getAttribute("itemList");
				
			}
		
			StoreDefectiveDrugM storeDefectiveObj = null;
			List<StoreIndentM> drugList = new ArrayList<StoreIndentM>();
			if(map.get("drugList") != null){
				drugList = (ArrayList) map.get("drugList");
				session.setAttribute("drugList",drugList);
			}else if(session.getAttribute("drugList") != null){
				drugList = (ArrayList)session.getAttribute("drugList");
				
			}
			
			
			
			List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
			if(map.get("brandList") != null){
				brandList = (ArrayList) map.get("brandList");
				session.setAttribute("brandList",brandList);
			}else if(session.getAttribute("brandList") != null){
				brandList = (ArrayList)session.getAttribute("brandList");
				
			}
			
			
			List<StoreDefectiveDrugM> searchDrugList= new ArrayList<StoreDefectiveDrugM>();
			if(map.get("searchDrugList")!=null)
				searchDrugList = (List) map.get("searchDrugList");
		
			
			List<StoreCopyAddressList> copyList = new ArrayList<StoreCopyAddressList>();
			if(map.get("copyList")!=null)
				copyList = (List) map.get("copyList");
			
			List<StoreGrnT> grnList = new ArrayList<StoreGrnT>();
			if(map.get("grnList")!=null)
				grnList = (List) map.get("grnList");
			
			String message="";
			if(map.get("message") != null){
				message = (String)map.get("message"); 
			}
		
			String userName = "";
			if (session.getAttribute("userName") != null) {
				userName = (String) session.getAttribute("userName");
			}
			List<StoreInternalReturnT>storeInternalReturnTList = new ArrayList<StoreInternalReturnT>();
			if(map.get("storeInternalReturnTList") != null){
				storeInternalReturnTList = (List)map.get("storeInternalReturnTList");
			}
			System.out.println("storeInternalReturnTList==="+storeInternalReturnTList.size());
			List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
			if(map.get("manufacturerList")!=null)
				manufacturerList = (List) map.get("manufacturerList");
			
			
			int deptId = 0;
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
			}
			
			String time="";
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			 date = (String)utilMap.get("currentDate");	 
			 time = (String)utilMap.get("currentTime");
			int pageNo=1;
			if (map.get("pageNo") != null) {
				pageNo = Integer.parseInt(""+map.get("pageNo"));
			}
			String includedJsp = null;
			if (request.getAttribute("map") != null) {
				map = (Map) request.getAttribute("map");
				

			}
			includedJsp = (String) map.get("includedJsp");
			
			String max="";
			if(map.get("max") != null){
				max = (String) map.get("max");
			}
			
			Set<StoreItemBatchStock> set1 = new HashSet<StoreItemBatchStock>();
			if (request.getAttribute("set1") != null) {
				set1 = (Set) request.getAttribute("set1");
				

			}
			%>
<script>
 var nameArray=new Array();
 var itemsArray1=new Array();
 var itemsArray2 = new Array();
 var manufacturerArray = new Array();
  var brandArray = new Array();
  
 function fillValuesInDefectiveDrug(inc)
  {

  	 	var quanRec = "quanRec";
  	 	authyDec = "authyDec";
  	 	var disposal ="disposal";
  	 	var remarks = "remarks";
    
    	var quanRecTemp = "quanRecTemp";
    	var authyDecTemp = "authyDecTemp";
  	 	var disposalTemp ="disposalTemp";
  	 	remarksTemp = "remarksTemp";
    	
    	
    	
    	document.getElementById(quanRec+inc).value=document.getElementById(quanRecTemp+inc).value
    	//document.getElementById(authyDec+inc).value=document.getElementById(authyDecTemp+inc).value
    	if(document.getElementById(disposal+inc).value  != "" ){
    	document.getElementById(disposal+inc).value=document.getElementById(disposalTemp+inc).value
    	}else{
    	document.getElementById(disposal+inc).value=0;
    	}
    	if(document.getElementById(remarks+inc).value  != "" ){
    	document.getElementById(remarks+inc).value=document.getElementById(remarksTemp+inc).value
    	}else{
    	document.getElementById(remarks+inc).value=0;
    	}
  }
  
  function fillSrNo(rowVal){


	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%10
   		if(rowVal==0){
   			rowVal=10
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
	return true;
}
 function getManufacturerNameByAjax(brandId,rowVal){
 
 
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
	        var manufacturerName  = item.getElementsByTagName("manufacturerName")[0];
	        var mId  = item.getElementsByTagName("mId")[0];
        	document.getElementById('manufacturerId'+rowVal).value = manufacturerName.childNodes[0].nodeValue
        	document.getElementById('manufacturerIdTemp'+rowVal).value = mId.childNodes[0].nodeValue
        	
      	} 
      }
    }
     url="stores?method=getManufacturerNameInAjax&brandId="+brandId;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    
 }
 
 
  function getExpiryDateByAjax(batchId,rowVal){
 

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
	   	   
	        var expiryDate  = item.getElementsByTagName("expiryDate")[0];
	        var manufactureDate  = item.getElementsByTagName("manufactureDate")[0];
	        var manufacturerId  = item.getElementsByTagName("manufacturerId")[0];
	        var manufacturerName  = item.getElementsByTagName("manufacturerName")[0];
	       	var mId  = item.getElementsByTagName("mId")[0];
	          if(manufactureDate.childNodes[0] != undefined){
	        	document.getElementById('manufacturerDate'+rowVal).value = manufactureDate.childNodes[0].nodeValue
	          }
	          if(manufacturerName.childNodes[0] != undefined){
        		document.getElementById('manufactureName'+rowVal).value = manufacturerName.childNodes[0].nodeValue
	          }
	          if(manufacturerId.childNodes[0] != undefined){
        		document.getElementById('manufactureId'+rowVal).value = manufacturerId.childNodes[0].nodeValue
	          }
	          if(expiryDate.childNodes[0] != undefined){
        		document.getElementById('expiryDate'+rowVal).value = expiryDate.childNodes[0].nodeValue
	          }
	          if(expiryDate.childNodes[0] != undefined){
        		document.getElementById('expiryDateTemp'+rowVal).value = expiryDate.childNodes[0].nodeValue
	          }
        	
      	} 
      }
    }
     url="stores?method=getExpiryDateInAjax&batchId="+batchId;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    
 }
 
 
  function checkForSubmit(){
  
  
  
  if(document.getElementById('noOfRows').value==0)
  {alert("There must be one detail row");
  return false;
  }else{
  return true;
  }
 
  }
</script>

<script language="javascript">

function checkForDefectiveDrugs(val,a,inc)
{
		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*10)+1;
    	var end=((pageNo-1)*10)+10;
    	
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	   
	    
	   
		ajaxFunctionForAutoCompleteInDefectiveDrugs('grnGrid','stores?method=fillItemsForDefectiveDrugs&pvmsNo=' + pvms , inc);
		
}  
 </script>
<div class="titleBg">
<h2>Defective Drugs</h2>
</div>
<div class="clear"></div>
<%--
<form name="createGrn" method="post" action="">
<div class="search" id="threadsearch"><a href=""></a> 
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>
<div class="clear"></div>
<!--    
<input type="button" id="addbutton" name="Add" type="submit"  value="Add" class="button" onClick="submitForm('createGrn','stores?method=showDefectiveDrugJsp');">
<input type="button" name="Modify" type="submit" value="Modify" class="button"  onClick="submitForm('createGrn','stores?method=modifyDefectiveDrug');">
--> 
<!-- thread search menu -->
 
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<form name="searchPanel" method="post">
<div class="clear"></div>
<input type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" />
<input type="hidden" name="do" value="process" /> <input type="hidden"	name="searchthread" value="1" /> 
<input type="hidden" name="showposts"	value="1" /> 
<input type="hidden" name="searchthreadid" value="85875" />
<label class="bodytextB_blue">From Date </label> 
<input type="text"	name="<%= FROM_DATE %>" MAXLENGTH="30" tabindex=1 /> 
<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" 	validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate%>',document.createGrn.<%= FROM_DATE%>,event)" />
<div class="clear"></div>
<label class="bodytextB_blue">To Date </label> 
<input type="text"	name="<%= TO_DATE %>" MAXLENGTH="30" tabindex=1 /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.createGrn.<%= TO_DATE%>,event)" />
<div class="clear"></div>
<label>Defective Drug No</label> 
<select name="<%=ENTRY_NO%>">
	<%
					for (StoreDefectiveDrugM storeDefectiveDrugM :searchDrugList ) {
				%>
	<option value=<%=storeDefectiveDrugM.getEntryNo()%>><%=storeDefectiveDrugM.getEntryNo()%></option>
	<%
	}
				%>
</select> 
<input name="button" src="/hms/jsp/images/go.gif" type="image"	class="button"	onClick="submitForm('createGrn','stores?method=searchDefectiveDrug');" />
<div class="clear"></div>
</form>
</div>--%>
<form name="grnGrid" method="post">
<div class="Block">
<h4>Details</h4>
<input type="hidden" name="pageNo"	value="<%=pageNo%>" id="pageNo" validate="pageNo,int,no"/> 
<input type="hidden" name="deptId"	value="<%=deptId%>" validate="deptId,int,no"/> 
<div style="display: none">
<label>Defect No</label> 
<% if(storeDefectiveObj != null){%>
<input type="text" name="<%= ENTRY_NO %>"	value="<%=storeDefectiveObj.getEntryNo()%>" class="readOnly"	readonly="readonly" tabindex=1	maxlength="12" /> <%}else{ %> 
<input type="text" name="<%= ENTRY_NO %>"	value="<%=max %>" class="readOnly" readonly="readonly"  tabindex=1 maxlength="12" /> 
<%} %></div>
<label> Entry Date</label> 
<input type="text" class="date"	name="<%=ENTRY_DATE%>" value="<%=currentDate %>" MAXLENGTH="30" validate="entryDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.grnGrid.<%=ENTRY_DATE%>,event)" />
<label>From Department</label>
<input type="text" name="<%=FROM_STORE %>"	value="Central Store" id="<%=FROM_STORE %>" readonly="readonly"	class="readOnly" MAXLENGTH="18"  />
<div class="clear"></div>
<%-- 
<label>To Place</label> 
<%if(storeDefectiveObj != null){ %>
<textarea value="<%=storeDefectiveObj.getToPlace()%>" readOnly	
name="<%=TO_PLACE %>" tabindex=1 onpaste="return checkOnPaste(this)"
oninput="return checkMaxLengthMoz(this)"
onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
maxlength="45" /> 
</textarea> 
<%} else{%> 
<textarea value="" name="<%=TO_PLACE %>" validate="to Place  ,String,yes" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="45" /> </textarea> <%
				}
	  	  	  %>
--%>

<div class="clear"></div></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<input type="button" name="Add" type="submit" class="buttonAdd" value="" onClick="addRow();" />
  <input type="button" name="Delete" type="submit" class="buttonDel" value="" onClick="removeRow();" />
<input type="hidden" Page No: <%=pageNo%> validate="pageNo,int,no"/> 
<input type="hidden"	size="2" value="0" name="<%=NO_OF_ROWS %>" id="<%=NO_OF_ROWS %>" validate="NoOfRows,int,no"/> 

<div class="clear"></div>
<h4>Defective Drugs Entry</h4>
<div class="clear"></div>
<div class="clear"></div>
<div class="cmntable">
<table width="98%"  id="defectiveDetails" >
	
			<tr>
				<th>S.No.</th>
				<th>Item Code.</th>
				<th>Item Name.</th>
				<th>Unit.</th>
				<th>Batch No.</th>
				<th>Manufacturer</th>
				<th>DOM</th>
				<th>DOE</th>
				<th>Qty</th>
				<th>Remarks</th>
			</tr>
		
			<%
			int detailCounter=30; 
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idSection="idSection";
    	String nameBrand="nameBrand";
    	String idBrand="idBrand";
    	String idManufacturer="idManufacturer";
    	String idAu="idAu";
    	String batchNo="batchNo";
    	String batchNoTemp="batchNoTemp";
    	String quanRec="quanRec";
    	String quanRecTemp="quanRecTemp";
    	String unitRateVar="unitRateVar";
    	String discountVar="discountVar";
    	String amtVar="amtVar";
    	String taxVarTemp="taxVarTemp";
    	String unitRateVarTemp="unitRateVarTemp";
    	String discountVarTemp="discountVarTemp";
    	String amtVarTemp="amtVarTemp";
    	String stockInVarTemp="stockInVarTemp";
    	String mmfVarTemp="mmfVarTemp";
    	String demandVarTemp="demandVarTemp";
    	String incVar="incVar";
    	String quantityInVar="quantityInVar";
      	String quantityInVarTemp="quantityInVarTemp";
      	String freeQty="freeQty";
    	String freeItem="freeItem";
    	String manufacturingDate="manufacturingDate";
    	String expiryDate="expiryDate";
    	String manufacturerId="manufacturerId";
    	String lotNo="lotNo";
    	String shelfLife="shelfLife";
    	String expiry ="expiry";
    	String nameManufacturer="nameManufacturer";
    	String remarks ="remarks";
    	String disposal ="disposal";
    	String remarksTemp="remarksTemp";
    	String authyDecTemp="authyDecTemp";
    	String authyDec="authyDec";
    	String disposalTemp ="disposalTemp";
    	String expiryDateTemp="expiryDateTemp";
    	String brandId="brandId";
    	String batchId="batchId";
    	String manufacturerIdTemp="manufacturerIdTemp";
    	int inc = 0;
   		String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String idSection2="idSection";
    	String nameBrand2="nameBrand";
    	String idBrand2="idBrand";
    	String idAu2="idAu";
    	String freeItem2="freeItem";
    	String manufacturingDate2="manufacturingDate";
    	String expiryDate2="expiryDate";
    	String batchNo2="batchNo";
    	String batchNoTemp2="batchNoTemp";
    	String lotNoTemp2="lotNoTemp";
    	String quanRec2="quanRec";
    	String quanRecTemp2="quanRecTemp";
    	String taxVar2="taxVar";
    	String unitRateVar2="unitRateVar";
    	String discountVar2="discountVar";
    	String amtVar2="amtVar";
    	String quantityInVar2="quantityInVar";
    	String freeQty2="freeQty";
    	String taxVarTemp2="taxVarTemp";
    	String unitRateVarTemp2="unitRateVarTemp";
    	String discountVarTemp2="discountVarTemp";
    	String amtVarTemp2="amtVarTemp";
    	String quantityInVarTemp2="quantityInVarTemp";
    	String stockInVarTemp2="stockInVarTemp";
    	String mmfVarTemp2="mmfVarTemp";
    	String demandVarTemp2="demandVarTemp";
    	String incVar2="incVar2";
    	String manufacturerId2="manufacturerId";
    	String lotNo2="lotNo";
    	String shelfLife2 ="shelfLife";
    	String expiry2="expiry";
    	String remarks2 ="remarks";
    	String disposal2="disposal";
    	String remarksTemp2="remarksTemp";
    	String authyDecTemp2="authyDecTemp";
    	String authyDec2="authyDec";
    	String disposalTemp2="disposalTemp";
    	String idManufacturer2="idManufacturer";
    	String expiryDateTemp2="expiryDateTemp";
    	String brandId2="brandId";
    	String batchId2="batchId";
    	String manufacturerIdTemp2="manufacturerIdTemp";
    	
    	String nameManufacturer2="nameManufacturer";
    	/*
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
     	 for(int inc=1;inc<=30;inc++){
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		idSection=idSection2+(""+inc);
     		nameBrand=nameBrand2+(""+inc);
     		idBrand=idBrand2+(""+inc);
     		idAu=idAu2+(""+inc);
     		unitRateVar=unitRateVar2+(""+inc);
     		discountVar=discountVar2+(""+inc);
     		amtVar=amtVar2+(""+inc);
     		batchNo=batchNo2+(""+inc);
     		batchNoTemp=batchNoTemp2+(""+inc);
     		lotNo=lotNo2+(""+inc);
     		quanRec=quanRec2+(""+inc);
     		quanRecTemp=quanRecTemp2+(""+inc);
     		authyDecTemp=authyDecTemp2+(""+inc);
     		taxVarTemp=taxVarTemp2+(""+inc);
     		unitRateVarTemp=unitRateVarTemp2+(""+inc);
     		discountVarTemp=discountVarTemp2+(""+inc);
     		amtVarTemp=amtVarTemp2+(""+inc);
     		stockInVarTemp=stockInVarTemp2+(""+inc);
     		mmfVarTemp=mmfVarTemp2+(""+inc);
     		demandVarTemp=demandVarTemp2+(""+inc);
     		idManufacturer=idManufacturer2+(""+inc);
     		batchId = batchId2+(""+inc);
     		
     		incVar=incVar2+(""+inc);
     		freeQty=freeQty2+(""+inc);     		
     		freeItem=freeItem2+(""+inc);
     		manufacturingDate=manufacturingDate2+(""+inc);
     		expiryDate=expiryDate2+(""+inc);
     		manufacturerId=manufacturerId2+(""+inc);
     		shelfLife = shelfLife2+(""+inc);
     		expiry = expiry2+(""+inc);
     		remarks = remarks2+(""+inc);
     		remarksTemp =remarksTemp2+(""+inc);
     		nameManufacturer=nameManufacturer2+(""+inc);
     		disposal = disposal2+(""+inc);
     		disposalTemp = disposalTemp2+(""+inc);
     		authyDec = authyDec2+(""+inc);
     		expiryDateTemp =expiryDateTemp2+(""+inc);
     		brandId = brandId2+(""+inc);
     		batchId=batchId2+(""+inc);
     		manufacturerIdTemp = manufacturerIdTemp2+(""+inc);*/
     		if(storeInternalReturnTList.size()>0){
     			for(StoreInternalReturnT storeInternalReturnT : storeInternalReturnTList){
     				inc++;
    	  %>
			<tr>

		<td><input type="text" size="2" value="<%=inc%>" name="<%=SR_NO%>" class="readOnly" readonly="readonly" /></td>
		
		<td><input type="text" name="<%=ITEM_CODE %>" size="5" value="<%=storeInternalReturnT.getItem()!= null?storeInternalReturnT.getItem().getPvmsNo():"" %>" class="readOnly" readonly="readonly" id="<%=codeItem+inc%>" />
		 <input type="hidden" size="2" value="<%=storeInternalReturnT.getItem()!= null?storeInternalReturnT.getItem().getId():"" %>" class="smcaption" name="<%=ITEM_ID%>" id="<%=idItem+inc%>" />
		 <input type="hidden" size="2" value="<%=storeInternalReturnT.getId()!= null?storeInternalReturnT.getId():"" %>" class="smcaption" name="storeInternalReturnTId" id="storeInternalReturnTId<%=inc%>" /></td>
		 
		 <td><input type="text" value="<%=storeInternalReturnT.getItem()!= null?storeInternalReturnT.getItem().getNomenclature():""  %>" size="30" id="<%=nameItem+inc%>" onblur="if(fillSrNo('<%=inc %>')){checkForDefectiveDrugs(this.value, '<%=nameItem%>','<%=inc %>');}" name="<%=nameItem%>" />
		<div id="ac2update" class="autocomplete" style="display: none;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
  		new Ajax.Autocompleter('<%=nameItem+inc%>','ac2update','stores?method=getItemListForDefectiveDrugsByAutocomplete',{parameters:'requiredField=<%=nameItem%>'});</script></td>
		
		 <td><input type="text" value="<%=storeInternalReturnT.getItem()!= null && storeInternalReturnT.getItem().getItemConversion()!= null ?storeInternalReturnT.getItem().getItemConversion().getItemUnitName():""  %>" size="8" class="readOnly" readonly="readonly" name="<%=AV%>" id="<%=idAu+inc%>" tabindex="1" /></td>
		<td><select name="<%=BATCH_ID%>" id="<%=batchId+inc%>" onchange="getExpiryDateByAjax(this.value,<%=inc%>);" tabindex="1">
					<option value="<%=storeInternalReturnT.getStock().getId() %>"><%=storeInternalReturnT.getStock().getBatchNo() %></option></select></td>
		<%--<td><select name="<%=MANUFACTURER_ID%>" id="<%=manufacturerId%>" tabindex="1">
					<option value="0">Select</option>
				</select></td> --%>
				<td><input type="text" size="10" tabindex=1 value="<%=storeInternalReturnT.getStock() != null && storeInternalReturnT.getStock().getManufacturer() != null?storeInternalReturnT.getStock().getManufacturer().getManufacturerName():"" %>" name="manufactureName" id="manufactureName<%=inc%>" readonly />
			<input type="hidden" tabindex=1 value="<%=storeInternalReturnT.getStock() != null && storeInternalReturnT.getStock().getManufacturer() != null?storeInternalReturnT.getStock().getManufacturer().getId():"" %>" name="<%=MANUFACTURER_ID%>" id="manufactureId<%=inc%>"  readonly /></td>
			
		<td><input type="text" size="8" value="<%=storeInternalReturnT.getStock()!= null && storeInternalReturnT.getStock().getManufactureDate()!= null ? HMSUtil.convertDateToStringWithoutTime(storeInternalReturnT.getStock().getManufactureDate()):""  %>" name="<%=MANUFACTURING_DATE%>" id="manufacturerDate<%=inc%>" />
	</td>
	 
	<td><input type="hidden" value="<%=storeInternalReturnT.getExpiryDate()!= null ? storeInternalReturnT.getExpiryDate():""  %>" name="<%=EXPIRY_DATE%>" id="<%=expiry+inc%>" />
	<input id="<%=expiryDate+inc %>" size="8"  value="<%=storeInternalReturnT.getExpiryDate()!= null ? storeInternalReturnT.getExpiryDate():""  %>" onblur="fillExpForDefectiveDrug(<%=inc%>)" name="<%=EXPIRY_DATE%>" />
	 <input type="hidden" value="<%=storeInternalReturnT.getExpiryDate()!= null ? storeInternalReturnT.getExpiryDate():""  %>" id="<%=expiryDateTemp+inc %>" name="<%=EXPIRY_DATE%>" tabindex="1" /></td>

	<td width="10%"><input type="text" value="<%=storeInternalReturnT.getReturnQty()!= null ? storeInternalReturnT.getReturnQty().intValue():""  %>" size="8" name="<%=QUANTITY_RECEIVED%>" id="<%=quanRecTemp+inc%>" onblur="fillQuanForDefectiveDrug(<%=inc%>)" tabindex="1" />
	<input type="hidden" value="<%=storeInternalReturnT.getReturnQty()!= null ? storeInternalReturnT.getReturnQty().intValue():""  %>" name="<%=QUANTITY_RECEIVED%>" id="<%=quanRec+inc%>" tabindex="1" /></td>

	<td width="10%"><input type="text" value="" size="20" name="remarks" id="<%=remarksTemp%>" tabindex="1" maxlength="15" onblur="fillValuesInDefectiveDrug(<%=inc%>);" /> </td>



			</tr>
			<%
     				
			} 
     			}else{
     			inc++;
     			%>
     			
     				<tr>

		<td><input type="text" size="2" value="<%=inc%>" name="<%=SR_NO%>" class="readOnly" readonly="readonly"  /></td>
		
		<td><input type="text" name="<%=ITEM_CODE %>" size="5" value="" class="readOnly" readonly="readonly" id="<%=codeItem+inc%>"  />
		 <input type="hidden" size="2" value="" class="smcaption" name="<%=ITEM_ID%>" id="<%=idItem+inc%>" validate="itemId,int,no"/>
		 <input type="hidden" size="2" value="" class="smcaption" name="storeInternalTId" id="storeInternalTId<%=inc%>" validate="storeInternalTId,int,no"/></td>
		 
		 <td><input type="text" value="" size="30" id="<%=nameItem+inc%>" onblur="if(fillSrNo('<%=inc %>')){checkForDefectiveDrugs(this.value, '<%=nameItem%>','<%=inc %>');}" name="<%=nameItem%>"  />
		<div id="ac2update" class="autocomplete" style="display: none;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
  		new Ajax.Autocompleter('<%=nameItem+inc%>','ac2update','stores?method=getItemListForDefectiveDrugsByAutocomplete',{parameters:'requiredField=<%=nameItem%>'});</script></td>
		
		 <td><input type="text" value="" size="8" class="readOnly" readonly="readonly" name="<%=AV%>" id="<%=idAu+inc%>" tabindex="1" /></td>
		<td><select name="<%=BATCH_ID%>" id="<%=batchId+inc%>" onchange="getExpiryDateByAjax(this.value,<%=inc%>);" tabindex="1">
					<option value=""></option></select></td>
		<%--<td><select name="<%=MANUFACTURER_ID%>" id="<%=manufacturerId%>" tabindex="1">
					<option value="0">Select</option>
				</select></td> --%>
				<td><input type="text" size="10" tabindex=1 value="" name="manufactureName" id="manufactureName<%=inc%>" readonly  />
			<input type="hidden" tabindex=1 value="" name="<%=MANUFACTURER_ID%>" id="manufactureId<%=inc%>"  readonly validate="manufacturerId,int,no"/></td>
			
		<td><input type="text" size="8" value="" name="<%=MANUFACTURING_DATE%>" id="manufacturerDate<%=inc%>" validate="manufacturingDate,date,no"/>
	</td>
	 <td>
<%-- 	<input type="hidden" value="" name="<%=EXPIRY_DATE%>" id="<%=expiry+inc%>" /> --%>
	<input id="<%=expiryDate+inc %>"  value="" onblur="fillExpForDefectiveDrug(<%=inc%>)" name="<%=EXPIRY_DATE%>"  size="8" validate="expiryDate,date,no"/>
	<%--  <input type="hidden" value="" id="<%=expiryDateTemp+inc %>" name="<%=EXPIRY_DATE%>" tabindex="1" /></td>
 --%>
	<td><input type="text" value="" size="8" name="<%=QUANTITY_RECEIVED%>" id="<%=quanRecTemp+inc%>" onblur="fillQuanForDefectiveDrug(<%=inc%>)" tabindex="1" />
	<input type="hidden" value="" name="<%=QUANTITY_RECEIVED%>" id="<%=quanRec+inc%>" tabindex="1" /></td>

	<td><input type="text" value="" size="20" name="remarks" id="<%=remarksTemp%>" tabindex="1" maxlength="15" validate="Remarks,remarks,no"/> </td>

			</tr>
     			
     			<%} %>

</table>
</div>
<input	type="hidden" name="count" value="<%=inc%>" id="hdb" validate="count,int,no"/>
<script type="text/javascript">
function addRow(){
	  var tbl = document.getElementById('defectiveDetails');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cellRight1 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name='<%=SR_NO%>'+iteration;
	  e0.value = iteration;
	  e0.id='srNoId'+iteration;
	  e0.size='3'
	  e0.className = 'readonly'
	 cellRight1.appendChild(e0);

	 var cellRight2 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='<%=ITEM_CODE %>';
	  e1.id='<%=codeItem%>'+iteration;
	  e1.class = 'readonly'
	  e1.size='5'
	 cellRight2.appendChild(e1);
		 
	  var e11 = document.createElement('input');
	  e11.type = 'hidden';
	  e11.size='8';
	  e11.name='<%=ITEM_ID%>';
	  e11.id='idItem'+iteration
	  cellRight2.appendChild(e11);

	  var cellRight3 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.onblur=function(){checkForDefectiveDrugs(this.value, '<%=nameItem%>',iteration);
	                      };
	  e2.name = '<%=nameItem%>';
	  e2.id = '<%=nameItem%>' + iteration;
	  e2.size = '30';
	  var newdiv = document.createElement('div');
	  newdiv.setAttribute('id', 'ac2updates'+iteration);
	  newdiv.style.display = 'none';
	  newdiv.className = "autocomplete";
	  cellRight3.appendChild(newdiv);
	  cellRight3.appendChild(e2);
		new Ajax.Autocompleter('<%=nameItem%>'+iteration,'ac2update','stores?method=getItemListForDefectiveDrugsByAutocomplete',{minChars:1,parameters:'requiredField=<%=nameItem%>'});

	 // new Ajax.Autocompleter('nomenclature'+iteration,'ac2updates'+iteration,'stores?method=getItemListForIndent',{minChars:3,parameters:'requiredField=nomenclature'+iteration+'&counter='+iteration});
	  var cellRight4 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='<%=AV%>';
	  e3.size = '8';
	  e3.id='<%=idAu%>'+iteration;
	  cellRight4.appendChild(e3);
			  
	 
	 var cellRight5 = row.insertCell(4);
	  var e7 = document.createElement('select');
	 // e7.type = 'text';
	  //e7.size='8';
	  e7.name='<%=BATCH_ID%>';
	  e7.id='batchId'+iteration
	  e7.options[0] = new Option('Select', '');
	  e7.onblur=function(){getExpiryDateByAjax(this.value,iteration);};
	  cellRight5.appendChild(e7);
	  
	  var cellRight6 = row.insertCell(5);
	  var e8 = document.createElement('input');
	  e8.type = 'text';
	  e8.size='10';
	  e8.name='manufactureName';
	  e8.id='manufactureName'+iteration
	  cellRight6.appendChild(e8);

	  var e81 = document.createElement('hidden');
	  e81.type = 'text';
	  e81.size='10';
	  e81.name='<%=MANUFACTURER_ID%>';
	  e81.id='manufactureId'+iteration
	  cellRight6.appendChild(e81);

	  var cellRight7 = row.insertCell(6);
	  var e9 = document.createElement('input');
	  e9.type = 'text';
	  e9.size='8';
	  e9.name='<%=MANUFACTURING_DATE%>';
	  e9.id='manufacturerDate'+iteration
	  cellRight7.appendChild(e9);

	  var cellRight8 = row.insertCell(7);
	  var e10 = document.createElement('input');
	  e10.type = 'text';
	  e10.size=28;
	  e10.name='<%=EXPIRY_DATE%>';
	  e10.id='expiryDate'+iteration
	  cellRight8.appendChild(e10);

	  var cellRight9 = row.insertCell(8);
	  var e11 = document.createElement('input');
	  e11.type = 'text';
	  e11.size='8';
	  e11.name='<%=QUANTITY_RECEIVED%>';
	  e11.id='quanRecTemp'+iteration
	  cellRight9.appendChild(e11);

	  var cellRight10 = row.insertCell(9);
	  var e12 = document.createElement('input');
	  e12.type = 'text';
	  e12.size='20';
	  e12.name='remarks';
	  e12.setAttribute( "validate","Remarks,string,yes")
	  e12.id='remarksTemp'+iteration
	  cellRight10.appendChild(e12);

	  

	  
	}


function removeRow()
{
	var tbl = document.getElementById('defectiveDetails');
	 var tblRows  = tbl.getElementsByTagName("tr");
	var count = document.getElementById('hdb').value;
  	if(tblRows.length-2==0){
         	alert("Can not delete all rows")
         	return false;
     }
  	for(i=0;i<count.length;i++)
	{
		
  		//if (document.getElementsByName('srno')[i].checked == true)
		//{
		  	tbl.deleteRow(i-1);
		//}
	}
}



</script>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="sss" align="right" class="button"	value="Submit"	onclick="if(checkSave()){submitForm('grnGrid','stores?method=submitDefectiveDrug');}" />
<input type="button" name="Reset" type="submit" value="Reset"	class="buttonHighlight" />
<%-- <input type="button" name="print"	type="submit" class="button" value="Print"	onClick="submitForm('createGrn','stores?method=showDefectiveDrugReportJsp');" />--%>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>


<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" validate="rows,int,no"/>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>