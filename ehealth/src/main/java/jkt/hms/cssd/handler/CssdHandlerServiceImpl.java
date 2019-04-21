/**  
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Class 
 *  
 * Tables Used:  
 * @author  Create Date:  
 * Revision Date:      		Revision By: 
 * @version 1.0  
 * @see 
 **/

package jkt.hms.cssd.handler;

import java.util.Map;

import jkt.hms.cssd.dataservice.CssdDataService;
import jkt.hms.masters.business.CssdInstrumentMaster;
import jkt.hms.masters.business.CssdMaterialMaster;
import jkt.hms.util.Box;

public class CssdHandlerServiceImpl implements CssdHandlerService {
	CssdDataService cssdDataService = null;

	public void setCssdDataService(CssdDataService cssdDataService) {
		this.cssdDataService = cssdDataService;
	}

	public Map<String, Object> showInstrumentMasterJsp(Box box) {
		return cssdDataService.showInstrumentMasterJsp(box);
	}

	public boolean addInstrumentMaster(CssdInstrumentMaster cssdInstrumentMaster) {
		return cssdDataService.addInstrumentMaster(cssdInstrumentMaster);
	}

	public Map<String, Object> checkForExistingMasters(
			Map<String, Object> generalMap) {
		return cssdDataService.checkForExistingMasters(generalMap);
	}

	public Map<String, Object> searchInstrumentMaster(Map<String, Object> map) {
		return cssdDataService.searchInstrumentMaster(map);
	}

	public boolean editInstrumentMaster(Map<String, Object> generalMap) {
		return cssdDataService.editInstrumentMaster(generalMap);
	}

	public boolean deleteInstrumentMaster(Map<String, Object> generalMap) {
		return cssdDataService.deleteInstrumentMaster(generalMap);
	}

	public Map<String, Object> showMaterialStockEntryJsp(Box box) {
		return cssdDataService.showMaterialStockEntryJsp(box);
	}

	public Map<String, Object> getMaterialNamesForAutocomplete(
			Map<String, Object> dataMap) {
		return cssdDataService.getMaterialNamesForAutocomplete(dataMap);
	}

	public Map<String, Object> addAndRefreshGrid(Box box) {
		return cssdDataService.addAndRefreshGrid(box);
	}

	public Map<String, Object> getStockGridData(Box box) {
		return cssdDataService.getStockGridData(box);
	}

	public Map<String, Object> showAutoclaveRequestJsp(Box box) {
		return cssdDataService.showAutoclaveRequestJsp(box);
	}

	public Map<String, Object> getAutoclaveRequestMaterialNamesForAutocomplete(
			Map<String, Object> dataMap) {
		return cssdDataService
				.getAutoclaveRequestMaterialNamesForAutocomplete(dataMap);
	}

	public Map<String, Object> addAndRefreshAutoclaveRequestGrid(Box box) {
		return cssdDataService.addAndRefreshAutoclaveRequestGrid(box);
	}

	public Map<String, Object> getAutoclaveRequestStockGridData(Box box) {
		return cssdDataService.getAutoclaveRequestStockGridData(box);
	}

	public Map<String, Object> showAutoclaveEntryJsp(Box box) {
		return cssdDataService.showAutoclaveEntryJsp(box);
	}

	public Map<String, Object> showAutoclaveEntryDetailJsp(Box box) {
		return cssdDataService.showAutoclaveEntryDetailJsp(box);
	}

	public Map<String, Object> getAutoclaveRequestEntryGridDataForAutoclaveEntry(
			Box box) {
		return cssdDataService
				.getAutoclaveRequestEntryGridDataForAutoclaveEntry(box);
	}

	public Map<String, Object> submitEntryDetails(Box box) {
		return cssdDataService.submitEntryDetails(box);
	}

	public Map<String, Object> deleteCssdEntryGridItems(Box box) {
		return cssdDataService.deleteCssdEntryGridItems(box);
	}

	public Map<String, Object> showMaterialMasterJsp(Box box) {
		return cssdDataService.showMaterialMasterJsp(box);
	}

	public boolean addMaterialMaster(CssdMaterialMaster cssdMaterialMaster) {
		return cssdDataService.addMaterialMaster(cssdMaterialMaster);
	}

	public boolean deleteMaterialMaster(Map<String, Object> generalMap) {
		return cssdDataService.deleteMaterialMaster(generalMap);
	}

	public boolean editMaterialMaster(Map<String, Object> generalMap) {
		return cssdDataService.editMaterialMaster(generalMap);
	}

	public Map<String, Object> searchMaterialMaster(Map<String, Object> map) {
		return cssdDataService.searchMaterialMaster(map);
	}

	public Map<String, Object> showAutoclaveReceiptJsp(Box box) {
		return cssdDataService.showAutoclaveReceiptJsp(box);
	}

	public Map<String, Object> addAndRefreshAutoclaveReceiptGrid(Box box) {
		return cssdDataService.addAndRefreshAutoclaveReceiptGrid(box);
	}

	public Map<String, Object> getAutoclaveReceiptStockGridData(Box box) {
		return cssdDataService.getAutoclaveReceiptStockGridData(box);
	}

	public Map<String, Object> updateAutoclaveReceiptGridData(Box box) {
		return cssdDataService.updateAutoclaveReceiptGridData(box);
	}

	public Map<String, Object> getAutoclaveRecallGridData(Box box) {
		return cssdDataService.getAutoclaveRecallGridData(box);
	}

	public Map<String, Object> updateAutoclaveRecallGridData(Box box) {
		return cssdDataService.updateAutoclaveRecallGridData(box);
	}

	public Map<String, Object> getConnectionForReport() {
		return cssdDataService.getConnectionForReport();
	}

	public Map<String, Object> showAutoclaveMaterialList(Box box) {
		return cssdDataService.showAutoclaveMaterialList(box);
	}

	public String getHospitalName(int hospitalId) {
		return cssdDataService.getHospitalName(hospitalId);
	}

	// By--Mansi
	public Map<String, Object> getAutoclaveRequestInstrumentNameForAutocomplete(
			Map<String, Object> dataMap) {
		return cssdDataService.getAutoclaveRequestInstrumentNameForAutocomplete(dataMap);
	}
	public Map<String, Object> getInstrumentNamesForAutocomplete(
			Map<String, Object> dataMap) {
		return cssdDataService.getInstrumentNamesForAutocomplete(dataMap);
	}
	public Map<String, Object> showSterilizeInstrumentRecallListJsp(Box box) {
		return cssdDataService.showSterilizeInstrumentRecallListJsp(box);
	}

	public Map<String, Object> updateSterilizeInstrumentRecallList(Box box) {
		return cssdDataService.updateSterilizeInstrumentRecallList(box);
	}

	public Map<String, Object> cssdTemplate(Box box) {
		return cssdDataService.cssdTemplate(box);
	}

	public Map<String, Object> showRecordsForCssdTemplate(Box box) {
		return cssdDataService.showRecordsForCssdTemplate(box);
	}

	@Override
	public Map<String, Object> showCssdTemplateItem(
			Map<String, Object> mapDetail) {
		return cssdDataService.showCssdTemplateItem(mapDetail);
	}

	@Override
	public boolean submitCssdTemplateInstrument(Map<String, Object> map) {
		return cssdDataService.submitCssdTemplateInstrument(map);
	}

	@Override
	public Map<String, Object> showAutoclaveRequestFromTemplate(Box box) {
		return cssdDataService.showAutoclaveRequestFromTemplate(box);
	}

	@Override
	public Map<String, Object> showAutoclaveRequestFromTemplateDetail(Box box) {
		return cssdDataService.showAutoclaveRequestFromTemplateDetail(box);
	}

	@Override
	public Map<String, Object> saveAndRefreshAutoclaveRequestGrid(Box box) {
		return cssdDataService.saveAndRefreshAutoclaveRequestGrid(box);
	}

	public Map<String, Object> getAutoclaveRequestStockGridDataForTemplate(
			Box box) {
		return cssdDataService.getAutoclaveRequestStockGridDataForTemplate(box);
	}

	@Override
	public Map<String, Object> getItemForAutoComplete(Box box) {
		return cssdDataService.getItemForAutoComplete(box);
	}

	@Override
	public Map<String, Object> searchCssdTemplateInstrument(String itemName,int cssdTemplateId) {
		return cssdDataService.searchCssdTemplateInstrument(itemName,cssdTemplateId);
	}
	
}
