<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreFinancial"%>
<%@page import="jkt.hms.masters.business.MasStoreBudget"%>
<%@page import="java.math.BigDecimal"%>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<%
	StringBuffer orderDateOnly = new StringBuffer();
	GregorianCalendar gregorianCalendar1 = new GregorianCalendar();

	int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
	if (dateOfMonth < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(dateOfMonth);
	} else {
		orderDateOnly.append(dateOfMonth);
	}

	orderDateOnly.append("/");

	int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
	if (month < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(month);
	} else {
		orderDateOnly.append(month);
	}

	orderDateOnly.append("/");
	int year = gregorianCalendar1.get(Calendar.YEAR);
	orderDateOnly.append(year);
	String currentDate = new String(orderDateOnly);
%>

<%
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
	
	int pageNo=1;
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	
	}
	int budgetId=0;
	if(map.get("budgetId")!=null){
		budgetId=Integer.parseInt(""+map.get("budgetId"));
	}
	
	List<MasStoreBudget> searchBudgetList = new ArrayList<MasStoreBudget>();
	//List budgetDetailsList = new ArrayList();
	if(map.get("searchMasStoreBudgetList")!=null)
		searchBudgetList = (List) map.get("searchBudgetList");
		
	//if(map.get("budgetDetailsList")!=null){
		//budgetDetailsList = (List) map.get("budgetDetailsList");
	//}
		
	
	String previousPage="no";
	if(map.get("previousPage")!=null){
		previousPage=(""+map.get("previousPage"));
	
	}
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}

	List<MasStoreFinancial> financialList = new ArrayList<MasStoreFinancial>();
	financialList = (ArrayList)map.get("financialList");
	
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }

%>

<div class="titleBg">
<h2>Budget Master</h2>
</div>
<div class="clear"></div>
<form name="budgetEntryGrid" method="post">
<div class="Block">
<div id="testDiv"><label><span>*</span> Budget Code</label> <label
	class="value">LCH794/01</label> <label><span>*</span> Financial
Year</label> <select id="financialId" name="<%= FINANCIAL_ID %>"
	validate="Financial Year,string,yes" onchange="getFinancialYearInfo()"
	tabindex=1>
	<option value="0">Select</option>
	<% 
			for (MasStoreFinancial  masStoreFinancial : financialList){
			%>
	<option value="<%=masStoreFinancial.getId ()%>"><%=HMSUtil.changeDateToddMMyyyy(masStoreFinancial.getStartDate()) %>
	- <%=HMSUtil.changeDateToddMMyyyy(masStoreFinancial.getEndDate()) %></option>
	<%}%>
</select></div>
<div class="clear"></div>
<h4>Budget Summary Details</h4>

<div id="financial" style="display: none;"></div>
<div id="test" style="display: block;"><label>Total
Allocated Amount</label> <input id="totalAmt" type="text"
	name="<%=TOTAL_ALLOCATED_AMOUNT %>" value="" class="readOnly"
	readonly="readonly" MAXLENGTH="15" tabindex=1 /> <label>GRN
Committed Amount</label> <input type="text" id="crvAmt"
	name="<%=CRV_COMMITTED_AMOUNT %>" value="" class="readOnly"
	readonly="readonly" MAXLENGTH="15" tabindex=1 /> <label>PO
Committed Amount</label> <input type="text" id="soAmt"
	name="<%=PO_COMMITTED_AMOUNT %>" value="" class="readOnly"
	readonly="readonly" MAXLENGTH="15" tabindex=1 />
<div class="clear"></div>

<label>Cumulative Spent Amount</label> <input type="text"
	id="prevSpendAmt" name="<%=PREVIOUS_SPEND_AMOUNT %>" value=""
	class="readOnly" readonly="readonly" MAXLENGTH="15" tabindex=1 /> <label>Spent
Amount</label> <input type="text" id="spendAmt" name="<%= SPEND_AMOUNT%>"
	value="" onblur="calulateBalanceAmount(this.value)" MAXLENGTH="15"
	tabindex=1 /> <label>Balance Amount</label> <input type="text"
	id="balance" name="<%= BALANCE_AMOUNT%>" value="" class="readOnly"
	readonly="readonly" MAXLENGTH="15" tabindex=1 />
<div class="clear"></div>
</div>
<div class="clear"></div>
<h4>Budget Entry Details</h4>
<div class="clear"></div>
<label><span>*</span> Authority Letter
No.</label> <input type="text" name="<%= AUTHORITY_LETTER_NO%>" value=""
	MAXLENGTH="15" tabindex=1 /> <label><span>*</span> Projected
Amount</label> <input type="text" name="<%= PROJECT_AMOUNT%>" value=""
	MAXLENGTH="15" tabindex=1 /> <label><span>*</span> Budgeted
Amount</label> <input type="text" name="<%= BUDGETED_AMOUNT%>" value=""
	MAXLENGTH="15" tabindex=1 />
<div class="clear"></div>
<label class="auto">Additional Allocated Amount</label> <input type="text"
	name="<%= ADDITIONAL_ALLOCATED_AMOUNT%>" value="" MAXLENGTH="15"
	tabindex=1 style="width:175px;" />
<div class="clear"></div>
<input type="button" name="sss" align="right" class="button"
	value="Submit"
	onclick="submitForm('budgetEntryGrid','pharmacy?method=addBudgetDetails')" />
<%--- Report Button   --%> <input type="button" name="Report"
	value="Generate Report Based on Search" class="button"
	onClick="showBudgetReport('budgetEntryGrid')" accesskey="g" tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>"
	value="Mas_store_budjet">
<div class="clear"></div>
</div>

<div class="bottom"><label>Changed By</label> <input type="hidden"
	name="<%= CHANGED_BY%>" value="<%=userName%>" class="readOnly"
	readonly="readonly" MAXLENGTH="15" tabindex=3 /> <label class="value">Changed
By</label> <label>Changed Date</label> <input type="hidden"
	name="<%= CHANGED_DATE %>" value="<%=date%>" class="readOnly"
	readonly="readonly" tabindex=3 /> <label class="value">Changed
By</label> <label>Changed Time</label> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" class="readOnly"
	readonly="readonly" tabindex=3 /> <label class="value">Changed
By</label></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>
<input type="hidden" name="rows" id="rr" value="1" />





