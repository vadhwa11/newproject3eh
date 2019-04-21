package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mlc_refered table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mlc_refered"
 */

public abstract class BaseMlcRefered  implements Serializable {

	public static String REF = "MlcRefered";
	public static String PROP_MLC_REFERED_FROM = "MlcReferedFrom";
	public static String PROP_ID = "Id";
	public static String PROP_REFERED_FROM_OTHERS = "ReferedFromOthers";


	// constructors
	public BaseMlcRefered () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMlcRefered (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String mlcReferedFrom;
	private java.lang.String referedFromOthers;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="mlc_refered_id"
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
	 * Return the value associated with the column: mlc_refered_from
	 */
	public java.lang.String getMlcReferedFrom () {
		return mlcReferedFrom;
	}

	/**
	 * Set the value related to the column: mlc_refered_from
	 * @param mlcReferedFrom the mlc_refered_from value
	 */
	public void setMlcReferedFrom (java.lang.String mlcReferedFrom) {
		this.mlcReferedFrom = mlcReferedFrom;
	}



	/**
	 * Return the value associated with the column: refered_from_others
	 */
	public java.lang.String getReferedFromOthers () {
		return referedFromOthers;
	}

	/**
	 * Set the value related to the column: refered_from_others
	 * @param referedFromOthers the refered_from_others value
	 */
	public void setReferedFromOthers (java.lang.String referedFromOthers) {
		this.referedFromOthers = referedFromOthers;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MlcRefered)) return false;
		else {
			jkt.hms.masters.business.MlcRefered mlcRefered = (jkt.hms.masters.business.MlcRefered) obj;
			if (null == this.getId() || null == mlcRefered.getId()) return false;
			else return (this.getId().equals(mlcRefered.getId()));
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