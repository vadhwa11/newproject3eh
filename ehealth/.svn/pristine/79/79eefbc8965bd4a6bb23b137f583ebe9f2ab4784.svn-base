<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.PhDiseaseRegistrationScreening"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
List<OpdPatientDetails>list= new ArrayList<OpdPatientDetails>();
if(map.get("visitList") != null){
	list = (List)map.get("visitList");
}
List<PhDiseaseRegistrationScreening>pdrslist= new ArrayList<PhDiseaseRegistrationScreening>();
if(map.get("pdrslist") != null){
	pdrslist = (List)map.get("pdrslist");
}

%>
<%	if(list.size() >0 || pdrslist.size()>0){ %>
<tr><th>OPD Date Time</th><th>Pulse</th><th>Temperature (&deg;f)</th><th>BP</th><th>Height (Cm)</th><th>Weight (Kg)</th><th>BMI</th><th>BMI Status</th></tr> 
<%	if(list.size() !=0){ %>
	
		<%for (OpdPatientDetails opdPatientDetails :list) {
			String bmiStatus="";
			boolean vitalStatus=false;
			if(opdPatientDetails.getBmi()!=null && opdPatientDetails.getBmi() > 0f){
				Float bmi=opdPatientDetails.getBmi();
				if(bmi<=18.5){
					bmiStatus="Underweight";	
				}else if(bmi>=18.5 && bmi<=23){
					bmiStatus="Healthy Range";	
				}else if(bmi>23 && bmi<=29.9){
					bmiStatus="Overweight";
				}else if(bmi>=30 && bmi<=35){
					bmiStatus="Obesity";
				}else if(bmi>35){
					bmiStatus="Severely obese ";
				}
			}
			
			if(opdPatientDetails.getPulse()!=null && opdPatientDetails.getPulse() != 0){
				vitalStatus = true;
			}else if(opdPatientDetails.getTemperature()!=null && opdPatientDetails.getTemperature() > 0f){
				vitalStatus = true;
			}else if(opdPatientDetails.getBp()!=null && !opdPatientDetails.getBp().equals("")){
				vitalStatus = true;
			}else if(opdPatientDetails.getHeight()!=null && opdPatientDetails.getHeight() != 0){
				vitalStatus = true;
			}else if(opdPatientDetails.getWeight()!=null && opdPatientDetails.getWeight() != 0){
				vitalStatus = true;
			}else if(opdPatientDetails.getBmi()!=null && opdPatientDetails.getBmi() > 0f){
				vitalStatus = true;
			}else if(bmiStatus!=null && !bmiStatus.equals("")){
				vitalStatus = true;
			}else{
				vitalStatus = false;
			}
if(vitalStatus){		
%>			
<tr>
	<td><%= opdPatientDetails.getOpdDate()!=null? HMSUtil.changeDateToddMMyyyy(opdPatientDetails.getOpdDate()):""%>&nbsp;<%= opdPatientDetails.getOpdTime() %></td>
	<%if(opdPatientDetails.getPulse()!=null && opdPatientDetails.getPulse() != 0){%>
		<td><%=opdPatientDetails.getPulse()%></td>
	<%}else{ %>
		<td></td>
	<%} %>
	
	<%if(opdPatientDetails.getTemperature()!=null && opdPatientDetails.getTemperature() > 0f){%>
		<td><%=opdPatientDetails.getTemperature()%></td>
	<%}else{ %>
		<td></td>
	<%} %>
	
	<%if(opdPatientDetails.getBp()!=null){%>
		<td><%=opdPatientDetails.getBp()%></td>
	<%}else{ %>
		<td></td>
	<%} %>
	
	<%if(opdPatientDetails.getHeight()!=null && opdPatientDetails.getHeight() != 0){%>
		<td><%=opdPatientDetails.getHeight()%> </td>
	<%}else{ %>
		<td></td>
	<%} %>
	
	<%if(opdPatientDetails.getWeight()!=null && opdPatientDetails.getWeight() != 0){%>
		<td><%=opdPatientDetails.getWeight()%></td>
	<%}else{ %>
		<td></td>
	<%} %>
	
	<%if(opdPatientDetails.getBmi()!=null && opdPatientDetails.getBmi() > 0f){%>
		<td><%=opdPatientDetails.getBmi()%></td>
	<%}else{ %>
		<td></td>
	<%} %>
	
	<%if(bmiStatus!=null && !bmiStatus.equals("")){%>
		<td><%=bmiStatus%></td>
	<%}else{ %>
		<td></td>
	<%} %>
</tr>
<%} %>
<%} }if(pdrslist.size() !=0){ %>
<%for (PhDiseaseRegistrationScreening pdrs :pdrslist) {
	String bmiStatus="";
	if(pdrs.getBmi()!=null && Float.parseFloat(pdrs.getBmi()) > 0f){
		Float bmi=Float.parseFloat(pdrs.getBmi());
		if(bmi<=18.5){
			bmiStatus="Underweight";	
		}else if(bmi>=18.5 && bmi<=23){
			bmiStatus="Healthy Range";	
		}else if(bmi>23 && bmi<=29.9){
			bmiStatus="Overweight";
		}else if(bmi>=30 && bmi<=35){
			bmiStatus="Obesity";
		}else if(bmi>35){
			bmiStatus="Severely obese ";
		}
	}
	
%>			
<tr>
<td style="color:green"><%= pdrs.getRegDate()!=null? HMSUtil.changeDateToddMMyyyy(pdrs.getRegDate()):""%>&nbsp;<%= pdrs.getFollowTime() %></td>

<td></td>
<td></td>

<%if(pdrs.getBloodPreMin()!=null){ %>
<%if(pdrs.getBloodPreMin()>90 ||pdrs.getBloodPreMax()>120){%>
<td style="color:red" ><%=pdrs.getBloodPreMax()+"/"+pdrs.getBloodPreMin()%></td>
<%}else{ %>
<td style="color:green" ><%=pdrs.getBloodPreMax()+"/"+pdrs.getBloodPreMin()%></td>
<%}}else{ %>
<td></td>
<%} %>

<%if(pdrs.getHeight()!=null && !(pdrs.getHeight().toString().equals(""))){%>
<td style="color:green"><%=pdrs.getHeight()%> </td>
<%}else{ %>
<td></td>
<%} %>

<%if(pdrs.getWeight()!=null && !(pdrs.getWeight().equals(""))){%>
<td style="color:green"><%=pdrs.getWeight()%></td>
<%}else{ %>
<td></td>
<%} %>

<%if(pdrs.getBmi()!=null && Float.parseFloat(pdrs.getBmi()) > 0f){ %>
<%if(Float.parseFloat(pdrs.getBmi()) > 23f){%>
<td style="color:red"><%=pdrs.getBmi()%></td>
<%}else{ %>
<td style="color:green"><%=pdrs.getBmi()%></td>
<%}}else{ %>
<td></td>
<%} %>

<%if(bmiStatus!=null && !bmiStatus.equals("")){%>
<%if(bmiStatus.equals("Overweight")){%>
<td style="color:red"><%=bmiStatus%></td>
<%}else{ %>
<td style="color:green"><%=bmiStatus%></td>
<%}}else{ %>
<td></td>
<%} %>
</tr>
<%} }}else{ %>
	No vital Details
<%}%>




