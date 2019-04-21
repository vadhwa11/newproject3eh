package jkt.hrms.recruitment.masters.business.base;

import jkt.hrms.recruitment.masters.business.dao.iface.RequestStatusMasterDAO;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseRequestStatusMasterDAO extends
		jkt.hrms.recruitment.masters.business.dao._RootDAO {

	public BaseRequestStatusMasterDAO() {
	}

	public BaseRequestStatusMasterDAO(Session session) {
		super(session);
	}

	// query name references

	public static RequestStatusMasterDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static RequestStatusMasterDAO getInstance() {
		if (null == instance) {
			instance = new jkt.hrms.recruitment.masters.business.dao.RequestStatusMasterDAO();
		}
		return instance;
	}

	public Class getReferenceClass() {
		return jkt.hrms.recruitment.masters.business.RequestStatusMaster.class;
	}

	public Order getDefaultOrder() {
		return null;
	}

	/**
	 * Cast the object as a
	 * jkt.hrms.recruitment.masters.business.RequestStatusMaster
	 */
	public jkt.hrms.recruitment.masters.business.RequestStatusMaster cast(
			Object object) {
		return (jkt.hrms.recruitment.masters.business.RequestStatusMaster) object;
	}

	public jkt.hrms.recruitment.masters.business.RequestStatusMaster get(
			java.lang.Integer key) {
		return (jkt.hrms.recruitment.masters.business.RequestStatusMaster) get(
				getReferenceClass(), key);
	}

	public jkt.hrms.recruitment.masters.business.RequestStatusMaster get(
			java.lang.Integer key, Session s) {
		return (jkt.hrms.recruitment.masters.business.RequestStatusMaster) get(
				getReferenceClass(), key, s);
	}

	public jkt.hrms.recruitment.masters.business.RequestStatusMaster load(
			java.lang.Integer key) {
		return (jkt.hrms.recruitment.masters.business.RequestStatusMaster) load(
				getReferenceClass(), key);
	}

	public jkt.hrms.recruitment.masters.business.RequestStatusMaster load(
			java.lang.Integer key, Session s) {
		return (jkt.hrms.recruitment.masters.business.RequestStatusMaster) load(
				getReferenceClass(), key, s);
	}

	public jkt.hrms.recruitment.masters.business.RequestStatusMaster loadInitialize(
			java.lang.Integer key, Session s) {
		jkt.hrms.recruitment.masters.business.RequestStatusMaster obj = load(
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
	public java.util.List<jkt.hrms.recruitment.masters.business.RequestStatusMaster> findAll() {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no
	 * filter.
	 */
	public java.util.List<jkt.hrms.recruitment.masters.business.RequestStatusMaster> findAll(
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
	public java.util.List<jkt.hrms.recruitment.masters.business.RequestStatusMaster> findAll(
			Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

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
			jkt.hrms.recruitment.masters.business.RequestStatusMaster requestStatusMaster) {
		return (java.lang.Integer) super.save(requestStatusMaster);
	}

	/**
	 * Persist the given transient instance, first assigning a generated
	 * identifier. (Or using the current value of the identifier property if the
	 * assigned generator is used.) Use the Session given.
	 * 
	 * @param requestStatusMaster
	 *            a transient instance of a persistent class
	 * @param s
	 *            the Session
	 * @return the class identifier
	 */
	public java.lang.Integer save(
			jkt.hrms.recruitment.masters.business.RequestStatusMaster requestStatusMaster,
			Session s) {
		return (java.lang.Integer) save((Object) requestStatusMaster, s);
	}

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
			jkt.hrms.recruitment.masters.business.RequestStatusMaster requestStatusMaster) {
		saveOrUpdate((Object) requestStatusMaster);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of
	 * its identifier property. By default the instance is always saved. This
	 * behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. Use the Session given.
	 * 
	 * @param requestStatusMaster
	 *            a transient instance containing new or updated state.
	 * @param s
	 *            the Session.
	 */
	public void saveOrUpdate(
			jkt.hrms.recruitment.masters.business.RequestStatusMaster requestStatusMaster,
			Session s) {
		saveOrUpdate((Object) requestStatusMaster, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An
	 * exception is thrown if there is a persistent instance with the same
	 * identifier in the current session.
	 * 
	 * @param requestStatusMaster
	 *            a transient instance containing updated state
	 */
	public void update(
			jkt.hrms.recruitment.masters.business.RequestStatusMaster requestStatusMaster) {
		update((Object) requestStatusMaster);
	}

	/**
	 * Update the persistent state associated with the given identifier. An
	 * exception is thrown if there is a persistent instance with the same
	 * identifier in the current session. Use the Session given.
	 * 
	 * @param requestStatusMaster
	 *            a transient instance containing updated state
	 * @param the
	 *            Session
	 */
	public void update(
			jkt.hrms.recruitment.masters.business.RequestStatusMaster requestStatusMaster,
			Session s) {
		update((Object) requestStatusMaster, s);
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
	 * @param requestStatusMaster
	 *            the instance to be removed
	 */
	public void delete(
			jkt.hrms.recruitment.masters.business.RequestStatusMaster requestStatusMaster) {
		delete((Object) requestStatusMaster);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an
	 * instance associated with the receiving Session or a transient instance
	 * with an identifier associated with existing persistent state. Use the
	 * Session given.
	 * 
	 * @param requestStatusMaster
	 *            the instance to be removed
	 * @param s
	 *            the Session
	 */
	public void delete(
			jkt.hrms.recruitment.masters.business.RequestStatusMaster requestStatusMaster,
			Session s) {
		delete((Object) requestStatusMaster, s);
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
			jkt.hrms.recruitment.masters.business.RequestStatusMaster requestStatusMaster,
			Session s) {
		refresh((Object) requestStatusMaster, s);
	}

}