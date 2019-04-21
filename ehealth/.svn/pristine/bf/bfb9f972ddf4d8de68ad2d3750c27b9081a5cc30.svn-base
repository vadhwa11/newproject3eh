package jkt.hms.purchaseOrder.dataservice;


import static jkt.hms.util.RequestConstants.APPROVED_IN_AUCTION;
import static jkt.hms.util.RequestConstants.AUCTION_COMPLETE;
import static jkt.hms.util.RequestConstants.MARK_FOR_AUCTION;
import static jkt.hms.util.RequestConstants.NOT_FOR_AUCTION;
import static jkt.hms.util.RequestConstants.REJECT_IN_AUCTION;
import static jkt.hms.util.RequestConstants.TO_WARD;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadFile;
import jkt.hms.masters.business.AuctionDetail;
import jkt.hms.masters.business.HesEquipmentAssessories;
import jkt.hms.masters.business.HesEquipmentMaster;
import jkt.hms.masters.business.Hospital;
import jkt.hms.masters.business.MasAssetCategory;
import jkt.hms.masters.business.MasBedStatus;
import jkt.hms.masters.business.MasCategory;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasInstituteDepartment;
import jkt.hms.masters.business.MasInsuranceCompany;
import jkt.hms.masters.business.MasItemCategory;
import jkt.hms.masters.business.MasItemType;
import jkt.hms.masters.business.MasManufacturer;
import jkt.hms.masters.business.MasPriorityCodes;
import jkt.hms.masters.business.MasReferralDoctor;
import jkt.hms.masters.business.MasStoreGroup;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreItemConversion;
import jkt.hms.masters.business.MasStoreSection;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.MasStoreSupplierGroup;
import jkt.hms.masters.business.MasStoreUnit;
import jkt.hms.masters.business.MasUnitOfMeasurement;
import jkt.hms.masters.business.MmInspectionReport;
import jkt.hms.masters.business.MmMasRequestStatus;
import jkt.hms.masters.business.MmPreventiveCheckList;
import jkt.hms.masters.business.MmSafetyProcedureMaterials;
import jkt.hms.masters.business.MmServiceRequest;
import jkt.hms.masters.business.OneToOne;
import jkt.hms.masters.business.PrqAssetDetails;
import jkt.hms.masters.business.PrqInsuranceClaimDetails;
import jkt.hms.masters.business.PrqInsuranceDetails;
import jkt.hms.masters.business.PrqQuotationHeader;
import jkt.hms.masters.business.PrqQuotationItemDetails;
import jkt.hms.masters.business.PrqQuotationVendorDetails;
import jkt.hms.masters.business.StoreGrnM;
import jkt.hms.masters.business.StoreGrnT;
import jkt.hms.masters.business.StoreInternalIndentM;
import jkt.hms.masters.business.StoreInternalIndentT;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.StorePoDetail;
import jkt.hms.masters.business.StorePoHeader;
import jkt.hms.masters.business.StoreStockTakingM;
import jkt.hms.masters.business.StoreStockTakingT;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.hrms.masters.business.MasShift;
import jkt.hrms.util.SendMail;

import org.apache.derby.impl.sql.compile.CreateAliasNode;
import org.apache.log4j.Logger;
//import org.apache.poi.hssf.record.formula.functions.Setvalue;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.objectxp.a.h;

import static jkt.hms.util.RequestConstants.NOT_FOR_AUCTION;
import static jkt.hms.util.RequestConstants.MARK_FOR_AUCTION;
import static jkt.hms.util.RequestConstants.APPROVED_IN_AUCTION;
import static jkt.hms.util.RequestConstants.REJECT_IN_AUCTION;
import static jkt.hms.util.RequestConstants.AUCTION_COMPLETE;


public class ProcurementDataServiceImpl extends HibernateDaoSupport implements
ProcurementDataService {
	
	//logger 
	static final Logger log = Logger.getLogger(jkt.hms.purchaseOrder.dataservice.ProcurementDataServiceImpl.class);

    HibernateTransactionManager transactionManager=null;
    Session ses=null;
    
    //------------------------DataService for ShowPending Local purchase--------------------------
	@Override
	@SuppressWarnings("unchecked")
	public Map<String, Object> showPendingitemsforLocalPurchaseJsp(Box box,
			Map<String, Object> details) {

		Map<String, Object> map=new HashMap<String, Object>(); 
		Session session=(Session)getSession();
		List<StoreInternalIndentT> storelist=new ArrayList<StoreInternalIndentT>();
		List<MasStoreGroup> group1=new ArrayList<MasStoreGroup>();
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date fromDate=new Date();
		Date toDate=new Date();
		int hospitalId=0;
		int group11=0;
		if(details.get("hospitalId")!=null && details.get("hospitalId")!=""){
			hospitalId=(Integer)details.get("hospitalId");
		}
		System.out.println("hospitalId"+hospitalId);
		if(details.get("group") != null ){
			group11 = (Integer)details.get("group");
			
		}
		Criteria cr=session.createCriteria(StoreInternalIndentT.class,"sit")
				.createAlias( "sit.Item","ss")
				.createAlias("sit.Internal", "sim")
				.createAlias("sim.Hospital", "hos")
				.createAlias("ss.Group","grp")
				.add(Restrictions.eq("sit.NacStatus", "y").ignoreCase())
				.add(Restrictions.eq("grp.Id", group11))
				.add(Restrictions.eq("hos.Id",hospitalId));
		if(box.getString("fromDate")!=null && !box.getString("fromDate").equals("") && box.getString("toDate")!=null && !box.getString("toDate").equals("")){
			try{
			fromDate=sdf.parse(box.getString("fromDate"));
			toDate=sdf.parse(box.getString("toDate"));
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			//cr=cr.add(Restrictions.between("sim.KmsclProcessDate", fromDate, toDate));
		}
		  group1=session.createCriteria(MasStoreGroup.class).list();
		storelist=cr.list();
		List<Object[]> departmentIndentList = new ArrayList<Object[]>();
		if(storelist.size()>0){
			for(StoreInternalIndentT storeInternalIndentT:storelist){
				String instituteDemandNo = storeInternalIndentT.getInternal().getDemandNo();
				departmentIndentList = session.createCriteria(StoreInternalIndentT.class).createAlias("Internal", "internal").createAlias("internal.Department", "dept")
						.createAlias("Item", "item").add(Restrictions.eq("internal.ReferenceDemandNo", instituteDemandNo))
						.add(Restrictions.eq("internal.Hospital.Id", hospitalId)).setProjection(Projections.projectionList()
													.add(Projections.groupProperty("item.Id")).add(Projections.groupProperty("dept.DepartmentName"))).list();
				
			}
		}
		 map.put("storelist",storelist);
		 map.put("group1", group1);
		 map.put("departmentIndentList", departmentIndentList);
		return map;
	}
	//--------------------------------End-----------------------------------------------------
	
	//---------------------------Method for ShowQuotation requisition------------------------

	@Override
	@SuppressWarnings("unchecked")
	public Map<String, Object> showQuotationRequisitionJsp(Box box,Map<String, Object> dataMap) {
		
        Map<String, Object> map=new HashMap<String, Object>(); 
		Session session=(Session)getSession();
	    List suplist=new ArrayList();
		List<StoreInternalIndentT> itemList=new ArrayList<StoreInternalIndentT>();
		List<StoreInternalIndentT> storeInternalIndentTs=new ArrayList<StoreInternalIndentT>();
		List<MasStoreSupplier> supList=new ArrayList<MasStoreSupplier>();
		List<MasStoreSupplierGroup> suplierGroup=new ArrayList<MasStoreSupplierGroup>();
		List<UploadDocuments> uploadDocumentList = new ArrayList<UploadDocuments>();
		List<Integer> item=new ArrayList<Integer>();
		List<Integer> suplist1=new ArrayList<Integer>();
		
		
		int hospitalId=0;
		if(dataMap.get("hospitalId")!=null && dataMap.get("hospitalId")!=""){
			hospitalId=(Integer)dataMap.get("hospitalId");
		}
		if(dataMap.get("itemName")!=null ){
			item=(List<Integer>)dataMap.get("itemName");
		}
		Criteria cr=session.createCriteria(StoreInternalIndentT.class,"si").createAlias("Internal", "header")
					.add(Restrictions.eq("header.Hospital.Id", hospitalId)).createAlias( "si.Item","ss").add(Restrictions.eq("si.NacStatus", "y").ignoreCase());
			if(dataMap.get("itemName")!=null ){
				cr=cr.add(Restrictions.in("si.Id",item));
			}
		
			/*suplist1=session.createCriteria(MasStoreSupplierGroup.class,"grp")
					.createAlias("grp.Supplier","sup")
					.createAlias("grp.Group","stgp")
					.add(Restrictions.eq("stgp.Id", ))*/
			String hql="select msp.supplier_id, msp.supplier_name, msp.address1,msp.mobileno,msp.emailid  from mas_store_item msi LEFT OUTER JOIN mas_store_group msg ON msg.group_id=msi.group_id LEFT OUTER JOIN mas_store_supplier_group mss ON mss.group_id=msg.group_id LEFT OUTER JOIN mas_store_supplier msp ON msp.supplier_id=mss.supplier_id where msi.item_id in(select item_id from store_internal_indent_t ) group by msp.supplier_id;";
			Query qry=session.createSQLQuery(hql);
			suplist1=qry.list();
		 itemList=cr.list();
		 uploadDocumentList = session.createCriteria(UploadDocuments.class).add(Restrictions.isNotNull("StoreInternalT.Id")).list();
		 
		 
		 map.put("itemList",itemList);
		 map.put("uploadDocumentList",uploadDocumentList);
		 map.put("suplist1", suplist1);
		 return map;
	}

	
	//------------------------End--------------------------------------------
	
	
	
	

	/*@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getSectionGLList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreSection> masStoreSectionList = new ArrayList<MasStoreSection>();
		Session session = (Session) getSession();
		
		session = (Session) getSession();
		int type = 0;
		try {
			
			if(dataMap.get("type") != null ){
				type = (Integer)dataMap.get("type");
			}
			masStoreSectionList = session.createCriteria(MasStoreSection.class)
						.createAlias("ItemType", "g")
						.add(Restrictions.eq("g.Id",type))
						.add(Restrictions.eq("Status", "y").ignoreCase()).list();

} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("masStoreSectionList", masStoreSectionList);
		return map;

}		
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> responseQuotationRequisition(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreInternalIndentT> itemlist=new ArrayList<StoreInternalIndentT>();
		List<MasStoreSection> masStoreSectionList = new ArrayList<MasStoreSection>();
		List<MasStoreGroup> group=new ArrayList<MasStoreGroup>();
		List<MasItemType> itemtype=new ArrayList<MasItemType>();
		Session session = (Session) getSession();
		
			session = (Session) getSession();
			int type = 0;
			int section=0;
			int group1=0;
			try {
				
				if(dataMap.get("type") != null ){
					type = (Integer)dataMap.get("type");
					
				}
				if(dataMap.get("section") != null ){
					section = (Integer)dataMap.get("section");
					
				}
				if(dataMap.get("group") != null ){
					group1 = (Integer)dataMap.get("group");
					
				}
				System.out.println(group1+"+++++"+type+"---"+section);
				itemlist=(List<StoreInternalIndentT>) session.createCriteria(StoreInternalIndentT.class,"si")
						.createAlias( "si.Item","ss").add(Restrictions.eq("si.ItemStatus", "k"))
						.createAlias("ss.Group","grp")
						.createAlias("ss.Section","scn")
						.createAlias("ss.ItemType","itype")
						.add(Restrictions.eq("grp.Id", group1))
						.add(Restrictions.eq("itype.Id", type))
						.add(Restrictions.eq("scn.Id", section)).list();
				System.out.println("-------==-----"+itemlist.size());

	} catch (Exception e) {
				e.printStackTrace();
			}
                 
			map.put("itemlist", itemlist);
			return map;

	}		
*/
	//--------------------------Method for Open Vendor List------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> openVendorListJsp(Box box,Map<String, Object> dataMap) {


		Map<String, Object> map=new HashMap<String, Object>(); 
		Session session=(Session)getSession();
		List<Integer> suplist=new ArrayList<Integer>();
		int hospitalId=0;
		if(dataMap.get("hospitalId")!=null && dataMap.get("hospitalId")!=""){
			hospitalId=(Integer)dataMap.get("hospitalId");
		}
		String hql="select msp.supplier_id, msp.supplier_name, msp.address1 from mas_store_item msi LEFT OUTER JOIN mas_store_group msg ON msg.group_id=msi.group_id LEFT OUTER JOIN mas_store_supplier_group mss ON mss.group_id=msg.group_id LEFT OUTER JOIN mas_store_supplier msp ON msp.supplier_id=mss.supplier_id where msi.item_id in(select item_id from store_internal_indent_t siit where siit.item_status='k' ) group by msp.supplier_id;";
		Query qry=session.createSQLQuery(hql);
		suplist=qry.list();
		map.put("suplist", suplist);
		return map;
	}
	//--------------------End-------------------------------------------------------
	//Method for save Quotation requisition-------------------------------------

	@Override
	public Map<String, Object> saveQuotationRequisitionJsp(Box box,
			Map<String, Object> dataMap) {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		Map<String, String> map=new HashMap<String, String>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date cd=new Date();
		Date requiredDate=new Date();
		String msg="";
		Session session = (Session) getSession();
		int districtId = 0;
		if(dataMap.get("districtId") != null){
			districtId = (Integer)dataMap.get("districtId");
		}
		String mmMasRequestStatusPending = "";
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			mmMasRequestStatusPending = prop.getProperty("pendingItems");
		} catch (IOException e) {
			e.printStackTrace();
		}
		int hospitalId=(Integer)dataMap.get("hospitalId");
		/*List<StoreInternalIndentT> districtStoreInternalIndentTList = new ArrayList<StoreInternalIndentT>();
		districtStoreInternalIndentTList = session.createCriteria(StoreInternalIndentT.class).createAlias("Internal", "header").add(Restrictions.eq("ItemStatus", "h"))
											.createAlias("header.District", "district").add(Restrictions.eq("district.Id", districtId)).list();
		
		List<StoreInternalIndentT> instituteStoreInternalIndentTList = new ArrayList<StoreInternalIndentT>();
		instituteStoreInternalIndentTList = session.createCriteria(StoreInternalIndentT.class).createAlias("Internal", "header").add(Restrictions.eq("ItemStatus", "g"))
											.createAlias("header.Hospital", "hospital").add(Restrictions.eq("hospital.Id", hospitalId)).list();*/
		int itemCount=box.getInt("itemcount");
		PrqQuotationHeader hdr=null;
		StoreInternalIndentT indentT=null;
		int indentItemQty = 0;
		int qutationItemQty = 0;
		BigDecimal indentQuationQty = new BigDecimal(0);
		hdr=new PrqQuotationHeader();
		int userId=(Integer)dataMap.get(RequestConstants.USER_ID);
		if(userId!=0){
		Users users=new Users();
		users.setId(userId);
	
		hdr.setQuotationBy(users);
		}
		hdr.setQuotationDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("quotationRequisitionDate")));
		 hospitalId=(Integer)dataMap.get("hospitalId");
		//System.out.println(dataMap.get(hospitalId)+"kofrghfr"+hospitalId);
		MasHospital hospital=new MasHospital();
		MmMasRequestStatus status=(MmMasRequestStatus) session
				.createCriteria(MmMasRequestStatus.class)
				.add(Restrictions
						.eq("StatusCode", mmMasRequestStatusPending))
				.uniqueResult();
		hdr.setQuotationStatus(status);
		hospital.setId(hospitalId);
		hdr.setHospital(hospital);
		hdr.setLastChgDate(date);
		hdr.setLastChgTime(time);
		int hdrId=(Integer) hbt.save(hdr);
		hdr.setQuotationNo("quata"+"/"+hospitalId+"/"+hdrId);
		ArrayList venderIds=box.getArrayList("selectCheckBox");
	
		if(venderIds!=null && venderIds.size()>0)
		{
			for (Object object : venderIds) {
				PrqQuotationVendorDetails vendor=new PrqQuotationVendorDetails();
				vendor.setHeader(hdr);
				MasStoreSupplier masStoreSupplier=new MasStoreSupplier();
				masStoreSupplier.setId(new Integer((String)object));
				vendor.setVendor(masStoreSupplier);
				hbt.save(vendor);
				for(int i=1;i<=itemCount;i++)
				{   
					  indentT=(StoreInternalIndentT) session.load(StoreInternalIndentT.class, box.getInt("itemId1"+i));
					  indentItemQty = box.getInt("indentItemQty"+i);
					  //System.out.println("indentItemQty=="+indentItemQty);
					  indentQuationQty =new BigDecimal(box.getInt("indentQuationQty"+i));
					// System.out.println("indentQuationQty=="+indentQuationQty);
					  qutationItemQty = box.getInt("quotationRequisitionQty"+i);
					 //System.out.println("qutationItemQty=="+qutationItemQty);
					if(indentQuationQty != null && !indentQuationQty.equals("")){
						  if(indentItemQty==qutationItemQty){
							  indentT.setItemStatus("q");
							  indentT.setQuatationQty(new BigDecimal(qutationItemQty).add(indentQuationQty));
							  indentT.setQtyRequest(indentItemQty-qutationItemQty);
							  hbt.update(indentT);
						  }else if(qutationItemQty<indentItemQty){
							 // indentT.setItemStatus("n");
							  indentT.setQuatationQty(new BigDecimal(qutationItemQty).add(indentQuationQty));
							  indentT.setQtyRequest(indentItemQty-qutationItemQty);
							  hbt.update(indentT); 
						  }
					 }
					
	/*//====================================update indent district wise====================================
					if(districtStoreInternalIndentTList.size()>0){
						for(StoreInternalIndentT districtInternalIndentT :districtStoreInternalIndentTList){
							int indentTId = districtInternalIndentT.getId();
							//System.out.println("indentTId11111111111111=="+indentTId);
							StoreInternalIndentT districtindentT=(StoreInternalIndentT) session.load(StoreInternalIndentT.class, indentTId);
							  indentItemQty = districtInternalIndentT.getQtyRequest();
							  indentQuationQty =new BigDecimal(box.getInt("indentQuationQty"+i));
							  qutationItemQty = box.getInt("quotationRequisitionQty"+i);
							if(indentQuationQty != null && !indentQuationQty.equals("")){
								  if(indentItemQty==qutationItemQty){
									 // System.out.println("==in if=1111==");
									  districtindentT.setItemStatus("q");
									  districtindentT.setProcurementStatus("DNAC");
									  districtindentT.setItemStatus("n");
									  districtindentT.setQuatationQty(new BigDecimal(qutationItemQty).add(indentQuationQty));
									  districtindentT.setQtyRequest(indentItemQty-qutationItemQty);
									  hbt.update(districtindentT);
								  }else if(qutationItemQty<indentItemQty){
									  //System.out.println("==in else if=2222==");
									  districtindentT.setProcurementStatus("DNAC");
									  districtindentT.setQuatationQty(new BigDecimal(qutationItemQty).add(indentQuationQty));
									  districtindentT.setQtyRequest(indentItemQty-qutationItemQty);
									  hbt.update(districtindentT); 
								  }
							 }
						}
					}
//====================================update indent institute wise====================================
					if(instituteStoreInternalIndentTList.size()>0){
						for(StoreInternalIndentT instituteInternalIndentT :instituteStoreInternalIndentTList){
							int indentTId = instituteInternalIndentT.getId();
							//System.out.println("indentTId222222222222222=="+indentTId);
							StoreInternalIndentT instituteindentT=(StoreInternalIndentT) session.load(StoreInternalIndentT.class, indentTId);
							  indentItemQty = instituteInternalIndentT.getQtyRequest();
							  indentQuationQty =new BigDecimal(box.getInt("indentQuationQty"+i));
							  qutationItemQty = box.getInt("quotationRequisitionQty"+i);
							if(indentQuationQty != null && !indentQuationQty.equals("")){
								  if(indentItemQty==qutationItemQty){
									 // System.out.println("==in if=333==");
									  instituteindentT.setItemStatus("q");
									  instituteindentT.setProcurementStatus("INAC");
									  instituteindentT.setQuatationQty(new BigDecimal(qutationItemQty).add(indentQuationQty));
									  instituteindentT.setQtyRequest(indentItemQty-qutationItemQty);
									  hbt.update(instituteindentT);
								  }else if(qutationItemQty<indentItemQty){
									 //System.out.println("==in else if=4444==");
									  instituteindentT.setItemStatus("n");
									  instituteindentT.setProcurementStatus("INAC");
									  instituteindentT.setQuatationQty(new BigDecimal(qutationItemQty).add(indentQuationQty));
									  instituteindentT.setQtyRequest(indentItemQty-qutationItemQty);
									  hbt.update(instituteindentT); 
								  }
							 }
						}
					}*/
					if(venderIds!=null && venderIds.size()>0)
					{
						for (Object object1 : venderIds) {
							if(box.getString("mobileno"+i)!=null && !box.getString("mobileno"+i).equals(""))
							{
							OneToOne oneToOne =new OneToOne();
							oneToOne.setMessage("Quotation Number=="+"quata"+"/"+hospitalId+"/"+hdrId+" has been sent kindly submit the same");
						   oneToOne.setMobileNo(box.getString("mobileno"+i));
						   oneToOne.setSentDate(date);
						   oneToOne.setSentTime(time);
						   oneToOne.setType("T");
						   oneToOne.setStatus("U");
						   hbt.save(oneToOne);
							}
						}
					}
					PrqQuotationItemDetails items=new PrqQuotationItemDetails();
					int itemId=box.getInt("itemId"+i);
					MasStoreItem masStoreItem=new MasStoreItem();
					masStoreItem.setId(itemId);
					items.setItem(masStoreItem);
					items.setReqQty(new BigDecimal(box.getInt("quotationRequisitionQty"+i)));
					items.setVendorDetails(vendor);
					hbt.save(items);
					
					/*
					 * Mail Integration By Ujjwal Kashyap
					 * on Dated 24/09/2015
					 * at 4:54 pm
					 */
					String fromEmail="";
					String toEmail="";
					String messageToBeSent="";
					String itemName="";
					List<String> name=new ArrayList<String>();
					name=session.createCriteria(MasStoreItem.class).add(Restrictions.idEq(itemId)).setProjection(Projections.property("Nomenclature")).list();
					String nomenclature="";
					if(name.size()>0){
					nomenclature=name.get(0);
					}
					if(venderIds!=null && venderIds.size()>0)
					{
						for (Object object11 : venderIds) {
							List<Users> userList=new ArrayList<Users>();
							int vendorId=0;
									vendorId=(new Integer((String)object));
							userList=session.createCriteria(Users.class).add(Restrictions.idEq(vendorId)).list();
							for(Users user:userList){
								fromEmail=user.getEmailAddress();
							}
								SendMail sendMail=new SendMail();
								messageToBeSent="Quotation Number=="+"quata"+"/"+hospitalId+"/"+hdrId+" has been sent kindly submit the same";
								if(box.getString("emailId"+i)!=null && !box.getString("emailId"+i).equals(""))
								{
								toEmail=box.getString("emailId"+i);
								}
								String Subject="Quotation Info for Item:"+nomenclature;
						
								try{
									sendMail.sendMail("mail.jkt.com", toEmail, fromEmail, "", "", Subject, messageToBeSent);
								}catch(Exception e){
									e.printStackTrace();
								}
						
						}
					}
					//End By Ujjwal on  24/09/2015
					
				}
			}
			
		}
		hbt.flush();
		hbt.clear();
		msg="<span style='color: red'>Successfully Save.</span>";
		
		/*for(int i=1;i<=itemCount;i++)
		{
			ArrayList venderList=box.getArrayList("venderID"+i);
			
			if(venderList!=null && venderList.size()>0 && hdr==null)
			{
				
				
			}
			if(venderList!=null && venderList.size()>0)
			{
				PrqQuotationVendorDetils vendor=new PrqQuotationVendorDetils();
				vendor.setHeader(hdr);
				vendor.
				MasStoreSupplier masStoreSupplier=new MasStoreSupplier();
				masStoreSupplier.setId(new Integer((String)venderList.get()));
				vendor.setVendor(masStoreSupplier);
				hbt.save(vendor);
				for (int j = 0; j < venderList.size(); j++) {
					PrqQuotationItemDetails items=new PrqQuotationItemDetails();
					int itemId=box.getInt("itemId"+i);
					MasStoreItem masStoreItem=new MasStoreItem();
					masStoreItem.setId(itemId);
					items.setItem(masStoreItem);
					items.setReqQty(new BigDecimal(box.getInt("quotationRequisitionQty"+i)));
					hbt.save(items);
					vendor.setItemDetails(items);
				
				}
		}
		
		hbt.flush();
		hbt.clear();
		msg="<span style='color: red'>Successfully Save.</span>";
	}*/
		dataMap.put("msg",msg);
		return dataMap;
	}

	//-------------------------------End-------------------------------------------------
	
	//----------------------------Method for Show Pending list for Approval------------------
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showPendingListForApprovalOfQuotationRequisitionJsp(
			Box box, Map<String, Object> dataMap) {
		

		Map<String, Object> map=new HashMap<String, Object>(); 
		Session session=(Session)getSession();
		List<PrqQuotationHeader> plist=new ArrayList<PrqQuotationHeader>();
		List<MasEmployee> user=new ArrayList<MasEmployee>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date fromDate=new Date();
		Date toDate=new Date();
		int hospitalId=0;
		String pendingStatus="";
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				  .getResource("adt.properties");
		                     try {
			                 Properties prop = new Properties();
			                 prop.load(new FileInputStream(new File(resourcePath.getFile())));
			                 pendingStatus=prop.getProperty("pendingItems");
		                              } catch (IOException e) {
			                                e.printStackTrace();
		                                       }
		if(dataMap.get("hospitalId")!=null && dataMap.get("hospitalId")!=""){
			hospitalId=(Integer)dataMap.get("hospitalId");
		}
		Criteria cr=session.createCriteria(PrqQuotationHeader.class,"prq")
				.createAlias("prq.QuotationBy", "u")
				.createAlias("prq.QuotationStatus", "stat")
				.createAlias("prq.Hospital", "hosp")
				.add(Restrictions.eq("stat.StatusCode",pendingStatus))
				.add(Restrictions.eq("hosp.Id",hospitalId))
				.addOrder(Order.desc("prq.QuotationDate"));
		if(box.getString("fromDate")!=null && !box.getString("fromDate").equals("") && box.getString("toDate")!=null && !box.getString("toDate").equals("")){
			try{
			fromDate=sdf.parse(box.getString("fromDate"));
			toDate=sdf.parse(box.getString("toDate"));
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			cr=cr.add(Restrictions.between("prq.QuotationDate", fromDate, toDate));
		}
		if(box.getString("quotationRequisitionNo")!=null && !box.getString("quotationRequisitionNo").equals("")){
			
			cr=cr.add(Restrictions.eq("prq.QuotationNo", box.getString("quotationRequisitionNo")));
		}
          if(box.getString("quotationRequisitionBy")!=null && !box.getString("quotationRequisitionBy").equals("")){
			
			cr=cr.add(Restrictions.eq("u.UserName", box.getString("quotationRequisitionBy")));
		}
		 plist=cr.list();
		 user=session.createCriteria(MasEmployee.class)
				 .add(Restrictions.eq("Status","y").ignoreCase())
				 .add(Restrictions.isNotNull("EmployeeName"))
				 .add(Restrictions.eq("Hospital.Id",hospitalId)).list();
		 map.put("plist", plist);
		 map.put("user", user);
		
		return map;
	}

	//--------------------------------------------End------------------------------------
	//-----------------Method showing list for quotation Requisition approval--------------
	@Override
	public Map<String, Object> showQuotationRequisitionApprovalJsp(Box box,
			Map<String, Object> dataMap) {
		

		Map<String, Object> map=new HashMap<String, Object>(); 
		Session session=(Session)getSession();
		List<PrqQuotationHeader> pendinglist=new ArrayList<PrqQuotationHeader>();
		List<PrqQuotationItemDetails>itemList=new ArrayList<PrqQuotationItemDetails>();
		List<PrqQuotationVendorDetails> vendorList=new ArrayList<PrqQuotationVendorDetails>();
		List<MmMasRequestStatus> status=new ArrayList<MmMasRequestStatus>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date fromDate=new Date();
		Date toDate=new Date();
		int hospitalId=0;
		int requisitionId=0;
		String[] approvedStatus=null;
		 URL resourcePath = Thread.currentThread().getContextClassLoader()
				  .getResource("adt.properties");
		                     try {
			                 Properties prop = new Properties();
			                 prop.load(new FileInputStream(new File(resourcePath.getFile())));
			                 approvedStatus = prop.getProperty("submission.status.list").split("#");
		                              } catch (IOException e) {
			                                e.printStackTrace();
		                                       }

		if(dataMap.get("hospitalId")!=null && dataMap.get("hospitalId")!=""){
			hospitalId=(Integer)dataMap.get("hospitalId");
		}
		if(dataMap.get("requisitionId")!=null && dataMap.get("requisitionId")!=""){
			requisitionId=(Integer)dataMap.get("requisitionId");
		}
		Criteria cr=session.createCriteria(PrqQuotationItemDetails.class,"prq")
				.createAlias("prq.VendorDetails", "ven")
				.createAlias("ven.Header", "hdr")
				.createAlias("hdr.Hospital", "hospital")
				.add(Restrictions.eq("hospital.Id", hospitalId))
				.add(Restrictions.eq("hdr.Id",requisitionId));
		
		itemList=cr.list();
		Criteria cv=session.createCriteria(PrqQuotationVendorDetails.class,"ven")
				.createAlias("ven.Header", "hdr")
				.createAlias("hdr.Hospital", "hospital")
				.add(Restrictions.eq("hospital.Id", hospitalId))
				.add(Restrictions.eq("hdr.Id",requisitionId));
		vendorList=cv.list();
	//	System.out.println("hhhh---"+vendorList.size());
		Criteria cc=session.createCriteria(MmMasRequestStatus.class,"stat")
				.add(Restrictions.in("StatusCode", approvedStatus));
		status=cc.list();
		map.put("vendorList", vendorList);
		map.put("status", status);
		map.put("itemList", itemList);
		
		return map;
	}
    //---------------------------End-----------------------------------------------------
	
	
	//----------------Method For show vendor list-------------------------------------------
	/*@Override
	public Map<String, Object> showVendorListJsp(Box box,
			Map<String, Object> dataMap) {

		Map<String, Object> map=new HashMap<String, Object>(); 
		Session session=(Session)getSession();
	//	List<PrqQuotationVendorDetils>vendorList=new ArrayList<PrqQuotationVendorDetils>();

		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date fromDate=new Date();
		Date toDate=new Date();
		int hospitalId=0;
		int requisitionId=0;
		if(dataMap.get("hospitalId")!=null && dataMap.get("hospitalId")!=""){
			hospitalId=(Integer)dataMap.get("hospitalId");
		}
		if(dataMap.get("requisitionId")!=null && dataMap.get("requisitionId")!=""){
			requisitionId=(Integer)dataMap.get("requisitionId");
		}
		Criteria cr=session.createCriteria(PrqQuotationVendorDetils.class,"prq")
				.createAlias("prq.ItemDetails", "item")
				.add(Restrictions.eq("item.Id",requisitionId));
		  vendorList=cr.list();
		//map.put("vendorList", vendorList);
		return map;
	}*/
    //---------------------------End----------------------------------------------
	
	
	//--------------Method save quotation for approval----------------------------
	
	@Override
	public Map<String, Object> saveQuotationRequisitionApprovalJsp(Box box,
			Map<String, Object> dataMap) {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		Map<String, String> map=new HashMap<String, String>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		int userId=(Integer)dataMap.get(RequestConstants.USER_ID);
		int hospitalId=(Integer)dataMap.get(RequestConstants.HOSPITAL_ID);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		Date cd=new Date();
		Date requiredDate=new Date();
		String msg="";
		Session session = (Session) getSession();
		MmMasRequestStatus mmasRequestStatus=new MmMasRequestStatus();
		List<MmMasRequestStatus> status1=new ArrayList<MmMasRequestStatus>();
		status1=session.createCriteria(MmMasRequestStatus.class).add(Restrictions.eq("StatusCode", box.getString("status"))).list();
		int itemCount=box.getInt("itemcount");
		PrqQuotationHeader hdr=(PrqQuotationHeader) session.get(PrqQuotationHeader.class,box.getInt("headerId"));
		Users users=new Users();
		users.setId(userId);
		hdr.setApprovalBy(users);
		hdr.setLastChgDate(date);
		hdr.setLastChgTime(time);
		MasHospital hospital=new MasHospital();
		hospital.setId(hospitalId);
		hdr.setHospital(hospital);
		hdr.setApprovalRemarks(box.getString("remarks"));
		// Add by Vinay
		
		hdr.setQuotationDueDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("dueDateQuotation")));
		hdr.setQuotationOpeningDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("openingDateQuotation")));
		hdr.setDateUptoRatesRemainSame(HMSUtil.dateFormatterDDMMYYYY(box.getString("dateuptoratesremainsame")));
		hdr.setQuotationDueTime(box.getString("dueTimeQuotation"));
		hdr.setQuotationOpeningTime(box.getString("openingTimeQuotation"));
		
		mmasRequestStatus.setId(status1.get(0).getId());
		hdr.setQuotationStatus(mmasRequestStatus);
		hdr.setApprovalDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("quotationRequisitionDate1")));
		ArrayList venderList=box.getArrayList("selectCheckBox2");
		for (int j = 0; j < venderList.size(); j++) {
			if(!((String)venderList.get(j)).equals("on"))
			{
			PrqQuotationVendorDetails vendor=(PrqQuotationVendorDetails) session.get(PrqQuotationVendorDetails.class,new Integer((String)venderList.get(j)));
			vendor.setVendorFlag("s");
			hbt.update(vendor);
			for(int i=1;i<=itemCount;i++)
			{
				if( box.getInt("selectItem"+i)!=0)
				{
					PrqQuotationItemDetails items=(PrqQuotationItemDetails) session.createCriteria(PrqQuotationItemDetails.class)
							                      .createAlias("VendorDetails", "vender")
							                       .createAlias("Item", "item")
							                      .createAlias("vender.Header", "hdr")
							                      .add(Restrictions.eq("hdr.Id", box.getInt("headerId")))
							                      .add(Restrictions.eq("item.Id",box.getInt("selectItem"+i)))
							                      .add(Restrictions.eq("vender.Id", new Integer((String)venderList.get(j))))
							                      .uniqueResult();
					
					if(items!=null)
					{
					mmasRequestStatus.setId(status1.get(0).getId());
					items.setItemStatus(mmasRequestStatus);
					items.setApprovedQty(new BigDecimal(box.getInt("quotationRequisitionQty"+i)));
					hbt.update(items);
					}
							
				}
		}
			}
		}
		String hql="update PrqQuotationVendorDetails set VendorFlag='d' where (VendorFlag!='s' or VendorFlag is null) and Header.Id="+box.getInt("headerId");
		session.createQuery(hql).executeUpdate();
		
		
		hbt.flush();
		hbt.clear();
		msg="<span style='color: red'>Successfully Save.</span>";
		
		 int quotationId = hdr.getId();
			int locationId = hdr.getHospital().getId();
    	 hbt.clear();
		   // msg="<span style='color: green'>Successfully Po Create</span>";
		    
		    msg="<span style='color: green'> Quotation Requisition Approved Successfully Do You want to print.</span><span><a href=\"stores?method=printQuotationNotice&quotationId="+quotationId+"&locationId="+locationId+"\">Quatation Notice</a></span>";
		    
		/*
		for(int i=1;i<=itemCount;i++)
		{
			ArrayList venderList=box.getArrayList("venderID"+i);
			if( box.getInt("selectCheckBox"+i)!=0)
			{
				PrqQuotationItemDetails items=(PrqQuotationItemDetails) session.get(PrqQuotationItemDetails.class,box.getInt("selectCheckBox"+i));
				MmMasRequestStatus masRequestStatus=new MmMasRequestStatus();
				masRequestStatus.setId(box.getInt("status"));
				items.setItemStatus(masRequestStatus);
				items.setApprovedQty(new BigDecimal(box.getInt("quotationRequisitionQty"+i)));
				hbt.save(items);
				for (int j = 0; j < venderList.size(); j++) {
					PrqQuotationVendorDetils vendor=(PrqQuotationVendorDetils) session.get(PrqQuotationVendorDetils.class,new Integer((String)venderList.get(j)));
					vendor.setVendorFlag("s");
					hbt.update(vendor);
				}
			String hql="update PrqQuotationVendorDetils set VendorFlag='d' where VendorFlag!='s'";
			session.createQuery(hql).executeUpdate();
			}
		
		hbt.flush();
		hbt.clear();
		msg="<span style='color: red'>Successfully Save.</span>";
	}*/
		dataMap.put("msg",msg);
		return dataMap;
	}

	//------------------End-----------------------------------------------------

//---------------------show pending list for submitting quotation-----------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showPendingListForSubmittingQuotationJsp(
			Box box, Map<String, Object> dataMap) {

		Map<String, Object> map=new HashMap<String, Object>(); 
		List<PrqQuotationHeader> prqHdr=new ArrayList<PrqQuotationHeader>();
		List<PrqQuotationVendorDetails> vendorList=new ArrayList<PrqQuotationVendorDetails>();
		List<MmMasRequestStatus> status=new ArrayList<MmMasRequestStatus>();
		List<MasEmployee> users=new ArrayList<MasEmployee>();
		Session session=(Session)getSession();

		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date fromDate=new Date();
		Date toDate=new Date();
		int hospitalId=0;
		int requisitionId=0;
		String statusApp=null;
		 URL resourcePath = Thread.currentThread().getContextClassLoader()
				  .getResource("adt.properties");
		                     try {
			                 Properties prop = new Properties();
			                 prop.load(new FileInputStream(new File(resourcePath.getFile())));
			                 statusApp=prop.getProperty("approvedStatus");
		                              } catch (IOException e) {
			                                e.printStackTrace();
		                                       }
		if(dataMap.get("hospitalId")!=null && dataMap.get("hospitalId")!=""){
			hospitalId=(Integer)dataMap.get("hospitalId");
			Criteria cr=session.createCriteria(PrqQuotationHeader.class,"prq")
					.createAlias("prq.QuotationBy", "u")
					.createAlias("prq.QuotationStatus", "stats")
					.createAlias("prq.Hospital", "hospital")
					.add(Restrictions.eq("stats.StatusCode", statusApp))
					.add(Restrictions.eq("hospital.Id",hospitalId))
			        .addOrder(Order.desc("prq.QuotationDate"));
			if(box.getString("fromDate")!=null && !box.getString("fromDate").equals("") && box.getString("toDate")!=null && !box.getString("toDate").equals("")){
				try{
				fromDate=sdf.parse(box.getString("fromDate"));
				toDate=sdf.parse(box.getString("toDate"));
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				cr=cr.add(Restrictions.between("prq.QuotationDate", fromDate, toDate));
			}
			if(box.getString("quotationRequisitionNo")!=null && !box.getString("quotationRequisitionNo").equals("")){
				
				cr=cr.add(Restrictions.eq("prq.QuotationNo", box.getString("quotationRequisitionNo")));
			}
	          if(box.getString("quotationRequisitionBy")!=null && !box.getString("quotationRequisitionBy").equals("")){
				
				cr=cr.add(Restrictions.eq("u.UserName", box.getString("quotationRequisitionBy")));
			}
	          prqHdr=cr.list();
	         // System.out.println("----"+vendorList.size());
			 users=session.createCriteria(MasEmployee.class)
					 .add(Restrictions.eq("Status","y").ignoreCase())
					  .add(Restrictions.isNotNull("EmployeeName"))
					 .add(Restrictions.eq("Hospital.Id",hospitalId)).list();
			 map.put("prqHdr", prqHdr);
			 map.put("users", users);
			
		}
		return map;
	}

	//---------------show quotation submission----------------------------------
	public Map<String, Object> showQuotationSubmissionJsp(Box box,
			Map<String, Object> dataMap) {
		

		Map<String, Object> map=new HashMap<String, Object>(); 
		Session session=(Session)getSession();
		List<PrqQuotationHeader> pendinglist=new ArrayList<PrqQuotationHeader>();
		List<PrqQuotationVendorDetails> vendorList=new ArrayList<PrqQuotationVendorDetails>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date fromDate=new Date();
		Date toDate=new Date();
		int hospitalId=0;
		int requisitionId=box.getInt("requitionId");

		if(dataMap.get("hospitalId")!=null && dataMap.get("hospitalId")!=""){
			hospitalId=(Integer)dataMap.get("hospitalId");
		}
		if(dataMap.get("requisitionId")!=null && dataMap.get("requisitionId")!=""){
			requisitionId=(Integer)dataMap.get("requisitionId");
		}
		Criteria cr=session.createCriteria(PrqQuotationVendorDetails.class,"prq")
				.createAlias("prq.Header", "hdr")
				.createAlias("hdr.Hospital", "hos")
				.add(Restrictions.eq("hdr.Id",requisitionId))
					.add(Restrictions.eq("hos.Id",hospitalId))
		        .add(Restrictions.eq("prq.VendorFlag", "s"));
		    vendorList=cr.list();
		//System.out.println("-----"+vendorList.size());
		Criteria cc=session.createCriteria(PrqQuotationHeader.class,"hdr")
				.add(Restrictions.eq("hdr.Id",requisitionId));
		    pendinglist=cc.list();
		    map.put("pendinglist", pendinglist);
		    map.put("vendorList", vendorList);
		return map;
	}
	
	
	//----------------------------------End-----------------------------------------
 	@Override
	public Map<String, Object> showAccessoryDetailsJsp(Box box,Map<String, Object> dataMap) {

			Map<String, Object> map=new HashMap<String, Object>(); 
			Session session=(Session)getSession();
			List<PrqQuotationItemDetails> item=new ArrayList<PrqQuotationItemDetails>();
			List<PrqQuotationVendorDetails> vendorList=new ArrayList<PrqQuotationVendorDetails>();
			List<MasManufacturer> manufacturer=new ArrayList<MasManufacturer>();

			   int requestId=box.getInt("requestId");
			
			    Criteria cr=session.createCriteria(PrqQuotationVendorDetails.class)
					 .add(Restrictions.eq("Id",requestId));
			             vendorList=cr.list();
			      item=session.createCriteria(PrqQuotationItemDetails.class, "vd")
					 .createAlias("vd.VendorDetails", "i")
					 .add(Restrictions.eq("i.Id", requestId)).list();
			     manufacturer = session.createCriteria(MasManufacturer.class).add(Restrictions.eq("Status","y")).list();
			 map.put("manufacturer", manufacturer);
			 map.put("item", item);
			 map.put("vendorList", vendorList);
		  return map;
	}
 	
 	//-------------------------------------End-------------------------------------------------------------
 	//-----------------------------Method for Save Selected Items And Vendor Details-----------------------------------------------------------------------
 	@SuppressWarnings("unchecked")
	public Map<String, Object> saveAccessoryDetailsJsp(Box box,Map<String, Object> dataMap) {
 		
 		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		Map<String, String> map=new HashMap<String, String>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		int userId=(Integer)dataMap.get(RequestConstants.USER_ID);
		int hospitalId=(Integer)dataMap.get(RequestConstants.HOSPITAL_ID);
		Date cd=new Date();
		Date requiredDate=new Date();
		String msg="";
		Session session = (Session) getSession();
		    String mmMasRequestStatusClosed = "";
		         URL resourcePath = Thread.currentThread().getContextClassLoader()
				  .getResource("adt.properties");
		                     try {
			                 Properties prop = new Properties();
			                 prop.load(new FileInputStream(new File(resourcePath.getFile())));
			                  mmMasRequestStatusClosed = prop.getProperty("mmMasRequestStatusClosed");
		                              } catch (IOException e) {
			                                e.printStackTrace();
		                                       }
		
		                          MmMasRequestStatus status=(MmMasRequestStatus) session
						            .createCriteria(MmMasRequestStatus.class)
						               .add(Restrictions
								           .eq("StatusCode", mmMasRequestStatusClosed))
						                      .uniqueResult();
		                  int itemCount=box.getInt("itemCount");
		                  PrqQuotationHeader hdr=null;
		                   hdr=(PrqQuotationHeader) session.load(PrqQuotationHeader.class,box.getInt("headerId"));
		                   MasHospital hospital=new MasHospital();
		                   hospital.setId(hospitalId);
		                   hdr.setHospital(hospital);
		                  Users users=new Users();
		                  users.setId(userId);
		                  hdr.setSubmissionBy(users.getEmployee());
		                  hdr.setLastChgTime(time);
		                  hdr.setLastChgDate(date);
	                  hdr.setSubmissionDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("quotationSubmissionDate")));
	                  hbt.update(hdr);
	   	    
	              PrqQuotationVendorDetails vendor=(PrqQuotationVendorDetails) session.load(PrqQuotationVendorDetails.class,box.getInt("requestId"));
		            // vendor.setVendorFlag("a");
		                hbt.update(vendor);
		                
	 
		          for(int i=1;i<=itemCount;i++)
	         	      {
			        if( box.getInt("manufacture"+i)!=0)
			        {
			        	int id = box.getInt("item"+i);
			        	PrqQuotationItemDetails items=(PrqQuotationItemDetails) session.load(PrqQuotationItemDetails.class, id);
			        
			        	MasManufacturer manufacturer=new MasManufacturer();
			        	manufacturer.setId(box.getInt("manufacture"+i));
			        	items.setManufacturedBy(manufacturer);
			        	/*MmMasRequestStatus stat=new MmMasRequestStatus();
			        	stat.setId(5);*/
			        	items.setItemStatus(status);
			        	items.setAmount(new BigDecimal(box.getFloat("ammount"+i)));
			        	items.setRate(new BigDecimal(box.getFloat("rate"+i)));
			        	items.setExciseDutyType(box.getString("exciseOption"+i));
			        	items.setExciseDutyAmount(new BigDecimal(box.getFloat("exciseDuty"+i)));
			        	items.setNetAmount(new BigDecimal(box.getFloat("netAmount"+i)));
			        	items.setDiscountPercent(new BigDecimal(box.getFloat("dicount"+i)));
			        	items.setQuantity(new BigDecimal(box.getFloat("qty"+i)));
			        	items.setRemarks(box.getString("remarks"+i));
			        	items.setTax(new BigDecimal(box.getFloat("tax"+i)));
			        	items.setTechSpecs(box.getString("technicalSpecification"+i));
			        	items.setTotalAmount(new BigDecimal(box.getFloat("totalAmmount"+i)));
			        	items.setVat(new BigDecimal(box.getFloat("vat"+i)));
			        	hbt.update(items);
			        	
			        }
			        
			        List<PrqQuotationVendorDetails> prqQuotationVendorDetails=new ArrayList<PrqQuotationVendorDetails>();
			        prqQuotationVendorDetails=session.createCriteria(PrqQuotationItemDetails.class)
			        		.createAlias("VendorDetails", "vdtl")
			        		.createAlias("vdtl.Header", "hdr")
			        		.add(Restrictions.ne("vdtl.Id", box.getInt("requestId"))) 
			        		.add(Restrictions.eq("hdr.Id", box.getInt("headerId")))
			        		.add(Restrictions.eq("vdtl.VendorFlag", "s"))
			        		.add(Restrictions.isNull("Rate"))
			        		.setProjection(Projections.projectionList().add(Projections.property("VendorDetails")))
			        		.list();
			        
			        if(prqQuotationVendorDetails.size()==0)
			        {
			        	hdr.setQuotationStatus(status);
			        	hbt.update(hdr);
			        }
			        
			        
		hbt.flush();
		hbt.clear();
		msg="<span style='color: red'>Successfully Save.</span>";
	}
		    
		dataMap.put("msg",msg);
		return dataMap;
	}
	
      
 	//------------------------------End-----------------------------------------------------------------------------------------------
 	
 	//------------------------------method for save Quotation Submission------------------------------------------------------------
/*	public Map<String, Object> saveItemQuotationSubmissionJsp(Box box,Map<String, Object> dataMap) {

		Map<String, Object> map=new HashMap<String, Object>(); 
		Session session=(Session)getSession();

		
	  return null;
}*/
 
	//=============================End=====================================================================================================
	@SuppressWarnings("unchecked")
	
	@Override
	public Map<String, Object> getItemTypeGLList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PrqQuotationVendorDetails> prqItem=new ArrayList<PrqQuotationVendorDetails>();
		List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
		List<MmInspectionReport> inspectionReports=new ArrayList<MmInspectionReport>();
		Session session = (Session) getSession();
		
		session = (Session) getSession();
		int quotationRequisitionNo = 0;
		String flag="";
		try {
			//System.out.println("=Qo=="+dataMap.get("quotationRequisitionNo"));
			if(dataMap.get("quotationRequisitionNo") != null ){
				quotationRequisitionNo = Integer.parseInt(dataMap.get("quotationRequisitionNo").toString().split("@")[0]);
				flag=dataMap.get("quotationRequisitionNo").toString().split("@")[1];
			}
			
			if(flag!="" && flag.equalsIgnoreCase("Q")){
			 Criteria cr=session.createCriteria(PrqQuotationVendorDetails.class,"vendor")
				     .createAlias("vendor.Header", "hdr")
				     .add(Restrictions.eq("hdr.Id",quotationRequisitionNo))
				     .add(Restrictions.eq("vendor.VendorFlag","s"));
		      prqItem=cr.list();
			}
			if(flag!="" && flag.equalsIgnoreCase("R")){
		      mmServiceRequests=session.createCriteria(MmServiceRequest.class).createAlias("RequestStatus", "rs")
		    		  .add(Restrictions.eq("Id",quotationRequisitionNo )).add(Restrictions.eq("rs.StatusCode", "WO"))
		    		  .list();
		      if(mmServiceRequests.size()>0){
		    	  inspectionReports=session.createCriteria(MmInspectionReport.class,"ir").createAlias("ir.Request", "r").add(Restrictions.eq("r.Id", mmServiceRequests.get(0).getId())).list();
		      }
			}
		     //System.out.println(prqItem.size()+"oo----------------"+quotationRequisitionNo);
       } catch (Exception e) {
			   e.printStackTrace();
		     }
		map.put("inspectionReports",inspectionReports);
        map.put("mmServiceRequests", mmServiceRequests);
		map.put("prqItem", prqItem);
		return map;

}
	//=============================method for technical Approval===============================================
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showTechnicalApprovalJsp(Box box,
			Map<String, Object> dataMap) {

		Map<String, Object> map=new HashMap<String, Object>(); 
		List<PrqQuotationVendorDetails> prqItem=new ArrayList<PrqQuotationVendorDetails>();
		List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
		List<PrqQuotationHeader> hdr=new ArrayList<PrqQuotationHeader>();
		List<MmMasRequestStatus> stats=new ArrayList<MmMasRequestStatus>();
		Session session=(Session)getSession();

		@SuppressWarnings("unused")
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date fromDate=new Date();
		Date toDate=new Date();
		int hospitalId=0;
		int quotationRequisitionNo=0;
		if(dataMap.get("hospitalId")!=null && dataMap.get("hospitalId")!=""){
			hospitalId=(Integer)dataMap.get("hospitalId");
			
			  Criteria cd=(Criteria) session.createCriteria(PrqQuotationHeader.class)
					  .add(Restrictions.isNotNull("QuotationNo"))
					  .addOrder(Order.desc("QuotationNo"));
					  
			  hdr=cd.list();
	          mmServiceRequests=session.createCriteria(MmServiceRequest.class, "sr")
	        		  .createAlias("sr.RequestStatus", "rs").add(Restrictions.eq("rs.StatusCode", "WO").ignoreCase()).list();
	          System.out.println("mmServiceRequests"+mmServiceRequests.size());
	          map.put("mmServiceRequests", mmServiceRequests);
			 
			 map.put("hdr", hdr);
		}
		return map;
	}

	//========================================End====================================================================
	
	@Override
	public Map<String, Object> responseTechnicalApproval(Box box,
			Map<String, Object> dataMap) {

		Map<String, Object> map=new HashMap<String, Object>(); 
		List<PrqQuotationItemDetails>  itemList=new ArrayList<PrqQuotationItemDetails>();
		List<MmMasRequestStatus> stats=new ArrayList<MmMasRequestStatus>();
		List<MmSafetyProcedureMaterials> mmSafetyProcedureMaterials=new ArrayList<MmSafetyProcedureMaterials>();
		Session session = (Session) getSession();
		session = (Session) getSession();
		int requisitionId = 0;
		String[] statusCode=null;
		String status=null;
		 URL resourcePath = Thread.currentThread().getContextClassLoader()
				  .getResource("adt.properties");
		                     try {
			                 Properties prop = new Properties();
			                 prop.load(new FileInputStream(new File(resourcePath.getFile())));
			                 statusCode = prop.getProperty("technical.approval.status.list").split("#");
			                 status=prop.getProperty("technical.approval.status");
		                              } catch (IOException e) {
			                                e.printStackTrace();
		                                       }
		if(dataMap.get("requisitionId") != null ){
			requisitionId = (Integer)dataMap.get("requisitionId");
		
			}
		 Criteria cc=session.createCriteria(MmMasRequestStatus.class,"stat")
				  .add(Restrictions.in("StatusCode", statusCode));
                stats=cc.list();
		if(dataMap.get("flag")==null)
		{
		try {
			
			
			itemList= session.createCriteria(PrqQuotationItemDetails.class,"si")
					.createAlias("si.VendorDetails", "vend")
					.createAlias("si.ItemStatus", "st")
					.add(Restrictions.eq("st.StatusCode", status))
					.add(Restrictions.eq("vend.Id", requisitionId))
					.list();
                   } catch (Exception e) {
			          e.printStackTrace();
		                  }
		  
	             
		}
		if(dataMap.get("flag")!=null)
		{
			mmSafetyProcedureMaterials=session.createCriteria(MmSafetyProcedureMaterials.class,"sp").createAlias("sp.InspectionReport", "i")
					.add(Restrictions.eq("i.Id",requisitionId)).list();
			
		}
		// System.out.println("itemlist"+mmSafetyProcedureMaterials.size()+"id"+requisitionId);
		         map.put("mmSafetyProcedureMaterials", mmSafetyProcedureMaterials);
                 map.put("stats", stats);
	             map.put("itemList", itemList);
		          return map;

}		

	//======================save technical approval==============================================	
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> saveTechnicalApproval(Box box,
			Map<String, Object> dataMap) {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		Map<String, Object> map=new HashMap<String, Object>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		int userId=(Integer)dataMap.get(RequestConstants.USER_ID);
		Date cd=new Date();
		Date requiredDate=new Date();
		String msg="";
		Session session = (Session) getSession();
		String mmMasRequestStatusTechnical = "";
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			mmMasRequestStatusTechnical = prop.getProperty("mmMasRequestStatusTechnical");
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		MmMasRequestStatus status=(MmMasRequestStatus) session
						.createCriteria(MmMasRequestStatus.class)
						.add(Restrictions
								.eq("StatusCode", mmMasRequestStatusTechnical))
						.uniqueResult();*/
		int itemCount=box.getInt("itemCount");
		Integer qoutationId=0;
		PrqQuotationVendorDetails vendor=null;
		MmInspectionReport mmInspectionReport=null;
		MmServiceRequest mmServiceRequest=null;
		PrqQuotationHeader prqQuotationHeader=null;
		MmMasRequestStatus mmMasRequestStatus=new MmMasRequestStatus();
		List<MmMasRequestStatus> status1=new ArrayList<MmMasRequestStatus>();
		List<PrqQuotationItemDetails> itemList=new ArrayList<PrqQuotationItemDetails>();
		status1=session.createCriteria(MmMasRequestStatus.class).add(Restrictions.eq("StatusCode", box.getString("status"))).list();
			if(box.getInt("checkbox")!=0){
	   	   vendor=(PrqQuotationVendorDetails) session.load(PrqQuotationVendorDetails.class,box.getInt("checkbox"));
	   	qoutationId=vendor.getHeader().getId();
	   	vendor.setVendorFlag("t");
	     hbt.update(vendor);
	     hbt.flush();
     	 hbt.clear();
			}
			if(box.getInt("maintinanceChk")!=0){
				mmInspectionReport=(MmInspectionReport) session.load(MmInspectionReport.class, box.getInt("maintinanceChk"));
				mmServiceRequest=(MmServiceRequest) session.load(MmServiceRequest.class, mmInspectionReport.getRequest().getId());
				mmMasRequestStatus.setId(status1.get(0).getId());
				mmInspectionReport.setRequestStatus(mmMasRequestStatus);
				mmServiceRequest.setRequestStatus(mmMasRequestStatus);
				hbt.update(mmInspectionReport);
				hbt.flush();
		     	hbt.clear();
				hbt.update(mmServiceRequest);
				hbt.flush();
		     	hbt.clear();
			}
		    for(int i=1;i<=itemCount;i++)
	         	{
			        	int id = box.getInt("itemCheckbox"+i);
			        	int maintenance = box.getInt("maintenanceCheckbox"+i);
			        	if(id!=0)
			        	{
			        	PrqQuotationItemDetails items=(PrqQuotationItemDetails) session.load(PrqQuotationItemDetails.class, id);
			        	mmMasRequestStatus.setId(status1.get(0).getId());
			        	System.out.println("technicalapp"+box.getInt("status"));
			        	items.setItemStatus(mmMasRequestStatus);
			        	hbt.update(items);
			        	hbt.flush();
				     	hbt.clear();
			        	}
			        	if(maintenance!=0)
			        	{
			        		MmSafetyProcedureMaterials mmSafetyProcedureMaterials=(MmSafetyProcedureMaterials) session.load(MmSafetyProcedureMaterials.class, maintenance);
			        		mmSafetyProcedureMaterials.setStatus("t");
			        		hbt.update(mmSafetyProcedureMaterials);
			        		hbt.flush();
			    	     	hbt.clear();
			        	}
			        	
			        }
		    System.out.println(box.getString("requestId")+"   "+qoutationId);
		    if(box.getString("requestId") ==null || box.getString("requestId")=="")
		    	
		    {
		    if(qoutationId>0){
		    itemList=getSession().createCriteria(PrqQuotationItemDetails.class,"i")
		    		.createAlias("i.VendorDetails", "v")
		    		.createAlias("i.ItemStatus", "s")
		    		.createAlias("v.Header", "h")
		    		.add(Restrictions.eq("v.VendorFlag", "s").ignoreCase())
		    		.add(Restrictions.eq("h.Id", qoutationId)).list();
		    }
		   // System.out.println("itemList"+itemList.size());
		  if(itemList.size()>=0){
			  prqQuotationHeader=(PrqQuotationHeader)hbt.get(PrqQuotationHeader.class, qoutationId);
			  prqQuotationHeader.setQuotationStatus(mmMasRequestStatus);
			  prqQuotationHeader.setLastChgDate(date);
			  prqQuotationHeader.setLastChgTime(time);
			  hbt.update(prqQuotationHeader);
			  hbt.flush();
		      hbt.clear();
		  }
		    } 
		    hbt.flush();
		    hbt.clear();
		    msg="<span style='color: red'>Successfully Update</span>";
		    map.put("msg", msg);
		    
	          
		    return map;
	}


	//======================================Method for Commercial Approval===========================================
	@SuppressWarnings("unused")
	@Override
	public Map<String, Object> showCommercialApprovalJsp(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map=new HashMap<String, Object>(); 
		List<PrqQuotationHeader> hdrList=new ArrayList<PrqQuotationHeader>();
		List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
		Session session=(Session)getSession();

		@SuppressWarnings("unused")
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date fromDate=new Date();
		Date toDate=new Date();
		int hospitalId=0;
		String status="";
		if(dataMap.get("hospitalId")!=null && dataMap.get("hospitalId")!=""){
			hospitalId=(Integer)dataMap.get("hospitalId");
			
			  Criteria cd=(Criteria) session.createCriteria(PrqQuotationHeader.class)
					  .add(Restrictions.isNotNull("QuotationNo"))
					  .addOrder(Order.desc("QuotationNo"));
					  
			  hdrList=cd.list();
			  mmServiceRequests=session.createCriteria(MmServiceRequest.class, "sr")
	        		  .createAlias("sr.RequestStatus", "rs").add(Restrictions.eq("rs.StatusCode", "TA").ignoreCase()).list();
	          System.out.println("mmServiceRequests"+mmServiceRequests.size());
	          map.put("mmServiceRequests", mmServiceRequests);
			 
			   map.put("hdrList", hdrList);
			
		}
		return map;
		
		
	}
	//=======================================================================================================
	@SuppressWarnings("unchecked")
	@Override
		public Map<String, Object> getItemListForCommercial(
				Map<String, Object> dataMap) {
		   Map<String, Object> map = new HashMap<String, Object>();
			List<PrqQuotationItemDetails> prqItem=new ArrayList<PrqQuotationItemDetails>();
			Session session = (Session) getSession();
			List<MmSafetyProcedureMaterials> mmSafetyProcedureMaterial=new ArrayList<MmSafetyProcedureMaterials>();
			session = (Session) getSession();
			int quotationRequisitionNo = 0;
			
			String status=null;
			String flag="";
			 URL resourcePath = Thread.currentThread().getContextClassLoader()
					  .getResource("adt.properties");
			                     try {
				                 Properties prop = new Properties();
				                 prop.load(new FileInputStream(new File(resourcePath.getFile())));
				                 status=prop.getProperty("mmMasRequestStatusTechnical");
			                              } catch (IOException e) {
				                                e.printStackTrace();
			                                       }
			                   //  System.out.println("ufrurfh===="+status);
			try {
				
				if(dataMap.get("quotationRequisitionNo") != null ){
					quotationRequisitionNo = (Integer)dataMap.get("quotationRequisitionNo");
				}
				if(dataMap.get("flag")!=null)
					flag=(String)dataMap.get("flag");
				if(flag.equalsIgnoreCase("Q")){
					
					/*
					DetachedCriteria innerQuery = DetachedCriteria.forClass(PrqQuotationItemDetails.class,"item1")
				     .createAlias("item1.VendorDetails", "vendor1")
					 .createAlias("vendor1.Header", "hdr1")
					  .createAlias("item1.Item", "item2")
					 .createAlias("item1.ItemStatus", "stat1")
				     .add(Restrictions.eq("hdr1.Id",quotationRequisitionNo))
				      .add(Restrictions.eqProperty("item2.Id","itm.Id"))
				      .add(Restrictions.eq("stat1.StatusCode",status))
				     .add(Restrictions.isNotNull("item1.VendorDetails.LCategory"));
				     innerQuery.setProjection(Projections.projectionList().add(Projections.groupProperty("item1.Item.Id")))
				     ;
					
					DetachedCriteria innerQuery = DetachedCriteria.forClass(PrqQuotationVendorDetails.class, "vnder");
					innerQuery.createAlias("item.VendorDetails", "vendor")
					innerQuery.setProjection(Projections.projectionList().add(Projections.property("vnder.Id")));
					innerQuery.add(Restrictions.eq("vnder.Id", "vendor.id"));
					innerQuery.createCriteria(User.AT_BANDS)
					 .add(Restrictions.in(Band.AT_NAME, new String[] { "Linkin Park", "U2" }));
				     String sqbQuery="select itm1.Id from jkt.hms.masters.business.PrqQuotationItemDetails item1 "
				     		+ " inner join  item1.VendorDetails vendor1"
				     		+ " inner join  vendor1.Header hdr1"
				     		+ " inner join item1.Item itm1"
				     		+ " inner join item1.ItemStatus stat1"
				     		+ " where hdr1.Id=:quotationRequisitionNo"
				     		+ " and item1.LCategory is not null"
				     		+ "  and itm1.Id=itm.Id ";
					
				     String hql="select item from jkt.hms.masters.business.PrqQuotationItemDetails item "
				     		+ " inner join  item.VendorDetails vendor"
				     		+ " inner join vendor.Header hdr"
				     		+ " inner join item.Item itm"
				     		+ " inner join item.ItemStatus stat"
				     		+ " where hdr.Id=:quotationRequisitionNo"
				     		+ " and stat.StatusCode=:stat"
				     		+ "  and itm.Id not in("+sqbQuery+") ";
				     
				     System.out.println("hql is == "+hql);
				     
//				     and itm.Id not in("+sqbQuery+")
				     Query query=session.createQuery(hql);
				     query.setParameter("quotationRequisitionNo", quotationRequisitionNo);
				     query.setParameter("stat", status);
				     
				     prqItem=query.list();
				Criteria cr=session.createCriteria(PrqQuotationItemDetails.class,"item")
					     .createAlias("item.VendorDetails", "vendor")
						 .createAlias("vendor.Header", "hdr")
						   .createAlias("item.Item", "itm")
						 .createAlias("item.ItemStatus", "stat")
					     .add(Restrictions.eq("hdr.Id",quotationRequisitionNo))
					     .add(Subqueries.notExists(innerQuery)
					    		 
					    		 Subqueries.propertyNe("itm.Id", innerQuery)
					    		 
					    		 )
					     .add(Restrictions.eq("stat.StatusCode",status));
			       //  prqItem=cr.list();
			         Iterator<PrqQuotationItemDetails> iterator=prqItem.iterator();
			         List<Integer> ids=new ArrayList<Integer>();
			         while (iterator.hasNext()) {
						PrqQuotationItemDetails prqQuotationItemDetails = (PrqQuotationItemDetails) iterator
								.next();
						if(ids.contains(prqQuotationItemDetails.getItem().getId()))
						{
							iterator.remove();
						}
						else
						{
							ids.add(prqQuotationItemDetails.getItem().getId());
						}
						
					}*/
				
				/*prqItem=session.createCriteria(PrqQuotationItemDetails.class,"item")
					     .createAlias("item.VendorDetails", "vendor")
						 .createAlias("vendor.Header", "hdr")
						   .createAlias("item.Item", "itm")
						 .createAlias("item.ItemStatus", "stat")
					     .add(Restrictions.eq("hdr.Id",quotationRequisitionNo))
					    .add(Restrictions.eq("stat.StatusCode",status)).list();
					    
					    */
					
					 String sqbQuery="select itm1.Id from jkt.hms.masters.business.PrqQuotationItemDetails item1 "
					     		+ " inner join  item1.VendorDetails vendor1"
					     		+ " inner join  vendor1.Header hdr1"
					     		+ " inner join item1.Item itm1"
					     		+ " inner join item1.ItemStatus stat1"
					     		+ " where hdr1.Id=:quotationRequisitionNo"
					     		+ " and item1.LCategory is not null"
					     		+ "  and itm1.Id=itm.Id ";
						
					     String hql="select item from jkt.hms.masters.business.PrqQuotationItemDetails item "
					     		+ " inner join  item.VendorDetails vendor"
					     		+ " inner join vendor.Header hdr"
					     		+ " inner join item.Item itm"
					     		+ " inner join item.ItemStatus stat"
					     		+ " where hdr.Id=:quotationRequisitionNo"
					     		+ " and stat.StatusCode=:stat"
					     		+ "  and itm.Id not in("+sqbQuery+") ";
					     
					     //System.out.println("hql is == "+hql);
					     
//					     and itm.Id not in("+sqbQuery+")
					     Query query=session.createQuery(hql);
					     query.setParameter("quotationRequisitionNo", quotationRequisitionNo);
					     query.setParameter("stat","TA");
					     prqItem=query.list();
				
				}
				if(flag.equalsIgnoreCase("R")){
			      mmSafetyProcedureMaterial=session.createCriteria(MmSafetyProcedureMaterials.class,"sp")
			    		  .createAlias("sp.InspectionReport", "in")
			    		  .createAlias("in.Hospital", "h")
			    		  .createAlias("in.Request", "r")
			    		  .add(Restrictions.eq("r.Id", quotationRequisitionNo))
							.add(Restrictions.eq("h.Id", (Integer)dataMap.get("hospitalId")))
							.add(Restrictions.eq("sp.Status","t").ignoreCase()).list();
				}
					
	      } catch (Exception e) {
				   e.printStackTrace();
			     }
			//System.err.println("-----"+mmSafetyProcedureMaterial.size());
			map.put("mmSafetyProcedureMaterial", mmSafetyProcedureMaterial);
			map.put("prqItem", prqItem);
			return map;
		}
//=====================================================================================================================
	  @SuppressWarnings({ "unchecked", "unused" })
		@Override
    public Map<String, Object> vendorListCommercialJsp(Box box,
	Map<String, Object> dataMap) {
       Map<String, Object> map=new HashMap<String, Object>(); 
     		List<PrqQuotationItemDetails> prqQuotationVendorDetails=new ArrayList<PrqQuotationItemDetails>();
     		List<MmSafetyProcedureMaterials> mmSafetyProcedureMaterial=new ArrayList<MmSafetyProcedureMaterials>();
     		List<MmMasRequestStatus> stats=new ArrayList<MmMasRequestStatus>();
     		Session session = (Session) getSession();
     		session = (Session) getSession();
     		int requisitionId = 0;
     		String[] statusCode=null;
     		String flag="";
     		if(dataMap.get("flag")!=null){
     			flag=(String)dataMap.get("flag");
     		}
  		 URL resourcePath = Thread.currentThread().getContextClassLoader()
  				  .getResource("adt.properties");
  		                     try {
  			                 Properties prop = new Properties();
  			                 prop.load(new FileInputStream(new File(resourcePath.getFile())));
  			                 statusCode = prop.getProperty("commercial.approval.status.list").split("#");
  		                              } catch (IOException e) {
  			                                e.printStackTrace();
  		                                       }
     		try {
     			
     			if(dataMap.get("requisitionId") != null ){
     				requisitionId = (Integer)dataMap.get("requisitionId");
     				
     			}
     			PrqQuotationItemDetails itemDetails=(PrqQuotationItemDetails) session.get(PrqQuotationItemDetails.class, requisitionId);
     			if(flag.equalsIgnoreCase("Q")){
     				
     			   prqQuotationVendorDetails=session.createCriteria(PrqQuotationItemDetails.class,"item")
			   					 .createAlias("item.Item", "i")
			   					  .createAlias("item.ItemStatus", "istatus")
			                     .createAlias("item.VendorDetails", "vender")
			                     .createAlias("vender.Header", "hdr")
			                     .add(Restrictions.eq("i.Id", itemDetails.getItem().getId()))
			                     .add(Restrictions.eq("hdr.Id", itemDetails.getVendorDetails().getHeader().getId()))
			                     .add(Restrictions.eq("istatus.StatusCode", "ta").ignoreCase())
			                     .addOrder(Order.asc("TotalAmount")).list();
     			}
     			System.out.println("vendorlist"+prqQuotationVendorDetails.size());
     			if(flag.equalsIgnoreCase("R")){         
     		        mmSafetyProcedureMaterial=session.createCriteria(MmSafetyProcedureMaterials.class,"ms")
     		        		                     .add(Restrictions.eq("ms.Id", requisitionId)).list();
     	             
     			}  
     		 Criteria cc=session.createCriteria(MmMasRequestStatus.class,"stat")
     				  .add(Restrictions.in("StatusCode", statusCode));
                      stats=cc.list();
     	 } catch (Exception e) {
		          e.printStackTrace();
	                  }
                      map.put("stats", stats);
     	             	map.put("prqQuotationVendorDetails", prqQuotationVendorDetails);
     	             	map.put("mmSafetyProcedureMaterial", mmSafetyProcedureMaterial);
     		          return map;

    
       }

	//===========================End===================================================================================
    
	//=================================================save commercial approval=======================================
	  @SuppressWarnings({ "unchecked", "unchecked", "unused", "unchecked", "unchecked" })
		@Override
   	public Map<String, Object> saveCommercialApproval(Box box,
   			Map<String, Object> dataMap) {
      	 org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
   		hbt.setFlushModeName("FLUSH_AUTO");
   		hbt.setCheckWriteOperations(false);
   		Integer headerId=0;
   		List<PrqQuotationItemDetails> itemList=new ArrayList<PrqQuotationItemDetails>();
   		PrqQuotationHeader prqQuotationHeader=null;
   		Map<String, Object> map=new HashMap<String, Object>();
   		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
   		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

   		int userId=(Integer)dataMap.get(RequestConstants.USER_ID);
   		int hospitalid=(Integer)dataMap.get(RequestConstants.HOSPITAL_ID);
   		Date cd=new Date();
   		Date requiredDate=new Date();
   		String msg="";
   		String statusCode="";
   		          Session session = (Session) getSession();
   		       URL resourcePath = Thread.currentThread().getContextClassLoader()
   	  				  .getResource("adt.properties");
   	  		                     try {
   	  			                 Properties prop = new Properties();
   	  			                 prop.load(new FileInputStream(new File(resourcePath.getFile())));
   	  			                 statusCode = prop.getProperty("commercialReject");
   	  		                              } catch (IOException e) {
   	  			                                e.printStackTrace();
   	  		                                       }
   		   MmMasRequestStatus mmRequest =(MmMasRequestStatus)session.createCriteria(MmMasRequestStatus.class).add(Restrictions.eq("StatusCode", statusCode)).uniqueResult();
   		   int vendorCount=box.getInt("vendorCount");
   		    PrqQuotationItemDetails item=null;
   		    MmInspectionReport mmInspectionReport=null;
   		    MmServiceRequest mmServiceRequest=null;
   		    
   		    List<MmMasRequestStatus> status1=new ArrayList<MmMasRequestStatus>();
   		       status1=session.createCriteria(MmMasRequestStatus.class).add(Restrictions.eq("StatusCode", box.getString("status"))).list();
   		     	/*if(box.getInt("status")!=0){
   		     		mmMasRequestStatus=(MmMasRequestStatus)hbt.get(MmMasRequestStatus.class, box.getInt("status"));
   		     		// mmMasRequestStatus.setId(box.getInt("status"));
   		     	}*/
   		     	//item=(PrqQuotationItemDetails) session.load(PrqQuotationItemDetails.class,box.getInt("checkbox"));
   		     	//qoutationId=item.getVendorDetails().getHeader().getId();
   		         /* if(box.getInt("checkbox")!=0){
   		        	  List<PrqQuotationItemDetails>  item1=new ArrayList<PrqQuotationItemDetails>();
   		        	  item1=session.createCriteria(PrqQuotationItemDetails.class,"item")
   		        			      .createAlias("item.Item", "i")
   		        			      .add(Restrictions.eq("i.Id", box.getInt("checkbox"))).list();
   	   	              System.out.println("list"+item1.size());
   		        	
   	   	              item.setItemStatus(mmMasRequestStatus);
   	                 hbt.update(item);
   	                hbt.flush();
  	     	     	hbt.clear();
   			}*/
   			Integer inspectionId=0;
   			int maintenance =0;
   		    for(int i=1;i<=vendorCount;i++) 
   		    {
   		    	int id = box.getInt("itemId"+i);
   			        	 maintenance = box.getInt("maintinenceCheckbox"+i);
   			        	if(id!=0)
   			        	{/*
   			        	PrqQuotationVendorDetails vendor=(PrqQuotationVendorDetails) session.load(PrqQuotationVendorDetails.class, id);	     			        	
   			        	//vendor.setVendorFlag("c");
   			        	
   			        	vendor.setVendorRemarks(box.getString("remarks")+i);
   			        	hbt.update(vendor);
   			        	if(item!=null){
   			        		
   			        		int quotationNo=Integer.parseInt(box.getString("quotationRequisitionNo").substring(0,box.getString("quotationRequisitionNo").indexOf("@")));
   			        		PrqQuotationItemDetails itemDetails=(PrqQuotationItemDetails) session.createCriteria(PrqQuotationItemDetails.class,"item")
	     		        			      .createAlias("item.Item", "i")
	     		        			      .createAlias("item.VendorDetails", "v")
	     		        			      .createAlias("v.Header", "hdr")
	     		        			      .add(Restrictions.eq("i.Id", item.getItem().getId()))
	     		        			       .add(Restrictions.eq("v.Id", id))
	     		        			        .add(Restrictions.eq("hdr.Id", quotationNo))
	     		        			       .uniqueResult();
   			        	//System.out.println(quotationNo+"-------"+item.getItem().getId()+"---Prq-----"+mmMasRequestStatus.getId());	
   			        		mmMasRequestStatus.setId(status1.get(0).getId());
   			        		itemDetails.setItemStatus(mmMasRequestStatus);
   			        		itemDetails.setLCategory(Integer.parseInt(box.getString("lcat"+i).substring(1).trim()));
 	     	                 hbt.update(itemDetails);
 	     	               hbt.flush();
 	    	     	     	hbt.clear();
   			        	}
   			        	*/
   			        		item=(PrqQuotationItemDetails) session.load(PrqQuotationItemDetails.class,id);
   			        		if(box.getString("itemCheckbox"+i)!=null && !"".equals(box.getString("itemCheckbox"+i)))
   			        		{
   			        			MmMasRequestStatus mmMasRequestStatus=new MmMasRequestStatus();
   			        			mmMasRequestStatus.setId(status1.get(0).getId());
   			        			item.setItemStatus(mmMasRequestStatus);
   			        			item.setLCategory(Integer.parseInt(box.getString("lcat"+i).substring(1).trim()));
   	 	     	               
   			        		}
   			        		else
   			        		{    
   			        			item.setItemStatus(mmRequest);
   			        			item.setLCategory(Integer.parseInt(box.getString("lcat"+i).substring(1).trim()));
   			        		}
   			        	  hbt.update(item);
   			        	}
   			        	if(maintenance!=0)
   			        	{
   			        		MmSafetyProcedureMaterials mmSafetyProcedureMaterials=(MmSafetyProcedureMaterials) session.load(MmSafetyProcedureMaterials.class, maintenance);
   			        		inspectionId=mmSafetyProcedureMaterials.getInspectionReport().getId();
   			        		mmSafetyProcedureMaterials.setStatus("c");
   			        		mmSafetyProcedureMaterials.setItemRemarks(box.getString("remarks")+i);
   			        		hbt.update(mmSafetyProcedureMaterials);
   			        	}
   			        	
   			        }
   		   if(inspectionId!=0){
   				mmInspectionReport=(MmInspectionReport) session.load(MmInspectionReport.class, inspectionId);
   				mmServiceRequest=(MmServiceRequest) session.load(MmServiceRequest.class, mmInspectionReport.getRequest().getId());
   			   MmMasRequestStatus mmMasRequestStatus=new MmMasRequestStatus();
   				mmMasRequestStatus.setId(status1.get(0).getId());
   				mmInspectionReport.setRequestStatus(mmMasRequestStatus);
   				mmServiceRequest.setRequestStatus(mmMasRequestStatus);
   				hbt.update(mmInspectionReport);
   				hbt.flush();
	     	     	hbt.clear();
   				hbt.update(mmServiceRequest);
   				hbt.flush();
	     	     	hbt.clear();
   			}
   		hbt.flush();
	     	hbt.clear();
   		   if(maintenance==0){
   		  if(box.getInt("headerId")>0){
   			  
   			 String sqbQuery="select itm1.Id from jkt.hms.masters.business.PrqQuotationItemDetails item1 "
			     		+ " inner join  item1.VendorDetails vendor1"
			     		+ " inner join  vendor1.Header hdr1"
			     		+ " inner join item1.Item itm1"
			     		+ " inner join item1.ItemStatus stat1"
			     		+ " where hdr1.Id=:quotationRequisitionNo"
			     		+ " and item1.LCategory is not null"
			     		+ "  and itm1.Id=itm.Id ";
				
			     String hql="select item from jkt.hms.masters.business.PrqQuotationItemDetails item "
			     		+ " inner join  item.VendorDetails vendor"
			     		+ " inner join vendor.Header hdr"
			     		+ " inner join item.Item itm"
			     		+ " inner join item.ItemStatus stat"
			     		+ " where hdr.Id=:quotationRequisitionNo"
			     		+ " and stat.StatusCode=:stat"
			     		+ "  and itm.Id not in("+sqbQuery+") ";
			     
			     //System.out.println("hql is == "+hql);
			     
//			     and itm.Id not in("+sqbQuery+")
			     Query query=session.createQuery(hql);
			     query.setParameter("quotationRequisitionNo", box.getInt("headerId"));
			     query.setParameter("stat","TA");
			    itemList=query.list();
			     
   			    /*itemList=getSession().createCriteria(PrqQuotationItemDetails.class,"i")
   			    		.createAlias("i.VendorDetails", "v")
   			    		.createAlias("i.ItemStatus", "s")
   			    		.createAlias("v.Header", "h")
   			    		.add(Restrictions.eq("s.StatusCode", "TA"))
   			    		.add(Restrictions.eq("h.Id", box.getInt("headerId"))).list();*/
   			    }
   			  if(itemList.size()==0){
   				  prqQuotationHeader=(PrqQuotationHeader)hbt.get(PrqQuotationHeader.class, box.getInt("headerId"));
   				  MasHospital hospital=new MasHospital();
   				  hospital.setId(hospitalid);
   				  prqQuotationHeader.setHospital(hospital);
   				  prqQuotationHeader.setLastChgDate(date);
   				  prqQuotationHeader.setLastChgTime(time);
   				 MmMasRequestStatus mmMasRequestStatus=new MmMasRequestStatus();
   				  mmMasRequestStatus.setId(status1.get(0).getId());
   				  prqQuotationHeader.setQuotationStatus(mmMasRequestStatus);
   				  hbt.update(prqQuotationHeader);
   				  hbt.flush();
   			      hbt.clear();
   			  }
   		   }    
   		  
   		    hbt.flush();
   	     	hbt.clear();
   		    msg="<span style='color: green'>Successfully Update</span>";
   		    map.put("msg", msg);
   		    
   		return map;
   	}
       
   //==================================End======================================================================
  //==============================method for negotiation========================================================
		@Override
    	public Map<String, Object> showNegotiationJsp(Box box,
    			Map<String, Object> dataMap) {
     		Map<String, Object> map=new HashMap<String, Object>(); 
    		List<PrqQuotationHeader> hdrList=new ArrayList<PrqQuotationHeader>();
    		Session session=(Session)getSession();

    		@SuppressWarnings("unused")
    		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    		Date fromDate=new Date();
    		Date toDate=new Date();
    		int hospitalId=0;
    		String status="";

			 URL resourcePath = Thread.currentThread().getContextClassLoader()
					  .getResource("adt.properties");
			                     try {
				                 Properties prop = new Properties();
				                 prop.load(new FileInputStream(new File(resourcePath.getFile())));
				                 status=prop.getProperty("technical.approval.status");
			                              } catch (IOException e) {
				                                e.printStackTrace();
			                                       }
    		if(dataMap.get("hospitalId")!=null && dataMap.get("hospitalId")!=""){
    			hospitalId=(Integer)dataMap.get("hospitalId");
    			
    			  Criteria cd=(Criteria) session.createCriteria(PrqQuotationHeader.class,"hdr")
    					  .createAlias("hdr.QuotationStatus", "stat")
    					  .createAlias("hdr.Hospital", "hos")
    					  .add(Restrictions.eq("hos.Id", hospitalId))
    					  .add(Restrictions.eq("stat.StatusCode", "CA"))
    					  .add(Restrictions.isNotNull("QuotationNo"))
    					  .addOrder(Order.desc("QuotationNo"));
    					   hdrList=cd.list();
    			      map.put("hdrList", hdrList);
    			}
    		return map;
    	}
      //--------==========================================End================================================================
	  
			//============================================method for vendor list in negotiation===================================
		@SuppressWarnings("unchecked")
     	@Override
    	public Map<String, Object> vendorListNegotiation(Box box,Map<String, Object> dataMap) {
    		
    		Map<String, Object> map=new HashMap<String, Object>(); 
       		List<PrqQuotationItemDetails> itemDetails=new ArrayList<PrqQuotationItemDetails>();
       		Session session = (Session) getSession();
       		session = (Session) getSession();
       		int requisitionId = 0;
       		
       		try {
       			if(dataMap.get("requisitionId") != null ){
       				requisitionId = (Integer)dataMap.get("requisitionId");
       				
       			}
       			
       			System.out.println("--------"+dataMap.get("requisitionId"));
       		/*	//PrqQuotationHeader prqQuotationHeader=(PrqQuotationHeader) session.get(PrqQuotationHeader.class, quotationRequisitionNo);
       		       PrqQuotationItemDetails itemQuotationItemDetails=(PrqQuotationItemDetails) session.get
       				
       			     itemDetails=session.createCriteria(PrqQuotationItemDetails.class,"item")
			                     .createAlias("item.VendorDetails", "vender")	
			                      .createAlias("vender.Header", "hdr")	
			                     .add(Restrictions.eq("item.Id", itemDetails.getItem().getId()))
			                     .add(Restrictions.eq("istatus.StatusCode", "ta").ignoreCase())
			                     .addOrder(Order.asc("TotalAmount")).list();
       			}
       			*/
       		/*	//PrqQuotationItemDetails itemDetails=(PrqQuotationItemDetails) session.get(PrqQuotationItemDetails.class, requisitionId);
       			 prqQuotationVendorDetails=session.createCriteria(PrqQuotationVendorDetails.class,"vendor")
       					 .createAlias("vendor.Header", "hdr")
       					 .add(Restrictions.eq("hdr.Id", quotationRequisitionNo))
       					 .add(Restrictions.eq("vendor.VendorFlag", "c"))
       					 .addOrder(Order.asc("LCategory")).list();
       			// System.out.println("vendorlist===="+prqQuotationVendorDetails.size());
       			
*/	       		 PrqQuotationItemDetails prqQuotationItemDetails=(PrqQuotationItemDetails) session.get(PrqQuotationItemDetails.class, requisitionId);
       		  itemDetails=session.createCriteria(PrqQuotationItemDetails.class,"item")
       				       .createAlias("item.Item", "i")
   					       .createAlias("item.ItemStatus", "istatus")
       				      .createAlias("item.VendorDetails", "v")
       				      .createAlias("v.Header", "hdr")
       				      .addOrder(Order.asc("item.LCategory"))
       				      .add(Restrictions.eq("istatus.StatusCode", "ca").ignoreCase())
       				       .add(Restrictions.eq("hdr.Id", prqQuotationItemDetails.getVendorDetails().getHeader().getId()))
       				      .add(Restrictions.eq("i.Id", prqQuotationItemDetails.getItem().getId())).list();
       				    
       				      
       		 } catch (Exception e) {
		          e.printStackTrace();
	                  }
       	             map.put("itemDetails", itemDetails);
       		          return map;

      
         }

	    		
	    
      //========================================end=================================================================
	  //======================method for item list in negotiation-==================================================
		@Override
    	public Map<String, Object> getItemListForNegotiation(Box box,
    			Map<String, Object> dataMap) {
    		 Map<String, Object> map = new HashMap<String, Object>();
    			List<PrqQuotationItemDetails> prqItem=new ArrayList<PrqQuotationItemDetails>();
    			Session session = (Session) getSession();
    			session = (Session) getSession();
    			int requitionId = 0;
    			
    			String status="";
    			 URL resourcePath = Thread.currentThread().getContextClassLoader()
    					  .getResource("adt.properties");
    			                     try {
    				                 Properties prop = new Properties();
    				                 prop.load(new FileInputStream(new File(resourcePath.getFile())));
    				                 status=prop.getProperty("commercialApproval");
    			                              } catch (IOException e) {
    				                                e.printStackTrace();
    			                                       }
    			        try {
    				
    				if(dataMap.get("requitionId") != null ){
    					requitionId = (Integer)dataMap.get("requitionId");
    				}
    				// System.out.println(requitionId+"===="+status);
    				Criteria cr=session.createCriteria(PrqQuotationItemDetails.class,"item")
    						  .createAlias("item.ItemStatus", "itm")
    					     .createAlias("item.VendorDetails", "vendor")
    					     .createAlias("vendor.Header", "hdr")
    					     .add(Restrictions.eq("hdr.Id",requitionId))
    					     .add(Restrictions.eq("itm.StatusCode",status));
    			      prqItem=cr.list();
    				}
    			
    					
    	       catch (Exception e) {
    				   e.printStackTrace();
    			     }
      // System.out.println("itemlist----"+prqItem.size());
    			map.put("prqItem", prqItem);
    			return map;
    	}
	    //==========================================end==========================================================
	         
	      //----------------------------------save negotiation------------------------------------
		@SuppressWarnings("unchecked")
		@Override
    	public Map<String, Object> saveNegotiation(Box box,
    			Map<String, Object> dataMap) {
    		    org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
    			hbt.setFlushModeName("FLUSH_AUTO");
    			hbt.setCheckWriteOperations(false);
    			Map<String, Object> map=new HashMap<String, Object>();
    			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    			int userId=(Integer)dataMap.get(RequestConstants.USER_ID);
    			Map<String, Object> utilMap = new HashMap<String, Object>();
    			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
    			String currentDate = (String) utilMap.get("currentDate");
    			String time = (String) utilMap.get("currentTime");
    			Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

    			Date cd=new Date();
    			Date requiredDate=new Date();
    			String msg="";
    			Session session = (Session) getSession();
    			String negotiationStatus = "";
    			int hospitalid=(Integer)dataMap.get(RequestConstants.HOSPITAL_ID);
    			URL resourcePath = Thread.currentThread().getContextClassLoader()
    					.getResource("adt.properties");
    			try {
    				       Properties prop = new Properties();
    				       prop.load(new FileInputStream(new File(resourcePath.getFile())));
    				       negotiationStatus = prop.getProperty("negotiationStatus");

	                          
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    			MmMasRequestStatus status=(MmMasRequestStatus) session
			            .createCriteria(MmMasRequestStatus.class)
			               .add(Restrictions
					           .eq("StatusCode", negotiationStatus))
			                      .uniqueResult();
    			int vendorCount=box.getInt("vendorCount");
    			PrqQuotationItemDetails itemDetails=null;
    			/*PrqQuotationHeader hdr =null;
    			hdr=(PrqQuotationHeader) session.load(PrqQuotationHeader.class,box.getInt("headerId"));
    			hdr.setNegotiationDate(HMSUtil.getCurrentDateAndTimeObject());
    			
    			hdr.setQuotationStatus(status);
    			 hbt.update(hdr);
    			 */
    			MmMasRequestStatus mmMasRequestStatus=new MmMasRequestStatus();
    			if(box.getInt("checkbox")!=0){
    				itemDetails=(PrqQuotationItemDetails) session.load(PrqQuotationItemDetails.class,box.getInt("checkbox"));
    				//itemDetails.setItemStatus(status);
    				List<PrqQuotationItemDetails> itemDetails2=new ArrayList<PrqQuotationItemDetails>();
    				itemDetails2=session.createCriteria(PrqQuotationItemDetails.class,"it")
    						.createAlias("it.Item", "item")
    						.createAlias("it.VendorDetails", "vender")
    						.createAlias("vender.Header", "header")
    						.add(Restrictions.eq("item.Id", itemDetails.getItem().getId()))
    						.add(Restrictions.eq("header.Id", itemDetails.getVendorDetails().getHeader().getId()))
    						.list();
    				int vender=box.getInt("approveCheckbox");
    				Iterator<PrqQuotationItemDetails> iterator=itemDetails2.iterator();
    				while (iterator.hasNext()) {
						PrqQuotationItemDetails prqQuotationItemDetails = (PrqQuotationItemDetails) iterator
								.next();
						if(vender==prqQuotationItemDetails.getVendorDetails().getId())
    					{
							prqQuotationItemDetails.setLCategory(Integer.parseInt(box.getString("lcat").substring(1)));
							prqQuotationItemDetails.setVendorFlag("n");
							prqQuotationItemDetails.setNewAmount(new BigDecimal(box.getString("newAmt"+prqQuotationItemDetails.getVendorDetails().getId())));
							prqQuotationItemDetails.setItemStatus(status);
    					}
    					else{
    						prqQuotationItemDetails.setVendorFlag("r");
    						prqQuotationItemDetails.setItemStatus(status);
    						prqQuotationItemDetails.setRemarks(box.getString("reject"+prqQuotationItemDetails.getVendorDetails().getId()));
    					}
						hbt.update(prqQuotationItemDetails);
						
					}
    				
    		   	  /*vendor.setVendorFlag("n");*/
    		   	  /*vendor.setConsolidatedDiscountAmount(new BigDecimal(box.getFloat("consiDiscountAmt")));
    		   	  vendor.setConsolidatedDiscountPercent(new BigDecimal(box.getFloat("consiDiscount")));
    		   	  vendor.setTotalConsolidatedAmount(new BigDecimal(box.getFloat("consiDiscountAmt")));
    		   	  vendor.setTotalConsolidatedAmount(new BigDecimal(box.getFloat("consiTotalAmt")));*/
    		      // hbt.update(itemDetails);
    			}
    		/*	
    		 Vector<String> vector=box.getVector("rejectCheckbox");
    		 for (String string : vector) {
    			 
    			 if(string!=null && !string.equals(""))
    			 {
    				 	vendor=(PrqQuotationVendorDetails) session.load(PrqQuotationVendorDetails.class,Integer.parseInt(string));
	    		   	  vendor.setVendorFlag("r");
	    		   	  vendor.setRejectReason(box.getString("reject"));
	    		       hbt.update(vendor);
    			 }
				
			}*/
    			
    			    /*for(int i=1;i<=vendorCount;i++)
    		         	{
    				        	if(vendorCount!=0)
    				        	{
    				        	PrqQuotationItemDetails prqItemDetails=(PrqQuotationItemDetails) session.load(PrqQuotationItemDetails.class,box.getInt("itemId"+i));
    				        	prqItemDetails.setNewAmount(new BigDecimal(box.getFloat("newNetAmt"+i)));
    				        	prqItemDetails.setNewDiscountOnRate(new BigDecimal(box.getFloat("newDis"+i)));
    				        	prqItemDetails.setNewItemRate(new BigDecimal(box.getFloat("newRate"+i)));
    				        	prqItemDetails.setNewNetAmount(new BigDecimal(box.getFloat("newAmount"+i)));
    				        	prqItemDetails.setNewQty(new BigDecimal(box.getFloat("newQty"+i)));
    				        	prqItemDetails.setNewExciseDutyType(box.getString("exciseOption"+i));
    				        	prqItemDetails.setExciseDutyAmount(new BigDecimal(box.getFloat("exciseDuty"+i)));
    				        	prqItemDetails.setNewVat(new BigDecimal(box.getFloat("newVat"+i)));
    				        	prqItemDetails.setNewTax(new BigDecimal(box.getFloat("newTax"+i)));
    				        	prqItemDetails.setNewTotalAmount(new BigDecimal(box.getFloat("newTotalAmt"+i)));
    				        	prqItemDetails.setAmount(new BigDecimal(box.get("newAmt")));
    				        	prqItemDetails.setItemStatus(status);
    				        	hbt.update(prqItemDetails);
    				        	}
    				        	    			    
    		}*/
    			 hbt.flush();
		     	  hbt.clear();
    			List<PrqQuotationItemDetails> details=session.createCriteria(PrqQuotationItemDetails.class,"item")
    					.createAlias("item.VendorDetails", "vendor")
    					.createAlias("vendor.Header", "hdr")
    					.createAlias("item.ItemStatus", "stat")
    					.add(Restrictions.eq("hdr.Id",  box.getInt("headerId")))
    					.add(Restrictions.ne("stat.StatusCode", "NEG")).list();
    					                           
    			System.out.println("==="+details.size());
    			
    		if(details.size()==0)
    			{
    				PrqQuotationHeader prqQuotationHeader=(PrqQuotationHeader)hbt.get(PrqQuotationHeader.class, box.getInt("headerId"));
      				  MasHospital hospital=new MasHospital();
      				  hospital.setId(hospitalid);
      				  prqQuotationHeader.setHospital(hospital);
      				  mmMasRequestStatus.setId(status.getId());
      				  prqQuotationHeader.setQuotationStatus(mmMasRequestStatus);
      				  prqQuotationHeader.setLastChgDate(date);
      				  prqQuotationHeader.setLastChgTime(time);
      				  prqQuotationHeader.setNegotiationDate(date);
      				  hbt.update(prqQuotationHeader);
      				  hbt.flush();
      			      hbt.clear();
    			}
    		     hbt.flush();
		     	  hbt.clear();
			      msg="<span style='color: red'>Successfully Save</span>";
			      map.put("msg", msg);
    			    return map;
    		}
	    //==========================================================================================
	    	
	  @SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showPendingListForCreatingPOWOJsp(Box box,
			Map<String, Object> dataMap) {
		  Map<String, Object> map=new HashMap<String, Object>(); 
			List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
			List<PrqQuotationHeader> hdPrqQuotationHeaders=new ArrayList<PrqQuotationHeader>();
			List<MmMasRequestStatus> stats=new ArrayList<MmMasRequestStatus>();
			List<PrqQuotationVendorDetails> vendorDetails=new ArrayList<PrqQuotationVendorDetails>();
			List<PrqQuotationItemDetails> itemDetails=new ArrayList<PrqQuotationItemDetails>();
			List<MmInspectionReport> inspectionReports=new ArrayList<MmInspectionReport>();
			Session session=(Session)getSession();

			@SuppressWarnings("unused")
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			Date fromDate=new Date();
			Date toDate=new Date();
			int hospitalId=0;
			int quotationNo=0;
			String flag="";
			String negotiationStatus = "";
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				       Properties prop = new Properties();
				       prop.load(new FileInputStream(new File(resourcePath.getFile())));
				       negotiationStatus = prop.getProperty("negotiationStatus");

                          
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(dataMap.get("hospitalId")!=null && dataMap.get("hospitalId")!=""){
				hospitalId=(Integer)dataMap.get("hospitalId");
				
			
				
				
						  // .add(Restrictions.eq("QuotationNo",""))
//						  .addOrder(Order.desc("QuotationNo"))
						  
						  
				 /* Criteria cd=(Criteria) session.createCriteria(PrqQuotationItemDetails.class,"it")
						  .createAlias("it.VendorDetails", "vender")
						  .createAlias("vender.VendorDetails", "vender")
						   .createAlias("vender.Header", "header")
						   .createAlias("it.ItemStatus", "itemStatus")
						  .add(Restrictions.eq("itemStatus.StatusCode", "NEG").ignoreCase())
						  .add(Restrictions.isNotNull("QuotationNo"))
						  .add(Restrictions.isNotNull("LCategory"))
						  .setProjection(Projections.projectionList().add(Projections.groupProperty("it.VendorDetails.Vendor")))
						  // .add(Restrictions.eq("QuotationNo",""))
//						  .addOrder(Order.desc("QuotationNo"))
						  ;*/
				
 			  Criteria cd=(Criteria) session.createCriteria(PrqQuotationHeader.class,"hdr")
						  .createAlias("hdr.QuotationStatus", "stat")
					  .add(Restrictions.eq("stat.StatusCode", "NEG").ignoreCase())
					  .add(Restrictions.isNotNull("QuotationNo"))
					  .addOrder(Order.desc("QuotationDate"));
				  if(dataMap.get("fromDate")!=null && dataMap.get("toDate")!=null){
					  cd=cd.add(Restrictions.between("hdr.QuotationDate", HMSUtil.convertStringTypeDateToDateType((String)dataMap.get("fromDate")), HMSUtil.convertStringTypeDateToDateType((String)dataMap.get("toDate"))));
				  }
						  
				  hdPrqQuotationHeaders=cd.list();
				  
				  Criteria sr=session.createCriteria(MmServiceRequest.class, "sr")
		        		  .createAlias("sr.RequestStatus", "rs")
		        		  .add(Restrictions.eq("rs.StatusCode", "CA").ignoreCase());
				  if(dataMap.get("fromDate")!=null && dataMap.get("toDate")!=null){
					  sr=sr.add(Restrictions.between("sr.RequestDate", HMSUtil.convertStringTypeDateToDateType((String)dataMap.get("fromDate")), HMSUtil.convertStringTypeDateToDateType((String)dataMap.get("toDate"))));
				  }
				  mmServiceRequests=sr.list();
				  if(box.getString("fromDate")!=null && !box.getString("fromDate").equals("") && box.getString("toDate")!=null && !box.getString("toDate").equals("")){
						try{
						fromDate=sdf.parse(box.getString("fromDate"));
						toDate=sdf.parse(box.getString("toDate"));
						}catch(Exception e)
						{
							e.printStackTrace();
						}
						cd=cd.add(Restrictions.between("hdr.NegotiationDate", fromDate, toDate));
					}
				  
                      if(dataMap.get("quotationNo") != null ){
  					 quotationNo = Integer.parseInt((String)dataMap.get("quotationNo").toString().split("@")[0].trim());
  					 flag=(String)dataMap.get("quotationNo").toString().split("@")[1].trim();
  				  }
                if(flag=="" || flag.equalsIgnoreCase("Q")){
                	vendorDetails=session.createCriteria(PrqQuotationItemDetails.class,"it")
    						  .createAlias("it.VendorDetails", "vender")
    						   .createAlias("vender.Header", "header")
    						   .createAlias("it.ItemStatus", "itemStatus")
    						  .add(Restrictions.eq("itemStatus.StatusCode", "NEG").ignoreCase())
    						  .add(Restrictions.eq("it.VendorFlag", "n").ignoreCase())
    						  .setProjection(Projections.projectionList().add(Projections.groupProperty("it.VendorDetails"))).list();
                	//System.out.println("vendor"+vendorDetails.size());
                }
                if(flag=="" || flag.equalsIgnoreCase("R")){
                 Criteria inspection=session.createCriteria(MmInspectionReport.class,"ir").createAlias("ir.Request", "r")
            			 .createAlias("r.RequestStatus", "rs")
		        		  .add(Restrictions.eq("rs.StatusCode", "CA").ignoreCase());
                 if(flag.equalsIgnoreCase("R")){
                	 inspection=inspection
                			 .add(Restrictions.eq("r.Id", Integer.parseInt(box.getString("quotationNo").split("@")[0])));
                 }
                 inspectionReports=inspection.list();
                }
  		           map.put("vendorDetails", vendorDetails);
		          map.put("mmServiceRequests", mmServiceRequests);
				 map.put("inspectionReports", inspectionReports);
				 map.put("hdPrqQuotationHeaders", hdPrqQuotationHeaders);
			}
			return map;
		}
	      	
//	-----------------------------------Pending Technical Approval----------------------------    	
	    	  @SuppressWarnings("unchecked")
	    		@Override
	    		public Map<String, Object> showPendingTechnicalApprovalJsp(Box box,
	    				Map<String, Object> dataMap) {
	    			  Map<String, Object> map=new HashMap<String, Object>(); 
	    				List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
	    				List<PrqQuotationHeader> hdPrqQuotationHeaders=new ArrayList<PrqQuotationHeader>();
	    				List<MmMasRequestStatus> stats=new ArrayList<MmMasRequestStatus>();
	    				List<PrqQuotationVendorDetails> vendorDetails=new ArrayList<PrqQuotationVendorDetails>();
	    				List<MmInspectionReport> inspectionReports=new ArrayList<MmInspectionReport>();
	    				Session session=(Session)getSession();

	    				@SuppressWarnings("unused")
	    				SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	    				Date fromDate=new Date();
	    				Date toDate=new Date();
	    				int hospitalId=0;
	    				int quotationNo=0;
	    				String flag="";
	    				String negotiationStatus = "";
	    				URL resourcePath = Thread.currentThread().getContextClassLoader()
	    						.getResource("adt.properties");
	    				try {
	    					       Properties prop = new Properties();
	    					       System.out.println("path >>>> >>> "+resourcePath.getFile()  );
	    					       prop.load(new FileInputStream(new File(resourcePath.getFile())));
	    					       negotiationStatus = prop.getProperty("negotiationStatus");

	    	                          
	    				} catch (IOException e) {
	    					e.printStackTrace();
	    				}
	    				if(dataMap.get("hospitalId")!=null && dataMap.get("hospitalId")!=""){
	    					hospitalId=(Integer)dataMap.get("hospitalId");
	    				
	    	                      if(dataMap.get("quotationNo") != null ){
	    	  					 quotationNo = Integer.parseInt((String)dataMap.get("quotationNo").toString().split("@")[0].trim());
	    	  					 flag=(String)dataMap.get("quotationNo").toString().split("@")[1].trim();
	    	  				  }
	    	                if(flag=="" || flag.equalsIgnoreCase("Q")){
	    	                  Criteria vendor=session.createCriteria(PrqQuotationHeader.class,"hdr")
	    	                		  .createAlias("hdr.Hospital", "h")
	    	                		  .createAlias("hdr.QuotationStatus", "s")
	    	                		  .add(Restrictions.eq("h.Id", hospitalId))
	    	                		  //.add(Restrictions.or(Restrictions.isNotNull("hdr.QuotationNo"), Restrictions.eq("s.Id", 5)));
	    	                		 .add(Restrictions.eq("s.StatusCode", "CL").ignoreCase())
	    	                		 .addOrder(Order.desc("hdr.QuotationDate"));
	    	                 if(flag.equalsIgnoreCase("Q")){
	    	                	 vendor=vendor.add(Restrictions.eq("hdr.Id",quotationNo));
	    	                 }
	    	                 hdPrqQuotationHeaders=vendor.list();
	    	                 System.out.println("");
	    	                }
	    	                if(flag=="" || flag.equalsIgnoreCase("R")){
	    	                 Criteria inspection=session.createCriteria(MmInspectionReport.class,"ir").createAlias("ir.Request", "r")
	    	            			 .createAlias("r.RequestStatus", "rs")
	    			        		  .add(Restrictions.eq("rs.StatusCode", "WO").ignoreCase());
	    	                 if(flag.equalsIgnoreCase("R")){
	    	                	 inspection=inspection
	    	                			 .add(Restrictions.eq("r.Id", Integer.parseInt(box.getString("quotationNo").split("@")[0])));
	    	                 }
	    	                 inspectionReports=inspection.list();
	    	                }
//	    	  		           map.put("vendorDetails", vendorDetails);
	    			          //map.put("mmServiceRequests", mmServiceRequests);
	    					 map.put("inspectionReports", inspectionReports);
	    					 map.put("hdPrqQuotationHeaders", hdPrqQuotationHeaders);
	    				}
	    				return map;
	    			}
    //==============================================================================================================
	  
//		-----------------------------------Pending Commercial Approval----------------------------    	
	  @SuppressWarnings("unchecked")
		@Override
		public Map<String, Object> showPendingCommercialApprovalJsp(Box box,
				Map<String, Object> dataMap) {
			  Map<String, Object> map=new HashMap<String, Object>(); 
				List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
				List<PrqQuotationHeader> hdPrqQuotationHeaders=new ArrayList<PrqQuotationHeader>();
				List<MmMasRequestStatus> stats=new ArrayList<MmMasRequestStatus>();
				List<PrqQuotationVendorDetails> vendorDetails=new ArrayList<PrqQuotationVendorDetails>();
				List<MmInspectionReport> inspectionReports=new ArrayList<MmInspectionReport>();
				Session session=(Session)getSession();

				@SuppressWarnings("unused")
				SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
				Date fromDate=new Date();
				Date toDate=new Date();
				int hospitalId=0;
				int quotationNo=0;
				String flag="";
				String negotiationStatus = "";
				URL resourcePath = Thread.currentThread().getContextClassLoader()
						.getResource("adt.properties");
				try {
					       Properties prop = new Properties();
					       prop.load(new FileInputStream(new File(resourcePath.getFile())));
					       negotiationStatus = prop.getProperty("negotiationStatus");

	                          
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(dataMap.get("hospitalId")!=null && dataMap.get("hospitalId")!=""){
					hospitalId=(Integer)dataMap.get("hospitalId");
					   
			              if(dataMap.get("quotationNo") != null ){
	  					 quotationNo = Integer.parseInt((String)dataMap.get("quotationNo").toString().split("@")[0].trim());
	  					 flag=(String)dataMap.get("quotationNo").toString().split("@")[1].trim();
	  				  }
	                if(flag=="" || flag.equalsIgnoreCase("Q")){
	                  Criteria vendor=session.createCriteria(PrqQuotationHeader.class,"hdr")
//	                		  .createAlias("vendor.Header", "hdr")
	                		  .createAlias("hdr.Hospital", "h")
	                		  .createAlias("hdr.QuotationStatus", "s")
	                		  .add(Restrictions.eq("h.Id", hospitalId))
	                		  //.add(Restrictions.or(Restrictions.isNotNull("hdr.QuotationNo"), Restrictions.eq("s.Id", 5)));
	                		 .add(Restrictions.eq("s.StatusCode", "TA").ignoreCase())
	                		  .addOrder(Order.desc("hdr.QuotationDate"));
	                 if(flag.equalsIgnoreCase("Q")){
	                	 vendor=vendor.add(Restrictions.eq("hdr.Id",quotationNo));
	                 }
	                 hdPrqQuotationHeaders=vendor.list();
	                 System.out.println("");
	                }
	                if(flag=="" || flag.equalsIgnoreCase("R")){
	                 Criteria inspection=session.createCriteria(MmInspectionReport.class,"ir").createAlias("ir.Request", "r")
	            			 .createAlias("r.RequestStatus", "rs")
			        		  .add(Restrictions.eq("rs.StatusCode", "TA").ignoreCase());
	                 if(flag.equalsIgnoreCase("R")){
	                	 inspection=inspection
	                			 .add(Restrictions.eq("r.Id", Integer.parseInt(box.getString("quotationNo").split("@")[0])));
	                 }
	                 inspectionReports=inspection.list();
	                }
//	  		           map.put("vendorDetails", vendorDetails);
			          //map.put("mmServiceRequests", mmServiceRequests);
					 map.put("inspectionReports", inspectionReports);
					 map.put("hdPrqQuotationHeaders", hdPrqQuotationHeaders);
				}
				return map;
			}
//==============================================================================================================
	@Override
	public Map<String, Object> showPOCreationJsp(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PrqQuotationItemDetails> prqItem=new ArrayList<PrqQuotationItemDetails>();
		List<MmSafetyProcedureMaterials> mmSafetyProcedureMaterial=new ArrayList<MmSafetyProcedureMaterials>();
		List<MasHospital> hospitals=new ArrayList<MasHospital>();
		Session session = (Session) getSession();
		
		session = (Session) getSession();
		int requitionId = 0;
		String flag="";
		try {
			
			if(dataMap.get("requitionId") != null ){
				requitionId = (Integer)dataMap.get("requitionId");
				flag=(String)dataMap.get("flag");
			}
			
			if(flag.equalsIgnoreCase("Q")){
			 Criteria cr=session.createCriteria(PrqQuotationItemDetails.class,"item")
				     .createAlias("item.VendorDetails", "vendor")
				     .createAlias("item.ItemStatus", "stat")
				     .add(Restrictions.eq("stat.StatusCode","NEG"))
				     .add(Restrictions.eq("item.VendorFlag","n"))
				     .add(Restrictions.eq("vendor.Id",requitionId));
		      prqItem=cr.list();
			}
			if(flag.equalsIgnoreCase("R"))
			{
				 mmSafetyProcedureMaterial=session.createCriteria(MmSafetyProcedureMaterials.class,"sp")
			    		  .createAlias("sp.InspectionReport", "in")
			    		  .createAlias("in.Hospital", "h")
			    		  .add(Restrictions.eq("in.Id", requitionId))
							.add(Restrictions.eq("h.Id", (Integer)dataMap.get("hospitalId")))
							.add(Restrictions.eq("sp.Status","c").ignoreCase()).list();
			}
			hospitals=session.createCriteria(MasHospital.class).list();
       } catch (Exception e) {
			   e.printStackTrace();
		     }
		map.put("mmSafetyProcedureMaterial", mmSafetyProcedureMaterial);
		map.put("prqItem", prqItem);
		map.put("hospitals", hospitals);
		return map;
	}
//=====================================================================================================================
	
  //================method for creating  po==============================================================
	
	@Override
	public Map<String, Object> submitPoCreation(Box box,Map<String, Object> dataMap) {
		
		 org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
  		hbt.setFlushModeName("FLUSH_AUTO");
  		hbt.setCheckWriteOperations(false);
  		Map<String, Object> map=new HashMap<String, Object>();
  		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
  		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

  		int userId=(Integer)dataMap.get(RequestConstants.USER_ID);
  		int itemManfactureId = 0; // added by amit das on 07-06-2016
  		MasManufacturer manufacturer = null; // added by amit das on 07-06-2016
  		Date cd=new Date();
  		Date requiredDate=new Date();
  		String msg="";
  		          Session session = (Session) getSession();
  		         String purchaseorder = "";
  		         String workOrder="";
  		             URL resourcePath = Thread.currentThread().getContextClassLoader()
  				                                                .getResource("adt.properties");
  		     try { 
  			                   Properties prop = new Properties();
  			                   prop.load(new FileInputStream(new File(resourcePath.getFile())));
  			                 purchaseorder = prop.getProperty("purchaseorder");
  			                 workOrder = prop.getProperty("poComplete");
  		                      } catch (IOException e) {
  			                e.printStackTrace();
  		                    }
  		
  		               MmMasRequestStatus status=(MmMasRequestStatus) session
  						.createCriteria(MmMasRequestStatus.class)
  						.add(Restrictions
  								.eq("StatusCode",purchaseorder))
  								
  						.uniqueResult();
  		              // System.out.println("statu"+status.getId());
  		             MmMasRequestStatus masRequestStatus=(MmMasRequestStatus) session
  	  						.createCriteria(MmMasRequestStatus.class)
  	  						.add(Restrictions
  	  								.eq("StatusCode",workOrder))
  	  								
  	  						.uniqueResult();
  		             // System.out.println("jfhjfhegefgvfe"+status.getId());
  		         int itemCount=box.getInt("itemCount");
  		        PrqQuotationItemDetails item=null;
  		        MmInspectionReport mmInspectionReport=null;
  		        MmServiceRequest mmServiceRequest=null;
  		        StorePoDetail detail=null;
  		        StorePoHeader header=null;
  		         header= new StorePoHeader();
  		   //   System.out.println(box.getInt("vId"));
  		       header.setPoDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("poCreationDate")));
		         header.setDeliveryDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("deliveryDate")));
	        	 header.setDeliveryTerms(box.getString("deliveryInstruction"));
	        	 header.setDeliveryAddress(box.getString("deliveryAddress"));
	        	 header.setPoTime(time);
	        	 header.setLastChgDate(date);
	        	 header.setLastChgTime(time);
	        	 
	  		        int hospitalId=(Integer)dataMap.get(RequestConstants.HOSPITAL_ID);
	  		       // System.out.println("jhfhfvhu"+(Integer)dataMap.get(RequestConstants.HOSPITAL_ID));
	  		        MasHospital hospital=new MasHospital();
	  		  		hospital.setId(hospitalId);
	  		  		header.setHospital(hospital);
	  		  		int hdrId=(Integer)hbt.save(header);
	  		  		header.setPoNumber("PO"+"/"+dataMap.get(RequestConstants.HOSPITAL_ID)+"/"+hdrId);
  		  	   // hbt.save(header);
	        	// hbt.flush();
	        	// hbt.clear();
  		         //code for procurement header
  		         if(box.getString("flag").equalsIgnoreCase("P")){
  		        	 PrqQuotationVendorDetails details=(PrqQuotationVendorDetails) session.load(PrqQuotationVendorDetails.class,box.getInt("vId"));
  		        	 details.setVendorFlag("w");
  		        	  PrqQuotationHeader prqQuotationHeader=(PrqQuotationHeader)session.load(PrqQuotationHeader.class,box.getInt("headerId"));
  		        	  prqQuotationHeader.setQuotationStatus(status);
  		        	  prqQuotationHeader.setLastChgDate(date);
  		        	  prqQuotationHeader.setLastChgTime(time);
  		        	  PrqQuotationVendorDetails prqQuotationVendorDetail=new PrqQuotationVendorDetails();
  		        	  prqQuotationVendorDetail.setId(box.getInt("vId"));
  		        	  header.setVendorDetails(prqQuotationVendorDetail);
  		            MasStoreSupplier storeSupplier=new MasStoreSupplier();
  		        	 storeSupplier.setId(box.getInt("vendorId"));
  		        	 header.setSupplier(storeSupplier);
  		           MasHospital hospital1=new MasHospital();
  		        	 hospital1.setId(box.getInt("deliveryTo"));
  		        	 header.setDeliveryTo(hospital1);
  		        	header.setStatus(status);
  		        	 header.setQuotationNumber(box.getString("quotationNo."));
  		        	 header.setQuotationDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("quotationDate")));
  		        	 hbt.save(header);
  		        	 hbt.flush();
  		        	 hbt.clear();
  		         }	
  		         //code for maintinen====ce header
  		          if(box.getString("flag").equalsIgnoreCase("M")){
  		        	 MasStoreSupplier storeSupplier=new MasStoreSupplier();
  		        	 storeSupplier.setId(box.getInt("mvend"));
  		        	 header.setSupplier(storeSupplier);
 		        	 hospital.setId(box.getInt("deliveryTo"));
 		        	 header.setDeliveryTo(hospital);
 		        	
 		        	header.setStatus(masRequestStatus);
 		        	 hbt.save(header);
  		        	 hbt.flush();
  		        	 hbt.clear();
  		          }
  		          
  		         
	  		  		
  		    for(int i=1;i<=itemCount;i++) 
  		    {
  		    	    int id = box.getInt("itemCheckBox"+i);
  			         int maintenance = box.getInt("mCheckBox"+i);
  			        itemManfactureId = box.getInt("itemManfactureId"+i); // added by amit das on 07-06-2016
  			         if(id!=0)
  			        	{
  			        	 
  			        	item=(PrqQuotationItemDetails) session.load(PrqQuotationItemDetails.class,id);
  			        	 item.setItemStatus(status);
  			        	 
  			        	detail=new StorePoDetail();
  			        			detail.setPo(header);
  			        			// added by amit das on 07-06-2016
  			        			if(itemManfactureId!=0){
  			        				manufacturer = new MasManufacturer();
  			        				manufacturer.setId(itemManfactureId);
  			        				detail.setManufacturer(manufacturer);
  			        			}
  			        		// ended by amit das on 07-06-2016
  			        			MasStoreItem masStoreItem=new MasStoreItem();
  			        			masStoreItem.setId(box.getInt("itemId"+i));
  			        			detail.setItem(masStoreItem);
  			        			PrqQuotationItemDetails itemDetails=new PrqQuotationItemDetails();
  			                   itemDetails.setId(box.getInt("itemCheckBox"+i));
  			                   detail.setItemDetails(itemDetails);
  			        	       detail.setItemStatus("w");
  			        	       System.out.println("rate============"+item.getRate());
  			        	       detail.setUnitRate(item.getRate());
  			        		    detail.setQuantityOrdered(new BigDecimal(box.getInt("qty"+i)));
  			        		    detail.setAmount(new BigDecimal(box.getInt("netAmt"+i)));
  			        		    detail.setTaxPercent(new BigDecimal(box.getInt("tax"+i)));
                                detail.setDiscountPercent(new BigDecimal(box.getInt("discount"+i))); 
                               detail.setDiscountAmount(new BigDecimal(box.getInt("totAmt"+i)));
                              hbt.save(detail);
                              hbt.flush();
                    	     	hbt.clear();
  			        	}
  			        	
  			        	if(maintenance!=0)
  			        		
  			        	{
  			        		detail=new StorePoDetail();
			        			detail.setPo(header);
			        			MasStoreItem masStoreItem=new MasStoreItem();
  			        			masStoreItem.setId(box.getInt("mItemid"+i));
  			        			detail.setItem(masStoreItem);
  			        			detail.setQuantityOrdered(new BigDecimal(box.getInt("qty"+i)));
  			        			hbt.save(detail);
  			        			hbt.flush();
  			        	     	hbt.clear();
  			        		MmSafetyProcedureMaterials  mmSafetyProcedureMaterials=(MmSafetyProcedureMaterials)session.load(MmSafetyProcedureMaterials.class, maintenance);
  			        		mmSafetyProcedureMaterials.setStatus("w");
  			        		hbt.update(mmSafetyProcedureMaterials);
  			        		hbt.flush();
  			        		hbt.clear();
  			        		mmInspectionReport=(MmInspectionReport)session.load(MmInspectionReport.class, mmSafetyProcedureMaterials.getInspectionReport().getId());
  			        		mmInspectionReport.setRequestStatus(masRequestStatus);
  			        		mmInspectionReport.setPoDetail(detail);
  			        		hbt.update(mmInspectionReport);
  			        		hbt.flush();
  			        		hbt.clear();
  			        		mmServiceRequest=(MmServiceRequest)session.load(MmServiceRequest.class, mmInspectionReport.getRequest().getId());
  			        		mmServiceRequest.setRequestStatus(masRequestStatus);
  			        		hbt.update(mmServiceRequest);
  			        		hbt.flush();
  			        		hbt.clear();
  			        		
  			        		
  			        	}
  			        }
  		           
  		    /*
  		     * By Ujjwal for Email Integration
  		     * on 24/09/2015 
  		     * at 06:09 PM
  		     */
  		  String fromEmail="";
			String toEmail="";
			String messageToBeSent="";
			String itemName="";
			List<Users> userList=new ArrayList<Users>();
			if(userList.size()>0){
				userList=session.createCriteria(Users.class).add(Restrictions.idEq(userList)).list();
				for(Users user:userList){
					fromEmail=user.getEmailAddress();
				}
				List<MasStoreSupplier>supplierLIst=new ArrayList<MasStoreSupplier>();
				supplierLIst=session.createCriteria(MasStoreSupplier.class).add(Restrictions.idEq(box.getInt("vendorId"))).list();
				for(MasStoreSupplier supplier:supplierLIst){
					toEmail=supplier.getEmailId();
				}
	  		    if(toEmail!=null && !toEmail.equals("")){
	  		    	SendMail sendMail=new SendMail();
	  		    	sendMail.sendMail("mail.jkt.com", toEmail, fromEmail, "", "", "PO Cpnfirmation", "Your PO Generated Successfully!!");
	  		    }
			}
			List<MasStoreSupplier>supplierLIst=new ArrayList<MasStoreSupplier>();
			supplierLIst=session.createCriteria(MasStoreSupplier.class).add(Restrictions.idEq(box.getInt("vendorId"))).list();
			for(MasStoreSupplier supplier:supplierLIst){
				toEmail=supplier.getEmailId();
			}
  		    if(toEmail!=null && !toEmail.equals("")){
  		    	SendMail sendMail=new SendMail();
  		    	//sendMail.sendMail("mail.jkt.com", toEmail, fromEmail, "", "", "PO Cpnfirmation", "Your PO Generated Successfully!!");
  		    }
  		    //ENd by UJJWAL
  		    
  		  int poId = header.getId();
  		  int locationId = hospitalId;
  		//msg="<span style='color: green'>Approved Sucessfully Do You want to print the purchase Order.</span><span><a href=\"stores?method=printPurchaseOrder&poId="+poId+"&locationId="+locationId+"\">Print Purchase Order</a></span>";
  		
  		    //msg="<span style='color: green'> Purchase Order Created Successfully Do You want to print.</span><span><a href=\"stores?method=printPurchaseOrder&poId="+poId+"&locationId="+locationId+"\">Print Purchase Order</a></span>";
  		  
  		msg="<span style='color: green'> Purchase Order Created Successfully Do You want to print.</span>";
  		    
  		    map.put("msg", msg);
  		    
  		return map;
	
	}
	
	//=================================================================================================
	@SuppressWarnings("unused")
	@Override
	public Map<String, Object> showPendingForPOApprovalJsp(Box box,
			Map<String, Object> dataMap) {
		
		Map<String, Object> map=new HashMap<String, Object>(); 
		Session session=(Session)getSession();
		List<StorePoHeader> vendorlist=new ArrayList<StorePoHeader>();
		List<StorePoHeader> header=new ArrayList<StorePoHeader>();
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date fromDate=new Date();
		Date toDate=new Date();
		int hospitalId=0;
		int vendorName=0;
		String poNo="";
	       String purchaseorder = "";
	             URL resourcePath = Thread.currentThread().getContextClassLoader()
			                                                .getResource("adt.properties");
	     try { 
		                   Properties prop = new Properties();
		                   prop.load(new FileInputStream(new File(resourcePath.getFile())));
		                 purchaseorder = prop.getProperty("purchaseorder");
	                      } catch (IOException e) {
		                e.printStackTrace();
	                    }
		if(dataMap.get("hospitalId")!=null && dataMap.get("hospitalId")!=""){
			hospitalId=(Integer)dataMap.get("hospitalId");
		}
		Criteria cr=session.createCriteria(StorePoHeader.class,"sph")
	            .createAlias("sph.Status", "stat")
	            .createAlias("sph.Supplier", "sup")
	     .add(Restrictions.eq("stat.StatusCode", purchaseorder))
	     .addOrder(Order.desc("sph.PoDate"));
		
		
		if((Integer)dataMap.get("vendorName") != 0 && !dataMap.get("vendorName").equals("") ){
			cr=cr.add(Restrictions.eq("sup.Id", (Integer)dataMap.get("vendorName")));
		}
		//System.out.println("---rrr"+vendorName);
		 if(dataMap.get("poNo") != null && !dataMap.get("poNo").equals("") ){
			cr.add(Restrictions.eq("sph.PoNumber", (String)dataMap.get("poNo")));
		 }
		
		if(dataMap.get("fromDate")!=null && !dataMap.get("fromDate").equals("") &&dataMap.get("toDate")!=null && !dataMap.get("toDate").equals("")){
			try{
			fromDate=sdf.parse(dataMap.get("fromDate").toString());
			toDate=sdf.parse(dataMap.get("toDate").toString());
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			cr=cr.add(Restrictions.between("sph.PoDate", fromDate, toDate));
		}
		  vendorlist=cr.list();
		  header=(List<StorePoHeader>) session.createCriteria(StorePoHeader.class,"str")
				  .createAlias("str.Status", "stat")
				     .add(Restrictions.eq("stat.StatusCode", purchaseorder)).list();
				  
		  map.put("header",header);
		 map.put("vendorlist",vendorlist);
		
		return map;
	}

	
  //======================================================================
	@Override
	public Map<String, Object> showPOApprovalJsp(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map=new HashMap<String, Object>(); 
		Session session=(Session)getSession();
		List<StorePoHeader> poHeaders=new ArrayList<StorePoHeader>();
		List<StorePoDetail>poDetails=new ArrayList<StorePoDetail>();
		List<MmMasRequestStatus> status=new ArrayList<MmMasRequestStatus>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date fromDate=new Date();
		Date toDate=new Date();
		int hospitalId=0;
		int requisitionId=0;
		String[] approvedStatus=null;
		 URL resourcePath = Thread.currentThread().getContextClassLoader()
				  .getResource("adt.properties");
		                     try {
			                 Properties prop = new Properties();
			                 prop.load(new FileInputStream(new File(resourcePath.getFile())));
			                 approvedStatus = prop.getProperty("submission.status.list").split("#");
		                              } catch (IOException e) {
			                                e.printStackTrace();
		                                       }

		if(dataMap.get("hospitalId")!=null && dataMap.get("hospitalId")!=""){
			hospitalId=(Integer)dataMap.get("hospitalId");
		}
		System.out.println("id-----"+requisitionId);
		if(dataMap.get("requitionId")!=null && dataMap.get("requitionId")!=""){
			requisitionId=(Integer)dataMap.get("requitionId");
			
		}
		//System.out.println("----"+requisitionId);
		Criteria cr=session.createCriteria(StorePoDetail.class,"store")
				.createAlias("store.Po", "poh")
				.add(Restrictions.eq("poh.Id",requisitionId));
		
		poDetails=cr.list();
		//System.out.println(poDetails.size()+"hhhh---");
		Criteria cc=session.createCriteria(MmMasRequestStatus.class,"stat")
				.add(Restrictions.in("StatusCode", approvedStatus));
		status=cc.list();
		map.put("status", status);
		map.put("poDetails", poDetails);
		
		return map;
	}
  //==================================================================================================================
	
	//================================method for Po Approval======================================================

	@Override
	public Map<String, Object> poApproval(Box box, Map<String, Object> dataMap) {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		Map<String, String> map=new HashMap<String, String>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		int userId=(Integer)dataMap.get(RequestConstants.USER_ID);
		int hospitalId=(Integer)dataMap.get(RequestConstants.HOSPITAL_ID);
		Date cd=new Date();
		Date requiredDate=new Date();
		String msg="";
		Session session = (Session) getSession();
		MmMasRequestStatus mmasRequestStatus=new MmMasRequestStatus();
		List<MmMasRequestStatus> status1=new ArrayList<MmMasRequestStatus>();
		status1=session.createCriteria(MmMasRequestStatus.class).add(Restrictions.eq("StatusCode", box.getString("status"))).list();
		int itemCount=box.getInt("itemCount");
		StorePoHeader hdr=(StorePoHeader) session.get(StorePoHeader.class,box.getInt("headerId"));
		MasHospital hospital=new MasHospital();
		hospital.setId(hospitalId);
		hdr.setHospital(hospital);
		hdr.setRemarks(box.getString("remarks"));
		mmasRequestStatus.setId(status1.get(0).getId());
		hdr.setStatus(mmasRequestStatus);
		hdr.setLastChgTime(time);
		hdr.setLastChgDate(date);
		  hbt.update(hdr);
		   for(int i=1;i<=itemCount;i++)
			   
		   { int id = box.getInt("itemCheckBox"+i);
			     System.out.println(box.getInt("itemcount")+"id"+id);
		         if(id!=0)
		        	{
		        	   System.out.println("id333"+id);
					StorePoDetail detail=(StorePoDetail)session.get(StorePoDetail.class,id);
					  detail.setItemStatus("a");
						hbt.update(detail);	
						hbt.flush();
						hbt.clear();
				}
		}
			
		hbt.flush();
		hbt.clear();
		int poId = box.getInt("headerId");
		int locationId = hdr.getHospital().getId();
		msg="<span style='color: green'>Approved Sucessfully Do You want to print the purchase Order.</span><span><a href=\"stores?method=printPurchaseOrder&poId="+poId+"&locationId="+locationId+"\">Print Purchase Order</a></span>";
		
		dataMap.put("msg",msg);
		return dataMap;
		
	}

	//===========================================================================================================
	@Override
	public Map<String, Object> showPendingListForEnterEquipmentDetailJsp(
			Box box, Map<String, Object> dataMap) {
		Map<String, Object> map=new HashMap<String, Object>();
		/*List<StoreGrnT> storeGrnT=new ArrayList<StoreGrnT>();*/
		List<StoreItemBatchStock> batchStockList=new ArrayList<StoreItemBatchStock>();
		List<MasDepartment> masDepartments=new ArrayList<MasDepartment>();
		List<MasManufacturer> masManufacturers=new ArrayList<MasManufacturer>();
		List<MasInstituteDepartment> instituteDepartments=new ArrayList<MasInstituteDepartment>();
		List<PrqAssetDetails> assetDetails=new ArrayList<PrqAssetDetails>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		String[] equipmentCode=null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("maintenance.properties");
		try {
			java.util.Properties prop = new java.util.Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			equipmentCode = prop.getProperty("procurement.equipment.category.code").split("#");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(box.getInt("itemId") != 0){
			Criteria cr1=
					getSession().createCriteria(StoreItemBatchStock.class,"sgt")
					.createAlias("sgt.Item", "i").add(Restrictions.eq("i.Id", box.getInt("itemId")))
					.createAlias("i.ItemType", "it")
					.add(Restrictions.in("it.ItemTypeCode", equipmentCode))
					.add(Restrictions.isNull("EquipmentDetailStatus"))
					.add(Restrictions.eq("Hospital.Id", (Integer)dataMap.get("hospitalId")));
			batchStockList=cr1.list();
		}else{
			Criteria cr1=
					getSession().createCriteria(StoreItemBatchStock.class,"sgt")
					.createAlias("sgt.Item", "i")
					.createAlias("i.ItemType", "it")
					.add(Restrictions.in("it.ItemTypeCode", equipmentCode))
					.add(Restrictions.isNull("EquipmentDetailStatus"))
					.add(Restrictions.eq("Hospital.Id", (Integer)dataMap.get("hospitalId")));
			batchStockList=cr1.list();	
			
			
		}
		/*Criteria cr=
				getSession().createCriteria(StoreGrnT.class,"sgt").createAlias("sgt.GrnMaster", "sgm")
				.createAlias("sgt.Item", "i")
				.createAlias("sgm.Hospital", "h")
				.createAlias("i.ItemType", "it")
				.add(Restrictions.in("it.ItemTypeCode", equipmentCode));
		Criteria cr1=
				getSession().createCriteria(StoreItemBatchStock.class,"sgt")
				.createAlias("sgt.Item", "i")
				.createAlias("i.ItemType", "it")
				.add(Restrictions.in("it.ItemTypeCode", equipmentCode))
				.add(Restrictions.eq("Hospital.Id", (Integer)dataMap.get("hospitalId")));
		Criteria department=getSession().createCriteria(MasInstituteDepartment.class, "mid");
		Criteria manufacturer=getSession().createCriteria(MasManufacturer.class, "m");
		
		if(dataMap.get("hospitalId")!=null){
			cr=cr.add(Restrictions.eq("h.Id", (Integer)dataMap.get("hospitalId")));
			department=department.createAlias("mid.Institute", "h").add(Restrictions.eq("h.Id", (Integer)dataMap.get("hospitalId")));
		}
		if(box.getString("grnDate")!=null && box.getString("grnDate")!=""){
			try{
			cr=cr.add(Restrictions.eq("sgm.GrnDate", sdf.parse(box.getString("grnDate"))));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(box.getString("grnNo")!=null && box.getString("grnNo")!=""){
			cr=cr.add(Restrictions.eq("sgm.GrnNo", box.getString("grnNo")));
		}
		if(box.getString("requestId")!=null && box.getString("requestId")!=""){
			cr=cr.add(Restrictions.eq("sgt.Id", box.getInt("requestId")));
		}
		if(box.getString("equipmentName")!=null && box.getString("equipmentName")!=""){
			cr=cr.add(Restrictions.like("i.Nomenclature", box.getString("equipmentName")));
		}
		storeGrnT=cr.add(Restrictions.or(Restrictions.ltProperty("sgt.EqpDetailQty", "sgt.ReceivedQty"), Restrictions.isNull("sgt.EqpDetailQty"))).list();
		masDepartments=department.createAlias("Department", "d").list();
		System.out.println("maslist"+masDepartments.size());
		System.out.println("maslist+++"+storeGrnT.size());
		System.out.println("maslist+++"+masManufacturers.size());
		masManufacturers=manufacturer.addOrder(Order.asc("m.ManufacturerName")).list();
		Criteria criteria1=(Criteria) getSession().createCriteria(PrqAssetDetails.class)
				              .createAlias("Item", "item").add(Restrictions.eq("item.Id", box.getInt("itemId")));
		assetDetails=criteria1.list();
		batchStocks=cr1.list();*/
		
		Criteria department=getSession().createCriteria(MasInstituteDepartment.class, "mid");
		masDepartments=department.createAlias("Department", "d").list();
		
		Criteria manufacturer=getSession().createCriteria(MasManufacturer.class, "m");
		masManufacturers=manufacturer.addOrder(Order.asc("m.ManufacturerName")).list();
		
		Criteria criteria1=(Criteria) getSession().createCriteria(PrqAssetDetails.class)
				              .createAlias("Item", "item").add(Restrictions.eq("item.Id", box.getInt("itemId")));
		assetDetails=criteria1.list();
		System.out.println("list++"+batchStockList.size());
		map.put("batchStockList", batchStockList);
		map.put("assetDetails", assetDetails);
		map.put("masDepartments", masDepartments);
		map.put("masManufacturers", masManufacturers);
		return map;
	}

	@Override
	public Map<String, Object> showEquipmentDetailJsp(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<StoreItemBatchStock> batchStockList=new ArrayList<StoreItemBatchStock>();
		List<MasDepartment> masDepartments=new ArrayList<MasDepartment>();
		List<MasManufacturer> masManufacturers=new ArrayList<MasManufacturer>();
		List<MasInstituteDepartment> instituteDepartments=new ArrayList<MasInstituteDepartment>();
		List<PrqAssetDetails> assetDetails=new ArrayList<PrqAssetDetails>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		String[] equipmentCode=null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("maintenance.properties");
		try {
			java.util.Properties prop = new java.util.Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			equipmentCode = prop.getProperty("procurement.equipment.category.code").split("#");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Session session = (Session)getSession();
		batchStockList = session.createCriteria(StoreItemBatchStock.class,"sgt")
							.createAlias("sgt.Item", "i")
							.createAlias("i.ItemType", "it")
							.add(Restrictions.in("it.ItemTypeCode", equipmentCode)).add(Restrictions.eq("Id", box.getInt("batchStockId")))
							.add(Restrictions.isNull("EquipmentDetailStatus"))
							.add(Restrictions.eq("Hospital.Id", (Integer)dataMap.get("hospitalId"))).list();
		Criteria department=getSession().createCriteria(MasInstituteDepartment.class, "mid");
		/*masDepartments=department.createAlias("Department", "d").list();*/ // commented by amit das on 02-09-2016
		
		masDepartments=department.createAlias("Department", "d")
				.createAlias("Institute", "i").setProjection(Projections.distinct(Projections.property("mid.Department")))
				.add(Restrictions.eq("i.Id", (Integer)dataMap.get("hospitalId"))).list(); // added by amit das on 02-09-2016
		
		Criteria manufacturer=getSession().createCriteria(MasManufacturer.class, "m");
		masManufacturers=manufacturer.addOrder(Order.asc("m.ManufacturerName")).list();
		
		Criteria criteria1=(Criteria) getSession().createCriteria(PrqAssetDetails.class)
				              .createAlias("Item", "item").add(Restrictions.eq("item.Id", box.getInt("itemId")));
		assetDetails=criteria1.list();
		System.out.println("list++"+batchStockList.size());
		map.put("batchStockList", batchStockList);
		map.put("assetDetails", assetDetails);
		map.put("masDepartments", masDepartments);
		map.put("masManufacturers", masManufacturers);
		return map;
	}

	@Override
	public Map<String, Object> showManufactureDetailJsp(Box box) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> showCategoryMasterJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasAssetCategory> searchCategoryList = new ArrayList<MasAssetCategory>();
		searchCategoryList = getHibernateTemplate().find("from jkt.hms.masters.business.MasAssetCategory ");
		map.put("searchCategoryList", searchCategoryList);
		return map;
	}

	@Override
	public Map<String, Object> showSubCategoryMasterJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session =(Session)getSession();
		List<MasAssetCategory> categoryList = new ArrayList<MasAssetCategory>();
		
		categoryList =session.createCriteria(MasAssetCategory.class).add(Restrictions.eq("Status","y").ignoreCase()).addOrder(Order.asc("AssetCategoryCode")).list();
		map.put("categoryList", categoryList);
		return map;
	}

	@Override
	public Map<String, Object> showAssetDetailsJsp(Map<String, Object> details) {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		Map<String, Object> map = new HashMap<String, Object>();
		MasHospital masHospital = new MasHospital();
		List<MasDistrict> masDistrict = new ArrayList<MasDistrict>();
		List<PrqAssetDetails> assetMovable=new ArrayList<PrqAssetDetails>();
		List<MasStoreItem> itemList=new ArrayList<MasStoreItem>();
		List<MasStoreSection> sectionList=new ArrayList<MasStoreSection>();
		
		Session session = getSession();
		
		// added by amit das on 28-07-2016
		String immoveableAndMoaveableAssetCode = null;
		String immoveableAssetCode[] = null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("maintenance.properties");
		try {
			java.util.Properties prop = new java.util.Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			immoveableAndMoaveableAssetCode = prop.getProperty("immoveable.moveable.asset.Code");
			immoveableAssetCode = immoveableAndMoaveableAssetCode.split("#");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// added by amit das on 28-07-2016
		
		if (details.get("hospitalId") != null) {
			masHospital = (MasHospital) hbt.get(MasHospital.class,
					(Integer) details.get("hospitalId"));
		}
		masDistrict = session
				.createCriteria(MasDistrict.class, "d")
				.createAlias("State", "s")
				.add(Restrictions.eq("s.Id", masHospital.getDistrict()
						.getState().getId())).list();
		
		/*assetMovable = getHibernateTemplate().find(
				"from jkt.hms.masters.business.PrqAssetDetails ");*/
		assetMovable=session
					.createCriteria(PrqAssetDetails.class)
					.add(Restrictions.eq("Status", "Y").ignoreCase())
					.addOrder(Order.asc("AssetName"))
					.list();

		
		
		
		
		List<MasItemCategory> masItemCategories = session
				.createCriteria(MasItemCategory.class)
				.createAlias("Section", "sec")
				.createAlias("sec.MasStoreItems", "mas")
				.createAlias("sec.ItemType", "itemType")
				.createAlias("mas.Group", "grp")
				.add(Restrictions.eq("grp.GroupName", "Assets"))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				//.add(Restrictions.eq("itemType.ItemTypeCode", immoveableAssetCode).ignoreCase()) // commented  by amit das
				.add(Restrictions.in("itemType.ItemTypeCode", immoveableAssetCode))
				.addOrder(Order.asc("ItemCategoryName")).list();
		List<MasManufacturer> manufacturers = session
				.createCriteria(MasManufacturer.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("ManufacturerName")).list();

		List<MasStoreUnit> itemConversions = session
				.createCriteria(MasStoreUnit.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("UnitName")).list();
		itemList = session.createCriteria(MasStoreItem.class)
				   .createAlias("Group", "gp")
				   .createAlias("ItemType", "it")
			       //.add(Restrictions.eq("it.ItemTypeCode", "IA").ignoreCase())
				   .add(Restrictions.eq("gp.GroupCode", "Ass").ignoreCase())
				.add(Restrictions.eq("Status", "y")).list();
		System.out.println("dehuh"+itemList.size());
		sectionList = session.createCriteria(MasStoreSection.class).createAlias("ItemType", "itemType").createAlias("itemType.Group", "group")
				// .add(Restrictions.eq("SectionCode", "BU").ignoreCase())
				// .add(Restrictions.eq("itemType.ItemTypeCode", immoveableAssetCode).ignoreCase()) // commented  by amit das
				.add(Restrictions.in("itemType.ItemTypeCode", immoveableAssetCode))
				// .add(Restrictions.eq("group.GroupName", "Assets").ignoreCase()).list() // commented by amit das on 28-07-2016
				.add(Restrictions.eq("group.GroupName", "Asset").ignoreCase()).list(); // added by amit das on 28-07-2016
		
		
		map.put("manufacturers", manufacturers);
		map.put("itemList", itemList);
		map.put("itemConversions", itemConversions);
		map.put("masItemCategories", masItemCategories);
		map.put("masDistrict", masDistrict);
		map.put("assetMovable", assetMovable);
		map.put("sectionList", sectionList);
		return map;
	}

	@Override
	public Map<String, Object> showPendingListForAuctionJsp(Box box,
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> showAuctionDetailJsp(Box box,
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> showInsuranceDetailJsp(Box box,
			Map<String, Object> dataMap) {

		Map<String, Object> map=new HashMap<String, Object>();
		List<PrqAssetDetails> prqInsuranceDetails=new ArrayList<PrqAssetDetails>();
		List<MasInsuranceCompany> insuranceDetails=new ArrayList<MasInsuranceCompany>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Integer hospitalId=0;
		Integer userId=0;
		
		Date insuranceDetailDate=null;
		if(dataMap.get("hospitalId")!=null){
			hospitalId=(Integer)dataMap.get("hospitalId");
		}
		if(dataMap.get("hospitalId")!=null){
			userId=(Integer)dataMap.get("userId");
		}
		if((dataMap.get("assetCode")!=null && !((String)dataMap.get("assetCode")).equalsIgnoreCase(""))
				||(dataMap.get("assetname")!=null && !((String)dataMap.get("assetname")).equalsIgnoreCase("")))
		{
			Criteria cr= getSession().createCriteria(PrqAssetDetails.class, "prq")
				.createAlias("prq.AssetCategory", "ac")
				.add(Restrictions.eq("prq.Status", "y").ignoreCase());
				
		/*if(dataMap.get("insuranceDetailDate")!=null ){
			try{
				insuranceDetailDate=sdf.parse((String)dataMap.get("insuranceDetailDate"));
			}catch(Exception e){e.printStackTrace();}
			cr=cr.add(Restrictions.eq("InsuranceDate", insuranceDetailDate));
		}*/
		if(dataMap.get("assetCode")!=null && !((String)dataMap.get("assetCode")).equalsIgnoreCase("")){
			cr=cr.add(Restrictions.eq("AssetCode", (String)dataMap.get("assetCode")).ignoreCase());
			
		}
		if(dataMap.get("assetname")!=null && !((String)dataMap.get("assetname")).equalsIgnoreCase("")){
			cr=cr.add(Restrictions.eq("AssetName", (String)dataMap.get("assetname")).ignoreCase());
		}
		/*if(dataMap.get("catogery")!=null){
			cr=cr.add(Restrictions.eq("ac.AssetCategory", (String)dataMap.get("catogery")));
		}*/
		prqInsuranceDetails=cr.list();
		}
		insuranceDetails=getSession().createCriteria(MasInsuranceCompany.class,"ins").add(Restrictions.eq("ins.Status", "y").ignoreCase())
				.list();
		map.put("insuranceDetails", insuranceDetails);
		map.put("prqInsuranceDetails", prqInsuranceDetails);
		return map;
		
	}

	@Override
	public Map<String, Object> showInsuranceClaimAndTrackingJsp(Box box,
			Map<String, Object> dataMap) {
		
		Map<String, Object> map=new HashMap<String, Object>();
		List<PrqInsuranceDetails> prqInsuranceDetails=new ArrayList<PrqInsuranceDetails>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Integer hospitalId=0;
		Integer userId=0;
		
		Date insuranceDetailDate=null;
		if(dataMap.get("hospitalId")!=null){
			hospitalId=(Integer)dataMap.get("hospitalId");
		}
		if(dataMap.get("hospitalId")!=null){
			userId=(Integer)dataMap.get("userId");
		}
		if((dataMap.get("assetCode")!=null && !((String)dataMap.get("assetCode")).equalsIgnoreCase(""))
				||(dataMap.get("assetname")!=null && !((String)dataMap.get("assetname")).equalsIgnoreCase("")))
		{
			 Object [] stat={"i","r"};
			Criteria cr= getSession().createCriteria(PrqInsuranceDetails.class, "prq")
				.createAlias("prq.Asset", "ac")
				.add(Restrictions.in("Status", stat));
				
	/*	if(dataMap.get("insuranceDetailDate")!=null ){
			try{
				insuranceDetailDate=sdf.parse((String)dataMap.get("insuranceDetailDate"));
			}catch(Exception e){e.printStackTrace();}
			cr=cr.add(Restrictions.eq("InsuranceDate", insuranceDetailDate));
		}*/
		if(dataMap.get("assetCode")!=null && !((String)dataMap.get("assetCode")).equalsIgnoreCase("")){
			cr=cr.add(Restrictions.eq("ac.AssetCode", (String)dataMap.get("assetCode")).ignoreCase());
			
		}
		if(dataMap.get("assetname")!=null && !((String)dataMap.get("assetname")).equalsIgnoreCase("")){
			cr=cr.add(Restrictions.eq("ac.AssetName", (String)dataMap.get("assetname")).ignoreCase());
		}
		
		prqInsuranceDetails=cr.list();
		}
		//System.out.println("size in data"+prqInsuranceDetails.size());
		map.put("prqInsuranceDetails", prqInsuranceDetails);
		return map;
		
	}

	@Override
	public Map<String, Object> showPhysicalInventoryDetailsJsp(Map<String, Object> dataMap,Box box) {
		Map<String, Object> genMap=new HashMap<String, Object>();
		List<PrqAssetDetails> assetDetails=new ArrayList<PrqAssetDetails>();
		int hospitalId=0;
		int departmentId=0;
		int itemCatId=0;
		int itemNameId=0;
		if(dataMap.get(RequestConstants.HOSPITAL_ID)!=null){
			hospitalId=Integer.parseInt(dataMap.get(RequestConstants.HOSPITAL_ID).toString());
		}
		if(box.get("itemCategory")!=null&&!"".equals(box.get("itemCategory"))){
			itemCatId=box.getInt("itemCategory");
		}
		if(box.get("departmentName")!=null&&!"".equals(box.get("departmentName"))){
			departmentId=box.getInt("departmentName");
		}
		if(box.get("nomenclature")!=null&&!"".equals(box.get("nomenclature"))){
			String itemName=box.getString("nomenclature");
			int index1=itemName.indexOf("[");
			int index2=itemName.indexOf("]");
			itemName=itemName.substring(index1+1, index2);
			itemNameId=Integer.parseInt(itemName); 
		}
		Object[] statusArray={"y","I","R"};
		Session session=getSession();
		assetDetails=getSession().createCriteria(PrqAssetDetails.class,"mas")
				.add(Restrictions.in("mas.Status",statusArray))
				.addOrder(Order.asc("AssetName"))
				.list();
		List<MasItemCategory> itemCategories=session.createCriteria(MasItemCategory.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("ItemCategoryName"))
				.list(); 
		List<MasDepartment> masDepartments=session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.list();  
		genMap.put("masDepartments", masDepartments);
		genMap.put("assetDetails", assetDetails);
		genMap.put("itemCategories", itemCategories);
		
		
		return genMap;
	}

	
	public boolean addCategory(MasAssetCategory masCategory) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masCategory);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editCategoryToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String categoryName = "";
		@SuppressWarnings("unused")
		String categoryCode = "";
		int categoryId = 0;
		int userId = 0;
		
		categoryId = (Integer) generalMap.get("id");
		System.out.println(categoryId);
		categoryCode = (String) generalMap.get("categoryCode");
		categoryName = (String) generalMap.get("name");
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasAssetCategory masCategory = (MasAssetCategory) getHibernateTemplate().get(
				MasAssetCategory.class, categoryId);

		masCategory.setId(categoryId);
		masCategory.setAssetCategoryName(categoryName);
		Users users = new Users();
		users.setId(userId);
		masCategory.setLastChgBy(users);
		masCategory.setLastChgDate(currentDate);
		masCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCategory);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchCategory(String categoryCode,
			String categoryName) {
		List<MasAssetCategory> searchCategoryList = new ArrayList<MasAssetCategory>();
		Map<String, Object> categoryFieldsMap = new HashMap<String, Object>();
		Session session =(Session)getSession();
		try {
			if ((categoryName != null) || (categoryCode == null)) {
				//searchCategoryList = getHibernateTemplate().find("from jkt.hms.masters.business.MasCategory imc where imc.CategoryName like '"+ categoryName + "%' order by imc.CategoryName");
				searchCategoryList =session.createCriteria(MasAssetCategory.class).add(Restrictions.like("AssetCategoryName", categoryName).ignoreCase()).addOrder(Order.asc("AssetCategoryName")).list();
			} else {
				//searchCategoryList = getHibernateTemplate()	.find("from jkt.hms.masters.business.MasCategory imc where imc.CategoryCode like '"	+ categoryCode + "%' order by imc.CategoryCode");
				
				searchCategoryList =session.createCriteria(MasAssetCategory.class).add(Restrictions.like("AssetCategoryCode", categoryCode).ignoreCase()).addOrder(Order.asc("AssetCategoryCode")).list();
				
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		categoryFieldsMap.put("searchCategoryList", searchCategoryList);
		return categoryFieldsMap;
	}


	public boolean deleteCategory(int categoryId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		System.out.println(categoryId);
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		MasAssetCategory masCategory = (MasAssetCategory) getHibernateTemplate().get(
				MasAssetCategory.class, categoryId);
		
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		System.out.println(generalMap.get("flag"));
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masCategory.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masCategory.setStatus("y");
				dataDeleted = false;
			}
		}

		Users users = new Users();
		users.setId(userId);
		masCategory.setLastChgBy(users);
		
		
		masCategory.setLastChgDate(currentDate);
		masCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCategory);
		return dataDeleted;
	}

	@Override
	public Map<String, Object> searchSubCategory(String subCategoryCode,
			String subCategoryName) {/*
		List<MasSubCategory> searchSubCategoryList = new ArrayList<MasSubCategory>();
		Map<String, Object> categoryFieldsMap = new HashMap<String, Object>();
		Session session =(Session)getSession();
		try {
			if ((subCategoryName != null) || (subCategoryCode == null)) {
				//searchCategoryList = getHibernateTemplate().find("from jkt.hms.masters.business.MasCategory imc where imc.CategoryName like '"+ categoryName + "%' order by imc.CategoryName");
				searchSubCategoryList =session.createCriteria(MasSubCategory.class).add(Restrictions.like("SubCategoryName", subCategoryName).ignoreCase()).addOrder(Order.asc("SubCategoryName")).list();
			} else {
				//searchCategoryList = getHibernateTemplate()	.find("from jkt.hms.masters.business.MasCategory imc where imc.CategoryCode like '"	+ categoryCode + "%' order by imc.CategoryCode");
				
				searchSubCategoryList =session.createCriteria(MasSubCategory.class).add(Restrictions.like("SubCategoryCode", subCategoryCode).ignoreCase()).addOrder(Order.asc("SubCategoryCode")).list();
				
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		categoryFieldsMap.put("searchSubCategoryList", searchSubCategoryList);
		return categoryFieldsMap;
	*/
		return null;	
	}

	@Override
	public boolean editSubCategoryToDatabase(Map<String, Object> generalMap) {/*
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String subCategoryName = "";
		@SuppressWarnings("unused")
		String subCategoryCode = "";
		int subCategoryId = 0;
		int userId = 0;
		subCategoryId = (Integer) generalMap.get("id");
		subCategoryCode = (String) generalMap.get("subCategoryCode");
		subCategoryName = (String) generalMap.get("name");
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasSubCategory masSubCategory = (MasSubCategory) getHibernateTemplate().get(
				MasSubCategory.class, subCategoryId);

		masSubCategory.setId(subCategoryId);
		masSubCategory.setSubCategoryName(subCategoryName);
		Users users = new Users();
		users.setId(userId);
		masSubCategory.setLastChgBy(users);
		masSubCategory.setLastChgDate(currentDate);
		masSubCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masSubCategory);
		dataUpdated = true;
		return dataUpdated;*/
		return true;
	}

	@Override
	public boolean deleteSubCategory(int subCategoryId,
			Map<String, Object> generalMap) {/*
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasSubCategory masSubCategory = new MasSubCategory();
		masSubCategory = (MasSubCategory) getHibernateTemplate().get(
				MasSubCategory.class, subCategoryId);
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masSubCategory.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masSubCategory.setStatus("y");
				dataDeleted = false;
			}
		}

		Users users = new Users();
		users.setId(userId);
		masSubCategory.setLastChgBy(users);
		
		
		masSubCategory.setLastChgDate(currentDate);
		masSubCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCategory);
		return dataDeleted;
	*/
		return true;	
	}

	@Override
	public Map<String, Object> submitEquipmentDetails(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map=new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		List<MmMasRequestStatus> mmMasRequestStatus=new ArrayList<MmMasRequestStatus>();
		HesEquipmentMaster hesEquipmentMaster=null;
		MasDepartment masDepartment=null;
		MasManufacturer masManufacturer=null;
		MasStoreItem storeItem=null;
		/*StoreGrnT storeGrnT=null;*/
		MasHospital hospital=null;
		Users user=null;
		String status="Yes";
		String message="";
		int itemCount=box.getInt("itemCount");
		Transaction tx=null;
		if(itemCount>0){
		try{
				tx=getSession().beginTransaction();
			for(int i=1;i<=itemCount;i++){
				hesEquipmentMaster=new HesEquipmentMaster();
				if(box.getString("department"+i)!=null && box.getString("department"+i)!=""){
					masDepartment=new MasDepartment();
					masDepartment.setId(box.getInt("department"+i));
					hesEquipmentMaster.setDepartment(masDepartment);
				}
				if(box.getString("modelNumber"+i)!=null && box.getString("modelNumber"+i)!=""){
					hesEquipmentMaster.setModelName(box.getString("modelNumber"+i));
				}
				if(box.getString("serialNumber"+i)!=null && box.getString("serialNumber"+i)!=""){
					hesEquipmentMaster.setSerialNo(box.getString("serialNumber"+i));
				}
				if(box.getString("make"+i)!=null && box.getString("make"+i)!=""){
					hesEquipmentMaster.setMake(box.getString("make"+i));
				}
				if(box.getString("manufacture"+i)!=null && box.getString("manufacture"+i)!=""){
					masManufacturer=new MasManufacturer();
					masManufacturer.setId(box.getInt("manufacture"+i));
					hesEquipmentMaster.setManufacturer(masManufacturer);;
				}
				if(box.getString("technicalSpecification"+i)!=null && box.getString("technicalSpecification"+i)!=""){
					hesEquipmentMaster.setTechnicalSpecifications(box.getString("technicalSpecification"+i));
				}
				if(box.getString("itemId")!=null && box.getString("itemId")!=""){
					storeItem=new MasStoreItem();
					storeItem.setId(box.getInt("itemId"));
					hesEquipmentMaster.setItem(storeItem);
				}
				/*if(box.getString("storeGrnId")!=null && box.getString("storeGrnId")!=""){
					storeGrnT=(StoreGrnT)hbt.get(StoreGrnT.class, box.getInt("storeGrnId"));
//					storeGrnT.setId(box.getInt("grnId"));
					hesEquipmentMaster.setGrnT(storeGrnT);
					if(storeGrnT.getEqpDetailQty()!=null)
					{
						storeGrnT.setEqpDetailQty(storeGrnT.getEqpDetailQty().add(new BigDecimal(1)));
					}
					else
					{
						storeGrnT.setEqpDetailQty(new BigDecimal(1));
					}
				}*/
				if(box.getInt("batchStockId")!=0 ){
					StoreItemBatchStock storeItemBatchStock =(StoreItemBatchStock)hbt.load(StoreItemBatchStock.class, box.getInt("batchStockId"));
					storeItemBatchStock.setEquipmentDetailStatus("y");
					hbt.update(storeItemBatchStock);
				}
				
				if(dataMap.get("hospitalId")!=null && dataMap.get("hospitalId")!=""){
					hospital=new MasHospital();
					hospital.setId((Integer)dataMap.get("hospitalId"));
					hesEquipmentMaster.setHospital(hospital);
				}
				if(dataMap.get("userId")!=null && dataMap.get("userId")!=""){
					user=new Users();
					user.setId((Integer)dataMap.get("userId"));
					hesEquipmentMaster.setLastChgBy(user);;
				}
				if(box.getString("currentDate")!=null && box.getString("currentDate")!=""){
					hesEquipmentMaster.setLastChgDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("currentDate")));
				}
				if(box.getString("currentTime")!=null && box.getString("currentTime")!=""){
					hesEquipmentMaster.setLastChgTime(box.getString("currentTime"));
				}
				if(box.getString("equipmentDetailDate")!=null && box.getString("equipmentDetailDate")!=""){
					try{
						hesEquipmentMaster.setEquipmentDetailDate(sdf.parse(box.getString("equipmentDetailDate")));
					}catch(Exception e){e.printStackTrace();}
				}
				if(box.getString("equipmentStatus"+i)!=null && box.getString("equipmentStatus"+i)!=""){
					if(box.getString("installationDate"+i)!=null && box.getString("installationDate"+i)!=""){
						try{
							hesEquipmentMaster.setDateOfInstallation(sdf.parse(box.getString("installationDate"+i)));
						}catch(Exception e){e.printStackTrace();}
					}
				}
				if(box.getString("userStatus"+i)!=null && box.getString("userStatus"+i)!=""){
					mmMasRequestStatus=getSession().createCriteria(MmMasRequestStatus.class).add(Restrictions.eq("StatusCode", "ACPT")).list();
					MmMasRequestStatus masRequestStatus=new MmMasRequestStatus();
					if(mmMasRequestStatus.size()>0){
						masRequestStatus.setId(mmMasRequestStatus.get(0).getId());
						hesEquipmentMaster.setEquipStatus(masRequestStatus);
					}
				}else{
					mmMasRequestStatus=getSession().createCriteria(MmMasRequestStatus.class).add(Restrictions.eq("StatusCode", "RJT")).list();
					MmMasRequestStatus masRequestStatus=new MmMasRequestStatus();
					if(mmMasRequestStatus.size()>0){
						masRequestStatus.setId(mmMasRequestStatus.get(0).getId());
						hesEquipmentMaster.setEquipStatus(masRequestStatus);
						if(box.getString("reson"+i)!=null && box.getString("reson"+i)!=""){
							hesEquipmentMaster.setRejectionDetail(box.getString("reson"+i));
						}
					}
				}
				if(box.getString("assetId"+i)!=null && box.getString("assetId"+i)!=""){
					PrqAssetDetails assetDetails=new PrqAssetDetails();
					assetDetails.setId(box.getInt("assetId"+i));
					hesEquipmentMaster.setAsset(assetDetails);
				}
//				---Equipment Code------
				hesEquipmentMaster.setStatus("y");
				hesEquipmentMaster.setReplacementValue(new BigDecimal(0.0));
				int equipmentId=(Integer)hbt.save(hesEquipmentMaster);
				hbt.flush();
			
				String entryNo="EQNO"+equipmentId+"/"+HMSUtil.changeDateToddMMyyyy(new Date());
//				---End-------
				hesEquipmentMaster.setId(equipmentId);
				hesEquipmentMaster.setEntryNo(entryNo);
				if(box.getString("warranty"+i)!=null && box.getString("warranty"+i)!=""){
					status="Yes";
					hesEquipmentMaster.setWarrentyStatus(status);
					String[] warrantyType=box.getString("warranty"+i).trim().split(",");
					if("1".equalsIgnoreCase(warrantyType[1])){
						hesEquipmentMaster.setWarrantyType("warranty");
					}else if("2".equalsIgnoreCase(warrantyType[1])){
						hesEquipmentMaster.setWarrantyType("camc");
					}else if("3".equalsIgnoreCase(warrantyType[1])){
						hesEquipmentMaster.setWarrantyType("cmc");
					}else if("4".equalsIgnoreCase(warrantyType[1])){
						hesEquipmentMaster.setWarrantyType("amc");
					}
//				-------	warranty details Start----------
					if(box.getString("warrantyStartDate"+i)!=null && box.getString("warrantyStartDate"+i)!=""){
						try{
							hesEquipmentMaster.setWarrentyStartDate(sdf.parse(box.getString("warrantyStartDate"+i)));
						}catch(Exception e){e.printStackTrace();}
						}
					if(box.getString("warrantyStartDate"+i)!=null && box.getString("warrantyStartDate"+i)!=""){
						try{
							hesEquipmentMaster.setWarrentyEndDate(sdf.parse(box.getString("warrantyEndDate"+i)));
						}catch(Exception e){e.printStackTrace();}
						}
					if(box.getString("warrantyDetails"+i)!=null && box.getString("warrantyDetails"+i)!=""){
						hesEquipmentMaster.setWarrantyDetails(box.getString("warrantyDetails"+i));
						}
//				--- Preventive Start-------	
					String preventiveStaus="No";
						if(box.getString("preventive"+i)!=null && box.getString("preventive"+i)!=""){
							preventiveStaus="Yes";
						    hesEquipmentMaster.setPreventiveStatus(preventiveStaus);
						if(box.getString("totalPreventive"+i)!=null && box.getString("totalPreventive"+i)!=""){
							hesEquipmentMaster.setPreventiveCycle(box.getInt("totalPreventive"+i));
							hesEquipmentMaster.setPreventiveCompletedCycle(0);
						}
//				------ Check List Start ------
						String checkListStatus="No";
						if(box.getString("checkList"+i)!=null && box.getString("checkList"+i)!=""){
							checkListStatus="Yes";
							hesEquipmentMaster.setChecklistStatus(checkListStatus);
							if(box.getString("checkListName"+i)!=null && box.getString("checkListName"+i)!=""){
							String[] checkListName=box.getString("checkListName"+i).split("@#");
								if(checkListName.length>0){
									for(int ch=0;ch<checkListName.length;ch++){
										MmPreventiveCheckList mmPreventiveCheckList=new MmPreventiveCheckList();
										mmPreventiveCheckList.setCheckListName(checkListName[ch]);
										if(hesEquipmentMaster.getId()!=null){
										mmPreventiveCheckList.setEquipment(hesEquipmentMaster);
										}
										hbt.save(mmPreventiveCheckList);
										hbt.flush();
										hbt.clear();
									}
								}
							}
						}else{
							hesEquipmentMaster.setChecklistStatus(checkListStatus);
						}
//						------ Check List End ------
						
					}else{
						hesEquipmentMaster.setPreventiveStatus(preventiveStaus);
					}
//						--- Preventive End-------	
					
				}else{
					hesEquipmentMaster.setWarrentyStatus(status);
				}
//				-------	warranty details End----------
//				-------	Accessory details Start----------
				if(box.getString("accessory"+i)!=null && box.getString("accessory"+i)!=""){
					int accessoryCount=box.getInt("accessoryCount"+i);
					if(accessoryCount>0){
						for(int a=1;a<=accessoryCount;a++){
							HesEquipmentAssessories hesEquipmentAssessories=new HesEquipmentAssessories();
							MasStoreItem masStoreItem=new MasStoreItem();
							if(hesEquipmentMaster.getId()!=null){
								hesEquipmentAssessories.setEquipment(hesEquipmentMaster);
								}
							if(box.getString("accessoryItemId"+i+a)!=null && box.getString("accessoryItemId"+i+a)!=""){
								masStoreItem.setId(box.getInt("accessoryItemId"+i+a));
								hesEquipmentAssessories.setItem(masStoreItem);
							}
							if(box.getString("accessoryItemName"+i+a)!=null && box.getString("accessoryItemName"+i+a)!=""){
								hesEquipmentAssessories.setAssessoryName(box.getString("accessoryItemName"+i+a));
							}
							if(box.getString("serialNo"+i+a)!=null && box.getString("serialNo"+i+a)!=""){
								hesEquipmentAssessories.setSerialNo(box.getString("serialNo"+i+a));
							}
							if(box.getString("modelNo"+i+a)!=null && box.getString("modelNo"+i+a)!=""){
								hesEquipmentAssessories.setModelNo(box.getString("modelNo"+i+a));
							}
							if(box.getString("warrantyStartDate"+i+a)!=null && box.getString("warrantyStartDate"+i+a)!=""){
								try{
									hesEquipmentAssessories.setWarrantyStartDate(sdf.parse(box.getString("warrantyStartDate"+i+a)));
								}catch(Exception e){e.printStackTrace();}
							}
							if(box.getString("warrantyEndDate"+i+a)!=null && box.getString("warrantyEndDate"+i+a)!=""){
								try{
									hesEquipmentAssessories.setWarrantyEndDate(sdf.parse(box.getString("warrantyEndDate"+i+a)));
								}catch(Exception e){e.printStackTrace();}
							}
							if(box.getString("details"+i+a)!=null && box.getString("details"+i+a)!=""){
								hesEquipmentAssessories.setRemarks(box.getString("details"+i+a));
							}
							if(dataMap.get("hospitalId")!=null && dataMap.get("hospitalId")!=""){
								hospital=new MasHospital();
								hospital.setId((Integer)dataMap.get("hospitalId"));
								hesEquipmentAssessories.setHospital(hospital);
							}
							if(dataMap.get("userId")!=null && dataMap.get("userId")!=""){
								user=new Users();
								user.setId((Integer)dataMap.get("userId"));
								hesEquipmentAssessories.setLastChgBy(user);;
							}
							if(box.getString("currentDate")!=null && box.getString("currentDate")!=""){
								hesEquipmentAssessories.setLastChgDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("currentDate")));
							}
							if(box.getString("currentTime")!=null && box.getString("currentTime")!=""){
								hesEquipmentAssessories.setLastChgTime(box.getString("currentTime"));
							}
							if(box.getString("department"+i)!=null && box.getString("department"+i)!=""){
								masDepartment=new MasDepartment();
								masDepartment.setId(box.getInt("department"+i));
								hesEquipmentAssessories.setDepartment(masDepartment);
							}
							hesEquipmentAssessories.setStatus("y");
							hbt.save(hesEquipmentAssessories);
							hbt.flush();
							hbt.clear();
						}
					}
				}
//				-------	Accessory details End----------
				hbt.update(hesEquipmentMaster);
				hbt.flush();
				hbt.clear();
			}
			tx.commit();
			message="<span style='color: green'>Successfully Save.</span>";
		}catch(Exception e){
			e.printStackTrace();
			if(tx==null){
				tx.rollback();
				message="<span style='color: green'>Try Again...</span>";
			}
		}
		}
		map.put("message", message);
		return map;
	}
	
	
	@Override
	public Map<String, Object> addImmuableAssets(
			MultipartFormDataRequest mrequest, Map<String, Object> dataMap)  {
		boolean saveFlag = false;
		MasHospital masHospital = new MasHospital();
		Session session = (Session) getSession();
		int hospitalId = Integer.parseInt(dataMap.get(
				RequestConstants.HOSPITAL_ID).toString());
		String survay = mrequest.getParameter("surveyNo");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		List<String> values = new ArrayList<String>();
		String fileSeparator = System.getProperty("file.separator");
		String fileName = null;
		String fileExtension = null;
		Users users = (Users) dataMap.get(RequestConstants.USERS);
		String userHome = dataMap.get("userHome").toString();
		String uploadURL = userHome.substring(0,
				userHome.lastIndexOf(fileSeparator))
				+ fileSeparator
				+ "HMSDocumentFolder"
				+ fileSeparator
				+ "upload" + fileSeparator;

		HMSUtil.createFolderFroDocument("assets", uploadURL);
		List fileUploadedList = null;
		Hashtable files = mrequest.getFiles();
		UploadFile file = (UploadFile) files
				.get(RequestConstants.UPLOAD_FILENAME);
		String fileName1 = null;
		if (file != null && file.getFileName() != null) {

			fileName1 = file.getFileName();

			StringTokenizer strToken = new StringTokenizer(fileName1, ".");

			fileName = strToken.nextToken();
			fileExtension = strToken.nextToken();

			String whiteList = "*." + fileExtension;

			fileUploadedList = HMSUtil.uploadFile(mrequest, uploadURL
					+ "assets" + fileSeparator, whiteList, fileName);

		}
		masHospital = (MasHospital) session.load(MasHospital.class, hospitalId);
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			PrqAssetDetails prqAssetDetails = new PrqAssetDetails();
			if (mrequest.getParameter("commonId") != null
					&& !"".equalsIgnoreCase(mrequest
							.getParameter("commonId"))) {

				prqAssetDetails=(PrqAssetDetails)hbt.load(PrqAssetDetails.class, Integer.parseInt(mrequest.getParameter("commonId")));
			}
			
			if (mrequest.getParameter("addressDescription") != null
					&& !"".equalsIgnoreCase(mrequest
							.getParameter("addressDescription"))) {

				prqAssetDetails.setAssetDesc(mrequest
						.getParameter("addressDescription"));
			}
			if (mrequest.getParameter("dateOfRegistration") != null
					&& !"".equalsIgnoreCase(mrequest
							.getParameter("dateOfRegistration"))) {
				prqAssetDetails.setRegistrationDate(HMSUtil
						.convertStringTypeDateToDateType(mrequest
								.getParameter("dateOfRegistration")));
			}
			if (mrequest.getParameter("assetCode") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("assetCode"))) {
				prqAssetDetails.setAssetCode(mrequest
						.getParameter("assetCode"));

			}
			if (mrequest.getParameter("address") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("address"))) {
				prqAssetDetails.setAddress(mrequest.getParameter("address"));
			}
			if (mrequest.getParameter("registrationAndOtherCharges") != null
					&& !"".equalsIgnoreCase(mrequest
							.getParameter("registrationAndOtherCharges"))) {
				BigDecimal money = new BigDecimal(
						mrequest.getParameter("registrationAndOtherCharges"));
				prqAssetDetails.setRegistrationOtherCharges(money);
			}
			if (mrequest.getParameter("remarks") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("remarks"))) {
				prqAssetDetails.setRemarks(mrequest.getParameter("remarks"));
			}
			if (mrequest.getParameter("surveyNo") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("surveyNo"))) {
				prqAssetDetails.setPlotSurveyNo(mrequest
						.getParameter("surveyNo"));

			}
			if (mrequest.getParameter("uomLandExtentId") != null
					&& !"".equalsIgnoreCase(mrequest
							.getParameter("uomLandExtentId"))) {
				MasStoreUnit uom = new MasStoreUnit(Integer.parseInt(mrequest
						.getParameter("uomLandExtentId")));
				prqAssetDetails.setUom(uom);

			}
			if (mrequest.getParameter("leasePeriodFreehold") != null
					&& !"".equalsIgnoreCase(mrequest
							.getParameter("leasePeriodFreehold"))) {
				prqAssetDetails.setLeaseholdFreehold(mrequest
						.getParameter("leasePeriodFreehold"));

			}
			if (mrequest.getParameter("district") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("district"))) {
				MasDistrict district = new MasDistrict(
						Integer.parseInt(mrequest.getParameter("district")));
				prqAssetDetails.setDistrict(district);
			}
			if (mrequest.getParameter("dateOfPossession") != null
					&& !"".equalsIgnoreCase(mrequest
							.getParameter("dateOfPossession"))) {
				prqAssetDetails.setPossessionDate(HMSUtil
						.convertStringTypeDateToDateType(mrequest
								.getParameter("dateOfPossession")));

			}
			if (mrequest.getParameter("totalCost") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("totalCost"))) {
				BigDecimal money = new BigDecimal(
						mrequest.getParameter("totalCost"));
				prqAssetDetails.setTotalCost(money);
			}
			if (mrequest.getParameter("assetCategory") != null
					&& !"".equalsIgnoreCase(mrequest
							.getParameter("assetCategory"))) {
				MasItemCategory assetCategory = new MasItemCategory(
						Integer.parseInt(mrequest.getParameter("assetCategory")));
				prqAssetDetails.setAssetCategory(assetCategory);

			}
			if (mrequest.getParameter("assetSection") != null
					&& !"".equalsIgnoreCase(mrequest
							.getParameter("assetSection"))) {
				MasStoreSection storeSection = new MasStoreSection(
						Integer.parseInt(mrequest.getParameter("assetSection")));
				prqAssetDetails.setItemSection(storeSection);

			}
			if (mrequest.getParameter("depriciation") != null
					&& !"".equalsIgnoreCase(mrequest
							.getParameter("depriciation"))) {
				prqAssetDetails.setDeprecation(Long.parseLong(mrequest.getParameter("depriciation")));

			}
			if (mrequest.getParameter("itemId") != null
					&& !"".equalsIgnoreCase(mrequest
							.getParameter("itemId"))) {
				MasStoreItem masStoreItem = new MasStoreItem(
						Integer.parseInt(mrequest.getParameter("itemId")));
				prqAssetDetails.setItem(masStoreItem);

			}
			if (mrequest.getParameter("cost") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("cost"))) {
				BigDecimal money = new BigDecimal(mrequest.getParameter("cost"));
				prqAssetDetails.setEstCost(money);

			}
			if (mrequest.getParameter("assetsName") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("assetsName"))) {
				prqAssetDetails.setAssetName(mrequest
						.getParameter("assetsName"));

			}
			if (mrequest.getParameter("aquireFrom") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("aquireFrom"))) {
				prqAssetDetails.setAcquireFrom(mrequest
						.getParameter("aquireFrom"));
			}
			if (mrequest.getParameter("presentBookValue") != null
					&& !"".equalsIgnoreCase(mrequest
							.getParameter("presentBookValue"))) {
				BigDecimal money = new BigDecimal(
						mrequest.getParameter("presentBookValue"));
				prqAssetDetails.setBookValue(money);
			}
			if (mrequest.getParameter("landMeasurementw") != null
					&& !"".equalsIgnoreCase(mrequest
							.getParameter("landMeasurementw"))) {
				BigDecimal width = new BigDecimal(
						mrequest.getParameter("landMeasurementw"));
				prqAssetDetails.setLandMeasurementW(width);

			}
			if (mrequest.getParameter("landMeasurementh") != null
					&& !"".equalsIgnoreCase(mrequest
							.getParameter("landMeasurementh"))) {
				BigDecimal height = new BigDecimal(
						mrequest.getParameter("landMeasurementh"));
				prqAssetDetails.setLandMeasurementH(height);

			}
			if (mrequest.getParameter("leasePeriod") != null
					&& !"".equalsIgnoreCase(mrequest
							.getParameter("leasePeriod"))) {
				prqAssetDetails.setLeasePeriod(mrequest
						.getParameter("leasePeriod"));

			}
			if (mrequest.getParameter("completionDate") != null
					&& !"".equalsIgnoreCase(mrequest
							.getParameter("completionDate"))) {
				prqAssetDetails.setLeaseCompletionDate(HMSUtil
						.convertStringTypeDateToDateType(mrequest
								.getParameter("completionDate")));

			}
			prqAssetDetails.setAuctionStatus(NOT_FOR_AUCTION);
			prqAssetDetails.setAssetType("immovable");
			prqAssetDetails.setStatus("y");
			prqAssetDetails.setLastChgBy(users);
			prqAssetDetails.setLastChgDate(HMSUtil
					.getCurrentDateAndTimeObject());
			prqAssetDetails.setInstitutionType(masHospital.getHospitalType());
			prqAssetDetails.setLastChgTime(time);
			prqAssetDetails.setInstitution(masHospital);
			hbt.save(prqAssetDetails);

			/*
			 * 
			 * 
			 * 
			 * if (mrequest.getParameter("addressDescription") != null &&
			 * !"".equalsIgnoreCase(mrequest
			 * .getParameter("addressDescription"))) {
			 * 
			 * } if (mrequest.getParameter("addressDescription") != null &&
			 * !"".equalsIgnoreCase(mrequest
			 * .getParameter("addressDescription"))) {
			 * 
			 * } if (mrequest.getParameter("addressDescription") != null &&
			 * !"".equalsIgnoreCase(mrequest
			 * .getParameter("addressDescription"))) {
			 * 
			 * } if (mrequest.getParameter("addressDescription") != null &&
			 * !"".equalsIgnoreCase(mrequest
			 * .getParameter("addressDescription"))) {
			 * 
			 * }
			 */
			if (fileName1 != null) {
				UploadDocuments uploadDocuments = new UploadDocuments();
				File file1 = null;
				file1 = new File(uploadURL + fileSeparator + "assets"
						+ fileSeparator + fileName1);

				File f = new File(uploadURL);
				try {
					if (f.exists()) {
						FileInputStream is = new FileInputStream(file1);
						long length = file1.length();

						if (length > Integer.MAX_VALUE) {

						}

						byte[] bytes = new byte[(int) length];
						int offset = 0;
						int numRead = 0;
						while (offset < bytes.length
								&& (numRead = is.read(bytes, offset,
										bytes.length - offset)) >= 0) {
							offset += numRead;
						}

						if (offset < bytes.length) {
							throw new IOException(
									"Could not completely read file "
											+ file1.getName());
						}

						uploadDocuments.setPatientDocument(bytes);
						is.close();
					} else {
						f.mkdir();
						FileInputStream is = new FileInputStream(file1);
						long length = file1.length();

						if (length > Integer.MAX_VALUE) {

						}

						byte[] bytes = new byte[(int) length];
						int offset = 0;
						int numRead = 0;
						while (offset < bytes.length
								&& (numRead = is.read(bytes, offset,
										bytes.length - offset)) >= 0) {
							offset += numRead;
						}

						if (offset < bytes.length) {
							throw new IOException(
									"Could not completely read file "
											+ file1.getName());
						}
						is.close();

						uploadDocuments.setPatientDocument(bytes);

					}
					uploadDocuments.setAsset(prqAssetDetails);
					uploadDocuments.setLastChgBy(users);
					uploadDocuments.setLastChgDate(HMSUtil
							.getCurrentDateAndTimeObject());
					uploadDocuments.setLastChgTime(time);
					uploadDocuments.setHospital(masHospital);
					hbt.save(uploadDocuments);
					hbt.flush();
					hbt.clear();
					saveFlag = true;

				} catch (Exception e) {
					e.printStackTrace();
					if (transaction != null) {
						transaction.rollback();
					}

				}
			}

			transaction.commit();
			saveFlag = true;
		} catch (Exception e) {

			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();

		}
		dataMap.put("message", saveFlag);
		return dataMap;

	}
	@Override
	public Map<String, Object> showMarkForAuctionJsp(Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MasItemCategory> categoryList = new ArrayList<MasItemCategory>();
		List<PrqAssetDetails> assetsList = new ArrayList<PrqAssetDetails>();
		Session session = (Session)getSession();
		categoryList = session.createCriteria(MasItemCategory.class).createAlias("Section", "section")
							.createAlias("section.ItemType", "itemType").createAlias("itemType.Group", "group").add(Restrictions.eq("group.GroupName", "Assets")).list();
		assetsList = session.createCriteria(PrqAssetDetails.class).add(Restrictions.eq("AuctionStatus", NOT_FOR_AUCTION))
						.add(Restrictions.eq("Institution.Id", box.getInt("hospitalId"))).list();
		map.put("categoryList", categoryList);
		map.put("assetsList", assetsList);
		return map;
	}

	@Override
	public Map<String, Object> searchAssetsMarkForAuction(Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<PrqAssetDetails> assetsDetailList = new ArrayList<PrqAssetDetails>();
		List<MasItemCategory> categoryList = new ArrayList<MasItemCategory>();
		List<PrqAssetDetails> assetsList = new ArrayList<PrqAssetDetails>();
		Session session = (Session)getSession();
		if(box.getString("flag").equals("all")){
			Criteria criteria=session.createCriteria(PrqAssetDetails.class).add(Restrictions.eq("AuctionStatus", NOT_FOR_AUCTION))
					.add(Restrictions.eq("Institution.Id", box.getInt("hospitalId")));
			assetsDetailList = criteria.list();
		}else{
			Criteria criteria=session.createCriteria(PrqAssetDetails.class).add(Restrictions.eq("AuctionStatus", NOT_FOR_AUCTION))
					.add(Restrictions.eq("Institution.Id", box.getInt("hospitalId")));
			if(box.getInt("itemCategoryId") != 0){
				criteria = criteria.createAlias("AssetCategory", "itemCategory").add(Restrictions.eq("itemCategory.Id", box.getInt("itemCategoryId") ));
			}
			
			if(box.getString("assetCode") != null && !box.getString("assetCode").equals("")){
				criteria = criteria.add(Restrictions.eq("AssetCode",box.getString("assetCode")));
			}
			
			if(box.getString("assetName") != null && !box.getString("assetName").equals("")){
				criteria = criteria.add(Restrictions.eq("AssetName",box.getString("assetName")));
			}
			assetsDetailList = criteria.list();
		}
		categoryList = session.createCriteria(MasItemCategory.class).createAlias("Section", "section")
				.createAlias("section.ItemType", "itemType").createAlias("itemType.Group", "group").add(Restrictions.eq("group.GroupName", "Assets")).list();
		assetsList = session.createCriteria(PrqAssetDetails.class)
				//.add(Restrictions.eq("AuctionStatus", NOT_FOR_AUCTION))
				.list();

		map.put("assetsDetailList", assetsDetailList);
		map.put("categoryList", categoryList);
		map.put("assetsList", assetsList);
		return map;
	}

	@Override
	public Map<String, Object> submitMarkForAuction(Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		int count = 0;
		
		boolean flag = false;
		if(box.getInt("count") !=0){
			count =(Integer)box.getInt("count");
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			for(int i=1;i<=count;i++){
				if(box.getString("markForAuction"+i)!=null && !box.getString("markForAuction"+i).equals("")){
					int assetDetailId = box.getInt("assetDetailId"+i);
					PrqAssetDetails prqAssetDetails =(PrqAssetDetails)hbt.load(PrqAssetDetails.class, assetDetailId);
					prqAssetDetails.setAuctionStatus(MARK_FOR_AUCTION);
					prqAssetDetails.setAuctionDate(new Date());
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(box.getInt("employeeId"));
					prqAssetDetails.setRequestedBy(masEmployee);
					hbt.update(prqAssetDetails);
				}
			}
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}

	@Override
	public Map<String, Object> showPendingListForAuctionJsp(Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MasItemCategory> categoryList = new ArrayList<MasItemCategory>();
		List<PrqAssetDetails> assetsList = new ArrayList<PrqAssetDetails>();
		List<PrqAssetDetails> assetsDetailList = new ArrayList<PrqAssetDetails>();
		List<MmServiceRequest>  mmServiceRequests=new ArrayList<MmServiceRequest>();
		Session session = (Session)getSession();
		categoryList = session.createCriteria(MasItemCategory.class).createAlias("Section", "section")
							.createAlias("section.ItemType", "itemType").createAlias("itemType.Group", "group").add(Restrictions.eq("group.GroupName", "Assets")).list();
		assetsList = session.createCriteria(PrqAssetDetails.class).add(Restrictions.eq("Institution.Id", box.getInt("hospitalId")))
				//.add(Restrictions.eq("AuctionStatus", MARK_FOR_AUCTION))
				.list();
		Criteria criteria=session.createCriteria(PrqAssetDetails.class).add(Restrictions.eq("AuctionStatus", MARK_FOR_AUCTION))
				.add(Restrictions.eq("Institution.Id", box.getInt("hospitalId")));
		assetsDetailList = criteria.list();
		mmServiceRequests=session.createCriteria(MmServiceRequest.class).createAlias("RequestStatus", "rs")
				           .add(Restrictions.eq("rs.StatusCode", "AUC").ignoreCase()).list();
		map.put("mmServiceRequests", mmServiceRequests);
		map.put("categoryList", categoryList);
		map.put("assetsList", assetsList);
		map.put("assetsDetailList", assetsDetailList);
		return map;
	}

	@Override
	public Map<String, Object> searchPendingListForAuction(Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MasItemCategory> categoryList = new ArrayList<MasItemCategory>();
		List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
		List<PrqAssetDetails> assetsList = new ArrayList<PrqAssetDetails>();
		List<PrqAssetDetails> assetsDetailList = new ArrayList<PrqAssetDetails>();
		Session session = (Session)getSession();
		categoryList = session.createCriteria(MasItemCategory.class).createAlias("Section", "section")
							.createAlias("section.ItemType", "itemType").createAlias("itemType.Group", "group").add(Restrictions.eq("group.GroupName", "Assets")).list();
		assetsList = session.createCriteria(PrqAssetDetails.class).add(Restrictions.eq("Institution.Id", box.getInt("hospitalId")))
				//.add(Restrictions.eq("AuctionStatus", MARK_FOR_AUCTION))
				.list();
		if(box.getString("flag").equals("all")){
			Criteria criteria=session.createCriteria(PrqAssetDetails.class).add(Restrictions.eq("AuctionStatus", MARK_FOR_AUCTION))
					.add(Restrictions.eq("Institution.Id", box.getInt("hospitalId")));
			assetsDetailList = criteria.list();
			Criteria criteria2=session.createCriteria(MmServiceRequest.class).createAlias("RequestStatus", "rs")
			           .add(Restrictions.eq("rs.StatusCode", "AUC").ignoreCase());
			mmServiceRequests=criteria2.list();
		}else{
			Criteria criteria2=session.createCriteria(MmServiceRequest.class).createAlias("RequestStatus", "rs")
			           .add(Restrictions.eq("rs.StatusCode", "AUC").ignoreCase());
			Criteria criteria=session.createCriteria(PrqAssetDetails.class).add(Restrictions.eq("AuctionStatus", MARK_FOR_AUCTION))
					.add(Restrictions.eq("Institution.Id", box.getInt("hospitalId")));
			if(box.getInt("itemCategoryId") != 0){
				criteria = criteria.createAlias("AssetCategory", "itemCategory").add(Restrictions.eq("itemCategory.Id", box.getInt("itemCategoryId") ));
			}
			
			if(box.getString("assetCode") != null && !box.getString("assetCode").equals("")){
				criteria = criteria.add(Restrictions.eq("AssetCode",box.getString("assetCode")));
			}
			
			if(box.getString("assetName") != null && !box.getString("assetName").equals("")){
				criteria = criteria.add(Restrictions.eq("AssetName",box.getString("assetName")));
			}
			if(box.getString("fromDate")!=null && box.getString("toDate")!=null){
				/*try{
					fromDate=sdf.parse((String)details.get("fromDate"));
					toDate=sdf.parse((String)details.get("toDate"));
				}catch(Exception e){e.printStackTrace();}*/
				criteria=criteria.add(Restrictions.between("AuctionDate", HMSUtil.convertStringTypeDateToDateType(box.getString("fromDate")), HMSUtil.convertStringTypeDateToDateType(box.getString("toDate"))));
				criteria2=criteria2.add(Restrictions.between("RequestDate", HMSUtil.convertStringTypeDateToDateType(box.getString("fromDate")), HMSUtil.convertStringTypeDateToDateType(box.getString("toDate"))));
			}
			assetsDetailList = criteria.list();
			mmServiceRequests=criteria2.list();
	}
		map.put("mmServiceRequests", mmServiceRequests);
		map.put("categoryList", categoryList);
		map.put("assetsList", assetsList);
		map.put("assetsDetailList", assetsDetailList);
		return map;
	}

	@Override
	public Map<String, Object> showAuctionApprovalJsp(Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<PrqAssetDetails> assetsDetailList = new ArrayList<PrqAssetDetails>();
		List<MmServiceRequest> mmRequests=new ArrayList<MmServiceRequest>();
		Session session = (Session)getSession();
		mmRequests=session.createCriteria(MmServiceRequest.class).add(Restrictions.idEq(box.getInt("requestId"))).list();
		assetsDetailList = session.createCriteria(PrqAssetDetails.class).add(Restrictions.idEq(box.getInt("assetDetailId"))).list();
		System.out.println(box.getInt("requestId")+"list"+mmRequests.size());
		map.put("assetsDetailList", assetsDetailList);
		map.put("mmRequests", mmRequests);
		return map;
	}

	@Override
	public Map<String, Object> submitAuctionApproval(Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		int count = 0;
		boolean flag = false;
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			System.out.println("fn"+box.getInt("equipmentId"));
				if(box.getString("status")!=null && !box.getString("status").equals("")){
					int assetDetailId = 0;
					int equipmentId=0;
					if(box.getInt("assetDetailId")!=0)
					{
					PrqAssetDetails prqAssetDetails =(PrqAssetDetails)hbt.load(PrqAssetDetails.class, box.getInt("assetDetailId"));
					if(box.getString("status").equals("Approve")){
						prqAssetDetails.setAuctionStatus(APPROVED_IN_AUCTION);
					}else if(box.getString("status").equals("Reject")){
						prqAssetDetails.setAuctionStatus(REJECT_IN_AUCTION);
					}
					if(box.getString("auctionRemarks") != null){
						prqAssetDetails.setAuctionRemarks(box.getString("auctionRemarks"));
					}
					hbt.update(prqAssetDetails);
					}
					else if(box.getInt("equipmentId")!=0)
						{
						HesEquipmentMaster equipmentMaster=(HesEquipmentMaster)hbt.load(HesEquipmentMaster.class, box.getInt("equipmentId"));
						MmMasRequestStatus masRequestStatus=new MmMasRequestStatus();
						if(box.getString("status").equals("Approve")){
							masRequestStatus.setId(2);
							equipmentMaster.setEquipStatus(masRequestStatus);
						}else if(box.getString("status").equals("Reject")){
							masRequestStatus.setId(6);
							equipmentMaster.setEquipStatus(masRequestStatus);
						}
						
						hbt.update(equipmentMaster);
						}
			flag = true;
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}

	@Override
	public Map<String, Object> showPendingListForAuctionDetailJsp(Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MasItemCategory> categoryList = new ArrayList<MasItemCategory>();
		List<PrqAssetDetails> assetsList = new ArrayList<PrqAssetDetails>();
		List<PrqAssetDetails> assetsDetailList = new ArrayList<PrqAssetDetails>();
		List<HesEquipmentMaster> equipmentMasters=new ArrayList<HesEquipmentMaster>();
		Session session = (Session)getSession();
		categoryList = session.createCriteria(MasItemCategory.class).createAlias("Section", "section")
							.createAlias("section.ItemType", "itemType").createAlias("itemType.Group", "group").add(Restrictions.eq("group.GroupName", "Assets")).list();
		assetsList = session.createCriteria(PrqAssetDetails.class).add(Restrictions.eq("Institution.Id", box.getInt("hospitalId")))
				//.add(Restrictions.eq("AuctionStatus", MARK_FOR_AUCTION))
				.list();
		Criteria criteria=session.createCriteria(PrqAssetDetails.class).add(Restrictions.eq("AuctionStatus", APPROVED_IN_AUCTION))
				.add(Restrictions.eq("Institution.Id", box.getInt("hospitalId")));
		Criteria criteria2=session.createCriteria(HesEquipmentMaster.class)
				     .createAlias("EquipStatus", "eqp")
				.add(Restrictions.eq("eqp.StatusCode", "AP").ignoreCase());
		equipmentMasters=criteria2.list();
		assetsDetailList = criteria.list();
		System.out.println("nhd"+equipmentMasters.size());
		map.put("equipmentMasters", equipmentMasters);
		map.put("categoryList", categoryList);
		map.put("assetsList", assetsList);
		map.put("assetsDetailList", assetsDetailList);
		return map;
	}

	@Override
	public Map<String, Object> showAssetDetailsMovableJsp(Map<String, Object> details) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<PrqAssetDetails> assetMovable=new ArrayList<PrqAssetDetails>();
		List<MasItemCategory> masItCategory= new ArrayList<MasItemCategory>(); 
		List<MasStoreItem> itemList= new ArrayList<MasStoreItem>(); 
		List<MasStoreSection> sectionList= new ArrayList<MasStoreSection>(); 
		PrqAssetDetails asset=new PrqAssetDetails();
		Session session=getSession();
		
		// added by amit das on 28-07-2016
				String immoveableAndMoaveableAssetCode = null;
				String moveableAssetCode[] = null;
				URL resourcePath = Thread.currentThread().getContextClassLoader()
						.getResource("maintenance.properties");
				try {
					java.util.Properties prop = new java.util.Properties();
					prop.load(new FileInputStream(new File(resourcePath.getFile())));
					immoveableAndMoaveableAssetCode = prop.getProperty("immoveable.moveable.asset.Code");
					moveableAssetCode = immoveableAndMoaveableAssetCode.split("#");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
		// added by amit das on 28-07-2016
		
		
		List<MasItemCategory> masItemCategories = session
				.createCriteria(MasItemCategory.class)
				.createAlias("Section", "sec")
				.createAlias("sec.MasStoreItems", "mas")
				.createAlias("sec.ItemType", "itemType")
				.createAlias("mas.Group", "grp")
			//	.add(Restrictions.eq("itemType.ItemTypeCode", "MA").ignoreCase()) // commented by amit das
				.add(Restrictions.in("itemType.ItemTypeCode", moveableAssetCode))
				.add(Restrictions.eq("grp.GroupName", "Asset").ignoreCase())
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("ItemCategoryName")).list();

		List<MasManufacturer> manufacturers = session
				.createCriteria(MasManufacturer.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("ManufacturerName")).list();
		/*assetMovable = getHibernateTemplate().find(
				"from jkt.hms.masters.business.PrqAssetDetails "); */
		assetMovable=session
				.createCriteria(PrqAssetDetails.class)
				.add(Restrictions.eq("Status", "Y").ignoreCase())
				.addOrder(Order.asc("AssetName"))
				.list();
	itemList = session.createCriteria(MasStoreItem.class)
			 .createAlias("Group", "gp")
			 .createAlias("ItemType", "it")
			 //.add(Restrictions.eq("it.ItemTypeCode", "MA").ignoreCase())
			  .add(Restrictions.eq("gp.GroupCode", "Ass").ignoreCase())
			.add(Restrictions.eq("Status", "y").ignoreCase()).list();
	sectionList = session.createCriteria(MasStoreSection.class).createAlias("ItemType", "itemType").createAlias("itemType.Group", "group")
			//.add(Restrictions.eq("SectionCode", "VH").ignoreCase())
			//.add(Restrictions.eq("itemType.ItemTypeCode", "MA").ignoreCase()) // commented by amit das
			.add(Restrictions.in("itemType.ItemTypeCode", moveableAssetCode))
			.add(Restrictions.eq("group.GroupName", "Asset").ignoreCase()).list();
	map.put("manufacturers", manufacturers);	
	map.put("assetMovable", assetMovable);
	map.put("masItCategory", masItemCategories);
	map.put("itemList", itemList);
	map.put("sectionList", sectionList);
	return map; 	
	}
	
	@Override
	public Map<String, Object> populateStoreItemCategory(int storeSectionId) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Session session=(Session) getSession();
		
		List<MasItemCategory> masItemCategories = session
				.createCriteria(MasItemCategory.class)
				.createAlias("Section", "sec")
				.add(Restrictions.eq("sec.Id", storeSectionId)).list();
				
				/*.createAlias("sec.MasStoreItems", "mas")
				.createAlias("sec.ItemType", "itemType")
				.createAlias("mas.Group", "grp")
				.add(Restrictions.eq("itemType.ItemTypeCode", "MA").ignoreCase())
				.add(Restrictions.eq("grp.GroupName", "Assets"))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("ItemCategoryName")).list();*/
		map.put("masItemCategories", masItemCategories);
		
		return map;
	}
	
	@Override
	public Map<String, Object> populateImmovableStoreItemCategory(
			int storeSectionId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session=(Session) getSession();
		
		List<MasItemCategory> masItemCategories = session
				.createCriteria(MasItemCategory.class)
				.createAlias("Section", "sec")
				.add(Restrictions.eq("sec.Id", storeSectionId)).list();
				
				/*.createAlias("sec.MasStoreItems", "mas")
				.createAlias("sec.ItemType", "itemType")
				.createAlias("mas.Group", "grp")
				.add(Restrictions.eq("itemType.ItemTypeCode", "MA").ignoreCase())
				.add(Restrictions.eq("grp.GroupName", "Assets"))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("ItemCategoryName")).list();*/
		map.put("masItemCategories", masItemCategories);
		return map;
	}
	

	@Override
	public Map<String, Object> populateCodeByItemName(int itemNameId) {
		
		Map<String,Object> map=new HashMap<String,Object>();
		
		List<MasStoreItem> itemList= new ArrayList<MasStoreItem>(); 
		Session session=(Session) getSession();
		itemList = session.createCriteria(MasStoreItem.class)
				 .createAlias("Group", "gp")
				 .createAlias("ItemType", "itemType")
				 .createAlias("ItemCategory", "it")
				 .add(Restrictions.eq("it.Id", itemNameId)).list();
				/*  .add(Restrictions.eq("gp.GroupCode", "Ass").ignoreCase())
				.add(Restrictions.eq("Status", "y").ignoreCase())*/
		
		map.put("itemList", itemList);
		
		return map;
	}
	
	
	@Override
	public Map<String, Object> populateImmovableCodeByItemName(int itemNameId) {
		Map<String,Object> map=new HashMap<String,Object>();
		
		List<MasStoreItem> itemList= new ArrayList<MasStoreItem>(); 
		Session session=(Session) getSession();
		itemList = session.createCriteria(MasStoreItem.class)
				 .createAlias("Group", "gp")
				 .createAlias("ItemType", "itemType")
				 .createAlias("ItemCategory", "it")
				 .add(Restrictions.eq("it.Id", itemNameId)).list();
				/*  .add(Restrictions.eq("gp.GroupCode", "Ass").ignoreCase())
				.add(Restrictions.eq("Status", "y").ignoreCase())*/
		
		map.put("itemList", itemList);
		
		return map;
	}
	
	@Override
	public Map<String, Object> populateStoreItemNameByCode(int itemCode) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Session session=(Session) getSession();
		String itemName="";
		
		Query qry = session.createQuery("select p.Nomenclature from MasStoreItem p where p.Id= :pvmsNo");
		 
		List ltemList =qry.setParameter("pvmsNo",itemCode).list();
		
		Iterator it = ltemList.iterator();
 
		while(it.hasNext())
		{
			itemName = (String)it.next();
			//itemName=(String) o[0];
		}			
		map.put("itemName", itemName);
		return map;
	}
	

	@Override
	public Map<String, Object> directPoCreation(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreSupplier> masStoreSuppliers=new ArrayList<MasStoreSupplier>();
		List<MasHospital> hospitals=new ArrayList<MasHospital>();
		Session session = (Session) getSession();
		int hospitalId=0;
		
		try {

			if(dataMap.get("hospitalId")!=null && dataMap.get("hospitalId")!=""){
				hospitalId=(Integer)dataMap.get("hospitalId");
			}
			masStoreSuppliers=session.createCriteria(MasStoreSupplier.class).list();
			hospitals=session.createCriteria(MasHospital.class).list();	          
		       } catch (Exception e) {
			   e.printStackTrace();
		     }
		map.put("hospitals", hospitals);
		map.put("masStoreSuppliers", masStoreSuppliers);
	    return map;
	}
	
//========================================================================================================
	@Override
	public Map<String, Object> getItemList(Map<String, Object> map) {
			Map<String, Object> datamap = new HashMap<String, Object>();
			List<MasStoreItem> itemList=new ArrayList<MasStoreItem>();
			Session session = (Session) getSession();
			int hospitalId=0;
			int vendorid=0;
			try{
					if(map.get("hospitalId")!=null && map.get("hospitalId")!=""){
						hospitalId=(Integer)map.get("hospitalId");
						
				}
					if(map.get("vendorId")!=null && map.get("vendorId")!=""){
						vendorid=(Integer)map.get("vendorId");
						
					}
					//System.out.println("vendorid----"+vendorid);
					String itemNameField = "";
					if(map.get("itemNameField")!=null ){
						itemNameField=(String)map.get("itemNameField");
						
					}
					
					//System.out.println("group id is == "+itemNameField); 
					
					List<Integer> vendorGrpList = new ArrayList<Integer>();
					vendorGrpList = session.createCriteria(MasStoreSupplierGroup.class).createAlias("Supplier", "sup")
			        		.add(Restrictions.eq("sup.Id", vendorid)).setProjection(Projections.property("Group.Id")).list();
					for (Integer integer : vendorGrpList) {
						//System.out.println("group id is == "+integer);
					}
					if(vendorGrpList.size()>0)
						itemList=session.createCriteria(MasStoreItem.class,"msi")
			        		.createAlias("msi.Group", "grp")
			        		.add(Restrictions.in("grp.Id", vendorGrpList))
			        		.add(Restrictions.ilike("Nomenclature", itemNameField+"%")).list();
				}
			       
				catch (Exception e) {
					   e.printStackTrace();
				     }
			// System.out.println("itemList"+itemList.size());
				map.put("itemList", itemList);
		          return map;
	}

//=====================================================================================================
@Override
public Map<String, Object> showPendingListNegotiation(Map<String, Object> details) {
	Map<String, Object> map=new HashMap<String, Object>();
	List<PrqQuotationHeader> headers=new ArrayList<PrqQuotationHeader>();
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	Integer hospitalId=0;
	Integer userId=0;
	String statusCode=null;
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		java.util.Properties prop = new java.util.Properties();
		prop.load(new FileInputStream(new File(resourcePath.getFile())));
		statusCode = prop.getProperty("commercialApproval");
		System.out.println("ooo"+statusCode);
	} catch (IOException e) {
		e.printStackTrace();
	}
	Date fromDate=null;
	Date toDate=null;
	if(details.get("hospitalId")!=null){
		hospitalId=(Integer)details.get("hospitalId");
	}
	if(details.get("hospitalId")!=null){
		userId=(Integer)details.get("userId");
	}
	Criteria cr=getSession().createCriteria(PrqQuotationHeader.class, "prq")
			.createAlias("prq.Hospital", "h")
			.createAlias("prq.QuotationStatus", "qs")
			.add(Restrictions.eq("h.Id", hospitalId))
			.add(Restrictions.eq("qs.StatusCode",statusCode))
			.add(Restrictions.isNotNull("QuotationNo"))
			.addOrder(Order.desc("prq.QuotationDate"));
	if(details.get("fromDate")!=null && details.get("toDate")!=null){
		try{
			fromDate=sdf.parse((String)details.get("fromDate"));
			toDate=sdf.parse((String)details.get("toDate"));
		}catch(Exception e){e.printStackTrace();}
		cr=cr.add(Restrictions.between("QuotationDate", fromDate, toDate));
	}
	if(details.get("QuotationNo")!=null){
		cr=cr.add(Restrictions.eq("QuotationNo", (String)details.get("QuotationNo")));
	}
	headers=cr.list();
	map.put("headers", headers);
	return map;
}

@Override
public Map<String, Object> submitPoCreationDirect(Box box,
		Map<String, Object> dataMap) {
	 org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		Map<String, Object> map=new HashMap<String, Object>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		int userId=(Integer)dataMap.get(RequestConstants.USER_ID);
		Date cd=new Date();
		Date requiredDate=new Date();
		String msg="";
		          Session session = (Session) getSession();
		         String purchaseorder = "";
		             URL resourcePath = Thread.currentThread().getContextClassLoader()
				                                                .getResource("adt.properties");
		     try { 
			                   Properties prop = new Properties();
			                   prop.load(new FileInputStream(new File(resourcePath.getFile())));
			                 purchaseorder= prop.getProperty("purchaseorder");
		                      } catch (IOException e) {
			                e.printStackTrace();
		                    }
		
		               MmMasRequestStatus status=(MmMasRequestStatus) session
						.createCriteria(MmMasRequestStatus.class)
						.add(Restrictions
								.eq("StatusCode",purchaseorder))
								
						.uniqueResult();
		             System.out.println(box.getInt("itemCount")+"statu"+status.getId());
		            
		        int itemCount=box.getInt("itemCount");
		        StorePoHeader header=null;
		        header= new StorePoHeader();
		        header.setPoDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("poCreationDate")));
		         header.setDeliveryDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("deliveryDate")));
	        	 header.setDeliveryTerms(box.getString("deliveryInstruction"));
	        	 
	  		        int hospitalId=(Integer)dataMap.get(RequestConstants.HOSPITAL_ID);
	  		        MasHospital hospital=new MasHospital();
	  		  		hospital.setId(hospitalId);
	  		  		header.setHospital(hospital);
	  		  		int hdrId=(Integer)hbt.save(header);
	  		  		header.setPoNumber("D-PO"+"/"+dataMap.get(RequestConstants.HOSPITAL_ID)+"/"+hdrId);
	  		  	 MasStoreSupplier storeSupplier=new MasStoreSupplier();
	        	 storeSupplier.setId(box.getInt("vendorName"));
	        	 header.setSupplier(storeSupplier);
	        	 hospital.setId(box.getInt("deliveryTo"));
	        	 header.setDeliveryTo(hospital);
	        	header.setStatus(status);
	        	 header.setDeliveryTerms(box.getString("deliveryInstruction"));
	        	 header.setDeliveryAddress(box.getString("deliveryAddress"));;
	        	 hbt.save(header);
	  		  		
		    for(int i=1;i<=itemCount;i++) 
		    {
			        		if(box.get("itemId"+i)!=null){
			        			StorePoDetail detail=new StorePoDetail();
				        		detail.setPo(header); 
				        		MasStoreItem masStoreItem=new MasStoreItem();
				        		masStoreItem.setId(box.getInt("itemId"+i));
				        		detail.setItem(masStoreItem);
				        	    detail.setItemStatus("w");
				        		 detail.setQuantityOrdered(new BigDecimal(box.getInt("qty"+i)));
				        		 detail.setRatePerMdq(new BigDecimal(box.getInt("rate"+i)));
				        		  detail.setAmount(new BigDecimal(box.getInt("netAmt"+i)));
				        		  detail.setTaxPercent(new BigDecimal(box.getInt("tax"+i)));
	                             detail.setDiscountPercent(new BigDecimal(box.getInt("discount"+i))); 
	                            detail.setDiscountAmount(new BigDecimal(box.getInt("totAmt"+i)));
	                           hbt.save(detail); 
			        		}
			        		
			        	}
		   hbt.flush();
		   
		   int poId = header.getId();
			int locationId = header.getHospital().getId();
       	 hbt.clear();
		   // msg="<span style='color: green'>Successfully Po Create</span>";
		    
		    msg="<span style='color: green'> Direct Purchase Order Created Successfully Do You want to print.</span><span><a href=\"stores?method=printPurchaseOrder&poId="+poId+"&locationId="+locationId+"\">Print Purchase Order</a></span>";
		    
		    
		    map.put("msg", msg);
		    
		return map;
	
}
//=====================================method for submit insurance========================
@Override
public Map<String, Object> submitInsuranceDetails(Box box,
		Map<String, Object> dataMap) {
	
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_AUTO");
	hbt.setCheckWriteOperations(false);
	Map<String, Object> map=new HashMap<String, Object>();
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	int userId=(Integer)dataMap.get(RequestConstants.USER_ID);
	Date cd=new Date();
	Date requiredDate=new Date();
	 int hospitalId=(Integer)dataMap.get(RequestConstants.HOSPITAL_ID);
	String msg="";
	          Session session = (Session) getSession();
	        PrqAssetDetails assetDetails=null;
	        int id = box.getInt("assetId");
	         if(id!=0)
	        	{
	        	  assetDetails=(PrqAssetDetails)session.get(PrqAssetDetails.class,id);
	        	   assetDetails.setStatus("I");
	        	   hbt.update(assetDetails);
                   hbt.flush();
         	     	hbt.clear();
	        	}
	        PrqInsuranceDetails insuranceDetails=null;
        	 insuranceDetails=new PrqInsuranceDetails();
        	                      insuranceDetails.setAsset(assetDetails);
        	                  MasInsuranceCompany company=new MasInsuranceCompany();
        	                    company.setId(box.getInt("insuranceCompany"));
        	                    insuranceDetails.setInsuranceCompany(company);
        	                    insuranceDetails.setAddress(box.getString("address"));
        	                    insuranceDetails.setContactNo(new Long(box.getString("contactNo")));
        	                    insuranceDetails.setPolicyNo(box.getString("policyNo"));
        	                    insuranceDetails.setInsuranceType(box.getString("insuranceType"));
        	                    insuranceDetails.setInsuranceDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("endOfInsurance")));
        	                    insuranceDetails.setInsuranceEndDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("dateOfInsurance")));
        	                    insuranceDetails.setPremiumAmount(new BigDecimal(box.getString("premiumm")));
        	                    insuranceDetails.setRemarks(box.getString("remarks"));
        	                    insuranceDetails.setStatus("i");
        		  		        MasHospital hospital=new MasHospital();
        		  		  		hospital.setId(hospitalId);
        		  		    	insuranceDetails.setHospital(hospital);
                       hbt.save(insuranceDetails);
                       hbt.flush();
             	     	hbt.clear();
		       
	    msg="<span style='color: green'>Successfully Insurance Genrated</span>";
	    map.put("msg", msg);
	    
	return map;

}
//================================================Renewal Insurance=====================================================
@Override
public Map<String, Object> showPendingRenewalInsurance(Box box,
		Map<String, Object> dataMap) {

	Map<String, Object> map=new HashMap<String, Object>(); 
	Session session=(Session)getSession();
	List<PrqInsuranceDetails> prqInsuranceDetails=new ArrayList<PrqInsuranceDetails>();
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	Date fromDate=new Date();
	Date toDate=new Date();
	int hospitalId=0;
	int dueDay=0;
	if(dataMap.get("hospitalId")!=null && dataMap.get("hospitalId")!=""){
		hospitalId=(Integer)dataMap.get("hospitalId");
	}
	if(dataMap.get("dueDay") != null ){
		dueDay = (Integer)dataMap.get("dueDay");
		
	}
	Calendar cal = Calendar.getInstance();
	   cal.add(Calendar.DATE, dueDay);
	   toDate = cal.getTime();
	// System.out.println(fromDate+""+toDate+"==="+hospitalId);

	Criteria cr=session.createCriteria(PrqInsuranceDetails.class,"pi")
			.createAlias("pi.Hospital", "hos")
	     .add(Restrictions.between("pi.InsuranceEndDate", fromDate, toDate))
	       .add(Restrictions.eq("hos.Id", hospitalId))
		 .add(Restrictions.eq("pi.Status", "i").ignoreCase());
	  prqInsuranceDetails=cr.list();
	  System.out.println("---"+prqInsuranceDetails.size());
	 map.put("prqInsuranceDetails",prqInsuranceDetails);
	
	return map;
}
//===============================show renewal insurance================================
@Override
public Map<String, Object> showRenewaljsp(Box box, Map<String, Object> dataMap) {

	 Map<String, Object> map=new HashMap<String, Object>(); 
		List<PrqInsuranceDetails> insuranceDetails=new ArrayList<PrqInsuranceDetails>();
		List<MasInsuranceCompany> insuranceCompanies=new ArrayList<MasInsuranceCompany>();
		Session session = (Session) getSession();
		session = (Session) getSession();
		int requisitionId = 0;
		if(dataMap.get("requisitionId") != null ){
			requisitionId = (Integer)dataMap.get("requisitionId");
			}
		System.out.println("ppooo"+requisitionId);
		insuranceDetails=session.createCriteria(PrqInsuranceDetails.class,"ins")
//		   					 .createAlias("ins.Asset", "asset")
		                     .add(Restrictions.eq("Id", requisitionId)).list();
		
			System.out.println("vendorlist"+insuranceDetails.size());
			insuranceCompanies=getSession().createCriteria(MasInsuranceCompany.class,"ins").add(Restrictions.eq("ins.Status", "y").ignoreCase())
					.list();
			map.put("insuranceCompanies", insuranceCompanies);
			
	           map.put("insuranceDetails", insuranceDetails);
		          return map;
}

@Override
public Map<String, Object> submitrenewalInsuranceDetails(Box box,
		Map<String, Object> dataMap) {
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_AUTO");
	hbt.setCheckWriteOperations(false);
	Map<String, Object> map=new HashMap<String, Object>();
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	int userId=(Integer)dataMap.get(RequestConstants.USER_ID);
	Date cd=new Date();
	Date requiredDate=new Date();
	 int hospitalId=(Integer)dataMap.get(RequestConstants.HOSPITAL_ID);
	String msg="";
	          Session session = (Session) getSession();
	        PrqAssetDetails assetDetails=null;
	        int id = box.getInt("AssetId");
	        System.out.println("id"+id);
	         if(id!=0)
	        	{
	        	  assetDetails=(PrqAssetDetails)session.get(PrqAssetDetails.class,id);
	        	   assetDetails.setStatus("R");
	        	   hbt.update(assetDetails);
                   hbt.flush();
         	     	hbt.clear();
	        	}
	        PrqInsuranceDetails insuranceDetails=null;
        	 insuranceDetails=new PrqInsuranceDetails();
        	                     insuranceDetails.setAsset(assetDetails);
        	                  MasInsuranceCompany company=new MasInsuranceCompany();
        	                    company.setId(box.getInt("insuranceComp"));
        	                    insuranceDetails.setInsuranceCompany(company);
        	                    insuranceDetails.setPolicyNo(box.getString("policyNo."));
        	                    insuranceDetails.setInsuranceType("renew");
        	                    insuranceDetails.setInsuranceDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("insuranceDetailDate")));
        	                    insuranceDetails.setInsuranceEndDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("insuranceEndDate")));
        	                    insuranceDetails.setInsuranceStartDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("insuranceDueDate")));
        	                    insuranceDetails.setPremiumAmount(new BigDecimal(box.getString("renewalAmt")));
        	                    insuranceDetails.setStatus("r");
        		  		        MasHospital hospital=new MasHospital();
        		  		  		hospital.setId(hospitalId);
        		  		    	insuranceDetails.setHospital(hospital);
                       hbt.save(insuranceDetails);
                       hbt.flush();
             	     	hbt.clear();
		       
	    msg="<span style='color: green'>Successfully Insurance Renew</span>";
	    map.put("msg", msg);
	    
	return map;

}



	@Override
	public Map<String, Object> showAuctionDetailJsp(Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<PrqAssetDetails> assetsDetailList = new ArrayList<PrqAssetDetails>();
		List<HesEquipmentMaster> equipmentMasters=new  ArrayList<HesEquipmentMaster>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Session session = (Session)getSession();
		equipmentMasters=session.createCriteria(HesEquipmentMaster.class).add(Restrictions.idEq(box.getInt("requestId"))).list();
		assetsDetailList = session.createCriteria(PrqAssetDetails.class).add(Restrictions.idEq(box.getInt("assetDetailId"))).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("assetsDetailList", assetsDetailList);
		map.put("employeeList", employeeList);
		map.put("equipmentMasters", equipmentMasters);
		return map;
	}

	@Override
	public Map<String, Object> submitAuctionDetail(Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		int count = 0;
		boolean flag = false;
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		AuctionDetail auctionDetail=new AuctionDetail();
		MmMasRequestStatus mmMasRequestStatus=new MmMasRequestStatus();
		try {
			
				if(box.getInt("assetDetailId") !=0){
					int assetDetailId = box.getInt("assetDetailId");
					PrqAssetDetails prqAssetDetails =(PrqAssetDetails)hbt.load(PrqAssetDetails.class, assetDetailId);
					prqAssetDetails.setAuctionStatus(AUCTION_COMPLETE);
					
					if(box.getString("partyName") != null){
						auctionDetail.setPartyName(box.getString("partyName"));
					}
					if(box.getString("partyAddress") != null && !box.getString("partyAddress").equals("")){
						auctionDetail.setPartyName(box.getString("partyAddress"));
					}
					if(box.getInt("contactNo") != 0 ){
						auctionDetail.setContactNo(box.getString("contactNo"));
					}
					if(box.getInt("auctionAmount") != 0 ){
						auctionDetail.setAuctionAmt(box.getString("auctionAmount"));
					}
					if(box.getInt("authorizerId") != 0 ){
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(box.getInt("authorizerId"));
						auctionDetail.setAutherize(masEmployee);
					}
					auctionDetail.setAsset(prqAssetDetails);
					hbt.update(prqAssetDetails);
					hbt.saveOrUpdate(auctionDetail);
				}	
				if(box.getInt("eqpId") !=0){
					int eqpId = box.getInt("eqpId");
					HesEquipmentMaster hesEquipmentMaster =(HesEquipmentMaster)hbt.load(HesEquipmentMaster.class, eqpId);
					mmMasRequestStatus.setId(31);
					hesEquipmentMaster.setEquipStatus(mmMasRequestStatus);
					if(box.getString("partyName") != null){
						auctionDetail.setPartyName(box.getString("partyName"));
					}
					if(box.getString("partyAddress") != null && !box.getString("partyAddress").equals("")){
						auctionDetail.setPartyName(box.getString("partyAddress"));
					}
					if(box.getInt("contactNo") != 0 ){
						auctionDetail.setContactNo(box.getString("contactNo"));
					}
					if(box.getInt("auctionAmount") != 0 ){
						auctionDetail.setAuctionAmt(box.getString("auctionAmount"));
					}
					if(box.getInt("authorizerId") != 0 ){
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(box.getInt("authorizerId"));
						auctionDetail.setAutherize(masEmployee);
					}
					auctionDetail.setEquepment(hesEquipmentMaster);;
					hbt.update(hesEquipmentMaster);
					hbt.saveOrUpdate(auctionDetail);
				}	
			flag = true;
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}

	@Override
	public Map<String, Object> addMuableAssets(
			MultipartFormDataRequest mrequest, Map<String, Object> dataMap) {
		boolean saveFlag = false;
		MasHospital masHospital = new MasHospital();
		Session session = (Session) getSession();
		int hospitalId = Integer.parseInt(dataMap.get(
				RequestConstants.HOSPITAL_ID).toString());
		String survay = mrequest.getParameter("surveyNo");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		List<String> values = new ArrayList<String>();
		String fileSeparator = System.getProperty("file.separator");
		String fileName = null;
		String fileExtension = null;
		Users users = (Users) dataMap.get(RequestConstants.USERS);
		String userHome = dataMap.get("userHome").toString();
		String uploadURL = userHome.substring(0,
				userHome.lastIndexOf(fileSeparator))
				+ fileSeparator
				+ "HMSDocumentFolder"
				+ fileSeparator
				+ "upload" + fileSeparator;

		HMSUtil.createFolderFroDocument("assets", uploadURL);
		List fileUploadedList = null;
		Hashtable files = mrequest.getFiles();
		UploadFile file = (UploadFile) files
				.get(RequestConstants.UPLOAD_FILENAME + 1);
		String fileName1 = null;
		if (file != null && file.getFileName() != null) {

			fileName1 = file.getFileName();

			StringTokenizer strToken = new StringTokenizer(fileName1, ".");

			fileName = strToken.nextToken();
			fileExtension = strToken.nextToken();

			String whiteList = "*." + fileExtension;

			fileUploadedList = HMSUtil.uploadFile(mrequest, uploadURL
					+ "assets" + fileSeparator, whiteList, fileName, 1);

		}
		masHospital = (MasHospital) session.load(MasHospital.class, hospitalId);
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			PrqAssetDetails prqAssetDetails = new PrqAssetDetails();
			if (mrequest.getParameter("commonId") != null
					&& !"".equalsIgnoreCase(mrequest
							.getParameter("commonId"))) {

				prqAssetDetails=(PrqAssetDetails)hbt.load(PrqAssetDetails.class, Integer.parseInt(mrequest.getParameter("commonId")));
			}
			
			if (mrequest.getParameter("assetDescription") != null
					&& !"".equalsIgnoreCase(mrequest
							.getParameter("assetDescription"))) {

				prqAssetDetails.setAssetDesc(mrequest
						.getParameter("assetDescription"));
			}
			if (mrequest.getParameter("dateOfRegistration") != null
					&& !"".equalsIgnoreCase(mrequest
							.getParameter("dateOfRegistration"))) {
				 
			} 
			if (mrequest.getParameter("vName") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("vName"))) {
				prqAssetDetails.setVehicleName(mrequest.getParameter("vName"));
			}  
			if (mrequest.getParameter("remarks") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("remarks"))) {
				prqAssetDetails.setRemarks(mrequest.getParameter("remarks"));
			}
			if (mrequest.getParameter("purchesVal") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("purchesVal"))) {
				BigDecimal money=new BigDecimal(mrequest.getParameter("purchesVal"));
				prqAssetDetails.setPurchaseValue(money);
			}
			 
			if (mrequest.getParameter("tValue") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("tValue"))) {
				BigDecimal money=new BigDecimal(mrequest.getParameter("tValue"));
				prqAssetDetails.setTotalCost(money);
			}
			if (mrequest.getParameter("assetCategory") != null
					&& !"".equalsIgnoreCase(mrequest
							.getParameter("assetCategory"))) {
				MasItemCategory assetCategory = new MasItemCategory(
						Integer.parseInt(mrequest.getParameter("assetCategory")));
				prqAssetDetails.setAssetCategory(assetCategory);

			}
			if (mrequest.getParameter("itemId") != null
					&& !"".equalsIgnoreCase(mrequest
							.getParameter("itemId"))) {
				MasStoreItem masStoreItem = new MasStoreItem(
						Integer.parseInt(mrequest.getParameter("itemId")));
				prqAssetDetails.setItem(masStoreItem);

			}
			if (mrequest.getParameter("assetSection") != null
					&& !"".equalsIgnoreCase(mrequest
							.getParameter("assetSection"))) {
				MasStoreSection storeSection = new MasStoreSection(
						Integer.parseInt(mrequest.getParameter("assetSection")));
				prqAssetDetails.setItemSection(storeSection);

			}
			if (mrequest.getParameter("model") != null
					&& !"".equalsIgnoreCase(mrequest
							.getParameter("model"))) { 
				prqAssetDetails.setModalNo(mrequest.getParameter("model"));
			}
			if (mrequest.getParameter("address") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("address"))) {
				prqAssetDetails.setAddress(mrequest.getParameter("address"));
			}
			if (mrequest.getParameter("rNo") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("rNo"))) {
				prqAssetDetails.setRegistrationNo(mrequest.getParameter("rNo"));
			}
			if (mrequest.getParameter("vType") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("vType"))) {
				prqAssetDetails.setVehicleType(mrequest.getParameter("vType"));
			}
			if (mrequest.getParameter("cost") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("cost"))) {
				BigDecimal money = new BigDecimal(mrequest.getParameter("cost"));
				prqAssetDetails.setEstCost(money);

			}
			if (mrequest.getParameter("assetName") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("assetName"))) {
				prqAssetDetails.setAssetName(mrequest
						.getParameter("assetName"));

			}
			if (mrequest.getParameter("assetsCode") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("assetsCode"))) {
				prqAssetDetails.setAssetCode(mrequest
						.getParameter("assetsCode"));

			}
			if (mrequest.getParameter("roadTax") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("roadTax"))) {
				BigDecimal money=new BigDecimal(mrequest.getParameter("roadTax"));
				prqAssetDetails.setRoadTax(money);

			}
			if (mrequest.getParameter("acquireFrom") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("acquireFrom"))) {
				prqAssetDetails.setAcquireFrom(mrequest.getParameter("acquireFrom"));
			} 
			if (mrequest.getParameter("wPeriod") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("wPeriod"))) {
				prqAssetDetails.setWarrentyPeriod(mrequest.getParameter("wPeriod"));
			} 
			if (mrequest.getParameter("tax") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("tax"))) {
				BigDecimal money=new BigDecimal(mrequest.getParameter("tax"));
				prqAssetDetails.setTax(money);
			}
			if (mrequest.getParameter("email") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("email"))) { 
				prqAssetDetails.setEmail(mrequest.getParameter("email"));
			}
			if (mrequest.getParameter("outlet") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("outlet"))) { 
				prqAssetDetails.setServiceOutlet(mrequest.getParameter("outlet"));
			}
			System.out.println("contactNo."+mrequest.getParameter("contact"));
			if (mrequest.getParameter("contact") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("contact"))) { 
				prqAssetDetails.setContactNo(Long.parseLong(mrequest.getParameter("contact")));
			}
			if (mrequest.getParameter("deprication") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("deprication"))) { 
				prqAssetDetails.setDeprecation(Long.parseLong(mrequest.getParameter("deprication")));
			}
			if (mrequest.getParameter("manufacture") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("manufacture"))) {  
				MasManufacturer manufacturer=new MasManufacturer(Integer.parseInt(mrequest.getParameter("manufacture")));
				prqAssetDetails.setManufacturer(manufacturer);
			}
			if (mrequest.getParameter("effectDate") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("effectDate"))) {  
				
				prqAssetDetails.setEffectiveFromDate(HMSUtil.convertStringTypeDateToDateType(mrequest.getParameter("effectDate")));
			}
			if (mrequest.getParameter("validUpTo") != null
					&& !"".equalsIgnoreCase(mrequest
							.getParameter("validUpTo"))) {
				 
				prqAssetDetails.setValidUpto(HMSUtil.convertStringTypeDateToDateType(mrequest.getParameter("validUpTo")));
			}
			if (mrequest.getParameter("aData") != null
					&& !"".equalsIgnoreCase(mrequest
							.getParameter("aData"))) { 
				prqAssetDetails.setAgreementDate(HMSUtil.convertStringTypeDateToDateType(mrequest.getParameter("aData")));
			}
			if (mrequest.getParameter("sourceOfVehicle") != null
					&& !"".equalsIgnoreCase(mrequest.getParameter("sourceOfVehicle"))) { 
				prqAssetDetails.setSourceOfVehicle(mrequest.getParameter("sourceOfVehicle"));
			}
			prqAssetDetails.setAuctionStatus(NOT_FOR_AUCTION);
			prqAssetDetails.setAssetType("movable");
			prqAssetDetails.setStatus("y");
			prqAssetDetails.setLastChgBy(users);
			prqAssetDetails.setLastChgDate(HMSUtil
					.getCurrentDateAndTimeObject());
			prqAssetDetails.setInstitutionType(masHospital.getHospitalType());
			prqAssetDetails.setLastChgTime(time);
			prqAssetDetails.setInstitution(masHospital);
			UploadDocuments uploadDocuments = new UploadDocuments();
			if (fileName1 != null) {
				
				File file1 = null;
				file1 = new File(uploadURL + fileSeparator + "assets"
						+ fileSeparator + fileName1);

				File f = new File(uploadURL);
				try {
					if (f.exists()) {
						FileInputStream is = new FileInputStream(file1);
						long length = file1.length();

						if (length > Integer.MAX_VALUE) {

						}

						byte[] bytes = new byte[(int) length];
						int offset = 0;
						int numRead = 0;
						while (offset < bytes.length
								&& (numRead = is.read(bytes, offset,
										bytes.length - offset)) >= 0) {
							offset += numRead;
						}

						if (offset < bytes.length) {
							throw new IOException(
									"Could not completely read file "
											+ file1.getName());
						}

						uploadDocuments.setPatientDocument(bytes);
						is.close();
					} else {
						f.mkdir();
						FileInputStream is = new FileInputStream(file1);
						long length = file1.length();

						if (length > Integer.MAX_VALUE) {

						}

						byte[] bytes = new byte[(int) length];
						int offset = 0;
						int numRead = 0;
						while (offset < bytes.length
								&& (numRead = is.read(bytes, offset,
										bytes.length - offset)) >= 0) {
							offset += numRead;
						}

						if (offset < bytes.length) {
							throw new IOException(
									"Could not completely read file "
											+ file1.getName());
						}
						is.close();

						uploadDocuments.setPatientDocument(bytes);

					} 
					uploadDocuments.setAsset(prqAssetDetails);
					uploadDocuments.setLastChgBy(users);
					uploadDocuments.setLastChgDate(HMSUtil
							.getCurrentDateAndTimeObject());
					uploadDocuments.setLastChgTime(time);
					uploadDocuments.setHospital(masHospital);
					hbt.save(uploadDocuments); 
					saveFlag = true;

				} catch (Exception e) {
					e.printStackTrace();
					if (transaction != null) {
						transaction.rollback();
					}

				}
			}
			hbt.save(prqAssetDetails); 
			hbt.flush();
			hbt.clear();
			transaction.commit();
			saveFlag = true;
		} catch (Exception e) {

			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();

		}
		dataMap.put("message", saveFlag);
		return dataMap;

	}
	@Override
	public Map<String, Object> searchPendingListForAuctionDetail(Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MasItemCategory> categoryList = new ArrayList<MasItemCategory>();
		List<PrqAssetDetails> assetsList = new ArrayList<PrqAssetDetails>();
		List<PrqAssetDetails> assetsDetailList = new ArrayList<PrqAssetDetails>();
		Session session = (Session)getSession();
		categoryList = session.createCriteria(MasItemCategory.class).createAlias("Section", "section")
							.createAlias("section.ItemType", "itemType").createAlias("itemType.Group", "group").add(Restrictions.eq("group.GroupName", "Assets")).list();
		assetsList = session.createCriteria(PrqAssetDetails.class).add(Restrictions.eq("Institution.Id", box.getInt("hospitalId")))
				//.add(Restrictions.eq("AuctionStatus", MARK_FOR_AUCTION))
				.list();
		if(box.getString("flag").equals("all")){
			Criteria criteria=session.createCriteria(PrqAssetDetails.class).add(Restrictions.eq("AuctionStatus", APPROVED_IN_AUCTION))
					.add(Restrictions.eq("Institution.Id", box.getInt("hospitalId")));
			assetsDetailList = criteria.list();
			
		}else{
			Criteria criteria=session.createCriteria(PrqAssetDetails.class).add(Restrictions.eq("AuctionStatus", APPROVED_IN_AUCTION))
					.add(Restrictions.eq("Institution.Id", box.getInt("hospitalId")));
			if(box.getInt("itemCategoryId") != 0){
				criteria = criteria.createAlias("AssetCategory", "itemCategory").add(Restrictions.eq("itemCategory.Id", box.getInt("itemCategoryId") ));
			}
			if(box.getString("assetCode") != null && !box.getString("assetCode").equals("")){
				System.out.println("asset code=="+box.getString("assetCode"));
				criteria = criteria.add(Restrictions.eq("AssetCode",box.getString("assetCode")));
			}
			
			if(box.getString("assetName") != null && !box.getString("assetName").equals("")){
				criteria = criteria.add(Restrictions.eq("AssetName",box.getString("assetName")));
			}
			if(box.getString("auctionDate")!=null && !box.getString("auctionDate").equals("")){
				/*try{
					fromDate=sdf.parse((String)details.get("fromDate"));
					toDate=sdf.parse((String)details.get("toDate"));
				}catch(Exception e){e.printStackTrace();}*/
				criteria=criteria.add(Restrictions.eq("AuctionDate", HMSUtil.convertStringTypeDateToDateType(box.getString("auctionDate"))));
			}
			assetsDetailList = criteria.list();
	}
		map.put("categoryList", categoryList);
		map.put("assetsList", assetsList);
		map.put("assetsDetailList", assetsDetailList);
		return map;
	}
	public Map<String, Object> getMasStoreItemList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> itemList = new ArrayList<Object>(); 
		String autoHint="";
		if(box.get("autoHint")!=null&&!"".equals(box.get("autoHint"))){
			autoHint=box.get("autoHint");
		}
		List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();
		Session session = getSession(); 
		List<Integer> objectList = new ArrayList<Integer>(); 
		itemList=session.createCriteria(MasStoreItem.class)
				.add(Restrictions.like("Nomenclature", autoHint+"%").ignoreCase()) 
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.list();
		map.put("itemList", itemList);
		map.put("objectList", objectList);
		return map;
	}

	@Override
	public Map<String, Object> submitPhysicalInventoryDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreGroup> itemGroupList = new ArrayList<MasStoreGroup>();
		Session session = (Session)getSession();
		int count = 0;
		
		if(box.getInt("count") !=0){
			count =(Integer)box.getInt("count");
		}
		Transaction tx=null;
	
		String message = "";
		boolean flag = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			tx=getSession().beginTransaction();
		
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");
			Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
			int assetGroupId = 0;
			itemGroupList = session.createCriteria(MasStoreGroup.class).add(Restrictions.eq("GroupName", "Assets")).list();
			if(itemGroupList.size()>0){
				for(MasStoreGroup storeGroup : itemGroupList){
					assetGroupId = storeGroup.getId();
				}
			}
			StoreStockTakingM storeStockTakingM = new StoreStockTakingM();
			MasStoreGroup masStoreGroup = new MasStoreGroup();
			masStoreGroup.setId(assetGroupId);
			storeStockTakingM.setItemGroup(masStoreGroup);
			storeStockTakingM.setPhysicalDate(date);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("hospitalId"));
			storeStockTakingM.setHospital(masHospital);
			storeStockTakingM.setLastChangedDate(date);
			storeStockTakingM.setLastChangedTime(time);
			Users users = new Users();
			users.setId(box.getInt("userId"));
			storeStockTakingM.setLastChangedBy(users);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(box.getInt("deptId"));
			storeStockTakingM.setDepartment(masDepartment);
			storeStockTakingM.setStatus("p");
			hbt.save(storeStockTakingM);
			for(int i=1;i<=count;i++){
				if(box.getInt("assetId"+i)!=0){
					StoreStockTakingT storeStockTakingT = new StoreStockTakingT();
					PrqAssetDetails prqAssetDetails = new PrqAssetDetails();
					prqAssetDetails.setId(Integer.parseInt(box.getString("assetId"+i)));
					storeStockTakingT.setAsset(prqAssetDetails);
					storeStockTakingT.setStockTakingM(storeStockTakingM);
					
					if(box.getInt("itemId"+i)!=0){
						MasStoreItem masStoreItem = new MasStoreItem();
						masStoreItem.setId(Integer.parseInt(box.getString("itemId"+i)));
						storeStockTakingT.setItem(masStoreItem);
					}
					if(box.getString("itemAvailable"+i)!=null && !box.getString("itemAvailable"+i).equals("")){
						storeStockTakingT.setItemAvailabilityStatus(box.getString("itemAvailable"+i));
					
					}else if(box.getString("itemNotAvailable"+i)!=null && !box.getString("itemNotAvailable"+i).equals("")){
						storeStockTakingT.setItemAvailabilityStatus(box.getString("itemAvailable"+i));
					}
					if(box.getString("conditionOfItem"+i)!=null && !box.getString("conditionOfItem"+i).equals("")){
						storeStockTakingT.setItemCondition(box.getString("conditionOfItem"+i));
					}
					if(box.getString("reasonForNonAvaiability"+i)!=null && !box.getString("reasonForNonAvaiability"+i).equals("")){
						storeStockTakingT.setItemCondition(box.getString("reasonForNonAvaiability"+i));
					}
					hbt.save(storeStockTakingT);
					
				}
			}
			tx.commit();
			flag = true;
			
		}catch(Exception e){
			e.printStackTrace();
			if(tx==null){
				tx.rollback();
			}
		}
		map.put("flag", flag);
		return map;
	}

	@Override
	public Map<String, Object> showPhysicalInventoryApprovalListJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreStockTakingM> stocktakingMList = new ArrayList<StoreStockTakingM>();
		Session session = (Session)getSession();
		stocktakingMList = session.createCriteria(StoreStockTakingM.class).add(Restrictions.eq("Status", "p").ignoreCase()).list();
		map.put("stocktakingMList", stocktakingMList);
		return map;
	}

	@Override
	public Map<String, Object> showPhysicalInventoryApprovalJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreStockTakingT> stocktakingTList = new ArrayList<StoreStockTakingT>();
		Session session = (Session)getSession();
		stocktakingTList = session.createCriteria(StoreStockTakingT.class)
				 .createAlias("StockTakingM", "stm")
				 .add(Restrictions.eq("stm.Status", "p"))
				.add(Restrictions.eq("stm.Id", box.getInt("stockTakingMId")))
				
				.list();
		map.put("stocktakingTList", stocktakingTList);
		return map;
	}

	@Override
	public Map<String, Object> submitPhysicalInventoryApproval(Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		int count = 0;
		boolean flag = false;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			
				if(box.getString("status")!=null && !box.getString("status").equals("")){
					int storeStockTakingMId = box.getInt("storeStockTakingMId");
					System.out.println("storeStockTakingMId=="+storeStockTakingMId);
					StoreStockTakingM stockTakingM =(StoreStockTakingM)hbt.load(StoreStockTakingM.class, storeStockTakingMId);
					if(box.getString("status").equals("Approve")){
						stockTakingM.setStatus("a");
					}else{
						stockTakingM.setStatus("r");
					}
					if(box.getString("remarks") != null){
						stockTakingM.setRemarks(box.getString("remarks"));
					}
					stockTakingM.setApprovedDate(date);
					hbt.update(stockTakingM);
				
			flag = true;
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}

	@Override
	public Map<String, Object> submitInsuranceClaimTracking(Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		boolean flag = false;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx=null;
		try {
			tx=getSession().beginTransaction();
			if(box.getInt("insuranceId") !=0){
				int insuranceId = box.getInt("insuranceId");
				PrqInsuranceDetails insuranceDetails =(PrqInsuranceDetails)hbt.load(PrqInsuranceDetails.class, insuranceId);
				insuranceDetails.setStatus("c");
				hbt.update(insuranceDetails);
				hbt.flush();
				PrqInsuranceClaimDetails prqInsuranceClaimDetails=new PrqInsuranceClaimDetails();
				if(box.getString("claimDate") != null  && !box.getString("claimDate").equals("")){
					prqInsuranceClaimDetails.setClaimDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("claimDate")));
				}
				if(box.getString("claimType") != null && !box.getString("claimType").equals("")){
					prqInsuranceClaimDetails.setClaimType(box.getString("claimType"));
				}
				if(box.getString("claimDescription") != null && !box.getString("claimDescription").equals("") ){
					prqInsuranceClaimDetails.setClaimDesc(box.getString("claimDescription"));
				}
				if(box.getInt("claimAmount") != 0 ){
					prqInsuranceClaimDetails.setClaimAmount(new BigDecimal(box.getInt("claimAmount")));
				}
				if(box.getString("claimStatus") != null && !box.getString("claimStatus").equals("") ){
					prqInsuranceClaimDetails.setClaimStatus(box.getString("claimStatus"));
				}
				if(box.getString("claimDisbursementDate") != null && !box.getString("claimDisbursementDate").equals("") ){
					prqInsuranceClaimDetails.setClaimDisbursementDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("claimDisbursementDate")));
				}
				if(box.getInt("disbursedAmount") != 0 ){
					prqInsuranceClaimDetails.setDisbursedAmount(new BigDecimal(box.getInt("disbursedAmount")));
				}
				if(box.getString("remarks") != null && !box.getString("remarks").equals("") ){
					prqInsuranceClaimDetails.setRemarks(box.getString("remarks"));
				}
				 PrqInsuranceDetails insurance=new PrqInsuranceDetails();
				insurance.setId(insuranceId);
				prqInsuranceClaimDetails.setInsurance(insurance);
				prqInsuranceClaimDetails.setClaimNo("c"+insuranceId);
				prqInsuranceClaimDetails.setLastChgDate(date);
				prqInsuranceClaimDetails.setLastChgTime(time);
				hbt.save(prqInsuranceClaimDetails);
				hbt.flush();
				hbt.clear();
			}	
			tx.commit();
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
			if(tx==null){
				tx.rollback();
			}
		}
		map.put("flag", flag);
		return map;
	}

	@Override
	public Map<String, Object> showLocalPurchaseItemTracking(int hospitalId) {
		Map<String, Object> map=new HashMap<String, Object>();
		Session session=(Session)getSession();
		List<StorePoHeader>poHeaderList=new ArrayList<StorePoHeader>();
		poHeaderList=session.createCriteria(StorePoHeader.class).add(Restrictions.eq("Hospital.Id",hospitalId)).list();
		map.put("poHeaderList",poHeaderList);
		return map;
	}

	@Override
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}

	@Override
	public Map<String, Object> printForLocalPurchaseItemTrackingScreen(int hospitalId, int poId,Box box) {
		
		int item_id=0;
		String fromDate="";
		String toDate=""; 
		String pvmsNo="";

		String query=
				
				
				"select i.nomenclature,po.po_number,po.po_date,m.grn_no,m.grn_date,t.qty_ordered,t.received_qty ,(t.qty_ordered-t.received_qty) from store_po_header po left outer join  store_po_detail pot on po.po_id=pot.po_id left outer join mas_hospital mh on mh.hospital_id=po.hospital_id left outer join mas_store_item i on i.item_id=pot.item_id left outer join  store_grn_m m on  m.po_id=po.po_id left outer join  store_grn_t t on m.grn_master_id=t.grn_master_id where po.po_id="+poId+" and po.hospital_id="+hospitalId;
			
		
		/*String query="select i.nomenclature,d.quantity_ordered,t.received_qty,(d.quantity_ordered-t.received_qty)as qty_remained,mh.hospital_name, "+
" m.grn_no,m.grn_date,h.po_number,h.po_date from store_grn_t t  "+
"   left outer join  store_grn_m m on m.grn_master_id=t.grn_master_id "+
		   "    left outer join  store_po_header h on h.po_id=m.po_id "+
		   " left outer join  store_po_detail d on d.po_id=h.po_id "+
		   " left outer join mas_store_item i on i.item_id=d.item_id "+
		   " left outer join mas_hospital mh on mh.hospital_id=h.hospital_id "+ 
		   " where m.po_id="+poId+" and m.hospital_id="+hospitalId;*/
		Map<String, Object> map=new HashMap<String, Object>();
				
		if(box.get("fromDate")!=null && box.get("fromDate")!=""){
			fromDate=(String) box.get("fromDate");
		}
		if(box.get("toDate")!=null && box.get("toDate")!=""){
			toDate=(String) box.get("toDate");
		}
	
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date fromDated=new Date();
		Date toDated=new Date();
		
		if(fromDate!=null && !fromDate.equals("") && toDate!=null && !toDate.equals("")){
			try{
				fromDated=sdf.parse(fromDate);
			toDated=sdf.parse(toDate);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			query+= " and po.po_date between '"+ fromDated +"' and '"+toDated+"'" ;
		}
		
		
		
		
		
		if(box.getString("pvmsNo") != null && !box.getString("pvmsNo").equals("") ){
			pvmsNo = box.getString("pvmsNo");
			
			query+= " and i.pvms_no='"+pvmsNo+"'";
		}
		
		
		Session session=(Session)getSession();
		List<Object[]> aList=new ArrayList<Object[]>();
		aList=session.createSQLQuery(query).list();
		System.out.println(""+query);
		map.put("aList",aList);
		return map;
		}

	@Override
	public Map<String, Object> showPendingCondemnationJsp(Box box,
			Map<String, Object> dataMap) {

		Map<String, Object> map=new HashMap<String, Object>(); 
		Session session=(Session)getSession();
		List<MmServiceRequest> serviceRequests=new ArrayList<MmServiceRequest>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date fromDate=new Date();
		Date toDate=new Date();
		int hospitalId=0;
		if(dataMap.get("hospitalId")!=null && dataMap.get("hospitalId")!=""){
			hospitalId=(Integer) dataMap.get("hospitalId");
		}
		System.out.println("hospitalId"+hospitalId);
		
		Criteria cr=session.createCriteria(MmServiceRequest.class)
				     .createAlias("RequestStatus", "rs")
				     .createAlias("Hospital", "hosp")
		           .add(Restrictions.eq("rs.StatusCode", "AUC").ignoreCase())
		           .add(Restrictions.eq("hosp.Id", hospitalId));
		if(box.getString("fromDate")!=null && !box.getString("fromDate").equals("") && box.getString("toDate")!=null && !box.getString("toDate").equals("")){
			try{
			fromDate=sdf.parse(box.getString("fromDate"));
			toDate=sdf.parse(box.getString("toDate"));
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			cr=cr.add(Restrictions.between("RequestDate", fromDate, toDate));
		}
		serviceRequests=cr.list();
		 map.put("serviceRequests",serviceRequests);
		return map;
	}

	@Override
	public Map<String, Object> showCondemAuctionJsp(Box box,
			Map<String, Object> dataMap) {
		  Map<String, Object> map=new HashMap<String, Object>(); 
			Session session=(Session)getSession();
			List<MmServiceRequest> serviceRequests=new ArrayList<MmServiceRequest>();
			List<MasEmployee> employees=new ArrayList<MasEmployee>();
			List<Integer> item=new ArrayList<Integer>();
			
			int hospitalId=0;
			if(dataMap.get("hospitalId")!=null && dataMap.get("hospitalId")!=""){
				hospitalId=(Integer)dataMap.get("hospitalId");
			}
			if(dataMap.get("itemName")!=null ){
				item=(List<Integer>)dataMap.get("itemName");
			}
			Criteria cr=session.createCriteria(MmServiceRequest.class)
				     .createAlias("RequestStatus", "rs")
				     .createAlias("Hospital", "hosp")
		           .add(Restrictions.eq("rs.StatusCode", "AUC").ignoreCase())
		           .add(Restrictions.eq("hosp.Id", hospitalId));
				if(dataMap.get("itemName")!=null ){
					cr=cr.add(Restrictions.in("Id",item));
				}
				serviceRequests=cr.list();
				employees=session.createCriteria(MasEmployee.class).list();
				map.put("employees", employees);
			 map.put("serviceRequests",serviceRequests);
			 return map;
	}

	@Override
	public Map<String, Object> getItemListForEquipDetail(Map<String, Object> dataMap) {
			List<StoreItemBatchStock> itemList = new ArrayList<StoreItemBatchStock>();
			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session) getSession();
			String[] equipmentCode=null;
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("maintenance.properties");
			try {
				java.util.Properties prop = new java.util.Properties();
				prop.load(new FileInputStream(new File(resourcePath.getFile())));
				equipmentCode = prop.getProperty("procurement.equipment.category.code").split("#");
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				String str = dataMap.get("autoHint") + "%";;
				
				itemList = session.createCriteria(StoreItemBatchStock.class).createAlias("Item", "item").createAlias("item.ItemType", "it")
						.add(Restrictions.in("it.ItemTypeCode", equipmentCode))
						.add(Restrictions.like("item.Nomenclature", str).ignoreCase())
						.add(Restrictions.isNull("EquipmentDetailStatus")).add(Restrictions.eq("Hospital.Id", (Integer)dataMap.get("hospitalId"))).list();
				/*String query = "select mst from MasStoreItem as mst where mst.Nomenclature like '"
						+ str + "' and UPPER(mst.Status)=UPPER('Y')";
				Query q = session.createQuery(query);
				q.setFirstResult(0);
				q.setMaxResults(10);
				itemList = q.list();*/

			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("itemList"+itemList.size());
			map.put("itemList", itemList);
			return map;

		}

	

	@Override
	public Map<String, Object> getFromDateAndToDate(
			Map<String, Object> detailsMap) {

		Map<String, Object> map=new HashMap<String, Object>(); 
		Session session=(Session)getSession();
		List<StoreGrnM> storeGrnMList=new ArrayList<StoreGrnM>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date fromDated=new Date();
		Date toDated=new Date();
		String fromDate="";
		String toDate="";
		int hospitalId=0;
		List<StorePoHeader> poHeaderList=new ArrayList<StorePoHeader>();
		if(detailsMap.get("hospitalId")!=null && detailsMap.get("hospitalId")!=""){
			hospitalId=(Integer) detailsMap.get("hospitalId");
		}
		if(detailsMap.get("toDate")!=null && detailsMap.get("toDate")!=""){
			toDate=(String) detailsMap.get("toDate");
		}
		if(detailsMap.get("fromDate")!=null && detailsMap.get("fromDate")!=""){
			fromDate=(String) detailsMap.get("fromDate");
		}
		System.out.println("hospitalId"+hospitalId);
		
		System.out.println("fromDate"+fromDate);
		
		System.out.println("toDate"+toDate);
		Criteria cr=session.createCriteria(StorePoHeader.class).add(Restrictions.eq("Hospital.Id",hospitalId));
		
		if(fromDate!=null && !fromDate.equals("") && toDate!=null && !toDate.equals("")){
			
			try{
				fromDated=sdf.parse(fromDate);
			toDated=sdf.parse(toDate);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			cr=cr.add(Restrictions.between("PoDate", fromDated, toDated));
			
		}
		poHeaderList=cr.list();
		
		/*if(storeGrnMList.size()>0){
		for (StoreGrnM storeGrnM : storeGrnMList) {
			if(storeGrnM.getPo()!=null){
			poHeaderList=session.createCriteria(StorePoHeader.class)
					.add(Restrictions.eq("Hospital.Id",hospitalId))
					.add(Restrictions.eq("Id", storeGrnM.getPo().getId()))
					.setProjection(
							Projections
									.projectionList()
									.add(Projections
											.groupProperty("Id"))
									.add(Projections
											.property("PoNumber"))).list();
			}
			
			}
		
		}*/
		System.out.println("poHeaderList"+poHeaderList.size());
		map.put("poHeaderList",poHeaderList);
		
		return map;
	}
}
	

	
	
	

	





