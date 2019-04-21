<%@page import="jkt.hms.masters.business.EmpScMapping"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.UserWiseBranch"%>
<%@page import="jkt.hms.masters.business.UserDepartment"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascrip"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
 
<%
	String date = "";
	String time = "";
	int hospitalId = 0;
	Box box = HMSUtil.getBox(request);
	//List<EmpScMapping> deptList = new ArrayList<EmpScMapping>();
	List<MasDepartment> deptList = new ArrayList<MasDepartment>();
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	Map map = new HashMap();
 	String userName ="";
 	String deptName = "";
 	String message = "";
 	int userId = 0;
	
 	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
		if (map.get("userName")!=null)
		userName = (String)map.get("userName");
		
		if (map.get("deptName")!=null)
		deptName = (String)map.get("deptName");
		
		if (map.get("deptList")!=null)
			deptList  = (List)map.get("deptList");
		
		
		
		if (map.get("message")!=null)
			message  = (String)map.get("message");
		
		if(map.get("userId")!=null)
			userId = (Integer)map.get("userId");		
    }
%>
<div class="titleBg">
<h2>Change Service Centre</h2>
</div>
<div class="clear"></div>
<script language="Javascript">

function changeDepartment()
{
	var branchObj;
var obj = document.getElementById("wardId");

//var branch = document.getElementById("branchNameId").value;
var dept = document.getElementById("deptNameId").value;


if (obj.value=="")
{
	alert("Pl. Select the Department to be Changed!.....");
	return false;
}


var val = obj.value;

var branchName = "";
var deptName = "";
for(i=0;i<obj.length;i++)
{
 	if (obj.options[i].value==val)
 	{
 	deptName = obj.options[i].text;
 	break;
 	}
}
//alert("deptName="+deptName);
if( document.getElementById("branchId")){
 	branchObj = document.getElementById("branchId");
	var branchVal = branchObj.value;
	for(j=0;j<branchObj.length;j++)
	{
	 	if (branchObj.options[j].value==branchVal)
	 	{
	 		branchName = branchObj.options[j].text;
	 	break;
	 	}
	}
}
//alert("branchName="+branchName);
document.ChangeWardForm.method="post";
if(val == ""){
	deptName = dept;
}
if(branchVal == ""){
	branchName = branch;
}
var str = "superAdmin?method=changeWardInSession&deptName="+deptName+"&branchName="+branchName;
submitForm('ChangeWardForm',str);
}

</script>
</head>

<body>
<form name="ChangeWardForm">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
<h4><span> <%
		out.println(message); 
		%> </span></h4> 
<label>User Name </label> <input type="text"
	value="<%=userName%>" class="readOnly" readonly size="20"  validate="User Name,metachar,no"/>

<label>Service Centre Name </label> <input type="text" value="<%=deptName%>" id="deptNameId"
	class="readOnly" readonly size="30" validate="deptName,metachar,no"/>
<%-- <label>Branch Name </label> <input type="text" id="branchNameId" value="<%=branchName%>"
	class="readOnly" readonly size="30" /> --%>

<label class="auto" style="padding:0px 12px 0px 5px;">Service Centre to be Changed</label> 
<!-- <select name="ward" id="wardId" onchange="submitProtoAjax('ChangeWardForm','/hms/hms/superAdmin?method=showBranchList');"> -->
<select name="ward" id="wardId">
	<option value="">--Select Ward --</option>
<%-- 	<%
		for (EmpScMapping dept : deptList) 
		{
				if(deptName.equals(dept.getDepartment().getDepartmentName())){
		%>
	<option value="<%=dept.getDepartment().getId()%>" selected="selected"><%=dept.getDepartment().getDepartmentName()%></option>
	<%}else{%>
		<option value="<%=dept.getDepartment().getId()%>"><%=dept.getDepartment().getDepartmentName()%></option>
	<%}
		}
		%> --%>
		<%
		for (MasDepartment dept : deptList) 
		{
				if(deptName.equals(dept.getDepartmentName())){
		%>
	<option value="<%=dept.getId()%>" selected="selected"><%=dept.getDepartmentName()%></option>
	<%}else{%>
		<option value="<%=dept.getId()%>"><%=dept.getDepartmentName()%></option>
	<%}
		}
		%>
</select>

<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="change" onClick="changeDepartment();"
	value="Submit" class="button">
<div class="clear"></div>
</div>
<div class="division"></div>
<div class="clear"></div></form>
