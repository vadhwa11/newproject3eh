package jkt.hms.stores.controller;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.LeanServerOpdData;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.opd.dataservice.OPDDataService;

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
import ca.uhn.hl7v2.validation.impl.NoValidation;

@DisallowConcurrentExecution
public class HL7SchedularForCentralToLean extends QuartzJobBean {

	private static final Logger logger = org.apache.log4j.Logger
			.getLogger(HL7SchedularForCentralToLean.class);

	OPDDataService opdDataService;

	public OPDDataService getOpdDataService() {
		return opdDataService;
	}

	public void setOpdDataService(OPDDataService opdDataService) {
		this.opdDataService = opdDataService;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		MasHospital hospital = null;
		String message = null;
		Map<String, Object> objectMap = new HashMap<String, Object>();
		String ack = null;
		List<LeanServerOpdData> leanServerOpdDatas = null;
		Map<String, Object> dataMap = opdDataService.getDataForLeanServer();
		if (dataMap.get("leanServerOpdDatas") != null) {
			leanServerOpdDatas = (List<LeanServerOpdData>) dataMap
					.get("leanServerOpdDatas");
		}
		if (leanServerOpdDatas != null) {
			for (LeanServerOpdData lOpdData : leanServerOpdDatas) {
				if (lOpdData.getHospitalId() != null) {
					objectMap.put("hospitalId", lOpdData.getHospitalId());
					dataMap = opdDataService.getHospitalData(objectMap);
					if (dataMap.get("hospital") != null) {
						hospital = (MasHospital) dataMap.get("hospital");
						message = lOpdData.getOpdData();
						if (message != null && !message.equals("")) {
							ack = hl7MessageSender(lOpdData.getOpdData(),
									hospital);
							if ("success".equalsIgnoreCase(ack)) {
								opdDataService
										.updateLeanServerOPDData(lOpdData);
							}
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
				"/hms/hl7listserver", parser);
		client.setResponseTimeout(6000000);

		HapiContext hapiContext = new DefaultHapiContext();
		hapiContext.setValidationContext(new NoValidation());
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
				System.out
						.println("**********************************************************");
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

					logger.debug("order id Comming from server");
					logger.debug("update the central opd data status as Y status ");
					message = "success";
					return message;
				}

			} else {
				logger.debug("exit");
			}
		} catch (EncodingNotSupportedException e) {
			logger.debug("EncodingNotSupportedException in Patient OPD Data To Lean Server Schedular");
		} catch (HL7Exception e) {
			logger.debug("HL7Exception in Patient OPD Data To Lean Server Schedular");
		} catch (ConnectException e) {
			logger.debug("Connection refused in Patient OPD Data To Lean Server Schedular");
		} catch (SocketTimeoutException e) {
			logger.debug("Connection timeout in Patient OPD Data To Lean Server Schedular");
		} catch (IOException e) {
			logger.debug("IOException in Patient OPD Data To Lean Server Schedular");
		} catch (DecodeException e) {
			logger.debug("DecodeException in Patient OPD Data To Lean Server Schedular");
		}
		catch (EncodeException e){	
		logger.debug("EncodeException in Patient OPD Data To Lean Server Schedular");
		}

		return message;
	}

}
