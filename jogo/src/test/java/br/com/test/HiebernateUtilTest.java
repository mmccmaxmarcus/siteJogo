package br.com.test;

import org.hibernate.Session;
import org.junit.Test;

import br.com.HibernateUtil.HibernateUtil;

public class HiebernateUtilTest {
     
	@Test
	public void conecta() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.close();
		HibernateUtil.getSessionFactory().close();
		
	}
}

