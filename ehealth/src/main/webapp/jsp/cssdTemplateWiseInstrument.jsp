
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
		List<CssdInstrumentMaster> cssdInstrumentMasterList = new ArrayList<CssdInstrumentMaster>();
		List<CssdTemplateInstrument> cssdTemplateInstrumentList = new ArrayList<CssdTemplateInstrument>();

		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		// Code for Templete Instrument
		if (map.get("opdTemplateList") != null){
			opdTemplateList =(List<OpdTemplate>)map.get("opdTemplateList");
		}
		if (map.get("cssdInstrumentMasterList") != null){
			cssdInstrumentMasterList =(List<CssdInstrumentMaster>)map.get("cssdInstrumentMasterList");
		}
		if (map.get("cssdTemplateInstrumentList") != null){
			cssdTemplateInstrumentList =(List<CssdTemplateInstrument>)map.get("cssdTemplateInstrumentList");
		}
		int pageNo=1;
		if(map.get("pageNo")!=null)
			pageNo = Integer.parseInt(""+map.get("pageNo"));
		int templateId=0;
		if(opdTemplateList != null)
		   {
			   String templateName= "";
			   String templateCode= "";
			   String templateType= "";
			 //  =(OpdTemplate)opdTemplateList.get(0);
			   for(OpdTemplate opdTemplate:opdTemplateList){
			   templateName=opdTemplate.getTemplateName();
			   templateCode=opdTemplate.getTemplateCode();
			   templateType=opdTemplate.getTemplateType();
			   templateId=opdTemplate.getId();}
%>
<div class="titleBg">
<h2>Instrument Template Management</h2>
</div>
<div class="clear"></div>
<form name="cssdTemplateWiseInstrument" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<h4>Item Search</h4>
<div class="clear"></div>
<div class="Block">
<label>Item Name</label>
<input type="text" name="<%=GRN_NO%>" value=""	tabindex=1 MAXLENGTH="100" id="<%=GRN_NO%>" />
<div id="ac2update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=GRN_NO%>','ac2update','cssd?method=getItemForAutoComplete',{parameters:'requiredField=<%=GRN_NO%>'});
		</script>
<input type="button" value="search" class="button" onClick="submitForm('cssdTemplateWiseInstrument','/hms/hms/cssd?method=searchCssdTemplateInstrument');" />
</div>
<div class="paddingTop15"></div>
<h4>Template Details</h4>
<div class="clear"></div>

<div class="Block">
<label>Template Name</label> <label class="value">
<%= templateName %></label> 

<label>Template Code</label> <label class="value">
<%= templateCode %></label>
<label>Template Type</label> <label class="value">
<%= templateType %></label>
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
			<th>Instrument Name</th>
			<th>Instrument Code</th>
			<th>Instrument Type</th>
			<th>Assigned</th>
		</tr>
	</thead>
	<tbody id="tableData">
		<%


           		Iterator iterator = cssdInstrumentMasterList.iterator();

           		//GroupApplication groupApplication = null;
           		CssdInstrumentMaster cssdInstrumentMaster = null;
           		int i=0;
   				while (iterator.hasNext())
   				{

   					cssdInstrumentMaster = (CssdInstrumentMaster) iterator.next();
					int cssdInstrumentId = cssdInstrumentMaster.getId();
						i++;
	        %>
		<tr class="<% if(i %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><%=i%></td>
			<td><%=cssdInstrumentMaster.getInstrumentName() %></td>
			<td><%=cssdInstrumentMaster.getInstrumentCode() %></td>
			<td><%=cssdInstrumentMaster.getType() %></td>
			<td><input type="checkbox" name="cssdInstrumentId"
				value="<%=cssdInstrumentMaster.getId()%>" class="none" /></td>
				<%--<td><input type="checkbox" name="cssdInstrumentId"
				value="<%=cssdInstrumentMaster.getId()%>" class="none" /></td> --%>			
			
			<!-- <td><input type="checkbox" name="cssdInstrumentId"
				value="<%=cssdInstrumentMaster.getId()%>" class="none"/></td> -->
		</tr>

		<%
				}
		 	%>
	</tbody>
</table>
<input type="hidden" id="countVal" value="<%=i%>" /> <input
	type="hidden" id="chkStatus" value="no" />
	 <input type="hidden" name="templateId" value="<%=templateId %>" />
	<input type="hidden" name="pageEditNo" id="pageEditNo" value="<%=pageNo %>"/>
	<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
	  </script>
  <div class="clear"></div>
<div class="paddingTop15"></div>
<input type="button" name="save" value="Submit" class="button" onClick="submitForm('cssdTemplateWiseInstrument','/hms/hms/cssd?method=submitCssdTemplateInstrument');" />
<input type="button" name="Back" value="Back" class="button" onClick="submitForm('cssdTemplateWiseInstrument','/hms/hms/cssd?method=cssdTemplate');" />
  <div class="clear"></div>
<div class="paddingTop40"></div>
  </form>




