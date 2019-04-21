<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.FaMasAccountGroup"%>
<%@page import="java.math.BigDecimal"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/sorttableAccounts.js" type="text/javascript"></script>

<script type="text/javascript">

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
<form name="faAccountGroup" method="post" action="">
<%
       Map<String, Object> map = new HashMap<String, Object>();
       List<Object[]> faMasAccountGroupList = new ArrayList<Object[]>();
       if (request.getAttribute("map") != null) {
               map = (Map<String, Object>) request.getAttribute("map");
       }
       if(map.get("faMasAccountGroupList") != null){
               faMasAccountGroupList = (List<Object[]>)map.get("faMasAccountGroupList");
       }

%> <%
       if(faMasAccountGroupList.size() > 0){
%>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="titleBg">
<h2>Account Group Balance</h2>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<table  width="100%" border="0" id="accId" cellspacing="0" cellpadding="0" class="sortable">
       <tr>
               <th scope="col">Code</th>
               <th scope="col">Group</th>
               <th scope="col">Op-Dr</th>
               <th scope="col">Op-Cr</th>
               <th scope="col">YTD - Cr.</th>
               <th scope="col">YTD - Dr.</th>
               <th scope="col">Balance-Dr</th>
               <th scope="col">Balance-Cr</th>
               

       </tr>
       <tbody id="tableData">
               <%        String trColor = "";
                           for(Object[] accountGroup : faMasAccountGroupList){
                          // if(accountGroup.getAccountGroupDesc().equalsIgnoreCase("Assets")){
                                       // trColor="#D6FCA9";
                                //}else if(accountGroup.getAccountGroupDesc().equalsIgnoreCase("Liability")){
                                       // trColor="#FDBFA1";
                               // } else if(accountGroup.getAccountGroupDesc().equalsIgnoreCase("Income")){
                                        //trColor="#C2F7FA";
                               // }else if(accountGroup.getAccountGroupDesc().equalsIgnoreCase("Expenditure")){
                                        //trColor="#FDF1B1";
                              //  }
                           
                   //String url = "account?method=showAccountSubGroup&accountId="+accountGroup.getId();        
              %>
               <tr bgcolor="<%=trColor %>" onclick="submitForm('faAccountGroup','account?method=showAccountSubGroup&accountId=<%=accountGroup[0]%>')">
                       <td><%=accountGroup[1] %></td>
                       <td><%=accountGroup[2] %></td>
                       <%
                              if(accountGroup[6] != null && ((BigDecimal)accountGroup[6]).compareTo(new BigDecimal(0)) > 0){
                      %>
                       <td class="rightTxt"><%=accountGroup[6]%></td>
                       <%}else{ %>
                       <td class="rightTxt">0.00</td>
                       <%} %>
                       <%
                              if(accountGroup[5] != null && ((BigDecimal)accountGroup[5]).compareTo(new BigDecimal(0)) > 0){
                      %>
                       <td class="rightTxt"><%=accountGroup[5] %></td>
                      <%}else{ %>
                       <td class="rightTxt">0.00</td>
                       <%} %>
                       
                        <%
                              if(accountGroup[4] != null && ((BigDecimal)accountGroup[4]).compareTo(new BigDecimal(0)) > 0){
                      %>
                       <td class="rightTxt"><%=accountGroup[4]%></td>
                       <%}else{ %>
                       <td class="rightTxt">0.00</td>
                       <%} %>
                       
                       <%
                              if(accountGroup[3] != null && ((BigDecimal)accountGroup[3]).compareTo(new BigDecimal(0)) > 0){
                      %>
                       <td class="rightTxt"><%=accountGroup[3]%></td>
                       <%}else{ %>
                       <td class="rightTxt">0.00</td>
                       <%} %>
                       
                       <%
                       if(accountGroup[9] != null && ((BigDecimal)accountGroup[9]).compareTo(new BigDecimal(0)) > 0){
                      %>
                       <td class="rightTxt"><%=accountGroup[9]%></td>
                       <%}else{ %>
                       <td class="rightTxt">0.00</td>
                       <%} %>
                       
                       <%
                              if(accountGroup[10] != null && ((BigDecimal)accountGroup[10]).compareTo(new BigDecimal(0)) > 0){
                      %>
                       <td class="rightTxt"><%=accountGroup[10]%></td>
                       <%}else{ %>
                       <td class="rightTxt">0.00</td>
                       <%} %>

               </tr>
               <%
                           } %>
       </tbody>
</table>
<div class="clear"></div>
<%}else{ %>
<div class="clear"></div>
<h4>No Record found!</h4>

<%} %>
<input type="button" name="Back" value="Back" class="button" onclick="submitForm('faAccountGroup','account?method=showAccountsGroupMasterJsp')" tabindex=1 />



<div class="paddingTop40"></div>
<script>
               var pager = new Pager('tableData',10);
               pager.init();
               pager.showPageNav('pager', 'pageNavPosition');
               pager.showPage(1);
         </script> <script>



</script><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
