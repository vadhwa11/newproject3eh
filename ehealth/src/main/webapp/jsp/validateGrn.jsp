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
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
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
function checkForRecQty(){

for(i=1;i<=document.getElementById('noOfRows').value;i++)
{
var grnQty = parseFloat(document.getElementById('grnQty'+i).value);

var qtyRecd=parseFloat(document.getElementById('quanRec'+i).value);
var indentCombo=document.getElementById("indentCombo").value;
if(indentCombo!=""){
if(grnQty<qtyRecd)
{

alert("Qty Recieved should be not greater than  GrnQty in row"+i);
document.getElementById('quanRec'+i).focus();
return false;
}
}

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
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<div class="search" id="threadsearch"><a href=""></a> <script
	type="text/javascript"> vbmenu_register("threadsearch"); </script></div>
<div class="clear"></div>
<!-- thread search menu -->
<form name="searchPanel" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<div class="paddingTop15"></div>
<%--
<input type="button" name="Add" type="submit"  value="Add" class="toolbutton">
<input type="button" name="Reset" type="submit" value="Reset" class="toolbutton" >
<input type="button" name="Delete" type="submit"  value="Delete" class="toolbutton" >
<input type="button" name="print" type="submit" class="toolbutton" value=" " onClick="">
--%> <input type="hidden" name="s"
	value="cccfbaab0a70ed43fad9de8e3733112d" /> <input type="hidden"
	name="do" value="process" /> <input type="hidden" name="searchthread"
	value="1" /> <input type="hidden" name="showposts" value="1" /> <input
	type="hidden" name="searchthreadid" value="85875" /> <label>From
Date</label> <input type="text" name="<%= FROM_DATE %>"
	value="<%= currentDate %> " class="date" MAXLENGTH="30" / tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.indent.<%= FROM_DATE%>,event)" />

<label>To Date</label> <input type="text" name="<%= TO_DATE %>"
	value="<%= currentDate %> " class="date" MAXLENGTH="30" tabindex=1 />

<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.indent.<%= TO_DATE%>,event)" />

<div class="clear"></div>
<div class="paddingTop15"></div>


<label>GRN No.</label> <input type="text" name="<%=GRN_NO%>" value=""
	tabindex=1 MAXLENGTH="100" id="<%=GRN_NO%>" />
<div id="ac5update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
new Ajax.Autocompleter('<%=GRN_NO%>','ac5update','stores?method=getGrnNoListForAutoComplete',{parameters:'requiredField=<%=GRN_NO%>'});
</script> <input type="image" class="button" onClick="submitForm('indent','stores?method=searchGrn');" />
</div>
		</form>
</form>
<div class="clear"></div>
<form name="indentGrid" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 

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


<h4>GRN Details</h4>
<div class="clear"></div>
<div class="Block">
<h4><span><%=messageTOBeVisibleToTheUser %></span></h4>


<label><span>*</span> Source of Supply</label> <select
	name="<%=SOURCE_OF_SUPPLY%>" id="sourceCombo" tabindex=1
	validate="Source of Supply,String,yes">
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
</select> <label>GRN Number</label> <% if(grnMObj.getGrnNo() != null){ %> <input
	type="text" name="<%= GRN_NO %>" value="<%=grnMObj.getGrnNo()%>"
	class="readOnly" readonly="readonly" validate="GRN Number ,String,no"
	tabindex=1 /> <input type="hidden" name="parent" id="parent"
	value="<%=grnMObj.getId()%>" validate="" tabindex=1 /> <%}else{ %> <input
	type="text" name="<%= GRN_NO %>" value=""
	validate="GRN Number ,String,no" tabindex=1 /> <%} %> <label>GRN
Date</label> <%if(grnMObj.getGrnDate() != null){ %> <input type="text"
	name="<%=GRN_DATE%>" value="<%=HMSUtil.convertDateToStringTypeDateOnly(grnMObj.getGrnDate()) %>"
	class="readOnly" readonly="readonly" tabindex=1
	validate="GRN Date ,String,no" /> <%}else{ %> <input type="text"
	name="<%=GRN_DATE%>" value="<%=currentDate %>" class="readOnly"
	readonly="readonly" tabindex=1 validate="GRN Date ,String,no" /> <%} %>
<div class="clear"></div>
<label>Unit/Ven.Name:</label> <%if(!grnMObj.getReceiveType().equals("l")){%>
<select name="<%= SUPPLIER_ID %>" validate="Unit/Ven.Name,string,no"
	tabindex=1>
	<%
	if(grnMObj.getSupplier()!=null){
	for(MasStoreSupplier masSupplier:supplierList){

if(grnMObj.getSupplier().getId().equals(masSupplier.getId())){
%>
	<option value="<%=masSupplier.getId() %>" selected="selected"><%=masSupplier.getSupplierName()%></option>
	<%}else{ %>
	<option value="<%=masSupplier.getId() %>"><%=masSupplier.getSupplierName()%></option>
	<%}}}%>
</select> <%}else{ %> <select name="<%= SUPPLIER_ID %>" id="<%= SUPPLIER_ID%>"
	validate="Unit/Ven.Name,string,no" disabled tabindex=1>
	<%
	if(grnMObj.getSupplier()!=null){
	for(MasStoreSupplier masSupplier:supplierList){

if(grnMObj.getSupplier().getId().equals(masSupplier.getId())){
%>
	<option value="<%=masSupplier.getId() %>" selected="selected"><%=masSupplier.getSupplierName()%></option>
	<%}else{ %>
	<option value="<%=masSupplier.getId() %>"><%=masSupplier.getSupplierName()%></option>
	<%}}
	}%>
</select> <%} %> <%if(grnMObj.getReceiveType().equals("l")){%> <label>SO No.</label>
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
	type="hidden" name="temp" id="temp" value="" /> <% }%> <%if(grnMObj.getIndent()!=null && grnMObj.getReceiveType().equals("p") || grnMObj.getReceiveType().equals("a")) { %>
<label>Indent No.</label> <input type="text" name="<%=INDENT_ID %>"
	class="readOnly" readonly id="<%=INDENT_ID %>"
	value="<%=grnMObj.getIndent().getIndentNo() %>" /> <%}else{ %> <input
	type="hidden" name="<%=INDENT_ID %>" readonly id="<%=INDENT_ID %>"
	value="" /> <%} %>

<div class="clear"></div>

<%-- <label>Po No.</label>--%> <% if(grnMObj != null){%> <input id="test"
	type="hidden" name="<%=SUPPLY_ORDER_NO %>"
	value="<%=grnMObj.getAtSoNo() %>" MAXLENGTH="75" tabindex=1> <%}else{ %>
<input id="test" type="hidden" name="<%=SUPPLY_ORDER_NO %>" value=""
	MAXLENGTH="75" tabindex=1> <%} %>
<div class="clear"></div>

<div id="atsoDateDiv"><label>Po Date</label> <input id="dateTest"
	type="text" name="<%=AT_SO_DATE%>" readonly="readonly" id="atSoDate"
	value="<%=currentDate %>" MAXLENGTH="30" /> <%-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="javascript:setdate('<%=currentDate%>',document.grnGrid.<%=AT_SO_DATE%>,true)" />--%>
</div>
<label>Date Rec/Surp</label> <%if(grnMObj.getDateReceivedSurplus()!= null) {%>
<input type="text" class="date" name="<%=RECEIVED_DATE%>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(grnMObj.getDateReceivedSurplus())%>"
	tabindex=1 validate="surplus Date ,String,no" /> <%}else{ %> <input
	type="text" class="date" name="<%=RECEIVED_DATE%>" value=""
	readonly="readonly" tabindex=1 validate="surplus Date ,String,no" /> <%} %>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.indentGrid.<%=RECEIVED_DATE%>,event);" />

<label>Unpack/Checked by</label> <select name="<%=EMPLOYEE_ID%>"
	validate="Employee Name,string,no" tabindex=1>
	<option value="0">select</option>
	<%for(MasEmployee masEmployee:employeeList){

if(grnMObj.getEmployee().getId().equals(masEmployee.getId())){
%>
	<option value="<%=masEmployee.getId() %>" selected="selected"><%=masEmployee.getFirstName() + " " + masEmployee.getLastName()%></option>
	<%}else{ %>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+ " " +masEmployee.getLastName()%></option>
	<%}}%>
</select>

<div class="clear"></div>
<%--<label >R/R No. </label>
<% if(grnMObj.getRrNo()
!= null){ %>
<input	type="text"  name="<%=RR_NO %>" value="<%=grnMObj.getRrNo()%>" validate="rr Number ,String,no" tabindex=1 />
<%}else{ %>
<input	type="text"  name="<%=RR_NO %>" value=""  tabindex=1 />
<%} %>


<label >Transportation Mode</label>
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
	type="text" name="<%= HOW_RECEIVED %>" value="" tabindex=1 /> <%} %>

<div class="clear"></div>

<label>Remarks</label> <%if(grnMObj.getRemarks() != null){ %> <textarea
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
	tabindex=1 /> <%}%> <% if(grnMObj.getInvoiceDate() != null){ %> <label>Invoice
Date</label> <input type="text" class="date" name="<%= INVOICE_DATE %>"
	id="invoiceDate"
	value="<%=HMSUtil.convertDateToStringWithoutTime(grnMObj.getInvoiceDate())%>"
	tabindex=1 /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate%>',document.getElementById('<%=INVOICE_DATE%>'),event);" />
<%}%> <%
//if(grnMObj.getInvoiceAmount() != null && grnMObj.getInvoiceAmount().intValue()!= 0){ %>
<div class="clear"></div>

<label>Invoice Amount</label> <input type="text"
	name="<%= INVOICE_AMOUNT %>" id="<%=INVOICE_AMOUNT %>"
	value="<%=grnMObj.getInvoiceAmount()==null?"":grnMObj.getInvoiceAmount()%>"
	tabindex=1 /> <%//}%> <label>Freight Duty</label> <input type="text"
	name="<%=FREIGHT_DUTY %>" id="<%=FREIGHT_DUTY %>"
	value="<%=grnMObj.getFreightDuty()==null?"":grnMObj.getFreightDuty() %>"
	onblur="calculationInCRVMod()" tabindex=1 MAXLENGTH="8"/  > <label>Excise
Duty</label> <input type="text" name="<%=EXCISE_DUTY %>" id="<%=EXCISE_DUTY %>"
	value="<%=grnMObj.getExciseDuty()==null?"":grnMObj.getExciseDuty() %>"
	onblur="calculationInCRVMod()" tabindex=1 MAXLENGTH="8"/  >

<div class="clear"></div>

<label>Octroi</label> <input type="text" name="<%=OCTROI %>"
	id="<%=OCTROI %>"
	value="<%= grnMObj.getOctroi()==null?"":grnMObj.getOctroi()%>"
	onblur="calculationInCRVMod()" tabindex=1 MAXLENGTH="8"/  > <label>Insurance
Charge</label> <input type="text" name="<%=INSURANCE_CHARGES %>"
	id="<%=INSURANCE_CHARGES %>"
	value="<%=grnMObj.getInsuranceCharge()==null?"":grnMObj.getInsuranceCharge() %>"
	onblur="calculationInCRVMod()" tabindex=1 MAXLENGTH="8"/  > <label>Other
Charges</label> <input type="text" name="<%=OTHER_CHARGES %>"
	id="<%=OTHER_CHARGES %>"
	value="<%=grnMObj.getOtherCharges()==null?"":grnMObj.getOtherCharges() %>"
	onblur="calculationInCRVMod()" tabindex=1 MAXLENGTH="8"/  >

<div class="clear"></div>

<label>Custom Duty</label> <input type="text" name="<%=CUSTOM_DUTY %>"
	id="<%=CUSTOM_DUTY %>"
	value="<%=grnMObj.getCustomDuty()==null?"":grnMObj.getCustomDuty() %>"
	onblur="calculationInCRVMod()" tabindex=1 MAXLENGTH="8"/  >

<div class="clear"></div></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<%if(!grnMObj.getStatus().equalsIgnoreCase("v")) {%> <input type="button"
	name="validate" align="right" title="LEDGER ACC DONE" class="button"
	value="Validate"
	onclick="if(checkForCRVGrid() && testForGrn()&& checkloanin()&& checkForRecQty()&&checkSave()&& checkForSubmit()){submitForm('indentGrid','stores?method=updateCrv&validate=t&po_id=');}" />

<%}else{%>
<h4><%=validationMessage %></h4>

<%} %> <input type="hidden" name="<%=NO_DETAIL_RECORDS%>"
	value="<%=noDetailRecords%>" /> <input type="hidden" size="2"
	value="10" name="<%=NO_OF_ROWS %>" id="<%=NO_OF_ROWS %>" /> <input
	type="hidden" name="<%=GRN_ID %>" id="<%=GRN_ID%>" value="<%=grnId%>"
	id="hdb" />

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<div class="Block"><label> Total VAT Amount </label> <input
	type="text" name="vatTax" id="vatTax" value="<%=grnMObj.getVat()%>"
	MAXLENGTH="15" validate="Total VAT,float,no"
	onblur="calculationInCRVMod()" tabindex="1" /> <label> Total
Discount </label> <input type="text" name="totDiscount" id="totDiscount"
	value="<%=grnMObj.getDiscount() %>" MAXLENGTH="15"
	validate="Total Discount,float,no" onblur="calculationInCRVMod()"
	tabindex="1" /> <label> GRN Value </label> <input type="text"
	name="grnValue" id="grnValue"
	value="<%=grnMObj.getInvoiceAmount()==null?"":grnMObj.getInvoiceAmount()%>"
	class="textbox_size_medium" MAXLENGTH="15"
	validate="GRN Value,float,no" tabindex="1" />

<div class="clear"></div>

<label> Round O ff Value </label> <input type="text" name="roundOfValue"
	id="roundOfValue"
	value="<%=grnMObj.getRoundOffValue()==null?"":grnMObj.getRoundOffValue()%>"
	MAXLENGTH="15" tabindex="1" /> <input type="hidden"
	name="actualGrnValue" id="actualGrnValue" value="" /> <%if(grnMObj.getVat().intValue() != 0){ %>
<label>VAT Added</label> <input type="checkbox" class="radioCheck"
	name="vatApplicable" id="vatApplicable" value="1" checked tabindex=1
	onClick="calculationInCRVMod();" /> <%}else{ %> <label>VAT Added</label>
<input type="checkbox" class="radioCheck" name="vatApplicable"
	id="vatApplicable" value="1" tabindex=1
	onClick="calculationInCRVMod();" /> <%} %>
<div class="clear"></div>
</div>

<% } %>

<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>GRN</h4>
<div class="clear"></div>
<!--<input type="button" class="buttonDel" value="" title="DELETE ITEMS" onclick="removeRow(this,'purchaseDetails');" align="right" />
<label> delete Items</label>

-->
<div class="cmntable">
<table colspan="7" id="purchaseDetails">
	<tr>

		<!--<th width="5%"></th>
-->
		<th width="8%">Item Code</th>
		<th width="9%">Item Name</th>
		<th width="9%">Manuf. Name</th>
		<th width="9%">UOM</th>
		<th width="9%">Batch No</th>
		<th width="9%">BarCode No</th>
		<th width="9%">PO Qty</th>
		<th width="9%">Recd Qty</th>
		<th width="9%">Free Qty</th>
		<th width="9%">Dispen.Type</th>
		<!--
<th width="9%">MDQ</th>-->
		<th width="9%">Rate Per MDQ</th>
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
String grnQty="grnQty";
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



if(previousPage.equals("no")){
int inc=((pageNo-1)*40)+1;
int incTemp2=inc+40;
for(StoreGrnT storeGrnT : gridGrnTList){


if(inc<incTemp2){
BigDecimal grnQty2=new BigDecimal(0);
if(storeGrnT.getGrnQty()!=null){
grnQty2=storeGrnT.getGrnQty();
}


%>

	<%

%>
	<tr>
		<!--<td width="5%"> <input type="checkbox" class="radioCheck" name="checkbox" value="" /> </td>
-->
		<!--<td width="5%"><input type="text" size="2"	value="<%=storeGrnT.getSerialNo()%>"  name="<%=SR_NO%>" readonly="readonly" /></td>
-->
		<td width="10%">
		<%
		if(storeGrnT.getItem().getPvmsNo()!=null){ %> <input type="text"
			value="<%=storeGrnT.getItem().getPvmsNo() %>" name="<%=ITEM_CODE %>"
			onblur="autocompleteBasedOnPvms(this.value,'<%=inc%>');"
			id="<%=codeItem+""+inc%>" size="5" /> <%}else{ %> <input type="text"
			value=" " name="<%=ITEM_CODE %>" id="<%=codeItem+""+inc%>" size="8" />
		<%} %> <input type="hidden" name="flag" value="Grn" /> <input
			type="hidden" name="<%=DETAIL_ID %>" value="<%=storeGrnT.getId() %>"
			id="hdb" /> <input type="hidden"
			value="<%=storeGrnT.getItem().getId()%>" name="<%=ITEM_ID%>"
			id="<%=idItem+""+inc%>" /> <input type="hidden" value="" name=""
			id="<%=expiry+""+inc%>" /> <input type="hidden" value="" name=""
			id="<%=formula+""+inc%>" /> <input type="hidden" value="" name=""
			id="<%=conversionFactor+""+inc%>" /></td>

		<td width="10%"><input type="text"
			value="<%=storeGrnT.getItem().getNomenclature() %>"
			id="<%=nameItem+""+inc%>" class="bigcaption"
			onblur="if(fillSrNo('<%=inc %>')){checkForGrn(this.value, '<%=nameItem%>','<%=inc %>');}"
			name="<%=nameItem%>" />
		<div id="ac2update" class="autocomplete" style="display: none;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
new Ajax.Autocompleter('<%=nameItem+""+inc%>','ac2update','stores?method=getItemListForGrnByAutocomplete',{parameters:'requiredField=<%=nameItem%>&indentId='+document.getElementById('indentCombo').value+'&sourceOfSupply= '+document.getElementById('sourceCombo').value});
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
			<option value="">Select</option>
			<%} %>
		</select>
		<%
		String conversionPoUnit="";
		if(storeGrnT.getItem().getItemConversion()!=null){
			conversionPoUnit=storeGrnT.getItem().getItemConversion().getPurchaseUnit().getUnitName();
		}
		%>
		<td width="10%"><input type="text" size="8"
			value="<%=conversionPoUnit %>"
			readonly="readonly" name="<%=AV%>" id="<%=idAu+""+inc%>" size="5" /></td>

		<td width="10%"><input type="text" size="8"
			value="<%=storeGrnT.getBatchNo() %>" size="5" name="<%=BATCH_NO %>"
			id="<%=batchNo+""+inc %>" tabindex="2" />
			<%
			int deptId=0;
			if(storeGrnT.getItem().getDepartment()!=null){
				deptId=storeGrnT.getItem().getDepartment().getId();
			}
			%>
			<input type="hidden" name="storeDept" id="storeDept<%=inc %>" value="<%=deptId %>"/>
			</td>
		<td width="10%"><input type="text" size="15" name="barcodeNo"
			tabindex="1" id="barCodeNo<%=inc%>"
			value="<%=storeGrnT.getBarcodeNo() %>" maxlength="35" /></td>
		<input type="hidden" value="<%=storeGrnT.getLotNo() %>"
			name="<%=LOT_NO %>" tabindex="1" id="<%=lotNo+""+inc%>"
			maxlength="50" /> <%--
<td width="10%">
<input type="text" value="<%=storeGrnT.getLotNo() %>"  name="<%=LOT_NO %>" id="<%=lotNo+""+inc %>" tabindex="1" />
</td> --%>
		<td width="10%"><input type="text" size="8" value="<%=grnQty2 %>"
			name="<%=grnQty+""+inc %>" id="<%=grnQty+""+inc %>" tabindex="1"
			size="5" /></td>
		<td width="10%"><input name="<%=QUANTITY_RECEIVED %>" type="text"
			id="<%=quanRec+""+inc %>" tabindex="1"
			value="<%=storeGrnT.getReceivedQty() %>" size="5" /></td>
		<td width="10%"><input name="<%=FREE_QTY %>" type="text"
			id="<%=freeQty+""+inc %>" value="<%=storeGrnT.getFreeQty() %>"
			size="8" readonly="readonly" /></td>
		<td width="10%"><select name="dispenseType"
			id=<%=dispenseType+""+inc%> tabindex="1">
			<option value="<%=storeGrnT.getDispType()%>"><%=storeGrnT.getDispType()%></option>
		</select>
		<td width="10%"><input name="mdq" type="hidden"
			id="<%=mdq+""+inc%>" readonly="readonly" tabindex="1" value="1"
			size="8" /> <input type="hidden" value="" name=""
			readonly="readonly" tabindex="2" id="<%=mdq%>" /> <input
			name="ratePerMdq" type="text" size="8" id="<%=ratePerMdq+""+inc%>"
			tabindex="1" onblur="calculationInCRVMod()"
			value="<%=storeGrnT.getRatePerMdq()%>" size="5" /> <input
			type="hidden" value="" name="" readonly="readonly" tabindex="2"
			id="<%=ratePerMdq+""+inc%>" /></td>
		<td width="10%"><input name="dispencingPrice" type="text"
			size="8" id="dispencingPrice<%=inc%>" tabindex="1"
			onblur="calculationInCRVMod()"
			value="<%=storeGrnT.getDispencingPrice()%>" size="5" /> <input
			type="hidden" value="" name="" readonly="readonly" tabindex="2"
			id="dispencingPrice<%=inc%>" /></td>
		<td width="10%"><input name="mrp" type="text" size="8"
			id="mrp<%=inc%>" tabindex="1" onblur="calculationInCRVMod()"
			value="<%=storeGrnT.getMrp()%>" size="5" /> <input type="hidden"
			value="" name="" readonly="readonly" tabindex="2" id="mrp<%=inc%>" />
		</td>

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
	if(storeGrnT.getItem().getItemConversion().getFormula()!=null){
		formulaValue = storeGrnT.getItem().getItemConversion().getFormula();
	}else{
		formulaValue = "";
	}
}
catch(Exception e)
{
formulaValue = "";
}


try
{
conversionFactorValue = storeGrnT.getItem().getItemConversion().getConversionFactor1();
}
catch(Exception e)
{
conversionFactorValue = 1;
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


if(!discount.toString().equals("0.0000")){
discountPercent = (discount.multiply(new BigDecimal(100))).divide(amount, 2, RoundingMode.HALF_UP);
}

if(!tax.toString().equals("0.0000")){
taxPercent = (tax.multiply(new BigDecimal(100))).divide(amount, 2, RoundingMode.HALF_UP);
}

BigDecimal convertedStockValue = new BigDecimal(0);

if (formulaValue.equals("1"))
{
convertedStockValue = qty.multiply(new BigDecimal(mdqValue)).divide(new BigDecimal(conversionFactorValue), 2, RoundingMode.HALF_UP);
}
else if (formulaValue.equals("2"))
{
convertedStockValue = qty;
}else{
	convertedStockValue = qty;
}
%>

		<td width="3%"><input name="convertedStock" type="text" size="8"
			id="<%=convertedStock+""+inc%>" tabindex="1"
			value="<%= convertedStockValue%>" size="5" /> <input type="hidden"
			value="<%=storeGrnT.getUnitRate() %>" name="<%=UNIT_RATE%>"
			tabindex="2" id="<%=unitRateVar+""+inc%>" /></td>

		<td width="3%"><input name="<%=DISCOUNT_PERCENTAGE%>" size="8"
			type="text" id="<%=discountVar+""+inc%>" tabindex="1"
			onblur="calculationInCRVMod()" value="<%=discountPercent %>" size="5" />
		<input type="hidden" value="<%=storeGrnT.getDiscount() %>"
			name="discountAmount" tabindex="2" id="<%=discountAmount+""+inc%>" />
		</td>

		<td width="10%"><input name="<%=TAX_PERCENT %>" type="text"
			size="8" id="<%=taxVar+""+inc%>" tabindex="1"
			onblur="calculationInCRVMod()" value="<%=taxPercent %>" size="5" />
		<input type="hidden" value="<%=storeGrnT.getTax() %>" name="taxAmount"
			tabindex="2" id="<%=taxAmount+""+inc%>" /></td>
		<td width="10%"><input type="hidden"
			value="<%=storeGrnT.getAmountValue() %>" name="<%= COST_PRICE %>"
			id="<%=costPrice+""+inc%>" /> <input name="<%=AMOUNT%>" type="text"
			id="<%=amtVar+""+inc%>" value="<%=storeGrnT.getAmountValue() %>"
			size="5" readonly="readonly" /> <input type="hidden"
			value="<%=storeGrnT.getFreeQty() %>" name="<%=FREE_QTY %>"
			id="<%=freeQty+""+inc %>" /></td>

		<td width="10%"><select name="<%=FREE_ITEM %>" size="8"
			class="small" id="<%=freeItem+""+inc %>" tabindex="1">
			<option value="n"
				<%=HMSUtil.isSelected(storeGrnT.getFreeItem(),"n")%>>No</option>
			<option value="y"
				<%=HMSUtil.isSelected(storeGrnT.getFreeItem(),"y")%>>Yes</option>
		</select></td>

		<td width="40%"><input name="<%=MANUFACTURING_DATE%>" type="text"
			id="<%=manufacturingDate+""+inc%>" tabindex="1"
			value="<%=storeGrnT.getManufacturerDate()==null?"":HMSUtil.convertDateToStringWithoutTime(storeGrnT.getManufacturerDate())%>"
			size="8" MAXLENGTH="30" readonly="readonly" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufacturingDate+""+inc %>'),event);" />
		</td>


		<td width="40%"><input name="<%=EXPIRY_DATE%>" type="text"
			id="<%=expiryDate+""+inc %>" tabindex="1"
			value="<%=storeGrnT.getExpiryDate()==null?"":HMSUtil.convertDateToStringWithoutTime(storeGrnT.getExpiryDate())%>"
			size="8" MAXLENGTH="30" readonly="readonly" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.getElementById('<%=expiryDate+""+inc %>'),event);" />
		</td>
	</tr>
	<% inc++;
}
}
%>
	<script>

document.indentGrid.noOfRows.value=<%=inc-((pageNo-1)*10)-1%>
</script>


	<%
//for(StorePoDetail storePO : poList){

//if(inc<incTemp2){
%>

	<%

%>
	<!--<tr>
<td width="5%"> <input type="checkbox" class="radioCheck" name="checkbox" value="" /> </td>
<td width="5%"><input type="text" size="2"	value=""  name="<%=SR_NO%>" readonly="readonly" /></td>
<td width="10%">
<%//if(storePO.getItem().getPvmsNo()!=null){ %>
<input type="text" value="<%//=storePO.getItem().getPvmsNo() %>"  name="<%=ITEM_CODE %>" onblur="autocompleteBasedOnPvms(this.value,'<%=inc%>');" id="<%=codeItem+""+inc%>" size="5" />
<%//}else{ %>
<input type="text" value=" "  name="<%=ITEM_CODE %>"  id="<%=codeItem+""+inc%>"  size="5"/>
<%//} %>
<input type="hidden" name="flag" value="Grn" />

<input type="hidden" name="<%=DETAIL_ID %>" value="" id="hdb" />
<input type="hidden" value="<%//=storePO.getItem().getId()%>"  name="<%=ITEM_ID%>" id="<%=idItem+""+inc%>" />
<input type="hidden" value=""  name="" id="<%=expiry+""+inc%>" />
<input type="hidden" value=""  name="" id="<%=formula+""+inc%>" />
<input type="hidden" value=""  name="" id="<%=conversionFactor+""+inc%>" />

</td>

<td width="10%">
<input type="text" value="<%//=storePO.getItem().getNomenclature() %>"	id="<%=nameItem+""+inc%>" class="bigcaption" onblur="if(fillSrNo('<%=inc %>')){checkForGrn(this.value, '<%=nameItem%>','<%=inc %>');}" name="<%=nameItem%>" />
<div id="ac2update" style="display:none; " class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
new Ajax.Autocompleter('<%=nameItem+""+inc%>','ac2update','stores?method=getItemListForGrnByAutocomplete',{parameters:'requiredField=<%=nameItem%>&indentId='+document.getElementById('indentCombo').value+'&sourceOfSupply= '+document.getElementById('sourceCombo').value});
</script>
</td>

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

<td width="10%">
<select name="<%=MANUFACTURER_ID %>" id=<%=manufacturerId+""+inc%> tabindex="1">
<%-- <option value="<%=mId%>"><%=manufacturer%></option>--%>
</select>

<td width="10%">
<input type="text" value="<%//=storePO.getItem().getItemConversion().getPurchaseUnit().getUnitName() %>"	  readonly="readonly" name="<%=AV%>"  id="<%=idAu+""+inc%>" size="5"/></td>

<td width="10%">
<input type="text" value="" size="5"  name="<%=BATCH_NO %>" id="<%=batchNo+""+inc %>" tabindex="2" />
</td>
<td width="10%">
			<input type="text" value="" size="15" name="barcodeNo" tabindex="1" id="barCodeNo<%=inc%>" value="" maxlength="35"/>


			</td>
<input type="hidden" value=""  name="<%=LOT_NO %>" tabindex="1" id="<%=lotNo+""+inc%>" maxlength="50"/>

<td width="10%">
<input type="text" value=""  name="<%=LOT_NO %>" id="<%=lotNo+""+inc %>" tabindex="1" />
</td>

 <td width="10%">
<input type="text" value="<%//=storePO.getQuantityOrdered() %>"  name=" <%=grnQty+""+inc %>" size="5" id=" <%=grnQty+""+inc %>" tabindex="1" />
</td>


<td width="10%">
<input  name="<%=QUANTITY_RECEIVED %>" type="text" id="<%=quanRec+""+inc %>" tabindex="1" value="<%//=storePO.getQuantityOrdered() %>" size="5" />
</td>
<td width="10%">
<input name="<%=FREE_QTY %>" type="text" id="<%=freeQty+""+inc %>" value="0" size="5"  readonly="readonly" />
</td>
<td width="10%">
<select name="dispenseType" id=<%=dispenseType+""+inc%> tabindex="1">
<option value="<%//=storePO.getDispType()%>"><%//=storePO.getDispType()%></option>
</select>
<td width="10%">
<input  name="mdq" type="hidden"readonly="readonly"  id="<%=mdq+""+inc%>" tabindex="1" value="1" size="5" />
<input type="hidden" value=""  name="" tabindex="2" id="<%=mdq%>"/>

<input  name="ratePerMdq" type="text"  id="<%=ratePerMdq+""+inc%>"  tabindex="1" onblur="calculationInCRVMod()" value="<%//=storePO.getRatePerMdq()%>" size="5" />
<input type="hidden" value=""  name="" readonly="readonly" tabindex="2" id="<%=ratePerMdq+""+inc%>"/>
</td>
<td width="10%">
<input  name="dispencingPrice" type="text"  id="dispencingPrice<%=inc%>"  tabindex="1" onblur="calculationInCRVMod()" value="" size="5" />
<input type="hidden" value=""  name="" readonly="readonly" tabindex="2" id="dispencingPrice<%=inc%>"/>
</td>
<td width="10%">
<input  name="mrp" type="text"  id="mrp<%=inc%>"  tabindex="1" onblur="calculationInCRVMod()" value="" size="5" />
<input type="hidden" value=""  name="" readonly="readonly" tabindex="2" id="mrp<%=inc%>"/>
</td>
<%
//BigDecimal tax = new BigDecimal(0);
//BigDecimal discount = new BigDecimal(0);
//BigDecimal qty = new BigDecimal(0);
//BigDecimal rate = new BigDecimal(0);
///BigDecimal amount  = new BigDecimal(0);
//BigDecimal amountAfterTax = new BigDecimal(0);
//BigDecimal amountAfterdis = new BigDecimal(0);

//int mdqValue = 1;
//String formulaValue = "";
//int conversionFactorValue = 0;

//float taxPercent = 0f;
//float discountPercent = 0f;


//try
//{
//qty = storePO.getQuantityOrdered();
//}
//catch(Exception e)
//{
//qty = new BigDecimal(0);
//}

//try
//{
//rate = storePO.getRatePerMdq();
//}
//catch(Exception e)
//{
//rate = new BigDecimal(0);
//}

//try
//{
//tax = storePO.getTaxAmount();
//}
//catch(Exception e)
//{
//tax = new BigDecimal(0);
//}

/**  try
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
mdqValue = 1;
}



amount = qty.multiply(rate);
amountAfterTax = amount.add(tax);
//	amountAfterdis = amount.subtract(discount);


//	discountPercent = discount.divide(amount).multiply(new BigDecimal(100)).floatValue();
//	taxPercent = tax.divide(amountAfterdis).multiply(new BigDecimal(100)).floatValue();
BigDecimal convertedStockValue = new BigDecimal(0);

if (formulaValue.equals("1"))
{
convertedStockValue = qty.multiply(new BigDecimal(mdqValue)).divide(new BigDecimal(conversionFactorValue), 2, RoundingMode.HALF_UP);
}
else if (formulaValue.equals("2"))
{
convertedStockValue = qty;
} */

%>

<td width="3%">
<input name="convertedStock" type="text" id="<%=convertedStock+""+inc%>" tabindex="1"  value="<%//= convertedStockValue%>" size="5" />
<input type="hidden"  value="<%//=storePO.getUnitRate() %>" name="<%=UNIT_RATE%>" tabindex="2" id="<%=unitRateVar+""+inc%>"/>
</td>

<td width="3%">
<%//if(storePO.getDiscountPercent() != null){ %>
<input  name="<%=DISCOUNT_PERCENTAGE%>" type="text" id="<%=discountVar+""+inc%>"  tabindex="1" onblur="calculationInCRVMod()"  value="<%//=storePO.getDiscountPercent() %>" size="5" />
<input type="hidden"  value="<%//=storePO.getDiscountAmount() %>" name="discountAmount" tabindex="2" id="<%=discountAmount+""+inc%>"/>
<%//} else{ %>
<input  name="<%=DISCOUNT_PERCENTAGE%>" type="text" id="<%=discountVar+""+inc%>"  tabindex="1" onblur="calculationInCRVMod()"  value="0.0" size="5" />
<input type="hidden"  value="0.0" name="discountAmount" tabindex="2" id="<%=discountAmount+""+inc%>"/>
<% //} %>
</td>

<td width="10%">
<%//if(storePO.getTaxPercent() != null){ %>
<input  name="<%=TAX_PERCENT %>" type="text"  id="<%=taxVar+""+inc%>"  tabindex="1" onblur="calculationInCRVMod()" value="<%//=storePO.getTaxPercent() %>" size="5"  />
<input type="hidden"	value="<%//=storePO.getTaxAmount() %>"  name="taxAmount" tabindex="2" id="<%=taxAmount+""+inc%>"/>
<%//} else{ %>
<input  name="<%=TAX_PERCENT %>" type="text"  id="<%=taxVar+""+inc%>"  tabindex="1" onblur="calculationInCRVMod()" value="0.0" size="5" />
<input type="hidden"	value="0.0"  name="taxAmount" tabindex="2" id="<%=taxAmount+""+inc%>"/>
<%// }%>
</td>
<td width="10%">
<input type="hidden" value="<%//=storePO.getAmount() %>"  name="<%= COST_PRICE %>" id="<%=costPrice+""+inc%>"/>
<input  name="<%=AMOUNT%>" type="text" id="<%=amtVar+""+inc%>"	value="<%//=storePO.getAmount() %>" size="5" readonly="readonly"/>

<input type="hidden" value="<%//=storePO.getFreeQuantity() %>" name="<%=FREE_QTY %>" id="<%=freeQty+""+inc %>"/>
</td>

<td width="10%">
<select name="<%=FREE_ITEM %>" class="small" id="<%=freeItem+""+inc %>"  tabindex="1" >
<option value="n" <%//=HMSUtil.isSelected(storePO.getFreeItem(),"n")%>>No</option>
<option value="y" <%//=HMSUtil.isSelected(storePO.getFreeItem(),"y")%>>Yes</option>
</select>
</td>

<td width="40%">
<input name="<%=MANUFACTURING_DATE%>" type="text" id="<%=manufacturingDate+""+inc%>" tabindex="1" value="" size="8"   MAXLENGTH="30" readonly="readonly"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufacturingDate+""+inc %>'),event);"/>
</td>


<td width="40%">
<input name="<%=EXPIRY_DATE%>" type="text" id="<%=expiryDate+""+inc %>" tabindex="1" value="" size="8"   MAXLENGTH="30" readonly="readonly"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onClick="setdate('<%=currentDate%>',document.getElementById('<%=expiryDate+""+inc %>'),event);"/>
</td>

</tr>
-->
	<%// inc++;
//}
//}
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
grnQty="grnQty";
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
%><!--
<tr>
<td width="5%"> <input type="checkbox" class="radioCheck" name="checkbox" value="" /> </td>
<td width="5%"><input type="text" size="2"	tabindex="1" value="<%=temp+inc%>"  name="<%=SR_NO%>" readonly="readonly" /></td>
<td width="10%">
<input type="text"  name="<%=ITEM_CODE%>" tabindex="1" id="<%=codeItem+""+inc%>" size="5"  onblur="autocompleteBasedOnPvms(this.value,'<%=inc%>');"/>

<input type="hidden" name="flag" value="Grn" />
<input type="hidden" size="2" value="0"  name="<%=ITEM_ID%>" id="<%=idItem+""+inc%>" />
<input type="hidden" name="<%=DETAIL_ID %>" value="0" id="hdb" />
<input type="hidden" value=""  name="" id="<%=expiry+""+inc%>" />
<input type="hidden" value=""  name="" id="<%=formula+""+inc%>" />
<input type="hidden" value=""  name="" id="<%=conversionFactor+""+inc%>" />

</td>
<td width="10%">
<input type="text" value=""	tabindex="1" id="<%=nameItem+""+inc%>" class="bigcaption" onblur="if(fillSrNo('<%=inc %>')){checkForGrn(this.value, '<%=nameItem%>','<%=inc %>');}" name="<%=nameItem%>" />
<div id="ac2update" class="autocomplete" style="display:none;"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
new Ajax.Autocompleter('<%=nameItem+""+inc%>','ac2update','stores?method=getItemListForGrnByAutocomplete',{parameters:'requiredField=<%=nameItem%>&indentId='+document.getElementById('indentCombo').value+'&sourceOfSupply= '+document.getElementById('sourceCombo').value});
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
<input type="text" value=""  readonly="readonly" name="<%=AV%>" id="<%=idAu+""+inc%>" tabindex="1" size="5"/>
</td>

<td width="10%">
<input type="text" value=""  name="<%=BATCH_NO %>" id="<%=batchNo+""+inc %>" tabindex="1" size="5" />
</td>
<td width="10%">
			<input type="text" value="" size="15" name="barcodeNo" tabindex="1" id="barCodeNo<%=inc%>" value="" maxlength="35"/>


			</td>
<input type="hidden" value=""  name="<%=LOT_NO %>" tabindex="1" id="<%=lotNo+""+inc%>" maxlength="50"/>
<td width="10%">
<input type="text" value="" name="<%=LOT_NO %>" id="<%=lotNo+""+inc %>" tabindex="1" />
</td>

<td width="10%">
<input  name="<%=grnQty+""+inc %>" type="text" id="<%=grnQty+""+inc %>" tabindex="1" value="" size="5" />
</td>
<td width="10%">
<input  name="<%=QUANTITY_RECEIVED %>" type="text" id="<%=quanRec+""+inc %>" tabindex="1" value="" size="5" />
</td>

<td width="10%">
<input name="<%=FREE_QTY %>" type="text" id="<%=freeQty+""+inc %>" tabindex="1" value="" size="5"  />
</td>


<td width="10%">
<select name="dispenseType" tabindex="1" id=<%=dispenseType+""+inc%>>
<option value="">--select dispen--</option>
</select>
</td>

<td width="10%">
<input  name="mdq" type="hidden" value="1"  readonly="readonly"  id="<%=mdq+""+inc%>" tabindex="1" value="1" size="5"/>

<input  name="ratePerMdq" type="text" id="<%=ratePerMdq+""+inc%>" tabindex="1"  onblur="calculationInCRVMod()" value="" size="5" />
<input type="hidden" value=""  name="" readonly="readonly" tabindex="1" id="<%=ratePerMdq+""+inc%>"/>
</td>
<td width="10%">
<input  name="dispencingPrice" type="text" id="dispencingPrice<%=inc%>" tabindex="1"  onblur="calculationInCRVMod()" value="" size="5" />
<input type="hidden" value=""  name="" readonly="readonly" tabindex="1" id="dispencingPrice<%=inc%>"/>
</td>
<td width="10%">
<input  name="mrp" type="text" id="mrp<%=inc%>" tabindex="1"  onblur="calculationInCRVMod()" value="" size="5" />
<input type="hidden" value=""  name="" readonly="readonly" tabindex="1" id="mrp<%=inc%>"/>
</td>


<td width="3%">
<input name="convertedStock" type="text" id="<%=convertedStock+""+inc%>" tabindex="1"  value="" size="5" readonly="readonly"/>
</td>

<td width="3%">
<input type="text" size="5"  value="" name="<%=DISCOUNT_PERCENTAGE%>" onblur="calculationInCRVMod();" tabindex="1" id="<%=discountVar+""+inc%>" />
<input type="hidden"  value="" name="discountAmount" id="<%=discountAmount+""+inc%>" />
</td>

<td width="10%">
<input  name="<%=TAX_PERCENT %>" type="text" id="<%=taxVar+""+inc%>" tabindex="1"  onblur="calculationInCRVMod();" value="" size="5" />
<input type="hidden"  value="" name="taxAmount" id="<%=taxAmount+""+inc%>" />
</td>
<td width="10%">
<input type="hidden" value="0" tabindex="1"  name="<%= COST_PRICE %>" id="<%=costPrice+""+inc%>"/>
<input  name="<%=AMOUNT%>" type="text" id="<%=amtVar+""+inc%>"	value="0" size="5" readonly="readonly"/>
</td>

<td width="10%">
<select name="<%=FREE_ITEM %>" class="small" id="<%=freeItem+""+inc %>"  tabindex="1" >
<option value="n">No</option>
<option value="y">Yes</option>
</select>
</td>

<td width="40%">
<input name="<%=MANUFACTURING_DATE%>" type="text" id="<%=manufacturingDate+""+inc%>" tabindex="1" size="8"   MAXLENGTH="30"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" tabindex="1"  onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufacturingDate+""+inc %>'),event);"/>
</td>


<td width="40%">
<input name="<%=EXPIRY_DATE%>" type="text" id="<%=expiryDate+""+inc %>" tabindex="1" size="8"   MAXLENGTH="30"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" tabindex="1"  onClick="setdate('<%=currentDate%>',document.getElementById('<%=expiryDate+""+inc %>'),event);"/>
</td>

</tr>
-->
	<% //}
//}
%>


	<%}//this is if(previousPage.equals("no")) end
else{}%>

</table>

</div>

<div class="clear"></div>
<div class="paddingTop15"></div>

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
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></form>
<script type="text/javascript">
<!--
// Main vBulletin Javascript Initialization
vBulletin_init();
//-->
</script>
<input type="hidden" name="rows" id="rr" value="1" />





