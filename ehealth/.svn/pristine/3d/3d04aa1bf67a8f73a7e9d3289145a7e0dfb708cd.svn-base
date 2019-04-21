<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * patientType.jsp
 * Purpose of the JSP -  This is for Patient Type.
 * @author Ujjwal
 * Create Date: 25th Feb,2009
 * Revision Date:
 * Revision By:
 * @version 1.8
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasBranch"%>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<Users> userList = new ArrayList<Users>();
	Set<Users> userSet = new HashSet<Users>();
	List<Users> userList1 = new ArrayList<Users>();
	List<MasBranch> branchList = new ArrayList<MasBranch>();
	List<UserWiseBranch> userWiseBranchList = new ArrayList<UserWiseBranch>();
	List<Object[]> searchBranchList = new ArrayList<Object[]>();
	List<UserDepartment> userDeptList = new ArrayList<UserDepartment>();
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("departmentList")!= null){
		departmentList = (List<MasDepartment>)map.get("departmentList");
	}
	if(map.get("userSet")!= null){
		userSet = (Set<Users>)map.get("userSet");
	}
	if(map.get("userList")!= null){
		userList = (List<Users>)map.get("userList");
	}
	if(map.get("userList1")!= null){
		userList1 = (List<Users>)map.get("userList1");
	}
	if(map.get("branchList")!= null){
		branchList = (List<MasBranch>)map.get("branchList");
	}
	if(map.get("userWiseBranchList")!= null){
		userWiseBranchList = (List<UserWiseBranch>)map.get("userWiseBranchList");
	}
	if(map.get("searchBranchList")!= null){
		searchBranchList = (List<Object[]>)map.get("searchBranchList");
	}
	if(map.get("userDeptList")!= null){
		userDeptList = (List<UserDepartment>)map.get("userDeptList");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
		   
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.UserDepartment"%>
<%@page import="jkt.hms.masters.business.UserWiseBranch"%><h4><span><%=message %></span></h4>
<%} %>

<div class="titleBg">
<h2>User Wise Branch</h2>
</div>

<div class="clear"></div>
<div class="division"></div>

<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

 <script type="text/javascript">

	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= DEPARTMENT_ID%>"], [2,"<%= USER_ID %>"], [3,"<%= BRANCH_ID %>"],[4,"<%=BRANCH_NAME%>"],[5,"<%=STATUS%>"] ];
	 statusTd = 4;
	</script></div>
<div class="clear"></div>

<form name="userWiseBranch" method="post" action="">

<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Department</label>
<select id="deptId" name="<%=DEPARTMENT_ID %>">
<option value="0">Select</option>
<%if(departmentList.size()>0){
	for(MasDepartment masDepartment :departmentList){
	%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
<%}
	}%>
</select>
 <label><span>*</span> User</label>
<select id="userId" name="<%=USER_ID %>">
<option value="0">Select</option>
<%if(userSet.size()>0){
	for(Users users:userSet){
		//for(UserDepartment userDepartment :userDeptList){
			//if(users.getId().equals(userDepartment.getUser().getId())){
	%>
	<option value="<%=users.getId() %>"><%=users.getUserName() %></option>
<%}}
	%>
</select>
<label><span>*</span> Branch Name </label> 
<select name="<%=BRANCH_ID %>" multiple size="6" validate="Branch Name,string,yes" tabindex=1 class="list">
	<%if(branchList.size()>0){
	for(MasBranch masBranch:branchList){
	%>
	<option value="<%=masBranch.getId() %>"><%=masBranch.getBranchDesc() %></option>
<%}
	}%>
</select>


<div class="clear"></div></div>
<div class="clear"></div>
<div class="division"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('userWiseBranch','superAdmin?method=addUserWiseBranch');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('userWiseBranch','superAdmin?method=editUserWiseBranch')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('branch','generalMaster?method=deleteBranch&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
 <input type="hidden" name="<%=STATUS %>" value="" />
  <input type="hidden" name="<%= COMMON_ID%>" value="" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="bottom">
<label>Changed By:</label>
 <label class="value"><%=userName%></label>
 <label>Changed Date:</label>
  <label class="value"><%=date%></label>
   <label>Changed Time:</label>
    <label class="value"><%=time%></label>
     <input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
      <input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
      <input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
      </div>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Department"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= DEPARTMENT_ID%>"

data_header[1] = new Array;
data_header[1][0] = "User"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= USER_ID %>";

data_header[2] = new Array;
data_header[2][0] = "Branch Id"
data_header[2][1] = "hide";
data_header[2][2] = "20%";
data_header[2][3] = "<%= BRANCH_ID %>"

data_header[3] = new Array;
data_header[3][0] = "Status"
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%=BRANCH_NAME%>";

data_header[4] = new Array;
data_header[4][0] = "Status"
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "<%=STATUS%>";



data_arr = new Array();

<%

Iterator itr=userWiseBranchList.iterator();

          int  counter=0;
          while(itr.hasNext())
           {


            UserWiseBranch  userWiseBranch= (UserWiseBranch)itr.next();
            //MasDepartment  masDepartment= (MasDepartment)itr.next();
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= userWiseBranch.getId()%>
<%if(departmentList.size()>0){
	for(MasDepartment  masDepartment:departmentList){
	if(masDepartment.getId().equals(userWiseBranch.getDepartment().getId())){
	%>
data_arr[<%= counter%>][1] = "<%=masDepartment.getDepartmentName()%>"

<%}}}%>
	<%if(userSet.size()>0){
	for(Users users:userSet){
	if(userWiseBranch.getUser().getId().equals(users.getId())){
	%>
data_arr[<%= counter%>][2] = "<%= users.getUserName()%>"
<%}}}%>

<%if(branchList.size()>0){
	for(MasBranch masBranch:branchList){
	if(userWiseBranch.getBranch().getId().equals(masBranch.getId())){
	%>
data_arr[<%= counter%>][3] = "<%=userWiseBranch.getBranch().getBranchDesc()%>"
<%}}}%>

<%
 StringBuffer branch_ids = new StringBuffer();
StringBuffer branch_names = new StringBuffer();
if(branchList.size()>0){
	for(MasBranch masBranch:branchList){
	if(userWiseBranch.getBranch().getId().equals(masBranch.getId())){
	
		  if (branch_ids.toString().length() > 0)
		  {
			  branch_ids.append(",");
			  branch_ids.append(masBranch.getId());
			  branch_names.append(masBranch.getBranchDesc());
		  }
		  else
		  {
			  branch_ids.append(masBranch.getId());
			  branch_names.append(masBranch.getBranchDesc());
		  }
	  }
}
}

%>
data_arr[<%= counter%>][3] = "<%=branch_ids.toString()%>"

	data_arr[<%= counter%>][4] = "<%=branch_names.toString()%>"


<% if(userWiseBranch.getStatus().equals("y")){ %>
data_arr[<%= counter%>][5] = "Active"
<%}else{%>
data_arr[<%= counter%>][5] = "InActive"
<%}%>


<%
		     counter++;
}
%>




formName = "userWiseBranch"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');
</script>
