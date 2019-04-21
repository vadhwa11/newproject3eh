
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

<script type="text/javascript">
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
	
</script>

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
	List<MasHospitalwiseChargecode> searchChargeCodeList = new ArrayList<MasHospitalwiseChargecode>();
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
	int hospitalId =0 ;
	
	if(session.getAttribute("hospitalId") != null){
		hospitalId = (Integer)session.getAttribute("hospitalId");
	}
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
	<h2>Local Charge Code Master</h2>
</div>
<div class="Block">
	<div id="searcharea">
		<div id="searchbar">

			<form name="search" method="post" action="">
				<label>ChargeCode</label>
				<input type="radio"	name="<%=SELECTED_RADIO %>" value="1" checked="checked"	class="radiobutMargin" />
			    <label >Charge Name</label>
				<input type="radio" class="radiobutMargin" name="<%=SELECTED_RADIO %>" value="2" /> 
				<input type="text" class="date" name="<%= SEARCH_FIELD%>" value=""	validate="ChargeCode Name,string,no" MAXLENGTH="8" tabindex=1 />
				 <label> Main Service Head</label> <select id="mainChargeName"
					name="<%=MAIN_CHARGECODE_ID %>" validate="MainCharge,string,No"
					onChange="populateSubChargeCode(this.value,'chargeCode')"
					tabindex=1>
					<option value="">Select</option>
					<%
for (MasMainChargecode mainChargecode : mainChargeList)
{
%>
					<option value="<%=mainChargecode.getId ()%>"><%=mainChargecode.getMainChargecodeName()%></option>
					<%	}
%>
				</select> 
				
				<%-- <select name="<%= MAIN_CHARGECODE_ID %>" validate="Main Service Head,string,yes" tabindex=1 onkeypress="return submitenter(this,event,'hospital?method=addSubCharge')"> <option value="">Select</option>
<% 
			for (MasMainChargecode  masMainChargecode : mainChargeCodeList){
          %>
	<option value="<%=masMainChargecode.getId ()%>"><%=masMainChargecode.getMainChargecodeName()%></option>

	<%}%>
</select> --%>

				<input type="submit" name="search" value="Search" class="button"
					onclick="submitForm('search','hospital?method=searchLocalChargeCode')"
					tabindex=1 /> <input type="button" name="Report"
					value="Generate Report" class="buttonBig"
					onClick="submitForm('search','hospital?method=printMainWiseCharge');"
					accesskey="g" tabindex=1 />
				<!--      
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_charge_code">-->
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
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
		<a href="hospital?method=showLocalChargeCodeJsp">Show All Records</a>
	</h4>
	<%
 	}
 	}
 if(searchChargeCodeList.size()==0 && map.get("search") != null){
	 %>
	<h4>
		<a href="hospital?method=showLocalChargeCodeJsp">Show All Records</a>
	</h4>
	<%  }%>
	<script type="text/javascript">

	formFields = [
	 	[0, "<%= CHARGE_CODE_ID%>", "id"], [1,"<%= CHARGE_CODE %>"], [2,"<%= CHARGE_NAME %>"],[3,"<%= CHARGE %>"], [4,"<%= MAIN_CHARGECODE_ID%>"], [5,"<%= SUB_CHARGECODE_ID%>"],[6,"<%= CHARGE_TYPE_ID%>"],[7,"<%= DEPARTMENT_ID%>"],[8,"<%= EFFECTIVE_DATE_FROM%>"],[9,"<%= EFFECTIVE_DATE_TO%>"],[10,"<%= FA_ACCOUNT_ID%>"],[11,"<%= EDITABLE%>"],[12,"<%= DISCOUNTABLE%>"],[13,"<%=DISCOUNT_PERCENTAGE%>"],[14,"<%= DR_ACC_REQ%>"], [15,"<%=FA_SUB_LED_ID%>"], [16,"<%=CHANGED_BY%>"],[17,"<%= CHANGED_DATE%>"],[18,"<%= CHANGED_TIME%>"],[19,"<%= STATUS%>"],[20,"<%=FA_MAS_SUB_LED%>"],[21,"<%=STD_DEDUCTION_GEN%>"],[22,"<%=STD_DEDUCTION_SPL%>"],[23,"mainChrge"], [24,"proceCode"], [25,"pacsInteg"], [26,"telemediInteg"] ];
	  statusTd = 19;
	</script>
</div>
<div class="clear"></div>
<script type="text/javascript">

function testForm(){
		alert(document.chargeCode.action)
		submitForm(chargeCode,contentspace,'/hms/hms/hospital?method=deleteSubTest');

	}


function deleteChargeCode(){
	var subChargeId1=document.chargeCode.<%= SUB_CHARGECODE_ID%>.options[document.chargeCode.<%= SUB_CHARGECODE_ID%>.selectedIndex].text;
	var mainChargeId1=document.chargeCode.<%= MAIN_CHARGECODE_ID%>.options[document.chargeCode.<%= MAIN_CHARGECODE_ID%>.selectedIndex].text;

	 if(mainChargeId1=="Select"){
	alert('Parent is InActivated!');
	}
	else{
	deleteForm('chargeCode','/hms/hms/hospital?method=deleteLocalChargeCode');
}
}
</script>

<form name="chargeCode" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<input type="hidden" name="<%= POJO_NAME %>" value="MasChargeCode">
		<input type="hidden" name="<%=POJO_PROPERTY_NAME %>"
		value="ChargeCodeName"> <input type="hidden" name="title"
			value="ChargeCode"> <input type="hidden"
				name="<%=JSP_NAME %>" value="chargeCode"> <input
					type="hidden" name="pojoPropertyCode" value="ChargeCodeCode">
<div class="paddingTop5"></div>
<div class="Block">
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
								<option value="<%=subChargecode.getId ()%>"><%=subChargecode.getSubChargecodeName()%></option>
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
							<label><span>*</span> Department </label> <select id="depName"
								name="<%=DEPARTMENT_ID %>" validate="Department,string,yes"
								tabindex=4>
								<option value="">Select</option>
								<%
				    for (MasDepartment department : departmentList){
				%>
								<option value="<%=department.getId ()%>"><%=department.getDepartmentName().trim()%></option>
								<%}%>
							</select> 
							<label><span>*</span> Service Code </label> <input type="text "
								name="<%=CHARGE_CODE%>" value=""
								validate="Service Code,string,yes" class="textbox_size20"
								MAXLENGTH="8" / tabindex=5> 
							<label><span>*</span>
									Service Name </label> <input type="text" name="<%= CHARGE_NAME %>"
								value="" validate="Service Name,string,yes"
								class="textbox_size20" MAXLENGTH="100" tabindex=6 /><script>document.chargeCode.<%=CHARGE_CODE%>.focus(); </script>

							<div class="clear"></div>
							<div class="clear"></div>
							<label><span>*</span> Charge</label> <input
								type="text" name="<%=CHARGE%>" value=""
								validate="Charge,floatWithoutSpaces,no" class="textbox_size20"
								maxlength="8" tabindex="7" />
							
							<label><span>*</span>Effective
									From</label> <input type="text" class="date" id="fromDateId"
								name="<%=EFFECTIVE_DATE_FROM %>" value="<%=currentDate %>"
								readonly="readonly" MAXLENGTH="30" /> <img
								src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
								validate="Pick a date"
								onClick="setdate('<%=currentDate %>',document.chargeCode.<%=EFFECTIVE_DATE_FROM%>,event)" />


								<div class="clear"></div>
						<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
						<input type="hidden" name="<%=CHANGED_DATE %>"
						value="<%=currentDate%>" /> <input type="hidden"
						name="<%=CHANGED_TIME %>" value="<%=time%>" /> <!--Bottom labels starts-->
						<div class="clear"></div>
						
						<div id="edited"></div> 
						<!-- <input type="button" name="add"
						id="addbutton" value="Add" class="button"
						onClick="submitForm('chargeCode','hospital?method=addChargeCode');"
						accesskey="a" tabindex=16 />  -->
						<input type="button" name="edit"
						id="editbutton" value="Update" class="button"
						style="display: none;" onClick="checkMainChargeForUpdate();"
						accesskey="u" tabindex=17 /> 
						<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" style="display: none;"
						onClick="submitForm('chargeCode','hospital?method=deleteLocalChargeCode&flag='+this.value,'deleteChargeCode()')"
						accesskey="d" tabindex=18 />
						
						 <input type="reset" name="Reset"
						id="reset" value="Reset" class="buttonHighlight"
						onclick="resetCheck();" accesskey="r" tabindex="19" /> <input
						type="hidden" name="<%=STATUS %>" value="" /> <input
						type="hidden" name="<%= CHARGE_CODE_ID%>" value="" /> <!-- Added By Ritu for edit page-->
						<input type="hidden" id="pageNoEdit" name="pageNoEdit"
						value="<%=pageNo %>" />
						<div class="clear"></div>
						</div>
						</form>

						<div class="bottom">
							<label>Changed By:</label> <label class="value"><%=userName%></label>
							<label>Changed Date:</label> <label class="value"><%=currentDate%></label>
							<label>Changed Time:</label> <label class="value"><%=time%></label>
						</div> <!--Bottom labels ends-->
						<div class="clear"></div>
					
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

data_header[8]=new Array;
data_header[8][0]="EffectiveTo Date"
data_header[8][1]="hide";
data_header[8][2]=0;
data_header[8][3]="<%= EFFECTIVE_DATE_TO%>";

data_header[9]=new Array;
data_header[9][0]="Account"
data_header[9][1]="hide";
data_header[9][2]=0;
data_header[9][3]="<%=FA_ACCOUNT_ID %>";

data_header[10]=new Array;
data_header[10][0]="Editable"
data_header[10][1]="hide";
data_header[10][2]=0;
data_header[10][3]="<%= EDITABLE%>";

data_header[11]=new Array;
data_header[11][0]="Discountable"
data_header[11][1]="hide";
data_header[11][2]=0;
data_header[11][3]="<%= DISCOUNTABLE%>";

data_header[12]=new Array;
data_header[12][0]=""
data_header[12][1]="hide";
data_header[12][2]=0;
data_header[12][3]="<%= DISCOUNT_PERCENTAGE%>";

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = 0;
data_header[13][3] = "<%= DR_ACC_REQ%>";

data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = 0;
data_header[14][3] = "<%= FA_MAS_SUB_LED%>";

data_header[15] = new Array;
data_header[15][0] = ""
data_header[15][1] = "hide";
data_header[15][2] = 0;
data_header[15][3] = "<%= CHANGED_BY%>";

data_header[16] = new Array;
data_header[16][0] = "LastChangeBy"
data_header[16][1] = "hide";
data_header[16][2] = 0;
data_header[16][3] = "<%= CHANGED_BY%>";

data_header[17] = new Array;
data_header[17][0] = ""
data_header[17][1] = "hide";
data_header[17][2] = 0;
data_header[17][3] = "<%= CHANGED_TIME%>";

data_header[18] = new Array;
data_header[18][0] = "Status"
data_header[18][1] = "data";
data_header[18][2] = 0;
data_header[18][3] = "<%= STATUS%>";

data_header[19] = new Array;
data_header[19][0] = "Fa mas Sub Led"
data_header[19][1] = "hide";
data_header[19][2] = 0;
data_header[19][3] = "<%= FA_MAS_SUB_LED%>";

data_header[20] = new Array;
data_header[20][0] = "Std. Deduction (General)"
data_header[20][1] = "hide";
data_header[20][2] = 0;
data_header[20][3] = "<%= STD_DEDUCTION_GEN%>";

data_header[21] = new Array;
data_header[21][0] = "Std. Deduction (Special)"
data_header[21][1] = "hide";
data_header[21][2] = 0;
data_header[21][3] = "<%= STD_DEDUCTION_SPL%>";

data_header[22] = new Array;
data_header[22][0] = ""
data_header[22][1] = "hide";
data_header[22][2] = 0;
data_header[22][3] = "mainChrge";

data_header[23] = new Array;
data_header[23][0] = ""
data_header[23][1] = "hide";
data_header[23][2] = 0;
data_header[23][3] = "proceCode";

data_header[24] = new Array;
data_header[24][0] = ""
data_header[24][1] = "hide";
data_header[24][2] = 0;
data_header[24][3] = "pacsInteg";

data_header[25] = new Array;
data_header[25][0] = ""
data_header[25][1] = "hide";
data_header[25][2] = 0;
data_header[25][3] = "telemediInteg";

data_arr = new Array();
<%
        Iterator itrCC=searchChargeCodeList.iterator();
        int  counter=0;
          while(itrCC.hasNext())
           {
        	  MasHospitalwiseChargecode  masChargeCode = (MasHospitalwiseChargecode)itrCC.next();
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masChargeCode.getChargeCode().getId()%>
data_arr[<%= counter%>][1] = '<%=masChargeCode.getChargeCode().getChargeCodeCode()%>';

<%

		 StringBuffer output_str1 = new StringBuffer();
		 StringTokenizer s1 = new StringTokenizer(masChargeCode.getChargeCode().getChargeCodeName().toString(),"\"");

		 while (s1.hasMoreTokens())
		 {
		 output_str1.append(s1.nextToken());
		 if (s1.hasMoreTokens())
		 {
		 output_str1.append("\\");
		 output_str1.append("\"");
		 }
		 }
		%>

data_arr[<%= counter%>][2] = "<%=output_str1 %>";
<%
	BigDecimal rate = new BigDecimal(0.00);
	Set<MasChargeCodeRates> rateSet = new HashSet<MasChargeCodeRates>();
	if(masChargeCode.getChargeCode().getMasChargeCodeRates() != null){
		rateSet = masChargeCode.getChargeCode().getMasChargeCodeRates();
	}
	if(rateSet.size() > 0){
		for(MasChargeCodeRates chargeCodeRates :rateSet){
			/* if(chargeCodeRates.getEffectiveToDate() == null){ */
				if(chargeCodeRates.getHospital()!=null && chargeCodeRates.getHospital().getId() == hospitalId){
				rate = chargeCodeRates.getRate();
				}
			/* } */
		}
	}else{
		rate = new BigDecimal(masChargeCode.getChargeCode().getCharge());
	}
%>

data_arr[<%= counter%>][3] = "<%= rate%>"
<%
			Iterator itrGridMainChargeList=mainChargeList.iterator();
			 while(itrGridMainChargeList.hasNext())
	            {
				 try
				 {
	             MasMainChargecode  mainChargecode = (MasMainChargecode)itrGridMainChargeList.next();
				 if(masChargeCode.getChargeCode().getMainChargecode().getId().equals(mainChargecode.getId()) && mainChargecode.getStatus().equalsIgnoreCase("y"))
				 {%>
				data_arr[<%= counter%>][4] = "<%=mainChargecode.getMainChargecodeName().trim()%>"
			<% }
			 else if(masChargeCode.getChargeCode().getMainChargecode().getId().equals(mainChargecode.getId()) && mainChargecode.getStatus().equalsIgnoreCase("n"))
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
		             if(masChargeCode.getChargeCode().getSubChargecode()!=null){
		            	 if(masChargeCode.getChargeCode().getSubChargecode().getId().equals(subChargecode.getId()) && subChargecode.getStatus().equalsIgnoreCase("y"))
						 { %>

							data_arr[<%= counter%>][5] = "<%=subChargecode.getSubChargecodeName()%>"
						<%} else if(masChargeCode.getId().equals(subChargecode.getId()) &&
								subChargecode.getStatus().equalsIgnoreCase("n")){
						%>
							data_arr[<%= counter%>][5] = "<font id='error'>*</font>Parent InActivated--<%=subChargecode.getSubChargecodeName()%>";
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
			 if(masChargeCode.getChargeCode().getChargeType().getId().equals(chargeType.getId()) && chargeType.getStatus().equalsIgnoreCase("y"))
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
             
			 if(masChargeCode.getChargeCode().getDepartment().getId().equals(masDepartment.getId()) && masDepartment.getStatus().equalsIgnoreCase("y"))
			 { %>
				data_arr[<%= counter%>][7] = "<%=masDepartment.getDepartmentName().trim()%>"
			<%}else if(masChargeCode.getChargeCode().getDepartment().getId().equals(masDepartment.getId()) && masDepartment.getStatus().equalsIgnoreCase("n")){
			%>
				data_arr[<%= counter%>][7] = "<font id='error'>*</font>Parent InActivated--<%=masDepartment.getDepartmentName().trim()%>";
			<%}//else{%>
				<%-- data_arr[<%= counter%>][7]="" --%>
				<%//}
			 }catch(Exception e){
				e.printStackTrace();
			} }%>
			<%if(masChargeCode.getChargeCode().getDateEffectiveFrom() != null){%>
			data_arr[<%= counter%>][8] ="<%= HMSUtil.convertDateToStringWithoutTime(masChargeCode.getChargeCode().getDateEffectiveFrom()) %>"
			<%}else{%>
			data_arr[<%= counter%>][8]="";
			<%}%>
			<%if(masChargeCode.getChargeCode().getDateEffectiveTo() != null){%>
			data_arr[<%= counter%>][9] ="<%= HMSUtil.convertDateToStringWithoutTime(masChargeCode.getChargeCode().getDateEffectiveTo()) %>"
			<%}else{%>
			data_arr[<%= counter%>][9]="";
			<%}%>

	<%
		Iterator itrGridAccountList=accountList.iterator();
		 while(itrGridAccountList.hasNext()){
			 try{
             FaMasAccount  masAccount = (FaMasAccount)itrGridAccountList.next();
			 if(masChargeCode.getChargeCode().getAccount()!=null && masChargeCode.getChargeCode().getAccount().getId().equals(masAccount.getId()) && masAccount.getStatus().equalsIgnoreCase("y"))
			 { %>
				data_arr[<%= counter%>][10] = "<%=masAccount.getAccDesc()%>"
			<%}else if(masChargeCode.getChargeCode().getAccount()!=null &&  masChargeCode.getId().equals(masAccount.getId()) && masAccount.getStatus().equalsIgnoreCase("n")){
			%>
				data_arr[<%= counter%>][10] = "<font id='error'>*</font>Parent InActivated--<%=masAccount.getAccDesc()%>";
			<%} }catch(Exception e){
				e.printStackTrace();
			} 
			 }%>
			data_arr[<%= counter%>][11] ="<%= masChargeCode.getChargeCode().getEditable() %>"
			data_arr[<%= counter%>][12] ="<%= masChargeCode.getChargeCode().getDiscountable() %>"
			<%if(masChargeCode.getChargeCode().getDiscountPercentage()!=null&&!masChargeCode.getChargeCode().getDiscountPercentage().toString().equals("")&&!masChargeCode.getChargeCode().getDiscountPercentage().toString().equals("null")){%>
			data_arr[<%= counter%>][13] ="<%= masChargeCode.getChargeCode().getDiscountPercentage() %>"
			<%}else{%>
				data_arr[<%= counter%>][13] ="0"
				<%}%>

			data_arr[<%= counter%>][14] ="<%= masChargeCode.getChargeCode().getDrAccountingRequired() %>"
			<%
			if(masChargeCode.getChargeCode().getSubAccount()!=null){
		Iterator itrGridSubAccountList=subAccountList.iterator();
		 while(itrGridSubAccountList.hasNext()){
			 try{
             FaMasSubLed  faMasSubLed = (FaMasSubLed)itrGridSubAccountList.next();

			 if(masChargeCode.getChargeCode().getSubAccount().getId().equals(faMasSubLed.getId()) && faMasSubLed.getStatus().equalsIgnoreCase("y"))
			 { %>
				data_arr[<%= counter%>][15] = "<%=faMasSubLed.getSubLedDesc()%>"
			<%}else if(masChargeCode.getId().equals(faMasSubLed.getId()) && faMasSubLed.getStatus().equalsIgnoreCase("n")){
			%>
				data_arr[<%= counter%>][15] = "<font id='error'>*</font>Parent InActivated--<%=faMasSubLed.getSubLedDesc()%>";
			<%} }catch(Exception e){
				e.printStackTrace();
			} }}%>


			     data_arr[<%= counter%>][16] ="<%= masChargeCode.getLastChgBy()!=null ?masChargeCode.getLastChgBy().getUserName():"" %> "
				data_arr[<%= counter%>][17] = "<%= masChargeCode.getLastChgDate()!=null ? HMSUtil.convertDateToStringWithoutTime(masChargeCode.getLastChgDate()):""%>"
				data_arr[<%= counter%>][18] ="<%= masChargeCode.getLastChgTime()!=null ? masChargeCode.getLastChgTime():""%> "

<% if(masChargeCode.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][19] = "Active"
<%}else{%>
data_arr[<%= counter%>][19] = "InActive"
<%}%>
<%
			if(masChargeCode.getChargeCode().getSubAccount()!=null){
		Iterator itrGridSubAccountList=subAccountList.iterator();
		 while(itrGridSubAccountList.hasNext()){
			 try{
             FaMasSubLed  faMasSubLed = (FaMasSubLed)itrGridSubAccountList.next();

			 if(masChargeCode.getChargeCode().getSubAccount().getId().equals(faMasSubLed.getId()) && faMasSubLed.getStatus().equalsIgnoreCase("y"))
			 {
				 %>
				data_arr[<%= counter%>][20] = "<%=faMasSubLed.getSubLedDesc()%>"
			<%}else if(masChargeCode.getId().equals(faMasSubLed.getId()) && faMasSubLed.getStatus().equalsIgnoreCase("n")){
			%>
				data_arr[<%= counter%>][20] = "<font id='error'>*</font>Parent InActivated--<%=faMasSubLed.getSubLedDesc()%>";
			<%} }catch(Exception e){
				e.printStackTrace();
			} }

		 %>
<%
	if(masChargeCode.getChargeCode().getStdDeductionGen() != null){
%>
			data_arr[<%= counter%>][21] = "<%=masChargeCode.getChargeCode().getStdDeductionGen()%>"

		 <%}else{
			 %>
			 data_arr[<%= counter%>][21] = ""
		 <%
		 }%>
		 <%
			if(masChargeCode.getChargeCode().getStdDeductionSpl() != null){
		%>
					data_arr[<%= counter%>][22] = "<%=masChargeCode.getChargeCode().getStdDeductionSpl()%>"

				 <%}else{
					 %>
					 data_arr[<%= counter%>][22] = ""
				 <%
				 }
			}%>

			data_arr[<%=counter%>][23] = "<%=masChargeCode.getChargeCode().getMainChargecode().getId() %>";
			
			<% if(masChargeCode.getChargeCode().getProcedureCode() != null)
			{ %>
					data_arr[<%= counter%>][24] = "<%=masChargeCode.getChargeCode().getProcedureCode()%>"
			<%}else{%>
					data_arr[<%= counter%>][24] = ""
			<%}%>
			
			<% 	if(masChargeCode.getChargeCode().getChargePacsStatus() != null && masChargeCode.getChargeCode().getChargePacsStatus().equalsIgnoreCase("y") )
				{
			%>
					data_arr[<%= counter%>][25] = "Yes"
			<%	}
				else if(masChargeCode.getChargeCode().getChargePacsStatus() != null && masChargeCode.getChargeCode().getChargePacsStatus().equalsIgnoreCase("n"))
				{
			%>
					data_arr[<%= counter%>][25] = "No"
			<%
				}
				else
				{
			%>
					data_arr[<%= counter%>][25] = ""
			<%	
				}
			%>
			
			<% 	if(masChargeCode.getChargeCode().getTelemedicineStatus() != null && masChargeCode.getChargeCode().getTelemedicineStatus().equalsIgnoreCase("y") )
				{
			%>
					data_arr[<%= counter%>][26] = "Yes"
			<%	}
				else if(masChargeCode.getChargeCode().getTelemedicineStatus() != null && masChargeCode.getChargeCode().getTelemedicineStatus().equalsIgnoreCase("n"))
				{
			%>
					data_arr[<%= counter%>][26] = "No"
			<%
				}
				else
				{
			%>
					data_arr[<%= counter%>][26] = ""
			<%	
				}
			%>

<%
		     counter++;
	
}
%>
function checkMainChargeForUpdate(){
var mainChargeForUpdateButton=document.chargeCode.<%= MAIN_CHARGECODE_ID%>.options[document.chargeCode.<%= MAIN_CHARGECODE_ID%>.selectedIndex].text;
var subChargeForUpdateButton=document.chargeCode.<%= SUB_CHARGECODE_ID%>.options[document.chargeCode.<%= SUB_CHARGECODE_ID%>.selectedIndex].text;
	if(mainChargeForUpdateButton != "Select" ){
		editForm('chargeCode','/hms/hms/hospital?method=editLocalChargeCode')
	}else{
	alert("Parent is InActivated!")
	}
}

formName = "chargeCode"
	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	makeTable(start,end);

	intializeHover('searchresulttable', 'TR', ' tableover');
</script>