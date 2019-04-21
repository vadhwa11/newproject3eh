<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * department.jsp  
 * Purpose of the JSP -  This is for Department details 
 * @author  Dipali
 * @author  Vishal
 * Create Date: 07th April,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>

<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasDepartmentType"%>
<%@page import="jkt.hms.masters.business.MasCostCenter"%>

<%

	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
	List<MasDepartmentType> departmentTypeList = new ArrayList<MasDepartmentType>();
	List<MasDepartment> storeTypeList = new ArrayList<MasDepartment>();
	List<MasDepartment> gridStoreTypeList = new ArrayList<MasDepartment>();
	departmentTypeList = (ArrayList)map.get("departmentTypeList");
	costCenterList = (ArrayList)map.get("costCenterList");
	ArrayList searchDepartmentList = (ArrayList)map.get("searchDepartmentList");
	ArrayList gridCostCenterList = (ArrayList)map.get("gridCostCenterList");
	ArrayList gridEmpDeptList = (ArrayList)map.get("gridEmpDeptList");
	ArrayList gridDepartmentTypeList = (ArrayList)map.get("gridDepartmentTypeList");
	List<MasEmployeeDepartment> masEmployeeDepartmentList = new ArrayList<MasEmployeeDepartment>();
	masEmployeeDepartmentList = (ArrayList)map.get("masEmployeeDepartmentList");
	storeTypeList = (ArrayList)map.get("storeTypeList");
	gridStoreTypeList= (ArrayList)map.get("gridStoreTypeList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		 String  message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		 <%} %> 

<div class="titleBg">
<h2>Service Centre </h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Service Centre  Code </label> 
<input type="radio"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" />
<label>Service Centre  Name </label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" />

<input type="hidden" name="colCode" value="department_code">
<input type="hidden" name="colName" value="department_name">

<input type="text" id="searchField"	name="<%= SEARCH_FIELD%>" value="" validate="Department Code,string,no"	MAXLENGTH="8" tabindex=1 />

<input type="button" name="search"	value="Search" class="button" onclick="submitForm('search','systemRelatedMaster?method=searchDepartment','checkSearch')"
	tabindex=1 /> 
<%--- Report Button   
<input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/> --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_department">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</div>
<div class="clear"></div>
</div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
		if(searchDepartmentList.size()>0 )
		{
			String strForCode = (String)map.get("departmentCode");
			String strForCodeDescription = (String)map.get("departmentName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
%> 
				<h4><a href="systemRelatedMaster?method=showDepartmentJsp">Show All Records</a></h4> <%
			}
		}
		if(searchDepartmentList.size()==0 && map.get("search") != null)
	  	{
%>
    		<h4><a href="systemRelatedMaster?method=showDepartmentJsp">Show All Records</a></h4>
<%
        }
%>
     <script type="text/javascript">
	
	formFields = [
			[0, "<%=COMMON_ID%>", "id"], [1,"<%=CODE%>"], [2,"<%=SEARCH_NAME %>"], [3,"<%=DEPARTMENT_TYPE_ID%>"],  [4,"<%=CHANGED_BY%>"], [5,"<%=CHANGED_DATE %>"],[6,"<%=CHANGED_TIME %>"],[7,"<%=STATUS%>"],[8,"deptDescription"],[9,"empDeptId"],[10,"visitApplicable"],[11,"payWard"]];
	 statusTd = 7;
	</script></div>

<form name="department" method="post" action=""><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 <input
	type="hidden" name="<%= POJO_NAME %>" value="MasDepartment"><input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="DepartmentName"><input
	type="hidden" name="title" value="Department"><input
	type="hidden" name="<%=JSP_NAME %>" value="department"><input
	type="hidden" name="pojoPropertyCode" value="DepartmentCode">
	<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">

<input id="codeId" type="hidden" name="<%= CODE%>" value=""	validate="Department Code,string,no" class="textbox_size20"	MAXLENGTH="8" tabindex=1></input> 
<label><span>*</span> Service Centre  </label>
<input type="text" name="<%= SEARCH_NAME %>" value=""	validate="Service Centre ,string,yes" class="textbox_size20" MAXLENGTH="30" tabindex=1 />

<script>
		document.department.<%=CODE%>.focus();
	</script> 
	<label><span>*</span> Service Centre Category</label> <select
	name="<%= DEPARTMENT_TYPE_ID %>" validate="Service Centre Category,string,yes" onchange="displayPayWard(this.value);"
	tabindex=1>
	<option value="">Select</option>
	<% 
		for (MasDepartmentType  masDepartmentType : departmentTypeList)
		{
	%>
	<option value="<%=masDepartmentType.getId ()%>"><%=masDepartmentType.getDepartmentTypeName()%></option>
	<%
		}
	%>
</select>

<label>Description</label>
<input id="deptDescription" type="text" name="deptDescription"validate="Description,string,no" class="textbox_size20"MAXLENGTH="100" ></input>
<div class="clear"></div>

<label><span>*</span> Department</label> 
<select	name="empDeptId" validate="Department,string,yes"	tabindex=1 id="empDeptId" >
	<option value="">Select</option>
	<% 
		for (MasEmployeeDepartment  masEmployeeDepartment : masEmployeeDepartmentList)
		{
	%>
	<option value="<%=masEmployeeDepartment.getId()%>"><%=masEmployeeDepartment.getEmpDeptName()%></option>
	<%	
		}
	%>
</select>

<label>Visit  Applicable</label> 

<select name="visitApplicable" id="wipseId">
<option value="-1">Select</option>
<option value="y">Yes</option>
<option value="n">No</option>
</select>

  <div id="payWardDiv" style="display: none">
 <label>Pay Ward </label> 
 <input id="payWard" name="payWard" type="checkbox" value="Y" class="small"/>
 </div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('department','systemRelatedMaster?method=addDepartment');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"	id="editbutton" value="Update" class="button" style="display: none;"	onClick="submitForm('department','systemRelatedMaster?method=editDepartment')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"	id="deletebutton" value="Activate" class="button"	style="display: none;"	onClick="submitForm('department','systemRelatedMaster?method=deleteDepartment&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"	id="reset" value="Reset" class="buttonHighlight"	onclick="resetCheck();" accesskey="r" /> <input type="hidden"
	name="<%=STATUS %>" value="" /> 
	<input type="hidden"	name="<%= COMMON_ID%>" value="" />

<div class="clear"></div>
</div>
<div class="clear"></div>

<div class="bottom"><label>Changed By:</label> 
<label	class="value"><%=userName%></label> <label>Changed Date:</label> 
<label	class="value"><%=date%></label> <label>Changed Time:</label> 
<label	class="value"><%=time%></label> 
<input type="hidden"	name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

</form>
<div class="clear"></div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Service Centre  Code"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Service Centre Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Service Centre Category"
data_header[2][1] = "data";
data_header[2][2] = "25%";
data_header[2][3] = "<%=DEPARTMENT_TYPE_ID %>";


data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CHANGED_DATE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%=CHANGED_TIME %>";

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";




data_header[7] = new Array;
data_header[7][0] = "Description"
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "deptDescription";



data_header[8] = new Array;
data_header[8][0] = "Emp Dept"
data_header[8][1] = "hide";
data_header[8][2] = "15%";
data_header[8][3] = "empDeptId";

data_header[9] = new Array;
data_header[9][0] = "Visit Applicable"
data_header[9][1] = "data";
data_header[9][2] = "15%";
data_header[9][3] = "visitApplicable";

data_header[10] = new Array;
data_header[10][0] = "Pay Ward Status"
data_header[10][1] = "hide";
data_header[10][2] = "15%";
data_header[10][3] = "payWard";

data_arr = new Array();

<%
Iterator itr=searchDepartmentList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasDepartment  masDepartment = (MasDepartment)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masDepartment.getId()%>
data_arr[<%= counter%>][1] = "<%=masDepartment.getDepartmentCode()%>"
data_arr[<%= counter%>][2] = "<%= masDepartment.getDepartmentName()%>"

<%
		Iterator itrGridDepartmentTypeList=gridDepartmentTypeList.iterator();
		 while(itrGridDepartmentTypeList.hasNext())
            {
			 
			 try{
             MasDepartmentType  departmentTypeGrid = (MasDepartmentType)itrGridDepartmentTypeList.next(); 
           
			 if(masDepartment.getDepartmentType()!=null && masDepartment.getDepartmentType().getId().equals(departmentTypeGrid.getId()) && departmentTypeGrid.getStatus().equalsIgnoreCase("y")){%>
				data_arr[<%= counter%>][3] = "<%=departmentTypeGrid.getDepartmentTypeName()%>"
			<%}else if(masDepartment.getDepartmentType()!=null && masDepartment.getId().equals(departmentTypeGrid.getId()) && departmentTypeGrid.getStatus().equalsIgnoreCase("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=departmentTypeGrid.getDepartmentTypeName()%>";
				
			<%}
            }catch(Exception e){e.printStackTrace();}}%>
            
data_arr[<%=counter%>][4] = "<%= masDepartment.getLastChgBy().getUserName() %>";
data_arr[<%=counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masDepartment.getLastChgDate()) %>"
data_arr[<%=counter%>][6] = "<%= masDepartment.getLastChgTime() %>"
<% if(masDepartment.getStatus().equalsIgnoreCase("Y")){ %>
data_arr[<%=counter%>][7] = "Active";
<%}else{%>
data_arr[<%=counter%>][7] = "InActive";
<%}%>
<%if(masDepartment.getDeptDescription()!=null){%>
data_arr[<%=counter%>][8] = "<%=masDepartment.getDeptDescription()%>";
<%}else{%>
data_arr[<%=counter%>][8] = "";
<%}%>



 <%
		Iterator itrGridEmpDeptList=gridEmpDeptList.iterator();
		 while(itrGridEmpDeptList.hasNext())
         {try{
          MasEmployeeDepartment  masEmployeeDepartment = (MasEmployeeDepartment)itrGridEmpDeptList.next(); 
			 if(masDepartment.getEmpDept()!=null && masDepartment.getEmpDept().getId().equals(masEmployeeDepartment.getId()) && masEmployeeDepartment.getStatus().equalsIgnoreCase("y")){%>
				data_arr[<%=counter%>][9] = "<%=masEmployeeDepartment.getEmpDeptName()%>";
			<%}else if(masDepartment.getEmpDept()!=null  && masDepartment.getEmpDept().getId().equals(masEmployeeDepartment.getId()) && masEmployeeDepartment.getStatus().equalsIgnoreCase("n")){%>
				data_arr[<%= counter%>][9] = "<font id='error'>*</font>Parent InActivated--<%=masEmployeeDepartment.getEmpDeptName()%>";
				
			<%}
         }catch(Exception e){e.printStackTrace();} }     %> 
         
         <%
     	if("y".equalsIgnoreCase(masDepartment.getVisitApplicable())){ %> 
		data_arr[<%= counter%>][10] ="Yes" 
		<%}else{ %>
		data_arr[<%= counter%>][10] ="No" 
		<%}%>
		
		 <%
	     	if("y".equalsIgnoreCase(masDepartment.getPaywardCheck())){ %> 
			data_arr[<%= counter%>][11] ="y" 
			<%}else{ %>
			data_arr[<%= counter%>][11] ="n" 
			<%}%>





<%
	counter++;
}
%>
 
formName = "department";

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		

	function displayPayWard(val){
		if(val==10){
			document.getElementById('payWardDiv').style.display = 'block';	
		}else{
			document.getElementById('payWardDiv').style.display = 'none';	
		}
		
	}





</script>
