<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * employeeDependent.jsp  
 * Purpose of the JSP -  This is for Dependent Employee.
 * @author  Javed
 * Create Date: 6th Mar,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.1
--%>

<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<%@page import="jkt.hms.masters.business.HrMasTransferNotification"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hrms.masters.business.HrMasShiftCodes"%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasGrade"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasShift"%>


<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
	<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>

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
	List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
	List<MasHospital> hosList = new ArrayList<MasHospital>();
	List<MasDistrict> distList = new ArrayList<MasDistrict>();
//	List<HrMasTransferNotification> transferNotificationList = new ArrayList<HrMasTransferNotification>();
	List transferNotificationList = new ArrayList();
	List<MasHospitalType> hosTypelst = new ArrayList<MasHospitalType>();
	
	if(map.get("masDepartmentList") != null){
		masDepartmentList = (List<MasDepartment>)map.get("masDepartmentList");
	}
	
	if(map.get("empList") != null){
		empList = (List<MasEmployee>)map.get("empList");
	}
	if(map.get("hosList") != null){
		hosList = (List<MasHospital>)map.get("hosList");
	}
	if(map.get("distList") != null){
		distList = (List<MasDistrict>)map.get("distList");
	}
	if(map.get("hosTypelst") != null){
		hosTypelst = (List<MasHospitalType>)map.get("hosTypelst");
	}
	 if(map.get("transferNotificationList") != null){
		transferNotificationList = (List<HrMasTransferNotification>)map.get("transferNotificationList");
	} 
	
	if(map.get("transferNotificationList") != null){
		transferNotificationList = (List)map.get("transferNotificationList");
	}
	
	String message = ""; 
	if(map.get("msg")!=null)
	{
		message = (String)map.get("msg");
	}
	
	int hosId= empList.get(0).getId();
	
	%>
<h4><span><%=message %></span></h4>
<div class="titleBg">
<h2>Transfer Application</h2>
</div>
<div class="clear"></div>
<div class="Block">

<div id="searcharea">

<div id="searchbar">

<!-- <form name="search" method="post" action=""> -->
<form name="itemGrid" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
 
<label>Employee Name <span>* </span></label>
<input type="text" id="empName" name="empName" value="<%=empList.get(0).getEmployeeName() %>"   class="medium3" validate="Employee Name,string,yes"  MAXLENGTH="128"/>	
<input type="hidden" id="empid" name="empid" value="<%=empList.get(0).getId() %>" class="medium3"  MAXLENGTH="128"/>

<label > PEN </label>
<input type="text" id="PEN" name="PEN" value="<%=empList.get(0).getPEN() != null ? empList.get(0).getPEN() :""%>"  MAXLENGTH="12" class="medium3" validate="PEN,String,no" />
 
<label > Department </label>
<input type="text" id="department" name="department" value="<%=empList.get(0).getEmployeeDepartment() != null ? empList.get(0).getEmployeeDepartment().getEmpDeptName() :"" %>"  MAXLENGTH="12" class="medium3" validate="Department,String,no" />
<div class="clear"></div>
<label > Designation </label>
<input type="text" id="designation" name="designation" value="<%=empList.get(0).getRank()!=null ? empList.get(0).getRank().getRankName(): ""%>" MAXLENGTH="12" class="medium3" validate="Designation,String,no"  />

<label > Current Institute </label>
<input type="text" id="cur_institute" name="cur_institute"  value="<%=empList.get(0).getHospital()!=null ? empList.get(0).getHospital().getHospitalName(): "" %>" MAXLENGTH="12" class="medium3" validate="Current Institute,String,no" />
<input type="hidden" id="cur_instituteId" name="cur_instituteId" value="<%=empList.get(0).getHospital()!=null ? empList.get(0).getHospital().getId(): "" %>" MAXLENGTH="12" class="medium3" validate="Current Institute,String,no" />

 <label > Within Days </label>
<input type="text" id="withInDays" name="withInDays" value="" MAXLENGTH="4" class="medium3" validate="With in Days,int,no" />

<div class="clear"></div>

 <label>With Notification</label>     
<input type="radio" name="<%=SELECTED_RADIO  %>" value="with" checked=" " class="inputRadiobutton" tabindex=1  onClick="notify(this.value)"/>
			    	
<label>Without Notification</label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="without"  class="inputRadiobutton"  tabindex=1 MAXLENGTH="128" onClick="notify(this.value)"/>

<div id="notification1" style="display: none;">
<label > Notification No </label>
<%if(transferNotificationList.size() >0){ %>
<select  name="notification" 	tabindex=1  id="notification" 	  validate="Notification No,String,no" />
			<option value="">Select</option>
						<%
						 	for (Iterator iterator = transferNotificationList.iterator(); iterator.hasNext();) {
									Object[] object = (Object[]) iterator.next();
						%>
							<option value="<%=object[0] %>"><%=object[1] %></option>
						<%} %>
			  </select>
<%}else{ %>

<input type="text" id="notification" name="notification" value="" MAXLENGTH="12" class="medium3" validate="Notification No,String,no" />
<%} %>
 </div>
 </div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<!-- <form name="itemGrid" method="post"> -->
<h4>Details</h4>
<input name="" value="" id="temp" type="hidden" /> 
<!-- <input type="button"	class="button" value="Add Row" onclick="addRow();" align="right" /> 
<input	type="button" class="button" value="Delete Row" onclick="removeRow()"	align="right" /> -->
<div class="clear"></div>
<input type="hidden" size="2" value="" name="noOfRecords"	id="noOfRecords" />
	<!--  <div id="jan" style="display: none;"> -->
<div class="tableForTab" style="width:100%"   >
<!-- <table width="100%" colspan="0" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0"  > -->
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="itemDetails">
    <tr>
			<th width="13%">Priority</th>
			<th width="13%"><span>*</span>District Name</th>
			<th width="13%"><span>*</span>Institute Type</th>
			<th width="10%"> Institute Name</th>
		 
		</tr>
		<%int i = 1;
 		for(i=1;i<=3;i++){
  		%>
		<tr>
			<td>
			<input type="text" name="priority<%=i  %>" value="Priority <%=i %>"	tabindex=1  id="priority<%=i  %>"  size="20" readonly="readonly"/>
			<input type="hidden" name="employee_id<%=i  %>" value=""	tabindex=1  id="id<%=i  %>"  size="20"/>
			</td>
			<td>
			<select  name="district<%=i  %>" 	tabindex=1  id="district<%=i  %>" 	  validate="District,string,yes"  onChange="populateInstitute(this.value,<%=i%>)" ><%--onChange="populateInstitute(this.value,<%=i%>)" --%>
			<option value="0">Select</option>
						<%
							for(MasDistrict md: distList) {
								if(md.getState().getId() == 32){
						%>
							<option value="<%=md.getId() %>"><%=md.getDistrictName()%></option>
						<%}} %>
			  </select>
			</td>
  			<td>
				<select name="instiType<%=i  %>" id="instiType<%=i%>"  validate="Institute Type,string,yes"   onChange="populateInst(this.value,<%=i%>)" >	
					<option value="">Select</option>
						<%
							for(MasHospitalType mht: hosTypelst) {
						%>
							<option value="<%=mht.getId() %>"><%=mht.getHospitalTypeName()%></option>
						<%} %>
			   </select>
			</td>
 			<td>
				<select name="instiName<%=i  %>" id="instiName<%=i  %>"  validate="shift,string,no" >	
					<option value="">Select</option>
						<%
							for(MasHospital mh: hosList) {
						%>
							<option value="<%=mh.getId() %>"><%=mh.getHospitalName()%></option>
						<%} %>
			   </select>
			</td>
 		</tr>
		<%} %>
 </table>
</div>
<!-- </div> -->
 
<input type="hidden" value="<%=i%>" name="hiddenValueCharge" id="hiddenValueCharge" /> 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="testDiv"></div>
<%	if(empList.size()==0){ %>
<input name="button"  type="button"	value="Submit" class="button"	 onClick="submitForm('itemGrid','/hms/hrms/training?method=saveTransferApplication')"  />
<%}else if(empList.size() >0){ %>
<input name="button"  type="button"	value="Submit" class="button"	 onClick="submitForm('itemGrid','/hms/hrms/training?method=saveTransferApplication')"  />
<%} %>
<input name="button"  type="button"	value="Reset" class="button"	onclick=""; />
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
function addRow(){
	var tbl = document.getElementById('itemDetails');
	var lastRow = tbl.rows.length;

	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hiddenValueCharge');
	var iteration = parseInt(hdb.value)+1;
	hdb.value = iteration;

	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'text';
	e0.name='session'+(iteration);
	e0.id='session'+(iteration);
	//e0.setAttribute('validate','Session,string,no');
	e0.size="20";
	e0.value="Sess2";
	e0.tabIndex="1";
	cell0.appendChild(e0);
	

	var cell1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='fromTime'+iteration;
	e1.id='fromTime'+(iteration);
	//e1.setAttribute('validate','From Time,string,no');
	e1.value='12';
	e1.size="20";
	e1.tabIndex="1";
	e1.onkeyup = function(){
		mask(this.value,this,'2,5',':');
			  }
	e1.onblur = function(){
				  IsValidTime(this.value,this.id);
		}
	cell1.appendChild(e1);
  	var cell2 = row.insertCell(2);
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.name='toTime'+(iteration);
	e2.id='toTime'+(iteration);
	//e2.setAttribute('validate','To Time,string,no');
	e2.value="";
	e2.size="20";
	e2.tabIndex="1";
	e2.onkeyup = function(){
		mask(this.value,this,'2,5',':');
			  }
	e2.onblur = function(){
				  IsValidTime(this.value,this.id);
		}
	cell2.appendChild(e2);
 	var cell3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.type = 'radio';
	e3.name='selectedChrage';
	e3.className='radioAuto';
	e3.value=(iteration);
	cell3.appendChild(e3);
 }
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

function populateInstitute(val,row){
	
	var sel = document.getElementById('instiName'+row);
	removeAllOptions(sel);
	if(val !=""){ 
			<% 
			for(MasHospital mid:hosList){%>
			<%if(mid.getDistrict()!=null){%>
 				if('<%=mid.getDistrict().getId()%>' == val){<%
					if(mid.getId() != hosId){
				if(mid.getStatus().equalsIgnoreCase("y")){
 			%>
 				optionRepMan = new Option("<%=mid.getHospitalName()%>" , "<%=mid.getId()%>","true");				
				sel.options.add(optionRepMan);
					
			<%}}
			%>
				}
 				<%}%>
				
				<%}%>
				optionRepMan = new Option("select" , "0","true");
				sel.options.add(optionRepMan);
 		 } 
 }
 
function populateInst(id,row)
{
	var hosType=document.getElementById("instiType"+row).value; 
	var dist=document.getElementById("district"+row).value;
	//alert(hosType+" "+dist)
	var sel = document.getElementById('instiName'+row);
	removeAllOptions(sel);
		
	if(hosType!="0" && dist==0){
	var size = <%=hosList.size()%>
	optionRepMan = new Option("Select" , "0","true");
	sel.options.add(optionRepMan);
			 
		<%
			for(MasHospital mid:hosList){%>
 				if(<%=mid.getHospitalType().getId()%> == hosType){<%
				if(mid.getStatus().equalsIgnoreCase("y")){
			%>
				optionRepMan = new Option("<%=mid.getHospitalName()%>" , "<%=mid.getId()%>","true");				
				sel.options.add(optionRepMan);
					
			<%}
			%>
				}
				<%}%>
 		}
	
	if(dist!="0" && hosType =="0"){
		var size = <%=hosList.size()%>
		optionRepMan = new Option("Select" , "0","true");
		sel.options.add(optionRepMan);
  		 <%
 				for(MasHospital mid:hosList){%>
 				<%if(mid.getDistrict()!=null){%>
 					if(<%=mid.getDistrict().getId()%> == dist){<%
					if(mid.getStatus().equalsIgnoreCase("y")){
				%>
					optionRepMan = new Option("<%=mid.getHospitalName()%>" , "<%=mid.getId()%>","true");				
					sel.options.add(optionRepMan);
						
				<%}
				%>
					}
 					<%}%>
					<%}%>
 			}
	
	if(dist!="0" && hosType !="0"){
		var size = <%=hosList.size()%>
		optionRepMan = new Option("Select" , "0","true");
		sel.options.add(optionRepMan);
	 <%
	 	for(MasHospital mid:hosList){%>
	 	<%if(mid.getDistrict()!=null && mid.getHospitalType()!=null){%>
		 	if(<%=mid.getDistrict().getId()%> == dist && <%=mid.getHospitalType().getId()%> == hosType){<%
					if(mid.getStatus().equalsIgnoreCase("y")){
				%>
					optionRepMan = new Option("<%=mid.getHospitalName()%>" , "<%=mid.getId()%>","true");				
					sel.options.add(optionRepMan);
						
				<%}
				%>
					}
					<%}%>
					<%}%>
			}
 }
 
function notify( val){
	var b = <%=transferNotificationList.size()%>
	var bint = parseInt(b);
	if(val =="with"){
		if(b>0){
		document.getElementById('notification1').style.display = "block";
		}else{
			alert("Notification not available Please select without Notification")
			document.getElementById('notification1').style.display = "none";
		}
	}else if(val =="without"){
		document.getElementById('notification1').style.display = "none";
  	}
 }
</script>
 </form>
