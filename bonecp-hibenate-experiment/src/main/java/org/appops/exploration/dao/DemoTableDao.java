package org.appops.exploration.dao;
// Generated 28 Sep, 2017 11:51:53 AM by Hibernate Tools 5.2.5.Final

import java.util.logging.Level;
import java.util.logging.Logger;

import org.appops.exploration.dao.domain.DemoTable;
import org.appops.exploration.util.HibernateUtil;
import org.hibernate.Session;

/**
 * Home object for domain model class DemoTable.
 * 
 * @see org.appops.exploration.dao.DemoTable
 * @author Hibernate Tools
 */
public class DemoTableDao {

	private Logger logger = Logger.getLogger(this.getClass().getCanonicalName());

	public DemoTable persist(DemoTable transientInstance) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			int id = (int) session.save(transientInstance);
			session.getTransaction().commit();
			transientInstance.setId(id);
			return transientInstance;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean delete(DemoTable persistentInstance) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(persistentInstance);
			session.getTransaction().commit();
			return true;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public DemoTable findById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			DemoTable instance = (DemoTable) session.get(DemoTable.class, id);
			if (instance == null) {
				logger.log(Level.INFO, "get successful, no instance found");
			} else {
				logger.log(Level.INFO, "get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
