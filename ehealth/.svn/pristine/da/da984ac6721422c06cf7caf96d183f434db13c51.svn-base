<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<script src="/hms/jsp/js/surveyTarget.js" type="text/javascript"></script>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasHospital> chcList = new ArrayList<MasHospital>();
if(map.get("chcList") !=null){
	chcList=(List<MasHospital>)map.get("chcList");
}

List<MasHospital> phcList = new ArrayList<MasHospital>();
if(map.get("phcList") !=null){
	phcList=(List<MasHospital>)map.get("phcList");
}

List<MasHospital> ppunit = new ArrayList<MasHospital>();
if(map.get("ppunit") !=null){
	ppunit=(List<MasHospital>)map.get("ppunit");
}
%>
 <div id="tDiv">
<%	if(chcList.size() >0){%>
<label><span>*</span> CHC</label>
<select name="chcphc" validate="CHC,int,yes" id="chcphc" onblur="submitProtoAjaxWithDivName('dashboardTarget','/hms/hms/pubHealth?method=getBasicCenterList&chcphc='+this.value,'testDiv');" >

				<option value="0">ALL</option>
				 <%
				 for (MasHospital dis : chcList) {
				  %>
				  <option value="<%=dis.getId ()%>"><%=dis.getHospitalName()%></option>
				  <%
				  	 	}
				   %>

</select>
<%	} else if(phcList.size() >0){%>
<label><span>*</span> PHC</label>
<select name="chcphc" id="chcphc" validate="PHC,int,yes" onblur="submitProtoAjaxWithDivName('dashboardTarget','/hms/hms/pubHealth?method=getBasicCenterList&chcphc='+this.value,'testDiv');" >

				<option value="0">ALL</option>
				 <%
				 for (MasHospital dis : phcList) {
				  %>
				  <option value="<%=dis.getId ()%>"><%=dis.getHospitalName()%></option>
				  <%
				  	 	}
				   %>

</select><%}else if(ppunit.size()>0){ %>
<label><span>*</span> PPUnit</label>
<select name="chcphc" id="chcphc" validate="PPUnit,int,yes" onblur="submitProtoAjaxWithDivName('dashboardTarget','/hms/hms/pubHealth?method=getBasicCenterList&chcphc='+this.value,'testDiv');" >

				<option value="0">ALL</option>
				 <%
				 for (MasHospital dis : ppunit) {
				  %>
				  <option value="<%=dis.getId ()%>"><%=dis.getHospitalName()%></option>
				  <%
				  	 	}
				   %>

</select>
<%} else{ %>
<label><span>*</span> PHC</label>
<select name="chcphc" validate="PHC,int,yes" id="chcphc">
				<option value="0">ALL</option>
</select>
<%} %>
<div id="testDiv">
<label><span>*</span> Institute Type </label>
<select name="instituteType" validate="Institute Type,int,yes" id="instituteType" class="" onclick="enableRadio();">
				<option value="0">ALL</option>
				<option value="1">Sub-Center</option>
				<option value="2">Basic-Section</option>
			</select>

<label><span>*</span>BasicSection/Subcenter </label>
    <select name="base" validate="BasicSection/Subcenter,int,yes" id="base" class="">
             	<option value="0">ALL</option>
	</select>

</div>

</div>
