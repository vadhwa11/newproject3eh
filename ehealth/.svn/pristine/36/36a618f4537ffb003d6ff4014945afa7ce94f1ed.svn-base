<%@ page import=" static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<%@page import="jkt.hms.masters.business.StoreGrnT"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.StorePoDetail"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="java.math.RoundingMode"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<%
StringBuffer orderDateOnly = new StringBuffer();
GregorianCalendar gregorianCalendar1 = new GregorianCalendar();
int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
if (dateOfMonth < 10) {
orderDateOnly.append("0");
orderDateOnly.append(dateOfMonth);
} else {
orderDateOnly.append(dateOfMonth);
}
orderDateOnly.append("/");
int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
if (month < 10) {
orderDateOnly.append("0");
orderDateOnly.append(month);
} else {
orderDateOnly.append(month);
}
orderDateOnly.append("/");
int year = gregorianCalendar1.get(Calendar.YEAR);
orderDateOnly.append(year);
String currentDate = new String(orderDateOnly);
%>
<script type="text/javascript" language="javascript">
var itemsArray1=new Array();
var numLinesAdded = 1;
var tt;
function checkForSubmit(){
if(document.getElementById('noOfRows').value==0)
{alert("There must be one detail row");
return false;
}else{
return true;
}
}
function get_value(rowNo,detailId)
{

var url="/hms/hms/stores?method=showInfoOfGrnJsp&detailId="+detailId+"&rowNo="+rowNo;
popwindow(url);
}
var newwindow;
function popwindow(url)
{

newwindow=window.open(url,'name',"height=500,width=600,status=1");
if (window.focus)
{
newwindow.focus()
}
newwindow.createPopup();

}


</script>
<script>
<%

Calendar calendar=Calendar.getInstance();
String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
String date1=String.valueOf(calendar.get(Calendar.DATE));
int year1=calendar.get(calendar.YEAR);
if(month1.length()<2){
month1="0"+month1;
}
if(date1.length()<2){
date1="0"+date1;
}
%>
serverdate = '<%=date1+"/"+month1+"/"+year1%>'
</script>
<script type="text/javascript" language="javascript">
function fillSrNo(rowVal)
{
var pageNo=parseInt(document.getElementById('noOfRows').value);
rowVal=rowVal%30
if(rowVal==0){
rowVal=30
}
if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
document.getElementById('noOfRows').value=rowVal
}
return true;
}

function autocompleteBasedOnPvms(val,inc)
{
ajaxFunctionForAutoCompleteForGrn('indentGrid','stores?method=fillItemsCommon&pvmsNo=' +  val , inc);
}

function ajaxFunctionForAutoCompleteForGrn(formName,action,rowVal)
{
var xmlHttp;
try {
// Firefox, Opera 8.0+, Safari
xmlHttp=new XMLHttpRequest();
}catch (e){
// Internet Explorer
try{
xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
}catch (e){
alert(e)
try{
xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
}catch (e){
alert("Your browser does not support AJAX!");
return false;
}
}
}
var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
xmlHttp.open("GET",url,true);
xmlHttp.setRequestHeader("Content-Type", "text/xml");
xmlHttp.send(null);
xmlHttp.onreadystatechange=function()
{
if(xmlHttp.readyState==4){
var items =xmlHttp.responseXML.getElementsByTagName('items')[0];

for (loop = 0; loop < items.childNodes.length; loop++)
{
var item = items.childNodes[loop];
var id  = item.getElementsByTagName("id")[0];
var pvms  = item.getElementsByTagName("pvms")[0];
var name  = item.getElementsByTagName("name")[0];
document.getElementById('nameItem'+rowVal).value = name.childNodes[0].nodeValue + "[" + pvms.childNodes[0].nodeValue + "]"
}
}
}
}
function fillSrNo(rowVal){

var pageNo=parseInt(document.getElementById('noOfRows').value);
rowVal=rowVal%30
if(rowVal==0){
rowVal=30
}
if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
document.getElementById('noOfRows').value=rowVal
}
return true;
}

function checkForGrn(val,a,inc)
{
if (val=="")
{
document.getElementById('codeItem'+inc).value="";
document.getElementById('idItem'+inc).value=0;
document.getElementById('expiry'+inc).value="";
document.getElementById('idAu'+inc).value="";
document.getElementById('batchNo'+inc).value="";
document.getElementById('lotNo'+inc).value="";
document.getElementById('quanRec'+inc).value="";
document.getElementById('freeQty'+inc).value="";
document.getElementById('dispenseType'+inc).length=0;
//	document.getElementById('brandId'+inc).length=1;

document.getElementById('manufacturerId'+inc).length=1;
document.getElementById('mdq'+inc).value="";
if(document.getElementById('sourceCombo').value=="a" || document.getElementById('sourceCombo').value=="i" )
{
document.getElementById('ratePerMdq'+inc).value=0;
document.getElementById('unitRateVar'+inc).value=0;
}
else{

document.getElementById('ratePerMdq'+inc).value="";
document.getElementById('unitRateVar'+inc).value="";
}

document.getElementById('discountVar'+inc).value="";
document.getElementById('taxVar'+inc).value="";
document.getElementById('amtVar'+inc).value="";
document.getElementById('costPrice'+inc).value="";
document.getElementById('manufacturingDate'+inc).value="";
document.getElementById('expiryDate'+inc).value="";
return;
}

var src = document.getElementById('sourceCombo').value;
var index1 = val.lastIndexOf("[");
var index2 = val.lastIndexOf("]");
index1++;

var pvms = val.substring(index1,index2);

var poId=0;
if(document.getElementById('indentCombo')!=null){
poId = document.getElementById('indentCombo').value;
}
if (src=='l')
ajaxFunctionForAutoCompleteInGrn('grnGrid','stores?method=fillItemsForGrn&requiredField=' + pvms + "&poId=" + poId+"&nom="+val , inc);
else

ajaxFunctionForAutoCompleteInGrnGeneral('grnGrid','stores?method=fillItemsForGrn&requiredField=' + pvms + "&poId=" + poId+"&nom="+val , inc);

}

function generateRow(idName) {
var d=document.getElementById(idName).getElementsByTagName("tr");
lastTr = d[d.length-1]
clone = lastTr.cloneNode(true);
clone.id = parseInt(lastTr.id);
lastTr.parentNode.insertBefore(clone,lastTr.nextSibling)
var tblCtrl = d[d.length-1].getElementsByTagName("input");
var tblCtrlsel = d[d.length-1].getElementsByTagName("select");
tblCtrl[1].value=d.length-1;
for(var i=0;i<tblCtrl.length;i++){
if(i == 0){
tblCtrl[i].value = parseFloat(tblCtrl[i].value) + parseFloat(1) ;
}else{
tblCtrl[i].value="";
}
}
for(var i=0;i < tblCtrlsel.length;i++){
tblCtrlsel[i].options[0].value = "";
tblCtrlsel[i].options[0].text = "";

}
}

function removeRow(argIndex,idName){
var table=document.getElementById(idName);
var tblRows  = table.getElementsByTagName("tr");
var check=0;

var temp1 = false;
for(i=tblRows.length-1;i>0;i--)
{
var tblCtrl =  tblRows[i].getElementsByTagName("input");
for(j=0;j<tblCtrl.length;j++)
{
if(tblCtrl[j].type == 'checkbox')
{
if(tblCtrl [j].checked){
	  check=check+1;
temp1 = true;
}
}
}
}

if(tblRows.length-1==check){
alert("Can not delete all rows")
return false;
}

if(temp1){
if(confirm("Are You Sure,You want Delete ? ")){
}else{
return false;
}
}
var temp =true;
for(i=tblRows.length-1;i>0;i--)
{
var tblCtrl =  tblRows[i].getElementsByTagName("input");
for(j=0;j<tblCtrl.length;j++)
{
if(tblCtrl[j].type == 'checkbox')
{
if(tblCtrl [j].checked){
document.getElementById(idName).deleteRow(i);
 temp = false;
}
}
}
}
if(temp){
alert("Atleast should select one row");
}

tempNetValue = parseFloat(0);
for(i=1;i<=40;i++)
{

if(document.getElementById('idItem'+i) != null){
if(document.getElementById('idItem'+i).value.trim()!=0)
{
var freeItem = document.getElementById('freeItem'+i).value;
if (freeItem=='n')
tempNetValue=parseFloat(tempNetValue)+parseFloat(document.getElementById('amtVar'+i).value);

}
}
}


var actualValue=roundVal(tempNetValue,2);
var valueAfterRounding=roundNumber(tempNetValue,0);
var roundOffAmount  = valueAfterRounding-actualValue;

if (vatApplicable.checked){
var vat = parseFloat(0);
vat = document.getElementById('vatTax').value;
var vatgrn = parseFloat(0);
if(vat == ""){
vat = parseFloat(0);
}

var vatgrn1 = parseFloat(valueAfterRounding)+parseFloat(vat);

vatgrn=roundVal(vatgrn1,0);
roundOffAmount=vatgrn1-vatgrn;
document.getElementById('grnValue').value =vatgrn
}else{
document.getElementById('grnValue').value=valueAfterRounding
}

//document.getElementById('grnValue').value=valueAfterRounding
roundOffAmount=roundVal(roundOffAmount,3);
document.getElementById('roundOfValue').value=roundOffAmount
document.getElementById('actualGrnValue').value=actualValue

}

function getsoitems(){
var so = document.getElementById('indentCombo').value;

currPage=1;
numOfRows=10;
if(so != 0 && so != ""){
var url="/hms/hms/stores?method=getSoItemDetails&currPage="+currPage+"&numOfRows=8&sos="+document.getElementById('sourceCombo').value+"&po_id="+so+"&pageType=mod";
newwindow=window.open(url,'name','top=50, left=50, height=675,width=850,status=1');
} else {
alert("Please select SONo ..!!!");
}
}

function jsGetGrid(){
if((document.getElementById('item_id').value).length > 0){
document.getElementById('temp').value = document.getElementById('item_id').value
document.getElementById('item_id').value = "";
var po_id = document.getElementById('indentCombo').value;
var sos = document.getElementById('sourceCombo').value;
submitForm('indentGrid','stores?method=modifyGrn&sos='+sos+'&po_id='+po_id+'&items='+document.getElementById('temp').value);
// submitForm('searchGrn','stores?method=modifyGrn');
}
}
</script>
<%
Map map = new HashMap();
String includedJsp = null;
String previousPage="no";
String validationMessage ="LEDGER ACCOUNT DONE";
int pageNo=1;
int grnId=0;
List<StoreGrnM> searchGrnList = new ArrayList<StoreGrnM>();
List<MasStoreSection> sectionList= new ArrayList<MasStoreSection>();
List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
List<StoreGrnM> previousStoreGrnMList=new ArrayList<StoreGrnM>();
List<StoreGrnT> gridGrnTList=new ArrayList<StoreGrnT>();
List<StoreGrnM> gridGrnMList= new ArrayList<StoreGrnM>();
List<StorePoDetail> poList = new ArrayList<StorePoDetail>();
List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
int maxGrnNo=0;
if (request.getAttribute("map") != null) {
map = (Map) request.getAttribute("map");

}

List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
if(map.get("supplierList") != null){
supplierList = (ArrayList) map.get("supplierList");
session.setAttribute("supplierList",supplierList);
}else if(session.getAttribute("supplierList") != null){
supplierList = (ArrayList)session.getAttribute("supplierList");

}
List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
if(map.get("employeeList") != null){
employeeList = (ArrayList) map.get("employeeList");
session.setAttribute("employeeList",employeeList);
}else if(session.getAttribute("employeeList") != null){
employeeList = (ArrayList)session.getAttribute("employeeList");

}
List<StoreIndentM> indentList = new ArrayList<StoreIndentM>();
if(map.get("indentList") != null){
indentList = (ArrayList) map.get("indentList");
session.setAttribute("indentList",indentList);
}else if(session.getAttribute("indentList") != null){
indentList = (ArrayList)session.getAttribute("indentList");

}
if(map.get("grnId")!=null){
grnId=Integer.parseInt(""+map.get("grnId"));
}

if (map.get("pageNo") != null) {
pageNo = Integer.parseInt(""+map.get("pageNo"));
}

if(map.get("maxGrnNo")!=null)
maxGrnNo=Integer.parseInt(""+map.get("maxGrnNo"));

if(map.get("sectionList")!=null)
sectionList=(List) map.get("sectionList");

if(map.get("previousStoreGrnMList")!=null)
previousStoreGrnMList=(List) map.get("previousStoreGrnMList");

if(map.get("gridGrnTList")!=null){
gridGrnTList=(List) map.get("gridGrnTList");

}

if(map.get("poList")!=null){
poList=(List) map.get("poList");
}

if(map.get("brandList")!=null){
brandList=(List) map.get("brandList");
}

if(map.get("gridGrnMList")!=null)
gridGrnMList=(List) map.get("gridGrnMList");
String noDetailRecords="no";
if(map.get("noDetailRecords")!=null){
noDetailRecords=(""+map.get("noDetailRecords"));
}

if(map.get("searchGrnList")!=null)
searchGrnList = (List) map.get("searchGrnList");
if(map.get("itemList")!=null)
itemList=(List) map.get("itemList");

String userName = "";
if (session.getAttribute("userName") != null) {
userName = (String) session.getAttribute("userName");
}
String messageTOBeVisibleToTheUser="";
if(map.get("messageTOBeVisibleToTheUser")!=null){
messageTOBeVisibleToTheUser=(String)map.get("messageTOBeVisibleToTheUser");
}

String time="";
String date="";
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
date = (String)utilMap.get("currentDate");
time = (String)utilMap.get("currentTime");
%>

<form name="indent" method="post">
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
<div class="clear"></div>
<!-- thread search menu -->
<form name="searchPanel" method="post">
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<input type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" />
<input type="hidden" name="do" value="process" />
<input type="hidden" name="searchthread" value="1" />
<input type="hidden" name="showposts" value="1" />
<input type="hidden" name="searchthreadid" value="85875" />
<div class="paddingTop15"></div>
<label>From Date</label>
<input type="text" name="<%= FROM_DATE %>"	value="<%= currentDate %> " MAXLENGTH="30" tabindex=1 class="date" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" tabindex="1" onClick="setdate('<%=currentDate%>',document.indent.<%= FROM_DATE%>,event)" />
<label>To Date</label>
<input type="text" name="<%= TO_DATE %>"	MAXLENGTH="30" value="<%= currentDate %> " tabindex=1 class="date" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" tabindex="1"	onClick="setdate('<%=currentDate%>',document.indent.<%= TO_DATE%>,event)" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<label>GRN No.</label>
<input type="text" name="<%=GRN_NO%>" value=""	tabindex=1 MAXLENGTH="100" id="<%=GRN_NO%>" />
<div id="ac5update" class="autocomplete" style="display: none;"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
new Ajax.Autocompleter('<%=GRN_NO%>','ac5update','stores?method=getGrnNoListForAutoComplete',{parameters:'requiredField=<%=GRN_NO%>'});
</script>
<input type="image" class="button"	onClick="submitForm('indent','stores?method=searchGrn');" />
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
<div class="clear"></div>
<div class="paddingTop15"></div>
<form name="indentGrid" method="post">
<div id="testDiv">
<%if(previousPage.equals("no")){ %> <%
if (map.get("gridGrnMList") != null) {
gridGrnMList = (List<StoreGrnM>)map.get("gridGrnMList");
}
StoreGrnM grnMObj = null;
String mode = "0";
if(gridGrnMList.size() > 0){
grnMObj = (StoreGrnM)gridGrnMList.get(0);
grnId = grnMObj.getId();
mode = grnMObj.getModeOfConveyance();
}
%>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="print" class="button" value="Print"	onClick="submitForm('indentGrid','stores?method=showGrnReportJsp');" />
<input type="button" name="GenerateBarCode" class="buttonBig"	value="Generate BarCode"	onClick="submitForm('indentGrid','stores?method=showCreateBarCodeJsp');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<h4>GRN Details</h4>
<div class="clear"></div>
<div class="Block">
<h4><span><%=messageTOBeVisibleToTheUser %></span></h4>
<label><span>*</span> Source of Supply</label>
<select	name="<%=SOURCE_OF_SUPPLY%>" id="sourceCombo" tabindex=1 disabled="disabled" validate="Source of Supply,String,yes">
<% if(grnMObj != null){
if(grnMObj.getReceiveType().equals("l")){
%>
	<option value=<%=grnMObj.getReceiveType()%>><%="Local Purchase"%></option>
	<%}else if(grnMObj.getReceiveType().equals("x")){ %>
	<option value=<%=grnMObj.getReceiveType()%>><%="Local Purchase without PO"%></option>
<%--else if(grnMObj.getReceiveType().equals("p")){ %>
<option value=<%=grnMObj.getReceiveType()%>><%="PVMS By DGRC"%></option>
<%}else if(grnMObj.getReceiveType().equals("a")){ %>
<option value=<%=grnMObj.getReceiveType()%> ><%="AFMSD"%></option>
<%}else if(grnMObj.getReceiveType().equals("o")){ %>
<option value=<%=grnMObj.getReceiveType()%> ><%="Other Units"%></option>
<%}else if(grnMObj.getReceiveType().equals("w")){ %>
<option value=<%=grnMObj.getReceiveType()%> ><%="GRN without LPO"%></option>
<%}--%>
	<%}} %>
</select> <input type="hidden" name="<%=SOURCE_OF_SUPPLY%>" id="sourceCombo"
	value="<%=grnMObj.getReceiveType()%>" validate="" tabindex=1 /> <label>GRN
No.</label> <% if(grnMObj.getGrnNo() != null){ %> <input type="text"
	name="<%= GRN_NO %>" value="<%=grnMObj.getGrnNo()%>" class="readOnly"
	readonly="readonly" validate="GRN Number ,String,no" tabindex=1 /> <input
	type="hidden" name="parent" id="parent" value="<%=grnMObj.getId()%>"
	validate="" tabindex=1 /> <%}else{ %> <input type="text"
	name="<%= GRN_NO %>" value="" validate="GRN Number ,String,no"
	tabindex=1 /> <%} %> <label>GRN Date</label> <%

if(grnMObj.getGrnDate() != null){ %> <input type="text"
	name="<%=GRN_DATE%>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(grnMObj.getGrnDate()) %>"
	class="readOnly" readonly="readonly" tabindex=1
	validate="GRN Date ,String,no" /> <%}else{ %> <input type="text"
	name="<%=GRN_DATE%>" value="<%=currentDate%>" class="readOnly"
	readonly="readonly" tabindex=1 validate="GRN Date ,String,no" /> <%} %>


<div class="clear"></div>


<label>Unit/Ven.Name</label> <%if(!grnMObj.getReceiveType().equals("l")){%>
<select name="<%= SUPPLIER_ID %>" validate="Unit/Ven.Name,string,no"
	tabindex=1>
	<%for(MasStoreSupplier masSupplier:supplierList){
if(grnMObj.getSupplier()!=null && masSupplier.getId()!=null){
	
}
if(grnMObj.getSupplier().getId().equals(masSupplier.getId())){
%>
	<option value="<%=masSupplier.getId() %>" selected="selected"><%=masSupplier.getSupplierName()%></option>
	<%}else{ %>
	<option value="<%=masSupplier.getId() %>"><%=masSupplier.getSupplierName()%></option>
	<%}%><%} %>
</select> <%}else{ %> <select name="<%= SUPPLIER_ID %>" id="<%= SUPPLIER_ID%>"
	validate="Unit/Ven.Name,string,no" disabled tabindex=1>
	<%for(MasStoreSupplier masSupplier:supplierList){

if(grnMObj.getSupplier().getId().equals(masSupplier.getId())){
%>
	<option value="<%=masSupplier.getId() %>" selected="selected"><%=masSupplier.getSupplierName()%></option>
	<%}else{ %>
	<option value="<%=masSupplier.getId() %>"><%=masSupplier.getSupplierName()%></option>
	<%}}%>
</select> <%} %> <%if(grnMObj.getReceiveType().equals("l")){%> <label>PO No.</label>
<input type="text" name="<%=PO_ID%>" id="SONo" class="readOnly" readonly
	tabindex=1 value="<%=grnMObj.getPo().getPoNumber() %>" /> <input
	type="hidden" name="po_id1" id="indentCombo" readonly tabindex=1
	value="<%=grnMObj.getPo().getId() %>" /> <input type="hidden"
	name="po_id2" id="po_id" readonly tabindex=1
	value="<%=grnMObj.getPo().getId() %>" /> <input type="hidden"
	name="item_id" id="item_id" value="" /> <input type="hidden"
	name="temp" id="temp" value="" /> <% if(!grnMObj.getStatus().equalsIgnoreCase("v")) {%>
<%-- <div id="contentHolder">
<input type="button" name="details" id="details" title="SUPPLY ORDER Items" align="right" class="cmnButton" onblur="jsGetGrid()"; value="Get SO Items" onclick="getsoitems();" />
</div>--%> <%}}else{ %> <input type="hidden" name="<%=PO_ID%>" id="SONo"
	readonly tabindex=1 value="" /> <input type="hidden" name="po_id1"
	id="indentCombo" readonly tabindex=1 value="" /> <input type="hidden"
	name="po_id2" id="po_id" readonly tabindex=1 value="" /> <input
	type="hidden" name="item_id" id="item_id" value="" /> <input
	type="hidden" name="temp" id="temp" value="" /> <%} %> <%if(grnMObj.getIndent()!=null && grnMObj.getReceiveType().equals("p") || grnMObj.getReceiveType().equals("a")) { %>

<label>Indent No.</label> <input type="text" name="<%=INDENT_ID %>"
	class="readOnly" readonly="" id="<%=INDENT_ID %>"
	value="<%=grnMObj.getIndent().getIndentNo() %>" /> <%}else{ %> <input
	type="hidden" name="<%=INDENT_ID %>" class="readOnly" readonly=""
	id="<%=INDENT_ID %>" value="" /> <%} %> <%-- <label >Po No.</label>--%>
<% if(grnMObj != null){%> <input id="test" type="hidden"
	name="<%=SUPPLY_ORDER_NO %>" value="<%=grnMObj.getAtSoNo() %>"
	MAXLENGTH="75" tabindex=1> <%}else{ %> <input id="test"
	type="hidden" name="<%=SUPPLY_ORDER_NO %>" value="" MAXLENGTH="75"
	tabindex=1> <%} %>
<div class="clear"></div>
<div id="atsoDateDiv"><label>Po Date</label> <input type="text"
	name="<%=AT_SO_DATE%>" id="atSoDate" value="<%=currentDate %>"
	class="readOnly" readonly="readonly" MAXLENGTH="30" /> <%-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="javascript:setdate('<%=currentDate%>',document.grnGrid.<%=AT_SO_DATE%>,true)" />--%>
</div>

<label>Date Rec/Surp</label> <%if(grnMObj.getDateReceivedSurplus()!= null) {%>
<input type="text" class="date" name="<%=RECEIVED_DATE%>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(grnMObj.getDateReceivedSurplus())%>"
	tabindex=1 validate="surplus Date ,String,no" /> <%}else{ %> <input
	type="text" name="<%=RECEIVED_DATE%>" value="" class="readOnly"
	readonly="readonly" class="date" tabindex=1
	validate="surplus Date ,String,no" /> <%} %> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.indentGrid.<%=RECEIVED_DATE%>,event);" />


<label>Unpack/Checked by</label> <select name="<%=EMPLOYEE_ID%>"
	validate="Unpack/Checked by,string,no" tabindex=1>
	<option value="0">Select</option>
	<%for(MasEmployee masEmployee:employeeList){

if(grnMObj.getEmployee().getId().equals(masEmployee.getId())){
%>
	<option value="<%=masEmployee.getId() %>" selected="selected"><%=masEmployee.getFirstName() + " " + masEmployee.getLastName()%></option>
	<%}else{ %>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+ " " +masEmployee.getLastName()%></option>
	<%}}%>
</select>
<div class="clear"></div>


<%--
<label >R/R No. </label>
<% if(grnMObj.getRrNo()
!= null){ %>
<input	type="text"  name="<%=RR_NO %>" value="<%=grnMObj.getRrNo()%>" validate="rr Number ,String,no" tabindex=1 />
<%}else{ %>
<input	type="text"  name="<%=RR_NO %>" value=""  tabindex=1 />
<%} %>

<label >Mode of Convey</label>
<select id="modeoOfConv" name="<%=MODE_OF_CONVEYANCE%>"  value="4"  validate="Mode Of Conveyance,string,yes" tabindex=1>
<option value="0">Select</option>
<option value="1">Air</option>
<option value="2">Bus</option>
<option value="3">Train</option>
<option value="4">By Hand</option>
</select>

<script>
document.getElementById("modeoOfConv").value ='<%=mode%>';
</script>
 --%> <label>How Received</label> <% if(grnMObj.getHowReceived() != null){ %>
<input type="text" name="<%= HOW_RECEIVED %>"
	value="<%=grnMObj.getHowReceived()%>" tabindex=1 /> <%}else{ %> <input
	type="text" name="<%= HOW_RECEIVED %>" value="" tabindex=1 /> <%} %> <label>Remarks</label>
<%if(grnMObj.getRemarks() != null){ %> <textarea
	value="<%=grnMObj.getRemarks()%>" name="<%=REMARKS %>"
	validate="Remarks ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250">
</textarea> <%}else{ %> <textarea value="" name="<%=REMARKS %>"
	validate="Remarks ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250">
</textarea> <%} %> <% if(grnMObj.getInvoiceNo() != null && !grnMObj.getInvoiceNo().equals("")){ %>
<label>Invoice No.</label> <input type="text" name="<%= INVOICE_NO %>"
	id="<%= INVOICE_NO %>"
	value="<%=grnMObj.getInvoiceNo()==null?"":grnMObj.getInvoiceNo()%>"
	tabindex=1 /> <%}%>
<div class="clear"></div>

<% if(grnMObj.getInvoiceDate() != null){ %> <label>Invoice Date</label> <input
	type="text" name="<%= INVOICE_DATE %>" class="date" id="invoiceDate"
	value="<%=HMSUtil.convertDateToStringWithoutTime(grnMObj.getInvoiceDate())%>"
	tabindex=1 /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate%>',document.getElementById('<%=INVOICE_DATE%>'),event);" />
<%}%> <%

if(grnMObj.getInvoiceAmount() != null && grnMObj.getInvoiceAmount().intValue()!= 0){ %>



<label>Invoice Amount</label> <input type="text"
	name="<%= INVOICE_AMOUNT %>" id="<%=INVOICE_AMOUNT %>"
	value="<%=grnMObj.getInvoiceAmount()==null?"":grnMObj.getInvoiceAmount()%>"
	tabindex=1 /> <%}%> <label>Freight Duty</label> <input type="text"
	name="<%=FREIGHT_DUTY %>" id="<%=FREIGHT_DUTY %>"
	value="<%=grnMObj.getFreightDuty()==null?"":grnMObj.getFreightDuty() %>"
	onblur="calculationInCRVMod()" tabindex=1 MAXLENGTH="8"/  >
<div class="clear"></div>
<label>Excise Duty</label> <input type="text" name="<%=EXCISE_DUTY %>"
	id="<%=EXCISE_DUTY %>"
	value="<%=grnMObj.getExciseDuty()==null?"":grnMObj.getExciseDuty() %>"
	onblur="calculationInCRVMod()" tabindex=1 MAXLENGTH="8"/  ><label>Octroi</label>
<input type="text" name="<%=OCTROI %>" id="<%=OCTROI %>"
	value="<%= grnMObj.getOctroi()==null?"":grnMObj.getOctroi()%>"
	onblur="calculationInCRVMod()" tabindex=1 MAXLENGTH="8"/  ><label>Insurance
Charge</label> <input type="text" name="<%=INSURANCE_CHARGES %>"
	id="<%=INSURANCE_CHARGES %>"
	value="<%=grnMObj.getInsuranceCharge()==null?"":grnMObj.getInsuranceCharge() %>"
	onblur="calculationInCRVMod()" tabindex=1 MAXLENGTH="8"/  >
<div class="clear"></div>
<label>Other Charges</label> <input type="text"
	name="<%=OTHER_CHARGES %>" id="<%=OTHER_CHARGES %>"
	value="<%=grnMObj.getOtherCharges()==null?"":grnMObj.getOtherCharges() %>"
	onblur="calculationInCRVMod()" tabindex=1 MAXLENGTH="8"/  ><label>Custom
Duty</label> <input type="text" name="<%=CUSTOM_DUTY %>" id="<%=CUSTOM_DUTY %>"
	value="<%=grnMObj.getCustomDuty()==null?"":grnMObj.getCustomDuty() %>"
	onblur="calculationInCRVMod()" tabindex=1 MAXLENGTH="8"/  >
<div class="clear"></div></div>

<!--this is the closing tag of test div--></div>
<div class="clear"></div>
<%if(!grnMObj.getStatus().equalsIgnoreCase("v")) {%>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="sss" align="right" title="UPDATE"	class="button" value="Update"	onclick="if(checkForCRVGrid() && testForGrn()&& checkloanin()&& checkSave()&&checkForSubmit()){calculationInCRVMod();submitForm('indentGrid','stores?method=updateCrv&validate=f');}" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%-- <input type="button" name="validate" align="right" title="LEDGER ACC DONE" class="cmnButton" value="Validate" onclick="if(checkForCRVGrid() && testForGrn()&& checkloanin()&& checkSave()&& checkForSubmit()){submitForm('indentGrid','stores?method=updateCrv&validate=t&po_id=');}"/>--%>
<%-- <input type="button" name="sss" align="right"  title="REFRESH CRV CALCULATIONS" class="cmnButton" value="Refresh Calculation" onclick="calculationInCRVMod()"/>--%>
<%}else{%>
<h4><%=validationMessage %></h4>
<%} %>
<div class="clear"></div>
<input type="hidden" name="<%=NO_DETAIL_RECORDS%>"
	value="<%=noDetailRecords%>" /> <input type="hidden" size="2"
	value="10" name="<%=NO_OF_ROWS %>" id="<%=NO_OF_ROWS %>" /> <input
	type="hidden" name="<%=GRN_ID %>"
	<%--id="<%=GRN_ID%>"--%> value="<%=grnId%>" id="hdb" />
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block"><label> Total VAT Amt </label> <input
	type="text" name="vatTax" id="vatTax" value="<%=grnMObj.getVat()%>"
	MAXLENGTH="15" validate="Total VAT,float,no"
	onblur="calculationInCRVMod()" tabindex="1" /> <label> Total
Discount </label> <input type="text" name="totDiscount" id="totDiscount"
	value="<%=grnMObj.getDiscount() %>" MAXLENGTH="15"
	validate="Total Discount,float,no" onblur="calculationInCRVMod()"
	tabindex="1" /> <label> GRN Value </label> <input type="text"
	name="grnValue" id="grnValue"
	value="<%=grnMObj.getInvoiceAmount()==null?"":grnMObj.getInvoiceAmount()%>"
	MAXLENGTH="15" validate="GRN Value,float,no" tabindex="1" />

<div class="clear"></div>

<label> Round Off Value </label> <input type="text" name="roundOfValue"
	id="roundOfValue"
	value="<%=grnMObj.getRoundOffValue()==null?"":grnMObj.getRoundOffValue()%>"
	MAXLENGTH="15" tabindex="1" /> <input type="hidden"
	name="actualGrnValue" id="actualGrnValue" value="" /> <%if(grnMObj.getVat().intValue() != 0){ %>

<label>VAT Added</label> <input name="vatApplicable" type="checkbox"
	class="radioCheck" id="vatApplicable" tabindex=1
	onClick="calculationInCRVMod();" value="1" checked /> <%}else{ %> <label>VAT
Added</label> <input type="checkbox" name="vatApplicable" id="vatApplicable"
	value="1" tabindex=1 onClick="calculationInCRVMod();" />

<div class="clear"></div>
<%} %>
</div>

<% } %>
<div class="clear"></div>
<div class="paddingTop15"></div>

<input type="button" class="buttonDel" value="" title="DELETE ITEMS"
	onclick="removeRow(this,'purchaseDetails');" align="right" />

<div class="clear"></div>
<div class="paddingTop15"></div>

<div class="cmntable">
<table colspan="7" id="purchaseDetails">
	<tr>

		<th width="5%"></th>
		<th width="8%">Item Code</th>
		<th width="9%">Item Name</th>
		<th width="9%">Manuf. Name</th>
		<th width="9%">UOM</th>
		<th width="9%">Batch No</th>
		<th width="9%">BarCode No</th>
		<th width="9%">QTY Recd.</th>
		<th width="9%">Free Qty</th>
		<th width="9%">Dispen.Type</th>
		<!-- <th width="9%">MDQ</th> -->
		<th width="9%">Unit Rate</th>
		<th width="9%">Dispencing Price</th>
		<th width="9%">MRP</th>
		<th width="9%">Converted Stock</th>
		<th width="9%">Disc(%)</th>
		<th width="9%">Tax(%)</th>
		<th width="9%">Amt Value</th>
		<th width="9%">Free Item</th>
		<th width="9%">Manuf. Date</th>
		<th width="9%">Expiry Date</th>
	</tr>


	<%
int detailCounter=40;
int temp=0;
String idItem="idItem";
String codeItem="codeItem";
String nameItem="nameItem";
String idAu="idAu";
String idBrand="idBrand";
String dispenseType = "dispenseType";
String mdq = "mdq";
String ratePerMdq = "ratePerMdq";
String quantityInVar="quantityInVar";
String taxVar="taxVar";
String amountVar="amountVar";
String unitRateVar="unitRateVar";
String discountVar="discountVar";
String idSection="idSection";
String costPrice ="costPrice";
String freeQty="freeQty";
String manufacturerId="manufacturerId";
String freeItem="freeItem";
String manufacturingDate="manufacturingDate";
String expiryDate="expiryDate";
String brandId="brandId";
String nameBrand="nameBrand";
String batchNo="batchNo";
String quanRec="quanRec";
String amtVar="amtVar";
String stockInVarTemp="stockInVarTemp";
String lotNo="lotNo";
String shelfLife="shelfLife";
String expiry ="expiry";
String vatTax="vatTax";
String convertedStock = "convertedStock";
String formula = "formula";
String conversionFactor = "conversionFactor";
String discountAmount = "discountAmount";
String taxAmount = "taxAmount";
String dispencingPrice="dispencingPrice";
String mrp="mrp";



if(previousPage.equals("no")){
//int inc=((pageNo-1)*40)+1;
//int incTemp2=inc+40;
int inc=1;
for(StoreGrnT storeGrnT : gridGrnTList){


//if(inc<incTemp2){
%>

	<%

%>
	<tr>
		<td width="5%"><input type="checkbox" class="radioCheck"
			name="checkbox" value="" /></td>
		<!--<td width="5%"><input type="text" size="2"	value="<%=storeGrnT.getSerialNo()%>"  name="<%=SR_NO%>" readonly="readonly" /></td>
-->
		<td width="10%">
		<%if(storeGrnT.getItem().getPvmsNo()!=null){ %> <input type="text"
			value="<%=storeGrnT.getItem().getPvmsNo() %>" size="6"
			name="<%=ITEM_CODE %>"
			onblur="autocompleteBasedOnPvms(this.value,'<%=inc%>');"
			id="<%=codeItem+""+inc%>" size="5" /> <%}else{ %> <input type="text"
			value=" " name="<%=ITEM_CODE %>" size="6" id="<%=codeItem+""+inc%>"
			size="5" /> <%} %> <input type="hidden" name="flag" value="Grn" /> <input
			type="hidden" name="<%=DETAIL_ID %>" value="<%=storeGrnT.getId() %>"
			id="hdb" /> <input type="hidden"
			value="<%=storeGrnT.getItem().getId()%>" name="<%=ITEM_ID%>"
			id="<%=idItem+""+inc%>" /> <input type="hidden" value="" name=""
			id="<%=expiry+""+inc%>" /> <input type="hidden" value="" name=""
			id="<%=formula+""+inc%>" /> <input type="hidden" value="" name=""
			id="<%=conversionFactor+""+inc%>" /></td>

		<td width="10%"><input type="text"
			value="<%=storeGrnT.getItem().getNomenclature() %>"
			id="<%=nameItem+""+inc%>"
			onblur="if(fillSrNo('<%=inc %>')){checkForGrn(this.value, '<%=nameItem%>','<%=inc %>');}"
			name="<%=nameItem%>" />
		<div id="ac8update" class="autocomplete" style="display: none;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
new Ajax.Autocompleter('<%=nameItem+""+inc%>','ac8update','stores?method=getItemListForGrnByAutocomplete',{parameters:'requiredField=<%=nameItem%>&indentId='+document.getElementById('indentCombo').value+'&sourceOfSupply= '+document.getElementById('sourceCombo').value});
</script></td>


		<%--  <td width="10%">
<select name="<%=BRAND_ID%>"  id="<%=brandId+""+inc%>">
<option value="<%=storeGrnT.getBrand().getId()%>"><%=storeGrnT.getBrand().getBrandName()%></option>
</select>
</td>--%>

		<td width="10%"><select name="<%=MANUFACTURER_ID %>"
			id=<%=manufacturerId+""+inc%> tabindex="1">
			<%
			if(storeGrnT.getManufacturer() != null){
			%>
			<option value="<%=storeGrnT.getManufacturer().getId()%>"><%=storeGrnT.getManufacturer().getManufacturerName()%></option>
			<%}else{ %>
			<option value=""></option>
			<%} %>
		</select>
		<%
		String unitName="";
		int storeDept=0;
		if(storeGrnT.getItem().getItemConversion()!=null){
			unitName=storeGrnT.getItem().getItemConversion().getPurchaseUnit().getUnitName();
		}
		if(storeGrnT.getItem().getDepartment()!=null){
			storeDept=storeGrnT.getItem().getDepartment().getId();
		}

		%>
		<td width="10%"><input type="text" size="8"
			value="<%=unitName%>"
			readonly="readonly" name="<%=AV%>" id="<%=idAu+""+inc%>" size="5" /></td>

		<td width="10%"><input type="text" size="8"
			value="<%=storeGrnT.getBatchNo() %>" size="5" name="<%=BATCH_NO %>"
			id="<%=batchNo+""+inc %>" tabindex="2" />
			<input type="hidden" name="storeDept" id="storeDept<%=inc %>" value="<%=storeDept %>"/></td>
		<td width="10%">
		 <input type="text"
			size="15" name="barcodeNo" tabindex="1" id="barCodeNo<%=inc%>"
			value="<%=storeGrnT.getBarcodeNo()%>" maxlength="35" /></td>

		<input type="hidden" value="<%=storeGrnT.getLotNo() %>"
			name="<%=LOT_NO %>" tabindex="1" id="<%=lotNo+""+inc%>"
			maxlength="50" /> <%--
<td width="10%">
<input type="text" value="<%=storeGrnT.getLotNo() %>"  name="<%=LOT_NO %>" id="<%=lotNo+""+inc %>" tabindex="1" />
</td> --%>
		<td width="10%"><input type="text" size="8"
			value="<%=storeGrnT.getReceivedQty() %>" size="5"
			name="<%=QUANTITY_RECEIVED %>" id="<%=quanRec+""+inc %>" tabindex="1" />
		</td>
		<td width="10%"><input type="text" size="8"
			value="<%=storeGrnT.getFreeQty() %>" size="5" name="<%=FREE_QTY %>"
			id="<%=freeQty+""+inc %>" readonly="readonly" /></td>
		<td width="10%"><select name="dispenseType"
			id=<%=dispenseType+""+inc%> tabindex="1">
			<option value="<%=storeGrnT.getDispType()%>"><%=storeGrnT.getDispType()%></option>
		</select>
		<td width="10%"><input type="hidden" value="1"
			readonly="readonly" name="mdq" id="<%=mdq+""+inc%>" tabindex="1"
			size="8" /> <input type="hidden" value="" name=""
			readonly="readonly" tabindex="2" id="<%=mdq%>" /> <input type="text"
			value="<%=storeGrnT.getRatePerMdq()%>" size="8" name="ratePerMdq"
			id="<%=ratePerMdq+""+inc%>" onblur="calculationInCRVMod()"
			tabindex="1" size="5" /> <input type="hidden" value="" name=""
			readonly="readonly" tabindex="2" id="<%=ratePerMdq+""+inc%>" /></td>
		<td width="10%"><input type="text"
			value="<%=storeGrnT.getDispencingPrice()%>" size="8"
			name="dispencingPrice" id="dispencingPrice<%=inc%>"
			onblur="calculationInCRVMod()" tabindex="1" size="5" /> <input
			type="hidden" value="" name="" readonly="readonly" tabindex="2"
			id="dispencingPrice<%=inc%>" /></td>
		<td width="10%"><input type="text"
			value="<%=storeGrnT.getMrp()%>" size="8" name="mrp" id="mrp<%=inc%>"
			onblur="calculationInCRVMod()" tabindex="1" size="5" /> <input
			type="hidden" value="" name="" readonly="readonly" tabindex="2"
			id="mrp<%=inc%>" /></td>
		<%
BigDecimal tax = new BigDecimal(0);
BigDecimal discount = new BigDecimal(0);
BigDecimal qty = new BigDecimal(0);
BigDecimal rate = new BigDecimal(0);
BigDecimal amount  = new BigDecimal(0);
BigDecimal amountAfterTax = new BigDecimal(0);
BigDecimal amountAfterdis = new BigDecimal(0);
BigDecimal totamount  = new BigDecimal(0);

int mdqValue = 1;
String formulaValue = "";
int conversionFactorValue = 0;

BigDecimal taxPercent = new BigDecimal(0);
BigDecimal discountPercent = new BigDecimal(0);

try
{
qty = storeGrnT.getReceivedQty();
}
catch(Exception e)
{
qty = new BigDecimal(0);
}

try
{
rate = storeGrnT.getRatePerMdq();
}
catch(Exception e)
{
rate = new BigDecimal(0);
}

try
{
tax = storeGrnT.getTax();
}
catch(Exception e)
{
tax = new BigDecimal(0);
}

try
{
discount = storeGrnT.getDiscount();
}
catch(Exception e)
{
discount = new BigDecimal(0);
}

try
{
	if(storeGrnT.getItem().getItemConversion()!=null){
		formulaValue = storeGrnT.getItem().getItemConversion().getFormula();
	}else{
		formulaValue ="";
	}
}
catch(Exception e)
{
formulaValue = "";
}


try
{
	if(storeGrnT.getItem().getItemConversion()!=null){
		conversionFactorValue = storeGrnT.getItem().getItemConversion().getConversionFactor1();
	}else{
		conversionFactorValue =0;
	}
//conversionFactorValue = storeGrnT.getItem().getItemConversion().getConversionFactor1();
}
catch(Exception e)
{
conversionFactorValue = 0;
}

try
{
mdqValue = storeGrnT.getMdqValue();
}
catch(Exception e)
{
mdqValue = 1;
}

try
{
totamount = storeGrnT.getAmountValue();
}
catch(Exception e)
{
totamount = new BigDecimal(0);
}


amount = qty.multiply(rate);
amountAfterTax = amount.add(tax);
amountAfterdis = totamount.subtract(discount);

if(!discount.toString().equals("0.0000") && !discount.toString().equals("0")){
discountPercent = (discount.multiply(new BigDecimal(100))).divide(amount, 2, RoundingMode.HALF_UP);
}

if(!tax.toString().equals("0.0000") && !tax.toString().equals("0")){
taxPercent = (tax.multiply(new BigDecimal(100))).divide(amount, 2, RoundingMode.HALF_UP);
}

BigDecimal convertedStockValue = new BigDecimal(0);
if(formulaValue!=null && !formulaValue.equals("")){
	if (formulaValue.equals("1"))
	{
	convertedStockValue = qty.multiply(new BigDecimal(mdqValue)).divide(new BigDecimal(conversionFactorValue), 2, RoundingMode.HALF_UP);
	}
	else if (formulaValue.equals("2"))
	{
	convertedStockValue = qty;
	}
}else{
	convertedStockValue = qty;
}

%>

		<td width="3%"><input type="text" size="8"
			value="<%= convertedStockValue%>" name="convertedStock" tabindex="1"
			id="<%=convertedStock+""+inc%>" size="5" /> <input type="hidden"
			value="<%=storeGrnT.getUnitRate() %>" name="<%=UNIT_RATE%>"
			tabindex="2" id="<%=unitRateVar+""+inc%>" /></td>

		<td width="3%"><input type="text" size="8"
			value="<%=discountPercent %>" size="5"
			name="<%=DISCOUNT_PERCENTAGE%>" onblur="calculationInCRVMod()"
			tabindex="1" id="<%=discountVar+""+inc%>" /> <input type="hidden"
			value="<%=storeGrnT.getDiscount() %>" name="discountAmount"
			tabindex="2" id="<%=discountAmount+""+inc%>" /></td>

		<td width="10%"><input type="text" size="8"
			value="<%=taxPercent %>" size="5" name="<%=TAX_PERCENT %>"
			tabindex="1" onblur="calculationInCRVMod()" id="<%=taxVar+""+inc%>" />
		<input type="hidden" value="<%=storeGrnT.getTax() %>" name="taxAmount"
			tabindex="2" id="<%=taxAmount+""+inc%>" /></td>
		<td width="10%"><input type="hidden"
			value="<%=storeGrnT.getAmountValue() %>" name="<%= COST_PRICE %>"
			id="<%=costPrice+""+inc%>" /> <input type="text" size="8"
			value="<%=storeGrnT.getAmountValue() %>" size="5" name="<%=AMOUNT%>"
			id="<%=amtVar+""+inc%>" readonly="readonly" /> <input type="hidden"
			value="<%=storeGrnT.getFreeQty() %>" name="<%=FREE_QTY %>"
			id="<%=freeQty+""+inc %>" /></td>

		<td width="10%"><select name="<%=FREE_ITEM %>"
			id="<%=freeItem+""+inc %>" tabindex="1" class="small">
			<option value="n"
				<%=HMSUtil.isSelected(storeGrnT.getFreeItem(),"n")%>>No</option>
			<option value="y"
				<%=HMSUtil.isSelected(storeGrnT.getFreeItem(),"y")%>>Yes</option>
		</select></td>

		<td width="40%"><input type="text"
			value="<%=storeGrnT.getManufacturerDate()==null?"":HMSUtil.convertDateToStringWithoutTime(storeGrnT.getManufacturerDate())%>"
			name="<%=MANUFACTURING_DATE%>" id="<%=manufacturingDate+""+inc%>"
			size="8" MAXLENGTH="30" tabindex="1" readonly="readonly" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufacturingDate+""+inc %>'),event);" />
		</td>


		<td width="40%"><input type="text"
			value="<%=storeGrnT.getExpiryDate()==null?"":HMSUtil.convertDateToStringWithoutTime(storeGrnT.getExpiryDate())%>"
			name="<%=EXPIRY_DATE%>" id="<%=expiryDate+""+inc %>" size="8"
			MAXLENGTH="30" tabindex="1" readonly="readonly" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.getElementById('<%=expiryDate+""+inc %>'),event);" />
		</td>
	</tr>
	<% inc++;
//}
}
%>
	<script>

document.indentGrid.noOfRows.value=<%=inc-1%>
</script>


	<%
for(StorePoDetail storePO : poList){

//if(inc<incTemp2){
%>

	<%

%>
	<tr>
		<td width="5%"><input type="checkbox" class="radioCheck"
			name="checkbox" value="" /></td>
		<!--<td width="5%"><input type="text" size="2"	value=""  name="<%=SR_NO%>" readonly="readonly" /></td>
-->
		<td width="10%">
		<%if(storePO.getItem().getPvmsNo()!=null){ %> <input
			name="<%=ITEM_CODE %>" type="text" size="8" id="<%=codeItem+""+inc%>"
			onblur="autocompleteBasedOnPvms(this.value,'<%=inc%>');"
			value="<%=storePO.getItem().getPvmsNo() %>" size="5" /> <%}else{ %> <input
			type="text" value=" " size="5" name="<%=ITEM_CODE %>"
			id="<%=codeItem+""+inc%>" /> <%} %> <input type="hidden" name="flag"
			value="Grn" /> <input type="hidden" name="<%=DETAIL_ID %>" value=""
			id="hdb" /> <input type="hidden"
			value="<%=storePO.getItem().getId()%>" name="<%=ITEM_ID%>"
			id="<%=idItem+""+inc%>" /> <input type="hidden" value="" name=""
			id="<%=expiry+""+inc%>" /> <input type="hidden" value="" name=""
			id="<%=formula+""+inc%>" /> <input type="hidden" value="" name=""
			id="<%=conversionFactor+""+inc%>" /></td>

		<td width="10%"><input type="text"
			value="<%=storePO.getItem().getNomenclature() %>"
			id="<%=nameItem+""+inc%>"
			onblur="if(fillSrNo('<%=inc %>')){checkForGrn(this.value, '<%=nameItem%>','<%=inc %>');}"
			name="<%=nameItem%>" />
		<div id="ac99update" class="autocomplete" style="display: none;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
new Ajax.Autocompleter('<%=nameItem+""+inc%>','ac99update','stores?method=getItemListForGrnByAutocomplete',{parameters:'requiredField=<%=nameItem%>&indentId='+document.getElementById('indentCombo').value+'&sourceOfSupply= '+document.getElementById('sourceCombo').value});
</script></td>

		<%--<%

int bId = 0;
int mId = 0;
String brandName = "";
String manufacturer = "";
if (brandList != null && brandList.size()>0)
{
for(MasStoreBrand masStoreBrand : brandList){
if(masStoreBrand.getItem().getId() == storePO.getItem().getId()){
brandName = masStoreBrand.getBrandName();
bId = masStoreBrand.getId();
manufacturer = masStoreBrand.getManufacturer().getManufacturerName();
mId = masStoreBrand.getManufacturer().getId();
}
}
}

%>
<td width="10%">
<select name="<%=BRAND_ID%>"  id="<%=brandId+""+inc%>">
<option value="<%=bId%>"><%=brandName%></option>
</select>
</td>--%>

		<td width="10%"><select name="<%=MANUFACTURER_ID %>"
			id=<%=manufacturerId+""+inc%> tabindex="1">
			<%-- <option value="<%=mId%>"><%=manufacturer%></option>--%>
		</select>
		<td width="10%"><input type="text" size="8"
			value="<%=storePO.getItem().getItemConversion().getPurchaseUnit().getUnitName() %>"
			readonly="readonly" name="<%=AV%>" id="<%=idAu+""+inc%>" size="5" /></td>

		<td width="10%"><input type="text" value="" size="8"
			name="<%=BATCH_NO %>" id="<%=batchNo+""+inc %>" tabindex="2" size="5" />
			<input type="hidden" name="storeDept" id="storeDept<%=inc %>" value="<%=storePO.getItem().getDepartment().getId() %>"/>
		</td>
		<td width="10%"><input type="text" value="" size="15"
			name="barcodeNo" tabindex="1" id="barCodeNo<%=inc%>" value=""
			maxlength="35" /></td>
		<input type="hidden" value="" size="8" name="<%=LOT_NO %>"
			tabindex="1" id="<%=lotNo+""+inc%>" maxlength="50" /> <!--
<td width="10%">
<input type="text" value=""  name="<%=LOT_NO %>" id="<%=lotNo+""+inc %>" tabindex="1" />
</td>
-->
		<td width="10%"><input type="text"
			value="<%=storePO.getQuantityOrdered() %>"
			name="<%=QUANTITY_RECEIVED %>" id="<%=quanRec+""+inc %>" tabindex="1"
			size="5" /></td>
		<td width="10%"><input type="text" value="0" size="8"
			name="<%=FREE_QTY %>" id="<%=freeQty+""+inc %>" readonly="readonly"
			size="5" /></td>
		<td width="10%"><select name="dispenseType"
			id=<%=dispenseType+""+inc%> tabindex="1">
			<option value="<%=storePO.getDispType()%>"><%=storePO.getDispType()%></option>
		</select>
		<td width="10%"><input type="hidden" size="8" value="1"
			readonly="readonly" name="mdq" id="<%=mdq+""+inc%>" tabindex="1"
			size="5" /> <input type="hidden" value="" name=""
			readonly="readonly" tabindex="2" id="<%=mdq%>" /> <input type="text"
			size="8" value="<%=storePO.getRatePerMdq()%>" name="ratePerMdq"
			id="<%=ratePerMdq+""+inc%>" onblur="calculationInCRVMod()"
			tabindex="1" size="5" /> <input type="hidden" value="" name=""
			readonly="readonly" tabindex="2" id="<%=ratePerMdq+""+inc%>" /></td>
		<td width="10%"><input type="text" size="8" value=""
			name="dispencingPrice" id="dispencingPrice<%=inc%>"
			onblur="calculationInCRVMod()" tabindex="1" size="5" /> <input
			type="hidden" value="" name="" readonly="readonly" tabindex="2"
			id="dispencingPrice<%=inc%>" /></td>
		<td width="10%"><input type="text" size="8" value="" name="mrp"
			id="mrp<%=inc%>" onblur="calculationInCRVMod()" tabindex="1" size="5" />
		<input type="hidden" value="" name="" readonly="readonly" tabindex="2"
			id="mrp<%=inc%>" /></td>

		<%
BigDecimal tax = new BigDecimal(0);
BigDecimal discount = new BigDecimal(0);
BigDecimal qty = new BigDecimal(0);
BigDecimal rate = new BigDecimal(0);
BigDecimal amount  = new BigDecimal(0);
BigDecimal amountAfterTax = new BigDecimal(0);
BigDecimal amountAfterdis = new BigDecimal(0);

BigDecimal mdqValue = new BigDecimal(0);
String formulaValue = "";
int conversionFactorValue = 0;

float taxPercent = 0f;
float discountPercent = 0f;


try
{
qty = storePO.getQuantityOrdered();
}
catch(Exception e)
{
qty = new BigDecimal(0);
}

try
{
rate = storePO.getRatePerMdq();
}
catch(Exception e)
{
rate = new BigDecimal(0);
}

try
{
tax = storePO.getTaxAmount();
}
catch(Exception e)
{
tax = new BigDecimal(0);
}

try
{
discount = storePO.getDiscountAmount();
}
catch(Exception e)
{
discount = new BigDecimal(0);
}

try
{
formulaValue = storePO.getItem().getItemConversion().getFormula();
}
catch(Exception e)
{
formulaValue = "";
}


try
{
conversionFactorValue = storePO.getItem().getItemConversion().getConversionFactor1();
}
catch(Exception e)
{
conversionFactorValue = 0;
}

try
{
mdqValue = storePO.getMdqValue();
}
catch(Exception e)
{
mdqValue = new BigDecimal(1);
}



amount = qty.multiply(rate);
amountAfterTax = amount.add(tax);
//	amountAfterdis = amount.subtract(discount);


//	discountPercent = discount.divide(amount).multiply(new BigDecimal(100)).floatValue();
//	taxPercent = tax.divide(amountAfterdis).multiply(new BigDecimal(100)).floatValue();
BigDecimal convertedStockValue = new BigDecimal(0);

if (formulaValue.equals("1"))
{
convertedStockValue = qty.multiply(mdqValue).divide(new BigDecimal(conversionFactorValue), 2, RoundingMode.HALF_UP);
}
else if (formulaValue.equals("2"))
{
convertedStockValue = qty;
}

%>

		<td width="3%"><input type="text" size="8"
			value="<%= convertedStockValue%>" name="convertedStock" tabindex="1"
			id="<%=convertedStock+""+inc%>" size="5" /> <input type="hidden"
			value="<%=storePO.getUnitRate() %>" name="<%=UNIT_RATE%>"
			tabindex="2" id="<%=unitRateVar+""+inc%>" /></td>

		<td width="3%">
		<%if(storePO.getDiscountPercent() != null){ %> <input type="text"
			value="<%=storePO.getDiscountPercent() %>"
			name="<%=DISCOUNT_PERCENTAGE%>" onblur="calculationInCRVMod()"
			tabindex="1" id="<%=discountVar+""+inc%>" size="5" /> <input
			type="hidden" value="<%=storePO.getDiscountAmount() %>"
			name="discountAmount" tabindex="2" id="<%=discountAmount+""+inc%>" />
		<%} else{ %> <input type="text" size="8" value="0.0"
			name="<%=DISCOUNT_PERCENTAGE%>" onblur="calculationInCRVMod()"
			tabindex="1" id="<%=discountVar+""+inc%>" size="5" /> <input
			type="hidden" value="0.0" name="discountAmount" tabindex="2"
			id="<%=discountAmount+""+inc%>" /> <% } %>
		</td>

		<td width="10%">
		<%if(storePO.getTaxPercent() != null){ %> <input type="text"
			value="<%=storePO.getTaxPercent() %>" name="<%=TAX_PERCENT %>"
			tabindex="1" onblur="calculationInCRVMod()" id="<%=taxVar+""+inc%>"
			size="5" /> <input type="hidden" size="8"
			value="<%=storePO.getTaxAmount() %>" name="taxAmount" tabindex="2"
			id="<%=taxAmount+""+inc%>" /> <%} else{ %> <input type="text" size="8"
			value="0.0" name="<%=TAX_PERCENT %>" tabindex="1"
			onblur="calculationInCRVMod()" id="<%=taxVar+""+inc%>" /> <input
			type="hidden" value="0.0" name="taxAmount" tabindex="2"
			id="<%=taxAmount+""+inc%>" /> <% }%>
		</td>
		<td width="10%"><input type="hidden"
			value="<%=storePO.getAmount() %>" name="<%= COST_PRICE %>"
			id="<%=costPrice+""+inc%>" /> <input type="text" size="8"
			value="<%=storePO.getAmount() %>" name="<%=AMOUNT%>"
			id="<%=amtVar+""+inc%>" readonly="readonly" /> <input type="hidden"
			value="<%=storePO.getFreeQuantity() %>" name="<%=FREE_QTY %>"
			id="<%=freeQty+""+inc %>" /></td>

		<td width="10%"><select name="<%=FREE_ITEM %>"
			id="<%=freeItem+""+inc %>" tabindex="1" class="small">
			<option value="n" <%=HMSUtil.isSelected(storePO.getFreeItem(),"n")%>>No</option>
			<option value="y" <%=HMSUtil.isSelected(storePO.getFreeItem(),"y")%>>Yes</option>
		</select></td>

		<td width="40%"><input type="text" value="" size="8"
			name="<%=MANUFACTURING_DATE%>" id="<%=manufacturingDate+""+inc%>"
			MAXLENGTH="30" tabindex="1" readonly="readonly" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufacturingDate+""+inc %>'),event);" />
		</td>


		<td width="40%"><input type="text" value=""
			name="<%=EXPIRY_DATE%>" id="<%=expiryDate+""+inc %>" size="8"
			MAXLENGTH="30" tabindex="1" readonly="readonly" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.getElementById('<%=expiryDate+""+inc %>'),event);" />
		</td>
	</tr>
	<% inc++;
//}
}
%>
	<%
detailCounter=10;
temp=0;
idItem="idItem";
codeItem="codeItem";
nameItem="nameItem";
idAu="idAu";
idBrand="idBrand";
dispenseType = "dispenseType";
mdq = "mdq";
ratePerMdq = "ratePerMdq";
quantityInVar="quantityInVar";
taxVar="taxVar";
amountVar="amountVar";
unitRateVar="unitRateVar";
discountVar="discountVar";
idSection="idSection";
costPrice ="costPrice";
freeQty="freeQty";
manufacturerId="manufacturerId";
freeItem="freeItem";
manufacturingDate="manufacturingDate";
expiryDate="expiryDate";
brandId="brandId";
nameBrand="nameBrand";
batchNo="batchNo";
quanRec="quanRec";
amtVar="amtVar";
stockInVarTemp="stockInVarTemp";
lotNo="lotNo";
shelfLife="shelfLife";
expiry ="expiry";
vatTax="vatTax";
convertedStock = "convertedStock";
formula = "formula";
conversionFactor = "conversionFactor";
discountAmount = "discountAmount";
taxAmount = "taxAmount";



//if(inc<incTemp2){
//for(;inc<incTemp2;inc++){
%>
	<!--<tr>
<td width="5%"> <input type="checkbox" class="radioCheck" name="checkbox" value="" /> </td>
<td width="5%"><input type="text" size="2"	tabindex="1" value="<%=temp+inc%>"  name="<%=SR_NO%>" readonly="readonly" /></td>
<td width="10%">
<input type="text" size="8" name="<%=ITEM_CODE%>" tabindex="1" id="<%=codeItem+""+inc%>"  onblur="autocompleteBasedOnPvms(this.value,'<%=inc%>');"/>

<input type="hidden" name="flag" value="Grn" />
<input type="hidden" size="2" value="0"  name="<%=ITEM_ID%>" id="<%=idItem+""+inc%>" />
<input type="hidden" name="<%=DETAIL_ID %>" value="0" id="hdb" />
<input type="hidden" value=""  name="" id="<%=expiry+""+inc%>" />
<input type="hidden" value=""  name="" id="<%=formula+""+inc%>" />
<input type="hidden" value=""  name="" id="<%=conversionFactor+""+inc%>" />

</td>
<td width="10%">
<input type="text" value=""	tabindex="1" id="<%=nameItem+""+inc%>" class="bigcaption" onblur="if(fillSrNo('<%=inc %>')){checkForGrn(this.value, '<%=nameItem%>','<%=inc %>');}" name="<%=nameItem%>" />
<div id="ac3update" class="autocomplete" style="display:none;"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
new Ajax.Autocompleter('<%=nameItem+""+inc%>','ac3update','stores?method=getItemListForGrnByAutocomplete',{parameters:'requiredField=<%=nameItem%>&indentId='+document.getElementById('indentCombo').value+'&sourceOfSupply= '+document.getElementById('sourceCombo').value});
</script>
</td>

<%--<td width="10%">
<select name="<%=BRAND_ID%>" tabindex="1" id="<%=brandId+""+inc%>">
<option value="">--select brand--</option>
</select>
</td> --%>

<td width="10%">
<select name="<%=MANUFACTURER_ID %>"  tabindex="1" id=<%=manufacturerId+""+inc%> >
<option value="">--select manuf--</option>
</select>

<td width="10%">
<input type="text" value=""size="8"  readonly="readonly" name="<%=AV%>" id="<%=idAu+""+inc%>" tabindex="1" size="5"/>
</td>

<td width="10%">
<input type="text" value=""size="8"  name="<%=BATCH_NO %>" id="<%=batchNo+""+inc %>" tabindex="1" size="5" />
</td>
<td width="10%">
			<input type="text" value="" size="15" name="barcodeNo" tabindex="1" id="barCodeNo<%=inc%>" value="" maxlength="35"/>


			</td>
<input type="hidden" value=""size="8"  name="<%=LOT_NO %>" tabindex="1" id="<%=lotNo+""+inc%>" maxlength="50"/>
<td width="10%">
<input type="text" value="" name="<%=LOT_NO %>" id="<%=lotNo+""+inc %>" tabindex="1" />
</td>
<td width="10%">
<input type="text" value="" size="8" name="<%=QUANTITY_RECEIVED %>" id="<%=quanRec+""+inc %>" tabindex="1"  size="5" />
</td>

<td width="10%">
<input type="text" value=""size="8" tabindex="1" name="<%=FREE_QTY %>" id="<%=freeQty+""+inc %>" size="5"  />
</td>


<td width="10%">
<select name="dispenseType" tabindex="1" id=<%=dispenseType+""+inc%>>
<option value="">--select dispen--</option>
</select>
</td>

<td width="10%">
<input type="hidden" value="1" readonly="readonly" size="8"  name="mdq"  id="<%=mdq+""+inc%>" tabindex="1" size="5"/>



<input type="text" value=""  name="ratePerMdq" id="<%=ratePerMdq+""+inc%>" tabindex="1"  onblur="calculationInCRVMod()" size="5" />
<input type="hidden" value=""size="8"  name="" readonly="readonly" tabindex="1" id="<%=ratePerMdq+""+inc%>"/>
</td>
<td width="10%">
<input type="text"size="8" value=""  name="dispencingPrice"  id="dispencingPrice<%=inc%>" onblur="calculationInCRVMod()"  tabindex="1" size="5" />
<input type="hidden" value=""  name="" readonly="readonly" tabindex="2" id="dispencingPrice<%=inc%>"/>
</td>
<td width="10%">
<input type="text"size="8" value=""  name="mrp"  id="mrp<%=inc%>" onblur="calculationInCRVMod()"  tabindex="1" size="5" />
<input type="hidden" value=""  name="" readonly="readonly" tabindex="2" id="dispencingPrice<%=inc%>"/>
</td>


<td width="3%">
<input type="text"  value=""size="8" name="convertedStock" id="<%=convertedStock+""+inc%>" tabindex="1" readonly="readonly" size="5"/>
</td>

<td width="3%">
<input type="text" size="8" value=""name="<%=DISCOUNT_PERCENTAGE%>" onblur="calculationInCRVMod();" tabindex="1" id="<%=discountVar+""+inc%>" size="5" />
<input type="hidden"  value="" name="discountAmount" id="<%=discountAmount+""+inc%>" />
</td>

<td width="10%">
<input type="text" size="8" value=""  name="<%=TAX_PERCENT %>"  onblur="calculationInCRVMod();" tabindex="1" id="<%=taxVar+""+inc%>" size="5" />
<input type="hidden"  value="" name="taxAmount" id="<%=taxAmount+""+inc%>" />
</td>
<td width="10%">
<input type="hidden" value="0" tabindex="1"  name="<%= COST_PRICE %>" id="<%=costPrice+""+inc%>"/>
<input type="text"	size="8"value="0"  name="<%=AMOUNT%>" id="<%=amtVar+""+inc%>" readonly="readonly" size="5" />
</td>

<td width="10%">
<select name="<%=FREE_ITEM %>" id="<%=freeItem+""+inc %>"  tabindex="1"  class="small">
<option value="n">No</option>
<option value="y">Yes</option>
</select>
</td>

<td width="40%">
<input type="text" name="<%=MANUFACTURING_DATE%>" id="<%=manufacturingDate+""+inc%>"   MAXLENGTH="30" size="8" tabindex="1"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" tabindex="1"  onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufacturingDate+""+inc %>'),event);"/>
</td>


<td width="40%">
<input type="text" name="<%=EXPIRY_DATE%>" id="<%=expiryDate+""+inc %>"   MAXLENGTH="30" tabindex="1" size="8"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" tabindex="1"  onClick="setdate('<%=currentDate%>',document.getElementById('<%=expiryDate+""+inc %>'),event);"/>
</td>

</tr>
-->
	<%// }
//}
%>

	<input type="hidden" name="" id="poListSize" value="<%=inc-1%>" />

	<%}
%>


</table>
</div>
<div class="clear"></div>
<%
if (map.get("gridGrnMList") != null) {
gridGrnMList = (List<StoreGrnM>)map.get("gridGrnMList");
}
StoreGrnM grnMObj = null;

if(gridGrnMList.size() > 0){
grnMObj = (StoreGrnM)gridGrnMList.get(0);
grnId = grnMObj.getId();
}

%>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input
	type="hidden" name="rows" id="rr" value="1" />
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
<script type="text/javascript">
<!--
// Main vBulletin Javascript Initialization
vBulletin_init();
//-->
</script>






