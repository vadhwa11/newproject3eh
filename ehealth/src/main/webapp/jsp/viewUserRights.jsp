

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.masters.business.*"%>

<%@page import="jkt.hms.masters.business.*"%>



<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%
	
		Map map = new HashMap();
		List<Object> applicationListGroupWise = new ArrayList<Object>();
		List<Object>masApplicationList= new ArrayList<Object>();
		List<Object>userUsergroupApplicationList= new ArrayList<Object>();
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("applicationListGroupWise") != null)
			applicationListGroupWise =(List)map.get("applicationListGroupWise");
  	    
		if (map.get("masApplicationList") != null)
			masApplicationList =(List)map.get("masApplicationList");
		
		if (map.get("userUsergroupApplicationList") != null)
			userUsergroupApplicationList =(List)map.get("userUsergroupApplicationList");
	
		int groupHospitalId= 0;
		int userId=0;
		int hospitalId=0;
		if (map.get("groupHospitalId") != null)
			groupHospitalId =(Integer)map.get("groupHospitalId");
	
		if (map.get("userId") != null)
			userId =(Integer)map.get("userId");
		
		if (map.get("hospitalId") != null)
			hospitalId =(Integer)map.get("hospitalId");
		
		List<Object>userList= new ArrayList<Object>();
		if (map.get("userList") != null)
			userList =(List)map.get("userList");
		
		
		 if(userList != null)
		   {
			   String username= "";
			   String loginName= "";
			   String serviceNo=null;
			   Users userObj=(Users)userList.get(0);
			   String employeeCode=userObj.getEmployee().getEmployeeCode();
			   String email=userObj.getEmailAddress();
			  
		    	 if(userObj.getUserName() != null)
				   {
		    		 username=userObj.getUserName();
				   }
				
				if(userObj.getLoginName() != null)
				{
					loginName=userObj.getLoginName();	
				}
%>
<script>
function checkAll(){


 if(document.getElementById("chkStatus").value =="no"){
   document.getElementById("chkStatus").value ="yes"
   for(var i=1;i<=document.getElementById("countVal").value;i++){
    document.getElementById("chk"+i).checked =true
  }
  }else{
 document.getElementById("chkStatus").value ="no"
   for(var i=1;i<=document.getElementById("countVal").value;i++){
    document.getElementById("chk"+i).checked =false
  }
  }
  

}
</script>
<div class="titleBg">
<h2>User Application Rights</h2>
</div>
<div class="clear"></div>

<form name="userApplicationRights" method="post" action="">
<h4>User Details</h4>
<div class="clear"></div>
<div class="Block"><label>User Name</label> <label class="value">
<%= username %></label> <label>Login Name</label> <label class="value">
<%=loginName %></label> <label>Employee Code</label> <%if(userObj.getEmployee() != null){ %>
<label class="value"><%=employeeCode %></label> <%}else{ %> <label
	class="value">-</label> <%} %>
<div class="clear"></div>
<label>Email Address</label> <%if(userObj.getEmailAddress() != null){ %> <label
	class="value"> <%=email %></label> <%}else{ %> <label class="value">-</label>
<%} %>

<div class="clear"></div>
<%
			}
		%>
<div class="clear"></div>
</div>
<div class="clear"></div>

<div class="paddingTop15"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<table id="tableData">
	<thead>
		<tr>
			<th width="15">S.No</th>
			<th>Application Id</th>
			<th>Application Description</th>
			<th><input type="checkbox" class="checkbox" disabled />
			Assigned</th>
		</tr>
	</thead>
	<tbody id="searchresulttable">
		<%	
				
           		
           		Iterator iterator = userUsergroupApplicationList.iterator();
           		
           		UserUsergroupApplication groupApplication = null;
           		int i=0;
   				while (iterator.hasNext()) 
   				{
   					
   					groupApplication = (UserUsergroupApplication) iterator.next();
					String masterAppId = groupApplication.getGroupApp().getApp().getId();
					if(!groupApplication.getGroupApp().getApp().getId().equals("0"))
					{
						i++;
	        %>
		<tr class="<% if(i %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><%=i%></td>
			<td><%=groupApplication.getGroupApp().getApp().getId()%></td>
			<td>
			<%
		  			String parentId=null;
		  			 	if(groupApplication.getGroupApp().getApp().getUrl().equals("#"))
		  			 	{
		  			 		String appName=groupApplication.getGroupApp().getApp().getName();
		  			 		parentId=groupApplication.getGroupApp().getApp().getParentId();
		  			 		if(!parentId.equals("0")){
		  			 			
		  			 		
		  			%> <em><b><%=groupApplication.getGroupApp().getApp().getApplication().getName()%></b></em>
			&nbsp;>>&nbsp;<%=groupApplication.getGroupApp().getApp().getName()%>
			</td>


			<td><input type="checkbox" id="chk<%=i%>"
				name="groupApplicationId"
				value="<%=groupApplication.getGroupApp().getId()%>" class="none"
				checked="true" disabled /></td>



			<%
                    	}
                      	else
                      	{
                      		
                    %>
			<td><b><i><%=groupApplication.getGroupApp().getApp().getName()%></i></b>
			</td>

			<td><input type="checkbox" id="chk<%=i%>"
				name="groupApplicationId"
				value="<%=groupApplication.getGroupApp().getId()%>" class="none"
				checked="true" disabled /></td>

			<%	
                      	}}
		  			 	else{
		  			 		 String parentName=groupApplication.getGroupApp().getApp().getApplication().getName();
		  			 		 String parentid=groupApplication.getGroupApp().getApp().getApplication().getId();
		  			 		
		  			 			for(Iterator itr=masApplicationList.iterator();itr.hasNext();)
		  			 			{
		  			 				MasApplication masApplication=(MasApplication)itr.next();
		  			 				String appId=masApplication.getId();
		  			 				String appName=masApplication.getName();
		  			 				String pId=masApplication.getParentId();
		  			 				if(appId.equals(parentid)){
		  			 					if(!pId.equals("0")){
		  			 						for(Iterator itr1=masApplicationList.iterator();itr1.hasNext();)
		  			 						{
		  			 							MasApplication masAppObj=(MasApplication)itr1.next();
		  			  			 				String appname=masAppObj.getName();
		  			  			 				String appid=masAppObj.getId();
		  			  			 				if(appid.equals(pId)){
		  			 						
		  			 					
		  			 					
		  			 				
		  			 				
                    %>
			<td><b><i><%=appname%></i></b>&nbsp;>>&nbsp;<b><i><%=groupApplication.getGroupApp().getApp().getApplication().getName()%></i></b>&nbsp;>>&nbsp;<%=groupApplication.getGroupApp().getApp().getName()%>
			</td>

			<td><input type="checkbox" id="chk<%=i%>"
				name="groupApplicationId"
				value="<%=groupApplication.getGroupApp().getId()%>" class="none"
				checked="true" disabled /></td>

			<%	
                        }}
		  			 	  }else{
		  			 %>
			<td><b><i><%=groupApplication.getGroupApp().getApp().getApplication().getName()%></i></b> &nbsp;>>&nbsp;<%=groupApplication.getGroupApp().getApp().getName()%>
			</td>

			<td><input type="checkbox" id="chk<%=i%>"
				name="groupApplicationId"
				value="<%=groupApplication.getGroupApp().getId()%>" class="none"
				checked="true" disabled /></td>

			<%		  
		  			 	}
		  			 	}
		  			 	}}
		  			 	 %>
		</tr>

		<%
					}
				}
		 	%>
	</tbody>
</table>
<input type="hidden" id="countVal" value="<%=i%>" validate="countVal,int,no"/> <input
	type="hidden" id="chkStatus" value="no" /> <input type="hidden"
	name="userId" value="<%=userId %>" validate="userId,int,no"/> <input type="hidden"
	name="hospitalId" value="<%=hospitalId%>" validate="hospitalId,int,no"/> <script>
		var pager = new Pager('tableData',10); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);
	  </script>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" name="Back" value="Back" class="button"
	onClick="submitForm('userApplicationRights','/hms/hms/superAdmin?method=showModuleManagementJsp');" />
<input type="button" name="removeRights" value="Remove All Rights"
	class="buttonBig"
	onClick="if(confirmMessage()){submitForm('userApplicationRights','/hms/hms/superAdmin?method=removeUserRights');}" />
<div class="clear"></div>
<div class="division"></div>
<div class="paddingTop40"></div>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>
<script type="text/javascript">
	  function confirmMessage(){
	
	  		if(confirm("Are You sure, You want to Remove All User Rights ?"))
					return true;
				else
					return false;
		}
			
		</script>

