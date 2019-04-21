<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.io.File"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				
				String message = "";
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
				
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
					
				
				String userName = "";
				if(session.getAttribute("userName") != null){
					userName = (String)session.getAttribute("userName");
				}
				
				



	
			
		%>
				
	
<script language="javascript">

function jsImport()
{
	if (document.getElementById('fileNameId').value == "")
		
	{
	alert('Pl. Select a file to Import!.....');
	return;
	}
	var fname = document.getElementById('fileNameId').value;
	//alert("fname=>"+);
	
	//var st = fname.length;
	//st = st-3;
	//if (fname.substring(st)!="zip")
	//{
	//alert('Only zip files are Allowed. Please Zip all the Excel Files and Give the file as input !....For further Help, Refer User Manual.');
	//return;
	//}
	var ind1 = fname.lastIndexOf("\\");
	
	var filename = fname.substring(ind1+1);
	alert("filename=> "+filename);
	document.noticeBoardFile1.method="post";
	submitForm('noticeBoardFile1','noticeBoard?method=addNoticeBoardFile&filename='+filename+'&'+csrfTokenName+'='+csrfTokenValue);
	
}

</script>


<form name="noticeBoardFile1" method="post" action="" enctype="multipart/form-data">
<div class="titleBg"> <h2>Upload File </h2></div>
<div class="clear"></div>

<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>File</label>
<input type="file" name="<%=UPLOAD_FILENAME %>" id="fileNameId" class="browse">

<div class="clear"></div>
</div>
<table class="small">
<tr>
<th>Select</th>
<th>File</th>
</tr>
<%String uploadURL = getServletContext().getRealPath("/Attendance/");	
File folder = new File(uploadURL);
File[] listOfFiles = folder.listFiles();
String filename = "";
for (int i = 0; i < listOfFiles.length; i++) {
  if (listOfFiles[i].isFile()) {
    
     filename = listOfFiles[i].getName();
   
  
 %>


<tr>
<td><input name="filename"  class="radioCheck" id="rb<%=i%>" type="radio" value='<%=filename%>' /></td>

<td><%=listOfFiles[i].getName() %></td>
<%} 
}%>

</tr>


</table>
<div class="division"></div>




<input name="add" type="button" class="button" value="Add" onClick="jsImport();"/>
<input name="add" type="button" class="button" value="Delete" onClick="submitForm('noticeBoardFile1','/hms/hms/noticeBoard?method=deleteNoticeBoardDocument&'+csrfTokenName+'='+csrfTokenValue);"/>

<input name="add" type="button" class="button" value="Close" onClick="window.close();"/>
<div class="clear"></div>



<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

