package jkt.hms.masters.handler;

import java.util.Map;

import jkt.hms.masters.business.MasDietCombination;
import jkt.hms.masters.business.MasDietItems;
import jkt.hms.masters.business.MasDietType;
import jkt.hms.masters.business.MasMenuType;
import jkt.hms.masters.business.MasRoomType;
import jkt.hms.masters.dataservice.CanteenMasterDataService;
import jkt.hms.util.Box;

public class CanteenMasterHandlerServiceImpl implements
		CanteenMasterHandlerService {

	CanteenMasterDataService canteenMasterDataService = null;

	// ---------------------------------Diet
	// Master-------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> addDiet(Map<String, Object> generalMap) {
		return canteenMasterDataService.addDiet(generalMap);
	}

	public boolean deleteDiet(int dietId, Map<String, Object> generalMap) {
		return canteenMasterDataService.deleteDiet(dietId, generalMap);
	}

	public Map<String, Object> editDietToDatabase(Map<String, Object> generalMap) {
		return canteenMasterDataService.editDietToDatabase(generalMap);
	}

	public Map<String, Object> searchDiet(String dietCode, String dietName) {
		return canteenMasterDataService.searchDiet(dietCode, dietName);
	}

	public Map<String, Object> showDietJsp() {
		return canteenMasterDataService.showDietJsp();
	}

	// -------------------------------Diet Type---------------------------------

	public Map<String, Object> showDietTypeJsp() {
		return canteenMasterDataService.showDietTypeJsp();
	}

	public Map<String, Object> searchDietType(String dietTypeCode,
			String dietTypeName) {
		return canteenMasterDataService.searchDietType(dietTypeCode,
				dietTypeName);
	}

	public boolean addDietType(MasDietType masDietType) {
		return canteenMasterDataService.addDietType(masDietType);
	}

	public boolean deleteDietType(int dietTypeId, Map<String, Object> generalMap) {
		return canteenMasterDataService.deleteDietType(dietTypeId, generalMap);
	}

	public boolean editDietTypeToDatabase(Map<String, Object> generalMap) {
		return canteenMasterDataService.editDietTypeToDatabase(generalMap);
	}

	// --------------------------Diet items----------------------------

	public boolean addDietItems(MasDietItems masDietItems) {
		return canteenMasterDataService.addDietItems(masDietItems);
	}

	public boolean deleteDietItems(int dietItemsId,
			Map<String, Object> generalMap) {
		return canteenMasterDataService
				.deleteDietItems(dietItemsId, generalMap);
	}

	public boolean editDietItemsToDatabase(Map<String, Object> generalMap) {
		return canteenMasterDataService.editDietItemsToDatabase(generalMap);
	}

	public Map<String, Object> searchDietItems(String dietItemsCode,
			String dietItemsName) {
		return canteenMasterDataService.searchDietItems(dietItemsCode,
				dietItemsName);
	}

	public Map<String, Object> showDietItemsJsp() {
		return canteenMasterDataService.showDietItemsJsp();
	}

	// --------------------Diet Diet Type--------------------------------------

	public boolean addDietCombination(MasDietCombination masDietCombination) {
		return canteenMasterDataService.addDietCombination(masDietCombination);
	}

	public boolean deleteDietCombination(int dietDietTypeId,
			Map<String, Object> generalMap) {
		return canteenMasterDataService.deleteDietCombination(dietDietTypeId,
				generalMap);
	}

	public boolean editDietCombination(Map<String, Object> generalMap) {
		return canteenMasterDataService.editDietCombination(generalMap);
	}

	public Map<String, Object> searchItemGeneric(String itemGenericName) {
		return canteenMasterDataService.searchItemGeneric(itemGenericName);
	}

	public Map<String, Object> showDietCombinationJsp() {
		return canteenMasterDataService.showDietCombinationJsp();
	}

	public Map<String, Object> searchDietCombination(String dietName) {
		return canteenMasterDataService.searchDietCombination(dietName);
	}

	// -------------------------Diet Menu
	// Item---------------------------------------

	public Map<String, Object> showDietMenuItemJsp() {
		return canteenMasterDataService.showDietMenuItemJsp();
	}

	public boolean addDietMenuItem(Box box) {
		return canteenMasterDataService.addDietMenuItem(box);
	}

	public boolean deleteDietMenuItem(Box box) {
		return canteenMasterDataService.deleteDietMenuItem(box);
	}

	public Map<String, Object> searchDietMenuItem(Box box) {
		return canteenMasterDataService.searchDietMenuItem(box);
	}
	public boolean editDietMenuItemToDatabase(Map<String, Object> generalMap) {
		
		return canteenMasterDataService.editDietMenuItemToDatabase(generalMap);
	}

	// ---------------------------Diet Indent
	// Item-------------------------------

	public Map<String, Object> showDietIndentItemJsp() {
		return canteenMasterDataService.showDietIndentItemJsp();
	}

	public Map<String, Object> addDietIndentItem(Box box) {
		return canteenMasterDataService.addDietIndentItem(box);
	}

	public Map<String, Object> editDietIndentItem(Box box) {
		return canteenMasterDataService.editDietIndentItem(box);
	}

	public boolean deleteDietIndentItem(Box box) {
		return canteenMasterDataService.deleteDietIndentItem(box);
	}

	public Map<String, Object> searchDietIndentItem(Box box) {
		return canteenMasterDataService.searchDietIndentItem(box);
	}

	// ------------------------------------------------------------------

	public CanteenMasterDataService getCanteenMasterDataService() {
		return canteenMasterDataService;
	}

	public void setCanteenMasterDataService(
			CanteenMasterDataService canteenMasterDataService) {
		this.canteenMasterDataService = canteenMasterDataService;
	}


	

	
	@Override
	public Map showMenuType() {
		// TODO Auto-generated method stub
		return canteenMasterDataService.showMenuType();
	}

	@Override
	public boolean addMenuType(MasMenuType masMenuType) {
		// TODO Auto-generated method stub
		return canteenMasterDataService.addMenuType(masMenuType);
	}

	@Override
	public boolean editMenuType(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return canteenMasterDataService.editMenuType(generalMap);
	}

	@Override
	public Map<String, Object> searchMenuType(String menuCode, String menuName) {
		// TODO Auto-generated method stub
		return canteenMasterDataService.searchMenuType(menuCode, menuName);
	}

	@Override
	public boolean deleteMenuType(int menuId, Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return canteenMasterDataService.deleteMenuType(menuId, generalMap);
	}
}
