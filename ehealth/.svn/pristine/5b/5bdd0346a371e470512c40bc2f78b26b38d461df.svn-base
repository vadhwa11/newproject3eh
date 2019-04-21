<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
Map<String, Object> map = new HashMap<String, Object>();
List<MasChargeCode> chargeCodeList=new ArrayList<MasChargeCode>();

if(request.getAttribute("map")!=null)
{
	map=(Map<String, Object>)request.getAttribute("map");
}
if(map.get("chargeCodeList")!=null)
{
	chargeCodeList=(List<MasChargeCode>)map.get("chargeCodeList");
}
%>

<label id="">Exclude</label> 
<select multiple="5"	id="excludechargeId" name="excludechargeId" class="listBig" >
	<%
	for(MasChargeCode chargeCode:chargeCodeList)
	{
	%>
	<option value="<%=chargeCode.getId()%>"><%=chargeCode.getChargeCodeName()%></option>
	<%} %>
</select>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
