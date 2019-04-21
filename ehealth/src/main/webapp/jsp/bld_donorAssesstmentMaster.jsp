<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.BloodSampleCollection"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.BloodDonationEntryHeader"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
	

<div class="titleBg">
<h2>Search</h2>
</div>

<form action="" name="assesstmentMaster" method="post">
<div class="Block">
<label>Sequence Number</label> 
	<input type="text" id="uidNo"  name="sequenceNum" value="" validate="UID,string,no" maxlength="5"
	tabindex="1" /> 	
	
<label>Assestment Name</label> 
	<input type="text"  name="assesstName" value="" validate="BP,string,no" maxlength="200"
	tabindex="1" /> 
	
<!-- <label>Code</label> 
	<input type="text"  name="assesstCode" value="" validate="BP,string,no" maxlength="8"
	tabindex="1" />  -->
	
	
	<input type="button" class="button" value="search" onclick="submitForm('assesstmentMaster','/hms/hms/bloodBank?method=searchAssesstment');"/>
	<div class="clear"></div>
	<c:if test="${not empty requestScope.map.assesstmentList}">    
	
	<table id="massAssesstTable" width="100%" border="0" cellspacing="0" cellpadding="0">
 
		<tr>
			<th>Sequence Number</th>
			<th>Name</th>
			<!-- <th>Code</th> -->
			<th>Category</th>
			<th>Deferred Type</th>
			<th>Satatus</th>
		</tr>
    <c:forEach var='assesstment' items="${requestScope.map.assesstmentList}" >
      <tr  onclick="javascript:getTableRowData(this);">
      <td>${assesstment.assessmentSeqNo}</td>
		<td>${assesstment.assessmentName}</td>
<%-- 		<td >${assesstment.assessmentCode}</td>
 --%>		<td >${assesstment.assessmentCategory}</td>
		<td >${assesstment.assessmentType}</td>
		<td >${assesstment.status}</td>
		<td  style="display:none;">${assesstment.id}</td>
		</tr>
	
</c:forEach>	
	</table>
		
	<div class="clear"></div>
	<div class="clear"></div>
	<%--For displaying Previous link except for the 1st page --%>
    <c:if test="${ requestScope.map.currentPage ge 1}">
        <td><a href="/hms/hms/bloodBank?method=showDonorAssesstmentMasterJsp&page=${requestScope.map.currentPage - 1}">Previous</a></td>
        
    </c:if>
    
    <%--For displaying Page numbers. 
    The when condition does not display a link for the current page--%>
    <table border="0" cellpadding="2" cellspacing="1" style="border-top:1px solid #C0C0C0;">
        <tr>
            <c:forEach begin="1" end="${requestScope.map.noOfPages}" var="i">
                <c:choose>
                    <c:when test="${requestScope.map.currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                      <td><a href="/hms/hms/bloodBank?method=showDonorAssesstmentMasterJsp&page=${i}">${i}</a></td> 
                     <%--    <td onclick="submitFormForButton('donorSearch',
        '/hms/hms/bloodBank?method=showDonorAssesstmentMasterJsp&page=${i}')"${i}</td> --%>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>
     
    <%--For displaying Next link --%>
    <c:if test="${requestScope.map.currentPage lt requestScope.map.noOfPages}">
     <td><a href="/hms/hms/bloodBank?method=showDonorAssesstmentMasterJsp&page=${requestScope.map.currentPage + 1}">Next</a></td>
        <%--  <td onclick="submitFormForButton('donorSearch',
        '/hms/hms/bloodBank?method=showDonorAssesstmentMasterJsp&page=${requestScope.map.currentPage + 1}')"Next</td> --%>
    </c:if>
    </c:if>
<div class="clear"></div>
<div class="titleBg">
<h2>Donor Assesstment Master</h2>
</div>
<div class="clear" style="margin:5px 0px"></div>
<label>Sequence Number</label> 
	<input type="text" id="sequenceId"  name="sequenceNumber"
	 value="" validate="UID,string,no" maxlength="32"
	tabindex="1" /> 
<label>Name</label> 
	<input type="text" id="assesstmentName" name="assesstmentName" value="" 
	validate="BP,string,no" maxlength="100"
	tabindex="1" /> 
	<input type="hidden" id="assesstmentUniqueId" name="assesstmentUniqueId" value=""/>
<label>Deferred Type</label>
	<%-- <input type="text" id="uidNo"  name="<%=UID%>" value="" validate="UID,string,no" maxlength="3"
	tabindex="1" /> --%> 
	 <select  onchange="" id="deferredId" 
	name="type" validate="sex,string,no" tabindex="1">
			<option value="0">Select</option> 
			<option value="Temporary">Temporary deffered</option>
			<option value="Permanently">Permanently deffered </option>
			<option value="Non">Non </option>
			</select>
			
			<div class="clear">
	</div>
	<label>Status</label>
	
	 <select  onchange="" id="statusId" 
	name="status" validate="sex,string,no" tabindex="1">
			<option value="">Select</option>
			<option value="Active">Active</option>
			<option value="InActive">InActive</option>
	
			</select>
<label>Period</label> 
	<input type="text" id="assesstmentCode" name="assesstmentCode" value="" validate="BP,string,no"
	 maxlength="50"
	tabindex="1" /> <label class="smallAuto">In Days</label>
	<div class="clear"></div>

<h4> Category</h4>
<div class="clear"></div>
<label>General</label>
	 <input type="radio"  checked="checked" id="generalId" class="inputRadiobutton" name="category" value="general" validate="UID,string,no" maxlength="3"
	tabindex="1" /> 
	
	<label>Female</label>
	 <input type="radio" id="femalelId" class="radioCheck" name="category" value="female" validate="UID,string,no" maxlength="3"
	tabindex="1" />
<div class="clear"></div>
	
<div id="addbutton">
<input type="button" class="button" value="Add" tabindex="1"
	onclick="submitForm('assesstmentMaster','/hms/hms/bloodBank?method=saveAssesstment');"
	align="right" /> 
	</div>
	<div id="updateButton" style="display: none;">
	<input type="button" class="button" value="Update" tabindex="1"
	onclick="submitForm('assesstmentMaster','/hms/hms/bloodBank?method=updateAssesstment');"
	align="right" /> 
	</div>
	<input type="button" class="buttonHighlight"
	name="newRegister" id="reset" value="Reset" tabindex="1"
	onclick="submitForm('assesstmentMaster','/hms/hms/bloodBank?method=showBloodDonationEntryJsp')" accesskey="r" />	
	<div class="clear"></div>
	
</div>

<script type="text/javascript">
function getTableRowData(row)
{
	
var x=row.cells;
document.getElementById("sequenceId").value = x[0].innerHTML;
document.getElementById("assesstmentName").value = x[1].innerHTML;
document.getElementById("assesstmentCode").value = x[2].innerHTML;
var value=x[3].innerHTML;
if((value.localeCompare("f"))==0){
document.getElementById("femalelId").checked = true;
}
else{
	document.getElementById("generalId").checked = true;
}

document.getElementById("deferredId").value = x[4].innerHTML;
document.getElementById("statusId").value = x[5].innerHTML;
document.getElementById("updateButton").style.display = "";
document.getElementById("addbutton").style.display = "none";

document.getElementById("assesstmentUniqueId").value = x[0].innerHTML;

}
</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

