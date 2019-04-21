<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%
Map<String,Object>map=new HashMap<String,Object>();
int hin=0;
if(request.getAttribute("map")!=null)
{
	map=(Map<String,Object>)request.getAttribute("map");
}
List<DgOrderdt>dtList=new ArrayList<DgOrderdt>();
if(map.get("dtList")!=null){
	dtList=(List<DgOrderdt>)map.get("dtList");
}
if(map.get("hin")!=null){
	hin=Integer.parseInt(map.get("hin")+"");
}
System.out.println("dtList size --- >>"+dtList.size());
%>
<div class="tableHolderAuto">
			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				id="chargeDetails">
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
				int inc = 1;
				if(dtList!=null && dtList.size()>0){
					for(DgOrderdt dt:dtList){
				%>
				<tr>
					<input type="hidden" value="<%=dt.getId() %>" name="dgOrderhdId"
						id="dgOrderhdId" />
					<td><input type="checkbox" value="<%=inc%> "
						name="selectedChrage" class="radioCheck" /></td>
					<td><input type="text" name="chargeCode<%=inc%>"
						id="chargeCode<%=inc%>"
						onblur="checkInvestigationItem(<%=inc %>);if(validateChargeCodeForAutoComplete(this.value, '<%=inc %>')){submitProtoAjaxWithDivName('investigationOrderBooking','/hms/hms/lab?method=fillChargeCode&rowVal=1&hin=<%=dt.getOrderhd().getHin().getId()%>','rateVal');}"
						tabindex="1" value="<%=dt.getChargeCode().getChargeCodeName() %>" />
						<div id="ac2update" style="display: none;" class="autocomplete"></div>
						<script type="text/javascript" language="javascript"
							charset="utf-8">
			  function eventCallback(element, entry){
			 //var r;
			// if(document.getElementById('rareCommon1').checked == true){
			// r=document.getElementById('rareCommon1').value;
			// }else {
			// r=document.getElementById('rareCommon2').value;
			// }
						return entry + "&mainChargeCodeId=" + document.getElementById('mainChargeCodeId').value+"&subChargeCodeId="+document.getElementById('subChargeCodeId').value;
				}
			    new Ajax.Autocompleter('chargeCode<%=inc%>','ac2update','lab?method=getChargeCodeForAutoComplete',{parameters:'requiredField=chargeCode<%=inc%>', callback: eventCallback});

			</script></td>
					<input type="hidden" value="<%=dt.getChargeCode().getId() %>" name="<%=CHARGE_CODE_ID%><%=inc %>"
						id="chargeCodeId<%=inc %>" />
					<input type="hidden" value="<%=dt.getMainChargecode().getId() %>" name="<%=MAIN_CHARGECODE_ID%><%=inc %>"
						id="mainChargeId<%=inc %>" />
					<input type="hidden" value="<%=dt.getSubChargeid().getId()%>" name="<%=SUB_CHARGECODE_ID%><%=inc %>"
						id="subCharegId<%=inc %>" />
					<%-- <td><input type="text" id="chargeName<%=inc%>"
						name="<%=CHARGE_NAME%>" value="" class="readonly" /></td> --%>

					<td><input type="text" id="qty<%=inc%>" name="<%=QUANTITY %>" va
						value="1" readonly="readonly" validate="Qty,int,yes" MAXLENGTH="3" tabindex="1"
					onblur="if(this.readOnly== false){validateQty(this.value,this.id);calculateAmt(<%=inc %>);totalCost();}" />
					</td>

					<td id="rateVal"><input type="text" value="<%=dt.getChargeCode().getCharge()%>"
						id="resrate<%=inc%>" name="<%=RATE%><%=inc%>"
						validate="Rate,float,no"
						onblur="calculateAmt(<%=inc %>);totalCost();"  readonly="readonly"
						size="15" maxlength="12" /></td>

					<td><input type="text" id="amount<%=inc%>" value="<%=dt.getChargeCode().getCharge()%>"
						name="<%=AMOUNT%><%=inc%>" onblur="totalCost();" class="readonly"
						readonly="readonly" /></td>
					<td><input type="button" name="add" value="" class="buttonAdd"
						onclick="addRow();" tabindex="1" /></td>

				</tr>

				<input type="hidden" value="<%=dt.getId() %>" name="dgOrderhdId"
					id="dgOrderhdId" />
			

			<input type="hidden" value="<%=inc %>" name="hiddenValueCharge"
				id="hiddenValueCharge" />
			<%}%>	
				<%}else{ %>
					<tr>
					<input type="hidden" value="0" name="dgOrderhdId"
						id="dgOrderhdId" />
					<td><input type="checkbox" value="<%=inc%>"
						name="selectedChrage" class="radioCheck" /></td>
					<td><input type="text" name="chargeCode<%=inc%>"
						id="chargeCode<%=inc%>"
						onblur="checkInvestigationItem(<%=inc %>);if(validateChargeCodeForAutoComplete(this.value, '<%=inc %>')){submitProtoAjaxWithDivName('investigationOrderBooking','/hms/hms/lab?method=fillChargeCode&rowVal=1&hin=<%=hin%>','rateVal');}"
						tabindex="1" />
						<div id="ac2update" style="display: none;" class="autocomplete"></div>
						<script type="text/javascript" language="javascript"
							charset="utf-8">
			  function eventCallback(element, entry){
			 //var r;
			// if(document.getElementById('rareCommon1').checked == true){
			// r=document.getElementById('rareCommon1').value;
			// }else {
			// r=document.getElementById('rareCommon2').value;
			// }
						return entry + "&mainChargeCodeId=" + document.getElementById('mainChargeCodeId').value+"&subChargeCodeId="+document.getElementById('subChargeCodeId').value;
				}
			    new Ajax.Autocompleter('chargeCode<%=inc%>','ac2update','lab?method=getChargeCodeForAutoComplete',{parameters:'requiredField=chargeCode<%=inc%>', callback: eventCallback});

			</script></td>
					<input type="hidden" value="" name="<%=CHARGE_CODE_ID%>"
						id="chargeCodeId<%=inc %>" />
					<input type="hidden" value="" name="<%=MAIN_CHARGECODE_ID%>"
						id="mainChargeId<%=inc %>" />
					<input type="hidden" value="" name="<%=SUB_CHARGECODE_ID%>"
						id="subCharegId<%=inc %>" />
					<%-- <td><input type="text" id="chargeName<%=inc%>"
						name="<%=CHARGE_NAME%>" value="" class="readonly" /></td> --%>

					<td><input type="text" id="qty<%=inc%>" name="<%=QUANTITY %>"
						value="" readonly="readonly" validate="Qty,int,yes" MAXLENGTH="3" tabindex="1"
						onblur="if(this.readOnly== false){validateQty(this.value,this.id);calculateAmt(<%=inc %>);totalCost();}" />
					</td>

					<td id="rateVal"><input type="text" value=""
						id="resrate<%=inc%>" name="<%=RATE%><%=inc%>"
						validate="Rate,float,no"
						onblur="calculateAmt(<%=inc %>);totalCost();" readonly="readonly"
						size="15" maxlength="12" /></td>

					<td><input type="text" id="amount<%=inc%>" value=""
						name="<%=AMOUNT%><%=inc%>" onblur="totalCost();" class="readonly"
						readonly="readonly" /></td>
					<td><input type="button" name="add" value="" class="buttonAdd"
						onclick="addRow();" tabindex="1" /></td>

				</tr>

				<input type="hidden" value="0" name="dgOrderhdId"
					id="dgOrderhdId" />
				<%}%>
				
				</table>
		</div>