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

import jkt.hms.adt.dataservice.RegistrationDataService;
import jkt.hms.masters.business.LeanServerPatientAppointmentData;
import jkt.hms.masters.business.MasHospital;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

@DisallowConcurrentExecution
public class PatientAppointmentDataUpdateToLeanServerSchedular extends
		QuartzJobBean {

	private static final Logger logger = org.apache.log4j.Logger
			.getLogger(PatientAppointmentDataUpdateToLeanServerSchedular.class);

	RegistrationDataService registrationDataService;

	public RegistrationDataService getRegistrationDataService() {
		return registrationDataService;
	}

	public void setRegistrationDataService(
			RegistrationDataService registrationDataService) {
		this.registrationDataService = registrationDataService;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		MasHospital hospital = null;
		Map<String, Object> objectMap = new HashMap<String, Object>();
		String ack = null;
		List<LeanServerPatientAppointmentData> leanServerPatientAppointmentDatas = null;
		Map<String, Object> dataMap = registrationDataService
				.getPatientAppointmentUpdateDataForLeanServer();
		if (dataMap.get("leanServerPatientAppointmentData") != null) {
			leanServerPatientAppointmentDatas = (List<LeanServerPatientAppointmentData>) dataMap
					.get("leanServerPatientAppointmentData");
		}
		if (leanServerPatientAppointmentDatas != null) {
			for (LeanServerPatientAppointmentData leanServerPatientAppointmentData : leanServerPatientAppointmentDatas) {
				if (leanServerPatientAppointmentData.getHospitalId() != null) {
					objectMap.put("hospitalId",
							leanServerPatientAppointmentData.getHospitalId());
					dataMap = registrationDataService
							.getHospitalData(objectMap);
					if (dataMap.get("hospital") != null) {
						hospital = (MasHospital) dataMap.get("hospital");
						ack = hl7MessageSender(
								leanServerPatientAppointmentData
										.getPaitentAppointmentData(),
								hospital);
						if ("1".equalsIgnoreCase(ack)) {
							registrationDataService
									.updateLeanServerPatientAppointmentData(leanServerPatientAppointmentData);
						}

					}
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
			String header = "http://" + hospital.getClientIp();
			if (hospital.getClientPort() != null) {
				header = header.concat(":" + hospital.getClientPort());
			}
			String uri = header
					+ "/hms/hms/appointment?method=updateClientAppointmentPatientToServer&message="
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
			logger.debug("MalformedURLException in Patient Appointment Data To Lean Server Schedular");
		} catch (ConnectException e) {
			logger.debug("Connection refused in Patient Appointment Data To Lean Server Schedular");
		} catch (SocketTimeoutException e) {
			logger.debug("Connection timeout in Patient Appointment Data To Lean Server Schedular");
		} catch (IOException e) {
			logger.debug("IOException in Patient Appointment Data To Lean Server Schedular");
		}

		return message;
	}
}
