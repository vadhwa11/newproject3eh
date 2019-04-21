<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientAdmissionSearch.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
--%>
<%@page import="java.io.File"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="jkt.hms.masters.business.MasBed"%>
<%@page import="jkt.hms.masters.business.Transfer"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>




<form name="wardtransferAccept" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();

List<Transfer> transferList = new ArrayList<Transfer>();
List<MasBed> beds = new ArrayList<MasBed>();
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("transferList") != null){
	transferList= (List<Transfer>)map.get("transferList");
}

if(map.get("beds") != null){
	beds= (List<MasBed>)map.get("beds");
}

		
	
	%> 
	<% Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap= (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	
	String masdeptTypeMortury = "";
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File(resourcePath.getFile())));
		masdeptTypeMortury = prop
				.getProperty("masdeptTypeMortury");
	} catch (IOException e) {
		e.printStackTrace();
	}

	%>
	
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
<div class="titleBg">
<h2>Bed allocation</h2>
</div>
<div class="clear"></div>
	<%
		if(map.get("message") != null){
		   String message = (String)map.get("message");

      %>
    <h4 style="color: red;"><%=message %></h4>
		<% }
		%>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="Block">
<div class="clear"></div>
<div class="paddingTop15"></div>
<jsp:include page="searchResultBlock.jsp"  />
<div class="clear"></div>
<form name="wardtransferaccept" method="post" action="">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<script
	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"],[1, "select"],[2,"transfertype"], [3,"transferdate"], [4,"transfertime"], [5,"uhid"],[6,"pname"],[7,"ipdno"],[8,"fward"]
			[9,"fbed"],[10,"tward"],[11,"reason"],[12,"status"]];
	 statusTd = 12;
	</script>
</div>
<script type="text/javascript" language="javascript">
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = ""
	data_header[0][1] = "data";
	data_header[0][2] = "15%";
	data_header[0][3] = "select";
	
	data_header[1] = new Array;
	data_header[1][0] = "Transfer Type"
	data_header[1][1] = "data";
	data_header[1][2] = "30%";
	data_header[1][3] = "transfertype";
	
	data_header[2] = new Array;
	data_header[2][0] = "Transfer Date"
	data_header[2][1] = "data";
	data_header[2][2] = "30%";
	data_header[2][3] = "transferdate";
	
	
	data_header[3] = new Array;
	data_header[3][0] = "Transfer Time"
	data_header[3][1] = "data";
	data_header[3][2] = "30%";
	data_header[3][3] = "transfertime";
	
	data_header[4] = new Array;
	data_header[4][0] = "<%=prop.getProperty("com.jkt.hms.uhid") %>"
	data_header[4][1] = "data";
	data_header[4][2] = "15%";
	data_header[4][3] = "uhid";
	
	data_header[5] = new Array;
	data_header[5][0] = "Patient Name"
	data_header[5][1] = "data";
	data_header[5][2] = "20%";
	data_header[5][3] = "patName";
	
	data_header[6] = new Array;
	data_header[6][0] = "IP No."
	data_header[6][1] = "data";
	data_header[6][2] = "20%";
	data_header[6][3] = "ipdno";
	
	
	data_header[7] = new Array;
	data_header[7][0] = "From ward"
	data_header[7][1] = "data";
	data_header[7][2] = "20%";
	data_header[7][3] = "fward";
	
	data_header[8] = new Array;
	data_header[8][0] = "From Bed"
	data_header[8][1] = "data";
	data_header[8][2] = "20%";
	data_header[8][3] = "fbed";
	
	data_header[9] = new Array;
	data_header[9][0] = "To ward"
	data_header[9][1] = "data";
	data_header[9][2] = "20%";
	data_header[9][3] = "tward";
	
	
	data_header[10] = new Array;
	data_header[10][0] = "Reason"
	data_header[10][1] = "data";
	data_header[10][2] = "20%";
	data_header[10][3] = "reason";
	
	data_header[11] = new Array;
	data_header[11][0] = "Status"
	data_header[11][1] = "data";
	data_header[11][2] = "20%";
	data_header[11][3] = "status";
	data_arr = new Array();
	<%
	if(transferList.size()>0)
	{
		int j=0;
		%>
		
		<%
		for(Transfer transfer:transferList)
		{
		String transferPatientname=transfer.getHin().getPFirstName();
		if(transfer.getHin().getPMiddleName()!=null){
			transferPatientname += " "+transfer.getHin().getPMiddleName();
		}
		if(transfer.getHin().getPLastName()!=null){
			transferPatientname += " "+transfer.getHin().getPLastName();
	}
	%>
	
	    
		data_arr[<%=j%>] = new Array();
		data_arr[<%=j%>][0] = "<%=transfer.getHin().getId()%>"
		data_arr[<%=j%>][1] = '<input type="radio" value="<%=transfer.getId()%>" name="transferId" onclick="onPatientSelect(this.value);" id="transferId<%=j%>" validate="Bed,int,yes" />'
		data_arr[<%=j%>][2] = "<%=transfer.getTransferType()%>"
		data_arr[<%=j%>][3] = "<%=HMSUtil.convertDateToStringWithoutTime(transfer.getDateOfTransfer())%>"
		data_arr[<%=j%>][4] = "<%=transfer.getTimeOfTransfer()%>"			
		data_arr[<%=j%>][5] = '<%=transfer.getHin().getHinNo()%>'
		
		data_arr[<%=j%>][6] ="<%=transferPatientname%>"
		data_arr[<%=j%>][7] = "<%=transfer.getInpatient().getAdNo()%>"
		data_arr[<%=j%>][8] = "<%=transfer.getFromWard().getDepartmentName()%>"
		data_arr[<%=j%>][9] = "<%=transfer.getFromBed().getBedNo()%>"
		data_arr[<%=j%>][10] = "<%=transfer.getToWard().getDepartmentName()%> "
		data_arr[<%=j%>][11] = " "
		<%if(transfer.getRequestStatus().equalsIgnoreCase("p"))
		{
		%>
		data_arr[<%=j%>][12] = "Pending"
		<%} else if(transfer.getRequestStatus().equalsIgnoreCase("r"))
		{
		%>
		data_arr[<%=j%>][9] = "Rejected"
		<%}%>
		<%
		j++;
		}
		
	}
	%>
	
	    
	
    formName = "wardtransferaccept"
	
	start = 0;
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
	
		
	</script>
	<%
	if(transferList.size()>0)
	{		%>
	<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>

<div class="clear"></div>
<div id="bedList" style="display: none;">
<h4>Bed Details</h4>
<div class="clear"></div>

<div class="clear"></div>
<%if(beds.size()>0)
{
	%>
<table id="investigationGrid" class="cmntable">
	<tr>		

<th scope="col">Available Bed No.</th>
<th scope="col">Department</th>
<th scope="col">Select Bed</th>
	</tr>
	<%
	int i=0;
	for(MasBed bed:beds)
	{
		/* if(i<=3)
		{ */
	%>
	<tr>
	<td><%=bed.getBedNo() %></td>
	<td><%=bed.getDepartment().getDepartmentName() %></td>
	<td><input type="radio" name="bedId" value="<%=bed.getId()%>"  validate="Bed,int,yes"  /> </td>
	</tr>
	<%
	/* } */
		i++;
	}
	%>
</table>
<%}
else
{
	%>
	<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>

<div class="clear"></div>
<h4>No Beds Available</h4>
<div class="clear"></div>
	<%
}
%>


</div>


<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<label>Remarks</label>
<textarea rows="" cols="" class="medium" name="remarks" id="remarks" maxlength="200" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)" ></textarea>

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<input type="button" name="Accept" value="Accept" class="button" onclick="submitAcceptTransfer();" />
<input type="button" name="Reject" value="Reject" class="button" onclick="submitrejectTransfer();" />
<input type="reset" class="button" name="reset" value="Reset" onclick="submitFormForButton('wardtransferaccept','ipd?method=showWardTransferAccepJsp');"/>
<input type="reset" class="button" name="reset" value="Back" onclick="submitFormForButton('wardtransferaccept','ipd?method=showPatientListJsp');"/>
<div class="clear"></div>
<%} %>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>

</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>

<div class="paddingTop15"></div>

<div class="paddingTop15"></div>

<script type="text/javascript">


function onPatientSelect(val)
{
	<%
	if(transferList.size()>0)
	{
		int j=0;
		for(Transfer transfer:transferList)
		{
		
	%>
	if('<%=transfer.getId()%>'==val)
		{
	if('<%=transfer.getTransferType()%>'=='bed')
		{
		document.getElementById('bedList').style.display='none';
		
		}
	else if('<%=transfer.getTransferType()%>'=='ward' && '<%=transfer.getToWard().getDepartmentType().getDepartmentTypeCode()%>'=='<%=masdeptTypeMortury%>')
		{
		document.getElementById('bedList').style.display='none';
		}
	else
		{
		document.getElementById('bedList').style.display='inline-block';
		}
	return;
		}
		<%
		j++;
		}
		
	}
	%>
	
}

function submitAcceptTransfer()
{
	var patientSelected=false;
	var bedSelected=false;
	var bedrequired=false;
	var transferId=0;
	var patients=document.getElementsByName('transferId');
	for(var j=0;j<patients.length;j++)
		{
		if(patients[j].checked)
		{
			patientSelected=true;
			transferId=patients[j].value;
			break;
		}
		}
	if(!patientSelected)
		{
		alert('Please select Patient.');
		return;
		}
	
	<%
	if(transferList.size()>0)
	{
		for(Transfer transfer:transferList)
		{
		
	%>
	if('<%=transfer.getId()%>'==transferId)
		{
	if('<%=transfer.getTransferType()%>'=='bed')
		{
		bedrequired=false;
		}
	else if('<%=transfer.getTransferType()%>'=='ward' && '<%=transfer.getToWard().getDepartmentType().getDepartmentTypeCode()%>'=='<%=masdeptTypeMortury%>')
	{
		bedrequired=false;
	}
	else
		{
		bedrequired=true;
		}
		}
		<%
		}
		
	}
	%>
	if(bedrequired)
		{
	var beds=document.getElementsByName('bedId');
	for(var j=0;j<beds.length;j++)
		{
		if(beds[j].checked)
			{
				bedSelected=true;
				break;
			}
		}
		}
	if(bedrequired && !bedSelected)
		{
		alert("Please select Bed for patient");
		return;
		}
	
	 document.getElementById("remarks").setAttribute("validate", "Remarks,remarks,no");
	
	submitForm('wardtransferaccept','/hms/hms/ipd?method=submitWardTransferAccepJsp&Accept=1');
	
	
	
}
	
function submitrejectTransfer()
{
	var patientSelected=false;
	var bedSelected=false;
	var bedrequired=false;
	var transferId=0;
	var patients=document.getElementsByName('transferId');
	for(var j=0;j<patients.length;j++)
		{
		if(patients[j].checked)
		{
			patientSelected=true;
			transferId=patients[j].value;
			break;
		}
		}
	if(!patientSelected)
		{
		alert('Please select Patient.');
		return;
		}
	
	 document.getElementById("remarks").setAttribute("validate", "Remarks,remarks,no");
	
	submitForm('wardtransferaccept','/hms/hms/ipd?method=submitWardTransferAccepJsp&Accept=2');
	
}
</script>
 