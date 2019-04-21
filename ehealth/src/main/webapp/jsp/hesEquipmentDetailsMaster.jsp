<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.HesEquipmentMaster"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>


<%@page import="jkt.hms.util.RequestConstants"%><script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/acnik.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>

<script type="text/javascript" language="javascript">
<%
Calendar calendar = Calendar.getInstance();
String month = String.valueOf((calendar.get(Calendar.MONTH))+1);
String date = String.valueOf(calendar.get(Calendar.DATE));
int year = calendar.get(calendar.YEAR);

	if(month.length() < 2)
	{
		month = "0" + month;
	}
	if(date.length() < 2)
	{
		date = "0" + date;
	}
%>
serverdate = '<%=date+"/"+month+"/"+year%>'
</script>

<script language="javascript">


function var_trim(str)
{
    if(!str || typeof str != 'string')
        return null;

    return str.replace(/^[\s]+/,'').replace(/[\s]+$/,'').replace(/[\s]{2,}/,' ');
}

function checkQuantityValidate(val,inc)
{
	var qtyUsed = parseInt(val);
		
	if(qtyUsed == 0 || var_trim(qtyUsed) == '' || var_trim(qtyUsed) == ' ')
	{
		alert("Qty used should be greater than 0");
		document.getElementById('Quantity'+inc).value = '';
		alert(('Quantity'+inc).value);
		document.getElementById('Quantity'+inc).focus();
	}
	
	else if (isNaN(qtyUsed))
	{
		alert("Please enter Quantity in numeric.");
		document.getElementById('Quantity'+inc).value = '';
		document.getElementById('Quantity'+inc).focus();
	}
}

/*function selectDeselectWarrentyDate(){

	var val = 1;
	if( document.submitEquipmentForm.yes.checked == true )
	{
	val = document.submitEquipmentForm.yes.value;
	if(val=='2')
	{
	document.submitEquipmentForm.No.disabled=false;
	document.submitEquipmentForm.No.focus();
	} 
	else
	{
		document.submitEquipmentForm.No.disabled=true;
	}
	}
	}
*/		

function valueChange()
{
var ret_value=document.getElementById("returnValue").value;
var v=document.getElementById("hospidataId").style.display;

if(ret_value=="false")
{

document.getElementById("hospidataId").style.display= 'inline'

var v1=document.getElementById("hospidataId").style.display;

document.getElementById("returnValue").value="true";

}
if(ret_value=="true")
{
document.getElementById("hospidataId").style.display='none'
document.getElementById("returnValue").value="false";
}

}

</script>

<%
	Map<String ,Object> map = new HashMap<String ,Object>();
	String entryNo = "";
	String userName = "";
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	
	if(request.getAttribute("map")!=null)
	{
		map = (Map<String ,Object>) request.getAttribute("map");
	}
	if (map.get("num")!=null)
		entryNo = (String)map.get("num").toString();
	   
	   if (map.get("departmentList")!= null){
			departmentList = (List<MasDepartment>)map.get("departmentList");
		}
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<HesEquipmentMaster> hesEquipmentList = new ArrayList<HesEquipmentMaster>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");

	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
%>

<form name="searchEquipment" method="post">

<div class="titleBg">
<h2>Equipment Entry Master</h2>
</div>
<%--------------- Start of Tool Panel ---------------------------%>
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>
<div class="clear"></div>
<%--------------- End of Tool Panel ---------------------------%>

<!-- thread search menu -->
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<div class="clear"></div>
<%--------------- Start of Search Panel using text box equipment no master ---------------------------%>



<label><span>*</span> Entry No</label>
	<td><input id="entryIdTemp" type="text" tabindex="1" size="45" value="" name="entryIdTemp" );"/>
			<div id="ac2update" class="autocomplete" style="display: none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
				new Ajax.Autocompleter('entryIdTemp','ac2update','/hms/hms/hes?method=getEntryListForEquipment',{parameters: 'requiredField=entryIdTemp&searchEntryNo=<%=entryNo%>'});
			</script>
				</td>
<input type="image" name="button" class="button"	onClick="submitForm('searchEquipment','/hms/hms/hes?method=searchEquipmentEntry');" />
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<%-------------------- End of Search Panel ---------------------------%>

<form name="submitEquipmentForm" method="post">

<!--Block One Starts-->
<div class="Block">
<label><span>*</span> Entry No.</label>
<input type="text" id="entryNo" name="<%=RequestConstants.ENTRY_NO_ID %>" value="<%=entryNo%>"  tabindex=1 readonly="readonly" />

<label><span>*</span> Serial No.</label>
<input type="text" id="SerialNo" name="SerialNo" value=""  />

<label>Equipment Name</label>
<input type="text" id="EquipmentName" name="EquipmentName" value=""  />
<div class="clear"></div>
<label>Model Name</label>
<input type="text" id="ModelName" name="ModelName" value="" />

<label>Make</label>
<input type="text" id="Make" name="Make" value="" />

<label>Contact Number Of Sales/Service Persons</label>
<input type="text" id="ContactNoSalesService" name="ContactNoSalesService" value=""  />
<div class ="clear"></div>

<label><span>*</span>Department Name</label>
<select name="deptId" id="deptId" validate="Department Name,String,yes" >
	<option value="0">-Select Department-</option>
<%
		for (MasDepartment mastDepartment : departmentList )
		{
%>
			<option value=<%=mastDepartment.getId()%>><%=mastDepartment.getDepartmentName()%></option>
<%
		}
%>
</select>
<label>Date Of Installation:</label>
	 <input type="text" name="<%=ON_DATE%>"
	value="<%=currentDate %>" class="date" maxlength="30" tabindex=1 /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.submitEquipmentForm.<%= ON_DATE%>,event);" />



<label style="margin-left: 33px;">Technical Specification</label>
<textarea id="TechnicalSpecifications" rows="8" name="TechnicalSpecifications" value="" ></textarea>

<div class="clear"></div>

<label>Warranty Date:</label>

<input type="checkbox" name="warrantyStEnDate" class="radio" id="returnValue" value="false"  onchange="valueChange()"/>
<div id=hospidataId style="display: none">
<label class="auto">Warrenty Start Date:</label> <input    type="text" name="<%=FROM_DATE%>"  class="date" id="doa"    MAXLENGTH="30" validate="Pick a from date,date,no" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="javascript:setdate('<%=FROM_DATE%>',document.submitEquipmentForm.<%= FROM_DATE%>,event);"   validate="Pick a date"  />

<label>Warranty End Date:</label> <input    type="text" name="<%=TO_DATE%>" class="date" id="dod"    MAXLENGTH="30" validate="Pick a from date,date,no"  />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="javascript:setdate('<%=TO_DATE%>',document.submitEquipmentForm.<%= TO_DATE%>,event);" validate="Pick a date"  />
</div>
<div class ="clear"></div>

<label>Warranty Details</label>
<textarea id="WarrantyDetails" rows="8" name="WarrantyDetails" value=""  > </textarea>

</div>
<!--Block one Ends-->

<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<h4>Equipment Assessories Entry</h4>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" />
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" />
<div class="division"></div>
<div class="tableHolderAuto">
<table border="0" cellspacing="0" cellpadding="0" id="chargeDetails">
	
	<tr>
		<th scope="col"></th>
		<th scope="col">Assessory Name</th>
		<th scope="col">Model No.</th>
		<th scope="col">Serial No.</th>
		<th scope="col">Quantity</th>
		<th scope="col">Remarks</th>
		
	</tr>
	
	<%
		int inc = 1;
	%>
		<td><input type="checkbox" value="<%=inc%>" name="selectedChrage" class="radioCheck" /></td>
		<td width="10%"><input id="AssessoryName<%=inc%>" name="AssessoryName<%=inc%>" type="text" size="25" MAXLENGTH="200" /></td>
		<td width="10%"><input id="ModelNo<%=inc%>" name="ModelNo<%=inc%>" type="text" size="25" MAXLENGTH="25" /></td>
		<td width="10%"><input id="Serial_No<%=inc%>" name="Serial_No<%=inc%>" type="text" size="25" MAXLENGTH="25" /></td>
		<td width="10%"><input id="Quantity<%=inc%>" name="Quantity<%=inc%>" type="text" size="25" MAXLENGTH="250"  onblur="checkQuantityValidate(this.value,'<%=inc %>')"/></td>
		<td width="10%"><textarea id="Remarks<%=inc%>" name="Remarks<%=inc%>" size="40" MAXLENGTH="250" ></textarea></td>
		
		
</table>
</div>
<input type="hidden" value="<%=inc%>" name="hiddenValueCharge"	id="hiddenValueCharge" />
<input type="hidden" id="counter" name="counter" value="<%=inc %>" />
<!--Block Two Ends-->
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" name="sss" align="right" class="button" value="Submit"
 onclick="submitForm('submitEquipmentForm','/hms/hms/hes?method=submitEquipmentEntry');" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<!--Bottom labels starts-->

<div class="bottom">
<input type="hidden" name="lastChgBy" value="<%=userName%>" />
<input type="hidden" name="lastChgDate" value="<%=currentDate%>" /> 
<input type="hidden" name="lastChgTime" value="<%=currentTime%>" /> 
<label>Changed By</label> <label class="value"><%=userName%> </label>
<label>Changed Date</label> <label class="value"><%=currentDate%></label> 
<label>Changed Time</label> <label class="value"><%=currentTime%></label>
<div class="clear"></div>

	
</div>
<script type="text/javascript">

	function addRow()
	{
		var tbl = document.getElementById('chargeDetails');
		var lastRow = tbl.rows.length;
		var row = tbl.insertRow(lastRow);
		var hdb = document.getElementById('counter');
		var iteration = parseInt(hdb.value)+1;
		hdb.value = iteration;

       	var cell0 = row.insertCell(0);
		var e0 = document.createElement('input');
		e0.type = 'checkbox';
		e0.name='selectedChrage';
		//e0.id='selectedChrage'+(iteration);
		e0.className = 'radioCheck';
		e0.value=(iteration);
		cell0.appendChild(e0);
		
		var cell1 = row.insertCell(1);
		var e1 = document.createElement('input');
		e1.type="text";
		e1.name = 'AssessoryName'+(iteration);
		e1.id = 'AssessoryName'+(iteration);
		e1.size="25";
		e1.maxlength="100";
		cell1.appendChild(e1);
       
		var cell3 = row.insertCell(2);
		var e3 = document.createElement('input');
		e3.type = 'text';
		e3.name='ModelNo'+(iteration);
		e3.id = 'ModelNo'+(iteration);
		e3.size="25";
		e3.maxLength="25";
		cell3.appendChild(e3);
		
		var cell4 = row.insertCell(3);
		var e4 = document.createElement('input');
		e4.type = 'text';
		e4.name='Serial_No'+(iteration);
		e4.id='Serial_No'+(iteration);
		e4.size="25";
		cell4.appendChild(e4);
        
        var cell5= row.insertCell(4);
        var e5 = document.createElement('input');
        e5.type = 'text';
        e5.id='Quantity'+(iteration);
        e5.name='Quantity'+(iteration);
        e5.size="25";
        cell5.appendChild(e5);


        var cell6= row.insertCell(5);
        var e6 = document.createElement('textarea');
        e6.name='Remarks'+(iteration);
		e6.id='Remarks'+(iteration);
        //e6.setAttribute(e6.name,'Remarks'+(iteration));
        e6.size = "40";
        e6.maxLength="250";
        cell6.appendChild(e6);

        
       /* var cell6= row.insertCell(5);
        var e6 = document.createElement('textarea');
        e6.name='Remarks';
        e6.type = 'textarea'
        e6.setAttribute(e6.name,'Remarks'+(iteration));
        //e6.id='Remarks'+(iteration);
        e6.maxLength="500";
        cell6.appendChild(e6);*/
	}
	
	function removeRow()
	{
		var tbl = document.getElementById('chargeDetails');
		 var tblRows  = tbl.getElementsByTagName("tr");
		
	  	if(tblRows.length-2==0){
	         	alert("Can not delete all rows")
	         	return false;
	     }
		         
	  	for(abc=0;abc<document.getElementsByName('selectedChrage').length;abc++)
		{
			if (document.getElementsByName('selectedChrage')[abc].checked == true)
			{
			  	tbl.deleteRow(abc+1);
			}
		}
	}

	
	
</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script><input type="hidden" name="rows" id="rr" value="1" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<!--Bottom labels ends--> <!--main content placeholder ends here--></form>
<div class="clear"></div>
<div class="paddingTop40"></div>
