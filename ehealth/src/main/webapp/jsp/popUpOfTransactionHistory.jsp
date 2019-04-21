<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.

 * Purpose of the JSP -  
 * @author  Vinay
 * Create Date: 16 May,2014 
 * Revision Date:      
 * Revision By: 
 * @version 1.14
--%>

<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Cache-control", "no-store");
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0);

%>


<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>



<%@ page import="java.net.URL"%>



<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css?n=1" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/datePicker.css?n=1" />

 

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/lightbox-form.css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/lightbox-form.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js?n=1"></script>

<%


    String Print = "N";
    if(request.getParameter("Print") != null)
    {
    	Print = request.getParameter("Print");
    }
	int locationId = 0;
	if (request.getParameter("locationId") != null) {
		locationId =  Integer.parseInt(request.getParameter("locationId"));
	}


    String pageTitle = "";
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
			
	List<Object[]> seedCategoryList = new ArrayList<Object[]>();
	List<Object[]> financialYearList = new ArrayList<Object[]>();	
	
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	
	
	int userId = 0;
	if(session.getAttribute("userId") != null){
		userId = (Integer)session.getAttribute("userId");
	}
	//out.print("User="+userId);
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	 
	 boolean bSuccessfullyAdded = false;
	 String message = "";
	 //String AUStockId = "";
	 
	 if(map.get("bSuccessfullyAdded") != null)
	 {
		 bSuccessfullyAdded =  (Boolean)map.get("bSuccessfullyAdded");
	 }
	 if(map.get("title") != null)
	 {
		 pageTitle =  (String)map.get("title");	  
		   
	  }	 
	 
	 if(map.get("message") != null)
	 {
		 message =  (String)map.get("message");	  
		   
	  }		
	
	 if(map.get("seedCategoryList") != null)
	 {
		 seedCategoryList =  (List<Object[]>)map.get("seedCategoryList");	  
		   
	  }	
	 if(map.get("financialYearList") != null)
	 {
		 financialYearList =  (List<Object[]>)map.get("financialYearList");	  
		   
	  }		 
	 
	  if(bSuccessfullyAdded)
	 {
			out.println("<h4 id='divResult' class='success'>"+message+"</h4>");
	 }
	 else
	 {
		 out.println("<h4 id='divResult' class='failure'>"+message+"</h4>");
	 } 
	}
	
	
	
	
	
	int departmentId = 0;
	if (session.getAttribute("departmentId") != null) {
		departmentId =  (Integer)session.getAttribute("departmentId");
	}
	
	int Id = 0;
	String TransactionType = "";
	
	if(request.getParameter("Id") != null)
	{
		Id  = Integer.parseInt(request.getParameter("Id"));
	}
	
	if(request.getParameter("TransactionType") != null)
	{
		TransactionType  = request.getParameter("TransactionType");
	}
			
			
	
	
	
	
	
	
	
%>
<html>
<head>
<title>Transaction History </title>
</head>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>
<script language="javascript">


var $j = jQuery.noConflict();
</script>

<form name="TransactionHistory" id="frmTransactionHistory" method="post" action="" autocomplete="off">

<div class="page_title">Transaction Details 
</div>

<div class="Block">
<label>From:<span>*</span></label>
<input name="textfield3" type="text" validate="From date,string,yes" class="small" id="fromdate-pick" placeholder="DD/MM/YYYY" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'fromdate-pick');" maxlength='10' onchange="GetKSDAReqisitionList('FILTER');" />

<label>To:<span>*</span> </label>
<input name="textfield2" type="text" validate="To date,string,yes"  class="small" id="todate-pick" placeholder="DD/MM/YYYY" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'todate-pick');" maxlength='10' onchange="GetKSDAReqisitionList('FILTER');" />

<input type="button" name="reset" id="resetbutton" value="Show all" class="button" onClick="ShowAllList('1');" accesskey="r" tabindex=1 />
<%
 if(Print.equalsIgnoreCase("Y"))
 {
	 %>
	 	<input type="button" name="reset" id="printbutton" value="Print" class="button" onClick="printGrowerLedgerAccount();" accesskey="r" tabindex=1 />
	 <%
 }
%>
 
  <div class="clear" ></div>
  
  
 <div class="clear" style="padding-top: 30px;"></div>
 <div id="divTransactionDetails">


<table class="appContentContainer" align="center" cellspacing="0" cellpadding="0" borde="0">
	
	<tr><td>
		<table class="tblSearchActions" cellspacing="0" cellpadding="0" border="0" >
			<tr>
				<td class="SearchStatus" style="font-size: 13px;" width: 400px; align="left">Search Results</td>
				<td>
				<div id=resultnavigation></div>
				
				</td>
				
				
				
			</tr>
		</table>
	</td></tr>	
	<tr><td>
  <table id="tblSearchResultsHeader" class="tblSearchResultsHeader" cellspacing="0" cellpadding="0" border="0">
			<tr>
				
				<th style="width:80px;">Date</th>
				<th style="width:150px;">Name</th>
				<th style="width:100px;">Dr Amount</th>
				<th style="width:100px;">Cr Amount</th>
				<!-- <th>Transaction Type</th> -->
				<th style="width:200px;">Narration</th>
				<th style="width:100px;">Transaction By</th>
				
			</tr>
			
</table>
</td></tr>
		
<tr><td>
		<table id="tblListOfHistoryOfTransaction" class="tblSearchResults" cellspacing="0" cellpadding="0" border="0">
			<tr>
				<td colspan="6"><img src="/hms/jsp/images/dot.gif" width="1" height="200"/></td>
			</tr>
			
		</table>
</td></tr>	


          
        
</table>
</div>
</div>
<div class="clear" style="padding-top: 30px;"></div>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</html>
<script language="javascript">

var nPageNo=1;
$j(document).ready(function(){
	
	GetHistoryOfTransaction('ALL');
	
});


function GetHistoryOfTransaction(MODE)
{
	var TransactionType = '<% out.print(TransactionType);%>';
	var Id = <% out.print(Id);%>;
	var locationId = <%out.print(locationId);%>;

	if(MODE == 'ALL')
		{
			var data = "PN="+nPageNo+"&TransactionType="+TransactionType+"&Id="+Id+"&locationId="+locationId;
		}
	else
		{
		var data = "PN="+nPageNo+"&TransactionType="+TransactionType+"&Id="+Id+"&locationId="+locationId;
		}
	var url = "account?method=getTransactionHistory";
	var bClickable = false;
	GetJsonData('tblListOfHistoryOfTransaction',data,url,bClickable);
}



function makeTable(jsonData)
{
	var htmlTable = "<table id='tblListOfHistoryOfTransaction' class='tblSearchResults' cellspacing='0' cellpadding='0' border='0'>";
	for(i=0;i<jsonData.length;i++)
		{			
			
			htmlTable = htmlTable+"<tr id='"+jsonData[i].Id+"'>";
			htmlTable = htmlTable +"<td style=\"width:80px;\">"+jsonData[i].Date+"</td>";
			htmlTable = htmlTable +"<td style=\"width:150px;\">"+jsonData[i].Name+"</td>";
			htmlTable = htmlTable +"<td style=\"width:100px;\">"+jsonData[i].DrAmount+"</td>";
			htmlTable = htmlTable +"<td style=\"width:100px;\">"+jsonData[i].CrAmount+"</td>";
			/* htmlTable = htmlTable +"<td>"+jsonData[i].VoucherType+"</td>"; */
			htmlTable = htmlTable +"<td style=\"width:200px;\">"+jsonData[i].Narration+"</td>";
			htmlTable = htmlTable +"<td style=\"width:100px;\">"+jsonData[i].LastChgBy+"</td>";
			
			htmlTable = htmlTable+"</tr>";
		}
	if(jsonData.length == 0)
		{
		   htmlTable = htmlTable+"<tr><td colspan='6'><img src='/hms/jsp/images/dot.gif' width='1' height='200'/></td></tr>";
		}
		htmlTable = htmlTable +"</table>";		
	
	$j("#tblListOfHistoryOfTransaction").parent().html(htmlTable);	
	
	
}

function executeClickEvent(Id)
{
	//ViewUpdateCentreBudget(Id);
}

function showResultPage(pageNo)
{
	nPageNo = pageNo;	
	GetHistoryOfTransaction('FILTER');	
}

function ShowAllList(pageNo)
{
	
	nPageNo = pageNo;		
	GetHistoryOfTransaction('ALL');
}

function printGrowerLedgerAccount()
{
	
	var locationId = <% out.print(locationId);%>;
	var Id = <% out.print(Id);%>;
	
	obj = eval('document.TransactionHistory');
	obj.action ="account?method=printGrowerLedgerAccount&locationId="+locationId+"&Id="+Id;
	obj.submit();
}

</script>