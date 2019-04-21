<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientAdmissionSearch.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
--%>
<%@page import="jkt.hms.masters.business.HospitalDoctorUnitT"%>
<%@page import="jkt.hms.masters.business.OtMasUnitDay"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasBed"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<%
		Map<String, Object> map = new HashMap<String, Object>();

        List<MasBed> beds  = new ArrayList<MasBed>();
        List<MasBed> availableedList  = new ArrayList<MasBed>();
        int departmentId=0;
        MasDepartment department=null;
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("bedList") != null){
			beds= (List<MasBed>)map.get("bedList");
		}
		
		if(map.get("availableedList") != null){
			availableedList= (List<MasBed>)map.get("availableedList");
		}
		
		if(map.get("department") != null){
			department= (MasDepartment)map.get("department");
		}
	
	%>
	
	<% Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap= (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");%>
	
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<div class="titleBg">
<h2>Create Virtual Bed</h2>
</div>
<div class="clear"></div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="Block">
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<%if(availableedList.size()==0){ %>
<div>
<form action="#" name="createVirtual" id="createVirtual" method="post" >
<label>Department</label>
<label class="valueAuto">

<%
if(department!=null)
{
	%>
	<%=department.getDepartmentName() %>
	<input type="hidden" name="deptId" value="<%=department.getId() %>" validate="deptId,int,no"/>
	<%
}
else
{
	%>
	<input type="hidden" name="deptId" validate="deptId,int,no"/>
	<%
	}
%>
</label>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<label>After Bed NO.<span>*</span> </label>
<label class="valueAuto">
<select name="<%=BED_ID%>" id="<%=BED_ID%>" validate="Bed No,metachar,yes" onchange="displayUnit(this.value)">
<option value="">select</option>
<%
for(MasBed bed:beds)
{
	%>
	<option value="<%=bed.getId()%>"><%=bed.getBedNo()%></option>
	<%
}
%>
</select>
</label>
<label>Unit</label>
<input type="text" name="unit" id="unitId" readonly="readonly"/>
<label>Unit Head</label>
<input type="text" name="unitHead" id="unitHeadId" readonly="readonly"/>
<div class="clear"></div>


<div class="paddingTop25"></div>
<div class="clear"></div>
<div class="clear"></div>

<input type="button" name="add" id="addbutton" value="Add"	class="button" onclick="javascript:submitForm('createVirtual','ipd?method=submitCreateVirtualBed')" /> 
<input type="button" class="button" value="Reset" id="reset" />
<div class="clear"></div>



<%}else{ %>
<span>Physical Beds are available.You can not create virtual bed</span>
<% }%>
<div class="clear"></div>
<input type="reset" class="button" name="reset" value="Back" onclick="submitFormForButton('createVirtual','ipd?method=showPatientListNurseJsp');"/>
<div class="clear"></div>
<div class="paddingTop15"></div>
 
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
</form>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
</div>
<div class="clear"></div>
<div class="paddingTop40"></div>

<script type="text/javascript">
function displayUnit(bedId){
	<%
		for(MasBed bed : beds){
			Set<OtMasUnitDay> unitSet = bed.getOtMasUnitDays()!=null?bed.getOtMasUnitDays():new HashSet<OtMasUnitDay>();
			for(OtMasUnitDay masUnitDays: unitSet){
				Set<HospitalDoctorUnitT> docSet = masUnitDays.getUnitM()!=null?masUnitDays.getUnitM().getHospitalDoctorUnitTs():new HashSet<HospitalDoctorUnitT>();
				String unitHeadName = "";
				for(HospitalDoctorUnitT docT : docSet){
					if(docT.getHeadFleg()!=null && docT.getHeadFleg().equalsIgnoreCase("y")){
						unitHeadName = docT.getEmployee().getEmployeeName();
					}
				}
	%>
	if(bedId == '<%=masUnitDays.getMasBed().getId()%>')
	{
		document.getElementById('unitId').value = '<%=masUnitDays.getUnitM().getUnitCode()%>'
			document.getElementById('unitHeadId').value = '<%=unitHeadName%>'
		}	
	
	<%}
	}%>
	
}
</script>