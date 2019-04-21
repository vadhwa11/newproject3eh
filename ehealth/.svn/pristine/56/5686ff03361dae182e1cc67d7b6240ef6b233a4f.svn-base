<%@ page import="java.util.*"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<link href="/hms/HrmsJsp/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/common.js"></script> 
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script> 
<%@page	import="jkt.hms.util.HMSUtil"%> 
<%@page	import="jkt.hms.masters.business.MasHospital"%> 
<%@page	import="java.math.BigDecimal"%> 
<%@page	import="jkt.hrms.masters.business.HrMasParameterMaintenance"%>
<%
		Map<String,Object> map = new HashMap<String,Object>();
	    List<HrMasParameterMaintenance> masParameterMaintenanceList = new ArrayList<HrMasParameterMaintenance>();
	    List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
	    if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if(map.get("masParameterMaintenanceList")!= null){
			masParameterMaintenanceList = (List)map.get("masParameterMaintenanceList");
		}
		if(map.get("masHospitalList")!= null){
			masHospitalList = (List)map.get("masHospitalList");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		int hospitalId = 0;
		
		if(masHospitalList.size()>0){
			MasHospital masHospital = masHospitalList.get(0);
			hospitalId = masHospital.getId();
		}
		int	parameterMaintenanceId = 0;
		float inspectionCharge=  0;
		String da = "";
		BigDecimal epsMaxLimit = null;
		float edli = 0;
		float adminCharge = 0;
		String headOfficeCode = "";
		int inServiceCode = 0;
		int leaveEncash = 0;
		int payType = 0;
		int noOfWorkingDays = 0;
		int retirementAge = 0;
		String volunatryContr = "";
		String	saturdayHoliday = "";
		String	sundayHoliday = "";
		float gratuity = 0;
		float superannuation= 0;
		int passwordExpiryDay= 0;
		float adminOnEdli= 0;
		float pensionFund= 0;
		String accountNoOfEpf = "";
		BigDecimal femaleTaxRebate= null;
		String	tanNo = ""; 
		String	panNo = "";
		float esiEmployeeCont= 0;
		float esiEmployerCont= 0;
		String nightShiftStart = "";
		String nightShiftEnd = "";
		float benefitPercentage= 0;
		String finalYrLeaveCalc = "";
		String includeHolidaysInLeave = "";
		String unusdLeaveForCaryOrEncash = "";
		String sickLeaveEligibility = ""; 
		String vacationLeaveEligibility = "";
		
		if(masParameterMaintenanceList.size()>0){
			
			for(HrMasParameterMaintenance hrMasParameterMaintenance : masParameterMaintenanceList){
			
			parameterMaintenanceId =(Integer) hrMasParameterMaintenance.getId();
			
			if(hrMasParameterMaintenance.getInspectionCharge()!=null) // added by amit das on 21-07-2016	
			 inspectionCharge = hrMasParameterMaintenance.getInspectionCharge();
			 
			
			if(hrMasParameterMaintenance.getHospital()!=null) // added by amit das on 21-07-2016
			 hospitalId = hrMasParameterMaintenance.getHospital().getId();
			
			 da = hrMasParameterMaintenance.getDa();
			 epsMaxLimit = hrMasParameterMaintenance.getEpsMaxLimit();
			 
			 if(hrMasParameterMaintenance.getEdli()!=null) // added by amit das on 21-07-2016
			 edli = hrMasParameterMaintenance.getEdli();
			 
			 if(hrMasParameterMaintenance.getAdminCharge()!=null) // added by amit das on 21-07-2016
			 adminCharge = hrMasParameterMaintenance.getAdminCharge();
			
			 headOfficeCode = hrMasParameterMaintenance.getHeadOfficeCode();
			 
			 if(hrMasParameterMaintenance.getInServiceCode()!=null) // added by amit das on 21-07-2016
			inServiceCode = hrMasParameterMaintenance.getInServiceCode();
			 
			if(hrMasParameterMaintenance.getLeaveEncash()!=null) // added by amit das on 21-07-2016
			 leaveEncash = hrMasParameterMaintenance.getLeaveEncash();
			 
			 if(hrMasParameterMaintenance.getPayType()!=null) // added by amit das on 21-07-2016
			 	payType = hrMasParameterMaintenance.getPayType();
			 
			 if(hrMasParameterMaintenance.getNoOfWorkingDays()!=null) // added by amit das on 21-07-2016
				noOfWorkingDays = hrMasParameterMaintenance.getNoOfWorkingDays();
				
			if(hrMasParameterMaintenance.getRetirementAge()!=null) // added by amit das on 21-07-2016
			 retirementAge = hrMasParameterMaintenance.getRetirementAge();
			
			volunatryContr = hrMasParameterMaintenance.getVolunatryContr();
			saturdayHoliday = hrMasParameterMaintenance.getHoliday1();
			sundayHoliday = hrMasParameterMaintenance.getHoliday2();
			
			 if(hrMasParameterMaintenance.getGratuity()!=null) // added by amit das on 21-07-2016
			 gratuity = hrMasParameterMaintenance.getGratuity();
			 
			 	if(hrMasParameterMaintenance.getSuperannuation()!=null) // added by amit das on 21-07-2016
			 superannuation = hrMasParameterMaintenance.getSuperannuation();
			 
			 if(hrMasParameterMaintenance.getPasswordExpiryDay()!=null) // added by amit das on 21-07-2016
				passwordExpiryDay = hrMasParameterMaintenance.getPasswordExpiryDay(); 
			
			if(hrMasParameterMaintenance.getAdminOnEdli()!=null) // added by amit das on 21-07-2016
				adminOnEdli = hrMasParameterMaintenance.getAdminOnEdli();
			
			if(hrMasParameterMaintenance.getPensionFund()!=null) // added by amit das on 21-07-2016
				pensionFund = hrMasParameterMaintenance.getPensionFund();
			
			 accountNoOfEpf = hrMasParameterMaintenance.getAccountNoOfEpf();
			 femaleTaxRebate = hrMasParameterMaintenance.getFemaleTaxRebate();
			tanNo = hrMasParameterMaintenance.getTanNo();
			panNo = hrMasParameterMaintenance.getPanNo();
			
			if(hrMasParameterMaintenance.getEsiEmployeeCont()!=null) // added by amit das on 21-07-2016
				esiEmployeeCont = hrMasParameterMaintenance.getEsiEmployeeCont();
			
			nightShiftStart = hrMasParameterMaintenance.getNightShiftStart();
			nightShiftEnd = hrMasParameterMaintenance.getNightShiftEnd();
			
			if(hrMasParameterMaintenance.getBenefitPercentage()!=null) // added by amit das on 21-07-2016
				benefitPercentage = hrMasParameterMaintenance.getBenefitPercentage();
			
			
			
			finalYrLeaveCalc = hrMasParameterMaintenance.getFinYrForLeaveCalc();
		
			includeHolidaysInLeave = hrMasParameterMaintenance.getIncludeHolidaysInLeave();
			unusdLeaveForCaryOrEncash = hrMasParameterMaintenance.getUnusdLeaveCaryFwdOrEncash();
			sickLeaveEligibility = hrMasParameterMaintenance.getSickLeaveEligibilty(); 
			vacationLeaveEligibility = hrMasParameterMaintenance.getVacationLeaveEligibilty();
			
			}
			
		
	
	
		}
	%> <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<title>EHA Hospital Management System</title>
<!--  <link href="css/style.css" rel="stylesheet" type="text/css" />-->
</head>
<body>
<form name="parameterMaintenance" method="post" action="">
<!--Main Div starts here-->

<div class="titleBg">
<h2>Parameter Maintenance</h2>
</div>
<div class="Block">
<label><span>*</span> Inspection Charge </label> 
<input name="<%=INSPECTION_CHARGE %>" type="text" validate="Inspection Charge,float,yes" /> 
<script
	type="text/javascript">
          		  document.parameterMaintenance.<%=INSPECTION_CHARGE%>.value='<%=inspectionCharge%>';
    </script> 
<label><span>*</span> EPS MaxLimit</label> 
<input	name="<%=EPS_MAX_LIMIT %>" type="text" validate="EpsMaxLimit,float,yes" />
<script type="text/javascript">
          		  document.parameterMaintenance.<%=EPS_MAX_LIMIT%>.value='<%=epsMaxLimit%>';
        </script> 
<label><span>*</span> DA </label> 
<input name="<%=DA %>" type="text" validate="Da,string,yes" maxlength="20" /> 
<script
	type="text/javascript">
          		  document.parameterMaintenance.<%=DA%>.value='<%=da%>';
            </script>
<div class="clear"></div>
<label><span>*</span> Admn on EDLI</label> 
<input name="<%=ADMIN_ON_EDLI %>" type="text" validate="Admin on Edli,float,yes" /> 
<script type="text/javascript">
          		  document.parameterMaintenance.<%=ADMIN_ON_EDLI%>.value='<%=adminOnEdli%>';
            </script> 
<label><span>*</span> EDLI</label> 
<input name="<%=EDLI %>" type="text" validate="Edli,float,yes" /> 
<script	type="text/javascript">
document.parameterMaintenance.<%=EDLI%>.value='<%=edli%>';
            </script> 
<label><span>*</span> Pension Fund (%)</label> 
<input	name="<%=PENSION_FUND %>" type="text" validate="Pension Fund,float,yes" />
<script type="text/javascript">
          		  document.parameterMaintenance.<%=PENSION_FUND%>.value='<%=pensionFund%>';
            </script>
<div class="clear"></div>
<label><span>*</span> Admission Charge</label> 
<input	name="<%=ADMIN_CHARGE %>" type="text" validate="Admin Charge,float,yes" />
<script type="text/javascript">
          		  document.parameterMaintenance.<%=ADMIN_CHARGE%>.value='<%=adminCharge%>';
            </script> 
<label><span>*</span> A/C No. (EPF)</label> 
<input	name="<%=ACCOUNT_NO_OF_EPF %>" type="text"	validate="A/C of EPF,string,yes" /> 
<script type="text/javascript">
          		  document.parameterMaintenance.<%=ACCOUNT_NO_OF_EPF%>.value='<%=accountNoOfEpf%>';
            </script> 
            <label><span>*</span> Head Office Code</label> 
            <input	name="<%=HEAD_OFFICE_CODE %>" type="text" validate="Head Office Code,string,yes" maxlength="20" /> 
            <script	type="text/javascript">
          		  document.parameterMaintenance.<%=HEAD_OFFICE_CODE%>.value='<%=headOfficeCode%>';
            </script>
<div class="clear"></div>
<label><span>*</span> Female Tax Rebate</label> 
<input	name="<%=FEMALE_TAX_REBATE %>" type="text"	validate="Female Tax Rebate,float,yes" /> 
<script	type="text/javascript">
          		  document.parameterMaintenance.<%=FEMALE_TAX_REBATE%>.value='<%=femaleTaxRebate%>';
            </script> 
            <label><span>*</span> In Service Code</label> 
            <input	name="<%=IN_SERVICE_CODE %>" type="text" validate="In Service code,num,yes" maxlength="6" /> 
            <script type="text/javascript">
          		  document.parameterMaintenance.<%=IN_SERVICE_CODE%>.value='<%=inServiceCode%>';
            </script> 
          <label><span>*</span> PAN No.</label> 
          <input name="<%=PAN_NO %>" type="text" validate="Pan No,string,yes" maxlength="30" /> 
          <script type="text/javascript">
                  		  document.parameterMaintenance.<%=PAN_NO%>.value='<%=panNo%>';
            </script>
<div class="clear"></div>
<label><span>*</span> Leave Encash</label> 
<input	name="<%=LEAVE_ENCASH %>" type="text" validate="Leave Encash,num,yes"	maxlength="3" /> 
<script type="text/javascript">
document.parameterMaintenance.<%=LEAVE_ENCASH%>.value='<%=leaveEncash%>';
            </script> 
            <label><span>*</span> Tan No.</label> 
            <input	name="<%=TAN_NO %>" type="text" validate="Tan No,string,yes" maxlength="30" /> 
            <script type="text/javascript">
                     		  document.parameterMaintenance.<%=TAN_NO%>.value='<%=tanNo%>';
            </script> 
            <label><span>*</span> Pay Type</label> 
            <input	name="<%=PAY_TYPE %>" type="text" validate="Pay Type,num,yes"	maxlength="3" /> 
            <script type="text/javascript">
                     		  document.parameterMaintenance.<%=PAY_TYPE%>.value='<%=payType%>';
            </script>
<div class="clear"></div>
<label><span>*</span> ESI Employee Cont (%)</label> 
<input	name="<%=ESI_EMPLOYEE_CONT %>" type="text"	validate="ESI Employee Cont,float,yes" /> 
<script
	type="text/javascript">
          		  document.parameterMaintenance.<%=ESI_EMPLOYEE_CONT%>.value='<%=esiEmployeeCont%>';
            </script> 
            <label><span>*</span> ESI Employer Cont</label> 
            <input	name="<%=ESI_EMPLOYER_CONT %>" type="text" validate="ESI Employer Cont,float,yes" /> 
            <script
	type="text/javascript">
          		  document.parameterMaintenance.<%=ESI_EMPLOYER_CONT%>.value='<%=esiEmployerCont%>';
            </script> 
            <label><span>*</span> Volunatry Contr</label> 
            <input	name="<%=VOLUNATRY_CONTR %>" type="text" validate="Volunatry Contr,string,yes" maxlength="20" /> 
            <script	type="text/javascript">
          		  document.parameterMaintenance.<%=VOLUNATRY_CONTR%>.value='<%=volunatryContr%>';
            </script>
<div class="clear"></div>
<label><span>*</span> Weekely Holiday 1</label> 
<select	name="<%=HOLIDAY1 %>" class="select"	validate="Weekely Holiday 1,string,yes">
	<option value="0">Select</option>
	<option value="1">Sunday</option>
	<option value="2">Monday</option>
	<option value="3">Tuesday</option>
	<option value="4">Wednsday</option>
	<option value="5">Thursday</option>
	<option value="6">Friday</option>
	<option value="7">Saturday</option>
</select> <script type="text/javascript">
          		  document.parameterMaintenance.<%=HOLIDAY1%>.value='<%=saturdayHoliday%>';
            </script> 
<label><span>*</span> Weekely Holiday 2</label> 
<select	name="<%=HOLIDAY2 %>" class="select"	validate="Weekely Holiday 2,string,yes">
	<option value="0">Select</option>
	<option value="1">Sunday</option>
	<option value="2">Monday</option>
	<option value="3">Tuesday</option>
	<option value="4">Wednsday</option>
	<option value="5">Thursday</option>
	<option value="6">Friday</option>
	<option value="7">Saturday</option>
</select> <script type="text/javascript">
          		  document.parameterMaintenance.<%=HOLIDAY2%>.value='<%=sundayHoliday%>';
            </script> 
<label><span>*</span> No.Of Working Days</label> 
<input	name="<%=NO_OF_WORKING_DAYS %>" type="text"	validate="No Of Working Days,num,yes" maxlength="3" /> 
<script	type="text/javascript">
          		  document.parameterMaintenance.<%=NO_OF_WORKING_DAYS%>.value='<%=noOfWorkingDays%>';
            </script>
<div class="clear"></div>
<label><span>*</span> Superannuation</label> 
<input	name="<%=SUPERANNUATION %>" type="text"	validate="Superannuation,float,yes" /> 
<script type="text/javascript">
          		  document.parameterMaintenance.<%=SUPERANNUATION%>.value='<%=superannuation%>';
            </script> 
<label><span>*</span> Password Expiry Day</label> 
<input name="<%=PASSWORD_EXPIRY_DAY %>" type="text"	validate="Password Expiry Day,num,yes" maxlength="2" /> 
<script	type="text/javascript">
document.parameterMaintenance.<%=PASSWORD_EXPIRY_DAY%>.value='<%=passwordExpiryDay%>';
            </script> 
<label><span>*</span> Retirement Age</label> 
<input	name="<%=RETIREMENT_AGE %>" type="text"	validate="Retirement Age,num,yes" maxlength="2" /> 
<script	type="text/javascript">
document.parameterMaintenance.<%=RETIREMENT_AGE%>.value='<%=retirementAge%>';
            </script>
<div class="clear"></div>
<label><span>*</span> Gratuity (%)</label> 
<input name="<%=GRATUITY %>" type="text" validate="Gratuity,float,yes" /> 
<script	type="text/javascript">
          		  document.parameterMaintenance.<%=GRATUITY%>.value='<%=gratuity%>';
            </script>
            </div>
<div class="titleBg">
<h2>Night Differential</h2>
</div>
<div class="Block">
<label><span>*</span> Night Shift Start</label>
<input name="<%=NIGHT_SHIFT_START %>" type="text"
	validate="Night Shift Start,string,yes"
	onKeyUp="mask(this.value,this,'2,5',':');" maxlength="8" /> <script
	type="text/javascript">
          		  document.parameterMaintenance.<%=NIGHT_SHIFT_START%>.value='<%=nightShiftStart%>';
            </script> 
<label><span>*</span> Night Shift End</label> 
<input	name="<%=NIGHT_SHIFT_END %>" type="text"	validate="Night Shift End,string,yes"	onKeyUp="mask(this.value,this,'2,5',':');"	onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="8" /> 
<script	type="text/javascript">
          		  document.parameterMaintenance.<%=NIGHT_SHIFT_END%>.value='<%=nightShiftEnd%>';
            </script> 
<label><span>*</span> Benefit Percentage</label> 
<input	name="<%=BENEFIT_PERCENTAGE %>" type="text"	validate="Benefit Percentage,float,yes" /> 
<script	type="text/javascript">
          		  document.parameterMaintenance.<%=BENEFIT_PERCENTAGE%>.value='<%=benefitPercentage%>';
            </script>
<div class="clear"></div>
<input name="<%=FIN_YR_FOR_LEAVE_CALC %>" type="checkbox" class="radiobutMargin" value="" /> 
<label class="large">Use financial year for leave calculation</label> 
<%
if(finalYrLeaveCalc.equals("y")){
%> 
<script type="text/javascript">
          		  document.parameterMaintenance.<%=FIN_YR_FOR_LEAVE_CALC%>.checked=true;
            </script> <%
	}else{
%> 
<script type="text/javascript">
          		  document.parameterMaintenance.<%=FIN_YR_FOR_LEAVE_CALC%>.checked=false;
            </script> <%
	}
%> 
<input name="<%=INCLUDE_HOLIDAYS_In_LEAVE %>" type="checkbox" class="radiobutMargin" value="" /> 
<label class="large">Include holidays in leave</label> 
<%
if(includeHolidaysInLeave.equals("y")){
%> 
<script type="text/javascript">
          		  document.parameterMaintenance.<%=INCLUDE_HOLIDAYS_In_LEAVE%>.checked=true;
            </script> <%
	}else{
%> <script type="text/javascript">
          		  document.parameterMaintenance.<%=INCLUDE_HOLIDAYS_In_LEAVE%>.checked=false;
            </script> <%
	}
%>

<input name="<%=UNUSED_LEAVE_CARY_FWD_OR_ENCASH %>" type="checkbox"	class="radiobutMargin" value="" /> 
<label class="large">Unused leaves carry forward/ Encashable</label> 
<%
if(unusdLeaveForCaryOrEncash.equals("y")){
%> 
<script type="text/javascript">
          		  document.parameterMaintenance.<%=UNUSED_LEAVE_CARY_FWD_OR_ENCASH%>.checked=true;
            </script> <%
	}else{
%> 
<script type="text/javascript">
          		  document.parameterMaintenance.<%=UNUSED_LEAVE_CARY_FWD_OR_ENCASH%>.checked=false;
            </script> <%
	}
%> 
<div class="clear"></div>
<input name="<%=SICK_LEAVE_ELIGIBILITY %>" type="checkbox" class="radiobutMargin" value="" /> 
<label class="large"> Sick leave eligiblity for covered employees only</label> 
<%
if(sickLeaveEligibility.equals("y")){
%>
 <script type="text/javascript">
          		  document.parameterMaintenance.<%=SICK_LEAVE_ELIGIBILITY%>.checked=true;
            </script> <%
	}else{
%> <script type="text/javascript">
          		  document.parameterMaintenance.<%=SICK_LEAVE_ELIGIBILITY%>.checked=false;
            </script> <%
	}
%>

<input name="<%=VACATION_LEAVE_ELIGIBILITY %>" type="checkbox" class="radiobutMargin" value="" /> 
<label class="large">Vacation leave eligiblity for covered employees only</label> 
<%
if(vacationLeaveEligibility.equals("y")){
%> 
<script type="text/javascript">
          		  document.parameterMaintenance.<%=VACATION_LEAVE_ELIGIBILITY%>.checked=true;
            </script> <%
	}else{
%> 
<script type="text/javascript">
          		  document.parameterMaintenance.<%=VACATION_LEAVE_ELIGIBILITY%>.checked=false;
            </script> <%
	}
%> 
<input type="hidden" name="<%=PARAMETER_MAINTENANCE_ID %>"	value="<%=parameterMaintenanceId %>">
<input type="hidden" name="<%=HOSPITAL_ID %>" value="<%=hospitalId%>" />
<div class="clear"></div>
<%
			if(masParameterMaintenanceList.size()>0){
	%>
<div class="clear"></div>
<input name="save" type="button" class="button" value="Update"	onClick="submitForm('parameterMaintenance','setup?method=upDateParameterMaintenance');" />
<%
		}else{ 
	%>
<div class="clear"></div>
<input name="save" type="button" class="button" value="Save" onClick="submitForm('parameterMaintenance','setup?method=saveParameterMaintenance');" />
<%
		}	
	%> 
<input name="reset" type="button" class="buttonHighlight" value="Reset" />
</div>

<div class="bottom">
<label>Changed By:</label> 
<label class="value"><%=userName%></label> 
<label>Changed Date:</label> 
<label	class="value"><%=date%></label> 
<label>Changed Time:</label> 
<label	class="value"><%=time%></label> 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<!--<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />-->
<!--Main Div ends here-->
</body>
</html>