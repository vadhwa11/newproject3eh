<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasInstituteDepartment"%>
<%@page import="java.util.concurrent.PriorityBlockingQueue"%>
<%@page import="jkt.hms.util.PatientVisitBean"%>
<%@page import="java.util.*"%>
<%@page import="java.util.*"%>
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * window_popupJsp.jsp
 * Purpose of the JSP -  This is for Window.
 * @author Ramdular
 * Create Date: 14th Sep,2010
 * Revision Date:
 * Revision By:
 * @version 1.4
--%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.QueueManagment"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@ page import="java.util.*"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script src="/hms/jsp/js/jquery-1.11.0.min.js"></script>
<SCRIPT SRC="/hms/jsp/js/ssm.js" language="JavaScript1.2"></SCRIPT> 
<script>
<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}

	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
</script>


<%
/* int deptId=0;
int token=0;
String deptName=""; */
List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
List<MasDepartment> departmentList = new ArrayList<MasDepartment>();

Map map = new HashMap();
 if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
 /*
if (map.get("deptName") != null) {
	deptName = (String)map.get("deptName");
}

if (map.get("deptId") != null) {
	deptId = (Integer)map.get("deptId");
} */

if(map.get("masHospitalList") != null){
	masHospitalList =(List<MasHospital>) map.get("masHospitalList");
}

if(map.get("departmentList") != null){
	departmentList =(List<MasDepartment>) map.get("departmentList");
}
%>

<body>
<!-- <form name="uploadVideos" method="post" enctype="multipart/form-data"  >
<div class="Block">

<h2>Display Hospital</h2>

<input type="file" name="videosfile" id="videosfile">
<input type="button" name="button" value="Upload" class="button" onClick="submitForm('uploadVideos','/hms/hms/opd?method=uploadVideosData');"/>
</form> -->

<form name="displayImages" method="post" enctype="multipart/form-data" >
<div class="titleBg">
<h2>Display Hospital Images</h2>
</div>
<div class="Block">
<div class="clear"></div>
<%-- <center><font class="BigFont"><%=deptName %></font></center> --%>

<div class="clear"></div>
<label>Browse Images</label>
<input type="file" name="image" id="imageNameId"  class="browse"/>

<label>Browse Video</label>
<input type="file" name="video" id="videoNameId" class="browse"/>
<div class="clear"></div>
<label>Hospital</label>
<select id="hospitalIdd"
								name="hospitalIdd" validate="Hospital,string,yes"
								tabindex=4 onchange="Javascript: populatMasInstitute(this.value);">
								<option value="">Select</option>
								<%
				    for (MasHospital hospital : masHospitalList){
				    	
				%>
								<option value="<%=hospital.getId()%>"><%=hospital.getHospitalName()%></option>
								<%}%>
</select>
<label>Service Center</label>
<select id="deptNameId"
								name="deptNameId" validate="Department,string,yes"
								tabindex=4 >
								<option value="">Select</option>
								<%
				    for (MasDepartment dept : departmentList){
				    	
				%>
								<option value="<%=dept.getId()%>"><%=dept.getDepartmentName()%></option>
								<%}%>
</select>
<div class="clear"></div>
<label>Enter Text</label>
<input type="text" name="userText" id="userText"  value="" validate="User Text,string,no" style="font-size: 12pt; height: 20px; width:550px;"/>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<label><span>*</span> From Date</label> 
<input type="text"	name="<%=EFFECTIVE_DATE_FROM%>" id="<%=EFFECTIVE_DATE_FROM%>"
 value="<%=curDate+"/"+month+"/"+year%>" class="date"	
readonly="readonly" validate="Effective Date From,date,yes"	MAXLENGTH="30"   /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,yes"	
onclick="setdate('<%=curDate+"/"+month+"/"+year%>',document.displayImages.<%=EFFECTIVE_DATE_FROM%>,event)" />
<label>To Date</label>

<input type="text"	name="<%=EFFECTIVE_DATE_TO%>" id="<%=EFFECTIVE_DATE_TO%>" value="" class="date" readonly="readonly" validate="Effective Date To,date,no" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no" onclick="setdate('',document.displayImages.<%=EFFECTIVE_DATE_TO%>,event)" />

<div class="clear"></div>
<input type="button" name="button" value="Add"  class="button"	
onClick="jsImport()" />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" tabindex="19" />

<input type="hidden" id="imageNmae" name="imageNmae" vale="" />

<input type="hidden" id="imageNmae1" name="imageNmae1" vale="" />
</div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script language="javascript">

function jsImport()
{
	if (document.getElementById('imageNameId').value == "")
		
	{
	alert('Please select a file to Upload');
	return;
	}

	var fname = document.getElementById('imageNameId').value;
	
	var ind1 = fname.lastIndexOf("\\");
	var filename = fname.substring(ind1+1);
	document.getElementById("imageNmae").value=filename;
	
var fname1 = document.getElementById('videoNameId').value;
	
	var ind2 = fname1.lastIndexOf("\\");
	var filename1 = fname1.substring(ind1+1);
	document.getElementById("imageNmae1").value=filename1;
	document.displayImages.method="post";
	submitForm('displayImages','opd?method=submitImagesList&'+csrfTokenName+'='+csrfTokenValue);
	
}

</script>


</body>

