<%@page import="java.util.*"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
	
	


<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>


<script type="text/javascript" language="javascript">
	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}

	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>



<%
	String time = "";
	String userName = "";
	int hospitalId = 0;
	int deptId = 0;
	Box box = HMSUtil.getBox(request);
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
   	date = (String)utilMap.get("currentDate");
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}

  	Map map = new HashMap();
	if (request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");

		if (map.get("message")!=null)
		{%>
<script>alert('<%=map.get("message").toString()%>');</script>
<%
		}
    }

	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	if (session.getAttribute("deptId") != null) {
		Integer temp =  (Integer)session.getAttribute("deptId");
		deptId = temp.intValue();
	}

	Map<String, Object> drugStockItem = new HashMap<String, Object>();
	if (map.get("drugStockItem") != null) {

		drugStockItem = (Map<String, Object>)map.get("drugStockItem");

	}
	List objectList = new ArrayList();
	List objectList1 = new ArrayList();
		if (drugStockItem.get("objectList") != null) {
			objectList = (List)drugStockItem.get("objectList");

		}

		if (drugStockItem.get("objectList1") != null) {
			objectList1 = (List)drugStockItem.get("objectList1");

		}

		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<StoreItemBatchStock> batchStockList= new ArrayList<StoreItemBatchStock>();
		if (drugStockItem.get("departmentList") != null) {
			departmentList = (List)drugStockItem.get("departmentList");

		}

		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		if (drugStockItem.get("itemList") != null) {
			itemList = (List)drugStockItem.get("itemList");

		}

		if (drugStockItem.get("batchStockList") != null) {
			batchStockList = (List)drugStockItem.get("batchStockList");

		}
		Map itemValue  = new HashMap();
		if (drugStockItem.get("itemValue") != null) {
			itemValue = (Map)drugStockItem.get("itemValue");


		}
		String message="";
		if (drugStockItem.get("msg") != null) {
            message = (String)drugStockItem.get("msg");
     }
if(!message.equalsIgnoreCase("")){
%>
<h4><%=message %></h4>
<%} %>


<script language="Javascript">

function showReport()
{
	//alert("Please Enter The value."+document.stockPosition.Item.checked)
		if(document.stockPosition.nomenclature.value != "")
		{
			var val = document.stockPosition.nomenclature.value;
			document.stockPosition.method="post";
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	   		if (pvms!="")
	   	 	{
	    	document.getElementById("item_id").value=pvms;
	    	document.stockPosition.method="post";
			//submitForm('stockPosition','stores?method=generateStockPositionReport');
	    	submitForm('stockPosition','stores?method=generateDrugsStockPosition&pvmsNo='+pvms);
			document.getElementById("item_id").value="";
			}
			else
			{
			alert("Pl. select the Nomenclature!....");
			}
		}
	else if(document.stockPosition.pvms.value != "")
		{
		document.stockPosition.method="post";
		var pvms=document.getElementById("pvms").value;
		document.getElementById("item_id").value=0;
		//submitForm('stockPosition','stores?method=generateStockPositionReport&pvmsNo='+pvms);
		submitForm('stockPosition','stores?method=generateDrugsStockPosition&pvmsNo='+pvms);
		}

	else{
		if(document.stockPosition.Item.checked){
	 			 document.stockPosition.method="post";
				//submitForm('stockPosition','stores?method=generateStockPositionReport');
  				submitForm('stockPosition','stores?method=generateDrugsStockPosition');
		}
		else{
			alert("Pl. Fill the Nomenclature / PVMSNo.! OR \n Select radio Button.!");
		}
		}
}

</script>

<form name="stockPosition">
<input type="hidden" name="hospitalId" size="5" value="<%=hospitalId%>">
<input type="hidden" name="deptId" size="5" value="<%=deptId%>">
<input type="hidden" name="item_id" size="5" id="item_id"> <br />

<div class="titleBg">
<h2>Stock Position</h2>
</div>

<div class="Block">
<div id="ddd" >
<label>Item Code </label>
<input type="text" value="" id="pvms" name="pvms" validate="Item Code,alphanumeric1,no" />
</div>
<label>Item Name </label>
<input type="text" value="" id="nomenclature" class="bigcaption1" name="nomenclature"  />
<div id="ac2update" style="display: none; " class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
new Ajax.Autocompleter('nomenclature','ac2update','stores?method=getItemListForBINCardByAutocomplete',{parameters:'requiredField=nomenclature'});
</script>



<!-- 	<label class="medium">ALL ITEMS</label> <input type="radio" name="Item"
	value="Item" class="radioAuto" maxlength="30" tabindex=1 /> -->
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="button" name="generateReport" value="Generate Report" class="buttonBig"  onClick="showReport();"/>
<input type="button" name="Reset" 	value="Reset" class="button" onclick="submitForm('stockPosition','stores?method=drugsStockPosition');" />

	<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
<% if(objectList.size()>0){ %>

<table id="main">

	<thead>
		<tr>
		
		<th>Item Code</th>
			<th>
			 Item Name</th>
			<%
		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
		Object[] object = (Object[]) iterator.next();%>

			<th><div class="calcell"><%= object[1]%></div></th>

			<%} %>
			<th>Total</th>

		</tr>
	</thead>
	<tr>
	

<%
		int count=0;
		int tot=0;
		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
		Object[] object = (Object[]) iterator.next();
		count++;
		 tot +=((BigDecimal)object[0]).intValue();
		%>
	<%if(count==1){ %>
<td><div class="calcell"><%=object[2]%></div></td>
<td><div class="calcell"><%=object[3]%></div></td>
<%} %>
<td ><div class="calcell"><%=object[0]%></div></td>
<%}%>
<%if(objectList.size()==count){ %>
<td><%=tot%></td>
<%} %>


</tr>


</table>
<%} %>





<% if(itemValue .size()>0){ %>
<div STYLE=" height:400px; width: 1000px; font-size: 12px; overflow: auto;">
<table id="main">

	<thead>
		<tr>
			<th>Department/Ward </br>
			Item Code/Item Name</th>
			<%

			for (Iterator iterator = departmentList.iterator(); iterator.hasNext();) {
				MasDepartment object2 = (MasDepartment) iterator.next();

				%>
				<th><div class="calcell"><%=object2.getDepartmentName()%></div></th>
				<%} %>

			<th>Total</th>

		</tr>


	</thead>


<%
		int count=0;
		int j=0;
		Set s=itemValue.keySet();
		Iterator itr=s.iterator();
		while (itr.hasNext()) {
		int k=(Integer)itr.next();
		count++;
		int tot=0;
		for(MasStoreItem item : itemList){

		if(item.getId()==k){

		%>
	<tr>

<td ><div class="calcell"><b><%=item.getNomenclature()%></b></div></td>
<%} }%>
<%
int total=0;
String value=(String) itemValue.get(k);
String value1[]=value.split("#");
for(int n=0; n<value1.length; n++)
{
	String value2[]=value1[n].split("@");
	%>
	<td ><div class="calcell"><%=value2[1]%></div></td>

<%}%>
<td ><div class="calcell"><%=total%></div></td>
<% } %>
</tr>
</table>
</div>
<%}%>




