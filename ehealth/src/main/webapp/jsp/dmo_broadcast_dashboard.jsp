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
<form name="enquiryBroadcastdashBoard" method="post">
<div class="titleBg">
<h2>BroadCast DashBoard</h2>
</div>

<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>



<div class="clear"></div>
<div class="Block">
<label>District<span>*</span></label>
 <input type="text" name="district" value="<%=districtName != null?districtName:"" %>"  MAXLENGTH="8"  validate="district,string,yes"/> 
	
	<label>Institute Type<span>*</span></label>
 <input type="text" name="instituteType" value="<%=instituteTypeName != null?instituteTypeName:"" %>"  MAXLENGTH="8" validate="instituteType,string,yes"/> 
	
	<label>Institute Name<span>*</span></label>
 <input type="text" name="instituteName" value="<%=instituteName != null?instituteName:"" %>"  MAXLENGTH="8"  validate="instituteName,string,yes"/> 

</div>
<input type="button" name="Next/Update" type="submit" value="Delete"	onClick="submitForm('enquiryBroadcastdashBoard','stores?method=deleteBroadCast', 'validateRows');" class="button" />
<div id="pageNavPosition"></div>
<table>
	<tr>
	<th>Select</th>
	<th>Institute Name</th>
	<th>BroadCast No</th>
	<th>BroadCast Date</th>
	<th>BroadCast Type</th>
	
	</tr>
	<tbody id="tableData">
	<%
	int i = 0;
		if(broadCastMList.size()>0){
			for(StoreBroadcastEnquiryM broadcastEnquiryM :broadCastMList){
				//System.out.println("vailid up to=="+broadcastEnquiryM.getValidUpTo().equals(new Date()));
	
	%>
	<tr>
	<td><input type="radio" name="enquiryMId" id="enquiryMId<%=i %>" value="<%=broadcastEnquiryM.getId()%>" /></td>
	<td onclick="submitProtoAjax('enquiryBroadcastdashBoard','stores?method=showBroadCastItemDetail&broadCastEnquiryMId=<%=broadcastEnquiryM.getId()%>');"><%=broadcastEnquiryM.getInstitute()!= null?broadcastEnquiryM.getInstitute().getHospitalName():"" %></td>
	<td onclick="submitProtoAjax('enquiryBroadcastdashBoard','stores?method=showBroadCastItemDetail&broadCastEnquiryMId=<%=broadcastEnquiryM.getId()%>');"><%=broadcastEnquiryM.getBroadcastNo()!= null?broadcastEnquiryM.getBroadcastNo():"" %></td>
	<td onclick="submitProtoAjax('enquiryBroadcastdashBoard','stores?method=showBroadCastItemDetail&broadCastEnquiryMId=<%=broadcastEnquiryM.getId()%>');"><%=broadcastEnquiryM.getBroadcastDate()!= null?HMSUtil.convertDateToStringWithoutTime(broadcastEnquiryM.getBroadcastDate()):"" %></td>
	<td onclick="submitProtoAjax('enquiryBroadcastdashBoard','stores?method=showBroadCastItemDetail&broadCastEnquiryMId=<%=broadcastEnquiryM.getId()%>');"><%=broadcastEnquiryM.getBroadcastType()!= null?broadcastEnquiryM.getBroadcastType():"" %></td>
	
	</tr>
	
<%i++; 
				}}	%>
	</tbody>
</table>
<input type="hidden" name="cnt" id="cnt" value = "<%=i%>"/>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div id="testDiv"></div>


<!-- <input type="button" name="Next/Update" type="submit" value="Submit"	onClick="submitForm('enquiryBroadcastdashBoard','stores?method=submitDmoDashboardBroadData', 'validateRows');" class="button" />
<input type="button" name="Next/Update" type="submit" value="View"	onClick="submitForm('enquiryBroadcastdashBoard','stores?method=viewBroadCastStatusData');" class="button" />
 --><script type="text/javascript">
var pager = new Pager('tableData',5);
pager.init();
pager.showPageNav('pager', 'pageNavPosition');
pager.showPage(1);


function validateRows(){
	//alert("cnt=="+document.getElementById('cnt').value);
	var count = document.getElementById('cnt').value;
	for(var i=0;i<count;i++){
		if(document.getElementById('enquiryMId'+i).checked){
			return true;
		}

	}
	alert("Please select at least one row.");
	return false;
}




</script>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


