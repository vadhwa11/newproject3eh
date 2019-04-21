<%@page import="jkt.hms.masters.business.NephrologyCaseSheet"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.NephrologyCaseSheet"%>

<% 
Map<String, Object> map = new HashMap<String, Object>();
NephrologyCaseSheet nephrologyCaseSheet = new NephrologyCaseSheet();
map = (Map) request.getAttribute("map");
if (map.size()>0) {
		
		 if (map.get("nephrologyCaseSheet") != null)
	       {
			 nephrologyCaseSheet = (NephrologyCaseSheet) map.get("nephrologyCaseSheet");			
	       }
		}
		 %>
<form  method="post" name="nephroCaseSheet">
<input id="nephroFlag" name="nephroFlag" tabindex="1" value="NephrologyCaseSheet" type="hidden"  />
<input type="hidden" name="templateName" value="Nephrology Case Sheet"/>
<!-- <input type="hidden" name="searchFlag" id="searchFlag" value="1"/> -->
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="Block">

<h6>NEPHROLOGY CASE SHEET</h6>
<div class="clear"></div>
<select>
<option value="review">Review</option>
<option value="new">New</option>
</select>

 <div class="clear"></div>
<%if(nephrologyCaseSheet.getChronicOnMhd()!=null){ %>
<input id="chronicOnMhd" name="chronicOnMhd" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkChronicOnMhd(this.value)">
<%}else{ %>
<input id="chronicOnMhd" name="chronicOnMhd" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkChronicOnMhd(this.value)">
<label>Chronic On MHD</label>
<% } %> 

<label class="auto">Sr.Creatinine</label>
<input class="textYellow allownumericwithoutdecimal textSmall" tabindex="1" name="srCreatinine"  onPaste="return false"  type="text" id="" onkeypress="javascript:return isNumber(event)" validate="Sr.Creatinine,float,yes" maxlength="6" value="" onblur="setSrCreatinine(this.value,'srCreatinine')" />
<label class="smallAuto">mg/dl</label>
<div class="clear"></div>

<%if(nephrologyCaseSheet.getChronicNotOnMhd()!=null){ %>
<input id="chronicNotOnMhd" name="chronicNotOnMhd" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkChronicNotOnMhd(this.value)">
<%}else{ %>
<input id="chronicNotOnMhd" name="chronicNotOnMhd" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkChronicNotOnMhd(this.value)">
<label>Chronic not On MHD</label>
<% } %> 
<div class="clear"></div>

<%if(nephrologyCaseSheet.getCapd()!=null){ %>
<input id="capd" name="capd" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkCapd(this.value)">
<%}else{ %>
<input id="capd" name="capd" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkCapd(this.value)">
<label>CAPD</label>
<% } %> 
<div class="clear"></div>

<%if(nephrologyCaseSheet.getTransplantation()!=null){ %>
<input id="transplantation" name="transplantation" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkTransplantation(this.value)">
<%}else{ %>
<input id="transplantation" name="transplantation" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkTransplantation(this.value)">
<label>Transplantation</label>
<% } %> 
<div class="clear"></div>

<h4 style="float:left; width:248px;">Presenting Illness:</h4>
<label style="background:none;box-shadow:none;">Duration</label>
<label style="background:none;box-shadow:none;">Details</label>

<div class="clear"></div>
 <label>Deranged RFT</label>
<%if(nephrologyCaseSheet.getDerangedRftDuration()!=null){ %>
<input id="derangedRft" name="derangedRft" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkDerangedRftDetails(this.value)">
<input id="derangedRftDuration" name="derangedRftDuration" value="<%=nephrologyCaseSheet.getDerangedRftDuration()%>" tabindex="1" validate="Deranged RFT,metachar,no" maxlength="32" type="text" class="duWi80" style="display: block" > 
<textarea id="derangedRftDetails" name="derangedRftDetails" value="<%=nephrologyCaseSheet.getDerangedRftDetails()%>" tabindex="1" validate="Deranged RFT,metachar,no" maxlength="256" type="text" class="medium w270" type="text" class="detldWi4" style="display: block" ></textarea>
<%}else{ %>
<input id="derangedRft" name="derangedRft" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkDerangedRftDetails(this.value)">
<input id="derangedRftDuration" name="derangedRftDuration" value="" tabindex="1" validate="Deranged RFT,metachar,no" maxlength="32" type="text" class="duWi80" style="display: none" > 
<textarea id="derangedRftDetails" name="derangedRftDetails" value="" tabindex="1" validate="Deranged RFT,metachar,no" maxlength="256" type="text" class="medium w270" type="text"  style="display: none" class="detldWi4" ></textarea>
<% } %> 
<div class="clear"></div>
<label style="background:none;box-shadow:none;"></label>
<div class="clear"></div>
<label style="background:none;box-shadow:none;">Edema:</label>
<div class="clear"></div>
<label>Facial</label>
<%if(nephrologyCaseSheet.getEdmaFacialDuration()!=null){ %>
<input id="edmaFacial" name="edmaFacial" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkEdmaFacialDetails(this.value)">
<input id="edmaFacialDuration" name="edmaFacialDuration" value="<%=nephrologyCaseSheet.getEdmaFacialDuration()%>" tabindex="1" validate="Facial,metachar,no" maxlength="32" type="text" style="display: block" > 
<textarea id="edmaFacialDetails" name="edmaFacialDetails" value="<%=nephrologyCaseSheet.getEdmaFacialDetails()%>" tabindex="1" validate="Facial,metachar,no" maxlength="256" type="text" class="medium w270" type="text"  style="display: block" ></textarea>
  
 <%}else{ %>
<input id="edmaFacial" name="edmaFacial" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkEdmaFacialDetails(this.value)">
<input id="edmaFacialDuration" name="edmaFacialDuration" value="" tabindex="1" validate="Facial,metachar,no" maxlength="32" type="text" style="display: none" > 
<textarea id="edmaFacialDetails" name="edmaFacialDetails" value="" tabindex="1" validate="Thigh Value,metachar,no" maxlength="256" type="text" class="medium w270" type="text"  style="display: none" ></textarea>
<% } %> 

<div class="clear"></div>
<label>Pedal</label>
<%if(nephrologyCaseSheet.getEdmaPedalDuration()!=null){ %>
<input id="edmaPedal" name="edmaPedal" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkEdmaPedalDetails(this.value)">
<input id="edmaPedalDuration" name="edmaPedalDuration" value="<%=nephrologyCaseSheet.getEdmaPedalDuration()%>" tabindex="1" validate="Pedal,metachar,no" maxlength="32" type="text" style="display: block" > 
<textarea id="edmaPedalDetails" name="edmaPedalDetails" value="<%=nephrologyCaseSheet.getEdmaPedalDetails()%>" tabindex="1" validate="Pedal,metachar,no" maxlength="256" type="text" class="medium w270" type="text"  style="display: block" ></textarea>
<%}else{ %>
<input id="edmaPedal" name="edmaPedal" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkEdmaPedalDetails(this.value)">
<input id="edmaPedalDuration" name="edmaPedalDuration" value="" tabindex="1" validate="Pedal,metachar,no" maxlength="32" type="text" style="display: none" > 
<textarea id="edmaPedalDetails" name="edmaPedalDetails" value="" tabindex="1" validate="Pedal,metachar,no" maxlength="256" type="text" class="medium w270" type="text"  style="display: none" ></textarea>
<% } %> 
<div class="clear"></div>

<label style="background:none;box-shadow:none;"></label>
<div class="clear"></div>
<label style="background:none;box-shadow:none;">Breathlessness:</label>
<div class="clear"></div>
<label>NHYA Class</label>
<select class="medium2">
<option>1</option>
<option>2</option>
<option>3</option>
<option>4</option>
</select>
<%if(nephrologyCaseSheet.getBreathlessnessNyhaClassDuration()!=null){ %>
<input id="breathlessnessNyhaClass" name="breathlessnessNyhaClass" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkBreathlessnessNyhaClassDetails(this.value)">
<input id="breathlessnessNyhaClassDuration" name="breathlessnessNyhaClassDuration" value="<%=nephrologyCaseSheet.getBreathlessnessNyhaClassDuration()%>" tabindex="1" validate="NHYA Class,metachar,no" maxlength="32" type="text" style="display: block" > 
<textarea id="breathlessnessNyhaClassDetails" name="breathlessnessNyhaClassDetails" value="<%=nephrologyCaseSheet.getBreathlessnessNyhaClassDetails()%>" tabindex="1" validate="NHYA Class,metachar,no" maxlength="256" type="text" class="medium w270" type="text"  style="display: block" ></textarea>
<%}else{ %>
<input id="breathlessnessNyhaClass" name="breathlessnessNyhaClass" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkBreathlessnessNyhaClassDetails(this.value)">
<input id="breathlessnessNyhaClassDuration" name="breathlessnessNyhaClassDuration" value="" tabindex="1" validate="NHYA Class,metachar,no" maxlength="32" type="text" style="display: none" > 
<textarea id="breathlessnessNyhaClassDetails" name="breathlessnessNyhaClassDetails" value="" tabindex="1" validate="NHYA Class,metachar,no" maxlength="256" type="text" class="medium w270" type="text"  style="display: none" ></textarea>
<% } %> 
<div class="clear"></div>

<%-- <label>Orthopnea</label>
<%if(nephrologyCaseSheet.getBreathlessnessN=null){ %>
<input id="breathlessnessNyhaClassOrthopnea" name="vomatingBloodVomitus" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkVomatingBloodVomitusDetails(this.value)">
<input id="vomatingBloodVomitusDuration" name="vomatingBloodVomitusDuration" value="<%=nephrologyCaseSheet.getBreathlessnessNyhaClassOrthopnea()%>" tabindex="1" validate="Orthopnea,metachar,no" maxlength="32" type="text" style="display: block" > 
<input id="vomatingBloodVomitusDetails" name="vomatingBloodVomitusDetails" value="<%=nephrologyCaseSheet.getBreathlessnessNyhaClassOrthopnea()%>" tabindex="1" validate="Orthopnea,metachar,no" maxlength="32" type="text"  style="display: block" >
<%}else{ %>
<input id="vomatingBloodVomitus" name="vomatingBloodVomitus" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkVomatingBloodVomitusDetails(this.value)">
<input id="vomatingBloodVomitusDuration" name="vomatingBloodVomitusDuration" value="<%=nephrologyCaseSheet.getVomatingBloodVomitusDetails()%>" tabindex="1" validate="Orthopnea,metachar,no" maxlength="32" type="text" style="display: none" > 
<input id="vomatingBloodVomitusDetails" name="vomatingBloodVomitusDetails" value="" tabindex="1" validate="Orthopnea,metachar,no" maxlength="32" type="text"  style="display: none" >
<% } %> 
<div class="clear"></div> --%>
 
<label style="background:none;box-shadow:none;"></label>
<div class="clear"></div>
<label style="background:none;box-shadow:none;">Vomiting:</label>
<div class="clear"></div>
<label>Blood in vomitus</label>
<%if(nephrologyCaseSheet.getVomatingBloodVomitusDuration()!=null){ %>
<input id="vomatingBloodVomitus" name="vomatingBloodVomitus" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkVomatingBloodVomitusDetails(this.value)">
<input id="vomatingBloodVomitusDuration" name="vomatingBloodVomitusDuration" value="<%=nephrologyCaseSheet.getVomatingBloodVomitusDuration()%>" tabindex="1" validate="Blood in vomituse,metachar,no" maxlength="32" type="text" style="display: block" > 
<textarea id="vomatingBloodVomitusDetails" name="vomatingBloodVomitusDetails" value="<%=nephrologyCaseSheet.getVomatingBloodVomitusDetails()%>" tabindex="1" validate="Blood in vomitus,metachar,no" maxlength="256" type="text" class="medium w270" type="text"  style="display: block" ></textarea>
<%}else{ %>
<input id="vomatingBloodVomitus" name="vomatingBloodVomitus" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkVomatingBloodVomitusDetails(this.value)">
<input id="vomatingBloodVomitusDuration" name="vomatingBloodVomitusDuration" value="" tabindex="1" validate="Coffee coloured,metachar,no" maxlength="32" type="text" style="display: none" >
<textarea id="vomatingBloodVomitusDetails" name="vomatingBloodVomitusDetails" value="" tabindex="1" validate="Blood in vomitus,metachar,no" maxlength="256" type="text" class="medium w270" type="text"  style="display: none" ></textarea>
<% } %> 
<div class="clear"></div>

<label>Bilious</label>
<%if(nephrologyCaseSheet.getVomatingBiliousDuration()!=null && nephrologyCaseSheet.getVomatingBiliousDetails()!=null){ %>
<input id="vomatingBilious" name="vomatingBilious" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkVomatingBiliousDetails(this.value)">
<input id="vomatingBiliousDuration" name="vomatingBiliousDuration" value="<%=nephrologyCaseSheet.getVomatingBiliousDuration()%>" tabindex="1" validate="Bilious Value,metachar,no" maxlength="32" type="text" style="display: block" > 
<textarea id="vomatingBiliousDetails" name="vomatingBiliousDetails" value="<%=nephrologyCaseSheet.getVomatingBiliousDetails()%>" tabindex="1" validate="Bilious Value,metachar,no" maxlength="256" type="text" class="medium w270" style="display: block" ></textarea>
<%}else{ %>
<input id="vomatingBilious" name="vomatingBilious" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkVomatingBiliousDetails(this.value)">
<input id="vomatingBiliousDuration" name="vomatingBiliousDuration" value="" tabindex="1" validate="thigh Type,metachar,no" maxlength="32" type="text" style="display: none" > 
<textarea id="vomatingBiliousDetails" name="vomatingBiliousDetails" value="" tabindex="1" validate="Bilious,metachar,no" maxlength="256" type="text" class="medium w270" style="display: none" ></textarea>
<% } %> 
 
<div class="clear"></div>
<label style="background:none;box-shadow:none;"></label>
<div class="clear"></div>
<label style="background:none;box-shadow:none;">Hematuria:</label>
<div class="clear"></div>
<label>Coffee coloured</label>
<%if(nephrologyCaseSheet.getHermaturiaCoffeeColouredDuration()!=null){ %>
<input id="hermaturiaCoffeeColoured" name="hermaturiaCoffeeColoured" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkHermaturiaCoffeeColouredDetails(this.value)">
<input id="hermaturiaCoffeeColouredDuration" name="hermaturiaCoffeeColouredDuration" value="<%=nephrologyCaseSheet.getHermaturiaCoffeeColouredDuration()%>" tabindex="1" validate="Coffee coloured Value,metachar,no" maxlength="32" type="text" style="display: block" > 
<textarea id="hermaturiaCoffeeColouredDetails" name="hermaturiaCoffeeColouredDetails" value="<%=nephrologyCaseSheet.getHermaturiaCoffeeColouredDetails()%>" tabindex="1" validate="Coffee coloured Value,metachar,no" maxlength="256" type="text" class="medium w270" type="text"  style="display: block" ></textarea>
<%}else{ %>
<input id="hermaturiaCoffeeColoured" name="hermaturiaCoffeeColoured" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkHermaturiaCoffeeColouredDetails(this.value)">
<input id="hermaturiaCoffeeColouredDuration" name="hermaturiaCoffeeColouredDuration" value="" tabindex="1" validate="Coffee coloured,metachar,no" maxlength="32" type="text" style="display: none" > 
<textarea id="hermaturiaCoffeeColouredDetails" name="hermaturiaCoffeeColouredDetails" value="" tabindex="1" validate="Coffee coloured Value,metachar,no" maxlength="256" type="text" class="medium w270" type="text"  style="display: none" ></textarea>
<% } %> 

<div class="clear"></div>
<!-- <label style="background:none;box-shadow:none;width:66px;"></label> -->
<label>Painful</label>
<%if(nephrologyCaseSheet.getHermaturiaPainfulDuration()!=null){ %>
<input id="hermaturiaPainful" name="hermaturiaPainfulDuration" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkHermaturiaPainfulDetails(this.value)">
<input id="hermaturiaPainfulDuration" name="hermaturiaPainfulDuration" value="<%=nephrologyCaseSheet.getHermaturiaPainfulDuration()%>" tabindex="1" validate="Painful Value,metachar,no" maxlength="32" type="text" style="display: block" > 
<textarea id="hermaturiaPainfulDetails" name="hermaturiaPainfulDetails" value="<%=nephrologyCaseSheet.getHermaturiaPainfulDetails()%>" tabindex="1" validate="Painful Value,metachar,no" maxlength="256" type="text" class="medium w270"   style="display: block" ></textarea>
<%}else{ %>
<input id="hermaturiaPainful" name="hermaturiaPainful" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkHermaturiaPainfulDetails(this.value)">
<input id="hermaturiaPainfulDuration" name="hermaturiaPainfulDuration" value="" tabindex="1" validate="Painful,metachar,no" maxlength="32" type="text" style="display: none" > 
<textarea id="hermaturiaPainfulDetails" name="hermaturiaPainfulDetails" value="" tabindex="1" validate="Painful Value,metachar,no" maxlength="256" type="text" class="medium w270" style="display: none" ></textarea>
<% } %> 
<div class="clear"></div>

<label style="background:none;box-shadow:none;"></label>
<div class="clear"></div>
<label>Frothing</label>
<%if(nephrologyCaseSheet.getFrothingDuraton()!=null && nephrologyCaseSheet.getFrothingDetails()!=null){ %>
<input id="frothing" name="frothing" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkFrothingDetails(this.value)">
<input id="frothingDuraton" name="frothingDuraton" value="<%=nephrologyCaseSheet.getFrothingDuraton()%>" tabindex="1" validate="Frothing Value,metachar,no" maxlength="32" type="text" style="display: block" > 
<textarea id="frothingDetails" name="frothingDetails" value="<%=nephrologyCaseSheet.getFrothingDetails()%>" tabindex="1" validate="Frothing Value,metachar,no" maxlength="256" type="text" class="medium w270" type="text"  style="display: block" ></textarea>
<%}else{ %>
<input id="frothing" name="frothing" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkFrothingDetails(this.value)">
<input id="frothingDuraton" name="frothingDuraton" value="" tabindex="1" validate="Frothing Type,metachar,no" maxlength="32" type="text" style="display: none" > 
<textarea id="frothingDetails" name="frothingDetails" value="" tabindex="1" validate="Frothing Value,metachar,no" maxlength="256" type="text" class="medium w270" type="text"  style="display: none" ></textarea>
<% } %>   
<div class="clear"></div>

<label>Oliguria</label>
<%if(nephrologyCaseSheet.getOliguriaDuration()!=null && nephrologyCaseSheet.getOliguriaDuration()!=null){ %>
<input id="oliguria" name="oliguria" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkOliguriaDetails(this.value)">
<input id="oliguriaDuration" name="oliguriaDuration" value="<%=nephrologyCaseSheet.getOliguriaDuration()%>" tabindex="1" validate="Oliguria Value,metachar,no" maxlength="32" type="text" style="display: block" > 
<textarea id="oliguriaDetails" name="oliguriaDetails" value="<%=nephrologyCaseSheet.getOliguriaDetails()%>" tabindex="1" validate="Oliguria Value,metachar,no" maxlength="256" type="text" class="medium w270" type="text"  style="display: block" ></textarea>
<%}else{ %>
<input id="oliguria" name="oliguria" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkOliguriaDetails(this.value)">
<input id="oliguriaDuration" name="oliguriaDuration" value="" tabindex="1" validate="Oliguria ,metachar,no" maxlength="32" type="text" style="display: none" > 
<textarea id="oliguriaDetails" name="oliguriaDetails" value="" tabindex="1" validate="Oliguria Value,metachar,no" maxlength="256" type="text" class="medium w270" type="text"  style="display: none" ></textarea>
<% } %> 
<div class="clear"></div>

<label>Dysuria</label>
<%if(nephrologyCaseSheet.getDysuriaDuration()!=null && nephrologyCaseSheet.getDysuriaDuration()!=null){ %>
<input id="dysuria" name="dysuria" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkDysuriaDetails(this.value)">
<input id="dysuriaDuration" name="dysuriaDuration" value="<%=nephrologyCaseSheet.getDysuriaDuration()%>" tabindex="1" validate="Dysuria,metachar,no" maxlength="32" type="text" style="display: block" >
<textarea id="dysuriaDetails" name="dysuriaDetails" value="<%=nephrologyCaseSheet.getDysuriaDetails()%>" tabindex="1" validate="Dysuria Value,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: block" ></textarea>
<%}else{ %>
<input id="dysuria" name="dysuria" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkDysuriaDetails(this.value)">
<input id="dysuriaDuration" name="dysuriaDuration" value="<%-- <%=nephrologyCaseSheet.getDysuriaDetails()%> --%>" tabindex="1" validate="Dysuria Type,metachar,no" maxlength="32" type="text" style="display: none" >
<textarea id="dysuriaDetails" name="dysuriaDetails" value="" tabindex="1" validate="Dysuria Value,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: none" ></textarea>
<% } %> 
<div class="clear"></div>

<label>Chest pain</label>
<%if(nephrologyCaseSheet.getChestPainDuration()!=null && nephrologyCaseSheet.getChestPainDuration()!=null){ %>
<input id="chestPain" name="chestPain" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkChestPainDetails(this.value)">
<input id="chestPainDuration" name="chestPainDuration" value="<%=nephrologyCaseSheet.getChestPainDuration()%>" tabindex="1" validate="Chest pain,metachar,no" maxlength="32" type="text" style="display: block" >
<textarea id="chestPainDetails" name="chestPainDetails" value="<%=nephrologyCaseSheet.getChestPainDetails()%>" tabindex="1" validate="Chest pain,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: block" ></textarea>
<%}else{ %>
<input id="chestPain" name="chestPain" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkChestPainDetails(this.value)">
<input id="chestPainDuration" name="chestPainDuration" value="" tabindex="1" validate="Chest pain,metachar,no" maxlength="32" type="text" style="display: none" >
<textarea id="chestPainDetails" name="chestPainDetails" value="" tabindex="1" validate="Chest pain,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: none" ></textarea>
<% } %> 
<div class="clear"></div>

<label>Abdominal pain</label>
<%if(nephrologyCaseSheet.getAbdominalPainDuration()!=null && nephrologyCaseSheet.getAbdominalPainDuration()!=null){ %>
<input id="abdominalPain" name="abdominalPain" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkAbdominalPainDetails(this.value)">
<input id="abdominalPainDuration" name="abdominalPainDuration" value="<%=nephrologyCaseSheet.getAbdominalPainDuration()%>" tabindex="1" validate="Abdominal pain,metachar,no" maxlength="32" type="text" style="display: block" >
<textarea id="abdominalPainDetails" name="abdominalPainDetails" value="<%=nephrologyCaseSheet.getAbdominalPainDetails()%>" tabindex="1" validate="Abdominal pain,metachar,no" maxlength="32" type="text" style="display: block" ></textarea>
<%}else{ %>
<input id="abdominalPain" name="abdominalPain" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkAbdominalPainDetails(this.value)">
<input id="abdominalPainDuration" name="abdominalPainDuration" value="" tabindex="1" validate="Abdominal pain,metachar,no" maxlength="32" type="text" style="display: none" >
<textarea id="abdominalPainDetails" name="abdominalPainDetails" value="" tabindex="1" validate="Abdominal pain,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: none" ></textarea>
<% } %>  
<div class="clear"></div>
<label style="background:none;box-shadow:none;"></label>
<div class="clear"></div>
<label style="background:none;box-shadow:none;">Fever:</label>
<div class="clear"></div>
<label>Intermittent</label>
<%if(nephrologyCaseSheet.getFeverIntermittentDuration()!=null && nephrologyCaseSheet.getFeverIntermittentDuration()!=null){ %>
<input id="feverIntermittent" name="feverIntermittent" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkFeverIntermittentDetails(this.value)">
<input id="feverIntermittentDuration" name="feverIntermittentDuration" value="<%=nephrologyCaseSheet.getFeverIntermittentDuration()%>" tabindex="1" validate="Intermittent,metachar,no" maxlength="32" type="text" style="display: block" >
<textarea id="feverIntermittentDetails" name="feverIntermittentDetails" value="<%=nephrologyCaseSheet.getFeverIntermittentDetails()%>" tabindex="1" validate="Intermittent,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: block" ></textarea>
<%}else{ %>
<input id="feverIntermittent" name="feverIntermittent" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkFeverIntermittentDetails(this.value)">
<input id="feverIntermittentDuration" name="feverIntermittentDuration" value="" tabindex="1" validate="Intermittent,metachar,no" maxlength="32" type="text" style="display: none" >
<textarea id="feverIntermittentDetails" name="feverIntermittentDetails" value="" tabindex="1" validate="Intermittent,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: none" ></textarea>
<% } %>  
<div class="clear"></div>

<label>Chills and Rigors</label>
<%if(nephrologyCaseSheet.getFeverChillsRigorsDuration()!=null && nephrologyCaseSheet.getFeverChillsRigorsDetails()!=null){ %>
<input id="feverChillsRigors" name="feverChillsRigors" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkFeverChillsRigorsDetails(this.value)">
<input id="feverChillsRigorsDuration" name="feverChillsRigorsDuration" value="<%=nephrologyCaseSheet.getFeverChillsRigorsDuration()%>" tabindex="1" validate="Chills and Rigors,metachar,no" maxlength="32" type="text" style="display: block" >
<textarea id="feverChillsRigorsDetails" name="feverChillsRigorsDetails" value="<%=nephrologyCaseSheet.getFeverChillsRigorsDetails()%>" tabindex="1" validate="Chills and Rigors,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: block" ></textarea>
<%}else{ %>
<input id="feverChillsRigors" name="feverChillsRigors" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkFeverChillsRigorsDetails(this.value)">
<input id="feverChillsRigorsDuration" name="feverChillsRigorsDuration" value="" tabindex="1" validate="Chills and Rigors,metachar,no" maxlength="32" type="text" style="display: none" >
<textarea id="feverChillsRigorsDetails" name="feverChillsRigorsDetails" value="" tabindex="1" validate="Chills and Rigors,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: none" ></textarea>
<% } %>  
<div class="clear"></div>
 <label style="background:none;box-shadow:none;"></label>
<div class="clear"></div>
 
<div class="clear"></div>
<label>Cough</label>
<%if(nephrologyCaseSheet.getCoughDuration()!=null && nephrologyCaseSheet.getCoughDetails()!=null){ %>
<input id="cough" name="cough" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkCoughDetails(this.value)">
<input id="coughDuration" name="coughDuration" value="<%=nephrologyCaseSheet.getCoughDuration()%>" tabindex="1" validate="Cough,metachar,no" maxlength="32" type="text" style="display: block" >
<textarea id="coughDetails" name="coughDetails" value="<%=nephrologyCaseSheet.getCoughDetails()%>" tabindex="1" validate="Cough,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: block" ></textarea>
<%}else{ %>
<input id="cough" name="cough" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkCoughDetails(this.value)">
<input id="coughDuration" name="coughDuration" value="" tabindex="1" validate="Cough,metachar,no" maxlength="32" type="text" style="display: none" >
<textarea id="coughDetails" name="coughDetails" value="" tabindex="1" validate="Cough,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: none" ></textarea>
<% } %>  
<div class="clear"></div>

<label>Hemoptysis</label>
<%if(nephrologyCaseSheet.getHemoptysisDuration()!=null && nephrologyCaseSheet.getHemoptysisDetails()!=null){ %>
<input id="hemoptysis" name="hemoptysis" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkhemoptysisDetails(this.value)">
<input id="hemoptysisDuration" name="hemoptysisDuration" value="<%=nephrologyCaseSheet.getHemoptysisDuration()%>" tabindex="1" validate="Hemoptysis,metachar,no" maxlength="32" type="text" style="display: block" >
<textarea id="hemoptysisDetails" name="hemoptysisDetails" value="<%=nephrologyCaseSheet.getHemoptysisDetails()%>" tabindex="1" validate="Hemoptysis,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: block" ></textarea>
<%}else{ %>
<input id="hemoptysis" name="hemoptysis" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkhemoptysisDetails(this.value)">
<input id="hemoptysisDuration" name="hemoptysisDuration" value="" tabindex="1" validate="ankle Type,metachar,no" maxlength="32" type="text" style="display: none" >
<textarea id="hemoptysisDetails" name="hemoptysisDetails" value="" tabindex="1" validate="Hemoptysis,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: none" ></textarea>
<% } %>  
<div class="clear"></div>

<label>Fitness Procedure</label>
<%if(nephrologyCaseSheet.getFitnessProcedureDuration()!=null && nephrologyCaseSheet.getFitnessProcedureDetails()!=null){ %>
<input id="fitnessProcedure" name="fitnessProcedure" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkfitnessProcedureDetails(this.value)">
<input id="fitnessProcedureDuration" name="FitnessProcedureDuration" value="<%=nephrologyCaseSheet.getFitnessProcedureDuration()%>" tabindex="1" validate="Fitness Procedure ,metachar,no" maxlength="32" type="text" style="display: block" >
<textarea id="fitnessProcedureDetails" name="fitnessProcedureDetails" value="<%=nephrologyCaseSheet.getFitnessProcedureDetails()%>" tabindex="1" validate="Fitness Procedure,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: block" ></textarea>
<%}else{ %>
<input id="fitnessProcedure" name="fitnessProcedure" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkfitnessProcedureDetails(this.value)">
<input id="fitnessProcedureDuration" name="fitnessProcedureDuration" value="" tabindex="1" validate="Fitness Procedure,metachar,no" maxlength="32" type="text" style="display: none" >
<textarea id="fitnessProcedureDetails" name="fitnessProcedureDetails" value="" tabindex="1" validate="Fitness Procedure,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: none" ></textarea>
<% } %>   
<div class="clear"></div>

<label>Pruritus</label>
<%if(nephrologyCaseSheet.getPruritusDuration()!=null && nephrologyCaseSheet.getPruritusDetails()!=null){ %>
<input id="pruritus" name="pruritusCkd" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkPruritusDetails(this.value)">
<input id=pruritusDuration name="pruritusDuration" value="<%=nephrologyCaseSheet.getCkdDuartion()%>" tabindex="1" validate="Pruritus,metachar,no" maxlength="32" type="text" style="display: block" >
<textarea id="pruritusDetails" name="pruritusDetails" value="<%=nephrologyCaseSheet.getPruritusDetails()%>" tabindex="1" validate="Pruritus,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: block" ></textarea>
<%}else{ %>
<input id="pruritus" name="pruritus" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkPruritusDetails(this.value)">
<input id="pruritusDuration" name="pruritusDuration" value="" tabindex="1" validate="Pruritus,metachar,no" maxlength="32" type="text" style="display: none" >
<textarea id="pruritusDetails" name="pruritusDetails" value="" tabindex="1" validate="Pruritus,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: none" ></textarea>
<% } %>  
<div class="clear"></div>

<label>CKD</label>
<%if(nephrologyCaseSheet.getCkdDuartion()!=null && nephrologyCaseSheet.getCkdDetails()!=null){ %>
<input id="ckd" name="ckd" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkCkdDetails(this.value)">
<input id="ckdDuration" name="ckdDuration" value="<%=nephrologyCaseSheet.getCkdDuartion()%>" tabindex="1" validate="CKD,metachar,no" maxlength="32" type="text" style="display: block" >
<textarea id="ckdDetails" name="ckdDetails" value="<%=nephrologyCaseSheet.getCkdDetails()%>" tabindex="1" validate="CKD,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: block" ></textarea>
<%}else{ %>
<input id="ckd" name="ckd" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkCkdDetails(this.value)">
<input id="ckdDuration" name="ckdDuration" value="" tabindex="1" validate="CKD,metachar,no" maxlength="32" type="text" style="display: none" >
<textarea id="ckdDetails" name="ckdDetails" value="" tabindex="1" validate="CKD,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: none" ></textarea>
<% } %>  
<div class="clear"></div>



<label>Head ache</label>
<%if(nephrologyCaseSheet.getHeadacheDuration()!=null && nephrologyCaseSheet.getHeadacheDuration()!=null){ %>
<input id="headache" name="headache" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkHeadacheDetails(this.value)">
<input id=headacheDuration name="headacheDuration" value="<%=nephrologyCaseSheet.getHeadacheDuration()%>" tabindex="1" validate="Head ache,metachar,no" maxlength="32" type="text" style="display: block" >
<textarea id="headacheDetails" name="headacheDetails" value="<%=nephrologyCaseSheet.getHeadacheDetails()%>" tabindex="1" validate="Head ache,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: block" ></textarea>
<%}else{ %>
<input id="headache" name="headache" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkHeadacheDetails(this.value)">
<input id="headacheDuration" name="headacheDuration" value="" tabindex="1" validate="Head ache,metachar,no" maxlength="32" type="text" style="display: none" >
<textarea id="headacheDetails" name="headacheDetails" value="" tabindex="1" validate="Head ache,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: none" ></textarea>
<% } %>  
<div class="clear"></div>

<label>Hypertension</label>
<%if(nephrologyCaseSheet.getHypertensionDuration()!=null && nephrologyCaseSheet.getHypertensionDetails()!=null){ %>
<input id="hypertension" name="hypertension" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkHypertensionDetails(this.value)">
<input id="hypertensionDuration" name="hypertensionDuration" value="<%=nephrologyCaseSheet.getHypertensionDuration()%>" tabindex="1" validate="Hypertension,metachar,no" maxlength="32" type="text" style="display: block" >
<textarea id="hypertensionDetails" name="hypertensionDetails" value="<%=nephrologyCaseSheet.getHypertensionDetails()%>" tabindex="1" validate="Hypertension,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: block" ></textarea>
<%}else{ %>
<input id="hypertension" name="hypertension" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkHypertensionDetails(this.value)">
<input id="hypertensionDuration" name="hypertensionDuration" value="" tabindex="1" validate="Hypertension,metachar,no" maxlength="32" type="text" style="display: none" >
<textarea id="hypertensionDetails" name="hypertensionDetails" value="" tabindex="1" validate="Hypertension,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: none" ></textarea>
<% } %>  
<div class="clear"></div>
<label style="background:none;box-shadow:none;"></label>
<div class="clear"></div>
<label style="background:none;box-shadow:none;">LUTS:</label>
<div class="clear"></div>
<div class="clear"></div>
<label>Frequency</label>
<%if(nephrologyCaseSheet.getLutsFrequencyDuration()!=null && nephrologyCaseSheet.getLutsFrequencyDetails()!=null){ %>
<input id="lutsFrequency" name="lutsFrequency" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkLutsFrequencyDetails(this.value)">
<input id="lutsFrequencyDuration" name="lutsFrequencyDuration" value="<%=nephrologyCaseSheet.getLutsFrequencyDuration()%>" tabindex="1" validate="Frequency,metachar,no" maxlength="32" type="text" style="display: block" >
<textarea id="lutsFrequencyDetails" name="lutsFrequencyDetails" value="<%=nephrologyCaseSheet.getLutsFrequencyDetails()%>" tabindex="1" validate="Frequency,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: block" ></textarea>
<%}else{ %>
<input id="lutsFrequency" name="lutsFrequency" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkLutsFrequencyDetails(this.value)">
<input id="lutsFrequencyDuration" name="lutsFrequencyDuration" value="" tabindex="1" validate="Frequency,metachar,no" maxlength="32" type="text" style="display: none" >
<textarea id="lutsFrequencyDetails" name="lutsFrequencyDetails" value="" tabindex="1" validate="Frequency,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: none" ></textarea>
<% } %>  
<div class="clear"></div>

<label>Urgency</label>
<%if(nephrologyCaseSheet.getLutsUrgencyDuration()!=null && nephrologyCaseSheet.getLutsUrgencyDetails()!=null){ %>
<input id="lutsUrgency" name="lutsUrgency" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkLutsUrgencyDetails(this.value)">
<input id="lutsUrgencyDuration" name="lutsUrgencyDuration" value="<%=nephrologyCaseSheet.getLutsUrgencyDuration()%>" tabindex="1" validate="Urgency,metachar,no" maxlength="32" type="text" style="display: block" >
<textarea id="lutsUrgencyDetails" name="lutsUrgencyDetails" value="<%=nephrologyCaseSheet.getLutsUrgencyDetails()%>" tabindex="1" validate="Urgency,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: block" ></textarea>
<%}else{ %>
<input id="lutsUrgency" name="lutsUrgency" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkLutsUrgencyDetails(this.value)">
<input id="lutsUrgencyDuration" name="lutsUrgencyDuration" value="" tabindex="1" validate="ankle Type,metachar,no" maxlength="32" type="text" style="display: none" >
<textarea id="lutsUrgencyDetails" name="lutsUrgencyDetails" value="" tabindex="1" validate="Urgency,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: none" ></textarea>
<% } %>  
<div class="clear"></div>

<label>Obstructed</label>
<%if(nephrologyCaseSheet.getLutsObstructedDuration()!=null && nephrologyCaseSheet.getLutsObstructedDetails()!=null){ %>
<input id="lutsObstructed" name="lutsObstructed" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkLutsObstructedDetails(this.value)">
<input id="lutsObstructedDuration" name="lutsObstructedDuration" value="<%=nephrologyCaseSheet.getLutsObstructedDuration()%>" tabindex="1" validate="Obstructed,metachar,no" maxlength="32" type="text" style="display: block" >
<textarea id="lutsObstructedDetails" name="lutsObstructedDetails" value="<%=nephrologyCaseSheet.getLutsObstructedDetails()%>" tabindex="1" validate="Obstructed,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: block" ></textarea>
<%}else{ %>
<input id="lutsObstructed" name="lutsObstructed" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkLutsObstructedDetails(this.value)">
<input id="lutsObstructedDuration" name="lutsObstructedDuration" value="" tabindex="1" validate="Obstructed,metachar,no" maxlength="32" type="text" style="display: none" >
<textarea id="lutsObstructedDetails" name="lutsObstructedDetails" value="" tabindex="1" validate="Ankle Value,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: none" ></textarea>
<% } %>  
<div class="clear"></div>

<label>Noctoria</label>
<%if(nephrologyCaseSheet.getLutsNocturiaDuration()!=null && nephrologyCaseSheet.getLutsNocturiaDetails()!=null){ %>
<input id="lutsNocturia" name="lutsNocturia" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkLutsNocturiaDetails(this.value)">
<input id="lutsNocturiaDuration" name="lutsNocturiaDuration" value="<%=nephrologyCaseSheet.getLutsNocturiaDuration()%>" tabindex="1" validate="Noctoria,metachar,no" maxlength="32" type="text" style="display: block" >
<textarea id="lutsNocturiaDetails" name="lutsNocturiaDetails" value="<%=nephrologyCaseSheet.getLutsNocturiaDetails()%>" tabindex="1" validate="Noctoria,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: block" ></textarea>
<%}else{ %>
<input id="lutsNocturia" name="lutsNocturia" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkLutsNocturiaDetails(this.value)">
<input id="lutsNocturiaDuration" name="lutsNocturiaDuration" value="" tabindex="1" validate="Noctoria,metachar,no" maxlength="32" type="text" style="display: none" >
<textarea id="lutsNocturiaDetails" name="lutsNocturiaDetails" value="" tabindex="1" validate="Noctoria,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: none" ></textarea>
<% } %>  
<div class="clear"></div>
<label style="background:none;box-shadow:none;"></label>
<div class="clear"></div>
<label>Lithuria</label>
<%if(nephrologyCaseSheet.getLithuriaDuration()!=null && nephrologyCaseSheet.getLithuriaDuration()!=null){ %>
<input id="lithuria" name="lithuria" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkLithuriaDetails(this.value)">
<input id="lithuriaDuration" name="getLithuriaDetails" value="<%=nephrologyCaseSheet.getLithuriaDuration()%>" tabindex="1" validate="Lithuria,metachar,no" maxlength="32" type="text" style="display: " >
<textarea id="lithuriaDetails" name="lithuriaDetails" value="<%=nephrologyCaseSheet.getLithuriaDetails()%>" tabindex="1" validate="Lithuria,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: block" ></textarea>
<%}else{ %>
<input id="lithuria" name="lithuria" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkLithuriaDetails(this.value)">
<input id="lithuriaDuration" name="lithuriaDuration" value="" tabindex="1" validate="Lithuria,metachar,no" maxlength="32" type="text" style="display: none" >
<textarea id="lithuriaDetails" name="lithuriaDetails" value="" tabindex="1" validate="Lithuria,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: none" ></textarea>
<% } %> 
<div class="clear"></div>
<label style="background:none;box-shadow:none;"></label>
<div class="clear"></div>

<label>Visual Symptoms</label>
<%if(nephrologyCaseSheet.getVisualSymptomsDuration()!=null && nephrologyCaseSheet.getVisualSymptomsDetails()!=null){ %>
<input id="visualSymptoms" name="visualSymptoms" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkVisualSymptomsDetails(this.value)">
<input id="visualSymptomsDuration" name="visualSymptomsDuration" value="<%=nephrologyCaseSheet.getVisualSymptomsDuration()%>" tabindex="1" validate="Visual Symptoms,metachar,no" maxlength="32" type="text" style="display: " >
<textarea id="visualSymptomsDetails" name="visualSymptomsDetails" value="<%=nephrologyCaseSheet.getVisualSymptomsDetails()%>" tabindex="1" validate="Visual Symptoms,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: block" ></textarea>
<%}else{ %>
<input id="visualSymptoms" name="visualSymptoms" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkVisualSymptomsDetails(this.value)">
<input id="visualSymptomsDuration" name="visualSymptomsDuration" value="" tabindex="1" validate="Visual Symptoms,metachar,no" maxlength="32" type="text" style="display: none" >
<textarea id="visualSymptomsDetails" name="visualSymptomsDetails" value="" tabindex="1" validate="Visual Symptoms,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: none" ></textarea>
<% } %> 
<div class="clear"></div>
<label style="background:none;box-shadow:none;"></label>
<div class="clear"></div>
<label>Others</label>
<select id="Others" name="Others" tabindex="1" multiple="multiple" size="3" class="multiple" style="height:110px; validate="Others,string,no" >

<option value="Diabetes Mellitus">Diabetes Mellitus</option>
<option value="Hypertension">Hypertension</option>
<option value="Nephrolithiasis">Nephrolithiasis</option>
<option value="Glomerulonephritis">Glomerulonephritis</option>
<option value="Claudication">Claudication</option>
<option value="Parasthesia">Parasthesia</option>
</select>
<label>Remarks</label>
<textarea rows="" cols="" name ="presentingIllnessOthersRemark" maxlength="256" class="medium w270"></textarea>
<div class="clear"></div>
<label style="background:none;box-shadow:none;"></label>
<div class="clear"></div>
<h4>Past History:</h4>
<select id="pastHistory" name="pastHistory" tabindex="1" multiple="multiple" size="3" class="multiple" style="height:110px; validate="Service Center,string,no">

<option value="CAD">CAD</option>
<option value="CAD">CVA</option>
<option value="TB">TB</option>
<option value="Jaundice">Jaundice</option>
<option value="CAD">Calculi</option>
<option value="Surgical Procedures">Surgical Procedures</option>
<option value="COPD">COPD</option>
<option value="Recruitment UTI">Recruitment UTI</option>
<option value="Others">Others</option>
</select>

<label>Remarks</label>
<textarea rows="" cols="" name ="pastHistoryRemark" maxlength="256" class="medium w270"></textarea>
<div class="clear"></div>
<label style="background:none;box-shadow:none;"></label>
<div class="clear"></div>
<h4>Personal History:</h4>
<select id="personalHistory" name="personalHistory" tabindex="1" multiple="multiple" size="3" class="multiple" style="height:110px; validate="Service Center,string,no">
<
<option value="Smoker">Smoker</option>
<option value="Alcholic">Alcholic</option>
<option value="Sleep">Sleep</option>
<option value="Appetite">Appetite</option>
<option value="Bowel habits">Bowel habits</option>
<option value="Bladder Habits">Bladder Habits</option>
</select>
<label>Remarks</label>
<textarea rows="" cols="" name ="remarksPersonalHistory" maxlength="256" class="medium w270"></textarea>
<label style="background:none;box-shadow:none;"></label>
<div class="clear"></div>

<div class="clear"></div>


<h4>Family History:</h4>
<label>Chronic Kidney Disease</label>
<%if(nephrologyCaseSheet.getFamilyHistoryChronicKidenyDisease()!=null){ %>
<input id="familyHistoryChronicKidenyDisease" name="familyHistoryChronicKidenyDisease" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkfamilyHistoryChronicKidenyDiseaseValue(this.value)">

<div id="familyHistoryChronicKidenyDiseaseDiv" style="display: block">
<select id="familyHistoryChronicKidenyDiseaseType" name="familyHistoryChronicKidenyDiseaseType" tabindex="1" validate="Chronic Kidney Disease,metachar,no"  multiple="multiple"  class="multiple"  >
<option value="0" disabled="disabled">Select</option>
<option <%= nephrologyCaseSheet.getFamilyHistoryChronicKidenyDisease().contains("Diabetic Nephropathy")?"selected='selected'":"" %>>Diabetic Nephropathy</option>
<option <%= nephrologyCaseSheet.getFamilyHistoryChronicKidenyDisease().contains("ADPKD")?"selected='selected'":"" %>>ADPKD</option>
<option <%= nephrologyCaseSheet.getFamilyHistoryChronicKidenyDisease().contains("Stone Disease")?"selected='selected'":"" %>>Stone Disease</option>
<option <%= nephrologyCaseSheet.getFamilyHistoryChronicKidenyDisease().contains("Miscellaneous")?"selected='selected'":"" %>>Miscellaneous</option>
</select>
<input id="familyHistoryChronicKidneyDiseaseRemarkValue" name="familyHistoryChronicKidneyDiseaseRemarkValue" value="<%=nephrologyCaseSheet.getFamilyHistoryChronicKidneyDiseaseRemark()!=null?nephrologyCaseSheet.getFamilyHistoryChronicKidneyDiseaseRemark():"" %>" tabindex="1" validate="Chronic Kidney Disease Value,metachar,no" maxlength="32" type="text" >
</div>
<%}else{ %>
<input id="familyHistoryChronicKidenyDisease" name="familyHistoryChronicKidenyDisease" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkfamilyHistoryChronicKidenyDiseaseValue(this.value)">

<div id="familyHistoryChronicKidenyDiseaseDiv" style="display: none">
<select id="familyHistoryChronicKidenyDiseaseType" name="familyHistoryChronicKidenyDiseaseType" tabindex="1" validate="Chronic Kidney Disease,metachar,no"  multiple="multiple" class="multiple"  >
<option value="0" disabled="disabled">Select</option>
<option value="Diabetic Nephropathy">Diabetic Nephropathy</option>
<option value="ADPKD">ADPKD</option>
<option value="Stone Disease">Stone Disease</option>
<option value="Miscellaneous">Miscellaneous</option>
</select>
</div>
<% } %> 
 
<label>Remarks</label>
<textarea rows="" cols="" name ="remarksFamilyHistory" maxlength="256" class="medium w270"></textarea>  
<div class="clear"></div>
<label style="background:none;box-shadow:none;"></label>
<div class="clear"></div>
<label>Chronic Liver Disease </label>
<input id="cld" name="cld" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin">
<div class="clear"></div>
<label style="background:none;box-shadow:none;"></label>
<div class="clear"></div>
 <h4>Menstural History:</h4>
<div class="clear"></div>
<label>Menorrhagia</label>
<%if(nephrologyCaseSheet.getMenorrhagiaRemarks()!=null){ %>
<input id="menorrhagia" name="Menorrhagia" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkMenorrhagiaRemarks(this.value)">
<textarea id="menorrhagiaRemarks" name="menorrhagiaRemarks" value="<%=nephrologyCaseSheet.getMenorrhagiaRemarks()%>" tabindex="1" validate="Menorrhagia,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: block" ></textarea>
<%}else{ %>
<input id="menorrhagia" name="menorrhagia" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkMenorrhagiaRemarks(this.value)">
<textarea id="menorrhagiaRemarks" name="menorrhagiaRemarks" value="" tabindex="1" validate="Menorrhagia,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: none" ></textarea>
<% } %> 
<div class="clear"></div> 

<label>Dysmenorrhea</label>
<%if(nephrologyCaseSheet.getDysmenorrheaRemarks()!=null){ %>
<input id="dysmenorrhea" name="dysmenorrhea" tabindex="1" value="y" checked="checked" type="checkbox" class="checkboxMargin" onclick="checkDysmenorrheaRemarks(this.value)">
<textarea id="dysmenorrheaRemarks" name="dysmenorrheaRemarks" value="<%=nephrologyCaseSheet.getDysmenorrheaRemarks()%>" tabindex="1" validate="Dysmenorrhea,metachar,no" maxlength="256" class="medium w270" type="text" style="display: block" ></textarea>
<%}else{ %>
<input id="dysmenorrhea" name="dysmenorrhea" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkDysmenorrheaRemarks(this.value)">
<textarea id="dysmenorrheaRemarks" name="dysmenorrheaRemarks" value="" tabindex="1" validate="Dysmenorrhea,metachar,no" maxlength="256" class="medium w270" type="text" style="display: none" ></textarea>
<% } %>
<label style="background:none;box-shadow:none;"></label>
<div class="clear"></div>
<label style="background:none;box-shadow:none;"></label>
<div class="clear"></div>
<div class="clear"></div> 
<h4>Physical Examination:</h4>
<label style="width:50px;">Height</label>
<input class="textYellow allownumericwithoutdecimal textSmall" tabindex="11" name="heightNephro" onPaste="return false" type="text" id="" onkeypress="javascript:return isNumber(event)" maxlength="6" value="" onblur="" />
<label class="smallAuto">cm</label>

<label style="width:50px;">Weight</label>
<input class="textYellow allownumericwithoutdecimal textSmall" tabindex="11" name="weightNephro" onPaste="return false" type="text" id="" onkeypress="javascript:return isNumber(event)" maxlength="6" value="" onblur="" />
<label class="smallAuto">Kg</label>

<label style="width:50px;">BMI</label>
<input class="textYellow allownumericwithoutdecimal textSmall" tabindex="11" name="bmiNephro" onPaste="return false" type="text" id="" onkeypress="javascript:return isNumber(event)" maxlength="6" value="" onblur="" />

<label>Waist Circumference</label>
<input class="textYellow allownumericwithoutdecimal textSmall" tabindex="11" name="waistCircum" onPaste="return false" type="text" id="" onkeypress="javascript:return isNumber(event)" maxlength="6" value="" onblur="" />
<label class="smallAuto">cm</label>

<div class="clear"></div> 
<label style="width:50px;" id="bpLabel">BP</label>
<input name="bpNephro" id="" tabindex="14" placeholder="" validate="BP,int,no" onkeypress="javascript:return isNumber(event)" onPaste="return false" type="text" maxlength="6" 
class="textYellow allownumericwithoutdecimal textSmall" onblur="setBp(this.value,'systolic')"/>
<label id="bpLabel" class="smallAuto"><span style="color: black">/</span></label>
<input name="bpNephro" id="" tabindex="15" placeholder="" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)" maxlength="6"
class="textYellow allownumericwithoutdecimal textSmall" onblur="setBp(this.value,'diastolic')" />
<label class="smallAuto">mm&nbsp;Hg</label>

<label style="width:50px;">Pulse</label>
<input class="textYellow allownumericwithoutdecimal textSmall" onPaste="return false" tabindex="11" name="" type="text" id="" onkeypress="javascript:return isNumber(event)" maxlength="6" value="" onblur="" />
<label class="smallAuto">/min</label>

<label class="auto">Temperature</label>
<input class="textYellow allownumericwithdecimal textSmall"	name= "temperatureNephro" id="temperatureTemp" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)" maxlength="6" tabindex="12" onblur=""/>
<label class="smallAuto">&deg;F</label> 

<label class="auto">Respiratory Rate</label>
<input class="textYellow allownumericwithdecimal textSmall" name="respiratoryRateTemp" id="respiratoryRateTemp" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)" maxlength="6" validate="Respiratory Rate,float,no"  tabindex="12" onblur="" />		
<label class="smallAuto">/min</label> 
<label style="width:50px;">Spo2</label>
<input class="textYellow allownumericwithdecimal textSmall" name="spo2Temp" id="spo2Temp" type="text" onPaste="return false"  maxlength="6" validate="spo2,float,no" tabindex="12" onblur=""/>
<div class="clear"></div>	
<label style="background:none;box-shadow:none;"></label>
<div class="clear"></div>
<label>Anemia</label>
<input id="cld" name="anamia" tabindex="1" value="y" type="checkbox" checked="" class="checkboxMargin">

<label>Cyanosis</label>
<input id="cld" name="cyanosis" tabindex="1" value="y" type="checkbox" checked="" class="checkboxMargin">

<label>Jaundice</label>
<input id="cld" name="jaundice" tabindex="1" value="y" type="checkbox" checked="" class="checkboxMargin">
<div class="clear"></div>
<label>Clubbing</label>
<input id="cld" name="clubbing" tabindex="1" value="y" type="checkbox" checked="" class="checkboxMargin">

<label>Edema</label>
<input id="cld" name="edema" tabindex="1" value="y" type="checkbox" checked="" class="checkboxMargin">

<div class="clear"></div>
 <label>Lymhadenopathy</label>
<%if(nephrologyCaseSheet.getLymphadenopathy()!=null){ %>
<input id="lymphadenopathy" name="lymphadenopathy" tabindex="1" value="y" checked="checked" type="checkbox" class="checkboxMargin" onclick="checkLymphadenopathy(this.value)">
<textarea id="lymphadenopathyValue" name="lymphadenopathyValue" value="<%=nephrologyCaseSheet.getLymphadenopathy()%>" tabindex="1" validate="Lymhadenopathy,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: block" ></textarea>
<%}else{ %>
<input id="lymphadenopathy" name="lymphadenopathy" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkLymphadenopathy(this.value)">
<textarea id="lymphadenopathyValue" name="lymphadenopathyValue" value="" tabindex="1" validate="Lymhadenopathy,metachar,no" maxlength="256" type="text" class="medium w270" type="text" style="display: none" ></textarea>
<% } %> 

<div class="clear"></div>
<label style="background:none;box-shadow:none;"></label>
<div class="clear"></div>

  <label>JVP:</label>
<select class="medium2">
<option>Normal</option>
<option>Raised</option>
</select>
<%if(nephrologyCaseSheet.getJvp()!=null){ %>
<input id="jvpcheckbox" name="jvpcheckbox" tabindex="1" value="y" type="checkbox" checked="checked" class="checkboxMargin" onclick="checkJvpRaised(this.value)">
<input id="jvp" name="jvp" value="<%=nephrologyCaseSheet.getJvp()%>" tabindex="1" validate="JVP,metachar,no" maxlength="32" type="text" style="display: block" > 
<textarea id="jvpRaised" name="jvpRaised" value="<%=nephrologyCaseSheet.getJvpRaised()%>" tabindex="1" validate="JVP,metachar,no" maxlength="256" type="text" class="medium w270" type="text"  style="display: block" ></textarea>
<%}else{ %>
<input id="jvpcheckbox" name="jvpcheckbox" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkJvpRaised(this.value)">
<input id="jvp" name="jvp" value="<%-- <%=nephrologyCaseSheet.getEdmaPedalDuration()%> --%>" tabindex="1" validate="JVP,metachar,no" maxlength="32" type="text" style="display: none" > 
<textarea id="jvpRaised" name="jvpRaised" value="" tabindex="1" validate="JVP,metachar,no" maxlength="256" type="text" class="medium w270" type="text"  style="display: none" ></textarea>
<% } %> 
<div class="clear"></div>  
		<label style="background:none;box-shadow:none;"></label>
<div class="clear"></div>

<label>Chest</label>
<select id="Chest" name="chest" tabindex="1" multiple="multiple" size="3" class="multiple" >

<option value="Clear">Clear</option>
<option value="Crepts">Crepts</option>
<option value="Rhonchi">Rhonchi</option>
</select>
<label>Remarks</label>
<textarea rows="" cols="" name ="remarksFamilyHistory" maxlength="256" class="medium w270"></textarea>
<div class="clear"></div>	
<label style="background:none;box-shadow:none;"></label>
<div class="clear"></div>
<label>CVS</label>
<select id="CVS" name="cvs" tabindex="1" multiple="multiple" size="3" class="multiple" >
<option value="S1">S1</option>
<option value="S2">S2</option>
<option value="S3">S3</option>
<option value="S4">S4</option>
<option value="S3">Murmur</option>
<option value="S4">Rub</option>
</select>
<label>Remarks</label>
<textarea rows="" cols="" name ="remarksFamilyHistory" maxlength="256" class="medium w270"></textarea>
<div class="clear"></div>	
<label style="background:none;box-shadow:none;"></label>
<div class="clear"></div>
<label>PA</label>
<select id="CVS" name="pA" tabindex="1" multiple="multiple" size="3" class="multiple" >

<option value="Soft">Soft</option>
<option value="S2">Kidneys Palpable</option>
<option value="Ascitis">Ascitis</option>
<option value="S4">Reneral Bruit</option>
</Select>

<label>Remarks</label>
<textarea rows="" cols="" name ="remarksFamilyHistory" maxlength="256" class="medium w270"></textarea>
<div class="clear"></div>	
<label style="background:none;box-shadow:none;"></label>
<div class="clear"></div>
<label>Optic funds:</label>
<textarea rows="" cols="" name ="remarksFamilyHistory" maxlength="256" class="medium w270"></textarea>
<div class="clear"></div>	
<label style="background:none;box-shadow:none;"></label>
<div class="clear"></div>
<label>CNS findings:</label>
<textarea rows="" cols="" name ="remarksFamilyHistory" maxlength="256" class="medium w270"></textarea>

<div class="clear"></div>	
<label style="background:none;box-shadow:none;"></label>
<div class="clear"></div>
<label>Others:</label>
<textarea rows="" cols="" name ="remarksFamilyHistory" maxlength="256" class="medium w270"></textarea>
</div>
</form>