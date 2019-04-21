
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * approval_authority.jsp  
 * Purpose of the JSP -  This is for Approval Authority.
 * @author  Deepti Tevatia
 * Create Date: 20th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4  
--%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.MasAuthorizer"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasAuthorizer> authorityList = new ArrayList<MasAuthorizer>();
	int poId = 0;
	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if(map.get("authorityList")!=null){
		authorityList =(List<MasAuthorizer>) map.get("authorityList");
	}
	if(map.get("poId")!=null){
		poId =(Integer) map.get("poId");
	}
	
%>
<form name="approve" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<h4>Approved Authorities</h4>
<div class="clear"></div>

<div class="Block">
<%
			int counter = 0;
				for(MasAuthorizer masAuthorizer : authorityList)
				{
					if(masAuthorizer.getStatus().equals("y"))
					{
						%>
<div class="clear"></div>
<input type="checkbox" name="id<%=counter%>"
	value="<%=masAuthorizer.getId()%>" checked="checked" class="radioCheck" />
<%=masAuthorizer.getAuthorizerName()%>
<div class="clear"></div>
<%
					}
					else
					{
					%>

<div class="clear"></div>
<input type="checkbox" name="id<%=counter%>"
	value="<%=masAuthorizer.getId()%>" class="radioCheck" /> <%=masAuthorizer.getAuthorizerName()%>
<div class="clear"></div>
<%
					}
			%> <input type="hidden" name="<%=FREE_QTY %>"
	value="<%=masAuthorizer.getAuthorizerName() %>" readonly id="f1"
	MAXLENGTH="30" /> <%
					counter++;
					} 
				%> <input type="hidden" name="<%=PO_ID %>" value="<%=poId%>"><input
	type="hidden" name="counter" value="<%=counter %>"><input
	type="button" name="add" id="addbutton" value="Save" class="button"
	onClick="submitForm('approve','purchaseOrder?method=submitApprovalAuthority')"
	accesskey="a" tabindex=1 /> <input type="button" name="reset"
	id="addbutton" value="Reset" class="buttonHighlight"
	onClick="resetForm();" accesskey="a" tabindex=1 /> <input
	type="button" name="cancel" id="addbutton" value="Cancel"
	class="button" onClick="window.close();" accesskey="a" tabindex=1 />

<div class="clear"></div></div>

</form>
<script>
		function chkCheckBoxes()
		{
		alert("inside")
			inps = document.getElementsByTagName('input')
			alert(inps.length)
			flag=true;
			for(i=0;i<inps.length;i++)
			{
			alert(inps[i].type)
				if(inps[i].type == 'checkbox'){
					if(inps[i].checked){
						alert("checked")
						flag=false;
						break;
					}
				}
			}
			
			return true;
	}


</script>