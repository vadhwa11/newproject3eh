
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.*"%>
<%@ page import="jkt.hms.masters.business.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
 
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<%	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	Map map = new HashMap();
		String includedJsp="";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			
		}
		
		List<Object[]> userHospitalList = new ArrayList<Object[]>();
		if(map.get("userHospitalList")!=null){
			userHospitalList = (List<Object[]>)map.get("userHospitalList");
		}
		
				
		String userName = "";
		
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		List userList = new ArrayList();
		if(map.get("userList") != null)
		{
			userList=(List) map.get("userList");
		}
		int userId=0;
		if(map.get("userId") != null)
		{
			userId=(Integer) map.get("userId");
		}
		int hospitalIdFromSession=0;
		if(map.get("hospitalId") != null)
		{
			hospitalIdFromSession=(Integer) map.get("hospitalId");
		}
		List hospitalIdList=new ArrayList();
		List hospitalNameList= new ArrayList();
		 Users userObj= new Users();
	   if(userList != null && userList.size()>0)
	   {
		   String username= "";
		   String loginName= "";
		   String serviceNo=null;
		   userObj=(Users)userList.get(0);
		   
		   Set set=new HashSet();
		   set=userObj.getUserUsergroupHospitals();
		   Iterator itr= set.iterator();
		   while(itr.hasNext())
		   {
		   UserUsergroupHospital userUsergroupHospital=(UserUsergroupHospital)itr.next();
		   UsergroupHospital usergroupHospital=(UsergroupHospital)userUsergroupHospital.getGroupHospital();
		   int hospitalId=usergroupHospital.getHospital().getId();
		   String hospitalName=usergroupHospital.getHospital().getHospitalName();
		   hospitalIdList.add(hospitalId);
		   hospitalNameList.add(hospitalName);
		   }
		   
		   
		   String employeeCode=userObj.getEmployee().getEmployeeCode();
		   String email=userObj.getEmailAddress();
		  
	     //  String patientName=inPatientDetail.getHin().getPFirstName()+inPatientDetail.getHin().getPMiddleName()+inPatientDetail.getHin().getPLastName();
	    	 if(userObj.getUserName() != null)
			   {
	    		 username=userObj.getUserName();
			   }
			
			if(userObj.getLoginName() != null)
			{
				loginName=userObj.getLoginName();	
			}
	      
	%>


<div class="titleBg">
<h2>User Management</h2>
</div>
<div class="clear"></div>

<div class="clear"></div>
<form name="userManagement" method="post" action=""><input
	type="hidden" name="userId" value="<%=userId %>" validate="User,int,no"/>

<h4>User Details</h4>
<div class="clear"></div>

<div class="Block">
<div class="clear"></div>

<label>User Name:</label> <label class="value"> <%= username %></label>


<label>Login Name:</label> <label class="value"> <%=loginName %></label>

<label>Employee Code:</label> <%if(userObj.getEmployee() != null){ %> <label
	class="value"> <%=employeeCode %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Email Add:</label> <%if(userObj.getEmailAddress() != null){ %>
<label class="value"> <%=email %></span>
<div class="clear"></div>
<%}else{ %> <label class="value">-</label> <%} %>

<div class="clear"></div>
<%
			}
		%>
</div>

<%
		if(map.get("message") != null){
		   String message = (String)map.get("message");
		 %>
<h4><%=message %></h4>
<%}
    %>
<div class="paddingTop15"></div>
<label><span>*</span>Hospital Name </label> <select name="hospitalId" validate="Hospital Name,metachar,yes"
	onchange="submitProtoAjax('userManagement','superAdmin?method=getGroupList')"
	class="large">
	<option value="0">Select</option>

	<%
			 /*  Set hospitalNameSet=new HashSet();
			   Set hospitalIdSet=new HashSet();
				Iterator itr=hospitalIdList.iterator();
				int j=0;
				while(itr.hasNext()){
			    	int hospitalId= (Integer) itr.next();
					String hospitalName=(String)hospitalNameList.get(j);
					hospitalNameSet.add(hospitalName);
					hospitalIdSet.add(hospitalId);
					j++;
				}
					
					List hospitalNameListFromSet=new ArrayList();
					boolean bool=hospitalNameListFromSet.addAll(hospitalNameSet);
				int i=0;
				Iterator iter=hospitalIdSet.iterator();
			    while(iter.hasNext()){
			    	int hospitalId= (Integer) iter.next();
					String hospitalName=(String)hospitalNameListFromSet.get(i);	
					if(hospitalId==hospitalIdFromSession){*/
				
						
						
			%>
			<%-- <option value="<%=hospitalId%>" selected><%=hospitalName%></option> --%>
			
<%-- 	<option value="<%=userObj.getEmployee().getHospital().getId()%>"
		selected><%=userObj.getEmployee().getHospital().getHospitalName()%></option> --%>

	<% /*} 	else{ */
		
		%>
		<%-- <option value="<%=hospitalId%>" ><%=hospitalName%></option> --%>
	<% //} 
			/*   i++;
			  
			 } */
			%>
			
			<%
				for(Object[] obj : userHospitalList){
					if(obj[0].equals(hospitalIdFromSession)){
			%>
			<option value="<%=obj[0]%>" selected="selected"><%=obj[1]%></option>
			<%} 	else{
		
		%>
		<option value="<%=obj[0]%>" ><%=obj[1]%></option>
	<% } 
			} %>
</select>

<div id="testDiv"></div>



<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>


<script type="text/javascript">
  
  	function getGroupList(formName,action){
  		
		var hospitalIdObj = eval('document.'+formName+'.hospitalId')
		var hospitalId = hospitalIdObj.value;
		errorMsg ="";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		if(hospitalId != ""){
			obj = eval('document.'+formName)
			       	obj.action = action;
		    	   	 var url=action+"&"+getNameAndData(formName)
		        	
		        	new Ajax.Updater('hinDiv',url,
					   {asynchronous:true, evalScripts:true }); 
		}	
		return true;
   }
  </script>
<script language="Javascript" type="text/javascript">
            		submitProtoAjax('userManagement','superAdmin?method=getGroupList')
            	</script>