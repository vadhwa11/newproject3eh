<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.UserTemplate"%>
<%@page import="jkt.hms.masters.business.MasTemplate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<Object[]> masEmployeeList = new ArrayList<Object[]>();
	List<MasTemplate> masTemplateList = new ArrayList<MasTemplate>();
	
	if(map.get("masEmployeeList")!=null){
		masEmployeeList =(List) map.get("masEmployeeList");
		
	}
	if(map.get("masTemplateList")!=null){
		masTemplateList =(List) map.get("masTemplateList");
	}
	
	List<UserTemplate> userTemplateList = new ArrayList<UserTemplate>();
	if(map.get("userTemplateList")!=null){
		userTemplateList =(List) map.get("userTemplateList");
	}
	int userType = 0; /* user type 4 for general user */
	if(session.getAttribute("users") != null){
		 Users user = (Users)session.getAttribute("users");
		 userType = user.getUserType()!=null?user.getUserType():4;
	}
	
	%>
	<script type="text/javascript">$j.noConflict();</script>
<div class="userRights">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<thead>
	<tr>
	<%
	
	if(masTemplateList.size()>0){
		
		%>
		<th>Name</th>
		<%
		for(MasTemplate masTemplate :masTemplateList){
	%>
	<!-- day+"/"+month+"/"+year -->
	<th><%=masTemplate.getTemplateName()%></th>
	<%
	}
	}
	
	%>
	</tr>
	</thead>
	<tbody>
	<%
	int counter=0;
	int chgCnt = 0;
	if(masEmployeeList.size()>0){
		//for(MasEmployee masEmployee:masEmployeeList){
			for (Iterator iterator = masEmployeeList.iterator(); iterator.hasNext();) {
				
				Users user = (Users) iterator.next();
				 int userTypeDb = 4;
	        	  if(userType>0){
					if (user.getUserType() != null) {
						userTypeDb = user.getUserType();
					}
				}
				if (userTypeDb != 0) {
			
			++counter;
			String employeeName="";
			String EmployeeCode = "";
			
			
				if(user.getEmployee()!=null)
				{
					//EmployeeCode = user.getEmployee().getEmployeeCode();
					EmployeeCode = user.getLoginName();
				}
			if(user.getEmployee().getEmployeeName()!=null){
				employeeName = user.getEmployee().getEmployeeName();
			}else{
				employeeName=employeeName+" "+user.getEmployee().getFirstName();
				if(user.getEmployee().getMiddleName()!=null){
					employeeName=employeeName+" "+user.getEmployee().getMiddleName();
				}
				if(user.getEmployee().getLastName()!=null){
					employeeName=employeeName+" "+user.getEmployee().getLastName();
				}
			}
			String toolTip="";
			toolTip=employeeName;
	%>
		<tr>
		<%  
			if(EmployeeCode != null && !EmployeeCode.equals(""))
			{
				%>
					<th><%=employeeName %>  (<%=EmployeeCode %>)
				<%
			}
			else
			{
				%>
					<th><%=employeeName %>
				<%
			}
		%>
			
			<input type="hidden" name="empId<%=counter%>" id="empId<%=counter%>" value="<%=(user.getEmployee()!=null?user.getEmployee().getId():"0")%>" />
			<input type="hidden" name="userId<%=counter%>" id="userId<%=counter%>" value="<%=user.getId()%>" />
			
			</th>
		<%
		int templetCnt=0;
		if(masTemplateList.size()>0){
			for(MasTemplate masTemplate :masTemplateList){
				++templetCnt;
				boolean assignedTemplate=false;
				String assignedTemplateName="";
				assignedTemplateName=masTemplate.getTemplateName();
				int preTempletId=0;
				if(userTemplateList.size()>0){
					int templateIdMain=masTemplate.getId();
					
					for(UserTemplate userTemplate:userTemplateList){
						int templateIdTemp=0;
						
							templateIdTemp=userTemplate.getTemplate().getId();
						

						if(userTemplate.getUser().getId().equals(user.getId()) && templateIdTemp==templateIdMain){
							preTempletId=userTemplate.getTemplate().getId();
							assignedTemplate=true;
							break;
						}
					}
				}
				assignedTemplateName=toolTip+" # "+assignedTemplateName+" ";
		%>
		<td align="center" title="<%=assignedTemplateName%>">
		<%if(assignedTemplate){ %>
		<input type="checkbox" checked="checked" name="templetId<%=templetCnt%>" id="templetId<%=templetCnt%><%=counter%>" value="<%=masTemplate.getId()%>"  onclick="setHiddenTempId(this,<%=templetCnt%><%=counter%>,'<%=masTemplate.getTemplateName() %>',<%=chgCnt %>)"/>
		<input type="hidden" name="templetIdHidden<%=counter%>" id="<%=masTemplate.getTemplateName() %><%=templetCnt%><%=counter%>" value="<%=masTemplate.getId()%>" />
		<%}else{ %>
	
		<input type="checkbox"  name="templetId<%=templetCnt%>" id="templetId<%=templetCnt%><%=counter%>" value="<%=masTemplate.getId()%>" onclick="setHiddenTempId(this,<%=templetCnt%><%=counter%>,'<%=masTemplate.getTemplateName() %>',<%=chgCnt %>)" />
			<input type="hidden" name="templetIdHidden<%=counter%>" id="<%=masTemplate.getTemplateName() %><%=templetCnt%><%=counter%>" value="0" />
	<%} %>
	 	<input type="hidden" name="preTempletId<%=counter%>" id="preTempletId<%=templetCnt%><%=counter%>" value="<%=preTempletId%>" />
		<input type="hidden" name="changeFlag<%=counter%>" id="changeFlag<%=chgCnt %><%=templetCnt%><%=counter%>" value="no" />
	</td>
		<%
		}
		}
		%>			
		</tr>
		
	<%		
		chgCnt++;}}
	}
	%>
	</tbody>

</table>
	<input type="hidden" name="counter" id="counter" value="<%=counter%>" />
	<input type="hidden" name="templetCnt" id="templetCnt" value="<%=masTemplateList.size()%>" />
</div>