<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.StoreTenderM"%>
<%@page import="jkt.hms.masters.business.StoreTenderInvitationLetter"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.util.Box"%>



<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascrip"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
</script>
<%
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	Box box = HMSUtil.getBox(request);
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}
 	
  	Map map = new HashMap();
  	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
	List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
	Vector supplier_ids = null;
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
		if (map.get("tender_letters_to_be_sent")!=null)
			supplier_ids = (Vector)map.get("tender_letters_to_be_sent");
		
		pagedArray = (PagedArray)map.get("pagedArray");
		masStoreGroupList = (ArrayList)map.get("masStoreGroupList");
		storeTenderMList =   (ArrayList)map.get("storeTenderMList");
  }
	
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
%>



<title>Tender Document</title>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="../style/pdb_style.css" rel="stylesheet" type="text/css" />
<script>

//this function will be called by the Bean (not from JSP)
   function onChange()
	{
	 if (TenderDocumentForm.<%=TENDER_NO%>.value=="")
	 {
	 alert("Please First select the Tender.");
	 TenderDocumentForm.<%=TENDER_SUPPLIER_GROUP_ID %>.value = "";
	 return; 
	 }
	 var tenderNo=document.getElementById('TenderNo').value;
	  TenderDocumentForm.method="post";
	  submitForm('TenderDocumentForm','tender?method=showDocumentForTenderJspWithGridData&jspName=PTI&currPage=1&tenderId='+tenderNo);
	}

 function onTenderChange()
	{
	 var tenderNo=document.getElementById('TenderNo').value;
	  TenderDocumentForm.method="post";
	  submitForm('TenderDocumentForm','tender?method=showTenderDocumentJsp&jspName=PTI&tenderId='+tenderNo);
	}

 function showJasperReport2()
{

	if (TenderDocumentForm.<%=TENDER_NO%>.value=="" || TenderDocumentForm.<%=TENDER_SUPPLIER_GROUP_ID %>.value=="")
	{
	alert('Pl. Check Your Inputs (Tender No & Group)');
	return false;
	}

	var supplier_ids = "";
	if (TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>.length)
	{
			 for(var i = 0; i < TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>.length; i++)
			 {
			  if (TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>[i].disabled)
			  {
			  	  if (supplier_ids!="")  
			  	  	supplier_ids = supplier_ids + "," + TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>[i].value; 
			  	  else
			  	   	supplier_ids = supplier_ids + TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>[i].value;
			  }
			    
			 }
	}
	else
	{
		if (TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>.disabled)
			supplier_ids = TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>.value;
	}
	
	if (supplier_ids!="")
	{
	TenderDocumentForm.method="post";
	submitForm('TenderDocumentForm','tender?method=printTenderDocumentReportDrugSchedule&supplier_ids='+supplier_ids);
	}
	else
	{
	alert('Select Supplier and press Update!... and Go for Printing!.......');
	}
	
}

</script>

<body>
<form name="TenderDocumentForm"><input type="hidden"
	name="numOfRows" size="5" value="15"> <input type="hidden"
	name="pageCount" size="5" value="10"> <input type="hidden"
	name="hospitalId" size="5" value="<%=hospitalId%>"> <input
	type="hidden" name="date" size="5" value="<%=date%>"> <br />
<div id="contentspace">
<div style="float: left;">
<h2 align="left" class="style1">Previous Tender Items</h2>
</div>
<br />


<div style="padding-left: 15px;"><br />
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Tender Document</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 975px; height: 83px; background-color: #f4f9fe;">
<br />

<label class="bodytextB_blue">Tender No</label> <select
	name="<%=TENDER_NO%>" id='TenderNo' onChange="onTenderChange();">
	<option value="">--Select Tender No--</option>
	<%
		for (Iterator iterator = storeTenderMList.iterator(); iterator.hasNext();) 
		{
			StoreTenderM storeTenderM = (StoreTenderM)iterator.next();
		%>
	<option value="<%=storeTenderM.getId()%>"
		<%=HMSUtil.isSelected(storeTenderM.getId(),Integer.valueOf(box.getInt(TENDER_NO)))%>><%=storeTenderM.getTenderNo()%></option>
	<%
		}
		%>
</select> <label class="bodytextB_blue">Group</label> <select
	name="<%=TENDER_SUPPLIER_GROUP_ID %>" onChange="onChange();"
	id="groupId">
	<option value="">--Select Group--</option>
	<%
		for (Iterator iterator = masStoreGroupList.iterator(); iterator.hasNext();) 
		{
			MasStoreGroup masStoreGroup = (MasStoreGroup)iterator.next();
		%>
	<option value="<%=masStoreGroup.getId()%>"
		<%=HMSUtil.isSelected(masStoreGroup.getId(),Integer.valueOf(box.getInt(TENDER_SUPPLIER_GROUP_ID)))%>><%=masStoreGroup.getGroupName()%></option>
	<%
		}
		%>
</select></div>
<br />

<%
	 	if (pagedArray == null) {
		  } else { %> <%
			    gridData = (HashMap[])pagedArray.getPagedArray();
				int iFirstRow = pagedArray.getFirstRowIdx();
			    for(int i=0;i<gridData.length;i++)
			    {
			    String disable = "";
			    if (gridData[i].get(TENDER_VENDOR_DOCUMENT_STATUS)!=null && gridData[i].get(TENDER_VENDOR_DOCUMENT_STATUS).toString().length()>0)
			    	disable = "disabled";
			    %> <input type="hidden" name=<%=TENDER_LETTERS_TO_BE_SENT%>
	value="<%=gridData[i].get(TENDER_VENDOR_SUPPLIER_ID)%>" <%=disable%>>
<% } %>
</div>

<br />
<input type="button" name="print_report2" onClick="showJasperReport2()"
	value="Drugs Schedule" class="button"> <%}%>
</div>	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</body>
