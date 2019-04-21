<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.UploadDocuments"%>

<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript">
/* var csrfTokenName='<csrf:tokenname />';
var csrfTokenValue='<csrf:tokenvalue />'; */
 var csrfTokenName='${_csrf.parameterName}';
 var csrfTokenValue='${_csrf.token}';
</script>
<script type="text/javascript"  src="/hms/jsp/js/csrfToken.js"></script>

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
<%String date = "";
String time = "";
String userName = "";
int hospitalId = 0;
Box box = HMSUtil.getBox(request);
Map<String, Object> map = new HashMap<String, Object>();
Map<String,Object> utilMap = new HashMap<String,Object>();

				String message = "";
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			 	date = (String)utilMap.get("currentDate");
			 	time = (String)utilMap.get("currentTime");
			 	if(session.getAttribute("userName") != null)
			 	{
					userName = (String)session.getAttribute("userName");
				}
				
				if(session.getAttribute("userName") != null){
					userName = (String)session.getAttribute("userName");
				}
				int studentId=0;
				if(map.get("studentId") != null){
					studentId = (Integer)map.get("studentId");}
			String grNo="";
			if(map.get("grNo") != null){
				grNo = (String)map.get("grNo");
			}
	if (map.get("message") != null) {
	             message = (String) map.get("message");
	      }
	if(!message.equalsIgnoreCase("")){
	%>
<h2><%=message %></h2>
<%} %>
<div id="contentHolder">
<form name="studentphoto" method="post" action="" enctype="multipart/form-data">
<script language="javascript">

function jsImport()
{
//alert("in method");
	if (document.getElementById('fileNameId').value == "")

	{
	alert('Pl. Select a File to upload!.....');
	return;
	}
	var fname = document.getElementById('fileNameId').value;

	//var st = fname.length;
	//st = st-3;
	//if (fname.substring(st)!="zip")
	//{
	//alert('Only zip files are Allowed. Please Zip all the Excel Files and Give the file as input !....For further Help, Refer User Manual.');
	//return;
	//}
	var ind1 = fname.lastIndexOf("\\");
	var filename = fname.substring(ind1+1);
	if(filename.lastIndexOf(".xls")==-1 ){
	alert("File Type is InCorrect choose Another");
	document.getElementById('fileNameId').value="";
	
	}else{
		//alert("in else");
		
	document.studentphoto.method="POST";
	  submitForm('studentphoto','pubHealth?method=addorUpdateStudentRescord&filename='+filename+'&'+csrfTokenName+'='+csrfTokenValue);
  
	//window.close();
	alert("Done File Name: "+filename);
	}

}

</script>

<div class="titleBg"> <h6>Upload Excel </h6></div>
<div class="clear"></div>
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>

<div class="blockFrame">
<div class="clear"></div>
<label>Excel</label>

<input type="file" name="<%=UPLOAD_FILENAME %>" id="fileNameId" class="browse">

<input name="Submit13" type="button" class="button" value="Add" onClick="jsImport();"/>
<div class="clear"></div>
<label style="font-size:8px;padding-left:115px;width:150px;color: #ff0000;">only .xls files are accepted</label>
</div>
<div class="division"></div>

<div class="clear"></div>

<input name="button" type="hidden"  class="button" value="Close" onClick="window.close();" />
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>



</div>
