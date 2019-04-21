<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasLionc"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasLionc> masLioncList = new ArrayList<MasLionc>();
if(map.get("masLioncList") != null){
	masLioncList = (List<MasLionc>)map.get("masLioncList");
}

%>


<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<ul>
<%	if(masLioncList.size() !=0){
		for (Iterator iterator = masLioncList.iterator(); iterator.hasNext();) {
			MasLionc masLionc= (MasLionc) iterator.next();
		    String lionClass = masLionc.getMasClass();
		    String lionNo=masLionc.getId();

%>
   <li > <%=lionClass%>
 <input type=hidden name="lionNo" id="lionNo" value=<%=lionNo%> />
 </li>
 <% }%>
<%}else{%>
 <li>----------No Items found-------------</li>
<%} %>
</ul>
<script >
	function getBatchSizeInJsp()
	{
	alert("called");
		if (document.getElementById("itemName").value!="")
		{
			submitForm('indentDetail','production?method=getBatchSizeFromItemMaster');
		}
	}
</script>


