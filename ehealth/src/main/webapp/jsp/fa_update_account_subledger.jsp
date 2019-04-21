<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.FaMasAccountGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccountSubGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>

<%@page import="jkt.hms.masters.business.FaMasSubLed"%>
<%@page import="java.math.BigDecimal"%><script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/sorttableAccounts.js" type="text/javascript"></script>

<script type="text/javascript">

	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}

	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
</script>
<form name="updateAccountSubLedger" method="post" action="">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<FaMasSubLed> subLedList = new ArrayList<FaMasSubLed>();
	List<FaMasAccountGroup> accGrpList = new ArrayList<FaMasAccountGroup>();
	List<FaMasAccountSubGroup> subAccGrpList = new ArrayList<FaMasAccountSubGroup>();
	List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
	List<FaMasSubLed> subLedIdList = new ArrayList<FaMasSubLed>();
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
	if(map.get("subLedList") != null){
		subLedList = (List<FaMasSubLed>)map.get("subLedList");
	}
	if(map.get("subLedIdList") != null){
		subLedIdList = (List<FaMasSubLed>)map.get("subLedIdList");
	}
	if(map.get("accGrpList") != null){
		accGrpList = (List<FaMasAccountGroup>)map.get("accGrpList");
	}
	if(map.get("subAccGrpList") != null){
		subAccGrpList = (List<FaMasAccountSubGroup>)map.get("subAccGrpList");
	}
	if(map.get("accList") != null){
		accList = (List<FaMasAccount>)map.get("accList");
	}

	String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");
		%>
<h4><span><%=message %></span></h4>
	<%}

	if(subLedIdList.size()>0){
		for(FaMasSubLed masSubLed :subLedIdList){
			
	
%>
<div class="clear"></div>
<div class="paddingTop15"></div>
<h2>Update Sub Ledger</h2>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>


<label>Sub Ledger Name<span>*</span></label>

<input type="text" name="<%= SUB_LDEGER_NAME %>" value="<%=masSubLed.getSubLedDesc() %>" 	validate="Sub Ledger,string,yes" MAXLENGTH="30" tabindex=1 />
<input  type="hidden"  size="5" name="accountSubLedgerId" value="<%=masSubLed.getId() %>"  readonly="readonly"	validate="Account Code,string,yes" MAXLENGTH="8" tabindex=1 >

<label> Group Name<span>*</span></label>
<select id="accountGroupId" name="<%=ACCOUNT_GROUP_ID %>" validate="Account Group,string,yes" onChange="populateSubGroup(this.value,'updateAccountSubLedger')" >
	<option value="0">Select</option>
	<%if(accGrpList.size()>0){
		for(FaMasAccountGroup faMasAccountGroup :accGrpList){
			if(faMasAccountGroup.getId().equals(masSubLed.getAccount().getAccountSubGroup().getAccountGroup().getId())){
		%>
		<option value="<%=faMasAccountGroup.getId() %>" selected="selected"><%=faMasAccountGroup.getAccountGroupDesc() %></option>
		<%}else{ %>
		<option value="<%=faMasAccountGroup.getId() %>"><%=faMasAccountGroup.getAccountGroupDesc() %></option>
		
	<%}
		}
		}%>
</select>

<script type="text/javascript">
          subGroupArray = new Array();
		<%
			int count = 0;
			for (FaMasAccountGroup faMasAccountGroup :accGrpList) 
			{
				
				for (FaMasAccountSubGroup faMasAccountSubGroup :subAccGrpList) 
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

<label> Sub Group<span>*</span> </label>
<select id="subGroupId" name="<%=ACCOUNT_SUB_GROUP_ID %>" validate="Account Sub Group,string,yes" onchange="populateMainAccount(this.value,'updateAccountSubLedger')" " >
	<option value="0">Select</option>
	<%if(subAccGrpList.size()>0){
		for(FaMasAccountSubGroup faMasAccountSubGroup :subAccGrpList){
			if(faMasAccountSubGroup.getId().equals(masSubLed.getAccount().getAccountSubGroup().getId())){
		%>
		<option value="<%=faMasAccountSubGroup.getId() %>" selected="selected"><%=faMasAccountSubGroup.getAccountSubGroupName() %></option>
		<%}else{ %>
		<option value="<%=faMasAccountSubGroup.getId() %>" ><%=faMasAccountSubGroup.getAccountSubGroupName() %></option>
		
	<%}
		}
		}%>
</select>

<script type="text/javascript">
          mainAccountArray = new Array();
		<%
			int count1 = 0;
		for (FaMasAccountSubGroup faMasAccountSubGroup :subAccGrpList)  
			{
				
				for (FaMasAccount faMasAccount:accList) 
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
<label> Main Account<span>*</span></label>
<select id="mainAccountId"  name="<%=ACCOUNT_ID %>" validate=" Main Account ,string,yes">
	<option value="0">Select</option>
	<%if(accList.size()>0){
		for(FaMasAccount faMasAccount :accList){
			if(faMasAccount.getId().equals(masSubLed.getAccount().getId())){
		%>
		<option value="<%=faMasAccount.getId() %>" selected="selected"><%=faMasAccount.getAccDesc() %></option>
		<%}else{ %>
		<option value="<%=faMasAccount.getId() %>" ><%=faMasAccount.getAccDesc() %></option>
		
	<%}
		}
		}%>
</select>
<%if(masSubLed.getOpBalanceCr()!= null &&  masSubLed.getOpBalanceCr().compareTo(new BigDecimal(0.0))!=0){ %>
<input type="hidden" name="lastOpeningBalanceCr" value="<%=masSubLed.getOpBalanceCr() %>" 	 MAXLENGTH="11"  />	
<%}else if(masSubLed.getOpBalanceDr()!= null && masSubLed.getOpBalanceDr().compareTo(new BigDecimal(0.0))!=0){  %>
<input type="hidden" name="lastOpeningBalanceDr" value="<%=masSubLed.getOpBalanceDr() %>" 	 MAXLENGTH="11"  />	

<%} %>

<%if(masSubLed.getOpBalanceCr()!= null &&  masSubLed.getOpBalanceCr().compareTo(new BigDecimal(0.0))!=0){ %>
<input type="hidden" name="lastOpeningBalanceCr" value="<%=masSubLed.getOpBalanceCr() %>" 	 MAXLENGTH="11"  />	
<%}else if(masSubLed.getOpBalanceDr()!= null && masSubLed.getOpBalanceDr().compareTo(new BigDecimal(0.0))!=0){  %>
<input type="hidden" name="lastOpeningBalanceDr" value="<%=masSubLed.getOpBalanceDr() %>" 	 MAXLENGTH="11"  />	

<%} %>

<label>Opening Balance</label>
<%if(masSubLed.getOpBalanceCr()!= null && masSubLed.getOpBalanceCr().compareTo(new BigDecimal(0.0))!=0){ %>
<input type="text" name="openingBalance"  value="<%=masSubLed.getOpBalanceCr() %>" MAXLENGTH="11"  />	
<%}else if(masSubLed.getOpBalanceDr()!= null && masSubLed.getOpBalanceDr().compareTo(new BigDecimal(0.0))!=0){ %>
<input type="text" name="openingBalance"  value="<%=masSubLed.getOpBalanceDr() %>" MAXLENGTH="11"  />	
<%}else{ %>
<input type="text" name="openingBalance"  value="" MAXLENGTH="11"  />	

<%} %>

<select name="accountTypeA" class="small" />
			<%if(masSubLed.getOpBalanceDr()!= null && masSubLed.getOpBalanceDr().compareTo(new BigDecimal(0.0))!=0){ %>
			<option value="Dr" selected="selected">Dr</option>
			<option value="Cr">Cr</option>
			<%}else if(masSubLed.getOpBalanceCr()!= null && masSubLed.getOpBalanceCr().compareTo(new BigDecimal(0.0))!=0){ %>
			<option value="Cr" selected="selected">Cr</option>
			<option value="Dr" >Dr</option>
			<%} %>
			</select>
<div class="clear"></div>
</div>
<%}} %>
<div class="clear"></div>

<input type="button" name="Update" id="addbutton" value="Update" class="button" onClick="submitForm('updateAccountSubLedger','account?method=updateAccountSubLedger');" accesskey="a" tabindex=1 />
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




<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>