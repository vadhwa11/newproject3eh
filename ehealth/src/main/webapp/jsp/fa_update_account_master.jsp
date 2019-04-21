<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.FaMasAccountGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccountSubGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%@page import="java.math.BigDecimal"%>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
	List<FaMasAccountSubGroup> accountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
	List<FaMasAccount> accountIdList = new ArrayList<FaMasAccount>();
	List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if(map.get("accountGroupList") != null){
		accountGroupList = (List<FaMasAccountGroup>)map.get("accountGroupList");
	}

	if(map.get("accountSubGroupList") != null){
		accountSubGroupList = (List<FaMasAccountSubGroup>)map.get("accountSubGroupList");
	}

	if(map.get("accountList") != null){
		accountList = (List<FaMasAccount>)map.get("accountList");
	}
	if(map.get("accountIdList") != null){
		accountIdList = (List<FaMasAccount>)map.get("accountIdList");
	}
	System.out.println("accountIdList=="+accountIdList.size());
	Integer accCode = 0;
	if(map.get("accCode")!= null){
		accCode = (Integer)map.get("accCode");
	}
	String fYear = "";
	if(map.get("fYear")!= null){
		fYear = (String)map.get("fYear");
	}

	String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");
		%>
<h4><span><%=message %></span></h4>
	<%}
	if(accountIdList.size()>0){
		for(FaMasAccount masAccount :accountIdList){


%>


<form name="updateMaster" method="post" action="">
<div class="paddingTop15"></div>
<h2>Update Account Master</h2>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Account Code<span>*</span></label>
 <input id="codeId" type="text"  size="5" name="<%=ACCOUNT_CODE%>" value="<%=masAccount.getAccCode() %>"  readonly="readonly"	validate="Account Code,string,yes" MAXLENGTH="8" tabindex=1 >
 <input  type="hidden"  size="5" name="accountId" value="<%=masAccount.getId() %>"  readonly="readonly"	validate="Account Code,string,yes" MAXLENGTH="8" tabindex=1 >

<label>Account Name<span>*</span></label>

<input id="accountNameId" type="text"  name="<%= ACCOUNT_NAME %>" value="<%=masAccount.getAccDesc() %>" 	validate="Account Name,string,yes" MAXLENGTH="45"  />

<label> Parent Required</label>
<%
if(masAccount.getParentStatus().equals("y")){ %>
<input id="parentStatusId" type="checkbox" name="parentStatus" checked="checked" value="" validate="Parent Required,string,yes" tabindex=1 class="radioCheck" />
<%}else{ %>
<input id="parentStatusId" type="checkbox" name="parentStatus"  value="" validate="PF Dependent,string,yes" tabindex=1 class="radioCheck" />
<%}%>
<div class="clear"></div>
<label> SL Required</label>
<%if(masAccount.getSubLedger().equals("y")){ %>
<input id="subLedgerId" type="checkbox" name="subLedgerStatus" checked="checked" value="" validate="SL Required,string,yes" tabindex=1 class="radioCheck" />
<%}else{ %>
<input id="subLedgerId" type="checkbox" name="subLedgerStatus"  value="" validate="PF Dependent,string,yes" tabindex=1 class="radioCheck" />
<%} %>
<label> Group Name<span>*</span></label>
<select id="accountGroupId" name="<%=ACCOUNT_GROUP_ID %>" validate="Account Group,string,yes" onChange="populateSubGroup(this.value,'updateMaster')" />
	<option value="0">Select</option>
	<%if(accountGroupList.size()>0){
		for(FaMasAccountGroup faMasAccountGroup :accountGroupList){
			if(masAccount.getAccountSubGroup().getAccountGroup().getId().equals(faMasAccountGroup.getId())){
		%>
		<option value="<%=faMasAccountGroup.getId() %>" selected="selected"><%=faMasAccountGroup.getAccountGroupDesc() %></option>

	<%}else{%>
		<option value="<%=faMasAccountGroup.getId() %>"><%=faMasAccountGroup.getAccountGroupDesc() %></option>
	<%	}}
		}%>
</select>

<script type="text/javascript">
          subGroupArray = new Array();
		<%
			int count = 0;
			for (FaMasAccountGroup faMasAccountGroup :accountGroupList)
			{

				for (FaMasAccountSubGroup faMasAccountSubGroup :accountSubGroupList)
				{

					if(faMasAccountGroup.getId().equals(faMasAccountSubGroup.getAccountGroup().getId())){
								%>
									subGroupArray[<%=count%>] = new Array();
									subGroupArray[<%=count%>][0] = <%=faMasAccountGroup.getId()%>;
									subGroupArray[<%=count%>][1] = <%=faMasAccountSubGroup.getId()%>;
									subGroupArray[<%=count%>][2] = "<%=faMasAccountSubGroup.getAccountSubGroupName()%>";

								<%
								count++;
						}	} } %>
		</script>

<label> Sub Group Name<span>*</span></label>
<select id="subGroupId" name="<%=ACCOUNT_SUB_GROUP_ID %>" validate="Account SubGroup,string,yes" onchange="getAccCode(this.value),populateMainAccount(this.value,'updateMaster')" />
	<option value="0">Select</option>
	<%if(accountSubGroupList.size()>0){
		for(FaMasAccountSubGroup faMasAccountSubGroup :accountSubGroupList){
			if(masAccount.getAccountSubGroup().getId().equals(faMasAccountSubGroup.getId())){
		%>
		<option value="<%=faMasAccountSubGroup.getId() %>" selected="selected"><%=faMasAccountSubGroup.getAccountSubGroupName() %></option>
		<%}else{ %>
			<option value="<%=faMasAccountSubGroup.getId() %>"><%=faMasAccountSubGroup.getAccountSubGroupName() %></option>

	<%}}
		}%>
</select>

	<script type="text/javascript">
          mainAccountArray = new Array();
		<%
			int count1 = 0;
		for (FaMasAccountSubGroup faMasAccountSubGroup :accountSubGroupList)
			{

				for (FaMasAccount faMasAccount:accountList)
				{

					if(faMasAccountSubGroup.getId().equals(faMasAccount.getAccountSubGroup().getId())){
								%>
									mainAccountArray[<%=count1%>] = new Array();
									mainAccountArray[<%=count1%>][0] = <%=faMasAccountSubGroup.getId()%>;
									mainAccountArray[<%=count1%>][1] = <%=faMasAccount.getId()%>;
									mainAccountArray[<%=count1%>][2] = "<%=faMasAccount.getAccDesc()%>";

								<%
								count1++;
						}	} } %>
		</script>
<div class="clear"></div>

<label> Main Account</label>
<select id="mainAccountId" name="<%=ACCOUNT_ID %>" validate="Account Type,string,no"  />
	<option value="0">Select</option>
	<%if(accountList.size()>0){
		for(FaMasAccount faMasAccount :accountList){
			if(masAccount.getId().equals(faMasAccount.getId())){
		%>
		<option value="<%=faMasAccount.getId() %>" selected="selected"><%=faMasAccount.getAccDesc() %></option>
		<%}else{ %>
		<option value="<%=faMasAccount.getId() %>"><%=faMasAccount.getAccDesc() %></option>
	<%}
		}
		}%>
</select>
<%if(masAccount.getOpBalanceCr()!= null &&  masAccount.getOpBalanceCr().compareTo(new BigDecimal(0.0))!=0){ %>
<input type="hidden" name="lastOpeningBalanceCr" value="<%=masAccount.getOpBalanceCr() %>" 	 MAXLENGTH="11"  />
<%}else if(masAccount.getOpBalanceDr()!= null && masAccount.getOpBalanceDr().compareTo(new BigDecimal(0.0))!=0){  %>
<input type="hidden" name="lastOpeningBalanceDr" value="<%=masAccount.getOpBalanceDr() %>" 	 MAXLENGTH="11"  />

<%} %>

<label>Opening Balance</label>
<%if(masAccount.getOpBalanceCr()!= null && masAccount.getOpBalanceCr().compareTo(new BigDecimal(0.0))!=0){ %>
<input type="text" name="openingBalance" value="<%=masAccount.getOpBalanceCr() %>" 	 MAXLENGTH="11" />
<%}else if(masAccount.getOpBalanceDr()!= null && masAccount.getOpBalanceDr().compareTo(new BigDecimal(0.0))!=0){ %>
<input type="text" name="openingBalance" value="<%=masAccount.getOpBalanceDr() %>" 	 MAXLENGTH="11"  />
<%}else{ %>
<input type="text" name="openingBalance" value="" 	 MAXLENGTH="11"  />

<%} %>
<select name="accountTypeA" class="small" />
			<option value="0">Select</option>
			<%
			if(masAccount.getOpBalanceDr()!= null && masAccount.getOpBalanceDr().compareTo(new BigDecimal(0.0))!=0){ %>
			<option value="Dr" selected="selected">Dr</option>
			<option value="Cr">Cr</option>
			<%}else if(masAccount.getOpBalanceCr()!= null && masAccount.getOpBalanceCr().compareTo(new BigDecimal(0.0))!=0){ %>
			<option value="Cr" selected="selected">Cr</option>
			<option value="Dr" >Dr</option>
			<%}else{ %>
			<option value="Cr" >Cr</option>
			<option value="Dr" >Dr</option>
			<%} %>

			</select>
<div class="clear"></div>
<label>Schedule</label>
<select id="scheduleId" name="schedule" validate="Schedule,string,no"  />
	<option value="0">Select</option>
	<%
	if(masAccount.getSchedule()== null){
	 %>
	 <%	for(int i=1; i<=30; i++){ %>
	<option value="<%=i %>"><%=i %></option>
	<%}}else{ %>

		<option value="<%=masAccount.getSchedule() %>" selected="selected"><%=masAccount.getSchedule() %></option>
	
	<%}%>
</select>

</div>

<%}} %>
<div class="clear"></div>

<div class="clear"></div>

<input type="button" name="Submit" id="addbutton" value="Submit" class="button" onClick="submitForm('updateMaster','account?method=updateAccountMaster');" accesskey="a" tabindex=1 />
 <input type="button" name="Submit" id="addbutton" value="Back" class="button" onClick="submitForm('updateMaster','account?method=showAccountMasterJsp');" accesskey="a" tabindex=1 />

<div class="clear"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName %> </label>

<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
 <label class="value"><%=time%></label>
  <input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName %>" />
   <input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
    <input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>



<div class="clear"></div>
<div class="paddingTop40"></div>

<script type="text/javascript">
function openPopUp()
		{

				window.open('account?method=showBranchBalancePopupJsp','mywindow','location=1,status=1,scrollbars=1,top=210,left=30,width=960,height=300');

		}

</script>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>