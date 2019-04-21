<!DOCTYPE html>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript">
	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}

	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'		
	</script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<OpdPatientDetails> opdPatientDetailList = new ArrayList<OpdPatientDetails>();
	String opdHis="";
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if(map.get("opdPatientDetailList") != null){
		opdPatientDetailList =(List)map.get("opdPatientDetailList");
	}
	List<OpdPatientHistory> patientHistories = new ArrayList<OpdPatientHistory>();
	if(map.get("patientHistories")!=null){
		patientHistories=(List<OpdPatientHistory>)map.get("patientHistories");
    }
	System.out.println("patientHistories in jsp" +patientHistories.size());
	 for(OpdPatientHistory history:patientHistories){
		  opdHis= history.getPresentComplaintHistory(); 
	  }
	String msg = "";
	if(map.get("msg") != null){
		msg = (String)map.get("msg");
	}
	
	String orderNo = "";
	if(map.get("orderNo") != null){
		orderNo = (String)map.get("orderNo");
	}
	
	String patientName = "";
	String age = "";
	String ward = "";
	int hinId = 0; 
	int visitId = 0; 
	int inPatientId = 0; 
	int opdPatientDetialId = 0; 
	String hinNo="";
	if(opdPatientDetailList.size()>0){
		OpdPatientDetails opdPatientDetails =(OpdPatientDetails)opdPatientDetailList.get(0);
		if(opdPatientDetails.getVisit() != null){
			patientName =opdPatientDetails.getVisit().getHin().getFullName();
		}else{
			patientName =opdPatientDetails.getInpatient().getHin().getFullName();
		}
		if(opdPatientDetails.getVisit() != null){
			age =opdPatientDetails.getVisit().getHin().getAge();
		}else{
			age =opdPatientDetails.getInpatient().getHin().getAge();
		}
		if(opdPatientDetails.getVisit() != null){
			hinNo =opdPatientDetails.getVisit().getHin().getHinNo();
		}else{
			hinNo =opdPatientDetails.getInpatient().getHin().getHinNo();
		}
		if(opdPatientDetails.getVisit() != null){
			hinId =opdPatientDetails.getVisit().getHin().getId();
		}else{
			hinId =opdPatientDetails.getInpatient().getHin().getId();
		}
		if(opdPatientDetails.getVisit() != null){
			visitId = opdPatientDetails.getVisit().getId();
		}else{
			inPatientId =opdPatientDetails.getInpatient().getId();
			
		}
		if(opdPatientDetails.getInpatient()!= null && opdPatientDetails.getInpatient().getDepartment()!=null){
			ward =opdPatientDetails.getInpatient().getDepartment().getDepartmentName();
		}else{
			ward ="";
		}
		if(opdPatientDetails.getId() != null){
			opdPatientDetialId = (Integer)opdPatientDetails.getId();
		}

		
	}

	 System.out.println("opdHis" +opdHis);
if(map.get("message") != null){
	 String  message = (String)map.get("message");
	   %>
	   <h4><span><%=message %></span></h4>
	 <%} %>
<form name="policeIntimation" method="post" action="">
<div class="titleBg">
<h2> Police Intimation</h2>
</div>

<div class="Block">

<label><span>*</span> Serial No.</label>
<input type="text" name="serialNo" id="serialNo" MAXLENGTH="16" validate="Serial No,string,yes" value="<%=orderNo%>" />

<label><span>*</span> UHID</label>
<input type="text" name="uhinId" id="uhinId" validate="UHID,string,yes" MAXLENGTH="50" value="<%=hinNo != null?hinNo:"" %>"> 

 <label>Patient Name<span>*</span></label>
 <input type="text" name="patientName" value="<%=patientName != null?patientName:"" %>"  MAXLENGTH="8"  /> 
  <input type="hidden" name="hinId" value="<%=hinId != 0?hinId:"" %>"  MAXLENGTH="8"  /> 
  <input type="hidden" name="visitId" value="<%=visitId != 0?visitId:"" %>"  MAXLENGTH="8"  />
  <input type="hidden" name="inPatientId" value="<%=inPatientId != 0?inPatientId:"" %>"  MAXLENGTH="8"  />
   <input type="hidden" name="opdPatientDetialId" value="<%=opdPatientDetialId != 0?opdPatientDetialId:"" %>"  MAXLENGTH="8"  />
 
 <label>Age</label>
 <input type="text" name="district" value="<%=age != null?age:"" %>"  MAXLENGTH="8"  /> 
  <div class="clear"></div>
 <label>Ward</label>
 <input type="text" name="district" value="<%=ward != null?ward:"" %>"  MAXLENGTH="8"  /> 
 

 
 <label>Opd History</label>
 <input type="text" name="district" value="<%=opdHis!=null?opdHis:" "%>"  MAXLENGTH="8"  /> 

<label>Police Station<span>*</span></label>
 <input type="text" name="policeStation" value=""  MAXLENGTH="8"  validate="district,metachar,yes"/> 
 
  <div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="Submit" type="submit" value="Submit"	onClick="submitForm('policeIntimation','opd?method=submitPoliceIntimationDetail');" class="button" />	
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>







