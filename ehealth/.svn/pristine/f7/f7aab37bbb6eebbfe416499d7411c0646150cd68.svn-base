<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgFixedValue"%>
<%@page import="java.net.URL"%>


<%
	String[] orderStatusMsg = null;
	List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
	List<Map<String, Object>> resultDetailsMapList = new ArrayList<Map<String, Object>>();

	int initialHieght = 22;
	int mapIndex = 0;
	Map<String, Object> jspMap = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		jspMap = (Map) request.getAttribute("map");
	}

	if (jspMap.get("orderStatusMsg") != null) {
		orderStatusMsg = (String[]) jspMap.get("orderStatusMsg");
	}
	if (jspMap.get("resultDetailsMapList") != null) {
		resultDetailsMapList = (List) jspMap
				.get("resultDetailsMapList");
	}
	if (request.getParameter("mapIndex") != null) {
		mapIndex = Integer.parseInt(request.getParameter("mapIndex"));
	}
	Map<String, Object> multipleResultMap = resultDetailsMapList
			.get(mapIndex);

	List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
	if (multipleResultMap.get("dgResultdetailList") != null) {
		dgResultdetailList = (List<DgResultEntryDetail>) multipleResultMap
				.get("dgResultdetailList");
	}
	if (dgResultdetailList.size() > 0) {
		initialHieght = initialHieght + dgResultdetailList.size() * 27;
	}
	List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
	try {
		if (multipleResultMap.get("fixedValList") != null) {
			fixedValList = (List) multipleResultMap.get("fixedValList");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	try {
		if (multipleResultMap.get("resultList") != null) {
			resultList = (List) multipleResultMap.get("resultList");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

	DgResultEntryHeader dgResultEntryHeaderForReport = new DgResultEntryHeader();
	if (resultList != null && resultList.size() > 0) {
		dgResultEntryHeaderForReport = (DgResultEntryHeader) resultList
				.get(0);
	}
%>
<%@page import="java.text.DecimalFormat"%>
<br />



<div class="Clear"></div>
<div class="grid">
	<table width="100%" border="1" cellspacing="1" cellpadding="1">
		<tr>
			<th scope="col">S.No.</th>
			<th scope="col">Service</th>
			<th scope="col">Result</th>
			<th scope="col">UOM</th>
			<th scope="col">Normal Range</th>
		</tr>
		<%
			int i = 0;
			Set<DgNormalValue> normalSet = new HashSet<DgNormalValue>();
			for (DgResultEntryDetail dgDetail : dgResultdetailList) {
				System.out.println("Result Type ++++ "+dgDetail.getSubInvestigation().getResultType());
				System.out.println("Comprission Type ++++ "+dgDetail.getSubInvestigation().getComparisonType());
				System.out.println("Result  ++++ "+dgDetail.getResult());
		%><tr>
			<%
				i++;
					normalSet = dgDetail.getSubInvestigation().getDgNormalValues();
					if (dgDetail.getSubInvestigation().getResultType()
							.equalsIgnoreCase("s")
							&& dgDetail.getSubInvestigation().getComparisonType()
									.equalsIgnoreCase("v")) {
						if (dgResultEntryHeaderForReport.getHin().getSex()
								.getAdministrativeSexName()
								.equalsIgnoreCase("male")) {
							if (normalSet.size() > 0) {
								for (DgNormalValue nv : normalSet) {
									if (nv != null
											&& nv.getSex().equalsIgnoreCase("m")) {

										String investigationName = "-";
										if (dgDetail.getSubInvestigation() != null
												&& !"".equalsIgnoreCase(dgDetail
														.getSubInvestigation()
														.getSubInvestigationName())) {
											investigationName = dgDetail
													.getSubInvestigation()
													.getSubInvestigationName();

										}
										String resultDetail = "-";
										try {
											if (dgDetail.getResult() != null) {
												resultDetail=dgDetail.getResult() ;
											}
										} catch (Exception exception) {
											exception.printStackTrace();
										}

										String uomValue = "-";
										if (dgDetail.getUom() != null
												&& !"".equalsIgnoreCase(dgDetail
														.getUom().getUomName())) {
											uomValue = dgDetail.getUom()
													.getUomName();
										}

										String normalValue = "-";
										if (dgDetail.getNormal() != null) {

											if (dgDetail.getNormal()
													.getNormalValue() != null
													|| dgDetail.getNormal()
															.getMinNormalValue() != null
													|| dgDetail.getNormal()
															.getMaxNormalValue() != null) {

												if (dgDetail.getNormal()
														.getNormalValue() != null) {
													if (!dgDetail.getNormal()
															.getNormalValue()
															.equals("")) {
														normalValue = dgDetail
																.getNormal()
																.getNormalValue();

													} else if (dgDetail.getNormal()
															.getMinNormalValue() != null
															&& dgDetail
																	.getNormal()
																	.getMaxNormalValue() != null) {
														normalValue = dgDetail
																.getNormal()
																.getMinNormalValue()
																+ " - "
																+ dgDetail
																		.getNormal()
																		.getMaxNormalValue();

													}
												} else if (dgDetail.getNormal()
														.getMinNormalValue() != null
														&& dgDetail
																.getNormal()
																.getMaxNormalValue() != null) {
													normalValue = dgDetail
															.getNormal()
															.getMinNormalValue()
															+ " - "
															+ dgDetail
																	.getNormal()
																	.getMaxNormalValue();
												}
											}

										}
			%>
			<td><%=i%></td>
			<td><%=investigationName%></td>
			<td><%=resultDetail%></td>
			<td><%=uomValue%></td>
			<td><%=normalValue%></td>
			
			<%
				}
								}
							}
						}
					}
					normalSet = dgDetail.getSubInvestigation().getDgNormalValues();

					if (dgDetail.getSubInvestigation().getResultType()
							.equalsIgnoreCase("s")
							&& dgDetail.getSubInvestigation().getComparisonType()
									.equalsIgnoreCase("v")) {
						if (dgResultEntryHeaderForReport.getHin().getSex()
								.getAdministrativeSexName()
								.equalsIgnoreCase("female")) {

							if (normalSet.size() > 0) {
								for (DgNormalValue nv : normalSet) {
									if (nv != null
											&& nv.getSex().equalsIgnoreCase("f")) {

										String investigationName = "-";
										if (dgDetail.getSubInvestigation() != null
												&& !"".equalsIgnoreCase(dgDetail
														.getSubInvestigation()
														.getSubInvestigationName())) {
											investigationName = dgDetail
													.getSubInvestigation()
													.getSubInvestigationName();

										}
										String resultDetail = "-";
										try {
											if (dgDetail.getResult() != null) {
												resultDetail=dgDetail.getResult() ;
											}
										} catch (Exception exception) {
											exception.printStackTrace();
										}

										String uomValue = "-";
										if (dgDetail.getUom() != null
												&& !"".equalsIgnoreCase(dgDetail
														.getUom().getUomName())) {
											uomValue = dgDetail.getUom()
													.getUomName();
										}

										String normalValue = "-";
										if (dgDetail.getNormal() != null) {

											if (dgDetail.getNormal()
													.getNormalValue() != null
													|| dgDetail.getNormal()
															.getMinNormalValue() != null
													|| dgDetail.getNormal()
															.getMaxNormalValue() != null) {

												if (dgDetail.getNormal()
														.getNormalValue() != null) {
													if (!dgDetail.getNormal()
															.getNormalValue()
															.equals("")) {
														normalValue = dgDetail
																.getNormal()
																.getNormalValue();

													} else if (dgDetail.getNormal()
															.getMinNormalValue() != null
															&& dgDetail
																	.getNormal()
																	.getMaxNormalValue() != null) {
														normalValue = dgDetail
																.getNormal()
																.getMinNormalValue()
																+ " - "
																+ dgDetail
																		.getNormal()
																		.getMaxNormalValue();

													}
												} else if (dgDetail.getNormal()
														.getMinNormalValue() != null
														&& dgDetail
																.getNormal()
																.getMaxNormalValue() != null) {
													normalValue = dgDetail
															.getNormal()
															.getMinNormalValue()
															+ " - "
															+ dgDetail
																	.getNormal()
																	.getMaxNormalValue();
												}
											}

										}
			%>
			<td><%=i%></td>
			<td><%=investigationName%></td>
			<td><%=resultDetail%></td>
			<td><%=uomValue%></td>
			<td><%=normalValue%></td>
			
			<%
				}
								}
							}
						}
					}
					normalSet = dgDetail.getSubInvestigation().getDgNormalValues();

					if (dgDetail.getSubInvestigation().getResultType()
							.equalsIgnoreCase("s")
							&& dgDetail.getSubInvestigation().getComparisonType()
									.equalsIgnoreCase("v")) {
						if (dgResultEntryHeaderForReport.getHin().getSex()
								.getAdministrativeSexName()
								.equalsIgnoreCase("Not applicable")) {

							if (normalSet.size() > 0) {
								for (DgNormalValue nv : normalSet) {
									if (nv != null
											&& nv.getSex().equalsIgnoreCase("n")) {

										String investigationName = "-";
										if (dgDetail.getSubInvestigation() != null
												&& !"".equalsIgnoreCase(dgDetail
														.getSubInvestigation()
														.getSubInvestigationName())) {
											investigationName = dgDetail
													.getSubInvestigation()
													.getSubInvestigationName();

										}
										String resultDetail = "-";
										try {
											if (dgDetail.getResult() != null) {
												resultDetail=dgDetail.getResult() ;
											}
										} catch (Exception exception) {
											exception.printStackTrace();
										}

										String uomValue = "-";
										if (dgDetail.getUom() != null
												&& !"".equalsIgnoreCase(dgDetail
														.getUom().getUomName())) {
											uomValue = dgDetail.getUom()
													.getUomName();
										}

										String normalValue = "-";
										if (dgDetail.getNormal() != null) {

											if (dgDetail.getNormal()
													.getNormalValue() != null
													|| dgDetail.getNormal()
															.getMinNormalValue() != null
													|| dgDetail.getNormal()
															.getMaxNormalValue() != null) {

												if (dgDetail.getNormal()
														.getNormalValue() != null) {
													if (!dgDetail.getNormal()
															.getNormalValue()
															.equals("")) {
														normalValue = dgDetail
																.getNormal()
																.getNormalValue();

													} else if (dgDetail.getNormal()
															.getMinNormalValue() != null
															&& dgDetail
																	.getNormal()
																	.getMaxNormalValue() != null) {
														normalValue = dgDetail
																.getNormal()
																.getMinNormalValue()
																+ " - "
																+ dgDetail
																		.getNormal()
																		.getMaxNormalValue();

													}
												} else if (dgDetail.getNormal()
														.getMinNormalValue() != null
														&& dgDetail
																.getNormal()
																.getMaxNormalValue() != null) {
													normalValue = dgDetail
															.getNormal()
															.getMinNormalValue()
															+ " - "
															+ dgDetail
																	.getNormal()
																	.getMaxNormalValue();
												}
											}

										}
			%>
			<td><%=i%></td>
			<td><%=investigationName%></td>
			<td><%=resultDetail%></td>
			<td><%=uomValue%></td>
			<td><%=normalValue%></td>
			
			<%
				}
								}
							}
						}
					}
					normalSet = dgDetail.getSubInvestigation().getDgNormalValues();

					if (dgDetail.getSubInvestigation().getResultType()
							.equalsIgnoreCase("m")
							&& dgDetail.getSubInvestigation().getComparisonType()
									.equalsIgnoreCase("v")) {
						if (dgResultEntryHeaderForReport.getHin().getSex()
								.getAdministrativeSexName()
								.equalsIgnoreCase("male")) {

							if (normalSet.size() > 0) {
								for (DgNormalValue nv : normalSet) {
									if (nv != null
											&& nv.getSex().equalsIgnoreCase("n")) {

										String investigationName = "-";
										if (dgDetail.getSubInvestigation() != null
												&& !"".equalsIgnoreCase(dgDetail
														.getSubInvestigation()
														.getSubInvestigationName())) {
											investigationName = dgDetail
													.getSubInvestigation()
													.getSubInvestigationName();

										}
										String resultDetail = "-";
										try {
											if (dgDetail.getResult() != null) {
												resultDetail=dgDetail.getResult() ;
											}
										} catch (Exception exception) {
											exception.printStackTrace();
										}

										String uomValue = "-";
										if (dgDetail.getUom() != null
												&& !"".equalsIgnoreCase(dgDetail
														.getUom().getUomName())) {
											uomValue = dgDetail.getUom()
													.getUomName();
										}

										String normalValue = "-";
										if (dgDetail.getNormal() != null) {

											if (dgDetail.getNormal()
													.getNormalValue() != null
													|| dgDetail.getNormal()
															.getMinNormalValue() != null
													|| dgDetail.getNormal()
															.getMaxNormalValue() != null) {

												if (dgDetail.getNormal()
														.getNormalValue() != null) {
													if (!dgDetail.getNormal()
															.getNormalValue()
															.equals("")) {
														normalValue = dgDetail
																.getNormal()
																.getNormalValue();

													} else if (dgDetail.getNormal()
															.getMinNormalValue() != null
															&& dgDetail
																	.getNormal()
																	.getMaxNormalValue() != null) {
														normalValue = dgDetail
																.getNormal()
																.getMinNormalValue()
																+ " - "
																+ dgDetail
																		.getNormal()
																		.getMaxNormalValue();

													}
												} else if (dgDetail.getNormal()
														.getMinNormalValue() != null
														&& dgDetail
																.getNormal()
																.getMaxNormalValue() != null) {
													normalValue = dgDetail
															.getNormal()
															.getMinNormalValue()
															+ " - "
															+ dgDetail
																	.getNormal()
																	.getMaxNormalValue();
												}
											}

										}
			%>
			<td><%=i%></td>
			<td><%=investigationName%></td>
			<td><%=resultDetail%></td>
			<td><%=uomValue%></td>
			<td><%=normalValue%></td>
			
			<%
				}
								}
							}
						}
					}
					normalSet = dgDetail.getSubInvestigation().getDgNormalValues();
			%>
			<%
				if (dgDetail.getSubInvestigation().getResultType()
							.equalsIgnoreCase("m")
							&& dgDetail.getSubInvestigation().getComparisonType()
									.equalsIgnoreCase("v")) {
						if (dgResultEntryHeaderForReport.getHin().getSex()
								.getAdministrativeSexName()
								.equalsIgnoreCase("female")) {

							if (normalSet.size() > 0) {
								for (DgNormalValue nv : normalSet) {
									if (nv != null
											&& nv.getSex().equalsIgnoreCase("n")) {

										String investigationName = "-";
										if (dgDetail.getSubInvestigation() != null
												&& !"".equalsIgnoreCase(dgDetail
														.getSubInvestigation()
														.getSubInvestigationName())) {
											investigationName = dgDetail
													.getSubInvestigation()
													.getSubInvestigationName();

										}
										String resultDetail = "-";
										try {
											if (dgDetail.getResult() != null) {
												resultDetail=dgDetail.getResult() ;
											}
										} catch (Exception exception) {
											exception.printStackTrace();
										}

										String uomValue = "-";
										if (dgDetail.getUom() != null
												&& !"".equalsIgnoreCase(dgDetail
														.getUom().getUomName())) {
											uomValue = dgDetail.getUom()
													.getUomName();
										}

										String normalValue = "-";
										if (dgDetail.getNormal() != null) {

											if (dgDetail.getNormal()
													.getNormalValue() != null
													|| dgDetail.getNormal()
															.getMinNormalValue() != null
													|| dgDetail.getNormal()
															.getMaxNormalValue() != null) {

												if (dgDetail.getNormal()
														.getNormalValue() != null) {
													if (!dgDetail.getNormal()
															.getNormalValue()
															.equals("")) {
														normalValue = dgDetail
																.getNormal()
																.getNormalValue();

													} else if (dgDetail.getNormal()
															.getMinNormalValue() != null
															&& dgDetail
																	.getNormal()
																	.getMaxNormalValue() != null) {
														normalValue = dgDetail
																.getNormal()
																.getMinNormalValue()
																+ " - "
																+ dgDetail
																		.getNormal()
																		.getMaxNormalValue();

													}
												} else if (dgDetail.getNormal()
														.getMinNormalValue() != null
														&& dgDetail
																.getNormal()
																.getMaxNormalValue() != null) {
													normalValue = dgDetail
															.getNormal()
															.getMinNormalValue()
															+ " - "
															+ dgDetail
																	.getNormal()
																	.getMaxNormalValue();
												}
											}

										}
			%>
			<td><%=i%></td>
			<td><%=investigationName%></td>
			<td><%=resultDetail%></td>
			<td><%=uomValue%></td>
			<td><%=normalValue%></td>
			
			<%
				}
								}
							}
						}
					}
					normalSet = dgDetail.getSubInvestigation().getDgNormalValues();
			%>
			<%
				if (dgDetail.getSubInvestigation().getResultType()
							.equalsIgnoreCase("m")
							&& dgDetail.getSubInvestigation().getComparisonType()
									.equalsIgnoreCase("v")) {
						if (dgResultEntryHeaderForReport.getHin().getSex()
								.getAdministrativeSexName()
								.equalsIgnoreCase("Not applicable")) {

							if (normalSet.size() > 0) {
								for (DgNormalValue nv : normalSet) {
									if (nv != null
											&& nv.getSex().equalsIgnoreCase("n")) {

										String investigationName = "-";
										if (dgDetail.getSubInvestigation() != null
												&& !"".equalsIgnoreCase(dgDetail
														.getSubInvestigation()
														.getSubInvestigationName())) {
											investigationName = dgDetail
													.getSubInvestigation()
													.getSubInvestigationName();

										}
										String resultDetail = "-";
										try {
											if (dgDetail.getResult() != null) {
												resultDetail=dgDetail.getResult() ;
											}
										} catch (Exception exception) {
											exception.printStackTrace();
										}

										String uomValue = "-";
										if (dgDetail.getUom() != null
												&& !"".equalsIgnoreCase(dgDetail
														.getUom().getUomName())) {
											uomValue = dgDetail.getUom()
													.getUomName();
										}

										String normalValue = "-";
										if (dgDetail.getNormal() != null) {

											if (dgDetail.getNormal()
													.getNormalValue() != null
													|| dgDetail.getNormal()
															.getMinNormalValue() != null
													|| dgDetail.getNormal()
															.getMaxNormalValue() != null) {

												if (dgDetail.getNormal()
														.getNormalValue() != null) {
													if (!dgDetail.getNormal()
															.getNormalValue()
															.equals("")) {
														normalValue = dgDetail
																.getNormal()
																.getNormalValue();

													} else if (dgDetail.getNormal()
															.getMinNormalValue() != null
															&& dgDetail
																	.getNormal()
																	.getMaxNormalValue() != null) {
														normalValue = dgDetail
																.getNormal()
																.getMinNormalValue()
																+ " - "
																+ dgDetail
																		.getNormal()
																		.getMaxNormalValue();

													}
												} else if (dgDetail.getNormal()
														.getMinNormalValue() != null
														&& dgDetail
																.getNormal()
																.getMaxNormalValue() != null) {
													normalValue = dgDetail
															.getNormal()
															.getMinNormalValue()
															+ " - "
															+ dgDetail
																	.getNormal()
																	.getMaxNormalValue();
												}
											}

										}
			%>
			<td><%=i%></td>
			<td><%=investigationName%></td>
			<td><%=resultDetail%></td>
			<td><%=uomValue%></td>
			<td><%=normalValue%></td>
			
			<%
				}
								}
							}
						}
					}
					normalSet = dgDetail.getSubInvestigation().getDgNormalValues();
			%>
			<%
				if (dgDetail.getSubInvestigation().getResultType()
							.equalsIgnoreCase("t")
							&& dgDetail.getSubInvestigation().getComparisonType()
									.equalsIgnoreCase("v")) {
						if (dgResultEntryHeaderForReport.getHin().getSex()
								.getAdministrativeSexName()
								.equalsIgnoreCase("male")) {

							if (normalSet.size() > 0) {
								for (DgNormalValue nv : normalSet) {
									if (nv != null
											&& nv.getSex().equalsIgnoreCase("n")) {

										String investigationName = "-";
										if (dgDetail.getSubInvestigation() != null
												&& !"".equalsIgnoreCase(dgDetail
														.getSubInvestigation()
														.getSubInvestigationName())) {
											investigationName = dgDetail
													.getSubInvestigation()
													.getSubInvestigationName();

										}
										String resultDetail = "-";
										try {
											if (dgDetail.getResult() != null) {
												resultDetail=dgDetail.getResult() ;
											}
										} catch (Exception exception) {
											exception.printStackTrace();
										}

										String uomValue = "-";
										if (dgDetail.getUom() != null
												&& !"".equalsIgnoreCase(dgDetail
														.getUom().getUomName())) {
											uomValue = dgDetail.getUom()
													.getUomName();
										}

										String normalValue = "-";
										if (dgDetail.getNormal() != null) {

											if (dgDetail.getNormal()
													.getNormalValue() != null
													|| dgDetail.getNormal()
															.getMinNormalValue() != null
													|| dgDetail.getNormal()
															.getMaxNormalValue() != null) {

												if (dgDetail.getNormal()
														.getNormalValue() != null) {
													if (!dgDetail.getNormal()
															.getNormalValue()
															.equals("")) {
														normalValue = dgDetail
																.getNormal()
																.getNormalValue();

													} else if (dgDetail.getNormal()
															.getMinNormalValue() != null
															&& dgDetail
																	.getNormal()
																	.getMaxNormalValue() != null) {
														normalValue = dgDetail
																.getNormal()
																.getMinNormalValue()
																+ " - "
																+ dgDetail
																		.getNormal()
																		.getMaxNormalValue();

													}
												} else if (dgDetail.getNormal()
														.getMinNormalValue() != null
														&& dgDetail
																.getNormal()
																.getMaxNormalValue() != null) {
													normalValue = dgDetail
															.getNormal()
															.getMinNormalValue()
															+ " - "
															+ dgDetail
																	.getNormal()
																	.getMaxNormalValue();
												}
											}

										}
			%>
			<td><%=i%></td>
			<td><%=investigationName%></td>
			<td><%=resultDetail%></td>
			<td><%=uomValue%></td>
			<td><%=normalValue%></td>
			
			<%
				}
								}
							}
						}
					}
					normalSet = dgDetail.getSubInvestigation().getDgNormalValues();
			%>
			<%
				if (dgDetail.getSubInvestigation().getResultType()
							.equalsIgnoreCase("t")
							&& dgDetail.getSubInvestigation().getComparisonType()
									.equalsIgnoreCase("v")) {
						if (dgResultEntryHeaderForReport.getHin().getSex()
								.getAdministrativeSexName()
								.equalsIgnoreCase("female")) {

							if (normalSet.size() > 0) {
								for (DgNormalValue nv : normalSet) {
									if (nv != null
											&& nv.getSex().equalsIgnoreCase("n")) {

										String investigationName = "-";
										if (dgDetail.getSubInvestigation() != null
												&& !"".equalsIgnoreCase(dgDetail
														.getSubInvestigation()
														.getSubInvestigationName())) {
											investigationName = dgDetail
													.getSubInvestigation()
													.getSubInvestigationName();

										}
										String resultDetail = "-";
										try {
											if (dgDetail.getResult() != null) {
												resultDetail=dgDetail.getResult() ;
											}
										} catch (Exception exception) {
											exception.printStackTrace();
										}

										String uomValue = "-";
										if (dgDetail.getUom() != null
												&& !"".equalsIgnoreCase(dgDetail
														.getUom().getUomName())) {
											uomValue = dgDetail.getUom()
													.getUomName();
										}

										String normalValue = "-";
										if (dgDetail.getNormal() != null) {

											if (dgDetail.getNormal()
													.getNormalValue() != null
													|| dgDetail.getNormal()
															.getMinNormalValue() != null
													|| dgDetail.getNormal()
															.getMaxNormalValue() != null) {

												if (dgDetail.getNormal()
														.getNormalValue() != null) {
													if (!dgDetail.getNormal()
															.getNormalValue()
															.equals("")) {
														normalValue = dgDetail
																.getNormal()
																.getNormalValue();

													} else if (dgDetail.getNormal()
															.getMinNormalValue() != null
															&& dgDetail
																	.getNormal()
																	.getMaxNormalValue() != null) {
														normalValue = dgDetail
																.getNormal()
																.getMinNormalValue()
																+ " - "
																+ dgDetail
																		.getNormal()
																		.getMaxNormalValue();

													}
												} else if (dgDetail.getNormal()
														.getMinNormalValue() != null
														&& dgDetail
																.getNormal()
																.getMaxNormalValue() != null) {
													normalValue = dgDetail
															.getNormal()
															.getMinNormalValue()
															+ " - "
															+ dgDetail
																	.getNormal()
																	.getMaxNormalValue();
												}
											}

										}
			%>
			<td><%=i%></td>
			<td><%=investigationName%></td>
			<td><%=resultDetail%></td>
			<td><%=uomValue%></td>
			<td><%=normalValue%></td>
			
			<%
				}
								}
							}
						}
					}
			%>
			<!--  when result type TEXT AREA and comaprison type NORMAL VALUE and condition fEmale -->

			<!--  when result type is TEXT AREA and comparison type is NORMAL VALUE  -->
			<!--  condition none  -->
			<%
				normalSet = dgDetail.getSubInvestigation().getDgNormalValues();
			%>
			<%
				if (dgDetail.getSubInvestigation().getResultType()
							.equalsIgnoreCase("t")
							&& dgDetail.getSubInvestigation().getComparisonType()
									.equalsIgnoreCase("v")) {
						if (dgResultEntryHeaderForReport.getHin().getSex()
								.getAdministrativeSexName()
								.equalsIgnoreCase("Not applicable")) {

							if (normalSet.size() > 0) {
								for (DgNormalValue nv : normalSet) {
									if (nv != null
											&& nv.getSex().equalsIgnoreCase("n")) {

										String investigationName = "-";
										if (dgDetail.getSubInvestigation() != null
												&& !"".equalsIgnoreCase(dgDetail
														.getSubInvestigation()
														.getSubInvestigationName())) {
											investigationName = dgDetail
													.getSubInvestigation()
													.getSubInvestigationName();

										}
										String resultDetail = "-";
										try {
											if (dgDetail.getResult() != null) {
												resultDetail=dgDetail.getResult() ;
											}
										} catch (Exception exception) {
											exception.printStackTrace();
										}

										String uomValue = "-";
										if (dgDetail.getUom() != null
												&& !"".equalsIgnoreCase(dgDetail
														.getUom().getUomName())) {
											uomValue = dgDetail.getUom()
													.getUomName();
										}

										String normalValue = "-";
										if (dgDetail.getNormal() != null) {

											if (dgDetail.getNormal()
													.getNormalValue() != null
													|| dgDetail.getNormal()
															.getMinNormalValue() != null
													|| dgDetail.getNormal()
															.getMaxNormalValue() != null) {

												if (dgDetail.getNormal()
														.getNormalValue() != null) {
													if (!dgDetail.getNormal()
															.getNormalValue()
															.equals("")) {
														normalValue = dgDetail
																.getNormal()
																.getNormalValue();

													} else if (dgDetail.getNormal()
															.getMinNormalValue() != null
															&& dgDetail
																	.getNormal()
																	.getMaxNormalValue() != null) {
														normalValue = dgDetail
																.getNormal()
																.getMinNormalValue()
																+ " - "
																+ dgDetail
																		.getNormal()
																		.getMaxNormalValue();

													}
												} else if (dgDetail.getNormal()
														.getMinNormalValue() != null
														&& dgDetail
																.getNormal()
																.getMaxNormalValue() != null) {
													normalValue = dgDetail
															.getNormal()
															.getMinNormalValue()
															+ " - "
															+ dgDetail
																	.getNormal()
																	.getMaxNormalValue();
												}
											}

										}
			%>
			<td><%=i%></td>
			<td><%=investigationName%></td>
			<td><%=resultDetail%></td>
			<td><%=uomValue%></td>
			<td><%=normalValue%></td>
			
			<%
				}
								}
							}
						}
					}
			%>
			<!--  when result type is TEXT AREA and comaprison type NORMAL VALUE and condition none -->

			<!--  when result type is Range and comparison type is NORMAL VALUE  -->
			<!--  condition male  -->
			<%
				normalSet = dgDetail.getSubInvestigation().getDgNormalValues();
			%>
			<%
				if (dgDetail.getSubInvestigation().getResultType()
							.equalsIgnoreCase("r")
							&& dgDetail.getSubInvestigation().getComparisonType()
									.equalsIgnoreCase("v")) {
						if (dgResultEntryHeaderForReport.getHin().getSex()
								.getAdministrativeSexName()
								.equalsIgnoreCase("male")) {

							if (normalSet.size() > 0) {
								for (DgNormalValue nv : normalSet) {
									if (nv != null
											&& nv.getSex().equalsIgnoreCase("n")) {

										String investigationName = "-";
										if (dgDetail.getSubInvestigation() != null
												&& !"".equalsIgnoreCase(dgDetail
														.getSubInvestigation()
														.getSubInvestigationName())) {
											investigationName = dgDetail
													.getSubInvestigation()
													.getSubInvestigationName();

										}
										String resultDetail = "-";
										try {
											if (dgDetail.getResult() != null) {
												resultDetail=dgDetail.getResult() ;
											}
										} catch (Exception exception) {
											exception.printStackTrace();
										}

										String uomValue = "-";
										if (dgDetail.getUom() != null
												&& !"".equalsIgnoreCase(dgDetail
														.getUom().getUomName())) {
											uomValue = dgDetail.getUom()
													.getUomName();
										}

										String normalValue = "-";
										if (dgDetail.getNormal() != null) {

											if (dgDetail.getNormal()
													.getNormalValue() != null
													|| dgDetail.getNormal()
															.getMinNormalValue() != null
													|| dgDetail.getNormal()
															.getMaxNormalValue() != null) {

												if (dgDetail.getNormal()
														.getNormalValue() != null) {
													if (!dgDetail.getNormal()
															.getNormalValue()
															.equals("")) {
														normalValue = dgDetail
																.getNormal()
																.getNormalValue();

													} else if (dgDetail.getNormal()
															.getMinNormalValue() != null
															&& dgDetail
																	.getNormal()
																	.getMaxNormalValue() != null) {
														normalValue = dgDetail
																.getNormal()
																.getMinNormalValue()
																+ " - "
																+ dgDetail
																		.getNormal()
																		.getMaxNormalValue();

													}
												} else if (dgDetail.getNormal()
														.getMinNormalValue() != null
														&& dgDetail
																.getNormal()
																.getMaxNormalValue() != null) {
													normalValue = dgDetail
															.getNormal()
															.getMinNormalValue()
															+ " - "
															+ dgDetail
																	.getNormal()
																	.getMaxNormalValue();
												}
											}

										}
			%>
			<td><%=i%></td>
			<td><%=investigationName%></td>
			<td><%=resultDetail%></td>
			<td><%=uomValue%></td>
			<td><%=normalValue%></td>
			
			<%
				}
								}
							}
						}
					}
			%>
			<!--  when result type is Range and comaprison type NORMAL VALUE and condition male -->

			<!--  when result type is RANGE and comparison type is NORMAL VALUE  -->
			<!--  condition Female  -->
			<%
				normalSet = dgDetail.getSubInvestigation().getDgNormalValues();
			%>
			<%
				if (dgDetail.getSubInvestigation().getResultType()
							.equalsIgnoreCase("r")
							&& dgDetail.getSubInvestigation().getComparisonType()
									.equalsIgnoreCase("v")) {
						if (dgResultEntryHeaderForReport.getHin().getSex()
								.getAdministrativeSexName()
								.equalsIgnoreCase("female")) {

							if (normalSet.size() > 0) {
								for (DgNormalValue nv : normalSet) {
									if (nv != null
											&& nv.getSex().equalsIgnoreCase("n")) {

										String investigationName = "-";
										if (dgDetail.getSubInvestigation() != null
												&& !"".equalsIgnoreCase(dgDetail
														.getSubInvestigation()
														.getSubInvestigationName())) {
											investigationName = dgDetail
													.getSubInvestigation()
													.getSubInvestigationName();

										}
										String resultDetail = "-";
										try {
											if (dgDetail.getResult() != null) {
												resultDetail=dgDetail.getResult() ;
											}
										} catch (Exception exception) {
											exception.printStackTrace();
										}

										String uomValue = "-";
										if (dgDetail.getUom() != null
												&& !"".equalsIgnoreCase(dgDetail
														.getUom().getUomName())) {
											uomValue = dgDetail.getUom()
													.getUomName();
										}

										String normalValue = "-";
										if (dgDetail.getNormal() != null) {

											if (dgDetail.getNormal()
													.getNormalValue() != null
													|| dgDetail.getNormal()
															.getMinNormalValue() != null
													|| dgDetail.getNormal()
															.getMaxNormalValue() != null) {

												if (dgDetail.getNormal()
														.getNormalValue() != null) {
													if (!dgDetail.getNormal()
															.getNormalValue()
															.equals("")) {
														normalValue = dgDetail
																.getNormal()
																.getNormalValue();

													} else if (dgDetail.getNormal()
															.getMinNormalValue() != null
															&& dgDetail
																	.getNormal()
																	.getMaxNormalValue() != null) {
														normalValue = dgDetail
																.getNormal()
																.getMinNormalValue()
																+ " - "
																+ dgDetail
																		.getNormal()
																		.getMaxNormalValue();

													}
												} else if (dgDetail.getNormal()
														.getMinNormalValue() != null
														&& dgDetail
																.getNormal()
																.getMaxNormalValue() != null) {
													normalValue = dgDetail
															.getNormal()
															.getMinNormalValue()
															+ " - "
															+ dgDetail
																	.getNormal()
																	.getMaxNormalValue();
												}
											}

										}
			%>
			<td><%=i%></td>
			<td><%=investigationName%></td>
			<td><%=resultDetail%></td>
			<td><%=uomValue%></td>
			<td><%=normalValue%></td>
			
			<%
				}
								}
							}
						}
					}
			%>
			<!--  when result type RANGE and comaprison type NORMAL VALUE and condition fEmale -->

			<!--  when result type is RANGE and comparison type is NORMAL VALUE  -->
			<!--  condition none  -->
			<%
				normalSet = dgDetail.getSubInvestigation().getDgNormalValues();
			%>
			<%
				if (dgDetail.getSubInvestigation().getResultType()
							.equalsIgnoreCase("r")
							&& dgDetail.getSubInvestigation().getComparisonType()
									.equalsIgnoreCase("v")) {
						if (dgResultEntryHeaderForReport.getHin().getSex()
								.getAdministrativeSexName()
								.equalsIgnoreCase("Not applicable")) {

							if (normalSet.size() > 0) {
								for (DgNormalValue nv : normalSet) {
									if (nv != null
											&& nv.getSex().equalsIgnoreCase("n")) {

										String investigationName = "-";
										if (dgDetail.getSubInvestigation() != null
												&& !"".equalsIgnoreCase(dgDetail
														.getSubInvestigation()
														.getSubInvestigationName())) {
											investigationName = dgDetail
													.getSubInvestigation()
													.getSubInvestigationName();

										}
										String resultDetail = "-";
										try {
											if (dgDetail.getResult() != null) {
												resultDetail=dgDetail.getResult() ;
											}
										} catch (Exception exception) {
											exception.printStackTrace();
										}

										String uomValue = "-";
										if (dgDetail.getUom() != null
												&& !"".equalsIgnoreCase(dgDetail
														.getUom().getUomName())) {
											uomValue = dgDetail.getUom()
													.getUomName();
										}

										String normalValue = "-";
										if (dgDetail.getNormal() != null) {

											if (dgDetail.getNormal()
													.getNormalValue() != null
													|| dgDetail.getNormal()
															.getMinNormalValue() != null
													|| dgDetail.getNormal()
															.getMaxNormalValue() != null) {

												if (dgDetail.getNormal()
														.getNormalValue() != null) {
													if (!dgDetail.getNormal()
															.getNormalValue()
															.equals("")) {
														normalValue = dgDetail
																.getNormal()
																.getNormalValue();

													} else if (dgDetail.getNormal()
															.getMinNormalValue() != null
															&& dgDetail
																	.getNormal()
																	.getMaxNormalValue() != null) {
														normalValue = dgDetail
																.getNormal()
																.getMinNormalValue()
																+ " - "
																+ dgDetail
																		.getNormal()
																		.getMaxNormalValue();

													}
												} else if (dgDetail.getNormal()
														.getMinNormalValue() != null
														&& dgDetail
																.getNormal()
																.getMaxNormalValue() != null) {
													normalValue = dgDetail
															.getNormal()
															.getMinNormalValue()
															+ " - "
															+ dgDetail
																	.getNormal()
																	.getMaxNormalValue();
												}
											}

										}
			%>
			<td><%=i%></td>
			<td><%=investigationName%></td>
			<td><%=resultDetail%></td>
			<td><%=uomValue%></td>
			<td><%=normalValue%></td>
			
			<%
				}
								}
							}
						}
					}
			%>
			<!--  when result type is RANGE and comaprison type NORMAL VALUE and condition none -->

			<!--  when result type is HEADING and comparison type is NONE -->
			<%
				if (dgDetail.getSubInvestigation().getResultType()
							.equalsIgnoreCase("h")
							&& dgDetail.getSubInvestigation().getComparisonType()
									.equalsIgnoreCase("n")) {
						String investigationName = "-";
						if (dgDetail.getSubInvestigation() != null) {

							investigationName = dgDetail.getSubInvestigation()
									.getSubInvestigationName();

						}
			%>
			<td><%=i%></td>
			<td><%=investigationName%></td>
			<td>-</td>
			<td>-</td>
			<td>-</td>
			<%
				}
			%>
			<!--  end when result type is HEADING and comparison type is NONE  -->
			<!--  when result type is HEADING and comparison type is FIXED VALUE -->
			<%
				if (dgDetail.getSubInvestigation().getResultType()
							.equalsIgnoreCase("h")
							&& dgDetail.getSubInvestigation().getComparisonType()
									.equalsIgnoreCase("f")) {
						String investigationName = "-";
						if (dgDetail.getSubInvestigation() != null) {

							investigationName = dgDetail.getSubInvestigation()
									.getSubInvestigationName();

						}
			%>
			<td><%=i%></td>
			<td><%=investigationName%></td>
			<td>-</td>
			<td>-</td>
			<td>-</td>
			<%
				}
			%>
			<!--  end when result type is HEADING and comparison type is FIXED VALUE -->
			<!--  when result type is HEADING and comparison type is NORMAL VALUE  -->
			<%
				if (dgDetail.getSubInvestigation().getResultType()
							.equalsIgnoreCase("h")
							&& dgDetail.getSubInvestigation().getComparisonType()
									.equalsIgnoreCase("v")) {
						String investigationName = "-";
						if (dgDetail.getSubInvestigation() != null) {

							investigationName = dgDetail.getSubInvestigation()
									.getSubInvestigationName();

						}
			%>
			<td><%=i%></td>
			<td><%=investigationName%></td>
			<td>-</td>
			<td>-</td>
			<td>-</td>
			<%
				}
			%>
			<!--  end of when result type is HEADING and comparison type is NORMAL VALUE  -->
			<!--  when result type is SINGLE PARAMETER and COMPARISON TYPE is NONE  -->
			<%
				if ((dgDetail.getSubInvestigation().getResultType()
							.equalsIgnoreCase("s") && dgDetail
							.getSubInvestigation().getComparisonType()
							.equalsIgnoreCase("n"))) {
						String investigationName = "-";
						if (dgDetail.getSubInvestigation() != null) {
							investigationName = dgDetail.getSubInvestigation()
									.getSubInvestigationName();

						}
						String resultDetail = "-";
						try {
							if (dgDetail.getResult() != null) {
								resultDetail=dgDetail.getResult() ;
							}
						} catch (Exception exception) {
							exception.printStackTrace();
						}
						String uomValue = "-";
						if (dgDetail.getUom() != null) {
							uomValue = dgDetail.getUom().getUomName();
						}
						String normalValue = "-";
						if (dgDetail.getNormal() != null) {

							if (dgDetail.getNormal().getNormalValue() != null
									|| dgDetail.getNormal().getMinNormalValue() != null
									|| dgDetail.getNormal().getMaxNormalValue() != null) {

								if (dgDetail.getNormal().getNormalValue() != null) {
									if (!dgDetail.getNormal().getNormalValue()
											.equals("")) {
										normalValue = dgDetail.getNormal()
												.getNormalValue();

									} else if (dgDetail.getNormal()
											.getMinNormalValue() != null
											&& dgDetail.getNormal()
													.getMaxNormalValue() != null) {
										normalValue = dgDetail.getNormal()
												.getMinNormalValue()
												+ " - "
												+ dgDetail.getNormal()
														.getMaxNormalValue();

									}
								} else if (dgDetail.getNormal().getMinNormalValue() != null
										&& dgDetail.getNormal().getMaxNormalValue() != null) {
									normalValue = dgDetail.getNormal()
											.getMinNormalValue()
											+ " - "
											+ dgDetail.getNormal()
													.getMaxNormalValue();
								}
							}

						}
			%>
			<td><%=i%></td>
			<td><%=investigationName%></td>
			<td><%=resultDetail%></td>
			<td><%=uomValue%></td>
			<td><%=normalValue%></td>
			
			<%
				}
			%>
			<!--  end when result type is SINGLE PARAMETER and COMAPRISON TYPE is NONE -->

			<!--  when result type is SINGLE PARAMAETER and comparison type is FIXED VALUE  -->
			<%
				if (dgDetail.getSubInvestigation().getResultType()
							.equalsIgnoreCase("s")
							&& dgDetail.getSubInvestigation().getComparisonType()
									.equalsIgnoreCase("f")) {
						String investigationName = "-";
						if (dgDetail.getSubInvestigation() != null) {
							investigationName = dgDetail.getSubInvestigation()
									.getSubInvestigationName();

						}
						String resultDetail = "-";
						try {
							if (dgDetail.getResult() != null) {
								resultDetail=dgDetail.getResult() ;
							}
						} catch (Exception exception) {
							exception.printStackTrace();
						}
						String uomValue = "-";
						if (dgDetail.getUom() != null) {
							uomValue = dgDetail.getUom().getUomName();
						}
						String normalValue = "-";
						if (dgDetail.getNormal() != null) {

							if (dgDetail.getNormal().getNormalValue() != null
									|| dgDetail.getNormal().getMinNormalValue() != null
									|| dgDetail.getNormal().getMaxNormalValue() != null) {

								if (dgDetail.getNormal().getNormalValue() != null) {
									if (!dgDetail.getNormal().getNormalValue()
											.equals("")) {
										normalValue = dgDetail.getNormal()
												.getNormalValue();

									} else if (dgDetail.getNormal()
											.getMinNormalValue() != null
											&& dgDetail.getNormal()
													.getMaxNormalValue() != null) {
										normalValue = dgDetail.getNormal()
												.getMinNormalValue()
												+ " - "
												+ dgDetail.getNormal()
														.getMaxNormalValue();

									}
								} else if (dgDetail.getNormal().getMinNormalValue() != null
										&& dgDetail.getNormal().getMaxNormalValue() != null) {
									normalValue = dgDetail.getNormal()
											.getMinNormalValue()
											+ " - "
											+ dgDetail.getNormal()
													.getMaxNormalValue();
								}
							}

						}
			%>
			<td><%=i%></td>
			<td><%=investigationName%></td>
			<td><%=resultDetail%></td>
			<td><%=uomValue%></td>
			<td><%=normalValue%></td>
			
			<%
				}
			%>
			<!-- end of when result type is SINGLE PARAMAETER and comparison type is FIXED VALUE -->
			<!--  when result type is MULTIPLE PARAMETER and comparison type is NONE  -->
			<%
				if (dgDetail.getSubInvestigation().getResultType()
							.equalsIgnoreCase("m")
							&& dgDetail.getSubInvestigation().getComparisonType()
									.equalsIgnoreCase("n")) {
						String investigationName = "-";
						if (dgDetail.getSubInvestigation() != null) {
							investigationName = dgDetail.getSubInvestigation()
									.getSubInvestigationName();

						}
						String resultDetail = "-";
						try {
							if (dgDetail.getResult() != null) {
								resultDetail=dgDetail.getResult() ;
							}
						} catch (Exception exception) {
							exception.printStackTrace();
						}
						String uomValue = "-";
						if (dgDetail.getUom() != null) {
							uomValue = dgDetail.getUom().getUomName();
						}
						String normalValue = "-";
						if (dgDetail.getNormal() != null) {

							if (dgDetail.getNormal().getNormalValue() != null
									|| dgDetail.getNormal().getMinNormalValue() != null
									|| dgDetail.getNormal().getMaxNormalValue() != null) {

								if (dgDetail.getNormal().getNormalValue() != null) {
									if (!dgDetail.getNormal().getNormalValue()
											.equals("")) {
										normalValue = dgDetail.getNormal()
												.getNormalValue();

									} else if (dgDetail.getNormal()
											.getMinNormalValue() != null
											&& dgDetail.getNormal()
													.getMaxNormalValue() != null) {
										normalValue = dgDetail.getNormal()
												.getMinNormalValue()
												+ " - "
												+ dgDetail.getNormal()
														.getMaxNormalValue();

									}
								} else if (dgDetail.getNormal().getMinNormalValue() != null
										&& dgDetail.getNormal().getMaxNormalValue() != null) {
									normalValue = dgDetail.getNormal()
											.getMinNormalValue()
											+ " - "
											+ dgDetail.getNormal()
													.getMaxNormalValue();
								}
							}

						}
			%>
			<td><%=i%></td>
			<td><%=investigationName%></td>
			<td><%=resultDetail%></td>
			<td><%=uomValue%></td>
			<td><%=normalValue%></td>
			
			<%
				}
			%>
			<!--  when result type is MULTIPLE PARAMETER and comparison type is NONE   -->
			<!--  when result type is MULTIPLE PARAMETER and Comparison type is FIXED VALUE  -->
			<%
				if (dgDetail.getSubInvestigation().getResultType()
							.equalsIgnoreCase("m")
							&& dgDetail.getSubInvestigation().getComparisonType()
									.equalsIgnoreCase("f")) {
						String investigationName = "-";
						if (dgDetail.getSubInvestigation() != null) {
							investigationName = dgDetail.getSubInvestigation()
									.getSubInvestigationName();

						}
						String resultDetail = "-";
						try {
							if (dgDetail.getResult() != null) {
								resultDetail=dgDetail.getResult() ;
							}
						} catch (Exception exception) {
							exception.printStackTrace();
						}
						String uomValue = "-";
						if (dgDetail.getUom() != null) {
							uomValue = dgDetail.getUom().getUomName();
						}
						String normalValue = "-";
						if (dgDetail.getNormal() != null) {

							if (dgDetail.getNormal().getNormalValue() != null
									|| dgDetail.getNormal().getMinNormalValue() != null
									|| dgDetail.getNormal().getMaxNormalValue() != null) {

								if (dgDetail.getNormal().getNormalValue() != null) {
									if (!dgDetail.getNormal().getNormalValue()
											.equals("")) {
										normalValue = dgDetail.getNormal()
												.getNormalValue();

									} else if (dgDetail.getNormal()
											.getMinNormalValue() != null
											&& dgDetail.getNormal()
													.getMaxNormalValue() != null) {
										normalValue = dgDetail.getNormal()
												.getMinNormalValue()
												+ " - "
												+ dgDetail.getNormal()
														.getMaxNormalValue();

									}
								} else if (dgDetail.getNormal().getMinNormalValue() != null
										&& dgDetail.getNormal().getMaxNormalValue() != null) {
									normalValue = dgDetail.getNormal()
											.getMinNormalValue()
											+ " - "
											+ dgDetail.getNormal()
													.getMaxNormalValue();
								}
							}

						}
			%>
			<td><%=i%></td>
			<td><%=investigationName%></td>
			<td><%=resultDetail%></td>
			<td><%=uomValue%></td>
			<td><%=normalValue%></td>
			
			<%
				}
			%>
			<!-- end when result type is MULTIPLE PARAMETER and Comparison type is FIXED VALUE  -->

			<!--  when result type is TEXT AREA and comparison type is NONE -->
			<%
				if (dgDetail.getSubInvestigation().getResultType()
							.equalsIgnoreCase("t")
							&& dgDetail.getSubInvestigation().getComparisonType()
									.equalsIgnoreCase("n")) {
						String investigationName = "-";
						if (dgDetail.getSubInvestigation() != null) {
							investigationName = dgDetail.getSubInvestigation()
									.getSubInvestigationName();

						}
						String resultDetail = "-";
						try {
							if (dgDetail.getResult() != null) {
								resultDetail=dgDetail.getResult() ;
							}
						} catch (Exception exception) {
							exception.printStackTrace();
						}
						String uomValue = "-";
						if (dgDetail.getUom() != null) {
							uomValue = dgDetail.getUom().getUomName();
						}
						String normalValue = "-";
						if (dgDetail.getNormal() != null) {

							if (dgDetail.getNormal().getNormalValue() != null
									|| dgDetail.getNormal().getMinNormalValue() != null
									|| dgDetail.getNormal().getMaxNormalValue() != null) {

								if (dgDetail.getNormal().getNormalValue() != null) {
									if (!dgDetail.getNormal().getNormalValue()
											.equals("")) {
										normalValue = dgDetail.getNormal()
												.getNormalValue();

									} else if (dgDetail.getNormal()
											.getMinNormalValue() != null
											&& dgDetail.getNormal()
													.getMaxNormalValue() != null) {
										normalValue = dgDetail.getNormal()
												.getMinNormalValue()
												+ " - "
												+ dgDetail.getNormal()
														.getMaxNormalValue();

									}
								} else if (dgDetail.getNormal().getMinNormalValue() != null
										&& dgDetail.getNormal().getMaxNormalValue() != null) {
									normalValue = dgDetail.getNormal()
											.getMinNormalValue()
											+ " - "
											+ dgDetail.getNormal()
													.getMaxNormalValue();
								}
							}

						}
			%>
			<td><%=i%></td>
			<td><%=investigationName%></td>
			<td><%=resultDetail%></td>
			<td><%=uomValue%></td>
			<td><%=normalValue%></td>
			
			<%
				}
			%>
			<!-- end when result type is TEXT AREA and comparison type is NONE -->

			<!--  when result type is TEXT AREA and comparison type is FIXED VALUE -->
			<%
				if (dgDetail.getSubInvestigation().getResultType()
							.equalsIgnoreCase("t")
							&& dgDetail.getSubInvestigation().getComparisonType()
									.equalsIgnoreCase("f")) {
						String investigationName = "-";
						if (dgDetail.getSubInvestigation() != null) {
							investigationName = dgDetail.getSubInvestigation()
									.getSubInvestigationName();

						}
						String resultDetail = "-";
						try {
							if (dgDetail.getResult() != null) {
								resultDetail=dgDetail.getResult() ;
							}
						} catch (Exception exception) {
							exception.printStackTrace();
						}
						String uomValue = "-";
						if (dgDetail.getUom() != null) {
							uomValue = dgDetail.getUom().getUomName();
						}
						String normalValue = "-";
						if (dgDetail.getNormal() != null) {

							if (dgDetail.getNormal().getNormalValue() != null
									|| dgDetail.getNormal().getMinNormalValue() != null
									|| dgDetail.getNormal().getMaxNormalValue() != null) {

								if (dgDetail.getNormal().getNormalValue() != null) {
									if (!dgDetail.getNormal().getNormalValue()
											.equals("")) {
										normalValue = dgDetail.getNormal()
												.getNormalValue();

									} else if (dgDetail.getNormal()
											.getMinNormalValue() != null
											&& dgDetail.getNormal()
													.getMaxNormalValue() != null) {
										normalValue = dgDetail.getNormal()
												.getMinNormalValue()
												+ " - "
												+ dgDetail.getNormal()
														.getMaxNormalValue();

									}
								} else if (dgDetail.getNormal().getMinNormalValue() != null
										&& dgDetail.getNormal().getMaxNormalValue() != null) {
									normalValue = dgDetail.getNormal()
											.getMinNormalValue()
											+ " - "
											+ dgDetail.getNormal()
													.getMaxNormalValue();
								}
							}

						}
			%>
			<td><%=i%></td>
			<td><%=investigationName%></td>
			<td><%=resultDetail%></td>
			<td><%=uomValue%></td>
			<td><%=normalValue%></td>
			
			<%
				}
			%>
			<!-- end  when result type is TEXT AREA and comparison type is FIXED VALUE -->
			<!--  when result type is Range and comparison type is NONE -->
			<%
				if (dgDetail.getSubInvestigation().getResultType()
							.equalsIgnoreCase("r")
							&& dgDetail.getSubInvestigation().getComparisonType()
									.equalsIgnoreCase("n")) {
						String investigationName = "-";
						if (dgDetail.getSubInvestigation() != null) {
							investigationName = dgDetail.getSubInvestigation()
									.getSubInvestigationName();

						}
						String resultDetail = "-";
						try {
							if (dgDetail.getResult() != null) {
								resultDetail=dgDetail.getResult() ;
							}
						} catch (Exception exception) {
							exception.printStackTrace();
						}
						String uomValue = "-";
						if (dgDetail.getUom() != null) {
							uomValue = dgDetail.getUom().getUomName();
						}
						String normalValue = "-";
						if (dgDetail.getNormal() != null) {

							if (dgDetail.getNormal().getNormalValue() != null
									|| dgDetail.getNormal().getMinNormalValue() != null
									|| dgDetail.getNormal().getMaxNormalValue() != null) {

								if (dgDetail.getNormal().getNormalValue() != null) {
									if (!dgDetail.getNormal().getNormalValue()
											.equals("")) {
										normalValue = dgDetail.getNormal()
												.getNormalValue();

									} else if (dgDetail.getNormal()
											.getMinNormalValue() != null
											&& dgDetail.getNormal()
													.getMaxNormalValue() != null) {
										normalValue = dgDetail.getNormal()
												.getMinNormalValue()
												+ " - "
												+ dgDetail.getNormal()
														.getMaxNormalValue();

									}
								} else if (dgDetail.getNormal().getMinNormalValue() != null
										&& dgDetail.getNormal().getMaxNormalValue() != null) {
									normalValue = dgDetail.getNormal()
											.getMinNormalValue()
											+ " - "
											+ dgDetail.getNormal()
													.getMaxNormalValue();
								}
							}

						}
			%>
			<td><%=i%></td>
			<td><%=investigationName%></td>
			<td><%=resultDetail%></td>
			<td><%=uomValue%></td>
			<td><%=normalValue%></td>
			
			<%
				}
			%>
			<!-- when result type is RANGE and comparison type is FIXED VALUE  -->
			<%
				if (dgDetail.getSubInvestigation().getResultType()
							.equalsIgnoreCase("r")
							&& dgDetail.getSubInvestigation().getComparisonType()
									.equalsIgnoreCase("f")) {
						String investigationName = "-";
						if (dgDetail.getSubInvestigation() != null) {
							investigationName = dgDetail.getSubInvestigation()
									.getSubInvestigationName();

						}
						String resultDetail = "-";
						try {
							if (dgDetail.getResult() != null) {
								resultDetail=dgDetail.getResult() ;
							}
						} catch (Exception exception) {
							exception.printStackTrace();
						}
						String uomValue = "-";
						if (dgDetail.getUom() != null) {
							uomValue = dgDetail.getUom().getUomName();
						}
						String normalValue = "-";
						if (dgDetail.getNormal() != null) {

							if (dgDetail.getNormal().getNormalValue() != null
									|| dgDetail.getNormal().getMinNormalValue() != null
									|| dgDetail.getNormal().getMaxNormalValue() != null) {

								if (dgDetail.getNormal().getNormalValue() != null) {
									if (!dgDetail.getNormal().getNormalValue()
											.equals("")) {
										normalValue = dgDetail.getNormal()
												.getNormalValue();

									} else if (dgDetail.getNormal()
											.getMinNormalValue() != null
											&& dgDetail.getNormal()
													.getMaxNormalValue() != null) {
										normalValue = dgDetail.getNormal()
												.getMinNormalValue()
												+ " - "
												+ dgDetail.getNormal()
														.getMaxNormalValue();

									}
								} else if (dgDetail.getNormal().getMinNormalValue() != null
										&& dgDetail.getNormal().getMaxNormalValue() != null) {
									normalValue = dgDetail.getNormal()
											.getMinNormalValue()
											+ " - "
											+ dgDetail.getNormal()
													.getMaxNormalValue();
								}
							}

						}
			%>
			<td><%=i%></td>
			<td><%=investigationName%></td>
			<td><%=resultDetail%></td>
			<td><%=uomValue%></td>
			<td><%=normalValue%></td>
			
			<%
				}
			%>
			<%
				if (dgDetail.getSubInvestigation().getResultType()
							.equalsIgnoreCase("i")
							&& dgDetail.getSubInvestigation().getComparisonType()
									.equalsIgnoreCase("f")) {
						String investigationName = "-";
						if (dgDetail.getSubInvestigation() != null) {
							investigationName = dgDetail.getSubInvestigation()
									.getSubInvestigationName();

						}
						String resultDetail = "-";
						try {
							if (dgDetail.getResult() != null && dgDetail.getFixed() == null) {
								resultDetail=dgDetail.getResult() ;
							}
						} catch (Exception exception) {
							exception.printStackTrace();
						}
						String uomValue = "-";
						if (dgDetail.getUom() != null) {
							uomValue = dgDetail.getUom().getUomName();
						}
						String normalValue = "-";
						if (dgDetail.getNormal() != null) {

							if (dgDetail.getNormal().getNormalValue() != null
									|| dgDetail.getNormal().getMinNormalValue() != null
									|| dgDetail.getNormal().getMaxNormalValue() != null) {

								if (dgDetail.getNormal().getNormalValue() != null) {
									if (!dgDetail.getNormal().getNormalValue()
											.equals("")) {
										normalValue = dgDetail.getNormal()
												.getNormalValue();

									} else if (dgDetail.getNormal()
											.getMinNormalValue() != null
											&& dgDetail.getNormal()
													.getMaxNormalValue() != null) {
										normalValue = dgDetail.getNormal()
												.getMinNormalValue()
												+ " - "
												+ dgDetail.getNormal()
														.getMaxNormalValue();

									}
								} else if (dgDetail.getNormal().getMinNormalValue() != null
										&& dgDetail.getNormal().getMaxNormalValue() != null) {
									normalValue = dgDetail.getNormal()
											.getMinNormalValue()
											+ " - "
											+ dgDetail.getNormal()
													.getMaxNormalValue();
								}
							}

						}
			%>
			<td><%=i%></td>
			<td><%=investigationName%></td>
			<td><%=resultDetail%></td>
			<td><%=uomValue%></td>
			<td><%=normalValue%></td>
			
			<%
				}
			%>
		</tr>
		<%
			}
		%>

	</table> 
</div>
<h5></h5>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		