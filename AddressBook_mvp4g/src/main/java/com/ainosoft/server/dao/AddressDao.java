package com.ainosoft.server.dao;

// Generated 12 Mar, 2015 10:53:22 AM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ainosoft.server.dao.domain.Address;
import com.ainosoft.server.util.HibernateUtil;

/**
 * Home object for domain model class AddressTable.
 * @see com.ainosoft.server.dao.Address
 * @author Hibernate Tools
 */
public class AddressDao {

	private Session session;
	
	//private Logger logger = Logger.getLogger(this.getClass().getName());	
	
	public void saveAddress(Address transientInstance) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.persist(transientInstance);
			session.getTransaction().commit();
		} catch (RuntimeException re) {			
			throw re;
		}finally{
			if(session != null){
				session.close();
			}
		}
	}

	

	public void deleteAddress(Address persistentInstance) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(persistentInstance);
			session.getTransaction().commit();
		} catch (RuntimeException re) {			
			throw re;
		}finally{
			if(session != null){
				session.close();
			}
		}
	}

	public void updateAddress(Address persistentInstance) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(persistentInstance);
			session.getTransaction().commit();
		} catch (RuntimeException re) {			
			throw re;
		}finally{
			if(session != null){
				session.close();
			}
		}
	}

	public Address findById(long id) {
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Address instance = (Address) session.get(Address.class, id);
			if (instance == null) {
				//logger.log(Level.WARNING,"Instance not found with Id "+id);
			} else {
				//logger.log(Level.WARNING,"Instance found with Id "+id);
			}
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}finally{
			if(session != null){
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<Address> getAddressList(){
		List<Address> addrList = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			Query q = session.createQuery("From Address");
			addrList = q.list();
		}catch (RuntimeException re) {
			throw re;
		}finally{
			if(session != null){
				session.close();
			}
		}
		
		return addrList;
		
	}
	
}
