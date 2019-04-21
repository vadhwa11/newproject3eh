
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@ page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css"/>

<%
System.out.println("jsp");
Map<String,Object> map = new HashMap<String,Object>();

List<MasEmployee> suspendByList = new ArrayList<MasEmployee>();
String row="";
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}

if (map.get("suspendByList") != null) {
	suspendByList = (List<MasEmployee>) map.get("suspendByList");

}


/* System.out.println("jhkjgjk>>>"+hrMasShift.size()); */
%>
<div id="testDiv">



<label > <span>*</span>Order Issued By </label>
<select  name="suspendBy" 	tabindex=1  id="suspendBy" 	  validate="Order Issued By,string,yes" />

<%
if(suspendByList.size()>0){ %>

<option value="">Select</option>
	<%for(MasEmployee suspend : suspendByList){ %>

	<option value="<%=suspend.getId() %>"><%=suspend.getEmployeeName()+"  "+suspend.getRank().getRankName()%>
	</option>
	<%}%>
</select>


<%}else{ %>

<option value="">Select</option>

			  </select>
<%} %>	
	
</div>