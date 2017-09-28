package org.appops.exploration.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author vedang@ainosoft.com
 * @Responisibility :
 * @CreatedOn : 28-Sep-2017
 */
public class HibernateUtil {
	private static SessionFactory	sessionFactory;
	private static Logger			logger			= Logger.getLogger(HibernateUtil.class.getName());
	private static Configuration	configuration	= null;

	static {
		try {
			HibernateUtil.configuration = new Configuration().configure("./hibernate.cfg.xml");
		} catch (final Throwable ex) {
			HibernateUtil.logger.log(Level.SEVERE, "[HibernateUtil] Exception In static block", ex);
		}
	}

	public static Configuration getConfiguration() {
		return HibernateUtil.configuration;
	}

	public static SessionFactory getSessionFactory() {

		if (HibernateUtil.sessionFactory != null)
			return HibernateUtil.sessionFactory;

		HibernateUtil.sessionFactory = HibernateUtil.configuration.buildSessionFactory();

		return HibernateUtil.sessionFactory;
	}
}
