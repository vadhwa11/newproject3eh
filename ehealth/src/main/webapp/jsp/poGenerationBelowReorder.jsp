<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	
	List<Object> POQtyList = new ArrayList<Object>();
	List<Object> masStoreSupplierList = new ArrayList<Object>();
	int pageNo = 0;
	Integer deptId=0;
	String userName = "";
	boolean accessFlag=false;
	
	if(map.get("accessFlag")!=null)
	{
		accessFlag = (Boolean)map.get("accessFlag");
	}
	
	if(map.get("POQtyList") != null)
	{
		POQtyList = (List<Object>)map.get("POQtyList");
	}
	
	if(map.get("masStoreSupplierList") != null)
	{
		masStoreSupplierList = (List<Object>)map.get("masStoreSupplierList");
	}
		
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	
	if(map.get("pageNo") != null){
		pageNo = (Integer)map.get("pageNo");
	}
	
	if(map.get("message") != null)
	{
		String message = (String)map.get("message");
%>
   		<h4><span><%=message %></span></h4>
<% 
	}
	
	if(accessFlag)
	{

%>

<div class="titleBg">
<h2>PO Generation For Item Below Reorder Level</h2>
</div>
<div class="clear"></div>
<form name="POGenerationList" method="post" action="">

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<%
    int counter=0;
	int SlNo = 1;
%>
<table>
	<tr>
		<th>Select</th>
		<th>S.L.No.</th>
		<th>Item Name</th>
		<th>Vendor Name</th>
		<th>A/U</th>
		<!--<th>Previous Reorder Qty</th>
		--><th>Reorder Level Qty</th>
		<th>Stock Qty</th>
		<th>Required Qty</th>		
	</tr>

<%
		Iterator iterator = POQtyList.iterator();
        while(iterator.hasNext())
        {
        	Object[] object = (Object[]) iterator.next();
        	int mainItemId=0;
        	mainItemId=(Integer)object[0];
%>
			<tr>
			<td><input type="checkbox" id="parent<%=SlNo%>" name="parent" value="<%=SlNo%>" />
			<input type="hidden" name="itemID<%=SlNo%>" id="itemID<%=SlNo%>" value="<%=object[0]%>" />
			</td>
			<td><%=SlNo%></td>
<%
			if(object[1] != null)
			{
				StringBuffer output_str = new StringBuffer();
				StringTokenizer s = new StringTokenizer(object[1].toString(),"\"");

				while (s.hasMoreTokens())
				{
					output_str.append(s.nextToken());
					if (s.hasMoreTokens())
					{
						output_str.append("\\");
						output_str.append("\"");
					}
				}
%>
				<td><%=output_str.toString()%><input type="hidden" name="itemName<%=SlNo%>" id="itemName<%=SlNo%>" value="<%=output_str.toString()%>" /></td>
<%	
			}
%>
			<td>
			<select name="supplierId<%=SlNo%>" id="supplierId<%=SlNo%>">
			<option value="">Select</option>
<%
String supplierName="";
int supplierId=0;
for (Iterator iteratorSupp = masStoreSupplierList.iterator(); iteratorSupp.hasNext();) {
	Object[] objectSupp = (Object[]) iteratorSupp.next();
	int itemId=0;
	itemId=(Integer)objectSupp[1];
		boolean flag=false;
	if(itemId==mainItemId){
	supplierName=(String)objectSupp[0];
	supplierId=(Integer)objectSupp[2];
%>
<option value="<%=supplierId%>"><%=supplierName%></option>
<%
}
		}
%>
			</select>
			</td>
			<td><%=object[6]%><input type="hidden" name="AU<%=SlNo%>" id="AU<%=SlNo%>" value="<%=object[6]%>" /></td>
			<td><%=object[2]%><input type="hidden" name="rol<%=SlNo%>" id="rol<%=SlNo%>" value="<%=object[2]%>" /></td>
			<td><%=object[5]%><input type="hidden" name="stockQty<%=SlNo%>" id="stockQty<%=SlNo%>" value="<%=object[5]%>" /></td>
			<td><%=object[7]%><input type="hidden" name="reqQty<%=SlNo%>" id="reqQty<%=SlNo%>" value="<%=object[7]%>" /></td>
			<input type="hidden" name="saleTaxId<%=SlNo%>" id="saleTaxId<%=SlNo%>" value="<%=object[9]%>" />
			<input type="hidden" name="costPrice<%=SlNo%>" id="costPrice<%=SlNo%>" value="<%=object[8]%>" />
			<input type="hidden" name="manufacID<%=SlNo%>" id="manufacID<%=SlNo%>" value="<%=object[10]%>" />
			
			</tr>
<%
			SlNo++;
			counter++;
        }
%>
</table>
<input type="hidden" name="counter" id="counter" value="<%=counter%>"></input>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>

<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="clear"></div>

<input type="button" name="GenPO" id="generatePObutton" value="Generate PO" class="buttonBig"
onclick="if(validateCollected())submitForm('POGenerationList','purchaseOrder?method=submitPurchaseOrderBelowReorder')" accesskey="a" tabindex=1 />

<input type="button" name="selectAll" id="selectAll" value="Select All" class="button" 
onclick="SetAllCheckBoxes('POGenerationList', 'parent', true);" accesskey="a" tabindex=1 />

<input type="button" name="deselectAll" id="deselectAll" value="Deselect All" class="button" 
onclick="SetAllCheckBoxes('POGenerationList', 'parent', false);" accesskey="a" tabindex=1 />

<input type="button" name="search" id="search" value="Search" class="button" style="display: none"
onClick="" accesskey="a" tabindex=1 />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="bottom"><label>Changed By:</label>
<label class="value"><%=userName%></label>
<label>Changed Date:</label> <label class="value"><%=date%></label>
<label>Changed Time:</label> <label	class="value"><%=time%></label>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>

<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="paddingTop40"></div>

<%
	}
	else
	{
%>
		<h2>PO Generation For Item Below Reorder Level</h2>
		<div class="clear"></div>
		<h3>Access Denied</h3>
<%
	}
%>
<div class="paddingTop40"></div>

<script type="text/javascript">

	function validateCollected()
	{
		var msg="";
		var count = document.getElementsByName('parent').length;
		for(var i = 0; i < document.getElementsByName('parent').length; i++)
		{
			  if(document.getElementsByName('parent')[i].checked == true )
              {
              	count=count-1
				//alert("Please Collect atleast one Sample....")
				//return false;
			  }
  		}
  		if(count == document.getElementsByName('parent').length )
        {
        	alert("Please Select atleast one Checkbox....")
			return false;
		}
  		if(msg != "")
  		{
		 	alert(msg);
		 	return false;
		}
		return true;
	}
	
	function SetAllCheckBoxes(FormName, FieldName, CheckValue)
	{
		if(!document.forms[FormName])
		{
			return;
		}
		var objCheckBoxes = document.forms[FormName].elements[FieldName];
		if(!objCheckBoxes)
		{
			return;
		}
		var countCheckBoxes = objCheckBoxes.length;
		if(!countCheckBoxes)
		{
			objCheckBoxes.checked = CheckValue;
		}
		else
		{
			// set the check value for all check boxes
			for(var i = 0; i < countCheckBoxes; i++)
			{
				objCheckBoxes[i].checked = CheckValue;
			}
		}
	}
	
</script>