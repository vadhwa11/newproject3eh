<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.StoreTenderM"%>
<%@page import="jkt.hms.masters.business.StoreTenderInvitationLetter"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.util.Box"%>


<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
<script language="Javascript">
function showJasperReport()
{
var supplier_ids = "";
	if (document.InvitationTenderForm.<%=TENDER_LETTERS_TO_BE_SENT%>.length)
	{
			 for(var i = 0; i < document.InvitationTenderForm.<%=TENDER_LETTERS_TO_BE_SENT%>.length; i++)
			 {
			  if (document.InvitationTenderForm.<%=TENDER_LETTERS_TO_BE_SENT%>[i].disabled)
			  {
			  	  if (supplier_ids!="")
			  	  	supplier_ids = supplier_ids + "," + document.InvitationTenderForm.<%=TENDER_LETTERS_TO_BE_SENT%>[i].value;
			  	  else
			  	   	supplier_ids = supplier_ids + document.InvitationTenderForm.<%=TENDER_LETTERS_TO_BE_SENT%>[i].value;
			  }

			 }
	}
	else
	{
		if (document.InvitationTenderForm.<%=TENDER_LETTERS_TO_BE_SENT%>.disabled)
			supplier_ids = document.InvitationTenderForm.<%=TENDER_LETTERS_TO_BE_SENT%>.value;
	}

	if (supplier_ids!="")
	{
		if (checkFormFields())
		{
			document.InvitationTenderForm.method="post";
			submitForm('InvitationTenderForm','tender?method=showInvitationLetterReport&supplier_ids='+supplier_ids);

		}
		else
		{
			alert('Tender No & Tender Letter Should not be Empty!....');
		}
	}
	else
	{
	alert('Select Supplier and press Update!... and Go for Printing!.......');
	}

}
</script>
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
<%  int c=0;
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
	List<StoreTenderInvitationLetter> storeTenderInvitationLetterList = null;
	List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
	List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
	Vector supplier_ids = null;


	if (request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray)map.get("pagedArray");
		if (map.get("tender_letters_to_be_sent")!=null)
		supplier_ids = (Vector)map.get("tender_letters_to_be_sent");
		storeTenderInvitationLetterList = (ArrayList)map.get("storeTenderInvitationLetterList");
		masStoreGroupList = (ArrayList)map.get("masStoreGroupList");
		storeTenderMList =   (ArrayList)map.get("storeTenderMList");
  }

	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
%>
<script>
function openPopupWindow(flag)
{
if (flag=="Update" && document.InvitationTenderForm.<%=TENDER_LETTER_NO%>.value =="")
{
alert("Pl. select the Letter No. to be Updated!.........");
return;
}
var url="/hms/hms/tender?method=showDraftLetterJsp&<%=TENDER_LETTER_NO%>="+document.InvitationTenderForm.<%=TENDER_LETTER_NO%>.value + "&<%=TENDER_SUPPLIER_GROUP_ID%>=" + document.InvitationTenderForm.<%=TENDER_SUPPLIER_GROUP_ID%>.value + "&<%=TENDER_NO%>=" + document.InvitationTenderForm.<%=TENDER_NO%>.value  + "&flag="+flag;
newwindow=window.open(url,'name','top=50, left=50, height=600,width=800,status=1');
}


//this function will be called by the Bean (not from JSP)
function goPage(pidx) {
	document.InvitationTenderForm.currPage.value = pidx;
	document.InvitationTenderForm.method="post";
	submitForm('InvitationTenderForm','tender?method=showInvitationForTenderJspWithGridData');
}


function onChange()
	{
	if (document.InvitationTenderForm.<%=TENDER_SUPPLIER_GROUP_ID%>.value=="")
	{
	alert('Pl. Check Your Inputs (Group & Tender No)');
	document.InvitationTenderForm.<%=TENDER_NO %>.value =0;
	return;
	}
	document.InvitationTenderForm.method="post";
	//submitForm('InvitationTenderForm','tender?method=showInvitationForTenderJspWithGridData&currPage=1&groupId='+document.InvitationTenderForm.<%=TENDER_SUPPLIER_GROUP_ID%>.value);
	submitForm('InvitationTenderForm','tender?method=showInvitationForTenderJsp&currPage=1&groupId='+document.InvitationTenderForm.<%=TENDER_SUPPLIER_GROUP_ID%>.value);

}


function validateButton()
{
	if (document.InvitationTenderForm.<%=TENDER_LETTERS_TO_BE_SENT%>.length)
	{
			 for(var i = 0; i < document.InvitationTenderForm.<%=TENDER_LETTERS_TO_BE_SENT%>.length; i++)
			 {
			  if (document.InvitationTenderForm.<%=TENDER_LETTERS_TO_BE_SENT%>[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (document.InvitationTenderForm.<%=TENDER_LETTERS_TO_BE_SENT%>.checked == true)
			return true;
	}
	return false;
}


function checkFormFields()
{
	if (document.InvitationTenderForm.<%=TENDER_NO%>.value=="" || document.InvitationTenderForm.<%=TENDER_LETTER_NO%>.value=="")
		return false;
	else
		return true;
}


function printInvitationLetter()
{
	if (validateButton())
	{
		if (checkFormFields())
		{
			document.InvitationTenderForm.method="post";
		submitForm('InvitationTenderForm','tender?method=printInvitationLetter');
		//submitForm('InvitationTenderForm','tender?method=showInvitationLetterReport');
		}
		else
		{
			alert('Tender No & Tender Letter Should not be Empty!....');
		}
	}
	else
	{
	alert('No Item(s) Selected for Printing!....');
	}
}

function onChangeTender()
{
//document.InvitationTenderForm.<%=TENDER_SUPPLIER_GROUP_ID%>.options.length=1;
document.InvitationTenderForm.method="post";
submitForm('InvitationTenderForm','tender?method=showInvitationForTenderJspWithGridData&currPage=1&groupId='+document.InvitationTenderForm.<%=TENDER_SUPPLIER_GROUP_ID%>.value);
}
</script>
<div class="titleBg">
<h2>Invitation for Tender</h2>
</div>
<form name="InvitationTenderForm">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden"name="numOfRows" size="5" value="15">
<input type="hidden"	name="pageCount" size="5" value="10">
<input type="hidden"	name="hospitalId" size="5" value="<%=hospitalId%>">
<input	type="hidden" name="date" size="5" value="<%=date%>">
<div class="clear"></div>
<h4>Tender Invitation</h4>
<div class="clear"></div>
<div class="Block">
<label>Group</label>
<select	name="<%=TENDER_SUPPLIER_GROUP_ID %>" onChange="onChange();">
	<option value=0>--Select Group--</option>
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
</select>
<label>Tender No.</label>
<select name="<%=TENDER_NO%>" onChange="onChangeTender();">
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
</select>
<label>Letter No.</label>
<select name="<%=TENDER_LETTER_NO %>">
	<option value="">--Select Tender Letter--</option>
	<%
		for (Iterator iterator = storeTenderInvitationLetterList.iterator(); iterator.hasNext();)
		{
			StoreTenderInvitationLetter storeTenderInvitationLetter = (StoreTenderInvitationLetter)iterator.next();
		%>
	<option value="<%=storeTenderInvitationLetter.getId()%>"
		<%=HMSUtil.isSelected(storeTenderInvitationLetter.getId().toString(),box.getString(TENDER_LETTER_NO))%>><%=storeTenderInvitationLetter.getFileNo()%></option>
	<%
		}
		%>
</select>
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="Create" value="Draft New Letter"	class="buttonBig" onClick="openPopupWindow('Add');">
<input	type="button" name="Update" value="Update Letter" class="buttonBig"	onClick="openPopupWindow('Update');">
<div class="clear"></div>

<% String t = "false";
		if (pagedArray == null) {
		%>

<h4>Vendor/ Supplier Details</h4>
<div class="clear"></div>
<div class="cmntable">
<table width="100%" colspan="7" id="indentDetails" 	cellpadding="0" cellspacing="0" class="auto">
	<thead>
		<tr>
			<th width="5%">Sr No</th>
			<th width="5%"> <input type="radio" class="radioCheck"
				onclick="checkAll();" />Select</th>
			<th width="30%">Vendor Name</th>
   	        <th class="auto">Address</th>
		    <th width="20%">Contact No</th>
			<th width="auto">Letter Sent On</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=6 align="center">No Items Found</td>
		</tr>
	</tbody>
</table>
</div>

<%  } else { %>

<h4>Vendor/ Supplier Details</h4>
<div class="clear"></div>
<div class="cmntable">
<table width="100%" colspan="7" id="indentDetails" 	cellpadding="0" cellspacing="0" class="auto">
	<thead>
		<tr>
			<th width="5%">Sr No</th>
			<th width="10%"><input type="radio" id="selectBox"
				name="selectBox" class="radioCheck" onclick="checkAll();" />Select</th>
			<th width="30%">Vendor Name</th>
			<th class="auto" >Address</th>
			<th width="20%">Contact No</th>
			<th width="auto">Letter Sent On</th>
		</tr>
	</thead>
	<tbody>


		<%
			    gridData = (HashMap[])pagedArray.getPagedArray();
				int iFirstRow = pagedArray.getFirstRowIdx();

			    for(int i=0;i<gridData.length;i++)
			    {

			    String disable = "";
			    if (gridData[i].get(TENDER_VENDOR_INVITATION_STATUS)!=null && gridData[i].get(TENDER_VENDOR_INVITATION_STATUS).toString().length()>0){
			    	disable = "disabled";%>
		<input type="hidden" name="con" id="con" value="<%=disable%>">
		<%}else{
			     t= "true";
			 	 c++;
			    %>
		<input type="hidden" name="con" id="con" value="">
		<%}%>
		<tr>
			<td width="5%"><input type="text" value="<%=iFirstRow++%>"
				name="<%=TENDER_VENDOR_SRNO%>" readonly="readonly" size="3" /></td>
			<td width="5%" align="center"><input type="checkbox"
				id="tender_letters_to_be_sent<%=c%>"
				name=<%=TENDER_LETTERS_TO_BE_SENT%>
				value="<%=gridData[i].get(TENDER_VENDOR_SUPPLIER_ID)%>" <%=disable%>>
			</td>
			<td width="30%"><input type="text"
				value="<%=gridData[i].get(TENDER_VENDOR_NAME)%>"
				name="<%=TENDER_VENDOR_NAME%>" readonly="readonly" size="50" /></td>
			<td width="14%"><textarea name="<%=TENDER_VENDOR_ADDRESS%>"
				cols="50" rows="1" onpaste="return checkOnPaste(this)"
				oninput="return checkMaxLengthMoz(this)"
				onkeydown="return checkMaxLength(this)" 
				onkeyup="finalCheck(this)" readonly><%=gridData[i].get(TENDER_VENDOR_ADDRESS)==null?"":gridData[i].get(TENDER_VENDOR_ADDRESS)%></textarea></td>
			<td width="20%"><input type="text"
				value="<%=gridData[i].get(TENDER_VENDOR_CONTACT_NO)%>"
				name="<%=TENDER_VENDOR_CONTACT_NO%>" readonly="readonly" /></td>
			<td width="26%"><label><%=(gridData[i].get(TENDER_VENDOR_INVITATION_STATUS)==null)?"":gridData[i].get(TENDER_VENDOR_INVITATION_STATUS)%></label></td>
			<td><input type="hidden"
				value="<%=gridData[i].get(TENDER_VENDOR_SUPPLIER_ID)%>"
				name="<%=TENDER_VENDOR_SUPPLIER_ID%>" /></td>
		</tr>
		<% } %>
	</tbody>
</table>
</div>
</form>
<div class=""></div>
<!--<div id="pagination"><//%= pagedArray.showIndex()%> <//%= pagedArray.getPageIndexHiddenTag()%></div>
--><div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" id="countVal" value="<%=c%>" /> 
<input	type="hidden" id="chkStatus" value="no" /> 
<input type="button" name="send_invitation_letter" onClick="printInvitationLetter()" value="Update" class="button"> 
<input type="button" name="print_report" onClick="showJasperReport()" value="Print Report" class="buttonBig"> 
<%
String upload_filename="";
if(map.get("upload_filename")!=null){
	upload_filename=(String)map.get("upload_filename");
}
if(upload_filename!=""){
%>
<div class="clear"></div>
<label>View Document</label>
<a href="tender?method=viewTenderDocuments&filename=<%=upload_filename%>"><%=upload_filename%></a>
<%	
}
}
%>

<div class="clear"></div>
<div class="division"></div>
<div class="clear paddingtop40"></div>


<script>
function checkAll(){
 var check = document.getElementById('con').value;
 var temp = <%=t%>;
 if(temp)
 {
 if(document.getElementById("chkStatus").value =="no"){
   document.getElementById("chkStatus").value ="yes"
    for(var i=1;i<=document.getElementById("countVal").value;i++){
      document.getElementById("tender_letters_to_be_sent"+i).checked =true
    }
  } else{
   document.getElementById("chkStatus").value ="no"
     for(var i=1;i<=document.getElementById("countVal").value;i++){
      document.getElementById("tender_letters_to_be_sent"+i).checked =false
      }
  }
 }else{
 alert("All Vendor/Supplier are Invited");
 document.getElementById("selectBox").checked =false
 }
}

</script>
