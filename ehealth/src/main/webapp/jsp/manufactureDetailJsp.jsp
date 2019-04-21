

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>


<head> 
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css"	id="vbulletin_css" />
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar2.js"></script>



<title>Manufacture Detail</title>


</head>
<%
	Map map = new HashMap();
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Box box = HMSUtil.getBox(request);


	if (request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");

	}

%>



<div id="mainIn">
<form name="manufactureDetail" action="" method="post">
<div class="titleBg">
<h2>Manufacture Detail</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label>Manufacture Name</label> 
<input type="text"	name="manufactureName"  id="manufactureName" /> 


<label>Postal Address</label> 
<textarea rows="" cols=""></textarea>

<label>Email Id</label>
<input type="text"	name="emailId"  id="emailId" /> 


<div class="clear"></div>


<label>Mobile Number</label>
<input type="text"	name="mobileNumber"  id="mobileNumber" /> 


<label>Land Line Number</label>
<input type="text"	name="landLineNumber"  id="landLineNumber" /> 

<label>Url</label>
<input type="text"	name="url"  id="url" /> 

<input	type="button" name="Submit" id="addbutton" value="Submit" class="button" accesskey="a" /> 
<input	type="button" name="Submit" id="addbutton"	value="Reset" class="button" accesskey="a" /> 

<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
</form>
</div>
