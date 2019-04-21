<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * transferApplicationApproval.jsp  
 * Purpose of the JSP -  This is for Dependent Employee.
 * @author  Javed
 * Create Date: 6th Mar,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.1
--%>

<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hrms.masters.business.HrMasShiftCodes"%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%-- <%@page import="jkt.hms.masters.business.MasGrade"%> --%>
<%@page import="jkt.hms.masters.business.MasCadre"%>
<%@page import="jkt.hms.masters.business.HrTransferApplicationM"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasShift"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script>
	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String dateCal=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(dateCal.length()<2){
			dateCal="0"+dateCal;
		}
		
	%>
		serverdate = '<%=dateCal+"/"+month+"/"+year%>'
			 function abc(){
		
		 var mon = document.getElementById('month').value;
			
			if (mon=="4" || mon=="6" || mon=="8" || mon=="9" || mon=="11"){
				/*  document.getElementById('apr').style.display = "inline";
				 document.getElementById('jan').style.display = "none"; */
				 
				document.getElementById('apr').style.display = "none";
				
			} else{
				/* document.getElementById('apr').style.display = "none";
				 document.getElementById('jan').style.display = "inline"; */
				 document.getElementById('apr').style.display = "none";
			}
		 } 

</script>
 
<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	Map<String, Object> map1 = new HashMap<String, Object>();
	
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");	

	Map<String,Object> map = null;
	if(request.getAttribute("map")!=null)
	{
		map = (Map)request.getAttribute("map");
	}
	
	if(map.get("map1")!=null)
	{
		map1 = (Map)map.get("map1");
	}

	List<MasEmployee> empList = new ArrayList<MasEmployee>();
	List<MasEmployeeDepartment> departList = new ArrayList<MasEmployeeDepartment>();
	List<MasRank> desigList = new ArrayList<MasRank>();
	List<MasDistrict> distList = new ArrayList<MasDistrict>();
	//List<MasGrade> gradeList = new ArrayList<MasGrade>();
	List<MasCadre> cadreList = new ArrayList<MasCadre>();
	List<MasHospital> hosList = new ArrayList<MasHospital>();
	List<HrTransferApplicationM> hrTransferApplicationMList = new ArrayList<HrTransferApplicationM>();
	List<MasHospitalType> hosTypeList = new ArrayList<MasHospitalType>();
	
	if(map.get("empList") != null){
		empList = (List<MasEmployee>)map.get("empList");	
	}
	if(map.get("departList") != null){
		departList = (List<MasEmployeeDepartment>)map.get("departList");
	}
	if(map.get("desigList") != null){
		desigList = (List<MasRank>)map.get("desigList");
	}
	if(map.get("distList") != null){
		distList = (List<MasDistrict>)map.get("distList");
	}
	/* if(map.get("gradeList") != null){
		gradeList = (List<MasGrade>)map.get("gradeList");
	} */
	if(map.get("cadreList") != null){
		cadreList = (List<MasCadre>)map.get("cadreList");
	}
	if(map.get("hosList") != null){
		hosList = (List<MasHospital>)map.get("hosList");
	}
	if(map.get("hosTypeList") != null){
		hosTypeList = (List<MasHospitalType>)map.get("hosTypeList");
	}
	if(map.get("hrTransferApplicationMList") != null){
		hrTransferApplicationMList = (List<HrTransferApplicationM>)map.get("hrTransferApplicationMList");
	}
	
	String message = ""; 
	if(map.get("msg")!=null)
	{
		message = (String)map.get("msg");
	}
	
	int hosId=0;
	if(empList.size() > 0){
		 hosId= empList.get(0).getId();
	}
	 %>
<h4><span><%=message %></span></h4>
<div class="titleBg">
<h2>Transfer Approval</h2>
</div>
<div class="clear"></div>
<div class="Block">

<div id="searcharea">
<div id="searchbar">

 <form name="search" method="post" action=""> 
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
 
<label>Department</label> 
<select name="dept" id='dept' validate="Department,string,no">	
<option value="">Select</option>
	<% for(MasEmployeeDepartment md: departList){%>
	<option value="<%=md.getId() %>"><%=md.getEmpDeptName()%>
	</option>
	<%} %>
</select>
 
<label>Designation</label> 
<select name="desig" id='desig' validate="Department,string,no">	
<option value="">Select</option>
	<% for(MasRank md: desigList){%>
	<option value="<%=md.getId() %>"><%=md.getRankName()%>
	</option>
	<%} %>
</select> 

<label>Employee</label> 
<select name="emp" id='emp' validate="Employee,string,no">	
<option value="">Select</option>
	<% for(MasEmployee md: empList){
			if(md.getEmployeeName() != null){
	%>

	<option value="<%=md.getId() %>"><%=md.getEmployeeName()%>
	</option>
	<%} }%>
</select> 
<div class="clear"></div>


<%-- <label>Grade</label> 
<select name="grade" id="grade" validate="Department,string,no">	
<option value="">Select</option>
	<% for(MasGrade md: gradeList){%>

	<option value="<%=md.getId() %>"><%=md.getGradeName()%>
	</option>
	<%} %>
</select>  --%>

<label>Cadre</label> 
<select name="cadre" id='cadre' validate="Department,string,no">	
<option value="">Select</option>
	<% for(MasCadre md: cadreList){%>

	<option value="<%=md.getId() %>"><%=md.getCadreName()%>
	</option>
	<%} %>
</select> 

<label>Current District</label> 
<select  name="district" 	tabindex=1  id="district" 	  validate="District,string,no" onChange="populateInst('temp')"/>
			<option value="">Select</option>
						<%
							for(MasDistrict md: distList) {
									if(md.getState().getId() == 32){ // for kerala
						%>
							<option value="<%=md.getId() %>"><%=md.getDistrictName()%></option>
						<%} }%>
			  </select>
<label>Institution Type </label> 
<select id="instType"	name="instType" validate="Institute type ,string,no" tabindex=1 onChange="populateInst('temp')" >
	<option value="0">Select</option>
	 <% 
		for (MasHospitalType  mht : hosTypeList)
		{
	%>
	<option value="<%=mht.getId()%>"><%=mht.getHospitalTypeName()%></option>
	<%
		}
	%> 
	</select>
			  
<label>Current Institute</label> 
<select  name="currInsti" 	tabindex=1  id="currInsti" 	  validate="Current Institute,string,no" />
			<option value="">Select</option>
						<%
							for(MasHospital md: hosList) {
						%>
							<option value="<%=md.getId() %>"><%=md.getHospitalName()%></option>
						<%} %>
			  </select>
<div class="clear"></div>			  
<!--  <input type="button" name="search" value="Search" class="button" 	onClick="submitForm('search','/hms/hrms/training?method=searchTransferApprovalEmployee')"	tabindex=1 />  -->
<input type="button" name="search" value="Search" class="button" 	onClick="submitForm('search','/hms/hrms/training?method=showTransferApplicationApprovalJsp')"	tabindex=1 /> 

</div>
</div>
<div class="clear"></div>
</div>
</form>
 
<div class="clear"></div>
<!-- <form name="itemGrid" method="post"> -->
<h4>Details</h4>
<form name="itemGrid" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="paddingTop15"></div>
<input name="" value="" id="temp" type="hidden" /> 
<!-- <input type="button"	class="button" value="Add Row" onclick="addRow();" align="right" /> 
<input	type="button" class="button" value="Delete Row" onclick="removeRow()"	align="right" /> -->
<div class="clear"></div>
<input type="hidden" size="2" value="" name="noOfRecords"	id="noOfRecords" />
	<!--  <div id="jan" style="display: none;"> -->
<div class="tableForTab" style="min-width:1165px;"   >
<!-- <table width="100%" colspan="0" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0"  > -->
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="itemDetails">
 
		<tr>
			<th width="13%">Rank</th>
			<th width="13%">Employee Name</th>
			 
			<th width="10%"> PEN</th>
			<th width="10%"> Designation</th>
			<th width="10%"> Department</th>
			<!-- <th width="10%"> Grade</th> -->
			<th width="10%"> Cadre</th>
			<th width="10%"> Current District</th>
			<th width="10%"> Current Institute</th>
			
			<th style="min-width: 100px"> Transfer District</th>
			<th style="min-width: 200px"> Institute Type</th>
			<th style="min-width: 250px"> Transfer Institute</th>
			<th width="10%"> Joining Date</th>
			<th width="10%"> Select</th>
			 
		</tr>
		<%int i = 0;
			if(hrTransferApplicationMList.size() >0){
				for(i=0;i<hrTransferApplicationMList.size();i++){

		%>
		<tr>
			<td>
			<input type="text" name="rank<%=i  %>" value="<%=i+1 %>" readonly	tabindex=1  id="rank<%=i  %>"  size="4"/>
			<input type=hidden name="appId<%=i  %>" value="<%=hrTransferApplicationMList.get(i).getId()%>"	tabindex=1  id="appId<%=i  %>"  size="4"/>
			</td>
			<td>
			<input type="text" name="emp<%=i  %>"	value="<%=hrTransferApplicationMList.get(i).getEmployee().getEmployeeName() %>" readonly tabindex=1  id="emp<%=i %>"  size="25"/>
			<input type="hidden" name="employee_id<%=i  %>" value="<%=hrTransferApplicationMList.get(i).getEmployee().getId()%>"	tabindex=1  id="employee_id<%=i  %>"  size="10"/>
			</td>
		    <td>
			<input type="text" name="pen<%=i  %>" readonly value="<%=hrTransferApplicationMList.get(i).getEmployee().getPEN() != null ? hrTransferApplicationMList.get(i).getEmployee().getPEN() :""%>"	tabindex=1  id="pen<%=i %>"  size="8"/>
			</td>
				
			<td>
			<input type="text" name="desig<%=i  %>" readonly value="<%=hrTransferApplicationMList.get(i).getEmployee().getRank().getRankName()%>"	tabindex=1  id="desig<%=i %>"  size="18"/>
			</td>
			
			<td>
			<input type="text" name="depart<%=i  %>" readonly  value="<%=hrTransferApplicationMList.get(i).getEmployee() !=null && hrTransferApplicationMList.get(i).getEmployee().getEmployeeDepartment()!= null && hrTransferApplicationMList.get(i).getEmployee().getEmployeeDepartment().getEmpDeptName()!= null?hrTransferApplicationMList.get(i).getEmployee().getEmployeeDepartment().getEmpDeptName():""%>"	tabindex=1  id="depart<%=i %>"  size="18"/>
			</td>
			<%-- <td>
			<input type="text" name="grade<%=i  %>" readonly value="<%=hrTransferApplicationMList.get(i).getEmployee().getRank().getGrade() != null ?hrTransferApplicationMList.get(i).getEmployee().getRank().getGrade().getGradeName():""%>"	tabindex=1  id="grade<%=i %>"  size="10"/>
			</td> --%>
			<td>
			<input type="text" name="cadre<%=i  %>" readonly value="<%=hrTransferApplicationMList.get(i).getEmployee().getRank().getCadre() != null ?hrTransferApplicationMList.get(i).getEmployee().getRank().getCadre().getCadreName():""%>"	tabindex=1  id="cadre<%=i %>"  size="12"/>
			</td>
			<td>
			<input type="text" name="curr_dist<%=i  %>" readonly  value="<%=hrTransferApplicationMList.get(i).getEmployee().getHospital().getDistrict().getDistrictName()%>"	tabindex=1  id="curr_dist<%=i %>"  size="18"/>
			</td>
			
			<td>
			<input type="text" name="curr_inst<%=i  %>" readonly value="<%=hrTransferApplicationMList.get(i).getEmployee().getHospital().getHospitalName()%>"	tabindex=1  id="curr_inst<%=i %>"  size="18"/>
			</td>
			<td><%=hrTransferApplicationMList.get(i).getTrHospital().getDistrict().getDistrictName()%>
			<input type="hidden" name="transfer_dist<%=i  %>" id="transfer_dist<%=i  %>" value="<%=hrTransferApplicationMList.get(i).getTrHospital().getDistrict().getId() %>" />
			<%-- <select  name="transfer_dist<%=i  %>" 	tabindex=1  id="transfer_dist<%=i  %>" 	  validate="transfer_distin row <%=i+1  %>,int,no" onChange="populateInst(this.value,<%=i%>)"/>
			<option value="">Select</option>
						<%
							for(MasDistrict md: distList) {
								if(md.getState() != null){
									if(md.getState().getId() == 18){ // for kerala
						%>
							<option value="<%=md.getId() %>"><%=md.getDistrictName()%></option>
						<%} }}%>
			  </select> 
			<a href="#" onclick="openPopupWindow('<%=hrTransferApplicationMList.get(i).getId()%>');" >Show Priority</a>
			--%>
			</td>
			<td>
			<%=hrTransferApplicationMList.get(i).getTrHospital().getHospitalType().getHospitalTypeName()%>
			<input type="hidden" name="instType<%=i  %>" id="instType<%=i  %>" value="<%=hrTransferApplicationMList.get(i).getTrHospital().getHospitalType().getId() %>" />
			<%-- <select  name="instType<%=i  %>" 	tabindex=1  id="instType<%=i  %>" 	 validate="Institute Type row <%=i+1  %>,int,no" onChange="populateInst(this.value,<%=i%>)"/>
			<option value="">Select</option>
						<%
							for(MasHospitalType md: hosTypeList) {
						%>
							<option value="<%=md.getId() %>"><%=md.getHospitalTypeName()%></option>
						<%} %>
			  </select> --%>
			<%-- <a href="#" onclick="openPopupWindow('<%=hrTransferApplicationMList.get(i).getId()%>');" >Show Priority</a> --%>
			</td>
			
			<td>
			<%=hrTransferApplicationMList.get(i).getTrHospital().getHospitalName()%>
			<input type="hidden" name="transfer_inst<%=i  %>" id="transfer_inst<%=i  %>" value="<%=hrTransferApplicationMList.get(i).getTrHospital().getId() %>" />
			
			<%-- <select  name="transfer_inst<%=i  %>" 	tabindex=1  id="transfer_inst<%=i %>" 	  validate="transfer_inst in row <%=i+1  %>,int,no" />
			<option value="">Select</option>
						<%
							for(MasHospital md: hosList) {
						%>
							<option value="<%=md.getId() %>"><%=md.getHospitalName()%></option>
						<%} %>
			  </select>
			  <a href="#" onclick="openPopupWindow('<%=hrTransferApplicationMList.get(i).getId()%>');" >Show Priority</a> --%>
			</td>
			
			<td>
			<input type="text" name="joindate<%=i %>" id="joindate<%=i %>" value=""  onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="joindate<%=i %>,string,no" class="date">
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Joining Date ,date,yes"  onclick="javascript:setdate('joindate<%=i %>',document.itemGrid.joindate<%=i %>,true);" />
			</td>
			
			<td>
			<input type="checkBox" name="priority<%=i %>" value="<%=hrTransferApplicationMList.get(i).getId()%>"	tabindex=1  id="priority<%=i  %>"  size="3"/>
			</td>
		 </tr>
		<%}}else{ %>
		No Records Found
		<%} %>

</table>
</div>
<!-- </div> -->
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<label>Remarks</label> 
<input type="text" value="" name="remark" id="remark" maxlength="199" tabindex=1  /> 

<input type="hidden" value="<%=hrTransferApplicationMList.size()%>" name="hiddenValueCharge" id="hiddenValueCharge" /> 

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="testDiv"></div>
<%	if(hrTransferApplicationMList.size()>0){ %>
<input name="button"  type="button"	value="Approve" class="button"	 onClick="submitForm('itemGrid','/hms/hrms/training?method=saveApproveOrRejectTransfer&flag=a','selectBeforeOperation')"  />
<input name="button"  type="button"	value="Reject" class="button"	 onClick="submitForm('itemGrid','/hms/hrms/training?method=saveApproveOrRejectTransfer&flag=r','selectBeforeOperation')"  />
<%}%>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label> <label class="value"><%="admin"%></label>
<label>Changed Date</label> <label class="value"><%=date%></label>
<label>Changed Time</label> <label class="value"><%=time%></label> 
<input type="hidden"	name="<%=CHANGED_BY%>" value="<%="admin"%>" />
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" />
<input type="hidden"	name="CHANGED_DATE" value="<%=date%>" /> 
<input type="hidden"	name="CHANGED_TIME" value="<%=time%>" />
</div>

<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">

function removeRow(){
	var tbl = document.getElementById('itemDetails');
	 var tblRows  = tbl.getElementsByTagName("tr");

 	if(tblRows.length-2==0){
        	alert("Can not delete all rows")
        	return false;
    }
 	var count = 0;
	count = document.getElementById('hiddenValueCharge').value;
	for(counter=0;counter<document.getElementsByName('selectedChrage').length;counter++)
	{
		if (document.getElementsByName('selectedChrage')[counter].checked == true)
		{
		  	tbl.deleteRow(counter+1);

		}
	}
 	
}

function abc1(row,shift){
	alert(row+"  "+shift)
	var empcate= document.getElementById('empCate').value
	submitProtoAjaxWithDivName('itemGrid','/hms/hrms/attendance?method=getSessForShift&shift='+shift+'&row='+row+'&empcate='+empcate,'testDiv'+row);
	//submitProtoAjaxWithDivName('itemGrid','/hms/hrms/attendance?method=getSessForShift','testDiv'+row);
}

function removeAllOptions(selectbox)
{
	var i;
	for(i=selectbox.options.length-1;i>=0;i--)
	{
		selectbox.remove(i);
	}
}


function selectBeforeOperation(){
	  flag = true;
	  var j=0;
	  if(document.<%="itemGrid"%>.priority.checked != undefined)	
			{
				if(document.<%="itemGrid"%>.priority.checked)
				{
					flag = false;					
				}
			}
			  else{
				<%-- for(i=1;i<document.<%="itemGrid"%>.priority.length;i++){
					if(document.<%="itemGrid"%>.priority[i].checked) --%>
					for(i=0;i<document.getElementsByName('priority').length;i++){
						if(document.getElementsByName('priority')[i].checked)
					  flag=false;
				}
			 }
				if(flag){
					alert("Select a record to perform any operation.")
				
				    return false;
				}
				
				if(!flag){
					var flag1=false;
					for(i=0;i<document.getElementsByName('priority').length;i++){			
					j++;
					/* alert(document.getElementsByName('priority').length+"td--"+document.getElementById('transfer_dist'+i).value)
					alert("ti--"+document.getElementById('transfer_inst'+i).value) 
					alert(document.getElementsByName('priority')[i].checked+"j  "+document.getElementById('joindate'+i).value)*/
					if(document.getElementsByName('priority')[i].checked){
					  	if(document.getElementById('transfer_dist'+i).value != "" || document.getElementById('transfer_inst'+i).value != "" || document.getElementById('joindate'+i).value != ""){
					  		flag1=true;
					  	}
				}
					
					
				}
				if(!flag){ 	
					
					alert("Transfer District Or Transfer Institute Or joining Date can not be blank in row "+j);
					return false;
				}
				  
				}
		}
		
		if(flag){
			
			return false;
		}else{
			
			return true;
		}
		
		return true;
	}
	
function chkMan(){

	/* var j=0;
		  flag = true;
		  alert(document.getElementsByName('priority').length)
			for(i=0;i<=document.getElementsByName('priority').length;i++){
				alert("loop")
				j++;
				 alert(document.getElementsByName('priority')[0].checked)
				 	alert("loop1")
				if(document.getElementsByName('priority')[i].checked){
				  	if(document.getElementsByName('transfer_dist'+j).value == "" ||document.getElementsByName('transfer_inst'+j).value == ""){
				  		alert("in row "+j);
				  		
				  	}
			}
			} */
		}
	
function populateInst(id)
{
	var hosType=document.getElementById("instType").value; 
	var dist=document.getElementById("district").value;
	//alert(hosType+" "+dist)
	var sel = document.getElementById("transfer_inst");
	removeAllOptions(sel);
		
	if(hosType!="" && dist==""){
	var size = <%=hosList.size()%>
	 
			<%
			for(MasHospital mid:hosList){%>
				if(<%=mid.getHospitalType().getId()%> == hosType){<%
				if(mid.getStatus().equals("y")){
			%>
				optionRepMan = new Option("<%=mid.getHospitalName()%>" , "<%=mid.getId()%>","true");				
				sel.options.add(optionRepMan);
			<%}
			%>
				}
				<%}%>
				optionRepMan = new Option("Select" , "","true");
				sel.options.add(optionRepMan);
		}
	
	if(dist!="" && hosType ==""){
		var size = <%=hosList.size()%>
	 
				<%
				for(MasHospital mid:hosList){
				if(mid.getDistrict()!=null){
				%>
					if(<%=mid.getDistrict().getId()%> == dist){<%
					if(mid.getStatus().equals("y")){
				%>
					optionRepMan = new Option("<%=mid.getHospitalName()%>" , "<%=mid.getId()%>","true");				
					sel.options.add(optionRepMan);
						
				<%}
				%>
					}
					<%}}%>
					optionRepMan = new Option("Select" , "","true");
					sel.options.add(optionRepMan);
			}
	
	if(dist!="" && hosType !=""){
		var size = <%=hosList.size()%>
	 
				<%
				for(MasHospital mid:hosList){
				if(mid.getDistrict()!=null){%>
					if(<%=mid.getDistrict().getId()%> == dist && <%=mid.getHospitalType().getId()%> == hosType){<%
					if(mid.getStatus().equals("y")){
				%>
					optionRepMan = new Option("<%=mid.getHospitalName()%>" , "<%=mid.getId()%>","true");				
					sel.options.add(optionRepMan);
				<%}
				%>
					}
					<%}}%>
					optionRepMan = new Option("Select" , "","true");
					sel.options.add(optionRepMan);
			}
}
function openPopupWindow(appId)
{ 
var id = 0; 
	 for(var i = 0; i < document.getElementsByName('rb').length; i++){
		  if(document.getElementsByName('rb')[i].checked == true)
          {
			id = document.getElementsByName('rb')[i].value;
		  }		
		}
		var url="/hms/hrms/training?method=viewTransferPriority&appId="+appId+"";
		newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
}
</script>
</form>
