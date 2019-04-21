package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the printer_cofiguration table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="printer_cofiguration"
 */

public abstract class BasePrinterCofiguration  implements Serializable {

	public static String REF = "PrinterCofiguration";
	public static String PROP_REPORT_TYPE = "ReportType";
	public static String PROP_PRINTER_NAME = "PrinterName";
	public static String PROP_ID = "Id";
	public static String PROP_SYSTEM_IP = "SystemIp";


	// constructors
	public BasePrinterCofiguration () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrinterCofiguration (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String systemIp;
	private java.lang.String reportType;
	private java.lang.String printerName;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
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
	 * Return the value associated with the column: system_ip
	 */
	public java.lang.String getSystemIp () {
		return systemIp;
	}

	/**
	 * Set the value related to the column: system_ip
	 * @param systemIp the system_ip value
	 */
	public void setSystemIp (java.lang.String systemIp) {
		this.systemIp = systemIp;
	}



	/**
	 * Return the value associated with the column: report_type
	 */
	public java.lang.String getReportType () {
		return reportType;
	}

	/**
	 * Set the value related to the column: report_type
	 * @param reportType the report_type value
	 */
	public void setReportType (java.lang.String reportType) {
		this.reportType = reportType;
	}



	/**
	 * Return the value associated with the column: printer_name
	 */
	public java.lang.String getPrinterName () {
		return printerName;
	}

	/**
	 * Set the value related to the column: printer_name
	 * @param printerName the printer_name value
	 */
	public void setPrinterName (java.lang.String printerName) {
		this.printerName = printerName;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PrinterCofiguration)) return false;
		else {
			jkt.hms.masters.business.PrinterCofiguration printerCofiguration = (jkt.hms.masters.business.PrinterCofiguration) obj;
			if (null == this.getId() || null == printerCofiguration.getId()) return false;
			else return (this.getId().equals(printerCofiguration.getId()));
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