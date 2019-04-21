

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
		List<UserUsergroupHospital> usersList= new ArrayList<UserUsergroupHospital>();
		List<UserEmpGroup> userEmpGroupList= new ArrayList<UserEmpGroup>();
		List<UserUsergroupApplication> userUGAppList= new ArrayList<UserUsergroupApplication>();
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		
	  
		
		if (map.get("userEmpGroupList") != null)
			userEmpGroupList =(List<UserEmpGroup>)map.get("userEmpGroupList");
		
		List<UserButtonRights> buttonList= new ArrayList<UserButtonRights>();
		if (map.get("buttonList") != null){
			buttonList =(List<UserButtonRights>)map.get("buttonList");
		}
		String formName="";
		if (map.get("formName") != null)
			formName =(String)map.get("formName");
		
		int userId=0;
		if (map.get("userId") != null)
			userId =(Integer)map.get("userId");
		
%>

<table cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="15">S.No</th>
			<th>Button Name</th>
			<th><input type="checkbox" class="checkbox"
				onclick="checkAll();" />Select Button</th>
		</tr>
	</thead>
	<tbody id="searchresulttable">
		<%	
           		Iterator iterator = buttonList.iterator();
			    UserButtonRights userButtonForm = null;
           		int i=0;
   				while (iterator.hasNext()) 
   				{
   					
   					userButtonForm = (UserButtonRights) iterator.next();
					
					
						i++;
	        %>
		<tr class="<% if(i %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><%=i%></td>
			<td><%=userButtonForm.getButton().getButtonName()%></td>
			<td><input type="checkbox" id="chk<%=i %>"
				value="<%=userButtonForm.getButton().getId()%>" name="userButtonId" />
		</tr>
		<%}%>
	</tbody>
</table>







<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" id="countValForButton" value="<%=i%>" />
<input type="hidden" name="userIdNew" value="<%=userId%>" />
<input type="hidden" id="formName" value="<%=formName%>" />
<input type="hidden" id="chkStatus" value="no" />
<input type="button" name="removeRights" value="Remove Button Rights"
	class="buttonBig2"
	onClick="if(checkBlank()){submitForm('removeButtonRightsForm','superAdmin?method=removeButtonRights');}" />
<input type="button" name="Back" value="Back" class="button"
	accesskey="b"
	onclick="submitFormForButton('removeButtonRightsForm','superAdmin?method=showRemoveButtonRights')"
	tabindex=1 />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>






