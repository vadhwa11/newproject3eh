package jkt.hms.billing.handler;

import java.util.Map;

import jkt.hms.billing.dataservice.PackageBillingDataService;
import jkt.hms.util.Box;

public class PackageBillingHandlerServiceImpl implements
		PackageBillingHandlerService {

	PackageBillingDataService packageBillingDataService = null;

	public PackageBillingDataService getPackageBillingDataService() {
		return packageBillingDataService;
	}

	public void setPackageBillingDataService(
			PackageBillingDataService packageBillingDataService) {
		this.packageBillingDataService = packageBillingDataService;
	}

	public Map<String, Object> getPackageMasterList() {
		return packageBillingDataService.getPackageMasterList();
	}

	public Map<String, Object> getDetailsForPackageMaster() {
		return packageBillingDataService.getDetailsForPackageMaster();
	}

	public Map<String, Object> savePackageDetails(Box box) {
		return packageBillingDataService.savePackageDetails(box);
	}

	public Map<String, Object> getDetailsForPackageServices(int packageId) {
		return packageBillingDataService
				.getDetailsForPackageServices(packageId);
	}

	public Map<String, Object> savePackageServices(Box box) {
		return packageBillingDataService.savePackageServices(box);
	}

	public Map<String, Object> updatePackageServices(Box box) {
		return packageBillingDataService.updatePackageServices(box);
	}

	public Map<String, Object> getDetailsForPackageMedicines(int packageId) {
		return packageBillingDataService
				.getDetailsForPackageMedicines(packageId);
	}

	public Map<String, Object> getItemName(Box box) {
		return packageBillingDataService.getItemName(box);
	}

	public Map<String, Object> savePackageMedicines(Box box) {
		return packageBillingDataService.savePackageMedicines(box);
	}

	public Map<String, Object> getDispensingPriceForItem(int itemId) {
		return packageBillingDataService.getDispensingPriceForItem(itemId);
	}

	public Map<String, Object> updatePackageMedicines(Box box) {
		return packageBillingDataService.updatePackageMedicines(box);
	}

	public Map<String, Object> getPackageDetailsForDisplay(int packageId) {
		return packageBillingDataService.getPackageDetailsForDisplay(packageId);
	}

	public Map<String, Object> getDetailsForUpdatePackageMaster(int packageId) {
		return packageBillingDataService
				.getDetailsForUpdatePackageMaster(packageId);
	}

	public Map<String, Object> updatePackageDetails(Box box) {
		return packageBillingDataService.updatePackageDetails(box);
	}

	public Map<String, Object> getDetailsForPackageBilling(Box box) {
		return packageBillingDataService.getDetailsForPackageBilling(box);
	}

	public Map<String, Object> getPackageDetails(int packageId) {
		return packageBillingDataService.getPackageDetails(packageId);
	}

	public Map<String, Object> submitOPPkgBillingDetails(Box box) {
		return packageBillingDataService.submitOPPkgBillingDetails(box);
	}

}
