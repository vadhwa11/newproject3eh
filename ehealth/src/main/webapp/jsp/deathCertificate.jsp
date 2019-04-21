<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * registration.jsp
 * Purpose of the JSP -  This is for Death Certificate.
 * @author  Dipali
 * Create Date: 23rd April,2008
 * Revision Date:
 * Revision By:
 * @version 1.36
--%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>

<script type="text/javascript">
 function checkValidation(){
/*
	if(document.getElementById("regDateId").value == document.getElementById("deathDateId").value){
			return true;
	}else{
			alert("Date Of Death and Date Of Registration should be same")
			return false;
		}
		*/
		return true;
 }
function autoFill(){
	document.getElementById("regDateId").value =document.getElementById("deathDateId").value
}
</script>
<div class="clear"></div>

<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 27 Sep 2010
 -->
	<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
//out.println("name-jsp-" +p.getProperty("age") );
%>
<div class="titleBg">
<h2>Death Certificate</h2>
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
			 List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();

			   try{
					inPatientDetailList=(List)map.get("showList");

				}catch(Exception e){
					e.printStackTrace();
				}
			String userName = "";
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
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
<div class="Block">

<div id="hinDiv">
<label><span>*</span> <%=prop.getProperty("com.jkt.hms.registration_no") %></label> 
<input	type="text" name="<%=HIN_NO%>" value="" class="textbox_date"	MAXLENGTH="30" validate="<%=prop.getProperty("com.jkt.hms.registration_no") %>,metachar,yes" onchange="submitProtoAjaxWithDivName('fatalDocumentPanchnamaReport','mis?method=getExpiredAdmissionNumberList&flag=admission','testDiv')" />
</div>
<div id="testDiv">
<label><span>*</span><%=prop.getProperty("com.jkt.hms.ipd_no") %></label> 
<input	type="text" id="frwSlno" name="<%=INPATIENT_ID%>" value=""	class="textbox_date" MAXLENGTH="30" validate="<%=prop.getProperty("com.jkt.hms.ipd_no") %>,metachar,yes" />
</div>
<div class="clear"></div>
<div id="deathDiv">
<%-- Code for response jsp after select IPD NO --%>
</div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date1%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Submit" value="Submit" class="button"	onClick="if(checkValidation()){submitForm('fatalDocumentPanchnamaReport','mis?method=submitDeathCertificate');}"  tabindex="17"/>
<input type="reset" name="Reset" id="reset" value="Reset"	class="buttonHighlight" onclick="resetCheck();" accesskey="r"  tabindex="18"/>
<div class="clear"></div>
</div>
<div class="division"></div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>