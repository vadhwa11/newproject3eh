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
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.Properties"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Arrays"%>
<%@page import="jkt.hms.masters.business.Ft"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.FtRelation"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<head>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/opd.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
		   var relArray  = new Array();
	  	   var relTreeArray  = new Array();
	  	    var validMultipleMembers  = new Array();
		   </script>
</head>


<%
Properties pro = HMSUtil.getPropertyFile("adt.properties");

List<String> memCode = new  LinkedList <String>();
memCode.addAll(Arrays.asList(pro.getProperty("uncleAuntPIds").split("#")));
memCode.addAll(Arrays.asList(pro.getProperty("uncleAuntMIds").split("#")));
memCode.addAll(Arrays.asList(pro.getProperty("ftSiblingIds").split("#")));
memCode.addAll(Arrays.asList(pro.getProperty("ftChildrenIds").split("#")));


 Map<String,Object> map = new HashMap<String,Object>();
   
	int patientFTId =0;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Patient patient =null;
	 if(map.get("patient")!=null)
		 patient = (Patient)map.get("patient");
	
	 List<FtRelation> ftRelList = null;
	 if(map.get("ftRelList")!=null)
		 ftRelList = (List<FtRelation>)map.get("ftRelList");
	 List<Ft> ftlist = null;
	 if(map.get("ftlist")!=null)
		 ftlist = (List<Ft>)map.get("ftlist");
	 
	 boolean saved =false;
	 
	 if(map.get("saved")!=null)
		 saved = (Boolean)map.get("saved");
	%>
 <% if(!saved && patient!=null){
 
 int i=0;
 int j=0;
 for (FtRelation ft:ftRelList) {
	     			 %> <script>
	     			
	     			 <%if(!memCode.contains(ft.getRelationCode())){%>
	     			validMultipleMembers[<%=j%>] = "<%=ft.getId()%>";
	     			
	     			<%j++;}%>
	     			
	     			relArray[<%=i%>]= new Array();
	     			relArray[<%=i%>]= new Array();
	     			relArray[<%=i%>][0] = "<%=ft.getId()%>";
		          relArray[<%=i%>][1] = "<%=ft.getRelName()%>";
		          </script> <% i++;}%>
		          
		              <% 
 int k=0;
 for (FtRelation ft:ftRelList) {
				        	
	     			 %> <script>
	     			relTreeArray[<%=k%>]= new Array();
	     			relTreeArray[<%=k%>][0] = "<%=ft.getId()%>";
	     			relTreeArray[<%=k%>][1] = "<%=ft.getGender()%>";
		          </script> <% k++;}%>
<h1>Family Members</h1>	          
<div class="Block">	
<form name="familyTree" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" id="${_csrf.parameterName}" value="${_csrf.token}">
<div class="floatRight" style="margin-right:14px;">
<input type="button" value="&nbsp;" class="buttonDel" onclick="removeRowTree();" >
<input type="button" value="&nbsp;" class="buttonAdd" onclick="addRowTree()">
</div>

<div class="clear"></div>
<div class="tableForTab" style="width:780px">
<table id="TreeTable">
<tr><th style="width:20px;">&nbsp;</th><th>Name</th><th>Relation</th><th>Gender</th><th>Diagnosis</th><th>Status</th></tr>
<input type="hidden" name="hinId" value="<%=patient.getId()%>"/>
<%int inc = 0;
if(ftlist!=null &&  ftlist.size()>0){
for(Ft ft : ftlist){
%>
 <tr><td></td><td><input type="text" name="name<%=inc%>" id="name<%=inc%>" readonly="readonly" value="<%=ft.getRelName()%>"/><input type="hidden" name="ftId<%=inc%>" value="<%=ft.getId()%>"/></td> 
<td><select name="rel<%=inc%>" id="rel<%=inc%>"><option value="<%=ft.getRel().getId()%>"><%=ft.getRel().getRelName()%></option></select></td>

 <td><select name="gen<%=inc%>" id="gen<%=inc%>" disabled="disabled" class="smallnew"><option value="<%=ft.getGender()%>"><%=ft.getGender().equalsIgnoreCase("f")?"Female":"Male"%></option></select>
    <input type="hidden" name="genVal<%=inc%>" id="genVal<%=inc%>" maxlength="1" value="<%=ft.getGender()%>"/>
 </td>
<td><input name="diag<%=inc%>" id="diag<%=inc%>" maxlength="50" value="<%=ft.getDiagnosis()!=null?ft.getDiagnosis():""%>"></td>
<td><select name="Stat<%=inc%>" id="Stat<%=inc%>" class="smallnew"><option value="y" <%=ft.getStatus().equalsIgnoreCase("y")?"selected":""%>>Active</option>
<option value="n" <%=ft.getStatus().equalsIgnoreCase("n")?"selected":""%>>Inactive</option>
</select></td>
</tr>
<%inc++;} }else{%>

 <tr><td></td><td><input type="text" name="name<%=inc%>" id="name<%=inc%>" readonly="readonly" value="<%=patient.getFullName()%>"/> </td>
<td><select name="rel<%=inc%>" id="rel<%=inc%>"><option value="15">Self</option></select></td>
 <td><select name="gen<%=inc%>" id="gen<%=inc%>"disabled="disabled"  class="smallnew"><option value="<%=patient.getSex().getAdministrativeSexCode()%>"><%=patient.getSex().getAdministrativeSexName()%></option> </select>
 <input type="hidden" name="genVal<%=inc%>" id="genVal<%=inc%>" maxlength="1" value="<%=patient.getSex().getAdministrativeSexCode()%>"/>
 </td>
<td><input name="diag<%=inc%>" id="diag<%=inc%>" maxlength="50"></td>
<td><select name="Stat<%=inc%>" id="Stat<%=inc%>" class="smallnew" maxlength="50"><option value="y">Active </option></select></td>
</tr>
 
<tr><td><input class="radioCheck" name="TreeRadio<%=++inc%>" id="TreeRadio<%=++inc%>" type="checkbox"></td>
<td><input type="text" name="name<%=++inc%>" id="name<%=inc%>"/></td>
<td><select  name="rel<%=inc%>" id="rel<%=inc%>" onchange="openRelationGenderValid(this.value,<%=inc%>);familyMembersDuplicacyCheck(this.value,<%=inc%>);">
<option value="">Select Relation</option>
<%for(FtRelation ft:ftRelList){ %>
<option value="<%=ft.getId()%>"><%=ft.getRelName()%></option>
<%} %>
</select></td>

<td><select name="gen<%=inc%>" id="gen<%=inc%>" disabled="disabled"  class="smallnew"><option value="">Select</option><option value="F">Female</option><option value="M">Male</option> </select>
 <input type="hidden" name="genVal<%=inc%>" id="genVal<%=inc%>" maxlength="1"/>
</td>
<td><input name="diag<%=inc%>" id="diag<%=inc%>" maxlength="50"></td>
<td><select name="Stat<%=inc%>" id="Stat<%=inc%>" class="smallnew" maxlength="50"><option value="y">Active </option></select></td>
</tr>
<%inc++;} %>	
</table>
<input type="hidden" name="treeCount" id="treeCount" value="<%=inc%>" />
</div>
<div class="clear"></div>

<input type="hidden" name="totalMem" id="totalMem" value="2"/>
<input id="save" value="Submit" type="button"	onclick="if(checkFamilyTreeFields()){submitForm('familyTree','/hms/hms/opd?method=submitFamilyTree');}" />
<input  type="button"	value="Close" onclick="window.close();" />
</form>
<%}else{  if(saved){%>
Sucessfully saved.
<%}else {%>
No record Found.<%} %>
<input  type="submit"	value="Close" onclick="window.close();" />
<%}%>


<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>


<div class="signPdiv">P</div>
<label class="valueAuto bgNone">Peternal</label>
<div class="signPdiv">M</div>
<label class="value bgNone">Meternal</label>

<div class="clear"></div>
</div>



