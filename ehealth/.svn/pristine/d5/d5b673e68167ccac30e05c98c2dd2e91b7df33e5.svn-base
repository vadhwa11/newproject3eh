
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page import="static jkt.hms.util.RequestConstants.UPLOAD_FILENAME" %>

<form name="attachFile" method="post" action="" enctype="multipart/form-data">
<div class="titleBg"> <h2>KMSCL Stock Import </h2></div>
<div class="clear"></div>
<%
Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null)
	map = (Map<String,Object>) request.getAttribute("map");
String msg = "";
if(map.get("msg") != null){
	msg = (String)map.get("msg");
}
Set<String> itemsNotAvailable = new HashSet<String>();
//String itemsNotAvailable = "";
if(map.get("itemsNotAvailable") != null){
	itemsNotAvailable = (HashSet<String>)map.get("itemsNotAvailable");
}
String items = "";
for(String s : itemsNotAvailable){
	if(!items.equals("")){
		items +=", "+s;
	}else
		items +=""+s;
}
if(!msg .equals("")){%>
	<h4><span><%=msg %></span></h4>
		<div class="clear"></div>
	<% }
%>
<%
	if(!items.equals("")){
		%>
		<h4><span>Items not available in Ehealth:</span></h4>
		<h4><span><%=items %></span></h4>
	<%}
%>
<div class="Block">
<div class="clear"></div>
<label>Select File</label>
 <input type="file" name="<%=UPLOAD_FILENAME %>" id="uploadFilename">
 <input type="hidden" id="fileName" name="fileName" vale="" />
 
<input name="add" type="button" class="button" value="Import" onClick="jsImport();"/>
 </div>
 </form> 
 
 <script>
 function jsImport()
 {
	 var fname =document.getElementById('uploadFilename').value;
	if (document.attachFile.<%=UPLOAD_FILENAME%>.value=="")
		{
		alert('Pl. Select the Excel file to Import!.....');
		return;
		}
		var fname = document.attachFile.<%=UPLOAD_FILENAME%>.value;
		var st = fname.length;
		st = st-3;
		if (fname.substring(st)!="xls")
		{
		alert('Only Excel files are Allowed.');
		return;
		}
		//var deptId= document.getElementById('departmentId').value;
		document.attachFile.encoding="multipart/form-data";
			//alert(document.departmentIndentGrid.encoding);
		var ind = fname.lastIndexOf("\\");
		var filename = fname.substring(ind+1);
		//document.departmentIndentGrid.method="post";
		/* submitForm('departmentInd','stores?method=importPVMSOpeningBalance&filename='+filename,'checkDepartment'); */
		submitForm('attachFile','stores?method=importKMSCLStock&filename='+filename+'&'+csrfTokenName+'='+csrfTokenValue);

 	
 }
 </script>