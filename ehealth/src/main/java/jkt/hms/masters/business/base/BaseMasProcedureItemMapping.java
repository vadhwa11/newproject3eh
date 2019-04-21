package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_procedure_item_mapping table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_procedure_item_mapping"
 */

public abstract class BaseMasProcedureItemMapping  implements Serializable {

	public static String REF = "MasProcedureItemMapping";
	public static String PROP_ITEM = "Item";
	public static String PROP_PROCEDURE = "Procedure";
	public static String PROP_ID = "Id";


	// constructors
	public BaseMasProcedureItemMapping () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasProcedureItemMapping (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasNursingCare procedure;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
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
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem () {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * @param item the item_id value
	 */
	public void setItem (jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}



	/**
	 * Return the value associated with the column: procedure_id
	 */
	public jkt.hms.masters.business.MasNursingCare getProcedure () {
		return procedure;
	}

	/**
	 * Set the value related to the column: procedure_id
	 * @param procedure the procedure_id value
	 */
	public void setProcedure (jkt.hms.masters.business.MasNursingCare procedure) {
		this.procedure = procedure;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasProcedureItemMapping)) return false;
		else {
			jkt.hms.masters.business.MasProcedureItemMapping masProcedureItemMapping = (jkt.hms.masters.business.MasProcedureItemMapping) obj;
			if (null == this.getId() || null == masProcedureItemMapping.getId()) return false;
			else return (this.getId().equals(masProcedureItemMapping.getId()));
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