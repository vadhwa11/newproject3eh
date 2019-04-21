<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" src="/hms/jsp/js/balloontip.js">

/***********************************************
* Rich HTML Balloon Tooltip- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

</script>
<%
	List<MasEmployee> subordinateList = null;
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
	}
	if(map.get("subordinateList")!=null)
	{
		subordinateList = (List)map.get("subordinateList");
	}
	session.setAttribute("map",map);
%>
<div id="balloon" class="balloonstyle">
<%
if(subordinateList!=null && subordinateList.size()!=0){
	for(MasEmployee employee:subordinateList){
%> <label><%= employee.getFirstName() + " " + employee.getLastName()%></label>

<%}
}%>
</div>

<a href="#" rel="balloon">Subordinates List</a>
<a href="personnel?method=printSubordinateList">Print</a>