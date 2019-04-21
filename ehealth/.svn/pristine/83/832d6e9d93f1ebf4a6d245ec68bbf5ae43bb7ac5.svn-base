<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showPatientList.jsp  
 * Purpose of the JSP -  This is Show Patient List.
 * @author  Deepti
 * @author  Ritu
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.15
--%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->


function fillId(id){

document.getElementById("userId").value=id

}
</script>
<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	
	
	List users = new ArrayList();
	String search = "";
	
	if(map.get("users")!= null)
	{
		users=(List)map.get("users");
	}
	
	if(map.get("search")!= null)
	{
		search=(String)map.get("search");
	}

	
%>
<div class="titleBg">
<h2>Module Management</h2>
</div>
<div class="clear"></div>



<%
		if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
    %>





<form name="searchBlock" method="post" action="">

<div class="Block">
<label>User Name</label> <input type="text"
	name="userSearch" id="userSearch" value="" validate="userSearch,string,no"/> <label class="NoWidth">Login
Name</label> <input type="text" name="loginSearch" id="loginSearch" value="" validate="loginSearch,string,no"/>
<div class="clear"></div>
<div class="clear"></div>
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('searchBlock','superAdmin?method=showRecordsForModuleManagement');" />

<div class="clear"></div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<jsp:include page="searchResultBlockForIPD.jsp" />
<div class="clear"></div>

<form name="moduleManagement" method="post" action="">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input
	name="userId" id="userId" type="hidden"> <!-- <input type="button" class="button"  value="Clinical Setup" align="left" onClick="submitForm('patientList','ipd?method=showNursingCareJsp','validateRadio');" />-->
<!-- <div style="width: auto; height: 400px; float:left; border: 1px solid #ffffff;">
	<div><img src="/hms/jsp/images/sec.jpg" width="172" height="26"></div>
	
	<input type="image" src="/hms/jsp/images/hosp_master.jpg"  onClick="submitForm('moduleManagement','user?method=showHospitalJsp');" /><br/>
	<input type="image" src="/hms/jsp/images/user_group.jpg"  onClick="submitForm('moduleManagement','user?method=showUserGroupsJsp');" /><br/>
	<input type="image" src="/hms/jsp/images/empGroups.jpg"  onClick="submitForm('moduleManagement','user?method=showGroupsJsp');" /><br/>
	<input type="image" src="/hms/jsp/images/user_creation.jpg"  onClick="submitForm('moduleManagement','user?method=showUserJsp');" /><br/>
	
	<input type="image" src="/hms/jsp/images/add_applications.jpg"  onClick="submitForm('moduleManagement','user?method=showApplicationJsp');" /><br/>
	<input type="button" class="userMgmtButt" value=" " align="left"   onClick="submitForm('moduleManagement','superAdmin?method=showUserManagementJsp','validateRadioForSecurity');" /><br/>
	
	<input type="image" src="/hms/jsp/images/user_group_hosp.jpg"  onClick="submitForm('moduleManagement','user?method=showUsergroupHospitalJsp');" /><br/>
	<input type="image" src="/hms/jsp/images/user_hosp_maint.jpg"  onClick="submitForm('moduleManagement','user?method=showUserHospitalMaintenanceJsp');" /><br/>
	<input type="image" src="/hms/jsp/images/user_dept.jpg" 		onClick="submitForm('moduleManagement','user?method=showUserDepartmentJsp');" /><br/>
	<input type="image" src="/hms/jsp/images/buttonsDetail.jpg" 		onClick="submitForm('moduleManagement','user?method=showButtonMasterJsp');" /><br/>
	<input type="image" src="/hms/jsp/images/rem_butt_rights.JPG" 		onClick="submitForm('moduleManagement','superAdmin?method=showRemoveButtonRights','validateRadioForSecurity');" /><br/>
	<input type="image" src="/hms/jsp/images/view_user_rights.jpg" 		onClick="submitForm('moduleManagement','superAdmin?method=viewUserRightsJsp','validateRadioForSecurity');" /><br/>
	<input type="image" src="/hms/jsp/images/changeOrder.JPG" 		onClick="submitForm('moduleManagement','superAdmin?method=showOrderApplicationJsp');" /><br/> 
	<div><img src="/hms/jsp/images/ward_footer.jpg" width="172" height="1"></div>
	</div>  -->
<div>
<div class="leftMenu">Security Module



<div class="clear"></div>
<input type="button" class="button"
	onClick="submitForm('moduleManagement','user?method=showHospitalJsp');"
	value="Hospital Master" /> <input type="button" class="button"
	onClick="submitForm('moduleManagement','user?method=showUserGroupsJsp');"
	value="Application Group Master" /> <input type="button"
	value="Employee Group" class="button"
	onClick="submitForm('moduleManagement','user?method=showGroupsJsp');" />
<input type="button" class="button"
	onClick="submitForm('moduleManagement','user?method=showUserJsp');"
	value="User Creation" /> <input type="button" class="button"
	onClick="submitForm('moduleManagement','user?method=showApplicationJsp');"
	value="Add Applications" /> <input type="button" class="button"
	onClick="submitForm('moduleManagement','superAdmin?method=showUserManagementJsp','validateRadioForSecurity');"
	value="User Management" /> <input type="button" class="button"
	onClick="submitForm('moduleManagement','user?method=showUsergroupHospitalJsp');"
	value="Application Group &amp; Hospital" /> <input type="button"
	class="button"
	onClick="submitForm('moduleManagement','user?method=showUserHospitalMaintenanceJsp');"
	value="User Application Master" /> <input type="button" class="button"
	onClick="submitForm('moduleManagement','user?method=showUserDepartmentJsp');"
	value="User Department" /> <input type="button" class="button"
	value="Buttons Detail"
	onClick="submitForm('moduleManagement','user?method=showButtonMasterJsp');" />
<input type="button" class="button" value="Remove Buttons Detail"
	OnClick="submitForm('moduleManagement','superAdmin?method=showRemoveButtonRights','validateRadioForSecurity');" />
<input type="button" class="button" value="View User Rights"
	onClick="submitForm('moduleManagement','superAdmin?method=viewUserRightsJsp','validateRadioForSecurity');" />
<input type="button" class="button" value="Change Order"
	onClick="submitForm('moduleManagement','superAdmin?method=showOrderApplicationJsp');" />
</div>

<div id="test" class="floatRight">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2 class="small" style="margin-top:0px";></div>

<% try{
		  if(map!=null && map.get("search")!=null && map.get("search").equals("YES"))
		  {
			 %> <a href="superAdmin?method=showModuleManagementJsp">Show All
Records</a> <%
		     }
	   }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
    %> <script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= RequestConstants.USER_ID%>", "id"],[1, "<%= RequestConstants.USER_NAME%>"], [2,"<%= RequestConstants.LOGIN_NAME%>"], [3,"<%= RequestConstants.EMP_STATUS_CODE %>"] ];
	 statusTd =3;

</script></div>
<div id="edited"></div>
<label>&nbsp;</label>
<div id="statusMessage" class="messagelabel"><br />
</div>
</div>
</div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = "Radio"
		data_header[0][1] = "radio";
		data_header[0][2] = "5%";
		data_header[0][3] = "<%= RequestConstants.USER_ID%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "User Name"
		data_header[1][1] = "data";
		data_header[1][2] = "10%";
		data_header[1][3] = "<%= RequestConstants.USER_NAME%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "Login Name"
		data_header[2][1] = "data";
		data_header[2][2] = "10%";
		data_header[2][3] = "<%= RequestConstants.LOGIN_NAME %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "Employee Code"
		data_header[3][1] = "data";
		data_header[3][2] = "10%";
		data_header[3][3] = "<%= RequestConstants.EMP_STATUS_CODE %>";
		
		data_arr = new Array();
		
		<%
			
			Iterator iterator=users.iterator();
		    int  i=0;
		          while(iterator.hasNext())
		           {   
		        	  
		        	  Users userObj= (Users) iterator.next();
		        	  if(userObj.getStatus().equalsIgnoreCase("y") )
		        	  {
		        	  	String userName=userObj.getUserName();
		        	  	String loginName=userObj.getLoginName();
		        	  	MasEmployee empObj=(MasEmployee)userObj.getEmployee();
		        	  	String empCode=empObj.getEmployeeCode();
		        	  
		        	  
		        	  
		        	  
		%>
		
			data_arr[<%= i%>] = new Array();
			
			data_arr[<%= i%>][0] =<%=userObj.getId()%>
			
			data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="userId" value="<%= userObj.getId()%>" id="parent" onclick="fillId(this.value)" />'
			
			<%
				if(userName != null)
				{
			%>
			data_arr[<%= i%>][2] = "<%=userName%>"
			<%
				}else{
			%>
			data_arr[<%= i%>][2] = ""
			<%
				}
			   if(loginName != null)
			   {
			%>
			data_arr[<%= i%>][3]="<%=loginName%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][3]=""
			<%
				}
			   if(empCode != null)
			   {
			%>
			data_arr[<%= i%>][4] = "<%=empCode%>"
			<%
			   }else{
			%> 
			data_arr[<%= i%>][4] = ""
		<%}%>
		
		
		 
		<% 	
			i++;
			}
		  }
		%>
		 
		formName = "moduleManagement"
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeGridForPatient(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
</script> <input type="hidden" name="counter" id="counter" value="<%=i %>" validate="counter,int,no"/> <script
	type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>