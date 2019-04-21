<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
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
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript">
	<%
	List<MasUnit> unitList = new ArrayList<MasUnit>();
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
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
	List<MasDepartment>masDepartmentList=new ArrayList<MasDepartment>();
if(map.get("masDepartmentList")!=null){
	masDepartmentList=(List)map.get("masDepartmentList");
}
int deptId1=0;
if(map.get("deptId")!=null){
	deptId1=(Integer)map.get("deptId");
}
List<OtBooking>patientList=new ArrayList<OtBooking>();
if(map.get("patientDetailList")!=null){
	patientList=(List<OtBooking>)map.get("patientDetailList");
}
List<MasRelation>relationList=new ArrayList<MasRelation>();
if(map.get("relationList")!=null){
	relationList=(List<MasRelation>)map.get("relationList");
}
List<MasBloodGroup>bloodGroupList=new ArrayList<MasBloodGroup>();
if(map.get("bloodGroupList")!=null){
	bloodGroupList=(List<MasBloodGroup>)map.get("bloodGroupList");
}

String hin_no="";
String inpatient_no="";
String name="";
String age="";
String sex="";
int inpatientId=0;
int bookingId=0;
OtBooking otBooking=null;
for(OtBooking booking:patientList){
	otBooking=booking;
	bookingId=booking.getId();
	inpatientId=booking.getHin().getId();
	hin_no=booking.getHin().getHinNo();
	//inpatient_no=inp.getAdNo();
	name=booking.getHin().getPFirstName();
	age=booking.getHin().getAge();
	sex=booking.getHin().getSex()!=null?booking.getHin().getSex().getAdministrativeSexName():"";
}
	
%> 
	
	<%if(!message.equals("")){ %> <h4><span><%=message %></span></h4> <% }%>

<div class="clear"></div>
<div class="titlebg">
<h2>Pre Operative CheckList-Check in and Sign in</h2>
</div>
<div class="Block">
<h4>Patient Details</h4>

<input type="hidden" name="hinId" id="hinId" value="<%=inpatientId %>"/>
<label >Reg No.</label> 
<label class="value"><%=hin_no %></label>

<label >Name</label> 
<label class="value"><%=name %></label>


<label >Age</label> 
<label class="value"><%=age %></label><div class="clear"></div>
<label >Sex</label> 
<label class="value"><%=sex %></label>
<div class="clear"></div>
</div>
<div class="Block">
<h4>General</h4>
<input type="hidden" name="bookingId" value="<%=bookingId %>" />
<label>Temp</label>
<input type="text" name="temp" id="temp" value="" maxlength="3" onkeypress="return isNumberKey(event);"/>
<label>Pulse</label>
<input type="text" name="pulse" id="pulse" value="" maxlength="3" onkeypress="return isNumberKey(event);"/>
<label>Respiratory Rate</label>
<input type="text" name="resp" id="resp" value="" maxlength="3" onkeypress="return isNumberKey(event);"/>
<div class="clear"></div>
<label>Blood Pressure</label>
<input type="text" name="bp" id="bp" value="" maxlength="7" onblur="validateBpWithSlash1(this.value);"/>
<label>Weight</label>
<input type="text" name="wt" id="wt" value="" maxlength="3" onkeypress="return isNumberKey(event);"/>
<label>Height</label>
<input type="text" name="ht" id="ht" value="" maxlength="7" onkeypress="return isNumberKey(event);"/>
<div class="clear"></div>
<label class="auto">Procedural Consent Form Completed</label>
<select name="pcfc" id="pcfc" class="midium">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
<label class="auto">Intended Surgical Site Marked By Surgeon</label>
<select name="issm" id="issm" class="midium">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
<label class="auto">X-Ray /Medical Imaging /Pacs</label>
<textarea rows="5" cols="5" name="xraydtl" id="xraydtl" maxlength="500" class="textareaMediua"></textarea>
<div class="clear"></div>
</div>
<div class="Block">
<h4>Alerts</h4>
<label>Allergy Status Documented</label>
<input type="text" name="asd" id="asd" value="" maxlength="50"/>
<label>Infection Alerts</label>
<input type="text" name="ia" id="ia" value="" maxlength="50"/>
<label class="auto">Cytotoxic Medication administered in Last 7 Days</label>
<select name="cma" id="cma" class="midium">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
<div class="clear"></div>
<label>Pregnant</label>
<select name="pregnant" id="pregnant">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
<label>Diabetic Status</label>
<select name="diabetic" id="diabetic">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
<label>NIDDM</label>
<select name="NIDDM" id="NIDDM">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select><div class="clear"></div>
<label>IDDM</label>
<select name="IDDM" id="IDDM">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
<label>Other Chronical Illness</label>
<textarea rows="5" cols="5" name="oci" id="oci" maxlength="500" class="textareaMediua"></textarea>
<div class="clear"></div>
</div>
<div class="Block">
<h4>Fasted</h4>
<label>Last Food Intake</label>
<input type="text" name="lfi" id="lfi" maxlength="50"/>
<label>Last Fluid Intake</label>
<input type="text" name="fluid" id="fluid" maxlength="50"/><div class="clear"></div>
</div>
<div class="Block">
<h4>Medication</h4>
<label>Other Medicaltion Taken</label>
<input type="text" name="omt" id="omt" maxlength="50"/>
<label>Medication Withheld</label>
<input type="text" name="mw" id="mw" maxlength="50"/><div class="clear"></div>
</div>
<div class="Block">
<h4>Hematology</h4>
<label>Blood Group</label>
<!-- <input type="text" name="group" id="group" maxlength="5"/> -->
<select name="group" id="groupId">
<option value="0">Select</option>
<%for(MasBloodGroup group:bloodGroupList){ %>
<option value="<%=group.getBloodGroupName()%>"><%=group.getBloodGroupName() %></option>
<%} %>
</select>

<label>INR</label>
<input type="text" name="inr" id="inr" maxlength="50"/>
<label>Blood Cross Match</label>
<input type="text" name="bcm" id="bcm" maxlength="50"/>
<div class="clear"></div>
<label>Blood Product Refusal</label>
<select name="bpr" id="bpr" class="midium">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
<label class="auto">Existing Implant or prostheses</label>
<input type="text" name="eip" id="eip" value="" maxlength="50"/>
<label class="auto">Caps/Crowns/Loose Teeth or Denture documented</label>
<input type="text" name="dental" id="dental" value="" maxlength="5"/><div class="clear"></div>
</div>
<div class="Block">
<h4>Other Details</h4>
<label>Pre OP Shower</label>
<select name="pos" id="pos" maxlength="50">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
<label>Surgical Attire</label>
<select name="sa" id="sa">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>

<label>Operation Site Prepared</label>
<select name="opSitePrep" id="opSitePrep">
<option value="">Select</option>
<option value="C">Clip</option>
<option value="B">Bowel Prep & return</option>
</select><div class="clear"></div>
</div>
<div class="Block">
<h4>Personal Aids / Items documented</h4>
<label>Jewels</label>
<select name="jewelName" id="jewelId">
<option value="">Select</option>
<option value="R">Removed</option>
<option value="T">Tapped</option>
</select>
<label>Hair Pin Removed</label>
<select name="hairPin" id="hairPinId">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>


<label>Glasses</label>
<div class="clear"></div>
<label>Glasses</label>
<select name="glasses" id="glasses">
<option value="">Select</option>
<option value="R">Removed</option>
<option value="N">Not Remived</option>
</select>
<label>Hearing Aid</label>
<select name="hearing" id="hearing">
<option value="">Select</option>
<option value="R">Removed</option>
<option value="N">Not Remived</option>
</select>
<label>Passed Urine</label>
<!-- <input type="text"  value="" /> -->
<select name="passUrine" id="passUrine">
<option value="">Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
<option value="CT">Catheterized</option>
</select>
<div class="clear"></div>
<label>RYLES tube</label>
<select name="daaa" id="daaa" class="midium">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
<label class="auto">Risk of > 500 ml blood loss (7 ml/kg in children)</label>
<select name="risk" id="risk" class="midium">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
<label class="auto">Pre Operative CheckList Checked By</label>
<textarea cols="5" rows="5" name="checkedBy" name="checkedBy" class="textareaMediua"></textarea><div class="clear">
<!-- <label>Removed or Taped - jewelers,hair pins,make up,nail Police</label>
<select name="removal" id="removal">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
 -->
</div>
</div>

<div class="clear"></div>
<input type="button"
name="add" id="addbutton" value="Submit" class="button" onclick="submitForm('wardRemarks','ot?method=submitPreOTCheckList');" 
		accesskey="a" tabindex=1 />

<input name="pacClearanceBtn" id="pacClearanceBtn" type="button" class="button"	value="PAC Clearance" onclick="showPacClearance()" />
<input type="button" value="Patient History" class="buttonBig" onclick="showPatientHistoryDetails();" />
<input type="button" value="Pre-Anesthesia History"  class="buttonBig" onclick="showPreAnesthesiaHistory();" />
				
<div class="clear"></div>

</form>
<script>
function checkForLegal(){
var legalId=document.getElementById('checkpro').value;
if(legalId=='Yes'){
	document.getElementById("legal").style.display='block';
}else{
	document.getElementById("legal").style.display='none';
}
}
</script>	
<script language=Javascript>
      <!--
      function isNumberKey(evt)
      {
         var charCode = (evt.which) ? evt.which : event.keyCode
         if (charCode > 31 && (charCode < 46 || charCode > 57)){
        	 if(!displayAlert("Please Enter Numbers Only!!"))
            	 alert("Please Enter Numbers Only!!");
            return false;
         }else{
         return true;
         }
        
      }
      //-->
   </script>
   <script>
   function validateBpWithSlash1(strValue){
		if(strValue != ""){
		var objRegExp = /^(\d{1,}[\/]\d*)$/
		obj =  objRegExp.test(strValue);
		if(!obj){
			if(!displayAlert("Slash(/) should be there."))
				alert("Slash(/) should be there.");
			getShadow("bp");
		}
		var n=strValue.length;
		var n1 = strValue.charAt(n-1);
		 if(n1=='/'){
			 if(!displayAlert("Should be in Correct Format"))
				 alert("Should be in Correct Format");
			 getShadow("bp");
			return false;
			 }
	}
	}
   
   function showPacClearance(){
		var  url="/hms/hms/ot?method=getPacHistory&orderId=<%=otBooking.getOrderNo()%>";
		 window.open(url,
				"pac Clearance History",
				"toolbar=yes, scrollbars=yes, resizable=yes, top=90, left=100, width=1200, height=560");
	}
  
  function showPatientHistoryDetails(){
	    var url='/hms/hms/enquiry?method=showPatientDetails&hinNo=<%=otBooking.getHin().getHinNo()%>';
	    newwindow=window.open(url,'opd_window',"left=100,top=100,height=700,width=1024,status=1,scrollbars=yes,resizable=0");
	    
	 }
  
  function showPreAnesthesiaHistory(){
	   var  url="/hms/hms/ot?method=getPreAnesthesiaHistory&bookingId=<%=otBooking.getId()%>";
		 window.open(url,
				"Pre Anesthesia History",
				"toolbar=yes, scrollbars=yes, resizable=yes, top=90, left=100, width=1200, height=560");
  }
   </script>