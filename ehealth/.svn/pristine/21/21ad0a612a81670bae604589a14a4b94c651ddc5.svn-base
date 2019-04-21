<%@ page import="static jkt.hms.util.RequestConstants.WEIGHT"%>
<%@ page import="static jkt.hms.util.RequestConstants.HEIGHT"%>
<%@ page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>


<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Properties"%>

<%

URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);

Map<String, Object> map = new HashMap<String, Object>();

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}

List<OpdPatientDetails> pendingDietList = new ArrayList<OpdPatientDetails>();
if(map.get("pendingDietList") != null){
	pendingDietList =(List<OpdPatientDetails>)map.get("pendingDietList");
}
OpdPatientDetails opdDetails = (OpdPatientDetails)pendingDietList.get(0);
%>
<form method="post" action="" name="dietPendingForm">
<div class="Block">
<label class="auto">Height :</label>
<%
if(opdDetails.getHeight()!=null && opdDetails.getHeight()!=0)
{
%>
<input type="text" id="<%=HEIGHT%>" name="<%=HEIGHT%>"
	value="<%=opdDetails.getHeight()%>" validate="height,int,no" maxlength="3" class="small" tabindex="2" /><label	class="smallAuto">cm</label>
<%}else{ %>
<input type="text" id="<%=HEIGHT%>" name="<%=HEIGHT%>" value=""
	validate="height,int,no" maxlength="3" class="small" tabindex="2" /><label	class="smallAuto">cm</label>
<%} %>

<label class="auto">Weight :</label>
<%
if(opdDetails.getWeight()!=null && opdDetails.getWeight()!=0)
{
%>
<input  type="text" id="<%=WEIGHT%>" name="<%=WEIGHT%>"
	value="<%=opdDetails.getWeight()%>" tabindex="1" validate="weight,int,no" maxlength="3" class="small"/> <label class="smallAuto">kg</label>
<%}else{ %>
<input type="text" id="<%=WEIGHT%>"  name="<%=WEIGHT%>" value=""
	validate="weight,int,no" maxlength="3" class="small" tabindex="1" /> <label class="smallAuto">kg</label>
<%} %>

<label>Patient History :</label>
<%
if(opdDetails.getDietPatientHistory()!=null)
{

%>
<textarea name="dietPatientHistory" id="dietPatientHistory" tabindex="3"
cols="0" rows="0"  maxlength="300" validate="patient History,string,no"
onkeyup="return checkLength(this)"><%=opdDetails.getDietPatientHistory()%></textarea>
<%}else{ %>
<textarea name="dietPatientHistory"  id="dietPatientHistory" tabindex="3"
	cols="0" rows="0"  maxlength="300" validate="patient History,string,no" onkeyup="return checkLength(this)">
</textarea>

<%} %>
<label >Prescribed Diet Details :</label>
<%
if(opdDetails.getDietPrescribedDetails()!=null)
{
%>
<textarea name="dietPrescribedetails" id="dietPrescribedetails" cols="0"
validate="Prescribed Diet Details,string,no" tabindex="4" rows="0" maxlength="300"
onkeyup="return checkLength(this)"><%=opdDetails.getDietPrescribedDetails()%></textarea>
 <%}else{ %>
<textarea name="dietPrescribedetails" id="dietPrescribedetails" cols="0"
	validate="Prescribed Diet Details,string,no" tabindex="4" rows="0" maxlength="300" onkeyup="return checkLength(this)">
 </textarea>
 <%} %>
 <input type="hidden" name="opdPatientId" id="opdPatientId" value="<%=opdDetails.getId()%>" />
 </div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="Submit" type="button" align="right" tabindex="5"
	class="button" value="Submit" onclick="submitForm('dietPendingForm','/hms/hms/diet?method=updatePatientDiet');"/>
<input name="print" type="button" align="right" class="button"
	value="Print" tabindex="6" onclick="submitForm('dietPendingForm','/hms/hms/diet?method=printDietDetails');"/>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>



