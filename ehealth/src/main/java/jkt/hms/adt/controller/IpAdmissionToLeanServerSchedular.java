package jkt.hms.adt.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.adt.dataservice.ADTDataService;
import jkt.hms.masters.business.IpAdmissionForLean;
import jkt.hms.masters.business.MasHospital;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

@DisallowConcurrentExecution
public class IpAdmissionToLeanServerSchedular extends QuartzJobBean {

	private static final Logger logger = org.apache.log4j.Logger
			.getLogger(IpAdmissionToLeanServerSchedular.class);

	ADTDataService adtDataService;

	public ADTDataService getAdtDataService() {
		return adtDataService;
	}

	public void setAdtDataService(ADTDataService adtDataService) {
		this.adtDataService = adtDataService;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		MasHospital hospital = null;
		Map<String, Object> objectMap = new HashMap<String, Object>();
		String ack = null;
		List<IpAdmissionForLean> ipAdmissionForLeanServer = null;
		Map<String, Object> dataMap = adtDataService.getDataForLeanServer();
		if (dataMap.get("ipAdmissionForLeanServer") != null) {
			ipAdmissionForLeanServer = (List<IpAdmissionForLean>) dataMap
					.get("ipAdmissionForLeanServer");
		}
		if (ipAdmissionForLeanServer != null) {
			for (IpAdmissionForLean ipData : ipAdmissionForLeanServer) {
				if (ipData.getHospitalId() != null) {
					objectMap.put("hospitalId", ipData.getHospitalId());
					dataMap = adtDataService.getHospitalData(objectMap);
					if (dataMap.get("hospital") != null) {
						hospital = (MasHospital) dataMap.get("hospital");
						ack = hl7MessageSender(ipData.getIpAdmission(),
								ipData.getIpBedAllow(), hospital);
						if ("1".equalsIgnoreCase(ack)) {
							adtDataService
									.updateLeanServerIpAdmissionData(ipData);
						}
					}
				}
			}
		}

	}

	private String hl7MessageSender(String msg, String bedMessage,
			MasHospital hospital) {
		StringBuilder sb = new StringBuilder();
		URLConnection connection = null;
		InputStreamReader in = null;
		String message = "2";
		try {
			msg = msg.replace("&", "$");
			msg = msg.replaceAll("\r", "#");
			String encode = URLEncoder.encode(msg, "UTF-8");
			String encode2 = URLEncoder.encode(bedMessage, "UTF-8");
			String header = "http://" + hospital.getClientIp();
			if (hospital.getClientIp() != null
					&& hospital.getClientPort() != null) {
				header = header.concat(":" + hospital.getClientPort());

				String uri = header
						+ "/hms/hms/adt?method=submitAdmissionInformationFromLean&message="
						+ encode + "&hospitalId=" + hospital.getId() + "&bed="
						+ encode2;
				logger.debug("Url>>>>" + uri);
				URL url = new URL(uri);
				connection = url.openConnection();
				if (connection != null && connection.getInputStream() != null) {
					in = new InputStreamReader(connection.getInputStream(),
							Charset.defaultCharset());
					BufferedReader bufferedReader = new BufferedReader(in);
					if (bufferedReader != null) {
						int cp;
						while ((cp = bufferedReader.read()) != -1) {
							sb.append((char) cp);
						}
						bufferedReader.close();
					}
					in.close();
				}
				String responseMsg = sb.toString();
				if (responseMsg.contains("success")) {
					message = "1";
					logger.debug("Addmission deone at central side server");
				} else if (responseMsg.contains("fail")) {
					message = "2";
				} else if (responseMsg.contains("500")) {
					message = "3";
				}
				logger.debug("Input Stream: " + sb.toString());
			}
		} catch (MalformedURLException e) {
			logger.debug("MalformedURLException in Patient IP Addmission Data To Lean Server Schedular");
		} catch (ConnectException e) {
			logger.debug("Connection refused in Patient IP Addmission Data To Lean Server Schedular");
		} catch (SocketTimeoutException e) {
			logger.debug("Connection timeout in Patient IP Addmission Data To Lean Server Schedular");
		} catch (IOException e) {
			logger.debug("IOException in Patient IP Addmission Data To Lean Server Schedular");
		}

		return message;
	}

}
