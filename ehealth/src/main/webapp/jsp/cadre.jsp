<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * unit.jsp  
 * Purpose of the JSP -  This is for Cadre.
 * @author  Mansi
 * Create Date: 17th April,2015
 * Revision Date:      
 * Revision By:  
 * @version 1.9;
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasCadre"%>


<%
Map map = new HashMap();
if(request.getAttribute("map") != null)
{
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");

ArrayList searchCadreList = (ArrayList)map.get("searchCadreList");

String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}
if(map.get("message") != null){
	   String message = (String)map.get("message");
	   out.println(message);
	  }
%>

<div class="titleBg">
<h2>Cadre Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label>Cadre  Name</label>
<input type="text" id="searchField" name="<%= SEARCH_NAME%>" value="" validate="Cadre Name,string,no" MAXLENGTH="8" tabindex=1	/>
<input type="button" name="search" value="Search" class="inputButtonAutu" onclick="submitForm('search','generalMaster?method=searchCadre','checkSearch')"	tabindex=1 />

 <%--- Report Button   --%>
<input type="button"	name="Report" value="Generate Report Based on Search" class="inputButtonAutu" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');"	accesskey="g" tabindex=1 /> 

<input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_Cadre">
</form>
</div>
</div>
<div class="clear"></div>
</div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>
<% 
		if(searchCadreList.size()>0)
		 {
			String strForAddressDescription = (String)map.get("cadreName");
			if(strForAddressDescription!= null && strForAddressDescription!= "")
			{
	%>
	<a href="generalMaster?method=showCadreJsp">Show All Records</a> 
	<%
			}
		 }
	 if(searchCadreList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="generalMaster?method=showCadreJsp">Show All Records</a> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= SEARCH_NAME%>"],  [2,"strength"],[3,"description"], [4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"]
			,[8,"permaPost"],[9,"tempPost"],[10,"supernumPost"]];
	 statusTd = 7;
	</script></div>

<form name="cadre" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden"	name="<%= POJO_NAME %>" value="MasCadre"> 
<input type="hidden"	name="<%=POJO_PROPERTY_NAME %>" value="CadreName"> 
<input	type="hidden" name="title" value="Cadre"> 
<input type="hidden"	name="<%=JSP_NAME %>" value="cadre"> 
<input type="hidden"	name="pojoPropertyName" value="CadreName">

<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Cadre Name</label>

<input	type="text" name="<%= SEARCH_NAME %>" value=""	validate="Cadre Name,string,yes" class="textbox_size20" MAXLENGTH="32"	 tabindex=1> 
<script>
		document.cadre.<%=SEARCH_NAME%>.focus();
</script>

<label> Cadre Strength <span>*</span></label> 
<input type="text"	name="strength" id="strength" value="" validate="Strength,int,yes"	class="textbox_size20" MAXLENGTH="4"  tabindex=1>

<!-- <label> Permanent Post </label> 
<input type="text"	name="permaPost" id="permaPost" value="" validate="Permanent Post,int,no"	class="textbox_size20" MAXLENGTH="4"  tabindex=1>  

<div class="clear"></div>

<label>Temporary Post </label> 
<input type="text"	name="tempPost" id="tempPost" value="" validate="Temporary Post,int,no"	class="textbox_size20" MAXLENGTH="4"  tabindex=1>  

<label> Supernumerary Post </label> 
<input type="text"	name="supernumPost"	id="supernumPost" value="" validate="Supernumerary Post,int,no"	class="textbox_size20" MAXLENGTH="4"  tabindex=1>   -->

<label>Description </label> 
<!-- <input type="text"	name="description" value="" validate="Description,string,no"	class="textbox_size20" MAXLENGTH="200"  tabindex=1> -->
 <textarea name="description" validate="Description,string,no"  cols="10" rows="10" class="textareaMediua"></textarea> 

<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button" onClick="if(totalPost()){submitForm('cadre','generalMaster?method=addCadre');}"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit"	id="editbutton" value="Update" class="button" style="display: none;"	onClick="if(totalPost()){submitForm('cadre','generalMaster?method=editCadre')}" accesskey="u"	tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" style="display: none;"	class="button"	onClick="submitForm('cadre','generalMaster?method=deleteCadre&flag='+this.value)"	accesskey="d" tabindex=1 />
<input type="reset" name="Reset"	id="reset" value="Reset" class="buttonHighlight"	onClick="submitFormForButton('cadre','generalMaster?method=showCadreJsp')" accesskey="r" /> 
<input type="hidden"	name="<%=STATUS %>" value="" /> <input type="hidden"	name="<%= COMMON_ID%>" value="" />

<div class="clear"></div>
</div>
<div class="bottom">
<label>Changed By</label> 
<label	class="value"><%=userName%></label>
 
<label>Changed Date</label> 
<label	class="value"><%=date%></label> 

<label>Changed Time</label> 
<label	class="value"><%=time%></label> 
<input type="hidden"	name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Cadre Name"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= SEARCH_NAME%>"


	data_header[1] = new Array;
	data_header[1][0] = "Cadre Strength"
	data_header[1][1] = "data";
	data_header[1][2] = "40%";
	data_header[1][3] = "strength";
	
data_header[2] = new Array;
data_header[2][0] = "Description"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "description";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "0";
data_header[4][3] = "<%= CHANGED_DATE %>";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=CHANGED_TIME %>";

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_header[7] = new Array;
data_header[7][0] = "Permanent Post"
data_header[7][1] = "hide";
data_header[7][2] = "40%";
data_header[7][3] = "permaPost";

data_header[8] = new Array;
data_header[8][0] = "Temporary Post"
data_header[8][1] = "hide";
data_header[8][2] = "40%";
data_header[8][3] = "tempPost";

data_header[9] = new Array;
data_header[9][0] = "supernumerary Post"
data_header[9][1] = "hide";
data_header[9][2] = "40%";
data_header[9][3] = "supernumPost";


data_arr = new Array();

<%
Iterator itr=searchCadreList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasCadre  masCadre = (MasCadre)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masCadre.getId()%>
data_arr[<%= counter%>][1] = "<%=masCadre.getCadreName()!=null?masCadre.getCadreName():" "%>"
	data_arr[<%= counter%>][2] = "<%=masCadre.getCadreStrength()!=null?masCadre.getCadreStrength():" " %>"
data_arr[<%= counter%>][3] = "<%=masCadre.getDescription()!=null?masCadre.getDescription():" " %>"
data_arr[<%= counter%>][4] = "<%= masCadre.getLastChgBy()!=null?(masCadre.getLastChgBy().getId()!=null?masCadre.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masCadre.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masCadre.getLastChgTime() %>"
<% if(masCadre.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>

<% if(masCadre.getPermanentPost() != null){ %>
data_arr[<%= counter%>][8] = "<%=masCadre.getPermanentPost()%>"
<%}else{%>
data_arr[<%= counter%>][8] = ""
<%}%>

<% if(masCadre.getTempPost()!= null){ %>
data_arr[<%= counter%>][9] = "<%=masCadre.getTempPost()%>"
<%}else{%>
data_arr[<%= counter%>][9] = ""
<%}%>

<% if(masCadre.getSupernumeraryPost() != null){ %>
data_arr[<%= counter%>][10] = "<%=masCadre.getSupernumeraryPost()%>"
<%}else{%>
data_arr[<%= counter%>][10] = ""
<%}%>

<%
	     counter++;
}
%>
 
formName = "cadre"

nonEditable = ['<%= SEARCH_NAME%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>

  <script type="text/javascript">
function totalPost()
{
	
	var totalStrength=document.getElementById('strength').value;
	/* var d=document.getElementById('tempPost').value;
	var p=document.getElementById('permaPost').value;
	var c=document.getElementById('supernumPost').value;

	var s;
	if(d!="" && p!="" && c!="")
	{
		s=parseInt(d) + parseInt(p) + parseInt(c);	
	}
	if(d!="" && p!="" && c=="")
	{
		s=parseInt(d)+parseInt(p);	
	}
	if(d!="" && p=="" && c!="")
	{
		s=parseInt(d)+parseInt(c);	
	}
	if(d=="" && p!="" && c!="")
	{
		s=parseInt(p)+parseInt(c);	
	}

	if(d!="" && p=="" && c!="")
	{
		s=parseInt(d)+parseInt(c);	
	}
	if(d!="" && p=="" && c=="")
	{
		s=parseInt(d);	
	}
	if(d=="" && p!="" && c=="")
	{
		s=parseInt(p);	
	}

	if(d=="" && p=="" && c!="")
	{
		s=parseInt(c);	
	}
	 */
	 if(parseInt(totalStrength)<0){
		alert('Please enter positive value');
	/* if(parseInt(s)>parseInt(totalStrength))
	{
		alert("Please should be  Permanent Post, Temporary Post and Supernumerary Post  equal to Cadre Strength ");
		return false;
	}
	else if(parseInt(s)<parseInt(totalStrength))
	{
		alert("Please should be  Permanent Post, Temporary Post and Supernumerary Post  equal to Cadre Strength ");
		return false;
	} */
	 }else{
		return true;
		}
}
</script>
 