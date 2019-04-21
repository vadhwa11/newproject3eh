package jkt.hms.stores.controller; 

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

import jkt.hms.masters.business.CentralServerMedicineDispenseData;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.stores.dataservice.StoresDataService;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;


@DisallowConcurrentExecution
public class MedicinePresDataToCentralServerSchedular extends QuartzJobBean{ 
	
	private static final Logger logger = org.apache.log4j.Logger.getLogger(MedicinePresDataToCentralServerSchedular.class);
	
	StoresDataService storesDataService; 
	public StoresDataService getStoresDataService() {
		return storesDataService;
	}
	public void setStoresDataService(StoresDataService storesDataService) {
		this.storesDataService = storesDataService;
	}
	@SuppressWarnings("unchecked")
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		MasHospital hospital=null;
		List<CentralServerMedicineDispenseData> centralServerMedicineDispenseDatas=null;
		Map<String,Object>	dataMap=storesDataService.getDataForMedicinePresForCentralServer();
		if(dataMap.get("masHospital")!=null){
			hospital=(MasHospital)dataMap.get("masHospital");
		}
		if(dataMap.get("centralServerMedicineDispenseData")!=null){ 
			centralServerMedicineDispenseDatas=(List<CentralServerMedicineDispenseData>)dataMap.get("centralServerMedicineDispenseData");
		} 
		if(centralServerMedicineDispenseDatas!=null && hospital!=null && hospital.getServerIp()!=null && hospital.getServerPort()!=null){
			for(CentralServerMedicineDispenseData centralServerMedicineDispenseData:centralServerMedicineDispenseDatas){
				String ack=hl7MessageSender(centralServerMedicineDispenseData.getMedicineDispenseData(),hospital); 
				if("1".equalsIgnoreCase(ack)){ 
					storesDataService.updateCentralServerMedicinePresData(centralServerMedicineDispenseData);  
				}
			}
		} 
		
	}
	private String hl7MessageSender(String msg,MasHospital hospital) {
		StringBuilder sb = new StringBuilder();
		URLConnection connection = null;
		InputStreamReader in = null; 
		String message = "2"; 
		try{
			logger.debug("Data For discharge Patient ");
	  	  	logger.debug(msg);
	  	  	msg=msg.replace("&", "$");
			msg=msg.replaceAll("[\r\n]", "*");
			String encode=URLEncoder.encode(msg,"UTF-8");
			String header="http://"+hospital.getServerIp();
			if(hospital.getServerPort()!=null){
				header=header.concat(":"+hospital.getServerPort());
			}   
			String uri=header+"/hms/hms/stores?method=medicineDispencingToCentralServer&message="
						+encode+"&hospitalId="+hospital.getId();
			logger.debug("Url>>>>"+uri);
			URL url=new URL(uri);
			connection=url.openConnection();  
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
			if (responseMsg
					.contains("success")) {
				message = "1";
				logger.debug("Addimidddion deone at central side server");
			}else if(responseMsg
					.contains("fail")){
				message = "2";
			}else if(responseMsg
					.contains("500")){
				message = "3";
			}
			logger.debug("Input Stream: " + sb.toString());
		}catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ConnectException e) {
			logger.debug("Connection refused in Medicine Pres Data To Central Server Schedular");
		}catch (SocketTimeoutException e) {
			logger.debug("Connection timeout in Medicine Pres Data To Central Server Schedular");
		}catch (IOException e) {
			e.printStackTrace();
		}
	
		
		    
		return message;
	}

}
