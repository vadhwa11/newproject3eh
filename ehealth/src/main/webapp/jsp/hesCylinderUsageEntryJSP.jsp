<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.HesCylinderUsageMaster"%>
<%@page import="jkt.hms.masters.business.HesCylinderTypeMaster"%>
<%@page import="jkt.hms.masters.business.HesCylinderUsageEntryHeader"%>
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
	for(i=1;i<inc;i++)
	{
		if(inc != 1)
		{
			if(document.getElementById('materialName'+i).value == val)
			{
				alert("Item Name already selected...!")
				document.getElementById('materialName'+inc).value=0;
				return false;
			}
		}
  	}
  	ajaxMinorWork('purchaseGrid','/hms/hms/hes?method=getCylinderClosingStock&materialCode='+val,inc);
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
	else if (isNaN(qtyUsed))
	{
		alert("Quantity should be numeric!...");
		document.getElementById('qty'+inc).value = '';
		document.getElementById('qty'+inc).focus();
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
	List<HesCylinderUsageEntryHeader> headerList = new ArrayList<HesCylinderUsageEntryHeader>();
	List<HesCylinderUsageMaster> workParticularList = new ArrayList<HesCylinderUsageMaster>();
	List<HesCylinderTypeMaster> entryNoList = new ArrayList<HesCylinderTypeMaster>();
	String Entry_data = "";
	
	if (map.get("hesWorkList")!= null)
		workParticularList = (List<HesCylinderUsageMaster>)map.get("hesWorkList");
	
	if (map.get("hesEntryList")!= null)
		entryNoList = (List<HesCylinderTypeMaster>)map.get("hesEntryList");
	
	if (map.get("headerList")!= null)
		headerList = (List<HesCylinderUsageEntryHeader>)map.get("headerList");
	
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
<script type="text/javascript">
	var icdArray=new Array();
	var usedForArray=new Array();
</script>

<form name="CylinderUsageForm" method="post"">
<h2>Cylinder Usage Entry</h2>
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
	onclick="setdate('<%=currentDate%>',document.CylinderUsageForm.<%= FROM_DATE%>,event);" />
	
<label>Head:</label> <select name="searchHeadNo">
	<option value="0">--Select Head--</option>
	<option value="R">RKS</option>
	<option value="V">VBCH</option>
</select>

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<label>Entry No:</label> <select name="searchEntryNo">
	<option value="0">---Select Entry No----</option>
<%
		for (HesCylinderUsageEntryHeader hesUsageEntryHeader : headerList )
		{
%>
			<option value=<%=hesUsageEntryHeader.getId()%>><%=hesUsageEntryHeader.getEntryNo()%></option>
<%
		}
%>
</select> 
<label>Cylinder type:</label> <select name="searchCylinderNo">
	<option value="0">--Select Cylinder type--</option>
<%
		for (HesCylinderTypeMaster hesTypeMaster : entryNoList )
		{
%>
			<option value=<%=hesTypeMaster.getId()%>><%=hesTypeMaster.getCylinderTypeName()%></option>
<%
		}
%>
</select> 
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<input type="image" src="/hms/jsp/images/go.gif" class="button"
	onClick="submitForm('CylinderUsageForm','hes?method=searchCylinderUsageForm');" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</div>
<div class="clear"></div>

<form name="purchaseGrid" method="post">
<!--Block One Starts-->
<div class="Block">
<label><span>*</span>Entry No.</label>
<input type="text" id="entryNo" name="entryNo" value="CMGS/CUE-<%=Entry_data%>" tabindex=1 readonly="readonly" />

<label>Date</label>
<input type="text"
	name="<%=DELIVERY_DATE%>" value="<%=currentDate %>" class="date"
	readonly="readonly" validate="Delivery Date,date,yes"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onclick="javascript:setdate('<%=currentDate%>',document.purchaseGrid.<%=DELIVERY_DATE%>,event)" />

<div class="clear"></div>
</div>
<!--Block one Ends-->

<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" />
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" />
<div class="division"></div>
<div class="tableHolderAuto">
<table border="0" cellspacing="0" cellpadding="0" id="chargeDetails">
	<tr>
		<th scope="col"></th>
		<th scope="col">Date</th>
		<th scope="col">Cylinder Type</th>
		<th scope="col">Quantity Used</th>
		<th scope="col">Used For</th>
		<th scope="col">Head</th>
		<th scope="col">Remarks</th>
		<th scope="col">C Stock</th>
	</tr>
	<%
		int inc = 1;
	%>
	<tr>
		<td><input type="checkbox" value="<%=inc%>" name="selectedChrage" class="radioCheck" /></td>
		
		<td>	
		<input type="text" id="<%=CHALLAN_DATE%><%=inc%>" name="<%=CHALLAN_DATE%>" value="<%=currentDate %>" class="date" readonly="readonly" 
		validate="Challan Date,date,yes" MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
		height="16" border="0" validate="Pick a date" onclick="javascript:setdate('<%=currentDate%>',document.purchaseGrid.<%=CHALLAN_DATE%><%=inc%>,event)" />
		</td>
		
		<td width="20%">
		<select id="materialName<%=inc%>" name="materialName" onblur="onBlurMaterialName(this.value,'<%=inc %>')" >
		<option value="0">Select</option>
		<%
				for (HesCylinderTypeMaster cylinderTypeMaster : entryNoList )
				{
		%>
					<option value=<%=cylinderTypeMaster.getId()%>><%=cylinderTypeMaster.getCylinderTypeName()%></option>
		<%
				}
		%>	
		</select>
		
		<% 
				HesCylinderTypeMaster  master = new HesCylinderTypeMaster();
		    	    for (int i = 0; i < entryNoList.size(); i++)
		    	    {
		    	    	master = (HesCylinderTypeMaster) entryNoList.get(i);
	    %>
			<script>
	     		 	icdArray[<%=i%>]= new Array();
		          	icdArray[<%=i%>][0] = "<%=master.getId()%>";
		         	icdArray[<%=i%>][1] = "<%=master.getCylinderTypeName()%>";
	    	</script>
	    <%
	    			}
	    %>
			
		</td>
				
		<td width="10%"><input id="qty<%=inc%>" name="qty" type="text" size="5" MAXLENGTH="5" 
		onblur="checkMaterialQty(this.value,'<%=inc %>')" /></td>
		
		<td width="20%">
		<select id="usedFor<%=inc%>" name="usedFor" >
		<option value="0">Select</option>
		<%
			for (HesCylinderUsageMaster hesUsageMaster : workParticularList )
			{
		%>
			<option value=<%=hesUsageMaster.getId()%>><%=hesUsageMaster.getCylinderUsageName()%></option>
		<%
			}
		%>
		</select>
		
		<% 
					HesCylinderUsageMaster  Usagemaster = new HesCylinderUsageMaster();
		    	    for (int i = 0; i < workParticularList.size(); i++)
		    	    {
		    	    	Usagemaster = (HesCylinderUsageMaster) workParticularList.get(i);
	    %>
			<script>
	     		 	usedForArray[<%=i%>]= new Array();
		          	usedForArray[<%=i%>][0] = "<%=Usagemaster.getId()%>";
		         	usedForArray[<%=i%>][1] = "<%=Usagemaster.getCylinderUsageName()%>";
	    	</script>
	    <%
	    			}
	    %>
		
		</td>
		
		<td width="20%">
		<select id="usedHead<%=inc%>" name="usedHead">
		<option value="0">Select</option>
		<option value="R">RKS</option>
		<option value="V">VBCH</option>
		</select>
		</td>
		
		<td>
			<input id="remarks<%=inc%>" name="remarks" type="text" size="20" />
		</td>
		
		<td>
			<input id="closingStock<%=inc%>" name="closingStock" type="text" size="5" readonly="readonly" />
			<input id="ItemID<%=inc%>" name="ItemID" type="text" size="5" readonly="readonly" />
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
 onclick="if(checkFilledRow()){submitForm('purchaseGrid','hes?method=submitCylinderUsageFormEntry');}" />

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
		e2.name = '<%=CHALLAN_DATE%>';
		e2.id = '<%=CHALLAN_DATE%>'+(iteration);
		e2.value = '<%=currentDate %>';
		e2.className = 'date';
		e2.readonly = 'readonly';
		
		var img = document.createElement('img');
		img.src = '/hms/jsp/images/cal.gif';
		img.width = 16;
		img.height = 16;
		img.setAttribute("onclick","javascript:setdate(<%=currentDate%>,document.getElementById('<%=CHALLAN_DATE%>"+iteration+"'),event)");
		cell2.appendChild(e2);
		cell2.appendChild(img);
		
		var cell1 = row.insertCell(2);
		var e1 = document.createElement('Select');
		e1.name = 'materialName';
		e1.id = 'materialName'+(iteration);
		e1.onblur = function(){
			onBlurMaterialName(this.value,iteration);
		};
		e1.options[0] = new Option('Select', '0');
	   	for(var i = 0;i<icdArray.length;i++ ){
	      e1.options[icdArray[i][0]] = new Option(icdArray[i][1],icdArray[i][0]);
	    }
		cell1.appendChild(e1);
			
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
				
		var cell6 = row.insertCell(4);
		var e6 = document.createElement('Select');
		e6.name = 'usedFor';
		e6.id = 'usedFor'+(iteration);
		e6.options[0] = new Option('Select', '0');
	   	for(var i = 0;i<usedForArray.length;i++ ){
	      e6.options[usedForArray[i][0]] = new Option(usedForArray[i][1],usedForArray[i][0]);
	    }
		cell6.appendChild(e6);
		
		var cell5 = row.insertCell(5);
		var e5 = document.createElement('Select');
		e5.name = 'usedHead';
		e5.id = 'usedHead'+(iteration);
		e5.options[0] = new Option('Select', '0');
		e5.options[1] = new Option('RKS', 'R');
		e5.options[2] = new Option('VBCH', 'V');
		cell5.appendChild(e5);
		
		var cell7 = row.insertCell(6);
		var e7 = document.createElement('input');
		e7.type = 'text';
		e7.name = 'remarks';
		e7.id = 'remarks'+(iteration);
		e7.size='20';
		cell7.appendChild(e7);
		
		var cell4 = row.insertCell(7);
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
	
</script><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script><input type="hidden" name="rows" id="rr" value="1" />
<!--Bottom labels ends--> <!--main content placeholder ends here--></form>
<div class="clear"></div>
<div class="paddingTop40"></div>
