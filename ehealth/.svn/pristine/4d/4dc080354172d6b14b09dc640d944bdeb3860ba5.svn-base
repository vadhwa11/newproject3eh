<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.PhDiseaseRegistrationScreening"%>
<%@page import="jkt.hms.masters.business.PhDiseaseRegistrationFollow"%>
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
    List<PhDiseaseRegistrationScreening>phdList=new ArrayList<PhDiseaseRegistrationScreening>();
    if(map.get("phdList")!=null){
    	phdList=(List<PhDiseaseRegistrationScreening>)map.get("phdList");
    }
    List<PhDiseaseRegistrationFollow>phdfollowup=new ArrayList<PhDiseaseRegistrationFollow>();
    if(map.get("phdfollowup")!=null){
    	phdfollowup=(List<PhDiseaseRegistrationFollow>)map.get("phdfollowup");
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
		<%if (phdfollowup.size() > 0 ||phdList.size() > 0) { %>
		<h4>NCD Pattern</h4>
		<div class="cmntable">
		<table width="100%" colspan="1" id="itemDetails" border="0"  cellpadding="0" cellspacing="0">
		    <% int i=0; if (phdList.size() > 0) {%>
			 <thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Registration Date</th>
					<th scope="col">Suspected NCD</th>
					<th scope="col">Blood Pressure</th>
					<th scope="col">RBS</th>
					<th scope="col">Height</th>
					<th scope="col">Weight</th>
					<th scope="col">BMI</th>
					<th scope="col">Waist</th>
					<th scope="col">HIP</th>
					<th scope="col">Waist-Hip Ratio</th>
					<th scope="col">Follow Date</th>
					<th scope="col">Remarks</th>
					
				</tr>
			 </thead>	
		      <tbody>
		      
					<%
					int count=1;
					for (PhDiseaseRegistrationScreening phd : phdList) {%>
					<tr >
						<td><label><%=count++%></label></td>
						<td><input class="width75" type="text"  style="color:green" value="<%=phd.getRegDate()!=null?HMSUtil.convertDateOneFormatToAnother("dd-MM-YYYY",phd.getRegDate()):""%>" readonly="readonly"></td>
						<td><input class="width75" type="text" style="color:green" value="<%=phd.getSuspectedNcd()!=null?phd.getSuspectedNcd():""%>" readonly="readonly"></td>
						<%if(phd.getBloodPreMin()!=null){%>
                            <%if((phd.getBloodPreMin()>90 || phd.getBloodPreMin()<80) ||(phd.getBloodPreMax()>140 || phd.getBloodPreMax()<120)){%>
						<td><input class="width75" type="text" style="color:red" value="<%=phd.getBloodPreMax()%>/<%=phd.getBloodPreMin()%>" readonly="readonly">
						<%}else{ %>
                               <td><input class="width75" type="text" style="color:green" value="<%=phd.getBloodPreMax()%>/<%=phd.getBloodPreMin()%>" readonly="readonly">
                           <%}}else{ %>
                             <td></td>
                              <%} %>
                            <%if(phd.getBloodSugarRbs()!=null){%>
                             <%if(Float.parseFloat(phd.getBloodSugarRbs())>200){%> 
						<td><input class="width45" type="text" style="color:red" value="<%=phd.getBloodSugarRbs()!=null?phd.getBloodSugarRbs():""%>" readonly="readonly"></td>
						<%}else{ %>
                              <td><input class="width45" type="text" style="color:green" value="<%=phd.getBloodSugarRbs()!=null?phd.getBloodSugarRbs():""%>" readonly="readonly"></td>
                           <%}}else{ %>
                             <td></td>
                              <%} %>
						<td><input class="width45" type="text" style="color:green" value="<%=phd.getHeight()!=null?phd.getHeight():""%>"></td>
						<td><input class="width45" type="text" style="color:green" value="<%=phd.getWeight()!=null?phd.getWeight():""%>"></td>
						<%if(phd.getBmi()!=null && Float.parseFloat(phd.getBmi()) > 0f){ %>
                              <%if(Float.parseFloat(phd.getBmi()) > 23f){%>
						<td><input class="width45" type="text" style="color:red" value="<%=phd.getBmi()!=null?phd.getBmi():""%>" readonly="readonly"></td>
						<%}else{ %>
                        <td><input class="width45" type="text" style="color:green" value="<%=phd.getBmi()!=null?phd.getBmi():""%>" readonly="readonly"></td>
                         <%}}else{ %>
                            <td></td>
                            <%} %>
						<td><input class="width45" type="text" style="color:green" value="<%=phd.getWaist()!=null?phd.getWaist():""%>" readonly="readonly"></td>
						<td><input class="width45" type="text"  style="color:green" value="<%=phd.getHip()!=null?phd.getHip():""%>" readonly="readonly"></td>
						<%if(genderId==3){ %>
						<%if(phd.getWaistHipRatio()!=null){ %>
                            <%if(Float.parseFloat(phd.getWaistHipRatio()) > 1f){%>
						<td><input class="width75" type="text" style="color:red" value="<%=phd.getWaistHipRatio()!=null?phd.getWaistHipRatio():""%>" readonly="readonly"></td>
						<%}else{ %>
                       <td><input class="width75" type="text" style="color:green" value="<%=phd.getWaistHipRatio()!=null?phd.getWaistHipRatio():""%>" readonly="readonly"></td>
                         <%}}else{ %>
                            <td></td>
                            <%} } else{ %>
                            
						<%if(phd.getWaistHipRatio()!=null){ %>
                            <%if(Float.parseFloat(phd.getWaistHipRatio()) > 0.85f){%>
						<td><input class="width75" type="text" style="color:red" value="<%=phd.getWaistHipRatio()!=null?phd.getWaistHipRatio():""%>" readonly="readonly"></td>
						<%}else{ %>
                       <td><input class="width75" type="text" style="color:green" value="<%=phd.getWaistHipRatio()!=null?phd.getWaistHipRatio():""%>" readonly="readonly"></td>
                         <%}}else{ %>
                            <td></td>
                            <%}}%>
						<td><input class="width75" type="text" style="color:green" value="<%=HMSUtil.convertDateOneFormatToAnother("dd-MM-YYYY",phd.getFollowDate()) %>" readonly="readonly"></td>
						<td><input type="text" style="color:green" value="<%=phd.getRemarks()!=null?phd.getRemarks():""%>" readonly="readonly"></td>
						
						
					<tr>
					<%}
				}%>
		      </tbody>
		</table>
		</div>
		<%if (phdfollowup.size() > 0) { %>
		<h4>NCD Pattern Follow up Data</h4>
		<%}%>
		<div class="cmntable">
		<table width="100%" colspan="1" id="itemDetails" border="0"  cellpadding="0" cellspacing="0">
		    <% int j=0; if (phdfollowup.size() > 0) { %>
			 <thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Follow Up Date</th>
					<th scope="col">Complications</th>
					<th scope="col">Blood Pressure</th>
					<th scope="col">RBS</th>
					<th scope="col">Height</th>
					<th scope="col">Weight</th>
					<th scope="col">BMI</th>
					 <th scope="col">Waist</th>
					<th scope="col">HIP</th>
					<th scope="col">Waist-Hip Ratio</th>
					<!--  <th scope="col">Next Follow Date</th> -->
					<th scope="col">Remarks</th>
					
				</tr>
			 </thead>	
		      <tbody>
		      
					<%
					int count=1;
					for (PhDiseaseRegistrationFollow phd : phdfollowup) {%>
					<tr >
						<td><label><%=count++%></label></td>
						<td><input class="width75" type="text" style="color:green" value="<%=phd.getFollowDate()!=null?HMSUtil.convertDateOneFormatToAnother("dd-MM-YYYY",phd.getFollowDate()):""%>" readonly="readonly"></td>
						<td><input class="width75" type="text" style="color:red" value="<%=phd.getComplications()!=null?phd.getComplications():""%>" readonly="readonly"></td>
						<%if(phd.getBpMin()!=null){%>
						  <%if((phd.getBpMin()>90 || phd.getBpMin()<80) ||(phd.getBpMax()>140 || phd.getBpMax()<120)){%>
						<td><input class="width75" type="text" style="color:red" value="<%=phd.getBpMax()%>/<%=phd.getBpMin()%>" readonly="readonly">
						<%}else{ %>
						<td><input class="width75" type="text" style="color:green" value="<%=phd.getBpMax()%>/<%=phd.getBpMin()%>" readonly="readonly">
						<%} %>
						<%}else{ %>
						<td></td>
						<%} %>
						 <td><input class="width45" type="text" style="color:green" value="<%=phd.getSugerValue()!=null?phd.getSugerValue():""%>" readonly="readonly"></td> 
						<td><input class="width45" type="text" style="color:green" value="<%=phd.getHeight()!=null?phd.getHeight():""%>"></td> 
						<td><input class="width45" type="text"  style="color:green" value="<%=phd.getWeight()!=null?phd.getWeight():""%>"></td>
						<%if(phd.getBmi()!=null && Float.parseFloat(phd.getBmi()) > 0f){ %>
                              <%if(Float.parseFloat(phd.getBmi()) > 23f){%>
						<td><input class="width45" type="text" style="color:red" value="<%=phd.getBmi()!=null?phd.getBmi():""%>" readonly="readonly"></td>
						<%}else{ %>
                        <td><input class="width45" type="text" style="color:green" value="<%=phd.getBmi()!=null?phd.getBmi():""%>" readonly="readonly"></td>
                         <%}}else{ %>
                            <td></td>
                            <%} %>
						 <td><input class="width45" type="text" style="color:green" value="<%=phd.getWaist()!=null?phd.getWaist():""%>" readonly="readonly"></td>
						<td><input class="width45" type="text" style="color:green" value="<%=phd.getHip()!=null?phd.getHip():""%>" readonly="readonly"></td>
						<%if(genderId==3){ %>
						<%if(phd.getWaisthipratio()!=null){ %>
                            <%if(Float.parseFloat(phd.getWaisthipratio()) > 1f){%>
						<td><input class="width75" type="text" style="color:red" value="<%=phd.getWaisthipratio()!=null?phd.getWaisthipratio():""%>" readonly="readonly"></td>
						<%}else{ %>
                       <td><input class="width75" type="text" style="color:green" value="<%=phd.getWaisthipratio()!=null?phd.getWaisthipratio():""%>" readonly="readonly"></td>
                         <%}}else{ %>
                            <td></td>
                            <%} } else{ %>
                            
						<%if(phd.getWaisthipratio()!=null){ %>
                            <%if(Float.parseFloat(phd.getWaisthipratio()) > 0.85f){%>
						<td><input class="width75" type="text" style="color:red" value="<%=phd.getWaisthipratio()!=null?phd.getWaisthipratio():""%>" readonly="readonly"></td>
						<%}else{ %>
                       <td><input class="width75" type="text" style="color:green" value="<%=phd.getWaisthipratio()!=null?phd.getWaisthipratio():""%>" readonly="readonly"></td>
                         <%}}else{ %>
                            <td></td>
                            <%}}%>
						<%-- <td><input class="width75" type="text" style="color:green" value="<%=HMSUtil.convertDateOneFormatToAnother("dd-MM-YYYY",phd.getNextFollowDate()) %>" readonly="readonly"></td> --%> 
						<td><input type="text" style="color:green" value="<%=phd.getRemarks()!=null?phd.getRemarks():""%>" readonly="readonly"></td>
						
						
					<tr>
					<%}
				}%>
		      </tbody>
		</table>
		</div>
		 <%}else{ %>
		<h4>This is Not a NCD Patient</h4> 
		  <%} %>
		<input type="button" name="Submit" class="button" value="Close" onclick="javascript: window.close();" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

		</div>
</body>
</html>