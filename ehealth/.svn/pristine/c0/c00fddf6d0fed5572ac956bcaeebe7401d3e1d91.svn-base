
<%@page import="jkt.hms.util.User"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasServiceCentreCounter"%>
<%@page import="jkt.hms.masters.business.HospitalDoctorUnitT"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<script language="javascript" type="text/javascript"
	src="/hms/jsp/js/ajax.js"></script>




<%
	    Map map=new HashMap();	
        Map<String,Object> utilMap = new HashMap<String,Object>();
        List<HospitalDoctorUnitT> hospitalDoctorUnitTList=new ArrayList<HospitalDoctorUnitT>();
        List<MasServiceCentreCounter> masServiceCentreCounterList = new ArrayList<MasServiceCentreCounter>();
        List<Users> userList = new ArrayList<Users>();
        
    	
		  if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		        }
	 
             if(map.get("hospitalDoctorUnitTList") != null){
            	 hospitalDoctorUnitTList = (List<HospitalDoctorUnitT>)map.get("hospitalDoctorUnitTList");
	
			}  
			
             if(map.get("masServiceCentreCounterList") != null){
            	 masServiceCentreCounterList = (List<MasServiceCentreCounter>)map.get("masServiceCentreCounterList");

             } 
   
             if(map.get("userList") != null){
            	 userList = (List<Users>)map.get("userList");
	
			} 
   
             
             
		   %>
		
			
			
		<table>
		<tbody>
		<%
		   	
		if(masServiceCentreCounterList.size()>0)
		{
								%>
			<tr>
				
			<th>Doctor's Name</th>
			<%-- <%
			for(MasServiceCentreCounter masServiceCentreCounter: masServiceCentreCounterList)
			{
			%> --%>
			<th>
			Available today
			</th>
		
	<%-- <% }%> --%>
</tr>


<%
		int i=0;
		if(hospitalDoctorUnitTList.size()>0)
		{
		%>
	
			
			<%
			for(HospitalDoctorUnitT hosp: hospitalDoctorUnitTList)
			{
			
						i++;
			%>
			<tr>
			
			<td><%=hosp.getEmployee().getEmployeeName().trim()%></td>
				<%
					int counterId=0;	
					int j=0;
					int userId = 0;
					String availability=null;
					for(Users u:userList)
					{
						if(u.getEmployee().getId().equals(hosp.getEmployee().getId()))
						{	
							counterId=u.getCurrentCounter()!=null?u.getCurrentCounter().getId():0;
							userId = u.getId();
							availability = u.getAvailableToday();
							break;
						}
					}
					/* for(j=0;j<masServiceCentreCounterList.size();j++){
						int cntId = masServiceCentreCounterList.get(j).getId(); */
							if(availability!=null && availability.equals("y"))
							{
								
				%>
				
			<td>	
				
				<input type="hidden" value="<%=userId%>" name="userId<%=i%>" >
				<input type="checkbox" id="row<%=i%><%=j%>" checked="checked"  name="chk<%=i%>" value="y" onclick="checkDisbale(this,'<%=i%>')" >
			</td>
			<%}else{ %>
			<td>	
				
				<input type="hidden" value="<%=userId%>" name="userId<%=i%>" >
				<input type="checkbox" id="row<%=i%><%=j%>" name="chk<%=i%>" value="y" onclick="checkDisbale(this,'<%=i%>')" >
				
			</td>
				<%}%>
			<%-- <%} %> --%>
			<input type="hidden" id="total<%=i%>" value="<%=j%>" >	
		</tr>
		<% }%>	
			
		<%} %>
			<input type="hidden" name="totalrecord" value="<%=i %>" />


<%} %>
		

  </tbody>
  </table>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">


<input type="button" name="Add"  value="Submit"	class="button" 	onClick="submitForm('doctorCounterMapping','hospital?method=editDoctorCounterMapping')"	accesskey="u" tabindex=1 />
<input type="button" name="Reset"	value="Reset" class="button" />


