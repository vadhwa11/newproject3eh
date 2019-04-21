<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="java.io.InputStream"%>
<script src="/hms/jsp/js/jquery-1.7.2.min.js"></script>
<!-- <script>jQuery.noConflict();</script> -->

<script>
			// Wait until the DOM has loaded before querying the document
			$(document).ready(function(){
				$('ul.tabs').each(function(){
					// For each set of tabs, we want to keep track of
					// which tab is active and it's associated content
					var $active, $content, $links = $(this).find('a');

					// If the location.hash matches one of the links, use that as the active tab.
					// If no match is found, use the first link as the initial active tab.
					$active = $($links.filter('[href="'+location.hash+'"]')[0] || $links[0]);
					$active.addClass('Tabactive');

					$content = $($active[0].hash);

					// Hide the remaining content
					$links.not($active).each(function () {
						$(this.hash).hide();
					});

					// Bind the click event handler
					$(this).on('click', 'a', function(e){
						// Make the old tab inactive.
						$active.removeClass('Tabactive');
						$content.hide();

						// Update the variables with the new link and content
						$active = $(this);
						$content = $(this.hash);

						// Make the tab active.
						$active.addClass('Tabactive');
						$content.show();

						// Prevent the anchor's default click action
						e.preventDefault();
					});
				});
			});
</script>



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

int hinId = 0;
String hin_no="";
String inpatient_no="";
String name="";
String age="";
String sex="";
int inpatientId=0;
int bookingId=0;
for(OtBooking booking:patientList){
	bookingId=booking.getId();
	hinId=booking.getHin().getId();
	inpatientId  =booking.getInpatient()!=null?booking.getInpatient().getId():0;
	hin_no=booking.getHin().getHinNo();
	//inpatient_no=inp.getAdNo();
	name=booking.getHin().getPFirstName();
	age=booking.getHin().getAge();
	sex=booking.getHin().getSex()!=null?booking.getHin().getSex().getAdministrativeSexName():"";
}
	
%> 
	
	<%if(!message.equals("")){ %> <h4><span><%=message %></span></h4> <% }%>
<!--main content placeholder starts here-->
<body>
<form name="sugeryCheckList" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">		
<div class="clear"></div>
<div class="titlebg">
<h2>Surgery Safety CheckList</h2>
</div>
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>

<input type="hidden" name="hinId" id="hinId" value="<%=hinId %>"/>
<input type="hidden" name="inpatientId" id="inpatientId" value="<%=inpatientId %>"/>
<input type="hidden" name="bookingId" id="bookingId" value="<%=bookingId %>"/>
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

<!--tab content starts-->

		<ul class="tabs">
			<li><a href='#tab1'>Before induction of anaesthesia</a></li>
			<li><a href='#tab2'>Before skin incision</a></li>
			<li><a href='#tab3'>Before patient leaves operating room</a></li>
		</ul>


<div id='tab1'>
<div class="Block" style="background: #66bc95;">
<div class="tabsContentCenterDiv" style="margin-left:35px;">					
			    	<div class="clear"></div>
			    	<div class="episodelabel"><strong>Has the patient confirmed his/her identity, site, procedure, and consent?</strong></div>					
					<div class="clear"></div>
					<input type="radio" name="pcfc" value="Y"  class="episodeSelect" >
					<div class="episodelabel">Yes</div>
					<div class="clear"></div>
					<input type="radio" name="pcfc" value="N"  class="episodeSelect" >
					<div class="episodelabel">No</div>
					<div class="clear"></div>
					
					
					
					<div class="clear"></div>
					<div class="episodelabel"><strong>Is the site marked?</strong></div>
					<div class="clear"></div>
					<input type="radio" name="issm" value="Y"   class="episodeSelect" >
					<div class="episodelabel">Yes</div>
					<div class="clear"></div>
					<input type="radio" name="issm"  value="N"  class="episodeSelect" >
					<div class="episodelabel">Not applicable</div>
					<div class="clear"></div>
					
					
					<div class="clear"></div>
					<div class="episodelabel"><strong>Is the anaesthesia machine and medication check complete?</strong></div>
					<div class="clear"></div>
					<input type="radio" name="anaesthesiaMachineCheck"  value="Y"   class="episodeSelect" >
					<div class="episodelabel">Yes</div>
					<div class="clear"></div>
					<input type="radio" name="anaesthesiaMachineCheck"  value="N"  class="episodeSelect" >
					<div class="episodelabel">No</div>
					<div class="clear"></div>
					
					
					<div class="clear"></div>
					<div class="episodelabel"><strong>Is the pulse oximeter on the patient and functioning?</strong></div>
					<div class="clear"></div>
					<input type="radio" name="oximeterCheck"  value="Y"  class="episodeSelect" >
					<div class="episodelabel">Yes</div>
					<div class="clear"></div>
					<input type="radio" name="oximeterCheck"  value="N"  class="episodeSelect" >
					<div class="episodelabel">No</div>
					<div class="clear"></div>
					<br/>
					<br/>
					
					<h4>Does the patient have a:</h4>
					<div class="clear"></div>
					<div class="episodelabel"><strong>Known allergy?</strong></div>
					<div class="clear"></div>
					<input type="radio" name="allergyCheck" value="N"  class="episodeSelect" >
					<div class="episodelabel">No</div>
					<div class="clear"></div>
					<input type="radio" name="allergyCheck"  value="Y" class="episodeSelect" >
					<div class="episodelabel">Yes</div>
					<div class="clear"></div>
					
					
					
					<div class="clear"></div>
					<div class="episodelabel"><strong>Difficult airway or aspiration risk?</strong></div>
					<div class="clear"></div>
					<input type="radio" name="aspirationCheck" value="N" class="episodeSelect" >
					<div class="episodelabel">No</div>
					<div class="clear"></div>
					<input type="radio" name="aspirationCheck" value="Y"  class="episodeSelect" >
					<div class="episodelabel">Yes, and equipment/assistance available</div>
					<div class="clear"></div>
					
					
					
					<div class="clear"></div>
					<div class="episodelabel"><strong>Risk of >500ml blood loss (7ml/kg in children)?</strong></div>
					<div class="clear"></div>
					<input type="radio" name="risk" value="N"  class="episodeSelect" >
					<div class="episodelabel">No</div>
					<div class="clear"></div>
					<input type="radio" name="risk" value="Y"  class="episodeSelect" >
					<div class="episodelabel">Yes, and two IVs/central access and fluids planned</div>
					<div class="clear"></div>
					
					</div>
					</div>


</div>
<div id='tab2'>
<div class="Block"  style="background: #a6d8c1;">
<div class="tabsContentCenterDiv" style="margin-left:310px;">					
			  	 	<div class="clear"></div>
					<input type="checkbox" name="confirmAll" value="Y"  class="episodeSelect" > 
					<div class="episodelabel"><strong>Confirm all team members have	introduced themselves by name and role.</strong></div>
					<div class="clear"></div>
					
					
					<div class="clear"></div>
					<input type="checkbox" name="patientInfoCheck" value="Y"  class="episodeSelect" > 
					<div class="episodelabel"><strong>Confirm the patient's name, procedure, and where the incision will be made.</strong></div>
					<div class="clear"></div>
					
					
					<div class="clear"></div>
					<div class="episodelabel"><strong>Has antibiotic prophylaxis been given within the last 60 minutes?</strong></div>
					<div class="clear"></div>
					<input type="radio" name="antibioticProphylaxis" value="Y"  class="episodeSelect" >
					<div class="episodelabel">Yes</div>
					<div class="clear"></div>
					<input type="radio" name="antibioticProphylaxis" value="N"  class="episodeSelect" >
					<div class="episodelabel">Not applicable</div>
					<div class="clear"></div>
					<br/>
					<br/>
					
					<h6>Anticipated Critical Events</h6>
					<div class="clear"></div>
					<h4>To Surgeon:</h4>
					<div class="clear"></div>
					<input type="checkbox" name="criticalStepsCheck" value="Y"  class="episodeSelect" >
					<div class="episodelabel"><strong>What are the critical or non-routine steps?</strong></div> 
					<div class="clear"></div>
					<input type="checkbox" name="caseDurationCheck" value="Y"  class="episodeSelect" >
					<div class="episodelabel"><strong>How long will the case take?</strong></div> 
					<div class="clear"></div>
					<input type="checkbox" name="bloodLossCheck" value="Y"  class="episodeSelect" >
					<div class="episodelabel"><strong>What is the anticipated blood loss?</strong></div> 
					<div class="clear"></div>
					
					<h4>To Anaesthetist:</h4>
					<div class="clear"></div>
					<input type="checkbox" name="additionalConcern" value="Y"  class="episodeSelect" > 
					<div class="episodelabel"><strong>Are there any patient-specific concerns?</strong></div>
					<div class="clear"></div>
					
					<h4>To Nursing Team:</h4>
					<div class="clear"></div>
					<input type="checkbox" name="sterlizationIndicator"  value="Y" class="episodeSelect" >
					<div class="episodelabel"><strong>Has sterility (including indicator results) been confirmed?</strong></div> 
					<div class="clear"></div>
					<input type="checkbox" name="equipConcern" value="Y"  class="episodeSelect" > 
					<div class="episodelabel"><strong>Are there equipment issues or any concerns?</strong></div>
					
					
					<div class="clear"></div>
					<div class="episodelabel"><strong>Is essential imaging displayed?</strong></div>
					<div class="clear"></div>
					<input type="radio" name="ralavantImage"  value="Y" class="episodeSelect" >
					<div class="episodelabel">Yes</div>
					<div class="clear"></div>
					<input type="radio" name="ralavantImage" value="N"  class="episodeSelect" >
					<div class="episodelabel">Not applicable</div>
					<div class="clear"></div>
					
	</div>				
</div>
</div>
<div id='tab3'>
<div class="Block"   style="background: #d9eee5;">
<div class="tabsContentCenterDiv" style="margin-left:690px; width:450px;">				
			  		<div class="clear"></div>
					<h4>Nurse Verbally Confirms:</h4>
					<div class="clear"></div>
					<input type="checkbox" name="nameOfOperativeProc" value="Y"  class="episodeSelect" >
					<div class="episodelabel"><strong>The name of the procedure</strong></div> 
					<div class="clear"></div>
					<input type="checkbox" name="spongeNeddleCheck"  value="Y"  class="episodeSelect" >
					<div class="episodelabel"><strong>Completion of instrument, sponge and needle counts</strong></div> 
					<div class="clear"></div>
					<input type="checkbox" name="specIdentifiedAndLabeled" value="Y"  class="episodeSelect" >
					<div class="episodelabel"><strong>Specimen labelling (read specimen labels aloud, including patient name)</strong></div> 
					<div class="clear"></div>
					<input type="checkbox" name="anyEquipProbAddress" value="Y" class="episodeSelect" >
					<div class="episodelabel"><strong>Whether there are any equipment problems to be addressed</strong></div> 
					<div class="clear"></div>
					
					
					<div class="clear"></div>
					<h4>To Surgeon, Anaesthetist and Nurse:</h4>
					<div class="clear"></div>
					<input type="checkbox" name="keyConcernForRecovery" value="Y"   class="episodeSelect" >
					<div class="episodelabel"><strong>What are the key concerns for recovery and management of this patient?</strong></div> 

</div>					<div class="clear"></div>
</div>
</div>
			
			<div class="clear"></div>
			<div class="division"></div>
			<div class="clear"></div>
		
			<input name="Submit11" id="Submit" class="buttonAuto" type="button" align="right"	value="Submit"
				 onclick="submitForm('sugeryCheckList','ot?method=submitSurgerySafetyCheckList');" />
			
			<div class="clear"></div>
			<div class="division"></div>
		<div class="clear"></div>
		<div class="paddingTop40"></div>
		<div class="clear"></div>
	</form>
</body>


<!--main content placeholder ends here-->
<script type="text/javascript">
function checkTab(tab) {
	document.getElementById("tab").value = tab;
}

</script>
