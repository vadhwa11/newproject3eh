package jkt.hms.stores.handler;



import java.util.Map;

import jkt.hms.stores.dataservice.ColdChainDataService;
import jkt.hms.util.Box;



public class ColdChainHandlerServiceImpl implements	ColdChainHandlerService {


	ColdChainDataService coldChainDataService = null;

	public ColdChainDataService getColdChainDataService() {
		return coldChainDataService;
	}

	public void setColdChainDataService(ColdChainDataService coldChainDataService) {
		this.coldChainDataService = coldChainDataService;
	}

	@Override
	public Map<String, Object> showColdChainManagementJsp(Box box,Map<String, Object> dataMap) {
		return coldChainDataService.showColdChainManagementJsp(box,dataMap);
	}

	@Override
	public Map<String, Object> showTemperatureTrackerJsp(Box box,Map<String, Object> dataMap) {
		return coldChainDataService.showTemperatureTrackerJsp(box, dataMap);
	}

	@Override
	public Map<String, Object> showPendingListForRefrigeratorAllocation(Box box) {
		// TODO Auto-generated method stub
		return coldChainDataService.showPendingListForRefrigeratorAllocation(box);
	}

	@Override
	public Map<String, Object> searchForRefrigeratorAllocation(Box box) {
	
		return coldChainDataService.searchForRefrigeratorAllocation(box);
	}

	@Override
	public Map<String, Object> showRefrigeratorColdRoomAllocationJsp(Box box) {
		
		return coldChainDataService.showRefrigeratorColdRoomAllocationJsp(box);
	}

	@Override
	public Map<String, Object> submitColdRoomAllocation(Box box) {
		
		return coldChainDataService.submitColdRoomAllocation(box);
	}

	@Override
	public Map<String, Object> showTemperatureMonitoringJsp(Box box) {
		
		return coldChainDataService.showTemperatureMonitoringJsp(box);
	}

	@Override
	public Map<String, Object> submitTemperatureMonitoring(Box box) {
		
		return coldChainDataService.submitTemperatureMonitoring(box);
	}

	@Override
	public Map<String, Object> showPendingListForPotencyCheck(Box box) {
		
		return coldChainDataService.showPendingListForPotencyCheck(box);
	}

	@Override
	public Map<String, Object> showTemperatureValidationJsp(Box box) {
	
		return coldChainDataService.showTemperatureValidationJsp(box);
	}

	@Override
	public Map<String, Object> submitTemperatureValidation(Box box) {
		
		return coldChainDataService.submitTemperatureValidation(box);
	}

	@Override
	public Map<String, Object> showTransferPendingList(Box box) {
		
		return coldChainDataService.showTransferPendingList(box);
	}

	@Override
	public Map<String, Object> showRefrigeratorColdRoomReAllocationJsp(Box box) {
		
		return coldChainDataService.showRefrigeratorColdRoomReAllocationJsp(box);
	}

	@Override
	public Map<String, Object> submitColdRoomReAllocation(Box box) {
	
		return coldChainDataService.submitColdRoomReAllocation(box);
	}

	@Override
	public Map<String, Object> showDashBoardOfTemperatureMonitoringJsp(Box box) {
		
		return coldChainDataService.showDashBoardOfTemperatureMonitoringJsp(box);
	}

	@Override
	public Map<String, Object> searchForTemperatureMonitoringDashBord(Box box) {
		
		return coldChainDataService.searchForTemperatureMonitoringDashBord(box);
	}

	@Override
	public Map<String, Object> showRefrigeratorAllocationPopup(Box box) {
	
		return coldChainDataService.showRefrigeratorAllocationPopup(box);
	}

	@Override
	public Map<String, Object> getRefrigeratorTemperature(Box box) {
		// TODO Auto-generated method stub
		return coldChainDataService.getRefrigeratorTemperature(box);
	}

	@Override
	public Map<String, Object> getRefrigeratorSerialNo(Box box) {
		
		return coldChainDataService.getRefrigeratorSerialNo(box);
	}




}
