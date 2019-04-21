<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForOpdHinNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Hin Number Combo in patientPrescriptionReport.jsp
	 * @author  Create Date: 25.08.2008    Name: Mansi  
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasTitle"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasReligion"%>


<%@page import="jkt.hms.util.HMSUtil"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
	</script>


<%	
		Map map = new HashMap();
		List<Object[]> itemIdList = new ArrayList<Object[]>();
		List<Object[]> itemIdList1 = new ArrayList<Object[]>();
		List<MasTitle>titleList=new ArrayList<MasTitle>();
		List<MasAdministrativeSex>sexList=new ArrayList<MasAdministrativeSex>();
		List<MasReligion>religionList=new ArrayList<MasReligion>();
		String gr_no="";
		int schoolId=0;
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("itemIdList") != null){
			itemIdList =(List)map.get("itemIdList");
		}
		if (map.get("itemIdList1") != null){
			itemIdList1 =(List)map.get("itemIdList1");
		}
		if (map.get("gr_no") != null){
			gr_no =(String)map.get("gr_no");
		}
		if (map.get("titleList") != null){
			titleList =(List<MasTitle>)map.get("titleList");
		}
		if (map.get("sexList") != null){
			sexList =(List<MasAdministrativeSex>)map.get("sexList");
		}
		if (map.get("religionList") != null){
			religionList =(List<MasReligion>)map.get("religionList");
		}
		if (map.get("schoolId") != null){
			schoolId =(Integer)map.get("schoolId");
		}
	
%>
<div id="studentDiv1">
<%if(itemIdList!=null && itemIdList.size()>0){ %>
<%for(Object[] obj:itemIdList){ %>
<label>School</label>
<select	name="schoolId" id="schoolId" >
	<option value="">Select</option>
	<% 
	     	if (itemIdList1!=null && itemIdList1.size() > 0 ) 
	     	{ 
	     		for(Object[] object: itemIdList1){
	     			if(schoolId==(Integer)object[0]){
				%>
	<option value="<%=object[0]%>" selected="selected"><%=object[1]+" "+"["+object[2]+"]"%>
	</option>
	<% }else{%>
		<option value="<%=object[0]%>" selected="selected"><%=object[1]+" "+"["+object[2]+"]"%>
		
	<%}
	     		}
			} 
	     	 else
	     	 {
			 %>
	<script>
			 	document.getElementById('errorMsg').innerHTML='* No Record Found!!';
			 </script>
	<%
			  } 
	     	 %>
</select>
	     	 <label>Gr No</label>
	      <input type="text" name="gr_no" id="gr_no" value="<%=gr_no %>" onblur="submitProtoAjaxWithDivName('registration','opd?method=getstudentDetail1','studentDiv1');"/>

<div class="clear"></div>
<label>Title</label> <select id="titleId" name="<%=TITLE%>"
	validate="Title,string,no" tabindex="8" onChange="changeSex();">
	<option value="0">Select</option>
	<%
for (MasTitle masTitle : titleList)

{
if(masTitle.getTitleCode().equals("Mr.")){

%>
	<option value="<%=masTitle.getId() %>" selected="selected"><%=masTitle.getTitleName() %></option>
	<%		}else{ %>
	<option value="<%=masTitle.getId()%>"><%=masTitle.getTitleName()%></option>
	<%
}
}%>
</select> <input type="hidden" name="titleIdTemp" id="titleIdTemp" value="0" />
<div class="clear"></div>
<label><span>*</span> First Name</label> <input type="text"
	id="pFirstNameId" onchange="checkForPatientType();"
	name="<%=P_FIRST_NAME %>" value="<%=obj[6] %>" tabindex="9"
	title="First Name of the Patient" validate="First Name,alphaspace,no"
	MAXLENGTH="15" /> <input type="hidden" name="pFirstNameIdTemp"
	id="pFirstNameIdTemp" value="" /> <input type="hidden" name="flagPop"
	id="flagPop" value="" /> <!--
	Code For autocomplete show paitent detail if existing name
	Code By Mukesh Narayan Singh
	Date 13 July 2010
	 -->
<!-- <div id="ac2update" style="display: none;" class="autocomplete"></div> -->
<script type="text/javascript" language="javascript" charset="utf-8">
			//    new Ajax.Autocompleter('pFirstNameId','ac2update','registration?method=getPatientDetailForAutoComplete',{parameters:'requiredField=pFirstName'});

			</script>
			<label>Middle Name</label> <input type="text" id="pMiddleNameId"
	name="<%=P_MIDDLE_NAME%>" value="" tabindex="10"
	validate="Middle Name,name,no" MAXLENGTH="15" /> <input type="hidden"
	name="pMiddleNameIdTemp" id="pMiddleNameIdTemp" value="" /> <label>Last
Name</label> <input type="text" id="pLastNameId" name="<%=P_LAST_NAME %>"
	value="" validate="Last Name,alphaspace,no" MAXLENGTH="15"
	tabindex="11" onblur="openPopupForPatientDetail(this.value);"/> <input
	type="hidden" name="pLastNameIdTemp" id="pLastNameIdTemp" value="" />
<div class="clear"></div>
<label><span>*</span> Gender</label> <select id="gender"
	name="<%=GENDER %>" tabindex="12" onChange="changeGender();">
	<option value="0">Select</option>
	<%
for(MasAdministrativeSex masAdministrativeSex : sexList){
if((Integer)obj[10]==2){
%>
	<option value="2" selected="selected">Male</option>
	<%		}else{ %>
	<option value="3">Female</option>
	<%
}
} %>
</select> <input type="hidden" name="genderTemp" id="genderTemp" value="0" /> <label>DOB</label>

<input type="text" id="dobId" name="<%=DATE_OF_BIRTH %>" tabindex="13"  
	value="<%=HMSUtil.convertDateToStringTypeDateOnly((Date)obj[26]) %>"  readonly="readonly"
	onchange="calculateAgeInAjax('registration');" MAXLENGTH="30" />
<input type="hidden" name="dobIdTemp" id="dobIdTemp" value="" /> <label><span>*</span>
Age</label>

<div id="ageDiv"><input type="text" name="<%=AGE %>" id="age"
	value="<%=obj[22] %>" class="small" maxlength="2" tabindex="15" validate="Age,int,no"
	onblur="checkForDOB();" /> <input type="hidden" name="ageTemp"
	id="ageTemp" value="" /> <select id="ageUnitId" name="<%=AGE_UNIT %>"
	validate="AgeUnit,string,no" tabindex="16" class="small"
	onblur="checkForDOB();">
	<option selected="selected" value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select></div>
<input type="hidden" name="ageUnitIdTemp" id="ageUnitIdTemp" value="" />

<div class="clear"></div>

<label><span>*</span> Religion </label> <select name="<%=RELIGION %>"
	tabindex="17" id="religionId">
	<option value="0">Select</option>
	<%int religionId=(Integer)obj[9];
for(MasReligion masReligion : religionList){
if(masReligion.getId() == religionId){
%>
	<option value="<%=masReligion.getId()%>" selected="selected"><%=masReligion.getReligionName()%></option>
	<%}else{ %>
	<option value="<%=masReligion.getId()%>"><%=masReligion.getReligionName()%></option>
	<%}
}%>
</select> <input type="hidden" name="religionIdTemp" id="religionIdTemp"
	value="0" /> <label>Caste</label> <select id="casteId"
	name="<%=CASTE%>" validate="caste,string,no" tabindex="18">
	<option value="0">Select</option>
	<option value="1" selected="selected">Hindu</option>
	<option value="2">Christian</option>
	<option value="3">Muslim</option>
	<option value="4">Sikh</option>
	</select> <input type="hidden" name="casteIdTemp" id="casteIdTemp" value="0" />
<label>Address</label> <textarea name="<%=ADDRESS %>" id="addr"
	cols="20" rows="2" tabindex="19" validate="Address,string,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	onblur="fillNokAddr();"></textarea> 
<%} }%>
</div>