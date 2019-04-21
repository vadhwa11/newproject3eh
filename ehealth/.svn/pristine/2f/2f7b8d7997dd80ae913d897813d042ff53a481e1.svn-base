<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<%
	Map<String,Object> map = new HashMap<String,Object>();
	List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
	DgResultEntryHeader dgResultEntryHeaderForReport = new DgResultEntryHeader();

	Set<DgResultEntryDetail> subSet1 = new HashSet<DgResultEntryDetail>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	if (map.get("resultList") != null) {
		resultList = (List<DgResultEntryHeader>) map.get("resultList");
	}

	if(resultList.size() > 0 ){
		subSet1 = resultList.get(0).getDgResultEntryDetails();
		dgResultEntryHeaderForReport = resultList.get(0);
	}
	Set<DgResultEntryDetail> dgResultdetail = new LinkedHashSet<DgResultEntryDetail>();
	Set<DgResultEntryDetail> linkedHashSet = DgResultEntryComparatorByOrderNo.getApplicationTreeSet();
	for(DgResultEntryDetail dgResultEntryDetail : subSet1){
		linkedHashSet.add(dgResultEntryDetail);
	}
	dgResultdetail.addAll(linkedHashSet);

%>
<%@page import="jkt.hms.util.DgResultEntryComparatorByOrderNo"%>
<%@page import="java.text.DecimalFormat"%>

<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%><div class="clear"></div>
<!-- Table Starts -->
<div class="titleBg"><h2>Investigation Result</h2></div>
<div class="cmntable">
<label>Investigation</label>
<label class="value"><%= dgResultEntryHeaderForReport.getInvestigation().getInvestigationName()%></label>
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th>Investigation Name</th>
		<th>Result</th>
		<th>UOM</th>
		<th>Normal Range</th>
	</tr>
	<% char i = 96;
	    Set<DgNormalValue>normalSet = new HashSet<DgNormalValue>();
	    for(DgResultEntryDetail dgDetail :dgResultdetail){
	    	/*
	    	* if(dgDetail.getResult()!=null){ // This Code is use for (No Result filled)
	    	*/
	    	if(dgDetail.getResult()!=null && ! dgDetail.getResult().equalsIgnoreCase("null") && ! dgDetail.getResult().equals("") || dgDetail.getFixed()!=null){
	    	i++;
	    		
	    	
	    	
	    %>
	<tr>
		<!--  when result type is SINGLE PARAMETER and comparison type is NORMAL VALUE  -->
		<!--  condition male  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();

	    	 %>
	   <%
	String sex = "";
	if(dgResultEntryHeaderForReport.getHin() != null){
		sex =dgResultEntryHeaderForReport.getHin().getSex().getAdministrativeSexName();
	}else{
		Set<DgOrderdt> set = new HashSet<DgOrderdt>();
		set = dgDetail.getSampleCollectionDetails().getSampleCollectionHeader().getOrder().getDgOrderdts();
	for(DgOrderdt orderDt : set){
	if(orderDt.getBill() != null){
		BlOpBillHeader  billHeader = orderDt.getBill();
		if(billHeader.getHin() != null ){
			sex=billHeader.getHin().getSex().getAdministrativeSexName();

	}else {
			sex=billHeader.getSex().getAdministrativeSexName();
		}
	  }
	}

}
%>

		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(sex.equalsIgnoreCase("male")){ 
			%>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && (nv.getSex().equalsIgnoreCase("m") || nv.getSex().equalsIgnoreCase("n"))){
%>

		<%if(dgDetail.getSubInvestigation() !=null){ 

		%>
		<td><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
		<td><%=dgDetail.getResult() %></td>
		<% }else{ %>
		<td style="font-weight: bold; color: red;"><%=dgDetail.getResult() %></td>
		<% }
					    	}else{%>
		<td>-</td>
		<%}
					       }else{ %>
		<td><%=dgDetail.getResult() %></td>
		<% }
				    }catch(Exception exception){ %>
		<td><%=dgDetail.getResult() %></td>
		<% } %>
		<%if(dgDetail.getUom() !=null){ %>
		<td><%=dgDetail.getUom().getUomName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%if(dgDetail.getNormal() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null ){
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%>
		<td><%= dgDetail.getNormal().getNormalValue()%></td>
		<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}
				}
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}}else{ %>
		<td>-</td>
		<%}} %>
		<div class="clear"></div>
		<%
				}
					}
						}
				}
				} %>
		<!--  when result type is SINGLE PARAMETER and comaprison type NORMAL VALUE and condition male -->

		<!--  when result type is SINGLE PARAMETER and comparison type is NORMAL VALUE  -->
		<!--  condition Female  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%>
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(sex.equalsIgnoreCase("female")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && (nv.getSex().equalsIgnoreCase("f") || nv.getSex().equalsIgnoreCase("n"))){
							%>

		<%if(dgDetail.getSubInvestigation() !=null){ %>
		<td><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
		<td><%=dgDetail.getResult() %></td>
		<% }else{ %>
		<td style="font-weight: bold; color: red;"><%=dgDetail.getResult() %></td>
		<% }
					    	}else{%>
		<td>-</td>
		<%}
					       }else{ %>
		<td><%=dgDetail.getResult() %></td>
		<% }
				    }catch(Exception exception){ %>
		<td><%=dgDetail.getResult() %></td>
		<% } %>
		<%if(dgDetail.getUom() !=null){ %>
		<td><%=dgDetail.getUom().getUomName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%if(dgDetail.getNormal() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null ){
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%>
		<td><%= dgDetail.getNormal().getNormalValue()%></td>
		<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}
				}
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}}else{ %>
		<td>-</td>
		<%}} %>
		<div class="clear"></div>
		<%}}
					}
					}
				} %>
		<!--  when result type is SINGLE PARAMETER and comaprison type NORMAL VALUE and condition female -->

		<!--  when result type is SINGLE PARAMETER and comparison type is NORMAL VALUE  -->
		<!--  condition None  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%>
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(sex.equalsIgnoreCase("Not applicable")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("n")){
						%>

		<%if(dgDetail.getSubInvestigation() !=null){ %>
		<td><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
		<td><%=dgDetail.getResult() %></td>
		<% }else{ %>
		<td style="font-weight: bold;"><%=dgDetail.getResult() %></td>
		<% }
					    	}else{%>
		<td>-</td>
		<%}
					       }else{ %>
		<td><%=dgDetail.getResult() %></td>
		<% }
				    }catch(Exception exception){ %>
		<td><%=dgDetail.getResult() %></td>
		<% } %>
		<%if(dgDetail.getUom() !=null){ %>
		<td><%=dgDetail.getUom().getUomName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%if(dgDetail.getNormal() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null ){
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%>
		<td><%= dgDetail.getNormal().getNormalValue()%></td>
		<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}
				}
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}}else{ %>
		<td>-</td>
		<%}} %>
		<div class="clear"></div>
		<%}}
					}
					}
				} %>
		<!--  when result type is SINGLE PARAMETER and comaprison type NORMAL VALUE and condition NoNe -->

		<!--  when result type is MULTIPLE PARAMETER and comparison type is NORMAL VALUE  -->
		<!--  condition male fg  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	 %>
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(sex.equalsIgnoreCase("male")){ %>
		<% if(normalSet.size()>0){
					//for(DgNormalValue nv :normalSet){
						//if(nv != null && nv.getSex().equalsIgnoreCase("m")){
						%>

		<%if(dgDetail.getSubInvestigation() !=null){ %>
		<td><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
		<td><%=dgDetail.getResult() %></td>
		<% }else{ %>
		<td style="font-weight: bold;"><%=dgDetail.getResult() %></td>
		<% }
					    	}else{%>
		<td>-</td>
		<%}
					       }else{ %>
		<td><%=dgDetail.getResult() %></td>
		<% }
				    }catch(Exception exception){ %>
		<td><%=dgDetail.getResult() %></td>
		<% } %>
		<%if(dgDetail.getUom() !=null){ %>
		<td><%=dgDetail.getUom().getUomName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%if(dgDetail.getNormal() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null ){
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%>
		<td><%= dgDetail.getNormal().getNormalValue()%></td>
		<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}
				}
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}}else{ %>
		<td>-</td>
		<%}} %>

		<div class="clear"></div>
		<%
				}
				//	}
				//		}
				}
				} %>
		<!--  when result type is MULTIPLE PARAMETER and comaprison type NORMAL VALUE and condition male -->

		<!--  when result type is MULTIPLE PARAMETER and comparison type is NORMAL VALUE  -->
		<!--  condition Female  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	 %>
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(sex.equalsIgnoreCase("female")){ %>
		<% if(normalSet.size()>0){
					//for(DgNormalValue nv :normalSet){
					//	if(nv != null && nv.getSex().equalsIgnoreCase("f")){
						%>

		<%if(dgDetail.getSubInvestigation() !=null){ %>
		<td><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
		<td><%=dgDetail.getResult() %></td>
		<% }else{ %>
		<td style="font-weight: bold;"><%=dgDetail.getResult() %></td>
		<% }
					    	}else{%>
		<td>-</td>
		<%}
					       }else{ %>
		<td><%=dgDetail.getResult() %></td>
		<% }
				    }catch(Exception exception){ %>
		<td><%=dgDetail.getResult() %></td>
		<% } %>
		<%if(dgDetail.getUom() !=null){ %>
		<td><%=dgDetail.getUom().getUomName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%if(dgDetail.getNormal() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null ){
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%>
		<td><%= dgDetail.getNormal().getNormalValue()%></td>
		<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}
				}
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}}else{ %>
		<td>-</td>
		<%}} %>
		<div class="clear"></div>
		<%
				}
				//	}
				//		}
				}
				} %>
		<!--  when result type MULTIPLE PARAMETER and comaprison type NORMAL VALUE and condition fEmale -->

		<!--  when result type is multiple PARAMETER and comparison type is NORMAL VALUE  -->
		<!--  condition none  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%>
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(sex.equalsIgnoreCase("Not applicable")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("n")){
						%>
		

		<%if(dgDetail.getSubInvestigation() !=null){ %>
		<td><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
		<td><%=dgDetail.getResult() %></td>
		<% }else{ %>
		<td style="font-weight: bold;"><%=dgDetail.getResult() %></td>
		<% }
					    	}else{%>
		<td>-</td>
		<%}
					       }else{ %>
		<td><%=dgDetail.getResult() %></td>
		<% }
				    }catch(Exception exception){ %>
		<td><%=dgDetail.getResult() %></td>
		<% } %>
		<%if(dgDetail.getUom() !=null){ %>
		<td><%=dgDetail.getUom().getUomName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%if(dgDetail.getNormal() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null ){
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%>
		<td><%= dgDetail.getNormal().getNormalValue()%></td>
		<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}
				}
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}}else{ %>
		<td>-</td>
		<%}} %>
		<div class="clear"></div>
		<%
				}
					}
						}
				}
				} %>
		<!--  when result type is Multiple PARAMETER and comaprison type NORMAL VALUE and condition none -->

		<!--  when result type is MULTIPLE PARAMETER and comparison type is NORMAL VALUE  -->
		<!--  condition male  -->
		<% normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
			if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(sex.equalsIgnoreCase("male")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && (nv.getSex().equalsIgnoreCase("m") || nv.getSex().equalsIgnoreCase("n"))){
							%>
		

		<%if(dgDetail.getSubInvestigation() !=null){ %>
		<td><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
		<td><%=dgDetail.getResult() %></td>
		<% }else{ %>
		<td style="font-weight: bold;"><%=dgDetail.getResult() %></td>
		<% }
					    	}else{%>
		<td>-</td>
		<%}
					       }else{ %>
		<td><%=dgDetail.getResult() %></td>
		<% }
				    }catch(Exception exception){ %>
		<td><%=dgDetail.getResult() %></td>
		<% } %>
		<%if(dgDetail.getUom() !=null){ %>
		<td><%=dgDetail.getUom().getUomName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%if(dgDetail.getNormal() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null ){
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%>
		<td><%= dgDetail.getNormal().getNormalValue()%></td>
		<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}
				}
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}}else{ %>
		<td>-</td>
		<%}} %>
		<%
				}
					}
						}
				}
				} %>
		<!--  when result type is TEXT AREA  and comaprison type NORMAL VALUE and condition male -->

		<!--  when result type is TEXT AREA and comparison type is NORMAL VALUE  -->
		<!--  condition Female  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	 %>
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(sex.equalsIgnoreCase("female")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && (nv.getSex().equalsIgnoreCase("f") || nv.getSex().equalsIgnoreCase("n"))){
						%>
		

		<%if(dgDetail.getSubInvestigation() !=null){ %>
		<td><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
		<td><%=dgDetail.getResult() %></td>
		<% }else{ %>
		<td style="font-weight: bold;"><%=dgDetail.getResult() %></td>
		<% }
					    	}else{%>
		<td>-</td>
		<%}
					       }else{ %>
		<td><%=dgDetail.getResult() %></td>
		<% }
				    }catch(Exception exception){ %>
		<td><%=dgDetail.getResult() %></td>
		<% } %>
		<%if(dgDetail.getUom() !=null){ %>
		<td><%=dgDetail.getUom().getUomName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%if(dgDetail.getNormal() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null ){
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%>
		<td><%= dgDetail.getNormal().getNormalValue()%></td>
		<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}
				}
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}}else{ %>
		<td>-</td>
		<%}} %>
		<div class="clear"></div>
		<%
				}
					}
						}
				}
				} %>
		<!--  when result type TEXT AREA and comaprison type NORMAL VALUE and condition fEmale -->

		<!--  when result type is TEXT AREA and comparison type is NORMAL VALUE  -->
		<!--  condition none  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%>
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(sex.equalsIgnoreCase("Not applicable")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("n")){
						%>
		

		<%if(dgDetail.getSubInvestigation() !=null){ %>
		<td><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
		<td><%=dgDetail.getResult() %></td>
		<% }else{ %>
		<td style="font-weight: bold;"><%=dgDetail.getResult() %></td>
		<% }
					    	}else{%>
		<td>-</td>
		<%}
					       }else{ %>
		<td><%=dgDetail.getResult() %></td>
		<% }
				    }catch(Exception exception){ %>
		<td><%=dgDetail.getResult() %></td>
		<% } %>
		<%if(dgDetail.getUom() !=null){ %>
		<td><%=dgDetail.getUom().getUomName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%if(dgDetail.getNormal() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null ){
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%>
		<td><%= dgDetail.getNormal().getNormalValue()%></td>
		<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}
				}
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}}else{ %>
		<td>-</td>
		<%}} %>

		<div class="clear"></div>
		<%
				}
					}
						}
				}
				} %>
		<!--  when result type is TEXT AREA and comaprison type NORMAL VALUE and condition none -->

		<!--  when result type is Range and comparison type is NORMAL VALUE  -->
		<!--  condition male  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	 %>
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(sex.equalsIgnoreCase("male")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && (nv.getSex().equalsIgnoreCase("m") || nv.getSex().equalsIgnoreCase("n"))){
						%>
		

		<%if(dgDetail.getSubInvestigation() !=null){ %>
		<td><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
		<td><%=dgDetail.getResult() %></td>
		<% }else{ %>
		<td style="font-weight: bold;"><%=dgDetail.getResult() %></td>
		<% }
					    	}else{%>
		<td>-</td>
		<%}
					       }else{ %>
		<td><%=dgDetail.getResult() %></td>
		<% }
				    }catch(Exception exception){ %>
		<td><%=dgDetail.getResult() %></td>
		<% } %>
		<%if(dgDetail.getUom() !=null){ %>
		<td><%=dgDetail.getUom().getUomName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%if(dgDetail.getNormal() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null ){
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%>
		<td><%= dgDetail.getNormal().getNormalValue()%></td>
		<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}
				}
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}}else{ %>
		<td>-</td>
		<%}} %>
		<div class="clear"></div>
		<%
				}
					}
						}
				}
				} %>
		<!--  when result type is Range and comaprison type NORMAL VALUE and condition male -->

		<!--  when result type is RANGE and comparison type is NORMAL VALUE  -->
		<!--  condition Female  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	 %>
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(sex.equalsIgnoreCase("female")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && (nv.getSex().equalsIgnoreCase("f") || nv.getSex().equalsIgnoreCase("n"))){
							%>
		

		<%if(dgDetail.getSubInvestigation() !=null){ %>
		<td><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
		<td><%=dgDetail.getResult() %></td>
		<% }else{ %>
		<td style="font-weight: bold;"><%=dgDetail.getResult() %></td>
		<% }
					    	}else{%>
		<td>-</td>
		<%}
					       }else{ %>
		<td><%=dgDetail.getResult() %></td>
		<% }
				    }catch(Exception exception){ %>
		<td><%=dgDetail.getResult() %></td>
		<% } %>
		<%if(dgDetail.getUom() !=null){ %>
		<td><%=dgDetail.getUom().getUomName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%if(dgDetail.getNormal() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null ){
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%>
		<td><%= dgDetail.getNormal().getNormalValue()%></td>
		<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}
				}
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}}else{ %>
		<td>-</td>
		<%}} %>

		<div class="clear"></div>
		<%
				}
					}
						}
				}
				} %>
		<!--  when result type RANGE and comaprison type NORMAL VALUE and condition fEmale -->

		<!--  when result type is RANGE and comparison type is NORMAL VALUE  -->
		<!--  condition none  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%>
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(sex.equalsIgnoreCase("Not applicable")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("n")){
						%>
		

		<%if(dgDetail.getSubInvestigation() !=null){ %>
		<td><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
		<td><%=dgDetail.getResult() %></td>
		<% }else{ %>
		<td style="font-weight: bold;"><%=dgDetail.getResult() %></td>
		<% }
					    	}else{%>
		<td>-</td>
		<%}
					       }else{ %>
		<td><%=dgDetail.getResult() %></td>
		<% }
				    }catch(Exception exception){ %>
		<td><%=dgDetail.getResult() %></td>
		<% } %>
		<%if(dgDetail.getUom() !=null){ %>
		<td><%=dgDetail.getUom().getUomName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%if(dgDetail.getNormal() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null ){
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%>
		<td><%= dgDetail.getNormal().getNormalValue()%></td>
		<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}
				}
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}}else{ %>
		<td>-</td>
		<%}} %>
		<div class="clear"></div>
		<%
				}
					}
						}
				}
				} %>
		<!--  when result type is RANGE and comaprison type NORMAL VALUE and condition none -->

		<!--  when result type is HEADING and comparison type is NONE -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("h") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>

		

		<%if(dgDetail.getSubInvestigation() !=null){ %>
		<td style="font-weight: bold;"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<td>-</td>

		<td>-</td>

		<td>-</td>

		<div class="clear"></div>
		<%} %>
		<!--  end when result type is HEADING and comparison type is NONE  -->
		<!--  when result type is HEADING and comparison type is FIXED VALUE -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("h") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f")){ %>

		

		<%if(dgDetail.getSubInvestigation() !=null){ %>
		<td><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<td>-</td>

		<td>-</td>

		<%
			String fixedNmValue="";
			if(dgDetail.getFixedNormalValue() != null){
			fixedNmValue=dgDetail.getFixedNormalValue();
			}else{
				fixedNmValue="-";
			}
			%>
		<td><%=fixedNmValue %></td>

		<div class="clear"></div>
		<%} %>
		<!--  end when result type is HEADING and comparison type is FIXED VALUE -->
		<!--  when result type is HEADING and comparison type is NORMAL VALUE  -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("h") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){ %>

		

		<%if(dgDetail.getSubInvestigation() !=null){ %>
		<td><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<td>-</td>

		<td>-</td>
		<td>-</td>

		<div class="clear"></div>
		<%} %>
		<!--  end of when result type is HEADING and comparison type is NORMAL VALUE  -->
		<!--  when result type is SINGLE PARAMETER and COMPARISON TYPE is NONE  -->
		<%if((dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n"))){ %>

		

		<%if(dgDetail.getSubInvestigation() !=null){ %>
		<td><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
		<td><%=dgDetail.getResult() %></td>
		<% }else{ %>
		<td style="font-weight: bold;"><%=dgDetail.getResult() %></td>
		<% }
					    	}else{%>
		<td>-</td>
		<%}
					       }else{ %>
		<td><%=dgDetail.getResult() %></td>
		<% }
				    }catch(Exception exception){ %>
		<td><%=dgDetail.getResult() %></td>
		<% } %>
		<%if(dgDetail.getUom() !=null){ %>
		<td><%=dgDetail.getUom().getUomName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%if(dgDetail.getNormal() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null ){
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%>
		<td><%= dgDetail.getNormal().getNormalValue()%></td>
		<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}
				}
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}}else{ %>
		<td>-</td>
		<%}} %>
		<div class="clear"></div>

		<%} %>
		<!--  end when result type is SINGLE PARAMETER and COMAPRISON TYPE is NONE -->

		<!--  when result type is SINGLE PARAMAETER and comparison type is FIXED VALUE  -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f")){ %>
		
		<%if(dgDetail.getSubInvestigation() !=null){ %>
		<td><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>

		<!-- frst if -->
		<%if(dgDetail.getFixed() != null){%>
		<td><%=dgDetail.getFixed().getFixedValue() %></td>
		<%}else{
			%>
		<td>-</td>
		<%} %>

		<%if(dgDetail.getUom() !=null){ %>
		<td><%=dgDetail.getUom().getUomName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>

		<%String fixedNmValue="";
		if(dgDetail.getNormal() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null ){
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%>
		<td><%= dgDetail.getNormal().getNormalValue()%></td>
		<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}
				}
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}}%>
		
		<%} else if(dgDetail.getFixedNormalValue() != null){ %>
		<%
			fixedNmValue=dgDetail.getFixedNormalValue();%>
		<td><%=fixedNmValue %></td>
			<%}
			%>

		<div class="clear"></div>

		<%} %>
		<!-- end of when result type is SINGLE PARAMAETER and comparison type is FIXED VALUE -->
		<!--  when result type is MULTIPLE PARAMETER and comparison type is NONE  -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>

		

		<%if(dgDetail.getSubInvestigation() !=null){ %>
		<td><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
		<td><%=dgDetail.getResult() %></td>
		<% }else{ %>
		<td style="font-weight: bold;"><%=dgDetail.getResult() %></td>
		<% }
					    	}else{%>
		<td>-</td>
		<%}
					       }else{ %>
		<td><%=dgDetail.getResult() %></td>
		<% }
				    }catch(Exception exception){ %>
		<td><%=dgDetail.getResult() %></td>
		<% } %>
		<%if(dgDetail.getUom() !=null){ %>
		<td><%=dgDetail.getUom().getUomName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%if(dgDetail.getNormal() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null ){
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%>
		<td><%= dgDetail.getNormal().getNormalValue()%></td>
		<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}
				}
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}}else{ %>
		<td>-</td>
		<%}} %>
		<div class="clear"></div>

		<%} %>
		<!--  when result type is MULTIPLE PARAMETER and comparison type is NONE   -->
		<!--  when result type is MULTIPLE PARAMETER and Comparison type is FIXED VALUE  -->
		
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f") ){ %>
		<%if(dgDetail.getSubInvestigation() !=null){ %>
		<td><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>

		<% if(dgDetail.getFixed() != null){	%>
		<td><%=dgDetail.getFixed().getFixedValue() %></td>
		<%}%>

		<%if(dgDetail.getUom() !=null){ %>
		<td><%=dgDetail.getUom().getUomName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%if(dgDetail.getNormal() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null ){
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%>
		<td><%= dgDetail.getNormal().getNormalValue()%></td>
		<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}
				}
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}}else{ %>
		<td>-</td>
		<%}} %>

		<div class="clear"></div>

		<%} %>
		<!-- end when result type is MULTIPLE PARAMETER and Comparison type is FIXED VALUE  -->

		<!--  when result type is TEXT AREA and comparison type is NONE -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>

		

		<%if(dgDetail.getSubInvestigation() !=null){ %>
		<td><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
		<td><%=dgDetail.getResult() %></td>
		<% }else{ %>
		<td style="font-weight: bold;"><%=dgDetail.getResult() %></td>
		<% }
					    	}else{%>
		<td>-</td>
		<%}
					       }else{ %>
		<td><%=dgDetail.getResult() %></td>
		<% }
				    }catch(Exception exception){ %>
		<td><%=dgDetail.getResult() %></td>
		<% } %>
		<%if(dgDetail.getUom() !=null){ %>
		<td><%=dgDetail.getUom().getUomName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		<%if(dgDetail.getNormal() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null ){
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%>
		<td><%= dgDetail.getNormal().getNormalValue()%></td>
		<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}
				}
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}}else{ %>
		<td>-</td>
		<%}} %>

		<div class="clear"></div>
		<%} %>
		<!-- end when result type is TEXT AREA and comparison type is NONE -->

		<!--  when result type is TEXT AREA and comparison type is FIXED VALUE -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f")){ %>

		

		<%if(dgDetail.getSubInvestigation() !=null){ %>
		<td><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>


		<%if(dgDetail.getFixed() != null){ %>
		<td><%=dgDetail.getFixed().getFixedValue() %></td>

		<%}%>


		<%if(dgDetail.getUom() !=null){ %>
		<td><%=dgDetail.getUom().getUomName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>


		<%if(dgDetail.getNormal() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null ){
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%>
		<td><%= dgDetail.getNormal().getNormalValue()%></td>
		<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}
				}
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></label>
		<%}}else{ %>
		<td>-</td>
		<%}} %>

		<div class="clear"></div>

		<%} %> <!-- end  when result type is TEXT AREA and comparison type is FIXED VALUE -->
		<!--  when result type is Range and comparison type is NONE --> <%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>
		

		<%if(dgDetail.getSubInvestigation() !=null){ %>
		<td><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %> <%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
		<td><%=dgDetail.getResult() %></td>
		<% }else{ %>
		<td style="font-weight: bold;"><%=dgDetail.getResult() %></td>
		<% }
					    	}else{%>
		<td>-</td>
		<%}
					       }else{ %>
		<td><%=dgDetail.getResult() %></td>
		<% }
				    }catch(Exception exception){ %>
		<td><%=dgDetail.getResult() %></td>
		<% } %> <%if(dgDetail.getUom() !=null){ %>
		<td><%=dgDetail.getUom().getUomName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %> <%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null ){
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%>
		<td><%= dgDetail.getNormal().getNormalValue()%></td>
		<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}
				}
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}}else{ %>
		<td>-</td>
		<%}} %>
		<div class="clear"></div>


		<%} %> <!-- when result type is RANGE and comparison type is FIXED VALUE  -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f")){ %>


		

		<%if(dgDetail.getSubInvestigation() !=null){ %>
		<td><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %> <%if(dgDetail.getFixed() != null){ %>
		<td><%=dgDetail.getFixed().getFixedValue() %></td>
		<%}%> <%if(dgDetail.getUom() !=null){ %>
		<td><%=dgDetail.getUom().getUomName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %> <%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null ){
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%>
		<td><%= dgDetail.getNormal().getNormalValue()%></td>
		<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}
				}
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
		<%}}else{ %>
		<td>-</td>
		<%}} %> <%}
    	%>

	</tr>
	<%} 
	}%>
</table>
</div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		