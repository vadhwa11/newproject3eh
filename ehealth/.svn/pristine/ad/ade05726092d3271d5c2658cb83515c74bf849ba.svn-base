<%@page import="jkt.hms.masters.business.OpdAntenatalUsg"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.*"%>
<script type="text/javascript" src="/hms/jsp/js/antenatal2.js"></script>
<%
List<OpdAntenatalUsg> usgThirdTrimFirstVisitList= new ArrayList<OpdAntenatalUsg>();
List<OpdAntenatalUsg>  usgThirdTrimSecondVisitList= new ArrayList<OpdAntenatalUsg>();
List<OpdAntenatalUsg>  usgThirdTrimThirdVisitList= new ArrayList<OpdAntenatalUsg>();

if((List) request.getAttribute("usgThirdTrimFirstVisitList")!=null){
	usgThirdTrimFirstVisitList = (List<OpdAntenatalUsg>)request.getAttribute("usgThirdTrimFirstVisitList");
}
if((List) request.getAttribute("usgThirdTrimSecondVisitList")!=null){
	usgThirdTrimSecondVisitList = (List<OpdAntenatalUsg>)request.getAttribute("usgThirdTrimSecondVisitList");
}
if((List) request.getAttribute("usgThirdTrimThirdVisitList")!=null){
	usgThirdTrimThirdVisitList = (List<OpdAntenatalUsg>)request.getAttribute("usgThirdTrimThirdVisitList");
}
String usgThirdTrimFlag="";
if(request.getAttribute("usgThirdTrimFlag")!=null){
	usgThirdTrimFlag = (String)request.getAttribute("usgThirdTrimFlag");
}

String revisitFlagThirdTrim="";
if(request.getAttribute("revisitFlagThirdTrim")!=null){
	revisitFlagThirdTrim=(String)request.getAttribute("revisitFlagThirdTrim");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String dateC = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
%>

<div class="clear"></div>
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="displayCollapsibleTab('usg Third')"id="usgThirdDivId" name="" value="-" type="button"></div>
<div class="plusText"><h4 class="h4Tab">USG Report Third Trimester</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
		<div  id="usgThirdDiv"  >
		<div class="indArrow"></div>		
		<div class="Block">
		<table border="0" align="center" cellpadding="0" cellspacing="0"  style="border-top: 1px solid #C0C0C0; width:800px; float:left; margin-left:5px;">
							    <%int usgthirdTrimFirstVisitIndex = 1; int usgthirdTrimSecondVisitIndex= 1; int usgthirdTrimThirdVisitIndex= 1; %>
							   <%--  <%int l= 1;int v=1;int n=1; %> --%>
							  <tr><td><b>USG</b>(3rd Trimester)</td>
							  <%if(usgThirdTrimFlag !=null && !usgThirdTrimFlag.equals("")){ %>
							   <td colspan="3">				    
 <div style="width:75px; float:left;"><input style="margin-top:-3px;" id="usgThirdSingle" name="usgThirdTrimTwo" type="radio"  <%=usgThirdTrimFlag.equalsIgnoreCase("single")?"checked":""%> onclick="setThirdUsgFlag();usgThirdTrimDivShowHideRevisit();" >Single</div>
 <div style="width:75px; float:left;"><input style="margin-top:-3px;" id="usgThirdTrimTwins" name="usgThirdTrimTwo" type="radio"  <%=usgThirdTrimFlag.equalsIgnoreCase("Twins")?"checked":""%> onclick="setThirdUsgFlag();usgThirdTrimDivShowHideRevisit();" >Twins</div>
 <div style="width:75px; float:left;"><input style="margin-top:-3px;" id="usgThirdTrimTriplets" name="usgThirdTrimTwo" type="radio"  <%=usgThirdTrimFlag.equalsIgnoreCase("Triplets")?"checked":""%> onclick="setThirdUsgFlag();usgThirdTrimDivShowHideRevisit();" >Triplets</div>
                                     
                                      <input type="hidden" name="thirdTrimRevisit" id="thirdTrimRevisit" value="<%=revisitFlagThirdTrim %>" />
                                      <input type="hidden" name="thirdTrimRevistThirdV" id="thirdTrimRevistThirdV" value="<%=usgThirdTrimThirdVisitList.size() %>" />
                                      <input type="hidden" name="usgFlagThirdTrim" id="usgFlagThirdTrim" value="<%=usgThirdTrimFlag %>" />
     
     </td>
							  <%}else{ %>
							  
						    <td colspan="3">				    
 <div style="width:75px; float:left;"><input style="margin-top:-3px;" id="usgThirdSingle" name="usgThirdTrimTwo" type="radio" checked="checked"   onclick="setThirdUsgFlag();usgThirdTrimDivShowHide();">Single</div>
 <div style="width:75px; float:left;"><input style="margin-top:-3px;" id="usgThirdTrimTwins" name="usgThirdTrimTwo" type="radio"  onclick="setThirdUsgFlag();usgThirdTrimDivShowHide();">Twins</div>
 <div style="width:75px; float:left;"><input style="margin-top:-3px;" id="usgThirdTrimTriplets" name="usgThirdTrimTwo" type="radio"  onclick="setThirdUsgFlag();usgThirdTrimDivShowHide();">Triplets</div>
                                      <input type="hidden" name="usgFlagThirdTrim" id="usgFlagThirdTrim" value="" />
     
     </td>
     <%} %>
						</tr>	  
						 <tr>
						<td>USG Parameters</td>
						<!-- <td>Date</td> -->
					
							<% if(usgThirdTrimFirstVisitList.size()>0){ 
								for(OpdAntenatalUsg dateListThirdTrimFirstV : usgThirdTrimFirstVisitList ){
									if(dateListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("Date")){
									%>
								
								 <td><input type="text" value="<%=dateListThirdTrimFirstV.getUsgParameterValue1() != null?dateListThirdTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />
								<div class="clear"></div>
								</td>
							
							<%break;}}} else { %>
							<td><input type="text" name="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" id="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" class="small" readonly="readonly" tabindex="1" onblur="validateUSGDate(this.id);ValidateLmp(this.id);"/>
							<img src="/hms/jsp/images/cal.gif" width="16" height="16"  border="0" validate="Pick a date" onclick="setdate('<%=dateC%>',document.getElementById('usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>'),event);setThirdTrimFirstVisitFlag()" />
							<input type="hidden" name="thirdTrimFirstVisitFlag" id="thirdTrimFirstVisitFlag" value="" />
							</td>							
							<% usgthirdTrimFirstVisitIndex++;} %>
							
							
							<%if(usgThirdTrimSecondVisitList.size()>0){ 
							for(OpdAntenatalUsg dateListThirdTrimSecondV : usgThirdTrimSecondVisitList ){ 
								if(dateListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("Date")){
							%>
								<td><input type="text" value="<%=dateListThirdTrimSecondV.getUsgParameterValue2() != null?dateListThirdTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
							</td>
							<%break;}} }else { %>
							 <td><input type="text" name="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" id="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" class="small" readonly="readonly"  tabindex="2" onblur="validateUSGDate(this.id);ValidateLmp(this.id);"/>
							<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=dateC%>',document.getElementById('usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>'),event);setThirdTrimSecondVisitFlag()">
							<input type="hidden" name="thirdTrimSecondVisitFlag" id="thirdTrimSecondVisitFlag" value="" />
							</td>
							<% usgthirdTrimSecondVisitIndex++;} %>
							
							<%if(usgThirdTrimThirdVisitList.size()>0){ 
							for(OpdAntenatalUsg dateListThirdTrimThirdV : usgThirdTrimThirdVisitList ){ 
								if(dateListThirdTrimThirdV.getUsgParameter().equalsIgnoreCase("Date")){
							%>
								<td><input type="text" value="<%=dateListThirdTrimThirdV.getUsgParameterValue3() != null?dateListThirdTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
							</td>
							<%break;}}} else {%>
							   <td><input type="text" name="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" id="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex%>"  class="small" readonly="readonly" tabindex="3" onblur="validateUSGDate(this.id);ValidateLmp(this.id);"/>
							<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=dateC%>',document.getElementById('usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex%>'),event);setThirdTrimThirdVisitFlag();">
							<input type="hidden" name="thirdTrimThirdVisitFlag" id="thirdTrimThirdVisitFlag" value="" />
							</td>
							<% usgthirdTrimThirdVisitIndex++; } %> 
							
							</tr> 
						
						<!-- ------- -->
						 <tr>
						<td>LMP GA</td>
						
							<% if(usgThirdTrimFirstVisitList.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg lmpGAListThirdTrimFirstV:usgThirdTrimFirstVisitList ){
									 if(lmpGAListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("LMP GA")){
									 %>
								
								<input type="text" value="<%=lmpGAListThirdTrimFirstV.getUsgParameterValue1() != null?lmpGAListThirdTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} else { %>
							
							<td><input type="text" id="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/>
						 	 <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	  <div class="" style="display:block" id="dataDivLmpGaTwins1">
						 	   <input  type="text" id="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/></div> 
						 	  <%}else{ %>
						 	  <div class="" style="display:none" id="dataDivLmpGaTwins1">
						 	   <input  type="text" id="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/></div> 
						 	  <%} %> 
						 	  
						 	  <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	  <div class="" style="display:block" id="dataDivLmpGaTriplets1">
							 <input  type="text" id="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/> 
							  </div>
						 	  <%} else { %> 
						 	  <div class="" style="display:none" id="dataDivLmpGaTriplets1">
							 <input  type="text" id="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/> 
							  </div>
						 	<%} %>
							 </td>							
							<% usgthirdTrimFirstVisitIndex++;} %>
							
							<%if(usgThirdTrimSecondVisitList.size()>0){%>
							  <td>
								 <%
								 for(OpdAntenatalUsg lmpGAListThirdTrimSecondV:usgThirdTrimSecondVisitList ){  if(lmpGAListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("LMP GA")){
								 %> 
								<input type="text" value="<%=lmpGAListThirdTrimSecondV.getUsgParameterValue2() != null?lmpGAListThirdTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly" disabled="disabled" />
								 <div class="clear"></div>
							   <div class="" style="display:none" id="dataDivLmpGaTwinsColTwo1">
							   <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /></div>  
							   <div class="" style="display:none" id="dataDivLmpGaTripletsColTwo1">
							   <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /> </div>
							<%} }%>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" id="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" maxlength="128" tabindex="2"/>
						 	  <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivLmpGaTwinsColTwo1">
							  <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /></div>  
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivLmpGaTwinsColTwo1">
							  <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /></div>  
						 	  <%} %>
						 	    <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	     <div class="" style="display:block" id="dataDivLmpGaTripletsColTwo1">
							    <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /> </div>
						 	    <%}else{ %> 
						 	     <div class="" style="display:none" id="dataDivLmpGaTripletsColTwo1">
							   <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /> </div>
						 	   <%} %> 
							
							  </td>
							<% usgthirdTrimSecondVisitIndex++;} %>
							
							<%if(usgThirdTrimThirdVisitList.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg lmpGAListThirdTrimThirdV:usgThirdTrimThirdVisitList ){ 
									 if(lmpGAListThirdTrimThirdV.getUsgParameter().equalsIgnoreCase("LMP GA")){
								 %> 
								<input type="text" value="<%=lmpGAListThirdTrimThirdV.getUsgParameterValue3() != null?lmpGAListThirdTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly" disabled="disabled" />
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivLmpGaTwinsColThree1">
							     <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							     <div class="" style="display:none" id="dataDivLmpGaTripletsColThree1">
							     <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex %>" value="" id="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex %>"maxlength="128" tabindex="3"/>
							   <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivLmpGaTwinsColThree1">
							        <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128"  tabindex="3"/></div>
								   <%}else{ %>
								    <div class="" style="display:none" id="dataDivLmpGaTwinsColThree1">
							       <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							   <%} %> 
								  <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
							  <div class="" style="display:block" id="dataDivLmpGaTripletsColThree1">
							  <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							  <%}else{ %> 
							  <div class="" style="display:none" id="dataDivLmpGaTripletsColThree1">
							  <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							  <%} %>
							  </td>
							<%} usgthirdTrimThirdVisitIndex++; %>
							
							</tr>
						<!-- ------ -->
						
						<tr>
						<td>USG GA</td>
						
							<% if(usgThirdTrimFirstVisitList.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg usgGAListThirdTrimFirstV:usgThirdTrimFirstVisitList ){ 
								  if(usgGAListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("USG GA")){
							  %>	
								<input type="text" value="<%=usgGAListThirdTrimFirstV.getUsgParameterValue1() != null?usgGAListThirdTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />
							     <div class="clear"></div>
							<%}} %>	
								</td>							
							<%} else { %>
							<td><input type="text" name="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" id="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" maxlength="128" tabindex="1"/>
								  <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivUsgGaTwins1">
							       <input  type="text" id="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/></div>
								   
								   <%}else{ %>
								    <div class="" style="display:none" id="dataDivUsgGaTwins1">
							        <input  type="text" id="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/></div>
								   
								 <%} 
								
								 if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivUsgGaTriplets1">
							     <input  type="text" id="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128"  tabindex="1" /></div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivUsgGaTriplets1">
							     <input  type="text" id="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"  /></div>
								<%} %> 
								 
								 
							    </td>							
							<% usgthirdTrimFirstVisitIndex++;} %>
							
							<%if(usgThirdTrimSecondVisitList.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg usgGAListThirdTrimSecondV:usgThirdTrimSecondVisitList ){
									 if(usgGAListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("USG GA")){
									 %>		
								
								<input type="text" value="<%=usgGAListThirdTrimSecondV.getUsgParameterValue2() != null?usgGAListThirdTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivUsgGaTwinsColTwo1">
							     <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"  /></div>
							     <div class="" style="display:none" id="dataDivUsgGaTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /> </div>
							<%} }%>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" id="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" maxlength="128" tabindex="2"/>
						 	 <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivUsgGaTwinsColTwo1">
							  <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /></div>
						 	  <%}else{ %> 
						 	    <div class="" style="display:none" id="dataDivUsgGaTwinsColTwo1">
							  <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"  /></div>
						   <%} %> 
						 	  
						 	  <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivUsgGaTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /> </div>
						 	  <%}else{ %> 
						 	    <div class="" style="display:none" id="dataDivUsgGaTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /> </div>
						 	  <%} %> 
						 	     
						 	    
							  
							  </td>
							<% usgthirdTrimSecondVisitIndex++;} %>
							
							<%if(usgThirdTrimThirdVisitList.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg usgGAListThirdTrimThirdV : usgThirdTrimThirdVisitList ){
									 if(usgGAListThirdTrimThirdV.getUsgParameter().equalsIgnoreCase("USG GA")){
									 %>
								
								<input type="text" value="<%=usgGAListThirdTrimThirdV.getUsgParameterValue3() != null?usgGAListThirdTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
							   <div class="" style="display:none" id="dataDivUsgGaTwinsColThree1">
							   <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128"  tabindex="3"/></div>
							   <div class="" style="display:none" id="dataDivUsgGaTripletsColThree1">
							   <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex %>" value="" id="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex %>" maxlength="128" tabindex="3"  />
						 	 <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivUsgGaTwinsColThree1">
							  <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
						 	   <%}else{ %>
						 	   <div class="" style="display:none" id="dataDivUsgGaTwinsColThree1">
							  <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128"  tabindex="3"/></div>
						 	  <%} %> 
						 	      <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivUsgGaTripletsColThree1">
							      <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/></div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivUsgGaTripletsColThree1">
							     <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	       <%} %> 
							
							  </td>
							<% usgthirdTrimThirdVisitIndex++; } %>
							
							</tr>
							<!-- ----- -->
							<tr>
						<td>BPD</td>
						
							<% if(usgThirdTrimFirstVisitList.size()>0){ %>
							  <td>
								 <% for(OpdAntenatalUsg bpdListThirdTrimFirstV:usgThirdTrimFirstVisitList ){
									 if(bpdListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("BPD")){
									 %>		
								
								<input type="text" value="<%=bpdListThirdTrimFirstV.getUsgParameterValue1() !=null?bpdListThirdTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} else { %>
							<td><input type="text" name="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" id="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" maxlength="128" tabindex="1" />
								   <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivBpdTwins1">
							       <input  type="text" id="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/></div>
								   
								   <%}else{ %> 
								    <div class="" style="display:none" id="dataDivBpdTwins1">
							        <input  type="text" id="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/></div>
								   
								  <%} %> 
								
							 <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivBpdTriplets1">
							     <input  type="text" id="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128"  tabindex="1" /></div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivBpdTriplets1">
							     <input  type="text" id="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"  /></div>
							 <%} %> 
								 
								 
							    </td>							
							<% usgthirdTrimFirstVisitIndex++;} %>
							
							<%if(usgThirdTrimSecondVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg bpdListThirdTrimSecondV:usgThirdTrimSecondVisitList ){ 
									 if(bpdListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("BPD")){
								%>	
								<input type="text" value="<%=bpdListThirdTrimSecondV.getUsgParameterValue2() !=null?bpdListThirdTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								<div class="" style="display:none" id="dataDivBpdTwinsColTwo1">
							    <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /></div>
							    <div class="" style="display:none" id="dataDivBpdTripletsColTwo1">
							    <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128"  tabindex="2"/> </div>
							<%} }%>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" id="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" maxlength="128" tabindex="2"/>
						 	  <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivBpdTwinsColTwo1">
							  <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"  /></div>
						 	  <%}else{ %> 
						 	    <div class="" style="display:none" id="dataDivBpdTwinsColTwo1">
							  <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /></div>
						  <%} %> 
						 	  
						 	  <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivBpdTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /> </div>
						 	  <%}else{ %> 
						 	    <div class="" style="display:none" id="dataDivBpdTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128"  tabindex="2"/> </div>
						 	   <%} %> 
						 	     
						 	    
							  
							  </td>
							<% usgthirdTrimSecondVisitIndex++;} %>
							
							<%if(usgThirdTrimThirdVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg bpdListThirdTrimSecondtV:usgThirdTrimThirdVisitList ){
									 if(bpdListThirdTrimSecondtV.getUsgParameter().equalsIgnoreCase("BPD")){
									%>	 
								
								<input type="text" value="<%=bpdListThirdTrimSecondtV.getUsgParameterValue3() !=null?bpdListThirdTrimSecondtV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivBpdTwinsColThree1">
							      <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							      <div class="" style="display:none" id="dataDivBpdTripletsColThree1">
							      <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /> </div>
							<%}}%>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex %>" value="" id="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex %>" maxlength="128" tabindex="3"  />
						 	   <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivBpdTwinsColThree1">
							  <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivBpdTwinsColThree1">
							  <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
						 	   <%} %> 
						 	  <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivBpdTripletsColThree1">
							      <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivBpdTripletsColThree1">
							     <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /> </div>
						 	   <%} %> 
							
							  </td>
							<% usgthirdTrimThirdVisitIndex++; } %>							
							</tr>						
						<!-- ------ -->
						<tr>
						<td>HC</td>
						
							<% if(usgThirdTrimFirstVisitList.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg hcListThirdTrimFirstV:usgThirdTrimFirstVisitList ){
									 if(hcListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("HC")){
									 %>	
								
								<input type="text" value="<%=hcListThirdTrimFirstV.getUsgParameterValue1() !=null?hcListThirdTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} else { %>
							<td><input type="text" name="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" id="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" maxlength="128" tabindex="1"/>
								   <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivHcTwins1">
							       <input  type="text" id="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/></div>
								   
								   <%}else{ %> 
								    <div class="" style="display:none" id="dataDivHcTwins1">
							        <input  type="text" id="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/></div>
								   
								  <%} %> 
								
								 <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivHcTriplets1">
							     <input  type="text" id="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128"  tabindex="1" /></div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivHcTriplets1">
							     <input  type="text" id="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"  /></div>
							 <%} %> 
								 
								 
							    </td>							
							<% usgthirdTrimFirstVisitIndex++;} %>
						
							<%if(usgThirdTrimSecondVisitList.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg hcListThirdTrimSecondV:usgThirdTrimSecondVisitList ){ 
									 if(hcListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("HC")){
								 %>	
								<input type="text" value="<%=hcListThirdTrimSecondV.getUsgParameterValue2() !=null?hcListThirdTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivHcTwinsColTwo1">
							      <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /></div>
							      <div class="" style="display:none" id="dataDivHcTripletsColTwo1">
							      <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" id="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" maxlength="128" tabindex="2"/>
						 	 <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivHcTwinsColTwo1">
							  <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"  /></div>
						 	  <%}else{ %> 
						 	    <div class="" style="display:none" id="dataDivHcTwinsColTwo1">
							  <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /></div>
						    <%} %> 
						 	  
						  <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivHcTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /> </div>
						 	  <%}else{ %> 
						 	    <div class="" style="display:none" id="dataDivHcTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /> </div>
						 	  <%} %> 
						 	    
							  
							  </td>
							<% usgthirdTrimSecondVisitIndex++;} %>
						
							<%if(usgThirdTrimThirdVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg hcListThirdTrimThirdV:usgThirdTrimThirdVisitList ){
									 if(hcListThirdTrimThirdV.getUsgParameter().equalsIgnoreCase("HC")){
									 %>	
								 
								<input type="text" value="<%=hcListThirdTrimThirdV.getUsgParameterValue3() !=null?hcListThirdTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivHcTwinsColThree1">
							     <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128"  tabindex="3"/></div>
							     <div class="" style="display:none" id="dataDivHcTripletsColThree1">
							     <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							<%} }%>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex %>" value="" id="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex %>" maxlength="128"  tabindex="3" />
						 	  <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivHcTwinsColThree1">
							  <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
						 	   <%}else{ %>
						 	   <div class="" style="display:none" id="dataDivHcTwinsColThree1">
							  <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128"  tabindex="3"/></div>
						 	   <%} %>
						 	       <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivHcTripletsColThree1">
							      <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/></div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivHcTripletsColThree1">
							     <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	       <%} %> 
							
							  </td>
							<% usgthirdTrimThirdVisitIndex++; } %>
							
							</tr>						
						<!-- ------ -->
						<tr>
						<td>AC</td>
						
							<% if(usgThirdTrimFirstVisitList.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg acListThirdTrimFirstV:usgThirdTrimFirstVisitList ){ 
									 if(acListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("AC")){
								%>	
								<input type="text" value="<%=acListThirdTrimFirstV.getUsgParameterValue1() !=null?acListThirdTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} else { %>
							<td><input type="text" name="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" id="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" maxlength="128" tabindex="1"/>
								  <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivAcTwins1">
							       <input  type="text" id="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/></div>
								   
								   <%}else{ %> 
								    <div class="" style="display:none" id="dataDivAcTwins1">
							        <input  type="text" id="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/></div>
								   
								    <%} %> 
								
								<% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivAcTriplets1">
							     <input  type="text" id="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128"  tabindex="1" /></div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivAcTriplets1">
							     <input  type="text" id="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128"  tabindex="1" /></div>
								 <%} %> 
								 
								 
							    </td>							
							<% usgthirdTrimFirstVisitIndex++;} %>
							
							<%if(usgThirdTrimSecondVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg acListThirdTrimSecondV : usgThirdTrimSecondVisitList ){
									if(acListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("AC")){
									%>	
								<input type="text" value="<%=acListThirdTrimSecondV.getUsgParameterValue2() !=null?acListThirdTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								   <div class="" style="display:none" id="dataDivAcTwinsColTwo1">
							       <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /></div>
							       <div class="" style="display:none" id="dataDivAcTripletsColTwo1">
							       <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" id="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" maxlength="128" tabindex="2"/>
						 	 <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivAcTwinsColTwo1">
							  <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /></div>
						 	  <%}else{ %> 
						 	    <div class="" style="display:none" id="dataDivAcTwinsColTwo1">
							  <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /></div>
						 	  <%} %> 
						 	  
						   <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivAcTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128"  tabindex="2"/> </div>
						 	  <%}else{ %> 
						 	    <div class="" style="display:none" id="dataDivAcTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /> </div>
						 	  <%} %> 
						 	     
						 	    
							  
							  </td>
							<% usgthirdTrimSecondVisitIndex++;} %>
							
							<%if(usgThirdTrimThirdVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg acListThirdTrimThirdV : usgThirdTrimThirdVisitList ){
									if(acListThirdTrimThirdV.getUsgParameter().equalsIgnoreCase("AC")){
								%>	
								<input type="text" value="<%=acListThirdTrimThirdV.getUsgParameterValue3() !=null?acListThirdTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivAcTwinsColThree1">
							      <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128"  tabindex="3"/></div>
							      <div class="" style="display:none" id="dataDivAcTripletsColThree1">
							      <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							<%} }%>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex %>" value="" id="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex %>" maxlength="128"  tabindex="3" />
						 	   <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivAcTwinsColThree1">
							  <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
						 	   <%}else{ %>
						 	   <div class="" style="display:none" id="dataDivAcTwinsColThree1">
							  <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128"  tabindex="3"/></div>
						 	   <%} %>
						 	      <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivAcTripletsColThree1">
							      <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/></div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivAcTripletsColThree1">
							     <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	      <%} %> 
							
							  </td>
							<% usgthirdTrimThirdVisitIndex++; } %>
							</tr>
							
							
						
						<!-- ------- -->
						
						<tr>
						<td>FL</td>
						
							<% if(usgThirdTrimFirstVisitList.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg flListThirdTrimFirstV : usgThirdTrimFirstVisitList ){
								if(flListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("FL")){
								%>
								<input type="text" value="<%=flListThirdTrimFirstV.getUsgParameterValue1() !=null?flListThirdTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />

								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} else { %>
							<td><input  type="text" id="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/>
							  <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivFlTwins1">
							 <input  type="text" id="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/>
							  </div>
								   
								   <%}else{ %> 
								    <div class="" style="display:none" id="dataDivFlTwins1">
							        <input  type="text" id="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/> 
							        </div>
								   
								   <%} %> 
								
								 <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivFlTriplets1">
							      <input  type="text" id="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/> 
							     </div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivFlTriplets1">
							      <input  type="text" id="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/> </div>
								 <%} %> 
								 
								 
							    </td>							
							<% usgthirdTrimFirstVisitIndex++;} %>
							
							<%if(usgThirdTrimSecondVisitList.size()>0){%>
							 <td>
								 <%for(OpdAntenatalUsg flListThirdTrimSecondV : usgThirdTrimSecondVisitList ){%>
								  
									 <%if(flListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("FL")){
									%>	
							    <input type="text" value="<%=flListThirdTrimSecondV.getUsgParameterValue2() !=null?flListThirdTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								
								 <div class="clear"></div>
							  <div class="" style="display:none" id="dataDivFlTwinsColTwo1">
							  <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
							  <div class="" style="display:none" id="dataDivFlTripletsColTwo1">
							  <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td> <input  type="text" id="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/>
						 	 <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivFlTwinsColTwo1">
							  <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivFlTwinsColTwo1">
							  <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						    <%} %> 
						 	  
						 	   <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivFlTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivFlTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/> </div>
						 	   <%} %> 
						 	     
						 	    
							  
							  </td>
							<% usgthirdTrimSecondVisitIndex++;} %>
							
							<%if(usgThirdTrimThirdVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg flListThirdTrimThirdV : usgThirdTrimThirdVisitList ){ 
									if(flListThirdTrimThirdV.getUsgParameter().equalsIgnoreCase("FL")){
								%>	
								<input type="text" value="<%=flListThirdTrimThirdV.getUsgParameterValue3() !=null?flListThirdTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								  <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivFlTwinsColThree1">
							      <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							      <div class="" style="display:none" id="dataDivFlTripletsColThree1">
							      <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/>  </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input  type="text" id="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> 
						 	    <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivFlTwinsColThree1">
							  <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivFlTwinsColThree1">
							  <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%} %>
						 	       <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivFlTripletsColThree1">
							      <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivFlTripletsColThree1">
							     <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/>  </div>
						 	      <%} %>
							
							  </td>
							<% usgthirdTrimThirdVisitIndex++; } %>
							</tr>
							
							<!-- ------- -->
						
						<tr>
						<td>AFI</td>
						
							<% if(usgThirdTrimFirstVisitList.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg afiListThirdTrimFirstV : usgThirdTrimFirstVisitList ){
								if(afiListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("AFI")){
								%>
								<input type="text" value="<%=afiListThirdTrimFirstV.getUsgParameterValue1() !=null?afiListThirdTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />

								 <div class="clear"></div>
								<%} }%> 
								</td>
							
							<%} else { %>
							<td><input  type="text" id="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/>
							  <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivAfiTwins1">
							 <input  type="text" id="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/>
							  </div>
								   
								   <%}else{ %> 
								    <div class="" style="display:none" id="dataDivAfiTwins1">
							        <input  type="text" id="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/> 
							        </div>
								   
								   <%} %> 
								
								 <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivAfiTriplets1">
							      <input  type="text" id="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/> 
							     </div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivAfiTriplets1">
							      <input  type="text" id="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/> </div>
								 <%} %> 
								 
								 
							    </td>							
							<% usgthirdTrimFirstVisitIndex++;} %>
							
							<%if(usgThirdTrimSecondVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg afiListThirdTrimSecondV : usgThirdTrimSecondVisitList ){ 
									if(afiListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("AFI")){
								%>	
							    <input type="text" value="<%=afiListThirdTrimSecondV.getUsgParameterValue2() !=null?afiListThirdTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivAfiTwinsColTwo1">
							     <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
							     <div class="" style="display:none" id="dataDivAfiTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input  type="text" id="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/>
						 	 <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivAfiTwinsColTwo1">
							  <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivAfiTwinsColTwo1">
							  <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						    <%} %> 
						 	  
						 	   <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivAfiTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivAfiTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/> </div>
						 	   <%} %> 
						 	     
						 	    
							  
							  </td>
							<% usgthirdTrimSecondVisitIndex++;} %>
							
							<%if(usgThirdTrimThirdVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg afiListThirdTrimThirdV : usgThirdTrimThirdVisitList ){ 
									if(afiListThirdTrimThirdV.getUsgParameter().equalsIgnoreCase("AFI")){
								%>	
								<input type="text" value="<%=afiListThirdTrimThirdV.getUsgParameterValue3() !=null?afiListThirdTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivAfiTwinsColThree1">
							     <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							     <div class="" style="display:none" id="dataDivAfiTripletsColThree1">
							     <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input  type="text" id="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> 
						 	    <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivAfiTwinsColThree1">
							  <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivAfiTwinsColThree1">
							  <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%} %>
						 	       <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivAfiTripletsColThree1">
							      <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivAfiTripletsColThree1">
							     <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	      <%} %>
							
							  </td>
							<% usgthirdTrimThirdVisitIndex++; } %>
							</tr>
							
							<!-- ------- -->
						
						<tr>
						<td>Placenta</td>
						
							<% if(usgThirdTrimFirstVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg placentaListThirdTrimFirstV : usgThirdTrimFirstVisitList ){
								if(placentaListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("Placenta")){
								%>
								<input type="text" value="<%=placentaListThirdTrimFirstV.getUsgParameterValue1() !=null?placentaListThirdTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />

								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} else { %>
							<td><input  type="text" id="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/>
							  <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivPlacentaTwins1">
							 <input  type="text" id="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/>
							  </div>
								   
								   <%}else{ %> 
								    <div class="" style="display:none" id="dataDivPlacentaTwins1">
							        <input  type="text" id="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/> 
							        </div>
								   
								   <%} %> 
								
								 <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivPlacentaTriplets1">
							      <input  type="text" id="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/> 
							     </div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivPlacentaTriplets1">
							      <input  type="text" id="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/> </div>
								 <%} %> 
								 
								 
							    </td>							
							<% usgthirdTrimFirstVisitIndex++;} %>
							
							<%if(usgThirdTrimSecondVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg placentaListThirdTrimSecondV : usgThirdTrimSecondVisitList ){
									if(placentaListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("Placenta")){
									%>	
							    <input type="text" value="<%=placentaListThirdTrimSecondV.getUsgParameterValue2() !=null?placentaListThirdTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivPlacentaTwinsColTwo1">
							     <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
							     <div class="" style="display:none" id="dataDivPlacentaTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input  type="text" id="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/>
						 	 <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivPlacentaTwinsColTwo1">
							  <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivPlacentaTwinsColTwo1">
							  <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						    <%} %> 
						 	  
						 	   <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivPlacentaTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivPlacentaTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/> </div>
						 	   <%} %> 
						 	     
						 	    
							  
							  </td>
							<% usgthirdTrimSecondVisitIndex++;} %>
							
							<%if(usgThirdTrimThirdVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg placentaListThirdTrimThirdV : usgThirdTrimThirdVisitList ){
									if(placentaListThirdTrimThirdV.getUsgParameter().equalsIgnoreCase("Placenta")){
									%>	
								<input type="text" value="<%=placentaListThirdTrimThirdV.getUsgParameterValue3() !=null?placentaListThirdTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivPlacentaTwinsColThree1">
							     <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							     <div class="" style="display:none" id="dataDivPlacentaTripletsColThree1">
							     <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input  type="text" id="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> 
						 	    <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivPlacentaTwinsColThree1">
							  <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivPlacentaTwinsColThree1">
							  <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%} %>
						 	       <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivPlacentaTripletsColThree1">
							      <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivPlacentaTripletsColThree1">
							     <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	      <%} %>
							
							  </td>
							<% usgthirdTrimThirdVisitIndex++; } %>
							</tr>
							
							<!-- ------- -->
						
						<tr>
						<td>EBW</td>
						
							<% if(usgThirdTrimFirstVisitList.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg ebwListThirdTrimFirstV : usgThirdTrimFirstVisitList ){
								if(ebwListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("EBW")){
								%>
								<input type="text" value="<%=ebwListThirdTrimFirstV.getUsgParameterValue1() !=null?ebwListThirdTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />

								 <div class="clear"></div>
								<%}}%> 
								</td>
							
							<%} else { %>
							<td><input  type="text" id="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/>
							  <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivEbwTwins1">
							 <input  type="text" id="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/>
							  </div>
								   
								   <%}else{ %> 
								    <div class="" style="display:none" id="dataDivEbwTwins1">
							        <input  type="text" id="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/> 
							        </div>
								   
								   <%} %> 
								
								 <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivEbwTriplets1">
							      <input  type="text" id="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/> 
							     </div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivEbwTriplets1">
							      <input  type="text" id="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/> </div>
								 <%} %> 
								 
								 
							    </td>							
							<% usgthirdTrimFirstVisitIndex++;} %>
							
							<%if(usgThirdTrimSecondVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg ebwListThirdTrimSecondV : usgThirdTrimSecondVisitList ){
									if(ebwListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("EBW")){
									%>	
							    <input type="text" value="<%=ebwListThirdTrimSecondV.getUsgParameterValue2() !=null?ebwListThirdTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivEbwTwinsColTwo1">
							     <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
							     <div class="" style="display:none" id="dataDivEbwTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/> </div>
							<%} }%>
							</td>
							<%} else { %>
							   <td><input  type="text" id="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/>
						 	 <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivEbwTwinsColTwo1">
							  <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivEbwTwinsColTwo1">
							  <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						    <%} %> 
						 	  
						 	   <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivEbwTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivEbwTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/> </div>
						 	   <%} %> 
						 	     
						 	    
							  
							  </td>
							<% usgthirdTrimSecondVisitIndex++;} %>
						
							<%if(usgThirdTrimThirdVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg ebwListThirdTrimThirdV : usgThirdTrimThirdVisitList ){
									if(ebwListThirdTrimThirdV.getUsgParameter().equalsIgnoreCase("EBW")){
									%>	
								<input type="text" value="<%=ebwListThirdTrimThirdV.getUsgParameterValue3() !=null?ebwListThirdTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivEbwTwinsColThree1">
							    <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							    <div class="" style="display:none" id="dataDivEbwTripletsColThree1">
							    <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							<%} }%>
							</td>
							<%} else { %>
							   <td><input  type="text" id="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> 
						 	    <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivEbwTwinsColThree1">
							  <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivEbwTwinsColThree1">
							  <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%} %>
						 	       <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivEbwTripletsColThree1">
							      <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivEbwTripletsColThree1">
							     <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	      <%} %>
							
							  </td>
							<% usgthirdTrimThirdVisitIndex++; } %>
							</tr>
							
							<!-- ------- -->
						
						<tr>
						<td>BPP</td>
						
							<% if(usgThirdTrimFirstVisitList.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg bppListThirdTrimFirstV : usgThirdTrimFirstVisitList ){ 
								if(bppListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("BPP")){
							%>
								<input type="text" value="<%=bppListThirdTrimFirstV.getUsgParameterValue1() !=null?bppListThirdTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />

								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} else { %>
							<td><input  type="text" id="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/>
							  <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivBppTwins1">
							 <input  type="text" id="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/>
							  </div>
								   
								   <%}else{ %> 
								    <div class="" style="display:none" id="dataDivBppTwins1">
							        <input  type="text" id="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/> 
							        </div>
								   
								   <%} %> 
								
								 <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivBppTriplets1">
							      <input  type="text" id="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/> 
							     </div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivBppTriplets1">
							      <input  type="text" id="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/> </div>
								 <%} %> 
								 
								 
							    </td>							
							<% usgthirdTrimFirstVisitIndex++;} %>
							
							<%if(usgThirdTrimSecondVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg bppListThirdTrimSecondV : usgThirdTrimSecondVisitList ){
									if(bppListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("BPP")){
									%>	
							    <input type="text" value="<%=bppListThirdTrimSecondV.getUsgParameterValue2() !=null?bppListThirdTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivBppTwinsColTwo1">
							     <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
							     <div class="" style="display:none" id="dataDivBppTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input  type="text" id="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/>
						 	 <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivBppTwinsColTwo1">
							  <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivBppTwinsColTwo1">
							  <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						    <%} %> 
						 	  
						 	   <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivBppTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivBppTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/> </div>
						 	   <%} %> 
						 	     
						 	    
							  
							  </td>
							<% usgthirdTrimSecondVisitIndex++;} %>
							
							<%if(usgThirdTrimThirdVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg bppListThirdTrimThirdV : usgThirdTrimThirdVisitList ){
									if(bppListThirdTrimThirdV.getUsgParameter().equalsIgnoreCase("BPP")){
									%>	
								<input type="text" value="<%=bppListThirdTrimThirdV.getUsgParameterValue3() !=null?bppListThirdTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivBppTwinsColThree1">
							     <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							     <div class="" style="display:none" id="dataDivBppTripletsColThree1">
							     <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							<%} }%>
							</td>
							<%} else { %>
							   <td><input  type="text" id="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> 
						 	    <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivBppTwinsColThree1">
							  <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivBppTwinsColThree1">
							  <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%} %>
						 	       <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivBppTripletsColThree1">
							      <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivBppTripletsColThree1">
							     <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	      <%} %>
							
							  </td>
							<% usgthirdTrimThirdVisitIndex++; } %>
							</tr>
							
							
							<!-- ------- -->
						
						<tr>
						<td>Doppler</td>
						
							<% if(usgThirdTrimFirstVisitList.size()>0){ %>
							  <td>
								 <%
							for(OpdAntenatalUsg dopplerListThirdTrimFirstV : usgThirdTrimFirstVisitList ){ 
								if(dopplerListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("Doppler")){
							%>
								<input type="text" value="<%=dopplerListThirdTrimFirstV.getUsgParameterValue1() !=null?dopplerListThirdTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />

								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} else { %>
							<td><input  type="text" id="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/>
							  <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivDopplerTwins1">
							 <input  type="text" id="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/>
							  </div>
								   
								   <%}else{ %> 
								    <div class="" style="display:none" id="dataDivDopplerTwins1">
							        <input  type="text" id="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/> 
							        </div>
								   
								   <%} %> 
								
								 <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivDopplerTriplets1">
							      <input  type="text" id="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/> 
							     </div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivDopplerTriplets1">
							      <input  type="text" id="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/> </div>
								 <%} %> 
								 
								 
							    </td>							
							<% usgthirdTrimFirstVisitIndex++;} %>
						
							<%if(usgThirdTrimSecondVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg dopplerListThirdTrimSecondV : usgThirdTrimSecondVisitList ){
									if(dopplerListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("Doppler")){
									%>	
							    <input type="text" value="<%=dopplerListThirdTrimSecondV.getUsgParameterValue2() !=null?dopplerListThirdTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								
								 <div class="clear"></div>
							     <div class="" style="display:none" id="dataDivDopplerTwinsColTwo1">
							     <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
							     <div class="" style="display:none" id="dataDivDopplerTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input  type="text" id="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/>
						 	 <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivDopplerTwinsColTwo1">
							  <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivDopplerTwinsColTwo1">
							  <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						    <%} %> 
						 	  
						 	   <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivDopplerTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivDopplerTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/> </div>
						 	   <%} %> 
						 	     
						 	    
							  
							  </td>
							<% usgthirdTrimSecondVisitIndex++;} %>
							
							<%if(usgThirdTrimThirdVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg dopplerListThirdTrimThirdV : usgThirdTrimThirdVisitList ){ 
									if(dopplerListThirdTrimThirdV.getUsgParameter().equalsIgnoreCase("Doppler")){
								%>	
								<input type="text" value="<%=dopplerListThirdTrimThirdV.getUsgParameterValue3() !=null?dopplerListThirdTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivDopplerTwinsColThree1">
							     <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							     <div class="" style="display:none" id="dataDivDopplerTripletsColThree1">
							     <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/></div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input  type="text" id="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> 
						 	    <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivDopplerTwinsColThree1">
							  <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivDopplerTwinsColThree1">
							  <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%} %>
						 	       <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivDopplerTripletsColThree1">
							      <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivDopplerTripletsColThree1">
							     <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	      <%} %>
							
							  </td>
							<% usgthirdTrimThirdVisitIndex++; } %>
							</tr>
							
							<!-- ------- -->
						
						<tr>
						<td>Impression</td>
						
							<% if(usgThirdTrimFirstVisitList.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg impressionListThirdTrimFirstV : usgThirdTrimFirstVisitList ){ 
								if(impressionListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("Impression")){
							%>
								<input type="text" value="<%=impressionListThirdTrimFirstV.getUsgParameterValue1() !=null?impressionListThirdTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />

								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} else { %>
							<td><input  type="text" id="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/>
							  <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivImpressionTwins1">
							 <input  type="text" id="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/>
							  </div>
								   
								   <%}else{ %> 
								    <div class="" style="display:none" id="dataDivImpressionTwins1">
							        <input  type="text" id="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/> 
							        </div>
								   
								   <%} %> 
								
								 <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivImpressionTriplets1">
							      <input  type="text" id="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/> 
							     </div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivImpressionTriplets1">
							      <input  type="text" id="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/> </div>
								 <%} %> 
								 
								 
							    </td>							
							<% usgthirdTrimFirstVisitIndex++;} %>
							
							<%if(usgThirdTrimSecondVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg impressionListThirdTrimSecondV : usgThirdTrimSecondVisitList ){
									if(impressionListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("Impression")){
									%>	
							    <input type="text" value="<%=impressionListThirdTrimSecondV.getUsgParameterValue2() !=null?impressionListThirdTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivImpressionTwinsColTwo1">
							     <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
							     <div class="" style="display:none" id="dataDivImpressionTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input  type="text" id="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/>
						 	 <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivImpressionTwinsColTwo1">
							  <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivImpressionTwinsColTwo1">
							  <input  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						    <%} %> 
						 	  
						 	   <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivImpressionTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivImpressionTripletsColTwo1">
							     <input  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/> </div>
						 	   <%} %> 
						 	     
						 	    
							  
							  </td>
							<% usgthirdTrimSecondVisitIndex++;} %>
							
							<%if(usgThirdTrimThirdVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg impressionListThirdTrimThirdV : usgThirdTrimThirdVisitList ){ 
									if(impressionListThirdTrimThirdV.getUsgParameter().equalsIgnoreCase("Impression")){
								%>	
								<input type="text" value="<%=impressionListThirdTrimThirdV.getUsgParameterValue3() !=null?impressionListThirdTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivImpressionTwinsColThree1">
							     <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							     <div class="" style="display:none" id="dataDivImpressionTripletsColThree1">
							     <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/></div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input  type="text" id="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> 
						 	    <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivImpressionTwinsColThree1">
							  <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivImpressionTwinsColThree1">
							  <input  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%} %>
						 	       <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivImpressionTripletsColThree1">
							      <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivImpressionTripletsColThree1">
							     <input  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/></div>
						 	      <%} %>
							
							  </td>
							<% usgthirdTrimThirdVisitIndex++; } %>
							</tr>
							
							<!-- ------- -->
						
						<tr>
						<td>Remarks</td>
						
							<% if(usgThirdTrimFirstVisitList.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg remarksListThirdTrimFirstV : usgThirdTrimFirstVisitList ){
									if(remarksListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("Remarks")){
									%>
								<textarea type="text" readonly="readonly" ><%=remarksListThirdTrimFirstV.getUsgParameterValue1() !=null?remarksListThirdTrimFirstV.getUsgParameterValue1():"" %></textarea>
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} else { %>
							<td><textarea type="text" name="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" id="usgThirdTrimFirstV<%=usgthirdTrimFirstVisitIndex%>" maxlength="256" value="" tabindex="1"></textarea>
							  <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivThirdRemarksTwins1">
							       <textarea type="text" id="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="256" tabindex="1"></textarea></div>
								   
								   <%}else{ %> 
								    <div class="" style="display:none" id="dataDivThirdRemarksTwins1">
							        <textarea type="text" id="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTwinsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="256" tabindex="1"></textarea></div>
								   
								   <%} %> 
								
								 <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivThirdRemarksTriplets1">
							     <textarea  type="text" id="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="256" tabindex="1"></textarea></div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivThirdRemarksTriplets1">
							     <textarea type="text" id="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" name="usgThirdTrimTripletsFirstV<%=usgthirdTrimFirstVisitIndex%>" value="" maxlength="256" tabindex="1"></textarea></div>
								 <%} %> 
								 
								 
							    </td>							
							<% usgthirdTrimFirstVisitIndex++;} %>
							
							<%if(usgThirdTrimSecondVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg remarksListThirdTrimSecondV : usgThirdTrimSecondVisitList ){
									if(remarksListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("Remarks")){
									%>	
								<textarea type="text"  readonly="readonly" ><%=remarksListThirdTrimSecondV.getUsgParameterValue2() !=null?remarksListThirdTrimSecondV.getUsgParameterValue2():"" %></textarea>
								 <div class="clear"></div>
							     <div class="" style="display:none" id="dataDivThirdRemarksTwinsColTwo1">
							     <textarea  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="256" tabindex="2"></textarea></div>
							     <div class="" style="display:none" id="dataDivThirdRemarksTripletsColTwo1">
							     <textarea  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="256" tabindex="2"></textarea> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><textarea type="text" name="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" id="usgThirdTrimSecondV<%=usgthirdTrimSecondVisitIndex%>" maxlength="256" tabindex="2"></textarea>
						 	 <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivThirdRemarksTwinsColTwo1">
							  <textarea  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="256" tabindex="2"></textarea></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivThirdRemarksTwinsColTwo1">
							  <textarea  type="text" id="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTwinsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="256" tabindex="2"></textarea></div>
						    <%} %> 
						 	  
						 	   <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivThirdRemarksTripletsColTwo1">
							     <textarea  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="256" tabindex="2"></textarea></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivThirdRemarksTripletsColTwo1">
							     <textarea  type="text" id="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" name="usgThirdTrimTripletsSecondV<%=usgthirdTrimSecondVisitIndex%>" value="" maxlength="256" tabindex="2"></textarea> </div>
						 	   <%} %> 
						 	     
						 	    
							  
							  </td>
							<% usgthirdTrimSecondVisitIndex++;} %>
						
							<%if(usgThirdTrimThirdVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg remarksListThirdTrimThirdV : usgThirdTrimThirdVisitList ){
									if(remarksListThirdTrimThirdV.getUsgParameter().equalsIgnoreCase("Remarks")){
									%>	
								<textarea type="text" readonly="readonly"  ><%=remarksListThirdTrimThirdV.getUsgParameterValue3() !=null?remarksListThirdTrimThirdV.getUsgParameterValue3():"" %></textarea>
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivThirdRemarksTwinsColThree1">
							     <textarea  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="256" tabindex="3"></textarea></div>
							     <div class="" style="display:none" id="dataDivThirdRemarksTripletsColThree1">
							     <textarea  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="256" tabindex="3"></textarea> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><textarea type="text" name="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex %>" value="" id="usgThirdTrimThirdV<%=usgthirdTrimThirdVisitIndex %>" maxlength="256" tabindex="3"> </textarea>
						 	    <% if(usgThirdTrimFlag.equalsIgnoreCase("Twins") || usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivThirdRemarksTwinsColThree1">
							  <textarea  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="256" tabindex="3"></textarea></div>
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivThirdRemarksTwinsColThree1">
							  <textarea  type="text" id="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTwinsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="256" tabindex="3"></textarea></div>
						 	   <%} %>
						 	       <% if(usgThirdTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivThirdRemarksTripletsColThree1">
							      <textarea  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="256" tabindex="3"></textarea></div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivThirdRemarksTripletsColThree1">
							     <textarea  type="text" id="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" name="usgThirdTrimTripletsThirdV<%=usgthirdTrimThirdVisitIndex%>" value="" maxlength="256" tabindex="3"></textarea> </div>
						 	      <%} %>
							
							  </td>
							<% usgthirdTrimThirdVisitIndex++; } %>
							</tr>
							   
						</table> 
						
			<div class="clear"></div>
			<%-- <label>Remarks</label>			
				<input type="text" name="usgThirdTrimRemarks" value="<%=usgThirdRemarks != null?usgThirdRemarks:"" %>" id="usgThirdTrimRemarks" class="large" maxlength="100" /> --%>		
		
		</div>
		</div>	 