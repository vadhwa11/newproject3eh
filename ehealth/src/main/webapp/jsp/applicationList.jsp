

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.masters.business.*"%>

<%@page import="jkt.hms.masters.business.*"%>



<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
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
		List<UserUsergroupHospital> usersList= new ArrayList<UserUsergroupHospital>();
		List<UserEmpGroup> userEmpGroupList= new ArrayList<UserEmpGroup>();
		List<UserUsergroupApplication> userUGAppList= new ArrayList<UserUsergroupApplication>();
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("applicationListGroupWise") != null)
			applicationListGroupWise =(List)map.get("applicationListGroupWise");
  	    
		if (map.get("masApplicationList") != null)
			masApplicationList =(List)map.get("masApplicationList");
		
		if (map.get("usersList") != null)
			usersList =(List<UserUsergroupHospital>)map.get("usersList");
		
		if (map.get("userUGAppList") != null)
			userUGAppList =(List<UserUsergroupApplication>)map.get("userUGAppList");
		
	    String value="";
		if (map.get("value") != null)
			value =(String)map.get("value");
		if(value.equals("true")){
		if (map.get("userEmpGroupList") != null)
			userEmpGroupList =(List<UserEmpGroup>)map.get("userEmpGroupList");
		}
		
		
		
		
		
		int groupHospitalId= 0;
		
		int hospitalId=0;
		int groupId =0;
		if (map.get("groupHospitalId") != null)
			groupHospitalId =(Integer)map.get("groupHospitalId");
	
		
		if (map.get("groupId") != null)
			groupId =(Integer)map.get("groupId");
		
		
		
		
		
		 
%>
<div class="clear"></div>
<div class="paddingtop15"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="cmntable">
<table width="100%" align="left" id="tableData" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>

			<th>S.No</th>
			<th>Application Description</th>
			<th><input type="checkbox" class="radioCheck"
				onclick="appCheckAll();" /></th>
		</tr>
	</thead>
	<tbody id="searchresulttable">
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
			<td><input type="checkbox" id="apChk<%=i%>" class="radioCheck"
				name="appId" value="<%=groupApplication.getApp().getId()%>" /></td>
			<%
                    	}
                      	else
                      	{
                    %>
			<b><i><%=groupApplication.getApp().getName()%></i></b>
			</td>
			<td><input type="checkbox" id="apChk<%=i%>" class="radioCheck"
				name="appId" value="<%=groupApplication.getApp().getId()%>" /></td>
			<%	
                      	}}
		  			 	else{
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
			<td><input type="checkbox" class="radioCheck" id="apChk<%=i%>"
				name="appId" value="<%=groupApplication.getApp().getId()%>" /></td>

			<%	
                        }}
		  			 	  }else{
		  			 %>
			<b><i><%=groupApplication.getApp().getApplication().getName()%></i></b>
			�&nbsp;>>&nbsp;<%=groupApplication.getApp().getName()%>
			</td>
			<td><input type="checkbox" id="apChk<%=i%>" name="appId"
				value="<%=groupApplication.getApp().getId()%>" /></td>

			<%	}}}} %>

		</tr>
		<%}}%>
	</tbody>
</table>
</div>

<input type="hidden" name="groupHospitalId"
	value="<%=groupHospitalId %>" />
<input type="hidden" name="groupId" value="<%=groupId %>" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<script>
		var pager = new Pager('tableData',10); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);
	  </script>
<!-- other new table -->
<div class="cmntable">
<table cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="15">S.No</th>
			<th>Login Name</th>
			<th><input type="checkbox" class="radioCheck"
				onclick="checkAll();" /></th>
			<th></th>
		</tr>
	</thead>
	<tbody id="searchresulttable">
		<%	
			  
			   int k=0;
				if(userEmpGroupList!= null && userEmpGroupList.size()>0){
					for(Iterator iterr=usersList.iterator();iterr.hasNext();){
						UserUsergroupHospital userUsergroupHospital=(UserUsergroupHospital)iterr.next();
						for(Iterator iteratorr=userEmpGroupList.iterator();iteratorr.hasNext();){
							UserEmpGroup userEmpGroup=(UserEmpGroup)iteratorr.next();
						
							String boolVal="false";
							if(userEmpGroup.getUser().getId()==userUsergroupHospital.getUser().getId()){
								k++;
								Inner:	for(Iterator ite=userUGAppList.iterator();ite.hasNext();){
									UserUsergroupApplication userUsergroupApplication=(UserUsergroupApplication)ite.next();
									if(userUsergroupApplication.getUser().getId()==userUsergroupHospital.getUser().getId()){
										boolVal="true";
										break Inner;
									}
								}
				if(boolVal.equals("true")){
			%>
		<tr class="<% if(k %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><%=k%></td>
			<td><%=userUsergroupHospital.getUser().getLoginName()%></td>
			<td><input type="checkbox" class="radioCheck" id="chk<%=k%>"
				name="userId" value="<%=userUsergroupHospital.getUser().getId()%>"
				checked /></td>
			<td><input type="radio" id="rDetail" name="rDetail"
				onchange="if(checkBlank()){submitProtoAjaxWithDivNameToShowStatus('assignModuleForm','superAdmin?method=getUserRights&userId='+<%=userUsergroupHospital.getUser().getId()%>,'testDiv1');}" /></td>
		</tr>
		<%}else{
			%>
		<tr class="<% if(k %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><%=k%></td>
			<td><%=userUsergroupHospital.getUser().getLoginName()%></td>
			<td><input type="checkbox" class="radioCheck" id="chk<%=k%>"
				name="userId" value="<%=userUsergroupHospital.getUser().getId()%>" /></td>
			<td><input type="radio" id="rDetail" name="rDetail"
				onchange="if(checkBlank()){submitProtoAjaxWithDivNameToShowStatus('assignModuleForm','superAdmin?method=getUserRights&userId='+<%=userUsergroupHospital.getUser().getId()%>,'testDiv1');}" /></td>
		</tr>

		<%}
				break;}
				}}}else if(map.get("value").equals("false")){
			
           		Iterator itr =usersList.iterator();
           		UserUsergroupHospital userUsergroupHospital = null;
           		
   				while (itr.hasNext()) 
   				{
   					k++;
   					String bool="false";
   					userUsergroupHospital = (UserUsergroupHospital) itr.next();
					for(Iterator it=userUGAppList.iterator();it.hasNext();){
						UserUsergroupApplication userUsergroupApplication=(UserUsergroupApplication)it.next();
						if(userUsergroupApplication.getUser().getId()==userUsergroupHospital.getUser().getId()){
							bool="true";
							break;
						}
					}
					if(bool.equals("true")){
						
	         %>
		<tr class="<% if(k %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><%=k%></td>
			<td><%=userUsergroupHospital.getUser().getLoginName()%></td>
			<td><input type="checkbox" class="radioCheck" id="chk<%=k%>"
				name="userId" value="<%=userUsergroupHospital.getUser().getId()%>"
				checked /></td>
			<td><input type="radio" id="rDetail" name="rDetail"
				onchange="if(checkBlank()){submitProtoAjaxWithDivNameToShowStatus('assignModuleForm','superAdmin?method=getUserRights&userId='+<%=userUsergroupHospital.getUser().getId()%>,'testDiv1');}" /></td>
		</tr>
		<%}else{ %>
		<tr class="<% if(k %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><%=k%></td>
			<td><%=userUsergroupHospital.getUser().getLoginName()%></td>
			<td><input type="checkbox" class="radioCheck" id="chk<%=k%>"
				name="userId" value="<%=userUsergroupHospital.getUser().getId()%>" /></td>
			<td><input type="radio" id="rDetail" name="rDetail"
				onchange="if(checkBlank()){submitProtoAjaxWithDivNameToShowStatus('assignModuleForm','superAdmin?method=getUserRights&userId='+<%=userUsergroupHospital.getUser().getId()%>,'testDiv1');}" /></td>
		</tr>

		<%}}} %>




	</tbody>
</table>

</div>

<div id="testDiv1"></div>



<input type="hidden" id="countVal" value="<%=k%>" />
<input type="hidden" id="APCountVal" value="<%=i%>" />
<input type="hidden" id="chkStatus" value="no" />
<input type="hidden" id="apChkStatus" value="no" />


<div class="clear"></div>







