
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreWorkOrderT"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/nonExp?method=showImportedItemReportJsp";
  obj.submit();
  }
</script> <script type="text/javascript" language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script> <script type="text/javascript">
function check(){
var SDate = document.importedItem.<%= FROM_DATE%>.value;
var EDate = document.importedItem.<%= TO_DATE %>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate > endDate)
{
alert("Please ensure that the To Date is greater than or equal to the From Date.");
document.calldate.next_day.focus();
return false;
}
}
</script> <%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	
	

	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<StoreWorkOrderT> searchMasStoreItemList = new ArrayList<StoreWorkOrderT>();
	if(map.get("searchMasStoreItemList")!=null)
		searchMasStoreItemList = (List) map.get("searchMasStoreItemList");
	List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
	if(map.get("itemList") != null){
		itemList = (List<MasStoreItem>)map.get("itemList");
	}
	List<MasStoreSection> searchStoreSectionList = new ArrayList<MasStoreSection>();
	if(map.get("searchStoreSectionList")!=null)
		searchStoreSectionList = (List) map.get("searchStoreSectionList");

%>
<div id="contentspace">
<form name="importedItem" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><br />
<br />
<div class="panelbar">
<div class="paneltext">Imported Item Report</div>
</div>
<br />

<label class="bodytextB1"><font id="error">*</font>From Date :</label> <input
	type="text" name="<%=FROM_DATE%>" value="" class="textbox_date"
	MAXLENGTH="30" validate="Pick a from date,date,yes" readonly="readonly" />
<a
	href="javascript:setdate('<%=currentDate%>',document.importedItem.<%=FROM_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> <label class="bodytextB1"><font
	id="error">*</font>To Date :</label> <input type="text" name="<%=TO_DATE%>"
	value="" class="textbox_date" MAXLENGTH="30"
	validate="Pick a to date,date,yes" readonly="readonly" /> <a
	href="javascript:setdate('<%=currentDate%>',document.importedItem.<%=TO_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> <label class="bodytextB1"><font
	id="error">*</font>PVMS/NIV No:</label> <input type="text" value="" id="pvmsNo"
	class="bigcaption" validate="PVMS/NIV No.,String,yes"
	name="<%=PVMS_NO%>" />
<div id="ac2update"
	style="display: none; padding-right: 550px; background-color: white;"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=PVMS_NO%>','ac2update','nonExp?method=getItemListForImportedItemByAutocomplete',{parameters:'requiredField=<%=PVMS_NO%>'});
		</script> <br />

<label class="bodytextB1"><font id="error">*</font>Section Code:</label>
<select name="<%=SECTION_ID%>" validate="Section Name ,String,yes">
	<option value=0>Select</option>
	<%
				for (MasStoreSection masWorkOrder :searchStoreSectionList) {
				
				%>
	<option value=<%=masWorkOrder.getId()%>><%=masWorkOrder.getSectionName()%>
	</option>
	<%	
					}
				
					
				%>
</select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" name="add"
	id="addbutton" value="Ok" class="button"
	onClick="submitForm('importedItem','nonExp?method=generateImportedItemReport','check()');"
	accesskey="a" tabindex=1 /> <input type="button" name="clear"
	id="clearbutton" value="Clear" class="button"
	onClick="clearButton('importedItem');" accesskey="a" tabindex=1 /></form>

</div>