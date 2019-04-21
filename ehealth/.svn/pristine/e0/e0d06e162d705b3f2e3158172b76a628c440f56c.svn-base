package jkt.hms.masters.business.base;

import jkt.hms.masters.business.dao.ViewDataDAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseViewDataDAO extends jkt.hms.masters.business.dao._RootDAO {

	// query name references


	public static ViewDataDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static ViewDataDAO getInstance () {
		if (null == instance) instance = new ViewDataDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return jkt.hms.masters.business.ViewData.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a jkt.hms.masters.business.ViewData
	 */
	public jkt.hms.masters.business.ViewData cast (Object object) {
		return (jkt.hms.masters.business.ViewData) object;
	}




	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param viewData a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(jkt.hms.masters.business.ViewData viewData)
		throws HibernateException {
		saveOrUpdate((Object) viewData);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param viewData a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(jkt.hms.masters.business.ViewData viewData, Session s)
		throws HibernateException {
		saveOrUpdate((Object) viewData, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param viewData a transient instance containing updated state
	 */
	public void update(jkt.hms.masters.business.ViewData viewData) 
		throws HibernateException {
		update((Object) viewData);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param viewData a transient instance containing updated state
	 * @param the Session
	 */
	public void update(jkt.hms.masters.business.ViewData viewData, Session s)
		throws HibernateException {
		update((Object) viewData, s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param viewData the instance to be removed
	 */
	public void delete(jkt.hms.masters.business.ViewData viewData)
		throws HibernateException {
		delete((Object) viewData);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param viewData the instance to be removed
	 * @param s the Session
	 */
	public void delete(jkt.hms.masters.business.ViewData viewData, Session s)
		throws HibernateException {
		delete((Object) viewData, s);
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
	public void refresh (jkt.hms.masters.business.ViewData viewData, Session s)
		throws HibernateException {
		refresh((Object) viewData, s);
	}


}