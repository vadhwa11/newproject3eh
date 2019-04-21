<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.PhAtpJphnJhiHeader"%>
<%@page import="jkt.hms.masters.business.PhDayBlock"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/sorttableAccounts.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<form name="ashaWorker" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
       Map<String,Object> utilMap = new HashMap<String,Object>();
       utilMap = (Map)HMSUtil.getCurrentDateAndTime();
       String date = (String)utilMap.get("currentDate");
       String time = (String)utilMap.get("currentTime");
       String userName = "";
       if (session.getAttribute("userName") != null) {
               userName = (String) session.getAttribute("userName");
       }
  
      List<MasEmployee> masEmp = new ArrayList<MasEmployee>();
 	  	if(map.get("masEmp") != null){
 	  		masEmp = (List<MasEmployee>)map.get("masEmp"); 
	}
       
     
String message = "";
       if(map.get("message") != null){
               message = (String)map.get("message");
               %>
<h4><span><%=message %></span></h4>
       <%}
%>
<div class="titleBg">
<h2>Performance Assessment</h2>
</div>
<div class="Block">
<label>AshaWorkers<span>*</span></label>
<select id="ashaId"  name="ashaId" validate="Ashsa Worker,string,Yes" onblur="submitProtoAjaxWithDivName('ashaWorker','/hms/hms/pubHealth?method=getAshaworkerDetail','testDiv');">
<%	if(masEmp.size() >0){%>
				<option value="0">Select</option>
				 <%
				 for (MasEmployee emp : masEmp) {
				  %>
				  <option value="<%=emp.getId()%>"><%=emp.getEmployeeName()%></option>
				  <%
				  	 	}
				   %>
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>
	
</div>

<div class="clear"></div>
<div id="testDiv">

</div>


 <div class="clear"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName %> </label>

<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
<label class="value"><%=time%></label>
 <input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName %>" />
  <input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
   <input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>



<div class="clear"></div>
<div class="clear"></div>

<script>
var nameArray= new Array();

function getParameters(val,no){
	alert(no)
	var br='br';
	var dr='dr';
	var anc='anc';
    var ecr='ecr';
    var fpr='fpr';
    var bcr='bcr';
    var cdr='cdr';
    var ndr='ndr';
    
     if(val == br ){
    	 
    	 submitProtoAjaxWithDivNameToShowStatus('ashaWorker','/hms/hms/pubHealth?method=getBirthRegistration&rowVal='+no,'parameterDiv'+no);	 
     }
     else if(val == dr){
     	
     	 submitProtoAjaxWithDivName('ashaWorker','/hms/hms/pubHealth?method=getDeathRegistration&rowVal='+no,'parameterDiv'+no); 
     }
     else if(val == anc){
    	
    	 submitProtoAjaxWithDivName('ashaWorker','/hms/hms/pubHealth?method=getAncRegistration','parameterDiv'+no);
     }
     
     else if(val == ecr){
    	
     	 submitProtoAjaxWithDivName('ashaWorker','/hms/hms/pubHealth?method=getEcRegistration','parameterDiv'+no); 
     }
     else if(val == fpr){
    	
    	 submitProtoAjaxWithDivName('ashaWorker','/hms/hms/pubHealth?method=getFamilyPalRegistration&rowVal='+no,'parameterDiv'+no);
     }
     else if(val == bcr){
    	
     	 submitProtoAjaxWithDivName('ashaWorker','/hms/hms/pubHealth?method= &Val='+val,'parameterDiv'+no);
     }
     else if(val == cdr){
    	 
    	 submitProtoAjaxWithDivName('ashaWorker','/hms/hms/pubHealth?method=getCDRRegistration','parameterDiv'+no);
     }
    else if(val == ndr){
    	 
    	 submitProtoAjaxWithDivName('ashaWorker','/hms/hms/pubHealth?method=getNonCDRRegistration','parameterDiv'+no);
     }
     
    
}

function showDiv(){
	
		document.getElementById("divEnchashment").style.display ='block';
	
}

function total(val,no){  
	var options=val.options, count=0;
	//var options = document.getElementById('bName').options, count = 0;
	for (var i=0; i < options.length; i++) {
	  if (options[i].selected) count++;
	}
	document.getElementById("countId"+no).value=count;

}


function addRow(){
	var table=document.getElementById("tablediv"); 
	var tableLength=table.rows.length;
	var iteration=tableLength;
	var row=table.insertRow(tableLength);

      var cell0 = row.insertCell(0);
	  var e0 = document.createElement('Select');
	  e0.name='serviceId'+iteration;
	  e0.onchange = function(){getParameters(this.value,iteration);}
	  e0.style.width = "";
	  e0.options[0] = new Option('Select','');
	  e0.options[1] = new Option('Birth Registration','br');
	  e0.options[2] = new Option('Death Registration','dr');
	  e0.options[3] = new Option('ANC Registration','anc');
	  e0.options[4] = new Option('EC Registration','ecr');
	  e0.options[5] = new Option('FP Registration','fpr');
	  e0.options[6] = new Option('Baby/Child Registration','bcr');
	  e0.options[7] = new Option('Communicable Disease Registration','cdr');
	  e0.options[8] = new Option('Non-Communicable Disease Registration','ndr');
	  cell0.appendChild(e0);
	 
	  var cell1 = row.insertCell(1);
	  var d0=document.createElement('div');
      d0.id='parameterDiv'+iteration;
	  var e1 = document.createElement('Select');
	  e1.multiple="multiple";
	  e1.size="3";
	  e1.name='bName'+iteration;
	  e1.onclick = function(){total(this);}
	  e1.style.height = "50px";
	  e1.options[0] = new Option('Select', '0');
	  if(document.getElementById("bName")+iteration !== null){
	 /*  for(var i = 0;i<nameArray.length;i++ ){
		e1.options[i+1] = new Option(nameArray[i][1],nameArray[i][0]);
	  } */
	  }
	  
	  d0.appendChild(e1);
	  cell1.appendChild(d0);
	
	  
	  var cell2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.name='countId'+iteration;
	  e2.id='countId'+iteration;
	  e2.type = 'text';
	  e2.style.width = "";
	  cell2.appendChild(e2);

}


</script>



</form>
