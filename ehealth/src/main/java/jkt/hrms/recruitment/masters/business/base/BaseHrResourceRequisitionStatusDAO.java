package jkt.hrms.recruitment.masters.business.base;

import jkt.hrms.recruitment.masters.business.dao.iface.HrResourceRequisitionStatusDAO;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseHrResourceRequisitionStatusDAO extends
		jkt.hrms.recruitment.masters.business.dao._RootDAO {

	public BaseHrResourceRequisitionStatusDAO() {
	}

	public BaseHrResourceRequisitionStatusDAO(Session session) {
		super(session);
	}

	// query name references

	public static HrResourceRequisitionStatusDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static HrResourceRequisitionStatusDAO getInstance() {
		if (null == instance) {
			instance = new jkt.hrms.recruitment.masters.business.dao.HrResourceRequisitionStatusDAO();
		}
		return instance;
	}

	public Class getReferenceClass() {
		return jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus.class;
	}

	public Order getDefaultOrder() {
		return null;
	}

	/**
	 * Cast the object as a
	 * jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus
	 */
	public jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus cast(
			Object object) {
		return (jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus) object;
	}

	public jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus get(
			java.lang.Integer key) {
		return (jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus) get(
				getReferenceClass(), key);
	}

	public jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus get(
			java.lang.Integer key, Session s) {
		return (jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus) get(
				getReferenceClass(), key, s);
	}

	public jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus load(
			java.lang.Integer key) {
		return (jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus) load(
				getReferenceClass(), key);
	}

	public jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus load(
			java.lang.Integer key, Session s) {
		return (jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus) load(
				getReferenceClass(), key, s);
	}

	public jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus loadInitialize(
			java.lang.Integer key, Session s) {
		jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus obj = load(
				key, s);
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		}
		return obj;
	}

	/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no
	 * filter.
	 */
	public java.util.List<jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus> findAll() {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no
	 * filter.
	 */
	public java.util.List<jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus> findAll(
			Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no
	 * filter. Use the session given.
	 * 
	 * @param s
	 *            the Session
	 */
	public java.util.List<jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus> findAll(
			Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated
	 * identifier. (Or using the current value of the identifier property if the
	 * assigned generator is used.)
	 * 
	 * @param hrResourceRequisitionStatus
	 *            a transient instance of a persistent class
	 * @return the class identifier
	 */
	public java.lang.Integer save(
			jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus hrResourceRequisitionStatus) {
		return (java.lang.Integer) super.save(hrResourceRequisitionStatus);
	}

	/**
	 * Persist the given transient instance, first assigning a generated
	 * identifier. (Or using the current value of the identifier property if the
	 * assigned generator is used.) Use the Session given.
	 * 
	 * @param hrResourceRequisitionStatus
	 *            a transient instance of a persistent class
	 * @param s
	 *            the Session
	 * @return the class identifier
	 */
	public java.lang.Integer save(
			jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus hrResourceRequisitionStatus,
			Session s) {
		return (java.lang.Integer) save((Object) hrResourceRequisitionStatus, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of
	 * its identifier property. By default the instance is always saved. This
	 * behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping.
	 * 
	 * @param hrResourceRequisitionStatus
	 *            a transient instance containing new or updated state
	 */
	public void saveOrUpdate(
			jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus hrResourceRequisitionStatus) {
		saveOrUpdate((Object) hrResourceRequisitionStatus);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of
	 * its identifier property. By default the instance is always saved. This
	 * behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. Use the Session given.
	 * 
	 * @param hrResourceRequisitionStatus
	 *            a transient instance containing new or updated state.
	 * @param s
	 *            the Session.
	 */
	public void saveOrUpdate(
			jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus hrResourceRequisitionStatus,
			Session s) {
		saveOrUpdate((Object) hrResourceRequisitionStatus, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An
	 * exception is thrown if there is a persistent instance with the same
	 * identifier in the current session.
	 * 
	 * @param hrResourceRequisitionStatus
	 *            a transient instance containing updated state
	 */
	public void update(
			jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus hrResourceRequisitionStatus) {
		update((Object) hrResourceRequisitionStatus);
	}

	/**
	 * Update the persistent state associated with the given identifier. An
	 * exception is thrown if there is a persistent instance with the same
	 * identifier in the current session. Use the Session given.
	 * 
	 * @param hrResourceRequisitionStatus
	 *            a transient instance containing updated state
	 * @param the
	 *            Session
	 */
	public void update(
			jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus hrResourceRequisitionStatus,
			Session s) {
		update((Object) hrResourceRequisitionStatus, s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an
	 * instance associated with the receiving Session or a transient instance
	 * with an identifier associated with existing persistent state.
	 * 
	 * @param id
	 *            the instance ID to be removed
	 */
	public void delete(java.lang.Integer id) {
		delete((Object) load(id));
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an
	 * instance associated with the receiving Session or a transient instance
	 * with an identifier associated with existing persistent state. Use the
	 * Session given.
	 * 
	 * @param id
	 *            the instance ID to be removed
	 * @param s
	 *            the Session
	 */
	public void delete(java.lang.Integer id, Session s) {
		delete((Object) load(id, s), s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an
	 * instance associated with the receiving Session or a transient instance
	 * with an identifier associated with existing persistent state.
	 * 
	 * @param hrResourceRequisitionStatus
	 *            the instance to be removed
	 */
	public void delete(
			jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus hrResourceRequisitionStatus) {
		delete((Object) hrResourceRequisitionStatus);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an
	 * instance associated with the receiving Session or a transient instance
	 * with an identifier associated with existing persistent state. Use the
	 * Session given.
	 * 
	 * @param hrResourceRequisitionStatus
	 *            the instance to be removed
	 * @param s
	 *            the Session
	 */
	public void delete(
			jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus hrResourceRequisitionStatus,
			Session s) {
		delete((Object) hrResourceRequisitionStatus, s);
	}

	/**
	 * Re-read the state of the given instance from the underlying database. It
	 * is inadvisable to use this to implement long-running sessions that span
	 * many business tasks. This method is, however, useful in certain special
	 * circumstances. For example
	 * <ul>
	 * <li>where a database trigger alters the object state upon insert or
	 * update</li>
	 * <li>after executing direct SQL (eg. a mass update) in the same session</li>
	 * <li>after inserting a Blob or Clob</li>
	 * </ul>
	 */
	public void refresh(
			jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus hrResourceRequisitionStatus,
			Session s) {
		refresh((Object) hrResourceRequisitionStatus, s);
	}

}