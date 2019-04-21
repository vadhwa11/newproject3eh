<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@ page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>

<%
String sdValues="";
Map<String,Object> map = new HashMap<String,Object>();
Map<String,Object> rateMap=new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
map = (Map<String,Object>) request.getAttribute("map");
}

if(map.get("sdValues") != null){
	sdValues=(String)map.get("sdValues");
}
if(map.get("sdValues") != null){
	sdValues=(String)map.get("sdValues");
}
if(map.get("rateMap") != null){
	rateMap=(Map<String,Object>)map.get("rateMap");
}
Map<String,Object> chargeDetailsMap=new HashMap<String,Object>();
if(map.get("chargeDetailsMap") != null){
	chargeDetailsMap=(Map<String,Object>)map.get("chargeDetailsMap");
}
String strvalue[]=sdValues.split(",");
int inc=1;
int hinId=0;
String chargeId="";
String subchargeId="";
String mainchargeId="";
if(map.get("hinIdd") != null){
	hinId=(Integer)map.get("hinIdd");
}%>
				<tr>
					<th scope="col"></th>
					<th scope="col">Test Name</th>
					<!-- <th scope="col">Test Name</th> -->
					<th scope="col">Qty</th>
					<th scope="col">Rate</th>
					<th scope="col">Amount</th>
					<th scope="col">&nbsp;</th>
				</tr>

<%
for(String str:strvalue){
	
	String rate=rateMap.get(str).toString();
	
	 chargeId=chargeDetailsMap.get("chargeId"+inc).toString();
	 subchargeId=chargeDetailsMap.get("subChargeId"+inc).toString();
	 mainchargeId=chargeDetailsMap.get("mainChargeId"+inc).toString();
	
//System.out.println("sdValues  ::" +str	);%>
				<tr>
					<td><input type="checkbox" value="<%=inc%>"	name="selectedChrage" class="radioCheck" /></td>
					<td><input type="text" name="chargeCode<%=inc%>"	id="chargeCode<%=inc%>" value="<%=str %>"
						onblur="checkInvestigationItem(<%=inc %>);if(validateChargeCodeForAutoComplete(this.value, '<%=inc %>')){dsubmitProtoAjaxWithDivName('investigationOrderBooking','/hms/hms/lab?method=fillChargeCode&rowVal=<%=inc %>&hin=<%=hinId%>','rateVal<%=inc %>');test(<%=inc %>)}"
						tabindex="1" />
						<div id="ac2update<%=inc%>" style="display: none;" class="autocomplete"></div>
						<script type="text/javascript" language="javascript"
							charset="utf-8">
			  function eventCallback(element, entry){
					return entry + "&mainChargeCodeId=" + document.getElementById('mainChargeCodeId').value+"&subChargeCodeId="+document.getElementById('subChargeCodeId').value;
				}
			    new Ajax.Autocompleter('chargeCode<%=inc%>','ac2update<%=inc%>','lab?method=getChargeCodeForAutoComplete',{parameters:'requiredField=chargeCode<%=inc%>', callback: eventCallback});

			</script>
			</td>
					<input type="hidden" value="<%=chargeId %>" name="<%=CHARGE_CODE_ID%><%=inc %>"	id="chargeCodeId<%=inc %>" />
					<input type="hidden" value="<%=mainchargeId %>" name="<%=MAIN_CHARGECODE_ID%><%=inc %>"	id="mainChargeId<%=inc %>" />
					<input type="hidden" value="<%=subchargeId %>" name="<%=SUB_CHARGECODE_ID%><%=inc %>"	id="subCharegId<%=inc %>" />
					
					<td><input type="text" id="qty<%=inc%>" name="<%=QUANTITY %><%=inc%>"	value="1" readonly="readonly" validate="Qty,int,yes" MAXLENGTH="3" tabindex="1"
						onblur="if(this.readOnly== false){validateQty(this.value,this.id);calculateAmt(<%=inc %>);totalCost(<%=inc%>);}" />
					</td>

					<td id="rateVal<%=inc%>">
					<input type="text" id="resrate<%=inc%>" name="<%=RATE%><%=inc%>" value="<%=rate %>"	validate="Rate,float,no"	onblur="calculateAmt(<%=inc %>);totalCost(<%=inc%>);" readonly="readonly"
						size="15" maxlength="12" /></td>

					<td id="rateVal<%=inc%>"><input type="text" id="amount<%=inc%>" value="<%=rate %>"	name="<%=AMOUNT%><%=inc%>" onblur="totalCost(<%=inc%>);" class="readonly"	readonly="readonly" /></td>
					<td><input type="button" name="add" value="" class="buttonAdd"		onclick="addRow();" tabindex="1" /></td>

				</tr>		
<%inc++;}%>