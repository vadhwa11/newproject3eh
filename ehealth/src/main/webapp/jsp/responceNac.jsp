<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>


<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}

List<Object[]> indenList = new ArrayList<Object[]>();
if(map.get("indentTs") !=null){
	indenList=(List<Object[]>)map.get("indentTs");
}
 System.out.println("indenList=="+indenList.size());
%>



<table width="98%"  id="defectiveDetails" >
			<tr>
				<th>Item Code</th>
				<th>Item Name</th>
				<!-- <th>a/u</th> -->
				<th>NAC Qty</th>
			</tr>
			
	<%if(indenList.size()>0){
		for(Object[] indentT : indenList){%>
<tr>
		 
<td><%= indentT[0]%></td>
<td><%= indentT[1]%></td>
<%-- <td> <%= indentT.getItem().getItemConversion().getItemUnitName()%></td> --%>
<td><%= indentT[2]%></td>
</tr>


<%}
	}
		else{%>
	<% out.println("No Record."); %>
	<%	
	
		}
		%>
		
</table>
