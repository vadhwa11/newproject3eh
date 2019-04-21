
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasItemClass"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasItemType"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<%
Map<String, Object> map = new HashMap<String, Object>();
List<MasStoreGroup> groupList=new ArrayList<MasStoreGroup>();
List<MasItemType> itemTypeList=new ArrayList<MasItemType>();
List<MasStoreSection> sectionList=new ArrayList<MasStoreSection>();
List<MasItemCategory> categorieList=new ArrayList<MasItemCategory>();
List<MasItemClass> itemClasseList=new ArrayList<MasItemClass>();
List<Object[]> storeItemList = new ArrayList<Object[]>();

Box box=HMSUtil.getBox(request);
if(request.getAttribute("map")!=null)
{
	map=(Map<String, Object>)request.getAttribute("map");
}
if(map.get("groupList")!=null)
{
	groupList=(List<MasStoreGroup>)map.get("groupList");
}

if(map.get("itemTypeList")!=null)
{
	itemTypeList=(List<MasItemType>)map.get("itemTypeList");
}

if(map.get("sectionList")!=null)
{
	sectionList=(List<MasStoreSection>)map.get("sectionList");
}

if(map.get("categorieList")!=null)
{
	categorieList=(List<MasItemCategory>)map.get("categorieList");
}

if(map.get("itemClasseList")!=null)
{
	itemClasseList=(List<MasItemClass>)map.get("itemClasseList");
}
%>
<label id="">Item Group </label> 
<select id="<%= GROUP_ID%>"	name="<%= GROUP_ID%>" validate="Item Group,int,no"	onchange="onChangeItemGRoup()">
	<option value="0">Select</option>
	<%
for(MasStoreGroup masStoreGroup:groupList) {
	%>
	<%if(box.getInt(GROUP_ID)==masStoreGroup.getId()) 
	{%>
	<option value="<%=masStoreGroup.getId()%>" selected="selected"><%=masStoreGroup.getGroupName()%></option>
	<%} else{ %>
	<option value="<%=masStoreGroup.getId()%>"><%=masStoreGroup.getGroupName()%></option>
	<%}%>
	<%}%>
</select>

<label id="">Item Type </label> 
<select id="<%= ITEM_TYPE%>"	name="<%= ITEM_TYPE%>" validate="Item Type,int,no"	onchange="onChangeItemType()">
	<option value="0">Select</option>
	<%
for(MasItemType itemType:itemTypeList) {
	%>
	<%if(box.getInt(ITEM_TYPE)==itemType.getId()) 
	{%>
	<option value="<%=itemType.getId()%>" selected="selected"><%=itemType.getItemTypeName()%></option>
	<%} else{ %>
	<option value="<%=itemType.getId()%>"><%=itemType.getItemTypeName()%></option>
	<%}%>
	<%}%>
</select>

<label id="">Item Section </label> 
<select id="<%= SECTION_ID%>"	name="<%= SECTION_ID%>" validate="Item Section,int,no"	onchange="onChangeItemSection()">
	<option value="0">Select</option>
	<%
for(MasStoreSection masStoreSection:sectionList) {
	%>
	<%if(box.getInt(SECTION_ID)==masStoreSection.getId()) 
	{%>
	<option value="<%=masStoreSection.getId()%>" selected="selected"><%=masStoreSection.getSectionName()%></option>
	<%} else{ %>
	<option value="<%=masStoreSection.getId()%>"><%=masStoreSection.getSectionName()%></option>
	<%}%>
	<%}%>
</select>

<label id="">Item Category </label> 
<select id="<%= ITEM_CATEGORY_ID%>"	name="<%= ITEM_CATEGORY_ID%>" validate="Item Category,int,no"	onchange="onChangeItemCategory()">
	<option value="0">Select</option>
	<%
for(MasItemCategory itemCategory:categorieList) {
	%>
	<%if(box.getInt(ITEM_CATEGORY_ID)==itemCategory.getId()) 
	{%>
	<option value="<%=itemCategory.getId()%>" selected="selected"><%=itemCategory.getItemCategoryName()%></option>
	<%} else{ %>
	<option value="<%=itemCategory.getId()%>"><%=itemCategory.getItemCategoryName()%></option>
	<%}%>
	<%}%>
	
</select>

<label id="">Item Class </label> 
<select id="<%= ITEM_CLASS_ID%>"	name="<%= ITEM_CLASS_ID%>" validate="Item Class,int,no"	onchange="onChangeItemClass()">
	<option value="0">Select</option>
	<%
for(MasItemClass itemClass:itemClasseList) {
	%>
	<%if(box.getInt(ITEM_CLASS_ID)==itemClass.getId()) 
	{%>
	<option value="<%=itemClass.getId()%>" selected="selected"><%=itemClass.getItemClassName()%></option>
	<%} else{ %>
	<option value="<%=itemClass.getId()%>"><%=itemClass.getItemClassName()%></option>
	<%}%>
	<%}%>
	</select>
	<label id="" >Drug </label>
<select	name="drug" id="drug" validate="Drug,string,no">
	<option value="0">Select</option>
	<%
for(Object[] masStoreItem :storeItemList) {
%>
<option value="<%=masStoreItem[0]%>"><%=masStoreItem[1]%></option>
	<%}%>
</select>


