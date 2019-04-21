package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the lean_server_stock_data table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="lean_server_stock_data"
 */

public abstract class BaseLeanServerStockData  implements Serializable {

	public static String REF = "LeanServerStockData";
	public static String PROP_STATUS = "Status";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_CENTRAL_STOCK_ID = "CentralStockId";
	public static String PROP_LEAN_STOCK_ID = "LeanStockId";
	public static String PROP_ID = "Id";
	public static String PROP_STOCK_DATA = "StockData";


	// constructors
	public BaseLeanServerStockData () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLeanServerStockData (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String stockData;
	private java.lang.Long leanStockId;
	private java.lang.Long centralStockId;
	private java.lang.String status;
	private java.lang.Long hospitalId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
     */
	public java.lang.Long getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Long id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: stock_data
	 */
	public java.lang.String getStockData () {
		return stockData;
	}

	/**
	 * Set the value related to the column: stock_data
	 * @param stockData the stock_data value
	 */
	public void setStockData (java.lang.String stockData) {
		this.stockData = stockData;
	}



	/**
	 * Return the value associated with the column: lean_stock_id
	 */
	public java.lang.Long getLeanStockId () {
		return leanStockId;
	}

	/**
	 * Set the value related to the column: lean_stock_id
	 * @param leanStockId the lean_stock_id value
	 */
	public void setLeanStockId (java.lang.Long leanStockId) {
		this.leanStockId = leanStockId;
	}



	/**
	 * Return the value associated with the column: central_stock_id
	 */
	public java.lang.Long getCentralStockId () {
		return centralStockId;
	}

	/**
	 * Set the value related to the column: central_stock_id
	 * @param centralStockId the central_stock_id value
	 */
	public void setCentralStockId (java.lang.Long centralStockId) {
		this.centralStockId = centralStockId;
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
	 * Return the value associated with the column: hospital_id
	 */
	public java.lang.Long getHospitalId () {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospitalId the hospital_id value
	 */
	public void setHospitalId (java.lang.Long hospitalId) {
		this.hospitalId = hospitalId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.LeanServerStockData)) return false;
		else {
			jkt.hms.masters.business.LeanServerStockData leanServerStockData = (jkt.hms.masters.business.LeanServerStockData) obj;
			if (null == this.getId() || null == leanServerStockData.getId()) return false;
			else return (this.getId().equals(leanServerStockData.getId()));
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