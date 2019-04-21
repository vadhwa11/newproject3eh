<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.*"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>

<script type="text/javascript" language="javascrip"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>



<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%
	String date = "";
	String time = "";
	
	Box box = HMSUtil.getBox(request);
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	Map map = new HashMap();
 	String userName ="";
 	String deptName = "";
 	String message = "";
 	int hospitalIdFromSession=0;
 	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
	}
 	List<MasApplication> moduleList = new ArrayList<MasApplication>();
 	if(map.get("moduleList") != null){
		moduleList = (List<MasApplication>)map.get("moduleList");
	}
		if (map.get("message")!=null)
			message  = (String)map.get("message");

%>

<div class="titleBg">
<h2>Change Order For Application</h2>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>



<form name="changeOrderForm" method="post">

<div class="clear"></div>

<h4>
<%
		out.println(message); 
		%>
</h4>


<div class="clear"></div>

<h4>Change Order</h4>
<div class="clear"></div>
<div class="paddingTop15"></div>
<label>Module Name</label> 
<select name="parentId" id="parentId" validate="Module Name,metachar,no"
	onchange="if(this.value!=0){submitProtoAjax('changeOrderForm','superAdmin?method=getApplicationListForOrdering')}"
	class="large">

	<option value="0">Select</option>
	<%
				
				for(MasApplication app : moduleList){
					
			%>
	<option value="<%=app.getId()%>" ><%=app.getName()%></option>


	<% 	}		
			%>
</select>

<div class="clear"></div>
<div id="testDiv"></div>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>

<script type="text/javascript">
     
     
     function checkAll(){
		
	 if(document.getElementById('chkStatus').value =="no"){
	   document.getElementById('chkStatus').value ="yes"
	   for(var i=1;i<=document.getElementById('countVal').value;i++){
	    document.getElementById('chk'+i).checked =true
	  }
	  }else{
		 document.getElementById('chkStatus').value ="no"
	   	for(var i=1;i<=document.getElementById('countVal').value;i++){
	    	document.getElementById('chk'+i).checked =false
	  	}
	  }
	}  
	
	function checkHospitalId(){
		
		   var hospitalId=document.getElementById('hospitalId').value;
		   if(hospitalId=="0"){
		     alert("Please select the hospital.")
		   return false;
		   }else{
		     return true;
		   }
		
		}
	function checkBlank(){
     	
        var groupId=document.getElementById('groupId').value;
        var empGroup=document.getElementById('empGroup').value;
       if(groupId=="0"){
       
          alert("Please Select the Appplication Group.")
          return false;
       }
       
       return true;
     }
     function checkAssignModule(){
      for(var i = 0; i < document.getElementsByName('userId').length; i++){
			//alert("i-- "+i)
			//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
			  if(document.getElementsByName('userId')[i].checked == true)
              {
				
				return true;
			  }		
  		}
  		alert("Please select Atleast One User")
		return false;
  
  }
 
	function checkRadio(){
			
			 for(var i = 0; i < document.getElementsByName('appId').length; i++){
			//alert("i-- "+i)
			//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
			  if(document.getElementsByName('appId')[i].checked == true)
              {
				document.getElementById('appId').value=document.getElementsByName('appId')[i].value;
				document.getElementById('prevAppId').value = document.getElementsByName('appId')[i-1].value;
				
				return true;
			  }		
  		}
  		alert("Please select the Application.")
		return false;
		
	}
	
 	function swapApplication(){
			
			 for(var i = 0; i < document.getElementsByName('appIdToSwap').length; i++){
			//alert("i-- "+i)
			//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
			  if(document.getElementsByName('appId')[i].checked == true)
              {
				var temp = document.getElementsByName('appIdToSwap')[i].value;
				document.getElementsByName('appIdToSwap')[i].value = document.getElementsByName('appIdToSwap')[i-1].value;
				document.getElementsByName('appIdToSwap')[i-1].value = temp;

				var temp = document.getElementsByName('appName')[i].value;
				document.getElementsByName('appName')[i].value = document.getElementsByName('appName')[i-1].value;
				document.getElementsByName('appName')[i-1].value = temp;
				
				document.getElementsByName('appId')[i-1].checked = true;
				return true;
			  }		
  		}
  		alert("Please select the Application.")
		return false;
		
	}

</script>

