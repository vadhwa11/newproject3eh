package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_dermatological_nerve_examination table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_dermatological_nerve_examination"
 */

public abstract class BaseOpdDermatologicalNerveExamination  implements Serializable {

	public static String REF = "OpdDermatologicalNerveExamination";
	public static String PROP_SITE = "Site";
	public static String PROP_FLAG = "Flag";
	public static String PROP_LEFT_NERVE = "LeftNerve";
	public static String PROP_TEMPERATURE = "Temperature";
	public static String PROP_RIGHT_NERVE = "RightNerve";
	public static String PROP_ID = "Id";
	public static String PROP_PAIN = "Pain";
	public static String PROP_NERVE = "Nerve";
	public static String PROP_LEPROSY_PROFORMA = "LeprosyProforma";
	public static String PROP_TOUCH = "Touch";


	// constructors
	public BaseOpdDermatologicalNerveExamination () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdDermatologicalNerveExamination (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String nerve;
	private java.lang.String rightNerve;
	private java.lang.String leftNerve;
	private java.lang.String flag;
	private java.lang.String site;
	private java.lang.String temperature;
	private java.lang.String touch;
	private java.lang.String pain;

	// many to one
	private jkt.hms.masters.business.OpdDermatologyLeprosyProforma leprosyProforma;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="nerve_examination_id"
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
	 * Return the value associated with the column: nerve
	 */
	public java.lang.String getNerve () {
		return nerve;
	}

	/**
	 * Set the value related to the column: nerve
	 * @param nerve the nerve value
	 */
	public void setNerve (java.lang.String nerve) {
		this.nerve = nerve;
	}



	/**
	 * Return the value associated with the column: right_nerve
	 */
	public java.lang.String getRightNerve () {
		return rightNerve;
	}

	/**
	 * Set the value related to the column: right_nerve
	 * @param rightNerve the right_nerve value
	 */
	public void setRightNerve (java.lang.String rightNerve) {
		this.rightNerve = rightNerve;
	}



	/**
	 * Return the value associated with the column: left_nerve
	 */
	public java.lang.String getLeftNerve () {
		return leftNerve;
	}

	/**
	 * Set the value related to the column: left_nerve
	 * @param leftNerve the left_nerve value
	 */
	public void setLeftNerve (java.lang.String leftNerve) {
		this.leftNerve = leftNerve;
	}



	/**
	 * Return the value associated with the column: flag
	 */
	public java.lang.String getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: flag
	 * @param flag the flag value
	 */
	public void setFlag (java.lang.String flag) {
		this.flag = flag;
	}



	/**
	 * Return the value associated with the column: site
	 */
	public java.lang.String getSite () {
		return site;
	}

	/**
	 * Set the value related to the column: site
	 * @param site the site value
	 */
	public void setSite (java.lang.String site) {
		this.site = site;
	}



	/**
	 * Return the value associated with the column: temperature
	 */
	public java.lang.String getTemperature () {
		return temperature;
	}

	/**
	 * Set the value related to the column: temperature
	 * @param temperature the temperature value
	 */
	public void setTemperature (java.lang.String temperature) {
		this.temperature = temperature;
	}



	/**
	 * Return the value associated with the column: touch
	 */
	public java.lang.String getTouch () {
		return touch;
	}

	/**
	 * Set the value related to the column: touch
	 * @param touch the touch value
	 */
	public void setTouch (java.lang.String touch) {
		this.touch = touch;
	}



	/**
	 * Return the value associated with the column: pain
	 */
	public java.lang.String getPain () {
		return pain;
	}

	/**
	 * Set the value related to the column: pain
	 * @param pain the pain value
	 */
	public void setPain (java.lang.String pain) {
		this.pain = pain;
	}



	/**
	 * Return the value associated with the column: leprosy_proforma_id
	 */
	public jkt.hms.masters.business.OpdDermatologyLeprosyProforma getLeprosyProforma () {
		return leprosyProforma;
	}

	/**
	 * Set the value related to the column: leprosy_proforma_id
	 * @param leprosyProforma the leprosy_proforma_id value
	 */
	public void setLeprosyProforma (jkt.hms.masters.business.OpdDermatologyLeprosyProforma leprosyProforma) {
		this.leprosyProforma = leprosyProforma;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdDermatologicalNerveExamination)) return false;
		else {
			jkt.hms.masters.business.OpdDermatologicalNerveExamination opdDermatologicalNerveExamination = (jkt.hms.masters.business.OpdDermatologicalNerveExamination) obj;
			if (null == this.getId() || null == opdDermatologicalNerveExamination.getId()) return false;
			else return (this.getId().equals(opdDermatologicalNerveExamination.getId()));
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