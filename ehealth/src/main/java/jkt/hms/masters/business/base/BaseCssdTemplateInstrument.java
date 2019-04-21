package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the cssd_template_instrument table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="cssd_template_instrument"
 */


public abstract class BaseCssdTemplateInstrument  implements Serializable {

	public static String REF = "CssdTemplateInstrument";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TEMPLATE = "Template";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_INSTRUMENT = "Instrument";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseCssdTemplateInstrument () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCssdTemplateInstrument (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCssdTemplateInstrument (
		java.lang.Integer id,
		jkt.hms.masters.business.CssdInstrumentMaster instrument,
		jkt.hms.masters.business.OpdTemplate template) {

		this.setId(id);
		this.setInstrument(instrument);
		this.setTemplate(template);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.CssdInstrumentMaster instrument;
	private jkt.hms.masters.business.OpdTemplate template;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="cssd_template_item_id"
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
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: instrument_id
	 */
	public jkt.hms.masters.business.CssdInstrumentMaster getInstrument () {
		return instrument;
	}

	/**
	 * Set the value related to the column: instrument_id
	 * @param instrument the instrument_id value
	 */
	public void setInstrument (jkt.hms.masters.business.CssdInstrumentMaster instrument) {
		this.instrument = instrument;
	}



	/**
	 * Return the value associated with the column: template_id
	 */
	public jkt.hms.masters.business.OpdTemplate getTemplate () {
		return template;
	}

	/**
	 * Set the value related to the column: template_id
	 * @param template the template_id value
	 */
	public void setTemplate (jkt.hms.masters.business.OpdTemplate template) {
		this.template = template;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.CssdTemplateInstrument)) return false;
		else {
			jkt.hms.masters.business.CssdTemplateInstrument cssdTemplateInstrument = (jkt.hms.masters.business.CssdTemplateInstrument) obj;
			if (null == this.getId() || null == cssdTemplateInstrument.getId()) return false;
			else return (this.getId().equals(cssdTemplateInstrument.getId()));
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