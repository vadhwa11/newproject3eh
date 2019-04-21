package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_inspection_soft_tissue table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_inspection_soft_tissue"
 */

public abstract class BaseOpdInspectionSoftTissue  implements Serializable {

	public static String REF = "OpdInspectionSoftTissue";
	public static String PROP_DISCHARGE = "Discharge";
	public static String PROP_COLOUR = "Colour";
	public static String PROP_SHAPE = "Shape";
	public static String PROP_RIGHT_SOFT_TISSUE = "RightSoftTissue";
	public static String PROP_LEFT_SOFT_TISSUE = "LeftSoftTissue";
	public static String PROP_SITE = "Site";
	public static String PROP_FLAG = "Flag";
	public static String PROP_TYPE_OF_INJURY = "TypeOfInjury";
	public static String PROP_NUMBER_INSPECTION = "NumberInspection";
	public static String PROP_COMMENTS_SOFT_TISSUE = "CommentsSoftTissue";
	public static String PROP_SURFACE = "Surface";
	public static String PROP_ID = "Id";
	public static String PROP_ORAL_AND_MAXILLOFACIAL_SURGERY = "OralAndMaxillofacialSurgery";
	public static String PROP_SKIN_OVER_THE_SWELLING = "SkinOverTheSwelling";
	public static String PROP_SIZE = "Size";


	// constructors
	public BaseOpdInspectionSoftTissue () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdInspectionSoftTissue (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String flag;
	private java.lang.String size;
	private java.lang.String site;
	private java.lang.String numberInspection;
	private java.lang.String typeOfInjury;
	private java.lang.String commentsSoftTissue;
	private java.lang.String leftSoftTissue;
	private java.lang.String rightSoftTissue;
	private java.lang.String shape;
	private java.lang.String colour;
	private java.lang.String discharge;
	private java.lang.String surface;
	private java.lang.String skinOverTheSwelling;

	// many to one
	private jkt.hms.masters.business.OpdOralAndMaxillofacialSurgery oralAndMaxillofacialSurgery;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="inspection_soft_tissue_id"
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
	 * Return the value associated with the column: size
	 */
	public java.lang.String getSize () {
		return size;
	}

	/**
	 * Set the value related to the column: size
	 * @param size the size value
	 */
	public void setSize (java.lang.String size) {
		this.size = size;
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
	 * Return the value associated with the column: number_inspection
	 */
	public java.lang.String getNumberInspection () {
		return numberInspection;
	}

	/**
	 * Set the value related to the column: number_inspection
	 * @param numberInspection the number_inspection value
	 */
	public void setNumberInspection (java.lang.String numberInspection) {
		this.numberInspection = numberInspection;
	}



	/**
	 * Return the value associated with the column: type_of_injury
	 */
	public java.lang.String getTypeOfInjury () {
		return typeOfInjury;
	}

	/**
	 * Set the value related to the column: type_of_injury
	 * @param typeOfInjury the type_of_injury value
	 */
	public void setTypeOfInjury (java.lang.String typeOfInjury) {
		this.typeOfInjury = typeOfInjury;
	}



	/**
	 * Return the value associated with the column: comments_soft_tissue
	 */
	public java.lang.String getCommentsSoftTissue () {
		return commentsSoftTissue;
	}

	/**
	 * Set the value related to the column: comments_soft_tissue
	 * @param commentsSoftTissue the comments_soft_tissue value
	 */
	public void setCommentsSoftTissue (java.lang.String commentsSoftTissue) {
		this.commentsSoftTissue = commentsSoftTissue;
	}



	/**
	 * Return the value associated with the column: left_soft_tissue
	 */
	public java.lang.String getLeftSoftTissue () {
		return leftSoftTissue;
	}

	/**
	 * Set the value related to the column: left_soft_tissue
	 * @param leftSoftTissue the left_soft_tissue value
	 */
	public void setLeftSoftTissue (java.lang.String leftSoftTissue) {
		this.leftSoftTissue = leftSoftTissue;
	}



	/**
	 * Return the value associated with the column: right_soft_tissue
	 */
	public java.lang.String getRightSoftTissue () {
		return rightSoftTissue;
	}

	/**
	 * Set the value related to the column: right_soft_tissue
	 * @param rightSoftTissue the right_soft_tissue value
	 */
	public void setRightSoftTissue (java.lang.String rightSoftTissue) {
		this.rightSoftTissue = rightSoftTissue;
	}



	/**
	 * Return the value associated with the column: shape
	 */
	public java.lang.String getShape () {
		return shape;
	}

	/**
	 * Set the value related to the column: shape
	 * @param shape the shape value
	 */
	public void setShape (java.lang.String shape) {
		this.shape = shape;
	}



	/**
	 * Return the value associated with the column: colour
	 */
	public java.lang.String getColour () {
		return colour;
	}

	/**
	 * Set the value related to the column: colour
	 * @param colour the colour value
	 */
	public void setColour (java.lang.String colour) {
		this.colour = colour;
	}



	/**
	 * Return the value associated with the column: discharge
	 */
	public java.lang.String getDischarge () {
		return discharge;
	}

	/**
	 * Set the value related to the column: discharge
	 * @param discharge the discharge value
	 */
	public void setDischarge (java.lang.String discharge) {
		this.discharge = discharge;
	}



	/**
	 * Return the value associated with the column: surface
	 */
	public java.lang.String getSurface () {
		return surface;
	}

	/**
	 * Set the value related to the column: surface
	 * @param surface the surface value
	 */
	public void setSurface (java.lang.String surface) {
		this.surface = surface;
	}



	/**
	 * Return the value associated with the column: skin_over_the_swelling
	 */
	public java.lang.String getSkinOverTheSwelling () {
		return skinOverTheSwelling;
	}

	/**
	 * Set the value related to the column: skin_over_the_swelling
	 * @param skinOverTheSwelling the skin_over_the_swelling value
	 */
	public void setSkinOverTheSwelling (java.lang.String skinOverTheSwelling) {
		this.skinOverTheSwelling = skinOverTheSwelling;
	}



	/**
	 * Return the value associated with the column: oral_and_maxillofacial_surgery_id
	 */
	public jkt.hms.masters.business.OpdOralAndMaxillofacialSurgery getOralAndMaxillofacialSurgery () {
		return oralAndMaxillofacialSurgery;
	}

	/**
	 * Set the value related to the column: oral_and_maxillofacial_surgery_id
	 * @param oralAndMaxillofacialSurgery the oral_and_maxillofacial_surgery_id value
	 */
	public void setOralAndMaxillofacialSurgery (jkt.hms.masters.business.OpdOralAndMaxillofacialSurgery oralAndMaxillofacialSurgery) {
		this.oralAndMaxillofacialSurgery = oralAndMaxillofacialSurgery;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdInspectionSoftTissue)) return false;
		else {
			jkt.hms.masters.business.OpdInspectionSoftTissue opdInspectionSoftTissue = (jkt.hms.masters.business.OpdInspectionSoftTissue) obj;
			if (null == this.getId() || null == opdInspectionSoftTissue.getId()) return false;
			else return (this.getId().equals(opdInspectionSoftTissue.getId()));
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