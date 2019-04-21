package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mm_auction_participent table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mm_auction_participent"
 */

public abstract class BaseMmAuctionParticipent  implements Serializable {

	public static String REF = "MmAuctionParticipent";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_FORM_NO = "FormNo";
	public static String PROP_PARTY_NAME = "PartyName";
	public static String PROP_ID = "Id";
	public static String PROP_REQUEST = "Request";


	// constructors
	public BaseMmAuctionParticipent () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMmAuctionParticipent (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String formNo;
	private java.lang.String partyName;
	private java.math.BigDecimal amount;

	// many to one
	private jkt.hms.masters.business.MmServiceRequest request;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="party_id"
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
	 * Return the value associated with the column: form_no
	 */
	public java.lang.String getFormNo () {
		return formNo;
	}

	/**
	 * Set the value related to the column: form_no
	 * @param formNo the form_no value
	 */
	public void setFormNo (java.lang.String formNo) {
		this.formNo = formNo;
	}



	/**
	 * Return the value associated with the column: party_name
	 */
	public java.lang.String getPartyName () {
		return partyName;
	}

	/**
	 * Set the value related to the column: party_name
	 * @param partyName the party_name value
	 */
	public void setPartyName (java.lang.String partyName) {
		this.partyName = partyName;
	}



	/**
	 * Return the value associated with the column: amount
	 */
	public java.math.BigDecimal getAmount () {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * @param amount the amount value
	 */
	public void setAmount (java.math.BigDecimal amount) {
		this.amount = amount;
	}



	/**
	 * Return the value associated with the column: request_id
	 */
	public jkt.hms.masters.business.MmServiceRequest getRequest () {
		return request;
	}

	/**
	 * Set the value related to the column: request_id
	 * @param request the request_id value
	 */
	public void setRequest (jkt.hms.masters.business.MmServiceRequest request) {
		this.request = request;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MmAuctionParticipent)) return false;
		else {
			jkt.hms.masters.business.MmAuctionParticipent mmAuctionParticipent = (jkt.hms.masters.business.MmAuctionParticipent) obj;
			if (null == this.getId() || null == mmAuctionParticipent.getId()) return false;
			else return (this.getId().equals(mmAuctionParticipent.getId()));
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