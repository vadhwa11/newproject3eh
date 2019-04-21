
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.PhInvestigationSampleDetail"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
Map<String,Object>map=new HashMap<String,Object>();
if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
}
List<PhInvestigationSampleDetail>PhInvestigationSampleDetail=new ArrayList<PhInvestigationSampleDetail>();

if(map.get("PhInvestigationSampleDetail")!=null){
	PhInvestigationSampleDetail=(List<PhInvestigationSampleDetail>)map.get("PhInvestigationSampleDetail");
}
String message = "";
if(map.get("message") != null){
	message = (String)map.get("message");
}

%>
<form name="memberData" method="post">
<%if(message != null && !message.equals("")){ %>
<h4><span><%=message %></span></h4>
<%} %>
	<div class="clear"></div>
	<div class="titleBg">
		<h2>Pending For Sample Collection (PH)</h2>
	</div>
	<div class="clear"></div>
<div class="clear"></div><div class="clear"></div><div class="clear"></div><div class="clear"></div>
<table>
  <tr>
    <th>Member</th>
    <th>Name</th>
    <th>Date Of Birth</th>
    <th>Sub Centre/Basic Section</th>
    <th>Investigation</th>
    <th>Referred Hospital</th>
    <th>Select</th>
  </tr>
  
<%
int i=0;
for(PhInvestigationSampleDetail phInvestigationSampleDetail2:PhInvestigationSampleDetail){ %>
<tr>
    <td><%=phInvestigationSampleDetail2.getMemberId() %>
    <input type="hidden" name="memberId<%=i %>" id="memberId<%=i %>" value="<%=phInvestigationSampleDetail2.getMemberId() %>" />
    
    </td>
    <td>
    <%if(phInvestigationSampleDetail2.getName()!=null){ %>
    <%=phInvestigationSampleDetail2.getName()  %>
    <%}else{ %>
    -
    <%} %>
    </td>
     <td>
    <%if(phInvestigationSampleDetail2.getDateOfBirth()!=null){ %>
    <%=HMSUtil.convertDateToStringTypeDateOnly(phInvestigationSampleDetail2.getDateOfBirth())%>
    <%}else{ %>
    -
    <%} %>
    </td>
    <td>
    <%if(phInvestigationSampleDetail2.getSubCentre()!=null){ %>
    <%=phInvestigationSampleDetail2.getSubCentre().getHospitalName() %>
    <%}else{ %>
    -
    <%} %>
    </td>
    
    <td>
    <%=phInvestigationSampleDetail2.getInvestigation().getInvestigationName() %></td>
    <td><%=phInvestigationSampleDetail2.getReferHospital().getHospitalName() %>
    <input type="hidden" name="smearNo<%=i %>" id="smearNo<%=i %>" value="<%=phInvestigationSampleDetail2.getSmearNo()%>" />
    <input type="hidden" name="phInvestigationId<%=i %>" id="phInvestigationId<%=i %>" value="<%=phInvestigationSampleDetail2.getId()%>" />
    <input type="hidden" name="chargeCodeId<%=i %>" id="chargeCodeId<%=i %>" value="<%=phInvestigationSampleDetail2.getInvestigation().getChargeCode().getId()%>" />
    <input type="hidden" name="mainChargeCodeId<%=i %>" id="mainChargeCodeId<%=i %>" value="<%=phInvestigationSampleDetail2.getInvestigation().getMainChargecode().getId()%>" />
    <input type="hidden" name="subChargeCodeId<%=i %>" id="subChargeCodeId<%=i %>" value="<%=phInvestigationSampleDetail2.getInvestigation().getSubChargecode().getId()%>" />
     <input type="hidden" name="investigationId<%=i %>" id="investigationId<%=i %>" value="<%=phInvestigationSampleDetail2.getInvestigation().getId()%>" />
     <input type="hidden" name="containerId<%=i %>" id="containerId<%=i %>" value="<%=phInvestigationSampleDetail2.getInvestigation().getCollection() != null?phInvestigationSampleDetail2.getInvestigation().getCollection().getId():""%>" />
     <input type="hidden" name="sampleId<%=i %>" id="sampleId<%=i %>" value="<%=phInvestigationSampleDetail2.getInvestigation().getSample() != null?phInvestigationSampleDetail2.getInvestigation().getSample().getId():""%>" />
    </td>
  
    <td>
    <input type="hidden" name="memBerStatus<%=i %>" id="MemBerStatusId<%=i %>" value="n"  />
    <input type="hidden" name="referHospital<%=i %>" id="referHospitalId" value="<%=phInvestigationSampleDetail2.getReferHospital().getId() %>" />
    <input type="checkbox" name="checkMemBer<%=i %>" id="checkMemBer<%=i %>" value="<%=phInvestigationSampleDetail2.getMemberId() %>" onclick="checkData(<%=i %>);" /></td>
     </tr> <%i++;} %>

</table>
<input	type="hidden" name="hdb" id="hdb"	value="<%=i %>"  />
<div class="clear"> </div>
<input type="button" value="Send To Sample Validation " onclick="sumitData();" />
<div class="clear"> </div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
<script>
function sumitData(){
//	alert("in data");
	submitForm('memberData','lab?method=sendForSampleValidatePh');
}
function checkData(i){
	if(document.getElementById('checkMemBer'+i).checked==true){
		document.getElementById('MemBerStatusId'+i).value="y";
	} else if(document.getElementById('checkMemBer'+i).checked==false){
		document.getElementById('MemBerStatusId'+i).value="n";
	}
}
</script>
