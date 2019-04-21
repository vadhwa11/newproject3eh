<%@page import="jkt.hms.masters.business.OtBookSurgeon"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryHeader"%>
<%@page import="jkt.hms.masters.business.OtBooking"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript" language="javascript">
	<%
	List<MasUnit> unitList = new ArrayList<MasUnit>();
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(Calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(date.length()<2){
	date="0"+date;
	}
	%>
	serverdate = '<%=date+"/"+month+"/"+year%>'
		</script>

<form name="wardRemarks" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	String message ="";
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	if(map.get("message") !=null){
	message =""+map.get("message");
	}
List<OtBooking>patientList=new ArrayList<OtBooking>();
if(map.get("patientDetailList")!=null){
	patientList=(List<OtBooking>)map.get("patientDetailList");
}
String userName = "";
if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
}
String hin_no="";
String inpatient_no="";
String name="";
String age="";
String sex="";
int inpatientId=0;
int bookingId=0;
String preOpStatus = "";
String intraOpStatus = "";
String surgSaftyStatus = "";
String otName="";
String doneBy="";
String refferedDoctor="";
String ipNo="";
String wardName="";
if(map.get("RefferedDoctor")!=null && map.get("RefferedDoctor")!=""){
	refferedDoctor=(String)map.get("RefferedDoctor");
}
for(OtBooking otBooking:patientList){
	bookingId=otBooking.getId();
	inpatientId=otBooking.getHin().getId();
	hin_no=otBooking.getHin().getHinNo();
	//inpatient_no=inp.getAdNo();
	name=otBooking.getHin().getPFirstName();
	age=otBooking.getHin().getAge();
	sex=otBooking.getHin().getSex()!=null?otBooking.getHin().getSex().getAdministrativeSexName():"";
	preOpStatus = otBooking.getPreOperativeStatus()!=null?otBooking.getPreOperativeStatus():"";
	intraOpStatus = otBooking.getIntraOperativeStatus()!=null?otBooking.getIntraOperativeStatus():"";
	surgSaftyStatus = otBooking.getSurgicalSafetyStatus()!=null?otBooking.getSurgicalSafetyStatus():"";
	otName=otBooking.getChargeCode()!=null?otBooking.getChargeCode().getChargeCodeName():"";
	for(OtBookSurgeon surgeon:otBooking.getOtBookSurgeons()){
		doneBy+=surgeon.getEmployee().getEmployeeName()+",";
	}
	if(refferedDoctor==""){
		if(otBooking.getInpatient()!=null){
			refferedDoctor=otBooking.getInpatient().getDoctor().getEmployeeName();
		}
	}
	session.setAttribute("SurgeryRefDoc", refferedDoctor);
	
	if(otBooking.getInpatient()!=null){
		ipNo=otBooking.getInpatient().getAdNo();
		wardName=otBooking.getInpatient().getAdWard().getDepartmentName();
	}
}
	
%> 
	<%if(!message.equals("")){ %> <h4><span><%=message %></span></h4> <% }%>

<div class="clear"></div>
<div class="titlebg">
<h2>Sign Out-Before patient leaves the operating room</h2>
</div>
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<label>Reg No.</label>
<label class="value"><%=hin_no %></label>
<label>Patient Name</label>
<label class="value"><%=name %></label>
<input type="hidden" name="hinId" id="hinId" value="<%=inpatientId %>"  />

<label>Age</label>
<label class="value"><%=age %></label><div class="clear"></div>
<label>Sex</label>
<label class="value"><%=sex %></label>
<label>Ip No</label>
<label class="value"><%=ipNo%></label>
<label>Ward Name</label>
<label class="value"><%=wardName%></label>
<div class="clear"></div>
</div><br />
<div class="Block">
<input type="hidden" name="bookingId" value="<%=bookingId %>" />
<input type="hidden" name="ipNo" id="ipNo" value="<%=ipNo %>" />
<input type="hidden" name="wardName" id="wardName" value="<%=wardName %>" />
<label class="auto">Name of the operative procedure</label>
<input type="text" name="name_of_operative_proc" id="name_of_operative_proc" value="<%=otName %>" maxlength="50" tabindex="1"/>

<label>Ref Doctor</label>
<label class="value"><%=refferedDoctor%> </label>

<label>Done By</label>
<label class="value" style="width:200px"><%=doneBy.substring(0,doneBy.length()-1) %> </label>
<div class="clear"></div>
</div><br />
<div class="clear"></div>

<h4>Completion of sponge,sharp and instrument counts</h4><div class="clear"></div>
<div class="Block">
<input type="button" name="add" class="button" value="add" onclick="addRowForSurgery();"/>
<input type="button" name="delete" class="button" value="delete" onclick="removeRow();"/><div class="clear"></div>
<table id="investigationGrid" class="cmntable">
<tr>
<th>NAME</th>
<th>QTY USED</th></tr><tr>
<td><%int inc1=1; %>		<input type="hidden" value="<%=inc1%>" name="hiddenValue" id="hiddenValue" />

<input type="text" name="itemName<%=inc1%>" id="itemName1"	size=43	value=""/>
		<div id="ac2update2" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('itemName1','ac2update2','ot?method=getStoreConsumableItemForAutoComplete',{parameters:'requiredField=itemName1'});
	</script></td>
<td><input type="text" name="qty<%=inc1%>" id="qty1" size="10" maxlength="5"/></td>

</tr>
</table><div class="clear"></div></div>
<div class="clear paddingTop15"></div>
<div class="Block">
<label class="auto">Specimen identified and labeled </label>
<input type="text" name="spec_identified_and_labeled" id="spec_identified_and_labeled" value=""  maxlength="50" tabindex="1"/>

<label class="auto">Any equipment problems to be addressed </label>
<input type="text" name="any_equip_prob_address" id="any_equip_prob_address" value=""  maxlength="50" tabindex="1"/>

<label class="auto">What are the key concern for recovery and management of this patient </label>
<input type="text" name="key_concern_for_recovery" id="key_concern_for_recovery" value=""  maxlength="50" tabindex="1"/>
<div class="clear"></div>
</div>
<div class="clear paddingTop10"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="submit11" class="button" value="Submit" onclick="if(checkItem()){checkStatus()}"/>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="bottom">

<div class="clear"></div>
<label>Changed By</label> <label class="value"><%=userName %></label> <label>Changed
Date</label> <label class="value"><%=currentDate %></label> <label>Changed
Time</label> <label class="value"><%=currentTime %></label></div>
<script>
function addRowForSurgery(){
	
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	 
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=iteration
	  var cellRight1 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.name = 'itemName' + iteration;
	  e0.id = 'itemName' + iteration;
	  e0.size = '43'
	  cellRight1.appendChild(e0);
	    var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update2');
   	newdiv.style.display = 'none';
   	newdiv.className = "autocomplete";
    cellRight1.appendChild(newdiv);
    
	   new Ajax.Autocompleter('itemName'+iteration,'ac2update2','ot?method=getStoreConsumableItemForAutoComplete',{parameters:'requiredField=itemName'+iteration});
	  
	  var cellRightSel = row.insertCell(1);
	  cellRightSel.id='tdDose'+iteration;
	  
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='qty'+iteration;
	  sel.id='qty'+iteration
	  sel.size = '10'
	  sel.maxlength = '5'
	  cellRightSel.appendChild(sel);
	 
	}
function removeRow()
	{
		var tbl = document.getElementById('investigationGrid');
		var hdb = document.getElementById('hiddenValue');

		var lastRow = tbl.rows.length;
		if (lastRow > 2)
		{ 
			tbl.deleteRow(lastRow - 1);
			hdb.value=lastRow - 2;
		}
		else
			if(!displayAlert("Cannot delete all rows!!"))
				alert("Cannot delete all rows!!");
	}
function checkStatus(){
	var preOpStatus = "<%=preOpStatus%>";
	var intraOpStatus = "<%=intraOpStatus%>";
	var surgSaftyStatus = "<%=surgSaftyStatus%>";
	
	if(preOpStatus!='y' || intraOpStatus !='y' || surgSaftyStatus!='y'){
	if(confirm("Pre operative, Surgical and Surgical Safety check list has not been submitted yet. \n  Are you Sure, you want to submit the details ?"))
		submitForm('wardRemarks','ot?method=submitOtSignOutEntryJsp');
		return true;
	}else{
		submitForm('wardRemarks','ot?method=submitOtSignOutEntryJsp');
		return false;
	}
	
}
function checkItem()
{
	
	
	
	var flag = false;

		var errMsg = "";
		var numRows = document.getElementById('hiddenValue').value;
		for(var i=1; i<=numRows; i++)
		{
			if(document.getElementById("itemName"+i).value==null || document.getElementById("itemName"+i).value=="")
			{
				//getShadow("itemName"+i);
				errMsg += "Name cannot be blank at row "+i+" ";
			}
		}
		if(errMsg != "")
		{
			alert(errMsg);
		}
		else
		{
			flag = true;
		}
	return flag;
}
</script>
</form>
