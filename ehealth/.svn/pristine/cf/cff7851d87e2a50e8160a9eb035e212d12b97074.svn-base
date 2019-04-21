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
<%@page import="jkt.hms.masters.business.MasTemplate"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasInstituteDepartment"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.*" %>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hrms.masters.business.MstrDeptTaskMap"%>
<%@page import="jkt.hrms.masters.business.MstrTask"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>
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
	List<MasDepartment>   departmentList = new ArrayList<MasDepartment>();
	List<MstrDeptTaskMap> deptTaskMapList = new ArrayList<MstrDeptTaskMap>();
	List<MstrTask>   mstrTaskList = new ArrayList<MstrTask>();
	List<MasInstituteDepartment> instituteDepartmentList = new ArrayList<MasInstituteDepartment>();
	List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
	List<MasDistrict> mdistrictList = new ArrayList<MasDistrict>();
	
List<MasTemplate> templateList=new ArrayList<MasTemplate>();
		
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	if(map.get("templateList")!=null){
		templateList=(List<MasTemplate>)map.get("templateList");
		}
	
	  if(map.get("searchDepartmentList")!=null){
		 departmentList=(List<MasDepartment>)map.get("searchDepartmentList");
		} 
		if(map.get("instituteList")!=null){
			instituteList=(List<MasHospital>)map.get("instituteList");
			} 
	 if(map.get("deptTaskMapList")!=null){
		 deptTaskMapList=(List<MstrDeptTaskMap>)map.get("deptTaskMapList");
		 
		}
	 if(map.get("mstrTaskList")!=null){
		 mstrTaskList=(List<MstrTask>)map.get("mstrTaskList");
	}  
	  if(map.get("instituteDepartmentList")!=null){
		 instituteDepartmentList=(List<MasInstituteDepartment>)map.get("instituteDepartmentList");
	} 
	  if(map.get("mhospitalTypetList")!=null){
		 mhospitalTypetList=(List<MasHospitalType>)map.get("mhospitalTypetList");
		}
	 if(map.get("mdistrictList")!=null){
		 mdistrictList=(List<MasDistrict>)map.get("mdistrictList");
		} 
	 
	 String message="";
	 
	 if(map.get("message")!=null){
		 message=(String)map.get("message");
		} 
	 List<MasTemplate> hospitaltemplateList=new ArrayList<MasTemplate>();
	 
	 if(map.get("hospitaltemplateList")!=null){
		 hospitaltemplateList=(List<MasTemplate>)map.get("hospitaltemplateList");
		} 
	 
	 String hospitalName="",shortName="";	
	 int districtId = 0,instType=0;
	 int userType=0,hospitalId=0;
	 Users user=null;
	 if(session.getAttribute("users")!=null){
		 user=(Users)session.getAttribute("users");
		 userType=user.getUserType();
		}
	 
	 if(map.get("hospitalId")!=null){
		 hospitalId=(Integer)map.get("hospitalId");
	 }
	// System.out.println("userType jsp "+userType+" hospitalId "+hospitalId+" instituteList "+instituteList.size());
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
<%if(!message.equals("")){ %>
<h4><%=message %></h4>
<%} %>
<h2>Role Mapping</h2>
</div>

<div class="clear"></div>

<form name="task" method="post" >
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">


<%-- <label>District</label>
    <select name="district" id="district" onchange="populateInst('tempId')" validate="District,int,no">
             	<option value="0">Select</option>
                 	<%for(MasDistrict md:mdistrictList){ %>
            	 <option value="<%=md.getId() %>"><%=md.getDistrictName()%></option>
   					<%} %>
	</select> --%>
	<%-- <label>Institute Type</label>
    <select name="instType" id="instType" onchange="populateInst('tempId')" validate="Institute Type,int,no">
             	<option value="0">Select</option>
                 	<%for(MasHospitalType mht : mhospitalTypetList){ %>
            	 <option value="<%=mht.getId() %>"><%=mht.getHospitalTypeName()%></option>
   					<%} %>
	</select>
 --%>
<%-- <label><span>* </span>Institute</label>
    <select name="Institute" id="Institute" onchange="populateTasks(this,'tempId');abc1(this.value)" validate="Institute,int,yes">

             	<option value="0">Select</option>
                 	<%for(MasHospital mh:instituteList){ %>
            	 <option value="<%=mh.getId() %>"><%=mh.getHospitalName() %></option>
   					<%} %>
	</select> --%>
	<%if(userType<=1){ %>
	<label>District</label>
    <select name="district" id="district" validate="District,int,no" onchange="dropDownChange();getRoleTemplateList();" onblur="dropDownChange();getRoleTemplateList();" tabindex="1">
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
 <!--     <select name="instType" id="instType" onchange="populateInst('tempId')" validate="Institute Type,int,no">-->
    <select name="instType" id="instType" onchange="dropDownChange();getRoleTemplateList();" validate="Institute Type,int,no" onblur="dropDownChange();getRoleTemplateList();" tabindex="1">
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
	<%
if(userType==5){ // For PH admin
	List<Object[]> bsScInstList = new ArrayList<Object[]>();
	
	if(map.get("bsScInstList") != null){
		bsScInstList = (List<Object[]>)map.get("bsScInstList");
	}
%>
<label><span>* </span>Institute</label>
<div id="insHospital">
    <select name="instName" id="hospitalId" onchange="getRoleTemplateList();" validate="Institute,int,yes">

             	<option value="0">Select</option>
                 	<%for(Object[] mh:bsScInstList){ 
                 	if(hospitalId == (Integer)mh[0]){
                 	%>
                 	 <option value="<%=mh[0] %>" selected="selected"><%=mh[1]%></option>
                 	<%}else{ %>
            	 <option value="<%=mh[0] %>"><%=mh[1]%></option>
   					<%} 
   					}%>
	</select>
	<%}else{ %>
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
<input type="text" name="instName" id="Institute" onblur="getHospitalId('RoleMapping');getRoleTemplateList();" onkeypress="return noenter(event)" value="<%=shortName%>" tabindex="1" >
<input type="hidden" id="hospital"/>
				<div id="instDiv" style="display: none;"
												class="autocomplete"></div> 
				<script type="text/javascript"
												language="javascript" charset="utf-8">
				new Ajax.Autocompleter('Institute','instDiv','generalMaster?method=getHospitalListForAutoCompleteItem',{minChars:3,parameters:'requiredField=instName',callback: eventCallback});
					</script>
					<input type="hidden" name="<%=HOSPITAL_ID%>" id="hospitalId" value="<%=hospitalId%>">
	<%} else { %>
	<!-- Added by Arbind on 27-06-2017 -->
		<label><span>*</span>Institution</label>
		<input type="text" name="instName" id="Institute" readonly value="<%=shortName%>" tabindex="1" >
		<input type="hidden" name="<%=HOSPITAL_ID%>" id="hospitalId" value="<%=hospitalId%>">
	<%} %>
<%} %>
<div class="clear"></div> 
<div class="paddingTop5"></div>
<label class="bgNone"></label>
<label class="bgNone">Role</label>

<label class="bgNoneAuto" style="margin-left:268px;">To Be Assigned Role</label>
<div class="clear"></div>
<label class="bgNone"></label> 	
 
<select name="mainGroupId" id="mainGroupId"  multiple="multiple" size="7" class="listBig3" style="margin-top:0;">
     <%for(MasTemplate md : templateList){ %>
     <option value="<%=md.getTemplateName()%>"><%=md.getTemplateName()%></option>
     <%} %> 
</select>
<div class="placeHolderForAddLeftnRight">
<input type="button" name="Add" class="addRight" value="" onclick="copySelectedOptions();" />
<input type="button" name="send" class="addLeft"  onclick="removeSelectedOptions();"/>
</div>
<div id="templateDiv">	
<select name="tempId" id="tempId"  multiple="multiple" validate="Role,string,yes" size="3" class="listBig3" style="margin-top:0;">
<%if(null !=hospitaltemplateList && hospitaltemplateList.size()>0){
	for(MasTemplate template:hospitaltemplateList){
%>
<option value="<%= template.getTemplateName()%>"><%= template.getTemplateName()%></option>
<%}} %>
</select>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<label class="bgNone"></label>

<%if(null !=hospitaltemplateList && hospitaltemplateList.size()>0) {%>
<input type="button" class="button" style="margin-left:336px;" name="Assign" value="Update" onclick="abc()"/>  
<%}else{ %>
<input type="button" class="button" style="margin-left:336px;" name="Assign" value="Save" onclick="abc()"/>  
<%} %>
 <div class="clear"></div>
 <div class="paddingTop5"></div>
</div>	
</div>
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
	var size = <%=instituteDepartmentList.size()%>
	var sizeD = <%=departmentList.size()%>
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
			<% int k=0;
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
		<%/* } */%>
		
		
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

function hasOptions(obj) {
	if (obj!=null && obj.options!=null) { return true; }
	return false;
	}
function abc(){
	//var v=document.getElementById("mainGroupId").value;
	//alert(v)
	//submitForm('task','/hms/hms/systemRelatedMaster?method=saveDepartmentForInstitute&tempId='+v)
	submitForm('task','/hms/hms/user?method=addRoleTemplate')
}
function copySelectedOptions() {
	   from =document.getElementById("mainGroupId")
	   to =document.getElementById("tempId")
		var options = new Object();
		if (hasOptions(to)) {
			for (var i=0; i<to.options.length; i++) {
				options[to.options[i].value] = to.options[i].text;
				to.options[i].selected=true;
				}
			}
		if (!hasOptions(from)) { return; }
		for (var i=0; i<from.options.length; i++) {
			var o = from.options[i];
			if (o.selected) {
				if (options[o.value] == null || options[o.value] == "undefined" || options[o.value]!=o.text) {
					if (!hasOptions(to)) { var index = 0; } else { var index=to.options.length; }
					to.options[index] = new Option( o.text, o.value, true, false);
					to.options[index].selected=true;
					}
				}
			}
		if ((arguments.length<3) || (arguments[2]==true)) {
			sortSelect(to);
			}
		from.selectedIndex = -1;
		to.selectedIndex = -1;
		var objTemp = document.getElementById("tempId");
		for (var k=0; k<objTemp.options.length; k++) {
			objTemp.options[k].selected=true;
			}
		}
		
		
function removeSelectedOptions() {
	 from =document.getElementById("tempId") 
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
		
		
function populateInst(id)
{
	var hosType=document.getElementById("instType").value; 
	var dist=document.getElementById("district").value;
	//alert(hosType+" "+dist)
	var sel = document.getElementById("Institute");
	removeAllOptions(sel);
		
	if(hosType!="0" && dist==0){
	var size = <%=instituteList.size()%>
	
			
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
				optionRepMan = new Option("Select" , "0","true");
				sel.options.add(optionRepMan);
			
		}
	
	if(dist!="0" && hosType =="0"){
		var size = <%=instituteList.size()%>
	

				<%
				for(MasHospital mid:instituteList){%>
					<%if(mid.getDistrict()!=null){%>
					if(<%=mid.getDistrict().getId()%> == dist){<%
							if(mid.getStatus().equals("y")){
						%>
							optionRepMan = new Option("<%=mid.getHospitalName()%>" , "<%=mid.getId()%>","true");				
							sel.options.add(optionRepMan);
								
						<%}
						%>
						}
					<%}%>
					
					<%}%>
					optionRepMan = new Option("Select" , "0","true");
					sel.options.add(optionRepMan);
			}
	
	if(dist!="0" && hosType !="0"){
		var size = <%=instituteList.size()%>

				
				<%
				for(MasHospital mid:instituteList){%>
				<%if(mid.getDistrict()!=null){%>
						if(<%=mid.getDistrict().getId()%> == dist && <%=mid.getHospitalType().getId()%> == hosType){<%
							if(mid.getStatus().equals("y")){
						%>
							optionRepMan = new Option("<%=mid.getHospitalName()%>" , "<%=mid.getId()%>","true");				
							sel.options.add(optionRepMan);
								
						<%}
						%>
							}
				<%}%>
					<%}%>
					optionRepMan = new Option("Select" , "0","true");
					sel.options.add(optionRepMan);
			}
		
}

	function abc1(val){
		//alert("----"+val);
		/* submitProtoAjaxWithDivName('otBooking','/hms/hms/ot?method=fillStoreItem&rowVal=1','nomenclaturetd1'); */
		submitProtoAjaxWithDivName('task','/hms/hms/systemRelatedMaster?method=fillInst&Val='+val,'inst');
	}	
	
	function noenter(e) {
		if(window.event)
			keyPressed = window.event.keyCode; 
		else
			keyPressed = e.which; 
		
		return !(keyPressed == 13); 
	}
</script>



 