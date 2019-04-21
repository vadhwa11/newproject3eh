package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_speciality_dept_group table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_speciality_dept_group"
 */

public abstract class BaseMasSpecialityDeptGroup  implements Serializable {

	public static String REF = "MasSpecialityDeptGroup";
	public static String PROP_VALIDATION_VALUE = "ValidationValue";
	public static String PROP_COMPLEX_FORM_TYPE = "ComplexFormType";
	public static String PROP_MULTIPLE_SELECTION = "MultipleSelection";
	public static String PROP_DATA_TYPE = "DataType";
	public static String PROP_VALUE_TYPE = "ValueType";
	public static String PROP_SIMPLE_FORM_TYPE = "SimpleFormType";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_TEXT_COLOR = "TextColor";
	public static String PROP_NO_OF_FIELDS = "NoOfFields";
	public static String PROP_PARAMETER_SERIAL_NO = "ParameterSerialNo";
	public static String PROP_NAD_REQUIRED = "NadRequired";
	public static String PROP_MEDIUM_FORM_TYPE = "MediumFormType";
	public static String PROP_GROUP_SERIAL_NO = "GroupSerialNo";
	public static String PROP_IMAGE_REQ = "ImageReq";
	public static String PROP_TEXT_SIZE = "TextSize";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TEXT_FONT = "TextFont";
	public static String PROP_DATE_FIELD = "DateField";
	public static String PROP_TEXT_MAXLENGTH = "TextMaxlength";
	public static String PROP_GRID = "Grid";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_TEMPLATE = "Template";
	public static String PROP_TEXT_FIELD = "TextField";
	public static String PROP_PARAMETER_SEQ_NO = "ParameterSeqNo";
	public static String PROP_EXTRA_LOV = "ExtraLov";
	public static String PROP_STATUS = "Status";
	public static String PROP_SP_GROUP = "SpGroup";
	public static String PROP_RADIO_TEXT2 = "RadioText2";
	public static String PROP_UNIT_LABEL = "UnitLabel";
	public static String PROP_RADIO_TEXT1 = "RadioText1";
	public static String PROP_ID = "Id";
	public static String PROP_RADIO_DEFAULT1 = "RadioDefault1";
	public static String PROP_RADIO_DEFAULT2 = "RadioDefault2";
	public static String PROP_GROUP_SEQ_NO = "GroupSeqNo";


	// constructors
	public BaseMasSpecialityDeptGroup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasSpecialityDeptGroup (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String valueType;
	private java.lang.String imageReq;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Integer groupSeqNo;
	private java.lang.Integer parameterSeqNo;
	private java.lang.Integer groupSerialNo;
	private java.lang.Integer parameterSerialNo;
	private java.lang.String textField;
	private java.lang.String nadRequired;
	private java.lang.Integer noOfFields;
	private java.lang.String dateField;
	private java.lang.String multipleSelection;
	private java.lang.String grid;
	private java.lang.String simpleFormType;
	private java.lang.String mediumFormType;
	private java.lang.String complexFormType;
	private java.lang.String radioText1;
	private java.lang.String radioDefault1;
	private java.lang.String radioText2;
	private java.lang.String radioDefault2;
	private java.lang.String unitLabel;
	private java.lang.Integer textMaxlength;
	private java.lang.String dataType;
	private java.lang.String extraLov;
	private java.lang.String textColor;
	private java.lang.String textFont;
	private java.lang.String textSize;
	private java.lang.String validationValue;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasSpecialtyTemplate template;
	private jkt.hms.masters.business.MasSpecialtyGroupParameter spGroup;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="dept_group_id"
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
	 * Return the value associated with the column: value_type
	 */
	public java.lang.String getValueType () {
		return valueType;
	}

	/**
	 * Set the value related to the column: value_type
	 * @param valueType the value_type value
	 */
	public void setValueType (java.lang.String valueType) {
		this.valueType = valueType;
	}



	/**
	 * Return the value associated with the column: image_req
	 */
	public java.lang.String getImageReq () {
		return imageReq;
	}

	/**
	 * Set the value related to the column: image_req
	 * @param imageReq the image_req value
	 */
	public void setImageReq (java.lang.String imageReq) {
		this.imageReq = imageReq;
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
	 * Return the value associated with the column: group_seq_no
	 */
	public java.lang.Integer getGroupSeqNo () {
		return groupSeqNo;
	}

	/**
	 * Set the value related to the column: group_seq_no
	 * @param groupSeqNo the group_seq_no value
	 */
	public void setGroupSeqNo (java.lang.Integer groupSeqNo) {
		this.groupSeqNo = groupSeqNo;
	}



	/**
	 * Return the value associated with the column: parameter_seq_no
	 */
	public java.lang.Integer getParameterSeqNo () {
		return parameterSeqNo;
	}

	/**
	 * Set the value related to the column: parameter_seq_no
	 * @param parameterSeqNo the parameter_seq_no value
	 */
	public void setParameterSeqNo (java.lang.Integer parameterSeqNo) {
		this.parameterSeqNo = parameterSeqNo;
	}



	/**
	 * Return the value associated with the column: group_serial_no
	 */
	public java.lang.Integer getGroupSerialNo () {
		return groupSerialNo;
	}

	/**
	 * Set the value related to the column: group_serial_no
	 * @param groupSerialNo the group_serial_no value
	 */
	public void setGroupSerialNo (java.lang.Integer groupSerialNo) {
		this.groupSerialNo = groupSerialNo;
	}



	/**
	 * Return the value associated with the column: parameter_serial_no
	 */
	public java.lang.Integer getParameterSerialNo () {
		return parameterSerialNo;
	}

	/**
	 * Set the value related to the column: parameter_serial_no
	 * @param parameterSerialNo the parameter_serial_no value
	 */
	public void setParameterSerialNo (java.lang.Integer parameterSerialNo) {
		this.parameterSerialNo = parameterSerialNo;
	}



	/**
	 * Return the value associated with the column: text_field
	 */
	public java.lang.String getTextField () {
		return textField;
	}

	/**
	 * Set the value related to the column: text_field
	 * @param textField the text_field value
	 */
	public void setTextField (java.lang.String textField) {
		this.textField = textField;
	}



	/**
	 * Return the value associated with the column: nad_required
	 */
	public java.lang.String getNadRequired () {
		return nadRequired;
	}

	/**
	 * Set the value related to the column: nad_required
	 * @param nadRequired the nad_required value
	 */
	public void setNadRequired (java.lang.String nadRequired) {
		this.nadRequired = nadRequired;
	}



	/**
	 * Return the value associated with the column: no_of_fields
	 */
	public java.lang.Integer getNoOfFields () {
		return noOfFields;
	}

	/**
	 * Set the value related to the column: no_of_fields
	 * @param noOfFields the no_of_fields value
	 */
	public void setNoOfFields (java.lang.Integer noOfFields) {
		this.noOfFields = noOfFields;
	}



	/**
	 * Return the value associated with the column: date_field
	 */
	public java.lang.String getDateField () {
		return dateField;
	}

	/**
	 * Set the value related to the column: date_field
	 * @param dateField the date_field value
	 */
	public void setDateField (java.lang.String dateField) {
		this.dateField = dateField;
	}



	/**
	 * Return the value associated with the column: multiple_selection
	 */
	public java.lang.String getMultipleSelection () {
		return multipleSelection;
	}

	/**
	 * Set the value related to the column: multiple_selection
	 * @param multipleSelection the multiple_selection value
	 */
	public void setMultipleSelection (java.lang.String multipleSelection) {
		this.multipleSelection = multipleSelection;
	}



	/**
	 * Return the value associated with the column: grid
	 */
	public java.lang.String getGrid () {
		return grid;
	}

	/**
	 * Set the value related to the column: grid
	 * @param grid the grid value
	 */
	public void setGrid (java.lang.String grid) {
		this.grid = grid;
	}



	/**
	 * Return the value associated with the column: simple_form_type
	 */
	public java.lang.String getSimpleFormType () {
		return simpleFormType;
	}

	/**
	 * Set the value related to the column: simple_form_type
	 * @param simpleFormType the simple_form_type value
	 */
	public void setSimpleFormType (java.lang.String simpleFormType) {
		this.simpleFormType = simpleFormType;
	}



	/**
	 * Return the value associated with the column: medium_form_type
	 */
	public java.lang.String getMediumFormType () {
		return mediumFormType;
	}

	/**
	 * Set the value related to the column: medium_form_type
	 * @param mediumFormType the medium_form_type value
	 */
	public void setMediumFormType (java.lang.String mediumFormType) {
		this.mediumFormType = mediumFormType;
	}



	/**
	 * Return the value associated with the column: complex_form_type
	 */
	public java.lang.String getComplexFormType () {
		return complexFormType;
	}

	/**
	 * Set the value related to the column: complex_form_type
	 * @param complexFormType the complex_form_type value
	 */
	public void setComplexFormType (java.lang.String complexFormType) {
		this.complexFormType = complexFormType;
	}



	/**
	 * Return the value associated with the column: radio_text1
	 */
	public java.lang.String getRadioText1 () {
		return radioText1;
	}

	/**
	 * Set the value related to the column: radio_text1
	 * @param radioText1 the radio_text1 value
	 */
	public void setRadioText1 (java.lang.String radioText1) {
		this.radioText1 = radioText1;
	}



	/**
	 * Return the value associated with the column: radio_default1
	 */
	public java.lang.String getRadioDefault1 () {
		return radioDefault1;
	}

	/**
	 * Set the value related to the column: radio_default1
	 * @param radioDefault1 the radio_default1 value
	 */
	public void setRadioDefault1 (java.lang.String radioDefault1) {
		this.radioDefault1 = radioDefault1;
	}



	/**
	 * Return the value associated with the column: radio_text2
	 */
	public java.lang.String getRadioText2 () {
		return radioText2;
	}

	/**
	 * Set the value related to the column: radio_text2
	 * @param radioText2 the radio_text2 value
	 */
	public void setRadioText2 (java.lang.String radioText2) {
		this.radioText2 = radioText2;
	}



	/**
	 * Return the value associated with the column: radio_default2
	 */
	public java.lang.String getRadioDefault2 () {
		return radioDefault2;
	}

	/**
	 * Set the value related to the column: radio_default2
	 * @param radioDefault2 the radio_default2 value
	 */
	public void setRadioDefault2 (java.lang.String radioDefault2) {
		this.radioDefault2 = radioDefault2;
	}



	/**
	 * Return the value associated with the column: unit_label
	 */
	public java.lang.String getUnitLabel () {
		return unitLabel;
	}

	/**
	 * Set the value related to the column: unit_label
	 * @param unitLabel the unit_label value
	 */
	public void setUnitLabel (java.lang.String unitLabel) {
		this.unitLabel = unitLabel;
	}



	/**
	 * Return the value associated with the column: text_maxlength
	 */
	public java.lang.Integer getTextMaxlength () {
		return textMaxlength;
	}

	/**
	 * Set the value related to the column: text_maxlength
	 * @param textMaxlength the text_maxlength value
	 */
	public void setTextMaxlength (java.lang.Integer textMaxlength) {
		this.textMaxlength = textMaxlength;
	}



	/**
	 * Return the value associated with the column: data_type
	 */
	public java.lang.String getDataType () {
		return dataType;
	}

	/**
	 * Set the value related to the column: data_type
	 * @param dataType the data_type value
	 */
	public void setDataType (java.lang.String dataType) {
		this.dataType = dataType;
	}



	/**
	 * Return the value associated with the column: extra_lov
	 */
	public java.lang.String getExtraLov () {
		return extraLov;
	}

	/**
	 * Set the value related to the column: extra_lov
	 * @param extraLov the extra_lov value
	 */
	public void setExtraLov (java.lang.String extraLov) {
		this.extraLov = extraLov;
	}



	/**
	 * Return the value associated with the column: text_color
	 */
	public java.lang.String getTextColor () {
		return textColor;
	}

	/**
	 * Set the value related to the column: text_color
	 * @param textColor the text_color value
	 */
	public void setTextColor (java.lang.String textColor) {
		this.textColor = textColor;
	}



	/**
	 * Return the value associated with the column: text_font
	 */
	public java.lang.String getTextFont () {
		return textFont;
	}

	/**
	 * Set the value related to the column: text_font
	 * @param textFont the text_font value
	 */
	public void setTextFont (java.lang.String textFont) {
		this.textFont = textFont;
	}



	/**
	 * Return the value associated with the column: text_size
	 */
	public java.lang.String getTextSize () {
		return textSize;
	}

	/**
	 * Set the value related to the column: text_size
	 * @param textSize the text_size value
	 */
	public void setTextSize (java.lang.String textSize) {
		this.textSize = textSize;
	}



	/**
	 * Return the value associated with the column: validation_value
	 */
	public java.lang.String getValidationValue () {
		return validationValue;
	}

	/**
	 * Set the value related to the column: validation_value
	 * @param validationValue the validation_value value
	 */
	public void setValidationValue (java.lang.String validationValue) {
		this.validationValue = validationValue;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: template_id
	 */
	public jkt.hms.masters.business.MasSpecialtyTemplate getTemplate () {
		return template;
	}

	/**
	 * Set the value related to the column: template_id
	 * @param template the template_id value
	 */
	public void setTemplate (jkt.hms.masters.business.MasSpecialtyTemplate template) {
		this.template = template;
	}



	/**
	 * Return the value associated with the column: sp_group_id
	 */
	public jkt.hms.masters.business.MasSpecialtyGroupParameter getSpGroup () {
		return spGroup;
	}

	/**
	 * Set the value related to the column: sp_group_id
	 * @param spGroup the sp_group_id value
	 */
	public void setSpGroup (jkt.hms.masters.business.MasSpecialtyGroupParameter spGroup) {
		this.spGroup = spGroup;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasSpecialityDeptGroup)) return false;
		else {
			jkt.hms.masters.business.MasSpecialityDeptGroup masSpecialityDeptGroup = (jkt.hms.masters.business.MasSpecialityDeptGroup) obj;
			if (null == this.getId() || null == masSpecialityDeptGroup.getId()) return false;
			else return (this.getId().equals(masSpecialityDeptGroup.getId()));
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