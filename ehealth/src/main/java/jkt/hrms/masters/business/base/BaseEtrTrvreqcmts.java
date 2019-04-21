package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the etr_trvreqcmts table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="etr_trvreqcmts"
 */

public abstract class BaseEtrTrvreqcmts  implements Serializable {

	public static String REF = "EtrTrvreqcmts";
	public static String PROP_TRV = "Trv";
	public static String PROP_STR_STS = "StrSts";
	public static String PROP_ID = "Id";
	public static String PROP_CREATED_B_Y = "CreatedBY";
	public static String PROP_CREATED_AT = "CreatedAt";


	// constructors
	public BaseEtrTrvreqcmts () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEtrTrvreqcmts (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String strSts;
	private java.util.Date createdAt;

	// many to one
	private jkt.hrms.masters.business.EtrTravelreq trv;
	private jkt.hms.masters.business.MasEmployee createdBY;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="cmtsid"
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
	 * Return the value associated with the column: Str_sts
	 */
	public java.lang.String getStrSts () {
		return strSts;
	}

	/**
	 * Set the value related to the column: Str_sts
	 * @param strSts the Str_sts value
	 */
	public void setStrSts (java.lang.String strSts) {
		this.strSts = strSts;
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
	 * Return the value associated with the column: CreatedBY
	 */
	public jkt.hms.masters.business.MasEmployee getCreatedBY () {
		return createdBY;
	}

	/**
	 * Set the value related to the column: CreatedBY
	 * @param createdBY the CreatedBY value
	 */
	public void setCreatedBY (jkt.hms.masters.business.MasEmployee createdBY) {
		this.createdBY = createdBY;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.EtrTrvreqcmts)) return false;
		else {
			jkt.hrms.masters.business.EtrTrvreqcmts etrTrvreqcmts = (jkt.hrms.masters.business.EtrTrvreqcmts) obj;
			if (null == this.getId() || null == etrTrvreqcmts.getId()) return false;
			else return (this.getId().equals(etrTrvreqcmts.getId()));
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