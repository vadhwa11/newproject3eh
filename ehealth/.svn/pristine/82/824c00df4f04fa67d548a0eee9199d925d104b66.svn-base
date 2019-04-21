<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : adtBedState.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="java.math.BigDecimal"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>

<div class="titleBg">
<h2>ADT Daily Bed Status</h2>
</div>
<div class="clear"></div>
<form name="bedStatusSearch" method="post" action="">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		List bedStatusList = new ArrayList();
		List sumList = new ArrayList();
		Map<String, Object> mapDate = new HashMap<String, Object>();
		mapDate=HMSUtil.getCurrentDateAndTime();
		String currentDate="";
		String currentTime="";
		if(mapDate.get("currentDate")!=null){
			currentDate=(String)mapDate.get("currentDate");
		}
		if(mapDate.get("currentTime")!=null){
			currentTime=(String)mapDate.get("currentTime");
		}
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("bedStatusList") != null){
			bedStatusList= (List)map.get("bedStatusList");
		}
		
		if(map.get("sumList") != null){
			sumList= (List)map.get("sumList");
		}
		
		String message = "";
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
		
	%> <script type="text/javascript">
	<%
		if(!message.equals("")){
			%>
			var msg = "<%=message%>";
			alert(msg);
			
		<%}
	%>
	
	function showDeptRecords()
	{
	 for(var i = 0; i < document.getElementsByName('parent').length; i++){
	  if(document.getElementsByName('parent')[i].checked == true){
			var str = 'commandent?method=showTodayAdmissionJsp&parent=' + document.getElementsByName('parent')[i].value; 
	  	}		
  	}
	submitForm('finalDischarge',str,'validateRadio');
	}
	
	function showSILDILRecords()
	{
	 for(var i = 0; i < document.getElementsByName('parent').length; i++){
	  if(document.getElementsByName('parent')[i].checked == true){
		var str = 'commandent?method=showTodaySILDILJsp&parent=' + document.getElementsByName('parent')[i].value;
	  	}			
  	}
	submitForm('finalDischarge',str,'validateRadio');
	}
	

function validateRadio(){
			
	 for(var i = 0; i < document.getElementsByName('parent').length; i++){
	  if(document.getElementsByName('parent')[i].checked == true){
			return true;
	  	}		
  	}
 	alert("Please select record.");
	return false;
		
	}
		
	
</script>

<div class="Block"><label>Bed State as on</label><label
	class="value"> <%=currentDate%> : <%=currentTime %></label> <%  
   int counter = 0;
    	if(sumList.size()>0)
    	{
    	   	 BigDecimal tot = null;
    	   	 try
    	   	 {
    	   	 tot = new BigDecimal(sumList.get(0).toString());
    	   	 }
    	   	 catch(Exception e)
    	   	 {
    	   		tot= new BigDecimal("0");
    	   	 }
			     
								
  	%> <label>Total</label> <label class="value"><%=tot%></label> <%		
    	}
 %>
<div class="clear"></div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="test">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>



<script type="text/javascript">

   formFields = [
    [0, "<%= DEPARTMENT_ID%>", "id"],[1,"<%= RADIO_FOR_TABLE%>"], [2,"<%= WARD_NAME%>"],[3,"<%= BEDS_AUTH %>"], [4,"<%= BEDS_OCCUPIED %>"],[5,"<%=DIL%>"], [6,"<%= SIL %>"],[7,"<%= VEG %>"],[8,"<%= NON_VEG %>"]];
    statusTd = 8;

   </script></div>
</div>
<div class="clear"></div>
<form name="finalDischarge" method="post" action="">
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="patients" id="patientsButton"
	value="Patients" class="button" onClick="showDeptRecords();"
	accesskey="a" tabindex=1 /> <input type="button" name="dilSil"
	id="dilSil" value="DIL SIL" class="button"
	onClick="showSILDILRecords();" accesskey="a" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<script type="text/javascript">
    data_header = new Array();
        
   	data_header[0] = new Array;
	data_header[0][0] = ""
	data_header[0][1] = "radio";
	data_header[0][2] = "4%";
	data_header[0][3] = "<%=RADIO_FOR_TABLE%>"
    
    data_header[1] = new Array;
    data_header[1][0] = "Ward"
    data_header[1][1] = "data";
    data_header[1][2] = "30%";
    data_header[1][3] = "<%=WARD_NAME%>";
    
    data_header[2] = new Array;
    data_header[2][0] = "Beds Auth"
    data_header[2][1] = "data";
    data_header[2][2] = "12%";
    data_header[2][3] = "<%=BEDS_AUTH%>";
    
    data_header[3] = new Array;
    data_header[3][0] = "Beds Occupied"
    data_header[3][1] = "data";
    data_header[3][2] = "12%";
    data_header[3][3] = "<%=BEDS_OCCUPIED%>";
    
    data_header[4] = new Array;
    data_header[4][0] = "DIL"
    data_header[4][1] = "data";
    data_header[4][2] = "15%";
    data_header[4][3] = "<%=DIL%>";
    
    data_header[5] = new Array;
    data_header[5][0] = "SIL"
    data_header[5][1] = "data";
    data_header[5][2] = "14%";
    data_header[5][3] = "<%=SIL%>";
    
    data_header[6] = new Array;
    data_header[6][0] = "Veg"
    data_header[6][1] = "data";
    data_header[6][2] = "12%";
    data_header[6][3] = "<%=VEG%>";
    
    data_header[7] = new Array;
    data_header[7][0] = "Non Veg"
    data_header[7][1] = "data";
    data_header[7][2] = "12%";
    data_header[7][3] = "<%=NON_VEG%>";
    
     data_arr = new Array();
    
    <%
   
    counter = 0;
    	if(bedStatusList.size()>0)
    	{
			Iterator ite = bedStatusList.iterator();
			while ( ite.hasNext() ) {
		         Object[] pair = (Object[]) ite.next();
		         		       	 
		         String deptname = null;
		         //BigInteger total = new BigInteger("0");
		       	 //BigDecimal sil = new BigDecimal("0");
		       	 //BigDecimal dil = new BigDecimal("0");
		       	 //BigDecimal veg = new BigDecimal("0");
		       	 //BigDecimal nonveg = new BigDecimal("0");
		       	 //Integer bedStrength = new Integer("0");
		       	 	int total = 0;
		       	 int sil =0;
		       	 int dil =0;
		       	 int veg = 0;
		       	 int nonveg = 0;
		       	 Integer bedStrength = new Integer("0");
		       	 
		       	 int deptid = 0;
		       	 
		       	 if (pair[0]!=null)
		         	deptname = (String)pair[0];
		       	 
		         if (pair[1]!=null)
			        total = ((Number)pair[1]).intValue();
		         
		         if (pair[2]!=null)
			         sil = ((Number)pair[2]).intValue();
		         
		         if (pair[3]!=null)
			         dil =((Number)pair[3]).intValue();
		         
		         if (pair[4]!=null)
			         veg =((Number)pair[4]).intValue();
		         
		         if (pair[5]!=null)
			         nonveg =((Number)pair[5]).intValue();
		         
		         if (pair[6]!=null)
		         {
			         deptid =((Number)pair[6]).intValue();
		         }

		         if (pair[7]!=null)
		         {
			         bedStrength =((Number)pair[7]).intValue();
		         }
		         
		         
								
  	%>
		    	data_arr[<%= counter%>] = new Array();
				data_arr[<%= counter%>][0] = <%=deptid%>
				data_arr[<%= counter%>][1] = '<input type="radio" name="parent" value="<%=deptid%>"  id="parent"  />'
				data_arr[<%= counter%>][2] = "<%=deptname%>"
				data_arr[<%= counter%>][3] = "<%=bedStrength%>"
				
				<% if(total!=0){%>
						data_arr[<%= counter%>][4] = "<%= total%>"
				<%}else{%>
						data_arr[<%= counter%>][4] = 0
				<%}

				if(dil!=0){%>
						data_arr[<%= counter%>][5] = "<%= dil%>"
				<%}else{%>
						data_arr[<%= counter%>][5] = 0
				<%} 
				
				if(sil!=0){%>
						data_arr[<%= counter%>][6] = "<%= sil%>"
				<%}else{%>
						data_arr[<%= counter%>][6] = 0
				<%}
			
				if(veg!=0){%>
						data_arr[<%= counter%>][7] = "<%= veg%>"
				<%}else{%>
						data_arr[<%= counter%>][7] = 0
				<%}
			
				if(nonveg!=0){%>
						data_arr[<%= counter%>][8] = "<%= nonveg%>"
				<%}else{%>
						data_arr[<%= counter%>][8] = 0
				<%}%>
    		
  	<%		counter++;	
  				
    		}
    	}
 %>
     formName = "finalDischarge"
	 start = 0
    if(data_arr.length < rowsPerPage)
     end = data_arr.length;
    else
     end = rowsPerPage;
    
    makeTable(start,end);
    
    intializeHover('searchresulttable', 'TR', ' tableover');
</script> <script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
    </script>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    </form>

<%sumList.clear(); %>