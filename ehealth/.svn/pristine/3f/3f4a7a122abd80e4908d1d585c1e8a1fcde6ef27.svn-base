<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForAdmissionNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Admission Number Combo in ipAdmissionReprt.jsp
	 * @author  Name: Ritu
	 * Create Date: 22.07.2009   
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.MasStoreItem"%>


<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
	</script>
<%	
		Map map = new HashMap();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("itemList") != null){
			itemList =(List<MasStoreItem>)map.get("itemList");
		}
%>
<select name="<%=ITEM_ID %>"
	onchange="if(this.value !=0){submitProtoAjaxWithDivName('packageMedicines','packageBilling?method=getDispensingPriceForItem','priceDiv');}">
	<option value="0">Select</option>
	<% 
	     	int i=0;
	     		for (MasStoreItem storeItem : itemList) {
	     			
	     			if(storeItem.getNomenclature() != null){
	     				StringBuffer output_str = new StringBuffer();
	     				StringTokenizer s = new StringTokenizer(storeItem.getNomenclature().toString(),"\""); 
	     				
	     				while (s.hasMoreTokens())
	     				{
	     				output_str.append(s.nextToken());
	     				if (s.hasMoreTokens())
	     				{
	     				output_str.append("\\");
	     				output_str.append("\"");
	     				}
	     				}
	     	%>
	<script>
	     				amtArray[<%=i%>] = new Array();
	     				amtArray[<%=i%>][0] = <%=storeItem.getId()%>;
	     				amtArray[<%=i%>][1] = "<%=output_str.toString()%>";
	     				
	     		</script>

	<option value="<%=storeItem.getId()%>"><%=storeItem.getNomenclature()%>
	</option>
	<% }
	     			i++;
	     		}
	     		%>
</select>


		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
