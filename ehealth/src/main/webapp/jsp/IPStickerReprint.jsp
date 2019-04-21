<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * edReport.jsp  
 * Purpose of the JSP -  This is for Appropration Register Report.
 * @author  Govind
 * Create Date: 03rd Feb , 2017
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>

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
	<div class="titleBg">
<h2>IP Sticker Reprint</h2>
</div>
<%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	List<Inpatient> inpatientList=new ArrayList<Inpatient>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currenDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
			 	
			 	if (map.get("inpatientList") != null) {
			 		inpatientList = (List<Inpatient>) map.get("inpatientList");
			 	}
			 	
			 	String admNo="",adNo1="",hinNo="";
			 	if(inpatientList.size()>0){
			 		admNo=inpatientList.get(0).getAdNo();
			 	}
			 	if (map.get("adNo") != null) {
			 		adNo1 = (String) map.get("adNo"); 	
			 	}
			 	if (map.get("hinNo") != null) {
			 		hinNo = (String) map.get("hinNo"); 	
			 	}
			 	
			 	String msg="";
			 	if (map.get("msg") != null) {
			 		msg = (String) map.get("msg"); 	
			 	}
			 %>
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);	 %>
<form name="ipSticker" method="post" action="">
<div class="clear"></div>
	<%
	if(map.get("msg") != null){%>
		<div class="clear"></div>
		<label class="large"><span><%=msg%></span></label>
		<div class="clear"></div>
	 <% }%>
<div class="Block">
<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<input type="text" id="hin_no"  name="hin_no"  validate="Reg. No,integer,no"  value="<%=hinNo%>"   />
<label>IP Admission No</label>
<input type="text" id="adNo1"  name="adNo"  validate="IP Admisson No,string,no"  value="<%=adNo1%>"  />

<input name="button" value="Search" class="button" onclick="submitForm('ipSticker','/hms/hms/ipd?method=showIPStickerReprint')" type="button">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<%if(inpatientList.size()>0){ %>
<input type="hidden" id="adNo" value="<%=admNo%>">
<input type="button" class="buttonAuto" value="Print" onClick="submitFormForDirectPrint('ipSticker','/hms/hms/adt?method=showIPAdmissionReport&adNo='+document.getElementById('adNo').value);"	/>
<%} %>
</div>
</form>

<SCRIPT language=Javascript>//script for entering only integer
      <!--
      function isNumberKey(evt)
      {
         var charCode = (evt.which) ? evt.which : event.keyCode;
         if (charCode > 31 && ((charCode < 46) || (charCode > 57)))
            return false;

         return true;
      }
      //-->
      
      function getPatientEpisodes(){
    	var hinNo = document.getElementById("hin_no").value; 
		submitProtoAjaxNew('voucherReport','opd?method=getEpisodeList&hin_no='+hinNo,'patientEpisodeList');
	  }
      
</SCRIPT> 

