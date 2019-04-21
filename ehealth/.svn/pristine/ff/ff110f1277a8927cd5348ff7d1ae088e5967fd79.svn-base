
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.PatientWiseMlc"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.PhHouseSurvey"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@ page import="static jkt.hms.util.RequestConstants.HOSPITAL_ID"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
	<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/users.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript" language="javascript">
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
		String userName = "";
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
			String currentDate = (String)utilMap.get("currentDate");  
			String currentTime = (String)utilMap.get("currentTime");
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
		Map<String, Object> map=new HashMap<String, Object>();
		List<MasEmployee> removedEmployeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<MasHospitalType> hospitalTypeList = new ArrayList<MasHospitalType>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasEmpCategory> categoryList = new ArrayList<MasEmpCategory>();
		List<MasEmployeeDepartment> employeeDepartmentList = new ArrayList<MasEmployeeDepartment>();
		
		if(request.getAttribute("map")!=null){
			map=(Map<String ,Object>)request.getAttribute("map");
		}
		if(map.get("removedEmployeeList")!=null){
			removedEmployeeList=(List<MasEmployee>)map.get("removedEmployeeList");
		}
		if(map.get("employeeList")!=null){
			employeeList=(List<MasEmployee>)map.get("employeeList");
		}
		if(map.get("districtList")!=null){
			districtList=(List<MasDistrict>)map.get("districtList");
		}
		if(map.get("hospitalList")!=null){
			hospitalList=(List<MasHospital>)map.get("hospitalList");
		}
		if(map.get("hospitalTypeList")!=null){
			hospitalTypeList=(List<MasHospitalType>)map.get("hospitalTypeList");
		}
		if(map.get("rankList")!=null){
			rankList=(List<MasRank>)map.get("rankList");
		}
		if(map.get("categoryList")!=null){
			categoryList=(List<MasEmpCategory>)map.get("categoryList");
		}
		if(map.get("employeeDepartmentList")!=null){
			employeeDepartmentList=(List<MasEmployeeDepartment>)map.get("employeeDepartmentList");
		}
		List<Object[]> bsScInstList = new ArrayList<Object[]>();
		if(map.get("bsScInstList") != null){
			bsScInstList = (List<Object[]>)map.get("bsScInstList");
		}
		String message = "";
		if(map.get("message")!=null){
			message=(String)map.get("message");
		}
		
		String hospitalName="",shortName="";	
		 int districtId = 0,instType=0;
		 int userType=0,hospitalId=0;
		 
		 if(map.get("hospitalId")!=null){
			 hospitalId=(Integer)map.get("hospitalId");
		 }else{
			 hospitalId = (Integer)session.getAttribute("hospitalId");
		 }
			if(session.getAttribute("users") != null){
				 Users user = (Users)session.getAttribute("users");
				 userType = user.getUserType()!=null?user.getUserType():4;
			}
		// System.out.println("userType jsp "+userType+" hospitalId "+hospitalId+" instituteList "+instituteList.size());
		 for(MasHospital mh:hospitalList){ 
			 hospitalName=mh.getHospitalName();
			 if(hospitalId==mh.getId()){
			 shortName=mh.getShortName();
			 districtId=mh.getDistrict().getId();
			 instType=mh.getHospitalType().getId();
			 break;
			 }
		 }
		 
		String CurrentDate=date+"/"+month+"/"+year;
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
		

</script>
<h4><%=message != null?message:""%></h4>


<div class="titleBg">
<h2>Removed Employee Institution Mapping</h2>
</div>
<div class="Block">

 <form name="search" method="post">
<div class="Block">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label class="medium">PEN</label>
<input type="radio" name="radio"   value="1" validate="PEN,string,yes" checked="checked" class="radiobutMargin" tabindex=1 />
<label class="medium">Emp Name</label>
<input type="radio" name="radio" value="2"  class="radiobutMargin"  tabindex=1 MAXLENGTH="128" />							
<input type="text"  id="searchField"  name="searchField" value=""  validate="Search Field,string,no" MAXLENGTH="32"  tabindex=1/>
   <%
               	if(userType==5){
               %>
               <label>Institution</label>
               <select name="bsScInst" id="bsScInst" >
           	    	<option value="0">Select</option>
               		<%
               			for(Object[] ob : bsScInstList){
               		if(hospitalId == (Integer)ob[0]){
                 	%>
                 	 <option value="<%=ob[0] %>" selected="selected"><%=ob[1]%></option>
                 	<%}else{ %>
            	 <option value="<%=ob[0] %>"><%=ob[1]%></option>
   					<%} } %>
               	
               </select>
               
               
               <%} %> 
<!-- <label><span>*</span> PEN</label>
<input name="pen" id="pen" validate="PEN,string,no" /> -->
 <input type="button" value="Search" onclick="submitForm('search','/hms/hms/personnel?method=searchRemovedEmployeeInstitutionMappingJsp','checkSearch');"/>
 <input type="button" name="Report" value="Generate Report" class="inputButtonAutu" onClick="submitForm('search','personnel?method=generateReportRemovedEmployee');" accesskey="g" tabindex=1/>
 </div>
<div class="clear"></div>
	
</form>

<form name="removedEmployee" method="post">

     
           
               
<div id="pageNavPosition"></div>
<table id="tableId" class="cmntable">
	<tr>
	<th>PEN</th>
	<th>Employee Name</th>
	<th>Designation</th>
	<th>Category</th>
	<th>Department</th>
	<th>Last Institution</th>
	</tr>
	<%if(removedEmployeeList.size()>0){ 
		for(MasEmployee masEmployee :removedEmployeeList){
			String url = "personnel?method=showRemovedEmployeeDetail&employeeId="+masEmployee.getId();
	
	%>
<tr onclick="parent.location='<%=url %>'">
<td><%=masEmployee.getPEN() != null?masEmployee.getPEN():"" %></td>
<td><%=masEmployee.getEmployeeName() != null?masEmployee.getEmployeeName():"" %></td>
<td><%=masEmployee.getRank() != null?masEmployee.getRank().getRankName():"" %></td>
<td><%=masEmployee.getEmpCategory() != null?masEmployee.getEmpCategory().getEmpCategoryName():"" %></td>
<td><%=masEmployee.getEmployeeDepartment() != null?masEmployee.getEmployeeDepartment().getEmpDeptName():"" %></td>
<td><%=masEmployee.getHospital() != null?masEmployee.getHospital().getHospitalName():"" %></td>
<%}} %>

</tr>
</table>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>

<h2>Previous Institution Details</h2>
<div class="clear"></div>
<label>PEN</label>
<input type="text" name="pen" value="<%=employeeList.size()>0 && employeeList.get(0).getPEN() != null?employeeList.get(0).getPEN():"" %>"  />
<input type="hidden" name="title" value="<%=employeeList.size()>0 && employeeList.get(0).getTitle() != null?employeeList.get(0).getTitle().getId():"" %>"  />
<input type="hidden" name="firstName" value="<%=employeeList.size()>0 && employeeList.get(0).getFirstName() != null?employeeList.get(0).getFirstName():"" %>"  />
<input type="hidden" name="middleName" value="<%=employeeList.size()>0 && employeeList.get(0).getMiddleName() != null?employeeList.get(0).getMiddleName():"" %>"  />
<input type="hidden" name="lastName" value="<%=employeeList.size()>0 && employeeList.get(0).getLastName() != null?employeeList.get(0).getLastName():"" %>"  />
<input type="hidden" name="employeeStatusId" value="<%=employeeList.size()>0 && employeeList.get(0).getEmployeeStatus() != null?employeeList.get(0).getEmployeeStatus().getId():"" %>"  />
<input type="hidden" name="employeeTypeId" value="<%=employeeList.size()>0 && employeeList.get(0).getEmployeeType() != null?employeeList.get(0).getEmployeeType().getId():"" %>"  />
<input type="hidden" name="uhid" value="<%=employeeList.size()>0 && employeeList.get(0).getUHID() != null?employeeList.get(0).getUHID():"" %>"  />
<input type="hidden" name="fatherHusbandName" value="<%=employeeList.size()>0 && employeeList.get(0).getFatherHusbandName()!= null?employeeList.get(0).getFatherHusbandName():"" %>"  />
<input type="hidden" name="personaDetaisId" value="<%=employeeList.size()>0 && employeeList.get(0).getPersonalDetails()!= null?employeeList.get(0).getPersonalDetails().getId():"" %>"  />
<input type="hidden" name="employeeId" value="<%=employeeList.size()>0 && employeeList.get(0).getId()!= null?employeeList.get(0).getId():"" %>"  />
<input type="hidden" name="lastInstitutionId" value="<%=employeeList.size()>0 && employeeList.get(0).getHospital() != null?employeeList.get(0).getHospital().getId():"" %>"  />

<label>Employee Name</label>
<input type="text" name="employeeName" value="<%=employeeList.size()>0 && employeeList.get(0).getEmployeeName() != null?employeeList.get(0).getEmployeeName():"" %>"  />

<label>Designation</label>
<input type="text" name="designation" value="<%=employeeList.size()>0 && employeeList.get(0).getRank() != null?employeeList.get(0).getRank().getRankName():"" %>"  />

<div class="clear"></div>
<label>Category</label>
<input type="text" name="category" value="<%=employeeList.size()>0 && employeeList.get(0).getEmpCategory() != null?employeeList.get(0).getEmpCategory().getEmpCategoryName():"" %>"  />

<label>Department</label>
<input type="text" name="department" value="<%=employeeList.size()>0 && employeeList.get(0).getEmployeeDepartment() != null?employeeList.get(0).getEmployeeDepartment().getEmpDeptName():"" %>"  />

<label>Last Institution</label>
<input type="text" name="lastInstitution" value="<%=employeeList.size()>0 && employeeList.get(0).getHospital() != null?employeeList.get(0).getHospital().getHospitalName():"" %>" tabindex="1" />

<div class="clear"></div>
<%-- <label>District</label>
<select name="district" id="district" validate="District,int,no" onchange="populateHospital()">
			<option value="0">Select</option>
				<% for(MasDistrict district :districtList){ %>
				<option value="<%=district.getId()%>"><%=district.getDistrictName()%></option>
				<%	}%></select>	
				
<label>Type Of Institution</label>

<select name="hospitalType" id="hospitalType" validate="Hospital Type,int,no" onchange="populateHospital()" />
 <!-- onChange="populateHospital(this.value,'removedEmployee')" -->
			<option value="0">Select</option>
				<% for(MasHospitalType hospitalType :hospitalTypeList){ %>
				<option value="<%=hospitalType.getId()%>"><%=hospitalType.getHospitalTypeName()%></option>
				<%	}%></select>	
			
				<label>Hospital</label>
				<div id="insHospital">
<select name="hospitalId" id="hospitalId" validate="Hospital,int,yes" >
			<option value="0">Select</option>
				<% for(MasHospital hospital :hospitalList){ %>
				<option value="<%=hospital.getId()%>"><%=hospital.getHospitalName()%></option>
				<%	}%></select>
				</div>	 --%>
				<input type="hidden" id="hospital" name="hospital">
	<div class="clear"></div>
	<h2>New Institution Details</h2>
	<div class="clear"></div>			
				<label>District</label>
    <select name="district" id="district" validate="District,int,no" onchange="dropDownChange();" onblur="dropDownChange();" tabindex="1">
                      	<option value="0">Select</option>
                      	<%for(MasDistrict md:districtList){ if(employeeList.size()>0 && employeeList.get(0).getHospital()!=null && employeeList.get(0).getHospital().getDistrict()!=null && employeeList.get(0).getHospital().getDistrict().getId()==md.getId()){%>
                      	<option value="<%=md.getId() %>" selected="selected"><%=md.getDistrictName()%></option>
                      	<%}else {%>
            	        <option value="<%=md.getId() %>"><%=md.getDistrictName()%></option>
   					<%}} %>
	</select>
				
				<label>Type Of Institution</label>
    <select name="instType" id="instType" onchange="dropDownChange();" validate="Institute Type,int,no" onblur="dropDownChange();" tabindex="1">
              	<option value="0">Select</option>
                 	<%for(MasHospitalType mht : hospitalTypeList){ if(employeeList.size()>0 && employeeList.get(0).getHospital()!=null && employeeList.get(0).getHospital().getHospitalType()!=null && employeeList.get(0).getHospital().getHospitalType().getId()==mht.getId()){%>
                 	<option value="<%=mht.getId() %>" selected="selected"><%=mht.getHospitalTypeName()%></option>
                 	<%} else{%>
            	 <option value="<%=mht.getId() %>"><%=mht.getHospitalTypeName()%></option>
   					<%} }%>
	</select>
				
	<script type="text/javascript">
		function eventCallback(element, entry){
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
	
	<label><span>*</span>Hospital</label>
<input type="text" name="instName" id="Institute"  onblur="getHospitalId();getTabDetails(this.value);" oninput="checkDistrict();" value="" tabindex="1" > 
				<div id="instDiv" style="display: none;"
												class="autocomplete"></div> 
				<script type="text/javascript"
												language="javascript" charset="utf-8">
				new Ajax.Autocompleter('Institute','instDiv','generalMaster?method=getHospitalListForAutoCompleteItem',{minChars:3,parameters:'requiredField=instName',callback: eventCallback});
					</script>
					<input type="hidden" name="<%=HOSPITAL_ID%>" id="hospitalId" value="<%=hospitalId%>">
	
				<label>Designation</label>
<select name="rankId" id="rankId" validate="Designation,int,yes" tabindex="1" >
			<option value="0">Select</option>
				<% for(MasRank rank :rankList){ if(employeeList.size()>0 && employeeList.get(0).getRank()!=null && employeeList.get(0).getRank().getId()==rank.getId()){%>
				<option value="<%=rank.getId()%>" selected="selected"><%=rank.getRankName()%></option>
				<%}else{ %>
				<option value="<%=rank.getId()%>"><%=rank.getRankName()%></option>
				<%	}}%></select>
				
				<label>Category</label>
<select name="categoryId" id="categoryId" validate="Category,int,yes" tabindex="1">
			<option value="0">Select</option>
				<% for(MasEmpCategory category :categoryList){ if(employeeList.size()>0 && employeeList.get(0).getEmpCategory()!=null && employeeList.get(0).getEmpCategory().getId()==category.getId()){%>
				<option value="<%=category.getId()%>" selected="selected"><%=category.getEmpCategoryName()%></option>
				<%} else{%>
				<option value="<%=category.getId()%>"><%=category.getEmpCategoryName()%></option>
				<%	}}%></select>
				<label>Department</label>
<select name="empDeptId" id="empDeptId"  validate="Department,int,yes" tabindex="1" >
			<option value="0">Select</option>
				<% for(MasEmployeeDepartment employeeDepartment :employeeDepartmentList){ if(employeeList.size()>0 && employeeList.get(0).getEmployeeDepartment()!=null && employeeList.get(0).getEmployeeDepartment().getId()==employeeDepartment.getId()){%>
				<option value="<%=employeeDepartment.getId()%>" selected="selected"><%=employeeDepartment.getEmpDeptName()%></option>
				<%}else{ %>
				
				<option value="<%=employeeDepartment.getId()%>"><%=employeeDepartment.getEmpDeptName()%></option>
				<%	}}%></select>


 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
 
<div class="clear"></div>
<label>IMEI No.</label>
<input type="text" name="imeiNo" value="" id="imeiNoId" tabindex="1">

<label>SIM No.</label>
<input type="text" name="simSerialNo" value="" id="simSerialNoId" tabindex="1">

<label>MAC</label>
<input type="text" name="mac" value="" id="macId" tabindex="1">

<label>UTID</label>
<input type="text" name="utid" value="" id="utidId" tabindex="1">

 <div class="clear"></div>
 <input name="save" type="button" class="button" value="Submit" tabindex="1" onClick="submitForm('removedEmployee','personnel?method=assignInstituteForRemovedEmployee');" />
	<input type="reset" name="Reset" value="Reset"	class="buttonHighlight" onclick="resetValues();" accesskey="r" tabindex="1"/> 

</form>
 </div>	 
	<script>
		/* var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1); */
		
		
		hospitalArray = new Array();
		<%
			int count = 0;
			for (MasHospitalType masHospitalType :hospitalTypeList)
			{

				for (MasHospital masHospital :hospitalList)
				{

					if(masHospitalType.getId().equals(masHospital.getHospitalType().getId())){
								%>
								hospitalArray[<%=count%>] = new Array();
								hospitalArray[<%=count%>][0] = <%=masHospitalType.getId()%>;
								hospitalArray[<%=count%>][1] = <%=masHospital.getId()%>;
								hospitalArray[<%=count%>][2] = "<%=masHospital.getHospitalName()%>";

								<%
								count++;
						}	} } %>

		</script> 
 <div class="clear"></div>
	<div class="bottom">
		<label>Changed By:</label>
		<label class="value"><%=userName%></label>
		<label>Changed Date:</label>
		<label class="value"><%=currentDate%></label>
		<label>Changed Time:</label>
		<label class="value"><%=currentTime%></label>
	</div>
<!--Block Two Ends-->
	<div class="clear"></div>
	<!--Bottom labels starts-->
	<div class="bottom">
	<input type="hidden" name="lastChgBy" value="<%=userName%>" />
	<input type="hidden" name="lastChgDate" value="<%=currentDate%>" /> 
	<input type="hidden" name="lastChgTime" value="<%=currentTime%>" /> 
	</div>

<script>
	//added by govind 07-01-2017
	/* function populateHospital(){
		var districtId=document.getElementById("district").value;
	    var instType=document.getElementById("hospitalType").value;
	    var parameter="name='hospitalId' id='hospitalId' validate='Hospital,int,yes' onchange='populate();'";
		//alert("districtId "+districtId+" instType "+instType);
		submitProtoAjaxWithDivName('removedEmployee','/hms/hms/personnel?method=fillInstHospital&districtId='+districtId+'&instType='+instType+'&parameter='+parameter,'insHospital');
		
		var Institute=document.getElementById("Institute");		
		Institute.name = 'hospitalId';
		Institute.id = 'hospitalId';
		e1.setAttribute('validate', 'Hospital,int,yes');
	} *///added by govind 07-01-2017 end
	
  function	getTabDetails(hospitalId){
			var districtId= document.getElementById("district").value;
			var id;
			var xmlHttp;
			try {
				// Firefox, Opera 8.0+, Safari
				xmlHttp = new XMLHttpRequest();
			} catch (e) {
				// Internet Explorer
				try {
					xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
				} catch (e) {
					alert(e)
					try {
						xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
					} catch (e) {
						alert("Your browser does not support AJAX!");
						return false;
					}
				}
			}

			xmlHttp.onreadystatechange = function() {
				if (xmlHttp.readyState == 4) {
					var b = "false"; 
					var items = xmlHttp.responseXML.getElementsByTagName('tablet')[0];
					for (loop = 0; loop < items.childNodes.length; loop++) {

						var item = items.childNodes[loop];
						var dupl = item.getElementsByTagName('simNo')[0];
						var dupl1 = item.getElementsByTagName('imeiNo')[0];
						var dupl2 = item.getElementsByTagName('macNo')[0];
						var dupl3 = item.getElementsByTagName('utidNo')[0];
						
					/* 	b = dupl.childNodes[0].nodeValue;
						b1 = dupl1.childNodes[0].nodeValue;
						b2 = dupl2.childNodes[0].nodeValue;
						b3 = dupl3.childNodes[0].nodeValue; */
						
						if(dupl.childNodes[0]!=null){
							b = dupl.childNodes[0].nodeValue;
							if('null' !=b){
								document.getElementById('simSerialNoId').value=b;
							}else{
								document.getElementById('simSerialNoId').value='';
							}
						}
					}
					if(dupl1.childNodes[0]!=null){
						b1 = dupl1.childNodes[0].nodeValue;
						if('null' !=b1){
							document.getElementById('imeiNoId').value=b1;
						}else{
							document.getElementById('imeiNoId').value='';
						}
					}
					if(dupl2.childNodes[0]!=null){
						b2 = dupl2.childNodes[0].nodeValue;
						if('null' !=b2){
							document.getElementById('macId').value=b2;
						}else{
							document.getElementById('macId').value='';
						}
					}
					if(dupl3.childNodes[0]!=null){
						b3 = dupl3.childNodes[0].nodeValue;
						if('null' !=b3){
							document.getElementById('utidId').value=b3;
						}else{
							document.getElementById('utidId').value='';
						}
					}
				}
			};
			var url = "/hms/hms/personnel?method=showTabletDetails&hospitalId="+hospitalId +"&districtId="+ districtId + 
					  "&" + csrfTokenName + "="+ csrfTokenValue;
			
			xmlHttp.open("GET", url, true);
			xmlHttp.setRequestHeader("Content-Type", "text/xml");
			xmlHttp.send(null);
	}

	
	
	function getHospitalId(){
		var instName=document.getElementById("Institute").value;
		if(instName==""){
			document.getElementById("hospitalId").value=0;
			document.getElementById("hospital").value=0;
		}else{
		    var xmlHttp;
		    try {
		      // Firefox, Opera 8.0+, Safari
		      xmlHttp=new XMLHttpRequest();
		    }catch (e){
		      // Internet Explorer
		      try{
		        xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		      }catch (e){
		      	alert(e)
		        try{
		          xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		        }catch (e){
		          alert("Your browser does not support AJAX!");
		          return false;
		        }
		       }
		     }
		      xmlHttp.onreadystatechange=function()
		      {
		      	
		        if(xmlHttp.readyState==4){
		        	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
		        	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
		  	   	    var item = chargeCodes.childNodes[loop];
		  	   	 
		  	        var hospitalName  = item.getElementsByTagName("hospitalName")[0];
		  	        var hosid  = item.getElementsByTagName("hospitalId")[0]; 
		  	        var id= hosid.childNodes[0].nodeValue;			  	      
		  	    document.getElementById("hospitalId").value=id;
		  	  document.getElementById("hospital").value=id;

		        	}
		         }
	        }
		 
		    var url='/hms/hms/generalMaster?method=getHospitalId&hospitalName='+instName;
		 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; 

		    xmlHttp.open("GET",url,true);
		    xmlHttp.setRequestHeader("Content-Type", "text/xml");
		    xmlHttp.send(null);
		      }
		
	}
	
	function checkDistrict(){
		var district = document.getElementById("district").value;
		if(district=="0"){
			alert("Please select District !");
			document.getElementById("Institute").value="";
			return false;
			
		}else{
			return true;
		}
	}


	function checkSearch(){
		if(document.getElementById('bsScInst')){
			if(document.getElementById('searchField').value == '' && document.getElementById('bsScInst').value==0){
				alert("Please enter value in textfield or select Institution");
	
				return false;
			}else
				return true;
		}else if(document.getElementById('searchField').value == ''){
			alert("Please enter value in textfield");
			
			return false;
		}else
			return true;
		
	}
	
	</script>
