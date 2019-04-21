<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : ADT_ICD_Search.jsp
	 * Tables Used         :
	 * Description         :
	 * @author  Create Date: 04.08.2008    Name: Othivadivel K R
	 * Revision Date:      Revision By:
	 * @version 1.0
	 * @see
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="in.cdac.medinfo.csnotk.csnolib.model.Concept" %>

<%@page import="jkt.hms.masters.business.MasIcd"%><head>


<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" id="vbulletin_css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar2.js"></script>

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<title>SnomedCT Search</title>
<style type="text/css">
#loading-overlay { position: absolute; top: 0; left: 0; right: 0; bottom: 0; background-color: #FDF9F9; opacity: 0.7; }
#loading-message { position: absolute; width: 400px; height: 100px; line-height: 100px; background-color:#FDF9F9; text-align: center; font-size: 1.2em; left: 50%; top: 50%; margin-left: -200px; margin-top: -50px;}
</style>

<SCRIPT LANGUAGE="JavaScript">
	/*function jsSelData(snomedCode,fullySpecifiedName,code) {
		//opener.jsSetSnomedData(snomedCode,fullySpecifiedName,code);
		//self.close();
	}*/
	var flag=0;
	function addTermInSelect(termId,term,code){
		var check= document.getElementById(termId);
		if(check.checked){
			opener.addTermInSelect(termId,term,1,code);	
			flag++;
		}else{
			flag--;
			opener.addTermInSelect(termId,term,2,code);				
		}
		if(flag>0){
			document.getElementById("doneDiv").style.display="block";
		}else{
			document.getElementById("doneDiv").style.display="none";
		}
	}
	function closeWindow(){
		document.getElementById("doneDiv").style.display="none";
		self.close();
	}
</SCRIPT>
<style type="text/css">
<!--
html { overflow-y: hidden; }
.schInput {
	BACKGROUND-COLOR: #ffffff;
	BORDER-BOTTOM: #bfbfbf 1px solid;
	BORDER-LEFT: #bfbfbf 1px solid;
	BORDER-RIGHT: #bfbfbf 1px solid;
	BORDER-TOP: #bfbfbf 1px solid;
	COLOR: #4a4a4a;
	FONT-FAMILY: Arial;
	FONT-SIZE: 11px;
	height: 15px;
}

#linetblhdr {
	BACKGROUND-COLOR: #EBE7E7;
	BORDER-BOTTOM: #d1bfe8 1px solid;
	BORDER-LEFT: #d1bfe8 1px solid;
	BORDER-RIGHT: #d1bfe8 1px solid;
	BORDER-TOP: #d1bfe8 1px solid;
	COLOR: #000000;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif;
	FONT-SIZE: 8pt;
	font-weight: 400;
	MARGIN: 1px;
	vertical-align: middle;
	cursor: hand
}

#sel {
	BACKGROUND-COLOR: #CAE7EF;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif;
	FONT-SIZE: 8pt;
	cursor: hand
}
-->
</style>

</head>
<%
	Map map = new HashMap();
	List<Concept> concepts = new ArrayList<Concept>();
	Concept concept=new Concept();
	Integer code=0;
	
	if (request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");
		if(map.get("code")!=null){
			code=(Integer)map.get("code");
			if (map.get("conecpt")!=null){
				concepts = (List)map.get("conecpt");
				code =(Integer)map.get("code");
			}			
		}
	}
%>

<div id="mainIn">
<form name="SnomedSearchForm" action="" method="post">
<div class="titleBg">
<h2>SnomedCt Search</h2>
</div>
<div class="clear"></div>
<div class="Block"><label>SnomedCT Name</label>
    <input type="text" name="term" id="term" validate="Term,alphanumeric,no"/>
    <input type="hidden" name="code" id="code" value="<%=code%>" validate="Code,alphanumeric,no"/>
    <div id="autoconecpt" style="display: none;" class="autocomplete"></div>
	 <script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('term','autoconecpt','opd?method=getSnomedCTListForAutoCompleteItem',{minChars:3,parameters:'code='+<%=code%>});
  	 </script>
	 <input	type="button"  name="addbutton" id="addbutton"  value="Search" class="button" accesskey="a" onclick="getSuggestions()"/> <input type="hidden"
	name="SearchFlag" value="true" />
<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="testDiv">
<div style="display:none" id="progressImg"><img src="../jsp/images/waitig.gif"/></div>
<div style="overflow-y: scroll;overflow-x: hidden;height: auto;max-height: 500px;">
 <div style="height: auto;">
	<table id="snomedTable" width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
		<th>S.No.</th>
		<th>Disorder Code</th>
		<th>Disorder Name</th>
	</tr>
<%
if (concepts != null && concepts.size() > 0) { %>
	 <%int x=1; %>
	<% for(int i=0;i<concepts.size();i++)
	{   
		concept = (Concept)concepts.get(i);
	%>
	
	<tr id="linetblhdr" onmouseover="this.id='sel'" 
		onmouseout="this.id='linetblhdr'" style="cursor:pointer"
		<%if(concept!=null){%>
		> 
		<%} %>
		<%if(x<=9){ %>
		<td><%=(x++)%>&nbsp;<input type="checkbox" onclick="addTermInSelect('<%=concept.getId()%>','<%=concept.getFullySpecifiedName()%>','<%=code%>');" id="<%=concept.getId()%>" name="terms" value="<%=concept.getId()%>:<%=concept.getFullySpecifiedName()%>"></td>
		<%}else{%>
			<td><%=(x++)%><input type="checkbox" onclick="addTermInSelect('<%=concept.getId()%>','<%=concept.getFullySpecifiedName()%>','<%=code%>');" id="<%=concept.getId()%>" name="terms" value="<%=concept.getId()%>:<%=concept.getFullySpecifiedName()%>"></td>
		<%}%>
		<td>
		<%if(concept!=null){%>
				<%=concept.getId()%>
		<%} %>
		</td>
		<td>
		<%if(concept!=null){%>
			<%=concept.getFullySpecifiedName()%>
		<%} %>
		</td>
		
	</tr>
	<%
	}
	%>
	<% }
	else
	{
	%>
	<tr>
		<td>No Data Found</td>
		<td></td>
		<td></td>
	</tr>
	<% } %>  
</table>
</div>
</div>
</div>
<div id="doneDiv" style="display:none" onclick="closeWindow();">
<input type="button"  name="closeWindow" id="closeWindow"   value="Done" class="button"/></div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>
</div>

<script type="text/javascript">
function getSuggestions(){
	var term=document.getElementById('term').value;
	var code=document.getElementById('code').value;
	submitForm('SnomedSearchForm','opd?method=showSnomedCTSearchJsp&term='+term+"&code="+code);
} 
</script>
