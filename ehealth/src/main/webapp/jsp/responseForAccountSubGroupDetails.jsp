
<%@page import="java.io.IOException"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Properties"%>
<%@page import="java.util.HashMap"%>


<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHEQUE_DATE "%>
<%@ page import="static jkt.hms.util.RequestConstants.CHEQUE_NO "%>
<%@ page import="static jkt.hms.util.RequestConstants.BANK_NAME "%>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}
	int accountSubGroupId=0;
	if(map.get("accountSubGroupId")!=null){
		accountSubGroupId=(Integer)map.get("accountSubGroupId");
	}
	System.out.println("accountSubGroupId-------jsp--->>"+accountSubGroupId);
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");
		int subGroupIdForPayment = 0;
		subGroupIdForPayment = Integer.parseInt(properties.getProperty("subGroupIdForPayment"));
		System.out.println("subGroupIdForPayment-------jsp--->>"+subGroupIdForPayment);
		String flag="";
		if(map.get("flag")!=null){
			flag=(String)map.get("flag");
		}
		System.out.println("flag  jsp====>"+flag);
		if(flag.equals("2")){
				%>
<%--<div id="checkNoDiv" >
<label>Bank Name </label>
 <input id="bankNameId" type="text"  size="5" name="<%=BANK_NAME %>"  value=""  MAXLENGTH="40"  tabindex=1 /> --%>

<label>Cheque No. </label>
<input id="chequeNoId" type="text"  size="5" name="<%=CHEQUE_NO%>"  value=""  MAXLENGTH="20"  tabindex=1 />

<label>Cheque Date</label>
<input type="text" name="<%=CHEQUE_DATE %>" id="chequeDate" value="<%=currentDate %>" class="calDate"  MAXLENGTH="10" validate="Check Date,date,no" />

</div>
<%}%>