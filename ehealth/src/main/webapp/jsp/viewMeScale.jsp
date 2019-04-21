<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreMeScaleDetails"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Collections"%>
<%@page import="jkt.hms.util.Box"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.masters.business.MasStoreMeScale"%>


<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />
<script type="text/javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
</script>
<style type="text/css">
.locatorArrow {
	COLOR: #666666;
	text-align: center;
	FONT-FAMILY: Verdana;
	FONT-SIZE: 12px;
}
</style>
<script language="javascript">
		
		//this function will be called by the Bean (not from JSP)
	
	function goPage(pidx) {	
	viewMeScaleForm.currPage.value = pidx;
	viewMeScaleForm.method="post";
	submitForm('viewMeScaleForm','neStores?method=getMeScaleData');
	}

		function openPopupWindow()
		{
		var meScaleMasterId = document.viewMeScaleForm.<%=ME_SCALE_NUMBER %>.value;
		if(meScaleMasterId ==0){
		alert("Please select ME Scale number..!")
		return false;
		}
		var meScaleMasterId = document.viewMeScaleForm.<%=ME_SCALE_NUMBER %>.value;
		var url="/hms/hms/neStores?method=viewMeScaleAdditionJsp&meScaleMasterId="+meScaleMasterId;
		newwindow=window.open(url,'name','top=50, left=50, height=600,width=950');
		}
		
	
		function upd()
		{
		var meScaleMasterId = document.viewMeScaleForm.<%=ME_SCALE_NUMBER %>.value;
		if(meScaleMasterId ==0){
		alert("Please select ME Scale number..!")
		return false;
		}
		
		viewMeScale.method="post";
		submitForm('viewMeScaleForm','neStores?method=updateGridItemsInViewMeScale');
		}
		



function validateDeleteButton()
{
	if (viewMeScaleForm.<%=ITEMS_TO_BE_DELETED%>.length)
	{
			 for(var i = 0; i < viewMeScaleForm.<%=ITEMS_TO_BE_DELETED%>.length; i++)
			 {
			  if (viewMeScaleForm.<%=ITEMS_TO_BE_DELETED%>[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (viewMeScaleForm.<%=ITEMS_TO_BE_DELETED%>.checked == true)
			return true;
	}
	return false;
}

function del()
{
	if (validateDeleteButton())
	{
	viewMeScaleForm.method="post";
	submitForm('viewMeScaleForm','neStores?method=deleteMeScaleItems');
	}
	else
	{
	alert('No Item(s) Selected for delete!....');
	}
}


		</script>
<%
		StringBuffer orderDateOnly = new StringBuffer();
		GregorianCalendar gregorianCalendar1 = new GregorianCalendar();
		int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
		if (dateOfMonth < 10) 
			{
		orderDateOnly.append("0");
		orderDateOnly.append(dateOfMonth);
		} else 
		{
		orderDateOnly.append(dateOfMonth);
		}
		orderDateOnly.append("/");
		int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
		if (month < 10) 
		{
		orderDateOnly.append("0");
		orderDateOnly.append(month);
		} else 
		{
		orderDateOnly.append(month);
		}
		orderDateOnly.append("/");
		int year = gregorianCalendar1.get(Calendar.YEAR);
		orderDateOnly.append(year);
		String currentDate = new String(orderDateOnly);
			%>
<%
		List<MasStoreMeScale> searchMeScaleList = new ArrayList<MasStoreMeScale>();
		Map map = new HashMap();
		String includedJsp = null;
		String previousPage="no";
		int pageNo=1;
		Box box=HMSUtil.getBox(request);
  		HashMap[] gridData =null;
		PagedArray pagedArray = null;
		String userName = "";
		String PvmsNo="";
		int ItemId = 0;
		if(request.getAttribute("map") != null)
		{
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
		}
		if(map.get("searchMeScaleList") !=null){
			searchMeScaleList=(List<MasStoreMeScale>)map.get("searchMeScaleList");
		}
		if(map.get("box") !=null){
			box=(Box)map.get("box");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTime");
		String title=(String)map.get("title");
    	
    	
		Vector<HashMap> meScaleItems= null;
		if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
		try{
		if(box.getString("meScaleDesc").equals("") || box.getString("meScaleDesc") !=null ){
			if(map.get("meScaleDesc") !=null)
			box.put("meScaleDesc",""+map.get("meScaleDesc"));
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	 	}
			%>
<br />
<h2 align="left" class="style1">ME Scale Equipment Details</h2>
<div id="contentspace">
<form name="viewMeScaleForm" method="post"><input type="hidden"
	name="numOfRows" size="5" value="5"> <input type="hidden"
	name="pageCount" size="5" value="10">
<table class="tborder" width="100%" align="center">
	<tr>
		<td width="20%" nowrap="nowrap" class="vbmenu_control" id="">
		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>
		<table width="20%" align="right" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="5%"><IMG SRC="/hms/jsp/images/toolBar_01.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
				<td width="7%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Add" value="Add" class="toolbutton"
					onClick="openPopupWindow();"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Update" type="submit" value="Modify"
					onClick="upd();" class="toolbutton"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="View" type="submit" value="Reset"
					class="buttonHighlight"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Delete" type="submit" value="Delete"
					class="toolbutton" onclick="del();"></td>
				<td width="4%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Print" type="submit" class="toolbutton"
					value="Print" onClick=""></td>
				<td width="39%"><IMG SRC="/hms/jsp/images/closeButton.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<br> <input type="hidden" name="pageNo" value="<%=pageNo%>"
	id="pageNo" /> <input type="hidden" name="hospitalId"
	value="<%=HOSPITAL_ID%>" id="hospitalId" /> <input type="hidden"
	name="departmentId" value="<%=DEPARTMENT_ID%>" id="departmentId" /> <input
	type="hidden" size="2" value="" name="<%=NO_OF_ROWS%>"
	id="<%=NO_OF_ROWS%>" /> <label class="bodytextB">MEScaleNumber:</label>
<select name="<%=ME_SCALE_NUMBER%>" c
	onchange="submitForm('viewMeScaleForm','neStores?method=getMeScaleDescription');" />
<option value="0">Select</option>
<%
					for (MasStoreMeScale mEScaleNumber : searchMeScaleList) {
					%>
<option value=<%=mEScaleNumber.getId()%>
	<%=HMSUtil.isSelected(mEScaleNumber.getId().toString(),box.getString("meScaleNumber")) %>><%=mEScaleNumber.getMeScale()%></option>
<% } %> </select><br />

<label class="bodytextB">MeScale Description : </label> <textarea
	name="<%=ME_SCALE_DESCRIPTION%>" MAXLENGTH="256" cols="27" rows="2"
	id="Authority" class="txtarea"><%=box.getString("meScaleDesc")%></textarea>

<br />
<% if (pagedArray == null) { %>
<div
	style="overflow: hidden; width: 100%; height: 220px; padding-left: 9px;">
<table width="100%" colspan="7" id="viewMeScale" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td width="10%"><label valign="left" class="smalllabel">S.No.</label></td>
			<td width="10%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Old
			Niv No</label></td>
			<td width="18%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="10%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="10%"><label valign="left" class="smalllabel">Section</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Quantity</label></td>

		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=8>No Data Found</td>
		</tr>
	</tbody>
</table>
</div>
<% } else { %>
<div
	style="overflow: hidden; width: 100%; height: 220px; padding-left: 9px;">
<table width="100%" colspan="7" id="viewMeScale" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td width="10%"><label valign="left" class="smalllabel">S.No.</label></td>
			<td width="10%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Old
			Niv No</label></td>
			<td width="18%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="10%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="10%"><label valign="left" class="smalllabel">Section</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Quantity</label></td>

		</tr>
	</thead>
	<tbody>
		<%
			    gridData = (HashMap[])pagedArray.getPagedArray();
				int iFirstRow = pagedArray.getFirstRowIdx();
			    for(int i=0;i<gridData.length;i++)
			    { %>
		<tr>
			<td width="10%"><input type="text" value="<%=iFirstRow++%>"
				class="smcaption" name="<%=ME_SCALE_SRNO%>" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("pvms")%>" class="medcaption" name="pvms"
				readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("oldpvms") ==null?"":gridData[i].get("oldpvms")%>"
				class="medcaption" name="oldpvms" readonly="readonly" /></td>
			<td width="18%"><input type="text"
				value="<%=gridData[i].get("nomenclature")%>" class="bigcaption"
				name="nomenclature" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("au")==null?"":gridData[i].get("au")%>"
				class="medcaption" name="au" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("section") ==null?"":gridData[i].get("section")%>"
				name="section" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("qty")  ==null?"":gridData[i].get("qty")%>"
				validate="Qty ,floatWithoutSpaces,no" maxlength="9"
				class="medcaption" name="qty" /></td>
			<td align="center" width="4%"><input type="checkbox"
				style="width: 100px;" name=<%=ITEMS_TO_BE_DELETED%>
				value="<%=gridData[i].get("id")%>"></td>
			<td width="10%"><input type="hidden"
				value="<%=gridData[i].get("id")%>" class="medcaption" name="id" />
			</td>
		</tr>
		<% } %>
		<tr class="locatorArrow">
			<td colspan=7 align="center"><%= pagedArray.showIndex()%> <%=pagedArray.getPageIndexHiddenTag()%></td>
		</tr>
	</tbody>
</table>
<% } %>
</div>
<label class="bodytextB">Changed By:</label>
<div class="changebydt"><%=userName%></div>

<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=date%></div>

<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=time%></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>