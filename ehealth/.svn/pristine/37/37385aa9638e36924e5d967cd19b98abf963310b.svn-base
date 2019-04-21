<%--
 * Copyright 2016 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * departmentIndentjsp
 * Purpose of the JSP -  This is for Viw Documents: Blocked Item.
 * @author  Kaushal Mishra
 * Create Date: 02th March, 2016
 * Revision Date:
 * Revision By:
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page	import="jkt.hms.masters.business.UploadDocuments" %>

<%
				Map<String, Object> map = new HashMap<String, Object>();

				List<Object[]> uploadDocuments=new ArrayList<Object[]>();
		       
				if(request.getAttribute("map") != null){
				map = (Map) request.getAttribute("map");
				}
		
			if(map.get("uploadDocuments")!= null){
				uploadDocuments = (List<Object[]>)map.get("uploadDocuments");
				}
	
		%>


<div class="clear"></div>
<div class="clear"></div>
<div class="titleBg">
<h2>View Document : Item Blocked</h2>
</div>
<div class="paddingTtop5"></div>
<div class="clear"></div>

<form name="attachFile" method="post" action="" enctype="multipart/form-data">
<div class="clear"></div>
<div class="paddingTop15"></div>
<div id="pageNavPosition"></div>
<table border="0" cellpadding="0" cellspacing="0">
					<tr>
					    <th>Item Name</th>
					    <th>Batch No</th>
						<th>File</th>
						<th>Block Date</th>
						<th>Block Reason</th>
						<th>Block Status</th>
					</tr>					
<tbody id="tableData">					
			<% 
			
	int  counter=0;
	for(Object[] ud:uploadDocuments)
	{
	 %><tr>
	<td><%=ud[0]%></td>  <!-- Item Name -->
	<td><%=ud[1]%></td>  <!-- Batch No -->
	
<td><a href="#" onclick="submitFormForButton('attachFile','investigation?method=viewUploadDocuments&viewFrom=IP&uploadedDocumentId=<%=ud[8]%>&filename=<%=ud[2]+"."+ud[3]%>&'+csrfTokenName+'='+csrfTokenValue)"><%=ud[2]+"."+ud[3]%></a></td>  <!-- File Having Link to Download--> 

    <%
     SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    // Date blockDate =(Date)sdf.format(ud[5]);
     %>
    <td><%= ud[5] != null ?HMSUtil.convertDateToStringWithoutTime((Date)ud[5]):""%></td>  <!-- Blocked Date -->
    <td><%=ud[6] != null && !ud[6].equals("Select")?ud[6]:"" %></td>       <!--Block Reason  -->
    <%if(ud[7].equals(1)){ %>
    <td><b style="color: Red">Globally Blocked</b></td>
    <%}else{ %>
    <td><b style="color: Blue">Locally Blocked</b></td>
    <%} %>
    
  </tr>
 <%   ++counter;
      }
    %>
</tbody>
</table>
<div class="clear"></div>
<% if(uploadDocuments.size()==0){%>
	<h2>No Records Available.</h2>
	<%} %>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>

<script type="text/javascript">
var pager = new Pager('tableData',5);
pager.init();
pager.showPageNav('pager', 'pageNavPosition');
pager.showPage(1);

</script>



