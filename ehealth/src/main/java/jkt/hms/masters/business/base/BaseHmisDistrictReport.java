package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hmis_district_report table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hmis_district_report"
 */

public abstract class BaseHmisDistrictReport  implements Serializable {

	public static String REF = "HmisDistrictReport";
	public static String PROP_KOTTAYAM_ACTUAL = "KottayamActual";
	public static String PROP_REPORT_MONTH = "ReportMonth";
	public static String PROP_KASARAGOD_ACTUAL = "KasaragodActual";
	public static String PROP_ERNAKULAM_MODIFY = "ErnakulamModify";
	public static String PROP_THRISSUR_ACTUAL = "ThrissurActual";
	public static String PROP_KASARAGOD_MODIFY = "KasaragodModify";
	public static String PROP_PATHANAMTHITTA_ACTULA = "PathanamthittaActula";
	public static String PROP_KOTTAYAM_MODIFY = "KottayamModify";
	public static String PROP_KOLLAM_ACTUAL = "KollamActual";
	public static String PROP_KOZHIKODE_MODIFY = "KozhikodeModify";
	public static String PROP_MALAPPURAM_ACTULA = "MalappuramActula";
	public static String PROP_ERNAKULAM_ACTUAL = "ErnakulamActual";
	public static String PROP_ALAPPUZHA_ACTUAL = "AlappuzhaActual";
	public static String PROP_KANNUR_ACTUAL = "KannurActual";
	public static String PROP_PARAMETER = "Parameter";
	public static String PROP_WAYANAD_MODIFY = "WayanadModify";
	public static String PROP_MALAPPURAM_MODIFY = "MalappuramModify";
	public static String PROP_PALAKKAD_MODIFY = "PalakkadModify";
	public static String PROP_THIRUVANANTHAPURAM_ACTULA = "ThiruvananthapuramActula";
	public static String PROP_KOLLAM_MODIFY = "KollamModify";
	public static String PROP_WAYANAD_ACTULA = "WayanadActula";
	public static String PROP_KANNUR_MODIFY = "KannurModify";
	public static String PROP_KOZHIKODE_ACTUAL = "KozhikodeActual";
	public static String PROP_PALAKKAD_ACTULA = "PalakkadActula";
	public static String PROP_ALAPPUZHA_MODIFY = "AlappuzhaModify";
	public static String PROP_REPORT_YEAR = "ReportYear";
	public static String PROP_THIRUVANANTHAPURAM_MODIFY = "ThiruvananthapuramModify";
	public static String PROP_IDUKKI_ACTUAL = "IdukkiActual";
	public static String PROP_PATHANAMTHITTA_MODIFY = "PathanamthittaModify";
	public static String PROP_THRISSUR_MODIFY = "ThrissurModify";
	public static String PROP_IDUKKI_MODIFY = "IdukkiModify";
	public static String PROP_ID = "Id";


	// constructors
	public BaseHmisDistrictReport () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHmisDistrictReport (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer alappuzhaActual;
	private java.lang.Integer alappuzhaModify;
	private java.lang.Integer ernakulamActual;
	private java.lang.Integer ernakulamModify;
	private java.lang.Integer idukkiActual;
	private java.lang.Integer idukkiModify;
	private java.lang.Integer kannurActual;
	private java.lang.Integer kannurModify;
	private java.lang.Integer kasaragodActual;
	private java.lang.Integer kasaragodModify;
	private java.lang.Integer kollamActual;
	private java.lang.Integer kollamModify;
	private java.lang.Integer kottayamActual;
	private java.lang.Integer kottayamModify;
	private java.lang.Integer kozhikodeActual;
	private java.lang.Integer kozhikodeModify;
	private java.lang.Integer malappuramActula;
	private java.lang.Integer malappuramModify;
	private java.lang.Integer palakkadActula;
	private java.lang.Integer palakkadModify;
	private java.lang.Integer pathanamthittaActula;
	private java.lang.Integer pathanamthittaModify;
	private java.lang.Integer thiruvananthapuramActula;
	private java.lang.Integer thiruvananthapuramModify;
	private java.lang.Integer thrissurActual;
	private java.lang.Integer thrissurModify;
	private java.lang.Integer wayanadActula;
	private java.lang.Integer wayanadModify;
	private java.lang.Integer reportMonth;
	private java.lang.Integer reportYear;

	// many to one
	private jkt.hms.masters.business.MasPhReportsParameters parameter;



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
	 * Return the value associated with the column: alappuzha_actual
	 */
	public java.lang.Integer getAlappuzhaActual () {
		return alappuzhaActual;
	}

	/**
	 * Set the value related to the column: alappuzha_actual
	 * @param alappuzhaActual the alappuzha_actual value
	 */
	public void setAlappuzhaActual (java.lang.Integer alappuzhaActual) {
		this.alappuzhaActual = alappuzhaActual;
	}



	/**
	 * Return the value associated with the column: alappuzha_modify
	 */
	public java.lang.Integer getAlappuzhaModify () {
		return alappuzhaModify;
	}

	/**
	 * Set the value related to the column: alappuzha_modify
	 * @param alappuzhaModify the alappuzha_modify value
	 */
	public void setAlappuzhaModify (java.lang.Integer alappuzhaModify) {
		this.alappuzhaModify = alappuzhaModify;
	}



	/**
	 * Return the value associated with the column: ernakulam_actual
	 */
	public java.lang.Integer getErnakulamActual () {
		return ernakulamActual;
	}

	/**
	 * Set the value related to the column: ernakulam_actual
	 * @param ernakulamActual the ernakulam_actual value
	 */
	public void setErnakulamActual (java.lang.Integer ernakulamActual) {
		this.ernakulamActual = ernakulamActual;
	}



	/**
	 * Return the value associated with the column: ernakulam_modify
	 */
	public java.lang.Integer getErnakulamModify () {
		return ernakulamModify;
	}

	/**
	 * Set the value related to the column: ernakulam_modify
	 * @param ernakulamModify the ernakulam_modify value
	 */
	public void setErnakulamModify (java.lang.Integer ernakulamModify) {
		this.ernakulamModify = ernakulamModify;
	}



	/**
	 * Return the value associated with the column: idukki_actual
	 */
	public java.lang.Integer getIdukkiActual () {
		return idukkiActual;
	}

	/**
	 * Set the value related to the column: idukki_actual
	 * @param idukkiActual the idukki_actual value
	 */
	public void setIdukkiActual (java.lang.Integer idukkiActual) {
		this.idukkiActual = idukkiActual;
	}



	/**
	 * Return the value associated with the column: idukki_modify
	 */
	public java.lang.Integer getIdukkiModify () {
		return idukkiModify;
	}

	/**
	 * Set the value related to the column: idukki_modify
	 * @param idukkiModify the idukki_modify value
	 */
	public void setIdukkiModify (java.lang.Integer idukkiModify) {
		this.idukkiModify = idukkiModify;
	}



	/**
	 * Return the value associated with the column: kannur_actual
	 */
	public java.lang.Integer getKannurActual () {
		return kannurActual;
	}

	/**
	 * Set the value related to the column: kannur_actual
	 * @param kannurActual the kannur_actual value
	 */
	public void setKannurActual (java.lang.Integer kannurActual) {
		this.kannurActual = kannurActual;
	}



	/**
	 * Return the value associated with the column: kannur_modify
	 */
	public java.lang.Integer getKannurModify () {
		return kannurModify;
	}

	/**
	 * Set the value related to the column: kannur_modify
	 * @param kannurModify the kannur_modify value
	 */
	public void setKannurModify (java.lang.Integer kannurModify) {
		this.kannurModify = kannurModify;
	}



	/**
	 * Return the value associated with the column: kasaragod_actual
	 */
	public java.lang.Integer getKasaragodActual () {
		return kasaragodActual;
	}

	/**
	 * Set the value related to the column: kasaragod_actual
	 * @param kasaragodActual the kasaragod_actual value
	 */
	public void setKasaragodActual (java.lang.Integer kasaragodActual) {
		this.kasaragodActual = kasaragodActual;
	}



	/**
	 * Return the value associated with the column: kasaragod_modify
	 */
	public java.lang.Integer getKasaragodModify () {
		return kasaragodModify;
	}

	/**
	 * Set the value related to the column: kasaragod_modify
	 * @param kasaragodModify the kasaragod_modify value
	 */
	public void setKasaragodModify (java.lang.Integer kasaragodModify) {
		this.kasaragodModify = kasaragodModify;
	}



	/**
	 * Return the value associated with the column: kollam_actual
	 */
	public java.lang.Integer getKollamActual () {
		return kollamActual;
	}

	/**
	 * Set the value related to the column: kollam_actual
	 * @param kollamActual the kollam_actual value
	 */
	public void setKollamActual (java.lang.Integer kollamActual) {
		this.kollamActual = kollamActual;
	}



	/**
	 * Return the value associated with the column: kollam_modify
	 */
	public java.lang.Integer getKollamModify () {
		return kollamModify;
	}

	/**
	 * Set the value related to the column: kollam_modify
	 * @param kollamModify the kollam_modify value
	 */
	public void setKollamModify (java.lang.Integer kollamModify) {
		this.kollamModify = kollamModify;
	}



	/**
	 * Return the value associated with the column: kottayam_actual
	 */
	public java.lang.Integer getKottayamActual () {
		return kottayamActual;
	}

	/**
	 * Set the value related to the column: kottayam_actual
	 * @param kottayamActual the kottayam_actual value
	 */
	public void setKottayamActual (java.lang.Integer kottayamActual) {
		this.kottayamActual = kottayamActual;
	}



	/**
	 * Return the value associated with the column: kottayam_modify
	 */
	public java.lang.Integer getKottayamModify () {
		return kottayamModify;
	}

	/**
	 * Set the value related to the column: kottayam_modify
	 * @param kottayamModify the kottayam_modify value
	 */
	public void setKottayamModify (java.lang.Integer kottayamModify) {
		this.kottayamModify = kottayamModify;
	}



	/**
	 * Return the value associated with the column: kozhikode_actual
	 */
	public java.lang.Integer getKozhikodeActual () {
		return kozhikodeActual;
	}

	/**
	 * Set the value related to the column: kozhikode_actual
	 * @param kozhikodeActual the kozhikode_actual value
	 */
	public void setKozhikodeActual (java.lang.Integer kozhikodeActual) {
		this.kozhikodeActual = kozhikodeActual;
	}



	/**
	 * Return the value associated with the column: kozhikode_modify
	 */
	public java.lang.Integer getKozhikodeModify () {
		return kozhikodeModify;
	}

	/**
	 * Set the value related to the column: kozhikode_modify
	 * @param kozhikodeModify the kozhikode_modify value
	 */
	public void setKozhikodeModify (java.lang.Integer kozhikodeModify) {
		this.kozhikodeModify = kozhikodeModify;
	}



	/**
	 * Return the value associated with the column: malappuram_actula
	 */
	public java.lang.Integer getMalappuramActula () {
		return malappuramActula;
	}

	/**
	 * Set the value related to the column: malappuram_actula
	 * @param malappuramActula the malappuram_actula value
	 */
	public void setMalappuramActula (java.lang.Integer malappuramActula) {
		this.malappuramActula = malappuramActula;
	}



	/**
	 * Return the value associated with the column: malappuram_modify
	 */
	public java.lang.Integer getMalappuramModify () {
		return malappuramModify;
	}

	/**
	 * Set the value related to the column: malappuram_modify
	 * @param malappuramModify the malappuram_modify value
	 */
	public void setMalappuramModify (java.lang.Integer malappuramModify) {
		this.malappuramModify = malappuramModify;
	}



	/**
	 * Return the value associated with the column: palakkad_actula
	 */
	public java.lang.Integer getPalakkadActula () {
		return palakkadActula;
	}

	/**
	 * Set the value related to the column: palakkad_actula
	 * @param palakkadActula the palakkad_actula value
	 */
	public void setPalakkadActula (java.lang.Integer palakkadActula) {
		this.palakkadActula = palakkadActula;
	}



	/**
	 * Return the value associated with the column: palakkad_modify
	 */
	public java.lang.Integer getPalakkadModify () {
		return palakkadModify;
	}

	/**
	 * Set the value related to the column: palakkad_modify
	 * @param palakkadModify the palakkad_modify value
	 */
	public void setPalakkadModify (java.lang.Integer palakkadModify) {
		this.palakkadModify = palakkadModify;
	}



	/**
	 * Return the value associated with the column: pathanamthitta_actula
	 */
	public java.lang.Integer getPathanamthittaActula () {
		return pathanamthittaActula;
	}

	/**
	 * Set the value related to the column: pathanamthitta_actula
	 * @param pathanamthittaActula the pathanamthitta_actula value
	 */
	public void setPathanamthittaActula (java.lang.Integer pathanamthittaActula) {
		this.pathanamthittaActula = pathanamthittaActula;
	}



	/**
	 * Return the value associated with the column: pathanamthitta_modify
	 */
	public java.lang.Integer getPathanamthittaModify () {
		return pathanamthittaModify;
	}

	/**
	 * Set the value related to the column: pathanamthitta_modify
	 * @param pathanamthittaModify the pathanamthitta_modify value
	 */
	public void setPathanamthittaModify (java.lang.Integer pathanamthittaModify) {
		this.pathanamthittaModify = pathanamthittaModify;
	}



	/**
	 * Return the value associated with the column: thiruvananthapuram_actula
	 */
	public java.lang.Integer getThiruvananthapuramActula () {
		return thiruvananthapuramActula;
	}

	/**
	 * Set the value related to the column: thiruvananthapuram_actula
	 * @param thiruvananthapuramActula the thiruvananthapuram_actula value
	 */
	public void setThiruvananthapuramActula (java.lang.Integer thiruvananthapuramActula) {
		this.thiruvananthapuramActula = thiruvananthapuramActula;
	}



	/**
	 * Return the value associated with the column: thiruvananthapuram_modify
	 */
	public java.lang.Integer getThiruvananthapuramModify () {
		return thiruvananthapuramModify;
	}

	/**
	 * Set the value related to the column: thiruvananthapuram_modify
	 * @param thiruvananthapuramModify the thiruvananthapuram_modify value
	 */
	public void setThiruvananthapuramModify (java.lang.Integer thiruvananthapuramModify) {
		this.thiruvananthapuramModify = thiruvananthapuramModify;
	}



	/**
	 * Return the value associated with the column: thrissur_actual
	 */
	public java.lang.Integer getThrissurActual () {
		return thrissurActual;
	}

	/**
	 * Set the value related to the column: thrissur_actual
	 * @param thrissurActual the thrissur_actual value
	 */
	public void setThrissurActual (java.lang.Integer thrissurActual) {
		this.thrissurActual = thrissurActual;
	}



	/**
	 * Return the value associated with the column: thrissur_modify
	 */
	public java.lang.Integer getThrissurModify () {
		return thrissurModify;
	}

	/**
	 * Set the value related to the column: thrissur_modify
	 * @param thrissurModify the thrissur_modify value
	 */
	public void setThrissurModify (java.lang.Integer thrissurModify) {
		this.thrissurModify = thrissurModify;
	}



	/**
	 * Return the value associated with the column: wayanad_actula
	 */
	public java.lang.Integer getWayanadActula () {
		return wayanadActula;
	}

	/**
	 * Set the value related to the column: wayanad_actula
	 * @param wayanadActula the wayanad_actula value
	 */
	public void setWayanadActula (java.lang.Integer wayanadActula) {
		this.wayanadActula = wayanadActula;
	}



	/**
	 * Return the value associated with the column: wayanad_modify
	 */
	public java.lang.Integer getWayanadModify () {
		return wayanadModify;
	}

	/**
	 * Set the value related to the column: wayanad_modify
	 * @param wayanadModify the wayanad_modify value
	 */
	public void setWayanadModify (java.lang.Integer wayanadModify) {
		this.wayanadModify = wayanadModify;
	}



	/**
	 * Return the value associated with the column: report_month
	 */
	public java.lang.Integer getReportMonth () {
		return reportMonth;
	}

	/**
	 * Set the value related to the column: report_month
	 * @param reportMonth the report_month value
	 */
	public void setReportMonth (java.lang.Integer reportMonth) {
		this.reportMonth = reportMonth;
	}



	/**
	 * Return the value associated with the column: report_year
	 */
	public java.lang.Integer getReportYear () {
		return reportYear;
	}

	/**
	 * Set the value related to the column: report_year
	 * @param reportYear the report_year value
	 */
	public void setReportYear (java.lang.Integer reportYear) {
		this.reportYear = reportYear;
	}



	/**
	 * Return the value associated with the column: parameter_id
	 */
	public jkt.hms.masters.business.MasPhReportsParameters getParameter () {
		return parameter;
	}

	/**
	 * Set the value related to the column: parameter_id
	 * @param parameter the parameter_id value
	 */
	public void setParameter (jkt.hms.masters.business.MasPhReportsParameters parameter) {
		this.parameter = parameter;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HmisDistrictReport)) return false;
		else {
			jkt.hms.masters.business.HmisDistrictReport hmisDistrictReport = (jkt.hms.masters.business.HmisDistrictReport) obj;
			if (null == this.getId() || null == hmisDistrictReport.getId()) return false;
			else return (this.getId().equals(hmisDistrictReport.getId()));
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