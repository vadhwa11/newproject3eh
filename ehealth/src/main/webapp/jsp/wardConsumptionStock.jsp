<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
List<String> stockItemList = new ArrayList<String>();
if(map.get("stockItemList") != null){
	stockItemList = (List<String>)map.get("stockItemList");
}
int counter=0;
if(map.get("counter")!=null){
	counter=(Integer)(map.get("counter"));
}
%>
<select name="batchNo<%=counter%>" id="batchNo<%=counter%>" onchange="populateClosingStock(this.value,<%=counter%>)" >
<option value="0">Select Batch No</option>
	<%     	if (stockItemList!=null && stockItemList.size() > 0 )
	     	{		for(int i=0;i<stockItemList.size();i++)
	    			{ String batchNo = (String)stockItemList.get(i);
			%>
			<option value="<%=batchNo%>"><%=batchNo%></option>
	<%
	     			}
			}else
			{
			}
     	 %>
</select>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
