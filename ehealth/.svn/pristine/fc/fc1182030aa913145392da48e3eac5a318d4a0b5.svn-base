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
import java.util.Map;
import java.util.Map.Entry;

import jkt.hms.adt.dataservice.RegistrationDataService;
import jkt.hms.masters.business.MasHospital;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

@DisallowConcurrentExecution
public class TokenSerialToCentralServerSchedular extends QuartzJobBean {

	private static final Logger logger = org.apache.log4j.Logger
			.getLogger(TokenSerialToCentralServerSchedular.class);

	RegistrationDataService registrationDataService;

	public RegistrationDataService getRegistrationDataService() {
		return registrationDataService;
	}

	public void setRegistrationDataService(
			RegistrationDataService registrationDataService) {
		this.registrationDataService = registrationDataService;
	}

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		URLConnection connection = null;
		InputStreamReader in = null;
		MasHospital hospital = null;
		String msgData = null;
		StringBuilder sb = new StringBuilder();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = registrationDataService.getTokenAndSerialNo();

			if (map != null) {
				for (Entry<String, Object> entry : map.entrySet()) {
					msgData = entry.getKey();
					hospital = (MasHospital) entry.getValue();

					if (msgData != null && !msgData.trim().equals("")
							&& hospital.getServerIp() != null) {
						logger.debug("******************Lean Visit Token and Serial No Schedular Started*********************");
						String encode = URLEncoder.encode(msgData, "UTF-8");
						String header = "http://" + hospital.getServerIp();

						if (hospital.getServerPort() != null) {
							header = header.concat(":"
									+ hospital.getServerPort());
						}

						String uri = header
								+ "/hms/hms/registration?method=submitTokenSerialInformationFromLean&message="
								+ encode + "&hospitalId=" + hospital.getId();

						URL url = new URL(uri);
						connection = url.openConnection();
						if (connection != null
								&& connection.getInputStream() != null) {
							in = new InputStreamReader(
									connection.getInputStream(),
									Charset.defaultCharset());
							BufferedReader bufferedReader = new BufferedReader(
									in);
							if (bufferedReader != null) {
								int cp;
								while ((cp = bufferedReader.read()) != -1) {
									sb.append((char) cp);
								}
								bufferedReader.close();
							}
							in.close();
						}
						logger.debug("Response Message: " + sb.toString());
						logger.debug("******************Lean Visit Token and Serial No Schedular finished*********************");
					}
				}
			}
		} catch (MalformedURLException e) {
			logger.debug("MalformedURLException in Token Serial To Central Server Schedular");
		} catch (ConnectException e) {
			logger.debug("Connection refused in Token Serial To Central Server Schedular");
		} catch (SocketTimeoutException e) {
			logger.debug("Connection timeout in Token Serial To Central Server Schedular");
		} catch (IOException e) {
			logger.debug("IOException in Token Serial To Central Server Schedular");
		}

	}

}
