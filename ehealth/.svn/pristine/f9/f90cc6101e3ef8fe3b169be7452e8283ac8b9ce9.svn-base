<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import=" jkt.hms.masters.business.StoreInternalIndentT"%>

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
<script>
	 var nameArray=new Array();
	 var itemsArray1=new Array();
</script>
<script type="text/javascript">

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
		alert("Select Atleast one Vendor For Proceed");
		return false;
	}
	
}
function checkData(){
    var start= new Date(document.getElementById("fromDate").value.split("/")[2], document.getElementById("fromDate").value.split("/")[1], document.getElementById("fromDate").value.split("/")[0]);
     var end= new Date(document.getElementById("toDate").value.split("/")[2], document.getElementById("toDate").value.split("/")[1], document.getElementById("toDate").value.split("/")[0]);
     if(start<=end){
         return true;
     }else{alert("Date is Incorrect.");return false;}
}
</script>

<%
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<MasStoreGroup> storeGroup=new ArrayList<MasStoreGroup>();
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
	
	List<StoreInternalIndentT> pendingList= new ArrayList<StoreInternalIndentT>();
	List<Object[]> departmentIndentList = new ArrayList<Object[]>();
	if(request.getAttribute("map")!=null)
	{
		map=(Map<String ,Object>)request.getAttribute("map");
	}
	
      if(map.get("storelist")!=null){
	pendingList=(List<StoreInternalIndentT>)map.get("storelist");
	
}
      if(map.get("group1")!=null){
    	  storeGroup=(List<MasStoreGroup>)map.get("group1");
    		
    	}
      if(map.get("departmentIndentList")!=null){
    	  departmentIndentList=(List<Object[]>)map.get("departmentIndentList");
    	}
    System.out.println("In JSP >>>>>>>>>>>>"+pendingList.size());
	%>

<div class="titleBg">
<h2>Pending items for Local Purchase</h2>
</div>
<div class="Block">
<form name="searchPanel" method="post">
<label>From Date </label>
<input type="text" name="<%= FROM_DATE %>"	value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 id="fromDate" validate="From Date,date,no"/>
<img	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.searchPanel.<%= FROM_DATE%>,event);" />
<label>To Date </label>
<input type="text" name="<%= TO_DATE %>" value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 id="toDate" validate="To Date,date,no" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.searchPanel.<%= TO_DATE%>,true);" />

<!-- <label>Item Code</label>
<input type="text" name="itemCode" value=""	tabindex=1   id="itemCode" />


<label>Item Name </label>

<input type="text" name="itemName" value=""	tabindex=1   id="itemName" />
<div id="ac2update1" style="display: none;" class="autocomplete"></div>
					<script type="text/javascript" language="javascript"
						charset="utf-8">
			
			  new Ajax.Autocompleter('itemName','ac2update1','inPatientMaster?method=getItemListForAutoComplete',{parameters:'requiredField=itemName'});
			</script>


<label>Indent No.</label>
<input type="text" name="indentNo" value=""	tabindex=1   id="indentNo" /> -->

<label><span>*</span>Group</label>
<select name="group" id="group"  tabindex="1" validate="Group,int,yes"  >
<option value="">select</option>
   <%
		for (MasStoreGroup masStoreGroup : storeGroup) {
	%>
	<option value="<%=masStoreGroup.getId ()%>"><%=masStoreGroup.getGroupName()%></option>
	<%
		}
	%>
</select>
<div class="clear"></div>

<input name="button"  type="button"	value="Search" class="button"	onclick="if(checkData()){submitForm('searchPanel','procurement?method=showPendingItemsForLocalPurchaseJsp')}" />



	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
<div class="clear"></div>
<form name="itemGrid" method="post">
<%if (pendingList.size() > 0) {
	int i=1; %>
<h4>Item Details</h4>
<div class="cmntable">
<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th>Sl No.</th>
			<th>Indent No.</th>
			<th>Indenting Department</th>
			<th>Item Code</th>
			<th>Item Name</th>
			<th>Unit</th>
			<th>Qty Required</th>
			<th><input type="checkbox" name="selectCheckBox1" id="selectCheckBox1" onchange="toggle1()"></input></th>
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

		<%
		List<Integer> itemList=new ArrayList<Integer>(); 
		   if (pendingList.size() > 0) {
			for (StoreInternalIndentT st : pendingList) {
				  if(!itemList.contains(st.getItem().getId()))
				{
					itemList.add(st.getItem().getId()); 
		%>
		<tr>
		<td><%=i %></td>
		    <td width="5%"><%=st.getInternal()!=null ?st.getInternal().getDemandNo():""%></td>
		    <%
		    String department = "";
   			//System.out.println("departmentIndentList=="+departmentIndentList.size());
		    	if(departmentIndentList.size()>0){
		    		for(Object[] obj : departmentIndentList){
		    		//System.out.println("st.getItem().getId()---"+st.getItem().getId());
		    		//System.out.println("(Integer)obj[0]---"+(Integer)obj[0]);
		    		if(st.getItem().getId().equals((Integer)obj[0])){
		    			if(!department.equals("")){
		    				department += ",";
		    			}
		    			department += (String)obj[1];
		    			}
		    		}
		    	}
		    			
		    %>
		    <td width="5%"><%=department %></td>
			<td width="5%"><%=st.getItem()!=null?st.getItem().getPvmsNo():"" %></td>
			<td width="5%"><%=st.getItem()!=null ? st.getItem().getNomenclature():"" %></td>
			<td width="5%"><%=st.getItem()!=null ?st.getItem().getItemConversion().getItemUnitName():"" %></td>
			<%
				if(st.getQuatationQty() != null && !st.getQuatationQty().equals(0.00)){
			%>
			<td width="5%"><%=st.getQtyRequest()%></td>
			<%}else{ %>
			
			<td width="5%"><%=st.getQtyRequest() %></td>
			<%} %>
			<td><input name="selectCheckBox" type="checkbox" value="<%=st.getId() %>" /></td>
		</tr>			
		
		<%
		i++;
				}}}%>
				
   </table>
   <input name="button"  type="button"	value="Proceed" class="button"	onclick="if(vali()){submitForm('itemGrid','procurement?method=showQuotationRequisitionJsp')}" />
   <input name="button"  type="reset"	value="Reset" class="button"	onclick="" />
   <%}else{%>
				No Record Found
		<% 	}
			%>	
   </div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
   
   </form>
   
