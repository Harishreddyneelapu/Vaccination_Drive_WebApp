package com.tap.vaccine.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.entity.RegisterEntity;
@Component
public class LoginDAOImpl implements LoginDAO {
	private SessionFactory sessionFactory;

	@Autowired
	public LoginDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	

	public LoginDAOImpl() {
		super();

	}



	public RegisterEntity getEntityByEmail(String email) {
		System.out.println("invoked getEntityByEmail()");
		Session session = null;
		RegisterEntity entity = null;
		String hql = "from RegisterEntity where email=:email";
		try {
			session = this.sessionFactory.openSession();
			entity = session.createQuery(hql,RegisterEntity.class).setParameter("email", email).uniqueResult();
			if(entity!=null) {
				return entity;
			}
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		return entity;
	}



	public boolean updateRegisterEntity(int id, int loginAttempts) {
		Session session=null;
		try {
			session = this.sessionFactory.openSession();
			session.beginTransaction();
			session.get(RegisterEntity.class,id).setLoginAttempts(loginAttempts);
			session.getTransaction().commit();
			return true;
		}finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			}
		}
	}

}
