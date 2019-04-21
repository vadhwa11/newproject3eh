<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * registration.jsp
 * Purpose of the JSP -  This is for Birth Certificate.
 * @author  Dipali
 * Create Date: 23rd April,2008
 * Revision Date:
 * Revision By:
 * @version 1.36
--%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>

<script type="text/javascript">
function checkValidation(){
/*
if(document.getElementById("regDateId").value == document.getElementById("birthDateId").value){
	return true;
}else{
	alert("Date Of Birth and Date Of Registration should be same")
	return false;
}*/
return true;
}
function autoFill(val){
	document.getElementById("regDateId").value =document.getElementById("birthDateId").value
}
</script>
<div class="clear"></div>
<div class="titleBg">
<!-- <h2>Birth Certificate</h2> -->
<h2>New Born Baby Sheet Entry</h2>
</div>
<%
			Map<String, Object> map = new HashMap<String, Object>();
			if(request.getAttribute("map") != null){
				map=(Map<String, Object>)request.getAttribute("map");
			}
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date1 = (String)utilMap.get("currentDate");
			String time = (String)utilMap.get("currentTime");
			 String userName = "";
			 int birthNo=0;
			 if(map.get("birthNo") != null){
				birthNo = (Integer)map.get("birthNo");
				}
			//String message="";
			//String message1="";
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
			//List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
			//List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			//if(map.get("sexList") != null){
//				sexList = (List<MasAdministrativeSex>)map.get("sexList");
			//}
			//if(map.get("employeeList")!=null)
			//{
//		employeeList=(List)map.get("employeeList");
	//}
			%>
<script>
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
<div class="clear"></div>
<form name="fatalDocumentPanchnamaReport" method="post" action="">
<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 22 Sep 2010
 -->
	<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
//out.println("name-jsp-" +p.getProperty("age") );
%>
<div class="Block">
<div class="clear"></div>
<label><span>*</span> Birth No</label> 
<input	type="text" name="<%=BIRTH_CERTIFICATE_NO%>" id="<%=BIRTH_CERTIFICATE_NO%>" value="<%=birthNo%>" class="textbox_date"	MAXLENGTH="10" validate="Birth,string,yes"/>
<div class="clear"></div>
<div id="hinDiv">
<label><span>*</span><%=prop.getProperty("com.jkt.hms.uhid") %></label> 
<input	type="text" name="<%=HIN_NO%>" value="" class="textbox_date"	MAXLENGTH="30"	validate="hinNo,metachar,yes" onchange="submitProtoAjaxWithDivName('fatalDocumentPanchnamaReport','ipd?method=getMotherAdmissionNumberList&flag=admission','testDiv')" />
</div>
<div id="testDiv">
<label><span>*</span>  <%=prop.getProperty("com.jkt.hms.ipd_no") %></label> 
<input	type="text" id="frwSlno" name="<%=INPATIENT_ID%>" value=""	class="textbox_date" MAXLENGTH="30" validate="<%=prop.getProperty("com.jkt.hms.ipd_no") %>,metachar,yes" />
</div>

<div class="clear"></div>
<div class="clear"></div>
<div id="birthDiv">

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date1%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
</div>
<div class="division"></div>
<div class="clear"></div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
	<script>
function isNumber(evt) {
   
	evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}
function pastDateValidation()
{
	
	var d=document.getElementById("birthDateId").value;
	var d1=document.getElementById("changeddate2").value;

	    if(process(d) > process(d1)){
	          alert("Future Date Not Allowed");
	          document.getElementById("birthDateId").value="";
	    }
    
}

function process(date){
	   var date;
	   // Do something
	   return date;
	}
</script>