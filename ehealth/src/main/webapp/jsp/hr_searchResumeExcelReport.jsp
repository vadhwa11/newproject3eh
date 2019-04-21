<html> 

<%@page
	import="java.util.Map,java.util.List,java.util.Iterator,jkt.hrms.recruitment.masters.business.* "%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page contentType="application/vnd.ms-excel"%>
<%response.setHeader("context-Disposition","attachment;filename=SkillReport.xls");%>
<head>
<title>Excel Report For Search Resumes</title>
</head>
<body>
<form name="searchResults" action="" method="post">
<%Map map = null;
	List skillList = null;
	List statusMasterList=null;
	List excelResumeList=null;
	Iterator statusMasterIterator=null;
	String name = "";
	String status = "";
	String owner = "";
	String experience ="";
	String location = "";
	int skillId=0;
	int counter = 0;
	String primarySkills = "";
	String concatPrimarySkills = "";
	if(session.getAttribute("searchResumeResultMap")!=null)
	{
		map=(Map)session.getAttribute("searchResumeResultMap");
		excelResumeList=(List)map.get("excelResumeList");
		skillList = (List)map.get("skillList");
		statusMasterList=(List) map.get("statusMasterList");
	}
	if(excelResumeList.size()>=1)
	{%>
<table width="575" align="left" border="1">
	<thead>
		<tr>
			<td>Resume Id</td>
			<td>Candidate's Name</td>
			<td>Present Location</td>
			<td>Years Of Experience</td>
			<td>Primary Skills</td>
			<td>Status</td>
			<td>Owner</td>
		</tr>
	</thead>
	<tbody id="searchresulttable">
		<%int resumeStatusId=0;
			int counterBgColor = 0;
			for(Iterator searchListIterator = excelResumeList.iterator(); searchListIterator.hasNext();)
			{
				Resumepersonaldetails resumepersonaldetails = (Resumepersonaldetails) searchListIterator.next();
			 	Integer currentResumeID =  resumepersonaldetails.getId();
				name = resumepersonaldetails.getFirstName()+" "+resumepersonaldetails.getMiddleName()+" "+resumepersonaldetails.getLastName();
				location = resumepersonaldetails.getCity().getDistrictName();
				experience = resumepersonaldetails.getExperienceYear()+"."+resumepersonaldetails.getExperienceMonth();
				owner = resumepersonaldetails.getAddResumeBy().getUserName();
			 	statusMasterIterator = statusMasterList.iterator();
			 	while(statusMasterIterator.hasNext())
	 			{
	 				Resumestatusmaster resumeStatusMaster=(Resumestatusmaster)statusMasterIterator.next();
	 				int resumeStatusMasterId=resumeStatusMaster.getId();
	 				resumeStatusId=resumepersonaldetails.getResumeStatus().getStatusId();
	 				if(resumeStatusMasterId == resumeStatusId)
	 				{
	 					 status = resumeStatusMaster.getStatusDesc();
	 					 break;
	 				}
		 		}
			 	primarySkills = "";
				for (Iterator personalDetailsIterator = resumepersonaldetails.getResumeSkill().iterator(); personalDetailsIterator.hasNext();) 
				{
					Resumeskill resumeskill = (Resumeskill) personalDetailsIterator.next();
					if(resumeskill.getSkillType().equals("Primary"))
					{
						skillId = resumeskill.getSkillId();
					 	for(Iterator iter1=skillList.iterator(); iter1.hasNext();)
					 	{
					 		Resumeskillmaster skillMaster = (Resumeskillmaster)iter1.next();
					 		if(skillId == skillMaster.getId())
					 		{
					 			concatPrimarySkills = primarySkills.concat(skillMaster.getSkillDesc()).concat(",");
					 			primarySkills = concatPrimarySkills;
					 		}
					 		}
					 	}
					}
					primarySkills = primarySkills.substring(0,primarySkills.length() - 1);
					Resumeremarks resumeRemarks=null;
        			for (Iterator iter = resumepersonaldetails.getResumeRemarks().iterator(); iter.hasNext();) {
            			resumeRemarks = (Resumeremarks)iter.next();
        			}
        			String remarks="";
        			String fullRemarks="";
        			if(resumeRemarks.getRemarks().length()>20)
        			{
        				remarks = remarks.concat(resumeRemarks.getRemarks().substring(0,20));
        				remarks = remarks.concat("...");
        			}
        			else
        				remarks = remarks.concat(resumeRemarks.getRemarks());
        			fullRemarks =fullRemarks.concat(resumeRemarks.getRemarks());
        			fullRemarks = fullRemarks.concat("\n\n");
        			fullRemarks = fullRemarks.concat("Added By: ");
        			fullRemarks = fullRemarks.concat(resumeRemarks.getRemarksBy());
        			fullRemarks = fullRemarks.concat("\n");
        			fullRemarks = fullRemarks.concat("Added On: ");
        			fullRemarks = fullRemarks.concat(HMSUtil.convertDateToStringTypeDate(resumeRemarks.getDateRemarks()));
					counterBgColor++;
					String class1 = "";
					if(!status.equals("Blacklisted"))
					{
						if(counterBgColor %2 == 0)
						{
							class1 = "even";
						}
						else
						{
							class1="odd";
						}
					}else{
				 		class1="black";
					}%>
		<tr class="<%=class1%>">
			<td
				onclick="location.href='/jktintranet/jkt/resume?method=viewResume&resumeID=<%=currentResumeID%>'"><%=currentResumeID%></td>
			<td
				onclick="location.href='/jktintranet/jkt/resume?method=viewResume&resumeID=<%=currentResumeID%>'"><a><%=name%></a></td>
			<td
				onclick="location.href='/jktintranet/jkt/resume?method=viewResume&resumeID=<%=currentResumeID%>'"><%=location%></td>
			<td
				onclick="location.href='/jktintranet/jkt/resume?method=viewResume&resumeID=<%=currentResumeID%>'"><%=experience%></td>
			<td
				onclick="location.href='/jktintranet/jkt/resume?method=viewResume&resumeID=<%=currentResumeID%>'"><%=primarySkills%></td>
			<td
				onclick="location.href='/jktintranet/jkt/resume?method=viewResume&resumeID=<%=currentResumeID%>'"><%=status%></td>
			<td
				onclick="location.href='/jktintranet/jkt/resume?method=viewResume&resumeID=<%=currentResumeID%>'"><%=owner%></td>
		</tr>
		<% ++counter;	}
			  }%>
	</tbody>
</table>
<br />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</body>
</html>