package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the etr_ticketdetails table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="etr_ticketdetails"
 */

public abstract class BaseEtrTicketdetails  implements Serializable {

	public static String REF = "EtrTicketdetails";
	public static String PROP_AMT = "Amt";
	public static String PROP_FRMPLC = "Frmplc";
	public static String PROP_T_CNCLCMTS = "TCnclcmts";
	public static String PROP_FBDT = "Fbdt";
	public static String PROP_CUR = "Cur";
	public static String PROP_TICKET_CLASS = "TicketClass";
	public static String PROP_TO_COUNTRY = "ToCountry";
	public static String PROP_T_CNCLAPPAT = "TCnclappat";
	public static String PROP_T_CNCLAPPSTS = "TCnclappsts";
	public static String PROP_FROM_COUNTRY = "FromCountry";
	public static String PROP_MODE = "Mode";
	public static String PROP_SELFCANCEL = "Selfcancel";
	public static String PROP_TK_TYPE = "TkType";
	public static String PROP_FRMTO = "Frmto";
	public static String PROP_T_CNCLAPPBY = "TCnclappby";
	public static String PROP_ARR_TIME = "ArrTime";
	public static String PROP_ID = "Id";
	public static String PROP_TK_NO = "TkNo";
	public static String PROP_TICKET_DATE = "TicketDate";
	public static String PROP_DEPT_TIME = "DeptTime";
	public static String PROP_CANCEL_DESC = "CancelDesc";
	public static String PROP_CANCELREQ = "Cancelreq";


	// constructors
	public BaseEtrTicketdetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEtrTicketdetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String tkNo;
	private java.lang.String deptTime;
	private java.lang.String arrTime;
	private java.math.BigDecimal amt;
	private java.lang.Byte selfcancel;
	private java.lang.String cancelreq;
	private java.lang.String cancelDesc;
	private java.lang.Integer tCnclappby;
	private java.util.Date tCnclappat;
	private java.lang.String tCnclcmts;
	private java.lang.String tCnclappsts;
	private java.util.Date ticketDate;

	// many to one
	private jkt.hrms.masters.business.EtrFillbookeddtls fbdt;
	private jkt.hms.masters.business.MasCountry toCountry;
	private jkt.hrms.masters.business.MstrCode tkType;
	private jkt.hms.masters.business.MasDistrict frmplc;
	private jkt.hrms.masters.business.MstrCode mode;
	private jkt.hms.masters.business.MasCountry fromCountry;
	private jkt.hrms.masters.business.MstrCode ticketClass;
	private jkt.hms.masters.business.MasCurrency cur;
	private jkt.hms.masters.business.MasDistrict frmto;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="Tk_id"
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
	 * Return the value associated with the column: tk_no
	 */
	public java.lang.String getTkNo () {
		return tkNo;
	}

	/**
	 * Set the value related to the column: tk_no
	 * @param tkNo the tk_no value
	 */
	public void setTkNo (java.lang.String tkNo) {
		this.tkNo = tkNo;
	}



	/**
	 * Return the value associated with the column: Dept_time
	 */
	public java.lang.String getDeptTime () {
		return deptTime;
	}

	/**
	 * Set the value related to the column: Dept_time
	 * @param deptTime the Dept_time value
	 */
	public void setDeptTime (java.lang.String deptTime) {
		this.deptTime = deptTime;
	}



	/**
	 * Return the value associated with the column: arr_time
	 */
	public java.lang.String getArrTime () {
		return arrTime;
	}

	/**
	 * Set the value related to the column: arr_time
	 * @param arrTime the arr_time value
	 */
	public void setArrTime (java.lang.String arrTime) {
		this.arrTime = arrTime;
	}



	/**
	 * Return the value associated with the column: amt
	 */
	public java.math.BigDecimal getAmt () {
		return amt;
	}

	/**
	 * Set the value related to the column: amt
	 * @param amt the amt value
	 */
	public void setAmt (java.math.BigDecimal amt) {
		this.amt = amt;
	}



	/**
	 * Return the value associated with the column: selfcancel
	 */
	public java.lang.Byte getSelfcancel () {
		return selfcancel;
	}

	/**
	 * Set the value related to the column: selfcancel
	 * @param selfcancel the selfcancel value
	 */
	public void setSelfcancel (java.lang.Byte selfcancel) {
		this.selfcancel = selfcancel;
	}



	/**
	 * Return the value associated with the column: cancelreq
	 */
	public java.lang.String getCancelreq () {
		return cancelreq;
	}

	/**
	 * Set the value related to the column: cancelreq
	 * @param cancelreq the cancelreq value
	 */
	public void setCancelreq (java.lang.String cancelreq) {
		this.cancelreq = cancelreq;
	}



	/**
	 * Return the value associated with the column: CancelDesc
	 */
	public java.lang.String getCancelDesc () {
		return cancelDesc;
	}

	/**
	 * Set the value related to the column: CancelDesc
	 * @param cancelDesc the CancelDesc value
	 */
	public void setCancelDesc (java.lang.String cancelDesc) {
		this.cancelDesc = cancelDesc;
	}



	/**
	 * Return the value associated with the column: TCnclappby
	 */
	public java.lang.Integer getTCnclappby () {
		return tCnclappby;
	}

	/**
	 * Set the value related to the column: TCnclappby
	 * @param tCnclappby the TCnclappby value
	 */
	public void setTCnclappby (java.lang.Integer tCnclappby) {
		this.tCnclappby = tCnclappby;
	}



	/**
	 * Return the value associated with the column: TCnclappat
	 */
	public java.util.Date getTCnclappat () {
		return tCnclappat;
	}

	/**
	 * Set the value related to the column: TCnclappat
	 * @param tCnclappat the TCnclappat value
	 */
	public void setTCnclappat (java.util.Date tCnclappat) {
		this.tCnclappat = tCnclappat;
	}



	/**
	 * Return the value associated with the column: TCnclcmts
	 */
	public java.lang.String getTCnclcmts () {
		return tCnclcmts;
	}

	/**
	 * Set the value related to the column: TCnclcmts
	 * @param tCnclcmts the TCnclcmts value
	 */
	public void setTCnclcmts (java.lang.String tCnclcmts) {
		this.tCnclcmts = tCnclcmts;
	}



	/**
	 * Return the value associated with the column: TCnclappsts
	 */
	public java.lang.String getTCnclappsts () {
		return tCnclappsts;
	}

	/**
	 * Set the value related to the column: TCnclappsts
	 * @param tCnclappsts the TCnclappsts value
	 */
	public void setTCnclappsts (java.lang.String tCnclappsts) {
		this.tCnclappsts = tCnclappsts;
	}



	/**
	 * Return the value associated with the column: ticket_date
	 */
	public java.util.Date getTicketDate () {
		return ticketDate;
	}

	/**
	 * Set the value related to the column: ticket_date
	 * @param ticketDate the ticket_date value
	 */
	public void setTicketDate (java.util.Date ticketDate) {
		this.ticketDate = ticketDate;
	}



	/**
	 * Return the value associated with the column: Fbdt_id
	 */
	public jkt.hrms.masters.business.EtrFillbookeddtls getFbdt () {
		return fbdt;
	}

	/**
	 * Set the value related to the column: Fbdt_id
	 * @param fbdt the Fbdt_id value
	 */
	public void setFbdt (jkt.hrms.masters.business.EtrFillbookeddtls fbdt) {
		this.fbdt = fbdt;
	}



	/**
	 * Return the value associated with the column: to_country_id
	 */
	public jkt.hms.masters.business.MasCountry getToCountry () {
		return toCountry;
	}

	/**
	 * Set the value related to the column: to_country_id
	 * @param toCountry the to_country_id value
	 */
	public void setToCountry (jkt.hms.masters.business.MasCountry toCountry) {
		this.toCountry = toCountry;
	}



	/**
	 * Return the value associated with the column: tk_type
	 */
	public jkt.hrms.masters.business.MstrCode getTkType () {
		return tkType;
	}

	/**
	 * Set the value related to the column: tk_type
	 * @param tkType the tk_type value
	 */
	public void setTkType (jkt.hrms.masters.business.MstrCode tkType) {
		this.tkType = tkType;
	}



	/**
	 * Return the value associated with the column: frmplc_id
	 */
	public jkt.hms.masters.business.MasDistrict getFrmplc () {
		return frmplc;
	}

	/**
	 * Set the value related to the column: frmplc_id
	 * @param frmplc the frmplc_id value
	 */
	public void setFrmplc (jkt.hms.masters.business.MasDistrict frmplc) {
		this.frmplc = frmplc;
	}



	/**
	 * Return the value associated with the column: mode_id
	 */
	public jkt.hrms.masters.business.MstrCode getMode () {
		return mode;
	}

	/**
	 * Set the value related to the column: mode_id
	 * @param mode the mode_id value
	 */
	public void setMode (jkt.hrms.masters.business.MstrCode mode) {
		this.mode = mode;
	}



	/**
	 * Return the value associated with the column: from_country_id
	 */
	public jkt.hms.masters.business.MasCountry getFromCountry () {
		return fromCountry;
	}

	/**
	 * Set the value related to the column: from_country_id
	 * @param fromCountry the from_country_id value
	 */
	public void setFromCountry (jkt.hms.masters.business.MasCountry fromCountry) {
		this.fromCountry = fromCountry;
	}



	/**
	 * Return the value associated with the column: ticket_class
	 */
	public jkt.hrms.masters.business.MstrCode getTicketClass () {
		return ticketClass;
	}

	/**
	 * Set the value related to the column: ticket_class
	 * @param ticketClass the ticket_class value
	 */
	public void setTicketClass (jkt.hrms.masters.business.MstrCode ticketClass) {
		this.ticketClass = ticketClass;
	}



	/**
	 * Return the value associated with the column: cur_id
	 */
	public jkt.hms.masters.business.MasCurrency getCur () {
		return cur;
	}

	/**
	 * Set the value related to the column: cur_id
	 * @param cur the cur_id value
	 */
	public void setCur (jkt.hms.masters.business.MasCurrency cur) {
		this.cur = cur;
	}



	/**
	 * Return the value associated with the column: frmto_id
	 */
	public jkt.hms.masters.business.MasDistrict getFrmto () {
		return frmto;
	}

	/**
	 * Set the value related to the column: frmto_id
	 * @param frmto the frmto_id value
	 */
	public void setFrmto (jkt.hms.masters.business.MasDistrict frmto) {
		this.frmto = frmto;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.EtrTicketdetails)) return false;
		else {
			jkt.hrms.masters.business.EtrTicketdetails etrTicketdetails = (jkt.hrms.masters.business.EtrTicketdetails) obj;
			if (null == this.getId() || null == etrTicketdetails.getId()) return false;
			else return (this.getId().equals(etrTicketdetails.getId()));
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