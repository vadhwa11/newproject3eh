<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : investigationOrderBooking.jsp
	 * Tables Used         :
	 * Description         : For OrderBooking For OP .
	 * @author Name        : Dipali
	 * Revision Date:      Revision By:
	 * @version 1.0
--%>
<%@page import="jkt.hms.masters.business.StoreIssueM"%>
<%@page import="jkt.hms.masters.business.StoreIssueT"%>
<%@page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@ page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>

<form name="returnIssueDrug" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<script type="text/javascript">
		history.forward();
</script>
	<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(dateCal.length()<2){
	dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
	</script>
	<%
		URL myURL = application
				.getResource("/WEB-INF/commonFile.properties");
		InputStream in = myURL.openStream();
		Properties prop = new Properties();
		prop.load(in);
		int pageNo = 1;
		Map<String, Object> map = new HashMap<String, Object>();

		Map<String, Object> utilMap = new HashMap<String, Object>();
		Patient patient = null;
		StoreIssueM issueM = null;
		List<StoreIssueT> storeIssueTs = new ArrayList<StoreIssueT>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Integer doctorId = null;
		String admissionNumber = "";
		String userName = "";
		String deptType = "";
		int dgOrderhdId = 0;
		int inpatientId = 0;
		int hinId = 0;
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties
				.getProperty("empCategoryCodeForDoctor");
		Box box = HMSUtil.getBox(request);

		if (request.getAttribute("map") != null) {
			map = (Map<String, Object>) request.getAttribute("map");
		}
		if (map.get("issueTs") != null) {
			storeIssueTs = (List<StoreIssueT>) map.get("issueTs");
			if(storeIssueTs.size()>0){
			issueM = storeIssueTs.get(0).getIssueM();
			}
		}
		
				
		if (map.get("patient") != null) {
			patient = (Patient) map.get("patient");
		}
		//added by govind 30-9-2016
		int retCount=0,rowCount=0;
		System.out.println(" patient jsp "+(patient!=null));
	%>
	<div class="clear"></div>
	<%if(patient!=null){ %>
	<h4>Patient Details</h4>
	<div class="clear"></div>
	<div class="Block">
		<label>Issue No</label> <label class="value"> <%=issueM.getIssueNo()%><input type="hidden" name="issueNo" value="<%=issueM.getIssueNo()%>"/>
		</label> <label>Issue Date</label> <label class="value"><%=issueM.getIssueDate()%></label>
		<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label> <label
			class="value"><%=patient.getHinNo()%></label>
		<div class="clear"></div>
		<label>Patient Name</label> <label class="value"><%=patient.getFullName()%></label>
		<label>Gender</label> <label class="value"><%=patient.getSex().getAdministrativeSexName()%></label>
		<label>Marital Status</label>
		<%
			String maritalStatus = "";
			if (patient.getMaritalStatus() != null) {
				maritalStatus = patient.getMaritalStatus()
						.getMaritalStatusName();
			}
		%>
		<label class="value"><%=maritalStatus%></label>
		<div class="clear"></div>

		<%
				String age = "";
				String currentAge = "";
				if(patient.getAge()!=null){
					age = patient.getAge();
					currentAge = HMSUtil.calculateAgeForADT(age,
							patient.getRegDate());
				}
				
				
		%>
		<label>Age</label> <label class="value"><%=currentAge%></label> 
		<div class="clear"></div>

		<div class="clear"></div>
	</div>
	<%}%>
	<div class="clear"></div>

	<div class="clear"></div>
	<div class="clear"></div>
	<%if(storeIssueTs.size()>0){ %>
	<div class="tableHolderAuto">
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			id="chargeDetails">
			<tr>
				<th scope="col">Item Name</th>
				<th scope="col">Item Code</th> 
				<th scope="col">Batch No</th> 
				<th scope="col">Expiry Date</th>
				<th scope="col">Issued Quantity</th>
				<th scope="col">Returned Quantity</th>  
				<th scope="col">Return Qty</th>  <!-- added by amit das on 09-06-2016 -->
				<th scope="col">Remark</th>
				<th scope="col">Replace</th>
				<th scope="col">Return</th>
				
			</tr>
			<% 
			int i=0;
			for(StoreIssueT issueT:storeIssueTs){ rowCount=rowCount+1;
			%>
			
			<tr>
				
				<td scope="col"><%=issueT.getItem().getNomenclature() %></td>
				<td scope="col"><%=issueT.getItem().getPvmsNo() %></td>
				<td scope="col"><%=issueT.getBatchNo() %></td>
				<td scope="col"><%=HMSUtil.changeDateToddMMyyyy(issueT.getExpiryDate())%></td>
				<td scope="col"><%=issueT.getQtyIssued().intValue() %>
				<input type="hidden" name="issuedQty" id="issuedQty<%=i%>" value="<%=issueT.getQtyIssued()%>">
				</td>
				<td scope="col">
				<%if(issueT.getQtyReturned()!=null){ %>
				<%=issueT.getQtyReturned().intValue() %>
				<input type="hidden" name="returnedQty" id="returnedQty<%=i%>" value="<%=issueT.getQtyReturned().intValue()%>">
				<%}else{%>
				<%="0"%>
				<input type="hidden" name="returnedQty" id="returnedQty<%=i%>" value="<%="0"%>">
				<%}%>
				</td>  
				<td scope="col">
				<%if(issueT.getQtyReturned()!=null){ %>
				<%if(issueT.getQtyReturned().equals(issueT.getQtyIssued())){ 
				retCount=retCount+1;
				%>
				<input type="text" disabled="disabled" >
				<%}else{ %>
				<input type="text" name="returnDrugNo<%=i%>" validate="Return Drug,int,no" id="returnDrugNoId<%=i%>" onblur="validateQty(<%=i%>)">
				<%}}else{ %>
				<input type="text" name="returnDrugNo<%=i%>" validate="Return Drug,int,no" id="returnDrugNoId<%=i%>" onblur="validateQty(<%=i%>)">
				<%} %>
				</td>
				<td scope="col">
				<%if(issueT.getQtyReturned()!=null){ %>
				<%if(issueT.getQtyReturned().equals(issueT.getQtyIssued())){ %>
				<input type="text"  disabled="disabled"></input>
				<%}else{ %>
				<input type="text" name="remark<%=i%>" ></input>
				<%}}else{ %>
				<input type="text" name="remark<%=i%>" ></input>
					<%} %>
				</td> 
				
				<td scope="col">
		        <%if(issueT.getItemReplacedToPharmacy()!=null){ %> 
				<%if(issueT.getItemReplacedToPharmacy().equalsIgnoreCase("y")){ %>
				<input type="checkbox" disabled="disabled" />
				<%}else{ %>
				<input type="checkbox" value="<%=issueT.getId() %>" name="selectedRowForReplace<%=i%>" onclick="checkForReplace(<%=issueT.getId()%>);" id="selectedRowForReplaceId<%=i%>">
                <%}}else{%>	
                <input type="checkbox" value="<%=issueT.getId() %>" name="selectedRowForReplace<%=i%>" onclick="checkForReplace(<%=issueT.getId()%>);" id="selectedRowForReplaceId<%=i%>">
                <%} %>			
				</td>

				<td scope="col">
				<input type="hidden" value="<%=issueT.getId()%>" name="issueTId<%=i%>"></input>	
				<%if(issueT.getQtyReturned()!=null){ %>	
				<%if(issueT.getQtyReturned().equals(issueT.getQtyIssued())){ %>	
				<input type="checkbox" disabled="disabled" >
				<%}else{ %>
				<input type="checkbox" value="yes" name="selectedRow<%=i%>" onclick="checkTestRow(<%=i%>);" id="selectedRowId<%=i%>">
				<%}}else{ %>
				<input type="checkbox" value="yes" name="selectedRow<%=i%>" onclick="checkTestRow(<%=i%>);" id="selectedRowId<%=i%>">
                <%} %>
				</td>  
			</tr>
			<%i++;}%>  
		</table>
		<input type="hidden" name="totalRow" id="rowCount" value="<%=rowCount%>"></input>
		<input type="hidden" name="retCount" value="<%=retCount%>"></input>
		<input type="hidden" name="totalRow" value="<%=i%>"></input>
		<%if(rowCount!=retCount){ %>	
		<input type="button" class="button" value="Return"
				id="submitForDisable"
				onclick="if(validReturn()){submitForm('returnIssueDrug','stores?method=returnIssueDrug');}" />
	    <%} %>
	<div class="clear"></div>
	
	<div id="replaceDiv"></div>




</div>
	<%}%>
	<div class="clear"></div>

	<div class="paddFltRight110"></div>
	<div class="clear"></div>
	<div class="division"></div>

	<div class="clear"></div>



	<div class="clear"></div>
	<div class="division"></div> 
	<div class="clear"></div>
	<div class="division"></div>
	<div class="bottom">
		<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
			Date</label> <label class="value"><%=date%></label> <label>Changed
			Time</label> <label class="value"><%=time%></label>
	</div>
	<!--Bottom labels ends-->
	<div class="clear"></div>
	<div class="paddingTop40"></div>
</form>
<script type="text/javascript">
function checkTestRow(inc){ 
	var drug=document.getElementById('returnDrugNoId'+inc).value;
	var regex=/^[0-9]+$/; 
	 if(!drug.match(regex) || drug==""){
		 document.getElementById("selectedRowId"+inc).checked=false;
		 alert("Please enter the return drug");
	 } 
	
}
</script>
<script>
function checkForReplace(val){
	//alert("val--->>"+val);
	submitProtoAjaxWithDivName('returnIssueDrug','stores?method=getItemForReplace&issueTId='+val,'replaceDiv')
	
	
}


/* function getBatchDetails(itemId,qtyIssued,csrfToken,csrfValue){
	
	//alert("itemId---->>>>"+itemId);
	var issueTId=document.getElementById("issueTId").value;
	//alert("issueTId"+issueTId);
	var url="/hms/hms/stores?method=getPopupValueForItemReplacement&itemId="+itemId+"&issueTId="+issueTId+"&qtyIssued="+qtyIssued+"&"+csrfToken+"="+csrfValue;
//	alert(+"&csrfTokenName="+csrfTokenValue)
	window.open(url,'name',"height=400,width=700,status=1");
	
} */
// commented by amit das on 09-06-2016
// added by amit das on 09-06-2016

function getBatchDetails(itemId,qtyIssued,qtyReturned,csrfToken,csrfValue){
	
	//alert("itemId---->>>>"+itemId);
	var issueTId=document.getElementById("issueTId").value;
	//alert("issueTId"+issueTId);
	var url="/hms/hms/stores?method=getPopupValueForItemReplacement&itemId="+itemId+"&issueTId="+issueTId+"&qtyIssued="+qtyIssued+"&qtyReturned="+qtyReturned+"&"+csrfToken+"="+csrfValue;
//	alert(+"&csrfTokenName="+csrfTokenValue)
	window.open(url,'name',"height=400,width=700,status=1");
	
}


</script>
<script>
function validateQty(id)
{
	//alert(id);
var issuedQty = document.getElementById('issuedQty'+id).value;
var pastReturnedQty = document.getElementById('returnedQty'+id).value;
var intvalue = Math.round(issuedQty);
var intvalueForPastReturnedQty = Math.round(pastReturnedQty);
var returnedQty =document.getElementById('returnDrugNoId'+id).value;

if(returnedQty>(intvalue-intvalueForPastReturnedQty))
	{
	alert("Return Drug can not be Greater than Remaining Issued Quantity.");
	document.getElementById('returnDrugNoId'+id).value = "";
	 return false;
}
else
{
return true; 
}
}
//added by govind 3-10-2016
function validReturn(){
	var result = true;
	var count = 0;
	var iteration;
	
	var hdb = document.getElementById('rowCount');
	iteration = parseInt(hdb.value);
	//alert("rowCount "+iteration);
	
var f=0,ch=0;
	for (var i = 0; i < iteration; i++) {

		/*if (document.getElementById('selectedRowId' + i).checked==false){
			 f=f+1;
		}*/
		if(document.getElementById('selectedRowId' + i)!=null){
		if (document.getElementById('selectedRowId' + i).checked==true){
			 ch=1;
		}
		}
	}
	//alert("ch value "+ch);
	if(ch==1){
		result=true;
	}else{
		alert("Please click the Return check box");
		result=false;
	}
	//alert("finale result "+result);
	//result=false;
return result;
}
//added by govind 3-10-2016 end 
</script>