<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientDischargeSearch.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>
<%@page import="jkt.hms.masters.business.PhMasOrgCategory"%>
<%@page import="jkt.hms.masters.business.PhVillageSurvey"%>
<%@page import="jkt.hms.masters.business.PhHouseSurvey"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
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
		String userName = "";
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
			String currentDate = (String)utilMap.get("currentDate");  
			String currentTime = (String)utilMap.get("currentTime");
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
		Map<String, Object> map=new HashMap<String, Object>();
		List<PhVillageSurvey> villageSurveys=new ArrayList<PhVillageSurvey>();
		if(request.getAttribute("map")!=null){
			map=(Map<String ,Object>)request.getAttribute("map");
		}
		if(map.get("villageSurveys")!=null){
			villageSurveys=(List<PhVillageSurvey>)map.get("villageSurveys");
		}
		List<PhMasOrgCategory> phOrgCata=new ArrayList<PhMasOrgCategory>();
		if(map.get("phOrgCata")!=null){
			phOrgCata=(List<PhMasOrgCategory>)map.get("phOrgCata");
		}
		List<PhMasOrgCategory> phOrgCataList=new ArrayList<PhMasOrgCategory>();
		if(map.get("phOrgCataList")!=null){
			phOrgCataList=(List<PhMasOrgCategory>)map.get("phOrgCataList");
		}
		
		
		String CurrentDate=date+"/"+month+"/"+year;
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	
function selectOption(){
			
			var sel=document.getElementById("survey").value;
			if(sel == ""){
				alert("Select One Option Survey");
				 return false;
			}
			 return true;
		}	
		
	function checkData(){
			
			var start= new Date(document.getElementById("fromDate").value.split("/")[2], document.getElementById("fromDate").value.split("/")[1], document.getElementById("fromDate").value.split("/")[0]);
			 var end= new Date(document.getElementById("toDate").value.split("/")[2], document.getElementById("toDate").value.split("/")[1], document.getElementById("toDate").value.split("/")[0]);
			 if(start>end){
				 alert("Date is Incorrect.");
				 return false;
				 
			 }else{return true;
			 
			 }
		}
			
</script>

<form name="search" action="" method="post">
<%  String message="";
	if(map.get("msg")!=null){
		message=(String)map.get("msg");
		out.print(message);
	} 
	%>
<div class="titleBg">
<h2>Village Survey</h2>
</div>
<div class="clear"></div>
<div class="Block">
 <label><span>* </span>From Date</label> 
 <input id="fromDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=CurrentDate %>" name="fromDate">
<img width="16" height="16" border="0" onclick="javascript:setdate('',document.search.fromDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif"/> 
	<label><span>* </span>To Date</label>
	 <input id="toDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=CurrentDate %>" name="toDate">
<img width="16" height="16" border="0" onclick="javascript:setdate('',document.search.toDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif"/>

	 <label>Survey</label>
	<select name="survey" id="survey"  onchange="selectEnchashablePerc();" validate="Survey,string,yes">
        <option value="">Select</option>		   
     <%  for(PhMasOrgCategory org : phOrgCata){%>
			
		 <option value="<%=org.getCategoryCode()%>"><%=org.getCategoryName()%></option>		
	         <%
            }%>
</select> 
	 
	<div class="clear"></div>
	
<div class="clear"></div>
<div id="divEnchashment" style="display: none;">

<label>Clinic</label> 
<input type="radio" name="HOCL" id="HOCL" value="CL" />
<label>Hospital</label> 
<input type="radio" name="HOCL" id="HOCLHO" value="HO" />

</div>

<div id="div" style="display: none;">
<label>Category</label> 

	<select name="cli" id="cli"  onchange="selectEnchashablePerc();" validate="Clinic,string,yes">
        <option value="">Select</option>		   
     <%  for(PhMasOrgCategory org : phOrgCataList){%>
			
		 <option value="<%=org.getCategoryCode()%>"><%=org.getCategoryName()%></option>		
	         <%
            }%>
</select> 	 
</div>
<div class="clear"></div>
<div class="clear"></div>
<input type="button" name="Search" id="addbutton"	onclick="if(checkData() && selectOption()){submitProtoAjaxWithDivNameForVillageSurvey('search','/hms/hms/pubHealth?method=searChPublicHealthVillageSurveyJsp','tDivss');}" value="Search"	class="button"  />
</div>                                                                         
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="Block">
<h4>Survey Details</h4>
<div class="clear"></div>
 <div id="tDivss">
	</div>
	<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
		</script>
	</div>
   <div class="clear"></div>
 <div class="clear"></div>
	<div class="bottom">
		<label>Changed By:</label>
		<label class="value"><%=userName%></label>
		<label>Changed Date:</label>
		<label class="value"><%=currentDate%></label>
		<label>Changed Time:</label>
		<label class="value"><%=currentTime%></label>
	</div>
<!--Block Two Ends-->
	<div class="clear"></div>
	<div class="paddingTop15"></div>
	<div class="clear"></div>
	<!--Bottom labels starts-->
	<div class="bottom">
	<input type="hidden" name="lastChgBy" value="<%=userName%>" />
	<input type="hidden" name="lastChgDate" value="<%=currentDate%>" /> 
	<input type="hidden" name="lastChgTime" value="<%=currentTime%>" /> 
	</div>
	<script type="text/javascript">
	function selectEnchashablePerc(){

		if(document.getElementById("survey").value== '1004'){
		
			document.getElementById("divEnchashment").style.display ='block';
		
		}
		else {
			document.getElementById("divEnchashment").style.display ='none';
			document.getElementById("HOCL").checked = false;
			document.getElementById("HOCLHO").checked = false;
		}
		if(document.getElementById("survey").value== '1007'){
			document.getElementById("div").style.display ='block';
		}
		else{
			document.getElementById("div").style.display ='none';
		}
				
	}

</script>

	
