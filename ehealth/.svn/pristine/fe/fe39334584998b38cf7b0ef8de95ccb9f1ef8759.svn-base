
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasApplication"%>
<%@page import="jkt.hms.masters.business.GroupApplication"%>
<%@page import="jkt.hms.masters.business.UsergroupHospital"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script>
		function checkSearchForApplication(){
		if(document.getElementById('applicationId').value == ''){
		alert("Please enter Application Name.. ");
		return false;
		}else
		return true;
	}
	</script>
<%
	
	
	Map<String,Object> map= new HashMap<String,Object>();
	MasApplication masApp = null;
	GroupApplication groupapplication=null;
	String grpApp="";
	int group_app_id=0;
	//int orderNo=0;
	int groupApplicationId=0;
	
	if(request.getAttribute("map") != null){
		map = (Map<String,Object>)request.getAttribute("map");
	}
	%>
<% 
	String applicationId="";
	String mapplication="";
	String parentId="";
	
	
	List<MasApplication> searchApplicationList= new ArrayList<MasApplication>();
	if(map.get("searchApplicationList") != null){
	 searchApplicationList =(List<MasApplication>)map.get("searchApplicationList");
	 for(MasApplication mapp: searchApplicationList){
		 mapplication = mapp.getParentId();
	 }
	}
	int groupAppl=0;
	String grpStatus="";
	List<GroupApplication> searchGroupList= new ArrayList<GroupApplication>();
	if(map.get("searchGroupList") != null){
	 searchGroupList =(List<GroupApplication>)map.get("searchGroupList");
	 for(GroupApplication groupApp1 :searchGroupList){
		 groupAppl= groupApp1.getGroup().getId();
		grpApp=groupApp1.getApp().getId();
		groupApplicationId=groupApp1.getId();
		grpStatus=groupApp1.getStatus();
	 }
	}
	
	List<UsergroupHospital> groupList= new ArrayList<UsergroupHospital>();
	if(map.get("groupList") != null){
		groupList =(List<UsergroupHospital>)map.get("groupList");
		}
		
	List<MasApplication> applicationList = new ArrayList<MasApplication>();
	if(map.get("applicationList") != null){
		applicationList = (List<MasApplication>)map.get("applicationList");
	}
	if(map.get("parentId")!=null){
		parentId=(String)map.get("parentId");
	}
	
	if(map.get("applicationId")!=null){
		applicationId=(String)map.get("applicationId");
	}
	String searchParentName="";
	if(map.get("searchParentName")!=null){
		searchParentName=(String)map.get("searchParentName");
	}
	if(searchApplicationList.size() > 0){
		masApp = (MasApplication)searchApplicationList.get(0);
		applicationId = masApp.getId();
		
	}
	
	%>


<%
	String message="";
		if(map.get("message") != null){
		    message = (String)map.get("message");
		  
		   
		  }
    %>
<h4><span><%=message %></span></h4>
<div class="titleBg">
<h2>Edit Forms/ Reports</h2>
</div>

<div class="clear"></div>

<form name="application" method="post">
<div class="Block"><label><span>*</span>Application Name:</label>
<input type="text" value="" class="large" id="<%=APPLICATION_ID%>"
	name="<%=APPLICATION_ID%>" validate="Application Name,metachar,no"/>
<div id="ac2update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=APPLICATION_ID%>','ac2update','user?method=getApplicationListByAutocomplete',{parameters:'requiredField=<%=APPLICATION_ID%>&'+csrfTokenName+'='+csrfTokenValue});
			</script> <script>
	    document.application.<%=APPLICATION_ID%>.focus();
	   </script> <input type="button" class="button" value="Search"
	onClick="submitFormForButton('application','user?method=searchApplication','checkSearchForApplication');" />
<div class="clear"></div>
<label>Application Id</label> <%if(masApp != null ){ %> <input
	type="hidden" value="<%=groupApplicationId%>" name="<%=GROUP_APP_ID%>"
	id="<%=groupApplicationId%>" validate="groupApplicationId,metachar,no"/> <input type="text"
	value="<%=masApp.getId()%>" name="app" class="readOnly"
	readonly="readonly" validate="app,metachar,no"/> <%}else{ %> <input type="text" value=""
	name="app" validate="app,int,no"/> <%} %> <label>Application Name</label> <%if(masApp != null){ %>
<input type="text" value="<%=masApp.getName() %>" name="appName"
	id="applicationName" validate="Application Name,metachar,yes"
	MAXLENGTH="50" /> <%}else{ %> <input type="text" value="" name="appName"
	id="applicationName" validate="Application Name,metachar,yes"
	MAXLENGTH="50" /> <%} %> <label>Parent Id </label> <select id="aaaa"
	name="aaaa" tabindex=1 validate="Parent Id,metachar,no">
	<option value="0">New Application</option>
	<%
			for (MasApplication masApplication : applicationList) {
				
				if(parentId.equals(masApplication.getParentId()) && !parentId.equals("0")){	
		    %>
	<option value="<%=parentId%>" selected><%=searchParentName+"["+parentId+"]"%></option>
	<%}else{%>
	<option value="<%=masApplication.getId()%>"><%=masApplication.getName()+"["+masApplication.getId()+"]"%></option>
	<%}} %>

</select>

<%-- <label>Group Name</label> <select name="<%=GROUP_ID%>" tabindex=1
	validate="Group Name,string,yes">
	<option value="0">Select Group Name</option>
	<%
			for (UsergroupHospital usergroupHospital : groupList) {
			if(groupAppl == usergroupHospital.getGroup().getId()){
				%>

	<option value="<%=usergroupHospital.getGroup().getId()%>"
		selected="selected"><%=usergroupHospital.getGroup().getGroupName()%></option>
	<%
		}else{
		%>
	<option value="<%=usergroupHospital.getGroup().getId()%>"><%=usergroupHospital.getGroup().getGroupName()%></option>
	<%} }%>
</select>  --%>

<label>Url </label> <%if(masApp != null){ %> <input type="text"
	value="<%=masApp.getUrl() %>" name="url" validate="URL,string,yes"
	id="url" maxlength="200" /> <%}else{ %> <input type="text" value=""
	name="url" validate="URL,string,yes" id="url" maxlength="200" /> <%} %>
<%if(masApp!= null){ %> <input type="hidden"
	value="<%=masApp.getOrderNo()==null?"":masApp.getOrderNo() %>"
	name="orderNo" id="orderNo" validate="OrderNo,int,yes" MAXLENGTH="3" />
<%}else{ %> <input type="hidden" value="" id="orderNo" name="orderNo"
	validate="OrderNo,int,yes" MAXLENGTH="3" /> <%} %>
<label>Status :</label> <% if(grpStatus.equals("y")){ %> <input
	type="radio" name=<%=STATUS%> class="radioCheck" value="y" validate="status,metachar,no"
	checked="checked"> <label class="valueAuto">Active</label> <input
	type="radio" name=<%=STATUS%> class="radioCheck" value="n"> <label
	class="valueAuto">Inactive</label> <%}else{ %> <input type="radio"
	name=<%=STATUS%> class="radioCheck" value="y"> <label
	class="valueAuto">Active</label> <input type="radio" name=<%=STATUS%>
	class="radioCheck" value="n" checked="checked"> <label
	class="valueAuto">Inactive</label> <%} %>
<div class="clear"></div></div>
<div class="clear"></div>
<input type="button" class="button" value="Update"
	onClick="submitForm('application','user?method=updateApplication');" />
<input type="button" name="Back" value="Back" class="button"
	accesskey="b"
	onclick="submitFormForButton('application','superAdmin?method=showModuleManagementJsp')"
	tabindex=1 /> 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 </form>


