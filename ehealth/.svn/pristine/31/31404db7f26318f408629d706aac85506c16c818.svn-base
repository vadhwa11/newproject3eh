package jkt.hms.masters.dataservice;

import java.util.Map;

import jkt.hms.masters.business.MasDietCombination;
import jkt.hms.masters.business.MasDietItems;
import jkt.hms.masters.business.MasDietType;
import jkt.hms.masters.business.MasMenuType;
import jkt.hms.masters.business.MasRoomType;
import jkt.hms.util.Box;

public interface CanteenMasterDataService {

	// -----------------------------Diet Master-----------------------

	Map<String, Object> addDiet(Map<String, Object> generalMap);

	Map<String, Object> editDietToDatabase(Map<String, Object> generalMap);

	boolean deleteDiet(int dietId, Map<String, Object> generalMap);

	Map<String, Object> searchDiet(String dietCode, String dietName);

	Map<String, Object> showDietJsp();

	// --------------------------Diet Type---------------------------------
	Map<String, Object> showDietTypeJsp();

	Map<String, Object> searchDietType(String dietTypeCode, String dietTypeName);

	boolean addDietType(MasDietType masDietType);

	boolean deleteDietType(int dietTypeId, Map<String, Object> generalMap);

	boolean editDietTypeToDatabase(Map<String, Object> generalMap);

	// ------------------------Diet Items---------------------------------
	boolean deleteDietItems(int dietItemsId, Map<String, Object> generalMap);

	boolean editDietItemsToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchDietItems(String dietItemsCode,
			String dietItemsName);

	Map<String, Object> showDietItemsJsp();

	boolean addDietItems(MasDietItems masDietItems);

	// --------------------Diet Diet Type---------------------------------------

	boolean addDietCombination(MasDietCombination masDietCombination);

	boolean deleteDietCombination(int dietDietTypeId,
			Map<String, Object> generalMap);

	boolean editDietCombination(Map<String, Object> generalMap);

	Map<String, Object> searchItemGeneric(String itemGenericName);

	Map<String, Object> showDietCombinationJsp();

	Map<String, Object> searchDietCombination(String dietName);

	// -------------------------Diet Menu
	// Item---------------------------------------

	Map<String, Object> showDietMenuItemJsp();

	boolean addDietMenuItem(Box box);

	boolean deleteDietMenuItem(Box box);

	Map<String, Object> searchDietMenuItem(Box box);

	// --------------------------- Diet Indent Item
	// --------------------------------

	Map<String, Object> showDietIndentItemJsp();

	Map<String, Object> addDietIndentItem(Box box);

	Map<String, Object> editDietIndentItem(Box box);

	boolean deleteDietIndentItem(Box box);

	Map<String, Object> searchDietIndentItem(Box box);

	boolean editDietMenuItemToDatabase(Map<String, Object> generalMap);

	
	
	Map showMenuType();

	boolean addMenuType(MasMenuType masMenuType);

	boolean editMenuType(Map<String, Object> generalMap);

	Map<String, Object> searchMenuType(String menuCode, String menuName);

	boolean deleteMenuType(int menuId, Map<String, Object> generalMap);
}
