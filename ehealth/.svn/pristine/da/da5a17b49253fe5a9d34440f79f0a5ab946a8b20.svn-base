<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain"%>
<%@page import="jkt.hms.masters.business.OtPreAnaesthesiaProNotesSub"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<%

Map map = new HashMap();
OtPreAnaesthesiaProcNotesMain preAnesthesiaNotesMain=new OtPreAnaesthesiaProcNotesMain();
List<OtPreAnaesthesiaProNotesSub> preAnesthesiaNotesSubList=new ArrayList<OtPreAnaesthesiaProNotesSub>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
if(map.get("preAnesthesiaData")!=null){
	preAnesthesiaNotesMain=(OtPreAnaesthesiaProcNotesMain)map.get("preAnesthesiaData");
}

if(map.get("preAnesthesiaNotesSubList")!=null){
	preAnesthesiaNotesSubList=(List<OtPreAnaesthesiaProNotesSub>)map.get("preAnesthesiaNotesSubList");
}

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ot Pre Anesthesia History</title>
</head>
<body>

<div class="titleBg">
<h2>Ot Pre Anesthesia History</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label>Requisition Date</label>
<input type="text" readonly="readonly" value="<%=preAnesthesiaNotesMain.getBooking()!=null&&preAnesthesiaNotesMain.getBooking().getOpdSurseryHeader()!=null?preAnesthesiaNotesMain.getBooking().getOpdSurseryHeader().getRequisitionDate():"" %>"/>

<label>Requisition No</label>
<input type="text" readonly="readonly" value="<%=preAnesthesiaNotesMain.getBooking()!=null?preAnesthesiaNotesMain.getBooking().getOrderNo():"" %>"/>

<label>Pre Operative Advice </label>
<textarea readonly="readonly" ><%=preAnesthesiaNotesMain.getPreOperativeAdvice()%></textarea>

<div class="clear"></div>
<h2>Patient Advice</h2>
<div class="clear"></div>

<label>Patient Advise </label>
<textarea readonly="readonly" ><%=preAnesthesiaNotesMain.getPatientAdvice() %></textarea>

<label>Doctor's Notes </label>
<textarea readonly="readonly" ><%=preAnesthesiaNotesMain.getDoctorNotes()%></textarea>

<label>Multiple Drug </label>
<textarea readonly="readonly" ><%=preAnesthesiaNotesMain.getMultipleDrug() %></textarea>

<div class="clear"></div>
<h2>PreMedication</h2>
<div class="clear"></div>

<table>
<tr>
<th>Item Code</th>
<th>Item Name</th>
<th>Dose</th>
<th>Route</th>
</tr>


<%
if(preAnesthesiaNotesSubList.size()>0){

for(OtPreAnaesthesiaProNotesSub preAnesthesiaSub:preAnesthesiaNotesSubList){
	if(preAnesthesiaSub.getStoreItem()!=null){
%>
<tr>
<td><%=preAnesthesiaSub.getStoreItem().getPvmsNo() %></td>
<td><%=preAnesthesiaSub.getStoreItem().getNomenclature() %></td>
<td><%=preAnesthesiaSub.getDose() %></td>
<td><%=preAnesthesiaSub.getRoute() %></td>
</tr>


<%} }}%>

</table>
<div class="clear"></div>
<div class="clear"></div>
<label>Remarks</label>
<textarea readonly="readonly" ><%=preAnesthesiaNotesMain.getRemarks() %></textarea>

</div>


</body>
</html>