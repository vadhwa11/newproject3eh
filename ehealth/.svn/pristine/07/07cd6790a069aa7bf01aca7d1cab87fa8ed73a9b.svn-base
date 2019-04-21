<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * patientDetail.jsp  
 * Purpose of the JSP -  This is for Patient Details.
 * @author  Ritu
 * @author  Deepti
 * Create Date: 09th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>

<%@ page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<br />
<div id="contentspace">
<%	
	Map map = new HashMap();
		String includedJsp="";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		Patient patient=(Patient)map.get("patient");
		String  fathername="";
		String age="",hinNo="";
		String serviceNo="";
		String mobileNo="";
		String bloodGroup="";
		String patientType="";
		String doctorName="";
		String patientName="";
		String sex="",mob="",email="";
		String serviceValidityCard="";
		String yearMonth = "";
		int patientAge = 0;
		String relationName = "";
		String relativeName = "";
		String rsbyCaredNo = "";
		String occupationName = "";
		String education = "";
		
		if(patient!=null){
			if(patient.getHinNo()!=null){
				hinNo=patient.getHinNo();
			}
			if(patient.getPFirstName()!=null){
				patientName=patient.getPFirstName();
			}
			if(patient.getPMiddleName()!=null){
				patientName += " "+patient.getPMiddleName();
			}
			if(patient.getPLastName()!=null){
				patientName += " "+patient.getPLastName();
			}
			if(patient.getPLastName()!=null){
				patientName += " "+patient.getPLastName();
			}
			if(patient.getBloodGroup()!=null){
				bloodGroup= patient.getBloodGroup().getBloodGroupName();
			}
			if(patient.getBloodGroup()!=null){
				bloodGroup= patient.getBloodGroup().getBloodGroupName();
			}
			if(patient.getBloodGroup()!=null){
				patientType =patient.getPatientType().getPatientTypeName();
			}
			if(patient.getEmp()!=null){
				doctorName =patient.getEmp().getEmployeeName();
			}
			if(patient.getFatherMotherName()!=null && !patient.getFatherMotherName().equals("")){
				fathername =patient.getFatherMotherName();
			}
			if(patient.getAge()!=null && !patient.getAge().equals("")){
				age =patient.getAge();
			}
			if(patient.getServiceNo()!=null){
				serviceNo =patient.getServiceNo();
			}
			if(patient.getServiceCardValidityDate()!=null){
				serviceValidityCard =HMSUtil.convertDateToStringTypeDateOnly(patient.getServiceCardValidityDate());
			}
			if(patient.getSex()!=null){
				sex=patient.getSex().getAdministrativeSexName();
			}
			if(patient.getMobileNumber()!=null){
				mob=patient.getMobileNumber();
			}
			if(patient.getEmailId()!=null){
				email=patient.getEmailId();
			}
			if(patient.getPatientAge() !=null){
				patientAge=patient.getPatientAge();
			}
			if(patient.getRelation()!=null){
				relationName=patient.getRelation().getRelationName();
			}
			if(patient.getOccupation()!=null){
				occupationName=patient.getOccupation().getOccupationName();
			}
			if(patient.getEducation()!=null){
				education=patient.getEducation().getQualificationName();
			}
			if(relationName.equalsIgnoreCase("Husband")){
				if(patient.getFatherMotherName() != null){
					relativeName= patient.getFatherMotherName();
				}
			}
			
			if(patient.getRsbyCardNo()!=null){
				rsbyCaredNo=patient.getRsbyCardNo();
			}
			
			
			/* Added by Arbind on 26-04-2017 */
			if(patient.getDateOfBirth()!=null){
				Date dob=patient.getDateOfBirth();
				String ymd=HMSUtil.calculateYearMonthDay(dob);
				String d[]=ymd.split("&");
				int year1=Integer.parseInt(d[0].toString());
				int months1=Integer.parseInt(d[1].toString());
				int days1=Integer.parseInt(d[2].toString());
				yearMonth = year1 != 0 ? d[0] + " Y " : "";
				yearMonth += year1 < 18 && months1 != 0 ? d[1] + " M " : "";
				yearMonth += year1 < 5 && days1 != 0 ? d[2] + " D" : "";
			}
		}
%> <br />
<br />
<div class="Block" >
<form name="preConsultationScreen" action="" method="post">
<label>Patient Details</label>
<div class="clear"></div>
<label>UHID</label>
<input name="uhid" id="uhid" type="text" value="<%=hinNo%>" validate="uhid,string,no"  readonly="readonly" />
<label>Patient Name</label>
<input name="patientname" id="patientname" type="text" value="<%=patientName%>"	validate="patientname,string,no" readonly="readonly" />

<div class="clear"></div>
<label>Father Name</label>
<input name="fathername" type="text" value="<%=fathername%>"	validate="patientname,string,no" readonly="readonly" />
<div class="clear"></div>
<label>Gender</label>
<input name="gender" id="gender" type="text" value="<%=sex%>"	validate="gender,string,no"   readonly="readonly"/>
<label>Age</label>
<input name="age" id="age" type="text" value="<%=yearMonth%>"	validate="age,string,no" maxlength="3"  readonly="readonly" />

<div class="clear"></div>
<label>Blood Group</label>
<input type="text" value="<%=bloodGroup%>"	validate="age,string,no" maxlength="3"  readonly="readonly" />
<label>Patient Type</label>
<input  type="text" value="<%=patientType%>"	validate="gender,string,no"   readonly="readonly"/>

<div class="clear"></div>
<label>Registration Card Validity Date</label>
<input type="text" value="<%=serviceValidityCard%>"	validate="gender,string,no"  readonly="readonly"/>



<label>Doctor Name</label>
<input  type="text" value="<%=doctorName%>"	validate="gender,string,no"   readonly="readonly"/>
<div class="clear"></div>
<label>Mobile No</label>
<input  type="text" value="<%=mob%>"	validate="gender,string,no"  readonly="readonly"/>
<label>Email</label>
<input  type="text" value="<%=email%>"	validate="age,string,no" maxlength="3" readonly="readonly" />
<div class="clear"></div>
<%if(patientAge>60 && patientAge<18 || sex.equalsIgnoreCase("Female") ){
	%>
<label>Relation</label>
<%if(relationName != null && relationName.equalsIgnoreCase("Husband")){ %>	
<input  type="text" value="<%=relationName%>"	validate="gender,string,no"   readonly="readonly"/>
<%}else{ %>
<input  type="text" value=""	validate="gender,string,no"   readonly="readonly"/>
<%} %>

<label>Husband Name</label>
<input  type="text" value="<%=relativeName != null?relativeName:""%>"	validate="gender,string,no"   readonly="readonly"/>
<div class="clear"></div>
<label>Rsby Card No.</label>
<input  type="text" value="<%=rsbyCaredNo != null?rsbyCaredNo:""%>"	validate="gender,string,no"   readonly="readonly"/>


<label>Education</label>
<input  type="text" value="<%=education != null?education:""%>"	validate="gender,string,no"   readonly="readonly"/>
<div class="clear"></div>
<label>Occupation</label>
<input  type="text" value="<%=occupationName != null?occupationName:""%>"	validate="gender,string,no"   readonly="readonly"/>
<div class="clear"></div>

<%} %>


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div style="margin-left:80px">
<input type="button" class="button" value="Close" onclick='window.close()'/>
</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	
</div>