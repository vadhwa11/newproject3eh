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
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.masters.business.MasIcd"%>


<%@page import="jkt.hms.masters.business.Drugdetails"%>


<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<SCRIPT LANGUAGE="JavaScript">
<!--
	function jsSelData(hinNo) {
	var search = document.getElementById('search').value;
	 if(search == "n"){
		opener.jsSetIcdData(hinNo);
		self.close();
	  }
		
	}
	function filltreatment(val)
	{
		
		submitForm('TreatmentSearchForm','opd?method=showTreatmentPopUp&genericname='+encodeURIComponent(val));
		
		}
	function sub()
	{
	
	var search = document.getElementById('search').value;
	
	if (TreatmentSearchForm.generic_name.value=="")
    {
		
    	alert("Pl. Check your Input..... ");
    	return;
    }
    else
	{
	    if(search == "n"){
	    	
			submitForm('TreatmentSearchForm','opd?method=showTreatmentPopUp&search=y');
			
			}else{
				
		submitForm('TreatmentSearchForm','opd?method=showTreatmentPopUp&search=y');
		
		}
	}
	}
	
//-->
</SCRIPT>
</head>
<%
	Map map = new HashMap();
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Box box = HMSUtil.getBox(request);
	List<Drugdetails> drugDetailList = new ArrayList<Drugdetails>();
	Drugdetails drugdetail = new Drugdetails();
	String search = "";
	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
		
		
		if(map.get("drugDetailList") != null){
			drugDetailList=( List<Drugdetails>)map.get("drugDetailList");
		}	

		
		if (map.get("search")!=null){
			search = (String)map.get("search");
		}
		
	}
	
%>


<form name="TreatmentSearchForm" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input
	type="hidden" name="search" id="search" value="<%=search%>"></input>
<div class="titleBg">
<h2>Drug Search</h2>
</div>
<div class="Block"><label>Generic Name</label> <input type="text"
	id="genericname" name="genericname" value="" onchange="filltreatment(this.value)" />
<div id="ac2update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('genericname','ac2update','opd?method=autoCompleteForTreatment',{parameters:'requiredField=genericname'});
		</script> <%
String icdNameString ="";
if (drugDetailList != null && drugDetailList.size() > 0) { %> <% for(int i=0;i<drugDetailList.size();i++)
	{
		drugdetail = (Drugdetails)drugDetailList.get(i);
	%>
	<div class="clear"></div>
	 <label class="highlight auto">Generic Name</label> <%
				if(drugdetail.getGenericname()!=null)
				{
						
				%> <label class="valueLarge22"><%=drugdetail.getGenericname()%></label>
<%}else{%> <label class="valueLarge22"><%="---"%></label> <%}%>
<div class="clear"></div>
<label class="auto">Class</label> <%if(drugdetail.getDrugClass()!=null)
				{
				String drugclass = (String)drugdetail.getDrugClass();
				drugclass = drugclass.replaceAll(System.getProperty("line.separator"),"");
				drugclass = drugclass.replace('"', ' ');	
					%> <label class="valueLarge22"><%=drugclass%></label> <%}else{%> <label
	class="valueLarge22"><%="---"%></label> <%}%>
<div class="clear"></div>
<label class="auto">IndicationDosage</label> <%if(drugdetail.getIndicationdosage()!=null)
				{
					String dosage = (String)drugdetail.getIndicationdosage();
					dosage = dosage.replaceAll(System.getProperty("line.separator"),"");			
					dosage = dosage.replace('"', ' ');
				%> <label class="valueLarge22"><%=dosage%></label> <%}else{%> <label
	class="valueLarge22"><%="---"%></label> <%}%>
<div class="clear"></div>
<label class="auto">Administration</label> <%if(drugdetail.getAdministration()!=null)
				{
					String administrator = (String)drugdetail.getAdministration();
					administrator = administrator.replaceAll(System.getProperty("line.separator"),"");
					administrator = administrator.replace('"', ' ');
				%> <label class="valueLarge22"><%=administrator%></label> <%}else{%> <label
	class="valueLarge22"><%="---"%></label> <%}%>
<div class="clear"></div>
<label class="auto">Overdosage</label> <%if(drugdetail.getOverdosage()!=null)
				{
					  
					  String str1 = (String)drugdetail.getOverdosage();
					  str1 = str1.replaceAll(System.getProperty("line.separator"),"");
					  str1 = str1.replace('"', ' ');
					  %> <label class="valueLarge22"><%=str1%></label> <%}else{%> <label
	class="valueLarge22"><%="---"%></label> <%}%>
<div class="clear"></div>
<label class="auto">Contraindications</label> <%if(drugdetail.getContraindications()!=null)
				{
					String str2 = (String)drugdetail.getContraindications();
					str2 = str2.replaceAll(System.getProperty("line.separator"),"");
					str2 = str2.replace('"', ' ');%> <label class="valueLarge22"><%=str2%></label>
<%}else{%> <label class="valueLarge22"><%="---"%></label> <%}%>
<div class="clear"></div>
<label class="auto">SpecialPrecautions</label> <%if(drugdetail.getSpecialprecautions()!=null)
				{
					String str3 = (String)drugdetail.getSpecialprecautions();
					str3 = str3.replaceAll(System.getProperty("line.separator"),"");
					str3 = str3.replace('"', ' ');
					%> <label class="valueLarge22"><%=str3%></label> <%}else{%> <label
	class="valueLarge22"><%="---"%></label> <%}%>
<div class="clear"></div>
<label class="auto">AdverseDrugReactions</label> <%if(drugdetail.getAdversedrugreactions()!=null)
				{
					String adverse = (String)drugdetail.getAdversedrugreactions();
					adverse = adverse.replaceAll(System.getProperty("line.separator"),"");
					adverse = adverse.replace('"', ' ');

			         %> <label class="valueAuto"><%=adverse%></label> <%}else{%>
<label class="valueLarge22"><%="---"%></label> <%}%>
<div class="clear"></div>
<label class="auto">DrugInteractions</label> <%if(drugdetail.getDruginteractions()!=null)
				{
				String str5 = (String)drugdetail.getDruginteractions();
					str5 = str5.replaceAll(System.getProperty("line.separator"),"");
					str5 = str5.replace('"', ' ');
				%> <label class="valueLarge22"><%=str5%></label> <%}else{%> <label
	class="valueLarge22"><%="----"%></label> <%}%>
<div class="clear"></div>
<label>PregnancyCategory</label> <%if(drugdetail.getPregnancycategory()!=null)
				{
					String str6 = (String)drugdetail.getPregnancycategory();
					str6 = str6.replaceAll(System.getProperty("line.separator"),"");
					str6 = str6.replace('"', ' ');
				%> <label class="valueLarge22"><%=str6%></label> <%}else{%> <label
	class="valueLarge22"><%="---"%></label> <%}%>
<div class="clear"></div>
<label class="auto">Storage</label> <%if(drugdetail.getStorage()!=null)
				{
					String str7 = (String)drugdetail.getStorage();
					str7 = str7.replaceAll(System.getProperty("line.separator"),"");
					str7 = str7.replace('"', ' ');
					%> <label class="valueLarge22"><%=str7%></label> <%}else{%> <label
	class="valueLarge22"><%="---"%></label> <%}%>
<div class="clear"></div>
<label class="auto">MechanismAction</label> <%if(drugdetail.getMechanismaction()!=null)
				{
					String str8 = (String)drugdetail.getMechanismaction();
					str8 = str8.replaceAll(System.getProperty("line.separator"),"");
					str8 = str8.replace('"', ' ');
				%> <label class="valueLarge22"><%=str8%></label> <%}else{%> <label
	class="valueLarge22"><%="---"%></label> <%}%>

<div class="clear"></div>
<label class="auto">Atcclassification</label> <%if(drugdetail.getAtcclassification()!=null)
				{
					String str9 = (String)drugdetail.getAtcclassification();
					str9 = str9.replaceAll(System.getProperty("line.separator"),"");
					str9 = str9.replace('"', ' ');
					%> <label class="valueLarge22"><%=str9%></label> <%}else{%> <label
	class="valueLarge22"><%="---"%></label> <%}%>
<div class="clear"></div>
<label class="auto">Atcclassificationdetails</label> <%if(drugdetail.getAtcclassificationdetails()!=null)
				{
					String str10 = (String)drugdetail.getAtcclassificationdetails();
					str10 = str10.replaceAll(System.getProperty("line.separator"),"");
					str10 = str10.replace('"', ' ');
				%> <label class="valueLarge22"><%=str10%></label> <%}else{%> <label
	class="valueLarge22"><%="---"%></label> <%}%> <%
	}
	%> <% }else{%> <%-- <font face="arial" color="red">No Record Founds !</font>--%> <%} %>
</div>
</form>

