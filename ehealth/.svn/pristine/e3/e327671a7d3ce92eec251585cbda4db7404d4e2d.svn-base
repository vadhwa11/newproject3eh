<%@page import="jkt.hms.masters.business.SurveyDetailMails"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.PhMasParliyamentAssembly"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
int couHouse =0;
if(map.get("countHouse") !=null){
	System.out.println("okay ------> " + couHouse);
	couHouse=(Integer)map.get("countHouse");
}

int couVill =0;
if(map.get("coutnVillage") !=null){
	couVill=(Integer)map.get("coutnVillage");
}

int countSch =0;
if(map.get("countSchool") !=null){
	countSch=(Integer)map.get("countSchool");
}
int anganCou =0;
if(map.get("anganCount") !=null){
	anganCou=(Integer)map.get("anganCount");
}
int collageCount =0;
if(map.get("collCount") !=null){
	collageCount=(Integer)map.get("collCount");
}
int memCount =0;
if(map.get("memberCount") !=null){
	memCount=(Integer)map.get("memberCount");
}
int familyCount = 0;
if(map.get("familyCount") !=null){
	familyCount=(Integer)map.get("familyCount");
}

List<SurveyDetailMails> mailsList=new ArrayList<SurveyDetailMails>();
if(map.get("mails") !=null){
	mailsList=(List<SurveyDetailMails>)map.get("mails");
}



%>
 <div id="tDiv">


<label>House Survey</label> <input type="text" value="<%= couHouse%>" readonly="readonly" name="hSurvey" >
<label>Member Survey</label> <input type="text" value="<%= memCount%>" readonly="readonly" name="mSurvey"> 
<div class="clear"></div>
<label>Village Survey</label><input type="text" value="<%= couVill%>" readonly="readonly" name="vSurvey">

<label>Family Survey</label><input type="text" value="<%= familyCount%>" readonly="readonly" name="scSurvey">
<div class="clear"></div>
<%-- 
<label>Anganwadi Survey</label> <input type="text" value="<%= anganCou%>" readonly="readonly" name="angSurvey">
<label>College Survey</label> <input type="text" value="<%= collageCount%>" readonly="readonly" name="co --%>Survey">

</div>
<div class="clear"></div>
<%-- 
<label>From</label> <input type="text"  readonly="readonly"  name="fromEmail" value="avinash.singh@gmail.com">

 <label>To </label>
	<select name="toEmail" id="toEmail"   validate="Toemail,string,yes">
        <option value="">Select</option>		   
     <%  for( SurveyDetailMails org : mailsList){%>
			
		 <option value="<%=org.getEmails()%>"><%=org.getEmails()%></option>		
	         <%
            }%>
</select>  --%>

<!-- 

<input type="button" name="add" id="addbutton" value="Send Mail"
	class="buttonBig"
	onClick="submitForm('survey','pubHealth?method=sendMailOfSurvey');"
	accesskey="a" tabindex=1 />
 -->

</div>



