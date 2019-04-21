
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.*"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasEmployee> masEmployeeList= new ArrayList<MasEmployee>();
if(map.get("masEmployeeList") != null){
	masEmployeeList = (List)map.get("masEmployeeList");
}
int counter=0;
if(map.get("counter") != null){
	counter = (Integer)map.get("counter");
}
%>
<%@page import="java.util.Iterator"%>

	<%	if(masEmployeeList.size() !=0){

		for (Iterator iterator = masEmployeeList.iterator(); iterator.hasNext();) {

			MasEmployee e = (MasEmployee) iterator.next();

			String d = e.getRank().getRankName();
			
%>

<%@page import="jkt.hms.util.HMSUtil"%>

<td>
<%if(d!=null){ %>
<input  type="text"   id="desigation<%=counter%>"   name="desigation<%=counter%>" value="<%=d%>"  readonly="readonly"  size="30"/>
<%}else{ %>
<input  type="text"  id="desigation<%=counter%>"  name="desigation<%=counter%>" value="No Data"  readonly="readonly"  size="30"/>
<%} %>
</td>
<%} %>
	<%}else{%>
<input  type="text"  id="desigation<%=counter%>"  name="desigation<%=counter%>" value="No Data"  readonly="readonly"  size="30"/>
	<%} %>




