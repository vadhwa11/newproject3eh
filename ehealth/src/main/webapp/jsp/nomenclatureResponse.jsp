
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List brandManufacturerList= new ArrayList();
if(map.get("brandManufacturerList") != null){
	brandManufacturerList = (List)map.get("brandManufacturerList");
}
int counter=0;
int incr = 1;
if(map.get("counter") != null){
	counter = (Integer)map.get("counter");
}
%>
<%@page import="java.util.Iterator"%>

	<%	if(brandManufacturerList.size() !=0){

		for (Iterator iterator = brandManufacturerList.iterator(); iterator.hasNext();) {

			Object[] manufact = (Object[]) iterator.next();

			int id =(Integer)manufact[0];
			//String manufact_code=(String)manufact[1];
			//String manufact_name=(String)manufact[2];
			//int itemId =(Integer)manufact[3];
			String nomenclature =(String)manufact[4];
			String pvmsNo =(String)manufact[5];

%>
<input type="hidden" name="manufactureId<%=counter%>" id="manufactureId<%=counter%>" value="<%=id%>" />
<input type="text" value="<%=nomenclature%>[<%=pvmsNo%>]" id="nomenclature<%=counter%>"  size="35" name="nomenclature<%=counter%>"  onblur="populatebrand(this.value,'<%=counter%>');" />
	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">


