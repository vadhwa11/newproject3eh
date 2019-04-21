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

<%@page import="jkt.hrms.masters.business.HrMasShiftCodes"%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasShift"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/addRow.js"></script>


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
</script>

<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");	

	Map<String,Object> map = null;
	if(request.getAttribute("map")!=null)
	{
		map = (Map)request.getAttribute("map");
	}
	
	
	List<HrMasShift> srchmasShiftList = new ArrayList<HrMasShift>();
	List<MasEmpCategory> masEmpCategoryList =  new ArrayList<MasEmpCategory>();
	if(map!=null && map.get("masEmpCategoryList")!=null)
	{
		masEmpCategoryList = (List)map.get("masEmpCategoryList");
	}
	List<HrMasShiftCodes> masShiftCodeList = new ArrayList<HrMasShiftCodes>(); 
	if(map.get("masShiftCodesList") != null){
		masShiftCodeList = (List)map.get("masShiftCodesList");
	}
	if(map.get("srchmasShiftList") != null){
		srchmasShiftList = (List<HrMasShift>)map.get("srchmasShiftList");
	}
	System.out.println(srchmasShiftList.size());

	String message = ""; 
	if(map.get("message")!=null)
	{
		message = (String)map.get("message");
	}
	
	%>
<h4><span><%=message %></span></h4>
<div class="titleBg">
<h2>Shift Parameter Master</h2>
</div>
<div class="clear"></div>
<form name="itemGrid" method="post">
<div class="Block">

<div id="searcharea">

<div id="searchbar">

<!-- <form name="search" method="post" action="">  -->

  
<label><span>*</span>Employee Category</label> 
<select name="<%=EMPLOYEE_CATEGORY %>" id='searchField' validate="Employee Category,string,yes">	
<option value="">Select</option>
	<% for(MasEmpCategory emp: masEmpCategoryList){%>

	<option value="<%=emp.getId() %>"><%=emp.getEmpCategoryName()%>
	</option>
	<%} %>
</select>

<label><span>*</span>Shift</label> 
<select name="shiftName" id='shiftNameId' validate="Shift,string,yes">	
<option value="">Select</option>
	<% for(HrMasShiftCodes shift: masShiftCodeList){%>

	<option value="<%=shift.getId() %>"><%=shift.getShiftName()%>
	</option>
	<%} %>
</select>

 <input type="button" name="search" value="Search" class="button" 	onClick="submitForm('itemGrid','/hms/hrms/attendance?method=searchShiftParameter')"	tabindex=1 /> 

</div>
</div>
<div class="clear"></div>
</div>
<!-- </form> -->


<div class="clear"></div>
<!--  <form name="itemGrid" method="post">  -->

<h4>Add Session</h4>
<div class="paddingTop15"></div>
<input name="" value="" id="temp" type="hidden" /> 
<input type="button"	class="button" value="Add" onclick="addRow();" align="right" /> 
<input	type="button" class="button" value="Delete" onclick="removeRow()"	align="right" />
<div class="clear"></div>
<input type="hidden" size="2" value="" name="noOfRecords"	id="noOfRecords" />
	

<table width="100%" colspan="0" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0" class="cmntable">


		<tr>
			<th >Session</th>
			<th >From Time</th>
			<th >To Time</th>
			<th>Select</th>
			
		</tr>
	
		<%int i = 1;
		if(srchmasShiftList.size()==0){
		%>
		<tr>
			<td>
			<input type="text" name="session<%=i  %>" value=""	tabindex=1  id="session<%=i  %>"  size="20" maxlength="20"/>
			</td>
			<td>
			<input type="text" name="fromTime<%=i  %>" value=""	tabindex=1  id="fromTime<%=i  %>" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="5"/>
			</td>
			
			<td>
			<input type="text" name="toTime<%=i  %>" value=""	tabindex=1  id="toTime<%=i  %>" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="5" />
			</td>
			<td><input type="radio" value="" name="selectedChrage" class="radioAuto" /></td>
		</tr>
		
<%} else if(srchmasShiftList.size()>0){
	int j=0;
 for(HrMasShift hms :srchmasShiftList ){
j++;
%>
	<tr>
			<td>
			<input type="text" name="session<%=j  %>" value="<%=hms.getSession() %>"	tabindex=1  id="session<%=j  %>"  size="20"/>
			<input type="hidden" name="id<%=j  %>" value="<%=hms.getId() %>"	tabindex=1  id="id<%=j  %>"  size="20"/>
			</td>
			<td>
			<input type="text" name="fromTime<%=j  %>" value="<%=hms.getShiftStartTime() %>"	tabindex=1  id="fromTime<%=j  %>" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="5"/>
			</td>
			
			<td>
			<input type="text" name="toTime<%=j  %>" value="<%=hms.getShiftEndTime() %>"	tabindex=1  id="toTime<%=j  %>" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="5" />
			</td>
			<td><input type="radio" value="" name="selectedChrage" class="radioAuto" /></td>
		</tr>
<%}} %>
</table>
<input type="hidden" value="" name="v" id="v" />
<input type="hidden" value="<%=i%>" name="hiddenValueCharge" id="hiddenValueCharge" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<%	if(srchmasShiftList.size()==0){ %>
<input name="button"  type="button"	value="Submit" class="button"	 onClick="submitForm('itemGrid','/hms/hrms/attendance?method=saveShiftParameter')"  />
<%}else if(srchmasShiftList.size() >0){ %>
<input name="button"  type="button"	value="Update" class="button"	 onClick="submitForm('itemGrid','/hms/hrms/attendance?method=updateShiftParameter')"  />
<%} %>
<input   type="reset"	value="Reset" />


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
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">
function addRow(){
	var tbl = document.getElementById('itemDetails');
	var lastRow = tbl.rows.length;
	//var v=document.getElementById('v').value;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hiddenValueCharge');
	var iteration = parseInt(hdb.value)+1;
	hdb.value = iteration;

	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'text';
	e0.name='session'+iteration;
	e0.id='session'+(iteration);
	//e0.setAttribute('validate','Session,string,no');
	e0.size="20"; 
	e0.setAttribute("MaxLength", "20");
	e0.value="";
	e0.tabIndex="1";
	cell0.appendChild(e0);
	

	var cell1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='fromTime'+iteration;
	e1.id='fromTime'+(iteration);
	//e1.setAttribute('validate','From Time,string,no');
	e1.value='';
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
</script>

