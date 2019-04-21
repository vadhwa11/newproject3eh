<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * nursingCare.jsp  
 * Purpose of the JSP -  This is for Nursing Care.
 * @author  Dipali
 * @author  Vishal
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.6
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>


<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/nursingcare.js" type="text/javascript"></script>
<link href="/hms/jsp/css/css/jquery-ui.css" rel="stylesheet" />
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/jquery-ui.js"></script>
<script>jQuery.noConflict();</script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%

	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	List<MasNursingCare> searchNursingCareList = new ArrayList<MasNursingCare>();
	if(map.get("searchNursingCareList") != null){
		searchNursingCareList = (ArrayList)map.get("searchNursingCareList");
	}
	List<Object[]> chargeCodeList = new ArrayList<Object[]>();
	
	
	if (map.get("chargeCodeList") != null) {
		chargeCodeList = (List<Object[]>) map.get("chargeCodeList");
	}
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		 <% }%>

<div class="titleBg">
<h2>Nursing Care Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label>Nursing Care Code</label>
<input type="radio"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" />
<label>Nursing Care Name</label>
<input	type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" />
<input type="text" id="searchField"	name="<%= SEARCH_FIELD%>" value=""	validate="NursingCare Code,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'nursing?method=searchNursingCares')" />
<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','nursing?method=searchNursingCare','checkSearch')"	tabindex=1 />
<%--- Report Button   <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/> --%>

<input type="button" name="Report" value="Generate Report"	class="buttonBig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_nursing_care"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

</div>
</div>

<div class="clear"></div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
  if(searchNursingCareList.size()>0)
  {
	  String strForCode = (String)map.get("nursingCareCode");
   	  String strForCodeDescription = (String)map.get("nursingCareName");
   	  if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
   	  {
 %>
 		 <h4><a href="nursing?method=showNursingCareJsp">Show All Records</a></h4> <%
	  }
	}
	if(searchNursingCareList.size()==0 && map.get("search") != null)
	 {
%>
		 <h4><a href="nursing?method=showNursingCareJsp">Show All Records</a></h4> <%
  	}
	%>

<script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= DEFAULT_STATUS_RADIO %>"], [4,"<%= CHANGED_BY %>"], [5,"<%= CHANGED_DATE %>"],[6,"<%=CHANGED_TIME%>"],[7,"<%=STATUS%>"],[8,"chargeCode"] ];
  statusTd = 7;
 </script>
 </div>


<form name="nursingCare" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input	type="hidden" name="<%= POJO_NAME %>" value="MasNursingCare">
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="NursingName">
<input	type="hidden" name="nursingCare" value="NursingCare">
<input	type="hidden" name="<%=JSP_NAME %>" value="nursingCare">
<input	type="hidden" name="pojoPropertyCode" value="NursingCode">
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block" >
<label><span>*</span> NursingCare Code </label>
	<input type="text" name="<%= CODE%>" value="" validate="NursingCare Code,string,yes" MAXLENGTH="8" tabindex=1 />
	<label><span>*</span> NursingCare Name</label>
	<input type="text" name="<%= SEARCH_NAME %>" value="" validate="NursingCare Name,string,yes" MAXLENGTH="30" tabindex=1 />
	<label><span>*</span> Charge Code</label>
	<select id="chargeCode" name="chargeCode"	validate="Charge Code,metachar,yes" tabindex=1>
	<option value="">Select</option>
<% 
	for (Object[] masChargeCode : chargeCodeList){%>

	<option value="<%=masChargeCode[0]%>"><%=masChargeCode[1]%></option>

	<%}%>
	</select>
	<!-- <input	type="text" value="" id="chargeCode" size="35" name="chargeCode" validate="Charge Code,string,yes" />  -->
<!-- 
<div id="ac2update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript"	language="javascript" charset="utf-8">
new Ajax.Autocompleter('chargeCode','ac2update','nursing?method=getNursingCareChargeCodeList',{minChars:3, parameters:'requiredField=chargeCode'});
</script> 
	 -->
	
	<div class="clear"></div>
	<div class="floatLeft">
		<input type="button" class="buttonDel"  onclick="removeRow();" />
		<input type="button" class="buttonAdd"  onclick=" addRow();" value="" />
	</div>
	<div class="clear"></div>
	<div id="divTemplet" style="width:400px; overflow:auto; height:120px;border:solid 1px #336699; ">
	<table border="0" align="center" cellpadding="0" cellspacing="0"
					id="grid">
					<thead>
					<tr>
						<th scope="col">&nbsp;</th>
						<th scope="col">Item Name</th>
					</tr>
					</thead>
					<tbody>
					<%
					int incr = 0;
					%>
					<tr>
						<td><%=incr+1%><input type="checkbox" class="radioCheck" id="itemRadio1" name="itemRadio1" /></td>
						<td scope="col">
						<input type="text"	class="largTextBoxOpd"  id="nomenclature<%=incr%>" name="nomenclature<%=incr%>" />
						<div id="ac2updates<%=incr%>" style="display: none;"class="autocomplete"></div>
						 <script type="text/javascript" language="javascript" charset="utf-8">
				  			new Ajax.Autocompleter('nomenclature<%=incr%>','ac2updates<%=incr%>','opd?method=getItemListForAutoCompleteItem',{minChars:3,parameters:'requiredField=nomenclature<%=incr%>&screenName=nursingCare&counter=<%=incr%>'});
						</script>
						</td>
					</tr>
					</tbody>
				</table>
				<input type="hidden" name="hdb" value="<%=incr%>" id="hdb" />
	</div>	
	<div class="clear"></div>
	<div class="clear"></div>			
	<script>
     document.nursingCare.<%=CODE%>.focus();
    </script>
  <div style="display: none;">
	<label><span>*</span> Default Status</label>
	<input type="radio" name="<%= DEFAULT_STATUS_RADIO %>"   value="y" checked="checked" class="radioCheck" onkeypress="return submitenter(this,event,'nursing?method=addNursingCare')"/>
	<label class="auto">Yes</label>
	<input type="radio" name="<%=DEFAULT_STATUS_RADIO %>" value="n"  class="radioCheck" onkeypress="return submitenter(this,event,'nursing?method=addNursingCare')"/>
	<label class="auto">No </label>
	</div>
	<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button"	onClick="submitForm('nursingCare','nursing?method=addNursingCare');"	accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('nursingCare','nursing?method=editNursingCare');"	accesskey="u" tabindex=1 />
<input type="button" name="Delete"	id="deletebutton" value="Activate" style="display: none;"	class="button"	onClick="submitForm('nursingCare','nursing?method=deleteNursingCare&flag='+this.value);" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>

<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div></form>
<div class="clear"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Nursing Care Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Nursing Care Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Default Status"
data_header[2][1] = "hide";
data_header[2][2] = "20%";
data_header[2][3] = "<%= DEFAULT_STATUS_RADIO %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] =  "<%=CHANGED_DATE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%=CHANGED_TIME %>"

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_header[7] = new Array;
data_header[7][0] = "Charge Code"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "chaegeCode";


data_arr = new Array();

<%
Iterator itr=searchNursingCareList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             MasNursingCare  masNursingCare = (MasNursingCare)itr.next(); 
             
 %>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masNursingCare.getId()%>
data_arr[<%= counter%>][1] = "<%=masNursingCare.getNursingCode()%>"
data_arr[<%= counter%>][2] = "<%= masNursingCare.getNursingName()%>"


data_arr[<%= counter%>][3] = "No";
data_arr[<%= counter%>][4] = "<%= masNursingCare.getLastChgBy() %>";
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masNursingCare.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masNursingCare.getLastChgTime() %>"
<% if(masNursingCare.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>

<% for(Object[] obj : chargeCodeList){
	 StringBuffer output_str = new StringBuffer();
	 StringTokenizer s = new StringTokenizer(obj[1].toString(),"\""); 

	 while (s.hasMoreTokens())
	 {
	 output_str.append(s.nextToken());
	 if (s.hasMoreTokens())
	 {
	 output_str.append("\\");
	 output_str.append("\"");
	 }
	 }
	 if(masNursingCare.getChargeCode()!=null ){
		if(masNursingCare.getChargeCode().getId().equals((Integer)obj[0])){
			System.out.println("output_str--33-"+output_str);
%>
data_arr[<%= counter%>][8] = "<%=output_str.toString()%>"

<%}
}else{%>
data_arr[<%= counter%>][8] = "";
<%}
}
       counter++;
}
%>
 
formName = "nursingCare"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>
