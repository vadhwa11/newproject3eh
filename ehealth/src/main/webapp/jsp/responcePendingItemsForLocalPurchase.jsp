<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

<%
Map<String,Object> map = new HashMap<String,Object>();




List<StoreInternalIndentT> pendingList= new ArrayList<StoreInternalIndentT>();
if(request.getAttribute("map")!=null)
{
	map=(Map<String ,Object>)request.getAttribute("map");
}

  if(map.get("mmServiceRequests")!=null){
pendingList=(List<StoreInternalIndentT>)map.get("mmServiceRequests");
  }
%>


<div id="testDiv">



<h4>Item Details</h4>

	
<div class="cmntable">
<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th>Sl No.</th>
			<th>Item Code</th>
			<th>Item Name</th>
			<th>A/U</th>
			<th>Qty Needed</th>
			<th><input type="checkbox" name="selectCheckBox"></input></th>
		</tr>
	</thead>

<%
			if (pendingList.size() > 0) {
				for (StoreInternalIndentT st : pendingList) {
		%>
		<tr>
			<td width="5%"><%=st.getItem().getPvmsNo() %></td>
			<td width="5%"><%=st.getItem().getNomenclature() %></td>
			<td width="5%"><%=st.getItem().getItemConversion().getItemUnitName() %></td>
			<td width="5%"><%=st.getItem().get%>></td>
			<td><input type="checkbox" /></td>
		</tr>
			
		
		<%}%>
				
			
			
			

</table>
</div>

<input type="button" name="" value="Proceed" class="button" onclick=""	tabindex=1 />
<input type="button" name="" value="Reset" class="button" onclick=""	tabindex=1 />
<%} %>


</div>

