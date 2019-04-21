package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the temp_check_in_out_final table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="temp_check_in_out_final"
 */

public abstract class BaseTempCheckInOutFinal  implements Serializable {

	public static String REF = "TempCheckInOutFinal";
	public static String PROP_D19 = "D19";
	public static String PROP_D16 = "D16";
	public static String PROP_D15 = "D15";
	public static String PROP_D18 = "D18";
	public static String PROP_D17 = "D17";
	public static String PROP_D12 = "D12";
	public static String PROP_D11 = "D11";
	public static String PROP_D14 = "D14";
	public static String PROP_D13 = "D13";
	public static String PROP_D10 = "D10";
	public static String PROP_INTT26 = "Intt26";
	public static String PROP_INTT25 = "Intt25";
	public static String PROP_DATES = "Dates";
	public static String PROP_INTT28 = "Intt28";
	public static String PROP_INTT27 = "Intt27";
	public static String PROP_INTT29 = "Intt29";
	public static String PROP_INTT20 = "Intt20";
	public static String PROP_INTT22 = "Intt22";
	public static String PROP_INTT21 = "Intt21";
	public static String PROP_INTT24 = "Intt24";
	public static String PROP_INTT23 = "Intt23";
	public static String PROP_MONTHS = "Months";
	public static String PROP_INTT31 = "Intt31";
	public static String PROP_INTT30 = "Intt30";
	public static String PROP_USER_ID = "UserId";
	public static String PROP_CHECKTYPE = "Checktype";
	public static String PROP_OUTT24 = "Outt24";
	public static String PROP_OUTT25 = "Outt25";
	public static String PROP_OUTT26 = "Outt26";
	public static String PROP_OUTT27 = "Outt27";
	public static String PROP_OUTT28 = "Outt28";
	public static String PROP_OUTT29 = "Outt29";
	public static String PROP_OUTT20 = "Outt20";
	public static String PROP_OUTT21 = "Outt21";
	public static String PROP_OUTT22 = "Outt22";
	public static String PROP_OUTT23 = "Outt23";
	public static String PROP_INTT12 = "Intt12";
	public static String PROP_INTT13 = "Intt13";
	public static String PROP_INTT10 = "Intt10";
	public static String PROP_INTT9 = "Intt9";
	public static String PROP_INTT11 = "Intt11";
	public static String PROP_INTT7 = "Intt7";
	public static String PROP_INTT8 = "Intt8";
	public static String PROP_INTT5 = "Intt5";
	public static String PROP_INTT6 = "Intt6";
	public static String PROP_INTT18 = "Intt18";
	public static String PROP_INTT19 = "Intt19";
	public static String PROP_INTT16 = "Intt16";
	public static String PROP_INTT17 = "Intt17";
	public static String PROP_INTT14 = "Intt14";
	public static String PROP_INTT15 = "Intt15";
	public static String PROP_INTT4 = "Intt4";
	public static String PROP_INTT3 = "Intt3";
	public static String PROP_OUTT30 = "Outt30";
	public static String PROP_ID = "Id";
	public static String PROP_INTT2 = "Intt2";
	public static String PROP_INTT1 = "Intt1";
	public static String PROP_OUTT31 = "Outt31";
	public static String PROP_OUTT6 = "Outt6";
	public static String PROP_D20 = "D20";
	public static String PROP_OUTT7 = "Outt7";
	public static String PROP_D21 = "D21";
	public static String PROP_OUTT8 = "Outt8";
	public static String PROP_OUTT9 = "Outt9";
	public static String PROP_D24 = "D24";
	public static String PROP_D25 = "D25";
	public static String PROP_D22 = "D22";
	public static String PROP_D23 = "D23";
	public static String PROP_D28 = "D28";
	public static String PROP_D29 = "D29";
	public static String PROP_D26 = "D26";
	public static String PROP_D27 = "D27";
	public static String PROP_DAYS = "Days";
	public static String PROP_OUTT1 = "Outt1";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_OUTT3 = "Outt3";
	public static String PROP_OUTT2 = "Outt2";
	public static String PROP_OUTT5 = "Outt5";
	public static String PROP_OUTT4 = "Outt4";
	public static String PROP_D30 = "D30";
	public static String PROP_D31 = "D31";
	public static String PROP_D9 = "D9";
	public static String PROP_D8 = "D8";
	public static String PROP_D7 = "D7";
	public static String PROP_D6 = "D6";
	public static String PROP_D5 = "D5";
	public static String PROP_D4 = "D4";
	public static String PROP_YEARS = "Years";
	public static String PROP_OUTT19 = "Outt19";
	public static String PROP_OUTT17 = "Outt17";
	public static String PROP_OUTT18 = "Outt18";
	public static String PROP_OUTT15 = "Outt15";
	public static String PROP_OUTT16 = "Outt16";
	public static String PROP_OUTT13 = "Outt13";
	public static String PROP_OUTT14 = "Outt14";
	public static String PROP_OUTT11 = "Outt11";
	public static String PROP_D2 = "D2";
	public static String PROP_OUTT12 = "Outt12";
	public static String PROP_D3 = "D3";
	public static String PROP_OUTT10 = "Outt10";
	public static String PROP_D1 = "D1";


	// constructors
	public BaseTempCheckInOutFinal () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTempCheckInOutFinal (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer userId;
	private java.lang.String dates;
	private java.lang.String years;
	private java.lang.String department;
	private java.lang.String months;
	private java.lang.String days;
	private java.lang.String d1;
	private java.lang.String intt1;
	private java.lang.String outt1;
	private java.lang.String d2;
	private java.lang.String intt2;
	private java.lang.String outt2;
	private java.lang.String d3;
	private java.lang.String intt3;
	private java.lang.String outt3;
	private java.lang.String d4;
	private java.lang.String intt4;
	private java.lang.String outt4;
	private java.lang.String d5;
	private java.lang.String intt5;
	private java.lang.String outt5;
	private java.lang.String d6;
	private java.lang.String intt6;
	private java.lang.String outt6;
	private java.lang.String d7;
	private java.lang.String intt7;
	private java.lang.String outt7;
	private java.lang.String d8;
	private java.lang.String intt8;
	private java.lang.String outt8;
	private java.lang.String d9;
	private java.lang.String intt9;
	private java.lang.String outt9;
	private java.lang.String d10;
	private java.lang.String intt10;
	private java.lang.String outt10;
	private java.lang.String d11;
	private java.lang.String intt11;
	private java.lang.String outt11;
	private java.lang.String d12;
	private java.lang.String intt12;
	private java.lang.String outt12;
	private java.lang.String d13;
	private java.lang.String intt13;
	private java.lang.String outt13;
	private java.lang.String d14;
	private java.lang.String intt14;
	private java.lang.String outt14;
	private java.lang.String d15;
	private java.lang.String intt15;
	private java.lang.String outt15;
	private java.lang.String d16;
	private java.lang.String intt16;
	private java.lang.String outt16;
	private java.lang.String d17;
	private java.lang.String intt17;
	private java.lang.String outt17;
	private java.lang.String d18;
	private java.lang.String intt18;
	private java.lang.String outt18;
	private java.lang.String d19;
	private java.lang.String intt19;
	private java.lang.String outt19;
	private java.lang.String d20;
	private java.lang.String intt20;
	private java.lang.String outt20;
	private java.lang.String d21;
	private java.lang.String intt21;
	private java.lang.String outt21;
	private java.lang.String d22;
	private java.lang.String intt22;
	private java.lang.String outt22;
	private java.lang.String d23;
	private java.lang.String intt23;
	private java.lang.String outt23;
	private java.lang.String d24;
	private java.lang.String intt24;
	private java.lang.String outt24;
	private java.lang.String d25;
	private java.lang.String intt25;
	private java.lang.String outt25;
	private java.lang.String d26;
	private java.lang.String intt26;
	private java.lang.String outt26;
	private java.lang.String d27;
	private java.lang.String intt27;
	private java.lang.String outt27;
	private java.lang.String d28;
	private java.lang.String intt28;
	private java.lang.String outt28;
	private java.lang.String d29;
	private java.lang.String intt29;
	private java.lang.String outt29;
	private java.lang.String d30;
	private java.lang.String intt30;
	private java.lang.String outt30;
	private java.lang.String d31;
	private java.lang.String intt31;
	private java.lang.String outt31;
	private java.lang.String checktype;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="Id"
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
	 * Return the value associated with the column: userId
	 */
	public java.lang.Integer getUserId () {
		return userId;
	}

	/**
	 * Set the value related to the column: userId
	 * @param userId the userId value
	 */
	public void setUserId (java.lang.Integer userId) {
		this.userId = userId;
	}



	/**
	 * Return the value associated with the column: dates
	 */
	public java.lang.String getDates () {
		return dates;
	}

	/**
	 * Set the value related to the column: dates
	 * @param dates the dates value
	 */
	public void setDates (java.lang.String dates) {
		this.dates = dates;
	}



	/**
	 * Return the value associated with the column: years
	 */
	public java.lang.String getYears () {
		return years;
	}

	/**
	 * Set the value related to the column: years
	 * @param years the years value
	 */
	public void setYears (java.lang.String years) {
		this.years = years;
	}



	/**
	 * Return the value associated with the column: DEFAULTDEPTID
	 */
	public java.lang.String getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: DEFAULTDEPTID
	 * @param department the DEFAULTDEPTID value
	 */
	public void setDepartment (java.lang.String department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: months
	 */
	public java.lang.String getMonths () {
		return months;
	}

	/**
	 * Set the value related to the column: months
	 * @param months the months value
	 */
	public void setMonths (java.lang.String months) {
		this.months = months;
	}



	/**
	 * Return the value associated with the column: days
	 */
	public java.lang.String getDays () {
		return days;
	}

	/**
	 * Set the value related to the column: days
	 * @param days the days value
	 */
	public void setDays (java.lang.String days) {
		this.days = days;
	}



	/**
	 * Return the value associated with the column: d1
	 */
	public java.lang.String getD1 () {
		return d1;
	}

	/**
	 * Set the value related to the column: d1
	 * @param d1 the d1 value
	 */
	public void setD1 (java.lang.String d1) {
		this.d1 = d1;
	}



	/**
	 * Return the value associated with the column: intt1
	 */
	public java.lang.String getIntt1 () {
		return intt1;
	}

	/**
	 * Set the value related to the column: intt1
	 * @param intt1 the intt1 value
	 */
	public void setIntt1 (java.lang.String intt1) {
		this.intt1 = intt1;
	}



	/**
	 * Return the value associated with the column: outt1
	 */
	public java.lang.String getOutt1 () {
		return outt1;
	}

	/**
	 * Set the value related to the column: outt1
	 * @param outt1 the outt1 value
	 */
	public void setOutt1 (java.lang.String outt1) {
		this.outt1 = outt1;
	}



	/**
	 * Return the value associated with the column: d2
	 */
	public java.lang.String getD2 () {
		return d2;
	}

	/**
	 * Set the value related to the column: d2
	 * @param d2 the d2 value
	 */
	public void setD2 (java.lang.String d2) {
		this.d2 = d2;
	}



	/**
	 * Return the value associated with the column: intt2
	 */
	public java.lang.String getIntt2 () {
		return intt2;
	}

	/**
	 * Set the value related to the column: intt2
	 * @param intt2 the intt2 value
	 */
	public void setIntt2 (java.lang.String intt2) {
		this.intt2 = intt2;
	}



	/**
	 * Return the value associated with the column: outt2
	 */
	public java.lang.String getOutt2 () {
		return outt2;
	}

	/**
	 * Set the value related to the column: outt2
	 * @param outt2 the outt2 value
	 */
	public void setOutt2 (java.lang.String outt2) {
		this.outt2 = outt2;
	}



	/**
	 * Return the value associated with the column: d3
	 */
	public java.lang.String getD3 () {
		return d3;
	}

	/**
	 * Set the value related to the column: d3
	 * @param d3 the d3 value
	 */
	public void setD3 (java.lang.String d3) {
		this.d3 = d3;
	}



	/**
	 * Return the value associated with the column: intt3
	 */
	public java.lang.String getIntt3 () {
		return intt3;
	}

	/**
	 * Set the value related to the column: intt3
	 * @param intt3 the intt3 value
	 */
	public void setIntt3 (java.lang.String intt3) {
		this.intt3 = intt3;
	}



	/**
	 * Return the value associated with the column: outt3
	 */
	public java.lang.String getOutt3 () {
		return outt3;
	}

	/**
	 * Set the value related to the column: outt3
	 * @param outt3 the outt3 value
	 */
	public void setOutt3 (java.lang.String outt3) {
		this.outt3 = outt3;
	}



	/**
	 * Return the value associated with the column: d4
	 */
	public java.lang.String getD4 () {
		return d4;
	}

	/**
	 * Set the value related to the column: d4
	 * @param d4 the d4 value
	 */
	public void setD4 (java.lang.String d4) {
		this.d4 = d4;
	}



	/**
	 * Return the value associated with the column: intt4
	 */
	public java.lang.String getIntt4 () {
		return intt4;
	}

	/**
	 * Set the value related to the column: intt4
	 * @param intt4 the intt4 value
	 */
	public void setIntt4 (java.lang.String intt4) {
		this.intt4 = intt4;
	}



	/**
	 * Return the value associated with the column: outt4
	 */
	public java.lang.String getOutt4 () {
		return outt4;
	}

	/**
	 * Set the value related to the column: outt4
	 * @param outt4 the outt4 value
	 */
	public void setOutt4 (java.lang.String outt4) {
		this.outt4 = outt4;
	}



	/**
	 * Return the value associated with the column: d5
	 */
	public java.lang.String getD5 () {
		return d5;
	}

	/**
	 * Set the value related to the column: d5
	 * @param d5 the d5 value
	 */
	public void setD5 (java.lang.String d5) {
		this.d5 = d5;
	}



	/**
	 * Return the value associated with the column: intt5
	 */
	public java.lang.String getIntt5 () {
		return intt5;
	}

	/**
	 * Set the value related to the column: intt5
	 * @param intt5 the intt5 value
	 */
	public void setIntt5 (java.lang.String intt5) {
		this.intt5 = intt5;
	}



	/**
	 * Return the value associated with the column: outt5
	 */
	public java.lang.String getOutt5 () {
		return outt5;
	}

	/**
	 * Set the value related to the column: outt5
	 * @param outt5 the outt5 value
	 */
	public void setOutt5 (java.lang.String outt5) {
		this.outt5 = outt5;
	}



	/**
	 * Return the value associated with the column: d6
	 */
	public java.lang.String getD6 () {
		return d6;
	}

	/**
	 * Set the value related to the column: d6
	 * @param d6 the d6 value
	 */
	public void setD6 (java.lang.String d6) {
		this.d6 = d6;
	}



	/**
	 * Return the value associated with the column: intt6
	 */
	public java.lang.String getIntt6 () {
		return intt6;
	}

	/**
	 * Set the value related to the column: intt6
	 * @param intt6 the intt6 value
	 */
	public void setIntt6 (java.lang.String intt6) {
		this.intt6 = intt6;
	}



	/**
	 * Return the value associated with the column: outt6
	 */
	public java.lang.String getOutt6 () {
		return outt6;
	}

	/**
	 * Set the value related to the column: outt6
	 * @param outt6 the outt6 value
	 */
	public void setOutt6 (java.lang.String outt6) {
		this.outt6 = outt6;
	}



	/**
	 * Return the value associated with the column: d7
	 */
	public java.lang.String getD7 () {
		return d7;
	}

	/**
	 * Set the value related to the column: d7
	 * @param d7 the d7 value
	 */
	public void setD7 (java.lang.String d7) {
		this.d7 = d7;
	}



	/**
	 * Return the value associated with the column: intt7
	 */
	public java.lang.String getIntt7 () {
		return intt7;
	}

	/**
	 * Set the value related to the column: intt7
	 * @param intt7 the intt7 value
	 */
	public void setIntt7 (java.lang.String intt7) {
		this.intt7 = intt7;
	}



	/**
	 * Return the value associated with the column: outt7
	 */
	public java.lang.String getOutt7 () {
		return outt7;
	}

	/**
	 * Set the value related to the column: outt7
	 * @param outt7 the outt7 value
	 */
	public void setOutt7 (java.lang.String outt7) {
		this.outt7 = outt7;
	}



	/**
	 * Return the value associated with the column: d8
	 */
	public java.lang.String getD8 () {
		return d8;
	}

	/**
	 * Set the value related to the column: d8
	 * @param d8 the d8 value
	 */
	public void setD8 (java.lang.String d8) {
		this.d8 = d8;
	}



	/**
	 * Return the value associated with the column: intt8
	 */
	public java.lang.String getIntt8 () {
		return intt8;
	}

	/**
	 * Set the value related to the column: intt8
	 * @param intt8 the intt8 value
	 */
	public void setIntt8 (java.lang.String intt8) {
		this.intt8 = intt8;
	}



	/**
	 * Return the value associated with the column: outt8
	 */
	public java.lang.String getOutt8 () {
		return outt8;
	}

	/**
	 * Set the value related to the column: outt8
	 * @param outt8 the outt8 value
	 */
	public void setOutt8 (java.lang.String outt8) {
		this.outt8 = outt8;
	}



	/**
	 * Return the value associated with the column: d9
	 */
	public java.lang.String getD9 () {
		return d9;
	}

	/**
	 * Set the value related to the column: d9
	 * @param d9 the d9 value
	 */
	public void setD9 (java.lang.String d9) {
		this.d9 = d9;
	}



	/**
	 * Return the value associated with the column: intt9
	 */
	public java.lang.String getIntt9 () {
		return intt9;
	}

	/**
	 * Set the value related to the column: intt9
	 * @param intt9 the intt9 value
	 */
	public void setIntt9 (java.lang.String intt9) {
		this.intt9 = intt9;
	}



	/**
	 * Return the value associated with the column: outt9
	 */
	public java.lang.String getOutt9 () {
		return outt9;
	}

	/**
	 * Set the value related to the column: outt9
	 * @param outt9 the outt9 value
	 */
	public void setOutt9 (java.lang.String outt9) {
		this.outt9 = outt9;
	}



	/**
	 * Return the value associated with the column: d10
	 */
	public java.lang.String getD10 () {
		return d10;
	}

	/**
	 * Set the value related to the column: d10
	 * @param d10 the d10 value
	 */
	public void setD10 (java.lang.String d10) {
		this.d10 = d10;
	}



	/**
	 * Return the value associated with the column: intt10
	 */
	public java.lang.String getIntt10 () {
		return intt10;
	}

	/**
	 * Set the value related to the column: intt10
	 * @param intt10 the intt10 value
	 */
	public void setIntt10 (java.lang.String intt10) {
		this.intt10 = intt10;
	}



	/**
	 * Return the value associated with the column: outt10
	 */
	public java.lang.String getOutt10 () {
		return outt10;
	}

	/**
	 * Set the value related to the column: outt10
	 * @param outt10 the outt10 value
	 */
	public void setOutt10 (java.lang.String outt10) {
		this.outt10 = outt10;
	}



	/**
	 * Return the value associated with the column: d11
	 */
	public java.lang.String getD11 () {
		return d11;
	}

	/**
	 * Set the value related to the column: d11
	 * @param d11 the d11 value
	 */
	public void setD11 (java.lang.String d11) {
		this.d11 = d11;
	}



	/**
	 * Return the value associated with the column: intt11
	 */
	public java.lang.String getIntt11 () {
		return intt11;
	}

	/**
	 * Set the value related to the column: intt11
	 * @param intt11 the intt11 value
	 */
	public void setIntt11 (java.lang.String intt11) {
		this.intt11 = intt11;
	}



	/**
	 * Return the value associated with the column: outt11
	 */
	public java.lang.String getOutt11 () {
		return outt11;
	}

	/**
	 * Set the value related to the column: outt11
	 * @param outt11 the outt11 value
	 */
	public void setOutt11 (java.lang.String outt11) {
		this.outt11 = outt11;
	}



	/**
	 * Return the value associated with the column: d12
	 */
	public java.lang.String getD12 () {
		return d12;
	}

	/**
	 * Set the value related to the column: d12
	 * @param d12 the d12 value
	 */
	public void setD12 (java.lang.String d12) {
		this.d12 = d12;
	}



	/**
	 * Return the value associated with the column: intt12
	 */
	public java.lang.String getIntt12 () {
		return intt12;
	}

	/**
	 * Set the value related to the column: intt12
	 * @param intt12 the intt12 value
	 */
	public void setIntt12 (java.lang.String intt12) {
		this.intt12 = intt12;
	}



	/**
	 * Return the value associated with the column: outt12
	 */
	public java.lang.String getOutt12 () {
		return outt12;
	}

	/**
	 * Set the value related to the column: outt12
	 * @param outt12 the outt12 value
	 */
	public void setOutt12 (java.lang.String outt12) {
		this.outt12 = outt12;
	}



	/**
	 * Return the value associated with the column: d13
	 */
	public java.lang.String getD13 () {
		return d13;
	}

	/**
	 * Set the value related to the column: d13
	 * @param d13 the d13 value
	 */
	public void setD13 (java.lang.String d13) {
		this.d13 = d13;
	}



	/**
	 * Return the value associated with the column: intt13
	 */
	public java.lang.String getIntt13 () {
		return intt13;
	}

	/**
	 * Set the value related to the column: intt13
	 * @param intt13 the intt13 value
	 */
	public void setIntt13 (java.lang.String intt13) {
		this.intt13 = intt13;
	}



	/**
	 * Return the value associated with the column: outt13
	 */
	public java.lang.String getOutt13 () {
		return outt13;
	}

	/**
	 * Set the value related to the column: outt13
	 * @param outt13 the outt13 value
	 */
	public void setOutt13 (java.lang.String outt13) {
		this.outt13 = outt13;
	}



	/**
	 * Return the value associated with the column: d14
	 */
	public java.lang.String getD14 () {
		return d14;
	}

	/**
	 * Set the value related to the column: d14
	 * @param d14 the d14 value
	 */
	public void setD14 (java.lang.String d14) {
		this.d14 = d14;
	}



	/**
	 * Return the value associated with the column: intt14
	 */
	public java.lang.String getIntt14 () {
		return intt14;
	}

	/**
	 * Set the value related to the column: intt14
	 * @param intt14 the intt14 value
	 */
	public void setIntt14 (java.lang.String intt14) {
		this.intt14 = intt14;
	}



	/**
	 * Return the value associated with the column: outt14
	 */
	public java.lang.String getOutt14 () {
		return outt14;
	}

	/**
	 * Set the value related to the column: outt14
	 * @param outt14 the outt14 value
	 */
	public void setOutt14 (java.lang.String outt14) {
		this.outt14 = outt14;
	}



	/**
	 * Return the value associated with the column: d15
	 */
	public java.lang.String getD15 () {
		return d15;
	}

	/**
	 * Set the value related to the column: d15
	 * @param d15 the d15 value
	 */
	public void setD15 (java.lang.String d15) {
		this.d15 = d15;
	}



	/**
	 * Return the value associated with the column: intt15
	 */
	public java.lang.String getIntt15 () {
		return intt15;
	}

	/**
	 * Set the value related to the column: intt15
	 * @param intt15 the intt15 value
	 */
	public void setIntt15 (java.lang.String intt15) {
		this.intt15 = intt15;
	}



	/**
	 * Return the value associated with the column: outt15
	 */
	public java.lang.String getOutt15 () {
		return outt15;
	}

	/**
	 * Set the value related to the column: outt15
	 * @param outt15 the outt15 value
	 */
	public void setOutt15 (java.lang.String outt15) {
		this.outt15 = outt15;
	}



	/**
	 * Return the value associated with the column: d16
	 */
	public java.lang.String getD16 () {
		return d16;
	}

	/**
	 * Set the value related to the column: d16
	 * @param d16 the d16 value
	 */
	public void setD16 (java.lang.String d16) {
		this.d16 = d16;
	}



	/**
	 * Return the value associated with the column: intt16
	 */
	public java.lang.String getIntt16 () {
		return intt16;
	}

	/**
	 * Set the value related to the column: intt16
	 * @param intt16 the intt16 value
	 */
	public void setIntt16 (java.lang.String intt16) {
		this.intt16 = intt16;
	}



	/**
	 * Return the value associated with the column: outt16
	 */
	public java.lang.String getOutt16 () {
		return outt16;
	}

	/**
	 * Set the value related to the column: outt16
	 * @param outt16 the outt16 value
	 */
	public void setOutt16 (java.lang.String outt16) {
		this.outt16 = outt16;
	}



	/**
	 * Return the value associated with the column: d17
	 */
	public java.lang.String getD17 () {
		return d17;
	}

	/**
	 * Set the value related to the column: d17
	 * @param d17 the d17 value
	 */
	public void setD17 (java.lang.String d17) {
		this.d17 = d17;
	}



	/**
	 * Return the value associated with the column: intt17
	 */
	public java.lang.String getIntt17 () {
		return intt17;
	}

	/**
	 * Set the value related to the column: intt17
	 * @param intt17 the intt17 value
	 */
	public void setIntt17 (java.lang.String intt17) {
		this.intt17 = intt17;
	}



	/**
	 * Return the value associated with the column: outt17
	 */
	public java.lang.String getOutt17 () {
		return outt17;
	}

	/**
	 * Set the value related to the column: outt17
	 * @param outt17 the outt17 value
	 */
	public void setOutt17 (java.lang.String outt17) {
		this.outt17 = outt17;
	}



	/**
	 * Return the value associated with the column: d18
	 */
	public java.lang.String getD18 () {
		return d18;
	}

	/**
	 * Set the value related to the column: d18
	 * @param d18 the d18 value
	 */
	public void setD18 (java.lang.String d18) {
		this.d18 = d18;
	}



	/**
	 * Return the value associated with the column: intt18
	 */
	public java.lang.String getIntt18 () {
		return intt18;
	}

	/**
	 * Set the value related to the column: intt18
	 * @param intt18 the intt18 value
	 */
	public void setIntt18 (java.lang.String intt18) {
		this.intt18 = intt18;
	}



	/**
	 * Return the value associated with the column: outt18
	 */
	public java.lang.String getOutt18 () {
		return outt18;
	}

	/**
	 * Set the value related to the column: outt18
	 * @param outt18 the outt18 value
	 */
	public void setOutt18 (java.lang.String outt18) {
		this.outt18 = outt18;
	}



	/**
	 * Return the value associated with the column: d19
	 */
	public java.lang.String getD19 () {
		return d19;
	}

	/**
	 * Set the value related to the column: d19
	 * @param d19 the d19 value
	 */
	public void setD19 (java.lang.String d19) {
		this.d19 = d19;
	}



	/**
	 * Return the value associated with the column: intt19
	 */
	public java.lang.String getIntt19 () {
		return intt19;
	}

	/**
	 * Set the value related to the column: intt19
	 * @param intt19 the intt19 value
	 */
	public void setIntt19 (java.lang.String intt19) {
		this.intt19 = intt19;
	}



	/**
	 * Return the value associated with the column: outt19
	 */
	public java.lang.String getOutt19 () {
		return outt19;
	}

	/**
	 * Set the value related to the column: outt19
	 * @param outt19 the outt19 value
	 */
	public void setOutt19 (java.lang.String outt19) {
		this.outt19 = outt19;
	}



	/**
	 * Return the value associated with the column: d20
	 */
	public java.lang.String getD20 () {
		return d20;
	}

	/**
	 * Set the value related to the column: d20
	 * @param d20 the d20 value
	 */
	public void setD20 (java.lang.String d20) {
		this.d20 = d20;
	}



	/**
	 * Return the value associated with the column: intt20
	 */
	public java.lang.String getIntt20 () {
		return intt20;
	}

	/**
	 * Set the value related to the column: intt20
	 * @param intt20 the intt20 value
	 */
	public void setIntt20 (java.lang.String intt20) {
		this.intt20 = intt20;
	}



	/**
	 * Return the value associated with the column: outt20
	 */
	public java.lang.String getOutt20 () {
		return outt20;
	}

	/**
	 * Set the value related to the column: outt20
	 * @param outt20 the outt20 value
	 */
	public void setOutt20 (java.lang.String outt20) {
		this.outt20 = outt20;
	}



	/**
	 * Return the value associated with the column: d21
	 */
	public java.lang.String getD21 () {
		return d21;
	}

	/**
	 * Set the value related to the column: d21
	 * @param d21 the d21 value
	 */
	public void setD21 (java.lang.String d21) {
		this.d21 = d21;
	}



	/**
	 * Return the value associated with the column: intt21
	 */
	public java.lang.String getIntt21 () {
		return intt21;
	}

	/**
	 * Set the value related to the column: intt21
	 * @param intt21 the intt21 value
	 */
	public void setIntt21 (java.lang.String intt21) {
		this.intt21 = intt21;
	}



	/**
	 * Return the value associated with the column: outt21
	 */
	public java.lang.String getOutt21 () {
		return outt21;
	}

	/**
	 * Set the value related to the column: outt21
	 * @param outt21 the outt21 value
	 */
	public void setOutt21 (java.lang.String outt21) {
		this.outt21 = outt21;
	}



	/**
	 * Return the value associated with the column: d22
	 */
	public java.lang.String getD22 () {
		return d22;
	}

	/**
	 * Set the value related to the column: d22
	 * @param d22 the d22 value
	 */
	public void setD22 (java.lang.String d22) {
		this.d22 = d22;
	}



	/**
	 * Return the value associated with the column: intt22
	 */
	public java.lang.String getIntt22 () {
		return intt22;
	}

	/**
	 * Set the value related to the column: intt22
	 * @param intt22 the intt22 value
	 */
	public void setIntt22 (java.lang.String intt22) {
		this.intt22 = intt22;
	}



	/**
	 * Return the value associated with the column: outt22
	 */
	public java.lang.String getOutt22 () {
		return outt22;
	}

	/**
	 * Set the value related to the column: outt22
	 * @param outt22 the outt22 value
	 */
	public void setOutt22 (java.lang.String outt22) {
		this.outt22 = outt22;
	}



	/**
	 * Return the value associated with the column: d23
	 */
	public java.lang.String getD23 () {
		return d23;
	}

	/**
	 * Set the value related to the column: d23
	 * @param d23 the d23 value
	 */
	public void setD23 (java.lang.String d23) {
		this.d23 = d23;
	}



	/**
	 * Return the value associated with the column: intt23
	 */
	public java.lang.String getIntt23 () {
		return intt23;
	}

	/**
	 * Set the value related to the column: intt23
	 * @param intt23 the intt23 value
	 */
	public void setIntt23 (java.lang.String intt23) {
		this.intt23 = intt23;
	}



	/**
	 * Return the value associated with the column: outt23
	 */
	public java.lang.String getOutt23 () {
		return outt23;
	}

	/**
	 * Set the value related to the column: outt23
	 * @param outt23 the outt23 value
	 */
	public void setOutt23 (java.lang.String outt23) {
		this.outt23 = outt23;
	}



	/**
	 * Return the value associated with the column: d24
	 */
	public java.lang.String getD24 () {
		return d24;
	}

	/**
	 * Set the value related to the column: d24
	 * @param d24 the d24 value
	 */
	public void setD24 (java.lang.String d24) {
		this.d24 = d24;
	}



	/**
	 * Return the value associated with the column: intt24
	 */
	public java.lang.String getIntt24 () {
		return intt24;
	}

	/**
	 * Set the value related to the column: intt24
	 * @param intt24 the intt24 value
	 */
	public void setIntt24 (java.lang.String intt24) {
		this.intt24 = intt24;
	}



	/**
	 * Return the value associated with the column: outt24
	 */
	public java.lang.String getOutt24 () {
		return outt24;
	}

	/**
	 * Set the value related to the column: outt24
	 * @param outt24 the outt24 value
	 */
	public void setOutt24 (java.lang.String outt24) {
		this.outt24 = outt24;
	}



	/**
	 * Return the value associated with the column: d25
	 */
	public java.lang.String getD25 () {
		return d25;
	}

	/**
	 * Set the value related to the column: d25
	 * @param d25 the d25 value
	 */
	public void setD25 (java.lang.String d25) {
		this.d25 = d25;
	}



	/**
	 * Return the value associated with the column: intt25
	 */
	public java.lang.String getIntt25 () {
		return intt25;
	}

	/**
	 * Set the value related to the column: intt25
	 * @param intt25 the intt25 value
	 */
	public void setIntt25 (java.lang.String intt25) {
		this.intt25 = intt25;
	}



	/**
	 * Return the value associated with the column: outt25
	 */
	public java.lang.String getOutt25 () {
		return outt25;
	}

	/**
	 * Set the value related to the column: outt25
	 * @param outt25 the outt25 value
	 */
	public void setOutt25 (java.lang.String outt25) {
		this.outt25 = outt25;
	}



	/**
	 * Return the value associated with the column: d26
	 */
	public java.lang.String getD26 () {
		return d26;
	}

	/**
	 * Set the value related to the column: d26
	 * @param d26 the d26 value
	 */
	public void setD26 (java.lang.String d26) {
		this.d26 = d26;
	}



	/**
	 * Return the value associated with the column: intt26
	 */
	public java.lang.String getIntt26 () {
		return intt26;
	}

	/**
	 * Set the value related to the column: intt26
	 * @param intt26 the intt26 value
	 */
	public void setIntt26 (java.lang.String intt26) {
		this.intt26 = intt26;
	}



	/**
	 * Return the value associated with the column: outt26
	 */
	public java.lang.String getOutt26 () {
		return outt26;
	}

	/**
	 * Set the value related to the column: outt26
	 * @param outt26 the outt26 value
	 */
	public void setOutt26 (java.lang.String outt26) {
		this.outt26 = outt26;
	}



	/**
	 * Return the value associated with the column: d27
	 */
	public java.lang.String getD27 () {
		return d27;
	}

	/**
	 * Set the value related to the column: d27
	 * @param d27 the d27 value
	 */
	public void setD27 (java.lang.String d27) {
		this.d27 = d27;
	}



	/**
	 * Return the value associated with the column: intt27
	 */
	public java.lang.String getIntt27 () {
		return intt27;
	}

	/**
	 * Set the value related to the column: intt27
	 * @param intt27 the intt27 value
	 */
	public void setIntt27 (java.lang.String intt27) {
		this.intt27 = intt27;
	}



	/**
	 * Return the value associated with the column: outt27
	 */
	public java.lang.String getOutt27 () {
		return outt27;
	}

	/**
	 * Set the value related to the column: outt27
	 * @param outt27 the outt27 value
	 */
	public void setOutt27 (java.lang.String outt27) {
		this.outt27 = outt27;
	}



	/**
	 * Return the value associated with the column: d28
	 */
	public java.lang.String getD28 () {
		return d28;
	}

	/**
	 * Set the value related to the column: d28
	 * @param d28 the d28 value
	 */
	public void setD28 (java.lang.String d28) {
		this.d28 = d28;
	}



	/**
	 * Return the value associated with the column: intt28
	 */
	public java.lang.String getIntt28 () {
		return intt28;
	}

	/**
	 * Set the value related to the column: intt28
	 * @param intt28 the intt28 value
	 */
	public void setIntt28 (java.lang.String intt28) {
		this.intt28 = intt28;
	}



	/**
	 * Return the value associated with the column: outt28
	 */
	public java.lang.String getOutt28 () {
		return outt28;
	}

	/**
	 * Set the value related to the column: outt28
	 * @param outt28 the outt28 value
	 */
	public void setOutt28 (java.lang.String outt28) {
		this.outt28 = outt28;
	}



	/**
	 * Return the value associated with the column: d29
	 */
	public java.lang.String getD29 () {
		return d29;
	}

	/**
	 * Set the value related to the column: d29
	 * @param d29 the d29 value
	 */
	public void setD29 (java.lang.String d29) {
		this.d29 = d29;
	}



	/**
	 * Return the value associated with the column: intt29
	 */
	public java.lang.String getIntt29 () {
		return intt29;
	}

	/**
	 * Set the value related to the column: intt29
	 * @param intt29 the intt29 value
	 */
	public void setIntt29 (java.lang.String intt29) {
		this.intt29 = intt29;
	}



	/**
	 * Return the value associated with the column: outt29
	 */
	public java.lang.String getOutt29 () {
		return outt29;
	}

	/**
	 * Set the value related to the column: outt29
	 * @param outt29 the outt29 value
	 */
	public void setOutt29 (java.lang.String outt29) {
		this.outt29 = outt29;
	}



	/**
	 * Return the value associated with the column: d30
	 */
	public java.lang.String getD30 () {
		return d30;
	}

	/**
	 * Set the value related to the column: d30
	 * @param d30 the d30 value
	 */
	public void setD30 (java.lang.String d30) {
		this.d30 = d30;
	}



	/**
	 * Return the value associated with the column: intt30
	 */
	public java.lang.String getIntt30 () {
		return intt30;
	}

	/**
	 * Set the value related to the column: intt30
	 * @param intt30 the intt30 value
	 */
	public void setIntt30 (java.lang.String intt30) {
		this.intt30 = intt30;
	}



	/**
	 * Return the value associated with the column: outt30
	 */
	public java.lang.String getOutt30 () {
		return outt30;
	}

	/**
	 * Set the value related to the column: outt30
	 * @param outt30 the outt30 value
	 */
	public void setOutt30 (java.lang.String outt30) {
		this.outt30 = outt30;
	}



	/**
	 * Return the value associated with the column: d31
	 */
	public java.lang.String getD31 () {
		return d31;
	}

	/**
	 * Set the value related to the column: d31
	 * @param d31 the d31 value
	 */
	public void setD31 (java.lang.String d31) {
		this.d31 = d31;
	}



	/**
	 * Return the value associated with the column: intt31
	 */
	public java.lang.String getIntt31 () {
		return intt31;
	}

	/**
	 * Set the value related to the column: intt31
	 * @param intt31 the intt31 value
	 */
	public void setIntt31 (java.lang.String intt31) {
		this.intt31 = intt31;
	}



	/**
	 * Return the value associated with the column: outt31
	 */
	public java.lang.String getOutt31 () {
		return outt31;
	}

	/**
	 * Set the value related to the column: outt31
	 * @param outt31 the outt31 value
	 */
	public void setOutt31 (java.lang.String outt31) {
		this.outt31 = outt31;
	}



	/**
	 * Return the value associated with the column: checktype
	 */
	public java.lang.String getChecktype () {
		return checktype;
	}

	/**
	 * Set the value related to the column: checktype
	 * @param checktype the checktype value
	 */
	public void setChecktype (java.lang.String checktype) {
		this.checktype = checktype;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.TempCheckInOutFinal)) return false;
		else {
			jkt.hms.masters.business.TempCheckInOutFinal tempCheckInOutFinal = (jkt.hms.masters.business.TempCheckInOutFinal) obj;
			if (null == this.getId() || null == tempCheckInOutFinal.getId()) return false;
			else return (this.getId().equals(tempCheckInOutFinal.getId()));
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