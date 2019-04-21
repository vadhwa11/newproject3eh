<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * message.jsp  
 * Purpose of the JSP -  This is for Message.
 * @author  Dipali
 * Create Date: 21 Nov,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>

<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	String message="";
	String url="";
	String url1="";
	int hinId=0;
	String DiagNo="";
	
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	List<Object[]> sampleDetails=new ArrayList<Object[]>();
	if(map.get("sampleDetails")!=null){
		sampleDetails=(List<Object[]>)map.get("sampleDetails");
	}
	
	if(map.get("messageTOBeVisibleToTheUser") !=null){
		message=""+map.get("messageTOBeVisibleToTheUser");
	}
	if(map.get("url") !=null){
		url=""+map.get("url");
	}
	if(map.get("url1") !=null){
		url1=""+map.get("url1");
	}
	if(map.get("hinId")!=null){
		hinId=(Integer)map.get("hinId");
	}
	int orderId=0;
	if(map.get("orderId")!=null){
		orderId=(Integer)map.get("orderId");
	} 
	String diag_no="",diagSeqNo="";
	if(map.get("diag_no")!=null){
		diag_no=(String)map.get("diag_no");
	} 
	if(map.get("diagSeqNo")!=null){
		diagSeqNo=(String)map.get("diagSeqNo");
	}
	System.out.println("diagSeqNo "+diagSeqNo);
	//added by govind 12-07-2017
	int nextHinId=0,nextVisitId=0;String nextOrderNo =null;
if(map.get("nextHinId")!=null){
nextHinId=(Integer)map.get("nextHinId");
} 
if(map.get("nextVisitId")!=null){
nextVisitId=(Integer)map.get("nextVisitId");
}

if(map.get("nextOrderNo")!=null){
	nextOrderNo=(String)map.get("nextOrderNo");
}
Map<Integer,Boolean> sampleColId=new HashMap<Integer,Boolean>();//added by govind 13-07-2017	
if(map.get("sampleColId")!=null){
	sampleColId=(Map<Integer,Boolean>)map.get("sampleColId");
}

Map<Integer,String> investIdMap=new HashMap<Integer,String>();	
if(map.get("investIdMap")!=null){
	investIdMap=(Map<Integer,String>)map.get("investIdMap");
}
System.out.println("jsp nextVisitId "+nextVisitId+" nextHinId "+nextHinId);
System.out.println("jsp investIdMap "+investIdMap.size());
//added by govind 12-07-2017 end
//added by govind 12-10-2017
Map<String,Boolean> sampleMap=new HashMap<String,Boolean>();
List<Object[]>sampleDetails1=new ArrayList<Object[]>();
        int objCount=0;
        for(Object[] obj:sampleDetails){        	
        	if(objCount==0){    
        		sampleDetails1.add(obj);
        		sampleMap.put(obj[4].toString(), true);
        	}else{
        	if(sampleMap.get(obj[4].toString())!=null && sampleMap.get(obj[4].toString())==true){  
        		//System.out.println("sampleMap.get(obj[4].toString())--->>"+sampleMap.get(obj[4].toString())+" obj[4].toString()--->>"+obj[4].toString());
        	}else{
        		sampleDetails1.add(obj);
        		sampleMap.put(obj[4].toString(), true);
        	}
        	}
        	objCount++;
        }
        //System.out.println("1 sampleDetails1--->>"+sampleDetails1.size()+" sampleDetails--->>"+sampleDetails.size());
        if(sampleDetails1.size()>0){
        	sampleDetails=null;
        	sampleDetails=sampleDetails1;
        }
        //System.out.println("2 sampleDetails1--->>"+sampleDetails1.size()+" sampleDetails--->>"+sampleDetails.size());
        //added by govind 12-10-2017 end
%>
<form name="message" method="post" action="../servlets/jasperprintlabbarcode">
	<div class="clear"></div>
	<h4>
		<span><%=message%></span>
	</h4>
	<div class="clear"></div>

	<input type="button" value="Back" class="button"
		onClick="submitForm('message','<%=url%>');" />  <%--<input type="button"
		class="buttonAuto" name="next" value="Next Patient"
		onclick="submitForm('message','/hms/hms/lab?method=nextForSampleCollection&orderId=<%=orderId %>');" /> --%><!-- added & commented by govind 12-07-2017 -->
		<%if(nextHinId>0 && nextVisitId>0 && nextOrderNo !=null ){%>
		<input type="button"
		class="buttonAuto" name="next" value="Next Patient"
		onclick="submitForm('message','/hms/hms/lab?method=searchPatient&orderId=<%=nextHinId %>&visitId=<%=nextVisitId %>&orderNo=<%=nextOrderNo %>');" />
		<%} %><!-- added & commented by govind 12-07-2017 end-->
		<%if(url1!=null && !"".equals(url1)){%>
			<input type="button" value="Sample Validation " class="buttonAuto"
								onClick="submitForm('message','<%=url1%>');" />
		<%} %>
	
	<div class="Clear"></div>
	<h4>Barcode Print (Lab Machine)</h4>
	<div class="Clear"></div>
	<table>
		<tr>
			<th>Diag. Number </th>
			<th>Modality/Sample/Container</th>
			<th>Print</th>
		</tr>
		<% Set<String> checkDup=new HashSet<String>();
			for(Object[] sample:sampleDetails){
				String investAr="";
				if(investIdMap.get(sample[15])!=null){
					investAr=(String)investIdMap.get(sample[15]);
				}
			  if(sampleColId.get(sample[14]) !=null && sampleColId.get(sample[14])==true){//added by govind 13-07-2017	
				  %>
		<tr>
			<%
				if(sample[0]!=null && !"".equalsIgnoreCase(sample[0].toString())){
					if(checkDup.add(sample[4]+""+sample[13]+""+sample[8]+""+sample[0])){
			%>
			<td><input type="text" name="diagNo" id="diagNo" readonly="readonly"
				value="<%=sample[4]+"/"+sample[13]+"/"+sample[8]+"/"+sample[0]%>" /></td>
			<td><input type="text" name="inv" readonly="readonly" id="inv"
				value="<%=sample[1]+"/"+sample[2]+"/"+sample[3]%>" size="50" /> <input type="hidden" name="inv_id"
				id="inv_id" value="<%=sample[2]%>" /> <input type="hidden"
				name="order_id" id="order_id" value="<%=sample[3]%>" />
			
			<input type="text" name="modality"  value="<%=sample[1]%>" />	
			<input type="hidden" name="sectionCode"  value="<%=sample[4]%>" />	
			<input type="hidden" name="sampleNumber"  value="<%=sample[8]%>" />	
			<input type="hidden" name="containerCode"  value="<%=sample[3]%>" />	
			<input type="hidden" name="sequenceNo" value="<%=sample[0]%>" />	 
			
				
			<input type="hidden" name="collectedBy"  value="<%=sample[5]%>" />	
			<input type="hidden" name="collectionDate"  value="<%=sample[6]%>" />
			<input type="hidden" name="collectionTime"  value="<%=sample[7]%>" />
			<%-- <input type="hidden" name="sampleCode" value="<%=sample[2]%>" />  --%>
			<input type="hidden" name="visit_id"  value="<%=sample[9]%>" />
			<input type="hidden" name="inpatient_id"  value="<%=sample[10]%>" />	
			<input type="hidden" name="orderNo"  value="<%=sample[12]%>" />	
			<input type="hidden" name="routineUrgentStatus" value="<%=sample[11]%>" />	
			</td>
				
			<%-- <td><input type="button" class="button" name="print" id="parint"	value="print" onclick="generatePrin('<%=sample[13]+"/"+sample[8]+"/"+sample[0]%>','<%=sample[1]%>',<%=hinId%>,'<%=sample[4] %>','<%=sample[2] %>');" /></td> --%>
			<td>
			
			<%-- <APPLET name="appl" CODE="PrinterApplet.class" CODEBASE="../applets"
				ARCHIVE="jasperreports-applet-3.7.0.jar,commons-logging-1.0.4.jar,commons-collections-2.1.1.jar"
				WIDTH="257" HEIGHT="40"></XMP>
				<PARAM NAME=CODE VALUE="PrinterApplet.class">
				<PARAM NAME=CODEBASE VALUE="../applets">
				<PARAM NAME=ARCHIVE
				VALUE="jasperreports-applet-3.7.0.jar,commons-logging-1.0.4.jar,commons-collections-2.1.1.jar">
				<PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.2">
				<PARAM NAME="scriptable" VALUE="true">
				<PARAM NAME="REPORT_URL"
				VALUE="../servlets/jasperprintlabbarcode?&orderId=<%=orderId%>&dgSampleDetailId=<%=sample[14]%>">     
		 </APPLET>   --%>
		 <!-- commented by amit das on 29-06-2016 -->
		 <!-- added by amit das on 29-06-2016 -->
		 <input type="hidden" name="investAr"  value="<%=investAr!=null?investAr:""%>" />	
		 <input type="button" class="button" name="print" id="parint"	
		 value="print" onclick="generatePrintLab('<%=orderId%>','<%=sample[14]%>','<%=diagSeqNo%>','','','<%=sample[8]%>','<%=sample[1]%>','<%=(sample[4]+"/"+sample[0])%>','<%=investAr%>');" />
		 </td>
		</tr>
		<%
			}} }
			}
		%>


	</table>

	<script>
function generatePrin(a,b,c,d,e){
	//alert("a------>>"+a);
	//alert("b------>>"+b);
	//alert("c------>>"+c);
	submitForm('message','lab?method=generateReportForLabMachineBarcode&diag_no='+a+'&subChargeCodeName='+b+'&hinId='+c+'&subchargeCodeCode='+d+'&sampleCode='+e);
}

</script>



<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
