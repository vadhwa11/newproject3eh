<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.BloodStockDetail"%>
<%@page import="jkt.hms.masters.business.BloodReactionEntry"%>
<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/animatedcollapse.js"></script>
<script type="text/javascript" src="/hms/jsp/js/tabcontent.js">
	/***********************************************
	* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
	* This notice MUST stay intact for legal use
	* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
	***********************************************/
	</script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<form name="bloodReaction" method="post" action=""><script
	type="text/javascript">

animatedcollapse.addDiv('title1', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('title2', 'fade=0,speed=400,group=pets,persist=1,hide=1')

animatedcollapse.init()

</script> <script>
	function changeClass(title,t)
	{
	animatedcollapse.toggle(title,t);
	}
	</script> <script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(dateCal.length()<2){
	dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script> <%
	int pageNo=1;
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Set<Inpatient> inpatientSet = new HashSet<Inpatient>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	String userName="";
	int bloodReactionId=0;
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
		}
		if(map.get("detailsMap") != null){
		detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		if (session.getAttribute("userName") != null) {
			  userName = (String) session.getAttribute("userName");
		}
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<BloodStockDetail> stockList = new ArrayList<BloodStockDetail>();
		List<BloodReactionEntry> reactionList = new ArrayList<BloodReactionEntry>();
		
		if(map.get("reactionList") != null){
			reactionList= (List<BloodReactionEntry>)map.get("reactionList");
		}
		if(map.get("bloodGroupList") != null){
			bloodGroupList= (List<MasBloodGroup>)map.get("bloodGroupList");
		}
		if(map.get("employeeList") != null){
			employeeList= (List<MasEmployee>)map.get("employeeList");
		}
		if(map.get("stockList") != null){
			stockList= (List<BloodStockDetail>)map.get("stockList");
		}
		BloodReactionEntry reactionEntry = new BloodReactionEntry();
		if(reactionList != null && reactionList.size()>0){
			reactionEntry = reactionList.get(0);	
		}
		int hinId=0;
		int reactionId=0;
		if(reactionEntry.getHin()!=null){
			hinId = reactionEntry.getHin().getId();			
		}
		if(map.get("bloodReactionId") != null){
			bloodReactionId =(Integer)map.get("bloodReactionId");
		}
%> <!--main content placeholder starts here-->
<div class="titleBg">
<h2>Blood Reaction Form Entry</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<input id="entryNoId" type=hidden name="<%=BLOOD_REACTION_ID %>"
	value="<%=reactionEntry.getId() %>" title="Entry Number" /> <%
		String entrySeqNo="";
		if(map.get("entrySeqNo") != null){
			entrySeqNo = (String)map.get("entrySeqNo");
		}
%> <label>Entry No.</label> <label class="value"><%=reactionEntry.getEntryNo() %></label>
<input id="entryNoId" type=hidden name="<%=ENTRY_NO %>"
	value="<%=reactionEntry.getEntryNo() %>" title="Entry Number" /> <label>Reaction
Date</label> <% if(reactionEntry.getRactionDate() != null){%> <input type="text"
	id="reactDate" name="<%=REACTION_DATE %>" class="date"
	value="<%= HMSUtil.convertDateToStringWithoutTime(reactionEntry.getRactionDate()) %>"
	onblur="validateRequiredDate(bloodReaction);" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.bloodReaction.<%=REACTION_DATE%>,event)"
	onblur="validateRequiredDate(bloodReaction);" /> <%}else{ %> <label
	class="value"><%=currentDate %></label> <input type="hidden"
	name="<%=REACTION_DATE %>" value="<%=currentDate%>" /> <%} %>

<div class="clear"></div>
<label>HIN </label> <%if(reactionEntry.getHin() != null){ %> <label
	class="value"><%=reactionEntry.getHin().getHinNo()%></label> <%}else{ %>
<label class="value">-</label> <%} %> <label>Patient Blood Group</label> <%if(reactionEntry.getBloodGroup() !=null){%>
<label class="value"><%=reactionEntry.getBloodGroup().getBloodGroupName()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Patient
Name</label> <%if(reactionEntry.getHin() != null){ %> <label class="value"><%=reactionEntry.getHin().getPFirstName()+" "+reactionEntry.getHin().getPMiddleName()+" "+reactionEntry.getHin().getPLastName()%></label>
<%}else{ %> <label class="value">-</label> <%} %>

<div class="clear"></div>

<label>Sex</label> <%if(reactionEntry.getHin()!=null){ %> <%if(reactionEntry.getHin().getSex() != null){ %>
<label class="value"><%=reactionEntry.getHin() .getSex().getAdministrativeSexName()%></label>
<%}}else{ %> <label class="value">-</label> <%} %> <label>Age</label> <%if(reactionEntry.getHin()  != null){ %>
<label class="value"><%=reactionEntry.getHin().getAge()%></label> <%}else{ %>
<label class="value"> - </label> <%} %> <%
			Set<Inpatient> set = new HashSet<Inpatient>();
%> <%if(reactionEntry.getInpatient() != null) {%> <input type="hidden"
	name="<%=INPATIENT_ID %>"
	value="<%=reactionEntry.getInpatient().getId()%>" /> <%} %> <input
	type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=reactionEntry.getDepartment().getId() %>" /> <input
	type="hidden" name="<%=HIN_ID %>" value="<%=hinId %>" />

<div class="clear"></div>
</div>
<div class="clear"></div>
<a href="javascript:changeClass('title1','t1')">
<h5 id='t1'>Details</h5>
</a>
<div class="clear"></div>
<div id="title1"><!--Block Two Starts-->
<div class="Block">
<div class="clear"></div>
<label> <span>*</span> Blood Bag No.</label> <%if(reactionEntry.getBloodBagNo() != null){ %>
<input id="bloodBagNo" name="<%=BLOOD_BAG_NO %>" type="text"
	value="<%=reactionEntry.getBloodBagNo() %>" /> <%}else{ %> <input
	id="bloodBagNo" name="<%=BLOOD_BAG_NO %>" type="text" value="" /> <%} %>

<label> <span>*</span> Issue Date</label> <%if(reactionEntry.getIssuedDate() != null){ %>
<input id="bloodBagNo" name="<%=ISSUED_DATE %>" class="date" type="text"
	value="<%=HMSUtil.convertDateToStringWithoutTime(reactionEntry.getIssuedDate()) %>" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.bloodReaction.<%=ISSUED_DATE%>,event)" />
<%}else{ %> <input type="text" class="date" id="fromDateId"
	name="<%=ISSUED_DATE %>" value="" readonly="readonly" MAXLENGTH="30"
	validate="Issue Date,date,yes" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.bloodReaction.<%=ISSUED_DATE%>,event)" />
<%} %> <label> <span>*</span> Issue Time</label> <%if(reactionEntry.getIssuedTime() != null){ %>
<input id="bloodBagNo" name="<%=ISSUED_TIME %>" type="text"
	value="<%=reactionEntry.getIssuedTime() %>"
	onchange="IsValidTime(this.value,this.id);"
	validate="Issue Time,time,yes" maxlength="8" /> <%}else{ %> <input
	id="issueTime" name="<%=ISSUED_TIME %>" type="text" value=""
	onchange="IsValidTime(this.value,this.id);"
	validate="Issue Time,time,yes" maxlength="8" /> <%} %>
<div class="clear"></div>
<label> <span>*</span> Donor's Name</label> <%if(reactionEntry.getDonorName()!= null){ %>
<input id="bloodBagNo" name="<%=DONOR_NAME %>" type="text"
	value="<%=reactionEntry.getDonorName() %>"
	validate="Donor's Name,string,yes" maxlength="25" /> <%}else{ %> <input
	id="donorName" name="<%=DONOR_NAME %>" type="text" value=""
	validate="Donor's Name,string,yes" maxlength="25" /> <%} %> <label>
<span>*</span> Donor's Group</label> <select id="bloodGroupId"
	name=<%=BLOOD_GROUP_ID %> validate="Blood Group,string,yes">
	<option value="0">Select</option>
	<%
				         		if(bloodGroupList != null){ 	
				         			for (Iterator iter = bloodGroupList.iterator(); iter.hasNext();) {
				         				MasBloodGroup bloodGroup = (MasBloodGroup) iter.next();
				         %>
	<%if(reactionEntry.getBloodGroup().getId() .equals(bloodGroup.getId())){ %>
	<option value="<%=reactionEntry.getBloodGroup().getId()%>"
		selected="selected"><%=reactionEntry.getBloodGroup().getBloodGroupName()%></option>
	<%}else{ %>
	<option value="<%=bloodGroup.getId() %>"><%=bloodGroup.getBloodGroupName()%></option>
	<%		}} } %>
</select> <label> <span>*</span> Cross Matched By</label> <select id="matchedId"
	name=<%=CROSS_MATCHED_BY %> validate="Cross Matched By,string,yes">
	<option value="0">Select</option>
	<%
				         		if(employeeList != null){ 	
				         			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
				         				MasEmployee masEmployee = (MasEmployee) iter.next();
				         %>
	<%if(reactionEntry.getCrossMatchedBy().getId() .equals(masEmployee.getId())){ %>
	<option value="<%=reactionEntry.getCrossMatchedBy().getId()%>"
		selected="selected"><%=reactionEntry.getCrossMatchedBy().getFirstName()%></option>
	<%}else{ %>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()%></option>
	<%		}} } %>
</select>
<div class="clear"></div>
<label> <span>*</span> Issued To</label> <%if(reactionEntry.getIssuedTo() != null){ %>
<input id="issuedTo" name="<%=ISSUED_TO %>"
	value="<%=reactionEntry.getIssuedTo() %>" type="text" maxlength="25"
	validate="Issued To,string,yes" /> <%}else{ %> <input id="issuedTo"
	name="<%=ISSUED_TO %>" value="" type="text" maxlength="25"
	validate="Issued To,string,yes" /> <%} %> <label> <span>*</span>
Issued By</label> <select id="issuedBy" name=<%=ISSUED_BY %>
	validate="Issued By,string,yes">
	<option value="0">Select</option>
	<%
				         		if(employeeList != null){ 	
				         			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
				         				MasEmployee masEmployee1 = (MasEmployee) iter.next();
				         %>
	<%if(reactionEntry.getIssuedBy().getId() .equals(masEmployee1.getId())){ %>
	<option value="<%=reactionEntry.getIssuedBy().getId()%>"
		selected="selected"><%=reactionEntry.getIssuedBy().getFirstName()%></option>
	<%}else{ %>
	<option value="<%=masEmployee1.getId() %>"><%=masEmployee1.getFirstName()%></option>
	<%		}} } %>
</select> <label>Wd No.</label> <%if(reactionEntry.getWdNo()!=null){ %> <input
	id="wdNo" name="<%=WD_NO %>" value="<%=reactionEntry.getWdNo() %>"
	type="text" maxlength="25" validate="Wd No,int,yes" /> <%}else{ %> <input
	id="wdNo" name="<%=WD_NO %>" value="" type="text" maxlength="25"
	validate="Wd No,int,yes" /> <%} %>
<div class="clear"></div>
</div>
</div>

<div class="clear"></div>
<a href="javascript:changeClass('title2','t2')">
<h5 id='t2'>Details</h5>
</a>
<div class="clear"></div>
<div id="title2"><!--Block Two Starts-->
<div class="Block">
<div class="clear"></div>
<label><span>*</span>Temperature of patient Before Transfusion</label> <%if(reactionEntry.getTransfussion()!=null){ %>
<input id="tempTransfussion" name="<%=TEMP_TRANSFUSSION %>"
	value="<%=reactionEntry.getTransfussion() %>" type="text"
	maxlength="25"
	validate="Temperature of patient Before Transfusion,string,yes" /> <%}else{ %>
<input id="tempTransfussion" name="<%=TEMP_TRANSFUSSION %>" value=""
	type="text" maxlength="25"
	validate="Temperature of patient Before Transfusion,string,yes" /> <%} %>

<label>Date of Transfusion</label> <%if(reactionEntry.getDateTransfussion()!=null){ %>
<input type="text" class="date" id="fromDateId"
	name="<%=TRANSFUSSION_DATE %>"
	value="<%= HMSUtil.convertDateToStringWithoutTime(reactionEntry.getDateTransfussion()) %>"
	readonly="readonly" MAXLENGTH="30"
	validate="Date of Transfusion,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.bloodReaction.<%=TRANSFUSSION_DATE%>,event)" />
<%}else{ %> <input type="text" class="date" id="fromDateId"
	name="<%=TRANSFUSSION_DATE %>" value="" readonly="readonly"
	MAXLENGTH="30" validate="Date of Transfusion,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.bloodReaction.<%=TRANSFUSSION_DATE%>,event)" />

<%} %>
<div class="clear"></div>
<label> Time started</label> <%if(reactionEntry.getTimeStarted()!=null){ %>
<input id="startedTime" name="<%=STARTED_TIME %>"
	value="<%=reactionEntry.getTimeStarted() %>" type="text" maxlength="25"
	onchange="IsValidTime(this.value,this.id);"
	onKeyUp="mask(this.value,this,'2',':');"
	validate="Time started,time,yes" maxlength="5"
	onBlur="IsValidTime(this.value,this.id);" /> <%}else{ %> <input
	id="startedTime" name="<%=STARTED_TIME %>" type="text" value=""
	onKeyUp="mask(this.value,this,'2',':');"
	validate="Time started,time,yes" maxlength="5"
	onBlur="IsValidTime(this.value,this.id);" /> <%} %> <label class="small">hrs</label>

<label>Time Completed</label> <%if(reactionEntry.getTimeCompleted()!=null){ %>
<input id="startedTime" name="<%=COMPLETED_TIME %>"
	value="<%=reactionEntry.getTimeCompleted() %>" type="text"
	maxlength="25" onKeyUp="mask(this.value,this,'2',':');"
	validate="Time Completed,time,no" maxlength="5"
	onBlur="IsValidTime(this.value,this.id);" /> <%}else{ %> <input
	id="completedTime" name="<%=COMPLETED_TIME %>" type="text" value=""
	onKeyUp="mask(this.value,this,'2',':');"
	validate="Time Completed,time,no" maxlength="5"
	onBlur="IsValidTime(this.value,this.id);" /> <%} %> <label class="small">hrs</label>
<div class="clear"></div>

<h4>Reaction Noticed</h4>

<div class="clear"></div>
<div class="Height10"></div>

<div class="paddLeft25"><label class="large">Pyrexia -
Rise in temperature to 100 0F, but no subjective symptoms :</label></div>

<label>Yes</label> <%if(reactionEntry.getPyrexia().equalsIgnoreCase("y")){ %>
<input name="<%=PYREXIA %>" type="radio" class="radioCheck"
	value="<%=reactionEntry.getPyrexia() %>" checked="checked" /> <%}else { %>
<input name="<%=PYREXIA %>" type="radio" class="radioCheck" value="" />
<%} %> <label>No</label> <%if(reactionEntry.getPyrexia().equalsIgnoreCase("y")){ %>
<input name="<%=PYREXIA %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else { %> <input name="<%=PYREXIA %>"
	type="radio" class="radioCheck" value="" /> <%} %>
<div class="clear"></div>

<div class="paddLeft25"><label class="large">Rise in
temperature to 100 0F, or above, feeling cold but no rigor :</label></div>
<label>Yes</label> <%if(reactionEntry.getRiseTemp().equalsIgnoreCase("y")){ %>
<input name="<%=RISE_TEMP %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else{ %> <input name="<%=RISE_TEMP %>"
	type="radio" class="radioCheck" value="" /> <%} %> <label>No</label> <%if(reactionEntry.getRiseTemp().equalsIgnoreCase("n")){ %>
<input name="<%=RISE_TEMP %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else{ %> <input name="<%=RISE_TEMP %>"
	type="radio" class="radioCheck" value="" /> <%} %>
<div class="clear"></div>

<div class="paddLeft25"><label class="large">Rigor :</label></div>
<label>Yes</label> <%if(reactionEntry.getRigor().equalsIgnoreCase("y")){ %>
<input name="<%=RIGOR %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else{ %> <input name="<%=RIGOR %>" type="radio"
	class="radioCheck" value="" /> <%} %> <label>No</label> <%if(reactionEntry.getRigor().equalsIgnoreCase("n")){ %>
<input name="<%=RIGOR %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else{ %> <input name="<%=RIGOR %>" type="radio"
	class="radioCheck" value="" /> <%} %>
<div class="clear"></div>

<div class="paddLeft25"><label class="large">Fall of BP :
Systolic ............................ Diastolic
........................... </label></div>
<label>Yes</label> <%if(reactionEntry.getFallOfBp().equalsIgnoreCase("y")){ %>
<input name="<%=FALL_BP %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else{ %> <input name="<%=FALL_BP %>"
	type="radio" class="radioCheck" value="" /> <%} %> <label>No</label> <%if(reactionEntry.getFallOfBp().equalsIgnoreCase("n")){ %>
<input name="<%=FALL_BP %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else{ %> <input name="<%=FALL_BP %>"
	type="radio" class="radioCheck" value="" /> <%} %>
<div class="clear"></div>

<div class="paddLeft25"><label class="large">Allergic
Reaction- Itching : </label></div>
<label>Yes</label> <%if(reactionEntry.getItching().equalsIgnoreCase("y")){ %>
<input name="<%=ITCHING %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else{ %> <input name="<%=ITCHING %>"
	type="radio" class="radioCheck" value="" /> <%} %> <label>No</label> <%if(reactionEntry.getItching().equalsIgnoreCase("n")){ %>
<input name="<%=ITCHING %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else{ %> <input name="<%=ITCHING %>"
	type="radio" class="radioCheck" value="" /> <%} %>

<div class="clear"></div>

<div class="paddLeft25"><label class="large">Urticarla : </label>
</div>
<label>Yes</label> <%if(reactionEntry.getUrticarla().equalsIgnoreCase("y")){ %>
<input name="<%=URTICARLA %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else{ %> <input name="<%=URTICARLA %>"
	type="radio" class="radioCheck" value="" /> <%} %> <label>No</label> <%if(reactionEntry.getUrticarla().equalsIgnoreCase("n")){ %>
<input name="<%=URTICARLA %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else{ %> <input name="<%=URTICARLA %>"
	type="radio" class="radioCheck" value="" /> <%} %>
<div class="clear"></div>

<div class="paddLeft25"><label class="large">Anaphylaxis :
</label></div>
<label>Yes</label> <%if(reactionEntry.getAnaphylaxia().equalsIgnoreCase("y")){ %>
<input name="<%=ANAPHYLAXIA %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else{ %> <input name="<%=ANAPHYLAXIA %>"
	type="radio" class="radioCheck" value="" /> <%} %> <label>No</label> <%if(reactionEntry.getAnaphylaxia().equalsIgnoreCase("n")){ %>
<input name="<%=ANAPHYLAXIA %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else{ %> <input name="<%=ANAPHYLAXIA %>"
	type="radio" class="radioCheck" value="" /> <%} %>
<div class="clear"></div>

<div class="paddLeft25"><label class="large">Pain- Back :
</label></div>
<label>Yes</label> <%if(reactionEntry.getPainBack().equalsIgnoreCase("y")){ %>
<input name="<%=PAIN_BACK %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else{ %> <input name="<%=PAIN_BACK %>"
	type="radio" class="radioCheck" value="" /> <%} %> <label>No</label> <%if(reactionEntry.getPainBack().equalsIgnoreCase("n")){ %>
<input name="<%=PAIN_BACK %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else{ %> <input name="<%=PAIN_BACK %>"
	type="radio" class="radioCheck" value="n" /> <%} %>
<div class="clear"></div>

<div class="paddLeft25"><label class="large">Head : </label></div>
<label>Yes</label> <%if(reactionEntry.getHead().equalsIgnoreCase("y")){ %>
<input name="<%=HEAD %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else{ %> <input name="<%=HEAD %>" type="radio"
	class="radioCheck" value="" /> <%} %> <label>No</label> <%if(reactionEntry.getHead().equalsIgnoreCase("n")){ %>
<input name="<%=HEAD %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else{ %> <input name="<%=HEAD %>" type="radio"
	class="radioCheck" value="n" /> <%} %>

<div class="clear"></div>

<div class="paddLeft25"><label class="large">Chest :</label></div>
<label>Yes</label> <%if(reactionEntry.getChest().equalsIgnoreCase("y")){ %>
<input name="<%=CHEST %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else{ %> <input name="<%=CHEST %>" type="radio"
	class="radioCheck" value="" /> <%} %> <label>No</label> <%if(reactionEntry.getChest().equalsIgnoreCase("n")){ %>
<input name="<%=CHEST %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else{ %> <input name="<%=CHEST %>" type="radio"
	class="radioCheck" value="" /> <%} %>

<div class="clear"></div>

<div class="paddLeft25"><label class="large">Elsewhere :</label></div>
<label>Yes</label> <%if(reactionEntry.getElseWehere().equalsIgnoreCase("y")){ %>
<input name="<%=ELSE_WHERE %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else{ %> <input name="<%=ELSE_WHERE %>"
	type="radio" class="radioCheck" value="" /> <%} %> <label>No</label> <%if(reactionEntry.getElseWehere().equalsIgnoreCase("n")){ %>
<input name="<%=ELSE_WHERE %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else{ %> <input name="<%=ELSE_WHERE %>"
	type="radio" class="radioCheck" value="" /> <%} %>

<div class="clear"></div>

<div class="paddLeft25"><label class="large">Jaundice :</label></div>
<label>Yes</label> <%if(reactionEntry.getJaundice().equalsIgnoreCase("y")){ %>
<input name="<%=JAUNDICE %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else{ %> <input name="<%=JAUNDICE %>"
	type="radio" class="radioCheck" value="" /> <%} %> <label>No</label> <%if(reactionEntry.getJaundice().equalsIgnoreCase("n")){ %>
<input name="<%=JAUNDICE %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else{ %> <input name="<%=JAUNDICE %>"
	type="radio" class="radioCheck" value="" /> <%} %>

<div class="clear"></div>

<div class="paddLeft25"><label class="large">Haemoglobinuria
:</label></div>
<label>Yes</label> <%if(reactionEntry.getHaemoglobinuria().equalsIgnoreCase("y")){ %>
<input name="<%=HAEMAT %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else{ %> <input name="<%=HAEMAT %>" type="radio"
	class="radioCheck" value="" /> <%} %> <label>No</label> <%if(reactionEntry.getHaemoglobinuria().equalsIgnoreCase("n")){ %>
<input name="<%=HAEMAT %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else{ %> <input name="<%=HAEMAT %>" type="radio"
	class="radioCheck" value="" /> <%} %>

<div class="clear"></div>

<div class="paddLeft25"><label class="large">Anuria :</label></div>
<label>Yes</label> <%if(reactionEntry.getAnuria().equalsIgnoreCase("y")){ %>
<input name="<%=ANURIA %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else{ %> <input name="<%=ANURIA %>" type="radio"
	class="radioCheck" value="" /> <%} %> <label>No</label> <%if(reactionEntry.getAnuria().equalsIgnoreCase("n")){ %>
<input name="<%=ANURIA %>" type="radio" class="radioCheck" value=""
	checked="checked" /> <%}else{ %> <input name="<%=ANURIA %>" type="radio"
	class="radioCheck" value="n" /> <%} %>
<div class="clear"></div>

<label class="large">Anyother untoward reactions :</label> <%if(reactionEntry.getUntowardReaction()!= null){ %>
<input name="<%=UNTOWARD_REACTION %>" type="text"
	value="<%=reactionEntry.getUntowardReaction()%>"
	validate="Untoward reactions,string,no" maxlength="25" /> <%}else{ %> <input
	id="untoWardReaction" name="<%=UNTOWARD_REACTION %>" value=""
	type="text" validate="Untoward reactions,string,no" maxlength="25" />
<%} %>
<div class="clear"></div>
</div>
</div>

<div class="clear"></div>
<div class="division"></div>

<!--table--> <!--Bottom labels starts--> <input type="button"
	class="button" value="Update"
	onclick="submitForm('bloodReaction','bloodBank?method=updateBloodReaction');"
	align="right" /> <input type="reset" class="buttonHighlight"
	name="Reset" id="reset" value="Reset"
	onclick="resetClicked('bloodReaction',);" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=currentDate%></label>

<label>Changed Time</label> <label class="value"><%=time%></label> <input
	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="clear"></div>
</div>
<!--Bottom labels starts-->
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">
			function checkBloodBag(obj){	
		<%		
		if(stockList != null && stockList.size() > 0){
				for (BloodStockDetail bloodStockDetail : stockList) {%>
								var invObj =<%= bloodStockDetail.getBloodBagNo()%>
								
								if(invObj != obj){
								alert("Blood Bag No. is not available");
 								document.getElementById('bloodBagNo').value=""
 							}
 		<%} } %>
 		}
 			function validateRequiredDate(formName){
		
		var nowDate= Date();
		
		obj1 = eval(document.getElementById("reactDate"+inc))
			
		if(obj1.value != "" )
		{
		
		 validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
			
			if(nowDate>validFromDate)
				{
				alert("Required Date should not be Past date\n");
				document.getElementById("reactDate"+inc).value=""
				return false;
				}
		
		}
		return true;
	}
 </script>