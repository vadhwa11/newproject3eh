package jkt.hms.adt.controller;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Map;

import jkt.hms.adt.dataservice.RegistrationDataService;
import jkt.hms.masters.business.CentralServerVisitData;
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
public class PatientVisitDataToCentralServerSchedular extends QuartzJobBean {

	private static final Logger logger = org.apache.log4j.Logger
			.getLogger(PatientVisitDataToCentralServerSchedular.class);

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
		List<CentralServerVisitData> centralServerVisitDatas = null;
		Map<String, Object> dataMap = registrationDataService
				.getPatientVisitDataForCentralServer();
		if (dataMap.get("masHospital") != null) {
			hospital = (MasHospital) dataMap.get("masHospital");
		}
		if (dataMap.get("centralServerVisitData") != null) {
			centralServerVisitDatas = (List<CentralServerVisitData>) dataMap
					.get("centralServerVisitData");
		}
		if (centralServerVisitDatas != null && hospital != null
				&& hospital.getServerIp() != null
				&& hospital.getServerPort() != null) {
			logger.debug("******************Central Visit Schedular Started*********************");
			for (CentralServerVisitData cPatVisitData : centralServerVisitDatas) {
				String ack = hl7MessageSender(cPatVisitData.getVisitData(),
						hospital);
				if ("success".equalsIgnoreCase(ack)) {
					registrationDataService
							.updateCentralServerPatientVisitData(cPatVisitData);
				}
			}
			logger.debug("******************Central Visit Schedular Ended*********************");
		}
	}

	private String hl7MessageSender(String msg, MasHospital hospital) {
		String message = "fail";
		Parser parser = PipeParser.getInstanceWithNoValidation();
		HohClientSimple client = new HohClientSimple(hospital.getServerIp(),
				Integer.parseInt(hospital.getServerPort()), "/hms/hl7list",
				parser);
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

					logger.debug("visit save at lean_server");
					logger.debug("update the lean_server_vsit_data status as Y status ");
					message = "success";
					return message;
				}

			} else {
				logger.debug("exit");
			}
		} catch (EncodingNotSupportedException e) {
			logger.debug("EncodingNotSupportedException in Patient Visit Data To Central Server Schedular");
		} catch (HL7Exception e) {
			logger.debug("HL7Exception in Patient Visit Data To Central Server Schedular");
		} catch (ConnectException e) {
			logger.debug("Connection refused in Patient Visit Data To Central Server Schedular");
		} catch (SocketTimeoutException e) {
			logger.debug("Connection timeout in Patient Visit Data To Central Server Schedular");
		} catch (IOException e) {
			logger.debug("SocketTimeoutException in Patient Visit Data To Central Server Schedular");
		} catch (DecodeException e) {
			logger.debug("DecodeException in Patient Visit Data To Central Server Schedular");
		} catch (EncodeException e) {
			logger.debug("EncodeException in Patient Visit Data To Central Server Schedular");
		}

		return message;
	}
}
