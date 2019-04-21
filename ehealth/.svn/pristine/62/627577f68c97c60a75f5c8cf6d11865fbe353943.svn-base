<%@page import="jkt.hms.masters.business.DialysisSchudeling"%>
<%@page import="java.sql.Time"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.AppPatientAppointments"%>
<%@page import="jkt.hms.masters.business.DialysisSetup"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>	

<%

String[][] calculatedSlotList=null;
int counter=0;
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
Box box=HMSUtil.getBox(request);

String currenDate = (String) utilMap.get("currentDate");
String currentTime = (String) utilMap.get("currentTime");
Map<String, Object> map = new HashMap<String, Object>();
List<DialysisSchudeling>filledDialysisSchedulingList = new ArrayList<DialysisSchudeling>();
if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
}

Map<String, String> queueMap = new HashMap<String, String>();

if (map.get("queueMap") != null) 
{
	queueMap = (Map<String,String>) map.get("queueMap");
}
if (map.get("filledDialysisSchedulingList") != null) 
{
	filledDialysisSchedulingList = (List) map.get("filledDialysisSchedulingList");
}

if(map.get("slotList")!=null)
{
        calculatedSlotList=(String [][])map.get("slotList");
}
//System.out.println("calculatedSlotList==="+calculatedSlotList.length);
if(map.get("counter")!=null)
{
        counter=(Integer)map.get("counter");
}

//System.out.println("counter=="+counter);
Calendar c_currentTime=Calendar.getInstance();
%>

<table border="0" cellspacing="0" cellpadding="0">
  <tr>
<%
  int inc = 0;
        Calendar c_calculatedTime=Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	String currentTimeinformat=sdf.format(c_currentTime.getTime());
	 StringTokenizer st1 = null;
	 StringTokenizer  st2= null;
	 String t1 = "";
	 String t2 = "";
	 String t3 = "";
	 String t4 = "";
	 
	 
  	for(inc=0;inc<counter;inc++){
  		
  		
       if(calculatedSlotList[inc][0]!=null || calculatedSlotList[inc][1]!=null)
       {
       //c_calculatedTime.setTime(Time.valueOf(calculatedSlotList[inc][0]));
         //String calculatedTimeFormat=sdf.format(c_calculatedTime.getTime());
	    st1=new StringTokenizer(calculatedSlotList[inc][0],":");
	    st2=new StringTokenizer(calculatedSlotList[inc][1],":");
	    t1 = st1.nextToken();
	    t2 = st1.nextToken();
	    t3 = st2.nextToken();
	    t4 = st2.nextToken();
	    String disabled = "";
	    String btnClass = "";
	    //System.out.println("filledDialysisSchedulingList==="+filledDialysisSchedulingList.size());
	   if(filledDialysisSchedulingList.size()>0){
		   for(DialysisSchudeling dialysisSchudeling :filledDialysisSchedulingList){
			  // System.out.println("from time slot==="+dialysisSchudeling.getFromTimeSlot().substring(0,5));
			  // System.out.println("to time slot==="+dialysisSchudeling.getToTimeSlot().substring(0,5));
	   		if(dialysisSchudeling.getFromTimeSlot().substring(0,5).equals(t1+":"+t2) && dialysisSchudeling.getToTimeSlot().substring(0,5).equals(t3+":"+t4) ){
	   			disabled = "disabled";
	   			btnClass ="green";
            	//System.out.println("1111");
            	break;
	   		}
		   }
           
            %>

<td>
<input type="button" id="Id<%=inc%>" name="OnlineToken" value="<%=t1%>:<%=t2%>- <%=t3%>:<%=t4%>" onclick="getPriorityNumber(<%=inc%>)" <%=disabled %> style="background: <%=btnClass%>">
 <input type="hidden" id="fromTimeSlot<%=inc %>"  value="<%=calculatedSlotList[inc][0]%>" />
 <input type="hidden" id="toTimeSlot<%=inc %>"     value="<%=calculatedSlotList[inc][1]%>" />
</td>

<%}else{%>

<td>
<input type="button" id="Id<%=inc%>" name="OnlineToken" value="<%=t1%>:<%=t2%>- <%=t3%>:<%=t4%>" onclick="getPriorityNumber(<%=inc%>)" <%=disabled %> style="background: <%=btnClass%>">
 <input type="hidden" id="fromTimeSlot<%=inc %>"  value="<%=calculatedSlotList[inc][0]%>" />
 <input type="hidden" id="toTimeSlot<%=inc %>"     value="<%=calculatedSlotList[inc][1]%>" />
</td>


<%}}} %>
</tr>
</table>