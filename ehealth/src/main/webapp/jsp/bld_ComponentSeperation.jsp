
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.BloodStockDetail"%>
<%@page import="jkt.hms.masters.business.BloodMasComponent"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>

<title>Blood Component Separation</title>

<script language="javascript">

function addRowForInvestigation(){

	  var tbl = document.getElementById('dataTable');
		
			  var lastRow = tbl.rows.length;
			  var iteration = lastRow;
			  var row = tbl.insertRow(lastRow);
			 
			  var hdb = document.getElementById('hiddenValue');
			  iteration = parseInt(hdb.value)+1;
			  hdb.value=iteration;
			  row.id=iteration;

			  var cellRight1 = row.insertCell(0);
			  var e0 = document.createElement('input');
			  e0.type = 'checkbox';
			  e0.name='chargeRadio'+iteration;
			  e0.id='chargeRadio'+iteration;
			 // e0.className='radioCheck';
			  cellRight1.appendChild(e0);
			  
			  var cellRight1 = row.insertCell(1);
			  var e1 = document.createElement('Select');
			  e1.name='mascomponentName'+iteration;
			  e1.id='mascomponentName'+iteration;
			  e1.style.width = "120px";
			  e1.options[0] = new Option('Select', '0');
			  e1.onchange=function(event)
	          {	
	          if(checkDuplicateComponentName(iteration)){ populateComponentExpiry(this.value,iteration),generateChildBagNo(iteration);}
		      };
			  for(var i = 0;i<compnenetArray.length;i++ ){
				e1.options[i+1] = new Option(compnenetArray[i][1],compnenetArray[i][0]);
			  }  
			  cellRight1.appendChild(e1);
			  for(var i = 0;i<compnenetArray.length;i++ ){
				  var e0 = document.createElement('input');
				  e0.type = 'hidden'; 
				  e0.id=compnenetArray[i][0]+iteration;
				  e0.value=compnenetArray[i][2];
				  cellRight1.appendChild(e0);
			}
			  
			  var cellRight3 = row.insertCell(2);
			  var e0 = document.createElement('input');
			  e0.type = 'text';
			  e0.name='bagNo'+iteration;
			  e0.id='bagNo'+iteration;
			  e0.size='20';
			  e0.readOnly=true;
			  //0.className = "opdgridText";
			  cellRight3.appendChild(e0); 
			  
			  var cellRight3 = row.insertCell(3);
			  var e0 = document.createElement('input');
			  e0.type = 'text';
			  e0.name='tubeNumber'+iteration;
			  e0.id='tubeNumber'+iteration;
			  e0.size='20';
			  //e0.className = "opdgridText";
			  cellRight3.appendChild(e0); 
			  
			  var cellRight3 = row.insertCell(4);
			  var e0 = document.createElement('input');
			  e0.type = 'text';
			  e0.name='childquantity'+iteration;
			  e0.id='childquantity'+iteration;
			  e0.size='20';
			  //e0.className = "opdgridText";
			  cellRight3.appendChild(e0); 
			  
			  var cellRight1 = row.insertCell(5);
			  var e1 = document.createElement('input');
			  e1.type = 'text';
			  e1.name='dateOfBirth'+iteration;
			  e1.id='dateOfBirth'+iteration;
			  e1.size='20';
			  e1.value="";
			//   e1.className='small';
			  e1.readOnly=true;
			  cellRight1.appendChild(e1);
			 
			  var img1 = document.createElement('img');
			  img1.src = '/hms/jsp/images/cal.gif';
			  img1.onclick=function(event)
	          {	
				  var obj=document.getElementById('dateOfBirth'+iteration);
				  setdate('',obj,event);
		      };
			  cellRight1.appendChild(img1);
			  
			  
			  

			
			}
function removeRowPrescriptionTab ()
{
	var tbl = document.getElementById('dataTable');
	  var lastRow = tbl.rows.length;
	  var hdb = document.getElementById('hiddenValue');
	  var iteration = parseInt(hdb.value);
	  var totalSelected=0;
	  for(var i=1;i<=iteration;i++)
		  {
		  if(document.getElementById("chargeRadio"+i)!=null && (typeof  document.getElementById("chargeRadio"+i).checked)!='undefined' && document.getElementById("chargeRadio"+i).checked )
			  {
			  totalSelected=totalSelected+1;
			  }
		  }
	      if(totalSelected==0)
		  {
		  alert('Please select atleast 1 row to delete');
		  }
	      else  if(lastRow==2 || lastRow==(totalSelected+1))
		  {
	    	  alert('You can not delete all Row.');
	      }
	      else if (lastRow > 2){
	    	  for(var i=1;i<=iteration;i++)
	    	  {
	    		  if(document.getElementById("chargeRadio"+i)!=null && (typeof  document.getElementById("chargeRadio"+i).checked)!='undefined' && document.getElementById("chargeRadio"+i).checked )
	    		  {
	    		  var deleteRow= document.getElementById("chargeRadio"+i).parentNode.parentNode;
	    		  document.getElementById("chargeRadio"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
	    		  }
	    	  }
	  }	      
}	
 function componentDetails(x){
	 alert("Row index is: " + x.rowIndex);
	 
 }
	</script>	

<%
    int pageNo=1;
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<BloodMasComponent> componentList = new ArrayList<BloodMasComponent>();
	
	List<BloodStockDetail> stockList = new ArrayList<BloodStockDetail>();
	List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
	 List<BloodStockDetail> pendingForComponentSeparationList = new ArrayList<BloodStockDetail>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	Box box = HMSUtil.getBox(request);
	String userName = "";
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("stockList") != null){
		stockList=(List)map.get("stockList");
	}
	if(map.get("pageNo") != null){
		pageNo=(Integer)map.get("pageNo");
	}
	if(map.get("componentList") != null){
		componentList=(List<BloodMasComponent>)map.get("componentList");
	}
	if(map.get("bloodGroupList") != null){
		bloodGroupList=(List<MasBloodGroup>)map.get("bloodGroupList");
	}
	
	
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	 if(map.get("pendingComponentSeparationList") != null){
		 pendingForComponentSeparationList = (List<BloodStockDetail>)map.get("pendingComponentSeparationList");
	   } 
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   
		  
		  
		%>
<h4><span><%=message %></span></h4>
<%}
%>

<form name="bloodSeperation" method="post" action="">
<div class="titleBg">
<h2>Blood Component Separation</h2>
</div>
<div class="Block">
<h4>Pending Bags For Component Separation</h4>
<%System.out.println("pendingForComponentSeparationList "+pendingForComponentSeparationList.size());
if(null !=pendingForComponentSeparationList && pendingForComponentSeparationList.size()>0){ %>
<table width="100%" colspan="7" id="componentDetails1" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<!-- <th width="3%">SR No</th> -->
			<th width="7%">Blood Bag No</th>
			<th width="7%">Tube No</th>
			<th width="7%">Expiry Date</th>
			<th width="7%">Blood group</th>
			<th width="7%">Quantity</th>
			
		</tr>
	</thead>
	<tbody>
	
	<%for(BloodStockDetail bloodStockDetail:pendingForComponentSeparationList) {%>
	<tr  onclick="populateComponentBagDetails('<%=bloodStockDetail.getBloodBagNo()%>');HighLightTR(this)" style="cursor: pointer;">
	<td><%=bloodStockDetail.getBloodBagNo() %></td>
	<td><%=bloodStockDetail.getTubeNo() %></td>
	<td><%=HMSUtil.convertDateToStringTypeDateOnly(bloodStockDetail.getStockMain().getExpiryDate()	)  %></td>
	<%if(null !=bloodStockDetail.getStockMain().getBloodGroup()){ %>
	<td><%=bloodStockDetail.getStockMain().getBloodGroup().getBloodGroupName() %></td>
	<%}else{%>
		<td></td>
	
		<%} %>
	
	<td><%=bloodStockDetail.getQty() %></td>
	</tr>
	<%} %>
	</tbody>
	</table>
	<%} %>
		<div class="clear"></div>
<!--Block One Starts-->
<h4>Blood Current Stock Details</h4>
<div class="clear"></div>
<div class="clear"></div>

<!-- <input type="text" id="tubeNumberId" name="tubeNumber" value=""/> -->
<table width="100%" colspan="7" id="componentDetails1" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<!-- <th width="3%">SR No</th> -->
			<th width="7%">Blood Bag No</th>
			<th width="7%">Blood Group</th>
			<!-- <th width="10%">Component Name</th> -->
			<th width="7%">Qty (ml)</th>
			<th width="7%">&nbsp;</th>
			
		</tr>
	</thead>
	<tbody>

		<tr>
			<%-- <td width="5%"><input type="text" size="2" value="<%=1 %>"
				name="<%=SR_NO1%>" readonly="readonly" /></td>
 --%>

			<td width="10%"><input type="text" value=""
				name="<%=BLOOD_BAG_NO1%>" id="bloodBagNo1"
				onblur="populateComponentBagDetails(this.value); " /></td>

			<script type="text/javascript">
		function fillComponentDetail(obj){
			
			
			var matched = false;
			<%	
			if(stockList != null && stockList.size() > 0){
				
					for (BloodStockDetail bloodStockDetail : stockList) {
						System.out.println(bloodStockDetail.getBloodBagNo());
						
			%>
					var invObj ="<%= bloodStockDetail.getBloodBagNo()%>";
					
					if(invObj == obj){
						
						document.getElementById('componentNameId').value="<%=bloodStockDetail.getComponent().getComponentName()%>"
							
						document.getElementById('componentCodeId').value="<%=bloodStockDetail.getComponent().getComponentCode()%>"
						document.getElementById('qty1').value="<%=bloodStockDetail.getQty()%>"
						document.getElementById('stockDetailId').value="<%=bloodStockDetail.getId()%>"
						document.getElementById('stockMainId').value="<%=bloodStockDetail.getStockMain().getId()%>"
						matched = true;
					
					}
							
			<%} } %>
				if(matched == false){
					alert("No Record exist for this Blood Bag No.");
					document.getElementById('bloodBagNo1').value = "";
					document.getElementById('componentNameId').value=""
					document.getElementById('componentCodeId').value=""
					document.getElementById('qty1').value=""
					document.getElementById('stockDetailId').value=""
					document.getElementById('stockMainId').value = "";
					return false;
				}
			
				}
	 					
	 			</script>
			<td width="10%">
			<input type="hidden" align="right"
				name="<%=BLOOD_STOCK_DT_ID%>" id="stockDetailId" value="" /> 
				 <input
				type="hidden" align="right" name="<%=BLOOD_STOCK_MAIN_ID%>"
				id="stockMainId" value="" /> 
				
				<input type="hidden" align="right"
				name="<%=BLOOD_COMPONENT_CODE%>" id="componentCodeId" value=""
				readonly="readonly" /> 
				
				<select name="mydropdown" id="mydropdownId">
				<option value="">Select</option>
				<%
				if(null !=bloodGroupList && bloodGroupList.size()>0){
					for(MasBloodGroup bloodgroup:bloodGroupList ){%>
					<option value="<%=bloodgroup.getId()%>"><%=bloodgroup.getBloodGroupName() %></option>
				<%}
				}
					%>
				
				</select>				
				</td>
				<td><input type="text" id="qty1" name="<%=QUANTITY1 %>" value=""
				validate="Qty,int,no" MAXLENGTH="3" readonly="readonly" /></td>
				
			 <td><input type="hidden" id="componentNameId"
				name="<%=BLOOD_COMPONENT_NAME1%>" value="" readonly="readonly" /></td>			
		</tr>

	</tbody>
</table>
	
<div class="clear"></div>
<div class="paddingTop5"></div>
<input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" /> <input type="hidden" name="pageNo" id="pageNo"
	value="<%=pageNo%>" />
	
<h4>Blood Component Separation Details</h4>

<div class="floatRight-">
<input type="button" name="delete" id="delete" onclick="removeRowPrescriptionTab()" accesskey="r" value="" class="buttonDel">
<input type="button" value="" onclick="addRowForInvestigation()" class="buttonAdd">
</div>
<div class="clear"></div>

<table id="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
<thead>
		<tr>
		    <th>&nbsp;</th>			
			<th scope="col">Component Name</th>
			<th scope="col">Bag Number</th>
			<th scope="col">Tube Number</th>
			<th scope="col">Quantity (ml)</th>
			<th scope="col">Expiry Date</th>			
		</tr>
	</thead>
	<tbody>
		<%-- <%

	int inc=0;
	for(inc=1;inc<=4;inc++){
 %>
 --%>
		<tr >
			<%-- <td width="5%"><input type="text" size="2" value="<%=inc%>"
				name="<%=SR_NO%>" readonly="readonly" /> <input type="hidden"
				align="right" name="smainId" id="stockMainId1<%=inc%>" value="" /></td>
 --%><%int inc=1; %>
 		<td><input name="chk" type="checkbox" id="chargeRadio<%=inc%>"></td>
 		 
 			<td>
 			<%-- <input type="text" size="40" id="componentName<%=inc%>"
				name="bloodComponentName" onblur="if(fillSrNo('<%=inc %>')){checkForComponentCode(this.value, '<%=inc %>');}" /> --%>
 			<select name="mascomponentName<%=inc %>" id="mascomponentName<%=inc %>" onchange="if(checkDuplicateComponentName(<%=inc%>)){populateComponentExpiry(this.value,<%=inc%>),generateChildBagNo(<%=inc%>);}">
 			<option value="">Select</option>
 			<%
 			if(null !=componentList && componentList.size()>0){
 			
 			for(BloodMasComponent component:componentList){
 				%>
				<option value="<%=component.getId()%>"><%=component.getComponentName()%></option>
				<%}} %>
			</select>
 				<script type="text/javascript">
 					var	compnenetArray= new Array();
		              <%
		              BloodMasComponent cmp = new BloodMasComponent();
					     for (int k = 0; k < componentList.size(); k++) {
					    	 cmp = (BloodMasComponent) componentList.get(k);
		     			%> 
		     			compnenetArray[<%=k%>]= new Array();
		     			compnenetArray[<%=k%>][0] = "<%=cmp.getId()%>";
		     			compnenetArray[<%=k%>][1] = "<%=cmp.getComponentName()%>";
		     			compnenetArray[<%=k%>][2] ="<%=cmp.getComponentCode()%>";
	     				<% }%> 
            	</script> 
            <%for(BloodMasComponent component:componentList){%>
            		<input type="hidden" value="<%=component.getComponentCode()%>" id="<%=component.getId()%><%=inc%>">
            <%}%>
 			</td>
			<td><input id="bagNo<%=inc %>" type="text" validate="Child Bag Number,String,yes" 
				name="bagNo<%=inc %>" value="" size="20" MAXLENGTH="45"
				tabindex=1  readonly="readonly"/></td>
				
			<td><input type="hidden" value="" name="<%=BLOOD_COMPONENT_ID%>"
				id="" /> 
				<input type="text" align="right"
				name="tubeNumber<%=inc %>" id="tubeNumberId<%=inc %>" value=""
				 /></td>

			
<!-- 
			<div id="ac2update" style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
	  new Ajax.Autocompleter(document.getElementById('componentName'),'ac2update','bloodBank?method=getComponentNameSeparationForAutoComplete',{parameters:'requiredField=bloodComponentName'});
			</script></td> -->
			<td><input type="text" id="quantity<%=inc %>" name="childquantity<%=inc %>" value="" validate="Quantity,int,yes" MAXLENGTH="3" />
			</td>
			<td>			
				<%-- <input type="text" class="date" id="BirthDateId" 
	name="<%=DATE_OF_BIRTH%>" readonly="readonly" value=""
	 MAXLENGTH="14" tabindex="1" /> 
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" onClick="setdate('',document.bloodDonationEntry.BirthDateId,event)" /> --%>
	
	<input type="text" id="dateOfBirth<%=inc %>"
					name="<%=DATE_OF_BIRTH %><%=inc %>" tabindex="1" value=""
					   onblur="validateExpDate(this,'sbirthDayId')"
					   onkeyup="mask(this.value,this,'2,5','/');" 
					   onchange="calculateAgeInAjax()"
					   MAXLENGTH="10" validate="Expiry Date,string,yes" class="//date"/>
	
<div id="dobcalId">
<img id="calImageId" src="/hms/jsp/images/cal.gif" width="16" height="" border="0" onclick="setdate('',document.getElementById('BirthDateId'),event)" tabindex="1" />
</div>
</td>
</tr>
<%-- <%} %> --%>
<%-- <input type="hidden" name="counter" id="counter" value="<%=inc %>" /> --%>
</tbody>
</table>
<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" value="<%=inc%>"/>
<div class="clear"></div>
<div class="paddingTop5"></div>

<!-- <input type="button" class="button" value="Submit"
	onclick="if(checkFilledRow() && checkFilledRow())submitFormDetails()"
	align="right" /> --> 
	
	 <input type="button" class="button" value="Submit"
	onclick="submitFormDetails()"
	align="right" />  
	
	<input type="reset" class="buttonHighlight"
	name="Reset" id="reset" value="Reset"
	onclick="resetClicked('bloodSeperation');" accesskey="r" />

<div class="clear"></div>
<%-- <div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label></div> --%>

<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
</div>
</form>
<script type="text/javascript">

<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
 %>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>
<script type="text/javascript">
function fillSrNo(rowVal){

	if(document.getElementById('componentName'+rowVal).value != ""){
		var pageNo=parseInt(document.getElementById('noOfRecords').value);
  			rowVal=rowVal%8
  		if(rowVal==0){
  			rowVal=8
  	 	}
  		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRecords').value=rowVal
			}
	}else if(document.getElementById('componentName'+rowVal).value == "" ){
		if(document.getElementById('noOfRecords').value > 0){
			document.getElementById('noOfRecords').value = parseInt(document.getElementById('noOfRecords').value)-1;
		}
	}
		return true;
}
 function submitFormDetails(){
var stockDtId=document.getElementById("stockDetailId").value

submitForm('bloodSeperation','bloodBank?method=submitBloodComponentSeperation&stockDtId='+stockDtId+'');
} 
/* function submitFormDetails(){
	var stockDtId=document.getElementById("stockDetailId").value
	submitForm('bloodSeperation','bloodBank?method=submitBloodComponentSeperation');
	} */
function checkForComponentCode(val,inc){
		if(val != "")
		{
			var pageNo =parseInt(document.getElementById('pageNo').value) 
			var start=((pageNo-1)*8)+1;
			var end=((pageNo-1)*8)+8;
			
			var index1 = val.lastIndexOf("[");
			var indexForComponentName= index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var componentId = val.substring(index1,index2);
			var indexForComponentName = indexForComponentName--;
			var componentName = val.substring(0,indexForComponentName);
		
		if(componentId =="")
		{
		
	     document.getElementById('componentCode'+inc).value="";
	  	 document.getElementById('quantity'+inc).value="";
	  	 document.getElementById('bloodBagId'+inc).value= document.getElementById('bloodBagNo1').value;
	  	document.getElementById('stockMainId1'+inc).value= document.getElementById('stockMainId').value;
	     return;
		}
		for(i=1;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('componentName'+i).value==val)
		{
			alert("Component Name already selected...!")
			document.getElementById('componentName'+inc).value=""
			document.getElementById('bloodBagId'+inc).value=""
			document.getElementById('stockMainId1'+inc).value=""
			var e=eval(document.getElementById('componentName'+inc)); 
			e.focus();
			return false;
		} }  }
		
		ajaxFunctionForAutoCompleteComponentNameForSeparition('bloodSeperation','bloodBank?method=fillItemsForComponentnameSeperation&componentName=' +  componentName , inc);
		
		}else{
			document.getElementById('componentCode'+inc).value = "";
			document.getElementById('quantity'+inc).value = "";
			document.getElementById('bloodBagId'+inc).value= document.getElementById('bloodBagNo').value;
			document.getElementById('stockMainId1'+inc).value= document.getElementById('stockMainId').value;
		}
}

function checkFilledRow(){
	var msg ="";
	if(document.getElementById('noOfRecords').value==0 || document.getElementById('noOfRecords').value ==""){
	  	alert("Please fill atleast one row to submit in Blood Component Separation Details.");
	  	return false;
	  }else{
	  var msg ="";
	  	var count = document.getElementById('noOfRecords').value;
	  	for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('componentName'+i).value != ""){
	  			if(document.getElementById('bloodBagId'+i).value == ""){
	  				msg += "BloodBag No. can not be blank.\n";
	  			}
	  			if(msg != ""){
	  				break;
	  			}
	  		}
	  	}
	  		if(msg != ""){
	  			alert(msg)
	  			return false;
	  		}else
	  			return true;
	  }
	 }
function checkFilledRow1(){
	var msg ="";
	  			if(document.getElementById('bloodBagNo1').value == ""){
	  				msg += "Blood Current Stock Details can not be blank.\n";
	  			}
	  			
	  		if(msg != ""){
	  			alert(msg)
	  			return false;
	  		}else
	  			return true;
	  }
function generateChildBagNo(index){
	
	var bloodComponentId=document.getElementById("mascomponentName"+index).value;
	var bloodComponentCode=document.getElementById(bloodComponentId+""+index).value;
	var parentBagNo=document.getElementById("bloodBagNo1").value;
	
	var childBagNo=bloodComponentCode+"-"+parentBagNo;
	document.getElementById("bagNo"+index).value=childBagNo;
	//document.getElementById("tubeNumberId"+index).value=childBagNo;
}
function checkDuplicateComponentName(index){
	var componentId=document.getElementById("mascomponentName"+index).value;
	var totalRow=document.getElementById("hiddenValue").value;
	var flag=false;
	for(var i=1;i<=totalRow;i++){
		if(i!=index){
		var selectedId=document.getElementById("mascomponentName"+i).value;
			if(componentId==selectedId){
				flag=true;
			}
		}
	}
	if(flag){
		alert("Component Already Selected");
		return false;
	}else{
		return true;
	}
}
	  
	 /*  function populateComponentdetails(value,inc){
		  alert(value)
		  alert(inc)
		  window.location.href = 'bloodBank?method=populateComponentDetails&componentId='+Id+"&roeId="+inc; 
		  
	  }
 */
</script>
