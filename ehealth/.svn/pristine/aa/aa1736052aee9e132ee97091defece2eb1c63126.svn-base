<%@page import="jkt.hms.masters.business.MmServiceRequest"%>
<%@page import="jkt.hms.masters.business.PrqQuotationVendorDetails"%>
<%@page import="jkt.hms.masters.business.MmMasRequestStatus"%>
<%@page import="jkt.hms.masters.business.PrqQuotationItemDetails"%>
<%@page import="jkt.hms.masters.business.PrqQuotationHeader"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>


<script language="javascript"  type="text/javascript" src="/hms/jsp/js/ajax.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/proto.js"></script>
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
</script>



<%
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<PrqQuotationVendorDetails> prqHdr=new ArrayList<PrqQuotationVendorDetails>();
	List<PrqQuotationHeader> hdr=new ArrayList<PrqQuotationHeader>();
	List<MmServiceRequest> stat=new ArrayList<MmServiceRequest>();
	List<MasEmployee> users=new ArrayList<MasEmployee>();
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

	if(map.get("users")!=null){	
		users=(List<MasEmployee>)map.get("users");
	}
	if(map.get("mmServiceRequests")!=null){
		stat=(List<MmServiceRequest>)map.get("mmServiceRequests");
	}
	System.out.println("Tech-Appp---"+stat.size());
	if(map.get("prqItem")!=null)
	{
		prqHdr=(List<PrqQuotationVendorDetails>)map.get("prqItem");
	}
	if(map.get("hdr")!=null)
	{
		hdr=(List<PrqQuotationHeader>)map.get("hdr");
	}
	%>
<%=map.get("msg")!=null?map.get("msg"):"" %>
<div class="titleBg">
<h2>Technical Approval</h2>
</div>
<div class="clear"></div>
<div class="Block">
<form name="searchPanel" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>

<label>Quotation/Request No. </label>
<label class="value"><%=request.getParameter("flag")!=null ? request.getParameter("flag"):"" %></label>
<input type="hidden" readonly="readonly" name="quotationRequisitionNo" id="quotationRequisitionNo" value="<%=request.getParameter("quotationRequisitionNo")!=null ? request.getParameter("quotationRequisitionNo"):"" %>" />
<!-- <select name="quotationRequisitionNo" id="quotationRequisitionNo" onchange="displayValue(this.value)"> -->
<!-- <option value="">Select</option> -->
<%--     <%for(PrqQuotationHeader prqHdr1:hdr){ --%>
    	
<!-- //     	String prqQuotation=""; -->
<!-- // 					if(prqHdr1.getQuotationNo()!=null) -->
<!-- // 						prqQuotation=prqHdr1.getQuotationNo(); -->
<%-- 					%> --%>
<%-- 	 <option value="<%=prqHdr1.getId()%>@Q"><%=prqQuotation%></option> --%>
<%-- 	 <%} %> --%>
	 
<%-- 	 <% for(MmServiceRequest mmServiceRequest:stat) --%>
<!-- // 	 { -->
<%-- 		%>  --%>
<%-- 		<option value="<%=mmServiceRequest.getId()%>@R"><%=mmServiceRequest.getServiceRequestNo()%></option> --%>
<%-- 		<% --%>
<!-- // 	 } -->
	 
<%-- 	 %> --%>
<!-- </select> -->
<div id="test1Div" >
<!-- <label>Quotation Date </label> -->
<!-- <input type="text" name="quotationRequisitionDate"	id="sdate" value="" class="date" maxlength="30" tabindex=1 /> -->

<!-- <label>Quotation By</label> -->
<!-- <input type="text"  name="quotationBy" id="quotationBy" value=""/> -->

<!-- <div class="clear"></div> -->


<!-- <label>Approved By</label> -->
<!-- <input type="text"  name="quotationApproved" id="quotationApproved" value=""/> -->

	</div>
</form>

</div>

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<script>
   function vailidate(id){
	   if(id.value!=""){
		   document.getElementById("reason").innerHTML="Reason";
		   document.getElementById("remarks").setAttribute("validate","Remark,string,no");
		   if(id.value=='TR'){
			   document.getElementById("reason").innerHTML="Reason<span> *</span>";
			   document.getElementById("remarks").setAttribute("validate","Remark,string,yes");
		   }
	   }
   }
   </script>
<script type="text/javascript">

function populateValue(obj)
{
	
	 document.getElementById("sdate").value=document.getElementById("requisationDate").value;
	
	}
// function displayValue(obj){
	 if(document.getElementById("quotationRequisitionNo").value!="")
	 {
		// document.getElementById("sdate").value=document.getElementById("rdate").value;
		//alert('aa'+document.getElementById("quotationRequisitionNo").value);
		submitProtoAjaxWithDivName('searchPanel','/hms/hms/procurement?method=getItemTypeGLList&quotationRequisitionNo='+document.getElementById("quotationRequisitionNo").value,'test1Div');
		//alert("tt--"+document.getElementById("requisationDate").value);
		// document.getElementById("sdate").value=document.getElementById("requisationDate").value;
		 
	 }
// }
function maintinenceItemList(obj){
	//alert(obj.value);
	
	if(obj.checked)
	 {
	 submitProtoAjaxWithDivName('searchPanel','/hms/hms/procurement?method=responseTechnicalApproval&flag=R&requisitionId='+obj.value,'testDiv');
	 }
else
	 {
	 document.getElementById('testDiv').innerHTML="";
	 }
}
function vender(obj)
{
	 var venderCount=document.getElementById('venderCount').value;
	 var selected=0;
	 for(var i=1;i<=venderCount;i++)
		 {
		 if(document.getElementById('checkbox'+i).checked)
			 {
			 selected++;
			 }
		 }
	 if(selected>1)
		 {
		 alert('Please only one vender!!');
		 obj.checked=false;
		 return;
		 }
	 if(obj.checked)
		 {
		 submitProtoAjaxWithDivName('searchPanel','/hms/hms/procurement?method=responseTechnicalApproval&requisitionId='+obj.value,'testDiv');
		 }
	 else
		 {
		 document.getElementById('testDiv').innerHTML="";
		 }
}

<%-- if(<%=i%>>=1)
{
document.getElementById('checkbox1').checked=true;
vender(document.getElementById('checkbox1'));
} --%>

function validate(){
    var flag=false;
    var count=parseInt(document.getElementById("itemCount").value);
        for(var i=1;i<=count;i++){
        	if(document.getElementById("itemCheckbox"+i)!=null){
            if(document.getElementById("itemCheckbox"+i).checked==true){
                flag=true;
            }
        	}
        }
        for(var i=1;i<=count;i++){
        	if(document.getElementById("maintenanceCheckbox"+i)!=null){
            if(document.getElementById("maintenanceCheckbox"+i).checked==true){
                flag=true;
            }
        	}
        }
    if(flag){
        return true;
    }else{
        alert("Select Atleast one item for Approval");
        return false;
    }
    
}
</script>
<script type="text/javascript" language="javascript"
						charset="utf-8">
				
				function toggl() {
					 var count=parseInt(document.getElementById("itemCount").value);
				        for(var i=1;i<=count;i++){
				        	if(document.getElementById('selectCheckBox1').checked)
				        		{
				        		 document.getElementById('itemCheckbox'+i).checked=true;
				        		}
				        	else
				        		{
				        		 document.getElementById('itemCheckbox'+i).checked=false;

				        		}
				        }				        }
					
				</script>
   
