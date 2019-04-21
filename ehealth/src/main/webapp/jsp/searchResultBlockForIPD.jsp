<%--
* Copyright 2008 JK Technosoft Ltd. All rights reserved.
* Use is subject to license terms.
* searchResultBlockForIPD.jsp  
* Purpose of the JSP -  This is for Search Result Block for IPD.
* @author  Vikas
* Create Date: 01st Feb,2008 
* Revision Date:      
* Revision By:  
* @version 1.2
--%>

<% String search = request.getParameter("search");  %>

<form name="paging" method="post" action="">


<div id="resultnavigation">|---- <span id="currStart">1</span> to
<span id="totalRecs"> </span> of <span id="currEnd">10 </span>----| <!--|----  Total <span  id="currEnd">10 </span> Showing <span id="currStart">1</span> to <span id="totalRecs"> </span> ----|-->

<input type="button" name="firstpage" value="f"
	onClick="navigateIPD(this)" accesskey="f" class="previous" /> <input
	type="button" name="prevpage" value="p" onClick="navigateIPD(this)"
	accesskey="p" class="singlePrev" /> Page <span id="current"> 1
</span> of <span id="total"> </span> <input type="button" name="nextpage"
	value="n" onClick="navigateIPD(this)" accesskey="n" class="singleNext" />
<input type="button" name="lastpage" value="l"
	onClick="navigateIPD(this)" accesskey="l" class="next" />
<%if(search==null) {%>
 <input
	type="text" name="pageno" id="pageno" MAXLENGTH="4" validate="pageno,int,no"
	onkeypress="submitenter(this,event,'','goToPageForPatient(document.paging.pageno.value)')" />
<input type="button" name="ok" value=""
	onClick="goToPageForPatient(pageno.value)" class="button" />
 <%}else{ %>

<% } %>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 </form>



