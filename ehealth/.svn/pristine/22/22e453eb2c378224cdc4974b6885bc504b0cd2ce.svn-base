<%@page import="jkt.hms.masters.business.HospitalDoctorUnitM"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasBed"%>

<%
		Map<String, Object> map = new HashMap<String, Object>();
	//	List<MasBed> itemList = new ArrayList<MasBed>();	
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
	/*	if(map.get("itemList")!= null){
			itemList = (List<MasBed>)map.get("itemList");
		}*/
		int counter = 0;
		if(map.get("counter") != null){
			counter = (Integer)map.get("counter");
		}
		
		String flag = "";
		if(map.get("flag") != null){
			flag = (String)map.get("flag");
		}
		/* List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>(); */
		List<MasBed> bedList = new ArrayList<MasBed>();
		List<HospitalDoctorUnitM>hospitalDoctorUnitMList=new ArrayList<HospitalDoctorUnitM>();
		if(map.get("bedList")!=null)
		{
			bedList = (List<MasBed>)map.get("bedList");
		}
		if(map.get("hospitalDoctorUnitMList")!=null)
		{
			hospitalDoctorUnitMList = (List<HospitalDoctorUnitM>)map.get("hospitalDoctorUnitMList");
		}
		String deptType="";
		if(map.get("deptType")!=null){
			deptType=(String)map.get("deptType");
		}
	//	MasStoreItem storeItem = itemList.get(0);
%>
<%-- <select name="batchId<%=counter %>" id="batchId<%=counter %>" tabindex="1">
<option value="0">Select</option> --%>
<%	
/* int itemId = 0;
int itemCategoryId = 0;
String expDate = "";
String batchNo = "";
if(batchList.size() > 0){ 
		for(StoreItemBatchStock batchStock:batchList){
			itemId = batchStock.getItem().getId();
			itemCategoryId = batchStock.getItem().getItemCategory()!=null?batchStock.getItem().getItemCategory().getId():0;
			expDate = batchStock.getExpiryDate()!=null?(HMSUtil.convertDateToStringWithoutTime( batchStock.getExpiryDate())):"";
			batchNo = batchStock.getBatchNo(); */
%>
<%-- <option value="<%=batchStock.getId() %>"><%=batchStock.getBatchNo() %></option> --%>

<%/* }
		} */%>
<!-- </select> -->
<%-- <input type="hidden" id="batchNo<%=counter %>" name="batchNo<%=counter %>" value="<%=batchNo%>" /> --%>
<div id="unitDiv">
<%

if("O".equals(deptType)){ %>
<label>Table <span> *</span></label>
<select name="bedName" id="bedId" validate="Table,int,yes">
<option value="0">Select</option>


<%if(bedList.size() > 0){ 
	for(MasBed bed:bedList){ %>
<option value="<%=bed.getId() %>"><%=bed.getBedNo() %></option>

<%} }%>
</select>
<label>Unit <span>*</span></label>
<select name="UnitName" id="UnitId"  validate="Unit,int,yes">
<option value="0">Select</option>


<%if(hospitalDoctorUnitMList.size() > 0){ 
	for(HospitalDoctorUnitM hospitalDoctorUnitM:hospitalDoctorUnitMList){ %>
<option value="<%=hospitalDoctorUnitM.getId()%>"><%=hospitalDoctorUnitM.getUnitCode() %></option>

<%} }%>
</select>

<%}else{ %>
<label>Unit <span>*</span></label>
<select name="UnitName" id="UnitId"  validate="Unit,int,yes">
<option value="0">Select</option>


<%if(hospitalDoctorUnitMList.size() > 0){ 
	for(HospitalDoctorUnitM hospitalDoctorUnitM:hospitalDoctorUnitMList){ %>
<option value="<%=hospitalDoctorUnitM.getId()%>"><%=hospitalDoctorUnitM.getUnitCode() %></option>

<%} }%>
</select>

<label>Bed No. <span> *</span></label>
<select name="bedName" id="bedId" validate="Table,int,yes">
<option value="0">Select</option>


<%if(bedList.size() > 0){ 
	for(MasBed bed:bedList){ %>
<option value="<%=bed.getId() %>"><%=bed.getBedNo() %></option>

<%} }%>
</select>

<%} %>
<div class="clear">
</div>
<%

if("O".equals(deptType)){ %>
<label>Day <span>*</span></label>
<select name="dayName" id="dayId" validate="day,string,yes">
<option value="">Select</option>
<option value="Monday">Monday</option>
<option value="Tuesday">Tuesday</option>
<option value="Wednesday">Wednesday</option>
<option value="Thursday">Thursday</option>
<option value="Friday">Friday</option>
<option value="Saturday">Saturday</option>
<option value="Sunday">Sunday</option>

</select>
<%} %>
</div>
<%-- <input type="hidden" id="itemCategoryId<%=counter %>" name="itemCategoryId<%=counter %>" value="<%= itemCategoryId %>">
<input type="hidden" name="expDate<%=counter %>" id="expDate<%=counter %>" value="<%=expDate %>">
<input type="hidden" name="costPrice<%=counter %>" id="costPrice<%=counter %>" value=""> --%>