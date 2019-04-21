<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>

<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasBankMaster"%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>

<script>
	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}

	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
	</script>

<form name="deposit" id="form1" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%

	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> patientMap = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<Patient> patientDetailsList = new ArrayList<Patient>();
	List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();

	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");

	}
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date=(String)utilMap.get("currentDate");
	String time=(String)utilMap.get("currentTime");

	if(map.get("patientMap") != null){
		patientMap= (Map<String, Object>)map.get("patientMap");
	}

	if(patientMap.get("patientDetailsList") != null){
		patientDetailsList = (List<Patient>)patientMap.get("patientDetailsList");
	}
	if (patientMap.get("bankList") != null) {
		bankList = (List<MasBankMaster>) patientMap.get("bankList");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	String hinNo = "";
	   	if(patientDetailsList.size() > 0){
	   		for(Patient patient12 : patientDetailsList){
	   		hinNo = patient12.getHinNo();
	   		}}	%>
	<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 21 July 2010
 -->
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<h4><span><%=message %></span></h4>
<div class="clear"></div>

<script type="text/javascript">
var bankArray=new Array();
</script>
		    <%   boolean b=false;
			if(patientMap.get("b") != null){
				b=(Boolean)patientMap.get("b");
			}
 if(b==true){ %>
<div class="titleBg">
<h2>JSSK Patient Bill Update</h2>
</div>
<div class="clear"></div>
<!--Block One Starts-->
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<%
			String receiptNo = "";
			if(map.get("receiptNo") != null){
				receiptNo = (String)map.get("receiptNo");
			}

		%> 
		
		<%--<label>Receipt No.</label> <label class="value"><%=receiptNo %></label>

<label>Receipt Date</label> <label class="value"><%=date %></label> <label>Receipt
Time</label> <label class="value"><%=time %></label>
		 --%>
		
		<div class="clear"></div>

<%
   String patientName = "";
   String hin = "";
   String pastDue = "";
   	if(patientDetailsList.size() > 0){
   		for(Patient patient : patientDetailsList){
   			patientName = patient.getPFirstName();
   			if(patient.getPMiddleName()!=null){
   				patientName +=" "+patient.getPMiddleName();
   			}
   			if(patient.getPLastName()!=null){
   				patientName +=" "+patient.getPLastName();
   			}
   			hin = patient.getHinNo();
   			if(patient.getPastDue() != null){
   				pastDue = patient.getPastDue();
   			}

		    String adNo = "";
		    int inpatientId = 0;
		    if(patient.getInpatients() != null)
		    {
				Set<Inpatient> inpatientSet = patient.getInpatients();
				for(Inpatient inpatient :inpatientSet){
					if(!inpatient.getAdStatus().equals("D")){
						inpatientId = inpatient.getId();
						adNo = inpatient.getAdNo();
					}
				}
		    }

	    	if(b==true && !adNo.equals("")){
	    %>
<label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label>
 <label class="value"><%=adNo%></label> <input
	type="text" name="<%=INPATIENT_ID %>" value="<%=inpatientId%>"/><input
	type="text" name="<%=AD_NO %>" value="<%=adNo%>"/> <%} %>
<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<label class="value"><%=patient.getHinNo() %></label> <label>Patient
Name</label> <label class="value"> <%=patientName %></label> <label>Age</label>
<label class="value"> <%=patient.getAge() %></label> <label>Sex</label>
<label class="value"> <%=patient.getSex().getAdministrativeSexName() %></label>
<%
	    	if(!pastDue.equals("")){
	    %> <label>Past Due</label> <label class="value"> <%=pastDue %></label>
<%} %>
<div class="clear"></div>
<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>"/><input
	type="hidden" name="<%=HIN_NO %>" value="<%=hin %>"/> <%}

		}%>
<div class="clear"></div></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block"><label>Total Amount</label> <input type="text"
	id="totalAmt" name="<%=TOTAL_AMOUNT %>" class="readOnly"
	readonly="readonly" />
<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" tabindex="8" value="Update"
	name="Submit"
	onclick="submitForm('deposit','opd?method=updateBills');"
	align="right" />

<input type="reset" class="buttonHighlight" value="Reset" tabindex="10"/>
<%}else{ %>
<h4>Not Applicable to this patient!!</h4>
<input type="button" class="button" value="Back" onclick="submitForm('deposit','opd?method=showSearchJspForJSSK');" tabindex="10"/>
<%} %>
<div class="clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
<div class="paddingTop40"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>


<% 
bankList.clear();
patientDetailsList.clear();

%>