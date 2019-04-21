package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mm_preventive_check_list table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mm_preventive_check_list"
 */

public abstract class BaseMmPreventiveCheckList  implements Serializable {

	public static String REF = "MmPreventiveCheckList";
	public static String PROP_EQUIPMENT = "Equipment";
	public static String PROP_ID = "Id";
	public static String PROP_CHECK_LIST_NAME = "CheckListName";
	public static String PROP_AMC = "Amc";


	// constructors
	public BaseMmPreventiveCheckList () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMmPreventiveCheckList (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String checkListName;

	// many to one
	private jkt.hms.masters.business.HesEquipmentAmcDetailsEntry amc;
	private jkt.hms.masters.business.HesEquipmentMaster equipment;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="check_list_id"
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
	 * Return the value associated with the column: check_list_name
	 */
	public java.lang.String getCheckListName () {
		return checkListName;
	}

	/**
	 * Set the value related to the column: check_list_name
	 * @param checkListName the check_list_name value
	 */
	public void setCheckListName (java.lang.String checkListName) {
		this.checkListName = checkListName;
	}



	/**
	 * Return the value associated with the column: amc_id
	 */
	public jkt.hms.masters.business.HesEquipmentAmcDetailsEntry getAmc () {
		return amc;
	}

	/**
	 * Set the value related to the column: amc_id
	 * @param amc the amc_id value
	 */
	public void setAmc (jkt.hms.masters.business.HesEquipmentAmcDetailsEntry amc) {
		this.amc = amc;
	}



	/**
	 * Return the value associated with the column: equipment_id
	 */
	public jkt.hms.masters.business.HesEquipmentMaster getEquipment () {
		return equipment;
	}

	/**
	 * Set the value related to the column: equipment_id
	 * @param equipment the equipment_id value
	 */
	public void setEquipment (jkt.hms.masters.business.HesEquipmentMaster equipment) {
		this.equipment = equipment;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MmPreventiveCheckList)) return false;
		else {
			jkt.hms.masters.business.MmPreventiveCheckList mmPreventiveCheckList = (jkt.hms.masters.business.MmPreventiveCheckList) obj;
			if (null == this.getId() || null == mmPreventiveCheckList.getId()) return false;
			else return (this.getId().equals(mmPreventiveCheckList.getId()));
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