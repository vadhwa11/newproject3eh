<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<script type="text/javascript">
<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>
<script>


</script>

<form name="stockRegisterReport" method="post">
<div class="titleBg">
<h2>Item Details </h2>
</div>
<div class="clear"></div>
 



<div class="clear" ></div>

<label>Prescribed Qty </label> 
<input type="text"	name="" value="3" readonly="readonly"	maxlength="30" tabindex=1 />
<div class="clear"></div>
<div class="clear"></div>

<table>
<tr><th>SI No.</th><th>Batch No.</th><th>Expiry Date</th><th>Unit Price</th><th>Dispencing Price</th><th>Stock Quantity</th><th>Item Issued</th></tr>
<tr><td>1</td><td>DR34419</td><td>28/02/2016</td><td>2</td><td>2</td><td>1010</td><td><input type="text"	name=""  	maxlength="30" tabindex=1 /></td></tr>
<tr><td>2</td><td>DDDB2A </td><td>28/02/2017</td><td>2</td><td>2</td><td>1300</td><td><input type="text"	name=""  	maxlength="30" tabindex=1 /></td></tr>
<tr><td>3</td><td>DD153 </td><td>28/02/2018</td><td>2</td><td>2</td><td>3100</td><td><input type="text"	name=""  	maxlength="30" tabindex=1 /></td></tr>
<!-- <tr><td>4</td><td> 48004651</td><td>28/02/2017</td><td>2</td><td>2</td><td>3100</td><td><input type="text"	name=""  	maxlength="30" tabindex=1 /></td></tr>
<tr><td>5</td><td>OMA41215</td><td>28/02/2016</td><td>2</td><td>2</td><td>1200</td><td><input type="text"	name=""  	maxlength="30" tabindex=1 /></td></tr>
<tr><td>6</td><td>:D-045141</td><td>28/11/2015</td><td>2</td><td>2</td><td>1200</td><td><input type="text"	name=""  	maxlength="30" tabindex=1 /></td></tr>
 -->
</table>
<div class="clear"></div>
<div class="clear"></div>

<!--  <input type="button" class="buttonBig" value="Generate Report"	onclick="submitForm('stockRegisterReport','/hms/hms/stores?method=printStockRegisterReport');"></input>-->
<input type="button" class="button" value="Issue"	onclick=""></input>
<input type="button" class="button" value="Cancel"	></input>
<input type="hidden" size="2" value="fgfg" name="noOfRecords"
	id="noOfRecords" />
<div class="clear paddingTop40"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>