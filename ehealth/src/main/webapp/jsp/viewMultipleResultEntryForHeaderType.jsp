<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.DgSubMasInvestigationComparatorByOrderNo"%>
<%@page import="java.util.*"%>
<%
		int pageNo=1;
		Map<String,Object> map = new HashMap<String,Object>();
		Set<DgFixedValue> fixedValList = new HashSet<DgFixedValue>();
		Set<DgFixedValue> allFixedValueList = new HashSet<DgFixedValue>();
		Set<DgFixedValue> subList = new HashSet<DgFixedValue>();
		DgSubMasInvestigation dgCollection=new  DgSubMasInvestigation();
		List<String> resultSeqNoList = new ArrayList<String>();
	    String age = "";
	    int sizeOfList = 0;
	    int resultEntryIndex = 0;
	    int resultEntryIndexTemp= 0; 
	    int srNoCounter = 0;
	    char subCounter = 97;
	    Integer resultEntryIndexForMultiple = 0;
	    int dgSubMasInvestigationId=0;
		DgSampleCollectionDetails dgDetails = new DgSampleCollectionDetails();
		DgSampleCollectionDetails dgDet = new DgSampleCollectionDetails();
		List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
		Patient patient = new Patient();
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if(map.get("sampleCollectionList") != null){
			sampleCollectionList=(List)map.get("sampleCollectionList");
		}
		if(request.getParameter("resultEntryIndex") != null){
			resultEntryIndex = Integer.parseInt(request.getParameter("resultEntryIndex"));
			resultEntryIndexTemp =  resultEntryIndex;
		}
		if(request.getAttribute("dgCollection")!=null){
		
			dgCollection=(DgSubMasInvestigation)request.getAttribute("dgCollection");
		}
		if(request.getParameter("subCounter")!=null){
			char c=request.getParameter("subCounter").charAt(0);
			c++;
		subCounter=c;
		
		}
		
		if(request.getParameter("srNoCounter") != null){
			srNoCounter = Integer.parseInt(request.getParameter("srNoCounter"));
			
		}
		if(request.getParameter("dgSubMasInvestigationId") != null){
			dgSubMasInvestigationId = Integer.parseInt(request.getParameter("dgSubMasInvestigationId"));
			
		}
		
		if(map.get("allFixedValueList") != null){
			
			allFixedValueList=new HashSet((List)map.get("allFixedValueList"));
		}
		if(map.get("resultSeqNoList") != null){
			resultSeqNoList = (List<String>)map.get("resultSeqNoList");
		}

		if(map.get("subList") != null){
				subList=new HashSet((List)map.get("subList"));
		}
		
		if(request.getParameter("resultEntryIndexForMultiple") != null){
			resultEntryIndexForMultiple = Integer.parseInt(request.getParameter("resultEntryIndexForMultiple"));
		}

	    if(sampleCollectionList != null && sampleCollectionList.size()>0)
		{
			dgDetails=(DgSampleCollectionDetails) sampleCollectionList.get(0);
			dgDet =(DgSampleCollectionDetails) sampleCollectionList.get(resultEntryIndex);
			sizeOfList = sampleCollectionList.size();
			patient = (Patient) dgDetails.getSampleCollectionHeader().getHin();
		}
	    for(DgFixedValue dgFixedValue:dgCollection.getDgFixedValues()){
	    	
	    if(dgFixedValue.getFixedValue()!=null&& !dgFixedValue.getFixedValue().equalsIgnoreCase("null")){
	    	fixedValList.add(dgFixedValue);
	    }
	    }
	%>
<!-- Table Starts -->
<%@page import="jkt.hms.masters.business.DgSubMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgFixedValue"%>
<%@page import="jkt.hms.masters.business.Patient"%>


<!--  for increment of rows  -->
<%
	int detailCounter=8; 
	int temp=0;
	int inc = resultEntryIndexForMultiple;
	
	if(pageNo!=1)
	{
	temp=detailCounter*(pageNo-1);
	} 
	%>
<!--  end of increment code  -->
<!-- for getting sets  -->
<%
	Set<DgSubMasInvestigation> subSet = new  HashSet<DgSubMasInvestigation>();
	Set<DgNormalValue>normalSet = new HashSet<DgNormalValue>();
	
		dgDet = sampleCollectionList.get(resultEntryIndexTemp);
		

	
		%>


<%
		
	normalSet = dgCollection.getDgNormalValues();
	
	%>
<!--  if condition when result type is heading and comaprison type is none -->
<!-- end of if condition when result type is heading and comaprison type is none -->

<!-- if condition when result type is single parameter and comparison type is none -->
<input name="chargeCodeCodeForPerticularTestForMultiple"
	id="chargeCodeCodeForPerticularTestForMultiple<%=srNoCounter %><%=subCounter %>"
	value=<%= dgCollection.getInvestigation().getChargeCode().getChargeCodeCode()%>
	type="hidden">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		