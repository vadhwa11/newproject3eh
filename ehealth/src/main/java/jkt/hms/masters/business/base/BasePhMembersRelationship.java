package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_members_relationship table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_members_relationship"
 */

public abstract class BasePhMembersRelationship  implements Serializable {

	public static String REF = "PhMembersRelationship";
	public static String PROP_MEMBER1 = "Member1";
	public static String PROP_RELATIONSHIP_FROM = "RelationshipFrom";
	public static String PROP_RELATION = "Relation";
	public static String PROP_STATUS = "Status";
	public static String PROP_FAMILY_ID = "FamilyId";
	public static String PROP_REGISTRATION_DATE = "RegistrationDate";
	public static String PROP_ECR_STATUS = "EcrStatus";
	public static String PROP_ID = "Id";
	public static String PROP_REGISTRATION_TIME = "RegistrationTime";
	public static String PROP_REGISTRATION_BY = "RegistrationBy";
	public static String PROP_MEMBER2 = "Member2";


	// constructors
	public BasePhMembersRelationship () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhMembersRelationship (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String ecrStatus;
	private java.lang.String relationshipFrom;
	private java.lang.String status;
	private java.util.Date registrationDate;
	private java.lang.String registrationTime;
	private java.lang.Long familyId;

	// many to one
	private jkt.hms.masters.business.MasRelation relation;
	private jkt.hms.masters.business.PhMemberSurvey member1;
	private jkt.hms.masters.business.Users registrationBy;
	private jkt.hms.masters.business.PhMemberSurvey member2;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="relationship_id"
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
	 * Return the value associated with the column: ecr_status
	 */
	public java.lang.String getEcrStatus () {
		return ecrStatus;
	}

	/**
	 * Set the value related to the column: ecr_status
	 * @param ecrStatus the ecr_status value
	 */
	public void setEcrStatus (java.lang.String ecrStatus) {
		this.ecrStatus = ecrStatus;
	}



	/**
	 * Return the value associated with the column: relationship_from
	 */
	public java.lang.String getRelationshipFrom () {
		return relationshipFrom;
	}

	/**
	 * Set the value related to the column: relationship_from
	 * @param relationshipFrom the relationship_from value
	 */
	public void setRelationshipFrom (java.lang.String relationshipFrom) {
		this.relationshipFrom = relationshipFrom;
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
	 * Return the value associated with the column: registration_date
	 */
	public java.util.Date getRegistrationDate () {
		return registrationDate;
	}

	/**
	 * Set the value related to the column: registration_date
	 * @param registrationDate the registration_date value
	 */
	public void setRegistrationDate (java.util.Date registrationDate) {
		this.registrationDate = registrationDate;
	}



	/**
	 * Return the value associated with the column: registration_time
	 */
	public java.lang.String getRegistrationTime () {
		return registrationTime;
	}

	/**
	 * Set the value related to the column: registration_time
	 * @param registrationTime the registration_time value
	 */
	public void setRegistrationTime (java.lang.String registrationTime) {
		this.registrationTime = registrationTime;
	}



	/**
	 * Return the value associated with the column: family_id
	 */
	public java.lang.Long getFamilyId () {
		return familyId;
	}

	/**
	 * Set the value related to the column: family_id
	 * @param familyId the family_id value
	 */
	public void setFamilyId (java.lang.Long familyId) {
		this.familyId = familyId;
	}



	/**
	 * Return the value associated with the column: relation_id
	 */
	public jkt.hms.masters.business.MasRelation getRelation () {
		return relation;
	}

	/**
	 * Set the value related to the column: relation_id
	 * @param relation the relation_id value
	 */
	public void setRelation (jkt.hms.masters.business.MasRelation relation) {
		this.relation = relation;
	}



	/**
	 * Return the value associated with the column: member1_id
	 */
	public jkt.hms.masters.business.PhMemberSurvey getMember1 () {
		return member1;
	}

	/**
	 * Set the value related to the column: member1_id
	 * @param member1 the member1_id value
	 */
	public void setMember1 (jkt.hms.masters.business.PhMemberSurvey member1) {
		this.member1 = member1;
	}



	/**
	 * Return the value associated with the column: registration_by
	 */
	public jkt.hms.masters.business.Users getRegistrationBy () {
		return registrationBy;
	}

	/**
	 * Set the value related to the column: registration_by
	 * @param registrationBy the registration_by value
	 */
	public void setRegistrationBy (jkt.hms.masters.business.Users registrationBy) {
		this.registrationBy = registrationBy;
	}



	/**
	 * Return the value associated with the column: member2_id
	 */
	public jkt.hms.masters.business.PhMemberSurvey getMember2 () {
		return member2;
	}

	/**
	 * Set the value related to the column: member2_id
	 * @param member2 the member2_id value
	 */
	public void setMember2 (jkt.hms.masters.business.PhMemberSurvey member2) {
		this.member2 = member2;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhMembersRelationship)) return false;
		else {
			jkt.hms.masters.business.PhMembersRelationship phMembersRelationship = (jkt.hms.masters.business.PhMembersRelationship) obj;
			if (null == this.getId() || null == phMembersRelationship.getId()) return false;
			else return (this.getId().equals(phMembersRelationship.getId()));
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