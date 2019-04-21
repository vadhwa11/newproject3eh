<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.MasItemType"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasItemType> masItemTypeList= new ArrayList<MasItemType>();
if(map.get("masItemTypeList") !=null){
	masItemTypeList=(List<MasItemType>)map.get("masItemTypeList");
}
%>


<div id="nameDiv">
<label> Item Type <span>*</span></label>
<select id="<%= ITEM_TYPE_ID %>"	name="<%=ITEM_TYPE_ID %>" validate="Item Type,string,yes" tabindex=1 onchange="displayBagQuantityText()"onblur="submitProtoAjaxWithDivName('item','/hms/hms/pharmacy?method=getSectionList&itemType='+this.value,'testDiv');" tabindex=1>
<%	if(masItemTypeList.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = masItemTypeList.iterator(); iterator.hasNext();) {
					 MasItemType d = (MasItemType) iterator.next();
				  %>
				  <option value="<%=d.getId ()%>"><%=d.getItemTypeName().trim()%></option>
				  <%
				  	 	}
				   %>
			
			
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>


<div id="testDiv">


<label><span>*</span> Section</label> 
<select id="sectionId"	name="<%= SECTION_ID %>" validate="Section Name,string,yes" 	tabindex=1>
<option value="0">No Data</option>

</select>

</div>	
	
<div class="clear"></div>
</div>



