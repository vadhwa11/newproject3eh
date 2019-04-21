
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.OtBooking"%>
<%@page import="java.util.Iterator"%>



<%

Map<String,Object> map = new HashMap<String,Object>();

if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<OtBooking> otBookingList = new ArrayList<OtBooking>();
if(map.get("otBookingList") != null){
	otBookingList = (List<OtBooking>)map.get("otBookingList");
}
%>



<ul>
	


%>

<input type="hidden" name="otBookingList" id="otBookingList" value="<%=otBookingList%>" />


	
</ul>



