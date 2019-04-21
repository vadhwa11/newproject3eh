package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the location_parameter_mapping table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="location_parameter_mapping"
 */

public abstract class BaseLocationParameterMapping  implements Serializable {

	public static String REF = "LocationParameterMapping";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LSG = "Lsg";
	public static String PROP_MAS_DISTRICT = "MasDistrict";
	public static String PROP_LOCALITY = "Locality";
	public static String PROP_VILLAGE = "Village";
	public static String PROP_SUB_CENTRE = "SubCentre";
	public static String PROP_ELECTRICAL_SECTION = "ElectricalSection";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PARLIYAMENT = "Parliyament";
	public static String PROP_WARD = "Ward";
	public static String PROP_BASIC_SECTION = "BasicSection";
	public static String PROP_MAS_TALUK = "MasTaluk";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_POST_CODE = "PostCode";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ASSEMBLY = "Assembly";


	// constructors
	public BaseLocationParameterMapping () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLocationParameterMapping (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseLocationParameterMapping (
		java.lang.Integer id,
		java.lang.String status) {

		this.setId(id);
		this.setStatus(status);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasLsg lsg;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.PhMasElectricalSection electricalSection;
	private jkt.hms.masters.business.MasHospital basicSection;
	private jkt.hms.masters.business.PhMasParliyamentAssembly parliyament;
	private jkt.hms.masters.business.PhMasParliyamentAssembly assembly;
	private jkt.hms.masters.business.MasPostCode postCode;
	private jkt.hms.masters.business.MasHospital subCentre;
	private jkt.hms.masters.business.PhMasLocality locality;
	private jkt.hms.masters.business.MasVillage village;
	private jkt.hms.masters.business.MasDistrict masDistrict;
	private jkt.hms.masters.business.MasTaluk masTaluk;
	private jkt.hms.masters.business.MasWard ward;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="mapping_id"
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
	 * Return the value associated with the column: lsg_id
	 */
	public jkt.hms.masters.business.MasLsg getLsg () {
		return lsg;
	}

	/**
	 * Set the value related to the column: lsg_id
	 * @param lsg the lsg_id value
	 */
	public void setLsg (jkt.hms.masters.business.MasLsg lsg) {
		this.lsg = lsg;
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
	 * Return the value associated with the column: electrical_section_id
	 */
	public jkt.hms.masters.business.PhMasElectricalSection getElectricalSection () {
		return electricalSection;
	}

	/**
	 * Set the value related to the column: electrical_section_id
	 * @param electricalSection the electrical_section_id value
	 */
	public void setElectricalSection (jkt.hms.masters.business.PhMasElectricalSection electricalSection) {
		this.electricalSection = electricalSection;
	}



	/**
	 * Return the value associated with the column: basic_section_id
	 */
	public jkt.hms.masters.business.MasHospital getBasicSection () {
		return basicSection;
	}

	/**
	 * Set the value related to the column: basic_section_id
	 * @param basicSection the basic_section_id value
	 */
	public void setBasicSection (jkt.hms.masters.business.MasHospital basicSection) {
		this.basicSection = basicSection;
	}



	/**
	 * Return the value associated with the column: parliyament_id
	 */
	public jkt.hms.masters.business.PhMasParliyamentAssembly getParliyament () {
		return parliyament;
	}

	/**
	 * Set the value related to the column: parliyament_id
	 * @param parliyament the parliyament_id value
	 */
	public void setParliyament (jkt.hms.masters.business.PhMasParliyamentAssembly parliyament) {
		this.parliyament = parliyament;
	}



	/**
	 * Return the value associated with the column: assembly_id
	 */
	public jkt.hms.masters.business.PhMasParliyamentAssembly getAssembly () {
		return assembly;
	}

	/**
	 * Set the value related to the column: assembly_id
	 * @param assembly the assembly_id value
	 */
	public void setAssembly (jkt.hms.masters.business.PhMasParliyamentAssembly assembly) {
		this.assembly = assembly;
	}



	/**
	 * Return the value associated with the column: post_code_id
	 */
	public jkt.hms.masters.business.MasPostCode getPostCode () {
		return postCode;
	}

	/**
	 * Set the value related to the column: post_code_id
	 * @param postCode the post_code_id value
	 */
	public void setPostCode (jkt.hms.masters.business.MasPostCode postCode) {
		this.postCode = postCode;
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



	/**
	 * Return the value associated with the column: locality_id
	 */
	public jkt.hms.masters.business.PhMasLocality getLocality () {
		return locality;
	}

	/**
	 * Set the value related to the column: locality_id
	 * @param locality the locality_id value
	 */
	public void setLocality (jkt.hms.masters.business.PhMasLocality locality) {
		this.locality = locality;
	}



	/**
	 * Return the value associated with the column: village_id
	 */
	public jkt.hms.masters.business.MasVillage getVillage () {
		return village;
	}

	/**
	 * Set the value related to the column: village_id
	 * @param village the village_id value
	 */
	public void setVillage (jkt.hms.masters.business.MasVillage village) {
		this.village = village;
	}



	/**
	 * Return the value associated with the column: mas_district_id
	 */
	public jkt.hms.masters.business.MasDistrict getMasDistrict () {
		return masDistrict;
	}

	/**
	 * Set the value related to the column: mas_district_id
	 * @param masDistrict the mas_district_id value
	 */
	public void setMasDistrict (jkt.hms.masters.business.MasDistrict masDistrict) {
		this.masDistrict = masDistrict;
	}



	/**
	 * Return the value associated with the column: mas_taluk_id
	 */
	public jkt.hms.masters.business.MasTaluk getMasTaluk () {
		return masTaluk;
	}

	/**
	 * Set the value related to the column: mas_taluk_id
	 * @param masTaluk the mas_taluk_id value
	 */
	public void setMasTaluk (jkt.hms.masters.business.MasTaluk masTaluk) {
		this.masTaluk = masTaluk;
	}



	/**
	 * Return the value associated with the column: ward_id
	 */
	public jkt.hms.masters.business.MasWard getWard () {
		return ward;
	}

	/**
	 * Set the value related to the column: ward_id
	 * @param ward the ward_id value
	 */
	public void setWard (jkt.hms.masters.business.MasWard ward) {
		this.ward = ward;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.LocationParameterMapping)) return false;
		else {
			jkt.hms.masters.business.LocationParameterMapping locationParameterMapping = (jkt.hms.masters.business.LocationParameterMapping) obj;
			if (null == this.getId() || null == locationParameterMapping.getId()) return false;
			else return (this.getId().equals(locationParameterMapping.getId()));
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