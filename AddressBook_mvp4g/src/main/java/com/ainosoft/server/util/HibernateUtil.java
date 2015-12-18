package com.ainosoft.server.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static Configuration config;
	private static Logger logger = Logger.getLogger(HibernateUtil.class.getName());

	static {
		try {
			config = new Configuration().configure("/com/ainosoft/server/addressBookHibernate.cfg.xml");
		} catch (final Throwable th) {
			logger.log(Level.SEVERE, "from HibernateUtil", th);
		}
	}

	public static SessionFactory getSessionFactory() {
		if (HibernateUtil.sessionFactory != null)
			return sessionFactory;
		else {
			sessionFactory = HibernateUtil.config.buildSessionFactory();
			return sessionFactory;
		}
	}
}

