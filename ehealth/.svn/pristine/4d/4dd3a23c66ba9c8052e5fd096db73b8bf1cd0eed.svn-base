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
		List<OpdTemplate> opdTemplateList = new ArrayList<OpdTemplate>();
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		// Code for Templete Instrument
		if (map.get("opdTemplateList") != null){
			opdTemplateList =(List<OpdTemplate>)map.get("opdTemplateList");
		}
		int pageNo=1;
		if(map.get("pageNo")!=null)
			pageNo = Integer.parseInt(""+map.get("pageNo"));
		
%>
<div class="titleBg">
<h2>Autoclave Request Instrument From Template</h2>
</div>
<div class="clear"></div>
<form name="autoclaveRequestFormTemplate" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="paddingTop15"></div>
<h4>Template Details</h4>
<div class="clear"></div>

<div class="clear"></div>
<div class="division"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<table width="100%" align="left" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th>S.No.</th>
			<th>Template Name</th>
			<th>Template Code</th>
			<th>Template Type</th>
			<th>Request</th>
		</tr>
	</thead>
	<tbody id="tableData">
		<%

		int i=0;
		if(opdTemplateList != null)
		   {
			   for(OpdTemplate opdTemplate:opdTemplateList){
				int templateId=0;
			   String templateName= "";
			   String templateCode= "";
			   String templateType= "";
			   
			   templateName=opdTemplate.getTemplateName();
			   templateCode=opdTemplate.getTemplateCode();
			   templateType=opdTemplate.getTemplateType();
			   templateId=opdTemplate.getId();

						i++;
	        %>
		<tr class="<% if(i %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><%=i%></td>
			<td><%=templateName %></td>
			<td><%=templateCode%></td>
			<td><%=templateType%></td>
			
				
			<td><input type="checkbox" name="templateId" 
				value="<%=templateId%>" class="none" /></td>
			
		</tr>

		<%
			   }
				}
		 	%>
	</tbody>
</table>
<input type="hidden" id="countVal" value="<%=i%>" /> <input
	type="hidden" id="chkStatus" value="no" />
	<input type="hidden" name="pageEditNo" id="pageEditNo" value="<%=pageNo %>"/>
	<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
	  </script>
  <div class="clear"></div>
<div class="paddingTop15"></div>
<input type="button" name="save" value="Submit" class="button" onClick="submitForm('autoclaveRequestFormTemplate','/hms/hms/cssd?method=showAutoclaveRequestFromTemplateDetail','validateRowsTemplate');" />
<div class="clear"></div>
<div class="paddingTop40"></div>
  </form>




