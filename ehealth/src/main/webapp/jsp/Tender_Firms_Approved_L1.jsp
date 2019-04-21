<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.StoreTenderM"%>
<%@page import="jkt.hms.masters.business.StoreTenderInvitationLetter"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>


<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascrip"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
</script>



<style type="text/css">
<!--
.locatorArrow {
	COLOR: #666666;
	FONT-FAMILY: Verdana;
	FONT-SIZE: 12px
}
</style>

<%
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	int deptId = 0;
	Box box = HMSUtil.getBox(request);
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}
 	
  	Map map = new HashMap();
  	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
	List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
	Vector supplier_ids = null;
	String message = null;
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		masStoreGroupList = (ArrayList)map.get("masStoreGroupList");
		storeTenderMList =   (ArrayList)map.get("storeTenderMList");
		
		if (map.get("message")!=null)
		{%>
<script>alert('<%=map.get("message").toString()%>');</script>
<%
		}
    }
	
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	if (session.getAttribute("deptId") != null) {
		Integer temp =  (Integer)session.getAttribute("deptId");
		deptId = temp.intValue();
	}
%>


<script>

function showReport()
{
	if (document.FirmsL1Form.<%=TENDER_NO%>.value=="" || document.FirmsL1Form.<%=TENDER_SUPPLIER_GROUP_ID %>.value=="")
	{
	alert('Pl. Check Your Inputs (Tender No & Group)');
	return;
	}
	
	document.FirmsL1Form.method="post";
	submitForm('FirmsL1Form','tender?method=generateTenderFirmsApprovedL1Report');
}

function onChangeTender()
{
//document.FirmsL1Form.<%=TENDER_SUPPLIER_GROUP_ID%>.options.length=1;
document.FirmsL1Form.method="post";
submitForm('FirmsL1Form','tender?method=showFirmsL1Jsp&groupId='+document.FirmsL1Form.<%=TENDER_SUPPLIER_GROUP_ID%>.value);
}
</script>
<div class="titleBg">
<h2>Firms Approved as L1</h2>
</div>
<form name="FirmsL1Form">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="hospitalId" size="5" value="<%=hospitalId%>"> 
<input type="hidden" name="deptId" size="5" value="<%=deptId%>"> 
<input type="hidden" name="date" size="5" value="<%=date%>">


<div class="clear"></div>
<h4>Firms Approved as L1</h4>
<div class="clear"></div>
<div class="Block"><label>Group</label> 
<select
	name="<%=TENDER_SUPPLIER_GROUP_ID %>" onChange="onChangeTender();">
	<option value="">Select Group</option>
	<%
		for (Iterator iterator = masStoreGroupList.iterator(); iterator.hasNext();) 
		{
			MasStoreGroup masStoreGroup = (MasStoreGroup)iterator.next();
		%>
	<option value="<%=masStoreGroup.getId()%>"
		<%=HMSUtil.isSelected(masStoreGroup.getId(),Integer.valueOf(box.getInt(TENDER_SUPPLIER_GROUP_ID)))%>><%=masStoreGroup.getGroupName()%></option>
	<%
		}
		%>
</select> <label class="medium">Tender No</label> <select name="<%=TENDER_NO%>">
	<option value="">Select Tender No</option>
	<%
		for (Iterator iterator = storeTenderMList.iterator(); iterator.hasNext();) 
		{
			StoreTenderM storeTenderM = (StoreTenderM)iterator.next();
		%>
	<option value="<%=storeTenderM.getId()%>"
		<%=HMSUtil.isSelected(storeTenderM.getId(),Integer.valueOf(box.getInt(TENDER_NO)))%>><%=storeTenderM.getTenderNo()%></option>
	<%
		}
		%>
</select> <label>Prior to PNC Rates </label> <input type="radio" name="pnc"
	class="radio" value="1" checked="checked" /> <label>Post PNC
Rates </label> <input type="radio" name="pnc" value="2" class="radio" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="report" onClick="showReport()" value="Submit" class="button">
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
