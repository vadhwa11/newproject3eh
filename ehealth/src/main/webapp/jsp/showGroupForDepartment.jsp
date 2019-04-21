<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script>
<%

	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}

Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
map = (Map<String,Object>) request.getAttribute("map");
}

List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();

//List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();

//itemCategoryList = (List<MasItemCategory>)map.get("itemCategoryList");
if(map.get("groupList") != null){
groupList = (List<MasStoreGroup>)map.get("groupList") ;
}
%>
serverdate = '<%=date+"/"+month1+"/"+year1%>'

</script>


<label><span>*</span> Group</label>
<select name="<%= GROUP_ID %>" validate="Groups,string,yes" tabindex=1>
	<option value="0">Select</option>
	<%
			for (MasStoreGroup masStoreGroup : groupList) {
		%>
	<option value="<%=masStoreGroup.getId ()%>"><%=masStoreGroup.getGroupName()%></option>
	<%
			}
		%>
</select>
<%--
<label><span>*</span>Item Class</label>
<select name="<%= ITEM_CATEGORY_ID %>" validate="Item Class,string,yes"
	tabindex=1>
	<option value="0">Select</option>
	<%
			for (MasItemCategory masItemCategory : itemCategoryList) {
		%>
	<option value="<%=masItemCategory.getId ()%>"><%=masItemCategory.getItemCategoryName()%></option>
	<%
			}
		%>
 --%>
</select>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">