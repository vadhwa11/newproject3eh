<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<SCRIPT language=javascript src="/hms/jsp/js/common.js"	type=text/javascript></SCRIPT>
<SCRIPT language=javascript src="/hms/jsp/js/hms.js"	type=text/javascript></SCRIPT>
<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"	type=text/javascript></SCRIPT>

<SCRIPT>
		<%
		int pageNo=1;
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
			serverdate = '<%=dateCal+"/"+month+"/"+year%>'
		</SCRIPT>
<%
		Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("map") != null) {
			map = (Map<String,Object>) request.getAttribute("map");
		}
		List<StoreInternalIndentM> storeInternalPendingIndentList = new ArrayList<StoreInternalIndentM>();
		List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();



			if(map.get("storeInternalPendingIndentList")!=null){
				storeInternalPendingIndentList=(List<StoreInternalIndentM>)map.get("storeInternalPendingIndentList");
			}
					if(map.get("storeInternalIndentTList")!=null){
						storeInternalIndentTList=(List<StoreInternalIndentT>)map.get("storeInternalIndentTList");
					}
		
	%>


<script type="text/javascript">
function check(){
var SDate = document.report.<%= FROM_DATE%>.value;
var EDate = document.report.<%= TO_DATE %>.value;
var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))
if(startDate > endDate)
{
alert("Please ensure that the To Date is greater than or equal to the From Date.");
document.calldate.next_day.focus();
return false;
}
}
</script>
<%-- <%
	if(!message.equals("")){
%>
<h4><span><%=message %></span></h4>
<%} %>
 --%>

<%for(StoreInternalIndentM object:storeInternalPendingIndentList)
{
	
%>

<form name="getDetailsPendingIndentApproval" method="post" action="">
<div class="titleBg">
<h2>Indent Approval</h2>
</div>
<div class="clear"></div>
<div class="Block" >
 
<input type="hidden" name="<%=INDENT_NO%>" value="<%=object.getId() %>"  MAXLENGTH="30" readonly="readonly" validate="indentNo,string,no"/>
<label > Indent No</label> 
<input type="text" name="" value="<%=object.getDemandNo() %>"  MAXLENGTH="30" readonly="readonly" validate="indentNo,string,no"/> 

<label > Indent Date</label> 
<input type="text"	name="" value="<%=HMSUtil.convertDateToStringWithoutTime(object.getDemandDate())%>" class="date" MAXLENGTH="30"	readonly="readonly" validate="indentDate,date,no"/> 

<label>From Department</label> 
<input type="text"	name="" value="<%=object.getDepartment().getDepartmentName()%>"  MAXLENGTH="30"	readonly="readonly" validate="FromDept,metachar,no"/>
<div class="clear" ></div>
<label > To  Department</label> 
<input type="text"	name="" value="<%=object.getToStore().getDepartmentName()%>" 	maxlength="30" tabindex=1  readonly="readonly" validate="toDept,metachar,no"/>
<!-- <label >Request By </label>  -->
<%-- <input type="text"	name="" value="<%=object.getRequestedBy().getFirstName() %>" 	maxlength="30" tabindex=1 /> --%>
<!-- <label >Approved By </label>  -->
<%-- <input type="text"	name="" value="<%=object.getApprovedBy().getFirstName() %>" 	maxlength="30" tabindex=1 /> --%>
<div class="clear" ></div>

<label> Item Group. </label> 
<input type="text"	name="" value="" 	maxlength="30" tabindex=1 readonly="readonly" validate="itemGroup,string,no"/>

<label> Indent Type. </label> 
<input type="text"	name="" value="<%=object.getIndentType()%>"  readonly="readonly"	maxlength="30" tabindex=1 validate="IndentType,string,no"/>   
<% }%>
<!-- <label class="auto">Pending</label> 
<input type="radio"	name="dispensType" value="pending" checked="checked" class="radioCheck">
<label class="auto">Issued</label> 
<input type="radio"	name="dispensType" value="issued" class="radioCheck"> 
<label	class="auto">All</label> 
<input type="radio" name="dispensType"	value="all" class="radioCheck"> 
<div class="clear"></div> -->
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
	<!--  <a href="/hms/hms/stores?method=showDetailPendingDispensing" >Dispensing details(Grid Onclick)</a> -->
       
      <div id="update">
<% int  counter=1; int slNumber = 0;%>
<div id="pageNavPosition"></div>
<h4>Indent Details</h4>
<div class="clear"></div>
<%
 if (storeInternalIndentTList != null && storeInternalIndentTList.size() > 0)  
	/* for(StoreInternalIndentT object:storeInternalPendingIndentList) */
{  %>
<table id="searchresulttable" width="100%" cellspacing="0"
	cellpadding="0">
	<tr>
		<th>Sl.No.</th>
		<th>Item code</th>
		<th>Item Name</th>
		<th>Unit</th>
		<th>Available Stock</th>
		<th>Required Qty</th>
		<th>Indent Qty</th>
		<th>Status</th>
		<th>Remarks</th>
	</tr>
	<tbody id="tableData">
		<%
			String klass = "even";

		 	//for(StoreInternalIndentM storeInternalIndentM : storeInternalIndentPendingList){
		 		for (StoreInternalIndentT object:storeInternalIndentTList) {
			
		 		if(counter%2==0){
		 			klass = "even";
		 		}
		 		else
		 		{
		 			klass= "odd";
		 		}

		%>

		<tr class=<%= klass%> id="<%=counter%>">
		<td><%=counter%></td>
		<%-- 	<td><a href="javascript:Request('<%= object[0]%>','pendingIndent')"><%= object[1]%></a></td> --%>
			<td><%=object.getItem().getId() %></td> 
			<td><%=object.getItem().getNomenclature()%></td>
			<td></td>
			<td><%=object.getStockInHand()%></td>
			<td><%=object.getQtyRequest()%></td> 
			<td><input type="text" name="<%=QTY_IN_REQUEST_DEPARTMENT_INDENT%><%=counter%>" value="<%=object.getQtyRequest()%>">
			  
			     </td>
			     
			<td>
			<select  name="<%=REQUEST_STATUS%><%=counter%>">
			<option value="Approved">Approved</option>
			<option value="Reject">Reject</option>
			</select>
			</td>
			<td><textarea name="<%=REMARKS%><%=counter%>" cols="30" rows="5"></textarea></td> 
			
		</tr>

		<%
		++counter;	}
		 		
		 		
		  	%>
	</tbody>
</table>
<input type="hidden" name="pageEditNo" id="pageEditNo" value="<%=pageNo %>" validate="pageEditNo,int,no"/>
<input type="hidden" name="counter" id="counter" value="<%=counter %>" validate="counter,int,no"/>
<!-- <script> function Request(obj,formName){
	
	if(formName == 'pendingIndent'){
		
		obj1 = eval('document.'+formName)
		var hin = obj;
		alert(hin);
		url = "/hms/hms/stores?method=getDetailsPendingIndentApproval&id="+hin;
	   	obj1 .action = url;
		obj1 .submit(); 
	}
}
			var pager = new Pager('tableData',5);
			pager.init();
			pager.showPageNav('pager', 'pageNavPosition');
			pager.showPage(1);
		  </script> -->
<div class="clear"></div>
 <% }
		else{
		%>
<h4><span>No Record Exists</span></h4>
<div class="clear"></div>
<%}%>
</div>
<div class="clear"></div>
<label style="text-align: left;width: 100px!important;"> Remarks</label> 
  <textarea rows="4" cols="50" name="<%=OTHERS_REMARKS%>" validate="otherRemarks,remarks,no">
</textarea>
<div class="paddingTop15"></div>
<div class="clear"></div>

<input type="button" class="button" value="Submit" align="left"	onclick="submitForm('getDetailsPendingIndentApproval','/hms/hms/stores?method=intraIndentApproval');"></input>     
<input type="button" class="button" value="Reject" align="left"	onclick="submitForm('getDetailsPendingIndentApproval','/hms/hms/stores?method=intraIndentReject');"></input>
       <div class="clear"></div>

<%-- <%
			String includedJsp ="";
			if(map.get("includedJsp") != null){
				includedJsp = (String)map.get("includedJsp");
			}
			
			if(!includedJsp.equals("")){
			%>
<jsp:include page="<%=includedJsp%>" flush="true" />
<%} %> --%>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
