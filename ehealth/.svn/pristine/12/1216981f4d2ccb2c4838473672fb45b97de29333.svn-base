<%@page import="jkt.hms.masters.business.OpdAntenatalUsg"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.*"%>
<script type="text/javascript" src="/hms/jsp/js/antenatal2.js"></script>
<%
List<OpdAntenatalUsg> usgSecondTrimFirstVisitList= new ArrayList<OpdAntenatalUsg>();
List<OpdAntenatalUsg>  usgSecondTrimSecondVisitList= new ArrayList<OpdAntenatalUsg>();
List<OpdAntenatalUsg>  usgSecondTrimThirdVisitList= new ArrayList<OpdAntenatalUsg>();

if((List) request.getAttribute("usgSecondTrimFirstVisitList")!=null){
	usgSecondTrimFirstVisitList = (List<OpdAntenatalUsg>)request.getAttribute("usgSecondTrimFirstVisitList");
}
if((List) request.getAttribute("usgSecondTrimSecondVisitList")!=null){
	usgSecondTrimSecondVisitList = (List<OpdAntenatalUsg>)request.getAttribute("usgSecondTrimSecondVisitList");
}
if((List) request.getAttribute("usgSecondTrimThirdVisitList")!=null){
	usgSecondTrimThirdVisitList = (List<OpdAntenatalUsg>)request.getAttribute("usgSecondTrimThirdVisitList");
}
String usgSecondTrimFlag="";
if(request.getAttribute("usgSecondTrimFlag")!=null){
	usgSecondTrimFlag = (String)request.getAttribute("usgSecondTrimFlag");
}

String revisitFlagSecondTrim="";
if(request.getAttribute("revisitFlagSecondTrim")!=null){
	revisitFlagSecondTrim=(String)request.getAttribute("revisitFlagSecondTrim");
}

Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String dateC = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
%>

<div class="clear"></div>
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="displayCollapsibleTab('usg Second')" id="usgSecondDivId" name="" value="-" type="button"></div>
<div class="plusText"><h4 class="h4Tab">USG Report Second Trimester</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
		<div  id="usgSecondDiv"  >
		<div class="indArrow"></div>		
		<div class="Block">
		<table border="0" align="center" cellpadding="0" cellspacing="0"  style="border-top: 1px solid #C0C0C0; width:800px; float:left; margin-left:5px;">
							    <%int usgSecondTrimFirstVisitIndex = 1; int usgSecondTrimSecondVisitIndex= 1; int usgSecondTrimThirdVisitIndex= 1; %>
							   <%--  <%int l= 1;int v=1;int n=1; %> --%>
							  <tr><td><b>USG</b>(2nd Trimester)</td>
							  <%if(usgSecondTrimFlag !=null && !usgSecondTrimFlag.equals("")){ %>
							   <td colspan="3">				    
 <div style="width:75px; float:left;"><input style="margin-top:-3px;" id="usgSecondSingle" name="usgSecondTrimTwo" type="radio"  <%=usgSecondTrimFlag.equalsIgnoreCase("single")?"checked":""%> onclick="setSecondUsgFlag();usgSecondTrimDivShowHideRevisit();" >Single</div>
 <div style="width:75px; float:left;"><input style="margin-top:-3px;" id="usgSecondTrimTwins" name="usgSecondTrimTwo" type="radio"  <%=usgSecondTrimFlag.equalsIgnoreCase("Twins")?"checked":""%> onclick="setSecondUsgFlag();usgSecondTrimDivShowHideRevisit();" >Twins</div>
 <div style="width:75px; float:left;"><input style="margin-top:-3px;" id="usgSecondTrimTriplets" name="usgSecondTrimTwo" type="radio"  <%=usgSecondTrimFlag.equalsIgnoreCase("Triplets")?"checked":""%> onclick="setSecondUsgFlag();usgSecondTrimDivShowHideRevisit();" >Triplets</div>
                                       <input type="hidden" name="usgFlagSecondTrimRevisit" id="usgFlagSecondTrimRevisit" value="<%=revisitFlagSecondTrim %>" />
                                       <input type="hidden" name="secondTrimRevisitThirdV" id="secondTrimRevisitThirdV" value="<%=usgSecondTrimThirdVisitList.size() %>" />
                                      <input type="hidden" name="usgFlagSecondTrim" id="usgFlagSecondTrim" value="<%=usgSecondTrimFlag %>" />
     
     </td>
							  <%}else{ %>
							  
						    <td colspan="3">				    
 <div style="width:75px; float:left;"><input style="margin-top:-3px;" id="usgSecondSingle" name="usgSecondTrimTwo" type="radio" checked="checked"   onclick="setSecondUsgFlag();usgSecondTrimDivShowHide();">Single</div>
 <div style="width:75px; float:left;"><input style="margin-top:-3px;" id="usgSecondTrimTwins" name="usgSecondTrimTwo" type="radio"  onclick="setSecondUsgFlag();usgSecondTrimDivShowHide();">Twins</div>
 <div style="width:75px; float:left;"><input style="margin-top:-3px;" id="usgSecondTrimTriplets" name="usgSecondTrimTwo" type="radio"  onclick="setSecondUsgFlag();usgSecondTrimDivShowHide();">Triplets</div>
                                      <input type="hidden" name="usgFlagSecondTrim" id="usgFlagSecondTrim" value="" />
     
     </td>
     <%} %>
						</tr>	  
						 <tr>
						<td>USG Parameters
						<!-- <td>Date</td> -->
					
							<% if(usgSecondTrimFirstVisitList.size()>0){ 
								for(OpdAntenatalUsg dateListSecondTrimFirstV : usgSecondTrimFirstVisitList ){
									if(dateListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("Date")){
									%>
								
								 <td><input type="text" value="<%=dateListSecondTrimFirstV.getUsgParameterValue1() != null?dateListSecondTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />
								<div class="clear"></div>
								</td>
							
							<%break;}}} else { %>
							<td><input type="text" name="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" id="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" class="small" readonly="readonly" tabindex="1" onblur="validateUSGDate(this.id);ValidateLmp(this.id);"/>
							<img src="/hms/jsp/images/cal.gif" width="16" height="16"  border="0" validate="Pick a date" onclick="setdate('<%=dateC%>',document.getElementById('usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>'),event);setSecondTrimFirstVisitFlag()" />
							<input type="hidden" name="secondTrimFirstVisitFlag" id="secondTrimFirstVisitFlag" value="" />	
							</td>							
							<% usgSecondTrimFirstVisitIndex++;} %>
							
							
							<%if(usgSecondTrimSecondVisitList.size()>0){ 
							for(OpdAntenatalUsg dateListSecondTrimSecondV : usgSecondTrimSecondVisitList ){ 
								if(dateListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("Date")){
							%>
								<td><input type="text" value="<%=dateListSecondTrimSecondV.getUsgParameterValue2() != null?dateListSecondTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
							</td>
							<%break;}} }else { %>
							 <td><input type="text" name="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" id="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" class="small" readonly="readonly" tabindex="2" onblur="validateUSGDate(this.id);ValidateLmp(this.id);"/>
							<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=dateC%>',document.getElementById('usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>'),event);setSecondTrimSecondVisitFlag()">
							<input type="hidden" name="secondTrimSecondVisitFlag" id="secondTrimSecondVisitFlag" value="" />
							</td>
							<% usgSecondTrimSecondVisitIndex++;} %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){ 
							for(OpdAntenatalUsg dateListSecondTrimThirdV : usgSecondTrimThirdVisitList ){ 
								if(dateListSecondTrimThirdV.getUsgParameter().equalsIgnoreCase("Date")){
							%>
								<td><input type="text" value="<%=dateListSecondTrimThirdV.getUsgParameterValue3() != null?dateListSecondTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
							</td>
							<%break;}}} else {%>
							   <td><input type="text" name="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" id="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex%>"  class="small" readonly="readonly" tabindex="3" onblur="validateUSGDate(this.id);ValidateLmp(this.id);"/>
							<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=dateC%>',document.getElementById('usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex%>'),event);setSecondTrimThirdVisitFlag()">
							<input type="hidden" name="secondTrimThirdVisitFlag" id="secondTrimThirdVisitFlag" value="" />
							</td>
							<% usgSecondTrimThirdVisitIndex++; } %> 
							
							</tr> 
						
						<!-- ------- -->
						 <tr>
						<td>LMP GA</td>
						
							<% if(usgSecondTrimFirstVisitList.size()>0){ %>
							  <td>
								<% for(OpdAntenatalUsg lmpGAListSecondTrimFirstV:usgSecondTrimFirstVisitList ){
									 if(lmpGAListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("LMP GA")){
									 %>
								
								<input type="text" value="<%=lmpGAListSecondTrimFirstV.getUsgParameterValue1() != null?lmpGAListSecondTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} else { %>
							
							<td><input type="text" id="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" />
						 	 <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	  <div class="" style="display:block" id="dataDivLmpGaTwins">
						 	   <input  type="text" id="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /></div> 
						 	  <%}else{ %>
						 	  <div class="" style="display:none" id="dataDivLmpGaTwins">
						 	   <input  type="text" id="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /></div> 
						 	  <%} %> 
						 	  
						 	  <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	  <div class="" style="display:block" id="dataDivLmpGaTriplets">
							 <input  type="text" id="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> 
							  </div>
						 	  <%} else { %> 
						 	  <div class="" style="display:none" id="dataDivLmpGaTriplets">
							 <input  type="text" id="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> 
							  </div>
						 	<%} %>
							 </td>							
							<% usgSecondTrimFirstVisitIndex++;
							} %>
							
							<%if(usgSecondTrimSecondVisitList.size()>0){%>
							  <td>
								<%  for(OpdAntenatalUsg lmpGAListSecondTrimSecondV:usgSecondTrimSecondVisitList ){ 
									 if(lmpGAListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("LMP GA")){
								 %> 
								<input type="text" value="<%=lmpGAListSecondTrimSecondV.getUsgParameterValue2() != null?lmpGAListSecondTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly" disabled="disabled" />
								 <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivLmpGaTwinsColTwo">
							   <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /></div>  
							   <div class="" style="display:none" id="dataDivLmpGaTripletsColTwo">
							   <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /> </div>
							<%} }%>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" id="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" maxlength="128" tabindex="2"/>
						 	  <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivLmpGaTwinsColTwo">
							  <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /></div>  
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivLmpGaTwinsColTwo">
							  <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /></div>  
						 	  <%} %>
						 	    <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	     <div class="" style="display:block" id="dataDivLmpGaTripletsColTwo">
							    <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"  /> </div>
						 	    <%}else{ %> 
						 	     <div class="" style="display:none" id="dataDivLmpGaTripletsColTwo">
							   <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /> </div>
						 	   <%} %> 
							
							  </td>
							<% usgSecondTrimSecondVisitIndex++;} %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg lmpGAListSecondTrimThirdV:usgSecondTrimThirdVisitList ){ 
									 if(lmpGAListSecondTrimThirdV.getUsgParameter().equalsIgnoreCase("LMP GA")){
								 %> 
								<input type="text" value="<%=lmpGAListSecondTrimThirdV.getUsgParameterValue3() != null?lmpGAListSecondTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly" disabled="disabled" />
								 <div class="clear"></div>
								   <div class="" style="display:none" id="dataDivLmpGaTwinsColThree">
							       <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							       <div class="" style="display:none" id="dataDivLmpGaTripletsColThree">
							     <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128"  tabindex="3"/></div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex %>" value="" id="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex %>"maxlength="128" tabindex="3" />
							   <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivLmpGaTwinsColThree">
							        <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
								   <%}else{ %>
								    <div class="" style="display:none" id="dataDivLmpGaTwinsColThree">
							       <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							   <%} %> 
								  <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
							  <div class="" style="display:block" id="dataDivLmpGaTripletsColThree">
							  <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							  <%}else{ %> 
							  <div class="" style="display:none" id="dataDivLmpGaTripletsColThree">
							  <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128"  tabindex="3"/></div>
							  <%} %>
							  </td>
							<%} usgSecondTrimThirdVisitIndex++; %>
							
							</tr>
						<!-- ------ -->
						
						<tr>
						<td>USG GA</td>
						
							<% if(usgSecondTrimFirstVisitList.size()>0){ %>
							  <td>
								<%  for(OpdAntenatalUsg usgGAListSecondTrimFirstV:usgSecondTrimFirstVisitList ){ 
								  if(usgGAListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("USG GA")){
							  %>	
								<input type="text" value="<%=usgGAListSecondTrimFirstV.getUsgParameterValue1() != null?usgGAListSecondTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />
							     <div class="clear"></div>
							<%}} %>	
								</td>							
							<%} else { %>
							<td><input type="text" name="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" id="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" maxlength="128" tabindex="1" />
								  <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivUsgGaTwins">
							       <input  type="text" id="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /></div>
								   
								   <%}else{ %>
								    <div class="" style="display:none" id="dataDivUsgGaTwins">
							        <input  type="text" id="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /></div>
								   
								 <%} 
								
								 if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivUsgGaTriplets">
							     <input  type="text" id="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128"  tabindex="1" /></div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivUsgGaTriplets">
							     <input  type="text" id="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"  /></div>
								<%} %> 
								 
								 
							    </td>							
							<% usgSecondTrimFirstVisitIndex++;} %>
						
							<%if(usgSecondTrimSecondVisitList.size()>0){%>
							  <td>
								<%  for(OpdAntenatalUsg usgGAListSecondTrimSecondV:usgSecondTrimSecondVisitList ){
									 if(usgGAListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("USG GA")){
									 %>		
								
								<input type="text" value="<%=usgGAListSecondTrimSecondV.getUsgParameterValue2() != null?usgGAListSecondTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								   <div class="" style="display:none" id="dataDivUsgGaTwinsColTwo">
							      <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /></div>
							      <div class="" style="display:none" id="dataDivUsgGaTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /> </div>
							<%} }%>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" id="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" maxlength="128" tabindex="2"/>
						 	 <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivUsgGaTwinsColTwo">
							  <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /></div>
						 	  <%}else{ %> 
						 	    <div class="" style="display:none" id="dataDivUsgGaTwinsColTwo">
							  <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /></div>
						   <%} %> 
						 	  
						 	  <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivUsgGaTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /> </div>
						 	  <%}else{ %> 
						 	    <div class="" style="display:none" id="dataDivUsgGaTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /> </div>
						 	  <%} %> 
						 	     
						 	    
							  
							  </td>
							<% usgSecondTrimSecondVisitIndex++;} %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg usgGAListSecondTrimThirdV : usgSecondTrimThirdVisitList ){
									 if(usgGAListSecondTrimThirdV.getUsgParameter().equalsIgnoreCase("USG GA")){
									 %>
								
								<input type="text" value="<%=usgGAListSecondTrimThirdV.getUsgParameterValue3() != null?usgGAListSecondTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivUsgGaTwinsColThree">
							  <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							   <div class="" style="display:none" id="dataDivUsgGaTripletsColThree">
							     <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex %>" value="" id="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex %>" maxlength="128" tabindex="3"  />
						 	 <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivUsgGaTwinsColThree">
							  <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
						 	   <%}else{ %>
						 	   <div class="" style="display:none" id="dataDivUsgGaTwinsColThree">
							  <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
						 	  <%} %> 
						 	      <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivUsgGaTripletsColThree">
							      <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/></div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivUsgGaTripletsColThree">
							     <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	       <%} %> 
							
							  </td>
							<% usgSecondTrimThirdVisitIndex++; } %>
							
							</tr>
							<!-- ----- -->
							<tr>
						<td>BPD</td>
						
							<% if(usgSecondTrimFirstVisitList.size()>0){%>
							  <td>
								<%  for(OpdAntenatalUsg bpdListSecondTrimFirstV:usgSecondTrimFirstVisitList ){
									 if(bpdListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("BPD")){
									 %>		
								
								<input type="text" value="<%=bpdListSecondTrimFirstV.getUsgParameterValue1() !=null?bpdListSecondTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} else { %>
							<td><input type="text" name="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" id="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" maxlength="128"  tabindex="1" />
								   <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivBpdTwins">
							       <input  type="text" id="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /></div>
								   
								   <%}else{ %> 
								    <div class="" style="display:none" id="dataDivBpdTwins">
							        <input  type="text" id="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /></div>
								   
								  <%} %> 
								
							 <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivBpdTriplets">
							     <input  type="text" id="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128"  tabindex="1" /></div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivBpdTriplets">
							     <input  type="text" id="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128"  tabindex="1" /></div>
							 <%} %> 
								 
								 
							    </td>							
							<% usgSecondTrimFirstVisitIndex++;} %>
							
							<%if(usgSecondTrimSecondVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg bpdListSecondTrimSecondV:usgSecondTrimSecondVisitList ){ 
									 if(bpdListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("BPD")){
								%>	
								<input type="text" value="<%=bpdListSecondTrimSecondV.getUsgParameterValue2() !=null?bpdListSecondTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivBpdTwinsColTwo">
							  <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /></div>
							   <div class="" style="display:none" id="dataDivBpdTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /> </div>
							<%} }%>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" id="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" maxlength="128" tabindex="2"/>
						 	  <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivBpdTwinsColTwo">
							  <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"  /></div>
						 	  <%}else{ %> 
						 	    <div class="" style="display:none" id="dataDivBpdTwinsColTwo">
							  <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /></div>
						  <%} %> 
						 	  
						 	  <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivBpdTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /> </div>
						 	  <%}else{ %> 
						 	    <div class="" style="display:none" id="dataDivBpdTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /> </div>
						 	   <%} %> 
						 	     
						 	    
							  
							  </td>
							<% usgSecondTrimSecondVisitIndex++;} %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg bpdListSecondTrimSecondtV:usgSecondTrimThirdVisitList ){
									 if(bpdListSecondTrimSecondtV.getUsgParameter().equalsIgnoreCase("BPD")){
									%>	 
								
								<input type="text" value="<%=bpdListSecondTrimSecondtV.getUsgParameterValue3() !=null?bpdListSecondTrimSecondtV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivBpdTwinsColThree">
							    <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							    <div class="" style="display:none" id="dataDivBpdTripletsColThree">
							     <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							<%}}%>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex %>" value="" id="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex %>" maxlength="128"  tabindex="3" />
						 	   <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivBpdTwinsColThree">
							  <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivBpdTwinsColThree">
							  <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
						 	   <%} %> 
						 	  <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivBpdTripletsColThree">
							      <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/></div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivBpdTripletsColThree">
							     <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%} %> 
							
							  </td>
							<% usgSecondTrimThirdVisitIndex++; } %>							
							</tr>						
						<!-- ------ -->
						<tr>
						<td>HC</td>
						
							<% if(usgSecondTrimFirstVisitList.size()>0){%>
							  <td>
								<%  for(OpdAntenatalUsg hcListSecondTrimFirstV:usgSecondTrimFirstVisitList ){
									 if(hcListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("HC")){
									 %>	
								
								<input type="text" value="<%=hcListSecondTrimFirstV.getUsgParameterValue1() !=null?hcListSecondTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} else { %>
							<td><input type="text" name="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" id="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" maxlength="128" tabindex="1" />
								   <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivHcTwins">
							       <input  type="text" id="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /></div>
								   
								   <%}else{ %> 
								    <div class="" style="display:none" id="dataDivHcTwins">
							        <input  type="text" id="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /></div>
								   
								  <%} %> 
								
								 <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivHcTriplets">
							     <input  type="text" id="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128"  tabindex="1" /></div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivHcTriplets">
							     <input  type="text" id="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"  /></div>
							 <%} %> 
								 
								 
							    </td>							
							<% usgSecondTrimFirstVisitIndex++;} %>
						
							<%if(usgSecondTrimSecondVisitList.size()>0){%>
							  <td>
								<%  for(OpdAntenatalUsg hcListSecondTrimSecondV:usgSecondTrimSecondVisitList ){ 
									 if(hcListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("HC")){
								 %>	
								<input type="text" value="<%=hcListSecondTrimSecondV.getUsgParameterValue2() !=null?hcListSecondTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivHcTwinsColTwo">
							     <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"  /></div>
							     <div class="" style="display:none" id="dataDivHcTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128"  tabindex="2"/> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" id="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" maxlength="128" tabindex="2"/>
						 	 <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivHcTwinsColTwo">
							  <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /></div>
						 	  <%}else{ %> 
						 	    <div class="" style="display:none" id="dataDivHcTwinsColTwo">
							  <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"  /></div>
						    <%} %> 
						 	  
						  <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivHcTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /> </div>
						 	  <%}else{ %> 
						 	    <div class="" style="display:none" id="dataDivHcTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128"  tabindex="2"/> </div>
						 	  <%} %> 
						 	    
							  
							  </td>
							<% usgSecondTrimSecondVisitIndex++;} %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){%>
							  <td>
								<%  for(OpdAntenatalUsg hcListSecondTrimThirdV:usgSecondTrimThirdVisitList ){
									 if(hcListSecondTrimThirdV.getUsgParameter().equalsIgnoreCase("HC")){
									 %>	
								 
								<input type="text" value="<%=hcListSecondTrimThirdV.getUsgParameterValue3() !=null?hcListSecondTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivHcTwinsColThree">
							     <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							     <div class="" style="display:none" id="dataDivHcTripletsColThree">
							     <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							<%} }%>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex %>" value="" id="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex %>" maxlength="128" tabindex="3"  />
						 	  <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivHcTwinsColThree">
							  <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128"  tabindex="3"/></div>
						 	   <%}else{ %>
						 	   <div class="" style="display:none" id="dataDivHcTwinsColThree">
							  <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
						 	   <%} %>
						 	       <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivHcTripletsColThree">
							      <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/></div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivHcTripletsColThree">
							     <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	       <%} %> 
							
							  </td>
							<% usgSecondTrimThirdVisitIndex++; } %>
							
							</tr>						
						<!-- ------ -->
						<tr>
						<td>AC</td>
						
							<% if(usgSecondTrimFirstVisitList.size()>0){ %>
							  <td>
								<% 		for(OpdAntenatalUsg acListSecondTrimFirstV:usgSecondTrimFirstVisitList ){ 
									 if(acListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("AC")){
								%>	
								<input type="text" value="<%=acListSecondTrimFirstV.getUsgParameterValue1() !=null?acListSecondTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} else { %>
							<td><input type="text" name="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" id="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" maxlength="128" tabindex="1" />
								  <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivAcTwins">
							       <input  type="text" id="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /></div>
								   
								   <%}else{ %> 
								    <div class="" style="display:none" id="dataDivAcTwins">
							        <input  type="text" id="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /></div>
								   
								    <%} %> 
								
								<% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivAcTriplets">
							     <input  type="text" id="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"  /></div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivAcTriplets">
							     <input  type="text" id="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"  /></div>
								 <%} %> 
								 
								 
							    </td>							
							<% usgSecondTrimFirstVisitIndex++;} %>
						
							<%if(usgSecondTrimSecondVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg acListSecondTrimSecondV : usgSecondTrimSecondVisitList ){
									if(acListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("AC")){
									%>	
								<input type="text" value="<%=acListSecondTrimSecondV.getUsgParameterValue2() !=null?acListSecondTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivAcTwinsColTwo">
							     <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /></div>
							     <div class="" style="display:none" id="dataDivAcTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" id="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" maxlength="128" tabindex="2"/>
						 	 <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivAcTwinsColTwo">
							  <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"  /></div>
						 	  <%}else{ %> 
						 	    <div class="" style="display:none" id="dataDivAcTwinsColTwo">
							  <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /></div>
						 	  <%} %> 
						 	  
						   <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivAcTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /> </div>
						 	  <%}else{ %> 
						 	    <div class="" style="display:none" id="dataDivAcTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /> </div>
						 	  <%} %> 
						 	     
						 	    
							  
							  </td>
							<% usgSecondTrimSecondVisitIndex++;} %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg acListSecondTrimThirdV : usgSecondTrimThirdVisitList ){
									if(acListSecondTrimThirdV.getUsgParameter().equalsIgnoreCase("AC")){
								%>	
								<input type="text" value="<%=acListSecondTrimThirdV.getUsgParameterValue3() !=null?acListSecondTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivAcTwinsColThree">
							     <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							     <div class="" style="display:none" id="dataDivAcTripletsColThree">
							     <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							<%} }%>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex %>" value="" id="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex %>" maxlength="128" tabindex="3"  />
						 	   <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivAcTwinsColThree">
							  <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
						 	   <%}else{ %>
						 	   <div class="" style="display:none" id="dataDivAcTwinsColThree">
							  <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
						 	   <%} %>
						 	      <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivAcTripletsColThree">
							      <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/></div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivAcTripletsColThree">
							     <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	      <%} %> 
							
							  </td>
							<% usgSecondTrimThirdVisitIndex++; } %>
							</tr>
							
							
						
						<!-- ------- -->
						
						<tr>
						<td>FL</td>
						
							<% if(usgSecondTrimFirstVisitList.size()>0){ %>
							  <td>
								<%   
							for(OpdAntenatalUsg flListSecondTrimFirstV : usgSecondTrimFirstVisitList ){
								if(flListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("FL")){
								%>
								<input type="text" value="<%=flListSecondTrimFirstV.getUsgParameterValue1() !=null?flListSecondTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />

								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} else { %>
							<td><input  type="text" id="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" />
							  <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivFlTwins">
							 <input  type="text" id="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" />
							  </div>
								   
								   <%}else{ %> 
								    <div class="" style="display:none" id="dataDivFlTwins">
							        <input  type="text" id="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> 
							        </div>
								   
								   <%} %> 
								
								 <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivFlTriplets">
							      <input  type="text" id="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> 
							     </div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivFlTriplets">
							      <input  type="text" id="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> </div>
								 <%} %> 
								 
								 
							    </td>							
							<% usgSecondTrimFirstVisitIndex++;} %>
							
							<%if(usgSecondTrimSecondVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg flListSecondTrimSecondV : usgSecondTrimSecondVisitList ){
									if(flListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("FL")){
									%>	
							    <input type="text" value="<%=flListSecondTrimSecondV.getUsgParameterValue2() !=null?flListSecondTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								
								 <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivFlTwinsColTwo">
							     <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
							     <div class="" style="display:none" id="dataDivFlTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td> <input  type="text" id="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/>
						 	 <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivFlTwinsColTwo">
							  <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivFlTwinsColTwo">
							  <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						    <%} %> 
						 	  
						 	   <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivFlTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivFlTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/> </div>
						 	   <%} %> 
						 	     
						 	    
							  
							  </td>
							<% usgSecondTrimSecondVisitIndex++;} %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg flListSecondTrimThirdV : usgSecondTrimThirdVisitList ){ 
									if(flListSecondTrimThirdV.getUsgParameter().equalsIgnoreCase("FL")){
								%>	
								<input type="text" value="<%=flListSecondTrimThirdV.getUsgParameterValue3() !=null?flListSecondTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivFlTwinsColThree">
							     <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							     <div class="" style="display:none" id="dataDivFlTripletsColThree">
							     <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input  type="text" id="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> 
						 	    <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivFlTwinsColThree">
							  <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivFlTwinsColThree">
							  <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%} %>
						 	       <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivFlTripletsColThree">
							      <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivFlTripletsColThree">
							     <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	      <%} %>
							
							  </td>
							<% usgSecondTrimThirdVisitIndex++; } %>
							</tr>
							
							<!-- ------- -->
						
						<tr>
						<td>AFI</td>
						
							<% if(usgSecondTrimFirstVisitList.size()>0){ %>
							  <td>
								<% 	for(OpdAntenatalUsg afiListSecondTrimFirstV : usgSecondTrimFirstVisitList ){
								if(afiListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("AFI")){
								%>
								<input type="text" value="<%=afiListSecondTrimFirstV.getUsgParameterValue1() !=null?afiListSecondTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />

								 <div class="clear"></div>
								<%} }%> 
								</td>
							
							<%} else { %>
							<td><input  type="text" id="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" />
							  <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivAfiTwins">
							 <input  type="text" id="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/>
							  </div>
								   
								   <%}else{ %> 
								    <div class="" style="display:none" id="dataDivAfiTwins">
							        <input  type="text" id="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/> 
							        </div>
								   
								   <%} %> 
								
								 <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivAfiTriplets">
							      <input  type="text" id="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/> 
							     </div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivAfiTriplets">
							      <input  type="text" id="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1"/> </div>
								 <%} %> 
								 
								 
							    </td>							
							<% usgSecondTrimFirstVisitIndex++;} %>
							
							<%if(usgSecondTrimSecondVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg afiListSecondTrimSecondV : usgSecondTrimSecondVisitList ){ 
									if(afiListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("AFI")){
								%>	
							    <input type="text" value="<%=afiListSecondTrimSecondV.getUsgParameterValue2() !=null?afiListSecondTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivAfiTwinsColTwo">
							     <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
							     <div class="" style="display:none" id="dataDivAfiTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input  type="text" id="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/>
						 	 <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivAfiTwinsColTwo">
							  <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivAfiTwinsColTwo">
							  <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						    <%} %> 
						 	  
						 	   <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivAfiTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivAfiTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/> </div>
						 	   <%} %> 
						 	     
						 	    
							  
							  </td>
							<% usgSecondTrimSecondVisitIndex++;} %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg afiListSecondTrimThirdV : usgSecondTrimThirdVisitList ){ 
									if(afiListSecondTrimThirdV.getUsgParameter().equalsIgnoreCase("AFI")){
								%>	
								<input type="text" value="<%=afiListSecondTrimThirdV.getUsgParameterValue3() !=null?afiListSecondTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivAfiTwinsColThree">
							     <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							     <div class="" style="display:none" id="dataDivAfiTripletsColThree">
							     <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input  type="text" id="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> 
						 	    <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivAfiTwinsColThree">
							  <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivAfiTwinsColThree">
							  <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%} %>
						 	       <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivAfiTripletsColThree">
							      <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivAfiTripletsColThree">
							     <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	      <%} %>
							
							  </td>
							<% usgSecondTrimThirdVisitIndex++; } %>
							</tr>
							
							<!-- ------- -->
						
						<tr>
						<td>Placenta</td>
						
							<% if(usgSecondTrimFirstVisitList.size()>0){ %>
							  <td>
								<%   
							for(OpdAntenatalUsg placentaListSecondTrimFirstV : usgSecondTrimFirstVisitList ){
								if(placentaListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("Placenta")){
								%>
								<input type="text" value="<%=placentaListSecondTrimFirstV.getUsgParameterValue1() !=null?placentaListSecondTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />

								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} else { %>
							<td><input  type="text" id="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" />
							  <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivPlacentaTwins">
							 <input  type="text" id="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" />
							  </div>
								   
								   <%}else{ %> 
								    <div class="" style="display:none" id="dataDivPlacentaTwins">
							        <input  type="text" id="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> 
							        </div>
								   
								   <%} %> 
								
								 <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivPlacentaTriplets">
							      <input  type="text" id="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> 
							     </div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivPlacentaTriplets">
							      <input  type="text" id="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> </div>
								 <%} %> 
								 
								 
							    </td>							
							<% usgSecondTrimFirstVisitIndex++;} %>
							
							<%if(usgSecondTrimSecondVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg placentaListSecondTrimSecondV : usgSecondTrimSecondVisitList ){
									if(placentaListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("Placenta")){
									%>	
							    <input type="text" value="<%=placentaListSecondTrimSecondV.getUsgParameterValue2() !=null?placentaListSecondTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								
								  <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivPlacentaTwinsColTwo">
							     <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /></div>
							     <div class="" style="display:none" id="dataDivPlacentaTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input  type="text" id="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" />
						 	 <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivPlacentaTwinsColTwo">
							  <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivPlacentaTwinsColTwo">
							  <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /></div>
						    <%} %> 
						 	  
						 	   <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivPlacentaTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivPlacentaTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /> </div>
						 	   <%} %> 
						 	     
						 	    
							  
							  </td>
							<% usgSecondTrimSecondVisitIndex++;} %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg placentaListSecondTrimThirdV : usgSecondTrimThirdVisitList ){
									if(placentaListSecondTrimThirdV.getUsgParameter().equalsIgnoreCase("Placenta")){
									%>	
								<input type="text" value="<%=placentaListSecondTrimThirdV.getUsgParameterValue3() !=null?placentaListSecondTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivPlacentaTwinsColThree">
							     <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							     <div class="" style="display:none" id="dataDivPlacentaTripletsColThree">
							     <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input  type="text" id="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> 
						 	    <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivPlacentaTwinsColThree">
							  <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivPlacentaTwinsColThree">
							  <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%} %>
						 	       <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivPlacentaTripletsColThree">
							      <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivPlacentaTripletsColThree">
							     <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	      <%} %>
							
							  </td>
							<% usgSecondTrimThirdVisitIndex++; } %>
							</tr>
							
							<!-- ------- -->
						
						<tr>
						<td>EBW</td>
						
							<% if(usgSecondTrimFirstVisitList.size()>0){ %>
							  <td>
								<%   
							for(OpdAntenatalUsg ebwListSecondTrimFirstV : usgSecondTrimFirstVisitList ){
								if(ebwListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("EBW")){
								%>
								<input type="text" value="<%=ebwListSecondTrimFirstV.getUsgParameterValue1() !=null?ebwListSecondTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />

								 <div class="clear"></div>
								<%}}%> 
								</td>
							
							<%} else { %>
							<td><input  type="text" id="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" />
							  <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivEbwTwins">
							 <input  type="text" id="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" />
							  </div>
								   
								   <%}else{ %> 
								    <div class="" style="display:none" id="dataDivEbwTwins">
							        <input  type="text" id="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> 
							        </div>
								   
								   <%} %> 
								
								 <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivEbwTriplets">
							      <input  type="text" id="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> 
							     </div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivEbwTriplets">
							      <input  type="text" id="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> </div>
								 <%} %> 
								 
								 
							    </td>							
							<% usgSecondTrimFirstVisitIndex++;} %>
							
							<%if(usgSecondTrimSecondVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg ebwListSecondTrimSecondV : usgSecondTrimSecondVisitList ){
									if(ebwListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("EBW")){
									%>	
							    <input type="text" value="<%=ebwListSecondTrimSecondV.getUsgParameterValue2() !=null?ebwListSecondTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivEbwTwinsColTwo">
							     <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
							     <div class="" style="display:none" id="dataDivEbwTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/> </div>
							<%} }%>
							</td>
							<%} else { %>
							   <td><input  type="text" id="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/>
						 	 <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivEbwTwinsColTwo">
							  <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivEbwTwinsColTwo">
							  <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						    <%} %> 
						 	  
						 	   <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivEbwTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivEbwTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/> </div>
						 	   <%} %> 
						 	     
						 	    
							  
							  </td>
							<% usgSecondTrimSecondVisitIndex++;} %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg ebwListSecondTrimThirdV : usgSecondTrimThirdVisitList ){
									if(ebwListSecondTrimThirdV.getUsgParameter().equalsIgnoreCase("EBW")){
									%>	
								<input type="text" value="<%=ebwListSecondTrimThirdV.getUsgParameterValue3() !=null?ebwListSecondTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivEbwTwinsColThree">
							     <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							     <div class="" style="display:none" id="dataDivEbwTripletsColThree">
							     <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							<%} }%>
							</td>
							<%} else { %>
							   <td><input  type="text" id="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> 
						 	    <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivEbwTwinsColThree">
							  <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivEbwTwinsColThree">
							  <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%} %>
						 	       <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivEbwTripletsColThree">
							      <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivEbwTripletsColThree">
							     <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	      <%} %>
							
							  </td>
							<% usgSecondTrimThirdVisitIndex++; } %>
							</tr>
							
							<!-- ------- -->
						
						<tr>
						<td>CX Length</td>
						
							<% if(usgSecondTrimFirstVisitList.size()>0){ %>
							  <td>
								<% for(OpdAntenatalUsg cxLengthListSecondTrimFirstV : usgSecondTrimFirstVisitList ){ 
								if(cxLengthListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("CX Length")){
							%>
								<input type="text" value="<%=cxLengthListSecondTrimFirstV.getUsgParameterValue1() !=null?cxLengthListSecondTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />

								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} else { %>
							<td><input  type="text" id="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="3" tabindex="1" onkeypress="javascript:return isNumber(event);"/>
							  <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivCxLengthTwins">
							 <input  type="text" id="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="3" tabindex="1" onkeypress="javascript:return isNumber(event);"/>
							  </div>
								   
								   <%}else{ %> 
								    <div class="" style="display:none" id="dataDivCxLengthTwins">
							        <input  type="text" id="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="3" tabindex="1" onkeypress="javascript:return isNumber(event);"/> 
							        </div>
								   
								   <%} %> 
								
								 <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivCxLengthTriplets">
							      <input  type="text" id="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="3" tabindex="1" onkeypress="javascript:return isNumber(event);"/> 
							     </div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivCxLengthTriplets">
							      <input  type="text" id="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="3" tabindex="1" onkeypress="javascript:return isNumber(event);"/> </div>
								 <%} %> 
								 
								 
							    </td>							
							<% usgSecondTrimFirstVisitIndex++;} %>
							
							<%if(usgSecondTrimSecondVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg cxLengthListSecondTrimSecondV : usgSecondTrimSecondVisitList ){
									if(cxLengthListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("CX Length")){
									%>	
							    <input type="text" value="<%=cxLengthListSecondTrimSecondV.getUsgParameterValue2() !=null?cxLengthListSecondTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  onkeypress="javascript:return isNumber(event);"/>
								
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivCxLengthTwinsColTwo">
							     <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="3" tabindex="2" onkeypress="javascript:return isNumber(event);"/></div>
							     <div class="" style="display:none" id="dataDivCxLengthTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="3" tabindex="2" onkeypress="javascript:return isNumber(event);"/> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input  type="text" id="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="3" tabindex="2" onkeypress="javascript:return isNumber(event);"/>
						 	 <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivCxLengthTwinsColTwo">
							  <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="3" tabindex="2" onkeypress="javascript:return isNumber(event);"/></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivCxLengthTwinsColTwo">
							  <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="3" tabindex="2" onkeypress="javascript:return isNumber(event);"/></div>
						    <%} %> 
						 	  
						 	   <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivCxLengthTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="3" tabindex="2" onkeypress="javascript:return isNumber(event);"/></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivCxLengthTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="3" tabindex="2" onkeypress="javascript:return isNumber(event);"/> </div>
						 	   <%} %> 
						 	     
						 	    
							  
							  </td>
							<% usgSecondTrimSecondVisitIndex++;} %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg cxLengthListSecondTrimThirdV : usgSecondTrimThirdVisitList ){
									if(cxLengthListSecondTrimThirdV.getUsgParameter().equalsIgnoreCase("CX Length")){
									%>	
								<input type="text" value="<%=cxLengthListSecondTrimThirdV.getUsgParameterValue3() !=null?cxLengthListSecondTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivCxLengthTwinsColThree">
							     <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="3" tabindex="3" onkeypress="javascript:return isNumber(event);"/> </div>
							     <div class="" style="display:none" id="dataDivCxLengthTripletsColThree">
							     <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="3" tabindex="3" onkeypress="javascript:return isNumber(event);"/></div>
							<%} }%>
							</td>
							<%} else { %>
							   <td><input  type="text" id="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="3" tabindex="3" onkeypress="javascript:return isNumber(event);"/> 
						 	    <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivCxLengthTwinsColThree">
							  <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="3" tabindex="3" onkeypress="javascript:return isNumber(event);"/> </div>
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivCxLengthTwinsColThree">
							  <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="3" tabindex="3" onkeypress="javascript:return isNumber(event);"/> </div>
						 	   <%} %>
						 	       <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivCxLengthTripletsColThree">
							      <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="3" tabindex="3" onkeypress="javascript:return isNumber(event);"/> </div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivCxLengthTripletsColThree">
							     <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="3" tabindex="3" onkeypress="javascript:return isNumber(event);"/></div>
						 	      <%} %>
							
							  </td>
							<% usgSecondTrimThirdVisitIndex++; } %>
							</tr>
							
							
							<!-- ------- -->
						
						<tr>
						<td>Anomalies</td>
						
							<% if(usgSecondTrimFirstVisitList.size()>0){ %>
							  <td>
								<% 
							for(OpdAntenatalUsg anomaliesListSecondTrimFirstV : usgSecondTrimFirstVisitList ){ 
								if(anomaliesListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("Anomalies")){
							%>
								<input type="text" value="<%=anomaliesListSecondTrimFirstV.getUsgParameterValue1() !=null?anomaliesListSecondTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />

								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} else { %>
							<td><input  type="text" id="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" />
							  <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivAnomaliesTwins">
							 <input  type="text" id="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" />
							  </div>
								   
								   <%}else{ %> 
								    <div class="" style="display:none" id="dataDivAnomaliesTwins">
							        <input  type="text" id="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> 
							        </div>
								   
								   <%} %> 
								
								 <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivAnomaliesTriplets">
							      <input  type="text" id="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> 
							     </div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivAnomaliesTriplets">
							      <input  type="text" id="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> </div>
								 <%} %> 
								 
								 
							    </td>							
							<% usgSecondTrimFirstVisitIndex++;} %>
							
							<%if(usgSecondTrimSecondVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg anomaliesListSecondTrimSecondV : usgSecondTrimSecondVisitList ){
									if(anomaliesListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("Anomalies")){
									%>	
							    <input type="text" value="<%=anomaliesListSecondTrimSecondV.getUsgParameterValue2() !=null?anomaliesListSecondTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								
								  <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivAnomaliesTwinsColTwo">
							      <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /></div>
							      <div class="" style="display:none" id="dataDivAnomaliesTripletsColTwo">
							      <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input  type="text" id="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" />
						 	 <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivAnomaliesTwinsColTwo">
							  <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivAnomaliesTwinsColTwo">
							  <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /></div>
						    <%} %> 
						 	  
						 	   <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivAnomaliesTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivAnomaliesTripletsColTwo">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2" /> </div>
						 	   <%} %> 
						 	     
						 	    
							  
							  </td>
							<% usgSecondTrimSecondVisitIndex++;} %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg anomaliesListSecondTrimThirdV : usgSecondTrimThirdVisitList ){ 
									if(anomaliesListSecondTrimThirdV.getUsgParameter().equalsIgnoreCase("Anomalies")){
								%>	
								<input type="text" value="<%=anomaliesListSecondTrimThirdV.getUsgParameterValue3() !=null?anomaliesListSecondTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivAnomaliesTwinsColThree">
							      <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							      <div class="" style="display:none" id="dataDivAnomaliesTripletsColThree">
							      <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/></div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input  type="text" id="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> 
						 	    <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivAnomaliesTwinsColThree">
							  <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivAnomaliesTwinsColThree">
							  <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%} %>
						 	       <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivAnomaliesTripletsColThree">
							      <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivAnomaliesTripletsColThree">
							     <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/></div>
						 	      <%} %>
							
							  </td>
							<% usgSecondTrimThirdVisitIndex++; } %>
							</tr>
							
							<!-- ------- -->
						
						<tr>
						<td>Impression</td>
						
							<% if(usgSecondTrimFirstVisitList.size()>0){ %>
							  <td>
								<% 
							for(OpdAntenatalUsg impressionListSecondTrimFirstV : usgSecondTrimFirstVisitList ){ 
								if(impressionListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("Impression")){
							%>
								<input type="text" value="<%=impressionListSecondTrimFirstV.getUsgParameterValue1() !=null?impressionListSecondTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />

								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} else { %>
							<td><input  type="text" id="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" />
							  <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivImpressionTwins2t">
							 <input  type="text" id="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" />
							  </div>
								   
								   <%}else{ %> 
								    <div class="" style="display:none" id="dataDivImpressionTwins2t">
							        <input  type="text" id="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> 
							        </div>
								   
								   <%} %> 
								
								 <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivImpressionTriplets2t">
							      <input  type="text" id="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> 
							     </div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivImpressionTriplets2t">
							      <input  type="text" id="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> </div>
								 <%} %> 
								 
								 
							    </td>							
							<% usgSecondTrimFirstVisitIndex++;} %>
							
							<%if(usgSecondTrimSecondVisitList.size()>0){%>
							  <td>
								<% 	for(OpdAntenatalUsg impressionListSecondTrimSecondV : usgSecondTrimSecondVisitList ){
									if(impressionListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("Impression")){
									%>	
							    <input type="text" value="<%=impressionListSecondTrimSecondV.getUsgParameterValue2() !=null?impressionListSecondTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								
								 <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivImpressionTwinsColTwo2t">
							      <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
							      <div class="" style="display:none" id="dataDivImpressionTripletsColTwo2t">
							      <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input  type="text" id="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/>
						 	 <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivImpressionTwinsColTwo2t">
							  <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivImpressionTwinsColTwo2t">
							  <input  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						    <%} %> 
						 	  
						 	   <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivImpressionTripletsColTwo2t">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivImpressionTripletsColTwo2t">
							     <input  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="128" tabindex="2"/> </div>
						 	   <%} %> 
						 	     
						 	    
							  
							  </td>
							<% usgSecondTrimSecondVisitIndex++;} %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg impressionListSecondTrimThirdV : usgSecondTrimThirdVisitList ){ 
									if(impressionListSecondTrimThirdV.getUsgParameter().equalsIgnoreCase("Impression")){
								%>	
								<input type="text" value="<%=impressionListSecondTrimThirdV.getUsgParameterValue3() !=null?impressionListSecondTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivImpressionTwinsColThree2t">
							      <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
							      <div class="" style="display:none" id="dataDivImpressionTripletsColThree2t">
							      <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/></div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input  type="text" id="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> 
						 	    <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivImpressionTwinsColThree2t">
							  <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivImpressionTwinsColThree2t">
							  <input  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	   <%} %>
						 	       <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivImpressionTripletsColThree2t">
							      <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/> </div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivImpressionTripletsColThree2t">
							     <input  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="128" tabindex="3"/></div>
						 	      <%} %>
							
							  </td>
							<% usgSecondTrimThirdVisitIndex++; } %>
							</tr>
							
							<!-- ------- -->
						
						<tr>
						<td>Remarks</td>
						
							<% if(usgSecondTrimFirstVisitList.size()>0){ %>
							  <td>
								<% for(OpdAntenatalUsg remarksListSecondTrimFirstV : usgSecondTrimFirstVisitList ){
									if(remarksListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("Remarks")){
									%>
								<textarea type="text" readonly="readonly" ><%=remarksListSecondTrimFirstV.getUsgParameterValue1() !=null?remarksListSecondTrimFirstV.getUsgParameterValue1():"" %></textarea>
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} else { %>
							<td><textarea type="text" name="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" id="usgSecondTrimFirstV<%=usgSecondTrimFirstVisitIndex%>" maxlength="256" value="" tabindex="1" ></textarea>
							  <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivRemarksTwins2t">
							       <textarea type="text" id="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="256" tabindex="1" ></textarea></div>
								   
								   <%}else{ %> 
								    <div class="" style="display:none" id="dataDivRemarksTwins2t">
							        <textarea type="text" id="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTwinsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="256" tabindex="1" ></textarea></div>
								   
								   <%} %> 
								
								 <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivRemarksTriplets2t">
							     <textarea  type="text" id="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="256" tabindex="1" ></textarea></div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivRemarksTriplets2t">
							     <textarea type="text" id="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" name="usgSecondTrimTripletsFirstV<%=usgSecondTrimFirstVisitIndex%>" value="" maxlength="256" tabindex="1" ></textarea></div>
								 <%} %> 
								 
								 
							    </td>							
							<% usgSecondTrimFirstVisitIndex++;} %>
							
							<%if(usgSecondTrimSecondVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg remarksListSecondTrimSecondV : usgSecondTrimSecondVisitList ){
									if(remarksListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("Remarks")){
									%>	
								<textarea type="text"  readonly="readonly" ><%=remarksListSecondTrimSecondV.getUsgParameterValue2() !=null?remarksListSecondTrimSecondV.getUsgParameterValue2():"" %></textarea>
								 <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivRemarksTwinsColTwo2t">
							     <textarea  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="256" tabindex="2"></textarea></div>
							     <div class="" style="display:none" id="dataDivRemarksTripletsColTwo2t">
							     <textarea  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="256" tabindex="2"></textarea> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><textarea type="text" name="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" id="usgSecondTrimSecondV<%=usgSecondTrimSecondVisitIndex%>" maxlength="256" tabindex="2"></textarea>
						 	 <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivRemarksTwinsColTwo2t">
							  <textarea  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="256" tabindex="2"></textarea></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivRemarksTwinsColTwo2t">
							  <textarea  type="text" id="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTwinsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="256" tabindex="2"></textarea></div>
						    <%} %> 
						 	  
						 	   <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivRemarksTripletsColTwo2t">
							     <textarea  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="256" tabindex="2"></textarea></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivRemarksTripletsColTwo2t">
							     <textarea  type="text" id="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" name="usgSecondTrimTripletsSecondV<%=usgSecondTrimSecondVisitIndex%>" value="" maxlength="256" tabindex="2"></textarea> </div>
						 	   <%} %> 
						 	     
						 	    
							  
							  </td>
							<% usgSecondTrimSecondVisitIndex++;} %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg remarksListSecondTrimThirdV : usgSecondTrimThirdVisitList ){
									if(remarksListSecondTrimThirdV.getUsgParameter().equalsIgnoreCase("Remarks")){
									%>	
								<textarea type="text" readonly="readonly"  ><%=remarksListSecondTrimThirdV.getUsgParameterValue3() !=null?remarksListSecondTrimThirdV.getUsgParameterValue3():"" %></textarea>
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivRemarksTwinsColThree2t">
							     <textarea  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="256" tabindex="3"></textarea></div>
							     <div class="" style="display:none" id="dataDivRemarksTripletsColThree2t">
							     <textarea  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="256" tabindex="3"></textarea> </div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><textarea type="text" name="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex %>" value="" id="usgSecondTrimThirdV<%=usgSecondTrimThirdVisitIndex %>" maxlength="256" tabindex="3"> </textarea>
						 	    <% if(usgSecondTrimFlag.equalsIgnoreCase("Twins") || usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivRemarksTwinsColThree2t">
							  <textarea  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="256" tabindex="3"></textarea></div>
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivRemarksTwinsColThree2t">
							  <textarea  type="text" id="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTwinsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="256" tabindex="3"></textarea></div>
						 	   <%} %>
						 	       <% if(usgSecondTrimFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivRemarksTripletsColThree2t">
							      <textarea  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="256" tabindex="3"></textarea></div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivRemarksTripletsColThree2t">
							     <textarea  type="text" id="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" name="usgSecondTrimTripletsThirdV<%=usgSecondTrimThirdVisitIndex%>" value="" maxlength="256" tabindex="3"></textarea> </div>
						 	      <%} %>
							
							  </td>
							<% usgSecondTrimThirdVisitIndex++; } %>
							</tr>
							   
						</table> 
						
			<div class="clear"></div>
			<%-- <label>Remarks</label>			
				<input type="text" name="usgSecondTrimRemarks" value="<%=usgThirdRemarks != null?usgThirdRemarks:"" %>" id="usgSecondTrimRemarks" class="large" maxlength="100" /> --%>		
		
		</div>
		</div>	 