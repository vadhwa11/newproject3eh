package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_contact_lens_template table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_contact_lens_template"
 */

public abstract class BaseOpdContactLensTemplate  implements Serializable {

	public static String REF = "OpdContactLensTemplate";
	public static String PROP_PT_CONT_LENS_DUR_TYPE = "PtContLensDurType";
	public static String PROP_LENS_ORDER_VALUE2 = "LensOrderValue2";
	public static String PROP_DEF_VISION_LE = "DefVisionLe";
	public static String PROP_LENS_ORDER_VALUE1 = "LensOrderValue1";
	public static String PROP_K1_RE = "K1Re";
	public static String PROP_VISION_PT_NEAR_RE = "VisionPtNearRe";
	public static String PROP_CL_SOLUTION = "ClSolution";
	public static String PROP_PT_CONT_LENS_VALUE_OTHERS = "PtContLensValueOthers";
	public static String PROP_SPH_DIST_LE = "SphDistLe";
	public static String PROP_LENS_CASE = "LensCase";
	public static String PROP_DEF_DUR_TYPE_LE = "DefDurTypeLe";
	public static String PROP_OPD_PATIENT_DETAILS = "OpdPatientDetails";
	public static String PROP_SL_EXAM_OTHERS = "SlExamOthers";
	public static String PROP_AXIX_DIST_LE = "AxixDistLe";
	public static String PROP_PT_CONT_LENS_DUR = "PtContLensDur";
	public static String PROP_VISION_PT_DIS_LE = "VisionPtDisLe";
	public static String PROP_VISION_UNAIDED_DIST_RE = "VisionUnaidedDistRe";
	public static String PROP_PT_SPECT_DUR = "PtSpectDur";
	public static String PROP_SPH_NEAR_LE = "SphNearLe";
	public static String PROP_SL_EXAM_UTC = "SlExamUtc";
	public static String PROP_AXIX_NEAR_LE = "AxixNearLe";
	public static String PROP_K2_RE = "K2Re";
	public static String PROP_CONTACT_LENS_VISION = "ContactLensVision";
	public static String PROP_VISION_UNAIDED_NEAR_RE = "VisionUnaidedNearRe";
	public static String PROP_ID = "Id";
	public static String PROP_CYL_NEAR_LE = "CylNearLe";
	public static String PROP_VISION_PT_NEAR_LE = "VisionPtNearLe";
	public static String PROP_K2_LE = "K2Le";
	public static String PROP_DEFECTIVE_VIS_LE_DUR = "DefectiveVisLeDur";
	public static String PROP_OTHERS = "Others";
	public static String PROP_OVER_REFRACTION = "OverRefraction";
	public static String PROP_PT_CONT_LENS_VALUE = "PtContLensValue";
	public static String PROP_SL_EXAM_TBUT = "SlExamTbut";
	public static String PROP_CYL_DIST_RE = "CylDistRe";
	public static String PROP_R1_LE = "R1Le";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_CYL_NEAR_RE = "CylNearRe";
	public static String PROP_SPH_DIST_RE = "SphDistRe";
	public static String PROP_PT_SPECT = "PtSpect";
	public static String PROP_DEFECTIVE_VIS_RE_DUR = "DefectiveVisReDur";
	public static String PROP_R2_LE = "R2Le";
	public static String PROP_DEF_VISION_RE = "DefVisionRe";
	public static String PROP_VISION_PT_DIS_RE = "VisionPtDisRe";
	public static String PROP_AXIX_NEAR_RE = "AxixNearRe";
	public static String PROP_SPH_NEAR_RE = "SphNearRe";
	public static String PROP_SL_EXAM_LID_MARGIN = "SlExamLidMargin";
	public static String PROP_PT_SPECT_DUR_TYPE = "PtSpectDurType";
	public static String PROP_DEF_DUR_TYPE_RE = "DefDurTypeRe";
	public static String PROP_VISION_UNAIDED_DIST_LE = "VisionUnaidedDistLe";
	public static String PROP_R1_RE = "R1Re";
	public static String PROP_CYL_DIST_LE = "CylDistLe";
	public static String PROP_R2_RE = "R2Re";
	public static String PROP_AXIX_DIST_RE = "AxixDistRe";
	public static String PROP_K1_LE = "K1Le";
	public static String PROP_TRAIL_I_VALUE1 = "TrailIValue1";
	public static String PROP_VISION_UNAIDED_NEAR_LE = "VisionUnaidedNearLe";
	public static String PROP_TRAIL_I_VALUE2 = "TrailIValue2";
	public static String PROP_HIN = "Hin";
	public static String PROP_PT_CONTACT_LENS = "PtContactLens";


	// constructors
	public BaseOpdContactLensTemplate () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdContactLensTemplate (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String defVisionLe;
	private java.lang.String defectiveVisLeDur;
	private java.lang.String defDurTypeLe;
	private java.lang.String defVisionRe;
	private java.lang.String defectiveVisReDur;
	private java.lang.String defDurTypeRe;
	private java.lang.String ptContactLens;
	private java.lang.String ptContLensDur;
	private java.lang.String ptContLensDurType;
	private java.lang.String ptContLensValue;
	private java.lang.String ptContLensValueOthers;
	private java.lang.String ptSpect;
	private java.lang.String ptSpectDur;
	private java.lang.String ptSpectDurType;
	private java.lang.String visionUnaidedDistRe;
	private java.lang.String visionUnaidedDistLe;
	private java.lang.String visionUnaidedNearRe;
	private java.lang.String visionUnaidedNearLe;
	private java.lang.String visionPtDisRe;
	private java.lang.String visionPtDisLe;
	private java.lang.String visionPtNearRe;
	private java.lang.String visionPtNearLe;
	private java.lang.String sphDistRe;
	private java.lang.String cylDistRe;
	private java.lang.String axixDistRe;
	private java.lang.String sphDistLe;
	private java.lang.String cylDistLe;
	private java.lang.String axixDistLe;
	private java.lang.String sphNearRe;
	private java.lang.String cylNearRe;
	private java.lang.String axixNearRe;
	private java.lang.String sphNearLe;
	private java.lang.String cylNearLe;
	private java.lang.String axixNearLe;
	private java.lang.String k1Re;
	private java.lang.String k1Le;
	private java.lang.String k2Re;
	private java.lang.String k2Le;
	private java.lang.String r1Re;
	private java.lang.String r1Le;
	private java.lang.String r2Re;
	private java.lang.String r2Le;
	private java.lang.String slExamLidMargin;
	private java.lang.String slExamUtc;
	private java.lang.String slExamTbut;
	private java.lang.String slExamOthers;
	private java.lang.String remarks;
	private java.lang.String contactLensVision;
	private java.lang.String overRefraction;
	private java.lang.String others;
	private java.lang.String trailIValue1;
	private java.lang.String trailIValue2;
	private java.lang.String lensOrderValue1;
	private java.lang.String lensOrderValue2;
	private java.lang.String clSolution;
	private java.lang.String lensCase;

	// many to one
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="contact_lens_template_id"
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
	 * Return the value associated with the column: def_vision_le
	 */
	public java.lang.String getDefVisionLe () {
		return defVisionLe;
	}

	/**
	 * Set the value related to the column: def_vision_le
	 * @param defVisionLe the def_vision_le value
	 */
	public void setDefVisionLe (java.lang.String defVisionLe) {
		this.defVisionLe = defVisionLe;
	}



	/**
	 * Return the value associated with the column: defective_vis_le_dur
	 */
	public java.lang.String getDefectiveVisLeDur () {
		return defectiveVisLeDur;
	}

	/**
	 * Set the value related to the column: defective_vis_le_dur
	 * @param defectiveVisLeDur the defective_vis_le_dur value
	 */
	public void setDefectiveVisLeDur (java.lang.String defectiveVisLeDur) {
		this.defectiveVisLeDur = defectiveVisLeDur;
	}



	/**
	 * Return the value associated with the column: def_dur_type_le
	 */
	public java.lang.String getDefDurTypeLe () {
		return defDurTypeLe;
	}

	/**
	 * Set the value related to the column: def_dur_type_le
	 * @param defDurTypeLe the def_dur_type_le value
	 */
	public void setDefDurTypeLe (java.lang.String defDurTypeLe) {
		this.defDurTypeLe = defDurTypeLe;
	}



	/**
	 * Return the value associated with the column: def_vision_re
	 */
	public java.lang.String getDefVisionRe () {
		return defVisionRe;
	}

	/**
	 * Set the value related to the column: def_vision_re
	 * @param defVisionRe the def_vision_re value
	 */
	public void setDefVisionRe (java.lang.String defVisionRe) {
		this.defVisionRe = defVisionRe;
	}



	/**
	 * Return the value associated with the column: defective_vis_re_dur
	 */
	public java.lang.String getDefectiveVisReDur () {
		return defectiveVisReDur;
	}

	/**
	 * Set the value related to the column: defective_vis_re_dur
	 * @param defectiveVisReDur the defective_vis_re_dur value
	 */
	public void setDefectiveVisReDur (java.lang.String defectiveVisReDur) {
		this.defectiveVisReDur = defectiveVisReDur;
	}



	/**
	 * Return the value associated with the column: def_dur_type_re
	 */
	public java.lang.String getDefDurTypeRe () {
		return defDurTypeRe;
	}

	/**
	 * Set the value related to the column: def_dur_type_re
	 * @param defDurTypeRe the def_dur_type_re value
	 */
	public void setDefDurTypeRe (java.lang.String defDurTypeRe) {
		this.defDurTypeRe = defDurTypeRe;
	}



	/**
	 * Return the value associated with the column: pt_contact_lens
	 */
	public java.lang.String getPtContactLens () {
		return ptContactLens;
	}

	/**
	 * Set the value related to the column: pt_contact_lens
	 * @param ptContactLens the pt_contact_lens value
	 */
	public void setPtContactLens (java.lang.String ptContactLens) {
		this.ptContactLens = ptContactLens;
	}



	/**
	 * Return the value associated with the column: pt_cont_lens_dur
	 */
	public java.lang.String getPtContLensDur () {
		return ptContLensDur;
	}

	/**
	 * Set the value related to the column: pt_cont_lens_dur
	 * @param ptContLensDur the pt_cont_lens_dur value
	 */
	public void setPtContLensDur (java.lang.String ptContLensDur) {
		this.ptContLensDur = ptContLensDur;
	}



	/**
	 * Return the value associated with the column: pt_cont_lens_dur_type
	 */
	public java.lang.String getPtContLensDurType () {
		return ptContLensDurType;
	}

	/**
	 * Set the value related to the column: pt_cont_lens_dur_type
	 * @param ptContLensDurType the pt_cont_lens_dur_type value
	 */
	public void setPtContLensDurType (java.lang.String ptContLensDurType) {
		this.ptContLensDurType = ptContLensDurType;
	}



	/**
	 * Return the value associated with the column: pt_cont_lens_value
	 */
	public java.lang.String getPtContLensValue () {
		return ptContLensValue;
	}

	/**
	 * Set the value related to the column: pt_cont_lens_value
	 * @param ptContLensValue the pt_cont_lens_value value
	 */
	public void setPtContLensValue (java.lang.String ptContLensValue) {
		this.ptContLensValue = ptContLensValue;
	}



	/**
	 * Return the value associated with the column: pt_cont_lens_value_others
	 */
	public java.lang.String getPtContLensValueOthers () {
		return ptContLensValueOthers;
	}

	/**
	 * Set the value related to the column: pt_cont_lens_value_others
	 * @param ptContLensValueOthers the pt_cont_lens_value_others value
	 */
	public void setPtContLensValueOthers (java.lang.String ptContLensValueOthers) {
		this.ptContLensValueOthers = ptContLensValueOthers;
	}



	/**
	 * Return the value associated with the column: pt_spect
	 */
	public java.lang.String getPtSpect () {
		return ptSpect;
	}

	/**
	 * Set the value related to the column: pt_spect
	 * @param ptSpect the pt_spect value
	 */
	public void setPtSpect (java.lang.String ptSpect) {
		this.ptSpect = ptSpect;
	}



	/**
	 * Return the value associated with the column: pt_spect_dur
	 */
	public java.lang.String getPtSpectDur () {
		return ptSpectDur;
	}

	/**
	 * Set the value related to the column: pt_spect_dur
	 * @param ptSpectDur the pt_spect_dur value
	 */
	public void setPtSpectDur (java.lang.String ptSpectDur) {
		this.ptSpectDur = ptSpectDur;
	}



	/**
	 * Return the value associated with the column: pt_spect_dur_type
	 */
	public java.lang.String getPtSpectDurType () {
		return ptSpectDurType;
	}

	/**
	 * Set the value related to the column: pt_spect_dur_type
	 * @param ptSpectDurType the pt_spect_dur_type value
	 */
	public void setPtSpectDurType (java.lang.String ptSpectDurType) {
		this.ptSpectDurType = ptSpectDurType;
	}



	/**
	 * Return the value associated with the column: vision_unaided_dist_re
	 */
	public java.lang.String getVisionUnaidedDistRe () {
		return visionUnaidedDistRe;
	}

	/**
	 * Set the value related to the column: vision_unaided_dist_re
	 * @param visionUnaidedDistRe the vision_unaided_dist_re value
	 */
	public void setVisionUnaidedDistRe (java.lang.String visionUnaidedDistRe) {
		this.visionUnaidedDistRe = visionUnaidedDistRe;
	}



	/**
	 * Return the value associated with the column: vision_unaided_dist_le
	 */
	public java.lang.String getVisionUnaidedDistLe () {
		return visionUnaidedDistLe;
	}

	/**
	 * Set the value related to the column: vision_unaided_dist_le
	 * @param visionUnaidedDistLe the vision_unaided_dist_le value
	 */
	public void setVisionUnaidedDistLe (java.lang.String visionUnaidedDistLe) {
		this.visionUnaidedDistLe = visionUnaidedDistLe;
	}



	/**
	 * Return the value associated with the column: vision_unaided_near_re
	 */
	public java.lang.String getVisionUnaidedNearRe () {
		return visionUnaidedNearRe;
	}

	/**
	 * Set the value related to the column: vision_unaided_near_re
	 * @param visionUnaidedNearRe the vision_unaided_near_re value
	 */
	public void setVisionUnaidedNearRe (java.lang.String visionUnaidedNearRe) {
		this.visionUnaidedNearRe = visionUnaidedNearRe;
	}



	/**
	 * Return the value associated with the column: vision_unaided_near_le
	 */
	public java.lang.String getVisionUnaidedNearLe () {
		return visionUnaidedNearLe;
	}

	/**
	 * Set the value related to the column: vision_unaided_near_le
	 * @param visionUnaidedNearLe the vision_unaided_near_le value
	 */
	public void setVisionUnaidedNearLe (java.lang.String visionUnaidedNearLe) {
		this.visionUnaidedNearLe = visionUnaidedNearLe;
	}



	/**
	 * Return the value associated with the column: vision_pt_dis_re
	 */
	public java.lang.String getVisionPtDisRe () {
		return visionPtDisRe;
	}

	/**
	 * Set the value related to the column: vision_pt_dis_re
	 * @param visionPtDisRe the vision_pt_dis_re value
	 */
	public void setVisionPtDisRe (java.lang.String visionPtDisRe) {
		this.visionPtDisRe = visionPtDisRe;
	}



	/**
	 * Return the value associated with the column: vision_pt_dis_le
	 */
	public java.lang.String getVisionPtDisLe () {
		return visionPtDisLe;
	}

	/**
	 * Set the value related to the column: vision_pt_dis_le
	 * @param visionPtDisLe the vision_pt_dis_le value
	 */
	public void setVisionPtDisLe (java.lang.String visionPtDisLe) {
		this.visionPtDisLe = visionPtDisLe;
	}



	/**
	 * Return the value associated with the column: vision_pt_near_re
	 */
	public java.lang.String getVisionPtNearRe () {
		return visionPtNearRe;
	}

	/**
	 * Set the value related to the column: vision_pt_near_re
	 * @param visionPtNearRe the vision_pt_near_re value
	 */
	public void setVisionPtNearRe (java.lang.String visionPtNearRe) {
		this.visionPtNearRe = visionPtNearRe;
	}



	/**
	 * Return the value associated with the column: vision_pt_near_le
	 */
	public java.lang.String getVisionPtNearLe () {
		return visionPtNearLe;
	}

	/**
	 * Set the value related to the column: vision_pt_near_le
	 * @param visionPtNearLe the vision_pt_near_le value
	 */
	public void setVisionPtNearLe (java.lang.String visionPtNearLe) {
		this.visionPtNearLe = visionPtNearLe;
	}



	/**
	 * Return the value associated with the column: sph_dist_re
	 */
	public java.lang.String getSphDistRe () {
		return sphDistRe;
	}

	/**
	 * Set the value related to the column: sph_dist_re
	 * @param sphDistRe the sph_dist_re value
	 */
	public void setSphDistRe (java.lang.String sphDistRe) {
		this.sphDistRe = sphDistRe;
	}



	/**
	 * Return the value associated with the column: cyl_dist_re
	 */
	public java.lang.String getCylDistRe () {
		return cylDistRe;
	}

	/**
	 * Set the value related to the column: cyl_dist_re
	 * @param cylDistRe the cyl_dist_re value
	 */
	public void setCylDistRe (java.lang.String cylDistRe) {
		this.cylDistRe = cylDistRe;
	}



	/**
	 * Return the value associated with the column: axix_dist_re
	 */
	public java.lang.String getAxixDistRe () {
		return axixDistRe;
	}

	/**
	 * Set the value related to the column: axix_dist_re
	 * @param axixDistRe the axix_dist_re value
	 */
	public void setAxixDistRe (java.lang.String axixDistRe) {
		this.axixDistRe = axixDistRe;
	}



	/**
	 * Return the value associated with the column: sph_dist_le
	 */
	public java.lang.String getSphDistLe () {
		return sphDistLe;
	}

	/**
	 * Set the value related to the column: sph_dist_le
	 * @param sphDistLe the sph_dist_le value
	 */
	public void setSphDistLe (java.lang.String sphDistLe) {
		this.sphDistLe = sphDistLe;
	}



	/**
	 * Return the value associated with the column: cyl_dist_le
	 */
	public java.lang.String getCylDistLe () {
		return cylDistLe;
	}

	/**
	 * Set the value related to the column: cyl_dist_le
	 * @param cylDistLe the cyl_dist_le value
	 */
	public void setCylDistLe (java.lang.String cylDistLe) {
		this.cylDistLe = cylDistLe;
	}



	/**
	 * Return the value associated with the column: axix_dist_le
	 */
	public java.lang.String getAxixDistLe () {
		return axixDistLe;
	}

	/**
	 * Set the value related to the column: axix_dist_le
	 * @param axixDistLe the axix_dist_le value
	 */
	public void setAxixDistLe (java.lang.String axixDistLe) {
		this.axixDistLe = axixDistLe;
	}



	/**
	 * Return the value associated with the column: sph_near_re
	 */
	public java.lang.String getSphNearRe () {
		return sphNearRe;
	}

	/**
	 * Set the value related to the column: sph_near_re
	 * @param sphNearRe the sph_near_re value
	 */
	public void setSphNearRe (java.lang.String sphNearRe) {
		this.sphNearRe = sphNearRe;
	}



	/**
	 * Return the value associated with the column: cyl_near_re
	 */
	public java.lang.String getCylNearRe () {
		return cylNearRe;
	}

	/**
	 * Set the value related to the column: cyl_near_re
	 * @param cylNearRe the cyl_near_re value
	 */
	public void setCylNearRe (java.lang.String cylNearRe) {
		this.cylNearRe = cylNearRe;
	}



	/**
	 * Return the value associated with the column: axix_near_re
	 */
	public java.lang.String getAxixNearRe () {
		return axixNearRe;
	}

	/**
	 * Set the value related to the column: axix_near_re
	 * @param axixNearRe the axix_near_re value
	 */
	public void setAxixNearRe (java.lang.String axixNearRe) {
		this.axixNearRe = axixNearRe;
	}



	/**
	 * Return the value associated with the column: sph_near_le
	 */
	public java.lang.String getSphNearLe () {
		return sphNearLe;
	}

	/**
	 * Set the value related to the column: sph_near_le
	 * @param sphNearLe the sph_near_le value
	 */
	public void setSphNearLe (java.lang.String sphNearLe) {
		this.sphNearLe = sphNearLe;
	}



	/**
	 * Return the value associated with the column: cyl_near_le
	 */
	public java.lang.String getCylNearLe () {
		return cylNearLe;
	}

	/**
	 * Set the value related to the column: cyl_near_le
	 * @param cylNearLe the cyl_near_le value
	 */
	public void setCylNearLe (java.lang.String cylNearLe) {
		this.cylNearLe = cylNearLe;
	}



	/**
	 * Return the value associated with the column: axix_near_le
	 */
	public java.lang.String getAxixNearLe () {
		return axixNearLe;
	}

	/**
	 * Set the value related to the column: axix_near_le
	 * @param axixNearLe the axix_near_le value
	 */
	public void setAxixNearLe (java.lang.String axixNearLe) {
		this.axixNearLe = axixNearLe;
	}



	/**
	 * Return the value associated with the column: k1_re
	 */
	public java.lang.String getK1Re () {
		return k1Re;
	}

	/**
	 * Set the value related to the column: k1_re
	 * @param k1Re the k1_re value
	 */
	public void setK1Re (java.lang.String k1Re) {
		this.k1Re = k1Re;
	}



	/**
	 * Return the value associated with the column: k1_le
	 */
	public java.lang.String getK1Le () {
		return k1Le;
	}

	/**
	 * Set the value related to the column: k1_le
	 * @param k1Le the k1_le value
	 */
	public void setK1Le (java.lang.String k1Le) {
		this.k1Le = k1Le;
	}



	/**
	 * Return the value associated with the column: k2_re
	 */
	public java.lang.String getK2Re () {
		return k2Re;
	}

	/**
	 * Set the value related to the column: k2_re
	 * @param k2Re the k2_re value
	 */
	public void setK2Re (java.lang.String k2Re) {
		this.k2Re = k2Re;
	}



	/**
	 * Return the value associated with the column: k2_le
	 */
	public java.lang.String getK2Le () {
		return k2Le;
	}

	/**
	 * Set the value related to the column: k2_le
	 * @param k2Le the k2_le value
	 */
	public void setK2Le (java.lang.String k2Le) {
		this.k2Le = k2Le;
	}



	/**
	 * Return the value associated with the column: r1_re
	 */
	public java.lang.String getR1Re () {
		return r1Re;
	}

	/**
	 * Set the value related to the column: r1_re
	 * @param r1Re the r1_re value
	 */
	public void setR1Re (java.lang.String r1Re) {
		this.r1Re = r1Re;
	}



	/**
	 * Return the value associated with the column: r1_le
	 */
	public java.lang.String getR1Le () {
		return r1Le;
	}

	/**
	 * Set the value related to the column: r1_le
	 * @param r1Le the r1_le value
	 */
	public void setR1Le (java.lang.String r1Le) {
		this.r1Le = r1Le;
	}



	/**
	 * Return the value associated with the column: r2_re
	 */
	public java.lang.String getR2Re () {
		return r2Re;
	}

	/**
	 * Set the value related to the column: r2_re
	 * @param r2Re the r2_re value
	 */
	public void setR2Re (java.lang.String r2Re) {
		this.r2Re = r2Re;
	}



	/**
	 * Return the value associated with the column: r2_le
	 */
	public java.lang.String getR2Le () {
		return r2Le;
	}

	/**
	 * Set the value related to the column: r2_le
	 * @param r2Le the r2_le value
	 */
	public void setR2Le (java.lang.String r2Le) {
		this.r2Le = r2Le;
	}



	/**
	 * Return the value associated with the column: sl_exam_lid_margin
	 */
	public java.lang.String getSlExamLidMargin () {
		return slExamLidMargin;
	}

	/**
	 * Set the value related to the column: sl_exam_lid_margin
	 * @param slExamLidMargin the sl_exam_lid_margin value
	 */
	public void setSlExamLidMargin (java.lang.String slExamLidMargin) {
		this.slExamLidMargin = slExamLidMargin;
	}



	/**
	 * Return the value associated with the column: sl_exam_utc
	 */
	public java.lang.String getSlExamUtc () {
		return slExamUtc;
	}

	/**
	 * Set the value related to the column: sl_exam_utc
	 * @param slExamUtc the sl_exam_utc value
	 */
	public void setSlExamUtc (java.lang.String slExamUtc) {
		this.slExamUtc = slExamUtc;
	}



	/**
	 * Return the value associated with the column: sl_exam_tbut
	 */
	public java.lang.String getSlExamTbut () {
		return slExamTbut;
	}

	/**
	 * Set the value related to the column: sl_exam_tbut
	 * @param slExamTbut the sl_exam_tbut value
	 */
	public void setSlExamTbut (java.lang.String slExamTbut) {
		this.slExamTbut = slExamTbut;
	}



	/**
	 * Return the value associated with the column: sl_exam_others
	 */
	public java.lang.String getSlExamOthers () {
		return slExamOthers;
	}

	/**
	 * Set the value related to the column: sl_exam_others
	 * @param slExamOthers the sl_exam_others value
	 */
	public void setSlExamOthers (java.lang.String slExamOthers) {
		this.slExamOthers = slExamOthers;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: contact_lens_vision
	 */
	public java.lang.String getContactLensVision () {
		return contactLensVision;
	}

	/**
	 * Set the value related to the column: contact_lens_vision
	 * @param contactLensVision the contact_lens_vision value
	 */
	public void setContactLensVision (java.lang.String contactLensVision) {
		this.contactLensVision = contactLensVision;
	}



	/**
	 * Return the value associated with the column: over_refraction
	 */
	public java.lang.String getOverRefraction () {
		return overRefraction;
	}

	/**
	 * Set the value related to the column: over_refraction
	 * @param overRefraction the over_refraction value
	 */
	public void setOverRefraction (java.lang.String overRefraction) {
		this.overRefraction = overRefraction;
	}



	/**
	 * Return the value associated with the column: others
	 */
	public java.lang.String getOthers () {
		return others;
	}

	/**
	 * Set the value related to the column: others
	 * @param others the others value
	 */
	public void setOthers (java.lang.String others) {
		this.others = others;
	}



	/**
	 * Return the value associated with the column: trail_i_value1
	 */
	public java.lang.String getTrailIValue1 () {
		return trailIValue1;
	}

	/**
	 * Set the value related to the column: trail_i_value1
	 * @param trailIValue1 the trail_i_value1 value
	 */
	public void setTrailIValue1 (java.lang.String trailIValue1) {
		this.trailIValue1 = trailIValue1;
	}



	/**
	 * Return the value associated with the column: trail_i_value2
	 */
	public java.lang.String getTrailIValue2 () {
		return trailIValue2;
	}

	/**
	 * Set the value related to the column: trail_i_value2
	 * @param trailIValue2 the trail_i_value2 value
	 */
	public void setTrailIValue2 (java.lang.String trailIValue2) {
		this.trailIValue2 = trailIValue2;
	}



	/**
	 * Return the value associated with the column: lens_order_value1
	 */
	public java.lang.String getLensOrderValue1 () {
		return lensOrderValue1;
	}

	/**
	 * Set the value related to the column: lens_order_value1
	 * @param lensOrderValue1 the lens_order_value1 value
	 */
	public void setLensOrderValue1 (java.lang.String lensOrderValue1) {
		this.lensOrderValue1 = lensOrderValue1;
	}



	/**
	 * Return the value associated with the column: lens_order_value2
	 */
	public java.lang.String getLensOrderValue2 () {
		return lensOrderValue2;
	}

	/**
	 * Set the value related to the column: lens_order_value2
	 * @param lensOrderValue2 the lens_order_value2 value
	 */
	public void setLensOrderValue2 (java.lang.String lensOrderValue2) {
		this.lensOrderValue2 = lensOrderValue2;
	}



	/**
	 * Return the value associated with the column: cl_solution
	 */
	public java.lang.String getClSolution () {
		return clSolution;
	}

	/**
	 * Set the value related to the column: cl_solution
	 * @param clSolution the cl_solution value
	 */
	public void setClSolution (java.lang.String clSolution) {
		this.clSolution = clSolution;
	}



	/**
	 * Return the value associated with the column: lens_case
	 */
	public java.lang.String getLensCase () {
		return lensCase;
	}

	/**
	 * Set the value related to the column: lens_case
	 * @param lensCase the lens_case value
	 */
	public void setLensCase (java.lang.String lensCase) {
		this.lensCase = lensCase;
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



	/**
	 * Return the value associated with the column: opd_patient_details_id
	 */
	public jkt.hms.masters.business.OpdPatientDetails getOpdPatientDetails () {
		return opdPatientDetails;
	}

	/**
	 * Set the value related to the column: opd_patient_details_id
	 * @param opdPatientDetails the opd_patient_details_id value
	 */
	public void setOpdPatientDetails (jkt.hms.masters.business.OpdPatientDetails opdPatientDetails) {
		this.opdPatientDetails = opdPatientDetails;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdContactLensTemplate)) return false;
		else {
			jkt.hms.masters.business.OpdContactLensTemplate opdContactLensTemplate = (jkt.hms.masters.business.OpdContactLensTemplate) obj;
			if (null == this.getId() || null == opdContactLensTemplate.getId()) return false;
			else return (this.getId().equals(opdContactLensTemplate.getId()));
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