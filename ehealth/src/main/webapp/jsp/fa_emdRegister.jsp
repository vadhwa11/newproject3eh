<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasBankMaster"%>
<%@page import="java.math.BigDecimal"%>
<%@ page import="static jkt.hms.util.RequestConstants.JASPER_FILE_NAME"%>
<%@page import="jkt.hms.masters.business.FaEmdRegister"%>
<script type="text/javascript" src="/erp/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/erp/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/erp/jsp/js/jquery.common.js"></script>
<form name="emdRegister" method="post" action="">

<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
	List<FaEmdRegister> emdRegisterList = new ArrayList<FaEmdRegister>();
	List<FaEmdRegister> emdRegisterIdList = new ArrayList<FaEmdRegister>();
	int emdRegId=0;
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if(map.get("bankList") != null){
		bankList = (List<MasBankMaster>)map.get("bankList");
	}
	if(map.get("emdRegisterList") != null){
		emdRegisterList = (List<FaEmdRegister>)map.get("emdRegisterList");
	}
	if(map.get("emdRegisterIdList") != null){
		emdRegisterIdList = (List<FaEmdRegister>)map.get("emdRegisterIdList");
	}
	if(map.get("emdRegId") != null){
		emdRegId = (Integer)map.get("emdRegId");
		
	}
	boolean saved = false;
	if (map.get("saved") != null) {

		saved = (Boolean) map.get("saved");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	String tenderNo = "";
	String soNo = "";
	String entryDate ="";
	String fromDate ="";
	String toDate ="";
	BigDecimal amount = new BigDecimal(0);
	BigDecimal rateOfInterst = new BigDecimal(0);
	int bankId = 0;
	int days = 0;
	String remarks = "";
	int fdId = 0;
	String organisation = "";
	if(emdRegisterIdList.size()>0){
		for(FaEmdRegister emdRegister :emdRegisterIdList){
			if(emdRegister.getTenderNo()!= null){
				tenderNo = emdRegister.getTenderNo();
			}
			if(emdRegister.getSoNo()!= null){
				soNo = emdRegister.getSoNo();
			}
			if(emdRegister.getDate() != null){
				entryDate =HMSUtil.convertDateToStringWithoutTime(emdRegister.getDate());
			}
			if(emdRegister.getFromDate()!= null){
				fromDate =HMSUtil.convertDateToStringWithoutTime(emdRegister.getFromDate());
			}
			if(emdRegister.getFromDate()!= null){
				toDate =HMSUtil.convertDateToStringWithoutTime(emdRegister.getToDate());
			}
			if(emdRegister.getEmdAmount()!= null){
				amount = emdRegister.getEmdAmount();
			}
			if(emdRegister.getRemarks() != null){
				remarks = emdRegister.getRemarks();
			}
			if(emdRegister.getBank() != null){
				bankId = emdRegister.getBank().getId();
			}
			if(emdRegister.getOrganization() != null){
			 	organisation  = emdRegister.getOrganization();
			}
		
	}
	}

	
	String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	if (saved) {
			
			out.println("<h4 id='divResult' class='success'>" + message+ "</h4><a href='#' onclick='submitFormForButton(\"emdRegister\",\"account?method=printEmdRegId&emdRegId="+emdRegId+"\")'>Yes</a>");
			
		} else {
			out.println("<h4 id='divResult' class='failure'>" + message+ "</h4>");
		} 
		
		


%>


<div class="clear"></div>
<div class="paddingTop15"></div>

<div class="clear"></div>
<div class="titleBg">
<h4>BG/EMD Register</h4>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Date</label>
<input type="text" name="date" class="calDate" id="date" value="" />
<script>document.getElementById('date').value = '<%=entryDate%>'</script>
<label>Tender Ref. No.<span>*</span></label>
<input type="text" name="tenderNo" id="tenderNo" value="" />
<script>document.getElementById('tenderNo').value = '<%=tenderNo%>'</script>
<label>So No.<span>*</span></label>
<input type="text" name="soNo" id="soNoId" value="" />
 <script>document.getElementById('soNoId').value = '<%=soNo%>'</script>
<div class="clear"></div>
<label>Organization<span>*</span></label>
<input type="text" name="organisation" id="organisation" value="" />
 <script>document.getElementById('organisation').value = '<%=organisation%>'</script>
<label>Amount</label>
<input type="text" name="amount" id="amountId"  value="" />
 <script>document.getElementById('amountId').value = '<%=amount%>'</script>
<label>From Date</label>
<input type="text" name="fromDate"  class="calDate" id="fromDate" value="" />
 <script>document.getElementById('fromDate').value = '<%=fromDate%>'</script>
<div class="clear"></div>
<label>To Date</label>
<input type="text" name="toDate"  class="calDate" id="toDate" value="" />
 <script>document.getElementById('toDate').value = '<%=toDate%>'</script>
<label>Bank Name<span>*</span></label>
<select id="bankId"  name="bankId" >
<option value="0">Select</option>
<%if(bankList.size()>0){
		for(MasBankMaster masBankMaster :bankList){
			if(masBankMaster.getId().equals(bankId)){
		%>
		<option value="<%=masBankMaster.getId() %>" selected="selected"><%=masBankMaster.getBankName() %></option>
	<%}else{ %>
	<option value="<%=masBankMaster.getId() %>"><%=masBankMaster.getBankName() %></option>
	<%}}} %>
</select>
<label>Status</label>
<input type="text" name="status" id="status" value="" />
<div class="clear"></div>
<label>Remarks</label>
<input type="text" name="remarks" id="remarksId" class="extraLarge" value="" />
 <script>document.getElementById('remarksId').value = '<%=remarks%>'</script>
<div class="clear"></div>
</div>
<table>
<tr>
		<th scope="col">Date</th>
		<th scope="col">Tender No.</th>
		<th scope="col">Organization</th>
		<th scope="col">Amount</th>
		<th scope="col">From Date</th>
		<th scope="col">To date</th>
		<th scope="col">Bank Name</th>
	</tr>
	<%
	if(emdRegisterList.size()>0){
		for(FaEmdRegister emdRegister : emdRegisterList){
	
	
	%>
	<tr onclick="submitForm('emdRegister','account?method=editEMDRegister&emdRegisterId=<%=emdRegister.getId()%>')">
	
	<td><%=emdRegister.getDate()!= null ? HMSUtil.convertDateToStringWithoutTime(emdRegister.getDate()) : "" %></td>
	<td><%=emdRegister.getTenderNo() != null ? emdRegister.getTenderNo() :"" %></td>
	<td><%=emdRegister.getOrganization()!= null ? emdRegister.getOrganization():""%></td>
	<td><%=emdRegister.getEmdAmount() != null ?emdRegister.getEmdAmount():""%></td>
	<td><%=emdRegister.getFromDate()!= null?HMSUtil.convertDateToStringWithoutTime(emdRegister.getFromDate()):"" %></td>
	<td><%=HMSUtil.convertDateToStringWithoutTime(emdRegister.getToDate()) %></td>
	<td><%=emdRegister.getBank()!= null ? emdRegister.getBank().getBankName():""%></td>
	
	</tr>

<%}} %>
</table>
<div class="clear"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="submitForm('emdRegister','account?method=submitEMDRegister');" accesskey="a" tabindex=1 />
<input type="button" name="add" id="addbutton" value="Update" class="button" onClick="submitForm('emdRegister','account?method=updateEmdDepositRegister');" accesskey="a" tabindex=1 />
<%-- <input type="button" name="add" id="addbutton" value="Upload" class="button" onClick="submitForm('fdRegister','account?method=uploadFdDocument');" accesskey="a" tabindex=1 />--%>
<input type="reset" name="Reset" id="reset"  value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<%--
<input type="button" name="Report" value="Generate Report" class="buttonBig" onclick="submitForm('emdRegister','account?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="BG_EMD_Register"/>

<input type="button" name="add" id="addbutton" value="Display" class="button" onClick="submitForm('emdRegister','account?method=showVoucherMappingJsp');" accesskey="a" tabindex=1 />--%>


<div class="clear"></div>
<div class="clear"></div>



<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>