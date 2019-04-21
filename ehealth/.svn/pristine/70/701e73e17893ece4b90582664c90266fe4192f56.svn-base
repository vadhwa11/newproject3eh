
<%@page import="jkt.hms.masters.business.MasHospitalwiseChargecode"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasChargeType"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%@page import="jkt.hms.masters.business.FaMasSubLed"%>

<%@page import="jkt.hms.masters.business.MasChargeCodeRates"%>
<%@page import="java.math.BigDecimal"%>

<script src="/hms/jsp/js/snomedLink.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<link href="/hms/jsp/css/css/jquery-ui.css" rel="stylesheet" />
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/jquery-ui.js"></script>
<script>jQuery.noConflict();</script>
<script type="text/javascript" language="javascript">

	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>

<%
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();

	String currentDate = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	List<MasChargeCode> searchChargeCodeList = new ArrayList<MasChargeCode>();
	ArrayList<MasMainChargecode> mainChargeList = new ArrayList<MasMainChargecode>();
	ArrayList<MasSubChargecode> subChargeList = new ArrayList<MasSubChargecode>();
	ArrayList<MasChargeType> chargeTypeList = new ArrayList<MasChargeType> ();
	ArrayList<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	ArrayList<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
	ArrayList<FaMasSubLed> subAccountList = new ArrayList<FaMasSubLed>();

	searchChargeCodeList=(List)map.get("searchChargeCodeList");
	mainChargeList = (ArrayList)map.get("mainChargeList");
	subChargeList = (ArrayList)map.get("subChargeList");
	chargeTypeList=(ArrayList)map.get("chargeTypeList");
	departmentList=(ArrayList)map.get("departmentList");
	accountList=(ArrayList)map.get("accountList");
	subAccountList=(ArrayList)map.get("subAccountList");

	int chargeCodeId =0;
	int mainChargeId =0;
	int subChargeId =0;
	int chargeTypeId =0;
	String userName = "";

	if(session.getAttribute("userName") != null){
	  		userName = (String)session.getAttribute("userName");
	}
 	if(map.get("chargeCodeId") != null){
 		chargeCodeId =(Integer) map.get("chargeCodeId");
	}
	if(map.get("mainChargeId") != null){
		mainChargeId =(Integer) map.get("mainChargeId");
	}
	if(map.get("subChargeId") != null){
		subChargeId =(Integer) map.get("subChargeId");
	}
	if(map.get("chargeTypeId") != null){
		chargeTypeId =(Integer) map.get("chargeTypeId");
	}
	String investigationName ="";
 	if(map.get("name") != null){
 		investigationName = (String)map.get("name");
 	}

	if(map.get("chargeTypeId") != null){
		chargeTypeId =(Integer) map.get("chargeTypeId");
	}
	int mainChargecodeId =0;
	if(map.get("mainChargecodeId") != null){
		mainChargecodeId =(Integer) map.get("mainChargecodeId");
	}
	int subChargecodeId =0;
	if(map.get("subChargecodeId") != null){
		subChargecodeId =(Integer) map.get("subChargecodeId");
	}

 	if(map.get("name") != null){
 		investigationName = (String)map.get("name");
 	}

 	if(map.get("chargeCodeId") != null){
 		chargeCodeId =(Integer) map.get("chargeCodeId");
	}
 	int pageNo = 0;
	if(map.get("pageNo") != null){
		pageNo = (Integer)map.get("pageNo");
	}
	String message ="";
 	if(map.get("message") != null){
 	message = (String)map.get("message");
		%>
<h4>
	<span><%=message %></span>
</h4>
<%} %>

<%if(chargeTypeId == 2){%>
<input type="button" class="button" value="Diagnostic" align="left"
	onClick="submitFormForButton('chargeCode','investigation?method=showInvestigationJsp&mainChargecodeId=<%=mainChargecodeId %>&subChargecodeId=<%=subChargecodeId %>&investigationName=<%=investigationName%>&chargeCodeId=<%=chargeCodeId %>');" />
<%}%>

<div class="titleBg">
	<h2>Charge Code and Snomed  Mapping</h2>
</div>
<div class="clear"></div>
<div class="Block">
	<div id="searcharea">
		<div id="searchbar">

			<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
				<label>ChargeCode</label>
				<input type="radio"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" />				
			    <label>Charge Name</label>
				<input type="radio" class="radiobutMargin" name="<%=SELECTED_RADIO %>"	value="2" /> 
				<input type="text" class="date"	name="<%= SEARCH_FIELD%>" value="" validate="ChargeCode Name,string,no" MAXLENGTH="30" tabindex=1 />
			     <label>Main Service Head</label> 
					<select id="mainChargeName"		name="m1" validate="MainCharge,string,No" 	onChange="populateSubChargeCode(this.value,'chargeCode')"
					tabindex=1>
					<option value="">Select</option>
					<%
				for (MasMainChargecode mainChargecode : mainChargeList)
				{
				%>
					<option value="<%=mainChargecode.getId ()%>"><%=mainChargecode.getMainChargecodeName()%></option>
				<%}%>
				</select> 
				
				<input type="submit" name="search" value="Search" class="button"
					onclick="submitForm('search','hospital?method=showSnomedChargeCodeJsp')"
					tabindex=1 /> <input type="button" name="Report"
					value="Generate Report" class="buttonBig"
					onClick="submitForm('search','hospital?method=printMainWiseCharge');"
					accesskey="g" tabindex=1 />
				<!--  <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_charge_code">-->
			</form>

			<div class="clear"></div>
		</div>

	</div>

</div>

<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
	<div class="clear"></div>
	<div id="searchtable" tabindex=2></div>
	<!-- <h4>No Records Found</h4> -->
	<%
	if (searchChargeCodeList.size() > 0 ) {
		String strForCode = (String) map.get("chargeCodeCode");
		String strForCodeDescription = (String) map.get("chargeCodeName");
		if (strForCode != null && strForCode != "" || strForCodeDescription != null	&& strForCodeDescription != "") {
%>
	<br />
	<h4>
		<a href="hospital?method=showChargeCodeJsp">Show All Records</a>
	</h4>
	<%
 	}
 	}
 if(searchChargeCodeList.size()==0 && map.get("search") != null){
	 %>
	<h4>
		<a href="hospital?method=showChargeCodeJsp">Show All Records</a>
	</h4>
	<%  }%>
	<script type="text/javascript">

	formFields = [
	 	[0, "<%= CHARGE_CODE_ID%>", "id"], [1,"<%= CHARGE_CODE %>"], [2,"<%= CHARGE_NAME %>"],[3,"<%= CHARGE %>"], [4,"<%= MAIN_CHARGECODE_ID%>"], [5,"<%= SUB_CHARGECODE_ID%>"],[6,"<%= CHARGE_TYPE_ID%>"],[7,"<%= DEPARTMENT_ID%>"],[8,"<%= EFFECTIVE_DATE_FROM%>"], [9,"<%=CHANGED_BY%>"],[10,"<%= CHANGED_DATE%>"],[11,"<%= CHANGED_TIME%>"],[12,"<%= STATUS%>"]];
	  statusTd = 12;
	</script>
</div>
<div class="clear"></div>

<script type="text/javascript">

function testForm(){
		submitForm(chargeCode,contentspace,'/hms/hms/hospital?method=deleteSubTest');

	}


function deleteChargeCode(){
	var subChargeId1=document.chargeCode.<%= SUB_CHARGECODE_ID%>.options[document.chargeCode.<%= SUB_CHARGECODE_ID%>.selectedIndex].text;
	var mainChargeId1=document.chargeCode.<%= MAIN_CHARGECODE_ID%>.options[document.chargeCode.<%= MAIN_CHARGECODE_ID%>.selectedIndex].text;

	 if(mainChargeId1=="Select"){
	alert('Parent is InActivated!');
	}
	else{
	deleteForm('chargeCode','/hms/hms/hospital?method=deleteChargeCode');
}
}
</script>

<form name="chargeCode" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<input type="hidden" name="<%= POJO_NAME %>" value="MasChargeCode">
		<input type="hidden" name="<%=POJO_PROPERTY_NAME %>"	value="ChargeCodeName"> 
		<input type="hidden" name="title"			value="ChargeCode"> 
		<input type="hidden"				name="<%=JSP_NAME %>" value="chargeCode"> 
		<input					type="hidden" name="pojoPropertyCode" value="ChargeCodeCode">
						<div class="paddingTop5"></div>
						<div class="Block">

							<div class="clear"></div>
							<label><span>*</span> Main Service Head</label> <select
								id="mainChargeName" name="<%=MAIN_CHARGECODE_ID %>"
								validate="MainCharge,string,yes"
								onChange="populateSubChargeCode(this.value,'chargeCode')"
								tabindex=1>
								<option value="">Select</option>
								<%
				    for (MasMainChargecode mainChargecode : mainChargeList){
				%>
								<option value="<%=mainChargecode.getId ()%>"><%=mainChargecode.getMainChargecodeName()%></option>
								<%}%>

							</select>
							<script type="text/javascript">
          subChargeArray1 = new Array();
		<%
			int count = 0;
			for (Iterator iter = mainChargeList.iterator(); iter.hasNext();)
			{
				MasMainChargecode mainChargecode = (MasMainChargecode) iter.next();
				for (Iterator iterSubChargecode = subChargeList.iterator(); iterSubChargecode.hasNext();)
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
						}	} } %>
		</script>
							<label><span>*</span> Sub Service Head</label> <select
								id="subChargeName" name="<%=SUB_CHARGECODE_ID %>"
								validate="Sub Service Head,string,yes" tabindex="2">
								<option value="">Select</option>
								<%
					for (MasSubChargecode subChargecode : subChargeList){
				%>
								<option value="<%=subChargecode.getId ()%>"><%=subChargecode.getSubChargecodeName().trim()%></option>
								<%}%>
							</select> <label><span>*</span> Service Type</label> <select
								id="chargeTypeName" name="<%=CHARGE_TYPE_ID %>"
								validate="Service Type,string,yes" tabindex=3>
								<option value="">Select</option>
								<%
					for (MasChargeType chargeType : chargeTypeList){
				%>
								<option value="<%=chargeType.getId ()%>"><%=chargeType.getChargeTypeName()%></option>
								<%}%>
							</select>

							<div class="clear"></div>
							<label><span>*</span> Department</label> <select id="depName"
								name="<%=DEPARTMENT_ID %>" validate="Department,string,yes"
								tabindex=4>
								<option value="">Select</option>
								<%
								 for (MasDepartment department : departmentList){
								%>
								<option value="<%=department.getId ()%>"><%=department.getDepartmentName().trim()%></option>
								<%}%>
							</select> 
							<%-- <script>document.chargeCode.<%=CHARGE_CODE%>.focus(); </script> --%>
							 
							<label><span>*</span>Effective From</label> 
							<input type="text" class="date" id="fromDateId"	 name="<%=EFFECTIVE_DATE_FROM %>" value="<%=currentDate %>"	readonly="readonly" MAXLENGTH="30" /> <img
								src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"		validate="Pick a date"		onClick="setdate('<%=currentDate %>',document.chargeCode.<%=EFFECTIVE_DATE_FROM%>,event)" />
								<div class="clear"></div>
								<div>
									<div class="paddLeft15">
									<input type="button" name="searchProcedure"	id="searchProcedure" value="Search Procedure" class="button"/> 
									<input type="button" name="clearTable"	id="clearTable" value="clear table" class="button"/>
									<!-- <input type="button" name="add"	id="addbutton" value="Add" class="button"/> 
									<input type="button" name=""removeButton""	id="removeButton" value="Delete" class="button"/> -->
									</div>
									<%int inc=0;%>
									<div class="clear"></div>
									<div class="paddingTop5"></div>
									
									<div  class="cmntable" style="height:300px;width:790px;overflow: scroll;" >
									<table border="0" align="center" cellpadding="0" cellspacing="0" id="procedureTable">
									<thead>
										<tr><th><span>*</span>Procedure Name</th><th><span>*</span>Charge</th></tr>
									</thead> 	
									<%--<tr>
									 <td>
										<input type="text" id="code<%=inc%>" name="code<%=inc%>" style="text-transform:uppercase"/>
									 </td>
									 <td>
									 	<input type="text" autofocus class="large" id="charge<%=inc%>" name="charge<%=inc%>" onkeypress="selectSNOMEDCT('ACTIVE','PROCEDURE','ALL',returnlimit_IN,callbck_index,'charge<%=inc%>',<%=inc%>);"/>
									 	<input type="hidden" id="chargeId<%=inc%>" name="chargeId<%=inc%>" />
									 	</td>
									 <td>
										<input type="text" id="chargerate<%=inc%>" name="chargerate<%=inc%>"/>
									 </td>
									</tr> --%>
									</table>
									<input type="hidden" id="tableRow" name="tableRow" value="<%=inc%>"/>
									</div>
								</div>
						</div> 
						
						<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
						<input type="hidden" name="<%=CHANGED_DATE %>"	value="<%=currentDate%>" /> 
						<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> 
						
						<!--Bottom labels starts-->
						<div class="clear"></div>
						<div class="division"></div>
						<div class="clear"></div>

						<div id="edited"></div> 
						<input type="button" name="addbutton"	id="addbutton" value="Save" class="button"	onClick="submitCharge()" 	accesskey="a" tabindex=16 /> 
						<!-- input type="button" name="edit"	id="editbutton" value="Update" class="button" style="display: none;" onClick="checkMainChargeForUpdate();"		accesskey="u" tabindex=17 /> 
						<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" style="display: none;"	onClick="submitForm('chargeCode','hospital?method=deleteChargeCode&flag='+this.value,'deleteChargeCode()')"		accesskey="d" tabindex=18 />
						<input type="reset" name="Reset"	id="reset" value="Reset" class="buttonHighlight"	onclick="resetCheck();" accesskey="r" tabindex="19" /> --> 
						 <input	type="hidden" name="<%=STATUS %>" value="" /> 
						 <input type="hidden" name="<%= CHARGE_CODE_ID%>" value="" />
						 
						<!-- Added By Ritu for edit page-->
						<input type="hidden" id="pageNoEdit" name="pageNoEdit"			value="<%=pageNo %>" />		<div class="clear"></div>
						<div class="division"></div>
						<div class="clear"></div>

						<div class="bottom">
							<label>Changed By:</label> <label class="value"><%=userName%></label>
							<label>Changed Date:</label> <label class="value"><%=currentDate%></label>
							<label>Changed Time:</label> <label class="value"><%=time%></label>
						</div> <!--Bottom labels ends-->
						<div class="clear"></div>
						<div class="paddingTop40"></div>
						
				</form>		
<script type="text/javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Service Code"
data_header[0][1] = "data";
data_header[0][2] = 0;
data_header[0][3] = "<%= CHARGE_CODE %>"

data_header[1] = new Array;
data_header[1][0] = "Service Name"
data_header[1][1] = "data";
data_header[1][2] = 0;
data_header[1][3] = "<%= CHARGE_NAME%>";

data_header[2]=new Array;
data_header[2][0]="Charge"
data_header[2][1]="hide";
data_header[2][2]=0;
data_header[2][3]="<%= CHARGE%>";

data_header[3]=new Array;
data_header[3][0]="Main Service Head"
data_header[3][1]="data";
data_header[3][2]=0;
data_header[3][3]="<%= MAIN_CHARGECODE_ID%>";

data_header[4]=new Array;
data_header[4][0]="Sub Service Head"
data_header[4][1]="data";
data_header[4][2]=0;
data_header[4][3]="<%= SUB_CHARGECODE_ID%>";

data_header[5]=new Array;
data_header[5][0]="Charge Type"
data_header[5][1]="data";
data_header[5][2]=0;
data_header[5][3]="<%= CHARGE_TYPE_ID%>";

data_header[6]=new Array;
data_header[6][0]="Department"
data_header[6][1]="data";
data_header[6][2]=0;
data_header[6][3]="<%= DEPARTMENT_ID%>";

data_header[7]=new Array;
data_header[7][0]="EffectiveFrom Date"
data_header[7][1]="hide";
data_header[7][2]=0;
data_header[7][3]="<%= EFFECTIVE_DATE_FROM%>";


data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%= CHANGED_BY%>";

data_header[9] = new Array;
data_header[9][0] = "LastChangeBy"
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%= CHANGED_BY%>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "<%= CHANGED_TIME%>";

data_header[11] = new Array;
data_header[11][0] = "Status"
data_header[11][1] = "data";
data_header[11][2] = 0;
data_header[11][3] = "<%= STATUS%>";


data_arr = new Array();
<%
        Iterator itrCC=searchChargeCodeList.iterator();
        int  counter=0;
          while(itrCC.hasNext())
           {
             MasChargeCode  masChargeCode = (MasChargeCode)itrCC.next();
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masChargeCode.getId()%>
data_arr[<%= counter%>][1] = '<%=masChargeCode.getChargeCodeCode()%>';

<%

		 StringBuffer output_str1 = new StringBuffer();
		if(masChargeCode.getChargeCodeName()!=null){
			 StringTokenizer s1 = new StringTokenizer(masChargeCode.getChargeCodeName().toString(),"\"");

			 while (s1.hasMoreTokens())
			 {
			 output_str1.append(s1.nextToken());
			 if (s1.hasMoreTokens())
			 {
			 output_str1.append("\\");
			 output_str1.append("\"");
			 }
			 }
		}
		%>

data_arr[<%= counter%>][2] = "<%=output_str1 %>";
<%
	BigDecimal rate = new BigDecimal(0.00);
	Set<MasChargeCodeRates> rateSet = new HashSet<MasChargeCodeRates>();
	rate = new BigDecimal(masChargeCode.getCharge()!=null?masChargeCode.getCharge():0);
%>
data_arr[<%= counter%>][3] = "<%= rate%>"
<%
			Iterator itrGridMainChargeList=mainChargeList.iterator();
			 while(itrGridMainChargeList.hasNext())
	            {
				 try
				 {
	             MasMainChargecode  mainChargecode = (MasMainChargecode)itrGridMainChargeList.next();
				 if(masChargeCode.getMainChargecode().getId().equals(mainChargecode.getId()) && mainChargecode.getStatus().equalsIgnoreCase("y"))
				 {%>
				data_arr[<%= counter%>][4] = "<%=mainChargecode.getMainChargecodeName().trim()%>"
			<%}
			 else if(masChargeCode.getMainChargecode().getId().equals(mainChargecode.getId()) && mainChargecode.getStatus().equalsIgnoreCase("n"))
				{%>
				data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=mainChargecode.getMainChargecodeName().trim()%>";
			<%} }
			catch(Exception e){
				e.printStackTrace();
			} }%>

			<%
				Iterator itrGridSubChargeList=subChargeList.iterator();
				 while(itrGridSubChargeList.hasNext()){
					 try{
		             MasSubChargecode  subChargecode = (MasSubChargecode)itrGridSubChargeList.next();
		             if(masChargeCode.getSubChargecode()!=null){
		            	 if(masChargeCode.getSubChargecode().getId().equals(subChargecode.getId()) && subChargecode.getStatus().equalsIgnoreCase("y"))
						 { %>

							data_arr[<%= counter%>][5] = "<%=subChargecode.getSubChargecodeName().trim()%>"
						<%} else if(masChargeCode.getId().equals(subChargecode.getId()) &&
								subChargecode.getStatus().equalsIgnoreCase("n")){
						%>
							data_arr[<%= counter%>][5] = "<font id='error'>*</font>Parent InActivated--<%=subChargecode.getSubChargecodeName().trim()%>";
						<%} 
		             }
				 }catch(Exception e){
				e.printStackTrace();
			} }%>
	<%
		Iterator itrGridChargeTypeList=chargeTypeList.iterator();
		 while(itrGridChargeTypeList.hasNext()){
			 try {
             MasChargeType  chargeType = (MasChargeType)itrGridChargeTypeList.next();
			 if(masChargeCode.getChargeType().getId().equals(chargeType.getId()) && chargeType.getStatus().equalsIgnoreCase("y"))
			 {
			 %>
				data_arr[<%= counter%>][6] = "<%=chargeType.getChargeTypeName()%>"

			<%} else if(masChargeCode.getId().equals(chargeType.getId()) && chargeType.getStatus().equalsIgnoreCase("n")){
			%>
				data_arr[<%= counter%>][6] = "<font id='error'>*</font>Parent InActivated--<%=chargeType.getChargeTypeName()%>";
			<%	} }catch(Exception e){
				e.printStackTrace();
			} }%>
	<%
		Iterator itrGridDepartmentList=departmentList.iterator();
		 while(itrGridDepartmentList.hasNext()){
			 try{
             MasDepartment  masDepartment = (MasDepartment)itrGridDepartmentList.next();
           
			 if(masChargeCode.getDepartment().getId().equals(masDepartment.getId()) && masDepartment.getStatus().equalsIgnoreCase("y"))
			 { 
			 %>
				data_arr[<%= counter%>][7] = "<%=masDepartment.getDepartmentName().trim()%>";
			<%}else if(masChargeCode.getDepartment().getId().equals(masDepartment.getId()) && masDepartment.getStatus().equalsIgnoreCase("n")){
			
			%>
				data_arr[<%= counter%>][7] = "<font id='error'>*</font>Parent InActivated--<%=masDepartment.getDepartmentName().trim()%>";
			<%}
			 }catch(Exception e){
				e.printStackTrace();
			} }%>
			<%if(masChargeCode.getDateEffectiveFrom() != null){%>
			data_arr[<%= counter%>][8] ="<%= HMSUtil.convertDateToStringWithoutTime(masChargeCode.getDateEffectiveFrom()) %>"
			<%}else{%>
			data_arr[<%= counter%>][8]="";
			<%}%>
		

			data_arr[<%= counter%>][9] ="<%= masChargeCode.getLastChgBy()!=null ?masChargeCode.getLastChgBy().getUserName():"" %> "
			data_arr[<%= counter%>][10] = "<%= masChargeCode.getLastChgDate()!=null ? HMSUtil.convertDateToStringWithoutTime(masChargeCode.getLastChgDate()):""%>"
			data_arr[<%= counter%>][11] ="<%= masChargeCode.getLastChgTime()!=null ? masChargeCode.getLastChgTime():""%> "

<% if(masChargeCode.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][12] = "Active"
<%}else{%>
data_arr[<%= counter%>][12] = "InActive"
<%}
		     counter++;
}
%>





formName = "chargeCode"

	nonEditable = ['<%= CHARGE_CODE%>'];
	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	makeTable(start,end);
	
	intializeHover('searchresulttable', 'TR', ' tableover');
	</script>
	
	
<script type="text/javascript">
 jQuery(function ($){
	 $("#searchProcedure").click(function(){
		 copyselectSNOMEDCT('ACTIVE','PROCEDURE','ALL',returnlimit_IN,callbck_index,callbck_concept_index);
		 });
    });  
		/*$("#addbutton").click(function(){
			  var tbl = document.getElementById('procedureTable');
			  var lastRow = tbl.rows.length;
			  var iteration = lastRow;
			  var row = tbl.insertRow(lastRow);
			  var tableRow = document.getElementById('tableRow');
			  iteration = parseInt(tableRow.value)+1;
			  tableRow.value=iteration;
			  
			  var cellRight1 = row.insertCell(0);
			  var e1 = document.createElement('input');
			  e1.type = 'text';
			  e1.style="text-transform:uppercase";
			  e1.name='code'+iteration;
			  e1.id='code'+iteration;
			  cellRight1.appendChild(e1);
			  
			  var cellRight1 = row.insertCell(1);
			  var e1 = document.createElement('input');
			  e1.type = 'text';
			  e1.className='large';
			  e1.name='charge'+iteration;
			  e1.id='charge'+iteration;
			  e1.onkeypress=function(){selectSNOMEDCT("ACTIVE","PROCEDURE","ALL",returnlimit_IN,callbck_index,'charge'+iteration,iteration);};
			  cellRight1.appendChild(e1);
			 
			  var e2 = document.createElement('input');
			  e2.type = 'hidden';
			  e2.name='chargeId'+iteration;
			  e2.id='chargeId'+iteration;
			  cellRight1.appendChild(e2);
			  
			  var cellRight2 = row.insertCell(2);
			  var e21 = document.createElement('input');
			  e21.type = 'text';
			  e21.name='chargerate'+iteration;
			  e21.id='chargerate'+iteration;
			  cellRight2.appendChild(e21);
	});*/

 
	jQuery(function ($) {
		selectedConceptId = "";
		dialogFormHTML = '<div id="snomed-ct-search">'+
		'<input type="text" placeholder="Enter 3 characters to search..." id="txt-snomed-ct-search" class="searchText" name="txt-snomed-ct-search" style="width:90%;color:#000000;"></input>'+
		'<input type="image" name="submit" src="/hms/jsp/images/search.png" id="srcImg" alt="Search"  title="Search" style="height: 15px; width: 15px;float:right;cursor:pointer;position:relative;top:3px;padding-left:5px;display:block;"></div>';
		dialogFormHTML += '<label id="reccnt">No. of records :<span id="reccount" ></span> </label><label id="nosuggestion">No suggestions found</label><label id="norec">No results found</label><label id="msg3chars">Please enter atleast 3 characters</label>';
		divDialogForm = '<div id="dialog-form" style="width: 540px;">'+ dialogFormHTML + '</div>';
		$('body').append(divDialogForm);
		dialogData = '';
		dialogHTML = '<div id="dialog-message"'+ dialogData + '</p></div>';
		$('body').append(dialogHTML);
	
		var dialog = $("#dialog-form").dialog({autoOpen : false,height : 160,width : 600,modal : true,buttons : {
				"." : function(event) {
				}}
			});
		dialog.data("uiDialog")._title = function(title) {
			title.html(this.options.title);
		};
		
		if (document.getElementById("conceptdiv"))
			$("#conceptdiv").remove();
		dialog.dialog('option','title','Snomed Procedures<img align="right" style="position:relative;vertical-align: text-bottom; height: 20%; width: 36px; top: 0px;"');
		
		
		$("#clearTable").click(function(){
			$( "#procedureTable tbody tr" ).each( function(){
				  this.parentNode.removeChild( this ); 
			});
			$("#tableRow" ).val(0);
		});
	});
	
	
	
	
	$("#searchProcedure").mouseover(function() {
	    var x = jQuery(this).position().left + jQuery(this).outerWidth();
	    var y = jQuery(this).position().top - jQuery(document).scrollTop();
	    jQuery("#dialog-form").dialog('option', 'position', [x,y]);
	});
    
    
	
	var callbck_concept_index =function(ret_OUT){setValueConceptId(ret_OUT);};
	var callbck_index =function(ret_OUT,iteration){setValue(ret_OUT,iteration);};
	var semantictag_IN;
	var acceptability_IN;
	var state_IN ;
	var returnlimit_IN;
	var retterm_value ={};
	function setValue(selectedSNOMEDTerm,iteration)
	{	
		document.getElementById("chargeId"+iteration).value=selectedSNOMEDTerm;
	}
	function isNumeric(e)
	{
	e.value = (e.value.replace(/[^0-9]/g, ''));
	}
	function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
	}

	function checkMainChargeForUpdate(){
	var mainChargeForUpdateButton=document.chargeCode.<%= MAIN_CHARGECODE_ID%>.options[document.chargeCode.<%= MAIN_CHARGECODE_ID%>.selectedIndex].text;
	var subChargeForUpdateButton=document.chargeCode.<%= SUB_CHARGECODE_ID%>.options[document.chargeCode.<%= SUB_CHARGECODE_ID%>.selectedIndex].text;
		if(mainChargeForUpdateButton != "Select" ){
			editForm('chargeCode','/hms/hms/hospital?method=editChargeCode')
		}else{
		alert("Parent is InActivated!")
		}
	}

	function getDiscValue(val)
	{
		if(document.getElementById('CheckBoxdisc').checked == true)
		{
		}
		else
		{
		   document.getElementById('discountPercId').value = "0";
		}
	}
	
	function checkDiscValue(val)
	{
		if(parseInt(val) > 0)
		{
		  document.getElementById('CheckBoxdisc').checked = true;
		}
		else
		{
			document.getElementById('CheckBoxdisc').checked = false;
		}
	}
	function submitCharge(){
		var tableRow=document.getElementById("tableRow").value;
		var flag=0;
		for(var count=0;count<tableRow;count++){
			if(document.getElementById("chargerate"+count).value==""){
				alert("please fill charge rate !");
				document.getElementById("chargerate"+count).focus();
				flag=1;
				break;
			}
		}
		if(flag==0 && confirm("Do you want to save.")){
			submitForm('chargeCode','hospital?method=showSnomedChargeCodeJsp');
		}
	}
</script>
