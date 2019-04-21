<%@page import="java.net.URL"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>

<%@page import="jkt.hms.masters.business.DgSubMasInvestigation"%>
<%@page import="jkt.hms.masters.business.LabMachineXt2000iDetails"%>



<%
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
//int rowVal=(Integer)map.get("rowVal");
List<DgSubMasInvestigation> subInvestigationlist = new ArrayList<DgSubMasInvestigation>();
if(map.get("subInvestigationlist") != null)
{
	subInvestigationlist = (List<DgSubMasInvestigation>)map.get("subInvestigationlist");

}
List<DgMasInvestigation> invList = new ArrayList<DgMasInvestigation>();
if(map.get("invList") != null)
{
	invList = (List<DgMasInvestigation>)map.get("invList");
}
String machineName="";
if(map.get("machineName")!=null){
	machineName=(String)map.get("machineName");
	
}

//added by govind 02-06-2017
List<LabMachineXt2000iDetails> labMachine360List = new ArrayList<LabMachineXt2000iDetails>();
if(map.get("labMachine360List")!=null){
	labMachine360List=(List<LabMachineXt2000iDetails>)map.get("labMachine360List");
	
}
List<DgSubMasInvestigation> subInvestList = new ArrayList<DgSubMasInvestigation>();
if(map.get("subInvestList") != null)
{
	subInvestList = (List<DgSubMasInvestigation>)map.get("subInvestList");
}
System.out.println("machineName "+machineName+"labMachine360List jsp "+labMachine360List.size());

//added by govind 16-08-2017 
Properties properties = new Properties();
URL resourcePath = Thread.currentThread().getContextClassLoader()
		.getResource("labParameter.properties");
try {
	properties.load(resourcePath.openStream());
} catch (Exception e) {
	e.printStackTrace();
}
//String parName = properties.getProperty("parameterEM360");
String parName = properties.getProperty(machineName);
String par[]=parName.split(",");
List<String> paraList=new ArrayList<String>();
for(int i=0;i<par.length;i++){
	paraList.add(par[i]);
}
Collections.sort(paraList);
//added by govind 16-08-2017 end
%><%--
<div id="testDiv">
<div  class="tableForTab">

<table width="100%" colspan="7" id="chargeDetails" cellpadding="0"
	cellspacing="0">

	<tr>
		<th width="2%">Analyzer Parameter </th>
		<th>Investigation Name</th>
		<th>Sub Investigation Name</th>
	</tr>
	<%if(machineName.equals("EM360")){
		if(labMachine360List.size()>0){
			for(LabMachineXt2000iDetails lab360:labMachine360List){
		%>
	<tr>
		<td width="2%"><%=lab360.getParameterName()%> </td>
		<td>		
		<%for (DgMasInvestigation dgMas : invList)
			{	
			
					if(dgMas.getId().equals(lab360.getInvestigationId()))
					{
       %>
	                 <%=dgMas.getInvestigationName()%>
			<%       break;
					}
			}
		%>
		</td>
		<td><%=lab360.getSubInvestigationId()!=null?lab360.getSubInvestigationId():""%> </td>
	</tr>
	<%} } } %>
	
	
	<%
	int inc3 = 0;
	for(int i=0;i<23;i++)
	{
	%>
    <tr>
    <td>
    <%if(machineName.equalsIgnoreCase("xpandPlus")){ %>
    <select  id="parameterName<%=inc3%>" name="<%=PARAMETER_NAME %>"  >
    <option value="">Select</option>
	 <option value="GLUC">GLUC </option>
	 <option value="BUN">BUN</option>
	 <option value="CREA">CREA</option>
	 <option value="URCA">URCA</option>
	 <option value="CHOL">CHOL</option>
	 <option value="TGL">TGL</option>
	 <option value="AHDL">AHDL</option>
	 <option value="ALDL">ALDL</option>
	 <option value="TBI">TBI</option>
	 <option value="DBI">DBI</option>
	 <option value="AST">AST</option>
	 <option value="ALT">ALT</option>
	 <option value="ALP">ALP</option>
	 <option value="ALB">ALB</option>
	 <option value="A/G">A/G</option>
	 <option value="TP">TP</option>
	 <option value="GLOB">GLOB</option>
	 <option value="CA">CA</option>
	 <option value="AMG">AMG</option>
	 <option value="MBI">MBI</option>
	 <option value="CKI">CKI</option>
	 <option value="PHCE">PHCE</option> 
	 <option value="RCRP">RCRP</option>
	 </select>

	 <%}else if(machineName.equalsIgnoreCase("kx-21")){ %>
 <select  id="parameterName<%=inc3%>" name="<%=PARAMETER_NAME %>"  > 
	 <option value="">Select</option> 
     <option value="HB">HB</option>
	 <option value="TLC">TLC</option>
	 <option value="RBC">RBC</option>
	 <option value="PCV">PCV</option>
	 <option value="MCV">MCV</option> 
	 <option value="MCH">MCH</option>
	 <option value="MCHC">MCHC</option>
	 <option value="PLT">PLT</option>
	 <option value="DIFF COUNT">DIFF COUNT</option>
	 <option value="POLYS">POLYS</option>
	 <option value="LYMPHO">LYMPHO</option>
	 <option value="EOSIN">EOSIN</option>
	 <option value="MONO">MONO</option>
	 <option value="BASO">BASO</option>
	 <option value="RDW">RDW</option>  
	 <option value="PDW">PDW</option>
	 <option value="MPV">MPV</option>
	 <option value="P-LCR">P-LCR</option>
	 <option value="MXD">MXD</option> 
	 </select>
	 <%}else if(machineName.equalsIgnoreCase("XL300") ){%>
	 
    <select  id="parameterName<%=inc3%>" name="<%=PARAMETER_NAME %>"  >
    <option value="">Select</option>
	 <option value="ALB">ALB </option>
	 <option value="ALP">ALP</option>
	 <option value="AMY">AMY</option>
	 <option value="BCHO">BCHO</option>
	 <option value="BID">BID</option>
	 <option value="BIT">BIT</option>
	 <option value="CAL">CAL</option>
	 <option value="CHO">CHO</option>
	 <option value="CK">CK</option>
	 <option value="CKMB">CKMB</option>
	 <option value="CRE">CRE</option>
	 <option value="ETRI">ETRI</option>
	 <option value="GLU">GLU</option>
	 <option value="GOT">GOT</option>
	 <option value="GPT">GPT</option>
	 <option value="HDL">HDL</option>
	 <option value="LDL">LDL</option>
	 <option value="MPR">MPR</option>
	 <option value="PRO">PRO</option>
	 <option value="SI">SI</option>
	 <option value="TRI">TRI</option>
	 <option value="UA">UA</option> 
	 <option value="URE">URE</option>
	 </select>
	
	 <%}else if(machineName.equalsIgnoreCase("xpandPlus,XL300")){ %>
	 <select  id="parameterName<%=inc3%>" name="<%=PARAMETER_NAME %>"  >
    <option value="">Select</option>
	 <option value="ALB">ALB </option>
	 <option value="ALP">ALP</option>
	 <option value="AMY">AMY</option>
	 <option value="BCHO">BCHO</option>
	 <option value="BID">BID</option>
	 <option value="BIT">BIT</option>
	 <option value="CAL">CAL</option>
	 <option value="CHO">CHO</option>
	 <option value="CK">CK</option>
	 <option value="CKMB">CKMB</option>
	 <option value="CRE">CRE</option>
	 <option value="ETRI">ETRI</option>
	 <option value="GLU">GLU</option>
	 <option value="GOT">GOT</option>
	 <option value="GPT">GPT</option>
	 <option value="HDL">HDL</option>
	 <option value="LDL">LDL</option>
	 <option value="MPR">MPR</option>
	 <option value="PRO">PRO</option>
	 <option value="SI">SI</option>
	 <option value="TRI">TRI</option>
	 <option value="UA">UA</option> 
	 <option value="URE">URE</option>
	<option value="GLUC">GLUC </option>
	 <option value="BUN">BUN</option>
	 <option value="CREA">CREA</option>
	 <option value="URCA">URCA</option>
	 <option value="CHOL">CHOL</option>
	 <option value="TGL">TGL</option>
	 <option value="AHDL">AHDL</option>
	 <option value="ALDL">ALDL</option>
	 <option value="TBI">TBI</option>
	 <option value="DBI">DBI</option>
	 <option value="AST">AST</option>
	 <option value="ALT">ALT</option>
	 <option value="ALP">ALP</option>
	 <option value="ALB">ALB</option>
	 <option value="A/G">A/G</option>
	 <option value="TP">TP</option>
	 <option value="GLOB">GLOB</option>
	 <option value="CA">CA</option>
	 <option value="AMG">AMG</option>
	 <option value="MBI">MBI</option>
	 <option value="CKI">CKI</option>
	 <option value="PHCE">PHCE</option> 
	 <option value="RCRP">RCRP</option> 
	 </select>
	 
	 <%}else if(machineName.equalsIgnoreCase("EM360")){ %>
	 <select  id="parameterName<%=inc3%>" name="<%=PARAMETER_NAME %>"  onchange="ajaxFunctionForLabParameterName(machineParameter,<%=inc3%>);">
    <option value="">Select</option>
	 <option value="ALB">ALB</option>
	 <option value="ALP">ALP</option>
	 <option value="BID">BID</option>
	 <option value="CRE">CRE</option>
	 <option value="CHO">CHO</option>
	 <option value="TRIG">TRIG</option>
	 <option value="GPTHL">GPTHL</option>
	 <option value="GOTHL">GOTHL</option>
	 <option value="BIT">BIT</option> 
	 <option value="HDLC">HDLC</option>
	 <option value="UREA">UREA</option>
	 <option value="GLU">GLU</option>
	 <option value="UA">UA</option> 
	 <option value="GLOB">GLOB</option>
	 <option value="PRO">PRO</option>
	 <%--added by govind 02-06-2017 --%>
	 <%--  <option value="HDLC">HDLC</option>
	  <option value="CAA">CAA</option>
	  <option value="AMY">AMY</option>
	  <option value="GLUPP">GLUPP</option>
	  <option value="CLO">CLO</option>
	  <option value="MBR">MBR</option>
	  <option value="RBS">RBS</option>
	  <option value="GCT">GCT</option>
	  <option value="FBS">FBS</option>
	  <option value="CO2">CO2</option>
	  <option value="GLUF">GLUF</option>
	  <option value="CKN">CKN</option>
	    <option value="LDH">LDH</option>
	  <option value="LDL">LDL</option>
	  <option value="PHO">PHO</option>
	  <option value="GGT">GGT</option>
	  <option value="CKMB">CKMB</option>
	  <option value="GLUR">GLUR</option>
	  <option value="MG">MG</option>
	  <option value="PPBS">PPBS</option>
	  <option value="FBS">GTT</option>
	  <option value="LFT">LFT</option>
	  <option value="RFT">RFT</option>
	  <%--added by govind 02-06-2017 end --%>
 <%--	 </select>
	 <%} %>
<td><select id="investigationIdId<%=inc3%>" name="<%=INVESTIGATION_NAME %>" validate="investigationName,string,no"  tabindex=1
onchange="ajaxFunctionForInvestigationName(machineParameter,<%=inc3%>);">
			<option value="">Select</option>
		 	<%

			for (DgMasInvestigation dgMas : invList)
			{
				if(dgMas.getInvestigationName() != null)
				{
    %>
			<option value="<%=dgMas.getId()%>" ><%=dgMas.getInvestigationName()%></option>
			<%
					}

			}
		%>
		</select>

		<input type="hidden" name="investigationType" id="investigationType<%=inc3%>" value=""/>
		<input type="hidden" name="investigationId" value="" id="investigationId<%=inc3%>"/>
		</td>

		<td>
		<div id="subInv<%=inc3%>" align="center"><select  id="subInvestigationName<%=inc3%>" name="<%=SUB_INVESTIGATION_NAME %>"
			validate="subInvestigationName,string,no"  tabindex=1  >
			<option value=""></option>
			</select>
			</div></td>
    </tr>
    <%
    inc3++;
	} %>

	</table>
    </div></div>--%>
    
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">


<%--added by govind for Test Entry 360 28-07-2017  --%>	
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
		if(labMachine360List.size()>0 )
		 {
			String strForCode = (String)map.get("talukCode");
			String strForCodeDescription = (String)map.get("talukName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h4><a href="generalMaster?method=showTalukJsp">Show All Records </a></h4> <%
			}
		 }
	 if(labMachine360List.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="generalMaster?method=showTalukJsp">Show All Records</a></h4> <%
     }
%>
	
<script type="text/javascript">

	formFields = [
	 			[0, "<%= COMMON_ID%>", "id"], [1,"parameterName0"], [2,"investigationIdId0"], [3,"subInvestigationId0"],[4,"investigationname"],[5,"subInvestigationName"],[6,"status"]];
	 
		 statusTd = 6;
</script></div>

<form name="parameterTest" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden"name="<%= POJO_NAME %>" value="MasTaluk"/>
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="TalukName"/>
<input	type="hidden" name="title" value="taluk"/>
<input type="hidden" name="<%=JSP_NAME %>" value="taluk"/>
<input type="hidden" name="pojoPropertyCode" value="TalukCode"/>
	
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<div class="Taluk">
<label><span>*</span> Paramter Name </label> 
<select  id="parameterName0" name="<%=PARAMETER_NAME %>"  onchange="ajaxFunctionForLabParameterName(machineParameter,0);" 
validate="Parameter Name,string,yes"
>
     <option value="0">Select</option>
     <%if(paraList.size()>0){
     for(String paramName:paraList){ %>
      <option value=<%=paramName %>><%=paramName %></option>
      <%}}%>
	<%-- //commented by govind 16-08-2017 
	 <option value="ALP">ALP</option>
	 <option value="AMY">AMY</option>
	 <option value="BIT">BIT</option>
	 <option value="BID">BID</option>
	 <option value="CRE">CRE</option>
	 <option value="CHO">CHO</option>
	 <option value="CLO">CLO</option>
	 <option value="CO2">CO2</option>
	 <option value="CAA">CAA</option>
	 <option value="CKN">CKN</option>
	 <option value="CKMB">CKMB</option>
	 <option value="FBS">FBS</option>
	 <option value="GPTHL">GPTHL</option>
	 <option value="GOTHL">GOTHL</option>
	 <option value="GLU">GLU</option>
	 <option value="GLUPP">GLUPP</option>
	 <option value="GLOB">GLOB</option>
	 <option value="GCT">GCT</option>
	 <option value="GGT">GGT</option>
	 <option value="GLUF">GLUF</option>
	 <option value="GLUR">GLUR</option>
	 <option value="HDLC">HDLC</option>
	 <option value="LDH">LDH</option>
	 <option value="LDL">LDL</option>
	 <option value="LDLC">LDLC</option>
	 <option value="LFT">LFT</option>
	 <option value="MBR">MBR</option>
	 <option value="MG">MG</option>
	 <option value="PRO">PRO</option>
	 <option value="PHO">PHO</option>
	 <option value="PPBS">PPBS</option>
	 <option value="RBS">RBS</option>	  
	 <option value="RFT">RFT</option>
	 <option value="TRIG">TRIG</option>
	 <option value="VLDL">VLDL</option>
	 <option value="UA">UA</option>
	 <option value="UREA">UREA</option>
	  <%--added by govind 02-06-2017 end --%>
	 </select> 
<label><span>*</span> Investigation Name</label> 
<select id="investigationIdId0" name="<%=INVESTIGATION_NAME %>" validate="investigationName,int,yes"  tabindex=1
onchange="ajaxFunctionForRecordCheck(machineParameter,this.value,0);">
			<option value="0">Select</option>
		 	<%

			for (DgMasInvestigation dgMas : invList)
			{
				if(dgMas.getInvestigationName() != null)
				{
    %>
			<option value="<%=dgMas.getId()%>" ><%=dgMas.getInvestigationName()%></option>
			<%
					}

			}
		%>
		</select>
<label><span>*</span>Sub Investigation Name</label> 
<select  id="subInvestigationName0" name="<%=SUB_INVESTIGATION_NAME %>"
			validate="subInvestigationName,string,yes"  tabindex=1 onchange="ajaxFunctionForSubInvestigationName(machineParameter,0);" >
<option value="0">Select</option>
		 	<%
			for (DgSubMasInvestigation sub : subInvestList)
			{
				
    %>
			<option value="<%=sub.getId()%>" ><%=sub.getSubInvestigationName()%>- [<%=sub.getInvestigation().getInvestigationName()%>]</option>
			<%

			}
		%>

</select>
<input type="hidden" name="investigationType" id="investigationType0" value=""/>
		<input type="hidden" name="investigationId" value="" id="investigationId0"/>
<%-- 		<input type="hidden" name="<%=MACHINE_NAME%>" value="EM360" /> --%>
 		<input type="hidden" name="<%=MACHINE_NAME%>" value="<%=machineName %>" /> 
 		<input type="hidden" id="machineParamId" name="machineParamId" value="" /> 
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('parameterTest','lab?method=addTestParameter&flag=add&Type=<%=machineName %>');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitFormForButton('parameterTest','lab?method=addTestParameter&flag=update&Type=<%=machineName %>')"
	style="display: none;" accesskey="u" tabindex=1 /> <input
	type="button" name="Delete" id="deletebutton" value="Change Status"
	class="button"
	onClick="submitFormForButton('parameterTest','lab?method=addTestParameter&flag=deActivate&Type=<%=machineName %>')"
	style="display: none;" accesskey="d" tabindex=1 /> 
	<input type="reset"
	name="Reset" id="reset" value="Reset" class="buttonHighlight"
	onClick="" accesskey="r" /> <input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" />

<div class="clear"></div>
</div>
</div>
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Parameter Name"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "parameterName0"

data_header[1] = new Array;
data_header[1][0] = "Investigation Id"
data_header[1][1] = "hide";
data_header[1][2] = "40%";
data_header[1][3] = "investigationIdId0";

data_header[2] = new Array;
data_header[2][0] = "Sub Investigation Id"
data_header[2][1] = "hide";
data_header[2][2] = "40%";
data_header[2][3] = "subInvestigationId0";

data_header[3] = new Array;
data_header[3][0] = "Investigation Name"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "investigationName";

data_header[4] = new Array;
data_header[4][0] = "Sub Investigation Name"
data_header[4][1] = "data";
data_header[4][2] = "40%";
data_header[4][3] = "subInvestigationName";

 data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "40%";
data_header[5][3] = "status";
 
data_arr = new Array();

<%//if(machineName.equals("EM360")){
	int  counter=0;
	if(labMachine360List.size()>0){
		for(LabMachineXt2000iDetails lab360:labMachine360List){
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= lab360.getId()%>
data_arr[<%= counter%>][1] = "<%=lab360.getParameterName()%>"
<%if(lab360.getInvestigationId()!=null){
	if(lab360.getInvestigationId()>0){
%>
data_arr[<%= counter%>][2] = "<%= lab360.getInvestigationId()%>"
	<%for (DgMasInvestigation sub : invList)
	{
		if(lab360.getInvestigationId().equals(sub.getId())){
	%>
data_arr[<%= counter%>][4] = "<%= sub.getInvestigationName()%>"
<%}}
}}else{%>
data_arr[<%= counter%>][2] = "<%= 0%>"
data_arr[<%= counter%>][4] = "<%= ""%>"
<%}%>
<%if(lab360.getSubInvestigationId()!=null){
	if(lab360.getSubInvestigationId()>0){
%>
data_arr[<%= counter%>][3] = "<%= lab360.getSubInvestigationId()%>"
	<%for (DgSubMasInvestigation sub : subInvestList)
	{
		if(lab360.getSubInvestigationId().equals(sub.getId())){
	%>
data_arr[<%= counter%>][5] = "<%= sub.getSubInvestigationName()%>- [<%=sub.getInvestigation().getInvestigationName()%>]"
<%}}
}}else{%>
data_arr[<%= counter%>][3] = "<%= 0%>"
data_arr[<%= counter%>][5] = "<%= ""%>"
<%}%>
data_arr[<%= counter%>][6] = "<%= lab360.getStatus()!=null?lab360.getStatus():""%>"

<%
		     counter++;
		}
	}
//}
%>
 
formName = "parameterTest"

nonEditable = ['<%=CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);
intializeHover('searchresulttable', 'TR', ' tableover');		
</script>

<%--added by govind for Test Entry 360 28-07-2017 end --%>	