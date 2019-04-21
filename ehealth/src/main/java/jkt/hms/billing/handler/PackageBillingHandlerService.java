package jkt.hms.billing.handler;

import java.util.Map;

import jkt.hms.util.Box;

public interface PackageBillingHandlerService {

	Map<String, Object> getPackageMasterList();

	Map<String, Object> getDetailsForPackageMaster();

	Map<String, Object> savePackageDetails(Box box);

	Map<String, Object> getDetailsForPackageServices(int packageId);

	Map<String, Object> savePackageServices(Box box);

	Map<String, Object> updatePackageServices(Box box);

	Map<String, Object> getDetailsForPackageMedicines(int packageId);

	Map<String, Object> getItemName(Box box);

	Map<String, Object> savePackageMedicines(Box box);

	Map<String, Object> getDispensingPriceForItem(int itemId);

	Map<String, Object> updatePackageMedicines(Box box);

	Map<String, Object> getPackageDetailsForDisplay(int packageId);

	Map<String, Object> getDetailsForUpdatePackageMaster(int packageId);

	Map<String, Object> updatePackageDetails(Box box);

	Map<String, Object> getDetailsForPackageBilling(Box box);

	Map<String, Object> getPackageDetails(int packageId);

	Map<String, Object> submitOPPkgBillingDetails(Box box);

}
