<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * housekeepingSetup.jsp
	 * Purpose of the JSP -  This is for Clinical Setup
	 * @author  Deepali
	 * Create Date: 21st Feb,2008
	 * Revision Date:
	 * Revision By: Purpose
	 * @version 1.8
	--%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasHouseKeepingFrequency"%>
<%@page import="jkt.hms.masters.business.HouseKeepingSetup"%>
<%@page import="jkt.hms.masters.business.MasHouseKeeping"%>
<%@page import="jkt.hms.masters.business.IpdVitalSetup"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.IFNULL"%>
<%@page import="jkt.hms.masters.business.MasCareType"%>
<%@ page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<script type="text/javascript">
	function validatedCare() {
		/* //alert("haloooo");
		for (var i = 0; i < document.getElementsByName('frequency').length; i++) {
			//alert("i-- "+i)

			var care = document.getElementById('careName' + i).value
			//alert("document.getElementsByName('cares').length"+ document.getElementsByName('cares').length)
			//alert("document.getElementsByName('cares')[i].checked==="+ document.getElementsByName('cares')[i].checked)
			if (document.getElementsByName('frequency')[i].value != 0
					&& document.getElementsByName('cares')[i].checked == false) {

				alert("Please select the " + care + " Care")
				return false;
			}
			if (document.getElementsByName('frequency')[i].value == 0
					&& document.getElementsByName('cares')[i].checked == true) {
				alert("Please select the " + care + " Frequency")
				return false;
			}
		}
		return true; */
		
		validateRequiredFieldNursingCare();
		submitForm('housekeepingSetup','ipd?method=addHouseKeepingSetup');
	}
</script>

<%
	Map map = new HashMap();
	String userName = "";
	String deptName = "";
	
	
	List<MasHouseKeeping> masHouseKeepingList = new ArrayList<MasHouseKeeping>();
	List<HouseKeepingSetup> houseKeepingSetupList = new ArrayList<HouseKeepingSetup>();
	List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
	List<MasHouseKeepingFrequency> houseKeepingFrequenciyList = new ArrayList<MasHouseKeepingFrequency>();
	List<MasDepartment> wardList = new ArrayList<MasDepartment>();

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	try {
		masHouseKeepingList = (List<MasHouseKeeping>) map.get("masHouseKeepingList");
		houseKeepingSetupList = (List<HouseKeepingSetup>) map.get("houseKeepingSetupList");
		frequencyList = (List<MasFrequency>) map.get("frequencyList");
		houseKeepingFrequenciyList = (List<MasHouseKeepingFrequency>) map.get("houseKeepingFrequenciyList");
		wardList = (List<MasDepartment>) map.get("wardList");

	} catch (Exception e) {
		e.printStackTrace();
	}
String message="";
if(map.get("message")!=null){
	message=(String)map.get("message");
}
if(message!=null && !message.equals("")){
%>
<h4><%=message %></h4>
<%} %>

<div class="titleBg">
	<h2>House Keeping Setup</h2>
</div>
<div class="clear"></div>
<form name="housekeepingSetup" method="post" action="">
<div class="Block">
	<div class="paddingTop15"></div>
	<div class="clear"></div>	
<div class="clear"></div>
	<div class="paddingTop25"></div>
	<div class="clear"></div>
	
	
	<div class="clear"></div>
	<div style="float: right;">
	<input type="button" class="buttonAdd" value="" align="right" onclick="javascript:addRowForNursingcare();">
	<input type="button" name="Reset" value="" class="buttonDel" align="right" onclick="javascript:removeRowForNursingcare();">
		</div>
		<div class="clear"></div>
		<div class="paddingTop25"></div>
	<div class="clear"></div>
	<table border="0" cellpadding="0" cellspacing="0" id="nursingcaretable">
								<tr>
								     <th>&nbsp;</th>
									<th>Activity</th>
									<th>Ward</th>
									<th>Day Frequency</th>
									<th>Frequency</th>
									<th>Remarks</th>
								</tr>
								<%
								int countNursingCare=0;
								if(houseKeepingSetupList.size()>0)
								{
									for(HouseKeepingSetup housekeepingsetup:houseKeepingSetupList)
									{
										countNursingCare++;
										%>
										<tr>
							<td>
							<input type="checkbox" class="radioCheck" id="radionursingcare<%=countNursingCare%>"  name="radionursingcare<%=countNursingCare%>"  />
							</td>
							<td width="27%"><select name="activity<%=countNursingCare%>" id="activity<%=countNursingCare%>" onblur="validateDuplicateNursingCare('<%=countNursingCare%>')">
											<option value="0">Select</option>
											<%
												for (Object mashouseKeepingObject : masHouseKeepingList) {
													MasHouseKeeping masHouseKeeping=(MasHouseKeeping)mashouseKeepingObject;
													if(masHouseKeeping.getId()==housekeepingsetup.getHouseKeeping().getId())
													{%>
													<option value="<%=masHouseKeeping.getId()%>" selected="selected">
											<%=masHouseKeeping.getHouseKeepingName()%>
											</option>
													<%
													}
													else{
												%>
											<option value="<%=masHouseKeeping.getId()%>">
											<%=masHouseKeeping.getHouseKeepingName()%>
											</option>
											<%
												}
												}
											%>
									</select></td>
									
									
									
									<td width="27%"><select name="ward<%=countNursingCare%>" id="ward<%=countNursingCare%>" onblur="validateDuplicateNursingCare('<%=countNursingCare%>')">
											<option value="0">Select</option>
											<%
												for (Object wardObject : wardList) {
													MasDepartment department=(MasDepartment)wardObject;
													if(department.getId()==housekeepingsetup.getDepartment().getId())
													{%>
													<option value="<%=department.getId()%>" selected="selected">
											<%=department.getDepartmentName() %>
											</option>
													<%
													}
													else{
												%>
											<option value="<%=department.getId()%>">
											<%=department.getDepartmentName()%>
											</option>
											<%
												}
												}
											%>
									</select></td>
									
									<td width="27%"><select name="dayFrequency<%=countNursingCare%>" id="dayFrequency<%=countNursingCare%>"
										validate="Day Frequncy,string,no">
											<option value="0">Select</option>
											<%
												for (MasHouseKeepingFrequency masFrequency : houseKeepingFrequenciyList) {
													if(masFrequency.getId()==housekeepingsetup.getHouseKeepingFrequency().getId())
													{%>
													<option value="<%=masFrequency.getId()%>" selected="selected">
											<%=masFrequency.getFrequencyName()%>
											</option>
													<%
													}
													else{
											%>
											<option value="<%=masFrequency.getId()%>">
											<%=masFrequency.getFrequencyName()%>
											</option>
											<%
												}
												}
											%>
									</select></td>
									
									<td width="27%"><select name="<%=FREQUENCY%><%=countNursingCare%>" id="<%=FREQUENCY%><%=countNursingCare%>"
										validate="Complaint,string,no">
											<option value="0">Select</option>
											<%
												for (MasFrequency masFrequency : frequencyList) {
													if(masFrequency.getId()==housekeepingsetup.getFrequency().getId())
													{%>
													<option value="<%=masFrequency.getId()%>" selected="selected">
											<%=masFrequency.getFrequencyName()%>
											</option>
													<%
													}
													else{
											%>
											<option value="<%=masFrequency.getId()%>">
											<%=masFrequency.getFrequencyName()%>
											</option>
											<%
												}
												}
											%>
									</select></td>
									<td><input type="text" name="<%=CARE_REMARKS%><%=countNursingCare%>" id="<%=CARE_REMARKS%><%=countNursingCare%>" 
									value="<%=housekeepingsetup.getRemarks()!=null?housekeepingsetup.getRemarks():""%>" /> </td>
							</tr>
										<%
									}
								}
								else
								{
									countNursingCare++;
								%>
							
							<tr>
							<td>
							<input type="checkbox" class="radioCheck" id="radionursingcare<%=countNursingCare%>"  name="radionursingcare<%=countNursingCare%>"  />
							</td>
							<td width="27%"><select name="activity<%=countNursingCare%>" id="activity<%=countNursingCare%>" onblur="validateDuplicateNursingCare('<%=countNursingCare%>')">
											<option value="0">Select</option>
											<%
												for (Object mashouseKeepingObject : masHouseKeepingList) {
													MasHouseKeeping masHouseKeeping=(MasHouseKeeping)mashouseKeepingObject;
													%>
											<option value="<%=masHouseKeeping.getId()%>">
											<%=masHouseKeeping.getHouseKeepingName()%>
											</option>
											<%
												}
											%>
									</select></td>
									
									
									
									<td width="27%"><select name="ward<%=countNursingCare%>" id="ward<%=countNursingCare%>" onblur="validateDuplicateNursingCare('<%=countNursingCare%>')">
											<option value="0">Select</option>
											<%
												for (Object wardObject : wardList) {
													MasDepartment department=(MasDepartment)wardObject;
													%>
													
					
											<option value="<%=department.getId()%>">
											<%=department.getDepartmentName()%>
											</option>
											<%
												}
											%>
									</select></td>
									
									<td width="27%"><select name="dayFrequency<%=countNursingCare%>" id="dayFrequency<%=countNursingCare%>"
										validate="Day Frequncy,string,no">
											<option value="0">Select</option>
											<%
												for (MasHouseKeepingFrequency masFrequency : houseKeepingFrequenciyList) {
													%>
													
													
											<option value="<%=masFrequency.getId()%>">
											<%=masFrequency.getFrequencyName()%>
											</option>
											<%
												}
											%>
									</select></td>
									
									<td width="27%"><select name="<%=FREQUENCY%><%=countNursingCare%>" id="<%=FREQUENCY%><%=countNursingCare%>"
										validate="Complaint,string,no">
											<option value="0">Select</option>
											<%
												for (MasFrequency masFrequency : frequencyList) {
													%>
													
													
											<option value="<%=masFrequency.getId()%>">
											<%=masFrequency.getFrequencyName()%>
											</option>
											<%
												}
											%>
									</select></td>
									<td><input type="text" name="<%=CARE_REMARKS%><%=countNursingCare%>" id="<%=CARE_REMARKS%><%=countNursingCare%>" 
									value="" /> </td>
							</tr>
							<%} %>
							
							</tbody>
							
							
						</table>
	<input type="hidden" name="nursingcarecount" id="nursingcarecount" value="<%=countNursingCare%>"/>

	<div class="clear"></div>
	<div class="paddingTop25"></div>
	<div class="clear"></div>
	
	<div class="clear"></div>

	
	<div class="clear"></div>
	<div class="paddingTop25"></div>
	<div class="clear"></div>

	<input type="button" class="button" value="Submit" align="left"
		onclick="validatedCare();" />
		
		<input type="reset" class="button" value="Reset" align="left"
		onclick="" />
		
	<!-- <input type="button" class="button" value="Back" align="left"
		onclick="submitForm('clinicalSetup','ipd?method=showPatientListJsp');" /> -->

	<div class="clear"></div>
	<div class="clear"></div>
	<div class="paddingTop40"></div>
	<div class="clear"></div>
		
		</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


<script type="text/javascript">	var	frequencyArray= new Array();
                 <%
	    		MasFrequency  frequency = new MasFrequency();

			     for (int k = 0; k < frequencyList.size(); k++) {
			    	 frequency = (MasFrequency) frequencyList.get(k);
     			 %>

     			frequencyArray[<%=k%>]= new Array();
     			frequencyArray[<%=k%>][0] = "<%=frequency.getId()%>";
     			frequencyArray[<%=k%>][1] = "<%=frequency.getFrequencyName()%>";
     			<% }%> 
            </script> 
            
            <script type="text/javascript">	var	activityList= new Array();
                 <%

			     for (int k = 0; k < masHouseKeepingList.size(); k++) {
			    	 MasHouseKeeping housekeeping = (MasHouseKeeping) masHouseKeepingList.get(k);
     			 %>

     			activityList[<%=k%>]= new Array();
     			activityList[<%=k%>][0] = "<%=housekeeping.getId()%>";
     			activityList[<%=k%>][1] = "<%=housekeeping.getHouseKeepingName()%>";
     			<% }%> 
            </script> 
            
             <script type="text/javascript">	var	wardList= new Array();
                 <%

			     for (int k = 0; k < wardList.size(); k++) {
			    	 MasDepartment ward = (MasDepartment) wardList.get(k);
     			 %>

     			wardList[<%=k%>]= new Array();
     			wardList[<%=k%>][0] = "<%=ward.getId()%>";
     			wardList[<%=k%>][1] = "<%=ward.getDepartmentName()%>";
     			<% }%> 
            </script> 
            
             <script type="text/javascript">	var	houseKeepingFrequenciyList= new Array();
                 <%

			     for (int k = 0; k < houseKeepingFrequenciyList.size(); k++) {
			    	 MasHouseKeepingFrequency houseKeepingFrequency = (MasHouseKeepingFrequency) houseKeepingFrequenciyList.get(k);
     			 %>

     			houseKeepingFrequenciyList[<%=k%>]= new Array();
     			houseKeepingFrequenciyList[<%=k%>][0] = "<%=houseKeepingFrequency.getId()%>";
     			houseKeepingFrequenciyList[<%=k%>][1] = "<%=houseKeepingFrequency.getFrequencyName()%>";
     			<% }%> 
            </script> 
            
            
            
            <script type="text/javascript">
            function addRowForNursingcare(){
        		var tbl = document.getElementById('nursingcaretable');
        		var lastRow = tbl.rows.length;
        		// if there's no header row in the table, then iteration = lastRow + 1
        		var iteration = lastRow;
        		var row = tbl.insertRow(lastRow);
        		var hdb = document.getElementById('nursingcarecount');
        		iteration = parseInt(hdb.value)+1;
        		hdb.value=iteration;

        		var cellRight1 = row.insertCell(0);
        		var e1 = document.createElement('input');
        		e1.type = 'checkbox';
        		e1.name='radionursingcare'+iteration;
        		e1.id='radionursingcare'+iteration;
        		e1.className='radioCheck';
        		cellRight1.appendChild(e1);
        		
        		var cellRight1 = row.insertCell(1);
        		var e1 = document.createElement('Select');
        		e1.name='activity'+iteration;
        		e1.id='activity'+iteration;
        		e1.options[0] = new Option('Select', '0');
        		  for(var i = 0;i<activityList.length;i++ ){
        		e1.options[i+1] = new Option(activityList[i][1],activityList[i][0]);
        		} 
        		  e1.onblur=function(){
        			  validateDuplicateNursingCare(iteration);
        				};
        		cellRight1.appendChild(e1);
        		
        		var cellRight1 = row.insertCell(2);
        		var e1 = document.createElement('Select');
        		e1.name='ward'+iteration;
        		e1.id='ward'+iteration;
        		e1.options[0] = new Option('Select', '0');
        		  for(var i = 0;i<wardList.length;i++ ){
        		e1.options[i+1] = new Option(wardList[i][1],wardList[i][0]);
        		} 
        		  e1.onblur=function(){
        			  validateDuplicateNursingCare(iteration);
        				};
        		cellRight1.appendChild(e1);
        		
        		var cellRight1 = row.insertCell(3);
        		var e1 = document.createElement('Select');
        		e1.name='dayFrequency'+iteration;
        		e1.id='dayFrequency'+iteration;
        		e1.options[0] = new Option('Select', '0');
        		  for(var i = 0;i<houseKeepingFrequenciyList.length;i++ ){
        		e1.options[i+1] = new Option(houseKeepingFrequenciyList[i][1],houseKeepingFrequenciyList[i][0]);
        		} 
        		cellRight1.appendChild(e1);

        		
        		
        		var cellRight1 = row.insertCell(4);
        		var e1 = document.createElement('Select');
        		e1.name='frequency'+iteration;
        		e1.id='frequency'+iteration;
        		e1.options[0] = new Option('Select', '0');
        		  for(var i = 0;i<frequencyArray.length;i++ ){
        		e1.options[i+1] = new Option(frequencyArray[i][1],frequencyArray[i][0]);
        		} 
        		cellRight1.appendChild(e1);
        		
        	/* 	var cellRight1 = row.insertCell(3);
        		var e1 = document.createElement('input');
        		e1.type = 'checkbox';
        		e1.name='carestop'+iteration;
        		e1.id='carestop'+iteration;
        		e1.value='1';
        		cellRight1.appendChild(e1);
        	*/
        		
        		var cellRight1 = row.insertCell(5);
        		var e1 = document.createElement('input');
        		e1.type = 'text';
        		e1.name='careremarks'+iteration;
        		e1.id='careremarks'+iteration;
        		/* e1.onblur=function(){
        		populatebrand(this.value, iteration);
        		checkItem(iteration);
        		}; */
        		cellRight1.appendChild(e1);
        		
            }
            
            function removeRowForNursingcare()
        	{
        	  var tbl = document.getElementById('nursingcaretable');
        	  var lastRow = tbl.rows.length;
        	  var hdb = document.getElementById('nursingcarecount');
        	  var iteration = parseInt(hdb.value);
        	  var totalSelected=0;
        	  for(var i=1;i<=iteration;i++)
        		  {
        		  if(document.getElementById("radionursingcare"+i)!=null && (typeof  document.getElementById("radionursingcare"+i).checked)!='undefined' && document.getElementById("radionursingcare"+i).checked )
        			  {
        			  totalSelected=totalSelected+1;
        			  }
        		  }
        	      if(totalSelected==0)
        		  {
        		  alert('Please select atleast 1 row to delete');
        		  }
        	      else  if(lastRow==2 || lastRow==(totalSelected+1))
        		  {
        	    	  alert('You can not delete all Row.');
        	      }
        	      else if (lastRow > 2){
        	    	  for(var i=1;i<=iteration;i++)
        	    	  {
                		  if(document.getElementById("radionursingcare"+i)!=null && (typeof  document.getElementById("radionursingcare"+i).checked)!='undefined' && document.getElementById("radionursingcare"+i).checked )
        	    		  {
        	    		  var deleteRow= document.getElementById("radionursingcare"+i).parentNode.parentNode;
        	    		  document.getElementById("radionursingcare"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
        	    		  }
        	    	  }
        	  }
        	}
            
            function validateDuplicateNursingCare(index)
            {
            	var message="";
            	var count = document.getElementById('nursingcarecount').value;
            	var activityId=document.getElementById("activity"+index).value;
            	var wardId=document.getElementById("ward"+index).value;
        		for(var i=1;i<=count;i++)
        			{
        			   if(i!=index && document.getElementById("activity"+i)!=null && document.getElementById("activity"+i).value!=''&& document.getElementById("activity"+i).value!=0)
        				   {
        				   if(document.getElementById("activity"+i).value==activityId && document.getElementById("ward"+i).value==wardId)
        				    	{
        					   message +=document.getElementById("activity"+i).options[document.getElementById("activity"+i).selectedIndex].text +" is duplicate\n";        				    	
        				    	document.getElementById("activity"+index).value=0;
        				    	document.getElementById("ward"+index).value=0;
        				    	}
        				   
        				   }
        			}
        		if(message!="")
        			{
        			alert(message);
        			}
        		return true;
            }
            
            function validateRequiredFieldNursingCare()
            {
            	var count = document.getElementById('nursingcarecount').value;
        		for(var i=1;i<=count;i++)
        			{
        			   if(document.getElementById("activity"+i)!=null && document.getElementById("activity"+i).value!=''&& document.getElementById("activity"+i).value!=0)
        				   {
        					   document.getElementById("activity"+i).setAttribute("validate", "Activity,int,yes");
        					   document.getElementById("ward"+i).setAttribute("validate", "Ward,int,yes");
        					   document.getElementById("dayFrequency"+i).setAttribute("validate", "Day Frequency,int,yes");
        					   document.getElementById("frequency"+i).setAttribute("validate", "Frequency,int,yes");
        					   document.getElementById("careremarks"+i).setAttribute("validate", "Remarks,string,no");
        				   }
        			}
            }
            
            
            
           
            
          
            
            </script>

