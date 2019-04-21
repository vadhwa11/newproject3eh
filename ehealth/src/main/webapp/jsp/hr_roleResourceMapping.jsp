<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject> projectList = new ArrayList<MstrProject>();
				List<MstrProjectrole> projectRoleList = new ArrayList<MstrProjectrole>();
				List<PrjRolewiseResourceReq> prjRoleWiseResourceList = new ArrayList<PrjRolewiseResourceReq>();
				List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<PrjRoleResMappingHeader> roleResMappingHeaderList = new ArrayList<PrjRoleResMappingHeader>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
				}
				if(map.get("projectRoleList")!= null){
					projectRoleList = (List)map.get("projectRoleList");
				}
				if(map.get("prjRoleWiseResourceList")!= null){
					prjRoleWiseResourceList = (List)map.get("prjRoleWiseResourceList");
				}
				if(map.get("departmentList")!= null){
					departmentList = (List)map.get("departmentList");
				}
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
				}
				if(map.get("roleResMappingHeaderList")!= null){
					roleResMappingHeaderList = (List)map.get("roleResMappingHeaderList");
				}

				if(map.get("message") != null){
					String message = (String)map.get("message");
					out.println(message);
					}

				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");
				String time = (String)utilMap.get("currentTime");


				String userName = "";
				if(session.getAttribute("userName") != null){
					userName = (String)session.getAttribute("userName");
				}
				String projectName = "";
				String projectCode = "";
				String sponsorName  = "";
				String trialPhase = "";
				String protocolNo = "";
				String projectType = "";
				String projectStatus = "";
				BigDecimal budget = new BigDecimal("0");
				Date StartDate = new Date();
				Date endDate = new Date();
				String loiDate = "";
				String purchaseDate = "";
				String conTractDate = "";
				String purchaseOrderNo = "";
				String contractNo = "";
				String loino = "";
				int projectId = 0;
				if(projectList.size()>0){
					for (MstrProject mstrProject :projectList){
						projectName= mstrProject.getPrjName();
						projectCode = mstrProject.getPrjCode();
						sponsorName = mstrProject.getSponsor().getSponsorName();
						trialPhase = mstrProject.getTrialPhase().getTrialPhaseName();
						if(mstrProject.getPrjProtocalno()!= null){
						protocolNo = mstrProject.getPrjProtocalno();
						}
						projectType = mstrProject.getProjectType().getProjectName();
						projectStatus = mstrProject.getProjectStatus().getPrjsName();
						if(mstrProject.getPrjExpectedbudget()!= null){
						budget = mstrProject.getPrjExpectedbudget();
						}
						StartDate = mstrProject.getPrjStdt();
						endDate  = mstrProject.getPrjEddt();
						if(mstrProject.getPrjLoidt()!= null){
						loiDate = HMSUtil.convertDateToStringWithoutTime(mstrProject.getPrjLoidt());
						}
						if(mstrProject.getPrjLoino()!= null){
						loino = mstrProject.getPrjLoino();
						}
						if(mstrProject.getPurchasOrderDate()!= null ){
							purchaseDate = HMSUtil.convertDateToStringWithoutTime(mstrProject.getPurchasOrderDate());
						}
						if(mstrProject.getContractDate()!= null){
							conTractDate = HMSUtil.convertDateToStringWithoutTime(mstrProject.getContractDate());
						}
						if(mstrProject.getContractNo()!= null){
							contractNo = mstrProject.getContractNo();
						}
						if(mstrProject.getPurchaseOrderNo()!= null){
							purchaseOrderNo = mstrProject.getPurchaseOrderNo();
						}
						projectId = mstrProject.getId();
					}
				}


	%>
<%@page import="jkt.hrms.masters.business.PrjMilestone"%>
<%@page import="jkt.hrms.masters.business.MstrProjectrole"%>
<%@page import="jkt.hrms.masters.business.PrjRolewiseResourceReq"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hrms.masters.business.PrjRoleResMappingHeader"%>
<script type="text/javascript">

	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}

	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'

</script>
<script type="text/javascript"><!--
	function calculateAmount()
	{
		var totalAmount = document.getElementById('totalAmountId').value;
		var paymentPercentage = document.getElementById('paymentPercentageId').value;
		if(totalAmount != "" && paymentPercentage!=""  )
		{
		var totalAmt = parseFloat(totalAmount);
		var amtInpercentage = parseFloat(paymentPercentage);
		var amount = (totalAmt * paymentPercentage)/100;
		document.getElementById('amountId').value=amount;
		 }
	}

	function backProjectSetting()
	{
		 obj = eval('document.'+formName)
  		 obj.action = "projectTracking?method=showProjectVitalsJsp";
  		 obj.submit();
  		 return true;

	}
	function nextrojectSetting()
	{
		 var id = <%=projectId%>
		 obj = eval('document.'+formName)
  		 obj.action = "projectTracking?method=showFeasibilityStudyJsp&projectId="+id;
  		 obj.submit();
  		 return true;

	}
	function assignTask()
	{
		var rrhId = 0;
		 for(var i = 0; i < document.getElementsByName('roleResourceHeader').length; i++){
			  if(document.getElementsByName('roleResourceHeader')[i].checked == true)
              {
				rrhId = document.getElementsByName('roleResourceHeader')[i].value;
			  }
  		}
		 var id = <%=projectId%>
		 obj = eval('document.'+formName)

  		 obj.action = "projectTracking?method=showTaskSettingForProjectRole&projectId="+id+"&aaa="+rrhId;
  		 obj.submit();
  		 return true;

	}

	function display(idvalue) {
	<%
	for(PrjRolewiseResourceReq prjRolewiseResourceReq:prjRoleWiseResourceList){
		int id =prjRolewiseResourceReq.getPjr().getId();

	%>
	if(idvalue == <%=id%> ){
    document.getElementById('reqResourceId').value = '<%= prjRolewiseResourceReq.getResCount() %>'
	}
<%}%>
}


function validateRadio(){
			 for(var i = 0; i < document.getElementsByName('roleResourceHeader').length; i++){
			//alert("i-- "+i)
			//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
			  if(document.getElementsByName('roleResourceHeader')[i].checked == true)
              {
				return true;
			  }
  		}
  		alert("Please select the Project Role")
		return false;

	}
</script>


<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="java.math.BigDecimal"%>
<div class="titleBg"><h2>Role Resource Mapping </h2></div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Project Name</label>
<label ><%=projectName %></label>
<label>Project Code</label>
<label><%=projectCode %></label>
<label>Sponsor Name</label>
<label class="auto"><%=sponsorName %></label>
<div class="clear"></div>
<label>Trial Phase </label>
<label><%=trialPhase %></label>
<label>Protocol No </label>
<label><%=protocolNo %></label>
<label>Project Type</label>
<label><%=projectType %></label>
<div class="clear"></div>
<label>Project Status </label>
<label><%=projectStatus %></label>
<label>Expected Budget </label>
<label><%=budget %></label>
<label>Start Date</label>
<label><%=HMSUtil.convertDateToStringWithoutTime(StartDate) %></label>
<div class="clear"></div>
<label>End Date </label>
<label><%=HMSUtil.convertDateToStringWithoutTime(endDate )%></label>
<label>LOI Date </label>
<label><%=loiDate %>&nbsp;</label>
<label>LOI No</label>
<label><%=loino %>&nbsp;</label>
<div class="clear"></div>
<div class="clear"></div>
<label>Purchase Date </label>
<label><%=purchaseDate %>&nbsp;</label>
<label>Purchase Order No </label>
<label><%=purchaseOrderNo %>&nbsp;</label>
<label>Contract Date</label>
<label><%=conTractDate %>&nbsp;</label>

<div class="clear"></div>
<label>Contract No vishal</label>
<label><%=contractNo %>&nbsp;</label>
</div>
<div class="clear"></div>
<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2 >
<div id="searchtable" tabindex=2 ></div>

<script type="text/javascript">

formFields = [
[0, "<%= ROLE_RESOURCE_MAPPING_HEADER_ID%>", "id"], [1,"radioId"], [2,"<%= PROJECT_ROLE_ID %>"],[3,"<%=EMPLOYEE_ID%>"],[4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],
[7,"<%=PROJECT_ID%>"],[8,"<%=REQUIRED_NO%>"],[9,"<%=DEPARTMENT_ID%>"],[10,"<%=STATUS%>"]];
statusTd =10;
</script>
</div>
<div class="clear"></div>
<form name="roleResourceMapping" method="post" action="" >
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>

<label><span>*</span>Project Role </label>
<select  name="<%=PROJECT_ROLE_ID %>" validate="Project Role,string,yes"   onchange="display(this.value);" >
<option value="0">Select</option>
<%
for(PrjRolewiseResourceReq prjRolewiseResourceReq:prjRoleWiseResourceList){
%>
<option value="<%=prjRolewiseResourceReq.getPjr().getId() %>"><%=prjRolewiseResourceReq.getPjr().getPjrName() %></option>
<%} %>
</select>
<input type="hidden" name="<%=PROJECT_ID %>"  value="<%=projectId %>" />
<!--
<label><span>*</span>Required No </label>
<input type="text" id="reqResourceId"   name="<%=REQUIRED_NO %>" readonly="readonly" validate="Required No,int,yes"   maxlength="3" />
-->

<label><span>*</span>Department </label>
<select id="currencyId" name="<%=DEPARTMENT_ID %>" validate="Department,string,yes"  onChange="populateEmployee(this.value,'roleResourceMapping')" >
<option value="0">Select</option>
<%
for(MasDepartment masDepartment :departmentList){
%>
<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
<%} %>
</select>

<label><span>*</span>Employee </label>
<select id="headId" name="<%=EMPLOYEE_ID %>" validate="Employee,string,yes" >
<option value="0">Select</option>
<%
for(MasEmployee masEmployee :employeeList){ %>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName().trim()+" "+masEmployee.getLastName().trim()%></option>
<%} %>
</select>
<div class="clear"></div>
</div>
<script type="text/javascript">

<%
int count=0;
for (MasDepartment masDepartment :departmentList)
{
for (MasEmployee masEmployee :employeeList)
{
if(masEmployee.getDepartment() != null){
if(masDepartment.getId().equals(masEmployee.getDepartment().getId())){
%>
empArr[<%=count%>] = new Array();
empArr[<%=count%>][0] = <%=masDepartment.getId()%>;
empArr[<%=count%>][1] = <%=masEmployee.getId()%>;
empArr[<%=count%>][2] = "<%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%>";
<%
count++;
}
}
}
}
%>
</script>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('roleResourceMapping','projectTracking?method=saveRoleResourceMapping');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('roleResourceMapping','projectTracking?method=updateRoleResourceMapping')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('projectCreation','training?method=deleteTrainingMaster&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="button" name="add" id="addbutton" value="Back" class="button" onClick="backProjectSetting();" accesskey="a" tabindex=1 />
<input type="button" name="add" id="addbutton" value="Next" class="button" onClick="nextrojectSetting();" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Task Setting"  class="button" onClick="if(validateRadio()){assignTask()};" accesskey="u" tabindex=1 />
<div class="clear"></div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<div class="clear"></div>
<label>Last Changed By</label>
<label class="value"><%=userName%></label>

<label>Last Changed DATE</label>
<label class="value"><%=date%></label>

<label>Last Changed Time</label>
<label class="value"><%=time%></label>
</div>

			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= ROLE_RESOURCE_MAPPING_HEADER_ID%>" value="" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Select"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "radioId";

data_header[1] = new Array;
data_header[1][0] = "Project Role"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= PROJECT_ROLE_ID %>";

data_header[2] = new Array;
data_header[2][0] = "Employee"
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "<%=EMPLOYEE_ID%>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = "10%";
data_header[3][3] = "<%= CHANGED_BY%>";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_DATE %>";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%= CHANGED_TIME %>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=PROJECT_ID%>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%=REQUIRED_NO%>";

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = "15%";
data_header[8][3] = "<%=DEPARTMENT_ID%>";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = "15%";
data_header[9][3] = "<%=STATUS%>";


data_arr = new Array();

<%


Iterator itr=roleResMappingHeaderList.iterator();
int  counter=0;
while(itr.hasNext())
{


	PrjRoleResMappingHeader prjRoleResMappingHeader= (PrjRoleResMappingHeader)itr.next();
	if(prjRoleResMappingHeader.getEmployee()!= null){
		if(prjRoleResMappingHeader.getEmployee().getStatus()!= null){
if(prjRoleResMappingHeader.getEmployee().getStatus().equals("y")){

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= prjRoleResMappingHeader.getId()%>

data_arr[<%= counter%>][1] = '<input name="roleResourceHeader"  class="radioCheck"   type="radio" value="<%=prjRoleResMappingHeader.getId()%>" />';

<%
	if(projectRoleList.size()>0){
		for(MstrProjectrole mstrProjectrole :projectRoleList){
			if(prjRoleResMappingHeader.getPjr()!= null){
		if(mstrProjectrole.getId().equals(prjRoleResMappingHeader.getPjr().getId())){
%>
data_arr[<%= counter%>][2] = "<%= mstrProjectrole.getPjrName() %>"
<%
		}
			}
		}
	}

%>
<%
	if(employeeList.size()>0){
		for(MasEmployee masEmployee :employeeList){
			if(prjRoleResMappingHeader.getEmployee()!= null){
			if(masEmployee.getId().equals(prjRoleResMappingHeader.getEmployee().getId()) && masEmployee.getStatus().equals("y")){ %>
				data_arr[<%= counter%>][3] = "<%=masEmployee.getFirstName().trim()+" "+masEmployee.getLastName().trim()%>"
	<%
			}else if(masEmployee.getId().equals(prjRoleResMappingHeader.getEmployee().getId()) && masEmployee.getStatus().equals("n")){


				%>
				data_arr[<%= counter%>][3] = ""

		<%	}
			}else{

				%>
				data_arr[<%= counter%>][3] = ""

		<%
			}
		}
	}

%>



<% if(prjRoleResMappingHeader.getLastChgBy()!= null){%>
data_arr[<%= counter%>][4] = "<%= prjRoleResMappingHeader.getLastChgBy() %>"
<%
	}else{
%>
data_arr[<%= counter%>][4] = ""
<%
	}
%>
<% if(prjRoleResMappingHeader.getLastChgDate()!= null){%>
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(prjRoleResMappingHeader.getLastChgDate()) %>"
<%
	}else{
%>
data_arr[<%= counter%>][5] = ""
<%
	}
%>
<% if(prjRoleResMappingHeader.getLastChgDate()!= null){%>
data_arr[<%= counter%>][6] = "<%= prjRoleResMappingHeader.getLastChgTime() %>"
<%
	}else{
%>
data_arr[<%= counter%>][6] = ""
<%
	}
%>
<%
	if(projectList.size()>0){
		for(MstrProject mstrProject :projectList){
			if(prjRoleResMappingHeader.getPrj()!= null){
		if(mstrProject.getId().equals(prjRoleResMappingHeader.getPrj().getId())){
%>
data_arr[<%= counter%>][7] = "<%= mstrProject.getId() %>"
<%
		}
			}
		}
	}

%>


data_arr[<%= counter%>][8] = "<%= prjRoleResMappingHeader.getRequiredResource() %>"



data_arr[<%= counter%>][9] = "<%=prjRoleResMappingHeader.getDepartment().getId() %>"

<%

if(prjRoleResMappingHeader.getStatus().equals("y")){ %>
data_arr[<%= counter%>][10] = "Active"
<%}else{%>
data_arr[<%= counter%>][10] = "InActive"
<%}%>


<%

counter++;
}}
}
}
%>


formName = "roleResourceMapping"

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');


</script>


