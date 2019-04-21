<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : finalDischarge.jsp
	 * Tables Used         :
	 * Description         :
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By:
	 * @version 1.0

--%>


<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Discharge"%>
<%@page import="jkt.hms.masters.business.BlFinalBillDetails"%>

<%@page import="jkt.hms.masters.business.Inpatient"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<form name="finalDischargeSearch" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();

		List<Discharge> dischargeList = new ArrayList<Discharge>();
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}

		if(map.get("departmentList") != null){
			wardList = (List<MasDepartment>)map.get("departmentList");
		}
		if(patientMap.get("dischargeList") != null){
			dischargeList= (List<Discharge>)patientMap.get("dischargeList");
		}
		String message = "";
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
	%> <script type="text/javascript">
	function validatePatientDischarge(){


	for(var i = 0; i < document.getElementsByName('parent').length; i++){

		if(document.getElementsByName('parent')[i].checked == true)
		{

			var status=document.getElementById('finalBillDetail'+i).value
			var dischargeStatus = document.getElementById('dischargeStatus'+i).value;

			if(dischargeStatus =="y")
			{

			return true;
			}else{
				if(status == "s"){
					return true;
				}else{
					alert("Patient Cannot Be Discharged Without Final Bill Settlement.")
					return false;
				}
			}
	   }
	 }
	alert("Please select the patient")
	return false;

	}

	<%
		if(!message.equals("")){
			%>
			var msg = "<%=message%>";
			alert(msg);

		<%}
	%>
	</script>
<div class="titleBg">

<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 21 July 2010
 -->
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<h2>Patient Search</h2>
</div>
<div class="clear"></div>
<div class="Block"><%--
  			<label class="bodytextB">Service No:</label>
			<input type="text" name="<%=SERVICE_NO %>" value="" style="width: 100px" class="textbox_size20" MAXLENGTH="30" />
	 	--%> <label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <input type="text" name="<%=HIN_NO %>"
	value=""
	onblur="if(this.value!=''){submitForm('finalDischargeSearch','/hms/hms/adt?method=showReadyToDischargeList');}"
	MAXLENGTH="30" /> <label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label> <input type="text"
	name="<%=AD_NO %>" value="" MAXLENGTH="30" /> <label>Ward</label> <select
	name="<%=WARD_ID %>">
	<option value="0"><--Select Ward--></option>
	<%
     for(MasDepartment masDepartment : wardList){
    	 if(map.get("departmentId") != null ){
    		 int deptId = (Integer)map.get("departmentId");
    		 if(deptId == masDepartment.getId()){
    	%>
	<option value="<%=masDepartment.getId() %>" selected="selected"><%=masDepartment.getDepartmentName() %></option>
	<%	 	}
    		 if(deptId != masDepartment.getId()){
      %>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%}
     }else{%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%
     }
     }
    	 %>
</select>

<div class="clear"></div>
</div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<input type="button" name="Search" id="addbutton"
	onclick="submitForm('finalDischargeSearch','/hms/hms/adt?method=showReadyToDischargeList');"
	value="Search" class="button" accesskey="a" />

<div class="clear"></div>
<%
if(dischargeList!=null)
{
%>
<jsp:include page="searchResultBlock.jsp" />
<%} %>
<div class="clear"></div>
<form name="finalDischarge" method="post" action="">

<div id="test">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


<script type="text/javascript">

   formFields = [
    [0, "<%= DISCHARGE_ID%>", "id"],[1,"<%= RADIO_FOR_TABLE%>"], [2,"<%=AD_NO%>"], [3,"<%= HIN_NO %>"],[4,"<%=PATIENT_NAME  %>"],[5,"<%=WARD_NAME  %>"],[6,"billSettlementStatus"],[7,"dischargeFlagForPatientType"]];
     statusTd = 5;

   </script></div>
</div>

<div class="clear"></div>
<input type="button" name="discharge" id="dischargeButton"
	style="display: none;" value="Discharge" class="button"
	onClick="if(validatePatientDischarge()){submitForm('finalDischarge','adt?method=dischargePatient','validateRadio');}"
	accesskey="a" tabindex=1 /> <!--
<input type="button" name="addInfo" id="addInfoId"  style="display: none;"  value="Add Info" class="button" onClick="if(validateRadio()){showAddInfoPopUp();}" accesskey="a" tabindex=1/>
--> <input type="button" name="yes" value="Print" class="button"
	id="dsPrint" style="display: none;"
	onclick="submitForm('finalDischarge','/hms/hms/ipd?method=showDischargeSlipReport','validateRadio');" />
<script type="text/javascript">
function showAddInfoPopUp(obj,objName){
	var url = '/hms/hms/adt?method=showAdditionalInfoJsp';
	newwindow=window.open(url,'name','left=200,top=100,width=700,height=250');

}

</script> <script type="text/javascript">
data_header = new Array();

   	data_header[0] = new Array;
	data_header[0][0] = "Radio"
	data_header[0][1] = "radio";
	data_header[0][2] = "4%";
	data_header[0][3] = "<%=RADIO_FOR_TABLE%>"



    data_header[1] = new Array;
    data_header[1][0] = "<%=prop.getProperty("com.jkt.hms.ipd_no") %>"
    data_header[1][1] = "data";
    data_header[1][2] = "14%";
    data_header[1][3] = "<%=AD_NO%>";

    data_header[2] = new Array;
    data_header[2][0] = "<%=prop.getProperty("com.jkt.hms.registration_no") %>"
    data_header[2][1] = "data";
    data_header[2][2] = "14%";
    data_header[2][3] = "<%=HIN_NO%>";

    data_header[3] = new Array;
    data_header[3][0] = "Patient Name"
    data_header[3][1] = "data";
    data_header[3][2] = "26%";
    data_header[3][3] = "<%=PATIENT_NAME%>";

   	data_header[4] = new Array;
    data_header[4][0] = "Ward"
    data_header[4][1] = "data";
    data_header[4][2] = "30%";
    data_header[4][3] = "<%=WARD_NAME%>";

    data_header[5] = new Array;
    data_header[5][0] = "billSettlementStatus"
    data_header[5][1] = "hide";
    data_header[5][2] = "30%";
    data_header[5][3] = "billSettlementStatus";
    data_arr = new Array();

    data_header[6] = new Array;
    data_header[6][0] = "dischargeFlagForPatientType"
    data_header[6][1] = "hide";
    data_header[6][2] = "30%";
    data_header[6][3] = "dischargeFlagForPatientType";

     data_arr = new Array();

    <%
    int counter = 0;
    if(dischargeList.size()>0)
	{
    		for (Iterator iterator = dischargeList.iterator(); iterator.hasNext();) {
    			Discharge dischargeObj  = (Discharge) iterator.next();
				Patient patient = (Patient)dischargeObj.getHin();
				String patientName="";
				patientName=patient.getPFirstName();
				if(patient.getPMiddleName()!=null){
					patientName=patientName+" "+patient.getPMiddleName();
				}
				if(patient.getPLastName()!=null){
					patientName=patientName+" "+patient.getPLastName();
				}

				try{
  	%>
		    	data_arr[<%= counter%>] = new Array();
				data_arr[<%= counter%>][0] = <%= dischargeObj.getId()%>
				data_arr[<%= counter%>][1] = '<input type="radio" id="parent" name="parent" value="<%= dischargeObj.getId()%>" id="parent"  />'
				data_arr[<%= counter%>][2] = "<%= dischargeObj.getAdNo() %>"
				data_arr[<%= counter%>][3] = "<%= patient.getHinNo() %>"
				data_arr[<%= counter%>][4] = "<%= patientName%>"
				<%if(dischargeObj.getWard() !=null){%>
				data_arr[<%= counter%>][5] = "<%= dischargeObj.getWard().getDepartmentName() %>"
				<%}else{%>
				data_arr[<%= counter%>][5] = ""
				<%}%>
    	<%
	String statusForFinalBill="";
    	Inpatient lastPatient=new Inpatient();
    	for(Inpatient inp:dischargeObj.getHin().getInpatients()){
    		if(inp.getAdNo().equalsIgnoreCase(dischargeObj.getAdNo())){
	    		lastPatient=inp;
    		}
    	}

	Set<BlFinalBillDetails> set22=(Set<BlFinalBillDetails>)lastPatient.getBlFinalBillDetails();
	for(BlFinalBillDetails blFinalDetails :set22){
		statusForFinalBill=blFinalDetails.getStatus();
	}
	int loopCounterModulas=counter%5;
	%>
	data_arr[<%=counter%>][6] = '<input type="hidden" id="finalBillDetail<%=loopCounterModulas%>"  name="finalBillDetail<%=loopCounterModulas%>" value="<%=statusForFinalBill%>"  />'

<%
if(patient.getPatientType()!=null){
%>
data_arr[<%=counter%>][7] = '<input type="hidden" id="dischargeStatus<%=loopCounterModulas%>"  name="dischargeStatus<%=loopCounterModulas%>" value="<%=patient.getPatientType().getDischargeWithoutSettlement()%>"  />'
<%
}else{
	%>
	data_arr[<%=counter%>][7] = '<input type="hidden" id="dischargeStatus<%=loopCounterModulas%>"  name="dischargeStatus<%=loopCounterModulas%>" value=""  />'
	<%
}
%>
  	<%}catch(Exception e){
  		e.printStackTrace();
  	}
  	counter++;

    		}
    	}
 %>
     formName = "finalDischarge"
	 start = 0
    if(data_arr.length < rowsPerPage)
     end = data_arr.length;
    else
     end = rowsPerPage;

    makeTable(start,end);

    intializeHover('searchresulttable', 'TR', ' tableover');
    </script>