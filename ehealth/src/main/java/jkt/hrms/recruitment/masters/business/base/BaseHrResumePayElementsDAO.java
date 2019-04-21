package jkt.hrms.recruitment.masters.business.base;

import jkt.hrms.recruitment.masters.business.dao.iface.HrResumePayElementsDAO;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseHrResumePayElementsDAO extends
		jkt.hrms.recruitment.masters.business.dao._RootDAO {

	public BaseHrResumePayElementsDAO() {
	}

	public BaseHrResumePayElementsDAO(Session session) {
		super(session);
	}

	// query name references

	public static HrResumePayElementsDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static HrResumePayElementsDAO getInstance() {
		if (null == instance) {
			instance = new jkt.hrms.recruitment.masters.business.dao.HrResumePayElementsDAO();
		}
		return instance;
	}

	public Class getReferenceClass() {
		return jkt.hrms.recruitment.masters.business.HrResumePayElements.class;
	}

	public Order getDefaultOrder() {
		return null;
	}

	/**
	 * Cast the object as a
	 * jkt.hrms.recruitment.masters.business.HrResumePayElements
	 */
	public jkt.hrms.recruitment.masters.business.HrResumePayElements cast(
			Object object) {
		return (jkt.hrms.recruitment.masters.business.HrResumePayElements) object;
	}

	public jkt.hrms.recruitment.masters.business.HrResumePayElements get(
			java.lang.Integer key) {
		return (jkt.hrms.recruitment.masters.business.HrResumePayElements) get(
				getReferenceClass(), key);
	}

	public jkt.hrms.recruitment.masters.business.HrResumePayElements get(
			java.lang.Integer key, Session s) {
		return (jkt.hrms.recruitment.masters.business.HrResumePayElements) get(
				getReferenceClass(), key, s);
	}

	public jkt.hrms.recruitment.masters.business.HrResumePayElements load(
			java.lang.Integer key) {
		return (jkt.hrms.recruitment.masters.business.HrResumePayElements) load(
				getReferenceClass(), key);
	}

	public jkt.hrms.recruitment.masters.business.HrResumePayElements load(
			java.lang.Integer key, Session s) {
		return (jkt.hrms.recruitment.masters.business.HrResumePayElements) load(
				getReferenceClass(), key, s);
	}

	public jkt.hrms.recruitment.masters.business.HrResumePayElements loadInitialize(
			java.lang.Integer key, Session s) {
		jkt.hrms.recruitment.masters.business.HrResumePayElements obj = load(
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
	public java.util.List<jkt.hrms.recruitment.masters.business.HrResumePayElements> findAll() {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no
	 * filter.
	 */
	public java.util.List<jkt.hrms.recruitment.masters.business.HrResumePayElements> findAll(
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
	public java.util.List<jkt.hrms.recruitment.masters.business.HrResumePayElements> findAll(
			Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated
	 * identifier. (Or using the current value of the identifier property if the
	 * assigned generator is used.)
	 * 
	 * @param hrResumePayElements
	 *            a transient instance of a persistent class
	 * @return the class identifier
	 */
	public java.lang.Integer save(
			jkt.hrms.recruitment.masters.business.HrResumePayElements hrResumePayElements) {
		return (java.lang.Integer) super.save(hrResumePayElements);
	}

	/**
	 * Persist the given transient instance, first assigning a generated
	 * identifier. (Or using the current value of the identifier property if the
	 * assigned generator is used.) Use the Session given.
	 * 
	 * @param hrResumePayElements
	 *            a transient instance of a persistent class
	 * @param s
	 *            the Session
	 * @return the class identifier
	 */
	public java.lang.Integer save(
			jkt.hrms.recruitment.masters.business.HrResumePayElements hrResumePayElements,
			Session s) {
		return (java.lang.Integer) save((Object) hrResumePayElements, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of
	 * its identifier property. By default the instance is always saved. This
	 * behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping.
	 * 
	 * @param hrResumePayElements
	 *            a transient instance containing new or updated state
	 */
	public void saveOrUpdate(
			jkt.hrms.recruitment.masters.business.HrResumePayElements hrResumePayElements) {
		saveOrUpdate((Object) hrResumePayElements);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of
	 * its identifier property. By default the instance is always saved. This
	 * behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. Use the Session given.
	 * 
	 * @param hrResumePayElements
	 *            a transient instance containing new or updated state.
	 * @param s
	 *            the Session.
	 */
	public void saveOrUpdate(
			jkt.hrms.recruitment.masters.business.HrResumePayElements hrResumePayElements,
			Session s) {
		saveOrUpdate((Object) hrResumePayElements, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An
	 * exception is thrown if there is a persistent instance with the same
	 * identifier in the current session.
	 * 
	 * @param hrResumePayElements
	 *            a transient instance containing updated state
	 */
	public void update(
			jkt.hrms.recruitment.masters.business.HrResumePayElements hrResumePayElements) {
		update((Object) hrResumePayElements);
	}

	/**
	 * Update the persistent state associated with the given identifier. An
	 * exception is thrown if there is a persistent instance with the same
	 * identifier in the current session. Use the Session given.
	 * 
	 * @param hrResumePayElements
	 *            a transient instance containing updated state
	 * @param the
	 *            Session
	 */
	public void update(
			jkt.hrms.recruitment.masters.business.HrResumePayElements hrResumePayElements,
			Session s) {
		update((Object) hrResumePayElements, s);
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
	 * @param hrResumePayElements
	 *            the instance to be removed
	 */
	public void delete(
			jkt.hrms.recruitment.masters.business.HrResumePayElements hrResumePayElements) {
		delete((Object) hrResumePayElements);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an
	 * instance associated with the receiving Session or a transient instance
	 * with an identifier associated with existing persistent state. Use the
	 * Session given.
	 * 
	 * @param hrResumePayElements
	 *            the instance to be removed
	 * @param s
	 *            the Session
	 */
	public void delete(
			jkt.hrms.recruitment.masters.business.HrResumePayElements hrResumePayElements,
			Session s) {
		delete((Object) hrResumePayElements, s);
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
			jkt.hrms.recruitment.masters.business.HrResumePayElements hrResumePayElements,
			Session s) {
		refresh((Object) hrResumePayElements, s);
	}

}