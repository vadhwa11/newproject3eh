<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hospital.jsp  
 * Purpose of the JSP -  This is for All Hospital Master.
 * @author  Mansi
 * Create Date: 04 June,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.UserDepartment"%>


<script type="text/javascript">

/***********************************************
* Textarea Maxlength script- © Dynamic Drive (www.dynamicdrive.com)
* This notice must stay intact for legal use.
* Visit http://www.dynamicdrive.com/ for full source code
***********************************************/
function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}

</script>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	List<Users> searchUsersList = new ArrayList<Users>();
	searchUsersList= (ArrayList)map.get("searchUsersList");
	List<Users> userList = new ArrayList<Users>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<UserDepartment> searchUserDepartmentList = new ArrayList<UserDepartment>();
	userList = (ArrayList)map.get("userList");
	departmentList = (ArrayList)map.get("departmentList");
	searchUserDepartmentList = (ArrayList)map.get("searchUserDepartmentList");
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	}
	 String message = "";
	 if(map.get("message") != null){
		    message = (String)map.get("message");
		   
		  }
 %>

<h4><span><%=message %></span></h4>
<div class="titleBg">
<h2>User Department</h2>
</div>
<div class="clear"></div>


<form name="search" method="post" action="">
<div class="Block">
<div class="clear"></div>
<label>User Name</label> <input type="text" name="userSearch" validate="User Name,string,no"
	id="userSearch" value="" class="radio" /> <label>Login Name</label> <input
	type="text" name="loginSearch" id="loginSearch" value="" class="radio"  validate="Login Name,string,no"/>
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','user?method=searchUserDepartment');" />

<div class="clear"></div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

<div class="clear"></div>
<div class="paddingTop15"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
  if(searchUsersList.size()>0)
   {
   String strForUserName = (String)map.get("userName");
   String strForDepartmentName = (String)map.get("departmentName");
   if(strForUserName!= null && strForUserName!= "" || strForDepartmentName!= null && strForDepartmentName!= "")
   {
 %>
<div class="clear"></div>
<a href="user?method=showUserDepartmentJsp">Show All Records</a> <%
		
		  }
	   }
	 if(searchUsersList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="user?method=showUserDepartmentJsp">Show All Records</a> <%
    }
	%> <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= USER_ID%>"], [2,"<%= DEPARTMENT_ID %>"],[3,"<%=DEPARTMENT_NAME%>"],[4,"<%=STATUS%>"]];
  statusTd =4;
 </script></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<form name="usergroupHospital" method="post" action="">
<div class="Block"><input type="hidden" name="<%=JSP_NAME %>"  validate="jspName,metachar,no"
	value="userGroupHospital"> <label><span>*</span> User
Name </label> <select name="<%=USER_ID %>" validate="User Name,string,yes"
	tabindex=1>
	<option value="">Select</option>
	<%
          		if(userList != null){ 	
          			for (Iterator iter = userList.iterator(); iter.hasNext();) {
          				Users users = (Users) iter.next();
          %>
	<option value="<%=users.getId() %>"><%=users.getUserName() %></option>
	<%		
         			}
         		 } 
         %>
</select> <label><span>*</span> Department Name </label> <select
	name="<%=DEPARTMENT_ID %>" multiple size="6"
	 tabindex=1 class="list">
	<%
          		if(departmentList != null){ 	
          			for (Iterator iter = departmentList.iterator(); iter.hasNext();) {
          				MasDepartment masDepartment = (MasDepartment) iter.next();
          %>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%		
         		}
         	    } 
         %>
</select>
<div class="clear"></div></div>
<div class="clear"></div>

<div id="edited"></div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onclick="submitForm('usergroupHospital','user?method=addUserDepartment');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('usergroupHospital','user?method=editUserDepartment')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('usergroupHospital','user?method=deleteUserDepartment&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" /> <input type="button"
	name="Back" value="Back" class="button" accesskey="b"
	onclick="submitFormForButton('usergroupHospital','superAdmin?method=showModuleManagementJsp')"
	tabindex=1 /> <input type="hidden" name="<%=STATUS %>" value="" validate="status,metachar,no"/> <input
	type="hidden" name="<%= COMMON_ID%>" value="" validate="commonId,int,no"/>
<div class="clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName %></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="admin" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
<div class="paddingTop40"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "UserName"
data_header[0][1] = "data";
data_header[0][2] = "10%";
data_header[0][3] = "<%= USER_ID%>"

data_header[1] = new Array;
data_header[1][0] = "Department Ids"
data_header[1][1] = "hide";
data_header[1][2] = "0%";
data_header[1][3] = "<%= DEPARTMENT_ID %>";

data_header[2] = new Array;
data_header[2][0] = "Department Code(s)"
data_header[2][1] = "data";
data_header[2][2] = "50%";
data_header[2][3] = "<%=DEPARTMENT_NAME%>";

data_header[3] = new Array;
data_header[3][0] = "Status"
data_header[3][1] = "data";
data_header[3][2] = "5%";
data_header[3][3] = "<%=STATUS %>";




data_arr = new Array();
<%
Iterator itr=searchUsersList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {            
        	  Users  users = (Users)itr.next();       
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= users.getId()%>
data_arr[<%= counter%>][1] = "<%=users.getUserName()%>"

<%
 		  StringBuffer dept_ids = new StringBuffer();
		  StringBuffer dept_names = new StringBuffer();
		  String status = "";
		  int temp =0;
    	  for (Iterator iterator = searchUserDepartmentList.iterator(); iterator.hasNext();)
    	  {
    		  UserDepartment userDepartment = (UserDepartment)iterator.next();
    		  if (users.getId() == userDepartment.getUser().getId())
        	  {
    			  status = userDepartment.getStatus();
        		  if (dept_ids.toString().length() > 0)
        		  {
        			  dept_ids.append(",");
        			  dept_ids.append(userDepartment.getDepartment().getId());
        		  }
        		  else
        		  {
        			  dept_ids.append(userDepartment.getDepartment().getId());
        		  }
        		  
        		  if (dept_names.toString().length() > 0)
        		  {
        			  dept_names.append(",");
        			  if(temp ==7){
        				  temp=0;
        				  dept_names.append("\\n");
        				  dept_names.append(userDepartment.getDepartment().getDepartmentCode());
        			  }else{
        			  dept_names.append(userDepartment.getDepartment().getDepartmentCode());
        			  }
        		  }
        		  else
        		  {
        			  if(temp ==7){
        				  temp=0;
        				  dept_names.append("\\n");
        				  dept_names.append(userDepartment.getDepartment().getDepartmentCode());
        			  }else{
        			  dept_names.append(userDepartment.getDepartment().getDepartmentCode());
        			  }
        		  }

        		  temp++;
        	  }
    		 
	      }
    	  
    %>
data_arr[<%= counter%>][2] = "<%=dept_ids.toString()%>"
<% if(status.equals("y")){ %>
data_arr[<%= counter%>][4] = "Active"
<%}else{%>
data_arr[<%= counter%>][4] = "InActive"
<%}%>

data_arr[<%= counter%>][3] = "<%=dept_names.toString()%>"

<%
		     counter++;
}
%>
 
formName = "usergroupHospital"

start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>