<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.DgUom"%>
<script>
	function resultTypeee(rowVal){
	var rt = document.getElementById('resultType'+rowVal).value;
	if(rt == "h"){
		document.getElementById('comparisonType'+rowVal).value='n'
	}
	return true;
	}
</script>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	ArrayList  <MasSubChargecode> subChargecodeList = new ArrayList<MasSubChargecode>();
	ArrayList  <MasMainChargecode> mainChargecodeList = new ArrayList<MasMainChargecode>();
	ArrayList<MasChargeCode>chargeCodeList = new ArrayList<MasChargeCode>();
	List<DgUom> uomList = new ArrayList<DgUom>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	if(map.get("message") != null){
	 	  String message = (String)map.get("message");
	 	   out.println(message);
	}
	Boolean dataSaved=false;
	if(map.get("dataSaved") != null){
		dataSaved = (Boolean)map.get("dataSaved");

	}

	if(map.get("uomList") != null){
		uomList = (List<DgUom>)map.get("uomList");
	}
	if(map.get("subChargecodeList") != null){
	subChargecodeList = (ArrayList)map.get("subChargecodeList");
	}
	if(map.get("mainChargecodeList") != null){
	mainChargecodeList = (ArrayList)map.get("mainChargecodeList");
	}
	if(map.get("chargeCodeList") != null){
	chargeCodeList=(ArrayList)map.get("chargeCodeList");
	}
	int mainChargecodeId=0;
	int subChargeCodeId=0;
	int chargeCodeId=0;
	if(map.get("mainChargecodeId") != null){
		mainChargecodeId =(Integer) map.get("mainChargecodeId");
	}
	if(map.get("subChargeCodeId") != null){
		subChargeCodeId =(Integer) map.get("subChargeCodeId");
	}
	if(map.get("chargeCodeId") != null){
		chargeCodeId =(Integer) map.get("chargeCodeId");
	}
		int sampleId=0;
		int collectionCenterId =0;
		String investigationName="";
		String confidential="";
		String investigationType="";
		String dischargeSummary="";
		if(map.get("investigationName") != null){
			investigationName =(String) map.get("investigationName");
		}
		if(map.get("confidential") != null){
			confidential =(String) map.get("confidential");
		}
		if(map.get("investigationType") != null){
			investigationType =(String) map.get("investigationType");
		}
		if(map.get("dischargeSummary") != null){
			dischargeSummary =(String) map.get("dischargeSummary");
		}
		if(map.get("sampleId") != null){
			sampleId =(Integer) map.get("sampleId");
		}
		if(map.get("collectionCenterId") != null){
			collectionCenterId =(Integer) map.get("collectionCenterId");
		}
		String quantity ="";
		if(map.get("quantity") != null){
			quantity =(String) map.get("quantity");
		}
		String rareCommon ="";
		if(map.get("rareCommon") != null){
			rareCommon =(String) map.get("rareCommon");
		}
		int pageNo=0;
		if(map.get("pageNo") != null)
		{
		pageNo=(Integer)map.get("pageNo");
		}
		List<DgSubMasInvestigation> subInvestigationlist = new ArrayList<DgSubMasInvestigation>();
		if(map.get("subInvestigationlist") != null){
			subInvestigationlist =  (List<DgSubMasInvestigation>)map.get("subInvestigationlist");
		}
		int pageNoTemp = 0;
		if(map.get("pageNoTemp") != null){
			pageNoTemp =(Integer) map.get("pageNoTemp");
		}

%>

<script type="text/javascript">
	var icdArray=new Array();
	var usedForArray=new Array();
</script>


<script>
	function normal(rowNo,subTestId,chargeCodeId){
	if(document.getElementById('comparisonType'+rowNo).value == "v"){
	get_value(rowNo,subTestId,chargeCodeId);
	}
	else if(document.getElementById('comparisonType'+rowNo).value == "f"){
	get_value_for_fixedValues(rowNo,subTestId,chargeCodeId);
	}

	}

	function get_value(rowNo,subTestId,chargeCodeId)
	{
		var subTestId;
		subTestId =document.getElementById('subTestId'+rowNo).value
		var chargeCodeId;
		chargeCodeId = document.getElementById('chargeCodeId'+rowNo).value;
		var url="/hms/hms/investigation?method=showNormalValue&rowNo="+rowNo+'&subTestId='+subTestId+"&chargeCodeId="+chargeCodeId;
		popwindow(url);
	}

	function get_value_for_fixedValues(rowNo,subTestId,chargeCodeId)
	{
		var subTestId;
		subTestId =document.getElementById('subTestId'+rowNo).value

		//var chargeCodeId;
		//chargeCodeId = document.getElementById('chargeCodeId'+rowNo).value;
		var url="/hms/hms/investigation?method=showFixedValue&rowNo="+rowNo+'&subTestId='+subTestId;

		popwindow(url);
	}

	var newwindow;
	function popwindow(url)
	{

	newwindow=window.open(url,'name',"height=250,width=950,status=1");
	if (window.focus)
	{
	newwindow.focus()
	}
	}
	function checkFilledRow444(){
	var msg ="";
	var rowLength=document.getElementById('amcTDetailsListSize').value;

	if(document.getElementById('orderNo1').value ===""){
	  	alert("Please fill atleast one row to submit.");
	  	return false;
	  	}
	  for(var i=1;i<=parseInt(rowLength);i++)
	  {
	  var subTestName=document.getElementById('subTestName'+i).value;
	  var subTestCode=document.getElementById('subTestCode'+i).value;
	  var compressionType=document.getElementById('compressionType'+i).value;
	  if(subTestName!="")
	  {
	  if(subTestCode!="")
	  {
	 	if(compressionType=="")
	 	{
	 	alert("Please Select Compression Type");
	 	return false;
	 	}
	  else
	  {

	  }
	  }else
	  {
	  alert("please Enter Test Code");
	  return false;
	  }
	  }else
	  {
	   alert("please Enter Test Name");
	  return false;
	  }

	  }

	 }


	 function checkFilledRow()
{
	var count=document.getElementById('amcTDetailsListSize').value;

	var msg ="";


	  	for(var i=1;i<=count;i++){

	  	 if(document.getElementById('orderNo'+i).value!= ""){
	  	 	if(document.getElementById('subTestCode'+i).value!= ""){
	  	 		if(document.getElementById('subTestName'+i).value != ""){

	  	 		if(document.getElementById('resultType'+i).value != ""){
		  			if(document.getElementById('compressionType'+i).value == ""){
		  				msg += "Select compression Type.\n";
		  				document.getElementById('compressionType'+i).focus();
		  			}

		  			if(msg != ""){
		  				break;
		  			}
		  			}
		  			else
		  			{
		  			msg += "Select Result Type.\n";
		  			document.getElementById('resultType'+i).focus();

		  			}

	  			}
	  			else
	  			{
	  			msg += "sub Test Name can not be blank.\n";
	  			document.getElementById('subTestName'+i).focus();

	  			}

	  		}
	  		else
	  		{
	  		msg += "sub Test Code can not be blank.\n";
	  		document.getElementById('subTestCode'+i).focus();

	  		}
	  		}
	  		else
	  		{
	  		msg += "please fill atleast one raw\n";
	  		document.getElementById('orderNo'+i).focus();

	  		}

	  	}
	  	if(msg != ""){
	  		alert(msg)
	  		return false;
	  	}else{
	  		return true;
	  	}

	}
</script>
<div class="titleBg">
<h2>Diagnostic Master</h2>
</div>
<div class="Block">
<form name="chargeCode" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input type="button"
	name="back" value="Back" class="button"
	onclick="submitForm('chargeCode','/hms/hms/investigation?method=showInvestigationJsp');" />
<input type="hidden" name="<%= POJO_NAME %>" value="DgMasInvestigation"><input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="InvestigationName"><input
	type="hidden" name="<%=JSP_NAME %>" value="investigationSubTest"><input
	type="hidden" name="pojoPropertyCode" value="InvestigationCode">
<div class="clear"></div>
<div class="Block">
<%
String mainChargecodeName="";
int mainId=0;
if(mainChargecodeList != null){
for (MasMainChargecode masMainChargecode : mainChargecodeList)
{
	mainId=masMainChargecode.getId();
	if(mainChargecodeId == mainId){
	mainChargecodeId=masMainChargecode.getId();
	mainChargecodeName=masMainChargecode.getMainChargecodeName();
	%> <label>Lab </label> <input type="text"
	name="<%=MAIN_CHARGECODE_NAME %>" id="<%=MAIN_CHARGECODE_NAME %>"
	value="<%=masMainChargecode.getMainChargecodeName() %>"
	class="readOnly" readonly="readonly" /> <input type="hidden"
	id="<%=MAIN_CHARGECODE_ID %>" name="<%=MAIN_CHARGECODE_ID %>"
	value="<%=masMainChargecode.getId() %>"><input type="hidden"
	id="<%=INVESTIGATION_NAME %>" name="<%=INVESTIGATION_NAME %>"
	value="<%= investigationName%>"><input type="hidden"
	id="<%=INVESTIGATION_TYPE %>" name="<%=INVESTIGATION_TYPE %>"
	value="<%= investigationType%>"><input type="hidden"
	id="<%=DSICHARGE_SUMMARY %>" name="<%=DSICHARGE_SUMMARY %>"
	value="<%= dischargeSummary%>"><input type="hidden"
	id="<%=CONFIDENTIAL %>" name="<%=CONFIDENTIAL %>"
	value="<%= confidential%>"><input type="hidden"
	id="<%=SAMPLE_ID %>" name="<%=SAMPLE_ID %>" value="<%=sampleId %>"><input
	type="hidden" id="<%=COLLECTION_CENTER_ID %>"
	name="<%=COLLECTION_CENTER_ID %>" value="<%=collectionCenterId %>"><input
	type="hidden" id="<%=QUANTITY %>" name="<%=QUANTITY %>"
	value="<%=quantity %>"><input type="hidden"
	id="<%=RARE_COMMON %>" name="<%=RARE_COMMON %>"
	value="<%=rareCommon %>"><input type="hidden" name="pageNo"
	id="pageNo" value="<%=pageNo%>" /> <% 	}}
	}

	String subChargecodeName="";
	int subId=0;
	if(subChargecodeList != null){
	for (MasSubChargecode massubChargecode : subChargecodeList)
	{
		subId=massubChargecode.getId();
		if(subChargeCodeId == subId){
		subChargeCodeId=massubChargecode.getId();
		subChargecodeName=massubChargecode.getSubChargecodeName();
		%> <label>LabGroup </label> <input type="text"
	name="<%=SUB_CHARGECODE_NAME %>" id="<%=SUB_CHARGECODE_NAME %>"
	value="<%=massubChargecode.getSubChargecodeName() %>" class="readOnly"
	readonly="readonly" /> <input type="hidden"
	id="<%=SUB_CHARGECODE_ID %>" name="<%=SUB_CHARGECODE_ID %>"
	value="<%=massubChargecode.getId() %>"> <% 	}}}%> <%
	String chargecodeName="";
	int chargeId=0;
	if(chargeCodeList != null){
	for (MasChargeCode masChargeCode : chargeCodeList)
	{
		chargeId=masChargeCode.getId();
		if(chargeCodeId == chargeId){
			chargeCodeId=masChargeCode.getId();
		chargecodeName=masChargeCode.getChargeCodeName();
		%> <label>Test Name</label> <input type="text"
	name="<%=CHARGE_CODE_NAME %>" id="<%=CHARGE_CODE_NAME %>"
	value="<%=masChargeCode.getChargeCodeName()%>" class="readOnly"
	readonly="readonly" /> <input type="hidden" id="<%=CHARGE_CODE_ID %>"
	name="<%=CHARGE_CODE_ID %>" value="<%=masChargeCode.getId() %>"/>
<div class="clear"></div>
<% 	}}}%>
</div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="cmntable">
<table width="100%" border="0" id="chargeDetails" cellspacing="0"
	cellpadding="0">

	<tr>
		<th> </th>
		<th>Order No.</th>
		<th>Sub Test Code</th>
		<th>Sub Test Name</th>
		<th>Unit</th>
		<th>Result Type</th>
		<th>Comparison Type</th>
	</tr>
	<%

    	int temp=0;
    	int inc = 0;
    		if(subInvestigationlist.size() >0 && inc-1 < subInvestigationlist.size() ){
    		for(inc=1;inc<=subInvestigationlist.size();inc++){
    			DgSubMasInvestigation dgInv = subInvestigationlist.get(inc-1);
    	%>
	<tr>
	<td><input type="checkbox" value="<%=inc%>" name="selectedChrage" class="radioCheck" /></td>
		<td><input type="hidden" value="<%=dgInv.getId() %>"
			name="<%=SUBTEST_ID%>" id="<%=SUBTEST_ID %><%=inc %>" /> <input
			type="hidden" id="chargeCodeId<%=inc %>" name="chargeCodeId"
			value="<%=dgInv.getChargeCode().getId() %>"/><input
			type="hidden" value="<%=temp+inc%>" id="<%=SR_NO %>"
			name="<%=SR_NO%>" /> <input type="text" size="2"
			value="<%=dgInv.getOrderNo() %>" name="<%=ORDER_NO%>"
			id="orderNo<%=inc %>" disabled="disabled" maxlength="4"
			validate="Order No,int,no" tabindex=1 /></td>

		<td><input type="text" size="8"
			value="<%=dgInv.getSubInvestigationCode() %>"
			name="<%=SUBTEST_CODE%>" id="subTestCode<%=inc %>"
			disabled="disabled" validate="Sub test code,string,no" maxlength="8"
			tabindex=1 /></td>

		<td><input type="text"
			value="<%=dgInv.getSubInvestigationName() %>"
			name="<%=SUBTEST_NAME%>" id="subTestName<%=inc %>"
			validate="Sub test name,string,no" maxlength="30" disabled="disabled"
			tabindex=1 /></td>

		<td><select id="unitName" name="<%=UNIT_OF_MEASUREMENT_ID %>"
			validate="Unit,string,no" disabled="disabled" tabindex=1>
			<option value="">Select</option>
			<%

	for (DgUom dgUom : uomList){
		if(dgInv.getUom() != null){
		if (dgInv.getUom().getId().equals(
		dgUom.getId())) {
	%>
			<option value=<%=dgUom.getId()%> selected="selected"><%=dgUom.getUomName()%></option>
			<%} else {%>
			<option value=<%=dgUom.getId()%>><%=dgUom.getUomName()%></option>
			<%
	}
	}}
%>
		</select></td>

		<td><select name="<%=RESULT_TYPE %>"
			id="<%=RESULT_TYPE %><%=inc %>" tabindex=1 disabled="disabled"
			validate="Result Type,string,no"
			onchange="checkComparisionType(this.value,'<%=inc %>');">
			<option value="0">Select</option>

			<option value="h" <%=HMSUtil.isSelected(dgInv.getResultType(),"h")%>>Heading</option>
			<option value="s" <%=HMSUtil.isSelected(dgInv.getResultType(),"s") %>>Single
			Parameter</option>
			<option value="m" <%=HMSUtil.isSelected(dgInv.getResultType(),"m") %>>Text
			Area</option>
			<option value="t" <%=HMSUtil.isSelected(dgInv.getResultType(),"t") %>>Text</option>
			<option value="r" <%=HMSUtil.isSelected(dgInv.getResultType(),"r") %>>Range</option>
		</select></td>
		<td><select name="<%=COMPARISON_TYPE %>"
			id="<%=COMPARISON_TYPE%><%=inc %>" tabindex=1
			validate="Comparison Type,string,no" onclick="normal(<%=inc %>);">
			<option value="0">Select</option>
			<option value="n"
				<%=HMSUtil.isSelected(dgInv.getComparisonType(),"n")%>>None</option>
			<option value="f"
				<%=HMSUtil.isSelected(dgInv.getComparisonType(),"f") %>>Fixed
			Values</option>
			<option value="v"
				<%=HMSUtil.isSelected(dgInv.getComparisonType(),"v") %>>Normal
			Values</option>
		</select>
		</td>
	</tr>
	<%}
    		}else{
    			for(inc=1;inc<=1;inc++){
  %><input type="hidden" value="addOnlyInSubMasInvesrigation"
		id="addInSubMas" name="addInSubMas" />
	<tr>
	<td><input type="checkbox" value="<%=inc%>" name="selectedChrage" class="radioCheck" /></td>

		<td><input type="hidden" value="<%=temp+inc%>" id="<%=SR_NO %>"
			name="<%=SR_NO%>" /> <input type="text" size="2" value=""
			name="<%=ORDER_NO%>" id="orderNo<%=inc %>" maxlength="4"
			validate="Order No,int,no" tabindex=1 /></td>

		<td><input type="text" size="8" value="" name="<%=SUBTEST_CODE%>"
			id="subTestCode<%=inc %>" validate="Sub test code,string,no"
			maxlength="8" tabindex=1 /></td>

		<td><input type="text" value="" name="<%=SUBTEST_NAME%>"
			id="subTestName<%=inc %>" validate="Sub test name,string,no"
			maxlength="30" tabindex=1 /></td>

		<td><select id="unitType<%=inc %>"
			name="<%=UNIT_OF_MEASUREMENT_ID %>" validate="Unit,string,no"
			tabindex=1>
			<option value="">Select</option>
			<%
				for (DgUom dgUom : uomList){
				%>
			<option value="<%=dgUom.getId ()%>"><%=dgUom.getUomName()%></option>
			<%}%>

				<%
				DgUom  dgUom = new DgUom();
		    	    for (int i = 0; i <uomList.size(); i++)
		    	    {
		    	    	dgUom = (DgUom) uomList.get(i);
	    %>
			<script>
	     		 	usedForArray[<%=i%>]= new Array();
		          	usedForArray[<%=i%>][0] = "<%=dgUom.getId()%>";
		         	usedForArray[<%=i%>][1] = "<%=dgUom.getUomName()%>";
	    	</script>
	    <%
	    			}
	    %>

		</select></td>
		<td><select name="<%=RESULT_TYPE %>" id="resultType<%=inc %>"
			tabindex=1 validate="Result Type,string,no"
			onchange="checkComparisionType(this.value,'<%=inc %>');">
			<option value="">Select</option>
			<option value="h">Heading</option>
			<option value="s">Single Parameter</option>
			<option value="m">Text Area</option>
			<option value="t">Text</option>
			<option value="r">Range</option>
		</select></td>
		<td><select name="<%=COMPARISON_TYPE %>"
			id="compressionType<%=inc %>" tabindex=1
			validate="Comparison Type,string,no">
			<option value="">Select</option>
			<option value="n">None</option>
			<option value="f">Fixed Values</option>
			<option value="v">Normal Values</option>
		</select></td>
	</tr>

	<%}} %>

	<input type="hidden" class="medcaption" name=<%=inc%> value="y"
		id="status" />
</table>
</div>
<input type="hidden"name="hiddenValueCharge"  value="y"	id="hiddenValueCharge" />
<div class="clear"></div>
<% if(dataSaved==true){%>
<%}else{ %>
<input type="button" name="add" value="" class="buttonAdd" onclick="addRow();"
			<%--onclick="generateRowWithoutSrNo('chargeDetails');"--%> tabindex="1" />
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" />
<%}%>
<div class="paddingTop15"></div>
<%
	if(subInvestigationlist.size() == 0){
%>
<div class="clear"></div>
<div class="division"></div>
<input type="hidden" id="amcTDetailsListSize"
	name="amcTDetailsListSize" value="1" />
<input type="hidden" id="pageNoTempFromBackButton"
	name="pageNoTempFromBackButton" value="<%=pageNoTemp%>" /> <input
	type="button" class="button" value="Submit" align="left"
	onClick="if(checkFilledRow()){submitForm('chargeCode','investigation?method=submitSubTest');}" />
<input type="button" class="button" value="Back" align="left"
	onClick="submitFormForButton('chargeCode','investigation?method=showInvestigationJsp');" />
<div class="clear"></div>
<div class="division"></div>
</div>

<% }%> 

<script type="text/javascript">

function generateRowWithoutSrNo(idName) {

		var d=document.getElementById(idName).getElementsByTagName("tr");
		lastTr = d[d.length-1]
		var noOfRows=d.length
		clone = lastTr.cloneNode(true);
		clone.id = parseInt(lastTr.id);
		lastTr.parentNode.insertBefore(clone,lastTr.nextSibling)
		var tblCtrl = d[d.length-1].getElementsByTagName("input");
		for(var i=0;i<tblCtrl.length;i++)
			tblCtrl[i].value="";
			document.getElementById('amcTDetailsListSize').value=noOfRows


		}

 function checkComparisionType(resultType,inc){
  obj = document.getElementById('compressionType'+inc);


  obj.length =1;

	 if(resultType == "h"){
	 	obj.length++;
	 	obj.options[obj.length-1].value="n";
		obj.options[obj.length-1].text="None";
		obj.options[obj.length-1].selected = true;
	 }else{
	 	obj.length++;
	 	obj.options[obj.length-1].value="n";
		obj.options[obj.length-1].text="None";
		obj.length++;
		obj.options[obj.length-1].value="f";
		obj.options[obj.length-1].text="Fixed Values";
		obj.length++;
		obj.options[obj.length-1].value="v";
		obj.options[obj.length-1].text="Normal Values";

	 }

 }




function addRow(){
	var tbl = document.getElementById('chargeDetails');
	var lastRow = tbl.rows.length;
	document.getElementById('amcTDetailsListSize').value=lastRow

	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('amcTDetailsListSize');

	var iteration = parseInt(hdb.value);

	hdb.value = iteration;
	var cell0 = row.insertCell(0);
		var e0 = document.createElement('input');
		e0.type = 'checkbox';
		e0.name='selectedChrage';
		e0.className = 'radioCheck';
		e0.value=(iteration);
		cell0.appendChild(e0);

	var cell1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.size='2';
	e1.name = "<%=ORDER_NO%>";
	e1.id = 'orderNo' + (iteration);
	e1.tabIndex="1";
	cell1.appendChild(e1);

	var cell2 = row.insertCell(2);
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.size='8';
	e2.name="<%=SUBTEST_CODE%>";
	e2.id = 'subTestCode'+(iteration)
	e2.tabIndex="1";
	cell2.appendChild(e2);


	var cell3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name="<%=SUBTEST_NAME%>";
	e3.id = 'subTestName'+(iteration)
	cell3.appendChild(e3);
	e3.size='20';


	var cell4 = row.insertCell(4);
	var e4 = document.createElement('select');
	e4.name="<%=UNIT_OF_MEASUREMENT_ID %>";
	e4.id='unitType'+(iteration);
	e4.options[0] = new Option('Select', '');
	  	for(var i = 0;i<usedForArray.length;i++ ){
	      e4.options[usedForArray[i][0]] = new Option(usedForArray[i][1],usedForArray[i][0]);
	    }
	cell4.appendChild(e4);


		var cell5 = row.insertCell(5);
		var e5 = document.createElement('Select');
		e5.name = "<%=RESULT_TYPE %>";
		e5.id = 'resultType'+(iteration);
		e5.options[0] = new Option('Select', '');
		e5.options[1] = new Option('Heading', 'h');
		e5.options[2] = new Option('Single Parameter', 's');
		e5.options[3] = new Option('Text Area', 'm');
		e5.options[4] = new Option('Text', 't');
		e5.options[5] = new Option('Range', 'r');
		e5.onchange = function()
					{
						checkComparisionType(this.value,iteration);
					};
		cell5.appendChild(e5);


		var cell6 = row.insertCell(6);
		var e6 = document.createElement('Select');
		e6.name = "<%=COMPARISON_TYPE %>";
		e6.id = 'compressionType'+(iteration);
		e6.options[0] = new Option('Select', '');
		e6.options[1] = new Option('None', 'n');
		e6.options[2] = new Option('Fixed Values', 'f');
		e6.options[3] = new Option('Normal Value', 'v');

		cell6.appendChild(e6);
}
function removeRow()
	{
		var tbl = document.getElementById('chargeDetails');
		var lastRow=document.getElementById('amcTDetailsListSize').value;
		 var tblRows  = tbl.getElementsByTagName("tr");

	  	if(tblRows.length-2==0){
	         	alert("Can not delete all rows")
	         	return false;
	     }

		for(counter=0;counter<document.getElementsByName('selectedChrage').length;counter++)
		{
			if (document.getElementsByName('selectedChrage')[counter].checked == true)
			{
			  	tbl.deleteRow(counter+1);
			  	document.getElementById('amcTDetailsListSize').value=parseInt(lastRow)-1;
			}
		}
	}

 </script>

</form>

