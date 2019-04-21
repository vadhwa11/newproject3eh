<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * gruPara.jsp  
 * Purpose of the JSP -  This is showing State.
 * @author  Dipali
 * @author  Vishal
 * Create Date: 07th April,2009
 * Revision Date:      
 * Revision By:  
 * @version 1.14
--%>

<%@page import="jkt.hms.masters.business.DgMasTestKit"%>
<%@page import="jkt.hms.masters.business.SpGroupParameterM"%>
<%@page import="jkt.hms.masters.business.MasSpecialityParameter"%>
<%@page import="jkt.hms.masters.business.MasSpecialityGroup"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasSpecialityGroup"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>


<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%
	String userName = null;
	List<DgMasTestKit> dgMasTestKitList = null;
	Map<String, Object> utilMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if (map.get("testKit") != null) {
		Set<DgMasTestKit> kitSet = (Set<DgMasTestKit>) map
				.get("testKit");
		dgMasTestKitList = new ArrayList<DgMasTestKit>(kitSet);
	}

	String date = "";
	String time = "";
	try {
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if(map.get("message") != null){
		 String message = (String)map.get("message");
%>

<h4>
	<span><%=message %></span>
</h4>
<%}%>

<div class="titleBg">
	<h2>Lab Test Kit Mapping</h2>
</div>
<div class="clear"></div>
<%
	if (dgMasTestKitList.size() > 0) {
%>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div class="cmntable">
	<table border="0" cellspacing="0" width="100%" cellpadding="0">
		<tr>
			<th>Kit Name</th>
			<th>Investigation Name</th>
		</tr>
		<%
			for (DgMasTestKit kit : dgMasTestKitList) {

					if (kit.getInvestigation() != null) {
		%>
		<tr>
			<td><%=kit.getKitName()%></td>
			<td><%=kit.getInvestigation().getInvestigationName()%></td>
		</tr>

		<%
			}
				}
		%>
	</table>
</div>
<%
	}
%>
<form name="testKit" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<div class="paddingTop15"></div>
	<div class="clear"></div>
	<div class="Block">

		<label><span>*</span>Kit Name</label> <select name="testKitId"
			validate="Group,string,yes" tabindex=1>
			<%for(DgMasTestKit kit : dgMasTestKitList){%>
			<option value="<%=kit.getId()%>"><%=kit.getKitName()%></option>
			<%}%>
		</select> <label><span>*</span>Investigation Name </label> <input type="text"
			id="chargeCode" name="chargeCode" tabindex=1 value="">
			<div class="autocomplete" style="display: none;" id="ac2update"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
				new Ajax.Autocompleter(
						'chargeCode',
						'ac2update',
						'lab?method=getChargeCodeForAutoComplete&mainChargeCodeId=17&subChargeCodeId=0',
						{
							parameters : 'requiredField=chargeCode'
						});
			</script>
			<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<div id="edited"></div>

	<input type="button" name="add" id="addbutton" value="Add"
		class="button"
		onClick="submitForm('testKit','lab?method=addTestKitInLab');"
		accesskey="a" tabindex=1 />
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="bottom">
		<label> Changed By: </label> <label class="value"><%=userName%></label>
		<label> Changed Date: </label> <label class="value"><%=date%></label>
		<label> Changed Time: </label> <label class="value"><%=time%></label>
	</div>
</form>

