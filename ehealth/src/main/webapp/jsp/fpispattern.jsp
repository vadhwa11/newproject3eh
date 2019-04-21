<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.PhDiseaseRegistrationScreening"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>

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
    List<Object[]>fpisList=new ArrayList<Object[]>();
    if(map.get("fpisList")!=null){
    	fpisList=(List<Object[]>)map.get("fpisList");
    }
    
%>

</head>
<body>
		<div id="mainIn">
		<form name="manufactureDetail" action="" method="post" enctype="multipart/form-data">
		<div class="clear"></div>
		<h4>FPIS Detail</h4>
		<div class="cmntable">
		<table width="100%" colspan="1" id="itemDetails" border="0"  cellpadding="0" cellspacing="0">
		    <% int i=0; if (fpisList.size() > 0) {%>
			 <thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Sterilization Date</th>
					<th scope="col">Number Of Children</th>
					<th scope="col">Name Of Hospital</th>
					<th scope="col">LMP Date</th>
					<th scope="col">Failure Date</th>
					<th scope="col">Mode Of Pregnancy</th>
				</tr>
			 </thead>	
		      <tbody>
		      
					<%
					int count=1;
					for (Object[] phd : fpisList) {
						Date sterlizedDate = (Date) phd[4];	
						Date lmpDate = (Date) phd[6];
						Date failureDate = (Date) phd[7];
					String pregMode="";
					if(phd[8].toString().equals("Other")){
						pregMode=phd[9].toString();
					}else{
						pregMode=phd[8].toString();
					}
					%>
					
					<tr >
						<td><label><%=count++%></label></td>
						
					<td><input type="text" value="<%=sterlizedDate!=null?HMSUtil.convertDateOneFormatToAnother("dd-MM-YYYY",sterlizedDate):""%>" readonly="readonly"></td> 
						<td><input type="text" value="<%=phd[25]!=null?phd[25]:""%>" readonly="readonly"></td>
						<td><input type="text" value="<%=phd[45]!=null?phd[45]:""%>" readonly="readonly"></td>
						<td><input type="text" value="<%=lmpDate!=null?HMSUtil.convertDateOneFormatToAnother("dd-MM-YYYY",lmpDate):""%>" readonly="readonly"></td>
						<td><input type="text" value="<%=failureDate!=null?HMSUtil.convertDateOneFormatToAnother("dd-MM-YYYY",failureDate):""%>" readonly="readonly"></td>
						<td><input type="text" value="<%=pregMode!=null?pregMode:""%>" readonly="readonly"></td>
					<tr>
					<%}
				}%>
		      </tbody>
		</table>
		</div>
		<input type="button" name="Submit" class="button" value="Close" onclick="javascript: window.close();" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

		</div>
</body>
</html>