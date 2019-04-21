package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the etr_fillbookeddtls table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="etr_fillbookeddtls"
 */

public abstract class BaseEtrFillbookeddtls  implements Serializable {

	public static String REF = "EtrFillbookeddtls";
	public static String PROP_LOCAL_C_A_B_DESC = "LocalCABDesc";
	public static String PROP_LCB_CNCL_APPR_BY = "LcbCnclApprBy";
	public static String PROP_LCBCNCL_APPR_AT = "LcbcnclApprAt";
	public static String PROP_LCBBOOK = "Lcbbook";
	public static String PROP_TRV = "Trv";
	public static String PROP_HTL_SELF_CANCEL = "HtlSelfCancel";
	public static String PROP_HOTEL_DESC = "HotelDesc";
	public static String PROP_LCB_CANCEL_REQ = "LcbCancelReq";
	public static String PROP_HTL_CNCLAPPSTS = "HtlCnclappsts";
	public static String PROP_HTL_CANCEL_STS = "HtlCancelSts";
	public static String PROP_LCB_CANCEL_STS = "LcbCancelSts";
	public static String PROP_LCBCNCLAPPSTS = "Lcbcnclappsts";
	public static String PROP_HTL_CNCL_APPR_BY = "HtlCnclApprBy";
	public static String PROP_CREATED_AT = "CreatedAt";
	public static String PROP_LCB_SELF_CANCEL = "LcbSelfCancel";
	public static String PROP_LCB_CANCEL_DESC = "LcbCancelDesc";
	public static String PROP_MODIFIED_BY = "ModifiedBy";
	public static String PROP_HTL_CANCEL_DESC = "HtlCancelDesc";
	public static String PROP_HTLBOOK = "Htlbook";
	public static String PROP_LCBCNCLAPPCMTS = "Lcbcnclappcmts";
	public static String PROP_HTL_CANCEL_REQ = "HtlCancelReq";
	public static String PROP_CREATED_BY = "CreatedBy";
	public static String PROP_TKT_DESC = "TktDesc";
	public static String PROP_HTCNCLAPPCMTS = "Htcnclappcmts";
	public static String PROP_ID = "Id";
	public static String PROP_HTL_CNCL_APPR_AT = "HtlCnclApprAt";
	public static String PROP_FILL_DATE = "FillDate";


	// constructors
	public BaseEtrFillbookeddtls () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEtrFillbookeddtls (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date fillDate;
	private java.lang.String tktDesc;
	private java.lang.String hotelDesc;
	private java.lang.String localCABDesc;
	private java.util.Date createdAt;
	private java.lang.Byte htlSelfCancel;
	private java.lang.Byte lcbSelfCancel;
	private java.lang.String htlCancelReq;
	private java.lang.String lcbCancelReq;
	private java.lang.String htlCancelDesc;
	private java.lang.String lcbCancelDesc;
	private java.lang.Integer htlCancelSts;
	private java.lang.Integer lcbCancelSts;
	private java.lang.Integer lcbCnclApprBy;
	private java.util.Date lcbcnclApprAt;
	private java.lang.Byte htlbook;
	private java.lang.Byte lcbbook;
	private java.lang.Integer htlCnclApprBy;
	private java.util.Date htlCnclApprAt;
	private java.lang.String htcnclappcmts;
	private java.lang.String lcbcnclappcmts;
	private java.lang.String htlCnclappsts;
	private java.lang.String lcbcnclappsts;

	// many to one
	private jkt.hrms.masters.business.EtrTravelreq trv;
	private jkt.hms.masters.business.MasEmployee modifiedBy;
	private jkt.hms.masters.business.MasEmployee createdBy;

	// collections
	private java.util.Set<jkt.hrms.masters.business.EtrTicketdetails> etrTicketdetails;
	private java.util.Set<jkt.hrms.masters.business.EtrBookeddtlsAttach> etrBookeddtlsAttachs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="Fbdt_id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: fill_date
	 */
	public java.util.Date getFillDate () {
		return fillDate;
	}

	/**
	 * Set the value related to the column: fill_date
	 * @param fillDate the fill_date value
	 */
	public void setFillDate (java.util.Date fillDate) {
		this.fillDate = fillDate;
	}



	/**
	 * Return the value associated with the column: Tkt_desc
	 */
	public java.lang.String getTktDesc () {
		return tktDesc;
	}

	/**
	 * Set the value related to the column: Tkt_desc
	 * @param tktDesc the Tkt_desc value
	 */
	public void setTktDesc (java.lang.String tktDesc) {
		this.tktDesc = tktDesc;
	}



	/**
	 * Return the value associated with the column: HotelDesc
	 */
	public java.lang.String getHotelDesc () {
		return hotelDesc;
	}

	/**
	 * Set the value related to the column: HotelDesc
	 * @param hotelDesc the HotelDesc value
	 */
	public void setHotelDesc (java.lang.String hotelDesc) {
		this.hotelDesc = hotelDesc;
	}



	/**
	 * Return the value associated with the column: LocalCABDesc
	 */
	public java.lang.String getLocalCABDesc () {
		return localCABDesc;
	}

	/**
	 * Set the value related to the column: LocalCABDesc
	 * @param localCABDesc the LocalCABDesc value
	 */
	public void setLocalCABDesc (java.lang.String localCABDesc) {
		this.localCABDesc = localCABDesc;
	}



	/**
	 * Return the value associated with the column: CreatedAt
	 */
	public java.util.Date getCreatedAt () {
		return createdAt;
	}

	/**
	 * Set the value related to the column: CreatedAt
	 * @param createdAt the CreatedAt value
	 */
	public void setCreatedAt (java.util.Date createdAt) {
		this.createdAt = createdAt;
	}



	/**
	 * Return the value associated with the column: HtlSelfCancel
	 */
	public java.lang.Byte getHtlSelfCancel () {
		return htlSelfCancel;
	}

	/**
	 * Set the value related to the column: HtlSelfCancel
	 * @param htlSelfCancel the HtlSelfCancel value
	 */
	public void setHtlSelfCancel (java.lang.Byte htlSelfCancel) {
		this.htlSelfCancel = htlSelfCancel;
	}



	/**
	 * Return the value associated with the column: LcbSelfCancel
	 */
	public java.lang.Byte getLcbSelfCancel () {
		return lcbSelfCancel;
	}

	/**
	 * Set the value related to the column: LcbSelfCancel
	 * @param lcbSelfCancel the LcbSelfCancel value
	 */
	public void setLcbSelfCancel (java.lang.Byte lcbSelfCancel) {
		this.lcbSelfCancel = lcbSelfCancel;
	}



	/**
	 * Return the value associated with the column: HtlCancelReq
	 */
	public java.lang.String getHtlCancelReq () {
		return htlCancelReq;
	}

	/**
	 * Set the value related to the column: HtlCancelReq
	 * @param htlCancelReq the HtlCancelReq value
	 */
	public void setHtlCancelReq (java.lang.String htlCancelReq) {
		this.htlCancelReq = htlCancelReq;
	}



	/**
	 * Return the value associated with the column: LcbCancelReq
	 */
	public java.lang.String getLcbCancelReq () {
		return lcbCancelReq;
	}

	/**
	 * Set the value related to the column: LcbCancelReq
	 * @param lcbCancelReq the LcbCancelReq value
	 */
	public void setLcbCancelReq (java.lang.String lcbCancelReq) {
		this.lcbCancelReq = lcbCancelReq;
	}



	/**
	 * Return the value associated with the column: HtlCancelDesc
	 */
	public java.lang.String getHtlCancelDesc () {
		return htlCancelDesc;
	}

	/**
	 * Set the value related to the column: HtlCancelDesc
	 * @param htlCancelDesc the HtlCancelDesc value
	 */
	public void setHtlCancelDesc (java.lang.String htlCancelDesc) {
		this.htlCancelDesc = htlCancelDesc;
	}



	/**
	 * Return the value associated with the column: LcbCancelDesc
	 */
	public java.lang.String getLcbCancelDesc () {
		return lcbCancelDesc;
	}

	/**
	 * Set the value related to the column: LcbCancelDesc
	 * @param lcbCancelDesc the LcbCancelDesc value
	 */
	public void setLcbCancelDesc (java.lang.String lcbCancelDesc) {
		this.lcbCancelDesc = lcbCancelDesc;
	}



	/**
	 * Return the value associated with the column: HtlCancelSts
	 */
	public java.lang.Integer getHtlCancelSts () {
		return htlCancelSts;
	}

	/**
	 * Set the value related to the column: HtlCancelSts
	 * @param htlCancelSts the HtlCancelSts value
	 */
	public void setHtlCancelSts (java.lang.Integer htlCancelSts) {
		this.htlCancelSts = htlCancelSts;
	}



	/**
	 * Return the value associated with the column: LcbCancelSts
	 */
	public java.lang.Integer getLcbCancelSts () {
		return lcbCancelSts;
	}

	/**
	 * Set the value related to the column: LcbCancelSts
	 * @param lcbCancelSts the LcbCancelSts value
	 */
	public void setLcbCancelSts (java.lang.Integer lcbCancelSts) {
		this.lcbCancelSts = lcbCancelSts;
	}



	/**
	 * Return the value associated with the column: LcbCnclApprBy
	 */
	public java.lang.Integer getLcbCnclApprBy () {
		return lcbCnclApprBy;
	}

	/**
	 * Set the value related to the column: LcbCnclApprBy
	 * @param lcbCnclApprBy the LcbCnclApprBy value
	 */
	public void setLcbCnclApprBy (java.lang.Integer lcbCnclApprBy) {
		this.lcbCnclApprBy = lcbCnclApprBy;
	}



	/**
	 * Return the value associated with the column: LcbcnclApprAt
	 */
	public java.util.Date getLcbcnclApprAt () {
		return lcbcnclApprAt;
	}

	/**
	 * Set the value related to the column: LcbcnclApprAt
	 * @param lcbcnclApprAt the LcbcnclApprAt value
	 */
	public void setLcbcnclApprAt (java.util.Date lcbcnclApprAt) {
		this.lcbcnclApprAt = lcbcnclApprAt;
	}



	/**
	 * Return the value associated with the column: htlbook
	 */
	public java.lang.Byte getHtlbook () {
		return htlbook;
	}

	/**
	 * Set the value related to the column: htlbook
	 * @param htlbook the htlbook value
	 */
	public void setHtlbook (java.lang.Byte htlbook) {
		this.htlbook = htlbook;
	}



	/**
	 * Return the value associated with the column: lcbbook
	 */
	public java.lang.Byte getLcbbook () {
		return lcbbook;
	}

	/**
	 * Set the value related to the column: lcbbook
	 * @param lcbbook the lcbbook value
	 */
	public void setLcbbook (java.lang.Byte lcbbook) {
		this.lcbbook = lcbbook;
	}



	/**
	 * Return the value associated with the column: HtlCnclApprBy
	 */
	public java.lang.Integer getHtlCnclApprBy () {
		return htlCnclApprBy;
	}

	/**
	 * Set the value related to the column: HtlCnclApprBy
	 * @param htlCnclApprBy the HtlCnclApprBy value
	 */
	public void setHtlCnclApprBy (java.lang.Integer htlCnclApprBy) {
		this.htlCnclApprBy = htlCnclApprBy;
	}



	/**
	 * Return the value associated with the column: HtlCnclApprAt
	 */
	public java.util.Date getHtlCnclApprAt () {
		return htlCnclApprAt;
	}

	/**
	 * Set the value related to the column: HtlCnclApprAt
	 * @param htlCnclApprAt the HtlCnclApprAt value
	 */
	public void setHtlCnclApprAt (java.util.Date htlCnclApprAt) {
		this.htlCnclApprAt = htlCnclApprAt;
	}



	/**
	 * Return the value associated with the column: Htcnclappcmts
	 */
	public java.lang.String getHtcnclappcmts () {
		return htcnclappcmts;
	}

	/**
	 * Set the value related to the column: Htcnclappcmts
	 * @param htcnclappcmts the Htcnclappcmts value
	 */
	public void setHtcnclappcmts (java.lang.String htcnclappcmts) {
		this.htcnclappcmts = htcnclappcmts;
	}



	/**
	 * Return the value associated with the column: Lcbcnclappcmts
	 */
	public java.lang.String getLcbcnclappcmts () {
		return lcbcnclappcmts;
	}

	/**
	 * Set the value related to the column: Lcbcnclappcmts
	 * @param lcbcnclappcmts the Lcbcnclappcmts value
	 */
	public void setLcbcnclappcmts (java.lang.String lcbcnclappcmts) {
		this.lcbcnclappcmts = lcbcnclappcmts;
	}



	/**
	 * Return the value associated with the column: HtlCnclappsts
	 */
	public java.lang.String getHtlCnclappsts () {
		return htlCnclappsts;
	}

	/**
	 * Set the value related to the column: HtlCnclappsts
	 * @param htlCnclappsts the HtlCnclappsts value
	 */
	public void setHtlCnclappsts (java.lang.String htlCnclappsts) {
		this.htlCnclappsts = htlCnclappsts;
	}



	/**
	 * Return the value associated with the column: Lcbcnclappsts
	 */
	public java.lang.String getLcbcnclappsts () {
		return lcbcnclappsts;
	}

	/**
	 * Set the value related to the column: Lcbcnclappsts
	 * @param lcbcnclappsts the Lcbcnclappsts value
	 */
	public void setLcbcnclappsts (java.lang.String lcbcnclappsts) {
		this.lcbcnclappsts = lcbcnclappsts;
	}



	/**
	 * Return the value associated with the column: trv_id
	 */
	public jkt.hrms.masters.business.EtrTravelreq getTrv () {
		return trv;
	}

	/**
	 * Set the value related to the column: trv_id
	 * @param trv the trv_id value
	 */
	public void setTrv (jkt.hrms.masters.business.EtrTravelreq trv) {
		this.trv = trv;
	}



	/**
	 * Return the value associated with the column: ModifiedBy
	 */
	public jkt.hms.masters.business.MasEmployee getModifiedBy () {
		return modifiedBy;
	}

	/**
	 * Set the value related to the column: ModifiedBy
	 * @param modifiedBy the ModifiedBy value
	 */
	public void setModifiedBy (jkt.hms.masters.business.MasEmployee modifiedBy) {
		this.modifiedBy = modifiedBy;
	}



	/**
	 * Return the value associated with the column: CreatedBy
	 */
	public jkt.hms.masters.business.MasEmployee getCreatedBy () {
		return createdBy;
	}

	/**
	 * Set the value related to the column: CreatedBy
	 * @param createdBy the CreatedBy value
	 */
	public void setCreatedBy (jkt.hms.masters.business.MasEmployee createdBy) {
		this.createdBy = createdBy;
	}



	/**
	 * Return the value associated with the column: EtrTicketdetails
	 */
	public java.util.Set<jkt.hrms.masters.business.EtrTicketdetails> getEtrTicketdetails () {
		return etrTicketdetails;
	}

	/**
	 * Set the value related to the column: EtrTicketdetails
	 * @param etrTicketdetails the EtrTicketdetails value
	 */
	public void setEtrTicketdetails (java.util.Set<jkt.hrms.masters.business.EtrTicketdetails> etrTicketdetails) {
		this.etrTicketdetails = etrTicketdetails;
	}

	public void addToEtrTicketdetails (jkt.hrms.masters.business.EtrTicketdetails etrTicketdetails) {
		if (null == getEtrTicketdetails()) setEtrTicketdetails(new java.util.TreeSet<jkt.hrms.masters.business.EtrTicketdetails>());
		getEtrTicketdetails().add(etrTicketdetails);
	}



	/**
	 * Return the value associated with the column: EtrBookeddtlsAttachs
	 */
	public java.util.Set<jkt.hrms.masters.business.EtrBookeddtlsAttach> getEtrBookeddtlsAttachs () {
		return etrBookeddtlsAttachs;
	}

	/**
	 * Set the value related to the column: EtrBookeddtlsAttachs
	 * @param etrBookeddtlsAttachs the EtrBookeddtlsAttachs value
	 */
	public void setEtrBookeddtlsAttachs (java.util.Set<jkt.hrms.masters.business.EtrBookeddtlsAttach> etrBookeddtlsAttachs) {
		this.etrBookeddtlsAttachs = etrBookeddtlsAttachs;
	}

	public void addToEtrBookeddtlsAttachs (jkt.hrms.masters.business.EtrBookeddtlsAttach etrBookeddtlsAttach) {
		if (null == getEtrBookeddtlsAttachs()) setEtrBookeddtlsAttachs(new java.util.TreeSet<jkt.hrms.masters.business.EtrBookeddtlsAttach>());
		getEtrBookeddtlsAttachs().add(etrBookeddtlsAttach);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.EtrFillbookeddtls)) return false;
		else {
			jkt.hrms.masters.business.EtrFillbookeddtls etrFillbookeddtls = (jkt.hrms.masters.business.EtrFillbookeddtls) obj;
			if (null == this.getId() || null == etrFillbookeddtls.getId()) return false;
			else return (this.getId().equals(etrFillbookeddtls.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}