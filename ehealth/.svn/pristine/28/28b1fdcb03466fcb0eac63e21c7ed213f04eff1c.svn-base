<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%@page import="jkt.hms.masters.business.FaMasSubLed"%>
<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>

<%@page import="jkt.hms.masters.business.MasCompany"%>
<%@page import="jkt.hms.masters.business.MasPatientType"%>
<%@page import="jkt.hms.masters.business.FaAccountParameter"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/sorttableAccounts.js" type="text/javascript"></script>

<!-- Script for tab content -->
<script type="text/javascript" src="/hms/jsp/js/tabcontent.js">
/***********************************************
* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/
</script>
<script type="text/javascript">

	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}

	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
</script>

<div class="titleBg">
<h2>Account Parameter</h2>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>

<form name="accountsParameter" method="post" action="">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
	List<FaMasSubLed> subLedList = new ArrayList<FaMasSubLed>();
	List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
	List<FaAccountParameter> accountParameterList = new ArrayList<FaAccountParameter>();
	List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if(map.get("accountList")!= null){
		accountList = (List<FaMasAccount>)map.get("accountList");
	}
	if(map.get("subLedList")!= null){
		subLedList= (List<FaMasSubLed>)map.get("subLedList");
	}
	if(map.get("mainChargeCodeList")!= null){
		mainChargeCodeList= (List<MasMainChargecode>)map.get("mainChargeCodeList");
	}
	if(map.get("subChargeCodeList")!= null){
		subChargeCodeList= (List<MasSubChargecode>)map.get("subChargeCodeList");
	}
	if(map.get("accountParameterList")!= null){
		accountParameterList = (List<FaAccountParameter>)map.get("accountParameterList");
	}

	
	//String accountType = "";
	//if(accountParameterList.size()>0){
		//for(FaAccountParameter faAccountsParameter : accountParameterList){
			// accountType = faAccountsParameter.getPaymentMode();
	//	}
	//}


%>
<ul id="countrytabs" class="shadetabs">
<label><a href="#" rel="country1" class="selected">Billing</a></label>
<label><a href="#" rel="country2" >Main Charge</a></label>
</ul>
<div class="clear"></div>
<div class="tabcontainer">
<div id="country1" class="tabcontent">
<div class="titleBg">
<h4>Accounts Parameter</h4>
</div>

<div class="clear"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<table  width="100%" border="0" id="accIdForBilling" cellspacing="0" cellpadding="0" >
	<tr>
		<th scope="col">Select</th>
		<th scope="col">Payment Mode</th>
		<th scope="col">GL</th>
		<th scope="col">SL</th>
		<th scope="col"></th>
	</tr>
		<%int r = 1; %>
		<tr>
		<td><input type="radio" value="" name="selectedBankChrage" class="radioCheck" /></td>
			<td><select name="<%=PAYMENT_MODE%>" id ="paymentModeId<%=r%>"  >
				<option value="">Select</option>
				<option value="Cash">Cash</option>
				<option value="Cheque">Cheque</option>
				<option value="Bank">Bank</option>
				<option value="Credit Card">Credit Card</option>
					<option value="Discount">Discount</option>
						<option value="Charity">Charity</option>
							<option value="Mis.Account">Mis.Account</option>
							<option value="Round Off">Round Off</option>
							<option value="Sales Medicine">Sales Medicine</option>
				
				</select></td>
			<td><select name="acc_id" id="accId<%=r %>" onChange="populateSubLedgerForCash(this.value,'accountsParameter','<%=r%>')" >
				<option value="0">Select</option>
				<%if(accountList.size()>0){
				for(FaMasAccount account :accountList){

				%>
				<option value="<%=account.getId() %>"><%=account.getAccDesc() %></option>
				<%}} %>
					</select></td>
			<td>
			<select name="sub_led_id" id="subLedgId<%=r%>">
				<option value="0">Select</option>
				<%if(subLedList.size()>0){
				for(FaMasSubLed subLed:subLedList){%>
				<option value="<%=subLed.getId() %>"><%=subLed.getSubLedDesc() %></option>
				<%}} %>
					</select>
					</td>
				<td><input type="button" name="add" value="<%=r%>" class="buttonAdd" onclick="addRowForBilling();" tabindex="1" /></td>			
		</tr>	

</table>
<div class="clear"></div>
	<input type="hidden" value="<%=r %>" name="hiddenValueForBilling" id="hiddenValueForBilling" />
<script type="text/javascript">
function addRowForBilling(){
	var tbl = document.getElementById('accIdForBilling');
	var lastRow = tbl.rows.length;

	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hiddenValueForBilling');
	var iteration = parseInt(hdb.value)+1;
	hdb.value = iteration;


	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'radio';
	e0.name='selectedChrage';
	e0.className='radioCheck';
	e0.value=(iteration);
	cell0.appendChild(e0);

	

	var cell1 = row.insertCell(1);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Cash', 'Cash');
	e1.options[2] = new Option('Bank', 'Bank');
	e1.options[3] = new Option('Cheque', 'Cheque');
	e1.options[4] = new Option('CreditCard', 'CreditCard');
	e1.options[5] = new Option('Discount', 'Discount');
	e1.options[6] = new Option('Charity', 'Charity');
	e1.options[7] = new Option('Mis.Account', 'Mis.Account');
	e1.options[8] = new Option('Round Off', 'Round Off');
	e1.options[9] = new Option('Sales Medicine', 'Sales Medicine');
	
	e1.name='<%=PAYMENT_MODE%>';
	e1.id='paymentModeId'+(iteration);
	cell1.appendChild(e1);

	var cell2 = row.insertCell(2);
	var e2 = document.createElement('select');
	e2.name='acc_id';
	e2.id='accId'+(iteration);
	e2.options[0] = new Option('Select', '0');
	for(var c = 0;c<accountArray.length;c++){
		e2.options[c+1] = new Option(accountArray[c][1],accountArray[c][0]);
	}
	e2.onchange = function(){
		populateSubLedgerForCash(this.value,'accountsParameter',(iteration))
			  };
	cell2.appendChild(e2);

	var cell3 = row.insertCell(3);
	var e3 = document.createElement('select');
	e3.name='sub_led_id';
	e3.id='subLedgId'+(iteration);
	e3.options[0] = new Option('Select', '0');
	for(var d = 0;d<subLedgerArr.length;d++){
		e3.options[d+1] = new Option(subLedgerArr[d][1],subLedgerArr[d][0]);
	}
	cell3.appendChild(e3);



	var cell4 = row.insertCell(4);
	var e4 = document.createElement('input');
	e4.type = 'button';
	e4.name='add';
	e4.className = 'buttonAdd';
	e4.tabIndex="1";
	e4.onclick = function(){
		addRowForBilling();
	}
	cell4.appendChild(e4);
}</script>

		<script type="text/javascript">
         var subLedgerArr = new Array();
		<%
			int counter = 0;
		for (FaMasAccount faMasAccount:accountList)
			{

				for (FaMasSubLed faMasSubLed:subLedList)
				{

					if(faMasAccount.getId().equals(faMasSubLed.getAccount().getId())){
								%>
								subLedgerArr[<%=counter%>] = new Array();
								subLedgerArr[<%=counter%>][0] = <%=faMasAccount.getId()%>;
								subLedgerArr[<%=counter%>][1] = <%=faMasSubLed.getId()%>;
								subLedgerArr[<%=counter%>][2] = "<%=faMasSubLed.getSubLedDesc()%>";

								<%
								counter++;
						}	} } %>
		</script>
		<script type="text/javascript">
         var subLedArray = new Array();
		<%
			int cnt = 0;
		for (FaMasAccount faMasAccount:accountList)
			{

				for (FaMasSubLed faMasSubLed:subLedList)
				{

					if(faMasAccount.getId().equals(faMasSubLed.getAccount().getId())){
								%>
								subLedArray[<%=cnt%>] = new Array();
								subLedArray[<%=cnt%>][0] = <%=faMasAccount.getId()%>;
								subLedArray[<%=cnt%>][1] = <%=faMasSubLed.getId()%>;
								subLedArray[<%=cnt%>][2] = "<%=faMasSubLed.getSubLedDesc()%>";

								<%
								cnt++;
						}	} } %>
		</script>
<div class="clear"></div>
	
<input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="submitForm('accountsParameter','account?method=submitAccountsParameter');" accesskey="a" tabindex=1 />

 <div class="clear"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName %> </label>

<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
 <label class="value"><%=time%></label>
  <input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName %>" />
   <input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
    <input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>

</div>


<script type="text/javascript">
var mainChargeArray =new Array();

<%  int j=0;

for(MasMainChargecode mainChargecode:mainChargeCodeList){
%>

			mainChargeArray[<%=j%>]= new Array();
			mainChargeArray [<%=j%>][0] = "<%=mainChargecode.getId()%>";
			mainChargeArray [<%=j%>][1] = "<%=mainChargecode.getMainChargecodeName()%>";


<%j++;} %>


var accountArray =new Array();

<%  int n=0;

for(FaMasAccount masAccount:accountList){
%>

			accountArray[<%=n%>]= new Array();
			accountArray [<%=n%>][0] = "<%=masAccount.getId()%>";
			accountArray [<%=n%>][1] = "<%=masAccount.getAccDesc()%>";


<%n++;} %>

var subLedgerArray =new Array();

<%  int p=0;

for(FaMasSubLed masSubLed:subLedList){
%>

			subLedgerArray[<%=p%>]= new Array();
			subLedgerArray[<%=p%>][0] = "<%=masSubLed.getId()%>";
			subLedgerArray[<%=p%>][1] = "<%=masSubLed.getSubLedDesc()%>";


<%p++;} %>

var subChargeArr1 =new Array();

<%  int l=0;

for(MasSubChargecode masSubChargecode:subChargeCodeList){
%>

			subChargeArr1[<%=l%>]= new Array();
			subChargeArr1[<%=l%>][0] = "<%=masSubChargecode.getId()%>";
			subChargeArr1[<%=l%>][1] = "<%=masSubChargecode.getSubChargecodeName()%>";


<%l++;}%>
</script>

<div class="clear"></div>

<div id="country2" class="tabcontent">
<div class="paddingTop5"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<table  width="100%" border="0" id="accountsDetail" cellspacing="0" cellpadding="0" >
	<tr>
		<th scope="col">Select</th>
		<th scope="col">Main charge</th>
		<th scope="col">Sub Charge</th>
		<th scope="col">GL</th>
		<th scope="col">SL</th>
		<th scope="col"></th>
	</tr>
	<%int i = 1; %>

		<tr>

			<td><input type="radio" value="" name="selectedBankChrage" class="radioCheck" /></td>
			<td><select name="<%=MAIN_CHARGECODE_ID %>" id="mainChargecodeId<%=i %>" onChange="populateSubChargeForAccounts(this.value,'accountsParameter','<%=i%>')">
				<option value="0">Select</option>
				<%if(mainChargeCodeList.size()>0){
				for(MasMainChargecode mainChargecode : mainChargeCodeList){ %>
				<option value="<%=mainChargecode.getId() %>"><%=mainChargecode.getMainChargecodeName() %></option>
				<%}} %>
					</select></td>
				<td><select name="<%=SUB_CHARGECODE_ID %>" id="subChargeCodeId<%=i%>">
						<option value="0">Select</option>
					<%if(subChargeCodeList.size()>0){ 
					for(MasSubChargecode masSubChargecode:subChargeCodeList){
				
					%>
					<option value="<%=masSubChargecode.getId() %>"><%=masSubChargecode.getSubChargecodeName() %></option>
				<%}} %>
					</select></td>
				<td><select name="<%=ACCOUNT_ID %>" id="accountId<%=i %>" onChange="populateSubLed(this.value,'accountsParameter',<%=i%>)">
				<option value="0">Select</option>
				<%if(accountList.size()>0){
					for(FaMasAccount masAccount:accountList){
					%>
					<option value="<%=masAccount.getId() %>"><%=masAccount.getAccDesc() %></option>
				<%}} %>
					</select></td>
					<td><select name="<%=SUB_LEDGER_ID %> id="subLedId<%=i%>">
				<option value="0">Select</option>
				<%if(subLedList.size()>0){
					for(FaMasSubLed masSubLed:subLedList){
					%>
					<option value="<%=masSubLed.getId() %>"><%=masSubLed.getSubLedDesc() %></option>
				<%}} %>
					</select></td>
		<td><input type="button" name="add" value="<%=i%>" class="buttonAdd" onclick="addRow();" tabindex="1" /></td>

		</tr>

</table>
<input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="submitForm('accountsParameter','account?method=submitAccountsParameterMainCharge');" accesskey="a" tabindex=1 />
<input type="hidden" value="<%=i %>" name="hiddenValueForAccounts" id="hiddenValueForAccounts" />

<div class="clear"></div>
</div>
<script type="text/javascript">
function addRow(){
	var tbl = document.getElementById('accountsDetail');
	var lastRow = tbl.rows.length;

	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hiddenValueForAccounts');
	var iteration = parseInt(hdb.value)+1;
	hdb.value = iteration;


	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'radio';
	e0.name='selectedChrage';
	e0.className='radioCheck';
	e0.value=(iteration);
	cell0.appendChild(e0);

	var cell1 = row.insertCell(1);
	var e1 = document.createElement('select');
	e1.name='<%=MAIN_CHARGECODE_ID%>';
	e1.id='mainChargeId'+(iteration);
	e1.options[0] = new Option('Select', '0');
	for(var k = 0;k<mainChargeArray.length;k++){
		e1.options[k+1] = new Option(mainChargeArray[k][1],mainChargeArray[k][0]);
	}
	e1.onchange = function(){
		populateSubChargeForAccounts(this.value,'accountsParameter',(iteration))
		};
	cell1.appendChild(e1);

	var cell2 = row.insertCell(2);
	var e2 = document.createElement('select');
	e2.name='<%=SUB_CHARGECODE_ID%>';
	e2.id='subChargeCodeId'+(iteration);
	e2.options[0] = new Option('Select', '0');
	for(var m = 0;m<subChargeArr1.length;m++){
		e2.options[m+1] = new Option(subChargeArr1[m][1],subChargeArr1[m][0]);
	}
	cell2.appendChild(e2);

	var cell3 = row.insertCell(3);
	var e3 = document.createElement('select');
	e3.name='<%=ACCOUNT_ID%>';
	e3.id='accountId'+(iteration);
	e3.options[0] = new Option('Select', '0');
	for(var c = 0;c<accountArray.length;c++){
		e3.options[c+1] = new Option(accountArray[c][1],accountArray[c][0]);
	}
	e3.onchange = function(){
						populateSubLed(this.value,'accountsParameter',(iteration))
			  };
	cell3.appendChild(e3);

	var cell4 = row.insertCell(4);
	var e4 = document.createElement('select');
	e4.name='<%=SUB_LEDGER_ID%>';
	e4.id='subLedId'+(iteration);
	e4.options[0] = new Option('Select', '0');
	for(var d = 0;d<subLedgerArray.length;d++){
		e4.options[d+1] = new Option(subLedgerArray[d][1],subLedgerArray[d][0]);
	}
	cell4.appendChild(e4);



	var cell5 = row.insertCell(5);
	var e5 = document.createElement('input');
	e5.type = 'button';
	e5.name='add';
	e5.className = 'buttonAdd';
	e5.tabIndex="1";
	e5.onclick = function(){
					addRow();
	}
	cell5.appendChild(e5);
}

var subChargeArr = new Array();
<%
	int count = 0;
for (MasMainChargecode mainChargecode:mainChargeCodeList)
	{

		for (MasSubChargecode masSubChargecode:subChargeCodeList)
		{

			if(mainChargecode.getId().equals(masSubChargecode.getMainChargecode().getId())){
						%>
						subChargeArr[<%=count%>] = new Array();
						subChargeArr[<%=count%>][0] = <%=mainChargecode.getId()%>;
						subChargeArr[<%=count%>][1] = <%=masSubChargecode.getId()%>;
						subChargeArr[<%=count%>][2] = "<%=masSubChargecode.getSubChargecodeName()%>";

						<%
						count++;
				}	} } %>












</script>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</div>
</form>


<script type="text/javascript">
var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script>

<style>
table td {height:40px;}
</style>

