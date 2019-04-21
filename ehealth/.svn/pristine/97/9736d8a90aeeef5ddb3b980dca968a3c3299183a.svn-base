<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>



<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>


<script type="text/javascript">
	 var nameArray=new Array();
	 var codeArray=new Array();
	</script>


<script type="text/javascript" language="javascript">
	<%
		Map map = new HashMap();
		int pageNo=1;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
	
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currDate = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");
		String timeInHHmm="";
		String [] temp = null;
		temp = time.split(":");
		for (int i = 0 ; i < temp.length-1 ; i++) {
			
			timeInHHmm=timeInHHmm+(String)temp[i];
	    	 if(i==0)
	    	 {
	    		 timeInHHmm=timeInHHmm+":";
	    	 }
	    	 
		}
		
		
		
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
		String buttonFlag="";
		if(map.get("buttonFlag") != null)
		{
			buttonFlag=(String)map.get("buttonFlag");
			
			
		}
		if(map.get("pageNo") != null)
		{
			pageNo=(Integer)map.get("pageNo");
			
			
		}	
		int hinId=0;
		String hinNo="";
		if(map.get("hinId") != null)
		{
			
			hinId=(Integer)map.get("hinId");
			hinNo=(String)map.get("hinNo");
			
		}
		String issueNo="";
		if(map.get("issueNo") != null)
		{
			
			issueNo=(String)map.get("issueNo");
			
		}
		String prescription="";
		int consultantId=0;
		if(map.get("prescription") != null)
		{
			prescription=(String)map.get("prescription");
		}
		if(map.get("consultantId") != null)
		{
			consultantId=(Integer)map.get("consultantId");
		}
		
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>

<div class="titleBg">
<h2>OPD Patient Issue</h2>
</div>
<div class="clear"></div>
<form name="opdPatientIssue" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input
	type="hidden" name="pageNo" value="<%=pageNo %>" /> <input
	type="hidden" name="buttonFlag" value="<%=buttonFlag %>" /> <input
	type="hidden" name="issueNo" value="<%=issueNo %>" /> <input
	type="hidden" name="prescription" value="<%=prescription %>" /> <input
	type="hidden" name="consultantId" value="<%=consultantId %>" />
<div class="Block">
<%if(hinId != 0){ %> <label> HIN:</label> <input type="text"
	name="<%=HIN_NO%>" value="<%=hinNo %>" tabindex="1" MAXLENGTH="30"
	class="readOnly" readonly /> <input type="hidden" name="<%=HIN_ID%>"
	value="<%=hinId %>" /> <%}else{ %>
<div id="hinDiv"><label> Hin:</label> <input type="text"
	name="<%=HIN_ID%>" id="hinNo" value="" tabindex="1" MAXLENGTH="30"
	onblur="if(checkHinNo()){submitProtoAjax('opdPatientIssue','stores?method=showOPDPatientIssueGrid');}" />
</div>
<%} %> <label>Date(dd/mm/yyyy)</label> <input type="text" name="date"
	value="<%=currDate %>" class="readOnly" readonly /> <label>Time(HH:mm)</label>
<input type="text" name="time" value="<%=timeInHHmm %>" class="readOnly"
	readonly /> <input type="button" name="add" id="addbutton"
	value="Print" class="button"
	onClick="submitForm('opdPatientIssue','stores?method=generateOpdPatientIssueReport','checkTargetForYes');"
	accesskey="g" />
<div class="clear"></div>
</div>
</form>
<div id="testDiv"></div>




<script>
		<% if (hinId !=0 ) { %>
				//alert("calling ajax div grid");
				submitProtoAjax('opdPatientIssue','/hms/hms/stores?method=showOPDPatientIssueGrid');			
		<% } %>
		</script>

<script type="text/javascript"><!--
		
	function fillItemsInGrid(itemId,rowVal,deptId){
		
		
			document.getElementById('empId').value=document.getElementById('consultant').value;
			document.getElementById('prescription').value=document.getElementById('prescriptionNo').value;
			
		//	var lotNo=document.getElementById('lotNo'+rowVal)
		//	lotNo.disabled = true
		//	var combo=document.getElementById('nomenclature'+rowVal);
		//		combo.disabled=true
	}	
	
	function fillItemsInGridForLotNo(lotNo,rowVal,deptId,formName){
	
		
		
		//alert("Brand id=="+brandId)
		var bool="false";
		for(var i=0;i<nameArray.length;i++){
		
		
		if(nameArray[i][4]==lotNo){
			 bool="true";
			
			alert("nameArray[i][6]=="+nameArray[i][6])
			document.getElementById('pvmsNo'+rowVal).value=nameArray[i][1]
			document.getElementById('itemId'+rowVal).value=nameArray[i][2]
			//document.getElementById('nomenclature'+rowVal).value=nameArray[i][6]
			document.getElementById('noOfRecords').value=rowVal+1;
			document.getElementById('empId').value=document.getElementById('consultant').value;
			document.getElementById('prescription').value=document.getElementById('prescriptionNo').value;
			
		//	formname=formName.name
		//	var obj3 = eval('document.'+formname+'.lotNo'+rowVal);
		//	obj3.disabled = true
			
			var obj3=document.getElementById('lotNo'+rowVal);
			obj3.disabled = true
			
			var combo=document.getElementById('nomenclature'+rowVal);
				combo.disabled=true
			
			}
		}
		if(bool == "false")
		{
		  alert("Lot Number not matched")
		  return false
		}
		openPopupForLotNo(lotNo,rowVal,deptId);
		
		return true
}	


	
	
	function popwindow(url)
	{
		 newwindow=window.open(url,'name',"height=400,width=700,status=1");
    }
	function checkForNext(){
	  if(document.getElementById('noOfRecords').value<8)
	  {
	  	alert("All rows are not filled.Please Select the Nomenclature/LotNo to Enter ")
	  	return false;
	  }else{
	  return true;
	  }
  }
  
/*  function checkServiceNo(){
  
	  if(document.getElementById('serviceNo').value =="")
	  {
	  	alert("Please Enter the service Number ")
	  	document.opdPatientIssue.serviceNo.focus();
	  // var c=eval(document.opdPatientIssue.serviceNo);
	  // alert(c)
	  //	c.focus();
	  	return false;
	  }
	  return true;
	  }
*/
  
 function checkHinNo(){
  
	  if(document.getElementById('hinNo').value =="")
	  {
	  	alert("Please Enter the HIN Number ")
	   var c=eval(document.opdPatientIssue.serviceNo);
	   alert(c)
	  	c.focus();
	  	return false;
	  }
	  return true;
	  }
  
	function openPopupForDelete(OPDIssueNo){
		//alert("opdIssueNo:---"+OPDIssueNo)
		var url="/hms/hms/stores?method=showModifyOPDPatientIssueJsp&OPDIssueNo="+OPDIssueNo;
        popwindowForDelete(url);
     }
	function popwindowForDelete(url)
	{
		// newwindow=window.open(url,'name',"height=500,width=700,status=1, scrollbars=yes ");
		 
		 newwindow=window.open(url,'name','status=yes,resizable,scrollbars=1,height=400,width=980,');
		 
    }	
    function checkForNomenclature(val,inc,deptId){
	
		if(val != "")
		{
		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*8)+1;
    	var end=((pageNo-1)*8)+8;
    	
	    var index1 = val.lastIndexOf("[");
	    var indexForBrandName=index1;
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var itemId = val.substring(index1,index2);
	    var indexForBrandName=indexForBrandName--;
	    var nomenclature=val.substring(0,indexForBrandName);
	    
	     if(itemId =="")
	    {
	    
	     return;
	    }
	    for(i=1;i<inc;i++){
	    
	      if(inc != 1){
	        if(document.getElementById('nomenclature'+i).value==val)
	        {
	        //alert("document.getElementById('brandName'+i).value----:"+document.getElementById('brandName'+i).value+"----brand name from text box-----:"+val)
	    		alert("Item already selected...!")
	    		document.getElementById('nomenclature'+inc).value=""
	    	
	    	  return false;
	        }
	      }  
	   }
	   // alert("nomenclature---:"+nomenclature)	
		ajaxFunctionForAutoCompleteOPDPatient('opdPatient','stores?method=fillItemsInGridForOPD&itemId='+itemId , inc);
		document.getElementById('empId').value=document.getElementById('consultant').value;
		document.getElementById('prescription').value=document.getElementById('prescriptionNo').value;
		openPopup(itemId,deptId,inc);
		var nomenclature=document.getElementById('nomenclature'+inc)
			nomenclature.disabled = true
		var lotNo=document.getElementById('lotNo'+inc)
			lotNo.disabled = true
			
	  }
	}
    function openPopup(itemId,deptId,rowVal){
    	var serviceNo = document.getElementById('serviceNo').value;
		var url="/hms/hms/stores?method=showOPDStockDetailsJsp&itemId="+itemId+"&deptId="+deptId+"&rowVal="+rowVal+"&serviceNo="+serviceNo;
        popwindow(url);
     }
    
--></script>

