<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<%

Map<String, Object> map = new HashMap<String, Object>();
List<Patient> patientList=new ArrayList<Patient>();
List<MasRelation> relationList = new ArrayList<MasRelation>();
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("patientList") != null){
	patientList = (List<Patient>)map.get("patientList");
}
if(map.get("relationList") != null){
	relationList = (List<MasRelation>)map.get("relationList");
}
Patient patient=new Patient();
for(Patient patient2:patientList)
{
	patient=patient2;
}
%>


<%if(patientList!=null && patientList.size()>0)
	{
	String pName = "";
	pName=patient.getPFirstName();
	if(patient.getPMiddleName() != null){
		pName += " "+patient.getPMiddleName();
	}
	if(patient.getPLastName() != null){
		pName += " "+patient.getPLastName();
	}
	%>
<label>UHID</label>
<label class="value">
<input type="text" name="<%=NEXT_OF_KIN_UHID %>" id="<%=NEXT_OF_KIN_UHID %>" value="<%=patient.getHinNo() %>" onblur="searchDependent();" />
</label>


 <label>Name</label> 
 <label class="value"><input id="nokNameId"
                       type="text" name="<%=RELATIVE_NAME %>" value="<%=pName%>"
                       validate="Dependent Name,string,no" maxlength="30"  tabindex="34" />
                       </label>
                        
<label> Relation</label> 
<label class="value"><select name="<%=RELATION_ID%>"
                       id="relId" validate=" Relation,string,no" tabindex="35">
                       <option value="">Select</option>
                       <%
                       for(MasRelation relation:relationList)
                       {
                    	   %>
                    	   <option value="<%=relation.getId()%>"><%=relation.getRelationName()%></option>
                    	   <%
                       }
                       %>
               </select>
               </label>
               <div class="clear"></div>
               <label>Contact No. </label> 
               <label class="value"><input type="text" name="<%=MOBILE %>"
                       id="mobileNo" value="<%=patient.getMobileNumber()!=null?patient.getMobileNumber():""%>" validate="Cobtact Number,phone,no"
                       MAXLENGTH="10" tabindex="29" />
              </label>                     
                     
               </textarea>
               </label>  
<label>Address</label>
                     <label class="value">  <textarea name="<%=ADDRESS %>" id="addr" cols="20" rows="2"
                               tabindex="19" validate="Address,string,no"
                               onpaste="return checkOnPaste(this)"
                               oninput="return checkMaxLengthMoz(this)"
                               onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
                              >
               </textarea>
               </label>
               <%} else 
               {
            	   %>
            	   <label>UHID</label>
<label class="value">
<input type="text" name="<%=NEXT_OF_KIN_UHID %>" id="<%=NEXT_OF_KIN_UHID %>" onblur="searchDependent();" />
</label>


 <label>Name</label> 
 <label class="value"><input id="nokNameId"
                       type="text" name="<%=RELATIVE_NAME %>" value=""
                       validate="Dependent Name,string,no" maxlength="30" tabindex="34" />
                       </label>
                        
<label> Relation</label> 
<label class="value"><select name="<%=RELATION_ID%>"
                       id="relId" validate=" Relation,string,no" tabindex="35">
                       <option value="">Select</option>
                       <%
                       for(MasRelation relation:relationList)
                       {
                    	   %>
                    	   <option value="<%=relation.getId()%>"><%=relation.getRelationName()%></option>
                    	   <%
                       }
                       %>
               </select>
               </label>
               <div class="clear"></div>
               <label>Contact No. </label> 
               <label class="value"><input type="text" name="<%=MOBILE %>"
                       id="mobileNo" value="" validate="Cobtact Number,phone,no"
                       MAXLENGTH="10" tabindex="29" />
              </label>                     
                     
               </textarea>
               </label>  
<label>Address</label>
                     <label class="value">  <textarea name="<%=ADDRESS %>" id="addr" cols="20" rows="2"
                               tabindex="19" validate="Address,string,no"
                               onpaste="return checkOnPaste(this)"
                               oninput="return checkMaxLengthMoz(this)"
                               onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
                              >
               </textarea>
               </label>
            	   <%
               }%>
               <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       