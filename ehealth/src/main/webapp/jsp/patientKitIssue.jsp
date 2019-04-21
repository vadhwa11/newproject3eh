
<%@page import="jkt.hms.masters.business.IpdKitIssueMasterTemplateM"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Properties"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URI"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%-- <%@page import="jkt.hms.masters.business.AllergyDetail"%> --%>
 <%@page import="jkt.hms.masters.business.IpdKitIssueMasterTemplateM"%> 
<%@page import="static jkt.hms.util.RequestConstants.*"%>


 <%@page import="jkt.hms.masters.business.IpdKitIssueHeader"%>
<%@page import="jkt.hms.masters.business.IpdKitIssueMasterTemplateT"%>
<%@page import="jkt.hms.masters.business.IpdKitIssueDetails"%> 
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>


<%-- <%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%> --%>

<script
	type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
	<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
	
<%
String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}
	 Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String currentTime = (String) utilMap.get("currentTime");
	String time = (String) utilMap.get("currentTime");
	
	Map<String, Object> map = new HashMap<String, Object>();

	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<Inpatient> inpatientList = new ArrayList<Inpatient>();
	if(map.get("inpatientList")!=null){
		inpatientList = (List<Inpatient>) map.get("inpatientList");
	}
	List<IpdKitIssueMasterTemplateM> templateList = new ArrayList<IpdKitIssueMasterTemplateM>();
	if(map.get("templateList")!=null){
		templateList = (List<IpdKitIssueMasterTemplateM>) map.get("templateList");
	}
	List<IpdKitIssueHeader> ipdKitIssueList = new ArrayList<IpdKitIssueHeader>();
	if(map.get("ipdKitIssueList")!=null){
		ipdKitIssueList = (List<IpdKitIssueHeader>) map.get("ipdKitIssueList");
	}
	IpdKitIssueHeader ipdKitIssueHeader = new IpdKitIssueHeader();
	if(ipdKitIssueList.size() > 0){
		ipdKitIssueHeader = ipdKitIssueList.get(0);
	}
	List<IpdKitIssueDetails> ipdKitIssueDetailList = new ArrayList<IpdKitIssueDetails>();
	if(map.get("ipdKitIssueDetailList")!=null){
		ipdKitIssueDetailList = (List<IpdKitIssueDetails>)map.get("ipdKitIssueDetailList");
	} 
	
	Inpatient inpatient = new Inpatient();
	Patient patient = new Patient();
	String patientName ="";
	String servPersonName ="";
	String consultantName = "";
	String currentAge = "";
	String gender="-";
	String pCategory="";
	String bloodGroup="";
	String materialStatus="";
	String admittedBy="-";
	
	if(inpatientList.size() > 0){
		inpatient = inpatientList.get(0);
		patient = inpatient.getHin();
		
		patientName=patient.getPFirstName()+" "+(patient.getPMiddleName()!=null?patient.getPMiddleName():"")+" "+(patient.getPLastName()!=null?patient.getPLastName():"");
		servPersonName =(patient.getSFirstName()!=null?patient.getSFirstName():"")+" "+(patient.getSMiddleName()!=null?patient.getSMiddleName():"")+" "+(patient.getSLastName()!=null?patient.getSLastName():"");
		consultantName=inpatient.getDoctor().getRank()!=null?inpatient.getDoctor().getRank().getRankName():""+" "+ inpatient.getDoctor().getFirstName()+" "+(inpatient.getDoctor().getMiddleName()!=null?inpatient.getDoctor().getMiddleName():"")+" "+(inpatient.getDoctor().getLastName()!=null?inpatient.getDoctor().getLastName():"");	
		
		if(inpatient.getDoctor()!=null)
		{
			admittedBy=inpatient.getDoctor().getFirstName();
			if(inpatient.getDoctor().getMiddleName()!=null)
			{
				admittedBy +=" "+inpatient.getDoctor().getMiddleName();
			}
			if(inpatient.getDoctor().getLastName()!=null)
			{
				admittedBy +=" "+inpatient.getDoctor().getLastName();
			}
		}
		String age = "";
		if(inpatient.getHin().getSex()!=null)
		{
			gender=inpatient.getHin().getSex().getAdministrativeSexName();
		}
		
		
		if(inpatient.getHin().getMaritalStatus()!=null)
		{
			materialStatus=inpatient.getHin().getMaritalStatus().getMaritalStatusName();
		}else
		{
			materialStatus="-";
		}
		
		if(inpatient.getHin().getBloodGroup()!=null){
			bloodGroup = inpatient.getHin().getBloodGroup().getBloodGroupName();
		}
		else
		{
			bloodGroup="-";
		}
		
		if(inpatient.getHin().getPatientType()!=null){
			pCategory = inpatient.getHin().getPatientType().getPatientTypeName();
		}
		else
		{
			pCategory="-";
		}
		
		

	    if(patient.getAge()!=null)
			age = patient.getAge();
		try{
			if(!age.equals(""))
			currentAge = HMSUtil.calculateAgeForADT(age,patient.getRegDate());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		session.setAttribute("inpatient",inpatient);
	} 

URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<form name="patientKitIssue" method="post">
	<div class="titleBg">
		<h2>Kit Issue</h2>
	</div>
<div class="block">
 <input type="hidden" name="hinNo" value="<%=patient.getHinNo()%>" validate="hinNo,metachar,no"/>
<input type="hidden" name="adNo" value="<%=inpatient.getAdNo()%>" validate="adNo,metachar,no"/>
<input type="hidden" name="serviceNo" value="<%=patient.getServiceNo()!=null?patient.getServiceNo():""%>" validate="serviceNo,metachar,no"/>
<input type="hidden" name=<%=HIN_ID %> value="<%=patient.getId()%>" validate="hinId,int,no"/>
<input type="hidden" name=<%=INPATIENT_ID %> value="<%=inpatient.getId()%>" validate="inpatientId,int,no"/>
	<h4>Patient Details</h4>
	<div class="Clear"></div>
	<%-- <div class="Block">

<label>A&D No.</label> <%if(inpatient.getAdNo() != null){ %>
<label class="value"><%=inpatient.getAdNo() %></label> <%}else{ %>
<label class="value">-</label>
<%} %>
<label>Service No.</label> 
<label class="value"> <%=patient.getServiceNo()!=null?patient.getServiceNo():"" %></label>

<label>Ward </label> <%if(inpatient.getDepartment() != null){ %>
<label class="value"> <%=inpatient.getDepartment().getDepartmentName() %></label>
<%}else{ %>
<label class="value">-</label>
<%} %>

<div class="Clear"></div>
<label>Patient Name</label>
<label	class="value"> <%= patientName %></label>

<label>Relation</label> <%
	if(patient.getRelation() != null){
	%> 
<label class="value"><%= patient.getRelation().getRelationName()%></label>
<%} else{ %> <label
	class="value">-</label> 
	<% }%> 

<label>Rank</label>
<label class="value"><%=patient.getRank()!=null?patient.getRank().getRankName():"" %></label>
<div class="Clear"></div>
<label>Name</label> <%
		String sMiddleName = "";
		String sLastName = "";
		if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){
		
			if(patient.getSMiddleName() != null){
				sMiddleName = patient.getSMiddleName();
			}
			if(patient.getSLastName() != null){
				sLastName = patient.getSLastName();
			}
	 %> 
<label class="value"><%= patient.getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}else{ %> 
<label class="value">-</label> 
<% }%>

<label>Branch/Trade</label>
<%
if(patient.getTrade() != null){
%> 
<label class="value"><%=  patient.getTrade().getTradeName()%></label>
<%} else{ %> 
<label class="value">-</label> 
<% }%>


<label>Unit</label> <%
if(patient.getUnit() != null){
%> <label class="value"><%= patient.getUnit().getUnitName()%></label>
<%} else{ %> 
<label class="value">-</label> 
<% }%>
<div class="Clear"></div>
<label>Age</label> <%if(!currentAge.equals("")){ %>
<label class="value"> <%=currentAge %></label> <%}else{ %>
<label	class="value">-</label> <%} %>
<label>Gender</label> <%if(patient.getSex() != null){ %>
<label class="value"> <%=patient.getSex().getAdministrativeSexName() %></label>
<%}else{ %>
<label class="value">-</label> <%} %>

<label>Med Cat</label>
<label class="value"><%=patient.getCategory()!=null?patient.getCategory().getCategories():"-" %></label>

<div class="Clear"></div>

<label>Admitting MO</label>
<label class="value"><%=consultantName %></label>

<label>Allergies</label>
<%
String allergies = "";
	if(patient.getDrugAllergies()!=null){
/*	for(AllergyDetail allergyDetail : patient.getAllergyDetails()){
		if(!allergies.equals("")){
			allergies += ",";
		}
		allergies += allergyDetail.getDescription();
	}*/
		allergies = patient.getDrugAllergies();
}%>
<%
	if(!allergies.equals("")){
%>
<label class="valueAuto"><%=allergies %></label>
<%}else{ %>
<label class="value"></label>
<%} %>
<div class="Clear"></div>

<label> Diagnosis</label> 
<%
		List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
		if(map.get("diagnosisList")!=null){
			diagnosisList = (List<DischargeIcdCode>)map.get("diagnosisList");
			
		}
		if(diagnosisList != null && diagnosisList.size() > 0 && diagnosisList.get(0).getIcd()!=null)
		{
		%> <label class="valueFixedWidth"><%=diagnosisList.get(0).getIcd().getIcdName() %></label>
<%
		}else{
		%> <label class="value"></label> <%	
		}
		%> 
<label>Disability</label>
<%
	List<MasMedicalExaminationDetail> disabilityList = new ArrayList<MasMedicalExaminationDetail>();
	if(map.get("disabilityList")!=null){
		disabilityList = (List<MasMedicalExaminationDetail>)map.get("disabilityList");
	}
	
	if(disabilityList != null && disabilityList.size() > 0)
	{
	%> <label class="valueFixedWidth"><%=disabilityList.get(0).getMasIcd()!=null?disabilityList.get(0).getMasIcd().getIcdName():"" %></label>
<%
	}else{
	%> <label class="value"></label> <%	
	}
%> 

<!--<label>Date</label>
<label class="value"><%=currentDate%></label>
<div class="Clear"></div>
<label>Time</label>
-->
<input type="hidden"	id="timeId" name="timeForAll" value="<%=time%>" class="calDate"	tabindex=1 onblur="fillTime(this.value)"
	onchange="IsValidTime(this.value,this.id);" /> <!--  <input type="button" class="button" value="Go" onClick="" />-->




<div class="Clear"></div>
</div> --%>
	
	<div class="clear"></div>
	
<%if(inpatient!=null){ %>
<%@include file="PatientDetails.jsp" %>
<%} %>
<div class="clear"></div>

<div class="clear"></div>
	<div class="Clear"></div>		
	<div class="Clear"></div>
	<h4>Kit Issue Details</h4>
	<div class="Clear"></div>
	<%-- <div class="Block">
		<label>Template <span>*</span></label>
		<%
	if(ipdKitIssueList.size() > 0){
%>
		<input type="text" name="template" readonly="readonly"
			value="<%= ipdKitIssueHeader.getTemplate()!=null? ipdKitIssueHeader.getTemplate().getTemplateName():""%>">
			<%}else{ %> <select name="kitIssueMasterId" id=""
			onchange="submitProtoAjax('patientKitIssue','/hms/hms/ipd?method=getTemplateDetails')"
			validate="Template,string,yes">


				<option value="0">Select</option>
				<%
	if(templateList.size() > 0){
		for(KitIssueMasterTemplateM kitIssueMasterTemplateM : templateList){

%>
				<option value="<%=kitIssueMasterTemplateM.getId() %>"><%=kitIssueMasterTemplateM.getTemplateName() %></option>

				<%}
		}%>

		</select> <%} %> <input type="button" name="createTemplate"
			value="Create Template" class="buttonBig"
			onclick="submitFormForButton('patientKitIssue','/hms/hms/inPatientMaster?method=showKitIssueJsp&flag=kitIssue')">
				<div class="clear"></div>
	</div> --%>

	<!-- <div class="clear"></div> -->
	<%-- <div id="testDiv">
		<%
	if(ipdKitIssueHeader!=null && ipdKitIssueHeader.getIpdKitIssueDetails() !=null){
%>
		<input type="hidden" name="ipdKitIssueHeaderId"
			value="<%= ipdKitIssueHeader.getId()%>" />
		<div id="pageNavPosition"></div>
		<div class="Clear"></div>

		<table border="0" cellpadding="0" cellspacing="0" id="grid"
			class="center">
			<tr>
				<th width="15%">Nomenclature</th>
				<th width="3%">Qty Issued</th>
				<th>Add</th>
				<th>Delete</th>
			</tr>
			<% int j=1;
		for(IpdKitIssueDetails ipdKitIssueDetails :ipdKitIssueHeader.getIpdKitIssueDetails() ){
	%>
			<tr>

				<td><input type="text"
					value="<%=ipdKitIssueDetails.getItemName() %>" tabindex="1"
					id="itemName<%=j %>" readonly="readonly" size="35"
					name="itemName<%=j %>"
					onblur="if(this.value!=''){checkForNomenclature(this.value,<%=j %>);}" />
					<input type="hidden" name="kitIssueDetailsId<%=j %>"
					value="<%=ipdKitIssueDetails.getId() %>" />

					<div id="ac2update1" style="display: none;" class="autocomplete"></div>
					<script type="text/javascript" language="javascript"
						charset="utf-8">
			
		//	  new Ajax.Autocompleter('nomenclature1','ac2update1','inPatientMaster?method=getItemListForAutoComplete',{parameters:'requiredField=nomenclature1'});
			</script></td>
				<td id="batchDiv1" style="display: none;"><input type="hidden"
					id="itemId<%=j %>" name="itemId<%=j %>" value=""></td>
				<td><input type="text"
					value="<%=ipdKitIssueDetails.getQuantity()!=null?ipdKitIssueDetails.getQuantity():"" %>"
					tabindex="1" readonly="readonly" id="issueQuantity<%=j %>"
					size="25" name="issueQuantity<%=j %>"></td>
				<td><input name="Button" type="button" class="buttonAdd"
					value="" onclick="addRow();" tabindex="1" /></td>
				<td><input type="button" name="delete" value=""
					class="buttonDel" onclick="removeRow('grid','hdb',this);"
					tabindex="1" disabled="disabled" /></td>
			</tr>
			<%j++;
			}%>
		</table>
		<input type="hidden" name="hdb" value="<%=j-1 %>" id="hdb" />


		<%} %>
	</div> --%>
	<div class="clear"></div>
<div class="Block">
<label> Kit Template <span>*</span></label>
<%
 if(ipdKitIssueList.size() > 0){
%>
		<input type="text" name="template" readonly="readonly" validate="Template,metachar,yes"
			value="<%= ipdKitIssueHeader.getTemplate()!=null? ipdKitIssueHeader.getTemplate().getTemplateName():""%>">
			<%}else{ %> <select name="kitIssueMasterId" id=""
			onchange="submitProtoAjax('patientKitIssue','/hms/hms/ipd?method=getTemplateDetails')"
			validate="Template,metachar,yes">


				<option value="0">Select</option>
				<%
	if(templateList.size() > 0){
		for(IpdKitIssueMasterTemplateM kitIssueMasterTemplateM : templateList){

%>
				<option value="<%=kitIssueMasterTemplateM.getId() %>"><%=kitIssueMasterTemplateM.getTemplateName() %></option>

				<%}
		}%>

		</select> <%} %>
<input type="button" name="createTemplate" validate="createTemplate,metachar,no"
			value="Create Template" class="buttonBig"
			onclick="submitFormForButton('patientKitIssue','/hms/hms/inPatientMaster?method=showKitIssueJsp&flag=kitIssue')">
				<div class="clear"></div>
</div>
	<div class="clear"></div>
	<div class="clear"></div>	
	<div style="float: right;">
	<input type="button" class="button" value="Add" align="right"
		onClick="javascript:addRow();" />
	<input type="button" name="Reset" value="Delete" class="button" align="right" onClick="javascript:removeRow();"
 />
		</div>
		<div class="clear"></div>		
	<div class="clear"></div>
	
 <div id="testDiv">
		<%
	if(ipdKitIssueHeader!=null && ipdKitIssueHeader.getIpdKitIssueDetails() !=null){
%>
		<input type="hidden" name="ipdKitIssueHeaderId" validate="ipdKitIssueHeaderId,int,no"
			value="<%= ipdKitIssueHeader.getId()%>" />
		<div id="pageNavPosition"></div>
		<div class="Clear"></div>
<div class="cmnTable">
		<table border="0" cellpadding="0" cellspacing="0" id="grid"
			class="center">
			<tr>
				<th scope="col">Sl No.</th>
<th scope="col">Item Name</th>
<th scope="col">Qty Issued</th>
<th scope="col">Select</th>
			</tr>
			<% int j=1;
		
			for(IpdKitIssueDetails ipdKitIssueDetails :ipdKitIssueHeader.getIpdKitIssueDetails()){
	%>
			<tr>
			<td><%=j%></td>
				<td><input type="text"
					value="<%=ipdKitIssueDetails.getItemName() %>" tabindex="1"
					id="nomenclature<%=j %>" readonly="readonly" size="100"
					name="nomenclature<%=j %>"  
					onblur="if(this.value!=''){checkForNomenclature(this.value,<%=j %>);}" />
					<input type="hidden" name="kitIssueDetailsId<%=j %>"
					value="<%=ipdKitIssueDetails.getId() %>" />

					<div id="ac2update1" style="display: none;" class="autocomplete"></div>
					<script type="text/javascript" language="javascript"
						charset="utf-8">
			
		//	  new Ajax.Autocompleter('nomenclature1','ac2update1','inPatientMaster?method=getItemListForAutoComplete',{parameters:'requiredField=nomenclature1'});
			</script></td>
				<td id="batchDiv1" style="display: none;"><input type="hidden"
					id="itemId<%=j %>" name="itemId<%=j %>" value=""></td>
				<td><input type="text"
					value="<%=ipdKitIssueDetails.getQuantity()!=null?ipdKitIssueDetails.getQuantity():"" %>"
					tabindex="1" readonly="readonly" id="issueQuantity<%=j %>"
					size="60" name="issueQuantity<%=j %>"></td>
				
			<td><input type="checkbox"  tabindex="1" id="kitDetailId<%=j %>" size="40"
			name="kitDetailId<%=j %>"></td>
				
			</tr>
			<%j++;
			}%>
		</table>
		</div>
		<input type="hidden" name="hdb" value="<%=j-1 %>" id="hdb" />


		<%}else
		{
			%>
			<div class="cmnTable">
			<table id="grid" class="cmntable">
	<tbody><tr>		

<th scope="col">Sl No.</th>
<th scope="col">Item Name</th>
<th scope="col">Qty Issued</th>
<th scope="col">Select</th>
	</tr>
	<tr>
		<td>1</td>
		<td><input type="text" value="" tabindex="1" id="nomenclature1" si
			size="100" name="nomenclature1"
			onblur="if(this.value!=''){checkForNomenclature(this.value,1);}" />
	    <input type="hidden" name="kitIssueDetailsId"  value="0"/>

		<div id="ac2update1" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature1','ac2update1','inPatientMaster?method=getItemListForKitIssueAutoComplete',{parameters:'requiredField=nomenclature1'});
		</script>
			
			</td>
			<td id="batchDiv1" style="display: none;">
		<input type="hidden" id="itemId1" name="itemId1" value="">
		</td>	
		<td>
		  <input type="text" value="" tabindex="1" id="issueQuantity1" size="40"
			name="issueQuantity1"></td>
		<td><input type="checkbox" name="kitDetailId1" id="kitDetailId1"></td>
		<%-- <td><input type="button" name="delete" value="" class="buttonDel"
			onclick="removeRow('grid','hdb',this);setIdForDelete('<%=kitIssueMasterTemplateT.getId() %>','');" tabindex="1" />
			</td> --%>
	</tr>
	
</tbody></table>
</div>
<input type="hidden" name="hdb" value="1" id="hdb" />
			<%
		}%>
	</div>

<!-- <div style="float: right;">
<label>Page</label>
<select class="small" name="templateId" id="templateId"  tabindex="1">
<option value="0">Select</option>
</select>
</div> -->
<div class="clear"></div>
	
	
<%-- 	<%
	if(ipdKitIssueList.size() > 0){
%>
	<input type="button" name="Submit1" value="Submit" class="button"
		tabindex="1"
		onclick="submitForm('patientKitIssue','/hms/hms/ipd?method=submitPatientKitIssue')" />
	<%}else{ %>
	<input type="button" name="Submit1" value="Submit" class="button"
		tabindex="1"
		onclick="submitForm('patientKitIssue','/hms/hms/ipd?method=submitPatientKitIssue')" />

	<%} %> --%>
	<input type="button" class="button" value="Submit" align="left"
		onClick="submitFormForButton('patientKitIssue','ipd?method=submitPatientKitIssue','validateGridRows','validateGridRowsQuantity');" />
	<input type="reset" name="Reset" value="Reset" class="button"
		accesskey="r" /> 
	<div class="clear"></div>
<div class="paddingTop40"></div>
</div>
	<div class="clear"></div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	
<script>


function addRow(){
	
	 
	  
	 var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;
	  
	  var cell1 = row.insertCell(0);
	  var e1 = document.createElement('label');
	   e1.innerHTML  =lastRow;
	  cell1.appendChild(e1); 
	  lastRow=lastRow+1;
	 
	  var cell2 = row.insertCell(1);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.size = '100';
	  e2.tabIndex="1";
	  e2.name='nomenclature'+iteration;
	  e2.id='nomenclature'+iteration;
	  e2.onblur=function(){if(this.value!=''){checkForNomenclature(this.value,iteration)}};
	  cell2.appendChild(e2);
	  var div = document.createElement('div');
	  div.id='ac2update'+iteration;
	  div.style.display=' none';
	  div.className='autocomplete';
	  cell2.appendChild(div);
	  var script = document.createElement( "script" );
	  script.type = "text/javascript";
	  script.charset = "utf-8";
	  script.innerHTML = "new Ajax.Autocompleter('nomenclature"+iteration+"','ac2update"+iteration+"','inPatientMaster?method=getItemListForKitIssueAutoComplete',{parameters:'requiredField=nomenclature"+iteration+"'})";
	  cell2.appendChild(script);
	  
	  var cell3 = row.insertCell(2);
	  cell3.id='batchDiv'+iteration;
	  cell3.style.display='none';
	  var e3 = document.createElement('input');
	  e3.type = 'hidden';
	  e3.size = '60';
	  e3.tabIndex="1";
	  e3.name='itemId'+iteration;
	  e3.id='itemId'+iteration
	  e3.setAttribute('tabindex','1');
	  cell3.appendChild(e3);
	  
	  var cell3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.size = '60';
	  e3.tabIndex="1";
	  e3.name='issueQuantity'+iteration;
	  e3.id='issueQuantity'+iteration
	  e3.setAttribute('tabindex','1');
	  cell3.appendChild(e3);
	  
	  var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.type = 'checkbox';
	  e4.checked = false;
	  e4.tabIndex="1";
	  e4.name='kitDetailId'+iteration;
	  e4.id='kitDetailId'+iteration
	  //e4.onblur=function(){getRadioId(this.value,iteration)}; 
	 // cell1.style.display = 'none';
	  cellRight4.appendChild(e4); 
}

function removeRow()
{
  var tbl = document.getElementById('grid');
  var lastRow = tbl.rows.length;
  var hdb = document.getElementById('hdb');
  var iteration = parseInt(hdb.value);
  var totalSelected=0;
  for(var i=1;i<=iteration;i++)
	  {
	  if(document.getElementById("kitDetailId"+i)!=null && (typeof  document.getElementById("kitDetailId"+i).checked)!='undefined' && document.getElementById("kitDetailId"+i).checked )
		  {
		  totalSelected=totalSelected+1;
		  }
	  }
      if(totalSelected==0)
	  {
	  alert('Please select atleast 1 row to delete');
	  }
      else  if(lastRow==2 || lastRow==(totalSelected+1))
	  {
    	  alert('You can not delete all Row.');
      }
      else if (lastRow > 2){
    	  for(var i=1;i<=iteration;i++)
    	  {
    	  if(document.getElementById("kitDetailId"+i)!=null && (typeof  document.getElementById("kitDetailId"+i).checked)!='undefined' && document.getElementById("kitDetailId"+i).checked )
    		  {
    		  var deleteRow= document.getElementById("kitDetailId"+i).parentNode.parentNode;
    		  document.getElementById("kitDetailId"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
    		  }
    	  }
    	  for(var i=1;i<document.getElementById('grid').rows.length;i++)
    		  {
    		  document.getElementById('grid').rows[i].cells[0].innerHTML=i;
    		  }
  }
}
function checkForNomenclature(val,inc)
{
    //alert('avl'+val+'inc'+inc);
	if(val != ""){
		var index1 = val.lastIndexOf("[");
		var index2 = val.lastIndexOf("]");
		index1++;
		var pvms = val.substring(index1,index2);

		if(pvms == "" ) {
	      	document.getElementById('nomenclature'+inc).value="";
	       	return;
		}

		for(i=1;i<inc;i++){
			if(inc != 1){
 				if(document.getElementById('nomenclature'+i).value==val) {
					alert("Nomenclature already selected...!")
					document.getElementById('nomenclature'+inc).value=""
					var e=eval(document.getElementById('nomenclature'+inc));
					e.focus();
					return false;
				}
			}
		}
		
	if(pvms!=""){
		submitProtoAjaxWithDivName('patientKitIssue','/hms/hms/ipd?method=getItemId&counter='+inc+'&pvmsNo='+pvms,'batchDiv'+inc);
	}
}
}

function validateGridRows(){
	var count = document.getElementById('hdb').value;
	var flag = "";
	if(count > 0){
		for(var i=1;i<=count;i++){
			if(document.getElementById('nomenclature'+i) && document.getElementById('nomenclature'+i).value != ''){
				flag = "filled";
				break;
			}
		}
		if(flag==''){
			alert("Please fill a row.");
			return false;
		}
	}
	return true;
 }
 
 function validateGridRowsQuantity()
 {
	 var count = document.getElementById('hdb').value;
		var flag = "";
		if(count > 0){
			for(var i=1;i<=count;i++){
				if(document.getElementById('nomenclature'+i) && document.getElementById('nomenclature'+i).value != ''){
					if(document.getElementById('issueQuantity'+i).value!='' && parseInt(document.getElementById('issueQuantity'+i).value)>=0)
						{
						flag = "filled";
						}
					else{
						flag = "";
						break;
					}
				}
			}
			if(flag==''){
				alert("Please fill a valid quantity.");
				return false;
			}
		}
		return true;
 }

</script>
