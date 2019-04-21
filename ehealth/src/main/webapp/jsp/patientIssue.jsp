
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants,java.math.BigDecimal"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>

<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%>
<%@page import="jkt.hms.masters.business.BlDispensingDetails"%>
<%@page import="jkt.hms.masters.business.MasStoreItemConversion"%><script
	type="text/javascript" src="/hms/jsp/js/autocomplete.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/actb.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script> 
<script type="text/javascript"> 
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
vBulletin_init();
// -->
var nameArray=new Array();
var codeArray=new Array();
</script>

<%

	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);

	int pageNo=1;
	String buttonFlag="";
	Map map = new HashMap();

	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}
	if(map.get("buttonFlag") != null)
	{
	buttonFlag=(String)map.get("buttonFlag");
	}
	if(map.get("pageNo") != null)
	{
	pageNo=(Integer)map.get("pageNo");
	}
	String deptName="";
	if (map.get("deptName") != null) {
	deptName = (String) map.get("deptName");
	}

	int deptId = (Integer)map.get("deptId");
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date=(String)utilMap.get("currentDate");
	String time=(String)utilMap.get("currentTime");
	String timeInHHmm="";
	String [] tempArr = null;
	tempArr = time.split(":");
	for (int i = 0 ; i < tempArr.length-1 ; i++) {

	timeInHHmm=timeInHHmm+(String)tempArr[i];
	if(i==0)
	{
	timeInHHmm=timeInHHmm+":";
	}
	 }
 	List inPatientDetailList = new ArrayList();
 	if (map.get("inPatientDetailList") != null) {
	  inPatientDetailList = (List)map.get("inPatientDetailList");
 	}
	List<BlDispensingDetails> blDispensingDetailsList = new ArrayList<BlDispensingDetails>();
	if(map.get("blDispensingDetailsList")!=null){}
	{
		blDispensingDetailsList = (List<BlDispensingDetails>)map.get("blDispensingDetailsList");
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
	}
	%>

<form name="patientIssue" method="post">
<%
	String admissionNumber=null;
	int hinId=0;
	int hinNo=0;
	int inpatientId=0;
	if(inPatientDetailList != null)
	{
	String patientName= "";
	String consultantName="";
	String serviceNo="";
	String maritialStatus="";
	String unitName="";
	String rankName="";
	String sex="";
	String diagnosis="";
	String initDiagnosis="";
	Inpatient inPatientDetail=(Inpatient)inPatientDetailList.get(0);
	hinId=inPatientDetail.getHin().getId();
	hinNo = Integer.parseInt(inPatientDetail.getHinNo());
	inpatientId=inPatientDetail.getId();
	MasIcd masIcd=(MasIcd)inPatientDetail.getDiagnosis();
	if(inPatientDetail.getInitDiagnosis() !=null)
	initDiagnosis =inPatientDetail.getInitDiagnosis();
	if(inPatientDetail.getHin().getPFirstName() != null)
	{
	patientName=inPatientDetail.getHin().getPFirstName();
	}
	if(inPatientDetail.getHin().getPMiddleName() != null)
	{
	patientName +=inPatientDetail.getHin().getPMiddleName();
	}
	if(inPatientDetail.getHin().getPLastName() != null)
	{
	patientName +=inPatientDetail.getHin().getPLastName();
	}
	if(inPatientDetail.getDoctor().getFirstName()!= null)
	{
	consultantName=inPatientDetail.getDoctor().getFirstName();
	}
	if(inPatientDetail.getDoctor().getMiddleName() != null)
	{
	consultantName+=inPatientDetail.getDoctor().getMiddleName();
	}
	if(inPatientDetail.getDoctor().getLastName() != null)
	{
	consultantName+= inPatientDetail.getDoctor().getLastName();
	}

	if(inPatientDetail.getHin().getServiceNo() != null && inPatientDetail.getHin().getServiceNo() != "")
	{
	serviceNo= inPatientDetail.getHin().getServiceNo();
	}
	else
	{
	serviceNo="-";
	}
	if(inPatientDetail.getDiagnosis() != null)
	{
	diagnosis=masIcd.getIcdName();
	}else{
	diagnosis="-";
	}


	if(inPatientDetail.getHin().getMaritalStatus() != null)
	{
	maritialStatus = inPatientDetail.getHin().getMaritalStatus().getMaritalStatusName();

	}
	if(inPatientDetail.getAdNo() != null)
	{
	admissionNumber=inPatientDetail.getAdNo();
	}else{
	admissionNumber="-";
	}

	if(inPatientDetail.getHin().getSex()!= null)
	{
	sex=inPatientDetail.getHin().getSex().getAdministrativeSexName();
	}else{
	sex="-";
	}
	%>
<div class="titleBg">
<h2>Patient Issue</h2>
</div>
<div class="clear"></div>
<h4><%=deptName%></h4>
<div class="clear"></div>

<div class="paddingTop15"></div>
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>

<div class="Block"><label class="auto"><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<label class="valueAuto"> <%=hinNo%></label> <label class="auto">Patient
Name</label> <label class="valueAuto"> <%= patientName %></label> <label
	class="medium"><%=prop.getProperty("com.jkt.hms.opd_no")%></label> <label
	class="valueAuto"> <%=admissionNumber %></label> <label class="medium">Ward
Name</label> <%if(inPatientDetail.getDepartment().getDepartmentName() != null){%>
<label class="valueAuto"> <%=inPatientDetail.getDepartment().getDepartmentName() %></label>
<%}else{ %> <label class="valueAuto">-</label> <%} %> <label class="medium">Age</label>
<%if(inPatientDetail.getAge() != null){ %> <label class="valueAuto">
<%=inPatientDetail.getAge() %></label> <%}else{ %> <label class="valueAuto">-</label>
<%} %> <label class="medium">Sex</label> <label class="valueAuto">
<%=sex%></label> <label class="medium">Consultant</label> <label
	class="valueAuto"><%=consultantName %></label>
<div class="clear"></div>
<label class="medium">Diagnosis</label> <label class="valueAuto"><%=diagnosis%></label>
<div class="clear"></div>
<label class="auto">Init. Diagnosis</label> <label class="valueAuto"><%=initDiagnosis%></label>
<%}%>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div id="testDiv" class="Block"><input type="hidden" name="pageNo"
	id="pageNo" value="<%=pageNo%>" /> <%
	List ipIssueNo=(List)map.get("ipIssueNo");
	StoreFyDocumentNo storeFyDocumentNo= (StoreFyDocumentNo)ipIssueNo.get(0);
	int issueNoOfPatient=0;
	if(map.get("issueNoOfPatient")!=null){
	issueNoOfPatient=(Integer)map.get("issueNoOfPatient");
	}
	%> <label class="auto">IPD Issue No. </label> <label class="valueAuto"><%= issueNoOfPatient%></label>
<input type="hidden" id="storeFyDocumentId"
	value="<%= storeFyDocumentNo.getId()%>" /> <input type="hidden"
	id="hinId" value="<%= hinId%>" /> <input type="hidden"
	id="admissionNumber" value="<%= admissionNumber%>" /> <input
	type="hidden" id="ipissueno" value="<%=issueNoOfPatient%>" /> <input
	type="hidden" name="date" id="date" value="<%=date %>" /> <input
	type="hidden" name="time" id="time" value="<%=timeInHHmm %>" /> <input
	type="hidden" name="fromDateToDate" id="fromDateToDate" value="" /> <label
	class="">&nbsp;</label> <label class="auto">Issue Date</label> <label
	class="valueAuto"><%= date%></label> <label class="">&nbsp;</label> <label
	class="auto">Time</label> <label class="valueAuto"><%= timeInHHmm%></label>
<label class="">&nbsp;</label> <!-- <label class="auto">Page No.</label> <label
	class="valueAuto">pageNo</label>
	 -->
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" /> <!-- <input type="hidden" name="<%=RequestConstants.STORE_ITEM_BATCH_STOCK_ID %>" value="" id="hdb" /> -->
<input type="hidden" value="<%= deptId%>" name="deptId" id="deptId" />

<div class="paddingTop15"></div>
<!-- if(checkForNext()){submitForm('wardConsumption','ipd?method=showWardConsumptionJsp&buttonFlag=next');} -->
 <%
  if(blDispensingDetailsList.size()>0){
 %>
 <table id="stockDetails" class="scrollTable" border="1">
 					<tr>
						<th>S.No.</th>
						<th>Issue Date</th>
						<th>Item Name</th>
						<th>A/U</th>
						<th>Total Quantity Issued</th>
						<th>Remarks</th>
					</tr>
 					<%
		int detailCounter=8;
		int temp=0;
 		if(pageNo!=1)
		{
			temp=detailCounter*(pageNo-1);
		}
 		int inc=0;
	for(BlDispensingDetails bldetails :blDispensingDetailsList)
	{
			MasStoreItem item = new MasStoreItem();
			item = (MasStoreItem)bldetails.getItem();
			MasStoreItemConversion conversion = new MasStoreItemConversion();
			conversion  = (MasStoreItemConversion)item.getItemConversion();
 %>
					<tr>
						<td width="5%"><input type="text" size="2"
							value="<%=temp+inc%>" class="smcaption"
							name="<%=RequestConstants.SR_NO%>" readonly="readonly" /></td>
						<td width="15%"><input type="text" class="medcaption"
							name="pvmsNo<%=inc%>" id="pvmsNo<%=inc%>" readonly="readonly"
							value="<%=bldetails.getDispensingHeader().getBillDate()%>" /></td>
						<td width="19%"><input type="text"
							value="<%=item.getNomenclature()%>" id="nomenclature<%=inc%>"
							class="medcaption" name="<%=RequestConstants.NOMENCLATURE%>"  readonly="readonly"/></td>
						<td width="46%"><input type="text"
							value="<%=conversion.getItemUnitName()%>" class="medcaption"
							name="<%=RequestConstants.UNIT_NAME%>" id="unitName<%=inc%>"
							readonly="readonly" /></td>
 						<td width="46%"><input type="text"
							value="<%=bldetails.getQty()%>" class="medcaption"
							name="<%=RequestConstants.QTY_ISSUED%>" id="qtyIssued<%=inc%>"
							readonly="readonly" /></td>
						<td width="15%"><input type="text" class="medcaption"
							name="remarks<%=inc%>" id="remarks<%=inc%>" value=""
							maxlength="50" readonly="readonly" /></td>
					</tr>
					<%
					inc++;
						} %>
 			</table>
 		<%}%>
 <div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" value="Back"
	align="left"
	onClick="submitForm('patientIssue','ipd?method=showPatientListJsp');" />
<!-- <input type="button" class="button" value="View" align="right"
	onClick="openPopupForView('admissionNumber%>');" />
 -->
<input
	type="hidden" name="rows" id="rr" value="1" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	
<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="clear"></div>
<script type="text/javascript">
	function validatePage(formName) {

	var counter=document.getElementById('counter').value;
	formname=formName.name
	for(var i = 0; i < counter; i++)
	{
	amountVal = eval('document.'+formname+'.amount' + i + '.value')
	issQtyVal=eval('document.'+formname+'.issueQty' + i + '.value')
	if(amountVal =="" && issQtyVal != "")
	{
	alert("Please Enter the correct value in Issued Quantity")
	return false
	}
	if(amountVal !="" && issQtyVal == "")
	{
	alert("Please Enter the Issued Quantity")
	return false
	}
	}
	return true
	}

	function fillSrNo(rowVal){

	var pageNo=parseInt(document.getElementById('noOfRecords').value);
	rowVal=rowVal%8
	if(rowVal==0){
	rowVal=8
	}
	if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
	document.getElementById('noOfRecords').value=rowVal
	}
	return true;
	}

	function checkForBrand(val,inc,deptId,deptName){

	if(val != "")
	{
	var pageNo =parseInt(document.getElementById('pageNo').value)
	var start=((pageNo-1)*8)+1;
	var end=((pageNo-1)*8)+8;

	var index1 = val.lastIndexOf("[");
	var indexForBrandName=index1;
	var index2 = val.lastIndexOf("]");
	index1++;
	var pvmsNo = val.substring(index1,index2);
	var indexForBrandName=indexForBrandName--;
	var brandName=val.substring(0,indexForBrandName);

	if(pvmsNo =="")
	{
	return;
	}
	}
	for(i=1;i<inc;i++){

	if(inc != 1){
	if(document.getElementById('pvmsNo'+i).value==pvmsNo)
	{
	alert("Item already selected...!")
	document.getElementById('brandName'+inc).value=""
	var e=eval(document.getElementById('pvmsNo'+inc));
	e.focus();
	return false;
	}
	}
	}
	ajaxFunctionForAutoCompletePatientIssue('patientIssue','ipd?method=fillItemsInGrid&pvmsNo='+pvmsNo,inc);
 	}
	function popwindow(url)
	{
	newwindow=window.open(url,'name',"height=500,width=900,status=1");
	}
	function checkForNext(){
	if(document.getElementById('noOfRecords').value<8)
	{
	alert("All rows are not filled.")
	return false;
	}else{
	return true;
	}
	}
	function openPopupForDelete(ipIssueNo){
	var url="/hms/hms/ipd?method=showModifyPatientIssueJsp&ipIssueNo="+ipIssueNo;
	popwindowForDelete(url);
	}
	function popwindowForDelete(url)
	{
 	newwindow=window.open(url,'name','status=yes,resizable,scrollbars=1,height=400,width=1000,');

	}
	function openPopupForView(admissionNumber){
 	var url="/hms/hms/ipd?method=viewPatientIssueJsp&admissionNumber="+admissionNumber;
	popwindowForDelete(url);
	}
</script>