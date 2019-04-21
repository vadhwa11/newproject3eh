
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

<%@page import="jkt.hms.masters.business.MasStorePoDeliveryTerms"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">

<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasStorePoDeliveryTerms> paymentDetailsList = new ArrayList<MasStorePoDeliveryTerms>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if(map.get("paymentDetailsList")!=null){
		paymentDetailsList =(List<MasStorePoDeliveryTerms>) map.get("paymentDetailsList");
	}

%>
<form name="paymentForm" method="post" action="">
<h2>SO Payment Terms</h2>
<div class="clear"></div>
<div class="Block">
<%
int counter = 0;
	for(MasStorePoDeliveryTerms obj : paymentDetailsList){
%> <label><%=obj.getPoDeliveryTermsDescription() %></label> <input
	type="checkbox" name="id<%=counter%>" id="id<%=counter%>" value="<%=obj.getId()%>"
	class="radioCheck" /> <input type="hidden"
	id="<%=PO_DELIVERY_TERMS_DESC%><%=counter%>" name="<%=PO_DELIVERY_TERMS_DESC %><%=counter%>"
	value="<%=obj.getPoDeliveryTermsDescription() %>" readonly id="f1"
	MAXLENGTH="30" />


<div class="clear"></div>
<%
	counter++;
	}
%> <input type="hidden" name="counter" id="counter" value="<%=counter %>">


<div class="clear"></div></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="OK" class="button"
	onClick="check();" accesskey="a" tabindex=1 /> <input type="button"
	name="cancel" id="addbutton" value="Cancel" class="button"
	onClick="window.close();" accesskey="a" tabindex=1 />	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script>
	function check(){
		var count = 0;
		inps = document.getElementsByTagName('input')
		for(i=0;i<inps.length;i++)
		{
			if(inps[i].type == 'checkbox'){
				if(inps[i].checked){
					count++;
				}
			}
		}
		if(count > 1){
			alert("Select Only One Option.")
			return false;
		}else if(count == 1){
			for(i=0;i<document.getElementById('counter').value;i++)
			{
					if(document.getElementById('id'+i).checked){
					window.opener.document.getElementById('<%=PAY_TERMS %>').value=document.getElementById('<%=PO_DELIVERY_TERMS_DESC%>'+i).value;
					window.close();
					return true;
					}
			}
			window.close();
			return true;
		}
	}


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