<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * billPackageMaster.jsp  
 * Purpose of the JSP -  This is for Package master 
 * @author  Ritu
 * Create Date: 16 July,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>

<%@page import="jkt.hms.masters.business.MasScheme"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>

<script>
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
<%
	Map map = new HashMap();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
	List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
	List<MasScheme> schemeList = new ArrayList<MasScheme>();
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	if(map.get("departmentList") != null){
		departmentList = (List<MasDepartment>)map.get("departmentList");
	}
	
	if(map.get("sexList") != null){
		sexList = (List<MasAdministrativeSex>)map.get("sexList");
	}
	
	if(map.get("accountList") != null){
		accountList = (List<FaMasAccount>)map.get("accountList");
	}
	
	if(map.get("schemeList") != null){
		schemeList= (List<MasScheme>)map.get("schemeList");
	}
    System.out.println("departmentList"+departmentList.size());
%>
<form name="packageMaster" method="post" action="">
<div class="titleBg">
<h2>Package Master</h2>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block"><label><span>*</span> Package Code</label> <input
	id="codeId" type="text" name="<%=PACKAGE_CODE %>" value=""
	validate="Package Code,string,yes" MAXLENGTH="8" tabindex=1 />
	
	 <label><span>*</span>Package Name</label> <input type="text" name="<%= PACKAGE_DESCRIPTION %>"
	value="" MAXLENGTH="30" tabindex=1 validate="Package Name,string,yes" /> 
	<!--  <label><span>*</span>ICD Name</label> <input type="text" name="icdname"
	value="" MAXLENGTH="30" tabindex=1 validate="ICD Name,string,yes" />  -->
	 <label><span>*</span>Rate</label> <input type="text" name="rate"
	value="" MAXLENGTH="30" tabindex=1 validate="rate,int,yes"/> 
	 <label><span>*</span>Days</label> <input type="text" name="days"
	value="" MAXLENGTH="30" tabindex=1 validate="Days,int,yes"/>
	 
	 <!-- Scheme added by Amit Das on 07-03-2016 -->
	 <label>Scheme</label>
	<div id="schemeDiv">
 	<select id="schemeId" name="schemeId"	validate="Scheme,int,no" onchange="onChangeScheme();">
		<option value="0">Select</option>
	 <%
		for(MasScheme masScheme : schemeList){
	 %>
		<option value="<%=masScheme.getId() %>"><%=masScheme.getSchemeName()%></option>
	<%} %> 
	</select>
	</div>
	 
	<%-- <label><span>*</span>
Department</label> <select name="<%=DEPARTMENT_ID %>">
	<option value="0">Select</option>
	<%
		for(MasDepartment department : departmentList){
	%>
	<option value="<%=department.getId() %>"><%= department.getDepartmentName()%></option>
	<%} %>
</select> --%>

<!-- <div class="clear"></div> -->
<%-- <label><span>*</span> Effective From Date</label> <input type="text"
	name="<%=EFFECTIVE_DATE_FROM %>" value="" class="date"
	readonly="readonly" validate="Effective From Date,date,yes"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onclick="setdate('',document.packageMaster.<%=EFFECTIVE_DATE_FROM%>,event)" />


<label>Effective To Date</label> <input type="text"
	name="<%=EFFECTIVE_DATE_TO %>" value="" class="date"
	readonly="readonly" validate="Effective To Date,date,yes" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('',document.packageMaster.<%=EFFECTIVE_DATE_TO%>,event)" />
 --%>


<%-- <label>Account Code</label> <select id="accountId"
	name="<%= ACCOUNT_ID%>" validate="Account Code,string,no">
	<option value="0">Select</option>
	<%
for(FaMasAccount masAccount :accountList) {
	
%>
	<option value="<%=masAccount.getId()%>"><%=masAccount.getAccDesc()%></option>
	<%}%>

</select>
<div class="clear"></div>

<label>Sex</label> <select name="<%=SEX_ID %>">
	<option value="0">Select</option>
	<%
	for(MasAdministrativeSex sex : sexList){
%>
	<option value="<%=sex.getId() %>"><%=sex.getAdministrativeSexName() %></option>

	<%} %>
</select> <label>From Age</label> <input type="text" name="<%=FROM_AGE %>"
	value="" /> <label>To Age</label> <input type="text"
	name="<%=TO_AGE %>" value="" />

<div class="clear"></div>

<label>Additional Medicine Amount</label> <input type="text"
	name="<%=ADDITIONAL_MEDICINE_AMOUNT %>" value="" /> --%> <!-- 
<label>Frozen:</label>
<input type="checkbox" name="" class="radioCheck" value=""/> -->

<div class="clear"></div>
</div>

<div class="clear"></div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" name="add" value="Add" class="button"
	onClick="submitForm('packageMaster','packageBilling?method=savePackageDetails');"
	accesskey="a" tabindex=1 /> <input type="reset" name="Reset"
	value="Reset" class="buttonHighlight" accesskey="r" /> <input
	type="button" name="back" value="Back" class="button"
	onClick="submitFormCancel('packageMaster','packageBilling?method=showBillingPackageListJsp')" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
