
<%@page import="jkt.hms.masters.business.OpdPatientAllergyT"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>


<head>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css"    id="vbulletin_css" />
<script type="text/javascript" language="javascript"    src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"    src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"    src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"    src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"    src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"    src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
</head>
<%
    Map map = new HashMap();
    List<OpdPatientAllergyT> allergyTs=new ArrayList<OpdPatientAllergyT>();
    Box box = HMSUtil.getBox(request);


    if (request.getAttribute("map") != null)
    {
        map = (Map) request.getAttribute("map");
}
    
    if(map.get("allergyTs")!=null){
    	allergyTs=(List<OpdPatientAllergyT>)map.get("allergyTs");
	}
    boolean LP = false;
    if(map.get("LP")!=null){
    	LP=(Boolean)map.get("LP");
	}
    	
   
%>

<div id="mainIn">
<form name="manufactureDetail" action="" method="post" enctype="multipart/form-data">
<div class="titleBg">
<div class="clear"></div>
<h4>Allergy Details</h4>
<div class="cmntable">
<table width="70%" colspan="7" id="itemDetails" border="0"     cellpadding="0" cellspacing="0">
    <% int i=0;
      if (allergyTs.size() > 0) {%>
<thead>
		<tr>
		<th scope="col">Type</th>
		<th scope="col">Allergen</th>
		
		<%if(LP){ %>
		<th scope="col">Remarks</th>
		<%} else{%>
		<th scope="col">Severity</th>
		<th scope="col">Since:Month</th>
		<th scope="col">Year</th>
		<th scope="col">Status</th>
		<%} %>
		</tr>
      <tbody>
  
			<% for (OpdPatientAllergyT st : allergyTs) {%>
			<tr>
			<td><input type="text" value="<%=st.getAllergy()!=null ?st.getAllergy().getProductName():""%>" readonly="readonly"></td>
			<td><input type="text" value="<%=st.getAllergen()!=null ?st.getAllergen():""%>" readonly="readonly"></td>
			<%if(LP){ %>
			<td><input type="text" value="<%=st.getAllergyRemarks()!=null ?st.getAllergyRemarks():""%>" readonly="readonly"></td>
			<%} else{%>
			<td><input type="text" value="<%=st.getSeverity()!=null ?st.getSeverity().getSeverityName():""%>" readonly="readonly"></td>
			<td><input type="text" value="<%=st.getFromMonth()!=null ? st.getFromMonth():""%>" readonly="readonly"></td>
			<td><input type="text" value="<%=st.getFromYear()!=null ?st.getFromYear():""%>" readonly="readonly"></td>
				
			<td>
			<%
		if(st.getStatus()!=null && st.getStatus().equals("1"))
		{
			%>
			Active
			<%
		}
		else if(st.getStatus()!=null && st.getStatus().equals("2"))
		{
			%>
			InActive
			<%
		}
		%>
			</td>
			<%} %>
			</tr>
		<%
		i++;
				}%>
      </tbody>
      <%}else{%>
				<h1>No Record Available.</h1>
		<% 	}
			%>	
</table>
</div>
<input type="button" name="Submit" class="button" value="Close"
	onclick="javascript:closeWin();" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
<script type="text/javascript">
function closeWin() {
    window.close();   
}
</script>

