<div class="search"><a href="">Search</a> <script
	type="text/javascript"> vbmenu_register("threadsearch"); </script></div>
<div class="clear"></div>
<!-- thread search menu -->
<div class="searchBlock" id="threadsearch_menu" style="display: none">
<div class="clear"></div>


<form name="search" action="" method="post"><label>HIN: </label>

<input type="text" name="<%= RequestConstants.HIN_NO %>" id="hinNo"
	MAXLENGTH="30" tabindex=1 /> <input type="hidden" name="deptName"
	id="deptName" value="<%=deptName %>" /> <input type="hidden"
	name="date" id="date" value="<%=date %>" /> <label>Patient
First Name : </label> <input type="text"
	name="<%= RequestConstants.P_FIRST_NAME %>" id="patientFName"
	MAXLENGTH="30" tabindex=1 />

<div class="clear"></div>

<label>Patient Middle Name : </label> <input type="text"
	name="<%= RequestConstants.P_MIDDLE_NAME %>" id="patientMName"
	MAXLENGTH="30" tabindex=1 /> <label>Patient Last Name : </label> <input
	type="text" name="<%= RequestConstants.P_LAST_NAME %>"
	id="pateintLName" MAXLENGTH="30" tabindex=1 />


<div class="clear"></div>

<label>Service No. : </label> <input type="text"
	name="<%= RequestConstants.SERVICE_NO %>" id="serviceNo" MAXLENGTH="30"
	tabindex=1 /> <label>Service Type : </label> <select
	name="<%=RequestConstants.SERVICE_TYPE_NAME%>" id="serviceType">
	<option value="">Select</option>
	<%
try{	
if(patientList.size()>0){
Set serviceTypeSet=  new HashSet();
Iterator itr=patientList.iterator();
while(itr.hasNext()){
Visit visitObj= (Visit) itr.next();
String serviceType=visitObj.getHin().getServiceType().getServiceTypeName();
if(visitObj.getVisitStatus().equals("w")){
serviceTypeSet.add(serviceType);
}
}
Iterator iterator=serviceTypeSet.iterator();
while(iterator.hasNext()){
String serviceType=(String)iterator.next();
%>

	<option value="<%=serviceType%>"><%=serviceType%></option>

	<%

}	
}
}catch(Exception e){
e.printStackTrace();	

}
%>
</select>

<div class="clear"></div>
<input type="image" src="images/go.gif"
	onClick="submitForm('search','opd?method=searchWaitingPatientListJsp');"
	class="button" /> 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 </form>
</div>

