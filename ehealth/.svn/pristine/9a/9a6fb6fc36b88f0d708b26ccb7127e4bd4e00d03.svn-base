package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_investigation_sample_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_investigation_sample_detail"
 */

public abstract class BasePhInvestigationSampleDetail  implements Serializable {

	public static String REF = "PhInvestigationSampleDetail";
	public static String PROP_STATUS = "Status";
	public static String PROP_DATE_OF_BIRTH = "DateOfBirth";
	public static String PROP_MEMBER_ID = "MemberId";
	public static String PROP_UNIQUE_ID = "UniqueId";
	public static String PROP_INVESTIGATION = "Investigation";
	public static String PROP_SUB_CENTRE = "SubCentre";
	public static String PROP_DATA_TYPE = "DataType";
	public static String PROP_REFER_HOSPITAL = "ReferHospital";
	public static String PROP_ID = "Id";
	public static String PROP_SMEAR_NO = "SmearNo";
	public static String PROP_REFER_TYPE = "ReferType";
	public static String PROP_NAME = "Name";


	// constructors
	public BasePhInvestigationSampleDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhInvestigationSampleDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Long memberId;
	private java.lang.String status;
	private java.lang.String uniqueId;
	private java.lang.String smearNo;
	private java.lang.String dataType;
	private java.lang.Long referType;
	private java.lang.String name;
	private java.util.Date dateOfBirth;

	// many to one
	private jkt.hms.masters.business.MasHospital referHospital;
	private jkt.hms.masters.business.DgMasInvestigation investigation;
	private jkt.hms.masters.business.MasHospital subCentre;



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
	 * Return the value associated with the column: member_id
	 */
	public java.lang.Long getMemberId () {
		return memberId;
	}

	/**
	 * Set the value related to the column: member_id
	 * @param memberId the member_id value
	 */
	public void setMemberId (java.lang.Long memberId) {
		this.memberId = memberId;
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
	 * Return the value associated with the column: unique_id
	 */
	public java.lang.String getUniqueId () {
		return uniqueId;
	}

	/**
	 * Set the value related to the column: unique_id
	 * @param uniqueId the unique_id value
	 */
	public void setUniqueId (java.lang.String uniqueId) {
		this.uniqueId = uniqueId;
	}



	/**
	 * Return the value associated with the column: smear_no
	 */
	public java.lang.String getSmearNo () {
		return smearNo;
	}

	/**
	 * Set the value related to the column: smear_no
	 * @param smearNo the smear_no value
	 */
	public void setSmearNo (java.lang.String smearNo) {
		this.smearNo = smearNo;
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
	 * Return the value associated with the column: refer_type
	 */
	public java.lang.Long getReferType () {
		return referType;
	}

	/**
	 * Set the value related to the column: refer_type
	 * @param referType the refer_type value
	 */
	public void setReferType (java.lang.Long referType) {
		this.referType = referType;
	}



	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: date_of_birth
	 */
	public java.util.Date getDateOfBirth () {
		return dateOfBirth;
	}

	/**
	 * Set the value related to the column: date_of_birth
	 * @param dateOfBirth the date_of_birth value
	 */
	public void setDateOfBirth (java.util.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	/**
	 * Return the value associated with the column: refer_hospital
	 */
	public jkt.hms.masters.business.MasHospital getReferHospital () {
		return referHospital;
	}

	/**
	 * Set the value related to the column: refer_hospital
	 * @param referHospital the refer_hospital value
	 */
	public void setReferHospital (jkt.hms.masters.business.MasHospital referHospital) {
		this.referHospital = referHospital;
	}



	/**
	 * Return the value associated with the column: investigation
	 */
	public jkt.hms.masters.business.DgMasInvestigation getInvestigation () {
		return investigation;
	}

	/**
	 * Set the value related to the column: investigation
	 * @param investigation the investigation value
	 */
	public void setInvestigation (jkt.hms.masters.business.DgMasInvestigation investigation) {
		this.investigation = investigation;
	}



	/**
	 * Return the value associated with the column: sub_centre_id
	 */
	public jkt.hms.masters.business.MasHospital getSubCentre () {
		return subCentre;
	}

	/**
	 * Set the value related to the column: sub_centre_id
	 * @param subCentre the sub_centre_id value
	 */
	public void setSubCentre (jkt.hms.masters.business.MasHospital subCentre) {
		this.subCentre = subCentre;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhInvestigationSampleDetail)) return false;
		else {
			jkt.hms.masters.business.PhInvestigationSampleDetail phInvestigationSampleDetail = (jkt.hms.masters.business.PhInvestigationSampleDetail) obj;
			if (null == this.getId() || null == phInvestigationSampleDetail.getId()) return false;
			else return (this.getId().equals(phInvestigationSampleDetail.getId()));
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