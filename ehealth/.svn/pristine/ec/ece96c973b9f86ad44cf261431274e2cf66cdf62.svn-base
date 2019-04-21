
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasInstituteDepartment"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/proto.js"></script>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<script language="javascript"  type="text/javascript" src="/hms/jsp/js/ajax.js"></script>


<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();	
		
		   
	    if(map.get("departmentList")!=null){
	    	departmentList=(List<MasDepartment>)map.get("departmentList");
	    } 

		

	
	if(map.get("message") != null){
		  String message = (String)map.get("message");
	%>
	<h4><span><%=message %></span></h4>
	<%}

	%> 




<div class="titleBg">
	<h2>Doctor Counter Mapping</h2>
</div>
<div class="Block">
	<div id="searcharea">
		<div id="searchbar">			
		</div>
	</div>
	<div class="clear"></div>
</div>
<form name="doctorCounterMapping" method="post" action="" enctype="">
							<div class="Block">

													
								<label><span>*</span>Service Centre</label> 
								<select name="serviceCentreId" 	 onchange="displayUnitCounter(this.value);" tabindex=2>
									<option value="0">Select</option>
									<% 
					                 for (MasDepartment department : departmentList){
					                     %>
										<option value="<%=department.getId()%>"><%=department.getDepartmentName()%></option>
										<%}%>
								</select>
										
								
								<div id="divName">	
								
									  <label>Unit Name</label>
      									<select name="unitId" 	tabindex=2>
											<option value="0">Select</option>
										</select>						
			
																
								</div>								
								</div>	
								
								
								<div id="divNameAnother"></div>							
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
								</form>
							<script>

								function displayUnitCounter(obj){
									 submitProtoAjaxWithDivName('doctorCounterMapping','/hms/hms/hospital?method=showDoctorCounterValues&departmentId='+obj,'divName');
										 
									
								}
								function displayEmp(object,obj){
									 submitProtoAjaxWithDivName('doctorCounterMapping','/hms/hms/hospital?method=showEmpValues&hospitalDoctorUnitId='+object+'&departmentId='+obj,'divNameAnother');
										 
									
								}
								function checkDisbale(obj, rowCount) {
									var totalCheckBoxCount = document.getElementById('total'+rowCount).value;
									var element;
									if (obj.checked){
											for (var i = 0; i <= totalCheckBoxCount ; i++){
												element = document.getElementById('row'+rowCount+i);
												if (element==obj){
													element.disabled = false;
							  					}else{
							  						element.disabled = true;
							  					}
											}
							  		}else{
							  			for (var i = 0; i <= totalCheckBoxCount ; i++){
											element = document.getElementById('row'+rowCount+i);
											element.disabled = false;
							  			}
							  		}
									
							  	}
								</script>


