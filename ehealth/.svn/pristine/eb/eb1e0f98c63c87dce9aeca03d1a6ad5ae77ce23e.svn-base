<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * referralDoctor.jsp  
 * Purpose of the JSP -  This is for Referral Doctor.
 * @author Ujjwal

 * Create Date: 16th Feb,2013 
 * Revision Date:      
 * Revision By:  
 * @version 1.4
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Patient"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	employeeList = (ArrayList)map.get("employeeList");
	List<Patient> patientList = new ArrayList<Patient>();
	patientList = (ArrayList)map.get("patientList");
	
	if(map.get("message") != null){
		 String  message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		 <%} %>
<div class="titleBg">
<h2>Referral Patient Slip</h2>
</div>
<form name="referral" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<div class="Block">
<%for(Patient pt:patientList){ %>
<label>Reg. No.</label>
<input type="text" name="<%=HIN_NO %>" id="hinIdNo" value="<%=pt.getHinNo() %>" readonly="readonly"  />
<input type="hidden" name="<%=HIN_ID %>" id="hinId" value="<%=pt.getId() %>"  />
<label>Patient Name</label>
<input type="text" name="<%=P_FIRST_NAME %>" id="pName" value="<%=pt.getPFirstName().concat(" ").concat(pt.getPLastName()) %>"  />
<label>Age</label>
<input type="text" name="age" id="ageId" value="<%=pt.getAge() %>"  />
<label>Sex</label>
<input type="text" name="sex" id="sexId" value="<%=pt.getSex().getAdministrativeSexName() %>"  />
<div class="clear"></div>
<label>Father's Name</label>
<input type="text" name="fatherName" id="fatherNameId" value=""  maxlength="30" />
<label>Contact No.</label>
<input type="text" name="contactNo" id="contactNoId" value="" maxlength="15"  />
<label>Referred On</label>
<input type="text" name="referredDate" maxlength="10" id="referredDateId"  value="" placeHolder="dd/mm/yyyy" onkeypress="return isNumber(event)" onkeyup="
		var v = this.value;
		if (v.match(/^\d{2}$/) !== null) {
			this.value = v + '/';
		} else if (v.match(/^\d{2}\/\d{2}$/) !== null) {
			this.value = v + '/';
		}" />
 <label for="time">at</label>
<input type="text" id="time" maxlength="5" name="time" onkeypress="return isNumber(event)" placeHolder="hh:mm" onkeyup="
		var v = this.value;
		if (v.match(/^\d{2}$/) !== null) {
			this.value = v + ':';
		} else if (v.match(/^\d{2}\/\d{2}$/) !== null) {
			this.value = v + ':';
		}" />
		<label for="time">TO</label>
<input type="text" id="toId" maxlength="5" name="toName" onkeypress="return isNumber(event)" placeHolder="hh:mm" onkeyup="
		var v = this.value;
		if (v.match(/^\d{2}$/) !== null) {
			this.value = v + ':';
		} else if (v.match(/^\d{2}\/\d{2}$/) !== null) {
			this.value = v + ':';
		}" />
		<label>Facility Center</label>
<input type="text" id="facilityId" maxlength="50" name="facilityIdName"  />	
		<label>Facility Center Address</label>
<input type="text" id="facilityAddId" maxlength="500" name="facilityAddIdName"  />	
		<label>Facility Center Telephone</label>
<input type="text" id="facilityCntctId" maxlength="50" name="facilityCntctIdName"  />	


<label>Diagnosis <span>*</span></label>
<input type="text" value="" tabindex="1" id="icd" name="icd" />
<div id="ac2update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('referral','ac2update','opd?method=getICDList',{minChars:3,parameters:'requiredField=icd'});
			</script>
	
<label>Admitted Date</label>
<input type="text" name="AdmittedOn" id="AdmittedId" maxlength="10" onkeypress="return isNumber(event)"  value="" placeHolder="dd/mm/yyyy" onkeyup="
		var v = this.value;
		if (v.match(/^\d{2}$/) !== null) {
			this.value = v + '/';
		} else if (v.match(/^\d{2}\/\d{2}$/) !== null) {
			this.value = v + '/';
		}" />
 <label for="time">Admitted Time</label>
<input type="text" id="admittedtime" maxlength="5" onkeypress="return isNumber(event)" name="admittedtime" placeHolder="hh:mm" onkeyup="
		var v = this.value;
		if (v.match(/^\d{2}$/) !== null) {
			this.value = v + ':';
		} else if (v.match(/^\d{2}\/\d{2}$/) !== null) {
			this.value = v + ':';
		}" />`

<label>Summary of Procedure</label>
<textarea name="summaryName"   id="summaryId"  ></textarea>
<label>Drug Administered</label>
<textarea name="drugAdministered" id="drugAdministeredId" ></textarea>
<label>Investigation Done</label>
<textarea name="investigationDone" id="investigationDone" ></textarea></div>
<div class="clear"></div>
<h4>Condition At the time of Reffer</h4>
<div class="clear"></div>
<div class="Block">
<label>General:</label>
<input type="text" name="general" id="generalId" value="" maxlength="50" />
<label>CNS:</label>
<input type="text" name="cns" id="cnsId" value="" maxlength="50" />
<label>RESP:</label>
<input type="text" name="resp" id="respId" value=""  maxlength="50"/>
<label>CARDIAC:</label>
<input type="text" name="cardiac" id="cardiacId" value="" maxlength="50" />
<label>RENAL:</label>
<input type="text" name="renal" id="renalId" value="" maxlength="50" />
<label>Others:</label>
<input type="text" name="others" id="othersId" value="" maxlength="50"/>
<label>Information on referral provide to the institution referred to:</label>
<select name="info" id="infoid" onchange="checkPerson(this.value);">
<option value="">Select</option>
<option value="y">Yes</option>
<option value="n">No</option>

</select><div class="clear"></div>
<div id="personId" style="display: none">
<label>Person Spoken To</label>
<input type="text" name="personSpoken" id="personSpokenId" value="" maxlength="15"/>
</div>
</div>
<%} %>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" value="submit" onClick="submitForm('referral','/hms/hms/opd?method=submitReferalPatient');" /> 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<script>
function checkPerson(person){
	//alert("person---------------->"+person);

	if(person=='y'){
document.getElementById("personId").style.display='block';
		}else if(person=='n'){
document.getElementById("personId").style.display='none';
		} else if(person==''){
document.getElementById("personId").style.display='none';
		}
} 

function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}
</script>
</form>