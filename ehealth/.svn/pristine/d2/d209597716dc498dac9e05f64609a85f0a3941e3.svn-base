package jkt.hms.ipd.controller;

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
import java.util.List;
import java.util.Map;

import jkt.hms.ipd.dataservice.IPDDataService;
import jkt.hms.masters.business.CentralServerIpdData;
import jkt.hms.masters.business.MasHospital;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

@DisallowConcurrentExecution
public class IpdDataToServerSchedular extends QuartzJobBean {

	private static final Logger logger = org.apache.log4j.Logger
			.getLogger(IpdDataToServerSchedular.class);

	IPDDataService ipdDataService;

	public IPDDataService getIpdDataService() {
		return ipdDataService;
	}

	public void setIpdDataService(IPDDataService ipdDataService) {
		this.ipdDataService = ipdDataService;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		MasHospital hospital = null;
		List<CentralServerIpdData> centralServerIpdDatas = null;
		Map<String, Object> dataMap = ipdDataService.getDataForServer();
		if (dataMap.get("masHospital") != null) {
			hospital = (MasHospital) dataMap.get("masHospital");
		}
		if (dataMap.get("centralServerIpdDatas") != null) {
			centralServerIpdDatas = (List<CentralServerIpdData>) dataMap
					.get("centralServerIpdDatas");
		}
		if (centralServerIpdDatas != null && hospital != null
				&& hospital.getServerIp() != null
				&& hospital.getServerPort() != null) {
			for (CentralServerIpdData cIpdData : centralServerIpdDatas) {
				String ack = hl7MessageSender(cIpdData.getIpdData(), hospital);
				if ("1".equalsIgnoreCase(ack)) {
					ipdDataService.updateCentralServerIPDData(cIpdData);
				}
			}
		}
	}

	private String hl7MessageSender(String msg, MasHospital hospital) {
		StringBuilder sb = new StringBuilder();
		URLConnection connection = null;
		InputStreamReader in = null;
		String message = "2";
		try {
			msg = msg.replace("&", "$");
			msg = msg.replaceAll("[\r\n]", "*");
			String encode = URLEncoder.encode(msg, "UTF-8");
			String header = "http://" + hospital.getServerIp();
			if (hospital.getServerPort() != null) {
				header = header.concat(":" + hospital.getServerPort());
			}
			String uri = header
					+ "/hms/hms/ipd?method=submitIPDInformationFromLean&message="
					+ encode + "&hospitalId=" + hospital.getId();
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
			} else if (responseMsg.contains("fail")) {
				message = "2";
			} else if (responseMsg.contains("500")) {
				message = "3";
			}
			logger.debug("Input Stream: " + sb.toString());
		} catch (MalformedURLException e) {
			logger.debug("MalformedURLException in Patient IPD Data To Central Server Schedular");
		} catch (ConnectException e) {
			logger.debug("Connection refused in Patient IPD Data To Central Server Schedular");
		} catch (SocketTimeoutException e) {
			logger.debug("Connection timeout in Patient IPD Data To Central Server Schedular");
		} catch (IOException e) {
			logger.debug("IOException in Patient IPD Data To Central Server Schedular");
		}

		return message;
	}
}
