<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * cssTemplate.jsp  
 * Purpose of the JSP -  This is Show CSSD Template List.
 * @author  Mukesh Narayan SIngh
 * Create Date: 07 Jun,2011 
 * Revision Date:      
 * Revision By:  
 * @version 1.15
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->

<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="com.sun.mail.handlers.message_rfc822"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->


function fillId(id){

document.getElementById("cssdTemplateId").value=id

}
</script>
<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	
	
	List<OpdTemplate> opdTemplateList = new ArrayList<OpdTemplate>();
	String search = "";
	
	if(map.get("opdTemplateList")!= null)
	{
		opdTemplateList=(List<OpdTemplate>)map.get("opdTemplateList");
	}
	
	if(map.get("search")!= null)
	{
		search=(String)map.get("search");
	}

	
%>
<div class="titleBg">
<h2>CSSD Template</h2>
</div>
<div class="clear"></div>



<% String message ="";
		if(map.get("message") != null){
		    message = (String)map.get("message");
		   
		  }
    %>
<h4><%=message %></h4>




<form name="searchBlock" method="post" action="">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block"><label>Template Name</label> <input type="text"
	name="templateNameSearch" id="templateNameSearch" value="" /> 
	<label class="NoWidth">Template Code</label> 
	<input type="text" name="templateCodeSearch" id="templateCodeSearch" value="" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('searchBlock','cssd?method=showRecordsForCssdTemplate');" />

<div class="clear"></div>
</div>
</form>
<jsp:include page="searchResultBlockForIPD.jsp" />
<div class="clear"></div>

<form name="cssdTemplate" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input name="cssdTemplateId" id="cssdTemplateId" type="hidden" />  
 
 
<div id="test" class="floatRight"> 
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2 class="medium"></div>
<div class="clear paddingTop15"></div>
<input type="button" class="button"	onClick="submitForm('cssdTemplate','cssd?method=showCssdTemplateItem','validateRadioForCssdTemplate');" value="Assign Item" />
<div class="clear paddingTop15"></div>

	<script type="text/javascript" language="javascript">
	formFields = [
			[0, "<%= RequestConstants.CSSD_TEMPLATE_ID%>", "id"],[1, "<%= RequestConstants.CSSD_TEMPLATE_CODE%>"], [2,"<%= RequestConstants.CSSD_TEMPLATE_NAME%>"], [3,"<%= RequestConstants.CSSD_TEMPLATE_TYPE %>"] ];
	 statusTd =3;

</script></div>
<div id="edited"></div>
<label>&nbsp;</label>
<div id="statusMessage" class="messagelabel"><br />
</div>
</div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = "Radio"
		data_header[0][1] = "radio";
		data_header[0][2] = "5%";
		data_header[0][3] = "<%= RequestConstants.CSSD_TEMPLATE_ID%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Tamplate Code"
		data_header[1][1] = "data";
		data_header[1][2] = "10%";
		data_header[1][3] = "<%= RequestConstants.CSSD_TEMPLATE_CODE%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "Tamplate Name"
		data_header[2][1] = "data";
		data_header[2][2] = "10%";
		data_header[2][3] = "<%= RequestConstants.CSSD_TEMPLATE_NAME %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "Tamplate Type"
		data_header[3][1] = "data";
		data_header[3][2] = "10%";
		data_header[3][3] = "<%= RequestConstants.CSSD_TEMPLATE_TYPE %>";
		
		data_arr = new Array();
		
		<%
		if(opdTemplateList.size()>0){
			
		
		Iterator iterator=opdTemplateList.iterator();
		    int  i=0;
		          while(iterator.hasNext())
		           {   
		        	  
		        	  OpdTemplate opdTemplate= (OpdTemplate) iterator.next();
		        	  if(opdTemplate.getStatus().equalsIgnoreCase("y") )
		        	  {
		        	  	String tamplateCode=opdTemplate.getTemplateCode();
		        	  	String tamplateName=opdTemplate.getTemplateName();
		        	  	String tamplateType="";
		        	  	tamplateType=opdTemplate.getTemplateType();
		        	  	//String loginName=opdTemplate.getLoginName();
		        	  	//MasEmployee empObj=(MasEmployee)opdTemplate.getEmployee();
		        	  	//String empCode=empObj.getEmployeeCode();
		        	  
		        	  
		        	  
		        	  
		%>
		
			data_arr[<%= i%>] = new Array();
			
			data_arr[<%= i%>][0] =<%=opdTemplate.getId()%>
			
			data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="cssdTemplateId" value="<%= opdTemplate.getId()%>" id="parent" onclick="fillId(this.value)" />'
			
			<%
				if(tamplateCode != null)
				{
			%>
			data_arr[<%= i%>][2] = "<%=tamplateCode%>"
			<%
				}else{
			%>
			data_arr[<%= i%>][2] = ""
			<%
				}
			   if(tamplateName != null)
			   {
			%>
			data_arr[<%= i%>][3]="<%=tamplateName%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][3]=""
			<%
				}
			   if(tamplateType != null)
			   {
			%>
			data_arr[<%= i%>][4] = "<%=tamplateType%>"
			<%
			   }else{
			%> 
			data_arr[<%= i%>][4] = ""
		<%}%>
		
		
		 
		<% 	
			i++;
			}
		  }
		%>
		 
		formName = "cssdTemplate"
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeGridForPatient(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
</script> <input type="hidden" name="counter" id="counter" value="<%=i %>" />
<%} %>
 <script
	type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>