<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * subCharge.jsp  
 * Purpose of the JSP -  This is for Sub Charge.
 * Revision Date:      
 * Revision By:  
 * @version 1.16
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@ page import="jkt.hms.masters.business.DiagParam"%>
<%@ page import="jkt.hms.masters.business.MasMainChargecode"%>


<%
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	List<MasMainChargecode> mainChargeCodeList=new ArrayList<MasMainChargecode>();
	List<MasSubChargecode> subChargeCodeList=new ArrayList<MasSubChargecode>();
	if(map.get("mainChargeCodeList") != null){
	mainChargeCodeList = (ArrayList)map.get("mainChargeCodeList");
	}
	if(map.get("subChargeCodeList") != null){
	subChargeCodeList = (ArrayList)map.get("subChargeCodeList");
	}
	ArrayList searchParamList = (ArrayList)map.get("searchParamList");
	ArrayList gridMainChargeList = (ArrayList)map.get("gridMainChargeList");
	ArrayList gridSubChargeList = (ArrayList) map.get("gridSubChargeList");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
		if(map.get("message") != null){
	String 	 message = (String)map.get("message");
			%>
		<h4><span><%=message %></span></h4>
		 <%} %> 

<div class="titleBg">
<h2>Diagnostic Parameter Master</h2>
</div>
<div class="Block">
<form name="search" method="post" action="">
<label>SubCharge Code </label>
<input type="radio"	class="radiobutMargin" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" /> 
<label>SubCharge Name </label>
<input type="radio" class="radiobutMargin" name="<%=SELECTED_RADIO %>" value="2" />
<input type="text" id="searchField"	name="<%= SEARCH_FIELD%>" value="" validate="SubCharge Code,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'hospital?method=searchDiagParam')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','laboratory?method=searchDiagParam','checkSearch')" tabindex=1 /> 
<%--- Report Button  --%> <input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
</div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div class="clear"></div>
<div id="searchtable" tabindex=2></div>

<% 
		if(searchParamList.size()>0 )
		 {
			String strForCode = (String)map.get("subChargecodeCode");
			String strForCodeDescription = (String)map.get("subChargecodeName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%>
<div class="clear"></div>
<h4><a href="laboratory?method=showParamJsp">Show All Records</a> <%
			}
		 }
	if(searchParamList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="laboratory?method=showParamJsp">Show All Records</a></h4> <%
  }
	%> <script type="text/javascript">
	
	
	formFields = [
			[0, "<%= DIAG_ID%>", "id"], [1,"<%= SEQUENCE_NO%>"],[2,"<%= PREFIX%>"],[3,"<%= CRITERIA%>"],[4,"<%= MAIN_CHARGECODE_ID%>"],[5,"<%= SUB_CHARGECODE_ID %>"], [6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=STATUS%>"] ];
	 statusTd = 9;
	</script></div>
<div class="paddingTop5"></div>
<div class="Block">
<form name="diagParam" method="post" action=""><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="title" value="DiagParam">
<input type="hidden" name="<%=JSP_NAME %>" value="diagParam">
<label><span>*</span> Seq.No.</label> 
<input type="text" name="<%=SEQUENCE_NO%>" value=""	validate="Seq.No.,int,yes" class="textbox_size20" MAXLENGTH="9"	tabindex=1>
<label><span>*</span> Prefix </label> 
<input type="text" name="<%= PREFIX %>" value="" validate="Prefix,string,yes" class="textbox_size20" MAXLENGTH="4" tabindex=1>
<label><span>*</span> Criteria </label><select name="<%=CRITERIA %>" id="<%=CRITERIA %>" tabindex=1
	validate="Criteria,string,yes">
	<option value="">Select</option>
	<option value="c">Continous</option>
	<option value="m">Monthly</option>
	<option value="y">Yearly</option>

</select>
<div class="clear"></div>
<label><span>*</span> Main Charge</label> 
<select	name="<%= MAIN_CHARGECODE_ID %>" validate="Main Charge,string,yes" tabindex=1 onChange="populateSubChargeCode(this.value,'subCharge')">
<option value="">Select</option>
<%
				for (MasMainChargecode  masMainChargecode : mainChargeCodeList){
				%>
<option value="<%=masMainChargecode.getId ()%>"><%=masMainChargecode.getMainChargecodeName()%></option>
	<%}%>
</select> <script type="text/javascript">
          subChargeArray1 = new Array();
			<%
			int count = 0;
			for (Iterator iter = mainChargeCodeList.iterator(); iter.hasNext();) 
			{
				MasMainChargecode mainChargecode = (MasMainChargecode) iter.next();
				for (Iterator iterSubChargecode = subChargeCodeList.iterator(); iterSubChargecode.hasNext();) 
				{
					MasSubChargecode subChargecode = (MasSubChargecode) iterSubChargecode.next();
					if(mainChargecode.getId().equals(subChargecode.getMainChargecode().getId())){
								%>
									subChargeArray1[<%=count%>] = new Array();
									subChargeArray1[<%=count%>][0] = <%=mainChargecode.getId()%>;
									subChargeArray1[<%=count%>][1] = <%=subChargecode.getId()%>;									
									subChargeArray1[<%=count%>][2] = "<%=subChargecode.getSubChargecodeName()%>";

								<%
								count++;
						}
					}
				}
		%>
		</script> <label><span>*</span> Sub Charge </label> 
		<select	name="<%= SUB_CHARGECODE_ID %>" validate="Sub Charge,string,yes"	tabindex=1>
	<option value="">Select</option>
	<% 
				for (MasSubChargecode  massubChargecode : subChargeCodeList){
				%>
	<option value="<%=massubChargecode.getId ()%>"><%=massubChargecode.getSubChargecodeName()%></option>
	<%}%>
</select> <!--Bottom labels starts-->
</form>

<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button" onClick="submitForm('diagParam','laboratory?method=addDiagParam');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('diagParam','laboratory?method=editDiagParam')" accesskey="u" tabindex=1 /> 
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button"	style="display: none;"	ssonClick="submitForm('diagParam','laboratory?method=deleteDiagParam&flag='+this.value)" accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset"	id="reset" value="Reset" class="buttonHighlight"	onclick="resetCheck();" accesskey="r" /> 
<input type="hidden"	name="<%=STATUS %>" value="" /> 
<input type="hidden"	name="<%= DIAG_ID%>" value="" />
</div>
<div class="clear"></div>
<div class="bottom">
<div class="clear"></div>
<label>Changed By</label> 
<label class="value"><%=userName%></label> 
<label>Changed Date</label> <label class="value"><%=date%></label> 
<label>Changed Time</label>
<label class="value"><%=time%></label>
</div>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Seq.No."
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= SEQUENCE_NO%>"

data_header[1] = new Array;
data_header[1][0] = "Prefix"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= PREFIX%>"

data_header[2] = new Array;
data_header[2][0] = "Ctriteria"
data_header[2][1] = "hide";
data_header[2][2] = "25%";
data_header[2][3] = "<%= CRITERIA%>"

data_header[3] = new Array;
data_header[3][0] = "Main Charge"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%= MAIN_CHARGECODE_ID %>";

data_header[4] = new Array;
data_header[4][0] = "Sub Charge"
data_header[4][1] = "data";
data_header[4][2] = "40%";
data_header[4][3] = "<%=SUB_CHARGECODE_ID %>";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=CHANGED_BY %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%=CHANGED_DATE %>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%=CHANGED_TIME %>"


data_header[8] = new Array;
data_header[8][0] = "Status"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchParamList.iterator();

          int  counter=0;
          while(itr.hasNext())
           {
             DiagParam  diagParam = (DiagParam)itr.next(); 
 %>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= diagParam.getId()%>
data_arr[<%= counter%>][1] = "<%=diagParam.getSeqNo()%>"
data_arr[<%= counter%>][2] = "<%= diagParam.getPrefix()%>"
data_arr[<%= counter%>][3] ="<%=diagParam.getCriteria()%>"

<%
		Iterator itrGridMainChargeList=gridMainChargeList.iterator();
		 while(itrGridMainChargeList.hasNext())
            {
             MasMainChargecode  mainChargeGrid = (MasMainChargecode)itrGridMainChargeList.next(); 
			 if(diagParam.getMainCharge().getId().equals(mainChargeGrid.getId()) && mainChargeGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][4] = "<%=mainChargeGrid.getMainChargecodeName()%>"
			<%}else if(diagParam.getMainCharge().getId().equals(mainChargeGrid.getId()) && mainChargeGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=mainChargeGrid.getMainChargecodeName()%>";
				
			<%}
}%>
<%
		Iterator itrGridSubChargeList=gridSubChargeList.iterator();
		 while(itrGridSubChargeList.hasNext())
            {
             MasSubChargecode  subChargeGrid = (MasSubChargecode)itrGridSubChargeList.next(); 
			 if(diagParam.getSubCharge().getId().equals(subChargeGrid.getId()) && subChargeGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][5] = "<%=subChargeGrid.getSubChargecodeName()%>"
			<%}else if(diagParam.getSubCharge().getId().equals(subChargeGrid.getId()) && subChargeGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][5] = "<font id='error'>*</font>Parent InActivated--<%=subChargeGrid.getSubChargecodeName()%>";
				
			<%}
}%>
data_arr[<%= counter%>][6] = "<%= diagParam.getLastChgTime() %>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(diagParam.getLastChgDate()) %>"
data_arr[<%= counter%>][8] = "<%= diagParam.getLastChgTime() %>"



			
			
<% if(diagParam.getStatus()!=null && diagParam.getStatus().equals("y")){ %>
data_arr[<%= counter%>][9] = "Active"
<%}else{%>
data_arr[<%= counter%>][9] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "diagParam"

nonEditable = [['<%= MAIN_CHARGECODE_ID%>'],['<%= SUB_CHARGECODE_ID%>']];

start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>