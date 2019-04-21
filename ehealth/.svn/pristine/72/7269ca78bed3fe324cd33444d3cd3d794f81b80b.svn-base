<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<%
Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null)
{
	map = (Map<String,Object>) request.getAttribute("map");
}
List<Object[]> insWiseStockList = new ArrayList<Object[]>();
if (map.get("insWiseStockList") != null) {
	insWiseStockList = (List<Object[]>)map.get("insWiseStockList");

}
Box box = HMSUtil.getBox(request);

String nomenclature = "";
if(map.get("nomenclature")!=null){
	nomenclature = (String)map.get("nomenclature");
}else{
	nomenclature = box.getString("nomenclature");
}
%>
<form name="insWiseStockPosition" method="post">
<input type="hidden" name="item_id" size="5" id="item_id"> <br />

<div class="titleBg">
<h2>Institute Wise Stock Position</h2>
</div>

<div class="Block">
<div id="ddd" >
<label>Item Code </label>
<input type="text" value="<%=box.getString("pvmsNo") %>" id="pvms" name="pvms" validate="Item Code,alphanumeric1,no" />
</div>
<label>Item Name </label>
<input type="text" value="<%=nomenclature %>" id="nomenclature" class="bigcaption1" name="nomenclature"  />
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
<input type="button" name="Reset" 	value="Reset" class="button" onclick="submitForm('insWiseStockPosition','stores?method=drugsStockPosition');" />

	<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
<div class="clear"></div>

<div id="pageNavPosition"></div>
<div class="clear"></div>
<table id="main">

	<thead>
		<tr>
		<th>Institute</th>
		<th>Stock</th>

		</tr>
	</thead>
	<tbody id="tableData">
	<%
		for(Object[] obj : insWiseStockList){
	%>
	<tr>
	<td><%=obj[0] %></td>
	<td><%=obj[1] %></td>
	
	</tr>
	<%} %>
	</tbody>
</table>


<script>

function showReport()
{
		if(document.getElementById('nomenclature').value!= "")
		{
			var val = document.getElementById('nomenclature').value;
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    var nomenclature = val.substring(0,index1-1);
	   		if (pvms!="")
	   	 	{
	    	document.getElementById("item_id").value=pvms;
	    	submitForm('insWiseStockPosition','/hms/hms/stores?method=getInstituteWiseStock&pvmsNo='+pvms+'&nomenclature='+nomenclature);
			document.getElementById("item_id").value="";
			}
			else
			{
			alert("Pl. select the Nomenclature!....");
			}
		}else if(document.getElementById("pvms").value != "")
		{
			var pvms=document.getElementById("pvms").value;
			document.getElementById("item_id").value=0;
			submitForm('insWiseStockPosition','stores?method=getInstituteWiseStock&pvmsNo='+pvms);
			}
}


var pager = new Pager('tableData',5);
pager.init();
pager.showPageNav('pager', 'pageNavPosition');
pager.showPage(1);
</script>
