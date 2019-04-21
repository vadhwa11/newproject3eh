<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<%
Map<String, Object> map = new HashMap<String, Object>();
List<MasStoreItem> itemList=new ArrayList<MasStoreItem>();

if(request.getAttribute("map")!=null)
{
	map=(Map<String, Object>)request.getAttribute("map");
}
if(map.get("itemList")!=null)
{
	itemList=(List<MasStoreItem>)map.get("itemList");
}
%>

<label id="">Exclude</label> 
<select multiple="5"	id="excludeitemId" name="excludeitemId" class="listBig" >	<%
	for(MasStoreItem item:itemList)
	{
	%>
	<option value="<%=item.getId()%>"><%=item.getNomenclature()%></option>
	<%} %>
</select>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
