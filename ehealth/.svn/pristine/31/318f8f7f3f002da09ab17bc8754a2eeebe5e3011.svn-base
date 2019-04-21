<%@page import="jkt.hms.masters.business.UploadDocuments"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasItemType"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<script language="javascript"  type="text/javascript" src="/hms/jsp/js/ajax.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/calender.js"></script>
<script>
	 var nameArray=new Array();
	 var itemsArray1=new Array();	 
</script>
<script type="text/javascript">
function openPopupWindow1(count)
{
	var qrq=document.getElementById("quotationRequisitionQty"+count).value;
	var url="/hms/hms/procurement?method=openVendorListJsp&qrq&requestedId="+qrq+""+count.value;
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
	function vali(){
	var sl=document.getElementsByName("quotationRequisitionQty");
	var flag=false;
		for(var i=0;i<sl.value;i++){
			if(sl[i].checked==true){
				flag=true;
			}
		}
	if(flag){
		return true;
	}else{
		alert("Select Atleast One Item For Submission");
		return false;
	}	
} 
function isNumber(evt)
{//alert(evt);
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
</script>
<%
	Map<String, Object> map= new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<StoreInternalIndentT> pendingList= new ArrayList<StoreInternalIndentT>();
	List<MasStoreGroup> groups=new ArrayList<MasStoreGroup>();
	List<MasItemType> types=new ArrayList<MasItemType>();
	List<MasStoreSection> sections=new ArrayList<MasStoreSection>();
	List<UploadDocuments> uploadDocumentList = new ArrayList<UploadDocuments>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	if(map.get("itemList")!=null){
		pendingList=(List<StoreInternalIndentT>)map.get("itemList");
	}
	
	List<Object[]> supList=new ArrayList<Object[]>();
	if(map.get("suplist1")!=null){
		supList=(List<Object[]>)map.get("suplist1");
	}
	if(map.get("group")!=null){
		groups=(List<MasStoreGroup>)map.get("group");
	}
	if(map.get("type")!=null){
		types=(List<MasItemType>)map.get("type");
	}
	if(map.get("section")!=null){
		sections=(List<MasStoreSection>)map.get("section");
	}
	if(map.get("uploadDocumentList")!=null){
		uploadDocumentList=(List<UploadDocuments>)map.get("uploadDocumentList");
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
	// System.out.println("--===="+supList.size());	
    %>

<div class="titleBg">
<h2>Quotation Requisition</h2>
</div>
<div class="Block">
<form name="itemGrid" method="post">
<div class="clear"></div>
<label>Quotation Date </label>
<input type="text" name="quotationRequisitionDate"	value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.searchPanel.quotationRequisitionDate,event);" />

<label>Quotation By</label>
<label name="quotationRequisitionBy">
<%
   String user="";
   if(((Users)session.getAttribute("users"))!=null && ((Users)session.getAttribute("users")).getEmployee().getEmployeeName()!=null)
   {
	   user=((Users)session.getAttribute("users")).getEmployee().getEmployeeName();
   }
%>
<input type="text" name="quotationRequisitionBy" value="<%=user%>"	tabindex=1   id="quotationRequisitionBy" class="readonly"/>
</label>

<%-- <label><span>*</span>Group</label>
<select name="group" id="group"  tabindex="1" onchange="submitProtoAjaxWithDivName('itemGrid','procurement?method=getItemTypeGLList&group='+this.value,'nameDiv')" >
<option value="">select</option>
   <%
		for (MasStoreGroup masStoreGroup : groups) {
	%>
	<option value="<%=masStoreGroup.getId ()%>"><%=masStoreGroup.getGroupName()%></option>
	<%
		}
	%>
</select>
<div id="nameDiv">
<label><span>*</span>Type</label>
<select name="type" id="type" tabindex="1" onchange="submitProtoAjaxWithDivName('itemGrid','/hms/hms/procurement?method=getSectionGLList&type='+this.value,'testDiv');">
<option value="">select</option>

<%
		for (MasItemType masItemType : types) {
	%>
	<option value="<%=masItemType.getId ()%>"><%=masItemType.getItemTypeName()%></option>
	<%
		}
	%>
</select>
<div id="testDiv">
<label><span>*</span>Section</label>
<select name="section" id="section" validate="section,String,No" tabindex="1" onchange="submitProtoAjaxWithDivName('itemGrid','/hms/hms/procurement?method=responseQuotationRequisition&type&section&group='+this.value,'testDiv');>
<option value="">select</option>

<%
		for (MasStoreSection masStoreSection : sections) {
	%>
	<option value="<%=masStoreSection.getId ()%>"><%=masStoreSection.getSectionName()%></option>
	<%
		}
	%>
</select> --%>
<!-- </div>
</div> -->

<div class="clear"></div>
<h4>Item Details</h4>
<input type="hidden" id="aaTest"  value="" />
<%int i=0; %>
<div class="cmntable">
<table width="100%" colspan="7" id="itemDetails" border="0" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="13%">Sl No.</th>
			<th width="13%">Item Code</th>
			<th width="10%">Item Name</th>
			<th width="10%">Unit</th>
			<th width="20%">Qty Required</th>
			<th width="13%">Quotation Requisition Qty</th>
			<th width="13%">File</th>
			<!-- <th width="13%">Vendor</th> -->
		</tr>
	</thead>
	<tbody>
	    	<%
			if (pendingList.size() > 0) {
				
				for (StoreInternalIndentT st : pendingList) {
					i++;
		%>
		<tr>
			<td><%=i %> <input type="hidden" name="itemId<%=i%>" id="itemId<%=i%>" value="<%=st.getItem().getId() %>" /></td>
			<td width="5%"><%=st.getItem().getPvmsNo() %></td>
			<td width="5%"><%=st.getItem().getNomenclature() %></td>
			<td width="5%"><%=st.getItem().getItemConversion().getItemUnitName() %></td>			
			<%
				if(st.getQuatationQty() != null && !st.getQuatationQty().equals(0.00)){
			%>
			<td width="5%"><%=st.getQtyRequest() %><input type="hidden" name="indentItemQty<%=i %>" value="<%=st.getQtyRequest() %>" />
			<%}else{ %>
			<td width="5%"><%=st.getQtyRequest() %><input type="hidden" name="indentItemQty<%=i %>" value="<%=st.getQtyRequest() %>" />
			
			<%} %>
			
			<input type="hidden" name="indentQuationQty<%=i %>" value="<%=st.getQuatationQty()%>" /></td>
			<td><input type="text" name="quotationRequisitionQty<%=i%>" value=""	 tabindex=1   id="quotationRequisitionQty<%=i%>"  validate="quotationRequisitionQty<%=i%>,String,yes" onblur="return myFunction(this.value,<%=st.getQtyRequest() %>,'quotationRequisitionQty<%=i%>')" onkeypress="return isNumber(event)"/></td>
		   <%--  <td><input type="button" class="button" name="addVendor<%=i%>" value="addVendor" tabindex=1 id="addVendor<%=i%>" onclick="openPopupWindow1('<%=i%>')" />
			<input type="hidden" id="venderIDNew<%=i%>" name="venderIDNew" value="" />
			<select name="venderID<%=i%>" id="venderID<%=i%>" multiple="multiple" style="display: none" >
			</select> --%>
			<input type="hidden" name="itemId1<%=i%>" id="itemId1<%=i%>" value="<%=st.getId()%>" />
			<input type="hidden" name="groupId<%=i%>" value="<%=st.getItem().getGroup().getGroupName() %>"/>
			</td>
			<%
			int uploadId = 0;
			String fileName = "";
			String fileExtension = "";
			if(uploadDocumentList.size()>0){ 
				for(UploadDocuments uploadDocuments : uploadDocumentList){
					
					if(st.getId()==(uploadDocuments.getStoreInternalT().getId())){
						uploadId = (Integer)uploadDocuments.getId();
						fileExtension =(String)uploadDocuments.getFileExtension();
						fileName =(String)uploadDocuments.getFileName();
						
					}}}
			%>
			<%if(uploadId != 0){ %>
			<td><a href="#" onclick="submitFormForButton('itemGrid','investigation?method=viewUploadDocuments&viewFrom=IP&uploadedDocumentId=<%=uploadId%>&filename=<%=fileName+"."+fileExtension%>&'+csrfTokenName+'='+csrfTokenValue)"><%=fileName+"."+fileExtension%></a></td>  <!-- File Having Link to Download-->
			<%}else{ %>
			<td>-</td>
			<%} %>
			<%-- <% }else{%> 
			<td>--<td>
			<%}break;}}else{ %>
			<td>--<td>
			<%} %> --%>
			</tr>
		<%
				}}%>
				</tbody>
</table>
<input type="hidden" name="itemcount" value="<%=i%>" />
</div>
<div class="clear"></div>
<h4>Vendor Details</h4>
<div class="cmntable">
<table width="100%" colspan="7" id="itemDetails" border="0" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="13%">Sl No.</th>
			<th width="13%">Vendor Name</th>
			<th width="10%">Address</th>
			<th width="10%">MobileNo.</th>
			<th width="10%">Email Id</th>
			<!-- <th width="10%">Select</th> -->
			<th  style="width: 200px"> Select<input type="checkbox" name="selectCheckBox1" id="selectCheckBox1" onchange="toggle1()"></input></th>
				<script type="text/javascript" language="javascript" charset="utf-8">
				
				function toggle1() {
				
					 checkboxes = document.getElementsByName('selectCheckBox');
					if(document.getElementById('selectCheckBox1').checked)
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
	<tbody> <% if(supList.size()>0){
	        	int i1=1;
				for (Object[] ms : supList) {
	        	 %>
	          <tr>
		<td><%=i1 %></td>
			<td width="5%"><%=ms[1]!=null ? ms[1]:""%></td>
			<td width="5%"><%=ms[2]!=null?ms[2]:"" %></td>
		    <td><input type="text" name="mobileno<%=i1 %>" id="mobileno<%=i1 %>" value="<%=ms[3]!=null?ms[3]:"" %>"/>
		    </td>
		    <td><input type="text" name="emailId<%=i1 %>" id="emailId<%=i1 %>" value="<%=ms[4]!=null?ms[4]:"" %>"/>
		    </td>
            <td><input name="selectCheckBox" type="checkbox" value="<%=ms[0]%>"  /></td>
		</tr>
		<% 
		i1++;
				}}%>
	</tbody>
	
	</table>
	<input type="hidden" name="venderID" value="<%=i%>" />
	</div>
<div class="paddingTop15"></div>
<input name="button"  type="button"	value="Submit" class="button"	onclick="if(validate()){submitForm('itemGrid','procurement?method=saveQuotationRequisitionJsp')}" />
<input name="button"  type="reset"	value="Reset" class="button"	onclick=""; />
<input type="button" value="Back" class="button" onclick="javascript: history.go(-1);">
<div class="clear"></div> 
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
</div>
<script type="text/javascript">
function validate(){
	var sl=document.getElementsByName("selectCheckBox");
	var flag=false;
		for(var i=0;i<sl.length;i++){
			if(sl[i].checked==true){
				flag=true;
			}
		}
	if(flag){
		return true;
	}else{
		alert("Select Atleast one vendor for Submission");
		return false;
	}
	
}

</script>
<!-- <div id="testDiv1"></div> -->