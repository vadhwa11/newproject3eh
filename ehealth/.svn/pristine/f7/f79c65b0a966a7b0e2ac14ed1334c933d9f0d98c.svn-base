<%@page import="jkt.hms.masters.business.BldCrossmatchBagDetail"%>
<%@page import="jkt.hms.masters.business.BloodIssueDetail"%>
<%@page import="jkt.hms.masters.business.BldCrossmatchDetail"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.BloodStockDetail"%>
<%@page import="jkt.hms.masters.business.BloodReactionEntry"%>

<script type="text/javascript" src="/hms/jsp/js/tabcontent.js">
	/***********************************************
	* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
	* This notice MUST stay intact for legal use
	* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
	***********************************************/
	</script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/animatedcollapse.js"></script>

<script type="text/javascript">
animatedcollapse.addDiv('title1', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title2', 'fade=0,speed=400,group=pets')
animatedcollapse.init()

</script>
<script>
	function changeClass(title,t)
	{
	animatedcollapse.toggle(title,t);
	}
	</script>
<script>
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
</script>

<%
	int pageNo=1;
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	StringTokenizer st = new StringTokenizer(time);
	String currentTime[] =time.split(":");
	String time1 =currentTime[0]+":"+currentTime[1];
	String userName="";
	int hospitalId=0;
	int BloodhdId=0;
	int bldIssueDeatialId=0;
	
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
		}
		if(map.get("detailsMap") != null){
		detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		if (session.getAttribute("userName") != null) {
			  userName = (String) session.getAttribute("userName");
		}
		
		/* List<Inpatient> inpatientList = new ArrayList<Inpatient>(); */
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		/* List<MasEmployee> employeeList = new ArrayList<MasEmployee>(); */
		List<BloodStockDetail> stockList = new ArrayList<BloodStockDetail>();
	
		List<BloodIssueDetail> bldIssueDetailList=new ArrayList<BloodIssueDetail>();
		BloodIssueDetail bldIssueDetail=new BloodIssueDetail();
		
		
		if(map.get("bldIssueDetailList") != null){
			bldIssueDetailList =(List<BloodIssueDetail>)map.get("bldIssueDetailList");
		}
		if(bldIssueDetailList != null && bldIssueDetailList.size()>0){
			bldIssueDetail = bldIssueDetailList.get(0);	
		}
		
	
		int hinId=0;
		int issuedById=0;
		String issuedByName="";
		if(bldIssueDetail.getIssueHeader()!=null){
			
			hinId = bldIssueDetail.getIssueHeader().getBloodRequestHd().getId();
			if(null !=bldIssueDetail.getIssueHeader().getIssuedBy()){
			issuedById=bldIssueDetail.getIssueHeader().getIssuedBy().getId();
			issuedByName=bldIssueDetail.getIssueHeader().getIssuedBy().getEmployeeName();}
		}
		int reactionId=0;
		if(map.get("reactionId") != null){
			reactionId =(Integer)map.get("reactionId");
		}
		/* if(map.get("inpatientList") != null){
			inpatientList= (List<Inpatient>)map.get("inpatientList");
		} */
		if(map.get("bloodGroupList") != null){
			bloodGroupList= (List<MasBloodGroup>)map.get("bloodGroupList");
		}
		/* if(map.get("employeeList") != null){
			employeeList= (List<MasEmployee>)map.get("employeeList");
		} */
		if(map.get("stockList") != null){
			stockList= (List<BloodStockDetail>)map.get("stockList");
		}
		if(map.get("bldIssueDeatialId") != null){
			bldIssueDeatialId= (Integer)map.get("bldIssueDeatialId");
		}
		
		
		List<BldCrossmatchDetail> bldCrossMatchDetailList=new ArrayList<BldCrossmatchDetail>();

		BldCrossmatchBagDetail bldCrossMatchBagDetail=new BldCrossmatchBagDetail();
		if(map.get("bldCrossMatchBagDetail") != null){
			bldCrossMatchBagDetail= (BldCrossmatchBagDetail)map.get("bldCrossMatchBagDetail");
		}
		
		String issuedBagNo="";
		String crossMatchBy="";
		int crossMatchById=0;
		int requestEdBloodBankId=0;
		
		System.out.println("");
		if(null !=bldCrossMatchBagDetail && null != bldCrossMatchBagDetail.getBldCrossmatchingHeader()){
			
			//requestEdBloodBankId=bldCrossMatchBagDetail.getBldCrossmatchingHeader().getBldRequestHospitalId().getId();
			requestEdBloodBankId=bldCrossMatchBagDetail.getBldCrossmatchingHeader().getBldRequest().getBloodBank().getId();
				issuedBagNo=bldCrossMatchBagDetail.getBagNo();
				if(null !=bldCrossMatchBagDetail.getBldCrossmatchingHeader()){
				crossMatchBy=bldCrossMatchBagDetail.getBldCrossmatchingHeader().getCrossMatchBy().getEmployee().getEmployeeName();
				crossMatchById=bldCrossMatchBagDetail.getBldCrossmatchingHeader().getCrossMatchBy().getEmployee().getId();
				}
		}
%>
<% 
if(map.get("msg") != null){
		 String  message = (String)map.get("msg");
%>
<h2>Transfusion Reaction Form </h2>
<h4><span><%=message %></span></h4>
	 <%}else{ %>
<!--main content placeholder starts here-->
<form name="bloodReaction" method="post" action="">
	<div class="titleBg">
		<h2>Transfusion Reaction Form </h2>
	</div>
	<div class="clear"></div>
	<h4>Patient Details</h4>
	<div class="clear"></div>
	<div class="Block">
		<div class="clear"></div>
		<%
		String entrySeqNo="";
		if(map.get("entrySeqNo") != null){
			entrySeqNo = (String)map.get("entrySeqNo");
		}
%>
	<input type="hidden" name="requestEdBloodBankId" value="<%=requestEdBloodBankId%>">
		<input type="hidden" name="bldIssueDeatialId" value="<%=bldIssueDeatialId%>">
		<label>UHID</label> 
		<label class="value"><%=bldIssueDetail.getIssueHeader().getBloodRequestHd().getHin().getHinNo()%></label>

		<label>Patient Name</label>
		<%
String name="";
if(bldIssueDetail.getIssueHeader().getBloodRequestHd().getHin().getPFirstName()!=null)
{
	name = bldIssueDetail.getIssueHeader().getBloodRequestHd().getHin().getPFirstName();
}

if(bldIssueDetail.getIssueHeader().getBloodRequestHd().getHin().getPMiddleName()!=null)
{
	name = name+" "+bldIssueDetail.getIssueHeader().getBloodRequestHd().getHin().getPMiddleName();
}
if(bldIssueDetail.getIssueHeader().getBloodRequestHd().getHin().getPLastName()!=null)
{
	name = name+" "+bldIssueDetail.getIssueHeader().getBloodRequestHd().getHin().getPLastName();
}
%>
		<label class="value"><%=name%></label> <label>Gender</label>
		<%if(bldIssueDetail.getIssueHeader().getBloodRequestHd().getHin().getSex() != null){ %>
		<label class="value"><%=bldIssueDetail.getIssueHeader().getBloodRequestHd().getHin().getSex().getAdministrativeSexName()%></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<div class="clear"></div>
		<label>IP No.</label>
		<%if(bldIssueDetail.getIssueHeader().getBloodRequestHd().getInpatient().getAdNo()!=null){%>
		<label class="value"><%=bldIssueDetail.getIssueHeader().getBloodRequestHd().getInpatient().getAdNo()%></label>
		<%}else{%>
		<label class="value">-</label>
		<%} %>
		<label>Blood Group</label>
		<%if(bldIssueDetail.getIssueHeader().getBloodRequestHd().getBloodGroup() != null){ %>
		<label class="value"><%=bldIssueDetail.getIssueHeader().getBloodRequestHd().getBloodGroup().getBloodGroupName()%></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<label>Mobile No.</label>
		<%if(bldIssueDetail.getIssueHeader().getBloodRequestHd().getHin().getMobileNumber()!=null && !"".equalsIgnoreCase(bldIssueDetail.getIssueHeader().getBloodRequestHd().getHin().getMobileNumber())){%>
		<label class="value"><%=bldIssueDetail.getIssueHeader().getBloodRequestHd().getHin().getMobileNumber()%></label>
		<%}else{%>
		<label class="value">-</label>
		<%} %>
		<div class="clear"></div>
		<label>Unit</label>
		<%if(bldIssueDetail.getIssueHeader().getBloodRequestHd().getNoBottles()!=null && !"".equalsIgnoreCase(bldIssueDetail.getIssueHeader().getBloodRequestHd().getNoBottles())){%>
		<label class="value"><%=bldIssueDetail.getIssueHeader().getBloodRequestHd().getNoBottles()%></label>
		<%}else{%>
		<label class="value">-</label>
		<%} %>
		<label>Ward</label>
		<%if(bldIssueDetail.getIssueHeader().getBloodRequestHd().getDepartment() != null){ %>
		<label class="value"><%=bldIssueDetail.getIssueHeader().getBloodRequestHd().getDepartment().getDepartmentName()%></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<label>Bed No.</label>
		
		 <%if(bldIssueDetail.getIssueHeader().getBloodRequestHd().getInpatient().getBed()!=null && !"".equalsIgnoreCase(bldIssueDetail.getIssueHeader().getBloodRequestHd().getInpatient().getBed().getBedNo())){%>
		<label class="value"><%=bldIssueDetail.getIssueHeader().getBloodRequestHd().getInpatient().getBed().getBedNo()%></label>
		<%}else{%>
		<label class="value">-</label>
		<%} %> 
		
		<div class="clear"></div>
		<label>Age</label>
		<%if(bldIssueDetail.getIssueHeader().getBloodRequestHd().getHin().getAge() !=null){ %>
		<label class="value"><%=bldIssueDetail.getIssueHeader().getBloodRequestHd().getHin().getAge()%></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<label>Doctor Name</label>
		<%
			String dFName="";
			String dMName="";
			String dLName="";
			if(bldIssueDetail.getIssueHeader().getBloodRequestHd().getInpatient().getDoctor() != null) { 
			if(bldIssueDetail.getIssueHeader().getBloodRequestHd().getInpatient().getDoctor().getFirstName()!=null&&!"".equalsIgnoreCase(bldIssueDetail.getIssueHeader().getBloodRequestHd().getInpatient().getDoctor().getFirstName().trim())){
				dFName=bldIssueDetail.getIssueHeader().getBloodRequestHd().getInpatient().getDoctor().getFirstName();
			}if(bldIssueDetail.getIssueHeader().getBloodRequestHd().getInpatient().getDoctor().getLastName()!=null&&!"".equalsIgnoreCase(bldIssueDetail.getIssueHeader().getBloodRequestHd().getInpatient().getDoctor().getLastName().trim())){
				dLName=bldIssueDetail.getIssueHeader().getBloodRequestHd().getInpatient().getDoctor().getLastName();
			}if(bldIssueDetail.getIssueHeader().getBloodRequestHd().getInpatient().getDoctor().getMiddleName()!=null&&!"".equalsIgnoreCase(bldIssueDetail.getIssueHeader().getBloodRequestHd().getInpatient().getDoctor().getMiddleName().trim())){
				dMName=bldIssueDetail.getIssueHeader().getBloodRequestHd().getInpatient().getDoctor().getMiddleName();
			} 
		%>
		<label class="value"><%=dFName+" "+dMName+" "+dLName%></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<input type="hidden" name="<%=INPATIENT_ID %>"
			value="<%=bldIssueDetail.getIssueHeader().getBloodRequestHd().getInpatient().getId()%>" /> <input type="hidden"
			name="<%=DEPARTMENT_ID %>"
			value="<%=bldIssueDetail.getIssueHeader().getBloodRequestHd().getInpatient().getDepartment().getId() %>" /> <input
			type="hidden" name="<%=HIN_ID %>"
			value="<%=bldIssueDetail.getIssueHeader().getBloodRequestHd().getHin().getId() %>" />
		
		<label>Entry No.</label> <label class="value"><%=entrySeqNo %></label>
		<input id="entryNoId" type=hidden name="<%=ENTRY_NO %>"
			value="<%=entrySeqNo %>" title="Entry Number" />
		<div class="clear"></div>
		<label>Reaction Date</label> <label class="value"><%=currentDate %></label>
		<input type="hidden" name="<%=REACTION_DATE %>"
			value="<%=currentDate%>" />


		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<a href="javascript:changeClass('title1','t1')"><h5 id='t1'
			class="minus">Details</h5></a>

	<div class="clear"></div>
	<div class="Block" id="title1">
		<div class="clear"></div>
		<label> <span>*</span> Blood Bag No.
		</label> <input id="bloodBagNo" name="<%=BLOOD_BAG_NO %>" type="text" value="<%=issuedBagNo %>" readonly="readonly"
			onblur="ajaxFunctionForBagNoReaction(bloodReaction);" /> <label>
			<span>*</span> Issue Date
		</label> <input type="text" class="date" id="fromDateId" 
			name="<%=ISSUED_DATE %>" value="<%=HMSUtil.convertDateToStringWithoutTime(bldIssueDetail.getIssueHeader().getIssueDate())  %>" readonly="readonly" MAXLENGTH="30"
			validate="Issue Date,date,yes"  /> 
		<label> Issued By
		</label> <select id="issuedBy" name=<%=ISSUED_BY %>
			validate="Issued By,string,no">
			<option value="<%=issuedById %>"><%=issuedByName %>
			</option>
		</select>
		<div class="clear"></div>
		
		<label> <span>*</span> Cross Matched By
		</label> <select id="matchedId" name=<%=CROSS_MATCHED_BY %>
			validate="Cross Matched By,string,yes">
			<option value="<%=crossMatchById %>"><%=crossMatchBy %></option>
		</select>

		<div class="clear"></div>
		<div class="clear"></div>
	</div>
	<div id="reactionDetailtable">
		<div class="clear"></div>
		<%-- <label class="auto"><span>*</span>Temperature of patient
			Before Transfusion</label> <input id="tempTransfussion"
			name="<%=TEMP_TRANSFUSSION %>" value="" type="text" maxlength="25"
			validate="Temperature of patient Before Transfusion,string,yes" /> --%> <label>Date
			of Transfusion</label> <input type="text" class="date" id="fromDateId"
			name="<%=TRANSFUSSION_DATE %>" value="" readonly="readonly"
			MAXLENGTH="30" vvalidate="Date of Transfusion,date,yes" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate %>',document.bloodReaction.<%=TRANSFUSSION_DATE%>,event)" />

		<div class="clear"></div>
		<label> <span>*</span> Time Started
		</label> <input  id="startedTime" name="<%=STARTED_TIME %>"
			type="text" value="" onKeyUp="mask(this.value,this,'2',':');"
			validate="Time Started,time,no" maxlength="5"
			onBlur="IsValidTime(this.value,this.id);" /> <label >hrs</label>

		<label>Time Completed</label> <input  id="completedTime"
			name="<%=COMPLETED_TIME %>" type="text" value=""
			onKeyUp="mask(this.value,this,'2',':');"
			validate="Time Completed,time,no" maxlength="5"
			onBlur="IsValidTime(this.value,this.id);" /> <label >hrs</label>
		<div class="clear"></div>
		<div class="clear"></div>
		<h4>Before Transfusion</h4>
	<label><span>*</span>Temperature</label> 
	<input name="BeforeTemperature"
		value="" type="text" maxlength="25" validate="Temperature,float,yes" />
		
		<label><span>*</span>Pulse</label>
	<input name="BeforePulse" value="" type="text" maxlength="25"
		validate="Pulse,int,yes" />
		<div class="clear"></div>
		 <label><span>*</span>BP</label> <input
		name="BeforePulseMax" value="" placeholder="Systolic" type="text" maxlength="3"
		validate="BP Systolic,int,yes" /> <input name="BeforePulseMin"
		value="" type="text" maxlength="3" placeholder="Diatolic" validate="BP Diatolic,int,yes" />
		<div class="clear"></div>
		<h4>During Transfusion</h4>
	<label><span>*</span>Temperature</label> <input name="DuringTemperature"
		value="" type="text" maxlength="25" validate="Temperature,float,yes" />
		
		<label><span>*</span>Pulse</label>
	<input name="DuringPulse" value="" type="text" maxlength="25"
		validate="Pulse,int,yes" />
		<div class="clear"></div>
		 <label><span>*</span>BP</label> <input
		name="DuringPulseMax" value="" placeholder="Systolic" type="text" maxlength="3"
		validate="BP Systolic,int,yes" /> <input name="DuringPulseMin"
		value="" type="text" maxlength="3" placeholder="Diatolic" validate="BP Diatolic,int,yes" />
		
		<div class="clear"></div>
		<h4>After Transfusion</h4>
	<label><span>*</span>Temperature</label> <input name="AfterTemperature"
		value="" type="text" maxlength="25" validate="Temperature,float,yes" />
		
		<label><span>*</span>Pulse</label>
	<input name="AfterPulse" value="" type="text" maxlength="25"
		validate="Pulse,int,yes" /> 
		<div class="clear"></div>
		
		<label><span>*</span>BP</label> <input
		name="AfterPulseMax" value="" placeholder="Systolic" type="text" maxlength="3"
		validate="BP Systolic,int,yes" /> <input name="AfterPulseMin"
		value="" type="text" maxlength="3" placeholder="Diatolic" validate="BP Diatolic,int,yes" />
		
		<div class="clear"></div>
		<h4>Other signs and symptoms :</h4>
		<label>(a) Chills</label>
		 <label class="autoSize">
		 <input type="radio"  class="radioCheckCol2" name="Chills" value="y" tabindex=1 validate="assessmentName,string,no" />Yes</label>
		<label class="autoSize">
		<input type="radio" class="radioCheckCol2" checked="checked" name="Chills" value="n" tabindex=1 validate="assessmentName,string,no">No</label>
		<div class="clear"></div>
		
		<label>(b) Rigor</label>
		 <label class="autoSize">
		 <input type="radio"  class="radioCheckCol2" name="Rigor" value="y" tabindex=1 validate="assessmentName,string,no" />Yes</label>
		<label class="autoSize">
		<input type="radio" class="radioCheckCol2" checked="checked" name="Rigor" value="n" tabindex=1 validate="assessmentName,string,no">No</label>
		<div class="clear"></div>
		
		<label>(c) Rash/Itching</label>
		 <label class="autoSize">
		 <input type="radio"  class="radioCheckCol2" name="Rash" value="y" tabindex=1 validate="assessmentName,string,no" />Yes</label>
		<label class="autoSize">
		<input type="radio" class="radioCheckCol2" checked="checked" name="Rash" value="n" tabindex=1 validate="assessmentName,string,no">No</label>
		<div class="clear"></div>
		
		<label>(d) Pain:- Back</label>
		 <label class="autoSize">
		 <input type="radio"  class="radioCheckCol2" name="Back" value="y" tabindex=1 validate="assessmentName,string,no" />Yes</label>
		<label class="autoSize">
		<input type="radio" class="radioCheckCol2" checked="checked" name="Back" value="n" tabindex=1 validate="assessmentName,string,no">No</label>
		<div class="clear"></div>
		
		<label>Head</label>
		<label class="autoSize">
		 <input type="radio"  class="radioCheckCol2" name="Head" value="y" tabindex=1 validate="assessmentName,string,no" />Yes</label>
		<label class="autoSize">
		<input type="radio" class="radioCheckCol2" checked="checked" name="Head" value="n" tabindex=1 validate="assessmentName,string,no">No</label>
		<div class="clear"></div>
		
		<label>Chest</label>
		<label class="autoSize">
		 <input type="radio"  class="radioCheckCol2" name="Chest" value="y" tabindex=1 validate="assessmentName,string,no" />Yes</label>
		<label class="autoSize">
		<input type="radio" class="radioCheckCol2" checked="checked" name="Chest" value="n" tabindex=1 validate="assessmentName,string,no">No</label>
		<div class="clear"></div>
		
		<label>Elsewhere</label>
		<label class="autoSize">
		 <input type="radio"  class="radioCheckCol2" name="Elsewhere" value="y" tabindex=1 validate="assessmentName,string,no" />Yes</label>
		<label class="autoSize">
		<input type="radio" class="radioCheckCol2" checked="checked" name="Elsewhere" value="n" tabindex=1 validate="assessmentName,string,no">No</label>
		<div class="clear"></div>
		
		
		<label>(e) Haemoglobinuana</label>
		 <label class="autoSize">
		 <input type="radio"  class="radioCheckCol2" name="Haemoglobinuana" value="y" tabindex=1 validate="assessmentName,string,no" />Yes</label>
		<label class="autoSize">
		<input type="radio" class="radioCheckCol2" checked="checked" name="Haemoglobinuana" value="n" tabindex=1 validate="assessmentName,string,no">No</label>
		<div class="clear"></div>
		
		<label>(f) Pulmonary oedema</label>
		 <label class="autoSize">
		 <input type="radio"  class="radioCheckCol2" name="Pulmonary" value="y" tabindex=1 validate="assessmentName,string,no" />Yes</label>
		<label class="autoSize">
		<input type="radio" class="radioCheckCol2" checked="checked" name="Pulmonary" value="n" tabindex=1 validate="assessmentName,string,no">No</label>
		<div class="clear"></div>
		
		<label>(g) Jaundice</label>
		 <label class="autoSize">
		 <input type="radio"  class="radioCheckCol2" name="Jaundice" value="y" tabindex=1 validate="assessmentName,string,no" />Yes</label>
		<label class="autoSize">
		<input type="radio" class="radioCheckCol2" checked="checked" name="Jaundice" value="n" tabindex=1 validate="assessmentName,string,no">No</label>
		<div class="clear"></div>
		
		<label>(h) Any Other signs</label>
		 <label class="autoSize">
		 <input type="radio"  class="radioCheckCol2" name="AnyOther" value="y" tabindex=1 validate="assessmentName,string,no" />Yes</label>
		<label class="autoSize">
		<input type="radio" class="radioCheckCol2" checked="checked" name="AnyOther" value="n" tabindex=1 validate="assessmentName,string,no">No</label>
		<div class="clear"></div>
		
		
		<h4>Reaction</h4>
		<input type="button" tabindex="1" onclick="addRow('reactionTable');"
			class="buttonAdd" value="" name="add" style="float: right;"><input
			type="button" onclick="removeRow('reactionTable');" class="buttonDel"
			value="" name="delete" style="float: right;">
				<div class="clear"></div>
				<table width="100%" cellspacing="0" cellpadding="0" border="0"
					id="reactionTable">
					<tbody>
						<tr>
							<th scope="col"></th>
							<th scope="col">Sr No.</th>
							<th scope="col">Reaction</th>
						</tr>
						<%
										int sn = 1;
									%>
						<tr>
							<td><input type="checkbox" class="radioCheck"
								name="selectedReaction" value="<%=sn%>"></td>
							<td><%=sn%>
								<td><input type="text" style="width: 600px" name="reaction"
									id="reactionId<%=sn%>" tabindex="1" maxlength="128"
									validate="Reaction,string,yes"></td>
						</tr>

						<input type="hidden" id="dgOrderhdId" name="dgOrderhdId" value="0">
					</tbody>
				</table> <input type="hidden" id="hiddenValueReaction"
				name="hiddenValueReaction" value="<%=sn%>">
	</div>

	<div class="clear"></div>
	
	
	
	<label>Feedback </label>
	<textarea name="vitalRemark" value=""  maxlength="25"></textarea>
	
	<label>Return to blood bank</label>
	<input name="returnToBloodBank" type="checkbox" value="y" >
	<div class="clear"></div>
	<%-- <div class="Block" id="title2">
		<div class="clear"></div> 
		<div class="clear"></div>

		<h2>Reaction Noticed</h2>

		<div class="clear"></div>
		<div class="Height10"></div>
		<div class="paddLeft25">
			<label class="large">Pyrexia -Rise in temperature to 100 0F,
				but no subjective symptoms :</label>
		</div>
		<label>Yes</label> <input name="<%=PYREXIA %>" type="radio"
			class="radioCheck" value="y" /> <label>No</label> <input
			name="<%=PYREXIA %>" type="radio" class="radioCheck" value="n" />

		<div class="clear"></div>

		<div class="paddLeft25">
			<label class="large">Rise in temperature to 100 0F, or above,
				feeling cold but no rigor :</label>
		</div>

		<label>Yes</label> <input name="<%=RISE_TEMP %>" type="radio"
			class="radioCheck" value="y" /> <label>No</label> <input
			name="<%=RISE_TEMP %>" type="radio" class="radioCheck" value="n" />

		<div class="clear"></div>

		<div class="paddLeft25">
			<label class="large">Rigor :</label>
		</div>
		<label>Yes</label> <input name="<%=RIGOR %>" type="radio"
			class="radioCheck" value="y" /> <label>No</label> <input
			name="<%=RIGOR %>" type="radio" class="radioCheck" value="n" />

		<div class="clear"></div>

		<div class="paddLeft25">
			<label class="large">Fall of BP :Systolic
				............................ Diastolic........................... </label>
		</div>
		<label>Yes</label> <input name="<%=FALL_BP %>" type="radio"
			class="radioCheck" value="y" /> <label>No</label> <input
			name="<%=FALL_BP %>" type="radio" class="radioCheck" value="n" />

		<div class="clear"></div>

		<div class="paddLeft25">
			<label class="large">Allergic Reaction- Itching : </label>
		</div>
		<label>Yes</label> <input name="<%=ITCHING %>" type="radio"
			class="radioCheck" value="y" /> <label>No</label> <input
			name="<%=ITCHING %>" type="radio" class="radioCheck" value="n" />

		<div class="clear"></div>

		<div class="paddLeft25">
			<label class="large">Urticarla : </label>
		</div>
		<label>Yes</label> <input name="<%=URTICARLA %>" type="radio"
			class="radioCheck" value="y" /> <label>No</label> <input
			name="<%=URTICARLA %>" type="radio" class="radioCheck" value="n" />

		<div class="clear"></div>

		<div class="paddLeft25">
			<label class="large">Anaphylaxis :</label>
		</div>
		<label>Yes</label> <input name="<%=ANAPHYLAXIA %>" type="radio"
			class="radioCheck" value="y" /> <label>No</label> <input
			name="<%=ANAPHYLAXIA %>" type="radio" class="radioCheck" value="n" />

		<div class="clear"></div>

		<div class="paddLeft25">
			<label class="large">Pain- Back : </label>
		</div>
		<label>Yes</label> <input name="<%=PAIN_BACK %>" type="radio"
			class="radioCheck" value="y" /> <label>No</label> <input
			name="<%=PAIN_BACK %>" type="radio" class="radioCheck" value="n" />
		<div class="clear"></div>

		<div class="paddLeft25">
			<label class="large">Head : </label>
		</div>
		<label>Yes</label> <input name="<%=HEAD %>" type="radio"
			class="radioCheck" value="y" /> <label>No</label> <input
			name="<%=HEAD %>" type="radio" class="radioCheck" value="n" />

		<div class="clear"></div>

		<div class="paddLeft25">
			<label class="large">Chest :</label>
		</div>
		<label>Yes</label> <input name="<%=CHEST %>" type="radio"
			class="radioCheck" value="y" /> <label>No</label> <input
			name="<%=CHEST %>" type="radio" class="radioCheck" value="n" />

		<div class="clear"></div>

		<div class="paddLeft25">
			<label class="large">Elsewhere :</label>
		</div>
		<label>Yes</label> <input name="<%=ELSE_WHERE %>" type="radio"
			class="radioCheck" value="y" /> <label>No</label> <input
			name="<%=ELSE_WHERE %>" type="radio" class="radioCheck" value="n" />

		<div class="clear"></div>

		<div class="paddLeft25">
			<label class="large">Jaundice :</label>
		</div>
		<label>Yes</label> <input name="<%=JAUNDICE %>" type="radio"
			class="radioCheck" value="y" /> <label>No</label> <input
			name="<%=JAUNDICE %>" type="radio" class="radioCheck" value="n" />

		<div class="clear"></div>

		<div class="paddLeft25">
			<label class="large">Haemoglobinuria:</label>
		</div>
		<label>Yes</label> <input name="<%=HEMOGLOBIN %>" type="radio"
			class="radioCheck" value="y" /> <label>No</label> <input
			name="<%=HEMOGLOBIN %>" type="radio" class="radioCheck" value="n" />

		<div class="clear"></div>

		<div class="paddLeft25">
			<label class="large">Anuria :</label>
		</div>
		<label>Yes</label> <input name="<%=ANURIA %>" type="radio"
			class="radioCheck" value="y" /> <label>No</label> <input
			name="<%=ANURIA %>" type="radio" class="radioCheck" value="n" />

		<div class="clear"></div>

		<div class="paddLeft25">
			<label class="large">Anyother untoward reactions :</label>
		</div>
		<input id="untoWardReaction" name="<%=UNTOWARD_REACTION %>" value=""
			type="text" validate="untoward reactions,string,no" maxlength="25" />
		<div class="clear"></div>
	</div> --%>

	<!--Bottom labels starts-->
	<div class="clear"></div>
	<div class="division"></div>
	<input type="button" class="button" value="Submit"
		onclick="submitForm('bloodReaction','bloodBank?method=submitBloodReactionEntry');"
		align="right" /> <input type="reset" class="buttonHighlight"
		name="Reset" id="reset" value="Reset"
		onclick="resetClicked('bloodReaction');" accesskey="r" />
	<div class="clear"></div>
	<div class="division"></div>
	<div class="bottom">
		<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
			Date</label> <label class="value"><%=currentDate%></label> <label>Changed
			Time</label> <label class="value"><%=time%></label>
		<div class="clear"></div>
	</div>
	<!--Bottom labels ends-->
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="paddingTop40"></div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<!--Bottom labels starts-->
<!--main content placeholder ends here-->
<%}  %>

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
 </script>
<script type="text/javascript"> 
	function removeRow(id)
	{ 
		var tbl = document.getElementById(id);
		 var tblRows  = tbl.getElementsByTagName("tr");

	  	if(tblRows.length-2==0){
	         	alert("Can not delete all rows")
	         	return false;
	     }

		for(counter=0;counter<document.getElementsByName('selectedReaction').length;counter++)
		{
			if (document.getElementsByName('selectedReaction')[counter].checked == true)
			{
			  	tbl.deleteRow(counter+1);
			  	totalCost();
			}
		}
	}
	function addRow(id){ 
		var tbl = document.getElementById(id);
		var lastRow = tbl.rows.length; 
		var row = tbl.insertRow(lastRow);
		var hdb = document.getElementById('hiddenValueReaction'); 
		var iteration = parseInt(hdb.value)+1;
		hdb.value = iteration; 
		var cell0 = row.insertCell(0);
		var e0 = document.createElement('input');
		e0.type = 'checkbox';
		e0.name='selectedReaction';
	 	e0.className = 'radioCheck';
		e0.value=(iteration);
		cell0.appendChild(e0);

		var cell1 = row.insertCell(1); 
		cell1.textContent=iteration;  
		
		var cell2 = row.insertCell(2);
		var e2 = document.createElement('input');
		e2.type = 'text';  
		e2.name='reaction';
		e2.id = 'reactionId'+(iteration);
		e2.tabIndex="1";
		e2.maxLength="128"; 
		cell2.appendChild(e2);  
		document.getElementById('hiddenValueReaction').value=iteration;
	}	   
</script>