
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<Object[]> brandList = new ArrayList<Object[]>();
if(map.get("brandList") != null){
	brandList = (List<Object[]>)map.get("brandList");
}

int counter1=0;
if(map.get("counter")!=null){
	counter1=(Integer)(map.get("counter"));
}
//if(request.getParameter("hdb")!=null){
	//counter1=Integer.parseInt(request.getParameter("hdb"));
//}
%>
<!-- <select name="brandId<counter1%>" id="brandId<counter1%>" onchange="populateManufacturer(this.value,<counter1%>)" tabindex="1" >
<option value="0">Select</option> -->
	<%
	    	if (brandList!=null && brandList.size() > 0 )
	     	{
	   //for(Object[]  brand :  brandList)
	    			//{
		   Object[]  brand = brandList.get(0);
		   MasManufacturer manu = new MasManufacturer();
		   manu = (MasManufacturer)brand[2];
		  %>
	<input type="hidden"  name="brandId<%=counter1%>" id="brandId<%=counter1%>" value="<%=brand[0]%>" ></input>
	<input type="hidden" id="manufactureId<%=counter1%>"	name="manufactureId<%=counter1%>"  size="10" maxlength="6" readonly="readonly" value="<%=manu.getId()%>"  />
	<!-- <option value="<brand[0]%>"><brand[1]%> -->
	<%
	  //   			}
			}
	     	 %>
	     	 
	     	 
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<!--</select> -->