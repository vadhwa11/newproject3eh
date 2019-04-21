

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.masters.business.*"%>

<%@page import="jkt.hms.masters.business.*"%>



<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%
	
		Map map = new HashMap();
		List<MasApplication> appList = new ArrayList<MasApplication>();
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		
		if (map.get("appList") != null)
			appList =(List<MasApplication>)map.get("appList");
		
		
%>

<div class="clear"></div>

<div class="paddingTop15"></div>
<div class="cmntable">
<table cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="15">S.No</th>
			<th>Application Id</th>
			<th>Application Description</th>
			<th>Select Application To Move</th>
		</tr>
	</thead>
	<tbody id="searchresulttable">
		<%	
           		
           		int i=0;
   			for(MasApplication app : appList)
   				{
 				i++;
	        %>
		<tr class="<% if(i %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><input type="text" id="srNo<%=i%>" name="srNo" size="2"	value="<%=i%>" /></td>
			<td><input type="text" size="5" id="appIdToSwap<%=i%>"	name="appIdToSwap" value="<%=app.getId()%>" />
			</td>
			<td>
			<input type="hidden" id="orderNo<%=i%>"	name="orderNo" value="<%=app.getOrderNo()!=null?app.getOrderNo():0 %>" />
			<input type="text" id="appName<%=i%>" name="appName"	value="<%=app.getName() %>" /></td>
			<td><input type="radio" name="appId" class="checkbox"	value="<%=app.getId() %>" /></td>
		</tr>
		<%}%>
	</tbody>
</table>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="hidden" id="chkStatus" value="no" />
<input type="button" name="moveApp" value="Move UP " class="button"	onClick="swapApplication();" />

<input type="button" value="Submit" class="button"	onClick="submitForm('changeOrderForm','superAdmin?method=submitSwapApplication')" />
<input type="button" name="Back" value="Back" class="button" accesskey="b"	onclick="submitFormForButton('changeOrderForm','superAdmin?method=showModuleManagementJsp')"
	tabindex=1 />







