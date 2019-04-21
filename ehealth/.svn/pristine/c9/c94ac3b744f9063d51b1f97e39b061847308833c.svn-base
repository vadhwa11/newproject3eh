<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.BloodSampleCollection"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.BloodDonationEntryHeader"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Donor Search</title>

<div class="titleBg">
<h2>Donor Search</h2>
</div>

</head>
<body>
<%
 Map<String,Object> map = new HashMap<String,Object>();
	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
	List<BloodDonationEntryHeader> donorList = new ArrayList<BloodDonationEntryHeader>();

	if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
	}
	if(map.get("sexList") != null){
		sexList= (ArrayList) map.get("sexList");
	}
	

%>
<form action="" name="donorSearch" method="post">
<div class="Block">

<label>Donor Reg. No.</label> 
	<input type="text"  name="<%=REGISTERATION_NUMBER%>" value="" validate="registrationNumber,string,no" maxlength="15"
	tabindex="1" /> 
	
<label>UHID</label> 
	<input type="text" id="uidNo"  name="<%=UID%>" value="" validate="UID,string,no" maxlength="23"
	tabindex="1" /> 
	
	<label>Gender</label>
	<%-- <input type="text" id="uidNo"  name="<%=UID%>" value="" validate="UID,string,no" maxlength="3"
	tabindex="1" /> --%> 
	 <select  onchange="" id="sexId" 
	name="<%=GENDER%>" validate="sex,string,no">
			<option value="0">Select</option> 
			<%
			
				         		if(sexList != null){ 	
				         			for (Iterator iter = sexList.iterator(); iter.hasNext();) {
				         				MasAdministrativeSex administrativeSex = (MasAdministrativeSex) iter.next();
				         %>
			        
	<option value="<%=administrativeSex.getId() %>"><%=administrativeSex.getAdministrativeSexName() %></option>
	<%		
				        			}
				        		 } 
				        %>
	
			</select>
			 
<div class="clear"></div>

<label>Name</label> 
	<input type="text"  name="<%=DONOR_NAME %>" value="" validate="donorName,string,no" maxlength="20"
	tabindex="1" />
	 
<label>Mobile Number</label> 
	<input type="text"  name="mobileNumber" value="" validate="mobileNumber,string,no" maxlength="13"
	tabindex="1" /> 
	
	<label>Year Of Registration</label> 
	<input type="text"  name="regyear" value="" validate="regyear,string,no" maxlength="10"
	tabindex="1" />
	
	
	<div class="clear"></div>
	<label>Blood Bank Name</label> 
	<input type="text"  name="bloodBankName" value="" validate="bloodBankName,string,no" maxlength="20"
	tabindex="1" /> 
	
	<label class="heightAuto">Blood Bank Registration Number</label> 
	<input type="text"  name="bloodBankNumber" value="" validate="bloodBankNumber,string,no" maxlength="20"
	tabindex="1" /> 
	
	<div class="clear" style="margin:5px 0px"></div>
	
	
<input type="button" class="button" value="Search"
	onclick="submitForm('donorSearch','/hms/hms/bloodBank?method=searchDonor');"
	align="right" /> 
	
<input type="button" class="buttonBig" name="newRegister" id="reset" value="New Registration" onclick="submitForm('donorSearch','/hms/hms/bloodBank?method=showBloodDonationEntryJsp')" accesskey="r" />	

<div class="clear" style="margin:5px 0px"></div>
	<% if(null!=donorList) 
	{  
	int rowNumber=0;
	%>
	<%
	if(map.get("donorList") != null){
		donorList= (List<BloodDonationEntryHeader>)map.get("donorList");
	
	
	if(null !=donorList && !donorList.isEmpty()){
		
	%>
	 <table id=" " width="100%" border="0" cellspacing="0" cellpadding="0">
 <thead>
		<tr>
			
			<th>Donor Registration Number</th>
			<th>UHID</th>
			<th>Donor Name</th>
			<th>Gender</th>
			<th>Date Of Birth</th>
			<th>Status</th>
			<th>Deffered Till Date</th>
		</tr>
		
		
	
	<% 	String age="";
	
	String donorcurrentstatus="";
		String birthDay="";
	for(BloodDonationEntryHeader bloodDonationEntryHeader : donorList){
		int row=rowNumber++;
		if(null !=bloodDonationEntryHeader.getSex()){
			age=bloodDonationEntryHeader.getSex().getAdministrativeSexName();
		}
		if(null !=bloodDonationEntryHeader.getDateOfBirth()){
			birthDay=HMSUtil.convertDateToStringTypeDateOnly(bloodDonationEntryHeader.getDateOfBirth());
		}
		
		 donorcurrentstatus="";
		if(null !=bloodDonationEntryHeader.getDonorStatus() && !bloodDonationEntryHeader.getDonorStatus().equals("") && !bloodDonationEntryHeader.getDonorStatus().equals(null)){
			donorcurrentstatus=bloodDonationEntryHeader.getDonorStatus();
			if(bloodDonationEntryHeader.getDonorStatus().equalsIgnoreCase("Temporar")){
				donorcurrentstatus="Temporarily Deffered";
			}
			if(bloodDonationEntryHeader.getDonorStatus().equalsIgnoreCase("Permanen")){
				donorcurrentstatus="Permanently Deffered";
			}
		}
		String defferedDate="";
		if(null !=bloodDonationEntryHeader.getDefferedTillDate() && !bloodDonationEntryHeader.getDefferedTillDate().equals("")){
			
			defferedDate=HMSUtil.convertDateToStringWithoutTime(bloodDonationEntryHeader.getDefferedTillDate());
		}
		
		
		%>
		
		<tr id="r<%=row %>" onclick="if(checkDefferedCondition('<%=bloodDonationEntryHeader.getDonationNo() %>','<%=donorcurrentstatus%>','<%=defferedDate%>')){submitFormForButton('donorSearch','/hms/hms/bloodBank?method=showBloodDonationEntryJsp&donoruhid=<%=bloodDonationEntryHeader.getDonationNo() %>')};HighLightTR(this) " style="cursor: pointer;">
	
		<td ><%=bloodDonationEntryHeader.getDonationNo() %></td>
		<td ><%=bloodDonationEntryHeader.getUhidNo() != null ? bloodDonationEntryHeader.getUhidNo() : "" %></td>
		<td ><%=bloodDonationEntryHeader.getDonerName()%></td>
		<td ><%=age%></td>
		<td ><%=birthDay%></td>
		
		<td ><%=donorcurrentstatus%></td>
		
	 <td ><%= defferedDate %></td> 
		
		</tr>
		<%}
	}
	else{%>
			<font size="4" weight="bold" color="red">No Record Found </font>
	<% }}
		%>
		
		
	</thead>
	</table>
	
		
	<% } 
	else{
%>
 <H4>No Data Found</H4>
	<% }
	%>
	<c:if test="${requestScope.map.currentPage >= 2}">
       <a href="/hms/hms/bloodBank?method=searchDonor&page=${requestScope.map.currentPage - 1}">Previous</a>
        
    </c:if>
   
            <c:forEach begin="1" end="${requestScope.map.noOfPages}" var="i">
                <c:choose>
                    <c:when test="${requestScope.map.currentPage eq i}">
                        ${i}
                    </c:when>
                    <c:otherwise>
                      <a href="/hms/hms/bloodBank?method=searchDonor&page=${i}">${i}</a>
                     <%--    <td onclick="submitFormForButton('donorSearch',
        '/hms/hms/bloodBank?method=showDonorAssesstmentMasterJsp&page=${i}')"${i}</td> --%>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        
    
    
    <c:if test="${requestScope.map.currentPage lt requestScope.map.noOfPages}">
     <a href="/hms/hms/bloodBank?method=searchDonor&page=${requestScope.map.currentPage + 1}">Next</a>
        <%--  <td onclick="submitFormForButton('donorSearch',
        '/hms/hms/bloodBank?method=showDonorAssesstmentMasterJsp&page=${requestScope.map.currentPage + 1}')"Next</td> --%>
    </c:if>
	<div class="clear" style="margin:5px 0px"></div>
	
</div>
<script type="text/javascript">
function checkDefferedCondition(donorSequence,donorStatus,Deffereddate){
	
	if(donorStatus !=""){
		if(donorStatus == 'Temporarily Deffered'){
			
			
			if(Deffereddate !=""){
		    var res = Deffereddate.split("/");
		   
		    var deferDate=res[2]+"/"+res[1]+"/"+res[0];
			var q = new Date();
			var m = q.getMonth();
			var d = q.getDate();
			var y = q.getFullYear();
			
			var mm="";
			if(m.toString().length == 1){
				m=m+1;
				mm="0"+m;
			}
			else{
				mm=m+1;
			}
			 var temp=y+"/"+mm+"/"+d;
			var date = new Date(temp);
			
			mydate=new Date(deferDate);
		

			if(date<mydate)
			{
			    alert("Donor is Temporarily deffered till "+Deffereddate);
			    return false;
			}
			else if(date>mydate)
			{
				alert("Donor is Temporarily deffered till "+Deffereddate);
				return true;
			}
			else
			{
				alert("Donor is Temporarily deffered till "+Deffereddate);
				return false;
			}
			
			}
			
			
		}
	 else if(donorStatus == 'Permanently Deffered'){
			alert("Donor is Permanently Deffered ")
			return false
		}
		else{
			return true;
		}
		
	}
	else{
		return true
	}
}

</script>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</body>
</html>