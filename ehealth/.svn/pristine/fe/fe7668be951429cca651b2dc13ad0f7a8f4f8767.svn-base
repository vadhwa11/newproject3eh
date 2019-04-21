
<%@page import="java.util.Date"%>
<%@page import="jkt.hms.masters.business.HrInstituteAuthLevelDetails"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.io.IOException"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Properties"%>
<%@page import="java.util.HashMap"%>


<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHEQUE_DATE "%>
<%@ page import="static jkt.hms.util.RequestConstants.CHEQUE_NO "%>
<%@ page import="static jkt.hms.util.RequestConstants.BANK_NAME "%>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}
	int val=0;
	if(map.get("val")!=null){
		val=(Integer)map.get("val");
	}
	List<Object[]>serviceList=new ArrayList<Object[]>();
	if(map.get("serviceList")!=null){
		serviceList=(List<Object[]>)map.get("serviceList");
	}
	String service="";
	if(map.get("service")!=null){
		service =(String)map.get("service");
	}
if(service.equals("inv")){
%>
<table>
<tr>
<th>Sr No.</th>
<th>Investigation Name</th>
<th>Date</th>
<th>Time</th>
<th>Select</th>
</tr>
<%
int i=1;
for(Object[] obj:serviceList){ %>
<tr>
<td><%=i %></td>
<td><%=obj[1] %></td>
<td><%=HMSUtil.convertDateToStringTypeDateOnly((Date)obj[2]) %></td>
<td><%=obj[3] %></td>
<td><input type="checkbox" value="cancel" id="statusId<%=i %>" name="status"  onclick="setStatus('<%=i %>');" />
<input type="hidden" value="n" name="canStatus" id="canStatId<%=i %>"  />
<input type="hidden" value="<%=obj[0] %>" name="detailId" id="detailId<%=i %>"  />
</td>
</tr>

<%i++;} %>
</table>
<div class="clear"></div>
<input type="button" value="cancel" onclick="cancelInvData2();" />
<div class="clear"></div>
<%}else if(service.equals("presc")){ %>
<table>
<tr>
<th>Sr No.</th>
<th>Nomenclature</th>
<th>Date</th>
<th>Time</th>
<th>&nbsp;</th>
</tr>
<%
int i=1;
for(Object[] obj:serviceList){ %>
<tr>
<td><%=i %></td>
<td><%=obj[1] %></td>
<td><%=HMSUtil.convertDateToStringTypeDateOnly((Date)obj[2]) %></td>
<td><%=obj[3] %></td>
<td>
<input type="checkbox" value="cancel" id="PresstatusId<%=i %>" name="status" onclick="setStatusPresc('<%=i %>');" />
<input type="hidden" value="n" name="canPrescStatus" id="canPrescStatId<%=i %>"  />
<input type="hidden" value="<%=obj[0] %>" name="detailPrescId" id="detailId<%=i %>"  />

</td>
</tr>
<%i++;} %>
</table>
<div class="clear"></div>
<input type="button" value="cancel" onclick="cancelPresData2();" />
<%}else if(service.equalsIgnoreCase("diet")){ %>
<table>
<tr>
<th>Sr No.</th>
<th>Diet Name</th>
<th>Datee</th>
<th>Time</th>
<th>&nbsp;</th>
</tr>
<%
int i=1;
for(Object[] obj:serviceList){ %>
<tr>
<td><%=i %></td>
<td><%=obj[1] %></td>
<td><%=obj[1] %></td>
<td><%=obj[1] %></td>
<td><input type="checkbox" value="cancel" id="DietstatusId<%=i %>" name="status" onclick="setStatusDiet('<%=i %>');" />
<input type="text" value="n" name="canDietStatus" id="canDietStatId<%=i %>"  />
<input type="hidden" value="<%=obj[0] %>" name="detailDietId" id="detailId<%=i %>"  />
</td>
</tr>
<%i++;} %>
</table>
<div class="clear"></div>
<input type="button" value="cancel" onclick="cancelDietData();" />
<div class="clear"></div>
<%}else if(service.equalsIgnoreCase("procId")){ %>
<table>
<tr>
<th>Sr No.</th>
<th>Procedure Name</th>
<th>&nbsp;</th>
</tr>
<%
int i=1;
for(Object[] obj:serviceList){ %>
<tr>
<td><%=i %></td>
<td><%=obj[1] %></td>
<td><input type="button" value="cancel" onclick="cancelInvData(<%=obj[0] %>,'<%=service %>')" /></td>
</tr>
<%i++;} %>
</table>
<%}else if(service.equalsIgnoreCase("trans")){ %>
<table>
<tr>
<th>Sr No.</th>
<th>Transferred To</th>
<th>&nbsp;</th>
</tr>
<%
int i=1;
for(Object[] obj:serviceList){ %>
<tr>
<td><%=i %></td>
<td><%=obj[1] %></td>
<td><input type="button" value="cancel" onclick="cancelInvData(<%=obj[0] %>,'<%=service %>')" /></td>
</tr>
<%i++;} %>
</table>

<%}else if(service.equalsIgnoreCase("dis")){ %>
<table>
<tr>
<th>Sr No.</th>
<th>UHID</th>
<th>Patient Name</th>

<th>Discharge From</th>
<th>&nbsp;</th>
</tr>
<%
int i=1;
for(Object[] obj:serviceList){ %>
<tr>
<td><%=i %></td>
<td><%=obj[3] %></td>
<td><%=obj[2] %></td>
<td><%=obj[1] %></td>
<td><input type="button" value="cancel" onclick="cancelInvData(<%=obj[0] %>,'<%=service %>')" /></td>
</tr>
<%i++;} %>
</table>
<%}%>