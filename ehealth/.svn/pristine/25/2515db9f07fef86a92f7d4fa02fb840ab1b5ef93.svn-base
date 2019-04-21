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



<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css"/>
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
	List<PrqQuotationHeader> hdrList=new ArrayList<PrqQuotationHeader>();
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
		hdrList=(List<PrqQuotationHeader>)map.get("hdrList");
	}
	%>

<form name="priceNegotiation" method="post" action="">

<div class="titleBg">
<h2>Price Negotiation Process</h2>
</div>
<div class="Block">
<label>Quotation No.<span>*</span></label>
<select	name="quotationNo"  id="quotationNo" validate="quotationNo,String,yes" tabindex=1 onchange="displayVendor(this.value)"  >
	<option value="">Select</option>
	 <%for(PrqQuotationHeader prqHdr1:hdrList){
    	
    	%>
	 <option value="<%=prqHdr1.getId()%>"><%=prqHdr1.getQuotationNo()%></option>
	 <%} %>
	 
</select>
</div>
<div class="Block">
<div id="vendorName">
</div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

<script type="text/javascript">
function displayVendor(obj){
	 if(obj!="")
	 {  
		 submitProtoAjaxWithDivName('priceNegotiation','/hms/hms/procurement?method=vendorListNegotiation&quotationRequisitionNo='+obj,'vendorName');
		 
	 }
}
function itemDisplay(obj,index)
{
	var venderCount=document.getElementById('vendorCount').value;
	 for(var i=1;i<=venderCount&&i<index;i++)
	 {
	 if(!document.getElementById('rejectCheckbox'+i).checked)
		 {
		 alert('please reject first one');
		 document.getElementById('approveCheckbox'+index).checked=false;
		 return;
		 }
	 } 
	 var selected=0;
	 for(var i=1;i<=venderCount;i++)
		 {
		 if(document.getElementById('approveCheckbox'+i).checked)
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
	
		 submitProtoAjaxWithDivName('priceNegotiation','/hms/hms/procurement?method=getItemListForNegotiation&requisitionId='+obj.value,'itemName');
		 }
	 else
		 {
		 document.getElementById('itemName').innerHTML="";
		 }
}

function onApproveSelection(obj,index)
{
	
		if(obj.checked)
		{
			document.getElementById('rejectCheckbox'+index).checked=false;
		}
}

function onDisapproveSelection(obj,index)
{
	
		if(obj.checked)
		{
			document.getElementById('approveCheckbox'+index).checked=false;
		}
}


/* function totalAm(count){
  	 var newRate=0;
  	 var totalAmmount=0;
  	 var appqty=0;
  	 var newAmount=0;
  	 var newDis=0;
  	  var newNetAmt=0;
  	  var ratePerQty=0;
  	  var ratePerUnit=0;
  	  var newQty=0;
  	  if(isNaN(document.getElementById("appqty"+count).value))
  	  {
  	  alert('This is not valid Quantity');
  	  return;
  	  }
  	   appqty =document.getElementById('appqty'+count).value;
  	  if(isNaN(document.getElementById("newRate"+count).value))
  		  {
  		  alert('Please Enter valid Rate');
  		  return;
  		  }
  	  
  	     newRate=document.getElementById('newRate'+count).value;
  		if(isNaN(document.getElementById("newQty"+count).value))
  		  {
  		  alert('Please Enter valid Quantity');
  		  return;
  		  }
  		newQty=document.getElementById('newQty'+count).value;
  		if(newQty!='' && newQty!=0 && newRate !='' && newRate!=0)
  			ratePerUnit = eval(eval(Number(newRate)) / eval(Number(newQty)));
  		newAmount = eval(Number(eval(Number(appqty))* (eval(Number(ratePerUnit)))));
  		newAmount = parseFloat(newAmount).toFixed(2);
  		document.getElementById('newAmount'+count).value = newAmount;

  	
   	if(isNaN(document.getElementById("newDis"+count).value))
  	  {
  	  alert('Please Enter valid Discount');
  	  return;
  	  }
  	
      
       if(document.getElementById("newDis"+count).value!=null && document.getElementById("newDis"+count).value!=""){
       	newDis=parseInt(document.getElementById("newDis"+count).value);
   	}
      
       document.getElementById("newNetAmt"+count).value=newAmount-((newAmount*newDis)/100);
       newNetAmt=newAmount-((newAmount*newDis)/100);
       newNetAmt = parseFloat(newNetAmt).toFixed(2);
    	
    	}
    	  	 */
    function total(){
    	var itemCount=document.getElementById("itemCount").value;
    	var newNetAm=0;
    	var newDiscount=0;
    	var newNetAmt=0;
    	var newTotalAmt=0;
    	for(var i=1;i<=itemCount;i++)
    		{
    		var ln= document.getElementById("newAmount"+i).value;
    		if(ln!=null && ln!="" && parseFloat(ln.value)!="NaN")
        		newNetAm+=parseFloat(ln);
    		
    		var dis=document.getElementById("newDis"+i).value;
    		if(dis!=null && dis!="" && parseFloat(dis.value)!="NaN")
    			newDiscount+=parseFloat(dis);
    		
    		var totAm=document.getElementById("newNetAmt"+i).value;
    		if(totAm!=null && totAm!="" && parseFloat(totAm.value)!="NaN")
    			newNetAmt+=parseFloat(totAm);
    		
    		var totAmt=document.getElementById("newTotalAmt"+i).value;
    		if(totAmt!=null && totAmt!="" && parseFloat(totAmt.value)!="NaN")
    			newTotalAmt+=parseFloat(totAmt);
    		
    		}
    	document.getElementById("totConsiAmount").value=newNetAm;
       document.getElementById("consiDiscount").value=newDiscount/itemCount;
    	
    	document.getElementById("consiDiscountAmt").value=newNetAmt;
    	document.getElementById("consiTotalAmt").value=newTotalAmt;
    }
    function totalAm(count){
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
   	  if(isNaN(document.getElementById("appqty"+count).value))
   	  {
   	  alert('This is not valid Quantity');
   	  return;
   	  }
   	  quotationQty=document.getElementById('appqty'+count).value;
   	  if(isNaN(document.getElementById("newRate"+count).value))
   		  {
   		  alert('Please Enter valid Rate');
   		  return;
   		  }
   	  
   		rate=document.getElementById('newRate'+count).value;
   		/* if(isNaN(document.getElementById("newQty"+count).value))
   		  {
   		  alert('Please Enter valid Quantity');
   		  return;
   		  }
   		qty=document.getElementById('newQty'+count).value; */
   		/* if(qty!='' && qty!=0 && rate !='' && rate!=0)
   			ratePerUnit = eval(eval(Number(rate)) / eval(Number(qty))); */
   		ammount = eval(Number(eval(Number(quotationQty))* (eval(Number(rate)))));
   		ammount = parseFloat(ammount).toFixed(2);
   		document.getElementById('newAmount'+count).value = ammount;
   	
   	
      	if(isNaN(document.getElementById("newDis"+count).value))
   	    {
   	    alert('Please Enter valid Discount');
   	    return;
   	    }
   	
       
        if(document.getElementById("newDis"+count).value!=null && document.getElementById("newDis"+count).value!=""){
       	 dicount=parseInt(document.getElementById("newDis"+count).value);
    	}
       
        document.getElementById("newNetAmt"+count).value=ammount-((ammount*dicount)/100);
        netAmount=ammount-((ammount*dicount)/100);
        netAmount = parseFloat(netAmount).toFixed(2);
       
        exciseOption = document.getElementById('exciseOption'+count).value;
       if(exciseOption=='Percentage')
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
     
      
     tax = document.getElementById('newTax'+count).value;
     if(tax != null)
     {
     	var taxTotalAmount = (totalAmmount*tax)/100;
     	totalAmmount =parseFloat(totalAmmount)+parseFloat(taxTotalAmount);
     	totalAmmount = parseFloat(totalAmmount).toFixed(2);
     }
     

     vat = document.getElementById('newVat'+count).value;
     if(vat != null)
     {
     	var vatTotalAmount = (totalAmmount*vat)/100;
     	totalAmmount =parseFloat(totalAmmount)+parseFloat(vatTotalAmount);
     	totalAmmount = parseFloat(totalAmmount);
     }

     totalAmmount = parseFloat(totalAmmount).toFixed(2);
     	document.getElementById('newTotalAmt'+count).value = totalAmmount;
     	
     	}
     	
</script>
