package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hmis_parameter_mapping table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hmis_parameter_mapping"
 */

public abstract class BaseHmisParameterMapping  implements Serializable {

	public static String REF = "HmisParameterMapping";
	public static String PROP_ITEM_ID = "ItemId";
	public static String PROP_ITEM_CATEGORY = "ItemCategory";
	public static String PROP_ITEM_NAME = "ItemName";
	public static String PROP_ID = "Id";
	public static String PROP_PARAMETER_ID = "ParameterId";


	// constructors
	public BaseHmisParameterMapping () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHmisParameterMapping (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String parameterId;
	private java.lang.Long itemId;
	private java.lang.String itemName;
	private java.lang.String itemCategory;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="hmis_parameter_mapping_id"
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
	 * Return the value associated with the column: parameter_id
	 */
	public java.lang.String getParameterId () {
		return parameterId;
	}

	/**
	 * Set the value related to the column: parameter_id
	 * @param parameterId the parameter_id value
	 */
	public void setParameterId (java.lang.String parameterId) {
		this.parameterId = parameterId;
	}



	/**
	 * Return the value associated with the column: item_id
	 */
	public java.lang.Long getItemId () {
		return itemId;
	}

	/**
	 * Set the value related to the column: item_id
	 * @param itemId the item_id value
	 */
	public void setItemId (java.lang.Long itemId) {
		this.itemId = itemId;
	}



	/**
	 * Return the value associated with the column: item_name
	 */
	public java.lang.String getItemName () {
		return itemName;
	}

	/**
	 * Set the value related to the column: item_name
	 * @param itemName the item_name value
	 */
	public void setItemName (java.lang.String itemName) {
		this.itemName = itemName;
	}



	/**
	 * Return the value associated with the column: item_category
	 */
	public java.lang.String getItemCategory () {
		return itemCategory;
	}

	/**
	 * Set the value related to the column: item_category
	 * @param itemCategory the item_category value
	 */
	public void setItemCategory (java.lang.String itemCategory) {
		this.itemCategory = itemCategory;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HmisParameterMapping)) return false;
		else {
			jkt.hms.masters.business.HmisParameterMapping hmisParameterMapping = (jkt.hms.masters.business.HmisParameterMapping) obj;
			if (null == this.getId() || null == hmisParameterMapping.getId()) return false;
			else return (this.getId().equals(hmisParameterMapping.getId()));
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