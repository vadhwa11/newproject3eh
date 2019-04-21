<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%
Map<String, Object> map = new HashMap<String, Object>();
List<MasChargeCode> chargeCodeList=new ArrayList<MasChargeCode>();
List<MasAuthorizer> authorizerList=new ArrayList<MasAuthorizer>();
String billNo="";
BigDecimal amount=new BigDecimal(0.00);
BigDecimal rate=new BigDecimal(0.00);
BigDecimal stdDeduction = new BigDecimal(0.00);
BigDecimal discAmt = new BigDecimal(0.00);
int regChargeId = 0;

if(request.getAttribute("map") != null)
{
	map=(Map<String, Object>)request.getAttribute("map");
}
if (map.get("billNo") != null) 
{
	billNo = (String) map.get("billNo");
}
if(map.get("amount")!=null)
{
	amount=(BigDecimal)map.get("amount");
}
if(map.get("rate") != null)
{
	rate = (BigDecimal)map.get("rate");
}
if (map.get("discAmt") != null) 
{
	discAmt =  (BigDecimal)map.get("discAmt");
}
if (map.get("stdDeduction") != null) 
{
	stdDeduction = (BigDecimal)map.get("stdDeduction");
}
if(map.get("chargeCodeList") != null)
{
	chargeCodeList = (List<MasChargeCode>)map.get("chargeCodeList");
}
if (map.get("regChargeId") != null) 
{
	regChargeId =  (Integer)map.get("regChargeId");
}
if(map.get("authorizerList") != null)
{
	authorizerList = (List<MasAuthorizer>)map.get("authorizerList");
}

URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>


	
<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Properties"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.MasAuthorizer"%><div id="testDiv">
		<label><%=prop.getProperty("com.jkt.hms.bill_no")%></label> 
		<input type="text" id="billNo" class="readOnly" name="billNo" value="<%=billNo%>" readonly="readonly" 
		title="Bill No of the Patient" validate="Bill No,int,no" MAXLENGTH="15" />
	
		<div id="amount">
			<label>Amount</label> 
			<input type="text" id="amt" name="amt" value="<%=amount.setScale(2,BigDecimal.ROUND_HALF_UP) %>" MAXLENGTH="4" readonly="readonly" class="readOnly" /> 
			
			<input type="hidden" name="billamt" id="billamt" value="<%=rate%>" MAXLENGTH="4" class="readOnly" readonly="readonly" /> 
			<input type="hidden" name="stdDeduction" id="stdDeduction" value="<%=stdDeduction%>" MAXLENGTH="4" class="readOnly"	readonly="readonly" />
			<input type="hidden" name="discAmt"	id="discAmt" value="<%=discAmt%>" MAXLENGTH="4" class="readOnly" readonly="readonly" />
		</div>
	</div>


	<label>Registration Type</label> 
	<select name="regisType" id="regisType" tabindex="45" onchange="submitProtoAjaxWithDivName('registration','/hms/hms/registration?method=getAmount','amount')" onfocus="document.getElementById('loadB').removeAttribute('tabindex')">
		<option value="G">General</option>
		<option value="S">Special</option>
	</select>

	<div class="clear"></div>
	<div id="amount">
		<label><span>*</span> Charge</label> 
		<select name="registrationType"	id="registrationType" tabindex="46" onblur="checkForPatientType();"	onfocus="checkForPatientType();">
<%
		for(MasChargeCode masChargeCode : chargeCodeList)
		{
			if(masChargeCode.getId()==regChargeId)
			{
%>
				<option value="<%=masChargeCode.getId()%>"><%=masChargeCode.getChargeCodeName()%></option>
<%
			}
		}
		for(MasChargeCode masChargeCode : chargeCodeList)
		{
			if(masChargeCode.getId()!=regChargeId)
			{ 
%>
				<option value="<%=masChargeCode.getId()%>"><%=masChargeCode.getChargeCodeName()%></option>
<%
			}
		}
%>
		</select> 
		
		<label><%=prop.getProperty("com.jkt.hms.discount") %></label> 
		<input type="text" id="discount" tabindex="47" name="discount" value="" validate="<%=prop.getProperty("com.jkt.hms.discount") %>, int, no" MAXLENGTH="3"
		onblur="checkForDiscount();" /> 
		
		<label>Authorizer</label> 
		<select name="refDoctor" id="refDoctor" validate="Ref Doctor,string,no"	tabindex="48">
		<option value="0">Select</option>
<%
		for(MasAuthorizer masAuthorizer : authorizerList)
		{
%>
			<option value="<%=masAuthorizer.getId()%>"><%=masAuthorizer.getAuthorizerName()%></option>
<%
		}
%>
		</select>

		<div class="clear"></div>
		
		<label><span>*</span>Actual Collected Amount</label> 
		<input type="text" id="actualColAmtId" name="actualCollectedAmt" tabindex="49" value="<%=amount.setScale(2,BigDecimal.ROUND_HALF_UP) %>"
		validate="Actual Collected Amount,float,no" maxlength="8" /> 
		
		<input type="hidden" id="idForAge" name="idForAge" />
		
		<div class="clear"></div>
	</div>
<Script>
	document.getElementById("loadbIndicator").style.display="none";
	document.getElementById("loadBBlock").style.display="";
	document.getElementById("loadB").setAttribute("onfocus","");
	document.getElementById("loadB").style.cursor="default";
	document.getElementById("regisType").focus();
</Script>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
