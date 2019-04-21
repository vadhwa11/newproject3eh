<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.util.*"%>
<%-- <%@ taglib uri="http://www.owasp.org/index.php/Category:OWASP_CSRFGuard_Project/Owasp.CsrfGuard.tld" prefix="csrf" %>
<script type="text/javascript" language="javascript"  src="/hms/JavaScriptServlet">
</script> --%>
<script type="text/javascript">
/* var csrfTokenName='<csrf:tokenname />';
var csrfTokenValue='<csrf:tokenvalue />'; */
 var csrfTokenName='${_csrf.parameterName}';
 var csrfTokenValue='${_csrf.token}';
</script>
<script type="text/javascript"  src="/hms/jsp/js/csrfToken.js"></script>

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>
<%
Map<String, Object> map = new HashMap<String, Object>();
List<MasFrequency> frequeList=new ArrayList<MasFrequency>();
List<MasStoreItem> itemList=new ArrayList<MasStoreItem>();
if(request.getAttribute("map")!=null)
{
	map=(Map<String, Object>)request.getAttribute("map");
}
Boolean status=null;
if(map.get("frequeList")!=null)
{
	frequeList=(List<MasFrequency>)map.get("frequeList");
}
if(map.get("itemList")!=null)
{
	itemList=(List<MasStoreItem>)map.get("itemList");
} 
List<TaperedMedicineUtil> taperUtilList=new ArrayList<TaperedMedicineUtil>();
if(map.get("taperUtilList")!=null)
{
	taperUtilList=(List<TaperedMedicineUtil>)map.get("taperUtilList");
} 
int row=0;
if(map.get("row")!=null){
	row=(Integer)map.get("row");
}
String taperedEdit="N";
if(map.get("taperedEdit")!=null){
	taperedEdit=(String)map.get("taperedEdit");
}
int itemId=0;
String nomenclature="",unitValue="";
if(itemList.size()>0){
	MasStoreItem item=itemList.get(0);
	nomenclature=item.getNomenclature();
	unitValue=item.getItemConversion().getItemUnitName();
	itemId=item.getId();
}
System.out.println("row jsp "+row);
%>
<form name="taperedForm" method="post" action="" enctype="multipart/form-data">
<div class="Block">
<label>Item Name</label><input type="text"
				value="<%=nomenclature%>" readonly="readonly" />
<label>Unit</label><input type="text"
				value="<%=unitValue%>" readonly="readonly" />
<%if(!taperedEdit.equalsIgnoreCase("Y")){ %>
<div style="margin-left:700px; ">

<input type="button" class="buttonAdd"  value=""	onclick="addRow();" />
<input type="button"  class="buttonDel" onclick="removeRow();" value="" />
</div>
<%}%>
<div class="clear"></div>
<div class="tableForTab" style="width:1200px; height:152px; overflow: scroll;">
    <table border="0" align="center" cellpadding="0" cellspacing="0" id="gridForPrescription">
		<tr>
          <th scope="col">&nbsp;</th>          
          <th scope="col">Frequency</th>
          <th scope="col">Dosage</th>
          <th scope="col">Dosage Total</th>
          <th scope="col">Duration</th>
          <th scope="col">Total</th>
        </tr>
        <%if(taperedEdit.equalsIgnoreCase("Y")){ 
        	int inc=0;System.out.println("taperUtilList "+taperUtilList.size());
        %>
        <%for(TaperedMedicineUtil tap:taperUtilList){
        int dosTot=0;
        String dosAr[]=tap.getDosage().split("-");
        %>
        <tr>
        <td>&nbsp;</td>
        <td id="col<%=inc%>"> <select style="width: 90px; background: #FFFF99" 
				name="frequency<%=inc%>" id="frequency<%=inc%>" onchange="getFrequencyValue(this.value,<%=inc%>);getFillValue(<%=inc%>);"
				>
				<option value="0">Select</option>
              <%for(MasFrequency freq : frequeList){												  
                Integer id = freq.getId();
				String name = freq.getFrequencyName();
				String type = freq.getFrequencyType();
			  if(tap.getFrequency().equals(id)){ dosTot=freq.getFrequencyCount();%>
             <option id="<%=type %>" selected="selected" value="<%=id %>"><%=name%></option>
                <%}else{ %>
              <option id="<%=type %>" value="<%=id %>"><%=name%></option>
		      <%} }%>
		      </select>
		       <input type="hidden" name="frequencyValue<%=inc%>" 
											id="frequencyValue<%=inc%>" value="<%=dosTot%>" size="6" /> 
		      </td>
        <td>
        <%for(int d=0;d<dosTot;d++){ %>
        <input type="text"  class="textYellow opdTextBoxTSmall" size="10"
                     value="<%=dosAr[d]%>" 
					 id="dos<%=d%><%=inc%>" name="dos<%=d%><%=inc%>" readonly="readonly"
					 onblur="fillDosageAndCount(<%=inc%>);getFillValue(<%=inc%>);" oninput="fillDosageAndCount(<%=inc%>);getFillValue(<%=inc%>);" onkeypress="return isNumberKey(event)"/>
		<%}%>
        <input type="hidden"  class="textYellow opdTextBoxTSmall" size="10"
                     value="<%=tap.getDosage()%>" 
					 id="dosage<%=inc%>" name="dosage<%=inc%>" readonly="readonly"
					 onblur="getFillValue(<%=inc%>);" oninput="getFillValue(<%=inc%>);" onkeypress="return isNumberKey(event)"/></td>
        <td><input type="text"  class="textYellow opdTextBoxTSmall" size="10"
                      value="<%=tap.getDosageCount()%>"  readonly="readonly"
					 id="dosageCount<%=inc%>" name="dosageCount<%=inc%>" 
					 onblur="getFillValue(<%=inc%>);" oninput="getFillValue(<%=inc%>);"/></td>
        <td><input type="text"  class="textYellow opdTextBoxTSmall" size="10"
                      value="<%=tap.getDuration()%>"  id="duration<%=inc%>" name="duration<%=inc%>"
                     onblur="getFillValue(<%=inc%>);" oninput="getFillValue(<%=inc%>);" onkeypress="return isNumberKey(event)"
                      /></td>
        <td><input type="text"  class="textYellow opdTextBoxTSmall" size="10"
                     value="<%=tap.getTotal()%>" 
					 id="total<%=inc%>" onkeypress="return isNumberKey(event)"
					name="total<%=inc%>" /></td>
        </tr>
         <%inc++;}%>
         <input type="hidden" id="hdb" name="hdb" value="<%=inc%>"/>
        <% }else{%>
        <%int inc=0;int inxRow = 1;
		int inxCol = 0;
        for(inc=0;inc<1;inc++){ %>
        <tr>
        <td><input type="checkbox" class="radioCheck" id="itemRadio<%=inc%>" name="itemRadio<%=inc%>" tabindex="<%=inxRow%><%=inxCol + 1%>"></td>
         <td id="col<%=inc%>">
        <input type="hidden" name="frequencyValue<%=inc%>" 
											id="frequencyValue<%=inc%>" value="" size="6" /> 
        <select style="width: 90px; background: #FFFF99" tabindex="<%=inxRow%><%=inxCol + 2%>"
				name="frequency<%=inc%>" id="frequency<%=inc%>" onchange="getFrequencyValue(this.value,<%=inc%>);getFillValue(<%=inc%>);"
				>
				<option value="0">Select</option>
            <%for(MasFrequency freq : frequeList){												  
              int id = freq.getId();
				String name = freq.getFrequencyName();
				String type = freq.getFrequencyType();
			  %>
           <option id="<%=type %>" value="<%=id %>"><%=name%></option>
		      <%} %>
		      </select>
		 </td>
        <td><input type="text"  class="textYellow opdTextBoxTSmall" size="10"
                   value="" tabindex="<%=inxRow%><%=inxCol + 3%>"
					 id="dosage<%=inc%>" name="dosage<%=inc%>" readonly="readonly"
					 onblur="getFillValue(<%=inc%>);" oninput="getFillValue(<%=inc%>);" onkeypress="return isNumberKey(event)"/></td>
		 <td><input type="text"  class="textYellow opdTextBoxTSmall" size="10"
                   value="" tabindex="<%=inxRow%><%=inxCol + 4%>" readonly="readonly"
					 id="dosageCount<%=inc%>" name="dosageCount<%=inc%>" 
					 onblur="getFillValue(<%=inc%>);" oninput="getFillValue(<%=inc%>);" onkeypress="return isNumberKey(event)"/></td>
       
         <td><input type="text" tabindex="<%=inxRow%><%=inxCol + 5%>" class="textYellow opdTextBoxTSmall" size="10"
                   value="" id="duration<%=inc%>" name="duration<%=inc%>"
                   onblur="getFillValue(<%=inc%>);" oninput="getFillValue(<%=inc%>);" onkeypress="return isNumberKey(event)"
                    /></td>
         <td><input type="text" tabindex="<%=inxRow%><%=inxCol + 6%>" class="textYellow opdTextBoxTSmall" size="10"
                   value=""
					 id="total<%=inc%>" onkeypress="return isNumberKey(event)"
					name="total<%=inc%>" /></td>
      </tr>
      <%}%>
        <input type="hidden" id="hdb" name="hdb" value="<%=inc%>"/>
		<input type="hidden" name="hdbIndex" id="hdbIndex" value="<%=inxRow%>" />
       <%}%>
	</table>
	
	<input type="hidden" name="totalCount" id="totalCount" value="0" />	
 
</div>
<%if(!taperedEdit.equalsIgnoreCase("Y")){ %>
<input name="submit" id="Submit" class="buttonAuto" type="button" align="right"	value="Submit"
				 onclick="if(validateFormEmpty()){validateTaperedForm();}" />
<input name="cancel" id="cancel" class="buttonAuto" type="button" align="right"	value="Cancel"
				 onclick="cancelFunction('N');" />
<%}else{%>
<input name="Update" id="Update" class="buttonAuto" type="button" align="right"	value="Update"
				 onclick="if(validateFormEmpty()){UpdateTaperedForm();}" />
<input name="cancel" id="cancel" class="buttonAuto" type="button" align="right"	value="Cancel"
				 onclick="cancelFunction('Y');" />
<%}%>
</div>
</form>
<script>
var freqArr=new Array();
<%int corse =0;
for (MasFrequency hmc : frequeList) {
	%>
	freqArr[<%=corse%>] = new Array();
	freqArr[<%=corse%>][0] = <%=hmc.getId()%>;
	freqArr[<%=corse%>][1] = '<%=hmc.getFrequencyName()%>';	
	<%corse++;}%>
function getFrequencyValue(feqValue,inc){
	var feqQty;
	<%
	if(frequeList.size()>0){	
		for(MasFrequency masFrequency :frequeList){
	%>
	 if(feqValue == '<%=masFrequency.getId()%>'){
		 feqQty = '<%=masFrequency.getFrequencyCount()%>'
		 if(feqQty>0){
			 var col=document.getElementById('col' + inc);
			 var row=col.parentNode;
			 createDosageText(row,feqQty,inc);
		 }
	  }

	<%}
	}%>
	if(document.getElementById('frequencyValue' + inc)!=null){
	 document.getElementById('frequencyValue'+inc).value = feqQty;
	}
}

function createDosageText(row,freqCount,inc){
	var tbl = document.getElementById('gridForPrescription');
	//var row = tbl.rows[row.rowIndex];
	var cell = row.cells[2];
	while (cell.hasChildNodes()) {
	    cell.removeChild(cell.lastChild);
	}
	document.getElementById('dosageCount'+inc).value=0;
	
	for(i=0;i<freqCount;i++){
	var e1 = document.createElement('input');
	e1.className = "allownumericwithdecimal textYellow opdTextBoxTSmall ";
	e1.id="dos"+i+inc;
	e1.size=10;
	e1.oninput = function() {
		fillDosageAndCount(inc);getFillValue(inc);
	};
	e1.onblur = function() {
		fillDosageAndCount(inc);getFillValue(inc);
	};
	e1.onkeypress = function() {
		return isNumberKey(event);
	};
	cell.appendChild(e1);
     }
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'dosage' + inc;
	e1.id = 'dosage' + inc;
	e1.readOnly =true;
	e1.className = "textYellow opdTextBoxTSmall";
	cell.appendChild(e1);
	
	/*var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'dosageCount' + inc;
	e1.id = 'dosageCount' + inc;
	e1.className = "textYellow opdTextBoxTSmall";
	cell.appendChild(e1);*/
	
}

function fillDosageAndCount(inc){
	var freqCount= document.getElementById('frequencyValue'+inc).value;	
	var dosageCount=0.0;
	var dosage="";
	for(i=0;i<freqCount;i++){
		var dos=0;
		if(document.getElementById('dos'+i+inc)!=null && document.getElementById('dos'+i+inc).value!=""){
			dos=parseFloat(document.getElementById('dos'+i+inc).value);
		}
		dosageCount=dosageCount+dos;
		if(i==0){
		dosage=dos;
		}else{
		dosage=dosage+"-"+dos;
		}
	}
	document.getElementById('dosageCount'+inc).value=dosageCount;
	document.getElementById('dosage'+inc).value=dosage;
}

function getFillValue(inc){
	var freq=0.0,noOfDays=0.0,dosage=0.0;
	if(document.getElementById('frequencyValue' + inc)!=null){
		freq= parseFloat(document.getElementById('frequencyValue'+inc).value);
	}
	if(document.getElementById('duration' + inc)!=null && document.getElementById('duration'+inc).value!=""){
		noOfDays= parseFloat(document.getElementById('duration'+inc).value);
		}
	if(document.getElementById('dosageCount' + inc)!=null && document.getElementById('dosageCount'+inc).value!=""){
		dosage=  parseFloat(document.getElementById('dosageCount'+inc).value);
	}
	var total =0.0;
	 // total=parseFloat(freq * noOfDays * dosage);
	  total=parseFloat(noOfDays * dosage);
  document.getElementById('total'+inc).value=total;
}

function addRow(){

	var tbl = document.getElementById('gridForPrescription');
	var hdbTabIndex = parseInt(document.getElementById('hdbIndex').value)+1;
	document.getElementById('hdbIndex').value = hdbTabIndex;
	var lastRow = tbl.rows.length;
	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdb');
	iteration = parseInt(hdb.value);
	hdb.value = iteration+1;
	// document.getElementById('pulse').value=hdb.value;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadio' + iteration;
	e1.id = 'itemRadio' + iteration;
	e1.className = 'radioCheck';
	e1.tabIndex = iteration + "1";
	e1.onchange = function() {
		checkPrescriptionCheck(iteration);
	};
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(1);
	cellRight1.id = 'col' + iteration;	
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'frequencyValue' + iteration;
	e1.id = 'frequencyValue' + iteration;
	cellRight1.appendChild(e1);
	
	var e1 = document.createElement('select');
	e1.type = 'hidden';
	e1.name = 'frequency' + iteration;
	e1.id = 'frequency' + iteration;
	e1.style='width: 90px; background: #FFFF99';
	e1.tabIndex = hdbTabIndex + "2";
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < freqArr.length; i++) {
		e1.options[i + 1] = new Option(freqArr[i][1], freqArr[i][0]);
	}
	e1.onchange = function(event) {
		getFrequencyValue(this.value,iteration);getFillValue(iteration);
	};
	cellRight1.appendChild(e1);
	
	cellRight1.appendChild(e1);
	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'dosage' + iteration;
	e1.id = 'dosage' + iteration;
	e1.readOnly =true;
	e1.className = "textYellow opdTextBoxTSmall";
	e1.size=10;
	e1.value='1';
	e1.tabIndex = hdbTabIndex + "3";
	e1.onblur = function(event) {
		getFillValue(iteration);
	};
	e1.oninput = function(event) {
		getFillValue(iteration);
	};
	e1.onkeypress = function() {
		return isNumberKey(event);
	};
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'dosageCount' + iteration;
	e1.id = 'dosageCount' + iteration;
	e1.readOnly =true;
	e1.className = "textYellow opdTextBoxTSmall";
	e1.size=10;
	e1.tabIndex = hdbTabIndex + "4";
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'duration' + iteration;
	e1.id = 'duration' + iteration;
	e1.className = "textYellow opdTextBoxTSmall";
	e1.size=10;
	e1.value='1';
	e1.tabIndex = hdbTabIndex + "5";
	e1.onblur = function(event) {
		getFillValue(iteration);
	};
	e1.oninput = function(event) {
		getFillValue(iteration);
	};
	e1.onkeypress = function() {
		return isNumberKey(event);
	};
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'total' + iteration;
	e1.id = 'total' + iteration;
	e1.className = "textYellow opdTextBoxTSmall";
	e1.size=10;
	e1.tabIndex = hdbTabIndex + "6";
	e1.onkeypress = function() {
		return isNumberKey(event);
	};
	cellRight1.appendChild(e1);
}

function removeRow() {
	var tbl = document.getElementById('gridForPrescription');
	var lastRow = tbl.rows.length;
	var hdb= document.getElementById('hdb');
	var radio = "itemRadio";		
		
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	if (confirm("Do you want to delete !")) {
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById(radio + i) != null
					&& (typeof document.getElementById(radio + i).checked) != 'undefined'
					&& document.getElementById(radio + i).checked) {
				totalSelected = totalSelected + 1;
			}
		}

		if (totalSelected == 0) {
			alert('Please select atleast 1 row to delete');
		}
		/*
		 * else if(lastRow==2 || lastRow==(totalSelected+1)) { alert('You can
		 * not delete all Row.'); } else if (lastRow > 2){
		 */
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById(radio + i) != null
					&& (typeof document.getElementById(radio + i).checked) != 'undefined'
					&& document.getElementById(radio + i).checked) {
				var deleteRow = document.getElementById(radio + i).parentNode.parentNode;
				document.getElementById(radio + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}

	}
}
	
function validateTaperedForm(){
	var totRow= document.getElementById('hdb').value;
	var total=0.0;
	var dosageCount=0;
	var dosage="";
	for(i=0;i<=totRow;i++){
		var subTot=0,subDos=0;
		var subDosage="";
		if(document.getElementById('total'+i)!=null && document.getElementById('total'+i).value!=""){
			subTot=parseFloat(document.getElementById('total'+i).value);
		}
		if(document.getElementById('dosageCount'+i)!=null && document.getElementById('dosageCount'+i).value!=""){
			subDos=parseFloat(document.getElementById('dosageCount'+i).value);
		}
		if(document.getElementById('dosage'+i)!=null && document.getElementById('dosage'+i).value!=""){
			subDosage=document.getElementById('dosage'+i).value;
		}
		total=parseFloat(total+subTot);
		dosageCount=dosageCount+subDos;
		if(i==0){
			dosage=dosage+subDosage;
		}else{
			dosage=dosage+";"+subDosage;
		}
		
	}
	document.getElementById('totalCount').value=total;
	window.opener.document.getElementById("totaltreatment"+<%=row%>).value=parseFloat(total);
	window.opener.document.getElementById("totaltreatment"+<%=row%>).readOnly=true;
	window.opener.document.getElementById("dosagetreatment"+<%=row%>).value="";
	window.opener.document.getElementById("dosagetreatment"+<%=row%>).readOnly=true;
	window.opener.document.getElementById("dosagetreatment"+<%=row%>).removeAttribute('validate');
	
	window.opener.document.getElementById("nomenclaturetreatment"+<%=row%>).readOnly=true;
	window.opener.document.getElementById("nomenclaturetreatment"+<%=row%>).removeAttribute('onblur');
	window.opener.document.getElementById("nomenclaturetreatment"+<%=row%>).setAttribute('onblur','editTaperedMedicine('+<%=row%>+','+<%=itemId%>+')');
	
	window.opener.document.getElementById("routetreatment"+<%=row%>).disabled= true;
	window.opener.document.getElementById("routetreatment"+<%=row%>).removeAttribute('validate');
	
	window.opener.document.getElementById("unittreatment"+<%=row%>).readOnly=true;
	window.opener.document.getElementById("unittreatment"+<%=row%>).value="";
	window.opener.document.getElementById("unittreatment"+<%=row%>).removeAttribute('validate');
	
	window.opener.document.getElementById("frequencytreatment"+<%=row%>).disabled= true;
	window.opener.document.getElementById("frequencytreatment"+<%=row%>).removeAttribute('validate');
	
	window.opener.document.getElementById("noOfDaystreatment"+<%=row%>).readOnly=true;
	window.opener.document.getElementById("noOfDaystreatment"+<%=row%>).removeAttribute('onblur');
	window.opener.document.getElementById("noOfDaystreatment"+<%=row%>).removeAttribute('validate');	
	window.opener.document.getElementById("noOfDaystreatment"+<%=row%>).value="";
	
	if(window.opener.document.getElementById("instructiontreatment"+<%=row%>)!=null){
	window.opener.document.getElementById("instructiontreatment"+<%=row%>).disabled= true;
	}
	if(window.opener.document.getElementById("instructiontreatment"+<%=row%>)!=null){
		window.opener.document.getElementById("instructiontreatment"+<%=row%>).disabled= true;
	}
	if(window.opener.document.getElementById("unitLable"+<%=row%>)!=null){
		window.opener.document.getElementById("unitLable"+<%=row%>).readOnly=true;
	}
	if(window.opener.document.getElementById("spslinstructiontreatment"+<%=row%>)!=null){
		window.opener.document.getElementById("spslinstructiontreatment"+<%=row%>).readOnly=true;
		window.opener.document.getElementById("spslinstructiontreatment"+<%=row%>).value=dosage;
	}
	if(window.opener.document.getElementById("itemRadiotreatment"+<%=row%>)!=null){
		window.opener.document.getElementById("itemRadiotreatment"+<%=row%>).disabled= true;  
	}	
	if(window.opener.document.getElementById("itemBatchNoId"+<%=row%>)!=null){
		window.opener.document.getElementById("itemBatchNoId"+<%=row%>).disabled= true;  
	}
	createTaperedTale(totRow);
	
	var source = window.opener.document.getElementById('taperedMedicne');
	var destination = window.opener.document.getElementById('taperedMedicne1');
	var copy = source.cloneNode(true);
	copy.setAttribute('id', 'taperedMedicne1');
	destination.parentNode.replaceChild(copy, destination);
	
	window.self.close();
}

function createTaperedTale(rowCount){
	var tbl = window.opener.document.getElementById('taperedMedicne');
	var destination = window.opener.document.getElementById('taperedMedicne1');
	  var drowCount = destination.rows.length;
    for (var i = drowCount - 1; i > 0; i--) {
  	  destination.deleteRow(i);
    }
	//alert("test1 "+rowCount);
	for(var iteration=1;iteration<rowCount+1;iteration++){
		var lastRow = tbl.rows.length;
		var row = tbl.insertRow(lastRow);
	//var row = tbl.insertRow(iteration);
	// document.getElementById('pulse').value=hdb.value;
	//alert("test1 "+iteration);
	var iterate=iteration-1;
	//alert("test1 "+iterate);
	if(document.getElementById("frequency"+iterate)!=null){
	var sel = document.getElementById("frequency"+iterate);
	var frequency=sel.options[sel.selectedIndex].value; 
    var dosage=document.getElementById("dosage"+iterate).value;
    var dosageCount=document.getElementById("dosageCount"+iterate).value;
    var duration=document.getElementById("duration"+iterate).value;
    var total=document.getElementById("total"+iterate).value;
   // alert("test2 "+iteration);
	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'taperedItemId' +<%=row%>+'_'+iteration;
	e1.id = 'taperedItemId' + <%=row%>+'_'+iteration;
	e1.value='<%=itemId%>';
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'taperedFrequency' + <%=row%>+'_'+iteration;
	e1.id = 'taperedFrequency' + <%=row%>+'_'+iteration;
	e1.value=frequency;
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'taperedDosage' + <%=row%>+'_'+iteration;
	e1.id = 'taperedDosage' + <%=row%>+'_'+iteration;
	e1.value=dosage;
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'taperedDosageCount' + <%=row%>+'_'+iteration;
	e1.id = 'taperedDosageCount' + <%=row%>+'_'+iteration;
	e1.value=dosageCount;
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'taperedDuration' + <%=row%>+'_'+iteration;
	e1.id = 'taperedDuration' + <%=row%>+'_'+iteration;
	e1.value=duration;
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'total' + <%=row%>+'_'+iteration;
	e1.id = 'total' + <%=row%>+'_'+iteration;
	e1.value=total;
	cellRight1.appendChild(e1);
	}
	}
	window.opener.document.getElementById("taperedMedicineHdb").value=rowCount;
	window.opener.document.getElementById("taperedMedicineHdb1").value=rowCount;
}

function UpdateTaperedForm(){
	var rowCount = document.getElementById('hdb').value;
	var source = window.opener.document.getElementById('taperedMedicne');
	var destination = window.opener.document.getElementById('taperedMedicne1');
	  var rowCount = destination.rows.length;
      for (var i = rowCount - 1; i > 0; i--) {
    	  destination.deleteRow(i);
      }
      
	for(var i=1;i<=rowCount;i++){
		var iterate=i-1;
		if(document.getElementById("frequency"+iterate)!=null){
		var sel = document.getElementById("frequency"+iterate);
		var frequency=sel.options[sel.selectedIndex].value; //alert("freq "+frequency +"i"+iterate);
	    var dosage=document.getElementById("dosage"+iterate).value;//alert("dosage "+dosage +"i"+iterate);
	    var dosageCount=document.getElementById("dosageCount"+iterate).value;
	    var duration=document.getElementById("duration"+iterate).value;
	    var total=document.getElementById("total"+iterate).value;
	    
	    window.opener.document.getElementById('taperedItemId' + <%=row%>+'_'+i).value='<%=itemId%>';
	    window.opener.document.getElementById('taperedFrequency' + <%=row%>+'_'+i).value=frequency;
	    window.opener.document.getElementById('taperedDosage' + <%=row%>+'_'+i).value=dosage;
	    window.opener.document.getElementById('taperedDosageCount' + <%=row%>+'_'+i).value=dosageCount;
	    window.opener.document.getElementById('taperedDuration' + <%=row%>+'_'+i).value=duration;
	    window.opener.document.getElementById('total' + <%=row%>+'_'+i).value=total;
		}
	}
	
	var copy = source.cloneNode(true);
	copy.setAttribute('id', 'taperedMedicne1');
	destination.parentNode.replaceChild(copy, destination);
	copyTaperedDataToParent();
	window.self.close();
}

function cancelFunction(update){
	if(update=="N"){
	window.opener.document.getElementById("nomenclaturetreatment"+<%=row%>).value="";
	window.opener.document.getElementById("tapered"+<%=row%>).value="";
	}
	window.self.close();
}
function copyTaperedDataToParent(){
	var totRow= document.getElementById('hdb').value;
	var total=0.0;
	var dosageCount=0;
	var dosage="";
	for(i=0;i<=totRow;i++){
		var subTot=0,subDos=0;
		var subDosage="";
		if(document.getElementById('total'+i)!=null && document.getElementById('total'+i).value!=""){
			subTot=parseFloat(document.getElementById('total'+i).value);
		}
		if(document.getElementById('dosageCount'+i)!=null && document.getElementById('dosageCount'+i).value!=""){
			subDos=parseFloat(document.getElementById('dosageCount'+i).value);
		}
		if(document.getElementById('dosage'+i)!=null && document.getElementById('dosage'+i).value!=""){
			subDosage=document.getElementById('dosage'+i).value;
		}
		total=parseFloat(total+subTot);
		dosageCount=dosageCount+subDos;
		if(i==0){
			dosage=dosage+subDosage;
		}else{
			dosage=dosage+";"+subDosage;
		}
		
	}
	document.getElementById('totalCount').value=total;
	window.opener.document.getElementById("totaltreatment"+<%=row%>).value=parseFloat(total);
	window.opener.document.getElementById("totaltreatment"+<%=row%>).readOnly=true;
	window.opener.document.getElementById("dosagetreatment"+<%=row%>).value="";
	window.opener.document.getElementById("dosagetreatment"+<%=row%>).readOnly=true;
	window.opener.document.getElementById("dosagetreatment"+<%=row%>).removeAttribute('validate');
	
	window.opener.document.getElementById("nomenclaturetreatment"+<%=row%>).readOnly=true;
	window.opener.document.getElementById("nomenclaturetreatment"+<%=row%>).removeAttribute('onblur');
	window.opener.document.getElementById("nomenclaturetreatment"+<%=row%>).setAttribute('onblur','editTaperedMedicine('+<%=row%>+','+<%=itemId%>+')');
	
	window.opener.document.getElementById("routetreatment"+<%=row%>).disabled= true;
	window.opener.document.getElementById("routetreatment"+<%=row%>).removeAttribute('validate');
	
	window.opener.document.getElementById("unittreatment"+<%=row%>).readOnly=true;
	window.opener.document.getElementById("unittreatment"+<%=row%>).value="";
	window.opener.document.getElementById("unittreatment"+<%=row%>).removeAttribute('validate');
	
	window.opener.document.getElementById("frequencytreatment"+<%=row%>).disabled= true;
	window.opener.document.getElementById("frequencytreatment"+<%=row%>).removeAttribute('validate');
	
	window.opener.document.getElementById("noOfDaystreatment"+<%=row%>).readOnly=true;
	window.opener.document.getElementById("noOfDaystreatment"+<%=row%>).removeAttribute('onblur');
	window.opener.document.getElementById("noOfDaystreatment"+<%=row%>).removeAttribute('validate');	
	window.opener.document.getElementById("noOfDaystreatment"+<%=row%>).value="";
	
	if(window.opener.document.getElementById("instructiontreatment"+<%=row%>)!=null){
	window.opener.document.getElementById("instructiontreatment"+<%=row%>).disabled= true;
	}
	if(window.opener.document.getElementById("instructiontreatment"+<%=row%>)!=null){
		window.opener.document.getElementById("instructiontreatment"+<%=row%>).disabled= true;
	}
	if(window.opener.document.getElementById("unitLable"+<%=row%>)!=null){
		window.opener.document.getElementById("unitLable"+<%=row%>).readOnly=true;
	}
	if(window.opener.document.getElementById("spslinstructiontreatment"+<%=row%>)!=null){
		window.opener.document.getElementById("spslinstructiontreatment"+<%=row%>).readOnly=true;
		window.opener.document.getElementById("spslinstructiontreatment"+<%=row%>).value=dosage;
	}
	if(window.opener.document.getElementById("itemRadiotreatment"+<%=row%>)!=null){
		window.opener.document.getElementById("itemRadiotreatment"+<%=row%>).disabled= true;  
	}	
	if(window.opener.document.getElementById("itemBatchNoId"+<%=row%>)!=null){
		window.opener.document.getElementById("itemBatchNoId"+<%=row%>).disabled= true;  
	}
}

function isNumberKey(evt)
{
    var charCode = (evt.which) ? evt.which : event.keyCode

    if (charCode == 46)
    {
        var inputValue = $("#inputfield").val()
        if (inputValue.indexOf('.') < 1)
        {
            return true;
        }
        return false;
    }
    if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57))
    {
        return false;
    }
    return true;
}

function validateFormEmpty(){
	var totRow= document.getElementById('hdb').value;
	var msg="";
	var result=false;
	var c=0;
	for(i=0;i<totRow;i++){
		var e = document.getElementById('frequency'+i);
		var freqVal = e.options[e.selectedIndex].value;
		if(freqVal==0){
			msg=msg+"\nPlease select frequency";
			c++;
		}
		if(document.getElementById('dosageCount'+i).value=="" || document.getElementById('dosageCount'+i).value==0){
			msg=msg+"\nDosage must not be empty";
			c++;
		}
		if(document.getElementById('duration'+i).value=="" || document.getElementById('duration'+i).value==0){
			msg=msg+"\nDuration must not be empty";
			c++;
		}	
		if(document.getElementById('total'+i).value=="" || document.getElementById('total'+i).value==0){
			msg=msg+"\nTotal must not be empty";
			c++;
		}
		if(c>0){
			break;
		}
	}
	if(c>0){
		alert(msg);
		return false;
	}else{
	   return true;
	}
}
</script>