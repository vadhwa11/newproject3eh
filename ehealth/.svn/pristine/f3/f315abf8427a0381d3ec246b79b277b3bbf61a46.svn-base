<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<%

Map map = new HashMap();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}



%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OT PAC HISTORY</title>
</head>
<form name="pacHistory" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Ot PAC History (Anesthesia)</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label>Smoking/ Alcohol </label> 
<input type="text" readonly="readonly" value="<%=map.get("Smoking")!=null?(String)map.get("Smoking"):""%>"/>

<label style="width:180px">Previous Treatment/Surgery </label> 
<input type="text" readonly="readonly" value="<%=map.get("Previous Treatment")!=null?(String)map.get("Previous Treatment"):""%>"/>
<div class="clear"></div>

<h2>General Examination</h2>

<div class="clear"></div>
<label>Pulse </label> 
<input type="text" readonly="readonly" value="<%=map.get("Pulse")!=null?(String)map.get("Pulse"):""%>"/>

<label>Icetrus </label> 
<input type="text" readonly="readonly" value="<%=map.get("Icetrus")!=null?(String)map.get("Icetrus"):""%>"/>

<label>Nourishment </label> 
<input type="text" readonly="readonly" value="<%=map.get("Nourishment")!=null?(String)map.get("Nourishment"):""%>"/>

<label>Pallor </label> 
<input type="text" readonly="readonly" value="<%=map.get("Pallor")!=null?(String)map.get("Pallor"):""%>"/>

<label>Oedema </label> 
<input type="text" readonly="readonly" value="<%=map.get("Oedema")!=null?(String)map.get("Oedema"):""%>"/>

<label>BP </label> 
<input type="text" readonly="readonly" value="<%=map.get("BP")!=null?(String)map.get("BP"):""%>"/>

<label>Cyanosis </label> 
<input type="text" readonly="readonly" value="<%=map.get("Cyanosis")!=null?(String)map.get("Cyanosis"):""%>"/>

<label>Spine </label> 
<input type="text" readonly="readonly" value="<%=map.get("Spine")!=null?(String)map.get("Spine"):""%>"/>

<label>Airway </label> 
<input type="text" readonly="readonly" value="<%=map.get("Airway")!=null?(String)map.get("Airway"):""%>"/>

<label>Clubbing </label> 
<input type="text" readonly="readonly" value="<%=map.get("Clubbing")!=null?(String)map.get("Clubbing"):""%>"/>

<label>Thyroid </label> 
<input type="text" readonly="readonly" value="<%=map.get("Thyroid")!=null?(String)map.get("Thyroid"):""%>"/>

<label>Venus Access </label> 
<input type="text" readonly="readonly" value="<%=map.get("Venus Access")!=null?(String)map.get("Venus Access"):""%>"/>

<div class="clear"></div>

<h2>Respiratory System</h2><br>
<div class="clear"></div>
<label>Breath Sound </label> 
<input type="text" readonly="readonly" value="<%=map.get("Breath Sound")!=null?(String)map.get("Breath Sound"):""%>"/>

<label>Adv Sound </label> 
<input type="text" readonly="readonly" value="<%=map.get("Adv Sound")!=null?(String)map.get("Adv Sound"):""%>"/>
<div class="clear"></div>

<h2>Cardio Vascular System</h2><br>

<div class="clear"></div>

<label>S1 </label> 
<input type="text" readonly="readonly" value="<%=map.get("S1")!=null?(String)map.get("S1"):""%>"/>

<label>S2 </label> 
<input type="text" readonly="readonly" value="<%=map.get("S2")!=null?(String)map.get("S2"):""%>"/>

<label>S3 </label> 
<input type="text" readonly="readonly" value="<%=map.get("S3")!=null?(String)map.get("S3"):""%>"/>

<label>S4 </label> 
<input type="text" readonly="readonly" value="<%=map.get("S4")!=null?(String)map.get("S4"):""%>"/>

<label>Remarks </label> 
<input type="text" readonly="readonly" value="<%=map.get("Remarks")!=null?(String)map.get("Remarks"):""%>"/>
<div class="clear"></div>

<label>Abdomen </label> 
<input type="text" readonly="readonly" value="<%=map.get("Abdomen")!=null?(String)map.get("Abdomen"):""%>"/>
<label>Liver </label> 
<input type="text" readonly="readonly" value="<%=map.get("Liver")!=null?(String)map.get("Liver"):""%>"/>
<label>Spleen </label> 
<input type="text" readonly="readonly" value="<%=map.get("Spleen")!=null?(String)map.get("Spleen"):""%>"/>
<div class="clear"></div>

<h2>Others</h2><br>
<div class="clear"></div>

<label>Anaesthetic Technique </label> 
<input type="text" readonly="readonly" value="<%=map.get("Anaesthetic Technique")!=null?(String)map.get("Anaesthetic Technique"):""%>"/>

<label>Patient Type </label> 
<input type="text" readonly="readonly" value="<%=map.get("Patient Type")!=null?(String)map.get("Patient Type"):""%>"/>

<label>ASA Gade </label> 
<input type="text" readonly="readonly" value="<%=map.get("ASA Gade")!=null?(String)map.get("ASA Gade"):""%>"/>

<label>Fit for Surgery </label> 
<input type="text" readonly="readonly" value="<%=map.get("Fit for Surgery")!=null?(String)map.get("Fit for Surgery"):""%>"/>

<label>Blood Component </label> 
<%-- <input type="textarea" readonly="readonly" value="<%=map.get("Blood Component")!=null?(String)map.get("Blood Component"):""%>"/> --%>
<textarea readonly="readonly" ><%=map.get("Blood Component")!=null?(String)map.get("Blood Component"):""%></textarea>

<label>Any Special </label> 
<input type="text" readonly="readonly" value="<%=map.get("Any Special")!=null?(String)map.get("Any Special"):""%>"/>

</div>

</form>
</html>