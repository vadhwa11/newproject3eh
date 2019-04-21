<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * DocumentMaster.jsp  
 * Purpose of the JSP -  This is for document  Details.
 * @author  Vishal
 * Create Date: 15th July,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.1 
--%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hrms.masters.business.MstrDocument" %>
<%@page import="jkt.hrms.masters.business.MstrDoctype" %>



<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchDocumentList = (ArrayList)map.get("searchDocumentList");
	List<MstrDoctype> documentTypeList = new ArrayList<MstrDoctype>();
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
%>

<div class="titleBg"> 
<h2>Document Master</h2></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
		  
<form name="search" method="post" action="">
	<label>Document Code:</label>		    
	<input type="radio" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" class="radioCheck"/>
	<label>Document Name:</label>
	<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck"/>
	
	<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Document Code,string,no"   MAXLENGTH="8" tabindex=1  onkeypress="return submitenter(this,event,'projectTrackingMaster?method=searchDocument')"/>
    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','projectTrackingMaster?method=searchDocument','checkSearch')" tabindex=1  />
	<%--- Report Button   <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/>
    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mstr_Document">  --%>
    

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</div>
<div class="clear"></div>

</div>

<div class="clear"></div>
<div class="division"></div>

	<jsp:include page="searchResultBlock.jsp" />
	<div class="clear"></div>
	<div id="searchresults" tabindex=2 >
	<div id="searchtable" tabindex=2 ></div>
	
	<% 
	
	 if(map.get("documentTypeList")!=null){
		 documentTypeList=(List<MstrDoctype>)map.get("documentTypeList");
		}
	
	  
		if(searchDocumentList.size()>0)
		 {	String strForCode = (String)map.get("DocumentCode");
			String strForCodeDescription = (String)map.get("DocumentName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{ 
		%> 
	<div class="clear"></div>
    
    <a href="projectTrackingMaster?method=showDocumentJsp">Show All Records</a>
	<%
			}
		 }
	if(searchDocumentList.size()==0 && map.get("search") != null)
	  {
		
	 %>
				<a href="projectTrackingMaster?method=showDocumentJsp">Show All Records</a>

	 <%
    }
	%>
	<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= DOCUMENT_TYPE_ID %>"],[4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
</script>
</div>
<div class="clear"></div>
<div class="division"></div>
<form name="document" method="post" action=""><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
	

	<input type="hidden" name="<%= POJO_NAME %>" value = "MstrDocument">
  	<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="DocName">
  	<input type="hidden" name="title" value = "Document Master">
  	<input type="hidden" name="<%=JSP_NAME %>" value = "documentMaster">
  	<input type="hidden" name="pojoPropertyCode" value = "DocCode">
<div class="division"></div>
	<label><span>*</span>Document Code:</label>
  	<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Document Code,string,yes" MAXLENGTH="8"/ tabindex=1 >
  	<label><span>*</span>Document Name:</label>
  	<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Document Name,string,yes" MAXLENGTH="50"/ tabindex=1 onkeypress="return submitenter(this,event,'projectTrackingMaster?method=addDocument')" >
  	
    <div class="clear"></div>
    
 <label>Document Type</label>
    	<select name="<%=DOCUMENT_TYPE_ID %>" id="documentType" validate="Document Type,string,no">
    	<option value="">Select</option>
    	<%
			for(MstrDoctype mstrDoctype:documentTypeList)
			{				
		%>
		<option value="<%= mstrDoctype.getId() %>"><%=mstrDoctype.getDocTypeName()%></option>
		
		<%} %>   
		</select>

		<div class="clear"></div>
<script>
	document.document.<%=CODE%>.focus();
</script>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div id="edited"></div>

	<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('document','projectTrackingMaster?method=addDocument');" accesskey="a" tabindex=1/>

	<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('document','projectTrackingMaster?method=editDocument')" accesskey="u" tabindex=1 />

	<input type="button" name="Delete" id="deletebutton" value="Activate"  style="display: none;"  class="button" onClick="submitForm('document','projectTrackingMaster?method=deleteDocument&flag='+this.value)" accesskey="d" tabindex=1/>		

	<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
		
	<input type="hidden" name="<%=STATUS %>" value="" />
		
	<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="division"></div>
 			
	<label>Changed By:</label>   
	<label class="value"><%=userName%></label>
			        
	<label>Changed Date:</label>   
	<label class="value"><%=date%></label>
			 
	<label>Changed Time:</label>   
	<label class="value"><%=time%></label>
			 
	<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
	<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
	<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
	
<div class="division"></div>
<div class="clear"></div>
<div class="clear"></div>
			
</form>
<div class="clear"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Document Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

	
data_header[1] = new Array;
data_header[1][0] = "Document Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Document Type"
data_header[2][1] = "data";
data_header[2][2] = 0;
data_header[2][3] = "<%= DOCUMENT_TYPE_ID %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_DATE %>"


data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%= CHANGED_TIME %>";

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();
<%
Iterator itr=searchDocumentList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  MstrDocument  mstrDocument = (MstrDocument)itr.next(); 		
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= mstrDocument.getId()%>
data_arr[<%= counter%>][1] = "<%=mstrDocument.getDocCode()%>"
data_arr[<%= counter%>][2] = "<%= mstrDocument.getDocName()%>"

<%
				for(MstrDoctype mstrDoctype :documentTypeList){
             if(mstrDocument.getDocType()!= null){
			 if(mstrDocument.getDocType().getId().equals(mstrDoctype.getId()) && mstrDoctype.getStatus().equals("y")){%>
				data_arr[<%= counter%>][3] = "<%=mstrDoctype.getDocTypeName()%>";
			<%}else if(mstrDocument.getId().equals(mstrDoctype.getId()) && mstrDoctype.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=mstrDoctype.getDocTypeName()%>";
				
			<%}}else{%>
				data_arr[<%= counter%>][3] = ""
			<%}}%>

  
data_arr[<%= counter%>][4] = "<%= mstrDocument.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= mstrDocument.getLastChgDate() %>"
data_arr[<%= counter%>][6] = "<%= mstrDocument.getLastChgTime()%>"

<% if(mstrDocument.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "document"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  