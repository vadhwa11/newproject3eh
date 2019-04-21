<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigDecimal"%>

<%@page import="jkt.hms.masters.business.FaMasAccount"%><script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<form name="balanceSheet" method="post" action="">

<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<FaMasAccount> currentFinancialYearAccountList = new ArrayList<FaMasAccount>();
	List<FaMasAccount> lastFinancialYearAccountList = new ArrayList<FaMasAccount>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	String lastYearDesc = "";
	String currentYearDesc = "";
	String hospitalName="";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if(map.get("currentFinancialYearAccountList") != null){
		currentFinancialYearAccountList = (List<FaMasAccount>)map.get("currentFinancialYearAccountList");
	}
	if(map.get("lastFinancialYearAccountList") != null){
		lastFinancialYearAccountList = (List<FaMasAccount>)map.get("lastFinancialYearAccountList");
	}
	if(map.get("lastYearDesc") != null){
		lastYearDesc = (String)map.get("lastYearDesc");
	}
	if(map.get("currentYearDesc") != null){
		currentYearDesc = (String)map.get("currentYearDesc");
	}
	if(session.getAttribute("hospitalName")!=null ){
		hospitalName=(String)session.getAttribute("hospitalName");
	}
	String date1=date.substring(3, 5);
	System.out.println("date1------------>>>"+date1);
	String monthName="";
	monthName=HMSUtil.getMonthName(date1);
	String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");
		%>
<h4><span><%=message %></span></h4>
	<%}
%>
<div class="clear"></div>
<div class="titleBg">
<h2>Balance Sheet</h2>
</div>
<div class="Block">
<div class="clear"></div>
<div class="clear"></div><div class="clear"></div>
<div  align="center" style="font-weight: bold;">NATIONAL HEALTH MISSION</div>
<div class="clear"></div>
<div class="clear"></div>
<div  align="center" style="font-weight: bold;">Statement of Expenditure for the month of: <%=monthName %> <%=date.substring(6, 10) %></div>
<div class="clear"></div>
<div class="clear"></div>
<div  align="center" style="font-weight: bold;"><%=hospitalName %></div>

<div class="clear"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<table>
<tr>
		<th >Liabilities</th>
		<th >Sch.Ref.</th>
		<th >Current Yr. At 31-03-16</th>
		<th >Previous Yr.At 31-03-15</th>
		<th >Asset</th>
		<th >Sch.Ref.</th>
		<th >Current Yr. At 31-03-16</th>
		<th >Previous Yr.At 31-03-15</th>
	</tr>
	<%
	//------------------------------------for current Year Balance-----------------------------------------------------//
	BigDecimal currentCrBalance3 = new BigDecimal(0.00);
	BigDecimal currentDrBalance3 = new BigDecimal(0.00);
	BigDecimal currentCrBalance4 = new BigDecimal(0.00);
	BigDecimal currentDrBalance4 = new BigDecimal(0.00);
	BigDecimal currentCrBalance5 = new BigDecimal(0.00);
	BigDecimal currentDrBalance5 = new BigDecimal(0.00);
	BigDecimal currentCrBalance6 = new BigDecimal(0.00);
	BigDecimal currentDrBalance6 = new BigDecimal(0.00);
	BigDecimal currentCrBalance7 = new BigDecimal(0.00);
	BigDecimal currentDrBalance7 = new BigDecimal(0.00);
	BigDecimal currentCrBalance8 = new BigDecimal(0.00);
	BigDecimal currentDrBalance8 = new BigDecimal(0.00);
	BigDecimal currentCrBalance9 = new BigDecimal(0.00);
	BigDecimal currentDrBalance9 = new BigDecimal(0.00);
	BigDecimal currentCrBalance10 = new BigDecimal(0.00);
	BigDecimal currentDrBalance10 = new BigDecimal(0.00);
	BigDecimal currentCrBalance11 = new BigDecimal(0.00);
	BigDecimal currentDrBalance11 = new BigDecimal(0.00);
	BigDecimal currentCrBalance12 = new BigDecimal(0.00);
	BigDecimal currentDrBalance12 = new BigDecimal(0.00);
	BigDecimal currentCrBalance13 = new BigDecimal(0.00);
	BigDecimal currentDrBalance13 = new BigDecimal(0.00);
	BigDecimal currentCrBalance14 = new BigDecimal(0.00);
	BigDecimal currentDrBalance14 = new BigDecimal(0.00);
	BigDecimal currentCrBalance15 = new BigDecimal(0.00);
	BigDecimal currentDrBalance15 = new BigDecimal(0.00);
	BigDecimal currentCrBalance16 = new BigDecimal(0.00);
	BigDecimal currentDrBalance16 = new BigDecimal(0.00);
	BigDecimal currentCrBalance17 = new BigDecimal(0.00);
	BigDecimal currentDrBalance17 = new BigDecimal(0.00);
	BigDecimal currentSchedule3Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule4Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule5Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule6Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule7Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule8Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule9Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule10Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule11Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule12Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule13Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule14Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule15Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule16Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule17Amt = new BigDecimal(0.00);
	
	if(currentFinancialYearAccountList.size()>0){
		for(FaMasAccount masAccount : currentFinancialYearAccountList){
			if(!masAccount.getScheduleCr().getScheduleNo().equals("0") ){
			if(masAccount.getScheduleCr().getScheduleNo().equals("0")){
				if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
					currentCrBalance3 =currentCrBalance3.add(masAccount.getClBalanceCr());
				}
				if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
					currentDrBalance3 =currentDrBalance3.add(masAccount.getClBalanceDr());
				}
				if(currentCrBalance3.compareTo(currentDrBalance3)>0){
					currentSchedule3Amt = currentCrBalance3.subtract(currentDrBalance3);
				}else if(currentDrBalance3.compareTo(currentCrBalance3)>0){
					currentSchedule3Amt = currentDrBalance3.subtract(currentCrBalance3);
				}else if(currentDrBalance3.compareTo(currentCrBalance3)==0){
					currentSchedule3Amt =new BigDecimal(0.00);
				}
			}
			if(masAccount.getScheduleCr().getScheduleNo().equals("4")){
				if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
					currentCrBalance4 =currentCrBalance4.add(masAccount.getClBalanceCr());
				}
				if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
					currentDrBalance4 =currentDrBalance4.add(masAccount.getClBalanceDr());
				}
				if(currentCrBalance4.compareTo(currentDrBalance4)>0){
					currentSchedule4Amt = currentCrBalance4.subtract(currentDrBalance4);
				}else if(currentDrBalance4.compareTo(currentCrBalance4)>0){
					currentSchedule4Amt = currentDrBalance4.subtract(currentCrBalance4);
				}else if(currentDrBalance4.compareTo(currentCrBalance4)==0){
					currentSchedule4Amt =new BigDecimal(0.00);
				}
			}
			if(masAccount.getScheduleCr().getScheduleNo().equals("5")){
				if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
					currentCrBalance5 =currentCrBalance5.add(masAccount.getClBalanceCr());
				}
				if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
					currentCrBalance5 =currentCrBalance5.add(masAccount.getClBalanceDr());
				}
				if(currentCrBalance5.compareTo(currentDrBalance5)>0){
					currentSchedule5Amt = currentCrBalance5.subtract(currentDrBalance5);
				}else if(currentDrBalance5.compareTo(currentCrBalance4)>0){
					currentSchedule5Amt = currentDrBalance5.subtract(currentCrBalance5);
				}else if(currentDrBalance5.compareTo(currentCrBalance5)==0){
					currentSchedule5Amt =new BigDecimal(0.00);
				}
			}
			if(masAccount.getScheduleCr().getScheduleNo().equals("6")){
				if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
					currentCrBalance6 =currentCrBalance6.add(masAccount.getClBalanceCr());
				}
				if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
					currentDrBalance6 =currentDrBalance6.add(masAccount.getClBalanceDr());
				}
				if(currentCrBalance6.compareTo(currentDrBalance6)>0){
					currentSchedule6Amt = currentCrBalance6.subtract(currentDrBalance6);
				}else if(currentDrBalance6.compareTo(currentCrBalance6)>0){
					currentSchedule6Amt = currentDrBalance6.subtract(currentCrBalance6);
				}else if(currentDrBalance6.compareTo(currentCrBalance6)==0){
					currentSchedule6Amt =new BigDecimal(0.00);
				}
			}
			if(masAccount.getScheduleCr().getScheduleNo().equals("7")){
				if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
					currentCrBalance7 =currentCrBalance7.add(masAccount.getClBalanceCr());
				}
				if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
					currentDrBalance7 =currentDrBalance7.add(masAccount.getClBalanceDr());
				}
				if(currentCrBalance7.compareTo(currentDrBalance7)>0){
					currentSchedule7Amt = currentCrBalance7.subtract(currentDrBalance7);
				}else if(currentDrBalance7.compareTo(currentCrBalance7)>0){
					currentSchedule7Amt = currentDrBalance7.subtract(currentCrBalance7);
				}else if(currentDrBalance7.compareTo(currentCrBalance7)==0){
					currentSchedule7Amt =new BigDecimal(0.00);
				}
			}
			if(masAccount.getScheduleCr().getScheduleNo().equals("8")){
				if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
					currentCrBalance8 =currentCrBalance8.add(masAccount.getClBalanceCr());
				}
				if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
					currentDrBalance8 =currentDrBalance8.add(masAccount.getClBalanceDr());
				}
				if(currentCrBalance8.compareTo(currentDrBalance8)>0){
					currentSchedule8Amt = currentCrBalance8.subtract(currentDrBalance8);
				}else if(currentDrBalance8.compareTo(currentCrBalance8)>0){
					currentSchedule8Amt = currentDrBalance8.subtract(currentCrBalance8);
				}else if(currentDrBalance8.compareTo(currentCrBalance8)==0){
					currentSchedule8Amt =new BigDecimal(0.00);
				}
			}
			if(masAccount.getScheduleCr().getScheduleNo().equals("9")){
				if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
					currentCrBalance9 =currentCrBalance9.add(masAccount.getClBalanceCr());
				}
				if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
					currentDrBalance9 =currentDrBalance9.add(masAccount.getClBalanceDr());
				}
				if(currentCrBalance9.compareTo(currentDrBalance9)>0){
					currentSchedule9Amt = currentCrBalance9.subtract(currentDrBalance9);
				}else if(currentDrBalance9.compareTo(currentCrBalance9)>0){
					currentSchedule9Amt = currentDrBalance9.subtract(currentCrBalance9);
				}else if(currentDrBalance9.compareTo(currentCrBalance9)==0){
					currentSchedule9Amt =new BigDecimal(0.00);
				}
			}
			
		if(masAccount.getScheduleCr().getScheduleNo().equals("10")){
			if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
				currentCrBalance10 =currentCrBalance10.add(masAccount.getClBalanceCr());
			}
			if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
				currentDrBalance10 =currentDrBalance10.add(masAccount.getClBalanceDr());
			}
			if(currentCrBalance10.compareTo(currentDrBalance10)>0){
				currentSchedule10Amt = currentCrBalance10.subtract(currentDrBalance10);
			}else if(currentDrBalance10.compareTo(currentCrBalance10)>0){
				currentSchedule10Amt = currentDrBalance10.subtract(currentCrBalance10);
			}else if(currentDrBalance10.compareTo(currentCrBalance10)==0){
				currentSchedule10Amt =new BigDecimal(0.00);
			}
		}
		if(masAccount.getScheduleCr().getScheduleNo().equals("11")){
			if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
				currentCrBalance11 =currentCrBalance11.add(masAccount.getClBalanceCr());
			}
			if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
				currentDrBalance11 =currentDrBalance11.add(masAccount.getClBalanceDr());
			}
			if(currentCrBalance11.compareTo(currentDrBalance11)>0){
				currentSchedule11Amt = currentCrBalance11.subtract(currentDrBalance11);
			}else if(currentDrBalance11.compareTo(currentCrBalance11)>0){
				currentSchedule11Amt = currentDrBalance11.subtract(currentCrBalance11);
			}else if(currentDrBalance11.compareTo(currentCrBalance11)==0){
				currentSchedule11Amt =new BigDecimal(0.00);
			}
		}
		
		if(masAccount.getScheduleCr().getScheduleNo().equals("12")){
			if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
				currentCrBalance12 =currentCrBalance12.add(masAccount.getClBalanceCr());
			}
			if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
				currentDrBalance12 =currentDrBalance12.add(masAccount.getClBalanceDr());
			}
			if(currentCrBalance12.compareTo(currentDrBalance12)>0){
				currentSchedule12Amt = currentCrBalance12.subtract(currentDrBalance12);
			}else if(currentDrBalance12.compareTo(currentCrBalance12)>0){
				currentSchedule12Amt = currentDrBalance12.subtract(currentCrBalance12);
			}else if(currentDrBalance12.compareTo(currentCrBalance12)==0){
				currentSchedule12Amt =new BigDecimal(0.00);
			}
		}
		
		if(masAccount.getScheduleCr().getScheduleNo().equals("13")){
			if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
				currentCrBalance13 =currentCrBalance13.add(masAccount.getClBalanceCr());
			}
			if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
				currentDrBalance13 =currentDrBalance13.add(masAccount.getClBalanceDr());
			}
			if(currentCrBalance13.compareTo(currentDrBalance13)>0){
				currentSchedule13Amt = currentCrBalance13.subtract(currentDrBalance13);
			}else if(currentDrBalance13.compareTo(currentCrBalance13)>0){
				currentSchedule13Amt = currentDrBalance13.subtract(currentCrBalance13);
			}else if(currentDrBalance13.compareTo(currentCrBalance13)==0){
				currentSchedule13Amt =new BigDecimal(0.00);
			}
		}
		
		if(masAccount.getScheduleCr().getScheduleNo().equals("14")){
			if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
				currentCrBalance14 =currentCrBalance14.add(masAccount.getClBalanceCr());
			}
			if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
				currentDrBalance14 =currentDrBalance14.add(masAccount.getClBalanceDr());
			}
			if(currentCrBalance14.compareTo(currentDrBalance14)>0){
				currentSchedule14Amt = currentCrBalance14.subtract(currentDrBalance14);
			}else if(currentDrBalance14.compareTo(currentCrBalance14)>0){
				currentSchedule14Amt = currentDrBalance14.subtract(currentCrBalance14);
			}else if(currentDrBalance14.compareTo(currentCrBalance14)==0){
				currentSchedule14Amt =new BigDecimal(0.00);
			}
		}
		if(masAccount.getScheduleCr().getScheduleNo().equals("15")){
			if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
				currentCrBalance15 =currentCrBalance15.add(masAccount.getClBalanceCr());
			}
			if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
				currentDrBalance15 =currentDrBalance15.add(masAccount.getClBalanceDr());
			}
			if(currentCrBalance15.compareTo(currentDrBalance15)>0){
				currentSchedule15Amt = currentCrBalance15.subtract(currentDrBalance15);
			}else if(currentDrBalance15.compareTo(currentCrBalance15)>0){
				currentSchedule15Amt = currentDrBalance15.subtract(currentCrBalance15);
			}else if(currentDrBalance15.compareTo(currentCrBalance15)==0){
				currentSchedule15Amt =new BigDecimal(0.00);
			}
		}
		
		if(masAccount.getScheduleCr().getScheduleNo().equals("16")){
			if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
				currentCrBalance16 =currentCrBalance16.add(masAccount.getClBalanceCr());
			}
			if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
				currentDrBalance16 =currentDrBalance16.add(masAccount.getClBalanceDr());
			}
			if(currentCrBalance16.compareTo(currentDrBalance16)>0){
				currentSchedule16Amt = currentCrBalance16.subtract(currentDrBalance16);
			}else if(currentDrBalance16.compareTo(currentCrBalance16)>0){
				currentSchedule16Amt = currentDrBalance16.subtract(currentCrBalance16);
			}else if(currentDrBalance16.compareTo(currentCrBalance16)==0){
				currentSchedule16Amt =new BigDecimal(0.00);
			}
		}
		
		if(masAccount.getScheduleCr().getScheduleNo().equals("17")){
			if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
				currentCrBalance17 =currentCrBalance17.add(masAccount.getClBalanceCr());
			}
			if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
				currentDrBalance17 =currentDrBalance17.add(masAccount.getClBalanceDr());
			}
			if(currentCrBalance17.compareTo(currentDrBalance17)>0){
				currentSchedule17Amt = currentCrBalance17.subtract(currentDrBalance17);
			}else if(currentDrBalance17.compareTo(currentCrBalance17)>0){
				currentSchedule17Amt = currentDrBalance17.subtract(currentCrBalance17);
			}else if(currentDrBalance17.compareTo(currentCrBalance17)==0){
				currentSchedule17Amt =new BigDecimal(0.00);
			}
		}
		
		
		}
	}
}
	
%>
<tr>
<td><h2>Reserve & Surplus</td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
</tr>
	<tr>	
	<td>Opening Balance (Surplus)</td>
	<td>IX</td>
	<td></td>
	<td></td>
	<td>Fixed Asset</td>
	<td>II-A</td>
	<td></td>
	<td></td>	
	</tr>	
	<tr>
	<td>Add/Less: Surplus/Deficit for the year</td>
	<td>IX</td>
	<td>Total</td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	<tr>
<td><h2>Unspent Grant</h2></td>
	<td></td>
	<td></td>
	<td></td>
	<td><h2>Loans and Advances</h2></td>
	<td></td>
	<td></td>
	<td></td>
</tr>
	<tr onclick ="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=3&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Share Capital')">
	<td>RCH-I</td>
	<td>I-A</td>
	<%if(currentSchedule3Amt!=null && !currentSchedule3Amt.equals(new BigDecimal(0.00))){ %>
	<td><%=currentSchedule3Amt %></td>
	<%}else{ %>
	<td></td>
	<%} %>
	<td></td>
	<td>Advance RCH-I</td>
	<td>IV-A</td>
	<td></td>
	<td></td>
	</tr>
	<tr onclick ="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=4&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Reserves and surplus')">
	<td>RCH Flexipool</td>
	<td>I-B</td>
	<%BigDecimal currentshareHoldersAmt = currentSchedule3Amt.add(currentSchedule4Amt); %>
	<td></td>
	<td></td>
	<td>Advances- RCH Flexipool</td>
	<td></td>
	<td></td>
	<td></td>
	</tr>	
	<tr>
	<td>NRHM Additionalities</td>
	<td>I-C</td>
	<td></td>
	<td></td>
	<td>Advances- RI Strenthening</td>
	<td></td>
	<td></td>
	<td></td>
	</tr>	
	<tr>
	<td>RI Strenthening Project</td>
	<td>I-D</td>
	<td></td>
	<td></td>
	<td>Advances- PPI</td>
	<td>IV-B</td>
	<td></td>
	<td></td>
	</tr>	
	<tr onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=5&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Other Long term liabilities')">
	<td>Pulse Polio (PPI)</td>
	<td>I-D</td>
	<%if(currentSchedule5Amt!=null && !currentSchedule5Amt.equals(new BigDecimal(0.00))){ %>
	<td><%=currentSchedule5Amt %></td>
	<%}else{ %>
	<td></td>
	<%} %>
	<td></td>
	<td>Advances- NRHM Additionalities</td>
	<td>IV-C</td>
	<td></td>
	<td></td>
	</tr>
	<tr onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=6&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Long-term provisions')">
	<td>EC SIP</td>
	<td>I-E</td>
	<% BigDecimal nonCurrentLiabilities =  currentSchedule5Amt.add(currentSchedule6Amt); %>
	<td></td>
	<td></td>
<td></td>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	<tr>
	<td>TB Programme(As per CTB Division)</td>
	<td>I-F</td>
	<td></td>
	<td></td>
	<td>Advances- TB Programme </td>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	<tr onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=7&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Short-term borrowings')">
	<td>Malaria</td>
	<td>I-G</td>
	<%if(currentSchedule7Amt!=null && !currentSchedule7Amt.equals(new BigDecimal(0.00))){ %>
	<td><%=currentSchedule7Amt %></td>
	<%}else{ %>
	<td></td>
	<%} %>
	<td></td>
	<td>Advances- Malaria</td>
	<td>IV-D</td>
	<td></td>
	<td></td>
	</tr>
	<tr onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=8&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Trade payables')">
	<td>Iodine Deficiency</td>
	<td>I-H</td>
	<%if(currentSchedule8Amt!=null && !currentSchedule8Amt.equals(new BigDecimal(0.00))){ %>
	<td><%=currentSchedule8Amt %></td>
	<%}else{ %>
	<td></td>
	<%} %>
	<td></td>
	<td>Advances- Iodine Deficiency</td>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	<tr onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=9&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Other current liabilities')">
	<td>Blindness Control</td>
	<td>I-I</td>
	<%if(currentSchedule9Amt!=null && !currentSchedule9Amt.equals(new BigDecimal(0.00))){ %>
	<td><%=currentSchedule9Amt %></td>
	<%}else{ %>
	<td></td>
	<%} %>
	<td></td>
	<td>Advances- Blindness</td>
	<td>IV-E</td>
	<td></td>
	<td></td>
	</tr>
	<tr onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=10&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Short-term provisions')">
	<td>IDSP</td>
	<td>I-J</td>
	<%BigDecimal currentLiabilities =currentSchedule7Amt.add(currentSchedule8Amt).add(currentSchedule9Amt).add(currentSchedule10Amt);   %>
	<td></td>
	<td></td>
	<td>Advances- IDSP</td>
	<td>IV-E</td>
	<td></td>
	<td></td>
	</tr>
	<tr onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=10&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Short-term provisions')">
	<td>Leprosy</td>
	<td>I-K</td>
	<td></td>
	<td></td>
	<td>Advances- Leprosy</td>
	<td>IV-E</td>
	<td></td>
	<td></td>
	</tr>	
	<tr>
	<td><h2>TOTAL</h2></td>
	<td></td>
	<td><%=currentshareHoldersAmt.add(nonCurrentLiabilities).add(currentLiabilities) %></td>
	<td></td>
	<td>Advances- Staff</td>
	<td>IV-F</td>
	<td></td>
	<td></td
	</tr>
	<tr>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td>Advances- Others</td>
	<td>IV-G</td>
	<td></td>
	<td></td
	</tr>
	<tr>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td><h2>TOTAL</h2></td>
	<td>&nbsp;</td>
	<td></td>
	<td></td
	</tr><%--<tr>
	<td>ASSETS</td>
	<td></td>
	<td></td>
	<td></td>
	</tr>	
	<tr>
	<td>Non-current assets</td>
	<td></td>
	<td></td>
	<td></td>
	</tr>	
	<tr onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=11&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Fixed assets')">
	<td>Fixed assets</td>
	<td>11</td>
	<td><%=currentSchedule11Amt %></td>
	<td></td>
	</tr>
	<tr>
	<td>Tangible assets</td>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	<tr>
	<td>Intangible assets</td>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	<tr>
	<td>Capital work-in-progress</td>
	<td></td>
	<td></td>
	<td></td>
	</tr>	
	<tr onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=12&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Long-term loans and advances')">
	<td> Long-term loans and advances</td>
	<td>12</td>
	<td><%=currentSchedule12Amt %></td>
	<td></td>
	</tr>	
	<tr>
	<td>Current assets</td>
	<td></td>
	<td></td>
	<td></td>
	</tr>	
	<tr onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=13&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Inventories')">
	<td>Inventories</td>
	<td>13</td>
	<td><%=currentSchedule13Amt %></td>
	<td></td>
	</tr>	
	<tr onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=14&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Trade receivables')">
	<td>Trade receivables</td>
	<td>14</td>
	<td><%=currentSchedule14Amt %></td>
	<td></td>
	</tr>	
	<tr onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=15&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Cash and bank balances')">
	<td>Cash and bank balances</td>
	<td>15</td>
	<td><%=currentSchedule15Amt %></td>
	<td></td>
	</tr>
	<tr onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=16&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Short-term loans and advances')">
	<td>Short-term loans and advances</td>
	<td>16</td>
	<td><%=currentSchedule16Amt %></td>
	<td></td>
	</tr>
	<tr onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=17&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Other current assets')">
	<td>Other current assets</td>
	<td>17</td>
	<%BigDecimal currentAssets =currentSchedule13Amt.add(currentSchedule14Amt).add(currentSchedule15Amt).add(currentSchedule16Amt).add(currentSchedule17Amt);   %>
	<td><%=currentSchedule17Amt+"  -------------------  "+currentAssets %></td>
	<td></td>
	</tr>	
	<tr>
	<td>Total</td>
	<td></td>
	<td><%=currentSchedule11Amt.add(currentSchedule12Amt).add(currentAssets)%></td>
	<td></td>
	</tr> --%>

</table>
<div class="clear"></div>
<div class="paddingTop15"></div>
<input type="button" class="buttonBig" value="Export To Excel" onclick="submitForm('balanceSheet','account?method=generateBalanceSheetJsp');"/>
<div class="clear"></div>
<div class="clear"></div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
