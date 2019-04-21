package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the lab_machine_xt2000i_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="lab_machine_xt2000i_details"
 */

public abstract class BaseLabMachineXt2000iDetails  implements Serializable {

	public static String REF = "LabMachineXt2000iDetails";
	public static String PROP_MACHINE_CODE = "MachineCode";
	public static String PROP_SUB_INVESTIGATION_ID = "SubInvestigationId";
	public static String PROP_INVESTIGATION_ID = "InvestigationId";
	public static String PROP_ID = "Id";
	public static String PROP_PARAMETER_NAME = "ParameterName";
	public static String PROP_STATUS = "Status";


	// constructors
	public BaseLabMachineXt2000iDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLabMachineXt2000iDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String parameterName;
	private java.lang.Integer investigationId;
	private java.lang.Integer subInvestigationId;
	private java.lang.String machineCode;
	private java.lang.String status;



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
	 * Return the value associated with the column: parameter_name
	 */
	public java.lang.String getParameterName () {
		return parameterName;
	}

	/**
	 * Set the value related to the column: parameter_name
	 * @param parameterName the parameter_name value
	 */
	public void setParameterName (java.lang.String parameterName) {
		this.parameterName = parameterName;
	}



	/**
	 * Return the value associated with the column: investigation_id
	 */
	public java.lang.Integer getInvestigationId () {
		return investigationId;
	}

	/**
	 * Set the value related to the column: investigation_id
	 * @param investigationId the investigation_id value
	 */
	public void setInvestigationId (java.lang.Integer investigationId) {
		this.investigationId = investigationId;
	}



	/**
	 * Return the value associated with the column: sub_investigation_id
	 */
	public java.lang.Integer getSubInvestigationId () {
		return subInvestigationId;
	}

	/**
	 * Set the value related to the column: sub_investigation_id
	 * @param subInvestigationId the sub_investigation_id value
	 */
	public void setSubInvestigationId (java.lang.Integer subInvestigationId) {
		this.subInvestigationId = subInvestigationId;
	}


	
	

	public java.lang.String getStatus() {
		return status;
	}

	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: machine_code
	 */
	public java.lang.String getMachineCode () {
		return machineCode;
	}

	/**
	 * Set the value related to the column: machine_code
	 * @param machineCode the machine_code value
	 */
	public void setMachineCode (java.lang.String machineCode) {
		this.machineCode = machineCode;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.LabMachineXt2000iDetails)) return false;
		else {
			jkt.hms.masters.business.LabMachineXt2000iDetails labMachineXt2000iDetails = (jkt.hms.masters.business.LabMachineXt2000iDetails) obj;
			if (null == this.getId() || null == labMachineXt2000iDetails.getId()) return false;
			else return (this.getId().equals(labMachineXt2000iDetails.getId()));
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