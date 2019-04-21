<%@page import="jkt.hms.masters.business.OtBookSurgeon"%>
<%@page import="jkt.hms.masters.business.OtBooking"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

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
List<MasEmployee>surgeonList=new ArrayList<MasEmployee>();
if(map.get("surgeonList")!=null){
	surgeonList=(List<MasEmployee>)map.get("surgeonList");
}


List<MasEmployee>nurseList=new ArrayList<MasEmployee>();
if(map.get("nurseList")!=null){
	nurseList=(List<MasEmployee>)map.get("nurseList");
}


List<MasEmployee>assisstantList=new ArrayList<MasEmployee>();
if(map.get("assisstantList")!=null){
	assisstantList=(List<MasEmployee>)map.get("assisstantList");
}


List<MasEmployee>anestheticList=new ArrayList<MasEmployee>();
if(map.get("anestheticList")!=null){
	anestheticList=(List<MasEmployee>)map.get("anestheticList");
}


String hin_no="";
String inpatient_no="";
String name="";
String age="";
String sex="";
int hinId=0;
int bookingId=0;
for(OtBooking otBooking:patientList){
	bookingId=otBooking.getId();
	hinId=otBooking.getHin().getId();
	hin_no=otBooking.getHin().getHinNo();
	//inpatient_no=inp.getAdNo();
	name=otBooking.getHin().getPFirstName();
	age=otBooking.getHin().getAge();
	sex=otBooking.getHin().getSex()!=null?otBooking.getHin().getSex().getAdministrativeSexName():"";
}
List<OtBookSurgeon> surgeons=new ArrayList<OtBookSurgeon>();
int inc=0;
if(map.get("surgeons")!=null){
	surgeons=(List<OtBookSurgeon>)map.get("surgeons");
}
	
%> 
	<%if(!message.equals("")){ %> <h4><span><%=message %></span></h4> <% }%>

<div class="clear"></div>
<div class="titlebg">
<h2>Surgical Check List</h2>
</div>
<div class="clear paddingTop10"></div>
<div class="Block">
<input type="hidden" name="bookingId" value="<%=bookingId %>" />
<label class="auto" style="padding:0px 12px 0px 5px;">Confirm all team members have introduced themselves by name and role.</label>

<select name="confirmAll" id="confirmAll" onchange="checkConfirm(this.value);">
<option value=" ">Select</option>
<option value="Y" selected="selected">Yes</option>
<option value="N">No</option>
</select>
<div id="confirmId" style="display: inline;">
<div class="clear"></div>
<%-- <label>Surgeon</label>
<select name="surgeonId" id="surgeonId">
<option value=" ">Select</option>
<%for(MasEmployee emp:surgeonList){ %>
<option value="<%=emp.getId() %>"><%=emp.getEmployeeName() %></option>

<%} %>
</select>
<label>Anesthetist</label>
<select name="anestheticId" id="anestheticId">
<option value=" ">Select</option>
<%for(MasEmployee emp:anestheticList){ %>
<option value="<%=emp.getId() %>"><%=emp.getEmployeeName() %></option>

<%} %>
</select>
<label>OT Nurse</label>
<select name="nurseId" id="nurseId">
<option value=" ">Select</option>
<%for(MasEmployee emp:nurseList){ %>
<option value="<%=emp.getId() %>"><%=emp.getEmployeeName()%></option>

<%} %>
</select><div class="clear"></div>
<label>OT Assistant</label>
<select name="assisstantId" id="assisstantId">
<option value=" ">Select</option>
<%for(MasEmployee emp:assisstantList){ %>
<option value="<%=emp.getId() %>"><%=emp.getEmployeeName()%></option>

<%} %>
</select> --%>
<div class="clear"></div>
 <input type="button" class="button" alt="Delete" value="Delete"
				onclick="removeRow();" align="right" /> <input type="button"
				class="button" alt="Add" value="Add" onclick="addRowForSurgeon();"
				align="right" />
				
<table border="0" align="center" cellpadding="0" cellspacing="0" id="surgeonGrid">
				
	           <tr>
					<th scope="col"></th>
					<th scope="col">Resource Name</th>
					<th scope="col">Designation</th>
					<th scope="col">Role</th>
				</tr>
				<%if(surgeons.size()>0){ for(OtBookSurgeon surgeon:surgeons){inc++;%>
				<tr>
				<td><input type="checkbox" class="radioCheck" id="itemRadio<%=inc-1 %>" name="itemRadio<%=inc-1 %>"  /></td>
				
				<td>
						 
						<input type="text" value="<%=surgeon.getEmployee().getEmployeeName()+"["+surgeon.getEmployee().getId()+"]"%>" id="surgeonName<%=inc%>" size="43" name="surgeonName<%=inc%>"
						onblur="fillMemberDetails(this.value,<%=inc%>)" />
						
						<div id="ac2update2" style="display: none;" class="autocomplete"></div>
						<script type="text/javascript" language="javascript"
							charset="utf-8">
				  new Ajax.Autocompleter('surgeonName<%=inc%>','ac2update2','ot?method=getSurgeonListForAutoComplete',{parameters:'requiredField=surgeonName<%=inc%>'});
				</script>
			 
					</td>
					<td>
					<input type="text" size="43" name="designation<%=inc%>"
						id="designation<%=inc%>" value="<%=surgeon.getEmployee().getRank().getRankName()%>"></input>
					</td>
						
						<td><select name="role<%=inc%>" id="role<%=inc%>">
						<option value="">Select</option>
						<%String[] rolesList={"Surgeon","First Assistance","Second Assistance","Third Assistance","Fourth Assistance",
								"Floor Nurse","Main Nurse","Count Nurse","Anesthetist one","Anesthetist two","Anesthetist three"}; 
						for(String role:rolesList){
							if(role.equalsIgnoreCase(surgeon.getRole())){
						%>
						<option value="<%=role%>" selected="selected"><%=role%></option>
						<%}else{ %>
						<option value="<%=role%>" ><%=role%></option>
						<%}} %>
						</select>
						</td>
				
				
				</tr>
				
				<%}} %>
							
				
</table>
<input type="hidden" value="<%=inc%>" name="hiddenValue" id="hiddenValue" />

<div class="clear"></div>
</div>
<div class="clear"></div>
</div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">

<label>Registration No.</label>
<label class="value"><%=hin_no %></label>

<label>Patient Name</label>
<label class="value"><%=name %></label>
<input type="hidden" name="hinId" id="hinId" value="<%=hinId %>"  />

<label>Age</label>
<label class="value"><%=age %></label>
<div class="clear"></div>
<label>Sex</label>
<label class="value"><%=sex %></label>
<div class="clear"></div>

</div>
<div class="clear"></div>

<h4>Confirmation of </h4>

<div class="Block">

<label>Identity</label> 
<select name="identity" id="identity">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>

<label>Procedure</label> 
<select name="Procedure" id="Procedure">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>

<label >Procedure Site</label> 
<select name="proc_site" id="proc_site">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
 
<div class="clear"></div>
 
<label>Consent</label>  
<select name="consent_confrm" id="consent_confrm">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>

<!-- <label>Site marked by procedure performing person and is visible</label>
<select name="site_mark" id="site_mark">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
 -->
<label class="auto" style="padding:0px 12px 0px 5px;">Relevant images properly labeled and displayed</label>
<select name="ralavant_image" id="ralavant_image">
<option value="">Select</option>
<option value="ECG">ECG</option>
<option value="X-Ray">X-Ray</option>
<option value="MRI">MRI</option>
<option value="Audiogram">Audiogram</option>
<option value="USG">USG</option>
</select>

<div class="clear"></div>

<label>Surgical position</label>
<select name="surgical_pos" id="surgical_pos">
<option value="">Select</option>
<option value="Supine">Supine</option>
<option value="Lateral left">Lateral left</option>
<option value="Lateral right">Lateral right</option>
<option value="Prone">Prone</option>
<option value="Trendelenburg">Trendelenburg</option>
<option value="Lithotomy">Lithotomy</option>
<option value="Others">Others</option>
</select>

<label>Any Equipment Concern</label>
<!-- <input type="text" maxlength="10" name="equip_concern" id="equip_concern" value=""  /> -->
<select name="equip_concern" id="equip_concern">
<option>Select</option>
<option value="Airway">Airway</option>
<option value="MASK">MASK</option>
<option value="EDT">EDT</option>
<option value="LMA">LMA</option>
<option value="IGEL"> IGEL</option>
<option value="ILMA"> ILMA</option>
<option value="FOB"> FOB</option>
<option value="TRACHEOSTOMY"> TRACHEOSTOMY</option>
</select>

<label>Antipicated Critical Events</label>
<input type="text" maxlength="10" name="anticipated_critical_event" id="anticipated_critical_event"  value="" />
<div class="clear"></div>
</div>

<h4>Surgeon</h4>

<div class="Block">

<label style="width: 161px;margin-left: 0px" >Critical or non routine steps</label>
<input type="text" maxlength="250" name="critical_steps" id="critical_steps" value="" />
 
<label>Case Duration</label>
<input type="text" name="case_duration"  id="case_duration" value="" maxlength="5"/>

<label>Anticipated Blood Loss</label>
<input type="text" maxlength="5" name="blood_loss" id="blood_loss" value="" />
<div class="clear"></div>
</div>

<h4>Anesthesia Provider</h4>

<div class="Block">

<label class="auto" style="padding:0px 12px 0px 5px;">Antibiotic Prophylaxis within one hour before incision</label>
<select  name="antibiotic_prophylaxis" id="antibiotic_prophylaxis">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
 <label>Additional Concerns</label>
<input type="text" maxlength="10" name="additional_concern"  id="additional_concern" value="" />
<div class="clear"></div>
</div>
<h4>Scrub and Circulating Nurse</h4>
<div class="Block">
<label class="auto" style="padding:0px 12px 0px 5px;">Sterilization indicators have been confirmed</label>
<select name="sterlization_indicator" id="sterlization_indicator">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
 <label>Additional Concerns</label>
<input type="text" maxlength="10" name="ster_additional_concern" id="ster_additional_concern" value="" />
<div class="clear"></div>
</div>
<div class="paddingTop20"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Submit" class="button" onclick="submitForm('wardRemarks','ot?method=submitIntrOperatioveForOt');" accesskey="a" tabindex=1 />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div><div class="paddingTop40"></div>
<script >
function checkConfirm(con){
	if(con=='Y')
	{
		jQuery(document).ready(function()
		{
			jQuery("#confirmId").slideDown();
		});
	}
	else
	{
		jQuery(document).ready(function()
		{
			jQuery("#confirmId").slideUp();
		});
	}	
}


function fillMemberDetails(val,inc)
{
	  if(val!=''){
		  //alert("Method called " + val + inc);
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
              
                  obj = document.getElementById('designation'+inc);
                obj.length = 1;
                  var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
                  for (loop = 0; loop < items.childNodes.length; loop++) {
                       var item = items.childNodes[loop];
                      var idMember = item.getElementsByTagName("idMember")[0];    
                       var nameMember  = item.getElementsByTagName("nameMember")[0];
                      // alert("dfsf"+item.getElementsByTagName("designation")[0]);
                    var designation  = item.getElementsByTagName("designation")[0];
                    if(designation.childNodes[0]!=undefined){
                          for(innerLoop = 0;innerLoop <designation.childNodes.length;innerLoop++)
                        {
                            var dr = designation.childNodes[innerLoop];
                            //var dId  = dr.getElementsByTagName("dId")[0];
                            var dName  = dr.getElementsByTagName("dName")[0];
                              // document.getElementById('emp_id'+inc).value = idMember.childNodes[0].nodeValue
                          obj.length++;
                            //obj.options[obj.length-1].value=dId.childNodes[0].nodeValue;
                            document.getElementById('designation'+inc).value=dName.childNodes[0].nodeValue;
                            
                        }
                        }
              }
        
              }
            }
            
            var url='/hms/hms/ot?method=fillMemberForName&nameMember='+val;
    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
             
            xmlHttp.open("GET",url,true);
            xmlHttp.setRequestHeader("Content-Type", "text/xml");
            xmlHttp.send(null);
        }else{
            //document.getElementById('surgeonName'+inc).value='';
        }
   
}

function addRowForSurgeon(){

	  var tbl = document.getElementById('surgeonGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=iteration
	  // alert("iteration row--"+iteration)


	  var cellRightSel = row.insertCell(0);
	  var sel = document.createElement('input');
	  //sel.value=hdb.value;
	 // sel.size='2';
	  sel.type = 'checkbox';
	  //sel.setAttribute("readonly","readonly");
	  sel.name='itemRadio'+(iteration-1);
	  sel.id ='itemRadio'+(iteration-1);
	  cellRightSel.appendChild(sel);


	  var cellRight1 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name = 'surgeonName' + iteration;
	  e0.id = 'surgeonName' + iteration;
	  e0.size = '43'
	 
		  /* e0.onclick = function(){
		  fillMemberDetails(this.value,this,'2,5',':');
				  } */
		e0.onblur = function(){
			fillMemberDetails(this.value,iteration);
			}
	 
	var newdiv = document.createElement('div');
 	newdiv.setAttribute('id', 'ac2update2');
 	newdiv.style.display = 'none';
 	newdiv.className = "autocomplete";
  cellRight1.appendChild(newdiv);

	  cellRight1.appendChild(e0);
	new Ajax.Autocompleter('surgeonName'+iteration,'ac2update2','ot?method=getSurgeonListForAutoComplete',{parameters:'requiredField=surgeonName'+iteration});
 
	/*  */
	 var cellRight2 = row.insertCell(2);
	  var d = document.createElement('input');
	  d.type = 'text';
	  d.name = 'designation' + iteration;
	  d.id = 'designation' + iteration;
	  d.size = '43'
		  cellRight2.appendChild(d);
	  
	  
	  
	  var cellRight3 = row.insertCell(3);
	  var d2 = document.createElement('Select');
	  d2.name = 'role' + iteration;
	  d2.id = 'role' + iteration;
	  
	  
	  d2.options[0] = new Option('Select', '');
	  d2.options[1] = new Option('Surgeon', 'Surgeon');
	  d2.options[2] = new Option('First Assistance', 'First Assistance');
	  d2.options[3] = new Option('Second Assistance', 'Second Assistance');
	  d2.options[4] = new Option('Third Assistance', 'Third Assistance');
	  d2.options[5] = new Option('Fourth Assistance', 'Fourth Assistance');
	  d2.options[6] = new Option('Floor Nurse', 'Floor Nurse');
	  d2.options[7] = new Option('Main Nurse', 'Main Nurse');
		d2.options[8] = new Option('Count Nurse', 'Count Nurse');
		d2.options[9] = new Option('Anesthetist one', 'Anesthetist one');
		d2.options[10] = new Option('Anesthetist two', 'Anesthetist two');
		d2.options[11] = new Option('Anesthetist three', 'Anesthetist three');
		
		
		  cellRight3.appendChild(d2);
	 }
	 
/* function removeRow()
{
  var tbl = document.getElementById('surgeonGrid');
  document.getElementById('hiddenValue').value=document.getElementById('hiddenValue').value-1;
  var lastRow = tbl.rows.length;
  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
  else
	      alert("Cannot Delete All Rows");
 } */
 
 function removeRow(){
	 var tbl = document.getElementById('surgeonGrid');
	 var lastRow = tbl.rows.length;
	 var hdb = document.getElementById('hiddenValue');
	 var iteration = parseInt(hdb.value);
	 var totalSelected = 0;
	 var lastRow = tbl.rows.length;
	 if(lastRow==2){
		 alert("Cannot Delete All Rows!");
	 }else if (confirm("Do you want to delete !")) {
		 for (var i = 0; i <= iteration; i++) {

				if (document.getElementById("itemRadio" + i) != null
						&& (typeof document.getElementById("itemRadio" + i).checked) != 'undefined'
						&& document.getElementById("itemRadio" + i).checked) {
					totalSelected = totalSelected + 1;
				}
			}
		 if (totalSelected == 0) {
				alert('Please select atleast 1 row to delete');
			}
		 
		 for (var i = 0; i <= iteration; i++) {
				if (document.getElementById("itemRadio" + i) != null
						&& (typeof document.getElementById("itemRadio" + i).checked) != 'undefined'
						&& document.getElementById("itemRadio" + i).checked) {
					var deleteRow = document.getElementById("itemRadio" + i).parentNode.parentNode;
					document.getElementById("itemRadio" + i).parentNode.parentNode.parentNode
							.removeChild(deleteRow);
				}
			}
		 
	 }
	 
		
 }

</script>


</form>