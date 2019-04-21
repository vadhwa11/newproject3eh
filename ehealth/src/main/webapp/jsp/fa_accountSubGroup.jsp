<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.FaMasAccountSubGroup"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.FaMasAccountGroup"%>

<form name="faAccountSubGrp" method="post" action="">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<FaMasAccountSubGroup> accountSubGrpList = new ArrayList<FaMasAccountSubGroup>();
	List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
	List<FaMasAccountSubGroup> accountSubGroupIdList = new ArrayList<FaMasAccountSubGroup>();


	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
		
	if(map.get("accountGroupList") != null){
		accountGroupList = (List<FaMasAccountGroup>)map.get("accountGroupList");
	}
	
	if(map.get("accountSubGrpList") != null){
		accountSubGrpList = (List<FaMasAccountSubGroup>)map.get("accountSubGrpList");
	}
	if(map.get("accountSubGroupIdList") != null){
		accountSubGroupIdList = (List<FaMasAccountSubGroup>)map.get("accountSubGroupIdList");
	}
	int lastSubGroupCode = 0;
	if(map.get("lastSubGroupCode") != null){
		lastSubGroupCode = (Integer)map.get("lastSubGroupCode");
	}

	FaMasAccountSubGroup subGroup = new FaMasAccountSubGroup();
	String accountGroupName = "";
	int subGroupCode = 0;
	String subGroupName = "";
	if(accountSubGroupIdList.size()>0){
		 subGroup = accountSubGroupIdList.get(0);
		 if(subGroup.getAccountGroup() != null && subGroup.getAccountGroup().getAccountGroupDesc() != null ){
			 accountGroupName = subGroup.getAccountGroup().getAccountGroupDesc();
		 }
		 if(subGroup.getAccountSubGroupCode() != null){
		 subGroupCode = subGroup.getAccountSubGroupCode();
		 }
		 if(subGroup.getAccountSubGroupName() != null){
		 subGroupName = subGroup.getAccountSubGroupName();
		 }
	}
	
	String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");
		%>
<h4><span><%=message %></span></h4>
	<%}	

%> 
<div class="titleBg">
<h4>Account Sub Group Master</h4>
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
	<input type="button" name="Report" value="Generate Report" class="buttonBig" onclick="submitForm('faAccountSubGrp','account?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_fa_acc_sub_group"/>
<%-- 	<input type="button" name="report" value="Generate Report" class="buttonBig"/>--%>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>

<table  width="100%" border="0" id="accId" cellspacing="0" cellpadding="0" class="sortable">
	<tr>
		<th scope="col" width="5%">Code</th>
		<th scope="col">Main Account Group</th>
		<th scope="col">Sub Group</th>
		<th scope="col">Opening Balance</th>
		<th scope="col">YTD -Dr.</th>
		<th scope="col">YTD -Cr.</th>
		<th scope="col">Closing Balance</th>
	</tr>
	<tbody id="tableData">
		<%
		String trColor = "";
		
   	 		for(FaMasAccountSubGroup accountType : accountSubGrpList){
   	 		if(accountType.getAccountGroup() != null){
   	 		if(accountType.getAccountGroup().getAccountGroupDesc() != null){
   	 			if(accountType.getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Assets")){
   	 				trColor="#D6FCA9";
   	 			}else if(accountType.getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Liability")){
   	 				trColor="#FDBFA1";
   	 			} else if(accountType.getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Income")){
   	 				trColor="#C2F7FA";
   	 			}else if(accountType.getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Expenditure")){
   	 				trColor="#FDF1B1";
   	 			}
   	 		}
   	 	}
   	    %>
		<tr bgcolor="<%=trColor %>" onclick="submitForm('faAccountSubGrp','account?method=editAccountSubGroup&accountSubGroupId=<%=accountType.getId()%>')">
			<td class="right"><%=accountType.getAccountSubGroupCode() %></td>
		
			
			<%if(accountGroupList.size()>0){
				 for(FaMasAccountGroup accountGroup : accountGroupList){
					 if(accountType.getAccountGroup() != null){
					 if(accountGroup.getId().equals(accountType.getAccountGroup().getId())){
				%>
				<td><%=accountGroup.getAccountGroupDesc() %></td>
			<%}}}}else{ %>
			<td>--</td>
			<%} %>
			
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
			
		</tr>
		<%
  } %>
	</tbody>
</table>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>


<div class="Block">
<div class="clear"></div>
<label>Sub Group Code<span>*</span></label>
<%if(subGroupCode != 0){ 
%>
 <input id="codeId" type="text"  size="5" name="subGroupCode" value="<%=subGroupCode %>"  readonly="readonly"	validate="Sub Group Code,string,no" MAXLENGTH="8" tabindex=1 />
 <%}else{ %>
<%if(lastSubGroupCode != 0){
	%>
 <input id="codeId" type="text"  size="5" name="subGroupCode" value="<%=lastSubGroupCode+1 %>"  readonly="readonly"	validate="Sub Group Code,string,no" MAXLENGTH="8" tabindex=1 />
 <%}else{ %>
 <input id="codeId" type="text"  size="5" name="subGroupCode" value="1"  readonly="readonly"	validate="Sub Group Code,string,no" MAXLENGTH="8" tabindex=1 />
 <%}} %>
<label>Sub Group Name<span>*</span></label>
<input id="subGroupId" type="hidden" name="subGroupId" value="<%=subGroup.getId() %>" validate="Sub Group Name,string,no" MAXLENGTH="45"  />
<input id="subGroupNameId" type="text" name="subGroupName" value="" validate="Sub Group Name,string,no" MAXLENGTH="45"  />

<script>document.getElementById('subGroupNameId').value = '<%=subGroupName%>'</script>

<label> Account Group<span>*</span></label>
<select id="accountGroupId" name="accountGroupId" validate="Account Group,string,no"  >
	<option value="0">Select</option>
	
		<%
		if(accountGroupName != null && !accountGroupName.equals("")){
		if(accountGroupList.size()>0){
			for(FaMasAccountGroup accountGroup :accountGroupList){
				if(accountGroupName.equals(accountGroup.getAccountGroupDesc())){
			
			%>
			<option value="<%=accountGroup.getId() %>" selected="selected"><%=accountGroup.getAccountGroupDesc() %></option>
		<%}}}}else{ %>
		<%if(accountGroupList.size()>0){
		for(FaMasAccountGroup accountGroup :accountGroupList){
		%>
		<option value="<%=accountGroup.getId() %>"><%=accountGroup.getAccountGroupDesc() %></option>
	<%}}}
		%>
</select>

<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="Submit11" id="addbutton" value="Add" class="button" onClick="submitForm('faAccountSubGrp','account?method=addAccountSubGroup','validateAccountSubGroupField');" accesskey="a" tabindex=1 />
<input type="button" name="Submit11" id="addbutton" value="Update" class="button" onClick="submitForm('faAccountSubGrp','account?method=updateAccountSubGroup','validateAccountSubGroupField');" accesskey="a" tabindex=1 />

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);



		function validateAccountSubGroupField(){
			var errMsg = "";
				var accountCodeId = document.getElementById('codeId').value;
				var subGroupName = document.getElementById('subGroupNameId').value;
				var accountGroupId = document.getElementById('accountGroupId').value;
				if(accountGroupId == 0){
					errMsg += "Account Group can not be blank.\n";
				}
				if(subGroupName == ""){
					errMsg += "Sub Group Name can not be blank.\n";
				}
				if(accountCodeId == ""){
					errMsg += "Sub Group Code can not be blank.\n";
				}


				if(errMsg != ""){
					alert(errMsg);
					return false;
				}

				return true;
			}
					
	  </script>
