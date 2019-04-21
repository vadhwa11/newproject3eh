package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_lionc_sub_class table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_lionc_sub_class"
 */

public abstract class BaseMasLioncSubClass  implements Serializable {

	public static String REF = "MasLioncSubClass";
	public static String PROP_STATUS = "Status";
	public static String PROP_SUB_CHARGE_CODE = "SubChargeCode";
	public static String PROP_LION_C_CLASS = "LionCClass";
	public static String PROP_MAIN_CHARGE_CODE = "MainChargeCode";
	public static String PROP_LOIN_NUM= "LoincNum";

	public static String PROP_ID = "Id";


	// constructors
	public BaseMasLioncSubClass () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasLioncSubClass (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String lionCClass;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasMainChargecode mainChargeCode;
	private jkt.hms.masters.business.MasSubChargecode subChargeCode;
	private jkt.hms.masters.business.MasLionc lioncNum;

	
	

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="id"
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
	 * Return the value associated with the column: lionc_class
	 */
	public java.lang.String getLionCClass () {
		return lionCClass;
	}

	/**
	 * Set the value related to the column: lionc_class
	 * @param lionCClass the lionc_class value
	 */
	public void setLionCClass (java.lang.String lionCClass) {
		this.lionCClass = lionCClass;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	
	
	/**
	 * Return the value associated with the column: main_chargecode_id
	 */
	public jkt.hms.masters.business.MasMainChargecode getMainChargeCode () {
		return mainChargeCode;
	}

	/**
	 * Set the value related to the column: main_chargecode_id
	 * @param mainChargeCode the main_chargecode_id value
	 */
	public void setMainChargeCode (jkt.hms.masters.business.MasMainChargecode mainChargeCode) {
		this.mainChargeCode = mainChargeCode;
	}



	/**
	 * Return the value associated with the column: sub_chargecode_id
	 */
	public jkt.hms.masters.business.MasSubChargecode getSubChargeCode () {
		return subChargeCode;
	}

	/**
	 * Set the value related to the column: sub_chargecode_id
	 * @param subChargeCode the sub_chargecode_id value
	 */
	public void setSubChargeCode (jkt.hms.masters.business.MasSubChargecode subChargeCode) {
		this.subChargeCode = subChargeCode;
	}

	
	/**
	 * Return the value associated with the column: sub_chargecode_id
	 */
	public jkt.hms.masters.business.MasLionc getLoincNum () {
		return lioncNum;
	}

	/**
	 * Set the value related to the column: sub_chargecode_id
	 * @param subChargeCode the sub_chargecode_id value
	 */
	public void setLoincNum(jkt.hms.masters.business.MasLionc lioncNum) {
		this.lioncNum = lioncNum;
	}

	
	


	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasLioncSubClass)) return false;
		else {
			jkt.hms.masters.business.MasLioncSubClass masLioncSubClass = (jkt.hms.masters.business.MasLioncSubClass) obj;
			if (null == this.getId() || null == masLioncSubClass.getId()) return false;
			else return (this.getId().equals(masLioncSubClass.getId()));
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

	public void setLioncNum(jkt.hms.masters.business.MasLionc lioncNum) {
		this.lioncNum = lioncNum;
	}


}