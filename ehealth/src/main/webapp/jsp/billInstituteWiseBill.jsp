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
<%@page import="jkt.hms.masters.business.Users"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
	<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/users.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

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
	List<MasDistrict> mdistrictList = new ArrayList<MasDistrict>();

	
	List<MasHospital> hospitalNameList = new ArrayList<MasHospital>();
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	String message = "";
	if(map.get("message") != null){
		   message = (String)map.get("message");
		   out.println(message);
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
	 //Added by Arbind on 27-06-2017
	 if(map.get("instituteList")!=null){
		instituteList=(List<MasHospital>)map.get("instituteList");
	 } 
	 if(map.get("mdistrictList")!=null){
		 mdistrictList=(List<MasDistrict>)map.get("mdistrictList");
	 } 
	 int hospitalId = 0;
	 if(map.get("hospitalId") != null) {
		 hospitalId = Integer.parseInt(map.get("hospitalId").toString());
	 }
	 String hospitalName="",shortName="";	
	 int districtId = 0,instType=0;
	 int userType=0;
	 Users user=null;
	 if(session.getAttribute("users")!=null){
		 user=(Users)session.getAttribute("users");
		 userType=user.getUserType();
		}
	 
	 /* if(map.get("hospitalId")!=null){
		 hospitalId=(Integer)map.get("hospitalId");
	 } */
	 System.out.println("userType jsp "+userType+" hospitalId "+hospitalId+" instituteList "+instituteList.size());
	 for(MasHospital mh:instituteList){ 
		 hospitalName=mh.getHospitalName();
		 if(hospitalId==mh.getId()){
		 shortName=mh.getShortName();
		 districtId=mh.getDistrict().getId();
		 instType=mh.getHospitalType().getId();
		 break;
		 }
	 }
	
%>

<div class="titleBg"> 
<h2>Institute Wise Services</h2>
</div>

<div class="clear"></div>

<form name="instituteWiseServices" method="post" action="">
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
chargeArray[<%=i%>][1] = "<%=chargeCode.getChargeCodeName().replace("\"", "")%>";
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

<!-- Added by Arbind on 27-06-2017 -->	
	<%if(userType<=1){ %>
	<label>District</label>
    <select name="district" id="district" validate="District,int,no" onchange="dropDownChange();populateCharge();" onblur="dropDownChange();populateCharge();" tabindex="1">
                      	<option value="0">Select</option>
                      	<%for(MasDistrict md:mdistrictList){ 
                 		if(districtId==md.getId()){%>  
                 		 <option value="<%=md.getId() %>" selected="selected"><%=md.getDistrictName()%></option>               		
                 		<%}else{ %>
            	 <option value="<%=md.getId() %>"><%=md.getDistrictName()%></option>
   					<%}} %>
	</select>
	<%}else{ %>
	
	<input type="hidden" name="district" id="district" value="<%=districtId%>"/>
	<%} %>	
	
	<%if(userType<=2){ %>
	<label>Institute Type</label>
    <select name="instType" id="instType" onchange="dropDownChange();populateCharge();" validate="Institute Type,int,no" onblur="dropDownChange();populateCharge();" tabindex="1">
              	<option value="0">Select</option>
                 	<%for(MasHospitalType mht : mhospitalTypetList){ 
                 	if(instType==mht.getId()){
                 	%>
                <option value="<%=mht.getId() %>" selected="selected"><%=mht.getHospitalTypeName()%></option>
                 	<%}else{ %>
            	 <option value="<%=mht.getId() %>"><%=mht.getHospitalTypeName()%></option>
   					<%} }%>
	</select>
	<%} %>
	<script type="text/javascript">
function eventCallback(element, entry){
//alert("group-=="+document.getElementById('itemGroupId').value);
var dist=0,ins=0;
if(document.getElementById("district")!=null){
dist= document.getElementById("district").value;
}
if(document.getElementById("instType")!=null){
ins= document.getElementById("instType").value;
}
	return entry+"&districtId=" + dist+"&instType="+ins;                                                                       
}
</script>
	<%if(userType<=3){ %>
	<label><span>*</span>Institution</label>
<input type="text" name="instName" id="Institute" onblur="getHospitalId('Charge');populateCharge();" value="<%=shortName%>" tabindex="1" >
				<div id="instDiv" style="display: none;"
												class="autocomplete"></div> 
				<script type="text/javascript"
												language="javascript" charset="utf-8">
				new Ajax.Autocompleter('Institute','instDiv','generalMaster?method=getHospitalListForAutoCompleteItem',{minChars:3,parameters:'requiredField=instName',callback: eventCallback});
					</script>
					<input type="hidden" name="hospital" id="hospital" value="<%=hospitalId%>">
					<input type="hidden" name="hospitalId" id="hospitalId" value="<%=hospitalId%>">
	<div class="clear"></div>
	<%} else { %>
		<label><span>*</span>Institution</label>
		<input type="text" name="instsName" id="Institutes" readonly value="<%=shortName%>" tabindex="1" >
		<input type="hidden" name="hospital" id="hospital" value="<%=hospitalId%>">
	<%} %>
	
 
<label>Main Service Head</label> <select id="mainChargeName"
					name="<%=MAIN_CHARGECODE_ID %>" validate="MainCharge,string,No"
					onChange="getSubChargeCode(this.value)"
					tabindex=1>
					<option value="">Select</option>
					<%
for (MasMainChargecode mainChargecode : mainChargeList)
{
%>
					<option value="<%=mainChargecode.getId ()%>"><%=mainChargecode.getMainChargecodeName()%></option>
					<%	}
%>
</select> 

<label><span>*</span> Sub Service Head </label> <select
								id="subChargeName" name="<%=SUB_CHARGECODE_ID %>"
								validate="Sub Service Head ,string,NO" onChange="populateCharge()" tabindex="2">
								<option value="">Select</option>
								<%-- <%
					for (MasSubChargecode subChargecode : subChargeList){
						
				%>
								<option value="<%=subChargecode.getId ()%>"><%=subChargecode.getSubChargecodeName()%></option>
								<%}%> --%>
							</select>
				<%-- <label>Institution Name</label>
                   <select name="hospital" id="hospital" onchange="populateCharge()" validate="Hospital,int,yes">
             	<option value="0">Select</option>
                 	<%for(MasHospital mh:hospitalNameList){ 
                 		if(hospitalId == mh.getId()) {%>
                 			<option value="<%=mh.getId() %>" selected="selected"><%=mh.getHospitalName()%></option>
                 		<%} else {%>
            	 		<option value="<%=mh.getId() %>"><%=mh.getHospitalName()%></option>
   					<%} }%>
	</select> --%>
 <div class="clear"></div>
 <div class="division"></div>
  <div class="clear"></div>
<label style="width:304px;margin-left:0;">Available Charges</label>
<label style="width:304px;margin-left:129px;">To Be Assigned Service</label>
 <div class="clear"></div>
 <div id="inst">
<select name="mainGroupId" id="mainGroupId"  multiple="multiple" size="10" style="height:150px;" class="listBig">
    <%for(MasSubChargecode mh : subChargeList){ %>
     <%-- <option value="<%=md.getId()%>"><%=md.getDepartmentName()%></option> --%>
    <%--  <option value="<%=mh.getId()%>"><%=mh.getSubChargecodeCode()%></option> --%>
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
 <% }%> --%>
     
</select>
<div class="clear"></div>
<div class="clear"></div>
 <input type="hidden" name="removeData" value="" id="removeData" />
 <input type="hidden" name="flag" value="" id="flag"/>

<div class="clear"></div>
<input type="button" class="buttonBig" name="Assign" value="Save" onclick="abc()" style="margin-left:350px;">  
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
	var v=document.getElementById("mainGroupId").value;
	submitForm('instituteWiseServices','/hms/hms/hospital?method=submitBillInstituteWiseServicesJsp')
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
	 
	  // added by Amit Das on 22-03-2016 for multiple remove
	  for (var i = 0; i < from.options.length; i++) {
		     if(from.options[i].selected){
		    	 document.getElementById("removeData").value=document.getElementById("removeData").value+"@"+from.options[i].value;
		      }
		  }
	  
	
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
window.onload = populateCharge();
function populateCharge()
{
	submitProtoAjaxWithDivName('instituteWiseServices','/hms/hms/hospital?method=getBillInstituteWiseServices','tempId','mainGroupId');

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
	
	/* function onSelectSubCharge(val)
	{
		if(val == undefined) {
			var e = document.getElementById('subChargeName');
			val = e.options[e.selectedIndex].value;
			alert("in "+val)
		}
		alert(val);
		flag = false;
		var obj=document.getElementById('mainGroupId');
		obj.options.length=0;
		var k=0;
		for(var i=1;i<=chargeArray.length;i++)
		{
			//Changed by Arbind on 27-06-2017
		/* if(chargeArray[i-1][2]==val)
			{
			obj.options[k] = new Option(chargeArray[i-1][1],chargeArray[i-1][0]);
			k++;
			} 
			if(chargeArray[i-1][2]==val) {
				for(var j=1;j<=assignedChargeArray.length;j++) {
					if(chargeArray[i-1][0] == assignedChargeArray[j-1][0]) {
						flag = true;
					}
				}
				if(flag == false) {
					obj.options[k] = new Option(chargeArray[i-1][1],chargeArray[i-1][0]);
					k++;
				}
				flag = false;
			}
		}
	} */
	
	//Added by Arbind on 27-06-2017
	function dropDownChange(){
		var dist= document.getElementById("district").value;
		var ins= document.getElementById("instType").value;
		if(dist>0 && ins>0){
		    document.getElementById("hospitalId").value=0;
		    document.getElementById("hospital").value=0;
			document.getElementById("Institute").value="";
		}
		 
	}
	document.getElementById('mainChargeName').selectedIndex = 0;
	//document.getElementById('hospital').selectedIndex = 0;
	document.getElementById('subChargeName').selectedIndex = 0;

</script>



 