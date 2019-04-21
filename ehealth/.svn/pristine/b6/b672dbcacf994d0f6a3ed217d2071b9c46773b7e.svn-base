package jkt.hms.masters.business.base;

import jkt.hms.masters.business.dao.DrugdetailsDAO;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseDrugdetailsDAO extends jkt.hms.masters.business.dao._RootDAO {

	// query name references


	public static DrugdetailsDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static DrugdetailsDAO getInstance () {
		if (null == instance) instance = new DrugdetailsDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return jkt.hms.masters.business.Drugdetails.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a jkt.hms.masters.business.Drugdetails
	 */
	public jkt.hms.masters.business.Drugdetails cast (Object object) {
		return (jkt.hms.masters.business.Drugdetails) object;
	}

	public jkt.hms.masters.business.Drugdetails get(java.lang.String key)
		throws HibernateException {
		return (jkt.hms.masters.business.Drugdetails) get(getReferenceClass(), key);
	}

	public jkt.hms.masters.business.Drugdetails get(java.lang.String key, Session s)
		throws HibernateException {
		return (jkt.hms.masters.business.Drugdetails) get(getReferenceClass(), key, s);
	}

	public jkt.hms.masters.business.Drugdetails load(java.lang.String key)
		throws HibernateException {
		return (jkt.hms.masters.business.Drugdetails) load(getReferenceClass(), key);
	}

	public jkt.hms.masters.business.Drugdetails load(java.lang.String key, Session s)
		throws HibernateException {
		return (jkt.hms.masters.business.Drugdetails) load(getReferenceClass(), key, s);
	}

	public jkt.hms.masters.business.Drugdetails loadInitialize(java.lang.String key, Session s) 
			throws HibernateException { 
		jkt.hms.masters.business.Drugdetails obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}


	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param drugdetails a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.String save(jkt.hms.masters.business.Drugdetails drugdetails)
		throws HibernateException {
		return (java.lang.String) super.save(drugdetails);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param drugdetails a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.String save(jkt.hms.masters.business.Drugdetails drugdetails, Session s)
		throws HibernateException {
		return (java.lang.String) save((Object) drugdetails, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param drugdetails a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(jkt.hms.masters.business.Drugdetails drugdetails)
		throws HibernateException {
		saveOrUpdate((Object) drugdetails);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param drugdetails a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(jkt.hms.masters.business.Drugdetails drugdetails, Session s)
		throws HibernateException {
		saveOrUpdate((Object) drugdetails, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param drugdetails a transient instance containing updated state
	 */
	public void update(jkt.hms.masters.business.Drugdetails drugdetails) 
		throws HibernateException {
		update((Object) drugdetails);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param drugdetails a transient instance containing updated state
	 * @param the Session
	 */
	public void update(jkt.hms.masters.business.Drugdetails drugdetails, Session s)
		throws HibernateException {
		update((Object) drugdetails, s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(java.lang.String id)
		throws HibernateException {
		delete((Object) load(id));
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param id the instance ID to be removed
	 * @param s the Session
	 */
	public void delete(java.lang.String id, Session s)
		throws HibernateException {
		delete((Object) load(id, s), s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param drugdetails the instance to be removed
	 */
	public void delete(jkt.hms.masters.business.Drugdetails drugdetails)
		throws HibernateException {
		delete((Object) drugdetails);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param drugdetails the instance to be removed
	 * @param s the Session
	 */
	public void delete(jkt.hms.masters.business.Drugdetails drugdetails, Session s)
		throws HibernateException {
		delete((Object) drugdetails, s);
	}
	
	/**
	 * Re-read the state of the given instance from the underlying database. It is inadvisable to use this to implement
	 * long-running sessions that span many business tasks. This method is, however, useful in certain special circumstances.
	 * For example 
	 * <ul> 
	 * <li>where a database trigger alters the object state upon insert or update</li>
	 * <li>after executing direct SQL (eg. a mass update) in the same session</li>
	 * <li>after inserting a Blob or Clob</li>
	 * </ul>
	 */
	public void refresh (jkt.hms.masters.business.Drugdetails drugdetails, Session s)
		throws HibernateException {
		refresh((Object) drugdetails, s);
	}


}