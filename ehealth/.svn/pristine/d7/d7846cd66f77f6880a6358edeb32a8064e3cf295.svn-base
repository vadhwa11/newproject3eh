<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.StoreIssueT"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ taglib uri="http://www.owasp.org/index.php/Category:OWASP_CSRFGuard_Project/Owasp.CsrfGuard.tld" prefix="csrf" %>
<script type="text/javascript" language="javascript"  src="/hms/JavaScriptServlet"></script>
<%
Map<String,Object>map=new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
}
List<StoreIssueT>issueTList=new ArrayList<StoreIssueT>();
if(map.get("issueTList")!=null){
	issueTList=(List<StoreIssueT>)map.get("issueTList");
}
int issueTId=0;
if(map.get("issueTId")!=null){
	issueTId=(Integer)map.get("issueTId");
}
System.out.println("issueTList size --->>"+issueTList.size());

%>
<%if(issueTList.size()>0){ %>
<table>
<tr>
<th>Item Code</th>
<th>Item Name</th>
<th>Issued Qty</th>
<th>Returned Qty</th> <!-- added by amit das on 09-06-2016 -->
<th>Replaced Qty</th>
<th></th>

</tr>
<%for(StoreIssueT issueT:issueTList){ %>
<tr>
<input type="hidden" readonly="readonly" name="issueTId"  id="issueTId"  value="<%=issueTId %>"/>
<td><%=issueT.getItem().getPvmsNo() %></td>
<td><%=issueT.getItem().getNomenclature() %></td>
<td><%=issueT.getQtyIssued().intValue() %>
<td><%=issueT.getQtyReturned() != null?issueT.getQtyReturned().intValue():""%>
<input type="hidden" readonly="readonly" value="<%=issueT.getQtyIssued() %>" id="issuesQtyId" />
</td>
<td><input type="text" readonly="readonly" value="" /></td>
<td><input type="button" value="Issue" onclick="getBatchDetails(<%=issueT.getItem().getId() %>,<%=issueT.getQtyIssued() %>,<%=issueT.getQtyReturned() != null?issueT.getQtyReturned().intValue():0%>,csrfTokenName,csrfTokenValue);" /></td>
</tr>
<%} %>
</table>
<%}else{ %>
<h4>Already Replaced!!</h4>
<%} %>
<script>
	function setTotalQty(){
		  var tbl = document.getElementById('indentDetails');
		  var lastRow = tbl.rows.length;
		  alert("lastRow----->>"+lastRow);
		  int qty=0;
		  for( i=1;i<lastRow;i++){
			  qty=qty+parseInt(document.getElementById("qtyReplaceId"+i).value);
		  }
		  alert("qty---->>"+qty);
		  submitForm('itemReplaceForm','/hms/hms/stores?method=addPatientDrugReplace');
		  
	}
	</script>