
<%@page import="jkt.hms.masters.business.OpdSpecialityTemplateDetails"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css">





<%
				Map<String, Object> map = new HashMap<String, Object>();
				if(request.getAttribute("map")!=null)
				{
					map=(Map<String, Object>)request.getAttribute("map");
				}
				List<OpdSpecialityTemplateDetails> opdSpecialityTemplateDetailsList = new ArrayList<OpdSpecialityTemplateDetails>();
				
				if(map.get("opdSpecialityTemplateDetailsList")!= null){
					opdSpecialityTemplateDetailsList = (List)map.get("opdSpecialityTemplateDetailsList");
				}
				System.out.println("opdSpecialityTemplateDetailsList...."+opdSpecialityTemplateDetailsList.size());
				if(opdSpecialityTemplateDetailsList.size()>0){
					String hinNo="";
					String fname="";
					String mname="";
					Date dob=null;
					Date visitDate=null;
					String gender="";
					String age="";
					String address="";
					String temp="";
					String hospitalName = "";
					for(OpdSpecialityTemplateDetails opdSpecialityTemplateDetails :opdSpecialityTemplateDetailsList){

						hinNo = opdSpecialityTemplateDetails.getVisit().getHin().getHinNo();
						fname=	opdSpecialityTemplateDetails.getVisit().getHin().getPFirstName();
						mname=  opdSpecialityTemplateDetails.getVisit().getHin().getPMiddleName()!=null?opdSpecialityTemplateDetails.getVisit().getHin().getPMiddleName():"";
						dob=opdSpecialityTemplateDetails.getVisit().getHin().getDateOfBirth();
						visitDate=opdSpecialityTemplateDetails.getVisit().getVisitDate();
						gender=	opdSpecialityTemplateDetails.getVisit().getHin().getSex().getAdministrativeSexName();
						age=opdSpecialityTemplateDetails.getVisit().getHin().getAge();
						temp=opdSpecialityTemplateDetails.getTemplateName();
						address=opdSpecialityTemplateDetails.getVisit().getHin().getPatientAddress()!=null?opdSpecialityTemplateDetails.getVisit().getHin().getPatientAddress():"";
						hospitalName = opdSpecialityTemplateDetails.getVisit().getHospital().getHospitalName();
					}
					

%>

<form name="tenderForm" action="" method="post" target="_blank">
<center><h2 class="h2Text"><%=hospitalName%></h2></center>
<center><h4 class="h2Text" style="font-size:20px !important;"><%=temp%></h4></center>
<br/>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="cmntable">
  <tbody>
    <tr>
      <td><label class="fontBold">UHID : </label></td>
      <td><label><%=hinNo%> </label></td>
      <td><label class="fontBold">Patient Name :</label></td>
      <td><label><%=fname %><%=mname %> </label></td>
     </tr> 
    <tr>  
      <td><label class="fontBold">DOB :</label></td>
      <td><label><%=HMSUtil.changeDateToddMMyyyy(dob)%> </label></td>
      <td><label class="fontBold">Visit Date : </label></td>
      <td><label><%=HMSUtil.changeDateToddMMyyyy(visitDate)%> </label></td>
      </tr>
       <tr>
      <td><label class="fontBold">Sex :</label></td>
      <td><label><%=gender%> </label></td>
      <td><label class="fontBold">Age :</label></td>
      <td><label><%=age%> </label></td>
    </tr>     
    <tr>
      <td><label class="fontBold">Address :</label></td>
      <td colspan="5"><label><%=address %> </label></td>
      
    </tr> 

  </tbody>
</table>

<hr/>


<div class="clear"></div>

<%
String parameterType = "";
String tableHeader = "";
String tableData = "";
int i=0;

String prevDisplayType = "";
for(OpdSpecialityTemplateDetails val :opdSpecialityTemplateDetailsList){
String displayType = "";
	if(!val.getParameterType().equals("")){
		parameterType = val.getParameterType();
	}
	if(parameterType.equalsIgnoreCase("Group")){
		displayType = "h4";
	}
	if(parameterType.equalsIgnoreCase("Parameter")){
		displayType = "label";
	}
	i=0;
	System.out.println("prevDisplayType--"+prevDisplayType);
	if(prevDisplayType.equalsIgnoreCase("TableData") &&  !parameterType.equalsIgnoreCase("TableData")){
%>		
</table>
	<%}
	
	if(parameterType.equalsIgnoreCase("Group") || parameterType.equalsIgnoreCase("Parameter")){
		 if(i%2==0){ %>
			 <div class="clear"></div>
				<%} 
		
	
%>

<%if(val.getColoumn1()!=null && !val.getColoumn1().equals("")){ %>

<<%=displayType %>><%=val.getColoumn1() %></<%=displayType %>>
<%}else{%>

<%} %>
<%if(val.getColoumn2()!=null && !val.getColoumn2().equals("")){ %>

<<%=displayType %> class="value"><%=val.getColoumn2() %></<%=displayType %>>
<%}else{%>

<%} %>

<%if(val.getColoumn3()!=null && !val.getColoumn3().equals("")){ %>

<<%=displayType %>><%=val.getColoumn3() %></<%=displayType %>>
<%}else{%>

<%} %>

<%if(val.getColoumn4()!=null && !val.getColoumn4().equals("")){ %>

<<%=displayType %> class="value"><%=val.getColoumn4() %></<%=displayType %>>
<%}else{%>

<%} %>

<%if(val.getColoumn5()!=null && !val.getColoumn5().equals("")){ %>

<<%=displayType %>><%=val.getColoumn5() %></<%=displayType %>>
<%}else{%>

<%} %>


<%if(val.getColoumn6()!=null && !val.getColoumn6().equals("")){ %>

<<%=displayType %> class="value"><%=val.getColoumn6() %></<%=displayType %>>
<%}else{%>

<%} %>


<%if(val.getColoumn7()!=null && !val.getColoumn7().equals("")){ %>

<<%=displayType %>><%=val.getColoumn7() %></<%=displayType %>>
<%}else{%>

<%} %>


<%if(val.getColoumn8()!=null && !val.getColoumn8().equals("")){ %>

<<%=displayType %> class="value"><%=val.getColoumn8() %></<%=displayType %>>
<%}else{%>

<%} %>


<%if(val.getColoumn9()!=null && !val.getColoumn9().equals("")){ %>

<<%=displayType %>><%=val.getColoumn9() %></<%=displayType %>>
<%}else{%>

<%} %>


<%if(val.getColoumn10()!=null && !val.getColoumn10().equals("")){ %>

<<%=displayType %> class="value"><%=val.getColoumn10() %></<%=displayType %>>
<%}else{%>

<%} %>


<%if(val.getColoumn11()!=null && !val.getColoumn11().equals("")){ %>

<<%=displayType %>><%=val.getColoumn11() %></<%=displayType %>>
<%}else{%>

<%} %>


<%if(val.getColoumn12()!=null && !val.getColoumn12().equals("")){ %>

<<%=displayType %> class="value"><%=val.getColoumn12() %></<%=displayType %>>
<%}else{%>

<%} %>

<%if(val.getColoumn13()!=null && !val.getColoumn13().equals("")){ %>

<<%=displayType %>><%=val.getColoumn13() %></<%=displayType %>>
<%}%>


<%if(val.getColoumn14()!=null && !val.getColoumn14().equals("")){ %>

<<%=displayType %> class="value"><%=val.getColoumn14() %></<%=displayType %>>
<%}else{%>

<%} %>


<%if(val.getColoumn15()!=null && !val.getColoumn15().equals("")){ %>

<<%=displayType %>><%=val.getColoumn15() %></<%=displayType %>>
<%}else{%>

<%} %>



<%prevDisplayType = "";} if(parameterType.equalsIgnoreCase("TableHeader")){
	String colSpan = ""; 
	%>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="cmntable"> 
	<tr>
	<%if(val.getColoumn1()!=null  && !val.getColoumn1().equals("")){
		if(val.getColoumn2().equals("")){
			colSpan="2";
		}
		%>
		
		

<th colspan="<%=colSpan%>"><%=val.getColoumn1() %></th>
<%}%>
<%if(val.getColoumn2()!=null  && !val.getColoumn2().equals("")){
	colSpan = ""; 
	if(val.getColoumn3().equals("")){
			colSpan="2";
		}
		
%>

<th colspan="<%=colSpan%>"><%=val.getColoumn2() %></th>
<%}%>
<%if(val.getColoumn3()!=null  && !val.getColoumn3().equals("")){ 
	colSpan = ""; 
	if(val.getColoumn4().equals("")){
		colSpan="2";
	}
%>

<th colspan="<%=colSpan%>"><%=val.getColoumn3() %></th>
<%}%>
<%if(val.getColoumn4()!=null  && !val.getColoumn4().equals("")){ 
	colSpan = ""; 
	if(val.getColoumn5().equals("")){
		colSpan="2";
	}
%>

<th colspan="<%=colSpan%>"><%=val.getColoumn4() %></th>
<%}%>
<%if(val.getColoumn5()!=null  && !val.getColoumn5().equals("")){ 
	colSpan = ""; 
	if(val.getColoumn6().equals("")){
			colSpan="2";
		}%>

<th colspan="<%=colSpan%>"><%=val.getColoumn5() %></th>
<%}%>
<%if(val.getColoumn6()!=null  && !val.getColoumn6().equals("")){
	colSpan = ""; 
	if(val.getColoumn7().equals("")){
			colSpan="2";
		}
		
		%>

<th colspan="<%=colSpan%>"><%=val.getColoumn6() %></th>
<%}%>
<%if(val.getColoumn7()!=null  && !val.getColoumn7().equals("")){ 
	colSpan = ""; 
	if(val.getColoumn8().equals("")){
		colSpan="2";
	}
%>

<th colspan="<%=colSpan%>"><%=val.getColoumn7() %></th>
<%}%>
<%if(val.getColoumn8()!=null  && !val.getColoumn8().equals("") ){
	colSpan = ""; 
	if(val.getColoumn9().equals("")){
			colSpan="2";
		}%>

<th colspan="<%=colSpan%>"><%=val.getColoumn8() %></th>
<%}%>
<%if(val.getColoumn9()!=null  && !val.getColoumn9().equals("")){
	colSpan = ""; 
	if(val.getColoumn10().equals("")){
		colSpan="2";
	}
%>

<th colspan="<%=colSpan%>"><%=val.getColoumn9() %></th>
<%}%>
<%if(val.getColoumn10()!=null  && !val.getColoumn10().equals("")){
	colSpan = ""; 
	if(val.getColoumn11() != null && val.getColoumn11().equals("")){
			colSpan="2";
		}
		
		%>

<th colspan="<%=colSpan%>"><%=val.getColoumn10() %></th>
<%}%>
<%if(val.getColoumn11()!=null  && !val.getColoumn11().equals("")){ 
	colSpan = ""; 
	if(val.getColoumn12() != null && val.getColoumn12().equals("")){
		colSpan="2";
	}
	%></th>

<th colspan="<%=colSpan%>"><%=val.getColoumn11() %></th>
<%}%>


<%if(val.getColoumn12()!=null  && !val.getColoumn12().equals("")){ 
	colSpan = ""; 
if(val.getColoumn13() != null && val.getColoumn13().equals("")){
			colSpan="2";
		}%>

<th colspan="<%=colSpan%>"><%=val.getColoumn12() %></th>
<%}%>


<%if(val.getColoumn13()!=null  && !val.getColoumn13().equals("")){ 
	colSpan = ""; 
if(val.getColoumn14() != null && val.getColoumn14().equals("")){
			colSpan="2";
		}%>

<th colspan="<%=colSpan%>"><%=val.getColoumn13() %></th>
<%}%>


<%if(val.getColoumn14()!=null  && !val.getColoumn14().equals("")){
	colSpan = ""; 
	if(val.getColoumn15() != null && val.getColoumn15().equals("")){
		colSpan="2";
	}
	%>

<th colspan="<%=colSpan%>"><%=val.getColoumn14() %></th>
<%}%>


<%if(val.getColoumn15()!=null  && !val.getColoumn15().equals("")){ %>

<th><%=val.getColoumn15() %></th>
<%}%>
	</tr>
	
<%prevDisplayType = "";} if(parameterType.equalsIgnoreCase("TableData")){ 
	prevDisplayType = "TableData";
%>
 <tr>
	<%if(val.getColoumn1()!=null && !val.getColoumn1().equals("")){ %>
<td><%=val.getColoumn1() %></td>
<%}else if(val.getColoumn1()!=null && val.getColoumn1().equals("")){%>
<td></td>
<%} %>

<%if(val.getColoumn2()!=null && !val.getColoumn2().equals("")){ %>

<td><%=val.getColoumn2() %></td>
<%}else if(val.getColoumn2()!=null && val.getColoumn2().equals("")){%>
<td></td>
<%} %>

<%if(val.getColoumn3()!=null && !val.getColoumn3().equals("")){ %>

<td><%=val.getColoumn3() %></td>
<%}else if(val.getColoumn3()!=null && val.getColoumn3().equals("")){%>
<td></td>
<%} %>

<%if(val.getColoumn4()!=null && !val.getColoumn4().equals("")){ %>

<td><%=val.getColoumn4() %></td>
<%}else if(val.getColoumn4()!=null && val.getColoumn4().equals("")){%>
<td></td>
<%} %>



<%if(val.getColoumn5()!=null && !val.getColoumn5().equals("")){ %>

<td><%=val.getColoumn5() %></td>
<%}else if(val.getColoumn5()!=null && val.getColoumn5().equals("")){%>
<td></td>
<%} %>


<%if(val.getColoumn6()!=null && !val.getColoumn6().equals("")){ %>

<td><%=val.getColoumn6() %></td>
<%}else if(val.getColoumn6()!=null && val.getColoumn6().equals("")){%>
<td></td>
<%} %>


<%if(val.getColoumn7()!=null && !val.getColoumn7().equals("")){ %>

<td><%=val.getColoumn7() %></td>

<%}else if(val.getColoumn7()!=null && val.getColoumn7().equals("")){%>
<td></td>
<%} %>

<%if(val.getColoumn8()!=null && !val.getColoumn8().equals("")){ %>

<td><%=val.getColoumn8() %></td>
<%}else if(val.getColoumn8()!=null && val.getColoumn8().equals("")){%>
<td></td>
<%} %>


<%if(val.getColoumn9()!=null && !val.getColoumn9().equals("")){ %>

<td><%=val.getColoumn9() %></td>
<%}else if(val.getColoumn9()!=null && val.getColoumn9().equals("")){%>
<td></td>
<%} %>


<%if(val.getColoumn10()!=null && !val.getColoumn10().equals("")){ %>

<td><%=val.getColoumn10() %></td>
<%}else if(val.getColoumn11()!=null && val.getColoumn10().equals("")){%>
<td></td>
<%} %>


<%if(val.getColoumn11()!=null && !val.getColoumn11().equals("")){ %></td>

<td><%=val.getColoumn11() %></td>
<%}else if(val.getColoumn11()!=null && val.getColoumn11().equals("")){%>
<td></td>
<%} %>



<%if(val.getColoumn12()!=null && !val.getColoumn12().equals("")){ %>

<td><%=val.getColoumn12() %></td>
<%}else if(val.getColoumn12()!=null && val.getColoumn12().equals("")){%>
<td></td>
<%} %>


<%if(val.getColoumn13()!=null && !val.getColoumn13().equals("")){ %>

<td><%=val.getColoumn13() %></td>
<%}else if(val.getColoumn13()!=null && val.getColoumn13().equals("")){%>
<td></td>
<%} %>


<%if(val.getColoumn14()!=null && !val.getColoumn14().equals("")){ %>

<td><%=val.getColoumn14() %></td>
<%}else if(val.getColoumn14()!=null && val.getColoumn14().equals("")){%>
<td></td>
<%} %>


<%if(val.getColoumn15()!=null && !val.getColoumn15().equals("")){ %>

<td><%=val.getColoumn15() %></td>
<%}else if( val.getColoumn15()!=null && val.getColoumn15().equals("")){%>
<td></td>
<%} %>

</tr>


	<%}
	} %>

	


<div class="clear"></div>


<%}%>
<input type="button" value="Print" id="print" onclick="printRpt()"/>

</form>
<style>

table td label {font-size:14px !important;}
table th, table td {font-size:14px !important;}
label, label.value {font-size:14px !important;}
h4 {font-size:16px !important;}


.fontBold {font-weight:bold;}
table th {text-align:left;}
.h2Text {font-size:20px; margin:7px 0px;}
.h1Text {font-size:22px; margin:7px 0px;}

.table {border:solid 1px #ccc;}
.table th {border:solid 1px #ccc;}
.table td {border:solid 1px #ccc;}


</style>
<script> 
function printRpt(){
	document.getElementById('print').style.display='none';
	window.print();
}
</script>