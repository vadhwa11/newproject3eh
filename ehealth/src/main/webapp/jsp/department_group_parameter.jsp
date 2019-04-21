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

<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.MasSpecialtyTemplate"%>
<%@page import="jkt.hms.masters.business.MasSpecialityDeptGroup"%>
<%@page import="jkt.hms.masters.business.SpDeptGroupT"%>
<%@page import="jkt.hms.masters.business.SpDeptGroupM"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>

<%@page import="jkt.hms.masters.business.MasSpecialtyGroupParameter"%>
<%@page import="jkt.hms.masters.business.MasSpecialityParameter"%>
<%@page import="jkt.hms.masters.business.MasSpecialityGroup"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasSpecialityGroup"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		
		List<MasSpecialityDeptGroup>  masSpDepGrp = new ArrayList<MasSpecialityDeptGroup>();
		List<MasSpecialtyGroupParameter> masSpGrpList = new ArrayList<MasSpecialtyGroupParameter>();
		List<MasDepartment> masDpList = new ArrayList<MasDepartment>();
		List<MasDepartment> masDpGridList = new ArrayList<MasDepartment>();
		List<MasSpecialityGroup> masSpGroup = new ArrayList<MasSpecialityGroup>();
		List<MasSpecialtyTemplate> masTempl = new ArrayList<MasSpecialtyTemplate>();
		
		
		String userName = "";
		
				
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		
		 if(map.get("masSpGrpList") != null){
			masSpGrpList = (ArrayList)map.get("masSpGrpList");
		} 
			
	   
	    if(map.get("masDpList") != null){
	    	masDpList = (List<MasDepartment>)map.get("masDpList");
	      }
	    
	    
	    if(map.get("masSpGrpPara")!=null){
	    	masSpGrpList=(List<MasSpecialtyGroupParameter>)map.get("masSpGrpPara");
	    } 
	    
	
	    if(map.get("masSpDepGrp")!=null){
	    	masSpDepGrp=(List<MasSpecialityDeptGroup>)map.get("masSpDepGrp");
	    } 
	    
	   
	    if(map.get("masDpGridList")!=null){
	    	masDpGridList=(List<MasDepartment>)map.get("masDpGridList");
	    } 
	    
	   
	    if(map.get("masTempl")!=null){
	    	masTempl=(List<MasSpecialtyTemplate>)map.get("masTempl");
	    } 
	    if(map.get("masSpGroup")!=null){
	    	masSpGroup=(List<MasSpecialityGroup>)map.get("masSpGroup");
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
	List<MasDepartment> masDepartments=new ArrayList<MasDepartment>();
	if(map.get("departments") != null){
		masDepartments = (List<MasDepartment>)map.get("departments");
	}
	if(map.get("message") != null){
		  String message = (String)map.get("message");
		  
		   %>

<h4>
	<span><%=message %></span>
</h4>
<%}
	int pageNo = 0;
	if(map.get("pageNo") != null){
		pageNo = (Integer)map.get("pageNo");
	}
%>

<div class="titleBg">
	<h2>Department Wise Group Parameter Master</h2>
</div>
<div class="Block">
	<div id="searcharea">
		<div id="searchbar">
			<form name="search" method="post" action="">
				<label> Department </label>
				<%-- <input type="text" id="searchField"
					name="<%= SEARCH_FIELD%>" value="" validate="Department ,string,no"
					MAXLENGTH="8" tabindex=1
					onkeypress="return submitenter(this,event,'generalMaster?method=searchDepartmentGroupParameter')" />
					
					//onchange="return submitenter(this.value,event,'generalMaster?method=showDepartmentGroupParameter')"
					 --%>
				
				<select id="searchField"  name="searchField" >
				<option value="0">Select</option>
				<%for(MasDepartment msd:masDepartments) {%>
					<option value="<%=msd.getId()%>"><%=msd.getDepartmentName() %></option>
				<%} %>
				</select>
				
				<label> Template </label>
				<select id="searchTemplate"  name="searchTemplate" >
				<option value="0">Select</option>
				<%for(MasSpecialtyTemplate masSpecialtyTemplate:masTempl) {%>
					<option value="<%=masSpecialtyTemplate.getId()%>"><%=masSpecialtyTemplate.getTemplateName() %></option>
				<%} %>
				</select>
				
				
				
				<input type="button" name="search" value="Search" class="button"
					id="searchField"
					onclick="submitForm('search','generalMaster?method=showDepartmentGroupParameter','checkSearch')"
					tabindex=1 />
				<%--- Report Button   --%>


			
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


		</div>
	</div>
	<div class="clear"></div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
	<div id="searchtable" tabindex=2></div>
	<% 
		if(masSpDepGrp.size()>0 || masSpDepGrp.size() > 0)
		 {
			String strForCode = (String)map.get("groupCode");
			String strForCodeDescription = (String)map.get("groupName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%><h4>
		<a href="generalMaster?method=showDepartmentGroupParameter">Show
			All Records </a>
	</h4>
	<%
			}
		 }
	 if(masSpDepGrp.size()==0 && map.get("search") != null)
	  {
	 %>
	<h4>
		<a href="generalMaster?method=showDepartmentGroupParameter">Show
			All Records</a>
	</h4>
	<%
     }
	%>
	<script type="text/javascript">

	formFields = [
	 			[0, "<%= COMMON_ID%>", "id"], [1,"dpartName"], [2,"tempLate"], [3,"grpName"], [4,"parameter"], [5,"<%=VALUE_TYPE%>"],  [6,"<%= IMG_REQ%>"], [7,"snoGp"],[8,"snoPa"],[9,"<%= STATUS%>"],[10,"checkbox"],[11,"nadRequired"],[12,"noOfFields"],[13,"dateFields"],[14,"grid"],[15,"simpleFormType"]
	 			,[16,"mediumFormType"],[17,"complexFormType"],[18,"radioText1"],[19,"radioDefault1"],[20,"radioText2"],[21,"radioDefault2"],[22,"unitLabel"],[23,"textMaxLength"]
	 			,[24,"dataType"],[25,"extraLov"],[26,"textFont"],[27,"textColor"],[28,"textSize"],[29,"validationValue"]];
	 statusTd = 9;

	</script>
</div>


<form name="departmentGroup" method="post" action="" enctype="multipart/form-data"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<input type="hidden" name="<%= POJO_NAME %>"value="MasSpecialityDeptGroup" />
 <input type="hidden"		name="<%=POJO_PROPERTY_NAME %>" value=""> 
 <input type="hidden"			name="<%=POJO_PROPERTY_CODE %>" value="">
  <input				type="hidden" name="title" value="DepartmentGroup">
   <input	type="hidden" name="<%=JSP_NAME %>" 	value="department_group_parameter"> 
   <input type="hidden"	name="pojoPropertyCode" value="SpGroup">

							<div class="paddingTop5"></div>
							<div class="clear"></div>
							<div class="Block">

								<label><span>*</span>Department</label> 
								<select id="dpartName"	name="<%= CODE%>" validate="Department,string,yes" tabindex=1>
									<option value="0">Select</option>
									<% 
				             for ( MasDepartment masDepartment: masDpList){
				            %>
									<option value="<%=masDepartment.getId ()%>"><%=masDepartment.getDepartmentName()%></option>
									<%}%>

								</select> 
								<label><span>*</span>Template</label> 
								<select name="tempLate" id="tempLate" validate="Template,string,yes"  tabindex=1>

									<option value="0">Select</option>

									<% 
				              for ( MasSpecialtyTemplate masTampList : masTempl){
				                     %>
									<option value="<%=masTampList.getId()%>"><%=masTampList.getTemplateName()%></option>
									<%}%>


								</select>

								<div class="clear"></div>

								<label> Group </label> 
								<select name="grpName"	validate="Group,string,yes" tabindex=1 onchange="onGroupChange(this.value);displayGroupSeq(this.value);"  >
									<option value="0">Select</option>
									<% 
									List<Integer> list=new ArrayList<Integer>();
				              		for (MasSpecialtyGroupParameter masGroupPara: masSpGrpList)
				              		{
				            	     if(!list.contains(masGroupPara.getSpGroup().getId()))
				            	     {
				            	    	 list.add(masGroupPara.getSpGroup().getId());
				                     %>
									<option value="<%=masGroupPara.getSpGroup().getId()%>"><%=masGroupPara.getSpGroup().getSpGroupName().trim()%></option>
									<%}
									}%>

								</select> 
								<label style="width: 105px;">Group S.NO</label> 
								<input type="text" id="snoGp"	name="snoGp" class="smallest" validate="Group S.No,string,no" />

								<label style="width: 186px"><span>*</span> Parameter </label> 
								<select id="parameter"	name="parameter" validate="Parameter,string,yes" tabindex=1  style="width: 162px">
									<option value="0">Select</option>
									<% 
			           				for (MasSpecialtyGroupParameter masGruplist : masSpGrpList){
				            			%>
										<option value="<%=masGruplist.getId()%>"><%=masGruplist.getSpParameter().getSpParameterName()%></option>
									<%}%>

								</select> 
								<label style="width: 135px;">Parameter S.NO</label>
								<input type="text" id="snoPa" name="snoPa" class="smallest"  validate="Parameter S.No,string,no" onkeypress="return isNumberKey(event)" />

								
								<div class="clear"></div>
								<div class="clear"></div>
								<label><span>*</span> Value Type</label> 
								<select	name="<%=VALUE_TYPE%>" onchange="fun(this.value),displayValueType(this.value);" id="valueTypeId" validate="Value Type,string,yes" tabindex=1>
									<option value="">Select</option>
									<option value="Text">Text Box</option>
									<option value="LOV">LOV</option>
									<option value="TEXT AREA">Text Area</option>
									<option value="CHECK BOX">Check Box</option>
									<option value="RADIO BUTTON">Radio Button</option>

								</select> 
							<div id="radioDiv" style="display: none"> 
                             <label>Radio Text1</label>
                            <input type="text" value="" name="radioText1" id="radioText1" validate="No. Of field,string,no"  maxlength="" onblur="copyRadioText1Value(this.value)"/>
                          
                            <label>Radio Default1</label>
                            <input type="checkbox" value="" name="radioDefault1" id="radioDefault1"  class="inputRadiobutton"  onclick="disableRadioCheckBox();"/>
                            	<div class="clear"></div>
                             <label>Radio Text2</label>
                            <input type="text" value="" name="radioText2" id="radioText2"  validate="No. Of field,string,no"  maxlength="" onblur="copyRadioText2Value(this.value)"/>
                          
                            <label>Radio Default2</label>
                            <input type="checkbox" value="" name="radioDefault2" id = "radioDefault2"   class="inputRadiobutton" onclick="disableRadioCheckBox();"/>
                            </div>
                            <div id="multipleSelectionDiv" style="display: none">	
                             <label>Multiple Selection</label>
                            <input type="checkbox" value="y" name="multipleSelection" id="multipleSelectionId"  validate="Multiple Selection,string,no"  maxlength="1" class="inputRadiobutton" />
                            
                            	</div>
                           
                             <label>Extra Text Box</label>
                            <input type="checkbox" value="t" name="checkbox" class="inputRadiobutton" />
                            
                             
                 			
                       	 	<div id="dateDiv" style="display: none">	
                            <label>Date</label>
                            <input type="checkbox" value="y" name="dateFields"  validate="Date Field,int,no"  maxlength="1" class="inputRadiobutton"  />
                            </div>
								<div class="clear"></div>
                            <label>Grid</label>
                            <input type="checkbox" value="y" name="grid"  validate="Grid,string,no"  maxlength="1" class="inputRadiobutton" />
								
                            <label><span>*</span>Image Required</label> 
								<select	name="<%= IMG_REQ%>" onchange="fun2(this.value)" validate="Image,string,no" tabindex=1>
									<option value="">Select</option>
									<option value="Yes">Yes</option>
									<option value="NO">NO</option>
								</select>
                                                        
                            <label>No. of fields</label>
                            <input type="text" value="" name="noOfFields"  validate="No. Of field,int,no"  maxlength="1"/>
                            
                             <label>Unit Label</label>
                            <input type="text" value="" name="unitLabel"  validate="Unit Label,string,no"  maxlength="8"/>
                            
                            <label>Maxlength</label>
                            <input type="text" value="" name="textMaxLength"  validate="Maxlength,int,no"  maxlength="3"/>
                            
                            <label> Data Type</label> 
								<select	name="dataType"  id="dataTypeId" validate="Data Type,string,no" tabindex=1>
									<option value="">Select</option>
									<option value="int">Integer</option>
									<option value="string">Alphanumeric</option>
									<option value="string">Character</option>
								</select> 
                          
                          <div class="clear"></div>
                            <label>NAD Required</label>
                            <input type="checkbox" value="y" name="nadRequired"  class="inputRadiobutton" />
                            
                             
                            <label>Extra LOV</label>
                            <input type="checkbox" value="l" name="extraLov" class="inputRadiobutton" onclick="fun(this.value);" />
                                                        
                             <label>Text Font</label>
                            <input type="text" value="" name="textFont"  validate="Text Font,string,no"  maxlength="60"/>
                            
                            <div class="clear"></div>
                             <label>Text Color</label>
                            <input type="text" value="" name="textColor"  validate="Text Color,string,no"  maxlength="60"/>
                            
                              <label>Text Size</label>
                            <input type="text" value="" name="textSize"  validate="Text Size,string,no"  maxlength="60"/>
                            
                            <label>Validation Value</label>
                            <input type="text" value="" name="validationValue"  validate="Validation Value,string,no"  maxlength="60"/>
                            
                            <div class="clear"></div>
                             
                        	<h4>Form Type</h4>
                              
                            <label>Primary Care</label>
                            <input type="checkbox" value="y" name="simpleFormType" class="inputRadiobutton"  id="simpleFormType" validate="Simple,string,no"  maxlength="1"/>
                        
                           
                            <label>Secondary Care</label>
                            <input type="checkbox" value="y" name="mediumFormType" class="inputRadiobutton"  id="mediumFormType"   validate="Medium,string,no"  maxlength="1"/>
                        
                           
                            <label>Tertiary Care</label>
                            <input type="checkbox" value="y" name="complexFormType" class="inputRadiobutton"  id="complexFormType"   validate="Complex,string,no"  maxlength="1"/>
                        
                           <div id="testDiv">
                           	<div class="clear"></div>
								<div class="Block">
									<div id="view" style="display: none">

										<table id="safetyPM">
										<input class="buttonAdd" type="button" onclick="add1()" value="" name="Add" />
										 <input	class="buttonDel" type="button" onclick="removeRow()" value="" name="delete" />
											<tr>
											<th></th>
												<th>Values</th>
												<th>Default Value</th>
												<th>Extra Text</th>
									
											</tr>
											<tr>
												<td><input type='checkbox' name='Item' id='Item1' /></td>
												<td><input type='text' name='values' id='values' value="" /></td>
												<td><input type="radio" name="defVal" id="defaultValues1" value="y" onclick="setDefVal(1)"/>
												<input type="hidden" name="defaultValues" id="defVal1" value="y" />
												</td>
												<td><input type="radio" name="ext" id="extraText1" value="y" onclick="setExtVal(1)"/>
												
												<input type="hidden" name="extraText" id="ext1" value="y" />
												</td>
												
											</tr>
										</table>
									</div>
								</div>
								</div>
							<!-- <input name="view" type="button" class="button" value="View Template" onclick="openPopupForTemplate()" />
							 -->	<div class="Block">
									<div id="view2" style="display: none">

										<table id="safetyP">
											<tr>
												<th>Image</th>
											</tr>
<tr>
											<td><input type="file" name="<%=UPLOAD_FILENAME%>1"
												id="<%=UPLOAD_FILENAME%>1" class="browse" /></td>
											</tr>
										</table>
									</div>
								</div>

	
								<script>
								
	 document.departmentGroup.<%=CODE%>.focus();
			</script>

							<div class="clear"></div>
							<div id="edited"></div> <input type="button" name="add"
							id="addbutton" value="Add" class="button"
							onClick="submitForm('departmentGroup','generalMaster?method=addDepartmentGroupParameter&'+csrfTokenName+'='+csrfTokenValue,'checkFormType');"
							accesskey="a" tabindex=1 /> <input type="button" name="edit"
							id="editbutton" value="Update" style="display: none;"
							class="button"
							onClick="submitForm('departmentGroup','generalMaster?method=editDepartmentGroupParameter&'+csrfTokenName+'='+csrfTokenValue)"
							accesskey="u" tabindex=1 /> <input type="button" name="Delete"
							id="deletebutton" value="Activate" class="button"
							style="display: none;"
							onClick="submitForm('departmentGroup','generalMaster?method=deleteDepartmentGroupParameter&flag='+this.value+'&'+csrfTokenName+'='+csrfTokenValue)"
							accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
							id="reset" value="Reset" class="buttonHighlight"
							onclick="resetCheck();" accesskey="r" /> <input type="hidden"
							name="<%=STATUS %>" value="" /> <input type="hidden"
							name="<%= COMMON_ID%>" value="" /> <input type="hidden"
							id="pageNoEdit" name="pageNoEdit" value="<%=pageNo%>" /> <!--  -->
							<div class="clear"></div>
							</div>
							<div class="bottom">
								<label> Changed By: </label> <label class="value"><%=userName%></label>
								<label> Changed Date: </label> <label class="value"><%=date%></label>
								<label> Changed Time: </label> <label class="value"><%=time%></label>
								<input type="hidden" name="<%=CHANGED_BY%>"
									value="<%=userName%>" /> <input type="hidden"
									name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
									type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
							</div>
</form>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Department"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "dpartName"

data_header[1] = new Array;
data_header[1][0] = "TempLate"
data_header[1][1] = "data";
data_header[1][2] = "";
data_header[1][3] = "tempLate";


data_header[2] = new Array;
data_header[2][0] = "Group"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "grpName";

data_header[3] = new Array;
data_header[3][0] = "Parameter"
data_header[3][1] = "data";
data_header[3][2] = "";
data_header[3][3] = "parameter";

data_header[4] = new Array;
data_header[4][0] = "Value Type"
data_header[4][1] = "data";
data_header[4][2] = "40%";
data_header[4][3] = "<%= VALUE_TYPE %>";


data_header[5] = new Array;
data_header[5][0] = "Image  Required"
data_header[5][1] = "data";
data_header[5][2] = "40%";
data_header[5][3] = "<%= IMG_REQ %>";

data_header[6] = new Array;
data_header[6][0] = "Group -S.NO"
data_header[6][1] = "data";
data_header[6][2] = "40%";
data_header[6][3] = "snoGp";

data_header[7] = new Array;
data_header[7][0] = "Parameter -S.NO"
data_header[7][1] = "data";
data_header[7][2] = "40%";
data_header[7][3] = "snoPa";



data_header[8] = new Array;
data_header[8][0] = "Status"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=STATUS %>";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = "15%";
data_header[9][3] = "checkbox";

data_header[10] = new Array;
data_header[10][0] = "NAD Required"
data_header[10][1] = "hide";
data_header[10][2] = "15%";
data_header[10][3] = "nadRequired";

data_header[11] = new Array;
data_header[11][0] = "No. of fields"
data_header[11][1] = "hide";
data_header[11][2] = "15%";
data_header[11][3] = "noOfFields";


data_header[12] = new Array;
data_header[12][0] = "Date"
data_header[12][1] = "hide";
data_header[12][2] = "15%";
data_header[12][3] = "dateFields";


data_header[13] = new Array;
data_header[13][0] = "Grid"
data_header[13][1] = "hide";
data_header[13][2] = "15%";
data_header[13][3] = "grid";

data_header[14] = new Array;
data_header[14][0] = "simpleFormType"
data_header[14][1] = "hide";
data_header[14][2] = "15%";
data_header[14][3] = "Primary Care";


data_header[15] = new Array;
data_header[15][0] = "mediumFormType"
data_header[15][1] = "hide";
data_header[15][2] = "15%";
data_header[15][3] = "Secondary Care";


data_header[16] = new Array;
data_header[16][0] = "complexFormType"
data_header[16][1] = "hide";
data_header[16][2] = "15%";
data_header[16][3] = "Tertiary sector";
	
data_header[17] = new Array;
data_header[17][0] = ""
data_header[17][1] = "hide";
data_header[17][2] = 0;
data_header[17][3] = "radioText1"

	data_header[18] = new Array;
data_header[18][0] = ""
data_header[18][1] = "hide";
data_header[18][2] = 0;
data_header[18][3] = "radioDefault1"

	data_header[19] = new Array;
data_header[19][0] = ""
data_header[19][1] = "hide";
data_header[19][2] = 0;
data_header[19][3] = "radioText2"

data_header[20] = new Array;
data_header[20][0] = ""
data_header[20][1] = "hide";
data_header[20][2] = 0;
data_header[20][3] = "radioDefault2"


	data_header[21] = new Array;
data_header[21][0] = ""
data_header[21][1] = "hide";
data_header[21][2] = 0;
data_header[21][3] = "unitLabel"


	data_header[22] = new Array;
data_header[22][0] = ""
data_header[22][1] = "hide";
data_header[22][2] = 0;
data_header[22][3] = "textMaxLength"


	data_header[23] = new Array;
data_header[23][0] = ""
data_header[23][1] = "hide";
data_header[23][2] = 0;
data_header[23][3] = "dataType"

	data_header[24] = new Array;
data_header[24][0] = ""
data_header[24][1] = "hide";
data_header[24][2] = 0;
data_header[24][3] = "extraLov"

	data_header[25] = new Array;
data_header[25][0] = ""
data_header[25][1] = "hide";
data_header[25][2] = 0;
data_header[25][3] = "textFont"

	data_header[26] = new Array;
data_header[26][0] = ""
data_header[26][1] = "hide";
data_header[26][2] = 0;
data_header[26][3] = "textColor"

	data_header[27] = new Array;
data_header[27][0] = ""
data_header[27][1] = "hide";
data_header[27][2] = 0;
data_header[27][3] = "textSize"

	data_header[28] = new Array;
data_header[28][0] = ""
data_header[28][1] = "hide";
data_header[28][2] = 0;
data_header[28][3] = "validationValue"


data_arr = new Array();


<%
Iterator itr=masSpDepGrp.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             MasSpecialityDeptGroup  masSpParameter = (MasSpecialityDeptGroup)itr.next(); 
%>
data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masSpParameter.getId()%>

<%
Iterator itrFroDepartment=masDpList.iterator();
while(itrFroDepartment.hasNext())
   {
	 
	 try{
		 MasDepartment  departmentTypeGrid = (MasDepartment)itrFroDepartment.next(); 
		if(masSpParameter.getDepartment()!=null){	 
	 if(masSpParameter.getDepartment().getId().equals(departmentTypeGrid.getId())){ %>
	 data_arr[<%= counter%>][1] = "<%=departmentTypeGrid.getDepartmentName().trim()%>"
	<%}else if(masSpParameter.getDepartment().getId().equals(departmentTypeGrid.getId())){%>
	 data_arr[<%= counter%>][1] = "<%=departmentTypeGrid.getDepartmentName().trim()%>"
		
	<%}
		}else{
			%>
			 data_arr[<%= counter%>][1] = "";
		<%}
   }catch(Exception e){e.printStackTrace();
   System.out.println("Error"+"----------");
   }}
   
   
   %>
  <%

  if(masSpParameter!=null && masSpParameter.getTemplate()!=null){
  	
  		for(MasSpecialtyTemplate template : masTempl){
  			if(template.getId().equals(masSpParameter.getTemplate().getId())){
  				
  %>
   	data_arr[<%= counter%>][2] = "<%=template.getTemplateName()%>";
   	<%}}}%>
   	
   	
   	
   
   	
   	
 <%--   <% Iterator itrForGrid=masSpGrpList.iterator();
   while(itrForGrid.hasNext())
      {
   	 try{
   		MasSpecialtyGroupParameter masSpecialGp = (MasSpecialtyGroupParameter)itrForGrid.next();
   		if(masSpParameter.getSpGroup()!=null && masSpecialGp!=null){
   			if(masSpecialGp!=null && masSpParameter.getSpGroup()!=null && masSpParameter.getSpGroup().getSpGroup()!=null){
	   			if(masSpParameter.getSpGroup().getSpGroup().getId().equals(masSpecialGp.getSpGroup().getId())){%>
	   		   	data_arr[<%= counter%>][3] ="<%=masSpecialGp.getSpGroup() != null?masSpecialGp.getSpGroup().getSpGroupName().trim():""%>"
	   		   	<%}else if(masSpParameter.getSpGroup().getSpGroup().getSpGroupName().equals(masSpecialGp.getSpGroup().getSpGroupName()) ){	%>
	   		   	data_arr[<%= counter%>][3] = "<%=masSpecialGp.getSpGroup() != null?masSpecialGp.getSpGroup().getSpGroupName().trim():""%>"
	   			<%}
   		}
  		 }else{
  			 %>
  			data_arr[<%= counter%>][3] = "<%=masSpecialGp.getSpGroup() != null?masSpecialGp.getSpGroup().getSpGroupName().trim():""%>"
  		 <%}
      }catch(Exception e){e.printStackTrace();
  		 System.out.println("Error in Group");   
      }
   	 }
      %> --%>
      
      <%
      Iterator itrForGrid=masSpGrpList.iterator();
      while(itrForGrid.hasNext())
         {
      	 
      	 try{
      		MasSpecialtyGroupParameter masSpecialGp = (MasSpecialtyGroupParameter)itrForGrid.next(); 
      		if(masSpParameter.getSpGroup()!=null && masSpecialGp!=null){
      			if(masSpParameter.getSpGroup().getId().equals(masSpecialGp.getId())){
      			%>
      			data_arr[<%= counter%>][3] = "<%= masSpecialGp.getSpGroup() != null?masSpecialGp.getSpGroup().getSpGroupName():""%>"
      		   	<%}else if(masSpParameter.getSpGroup().getId().equals(masSpecialGp.getId())){%>
      		   	data_arr[<%= counter%>][3] = "<%=masSpecialGp.getSpGroup() != null?masSpecialGp.getSpGroup().getSpGroupName():""%>"
      		<%}
      		}
         }catch(Exception e){e.printStackTrace();
      System.out.println("Error in Group");   
         }}
         %>
	  
      
      
      


<%-- 
<%
Iterator itrGridDepartmentTypeList=gridDepartmentTypeList.iterator();
 while(itrGridDepartmentTypeList.hasNext())
    {
	 
	 try{
     MasDepartmentType  departmentTypeGrid = (MasDepartmentType)itrGridDepartmentTypeList.next(); 
   
	 if(masDepartment.getDepartmentType().getId().equals(departmentTypeGrid.getId()) && departmentTypeGrid.getStatus().equalsIgnoreCase("y")){%>
		data_arr[<%= counter%>][3] = "<%=departmentTypeGrid.getDepartmentTypeName()%>"
	<%}else if(masDepartment.getId().equals(departmentTypeGrid.getId()) && departmentTypeGrid.getStatus().equalsIgnoreCase("n")){%>
		data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=departmentTypeGrid.getDepartmentTypeName()%>";
		
	<%}
    }catch(Exception e){e.printStackTrace();}}%>
 --%>



<%-- data_arr[<%= counter%>][1] = "<%=masSpParameter.getDepartment().getDepartmentName()%>" 


data_arr[<%= counter%>][2] = "<%= masSpParameter.getSpGroup().getSpGroup().getSpGroupName()%>"

--%>


<%
Iterator itrForPara=masSpGrpList.iterator();
while(itrForPara.hasNext())
   {
	 
	 try{
		MasSpecialtyGroupParameter masSpecialPa = (MasSpecialtyGroupParameter)itrForPara.next(); 
		if(masSpParameter.getSpGroup()!=null && masSpecialPa!=null){
			if(masSpParameter.getSpGroup().getId().equals(masSpecialPa.getId())){
			%>
			data_arr[<%= counter%>][4] = "<%= masSpecialPa.getSpParameter() != null?masSpecialPa.getSpParameter().getSpParameterName():""%>"
		   	<%}else if(masSpParameter.getSpGroup().getId().equals(masSpecialPa.getId())){%>
		   	data_arr[<%= counter%>][4] = "<%=masSpecialPa.getSpParameter().getSpParameterName()%>"
		<%}
		}
   }catch(Exception e){e.printStackTrace();
System.out.println("Error in Group");   
   }}
   %>


	
data_arr[<%= counter%>][5] = "<%= masSpParameter.getValueType() != null?masSpParameter.getValueType():""%>"
data_arr[<%= counter%>][6] = "<%= masSpParameter.getImageReq()!= null? masSpParameter.getImageReq():""%>"
	data_arr[<%= counter%>][7] = "<%= masSpParameter.getGroupSeqNo() != null?masSpParameter.getGroupSeqNo():""%>"
		data_arr[<%= counter%>][8] = "<%= masSpParameter.getParameterSeqNo() != null?masSpParameter.getParameterSeqNo():""%>"

	<% if(masSpParameter.getStatus().equalsIgnoreCase("y")){ %>
	data_arr[<%= counter%>][9] = "Active"
	<%}else{%>
	data_arr[<%= counter%>][9] = "InActive"
	<%}%>
	

	<% if(masSpParameter.getTextField() != null && masSpParameter.getTextField().equalsIgnoreCase("t")){ %>
	data_arr[<%= counter%>][10] = "y"
	<%}else{%>
	data_arr[<%= counter%>][10] = "n"
	<%}%>
	
	<% if(masSpParameter.getNadRequired() != null){ %>
	data_arr[<%= counter%>][11] = "<%=masSpParameter.getNadRequired()%>"
	<%}else{%>
	data_arr[<%= counter%>][11] = "n"
	<%}%>

	<% if(masSpParameter.getNoOfFields() != null){ %>
	data_arr[<%= counter%>][12] = "<%=masSpParameter.getNoOfFields()%>"
	<%}else{%>
	data_arr[<%= counter%>][12] = ""
	<%}%>
	
	<% if(masSpParameter.getDateField() != null && masSpParameter.getDateField().equalsIgnoreCase("y")){ %>
	data_arr[<%= counter%>][13] = "y"
	<%}else{%>
	data_arr[<%= counter%>][13] = "n"
	<%}%>
	
	<% if(masSpParameter.getGrid() != null && masSpParameter.getGrid().equalsIgnoreCase("y")){ %>
	data_arr[<%= counter%>][14] = "y"
	<%}else{%>
	data_arr[<%= counter%>][14] = "n"
	<%}%>
	
	<% if(masSpParameter.getSimpleFormType() != null && masSpParameter.getSimpleFormType().equalsIgnoreCase("y")){ %>
	data_arr[<%= counter%>][15] = "y"
	<%}else{%>
	data_arr[<%= counter%>][15] = "n"
	<%}%>
	
	
	<% if(masSpParameter.getMediumFormType() != null && masSpParameter.getMediumFormType().equalsIgnoreCase("y")){ %>
	data_arr[<%= counter%>][16] = "y"
	<%}else{%>
	data_arr[<%= counter%>][16] = "n"
	<%}%>
	
	
	<% if(masSpParameter.getComplexFormType() != null && masSpParameter.getComplexFormType().equalsIgnoreCase("y")){ %>
	data_arr[<%= counter%>][17] = "y"
	<%}else{%>
	data_arr[<%= counter%>][17] = "n"
	<%}%>
	
	<% if(masSpParameter.getRadioText1() != null){ %>
	data_arr[<%= counter%>][18] = "<%=masSpParameter.getRadioText1()%>"
	<%}else{%>
	data_arr[<%= counter%>][18] = ""
	<%}%>
	
	
	<% if(masSpParameter.getRadioDefault1() != null){ %>
	data_arr[<%= counter%>][19] = "y"
	<%}else{%>
	data_arr[<%= counter%>][19] = "n"
	<%}%>
	
	<% if(masSpParameter.getRadioText2() != null){ %>
	data_arr[<%= counter%>][20] = "<%=masSpParameter.getRadioText2()%>"
	<%}else{%>
	data_arr[<%= counter%>][20] = ""
	<%}%>
	
	<% if(masSpParameter.getRadioDefault2() != null){ %>
	data_arr[<%= counter%>][21] = "y"
	<%}else{%>
	data_arr[<%= counter%>][21] = "n"
	<%}%>
	
	<% if(masSpParameter.getTextMaxlength() != null){ %>
	data_arr[<%= counter%>][22] = "<%=masSpParameter.getUnitLabel()%>"
	<%}else{%>
	data_arr[<%= counter%>][22] = ""
	<%}%>
	
	<% if(masSpParameter.getUnitLabel() != null){ %>
	data_arr[<%= counter%>][23] = "<%=masSpParameter.getTextMaxlength()%>"
	<%}else{%>
	data_arr[<%= counter%>][23] = ""
	<%}%>
	
	<% if(masSpParameter.getDataType() != null){ %>
	data_arr[<%= counter%>][24] = "<%=masSpParameter.getDataType()%>"
	<%}else{%>
	data_arr[<%= counter%>][24] = ""
	<%}%>
	
	<% if(masSpParameter.getExtraLov() != null){ %>
	data_arr[<%= counter%>][25] = "<%=masSpParameter.getExtraLov()%>"
	<%}else{%>
	data_arr[<%= counter%>][25] = ""
	<%}%>
	
	<% if(masSpParameter.getTextFont() != null){ %>
	data_arr[<%= counter%>][26] = "<%=masSpParameter.getTextFont()%>"
	<%}else{%>
	data_arr[<%= counter%>][26] = ""
	<%}%>
	
	
	<% if(masSpParameter.getTextColor() != null){ %>
	data_arr[<%= counter%>][27] = "<%=masSpParameter.getTextColor()%>"
	<%}else{%>
	data_arr[<%= counter%>][27] = ""
	<%}%>
	
	<% if(masSpParameter.getTextSize() != null){ %>
	data_arr[<%= counter%>][28] = "<%=masSpParameter.getTextSize()%>"
	<%}else{%>
	data_arr[<%= counter%>][28] = ""
	<%}%>
	
	<% if(masSpParameter.getValidationValue() != null){ %>
	data_arr[<%= counter%>][29] = "<%=masSpParameter.getValidationValue()%>"
	<%}else{%>
	data_arr[<%= counter%>][29] = ""
	<%}%>
	
	

<%
       counter++;
}
%>


<%-- 
<%
Iterator itr=masGroupList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             MasSpecialityGroup  masGroup = (MasSpecialityGroup)itr.next(); 
%>


data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masGroup .getId()%>
data_arr[<%= counter%>][1] = "<%=masGroup .getSpGroupCode()%>"
data_arr[<%= counter%>][2] = "<%= masGroup .getSpGroupName()%>"
<%
		Iterator itrGridGroupList=gridGroupList.iterator();
		 while(itrGridGroupList.hasNext())
            {
			 MasSpecialityGroup  masGroupItr = (MasSpecialityGroup)itrGridGroupList.next(); 
            
			 if(masGroupItr.getSpGroupName().getId().equals(masGroupItr.getId()) && masGroupItr.getStatus().equalsIgnoreCase("y")){
			
			 %>
				data_arr[<%= counter%>][3] = "<%=masGroupItr.getSpGroupName()%>"
			<%}else if(masGroupItr.getSpGroupName().getId().equals(masGroupList.getId()) && masGroupList.getStatus().equalsIgnoreCase("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masGroupList.getSpGroupName()%>";
				
			<%}
}%>

data_arr[<%= counter%>][4] = "<%= masGroupList.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masGroupList.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masGroupList.getLastChgTime() %>
	"
<% if(masGroupList.getStatus().equalsIgnoreCase("y")){ %>
	data_arr[
<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 --%>
formName = "departmentGroup"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
	makeTable(start,end);
	
//pgNo = '<%=pageNo%>';
//totalPages = Math.ceil(data_arr.length/rowsPerPage);
//goToPage(pgNo);

intializeHover('searchresulttable', 'TR', ' tableover');	



function checkFormType(){
	if(!document.getElementById('simpleFormType').checked && !document.getElementById('mediumFormType').checked  && !document.getElementById('complexFormType').checked ){
		errorMsg += "Select Form Type Simple/ Medium/ Complex \n";
		//alert(errorMsg);
		return false;
		
	}
	return true;
}

function displayGroupSeq(val){
	var templateId = document.getElementById('tempLate').value;
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
	                         var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	                         for (loop = 0; loop < items.childNodes.length; loop++) {
	                                  var item = items.childNodes[loop];
	                               
	                           var grpSeq = item.getElementsByTagName("grpSeq")[0];
		                           if(grpSeq.childNodes[0] !=undefined){
		                                   document.getElementById('snoGp').value = grpSeq.childNodes[0].nodeValue;
		                           }else{
		                                   document.getElementById('snoGp').value = '';
		                           }
	                           
	                           
	                         }
	                 }
	                }
	               //alert("groupId=="+val);
	              // alert("templateId=="+templateId);
	               var url="/hms/hms/generalMaster?method=displayGroupSequence&groupId="+val+"&templateId="+templateId;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue;
	               xmlHttp.open("GET",url,true);
	               xmlHttp.setRequestHeader("Content-Type", "text/xml");
	               xmlHttp.send(null);
	           
	}
	

</script>

<script type="text/javascript">
	var masSpGrpList=new Array();
	 <% 
	 int x=0;
	 for (MasSpecialtyGroupParameter masGruplist : masSpGrpList){
		%>
		masSpGrpList[<%=x%>]=new Array();
		masSpGrpList[<%=x%>][0]='<%=masGruplist.getSpGroup().getId()%>';
		masSpGrpList[<%=x%>][1]='<%=masGruplist.getId()%>';
		masSpGrpList[<%=x%>][2]='<%=masGruplist.getSpParameter().getSpParameterName()%>';
		
		
		<%
	x++;	
	 }%>
	 
	 function onGroupChange(val){

		 var obj=document.getElementById('parameter');
		 obj.options.length=0;
		 var j=0;
		 for(var i=0;i<masSpGrpList.length;i++)
		
			 {
		
			 if(val==masSpGrpList[i][0])
				 {
				 obj.options[j] = new Option(masSpGrpList[i][2], masSpGrpList[i][1]);
				 j++;
				 }
			 }
	 }
	 
	 function copyRadioText1Value(val){
		 document.getElementById("radioDefault1").value=val;
		 
	 }
	 function copyRadioText2Value(val){
		 document.getElementById("radioDefault2").value=val;
		 
	 }
	 function disableRadioCheckBox(){
		 var textVal1 =document.getElementById("radioText1").value
		 var textVal2 = document.getElementById("radioText2").value 
	 if(document.getElementById("radioDefault1").checked ==true){
		//if(textVal1 != ''){
		 document.getElementById("radioDefault2").disabled = true;
		 document.getElementById("radioDefault1").disabled = false;
		//}
	 }else if(document.getElementById("radioDefault1").checked == false){
		// if(textVal2 != ''){
		 document.getElementById("radioDefault2").disabled = false;
		 document.getElementById("radioDefault1").disabled = true;
		 //}
	 }
		 
		 
	 }
	 
	function fun(val){
	
		if(document.getElementById("view")){
		if(val.trim()=="LOV"){
			document.getElementById("view").style.display="block";
		}else if(val.trim()=="l"){
			document.getElementById("view").style.display="block";
		
		}else{
			document.getElementById("view").style.display="none";
		}
		}
	}
	function fun2(val){
		document.getElementById("view2").style.display="none";
		if(val=="Yes"){
			document.getElementById("view2").style.display="";
		}
	}
	
	
	function add1(){
		var table=document.getElementById("safetyPM"); 
		var tableLength=table.rows.length;
		var iteration=tableLength;
		var row=table.insertRow(tableLength);
		var cell2 = row.insertCell(0);
		 var e2 = document.createElement('input');
		  e2.type = 'checkbox';
		  e2.name='Item';
		  e2.id='Item'+iteration;
		  cell2.appendChild(e2);
		  var e2 = document.createElement('input');
		  e2.type = 'hidden';
		  e2.name='ItemId';
		  e2.id='ItemId'+iteration;
		  cell2.appendChild(e2);
		  
		  var cell2 = row.insertCell(1);
		  var e2 = document.createElement('input');
		  e2.type = 'text';
		  e2.name='values';
		 
		  e2.id='values'+iteration;
		  cell2.appendChild(e2);
		  
		  var cell2 = row.insertCell(2);
		  var e2 = document.createElement('input');
		  e2.type = 'radio';
		  e2.name='defVal';
		  e2.value='y';
		  e2.id='defaultValues'+iteration;
		  e2.onclick=function() {setDefVal(iteration)};
		  cell2.appendChild(e2);
		  
		  var e21 = document.createElement('input');
		  e21.type = 'hidden';
		  e21.name='defaultValues';
		  e21.id='defVal'+iteration;
		  e21.value='';
		  cell2.appendChild(e21);
		  
		  
		  
		  var cell2 = row.insertCell(3);
		  var e3 = document.createElement('input');
		  e3.type = 'radio';
		  e3.name='ext';
		  e3.value='y';
		  e3.id='extraText'+iteration;
		  e3.onclick=function() {setExtVal(iteration)};
		  cell2.appendChild(e3);
		  
		  var e31 = document.createElement('input');
		  e31.type = 'hidden';
		  e31.name='extraText';
		  e31.id='ext'+iteration;
		  e31.value='';
		  cell2.appendChild(e31);
		 	 
	}
	function removeRow(){
		var table=document.getElementById("safetyPM"); 
		var tableLength=table.rows.length;
		var item=document.getElementsByName("Item");
		var itemLength=0;
		for(var i=0;i<item.length;i++){
			if(item[i].checked==true){
				itemLength=itemLength+1;
			}
		}
		if((itemLength+2)<=tableLength){
			for(var i=0;i<item.length;i++){
				if(item[i].checked==true){
					table.deleteRow(i+1);
				}
		}
		}else{
			alert("You Con't Delete!");
		}
	}
	
	function openPopupWindow()
	  {
	  	var id = document.getElementById('safetyP').value;
//	  	var mode = document.getElementById('mode').value;
	  	var url="/hms/hms/generalMaster?method=imageBowserJSP&RequestId="+id+'&'+csrfTokenName+'='+csrfTokenValue;
	   	newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
	  }
	
	function openPopupForTemplate() {
		//var tempLate = document.getElementById('tempLate').value;
		//var deptId = document.getElementById('dpartName').value;
		//alert("deptId==="+document.getElementById('dpartName').value);
		//alert("template==="+document.getElementById('tempLate').value);
		if (document.getElementById('tempLate').value != 0 && document.getElementById('dpartName').value != 0) {
			// var nomenclature1=document.getElementById("nomenclature1").value;
			var url = "/hms/hms/generalMaster?method=viewSpecialityTemplate&tempLate="+ document.getElementById('tempLate').value+"&deptId="+ document.getElementById('dpartName').value+ "&"+ csrfTokenName + "=" + csrfTokenValue;
			newwindow = window.open(url, 'opd_window',
					"height=420,width=1050,status=1,scrollbars=yes");
		} else {
			alert("Select Template and Department")
		}

	}
	function submitRecords(){

		var fname = document.getElementById('fileNameId').value;
		var ind1 = fname.lastIndexOf("\\");
		if(fname!="")
		{
		var filename = fname.substring(ind1+1);
		if(filename.lastIndexOf(".jpg")==-1){
		alert("File Type is InCorrect choose Another");
		document.getElementById('fileNameId').value="";
		}else{
		document.shareHolderLedger.method="post";
		submitForm('shareHolderLedger','/erp/erp/legal?method=saveShareHolderLedger&filename='+filename+'&'+csrfTokenName+'='+csrfTokenValue);
		}
		}else{
			document.shareHolderLedger.method="post";
			submitForm('shareHolderLedger','/erp/erp/legal?method=saveShareHolderLedger'+'&'+csrfTokenName+'='+csrfTokenValue);
			}
		
		
	}
	function displayValueType(val){
		
		if(val =='RADIO BUTTON'){
			document.getElementById('radioDiv').style.display = 'block';
		}else{
			document.getElementById('radioDiv').style.display = 'none';	
		}
		if(val =='LOV'){
			document.getElementById('multipleSelectionDiv').style.display = 'block';
		}else{
			document.getElementById('multipleSelectionDiv').style.display = 'none';	
		}
		
		if(val =='Text'){
			document.getElementById('dateDiv').style.display = 'block';
		}else{
			document.getElementById('dateDiv').style.display = 'none';	
		}
		
	}
	
	 function isNumberKey(evt)
     {
        var charCode = (evt.which) ? evt.which : event.keyCode
        if (charCode > 31 && (charCode<48||charCode>57))
               	
         return false;
        
        	
        return true;
     }
	
	 function setDefVal(itr){
		 var table=document.getElementById("safetyPM"); 
		 var tableLength=table.rows.length;
		 
		for(var i=1;i<tableLength;i++){
			 if(itr != i){
				 
				 document.getElementById('defVal'+i).value ='';
			 }
			 else {
				 document.getElementById('defVal'+itr).value ='y';
				 
			 }
		}
		 
		 
	 }
	 function setExtVal(itr){
		 //document.getElementById('ext'+itr).value ='y';
		 var table=document.getElementById("safetyPM"); 
		 var tableLength=table.rows.length;
		 
		for(var i=1;i<tableLength;i++){
			 if(itr != i){
				 
				 document.getElementById('ext'+i).value ='';
			 }
			 else {
				 document.getElementById('ext'+itr).value ='y';
				 
			 }
		}
		 
	 }
	</script>


