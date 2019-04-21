<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="javax.mail.Store"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.StoreGrnT"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<script language="javascript"  type="text/javascript" src="/hms/jsp/js/calender.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/addRow.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script>
	 var nameArray=new Array();
	 var itemsArray1=new Array();
</script>
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
	List<Object[]> refrigeratorAllocationList = new ArrayList<Object[]>();
	List<Object[]>refrigeratorList = new ArrayList<Object[]>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	String message="";
	if(map.get("message") != null){
		message = (String)map.get("message");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int deptId = 0;
	if (session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute("deptId");
	}
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	if(map.get("refrigeratorAllocationList") != null){
		refrigeratorAllocationList = (List)map.get("refrigeratorAllocationList");
	}
	
	if(map.get("refrigeratorList") != null){
		refrigeratorList = (List)map.get("refrigeratorList");
	}

	%>
	<script type="text/javascript">
	var coldArray=new Array();
</script>

<div class="titleBg">
<h2>Refrigerator / Cold Room Allocation</h2>
</div>
<div class="clear"></div>
<form name="coldRoomAllocation" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<h4>Item Details</h4>

<div class="paddingTop15"></div>
<input name="" value="" id="temp" type="hidden" /> 

<div class="clear"></div>
	<input type="button" name="Add" type="submit" class="buttonAdd" value="" onClick="addRow();" />
  <input type="button" name="Delete" type="submit" class="buttonDel" value="" onClick="removeRow();" />

<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
		<tr>

			<th>Item Code</th>
			<th>Item Name</th>
			<th>Unit</th>
			<!-- <th>Batch No.</th> -->
			<th>Ref/CR</th>
			<th>Ref. Batch No</th>
			<th>GRN Qty</th>
			<th>Stored Qty</th>
			<th>Qty Pending</th>
			<th>Item Min Temp(°C)</th>
			<th>Item Max Temp(°C)</th>
			<!-- <th>Ref. Min Temp(°C)</th>
			<th>Ref. Max Temp(°C)</th> -->
			<!-- <th>Stock</th> -->
		</tr>
				<%
				int i= 1;
				if(refrigeratorAllocationList.size()>0){
					for(Object[] obj :refrigeratorAllocationList){
				
				
				
				%>
		<tr>
			<td>
			<input type="text" name="itemCode" size="5" value="<%=obj[2]!= null?(String)obj[2]:"" %>" validate="Item Code,string,yes"	tabindex=1  readonly="readonly" id="itemCode<%=i %>" />
			<%-- <input type="hidden" name="grnTId" size="5" value="<%=storeGrnT.getId()!= null ? storeGrnT.getId():"" %>" 	tabindex=1  readonly="readonly" id="grnTId<%=i %>" /> --%>
			</td>
			
			<td>
			<input type="text" name="itemName" size="25" value="<%=obj[1]!= null?(String)obj[1]:""%>" validate="Item Name,string,yes"	tabindex=1  readonly="readonly" id="itemName<%=i %>" />
			<input type="hidden" name="itemId"  value="<%=obj[0]!= null?(Integer)obj[0]:""%>"	tabindex=1  readonly="readonly" id="itemId<%=i %>" />
			</td>
			
			<td>
			<input type="text" name="au" value="<%=obj[5]!= null?(String)obj[5]:""%>" size="5"	tabindex=1 validate="Unit,string,yes"  readonly="readonly" id="au<%=i %>" />
			</td>
			
			<%-- <td><input type="text" name="batchNo" value="<%=obj[7]!= null?(String)obj[7]:""%>" size="8"	tabindex=1  readonly="readonly" id="batchNo<%=i %>"  validate="Batch No,string,yes"/>
			<input type="hidden" name="batchId"  value="<%=obj[8]!= null?(Integer)obj[8]:""%>"	tabindex=1  readonly="readonly" id="batchId<%=i %>" />
			</td> --%>
			
			<td>
			<select name="serialNo" id= "serialNo<%=i %>"  validate="Refrigerator,string,yes"  onchange="getRefrigeratorSerialNo(this.value,<%=i%>);">
			<option value="0">Select </option>
			<%
				if(refrigeratorList.size()>0){
					for(Object[] storeItemBatchStock : refrigeratorList){
						
			%>
			<option value="<%=storeItemBatchStock[0]%>"><%=storeItemBatchStock[1]%> </option>
			<%}} %>
			</select>
			<% 
			int j =0;
				for(Object[] itemBatchStock : refrigeratorList){
		    	System.out.println("refrigeratorList=="+refrigeratorList.size());    
	    %>
			<script>
			coldArray[<%=j%>]= new Array();
			coldArray[<%=j%>][0] = "<%=itemBatchStock[0]%>";
			coldArray[<%=j%>][1] = "<%=itemBatchStock[1]%>";
			
	    	</script>
	    <%
	    			j++;}
	    %>
			</td>
			<td><select name="batchName"  id="batchName<%=i%>"  tabindex="1">
					<option value="">Select</option></select></td>
			
			<td>
			<input type="text" name="grnQty" value="<%=obj[6]!= null?((BigDecimal)obj[6]).intValue():""%>" size="8" validate="GRN Qty,float,yes"	tabindex=1   id="grnQty<%=i %>" />
			</td>
			<td>
			<input type="text" name="storedQty" value="" size="8"	tabindex=1 onblur="calculatePendingQty(<%=i %>);"   id="storedQty<%=i %>"  validate="Stored Qty,float,yes"/>
			</td>
			
			<td>
			<input type="text" name="pendingQty" value="" size="8"	 readonly="readonly" tabindex=1   id="pendingQty<%=i %>" validate="Pending Qty,float,no" />
			</td>
			
				<td>
			<input type="text" name="itemMinTemperature" value="<%=obj[3]!= null?((BigDecimal)obj[3]).intValue():""%>" validate="Min.Temperature,float,no" maxlength="2"	size="5"   tabindex=1   id="itemMinTemperature<%=i %>" />
			</td>
			
				<td>
			<input type="text" name="itemMaxTemperature" value="<%=obj[4]!= null?((BigDecimal)obj[4]).intValue():""%>" size="5"	validate="Max.Temperature,float,no" maxlength="2"  tabindex=1   id="itemMaxTemperature<%=i %>" />
			</td>
			
				<%-- <td>
			<input type="text" name="minTemperature" value="" validate="Min.Temperature,float,no" maxlength="2"	size="5"   tabindex=1   id="minTemperature<%=i %>" />
			</td>
			
				<td>
			<input type="text" name="maxTemperature" value="" size="5"	validate="Max.Temperature,float,no" maxlength="2"  tabindex=1   id="maxTemperature<%=i %>" />
			</td> --%>
			<%-- <td><a href="javascript:openPopupWindow(<%=storeGrnT.getId()%>);">Stock</a>
			
			</td> --%>
		</tr>
		<%}} %>
</table>
<input	type="hidden" name="hdb" id="hdb"	value="<%=i %>" />
<div class="paddingTop15"></div>
<input name="button"  type="button"	value="Submit" class="button"	onClick="submitForm('coldRoomAllocation','coldChain?method=submitColdRoomAllocation');" />
<input name="button"  type="button"	value="Reset" class="button"	onclick=""; />


<div class="clear"></div>

<script type="text/javascript">
	function displayTemperature(serialId,rowVal){
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

				        var maxTemperature  = item.getElementsByTagName("maxTemperature")[0];
				        var minTemperature  = item.getElementsByTagName("minTemperature")[0];
				      

				       
			        	document.getElementById('minTemperature'+rowVal).value = minTemperature.childNodes[0].nodeValue
			        	document.getElementById('maxTemperature'+rowVal).value = maxTemperature.childNodes[0].nodeValue
			        	
			      	}
			      }
			    }
			     url="coldChain?method=getRefrigeratorTemperature&serialId="+serialId;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
			    xmlHttp.open("GET",url,true);
			    xmlHttp.setRequestHeader("Content-Type", "text/xml");
			    xmlHttp.send(null);

			 }	
		
	function getRefrigeratorSerialNo(refId,rowVal){
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
			    	var batchId="batchName"+rowVal;
						obj = document.getElementById(batchId);
						obj.length = 1;
						
						for (loop = 0; loop < items.childNodes.length; loop++) {
					   	    var item = items.childNodes[loop];
					         var batchLength  = item.getElementsByTagName("batchs")[0];
					     
	
				        	for(innerLoop = 0;innerLoop < batchLength.childNodes.length;innerLoop++)
				        	{
				        		var batch = batchLength.childNodes[innerLoop];
				        		
					        	var batchName  = batch.getElementsByTagName("batchName")[0];
					        	obj.length++;
					        	//alert("batch==="+batch);
					        	//alert("batchName==="+batchName);
					        	//alert("obj==="+obj.length);
								obj.options[obj.length-1].value=batchName.childNodes[0].nodeValue;
								obj.options[obj.length-1].text=batchName.childNodes[0].nodeValue;

				        	}

				      	}
			      }
			    }
			   
			     url="coldChain?method=getRefrigeratorSerialNo&refId="+refId;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
			    xmlHttp.open("GET",url,true);
			    xmlHttp.setRequestHeader("Content-Type", "text/xml");
			    xmlHttp.send(null);

			 }	
		



function calculatePendingQty(inc){
	
	var incc=inc;
		var storedQty =0;
		var grnQty =0;
		var pendingQty =0;
		
		if (!isNaN(document.getElementById('storedQty'+inc).value))
			storedQty = parseFloat(document.getElementById('storedQty'+inc).value);
		if (!isNaN(document.getElementById('grnQty'+inc).value))
			grnQty = parseFloat(document.getElementById('grnQty'+inc).value);
		//alert("storedQty=="+storedQty);
		//alert("grnQty=="+grnQty);
		if(inc>1){
			incc=incc-1;
			
		if (document.getElementById('pendingQty'+incc).value !="" ){
			pendingQty = parseFloat(document.getElementById('pendingQty'+incc).value);
		
		
		}
		}
		
		if(pendingQty==0){
		if(!isNaN(storedQty) != "" && !isNaN(grnQty)!= ""){
			
			if(grnQty>storedQty){
				pendingQty =parseFloat(grnQty)-parseFloat(storedQty);
			document.getElementById('pendingQty'+inc).value = pendingQty;
			}else if(grnQty==storedQty){
				document.getElementById('pendingQty'+inc).value = pendingQty;	
			
			}else{
				alert("Stored Quantity Is Greater Than GRN Quantity ")
			}
		}
		}
		else{
				if(pendingQty >= storedQty){
					
					pendingQty =parseFloat(pendingQty)-parseFloat(storedQty);
					
				document.getElementById('pendingQty'+inc).value = pendingQty;
				}
				else{
					alert("Stored Quantity Is Greater Than Pending Quantity ")
				}
			
		}
	
	}
	
	
	

function openPopupWindow(storeGrnTId)
{
 var url="/hms/hms/coldChain?method=showRefrigeratorAllocationPopup&storeGrnTId="+storeGrnTId;
 newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
	
}

function addRow(){
	  var tbl = document.getElementById('itemDetails');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cellRight1 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name='itemCode'+iteration;
	  e0.id='itemCode'+iteration;
	  e0.value =document.getElementById('itemCode'+(iteration-1)).value;
	  e0.size='5'
	 cellRight1.appendChild(e0);
	
	  

	 var cellRight2 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='itemName';
	  e1.id='itemName'+iteration;
	  e1.value =document.getElementById('itemName'+(iteration-1)).value;
	  e1.size='25'
	 cellRight2.appendChild(e1);
	  
	  var e11 = document.createElement('input');
	  e11.type = 'hidden';
	  e11.name = 'itemId';
	  e11.id = 'itemId' + iteration;
	  e11.value =document.getElementById('itemId'+(iteration-1)).value;
	  e11.size = '5';
	  cellRight2.appendChild(e11);
	  
	  var cellRight3 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name='au';
	  e2.id='au'+iteration;
	  e2.value =document.getElementById('au'+(iteration-1)).value;
	  e2.size='5'
	 cellRight3.appendChild(e2);
	  
	  
	  /* var cellRight4 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='batchNo';
	  e3.size = '8';
	  e3.id='batchNo'+iteration;
	  e3.value =document.getElementById('batchNo'+(iteration-1)).value;
	  cellRight4.appendChild(e3);
	  
	  var e31 = document.createElement('input');
	  e31.type = 'hidden';
	  e31.name='batchId';
	  e31.size = '8';
	  e31.id='batchId'+iteration;
	  e31.value =document.getElementById('batchId'+(iteration-1)).value;
	  cellRight4.appendChild(e31); */
			  
	  var cellRight4 = row.insertCell(3);
	  var e4 = document.createElement('select');
	  e4.name='serialNo';
	  e4.id='serialNo'+iteration;
	  e4.options.length = 1;
	  e4.options[0] = new Option('Select', '0');
	   	/* for(var i = 0;i<coldArray.length;i++ ){
	      e4.options[coldArray[i][0]] = new Option(coldArray[i][1],coldArray[i][0]);
	    } */
	    for(var k = 0;k<coldArray.length;k++){
	    
            e4.options[k+1] = new Option(coldArray[k][1],coldArray[k][0]);
   		}
  	  e4.setAttribute('validate','Serial No,string,yes');
  	 e4.onblur=function(){getRefrigeratorSerialNo(this.value,iteration);};
	  cellRight4.appendChild(e4);
	  
	  var cellRight5 = row.insertCell(4);
	  var e41 = document.createElement('select');
	  e41.name='batchName';
	  e41.id='batchName'+iteration
	  e41.setAttribute('validate', 'Batch No,string,yes');
	  e41.value='';
	  e41.options[0] = new Option('Select', '');
	  cellRight5.appendChild(e41);

	  
	  var cellRight6 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.size='8';
	  e5.name='grnQty';
	  e5.id='grnQty'+iteration
	  e5.value =document.getElementById('grnQty'+(iteration-1)).value;
	  cellRight6.appendChild(e5);

	  var cellRight7 = row.insertCell(6);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.size='8';
	  e6.name='storedQty';
	  e6.id='storedQty'+iteration
	// e6.value =document.getElementById('pendingQty'+(iteration-1)).value;
	  e6.onblur=function(){calculatePendingQty(iteration);};
	  cellRight7.appendChild(e6);
	  
	  var cellRight8 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.size='8';
	  e7.name='pendingQty';
	  e7.id='pendingQty'+iteration
	  cellRight8.appendChild(e7);


	  var cellRight9 = row.insertCell(8);
	  var e71 = document.createElement('input');
	  e71.type = 'text';
	  e71.size='5';
	  e71.name='itemMinTemperature';
	  e71.id='itemMinTemperature'+iteration;
	  e71.maxLength = "2";
	  e71.value =document.getElementById('itemMinTemperature'+(iteration-1)).value;
	  e71.onblur=function(){calculateIndentQty(iteration);};
	  cellRight9.appendChild(e71);

	  var cellRight10 = row.insertCell(9);
	  var e8 = document.createElement('input');
	  e8.type = 'text';
	  e8.size='5';
	  e8.name='itemMaxTemperature';
	  e8.id='itemMaxTemperature'+iteration
	  e8.maxLength = "2";
	  e8.value =document.getElementById('itemMaxTemperature'+(iteration-1)).value;
	  cellRight10.appendChild(e8);
	  
	  /* var cellRight10 = row.insertCell(9);
	  var e81 = document.createElement('input');
	  e81.type = 'text';
	  e81.size='5';
	  e81.name='minTemperature';
	  e81.id='minTemperature'+iteration;
	  e81.maxLength = "2";
	  e81.value =document.getElementById('minTemperature'+(iteration-1)).value;
	  e81.onblur=function(){calculateIndentQty(iteration);};
	  cellRight10.appendChild(e81);

	  var cellRight11 = row.insertCell(10);
	  var e9 = document.createElement('input');
	  e9.type = 'text';
	  e9.size='5';
	  e9.name='maxTemperature';
	  e9.id='maxTemperature'+iteration
	  e9.maxLength = "2";
	  e9.value =document.getElementById('maxTemperature'+(iteration-1)).value;
	  cellRight11.appendChild(e9); */
	  
	 /*  var cellRight11 = row.insertCell(10);
	  var e9 = document.createElement('input');
	  e9.type = 'text';
	  e9.size='5';
	  e9.name='itemData';
	  e9.id='ItemData'+iteration
	  cellRight11.appendChild(e9);
	   */
	 
}

function removeRow()
{
	var tbl = document.getElementById('itemDetails');
	 var tblRows  = tbl.getElementsByTagName("tr");
	
  	if(tblRows.length-2==0){
         	alert("Can not delete all rows")
         	return false;
     }
  	for(i=0;i<document.getElementsByName('hdb').length;i++)
	{
		
  		//if (document.getElementsByName('srno')[i].checked == true)
		//{
		  	tbl.deleteRow(i-1);
		//}
	}
}
	
</script>

</form>