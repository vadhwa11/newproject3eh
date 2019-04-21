<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * departmentIndentjsp
 * Purpose of the JSP -  This is for Department Indent.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 08th Feb, 2008
 * Revision Date:
 * Revision By:
 * @version 1.5
--%>
<%@page import="jkt.hms.masters.business.StoreBroadcastStatus"%>
<%@page import="jkt.hms.masters.business.StoreBroadcastEnquiryM"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.ItemGroup"%>
<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>

<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.MasItemType"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasItemClass"%>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script> 
<script type="text/javascript" language="javascript" src="/hms/jsp/js/addRow.js"></script>
<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year1=calendar.get(calendar.YEAR);
		if(month1.length()<2){
		month1="0"+month1;
		}
		if(date1.length()<2){
		date1="0"+date1;
		}
	%>
		serverdate = '<%=date1+"/"+month1+"/"+year1%>'
	</script>


<%
	Map<String,Object> map = new HashMap<String,Object>();

	Box box = HMSUtil.getBox(request);
	

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<MasHospital> hospitalList = new ArrayList<MasHospital>();
	List<StoreBroadcastEnquiryM> broadCastMList = new ArrayList<StoreBroadcastEnquiryM>();
	
	if(map.get("hospitalList") != null){
		hospitalList = (List)map.get("hospitalList");
	}
	if(map.get("broadCastMList") != null){
		broadCastMList = (List)map.get("broadCastMList");
	}
	String districtName = "";
	String instituteTypeName = "";
	String instituteName = "";
	if(hospitalList.size()>0){
		MasHospital masHospital = hospitalList.get(0);
		if(masHospital.getDistrict() != null){
			districtName = masHospital.getDistrict().getDistrictName();
		}
		if(masHospital.getHospitalType() != null){
			instituteTypeName = masHospital.getHospitalType().getHospitalTypeName();
		}
		if(masHospital.getHospitalName() != null){
			instituteName = masHospital.getHospitalName();
		}
	}
%>
<form name="enquiryBroadcastdashBoardInstitute" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>BroadCast DashBoard</h2>
</div>

<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>



<div class="clear"></div>
<div class="Block">
<label>District<span>*</span></label>
 <input type="text" name="district" value="<%=districtName != null?districtName:"" %>"  MAXLENGTH="8"  validate="district,metachar,yes"/> 
	
	<label>Institute Type<span>*</span></label>
 <input type="text" name="instituteType" value="<%=instituteTypeName != null?instituteTypeName:"" %>"  MAXLENGTH="8" validate="instituteType,metachar,yes" /> 
	
	<label>Institute Name<span>*</span></label>
 <input type="text" name="instituteName" value="<%=instituteName != null?instituteName:"" %>"  MAXLENGTH="8" validate="instituteName,metachar,yes" /> 

</div>
<div id="pageNavPosition"></div>
<table>
	<tr>
	
	<th>Institute Name</th>
	<th>BroadCast No</th>
	<th>BroadCast Date</th>
	
	</tr>
	<%
	int i = 1;	
	if(broadCastMList.size()>0){
			for(StoreBroadcastEnquiryM broadcastEnquiryM :broadCastMList){
	
	%>
	<tbody id="tableData">
	<tr onclick="submitProtoAjax('enquiryBroadcastdashBoardInstitute','stores?method=showBroadCastItemDetailInstitute&broadCastEnquiryMId=<%=broadcastEnquiryM.getId()%>');">
	
	<td><%= broadcastEnquiryM.getInstitute()!= null?broadcastEnquiryM.getInstitute().getHospitalName():"" %>
	</td>
	<td><%=broadcastEnquiryM.getBroadcastNo() != null?broadcastEnquiryM.getBroadcastNo():"" %></td>
	<td><%= broadcastEnquiryM.getBroadcastDate()!= null?HMSUtil.convertDateToStringWithoutTime(broadcastEnquiryM.getBroadcastDate()):"" %></td>
	
	</tr>
	
<% i++;}}	%>
	</tbody>
</table>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div id="testDiv"></div>



<script type="text/javascript">
var pager = new Pager('tableData',5);
pager.init();
pager.showPageNav('pager', 'pageNavPosition');
pager.showPage(1);

function validateRows(){
	var count = document.getElementById('hdb').value;
	for(var i=1;i<count;i++){
		if(document.getElementById('srNo'+i).checked){
			return true;
		}

	}
	alert("Please select at least one row.");
	return false;
}

</script>
</form>


