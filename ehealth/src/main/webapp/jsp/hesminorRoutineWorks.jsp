<%@page import="jkt.hms.masters.business.HesMinorRoutineWork"%>
<%@page import="jkt.hms.masters.business.HesWorkParticularMaster"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.CssdMaterialStockM"%>
<%@page import="jkt.hms.masters.business.CssdMaterialStockT"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
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

function onBlurMaterialName(val,inc)
{
	var index1 = val.lastIndexOf("[");
	var index2 = val.lastIndexOf("]");
	index1++;
	var materialCode = val.substring(index1,index2);
	document.getElementById('materialCode'+inc).value = materialCode;

	for(i=1;i<inc;i++)
	{
		if(inc != 1)
		{
			if(document.getElementById('materialName'+i).value == val)
			{
				alert("Item Name already selected...!")
				document.getElementById('materialName'+inc).value=""
				document.getElementById('materialCode'+inc).value=""
				var e=eval(document.getElementById('materialName'+inc));
				e.focus();
				return false;
			}
		}
  	}
	var variable = materialCode;
	variable = variable.replace("&","$");
	if(variable.trim()!='')
	{
		ajaxMinorWork('purchaseGrid','/hms/hms/hes?method=getItemClosingStock&materialCode='+variable,inc);
	}
}

function var_trim(str)
{
    if(!str || typeof str != 'string')
        return null;

    return str.replace(/^[\s]+/,'').replace(/[\s]+$/,'').replace(/[\s]{2,}/,' ');
}

function checkMaterialQty(val,inc)
{
	var cStock = parseInt(document.getElementById('closingStock'+inc).value);
	var qtyUsed = parseInt(val);

	if(qtyUsed == 0 || var_trim(qtyUsed) == '' || var_trim(qtyUsed) == ' ')
	{
		alert("Qty used should be greater than 0");
		document.getElementById('qty'+inc).value = '';
		document.getElementById('qty'+inc).focus();
	}
	else if(qtyUsed > cStock)
	{
		alert("You cannot have quantity greater than closing stock");
		document.getElementById('qty'+inc).value = '';
		document.getElementById('qty'+inc).focus();
	}
	else if (isNaN(qtyUsed))
	{
		alert("Quantity should be numeric!...");
	}
}

function ajaxMinorWork(formName,action,inc)
{
	var xmlHttp;
	try
	{
		// Firefox, Opera 8.0+, Safari
		xmlHttp=new XMLHttpRequest();
	}
	catch(e)
	{
		// Internet Explorer
		try
		{
			xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		}
		catch(e)
		{
			try
			{
				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			catch(e)
			{
				alert("Your browser does not support AJAX!");
				return false;
			}
		}
   }

	xmlHttp.onreadystatechange=function()
	{
      if(xmlHttp.readyState == 4)
      {
    	  var items = xmlHttp.responseXML.getElementsByTagName("items")[0];
    	  for (loop = 0; loop < items.childNodes.length; loop++)
    	  {
    		  var item = items.childNodes[loop];
  	   	      var id  = item.getElementsByTagName("closingStock")[0];
		      var item_id = item.getElementsByTagName("itemId")[0];

  	   	      var cStock = parseInt(id.childNodes[0].nodeValue);
  	   	      var ItemId = item_id.childNodes[0].nodeValue;
  	   	      document.getElementById('closingStock'+inc).value = cStock
  	   	 	  document.getElementById('ItemID'+inc).value = ItemId
    	  }
      }
	}
	var url=action;
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
    xmlHttp.open("GET",url,true);
    xmlHttp.send(null);
}

function addAndRefreshGrid()
{
	var code = document.getElementById('materialCode').value;
	var qty = document.getElementById('qty').value;
	var approvedBy = document.getElementById('approvedBy').value;

	if (code=="")
	{
		alert("Material Code is Mandatory!... Pl Check your Inputs!....");
		return;
	}

 	if (qty=="")
 	{
 		alert("Quantity is Mandatory!... Pl Check your Inputs!....");
 		return;
 	}

  	if (approvedBy==0)
  	{
    	alert("Approved By is Mandatory!... Pl Check your Inputs!....");
		return;
  	}

	if (isNaN(document.getElementById('qty').value))
	{
		alert("Quantity should be numeric!...");
		return;
	}

	submitProtoAjax('materialStockForm','/hms/hms/hes?method=addAndRefreshGrid');
}

</script>

<%
	Map<String ,Object> map = new HashMap<String ,Object>();
	String entryNo = "";
	String userName = "";

	if(request.getAttribute("map") != null)
	{
		map = (Map<String ,Object>) request.getAttribute("map");
	}

	if (map.get("entryNo")!=null)
		entryNo = map.get("entryNo").toString();

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");

	List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
	List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
	List<HesWorkParticularMaster> workParticularList = new ArrayList<HesWorkParticularMaster>();
	List<HesMinorRoutineWork> entryNoList = new ArrayList<HesMinorRoutineWork>();
	String Entry_data = "";

	if (map.get("hesWorkList")!= null)
		workParticularList = (List<HesWorkParticularMaster>)map.get("hesWorkList");

	if (map.get("hesEntryList")!= null)
		entryNoList = (List<HesMinorRoutineWork>)map.get("hesEntryList");

	if (map.get("masDepartmentList")!= null)
		masDepartmentList = (List<MasDepartment>)map.get("masDepartmentList");

	if (map.get("masEmployeeList")!= null)
		masEmployeeList = (List<MasEmployee>)map.get("masEmployeeList");

	if (map.get("EntryNo")!= null)
	{
		Entry_data = (String)map.get("EntryNo");
	}

	String nameItem = "nameItem";
	if(session.getAttribute("userName") != null)
	{
		userName = (String)session.getAttribute("userName");
	}

	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
%>

<!--main content placeholder starts here-->
<form name="minorRoutineForm" method="post"">
<h2>Minor Routine Works Entry</h2>
<div class="clear"></div>
<div class="search" id="threadsearch"><a href=""></a> <script
	type="text/javascript"> vbmenu_register("threadsearch"); </script></div>
<div class="clear"></div>
<!-- thread search menu -->
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<form action="" method="post">
<input type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" />
<input type="hidden" name="do" value="process" /> <input type="hidden"
	name="searchthread" value="1" /> <input type="hidden" name="showposts"
	value="1" /> <input type="hidden" name="searchthreadid" value="85875" />
<div class="paddingTop15"></div>
<div class="clear"></div>

<label>Date </label> <input type="text" name="<%=FROM_DATE%>"
	value="<%=currentDate %>" class="date" maxlength="30" tabindex=1 /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.minorRoutineForm.<%= FROM_DATE%>,event);" />

<label>Work Particular :</label> <select name="searchWorkParticular">
	<option value="0" >-Select Work Particulars-</option>
<%
		for (HesWorkParticularMaster hesWorkParticular : workParticularList )
		{
%>
			<option value=<%=hesWorkParticular.getId()%>><%=hesWorkParticular.getWorkParticularName()%></option>
<%
		}
%>
</select>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<label>Entry No :</label> <select name="searchEntryNo">
	<option value="0">---Select Entry No----</option>
<%
		for (HesMinorRoutineWork hesMinorRoutineWork : entryNoList )
		{
%>
			<option value=<%=hesMinorRoutineWork.getId()%>><%=hesMinorRoutineWork.getEntryNo()%></option>
<%
		}
%>
</select>
<label>Department/Area :</label> <select name="searchDeptName">
	<option value="0">--Select Department--</option>
<%
		for (MasDepartment mastDepartment : masDepartmentList )
		{
%>
			<option value=<%=mastDepartment.getId()%>><%=mastDepartment.getDepartmentName()%></option>
<%
		}
%>
</select>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<input type="image" src="/hms/jsp/images/go.gif" class="button"
	onClick="submitForm('minorRoutineForm','hes?method=searchMinorRoutine');" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</div>
<div class="clear"></div>

<form name="purchaseGrid" method="post">
<!--Block One Starts-->
<div class="Block">
<label><span>*</span>Entry No.</label>
<input type="text" id="entryNo" name="entryNo" value="ES-<%=Entry_data%>" tabindex=1 readonly="readonly" />

<label>Date</label>
<input type="text"
	name="<%=DELIVERY_DATE%>" value="<%=currentDate %>" class="date"
	readonly="readonly" validate="Delivery Date,deliveryDate,yes"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onclick="javascript:setdate('<%=currentDate%>',document.purchaseGrid.<%=DELIVERY_DATE%>,event)" />

<label><span>*</span>Work Particulars</label>
<select name="workParticular" validate="Work Particulars Name,String,yes" tabindex=1 onchange="EntryData(this.value)">
	<option value="0" >-Select Work Particulars-</option>
<%
		for (HesWorkParticularMaster hesWorkParticular : workParticularList )
		{
%>
			<option value=<%=hesWorkParticular.getId()%>><%=hesWorkParticular.getWorkParticularName()%></option>
<%
		}
%>
</select>

<div class="clear"></div>

<label><span>*</span>Department/Area</label>
<select name="deptName" validate="Department Name,String,yes" tabindex=1>
	<option value="0">--Select Department--</option>
<%
		for (MasDepartment mastDepartment : masDepartmentList )
		{
%>
			<option value=<%=mastDepartment.getId()%>><%=mastDepartment.getDepartmentName()%></option>
<%
		}
%>
</select>

<label>Remarks</label>
<textarea id="remarks" name="remarks" rows="5" validate="Remarks,String,no"></textarea>

<label><span>*</span>Work Completed By </label>
<select name="completedBy" id="completedBy" validate="Employee Name,String,yes">
	<option value="">--Select Employee--</option>
<%
		for (MasEmployee masEmployee : masEmployeeList )
		{
%>
			<option value=<%=masEmployee.getId()%>><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
<%
		}
%>
</select>

<div class="clear"></div>
</div>
<!--Block one Ends-->

<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<h4>Item Consumption Entry</h4>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" />
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" />
<div class="division"></div>
<div class="tableHolderAuto">
<table border="0" cellspacing="0" cellpadding="0" id="chargeDetails">
	<tr>
		<th scope="col"></th>
		<th scope="col">Item Code</th>
		<th scope="col">Item Name</th>
		<th scope="col">Quantity Used</th>
		<th scope="col">C Stock</th>
	</tr>
	<%
		int inc = 1;
	%>
	<tr>
		<td><input type="checkbox" value="<%=inc%>" name="selectedChrage" class="radioCheck" /></td>

		<td><input id="materialCode<%=inc%>" name="materialCode" type="text"
			size="3" MAXLENGTH="3" readonly="readonly" /></td>

		<td width="20%">
			<input type="text" id="materialName<%=inc%>" name="materialName" size="25" MAXLENGTH="25" onblur="onBlurMaterialName(this.value,'<%=inc %>')" />
			<div id="ac2update" style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">new Ajax.Autocompleter(document.getElementById('materialName<%=inc%>'),'ac2update','hes?method=getItemNamesForAutocomplete',{parameters:'requiredField=materialName'});
			</script>
		</td>

		<td width="10%"><input id="qty<%=inc%>" name="qty" type="text" size="5" MAXLENGTH="5"
		onblur="checkMaterialQty(this.value,'<%=inc %>')" /></td>

		<td>
			<input id="closingStock<%=inc%>" name="closingStock" type="text" size="5" readonly="readonly" />
			<input id="ItemID<%=inc%>" name="ItemID" type="text" size="5" readonly="readonly" style="margin-left: 2px;"/>
		</td>

	</tr>
</table>
</div>
<input type="hidden" value="<%=inc%>" name="hiddenValueCharge"	id="hiddenValueCharge" />

<!--Block Two Ends-->
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" name="sss" align="right" class="button" value="Submit"
 onclick="if(checkFilledRow()){submitForm('purchaseGrid','hes?method=submitMinorRoutineWorksEntry');}" />

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<!--Bottom labels starts-->

<div class="bottom"><input type="hidden" name="lastChgBy"
	value="<%=userName%>" /> <input type="hidden" name="lastChgDate"
	value="<%=currentDate%>" /> <input type="hidden" name="lastChgTime"
	value="<%=currentTime%>" /> <label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=currentDate%></label> <label>Changed
Time</label> <label class="value"><%=currentTime%></label>
<div class="clear"></div>


</div>
<script type="text/javascript">

	function addRow()
	{
		var tbl = document.getElementById('chargeDetails');
		var lastRow = tbl.rows.length;

		var row = tbl.insertRow(lastRow);
		var hdb = document.getElementById('hiddenValueCharge');
		var iteration = parseInt(hdb.value)+1;
		hdb.value = iteration;

		var cell0 = row.insertCell(0);
		var e0 = document.createElement('input');
		e0.type = 'checkbox';
		e0.name='selectedChrage';
		e0.className = 'radioCheck';
		e0.value=(iteration);
		cell0.appendChild(e0);

		var cell2 = row.insertCell(1);
		var e2 = document.createElement('input');
		e2.type = 'text';
		e2.name='materialCode';
		e2.id = 'materialCode'+(iteration)
		e2.tabIndex="1";
		e2.readOnly = true;
		cell2.appendChild(e2);
		e2.size='3';

		var cell1 = row.insertCell(2);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.onblur = function()
					{
						onBlurMaterialName(this.value,iteration);
				  	};
		e1.name = 'materialName';
		e1.id = 'materialName'+(iteration);
		e1.tabIndex="1";
		e1.size='25';
		var newdiv = document.createElement('div');
	   	newdiv.setAttribute('id','ac2update');
	   	newdiv.style.display = 'none';
	   	newdiv.className = 'autocomplete';
	   	cell1.appendChild(e1);
	    cell1.appendChild(newdiv);
	    new Ajax.Autocompleter('materialName'+(iteration), 'ac2update' ,'hes?method=getItemNamesForAutocomplete',{parameters:'requiredField=materialName'});

		var cell3 = row.insertCell(3);
		var e3 = document.createElement('input');
		e3.type = 'text';
		e3.name='qty';
		e3.id = 'qty'+(iteration);
		e3.maxLength="5";
		e3.onblur = function()
					{
						checkMaterialQty(this.value,iteration);
					};
		cell3.appendChild(e3);
		e3.size='5';

		var cell4 = row.insertCell(4);
		var e4 = document.createElement('input');
		e4.type = 'text';
		e4.id='closingStock'+(iteration);
		e4.name='closingStock';
		e4.readOnly = true;
		e4.size='5';
		var newId = document.createElement('input');
		newId.type = 'text';
		newId.id = 'ItemID'+(iteration);
		newId.name = 'ItemID';
		newId.readOnly = true;
		newId.size='5';
		cell4.appendChild(e4);
		cell4.appendChild(newId);

	}

	function removeRow()
	{
		var tbl = document.getElementById('chargeDetails');
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
			}
		}
	}

	function checkFilledRow()
	{
		var msg ="";
		if(document.getElementById('hiddenValueCharge').value == 1 || document.getElementById('hiddenValueCharge').value == "")
		{
			var rowCount = document.getElementById('hiddenValueCharge').value;
			if(document.getElementById('materialName'+rowCount).value == "")
			{
				alert("Please fill atleast one row to submit.");
		  		return false;
			}
			else
			{
				for(var i=1;i<=rowCount;i++)
				{
				 	if(document.getElementById('materialName'+i))
					{
						if(document.getElementById('materialName'+i).value == ""){
				  			msg += "Material Name can not be blank.\n";
				  		}
				  		if(document.getElementById('qty'+i).value == ""){
				  			msg += " Quantity can not be blank.\n";
				  		}
				  		if(msg != ""){
				  			break;
				  		}
				  	}
				}

				if(msg != "")
				{
					alert(msg)
				  	return false;
				}
				else
				  	return true;
			}
		}
		else
		{
			return true;
		}
	}

	function EntryData(val)
	{
		var temp = "";
		var temp2 = "";
		<%
			if(workParticularList != null && workParticularList.size() > 0)
			{
				for(HesWorkParticularMaster hesWorkParticularMaster : workParticularList)
				{
		%>
					if(val == <%=hesWorkParticularMaster.getId()%>)
					{
						temp = "<%=hesWorkParticularMaster.getWorkParticularCode()%>";
						document.getElementById('entryNo').value = temp + "-"+"<%=Entry_data%>";
					}
					else if (val == 0)
					{
						document.getElementById('entryNo').value = "";
					}
	<%
				}
			}
	%>
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
