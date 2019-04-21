package jkt.hms.purchaseOrder.dataservice;

import static jkt.hms.util.RequestConstants.FROM_WARD;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import jkt.hms.masters.business.HospitalParameters;
import jkt.hms.masters.business.MasAuthorizer;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDiscount;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasItemCategory;
import jkt.hms.masters.business.MasManufacturer;
import jkt.hms.masters.business.MasSalesTaxType;
import jkt.hms.masters.business.MasSetupParameterMaintaince;
import jkt.hms.masters.business.MasStoreBrand;
import jkt.hms.masters.business.MasStoreBudget;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.MasStoreGroup;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStorePoDeliveryTerms;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.StoreFyDocumentNo;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.StorePoDetail;
import jkt.hms.masters.business.StorePoHeader;
import jkt.hms.masters.business.StoreSetup;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


public class PurchaseOrderDataServiceImpl extends HibernateDaoSupport implements
		PurchaseOrderDataService {
	/*
	 * Code for read from property file from src package
	 */
	Properties properties = new Properties();{
	try{
				ClassLoader loader =getClass().getClassLoader();
				InputStream inStream = loader.getResourceAsStream("stores.properties");
		        properties.load(inStream);
		        }catch (IOException e) {
		    	//
		    	e.printStackTrace();
		       }
	}
	/*
	 * Logger Implemented By Mukesh Narayan Singh
	 * Date 07 Oct 2010
	 */
	static final Logger log = Logger.getLogger(jkt.hms.purchaseOrder.dataservice.PurchaseOrderDataServiceImpl.class);


	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> submitPurchaseOrderBelowReorder(Box box, int departmentId, String loginName,int hospitalId)
	{
		Map<String, Object> poMap = new HashMap<String, Object>();
		Boolean flag = false;
		ArrayList checkBoxVal = box.getArrayList("parent");
		String date = "";
		String time = "";
		Session session = (Session) getSession();
		Transaction transaction = null;
		List<String> poList = new ArrayList<String>();
		

		try
		{
			Set<Integer> supplierSet = new HashSet<Integer>();
			List<Integer> itemIdList = new ArrayList<Integer>();
			List<Integer> supplierIdList = new ArrayList<Integer>();
			List<String> auList = new ArrayList<String>();
			List<Integer> rolIdList = new ArrayList<Integer>();
			List<Integer> stockQtyIdList = new ArrayList<Integer>();
			List<Integer> reqQtyIdList = new ArrayList<Integer>();
			List<BigDecimal> costPriceList = new ArrayList<BigDecimal>();
			List<Integer> saleTaxList = new ArrayList<Integer>();
			List<Integer> manufacIdList = new ArrayList<Integer>();

			for (int i = 0; i < checkBoxVal.size(); i++)
			{
				if (checkBoxVal.get(i) != null && !checkBoxVal.get(i).equals(""))
				{
					Integer SNo = Integer.parseInt((String)checkBoxVal.get(i));

					Integer itemId = Integer.parseInt((String)box.getString("itemID"+SNo));
					itemIdList.add(itemId);

					String AU = box.getString("AU"+SNo);
					auList.add(AU);

					Integer rol = Integer.parseInt((String)box.getString("rol"+SNo));
					rolIdList.add(rol);

					Integer stockQty = Integer.parseInt((String)box.getString("stockQty"+SNo));
					stockQtyIdList.add(stockQty);

					Integer reqQty = Integer.parseInt((String)box.getString("reqQty"+SNo));
					reqQtyIdList.add(reqQty);
					Integer supplierId =0;
					if(box.getString("supplierId"+SNo) != null && !box.getString("supplierId"+SNo).equals("") )
					{
						supplierId= Integer.parseInt((String)box.getString("supplierId"+SNo));
						supplierIdList.add(supplierId);
						supplierSet.add(supplierId);

					}/*else
					{
						supplierId= 1;
						supplierIdList.add(supplierId);

					}*/
					 
					if(box.getString("costPrice"+SNo) != null && !box.getString("costPrice"+SNo).equals("") )
					{
						String costPrice = box.getString("costPrice"+SNo);
						BigDecimal itemCostPrice = new BigDecimal(costPrice);
						costPriceList.add(itemCostPrice);
					}
					/*else
					{
						BigDecimal itemCostPrice = new BigDecimal(1);
						costPriceList.add(itemCostPrice);
					}*/

					Integer saleTaxId=1;
					if(!box.getString("saleTaxId"+SNo).equalsIgnoreCase("null") && !box.getString("saleTaxId"+SNo).equals("") )
					{
						saleTaxId = Integer.parseInt((String)box.getString("saleTaxId"+SNo));
						saleTaxList.add(saleTaxId);
					}
					/*else
					{
						saleTaxId = 1;
						saleTaxList.add(saleTaxId);
					}*/
					Integer manuFacId =1;
					if(!box.getString("manufacID"+SNo).equalsIgnoreCase("null") && !box.getString("manufacID"+SNo).equals("") )
					{
						manuFacId= Integer.parseInt((String)box.getString("manufacID"+SNo));
						manufacIdList.add(manuFacId);
					}
					/*else
					{
						 manuFacId = 1;
						manufacIdList.add(manuFacId);
					}*/
					

					
				}
			}

			if(supplierSet.size()>0)
			{
				int counter = 0;
				for (Integer supplierSetId : supplierSet)
				{
					List<Integer> itemIdListTemp = new ArrayList<Integer>();
					List<String> auListTemp = new ArrayList<String>();
					List<Integer> rolIdListTemp = new ArrayList<Integer>();
					List<Integer> stockQtyIdListTemp = new ArrayList<Integer>();
					List<Integer> reqQtyIdListTemp = new ArrayList<Integer>();
					List<BigDecimal> costPriceListTemp = new ArrayList<BigDecimal>();
					List<Integer> saleTaxListTemp = new ArrayList<Integer>();
					List<Integer> manufacListTemp = new ArrayList<Integer>();

					BigDecimal costPrice = new BigDecimal(0);
					BigDecimal salesTax = new BigDecimal(0);
					BigDecimal totalAmt = new BigDecimal(0);
					BigDecimal sumtotalAmt = new BigDecimal(0);
					BigDecimal taxPercent;
					Integer reqQty;

					for (Integer supplierListId : supplierIdList)
					{
						if(supplierListId == supplierSetId)
						{
							if(itemIdList.get(counter)!= null)
							{
								itemIdListTemp.add(itemIdList.get(counter));
							}

							if(auList.get(counter)!= null)
							{
								auListTemp.add(auList.get(counter));
							}

							if(rolIdList.get(counter)!=null)
							{
								rolIdListTemp.add(rolIdList.get(counter));
							}

							if(stockQtyIdList.get(counter)!=null)
							{
								stockQtyIdListTemp.add(stockQtyIdList.get(counter));
							}

							if(reqQtyIdList.get(counter)!=null)
							{
								reqQtyIdListTemp.add(reqQtyIdList.get(counter));
							}
							//reqQty = reqQtyIdListTemp.get(counter);
							reqQty =reqQtyIdList.get(counter);

							if(costPriceList.get(counter)!=null)
							{
								costPriceListTemp.add(costPriceList.get(counter));
								costPrice = (BigDecimal)costPriceList.get(counter);
							}
							else
							{
								costPrice = new BigDecimal(1);
							}

							if(saleTaxList.get(counter)!=null)
							{
								saleTaxListTemp.add(saleTaxList.get(counter));
							}

							if(manufacIdList.get(counter)!=null)
							{
								manufacListTemp.add(manufacIdList.get(counter));
							}

							Integer taxId = saleTaxList.get(counter);

							List<MasSalesTaxType> searchTaxList = new ArrayList<MasSalesTaxType>();
							searchTaxList = getHibernateTemplate().find("from jkt.hms.masters.business.MasSalesTaxType as mst where mst.Id = "+taxId);
							if(searchTaxList.size() > 0)
							{
								salesTax = searchTaxList.get(0).getSaleTax();
							}

							if(totalAmt.intValue() > 0)
							{
								sumtotalAmt = totalAmt;
							}

							totalAmt = new BigDecimal(reqQty).multiply(costPrice);
							if(salesTax.intValue() != 0)
							{
								taxPercent = totalAmt.multiply(salesTax.divide(new BigDecimal(100)));
								totalAmt = totalAmt.add(taxPercent);
							}
							sumtotalAmt = sumtotalAmt.add(totalAmt);
						}
						++counter;
					}

					HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);

					if(itemIdListTemp.size()>0)
					{
						StorePoHeader storePoHeader = new StorePoHeader();
						StorePoDetail storePoDetail = null;
						List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
						String signingAuthority = "";
						String max = "";
						String no = "";
						String poCode="";
						String MaxPoNo = "";
						java.util.Date poDate = null;
						BigDecimal poAmount = null;

						Map<String, Object> utilMap = new HashMap<String, Object>();
						utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
						date = (String) utilMap.get("currentDate");
						time = (String) utilMap.get("currentTime");

						List<HospitalParameters> hospitalParametersList = new ArrayList<HospitalParameters>();
						hospitalParametersList=session.createCriteria(HospitalParameters.class).add(Restrictions.eq("DeptIdStoreCodeRKS", departmentId)).list();

						if(hospitalParametersList.size()>0)
						{
							poCode = properties.getProperty("store.store_po_code_rks");
						}
						else
						{
							hospitalParametersList=session.createCriteria(HospitalParameters.class).add(Restrictions.eq("DeptIdStoreCodeVBCH", departmentId)).list();
							if(hospitalParametersList.size()>0)
							{
								poCode = properties.getProperty("store.store_po_code_vbch");
							}
						}

						storeFyDocumentNoList = session.createQuery("from jkt.hms.masters.business.StoreFyDocumentNo as inp where inp.Department.Id = "+ departmentId +" and Hospital.Id = "+hospitalId).list();
						List<MasSetupParameterMaintaince> masSetupParameterMaintainceList = session.createCriteria(MasSetupParameterMaintaince.class).list();
						if (masSetupParameterMaintainceList != null && masSetupParameterMaintainceList.size() > 0)
						{
							signingAuthority = masSetupParameterMaintainceList.get(0).getPoSignatoryOfficer();
						}
						if (storeFyDocumentNoList != null && storeFyDocumentNoList.size() > 0)
						{
							StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) storeFyDocumentNoList.get(0);
							no = ("" + storeFyDocumentNo.getPoNo());
						}

						try
						{
							max = getMaxNo(no,poCode);
						}
						catch (Exception e)
						{
							e.printStackTrace();
						}

						transaction = session.beginTransaction();

						List<StoreFyDocumentNo> fyList = session.createCriteria(StoreFyDocumentNo.class)
						.add(Restrictions.eq("Department.Id", departmentId)).list();
						if (fyList != null && fyList.size() > 0)
						{
							StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) fyList.get(0);
							MaxPoNo = ("" + storeFyDocumentNo.getPoNo());
							MaxPoNo = getMaxNo(MaxPoNo,poCode);
							storeFyDocumentNo.setPoNo(MaxPoNo);
							HibernateTemplate hbt2 = getHibernateTemplate();
							hbt2.setFlushModeName("FLUSH_EAGER");
							hbt2.update(storeFyDocumentNo);
						}

						storePoHeader.setPoNumber(max);
						storePoHeader.setPoDate(HMSUtil.convertStringTypeDateToDateType(date));
						MasStoreSupplier supplier = new MasStoreSupplier();
						supplier.setId(supplierSetId);
						storePoHeader.setSupplier(supplier);
						storePoHeader.setQuotationNumber("");
						storePoHeader.setQuotationDate(HMSUtil.convertStringTypeDateToDateType(date));
						storePoHeader.setDeliveryDate(HMSUtil.convertStringTypeDateToDateType(date));
						storePoHeader.setRemarks("");
						storePoHeader.setPayTerms("Monthly");
						storePoHeader.setDeliveryTerms("One Time");
						//commented for maven
						/*storePoHeader.setPOGeneratedThrough("Auto");*/
						storePoHeader.setSigningAuthority(signingAuthority);
						storePoHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
						storePoHeader.setLastChgTime(time);
						//commented for maven
						/*storePoHeader.setStatus("o");*/
						storePoHeader.setNetAmount(sumtotalAmt);
						Users users = new Users();
						users.setId(box.getInt("userId"));
						storePoHeader.setLastChgBy(users);
						MasDepartment masDepartment = new MasDepartment();
						masDepartment.setId(departmentId);
						storePoHeader.setDepartment(masDepartment);
						MasHospital masHospital = new MasHospital();
						masHospital.setId(hospitalId);
						storePoHeader.setHospital(masHospital);
						storePoHeader.setPoTime(time);

						poDate = (java.util.Date) storePoHeader.getPoDate();
						poAmount = storePoHeader.getNetAmount();

						hbt.save(storePoHeader);
						hbt.refresh(storePoHeader);
						int poId = storePoHeader.getId();
						poMap.put("poId", poId);

						poList.add(max);

						int count = 0;

						for (Integer itemId : itemIdListTemp)
						{
							storePoDetail = new StorePoDetail();
							BigDecimal ItemtaxPercent;
							BigDecimal ItemtotalAmt;

							if(costPriceListTemp.get(count) != null)
							{
								ItemtotalAmt = new BigDecimal(reqQtyIdListTemp.get(count)).multiply(costPriceListTemp.get(count));
							}
							else
							{
								ItemtotalAmt = new BigDecimal(reqQtyIdListTemp.get(count)).multiply(new BigDecimal(1));
							}


							if(saleTaxListTemp.get(count).intValue() != 0)
							{
								BigDecimal ItemsalesTax = new BigDecimal(0);
								List<MasSalesTaxType> searchTaxList = new ArrayList<MasSalesTaxType>();
								searchTaxList = getHibernateTemplate().find("from jkt.hms.masters.business.MasSalesTaxType as mst where mst.Id = "+saleTaxListTemp.get(count).intValue());
								if(searchTaxList.size() > 0)
								{
									ItemsalesTax = searchTaxList.get(0).getSaleTax();
								}

								ItemtaxPercent = ItemtotalAmt.multiply(ItemsalesTax.divide(new BigDecimal(100)));
								ItemtotalAmt = ItemtotalAmt.add(ItemtaxPercent);
							}

							storePoDetail.setPo(storePoHeader);
							//commented for maven
							/*storePoDetail.setSerialNo(count+1);*/
							MasStoreItem masItem = new MasStoreItem();
							masItem.setId(itemId);
							storePoDetail.setItem(masItem);
							storePoDetail.setQuantityOrdered(new BigDecimal(reqQtyIdListTemp.get(count)));
							storePoDetail.setFreeQuantity(new BigDecimal("0"));
							storePoDetail.setTaxPercent(new BigDecimal(saleTaxListTemp.get(count)));
							storePoDetail.setDiscountAmount(null);
							storePoDetail.setAmount(ItemtotalAmt);
							storePoDetail.setUnitRate(costPriceListTemp.get(count));
							storePoDetail.setDiscountPercent(new BigDecimal(0));
							storePoDetail.setFreeItem("n");
							MasManufacturer masManufacturer = new MasManufacturer();
							masManufacturer.setId(Integer.parseInt(manufacListTemp.get(count).toString()));
							storePoDetail.setManufacturer(masManufacturer);
							storePoDetail.setNotes("");
							storePoDetail.setQuantityReceived(null);
							storePoDetail.setTaxAmount(null);
							storePoDetail.setDispType(auListTemp.get(count));
							storePoDetail.setMdqValue(new BigDecimal(1));
							storePoDetail.setRatePerMdq(new BigDecimal(1).multiply(costPriceListTemp.get(count)));
							//commented for maven
							/*storePoDetail.setBrand(null);*/
							storePoDetail.setMrp(new BigDecimal(0));
							storePoDetail.setOtherTaxes(new BigDecimal(0));
							hbt.save(storePoDetail);

							count++;
						}

						List<MasStoreFinancial> masStoreFinancialList = new ArrayList<MasStoreFinancial>();
						masStoreFinancialList = session.createCriteria(MasStoreFinancial.class).list();
						java.util.Date start_date = null;
						java.util.Date end_date = null;
						int financial_id = 0;
						for (Iterator iterator = masStoreFinancialList.iterator(); iterator.hasNext();)
						{
							MasStoreFinancial masStoreFinancial = (MasStoreFinancial) iterator.next();
							start_date = (java.util.Date) masStoreFinancial.getStartDate();
							end_date = (java.util.Date) masStoreFinancial.getEndDate();
							if (poDate.after(start_date) && poDate.before(end_date))
							{
								financial_id = masStoreFinancial.getId();
								break;
							}
							else if (poDate.equals(start_date) || poDate.equals(end_date))
							{
								financial_id = masStoreFinancial.getId();
								break;
							}
						}

						List<MasStoreBudget> masStoreBudgetList = new ArrayList<MasStoreBudget>();
						masStoreBudgetList = session.createCriteria(MasStoreBudget.class)
						.add(Restrictions.eq("Financial.Id", financial_id)).list();
						BigDecimal existing_committed_amount = null;
						if (masStoreBudgetList != null && masStoreBudgetList.size() > 0)
						{
							MasStoreBudget masStoreBudget = masStoreBudgetList.get(0);
							try
							{
								existing_committed_amount = masStoreBudget.getPoComittedAmount();
							}
							catch (Exception e)
							{
								existing_committed_amount = new BigDecimal(0);
							}

							masStoreBudget.setPoComittedAmount(existing_committed_amount.add(poAmount));
							hbt.update(masStoreBudget);
						}
						transaction.commit();
					}
					counter = 0;
				}
				flag = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//flag = false;
			
			//if (transaction != null)
			//{
				transaction.rollback();
			//}
		}
		/*finally
		{
			if(session!=null){
				session.close();
			}
		}*/
		poMap.put("flag", flag);
		poMap.put("poList", poList);
		return poMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showPurchaseOrderJsp(int deptId,int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> storeList = new ArrayList<MasDepartment>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		// List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<MasDiscount> discountList = new ArrayList<MasDiscount>();
		List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		String max = "";
		String no = "";
		String signingAuthority = "";
		Session session = (Session) getSession();
		/*HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);*/
		boolean accessFlag=false;
		try{

			List<HospitalParameters> hospitalParametersList = new ArrayList<HospitalParameters>();
			//
			hospitalParametersList=session.createCriteria(HospitalParameters.class)
			.add(Restrictions.eq("DeptIdStoreCodeRKS", deptId)).list();
			String poCode="";

			if(hospitalParametersList.size()>0){
				/**/
				poCode=properties.getProperty("store.store_po_code_rks");
				accessFlag=true;
			}else if(deptId==192){
				/**/
				hospitalParametersList=session.createCriteria(HospitalParameters.class)
				.add(Restrictions.eq("DeptIdStoreCodeNursingCollege", deptId)).list();
				if(hospitalParametersList.size()>0){
					poCode=properties.getProperty("store.store_nursing_po_code");
					accessFlag=true;
				}
				
			
				
				
			}else if(deptId==194){
				
				//
				hospitalParametersList=session.createCriteria(HospitalParameters.class)
				.add(Restrictions.eq("DeptIdStoreCodeSickel", deptId)).list();
				if(hospitalParametersList.size()>0){
					poCode=properties.getProperty("store.store_sickel_po_code");
					accessFlag=true;
				}			
			}else if(deptId==201){
				
				//
				hospitalParametersList=session.createCriteria(HospitalParameters.class)
				.add(Restrictions.eq("DeptIdStoreCodeKhanvel", deptId)).list();
				if(hospitalParametersList.size()>0){
					poCode=properties.getProperty("store.store_po_code_khanvel");
					accessFlag=true;
				}			
			}else if(deptId==206){
				
				//
				hospitalParametersList=session.createCriteria(HospitalParameters.class)
				.add(Restrictions.eq("DeptIdStoreCodeDhms", deptId)).list();
				if(hospitalParametersList.size()>0){
					poCode=properties.getProperty("store.store_po_code_DHMS");
					accessFlag=true;
				}			
			}
			
			
			else{
				/**/
				hospitalParametersList=session.createCriteria(HospitalParameters.class)
				.add(Restrictions.eq("DeptIdStoreCodeVBCH", deptId)).list();
				if(hospitalParametersList.size()>0){
					poCode=properties.getProperty("store.store_po_code_vbch");
					accessFlag=true;
				}
				
			}
			//poCode="MS/"+poCode+"/STORE/";
			//
			//
			if(accessFlag){
				storeList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
				supplierList = session.createCriteria(MasStoreSupplier.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("SupplierName")).list();
				// itemList = hbt.find("from jkt.hms.masters.business.MasStoreItem as ma
				// where ma.Id < 100");
				// itemList =
				// session.createCriteria(MasStoreItem.class).add(Restrictions.eq("Status",
				// "y")).list();
				discountList = session.createCriteria(MasDiscount.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
				manufacturerList = session.createCriteria(MasManufacturer.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
				// storeFyDocumentNoList =
				// session.createCriteria(StoreFyDocumentNo.class).add(Restrictions.eq("Department.Id",
				// deptId)).list();
				storeFyDocumentNoList = session.createQuery("from jkt.hms.masters.business.StoreFyDocumentNo as inp where inp.Department.Id = "+ deptId+" and inp.Hospital.Id = "+hospitalId).list();
				List<MasSetupParameterMaintaince> masSetupParameterMaintainceList = session.createCriteria(MasSetupParameterMaintaince.class).list();
				if (masSetupParameterMaintainceList != null && masSetupParameterMaintainceList.size() > 0) {
					signingAuthority = masSetupParameterMaintainceList.get(0).getPoSignatoryOfficer();
				}
				// storeFyDocumentNoList = session.createSQLQuery("select po_no from
				// store_fy_document_no as syd where syd.department_id="+
				// deptId).list();

				// for (StoreFyDocumentNo storeFyDocumentNo :storeFyDocumentNoList ) {
				/*
				 * if(storeFyDocumentNo.getDepartment().getId() == deptId) {
				 */
				if (storeFyDocumentNoList != null && storeFyDocumentNoList.size() > 0) {
					StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) storeFyDocumentNoList
					.get(0);
					// startNo=(""+storeFyDocumentNo.getPoStartNo());
					no = ("" + storeFyDocumentNo.getPoNo());
				}
				// }
				// }
				try {
					/*
					 * Code Commented By Mukesh Narayan Singh
					 * Date 11 Oct 2010
					 */
					max = getMaxNo(no,poCode);

				} catch (Exception e) {
					e.printStackTrace();
				}
				map.put("max", max);
			}
			/**/

			map.put("accessFlag", accessFlag);
			map.put("storeList", storeList);
			map.put("supplierList", supplierList);
			// map.put("itemList", itemList);
			map.put("discountList", discountList);
			map.put("manufacturerList", manufacturerList);
			map.put("signingAuthority", signingAuthority);

		}catch (Exception e) {
			e.printStackTrace();
			
		}/*finally{
			*//**
			 * session.close() is done By Mukesh Narayan Singh
			 * Date 07 Oct 2010
			 *//*
			if(session!=null){
				session.close();
			}
		}*/
		return map;
	}
	public String getMaxNo(String no,String poCode) {
		String sequenceNo="";
		try{
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String currentDate="";
			currentDate = (String) utilMap.get("currentDate");
			String financialYear="";
			financialYear=HMSUtil.getfinancialYear(currentDate);
			String[] str = no.split("/");
			
			String seqNo="";
			int sequenceCounter=0;
			/*("no--------->"+no);*/
			if(!no.equalsIgnoreCase("")){
			try{
				if(str[4]!=""){
					seqNo=str[4];
					if(seqNo!="" && seqNo!=null){
						sequenceCounter=Integer.parseInt(seqNo)+1;
					}else{
						sequenceCounter=1;
					}
				}else{
					sequenceCounter=1;
				}
			}catch (ArrayIndexOutOfBoundsException e) {
				sequenceCounter=1;
				e.printStackTrace();
			}
			}else{
				sequenceCounter=1;
			}
			sequenceNo=poCode+""+financialYear+"/"+sequenceCounter;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return sequenceNo;
	}
	/*
	 * This method is user to evaluate auto generated number based on the year
	 * It takes one parameter that is coming from store_fy_document_no
	 */
	/*
	public String getMaxNo(String no) {
		String maxNo = "";
		int tempMonth = 0;
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		int currentMonth = gregorianCalendar.get(Calendar.MONTH) + 1;
		String currentYear = "" + gregorianCalendar.get(Calendar.YEAR);

		try {
			if (!no.equals("")) {
				StringTokenizer stringTokenizer = new StringTokenizer(no, "/");
				tempMonth = Integer.parseInt(stringTokenizer.nextToken());

				String arr[] = no.split("/");
				// for no also containging month

				if (arr.length > 2) {
					if (currentMonth == (Integer.parseInt(arr[1]))) {
						tempMonth++;
					} else {
						tempMonth = 01;
					}
				}

				if (currentMonth < 4) {

					maxNo = tempMonth + "/" + currentMonth + "/" + currentYear;
				} else {
					maxNo = tempMonth + "/" + currentMonth + "/" + currentYear;
				}

			} else {
				if (currentMonth < 4) {
					maxNo = "01" + "/" + currentMonth + "/" + currentYear;
				} else {
					maxNo = "01" + "/" + currentMonth + "/" + currentYear;
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return maxNo;
	}
*/
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitPurchaseOrder(Map<String, Object> infoMap) {
		boolean flag = false;
		StorePoHeader storePoHeader = null;
		List<StorePoDetail> poDetailList = new ArrayList<StorePoDetail>();
		Map<String, Object> poMap = new HashMap<String, Object>();
		int departmentId = 0;
		int hospitalId = 0;
		String no = "";
		java.util.Date poDate = null;
		BigDecimal poAmount = null;

		if (infoMap.get("storePoHeader") != null) {
			storePoHeader = (StorePoHeader) infoMap.get("storePoHeader");
		}
		if (infoMap.get("departmentId") != null) {
			departmentId = (Integer) infoMap.get("departmentId");
		}
		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap.get("hospitalId");
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Session session = (Session) getSession();
		Transaction transaction = null;

		try {

			List<HospitalParameters> hospitalParametersList = new ArrayList<HospitalParameters>();
			/**/
			hospitalParametersList=session.createCriteria(HospitalParameters.class)
			.add(Restrictions.eq("DeptIdStoreCodeRKS", departmentId)).list();
			int departmentIdForPOCode=0;
			String poCode="";

			if(hospitalParametersList.size()>0){
				/**/
				for (HospitalParameters hospitalParameters : hospitalParametersList) {
					departmentIdForPOCode=hospitalParameters.getDeptIdStoreCodeRKS();
				}

				poCode=properties.getProperty("store.store_po_code_rks");
			}else{
				/**/
				hospitalParametersList=session.createCriteria(HospitalParameters.class)
				.add(Restrictions.eq("DeptIdStoreCodeVBCH", departmentId)).list();
				if(hospitalParametersList.size()>0){
					for (HospitalParameters hospitalParameters : hospitalParametersList) {
						departmentIdForPOCode=hospitalParameters.getDeptIdStoreCodeVBCH();
					}
					poCode=properties.getProperty("store.store_po_code_vbch");
				}
			}
			//poCode="MS/"+poCode+"/STORE/";

			transaction = session.beginTransaction();
			if (!(infoMap.get("headerStored") + "").equals("yes")) {

				List<StoreFyDocumentNo> fyList = session
						.createCriteria(StoreFyDocumentNo.class)
						.add(Restrictions.eq("Department.Id", departmentId)).add(Restrictions.eq("Hospital.Id", hospitalId))
						.list();
				System.out.println("fyList==="+fyList.size());
				if (fyList != null && fyList.size() > 0) {
					StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) fyList
							.get(0);
					no = ("" + storeFyDocumentNo.getPoNo());
					no = getMaxNo(no,poCode);
					storeFyDocumentNo.setPoNo(no);
					HibernateTemplate hbt2 = getHibernateTemplate();
					hbt2.setFlushModeName("FLUSH_EAGER");
					hbt2.update(storeFyDocumentNo);
				} else {
					StoreFyDocumentNo storeFyDocumentNo = new StoreFyDocumentNo();
					String issueDeptReturnNo = "";
					storeFyDocumentNo.setIssueDeptReturnNo(issueDeptReturnNo);
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(departmentId);
					storeFyDocumentNo.setDepartment(masDepartment);
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					storeFyDocumentNo.setHospital(masHospital);
					no = getMaxNo(no,poCode);
					storeFyDocumentNo.setPoNo(no);
					hbt.save(storeFyDocumentNo);
					hbt.refresh(storeFyDocumentNo);

				}

				poDate = (java.util.Date) storePoHeader.getPoDate();
				poAmount = storePoHeader.getNetAmount();
				storePoHeader.setPoNumber(no);
				hbt.save(storePoHeader);
				int poId = storePoHeader.getId();
				poMap.put("poId", poId);
			} else {
				int id = Integer.parseInt("" + infoMap.get("poId"));
				storePoHeader = (StorePoHeader) getHibernateTemplate().load(
						StorePoHeader.class, id);
				poDate = (java.util.Date) storePoHeader.getPoDate();
				storePoHeader.setNetAmount(new BigDecimal(infoMap.get(
						"totalAmount").toString()));
				hbt.update(storePoHeader);

			}
			if (infoMap.get("poDetailList") != null) {
				poDetailList = (List<StorePoDetail>) infoMap
						.get("poDetailList");
				if (poDetailList.size() > 0) {
					StorePoHeader storePoHeaderObj = new StorePoHeader();
					if ((infoMap.get("headerStored") + "").equals("yes")) {
						int id = Integer.parseInt("" + infoMap.get("poId"));
						storePoHeaderObj.setId(id);
					}
					for (int i = 0; i < poDetailList.size(); i++) {
						StorePoDetail storePoDetailObj = (StorePoDetail) poDetailList
								.get(i);
						if ((infoMap.get("headerStored") + "").equals("yes")) {
							storePoDetailObj.setPo(storePoHeaderObj);
							hbt.save(storePoDetailObj);
						} else {
							storePoDetailObj.setPo(storePoHeader);
							hbt.save(storePoDetailObj);
						}

					}
					int pageNo = 0;
					String poNumber = "";
					pageNo = Integer.parseInt("" + infoMap.get("pageNo"));
					poNumber = (String) infoMap.get("poNumber");

				}
			}

			List<MasStoreFinancial> masStoreFinancialList = new ArrayList<MasStoreFinancial>();
			masStoreFinancialList = session.createCriteria(
					MasStoreFinancial.class).list();
			java.util.Date start_date = null;
			java.util.Date end_date = null;
			int financial_id = 0;

			for (Iterator iterator = masStoreFinancialList.iterator(); iterator
					.hasNext();) {
				MasStoreFinancial masStoreFinancial = (MasStoreFinancial) iterator
						.next();
				start_date = (java.util.Date) masStoreFinancial.getStartDate();
				end_date = (java.util.Date) masStoreFinancial.getEndDate();
				if (poDate.after(start_date) && poDate.before(end_date)) {
					financial_id = masStoreFinancial.getId();
					break;
				} else if (poDate.equals(start_date) || poDate.equals(end_date)) {
					financial_id = masStoreFinancial.getId();
					break;
				}
			}

			List<MasStoreBudget> masStoreBudgetList = new ArrayList<MasStoreBudget>();
			masStoreBudgetList = session.createCriteria(MasStoreBudget.class)
					.add(Restrictions.eq("Financial.Id", financial_id)).list();
			BigDecimal existing_committed_amount = null;
			if (masStoreBudgetList != null && masStoreBudgetList.size() > 0) {
				MasStoreBudget masStoreBudget = masStoreBudgetList.get(0);
				try {
					existing_committed_amount = masStoreBudget
							.getPoComittedAmount();
				} catch (Exception e) {
					existing_committed_amount = new BigDecimal(0);
				}

				masStoreBudget.setPoComittedAmount(existing_committed_amount
						.add(poAmount));
				hbt.update(masStoreBudget);
			}

			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
		flag = true;
		poMap.put("flag", flag);
		return poMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForMoreInfoPurchase() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
		Session session = (Session) getSession();
		try{


		brandList = session.createCriteria(MasStoreBrand.class)
				.add(Restrictions.eq("Status", "y")).list();
		manufacturerList = session.createCriteria(MasManufacturer.class)
				.add(Restrictions.eq("Status", "y")).list();
		}catch (Exception e) {
			e.printStackTrace();
		}/*finally{
			*//**
			 * session.close() is done By Mukesh Narayan Singh
			 * Date 07 Oct 2010
			 *//*
			if(session!=null){
				session.close();
			}
		}*/
		map.put("brandList", brandList);
		map.put("manufacturerList", manufacturerList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public int getPurchaseOrderId(String poNumber) {
		int poId = 0;
		List<StorePoHeader> list = new ArrayList<StorePoHeader>();
		Session session = (Session) getSession();

		list = session.createCriteria(StorePoHeader.class)
				.add(Restrictions.eq("Status", "o"))
				.add(Restrictions.eq("PoNumber", poNumber)).list();
		for (StorePoHeader storePoHeader : list) {
			poId = Integer.parseInt("" + storePoHeader.getId());
		}
		return poId;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public List<StorePoHeader> getPoHeader(int poId) {
		Session session = (Session) getSession();
		List<StorePoHeader> poHeaderList = session
				.createCriteria(StorePoHeader.class)
				.add(Restrictions.eq("Id", poId)).list();
		return poHeaderList;
	}

	@SuppressWarnings("unchecked")
	public List<StorePoHeader> getPoNumberList(int deptId,int hospitalId) {
		Session session = (Session) getSession();
		List<StorePoHeader> poNumberList =new ArrayList<StorePoHeader>();
		try{
			poNumberList = session
			.createCriteria(StorePoHeader.class)
			//.add(Restrictions.eq("Department.Id", deptId))
			.add(Restrictions.eq("Hospital.Id", hospitalId))
			.addOrder(Order.desc("Id")).list();
		}catch (Exception e) {
			e.printStackTrace();
		}/*finally{
			*//**
			 * session.close() is done By Mukesh Narayan Singh
			 * Date 07 Oct 2010
			 *//*
			if(session!=null){
				session.close();
			}
		}*/
		return poNumberList;
	}

	@SuppressWarnings("unchecked")
	public List<MasStoreBudget> getBudgetStatusList() {
		Session session = (Session) getSession();
		List<MasStoreBudget> budgetStatusList = session
				.createCriteria(MasStoreBudget.class)
				.add(Restrictions.eq("Status", "y")).list();
		return budgetStatusList;
	}

	@SuppressWarnings("unchecked")
	public Map getViewAllMap() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		List<StorePoDetail> poDetailList = new ArrayList<StorePoDetail>();
		List<StorePoHeader> poHeaderList = new ArrayList<StorePoHeader>();
		Session session = (Session) getSession();
		try {
			poDetailList = session.createCriteria(StorePoDetail.class).list();
			supplierList = session.createCriteria(MasStoreSupplier.class)
					.add(Restrictions.eq("Status", "y")).list();
			poHeaderList = session.createCriteria(StorePoHeader.class)
					.add(Restrictions.eq("Status", "y")).list();
		}catch (Exception e) {
			e.printStackTrace();
		}/*finally{
			*//**
			 * session.close() is done By Mukesh Narayan Singh
			 * Date 07 Oct 2010
			 *//*
			if(session!=null){
				session.close();
			}
		}*/
		map.put("poDetailList", poDetailList);
		map.put("poHeaderList", poHeaderList);
		map.put("supplierList", supplierList);

		return map;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public Map<String, Object> searchPO(Map<String, Object> searchMap)
	 {
		String fromDate = "";
		String toDate = "";
		int supplierId = 0;
		int poId = 0;
		int departmentId = 0;
		if(searchMap.get("departmentId")!=null){
			departmentId=(Integer)searchMap.get("departmentId");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreSupplier> searchSupplierList = new ArrayList<MasStoreSupplier>();
		List<StorePoDetail> searchPoDetailList = new ArrayList<StorePoDetail>();
		List<StorePoHeader> searchPoHeaderList = new ArrayList<StorePoHeader>();
		Session session = (Session) getSession();
		try{



			if (!(searchMap.get("fromDate").equals(""))
					&& (!searchMap.get("toDate").equals(""))) {
				fromDate = (String) searchMap.get("fromDate");
				toDate = (String) searchMap.get("toDate");
				String date4MySQL1;
				String date4MySQL2;
				try {
					SimpleDateFormat formatterIn = new SimpleDateFormat(
					"dd/MM/yyyy");
					SimpleDateFormat formatterOut = new SimpleDateFormat(
					"yyyy-MM-dd");
					date4MySQL1 = formatterOut.format(formatterIn.parse(fromDate));
					date4MySQL2 = formatterOut.format(formatterIn.parse(toDate));
					Date startDate = Date.valueOf(date4MySQL1);
					Date endDate = Date.valueOf(date4MySQL2);

					searchPoDetailList = session
					.createCriteria(StorePoDetail.class).list();
					searchSupplierList = session
					.createCriteria(MasStoreSupplier.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
					Criteria c = session.createCriteria(StorePoHeader.class);

					if ((Integer) searchMap.get("poId") != 0) {
						poId = (Integer) searchMap.get("poId");
						c.add(Restrictions.eq("Id", poId));
					}else{
						c.add(Restrictions.between("PoDate", startDate, endDate))
						.add(Restrictions.eq("Department.Id", departmentId)).list();
					}

					searchPoHeaderList=c.list();
					/*String sql="";
					sql="from jkt.hms.masters.business.StorePoHeader as sph ";
					if ((Integer) searchMap.get("poId") != 0) {
						poId = (Integer) searchMap.get("poId");
						sql=sql+" where sph.Id="+poId;

						searchPoHeaderList=getHibernateTemplate().find(sql);
					}else{
						sql=sql+" where sph.PoDate between '"+startDate+"' and '"+endDate+"' and Department.Id="+departmentId;
						searchPoHeaderList=getHibernateTemplate().find(sql);
					}*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

/**
 * This Code is commented By Mukesh Narayan Singh
 * Date 12-Jan-2011
 * Remark: There is no use for supplier and department search
 */
			/*
			if ((Integer) searchMap.get("supplierId") != 0) {
				supplierId = (Integer) searchMap.get("supplierId");

				searchPoDetailList = session.createCriteria(StorePoDetail.class)
				.list();
				searchSupplierList = session.createCriteria(MasStoreSupplier.class)
				.add(Restrictions.eq("Status", "y")).list();
				searchPoHeaderList = session.createCriteria(StorePoHeader.class)
				.list();
			}

			if ((Integer) searchMap.get("poId") != 0) {
				poId = (Integer) searchMap.get("poId");

				searchPoDetailList = session.createCriteria(StorePoDetail.class)
				.list();
				searchSupplierList = session.createCriteria(MasStoreSupplier.class)
				.add(Restrictions.eq("Status", "y")).list();
				searchPoHeaderList = session.createCriteria(StorePoHeader.class)
				.add(Restrictions.eq("Id", poId)).list();
			}

			if ((Integer) searchMap.get("departmentId") != 0) {
				departmentId = (Integer) searchMap.get("departmentId");

				searchPoDetailList = session.createCriteria(StorePoDetail.class)
				.list();
				searchSupplierList = session.createCriteria(MasStoreSupplier.class)
				.add(Restrictions.eq("Status", "y")).list();
				searchPoHeaderList = session.createCriteria(StorePoHeader.class)
				.add(Restrictions.eq("Department.Id", departmentId)).list();
			}
			*/
		}catch (Exception e) {
			e.printStackTrace();
		}/*finally{
			*//**
			 * session.close() is done By Mukesh Narayan Singh
			 * Date 07 Oct 2010
			 *//*
			if(session!=null){
				session.close();
			}
		}*/
		map.put("searchPoDetailList", searchPoDetailList);
		map.put("searchSupplierList", searchSupplierList);
		map.put("searchPoHeaderList", searchPoHeaderList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> poModifyMap(int poId, int pageNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StorePoDetail> poDetailList = new ArrayList<StorePoDetail>();
		List<StorePoHeader> poHeaderList = new ArrayList<StorePoHeader>();
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
		List objectList = new ArrayList();
		int firstResult = 0;
		int maxResults = 10;
		int totalPages = 0;
		double totalPage = 0.0;

		if (pageNo != 1) {
			firstResult = firstResult + (pageNo - 1) * 10;
		}

		Session session = (Session) getSession();
		Criteria c = session.createCriteria(StorePoDetail.class).add(
				Restrictions.eq("Po.Id", poId));
		if(pageNo!=0){
			c.setFirstResult(firstResult);
			c.setMaxResults(maxResults);
		}
		poDetailList = c.list();
		poHeaderList = session.createCriteria(StorePoHeader.class)
				.add(Restrictions.eq("Id", poId)).list();
		manufacturerList = session.createCriteria(MasManufacturer.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		for (Iterator iterator = poDetailList.iterator(); iterator.hasNext();) {
			StorePoDetail storePoDetail = (StorePoDetail) iterator.next();
//---------------------changes by anamika------------
			Criteria c1 = session
					.createCriteria(MasStoreBrand.class)
					.createAlias("Item", "item")
					//.add(Restrictions.like("item.Id", storePoDetail.getItem()
					.add(Restrictions.eq("item.Id", storePoDetail.getItem()
							.getId()));
			brandList = c1.list();
			map.put(storePoDetail.getItem().getId().toString(), brandList);
		}
		String qry = "select count(*) from store_po_detail where po_id=" + poId
				+ "";
		objectList = session.createSQLQuery(qry).list();
		if (objectList != null && objectList.size() > 0) {
			totalPage = (new Double(objectList.get(0).toString()))
					/ (double) 10;
			Double d = new Double(Math.ceil(totalPage));
			totalPages = d.intValue();

		} else {
			totalPages = 0;
		}
		map.put("totalPages", totalPages);

		map.put("poDetailList", poDetailList);
		map.put("poHeaderList", poHeaderList);
		map.put("masManufacturerList", manufacturerList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public List<StorePoDetail> getPoDetailListForMoreInfoPurchase(int poDetailId) {
		Session session = (Session) getSession();
		List<StorePoDetail> poDetailMoreInfoList =new ArrayList<StorePoDetail>();
		try{
			poDetailMoreInfoList = session
			.createCriteria(StorePoDetail.class)
			.add(Restrictions.eq("Id", poDetailId)).list();
		}catch (Exception e) {
			e.printStackTrace();
		}/*finally{
			*//**
			 * session.close() is done By Mukesh Narayan Singh
			 * Date 07 Oct 2010
			 *//*
			if(session!=null){
				session.close();
			}
		}*/
		return poDetailMoreInfoList;
	}

	@SuppressWarnings({ "unchecked", "unused", "unchecked" })
	public boolean updatePurchaseOrder(Map<String, Object> infoMap) {
		boolean successfullyAdded = false;
		StorePoHeader storePoHeader = null;
		int pageNo = 0;
		int poId = 0;
		List<StorePoDetail> poDetailList = new ArrayList<StorePoDetail>();
		List<StorePoDetail> poDetailListAdd = new ArrayList<StorePoDetail>();

		if (infoMap.get("pageNo") != null) {
			pageNo = Integer.parseInt("" + infoMap.get("pageNo"));
		}
		if (infoMap.get("poId") != null) {
			poId = Integer.parseInt("" + infoMap.get("poId"));
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			if (pageNo == 1) {
				storePoHeader = (StorePoHeader) infoMap.get("storePoHeader");
				hbt.update(storePoHeader);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (infoMap.get("poDetailList") != null) {
				poDetailList = (List<StorePoDetail>) infoMap
						.get("poDetailList");
				if (poDetailList.size() > 0) {
					for (int i = 0; i < poDetailList.size(); i++) {
						StorePoDetail storePoDetail = new StorePoDetail();
						storePoDetail = (StorePoDetail) poDetailList.get(i);
						hbt.update(storePoDetail);
					}
				}
				successfullyAdded = true;
			}
			if (infoMap.get("poDetailListAdd") != null) {
				poDetailListAdd = (List<StorePoDetail>) infoMap
						.get("poDetailListAdd");
				if (poDetailListAdd.size() > 0) {
					for (int i = 0; i < poDetailListAdd.size(); i++) {
						StorePoDetail storePoDetail = (StorePoDetail) poDetailListAdd
								.get(i);
						hbt.save(storePoDetail);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public List<MasAuthorizer> getApprovalAuthoritiesList() {
		List<MasAuthorizer> authorityList = new ArrayList<MasAuthorizer>();
		Session session = (Session) getSession();

		authorityList = session.createCriteria(MasAuthorizer.class).list();
		return authorityList;
	}

	@SuppressWarnings("deprecation")
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}

	@SuppressWarnings("unchecked")
	public boolean submitApprovalAuthority(String approvalIds, int poId) {
		boolean flag = false;

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (poId != 0) {
			List<StorePoHeader> list = hbt
					.find("from jkt.hms.masters.business.StorePoHeader as sph where sph.Id = '"
							+ poId + "'");

			if (approvalIds != "") {
				List<MasAuthorizer> authorizerList = hbt
						.find("from jkt.hms.masters.business.MasAuthorizer as ma where ma.Id IN ( "
								+ approvalIds + ")");
				List<MasAuthorizer> unAuthorizerList = hbt
						.find("from jkt.hms.masters.business.MasAuthorizer as ma where ma.Id NOT IN ( "
								+ approvalIds + ")");

				for (MasAuthorizer masAuthorizer1 : authorizerList) {
					masAuthorizer1.setStatus("y");
					hbt.update(masAuthorizer1);
				}
				for (MasAuthorizer masAuthorizer2 : unAuthorizerList) {
					masAuthorizer2.setStatus("n");
					hbt.update(masAuthorizer2);
				}

				if (list.size() > 0) {
					StorePoHeader storePoHeader = (StorePoHeader) list.get(0);
					storePoHeader.setApprovalAuthority(approvalIds);
					hbt.update(storePoHeader);
					flag = true;
				}
			} else {
				List<MasAuthorizer> allAuthorizerList = hbt
						.find("from jkt.hms.masters.business.MasAuthorizer as ma");
				for (MasAuthorizer masAuthorizer : allAuthorizerList) {
					masAuthorizer.setStatus("n");
					hbt.update(masAuthorizer);
				}
				if (list.size() > 0) {
					StorePoHeader storePoHeader = (StorePoHeader) list.get(0);
					storePoHeader.setApprovalAuthority("0");
					hbt.update(storePoHeader);
					flag = true;
				}
			}
		} else {
			flag = false;
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	public List<MasStoreSupplier> getSupplierList() {
		Session session = (Session) getSession();
		List<MasStoreSupplier> supplierList = session
				.createCriteria(MasStoreSupplier.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		return supplierList;
	}

	public Map<String, Object> getStockDetails(Map<String, Object> costMap) {
		Map<String, Object> stockMap = new HashMap<String, Object>();
		float costPriceForAClass = 0f;
		float costPriceForBClass = 0f;
		if (costMap.get("costPriceForAClass") != null) {
			costPriceForAClass = (Float) costMap.get("costPriceForAClass");
		}
		if (costMap.get("costPriceForBClass") != null) {
			costPriceForBClass = (Float) costMap.get("costPriceForBClass");
		}
		Session session = (Session) getSession();
		List<StoreItemBatchStock> sumList = session
				.createQuery(
						"select sum(ss.ClosingStock*ss.CostPrice) from StoreItemBatchStock as ss")
				.list();

		float sumOfStock = Float.valueOf(sumList.toString().substring(1,
				sumList.toString().length() - 1));
		stockMap.put("sumOfStock", sumOfStock);
		return stockMap;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public Map<String, Object> getStoreSetUpDetails() {
		Map<String, Object> classMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<StoreSetup> classList = session.createCriteria(StoreSetup.class)
				.list();
		classMap.put("classList", classList);
		return classMap;
	}

	@SuppressWarnings("unchecked")
	public List<MasStorePoDeliveryTerms> getPaymentDetails() {
		List<MasStorePoDeliveryTerms> paymentDetailsList = new ArrayList<MasStorePoDeliveryTerms>();
		Session session = (Session) getSession();
		try{
			paymentDetailsList = session
			.createCriteria(MasStorePoDeliveryTerms.class)
			.add(Restrictions.eq("Status", "y").ignoreCase())
			.add(Restrictions.eq("PoDeliveryTermsName", "Payment")).list();
		}catch (Exception e) {
			e.printStackTrace();
		}/*finally{
			*//**
			 * session.close() is done By Mukesh Narayan Singh
			 * Date 07 Oct 2010
			 *//*
			if(session!=null){
				session.close();
			}
		}*/
		return paymentDetailsList;
	}

	@SuppressWarnings("unchecked")
	public List<MasStorePoDeliveryTerms> getDeliveryDetails() {
		List<MasStorePoDeliveryTerms> deliveryDetailsList = new ArrayList<MasStorePoDeliveryTerms>();
		Session session = (Session) getSession();
		try{
			deliveryDetailsList = session
			.createCriteria(MasStorePoDeliveryTerms.class)
			.add(Restrictions.eq("Status", "y").ignoreCase())
			.add(Restrictions.eq("PoDeliveryTermsName", "Delivery")).list();
		}catch (Exception e) {
			e.printStackTrace();
		}/*finally{
			*//**
			 * session.close() is done By Mukesh Narayan Singh
			 * Date 07 Oct 2010
			 *//*
			if(session!=null){
				session.close();
			}
		}*/
		return deliveryDetailsList;
	}

	@SuppressWarnings("unchecked")
	public List<MasStorePoDeliveryTerms> getDescriptionForDeliveryTermId(
			int poDeliveryTermId) {
		List<MasStorePoDeliveryTerms> detailsList = new ArrayList<MasStorePoDeliveryTerms>();
		Session session = (Session) getSession();
		detailsList = session.createCriteria(MasStorePoDeliveryTerms.class)
				.add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Id", poDeliveryTermId)).list();

		return detailsList;
	}

	public String getHospitalName(int hospitalId) {
		Session session = (Session) getSession();
		String hospitalName = "";
		List<MasHospital> list = session.createCriteria(MasHospital.class)
				.add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Id", hospitalId)).list();

		if (list != null && list.size() > 0) {
			MasHospital obj = (MasHospital) list.get(0);
			hospitalName = obj.getHospitalName();
		}
		return hospitalName;
	}

	public Map<String, Object> getItemListForPurchaseOrder(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List objectList = new ArrayList();

		Session session = (Session) getSession();
		//String pvmsNo = null;
		int deptId = 0;
		int poId = 0;

		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		poId = Integer.parseInt("" + dataMap.get("poId"));

		try {
			String str = (String) dataMap.get("autoHint") + "%";


			String qry1 = "SELECT t.item_id FROM store_po_detail t,store_po_header m where m.po_id='"
					+ poId + "' and m.po_id=t.po_detail_id;";

			objectList = (List) session.createSQLQuery(qry1).list();
 			/*
			 * Code for get GRN No from property file and access right's from hospital parameter
			 * Code date 13 Oct 2010
			 * Code By Mukesh Narayan Singh
			 */
			List<HospitalParameters> hospitalParametersList = new ArrayList<HospitalParameters>();
			hospitalParametersList=session.createCriteria(HospitalParameters.class).list();
			int departmentIdForRKS=0;
			int departmentIdForVBCH=0;
			/**/
			if(hospitalParametersList.size()>0){
				/**/
				for (HospitalParameters hospitalParameters : hospitalParametersList) {
					departmentIdForRKS=hospitalParameters.getDeptIdStoreCodeRKS();
					departmentIdForVBCH=hospitalParameters.getDeptIdStoreCodeVBCH();
				}
			if (objectList.size() != 0) {

				/**/
					if(deptId==departmentIdForRKS || deptId==departmentIdForVBCH){
						Criteria c = session
						.createCriteria(MasStoreItem.class)
						.add(Restrictions.like("Nomenclature", str))
						//.add(Restrictions.eq("Department.Id", deptId))
						.add(Restrictions.not(Restrictions.in("Id", objectList)));
						c.setFirstResult(0);
						c.setMaxResults(10);
						itemList = c.list();
					}else{
						/**/
						Criteria c = session
						.createCriteria(MasStoreItem.class)
						.add(Restrictions.like("Nomenclature", str))
						.add(Restrictions.eq("Department.Id", deptId))
						.add(Restrictions.not(Restrictions.in("Id", objectList)));
						c.setFirstResult(0);
						c.setMaxResults(10);
						itemList = c.list();
					}
				}else{
					/**/
					if(deptId==departmentIdForRKS || deptId==departmentIdForVBCH){
						Criteria c = session.createCriteria(MasStoreItem.class)
						.add(Restrictions.like("Nomenclature", str));
						//.add(Restrictions.eq("Department.Id", deptId));
						c.setFirstResult(0);
						c.setMaxResults(10);
						itemList = c.list();
					}
					else
					{
 						Criteria c = session.createCriteria(MasStoreItem.class)
						.add(Restrictions.like("Nomenclature", str))
						.add(Restrictions.eq("Department.Id", deptId));
						c.setFirstResult(0);
						c.setMaxResults(10);
						itemList = c.list();
					}
				}

			}
			/*else {

					Criteria c = session.createCriteria(MasStoreItem.class)
					.add(Restrictions.like("Nomenclature", str))
					.add(Restrictions.eq("Department.Id", deptId));
					c.setFirstResult(0);
					c.setMaxResults(10);
					itemList = c.list();
				}
*/

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;

	}

	public Map<String, Object> getPoListForPurchaseOrder(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List objectList = new ArrayList();

		Session session = (Session) getSession();
		String pvmsNo = null;
		int deptId = 0;

		deptId = Integer.parseInt("" + dataMap.get("deptId"));

		try {
			String str = (String) dataMap.get("autoHint") + "%";

			Criteria c = session.createCriteria(StorePoHeader.class)
					.add(Restrictions.like("PoNumber", str))
					.add(Restrictions.eq("Department.Id", deptId));

			c.setFirstResult(0);
			c.setMaxResults(10);
			itemList = c.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showPOGenerationBelowReorderJsp(int deptId,int hospitalId)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		//List<MasStoreSupplier> masStoreSupplierList = new ArrayList<MasStoreSupplier>();
		List<Object> masStoreSupplierList = new ArrayList<Object>();
		List<Object> POQtyList = new ArrayList<Object>();
		boolean accessFlag = false;

		try
		{
			List<HospitalParameters> hospitalParametersList = new ArrayList<HospitalParameters>();
			/**/
			hospitalParametersList=session.createCriteria(HospitalParameters.class)
			.add(Restrictions.eq("DeptIdStoreCodeRKS", deptId)).list();

			if(hospitalParametersList.size()>0)
			{
				/**/
				accessFlag = true;
			}
			else
			{
				/**/
				hospitalParametersList=session.createCriteria(HospitalParameters.class)
				.add(Restrictions.eq("DeptIdStoreCodeVBCH", deptId)).list();
				if(hospitalParametersList.size()>0)
				{
					accessFlag = true;
				}
			}
			
			
			if(accessFlag)
			{
				String query1 = "delete from Temp1 t1";
				String query2 = "delete from Temp2 t2";

				Query query1List = session.createQuery(query1);
				Query query2List = session.createQuery(query2);

				int row1 = query1List.executeUpdate();
				int row2 = query2List.executeUpdate();

				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String currentdate = (String)utilMap.get("currentDate");
				//String modidate = (String)utilMap.get("modifiedDate");
				String prevDate="";
		 		//String currDate="";
				String applicationDate=properties.getProperty("store.application_date");
		 		map.put("prevDate",applicationDate);
		 		map.put("currDate", currentdate);
		 		
				//map.put("firstDate", "01/02/2010");
		 		//map.put("secondDate", currentdate);
		 		Map<String, Object> mapData = new HashMap<String, Object>();
		 		mapData=HMSUtil.getDaysDiffBetweenDate(map);
		 		if(mapData.get("prevDate")!=null){
		 			prevDate=(String)mapData.get("prevDate");
		 		}
		 		String currDate="";
		 		if(mapData.get("currDate")!=null){
		 			currDate=(String)mapData.get("currDate");
		 		}
		 		int month=0;
		 		if(mapData.get("month")!=null){
		 			month=(Integer)mapData.get("month");
		 		}
		 		System.out.println("prevDate=="+prevDate);
		 		System.out.println("currDate=="+currDate);
		 		System.out.println("month=="+month);
		 		System.out.println("deptId=="+deptId);
				String financialYear="";
				financialYear=HMSUtil.getFinancialYearOnlyYY_YY(currentdate);
				System.out.println("financialYear=="+financialYear);
				String query3 = " INSERT INTO temp1(item_id,nomenclature,qty_issued) "+
				" select mst.item_id , mst.nomenclature, round(((sum(sit.qty_issued)/"+month+")*3),0) as qty_issued "+
				" from store_issue_m sim  left outer join store_issue_t sit on sit.issue_m_id = sim.id "+
				" left outer join mas_store_item mst on mst.item_id = sit.item_id "+
				//" where sim.issue_date between '2009-12-02' and '2010-12-02' "+
				//" where sim.issue_date between '"+modidate+"' and '"+currentdate+"' "+
				" where sim.department_id = "+deptId+" and sim.hospital_id = "+hospitalId+" and  sim.issue_date between '"+prevDate+"' and '"+currDate+"' "+
				" and sit.qty_issued is not null and sit.qty_issued > 0 "+
				" group by mst.item_id,mst.nomenclature";

				String query4 = " INSERT INTO temp2(item_id,item_name,rol,pvms_no,stock_qty,unit_name,cost_price,sale_tax_id,manufacturer_id) "+
				" select a.ItemID, a.ItemName, cast(a.ROL as int), a.PVMS_No,a.Stock_qty,a.UnitName,a.CostPrice, a.SaleTaxId, a.ManufacId "+
				" from (select mas_store_item.item_id as ItemID, mas_store_item.nomenclature as ItemName, mas_store_item.rol as ROL, "+
				" mas_store_item.pvms_no as PVMS_No, SUM((coalesce(closing_stock,0))) as Stock_qty, "+
				" msic.item_unit_name as UnitName ,mas_store_item.cost_price as CostPrice, mas_store_item.sale_tax_id as SaleTaxId , mas_store_item.manufacturer_id as ManufacId "+
				" from mas_store_item as mas_store_item left outer join store_item_batch_stock as sibs on mas_store_item.item_id = sibs.item_id "+
				" left outer join mas_store_item_conversion as msic on mas_store_item.item_conversion_id = msic.item_conversion_id "+
				" where sibs.department_id = "+deptId+" and sibs.hospital_id = "+hospitalId+" and  mas_store_item.Status='Y' "+
				" group by mas_store_item.item_id, mas_store_item.nomenclature, "+
				" mas_store_item.rol,mas_store_item.pvms_no,msic.item_unit_name, " +
				" mas_store_item.cost_price, mas_store_item.sale_tax_id, mas_store_item.manufacturer_id ) a "+
				" where cast(a.Stock_qty as int) <= cast(a.ROL as int) ";

				int row3 = session.createSQLQuery(query3).executeUpdate();
				int row4 = session.createSQLQuery(query4).executeUpdate();
				System.out.println("row3=="+row3);
				System.out.println("row4=="+row4);

				String query5 = "select t1.item_id, t1.nomenclature, t1.qty_issued, t2.rol, "+
				" t2.pvms_no, t2.stock_qty, t2.unit_name, "+
				//" ((t2.rol) - (t2.stock_qty + t1.qty_issued)) as reqQty , t2.cost_price, t2.sale_tax_id, t2.manufacturer_id "+
				" (t1.qty_issued-t2.stock_qty) as reqQty , t2.cost_price, t2.sale_tax_id, t2.manufacturer_id  "+
				" from temp1 t1 inner join temp2 t2 on t2.item_id = t1.item_id where (t1.qty_issued-t2.stock_qty)>0 order by t1.nomenclature asc";

				POQtyList  = session.createSQLQuery(query5).list();
				//masStoreSupplierList = getHibernateTemplate().find("from jkt.hms.masters.business.MasStoreSupplier");
				String supplerQuery="";
		 		
				
				supplerQuery="select d.supplier_name, a.item_id, b.supplier_id from store_tender_comm_bid_m a, store_tender_comm_bid_t b,  mas_store_supplier d, mas_store_item e, store_tender_m stm where a.id = b.comm_bid_id  and b.supplier_id = d.supplier_id and a.tender_id = stm.id and a.department_id = "+deptId+"  and substring(stm.tender_no,position('/' in stm.tender_no)+1,char_length(stm.tender_no))='"+financialYear+"' group by a.item_id,b.supplier_id,d.supplier_name";
				masStoreSupplierList= session.createSQLQuery(supplerQuery).list();
			}

			map.put("accessFlag", accessFlag);
			map.put("POQtyList", POQtyList);
			map.put("masStoreSupplierList", masStoreSupplierList);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return map;
	}

	public Map<String, Object> showROLJsp(int deptId)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		List<MasStoreGroup> storeGroupList = new ArrayList<MasStoreGroup>();
		try
		{
			storeGroupList = session.createCriteria(MasStoreGroup.class).list();
			map.put("storeGroupList", storeGroupList);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> showROLJsp(int deptId,int groupId)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		//List<MasStoreSupplier> masStoreSupplierList = new ArrayList<MasStoreSupplier>();
		List<Object> masStoreSupplierList = new ArrayList<Object>();
		List<Object> POQtyList = new ArrayList<Object>();
		//List<MasStoreGroup> storeGroupList = new ArrayList<MasStoreGroup>();
		boolean accessFlag = false;

		try
		{
			List<HospitalParameters> hospitalParametersList = new ArrayList<HospitalParameters>();
			/**/
			hospitalParametersList=session.createCriteria(HospitalParameters.class)
			.add(Restrictions.eq("DeptIdStoreCodeRKS", deptId)).list();

			if(hospitalParametersList.size()>0)
			{
				/**/
				accessFlag = true;
			}
			else
			{
				/**/
				hospitalParametersList=session.createCriteria(HospitalParameters.class)
				.add(Restrictions.eq("DeptIdStoreCodeVBCH", deptId)).list();
				if(hospitalParametersList.size()>0)
				{
					accessFlag = true;
				}
			}
			
			
			if(accessFlag)
			{
				String query1 = "delete from Temp1 t1";
				String query2 = "delete from Temp2 t2";

				Query query1List = session.createQuery(query1);
				Query query2List = session.createQuery(query2);

				int row1 = query1List.executeUpdate();
				int row2 = query2List.executeUpdate();

				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String currentdate = (String)utilMap.get("currentDate");
				//String modidate = (String)utilMap.get("modifiedDate");
				String prevDate="";
		 		//String currDate="";
				String applicationDate=properties.getProperty("store.application_date");
		 		map.put("prevDate",applicationDate);

//				map.put("prevDate", "01/01/2011");
		 		map.put("currDate", currentdate);
		 		
				//map.put("firstDate", "01/02/2010");
		 		//map.put("secondDate", currentdate);
		 		Map<String, Object> mapData = new HashMap<String, Object>();
		 		mapData=HMSUtil.getDaysDiffBetweenDate(map);
		 		if(mapData.get("prevDate")!=null){
		 			prevDate=(String)mapData.get("prevDate");
		 		}
		 		String currDate="";
		 		if(mapData.get("currDate")!=null){
		 			currDate=(String)mapData.get("currDate");
		 		}
		 		int month=0;
		 		if(mapData.get("month")!=null){
		 			month=(Integer)mapData.get("month");
		 		}
				String financialYear="";
				financialYear=HMSUtil.getFinancialYearOnlyYY_YY(currentdate);
				String query3 = " INSERT INTO temp1(item_id,nomenclature,qty_issued) "+
				" select mst.item_id , mst.nomenclature, round(((sum(sit.qty_issued)/"+month+")*3),0) as qty_issued "+
				" from store_issue_m sim  left outer join store_issue_t sit on sit.issue_m_id = sim.id "+
				" left outer join mas_store_item mst on mst.item_id = sit.item_id "+
				//" where sim.issue_date between '2009-12-02' and '2010-12-02' "+
				//" where sim.issue_date between '"+modidate+"' and '"+currentdate+"' "+
				" where sim.department_id = "+deptId+" and  sim.issue_date between '"+prevDate+"' and '"+currDate+"' "+
				" and mst.group_id="+groupId+"  and sit.qty_issued is not null and sit.qty_issued > 0 "+
				" group by mst.item_id,mst.nomenclature";

				String query4 = " INSERT INTO temp2(item_id,item_name,rol,pvms_no,stock_qty,unit_name,cost_price,sale_tax_id,manufacturer_id) "+
				" select a.ItemID, a.ItemName, cast(a.ROL as int), a.PVMS_No,a.Stock_qty,a.UnitName,a.CostPrice, a.SaleTaxId, a.ManufacId "+
				" from (select mas_store_item.item_id as ItemID, mas_store_item.nomenclature as ItemName, mas_store_item.rol as ROL, "+
				" mas_store_item.pvms_no as PVMS_No, SUM(coalesce(closing_stock,0)) as Stock_qty, "+
				" msic.item_unit_name as UnitName ,mas_store_item.cost_price as CostPrice, mas_store_item.sale_tax_id as SaleTaxId , mas_store_item.manufacturer_id as ManufacId "+
				" from mas_store_item as mas_store_item left outer join store_item_batch_stock as sibs on mas_store_item.item_id = sibs.item_id "+
				" left outer join mas_store_item_conversion as msic on mas_store_item.item_conversion_id = msic.item_conversion_id "+
				" where sibs.department_id = "+deptId+" and mas_store_item.group_id="+groupId+" and  mas_store_item.Status='Y' "+
				" group by mas_store_item.item_id, mas_store_item.nomenclature, "+
				" mas_store_item.rol,mas_store_item.pvms_no,msic.item_unit_name, " +
				" mas_store_item.cost_price, mas_store_item.sale_tax_id, mas_store_item.manufacturer_id ) a "+
				" where  cast(a.Stock_qty as int) <= cast(a.ROL as int)";
		 		
				int row3 = session.createSQLQuery(query3).executeUpdate();
				int row4 = session.createSQLQuery(query4).executeUpdate();

				String query5 = "select t1.item_id, t1.nomenclature, t1.qty_issued, t2.rol, "+
				" t2.pvms_no, t2.stock_qty, t2.unit_name, "+
				//" ((t2.rol) - (t2.stock_qty + t1.qty_issued)) as reqQty , t2.cost_price, t2.sale_tax_id, t2.manufacturer_id "+
				" (t1.qty_issued-t2.stock_qty) as reqQty , t2.cost_price, t2.sale_tax_id, t2.manufacturer_id "+
				" from temp1 t1 inner join temp2 t2 on t2.item_id = t1.item_id where (t1.qty_issued-t2.stock_qty)>0 order by t1.nomenclature ";

				POQtyList  = session.createSQLQuery(query5).list();
				//masStoreSupplierList = getHibernateTemplate().find("from jkt.hms.masters.business.MasStoreSupplier");
				String supplerQuery="";
		 		
				supplerQuery="select d.supplier_name, a.item_id, b.supplier_id from store_tender_comm_bid_m a, store_tender_comm_bid_t b,  mas_store_supplier d, mas_store_item e, store_tender_m stm where a.id = b.comm_bid_id  and b.supplier_id = d.supplier_id and a.tender_id = stm.id and a.department_id = "+deptId+" and substring(stm.tender_no,position('/' in stm.tender_no)+1,char_length(stm.tender_no))='"+financialYear+"' group by a.item_id,b.supplier_id,d.supplier_name order by d.supplier_name";
				masStoreSupplierList= session.createSQLQuery(supplerQuery).list();
			}
			//storeGroupList = session.createCriteria(MasStoreGroup.class).list();
			map.put("accessFlag", accessFlag);
			map.put("POQtyList", POQtyList);
			map.put("masStoreSupplierList", masStoreSupplierList);
			//map.put("storeGroupList", storeGroupList);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return map;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitReorderLevel(Box box, int departmentId, String loginName)
	{
		Map<String, Object> rolMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Transaction transaction = null;
		Boolean flag = false;
		try
		{
			int counter =0;int groupId=0;
		    transaction = (Transaction)session.beginTransaction();
		    counter = box.getInt("counter");
		    groupId = box.getInt("groupId");
		    Query query =null;
		    for(int i=1;i<=counter;i++){
		    	Integer itemId = Integer.parseInt((String)box.getString("itemID"+i));
		    	Integer reqQty = Integer.parseInt((String)box.getString("reqQty"+i));
		    	String hql = "update MasStoreItem set rol="+reqQty+" where department_id="+departmentId+" and  item_id ="+itemId+" and group_id="+groupId;
		    	query = session.createQuery(hql);;
		    	int rowCount = query.executeUpdate();
		    }
		    query   = session.createQuery("from MasStoreItem where group_id="+groupId);
		    itemList = query.list(); 
		    transaction.commit();
		    flag = true;
		}
		catch(Exception e)
		{
			flag = false;
			e.printStackTrace();
			transaction.rollback();
		}
		rolMap.put("itemList", itemList);
		rolMap.put("flag", flag);
		return rolMap;
	}

	@Override
	public Map<String, Object> runAbcProcedure(int deptId,String newFromDate,String newToDate,int itemCatId) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag=false;
		Session session = (Session) getSession();
		try{
						java.sql.Connection con = session.connection();
			String sql="";
			sql = "{call abc_analysis(" + deptId +",'"+newFromDate+"',"+"'"+newToDate+"',"+itemCatId+")}";
			
			try {
				if(sql!=""){
					CallableStatement cals = con.prepareCall(sql);
					cals.execute();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
			flag=true;
		}
		catch(Exception e){
			e.printStackTrace();
			flag=false;
		}
		map.put("flag", flag);
		return map;
	}

	@SuppressWarnings("unchecked")
		public Map<String, Object> showABCJsp() {
		Map<String, Object> abcMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasStoreGroup> categoryList = new ArrayList<MasStoreGroup>();
		try{
			categoryList=session.createCriteria(MasStoreGroup.class)
			.add(Restrictions.eq("Status","y")).list();
		}catch(Exception e){
			e.printStackTrace();
		}
		abcMap.put("categoryList", categoryList);
		return abcMap;
	}

	@Override
	public Map<String, Object> runFsnProcedure(int deptId, Date startDate,
			Date endDate, int itemCatId) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag=false;
		Session session = (Session) getSession();
		try{
			java.sql.Connection con = session.connection();
			String sql="";
			sql = "{call fsn_analysis(" + deptId +",'"+startDate+"',"+"'"+endDate+"',"+itemCatId+")}";
			
			try {
				if(sql!=""){
					CallableStatement cals = con.prepareCall(sql);
					cals.execute();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
			flag=true;
		}
		catch(Exception e){
			e.printStackTrace();
			flag=false;
		}
		map.put("flag", flag);
		return map;
	}


	@SuppressWarnings("unchecked")
	public Map<String, Object> getPoNumberAgainstVendorList(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		java.util.Date fromDate =new java.util.Date();
		java.util.Date toDate=new java.util.Date();
		String vendorId="";
		Integer hospitalId= 0;
		if(dataMap.get("fromDate")!= null)
		fromDate=(java.util.Date)dataMap.get("fromDate");
		if(dataMap.get("toDate")!= null)
			toDate=(java.util.Date)dataMap.get("toDate");
		if(dataMap.get("vendorName")!= null && (String)dataMap.get("vendorName")!= "")
			vendorId=(String)dataMap.get("vendorName");

		if(dataMap.get("hospitalId")!= null && (Integer)dataMap.get("hospitalId")!= 0)
			hospitalId=(Integer)dataMap.get("hospitalId");

		if(vendorId != "")
		{
		List<StorePoHeader> poNumberList = session
				.createCriteria(StorePoHeader.class)
				.add(Restrictions.between("PoDate", fromDate, toDate))
				.add(Restrictions.eq("Hospital.Id",hospitalId ))
				.add(Restrictions.eq("Supplier.Id", Integer.parseInt(vendorId)))
				.addOrder(Order.desc("Id")).list();
		dataMap.put("poNumberList",poNumberList);
		}
		else
		{
			List<StorePoHeader> poNumberList = session
			.createCriteria(StorePoHeader.class)
			.add(Restrictions.between("PoDate", fromDate, toDate))
			.add(Restrictions.eq("Hospital.Id",hospitalId ))
			.addOrder(Order.desc("Id")).list();
	dataMap.put("poNumberList",poNumberList);
		}


		return dataMap;
	}	
	
}
