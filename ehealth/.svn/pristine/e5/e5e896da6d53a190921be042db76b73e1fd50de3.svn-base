<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * state.jsp  
 * Purpose of the JSP -  This is showing State.
 * @author  Dipali
 * @author  Vishal
 * Create Date: 07th April,2009
 * Revision Date:      
 * Revision By:  
 * @version 1.14
--%>



<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.MasOccupation"%>
<%@page import="jkt.hms.masters.business.MasReligion"%>
<%@page import="jkt.hrms.masters.business.MasQualification"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.MasSpecialtyTemplate"%>
<%@page import="jkt.hms.masters.business.MasSpecialityDeptGroup"%>
<%@page import="jkt.hms.masters.business.MasSpecialityDeptGroupValue"%>
<%@page import="jkt.hms.masters.business.SpDeptGroupT"%>
<%@page import="jkt.hms.masters.business.SpDeptGroupM"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<%@page import="jkt.hms.masters.business.MasSpecialtyGroupParameter"%>
<%@page import="jkt.hms.masters.business.MasSpecialityParameter"%>
<%@page import="jkt.hms.masters.business.MasSpecialityGroup"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasSpecialityGroup"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>
<script language="javascript" type="text/javascript" src="/hms/jsp/js/ajax.js"></script>
<script src="/hms/jsp/js/snomedLink.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<script language="javascript" type="text/javascript" src="/hms/jsp/js/calendar.js"></script>

<script type="text/javascript" language="javascript">
	<%
	
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String getDate=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(getDate.length()<2){
	getDate="0"+getDate;
	}

	%>
	serverdate = '<%=getDate+"/"+month+"/"+year%>';
	</script>


<%
	    Map map=new HashMap();	
          Map<String,Object> utilMap = new HashMap<String,Object>();
        List<MasSpecialityDeptGroup> masForGorupParameter=new ArrayList<MasSpecialityDeptGroup>();
		List<MasSpecialtyGroupParameter> groupParameterList=new ArrayList<MasSpecialtyGroupParameter>();
		List<MasSpecialityDeptGroupValue> masValue=new ArrayList<MasSpecialityDeptGroupValue>();
		List<MasMaritalStatus>maritalStatusList = new ArrayList<MasMaritalStatus>();
		List<MasQualification>educationList = new ArrayList<MasQualification>();
		List<MasReligion>religionList = new ArrayList<MasReligion>();
		List<MasOccupation>occupationList = new ArrayList<MasOccupation>();
		List<MasSpecialityDeptGroup> deptGorupParameterGridList=new ArrayList<MasSpecialityDeptGroup>();
		List<Object[]> groupList=new ArrayList<Object[]>();
		List<Object[]> headingList=new ArrayList<Object[]>();
		List<MasSpecialityDeptGroupValue> masValueForGrid=new ArrayList<MasSpecialityDeptGroupValue>();
		List<DgResultEntryHeader>labResultForLeprosyPerformaList = new ArrayList<DgResultEntryHeader>();
		List<Patient> patientList=new ArrayList<Patient>();
		
		String userName = "";
		String  departName= "";
		String checkBox="";
	    String valueName="";	
	    
		  if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		        }
		 if(map.get("masForGorupParameter") != null){
			 masForGorupParameter = (List<MasSpecialityDeptGroup>)map.get("masForGorupParameter");
			      } 
         if(map.get("masValue") != null){
            masValue = (List<MasSpecialityDeptGroupValue>)map.get("masValue");
		 }
         if(map.get("labResultForLeprosyPerforma") != null){
         	labResultForLeprosyPerformaList = (List<DgResultEntryHeader>)map.get("labResultForLeprosyPerforma");
 	 	 }
         
         if(map.get("masValueForGrid") != null){
        	 masValueForGrid = (List<MasSpecialityDeptGroupValue>)map.get("masValueForGrid");
 		 }
           if(map.get("groupParameterList") != null){
      		 groupParameterList = (List<MasSpecialtyGroupParameter>)map.get("groupParameterList");
			} 
        if(map.get("maritalStatusList") != null){
        	maritalStatusList = (List<MasMaritalStatus>)map.get("maritalStatusList");
	 	 } 
       
        if(map.get("educationList") != null){
        	educationList = (List<MasQualification>)map.get("educationList");
	 	 } 
        if(map.get("religionList") != null){
        	religionList = (List<MasReligion>)map.get("religionList");
	 	 } 
        if(map.get("occupationList") != null){
        	occupationList = (List<MasOccupation>)map.get("occupationList");
	 	 } 
        if(map.get("deptGorupParameterGridList") != null){
        	deptGorupParameterGridList = (List<MasSpecialityDeptGroup>)map.get("deptGorupParameterGridList");
	 	 } 
        if(map.get("groupList") != null){
        	groupList = (List<Object[]>)map.get("groupList");
	 	 } 
        if(map.get("headingList") != null){
        	headingList = (List<Object[]>)map.get("headingList");
	 	 } 
        if(map.get("patientList") != null){
        	patientList = (List<Patient>)map.get("patientList");
	 	 } 
       
             if(map.get("valueName") != null){
            	 valueName = (String)map.get("valueName");
     	
     			} 
             
             if(map.get("checkBox") != null){
            	 checkBox = (String)map.get("checkBox");
     	
     			} 
         
         int templateId = 0;
         if(map.get("template")!=null){
        	 templateId = (Integer)map.get("template");
         }
         String tempLateName = "";
         if(map.get("tempLateName")!=null){
        	 tempLateName = (String)map.get("tempLateName");
         }
         int hinId = 0;
         if(map.get("hinId")!=null){
        	 hinId = (Integer)map.get("hinId");
         }
         int visitId = 0;
         if(map.get("visitId")!=null){
        	 visitId = (Integer)map.get("visitId");
         }
         
	   
	String date ="";
	String time ="";
	try{
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	}catch(Exception ex){
		ex.printStackTrace();
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	String message="";
	if(map.get("message") != null){
		  message = (String)map.get("message");
	}
	
		   %>
<div class="clear"></div>
<input type="hidden" name="specialty" value="<%=templateId%>"/>
<input type="hidden" name="templateName" value="<%=tempLateName%>"/>

<h2><%=tempLateName %></h2>

<script>jQuery.noConflict();
jQuery(function($) {
	

    function split( val ) {
        return val.split( /,\s*/ );
    }
    function extractLast( term ) {
        return split( term ).pop();
    }
    
  
	$( ".historyAutoComplete" )
    .autocomplete({
	    minLength: 1,
		source: function( request, response ) {
            // delegate back to autocomplete, but extract the last term
			var arTerm=request.term.split(",");
			var searchTerm=arTerm[arTerm.length-1].trim();
			console.log("terms :: "+searchTerm);
			servURL = enumSERVICES.SEARCH.searchbyacceptability_url;
			var refsetidParam = document.getElementById('refsetId').value;
			servURL +="?term="+searchTerm+"&state=active&semantictag=all&acceptability=all&returnlimit=10&refsetid="+refsetidParam;
            $.getJSON(servURL,
            		function (data)
			{ 
            	var array = data.error ? [] : $.map(data, function(m) {
					return {
						label: m.term ,
						 value:  m.conceptId 
					};
				});
				response(array);
			
            });
        },
        focus: function() {
            // prevent value inserted on focus
            return false;
        },
        select: function( event, ui ) {
            var terms = split( this.value );
         	// remove the current input
            terms.pop();
          
            terms.push( ui.item.label );
            // add placeholder to get the comma-and-space at the end
            terms.push( "" );
            var snomedCount =   $('#snomedCount').val();
            snomedCount = parseInt(snomedCount)+1;
            $('#snomedCount').val(snomedCount) ;
           
            var fieldType = $(this).prev().text().replace(/\s+/g," ");
       		if(fieldType == 'GIS'){
       			fieldType = 'Systemic Examination';
       		}
           $('#termTable').append("<input type='text' name ='snomedId"+snomedCount+"' value ='"+ui.item.value+"' />"+"<input type='text' name ='snomedDesc"+snomedCount+"' value ='"+ui.item.label+"'/><input type='text' name ='fieldType"+snomedCount+"' value ='"+fieldType+"'/>");
       /*    $('#termTable').append("<tr>");
          $('#termTable').append("<td><input type='text' name ='termValue' value ='"+ui.item.value+"' /></td>");
          $('#termTable').append("<td><input type='text' name ='termLabel' value ='"+ui.item.label+"'/></td>");
          $('#termTable').append("<td><input type='text' name ='termType' value ='Present Complaint'/></td>");
          $('#termTable').append("</tr>"); */
           	
       		 $("#termTable td").each(function () {
       		    var tdText = $(this).text();
       		    $("#termTable td").filter(function () { 
       		            return tdText == $(this).text(); 
       		        }).not(":first").remove();
       		});
		   
            this.value = terms.join( "," );
            return false;
        }
    });
});
</script>

<div class="Block">

<%if(tempLateName.equalsIgnoreCase("Neonatology Unit")){ %>
<div class="clear"></div>
<input name="button4" type="button" align="right" class="buttonBig"	value="Height Weight Graph" onClick="submitForm('opdMain','opd?method=printHeightWeightGraph&hinId=<%=hinId %>');"  />
<input name="button4" type="button" align="right" class="buttonBig"	value="Height Weight Head Circumference Graph" onClick="submitForm('opdMain','opd?method=printHeightWeightHeadCircumferenceGraph&hinId=<%=hinId %>');"  />
<input name="button4" type="button" align="right" class="buttonBig"	value="Growth Record" onClick="submitForm('opdMain','opd?method=printGrowthRecord&hinId=<%=hinId %>');"  />


<div class="clear"></div>
<%} %>
<%if(tempLateName.trim().equalsIgnoreCase("Child And Adolescent")){ %>
<label>Education</label>
<select name="qualificationId" id="qualificationId">
<option value="">Select</option>
<%if(educationList.size()>0){
	for(MasQualification masQualification :educationList){
	%>
	<option value="<%=masQualification.getId()%>"><%=masQualification.getQualificationName() %></option>
<%}} %>
</select>

<script type="text/javascript">document.getElementById('qualificationId').value= <%=patientList.get(0).getEducation() != null?patientList.get(0).getEducation().getId():""%></script>


<%-- <select name="qualificationId">
<option value="">Select</option>
<%if(educationList.size()>0){
	for(MasQualification masQualification :educationList){
		if(patientList.get(0).getEducation().getId() != null){
			if(masQualification.getId().equals(patientList.get(0).getEducation().getId())){
		System.out.println("patientList.get(0).getEducation()=in loop===="+patientList.get(0).getEducation().getId());
		
	%>
	<option value="<%=masQualification.getId()%>" selected="selected"><%=masQualification.getQualificationName() %></option>
<% }}else{%>
<option value="<%=masQualification.getId()%>" ><%=masQualification.getQualificationName() %></option>
<%} }}%>
</select>

 --%>

<%} %>

<%if(tempLateName.trim().equalsIgnoreCase("STD Case Records")){ %>
<label>Marital Status</label>
<select name="maritalStatusId">
<option value="">Select</option>
<%if(maritalStatusList.size()>0){
	for(MasMaritalStatus masMaritalStatus :maritalStatusList){
	%>
	<option value="<%=masMaritalStatus.getId()%>"><%=masMaritalStatus.getMaritalStatusName() %></option>
<%}} %>
</select>

<label>Education</label>
<select name="qualificationId">
<option value="">Select</option>
<%if(educationList.size()>0){
	for(MasQualification masQualification :educationList){
	%>
	<option value="<%=masQualification.getId()%>"><%=masQualification.getQualificationName() %></option>
<%}} %>
</select>
<div class="clear"></div>
<label>Religion</label>
<select name="religionId">
<option value="">Select</option>
<%if(religionList.size()>0){
	for(MasReligion masReligion :religionList){
	%>
	<option value="<%=masReligion.getId()%>"><%=masReligion.getReligionName() %></option>
<%}} %>
</select>

<label>Occupation</label>
<select name="occupationId">
<option value="">Select</option>
<%if(occupationList.size()>0){
	for(MasOccupation masOccupation :occupationList){
	%>
	<option value="<%=masOccupation.getId()%>"><%=masOccupation.getOccupationName() %></option>
<%}} %>
</select>
<div class="clear"></div>
<%} %>
		<%
		   Set<Integer> set=new HashSet<Integer>();
		   Set<Integer> headingset=new HashSet<Integer>();
		   int i= 0;
			int count=0;
			int y=0;
			int j=0;	
			int idInx = 0;
			if(groupList.size()>0){
					
				for(Object[] obj : groupList){
					 i= 0;
					 y++;
				%>
					
			
				<div>
				<%
				if(headingList.size()>0){
						for(Object[] ob : headingList){
							if(obj[1].equals(ob[2])){
								
								
				%>
					<%if(ob[0]!=null && (ob[1] == null || ob[1].equals(""))){ %>
						<div align="left">
								<%
								if(ob[0]!=null){
									
								%>
								<label class="auto" style="margin-right: 265px; color:#0f75bf; font-size:13px"><%=ob[0]%></label>
								<input type="hidden" name="parameter<%=y %>" value="<%=(String)ob[0]%>"/>
								<%}
								if(ob[1]!=null){
									
								%>
								<label class="auto" style="margin-left: 25px; color:#0f75bf; font-size:13px"><%=ob[1]%></label>
								<input type="hidden" name="parameter<%=y %>" value="<%=(String)ob[1]%>"/>
								<%} %>
								
								
						</div>
						<%}else{ %>
						<div align="right">
								<%
								if(ob[0]!=null){
									
								%>
								<label class="auto" style="margin-left: 265px; color:#0f75bf; font-size:13px"><%=ob[0]%></label>
								<input type="hidden" name="parameter<%=y %>" value="<%=(String)ob[0]%>"/>
								<%}
								if(ob[1]!=null){
									
								%>
								<label class="auto" style="margin-left: 25px; color:#0f75bf; font-size:13px"><%=ob[1]%></label>
								<input type="hidden" name="parameter<%=y %>" value="<%=(String)ob[1]%>"/>
								<%} %>
								
								
						</div>
						
										
						<%}}
						}y++;
						}%>				
			
						<%
						if(obj[3]!=null && ((String)obj[3]).equalsIgnoreCase("y")){
							
						%>
						<hr class="hr-bg">
							<h4 class="large"><%=(String)obj[0]%>
							<input type="hidden" name="parameter<%=y %>" value="<%=(String)obj[0]%>"/>
							<input type="hidden" name="parameterType<%=y %>" value="Group"/>
							</h4>
							<div class="clear"></div>
						
						<%y++;}
								%>
								
								
						<div class="Block">
			            	 
			            	 
			            	 <%	
		            	 int maxlength = 0;           		
			 				
			for(MasSpecialityDeptGroup deptGroup: masForGorupParameter)
				{
				if(deptGroup.getSpGroup().getSpGroup().getId().equals(obj[1])){
					idInx++;
					i++;
					j++;
				String cls ="";
				String textColor ="";
				String textFont="";
				if(deptGroup.getTextMaxlength() != null){
				 maxlength = (Integer)deptGroup.getTextMaxlength();
				}
				if(deptGroup.getTextColor() != null){
					textColor = (String)deptGroup.getTextColor();
					}
				if(deptGroup.getTextFont() != null){
					textFont = (String)deptGroup.getTextFont();
					}
				String dataType = (String)(deptGroup.getDataType() != null?deptGroup.getDataType():"");
				
				//System.out.println("i===="+i+"---y--"+y+"--------"+deptGroup.getSpGroup().getSpParameter().getSpParameterName());
				%>
           	<input type="hidden" name="parameterType<%=y %>" value="Parameter"/>
          		<%
 				if(deptGroup.getSpGroup().getSpParameter().getStatus().equalsIgnoreCase("Y")) {
 				%>
					 <label style="height: auto;width: 175px ! important;color:<%=textColor%>";font-weight:<%=textFont %>><%=deptGroup.getSpGroup().getSpParameter().getSpParameterName()%></label>
					 <input type="hidden" name="parameter<%=y %>" id="parameterId<%=idInx %>" value="<%=deptGroup.getSpGroup().getSpParameter().getSpParameterName()%>"/>
					 
		      	<%} %>
		      	 <%String readonlyTxt = "";
 			 	if(deptGroup.getNadRequired()!=null && deptGroup.getNadRequired().equalsIgnoreCase("y")){ 
 			 		//readonlyTxt = "readonly";
 			 		cls="auto"; 
 			 %>
 			 <label class="auto" >NAD</label>
 			
 			  <input type="checkbox" name="parameter<%=y %>" value="nad" onclick="enableSplTextField(this,'<%=idInx%>')" class="checkboxMargin"/>
 			 <%--  <input type="checkbox" name="parameter<%=y %>" value="y" checked="checked" onclick="enableSplTextField(this,'<%=count%>')"  style="margin-right:30px;" /> --%>
 			  
 			 
 			 <%} %>
		 		
		 		<%
				if(deptGroup.getValueType() != null){
						if(deptGroup.getValueType().equalsIgnoreCase("text")){
					%>    
					 <%if(deptGroup.getDateField() != null && deptGroup.getDateField().equalsIgnoreCase("y")){
						if(tempLateName.equalsIgnoreCase("Neonatology Unit")){
					%>	 
					<input type="text" name="parameter<%=y %>"  id="textVal1<%=idInx %>"  class="auto"  style="width: 154px;" maxlength="<%=maxlength%>" validate="<%=deptGroup.getSpGroup().getSpParameter().getSpParameterName() != null?deptGroup.getSpGroup().getSpParameter().getSpParameterName():""%>,<%=dataType%>,no" />
 		 			 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=date%>',document.getElementById('textVal1<%=idInx %>'),event)" />
 		 			 <%}else{ %>
 		 			 
					<input type="text" name="parameter<%=y %>"  id="textVal1<%=idInx %>"  class="auto"  style="width: 154px;" maxlength="<%=maxlength%>" validate="<%=deptGroup.getSpGroup().getSpParameter().getSpParameterName() != null?deptGroup.getSpGroup().getSpParameter().getSpParameterName():""%>,<%=dataType%>,no" />
 		 			 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=date%>',document.getElementById('textVal1<%=idInx %>'),event)" />
 		 			 
 		 			 <%}}else{ 
 		 			 
 		 			 if((deptGroup.getDataType()!=null && !deptGroup.getDataType().equals("")) && (deptGroup.getDataType().equals("int") ||deptGroup.getDataType().equals("float"))){
 		 			 %>
					<input type="text" name="parameter<%=y %>"  id="textVal1<%=idInx %>"  class="auto"  style="width: 154px;" maxlength="<%=maxlength%>" validate="<%=deptGroup.getSpGroup().getSpParameter().getSpParameterName() != null?deptGroup.getSpGroup().getSpParameter().getSpParameterName():""%>,<%=dataType%>,no" onblur="populateValueInOtherFields(this.value,'<%=deptGroup.getSpGroup().getSpParameter().getSpParameterName()%>','<%=idInx%>')"/>
					<%}else{ %>
					<input type="text" name="parameter<%=y %>"  id="textVal1<%=idInx %>"  class="auto historyAutoComplete"  style="width: 154px;" maxlength="<%=maxlength%>" validate="<%=deptGroup.getSpGroup().getSpParameter().getSpParameterName() != null?deptGroup.getSpGroup().getSpParameter().getSpParameterName():""%>,<%=dataType%>,no" onblur="populateValueInOtherFields(this.value,'<%=deptGroup.getSpGroup().getSpParameter().getSpParameterName()%>','<%=idInx%>')"/>
					<%} %>
					
					<%if(deptGroup.getUnitLabel() != null && !deptGroup.getUnitLabel().equals("")){ %>
						<input type="text" name="parameter<%=y %>" class="small"  id="textVal1<%=idInx %>"  style="width:30px;" value="<%=deptGroup.getUnitLabel()%>"/>
					<%}%>
					
				<%
 				if(deptGroup.getSpGroup().getSpParameter().getStatus().equalsIgnoreCase("Y") && deptGroup.getSpGroup().getSpParameter().getSpParameterName().equalsIgnoreCase("Duration of illness")){
 				%>
				 <select name="parameter<%=y %>"  class="small">
						 	<option value="">Select</option>
						 <option value="Days">Days</option>
						 <option value="Month">Month</option>
						  <option value="Weeks">Weeks</option>
						 </select>
				<%}}}}
					
						   
				   if( deptGroup.getValueType() != null  && deptGroup.getValueType().equalsIgnoreCase("lov"))
			       {
				       	if(deptGroup.getMultipleSelection() != null && deptGroup.getMultipleSelection().equalsIgnoreCase("y")){
				       		cls="auto";
				       %>
				       <select name="multipleSelect"  multiple="multiple"  id="parameterId<%=idInx %>"   class="multiple2" size="5" onblur="displayExtraField(this,'<%=idInx %>');displayMultipleSelection(this,'<%=j%>');">
				    	<option value="">Select</option>
				    	<%for(MasSpecialityDeptGroupValue msdValue:masValue){ 
				    		if(msdValue.getDeptGroup() != null){
				    	%>
				    		<%if(deptGroup.getId()==msdValue.getDeptGroup().getId()){ %> 
				    			<option value="<%=msdValue.getValue()%>"><%=msdValue.getValue() %></option>
				    		<%} %>
				    	<%}}%>
				    	</select>
				    	
				    	<textarea value="" name="parameter<%=y %>" id="multiSelectText<%=j %>" class="historyAutoComplete"></textarea>
				    	
				     <input type="hidden" name="validationVal<%=y %>" id="validationVal<%=idInx %>" value="<%=deptGroup.getValidationValue()!=null?deptGroup.getValidationValue():""%>"/> 
				    	
				       
				       <%}else{cls="auto"; %>
				    	<select name="parameter<%=y %>" class="" onchange="displayExtraField(this,'<%=idInx %>');"  id="parameterId<%=idInx %>" >
				    	<option value="">Select</option>
				    	<%for(MasSpecialityDeptGroupValue msdValue:masValue){ 
				    		if(msdValue.getDeptGroup() != null){
				    	%>
				    		<%if(deptGroup.getId()==msdValue.getDeptGroup().getId()){
				    			if(msdValue.getDefaultValue() != null && msdValue.getDefaultValue().equals("y")){
				    			%> 
				    			<option value="<%=msdValue.getValue()%>" selected="selected"><%=msdValue.getValue() %></option>
				    			<%}else{ %>
				    			<option value="<%=msdValue.getValue()%>" ><%=msdValue.getValue() %></option>
				    			<%} %>
				    		<%} %>
				    	<%}}%>
				    	</select>
				    	
				   		 <input type="hidden" name="validationVal<%=y %>" id="validationVal<%=idInx %>" value="<%=deptGroup.getValidationValue()!=null?deptGroup.getValidationValue():""%>"/> 
		      
  					   
				 <%}}%> 
				 <%
				 	if(deptGroup.getSpGroup().getSpParameter().getSpParameterName().equals("Type of Contact")){ // change value here
				 %>
						 <div id="stdDiv" style="display: none;">
						<!--  <label >If Yes</label> -->
						 <input type="hidden" name="parameter<%=y %>" id="parameterId<%=idInx %>" value="If Yes"/>
		
						 <select name="parameter<%=y %>" >
						 	<option value="">Select</option>
						 <option value="Active">Active</option>
						 <option value="Passive">Passive</option>
						 </select>
						 </div>
						 
						 <%} %>
						 
				<%if(deptGroup.getValueType() != null && deptGroup.getValueType().equalsIgnoreCase("Radio Button")){
					if(deptGroup.getRadioText1() != null && !deptGroup.getRadioText1().equals("") || deptGroup.getRadioText2() != null && !deptGroup.getRadioText2().equals("")){
					
					%>
      				<%if(deptGroup.getRadioDefault1() != null && !deptGroup.getRadioDefault1().equals("")){ %>
      				<input type="radio" name="parameter<%=y %>" value="<%=deptGroup.getRadioText1() %>" class="radioCheck"  style="margin-right:10px;" checked="checked" onclick="displayExtraField(this,'<%=idInx %>');"/><label class="auto"> <%=deptGroup.getRadioText1() %></label>
      				<%}else{ %>
      				<input type="radio" name="parameter<%=y %>" value="<%=deptGroup.getRadioText1() %>" class="radioCheck" style="margin-right:10px;" onclick="displayExtraField(this,'<%=idInx %>');"/><label class="auto"> <%=deptGroup.getRadioText1() %></label>
      				<%} %>
      				<%if(deptGroup.getRadioDefault2() != null && !deptGroup.getRadioDefault2().equals("")){ %>
      					<input type="radio" name="parameter<%=y %>" value="<%=deptGroup.getRadioText2() %>" class="radioCheck" style="margin-right:10px;" checked="checked" onclick="displayExtraField(this,'<%=idInx %>');"/><label  class="auto"><%=deptGroup.getRadioText2() %></label>
					<%}else{ %>
					<input type="radio" name="parameter<%=y %>" value="<%=deptGroup.getRadioText2() %>" class="radioCheck" style="margin-right:10px;" onclick="displayExtraField(this,'<%=idInx %>');"/><label  class="auto"><%=deptGroup.getRadioText2() %></label>
      						
      				<%} %>
          				
          				<%}else{ %>
           				<input type="radio" name="parameter<%=y %>" value="yes" class="radioCheck" style="margin-right:10px;" id="parameterId<%=idInx %>" onclick="displayExtraField(this,'<%=idInx %>');"/><label class="auto"> Yes</label>
     						<input type="radio" name="parameter<%=y %>" value="no" class="radioCheck" style="margin-right:10px;" id="parameterId<%=idInx %>" onclick="displayExtraField(this,'<%=idInx %>');"/><label  class="auto"> No</label>
           				
           				<%} %>
							 <input type="hidden" name="validationVal<%=y %>" id="validationVal<%=idInx %>" value="<%=deptGroup.getValidationValue()!=null?deptGroup.getValidationValue():""%>"/> 
		      
		      <!-- For Extra LOV on radio button -->
		      <%
		      		if(deptGroup.getExtraLov()!=null && deptGroup.getExtraLov().equalsIgnoreCase("t")){
		      %>
		      			<select name="multipleSelect"  multiple="multiple"  id="extraLovId<%=idInx %>" style="display: none"  class="multiple2" size="5" onblur="displayExtraField(this,'<%=idInx %>');displayMultipleSelection(this,'<%=j%>');">
				    	<option value="">Select</option>
				    	<%for(MasSpecialityDeptGroupValue msdValue:masValue){ 
				    		if(msdValue.getDeptGroup() != null){
				    			
				    			
				    	%>
				    		<%if(deptGroup.getId()==msdValue.getDeptGroup().getId()){ %> 
				    			<option value="<%=msdValue.getValue()%>"><%=msdValue.getValue() %></option>
				    		<%} %>
				    	<%}}%>
				    	</select>
				    		 <input type="hidden" name="parameter<%=y %>" id="multiSelectText<%=j %>" />
				    <%} %>	
				    	<!-- End extra lov -->
		      
  						 <% y++;}else if(deptGroup.getValueType() != null && deptGroup.getValueType().equalsIgnoreCase("Check Box")){ cls="auto";
  						 	String checkClass = "";
  						 	if(deptGroup.getSpGroup().getSpParameter().getSpParameterName().equalsIgnoreCase("others")){
  						 		checkClass = "checkboxMargin";
  						 	}
  						 %>
   						   <input type="checkbox" name="parameter<%=y %>"  id="parameterId<%=idInx %>"  value="y" class="<%=checkClass%>" onclick="displayExtraField(this,'<%=idInx %>')"/>
							<%} %>
				 
				 	 <%-- <%//String readonlyTxt = "";
 			 	if(deptGroup.getNadRequired()!=null && deptGroup.getNadRequired().equalsIgnoreCase("y")){ 
 			 		//readonlyTxt = "readonly";
 			 		cls="auto"; 
 			 %>
 			 <label class="auto" >NAD</label>
 			
 			  <input type="checkbox" name="parameter<%=y %>" value="nad" onclick="enableSplTextField(this,'<%=count%>')" class="checkboxMargin"/>
 			  <input type="checkbox" name="parameter<%=y %>" value="y" checked="checked" onclick="enableSplTextField(this,'<%=count%>')"  style="margin-right:30px;" />
 			  
 			 
 			 <%} %> --%>
 			 
 			 <%if(deptGroup.getTextField()!=null && deptGroup.getTextField().equalsIgnoreCase("t")){ %>
					<%-- <%if(deptGroup.getDateField() != null && deptGroup.getDateField().equalsIgnoreCase("y")){
						if(tempLateName.equalsIgnoreCase("Neonatology Unit")){
					%>	 
				    <input type="text" name="parameter<%=y %>"  id="parameterId<%=idInx %>"  class="dateSmall"  readonly="readonly"   value="<%=date%>"/>
 		 			 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=date%>',document.getElementById('textValue<%=y %>'),event)" />
 		 			 <%}else{ %>
 		 			 
 		 			 <input type="text" name="parameter<%=y %>"  id="parameterId<%=idInx %>"  class="dateSmall" readonly="readonly"/>
 		 			 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=date%>',document.getElementById('textValue<%=y %>'),event)" />
 		 			 
 		 			 <%} %> --%>
 		 			<!-- ------------for extra field------------------------ -->
 		 			<% //}else 
 		 				
 		 				//if(){%>
 		 			 <input type="text" name="parameter<%=y %>"  id="textValue<%=idInx %>"   class="historyAutoComplete" style="width: 154px;display: none;"  maxlength="<%=maxlength%>" />
 		 			 
 		 			 <%
 		 			 if(deptGroup.getMultipleSelection() != null && deptGroup.getMultipleSelection().equalsIgnoreCase("y")){
 		 			 %>
 		 			 
 		 			<div class="clear"></div>
 		 			<%} %>
 		 			<%//} %>
				<%}%>
				
				<%
 				if(deptGroup.getNoOfFields()!=null && deptGroup.getNoOfFields() > 1){
 			%>
 				 <input type="text" name="parameter<%=y %>"  id="textValue<%=idInx %>"  class="auto historyAutoComplete"  <%=readonlyTxt %> id="parameterId<%=idInx %>"/>
 				 <div class="clear"></div>
 			 			<%y++;}%>
 			 			
			
				 <%if(deptGroup.getTextField()!=null){ 
				 %>
					<%if(deptGroup.getTextField().equalsIgnoreCase("n")  && deptGroup.getValueType()!=null && deptGroup.getValueType().equalsIgnoreCase("text area"))
				    {%>
				    <textarea style="width: 179px; height: 38px;" rows="" cols="" class="historyAutoComplete" id="parameterId<%=idInx %>"  name="parameter<%=y %>" maxlength="<%=maxlength%>"></textarea> <% }%>
				 <%}%> 
				 
				 
				 
			
	
			 <%
			 if(i%2==0){ 
								   y++; %>
											<div class="clear"></div>
										<%} %>
		<%
						}
							%>
							  
						<%
}	 

	
		%>
			</div>
			<%
			if(deptGorupParameterGridList.size()>0){
				
				String grpGrid="";
				for(MasSpecialityDeptGroup spGrid : deptGorupParameterGridList){
					if(spGrid.getSpGroup().getSpGroup().getId().equals(obj[1])){
						grpGrid = "yes";
						break;
					}
				}
			%>
			<%
			if(grpGrid.equals("yes")){
			%>
	<input type="button" class="buttonAdd" alt="Add" onclick="generateRowDynamic('splGrid<%=y%>');" />
	<input type="button" class="buttonDel" alt="Delete" value="&nbsp;"	onclick="removeRowDynamic(<%=y %>,'splGrid<%=y%>');" />
	
	<div class="clear"></div>
	<div></div>
	<div class="tableForTab" style="width:1158px;">
		<table id="splGrid<%=y%>" width="100%" border="0" cellpadding="5" cellspacing="0" >
		<%
			List<String> paramName = new ArrayList<String>();
			List<Integer> paramNameId = new ArrayList<Integer>();
			List<String> valType = new ArrayList<String>();
			List<String> multiSelection = new ArrayList<String>();
			
			int k=0;
			for(MasSpecialityDeptGroup spGrid : deptGorupParameterGridList){
				if(spGrid.getSpGroup().getSpGroup().getId().equals(obj[1])){
					
					paramName.add(k, spGrid.getSpGroup().getSpParameter().getSpParameterName());
					valType.add(k, spGrid.getValueType());
					multiSelection.add(k, spGrid.getMultipleSelection()!= null?spGrid.getMultipleSelection():"");
					paramNameId.add(k, spGrid.getSpGroup().getSpParameter().getId());
				k++;
				}
			}
			
			%>
		<tr>
		
		<th></th>
		
			<%for(int l=0;l<paramName.size();l++){
				
				%>
			<th><%=paramName.get(l) %><input type="hidden" name="parameter<%=y %>" value="<%=paramName.get(l) %>" class="" id="gridParameter"/>
			<input type="hidden" name="parameterType<%=y %>" value="TableHeader"/>
			
			</th>
			<%
				if(paramName.get(l).equalsIgnoreCase("Pigmentation")){
					%>
					<th style="display: none;">
					<input type="hidden" name="parameter<%=y %>" value="" class="" id="gridParameter"/>
					</th>
				<%}
			%>
				<%
				if(paramName.get(l).equalsIgnoreCase("Size")){
					%>
					<th style="display: none;">
					<input type="hidden" name="parameter<%=y %>" value="" class="" id="gridParameter"/>
					</th>
				<%}
			%>
			
			<%	}y++;
			%>
		</tr>

		<tr>
		
		<td><input type="checkbox" class="radioCheck"	name="chargeRadio<%=y %>" id="chargeRadio<%=y %>" />
	
		</td>
	
			<%
			for(int l=0;l<valType.size();l++){ 
			//	y++;
				
				%>
			
			<td>
				<input type="hidden" name="parameterType<%=y %>" value="TableData"/>
			<%
				if(valType.get(l).equalsIgnoreCase("text")){
			
			%>    
			<input type="text" name="parameter<%=y %>" class="auto" id="" />
			
			<%		
			if(tempLateName.equalsIgnoreCase("Vesiculo-bullous disorders")){
				if(paramName.get(l).equalsIgnoreCase("Size")){
		%>
					<label>Smallest Lesion</label>
					<input type="text" name="parameter<%=y %>" class="auto" id="" /></br>
					<label>Largest Lesion</label>
					
			<%}}}else if(valType.get(l).equalsIgnoreCase("LOV")){
				String multipleSelection = "";
				
					multipleSelection = multiSelection.get(l)!= null?multiSelection.get(l):"";
				
				if(multipleSelection.equalsIgnoreCase("y")){
					
				%>
				<input type="hidden" name="parameter<%=y %>" id="multiSelectText<%=count %>"  value=""/>
			<select name="selMulti<%=y %>" multiple="multiple"  class="multiple3" size="5" onblur="displayMultipleSelection(this,'<%=count%>')">
		    	<option value="">Select</option>
		    	<%for(MasSpecialityDeptGroupValue msdValueForGrid:masValueForGrid){ 
	    		
	    	%>
	    		<%if(paramName.get(l).equalsIgnoreCase(msdValueForGrid.getDeptGroup().getSpGroup().getSpParameter().getSpParameterName())){ %> 
	    			<option value="<%=msdValueForGrid.getValue()%>"><%=msdValueForGrid.getValue() %></option>
				    		
				    	<%}}%>
			</select>
				
				<%}else{
					
				%>
			<select name="parameter<%=y %>">
			    	<option value="">Select</option>
			    	<%for(MasSpecialityDeptGroupValue msdValueForGrid:masValueForGrid){ 
   		if(msdValueForGrid.getDeptGroup() != null){
   		%>
   		<%if(paramNameId.get(l).equals(msdValueForGrid.getDeptGroup().getSpGroup().getSpParameter().getId())){ 
   			
   		%> 
   			<option value="<%=msdValueForGrid.getValue()%>"><%=msdValueForGrid.getValue() %></option>
				    	<%}}
				    	}%>
	    	</select>
			<%}
				
				

					
				if(tempLateName.equalsIgnoreCase("Vesiculo-bullous disorders") ){
					if(paramName.get(l).equalsIgnoreCase("Pigmentation")){
			%>
					<select name="parameter<%=y %>">
			    	<option value="">Select</option>
			    	<option value="Erythematous">Erythematous</option>
				<option value="Violaceous">Violaceous</option>
				<option value="Hypo pigmented">Hypo pigmented</option>
				<option value="Hyper pigmented">Hyper pigmented</option>
				<option value="De pigmented">De pigmented</option>
			    	
	    	</select>
				<%}}
			
			}else if(valType.get(l).equalsIgnoreCase("Text Area")){ %>
			<textarea style="width: 179px; height: 38px;" rows="" cols=""  name="parameter<%=y %>" id=""></textarea>
			
			<%}else if(valType.get(l).equalsIgnoreCase("Check Box")){ %>
		   <input type="checkbox" name="chk<%=y %>" value="" />
  	       					
			<%}else if(valType.get(l).equalsIgnoreCase("Radio Button")){ %>
			<input type="hidden" name="parameter<%=y %>"  id="radioId<%=count %>" />
 						<input type="radio" name="radioPara<%=y %>" value="yes" class="radioCheck" style="margin-right:10px;" onclick="setValueInText(this.value,<%=count%>)"/><label class="auto"> Yes</label>
 						<input type="radio" name="radioPara<%=y %>" value="no" class="radioCheck" style="margin-right:10px;" onclick="setValueInText(this.value,<%=count%>)"/><label  class="auto"> No</label>
			 <%}
			count++;
}//y++;
y= y+10;
%>
		</tr>
		
	</table>
	</div>
	<%} %>
        <%  y++; 
			}} %>
       
           	 <%} %>
           	 
         <%--   	 <%if(tempLateName.equalsIgnoreCase("Vesiculo-bullous disorders")){ %>
			
			
			<!-- ------Lab Examination--------- -->
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="displayCollapsibleTabForLabResultDermotelogy('Lab Result Vesiculo')" name="" value="+" type="button">
</div>
<div class="plusText"><h4 class="h4Tab">Lab Result</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div  id="labResultVesiculo" class="collapasHide">
<div class="indArrow"></div>
<div class="Block">
			<div class="clear"></div>
			
			<%if(labResultForLeprosyPerformaList.size()>0){ %>
				<div class="tableForTab" style="width:910px">
					<div id="divTemplet1">
						<table border="0" align="center" cellpadding="0" cellspacing="0" id="labResultFirstTrimester">
							<tr>
								<th>Investigation</th>
								<th>Resul Date</th>
								<th>Result</th>
							</tr>
							<%
								boolean flag = false;
								int OrderId = 0; 
								for(DgResultEntryHeader dgResultEntry :labResultForLeprosyPerformaList){
									DgResultEntryDetail dgResultEntryDetail =  new DgResultEntryDetail();
									 if (dgResultEntry.getDgResultEntryDetails().size() > 0) {
										flag = true;
										dgResultEntryDetail = dgResultEntry.getDgResultEntryDetails().iterator().next();
										OrderId = (Integer)dgResultEntryDetail.getSampleCollectionDetails().getSampleCollectionHeader().getOrder().getId();
									} 
									
								%>
							<tr>
							<td><%=dgResultEntry.getInvestigation().getInvestigationName() %></td>
							<td><%=HMSUtil.convertDateToStringWithoutTime(dgResultEntry.getResultDate()) %></td>
							<td><a href="javascript:openPopupForLabResultsForSpeciality(csrfTokenName+'='+csrfTokenValue,'<%=OrderId%>','<%=dgResultEntry.getInvestigation().getId()%>');">Lab Results</a></td>
							</tr>
						<%} %>	
						</table>
						
					</div>
				</div>
				<%}else{ %>
						<span>No Record Found</span>
						<%} %>
</div>			
</div>
<!-- ------Lab Examination End--------- -->
			
			
			
			
			
			
			
				 <%} %>
				 
				 <%if(tempLateName.equalsIgnoreCase("STD Case Record")){ %>
				 
				
			<!-- ------Lab Examination--------- -->
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="displayCollapsibleTabForLabResultDermotelogy('Lab Result STD')" name="" value="+" type="button">
</div>
<div class="plusText"><h4 class="h4Tab">Lab Result</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div  id="labResultStd" class="collapasHide">
<div class="indArrow"></div>
<div class="Block">
			<div class="clear"></div>
			
			<%if(labResultForLeprosyPerformaList.size()>0){ %>
				<div class="tableForTab" style="width:910px">
					<div id="divTemplet1">
						<table border="0" align="center" cellpadding="0" cellspacing="0" id="labResultFirstTrimester">
							<tr>
								<th>Investigation</th>
								<th>Resul Date</th>
								<th>Result</th>
							</tr>
							<%
								boolean flag = false;
								int OrderId = 0; 
								for(DgResultEntryHeader dgResultEntry :labResultForLeprosyPerformaList){
									DgResultEntryDetail dgResultEntryDetail =  new DgResultEntryDetail();
									 if (dgResultEntry.getDgResultEntryDetails().size() > 0) {
										flag = true;
										dgResultEntryDetail = dgResultEntry.getDgResultEntryDetails().iterator().next();
										OrderId = (Integer)dgResultEntryDetail.getSampleCollectionDetails().getSampleCollectionHeader().getOrder().getId();
									} 
									
								%>
							<tr>
							<td><%=dgResultEntry.getInvestigation().getInvestigationName() %></td>
							<td><%=HMSUtil.convertDateToStringWithoutTime(dgResultEntry.getResultDate()) %></td>
							<td><a href="javascript:openPopupForLabResultsForSpeciality(csrfTokenName+'='+csrfTokenValue,'<%=OrderId%>','<%=dgResultEntry.getInvestigation().getId()%>');">Lab Results</a></td>
							</tr>
						<%} %>	
						</table>
						
					</div>
				</div>
				<%}else{ %>
						<span>No Record Found</span>
						<%} %>
</div>			
</div>
<!-- ------Lab Examination End--------- -->
				 <%} %>
           	  --%>
           	 <input type="hidden" name="cnt"  id="cnt" value="<%=y%>"/>	 
</div>
</div>



