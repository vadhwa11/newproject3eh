package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_image_annotation table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_image_annotation"
 */

public abstract class BaseOpdImageAnnotation  implements Serializable {

	public static String REF = "OpdImageAnnotation";
	public static String PROP_TYPE = "Type";
	public static String PROP_SRC = "Src";
	public static String PROP_VISIT = "Visit";
	public static String PROP_TEMPLATE_NAME = "TemplateName";
	public static String PROP_TEXT = "Text";
	public static String PROP_HEIGHT = "Height";
	public static String PROP_X_COORDINATE = "XCoordinate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";
	public static String PROP_WIDTH = "Width";
	public static String PROP_Y_COORDINATE = "YCoordinate";


	// constructors
	public BaseOpdImageAnnotation () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdImageAnnotation (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String templateName;
	private java.lang.String src;
	private java.lang.String text;
	private java.lang.String height;
	private java.lang.String width;
	private java.lang.String xCoordinate;
	private java.lang.String yCoordinate;
	private java.lang.String type;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="image_annotation_id"
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
	 * Return the value associated with the column: template_name
	 */
	public java.lang.String getTemplateName () {
		return templateName;
	}

	/**
	 * Set the value related to the column: template_name
	 * @param templateName the template_name value
	 */
	public void setTemplateName (java.lang.String templateName) {
		this.templateName = templateName;
	}



	/**
	 * Return the value associated with the column: src
	 */
	public java.lang.String getSrc () {
		return src;
	}

	/**
	 * Set the value related to the column: src
	 * @param src the src value
	 */
	public void setSrc (java.lang.String src) {
		this.src = src;
	}



	/**
	 * Return the value associated with the column: text
	 */
	public java.lang.String getText () {
		return text;
	}

	/**
	 * Set the value related to the column: text
	 * @param text the text value
	 */
	public void setText (java.lang.String text) {
		this.text = text;
	}



	/**
	 * Return the value associated with the column: height
	 */
	public java.lang.String getHeight () {
		return height;
	}

	/**
	 * Set the value related to the column: height
	 * @param height the height value
	 */
	public void setHeight (java.lang.String height) {
		this.height = height;
	}



	/**
	 * Return the value associated with the column: width
	 */
	public java.lang.String getWidth () {
		return width;
	}

	/**
	 * Set the value related to the column: width
	 * @param width the width value
	 */
	public void setWidth (java.lang.String width) {
		this.width = width;
	}



	/**
	 * Return the value associated with the column: x_coordinate
	 */
	public java.lang.String getXCoordinate () {
		return xCoordinate;
	}

	/**
	 * Set the value related to the column: x_coordinate
	 * @param xCoordinate the x_coordinate value
	 */
	public void setXCoordinate (java.lang.String xCoordinate) {
		this.xCoordinate = xCoordinate;
	}



	/**
	 * Return the value associated with the column: y_coordinate
	 */
	public java.lang.String getYCoordinate () {
		return yCoordinate;
	}

	/**
	 * Set the value related to the column: y_coordinate
	 * @param yCoordinate the y_coordinate value
	 */
	public void setYCoordinate (java.lang.String yCoordinate) {
		this.yCoordinate = yCoordinate;
	}



	/**
	 * Return the value associated with the column: type
	 */
	public java.lang.String getType () {
		return type;
	}

	/**
	 * Set the value related to the column: type
	 * @param type the type value
	 */
	public void setType (java.lang.String type) {
		this.type = type;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}



	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdImageAnnotation)) return false;
		else {
			jkt.hms.masters.business.OpdImageAnnotation opdImageAnnotation = (jkt.hms.masters.business.OpdImageAnnotation) obj;
			if (null == this.getId() || null == opdImageAnnotation.getId()) return false;
			else return (this.getId().equals(opdImageAnnotation.getId()));
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