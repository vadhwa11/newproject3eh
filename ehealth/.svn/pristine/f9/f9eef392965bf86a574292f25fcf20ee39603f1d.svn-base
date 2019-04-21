<%@page import="jkt.hms.masters.business.MmServiceRequest"%>
<%@page import="jkt.hms.masters.business.PrqQuotationHeader"%>
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
</script>



<%
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<PrqQuotationHeader> hdrLst=new ArrayList<PrqQuotationHeader>();
	List<MmServiceRequest> requests=new ArrayList<MmServiceRequest>();
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
	if(map.get("hdrList")!=null)
	{
		hdrLst=(List<PrqQuotationHeader>)map.get("hdrList");
	}
	if(map.get("mmServiceRequests")!=null)
	{
		requests=(List<MmServiceRequest>)map.get("mmServiceRequests");
	}
	%>
<%=map.get("msg")!=null?map.get("msg"):"" %>
<div class="titleBg">
<h2>Commercial Approval</h2>
</div>
<div class="clear"></div>

<div class="Block">
<form name="itemGrid" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>

<label>Quotation/Request No. </label>
<label class="value"><%=request.getParameter("flag")!=null ? request.getParameter("flag"):"" %></label>
<input type="hidden" readonly="readonly" name="quotationRequisitionNo" id="quotationRequisitionNo" value="<%=request.getParameter("quotationRequisitionNo")!=null ? request.getParameter("quotationRequisitionNo"):"" %>" />

<!-- <select name="quotationRequisitionNo" id="quotationRequisitionNo" onchange="displayItem(this.value)"> -->
<!-- <option value="">Select</option> -->
<%--     <%for(PrqQuotationHeader prqHdr1:hdrLst){ --%>
    	
<%--     	%> --%>
<%-- 	 <option value="<%=prqHdr1.getId()%>@Q"><%=prqHdr1.getQuotationNo()%></option> --%>
<%-- 	 <%} %> --%>
	 
<%-- 	  <%for(MmServiceRequest mmServiceRequest:requests){ --%>
    	
<%--     	%> --%>
<%-- 	 <option value="<%=mmServiceRequest.getId()%>@R"><%=mmServiceRequest.getServiceRequestNo()%></option> --%>
<%-- 	 <%} %> --%>
<!-- </select> -->

<div id="itemDiv">

</div>

</form>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<script>
   function vailidat(id){
	   if(id.value!=""){
		   document.getElementById("reason").innerHTML="Reason";
		   document.getElementById("remarks").setAttribute("validate","Remark,string,no");
		   if(id.value=='CR'){
			   document.getElementById("reason").innerHTML="Reason<span> *</span>";
			   document.getElementById("remarks").setAttribute("validate","Remark,string,yes");
		   }
	   }
   }
   </script>

<script type="text/javascript">
// function displayItem(obj){
	 if(document.getElementById("quotationRequisitionNo").value!="")
	 {  
		 var data=document.getElementById("quotationRequisitionNo").value.split("@");
		 submitProtoAjaxWithDivName('itemGrid','/hms/hms/procurement?method=getItemListForCommercial&quotationRequisitionNo1='+data[0]+'&flag='+data[1],'itemDiv');
	 }
// }
function vendorDisplay(obj,id,flag)
{
	//alert(obj+""+id+""+flag);
	 var itemCount=document.getElementById('itemCount').value;
	// alert(itemCount);
	 var selected=0;
	 for(var i=1;i<=itemCount;i++)
		 {
		 if(document.getElementById('checkbox'+i).checked)
			 {
			 selected++;
			 }
		 }
//alert(selected);
	 if(selected>1)
		 {
		 alert('Please only one Item!!'+selected);
		 document.getElementById(id).checked=false;
		 return;
		 }
	 if(document.getElementById(id).checked)
		 {
		 submitProtoAjaxWithDivName('itemGrid','/hms/hms/procurement?method=vendorListCommercialJsp&requisitionId='+obj+'&flag='+flag,'vendorDiv');
		 }
	 else
		 {
		 document.getElementById('vendorDiv').innerHTML="";
		 }
}
function validate(){
	
    var flag=false;
    var count=parseInt(document.getElementById("vendorCount").value);
    var TotalChecked=0;
    TotalChecked = TotalChecked *1;
    
        for(var i=1;i<=count;i++){
        	if(document.getElementById("itemCheckbox"+i)!=null){
            if(document.getElementById("itemCheckbox"+i).checked==true){
                flag=true;
                TotalChecked++;
            }
        	}
        }
        for(var i=1;i<=count;i++){
        	if(document.getElementById("maintinenceCheckbox"+i)!=null){
            if(document.getElementById("maintinenceCheckbox"+i).checked==true){
                flag=true;
            }
        	}
        }
    if(flag){
    	if(TotalChecked>1)
    		{
    			alert("Please select only one vendor for Approval");
    		  return false;
    		}
    	
        return true;
    }else{
        alert("Select the vendor for Approval");
        return false;
    }
    
}
</script>
