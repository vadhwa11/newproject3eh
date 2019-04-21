<%@ page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.NursingcareSetup"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript">
var icdArray = new Array();

</script>


<script type="text/javascript">
function openPopupWindow()
{
 var url="/hms/hms/adt?method=showICDSearchJsp";
 newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
}

function jsSetIcdData(icd_no)
{
document.getElementById("icdCode").value=icd_no;
document.getElementById("icdCode").focus();
}
</script>

<style>
#contentspace label {
	text-align: right;
	width: 90px;
	float: left;
	height: 9px;
}
</style>
<%  String message ="";
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String currentTime = (String) utilMap.get("currentTime");
	Map map = new HashMap();
	String includedJsp = "";
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}

	List inPatientDetailList = new ArrayList();
	List<MasIcd> icdNoList = new ArrayList<MasIcd>();
	if (map.get("icdNoList") != null) {
		icdNoList = (List<MasIcd>) map.get("icdNoList");
	}
	if (inPatientDetailList != null) {
		inPatientDetailList = (List) map.get("inPatientDetailList");
	}

	String userName = "";
	String deptName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	String admissionNumber = null;
	int hinId = 0;
	int inpatientId = 0;
	String temp ="";
	if (inPatientDetailList != null) {
		String patientName = "";
		String consultantName = "";
		String serviceNo = null;
		Inpatient inPatientDetail = (Inpatient) inPatientDetailList
				.get(0);
		hinId = inPatientDetail.getHin().getId();
		inpatientId = inPatientDetail.getId();
		//  String patientName=inPatientDetail.getHin().getPFirstName()+inPatientDetail.getHin().getPMiddleName()+inPatientDetail.getHin().getPLastName();
		if (inPatientDetail.getHin().getPFirstName() != null) {
			patientName = inPatientDetail.getHin().getPFirstName();
		}
		if (inPatientDetail.getHin().getPMiddleName() != null) {
			patientName += inPatientDetail.getHin().getPMiddleName();
		}
		if (inPatientDetail.getHin().getPLastName() != null) {
			patientName += inPatientDetail.getHin().getPLastName();
		}
		if (inPatientDetail.getDoctor().getFirstName() != null) {
			consultantName = inPatientDetail.getDoctor().getFirstName();
		}
		if (inPatientDetail.getDoctor().getMiddleName() != null) {
			consultantName += inPatientDetail.getDoctor()
					.getMiddleName();
		}
		if (inPatientDetail.getDoctor().getLastName() != null) {
			consultantName += inPatientDetail.getDoctor().getLastName();
		}
		if (inPatientDetail.getHin().getServiceNo() != null
				&& inPatientDetail.getHin().getServiceNo() != "") {
			serviceNo = inPatientDetail.getHin().getServiceNo();
		}

		MasIcd masIcd = (MasIcd) inPatientDetail.getDiagnosis();
		admissionNumber = inPatientDetail.getAdNo();
		String unitName = "";
		String rankName = "";
		if (inPatientDetail.getHin().getUnit() != null) {
			unitName = inPatientDetail.getHin().getUnit().getUnitName();
		} else {
			unitName = "-";
		}
		if (inPatientDetail.getHin().getRank() != null) {

			rankName = inPatientDetail.getHin().getRank().getRankName();
		} else {
			rankName = "-";
		}
		System.out
				.println("Unit name in jsp========***********************"
						+ unitName
						+ "========Rank name in jsp==="
						+ rankName);
		session.setAttribute("admissionNumber", admissionNumber);
%>
<div id=contentspace>
<form name="patientDiagnosis" method="post" action="">
<div style="float: left;">
<h2 align="left" class="style1">Patient Diagnosis</h2>
</div>
<div style="float: left; padding-left: 500px;">
<h4 align="left" class="style1"><%=deptName%></h4>
</div>
<br />
<%
		if(map.get("message") != null){
		    message = (String)map.get("message");
		    }
	if(!message.equals("")){
		String adNo ="";
		String hinNo = "";
		if (map.get("andNo") != null) {
			adNo = (String) map.get("andNo");
		}
		if (map.get("hinNo") != null) {
			hinNo = (String) map.get("hinNo");
		}
    %> <font id="error"><%=message %></font> <input type="button"
	name="Print" value="Print" class="button"
	onClick="submitForm('patientDiagnosis','/hms/hms/discharge?method=showDischargeSummaryReport&admissionNumber=<%=adNo%>&hinNo=<%=hinNo%>');"
	accesskey="p" /> <%} %>

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Patient Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 98px; background-color: #f4f9fe;">


<div style="height: auto; width: auto;"><br />


<label class="bodytextB">Patient Name:</label> <span class="wardspan">
<%=patientName%></span> <label class="bodytextB">Service No:</label> <%
	    	if (serviceNo != null) {
	    %> <span class="wardspan"> <%=inPatientDetail.getHin().getServiceNo()%></span>
<%
	    	} else {
	    %> <span class="wardspan">-</span> <%
			}
		%> <label class="bodytextB" style="width: 110px;">IP No:</label> <%
	    	if (inPatientDetail.getAdNo() != null) {
	    %> <span class="wardspan"> <%=inPatientDetail.getAdNo()%></span> <%
			} else {
		%> <span class="wardspan">-</span> <%
			}
		%> <label class="bodytextB">Ward Name:</label> <%
	    	if (inPatientDetail.getDepartment() != null) {
	    %> <span class="wardspan"> <%=inPatientDetail.getDepartment()
									.getDepartmentName()%></span> <%
			} else {
		%> <span class="wardspan">-</span> <%
		 	}
		 %> <label class="bodytextB">Age:</label> <%
	    	if (inPatientDetail.getAge() != null) {
	    %> <span class="wardspan"> <%=inPatientDetail.getAge()%></span> <%
			} else {
		%> <span class="wardspan">-</span> <%
			}
		%> <label class="bodytextB">Sex:</label> <%
			if (inPatientDetail.getHin().getSex() != null) {
		%> <span class="wardspan"> <%=inPatientDetail.getHin().getSex()
									.getAdministrativeSexName()%></span> <%
			} else {
		%> <span class="wardspan">-</span> <%
			}
		%> <label class="bodytextB" style="width: 110px;">Rank:</label> <%
	     	if (rankName != null) {
	     %> <span class="wardspan"> <%=rankName%></span> <%
			} else {
		%> <span class="wardspan">-</span> <%
			}
		%> <label class="bodytextB">Unit:</label> <%
	    	if (unitName != null) {
	    %> <span class="wardspan"><%=unitName%></span> <%
			} else {
		%> <span class="wardspan">-</span> <%
			}
		%> <label class="bodytextB">Consultant:</label> <span class="wardspan"><%=consultantName%></span>



<label class="bodytextB">Diagnosis:</label> <%
			Set<DischargeIcdCode> set = (Set<DischargeIcdCode>) inPatientDetail.getDischargeIcdCodes();
				if (set.size() > 0) {
					int dilStatusId = 0;
					String diagnosisStatus = "";

					for (DischargeIcdCode dischargeIcdCode : set) {
						if (dischargeIcdCode.getInpatient().getId() == inPatientDetail.getId()) {
							if (dischargeIcdCode.getId() > dilStatusId) {
								if(dischargeIcdCode.getIcd() !=null){
								diagnosisStatus = ""+ dischargeIcdCode.getIcd().getIcdName();
								dilStatusId = dischargeIcdCode.getId();
								temp =""+ dischargeIcdCode.getIcd().getIcdName()+"["+dischargeIcdCode.getIcd().getIcdCode()+"]";
								}
							}
						}
					}
		%> <span class="wardspan"><%=diagnosisStatus%></span> <%
			} else if (inPatientDetail.getDiagnosis() != null) {
				temp =inPatientDetail.getDiagnosis().getIcdName()+"["+inPatientDetail.getDiagnosis().getIcdCode()+"]";
		%> <span class="wardspan"><%=inPatientDetail.getDiagnosis().getIcdName() %></span>
<%
			} else {
		%> <span class="wardspan">-</span> <%
			}
		%> <label class="bodytextB">Init Diagnosis:</label> <%if(inPatientDetail.getInitDiagnosis() !=null) %>
<span class="wardspan"><%=inPatientDetail.getInitDiagnosis()%></span> <br />
<%
			}
		%>
</div>
</div>
<br />
<div
	style="width: 15px; height: 20px; BORDER-bottom: #3c8ad7 1px solid; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Diagnosis:</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: auto; background-color: #f4f9fe;">



<div style="float: left; width: 15px; height: 20px; padding-top: 5px;"></div>
<div style="float: left;"><input type="checkbox" name="<%=Z03 %>"
	class="checkbox" value="z03"> <font class="bodytextB"
	style="width: 20px;">Z03</font> <input type="checkbox" name="<%=Z09 %>"
	class="checkbox" value="z09"> <font class="bodytextB"
	style="width: 20px;">Z09</font></div>
<div style="float: left;"><input type="button" class="delbutton"
	value=" " onclick="removeRowForUpdateDischarge(this,'tblSample');"
	align="right" /> <input type="button" class="addbutton" value=" "
	onclick="addRow();" align="right" /> <label class="smalllabel">Icd
Code :</label> <input name="" value="" class="textbox_date" style="width: 90"
	id="icdCode" onblur="getIcd();" /> <input name="" value=""
	class="textbox_date" style="width: 90" id="temp" type="hidden" /> <IMG
	SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26"
	style="cursor: pointer;" onClick="javascript:openPopupWindow();"
	title="Click here to Search ICD Codes"></div>

<br />

<div
	style="overflow: auto; width: 99%; height: 130px; padding-left: 9px;">
<table width="100%" colspan="7" id="tblSample" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<tbody>
		<tr>
			<td width="3%" class="rowheader"></td>
			<td width="19%" class="rowheader">S.No</td>
			<td width="6%" class="rowheader">Diagnosis</td>
			<td width="14%" class="rowheader">Provisional Diagnosis</td>
			<td width="14%" class="rowheader">Final Diagnosis</td>

		</tr>
		<tr>
			<td width="2%"><input type="hidden" class="checkbox"
				name="checkbox" id="checkbox" value="" /></td>
			<td width="1%"><label class="smalllabel"> 1:</label></td>

			<td width="10%"><input type="text" align="right" name="icd"
				id="icd" class="bigcaptionIcd2" value="<%=temp%>" />
			<div id="ac2update"
				style="height: 150px; overflow: scroll; display: none; border: 1px solid #000"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('icd','ac2update','ipd?method=getICDList',{parameters:'requiredField=icd'});
			</script></td>

			<td width="1%"><input type="radio" align="right" name="parent"
				value="p" checked="true" id="parent" /></td>
			<td width="1%"><input type="radio" align="right" name="parent"
				value="f" id="parent1" /></td>

		</tr>
	</tbody>
</table>
</div>
</div>

<br />
<br />
<br />
<br />
<div
	style="width: 15px; height: 20px; BORDER-bottom: #3c8ad7 1px solid; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Previous Diagnosis:</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />
<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: auto; background-color: #f4f9fe;">



<div style="float: left; width: 15px; height: 20px; padding-top: 5px;"></div>

<br />

<div
	style="overflow: auto; width: 99%; height: 130px; padding-left: 9px;">
<table width="100%" border="1" cellpadding="0" cellspacing="0"
	class="grid_header" id="indentDetails" colspan="7">
	<tbody>
		<tr>
			<td width="1%" class="rowheader">SR No.</td>
			<td width="3%" class="rowheader">Date</td>
			<td width="3%" class="rowheader">Time</td>
			<td width="20%" class="rowheader">Diagnosis</td>
			<td width="2%" class="rowheader">Provisional Diagnosis</td>
			<td width="5%" class="rowheader">Final Diagnosis</td>

		</tr>

		<%
					int i = 1;
					if (map.get("disList") != null) {
						List disList = (List) map.get("disList");
						Iterator itr = disList.iterator();
						String nomenclature ="";
						String diagnosisStatus ="";
						while (itr.hasNext()) {
							DischargeIcdCode dischargeIcdCode = (DischargeIcdCode) itr.next();
							if(dischargeIcdCode.getIcd() !=null){
								 nomenclature = dischargeIcdCode.getIcd().getIcdName();
								 diagnosisStatus = dischargeIcdCode.getDiagnosisStatus();
							}
				%>


		<tr>


			<td width="1%"><input type="text" class="bodytextB_blue"
				style="width: 25px;" value="<%=i%>" /></td>
			<td width="1%"><font class="bodytextB_blue"> <%=dischargeIcdCode.getAddEditDate()%></font></td>
			<td width="1%"><font class="bodytextB_blue"> <%=dischargeIcdCode.getAddEditTime()%></font></td>
			<td width="6%"><!--  <input type="text" align="rclass="bodytextB_blue"ht" value="<%=nomenclature %>" name="icd" id="icd" class="bigcaption"    /> -->
			<label><%=nomenclature%></label></td>
			<%
		    	if (diagnosisStatus.equals("p")) {
		    %>
			<td width="2%"><label>Provisional</label></td>
			<%
		    	} else {
		    %>
			<td width="5%"><label>-</label></td>
			<%
		    	}
		    			if (diagnosisStatus.equals("f")) {
		    %>

			<td width="5%"><label>Final</label></td>
			<%
 		    	} else {
 		    %>
			<td width="5%"><label>-</label></td>
			<%
		    	}
		    %>
		</tr>
		<%
		   	i++;
		   		}

		   	}
		   %>

	</tbody>
</table>
</div>
</div>
<br />
<input type="hidden" name="hdb" value="1" id="hdb" /> <input
	type="hidden" name="inpatientId" value="<%=inpatientId %>"
	id="inpatientId" /> <input type="hidden" name="hinId"
	value="<%=hinId %>" id="hinId" /> <input type="hidden" name="date"
	value="<%=currentDate %>"> <input type="hidden" name="time"
	value="<%=currentTime%>"> <input type="hidden" name="deptName"
	value="<%=deptName%>"> <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
<input type="button" name="Submit" value="Submit" align="right"
	class="button"
	onClick="if(checkICD()){submitForm('patientDiagnosis','/hms/hms/ipd?method=addPatientDiagnosisInformation');}" />
<input type="button" class="button" value="Discharge Summery "
	align="right"
	onClick="submitForm('patientDiagnosis','/hms/hms/discharge?method=showDischargeInputJsp&parent=<%=inpatientId%>');" />
<input type="button" class="button" value="Back" align="right"
	onClick="submitForm('patientDiagnosis','ipd?method=showPatientListJsp');" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


</div>
<script type="text/javascript">
 
	 function addRow(){
	var icdString =document.getElementById("temp").value;
	
	if(icdString !="NO"){
	if(document.getElementById("icd").value==""){
		document.getElementById("icd").value =icdString
		document.getElementById("temp").value=""
		document.getElementById("icdCode").value =""
		return false;
	}
	}else{
		alert("ICD Code does not exists...!")
  		document.getElementById("icdCode").value =""
  		document.getElementById("temp").value =""
  		return true
	}
	if(icdString != "NO"){
	  var tbl = document.getElementById('tblSample');
	  var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  hdb.value=iteration
	  
	  var cellRight2 = row.insertCell(0);
  var e2 = document.createElement('input');
  e2.type = 'checkbox';
  cellRight2.appendChild(e2);
	 
	  var cellRight0 = row.insertCell(1);
	  var e0 = document.createElement('label');
	  e0.type = 'label';
	  e0.innerHTML = iteration+':'
	  e0.className = 'smalllabel'
	  cellRight0.appendChild(e0);
	  
	  var cellRightSel = row.insertCell(2);
	  var sel = document.createElement('input');
	  sel.name = 'icd' + iteration;
	  sel.id = 'icd' + iteration;
	  sel.type = 'text';
	   sel.value =icdString;
	  sel.className = 'bigcaptionIcd2'
	  cellRightSel.appendChild(sel);
	  new Ajax.Autocompleter('icd'+iteration,'ac2update','ipd?method=getICDList',{parameters:'requiredField=icd'+iteration});
	 
  
	  var cellRight2 = row.insertCell(3);
	  var e2 = document.createElement('input');
	  e2.name='parent'+iteration;
	  e2.id='parent'+iteration;
	  e2.type = 'radio';
	  e2.width='1%'
	  e2.checked='true';
	  e2.value='p';
	  cellRight2.appendChild(e2); 
	  
	  var cellRight3 = row.insertCell(4);
	  var e3 = document.createElement('input');
	  e3.name='parent'+iteration;
	  e3.id='parent1'+iteration;
	  e3.type = 'radio';
	  e3.width='1%'
	  e3.value='f';
	  cellRight3.appendChild(e3); 
	   document.getElementById("icdCode").value =""
  	   document.getElementById("temp").value =""
  }else{
  		alert("ICD Code does not exists...!")
  		document.getElementById("icdCode").value =""
  		document.getElementById("temp").value =""
  		return true
  }
	  
	}
	function removeRowForUpdateDischarge(argIndex,idName){
	
	         var table=document.getElementById(idName);
	         var tblRows  = table.getElementsByTagName("tr");
	         var check=0;
	         
	         for(i=tblRows.length-1;i>0;i--)
	        {         
	         var tblCtrl =  tblRows[i].getElementsByTagName("input"); 
	         
	         
	               for(j=0;j<tblCtrl.length;j++)
	               {
	                  if(tblCtrl[j].type == 'checkbox')
	                   {    
	                    if(tblCtrl [j].checked)
	                              check=check+1;
	                   }
	               }
	        }
			
	        for(i=tblRows.length-1;i>0;i--)
	        {         
	         var tblCtrl =  tblRows[i].getElementsByTagName("input"); 
	         
	               for(j=0;j<tblCtrl.length;j++)
	               {
	                  if(tblCtrl[j].type == 'checkbox')
	                   {    
	                    if(tblCtrl [j].checked)
	                              document.getElementById(idName).deleteRow(i);
	                   }
	               }
	        }
     }
	function removeRow()
	{
	  var tbl = document.getElementById('tblSample');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	}

	function checkICD()
	{
	 
	 var counter = document.getElementById('hdb').value;
	// alert("in function icd value of counter--"+counter)
	 var str="";
	 var inc="";
	 var temp="";
	 
	 for(var i=1;i<=counter;i++)
	  {
	  	
	      temp=i+1;
	   for(var j=temp;j<=counter;j++)
	   {
	     var k=j+"";
	   	 var icdIdInF=document.getElementById('icd'+str).value
	   	 var icdIdInS=document.getElementById('icd'+k).value
	   	 //alert("value of ICD in iii loop--- "+icdIdInF+"---and value of ICD id in jjj loop---"+icdIdInS)
	   	 
	   	  var diagnosis="";
		  if(document.getElementById('parent'+str).checked == true)
		  {
		   diagnosis=document.getElementById('parent'+str).value
		  }else{
		  	 diagnosis=document.getElementById('parent1'+str).value
		  }
	   	var currDiagnosis="";
		  if(document.getElementById('parent'+k).checked == true)
		  {
		  currDiagnosis=document.getElementById('parent'+k).value
		  }
		  else{
		  currDiagnosis=document.getElementById('parent1'+k).value
		  }
	   
	   if(icdIdInS ==icdIdInF && currDiagnosis==diagnosis )
			{
			 alert("PLease Either Change the ICD Code for Serial Number "+k +" OR Change the Status of Diagnosis. ")
			 return false;
			}
	   
	   }
	   if(i==1)
		  {
			str=(i+1)+"";
			temp=i+1;
		  }else{
			str=(i+1)+"";
			temp=i+1;
	      }
	    
	  }
	  return true;
	}

	function checkICDCodes()
	{
	  var counter = document.getElementById('hdb').value;
	  var str="";
	  alert("In ICD code method")
	  for(var i=0;i<counter-1;i++)
	  {
	  	 
		  var icdId=document.getElementById('icdId'+str).value
		  var diagnosis="";
		  if(document.getElementById('parent'+str).checked == true)
		  {
		   diagnosis=document.getElementById('parent'+str).value
		  }else{
		  	 diagnosis=document.getElementById('parent1'+str).value
		  }
		  
		   //var diagnosis=document.getElementById('parent1'+str).value
		  var currICD=document.getElementById('icdId'+counter).value
		  var currDiagnosis="";
		  if(document.getElementById('parent'+counter).checked == true)
		  {
		  currDiagnosis=document.getElementById('parent'+counter).value
		  }
		  else{
		  currDiagnosis=document.getElementById('parent1'+counter).value
		  }
		  
		  //alert("value of icd id---"+icdId+"---value of diagnosis-----"+diagnosis)
		  //alert("value of currICD-----"+currICD+"----value of current Diagnosis-----"+currDiagnosis)
		  if(i==0)
		  {
			str=(i+1+1)+"";
			
		  }else{
			str=(i+1+1)+"";
			
		 }
			if(currICD ==icdId && diagnosis==currDiagnosis )
			{
			 alert("PLease Either Change the ICD Code for Serial Number "+counter +" OR Change the Status of Diagnosis. ")
			 return false;
			}
	}
	  return true;
	}
function getIcd(){
 //=========To get Icd String with icd code==========================
var icdCode =document.getElementById("icdCode").value
 if(icdCode !="")
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
 
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
      
      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	         icdString  = item.getElementsByTagName("icdString")[0];
	         	
	        if(icdString.childNodes[0].nodeValue){
	        	icdString=icdString.childNodes[0].nodeValue
	        	document.getElementById("temp").value =icdString
	        }
	       }
      }
      }
    var url="/hms/hms/adt?method=getIcdWithIcdCode&icdCode="+encodeURIComponent(icdCode)
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  
  }
  //==================End of Icd String block======================
}
</script>




