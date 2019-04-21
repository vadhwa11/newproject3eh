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

<%@page import="jkt.hms.masters.business.OpdSpecialityTemplateDetails"%>
<%@page import="jkt.hms.masters.business.OpdSpecialityDetails"%>
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
		List<OpdSpecialityTemplateDetails>specialityDetailsList = new ArrayList<OpdSpecialityTemplateDetails>();
			
		
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
        if(map.get("specialityDetailsList") != null){
        	specialityDetailsList = (List<OpdSpecialityTemplateDetails>)map.get("specialityDetailsList");
	 	 } 
			System.out.println("===========specialityDetailsList===="+specialityDetailsList.size());

            
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
<div id="divName">
<input type="hidden" name="specialty" value="<%=templateId%>"/>
<input type="hidden" name="templateName" value="<%=tempLateName%>"/>
<h2><%=tempLateName %></h2>
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
		
		<%-- <%if(specialityDetailsList.size()>0){ %> --%>
		
		
		
		<%
		   Set<Integer> set=new HashSet<Integer>();
		   Set<Integer> headingset=new HashSet<Integer>();
			int i=0;
				if(masForGorupParameter.size()>0)
				{
					int count=0;
						%>
					
					<%
					for(MasSpecialityDeptGroup deptGroup: masForGorupParameter)
						{ count++;
						%>
						<div>
								<div>
								<% if(deptGroup.getSpGroup().getSpGroup().getSpHeading()!=null && headingset.add(deptGroup.getSpGroup().getSpGroup().getSpHeading().getId())){
										%>
										<div align="right">
										<%
										if(deptGroup.getSpGroup().getSpGroup().getSpHeading().getSpHeadingOne()!=null){
										%>
										<label class="auto" style="margin-left: 371px; color:#0f75bf; font-size:13px"><%=deptGroup.getSpGroup().getSpGroup().getSpHeading().getSpHeadingOne()%></label>
										<%}
										if(deptGroup.getSpGroup().getSpGroup().getSpHeading().getSpHeadingTwo()!=null){
										%>
										<label class="auto" style="margin-left: 32px; color:#0f75bf; font-size:13px"><%=deptGroup.getSpGroup().getSpGroup().getSpHeading().getSpHeadingTwo()%></label>
										<%} %>
										</div>
										<div class="clear"></div>
										<%
												}%>
												
												
										<% if(set.add(deptGroup.getSpGroup().getSpGroup().getId())){%>
									<hr class="hr-bg">
												<%if(deptGroup.getSpGroup().getSpGroup().getDisplay()!=null && deptGroup.getSpGroup().getSpGroup().getDisplay().equalsIgnoreCase("y")){
													
										%>
										<h4 class="large"><%=deptGroup.getSpGroup().getSpGroup().getSpGroupName()%></h4>
										<div class="clear"></div>
										<%}
												}%>
								</div> 
								<div>
					            	 
					            	 
					            	 
					            	
					            		<% 
					            		if(deptGroup.getSpGroup().getSpParameter().getSpParameterName().length()>20){
					            		if(deptGroup.getSpGroup().getSpParameter().getStatus().equalsIgnoreCase("Y")) {%>
											 <label class="largeAutoHeight"><%=deptGroup.getSpGroup().getSpParameter().getSpParameterName()%>	 </label>
								       		<input type="hidden" value="<%=deptGroup.getSpGroup().getSpParameter().getId()%>" name="parameterId" id="parameterId<%=count%>"/>
								       		<input type="hidden" value="<%= deptGroup.getSpGroup().getSpGroup().getId()%>" name="grpId" id="grpId<%=count%>"/>
								       		
						 				<%}
						 				}else{
						 				
						 				
						 				if(deptGroup.getSpGroup().getSpParameter().getStatus().equalsIgnoreCase("Y")) {
						 				//System.out.println("parameter==="+deptGroup.getSpGroup().getSpParameter().getSpParameterName());
						 				%>
											 <label><%=deptGroup.getSpGroup().getSpParameter().getSpParameterName()%>	 </label>
								       		<input type="hidden" value="<%=deptGroup.getSpGroup().getSpParameter().getId()%>" name="parameterId" id="parameterId<%=count%>"/>
								       		<input type="hidden" value="<%= deptGroup.getSpGroup().getSpGroup().getId()%>" name="grpId" id="grpId<%=count%>"/>
						 				<%}} %>
						 		
						 		
										
											   <%if( deptGroup.getValueType() != null  && deptGroup.getValueType().equalsIgnoreCase("lov"))
										       {
										       	if(deptGroup.getMultipleSelection() != null && deptGroup.getMultipleSelection().equalsIgnoreCase("y")){
										       
										       %>
										       <select name="textValue"  multiple="multiple" class="multiple1" size="5">
										    	<option value="">Select</option>
										    	<%for(MasSpecialityDeptGroupValue msdValue:masValue){ 
										    		if(msdValue.getDeptGroup() != null){
										    	%>
										    		<%if(deptGroup.getId()==msdValue.getDeptGroup().getId()){ %> 
										    			<option value="<%=msdValue.getValue()%>"><%=msdValue.getValue() %></option>
										    		<%} %>
										    	<%}}%>
										    	</select>
										       
										       
										       <%}else{ %>
										    	<select name="textValue">
										    	<option value="">Select</option>
										    	<%for(MasSpecialityDeptGroupValue msdValue:masValue){ 
										    		if(msdValue.getDeptGroup() != null){
										    	%>
										    		<%if(deptGroup.getId()==msdValue.getDeptGroup().getId()){ %> 
										    			<option value="<%=msdValue.getValue()%>"><%=msdValue.getValue() %></option>
										    		<%} %>
										    	<%}}%>
										    	</select>
										    	
										      
										 <%}}%> 
										 
										<%if(deptGroup.getValueType() != null && deptGroup.getValueType().equalsIgnoreCase("Radio Button")){ %>
    	              						<input type="radio" name="radioBtn<%=count %>" value="yes" class="radioCheck" style="margin-right:10px;" onclick="setValueInText(this.value,<%=count%>)"/><label class="auto"> Yes</label>
    	              						<input type="radio" name="radioBtn<%=count %>" value="no" class="radioCheck" style="margin-right:10px;" onclick="setValueInText(this.value,<%=count%>)"/><label  class="auto"> No</label>
	              							   <input type="hidden" name="textValue" class="auto" id="textValue<%=count %>" />
	              						
	              						 <%}else if(deptGroup.getValueType() != null && deptGroup.getValueType().equalsIgnoreCase("Check Box")){ %>
        	       						   <input type="checkbox" name="textValueChkb" value="" onclick="setValForCheckBox(this,'<%=count %>')"/>
        	       						      <input type="hidden" name="textValue"  id="textValue<%=count %>"/>
             							<%} %>
										 
										 	 <%String readonlyTxt = "";
						 			 	if(deptGroup.getNadRequired()!=null && deptGroup.getNadRequired().equalsIgnoreCase("y")){
						 			 		readonlyTxt = "readonly";
						 			 %>
						 			 <label class="auto" style="margin-left: 100px;" >NAD</label>
						 			  <input type="checkbox" name="nad" value="checkbox" checked="checked" onclick="enableSplTextField(this,'<%=count%>')" style="margin-right:30px;" />
						 			 
						 			 <%} %>
						 			 
						 			 <%if(deptGroup.getTextField()!=null){%>
										
											<%if(deptGroup.getDateField() != null && deptGroup.getDateField().equalsIgnoreCase("y")){%>	 
										    
										    <input type="text" name="textValue" class="auto" value="<%=date %>" id="textValue<%=count %>" <%=readonlyTxt %>/>
						 		 			 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=date+count%>',document.opdMain.textValue<%=count %>,event)" />
						 		 			<% }else if(deptGroup.getTextField().equalsIgnoreCase("t")){%>
						 		 			
						 		 			 <input type="text" name="textValue" class="auto" id="textValue<%=count %>" <%=readonlyTxt %>/>
						 		 			 
						 		 			
						 		 			
						 		 			<%} %>
										<%}%>
										
										<%
						 				if(deptGroup.getNoOfFields()!=null && deptGroup.getNoOfFields() > 1){
						 			%>
						 				 <input type="text" name="textVal1" class="auto" id="textVal1<%=count %>" <%=readonlyTxt %>/>
						 			 			
						 			 			<%}else{
						 			 									 			 				
						 			 				%>
						 			 				<input type="hidden" name="textVal1" class="auto" id="textVal1<%=count %>" <%=readonlyTxt %>/>
						 			 			<% }%>
						 			 			
									
										 <%if(deptGroup.getTextField()!=null){ 
										 %>
											<%if(deptGroup.getTextField().equalsIgnoreCase("n")  && deptGroup.getValueType()!=null && deptGroup.getValueType().equalsIgnoreCase("text area"))
										    {%><textarea style="width: 179px; height: 38px;" rows="" cols=""  name="textValue" id="textValue<%=count%>"></textarea> <% }%>
										 <%}%> 
										 
										 
										 <%-- <%if(count%2==0){ %> --%>
											<div class="clear"></div>
										<%-- <%} %> --%>
								</div>
								
						</div>
						<%if(deptGroup.getSpGroup().getSpGroup().getSpGroupName().equalsIgnoreCase("DrHiGrpB1")  /* || deptGroup.getTemplate().getTemplateName().equalsIgnoreCase("Vesiculo-bullous disorders") */){ %>
						<div class="clear"></div>
<input type="button" class="buttonAdd" alt="Add" tabindex="4"	value="&nbsp;" onclick="addRowForPrimaryLesionVesiculoTemplate('Vesiculo-bullous disorders');" />
<input type="button" class="buttonDel" tabindex="3" alt="Delete" value="&nbsp;" onclick="removeRowForPrimaryLesion();" />
  <div class="clear"></div>
  <div style="width: 875px; height: 150px; overflow: scroll;" class="tableForTab">
  <table width="100%" border="0" cellpadding="5" cellspacing="0" class="tablestyle" id="primaryLessionGrid"> 
    <tr>
    <th align="center"></th>
      <th align="center">Primary Lesion</th>
      <th align="center">Number</th>
      <th align="center">Site</th>
     <!--  <th align="center">Pigmentation</th>
       <th align="center">Character</th>
       <th align="center">Border</th>
       <th align="center">Surface</th> -->
       <th align="center">Type of Lesion</th>
       <th align="center">Size</th>
        <th align="center">Hair on Lesion</th>
         <!-- <th align="center">Aggravating Factors</th> -->
          <th align="center">Additional Feature</th>
    </tr>
    <tr>
      <td><input  type="checkbox" class="radioCheck" name="primaryLesionRadio1" id="primaryLesionRadio1" /></td> 
		<td>
		<select name="primaryLesion1" id="primaryLesion1">
		<option value="">Select</option>
		<option value="Macule">Macule</option>
		<option value="Papule">Papule</option>
		<option value="Plaque">Plaque</option>
		<option value="Nodule">Nodule</option>
		<option value="Wheal">Wheal</option>
		<option value="Bulla">Bulla</option>
		<option value="Pustule">Pustule</option>
		<option value="Vesicle">Vesicle</option>
		<option value="Haemorrhagic">Haemorrhagic</option>
		<option value="Others">Others</option>
		</select>
		</td>
     <td>
		<select name="primaryLesionNo1" id="primaryLesionNo1">
		<option value="">Select</option>
		<option value="Single">Single</option>
		<option value="Multiple">Multiple</option>
		<option value="Generalized">Generalized</option>
		</select>
		</td>
      <td align="left"><input  type="text" maxlength="120" validate="Duration,metachar,no" tabindex="1" value="" name="primaryLesionSite1" ></td>
      
     
    <!--  <td>
		<select name="primaryPigmentation1" id="primaryPigmentation1">
		<option value="">Select</option>
		<option value="Yes">Yes</option>
		<option value="No">No</option>
		</select>
		<select name="primaryPigmentationValue1" id="primaryPigmentationValue1">
		<option value="">Select</option>
		<option value="Erythematous">Erythematous</option>
		<option value="Hypo pigmented">Hypo pigmented</option>
		<option value="Hyper pigmented">Hyper pigmented</option>
		<option value="De pigmented">De pigmented</option>
		</select>
		</td>
		  <td>
		<select name="primaryCharacter1" id="primaryCharacter1">
		<option value="">Select</option>
		<option value="Flat">Flat</option>
		<option value="Raised">Raised</option>
		<option value="Fluid Filled">Fluid Filled</option>
		</select>
		</td>
		<td>
		<select name="primaryBorder1" id="primaryBorder1">
		<option value="">Select</option>
		<option value="Well defined">Well defined</option>
		<option value="Partially Ill Defined">Partially Ill Defined</option>
		<option value="Ill Defined">Ill Defined</option>
		</select>
		</td>
		<td>
		<select name="primarySurface1" id="primarySurface1">
		<option value="">Select</option>
		<option value="Smooth">Smooth</option>
		<option value="Rough">Rough</option>
		<option value="Dry">Dry</option>
		</select>
		</td> -->
		
		 <td>
		<select name="typeOfLesion1" id="typeOfLesion1">
		<option value="">Select</option>
		<option value="Grooping">Grooping</option>
		<option value="Confluent">Confluent</option>
		<option value="Discrete">Discrete</option>
		</select>
		<input  type="text" maxlength="120" validate="Duration,metachar,no" tabindex="1" value="" name="typeOfLesionValue1" ></td>
      
		<td align="left"><input  type="text" maxlength="120" validate="Duration,metachar,no" tabindex="1" value="" name="primarySmallestSize1" >
		<label class="smallAuto autoSpace">Smallest Lesion</label>
		<input  type="text" maxlength="120" validate="Duration,metachar,no" tabindex="1" value="" name="primaryLargestSize1" >
		<label class="smallAuto autoSpace">Largest Lesion</label></td>
		<td>
		<select name="hairOnPrimaryLesion1" id="hairOnPrimaryLesion1">
		<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="De pigmented">De pigmented</option>
		</select>
		</td>
		
		<td><input  type="text"  validate="Additional Feature,metachar,no" tabindex="1" value="" name="primaryAdditionalFeature1" ></td>
	<!-- 	<td>
		<select name="primaryAggravatingFactors1" id="primaryAggravatingFactors1">
		<option value="">Select</option>
		<option value="Sweating">Sweating</option>
		<option value="Sun exposure">Sun exposure</option>
		<option value="Topical Application">Topical Applicatione</option>
		<option value="Others-Option to capture">Others-Option to capture</option>
		</select>
		</td> -->
    </tr>
      </table>
  </div>
  
  <input type="hidden" name="primaryLesionCount" id="primaryLesionCount" value="1" />
   <div class="clear"></div>
   <label>Others</label>
	<input type="text"  id="primaryLessionOthers" name="primaryLessionOthers" tabindex="1" value=""  />		
	<div class="clear"></div>	
  <div class="paddingTop5"></div>
  
  <div class="clear"></div>
<input type="button" class="buttonAdd" alt="Add" tabindex="4"	value="&nbsp;" onclick="addRowForSecondaryLesion();" />
<input type="button" class="buttonDel" tabindex="3" alt="Delete" value="&nbsp;" onclick="removeRowForTreatmentHistory();" />
  <div class="clear"></div>
  <div style="width: 875px; height: 150px; overflow: scroll;" class="tableForTab">
  <table width="500" border="0" cellpadding="5" cellspacing="0" style="width:600px; float:left;" class="tablestyle" id="secondaryLessionGrid"> 
    <tr>
    <th align="center"></th>
      <th align="center">Secondary Lesion</th>
      <th align="center">Number</th>
      <th align="center">Site</th>
      <th align="center">Type of Lesions</th>
      <th align="center">Pigmentation</th>
       <!-- <th align="center">Character</th> -->
       <th align="center">Border</th>
       <th align="center">Surface</th>
       <th align="center">Size</th>
        <th align="center">Hair on Lesion</th>
         <th align="center">Additional Feature</th>
    </tr>
    <tr>
      <td><input  type="checkbox" class="radioCheck" name="secondaryLesionRadio1" id="secondaryLesionRadio1" /></td> 
		<td>
		<select name="secondaryLesion1" id="secondaryLesion1">
		<option value="">Select</option>
		<option value="Erosion">Erosion</option>
		<option value="Ulcer">Ulcer</option>
		<option value="Scale">Scale</option>
		<option value="Crust">Crust</option>
		<option value="Lichenification">Lichenification</option>
		<option value="Vesicle">Vesicle</option>
		</select>
		</td>
     <td>
		<select name="secondaryLesionNo1" id="secondaryLesionNo1">
		<option value="">Select</option>
		<option value="Single">Single</option>
		<option value="Multiple">Multiple</option>
		<option value="Generalized">Generalized</option>
		</select>
		</td>
      <td align="left"><input  type="text" maxlength="120" validate="Duration,metachar,no" tabindex="1" value="" name="secondaryLesionSite1" ></td>
      
      <td>
		<select name="typeOfSecondaryLesion1" id="typeOfSecondaryLesion1">
		<option value="">Select</option>
		<option value="Discrete">Discrete</option>
		<option value="Confluent">Confluent</option>
		</select>
		</td>
     <td>
		<select name="secondaryPigmentation1" id="secondaryPigmentation1">
		<option value="">Select</option>
		<option value="Y">Yes</option>
		<option value="n">No</option>
		</select>
		<div class="clear"></div>
        <div class="paddingTop15"></div>
        <div class="clear"></div>
		<select name="secondaryPigmentationValue1" id="secondaryPigmentationValue1">
		<option value="">Select</option>
		<option value="Erythematous">Erythematous</option>
		<option value="Violaceous">Violaceous</option>
		<option value="Hypo pigmented">Hypo pigmented</option>
		<option value="Hyper pigmented">Hyper pigmented</option>
		<option value="Di pigmented">Di pigmented</option>
		</select>
		</td>
		  <!-- <td>
		<select name="secondaryCharacter1" id="secondaryCharacter1">
		<option value="">Select</option>
		<option value="Flat">Flat</option>
		<option value="Raised">Raised</option>
		<option value="Fluid Filled">Fluid Filled</option>
		<option value="Raised">Raised</option>
		</select>
		</td> -->
		<td>
		<select name="secondaryBorder1" id="secondaryBorder1">
		<option value="">Select</option>
		<option value="Well defined">Well defined</option>
		<option value="Partially Ill Defined">Partially Ill Defined</option>
		<option value="Ill Defined">Ill Defined</option>
		</select>
		</td>
		<td>
		<select name="secondarySurface1" id="secondarySurface1">
		<option value="">Select</option>
		<option value="Smooth">Smooth</option>
		<option value="Rough">Rough</option>
		<option value="Dry">Dry</option>
		</select>
		</td>
		<td align="left"><input  type="text" maxlength="120" validate="Duration,metachar,no" tabindex="1" value="" name="secondarySmallestSize1" >
		<label class="smallAuto autoSpace">Smallest Lesion</label>
		<input  type="text" maxlength="120" validate="Duration,metachar,no" tabindex="1" value="" name="secondaryLargestSize1" >
		<label class="smallAuto autoSpace">Largest Lesion</label></td>
		<td>
		<select name="hairOnSecondaryLesion1" id="hairOnSecondaryLesion1">
		<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="De pigmented">De pigmented</option>
		</select>
		</td>
		
		<td><input  type="text"  validate="Additional Feature,metachar,no" tabindex="1" value="" name="secondaryAdditionalFeature1" ></td>
		<!-- <td>
		<select name="secondaryAggravatingFactors1" id="secondaryAggravatingFactors1">
		<option value="">Select</option>
		<option value="Sweating">Sweating</option>
		<option value="Sun exposure">Sun exposure</option>
		<option value="Topical Application">Topical Applicatione</option>
		<option value="Others-Option to capture">Others-Option to capture</option>
		</select>
		</td> -->
    </tr>
     </table>
     </div>
  <input type="hidden" name="secondaryLesionCount" id="secondaryLesionCount" value="1" />
   <div class="clear"></div>
		 <label>Others</label>
	<input type="text"  id="secondaryLessionOthers" name="secondaryLessionOthers" tabindex="1" value=""  />
	<div class="clear"></div>		
						
						
						<%} %>
						<%} %>
						<input type="hidden" name="count" value="<%=count%>">
		<%}else{ %>
		<h4>No Record Found</h4>
		<% } %>
</div>
