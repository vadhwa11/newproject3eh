<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * edReturnFrom.jsp  
 * Purpose of the JSP -  This is for ed Return.
 * @author  Vishal Jain
 * Create Date: 14th March,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.3
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript">
	<%
		Map<String, Object> map = new HashMap<String, Object>();
 			if (request.getAttribute("map") != null) {
 				map = (Map<String, Object>) request.getAttribute("map");
 		}	
 		List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
 		List<MasItemCategory> subSectionList = new ArrayList<MasItemCategory>();
 		List<MasStoreGroup> itemGroupList = new ArrayList<MasStoreGroup>();
 		List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
 		if(map.get("itemGroupList") !=null){
 			itemGroupList = (List)map.get("itemGroupList");
 		}
 		if(map.get("manufacturerList") !=null){
 			manufacturerList = (List)map.get("manufacturerList");
 		}
 		if (map.get("sectionList") != null) {
 				sectionList = (List<MasStoreSection>) map.get("sectionList");
 	 	}
 		if (map.get("subSectionList") != null) {
 		 		subSectionList = (List<MasItemCategory>) map.get("subSectionList");
 	 	}	
	
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
			</script>
<div class="clear"></div>
<div class="titleBg">
<h2>Item Name/ Item code</h2>
</div>
<div class="clear"></div>
<form name="PvmsNivMasterReport" method="post" action=""><script
	type="text/javascript">
		  function getSectionName(){
		  	var w = document.getElementById('sectionListId').selectedIndex;
		  	if(w > 0){
			  	var selectedText = document.getElementById('sectionListId').options[w].text;
				document.getElementById('sectionNameId').value = selectedText;
		  	}
		  }
		  function getManufacturerName(){
		  	var w = document.getElementById('manufacturerId').selectedIndex;
		  	if(w > 0){
		  		var selectedText = document.getElementById('manufacturerId').options[w].text;
				document.getElementById('manufacturerNameId').value = selectedText;
			}
		  }
		  function getGroupName(){
		  	var w = document.getElementById('itemGroupId').selectedIndex;
		  	if(w > 0){
		  		var selectedText = document.getElementById('itemGroupId').options[w].text;
		  		document.getElementById('groupNameId').value = selectedText;
		  	}
		  }
		  </script>
<div class="Block"><label>Section List</label> 
<select	id="sectionListId" name="<%=SECTION_LIST %>"   onchange="getSectionName();">
	<option value="0">Select</option>
	<%
							for (MasStoreSection masStoreSection : sectionList) {
						%>
	<option value="<%=masStoreSection.getId() %>"><%=masStoreSection.getSectionName()%></option>
	<%
						}
					%>
</select>
<label>Manufacturer Name</label> 
<select id="manufacturerId"	name="<%=MANUFACTURER_ID%>"  onchange="getManufacturerName();">
<option value="0">Select</option>
<% 	for(MasManufacturer masManufacturer: manufacturerList){ %>
<option value="<%=masManufacturer.getId()%>"><%=masManufacturer.getManufacturerName()%></option>
<% } %>
</select> 
<label>Group Name</label> 
<select id="itemGroupId" name="<%=GROUP_ID%>"   onchange="getGroupName();">
<option value="0">Select</option>
<%	for(MasStoreGroup masStoreGroup: itemGroupList){%>
<option value="<%=masStoreGroup.getId()%>"><%=masStoreGroup.getGroupName()%></option>
	<%}%>
</select> 
<input type="hidden" id="sectionNameId" name="sectionName"  /> 
<input	type="hidden" id="manufacturerNameId" name="manufacturerName"  /> 
<input	type="hidden" id="groupNameId" name="groupName"  />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button"	onClick="submitForm('PvmsNivMasterReport','stores?method=showItemCatalogue');" />
<input type="button" name="clear" value="Clear" class="button"	onClick="submitForm('PvmsNivMasterReport','stores?method=showItemCatalogueJsp');"	accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>