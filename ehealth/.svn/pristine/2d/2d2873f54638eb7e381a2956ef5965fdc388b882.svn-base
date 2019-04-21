<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.PhRevisedNationalTuberculosisScreening"%>
<%@page import="jkt.hms.masters.business.PhRevisedNationalTuberculosisFollowup"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css"    id="vbulletin_css" />
<title>Insert title here</title>
<%
    Map map = new HashMap();
    Box box = HMSUtil.getBox(request);
    if (request.getAttribute("map") != null)
    {
        map = (Map) request.getAttribute("map");
	}
    List<Object[]>phdList=new ArrayList<Object[]>();
    if(map.get("phdList")!=null){
    	phdList=(List<Object[]>)map.get("phdList");
    }
    List<PhRevisedNationalTuberculosisFollowup>phdfollowup=new ArrayList<PhRevisedNationalTuberculosisFollowup>();
    if(map.get("phdfollowup")!=null){
    	phdfollowup=(List<PhRevisedNationalTuberculosisFollowup>)map.get("phdfollowup");
    }
    int genderId=0;
    if(map.get("genderId")!=null){
    	genderId=(Integer)map.get("genderId");
    }

%>
<style>
table td input.width75{width:75px;}
table td input.width45{width:45px;}

</style>

</head>
<body>
		<div id="mainIn">
		<form name="manufactureDetail" action="" method="post" enctype="multipart/form-data">
		<div class="clear"></div>
		<h4>RNTCP Detail.</h4>
		<div class="cmntable">
		<table width="100%" colspan="1" id="itemDetails" border="0"  cellpadding="0" cellspacing="0">
		    <% int i=0; if (phdList.size() > 0) {%>
			 <thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Past History Of TB</th>
					<th scope="col">Any Family Member Having TB</th>
					<th scope="col">Cough More Than 2 Weak</th>
					<th scope="col">Blood Stained Sputum</th>
					<th scope="col">Fever</th>
					<th scope="col">Loss in Weight</th>
					<th scope="col">History of Diabetic Melitus</th>
					<th scope="col">COPD</th>
					<th scope="col">Smoking</th>
					<th scope="col">Alcohol</th>
					<th scope="col">Remarks</th>
					
				</tr>
			 </thead>	
		      <tbody>
		      
					<%
					int count=1;
					for (Object[] phd : phdList) {%>
					<tr >
						<td><label><%=count++%></label></td>
						<td><input class="width75" type="text" style="color:green" value="<%=phd[4]!=null?phd[4]:""%>" readonly="readonly"></td>
						<td><input class="width75" type="text" style="color:green" value="<%=phd[5]!=null?phd[5]:""%>" readonly="readonly"></td>
						<td><input class="width75" type="text" style="color:green" value="<%=phd[6]!=null?phd[6]:""%>" readonly="readonly"></td>
						<td><input class="width75" type="text" style="color:green" value="<%=phd[7]!=null?phd[7]:""%>" readonly="readonly"></td>
						<td><input class="width75" type="text" style="color:green" value="<%=phd[8]!=null?phd[8]:""%>" readonly="readonly"></td>
						<td><input class="width75" type="text" style="color:green" value="<%=phd[9]!=null?phd[9]:""%>" readonly="readonly"></td>
						<td><input class="width75" type="text" style="color:green" value="<%=phd[10]!=null?phd[10]:""%>" readonly="readonly"></td>
						<td><input class="width75" type="text" style="color:green" value="<%=phd[11]!=null?phd[11]:""%>" readonly="readonly"></td>
						<td><input class="width75" type="text" style="color:green" value="<%=phd[12]!=null?phd[12]:""%>" readonly="readonly"></td>
						<td><input class="width75" type="text" style="color:green" value="<%=phd[13]!=null?phd[13]:""%>" readonly="readonly"></td>
						<td><input class="width75" type="text" style="color:green" value="<%=phd[15]!=null?phd[15]:""%>" readonly="readonly"></td>
						
					<tr>
					<%}
				}%>
		      </tbody>
		</table>
		</div>
		<%-- <%if (phdfollowup.size() > 0) { %>
		<h4>NCD Pattern Follow up Data</h4>
		<%}%>
		<div class="cmntable">
		<table width="100%" colspan="1" id="itemDetails" border="0"  cellpadding="0" cellspacing="0">
		    <% int j=0; if (phdfollowup.size() > 0) { %>
			 <thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Past History Of TB</th>
					<th scope="col">Any Family Member Having TB</th>
					<th scope="col">Cough More Than 2 Weak</th>
					<th scope="col">Blood Stained Sputum</th>
					<th scope="col">Fever</th>
					<th scope="col">Loss in Weight</th>
					<th scope="col">History of Diabetic Melitus</th>
					<th scope="col">COPD</th>
					<th scope="col">Smoking</th>
					<th scope="col">Alcohol</th>
					<th scope="col">Remarks</th>
					
				</tr>
			 </thead>	
		      <tbody>
		      
					<%
					int count=1;
					for (PhDiseaseRegistrationFollow phd : phdfollowup) {%>
					<tr >
						<td><label><%=count++%></label></td>
						
						<td><input class="width75" type="text" style="color:green" value="<%=phd.getPastHistoryTb()!=null?phd.getPastHistoryTb():""%>" readonly="readonly"></td>
						<td><input class="width45" type="text" style="color:green" value="<%=phd.getFamilyMemberTb()!=null?phd.getFamilyMemberTb():""%>" readonly="readonly"></td>
						<td><input class="width45" type="text" style="color:green" value="<%=phd.getCoughMorethanTwoWeeks()!=null?phd.getCoughMorethanTwoWeeks():""%>" readonly="readonly"></td>
						<td><input class="width45" type="text" style="color:green" value="<%=phd.getBloodStainedSputum()!=null?phd.getBloodStainedSputum():""%>" readonly="readonly"></td>
						<td><input class="width45" type="text" style="color:green" value="<%=phd.getFever()!=null?phd.getFever():""%>" readonly="readonly"></td>
						<td><input class="width45" type="text" style="color:green" value="<%=phd.getLossOfWeight()!=null?phd.getLossOfWeight():""%>" readonly="readonly"></td>
						<td><input class="width45" type="text" style="color:green" value="<%=phd.getHistoryOfDiabetesMellitus()!=null?phd.getHistoryOfDiabetesMellitus():""%>" readonly="readonly"></td>
						<td><input class="width45" type="text" style="color:green" value="<%=phd.getCopd()!=null?phd.getCopd():""%>" readonly="readonly"></td>
						<td><input class="width45" type="text" style="color:green" value="<%=phd.getSmoking()!=null?phd.getSmoking():""%>" readonly="readonly"></td>
						<td><input class="width45" type="text" style="color:green" value="<%=phd.getAlcohol()!=null?phd.getAlcohol():""%>" readonly="readonly"></td>
						<td><input class="width45" type="text" style="color:green" value="<%=phd.getRemarks()!=null?phd.getRemarks():""%>" readonly="readonly"></td>
						
						
					<tr>
					<%}
				}%>
		      </tbody>
		</table>
		</div> --%>
		<input type="button" name="Submit" class="button" value="Close" onclick="javascript: window.close();" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

		</div>
</body>
</html>