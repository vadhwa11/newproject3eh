
<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<Object []> closingItemList= new ArrayList<Object []>();
if(map.get("closingItemList") != null){
	closingItemList = (List)map.get("closingItemList");
}
int counter=0;
if(map.get("counter") != null){
	counter = (Integer)map.get("counter");
}
%>
<%@page import="java.util.Iterator"%>

	<%	if(closingItemList.size() !=0){

		for (Iterator iterator = closingItemList.iterator(); iterator.hasNext();) {

			Object[] closingStockItem = (Object[]) iterator.next();

			Date expiryDate =(Date)closingStockItem[0];
			BigDecimal closingStock=(BigDecimal)closingStockItem[1];
%>

<%@page import="jkt.hms.util.HMSUtil"%>
<td><input type="text" name="expDate<%=counter%>" id="expDate<%=counter%>" readonly="readonly" value="<%=HMSUtil.convertDateToStringWithoutTime(expiryDate)%>" size="20"/></td>
 <td> <input type="text" id="closeStock<%=counter%>"  name="closeStock<%=counter%>" size="20" value="<%=closingStock.intValue()%>" readonly="readonly"></input></td>
 <%-- <script type="text/javascript" >
 alert( document.getElementById('closeStock<%=counter%>'));
 document.getElementById('closeStock<%=counter%>').value='<%=closingStock%>';
 </script> --%>
<%} %>
	<%}else{%>
	<li>----------No Items found-------------</li>
	<%} %>




<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

