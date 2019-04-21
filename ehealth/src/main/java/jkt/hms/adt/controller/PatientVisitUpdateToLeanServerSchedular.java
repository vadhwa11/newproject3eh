package jkt.hms.adt.controller;

// class created by amit das on 16-08-2016import java.io.IOException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.adt.dataservice.RegistrationDataService;
import jkt.hms.masters.business.LeanServerVisitData;
import jkt.hms.masters.business.MasHospital;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.hoh.api.DecodeException;
import ca.uhn.hl7v2.hoh.api.EncodeException;
import ca.uhn.hl7v2.hoh.api.IReceivable;
import ca.uhn.hl7v2.hoh.api.ISendable;
import ca.uhn.hl7v2.hoh.api.MessageMetadataKeys;
import ca.uhn.hl7v2.hoh.hapi.api.MessageSendable;
import ca.uhn.hl7v2.hoh.hapi.client.HohClientSimple;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v22.message.ACK;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;


@DisallowConcurrentExecution
public class PatientVisitUpdateToLeanServerSchedular extends QuartzJobBean {

	private static final Logger logger = org.apache.log4j.Logger
			.getLogger(PatientVisitUpdateToLeanServerSchedular.class);

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
		List<LeanServerVisitData> leanServerVisitDatas = null;
		Map<String, Object> dataMap = registrationDataService
				.getPatientVisitUpdateForLeanServer();
		if (dataMap.get("leanServerVisitData") != null) {
			leanServerVisitDatas = (List<LeanServerVisitData>) dataMap
					.get("leanServerVisitData");
		}
		if (leanServerVisitDatas != null) {
			for (LeanServerVisitData lPatVisitData : leanServerVisitDatas) {
				if (lPatVisitData.getHospitalId() != null) {
					objectMap.put("hospitalId", lPatVisitData.getHospitalId());
					dataMap = registrationDataService
							.getHospitalData(objectMap);
					if (dataMap.get("hospital") != null) {
						hospital = (MasHospital) dataMap.get("hospital");
						ack = hl7MessageSender(lPatVisitData.getVisitData(),
								hospital);
						if ("success".equalsIgnoreCase(ack)) {
							registrationDataService
									.updateLeanServerPatientVisitData(lPatVisitData);
						}
					}
				}
			}
		}
	}

	private String hl7MessageSender(String msg, MasHospital hospital) {
		String message = "fail";
		Parser parser = PipeParser.getInstanceWithNoValidation();
		HohClientSimple client = new HohClientSimple(hospital.getClientIp(),
				Integer.parseInt(hospital.getClientPort()),
				"/hms/hl7updateVisit", parser);
		client.setResponseTimeout(6000000);

		HapiContext hapiContext = new DefaultHapiContext();
		Parser p = hapiContext.getGenericParser();

		try {
			Message hapiMsg2 = p.parse(msg);
			ISendable sendable = new MessageSendable(hapiMsg2);
			IReceivable<Message> receivable = client
					.sendAndReceiveMessage(sendable);
			Message hapiMsg = receivable.getMessage();
			logger.debug("Response was:\n" + hapiMsg.encode());
			String remoteHostIp = (String) receivable.getMetadata().get(
					MessageMetadataKeys.REMOTE_HOST_ADDRESS);
			logger.debug("From:\n" + remoteHostIp);

			if (hapiMsg instanceof ACK) {
				ACK ack = (ACK) hapiMsg;

				logger.debug("Recieve acknowledge");

				logger.debug("inside ach msh "
						+ ack.getMSH().getMsh7_DateTimeOfMessage()
								.getTs1_TimeOfAnEvent());
				logger.debug("inside ach msh "
						+ ack.getMSH().getMsh9_MessageType()
								.getCm_msg1_MessageType());
				logger.debug("inside ach msh "
						+ ack.getMSH().getMsh10_MessageControlID());
				logger.debug("inside ach msh "
						+ ack.getMSH().getMsh11_ProcessingID());
				logger.debug("inside ach msh "
						+ ack.getMSH().getMsh12_VersionID());
				logger.debug("**********************************************************");
				logger.debug("inside ach msa  "
						+ ack.getMSA().getMsa1_AcknowledgementCode().getValue());
				logger.debug("inside ach msa  "
						+ ack.getMSA().getMsa2_MessageControlID());
				logger.debug("inside ach msa  "
						+ ack.getMSA().getMsa3_TextMessage().getValue());
				logger.debug("**********************************************************");
				logger.debug("inside ach err1  "
						+ ack.getERR().getErr1_ErrorCodeAndLocation(0)
								.getCm_eld4_CodeIdentifyingError()
								.getCe2_Text().getValue());
				logger.debug("inside ach err2  "
						+ ack.getERR().getErr1_ErrorCodeAndLocation(0)
								.getCm_eld4_CodeIdentifyingError()
								.getCe1_Identifier());
				logger.debug("inside ach err3  "
						+ ack.getERR().getErr1_ErrorCodeAndLocation(0)
								.getCm_eld4_CodeIdentifyingError()
								.getCe3_NameOfCodingSystem());

				if (ack.getMSA().getMsa1_AcknowledgementCode().getValue()
						.equalsIgnoreCase("AA")
						&& ack.getMSA().getMsa3_TextMessage().getValue() == null
						&& ack.getERR().getErr1_ErrorCodeAndLocation(0)
								.getCm_eld4_CodeIdentifyingError()
								.getCe2_Text().getValue() == null) {

					logger.debug("visit update at lean_server");
					logger.debug("update the lean_server_vsit_data status as Y status ");
					message = "success";
					return message;
				}

			} else {
				logger.debug("exit");
			}
		} catch (EncodingNotSupportedException e) {
			logger.debug("EncodingNotSupportedException in Patient Visit Update To Lean Server Schedular");
		} catch (HL7Exception e) {
			logger.debug("HL7Exception in Patient Visit Update To Lean Server Schedular");
		} catch (ConnectException e) {
			logger.debug("Connection refused in Patient Visit Update To Lean Server Schedular");
		} catch (SocketTimeoutException e) {
			logger.debug("Connection timeout in Patient Visit Update To Lean Server Schedular");
		} catch (IOException e) {
			logger.debug("IOException in Patient Visit Update To Lean Server Schedular");
		} catch (DecodeException e) {
			logger.debug("DecodeException in Patient Visit Update To Lean Server Schedular");
		} catch (EncodeException e) {
			logger.debug("EncodeException in Patient Visit Update To Lean Server Schedular");
		}

		return message;
	}
}
