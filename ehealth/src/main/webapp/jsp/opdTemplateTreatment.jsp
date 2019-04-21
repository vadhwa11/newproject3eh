<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * opdTemplateTreatment.jsp
	 * Purpose of the JSP -  This is for All OpdTemplateTreatment Master.
	 * @author  Vishal
	 * Create Date: 15 April,2009
	 * Revision Date:
	 * Revision By:
	 * @version 1.5
	--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar2.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<script type="text/javascript">
	templateArray = new Array();
	function populateTemplate(val,formName){
		obj = eval('document.'+formName+'.templateId');
		obj.length = 1;
		for(i=0;i<templateArray.length;i++){
			if(templateArray[i][0]==val){
				obj.length++;
				obj.options[obj.length-1].value=templateArray[i][1];
				obj.options[obj.length-1].text=templateArray[i][2];
			}
		}
	}

function check()
{
		var r = document.getElementById('depId').value;
		if(r=="0")
		{
			alert("Please select Department Name")
			return false;
		}
		else
		{
			return true;
		}
}
	</script>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}

	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	departmentList = (List<MasDepartment>)map.get("departmentList");
	System.out.println("departmentList=="+departmentList.size());

	List<OpdTemplate> opdTemplateList = new ArrayList<OpdTemplate>();
	opdTemplateList = (List<OpdTemplate>)map.get("opdTemplateList");
	System.out.println("opdTemplateList=="+opdTemplateList.size());
	Integer deptId=0;
	Integer hospitalId=0;
	if(map.get("deptId") != null){
		deptId=(Integer)map.get("deptId");
	}
	
	if(map.get("hospitalId") != null){
		hospitalId=(Integer)map.get("hospitalId");
	}	
	
	int templateId=0;
	if(map.get("templateId") != null){
		templateId=(Integer)map.get("templateId");
	}
	String templateName="";
	if(map.get("templateName") != null){
		templateName=(String)map.get("templateName");
	}
	
	String departmentName="";
	if(map.get("departmentName") != null){
		departmentName=(String)map.get("departmentName");
	}
	
	if(map.get("message") != null){
		 String  message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		 <%} %>
<script type="text/javascript">
			<%
				int counter1 = 0;
				
				for (MasDepartment masDepartment : departmentList)
				{
					for (OpdTemplate opdTemplate : opdTemplateList)
					{
						
						if(/* opdTemplate.getDepartment() != null && opdTemplate.getDepartment().getId().equals(deptId) &&  */( opdTemplate.getHospital()==null || opdTemplate.getHospital().getId().equals(hospitalId))){
							if(masDepartment.getId().equals(opdTemplate.getDepartment().getId() )){
									%>
										templateArray[<%=counter1%>] = new Array();
										templateArray[<%=counter1%>][0]=<%=masDepartment.getId()%>;
										templateArray[<%=counter1%>][1] = <%=opdTemplate.getId()%>;
										templateArray[<%=counter1%>][2] = "<%=opdTemplate.getTemplateName()%>";

									<%
									counter1++;
							}
						}
					}
				}

			%>

		</script>

<div class="titleBg">
<h2>Opd Treatment Template</h2>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<form name="opdTemplateTreatment" action="">
<input type="hidden"  value="<%=templateId>0?templateId:"" %>" id="tID">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label><span>*</span> Department Name</label>
<select name="<%= DEPARTMENT_ID %>" id="depId" validate="Department Name,string,yes" tabindex=1 onChange="populateTemplate(this.value,'opdTemplateTreatment');">
   <%if(deptId>0){ %>
    <option value="<%=deptId%>" selected="selected"><%=departmentName%></option>
    <%}else{ %>
   <option value="0">Select</option>
<%
							  	for (MasDepartment masDepartment : departmentList) {
		   		  %>
	<option value="<%=masDepartment.getId ()%>"><%=masDepartment.getDepartmentName()%></option>
	<%
					  		  				  	}
					  		  				  %>
					  		  				  
 <%}%>
</select>
<label><span>*</span> Template Group</label>
<select
	name="<%=TEMPLATE_ID%>" id="templateId" validate="Template Group,string,yes"
	onchange="submitProtoAjax('opdTemplateTreatment','/hms/hms/opdMaster?method=getTemplateGroup');"
	onmousedown="check();">
	   <%if(templateId>0){ %>
    <option value="<%=templateId%>" selected="selected"><%=templateName%></option>
    <%}else{ %>
    <option value="0">Select</option>
    <%}%>

</select></form>
<div class="clear"></div>
</div>
<!-- </div> -->
<div id="testDiv"></div>
<!-- </div> -->


<script type="text/javascript">


function checkForPVMS(val){

	 var counter=document.getElementById('counter').value
		 if(counter>0)
		  {
		 for(var i=0;i<=counter; i++)
		 {
		 	 var itemNameFromDS=data_arr[i][4]
		 	if(val != "")
			{
				var index1 = val.lastIndexOf("[");
			    var indexForNomenclature=index1;
			    var index2 = val.lastIndexOf("]");
			    index1++;
			    var pvmsNo = val.substring(index1,index2);
			    var indexForNomenclature=indexForNomenclature--;
			    var nomenclature=val.substring(0,indexForNomenclature);

		 	}
		 	if(pvmsNo =="")
			{
				return;
			}

			if(nomenclature==itemNameFromDS)
			{
				alert("Nomenclature already selected...!")
	     		document.getElementById('nomenclature').value=""
	     		document.getElementById('pvmsNo').value=""
	     		return false;
			}
					ajaxFunctionForAutoCompletePVMS('testOPD','opdMaster?method=fillItemsInGrid&pvmsNo='+pvmsNo);

		}
		}else{
			if(val != "")
			{
				var index1 = val.lastIndexOf("[");
			    var indexForNomenclature=index1;
			    var index2 = val.lastIndexOf("]");
			    index1++;
			    var pvmsNo = val.substring(index1,index2);
			    var indexForNomenclature=indexForNomenclature--;
			    var nomenclature=val.substring(0,indexForNomenclature);

		 	}
		 /*	if(pvmsNo =="")
			{
				return;
			}*/
			ajaxFunctionForAutoCompletePVMS('testOPD','opdMaster?method=fillItemsInGrid&pvmsNo='+pvmsNo);

		}
	}
		function showPage()
		{
		 obj = eval('document.'+formName)
 		 obj.action = "/hms/hms/opdMaster?method=showOpdTemplateTreatmentJsp";
  		 obj.submit();
		}


       function callTotal(){

			var frequency = document.getElementById('frequency').value;
			var dosageCalculation = document.getElementById('dosageCalculation').value;
			var noOfDays = document.getElementById('noOfDays').value;
			if(frequency!=null && dosageCalculation!=null && noOfDays!=null)
			{
			 var total = parseInt(frequency)*parseInt(dosageCalculation)*parseInt(noOfDays);
       		 document.getElementById('totalId').value = total;
			}

       }
function checkPVMSNo()
{
		var r = document.getElementById('nomenclature').value;
		if(r=="")
		{
			alert("Please Enter Nomenclature")
			return false;
		}
		else
		{
			return true;
		}
}

function convert(event) {
	if(event.keyCode){
		var data = document.getElementById("duration").value;
	    var lines = data.split(' ');
	    document.getElementById("duration").value = lines.join(',');
	    document.getElementById("noOfDays").value=(data.split(',').length);
	    document.getElementById("noOfDays").readOnly = true;
	}
}
function convert(event) {
	if(event.keyCode){
		var data = document.getElementById("duration").value;
	    var lines = data.split(' ');
	    document.getElementById("duration").value = lines.join(',');
	    document.getElementById("noOfDays").readOnly = true;
	}
}

function NoOfDays() {
	    Array.prototype.removeDuplicate = function(){
		   var result = [];
		   for(var i =0; i < this.length ; i++){
		       if(result.indexOf(this[i]) == -1) result.push(this[i]);
		   }
		   return result;
		}
		var str = document.getElementById("duration").value;
		document.getElementById("duration").value  = str.replace(/[ ]/g,"").split(",").removeDuplicate().join(", ");
		
	
		var data = document.getElementById("duration").value;
		if(data!=""){
			document.getElementById("noOfDays").value=(data.split(',').length);
		    document.getElementById("noOfDays").readOnly = true;
		    document.getElementById("frequency").selectedIndex = 1;
		}else{
			document.getElementById("noOfDays").value="";
			document.getElementById("noOfDays").readOnly = false;
		    document.getElementById("frequency").disabled=false;
		}
}


function  fillValue(){
	  var dosage = document.getElementById('dosageCalculation').value;;
	  var freq=document.getElementById('frequency').value;
	  var dispenseQty = document.getElementById('actualDispensingQty').value;
	  var noOfDays = document.getElementById('noOfDays').value;
	  var sosQty = document.getElementById('sosQty').value;
	  var total = freq*noOfDays*dosage;
	  var finalQty;
	  if(document.getElementById('frequency').value != 13 ){
	  if(document.getElementById('actualDispensingQty').value != 0){
		  var totalQty = (parseFloat(total)/parseFloat(dispenseQty)).toFixed(2)
		  if(totalQty != '0.00'){
			  finalQty = Math.ceil(totalQty);
		  }
		  document.getElementById('totalId').value=finalQty;
		 }else{
			  document.getElementById('totalId').value=freq*noOfDays*dosage;
		  }
	  }else{
		  if(document.getElementById('actualDispensingQty').value != 0){
			  var totalQty = (parseFloat(freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2);
			  if(totalQty != '0.00'){
				  finalQty = Math.ceil(totalQty);
			  }
			  document.getElementById('totalId').value=finalQty;
			 }else{
				  document.getElementById('totalId').value=freq*sosQty*dosage
			  }
	  }
	 }
	 

function displayAu(val){
   if(val != "")
   {
       var index1 = val.lastIndexOf("[");
       var index2 = val.lastIndexOf("]");
       index1++;
       var pvmsNo = val.substring(index1,index2);
     if(pvmsNo == "")
     {
       document.getElementById('nomenclature').value="";
       document.getElementById('pvmsNo').value="";
      return;
      }
      else
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
           
               xmlHttp.onreadystatechange=function()
               {
                 if(xmlHttp.readyState==4){
                         var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
                         for (loop = 0; loop < items.childNodes.length; loop++) {
                                  var item = items.childNodes[loop];
                               
                           var actualDispensingQty = item.getElementsByTagName("actualDispensingQty")[0];
                           if(document.getElementById('actualDispensingQty')){
	                           if(actualDispensingQty.childNodes[0]!=undefined){
	                                   document.getElementById('actualDispensingQty').value = actualDispensingQty.childNodes[0].nodeValue;
	                           }else{
	                                   document.getElementById('actualDispensingQty').value = 0;
	                           }
                           }
                           var dangerousDrug = item.getElementsByTagName("dangerousDrug")[0];
                           if(dangerousDrug.childNodes[0]!=undefined && dangerousDrug.childNodes[0].nodeValue == 'y'){
                                   alert("This drug is dangerous.");
                           }
                         }
                 }
                }
               var url="/hms/hms/opd?method=displayAU&pvmsNo="+pvmsNo;
	    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
               xmlHttp.open("GET",url,true);
               xmlHttp.setRequestHeader("Content-Type", "text/xml");
               xmlHttp.send(null);
           }
}

//added by govind 17-02-2017
window.onload= callpopulateTemplate;

function callpopulateTemplate(){
populateTemplate(<%=deptId%>,'opdTemplateTreatment');
var tempId=document.getElementById("tID").value;
if(tempId!=""){
if(tempId>0){
	submitProtoAjax('opdTemplateTreatment','/hms/hms/opdMaster?method=getTemplateGroup&templateId='+tempId+'&departmentId='+<%=deptId%>);	
}
}
}
//added by govind 17-02-2017 end
</script>


