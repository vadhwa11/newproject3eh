<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}

List<MasHospital> healthBlock = new ArrayList<MasHospital>();
if(map.get("healthBlock") !=null){
	healthBlock=(List<MasHospital>)map.get("healthBlock");
	System.out.println("healthBlock"+healthBlock.size());
}

%>
 <div id="healthblock">
<label><span>*</span> Health Block</label>
<select name="healthBlock" id="healthBlockId" validate="Health block,int,yes" onchange="submitProtoAjaxWithDivName('dashboardTarget','/hms/hms/pubHealth?method=getBasicCenterList&chcphc='+this.value,'testDiv');getListCenter();">
<%	if(healthBlock.size() >0){%>
				<option value="0">ALL</option>
				 <%
				 for (MasHospital obj : healthBlock) {
				  %>
				  <option value="<%=obj.getId ()%>"><%=obj.getHospitalName()%></option>
				  <%
				  	}
				 } else{
				   %>
				   <option value="0">ALL</option>
				   <%} %>

</select>
</div>
