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
<div class="clear"></div>
<div class="Block">
<%for(Patient pt:patientList){ %>
<label>Reg. No.</label>
<input type="text" name="<%=HIN_NO %>" id="hinIdNo" value="<%=pt.getHinNo() %>" readonly="readonly"  />
<input type="hidden" name="<%=HIN_ID %>" id="hinId" value="<%=pt.getId() %>"  />
<label>Patient Name</label>
<input type="text" name="<%=P_FIRST_NAME %>" readonly="readonly" id="pName" value="<%=pt.getPFirstName()!=null?pt.getPFirstName().concat(" ").concat(pt.getPLastName()!=null?pt.getPLastName():""):"" %>"  />
<label>Age</label>
<input type="text" name="age" id="ageId" readonly="readonly" value="<%=pt.getAge()!=null?pt.getAge():"" %>"  />
<label>Sex</label>
<input type="text" name="sex" id="sexId" readonly="readonly" value="<%=pt.getSex()!=null?pt.getSex().getAdministrativeSexName():"" %>"  />
<%} %>
<div class="clear"></div>
<h4>Examination</h4>
<div class="Block">
<label>General Physical</label>
<textarea rows="5" cols="10" name="generalPhysic" onblur="checkLength(this.value);" id="generalPhysic"></textarea>
<div class="clear"></div>
<label>Systemic Examination</label>
<input type="text" name="sysExam" maxlength="50" id="sysExamId" value="" />
<label>Res. System</label>
<input type="text" name="resSystem" maxlength="50" id="resSystemId" value="" />
<label>CVS</label>
<input type="text" name="CVS" maxlength="50" id="cvsId" value="" />
<div class="clear"></div>
<label>P/A</label>
<input type="text" name="pa" id="paId" value="" />
<label>Gentio Urinary</label>
<input type="text" name="gentio" maxlength="50" id="gentioId" value="" />
<label>CNS</label>
<input type="text" name="cns" maxlength="50" id="cnsId" value="" />
<label>ANS</label>
<input type="text" name="ans"  maxlength="50" id="ansId" value="" />
</div>
<div class="clear"></div>
<h4>Investigation</h4>
<div class="clear"></div>
<h4>Blood Report</h4>
<div class="clear"></div>
<div class="Block">
<label>Blood Group</label>
<input type="text" name="grp"  id="grpId" value=""  />
<label>Haemogram</label>
<input type="text" name="haemo" maxlength="5" id="haemoId" value="" />
<label>Hb%</label>
<input type="text" name="hb" maxlength="5" id="hbId" value=""  onkeypress="return isNumber(event)" />
<label>TLC</label>
<input type="text" name="tlc" maxlength="5" id="tlcId" value=""  onkeypress="return isNumber(event)" />
<h4>DLC</h4>
<label>P</label>
<input type="text" name="p" maxlength="5" id="pId" value=""  onkeypress="return isNumber(event)" />
<label>L</label>
<input type="text" name="l" maxlength="5" id="lId" value=""  onkeypress="return isNumber(event)" />
<label>E</label>
<input type="text" name="e" maxlength="5" id="eId" value=""  onkeypress="return isNumber(event)" />
<label>M</label>
<input type="text" name="m"  maxlength="5" id="mId" value=""  onkeypress="return isNumber(event)" />
<label>B</label>
<input type="text" name="b"  maxlength="5" id="bId" value=""  onkeypress="return isNumber(event)"  />
</div>
<div class="clear"></div>
<h4>Eye:</h4>
<div class="Block">
<label>Activity of Vision</label>
<input type="text" name="eyeActivity"  maxlength="50" id="eyeActivityId" value="" />
<label>Color of Vision</label>
<input type="text" name="Color"  maxlength="50" id="ColorId" value="" />
<label>Overall Health of the Examinee</label>
<textarea rows="10" cols="20" name="ohe" id="oheId"> </textarea>
<label>Any other remarks based on the health medical checkup of the Examinee</label>
<textarea rows="10" cols="20" name="ace" id="aceId"> </textarea>
<div class="clear"></div>
<label>Hospital</label>
<select name="hospitalName" id="hospitalId">
<option value="VBCH">Shri Vinoba Bhave CIVIL Hospital</option>
<option value="RKS">RKS</option>
</select>
</div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" value="Submit" onclick="submitForm('referral','opd?method=submitPatientForFitness');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<script>
function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        alert("Please Enter integer value");
        return false;
    }
    return true;
}
function checkLength(val){
	var length=val.length;
	if(length>500){
alert("Limit Exceeded");
		}
}
</script>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>