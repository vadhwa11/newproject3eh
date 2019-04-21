<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
    <%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.BloodRequestEntryDetail"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.BloodSampleCollection"%>
<%@page import="java.util.Calendar"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
	 <script type="text/javascript" src="/hms/jsp/js/jquery-1.4.2.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Of Indent</title>
<div class="titleBg">
<h2>Issue Of Indent</h2>
</div>

<script type="text/javascript">

        function Show_Div(Div_id) {

            if (false == $(Div_id).is(':visible')) {

                $(Div_id).show(250);

            }

            else {

                $(Div_id).hide(250);

            }

        }

    </script>
    
    <script>
<%

               Calendar calendar=Calendar.getInstance();
               String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
               String curDate=String.valueOf(calendar.get(Calendar.DATE));
              
               Map<String,Object> utilMap = new HashMap<String,Object>();
           	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
           	String currentDate = (String)utilMap.get("currentDate");
           	System.out.println("currentDate "+currentDate);
           	String time = (String)utilMap.get("currentTime");
               
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

<script language="javascript">
		function addRow(tableID) {
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;
			var row = table.insertRow(rowCount);
			var colCount = table.rows[0].cells.length;
			
			for (var i = 0; i < colCount; i++) {
				var newcell = row.insertCell(i);
				newcell.innerHTML = table.rows[0].cells[i].innerHTML;
				switch (newcell.childNodes[0].type) {
				case "text":
					newcell.childNodes[0].value = "";
					break;
				case "checkbox":
					newcell.childNodes[0].checked = false;
					break;
				case "select-one":
					newcell.childNodes[0].selectedIndex = 0;
					break;
				}
			}
		}
		function deleteRow(tableID) {
			try {
				
				var table = document.getElementById(tableID);
				var rowCount = table.rows.length;
				
				for (var i = 0; i < rowCount; i++) {
					var row = table.rows[i];
					
					var chkbox = row.cells[0].childNodes[0];
					alert(chkbox);
					if (null != chkbox && true == chkbox.checked) {
						
						if (rowCount <= 1) {
							
							alert("Cannot delete all the rows.");
							break;
						}
						
						table.deleteRow(i);
						rowCount--;
						i--;
					}
				}
			} catch (e) {
				alert(e);
			}
		}
	</script>
</head>
<body>
<%
int inc=1;
List<BloodRequestEntryDetail> bldRequestEntryDetailsList=new ArrayList<BloodRequestEntryDetail>();

Map<String,Object> map = new HashMap<String,Object>();

if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}

if(map.get("bldRequestEntryDetailsList") != null){
	bldRequestEntryDetailsList=(List<BloodRequestEntryDetail>)map.get("bldRequestEntryDetailsList");
}

Date dateOfIndent=null;
String indentBloodBank="";
String indentOrderNo="";

if(null !=bldRequestEntryDetailsList){
for(BloodRequestEntryDetail bred:bldRequestEntryDetailsList){
	dateOfIndent=bred.getRequest().getOrderDate();
	indentBloodBank=bred.getRequest().getHospital().getHospitalName();
	indentOrderNo=bred.getRequest().getOrderNo();
}
}
%>
<form  name="issueOfIndent" method="post">
<div class="Block">

<label>Indent Date </label> 
<input type="text" class="date"
	id="lastDateId" name="" value="<%=HMSUtil.convertDateToStringTypeDateOnly(dateOfIndent)  %>" readonly="readonly"
	validate="Date of Collection,date,no" MAXLENGTH="10" tabindex="1" />
	 <!-- <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.bloodDonationEntry.expiryDate,event)" />
	 -->
	
<label>Indent From </label> 
<input type="text" name="bloodBankName" value="<%=indentBloodBank %>"/>
<label>Indent Number</label> 
	<input type="text"  name="" value="<%=indentOrderNo %>" readonly="readonly" tabindex="1" /> 	
	
	<div class="clear"></div>
	<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>

	
<div class="clear"></div>

<!-- <input type="button" class="button" value="Add"
	onclick="addRow('dataTable')"
	align="right"/> 
	
	
	<input type="button" class="buttonHighlight"
	name="Reset" id="reset" value="Delete"
	onclick="deleteRow('dataTable')" accesskey="r"/>
	 -->
	
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<%int bloodGroupId=0;int bldRequestEntryHeaderId=0;
int componentId=1;
if(null !=bldRequestEntryDetailsList){
%>
	<table id=" " width="100%" border="0" cellspacing="0" cellpadding="0">
 <thead>
		<tr>
			<th> </th>
			<th>Blood Group</th>
			<th>Component Name</th>
			
			<th>Required Quantity</th>
			<th>Required On Date</th>
			
			<th></th>
		</tr>
		</thead>
		<%
		
		
		for(BloodRequestEntryDetail bred:bldRequestEntryDetailsList){
			bldRequestEntryHeaderId=bred.getRequest().getId();
			bloodGroupId=bred.getBloodGroup().getId();
			componentId=bred.getComponent().getId();
			%>
		
		<tr>
		<td>
			<input name="chk" type="checkbox" size="20" id="chk">
 		</td>
 			<td>
 			<input id="" type="text"
				name="bloodGroup<%=inc %>" value="<%=bred.getBloodGroup().getBloodGroupName() %>" size="20" MAXLENGTH="45"
				tabindex=1 readonly="readonly" />
			<!-- <select name="source" onchange="">
			<option value="rss">Select</option>
				<option value="other"></option>
			</select> -->
			
 			</td>
			<td><input id="" type="text"
				name="componentName<%=inc %>" value="<%=bred.getComponent().getComponentName() %>" size="20" MAXLENGTH="45"
				tabindex=1 readonly="readonly" /></td>
				
				
				<td><input id="" type="text"
				name="requiredQuantity<%=inc %>" value="<%=bred.getQty() %>" size="20" MAXLENGTH="45"
				tabindex=1 readonly="readonly" /></td>
				
			<td>
			<input type="text" class="date" id="requiredDate" name="requiredDate<%=inc %>" value="<%=HMSUtil.convertDateToStringTypeDateOnly(bred.getReqDate()) %>"
	validate="Date of Collection,date,no" MAXLENGTH="10" tabindex="1" /> 
			
			 </td>
			<td> 
			<input type="button" class="button" value="Issue"
			onclick="displayAndHideDiv(<%=bloodGroupId %>,<%=componentId %>)"  />
			</td>
		</tr>
		<%} %>
	
	</table>
<%} %>
<input type="hidden" value="<%=inc %>" name="incValue" >
<input type="hidden" value="<%=bldRequestEntryHeaderId %>" name="bldRequestEntryHeaderId" >

<div class="clear"></div>
<div class="clear"></div>

<!-- <input type="button" class="button" value="Submit"
	onclick="addRow('dataTable')"
	align="right" /> 
	
	<input type="button" class="buttonHighlight"
	name="Reset" id="reset" value="Reset"
	onclick="deleteRow('dataTable')" accesskey="r" /> -->
	
	<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>

	<div id="Div_1" class="Block" style="display: none; ">
	
	<label>Issue Indent Date </label> 

<input type="text" class="date"
	id="indentDateId" name="indentDateId" value="<%=currentDate %>"
	validate="Date of Collection,date,no" MAXLENGTH="10" tabindex="1" readonly="readonly"/>
	 <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate%>',document.issueOfIndent.indentDateId,event)" />
	
     <div class="clear"></div>
     <table id=" " width="100%" border="0" cellspacing="0" cellpadding="0">
 <thead>
		<tr>
			
			<th>Blood Bag Number</th>
			<th>Quantity(ml)</th>
			<th>Expiry Date</th>
			<th>Issued Quantity</th>
			<th>Select</th>
		</tr>
		<tr>
		<td><input id="bagNumId" type="text" 
				name="bagNum" value="" size="20" MAXLENGTH="45"
				tabindex=1 readonly="readonly" /></td>
				
		<td><input  type="text" id="quantityId"
				name="quantity" value="" size="20" MAXLENGTH="45"
				tabindex=1 readonly="readonly" /></td>
				
	<td><input id="ExpiryDateId" type="text"
				name="ExpiryDate" value="" size="20" MAXLENGTH="45"
				tabindex=1 readonly="readonly" /></td>
				
	<td><input id="" type="text"
				name="issueQuantity" value="" size="20" MAXLENGTH="45" validate="Issue Quantity,int,yes"
				tabindex=1  /></td>
						
		<td><input type="checkbox" name="vehicle" value="Bike"> </td>
		</tr>
		
	</thead>
	</table>
     <div class="clear"></div>
     
				
	<%-- <label>Quantity Issued</label>
     <input id="" type="text"
				name="<%=BLOOD_BAG_NO%>" value="" size="20" MAXLENGTH="45"
				tabindex=1 readonly="readonly" /> --%>
				
		<div class="clear"></div>		
	<input type="button" class="buttonHighlight"
	name="save"  value="Save"  accesskey="r"  onclick="submitForm('issueOfIndent','/hms/hms/bloodBank?method=saveIssueofIndent')" />
		
	<input type="button" class="buttonHighlight"
	name="Reset" id="reset" value="Reset"
	onclick="deleteRow('dataTable')" accesskey="r" />						
    </div>
</div>
<input type="hidden" name="hiddenComponentName" id="hiddenComponentNameId" value=""/>
<input type="hidden" name="hiddenBloodGroupName" id="hiddenBloodGroupId" value=""/>


		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</body>
<script type="text/javascript">

function displayAndHideDiv(bloodGroupId,componentId){
	
	var elem=document.getElementById('Div_1');
	if(elem.style.display=='block')
	{
	document.getElementById('Div_1').style.display = 'none';
	}
	else{
		document.getElementById('Div_1').style.display = 'block';	
		//alert();
		  populateBagDetalForIndent(bloodGroupId,componentId);
	}
	
	
}


</script>
</html>