
<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * users.jsp
	 * Purpose of the JSP -  This is for All Userss.
	 * @author  Mansi
	 * Create Date: 6 June,2008
	 * Revision Date:
	 * Revision By:
	 * @version 1.5
	--%>

<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasTemplate"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.EmpGroups"%>
<%@page import="jkt.hms.masters.business.UserEmpGroup"%>
<%@page import="jkt.hms.masters.business.UserGroups"%>
<%@page import="jkt.hms.masters.business.UserUsergroupHospital"%>
<%@page import="jkt.hms.masters.business.UsergroupHospital"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<script language="javascript">


var $j = jQuery.noConflict();
</script>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	ArrayList searchUserList = (ArrayList)map.get("searchUserList");

	List<Object[]> employeeList = new ArrayList<Object[]>();
	if(map.get("employeeList") != null){
	employeeList = (ArrayList<Object[]>)map.get("employeeList");
	}
	System.out.println("employeeList--->>"+employeeList.size());
	List<MasTemplate> masTemplateList = new ArrayList<MasTemplate>();
	if(map.get("masTemplateList")!=null){
		masTemplateList =(List) map.get("masTemplateList");
	}

	List<Users> userList = new ArrayList<Users>();
	if(map.get("userList") != null){
	userList = (ArrayList)map.get("userList");
	}else if(map.get("searchUserList")!=null){
		userList=(ArrayList)map.get("searchUserList");
	}
	
	List<MasHospital> hospitalList = new ArrayList<MasHospital>();
	
	if(map.get("hospitalList") != null){
		hospitalList = (List<MasHospital>)map.get("hospitalList");
	}
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	}
	String superAdmin = "";
	int userType = 0; /* user type 4 for general user */
	if(session.getAttribute("users") != null){
		 Users user = (Users)session.getAttribute("users");
		 superAdmin = user.getSuperuser()!=null?user.getSuperuser():"n";
		 userType = user.getUserType()!=null?user.getUserType():4;
	}
	List<Object[]> bsScInstList = new ArrayList<Object[]>();
	if(map.get("bsScInstList") != null){
		bsScInstList = (List<Object[]>)map.get("bsScInstList");
	}
	String message="";
	if(map.get("message") != null){
		  message = (String)map.get("message");

		  }

	%>

<h4><span><%=message %></span></h4>
<div class="titleBg">
<h2>User</h2>
</div>
<form name="search" method="post" action="">
<div class="Block">
<div class="clear"></div>
<label>Login Name</label> <input type="text" id="searchField"
	name="<%= LOGIN_NAME%>" value="" validate="Login Name,string,no"
	MAXLENGTH="20" tabindex=1
	onkeypress="return submitenter(this,event,'user?method=searchUser')" />

	
	   
               <%
               	if(userType==5){
               %>
               <label>Institution</label>
               <select name="bsScInst" id="bsScInst">
           	    	<option value="0">Select</option>
               		<%
               			for(Object[] ob : bsScInstList){
               		%>
               			<option value="<%=ob[0]%>"><%=ob[1] %></option>
               		
               		<%} %>
               	
               </select>
               
               
               <%} %>
               <input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','user?method=searchUser','checkSearch')"
	tabindex=1 />
<div class="clear"></div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<%
			if(userList.size()>0)
			 {
				String strForCode = (String)map.get("loginName");

				if(strForCode!= null && strForCode!= "" )
				{
		%> <a href="user?method=showUserJsp">Show All Records</a> <%
				}
			 }
		 if(userList.size()==0 && map.get("search") != null)
		  {
		 %> <a href="user?method=showUserJsp">Show All Records</a> <%
	     }
		%> <script type="text/javascript">

		formFields = [
				[0, "<%= COMMON_ID%>", "id"], [1,"<%=EMPLOYEE_CODE %>"], [2,"<%= EMPLOYEE_NAME %>"], [3,"hospitalId"], [4,"<%=LOGIN_NAME  %>"],
				[5,"<%=PASSWORD %>"],[6,"<%=STATUS%>"],[7,"<%= CHANGED_BY%>"],[8,"<%=CHANGED_DATE%>"],[9,"<%= CHANGED_TIME%>"] ,[10,"empId"],
				[11,"superuser"],[12,"userType"],[13,"imeiNo"],[14,"simNo"],[15,"wipseStatus"],
				[16,"pacsUserName"],[17,"pacsPassword"],[18,"pacsDesignation"],[19,"hospitalName"]];
		 statusTd = 6;
		</script></div>
<div class="clear"></div>
<form name="users" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden"
	name="<%= POJO_NAME %>" value="Users" validate="pojoName,metachar,no"> <input type="hidden"
	name="<%=POJO_PROPERTY_NAME %>" value="LoginName" validate="pojoPropertyName,metachar,no"> <input
	type="hidden" name="title" value="Users" > <input type="hidden"
	name="<%=JSP_NAME %>" value="user" validate="jspName,metachar,no"> <input type="hidden"
	name="pojoPropertyCode" value="LoginName" validate="pojoPropertyCode,metachar,no">

<div class="clear"></div>
<div class="Block">
<label>PEN </label>
<input type="text" name="<%= EMPLOYEE_CODE%>" value="" validate="EmployeeCode,metachar,no"  maxlength="15"   id="employeeCode" onblur="getEmployeeDetails();" />


 <%-- 	<%	if(superAdmin.equalsIgnoreCase("y") || session.getAttribute("userName").equals("admin") || userType<3){ %>
	
	<label>Institution <span>*</span> </label> 
	<select id="hospitalId" name="hospitalId" validate="Institution,metachar,yes" onchange="if(document.getElementById('employeeName').value==''){getHospitalWiseEmpList(this.value);};submitProtoAjax('users','/hms/hms/user?method=getHospitalWiseTemplate')">
	<option value="0">Select</option>
	<%
		if(hospitalList.size()>0){
		for(MasHospital unit : hospitalList){
	%>
		<option value="<%=unit.getId() %>"><%=unit.getHospitalName() %></option>
		<%}
	}
	%>

	</select>	
	<%}else if(userType==5){
		%>	
		 
        <label>Institution</label>
        <select name="hospitalId" id="hospitalId">
    	    	<option value="0">Select</option>
        		<%
        			for(Object[] ob : bsScInstList){
        		%>
        			<option value="<%=ob[0]%>"><%=ob[1] %></option>
        		
        		<%} %>
        	
        </select>
        
        
      
<%}	else{ %>
		<input type="hidden" id="hospitalId" name="hospitalId" value="<%=session.getAttribute("hospitalId") %>" validate="hospitalId,int,no">
	<%} %>	 --%>

<label>Institution<span>*</span></label>
<input type="text" id="hospitalName" name="hospitalName" readonly="readonly" />
<input type="hidden" id="hospitalId" name="hospitalId" validate="hospitalId,int,yes" />


<label>Employee Name<span>*</span></label>
<div id="emp">
<input type="text" id="employeeName" name="<%=EMPLOYEE_NAME %>" value=""  validate="First Name,string,yes"  maxlength="30"/>
<input type="hidden" name="empId" id="empId" value="" validate="empId,int,no"/>
</div>
   <select name="employeeId" id="employeeId" style="display: none">
   <option value="0">Select</option>
   </select>
<div class="clear"></div>
<label>Login Name<span>*</span></label> 
<input id="loginNameId" type="text" name="<%= LOGIN_NAME%>" value="" 	validate="Login Name,string,yes" MAXLENGTH="12" tabindex=1 /> 
	<script>
			document.users.<%=LOGIN_NAME%>.focus();
	</script>
					
<label>Password<span>*</span>  </label> 
<input id="pwd" name=<%=PASSWORD%> type="password" maxlength="15" tabindex="1" validate="Password,metachar,yes" /> 

	<%	if(session.getAttribute("userName").equals("admin")){ %>
	<label style="display: none;">Super User</label>
	<input type="hidden" name="superuser" value=""/>
	<%} %>
		<label>User Type<span>*</span>  </label>
		<select name="userType" validate="User Type,string,yes">

			
					<%
			if(userType<=1){
		%>
				<option value="1">State Admin</option>
				<option value="2">District Admin</option>
				<option value="5">PH Admin</option>
				<option value="3">Institute Admin</option>
				<option value="4" selected="selected">General</option>
			<%}else if(userType==2){ %>
				<option value="5">PH Admin</option>
				<option value="3">Institute Admin</option>
				<option value="4" selected="selected">General</option>
			<%}else if(userType==3){ %>
				<option value="4" selected="selected">General</option>
			<%} %>
			
		</select>
		
<div class="clear"></div>
<label>PACS User Name</label> 
<input id="pacsUserId" name="pacsUserName" type="text" maxlength="32" tabindex="1" validate="" />  
<label>PACS Password</label> 
<input id="pacsPasswordId" name="pacsPassword" type="text" maxlength="32" tabindex="1" validate="" />
<label>PACS Designation</label> 
<select id="pacsDesignationId" name="pacsDesignation">
<option value="-1">Select</option>
<option value="Radiologist">Radiologist</option>
<option value="Physician">Physician</option>
<option value="Technician">Technician</option>
</select> 

<div class="clear"></div>
<label>IMEI No.</label> 
<input id="imeiNoId" type="text" name="imeiNo"  validate="IMEI No,string,no" MAXLENGTH="32" tabindex=1 /> 
<label>SIM No.</label> 
<input id="simNoId" name="simNo" type="text"  maxlength="32" tabindex="1" validate="SIM No.,string,no" /> 
 
<label>Wipe</label> 
<!-- <input type="checkbox" id="wipseId" name="wipseStatus" validate="" value="" /> -->
<select name="wipseStatus" id="wipseId">
<option value="-1">Select</option>
<option value="y">Yes</option>
<option value="n">No</option>
</select>

<h4>
Profiles
</h4>
<div id="testDiv">

<%
	int counterMenu=0;
		if(masTemplateList.size()>0){
		for(MasTemplate masTemplate :masTemplateList){
			++counterMenu;
	%>
	<label class=""><%=masTemplate.getTemplateName()%>
	</label>
	<input type="checkbox" class="radioAuto" name="templetId<%=counterMenu%>" id="templetId<%=counterMenu%>" value="<%=masTemplate.getId()%>" />
	<%
	if(counterMenu%3==0){
		%>
		<div class="clear" style="padding-top:8px"></div>
		<%
	}
	}
	}
	
	%> 
	<input type="hidden" name="counterMenu" id="counterMenu" value="<%=counterMenu%>" />
	<input type="hidden" name="templetCnt" id="templetCnt" value="<%=masTemplateList.size()%>" />
	<div class="clear"></div>
	</div>
	<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button" onClick="submitForm('users','user?method=addUser');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('users','user?method=editUser')" accesskey="u"
	tabindex=1 /> <input type="button" name="Delete" id="deletebutton"
	value="Activate" class="button"
	onClick="submitForm('users','user?method=deleteUser&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" /> <input type="button"
	name="Back" value="Back" class="button" accesskey="b"
	onclick="submitFormForButton('users','superAdmin?method=showModuleManagementJsp')"
	tabindex=1 /> <!-- <input type="reset" name ="Encryptpassword" id="" value ="Encryptpassword" class="button" onclick="submitForm('users','user?method=encryptAllUserPassword')" accesskey="r" /> -->

<input type="hidden" name="<%=STATUS %>" value="" validate="status,metachar,no"/> <input
	type="hidden" name="<%= COMMON_ID%>" value="" validate="commonId,int,no"/>

<div class="clear"></div>
</div>
<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName %></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="DepartmentId" id="DepartmentId" value="1" /> <input
	type="hidden" name="<%=CHANGED_BY%>" value="admin" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
	</div>
	</form>

<script type="text/javascript">
	data_header = new Array();

	data_header[0] = new Array;
	data_header[0][0] = "PEN"
	data_header[0][1] = "data";
	data_header[0][2] = "25%";
	data_header[0][3] = "employeeCode"
	
	data_header[1] = new Array;
	data_header[1][0] = "Employee Name"
	data_header[1][1] = "data";
	data_header[1][2] = "25%";
	data_header[1][3] = "employeeName"
	
	data_header[2] = new Array;
	data_header[2][0] = "Hospital"
		<%	if(superAdmin.equalsIgnoreCase("y") || session.getAttribute("userName").equals("admin")){ %>
	data_header[2][1] = "data";
	<%}else{%>
	
	data_header[2][1] = "hide";
	<%}%>
	data_header[2][2] = "25%";
	data_header[2][3] = "hospitalId"
	
	data_header[3] = new Array;
	data_header[3][0] = "Login Name"
	data_header[3][1] = "data";
	data_header[3][2] = "25%";
	data_header[3][3] = "<%= LOGIN_NAME%>"
	
	data_header[4] = new Array;
	data_header[4][0] = "Password"
	data_header[4][1] = "hide";
	data_header[4][2] = "25%";
	data_header[4][3] = "<%= PASSWORD %>"
	
	data_header[5] = new Array;
	data_header[5][0] = "Status"
	data_header[5][1] = "data";
	data_header[5][2] = "25%";
	data_header[5][3] = "<%=STATUS %>"

	data_header[6] = new Array;
	data_header[6][0] = ""
	data_header[6][1] = "hide";
	data_header[6][2] = "40%";
	data_header[6][3] = "<%= CHANGED_BY%>";

	data_header[7] = new Array;
	data_header[7][0] = ""
	data_header[7][1] = "hide";
	data_header[7][2] = "15%";
	data_header[7][3] = "<%= CHANGED_DATE%>";

	data_header[8] = new Array;
	data_header[8][0] = ""
	data_header[8][1] = "hide";
	data_header[8][2] = 0;
	data_header[8][3] = "<%= CHANGED_TIME%>"

	data_header[9] = new Array;
	data_header[9][0] = ""
	data_header[9][1] = "hide";
	data_header[9][2] = 0;
	data_header[9][3] = "empId"
	
	data_header[10] = new Array;
	data_header[10][0] = ""
	data_header[10][1] = "hide";
	data_header[10][2] = 0;
	data_header[10][3] = "superuser"

	
	data_header[11] = new Array;
	data_header[11][0] = ""
	data_header[11][1] = "hide";
	data_header[11][2] = 0;
	data_header[11][3] = "userType"
	
	data_header[12] = new Array;
	data_header[12][0] = "IMEI No."
	data_header[12][1] = "data";
	data_header[12][2] = "25%";
	data_header[12][3] = "imeiNo"
	
	data_header[13] = new Array;
	data_header[13][0] = "Sim No."
	data_header[13][1] = "data";
	data_header[13][2] = "25%";
	data_header[13][3] = "simNo"
	
	data_header[14] = new Array;
	data_header[14][0] = "Wipe Status"
	data_header[14][1] = "data";
	data_header[14][2] = "25%";
	data_header[14][3] = "wipseStatus"
	
	data_header[15] = new Array;
	data_header[15][0] = "PACS User Name"
	data_header[15][1] = "data";
	data_header[15][2] = "25%";
	data_header[15][3] = "pacsUserName"
	
	data_header[16] = new Array;
	data_header[16][0] = "PACS Password"
	data_header[16][1] = "data";
	data_header[16][2] = "25%";
	data_header[16][3] = "pacsPassword"
	
	data_header[17] = new Array;
	data_header[17][0] = "PACS Designation"
	data_header[17][1] = "data";
	data_header[17][2] = "25%";
	data_header[17][3] = "pacsDesignation"
	
	data_header[18] = new Array;
	data_header[18][0] = "Institution Name"
	data_header[18][1] = "hide";
	data_header[18][2] = "25%";
	data_header[18][3] = "hospitalName"
	
	
	data_arr = new Array();
	<%Iterator itr=userList.iterator();
	          int  counter=0;
	          while(itr.hasNext())
	           {
	        	  Users  users = (Users)itr.next();
	        	  int userTypeDb = 4;
	        	  if(userType>0){
					if (users.getUserType() != null) {
						userTypeDb = users.getUserType();
					}
				}
				if (userTypeDb != 0) {%>

		data_arr[<%= counter%>] = new Array();
		data_arr[<%= counter%>][0] = <%= users.getId()%>
		data_arr[<%= counter%>][1] = "<%=users.getEmployee().getPEN()%>"
			data_arr[<%= counter%>][2] = "<%=users.getEmployee().getEmployeeName()%>"
			data_arr[<%= counter%>][10] = "<%=users.getEmployee().getId()%>"
		<%-- <%

	for(Object[]  masEmployeeGrid : employeeList)
	      {%>
	        
	      
	        data_arr[<%= counter%>][1] = "<%=masEmployeeGrid[3]!=null?masEmployeeGrid[3]:""%>"
			data_arr[<%= counter%>][2] = "<%=masEmployeeGrid[1]%>"
			data_arr[<%= counter%>][10] = "<%=masEmployeeGrid[0]%>"
			
			
			
			<%}%> --%>
	
	<%	if(superAdmin.equalsIgnoreCase("y") || session.getAttribute("userName").equals("admin")){ %>
	<% 

		Iterator itrHospitalList=hospitalList.iterator();
		 while(itrHospitalList.hasNext())
	        {
	         MasHospital  masHospitalGrid = (MasHospital)itrHospitalList.next(); 
			 if(users.getHospital()!=null && users.getHospital().getId().equals(masHospitalGrid.getId()) && masHospitalGrid.getStatus().equalsIgnoreCase("y")){%>
				data_arr[<%= counter%>][3] = "<%=masHospitalGrid.getId()%>";
			<%}else if(users.getHospital()!=null && users.getHospital().getId().equals(masHospitalGrid.getId()) && masHospitalGrid.getStatus().equalsIgnoreCase("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masHospitalGrid.getId()%>";
				
			<%}
	        }
	}else{
	%>
	data_arr[<%= counter%>][3] = "<%=users.getHospital().getId()%>";
	
	<%}%>
	data_arr[<%= counter%>][4] = "<%= users.getLoginName()%>"
	data_arr[<%= counter%>][5] = "<%= (users.getPassword())%>"

		<% if(users.getStatus().equalsIgnoreCase("y")){ %>
		data_arr[<%= counter%>][6] = "Active"
		<%}else{%>
		data_arr[<%= counter%>][6] = "InActive"
		<%}%>
	data_arr[<%= counter%>][7] = "<%= users.getLastChgBy().getLoginName() %>"
	data_arr[<%= counter%>][8] = "<%= HMSUtil.convertDateToStringWithoutTime(users.getLastChgDate()) %>"
	data_arr[<%= counter%>][9] = "<%= users.getLastChgTime() %>"
	
	<%
		if(users.getSuperuser()!=null){
	%>
	data_arr[<%= counter%>][11] = "<%= users.getSuperuser() %>"

	<%}
	if(users.getUserType()!=null){
		%>
		data_arr[<%= counter%>][12] = "<%= users.getUserType() %>"

		<%}if( users.getImeiNo()!=null){%>
			data_arr[<%= counter%>][13] = "<%= users.getImeiNo() %>"
		<%}else{%>
			data_arr[<%= counter%>][13] = ""
		<%}if(users.getSimSerialNo()!=null){%>
		data_arr[<%= counter%>][14] = "<%= users.getSimSerialNo() %>" 
		<%}else{%>
		data_arr[<%= counter%>][14] = ""
		<%}
		
		if("y".equalsIgnoreCase(users.getWipseStatus())){%> 
		data_arr[<%= counter%>][15] ="Yes" 
		<%}else{%>
		data_arr[<%= counter%>][15] ="No" 
		<%}
		
		if(users.getPacsUsername()!=null){%> 
		data_arr[<%= counter%>][16] ="<%=users.getPacsUsername()%>" 
		<%}else{%>
		data_arr[<%= counter%>][16] ="" 
		<%}
		
		if(users.getPacsPassword()!=null){%> 
		data_arr[<%= counter%>][17] ="<%=users.getPacsPassword()%>" 
		<%}else{%>
		data_arr[<%= counter%>][17] ="" 
		<%}
		if(users.getPacsDesignation()!=null){%> 
		data_arr[<%= counter%>][18] ="<%=users.getPacsDesignation()%>" 
		<%}else{%>
		data_arr[<%= counter%>][18] ="" 
		<%}%>
		data_arr[<%= counter%>][19] ="<%=users.getHospital().getHospitalName()%>" 
		<%
		
	  counter++;
	        	  }
	}
	%>
	
	formName = "users"

	//nonEditable = ['<%= CODE%>'];
	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	makeTable(start,end);

	intializeHover('searchresulttable', 'TR', ' tableover');
	
	function getEmployeeDetails()
	{
		var employeeCode = $j("#employeeCode").val();
		
		/* if(employeeCode != "")
			{
				$j("#employeeName").prop('readonly', true);
				$j("#loginNameId").prop('readonly', true);
				
			}
		else
			{
				$j("#employeeName").removeAttr("readonly");
			
			} */
		
		var data = "employeeCode="+employeeCode;
		
		$j.ajax({
			type: "GET",
			url:'user?method=getEmployeeCodeDetails',
			data: data,			
			cache: false,
			success: function(msg)
			{
				if(msg.indexOf("success,Exist") != -1)
					{
					document.getElementById('employeeId').style.display='none';
					document.getElementById('emp').style.display='block';
						var data = new Array();
					    data = msg.split(",");
					    // fill the employeeid in hidden input
					    
					    $j("#empId").val(data[2])
					    $j("#employeeCode").val(data[3])
					    $j("#employeeName").val(data[4])
					   // $j("#hospitalId option[value='"+data[5]+"']").prop("selected","selected");   
					    $j("#hospitalId").val(data[5])
					    $j("#hospitalName").val(data[6]).attr('title',data[6])
					    $j("#imeiNoId").val(data[7]).attr('title',data[7])
					    $j("#simNoId").val(data[8]).attr('title',data[8])
						

						document.getElementById('loginNameId').value=employeeCode;
						document.getElementById('pwd').value=employeeCode;
						
						submitProtoAjax('users','/hms/hms/user?method=getHospitalWiseTemplate&hospitalId='+data[5]);
						
					}else if(msg.indexOf("success,UserExists") != -1){
						alert("User already exist..");
						$j("#employeeCode").val("");
						ResetEmployeeDetails();
					}
				else
					{
					document.getElementById('employeeId').style.display='block';
					document.getElementById('emp').style.display='none';
						alert("PEN does not Exist..");
						$j("#employeeCode").val("");
						ResetEmployeeDetails();
						
					}
			  
			}
			,error: function(msg)
			{
				//alert("error="+msg);
				
			}
		});
		
		
		
		
	}

	
	function ResetEmployeeDetails()
	{
		$j("#empId").val("0");
		$j("#employeeName").val("");
		$j("#employeeCode").val("");
		$j("#loginNameId").val("");
		$j("#pwd").val("");
		
		
		//$j("#hospitalId option[value='0']").prop("selected","selected");
		$j("#hospitalId").val("");
	 
		
	}
	

	function checkSearch(){
		if(document.getElementById('bsScInst')){
			if(document.getElementById('searchField').value == '' && document.getElementById('bsScInst').value==0){
				alert("Please enter value in textfield or select Institution");
	
				return false;
			}else
				return true;
		}else if(document.getElementById('searchField').value == ''){
			alert("Please enter value in textfield");
			
			return false;
		}else
			return true;
		
	}
	</script>
