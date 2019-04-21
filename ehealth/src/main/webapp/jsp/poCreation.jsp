<%@page import="jkt.hms.masters.business.MmSafetyProcedureMaterials"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.PrqQuotationItemDetails"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>


<script type="text/javascript" language="javascript"  src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/pops_menu.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/ajax.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/prototype.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/scriptaculous.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/unittest.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/calender.js"></script>

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text
<script>
	 var nameArray=new Array();
	 var itemsArray1=new Array();
</script>
<script type="text/javascript">
<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
serverdate = '<%=date+"/"+month1+"/"+year1%>'

	function validate(){
    var flag=false;
    var count=parseInt(document.getElementById("itemCount").value);
        for(var i=1;i<=count;i++){
        	if(document.getElementById("itemCheckBox"+i)!=null){
            if(document.getElementById("itemCheckBox"+i).checked==true){
                flag=true;
            }
        	}
        }
        for(var i=1;i<=count;i++){
        	if(document.getElementById("mCheckBox"+i)!=null){
            if(document.getElementById("mCheckBox"+i).checked==true){
                flag=true;
            }
        	}
        }
    if(flag){
        return true;
    }else{
        alert("Select Atleast one item for PO");
        return false;
    }
    
}

function checkData(){
var start= new Date(document.getElementById("podateId").value.split("/")[2], document.getElementById("podateId").value.split("/")[1], document.getElementById("podateId").value.split("/")[0]);
 var end= new Date(document.getElementById("deliverydateId").value.split("/")[2], document.getElementById("deliverydateId").value.split("/")[1], document.getElementById("deliverydateId").value.split("/")[0]);
 if(start<=end){
     return true;
 }else{alert("Delivery Date is Not Less Than PoCreation.");return false;}
}
</script>



<%
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<PrqQuotationItemDetails> prqQuotationItemDetails=new ArrayList<PrqQuotationItemDetails>();
	List<MmSafetyProcedureMaterials> mmSafetyProcedureMaterial=new ArrayList<MmSafetyProcedureMaterials>();
	List<MasHospital> hospital=new ArrayList<MasHospital>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	String message="";
	if(map.get("message") != null){
		message = (String)map.get("message");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int deptId = 0;
	if (session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute("deptId");
	}
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}

	if(map.get("prqItem")!=null){
		prqQuotationItemDetails=(List<PrqQuotationItemDetails>)map.get("prqItem");
	}
	
	if(map.get("hospitals")!=null){
		hospital=(List<MasHospital>)map.get("hospitals");
	}
	if(map.get("mmSafetyProcedureMaterial")!=null){
		mmSafetyProcedureMaterial=(List<MmSafetyProcedureMaterials>)map.get("mmSafetyProcedureMaterial");
	}
	String flag="";
    //System.out.println(mmSafetyProcedureMaterial.size()+"jspitem=="+prqQuotationItemDetails.size());
	%>

<div class="titleBg">
<h2>PO Creation</h2>
</div>
<div class="clear"></div>

<!-- thread search menu -->
<div class="Block">
<form name="poCreate" method="post">
<div class="clear"></div>
<label>PO/WO Creation Date</label>
<input type="text" name="poCreationDate" id="podateId"	value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 />
<%-- <img	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.searchPanel.poCreationDate,event);" /> --%>


<label>Vendor Name </label>
 <%if (prqQuotationItemDetails.size() > 0){ %>
<input name="vendorName" value="<%=prqQuotationItemDetails.get(0).getVendorDetails()!=null  ?prqQuotationItemDetails.get(0).getVendorDetails().getVendor().getSupplierName():"" %>"	tabindex=1   id="vendorName"/>
  <input type="hidden" name="vendorId" id="vendorid" value="<%=prqQuotationItemDetails.get(0).getVendorDetails().getVendor().getId()%>"/>
  <input  type="hidden" name="prqvend" id="prqvend" value="<%=prqQuotationItemDetails.get(0).getVendorDetails().getId()%>"/> 
  <input type="hidden" name="quotationNo." value="<%=prqQuotationItemDetails.get(0).getVendorDetails().getHeader().getQuotationNo() %>"/>
<input type="hidden" name="quotationDate" value="<%=prqQuotationItemDetails.get(0).getVendorDetails().getHeader().getQuotationDate() %>"/>
  <%} else{%>
<input name="vendorName" 	id="vendorname" value="<%=mmSafetyProcedureMaterial.get(0).getInspectionReport()!=null ? mmSafetyProcedureMaterial.get(0).getInspectionReport().getVendor().getSupplierName():"" %>" class="date" maxlength="30" tabindex=1 />
  <input  type="hidden" name="mvend" id="mvend" value="<%=mmSafetyProcedureMaterial.get(0).getInspectionReport().getVendor().getId()%>"/> 
<%} %>
<label>Delivery Date </label>
<input type="text" name="deliveryDate" id="deliverydateId" value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.poCreate.deliveryDate,true);" />

<div class="clear"></div>

<label>Delivery To</label>
<%if(prqQuotationItemDetails.size()>0) {%>
<select name="deliveryTo" validate="deliveryTo,String,yes">
<option value="">Select</option>
<%for(MasHospital emp:hospital){ %>
	 <option value="<%=emp.getId()%>"><%=emp.getHospitalName()%></option>
	 <%}}else { %>
	 <input type="text" id="deliveryTo" value="<%=mmSafetyProcedureMaterial.get(0).getInspectionReport().getHospital().getHospitalName() %>" />
	  <input type="hidden" name="deliveryTo" value="<%=mmSafetyProcedureMaterial.get(0).getInspectionReport().getHospital().getId() %>"/>
	 <%} %>
</select>
<label>Delivery Instruction</label>
<input type="text" name="deliveryInstruction"  id= "deliveryInstruction" value=""  maxlength="30" tabindex=1 />
<label>Delivery Address</label>
<input type="text" name="deliveryAddress"  id= "deliveryAddress" value=""  maxlength="30" tabindex=1 />
</div>
<div class="clear"></div>
<h4>Item Details</h4>

<div class="cmntable">
<table width="auto"  id="itemDetails" border="0"  	cellpadding="0" cellspacing="0">
<% int i=1;
		if (prqQuotationItemDetails.size() > 0) {%>
	<thead>
		<tr>
			<th width="13%">Sl No.</th>
			<th width="13%">Item Code</th>
			<th width="10%">Item Name</th>
			<th width="10%">Unit</th>
			<th width="20%">Qty</th>
			<th width="10%">Amount</th>
			<!-- <th width="10%">Discount%</th>
			<th width="10%">Tax%</th>
			<th width="10%">Total Amount</th> -->
			<th width="13%"><input type="checkbox" name="selectCheckBox1" id="selectCheckBox1" onchange="toggl()"></input>SelectAll</th>
		</tr>
	</thead>
	<tbody>
	     
		<%
				for (PrqQuotationItemDetails st : prqQuotationItemDetails) {
					flag="P";
		%>
		<tr>
		<td><%=i %></td>
		    <td width="5%"><input type="text" name="itemCode<%=i%>" value="<%=st.getItem().getPvmsNo()%>"  readonly="readonly"/></td>
			<td width="5%"> <input type="text" name="itemName<%=i%>" value="<%=st.getItem().getNomenclature() %>"  readonly="readonly"/></td>
			<td width="5%"><input type="text" name="unitName<%=i%>" value="<%=st.getItem().getItemConversion().getItemUnitName() %>"  readonly="readonly"/></td>
			<td width="5%"><input type="text" name="qty<%=i%>" value="<%=st.getApprovedQty().intValue()%>"  readonly="readonly"/></td>
			<td width="5%"><input type="text" name="netAmt<%=i%>" value="<%=st.getNewAmount() %>"  readonly="readonly"/></td>
			<%-- <td width="5%"><input type="text" name="discount<%=i%>" value="<%=st.getNewDiscountOnRate() %>"  readonly="readonly"/></td>
			<td width="5%"><input type="text" name="tax<%=i%>" value="<%=st.getNewTax() %>"  readonly="readonly"/></td>
			<td width="5%"><input type="text" name="totAmt<%=i%>" value="<%=st.getNewTotalAmount()%>"  readonly="readonly"/></td> --%>
			
			<td><input name="itemCheckBox<%=i %>" id="itemCheckBox<%=i %>" type="checkbox" value="<%=st.getId() %>" />
			<td><input name="itemManfactureId<%=i %>" id="itemManfactureId<%=i %>" type="hidden" value="<%=(st.getManufacturedBy()!=null && st.getManufacturedBy().getId()!=null)?st.getManufacturedBy().getId():0 %>" />
			<script type="text/javascript" language="javascript"
						charset="utf-8">
				

			  function toggl() {
				 var count=parseInt(document.getElementById("itemCount").value);
			        for(var i=1;i<=count;i++){
			        	if(document.getElementById('selectCheckBox1').checked)
			        		{
			        		 document.getElementById('itemCheckBox'+i).checked=true;
			        		}
			        	else
			        		{
			        		 document.getElementById('itemCheckBox'+i).checked=false;

			        		}
			        }				        }
				
				</script>
			</td>
			<input  type="hidden" name="itemId<%=i%>" id="itemId" value="<%=st.getItem().getId()%>"/>
			<input  type="hidden" name="vId" id="vId" value="<%=st.getVendorDetails().getId()%>"/>
			<input type="hidden" name="headerId" id="headerId" value="<%=st.getVendorDetails().getHeader().getId()%>"/>
		</tr>
		<%
		i++;
				}%>
	</tbody>
	<%}else if(mmSafetyProcedureMaterial.size()>0){ %>
	 <thead>
	  <tr>
	       <th width="13%">Sl No.</th>
			<th width="13%">Item Code</th>
			<th width="10%">Item Name</th>
			<th width="10%">Unit</th>
			<th width="20%">Qty</th>
			<th width="20%">Select</th>
	  </tr>
	 </thead>
	 <tbody>
	   	<%for(MmSafetyProcedureMaterials spm:mmSafetyProcedureMaterial) {
	   		flag="M";
	   	%>
	   	<tr>
	   	<td><%=i %></td>
	   	 <td><%=spm.getItem().getPvmsNo() %></td>
	   	 <td><%=spm.getItem().getNomenclature() %></td>
	   	 <td><%=spm.getItem().getItemConversion().getItemUnitName() %></td>
	   	 <td><input type="hidden" name="qty<%=i%>" value="<%=spm.getRequiredQty() %>"/><%=spm.getRequiredQty() %></td>
	   	 <td><input name="mCheckBox<%=i %>" id="mCheckBox<%=i %>" type="checkbox" value="<%=spm.getId() %>" /></td>
	   	  <td><input name="mItemid<%=i %>" id="mItemid<%=i %>" type="hidden" value="<%=spm.getItem().getId() %>" /></td>
	   	 <input type="hidden" name="vendorIdM<%=i %>" id="vendorIdM" value="<%=spm.getInspectionReport().getVendor().getId() %>"/>
	   	</tr>
	   	<%i++;}} %>
	 </tbody>
</table>
</div>
<input type="hidden" name="itemCount" id="itemCount" value="<%=i-1%>"/>
<input type="hidden" name="flag" id="flag" value="<%=flag%>"/>
<div class="clear"></div><div class="clear"></div>
<div class="clear"></div><div class="clear"></div>
<input name="button"  type="button"	value="Submit" class="button"	onclick="if(validate()&&checkData()){submitForm('poCreate','procurement?method=submitPoCreation')}"/>
<input name="button"  type="reset"	value="Reset" class="button" />
<div class="clear"></div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>