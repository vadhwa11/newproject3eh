package jkt.hms.diet.handler;

import java.util.Map;

import jkt.hms.util.Box;

public interface DietHandlerService {

	/**
	 * --------------------------- Methods for Menu Item Formula
	 * -----------------------------------
	 *
	 */

	Map<String, Object> showMenuItemFormulaJsp();

	Map<String, Object> addMenuItemFormula(Box box);

	Map<String, Object> editMenuItemFormula(Box box);

	Map<String, Object> deleteMenuItemFormula(Box box);

	Map<String, Object> searchMenuItemFormula(Box box);

	/**
	 * --------------------------- Methods for Extra Item Formula
	 * -----------------------------------
	 *
	 */

	Map<String, Object> showExtraItemFormulaJsp();

	Map<String, Object> addExtraItemFormula(Box box);

	Map<String, Object> editExtraItemFormula(Box box);

	Map<String, Object> deleteExtraItemFormula(Box box);

	Map<String, Object> searchExtraItemFormula(Box box);

	/**
	 * --------------------------- Methods for Indent Item Formula
	 * -----------------------------------
	 *
	 */

	Map<String, Object> showIndentItemFormulaJsp();

	Map<String, Object> addIndentItemFormula(Box box);

	Map<String, Object> editIndentItemFormula(Box box);

	Map<String, Object> deleteIndentItemFormula(Box box);

	Map<String, Object> searchIndentItemFormula(Box box);

	/**
	 * --------------------------- Methods for Patient Diet Change
	 * -----------------------------------
	 *
	 */

	Map<String, Object> getPatientListForDietChange(int departmentId);

	Map<String, Object> addPatientDietDetails(Box box);
	//Added by Ramdular +21-OCT-2010+
	Map<String, Object> getPendingPatientDietList(Map<String, Object> map);

	Map<String, Object> showPendingPatientDietDetails(Map<String, Object> dataMap);

	Map<String, Object> updatePatientDiet(Box box);

	Map<String, Object> getConnectionForReport();

	Map<String, Object> getDietForIndoorPatientList(Map<String, Object> map);

	Map<String, Object> updateIndoorPatientDiet(Box box);

}
