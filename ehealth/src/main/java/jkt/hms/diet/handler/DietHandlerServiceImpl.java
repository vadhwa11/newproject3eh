package jkt.hms.diet.handler;

import java.util.Map;

import jkt.hms.diet.dataservice.DietDataService;
import jkt.hms.util.Box;

public class DietHandlerServiceImpl implements DietHandlerService {

	DietDataService dietDataService = null;

	public DietDataService getDietDataService() {
		return dietDataService;
	}

	public void setDietDataService(DietDataService dietDataService) {
		this.dietDataService = dietDataService;
	}

	/**
	 * --------------------------- Methods for Menu Item Formula
	 * -----------------------------------
	 *
	 */

	public Map<String, Object> showMenuItemFormulaJsp() {
		return dietDataService.showMenuItemFormulaJsp();
	}

	public Map<String, Object> addMenuItemFormula(Box box) {
		return dietDataService.addMenuItemFormula(box);
	}

	public Map<String, Object> editMenuItemFormula(Box box) {
		return dietDataService.editMenuItemFormula(box);
	}

	public Map<String, Object> deleteMenuItemFormula(Box box) {
		return dietDataService.deleteMenuItemFormula(box);
	}

	public Map<String, Object> searchMenuItemFormula(Box box) {
		return dietDataService.searchMenuItemFormula(box);
	}

	/**
	 * --------------------------- Methods for Extra Item Formula
	 * -----------------------------------
	 *
	 */

	public Map<String, Object> showExtraItemFormulaJsp() {
		return dietDataService.showExtraItemFormulaJsp();
	}

	public Map<String, Object> addExtraItemFormula(Box box) {
		return dietDataService.addExtraItemFormula(box);
	}

	public Map<String, Object> editExtraItemFormula(Box box) {
		return dietDataService.editExtraItemFormula(box);
	}

	public Map<String, Object> deleteExtraItemFormula(Box box) {
		return dietDataService.deleteExtraItemFormula(box);
	}

	public Map<String, Object> searchExtraItemFormula(Box box) {
		return dietDataService.searchExtraItemFormula(box);
	}

	/**
	 * --------------------------- Methods for Indent Item Formula
	 * -----------------------------------
	 *
	 */

	public Map<String, Object> showIndentItemFormulaJsp() {
		return dietDataService.showIndentItemFormulaJsp();
	}

	public Map<String, Object> addIndentItemFormula(Box box) {
		return dietDataService.addIndentItemFormula(box);
	}

	public Map<String, Object> editIndentItemFormula(Box box) {
		return dietDataService.editIndentItemFormula(box);
	}

	public Map<String, Object> deleteIndentItemFormula(Box box) {
		return dietDataService.deleteIndentItemFormula(box);
	}

	public Map<String, Object> searchIndentItemFormula(Box box) {
		return dietDataService.searchIndentItemFormula(box);
	}

	/**
	 * --------------------------- Methods for Patient Diet Change
	 * -----------------------------------
	 *
	 */

	public Map<String, Object> getPatientListForDietChange(int departmentId) {
		return dietDataService.getPatientListForDietChange(departmentId);
	}

	public Map<String, Object> addPatientDietDetails(Box box) {
		return dietDataService.addPatientDietDetails(box);
	}
	//Added by Ramdular +21-OCT-2010+
	public Map<String, Object> getPendingPatientDietList(Map<String, Object> map) {
		return dietDataService.getPendingPatientDietList(map);
	}
	public Map<String, Object> showPendingPatientDietDetails(Map<String, Object> dataMap)
	{
		return dietDataService.showPendingPatientDietDetails(dataMap);
	}
	public Map<String, Object> updatePatientDiet(Box box) {
		return dietDataService.updatePatientDiet(box);
	}
	public Map<String, Object> getConnectionForReport()
	{
		return dietDataService.getConnectionForReport();
	}
	public Map<String, Object> getDietForIndoorPatientList(Map<String, Object> map)
	{
		return dietDataService.getDietForIndoorPatientList(map);
	}
	public Map<String, Object> updateIndoorPatientDiet(Box box)
	{
		return dietDataService.updateIndoorPatientDiet(box);
	}
}
