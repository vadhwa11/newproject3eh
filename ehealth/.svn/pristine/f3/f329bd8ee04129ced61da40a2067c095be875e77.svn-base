<%@page import="jkt.hms.masters.business.PrqQuotationVendorDetails"%>
<%@page import="jkt.hms.masters.business.MmMasRequestStatus"%>
<%@page import="jkt.hms.masters.business.PrqQuotationItemDetails"%>
<%@page import="jkt.hms.masters.business.PrqQuotationHeader"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Users"%>


<script language="javascript"  type="text/javascript" src="/hms/jsp/js/ajax.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/calender.js"></script>
<script>
	 var nameArray=new Array();
	 var itemsArray1=new Array();
</script>
<script type="text/javascript">
function openPopupWindow2(count,url)
{
	//var url="/hms/hms/procurement?method=showVendorListJsp";
 	newwindow=window.open(url,''+count+'',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
}
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


	function isNumber(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode != 46 && charCode > 31
     && (charCode < 48 || charCode > 57))
      return false;

   return true;
}
function myFunction(val1,totValue,id)
{
	var val=0;
	var totV=0;
	if(val1!=null && val1!="")
		val+=parseInt(val1);
	if(totValue!=null && totValue!="")
		totV=parseInt(totValue);
//  	alert(val+"===="+totV+"===="+id);
//alert(val>totV);
	if(val>totV){
		document.getElementById(id).value="";
		return true;
	}
	return false;
}	

function vali(){
	var sl=document.getElementsByName("selectCheckBox2");
	var flag=false;
		for(var i=0;i<sl.length;i++){
			if(sl[i].checked==true){
				flag=true;
			}
		}
	if(flag){
		return true;
	}else{
		alert("Atleast Select One vendor For Submission");
		return false;
	}
	
}
</script>



<%
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<PrqQuotationItemDetails> appList=new ArrayList<PrqQuotationItemDetails>();
	List<PrqQuotationVendorDetails> vendor=new ArrayList<PrqQuotationVendorDetails>();
	List<MmMasRequestStatus> stat=new ArrayList<MmMasRequestStatus>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	
	if(map.get("itemList")!=null){
		appList=(List<PrqQuotationItemDetails>)map.get("itemList");
	}
	if(map.get("status")!=null){
		stat=(List<MmMasRequestStatus>)map.get("status");
	}
	
	if(map.get("vendorList")!=null){
		vendor=(List<PrqQuotationVendorDetails>)map.get("vendorList");
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

	%>

<div class="titleBg">
<h2>Quotation Requisition Approval</h2>
</div>
<div class="clear"></div>

<!-- thread search menu -->
<div class="Block">
<form name="itemGrid" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<label>Quotation Requisition Date </label>
<input type="text" name="quotationRequisitionDate1"	value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 readonly="readonly"/>
<img	id="calendar" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.searchPanel.quotationRequisitionDate1,event);" />

<label>Quotation Requisition By</label>
<input type="text" name="quotationRequisitionBy" value="<%=((Users)session.getAttribute("users")).getEmployee().getEmployeeName()%>" tabindex=1   id="quotationRequisitionBy" readonly="readonly"/>

<label> Date upto rates remain same <span>*</span></label> 
<input	type="text" name="dateuptoratesremainsame" id="dateuptoratesremainsame" validate="Date upto rates remain same,string,yes" value="" class="date" readonly="readonly" MAXLENGTH="50"  />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.itemGrid.dateuptoratesremainsame,event)" /> 


<div class="clear"></div>


<label> Quotation Opening Date <span>*</span></label> 
<input	type="text" name="openingDateQuotation" id="openingDateQuotation" validate="Date of opening of Quotation,string,yes" value="" class="date" readonly="readonly" MAXLENGTH="50"  />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.itemGrid.openingDateQuotation,event)" /> 


<label> Quotation opening Time <span>*</span></label> 
<input	type="text" name="openingTimeQuotation" id="openingTimeQuotation" validate="Time of opening of Quotation,string,yes" value="" MAXLENGTH="5" onKeyUp="if(this.value!=''){mask(this.value,this,'2',':')};" onBlur="if(this.value!=''){IsValidTime(this.value,this.id);}" />

<div class="clear"></div>

<label> Quotation Due Date <span>*</span></label> 
<input	type="text" name="dueDateQuotation" id="dueDateQuotation" validate="Quotation Due Date,string,yes" value="" class="date" readonly="readonly" MAXLENGTH="50"  />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.itemGrid.dueDateQuotation,event)" /> 


<label> Quotation Due Time <span>*</span></label> 
<input	type="text" name="dueTimeQuotation" id="dueTimeQuotation" validate="Quotation Due Time,string,yes" value="" MAXLENGTH="5" onKeyUp="if(this.value!=''){mask(this.value,this,'2',':')};" onBlur="if(this.value!=''){IsValidTime(this.value,this.id);}" />




</div>
<div class="clear"></div>

<h4>Item Details</h4>

<div class="cmntable">
<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="13%">Sl No.</th>
			<th width="13%">Item Code</th>
			<th width="10%">Item Name</th>
			<th width="10%">Unit</th>
			<th width="20%">Quotation Qty</th>
			<th width="13%">Qty Needed</th>
			<th width="20%">Technical Specification</th>
			<th><input type="checkbox" name="selectCheckBox1" id="selectCheckBoxMain1" onchange="toggle1()"></input></th>
				<script type="text/javascript" language="javascript"
						charset="utf-8">
				
				function toggle1() {
					
					 checkboxes = document.getElementsByName('selectCheckBox1');
					// alert(checkboxes.length);
					if(document.getElementById('selectCheckBoxMain1').checked)
						{
					  for(var i=0, n=checkboxes.length;i<n;i++) {
					    checkboxes[i].checked = true;
					  }
						}
					else
						{
						 for(var i=0, n=checkboxes.length;i<n;i++) {
							    checkboxes[i].checked = false;
							  }
						}
					}
				</script>
			
		</tr>
	</thead>
	<tbody>
	      	<%
	      	int i=0;
	      	List<Integer> itemIdList=new ArrayList<Integer>();
			if (appList.size() > 0) {
				
				for (PrqQuotationItemDetails st : appList) {
					if(!itemIdList.contains(st.getItem().getId()))
							{
						itemIdList.add(st.getItem().getId());
					String technicalSpecification="";
					if(st.getItem().getSpecification()!=null)
						technicalSpecification=st.getItem().getSpecification();
					i++;
		%>
		<tr>
			<td><%=i %> <input type="hidden" name="itemId<%=i%>" id="itemId<%=i%>" value="" /></td>
			<td width="5%"><%=st.getItem().getPvmsNo() %></td>
			<td width="5%"><%=st.getItem().getNomenclature() %></td>
			<td width="5%"><%=st.getItem().getItemConversion().getItemUnitName() %></td>
			<td width="5%"><%=st.getReqQty().intValue() %></td>
			<td><input type="text" name="quotationRequisitionQty<%=i%>" value="" tabindex=1   id="quotationRequisitionQty<%=i%>" onblur="return myFunction(this.value,<%=st.getReqQty()  %>,'quotationRequisitionQty<%=i%>')" validate="quotationRequisitionQty<%=i%>,string,yes" onkeypress="return isNumber(event)"/></td>
		    <td width="5%"><%=technicalSpecification %></td>
		    
			<td><input name="selectCheckBox1" id="selectCheckBox1" type="checkbox" value="<%=st.getItem().getId() %>" />
			<input name="selectItem<%=i %>" id="selectItem" type="hidden" value="<%=st.getItem().getId() %>" /></td>
			</tr>
		<%
							}}}%>
				</tbody>

<input type="hidden" name="itemcount" value="<%=i%>" />

</table>
</div>

<h4>Select Vendor</h4>
<div class="paddingTop15"></div>
<form>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="cmntable">
<table  colspan="7" id="vendorDetails" border="0" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="13%">Sl No.</th>
			<th width="13%">Vendor Name</th>
			<th width="10%">Address</th>
			<th><input type="checkbox" name="selectCheckBox2" id="selectCheckBox2" onchange="toggle2()"></input></th>
				<script type="text/javascript" language="javascript"
						charset="utf-8">
				
				function toggle2() {
				
					 checkboxes = document.getElementsByName('selectCheckBox2');
					 //alert(checkboxes.length);
					if(document.getElementById('selectCheckBox2').checked)
						{
					  for(var i=0, n=checkboxes.length;i<n;i++) {
					    checkboxes[i].checked = true;
					  }
						}
					else
						{
						 for(var i=0, n=checkboxes.length;i<n;i++) {
							    checkboxes[i].checked = false;
							  }
						}
					}
				</script>
		</tr>
	</thead>
	<tbody>
	 <% if(vendor.size()>0){
	        	int i1=1;
				for (PrqQuotationVendorDetails ms : vendor) {
					String add="";
					if(ms.getVendor().getAddress1()!=null)
					{
						add=ms.getVendor().getAddress1();
					}
					
	        	 %>
	          <tr>
		   <td><%=i1 %></td>
			<td width="5%"><%=ms.getVendor().getSupplierName() %> </td>
			<td width="5%"><%=add%></td>
		<td><input name="selectCheckBox2" id="selectCheckBox1" type="checkbox" value="<%=ms.getId() %>" />
		<input name="selectVendor<%=i1 %>" id="selectvendor" type="hidden" value="<%=ms.getId() %>" /></td>
			
		</tr>
			
		<% 
		i1++;
					}}%>
	</tbody>
</table>
<%if(vendor.size()>0){ %>
	 <input type="hidden" name="headerId" value="<%=vendor.get(0).getHeader().getId() %>" />
 <%} %>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
     <label>Status</label>
      <select  name="status" validate="Status,string,yes" onchange="vailidate(this)" ><option value="">Select</option>
	 <%for(MmMasRequestStatus stats :stat){ %>
	 <option value="<%=stats.getStatusCode() %>"><%=stats.getStatusName() %></option>
	 <%} %>
	 </select>
     <label id="reason">Reason</label>
    <textarea rows="" cols="" id="remarks" name="remarks"></textarea>

    </div>
<div class="clear"></div>
<input name="button"  type="button"	value="Submit" class="button"	onclick="if(vali()){submitForm('itemGrid','procurement?method=saveQuotationRequisitionApprovalJsp')}" />
<input name="button"  type="reset"	value="Reset" class="button"	onclick=""; />


<div class="clear"></div>
<script>
   function vailidate(id){
	   if(id.value!=""){
		   document.getElementById("reason").innerHTML="Reason";
		   document.getElementById("remarks").setAttribute("validate","Remark,string,no");
		   if(id.value=='RJ'){
			   document.getElementById("reason").innerHTML="Reason<span> *</span>";
			   document.getElementById("remarks").setAttribute("validate","Remark,string,yes");
		   }
	   }
   }
   </script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>