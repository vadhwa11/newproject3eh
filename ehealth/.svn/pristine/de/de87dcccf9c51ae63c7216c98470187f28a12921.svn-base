

<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<Inpatient> inPatientList = new ArrayList<Inpatient>(); 
	if(map.get("inPatientList") != null){
		inPatientList = (List)map.get("inPatientList");
	}

	if(inPatientList.size() > 0){
		Inpatient inpatient = (Inpatient)inPatientList.get(0);
%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<label>Admision No.</label>
<input type="text" id="AdNumber" name="AdNumber" tabindex="1"
	value="<%=inpatient.getAdNo()%>" class="date" validate="IP No.,int,yes"
	MAXLENGTH="30" />

<label>Ward</label>
<input type="text" id="Department" name="Department" tabindex="1"
	value="<%=inpatient.getDepartment().getDepartmentName()%>" class="date"
	validate="Department,int,yes" MAXLENGTH="30" />

<label>Age</label>
<input type="text" id="Age" name="Age" tabindex="1"
	value="<%=inpatient.getAge()%>" class="date" validate="Age,int,yes"
	MAXLENGTH="30" />

<label>Bed No.</label>
<input type="text" id="BedNo" name="BedNo" tabindex="1"
	value="<%=inpatient.getBed().getBedNo()%>" class="date"
	validate="Bed No,int,yes" MAXLENGTH="30" />

<%} %>

