<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>

<%Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");

	}
	List<OpdTemplateTreatment> treatmentTemplateList= new ArrayList<OpdTemplateTreatment>();
	List frequencyList= new ArrayList();
	if(map.get("treatmentTemplateList") != null){
		treatmentTemplateList = (List)map.get("treatmentTemplateList");
	}
	List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
	if(map.get("brandList") != null){
		brandList = (List)map.get("brandList");
	}
	List<MasStoreItem> masStoreList = new ArrayList<MasStoreItem>();
	if(map.get("masStoreList") != null){
		masStoreList = (List)map.get("masStoreList");
	}
	if(map.get("frequencyList") != null){
		frequencyList = (List)map.get("frequencyList");
	}
	BigDecimal totalDispPrice = new BigDecimal(0);
%>

<%@page import="jkt.hms.masters.business.OpdTemplateTreatment"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="java.math.BigDecimal"%>


<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>

<div id="divTemplet">

<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="grid">
	<tr>

		<th scope="col">Item Name</th>
		<!-- <th scope="col">Brand Name</th>
		<th scope="col">Manufacturer</th> -->
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. of Days</th>
		<th scope="col">Total</th>
	</tr>
	<%
	    int i=1;
	       Iterator itr=treatmentTemplateList.iterator();
	      while(itr.hasNext())
	      {
	    	  OpdTemplateTreatment opdTemplateTreatment=(OpdTemplateTreatment)itr.next();
	    	  String frequencyNameFromDB="";
	    	  int frquencyId=0;
	    	  if( opdTemplateTreatment.getFrequency() != null){
	    	  frequencyNameFromDB = opdTemplateTreatment.getFrequency().getFrequencyName();
	    	  frquencyId=opdTemplateTreatment.getFrequency().getId();
	    	  }
	    	  String manufacturer =null;
	    	  int manufactureId =0;
		          if(opdTemplateTreatment.getItem()!=null)
		          {
		        	  manufacturer = opdTemplateTreatment.getItem().getManufacturer().getManufacturerName();
		        	  manufactureId =opdTemplateTreatment.getItem().getManufacturer().getId();
		          }
	    %>
	<tr>
		<td id="nomenclatureDiv<%=i%>"><input type="text" id="nomenclature<%=i%>"
			name="nomenclature<%=i%>"
			value="<%=opdTemplateTreatment.getItem().getNomenclature()%>[<%=opdTemplateTreatment.getItem().getPvmsNo()%>]"
			size="35" onblur="populatebrand(this.value,'<%=i%>');checkItem('<%=i %>');"/>
		<input type="hidden" name="pvmsNo<%=i%>" id="pvmsNo<%=i%>" size="10" value="<%=opdTemplateTreatment.getItem().getPvmsNo()%>"/>
		<div id="ac2updates<%=i%>" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('nomenclature<%=i%>','ac2updates<%=i%>','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1&counter=<%=i%>'});
				</script>
		</td>


       <!--  <td id="testDiv<i%>">-->

        <!--  <select id="brandId<i%>" name="brandId<i %>" readonly="readonly" onchange="populateManufacturer(this.value,'<i%>');">

       		<option value="0">Select</option>-->
       		
       			<%
       		 	int brandId =0;
	    				   for(MasStoreItem item :masStoreList)
	    				   {
	    					   Set<MasStoreBrand> masStoreBrandsSet= new HashSet<MasStoreBrand>();
	    					   masStoreBrandsSet=item.getMasStoreBrands();

	    					   if(masStoreBrandsSet.size()>0){
	    						  
    				    for(MasStoreBrand brand :masStoreBrandsSet)
 	    		         {
    				    	brandId = brand.getId();
// 	    			  if(opdTemplateTreatment.getItem()!=null)
//	    	    	  {
	    //			    if(brand.getItem().getId().equals(opdTemplateTreatment.getItem().getId())){
	    		       %>
				          <option value="<brand.getId()%>" selected="selected"><brand.getBrandName()%></option>
				       <%//}else{ %>
				                 <option value="<brand.getId()%>"><brand.getBrandName()%></option>
				                  
				     <%}}}%>
			<input type="text" id="brandId<%=i%>" name="brandId<%=i%>" readonly="readonly" value="<%=brandId%>">
	    				//	 }
	    				 //  } %>
				<!--</select>

		 	</td> -->
		<%
	    	//Set<StoreItemBatchStock> batchSet = new HashSet();
	    //	List<BigDecimal> tempDispList = new ArrayList();
	    //	if(opdTemplateTreatment.getItem().getStoreItemBatchStocks() != null){
	    //		batchSet = opdTemplateTreatment.getItem().getStoreItemBatchStocks();
	    //	}
	   // 	if(batchSet.size() > 0){
	    //		for(StoreItemBatchStock batchStock : batchSet){
	    //			tempDispList.add(batchStock.getDispencingPrice());
	    //		}
	    //	}

    	//	BigDecimal dispPrice = new BigDecimal(0);
	    //	if(tempDispList != null && tempDispList.size() > 0){
	    //		dispPrice = Collections.max(tempDispList);
	    //	}
	    	//totalDispPrice = totalDispPrice.add(dispPrice.multiply(new BigDecimal(opdTemplateTreatment.getTotal())));
	    %>
		<input type="hidden" id="manufacturer<%=i %>" name="manufacturer<%=i %>"
				readonly="readonly" value="<%=manufacturer%>" size="10"/><input type="hidden" id="manufactureId<%=i%>" name="manufactureId<%=i %>"
				readonly="readonly" value="<%=manufactureId%>" />
		<!--  -----End ----- -->
		<td><input type="text" id="dosage<%=i %>" name="dosage<%=i%>"
			value="<%=opdTemplateTreatment.getDosage() %>" size="10" /></td>
		<td><select id="frequency<%=i%>" name="frequency<%=i%>">
			<option>Select</option>
			<%
	         for(Iterator itr1=frequencyList.iterator();itr1.hasNext();){
	        	 MasFrequency frequency=(MasFrequency)itr1.next();
	        	 String frequencyName=frequency.getFrequencyName();
	         	 if(frquencyId==frequency.getId()){
	       %>
			<option value="<%=frquencyId %>" selected><%=frequencyNameFromDB %></option>
			<%}else{ %>
			<option value="<%=frequency.getId() %>"><%=frequency.getFrequencyName() %></option>
			<%}} %>
		</select></td>
		<td><input type="text" id="noOfDays<%=i %>" name="noOfDays<%=i%>"
			value="<%=opdTemplateTreatment.getNoofdays() %>" size="3"
			onblur="fillValue(this.value,<%=i %>);" /></td>
		<td><input type="text" id="total<%=i%>" name="total<%=i%>"
			value="<%=opdTemplateTreatment.getTotal()%>" size="5" /></td>

	</tr>
	<%i++;} %>

</table>
<input type="hidden" name="hdb" value="<%=i-1%>" id="hdb" />
<div class="clear"></div>
<br />
</div>



