<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * searchResultPO.jsp  
 * Purpose of the JSP -  This is for Search Result for PO.
 * @author  Deeti Tevatia
 * Create Date: 06th Dec,2007 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>



<div id="resultnavigation">
<form name="paging" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 

<table width="61%" align="right">
	<tr>
		<td width="30%">
		<div style="left: 150px; width: 150px;"><font class="pagingtext">|---</font>
		<font class="space"></font> <font class="pagingtext" id="currStart">1
		</font> <font class="space"></font> <font class="pagingtext">to</font> <font
			class="pagingtext" id="currEnd">5 </font> <font class="space"></font>
		<font class="pagingtext">of</font> <font class="space"></font> <font
			class="pagingtext" id="totalRecs"></font> <font class="pagingtext">---|</font>
		</div>
		</td>
		<td width="5%"><input type="button" name="firstpage" value="f"
			style="background: url(/hms/jsp/images/newest.gif) !important; font-size: 0px; width: 25px; height: 20px; background-color: #ffffff !important; color: #f5fdfe !important; background-repeat: no-repeat !important;"
			onClick="navigate(this)" accesskey="f" /></td>
		<td width="6%"><input type="button" name="prevpage" value="p"
			style="background: url(/hms/jsp/images/newer.gif) !important; font-size: 0px; width: 20px; height: 20px; background-color: #ffffff !important; color: #f5fdfe !important; background-repeat: no-repeat !important; cursor: pointer;"
			onClick="navigate(this)" accesskey="p" /></td>
		<td width="23%">
		<div style="width: 120px;"><font class="pagingtext">Page
		</font> <font class="space"></font> <font class="pagingtext" id="current">
		1 </font> <font class="space"></font> <font class="pagingtext">of</font> <font
			class="space"></font> <font class="pagingtext" id="total"></font></div>
		</td>
		<td width="6%"><input type="button" name="nextpage" value="n"
			style="background: url(/hms/jsp/images/older.gif) !important; font-size: 0px; width: 20px; height: 20px; background-color: #ffffff !important; color: #f5fdfe !important; background-repeat: no-repeat !important; cursor: pointer;"
			onclick="navigate(this)" accesskey="n" /></td>
		<td width="5%"><input type="button" name="lastpage" value="l"
			style="background: url(/hms/jsp/images/oldest.gif) !important; font-size: 0px; width: 25px; height: 20px; background-color: #ffffff !important; color: #f5fdfe !important; background-repeat: no-repeat !important; cursor: pointer;"
			onClick="navigate(this)" accesskey="l" /></td>
		<td width="25%"><input type="text" name="pageno" id="pageno"
			class="inputbutton" MAXLENGTH="4" / /></td>
		<td width="8%"><input type="button" name="ok" value="ok"
			class="smbutton" onClick="goToPage(pageno.value)" /></td>
		<td width="8%"><input type="button" name="ok" value="Refresh"
			class="button" onClick="goToPage(pageno.value)" /></td>
	</tr>
</table>
 


 </form>
<br />
</div>




