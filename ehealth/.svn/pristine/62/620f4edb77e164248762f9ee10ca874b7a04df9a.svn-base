<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * DepartmentTaskMap.jsp  
 * Purpose of the JSP -  This is for Rating Details.
 * @author  Vishal
 * Create Date: 15th July,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.1 
--%>
<%@page import="jkt.hms.masters.business.MasHospitalwiseChargecode"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasInstituteDepartment"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.*" %>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hrms.masters.business.MstrDeptTaskMap"%>
<%@page import="jkt.hrms.masters.business.MstrTask"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<%@page import="jkt.hms.masters.business.MasMainChargecode"%>

<%List<MasDepartment> al1 = new ArrayList<MasDepartment>();
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<MasHospital> instituteList = new ArrayList<MasHospital>();
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasMainChargecode> mainChargeList = new ArrayList<MasMainChargecode>();
	List<MasSubChargecode> subChargeList = new ArrayList<MasSubChargecode>();
	List<MasChargeCode> chargeList = new ArrayList<MasChargeCode>();
	List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
	List<MasHospitalwiseChargecode> masHospitalwiseChargecodeList = new ArrayList<MasHospitalwiseChargecode>();
	List<MasHospitalwiseChargecode> blockedchargeCodeList = new ArrayList<MasHospitalwiseChargecode>();
	
	List<MasHospital> hospitalNameList = new ArrayList<MasHospital>();
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		  // out.println(message);
		  }
	
	

	 if(map.get("hospitalNameList")!=null){
		 hospitalNameList=(List<MasHospital>)map.get("hospitalNameList");
		}
	 if(map.get("mainChargeList")!=null){
		 mainChargeList=(List<MasMainChargecode>)map.get("mainChargeList");
		}
	 if(map.get("subChargeList")!=null){
		 subChargeList=(List<MasSubChargecode>)map.get("subChargeList");
		}
	 if(map.get("chargeList")!=null){
		 chargeList=(List<MasChargeCode>)map.get("chargeList");
		}
	
	 if(map.get("mhospitalTypetList")!=null){
		 mhospitalTypetList=(List<MasHospitalType>)map.get("mhospitalTypetList");
		}
	 if(map.get("masHospitalwiseChargecodeList")!=null){
		 masHospitalwiseChargecodeList=(List<MasHospitalwiseChargecode>)map.get("masHospitalwiseChargecodeList");
		}
	 if(map.get("blockedchargeCodeList")!=null){
		 blockedchargeCodeList=(List<MasHospitalwiseChargecode>)map.get("blockedchargeCodeList");
		}	 
	 
	 String hospitalName="";
	 
	 
	 if(session.getAttribute("hospitalName")!=null){
		 hospitalName=	""+ session.getAttribute("hospitalName");
	 }
	String deptName="";
	 if(session.getAttribute("deptName")!=null){
		 deptName=	""+ session.getAttribute("deptName");
	 }
	 String message="";
	 if(map.get("message")!=null){
		 message=(String)map.get("message");
	 }
%>



<div class="titleBg"> 
<h2>Institute Wise Services Block/UnBlock</h2>
</div>
<%if(message!=null && !message.equals("")){ %>
<h4><%=message %></h4>
<%} %>
<form name="instituteWiseServices" method="post" action="">
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>

<div class="Block">
<script type="text/javascript">
var chargeArray= new Array();
<%
int i=0;
for(MasChargeCode chargeCode:chargeList)
{
%>
chargeArray[<%=i%>]= new Array();
chargeArray[<%=i%>][0] = "<%=chargeCode.getId()%>";
chargeArray[<%=i%>][1] = "<%=chargeCode.getChargeCodeName()%>";
chargeArray[<%=i%>][2] = "<%=chargeCode.getSubChargecode().getId()%>";
chargeArray[<%=i%>][3] = "<%=chargeCode.getMainChargecode().getId()%>";
<%
i++;} %>
</script>

<script type="text/javascript">
var subChargeArray= new Array();
<%
 i=0;
for(MasSubChargecode subChargecode:subChargeList)
{
%>
subChargeArray[<%=i%>]= new Array();
subChargeArray[<%=i%>][0] = "<%=subChargecode.getId()%>";
subChargeArray[<%=i%>][1] = "<%=subChargecode.getSubChargecodeName()%>";
subChargeArray[<%=i%>][2] = "<%=subChargecode.getMainChargecode().getId()%>";
<%
i++;
} %>
</script>
<label>Hospital Name</label>
<label class="value" style="width:145px;"><%=hospitalName %></label>
	
<label class="medium"> Main Service Head</label> <label class="value"><%=deptName %></label>
<div class="clear"></div>
 <label>Block</label> 
<input type="radio" name="block" id="blockId" value=""  onclick="checkForReason();" validate="Block,string,yes" />
<label>Investigation</label>
<select name="invName" id="investigationId" multiple="multiple" class="multiple" size="10">
<option value="0">Select</option>
<%
 for(MasHospitalwiseChargecode chargecode:masHospitalwiseChargecodeList)
 {
 %>
     <option value="<%=chargecode.getChargeCode().getId()%>" ><%=chargecode.getChargeCode().getChargeCodeName()+"["+chargecode.getChargeCode().getChargeCodeCode()+"]"%></option>
 <% } %>
 
 </select>
<div id="reasonToBlockId" style="display: none;">
<label>Reason To Block</label>
<textarea name="reasonToBlock" id="reasonToBlock">
</textarea>
</div> 

<div class="clear"></div>
<label>Un-Block</label>
<input type="radio" name="block" id="blockId2" value="" onclick="checkForReason();" validate="Block,string,yes" />
<label>Blocked Investigation</label>
<select name="invName" id="investigationId" multiple="multiple" class="multiple" size="10" onclick="getReasonForBlock(this.value);">
<option value="0">Select</option>
<%
 for(MasHospitalwiseChargecode chargecode:blockedchargeCodeList)
 {
 %>
     <option value="<%=chargecode.getChargeCode().getId()%>" ><%=chargecode.getChargeCode().getChargeCodeName()+"["+chargecode.getChargeCode().getChargeCodeCode()+"]"%></option>
 <% } %>
 
 </select>
 <div id="reasonForBlockedId"></div>
<!-- <div class="clear"></div> -->

<%-- <label><span>*</span> Sub Service Head </label> <select
								id="subChargeName" name="<%=SUB_CHARGECODE_ID %>"
								validate="Sub Service Head ,string,NO" onChange="onSelectSubCharge(this.value)" tabindex="2">
								<option value="">Select</option>
								<%
					for (MasSubChargecode subChargecode : subChargeList){
						
				%>
								<option value="<%=subChargecode.getId ()%>"><%=subChargecode.getSubChargecodeName()%></option>
								<%}%>
							</select> --%>
	
<div id="tempId"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<!-- <label >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Available Charges</label>
<label class="white"> </label>
<label class="white"> </label> -->

<%-- <label > To Be Assigned Service</label>
 <div class="clear"></div>
 <div id="inst">
<select name="mainGroupId" id="mainGroupId"  multiple="multiple" size="10" style="height:150px;" class="listBig">
    <%for(MasSubChargecode mh : subChargeList){ %>
     <option value="<%=md.getId()%>"><%=md.getDepartmentName()%></option>
     <option value="<%=mh.getId()%>"><%=mh.getSubChargecodeCode()%></option>
     <%} %>
</select>
</div>
<div class="placeHolderForAddLeftnRight">
<input type="button" name="Add" class="addRight" value="" onclick="copySelectedOptions();" />

<input type="button" name="send" class="addLeft"  value="" onclick="removeSelectedOptions();"/>
</div>

<select name="tempId" id="tempId" style="height:150px;"   multiple="multiple" size="10" class="listBig">
 	 
 <%-- <%
 for(MasHospitalwiseChargecode chargecode:masHospitalwiseChargecodeList)
 {
 %>
     <option value="<%=chargecode.getChargeCode().getId()%>" selected="selected"><%=chargecode.getChargeCode().getChargeCodeName()%></option>
 <% }%> 
     
</select>
<div class="clear"></div>
 --%>
 <div class="clear"></div>
 <input type="hidden" name="removeData" value="" id="removeData" />
 <input type="hidden" name="flag" value="" id="flag"/>
<!-- <div class="paddLeft155">
<input type="button" class="buttonBig" name="Assign" value="Effect The Change" onclick="abc()">  
</div> -->

<input type="button" class="buttonBig" name="Assign" value="save" onclick="abc()">  
 <div class="clear"></div>
 <div class="paddingTop15"></div>
</div>	

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script>
function populateTasks(obj,id)
{
	
	var sel = document.getElementById(id);
	removeAllOptions(sel);
	var sel1 = document.getElementById('mainGroupId');
	removeAllOptions(sel1);
		
	if(obj.value!="All"){
	<%-- <%for(MasHospital hos : instituteList ){%> --%>
	<%-- var size = <%=instituteDepartmentList.size()%>
	var sizeD = <%=departmentList.size()%> --%>
		<%-- if(obj.value == <%=hos.getId()%>){ --%>
		
			
			<%
			
			//Set taskMap = hos.getDeptTaskMaps();
			//List<MstrDeptTaskMap> taskMapList = new ArrayList();
			//Set set = EmployeeComparator.getEmployeeTreeSet();
			//set.addAll(empSet);
			
			 //if(taskMap!=null)
			//{
				//taskMapList = new ArrayList(taskMap);
				//Collections.sort(taskMapList,new TaskComparator());	
			//} 
				
			
			al1.clear();
			
			%> 
			<%-- <% int k=0;
			for(MasInstituteDepartment mid:instituteDepartmentList){%>
		
				if(<%=mid.getInstitute().getId()%> == obj.value){<%
				if(mid.getStatus().equalsIgnoreCase("y")){k++;
					al1.add(mid.getDepartment());
			%>
			
				optionRepMan = new Option("<%=mid.getDepartment().getDepartmentName()%>" , "<%=mid.getDepartment().getId()%>","true");				
				sel.options.add(optionRepMan);
					
			<%}
			%>
				}
				<%}%>
			
		
				
		/* } */
		<%/* } */%> --%>		
		}
	
}

function removeAllOptions(selectbox)
	{
		var i;
		for(i=selectbox.options.length-1;i>=0;i--)
		{
			selectbox.remove(i);
		}
	}

function confirmSubmit()
{
 var x = confirm('Are you sure , you want to assign selected companies to selected record ?');
 if(x)
 {
 submitForm('masters','mastersManagementController?method=assignMasters');
 }
 else
 {
 	return false;
 }
}

function hasOptions(obj) {
	if (obj!=null && obj.options!=null) { return true; }
	return false;
	}
function abc(){
	var v;
	if(document.getElementById("blockId").checked==true && document.getElementById("blockId2").checked==false){
		
		v="y";
	}else if(document.getElementById("blockId2").checked==true && document.getElementById("blockId").checked==false){
		
		v="n";
	}
	if(document.getElementById("blockId").checked==false && document.getElementById("blockId2").checked==false){
		alert("Please Check Block/UnBlock!!");
		return false;
	}else{
	submitForm('instituteWiseServices','/hms/hms/hospital?method=saveForBlockUnBlock&status='+v);
	return true;
	}
}
function copySelectedOptions() {
	   from =document.getElementById("mainGroupId")
	   to =document.getElementById("tempId")
		var options = new Object();
		if (hasOptions(to)) {
			for (var i=0; i<to.options.length; i++) {
				options[to.options[i].value] = to.options[i].text;
				}
			}
		if (!hasOptions(from)) { return; }
		for (var i=0; i<from.options.length; i++) {
			var o = from.options[i];
			if (o.selected) {
				if (options[o.value] == null || options[o.value] == "undefined" || options[o.value]!=o.text) {
					if (!hasOptions(to)) { var index = 0; } else { var index=to.options.length; }
					to.options[index] = new Option( o.text, o.value, true, false);
					}
				}
			}
		/* if ((arguments.length<3) || (arguments[2]==true)) {
			sortSelect(to);
			} */
		from.selectedIndex = -1;
		to.selectedIndex = -1;
		var objTemp = document.getElementById("tempId");
		for (var k=0; k<objTemp.options.length; k++) {
			objTemp.options[k].selected=true
			}
		}
		
		
function removeSelectedOptions() {
	 from =document.getElementById("tempId");
	 document.getElementById("removeData").value=document.getElementById("removeData").value+"@"+from.value;
		if (!hasOptions(from)) { return; }
		if (from.type=="select-one") {
			from.options[from.selectedIndex] = null;
			}
		else {
			for (var i=(from.options.length-1); i>=0; i--) { 
				var o=from.options[i]; 
				if (o.selected) { 
					from.options[i] = null; 
					} 
				}
			}
		from.selectedIndex = -1; 
		} 
		
		
<%-- function populateInst(id)
{
	var hosType=document.getElementById("instType").value; 
	var dist=document.getElementById("district").value;
	alert(hosType+" "+dist)
	var sel = document.getElementById("Institute");
	removeAllOptions(sel);
		
	if(hosType!="0" && dist==0){
	var size = <%=instituteList.size()%>
	optionRepMan = new Option("Select" , "0","true");
	sel.options.add(optionRepMan);
			
			
			<%
			
			for(MasHospital mid:instituteList){%>
		
				if(<%=mid.getHospitalType().getId()%> == hosType){<%
				if(mid.getStatus().equals("y")){
			%>
				optionRepMan = new Option("<%=mid.getHospitalName()%>" , "<%=mid.getId()%>","true");				
				sel.options.add(optionRepMan);
					
			<%}
			%>
				}
				<%}%>
			
		}
	
	if(dist!="0" && hosType =="0"){
		var size = <%=instituteList.size()%>
		optionRepMan = new Option("Select" , "0","true");
		sel.options.add(optionRepMan);
				
				
				<%
				
				for(MasHospital mid:instituteList){%>
			
					if(<%=mid.getDistrict().getId()%> == dist){<%
					if(mid.getStatus().equals("y")){
				%>
					optionRepMan = new Option("<%=mid.getHospitalName()%>" , "<%=mid.getId()%>","true");				
					sel.options.add(optionRepMan);
						
				<%}
				%>
					}
					<%}%>
				
			}
	
	if(dist!="0" && hosType !="0"){
		var size = <%=instituteList.size()%>
		optionRepMan = new Option("Select" , "0","true");
		sel.options.add(optionRepMan);
				
				
				<%
				
				for(MasHospital mid:instituteList){%>
			
					if(<%=mid.getDistrict().getId()%> == dist && <%=mid.getHospitalType().getId()%> == hosType){<%
					if(mid.getStatus().equals("y")){
				%>
					optionRepMan = new Option("<%=mid.getHospitalName()%>" , "<%=mid.getId()%>","true");				
					sel.options.add(optionRepMan);
						
				<%}
				%>
					}
					<%}%>
				
			}
		
				
	
} --%>

function populateCharge()
{
	submitProtoAjaxWithDivName('instituteWiseServices','/hms/hms/hospital?method=getBillInstituteWiseServicesForBlockUnBlock','tempId');

}

	function abc1(val){
		alert("----"+val);
		/* submitProtoAjaxWithDivName('otBooking','/hms/hms/ot?method=fillStoreItem&rowVal=1','nomenclaturetd1'); */
		submitProtoAjaxWithDivName('task','/hms/hms/systemRelatedMaster?method=fillInst&Val='+val,'inst');
	}	
	
	function getSubChargeCode(val)
	{
		var obj=document.getElementById('subChargeName');
		obj.options.length=0;
		obj.options[1] = new Option('select','0');
		//document.getElementById('subChargeName').getElementsByTagName('option').length=0;
		var k=1;
		for(var i=1;i<=subChargeArray.length;i++)
			{
			if(subChargeArray[i-1][2]==val)
				{
				obj.options[k] = new Option(subChargeArray[i-1][1],subChargeArray[i-1][0]);
				k++;
				}
			}
		document.getElementById('mainGroupId').options.length=0;
		//document.getElementById('tempId').options.length=0;
	}
	
	function onSelectSubCharge(val)
	{
		var obj=document.getElementById('mainGroupId');
		obj.options.length=0;
		var k=0;
		for(var i=1;i<=chargeArray.length;i++)
		{
		if(chargeArray[i-1][2]==val)
			{
			obj.options[k] = new Option(chargeArray[i-1][1],chargeArray[i-1][0]);
			k++;
			}
		}
	}
	
	document.getElementById('mainChargeName').selectedIndex = 0;
	document.getElementById('hospital').selectedIndex = 0;
	document.getElementById('subChargeName').selectedIndex = 0;

</script>
<script>
function checkForReason(){
	
if(document.getElementById("blockId").checked==true && document.getElementById("blockId2").checked==false){
		
	document.getElementById("reasonToBlockId").style.display="inline";
	}else if(document.getElementById("blockId2").checked==true && document.getElementById("blockId").checked==false){
		
		document.getElementById("reasonToBlockId").style.display="none";
	}

}

</script>
<script>
function getReasonForBlock(value){
	//alert("value++++++>>>>"+value);
	submitProtoAjaxWithDivName('instituteWiseServices','/hms/hms/hospital?method=getReasonForBlock&chargeCodeId='+value,'reasonForBlockedId');	
	
}

</script>



 