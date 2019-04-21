<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.OpdAntenatalCardPregnancy"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.OpdInstructionTreatment"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.RouteOfAdministration"%>
<%@page import="jkt.hms.masters.business.OpdTemplateTreatment"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@ page import="static jkt.hms.util.RequestConstants.BLOOD_TRANSFUSION"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="static jkt.hms.util.RequestConstants.PREGNANCY_OUTCOME"%>
<%@page import="static jkt.hms.util.RequestConstants.AGE_UNIT"%>
<%@page import="static jkt.hms.util.RequestConstants.DELIVERY_OUTCOME"%>
<%@page import="static jkt.hms.util.RequestConstants.PLACE_OF_DELIVERY"%>
<%@page import="static jkt.hms.util.RequestConstants.BIRTH_WEIGHT"%>
<%@page import="static jkt.hms.util.RequestConstants.SEX"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}

int counter = 0;
int i=0;
String displayOnly =null;
int prevTotal=0;
boolean existsCounter = false;
Map<Integer, OpdAntenatalCardPregnancy> prevPregnancyDt = null;
if(map.get("counter")!=null){
	counter = (Integer)map.get("counter");
}
if(map.get("prevTotal")!=null){
	prevTotal = (Integer)map.get("prevTotal");
}
if(map.get("existsCounter")!=null){
	existsCounter = (Boolean)map.get("existsCounter");
}
if(map.get("prevPregnancyDt")!=null){
	prevPregnancyDt = (Map<Integer, OpdAntenatalCardPregnancy>)map.get("prevPregnancyDt");
}
if(map.get("displayOnly")!=null && map.get("displayOnly").equals("y")){
	displayOnly = (String)map.get("displayOnly");
}
OpdAntenatalCardPregnancy antenatalCard =null;
List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
if (map.get("sexList") != null)
{
        sexList = (List<MasAdministrativeSex>) map.get("sexList");
}
%>


						<div id="divTemplet2">
						<div class="clear"></div>
						<%---Start preg dt --%>
				<div class="tableForTab fixedWidth900">
						<%for (Map.Entry<Integer, OpdAntenatalCardPregnancy> prevPreg : prevPregnancyDt.entrySet())
								{
								  antenatalCard = prevPreg.getValue();
									%>
								  	 <p>
								  	  <b>Pregnancy No:</b><%=antenatalCard.getNoOfPregnancy()%>
									   <b>Age of Mother:</b><%=antenatalCard.getAge()%>Yrs 
									   
									   <%if(antenatalCard.getPregnancyOutcome()!=null && !antenatalCard.getPregnancyOutcome().isEmpty()){%> 
									   <b>Pregnancy Outcome:</b><%=antenatalCard.getPregnancyOutcome()%>
									   <%}%>
									   
									   <%if(antenatalCard.getPregnancyOutcomePreTermValue()!=null && !antenatalCard.getPregnancyOutcomePreTermValue().isEmpty()){%> 
									   <b>Pre Term Remarks:</b><%=antenatalCard.getPregnancyOutcomePreTermValue()%>
									   <%}%>
									  <%if(antenatalCard.getPlaceDelivery()!=null && !antenatalCard.getPlaceDelivery().isEmpty()){%>
									   <b>Place of Outcome:</b> <%=antenatalCard.getPlaceDelivery()%> 
									  <%}%>
									  
									  <%if(antenatalCard.getDeliveryOutcome()!=null && !antenatalCard.getDeliveryOutcome().isEmpty()){%>
										 <b>Delivery Outcome:</b> <%=antenatalCard.getDeliveryOutcome()%> 
										<%}%>
										
										<%if(antenatalCard.getSex()!=null && !antenatalCard.getSex().isEmpty()){%>
										 <b>Gender:</b>
										<%if(!antenatalCard.getSex().isEmpty()){for (MasAdministrativeSex masAdministrativeSex : sexList) {
											if(masAdministrativeSex.getId()==Integer.parseInt(antenatalCard.getSex())){%>
										<%=masAdministrativeSex.getAdministrativeSexName()%> 		
											
											<%break;}
										}}%>
										<%}%>
										
										<%if(antenatalCard.getPreviousGestationalAge()!=null && !antenatalCard.getPreviousGestationalAge().isEmpty()){%>
										 <b>GA:</b> <%=antenatalCard.getPreviousGestationalAge()%>
										in Weeks: <%}%>
										
										<%if(antenatalCard.getBirthWeight()!=null && antenatalCard.getBirthWeight()!=0.0){%>
										 <b>Birth Weight:</b> <%=antenatalCard.getBirthWeight()%> kg
										<%}%>
										
										<%if(antenatalCard.getBloodTransfusion()!=null && !antenatalCard.getBloodTransfusion().isEmpty()){%>
										 <b>Blood Transfusion:</b> <%=antenatalCard.getBloodTransfusion()%>
										<%}%>
										
										<%if(antenatalCard.getAntenatal()!=null && !antenatalCard.getAntenatal().isEmpty()){%>
										 <b>Antenatal:</b> <%=antenatalCard.getAntenatal()%> 
										<%}%>
										<%if(antenatalCard.getIntraPartum()!=null && !antenatalCard.getIntraPartum().isEmpty()){%>
										  <b>Intra Partum:</b> <%=antenatalCard.getIntraPartum()%> 
										 <%}%>
										 <%if(antenatalCard.getPostPartum()!=null && !antenatalCard.getPostPartum().isEmpty()){%>
										 <b> Post Partum:</b> <%=antenatalCard.getPostPartum()%> 
										 <%}%>
										 <%if(antenatalCard.getRemarks()!=null && !antenatalCard.getRemarks().isEmpty()){%>
										 <b>Remarks:</b> <%=antenatalCard.getRemarks()%>
										<%}%>
										</p>
										
										<div class="clear"></div>
										<div class="divisionSolid"></div>
								        <div class="clear"></div>
								<%i++;}%>
						</div>
						<div class="clear"></div>
						<div class="clear"></div>
						<%
						OpdAntenatalCardPregnancy prevantenatalCard = null;
						if(existsCounter)
							prevantenatalCard = prevPregnancyDt.get(counter);
						/* if(prevPregnancyDt.get(counter+1)==null)
							counter = counter++; */
							%>
						<label  class="medium">Mother</label> 
						<%-- <label class="auto bgNone">Pregnancy No.</label> 
						<label class="auto"><%=counter+1%> <input type="hidden" name="noOfPregnancy" id="noOfPregnancy" value="<%=counter+1%>"> </label>   
						 --%>
						<label class="auto bgNone">Pregnancy No.</label> 
						<label ><input type="text" size=2 maxlength="2" name="noOfPregnancy" id="noOfPregnancy" value="<%=counter+1%>" onkeypress="javascript:return isNumber(event)" style="width: 20px;height:20px;"></label>   
						
						<label class="auto bgNone">Age of Mother</label> 
						  <input id="<%=AGE_UNIT%>"  onblur="checkMotherPreviousPregnancyAge(this.value,this.id);" name="<%=AGE_UNIT%>" type="text" size=3 onkeypress="javascript:return isNumber(event)" validate="Age,num,no"  maxlength="2"  style="width: 20px;height:20px;" value="<%= prevantenatalCard!=null && prevantenatalCard.getAge()!=null?antenatalCard.getAge():""%>"/>  
						<label class="smallAuto">Yrs</label>  
				 		<label class="auto bgNone">Pregnancy Outcome</label> 
						
						<select class="medium" multiple="5" style="height:65px;" name="<%=PREGNANCY_OUTCOME%>" onchange="displayPreTermValue(this.value);toggleBabyDetails();displayPregnancyOutComeSelection(this.value);checkForFTND();" id="<%=PREGNANCY_OUTCOME%>">
											<option value="">Select</option>
											<option value="FTND" <%= prevantenatalCard!=null && prevantenatalCard.getPregnancyOutcome()!=null && prevantenatalCard.getPregnancyOutcome().contains("FTND")?"selected":""%>>FTND</option>
					 						<option value="Vacuum" <%= prevantenatalCard!=null && prevantenatalCard.getPregnancyOutcome()!=null && prevantenatalCard.getPregnancyOutcome().contains("Vacuum")?"selected":""%>>Vacuum</option>
											<option value="Forceps" <%= prevantenatalCard!=null && prevantenatalCard.getPregnancyOutcome()!=null && prevantenatalCard.getPregnancyOutcome().contains("Forceps")?"selected":""%>>Forceps</option>
											<option value="LSCS" <%= prevantenatalCard!=null && prevantenatalCard.getPregnancyOutcome()!=null && prevantenatalCard.getPregnancyOutcome().contains("LSCS")?"selected":""%>>LSCS</option>
											<option value="Abortion"<%= prevantenatalCard!=null && prevantenatalCard.getPregnancyOutcome()!=null && prevantenatalCard.getPregnancyOutcome().contains("Abortion")?"selected":""%>>Abortion</option>
											<option value="Ectopic"<%= prevantenatalCard!=null && prevantenatalCard.getPregnancyOutcome()!=null && prevantenatalCard.getPregnancyOutcome().contains("Ectopic")?"selected":""%>>Ectopic</option>
											<option value="Vesicular Mole"<%= prevantenatalCard!=null && prevantenatalCard.getPregnancyOutcome()!=null && prevantenatalCard.getPregnancyOutcome().contains("Vesicular Mole")?"selected":""%>>Vesicular Mole</option>
										    <option value="Pre Term" <%= prevantenatalCard!=null && prevantenatalCard.getPregnancyOutcome()!=null && prevantenatalCard.getPregnancyOutcome().contains("Pre Term")?"selected":""%>>Pre Term</option> 
											<option value="VBAC" <%= prevantenatalCard!=null && prevantenatalCard.getPregnancyOutcome()!=null && prevantenatalCard.getPregnancyOutcome().contains("VBAC")?"selected":""%>>VBAC</option>
											<option value="Normal vaginal delivery" <%= prevantenatalCard!=null && prevantenatalCard.getPregnancyOutcome()!=null && prevantenatalCard.getPregnancyOutcome().contains("Normal vaginal delivery")?"selected":""%>>Normal vaginal delivery</option>
											
											</select>
											
											<input name="preTermValue" 
										id="preTermValueId" type="text" size="11" value="<%=prevantenatalCard!=null && prevantenatalCard.getPregnancyOutcomePreTermValue()!=null ?prevantenatalCard.getPregnancyOutcomePreTermValue():""%>" maxlength="100" validate="Others,string,no"
										 style="display:block; margin-top:5px;"/>
										 <textarea name="pregnancyOutComeSelection" id="pregnancyOutComeSelection" cols="0" rows="0" maxlength="256" style="width:169px;height:30px; display: block"><%=prevantenatalCard!=null && prevantenatalCard.getPregnancyOutcome()!=null ? prevantenatalCard.getPregnancyOutcome():""%></textarea>
										 <div class="clear"></div>
									<!-- - <input name="preTermValue" 
										id="preTermValueId" type="text" size="11" maxlength="100" validate="Others,string,no" 
										tabindex="1" style="display:none; margin-top:5px;"/> -->
						<label class="auto bgNone">Place of Outcome</label> 
						<select style="width:140px;" name="<%=PLACE_OF_DELIVERY%>" id="<%=PLACE_OF_DELIVERY%>" onchange="displayOthersValue(this.value);">
											<option value="">Select</option>
											<option value="CHC" <%= prevantenatalCard!=null && prevantenatalCard.getPlaceDelivery()!=null && prevantenatalCard.getPlaceDelivery().equals("CHC")?"selected":""%>>CHC</option>
											<option value="PHC" <%= prevantenatalCard!=null && prevantenatalCard.getPlaceDelivery()!=null && prevantenatalCard.getPlaceDelivery().equals("PHC")?"selected":""%>>PHC</option>
											<option value="DH" <%= prevantenatalCard!=null && prevantenatalCard.getPlaceDelivery()!=null && prevantenatalCard.getPlaceDelivery().equals("DH")?"selected":""%>>DH</option>
												<option value="Private Hospital" <%= prevantenatalCard!=null && prevantenatalCard.getPlaceDelivery()!=null && prevantenatalCard.getPlaceDelivery().equals("Private Hospital")?"selected":""%>>Private Hospital</option>
											<option value="W&C" <%= prevantenatalCard!=null && prevantenatalCard.getPlaceDelivery()!=null && prevantenatalCard.getPlaceDelivery().equals("W&C")?"selected":""%>>W&C</option>
											<option value="Private-Multispecialty" <%= prevantenatalCard!=null && prevantenatalCard.getPlaceDelivery()!=null && prevantenatalCard.getPlaceDelivery().equals("Private-Multispecialty")?"selected":""%>>Private-Multispecialty</option>
											<option value="Home Delivery" <%= prevantenatalCard!=null && prevantenatalCard.getPlaceDelivery()!=null && prevantenatalCard.getPlaceDelivery().equals("Home Delivery")?"selected":""%>>Home Delivery</option>
											<option value="Others" <%= prevantenatalCard!=null && prevantenatalCard.getPlaceDelivery()!=null && prevantenatalCard.getPlaceDelivery().equals("Others")?"selected":""%>>Others</option>
											</select>
									<input name="placeOfDeliveryOthers"  id="placeOfDeliveryOtherId" type="text" size="11" maxlength="100" validate="Others,string,no" style="display:<%= prevantenatalCard!=null && prevantenatalCard.getPlaceDelivery()!=null && prevantenatalCard.getPlaceDelivery().equals("Others")?"block":"none"%>;" />
						
					 	<div class="clear"></div>
						<label  class="medium">Baby</label>
						
						<label class="auto bgNone">Delivery Outcome</label> 
						<select   id="deliveryOutcome" class="medium2" name="deliveryOutcome" onchange="displayLiveBirthValue(this.value,);" >
											<option value="">Select</option>
											<option value="Live" <%= (prevantenatalCard!=null && prevantenatalCard.getDeliveryOutcome()!=null && prevantenatalCard.getDeliveryOutcome().equalsIgnoreCase("Live"))?"selected":""%>>Live</option>
											<option value="Still Birth" <%= prevantenatalCard!=null && prevantenatalCard.getDeliveryOutcome()!=null && prevantenatalCard.getDeliveryOutcome().equalsIgnoreCase("Still Birth")?"selected":""%>>Still Birth</option>
											<option value="IUD" <%= prevantenatalCard!=null && prevantenatalCard.getDeliveryOutcome()!=null && prevantenatalCard.getDeliveryOutcome().equalsIgnoreCase("IUD")?"selected":""%>>IUD</option>
											<option value="NND" <%= prevantenatalCard!=null && prevantenatalCard.getDeliveryOutcome()!=null && prevantenatalCard.getDeliveryOutcome().equalsIgnoreCase("NND")?"selected":""%>>NND</option>
											</select> 
						
									
				 		<label class="auto bgNone">Gender</label> 
						<select name="<%=SEX%>" class="medium2" id="<%=SEX%>" >
											<option value="0">Select</option>
											<%
												for (MasAdministrativeSex masAdministrativeSex : sexList) {
											%>
											<option value="<%=masAdministrativeSex.getId()%>" <%= prevantenatalCard!=null && masAdministrativeSex.getId().toString().equals(prevantenatalCard.getSex())?"selected":""%>><%=masAdministrativeSex.getAdministrativeSexName()%></option>
											<%
												}
											%>
											</select>
						
						<label class="auto bgNone">GA</label> 
						<input id="previousGestationalAgeId" name="previousGestationalAge" type="text" style="width: 20px;height:20px;" onkeypress="javascript:return isNumber(event)" validate="Gestational Age,int,no" onblur="checkGAInPreviousPregnancy(this.value,this.id);" maxlength="3" value="<%=prevantenatalCard!=null && prevantenatalCard.getPreviousGestationalAge()!=null?prevantenatalCard.getPreviousGestationalAge():""%>" />
						<label class="smallAuto">in Weeks</label> 
						
						<label class="auto bgNone">Birth Weight</label> 
						<input id="<%=BIRTH_WEIGHT%>" id="b100" name="<%=BIRTH_WEIGHT%>" type="text" style="width:35px;" onkeypress="javascript:return isNumber(event)" maxlength="5" value="<%=prevantenatalCard!=null && prevantenatalCard.getBirthWeight()!=null&&prevantenatalCard.getBirthWeight()!=0?prevantenatalCard.getBirthWeight():""%>" onblur="checkMaxLimit(this.value,this.id,'10')"/>
						<label class="smallAuto">Kg</label>
							<div class="clear"></div>
						<label class="auto">Blood Transfusion</label>
						<select id="<%=BLOOD_TRANSFUSION%>" class="YesNo"
										name="<%=BLOOD_TRANSFUSION%>"
										>
											<option value="">Select</option>
											<option value="Yes"<%=prevantenatalCard!=null && prevantenatalCard.getBloodTransfusion()!=null && prevantenatalCard.getBloodTransfusion().equalsIgnoreCase("yes")?"selected":"" %> >Yes</option>
											<option value="No" <%=prevantenatalCard!=null && prevantenatalCard.getBloodTransfusion()!=null ?  prevantenatalCard.getBloodTransfusion().isEmpty()|| prevantenatalCard.getBloodTransfusion().equalsIgnoreCase("no")?"selected":"":"selected"%>>No</option>
									</select>
						<div class="clear"></div>
						<h4 style="text-align:left;">Complications</h4>  
						
						<div class="clear"></div>
						 <label class="medium">Antenatal</label> 
						<textarea type="text" style="width:465px;height:60px" id="antenatal" name="antenatal" maxlength="220" placeholder="NIL"  style="width:60px;"><%=prevantenatalCard!=null && prevantenatalCard.getAntenatal()!=null?prevantenatalCard.getAntenatal():""%></textarea>  
						
						 <label class="medium">Intra Partum</label> 
						<textarea type="text" style="width:465px;height:60px" id="intraPartum" name="intraPartum" maxlength="220" placeholder="NIL"  style="width:60px;"><%=prevantenatalCard!=null && prevantenatalCard.getIntraPartum()!=null?prevantenatalCard.getIntraPartum():""%></textarea>  
						
						<div class="clear"></div>
						 <label class="medium">Post Partum</label> 
						<textarea type="text" style="width:465px;height:60px" id="postPartum"   name="postPartum" maxlength="220" placeholder="NIL"  style="width:60px;" ><%=prevantenatalCard!=null && prevantenatalCard.getPostPartum()!=null?prevantenatalCard.getPostPartum():""%></textarea> 
						
						<label class="medium">Remark</label> 
						<textarea type="text" style="width:465px;height:60px" id="remarkforPrePreg" name="remarkforPrePregs" maxlength="220"><%=prevantenatalCard!=null && prevantenatalCard.getRemarks()!=null?prevantenatalCard.getRemarks():""%></textarea>
						
						<div class="clear"></div>
						<div class="paddingTop5"></div>						
						
						<%/* if(displayOnly!=null){ */
						if(counter!=0 && counter>prevTotal){
						%>
						<input type="button" style="margin-left:930px;" value="<Previous" onclick="displayNSavePregnancyDetails(<%=counter-1%>,'y')"><%}%>
						<input type="button" style="float:right;margin-right:16px;" value="Save & Next>" onclick="displayNSavePregnancyDetails(<%=counter%>,'n');">
						<%/*} else{ */ %>
						
						<%-- <input type="button" value="<Previous" onclick="displayNSavePregnancyDetails(<%=counter%>,'y')">
						<input type="button" value="Save & Next>"onclick="displayNSavePregnancyDetails(<%=counter+1%>,'n');">
						<%} %> --%>
						
						<input type="hidden" name="totalPreDt" value="<%=i%>" id="totalPreDt"/>
						<input type="hidden" name="prevTotal" value="<%=prevTotal%>" id="prevTotal"/>
						<div class="clear"></div>
						<div class="clear"></div>		
						</div>
					


<style>
.fixedWidth900 {background:#fff;min-height:70px; max-height:160px; width:1154px;overflow-x: hidden;}
.fixedWidth900 p {text-align: justify;margin: 0;line-height: 17px;padding: 5px;}

.normaltextLabel
{
background:none;box-shadow:none;margin-left: 1px;margin-bottom:-5px;
font-weight: normal;
width: auto;
height: auto;
text-align: justify;
}

.normalLabel
{
width: auto;background:none;box-shadow:none;margin-left: 1px;margin-bottom:-5px;
margin-right: -2px;
margin-left: -1px;
font-weight: normal;

}
</style>

