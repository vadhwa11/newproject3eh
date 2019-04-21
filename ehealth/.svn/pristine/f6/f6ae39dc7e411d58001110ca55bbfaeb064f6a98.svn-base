

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.masters.business.*"%>

<%@page import="jkt.hms.masters.business.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
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
		int pageNo=1;
		if(map.get("pageNo")!=null)
			pageNo = Integer.parseInt(""+map.get("pageNo"));

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
		GroupApplication groupApplicationObj=new GroupApplication();
		String applicationId="";
		if(applicationListGroupWise!=null&&applicationListGroupWise.size()>0){
		 groupApplicationObj=(GroupApplication)applicationListGroupWise.get(0);
		}
		if(groupApplicationObj.getApp()!=null){
		 applicationId=groupApplicationObj.getApp().getId();
		 }
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
<div class="titleBg">
<h2>User Application Management</h2>
</div>
<div class="clear"></div>
<form name="groupApplication" method="post" action="">
<div class="paddingTop15"></div>
<h4>User Details</h4>
<div class="clear"></div>

<div class="Block"><label>User Name</label> <label class="value">
<%= username %></label> <label>Login Name</label> <label class="value">
<%=loginName %></label> <label>Employee Code</label> <%if(userObj.getEmployee() != null){ %>
<label class="value"><%=employeeCode %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Email Add</label> <%if(userObj.getEmailAddress() != null){ %>
<label class="value"> <%=email %></label> <%}else{ %> <label class="value">-</label>
<%} %>

<div class="clear"></div>
<%
			}
		%>
</div>
<div class="clear"></div>
<div class="division"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<table width="100%" align="left" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th>S.No.</th>
			<th>Application Id</th>
			<th>Application Description</th>
			<th>Assigned</th>
		</tr>
	</thead>
	<tbody id="tableData">
		<%


           		Iterator iterator = applicationListGroupWise.iterator();

           		GroupApplication groupApplication = null;
           		int i=0;
   				while (iterator.hasNext())
   				{

   					groupApplication = (GroupApplication) iterator.next();
					String masterAppId = groupApplication.getApp().getId();
					if(!groupApplication.getApp().getId().equals("0"))
					{
						i++;
	        %>
		<tr class="<% if(i %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><%=i%></td>
			<td><%=groupApplication.getApp().getId()%></td>
			<td>
			<%
		  			String parentId=null;
		  			 	if(groupApplication.getApp().getUrl().equals("#"))
		  			 	{
		  			 		String appName=groupApplication.getApp().getName();
		  			 		parentId=groupApplication.getApp().getParentId();
		  			 		if(!parentId.equals("0")){


		  			%> <em><b><%=groupApplication.getApp().getApplication().getName()%></b></em>
			&nbsp;>>&nbsp;<%=groupApplication.getApp().getName()%></td>
			<%
                        	String bool="false";
                        	for(Iterator itr=userUsergroupApplicationList.iterator();itr.hasNext();){

                        	UserUsergroupApplication userUsergroupApplication=(UserUsergroupApplication)itr.next();
                        	int groupAppId=userUsergroupApplication.getGroupApp().getId();
                        	int hospitalIdFromTable=userUsergroupApplication.getGroupHospital().getHospital().getId();
                        	if(hospitalIdFromTable==hospitalId){
                        	if(groupAppId==groupApplication.getId()){
                        	  bool="true";

                        %>

			<td><input type="checkbox" name="groupApplicationId"
				value="<%=groupApplication.getId()%>" class="none" checked="true" /></td>

			<%
                      	break;
                      	}}}if(bool.equals("false")) {%>
			<td><input type="checkbox" name="groupApplicationId"
				value="<%=groupApplication.getId()%>" class="none" /></td>
			<%
                    	}}
                      	else
                      	{

                    %>
			<b><i><%=groupApplication.getApp().getName()%></i></b>
			</td>
			<%
	                      	String bool="false";
	                    	for(Iterator itr=userUsergroupApplicationList.iterator();itr.hasNext();){

	                    	UserUsergroupApplication userUsergroupApplication=(UserUsergroupApplication)itr.next();
	                    	int groupAppId=userUsergroupApplication.getGroupApp().getId();
	                    	int hospitalIdFromTable=userUsergroupApplication.getGroupHospital().getHospital().getId();
                        	if(hospitalIdFromTable==hospitalId){
	                    	if(groupAppId==groupApplication.getId()){
	                    	  bool="true";
                      	%>
			<td><input type="checkbox" name="groupApplicationId"
				value="<%=groupApplication.getId()%>" class="none" checked="true" /></td>
			<%
                      	    break;
                      		}}}if(bool.equals("false")) {%>
			<td><input type="checkbox" name="groupApplicationId"
				value="<%=groupApplication.getId()%>" class="none" /></td>
			<%
                      	}}}
		  			 	else{
		  			 		 String parentName=groupApplication.getApp().getApplication().getName();
		  			 		 String parentid=groupApplication.getApp().getApplication().getId();

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
			<b><i><%=appname%></i></b>
			&nbsp;>>&nbsp;
			<b><i><%=groupApplication.getApp().getApplication().getName()%></i></b>
			&nbsp;>>&nbsp;<%=groupApplication.getApp().getName()%>
			</td>
			<%
	                      	String bool="false";
	                    	for(Iterator iter=userUsergroupApplicationList.iterator();iter.hasNext();){

	                    	UserUsergroupApplication userUsergroupApplication=(UserUsergroupApplication)iter.next();
	                    	int groupAppId=userUsergroupApplication.getGroupApp().getId();
	                    	int hospitalIdFromTable=userUsergroupApplication.getGroupHospital().getHospital().getId();
                        	if(hospitalIdFromTable==hospitalId){
	                    	if(groupAppId==groupApplication.getId()){
	                    	  bool="true";
                      	%>
			<td><input type="checkbox" name="groupApplicationId"
				value="<%=groupApplication.getId()%>" class="none" checked="true" /></td>
			<%
                       		 break;
                        	}}}if(bool.equals("false")) {%>
			<td><input type="checkbox" name="groupApplicationId"
				value="<%=groupApplication.getId()%>" class="none" /></td>
			<%
                        }}}
		  			 	  }else{
		  			 %>
			<b><i><%=groupApplication.getApp().getApplication().getName()%></i></b>
			 &nbsp;>>&nbsp;<%=groupApplication.getApp().getName()%>
			</td>
			<%
	                      	String bool="false";
	                    	for(Iterator iter=userUsergroupApplicationList.iterator();iter.hasNext();){

	                    	UserUsergroupApplication userUsergroupApplication=(UserUsergroupApplication)iter.next();
	                    	int groupAppId=userUsergroupApplication.getGroupApp().getId();
	                    	int hospitalIdFromTable=userUsergroupApplication.getGroupHospital().getHospital().getId();
                        	if(hospitalIdFromTable==hospitalId){
	                    	if(groupAppId==groupApplication.getId()){
	                    	  bool="true";
                      	%>
			<td><input type="checkbox" name="groupApplicationId"
				value="<%=groupApplication.getId()%>" class="none" checked="true" /></td>
			<%
		  			  		break;
	                    	}}}if(bool.equals("false")) {%>
			<td><input type="checkbox" name="groupApplicationId"
				value="<%=groupApplication.getId()%>" class="none" /></td>
			<%
		  			 	} }
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
<input type="hidden" id="countVal" value="<%=i%>" /> <input
	type="hidden" id="chkStatus" value="no"/> <input type="hidden"
	name="applicationId" value="<%=applicationId %>" validate="applicationId,int,no"/> <input
	type="hidden" name="userId" value="<%=userId %>" validate="userId,int,no"/> <input
	name="userIdNew" id="userIdNew" type="hidden" value="<%=userId %>" validate="userIdNew,int,no"/>
<input type="hidden" name="groupHospitalId"
	value="<%=groupHospitalId %>" validate="groupHospitalId,int,no"/>
	<input type="hidden" name="pageEditNo" id="pageEditNo" value="<%=pageNo %>" validate="pageEditNo,int,no"/>
	<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
	  </script>
  <div class="clear"></div>
<div class="paddingTop15"></div>
<input type="button" name="save" value="Submit" class="button" onClick="submitForm('groupApplication','/hms/hms/superAdmin?method=submitUserWiseApplication');" />
<input type="button" name="Back" value="Back" class="button" onClick="submitForm('groupApplication','/hms/hms/superAdmin?method=showUserManagementJsp');" />
  <div class="clear"></div>
<div class="paddingTop40"></div>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>





