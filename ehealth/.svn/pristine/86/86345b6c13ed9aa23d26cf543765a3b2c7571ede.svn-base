<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
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
function fillValues(){
var obj=document.getElementById("departmentId");
var departmentName=obj.options[obj.selectedIndex].text
submitForm('actualStockReport','/hms/hms/stores?method=generateActualStockReport&deptName='+departmentName+'');
}
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
	List<MasDepartment> departmentList=new ArrayList<MasDepartment>();
	List<MasStoreGroup> itemGroupList = new ArrayList<MasStoreGroup>();
    List<MasStoreItem>  itemList = new ArrayList<MasStoreItem>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	Map<String, Object> map = new HashMap<String, Object>();
	int deptId=(Integer)session.getAttribute("deptId");
	if(request.getAttribute("map")!=null){
	map=(Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("departmentList")!=null){
		departmentList=(List<MasDepartment>)map.get("departmentList");
	}
	if(map.get("itemGroupList")!=null){
		itemGroupList = (List)map.get("itemGroupList");
	}
	if(map.get("itemList")!=null){
		itemList =(List)map.get("itemList");
	}
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>
<form name="actualStockReport" method="post">
<div class="titleBg">
<h2>Actual Stock Report</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Service Centre</label>
<select name="departmentId" id="departmentId"  >
	<option value="0">select</option>
	<%for(MasDepartment masDepartment:departmentList){ 
if(deptId==masDepartment.getId()){%>
	<option value="<%=masDepartment.getId() %>" selected="selected"><%=masDepartment.getDepartmentName() %></option>
	<%}else{ %>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%}} %>
</select> 
<!-- <input type="hidden" name="departmentId" value="<%=deptId %>" /> --> 
<label>Item Group</label> 
<select name="<%=GROUP_NAME%>" id="itemGroupId"  
	onChange="submitProtoAjaxWithDivName('actualStockReport','/hms/hms/stores?method=getItemsForItemGroup','itemDiv');"
	onKeyUp="submitProtoAjaxWithDivName('actualStockReport','/hms/hms/stores?method=getItemsForItemGroup','itemDiv');">
	<option value="0">Select</option>
	<%for(MasStoreGroup masStoreGroup:itemGroupList){%>
	<option value="<%=masStoreGroup.getId()%>"><%=masStoreGroup.getGroupName()%></option>
	<%} %>
</select>
<div id="itemDiv">
<label>Item Name</label> 
<select name="<%=ITEM_NAME%>" id="itemName"  >
	<option value="0">Select</option>
	<%for(MasStoreItem masStoreItem:itemList){%>
	<option value="<%=masStoreItem.getId()%>"><%=masStoreItem.getNomenclature()%></option>
	<%} %>
</select></div>
<div class="clear"></div>

<label>Summary</label> 
<input type="radio" name="reportType"	value="<%=SUMMARY  %>" class="inputRadiobutton" checked="checked"	maxlength="30" tabindex=1  /> 
<label>Detail </label> 
<input	type="radio" name="reportType" value="<%=DETAIL  %>" class="inputRadiobutton"	maxlength="30" tabindex=1  /> 
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="buttonBig" value="Generate Report"	onclick="fillValues()">
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
	function removeAllOptions(selectbox)
	{
		var i;
		for(i=selectbox.options.length-1;i>=0;i--)
		{
			selectbox.remove(i);
		}
	}	
</script>
<%departmentList.clear();
itemGroupList.clear();
itemList.clear();
%>