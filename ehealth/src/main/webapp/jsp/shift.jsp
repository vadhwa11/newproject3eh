<%@page import="jkt.hms.masters.business.MasEmpCategory"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasShift"%>
<%@page import="jkt.hrms.masters.business.HrMasShiftCodes"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<HrMasShiftCodes> masShiftCodesList = new ArrayList<HrMasShiftCodes>();
				List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
				List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
				List<HrMasShift> masShiftList = new ArrayList<HrMasShift>();
				List<HrMasShift> singleMasShiftList = new ArrayList<HrMasShift>();
				List<MasEmpCategory> masEmpCategoryList = new ArrayList<MasEmpCategory>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("masHospitalList")!= null){
					masHospitalList = (List)map.get("masHospitalList");
				}
				if(map.get("masDepartmentList")!= null){
					masDepartmentList = (List)map.get("masDepartmentList");
				}
				if(map.get("masShiftCodesList")!= null){
					masShiftCodesList = (List)map.get("masShiftCodesList");
				}
				if(map.get("masShiftList")!= null){
					masShiftList = (List)map.get("masShiftList");
				}
				if(map.get("singleMasShiftList")!= null){
					singleMasShiftList = (List)map.get("singleMasShiftList");
				}
				if(map.get("masEmpCategoryList")!= null){
					masEmpCategoryList = (List)map.get("masEmpCategoryList");
				}
				String message = "";
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
				int hospitalId = 0;
				int departmentId = 0;
				int shiftuniqueId = 0;
				int ShiftCodeId = 0;
				int empCatId = 0;
				String empCatName = "";
				String shiftCodeName = "";
				String departmentName = "";
				String startTime = "";
				String endTime = "";
				if(masHospitalList.size()>0){
					MasHospital masHospital = masHospitalList.get(0);
					hospitalId = masHospital.getId();
				}
				if(singleMasShiftList.size()>0){
					for(HrMasShift hrMasShift: singleMasShiftList){
							if(hrMasShift.getId()!= null){
								shiftuniqueId = (Integer)hrMasShift.getId();
							}
							if(hrMasShift.getShiftCodes().getId()!= null){
								ShiftCodeId = (Integer)hrMasShift.getShiftCodes().getId();
							}
							if(hrMasShift.getDepartment().getId()!= null){
								departmentId = (Integer)hrMasShift.getDepartment().getId();
							}
							if(hrMasShift.getShiftStartTime()!= null){
							startTime = (String)hrMasShift.getShiftStartTime();
							}
							if(hrMasShift.getShiftStartTime()!= null){
								endTime = (String)hrMasShift.getShiftEndTime();
								}
							
							if(hrMasShift.getShiftCodes().getShiftName()!= null){
								departmentName = (String)hrMasShift.getDepartment().getDepartmentName();
								}
							
							
							if(hrMasShift.getEmployeeCategory()!= null){
								empCatId = (Integer)hrMasShift.getEmployeeCategory().getId();
								}

							if(hrMasShift.getEmployeeCategory()!= null){
								empCatName = (String)hrMasShift.getEmployeeCategory().getEmpCategoryName();
								}
 			}
		}

	%>
<%
	if(message!= null){
%>
<h4><span><%=message %></span></h4>
<%} %>
<form name="shift" method="post" action="">
<div class="titleBg">
<h2>Shift MASTER</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Shift </label> 
<select	name="<%=SHIFT_CODE_ID %>" validate="Shift Code,alphanumeric,yes"	>
<option value="0">Select</option>
<%
for(HrMasShiftCodes  hrMasShiftCodes:masShiftCodesList){
%>
<option value="<%=hrMasShiftCodes.getId() %>"><%=hrMasShiftCodes.getShiftName() %></option>
<%}%>
</select> 
<script type="text/javascript">
document.shift.<%=SHIFT_CODE_ID%>.value='<%=ShiftCodeId%>';
</script> 
<label><span>*</span> Service Centre </label> 
<select name="<%=DEPARTMENT_ID %>" validate="Service Centre,alphanumeric,yes" onchange="displayDepartment(this.value,'masDepartmentId');"	>
<option value="0">Select</option>
<%
for(MasDepartment masDepartment :masDepartmentList){
%>
<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
<%	}%>
</select> 
  <script type="text/javascript">
document.shift.<%=DEPARTMENT_ID%>.value='<%=departmentId%>';
</script> 
 
<label><span>*</span> Start Time</label> 
<input name="<%=START_TIME %>"	id="startTimeId" title="Time Should be in 24 hr Format" validate="Start Time,string,yes" onKeyUp="mask(this.value,this,'2,5',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="8" /> 
<script	type="text/javascript">
document.shift.<%=START_TIME%>.value='<%=startTime%>';
</script> 
<div class="clear"></div>
<label><span>*</span> End Time</label> 
<input	name="<%=END_TIME %>" id="endTimeId" validate="End Time,string,yes" title="Time Should be in 24 hr Format" onKeyUp="mask(this.value,this,'2,5',':');" onBlur="IsValidTime(this.value,this.id);" maxlength="8" /> 
<script	type="text/javascript">
document.shift.<%=END_TIME%>.value='<%=endTime%>';
</script>

<label><span>*</span> Employee Category </label> 
<select name="<%=EMPLOYEE_CATEGORY %>" validate="Employee Category ,alphanumeric,yes"	>
<option value="0">Select</option>
<%
for(MasEmpCategory masEmpCategory :masEmpCategoryList){
%>
<option value="<%=masEmpCategory.getId() %>"><%=masEmpCategory.getEmpCategoryName() %></option>
<%	}%>
</select> 
 <script type="text/javascript">
document.shift.<%=EMPLOYEE_CATEGORY%>.value='<%=empCatId%>';
</script> 

<div class="clear"></div>
</div>
<div class="division"></div>
<div id="pageNavPosition"></div>
<!--table starts-->
<table id="searchresulttable" width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Service Centre</th>
		<th scope="col">Shift</th>
		<th scope="col">Start Time</th>
		<th scope="col">End Time</th>
		<th scope="col">Employee Category</th>
	</tr>
	<tbody id="tableData">
		<%
  		String shiftCode = "";
  		String shiftName = "";
	  	 int  counter=0;
	  	String klass = "even";
  		if(masShiftList.size()>0){
	 			for(HrMasShift hrMasShift :masShiftList){
	  				String url = "attendance?method=editShiftDetails&"+SHIFT_ID +"="+hrMasShift.getId();
	  			 	
	  		  			String id = "";
	  			 		id = "id" + counter;
	  			 		counter++;
	  			 		
	  			 		if(counter%2==0){
	  			 			klass = "even"; 
	  			 		}
	  			 		else
	  			 		{
	  			 			klass= "odd";
	  			 		}
  	
  	
  %>
		<tr class=<%= klass%> id="<%=counter%>"
			onclick="parent.location='<%=url %>'">

			<%
	for(MasDepartment masDepartment :masDepartmentList){
		if(masDepartment.getId()!=null){
			if(hrMasShift.getDepartment()!=null){
			if(hrMasShift.getDepartment().getId()!=null){
		if(masDepartment.getId().equals(hrMasShift.getDepartment().getId())){

    %>
			<td><a	href="javascript:Request(document.getElementById('<%=counter %>'),'shift')"><%=masDepartment.getDepartmentName() %></a></td>
			<%}
		}
			}
		}else{%>
		<td></td>	
	<%}
 	}
 		for(HrMasShiftCodes hrMasShiftCodes:masShiftCodesList){ 
 			if(hrMasShiftCodes.getId().equals(hrMasShift.getShiftCodes().getId())){
 				shiftCode = hrMasShiftCodes.getShiftCode();
 				shiftName = hrMasShiftCodes.getShiftName();
 			}
 		}
  %>    <%  if(hrMasShift.getDepartment()!=null){ %>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'shift')"><%=shiftName %></a></td>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'shift')"><%=hrMasShift.getShiftStartTime() %></a></td>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'shift')"><%=hrMasShift.getShiftEndTime() %></a></td>
 
		

		<%
  }%>
  	<%
	for(MasEmpCategory masEmpCategory :masEmpCategoryList){
			if(hrMasShift.getEmployeeCategory()!=null){
		
		if(masEmpCategory.getId().equals(hrMasShift.getEmployeeCategory().getId())){

    %>
			<td><a	href="javascript:Request(document.getElementById('<%=counter %>'),'shift')"><%=masEmpCategory.getEmpCategoryName() %></a></td>
			<%}
		
			}else{
		%>
		<td></td>	
	<%}
  }%>
  </tr>
  <%}
  		}
  
  %>
	</tbody>
</table>
<!--table ends--> <script>
	  var pager = new Pager('tableData',5); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);

	  </script>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<%
	if(singleMasShiftList.size()>0){
%> 
<input name="Update" type="button" class="button" value="Update" onClick="submitForm('shift','attendance?method=updateShiftDetails');" />
<%
	}else{
%> 
<input name="save" type="button" class="button" value="Save" onClick="submitForm('shift','attendance?method=saveShiftDetails');" />
<%	}%> 
<input type="reset" name="Reset" value="Reset"	class="buttonHighlight" onclick="resetValues();" accesskey="r" /> 
<input	type="hidden" name="<%=HOSPITAL_ID %>" value="<%=hospitalId%>" /> 
<input	type="hidden" name="<%=SHIFT_ID %>" value="<%=shiftuniqueId%>">
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<div class="clear"></div>
<label>Last Changed By</label> <label class="value"><%=userName%></label>
<label>Last Changed DATE</label> <label class="value"><%=date%></label>
<label>Last Changed Time</label> <label class="value"><%=time%></label>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> 
<div class="paddingTop40"></div>
<div class="paddingTop40"></div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>
<script	type="text/javascript">
function displayDepartment(idvalue,displayFieldName){
	
<%
	for(MasDepartment masDepartment:masDepartmentList){
		int departmentIdValue = masDepartment.getId();
		
	%>
	if(idvalue == <%=departmentIdValue%> ){
    document.getElementById('masDepartmentId').value = '<%= masDepartment.getDepartmentName()%>'
	
	}
<%
	}%>
 }

function resetValues(){
submitForm('shift','attendance?method=showShiftJsp');
	}	 
</script>
 