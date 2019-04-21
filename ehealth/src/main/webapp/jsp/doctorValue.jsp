
<%@page import="jkt.hms.masters.business.MasServiceCentreCounter"%>
<%@page import="jkt.hms.masters.business.HospitalDoctorUnitM"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<script language="javascript" type="text/javascript" 	src="/hms/jsp/js/ajax.js"></script>




<%
	    Map map=new HashMap();	
        Map<String,Object> utilMap = new HashMap<String,Object>();
         List<MasServiceCentreCounter> masServiceCentreCounterList=new ArrayList<MasServiceCentreCounter>();
    	
    	
		  if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		        }

			
			List<Object[]> hospitalDoctorUnitMList = new ArrayList<Object[]>();
			if(map.get("hospitalDoctorUnitMList")!=null){
				hospitalDoctorUnitMList = (List<Object[]>)map.get("hospitalDoctorUnitMList");
			}
             if(map.get("masServiceCentreCounterList") != null){
            	 masServiceCentreCounterList = (List<MasServiceCentreCounter>)map.get("masServiceCentreCounterList");
	
			} 
             int departmentId=0;
             
             if(map.get("departmentId") != null){
            	 departmentId = (Integer)map.get("departmentId");
	
			} 
		   %>


<form name="doctorCounterMapping" method="post" action="" enctype="">
	<div id="divName">
      <label>Unit Name</label>
      <select name="unitId" onchange="displayEmp(this.value,<%=departmentId%>);" 	tabindex=2>
	<option value="0">Select</option>
					
				<%
				for(Object[] obj : hospitalDoctorUnitMList){
					
			%>
			<option value="<%=obj[0]%>"><%=obj[1]%></option>
			
	<% } 
			 %>
			</select>
	
		
		

		
		
	</div>
<div class="clear"></div>
  


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>


