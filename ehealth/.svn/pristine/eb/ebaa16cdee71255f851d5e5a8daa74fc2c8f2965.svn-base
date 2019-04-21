<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.FaMasAccountSubGroup"%>
<%@page import="java.math.BigDecimal"%>

<form name="faAccountSubGrp" method="post" action="">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<FaMasAccountSubGroup> accountSubGrpList = new ArrayList<FaMasAccountSubGroup>();
		if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if(map.get("accountSubGrpList") != null){
		accountSubGrpList = (List<FaMasAccountSubGroup>)map.get("accountSubGrpList");
	}
	int lastSubGroupCode = 0;;
	if(map.get("lastSubGroupCode") != null){
		lastSubGroupCode = (Integer)map.get("lastSubGroupCode");
	}


%> <%
	if(accountSubGrpList.size() > 0){
%>
<div class="titleBg">
<h2>Account Sub Group Master</h2>
</div>
<div class="clear"></div>
<div class="Block">
<input type="radio" name="<%=SELECTED_RADIO %>" value="1" checked="checked"	class="radioAuto" />
<label>Code</label>
<input type="radio"	name="<%=SELECTED_RADIO %>" value="2" class="radioAuto" />
<label class="auto">Name</label>
<input type="text" id="searchField" name="<%=SEARCH_FIELD %>" value="" maxlength="8" tabindex=1
	onkeypress="return submitenter(this,event,'account?method=searchAccountSubGroup')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('faAccountSubGrp','account?method=searchAccountSubGroup','checkSearch')"
	tabindex=1 />
<%-- 	<input type="button" name="report" value="Generate Report" class="buttonBig"/>--%>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>

<table  width="100%" border="0" id="accId" cellspacing="0" cellpadding="0" class="sortable">
	<tr>
		<th scope="col" width="5%">Code</th>
		<th scope="col">Sub Group</th>
		<th scope="col">Opening Balance</th>
		<th scope="col">YTD -Dr.</th>
		<th scope="col">YTD -Cr.</th>
		<th scope="col">Closing Balance</th>
		<th scope="col">Main Account Group</th>
	</tr>
	<tbody id="tableData">
		<%
		String trColor = "";
   	 		for(FaMasAccountSubGroup accountType : accountSubGrpList){
   	 			if(accountType.getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Assets")){
   	 				trColor="#D6FCA9";
   	 			}else if(accountType.getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Liability")){
   	 				trColor="#FDBFA1";
   	 			} else if(accountType.getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Income")){
   	 				trColor="#C2F7FA";
   	 			}else if(accountType.getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Expenditure")){
   	 				trColor="#FDF1B1";
   	 			}
   	    %>
		<tr bgcolor="<%=trColor %>" onclick="submitForm('faAccountSubGrp','account?method=showAccountMasterJsp&accountSubGroupId=<%=accountType.getId() %>')">
			<td class="right"><%=accountType.getAccountSubGroupCode() %></td>
			<td><%=accountType.getAccountSubGroupName() %></td>
			<%
	   	    	if(accountType.getOpBalanceCr() != null && accountType.getOpBalanceCr().compareTo(new BigDecimal(0)) > 0){
	   	    %>
			<td class="right"><%=accountType.getOpBalanceCr()%>  Cr</td>
			<%}else if(accountType.getOpBalanceDr() !=null && accountType.getOpBalanceDr().compareTo(new BigDecimal(0)) > 0){ %>
			<td class="right"><%=accountType.getOpBalanceDr() %>   Dr</td>
			<%}else{ %>
			<td class="right">-</td>
			<%} %>
			
			
			<%if(accountType.getYtdAmountDr() !=null && accountType.getYtdAmountDr().compareTo(new BigDecimal(0)) > 0){ %>
			<td class="right"><%=accountType.getYtdAmountDr() %>   Dr</td>
			<%}else{ %>
			<td class="right">-</td>
			<%} %>
			
			<%
	   	    	if(accountType.getYtdAmountCr() != null && accountType.getYtdAmountCr().compareTo(new BigDecimal(0)) > 0){
	   	    %>
			<td class="right"><%=accountType.getYtdAmountCr()%>  Cr</td>
			<%}else{ %>
			<td class="right">-</td>
			<%} %>
			
<%
	   	    	if(accountType.getClBalanceCr() != null && accountType.getClBalanceCr().compareTo(new BigDecimal(0)) > 0){
	   	    %>
			<td class="right"><%=accountType.getClBalanceCr()%>  Cr</td>
			<%}else if(accountType.getClBalanceDr() !=null && accountType.getClBalanceDr().compareTo(new BigDecimal(0)) > 0){ %>
			<td class="right"><%=accountType.getClBalanceDr() %>   Dr</td>
			<%}else{ %>
			<td class="right">-</td>
			<%} %>
			<%
				if(accountType.getAccountGroup() != null){
			%>
			<td><%=accountType.getAccountGroup().getAccountGroupDesc() %></td>
			<%}else{ %>
			<td>&nbsp;</td>
			<%} %>
		</tr>
		<%
  } %>
	</tbody>
</table>
<div class="clear"></div>
<%}else{ %>
<div class="clear"></div>
<h4>No Record found!</h4>

<%} %>


<div class="paddingTop40"></div>
<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
	  </script>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>