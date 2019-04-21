
<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * issueToDispensary.jsp
	 * Purpose of the JSP -  This is for issue to Dispensary.
	 * @author  Vivek
	 * @author  Abha
	 * Create Date: 21th Feb,2008
	 * Revision Date:
	 * Revision By:
	 * @version 1.8
	--%>

<%@page import="jkt.hms.masters.business.MasInstituteDepartment"%>
<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<%@page import="jkt.hms.masters.business.StoreSetup"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreIssueT"%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StoreIssueM"%>

<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasHospital"%><script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>

<%
	Map map = new HashMap();
	String userName="";
	String date="";
	String time="";
	String deptName="";
    int userId=0;
	int pageNo=1;
	int indentId=0;
	int internalIndentId=0;
	int listSize=0;
	int issueId=0;
	String max="";
	int issueIdForBarcode=0;
	List<Object[]> employees=new ArrayList<Object[]>();
	List<MasEmployee> employeeDeptByList = new ArrayList<MasEmployee>();
	List<StoreInternalIndentM> storeInternalIndentMList = new ArrayList<StoreInternalIndentM>();
	List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();
	List<StoreInternalIndentM> storeInternalPendingIndentList = new ArrayList<StoreInternalIndentM>();
	List<StoreIssueM> issueMList = new ArrayList<StoreIssueM>();
	List<MasInstituteDepartment> departmentList= new ArrayList<MasInstituteDepartment>();
	List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
	List<MasHospital> toInstituteList = new ArrayList<MasHospital>();
	//List issueTList=new ArrayList();
	List<Object[]> indentTList=new ArrayList<Object[]>();
	List <StoreIssueM> searchListForPopup=new ArrayList<StoreIssueM>();
	StoreSetup storeSetup = new StoreSetup();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Box box=HMSUtil.getBox(request);

	int deptId = 0;
	if(session.getAttribute("deptId") != null){
		deptId = Integer.parseInt(""+session.getAttribute("deptId"));
	}
	 if(session.getAttribute("userId") != null){
		 userId = (Integer)session.getAttribute("userId");
		}

	 // Code By Mukesh Narayan SIngh Date 20 Dec 2010
	 // Code for Display Request By Name from Indent

	 int requestByEmpId=0;
	 //
	 if(map.get("requestByEmpId")!=null){
		 requestByEmpId = (Integer) map.get("requestByEmpId");
		}
		if(map.get("employees")!=null){
			employees = (List<Object[]>) map.get("employees");
		}
		if(map.get("employeeDeptByList")!=null){
			employeeDeptByList = (List) map.get("employeeDeptByList");
		}
		List loginDepartmentStockList = new ArrayList();
		if(map.get("loginDepartmentStockList")!=null){
			loginDepartmentStockList=(List)map.get("loginDepartmentStockList");
		}
		String demandIndentDate="";
		if(map.get("demandIndentDate")!=null){
			demandIndentDate = (String) map.get("demandIndentDate");
		}
		List<MasEmployee>employeeList=new ArrayList<MasEmployee>();
		
	if(map.get("issueIdForBarcode")!=null){
		issueIdForBarcode = (Integer) map.get("issueIdForBarcode");
	}if(map.get("employeeList")!=null){
		employeeList = (List<MasEmployee>) map.get("employeeList");
	}
	int requestNoForAcc=0;
	String demandNoSelected="";
	if(map.get("requestNoForAcc")!=null){
		requestNoForAcc = (Integer) map.get("requestNoForAcc");
		demandNoSelected=""+requestNoForAcc;
	}
	int toInstituteId = 0;
	if(map.get("toInstituteId")!=null){
		toInstituteId = (Integer) map.get("toInstituteId");

	}
	System.out.println("toInstituteIdinoooojsp=="+toInstituteId);
	System.out.println("demandNoSelected=jsp="+demandNoSelected);
		if(map.get("storeSetup")!=null)
			storeSetup = (StoreSetup) map.get("storeSetup");
		if(map.get("storeInternalIndentTList")!=null)
			storeInternalIndentTList = (List) map.get("storeInternalIndentTList");
		if(map.get("departmentList")!=null)
			departmentList = (List) map.get("departmentList");
		if(map.get("itemList")!=null)
			itemList = (List) map.get("itemList");
		if(map.get("internalIndentId")!=null){
			internalIndentId=Integer.parseInt(""+map.get("internalIndentId"));
		}
		if(map.get("toInstituteList")!=null){
			toInstituteList = (List) map.get("toInstituteList");
		}
	//	if(map.get("issueTList")!=null){
	//		issueTList=(List)map.get("issueTList");
	//	}
		if(map.get("indentTList")!=null){
			indentTList=(List)map.get("indentTList");
		}

		if(map.get("deptName")!=null){
			deptName=(String)map.get("deptName");
		}
		List stockList= new ArrayList();
		if(map.get("stockList")!=null){
			stockList=(List)map.get("stockList");
		}
		List loanOutQtyList= new ArrayList();
		if(map.get("loanOutQtyList")!=null){
			loanOutQtyList=(List)map.get("loanOutQtyList");
		}
		int totalPages=0;
		 if(map.get("totalPages")!=null){
			 totalPages=(Integer)map.get("totalPages");
			}
		if(storeInternalPendingIndentList !=null){
			storeInternalPendingIndentList = (List)map.get("storeInternalPendingIndentList");
		}
		List<Object[]> storeInternalIndentPendingList = new ArrayList<Object[]>();
		if(storeInternalIndentPendingList !=null){
			storeInternalIndentPendingList = (List)map.get("storeInternalIndentPendingList");
		}
		if(map.get("storeInternalIndentMList")!=null){
			storeInternalIndentMList=(List<StoreInternalIndentM>)map.get("storeInternalIndentMList");
		}
	
		List<Object[]> storeInternalIndentMPOList = new ArrayList<Object[]>();
		if(map.get("storeInternalIndentMPOList")!=null){
			storeInternalIndentMPOList=(List)map.get("storeInternalIndentMPOList");
		}
		System.out.println("storeInternalIndentMPOList=="+storeInternalIndentMPOList.size());
		if(map.get("searchListForPopup")!=null){
			searchListForPopup=(List<StoreIssueM>)map.get("searchListForPopup");
		}
		if(map.get("max")!=null)
			max = (String) map.get("max");
		if(map.get("pageNo")!=null)
			pageNo = Integer.parseInt(""+map.get("pageNo"));
		if(map.get("listSize")!=null)
			listSize = Integer.parseInt(""+map.get("listSize"));

		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		 date = (String)utilMap.get("currentDate");
		 time = (String)utilMap.get("currentTime");
		 if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
		 if(map.get("issueId")!=null)
			 issueId = Integer.parseInt(""+map.get("issueId")) ;
		 String messageTOBeVisibleToTheUser ="";

			if(map.get("messageTOBeVisibleToTheUser")!=null){
				messageTOBeVisibleToTheUser=(""+map.get("messageTOBeVisibleToTheUser"));
			}
			String messageType ="";
			if(map.get("messageType")!=null){
				messageType=(""+map.get("messageType"));
			}
	//added by Manjul to check already Issued Indent		
			if(map.get("issueMList")!=null){
				issueMList=(List<StoreIssueM>)map.get("issueMList");
			}
	//
%>


<%-- Start of Content Div --%>
<%-- Start of Main Form --%>

<%-- Title --%>
<h4><span id="msgId"></span></h4>
<div class="titleBg">
<h2>Department Issue</h2>
</div>
<!--<div>
<input type="button"tabindex="1" name="print" type="button" class="button" value="Print" onClick="submitForm('issueDispensaryForm','stores?method=showGrnReportJsp');">
</div>-->
<!-- thread search menu -->
<div class="Block">
<form name="search" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<%--------------- Start of Search Panel ---------------------------<label><span>*</span>Issue
No:</label> <select name="<%= RequestConstants.ISSUE_UNIT_ID%>"
	validate="Issue No,string,yes">
	<option value="">Select</option>
	<%for (StoreIssueM storeIssueM :searchListForPopup ) {
		String toDeptName="";
		if(storeIssueM.getToStore()!=null){
			toDeptName=" [ "+storeIssueM.getToStore().getDepartmentName()+" ]";
		}

	%>
	<option value=<%=storeIssueM.getId()%>><%=storeIssueM.getIssueNo()+toDeptName%></option>
	<%}%>
</select> 
<input type="button" name="button" value="Search" class="button" onClick="submitForm('search','stores?method=searchIssueCiv');" />%> 
<div class="clear"></div><%-- 
<label>Print Issue No.</label>
<input type="text" name="issueIdPrint" value=""	tabindex=1 MAXLENGTH="100" id="issueIdPrint" />
<div id="ac2update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('issueIdPrint','ac2update','stores?method=getIssueNoListForAutoComplete',{parameters:'requiredField=issueIdPrint'});
		</script>
<input type="button" name="print" class="button" value="Print" onClick="submitprint('searchPanel');" />
--%>
<script type="text/javascript" language="javascript">
function submitprint(formName){
	var issueId=document.getElementById('issueIdPrint').value;
	if(issueId!=""){
		obj = eval('document.'+formName)
		obj.action = "/hms/hms/stores?method=printDepartmentIssue";
		obj.submit();
	}else{
		alert("Please Insert Issue No. for Print");
		return false;
	}
  }
</script>
</form>


<%-------------------- End of Search Panel ---------------------------%>
<%----------------------Start of show pending Indent------------------%>
<div id="update">
<% int  counter=0; int slNumber = 0;%>
<div id="pageNavPosition"></div>
<h4>Pending Indent</h4>
<div class="clear"></div>
<%if (storeInternalIndentPendingList != null && storeInternalIndentPendingList.size() > 0) {  %>
<table id="searchresulttable" width="100%" cellspacing="0"
	cellpadding="0">
	<tr>
		<th>Sl.No.</th>
		<th>Indent No</th>
		<th>Indent Date</th>
		<th>From Dept</th>
		<th>From Institute</th>
		<th>To Institute</th>
		<th>Requested By</th>
	</tr>
	<tbody id="tableData">
		<%
			String klass = "even";

		 	//for(StoreInternalIndentM storeInternalIndentM : storeInternalIndentPendingList){
		 		for (Iterator iterator = storeInternalIndentPendingList.iterator(); iterator
					.hasNext();) {
				Object[] objects = (Object[]) iterator.next();

				Date date11=  (Date)objects[2];
				String dd=HMSUtil.convertDateTypeToStringWithoutTime(date11);
		 		String id = "";
		 		id = "id" + counter;
		 		counter++;
		 		slNumber = slNumber + 1;
		 		if(counter%2==0){
		 			klass = "even";
		 		}
		 		else
		 		{
		 			klass= "odd";
		 		}

		%>

		<tr class=<%= klass%> id="<%=counter%>">
			<td><%=slNumber%></td>
			<td><%=objects[1]%></td>
			<td><%=dd%></td>
			<td><%=objects[3]%></td>
			<td><%=objects[4]%></td>
			<td><%=objects[5]%></td>
			<td><%=objects[6]%></td>
		</tr>

		<%
		  	}
		  	%>
	</tbody>
</table>
<input type="hidden" name="pageEditNo" id="pageEditNo" value="<%=pageNo %>"/>
<script>
			var pager = new Pager('tableData',2);
			pager.init();
			pager.showPageNav('pager', 'pageNavPosition');
			pager.showPage(1);
		  </script>
<div class="clear"></div>
<label>&nbsp;</label> <%
		 }
		else{
		%>
<h4><%-- <span>No Record Exists</span>--%></h4>
<div class="clear"></div>
<%}%>
</div>
<%----------------------End of show pending Indent---------------------%>

<%--------------- Start of Tool Panel ---------------------------%>

<div class="clear"></div>

<!-- <input type="button" name="Add" type="submit"  value="Add" class="button">
	<input type="button" name="Modify" type="submit" value="Modify" class="button"  onClick="submitForm('poMain','purchaseOrder?method=poModifyJsp');">
	<input type="button" name="Reset" type="submit" value="Reset" class="button" >

	<input type="button" name="Delete" type="submit"  value="Delete" class="button"  onClick="openDeletePopupForIssueciv();">
	-->


<%--------------- End of Tool Panel ---------------------------%>

<div class="division"></div>

</div>

<%--------------------Start of Status message  ---------------------------%>
<%if(!(messageTOBeVisibleToTheUser.equals("") ) || (messageTOBeVisibleToTheUser !=null) ){
					if(messageType.equals("success")){%>
<h4><%=messageTOBeVisibleToTheUser %></h4>
<%}%>
<%if(messageType.equals("failure")){%>
<span> <%=messageTOBeVisibleToTheUser %> </span>
<%}}%>
<%--------------------End of Status message  ---------------------------%>
<form name="issueToOtherInstitute" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input
	type="hidden" name="rows" id="rr" value="1" validate="rows,int,no"/> <input type="hidden"
	name="listSize" value="<%=listSize%>" validate="listSize,int,no"/> <input type="hidden"
	name="pageNo" value="<%=pageNo%>" validate="pageNo,int,no"/> <input type="hidden"
	name="<%=RequestConstants.ISSUE_ID%>" id="issueId" value="<%=issueId%>" validate="issueDate,date,no"/>
<div class="Block">
<div class="clear"></div>
<h4>Issue Details</h4>
<div class="clear"></div>
<input type="hidden" name="issueIdForBarcode"
	id="issueIdForBarcode" value="<%=issueId %>" validate="issueIdForBarcode,int,no"/> <label> Issue
No. </label> 
<%// %>
<input type="text" name="issueNo" id="issueNo" readonly="readonly"	value="<%=max%>" tabindex="1" MAXLENGTH="8" />
<label>Issue Date</label> <input type="text" name="<%=ISSUE_DATE%>" tabindex="1" id="issueDate"
	class="readOnly" readonly="readonly" value="<%=date %>" MAXLENGTH="30" validate="issueDate,date,no"/>

<label><span>*</span>To Institute </label> <select
	name="toInstitute" tabindex="1" id="instituteIdTemp"
	validate="To Institute,metachar,yes" onchange="isDispenserySelected();">
	<option value="">Select</option>
	<%for (MasHospital masHospital :toInstituteList) {	
		if(masHospital.getId().equals(toInstituteId)){
	%>
	<option value=<%=masHospital.getId()%> selected="selected"><%=masHospital.getHospitalName()%></option>
	<%}else{	%>
	<option value=<%=masHospital.getId()%> ><%=masHospital.getHospitalName()%></option>
	<%}} %>
</select>
<div class="clear"></div>
<label><span>*</span>To Department </label> <select
	name="<%=DEPARTMENT_ID_TEMP%>" tabindex="1" id="departmentIdTemp"
	validate="To Department,metachar,yes" onchange="isDispenserySelected();">
	<option value="">Select</option>
	<%for (MasInstituteDepartment masInstituteDepartment :departmentList ) {	%>
	<option value=<%=masInstituteDepartment.getDepartment().getId()%>><%=masInstituteDepartment.getDepartment().getDepartmentName()%></option>
	<%}	%>
</select>
<script>
document.getElementById('departmentIdTemp').value = '<%=box.get("departmentIdTemp")%>'

</script>
<label>Reference No.</label> <input type="text" tabindex="1"
	name="<%=REFERENCE %>" tabindex="1" id="reference"  
	value="<%=box.get("reference") %>" MAXLENGTH="30" /> <label>Indent
Date</label>
 <%
 if(demandIndentDate!=""){
	 %>
	 <input type="text" tabindex="1" name="<%= REQUEST_DATE %>" readonly="readonly"  value="<%=demandIndentDate %>" MAXLENGTH="30" validate="requestDate,date,no"/>
	 <%
 }else{
	 %>
	 <input type="text" tabindex="1" name="<%= REQUEST_DATE %>" readonly="readonly"  value="<%=date %>" MAXLENGTH="30" validate="requestDate,date,no"/>
	 <%
 }
 %>
 <div class="clear"></div>
 <%-- <label><span>*</span>Request By</label> 
 <select  name="<%= REQUEST_BY%>" id="requestBy" tabindex="1" validate="Request By,String,Yes" >
	<option value="">Select</option>
	<%for (MasEmployee masEmployee :employeeList) {
	
	//
	if(requestByEmpId==masEmployee.getId()){
		//
	//	
		//
	
	%>
	<option value=<%=masEmployee.getId()%> selected="selected"><%=masEmployee.getFirstName().concat(" ").concat(masEmployee.getLastName())%></option>
		<%}else{ 
		%>
<option value=<%=masEmployee.getId()%>><%=masEmployee.getFirstName().concat(" ").concat(masEmployee.getLastName())%></option>
		
		<%} %>
	<%}%>
</select>
<script type="text/javascript">
<%

if(requestByEmpId != 0){

%>
document.issueToOtherInstitute.<%=REQUEST_BY%>.value = '<%=requestByEmpId%>';
<%
}%></script>
	



<label><span>*</span>Approved By</label> <select name="<%= APPROVED_BY%>" tabindex="1" id="approvedBy" validate="Approved By,String,Yes" onchange="isDispenserySelected();">
	<option value="">Select</option>
	<%
	for (MasEmployee masEmployee :employeeDeptByList ) {%>
	<option value=<%=masEmployee.getId()%>
		<%=HMSUtil.isSelected(masEmployee.getId().toString(),box.get("approvedBy")) %>><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
	<%}%>
</select> <label><span>*</span>Issued By</label> <select name="<%= ISSUED_BY%>" tabindex="1" id="issuedBy" validate="Issued By,String,Yes">
	<option value="">Select</option>
	<%for (MasEmployee masEmployee :employeeDeptByList ) {%>
	<option value=<%=masEmployee.getId()%>
		<%=HMSUtil.isSelected(masEmployee.getId().toString(),box.get("issuedBy")) %>><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
	<%}%>
</select> --%>

<%-- 
//demandListAjax
//previously this method is used on Demand No on Change; Code Commented By Mukesh Narayan Singh Date 27 Dec 2010
//stores?method=searchInternalIndentDetails--%>


<label><span>*</span>Indent No.</label>
<div id="testDiv"><select  name="<%= REQUEST_NO%>" tabindex="1"
	validate="Indent No ,string,yes" id="requestNo"
	onchange="submitForm('issueToOtherInstitute','stores?method=searchIndentDetailsForOtherInstitute');">
	<option value="0">Select Indent No</option>
	<%for(Object[]  obj : storeInternalIndentMPOList){
		String tempDemandId="";
		tempDemandId=""+obj[0];
		//System.out.println("tempDemandId222=="+tempDemandId);
		//System.out.println("demandNoSelected=22="+demandNoSelected);
			if(demandNoSelected.equalsIgnoreCase(tempDemandId)){
			%>
			<option value="<%=obj[0] %>" selected="selected"><%=obj[1] %></option>
			<%
		}else{
			%>
			<option value="<%=obj[0] %>"><%=obj[1] %></option>
			<%
		}
		//requestNoForAcc

}	%>
</select>
</div>
<div class="clear"></div></div>
<input type="hidden" name="internalIndentId"	value="<%=internalIndentId%>" validate="internalIndentId,int,no"/>
<!-- Code commented by vikas for adjust loan out -->
<!--
				       Adjust Loan Out Button is not applicable for Dispensary
				       --> <%// if (storeSetup.getStoreDispensary().getId() != deptId) { %>
<!-- <div class="clear"></div>
						<input type="button" onclick="if(testForAdjustLoanOut()){submitForm('issueDispensaryForm','stores?method=showAdjustLoanOut');}" value="Adjust Loan Out" class="buttonBig"/>
						 --> <% //} %> <!-- Code commented by vikas for adjust loan out -->

<!--  Commented By Ritu --> <!--<input type="button"tabindex="1" class="button" value="Next"  onclick="if(checkIssueQty()){submitForm('issueDispensaryForm','stores?method=addNextOrSubmitIssue&buttonName=next');}" align="right" />
    <input type="button" tabindex="1" name="sss" align="right"
	class="button" value="Submit"
	onclick="if(checkIssueQty()){submitForm('issueDispensaryForm','stores?method=addNextOrSubmitIssue&buttonName=submit');}" />
 -->




<div class="clear"></div>


<input type="hidden" size="2" value="0" name="noOfRecords"
	id="noOfRecords" validate="noOfRecords,int,no"/> <input type="hidden"
	name="<%=RequestConstants.INDENT_ID %>" value="<%=indentId%>" id="hdb" validate="indentId,int,no"/>

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>


<%-- <!--  Commented By Ritu --> <!--<div id="pagination">
		Page <span class="selected"><%=pageNo %></span> of <span class="selected"><%=totalPages %></span>
		<a onclick="javascript:goNext()" class="next" >Next</a>
		<input type="button" name="Go Page" type="submit" class="button" value=" " onclick="goPage();">
		<input type="text" name="gopage" size="3" />

	</div>

		--> --%>
<input type="hidden" name="requestNo1" id="requestNo1" value=""  />

<input type="hidden" size="2" value="0" name="noOfRecords"
	id="noOfRecords" validate="noOfRecords,int,no"/> <input type="hidden"
	name="<%=RequestConstants.INDENT_ID %>" value="<%=indentId%>" id="hdb"   />
 
<div class="clear"></div>
<%
if(indentTList.size()>0){ %>
<h4>Item Details</h4>
<div class="clear"></div>
<div class="cmntable">
<table colspan="7" id="indentDetails">
	<thead>
		<tr>

			<th width="5%">S.No.</th>
			<th width="13%">Item No</th>
			<th width="10%">Item Name</th>
			<th width="13%">A/U</th>
			<%-- <th width="13%">BarCode No</th>
			<th width="13%">Batch No</th>
			<th width="13%">Expiry Date</th>--%>
			<th width="13%">Indent Dept. Stock</th>
			<th width="13%">Issue Stock</th>
			<th width="13%">Qty Requested</th>
			<th width="13%">Issue</th>
			<th width="13%">Qty Issued</th>
			<th width="3%">&nbsp;</th>
		</tr>
	</thead>
	<tbody>
		<%
	    	int inc= 0;
	    	try{
    	int detailCounter=10;
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idAu="idAu";
    	String qtyRequested="qtyRequested";
    	String loanOutQty="loanOutQty";
    	String incVar="incVar";
    	String issuedItemId="issuedItemId";
    	String batchNo="batchNo";
    	String barCodeNo="barCodeNo";
    	String batchNo2="batchNo";
    	String barCodeNo2="barCodeNo";
    	String expiryDate="expiryDate";
    	String expiryDate2="expiryDate";
    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String idAu2="idAu";
    	String qtyRequested2="qtyRequested";
    	String loanOutQty2="loanOutQty";
    	String incVar2="incVar2";
    	String issuedItemId2="issuedItemId";
    	String srNo = "srNo";
    	String srNo2 = "srNo";
    	String qtyIssued="qtyIssued";
    	String qtyIssued2="qtyIssued";
    	String detailId="detailId";
    	String detailId2="detailId";
    //	inc=((pageNo-1)*20)+1;
    //	int tempVar=((pageNo-1)*20)+1;

 	//   int incTemp2=inc+20;
 	inc=((pageNo-1)*indentTList.size())+1;
   	int tempVar=((pageNo-1)*indentTList.size())+1;

 	 int incTemp2=inc+indentTList.size();
 	  	for (Iterator iterator = indentTList.iterator(); iterator.hasNext();)
		{
		 Object[] object = (Object[]) iterator.next();

 		  tempVar--;

 		  if(inc<incTemp2){

     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		idAu=idAu2+(""+inc);
     		qtyRequested=qtyRequested2+(""+inc);
     		incVar=incVar2+(""+inc);
     		issuedItemId=issuedItemId2+(""+inc);
     		qtyIssued=qtyIssued2+(""+inc);
     		detailId=detailId2+(""+inc);
     		loanOutQty=loanOutQty2+(""+inc);
     		batchNo=batchNo2+(""+inc);
     		barCodeNo=barCodeNo2+(""+inc);
     		expiryDate=expiryDate2+(""+inc);
     		srNo = srNo2+(""+inc);


    	  %>

		<tr>
		 <input type="hidden" name="tt8" id='issueQtyAndBatch<%=inc %>' value="blank" readonly="readonly"/>
		 <input type="hidden" name="tt6" id="quantityToIssueOverAll<%=inc%>" value="" readonly="readonly"/>
			<td width="5%"><input type="text" size="2" tabindex="1"
				value="<%=temp+inc%>" id="srNo<%=inc %>"
				name="<%=RequestConstants.SR_NO%>" readonly="readonly" /></td>
			<td width="10%"><input type="text" size="8" tabindex="1"
				name="<%=RequestConstants.ITEM_CODE%>"
				value="<%=object[1].toString() %>" id="<%=codeItem%>" />
				 <input	type="hidden" size="2" value="<%=object[0].toString() %>"
				name="<%=RequestConstants.ITEM_ID%>" id="<%=idItem%>" />
				<input
				type="hidden" size="2" value="<%=object[6].toString() %>"
				name="<%=RequestConstants.DETAIL_ID%>" id="<%=detailId%>" />

				</td>
			<td width="10%"><input type="text" tabindex="1" size="50"
				value="<%=object[2].toString() %>" readonly="readonly"
				name="<%=RequestConstants.NOMENCLATURE%>" /></td>
			<td width="10%">
			<%
      String conv = null;
      try
      {
	  		conv = object[3].toString();
	  }
      catch(Exception e )
      {
	   	  e.printStackTrace();
	   	  conv="";
	  }
	  %> <input type="text" size="8" value="<%=conv%>" tabindex="1"
				readonly="readonly" name="<%=RequestConstants.AV%>" id="<%=idAu%>" />
				<input type="hidden" size="8" value=""
				maxlength="30" tabindex="1" name="barCodeNo" id="barCodeNo<%=inc %>"
				onblur="getDataForBarcode(this.value,<%=inc %>)" />
			</td>
		<%-- 	<td width="10%"><input type="text" size="8" value=""
				maxlength="30" tabindex="1" name="barCodeNo" id="barCodeNo<%=inc %>"
				onblur="getDataForBarcode(this.value,<%=inc %>)" /></td>
			<td width="10%"><input type="text" size="8" value=""
				maxlength="20" tabindex="1" name="batchNo" id="batchNo<%=inc %>" />
			</td>
			<td width="10%"><input type="text" size="8" value=""
				maxlength="20" tabindex="1" name="expiryDate"
				id="expiryDate<%=inc %>" /></td>--%>

			<td width="10%">
			<%if(inc<=stockList.size()){%> <input type="text" tabindex="1" size="8"
				value="<%=((BigDecimal)stockList.get(inc-1)).intValue() %>" id="availableStock<%=inc %>"
				class="medcaption" readonly /> <%}else{ %> <input type="text"
				tabindex="1" size="8" value="" id="availableStock<%=inc %>"
				class="medcaption" readonly /> <%} %>
			</td>
			<td width="10%">
			<%if(inc<=loginDepartmentStockList.size()){%> <input type="text" tabindex="1" size="8"
				value="<%=((BigDecimal)loginDepartmentStockList.get(inc-1)).intValue() %>" id="loginDeptStock<%=inc %>"
				class="medcaption" readonly /> <%}else{ %> <input type="text"
				tabindex="1" size="8" value="" id="loginDeptStock<%=inc %>"
				class="medcaption" readonly /> <%} %>
			</td>
<%
	BigDecimal qtyIssueRequest = new BigDecimal(0);
	if(object[7] != null){
		qtyIssueRequest =  new BigDecimal(object[7].toString());
	}
	BigDecimal qtyIssueDB = new BigDecimal(0);
	BigDecimal issyeRequestDiff = new BigDecimal(0);
	if(object[8] != null){
		qtyIssueDB =  new BigDecimal(object[8].toString());
	}
%>

			<td width="10%">
			<%if(qtyIssueRequest.intValue()!=0 && qtyIssueDB.intValue()!=0 && !qtyIssueRequest.equals(qtyIssueDB)){
				issyeRequestDiff =qtyIssueRequest.subtract(qtyIssueDB);

			%><input type="text" tabindex="1" size="8"
				value="<%=issyeRequestDiff%>" readonly="readonly"
				name="<%=RequestConstants.QTY_IN_REQUEST%>" id="<%=qtyRequested%>" />
			<%}else if(qtyIssueRequest.equals(qtyIssueDB)){%>
			<input type="text" tabindex="1" size="8"
					value="<%=qtyIssueRequest%>" readonly="readonly"
					name="<%=RequestConstants.QTY_IN_REQUEST%>" id="<%=qtyRequested%>" />
			<%}else{%>
			<input type="text" tabindex="1" size="8"
				value="<%=qtyIssueRequest%>" readonly="readonly"
				name="<%=RequestConstants.QTY_IN_REQUEST%>" id="<%=qtyRequested%>" />
			<%}%>
			<%try{ %>
			<input type="hidden" value="<%=object[2].toString() %>" tabindex="1"
				id="<%=nameItem%>" name="<%=nameItem%>" />
			<%}catch(Exception e ){ %>
			<input type="hidden" value="" id="<%=nameItem%>" name="<%=nameItem%>" />
			<%} %>
			<input type="hidden" value="<%=object[9].toString() %>" tabindex="1"
				id="<%=srNo%>" name="<%=srNo%>" />
			</td>


			<!-- Code commented by vikas For loan out
	       If id in StoreSetup is equivalent to login Id then display this coloumn
	       otherwise dont display.
	       -->
			<%--//if (storeSetup.getStoreDispensary().getId() == deptId) { %>
	      <!-- <td width="10%">
	      <input type="text" readonly="readonly" value="<%=map.get(storeIssueT.getItem().getId().toString()) %>"  name="loanOutQty" tabindex="2" align="right" />
	      </td>
	       -->
	      <% //} --%>
			<!-- Code commented by vikas For loan out-->
			<td width="10%">
			<%if(qtyIssueRequest.equals(qtyIssueDB)){ %>
			<input type="text" size="8" readonly="readonly"
				 value="<%=qtyIssueDB%>" name="qtyIssued<%=inc %>" tabindex="2"
				id="qtyIssued<%=inc %>" align="right" />
			<%}else{%>
			<input type="text" size="8" readonly="readonly"
				 name="qtyIssued<%=inc %>" tabindex="2"
				id="qtyIssued<%=inc %>" align="right" />
			<%}%>
				<input type="hidden"
				value="<%=object[0].toString() %>" name="issuedItemId" tabindex="2"
				id=<%=issuedItemId%> align="right" /></td>
				<%
				Date reqDate  = new Date();
					if(object[10] != null){
						 reqDate = (Date)(object[10]);
					}
				%>
			<td width="3%">
			<%if(qtyIssueRequest.equals(qtyIssueDB)){%>
			<font face="arial" size="4" color="red">Issued</font>
			<%}else{ %>
			<input type="button" tabindex="1"
				class="buttonIssue" tabindex="1"
				onclick="{openPopupForBrand(this.value,'<%=object[7].toString()%>',<%=inc%>,<%=issueId %>,<%=object[6].toString() %>,<%=object[5].toString() %>,'<%=HMSUtil.convertDateToStringWithoutTime(reqDate)%>');}"
				name="Submit2" value=" " />
			<%}%>
				</td>
		<input type="hidden" name="indentDtId" id="indentDtId<%=inc %>"   validate="indentDId,int,no"/>
		</tr>
		<% inc++;}  }
 	  //	if(inc<=(pageNo-1)*20+20){
			//  for(;inc<=(pageNo-1)*20+20;inc++){%><%-- <!--
		    			   <tr>
	      <td width="5%"><input type="text" size="2"tabindex="1"	value="<%=temp+inc%>"id="srNo<%=inc %>"  name="<%=RequestConstants.SR_NO%>" readonly="readonly" /></td>
	      <td width="10%">

	     <input type="text" size="8" tabindex="1" name="<%=RequestConstants.ITEM_CODE%>" value=""  id="<%=codeItem%>"/>
	      <input type="hidden" size="2"	value="0" validate="Qty Requested Year,floatWithoutSpaces,no" MAXLENGTH="7" name="<%=RequestConstants.ITEM_ID%>" id="<%=idItem%>" />

	      </td>
	      <td width="10%">
	      	<input type="text" tabindex="1" value=""	id="<%=nameItem%>"    name="<%=RequestConstants.NOMENCLATURE%>" /></td>
	     <td width="10%">
	        <input type="text"size="8" value=""  tabindex="1"readonly="readonly" name="<%=RequestConstants.AV%>"  id="<%=idAu%>"/>
	        </td>
	         <td width="10%">
		   <input type="text"size="8" value=""  maxlength="30" tabindex="1" name="barCodeNo"  id="barCodeNo<%=inc %>"  onblur="getDataForBarcode(this.value,<%=inc %>)"/>
		  </td>
		  <td width="10%">
		   <input type="text" size="8" value="" maxlength="20" tabindex="1" name="batchNo"  id="batchNo<%=inc %>"/>

		  </td>
		   <td width="10%">
		   <input type="text"size="8" value="" maxlength="20" tabindex="1" name="expiryDate"  id="expiryDate<%=inc %>"/>

		  </td>
	       <td width="10%">
     		 <input type="text"size="8" value=""	id="availableStock<%=inc %>"   readonly />
     	 </td>
	      <td width="10%"><input type="text"size="8"	value=""   readonly="readonly" name="<%=RequestConstants.QTY_IN_REQUEST%>"  id="<%=qtyRequested%>"/>


	      </td>

	   		 <input type="hidden" value=""	id="<%=nameItem%>"    name="<%=RequestConstants.ISSUED_ITEM%>" />


	      <td width="10%"><input type="text"size="8" tabindex="1" readonly="readonly"	value=""  name="<%=RequestConstants.QTY_ISSUED%>" tabindex="2" id="qtyIssued<%=inc %>" />
	      </td>
	      <td>
	       <input type="button" class="buttonIssue" tabindex="1" onclick="" name="Submit2" value=" "  />
	      </td>
	          </tr>
		    			  --> --%>
		<%//}}
 	  }catch(Exception e ){e.printStackTrace();}
 	  if(requestNoForAcc>0){
 	  %>

	<tr>
		 <td>

		 <input type="hidden" value="<%=requestNoForAcc%>" id="requestNoForAcc" name="requestNoForAcc" />
	   <!--     <input type="button" class="button" tabindex="1" onclick="submitForm('issueDispensaryForm','stores?method=correctDepartmentIssueToAcknowledgement');" name="Submit2" value="Correct"  /> -->
	      </td>
	</tr>

	<%} %>
	</tbody>

</table>
</div>
<input type="button" class="button" tabindex="1" onclick="if(validateIssue()){submitForm('issueToOtherInstitute','stores?method=submitIssueForOtherInstituteIndent');}" name="Submit11" value="Save" id="Save" />
<input type="hidden" id="counter" value="<%=inc %>" validate="counter,int,no"/>
<%}%>

 <script
	type="text/javascript">
		<!--
			// Main vBulletin Javascript Initialization
			vBulletin_init();
		//-->
		</script>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label></div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></form>
<div class="clear"></div>
<div class="paddingTop40"></div>
<%-- End of Main form --%>
<div>
	<input type="hidden" name="addBatchItemCounter" id="addBatchItemCounter" value="0" />
	<table id="batchWiseItem">

	</table>
</div>

<script type="text/javascript">


	function checkIssueQty(){
		var issued = "no";
		for(var i=1;i<document.getElementById('counter').value;i++){
			if(document.getElementById('qtyIssued'+i)){
				if(parseInt(document.getElementById('qtyIssued'+i).value) > 0){
					issued = "yes";
					break;
				}else{
					issued = "no";
				}
			}
		}
		if(issued == "yes"){

			return true;
		}else{
			alert("Issue Quantity can not be blank. ");
			return false;
		}
		return false;
	}



	function checkForSubmit()
  {
	  if(document.getElementById('noOfRecords').value==0)
	  {
	  alert("There must be one detail row");
	  return false;
	  }
	  return true;
  }
	function fillSrNo(rowVal){
	var pageNo=parseInt(document.getElementById('noOfRecords').value);
   		rowVal=rowVal%10
   		if(rowVal==0){
   			rowVal=10
   	 		}
   		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRecords').value=rowVal
			}
	return true;

}

	function test(indentId)
{
   var reqId = "";
 	<% for(int i=0;i<storeInternalIndentMList.size();i++)
 	{ %>
 		if (indentId == <%=storeInternalIndentMList.get(i).getId()%>)
 		{
			reqId = '<%=storeInternalIndentMList.get(i).getRequestedBy().getId()%>';
 		}
	<%}
	%>

	var obj = document.getElementById('requestBy');
	for(i=0;i<obj.length;i++)
	{
		if (reqId == obj.options[i].value)
		{
			obj.selectedIndex = i;
			break;
		}

	}
}

function confirm()
{
	formName="issueToOtherInstitute";
	obj = eval('document.'+formName);
//	if((document.getElementById('issuedBy').value != "") &&(document.getElementById('departmentIdTemp').value != "") &&(document.getElementById('requestBy').value != ""))
		if((document.getElementById('departmentIdTemp').value != "") &&(document.getElementById('requestBy').value != ""))
	{
    	obj.action = "/hms/hms/stores?method=searchInternalIndentDetails";
    	obj.submit();
    }
	else
	{
		alert("Pl. check the Input Values!.........")
		return false
	}
}

function testForAdjustLoanOut(deptName)
{
	var errorMessage="";
	formName="issueToOtherInstitute"
	obj = eval('document.'+formName)

/* 	if(document.getElementById('issuedBy').value == "")
		errorMessage=errorMessage+"Please Select Issue By \n";
	if(document.getElementById('approvedBy').value == "")
		errorMessage=errorMessage+"Please Select Approved By \n"; */
	//if(document.getElementById('requestBy').value == "")
		//errorMessage=errorMessage+"Please Select Requested By \n";
	if(document.getElementById('departmentIdTemp').value == "")
		errorMessage=errorMessage+"Please Select Dispensary \n";
	if(deptName=="Dispensary Store")
	{
	if(document.getElementById('reference').value == "")
		errorMessage=errorMessage+"Please Fill Reference No \n";
	}
	if(document.getElementById('requestNo').value == ""){
	errorMessage=errorMessage+"Please Select Demand No..";
	}

	if(deptName=="Dispensary Store")
	{
	// && (document.getElementById('requestBy').value != "")
	//	if((document.getElementById('issuedBy').value != "") &&(document.getElementById('reference').value != "") &&(document.getElementById('departmentIdTemp').value != "") &&(document.getElementById('approvedBy').value != ""))
			if((document.getElementById('reference').value != "") &&(document.getElementById('departmentIdTemp').value != "") )
		{
			return true;
		}
		else
		{
			alert(errorMessage);
			return false
		}
	}
	else
	{
	// &&(document.getElementById('requestBy').value != "")
	//	if((document.getElementById('issuedBy').value != "") &&(document.getElementById('departmentIdTemp').value != "") &&(document.getElementById('approvedBy').value != ""))
			if((document.getElementById('departmentIdTemp').value != "") )
		{
		return true;
		}
		else
		{
		alert(errorMessage)
		return false
		}
	}
}
	function isDispenserySelected()
	{
		if(document.getElementById('instituteIdTemp').value=="" || document.getElementById('departmentIdTemp').value=="")
		{
			//alert("Dispensery Name...!")
			return false;
		}
		else
		{
			submitProtoAjax('issueToOtherInstitute','stores?method=getIndentListForIssueToOtherInstitute&instituteIdTemp='+document.getElementById('instituteIdTemp').value+'departmentIdTemp='+document.getElementById('departmentIdTemp').value);
		}
	}
	function ajaxFunctionForIsDispenserySelected(formName,action)
	{

  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
    	alert(e)
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }
    var url=action;
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	obj =document.getElementById('requestNo');
		obj.length = 1;
		obj.options[0].value=0;
				obj.options[0].text="Select Demand No.";
      	for (loop = 0; loop < items.childNodes.length; loop++)
      	{

	   	    var item = items.childNodes[loop];
	        var id  = item.getElementsByTagName("id")[0];
	        var demandNo  = item.getElementsByTagName("demandNo")[0];



				obj.options[obj.length-1].value=id.childNodes[0].nodeValue;

        		obj.options[obj.length-1].text = demandNo.childNodes[0].nodeValue;
        			 	obj.length++;
      }
    }
  }
}
 function getDataForBarcode(val,rowVal){

 if(val!=""){

 submitProtoAjaxForBarcodeData('issueDispensaryForm','stores?method=getDataForBarcode&barcodeNo='+val+'',rowVal);


 }

 }
	function isToDepartmentSelected(){

	if(document.getElementById('toDeptId').value==""){
	alert("Department Name...!")
		return false;
	}else{
		submitProtoAjax('searchPanel','stores?method=getIssueList&toDeptId='+document.getElementById('toDeptId').value);
	}
	}

	function checkForLoanout()
	{
		if(document.getElementById('departmentIdTemp').value=="")
		{
			alert("Dispensery Name...!")
			return false;
		}
		else
		{
			submitForm('issueDispensaryForm','stores?method=showAdjustLoanOut&departmentIdTemp='+document.getElementById('departmentIdTemp').value);
		}
	}

function testForLotNo(value)
{
		if(value =="")
		{
			return false;
		}
		else
		{
			return true;
		}
}

function goPage(){

if(<%=totalPages%>==0){
alert("There are no pages to navigate");
return false;
}
else{

submitForm('issueDispensaryForm','stores?method=addNextOrSubmitIssue&buttonName=goToPage');
}
}
function goNext(){
var toatlPages=<%=totalPages%>;
if(toatlPages==0){
alert("There are no pages to navigate");
return false;
}
else{

submitForm('issueDispensaryForm','stores?method=addNextOrSubmitIssue&buttonName=next');
}
}
function cheackForSelect(){
if(document.getElementById("requestNo").value!=""){
document.getElementById("requestNo1").value=document.getElementById("requestNo").value;
return true;}
else{
alert("pls select demand no..");
return false;
}
}

function validateIssue()
{

	if(document.getElementById("departmentIdTemp").value=="")
	{
		alert('Select The Department !!!');
		document.getElementById("departmentIdTemp").focus();
		return false;
	}
	/* if(document.getElementById("requestBy").value=="")
	{
		alert('Select The Requested BY !!!');
		document.getElementById("requestBy").focus();
		return false;
	}
	if(document.getElementById("approvedBy").value=="")
	{
		alert('Select The Approved By !!!');
		document.getElementById("approvedBy").focus();
		return false;
	}

	if(document.getElementById("issuedBy").value=="")
	{
		alert('Select The Issue By !!!');
		document.getElementById("issuedBy").focus();
		return false;
	} */

	if(document.getElementById("requestNo").value=="")
	{
		alert('Select The Demand No !!!');
		document.getElementById("requestNo").focus();
		return false;
	}else{
		return true;
	}
}
//function checkIssueNo()
//{
	//var issueNo=document.getElementById("issueNo").value;
	//var requestNo=document.getElementById("requestNo").value;
	//var departmentIdTemp=document.getElementById("departmentIdTemp").value;
	//alert(issueNo);
	//alert(requestNo);
	//alert(departmentIdTemp);
	//submitForm('issueDispensaryForm','stores?method=checkIssueNo&issueNo='+issueNo+'&requestNo='+requestNo+'&departmentIdTemp='+departmentIdTemp);
	//disableSave();
//}

function disableSave(){
	var save=document.getElementById("Save");
	if(issueMList.size()> 0 ){
		alert("This Indent No is Already Issued..")
	document.getElementById("Save").disabled=true;
		return false;
	}
	else if(issueMList.size()= 0){
	return true;
}
}
	</script>