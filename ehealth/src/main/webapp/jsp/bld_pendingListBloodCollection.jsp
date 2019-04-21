<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.BloodSampleCollection"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
	   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pending List For Blood Collection</title>
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
</head>
<body>
<%Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate"); %>
<form name="pendingBloodCollection" method="post">
<div class="titleBg">
<h2>Pending List For Blood Collection</h2>
</div>
<div class="Block">
<label>Donor Registration Number</label> 
	<input type="text"  name="registerNumber" value=""  maxlength="10"
	tabindex="1" validate="registerNumber,metachar,no"/> 
	<label>Identification Card</label>
	<select name="IdCard" onchange="" validate="IdCard,metachar,no">
	<option value="">Select</option>
	<c:if test="${not empty requestScope.map.mapIdCard}">
	<c:forEach var="mapIdCard" items="${requestScope.map.mapIdCard }">
	
    <option value="${mapIdCard.id }">${mapIdCard.idCardCode}</option>
			
	</c:forEach>			
</c:if>	
</select>
<label>Id Card Number</label> 
	<input type="text"  name="IdCardNumber" value="" validate="IdCardNumber,metachar,no" maxlength="20"
	tabindex="1" /> 	
	
<div class="clear"></div>
<label>Donor Name</label> 
	<input type="text"  name="donorName" value="" validate="donorName,metachar,no" maxlength="20"
	tabindex="1" />
	<label>Gender</label>
	<select name="gender" onchange="" validate="gender,metachar,no">
			<option value="">Select</option>
	<c:if test="${not empty requestScope.map.masGender}">
	<c:forEach var="masGender" items="${requestScope.map.masGender }">

				<option value="${masGender.id }">${masGender.administrativeSexName }</option>
			
</c:forEach>
</c:if>	
</select>			 
<label>Date Of Birth </label> 

<input type="text" class="date"
	id="dob" name="dob" value=""
	validate="dob,date,no" MAXLENGTH="10" tabindex="1" />
	 <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.pendingBloodCollection.dob,event)" />
	
	<div class="clear"></div>
	<label>Mobile Number</label> 
	<input type="text"  name="mobileNumber" value="" validate="mobileNumber,metachar,no" maxlength="13"
	tabindex="1" />
<div class="clear"></div>	
<input type="button" class="button" value="Search"
	onclick="submitForm('pendingBloodCollection','bloodBank?method=showPendingListBloodCollection')"
	align="right" /> 
	<div class="clear"></div>	
	
	<c:if test="${not empty requestScope.map.donorPhyList}">	
	
	 <table id=" " width="100%" border="0" cellspacing="0" cellpadding="0">
      <thead>
		<tr>			
			<th>Donor Registration Number</th>
			<th>ID Card Number</th>
			<th>Donor Name</th>
			<th>Gender</th>
			<th>Date Of Birth</th>
			<th>Mobile Number</th>
		</tr>		
		<c:forEach var="donationHeader" items="${requestScope.map.donorPhyList}">
		
		 <input type="hidden"  name="donorRegNo${donationHeader[7]}" value="${donationHeader[3]}" validate="donorRegNo,metacahr,no"/>
		 <input type="hidden"  name="idCardNo${donationHeader[7]}" value="${donationHeader[5]}" validate="idCardNo,metacahr,no"/>
		  <input type="hidden"  name="donorNam${donationHeader[7]}" value="${donationHeader[0]}" validate="donorNam,metacahr,no"/>
		   <input type="hidden"  name="donorGender${donationHeader[7]}" value="${donationHeader[1]}" validate="donorGender,metacahr,no"/>
		     <input type="hidden"  name="donorDOB${donationHeader[7]}" value="${donationHeader[4]}" validate="donorDOB,metacahr,no"/>
		      <input type="hidden"  name="donorMob${donationHeader[7]}" value="${donationHeader[2]}" validate="donorMob,metacahr,no"/>
		      <input type="hidden"  name="donorSequenceId${donationHeader[7]}" value="${donationHeader[7]}" validate="donorSequenceId,metacahr,no"/>
		       <input type="hidden"  name="idcardTypeCode${donationHeader[7]}" value="${donationHeader[6]}" validate="idcardTypeCode,metacahr,no"/>
			<input type="hidden"  name="pulse${donationHeader[7]}" value="${donationHeader[8]}" validate="pulse,metacahr,no"/>
	  <input type="hidden"  name="bp${donationHeader[7]}" value="${donationHeader[9]}" validate="bp,metacahr,no"/>
	   <input type="hidden"  name="uhidNo${donationHeader[7]}" value="${donationHeader[10]}" validate="uhidNo,metacahr,no"/>
	    <input type="hidden"  name="dpDiastolic${donationHeader[7]}" value="${donationHeader[11]}" validate="dpDiastolic,metacahr,no"/>
	    
	     <input type="hidden"  name="storeitemId${donationHeader[7]}" value="${donationHeader[12]}" validate="item,string,no"/>
	       <input type="hidden"  name="expieyDate${donationHeader[7]}" value="${donationHeader[13]}" validate="dpDiastolic,string,no"/>
	     
	      
		
		<tr onclick="submitForm('pendingBloodCollection','/hms/hms/bloodBank?method=showBloodCollectionJsp&sequence=${donationHeader[7]}');HighLightTR(this)" style="cursor: pointer;">
		<td>${donationHeader[3]}</td>
		<td>${donationHeader[5]}</td>
		<td>${donationHeader[0]}</td>
		<td>${donationHeader[1]}</td>
		 <td>${donationHeader[4]}</td> 
		<td>${donationHeader[2]}</td>
		
		</tr>
		</c:forEach>
	</thead>
	</table>
	</c:if>
	<c:if test="${empty requestScope.map.donorPhyList}">
	<h4>No Data Founds</h4>
	</c:if>	
	<div class="clear"></div>
	<%--For displaying Previous link except for the 1st page --%>
    <c:if test="${requestScope.map.currentPage gt 0}">
        <td><a href="/hms/hms/bloodBank?method=showPendingListBloodCollection&page=${requestScope.map.currentPage - 1}">Previous</a></td>
        
    </c:if>
	<div class="clear"></div>
	<table border="0" cellpadding="2" cellspacing="1">
        <tr>
            <c:forEach begin="1" end="${requestScope.map.noOfPages}" var="i">
                <c:choose>
                    <c:when test="${requestScope.map.currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                      <td><a href="/hms/hms/bloodBank?method=showPendingListBloodCollection&page=${i}">${i}</a></td> 
                     <%--    <td onclick="submitFormForButton('donorSearch',
        '/hms/hms/bloodBank?method=showDonorAssesstmentMasterJsp&page=${i}')"${i}</td> --%>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>
     
    <%--For displaying Next link --%>
    <c:if test="${requestScope.map.currentPage lt requestScope.map.noOfPages}">
     <td><a href="/hms/hms/bloodBank?method=showPendingListBloodCollection&page=${requestScope.map.currentPage + 1}">Next</a></td>
        <%--  <td onclick="submitFormForButton('donorSearch',
        '/hms/hms/bloodBank?method=showDonorAssesstmentMasterJsp&page=${requestScope.map.currentPage + 1}')"Next</td> --%>
    </c:if>
	<div class="clear"></div>
		
</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</body>
</html>