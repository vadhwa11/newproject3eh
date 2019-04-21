<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>

<%@page import="jkt.hms.masters.business.MasStoreGroup"%>


<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<!-- Script for tab content -->
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js"></script>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<MasStoreGroup> storeGroupList = new ArrayList<MasStoreGroup>();
	
	if(map.get("storeGroupList")!=null)
	{
		storeGroupList = (List)map.get("storeGroupList");
	}

	%>

<div class="titleBg">
<h2>System Generated Item Wise Reorder Level</h2>
</div>
<div class="clear" align="left"></div>
<div align="center">
<form name="ROLGenerationList" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>	
	<select name="groupId" id="groupId"
			onchange="displayItemName(this.value)">
			<option value="0">Select</option>
			<%
				for(MasStoreGroup masGroup : storeGroupList){
	    	%>
			<option value="<%=masGroup.getId()%>"><%=masGroup.getGroupName()%></option>
			<%} %>
		</select>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div id="testDiv"></div>
</form>
</div>
<div class="paddingTop40"></div>

<script type="text/javascript">
function displayItemName(val){
	if(val !=null && val>0)
	{
		submitProtoAjaxWithDivName('ROLGenerationList','/hms/hms/purchaseOrder?method=getItemListByGroup&groupId='+val,'testDiv');
	}
 }
</script>