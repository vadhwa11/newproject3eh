<%@page import="jkt.hrms.util.HrmsRequestConstants"%>
<%@page import="jkt.hms.masters.business.HrTerminationProcess"%>
<%-- <%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %> --%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.HrTerminationProcess"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>



<% 
Map map= new HashMap();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}

int hospitalId = 0;
if (session.getAttribute("hospitalId") != null) {
	Integer temp =  (Integer)session.getAttribute("hospitalId");
	hospitalId = temp.intValue();
}
List<Object[]> supList=new ArrayList<Object[]>();
if(map.get("suplist")!=null){
	supList=(List<Object[]>)map.get("suplist");
}

%>
<script type="text/javascript">
document.getElemetById("quotationQty").value=document.getElementById("qrq").value;
function vali1(){
	var sl=document.getElementsByName("selectCheckBox");
	var flag=false;
		for(var i=0;i<sl.length;i++){
			if(sl[i].checked==true){
				flag=true;
			}
		}
	if(flag){
		vandor();
		window.close();
		return true;
	}else{
		alert("Select One Vendor");
		return false;
	}
	
}

function vandor(){
	var sl=document.getElementsByName("selectCheckBox");
	var vandorId="";
		var selectElement = window.opener.document.getElementById("venderID"+window.name);
		selectElement.options.length=0;
	  var j=0;
	for(var i=0;i<sl.length;i++){
		if(sl[i].checked==true){
			selectElement.options[j] = new Option(sl[i].value,sl[i].value);
			vandorId+=sl[i].value+"@";
			selectElement.options[j].selected=true;
			j++;
		}
	}
	window.opener.document.getElementById("venderIDNew"+window.name).value=vandorId;
	window.close();
}
</script>
<div id="mainIn">
<form name="itemDetails" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Item Detail</h2>
</div>

<div class="Block">
<label>Item Code</label>
<input type="text" name="itemCode" value=""    tabindex=1  readonly="readonly" id="itemCode" />

<label>Item Name</label>
<input type="text" name="itemName" value=""    tabindex=1  readonly="readonly" id="itemName" />

<label>Quotation Qty</label>
<input type="text" name="quotationQty" value="<%=request.getParameter("qrq") %>"    tabindex=1   id="quotationQty" />

 <input type="hidden" name="quotationby" value="" tabindex=1 id="quotationby"/>
 <input type="hidden" name="quotationdate" value="" tabindex=1 id="quotationdate"/>
</div>
<div class="clear"></div>


<h4>Select Vendor</h4>
<div class="paddingTop15"></div>
<form>
<div class="cmntable">
<table  colspan="7" id="vendorDetails" border="0" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="13%">Sl No.</th>
			<th width="13%">Vendor Name</th>
			<th width="10%">Address</th>
			<th width="13%">Select</th>
		</tr>
	</thead>
	<tbody>
	 <% if(supList.size()>0){
	        	int i1=1;
				for (Object[] ms : supList) {
					
	        	 %>
	          <tr>
		<td><%=i1 %></td>
			<td width="5%"><%=ms[1]%></td>
			<td width="5%"><%=ms[2]!=null?ms[2]:"" %></td>
		
<td><input name="selectCheckBox" type="checkbox" value="<%=ms[0]%>" /></td>
			
		</tr>
			
		<% 
		i1++;
				}}%>
	</tbody>
</table>


</div>
<div class="Block">
<input type="hidden" name="requestId" value=""/>
        <input type="hidden" name="vendorCount" value=""></input>
<input name="button"  type="button"	value="close" class="button"	onclick="vandor();" />
<input name="button" type="button" value="submit" onclick="" class="button"/>
<div class="clear"></div>
</div>
</form>