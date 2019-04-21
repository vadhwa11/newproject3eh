
<%@page import="jkt.hms.masters.business.PrqQuotationVendorDetails"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.PrqQuotationItemDetails"%>
<%@page import="jkt.hms.masters.business.PrqQuotationVendorDetails"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>


<head>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css"    id="vbulletin_css" />


<script type="text/javascript" language="javascript"    src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"    src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"    src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"    src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"    src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"    src="/hms/jsp/js/calendar2.js"></script>
</head>
<script type="text/javascript">
	var csrfTokenName='${_csrf.parameterName}';
	var csrfTokenValue='${_csrf.token}';

</script>
<script>
function disableFun(count)
{
	var count1=parseInt(count);
	for(i=1;i<=count1;i++){
		document.getElementById("priceprefrence"+i).setAttribute("disabled","disabled");
	}
	
// 	document.getElementById("priceprefrence").disabled = true;
}
</script>
<%
    Map map = new HashMap();
    List<PrqQuotationVendorDetails> vendor=new ArrayList<PrqQuotationVendorDetails>();
    List<PrqQuotationItemDetails> itemList=new ArrayList<PrqQuotationItemDetails>();
    List<MasManufacturer> manufacturerList=new ArrayList<MasManufacturer>();
    HashMap[] gridData =null;
    PagedArray pagedArray = null;
    Box box = HMSUtil.getBox(request);


    if (request.getAttribute("map") != null)
    {
        map = (Map) request.getAttribute("map");
}
    
    if(map.get("vendorList")!=null){
    	vendor=(List<PrqQuotationVendorDetails>)map.get("vendorList");
	}
    if(map.get("item")!=null){
    	itemList=(List<PrqQuotationItemDetails>)map.get("item");
	}
    if(map.get("manufacturer")!=null){
    	manufacturerList=(List<MasManufacturer>)map.get("manufacturer");
	}
   // System.out.println(vendor.size()+"===="+itemList.size());
    	 //System.out.println("iiii"+vendor.get(0).getVendor().getSupplierType().getId());
%>



<div id="mainIn">
<form name="manufactureDetail" action="" method="post" enctype="multipart/form-data">
<div class="titleBg">
<h2>Item Detail</h2>
</div>

<div class="Block">
<%-- <label>Item Code</label>
<input type="text" name="itemCode" value="<%=itemList.get(0).getItem().getPvmsNo() %>"    tabindex=1  readonly="readonly" id="itemCode" />

<label>Item Name</label>
<input type="text" name="itemName" value="<%=itemList.get(0).getItem().getNomenclature() %>"    tabindex=1  readonly="readonly" id="itemName" />

<label>Quotation Qty</label>
<input type="text" name="quotationQty" value="<%=itemList.get(0).getApprovedQty() %>"    tabindex=1   id="quotationQty" />
</div> --%>

<label>Vendor Name</label>
<input type="text" name="itemCode" value="<%=vendor.get(0).getVendor().getSupplierName() %>"    tabindex=1  readonly="readonly" id="itemCode" />

<input type="hidden" name="quotationSubmissionDate" id="quotationSubmissionDate" value="" />
<div class="clear"></div>


<div class="cmntable">
<table width="100%" colspan="7" id="itemDetails" border="0"     cellpadding="0" cellspacing="0">
    <thead>
        <tr>
            <th width="13%">Sl No.</th>
            <th width="13%">Item Name</th>
            <th width="13%">Unit</th>
            <th width="13%">Qty</th>
            <th width="10%">Manufacture By</th>
            <th width="13%">Rate(Rs.)</th>
           <!--  <th width="13%">Per Qty</th> -->
            <th width="13%">Amount</th>
            <th width="13%">Discount % on Rate</th>
             <th width="10%">Price Prefrence</th>
            <th width="13%">Net Amount</th>
            <th width="13%">Excise Duty</th>
            <th width="13%">Tax</th>
            <th width="13%">Vat</th>
            <th width="13%">Total Amount</th>
            <th width="13%">Remarks</th>
            <th width="13%">TechnicalSpecification</th>
            <th width="13%">Document Upload</th>
            
        </tr>
    </thead>
      <tbody>
         <% int i=0;
         if (itemList.size()>=0){
				for (PrqQuotationItemDetails ms : itemList) {
					i++;
	        	 %>
	        	   <tr>
		     <td><%=i %></td>
			  <td width="5%"><%=ms.getItem().getNomenclature() %> 
			  <input type="hidden" value="<%=ms.getId() %>" name="item<%=i%>">         
			  </td>
			  <td width="5%"><%=ms.getItem().getItemConversion().getItemUnitName()%></td>
			    <td width="5%"> <%=ms.getApprovedQty().intValue() %>
			     <input type="hidden" name="approvedQty<%=i %>" value="<%=ms.getApprovedQty().intValue()%>" id="approvedQty<%=i %>">
			    
			    </td>
		   <td>
                <select name="manufacture<%=i%>"  tabindex="1" validate="Manufacturer,string,yes">
                <option value="">Select</option>
           <%if(manufacturerList.size()>0){ 
              for(MasManufacturer manufacturer : manufacturerList){
                         %>
                    <option value="<%=manufacturer.getId() %>"><%=manufacturer.getManufacturerName() %></option>
                         <%} }%>
                          </select>
                          </td>
		             
		             <td><input type="text" name="rate<%=i%>" value= "" tabindex="1" id="rate<%=i%>" validate="Rate,int,yes"  onblur="totAm(<%=i%>);"/></td>
		            <%--  <td><input type="text" name="qty<%=i%>" value= "" onblur="totAm(<%=i%>);" tabindex="1" id="qty<%=i%>" validate="Quantity,int,yes"/></td> --%>
		             <td><input type="text" name="ammount<%=i%>" value= "" tabindex="1" id="ammount<%=i%>" readonly="readonly"/></td>
		             <td><input type="text" name="dicount<%=i%>" value= "" tabindex="1" id="dicount<%=i%>" onblur=" totAm(<%=i%>);" /></td>
		               
		              
		              <td><input type="text" name="priceprefrence<%=i%>" value= ""  tabindex="1" id="priceprefrence<%=i%>"  onblur=" totAm(<%=i%>)" /></td>
		  
		             <td><input type="text" name="netAmount<%=i%>" value= "" tabindex="1" id="netAmount<%=i%>"  onblur="totAm(<%=i%>)" readonly="readonly"/></td>
		            <td>
                            <select name="exciseOption<%=i%>" id="exciseOption<%=i%>"  tabindex="1" class="medium" validate="Excise Duty,string,no">
                           <option value="">Select</option>
                                      <option value="Flat">Amount</option>
                                      <option value="Percent">Percentage</option>
                                     </select>
                  <input type="text" class="auto" size="7"  tabindex="1" name="exciseDuty<%=i%>" id="exciseDuty<%=i%>" value=""  validate="Excise Duty,float,no" maxlength="10" onblur="totAm(<%=i%>)" /></td>
		             <td><input type="text" name="tax<%=i%>" value= "" tabindex="1" id="tax<%=i%>" onblur="totAm(<%=i%>)" /></td>
		             <td><input type="text" name="vat<%=i%>" value= "" tabindex="1" id="vat<%=i%>" onblur="totAm(<%=i%>)" /></td>
		             <td><input type="text" name="totalAmmount<%=i%>" value= "" tabindex="1" id="totalAmmount<%=i%>" readonly="readonly"/></td>
		             <td><input type="text" name="remarks<%=i%>"  value= "" tabindex="1" id="remarks<%=i %>"/></td>
		             <td><input type="text" name="technicalSpecification<%=i%>" value= "" tabindex="1" id="technicalSpecification<%=i%>"/></td>
		             <td><input type="file" name="upload_filename" id="fileNameId" class="browse" tabindex="1"/></td>
		             
		            </tr>
		<% 
				}}%>
      </tbody>
</table>
</div>
<% if(vendor.get(0).getVendor().getSupplierType().getId()!=5)
        		            	   {%>
        		            	   <script> disableFun(<%=i %>);</script>
        		            	   <%} %>
<div class="Block">
<input type="hidden" name="requestId" value="<%=vendor.get(0).getId()%>"/>
<input type="hidden" name="headerId" value="<%=vendor.get(0).getHeader().getId()%>"/>
 <input type="hidden" name="itemCount" value=<%=i %>></input>
<input    type="button" name="Submit" id="addbutton" value="Submit" class="button" accesskey="a" onclick="submitForm('manufactureDetail','procurement?method=saveQuotationSubmissionSelectJsp&'+csrfTokenName+'='+csrfTokenValue);" />
<input    type="button" name="Submit" id="addbutton"    value="Next" class="button" accesskey="a" onclick="openPopupWindow1();" />
<input name="button"  type="reset"	value="Reset" class="button"	onclick=""; />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
<script type="text/javascript">
function totAm(count){
	 var rate=0;
	 var tax=0;
	 var vat=0;
	 var totalAmmount=0;
	 var qty=0;
	 var ammount=0;
	 var dicount=0;
	 var exciseDuty=0;
	  var exciseOption=0;
	  var netAmount=0;
	  var ratePerQty=0;
	  var ratePerUnit=0;
	  var quotationQty=0;
	  var priceprefrence=0;
	  if(isNaN(document.getElementById("approvedQty"+count).value))
	  {
	  alert('This is not valid Quantity');
	  return;
	  }
	  quotationQty=document.getElementById('approvedQty'+count).value;
	  if(isNaN(document.getElementById("rate"+count).value))
		  {
		  alert('Please Enter valid Rate');
		  return;
		  }
	  
		rate=document.getElementById('rate'+count).value;
		/* if(isNaN(document.getElementById("qty"+count).value))
		  {
		  alert('Please Enter valid Quantity');
		  return;
		  }
		qty=document.getElementById('qty'+count).value;
		if(qty!='' && qty!=0 && rate !='' && rate!=0)
			ratePerUnit = eval(eval(Number(rate)) / eval(Number(qty))); */
		ammount = eval(Number(eval(Number(quotationQty))* (eval(Number(rate)))));
		ammount = parseFloat(ammount).toFixed(2);
		document.getElementById('ammount'+count).value = ammount;
	
	
	if(isNaN(document.getElementById("dicount"+count).value))
	  {
	  alert('Please Enter valid Discount');
	  return;
	  }
	
    
     if(document.getElementById("dicount"+count).value!=null && document.getElementById("dicount"+count).value!=""){
    	 dicount=parseInt(document.getElementById("dicount"+count).value);
 	}
    
     document.getElementById("netAmount"+count).value=ammount-((ammount*dicount)/100);
     netAmount=ammount-((ammount*dicount)/100);
     netAmount = parseFloat(netAmount).toFixed(2);
     
     if(isNaN(document.getElementById("priceprefrence"+count).value))
	  {
	  alert('Please Enter valid Price');
	  return;
	  }
     if(document.getElementById("priceprefrence"+count).value!=null && document.getElementById("priceprefrence"+count).value!=""){
    	 priceprefrence=parseInt(document.getElementById("priceprefrence"+count).value);
 	}
     document.getElementById("netAmount"+count).value=netAmount-((netAmount*priceprefrence)/100);
     netAmount=netAmount-((netAmount*priceprefrence)/100);
     netAmount = parseFloat(netAmount).toFixed(2);
     
     exciseOption = document.getElementById('exciseOption'+count).value;
    if(exciseOption=='Percent')
     {
    	if(isNaN(document.getElementById("exciseDuty"+count).value))
  	  {
  	  alert('Please Enter valid Excise Duty');
  	  return;
  	  }
     	exciseDuty = Number(document.getElementById('exciseDuty'+count).value);
  	   var exciseTotalAmount = ((netAmount)*(exciseDuty))/100;
  	 totalAmmount = netAmount+exciseTotalAmount;
  	totalAmmount = parseFloat(totalAmmount).toFixed(2);
     }
  else if(exciseOption=='Flat')
  {
	  if(isNaN(document.getElementById("exciseDuty"+count).value))
  	  {
  	  alert('Please Enter valid Excise Duty');
  	  return;
  	  }
  	exciseDuty = document.getElementById('exciseDuty'+count).value;
  	totalAmmount = parseFloat(netAmount)+parseFloat(exciseDuty);
  
}else{
  	totalAmmount = ammount-((ammount*dicount)/100);
 }
 
  tax = document.getElementById('tax'+count).value;
  if(tax != null)
  {
  	var taxTotalAmount = (totalAmmount*tax)/100;
  	totalAmmount =parseFloat(totalAmmount)+parseFloat(taxTotalAmount);
  	totalAmmount = parseFloat(totalAmmount).toFixed(2);
  }
  

  vat = document.getElementById('vat'+count).value;
  if(vat != null)
  {
  	var vatTotalAmount = (totalAmmount*vat)/100;
  	totalAmmount =parseFloat(totalAmmount)+parseFloat(vatTotalAmount);
  	totalAmmount = parseFloat(totalAmmount);
  }

  totalAmmount = parseFloat(totalAmmount).toFixed(2);
  	document.getElementById('totalAmmount'+count).value = totalAmmount;
  	
  	}
  	
  	
function openPopupWindow1(){
	//submission Code
	window.opener.openedIndex=parseInt(window.opener.openedIndex)+1;
	var obj= window.opener.document.getElementById("selectCheckBox"+window.opener.openedIndex);
	if(obj!=null)
		{
	obj.checked=true;
	if(obj.checked){
		submitForm('manufactureDetail','procurement?method=saveQuotationSubmissionSelectJsp&redirect=1&nextVendor='+obj.value+'&'+csrfTokenName+'='+csrfTokenValue);
		//var url="/hms/hms/procurement?method=showQuotationSubmissionSelectJsp&requestId="+obj.value;
		 //window.location=url;
		// newwindow=window.open(url,'name',"left=100,top=100,height=400,width=850,status=1,scrollbars=1,resizable=0");
	}
		}
	else
		{
		submitForm('manufactureDetail','procurement?method=saveQuotationSubmissionSelectJsp'+csrfTokenName+'='+csrfTokenValue);
		}
}
document.getElementById('quotationSubmissionDate').value=window.opener.document.getElementById('quotationSubmissionDate').value;

</script>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
