<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Calendar"%>
    <%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.BloodMasComponent"%>
<%@page import="jkt.hms.masters.business.BloodSampleScreeningHeader"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blood Collection</title>
<div class="titleBg">
<h2>Blood Collection</h2>
</div>


<script type="text/javascript" src="/hms/jsp/js/jquery.js"></script>

<style type="text/css">
.desc{
	display: none;
	}

</style>
<script type="text/javascript">

    $(document).ready(function(){

        $('input[type="radio"]').click(function(){

            if($(this).attr("value")=="Y"){
            	$(".Blockdiv2").hide();
            	 $(".Blockdiv1").show();
           
            }

            if($(this).attr("value")=="N"){
            	 $(".Blockdiv1").hide();
            	 $(".Blockdiv2").show();
            	
            }

        });

    });

</script>
</head>
<body>
<%
Map<String, Object> map = new HashMap<String, Object>();
String bagNo="";
String tubeNo="";
List<BloodMasComponent> searchBloodComponentList = new ArrayList<BloodMasComponent>();
//List<StoreItemBatchStock> bagTypeList = new ArrayList<StoreItemBatchStock>();
//List<Object[]> bagTypeList = new ArrayList<Object[]>();

List<MasStoreItem> bloodBagsList = new ArrayList<MasStoreItem>();

List<StoreItemBatchStock> bagTypeList = new ArrayList<StoreItemBatchStock>();



if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
}
if(map.get("bagTypeList") != null)
{
	bagTypeList = (List<StoreItemBatchStock>) map.get("bagTypeList");
	
}
if(map.get("searchBloodComponentList") != null)
{
	searchBloodComponentList=(List<BloodMasComponent>)map.get("searchBloodComponentList");
}
if(map.get("bagNo")!=null){
	bagNo=map.get("bagNo").toString();
}

if(null !=map.get("bloodBagsList")){
	bloodBagsList=(List<MasStoreItem>)map.get("bloodBagsList");
}
int itemId=0;
String itemExpiryDate="";
if(null !=map.get("itemId")){
	itemId=(Integer)map.get("itemId");
}
SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
String dateInString = "2020-01-01";

try {

	Date date = formatter.parse(dateInString);
	//System.out.println(date);
	//System.out.println(formatter.format(date));

} catch (Exception e) {
	e.printStackTrace();
}

if(null !=map.get("itemExpiryDate")){
	itemExpiryDate=(String)map.get("itemExpiryDate");
	
}


%>

<script>
<%

               Calendar calendar=Calendar.getInstance();
               String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
               String curDate=String.valueOf(calendar.get(Calendar.DATE));
               int year=calendar.get(calendar.YEAR);
               if(month.length()<2){
                       month="0"+month;
               }
               if(curDate.length()<2){
                       curDate="0"+curDate;
               }

       %>

               serverdate = '<%=curDate+"/"+month+"/"+year%>'
</script>
<div class="Block">
<form name="bloodCollection" action="" method="post">


<label>Donor Registration Number</label> 
	<input type="text" readonly="readonly"  name="" value="${requestScope.map.donorRegno} "  maxlength="10"
	tabindex="1" /> 
	
<label>Identification Card</label>
	<!-- <select name="source" onchange="">
			<option value="rss">Select</option>
				<option value="other"></option>
			</select> -->
			<%-- <input type="text"  name="" value="${requestScope.map.idcardTypeCode}"  maxlength="3"
	tabindex="1" />  --%>
	<input type="text" readonly="readonly" name="" value=""  maxlength="20"
	tabindex="1" /> 
	
				
	
<label>Id Card Number</label> 
	<input type="text"  name="" readonly="readonly" value="${requestScope.map.idCardNo}"  maxlength="16"
	tabindex="1" /> 
	
	
<div class="clear"></div>

<label>UHID</label> 
	<input type="text"  name="" readonly="readonly" value="${requestScope.map.uhidNo}"  maxlength="16"
	tabindex="1" />

<label>Donor Name</label> 
	<input type="text"  name="" readonly="readonly" value="${requestScope.map.donorName}"  maxlength="20"
	tabindex="1" />
<label>Gender</label>
	<!-- <select name="source" onchange="">
			<option value="rss">Select</option>
				<option value="other"></option>
			</select> -->
			<input type="text" readonly="readonly"  name="" value="${requestScope.map.donorGender}"  maxlength="3"
	tabindex="1" /> 
	
	
	<input type="hidden" name="donorSequenceId" value="${requestScope.map.sequence}" MAXLENGTH="10" tabindex="1" />
	
<div class="clear"></div>	 
<label>Date Of Birth </label> 

<input type="text" 
	id="lastDateId" name="Date of Collection" value="${requestScope.map.donorDOB}"
	 MAXLENGTH="10" tabindex="1" />
	 
	
	<label>Bag Number<span>*</span></label> 
	<input type="text"  name="bagNumber" value="<%=bagNo%>" validate="Bag Number,string,yes"  maxlength="10"
	tabindex="1" readonly="readonly"/>
	<label>Tube Number<span>*</span></label> 
	<input type="text"  name="tubeNumber" value="" validate="Tube Number,string,yes" maxlength="10"
	tabindex="1" />
	<div class="clear"></div>
	
	<label>Type of Bag<span>*</span></label> 
	<!-- <input type="text"  name="typeOfbag" value="" validate="typeOfbag Number,string,yes"  maxlength="10"
	tabindex="1" /> -->
	
	<select id="bagTypeId" name="typeOfbag" >
 	
 	<%
 	if(null !=bloodBagsList && bloodBagsList.size()>0){
 		for(MasStoreItem storeItem:bloodBagsList){
 			
 			if(itemId>0 && storeItem.getId()==itemId){
 		%>
 		
 			<option value="<%=storeItem.getId()%>" selected="selected"><%=storeItem.getNomenclature()%></option>
 		<%}}}%>
 </select> 
 <%
 	
 	if(null !=bagTypeList && bagTypeList.size()>0){
 		for(StoreItemBatchStock stock:bagTypeList){%>
 		<input type="hidden" id="<%=stock.getId()%>" name="<%=stock.getId()%>" value="<%=stock.getItem().getBagQuantity()%>"/>
 		<%}
 	}
 	%>
	
	<label>Batch Number<span>*</span></label> 
	<select  name="batchNumber" id="batchNumberId" onchange="populateBagVolumeForBloodCollection(this.value);populateVolume(this.value);populateBagExpiry(this.value)"
	validate="Batch Number,string,yes"  maxlength="10" 
	tabindex="1" >
	<option value="">Select</option>
	<%if(null !=bagTypeList && bagTypeList.size()>0){ 
			for(StoreItemBatchStock stock:bagTypeList){%>
				
				<option value="<%=stock.getId() %>"><%= stock.getBatchNo() %></option>	
			
			    
	<%}} %>
	
	</select>
	<%if(null !=bagTypeList && bagTypeList.size()>0){ 
			for(StoreItemBatchStock stock:bagTypeList){%>
				<input type="hidden" value="<%=HMSUtil.convertDateToStringTypeDateOnly(stock.getExpiryDate())%>" name="bb<%=stock.getId()%>" id="bb<%=stock.getId()%>">
					
			
			    
	<%}} %>
	<label>Bag Quantity <span>*</span></label> 
	<input  name="collectedId" id="collectedId" readonly="readonly"
	validate="Quantity Number,string,yes"  maxlength="3" 
	tabindex="1" />
	<label class="small">ml</label>
	<div class="clear"></div>
	<label >Blood Bag Expiry Date<span>*</span></label>
	
	<input type="text" id="bagExpiryDateIdd" 
					name="bagExpiryDate" tabindex="1" value=""
					   onblur="chechBagValidity(this.value)"
					  
					
					   MAXLENGTH="10"  validate="DOB,date,yes" class="date"
						 />
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	
	<div class="clear"></div>
	
	<h4>Patient Vitals</h4>
	<div class="clear"></div>
	
	<label >Pulse</label> <input
	type="text"  name="pulse" value="${requestScope.map.pulse}"
	validate="Pulse,flat,no" maxlength="6" tabindex="1"  readonly="readonly"/> 
	
	<label >Per Minute</label>
	
	<table>
	<label class="medium">BP</label> 
	<input type="text" placeholder="Systolic"  name="systolic" value="${requestScope.map.bp}" readonly="readonly" validate="BP,string,no" maxlength="5"
	tabindex="1" /> 
	
	<input type="text"  placeholder="Diastolic" name="diastolic" value="${requestScope.map.bpDiastolic}" readonly="readonly" validate="BP,string,no" maxlength="5"
	tabindex="1" /> 
	<label class="small">mm Hg</label>
	<div class="clear"></div>
	
	<div class="clear"></div>
	<h4>Collection Details</h4>
	<div class="clear"></div>
	<div class="clear"></div>
	
	<div class="clear"></div>
	<label>Process Completed</label>
	
	<label class="autoSize"><input type="radio" name="status" class="radioCheckCol2" validate="Process Completed,string,yes" 
	value="Y" onclick="showHide(1)">Yes</label>
	
	<label class="autoSize"><input type="radio" name="status" class="radioCheckCol2" validate="Process Completed,string,yes" 
	value="N"  onclick="showHide(2)">No</label>
	
	<div class="clear"></div>
	<div  class="Blockdiv1 desc">
	<label>Blood Component</label>
	<!-- <select name="bldcomponent" onchange="setQuantity(this.value);"> -->
	<select name="bldcomponent" onchange="setQuantity(this.value);">
	<option value="">Select</option>
	<%
	if(null !=searchBloodComponentList && searchBloodComponentList.size()>0){
	for(BloodMasComponent component:searchBloodComponentList){
	%>
	
			
				<option value="<%=component.getId() %>"><%=component.getComponentName() %></option>
				
			
	<%}} %>
	</select> 
	<% if(null !=searchBloodComponentList && searchBloodComponentList.size()>0){
	for(BloodMasComponent component:searchBloodComponentList){
	%>
	
			
				<input type="hidden" id="id<%=component.getId()%>"  value="<%=component.getQtyUnit() %>"/>
				<input type="hidden" id="expiryid<%=component.getId()%>"  value="<%=component.getLifeSpan() %>"/>
				
			
	<%}} %>
	
	<label>Quantity Collected</label> 
	<!-- <select name="source" onchange="">
			<option value="rss">Select</option>
				<option value="other"></option>
			</select> -->
				<input type="text" id="compquantityID" readonly="readonly"
				 name="bldComponentquntity" value="" onkeypress="javascript:return isNumber (event)">
			
	<label class="small">ml</label>
	<div class="clear"></div>
	<label >Component Expiry Date</label>
	
	<input type="text" name="ExpiryDate" id="ExpiryDateId" value="" readonly="readonly">
	
	
	

				<!-- <div id="dobcalId">
					<img id="calImageId" src="/hms/jsp/images/cal.gif" width="16" height=""
						border="0"
						onclick="setdate('',document.getElementById('bagExpiryDate'),event)"
						tabindex="1" />
				</div> -->
	
	</div>
	

	<%-- <label>Blood Component</label>
	<%
	if(null !=searchBloodComponentList && searchBloodComponentList.size()>0){
	for(BloodMasComponent component:searchBloodComponentList){
	%>
	<select name="source" onchange="componentQuantity(this.value)">
			<option value="">Select</option>
				<option value="<%=component.getId() %>"><%=component.getComponentName() %></option>
			</select> 
	<%}} %>
	
	 --%>
	<!-- label>Quantity Collected</label> 
	<select name="source" onchange="">
			<option value="rss">Select</option>
				<option value="other"></option>
			</select>
			<input type="text" name="quntity" value="">
	<label class="small">ml</label> -->
	<div class="clear"></div>
	<div id="reasonDiv">
	<label class="autoSize" >Reason For Process Incomplete</label>
	<!-- <select name="source" onchange="">
			<option value="rss">Select</option>
				<option value="other"></option>
			</select> -->
			<input type="text" name="reason" value="">
	</div>
	
	
	
	
	<label>Remarks </label> 
	 <textarea rows="10" cols="100" name="remark">
</textarea>
	
	 <div class="clear"></div>
	 <input type="button" class="buttonBig2"  value="Transfer To Untested Blood"
	align="right" onclick="if(checkBagAndComponentQuantity()){submitForm('bloodCollection','/hms/hms/bloodBank?method=submitBloodSampleCollection&discard=untestedBlood')}" />  
	
	
	<input type="button" class="buttonBig2" name="discard"  value="Discard Blood"
	onclick="submitForm('bloodCollection','/hms/hms/bloodBank?method=submitBloodSampleCollection&discard=Discard Blood')" accesskey="r" />
	
	
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
	</div>
</body>
</html>

<script type="text/javascript">
function populateBagExpiry(itemId){
	
	var expirydate=document.getElementById("bb"+itemId).value;
	
	document.getElementById('bagExpiryDateIdd').value=expirydate;
	
}
function checkBagAndComponentQuantity(){
	var compQuantity=document.getElementById('compquantityID').value;
	var bagQuantity=document.getElementById('collectedId').value;
	if(compQuantity == bagQuantity ){
		return true;
	}else{
		
		 var r = confirm("Bag Quantity and Component Quantity are not equal ! Do You want continue ");
		    if (r == true) {
		        return true;
		    } else {
		    	 return false;;
		    }
	}
	
}
function populateVolume(itemId){
	//alert(itemId);
	if(itemId>0){
	var volume=document.getElementById(itemId).value;
	document.getElementById('collectedId').value=volume;
	}
	else{
		document.getElementById('collectedId').value="";
	}
}
	function showHide(op){
		if(op==1)
		{document.getElementById("reasonDiv").style.display="none";}	
		else if(op==2)
		{document.getElementById("reasonDiv").style.display="block";}
	}
	
	function setQuantity(id){
		
		var quantity=document.getElementById("id"+id).value;
		var lifeSpan=document.getElementById("expiryid"+id).value;
		
		document.getElementById("compquantityID").value=quantity;
			
		var newdate=new Date();
		var newtimems=newdate.getTime()+(lifeSpan*24*60*60*1000);
		newdate.setTime(newtimems);
					
		var dd = newdate.getDate();
		var mm = newdate.getMonth() + 1; 
		if((""+dd).length <2){
			dd="0"+dd;
		}if((""+mm).length<2){
			mm="0"+mm;
		} 
		var yyyy = newdate.getFullYear();
		var dateString = dd + "/" + mm + "/" + yyyy;
		document.getElementById("ExpiryDateId").value=dateString;
			
	}
	
	
	 function isNumber(evt) {
	        var iKeyCode = (evt.which) ? evt.which : evt.keyCode
	        if (iKeyCode != 46 && iKeyCode > 31 && (iKeyCode < 48 || iKeyCode > 57)){
	        	alert("Eneter only numeric value");
	            return false;
	        }

	        return true;
	    } 
	 
	 
	 function chechBagValidity(value){ 
		
		 if(value !="")
			{
		  			 var date  = value.substring(0,2);
		  			
		   			var month = value.substring(3,5);
		   			var year  = value.substring(6,10);

		   			var myDate= new Date(year,month-1,date);
		   		
					 var today = new Date();

			 if (myDate<today)
		  	 {
		  	 alert("Please Enter Valid Date ");
		  	 document.getElementById('bagExpiryDate').value="";
		  	 }
			 else{
				 
				 var value1= document.getElementById('ExpiryDateId').value;
				 
					 var date  = value1.substring(0,2);
			   		var month = value1.substring(3,5);
			   		var year  = value1.substring(6,10);
			   		var componentDate= new Date(year,month-1,date);
			   	 if (myDate<componentDate)
			  	 {
			   		 if(confirm("Bag Expiry date is less than  component date !"+"\n \n Do you want to continue ! ")){
			   			 
			   		 }
			   		 else{
			   			 document.getElementById('bagExpiryDate').value=""; 
			   		 }
			  	 
			  	 }
			 }
		 }
		 else{
			 alert(" Enter Bag Expiry Date "); 
		 }
	 }
	 
	 /* function populateVolume(itemId){
			
			if(itemId>0){
			var volume=document.getElementById(itemId).value;
			document.getElementById('bagExpiryDate').value=volume;
			
			var batchNo=document.getElementById("batch"+itemId).value;
			document.getElementById('batchNumberId').value=batchNo;
			
			}
			else{
				document.getElementById('collectedId').value="";
			}
		} */
	 
</script>