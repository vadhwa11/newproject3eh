
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.MasStoreSection"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=showDrugListBodySystemWiseReportJsp";
  obj.submit();
  }
</script> 
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<%
Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
List<MasStoreSection> searchMasStoreSectionList = new ArrayList<MasStoreSection>();
if(map.get("searchMasStoreSectionList")!=null)
	searchMasStoreSectionList = (List) map.get("searchMasStoreSectionList");


	
	
	
%>
<div id="contentspace">
<form name="drugListBodySystemWise" method="post" action=""><br />
<br />
<div class="panelbar">
<div class="paneltext"">Drug List Body System Wise Report</div>
</div>
<br />

<label class="bodytextB1"><font id="error">*</font>Pharma Index:</label>
<select name="<%=SECTION_ID%>" validate="Pharma Index,String,yes">
	<option value=0>Select</option>
	<%
				for (MasStoreSection masStoreItem :searchMasStoreSectionList ) {
				%>

	<option value=<%=masStoreItem.getId()%>><%=masStoreItem.getSectionName()%>
	</option>
	<%	
					}
				
					
				%>
</select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" name="add"
	id="addbutton" value="Ok" class="button"
	onClick="submitForm('drugListBodySystemWise','stores?method=generateDrugListBodySystemWiseReport');"
	accesskey="a" tabindex=1 /> <input type="button" name="clear"
	id="clearbutton" value="Clear" class="button"
	onClick="clearButton('drugListBodySystemWise');" accesskey="a"
	tabindex=1 />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>