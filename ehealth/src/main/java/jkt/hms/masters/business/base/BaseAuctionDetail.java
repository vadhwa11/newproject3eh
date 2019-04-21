package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the auction_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="auction_detail"
 */

public abstract class BaseAuctionDetail  implements Serializable {

	public static String REF = "AuctionDetail";
	public static String PROP_PARTY_ADD = "PartyAdd";
	public static String PROP_AUCTION_DATE = "AuctionDate";
	public static String PROP_AUCTION_AMT = "AuctionAmt";
	public static String PROP_AUTHERIZE = "Autherize";
	public static String PROP_EQUEPMENT = "Equepment";
	public static String PROP_ASSET = "Asset";
	public static String PROP_PARTY_NAME = "PartyName";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_CONTACT_NO = "ContactNo";


	// constructors
	public BaseAuctionDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAuctionDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date auctionDate;
	private java.lang.String partyName;
	private java.lang.String partyAdd;
	private java.lang.String auctionAmt;
	private java.lang.String contactNo;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.PrqAssetDetails asset;
	private jkt.hms.masters.business.HesEquipmentMaster equepment;
	private jkt.hms.masters.business.MasEmployee autherize;



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
	 * Return the value associated with the column: auction_date
	 */
	public java.util.Date getAuctionDate () {
		return auctionDate;
	}

	/**
	 * Set the value related to the column: auction_date
	 * @param auctionDate the auction_date value
	 */
	public void setAuctionDate (java.util.Date auctionDate) {
		this.auctionDate = auctionDate;
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
	 * Return the value associated with the column: party_add
	 */
	public java.lang.String getPartyAdd () {
		return partyAdd;
	}

	/**
	 * Set the value related to the column: party_add
	 * @param partyAdd the party_add value
	 */
	public void setPartyAdd (java.lang.String partyAdd) {
		this.partyAdd = partyAdd;
	}



	/**
	 * Return the value associated with the column: auction_amt
	 */
	public java.lang.String getAuctionAmt () {
		return auctionAmt;
	}

	/**
	 * Set the value related to the column: auction_amt
	 * @param auctionAmt the auction_amt value
	 */
	public void setAuctionAmt (java.lang.String auctionAmt) {
		this.auctionAmt = auctionAmt;
	}



	/**
	 * Return the value associated with the column: contact_no
	 */
	public java.lang.String getContactNo () {
		return contactNo;
	}

	/**
	 * Set the value related to the column: contact_no
	 * @param contactNo the contact_no value
	 */
	public void setContactNo (java.lang.String contactNo) {
		this.contactNo = contactNo;
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
	 * Return the value associated with the column: asset_id
	 */
	public jkt.hms.masters.business.PrqAssetDetails getAsset () {
		return asset;
	}

	/**
	 * Set the value related to the column: asset_id
	 * @param asset the asset_id value
	 */
	public void setAsset (jkt.hms.masters.business.PrqAssetDetails asset) {
		this.asset = asset;
	}



	/**
	 * Return the value associated with the column: equepment_id
	 */
	public jkt.hms.masters.business.HesEquipmentMaster getEquepment () {
		return equepment;
	}

	/**
	 * Set the value related to the column: equepment_id
	 * @param equepment the equepment_id value
	 */
	public void setEquepment (jkt.hms.masters.business.HesEquipmentMaster equepment) {
		this.equepment = equepment;
	}



	/**
	 * Return the value associated with the column: autherize_id
	 */
	public jkt.hms.masters.business.MasEmployee getAutherize () {
		return autherize;
	}

	/**
	 * Set the value related to the column: autherize_id
	 * @param autherize the autherize_id value
	 */
	public void setAutherize (jkt.hms.masters.business.MasEmployee autherize) {
		this.autherize = autherize;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AuctionDetail)) return false;
		else {
			jkt.hms.masters.business.AuctionDetail auctionDetail = (jkt.hms.masters.business.AuctionDetail) obj;
			if (null == this.getId() || null == auctionDetail.getId()) return false;
			else return (this.getId().equals(auctionDetail.getId()));
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