<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
Map<String,Object>map=new HashMap<String,Object>();

if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
}
List<Object[]>sampleDetails=new ArrayList<Object[]>();
if(map.get("sampleDetails")!=null){
	sampleDetails=(List<Object[]>)map.get("sampleDetails");
}
int hinId=0;
if(map.get("hinId")!=null){
	hinId=(Integer)map.get("hinId");
}
int orderId=0;
if(map.get("orderId")!=null){
	orderId=(Integer)map.get("orderId");
} 
%>
<table>
        <tr>
            <th>Diag. Number </th>
            <th>Modality/Sample/Container</th>
            <th>Print</th>
        </tr>
        <%
            for(Object[] sample:sampleDetails){
        %>
        <tr>
            <%
                if(sample[0]!=null && !"".equalsIgnoreCase(sample[0].toString())){
            %>
            <td><input type="text" name="diagNo" id="diagNo" readonly="readonly"
                value="<%=sample[4]+"/"+sample[13]+"/"+sample[8]+"/"+sample[0]%>" /></td>
            <td><input type="text" name="inv" readonly="readonly" id="inv"
                value="<%=sample[1]+"/"+sample[2]+"/"+sample[3]%>" size="50" /> 
            
             
            <%-- <input type="text" value="../servlets/jasperprintlabbarcode?&diag_no=<%=sample[13]+"/"+sample[8]+"/"+sample[0]%>&subChargeCodeName=<%=sample[1]%>
				&hinId=<%=hinId%>&subchargeCodeCode=<%=sample[4] %>&sampleCode=<%=sample[2]%>&collectedBy=<%=sample[5]%>
				&collectionDate=<%=sample[6]%>&collectionTime=<%=sample[7]%>&sampleNumber=<%=sample[8]%>&containerCode=<%=sample[3]%>
				&sequenceNo=<%=sample[0]%>&inpatient_id=<%=sample[10]%>&visit_id=<%=sample[9]%>&routineUrgentStatus=<%=sample[11]%>
				&orderNo=<%=sample[12]%>" > --%>
            </td>
                
            <td>
            <input type="hidden" name="inv_id" id="inv_id" value="<%=sample[2]%>" /> 
            <input type="hidden" name="order_id" id="order_id" value="<%=sample[3]%>" />
            <input type="hidden" name="sectionCode"  value="<%=sample[4]%>" />    
            <input type="hidden" name="sampleNumber"  value="<%=sample[8]%>" />    
            <input type="hidden" name="containerCode"  value="<%=sample[3]%>" />    
            <input type="hidden" name="sequenceNo" value="<%=sample[0]%>" />       
            <input type="hidden" name="collectedBy"  value="<%=sample[5]%>" />    
            <input type="hidden" name="collectionDate"  value="<%=sample[6]%>" />
            <input type="hidden" name="collectionTime"  value="<%=sample[7]%>" /> 
     		<input type="hidden" name="visit_id"  value="<%=sample[9]%>" />
            <input type="hidden" name="inpatient_id"  value="<%=sample[10]%>" />    
            <input type="hidden" name="orderNo"  value="<%=sample[12]%>" />    
            <input type="hidden" name="routineUrgentStatus" value="<%=sample[11]%>" />  
            <!-- <input type="button" class="button" name="print" id="parint"    value="print" 
            onclick="generatePrin('<%=sample[13]+"/"+sample[8]+"/"+sample[0]%>','<%=sample[1]%>',<%=hinId%>,'<%=sample[4] %>','<%=sample[2]%>');" /> 
             submitForm('message','lab?method=generateReportForLabMachineBarcode&diag_no='+a+'&subChargeCodeName='+b+'&hinId='+c+'&subchargeCodeCode='+d+'&sampleCode='+e); -->
           
           
           <!-- commented by amit das on 30-06-2016 -->
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
		 </APPLET>  --%>
		 
		  <!-- added by amit das on 30-06-2016 -->
		 <%--<input type="button" class="button" name="print" id="parint"	value="print" onclick="generatePrintLab('<%=orderId%>','<%=sample[14]%>');" /> --%>
		<input type="button" class="button" name="print" id="parint"	
		 value="print" onclick="generatePrintLab('<%=orderId%>','<%=sample[14]%>','<%=sample[12]%>','','','<%=sample[8]%>','<%=sample[1]%>','<%=(sample[4]+"/"+sample[0])%>','0');" />
		   </td>
        </tr>
        <%
            } }
        %>


    </table>