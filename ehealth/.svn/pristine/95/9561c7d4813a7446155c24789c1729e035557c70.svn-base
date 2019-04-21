<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreDeptReorderLevel"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript">
		<!--
		var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
		var IMGDIR_MISC = "images/misc";
		var vb_disable_ajax = parseInt("0", 10);
		// -->
		</script>
<%
		List<StoreDeptReorderLevel> storeDeptReorderLevelList= new ArrayList<StoreDeptReorderLevel>();
		StringBuffer orderDateOnly = new StringBuffer();
		GregorianCalendar gregorianCalendar1 = new GregorianCalendar();
		int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
		if (dateOfMonth < 10) {
			orderDateOnly.append("0");
			orderDateOnly.append(dateOfMonth);
		} else {
			orderDateOnly.append(dateOfMonth);
		}
		orderDateOnly.append("/");
		int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
		if (month < 10) {
			orderDateOnly.append("0");
			orderDateOnly.append(month);
		} else {
			orderDateOnly.append(month);
		}

		orderDateOnly.append("/");
		int year = gregorianCalendar1.get(Calendar.YEAR);
		orderDateOnly.append(year);
		String currentDate = new String(orderDateOnly);
		
	%>
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
	Map map = new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
		String includedJsp="";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");


		}
		if(map.get("storeDeptReorderLevelList")!=null){
			storeDeptReorderLevelList=(List<StoreDeptReorderLevel>)map.get("storeDeptReorderLevelList");
		}
		
		utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
		String currentDate1 = (String)utilMap.get("currentDate");
		String currentTime1 = (String)utilMap.get("currentTime");

		try{
			storeDeptReorderLevelList=(List)map.get("storeDeptReorderLevelList");
			
		}catch(Exception e){
		}


		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		String message="";
		if(map.get("messageTOBeVisibleToTheUser")!=null){
			message=(String)map.get("messageTOBeVisibleToTheUser");
			
			%>
<h4><%=message %></h4>
<input type="button" class="button" name="back" value="back" onclick="window.history();" />
			
			<%
		}
	%>
	<script>
function search(){
	var rowV=document.getElementById("rowVal").value;
	for(var i=0;i<rowV;i++){
		if(document.getElementById("radio"+i)!=null){
	if(document.getElementById("radio"+i).checked==true){
	var parent=document.getElementById("radio"+i).value;
	submitForm('searchGrn','stores?method=modifyGrn&parent='+parent);
		}
		}
		}
		}
function searchV(){
	var rowV=document.getElementById("rowVal").value;
	for(var i=0;i<rowV;i++){
		if(document.getElementById("radio"+i)!=null){
	if(document.getElementById("radio"+i).checked==true){
	var parent=document.getElementById("radio"+i).value;
	submitForm('searchGrn','stores?method=validateGrnScreen&parent='+parent);
		}
		}
		}
		}
</script>

<form name="searchGrn" method="post" action="">
<%if(message!=null){ %>

<%} %>
<div class="titleBg">
<h2>Update Reorder Level</h2>
</div>
<div class="clear paddingTop15"></div>

<div class="clear"></div>
<table>
<tr>
<th>Item Name</th>
<th>Max Stock</th>
<th>Min  Stock</th>
<th>Rol</th>
<th>Update Rol</th>
</tr>
<%for(StoreDeptReorderLevel relevel:storeDeptReorderLevelList){ %>
<tr>
<td><%=relevel.getItem().getNomenclature() %>
</td>
<td><input type="text" name="max" id="max" value="<%=relevel.getMaxStock() %>" /></td>
<td><input type="text" name="min" id="min" value="<%=relevel.getMinStock() %>" /></td>
<td><input type="text" name="rol" id="rol" value="<%=relevel.getRol() %>" /></td>
<td><input type="button" name="update" id="update" class="button" value="update" onclick="updateRol(<%=relevel.getId() %>);" /></td>
</tr>
<%} %>
</table>
<script>
function updateRol(id){
//alert("relevel Id"+id)
var max=document.getElementById("max").value;
var min=document.getElementById("min").value;
var rol=document.getElementById("rol").value;
//alert(max+"relevel Id"+id+"MIN=--->"+min+"rol------->"+rol)

submitForm('searchGrn','stores?method=updateROl&parent='+id+'&max='+max+'&min='+min+'&rol='+rol);
}

</script>

 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 </form>