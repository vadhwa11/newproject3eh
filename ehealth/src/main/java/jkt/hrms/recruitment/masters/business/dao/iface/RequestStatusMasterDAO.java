package jkt.hrms.recruitment.masters.business.dao.iface;

public interface RequestStatusMasterDAO {
	public jkt.hrms.recruitment.masters.business.RequestStatusMaster get(
			java.lang.Integer key);

	public jkt.hrms.recruitment.masters.business.RequestStatusMaster load(
			java.lang.Integer key);

	public java.util.List<jkt.hrms.recruitment.masters.business.RequestStatusMaster> findAll();

	/**
	 * Persist the given transient instance, first assigning a generated
	 * identifier. (Or using the current value of the identifier property if the
	 * assigned generator is used.)
	 * 
	 * @param requestStatusMaster
	 *            a transient instance of a persistent class
	 * @return the class identifier
	 */
	public java.lang.Integer save(
			jkt.hrms.recruitment.masters.business.RequestStatusMaster requestStatusMaster);

	/**
	 * Either save() or update() the given instance, depending upon the value of
	 * its identifier property. By default the instance is always saved. This
	 * behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping.
	 * 
	 * @param requestStatusMaster
	 *            a transient instance containing new or updated state
	 */
	public void saveOrUpdate(
			jkt.hrms.recruitment.masters.business.RequestStatusMaster requestStatusMaster);

	/**
	 * Update the persistent state associated with the given identifier. An
	 * exception is thrown if there is a persistent instance with the same
	 * identifier in the current session.
	 * 
	 * @param requestStatusMaster
	 *            a transient instance containing updated state
	 */
	public void update(
			jkt.hrms.recruitment.masters.business.RequestStatusMaster requestStatusMaster);

	/**
	 * Remove a persistent instance from the datastore. The argument may be an
	 * instance associated with the receiving Session or a transient instance
	 * with an identifier associated with existing persistent state.
	 * 
	 * @param id
	 *            the instance ID to be removed
	 */
	public void delete(java.lang.Integer id);

	/**
	 * Remove a persistent instance from the datastore. The argument may be an
	 * instance associated with the receiving Session or a transient instance
	 * with an identifier associated with existing persistent state.
	 * 
	 * @param requestStatusMaster
	 *            the instance to be removed
	 */
	public void delete(
			jkt.hrms.recruitment.masters.business.RequestStatusMaster requestStatusMaster);

}